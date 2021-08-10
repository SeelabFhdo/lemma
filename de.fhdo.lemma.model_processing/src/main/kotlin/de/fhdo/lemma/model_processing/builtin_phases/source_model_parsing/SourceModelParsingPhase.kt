package de.fhdo.lemma.model_processing.builtin_phases.source_model_parsing

import de.fhdo.lemma.model_processing.annotations.InitialModelProcessingPhase
import de.fhdo.lemma.model_processing.annotations.ConsumesBasicCommandLineOption
import de.fhdo.lemma.model_processing.command_line.BasicOption
import de.fhdo.lemma.model_processing.phases.AbstractModelParsingPhase
import de.fhdo.lemma.model_processing.phases.ModelKind

/**
 * Implementation of the model processor's phase for source model parsing.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@InitialModelProcessingPhase("source_model_parsing")
@ConsumesBasicCommandLineOption(BasicOption.SOURCE_MODEL_FILE)
internal class SourceModelParsingPhase : AbstractModelParsingPhase(ModelKind.SOURCE)