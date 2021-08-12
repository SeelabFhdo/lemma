package de.fhdo.lemma.model_processing.builtin_phases

import de.fhdo.lemma.live_validation.model.IssueDiagnostic
import de.fhdo.lemma.live_validation.model.IssueRange
import de.fhdo.lemma.model_processing.printlnError
import de.fhdo.lemma.model_processing.printlnWarning
import org.eclipse.lsp4j.DiagnosticSeverity
import java.lang.IllegalStateException

/**
 * Enumeration to reflect the various types of a validation result.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
enum class ValidationResultType(val severityWeight: Int, val printableName: String) {
    ERROR(3, "ERROR"),
    IGNORE(0, "IGNORE"),
    INFO(1, "INFO"),
    WARNING(2, "WARNING")
}

/**
 * A validation result.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class ValidationResult(var lineNumber: Int? = null, var column: Int? = null, var offset: Int? = null,
    var length: Int? = null, var message: String? = null, var type: ValidationResultType = ValidationResultType.ERROR
)

/**
 * Internal helper to print out a [ValidationResult] list.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun List<ValidationResult>.print(file: String) {
    if (isEmpty())
        return

    val withoutIgnorableResults = filter { it.type != ValidationResultType.IGNORE }
    if (withoutIgnorableResults.isEmpty())
        return

    println("Validation results for file $file:")
    val sortedResults = sortedWith(
        compareByDescending<ValidationResult> { it.type.severityWeight }
        .thenBy(ValidationResult::lineNumber)
        .thenBy(ValidationResult::column)
        .thenBy(ValidationResult::message)
    )

    for (result in sortedResults) {
        val printResult: (Any) -> (Unit) = when (result.type) {
            ValidationResultType.ERROR -> ::printlnError
            ValidationResultType.WARNING -> ::printlnWarning
            else -> ::println
        }

        val printableResult = StringBuffer()
        with(result) {
            printableResult.append("\t${type.printableName}")
            if (lineNumber != null && column != null)
                printableResult.append(" ($lineNumber, $column)")
            else if (lineNumber != null)
                printableResult.append(" (line $lineNumber)")
            else if (column != null)
                printableResult.append(" (column $column)")

            val printableMessage = message ?: ""
            if (printableMessage.isNotEmpty())
                printableResult.append(": $printableMessage")
        }
        printResult(printableResult.toString())
    }
}

/**
 * Internal helper to convert a [ValidationResult] to an [IssueDiagnostic] used in Live Validation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ValidationResult.toIssueDiagnostic() : IssueDiagnostic {
    val issueSeverity = when(type) {
        ValidationResultType.ERROR -> DiagnosticSeverity.Error
        ValidationResultType.INFO -> DiagnosticSeverity.Information
        ValidationResultType.WARNING -> DiagnosticSeverity.Warning
        else -> throw IllegalStateException("Conversion of validation results of type $type to " +
            "${IssueDiagnostic::class.qualifiedName!!} is not supported")
    }
    val issueRange = IssueRange(lineNumber ?: 0, column ?: 0, offset ?: 0, length ?: 0)
    return IssueDiagnostic(issueRange, issueSeverity, message ?: "")
}