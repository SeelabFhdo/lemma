package de.fhdo.lemma.ui.quickfix

import de.fhdo.lemma.service.ImportedServiceAspect
import de.fhdo.lemma.service.Microservice
import de.fhdo.lemma.servicedsl.smells.Finding
import de.fhdo.lemma.servicedsl.smells.validation.AspectValues
import de.fhdo.lemma.servicedsl.smells.validation.ChannelVerdict
import de.fhdo.lemma.servicedsl.smells.validation.NonSecuredCommunicationValidator
import de.fhdo.lemma.servicedsl.smells.validation.RootCause
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil

/**
 * Every channel one root cause explains, gathered from the open models.
 *
 * A warning marks one channel, but a refactoring acts on a cause - three
 * services calling one plaintext connector are one repair, and mutual TLS has
 * to reach both ends of all three at once. So the fix does not propose for the
 * channel that was clicked; it collects the cause's siblings first.
 *
 * Gathered from the resource set the clicked model belongs to, which inside
 * Eclipse holds the models it imports as well. A cause whose channels live in
 * a model nobody has opened is therefore collected only in part, and the
 * proposal says how many it found - better than silently proposing for one
 * channel of three.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class CauseFindings {
    /**
     * The findings of the cause this aspect belongs to, the clicked one first.
     */
    static def List<Finding> of(ImportedServiceAspect clicked, String rootCauseId) {
        val findings = <Finding>newLinkedList
        if (clicked === null || rootCauseId.nullOrEmpty) {
            return findings
        }

        val mine = clicked.toFinding
        if (mine !== null && rootCauseId == mine.rootCauseId) {
            findings.add(mine)
        }

        for (aspect : clicked.siblings) {
            if (aspect !== clicked) {
                val finding = aspect.toFinding
                if (finding !== null && rootCauseId == finding.rootCauseId
                    && !findings.exists[sameChannelAs(finding)]) {
                    findings.add(finding)
                }
            }
        }
        return findings
    }

    /**
     * Every channel-bearing aspect in the same resource set.
     */
    private static def Iterable<ImportedServiceAspect> siblings(ImportedServiceAspect clicked) {
        val resource = clicked.eResource
        val resourceSet = resource?.resourceSet
        val roots = <EObject>newLinkedList
        if (resourceSet !== null) {
            // A copy: loading an import can extend the set while it is read.
            for (candidate : resourceSet.resources.toList) {
                roots.addAll(candidate.contents)
            }
        } else if (resource !== null) {
            roots.addAll(resource.contents)
        }

        val aspects = <ImportedServiceAspect>newLinkedList
        for (root : roots) {
            val iterator = EcoreUtil.getAllContents(root, true)
            while (iterator.hasNext) {
                val next = iterator.next
                if (next instanceof ImportedServiceAspect) {
                    aspects.add(next)
                }
            }
        }
        return aspects
    }

    /**
     * One aspect as a finding, or null when it states no channel.
     *
     * Reuses the shared rule rather than re-deciding anything: the cause comes
     * from ``RootCause`` and the values from ``AspectValues``, exactly as the
     * validator that raised the warning used them.
     */
    private static def Finding toFinding(ImportedServiceAspect aspect) {
        val name = AspectValues.nameOf(aspect)
        val values = AspectValues.of(aspect)
        val owner = aspect.owningMicroservice
        val caller = owner?.name ?: "<unknown>"

        if ("ServiceCall" == name) {
            val target = values.get("target")
            val finding = newFinding(caller, target, '''call to «target»'''.toString)
            val cause = RootCause.ofCall(target)
            finding.rootCauseId = cause.id
            finding.rootCauseLabel = cause.label
            finding.evidence.add(aspect.written)
            return finding
        }
        if ("MessageChannel" == name) {
            val target = values.get("target")
            val queue = values.get("queue")
            val finding = newFinding(caller, target, '''queue «queue»'''.toString)
            val cause = RootCause.ofQueue(values.get("broker"), values.get("scheme"))
            finding.rootCauseId = cause.id
            finding.rootCauseLabel = cause.label
            finding.evidence.add(aspect.written)
            return finding
        }
        return null
    }

    private static def Finding newFinding(String caller, String callee, String channel) {
        val finding = new Finding(ChannelVerdict.SMELL, ChannelVerdict.REFERENCE, caller,
            callee ?: "<unnamed>")
        finding.channel = channel
        finding.refactoring = ChannelVerdict.REFACTORING
        return finding
    }

    private static def boolean sameChannelAs(Finding one, Finding other) {
        return one.caller == other.caller && one.callee == other.callee
            && one.channel == other.channel
    }

    private static def Microservice owningMicroservice(EObject object) {
        var EObject container = object
        while (container !== null) {
            if (container instanceof Microservice) {
                return container
            }
            container = container.eContainer
        }
        return null
    }

    /**
     * What the model wrote for this aspect, so the proposal carries the
     * evidence as the model states it rather than a paraphrase.
     */
    private static def String written(ImportedServiceAspect aspect) {
        val node = org.eclipse.xtext.nodemodel.util.NodeModelUtils.findActualNodeFor(aspect)
        if (node === null) {
            return AspectValues.nameOf(aspect) ?: "<unresolved aspect>"
        }
        return org.eclipse.xtext.nodemodel.util.NodeModelUtils.getTokenText(node)?.trim
    }

    /**
     * The issue code the warnings this acts on carry.
     */
    static def String issueCode() {
        return NonSecuredCommunicationValidator.NON_SECURED_COMMUNICATION
    }
}
