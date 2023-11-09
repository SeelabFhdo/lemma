package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types;

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Type of arguments representing existing, regular files.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class FileArgumentType extends AbstractArgumentType {
  public static final ArgumentTypeIdentifier IDENTIFIER = ArgumentTypeIdentifier.FILE;

  /**
   * Constructor
   */
  public FileArgumentType() {
    super(FileArgumentType.IDENTIFIER, "File");
  }

  /**
   * Validate the type-specific argument value in its internal representation, i.e., the path to
   * the file
   */
  @Override
  public final void validateValueInInternalRepresentation(final ProcessingConfiguration processingConfiguration, final String filepath) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(filepath);
    if (_isNullOrEmpty) {
      throw new IllegalArgumentException("Please select a file");
    } else {
      boolean _isRegularFile = Files.isRegularFile(Paths.get(filepath));
      boolean _not = (!_isRegularFile);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("File \"");
        _builder.append(filepath);
        _builder.append("\" does not exist");
        throw new IllegalArgumentException(_builder.toString());
      }
    }
  }
}
