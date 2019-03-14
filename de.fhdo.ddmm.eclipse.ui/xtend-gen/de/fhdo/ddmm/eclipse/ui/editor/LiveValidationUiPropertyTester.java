package de.fhdo.ddmm.eclipse.ui.editor;

import com.google.common.base.Objects;
import de.fhdo.ddmm.eclipse.ui.editor.ServerConnection;
import org.eclipse.core.expressions.PropertyTester;

/**
 * Property tester for UI components related to live validation
 */
@SuppressWarnings("all")
public class LiveValidationUiPropertyTester extends PropertyTester {
  /**
   * Property test
   */
  public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (Objects.equal(property, "isConnectedToServer")) {
      _matched=true;
      _switchResult = this.testIsConnectedToServer((((Boolean) expectedValue)).booleanValue());
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  /**
   * Test if the connection to the server has the expected state
   */
  private boolean testIsConnectedToServer(final boolean expectedValue) {
    boolean _isConnected = ServerConnection.instance().isConnected();
    return (Boolean.valueOf(_isConnected) == Boolean.valueOf(expectedValue));
  }
}
