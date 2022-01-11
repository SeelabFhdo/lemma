package de.fhdo.lemma.xtext.test.utils

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.validation.Issue
import java.util.List
import java.util.function.Predicate

import static org.junit.Assert.*

/**
 * This class extends Xtext's ValidationTestHelper class with additional utility methods for testing
 * Xtext-based modeling languages.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ExtendedValidationTestHelper extends ValidationTestHelper {
    /**
     * Assert issues with a certain severity for the given model. In case the assertion fails, the
     * test will fail with the given failure message.
     *
     * The asserted issues must all occur in the model and as per their order of appearance in the
     * expectedIssueInformation parameter.
     */
    def void assertIssuesExactlyAndOrdered(EObject model, String failureMessage,
        Severity severity, Object... expectedIssueInformation) {
        val issues = model.validate
        assertTrue(
            failureMessage.withAddition('''Not all issues of expected severity ''' +
                '''"«severity.name.toLowerCase»"'''),
            issues.forall[it.severity == severity]
        )

        val expectedIssues = expectedIssueInformation.toList.unpackToExpectedIssues(severity)
        assertIssuesExactlyAndOrdered(model, failureMessage, issues, expectedIssues)
    }

    /**
     * Attach a given addition string to a failure message. In case the addition string is null or
     * empty, return the failure message alone. In case the failure message is null or empty, return
     * only the addition string.
     */
    private def withAddition(String failureMessage, String addition) {
        return if (addition.nullOrEmpty)
            failureMessage
        else if (!failureMessage.nullOrEmpty)
            '''«failureMessage» («addition»)'''
        else
            addition
    }

    /**
     * Unpack objects to ExpectedIssue instances. An object may be (i) an ExpectedIssue instance;
     * (ii) a Pair of an EClass pointing to an Ecore concept and an issue message that can get
     * attached to the concept; or (iii) a list of such Pairs.
     */
    private def List<ExpectedIssue> unpackToExpectedIssues(List<Object> expectedIssueInformation,
        Severity severity) {
        return expectedIssueInformation.map[toExpectedIssues(severity)].flatten.toList
    }

    /**
     * Convert an object to a list of ExpectedIssue instances with the given severity. The object
     * may cluster one of the specific class instances described for the unpackToExpectedIssues()
     * method.
     */
    private def toExpectedIssues(Object issueInfo, Severity severity) {
        val expectedIssues = switch(issueInfo) {
            Pair<EClass, String>: newArrayList(new ExpectedIssue(issueInfo, severity))
            List<Pair<EClass, String>>: ExpectedIssue.fromList(issueInfo, severity)
            ExpectedIssue: {
                issueInfo.hasSeverityOrExcepton(severity)
                newArrayList(issueInfo)
            } default:
                null
        }

        if (expectedIssues === null)
            throw new IllegalArgumentException("Object is not convertible to a list of " +
                '''«ExpectedIssue.simpleName» instances because of its unsupported type ''' +
                issueInfo.class.name)

         return expectedIssues
    }

    /**
     * Ensure that an ExpectedIssue instance has a certain severity. Otherwise, throw an
     * IllegalArgumentException.
     */
    private def hasSeverityOrExcepton(ExpectedIssue issue, Severity severity) {
        if (issue.severity !== null && issue.severity !== severity)
            throw new IllegalArgumentException('''Expected issue with message «issue.message» ''' +
                '''for EObject type «issue.objectType.name» has inconsistent severity''' +
                '''"«severity.name.toLowerCase»"''')
    }

    /**
     * Assert issues with a certain severity for the given model. In case the assertion fails, the
     * test will fail with the given failure message.
     *
     * The asserted issues must all occur in the model and as per their order of appearance in the
     * expectedIssues parameter.
     */
    private def void assertIssuesExactlyAndOrdered(EObject model, String failureMessage,
        List<Issue> issues, List<ExpectedIssue> expectedIssues) {
        assertTrue(
            failureMessage.withAddition('''Unexpected issue count: «issues.size» ''' +
                '''(expected: «expectedIssues.size»)'''),
            issues.size == expectedIssues.size
        )

        expectedIssues.processAgainstIssues(issues, model, [ processedIssue |
            // Verify that an actual issue points to the same Ecore object/model element as the
            // corresponding expected issue with the same index
            val issueObject = processedIssue.issueObject
            val expectedType = processedIssue.expectedIssue.objectType
            val printableIssueIndex = processedIssue.index + 1
            assertTrue(
                failureMessage.withAddition('''Unexpected type «issueObject.class.name» for ''' +
                    '''issue «printableIssueIndex» (expected: «expectedType.class.name»)'''),
                expectedType.isInstance(issueObject)
            )

            // Verify that an actual issue has the same message as the corresponding expected issue
            // with the same index
            val issueMessage = processedIssue.issue.message
            val expectedMessage = processedIssue.expectedIssue.message
            assertTrue(
                failureMessage.withAddition('''Unexpected message "«issueMessage»" for issue ''' +
                    '''«printableIssueIndex» (expected: "«expectedMessage»")'''),
                issueMessage == expectedMessage
            )

            true
        ])
    }

    /**
     * Process a list of ExpectedIssue instances against a list of Issue instances in the context
     * of the given model and governed by the given predicate. The predicate identifies if a an
     * actual issue matches an expected issue and the method will return a list of all unmatched
     * ExpectedIssue instances.
     */
    private def List<ExpectedIssue> processAgainstIssues(
        List<ExpectedIssue> expectedIssues,
        List<Issue> issues,
        EObject model,
        Predicate<ProcessedIssue> predicate
    ) {
        val unmatchedIndices = <Integer>newArrayList(0..<expectedIssues.size)
        val remainingIndices = <Integer>newArrayList(0..<issues.size)

        val resourceSet = model.eResource.resourceSet
        val issueObjects = issues.toMap([it], [resourceSet.getEObject(it.uriToProblem, true)])

        for (expectedIssueWithIndex : expectedIssues.indexed) {
            val expectedIssueIndex = expectedIssueWithIndex.key
            val expectedIssue = expectedIssueWithIndex.value

            var issueDone = false
            for (var i = 0; !issueDone && i < remainingIndices.size; i++) {
                val issueIndex = remainingIndices.get(i)
                val issue = issues.get(issueIndex)
                val issueObject = issueObjects.get(issue)
                val processedIssue = new ProcessedIssue(issueIndex, expectedIssue, issue,
                    issueObject)

                issueDone = predicate.test(processedIssue)
                if (issueDone) {
                    remainingIndices.remove(issueIndex)
                    unmatchedIndices.remove(expectedIssueIndex)
                }
            }
        }

        return unmatchedIndices.map[expectedIssues.get(it)]
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
    def void assertIssuesOrdered(EObject model, String failureMessage, Severity severity,
        int expectedIssuesCount, Object... expectedIssueInformation) {
        val issues = model.validate
        val issuesWithSeverityCount = issues.filter[it.severity == severity].size
        val expectedIssues = expectedIssueInformation.toList.unpackToExpectedIssues(severity)
        assertTrue(
            failureMessage.withAddition('''Count of expected issues («expectedIssues.size») ''' +
                "greater than count of actual issues with severity " +
                '''"«severity.name.toLowerCase»" («issuesWithSeverityCount»)'''),
            issuesWithSeverityCount >= expectedIssues.size
        )

        assertIssuesOrdered(model, failureMessage, issues, expectedIssuesCount, expectedIssues)
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
    private def void assertIssuesOrdered(EObject model, String failureMessage, List<Issue> issues,
        int expectedIssuesCount, List<ExpectedIssue> expectedIssues) {
        assertTrue(
            failureMessage.withAddition('''Unexpected issue count: «issues.size» (expected: ''' +
                '''«expectedIssuesCount»)'''),
            issues.size == expectedIssuesCount
        )

        assertTrue(
            failureMessage.withAddition('''Count of expected issues («expectedIssues.size») ''' +
                '''greater than count of actual issues («issues.size»)'''),
            issues.size >= expectedIssues.size
        )

        val unmatchedIssues = expectedIssues.processAgainstIssues(issues, model, [ processedIssue |
            val expectedIssue = processedIssue.expectedIssue
            processedIssue.issue.severity == expectedIssue.severity &&
            processedIssue.issue.message == expectedIssue.message &&
            expectedIssue.objectType.isInstance(processedIssue.issueObject)
        ])

        val printableUnmatchedIssues = String.join(", ",
            unmatchedIssues.map['''«objectType.name»: «message»'''])
        assertTrue(failureMessage.withAddition('''Unmatched issues: «printableUnmatchedIssues»'''),
            unmatchedIssues.empty)
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
    def void assertIssuesOrdered(EObject model, String failureMessage,
        int expectedIssuesCount, List<ExpectedIssue> expectedIssues) {
        assertIssuesOrdered(model, failureMessage, model.validate, expectedIssuesCount,
            expectedIssues)
    }
}

/**
 * An expected model issue.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ExpectedIssue {
    @Accessors(PUBLIC_GETTER)
    EClass objectType
    @Accessors(PUBLIC_GETTER)
    Severity severity
    @Accessors(PUBLIC_GETTER)
    String message

    /**
     * Construct an ExpectedIssue instance from a pair of Ecore object/model element and expected
     * issue message for the given severity
     */
    new (Pair<EClass, String> objectTypeAndMessage, Severity severity) {
        this(objectTypeAndMessage.key, severity, objectTypeAndMessage.value)
    }

    /**
     * Constructor
     */
    new(EClass objectType, Severity severity, String message) {
        this.objectType= objectType
        this.severity = severity
        this.message = message
    }

    /**
     * Factory method to create a list of ExpectedIssue instances from a list of pairs of
     * Ecore objects/model elements and expected issue messages for the given severity
     */
    static def fromList(List<Pair<EClass, String>> objectTypesAndMessages, Severity severity) {
        return objectTypesAndMessages.map[new ExpectedIssue(it, severity)].toList
    }
}

/**
 * Class to cluster information about an issue during the iteration of model issues.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
package class ProcessedIssue {
    @Accessors(PACKAGE_GETTER)
    int index
    @Accessors(PACKAGE_GETTER)
    ExpectedIssue expectedIssue
    @Accessors(PACKAGE_GETTER)
    Issue issue
    @Accessors(PACKAGE_GETTER)
    EObject issueObject

    /**
     * Constructor
     */
    new(int index, ExpectedIssue expectedIssue, Issue issue, EObject issueObject) {
        this.index = index
        this.expectedIssue = expectedIssue
        this.issue = issue
        this.issueObject = issueObject
    }
}