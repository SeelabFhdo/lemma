package de.fhdo.lemma.servicedsl.smells

import de.fhdo.lemma.servicedsl.diagram.AspectReference
import de.fhdo.lemma.servicedsl.diagram.ServiceGraph
import de.fhdo.lemma.servicedsl.diagram.ServiceNode
import de.fhdo.lemma.servicedsl.smells.validation.ChannelVerdict
import de.fhdo.lemma.servicedsl.smells.validation.Outcome
import de.fhdo.lemma.servicedsl.smells.validation.RootCause

/**
 * Detector of **Non-Secured Service-to-Service Communications**, §3.7 of
 *
 *     Ponce, Soldani, Astudillo, Brogi: Smells and refactorings for
 *     microservices security. JSS 192 (2022) 111393.
 *
 * The paper defines the smell as two microservices interacting "without
 * enacting a secure communication channel, **even if they are within the same
 * network**". That last clause is what makes a plaintext call inside a
 * container network a finding rather than a false positive.
 *
 * ## What it decides, and what it does not
 *
 * MRF collects facts; this decides the smell (ADR-0009). A channel is judged
 * from the facts the model carries for it:
 *
 * - a synchronous call: the scheme the caller uses, and whether the callee's
 *   connector accepts plaintext
 * - a channel through a queue: the transport of the broker
 *
 * A channel whose facts do not settle the question is reported as **undecided**
 * rather than as secure or as a smell. A system that does not smell and a
 * system whose facts were never reconstructed must not look alike.
 *
 * The detector is a function of a [[ServiceGraph]] and nothing else: no file
 * system, no workspace, no Eclipse.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class NonSecuredCommunicationDetector {
    public static val SMELL = ChannelVerdict.SMELL
    public static val REFERENCE = ChannelVerdict.REFERENCE
    public static val REFACTORING = ChannelVerdict.REFACTORING

    static val SERVICE_CALL = "ServiceCall"
    static val MESSAGE_CHANNEL = "MessageChannel"
    static val SERVER_ENDPOINT = "ServerEndpoint"
    static val GRPC_SERVER = "GrpcServer"
    static val MESSAGE_QUEUE = "MessageQueue"

    static val TARGET = "target"
    static val TARGET_KIND = "targetKind"
    static val SCHEME = "scheme"
    static val TRANSPORT = "transport"
    static val QUEUE = "queue"
    static val ROLE = "role"
    static val BROKER = "broker"
    static val TLS_ENABLED = "tlsEnabled"
    static val CONNECTOR = "connector"
    static val PORT = "port"
    static val HOST = "host"
    static val CLIENT_AUTH = "clientAuth"
    static val TRANSPORT_SECURITY = "transportSecurity"

    /**
     * The aspects that say anything about a service's channels.
     *
     * A service carrying none of them was not judged at all, which is not the
     * same as having nothing to judge, so the report names it. The Risk
     * Management server of Lakeside Mutual was such a service until its two
     * Node facts reached the models, and its plaintext gRPC endpoint and its
     * plaintext broker connection were invisible for as long as that lasted.
     */
    static val COMMUNICATION_FACTS = #[
        SERVICE_CALL, MESSAGE_CHANNEL, SERVER_ENDPOINT, GRPC_SERVER, MESSAGE_QUEUE
    ]

    /**
     * What a finding names as the caller where the model names none.
     *
     * An endpoint is judged from the server's end, so its peer may be something
     * the reconstruction does not model - a command line tool, a client outside
     * the application. Naming it this way keeps the finding readable without
     * claiming a caller that was never read.
     */
    static val UNIDENTIFIED_PEER = "an unidentified peer"

    static val KIND_SERVICE = "SERVICE"
    static val ROLE_PRODUCER = "producer"
    static val PLAINTEXT = "plaintext"
    static val UNRESOLVED = "unresolved"
    static val CLIENT_AUTH_REQUIRED = "need"

    /**
     * Judge every interaction the graph holds.
     *
     * @param graph the services and their facts
     * @return the findings, the channels judged secure, and the undecided ones
     */
    def DetectionResult detect(ServiceGraph graph) {
        val result = new DetectionResult
        if (graph.empty) {
            result.problems.add("No service model was read, so nothing was judged.")
            return result
        }

        for (service : graph.services.filter[resolved]) {
            for (aspect : service.aspects) {
                switch (aspect.name) {
                    case SERVICE_CALL: judgeCall(service, aspect, graph, result)
                    case MESSAGE_CHANNEL: judgeChannel(service, aspect, result)
                    case GRPC_SERVER: judgeListener(service, aspect, result)
                    case MESSAGE_QUEUE: judgeBrokerConnection(service, aspect, result)
                    default: {}
                }
            }
            if (!service.aspects.exists[COMMUNICATION_FACTS.contains(name)]) {
                result.unjudged.add(service.name)
            }
        }
        return result
    }

    /**
     * Judge one synchronous call.
     *
     * A call to something that is not a service of this system is not this
     * smell: the paper's smell is about two microservices of the application.
     */
    private def void judgeCall(ServiceNode caller, AspectReference aspect,
        ServiceGraph graph, DetectionResult result) {
        val target = aspect.valueOf(TARGET)
        if (target === null) {
            result.undecided.add(
                '''«caller.name» makes a call whose target the model does not name''')
            return
        }
        val kind = aspect.valueOf(TARGET_KIND)
        if (kind !== null && KIND_SERVICE != kind) {
            // A third party, not a microservice of this application.
            return
        }

        val channel = '''call to «target»'''.toString
        val callee = graph.services.findFirst[name == target && resolved]
        val verdict = ChannelVerdict.ofCall(aspect.valueOf(SCHEME), kind,
            calleeAcceptsPlaintext(callee), calleeClientAuth(callee))

        switch (verdict.outcome) {
            case NOT_APPLICABLE: return
            case UNDECIDED: {
                result.undecided.add(
                    '''«caller.name» -> «target» («channel»): «verdict.reason»''')
                return
            }
            case PROTECTED: {
                result.secured.add('''«caller.name» -> «target»: «verdict.reason»''')
                return
            }
            case PROTECTED_NOT_MUTUAL: {
                result.notMutual.add('''«caller.name» -> «target»: «verdict.reason»''')
                return
            }
            case SMELL: {
                val cause = RootCause.ofCall(target)
                val finding = newFinding(caller.name, target, channel)
                finding.reason = verdict.reason
                finding.rootCauseId = cause.id
                finding.rootCauseLabel = cause.label
                finding.evidence.add(aspect.written)
                if (callee !== null) {
                    callee.aspects.filter[name == SERVER_ENDPOINT].forEach[
                        finding.evidence.add(written)
                    ]
                }
                result.add(finding)
            }
        }
    }

    /**
     * Judge one channel through a queue.
     *
     * Only the producer's end is judged, although both ends carry the fact: the
     * channel is one interaction, and judging it twice would report the same
     * finding from each side. A consumer-only channel - nothing of this system
     * publishes to it - is undecided rather than judged, because the other end
     * is outside what was reconstructed.
     */
    private def void judgeChannel(ServiceNode service, AspectReference aspect,
        DetectionResult result) {
        val target = aspect.valueOf(TARGET)
        val queue = aspect.valueOf(QUEUE) ?: "a queue"
        val role = aspect.valueOf(ROLE)

        if (target === null) {
            result.undecided.add(
                '''«service.name» uses «queue» and nothing of this system is at the other end''')
            return
        }
        if (ROLE_PRODUCER != role) {
            return
        }

        val channel = '''queue «queue»'''.toString
        val verdict = ChannelVerdict.ofQueue(role, aspect.valueOf(TRANSPORT),
            aspect.valueOf(SCHEME), target !== null)

        switch (verdict.outcome) {
            case NOT_APPLICABLE: return
            case UNDECIDED:
                result.undecided.add(
                    '''«service.name» uses «queue»: «verdict.reason»''')
            case PROTECTED:
                result.secured.add(
                    '''«service.name» -> «target» («channel»): «verdict.reason»''')
            // A queue carries no client-authentication fact, so ofQueue never
            // returns this. The arm exists so that adding the fact later is a
            // change to the rule and not a silent fall-through here.
            case PROTECTED_NOT_MUTUAL:
                result.notMutual.add(
                    '''«service.name» -> «target» («channel»): «verdict.reason»''')
            case SMELL: {
                val cause = RootCause.ofQueue(aspect.valueOf(BROKER), aspect.valueOf(SCHEME))
                val finding = newFinding(service.name, target, channel)
                finding.reason = verdict.reason
                finding.rootCauseId = cause.id
                finding.rootCauseLabel = cause.label
                finding.evidence.add(aspect.written)
                result.add(finding)
            }
        }
    }

    /**
     * Judge an endpoint a service answers on, from what it binds it with.
     *
     * The peer is not required to be a reconstructed microservice. A gRPC
     * endpoint is served to whatever addresses it, and the smell holds "even if
     * within the same network", so a plaintext listener is a finding and the
     * reason says that no caller of it was identified. Where the model does
     * carry a caller, [[judgeCall]] judges that call as well: the two read
     * different facts, and a disagreement between them is information.
     */
    private def void judgeListener(ServiceNode service, AspectReference aspect,
        DetectionResult result) {
        val address = '''«aspect.valueOf(HOST) ?: "?"»:«aspect.valueOf(PORT) ?: "?"»'''
        val channel = '''gRPC endpoint on «address»'''.toString
        val verdict = ChannelVerdict.ofListener(aspect.valueOf(TRANSPORT_SECURITY),
            aspect.valueOf(CLIENT_AUTH))

        switch (verdict.outcome) {
            case NOT_APPLICABLE: return
            case UNDECIDED:
                result.undecided.add('''«service.name» serves a «channel»: «verdict.reason»''')
            case PROTECTED:
                result.secured.add('''«service.name» («channel»): «verdict.reason»''')
            case PROTECTED_NOT_MUTUAL:
                result.notMutual.add('''«service.name» («channel»): «verdict.reason»''')
            case SMELL: {
                // The connectors of this service are what has to change, which
                // is the cause a plaintext call to it has as well: one patch
                // serves both, and the key says so.
                val cause = RootCause.ofCall(service.name)
                val finding = newFinding(UNIDENTIFIED_PEER, service.name, channel)
                finding.reason =
                    '''«verdict.reason», and no reconstructed microservice calls it'''
                finding.rootCauseId = cause.id
                finding.rootCauseLabel = cause.label
                finding.evidence.add(aspect.written)
                result.add(finding)
            }
        }
    }

    /**
     * Judge the leg between a service and its message broker.
     *
     * Not the channel [[judgeChannel]] judges. That one is the interaction
     * between two microservices through a queue, judged once, at the producer's
     * end. This is the connection one service holds to the broker, and a broker
     * offers one connector per transport: Lakeside Mutual's producers reach it
     * over TCP and its Node consumer over STOMP, so protecting the one leaves
     * the other open and the queue readable there.
     *
     * Hence the cause is keyed by the scheme, as a MessageChannel's is. The two
     * legs are two patches.
     */
    private def void judgeBrokerConnection(ServiceNode service, AspectReference aspect,
        DetectionResult result) {
        val broker = aspect.valueOf(BROKER)
        val scheme = aspect.valueOf(SCHEME)
        val channel = '''queue «aspect.valueOf(QUEUE) ?: "a queue"» over «scheme ?: "?"»'''.toString
        val peer = '''the «broker ?: "message"» broker'''.toString
        val verdict = ChannelVerdict.ofBrokerConnection(
            aspect.valueOf(TRANSPORT_SECURITY), scheme)

        switch (verdict.outcome) {
            case NOT_APPLICABLE: return
            case UNDECIDED:
                result.undecided.add('''«service.name» uses «channel»: «verdict.reason»''')
            case PROTECTED:
                result.secured.add('''«service.name» -> «peer» («channel»): «verdict.reason»''')
            case PROTECTED_NOT_MUTUAL:
                result.notMutual.add('''«service.name» -> «peer» («channel»): «verdict.reason»''')
            case SMELL: {
                val cause = RootCause.ofQueue(broker, scheme)
                val finding = newFinding(service.name, peer, channel)
                finding.reason = verdict.reason
                finding.rootCauseId = cause.id
                finding.rootCauseLabel = cause.label
                finding.evidence.add(aspect.written)
                result.add(finding)
            }
        }
    }

    /**
     * Whether the callee answers on a connector that accepts plaintext.
     *
     * ``null`` where the model says nothing about the callee's connectors,
     * which is not the same as "it does not".
     */
    private def Boolean calleeAcceptsPlaintext(ServiceNode callee) {
        if (callee === null) {
            return null
        }
        val endpoints = callee.aspects.filter[name == SERVER_ENDPOINT].toList
        if (endpoints.empty) {
            return null
        }
        return endpoints.exists[
            "false" == (valueOf(TLS_ENABLED) ?: "false").toLowerCase
        ]
    }

    /**
     * What the callee demands of a client, across its connectors.
     *
     * The weakest value wins, as the least protected connector does: a callee
     * that requires a certificate on one connector and not on another is
     * reachable without one. ``null`` where nothing is known, which is not the
     * same as requiring nothing.
     *
     * Whether that makes a channel mutual is [[ChannelVerdict]]'s to decide,
     * not this detector's - this reads the fact and hands it over, exactly as
     * the editor's validator does.
     */
    private def String calleeClientAuth(ServiceNode callee) {
        if (callee === null) {
            return null
        }
        val values = callee.aspects.filter[name == SERVER_ENDPOINT]
            .map[valueOf(CLIENT_AUTH)].toList
        if (values.empty || values.exists[it === null]) {
            return null
        }
        if (values.forall[CLIENT_AUTH_REQUIRED.equalsIgnoreCase(it)]) {
            return CLIENT_AUTH_REQUIRED
        }
        return values.findFirst[!CLIENT_AUTH_REQUIRED.equalsIgnoreCase(it)]
    }

    private def Finding newFinding(String caller, String callee, String channel) {
        val finding = new Finding(SMELL, REFERENCE, caller, callee)
        finding.channel = channel
        finding.refactoring = REFACTORING
        return finding
    }

    /**
     * Which connector of a service accepts plaintext, for a report.
     */
    static def String plaintextConnectorsOf(ServiceNode service) {
        return service.aspects
            .filter[name == SERVER_ENDPOINT]
            .filter["false" == (valueOf(TLS_ENABLED) ?: "false").toLowerCase]
            .map['''«valueOf(CONNECTOR)»:«valueOf(PORT)»''']
            .join(", ")
    }
}
