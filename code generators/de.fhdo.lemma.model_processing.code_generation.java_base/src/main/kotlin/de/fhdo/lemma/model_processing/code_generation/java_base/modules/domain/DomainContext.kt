package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain

import com.github.javaparser.ast.Node
import de.fhdo.lemma.data.intermediate.IntermediateDataModel
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.VisitingCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.findCodeGenerationHandlers
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainCodeGenerationModule
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext.State.visitingDomainCodeGenerationHandlers
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext.State as MainState
import de.fhdo.lemma.model_processing.utils.loadModelRoot
import de.fhdo.lemma.model_processing.utils.mainInterface
import de.fhdo.lemma.model_processing.utils.removeFileUri
import org.eclipse.emf.ecore.EObject
import java.io.File
import java.lang.IllegalArgumentException
import kotlin.reflect.KProperty

/**
 * Represents the context for the [DomainCodeGenerationSubModule]. The context provides state handling for the sub-
 * module and sub-module-specific helpers.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object DomainContext {
    /* State object of the context */
    object State {
        private const val DOMAIN_SUBFOLDER_NAME = "domain"

        private lateinit var currentIntermediateDomainModelUri: String
        private lateinit var currentIntermediateDomainModelFilePath: String
        private var currentIntermediateDomainModel: IntermediateDataModel? = null
        internal lateinit var visitingDomainCodeGenerationHandlers
            : Map<String, Class<VisitingCodeGenerationHandlerI<EObject, Node, Any>>>

        /**
         * Initialize the state of the context
         */
        fun initialize() {
            visitingDomainCodeGenerationHandlers = findCodeGenerationHandlers(
                "${MainCodeGenerationModule::class.java.packageName}.domain.handlers"
            )
        }

        /**
         * Set the URI of the current intermediate domain model. Automatically updates the path of the model, too.
         */
        fun setCurrentIntermediateDomainModelUri(uri: String) {
            currentIntermediateDomainModelUri = uri
            currentIntermediateDomainModelFilePath = uri.removeFileUri()
        }

        /**
         * Provide delegated property values for callers
         */
        @Suppress("IMPLICIT_CAST_TO_ANY", "UNCHECKED_CAST")
        operator fun <T: Any> getValue(thisRef: Any?, property: KProperty<*>) : T {
            val value = when(property.name) {
                "currentDomainPackage" -> currentDomainPackage()
                "currentDomainTargetFolderPath" -> currentDomainTargetFolderPath()
                "currentIntermediateDomainModel" -> currentIntermediateDomainModel()
                "currentIntermediateDomainModelUri" -> currentIntermediateDomainModelUri
                "currentIntermediateDomainModelFilePath" -> currentIntermediateDomainModelFilePath
                else -> throw IllegalArgumentException("Domain state does not comprise property ${property.name}")
            }

            return value as T
        }

        /**
         * Helper to get the [IntermediateDataModel] instance from the state's [currentIntermediateDomainModelFilePath]
         */
        private fun currentIntermediateDomainModel() : IntermediateDataModel {
            if (currentIntermediateDomainModel == null)
                currentIntermediateDomainModel = loadModelRoot(currentIntermediateDomainModelFilePath)
            return currentIntermediateDomainModel!!
        }

        /**
         * Helper to calculate the base target folder path for the current domain code generation run. The path is the
         * base target folder of the current microservice code generation run (hold by the [MainState]) plus a
         * domain-specific sub-folder, currently called "domain".
         */
        private fun currentDomainTargetFolderPath() : String {
            val currentMicroserviceTargetFolderPathForJavaFiles: String by MainState
            return "$currentMicroserviceTargetFolderPathForJavaFiles${File.separator}$DOMAIN_SUBFOLDER_NAME"
        }

        /**
         * Helper to calculate the base package name for the current domain code generation run. This is the base
         * package name of the current microservice code generation run (hold by the [MainState]) plus a domain-specific
         * sub-package, currently called "domain".
         */
        private fun currentDomainPackage() : String {
            val currentMicroservicePackage: String by MainState
            return "$currentMicroservicePackage.$DOMAIN_SUBFOLDER_NAME"
        }
    }

    /**
     * Helper to invoke a [VisitingCodeGenerationHandlerI] instance hold by the domain [State] for domain-specific code
     * generation purposes
     */
    internal fun invokeVisitingCodeGenerationHandler(eObject: EObject) : Pair<Node, String?>? {
        val handler = visitingDomainCodeGenerationHandlers[eObject.mainInterface.name] ?: return null
        return handler.getConstructor().newInstance().invoke(eObject)
    }
}