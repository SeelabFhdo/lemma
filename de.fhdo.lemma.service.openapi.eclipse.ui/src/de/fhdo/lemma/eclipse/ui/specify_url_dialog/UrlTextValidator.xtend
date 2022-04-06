package de.fhdo.lemma.eclipse.ui.specify_url_dialog

import org.eclipse.jface.dialogs.IInputValidator
import org.apache.commons.validator.routines.UrlValidator

/**
 * This class validates a String whether it is a valid url or not.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class UrlTextValidator implements IInputValidator {

    UrlValidator urlValidator = new UrlValidator();

    /**
    * Validates the String. Returns null for no error, or an error message
    *
    * @param newUrl the Url to validate
    * @return String
    */
    override isValid(String newUrl) {
        if(urlValidator.isValid(newUrl))
            return null
        else
            return '''Not a valid Url'''
    }
}