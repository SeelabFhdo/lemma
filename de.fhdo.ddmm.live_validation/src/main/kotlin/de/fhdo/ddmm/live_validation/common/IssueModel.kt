package de.fhdo.ddmm.live_validation.common

import org.eclipse.lsp4j.DiagnosticSeverity

/**
 * Class representing an issue, i.e., a validation result, (follows LSP's [Diagnostics semantics](
 * https://microsoft.github.io/language-server-protocol/specification#textDocument_publishDiagnostics)). However, LSP's
 * Diagnostic interface was not sufficient to specify an issue as a validation result in the necessary detail. For
 * instance, with column (next to character offset) we added more information to the "range" field within the
 * [IssueRange] structure.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
data class IssueDiagnostic(var range: IssueRange, var severity: DiagnosticSeverity, var message: String)

/**
 * Class representing the range of an issue (follows LSP's [Range semantics](
 * https://microsoft.github.io/language-server-protocol/specification#textDocument_publishDiagnostics)).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
data class IssueRange(var lineNumber: Int, var column: Int, var offset: Int, var length: Int)