package de.fhdo.lemma.data.avro.ui.to_avro;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.avro.AvroGenerator;
import de.fhdo.lemma.data.avro.Shared;
import de.fhdo.lemma.data.avro.ui.Util;
import de.fhdo.lemma.data.intermediate.IntermediateComplexType;
import de.fhdo.lemma.data.intermediate.IntermediateContext;
import de.fhdo.lemma.data.intermediate.IntermediateDataModel;
import de.fhdo.lemma.data.intermediate.IntermediateVersion;
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import de.fhdo.lemma.utils.LemmaUtils;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.apache.avro.Protocol;
import org.apache.avro.Schema;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Handler to control the conversion of LEMMA models to Avro schema specification files.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class TransformToAvroHandler extends AbstractHandler {
  /**
   * Helper class to encapsulate the elements, protocol name and documentation from an instance of
   * the LemmaToAvroDialog
   */
  private static class SelectElementsDialogResult {
    private List<? extends EObject> elements;
    
    private String protocolName;
    
    private String protocolDocumentation;
    
    public SelectElementsDialogResult(final LemmaToAvroDialog dialog) {
      this.elements = dialog.getSelectedElements();
      this.protocolName = dialog.getProtocolName();
      this.protocolDocumentation = dialog.getProtocolDocumentation();
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
    boolean _notEquals = (!Objects.equal(_id, "de.fhdo.lemma.data.avro.commands.transformToAvro"));
    if (_notEquals) {
      return null;
    }
    final IFile selectedFile = Util.getSelectedFile(event);
    XMIResource _asXmiResource = null;
    if (selectedFile!=null) {
      _asXmiResource=this.asXmiResource(selectedFile);
    }
    IntermediateDataModel _intermediateDataModelRoot = null;
    if (_asXmiResource!=null) {
      _intermediateDataModelRoot=this.getIntermediateDataModelRoot(_asXmiResource);
    }
    final IntermediateDataModel selectedDataModelRoot = _intermediateDataModelRoot;
    if ((selectedDataModelRoot == null)) {
      return null;
    }
    final List<? extends EObject> initialModelElements = de.fhdo.lemma.data.avro.Util.getTopLevelComplexTypeContainers(selectedDataModelRoot);
    boolean _isEmpty = initialModelElements.isEmpty();
    if (_isEmpty) {
      Util.showError("Domain Model Load Error", "Intermediate LEMMA domain model is empty.");
      return null;
    }
    final Pair<TransformToAvroHandler.SelectElementsDialogResult, String> selectModelElementsInfo = this.selectModelElements(selectedFile, initialModelElements);
    if ((selectModelElementsInfo == null)) {
      return null;
    }
    final TransformToAvroHandler.SelectElementsDialogResult selectElementsResult = selectModelElementsInfo.getKey();
    final String avroSchemaFilepath = selectModelElementsInfo.getValue();
    boolean _avroGeneration = this.avroGeneration(selectElementsResult, avroSchemaFilepath);
    if (_avroGeneration) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(avroSchemaFilepath);
      _builder.append(".");
      String _plus = (("Selected model elements were " + 
        "successfully transformed to Avro schema specifications in file ") + _builder);
      Util.showInfo("Avro schema transformation successful", _plus);
    }
    return null;
  }
  
  /**
   * Load given IFile as XMI resource
   */
  private XMIResource asXmiResource(final IFile file) {
    XMIResource _xtrycatchfinallyexpression = null;
    try {
      _xtrycatchfinallyexpression = LemmaUiUtils.loadXmiResource(file);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        Object _xblockexpression = null;
        {
          String _errorMessageOrSimpleClassName = de.fhdo.lemma.data.avro.Util.getErrorMessageOrSimpleClassName(ex);
          String _plus = ("An error occurred while loading XMI resource: " + _errorMessageOrSimpleClassName);
          Util.showError("XMI Load Error", _plus);
          _xblockexpression = null;
        }
        _xtrycatchfinallyexpression = ((XMIResource)_xblockexpression);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  /**
   * Get root of given XMI resource as IntermediateDataModel
   */
  private IntermediateDataModel getIntermediateDataModelRoot(final XMIResource xmiResource) {
    IntermediateDataModel _xtrycatchfinallyexpression = null;
    try {
      EObject _get = xmiResource.getContents().get(0);
      _xtrycatchfinallyexpression = ((IntermediateDataModel) _get);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        Object _xblockexpression = null;
        {
          Util.showError("XMI Load Error", ("XMI resource does not represent an intermediate LEMMA " + 
            "domain model."));
          _xblockexpression = null;
        }
        _xtrycatchfinallyexpression = ((IntermediateDataModel)_xblockexpression);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  /**
   * Get the selection of source LEMMA elements to be transformed to Avro schemas as well as the
   * file path for the derived Avro schema specification file from the user
   */
  private Pair<TransformToAvroHandler.SelectElementsDialogResult, String> selectModelElements(final IFile selectedFile, final List<? extends EObject> initialModelElements) {
    final TransformToAvroHandler.SelectElementsDialogResult selectResult = this.selectElementsDialog(selectedFile.getName(), initialModelElements);
    if ((selectResult == null)) {
      return null;
    }
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(selectResult.protocolName);
    final boolean isProtocolTransformation = (!_isNullOrEmpty);
    Pair<String, String> _xifexpression = null;
    if (isProtocolTransformation) {
      String _simpleName = LemmaUtils.getSimpleName(selectResult.protocolName);
      _xifexpression = Pair.<String, String>of(_simpleName, Util.PROTOCOL_FILE_EXTENSION);
    } else {
      String _simpleName_1 = LemmaUtils.getSimpleName(de.fhdo.lemma.data.avro.Util.qualifiedName(selectResult.elements.get(0)));
      _xifexpression = Pair.<String, String>of(_simpleName_1, Util.SCHEMA_FILE_EXTENSION);
    }
    final Pair<String, String> filenameAndExtension = _xifexpression;
    final String avroSchemaFilepath = this.selectProjectFileDialog(selectedFile, filenameAndExtension.getValue(), 
      filenameAndExtension.getKey());
    boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(avroSchemaFilepath);
    if (_isNullOrEmpty_1) {
      return null;
    }
    return Pair.<TransformToAvroHandler.SelectElementsDialogResult, String>of(selectResult, avroSchemaFilepath);
  }
  
  /**
   * Let the user select the source LEMMA elements to be transformed to Avro schemas
   */
  private TransformToAvroHandler.SelectElementsDialogResult selectElementsDialog(final String modelFilename, final List<? extends EObject> initialElements) {
    final LemmaToAvroDialog dialog = new LemmaToAvroDialog(TransformToAvroHandler.SHELL, modelFilename, initialElements);
    dialog.create();
    TransformToAvroHandler.SelectElementsDialogResult _xifexpression = null;
    int _open = dialog.open();
    boolean _notEquals = (_open != Window.CANCEL);
    if (_notEquals) {
      _xifexpression = new TransformToAvroHandler.SelectElementsDialogResult(dialog);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  /**
   * Let the user specify the file path for the target Avro schema specification file
   */
  private String selectProjectFileDialog(final IFile file, final String fileExtension, final String initialFilename) {
    IProject _project = file.getProject();
    WorkbenchLabelProvider _workbenchLabelProvider = new WorkbenchLabelProvider();
    final ProjectFileSelectionDialog dialog = new ProjectFileSelectionDialog(TransformToAvroHandler.SHELL, _project, initialFilename, fileExtension, _workbenchLabelProvider);
    dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
    dialog.setMessage("Specify project-relative target file for generated Avro schemas");
    dialog.setInitialElementSelections(CollectionLiterals.<Object>newArrayList(file.getParent()));
    String _xifexpression = null;
    int _open = dialog.open();
    boolean _notEquals = (_open != Window.CANCEL);
    if (_notEquals) {
      _xifexpression = dialog.getTargetFilepath();
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  /**
   * Perform Avro schema generation from user input
   */
  private boolean avroGeneration(final TransformToAvroHandler.SelectElementsDialogResult elementSelectionResult, final String targetFilepath) {
    final List<Schema> schemas = this.generateSchemas(elementSelectionResult.elements);
    if ((schemas == null)) {
      return false;
    }
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(elementSelectionResult.protocolName);
    final boolean generateProtocol = (!_isNullOrEmpty);
    if ((!generateProtocol)) {
      this.writeToFile(schemas, targetFilepath);
    } else {
      this.writeToFile(this.generateProtocol(schemas, elementSelectionResult.protocolName, 
        elementSelectionResult.protocolDocumentation), targetFilepath);
    }
    return true;
  }
  
  /**
   * Generate Avro schemas from a list of LEMMA model elements
   */
  private List<Schema> generateSchemas(final List<? extends EObject> modelElements) {
    final ArrayList<Schema> schemas = CollectionLiterals.<Schema>newArrayList();
    for (final EObject element : modelElements) {
      try {
        schemas.addAll(this.generateSchemas(element));
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception ex = (Exception)_t;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("transform model element ");
          String _qualifiedName = de.fhdo.lemma.data.avro.Util.qualifiedName(element);
          _builder.append(_qualifiedName);
          _builder.append(" to an Avro schema: ");
          String _plus = ("An error occurred while trying to " + _builder);
          String _errorMessageOrSimpleClassName = de.fhdo.lemma.data.avro.Util.getErrorMessageOrSimpleClassName(ex);
          String _plus_1 = (_plus + _errorMessageOrSimpleClassName);
          Util.showError("Avro schema transformation error", _plus_1);
          return null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    return schemas;
  }
  
  /**
   * Generate Avro schemas from single LEMMA model element
   */
  private List<Schema> generateSchemas(final EObject eObject) {
    List<Schema> _switchResult = null;
    boolean _matched = false;
    if (eObject instanceof IntermediateVersion) {
      _matched=true;
      _switchResult = new AvroGenerator().generateSchemasFrom(((IntermediateVersion)eObject));
    }
    if (!_matched) {
      if (eObject instanceof IntermediateContext) {
        _matched=true;
        _switchResult = new AvroGenerator().generateSchemasFrom(((IntermediateContext)eObject));
      }
    }
    if (!_matched) {
      if (eObject instanceof IntermediateComplexType) {
        _matched=true;
        ArrayList<Schema> _xblockexpression = null;
        {
          final Schema typeSchema = new AvroGenerator().generateSchemasFrom(((IntermediateComplexType)eObject)).getKey();
          _xblockexpression = CollectionLiterals.<Schema>newArrayList(typeSchema);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      _switchResult = CollectionLiterals.<Schema>emptyList();
    }
    final List<Schema> schemas = _switchResult;
    final Function1<Schema, Boolean> _function = (Schema it) -> {
      return Boolean.valueOf(Shared.isNamedSchema(it));
    };
    return IterableExtensions.<Schema>toList(IterableExtensions.<Schema>filter(schemas, _function));
  }
  
  /**
   * Serialize a list of Avro schemas to a file
   */
  private void writeToFile(final List<Schema> schemas, final String targetFilepath) {
    try {
      try (final PrintStream out = new Function0<PrintStream>() {
        @Override
        public PrintStream apply() {
          try {
            FileOutputStream _fileOutputStream = new FileOutputStream(targetFilepath);
            return new PrintStream(_fileOutputStream);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      }.apply()) {
        final Consumer<Schema> _function = (Schema it) -> {
          out.println(it.toString(true));
        };
        schemas.forEach(_function);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Generate an Avro protocol from the given list of Avro schemas
   */
  private Protocol generateProtocol(final List<Schema> schemas, final String protocolName, final String protocolDocumentation) {
    final String name = LemmaUtils.getSimpleName(protocolName);
    final String namespace = LemmaUtils.getQualifyingParts(protocolName);
    return new AvroGenerator().toProtocol(schemas, name, protocolDocumentation, namespace);
  }
  
  /**
   * Serialize Avro protocol to a file
   */
  private void writeToFile(final Protocol protocol, final String targetFilepath) {
    try {
      Files.write(Paths.get(targetFilepath), protocol.toString(true).getBytes());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
