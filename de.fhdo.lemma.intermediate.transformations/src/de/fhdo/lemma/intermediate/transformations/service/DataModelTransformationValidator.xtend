package de.fhdo.lemma.intermediate.transformations.service

import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.intermediate.transformations.AbstractInputModelValidator
import de.fhdo.lemma.intermediate.transformations.IntermediateTransformationException

/**
 * Validator for data models that shall be transformed.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class DataModelTransformationValidator extends AbstractInputModelValidator<DataModel> {
    /**
     * Validate input models for errors
     */
    override checkInputModelForErrors(DataModel dataModel)
        throws IntermediateTransformationException {
        if (dataModel === null)
            error("Data model is empty")

        if (dataModel.eAllContents.empty)
            error("Data model is empty")
    }
}