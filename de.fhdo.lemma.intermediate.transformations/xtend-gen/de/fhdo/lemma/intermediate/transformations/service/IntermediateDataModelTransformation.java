package de.fhdo.lemma.intermediate.transformations.service;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.ComplexTypeImport;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.data.DataPackage;
import de.fhdo.lemma.data.intermediate.IntermediateDataModel;
import de.fhdo.lemma.data.intermediate.IntermediateImport;
import de.fhdo.lemma.data.intermediate.IntermediatePackage;
import de.fhdo.lemma.intermediate.transformations.AbstractAtlInputOutputIntermediateModelTransformationStrategy;
import de.fhdo.lemma.intermediate.transformations.AbstractInputModelValidator;
import de.fhdo.lemma.intermediate.transformations.AbstractIntermediateModelTransformationStrategy;
import de.fhdo.lemma.intermediate.transformations.TransformationModelDescription;
import de.fhdo.lemma.intermediate.transformations.TransformationModelType;
import de.fhdo.lemma.utils.LemmaUtils;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Implementation of the ATL-based model-to-model transformation of data models to intermediate data
 * models.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class IntermediateDataModelTransformation extends AbstractAtlInputOutputIntermediateModelTransformationStrategy {
  private String absoluteInputModelFilePath;
  
  /**
   * Specify reference name and transformation model type of input model
   */
  @Override
  public Pair<String, TransformationModelType> getInputModelReferenceNameAndType() {
    TransformationModelType _transformationModelType = new TransformationModelType(DataPackage.eNS_URI, DataPackage.eINSTANCE, DataModel.class);
    return Pair.<String, TransformationModelType>of("Data", _transformationModelType);
  }
  
  /**
   * Specify reference name and transformation model type of output model
   */
  @Override
  public Pair<String, TransformationModelType> getOutputModelReferenceNameAndType() {
    TransformationModelType _transformationModelType = new TransformationModelType(IntermediatePackage.eNS_URI, 
      IntermediatePackage.eINSTANCE, IntermediateDataModel.class);
    return Pair.<String, TransformationModelType>of("Intermediate", _transformationModelType);
  }
  
  /**
   * Specify path to the compiled ATL transformation file
   */
  @Override
  public String getCompiledModelTransformationFilePath() {
    return "/IntermediateDataModelTransformation.asm";
  }
  
  /**
   * Fetch input model file prior to transformation execution
   */
  @Override
  public void beforeTransformationHook(final Map<TransformationModelDescription, IFile> inputModelFiles, final Map<TransformationModelDescription, String> outputModelPaths) {
    final IFile inputModelFile = ((IFile[])Conversions.unwrapArray(inputModelFiles.values(), IFile.class))[0];
    this.absoluteInputModelFilePath = LemmaUtils.getAbsolutePath(inputModelFile);
  }
  
  /**
   * Prepare input model
   */
  @Override
  public void prepareInputModel(final TransformationModelDescription modelDescription, final EObject modelRoot) {
    final DataModel dataModel = ((DataModel) modelRoot);
    boolean _isFileUri = LemmaUtils.isFileUri(this.absoluteInputModelFilePath);
    boolean _not = (!_isFileUri);
    if (_not) {
      dataModel.setT_modelUri(LemmaUtils.convertToFileUri(this.absoluteInputModelFilePath));
    }
    final Consumer<ComplexTypeImport> _function = (ComplexTypeImport it) -> {
      boolean _isFileUri_1 = LemmaUtils.isFileUri(it.getImportURI());
      boolean _not_1 = (!_isFileUri_1);
      if (_not_1) {
        it.setImportURI(LemmaUtils.convertToFileUri(
          LemmaUtils.convertToAbsolutePath(it.getImportURI(), this.absoluteInputModelFilePath)));
      }
    };
    dataModel.getComplexTypeImports().forEach(_function);
  }
  
  /**
   * Specify validator for input model
   */
  @Override
  public AbstractInputModelValidator getInputModelValidator(final TransformationModelDescription modelDescription) {
    return new DataModelTransformationValidator();
  }
  
  /**
   * Add transformation target paths of imported model files to target model
   */
  @Override
  public void populateOutputModelWithImportTargetPaths(final TransformationModelDescription modelDescription, final EObject modelRoot, final Map<String, String> targetPaths) {
    final IntermediateDataModel intermediateModelRoot = ((IntermediateDataModel) modelRoot);
    final BiConsumer<String, String> _function = (String importName, String targetPath) -> {
      final Function1<IntermediateImport, Boolean> _function_1 = (IntermediateImport it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, importName));
      };
      final IntermediateImport import_ = IterableExtensions.<IntermediateImport>findFirst(intermediateModelRoot.getImports(), _function_1);
      import_.setImportUri(LemmaUtils.convertProjectPathToAbsoluteFileUri(targetPath));
    };
    targetPaths.forEach(_function);
  }
  
  /**
   * Convert URIs in intermediate data models to relative ones
   */
  @Override
  public void makeUrisRelative(final AbstractIntermediateModelTransformationStrategy.TransformationResult result) {
    IntermediateDataModelTransformation.performUriRelativization(result);
  }
  
  /**
   * Reusable helper to convert URIs in intermediate data models to relative ones
   */
  public static void performUriRelativization(final AbstractIntermediateModelTransformationStrategy.TransformationResult result) {
    EObject _get = result.getOutputModel().getResource().getContents().get(0);
    final IntermediateDataModel dataModel = ((IntermediateDataModel) _get);
    dataModel.setSourceModelUri(LemmaUtils.convertToFileUri(
      LemmaUtils.relativize(
        LemmaUtils.removeFileUri(result.getOutputModel().getOutputPath()), 
        LemmaUtils.removeFileUri(result.getInputModels().get(0).getInputPath()))));
    final Consumer<IntermediateImport> _function = (IntermediateImport it) -> {
      it.setImportUri(LemmaUtils.convertToFileUri(
        LemmaUtils.relativize(
          LemmaUtils.removeFileUri(result.getOutputModel().getOutputPath()), 
          LemmaUtils.removeFileUri(it.getImportUri()))));
    };
    dataModel.getImports().forEach(_function);
  }
}
