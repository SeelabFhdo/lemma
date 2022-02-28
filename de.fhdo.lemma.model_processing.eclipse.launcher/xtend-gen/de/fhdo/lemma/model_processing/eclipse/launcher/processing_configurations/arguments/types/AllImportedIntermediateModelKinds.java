package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types;

/**
 * Literal representation of all LEMMA models of equal kinds that can be imported into other
 * LEMMA models and are transformable into intermediate representations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public enum AllImportedIntermediateModelKinds {
  ALL_DOMAIN_MODELS,
  
  ALL_OPERATION_MODELS,
  
  ALL_SERVICE_MODELS;
}
