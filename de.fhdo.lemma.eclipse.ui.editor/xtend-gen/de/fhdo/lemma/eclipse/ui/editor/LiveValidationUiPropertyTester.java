package de.fhdo.lemma.eclipse.ui.editor;

import de.fhdo.lemma.eclipse.ui.editor.server.ServerConnection;
import org.eclipse.core.expressions.PropertyTester;

/**
 * Property tester for UI components related to Live Validation
 */
@SuppressWarnings("all")
public class LiveValidationUiPropertyTester extends PropertyTester {
  /**
   * Property test
   */
  @Override
  public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
    boolean _switchResult = false;
    if (property != null) {
      switch (property) {
        case "isConnectedToServer":
          _switchResult = this.testIsConnectedToServer((((Boolean) expectedValue)).booleanValue());
          break;
        default:
          _switchResult = false;
          break;
      }
    } else {
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
