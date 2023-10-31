package de.fhdo.lemma.xtext.test.utils;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Assert;

/**
 * This class extends Xtext's ValidationTestHelper class with additional utility methods for testing
 * Xtext-based modeling languages.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ExtendedValidationTestHelper extends ValidationTestHelper {
  /**
   * Assert issues with a certain severity for the given model. In case the assertion fails, the
   * test will fail with the given failure message.
   * 
   * The asserted issues must all occur in the model and as per their order of appearance in the
   * expectedIssueInformation parameter.
   */
  public void assertIssuesExactlyAndOrdered(final EObject model, final String failureMessage, final Severity severity, final Object... expectedIssueInformation) {
    final List<Issue> issues = this.validate(model);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Not all issues of expected severity ");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("\"");
    String _lowerCase = severity.name().toLowerCase();
    _builder_1.append(_lowerCase);
    _builder_1.append("\"");
    String _plus = (_builder.toString() + _builder_1);
    final Function1<Issue, Boolean> _function = (Issue it) -> {
      Severity _severity = it.getSeverity();
      return Boolean.valueOf(Objects.equal(_severity, severity));
    };
    Assert.assertTrue(
      this.withAddition(failureMessage, _plus), 
      IterableExtensions.<Issue>forall(issues, _function));
    final List<ExpectedIssue> expectedIssues = this.unpackToExpectedIssues(IterableExtensions.<Object>toList(((Iterable<Object>)Conversions.doWrapArray(expectedIssueInformation))), severity);
    this.assertIssuesExactlyAndOrdered(model, failureMessage, issues, expectedIssues);
  }

  /**
   * Attach a given addition string to a failure message. In case the addition string is null or
   * empty, return the failure message alone. In case the failure message is null or empty, return
   * only the addition string.
   */
  private String withAddition(final String failureMessage, final String addition) {
    String _xifexpression = null;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(addition);
    if (_isNullOrEmpty) {
      _xifexpression = failureMessage;
    } else {
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(failureMessage);
      boolean _not = (!_isNullOrEmpty_1);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(failureMessage);
        _builder.append(" (");
        _builder.append(addition);
        _builder.append(")");
        _xifexpression_1 = _builder.toString();
      } else {
        _xifexpression_1 = addition;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }

  /**
   * Unpack objects to ExpectedIssue instances. An object may be (i) an ExpectedIssue instance;
   * (ii) a Pair of an EClass pointing to an Ecore concept and an issue message that can get
   * attached to the concept; or (iii) a list of such Pairs.
   */
  private List<ExpectedIssue> unpackToExpectedIssues(final List<Object> expectedIssueInformation, final Severity severity) {
    final Function1<Object, List<ExpectedIssue>> _function = (Object it) -> {
      return this.toExpectedIssues(it, severity);
    };
    return IterableExtensions.<ExpectedIssue>toList(Iterables.<ExpectedIssue>concat(ListExtensions.<Object, List<ExpectedIssue>>map(expectedIssueInformation, _function)));
  }

  /**
   * Convert an object to a list of ExpectedIssue instances with the given severity. The object
   * may cluster one of the specific class instances described for the unpackToExpectedIssues()
   * method.
   */
  private List<ExpectedIssue> toExpectedIssues(final Object issueInfo, final Severity severity) {
    List<ExpectedIssue> _switchResult = null;
    boolean _matched = false;
    if (issueInfo instanceof Pair) {
      _matched=true;
      ExpectedIssue _expectedIssue = new ExpectedIssue(((Pair<EClass, String>)issueInfo), severity);
      _switchResult = CollectionLiterals.<ExpectedIssue>newArrayList(_expectedIssue);
    }
    if (!_matched) {
      if (issueInfo instanceof List) {
        _matched=true;
        _switchResult = ExpectedIssue.fromList(((List<Pair<EClass, String>>)issueInfo), severity);
      }
    }
    if (!_matched) {
      if (issueInfo instanceof ExpectedIssue) {
        _matched=true;
        ArrayList<ExpectedIssue> _xblockexpression = null;
        {
          this.hasSeverityOrExcepton(((ExpectedIssue)issueInfo), severity);
          _xblockexpression = CollectionLiterals.<ExpectedIssue>newArrayList(((ExpectedIssue)issueInfo));
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    final List<ExpectedIssue> expectedIssues = _switchResult;
    if ((expectedIssues == null)) {
      StringConcatenation _builder = new StringConcatenation();
      String _simpleName = ExpectedIssue.class.getSimpleName();
      _builder.append(_simpleName);
      _builder.append(" instances because of its unsupported type ");
      String _plus = ("Object is not convertible to a list of " + _builder);
      String _name = issueInfo.getClass().getName();
      String _plus_1 = (_plus + _name);
      throw new IllegalArgumentException(_plus_1);
    }
    return expectedIssues;
  }

  /**
   * Ensure that an ExpectedIssue instance has a certain severity. Otherwise, throw an
   * IllegalArgumentException.
   */
  private void hasSeverityOrExcepton(final ExpectedIssue issue, final Severity severity) {
    if (((issue.getSeverity() != null) && (issue.getSeverity() != severity))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Expected issue with message ");
      String _message = issue.getMessage();
      _builder.append(_message);
      _builder.append(" ");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("for EObject type ");
      String _name = issue.getObjectType().getName();
      _builder_1.append(_name);
      _builder_1.append(" has inconsistent severity");
      String _plus = (_builder.toString() + _builder_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("\"");
      String _lowerCase = severity.name().toLowerCase();
      _builder_2.append(_lowerCase);
      _builder_2.append("\"");
      String _plus_1 = (_plus + _builder_2);
      throw new IllegalArgumentException(_plus_1);
    }
  }

  /**
   * Assert issues with a certain severity for the given model. In case the assertion fails, the
   * test will fail with the given failure message.
   * 
   * The asserted issues must all occur in the model and as per their order of appearance in the
   * expectedIssues parameter.
   */
  private void assertIssuesExactlyAndOrdered(final EObject model, final String failureMessage, final List<Issue> issues, final List<ExpectedIssue> expectedIssues) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Unexpected issue count: ");
    int _size = issues.size();
    _builder.append(_size);
    _builder.append(" ");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("(expected: ");
    int _size_1 = expectedIssues.size();
    _builder_1.append(_size_1);
    _builder_1.append(")");
    String _plus = (_builder.toString() + _builder_1);
    String _withAddition = this.withAddition(failureMessage, _plus);
    int _size_2 = issues.size();
    int _size_3 = expectedIssues.size();
    boolean _equals = (_size_2 == _size_3);
    Assert.assertTrue(_withAddition, _equals);
    final Predicate<ProcessedIssue> _function = (ProcessedIssue processedIssue) -> {
      boolean _xblockexpression = false;
      {
        final EObject issueObject = processedIssue.getIssueObject();
        final EClass expectedType = processedIssue.getExpectedIssue().getObjectType();
        int _index = processedIssue.getIndex();
        final int printableIssueIndex = (_index + 1);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("Unexpected type ");
        String _name = issueObject.getClass().getName();
        _builder_2.append(_name);
        _builder_2.append(" for ");
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("issue ");
        _builder_3.append(printableIssueIndex);
        _builder_3.append(" (expected: ");
        String _name_1 = expectedType.getClass().getName();
        _builder_3.append(_name_1);
        _builder_3.append(")");
        String _plus_1 = (_builder_2.toString() + _builder_3);
        Assert.assertTrue(
          this.withAddition(failureMessage, _plus_1), 
          expectedType.isInstance(issueObject));
        final String issueMessage = processedIssue.getIssue().getMessage();
        final String expectedMessage = processedIssue.getExpectedIssue().getMessage();
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("Unexpected message \"");
        _builder_4.append(issueMessage);
        _builder_4.append("\" for issue ");
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append(printableIssueIndex);
        _builder_5.append(" (expected: \"");
        _builder_5.append(expectedMessage);
        _builder_5.append("\")");
        String _plus_2 = (_builder_4.toString() + _builder_5);
        String _withAddition_1 = this.withAddition(failureMessage, _plus_2);
        boolean _equals_1 = Objects.equal(issueMessage, expectedMessage);
        Assert.assertTrue(_withAddition_1, _equals_1);
        _xblockexpression = true;
      }
      return _xblockexpression;
    };
    this.processAgainstIssues(expectedIssues, issues, model, _function);
  }

  /**
   * Process a list of ExpectedIssue instances against a list of Issue instances in the context
   * of the given model and governed by the given predicate. The predicate identifies if a an
   * actual issue matches an expected issue and the method will return a list of all unmatched
   * ExpectedIssue instances.
   */
  private List<ExpectedIssue> processAgainstIssues(final List<ExpectedIssue> expectedIssues, final List<Issue> issues, final EObject model, final Predicate<ProcessedIssue> predicate) {
    int _size = expectedIssues.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    final ArrayList<Integer> unmatchedIndices = CollectionLiterals.<Integer>newArrayList(((Integer[])Conversions.unwrapArray(_doubleDotLessThan, Integer.class)));
    int _size_1 = issues.size();
    ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
    final ArrayList<Integer> remainingIndices = CollectionLiterals.<Integer>newArrayList(((Integer[])Conversions.unwrapArray(_doubleDotLessThan_1, Integer.class)));
    final ResourceSet resourceSet = model.eResource().getResourceSet();
    final Function1<Issue, Issue> _function = (Issue it) -> {
      return it;
    };
    final Function1<Issue, EObject> _function_1 = (Issue it) -> {
      return resourceSet.getEObject(it.getUriToProblem(), true);
    };
    final Map<Issue, EObject> issueObjects = IterableExtensions.<Issue, Issue, EObject>toMap(issues, _function, _function_1);
    Iterable<Pair<Integer, ExpectedIssue>> _indexed = IterableExtensions.<ExpectedIssue>indexed(expectedIssues);
    for (final Pair<Integer, ExpectedIssue> expectedIssueWithIndex : _indexed) {
      {
        final Integer expectedIssueIndex = expectedIssueWithIndex.getKey();
        final ExpectedIssue expectedIssue = expectedIssueWithIndex.getValue();
        boolean issueDone = false;
        for (int i = 0; ((!issueDone) && (i < remainingIndices.size())); i++) {
          {
            final Integer issueIndex = remainingIndices.get(i);
            final Issue issue = issues.get((issueIndex).intValue());
            final EObject issueObject = issueObjects.get(issue);
            final ProcessedIssue processedIssue = new ProcessedIssue((issueIndex).intValue(), expectedIssue, issue, issueObject);
            issueDone = predicate.test(processedIssue);
            if (issueDone) {
              remainingIndices.remove(issueIndex);
              unmatchedIndices.remove(expectedIssueIndex);
            }
          }
        }
      }
    }
    final Function1<Integer, ExpectedIssue> _function_2 = (Integer it) -> {
      return expectedIssues.get((it).intValue());
    };
    return ListExtensions.<Integer, ExpectedIssue>map(unmatchedIndices, _function_2);
  }

  /**
   * Assert issues with a certain severity for the given model. In case the assertion fails, the
   * test will fail with the given failure message.
   * 
   * The tested model must exhibit exactly as many issues as specified by the expectedIssuesCount
   * parameter. The asserted issues must all occur in the model and as per their order of
   * appearance in the expectedIssues parameter. However, the number of asserted issues may be
   * lower than then actual issues in the model, i.e., the number of asserted issues may be lower
   * than expectedIssuesCount.
   */
  public void assertIssuesOrdered(final EObject model, final String failureMessage, final Severity severity, final int expectedIssuesCount, final Object... expectedIssueInformation) {
    final List<Issue> issues = this.validate(model);
    final Function1<Issue, Boolean> _function = (Issue it) -> {
      Severity _severity = it.getSeverity();
      return Boolean.valueOf(Objects.equal(_severity, severity));
    };
    final int issuesWithSeverityCount = IterableExtensions.size(IterableExtensions.<Issue>filter(issues, _function));
    final List<ExpectedIssue> expectedIssues = this.unpackToExpectedIssues(IterableExtensions.<Object>toList(((Iterable<Object>)Conversions.doWrapArray(expectedIssueInformation))), severity);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Count of expected issues (");
    int _size = expectedIssues.size();
    _builder.append(_size);
    _builder.append(") ");
    String _plus = (_builder.toString() + 
      "greater than count of actual issues with severity ");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("\"");
    String _lowerCase = severity.name().toLowerCase();
    _builder_1.append(_lowerCase);
    _builder_1.append("\" (");
    _builder_1.append(issuesWithSeverityCount);
    _builder_1.append(")");
    String _plus_1 = (_plus + _builder_1);
    String _withAddition = this.withAddition(failureMessage, _plus_1);
    int _size_1 = expectedIssues.size();
    boolean _greaterEqualsThan = (issuesWithSeverityCount >= _size_1);
    Assert.assertTrue(_withAddition, _greaterEqualsThan);
    this.assertIssuesOrdered(model, failureMessage, issues, expectedIssuesCount, expectedIssues);
  }

  /**
   * Assert issues with a certain severity for the given model. In case the assertion fails, the
   * test will fail with the given failure message.
   * 
   * The tested model must exhibit exactly as many issues as specified by the expectedIssuesCount
   * parameter. The asserted issues must all occur in the model and as per their order of
   * appearance in the expectedIssues parameter. However, the number of asserted issues may be
   * lower than then actual issues in the model, i.e., the number of asserted issues may be lower
   * than expectedIssuesCount.
   */
  private void assertIssuesOrdered(final EObject model, final String failureMessage, final List<Issue> issues, final int expectedIssuesCount, final List<ExpectedIssue> expectedIssues) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Unexpected issue count: ");
    int _size = issues.size();
    _builder.append(_size);
    _builder.append(" (expected: ");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(expectedIssuesCount);
    _builder_1.append(")");
    String _plus = (_builder.toString() + _builder_1);
    String _withAddition = this.withAddition(failureMessage, _plus);
    int _size_1 = issues.size();
    boolean _equals = (_size_1 == expectedIssuesCount);
    Assert.assertTrue(_withAddition, _equals);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("Count of expected issues (");
    int _size_2 = expectedIssues.size();
    _builder_2.append(_size_2);
    _builder_2.append(") ");
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("greater than count of actual issues (");
    int _size_3 = issues.size();
    _builder_3.append(_size_3);
    _builder_3.append(")");
    String _plus_1 = (_builder_2.toString() + _builder_3);
    String _withAddition_1 = this.withAddition(failureMessage, _plus_1);
    int _size_4 = issues.size();
    int _size_5 = expectedIssues.size();
    boolean _greaterEqualsThan = (_size_4 >= _size_5);
    Assert.assertTrue(_withAddition_1, _greaterEqualsThan);
    final Predicate<ProcessedIssue> _function = (ProcessedIssue processedIssue) -> {
      boolean _xblockexpression = false;
      {
        final ExpectedIssue expectedIssue = processedIssue.getExpectedIssue();
        _xblockexpression = ((Objects.equal(processedIssue.getIssue().getSeverity(), expectedIssue.getSeverity()) && 
          Objects.equal(processedIssue.getIssue().getMessage(), expectedIssue.getMessage())) && 
          expectedIssue.getObjectType().isInstance(processedIssue.getIssueObject()));
      }
      return _xblockexpression;
    };
    final List<ExpectedIssue> unmatchedIssues = this.processAgainstIssues(expectedIssues, issues, model, _function);
    final Function1<ExpectedIssue, String> _function_1 = (ExpectedIssue it) -> {
      StringConcatenation _builder_4 = new StringConcatenation();
      String _name = it.getObjectType().getName();
      _builder_4.append(_name);
      _builder_4.append(": ");
      String _message = it.getMessage();
      _builder_4.append(_message);
      return _builder_4.toString();
    };
    final String printableUnmatchedIssues = String.join(", ", 
      ListExtensions.<ExpectedIssue, String>map(unmatchedIssues, _function_1));
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("Unmatched issues: ");
    _builder_4.append(printableUnmatchedIssues);
    Assert.assertTrue(this.withAddition(failureMessage, _builder_4.toString()), 
      unmatchedIssues.isEmpty());
  }

  /**
   * Assert issues with arbitrary severity for the given model. In case the assertion fails, the
   * test will fail with the given failure message.
   * 
   * The tested model must exhibit exactly as many issues as specified by the expectedIssuesCount
   * parameter. The asserted issues must all occur in the model and as per their order of
   * appearance in the expectedIssues parameter. However, the number of asserted issues may be
   * lower than then actual issues in the model, i.e., the number of asserted issues may be lower
   * than expectedIssuesCount.
   */
  public void assertIssuesOrdered(final EObject model, final String failureMessage, final int expectedIssuesCount, final List<ExpectedIssue> expectedIssues) {
    this.assertIssuesOrdered(model, failureMessage, this.validate(model), expectedIssuesCount, expectedIssues);
  }
}
