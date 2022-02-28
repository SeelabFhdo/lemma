package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments;

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.ArgumentKindFactory;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.ConstantParameterArgumentKind;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.MultiValuedParameterArgumentKind;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.SingleValuedParameterArgumentKind;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AllImportedIntermediateModelKinds;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.ArgumentTypeFactory;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.FileArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.FolderArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.ImportedIntermediateModelKind;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelKind;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelOfFirstImportArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelOfImportWithAliasArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelsOfAllImportsArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.RawStringArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.SourceModelArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.SourceModelKind;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.StringPairArgumentType;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * Builder for Argument instances.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class ArgumentBuilder {
  /**
   * Builder for Argument instances that have a parameter without value
   */
  public static class ParameterWithoutValueBuilder {
    private final Argument argument;
    
    private final ProcessingConfiguration processingConfiguration;
    
    /**
     * Constructor
     */
    public ParameterWithoutValueBuilder(final Argument argument, final ProcessingConfiguration processingConfiguration) {
      this.argument = argument;
      this.processingConfiguration = processingConfiguration;
    }
    
    /**
     * Set the argument parameter and return the final Argument instance
     */
    public Argument parameter(final String parameter) {
      this.argument.setParameter(parameter);
      if ((this.processingConfiguration != null)) {
        ArgumentBuilder.validate(this.argument, this.processingConfiguration);
      }
      return this.argument;
    }
  }
  
  /**
   * Exception for expected, yet missing model processing configurations
   */
  public static class MissingProcessingConfigurationException extends Exception {
    public MissingProcessingConfigurationException(final String message) {
      super(message);
    }
  }
  
  /**
   * Builder for single-valued arguments
   */
  public static class SingleValuedBuilder {
    private final Argument argument;
    
    private final ProcessingConfiguration processingConfiguration;
    
    /**
     * Constructor
     */
    public SingleValuedBuilder(final Argument argument, final ProcessingConfiguration processingConfiguration) {
      this.argument = argument;
      this.processingConfiguration = processingConfiguration;
    }
    
    /**
     * Let the single-valued argument represent a pair of arbitrary strings. Return a builder
     * for arguments with parameters and values. The parameter represents the first string and
     * its value represents the second string.
     */
    public ArgumentBuilder.ParameterBuilder stringPair() {
      this.argument.setType(ArgumentTypeFactory.fromIdentifier(StringPairArgumentType.IDENTIFIER));
      return new ArgumentBuilder.ParameterBuilder(this.argument, this.processingConfiguration);
    }
    
    /**
     * Let the single-valued argument represent a file. Return a builder for arguments with
     * parameters and values. The parameter represents the argument parameter and its value
     * represents the file.
     */
    public ArgumentBuilder.ParameterBuilder file() {
      this.argument.setType(ArgumentTypeFactory.fromIdentifier(FileArgumentType.IDENTIFIER));
      return new ArgumentBuilder.ParameterBuilder(this.argument, this.processingConfiguration);
    }
    
    /**
     * Let the single-valued argument represent a folder. Return a builder for arguments with
     * parameters and values. The parameter represents the argument parameter and its value
     * represents the folder.
     */
    public ArgumentBuilder.ParameterBuilder folder() {
      this.argument.setType(ArgumentTypeFactory.fromIdentifier(FolderArgumentType.IDENTIFIER));
      return new ArgumentBuilder.ParameterBuilder(this.argument, this.processingConfiguration);
    }
    
    /**
     * Let the single-valued argument represent a source LEMMA model file. Return a builder for
     * arguments with parameters but without values. The parameter represents the argument's
     * parameter and its value will automatically be set to the absolute path of the source
     * LEMMA model file.
     */
    public ArgumentBuilder.ParameterWithoutValueBuilder sourceModel() {
      AbstractArgumentType _fromIdentifier = ArgumentTypeFactory.fromIdentifier(SourceModelArgumentType.IDENTIFIER);
      final SourceModelArgumentType argumentType = ((SourceModelArgumentType) _fromIdentifier);
      this.argument.setType(argumentType);
      this.argument.setValue(argumentType.getLiteralDescription(SourceModelKind.SELECTED_FILE));
      return new ArgumentBuilder.ParameterWithoutValueBuilder(this.argument, this.processingConfiguration);
    }
    
    /**
     * Let the single-valued argument represent the intermediate representation of a source
     * LEMMA model file. Return a builder for arguments with parameters but without values. The
     * parameter represents the argument's parameter and its value will automatically be set to
     * the absolute path of the intermediate representation of the source LEMMA model file.
     */
    public ArgumentBuilder.ParameterWithoutValueBuilder intermediateModel() {
      AbstractArgumentType _fromIdentifier = ArgumentTypeFactory.fromIdentifier(IntermediateModelArgumentType.IDENTIFIER);
      final IntermediateModelArgumentType argumentType = ((IntermediateModelArgumentType) _fromIdentifier);
      this.argument.setType(argumentType);
      this.argument.setValue(argumentType.getLiteralDescription(IntermediateModelKind.SELECTED_FILE));
      return new ArgumentBuilder.ParameterWithoutValueBuilder(this.argument, this.processingConfiguration);
    }
    
    /**
     * Let the single-valued argument represent the intermediate representation of the first
     * LEMMA model of the given kind imported into another LEMMA model. Return a builder for
     * arguments with parameters but without values. The parameter represents the argument's
     * parameter and its value will automatically be set to the absolute path of the
     * intermediate representation of the first imported LEMMA model.
     */
    public ArgumentBuilder.ParameterWithoutValueBuilder intermdiateModelOfFirstImport(final ImportedIntermediateModelKind modelKind) {
      AbstractArgumentType _fromIdentifier = ArgumentTypeFactory.fromIdentifier(IntermediateModelOfFirstImportArgumentType.IDENTIFIER);
      final IntermediateModelOfFirstImportArgumentType argumentType = ((IntermediateModelOfFirstImportArgumentType) _fromIdentifier);
      this.argument.setType(argumentType);
      this.argument.setValue(argumentType.getLiteralDescription(modelKind));
      return new ArgumentBuilder.ParameterWithoutValueBuilder(this.argument, this.processingConfiguration);
    }
    
    /**
     * Build an argument that represents the intermediate representation of the LEMMA model
     * imported into another LEMMA model with the given alias
     */
    public ArgumentBuilder.ParameterWithoutValueBuilder intermediateModelOfImportWithAlias(final String alias) {
      AbstractArgumentType _fromIdentifier = ArgumentTypeFactory.fromIdentifier(IntermediateModelOfImportWithAliasArgumentType.IDENTIFIER);
      final IntermediateModelOfImportWithAliasArgumentType argumentType = ((IntermediateModelOfImportWithAliasArgumentType) _fromIdentifier);
      this.argument.setType(argumentType);
      this.argument.setValue(alias);
      return new ArgumentBuilder.ParameterWithoutValueBuilder(this.argument, this.processingConfiguration);
    }
  }
  
  /**
   * Builder for argument parameters
   */
  public static class ParameterBuilder {
    private final Argument argument;
    
    private final ProcessingConfiguration processingConfiguration;
    
    /**
     * Constructor
     */
    public ParameterBuilder(final Argument argument, final ProcessingConfiguration processingConfiguration) {
      this.argument = argument;
      this.processingConfiguration = processingConfiguration;
    }
    
    /**
     * Set the parameter and return a builder to specify the parameter's value
     */
    public ArgumentBuilder.ValueBuilder parameter(final String parameter) {
      this.argument.setParameter(parameter);
      return new ArgumentBuilder.ValueBuilder(this.argument, this.processingConfiguration);
    }
  }
  
  /**
   * Builder for argument values
   */
  public static class ValueBuilder {
    private final Argument argument;
    
    private final ProcessingConfiguration processingConfiguration;
    
    /**
     * Constructor
     */
    public ValueBuilder(final Argument argument, final ProcessingConfiguration processingConfiguration) {
      this.argument = argument;
      this.processingConfiguration = processingConfiguration;
    }
    
    /**
     * Set the value and return the final Argument instance
     */
    public Argument value(final String value) {
      this.argument.setValue(value);
      if ((this.processingConfiguration != null)) {
        ArgumentBuilder.validate(this.argument, this.processingConfiguration);
      }
      return this.argument;
    }
  }
  
  private final Argument argument;
  
  private ProcessingConfiguration processingConfiguration;
  
  /**
   * Constructor with a preliminary Argument instance
   */
  public ArgumentBuilder(final Argument argument) {
    this.argument = argument;
  }
  
  /**
   * Constructor with a preliminary Argument instance for a given ProcessingConfiguration
   */
  public ArgumentBuilder(final Argument argument, final ProcessingConfiguration processingConfiguration) {
    this(argument);
    this.processingConfiguration = processingConfiguration;
  }
  
  /**
   * Start building a constant argument. Return a builder for arguments with parameters but
   * without values. The parameter represents the argument's constant.
   */
  public final ArgumentBuilder.ParameterWithoutValueBuilder constant() {
    this.argument.setKind(ArgumentKindFactory.fromIdentifier(ConstantParameterArgumentKind.IDENTIFIER));
    this.argument.setType(ArgumentTypeFactory.fromIdentifier(RawStringArgumentType.IDENTIFIER));
    return new ArgumentBuilder.ParameterWithoutValueBuilder(this.argument, this.processingConfiguration);
  }
  
  /**
   * Validate an argument in the context of a model processing configuration
   */
  private static void validate(final Argument argument, final ProcessingConfiguration processingConfiguration) {
    try {
      if ((processingConfiguration == null)) {
        throw new ArgumentBuilder.MissingProcessingConfigurationException(("Processing configuration must not " + 
          "be null for argument validation"));
      }
      argument.getKind().validateTypeSupport(argument.getType());
      argument.getType().validateValueInUserRepresentation(processingConfiguration, argument.getValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Start building a multi-valued argument which is currently only supported for certain kinds of
   * intermediate representations of LEMMA models imported into other LEMMA models. Return a
   * builder for arguments with parameters but without values. The parameter represents the
   * argument's parameter that is repeated for each intermediate model.
   */
  public final ArgumentBuilder.ParameterWithoutValueBuilder multiValued(final AllImportedIntermediateModelKinds modelKinds) {
    this.argument.setKind(ArgumentKindFactory.fromIdentifier(MultiValuedParameterArgumentKind.IDENTIFIER));
    AbstractArgumentType _fromIdentifier = ArgumentTypeFactory.fromIdentifier(IntermediateModelsOfAllImportsArgumentType.IDENTIFIER);
    final IntermediateModelsOfAllImportsArgumentType argumentType = ((IntermediateModelsOfAllImportsArgumentType) _fromIdentifier);
    this.argument.setType(argumentType);
    this.argument.setValue(argumentType.getLiteralDescription(modelKinds));
    return new ArgumentBuilder.ParameterWithoutValueBuilder(this.argument, this.processingConfiguration);
  }
  
  /**
   * Start building a single-valued argument. Return a builder specific to such kinds of
   * arguments.
   */
  public final ArgumentBuilder.SingleValuedBuilder singleValued() {
    this.argument.setKind(ArgumentKindFactory.fromIdentifier(SingleValuedParameterArgumentKind.IDENTIFIER));
    return new ArgumentBuilder.SingleValuedBuilder(this.argument, this.processingConfiguration);
  }
}
