package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types;

import de.fhdo.lemma.eclipse.ui.ProgrammaticIntermediateModelTransformation;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Abstract superclass for argument types that are based on enumerations and point to some sort of
 * intermediate model. That is, the class provides a user validation that checks if the source model
 * selected for a given model processing configuration actually supports intermediate
 * transformations and is thus applicable with the argument type.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public abstract class AbstractIntermediateModelArgumentTypeWithEnumValue<T extends Enum<?>> extends AbstractArgumentTypeWithEnumValueSelection<T> {
  /**
   * Constructor
   */
  public AbstractIntermediateModelArgumentTypeWithEnumValue(final ArgumentTypeIdentifier identifier, final String name, final Map<T, String> validLiteralStringValues) {
    super(identifier, name, validLiteralStringValues);
  }

  /**
   * Validate the user value, i.e., the description of the literal, of an argument of this
   * enumeration-based type. Implementers may override this method to accompany user validation
   * with additional checks. However, overridden methods must invoke this method on the
   * superclass.
   */
  @Override
  public void validateValueInUserRepresentation(final ProcessingConfiguration configuration, final String literalDescription) {
    super.validateValueInUserRepresentation(configuration, literalDescription);
    final IFile sourceModelFile = configuration.getSourceModelFile();
    if (((sourceModelFile != null) && 
      (!ProgrammaticIntermediateModelTransformation.supportsTranformation(sourceModelFile)))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("kind *.");
      String _fileExtension = sourceModelFile.getFileExtension();
      _builder.append(_fileExtension);
      _builder.append(" is not supported");
      String _plus = ("Intermediate transformation of model files of " + _builder);
      throw new IllegalArgumentException(_plus);
    }
  }
}
