package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation

import de.fhdo.lemma.data.ComplexType
import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.data.DataStructure
import de.fhdo.lemma.data.ListType
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.DATA_DSL_LANGUAGE_DESCRIPTION
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.SERVICE_DSL_LANGUAGE_DESCRIPTION
import de.fhdo.lemma.model_processing.code_generation.java_base.qualifiedName
import de.fhdo.lemma.model_processing.languages.registerLanguage
import de.fhdo.lemma.model_processing.loadXtextResource
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import java.lang.IllegalArgumentException

/**
 * Helper to count the lines of a [serializationResult] as well as of the original [EObject] in the file at the
 * [originalModelFilePath], which corresponds to the given [intermediateEObject]. The result is a [LineCountInfo]
 * object.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun countLines(serializationResult: String, intermediateEObject: EObject, originalModelFilePath: String)
    : LineCountInfo {
    /* Count lines of serialization result */
    val serializationResultLineCount = serializationResult.countLines()

    /* Count lines and determine additional information of original EObject */
    val originalEObject = intermediateEObject.loadOriginalEObject(originalModelFilePath)
    val originalEObjectParserNode = NodeModelUtils.getNode(originalEObject)
    val originalEObjectLineCount = originalEObjectParserNode.text.countLines()
    val originalEObjectAdditionalInfo = originalEObject.deriveAdditionalLineCountInfo()

    return LineCountInfo(serializationResultLineCount, originalEObjectLineCount, originalEObjectAdditionalInfo)
}

/**
 * This class clusters information yielded by a call to [countLines]. It comprises the line count of the serialization
 * result, the original [EObject] instance, and arbitrary additional information concerning the original [EObject] like
 * number of data fields etc.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class LineCountInfo(var serializationResultLineCount: Int = 0, var originalEObjectLineCount: Int = 0,
    val additionalInfo: Map<String, String> = mutableMapOf())

/**
 * Count lines of a String. CRLF, LF, and CR will be considered as linebreak separators.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun String.countLines(includeEmptyLines: Boolean = false)
    = if (includeEmptyLines)
            lines().count()
        else
            lines().filter { it.isNotEmpty() && !it.matches("\\s+".toRegex()) }.count()

/**
 * Load the original [EObject] of the given intermediate [EObject] from the specified [originalModelFilePath]. The
 * result depends on the concrete runtime type of this [EObject].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun EObject.loadOriginalEObject(originalModelFilePath: String) : EObject {
    val originalEObject = when (this) {
        is IntermediateComplexType -> loadOriginalEObject(originalModelFilePath)
        else -> throw IllegalArgumentException("Loading original EObject for intermediate EObject of type " +
            "${this::class.java.name} is not supported")
    }

    if (originalEObject === null)
        throw IllegalArgumentException("Original EObject of intermediate EObject of type ${this::class.java.name} " +
            "could not be loaded")

    return originalEObject
}

/**
 * Load the original [EObject] of the given [IntermediateComplexType]from the specified [originalModelFilePath]. The
 * result will be an [EObject] of type [ComplexType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun IntermediateComplexType.loadOriginalEObject(originalModelFilePath: String) : EObject? {
    val modelRoot = loadOriginalModelRoot<DataModel>(originalModelFilePath)
    return modelRoot.containedComplexTypes.find { it.qualifiedName == this.qualifiedName }
}

/**
 * Cache of loaded model roots.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private val loadedOriginalModelRootsCache = mutableMapOf<String, EObject>()

/**
 * Load the root of the model file at the given [modelFilePath], which must point to an Xtext resource.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("UNCHECKED_CAST")
private fun <T: EObject> loadOriginalModelRoot(modelFilePath: String) : T {
    val alreadyLoadedModelRoot = loadedOriginalModelRootsCache[modelFilePath]
    if (alreadyLoadedModelRoot !== null)
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

/**
 * Derive additional line count information for the concrete runtime type of this [EObject].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun EObject.deriveAdditionalLineCountInfo() : MutableMap<String, String> {
    return when (this) {
        is ComplexType -> deriveAdditionalLineCountInfo()
        else -> mutableMapOf()
    }
}

/**
 * Derive additional line count information for [ComplexType] instances, e.g., the field counts of [DataStructure] and
 * [ListType] instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun ComplexType.deriveAdditionalLineCountInfo() : MutableMap<String, String> {
    return when (this) {
        is DataStructure -> mutableMapOf(FIELD_COUNT_INFO_FIELD to dataFields.size.toString())
        is ListType -> mutableMapOf(FIELD_COUNT_INFO_FIELD to dataFields.size.toString())
        else -> mutableMapOf()
    }
}

/**
 * Constant for the additional line count information "field count" of a [ComplexType] instance, e.g., a [DataStructure]
 * or [ListType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val ComplexType.FIELD_COUNT_INFO_FIELD
    get() = "fieldCount"