package de.fhdo.lemma.model_processing.builtin_phases.intermediate_model_validation

import de.fhdo.lemma.model_processing.annotations.ModelProcessingPhase
import de.fhdo.lemma.model_processing.annotations.ConsumesBasicCommandLineOption
import de.fhdo.lemma.model_processing.builtin_phases.source_model_validation.SourceModelValidationPhase
import de.fhdo.lemma.model_processing.command_line.BasicOption
import de.fhdo.lemma.model_processing.phases.ModelKind
import de.fhdo.lemma.model_processing.phases.validation.AbstractModelValidationPhase

/**
 * Implementation of the model processor's intermediate model validation phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@ModelProcessingPhase("intermediate_model_validation", SourceModelValidationPhase::class)
@ConsumesBasicCommandLineOption(BasicOption.INTERMEDIATE_MODEL_FILE)
internal class IntermediateModelValidationPhase : AbstractModelValidationPhase(ModelKind.INTERMEDIATE)