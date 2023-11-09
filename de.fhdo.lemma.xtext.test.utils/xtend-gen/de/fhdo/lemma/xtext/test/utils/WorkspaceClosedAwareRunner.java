package de.fhdo.lemma.xtext.test.utils;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

/**
 * XtextRunner implementation that is aware of closed Eclipse workspaces occurring in JUnit tests.
 * The main goal of the implementation is to detect the usage of getWorkspace() or similar methods
 * of Eclipse's ResourcesPlugin class. The invocation of such methods should be omitted because they
 * may prevent the usage of LEMMA components in standalone executions outside the Eclipse IDE.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class WorkspaceClosedAwareRunner extends XtextRunner {
  /**
   * Workspace-closed-aware JUnit Statement
   */
  public static class WorkspaceClosedAwareInvokeMethod extends Statement {
    private final FrameworkMethod testMethod;

    private final Object target;

    /**
     * Constructor
     */
    public WorkspaceClosedAwareInvokeMethod(final FrameworkMethod testMethod, final Object target) {
      this.testMethod = testMethod;
      this.target = target;
    }

    /**
     * Statement logic
     */
    @Override
    public void evaluate() throws Throwable {
      Throwable error = null;
      try {
        this.testMethod.invokeExplosively(this.target);
        return;
      } catch (final Throwable _t) {
        if (_t instanceof Throwable) {
          final Throwable ex = (Throwable)_t;
          error = ex;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      Throwable _xifexpression = null;
      if (((error instanceof IllegalStateException) && 
        error.getMessage().startsWith(WorkspaceClosedAwareRunner.WORKSPACE_CLOSED_ERROR_MESSAGE))) {
        _xifexpression = new WorkspaceClosedAwareRunner.WorkspaceClosedException(((IllegalStateException) error));
      } else {
        _xifexpression = error;
      }
      throw _xifexpression;
    }
  }

  /**
   * Specialized exception for closed workspaces
   */
  public static class WorkspaceClosedException extends Exception {
    public WorkspaceClosedException(final IllegalStateException cause) {
      super(new Function0<String>() {
        @Override
        public String apply() {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Caught ");
          String _name = IllegalStateException.class.getName();
          _builder.append(_name);
          _builder.append(" \"");
          _builder.append(WorkspaceClosedAwareRunner.WORKSPACE_CLOSED_ERROR_MESSAGE);
          _builder.append("\". ");
          String _plus = (_builder.toString() + 
            "The tested code path probably intends to access an Eclipse workspace by ");
          String _plus_1 = (_plus + 
            "invoking getWorkspace() or a similar method of Eclipse\'s ResourcesPlugin class. ");
          String _plus_2 = (_plus_1 + 
            "Such interactions with Eclipse\'s ResourcesPlugin class should be omitted ");
          String _plus_3 = (_plus_2 + 
            "because they likely prevent standalone execution of the tested plugin.");
          return _plus_3;
        }
      }.apply(), cause);
    }
  }

  private static final String WORKSPACE_CLOSED_ERROR_MESSAGE = "Workspace is closed";

  /**
   * Constructor
   */
  public WorkspaceClosedAwareRunner(final Class<?> clazz) throws InitializationError {
    super(clazz);
  }

  /**
   * Set workspace-closed-aware Statement to be invoked by JUnit upon test invocation
   */
  @Override
  public Statement methodInvoker(final FrameworkMethod method, final Object test) {
    return new WorkspaceClosedAwareRunner.WorkspaceClosedAwareInvokeMethod(method, test);
  }
}
