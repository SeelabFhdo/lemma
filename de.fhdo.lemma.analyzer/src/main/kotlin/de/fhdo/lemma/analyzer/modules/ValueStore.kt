package de.fhdo.lemma.analyzer.modules

import de.fhdo.lemma.analyzer.command_line.CommandLine
import java.io.FileWriter

/**
 * Singleton to maintain values collected during metrics calculation for their subsequent serialization to the local
 * filesystem.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object ValueStore : HashMap<String, Any>() {
    /**
     * Assign a [value] to the [ValueStore] under the given [key]
     */
    operator fun set(key: String, value: Any) {
        val prefix = CommandLine.csvColumnPrefix ?: ""
        val columnKey = if (prefix.isNotEmpty()) "$prefix${key.capitalize()}" else key
        put(columnKey, value)
    }

    /**
     * Assign a [valueAndVariableKeyParts] to the [ValueStore]. The variable key parts of the [valueAndVariableKeyParts]
     * will be joined by the specified [CommandLine.csvVariableSeparator] and appended to the given [key] again
     * separated by the [CommandLine.csvVariableSeparator].
     */
    operator fun set(key: String, valueAndVariableKeyParts: Pair<Any, List<String>>) {
        val (value, variableKeyParts) = valueAndVariableKeyParts
        val variableKey = variableKeyParts.joinToString(CommandLine.csvVariableSeparator)
        val completeKey = key + CommandLine.csvVariableSeparator + variableKey
        this[completeKey] = value
    }

    /**
     * Write the [ValueStore] as a CSV file to the given [targetFile] in the local filesystem
     */
    fun writeAsCsv(targetFile: String) {
        val csvContent =
            """
                ${keys.joinToString(";")}
                ${values.joinToString(";")}
            """.trimIndent()

        FileWriter(targetFile).use { it.write(csvContent) }
    }

    /**
     * Convert the [ValueStore] entries to a String representation useful for debugging purposes
     */
    override fun toString() = """{
            |${"\t" + toSortedMap().entries.joinToString("\n\t") { (k, v) -> "$k = $v" }}
            |}
        """.trimMargin()
}