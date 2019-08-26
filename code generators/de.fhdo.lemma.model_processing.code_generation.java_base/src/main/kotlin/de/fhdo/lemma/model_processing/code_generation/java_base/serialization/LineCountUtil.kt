package de.fhdo.lemma.model_processing.code_generation.java_base.serialization

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
import de.fhdo.lemma.model_processing.utils.countLines
import de.fhdo.lemma.model_processing.utils.mainInterface
import de.fhdo.lemma.model_processing.utils.trimToSingleLine
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import java.io.File
import java.lang.IllegalArgumentException

/**
 * Helper to count the lines of a [serializationResult] as well as of the original [EObject] in the file at the
 * [originalModelFilePath], which corresponds to the given [intermediateEObject]. The result is a [LineCountInfo]
 * object.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun countLines(serializationResult: Pair<String, String>, intermediateEObject: EObject,
    originalModelFilePath: String) : LineCountInfo {
    /* Count lines of generated code */
    val (targetFilePath, generatedCode) = serializationResult
    val generatedCodeLineCount = generatedCode.countLines()

    /* Count lines and determine additional information of original EObject */
    val originalEObject = intermediateEObject.loadOriginalEObject(originalModelFilePath)
    val originalEObjectParserNode = NodeModelUtils.getNode(originalEObject)
    val originalEObjectLineCount = originalEObjectParserNode.text.countLines()
    val originalEObjectAdditionalInfo = originalEObject.deriveAdditionalLineCountInfo(originalModelFilePath)
    originalEObjectAdditionalInfo[ORIGINAL_EOBJECT_TYPE_INFO_FIELD] = originalEObject.mainInterface.simpleName

    return LineCountInfo(
        targetFilePath,
        generatedCodeLineCount,
        originalEObjectLineCount,
        originalEObjectAdditionalInfo
    )
}

/**
 * This class clusters information yielded by a call to [countLines]. It comprises the line count of the serialization
 * result, the original [EObject] instance, and arbitrary additional information concerning the original [EObject] like
 * number of data fields etc.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class LineCountInfo(var serializationTargetFilePath: String, var serializationResultLineCount: Int = 0,
    var originalEObjectLineCount: Int = 0, val additionalInfo: Map<String, String> = mutableMapOf())

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
 * Helper to serialize a list of [LineCountInfo] instances to a CSV string.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun serializeLineCountInfo(lineCountInfoList: List<LineCountInfo>) : String {
    val serializationResult = mutableListOf<String>()
    val additionalInfoFieldNames = lineCountInfoList.map { it.additionalInfo.keys }.flatten().toSortedSet()

    /* Add heading */
    serializationResult.add(
        """
            Generated file path; 
            Generated line count;
            Original line count;
            ${additionalInfoFieldNames.joinToString(";")}
        """.trimToSingleLine()
    )

    /* Add line count information */
    for (lineCountInfo in lineCountInfoList) {
        val additionalInfo = lineCountInfo.additionalInfo
        val additionalInfoCsv = additionalInfoFieldNames.map { additionalInfo[it] ?: "n/a" }.joinToString(";")
        serializationResult.add(
            """
                ${lineCountInfo.serializationTargetFilePath}; 
                ${lineCountInfo.serializationResultLineCount};
                ${lineCountInfo.originalEObjectLineCount};
                $additionalInfoCsv
            """.trimToSingleLine()
        )
    }

    return serializationResult.joinToString("\n")
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
private fun EObject.deriveAdditionalLineCountInfo(originalModelFilePath: String) : MutableMap<String, String> {
    return when (this) {
        is ComplexType -> deriveAdditionalLineCountInfo(originalModelFilePath)
        else -> mutableMapOf()
    }
}

/**
 * Derive additional line count information for [ComplexType] instances, e.g., the field counts of [DataStructure] and
 * [ListType] instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun ComplexType.deriveAdditionalLineCountInfo(originalModelFilePath: String) : MutableMap<String, String> {
    val resultMap = mutableMapOf(ORIGINAL_EOBJECT_PATH_INFO_FIELD to "$originalModelFilePath${File.separator}$name")

    when (this) {
        is DataStructure -> {
            resultMap[COMPLEX_TYPE_FIELD_COUNT_INFO_FIELD] = dataFields.size.toString()
            resultMap[DATA_STRUCTURE_OPERATION_COUNT_INFO_FIELD] = operations.size.toString()
        }
        is ListType -> resultMap[COMPLEX_TYPE_FIELD_COUNT_INFO_FIELD] = dataFields.size.toString()
    }

    return resultMap
}

/**
 * Constant for the additional line count information "original EObject type".
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal const val ORIGINAL_EOBJECT_TYPE_INFO_FIELD = "originalEObjectType"

/**
 * Constant for the additional line count information "original EObject path", valid for all counted [EObject]
 * instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal const val ORIGINAL_EOBJECT_PATH_INFO_FIELD = "originalEObjectPath"

/**
 * Constant for the additional line count information "field count" of a [ComplexType] instance, e.g., a [DataStructure]
 * or [ListType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal const val COMPLEX_TYPE_FIELD_COUNT_INFO_FIELD = "fieldCount"

/**
 * Constant for the additional line count information "operation count" of a [DataStructure] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal const val DATA_STRUCTURE_OPERATION_COUNT_INFO_FIELD = "operationCount"