package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services

import com.github.javaparser.ast.Node
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.VisitingCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.findCodeGenerationHandlers
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainCodeGenerationModule
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.ServicesContext.State.visitingServicesCodeGenerationHandlers
import de.fhdo.lemma.model_processing.code_generation.java_base.simpleName
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext.State as MainState
import de.fhdo.lemma.model_processing.utils.mainInterface
import org.eclipse.emf.ecore.EObject
import java.io.File
import java.lang.IllegalArgumentException
import kotlin.reflect.KProperty

/**
 * Represents the context for the [ServicesCodeGenerationSubModule]. The context provides state handling for the sub-
 * module and sub-module-specific helpers.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object ServicesContext {
    /* State object of the context */
    object State {
        private const val SERVICE_SUBFOLDER_NAME = "service"
        private const val INTERFACE_SUBFOLDER_NAME = "interfaces"

        internal lateinit var visitingServicesCodeGenerationHandlers
            : Map<String, Set<Class<VisitingCodeGenerationHandlerI<EObject, Node, Any>>>>

        /**
         * Initialize the state of the context
         */
        fun initialize() {
            visitingServicesCodeGenerationHandlers = findCodeGenerationHandlers(
                "${MainCodeGenerationModule::class.java.packageName}.services.handlers"
            )
        }

        /**
         * Provide delegated property values for callers
         */
        @Suppress("IMPLICIT_CAST_TO_ANY", "UNCHECKED_CAST")
        operator fun <T: Any> getValue(thisRef: Any?, property: KProperty<*>) : T {
            val value = when(property.name) {
                "currentMicroserviceGenerationPackage" -> currentMicroserviceGenerationPackage()
                "currentMicroserviceGenerationTargetFolderPath" -> currentMicroserviceGenerationTargetFolderPath()
                "currentInterfacesGenerationPackage" -> currentInterfacesGenerationPackage()
                "currentInterfacesGenerationTargetFolderPath" -> currentInterfacesGenerationTargetFolderPath()
                "interfaceSubFolderName" -> INTERFACE_SUBFOLDER_NAME
                else -> throw IllegalArgumentException("Services' state does not comprise property ${property.name}")
            }

            return value as T
        }

        /**
         * Helper to build the package of the currently generated microservice
         */
        private fun currentMicroserviceGenerationPackage() : String {
            val currentMicroservicePackage: String by MainState
            return "$currentMicroservicePackage.${currentMicroserviceGenerationQualifiedNameFragment()}"
        }

        /**
         * Helper to build the generation target folder path of the currently generated microservice
         */
        private fun currentMicroserviceGenerationTargetFolderPath() : String {
            val currentMicroserviceTargetFolderPathForJavaFiles: String by MainState
            return "$currentMicroserviceTargetFolderPathForJavaFiles${File.separator}" +
                currentMicroserviceGenerationQualifiedNameFragment(File.separator)
        }

        /**
         * Helper to build the name fragment that qualifies the current microservice. It consists of the service's
         * name and version, preceded by the [SERVICE_SUBFOLDER_NAME]
         */
        private fun currentMicroserviceGenerationQualifiedNameFragment(separator: String = ".") : String {
            val currentMicroservice = MainState.currentMicroservice
            val microserviceVersion = currentMicroservice.version ?: ""
            val microserviceName = currentMicroservice.simpleName

            val fragmentParts = mutableListOf(SERVICE_SUBFOLDER_NAME)
            fragmentParts.add(microserviceName)
            if (microserviceVersion.isNotEmpty())
                fragmentParts.add(microserviceVersion)

            return fragmentParts.joinToString(separator)
        }

        /**
         * Helper to build the package of the currently generated interface
         */
        private fun currentInterfacesGenerationPackage()
            = "${currentMicroserviceGenerationPackage()}.$INTERFACE_SUBFOLDER_NAME"

        /**
         * Helper to build the generation target folder path of the currently generated interface
         */
        private fun currentInterfacesGenerationTargetFolderPath()
            ="${currentMicroserviceGenerationTargetFolderPath()}${File.separator}$INTERFACE_SUBFOLDER_NAME"
    }

    /**
     * Helper to invoke [VisitingCodeGenerationHandlerI] instances hold by the service [State] for service-specific
     * code generation purposes related to the specified [eObject]
     */
    internal fun invokeVisitingCodeGenerationHandlers(eObject: EObject) : List<Pair<Node, String?>> {
        val handlers = visitingServicesCodeGenerationHandlers[eObject.mainInterface.name] ?: return emptyList()
        val results = mutableListOf<Pair<Node, String?>>()
        handlers.forEach {
            val handlerResult = it.getConstructor().newInstance().invoke(eObject)
            if (handlerResult != null)
                results.add(handlerResult)
        }

        return results
    }
}