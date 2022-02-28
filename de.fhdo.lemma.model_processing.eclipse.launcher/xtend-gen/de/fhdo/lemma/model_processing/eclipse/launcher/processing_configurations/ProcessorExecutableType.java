package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations;

/**
 * Types of model processor executables supported by model processing configurations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public enum ProcessorExecutableType {
  LOCAL_JAVA_PROGRAM,
  
  LOCAL_DOCKER_IMAGE,
  
  RAW_EXECUTABLE;
}
