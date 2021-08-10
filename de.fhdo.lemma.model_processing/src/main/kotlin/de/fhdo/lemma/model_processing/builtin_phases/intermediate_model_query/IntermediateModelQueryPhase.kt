package de.fhdo.lemma.model_processing.builtin_phases.intermediate_model_query

import de.fhdo.lemma.model_processing.annotations.ModelProcessingPhase
import de.fhdo.lemma.model_processing.annotations.ConsumesBasicCommandLineOption
import de.fhdo.lemma.model_processing.builtin_phases.intermediate_model_parsing.IntermediateModelParsingPhase
import de.fhdo.lemma.model_processing.command_line.BasicOption
import de.fhdo.lemma.model_processing.phases.AbstractModelQueryPhase
import de.fhdo.lemma.model_processing.phases.ModelKind

/**
 * Implementation of the model processor's intermediate model query phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@ModelProcessingPhase("intermediate_model_query", IntermediateModelParsingPhase::class, false)
@ConsumesBasicCommandLineOption(BasicOption.INTERMEDIATE_MODEL_FILE)
internal class IntermediateModelQueryPhase : AbstractModelQueryPhase(ModelKind.INTERMEDIATE)