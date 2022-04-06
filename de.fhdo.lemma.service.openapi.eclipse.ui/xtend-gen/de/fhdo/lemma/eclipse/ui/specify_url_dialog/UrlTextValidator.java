package de.fhdo.lemma.eclipse.ui.specify_url_dialog;

import org.apache.commons.validator.routines.UrlValidator;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * This class validates a String whether it is a valid url or not.
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public class UrlTextValidator implements IInputValidator {
  private UrlValidator urlValidator = new UrlValidator();
  
  /**
   * Validates the String. Returns null for no error, or an error message
   * 
   * @param newUrl the Url to validate
   * @return String
   */
  @Override
  public String isValid(final String newUrl) {
    boolean _isValid = this.urlValidator.isValid(newUrl);
    if (_isValid) {
      return null;
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Not a valid Url");
      return _builder.toString();
    }
  }
}
