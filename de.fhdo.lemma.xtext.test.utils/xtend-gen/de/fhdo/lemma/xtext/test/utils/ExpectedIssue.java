package de.fhdo.lemma.xtext.test.utils;

import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * An expected model issue.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ExpectedIssue {
  @Accessors(AccessorType.PUBLIC_GETTER)
  private EClass objectType;

  @Accessors(AccessorType.PUBLIC_GETTER)
  private Severity severity;

  @Accessors(AccessorType.PUBLIC_GETTER)
  private String message;

  /**
   * Construct an ExpectedIssue instance from a pair of Ecore object/model element and expected
   * issue message for the given severity
   */
  public ExpectedIssue(final Pair<EClass, String> objectTypeAndMessage, final Severity severity) {
    this(objectTypeAndMessage.getKey(), severity, objectTypeAndMessage.getValue());
  }

  /**
   * Constructor
   */
  public ExpectedIssue(final EClass objectType, final Severity severity, final String message) {
    this.objectType = objectType;
    this.severity = severity;
    this.message = message;
  }

  /**
   * Factory method to create a list of ExpectedIssue instances from a list of pairs of
   * Ecore objects/model elements and expected issue messages for the given severity
   */
  public static List<ExpectedIssue> fromList(final List<Pair<EClass, String>> objectTypesAndMessages, final Severity severity) {
    final Function1<Pair<EClass, String>, ExpectedIssue> _function = (Pair<EClass, String> it) -> {
      return new ExpectedIssue(it, severity);
    };
    return IterableExtensions.<ExpectedIssue>toList(ListExtensions.<Pair<EClass, String>, ExpectedIssue>map(objectTypesAndMessages, _function));
  }

  @Pure
  public EClass getObjectType() {
    return this.objectType;
  }

  @Pure
  public Severity getSeverity() {
    return this.severity;
  }

  @Pure
  public String getMessage() {
    return this.message;
  }
}
