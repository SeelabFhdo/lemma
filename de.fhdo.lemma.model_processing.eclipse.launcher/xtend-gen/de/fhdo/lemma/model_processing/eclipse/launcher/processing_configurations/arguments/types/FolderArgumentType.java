package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types;

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Type of arguments representing existing folders.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class FolderArgumentType extends AbstractArgumentType {
  public static final ArgumentTypeIdentifier IDENTIFIER = ArgumentTypeIdentifier.FOLDER;
  
  /**
   * Constructor
   */
  public FolderArgumentType() {
    super(FolderArgumentType.IDENTIFIER, "Folder");
  }
  
  /**
   * Validate the type-specific argument value in its internal representation, i.e., the path to
   * the folder
   */
  @Override
  public final void validateValueInInternalRepresentation(final ProcessingConfiguration processingConfiguration, final String folderPath) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(folderPath);
    if (_isNullOrEmpty) {
      throw new IllegalArgumentException("Please select a folder");
    } else {
      boolean _isDirectory = Files.isDirectory(Paths.get(folderPath));
      boolean _not = (!_isDirectory);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Folder \"");
        _builder.append(folderPath);
        _builder.append("\" does not exist");
        throw new IllegalArgumentException(_builder.toString());
      }
    }
  }
}
