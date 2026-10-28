package de.fhdo.lemma.servicedsl.smells

import java.util.LinkedHashMap
import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * One occurrence of a security smell, with what it was decided from.
 *
 * A finding names the smell, the two microservices whose channel it is about,
 * and the facts the decision rests on. It carries no severity: the literature
 * does not rank these smells, and inventing a ranking would put a judgement in
 * the tool that belongs to whoever reads it.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class Finding {
    /**
     * The smell, as the literature names it.
     */
    @Accessors
    String smell

    /**
     * Section of Ponce et al. (2022) that defines it.
     */
    @Accessors
    String reference

    @Accessors
    String caller

    @Accessors
    String callee

    /**
     * What the channel is: a protocol and a path, or a queue.
     */
    @Accessors
    String channel

    /**
     * Why the channel is held to be unprotected.
     */
    @Accessors
    String reason

    /**
     * The refactoring the literature suggests.
     */
    @Accessors
    String refactoring

    /**
     * The facts the decision rests on, as the model states them.
     */
    @Accessors
    val List<String> evidence = newLinkedList

    new(String smell, String reference, String caller, String callee) {
        this.smell = smell
        this.reference = reference
        this.caller = caller
        this.callee = callee
    }

    override String toString() {
        return '''«caller» -> «callee» («channel»): «reason»'''.toString
    }
    /**
     * What causes this finding, as [[RootCause]] keys it. Findings sharing a
     * key share a repair.
     */
    @Accessors
    String rootCauseId

    /**
     * How that cause reads in a report.
     */
    @Accessors
    String rootCauseLabel

}

/**
 * What a detection run found, and what it could not decide.
 *
 * A smell the reconstruction has no facts for is not reported as absent: it is
 * reported as undecidable, so a reader can tell a system that does not smell
 * from one whose facts were not reconstructed.
 */
class DetectionResult {
    @Accessors
    val List<Finding> findings = newLinkedList

    /**
     * Channels that were found but could not be judged, with the reason.
     */
    @Accessors
    val List<String> undecided = newLinkedList

    /**
     * Channels that were judged and found to be protected.
     */
    @Accessors
    val List<String> secured = newLinkedList

    /**
     * Channels that are encrypted but not mutually authenticated.
     *
     * Its own list, not merged into ``secured``: §3.7 is resolved by TLS, so
     * these are not findings - but the refactoring the paper prescribes for
     * §3.7 is *mutual* TLS, so they were resolved by a weaker means than the
     * one cited, and that is where §3.8 Unauthenticated traffic begins.
     */
    @Accessors
    val List<String> notMutual = newLinkedList

    /**
     * Services that carry no fact about any channel of theirs.
     *
     * Not channels, and deliberately not undecided either: an undecided channel
     * was seen and could not be judged, while these services were not even
     * looked at, because nothing in the models says they communicate at all.
     * Reported so that the gap is visible in the artifact rather than only to
     * whoever reads the sources. Lakeside Mutual's Risk Management server stood
     * here while its two channels went unjudged.
     */
    @Accessors
    val List<String> unjudged = newLinkedList

    @Accessors
    val List<String> problems = newLinkedList

    def void add(Finding finding) {
        findings.add(finding)
    }

    def int channelsJudged() {
        return findings.size + secured.size + notMutual.size
    }

    /**
     * The findings grouped by what causes them, keyed by the cause's id and
     * ordered by where each cause is first met.
     *
     * Nine findings on Lakeside Mutual reduce to two causes, and a cause is
     * the unit a refactoring acts on - so this is what a report should lead
     * with and what a quickfix should offer.
     */
    def Map<String, List<Finding>> byRootCause() {
        val grouped = new LinkedHashMap<String, List<Finding>>
        for (finding : findings) {
            val key = finding.rootCauseId ?: "<ungrouped>"
            grouped.computeIfAbsent(key, [newLinkedList]).add(finding)
        }
        return grouped
    }
}
