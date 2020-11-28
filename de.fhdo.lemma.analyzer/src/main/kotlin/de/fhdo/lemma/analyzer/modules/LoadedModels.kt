package de.fhdo.lemma.analyzer.modules

import de.fhdo.lemma.model_processing.asXmiResource
import de.fhdo.lemma.model_processing.command_line.BasicCommandLine
import de.fhdo.lemma.model_processing.utils.removeFileUri
import de.fhdo.lemma.utils.LemmaUtils
import org.eclipse.emf.ecore.EObject
import java.io.File

/**
 * Singleton to maintain all loaded intermediate models in the form of their roots ([EObject] instances) at runtime.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object LoadedModels {
    val modelRoots = mutableMapOf<String, EObject>()
    private val INTERMEDIATE_MODEL_PATH = BasicCommandLine.intermediateModelFile!!.toAbsoluteFilePath()

    /**
     * Convert this [String] to an absolute file path
     */
    private fun String.toAbsoluteFilePath()
        = with(File(this)) {
                if (isAbsolute)
                    absolutePath
                else
                    absoluteFile.canonicalPath
            }

    /**
     * Assign the given [modelRoot] to the given [filePath] in the [LoadedModels]
     */
    operator fun set(filePath: String, modelRoot: EObject) {
        modelRoots[filePath.toAbsoluteFilePath()] = modelRoot
    }

    /**
     * Load the model with the given [filePath] in the form of its root. This method will also assign the loaded model
     * root to the [filePath] in the [LoadedModels].
     */
    fun <T: EObject> loadModel(filePath: String) {
        val absoluteFilePath = filePath.toAbsoluteFilePath()
        if (absoluteFilePath in modelRoots)
            return

        val modelRoot = loadModelRoot<T>(absoluteFilePath)
        modelRoots[absoluteFilePath] = modelRoot
    }

    /**
     * Helper to load a model's root [EObject] from the given [filePath]
     */
    @Suppress("UNCHECKED_CAST")
    private fun <T : EObject> loadModelRoot(filePath: String) : T {
        val filePathWithoutUri = filePath.removeFileUri()
        val absoluteFilePath = LemmaUtils.convertToAbsoluteFileUri(filePathWithoutUri, INTERMEDIATE_MODEL_PATH)
        return absoluteFilePath.removeFileUri().asXmiResource().contents[0] as T
    }
}