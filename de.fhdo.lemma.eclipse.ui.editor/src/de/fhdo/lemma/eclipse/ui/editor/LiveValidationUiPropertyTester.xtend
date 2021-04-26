package de.fhdo.lemma.eclipse.ui.editor

import org.eclipse.core.expressions.PropertyTester
import de.fhdo.lemma.eclipse.ui.editor.server.ServerConnection

/**
 * Property tester for UI components related to Live Validation
 */
class LiveValidationUiPropertyTester extends PropertyTester {
    /**
     * Property test
     */
    override test(Object receiver, String property, Object[] args, Object expectedValue) {
        return switch(property) {
            case "isConnectedToServer": testIsConnectedToServer(expectedValue as Boolean)
            default: false
        }
    }

    /**
     * Test if the connection to the server has the expected state
     */
    private def testIsConnectedToServer(boolean expectedValue) {
        return ServerConnection.instance.connected === expectedValue
    }
}