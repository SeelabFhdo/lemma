package de.fhdo.lemma.model_processing.builtin_phases.source_model_validation

import de.fhdo.lemma.model_processing.annotations.ModelProcessingPhase
import de.fhdo.lemma.model_processing.annotations.ConsumesBasicCommandLineOption
import de.fhdo.lemma.model_processing.builtin_phases.find_model_validators.FindModelValidatorsPhase
import de.fhdo.lemma.model_processing.command_line.BasicOption
import de.fhdo.lemma.model_processing.phases.ModelKind
import de.fhdo.lemma.model_processing.phases.validation.AbstractModelValidationPhase

/**
 * Implementation of the model processor's source model validation phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@ModelProcessingPhase("source_model_validation", FindModelValidatorsPhase::class)
@ConsumesBasicCommandLineOption(BasicOption.SOURCE_MODEL_FILE)
internal class SourceModelValidationPhase : AbstractModelValidationPhase(ModelKind.SOURCE)