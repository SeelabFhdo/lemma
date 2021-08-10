package de.fhdo.lemma.model_processing.builtin_phases.intermediate_model_parsing

import de.fhdo.lemma.model_processing.annotations.ModelProcessingPhase
import de.fhdo.lemma.model_processing.annotations.ConsumesBasicCommandLineOption
import de.fhdo.lemma.model_processing.builtin_phases.source_model_query.SourceModelQueryPhase
import de.fhdo.lemma.model_processing.command_line.BasicOption
import de.fhdo.lemma.model_processing.phases.AbstractModelParsingPhase
import de.fhdo.lemma.model_processing.phases.ModelKind

/**
 * Implementation of the model processor's phase for intermediate model parsing.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@ModelProcessingPhase("intermediate_model_parsing", SourceModelQueryPhase::class, false)
@ConsumesBasicCommandLineOption(BasicOption.INTERMEDIATE_MODEL_FILE)
internal class IntermediateModelParsingPhase : AbstractModelParsingPhase(ModelKind.INTERMEDIATE)