package de.fhdo.ddmm.intermediate.transformations

import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Exception for intermediate transformation errors that allows to distinguish between warnings and
 * "real" errors.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class IntermediateTransformationException extends Exception {
    @Accessors(PUBLIC_GETTER)
    IntermediateTransformationExceptionKind kind

    @Accessors(PUBLIC_GETTER)
    IntermediateTransformationPhase phase

    new(String message, IntermediateTransformationExceptionKind kind,
        IntermediateTransformationPhase phase) {
        super(message)
        this.kind = kind
        this.phase = phase
    }
}