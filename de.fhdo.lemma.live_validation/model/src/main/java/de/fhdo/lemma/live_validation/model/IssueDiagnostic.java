package de.fhdo.lemma.live_validation.model;

import org.eclipse.lsp4j.DiagnosticSeverity;

import java.util.Objects;

/**
 * Class representing an issue, i.e., a validation result, (follows LSP's
 * <a href="https://microsoft.github.io/language-server-protocol/specification#textDocument_publishDiagnostics">
 *  Diagnostics semantics
 * </a>). However, LSP's Diagnostic interface was not sufficient to specify an issue as a validation result in the
 * necessary detail. For instance, with column (next to character offset) we added more information to the "range" field
 * within the IssueRange structure.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
public class IssueDiagnostic {
    private IssueRange range;
    private DiagnosticSeverity severity;
    private String message;

    public IssueDiagnostic(IssueRange range, DiagnosticSeverity severity, String message) {
        this.range = range;
        this.severity = severity;
        this.message = message;
    }

    public IssueRange getRange() {
        return range;
    }

    public void setRange(IssueRange range) {
        this.range = range;
    }

    public DiagnosticSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(DiagnosticSeverity severity) {
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (IssueDiagnostic) o;
        return Objects.equals(range, that.range) && severity == that.severity && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(range, severity, message);
    }

    @Override
    public String toString() {
        return "IssueDiagnostic{" +
                "range=" + range +
                ", severity=" + severity +
                ", message='" + message + '\'' +
                '}';
    }
}
