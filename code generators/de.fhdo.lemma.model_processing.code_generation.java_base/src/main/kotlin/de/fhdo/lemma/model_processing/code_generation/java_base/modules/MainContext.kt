package de.fhdo.lemma.model_processing.code_generation.java_base.modules

import com.github.javaparser.ast.Node
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.commandline.CommandLine
import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyDescription
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.DependencyFragmentProviderI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEvent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.findAspectHandlers
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.findCodeGenerationHandlers
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.findDependencyFragmentProviders
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.loadGenlets
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.buildAspectHandlerQualifiedName
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.findAspectHandlers
import de.fhdo.lemma.model_processing.code_generation.java_base.eObjectPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.AbstractGenlet
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEventType
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.LineCountInfo
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation.CodeGenerationSerializerI
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.configuration.AbstractSerializationConfiguration
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.DependencySerializerI
import de.fhdo.lemma.model_processing.utils.mainInterface
import de.fhdo.lemma.model_processing.utils.modelRoot
import de.fhdo.lemma.model_processing.utils.packageToPath
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.io.File
import java.net.URLClassLoader
import java.nio.charset.Charset
import kotlin.reflect.KProperty

/**
 * Represents the context for the main code generation module. The context provides state handling for the module and
 * module-specific helpers.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object MainContext {
    /* State object of the context */
    object State : KoinComponent {
        private val serializationConfiguration: AbstractSerializationConfiguration by inject()
        private val codeGenerationSerializer: CodeGenerationSerializerI by inject()
        private val dependencySerializer: DependencySerializerI<*, *> by inject()

        private val collectedDependencies = mutableSetOf<DependencyDescription>()
        private val aspectHandlers = mutableMapOf<AbstractGenlet?, Map<String, Class<AspectHandlerI>>>()
        private val genletCodeGenerationHandlers
            = mutableMapOf<AbstractGenlet, Map<String, Set<Class<GenletCodeGenerationHandlerI<EObject, Node, Any>>>>>()
        private val dependencyFragmentProviders
            = mutableMapOf<AbstractGenlet, List<Class<DependencyFragmentProviderI<Any, Any>>>>()
        private val generatedFileContents = mutableMapOf<String, Pair<String, Charset>>()
        private val generatedLineCountInfo = mutableSetOf<LineCountInfo>()

        private lateinit var intermediateServiceModelFilePath: String
        private lateinit var intermediateServiceModel: IntermediateServiceModel
        private lateinit var intermediateServiceModelForDomainModels: IntermediateServiceModel
        private lateinit var targetFolderPath: String
        private var lineCountInfoFilePath: String? = null
        private lateinit var genlets: Map<AbstractGenlet, URLClassLoader>
        private lateinit var currentMicroservicePackage: String

        lateinit var currentMicroservice: IntermediateMicroservice
            private set

        /**
         * Initialize the state of the context
         */
        fun initialize(
            intermediateServiceModelFilePath: String,
            intermediateServiceModelResource: Resource,
            intermediateServiceModelResourceForDomainModels: Resource,
            targetFolderPath: String,
            lineCountInfoFilePath: String? = null
        ) {
            this.intermediateServiceModelFilePath = intermediateServiceModelFilePath
            intermediateServiceModel = intermediateServiceModelResource.modelRoot()
            intermediateServiceModelForDomainModels = intermediateServiceModelResourceForDomainModels.modelRoot()
            this.targetFolderPath = targetFolderPath.trimEnd(File.separatorChar)
            this.lineCountInfoFilePath = lineCountInfoFilePath

            findLocalAspectHandlers()
            loadGenlets()
        }

        /**
         * Initialize the state of the context with the current microservice package instead of intermediate service
         * model information
         */
        fun initialize(currentMicroservicePackage: String, targetFolderPath: String,
            lineCountInfoFilePath: String? = null) {
            this.currentMicroservicePackage = currentMicroservicePackage
            this.targetFolderPath = targetFolderPath.trimEnd(File.separatorChar)
            this.lineCountInfoFilePath = lineCountInfoFilePath

            findLocalAspectHandlers()
            loadGenlets()
        }

        /**
         * Set the state's current microservice
         */
        fun setCurrentMicroservice(microservice : IntermediateMicroservice) {
            currentMicroservice = microservice
            currentMicroservicePackage = microservice.eObjectPackageName
        }

        /**
         * Helper to find aspect handlers of the Java base generator itself
         */
        private fun findLocalAspectHandlers() {
            aspectHandlers[null] = findAspectHandlers("${MainCodeGenerationModule::class.java.packageName}.common" +
                ".aspects.handlers")
        }

        /**
         * Helper to load Genlets together with their code generation handlers, aspect handlers, and dependency fragment
         * providers
         */
        private fun loadGenlets() {
            genlets = loadGenlets(CommandLine.genlets())
            genlets.forEach { (genlet, classLoader) -> with(genlet) {
                genletCodeGenerationHandlers[this] = findCodeGenerationHandlers(classLoader)
                aspectHandlers[this] = findAspectHandlers(classLoader)
                dependencyFragmentProviders[this] = findDependencyFragmentProviders(classLoader, dependencySerializer)
            } }
            sendEventToGenlets(GenletEvent(GenletEventType.GENLET_LOADED))
        }

        /**
         * Provide delegated property values back to callers
         */
        @Suppress("IMPLICIT_CAST_TO_ANY", "UNCHECKED_CAST")
        operator fun <T: Any> getValue(thisRef: Any?, property: KProperty<*>) : T {
            val value = when(property.name) {
                "aspectHandlers" -> aspectHandlers.toMap()
                "collectedDependencies" -> collectedDependencies.toSet()
                "currentMicroservicePackage" -> currentMicroservicePackage
                "currentMicroserviceTargetFolderPath" -> currentMicroserviceTargetFolderPath()
                "currentMicroserviceTargetFolderPathForJavaFiles" -> currentMicroserviceTargetFolderPathForJavaFiles()
                "currentMicroserviceTargetFolderPathForResourceFiles" ->
                    currentMicroserviceTargetFolderPathForResourceFiles()
                "dependencyFragmentProviderInstances" -> dependencyFragmentProviderInstances()
                "generatedFileContents" -> generatedFileContents.toMap()
                "generatedLineCountInfo" -> generatedLineCountInfo.toList()
                "genletCodeGenerationHandlers" -> genletCodeGenerationHandlers.toMap()
                "genlets" -> genlets.keys
                "intermediateServiceModelFilePath" -> intermediateServiceModelFilePath
                "intermediateServiceModel" -> intermediateServiceModel
                "intermediateServiceModelForDomainModels" -> intermediateServiceModelForDomainModels
                "lineCountInfoFilePath" -> lineCountInfoFilePath
                "writeLineCountInfo" -> lineCountInfoFilePath != null
                "codeGenerationSerializer" -> codeGenerationSerializer
                "serializationConfiguration" -> serializationConfiguration
                else -> throw IllegalArgumentException("Main state does not comprise property ${property.name}")
            }

            return value as T
        }

        /**
         * Helper to calculate the target folder path of the state's [currentMicroservicePackage]
         */
        private fun currentMicroserviceTargetFolderPath() : String {
            val microservicePackageFolderPath = currentMicroservicePackage.packageToPath()
            return "$targetFolderPath${File.separator}$microservicePackageFolderPath"
        }

        /**
         * Helper to calculate the target folder path for Java files of the state's [currentMicroservicePackage]
         */
        private fun currentMicroserviceTargetFolderPathForJavaFiles() : String {
            val microservicePackageFolderPath = currentMicroservicePackage.packageToPath()

            return listOf(
                targetFolderPath,
                microservicePackageFolderPath,
                "src", "main", "java",
                microservicePackageFolderPath
            ).joinToString(File.separator)
        }

        /**
         * Helper to calculate the target folder path for resource files of the state's [currentMicroservicePackage]
         */
        private fun currentMicroserviceTargetFolderPathForResourceFiles() : String {
            val microservicePackageFolderPath = currentMicroservicePackage.packageToPath()

            return listOf(
                targetFolderPath,
                microservicePackageFolderPath,
                "src", "main", "resources"
            ).joinToString(File.separator)
        }

        /**
         * Helper to create a list of [DependencyFragmentProviderI] instances from the list of collected dependency
         * fragment providers
         */
        private fun dependencyFragmentProviderInstances() = dependencyFragmentProviders.values.flatten()
            .map { it.getConstructor().newInstance() }

        /**
         * Add a dependency to the set of collected dependencies during the current code generation run
         */
        fun addDependency(dependencyDescription : DependencyDescription)
            = collectedDependencies.add(dependencyDescription)

        /**
         * Clear the set of collected dependencies. This should happen at the end of the current code generation run and
         * when the dependencies were serialized.
         */
        fun clearCollectedDependencies() = collectedDependencies.clear()

        /**
         * Add content of a generated file to the set of collected generated file contents
         */
        fun addGeneratedFileContent(content: String, targetFilePath: String) {
            generatedFileContents[targetFilePath] = content to serializationConfiguration.charset
        }

        /**
         * Add a [LineCountInfo] object to the set of line count information generated during the current code
         * generation run
         */
        fun addOrUpdateGeneratedLineCountInfo(lineCountInfo: LineCountInfo) {
            val infoAlreadyExists = !generatedLineCountInfo.add(lineCountInfo)
            if (infoAlreadyExists) {
                generatedLineCountInfo.remove(lineCountInfo)
                generatedLineCountInfo.add(lineCountInfo)
            }
        }
    }

    /**
     * Helper to invoke all aspect handlers for the given [EObject], [Node], and [IntermediateImportedAspect] instances.
     * This may either happen for aspect handlers of the Java base generator itself (parameter [genlet] is null) or for
     * aspect handlers within a certain [AbstractGenlet] (parameter [genlet] set to the respective [AbstractGenlet]
     * instance).
     */
    internal fun invokeAspectHandlers(eObject: EObject, node: Node, aspects: List<IntermediateImportedAspect>,
        genlet: AbstractGenlet?) : Node {
        val aspectHandlers: Map<AbstractGenlet?, Map<String, Class<AspectHandlerI>>> by State
        val aspectHandlersForGenlet = aspectHandlers[genlet] ?: return node
        var adaptedNode = node
        for (aspect in aspects) {
            // Note that we use the original node instance (not the adapted one), because aspect handlers must not
            // change the runtime type of a node
            val handlerQualifiedName = buildAspectHandlerQualifiedName(eObject, node, aspect)
            val handlerClass = aspectHandlersForGenlet[handlerQualifiedName] ?: continue
            val handler = handlerClass.getConstructor().newInstance()
            adaptedNode = handler.execute(eObject, node, aspect)
            check(adaptedNode == node) { "Aspect handler for aspect $aspect did not return the same Node instance " +
                "for EObject type ${eObject::class.java.name} and input Node type ${node::class.java.name}" }
        }
        return adaptedNode
    }

    /**
     * Convenience function to wrap the invocation of local aspect handlers. Note, that we do not set the "genlet"
     * parameter of [invokeAspectHandlers] to null by default, because we want to force callers to consciously decide
     * whether the want to invoke local or [AbstractGenlet]-specific aspect handlers.
     */
    internal fun invokeLocalAspectHandlers(eObject: EObject, node: Node, aspects: List<IntermediateImportedAspect>)
        = invokeAspectHandlers(eObject, node, aspects, null)

    /**
     * Get all code generation handlers for the [EObject] within the given [AbstractGenlet]
     */
    internal fun getGenletCodeGenerationHandlers(eObject: EObject, genlet: AbstractGenlet)
        : Set<Class<GenletCodeGenerationHandlerI<EObject, Node, Any>>> {
        val genletCodeGenerationHandlers:
            Map<AbstractGenlet, Map<String, Set<Class<GenletCodeGenerationHandlerI<EObject, Node, Any>>>>> by State
        return genletCodeGenerationHandlers[genlet]?.get(eObject.mainInterface.name) ?: emptySet()
    }

    /**
     * Helper to invoke a [AbstractGenlet]-specific code generation handler on a given [EObject] and [Node] instance
     */
    internal fun invokeGenletCodeGenerationHandler(eObject: EObject, node: Node, context: Any?,
        handlerClass: Class<GenletCodeGenerationHandlerI<EObject, Node, Any>>)
        : GenletCodeGenerationHandlerResult<Node> {
        val handlerInstance = handlerClass.getConstructor().newInstance()
        if (!handlerInstance.generatesNodesOfInstance().isAssignableFrom(node::class.java))
            return GenletCodeGenerationHandlerResult(node)

        return handlerInstance.execute(eObject, node, context) ?: GenletCodeGenerationHandlerResult(node)
    }

    /**
     * Send an event to all known Genlets
     */
    internal fun sendEventToGenlets(event: GenletEvent) {
        val genlets: Set<AbstractGenlet> by State
        genlets.forEach { it.sendEvent(event) }
    }
}