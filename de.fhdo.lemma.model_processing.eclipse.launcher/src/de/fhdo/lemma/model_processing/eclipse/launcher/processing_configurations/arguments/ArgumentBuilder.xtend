package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.ArgumentKindFactory
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.ConstantParameterArgumentKind
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.RawStringArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.ArgumentTypeFactory
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.MultiValuedParameterArgumentKind
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelsOfAllImportsArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.SingleValuedParameterArgumentKind
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.FileArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.ArgumentBuilder.ParameterBuilder
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.FolderArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelKind
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.ImportedIntermediateModelKind
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AllImportedIntermediateModelKinds
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.SourceModelArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.SourceModelKind
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.StringPairArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelOfImportWithAliasArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelOfFirstImportArgumentType

/**
 * Builder for Argument instances.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class ArgumentBuilder {
    val Argument argument
    var ProcessingConfiguration processingConfiguration

    /**
     * Constructor with a preliminary Argument instance
     */
    new(Argument argument) {
        this.argument = argument
    }

    /**
     * Constructor with a preliminary Argument instance for a given ProcessingConfiguration
     */
    new(Argument argument, ProcessingConfiguration processingConfiguration) {
        this(argument)
        this.processingConfiguration = processingConfiguration
    }

    /**
     * Start building a constant argument. Return a builder for arguments with parameters but
     * without values. The parameter represents the argument's constant.
     */
    final def constant() {
        argument.kind = ArgumentKindFactory.fromIdentifier(ConstantParameterArgumentKind.IDENTIFIER)
        argument.type = ArgumentTypeFactory.fromIdentifier(RawStringArgumentType.IDENTIFIER)
        return new ParameterWithoutValueBuilder(argument, processingConfiguration)
    }

    /**
     * Builder for Argument instances that have a parameter without value
     */
    static class ParameterWithoutValueBuilder {
        val Argument argument
        val ProcessingConfiguration processingConfiguration

        /**
         * Constructor
         */
        new(Argument argument, ProcessingConfiguration processingConfiguration) {
           this.argument = argument
           this.processingConfiguration = processingConfiguration
        }

        /**
         * Set the argument parameter and return the final Argument instance
         */
        def parameter(String parameter) {
            argument.parameter = parameter
            if (processingConfiguration !== null)
                argument.validate(processingConfiguration)
            return argument
        }
    }

    /**
     * Validate an argument in the context of a model processing configuration
     */
    private static def validate(Argument argument,
        ProcessingConfiguration processingConfiguration) {
        if (processingConfiguration === null)
            throw new MissingProcessingConfigurationException("Processing configuration must not " +
                "be null for argument validation")
        argument.kind.validateTypeSupport(argument.type)
        argument.type.validateValueInUserRepresentation(processingConfiguration, argument.value)
    }

    /**
     * Exception for expected, yet missing model processing configurations
     */
    static class MissingProcessingConfigurationException extends Exception {
        new (String message) {
            super(message)
        }
    }

    /**
     * Start building a multi-valued argument which is currently only supported for certain kinds of
     * intermediate representations of LEMMA models imported into other LEMMA models. Return a
     * builder for arguments with parameters but without values. The parameter represents the
     * argument's parameter that is repeated for each intermediate model.
     */
    final def multiValued(AllImportedIntermediateModelKinds modelKinds) {
        argument.kind = ArgumentKindFactory
            .fromIdentifier(MultiValuedParameterArgumentKind.IDENTIFIER)
        val argumentType = ArgumentTypeFactory
            .fromIdentifier(IntermediateModelsOfAllImportsArgumentType.IDENTIFIER)
            as IntermediateModelsOfAllImportsArgumentType
        argument.type = argumentType
        argument.value = argumentType.getLiteralDescription(modelKinds)
        return new ParameterWithoutValueBuilder(argument, processingConfiguration)
    }

    /**
     * Start building a single-valued argument. Return a builder specific to such kinds of
     * arguments.
     */
    final def singleValued() {
        argument.kind = ArgumentKindFactory
            .fromIdentifier(SingleValuedParameterArgumentKind.IDENTIFIER)
        return new SingleValuedBuilder(argument, processingConfiguration)
    }

    /**
     * Builder for single-valued arguments
     */
    static class SingleValuedBuilder {
        val Argument argument
        val ProcessingConfiguration processingConfiguration

        /**
         * Constructor
         */
        new(Argument argument, ProcessingConfiguration processingConfiguration) {
           this.argument = argument
           this.processingConfiguration = processingConfiguration
        }

        /**
         * Let the single-valued argument represent a pair of arbitrary strings. Return a builder
         * for arguments with parameters and values. The parameter represents the first string and
         * its value represents the second string.
         */
        def stringPair() {
            argument.type = ArgumentTypeFactory.fromIdentifier(StringPairArgumentType.IDENTIFIER)
            return new ParameterBuilder(argument, processingConfiguration)
        }

        /**
         * Let the single-valued argument represent a file. Return a builder for arguments with
         * parameters and values. The parameter represents the argument parameter and its value
         * represents the file.
         */
        def file() {
            argument.type = ArgumentTypeFactory.fromIdentifier(FileArgumentType.IDENTIFIER)
            return new ParameterBuilder(argument, processingConfiguration)
        }

        /**
         * Let the single-valued argument represent a folder. Return a builder for arguments with
         * parameters and values. The parameter represents the argument parameter and its value
         * represents the folder.
         */
        def folder() {
            argument.type = ArgumentTypeFactory.fromIdentifier(FolderArgumentType.IDENTIFIER)
            return new ParameterBuilder(argument, processingConfiguration)
        }

        /**
         * Let the single-valued argument represent a source LEMMA model file. Return a builder for
         * arguments with parameters but without values. The parameter represents the argument's
         * parameter and its value will automatically be set to the absolute path of the source
         * LEMMA model file.
         */
        def sourceModel() {
            val argumentType = ArgumentTypeFactory
                .fromIdentifier(SourceModelArgumentType.IDENTIFIER)
                as SourceModelArgumentType
            argument.type = argumentType
            argument.value = argumentType.getLiteralDescription(SourceModelKind.SELECTED_FILE)
            return new ParameterWithoutValueBuilder(argument, processingConfiguration)
        }

        /**
         * Let the single-valued argument represent the intermediate representation of a source
         * LEMMA model file. Return a builder for arguments with parameters but without values. The
         * parameter represents the argument's parameter and its value will automatically be set to
         * the absolute path of the intermediate representation of the source LEMMA model file.
         */
        def intermediateModel() {
            val argumentType = ArgumentTypeFactory
                .fromIdentifier(IntermediateModelArgumentType.IDENTIFIER)
                as IntermediateModelArgumentType
            argument.type = argumentType
            argument.value = argumentType.getLiteralDescription(IntermediateModelKind.SELECTED_FILE)
            return new ParameterWithoutValueBuilder(argument, processingConfiguration)
        }

        /**
         * Let the single-valued argument represent the intermediate representation of the first
         * LEMMA model of the given kind imported into another LEMMA model. Return a builder for
         * arguments with parameters but without values. The parameter represents the argument's
         * parameter and its value will automatically be set to the absolute path of the
         * intermediate representation of the first imported LEMMA model.
         */
        def intermdiateModelOfFirstImport(ImportedIntermediateModelKind modelKind) {
            val argumentType = ArgumentTypeFactory
                .fromIdentifier(IntermediateModelOfFirstImportArgumentType.IDENTIFIER)
                as IntermediateModelOfFirstImportArgumentType
            argument.type = argumentType
            argument.value = argumentType.getLiteralDescription(modelKind)
            return new ParameterWithoutValueBuilder(argument, processingConfiguration)
        }

        /**
         * Build an argument that represents the intermediate representation of the LEMMA model
         * imported into another LEMMA model with the given alias
         */
        def intermediateModelOfImportWithAlias(String alias) {
            val argumentType = ArgumentTypeFactory
                .fromIdentifier(IntermediateModelOfImportWithAliasArgumentType.IDENTIFIER)
                as IntermediateModelOfImportWithAliasArgumentType
            argument.type = argumentType
            argument.value = alias
            return new ParameterWithoutValueBuilder(argument, processingConfiguration)
        }
    }

    /**
     * Builder for argument parameters
     */
    static class ParameterBuilder {
        val Argument argument
        val ProcessingConfiguration processingConfiguration

        /**
         * Constructor
         */
        new(Argument argument, ProcessingConfiguration processingConfiguration) {
           this.argument = argument
           this.processingConfiguration = processingConfiguration
        }

        /**
         * Set the parameter and return a builder to specify the parameter's value
         */
        def parameter(String parameter) {
            argument.parameter = parameter
            return new ValueBuilder(argument, processingConfiguration)
        }
    }

    /**
     * Builder for argument values
     */
    static class ValueBuilder {
        val Argument argument
        val ProcessingConfiguration processingConfiguration

        /**
         * Constructor
         */
        new(Argument argument, ProcessingConfiguration processingConfiguration) {
           this.argument = argument
           this.processingConfiguration = processingConfiguration
        }

        /**
         * Set the value and return the final Argument instance
         */
        def value(String value) {
            argument.value = value
            if (processingConfiguration !== null)
                argument.validate(processingConfiguration)
            return argument
        }
    }
}