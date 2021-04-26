package de.fhdo.lemma.live_validation.protocol.extensions;

/**
 * Structure to identify an LSP server as capable of handling Live Validation requests.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
public class LiveValidationCapabilities {
    private final boolean supportsLiveValidation;

    public LiveValidationCapabilities() {
        this(true);
    }

    public LiveValidationCapabilities(boolean supportsLiveValidation) {
        this.supportsLiveValidation = supportsLiveValidation;
    }

    public boolean isSupportsLiveValidation() {
        return supportsLiveValidation;
    }
}
