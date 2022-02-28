package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.mongodb

/**
 * Constants for for launch configuration templates targeting code generation with the MongoDB
 * Generator.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class MongoDBGeneratorConstants {
    protected static val DEFAULT_DOCKER_IMAGE_NAME = "lemma/mongodb_generator:latest"
    protected static val GENERATOR_LONG_NAME = "MongoDB Generator"
    protected static val GENERATOR_SHORT_NAME = "MongoDBGen"
}