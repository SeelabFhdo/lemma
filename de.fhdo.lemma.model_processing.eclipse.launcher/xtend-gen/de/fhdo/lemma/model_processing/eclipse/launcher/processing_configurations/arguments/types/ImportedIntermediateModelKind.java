package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types;

/**
 * Literal representation of the first LEMMA model of a certain kind that can be imported into other
 * LEMMA models and is transformable into intermediate representations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public enum ImportedIntermediateModelKind {
  FIRST_DOMAIN_MODEL,

  FIRST_OPERATION_MODEL,

  FIRST_SERVICE_MODEL;
}
