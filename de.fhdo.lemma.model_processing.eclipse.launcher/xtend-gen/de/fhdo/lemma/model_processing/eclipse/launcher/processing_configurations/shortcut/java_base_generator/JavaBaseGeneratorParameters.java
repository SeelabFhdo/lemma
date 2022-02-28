package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Constants and methods relevant to the configuration of executions of the Java Base Generator. The
 * class is a Singleton so that its methods are invokable from the static instance() method.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class JavaBaseGeneratorParameters {
  public enum GenletType {
    DDD,
    
    SPRING_CLOUD,
    
    SPRING_CLOUD_CQRS,
    
    SPRING_CLOUD_DOMAIN_EVENTS,
    
    SPRING_CLOUD_KAFKA;
  }
  
  public static final String ALTERNATIVE_INTERMEDIATE_SERVICE_MODEL_PARAMETER = "--alternative_intermediate_service_model";
  
  public static final String DEFAULT_DOCKER_IMAGE_NAME = "lemma/java_generator:latest";
  
  public static final String GENERATION_SERIALIZER_PARAMETER = "--code_generation_serializer";
  
  public static final String GENLET_PARAMETER = "--genlet";
  
  private static final String DOCKER_GENLETS_BASEPATH = "/home/genlets";
  
  private static final Map<JavaBaseGeneratorParameters.GenletType, String> DOCKER_GENLET_JAR_NAMES = Collections.<JavaBaseGeneratorParameters.GenletType, String>unmodifiableMap(CollectionLiterals.<JavaBaseGeneratorParameters.GenletType, String>newHashMap(Pair.<JavaBaseGeneratorParameters.GenletType, String>of(JavaBaseGeneratorParameters.GenletType.DDD, "de.fhdo.lemma.model_processing.code_generation.ddd.jar"), Pair.<JavaBaseGeneratorParameters.GenletType, String>of(JavaBaseGeneratorParameters.GenletType.SPRING_CLOUD, "de.fhdo.lemma.model_processing.code_generation.springcloud.jar"), Pair.<JavaBaseGeneratorParameters.GenletType, String>of(JavaBaseGeneratorParameters.GenletType.SPRING_CLOUD_CQRS, "de.fhdo.lemma.model_processing.code_generation.springcloud.cqrs.jar"), Pair.<JavaBaseGeneratorParameters.GenletType, String>of(JavaBaseGeneratorParameters.GenletType.SPRING_CLOUD_DOMAIN_EVENTS, "de.fhdo.lemma.model_processing.code_generation.springcloud.domain_events.jar"), Pair.<JavaBaseGeneratorParameters.GenletType, String>of(JavaBaseGeneratorParameters.GenletType.SPRING_CLOUD_KAFKA, "de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.jar")));
  
  private static JavaBaseGeneratorParameters instance;
  
  private final BiMap<String, String> availableCodeGenerationSerializers = HashBiMap.<String, String>create();
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final String defaultGenerationSerializer;
  
  /**
   * Constructor
   */
  private JavaBaseGeneratorParameters() {
    this.availableCodeGenerationSerializers.put("extended-generation-gap", "Extended Generation Gap");
    this.availableCodeGenerationSerializers.put("generation-gap", "Generation Gap");
    this.availableCodeGenerationSerializers.put("plain", "Plain Generation");
    this.defaultGenerationSerializer = ((String[])Conversions.unwrapArray(this.availableCodeGenerationSerializers.keySet(), String.class))[0];
  }
  
  /**
   * Get the Singleton instance
   */
  public static JavaBaseGeneratorParameters instance() {
    if ((JavaBaseGeneratorParameters.instance == null)) {
      JavaBaseGeneratorParameters _javaBaseGeneratorParameters = new JavaBaseGeneratorParameters();
      JavaBaseGeneratorParameters.instance = _javaBaseGeneratorParameters;
    }
    return JavaBaseGeneratorParameters.instance;
  }
  
  /**
   * Get the labels of all available approaches for serializing generated code sorted
   * alphabetically
   */
  public final List<String> getSerializerLabels() {
    final Function1<String, String> _function = (String it) -> {
      return it;
    };
    return IterableExtensions.<String>toList(IterableExtensions.<String, String>sortBy(this.availableCodeGenerationSerializers.values(), _function));
  }
  
  /**
   * Get the label of the approach for serializing generated code identified by its parameter
   */
  public final String getSerializerLabel(final String serializerParameter) {
    return this.availableCodeGenerationSerializers.get(serializerParameter);
  }
  
  /**
   * Get the label of the default approach for serializing generated code
   */
  public final String defaultSerializerLabel() {
    return this.availableCodeGenerationSerializers.get(this.defaultGenerationSerializer);
  }
  
  /**
   * Get the parameter of the approach for serializing generated code identified by its label
   */
  public final String getSerializerParameter(final String serializerLabel) {
    return this.availableCodeGenerationSerializers.inverse().get(serializerLabel);
  }
  
  /**
   * Get the file path for the Genlet identified by the given Genlet type
   */
  public final String getDockerGenletFilePath(final JavaBaseGeneratorParameters.GenletType genletType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(JavaBaseGeneratorParameters.DOCKER_GENLETS_BASEPATH);
    _builder.append("/");
    String _get = JavaBaseGeneratorParameters.DOCKER_GENLET_JAR_NAMES.get(genletType);
    _builder.append(_get);
    return _builder.toString();
  }
  
  @Pure
  public String getDefaultGenerationSerializer() {
    return this.defaultGenerationSerializer;
  }
}
