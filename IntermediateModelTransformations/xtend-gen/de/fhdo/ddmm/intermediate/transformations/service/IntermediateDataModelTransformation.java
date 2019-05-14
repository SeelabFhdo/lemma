package de.fhdo.ddmm.intermediate.transformations.service;

import de.fhdo.ddmm.data.ComplexTypeImport;
import de.fhdo.ddmm.data.DataModel;
import de.fhdo.ddmm.data.DataPackage;
import de.fhdo.ddmm.data.intermediate.IntermediateDataModel;
import de.fhdo.ddmm.data.intermediate.IntermediatePackage;
import de.fhdo.ddmm.intermediate.transformations.AbstractIntermediateModelTransformationStrategy;
import de.fhdo.ddmm.intermediate.transformations.AbstractSourceModelValidator;
import de.fhdo.ddmm.intermediate.transformations.TargetModelInfo;
import de.fhdo.ddmm.intermediate.transformations.service.DataModelTransformationValidator;
import de.fhdo.ddmm.utils.DdmmUtils;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;

/**
 * This class enables access to the model-to-model transformation of data models to intermediate
 * data models.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class IntermediateDataModelTransformation extends AbstractIntermediateModelTransformationStrategy {
  private static final TargetModelInfo TARGET_MODEL_INFO = new TargetModelInfo(
    IntermediatePackage.eNS_URI, 
    IntermediatePackage.eINSTANCE, 
    IntermediateDataModel.class);
  
  private String absoluteSourceModelPath;
  
  /**
   * Get project-relative path to compiled ATL model transformation file
   */
  @Override
  public String getCompiledModelTransformationFilePath() {
    return "/IntermediateDataModelTransformation.asm";
  }
  
  /**
   * Get URI and EPackage of the target intermediate metamodel
   */
  @Override
  public TargetModelInfo getTargetModelInfo() {
    return IntermediateDataModelTransformation.TARGET_MODEL_INFO;
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
    final DataModel dataModel = ((DataModel) modelRoot);
    boolean _isFileUri = DdmmUtils.isFileUri(this.absoluteSourceModelPath);
    boolean _not = (!_isFileUri);
    if (_not) {
      dataModel.setT_modelUri(DdmmUtils.convertToFileUri(this.absoluteSourceModelPath));
    }
    final Consumer<ComplexTypeImport> _function = (ComplexTypeImport it) -> {
      boolean _isFileUri_1 = DdmmUtils.isFileUri(it.getImportURI());
      boolean _not_1 = (!_isFileUri_1);
      if (_not_1) {
        it.setImportURI(DdmmUtils.convertToFileUri(
          DdmmUtils.convertToAbsolutePath(it.getImportURI(), this.absoluteSourceModelPath)));
      }
    };
    dataModel.getComplexTypeImports().forEach(_function);
  }
  
  /**
   * Get validator for source model
   */
  @Override
  public AbstractSourceModelValidator getSourceModelValidator() {
    return new DataModelTransformationValidator();
  }
  
  /**
   * Get namespace URI of the source metamodel's EPackage
   */
  @Override
  public String getSourcePackageNamespaceUri() {
    return DataPackage.eNS_URI;
  }
  
  /**
   * Get prefix of source model in ATL transformation file
   */
  @Override
  public String getTransformationSourceModelPrefix() {
    return "Data";
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
