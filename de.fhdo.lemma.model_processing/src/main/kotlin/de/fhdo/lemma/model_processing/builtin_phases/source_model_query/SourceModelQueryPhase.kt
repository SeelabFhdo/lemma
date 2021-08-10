package de.fhdo.lemma.model_processing.builtin_phases.source_model_query

import de.fhdo.lemma.model_processing.annotations.ModelProcessingPhase
import de.fhdo.lemma.model_processing.annotations.ConsumesBasicCommandLineOption
import de.fhdo.lemma.model_processing.builtin_phases.source_model_parsing.SourceModelParsingPhase
import de.fhdo.lemma.model_processing.command_line.BasicOption
import de.fhdo.lemma.model_processing.phases.AbstractModelQueryPhase
import de.fhdo.lemma.model_processing.phases.ModelKind

/**
 * Implementation of the model processor's source model query phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@ModelProcessingPhase("source_model_query", SourceModelParsingPhase::class, false)
@ConsumesBasicCommandLineOption(BasicOption.SOURCE_MODEL_FILE)
internal class SourceModelQueryPhase : AbstractModelQueryPhase(ModelKind.SOURCE)