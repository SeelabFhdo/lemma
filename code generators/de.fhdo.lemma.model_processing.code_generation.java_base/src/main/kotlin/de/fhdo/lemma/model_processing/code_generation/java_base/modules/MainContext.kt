package de.fhdo.lemma.model_processing.code_generation.java_base.modules

import com.github.javaparser.ast.Node
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.commandline.CommandLine
import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyDescription
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.DependencyFragmentProviderI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.Genlet
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.findAspectHandlers
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.findCodeGenerationHandlers
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.findDependencyFragmentProviders
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.loadGenlets
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.buildAspectHandlerQualifiedName
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.findAspectHandlers
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.DependencySerializerI
import de.fhdo.lemma.model_processing.utils.mainInterface
import de.fhdo.lemma.model_processing.utils.modelRoot
import de.fhdo.lemma.model_processing.utils.packageToPath
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.io.File
import java.net.URLClassLoader
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
        lateinit var currentMicroservicePackage: String

        private lateinit var intermediateServiceModel: IntermediateServiceModel
        private lateinit var intermediateServiceModelForDomainModels: IntermediateServiceModel
        private lateinit var targetFolderPath: String
        private val collectedDependencies = mutableSetOf<DependencyDescription>()
        private lateinit var genlets: Map<Genlet, URLClassLoader>
        private val aspectHandlers = mutableMapOf<Genlet?, Map<String, Class<AspectHandlerI>>>()
        private val genletCodeGenerationHandlers
                = mutableMapOf<Genlet, Map<String, Class<GenletCodeGenerationHandlerI<EObject, Node, Any>>>>()
        private val dependencyFragmentProviders
            = mutableMapOf<Genlet, List<Class<DependencyFragmentProviderI<Any, Any>>>>()

        /**
         * Initialize the state of the context
         */
        fun initialize(intermediateServiceModelResource: Resource,
            intermediateServiceModelResourceForDomainModels: Resource, targetFolderPath: String) {
            intermediateServiceModel = intermediateServiceModelResource.modelRoot()
            intermediateServiceModelForDomainModels = intermediateServiceModelResourceForDomainModels.modelRoot()
            this.targetFolderPath = targetFolderPath.trimEnd(File.separatorChar)

            findLocalAspectHandlers()
            loadGenlets()
        }

        /**
         * Helper to find aspect handlers of the Java base generator itself
         */
        private fun findLocalAspectHandlers() {
            aspectHandlers[null] = findAspectHandlers("${MainModule::class.java.packageName}.common.aspects.handlers")
        }

        /**
         * Helper to load Genlets together with their code generation handlers, aspect handlers, and dependency fragment
         * providers
         */
        private fun loadGenlets() {
            val dependencySerializer: DependencySerializerI<*, *> by inject()
            genlets = loadGenlets(CommandLine.genlets())
            genlets.forEach { (genlet, classLoader) -> with(genlet) {
                genletCodeGenerationHandlers[this] = findCodeGenerationHandlers(classLoader)
                aspectHandlers[this] = findAspectHandlers(classLoader)
                dependencyFragmentProviders[this] = findDependencyFragmentProviders(classLoader, dependencySerializer)
            } }
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
                "dependencyFragmentProviderInstances" -> dependencyFragmentProviderInstances()
                "genletCodeGenerationHandlers" -> genletCodeGenerationHandlers.toMap()
                "genlets" -> genlets.keys
                "intermediateServiceModel" -> intermediateServiceModel
                "intermediateServiceModelForDomainModels" -> intermediateServiceModelForDomainModels
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
    }

    /**
     * Helper to invoke all aspect handlers for the given [EObject], [Node], and [IntermediateImportedAspect] instances.
     * This may either happen for aspect handlers of the Java base generator itself (parameter [genlet] is null) or for
     * aspect handlers within a certain [Genlet] (parameter [genlet] set to the respective [Genlet] instance).
     */
    internal fun invokeAspectHandlers(eObject: EObject, node: Node, aspects: List<IntermediateImportedAspect>,
        genlet: Genlet?) : Node {
        val aspectHandlers: Map<Genlet?, Map<String, Class<AspectHandlerI>>> by State
        val aspectHandlersForGenlet = aspectHandlers[genlet] ?: return node
        var adaptedNode = node
        for (aspect in aspects) {
            // Note that we use the original node instance (not the adapted one), because aspect handlers must not
            // change the runtime type of a node
            val handlerQualifiedName = buildAspectHandlerQualifiedName(eObject, node, aspect)
            val handler = aspectHandlersForGenlet[handlerQualifiedName] ?: continue
            adaptedNode = handler.getConstructor().newInstance().invoke(eObject, adaptedNode, aspect)
        }
        return adaptedNode
    }

    /**
     * Convenience function to wrap the invocation of local aspect handlers. Note, that we do not set the "genlet"
     * parameter of [invokeAspectHandlers] to null by default, because we want to force callers to consciously decide
     * whether the want to invoke local or [Genlet]-specific aspect handlers.
     */
    internal fun invokeLocalAspectHandlers(eObject: EObject, node: Node, aspects: List<IntermediateImportedAspect>)
        = invokeAspectHandlers(eObject, node, aspects, null)

    /**
     * Helper to invoke a [Genlet]-specific code generation handler on a given [EObject] and [Node] instance
     */
    internal fun invokeGenletCodeGenerationHandler(eObject: EObject, node: Node, genlet: Genlet) : Node {
        val genletCodeGenerationHandlers:
            Map<Genlet, Map<String, Class<GenletCodeGenerationHandlerI<EObject, Node, Any>>>> by State
        val handler = genletCodeGenerationHandlers[genlet]?.get(eObject.mainInterface.name) ?: return node
        return handler.getConstructor().newInstance().invoke(eObject, node = node) ?: return node
    }
}