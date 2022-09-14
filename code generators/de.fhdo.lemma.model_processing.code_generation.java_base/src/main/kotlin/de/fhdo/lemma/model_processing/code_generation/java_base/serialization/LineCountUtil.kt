package de.fhdo.lemma.model_processing.code_generation.java_base.serialization

import de.fhdo.lemma.data.ComplexType
import de.fhdo.lemma.data.DataStructure
import de.fhdo.lemma.data.CollectionType
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.code_generation.java_base.loadOriginalEObject
import de.fhdo.lemma.model_processing.utils.countLines
import de.fhdo.lemma.model_processing.utils.mainInterface
import de.fhdo.lemma.model_processing.utils.trimToSingleLine
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import java.io.File
import java.math.BigDecimal
import java.math.RoundingMode

/**
 * Helper to count the lines of a [serializationResult] as well as of the original [EObject] in the file at the
 * [originalModelFilePath], which corresponds to the given [intermediateEObject]. The result is a [LineCountInfo]
 * object.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun countLines(serializationResult: Pair<String, String>, intermediateEObject: EObject? = null,
    originalModelFilePath: String? = null) : LineCountInfo {
    /* Count lines of generated code */
    val (targetFilePath, generatedCode) = serializationResult
    val generatedCodeLineCount = generatedCode.countLines(forFile = targetFilePath)

    if (intermediateEObject == null || originalModelFilePath == null)
        return LineCountInfo(targetFilePath, generatedCodeLineCount)

    /* Count lines and determine additional information of original EObject if specified */
    val originalEObject = intermediateEObject.loadOriginalEObject(originalModelFilePath)
    val originalEObjectParserNode = NodeModelUtils.getNode(originalEObject)
    val originalEObjectLineCount = originalEObjectParserNode.text.countLines(forFile = originalModelFilePath)
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
    var originalEObjectLineCount: Int = 0, val additionalInfo: Map<String, String> = mutableMapOf()) {
    /**
     * Two [LineCountInfo] instances are equal, if their [serializationTargetFilePath] values are equal
     */
    override fun equals(other: Any?)
        = if (this === other) true
            else if (other == null) false
            else if (other is LineCountInfo) serializationTargetFilePath == other.serializationTargetFilePath
            else false

    /**
     * The hash code of a [LineCountInfo] is equal to the hash code of its [serializationTargetFilePath]
     */
    override fun hashCode() = serializationTargetFilePath.hashCode()
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
    val fileExtensionSums = mutableMapOf<String, Pair<Int, Int>>()
    val summarizedEObjects = mutableSetOf<String>()
    for (lineCountInfo in lineCountInfoList) {
        val additionalInfo = lineCountInfo.additionalInfo
        val additionalInfoCsv = additionalInfoFieldNames.joinToString(";") { additionalInfo[it] ?: "n/a" }
        serializationResult.add(
            """
                ${lineCountInfo.serializationTargetFilePath}; 
                ${lineCountInfo.serializationResultLineCount};
                ${lineCountInfo.originalEObjectLineCount};
                $additionalInfoCsv
            """.trimToSingleLine()
        )

        // Collect line count sums per file type
        val fileExtension = lineCountInfo.serializationTargetFilePath.asFile().extension.toLowerCase()
        var (serializationResultLineCountSum, originalEObjectLineCountSum) =
            if (fileExtension in fileExtensionSums)
                fileExtensionSums[fileExtension]!!
            else
                0 to 0
        serializationResultLineCountSum += lineCountInfo.serializationResultLineCount
        val originalEObjectPath = lineCountInfo.additionalInfo[ORIGINAL_EOBJECT_PATH_INFO_FIELD]
        if (originalEObjectPath != null && originalEObjectPath !in summarizedEObjects) {
            originalEObjectLineCountSum += lineCountInfo.originalEObjectLineCount
            summarizedEObjects.add(originalEObjectPath)
        }
        fileExtensionSums[fileExtension] = serializationResultLineCountSum to originalEObjectLineCountSum
    }

    /* Write line count sums */
    serializationResult.add("\nLine count sums")
    serializationResult.add("Extension;Manual LOC;Generated LOC;Diff (How much code was truly generated?);" +
        "Ratio (What is the share of truly generated code to overall generated code?)")

    var serializationResultLineCountSumOverall = 0
    var originalEObjectLineCountSumOverall = 0
    fileExtensionSums.forEach { (fileExtension, sums) ->
        val (serializationResultLineCountSum, originalEObjectLineCountSum) = sums
        val diff = serializationResultLineCountSum - originalEObjectLineCountSum
        serializationResult.add(
            """
                $fileExtension;
                $originalEObjectLineCountSum;
                $serializationResultLineCountSum;
                $diff;
                ${calculatePercentage(diff, serializationResultLineCountSum)}
            """.trimToSingleLine()
        )

        serializationResultLineCountSumOverall += serializationResultLineCountSum
        originalEObjectLineCountSumOverall += originalEObjectLineCountSum
    }
    val overallDiff = serializationResultLineCountSumOverall - originalEObjectLineCountSumOverall
    serializationResult.add(
        """
            ;
            $originalEObjectLineCountSumOverall;
            $serializationResultLineCountSumOverall;
            $overallDiff;
            ${calculatePercentage(overallDiff, serializationResultLineCountSumOverall)}
        """.trimToSingleLine()
    )

    return serializationResult.joinToString("\n")
}

/**
 * Helper to calculate the share of [value] in [absolute]. The result is a percentage with two decimals.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun calculatePercentage(value: Int, absolute: Int)
    = BigDecimal((value * 1.0 / absolute) * 100.0).setScale(2, RoundingMode.HALF_EVEN).toFloat()

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
 * [CollectionType] instances.
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
        is CollectionType -> resultMap[COMPLEX_TYPE_FIELD_COUNT_INFO_FIELD] = dataFields.size.toString()
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
 * or [CollectionType].
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