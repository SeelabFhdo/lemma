package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types;

import java.util.Collections;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Type of arguments representing intermediate models.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class IntermediateModelArgumentType extends AbstractIntermediateModelArgumentTypeWithEnumValue<IntermediateModelKind> {
  public static final ArgumentTypeIdentifier IDENTIFIER = ArgumentTypeIdentifier.INTERMEDIATE_MODEL;

  private static final Map<IntermediateModelKind, String> LITERAL_DESCRIPTIONS = Collections.<IntermediateModelKind, String>unmodifiableMap(CollectionLiterals.<IntermediateModelKind, String>newHashMap(Pair.<IntermediateModelKind, String>of(IntermediateModelKind.SELECTED_FILE, "Intermediate representation of selected model file")));

  /**
   * Constructor
   */
  public IntermediateModelArgumentType() {
    super(IntermediateModelArgumentType.IDENTIFIER, "Intermediate model", IntermediateModelArgumentType.LITERAL_DESCRIPTIONS);
  }
}
