package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds;

/**
 * Supported kinds of arguments for model processor execution. Note that the kind of an argument is
 * currently determined by the kind of parameter values the argument expects.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public enum ArgumentKindIdentifier {
  CONSTANT_PARAMETER,

  MULTI_VALUED_PARAMETER,

  SINGLE_VALUED_PARAMETER;
}
