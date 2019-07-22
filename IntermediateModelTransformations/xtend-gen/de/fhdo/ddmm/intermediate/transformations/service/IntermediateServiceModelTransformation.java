package de.fhdo.ddmm.intermediate.transformations.service;

import com.google.common.base.Objects;
import de.fhdo.ddmm.data.intermediate.IntermediateImport;
import de.fhdo.ddmm.intermediate.transformations.AbstractAtlInputOutputIntermediateModelTransformationStrategy;
import de.fhdo.ddmm.intermediate.transformations.AbstractInputModelValidator;
import de.fhdo.ddmm.intermediate.transformations.TransformationModelDescription;
import de.fhdo.ddmm.intermediate.transformations.TransformationModelType;
import de.fhdo.ddmm.intermediate.transformations.service.ServiceModelTransformationValidator;
import de.fhdo.ddmm.service.Import;
import de.fhdo.ddmm.service.Microservice;
import de.fhdo.ddmm.service.ServiceModel;
import de.fhdo.ddmm.service.ServicePackage;
import de.fhdo.ddmm.service.TechnologyReference;
import de.fhdo.ddmm.service.intermediate.IntermediatePackage;
import de.fhdo.ddmm.service.intermediate.IntermediateServiceModel;
import de.fhdo.ddmm.technology.CommunicationType;
import de.fhdo.ddmm.technology.Protocol;
import de.fhdo.ddmm.technology.Technology;
import de.fhdo.ddmm.utils.DdmmUtils;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.core.resources.ResourcesPlugin;
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
  private String absoluteInputModelPath;
  
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
   * Fetch path of input model prior to transformation execution
   */
  @Override
  public void beforeTransformationHook(final Map<TransformationModelDescription, String> absoluteInputModelPaths) {
    this.absoluteInputModelPath = ((String[])Conversions.unwrapArray(absoluteInputModelPaths.values(), String.class))[0];
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
      serviceModel.setT_modelUri(DdmmUtils.convertToFileUri(this.absoluteInputModelPath));
    }
    final Consumer<Import> _function = (Import it) -> {
      it.setImportURI(DdmmUtils.convertToAbsoluteFileUri(it.getImportURI(), this.absoluteInputModelPath));
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
        final Technology technologyModel = DdmmUtils.<Technology>getImportedModelRoot(technologyImport.eResource(), 
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
    final String workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
    final BiConsumer<String, String> _function = (String importName, String targetPath) -> {
      final Function1<IntermediateImport, Boolean> _function_1 = (IntermediateImport it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, importName));
      };
      final IntermediateImport import_ = IterableExtensions.<IntermediateImport>findFirst(serviceModelRoot.getImports(), _function_1);
      import_.setImportUri(DdmmUtils.convertToFileUri((workspacePath + targetPath)));
    };
    targetPaths.forEach(_function);
  }
}
