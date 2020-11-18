package de.fhdo.lemma.intermediate.transformations.operation;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.intermediate.IntermediateImport;
import de.fhdo.lemma.intermediate.transformations.AbstractAtlInputOutputIntermediateModelTransformationStrategy;
import de.fhdo.lemma.intermediate.transformations.TransformationModelDescription;
import de.fhdo.lemma.intermediate.transformations.TransformationModelType;
import de.fhdo.lemma.operation.OperationModel;
import de.fhdo.lemma.operation.OperationPackage;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;
import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.utils.LemmaUtils;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Implementation of the ATL-based model-to-model transformation of operation models to intermediate
 * operation models.
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@SuppressWarnings("all")
public class IntermediateOperationModelTransformation extends AbstractAtlInputOutputIntermediateModelTransformationStrategy {
  private IFile inputModelFile;
  
  private String absoluteInputModelFilePath;
  
  private String absoluteOutputModelFilePath;
  
  private boolean convertToRelativeUris;
  
  /**
   * Specify reference name and transformation model type of input model
   */
  @Override
  public Pair<String, TransformationModelType> getInputModelReferenceNameAndType() {
    TransformationModelType _transformationModelType = new TransformationModelType(OperationPackage.eNS_URI, OperationPackage.eINSTANCE, 
      OperationModel.class);
    return Pair.<String, TransformationModelType>of("Operation", _transformationModelType);
  }
  
  /**
   * Specify reference name and transformation model type of output model
   */
  @Override
  public Pair<String, TransformationModelType> getOutputModelReferenceNameAndType() {
    TransformationModelType _transformationModelType = new TransformationModelType(IntermediatePackage.eNS_URI, 
      IntermediatePackage.eINSTANCE, IntermediateOperationModel.class);
    return Pair.<String, TransformationModelType>of("Intermediate", _transformationModelType);
  }
  
  /**
   * Specify path to the compiled ATL transformation file
   */
  @Override
  public String getCompiledModelTransformationFilePath() {
    return "/IntermediateOperationModelTransformation.asm";
  }
  
  /**
   * Fetch input model and output model file prior to transformation execution
   */
  @Override
  public void beforeTransformationHook(final Map<TransformationModelDescription, IFile> inputModelFiles, final Map<TransformationModelDescription, String> outputModelPaths, final boolean convertToRelativeUris) {
    this.inputModelFile = ((IFile[])Conversions.unwrapArray(inputModelFiles.values(), IFile.class))[0];
    this.absoluteInputModelFilePath = LemmaUtils.getAbsolutePath(this.inputModelFile);
    final String projectRelativeOutputModelFilePath = ((String[])Conversions.unwrapArray(outputModelPaths.values(), String.class))[0];
    this.absoluteOutputModelFilePath = LemmaUtils.convertProjectResourceToAbsoluteFilePath(projectRelativeOutputModelFilePath, 
      this.inputModelFile.getProject());
    this.convertToRelativeUris = convertToRelativeUris;
  }
  
  /**
   * Prepare input model
   */
  @Override
  public void prepareInputModel(final TransformationModelDescription modelDescription, final EObject modelRoot) {
    final OperationModel operationModel = ((OperationModel) modelRoot);
    operationModel.setT_modelUri(LemmaUtils.convertToFileUri(this.absoluteInputModelFilePath));
    final Consumer<Import> _function = (Import it) -> {
      it.setImportURI(LemmaUtils.convertToAbsoluteFileUri(it.getImportURI(), this.absoluteInputModelFilePath));
    };
    operationModel.getImports().forEach(_function);
  }
  
  /**
   * Add transformation target paths of imported model files to target model
   */
  @Override
  public void populateOutputModelWithImportTargetPaths(final TransformationModelDescription modelDescription, final EObject modelRoot, final Map<String, String> targetPaths) {
    final IntermediateOperationModel operationModelRoot = ((IntermediateOperationModel) modelRoot);
    final String workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
    final BiConsumer<String, String> _function = (String importName, String targetPath) -> {
      final Function1<IntermediateImport, Boolean> _function_1 = (IntermediateImport it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, importName));
      };
      final IntermediateImport import_ = IterableExtensions.<IntermediateImport>findFirst(operationModelRoot.getImports(), _function_1);
      import_.setImportUri(LemmaUtils.convertToFileUri((workspacePath + targetPath)));
    };
    targetPaths.forEach(_function);
  }
  
  /**
   * Modify the given output model
   */
  @Override
  public void modifyOutputModel(final TransformationModelDescription modelDescription, final EObject modelRoot) {
    if ((!this.convertToRelativeUris)) {
      return;
    }
    final IntermediateOperationModel operationModel = ((IntermediateOperationModel) modelRoot);
    final String relativeInputModelFilePath = LemmaUtils.relativize(this.absoluteOutputModelFilePath, 
      this.absoluteInputModelFilePath);
    operationModel.setSourceModelUri(LemmaUtils.convertToFileUri(relativeInputModelFilePath));
    final Consumer<IntermediateImport> _function = (IntermediateImport it) -> {
      final String relativeImportModelFilePath = LemmaUtils.relativize(this.absoluteOutputModelFilePath, 
        LemmaUtils.removeFileUri(it.getImportUri()));
      it.setImportUri(LemmaUtils.convertToFileUri(relativeImportModelFilePath));
    };
    operationModel.getImports().forEach(_function);
  }
}
