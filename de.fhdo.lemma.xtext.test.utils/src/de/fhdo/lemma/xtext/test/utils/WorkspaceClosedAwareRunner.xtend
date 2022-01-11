package de.fhdo.lemma.xtext.test.utils

import org.eclipse.xtext.testing.XtextRunner
import org.junit.runners.model.InitializationError
import org.junit.runners.model.Statement
import org.junit.runners.model.FrameworkMethod

/**
 * XtextRunner implementation that is aware of closed Eclipse workspaces occurring in JUnit tests.
 * The main goal of the implementation is to detect the usage of getWorkspace() or similar methods
 * of Eclipse's ResourcesPlugin class. The invocation of such methods should be omitted because they
 * may prevent the usage of LEMMA components in standalone executions outside the Eclipse IDE.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class WorkspaceClosedAwareRunner extends XtextRunner {
    static val WORKSPACE_CLOSED_ERROR_MESSAGE = "Workspace is closed"

    /**
     * Constructor
     */
    new(Class<?> clazz) throws InitializationError {
        super(clazz)
    }

    /**
     * Set workspace-closed-aware Statement to be invoked by JUnit upon test invocation
     */
    override methodInvoker(FrameworkMethod method, Object test) {
        return new WorkspaceClosedAwareInvokeMethod(method, test)
    }

    /**
     * Workspace-closed-aware JUnit Statement
     */
    static class WorkspaceClosedAwareInvokeMethod extends Statement {
        val FrameworkMethod testMethod
        val Object target

        /**
         * Constructor
         */
        new(FrameworkMethod testMethod, Object target) {
            this.testMethod = testMethod
            this.target = target
        }

        /**
         * Statement logic
         */
        override evaluate() throws Throwable {
            var Throwable error
            try {
                testMethod.invokeExplosively(target);
                return
            } catch (Throwable ex) {
                error = ex
            }

            throw if (error instanceof IllegalStateException &&
                error.message.startsWith(WORKSPACE_CLOSED_ERROR_MESSAGE))
                new WorkspaceClosedException(error as IllegalStateException)
            else
                error
        }
    }

    /**
     * Specialized exception for closed workspaces
     */
    static class WorkspaceClosedException extends Exception {
        new(IllegalStateException cause) {
            super('''Caught «IllegalStateException.name» "«WORKSPACE_CLOSED_ERROR_MESSAGE»". ''' +
                "The tested code path probably intends to access an Eclipse workspace by " +
                "invoking getWorkspace() or a similar method of Eclipse's ResourcesPlugin class. " +
                "Such interactions with Eclipse's ResourcesPlugin class should be omitted " +
                "because they likely prevent standalone execution of the tested plugin.", cause)
        }
    }
}