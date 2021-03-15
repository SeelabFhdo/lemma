package de.fhdo.lemma.visualizer

import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.languages.registerLanguage
import de.fhdo.lemma.model_processing.loadXtextResource
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import de.fhdo.lemma.service.intermediate.MicroserviceReference
import de.fhdo.lemma.visualizer.languages.DATA_DSL_LANGUAGE_DESCRIPTION
import de.fhdo.lemma.visualizer.languages.SERVICE_DSL_LANGUAGE_DESCRIPTION
import org.eclipse.emf.ecore.EObject
import java.lang.IllegalArgumentException

/*
 * This file comprises multiple utility functions which are taken from the Java Base Code Generator written
 * by Florian Rademacher. The main purpose of the functions is to load the additional models during the code generation
 * phase.
 */

//TODO the sourcemodel uri points to a specific service model, i.e., test.services. The importUri used in
//TODO microservice references points to the intermediate files, i.e., test.xmi. To make everything work the visualizer
//TODO currently simply gets rid of the fileexentsion and simply uses "test" as prefix. However, this is not very secure
//TODO because it only works if the intermediate and the service file both have the same name.
/**
 * Builds and returns a fully qualified name of a given [IntermediateMicroservice] by adding its services filename from
 * the [this.sourceModelUri] as prefix to [this.qualifiedName].
 *
 * @author [Jonas Sorgalla](mailto:jonas.sorgalla@fh-dortmund.de)
 */
fun IntermediateMicroservice.fullyQualifiedName() : String {
    return this.sourceModelUri.asFile().nameWithoutExtension+"::"+this.qualifiedName
}

/**
 * Builds and returns a fully qualified name of a given [IntermediateMicroservice] by adding its xmi filename from
 * the [this.sourceModelUri] as prefix to [this.qualifiedName].
 *
 * @author [Jonas Sorgalla](mailto:jonas.sorgalla@fh-dortmund.de)
 */
fun MicroserviceReference.fullyQualifiedName(): String {
    return this.import.importUri.removeRange(0, 7).asFile().nameWithoutExtension+"::"+this.qualifiedName
}

/**
* Load the root of the model file at the given [modelFilePath], which must point to an Xtext resource.
     *
     * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
     */
    @Suppress("UNCHECKED_CAST")
    fun <T: EObject> loadOriginalModelRoot(modelFilePath: String) : T {
        val alreadyLoadedModelRoot = loadedOriginalModelRootsCache[modelFilePath]
        if (alreadyLoadedModelRoot != null)
            return alreadyLoadedModelRoot as T

        val modelFile = modelFilePath.asFile()
        val languageSetup = when (modelFile.extension) {
            "data" -> {
                registerDataDsl()
                DATA_DSL_LANGUAGE_DESCRIPTION.languageSetup
            }
            "services" -> SERVICE_DSL_LANGUAGE_DESCRIPTION.languageSetup
            else -> throw IllegalArgumentException("Line counting in model files with extension ${modelFile.extension} " +
                    "is not supported")
        }

        val loadedModel = loadXtextResource(languageSetup, modelFilePath, modelFile.inputStream())
        val loadedModelRoot = loadedModel.contents[0] as T
        loadedOriginalModelRootsCache[modelFilePath] = loadedModelRoot
        return loadedModelRoot
    }

     /**
     * Cache of loaded model roots.
     *
     * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
     */
    private val loadedOriginalModelRootsCache = mutableMapOf<String, EObject>()
    /**
     * Flag to indicate whether the [DATA_DSL_LANGUAGE_DESCRIPTION] was already added to the EPackage registry.
     *
     * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
     */
    private var dataDslRegistered = false

    /**
     * Add the [DATA_DSL_LANGUAGE_DESCRIPTION] to the EPackage registry, if this did not happen already.
     *
     * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
     */
    private fun registerDataDsl() {
        if (!dataDslRegistered)
            registerLanguage(DATA_DSL_LANGUAGE_DESCRIPTION.nsUri)
        dataDslRegistered = true
    }