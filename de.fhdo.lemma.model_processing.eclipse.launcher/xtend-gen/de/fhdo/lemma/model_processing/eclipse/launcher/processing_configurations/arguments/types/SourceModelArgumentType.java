package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types;

import java.util.Collections;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Type of arguments representing the source model file specified for a model processing
 * configuration.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class SourceModelArgumentType extends AbstractArgumentTypeWithEnumValueSelection<SourceModelKind> {
  public static final ArgumentTypeIdentifier IDENTIFIER = ArgumentTypeIdentifier.SOURCE_MODEL;
  
  private static final Map<SourceModelKind, String> LITERAL_DESCRIPTIONS = Collections.<SourceModelKind, String>unmodifiableMap(CollectionLiterals.<SourceModelKind, String>newHashMap(Pair.<SourceModelKind, String>of(SourceModelKind.SELECTED_FILE, "Selected model file")));
  
  /**
   * Constructor
   */
  public SourceModelArgumentType() {
    super(SourceModelArgumentType.IDENTIFIER, "Source model", SourceModelArgumentType.LITERAL_DESCRIPTIONS);
  }
}
