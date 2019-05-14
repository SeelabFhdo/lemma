package de.fhdo.ddmm.intermediate.transformations.service;

import de.fhdo.ddmm.intermediate.transformations.AbstractIntermediateModelTransformationStrategy;
import de.fhdo.ddmm.intermediate.transformations.AbstractSourceModelValidator;
import de.fhdo.ddmm.intermediate.transformations.TargetModelInfo;
import de.fhdo.ddmm.intermediate.transformations.service.ServiceModelTransformationValidator;
import de.fhdo.ddmm.service.Import;
import de.fhdo.ddmm.service.Microservice;
import de.fhdo.ddmm.service.ServiceModel;
import de.fhdo.ddmm.service.ServicePackage;
import de.fhdo.ddmm.service.intermediate.IntermediatePackage;
import de.fhdo.ddmm.service.intermediate.IntermediateServiceModel;
import de.fhdo.ddmm.technology.CommunicationType;
import de.fhdo.ddmm.technology.Protocol;
import de.fhdo.ddmm.technology.Technology;
import de.fhdo.ddmm.utils.DdmmUtils;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * This class enables access the model-to-model transformation of service models to intermediate
 * service models.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class IntermediateServiceModelTransformation extends AbstractIntermediateModelTransformationStrategy {
  private static final TargetModelInfo TARGET_MODEL_INFO = new TargetModelInfo(
    IntermediatePackage.eNS_URI, 
    IntermediatePackage.eINSTANCE, 
    IntermediateServiceModel.class);
  
  private String absoluteSourceModelPath;
  
  /**
   * Get project-relative path to compiled ATL model transformation file
   */
  @Override
  public String getCompiledModelTransformationFilePath() {
    return "/IntermediateServiceModelTransformation.asm";
  }
  
  /**
   * Get URI and EPackage of the target intermediate metamodel
   */
  @Override
  public TargetModelInfo getTargetModelInfo() {
    return IntermediateServiceModelTransformation.TARGET_MODEL_INFO;
  }
  
  /**
   * Before transformation hook
   */
  @Override
  public void beforeTransformationHook(final String absoluteSourceModelPath) {
    this.absoluteSourceModelPath = absoluteSourceModelPath;
  }
  
  /**
   * Prepare source model
   */
  @Override
  public void prepareSourceModel(final EObject modelRoot) {
    final ServiceModel serviceModel = ((ServiceModel) modelRoot);
    String _t_modelUri = serviceModel.getT_modelUri();
    boolean _tripleEquals = (_t_modelUri == null);
    if (_tripleEquals) {
      serviceModel.setT_modelUri(DdmmUtils.convertToFileUri(this.absoluteSourceModelPath));
    }
    final Consumer<Import> _function = (Import it) -> {
      it.setImportURI(DdmmUtils.convertToAbsoluteFileUri(it.getImportURI(), this.absoluteSourceModelPath));
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
      final Consumer<Import> _function_1 = (Import technologyImport) -> {
        final Technology technologyModel = DdmmUtils.<Technology>getImportedModelRoot(technologyImport.eResource(), 
          technologyImport.getImportURI(), Technology.class);
        Map<CommunicationType, Pair<Import, Protocol>> _t_defaultProtocols = microservice.getT_defaultProtocols();
        boolean _tripleEquals_1 = (_t_defaultProtocols == null);
        if (_tripleEquals_1) {
          microservice.setT_defaultProtocols(
            CollectionLiterals.<CommunicationType, Pair<Import, Protocol>>newHashMap());
        }
        final Consumer<Protocol> _function_2 = (Protocol it) -> {
          boolean _isDefault = it.isDefault();
          if (_isDefault) {
            Map<CommunicationType, Pair<Import, Protocol>> _t_defaultProtocols_1 = microservice.getT_defaultProtocols();
            CommunicationType _communicationType = it.getCommunicationType();
            Pair<Import, Protocol> _mappedTo = Pair.<Import, Protocol>of(technologyImport, it);
            _t_defaultProtocols_1.putIfAbsent(_communicationType, _mappedTo);
          }
        };
        technologyModel.getProtocols().forEach(_function_2);
      };
      microservice.getTechnologies().forEach(_function_1);
    };
    microservices.forEach(_function);
  }
  
  /**
   * Get validator for source model
   */
  @Override
  public AbstractSourceModelValidator getSourceModelValidator() {
    return new ServiceModelTransformationValidator();
  }
  
  /**
   * Get namespace URI of the source metamodel's EPackage
   */
  @Override
  public String getSourcePackageNamespaceUri() {
    return ServicePackage.eNS_URI;
  }
  
  /**
   * Get prefix of source model in ATL transformation file
   */
  @Override
  public String getTransformationSourceModelPrefix() {
    return "Service";
  }
  
  /**
   * Get prefix of target model in ATL transformation file
   */
  @Override
  public String getTransformationTargetModelPrefix() {
    return "Intermediate";
  }
  
  /**
   * Add transformation target paths of imported model files to target model
   */
  @Override
  public void populateTargetModelWithImportTargetPaths(final /* EMFModel */Object targetModel, final Map<String, String> targetPaths) {
    throw new Error("Unresolved compilation problems:"
      + "\nresource cannot be resolved"
      + "\ncontents cannot be resolved"
      + "\nget cannot be resolved");
  }
}
