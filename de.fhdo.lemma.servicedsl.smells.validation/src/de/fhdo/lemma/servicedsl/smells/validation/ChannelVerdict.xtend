package de.fhdo.lemma.servicedsl.smells.validation

import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Whether one channel between two microservices is protected.
 *
 * The decision of **Non-Secured Service-to-Service Communications**, §3.7 of
 *
 *     Ponce, Soldani, Astudillo, Brogi: Smells and refactorings for
 *     microservices security. JSS 192 (2022) 111393.
 *
 * Plain values in, a verdict out: no model, no EMF, no Xtext. That is what lets
 * the editor's validator and the command line share one rule rather than agree
 * by accident - the validator reads resolved cross-references inside Eclipse,
 * the command line reads a graph built from parse trees, and both arrive here
 * with the same facts.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ChannelVerdict {
    public static val SMELL = "Non-Secured Service-to-Service Communications"
    public static val REFERENCE = "Ponce et al. (2022) §3.7"

    /**
     * What the paper suggests. Mutual rather than plain TLS, because it also
     * authenticates the peers - which is what additionally mitigates
     * §3.8 Unauthenticated traffic.
     */
    public static val REFACTORING = "Use Mutual TLS"

    static val KIND_SERVICE = "SERVICE"
    static val ROLE_PRODUCER = "producer"
    static val PLAINTEXT = "plaintext"
    static val UNRESOLVED = "unresolved"
    static val HTTPS = "https"

    /**
     * The value of ``clientAuth`` that means mutual.
     *
     * Spring offers ``none``, ``want`` and ``need``. Only ``need`` is mutual:
     * ``want`` asks for a certificate and then serves the request without one,
     * so it authenticates nobody. An absent value is ``none`` by Spring's own
     * default, and the reconstruction records the value as absent rather than
     * defaulting it, so absent is treated as not mutual.
     */
    static val CLIENT_AUTH_NEED = "need"
    static val CLIENT_AUTH_WANT = "want"

    @Accessors
    val Outcome outcome

    @Accessors
    val String reason

    private new(Outcome outcome, String reason) {
        this.outcome = outcome
        this.reason = reason
    }

    def boolean isSmell() {
        return outcome === Outcome.SMELL
    }

    /**
     * Whether the channel is encrypted but the peers are not mutually
     * authenticated.
     *
     * Not a §3.7 finding: plain TLS does secure the channel, which is what
     * §3.7 is about. It is reported separately because the refactoring the
     * paper prescribes for §3.7 is *mutual* TLS, so a channel in this state has
     * had the smell resolved by a weaker means than the one cited - and it is
     * where §3.8 Unauthenticated traffic would begin.
     */
    def boolean isProtectedButNotMutual() {
        return outcome === Outcome.PROTECTED_NOT_MUTUAL
    }

    /**
     * Whether the channel protects the data, mutually authenticated or not.
     */
    def boolean isProtected() {
        return outcome === Outcome.PROTECTED || outcome === Outcome.PROTECTED_NOT_MUTUAL
    }

    /**
     * Judge a synchronous call.
     *
     * Both halves decide it: the scheme the caller uses, and whether the callee
     * accepts plaintext. A TLS call to a callee that also answers on a
     * plaintext connector is still the smell, because the smell is about the
     * channel and that callee can be reached over plaintext however this caller
     * calls it.
     *
     * @param scheme scheme the caller uses, or null when the model does not say
     * @param targetKind whether the target is a service of this application
     * @param calleeAcceptsPlaintext true, false, or null where the model says
     *     nothing about the callee's connectors - which is not the same as "it
     *     does not"
     * @param calleeClientAuth what the callee's connectors demand of a client -
     *     ``need``, ``want``, ``none``, or null where the model does not say.
     *     Decides whether a TLS channel is mutual.
     * @return the verdict
     */
    static def ChannelVerdict ofCall(String scheme, String targetKind,
        Boolean calleeAcceptsPlaintext, String calleeClientAuth) {
        if (targetKind !== null && KIND_SERVICE != targetKind) {
            // A third party. The paper's smell is about two microservices of
            // the application, so this rule has nothing to say about it.
            return new ChannelVerdict(Outcome.NOT_APPLICABLE, null)
        }
        if (scheme.nullOrEmpty || UNRESOLVED.equalsIgnoreCase(scheme)) {
            return new ChannelVerdict(Outcome.UNDECIDED,
                "the model does not say which scheme the call uses")
        }

        if (HTTPS.equalsIgnoreCase(scheme)) {
            if (calleeAcceptsPlaintext === Boolean.TRUE) {
                return new ChannelVerdict(Outcome.SMELL,
                    "the caller uses TLS, but the callee also answers on a plaintext connector")
            }
            val onlyTls = calleeAcceptsPlaintext === Boolean.FALSE
            if (CLIENT_AUTH_NEED.equalsIgnoreCase(calleeClientAuth)) {
                return new ChannelVerdict(Outcome.PROTECTED,
                    if (onlyTls)
                        "the call uses mutual TLS and the callee accepts only TLS"
                    else
                        "the call uses mutual TLS")
            }
            // Encrypted, but nobody is authenticated. Not a §3.7 finding, and
            // not the refactoring §3.7 prescribes either.
            return new ChannelVerdict(Outcome.PROTECTED_NOT_MUTUAL,
                if (CLIENT_AUTH_WANT.equalsIgnoreCase(calleeClientAuth))
                    "the call uses TLS, but the callee only requests a client certificate "
                        + "and serves the request without one"
                else
                    "the call uses TLS, but the callee does not require a client certificate")
        }
        return new ChannelVerdict(Outcome.SMELL,
            '''the call uses «scheme», which does not protect the channel'''.toString)
    }

    /**
     * Judge a channel through a queue.
     *
     * Only the producer's end is judged, although both ends carry the fact: the
     * channel is one interaction, and judging it twice would report the same
     * finding from each side.
     *
     * @param role which end this service is
     * @param transport whether the broker's channel is protected
     * @param scheme scheme of the broker's address, for the reason
     * @param paired whether a service of this application is at the other end
     * @return the verdict
     */
    static def ChannelVerdict ofQueue(String role, String transport, String scheme,
        boolean paired) {
        if (!paired) {
            return new ChannelVerdict(Outcome.UNDECIDED,
                "nothing of this system is at the other end of the queue")
        }
        if (ROLE_PRODUCER != role) {
            // The producer's end carries the same channel.
            return new ChannelVerdict(Outcome.NOT_APPLICABLE, null)
        }
        if (transport.nullOrEmpty || UNRESOLVED.equalsIgnoreCase(transport)) {
            return new ChannelVerdict(Outcome.UNDECIDED,
                "the model does not say how the broker is reached")
        }
        if (!PLAINTEXT.equalsIgnoreCase(transport)) {
            // PROTECTED rather than split in two as a call is: a MessageChannel
            // carries no client-authentication fact, so whether the broker
            // demands a client certificate is not reconstructed and must not be
            // guessed at in either direction.
            return new ChannelVerdict(Outcome.PROTECTED,
                '''the broker is reached over «transport»'''.toString)
        }
        return new ChannelVerdict(Outcome.SMELL,
            '''the broker is reached over «scheme ?: transport», which does not protect the channel'''
                .toString)
    }

    /**
     * Judge an endpoint a service answers on.
     *
     * The caller-side counterpart of [[ofCall]] is missing here on purpose: a
     * gRPC endpoint is judged from what the server binds, because the peer that
     * calls it need not be a service the reconstruction knows. A command line
     * tool is such a peer in Lakeside Mutual, and it is deployed by nobody.
     *
     * That the peer is unknown does not make the endpoint protected. A
     * plaintext listener is reachable in plaintext by whatever is on the
     * network with it, which is what §3.7 is about - the smell holds "even if
     * within the same network". The detector says in the finding that no
     * reconstructed microservice was identified as the caller, so nothing is
     * claimed that was not read.
     *
     * @param transport whether the endpoint is bound with TLS - plaintext, tls,
     *     or unresolved where the sources do not say
     * @param clientAuth what the endpoint demands of a client certificate, or
     *     null where it demands nothing. Decides whether TLS is mutual.
     * @return the verdict
     */
    static def ChannelVerdict ofListener(String transport, String clientAuth) {
        if (transport.nullOrEmpty || UNRESOLVED.equalsIgnoreCase(transport)) {
            return new ChannelVerdict(Outcome.UNDECIDED,
                "the model does not say whether the endpoint is bound with TLS")
        }
        if (PLAINTEXT.equalsIgnoreCase(transport)) {
            return new ChannelVerdict(Outcome.SMELL,
                "the endpoint is bound without TLS, so it is reached over plaintext "
                    + "by whatever is on the network with it")
        }
        if (CLIENT_AUTH_NEED.equalsIgnoreCase(clientAuth)) {
            return new ChannelVerdict(Outcome.PROTECTED,
                "the endpoint uses TLS and requires a client certificate")
        }
        return new ChannelVerdict(Outcome.PROTECTED_NOT_MUTUAL,
            if (CLIENT_AUTH_WANT.equalsIgnoreCase(clientAuth))
                "the endpoint uses TLS, but only requests a client certificate and "
                    + "serves the request without one"
            else
                "the endpoint uses TLS, but does not require a client certificate")
    }

    /**
     * Judge the leg between a service and its message broker.
     *
     * [[ofQueue]] judges a channel between two microservices that passes
     * through a queue, and judges it once, at the producer's end. This judges
     * something else: the connection one service holds to the broker. A broker
     * offers a connector per transport, and the two ends of one queue may use
     * different ones - Lakeside Mutual's producers reach it over TCP and its
     * Node consumer over STOMP - so protecting the producer's connector leaves
     * the consumer's unprotected and the queue readable there.
     *
     * Which is why this is not the same finding seen from the other side, and
     * why its cause is keyed by the scheme: the two legs want two patches.
     *
     * @param transport whether the leg is protected - plaintext, tls, or
     *     unresolved where the sources do not say
     * @param scheme scheme the broker is addressed over, for the reason
     * @return the verdict
     */
    static def ChannelVerdict ofBrokerConnection(String transport, String scheme) {
        if (transport.nullOrEmpty || UNRESOLVED.equalsIgnoreCase(transport)) {
            return new ChannelVerdict(Outcome.UNDECIDED,
                "the model does not say how the service reaches the broker")
        }
        if (!PLAINTEXT.equalsIgnoreCase(transport)) {
            // PROTECTED rather than split in two, as in ofQueue: what a broker
            // demands of a client certificate is the broker's configuration,
            // and the broker is no service of the model.
            return new ChannelVerdict(Outcome.PROTECTED,
                '''the broker is reached over «transport»'''.toString)
        }
        return new ChannelVerdict(Outcome.SMELL,
            '''the service reaches the broker over «scheme ?: transport», which does not protect the channel'''
                .toString)
    }
}

/**
 * What judging a channel can come to.
 *
 * ``UNDECIDED`` is deliberately not ``PROTECTED``: a system that does not smell
 * and a system whose facts were never reconstructed must not look alike.
 */
enum Outcome {
    SMELL,
    PROTECTED,
    PROTECTED_NOT_MUTUAL,
    UNDECIDED,
    NOT_APPLICABLE
}
