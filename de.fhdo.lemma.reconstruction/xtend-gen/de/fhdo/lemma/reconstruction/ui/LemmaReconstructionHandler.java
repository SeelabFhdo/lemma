package de.fhdo.lemma.reconstruction.ui;

import com.google.inject.Injector;
import de.fhdo.lemma.ServiceDslStandaloneSetup;
import de.fhdo.lemma.data.DataDslStandaloneSetup;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.data.DataPackage;
import de.fhdo.lemma.data.datadsl.extractor.DataDslExtractor;
import de.fhdo.lemma.reconstruction.MongoDbRepository;
import de.fhdo.lemma.reconstruction.domain.Context;
import de.fhdo.lemma.reconstruction.domain.LemmaDomainGenerator;
import de.fhdo.lemma.reconstruction.service.LemmaServiceGenerator;
import de.fhdo.lemma.reconstruction.service.Microservice;
import de.fhdo.lemma.reconstruction.util.Util;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.service.ServicePackage;
import de.fhdo.lemma.servicedsl.extractor.ServiceDslExtractor;
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
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class LemmaReconstructionHandler extends AbstractHandler {
  /**
   * Current shell
   */
  private static final Shell SHELL = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
  
  private String mongoDbHostname;
  
  private String mongoDbPort;
  
  private List<Context> initialContexts = CollectionLiterals.<Context>newLinkedList();
  
  private List<Context> selectedContexts = CollectionLiterals.<Context>newLinkedList();
  
  private List<Microservice> initialMicroservices = CollectionLiterals.<Microservice>newLinkedList();
  
  private List<Microservice> selectedMicroservices = CollectionLiterals.<Microservice>newLinkedList();
  
  private String reconstructionPath;
  
  private List<DataModel> domainDataModels = CollectionLiterals.<DataModel>newLinkedList();
  
  private List<ServiceModel> serviceModels = CollectionLiterals.<ServiceModel>newLinkedList();
  
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    this.receiveMongoDbEndpoints();
    this.loadContextInformationFromMongoDb();
    this.loadMicroservicesFromMongoDB();
    this.displayReconstructionInforation();
    this.selectTargetFolderForModelGeneration();
    this.generateModels();
    this.writeModelsToFolder();
    this.showReconstructionInformationMessage();
    this.resetDialogHandler();
    return null;
  }
  
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
  
  private List<Microservice> displayReconstructionInforation() {
    List<Microservice> _xblockexpression = null;
    {
      final LemmaReconstructionResultsDialog dialog = new LemmaReconstructionResultsDialog(LemmaReconstructionHandler.SHELL, this.initialContexts, 
        this.initialMicroservices);
      dialog.create();
      dialog.open();
      this.selectedContexts = dialog.getSelectedContexts();
      _xblockexpression = this.selectedMicroservices = dialog.getSelectedMicroservices();
    }
    return _xblockexpression;
  }
  
  private boolean loadContextInformationFromMongoDb() {
    boolean _xblockexpression = false;
    {
      int _parseInt = Integer.parseInt(this.mongoDbPort);
      final MongoDbRepository repository = new MongoDbRepository(this.mongoDbHostname, _parseInt);
      _xblockexpression = this.initialContexts.addAll(repository.getReconstructedContexts());
    }
    return _xblockexpression;
  }
  
  private boolean loadMicroservicesFromMongoDB() {
    boolean _xblockexpression = false;
    {
      int _parseInt = Integer.parseInt(this.mongoDbPort);
      final MongoDbRepository repository = new MongoDbRepository(this.mongoDbHostname, _parseInt);
      _xblockexpression = this.initialMicroservices.addAll(repository.getReconstructedMicroservices());
    }
    return _xblockexpression;
  }
  
  private String selectTargetFolderForModelGeneration() {
    String _xblockexpression = null;
    {
      final DirectoryDialog fileDialog = new DirectoryDialog(LemmaReconstructionHandler.SHELL, SWT.OPEN);
      _xblockexpression = this.reconstructionPath = fileDialog.open();
    }
    return _xblockexpression;
  }
  
  private void generateModels() {
    this.generateDomainModels();
    this.generateServiceModels();
  }
  
  private void generateDomainModels() {
    final LemmaDomainGenerator generator = new LemmaDomainGenerator();
    final Consumer<Context> _function = (Context it) -> {
      CollectionExtensions.<DataModel>addAll(this.domainDataModels, generator.generateDataModel(it));
    };
    this.selectedContexts.forEach(_function);
  }
  
  private void generateServiceModels() {
    final LemmaServiceGenerator generator = new LemmaServiceGenerator();
    final Consumer<Microservice> _function = (Microservice it) -> {
      final ServiceModel model = generator.generateModelFrom(it);
      this.serviceModels.add(model);
    };
    this.selectedMicroservices.forEach(_function);
  }
  
  private void writeModelsToFolder() {
    final Consumer<DataModel> _function = (DataModel it) -> {
      this.writeDomainDataModel(it);
    };
    this.domainDataModels.forEach(_function);
    final Consumer<ServiceModel> _function_1 = (ServiceModel it) -> {
      this.writeServiceModel(it);
    };
    this.serviceModels.forEach(_function_1);
  }
  
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
  
  private Path validateDataModel(final String path) {
    try {
      Path _xblockexpression = null;
      {
        EPackage.Registry.INSTANCE.put(DataPackage.eNS_URI, DataPackage.eINSTANCE);
        final DataDslStandaloneSetup setup = new DataDslStandaloneSetup();
        final Injector injector = setup.createInjectorAndDoEMFRegistration();
        final XtextResourceSet resourceSet = injector.<XtextResourceSet>getInstance(XtextResourceSet.class);
        Resource _createResource = resourceSet.createResource(URI.createURI(path));
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
  
  private Path writeServiceModel(final ServiceModel model) {
    try {
      Path _xblockexpression = null;
      {
        final String serviceModel = new ServiceDslExtractor().extractToString(model);
        final String fileName = IterableExtensions.<String>last(model.getMicroservices().get(0).getQualifiedNameParts());
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(this.reconstructionPath);
        _builder.append(File.separator);
        _builder.append("service");
        _builder.append(File.separator);
        _builder.append(fileName);
        _builder.append(".services");
        final String filePath = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(this.reconstructionPath);
        _builder_1.append(File.separator);
        _builder_1.append("service");
        Files.createDirectories(Paths.get(_builder_1.toString()));
        Files.write(Paths.get(filePath), serviceModel.getBytes());
        _xblockexpression = this.validateServiceModel(filePath);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private Path validateServiceModel(final String path) {
    try {
      Path _xblockexpression = null;
      {
        EPackage.Registry.INSTANCE.put(ServicePackage.eNS_URI, DataPackage.eINSTANCE);
        final ServiceDslStandaloneSetup setup = new ServiceDslStandaloneSetup();
        final Injector injector = setup.createInjectorAndDoEMFRegistration();
        final XtextResourceSet resourceSet = injector.<XtextResourceSet>getInstance(XtextResourceSet.class);
        Resource _createResource = resourceSet.createResource(URI.createURI(path));
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
    final Consumer<Microservice> _function_1 = (Microservice it) -> {
      StringConcatenation _builder = new StringConcatenation();
      String _last = IterableExtensions.<String>last(((Iterable<String>)Conversions.doWrapArray(it.getName().split("\\W"))));
      _builder.append(_last);
      _builder.append(".services");
      generatedLemmaModels.add(_builder.toString());
    };
    this.selectedMicroservices.forEach(_function_1);
    final String messageText = "Generated Models:";
    String _join = IterableExtensions.join(generatedLemmaModels, "\n\t- ");
    String _plus = ((messageText + "\n\t- ") + _join);
    final String messageModels = (_plus + "\n\n");
    this.showInfoDialogMessage(title, messageModels);
  }
  
  private void showInfoDialogMessage(final String title, final String message) {
    MessageDialog.openInformation(LemmaReconstructionHandler.SHELL, title, message);
  }
  
  private void resetDialogHandler() {
    this.initialContexts.clear();
    this.selectedContexts.clear();
    this.domainDataModels.clear();
    this.initialMicroservices.clear();
    this.selectedMicroservices.clear();
    this.serviceModels.clear();
  }
}
