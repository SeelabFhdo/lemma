package de.fhdo.ddmm.intermediate.transformations.service;

import de.fhdo.ddmm.intermediate.transformations.AbstractIntermediateModelTransformationStrategy;
import de.fhdo.ddmm.intermediate.transformations.AbstractSourceModelValidator;
import de.fhdo.ddmm.intermediate.transformations.TargetModelInfo;
import de.fhdo.ddmm.intermediate.transformations.service.MappingModelTransformationValidator;
import de.fhdo.ddmm.service.Import;
import de.fhdo.ddmm.service.ServiceModel;
import de.fhdo.ddmm.service.ServicePackage;
import de.fhdo.ddmm.technology.mapping.MappingPackage;
import de.fhdo.ddmm.technology.mapping.TechnologyMapping;
import de.fhdo.ddmm.utils.DdmmUtils;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;

/**
 * This class enables access the model-to-model transformation of technology mapping models to
 * service models.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class MappingModelTransformation extends AbstractIntermediateModelTransformationStrategy {
  private static final TargetModelInfo TARGET_MODEL_INFO = new TargetModelInfo(
    ServicePackage.eNS_URI, 
    ServicePackage.eINSTANCE, 
    ServiceModel.class);
  
  private String absoluteSourceModelPath;
  
  /**
   * Get project-relative path to compiled ATL model transformation file
   */
  @Override
  public String getCompiledModelTransformationFilePath() {
    return "/MappingModelTransformation.asm";
  }
  
  /**
   * Get URI and EPackage of the target intermediate metamodel
   */
  @Override
  public TargetModelInfo getTargetModelInfo() {
    return MappingModelTransformation.TARGET_MODEL_INFO;
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
    final TechnologyMapping mappingModel = ((TechnologyMapping) modelRoot);
    this.convertImportUrisToAbsoluteFileUris(mappingModel.getImports(), this.absoluteSourceModelPath);
  }
  
  /**
   * Transformation preparation: Convert import URIs of imported model files to absolute file
   * URIs. Otherwise the transformation won't have access to them and the contained model
   * elements.
   */
  private void convertImportUrisToAbsoluteFileUris(final List<Import> imports, final String modelFilePath) {
    final Consumer<Import> _function = (Import it) -> {
      boolean _isFileUri = DdmmUtils.isFileUri(it.getImportURI());
      boolean _not = (!_isFileUri);
      if (_not) {
        it.setImportURI(DdmmUtils.convertToFileUri(
          DdmmUtils.convertToAbsolutePath(it.getImportURI(), modelFilePath)));
      }
    };
    imports.forEach(_function);
  }
  
  /**
   * Get validator for source model
   */
  @Override
  public AbstractSourceModelValidator getSourceModelValidator() {
    return new MappingModelTransformationValidator();
  }
  
  /**
   * Get namespace URI of the source metamodel's EPackage
   */
  @Override
  public String getSourcePackageNamespaceUri() {
    return MappingPackage.eNS_URI;
  }
  
  /**
   * Get prefix of source model in ATL transformation file
   */
  @Override
  public String getTransformationSourceModelPrefix() {
    return "Mapping";
  }
  
  /**
   * Get prefix of target model in ATL transformation file
   */
  @Override
  public String getTransformationTargetModelPrefix() {
    return "Service";
  }
  
  /**
   * Consider imports of imported service models to build import target paths. Otherwise the paths
   * of domain models imported by mapped service models will point to their original destination
   * instead of those of the intermediate models they get possibly transformed to within the
   * transformation process.
   */
  @Override
  public boolean considerChildrensChildrenForImportTargetPaths() {
    return true;
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
