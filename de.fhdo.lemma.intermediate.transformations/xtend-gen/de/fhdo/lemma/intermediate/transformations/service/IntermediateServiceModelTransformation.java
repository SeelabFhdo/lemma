package de.fhdo.lemma.intermediate.transformations.service;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.intermediate.IntermediateImport;
import de.fhdo.lemma.intermediate.transformations.AbstractAtlInputOutputIntermediateModelTransformationStrategy;
import de.fhdo.lemma.intermediate.transformations.AbstractInputModelValidator;
import de.fhdo.lemma.intermediate.transformations.AbstractIntermediateModelTransformationStrategy;
import de.fhdo.lemma.intermediate.transformations.TransformationModelDescription;
import de.fhdo.lemma.intermediate.transformations.TransformationModelType;
import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.Microservice;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.service.ServicePackage;
import de.fhdo.lemma.service.TechnologyReference;
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice;
import de.fhdo.lemma.service.intermediate.IntermediatePackage;
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel;
import de.fhdo.lemma.technology.CommunicationType;
import de.fhdo.lemma.technology.Protocol;
import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.utils.LemmaUtils;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Implementation of the ATL-based model-to-model transformation of service models to intermediate
 * service models.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class IntermediateServiceModelTransformation extends AbstractAtlInputOutputIntermediateModelTransformationStrategy {
  private IFile inputModelFile;
  
  private String absoluteInputModelFilePath;
  
  /**
   * Specify reference name and transformation model type of input model
   */
  @Override
  public Pair<String, TransformationModelType> getInputModelReferenceNameAndType() {
    TransformationModelType _transformationModelType = new TransformationModelType(ServicePackage.eNS_URI, ServicePackage.eINSTANCE, 
      ServiceModel.class);
    return Pair.<String, TransformationModelType>of("Service", _transformationModelType);
  }
  
  /**
   * Specify reference name and transformation model type of output model
   */
  @Override
  public Pair<String, TransformationModelType> getOutputModelReferenceNameAndType() {
    TransformationModelType _transformationModelType = new TransformationModelType(IntermediatePackage.eNS_URI, 
      IntermediatePackage.eINSTANCE, IntermediateServiceModel.class);
    return Pair.<String, TransformationModelType>of("Intermediate", _transformationModelType);
  }
  
  /**
   * Specify path to the compiled ATL transformation file
   */
  @Override
  public String getCompiledModelTransformationFilePath() {
    return "/IntermediateServiceModelTransformation.asm";
  }
  
  /**
   * Fetch input model file prior to transformation execution
   */
  @Override
  public void beforeTransformationHook(final Map<TransformationModelDescription, IFile> inputModelFiles, final Map<TransformationModelDescription, String> outputModelPaths) {
    this.inputModelFile = ((IFile[])Conversions.unwrapArray(inputModelFiles.values(), IFile.class))[0];
    this.absoluteInputModelFilePath = LemmaUtils.getAbsolutePath(this.inputModelFile);
  }
  
  /**
   * Prepare input model
   */
  @Override
  public void prepareInputModel(final TransformationModelDescription modelDescription, final EObject modelRoot) {
    final ServiceModel serviceModel = ((ServiceModel) modelRoot);
    String _t_modelUri = serviceModel.getT_modelUri();
    boolean _tripleEquals = (_t_modelUri == null);
    if (_tripleEquals) {
      serviceModel.setT_modelUri(LemmaUtils.convertToFileUri(this.absoluteInputModelFilePath));
    }
    final Consumer<Import> _function = (Import it) -> {
      it.setImportURI(LemmaUtils.convertToAbsoluteFileUri(it.getImportURI(), this.absoluteInputModelFilePath));
    };
    serviceModel.getImports().forEach(_function);
    this.linkTechnologyModels(serviceModel.getMicroservices());
  }
  
  /**
   * Transformation preparation: Link technology models to service model to prevent continuous
   * disk accesses to model files during transformation. Note that this depends on absolute file
   * URIs of the imported technology models.
   */
  private void linkTechnologyModels(final List<Microservice> microservices) {
    final Consumer<Microservice> _function = (Microservice microservice) -> {
      Technology _t_typeDefinitionTechnology = microservice.getT_typeDefinitionTechnology();
      boolean _tripleEquals = (_t_typeDefinitionTechnology == null);
      if (_tripleEquals) {
        microservice.setT_typeDefinitionTechnologyImport(
          microservice.getTypeDefinitionTechnologyImport());
        microservice.setT_typeDefinitionTechnology(microservice.getTypeDefinitionTechnology());
      }
      final Function1<TechnologyReference, Import> _function_1 = (TechnologyReference it) -> {
        return it.getTechnology();
      };
      final Consumer<Import> _function_2 = (Import technologyImport) -> {
        final Technology technologyModel = LemmaUtils.<Technology>getImportedModelRoot(technologyImport.eResource(), 
          technologyImport.getImportURI(), Technology.class);
        Map<CommunicationType, Pair<Import, Protocol>> _t_defaultProtocols = microservice.getT_defaultProtocols();
        boolean _tripleEquals_1 = (_t_defaultProtocols == null);
        if (_tripleEquals_1) {
          microservice.setT_defaultProtocols(
            CollectionLiterals.<CommunicationType, Pair<Import, Protocol>>newHashMap());
        }
        final Consumer<Protocol> _function_3 = (Protocol it) -> {
          boolean _isDefault = it.isDefault();
          if (_isDefault) {
            Map<CommunicationType, Pair<Import, Protocol>> _t_defaultProtocols_1 = microservice.getT_defaultProtocols();
            CommunicationType _communicationType = it.getCommunicationType();
            Pair<Import, Protocol> _mappedTo = Pair.<Import, Protocol>of(technologyImport, it);
            _t_defaultProtocols_1.putIfAbsent(_communicationType, _mappedTo);
          }
        };
        technologyModel.getProtocols().forEach(_function_3);
      };
      ListExtensions.<TechnologyReference, Import>map(microservice.getTechnologyReferences(), _function_1).forEach(_function_2);
    };
    microservices.forEach(_function);
  }
  
  /**
   * Specify validator for input model
   */
  @Override
  public AbstractInputModelValidator getInputModelValidator(final TransformationModelDescription modelDescription) {
    return new ServiceModelTransformationValidator();
  }
  
  /**
   * Add transformation target paths of imported model files to target model
   */
  @Override
  public void populateOutputModelWithImportTargetPaths(final TransformationModelDescription modelDescription, final EObject modelRoot, final Map<String, String> targetPaths) {
    final IntermediateServiceModel serviceModelRoot = ((IntermediateServiceModel) modelRoot);
    final BiConsumer<String, String> _function = (String importName, String targetPath) -> {
      final Function1<IntermediateImport, Boolean> _function_1 = (IntermediateImport it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, importName));
      };
      final IntermediateImport import_ = IterableExtensions.<IntermediateImport>findFirst(serviceModelRoot.getImports(), _function_1);
      import_.setImportUri(LemmaUtils.convertProjectPathToAbsoluteFileUri(targetPath));
    };
    targetPaths.forEach(_function);
  }
  
  /**
   * Convert URIs in intermediate service models to relative ones
   */
  @Override
  public void makeUrisRelative(final AbstractIntermediateModelTransformationStrategy.TransformationResult result) {
    IntermediateServiceModelTransformation.performUriRelativization(result);
  }
  
  /**
   * Reusable helper to convert URIs in intermediate service models to relative ones
   */
  public static void performUriRelativization(final AbstractIntermediateModelTransformationStrategy.TransformationResult result) {
    EObject _get = result.getOutputModel().getResource().getContents().get(0);
    final IntermediateServiceModel serviceModel = ((IntermediateServiceModel) _get);
    serviceModel.setSourceModelUri(LemmaUtils.convertToFileUri(
      LemmaUtils.relativize(
        LemmaUtils.removeFileUri(result.getOutputModel().getOutputPath()), 
        LemmaUtils.removeFileUri(result.getInputModels().get(0).getInputPath()))));
    final Consumer<IntermediateImport> _function = (IntermediateImport it) -> {
      it.setImportUri(LemmaUtils.convertToFileUri(
        LemmaUtils.relativize(
          LemmaUtils.removeFileUri(result.getOutputModel().getOutputPath()), 
          LemmaUtils.removeFileUri(it.getImportUri()))));
    };
    serviceModel.getImports().forEach(_function);
    final Consumer<IntermediateMicroservice> _function_1 = (IntermediateMicroservice it) -> {
      it.setSourceModelUri(LemmaUtils.convertToFileUri(
        LemmaUtils.relativize(
          LemmaUtils.removeFileUri(result.getOutputModel().getOutputPath()), 
          LemmaUtils.removeFileUri(it.getSourceModelUri()))));
    };
    serviceModel.getMicroservices().forEach(_function_1);
  }
}
