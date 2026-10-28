package de.fhdo.lemma.servicedsl.smells.refactoring

import de.fhdo.lemma.servicedsl.smells.DetectionResult
import java.util.List

/**
 * Turns a detection result into one request per root cause.
 *
 * The step between detecting and proposing. A finding is a symptom; a cause is
 * a repair - so nine findings on Lakeside Mutual become two requests, each
 * carrying every finding it has to resolve and the names of the causes it must
 * leave alone.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class RefactoringRequests {
    /**
     * One request per cause, in the order the causes were first met.
     */
    static def List<RefactoringRequest> of(DetectionResult result, String sourceRoot,
        String skill) {
        val requests = <RefactoringRequest>newLinkedList
        val grouped = result.byRootCause

        for (group : grouped.entrySet) {
            val request = new RefactoringRequest
            request.rootCauseId = group.key
            request.rootCauseLabel = group.value.head?.rootCauseLabel ?: group.key
            request.findings.addAll(group.value)
            request.sourceRoot = sourceRoot
            request.skill = skill
            // What this request must not touch. Without it a proposer asked
            // about a connector may also "helpfully" convert the broker, and
            // the patch stops being reviewable as one change.
            for (other : grouped.entrySet) {
                if (other.key != group.key) {
                    request.otherCauses.add(other.value.head?.rootCauseLabel ?: other.key)
                }
            }
            requests.add(request)
        }
        return requests
    }
}
