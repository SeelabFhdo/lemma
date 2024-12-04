package de.fhdo.lemma.reconstruction.ui;

import com.google.inject.Injector;
import de.fhdo.lemma.data.DataDslStandaloneSetup;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.data.DataPackage;
import de.fhdo.lemma.data.datadsl.extractor.DataDslExtractor;
import de.fhdo.lemma.reconstruction.MongoDbRepository;
import de.fhdo.lemma.reconstruction.domain.Context;
import de.fhdo.lemma.reconstruction.domain.LemmaDomainGenerator;
import de.fhdo.lemma.reconstruction.util.Util;
import de.fhdo.lemma.utils.LemmaUtils;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Handler for orchestrating the reconstruction process of LEMMA models
 * from a MongoDB based on recovered architecture information from the
 * Microservice Reconstruction Framework.
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@SuppressWarnings("all")
public class LemmaReconstructionHandler extends AbstractHandler {
  /**
   * Current shell
   */
  private static final Shell SHELL = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

  private String mongoDbHostname;

  private String mongoDbPort;

  private List<Context> initialContexts;

  private List<Context> selectedContexts;

  private String reconstructionPath;

  private List<DataModel> domainDataModels;

  /**
   * Executing the model generation process
   */
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    this.init();
    this.receiveMongoDbEndpoints();
    this.loadContextInformationFromMongoDb();
    this.displayReconstructionInforation();
    this.selectTargetFolderForModelGeneration();
    this.generateModels();
    this.writeModelsToFolder();
    this.showReconstructionInformationMessage();
    this.resetDialogHandler();
    return null;
  }

  /**
   * Initialize the content for the model creation
   */
  private List<DataModel> init() {
    List<DataModel> _xblockexpression = null;
    {
      this.initialContexts = CollectionLiterals.<Context>newLinkedList();
      this.selectedContexts = CollectionLiterals.<Context>newLinkedList();
      _xblockexpression = this.domainDataModels = CollectionLiterals.<DataModel>newLinkedList();
    }
    return _xblockexpression;
  }

  /**
   * Load MongoDB configuration from the UI dialog
   */
  private String receiveMongoDbEndpoints() {
    String _xblockexpression = null;
    {
      final LemmaReconstructionDialog dialog = new LemmaReconstructionDialog(LemmaReconstructionHandler.SHELL);
      dialog.create();
      dialog.open();
      this.mongoDbHostname = dialog.getMongoDbHostname();
      _xblockexpression = this.mongoDbPort = dialog.getMongoDbPort();
    }
    return _xblockexpression;
  }

  /**
   * Display the reconstructed architecture information, loaded from the database
   */
  private List<Context> displayReconstructionInforation() {
    List<Context> _xblockexpression = null;
    {
      final LemmaReconstructionResultsDialog dialog = new LemmaReconstructionResultsDialog(LemmaReconstructionHandler.SHELL, this.initialContexts);
      dialog.create();
      dialog.open();
      _xblockexpression = this.selectedContexts = dialog.getSelectedContexts();
    }
    return _xblockexpression;
  }

  /**
   * Load reconstructed domain information from the MongoDB database
   */
  private boolean loadContextInformationFromMongoDb() {
    boolean _xblockexpression = false;
    {
      int _parseInt = Integer.parseInt(this.mongoDbPort);
      final MongoDbRepository repository = new MongoDbRepository(this.mongoDbHostname, _parseInt);
      _xblockexpression = this.initialContexts.addAll(repository.getReconstructedContexts());
    }
    return _xblockexpression;
  }

  /**
   * UI dialog for selecting folder to save the generated LEMMA model in
   */
  private String selectTargetFolderForModelGeneration() {
    String _xblockexpression = null;
    {
      final DirectoryDialog fileDialog = new DirectoryDialog(LemmaReconstructionHandler.SHELL, SWT.OPEN);
      _xblockexpression = this.reconstructionPath = fileDialog.open();
    }
    return _xblockexpression;
  }

  /**
   * Generate the models based on the previous selection
   */
  private void generateModels() {
    boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(this.selectedContexts);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      this.generateDomainModels();
    }
  }

  /**
   * Generate LEMMA domain models
   */
  private void generateDomainModels() {
    final LemmaDomainGenerator generator = new LemmaDomainGenerator();
    final Consumer<Context> _function = (Context it) -> {
      CollectionExtensions.<DataModel>addAll(this.domainDataModels, generator.generateDataModel(it));
    };
    this.selectedContexts.forEach(_function);
  }

  /**
   * Write LEMMA models to the selected folder
   */
  private void writeModelsToFolder() {
    final Consumer<DataModel> _function = (DataModel it) -> {
      this.writeDomainDataModel(it);
    };
    this.domainDataModels.forEach(_function);
  }

  /**
   * Configuration and specific execution to write LEMMA domain models to the selected folder
   */
  private Path writeDomainDataModel(final DataModel model) {
    try {
      Path _xblockexpression = null;
      {
        final String dataModel = new DataDslExtractor().extractToString(model);
        final String fileName = model.getContexts().get(0).getName();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(this.reconstructionPath);
        _builder.append(File.separator);
        _builder.append("domain");
        _builder.append(File.separator);
        _builder.append(fileName);
        _builder.append(".data");
        final String filePath = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(this.reconstructionPath);
        _builder_1.append(File.separator);
        _builder_1.append("domain");
        Files.createDirectories(Paths.get(_builder_1.toString()));
        Files.write(Paths.get(filePath), dataModel.getBytes());
        _xblockexpression = this.validateDataModel(filePath);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Validated the created LEMMA domain model and adjust potential issues
   */
  private Path validateDataModel(final String path) {
    try {
      Path _xblockexpression = null;
      {
        EPackage.Registry.INSTANCE.put(DataPackage.eNS_URI, DataPackage.eINSTANCE);
        final DataDslStandaloneSetup setup = new DataDslStandaloneSetup();
        final Injector injector = setup.createInjectorAndDoEMFRegistration();
        final XtextResourceSet resourceSet = injector.<XtextResourceSet>getInstance(XtextResourceSet.class);
        final String uri = LemmaUtils.convertToAbsoluteFileUri(URI.createURI(path).toString(), path);
        Resource _createResource = resourceSet.createResource(URI.createURI(uri));
        final XtextResource resource = ((XtextResource) _createResource);
        FileInputStream _fileInputStream = new FileInputStream(path);
        resource.load(_fileInputStream, resourceSet.getLoadOptions());
        final IResourceValidator validator = resource.getResourceServiceProvider().getResourceValidator();
        final List<Issue> issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
        Path _xifexpression = null;
        boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(issues);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          Path _xblockexpression_1 = null;
          {
            final List<String> maskedModel = Util.maskModel(path, issues);
            _xblockexpression_1 = Files.write(Path.of(path), maskedModel, Charset.defaultCharset());
          }
          _xifexpression = _xblockexpression_1;
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Display the information about the generated LEMMA models
   */
  private void showReconstructionInformationMessage() {
    final String title = "Reconstruction Information Message";
    final LinkedList<String> generatedLemmaModels = CollectionLiterals.<String>newLinkedList();
    final Consumer<DataModel> _function = (DataModel models) -> {
      final Consumer<de.fhdo.lemma.data.Context> _function_1 = (de.fhdo.lemma.data.Context context) -> {
        StringConcatenation _builder = new StringConcatenation();
        String _name = context.getName();
        _builder.append(_name);
        _builder.append(".data");
        generatedLemmaModels.add(_builder.toString());
      };
      models.getContexts().forEach(_function_1);
    };
    this.domainDataModels.forEach(_function);
    final String messageText = "Generated Models:";
    String _join = IterableExtensions.join(generatedLemmaModels, "\n\t- ");
    String _plus = ((messageText + "\n\t- ") + _join);
    final String messageModels = (_plus + "\n\n");
    this.showInfoDialogMessage(title, messageModels);
  }

  /**
   * Handle dialog about the generated models
   */
  private void showInfoDialogMessage(final String title, final String message) {
    MessageDialog.openInformation(LemmaReconstructionHandler.SHELL, title, message);
  }

  /**
   * Reset model all model creation dialogs
   */
  private void resetDialogHandler() {
    this.initialContexts.clear();
    this.selectedContexts.clear();
    this.domainDataModels.clear();
  }
}
