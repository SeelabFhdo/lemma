package de.fhdo.lemma.data.avro.ui.to_lemma;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.data.avro.LemmaGenerator;
import de.fhdo.lemma.data.avro.Shared;
import de.fhdo.lemma.data.avro.ui.Util;
import de.fhdo.lemma.data.datadsl.extractor.DataDslExtractor;
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.technology.mapping.TechnologyMapping;
import de.fhdo.lemma.technology.mappingdsl.extractor.MappingDslExtractor;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.apache.avro.JsonProperties;
import org.apache.avro.Protocol;
import org.apache.avro.Schema;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Handler to control the conversion of Avro schema specification files to LEMMA models.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class TransformToLemmaHandler extends AbstractHandler {
  /**
   * Helper class to represent schema parsing results
   */
  private static class SchemasParsingResult {
    private List<Schema> schemas = CollectionLiterals.<Schema>emptyList();
    
    private String name = "";
    
    private String namespace = "";
    
    private String documentation = "";
    
    private Protocol protocol;
    
    /**
     * Constructor from Schema instance
     */
    public SchemasParsingResult(final Schema schema) {
      if ((schema == null)) {
        return;
      }
      List<Schema> _xifexpression = null;
      Schema.Type _type = schema.getType();
      boolean _equals = Objects.equal(_type, Schema.Type.UNION);
      if (_equals) {
        _xifexpression = schema.getTypes();
      } else {
        _xifexpression = CollectionLiterals.<Schema>newArrayList(schema);
      }
      this.schemas = _xifexpression;
      int _size = this.schemas.size();
      boolean _tripleEquals = (_size == 1);
      if (_tripleEquals) {
        this.name = schema.getName();
        this.namespace = schema.getNamespace();
        this.documentation = schema.getDoc();
      }
    }
    
    /**
     * Constructor from Protocol instance
     */
    public SchemasParsingResult(final Protocol protocol) {
      if ((protocol == null)) {
        return;
      }
      this.schemas = IterableExtensions.<Schema>toList(protocol.getTypes());
      this.name = protocol.getName();
      this.namespace = protocol.getNamespace();
      this.documentation = protocol.getDoc();
      this.protocol = protocol;
    }
  }
  
  /**
   * Current shell
   */
  private static final Shell SHELL = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
  
  /**
   * Execute handler
   */
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    String _id = event.getCommand().getId();
    boolean _notEquals = (!Objects.equal(_id, "de.fhdo.lemma.data.avro.commands.transformToLemma"));
    if (_notEquals) {
      return null;
    }
    final IFile selectedFile = Util.getSelectedFile(event);
    TransformToLemmaHandler.SchemasParsingResult _xtrycatchfinallyexpression = null;
    try {
      _xtrycatchfinallyexpression = this.parseSchemas(selectedFile);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        StringConcatenation _builder = new StringConcatenation();
        {
          boolean _isProtocol = this.isProtocol(selectedFile);
          if (_isProtocol) {
            _builder.append("protocol");
          } else {
            _builder.append("schema");
          }
        }
        _builder.append(": ");
        String _plus = ("An error occurred while parsing Avro " + _builder);
        String _errorMessageOrSimpleClassName = de.fhdo.lemma.data.avro.Util.getErrorMessageOrSimpleClassName(ex);
        String _plus_1 = (_plus + _errorMessageOrSimpleClassName);
        Util.showError("Schema Parsing Error", _plus_1);
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    final TransformToLemmaHandler.SchemasParsingResult parsingResult = _xtrycatchfinallyexpression;
    boolean _isEmpty = parsingResult.schemas.isEmpty();
    if (_isEmpty) {
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isProtocol = this.isProtocol(selectedFile);
        if (_isProtocol) {
          _builder.append("protocol");
        } else {
          _builder.append("schema");
        }
      }
      _builder.append(".");
      String _plus = ("No named Avro types found in Avro " + _builder);
      Util.showError("Schema Parsing Error", _plus);
      return null;
    }
    final Object selectedElements = this.selectElementsForTransformationDialog(
      selectedFile.getName(), 
      parsingResult.name, 
      parsingResult.namespace, 
      parsingResult.documentation, 
      parsingResult.schemas, 
      parsingResult.protocol);
    if ((selectedElements == null)) {
      return null;
    } else {
      if ((selectedElements instanceof List)) {
        boolean _isEmpty_1 = ((List)selectedElements).isEmpty();
        if (_isEmpty_1) {
          return null;
        }
      }
    }
    final Map<Class<? extends EObject>, Pair<String, String>> modelKindTargetPaths = this.specifyModelKindPathsDialog(selectedFile);
    if ((modelKindTargetPaths == null)) {
      return null;
    }
    final List<String> generatedLemmaModels = this.lemmaGeneration(selectedElements, modelKindTargetPaths);
    if ((generatedLemmaModels != null)) {
      String _join = IterableExtensions.join(generatedLemmaModels, "\n\t- ");
      String _plus_1 = ("\n\t- " + _join);
      final String generatedLemmaModelsString = (_plus_1 + "\n\n");
      Util.showInfo("LEMMA model transformation successful", (("Selected schemas were " + 
        "successfully transformed to the following LEMMA model files: ") + generatedLemmaModelsString));
    }
    return null;
  }
  
  /**
   * Parse Avro schemas from IFile
   */
  private TransformToLemmaHandler.SchemasParsingResult parseSchemas(final IFile file) {
    Function<File, JsonProperties> _xifexpression = null;
    boolean _isProtocol = this.isProtocol(file);
    if (_isProtocol) {
      final Function<File, JsonProperties> _function = (File it) -> {
        try {
          return Protocol.parse(it);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      _xifexpression = _function;
    } else {
      final Function<File, JsonProperties> _function_1 = (File it) -> {
        try {
          return new Schema.Parser().parse(it);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      _xifexpression = _function_1;
    }
    final Function<File, JsonProperties> parseFunction = _xifexpression;
    final JsonProperties parsedJsonProperties = parseFunction.apply(file.getLocation().toFile());
    TransformToLemmaHandler.SchemasParsingResult _switchResult = null;
    boolean _matched = false;
    if (parsedJsonProperties instanceof Schema) {
      _matched=true;
      _switchResult = new TransformToLemmaHandler.SchemasParsingResult(((Schema)parsedJsonProperties));
    }
    if (!_matched) {
      if (parsedJsonProperties instanceof Protocol) {
        _matched=true;
        _switchResult = new TransformToLemmaHandler.SchemasParsingResult(((Protocol)parsedJsonProperties));
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  /**
   * Check if the given IFile is expected to represent an Avro protocol depending on its extension
   */
  private boolean isProtocol(final IFile file) {
    return LemmaUiUtils.hasExtension(file, Util.PROTOCOL_FILE_EXTENSION);
  }
  
  /**
   * Display Avro-to-LEMMA dialog to user and return the results
   */
  private Object selectElementsForTransformationDialog(final String avroFilename, final String schemaName, final String schemaNamespace, final String schemaDocumentation, final List<Schema> initialSchemas, final Protocol protocol) {
    final AvroToLemmaDialog dialog = new AvroToLemmaDialog(TransformToLemmaHandler.SHELL, avroFilename, schemaName, schemaNamespace, schemaDocumentation, initialSchemas, protocol);
    dialog.create();
    Object _switchResult = null;
    int _open = dialog.open();
    boolean _matched = false;
    if (Objects.equal(_open, Window.CANCEL)) {
      _matched=true;
      _switchResult = null;
    }
    if (!_matched) {
      Protocol _selectedProtocol = dialog.getSelectedProtocol();
      boolean _tripleNotEquals = (_selectedProtocol != null);
      if (_tripleNotEquals) {
        _matched=true;
        _switchResult = dialog.getSelectedProtocol();
      }
    }
    if (!_matched) {
      _switchResult = dialog.getSelectedSchemas();
    }
    return _switchResult;
  }
  
  /**
   * Display LEMMA paths specification dialog to user and return the results
   */
  private Map<Class<? extends EObject>, Pair<String, String>> specifyModelKindPathsDialog(final IFile file) {
    IContainer _parent = file.getParent();
    final SpecifyLemmaPathsDialog dialog = new SpecifyLemmaPathsDialog(TransformToLemmaHandler.SHELL, _parent);
    dialog.create();
    Map<Class<? extends EObject>, Pair<String, String>> _switchResult = null;
    int _open = dialog.open();
    switch (_open) {
      case Window.CANCEL:
        _switchResult = null;
        break;
      default:
        _switchResult = dialog.getModelKindPaths();
        break;
    }
    return _switchResult;
  }
  
  /**
   * Generate LEMMA models
   */
  private List<String> lemmaGeneration(final Object source, final Map<Class<? extends EObject>, Pair<String, String>> modelKindTargetPaths) {
    final String serviceModelPath = this.fullModelPath(modelKindTargetPaths, ServiceModel.class);
    final String avroModelPath = this.fullModelPath(modelKindTargetPaths, Technology.class);
    final Pair<DataModel, TechnologyMapping> generatedDataAndMappingModel = this.generateModelsFrom(source, serviceModelPath, avroModelPath);
    final ArrayList<String> writtenProjectRelativeFilepaths = CollectionLiterals.<String>newArrayList();
    boolean _writeFile = this.writeFile(avroModelPath, Shared.StaticAvroTechnologyModel.content());
    if (_writeFile) {
      writtenProjectRelativeFilepaths.add(this.relativeModelPath(modelKindTargetPaths, Technology.class));
    }
    final DataModel generatedDataModel = generatedDataAndMappingModel.getKey();
    final String dataModelPath = this.fullModelPath(modelKindTargetPaths, DataModel.class);
    boolean _writeModel = this.writeModel(generatedDataModel, dataModelPath);
    if (_writeModel) {
      writtenProjectRelativeFilepaths.add(this.relativeModelPath(modelKindTargetPaths, DataModel.class));
    }
    final TechnologyMapping generatedMappingModel = generatedDataAndMappingModel.getValue();
    final String mappingModelPath = this.fullModelPath(modelKindTargetPaths, TechnologyMapping.class);
    boolean _writeModel_1 = this.writeModel(generatedMappingModel, mappingModelPath);
    if (_writeModel_1) {
      writtenProjectRelativeFilepaths.add(
        this.relativeModelPath(modelKindTargetPaths, TechnologyMapping.class));
    }
    return writtenProjectRelativeFilepaths;
  }
  
  /**
   * Retrieve the full path of a model kind from a list of model kind paths
   */
  private String fullModelPath(final Map<Class<? extends EObject>, Pair<String, String>> modelKindPaths, final Class<? extends EObject> modelKind) {
    String _elvis = null;
    Pair<String, String> _get = modelKindPaths.get(modelKind);
    String _value = null;
    if (_get!=null) {
      _value=_get.getValue();
    }
    if (_value != null) {
      _elvis = _value;
    } else {
      _elvis = "";
    }
    return _elvis;
  }
  
  /**
   * Generate LEMMA models from the given source, which may either be a Protocol instance or a
   * list of Avro schemas
   */
  private Pair<DataModel, TechnologyMapping> generateModelsFrom(final Object source, final String serviceModelPath, final String avroModelPath) {
    final LemmaGenerator generator = new LemmaGenerator();
    Pair<DataModel, TechnologyMapping> _xtrycatchfinallyexpression = null;
    try {
      Pair<DataModel, TechnologyMapping> _xifexpression = null;
      if ((source instanceof Protocol)) {
        _xifexpression = generator.generateModelsFrom(((Protocol)source), serviceModelPath, avroModelPath);
      } else {
        Pair<DataModel, TechnologyMapping> _xblockexpression = null;
        {
          final List<Schema> schemas = ((List<Schema>) source);
          _xblockexpression = generator.generateModelsFrom(schemas, serviceModelPath, avroModelPath);
        }
        _xifexpression = _xblockexpression;
      }
      _xtrycatchfinallyexpression = _xifexpression;
    } catch (final Throwable _t) {
      if (_t instanceof ClassCastException) {
        final ClassCastException ex = (ClassCastException)_t;
        Object _xblockexpression_1 = null;
        {
          String _errorMessageOrSimpleClassName = de.fhdo.lemma.data.avro.Util.getErrorMessageOrSimpleClassName(ex);
          String _plus = (("An error occurred while transforming " + 
            "selected schemas to LEMMA models: ") + _errorMessageOrSimpleClassName);
          Util.showError("LEMMA model transformation error", _plus);
          _xblockexpression_1 = null;
        }
        _xtrycatchfinallyexpression = ((Pair<DataModel, TechnologyMapping>)_xblockexpression_1);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  /**
   * Retrieve the project-relative path of a model kind from a list of model kind paths
   */
  private String relativeModelPath(final Map<Class<? extends EObject>, Pair<String, String>> modelKindPaths, final Class<? extends EObject> modelKind) {
    String _elvis = null;
    Pair<String, String> _get = modelKindPaths.get(modelKind);
    String _key = null;
    if (_get!=null) {
      _key=_get.getKey();
    }
    if (_key != null) {
      _elvis = _key;
    } else {
      _elvis = "";
    }
    return _elvis;
  }
  
  /**
   * Write string contents to the given file path. Returns true if the file path and the contents
   * are not empty.
   */
  private boolean writeFile(final String filepath, final String content) {
    try {
      if ((StringExtensions.isNullOrEmpty(filepath) || StringExtensions.isNullOrEmpty(content))) {
        return false;
      }
      Files.write(Paths.get(filepath), content.getBytes());
      return true;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Serialize a LEMMA data or mapping model to the given file path. Returns true if the file path
   * and the contents extracted from the model's root are not empty.
   */
  private boolean writeModel(final EObject modelRoot, final String filepath) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(filepath);
    if (_isNullOrEmpty) {
      return false;
    }
    String _switchResult = null;
    boolean _matched = false;
    if (modelRoot instanceof DataModel) {
      _matched=true;
      _switchResult = new DataDslExtractor().extractToString(((DataModel)modelRoot));
    }
    if (!_matched) {
      if (modelRoot instanceof TechnologyMapping) {
        _matched=true;
        _switchResult = new MappingDslExtractor().extractToString(((TechnologyMapping)modelRoot));
      }
    }
    final String content = _switchResult;
    return this.writeFile(filepath, content);
  }
}
