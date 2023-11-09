package de.fhdo.lemma.xtext.test.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Class to cluster information about an issue during the iteration of model issues.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
class ProcessedIssue {
  @Accessors(AccessorType.PACKAGE_GETTER)
  private int index;

  @Accessors(AccessorType.PACKAGE_GETTER)
  private ExpectedIssue expectedIssue;

  @Accessors(AccessorType.PACKAGE_GETTER)
  private Issue issue;

  @Accessors(AccessorType.PACKAGE_GETTER)
  private EObject issueObject;

  /**
   * Constructor
   */
  public ProcessedIssue(final int index, final ExpectedIssue expectedIssue, final Issue issue, final EObject issueObject) {
    this.index = index;
    this.expectedIssue = expectedIssue;
    this.issue = issue;
    this.issueObject = issueObject;
  }

  @Pure
  int getIndex() {
    return this.index;
  }

  @Pure
  ExpectedIssue getExpectedIssue() {
    return this.expectedIssue;
  }

  @Pure
  Issue getIssue() {
    return this.issue;
  }

  @Pure
  EObject getIssueObject() {
    return this.issueObject;
  }
}
