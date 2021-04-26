package de.fhdo.lemma.live_validation.protocol.extensions;

import de.fhdo.lemma.live_validation.model.IssueDiagnostic;

import java.util.List;
import java.util.Objects;

/**
 * Structure to send gathered validation results from the server to initiating Live Validation clients, i.e., clients
 * that realize the AbstractLiveValidationInitiator class from the Live Validation client project.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
public class PublishIssuesParams {
    private String uri;
    private List<IssueDiagnostic> diagnostics;

    public PublishIssuesParams(String uri, List<IssueDiagnostic> diagnostics) {
        this.uri = uri;
        this.diagnostics = diagnostics;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<IssueDiagnostic> getDiagnostics() {
        return diagnostics;
    }

    public void setDiagnostics(List<IssueDiagnostic> diagnostics) {
        this.diagnostics = diagnostics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (PublishIssuesParams) o;
        return Objects.equals(uri, that.uri) && Objects.equals(diagnostics, that.diagnostics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uri, diagnostics);
    }

    @Override
    public String toString() {
        return "PublishIssuesParams{" +
                "uri='" + uri + '\'' +
                ", diagnostics=" + diagnostics +
                '}';
    }
}
