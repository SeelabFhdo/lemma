package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types;

import com.google.common.collect.Iterables;
import de.fhdo.lemma.eclipse.ui.ModelFileTypeDescription;
import de.fhdo.lemma.eclipse.ui.OperationModelTransformationStrategy;
import de.fhdo.lemma.eclipse.ui.ProgrammaticIntermediateModelTransformation;
import de.fhdo.lemma.eclipse.ui.ServiceModelTransformationStrategy;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Type of arguments representing intermediate models of LEMMA models that are the first imports
 * of other LEMMA models.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class IntermediateModelOfFirstImportArgumentType extends AbstractIntermediateModelArgumentTypeWithEnumValue<ImportedIntermediateModelKind> {
  public static final ArgumentTypeIdentifier IDENTIFIER = ArgumentTypeIdentifier.INTERMEDIATE_MODEL_OF_IMPORT;
  
  private static final Map<ImportedIntermediateModelKind, String> LITERAL_DESCRIPTIONS = Collections.<ImportedIntermediateModelKind, String>unmodifiableMap(CollectionLiterals.<ImportedIntermediateModelKind, String>newHashMap(Pair.<ImportedIntermediateModelKind, String>of(ImportedIntermediateModelKind.FIRST_DOMAIN_MODEL, "Intermediate representation of first imported data model"), Pair.<ImportedIntermediateModelKind, String>of(ImportedIntermediateModelKind.FIRST_OPERATION_MODEL, "Intermediate representation of first imported operation model"), Pair.<ImportedIntermediateModelKind, String>of(ImportedIntermediateModelKind.FIRST_SERVICE_MODEL, "Intermediate representation of first imported service model")));
  
  /**
   * Constructor
   */
  public IntermediateModelOfFirstImportArgumentType() {
    super(IntermediateModelOfFirstImportArgumentType.IDENTIFIER, "Intermediate model of first import", IntermediateModelOfFirstImportArgumentType.LITERAL_DESCRIPTIONS);
  }
  
  /**
   * Validate the user value. Next to the validation implemented by the superclass, this
   * validation method also checks if the source model kind of the given model processing
   * configuration provides support for intermediate transformation of the specified kind of the
   * first imported model.
   */
  @Override
  public final void validateValueInUserRepresentation(final ProcessingConfiguration configuration, final String literalDescription) {
    super.validateValueInUserRepresentation(configuration, literalDescription);
    IFile _sourceModelFile = configuration.getSourceModelFile();
    String _fileExtension = null;
    if (_sourceModelFile!=null) {
      _fileExtension=_sourceModelFile.getFileExtension();
    }
    final String sourceModelFileExtension = _fileExtension;
    if ((sourceModelFileExtension == null)) {
      return;
    }
    final Function1<ModelFileTypeDescription, List<String>> _function = (ModelFileTypeDescription it) -> {
      return it.getExtensions();
    };
    final Iterable<String> transformableFileExtensions = Iterables.<String>concat(IterableExtensions.<ModelFileTypeDescription, List<String>>map(ProgrammaticIntermediateModelTransformation.getTransformationStrategy(sourceModelFileExtension).getModelFileTypeDescriptions().values(), _function));
    final ImportedIntermediateModelKind intermediateModelKind = ImportedIntermediateModelKind.valueOf(this.getLiteralName(literalDescription));
    List<String> _switchResult = null;
    if (intermediateModelKind != null) {
      switch (intermediateModelKind) {
        case FIRST_DOMAIN_MODEL:
          _switchResult = ServiceModelTransformationStrategy.DATA_MODEL_FILE_EXTENSIONS;
          break;
        case FIRST_OPERATION_MODEL:
          _switchResult = OperationModelTransformationStrategy.OPERATION_MODEL_FILE_EXTENSIONS;
          break;
        case FIRST_SERVICE_MODEL:
          _switchResult = ServiceModelTransformationStrategy.SERVICE_MODEL_FILE_EXTENSIONS;
          break;
        default:
          break;
      }
    }
    final List<String> importedModelFileExtensions = _switchResult;
    final Function1<String, Boolean> _function_1 = (String it) -> {
      return Boolean.valueOf(importedModelFileExtensions.contains(it));
    };
    boolean _exists = IterableExtensions.<String>exists(transformableFileExtensions, _function_1);
    if (_exists) {
      return;
    }
    String _xifexpression = null;
    int _size = importedModelFileExtensions.size();
    boolean _equals = (_size == 1);
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("kind *.");
      String _get = importedModelFileExtensions.get(0);
      _builder.append(_get);
      _xifexpression = _builder.toString();
    } else {
      final Function1<String, String> _function_2 = (String it) -> {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("*.");
        _builder_1.append(it);
        return _builder_1.toString();
      };
      String _join = IterableExtensions.join(ListExtensions.<String, String>map(importedModelFileExtensions, _function_2), ", ");
      _xifexpression = ("kinds " + _join);
    }
    final String kindHint = _xifexpression;
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("support transformation of imported model files of ");
    _builder_1.append(kindHint);
    String _plus = ("Source model intermediate transformation does not " + _builder_1);
    throw new IllegalArgumentException(_plus);
  }
}
