package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Constants and methods relevant to the configuration of executions of the Java Base Generator. The
 * class is a Singleton so that its methods are invokable from the static instance() method.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class JavaBaseGeneratorParameters {
    public static val ALTERNATIVE_INTERMEDIATE_SERVICE_MODEL_PARAMETER
        = "--alternative_intermediate_service_model"
    public static val DEFAULT_DOCKER_IMAGE_NAME = "lemma/java_generator:latest"
    public static val GENERATION_SERIALIZER_PARAMETER = "--code_generation_serializer"
    public static val GENLET_PARAMETER = "--genlet"

    static val DOCKER_GENLETS_BASEPATH = "/home/genlets"
    static val DOCKER_GENLET_JAR_NAMES = #{
        GenletType.DDD -> "de.fhdo.lemma.model_processing.code_generation.ddd.jar",
        GenletType.SPRING_CLOUD -> "de.fhdo.lemma.model_processing.code_generation.springcloud.jar",
        GenletType.SPRING_CLOUD_CQRS
            -> "de.fhdo.lemma.model_processing.code_generation.springcloud.cqrs.jar",
        GenletType.SPRING_CLOUD_DOMAIN_EVENTS
            -> "de.fhdo.lemma.model_processing.code_generation.springcloud.domain_events.jar",
        GenletType.SPRING_CLOUD_KAFKA
            -> "de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.jar"
    }
    enum GenletType {
        DDD,
        SPRING_CLOUD,
        SPRING_CLOUD_CQRS,
        SPRING_CLOUD_DOMAIN_EVENTS,
        SPRING_CLOUD_KAFKA
    }

    static var JavaBaseGeneratorParameters instance

    val BiMap<String, String> availableCodeGenerationSerializers = HashBiMap.create()
    @Accessors(PUBLIC_GETTER)
    val String defaultGenerationSerializer

    /**
     * Constructor
     */
    private new() {
        availableCodeGenerationSerializers.put("extended-generation-gap", "Extended Generation Gap")
        availableCodeGenerationSerializers.put("generation-gap", "Generation Gap")
        availableCodeGenerationSerializers.put("plain", "Plain Generation")

        defaultGenerationSerializer = availableCodeGenerationSerializers.keySet.get(0)
    }

    /**
     * Get the Singleton instance
     */
    static def instance() {
        if (instance === null)
            instance = new JavaBaseGeneratorParameters()

        return instance
    }

    /**
     * Get the labels of all available approaches for serializing generated code sorted
     * alphabetically
     */
    final def getSerializerLabels() {
        return availableCodeGenerationSerializers.values.sortBy[it].toList
    }

    /**
     * Get the label of the approach for serializing generated code identified by its parameter
     */
    final def getSerializerLabel(String serializerParameter) {
        return availableCodeGenerationSerializers.get(serializerParameter)
    }

    /**
     * Get the label of the default approach for serializing generated code
     */
    final def defaultSerializerLabel() {
        return availableCodeGenerationSerializers.get(defaultGenerationSerializer)
    }

    /**
     * Get the parameter of the approach for serializing generated code identified by its label
     */
    final def getSerializerParameter(String serializerLabel) {
        return availableCodeGenerationSerializers.inverse.get(serializerLabel)
    }

    /**
     * Get the file path for the Genlet identified by the given Genlet type
     */
    final def getDockerGenletFilePath(GenletType genletType) {
        return '''«DOCKER_GENLETS_BASEPATH»/«DOCKER_GENLET_JAR_NAMES.get(genletType)»'''
    }
}