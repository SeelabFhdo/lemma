package de.fhdo.ddmm.intermediate.transformations.service

import de.fhdo.ddmm.intermediate.transformations.AbstractSourceModelValidator
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationException
import de.fhdo.ddmm.data.DataModel

/**
 * Validator for data models that shall be transformed.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class DataModelTransformationValidator extends AbstractSourceModelValidator<DataModel> {
    /**
     * Validate source models for errors
     */
    override checkSourceModelForErrors(DataModel dataModel)
        throws IntermediateTransformationException {
        if (dataModel === null)
            error("Data model is empty")

        if (dataModel.eAllContents.empty)
            error("Data model is empty")
    }
}