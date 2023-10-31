package de.fhdo.lemma.intermediate.transformations.service;

import de.fhdo.lemma.data.intermediate.IntermediateDataModel;
import de.fhdo.lemma.data.intermediate.IntermediatePackage;
import de.fhdo.lemma.intermediate.transformations.AbstractEmftvmIntermediateModelTransformationStrategy;
import de.fhdo.lemma.intermediate.transformations.TransformationModelDescription;
import de.fhdo.lemma.intermediate.transformations.TransformationModelDirection;
import de.fhdo.lemma.intermediate.transformations.TransformationModelType;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.service.ServicePackage;
import java.util.LinkedHashMap;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Implementation of the EMFTVM-based refining transformation of intermediate data models.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class IntermediateDataModelRefinement extends AbstractEmftvmIntermediateModelTransformationStrategy {
  public static final TransformationModelDescription IN_MODEL_DESCRIPTION = new TransformationModelDescription("IN", "Intermediate", TransformationModelDirection.INOUT);

  public static final TransformationModelDescription SERVICE_MODEL_DESCRIPTION = new TransformationModelDescription("SERVICE", "Service", TransformationModelDirection.IN);

  /**
   * Get the platform path to the folder that holds the transformation model file
   */
  @Override
  public String getModelTransformationFilePlatformFolder() {
    return "platform:/plugin/de.fhdo.lemma.intermediate.transformations/transformation/";
  }

  /**
   * Get the name of the transformation model file
   */
  @Override
  public String getModelTransformationFileName() {
    return "IntermediateDataModelRefinement";
  }

  /**
   * Register model types
   */
  @Override
  public LinkedHashMap<TransformationModelDescription, TransformationModelType> registerModelTypes() {
    TransformationModelType _transformationModelType = new TransformationModelType(
      IntermediatePackage.eNS_URI, IntermediatePackage.eINSTANCE, IntermediateDataModel.class);
    Pair<TransformationModelDescription, TransformationModelType> _mappedTo = Pair.<TransformationModelDescription, TransformationModelType>of(IntermediateDataModelRefinement.IN_MODEL_DESCRIPTION, _transformationModelType);
    TransformationModelType _transformationModelType_1 = new TransformationModelType(
      ServicePackage.eNS_URI, ServicePackage.eINSTANCE, ServiceModel.class);
    Pair<TransformationModelDescription, TransformationModelType> _mappedTo_1 = Pair.<TransformationModelDescription, TransformationModelType>of(IntermediateDataModelRefinement.SERVICE_MODEL_DESCRIPTION, _transformationModelType_1);
    return CollectionLiterals.<TransformationModelDescription, TransformationModelType>newLinkedHashMap(_mappedTo, _mappedTo_1);
  }
}
