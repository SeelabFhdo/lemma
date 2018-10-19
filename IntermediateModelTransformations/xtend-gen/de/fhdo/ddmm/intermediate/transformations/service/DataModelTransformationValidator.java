package de.fhdo.ddmm.intermediate.transformations.service;

import de.fhdo.ddmm.data.DataModel;
import de.fhdo.ddmm.intermediate.transformations.AbstractSourceModelValidator;
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationException;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

/**
 * Validator for data models that shall be transformed.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class DataModelTransformationValidator extends AbstractSourceModelValidator<DataModel> {
  /**
   * Validate source models for errors
   */
  @Override
  public void checkSourceModelForErrors(final DataModel dataModel) throws IntermediateTransformationException {
    if ((dataModel == null)) {
      this.error("Data model is empty");
    }
    boolean _isEmpty = IteratorExtensions.isEmpty(dataModel.eAllContents());
    if (_isEmpty) {
      this.error("Data model is empty");
    }
  }
}
