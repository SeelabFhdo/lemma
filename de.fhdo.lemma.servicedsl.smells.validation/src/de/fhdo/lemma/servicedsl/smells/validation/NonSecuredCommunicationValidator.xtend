package de.fhdo.lemma.servicedsl.smells.validation

import de.fhdo.lemma.service.ImportedServiceAspect
import de.fhdo.lemma.service.Microservice
import de.fhdo.lemma.service.ServicePackage
import java.util.Map
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

/**
 * Warns in the model editor where a microservice interacts with another over an
 * unprotected channel.
 *
 * The editor's half of the detection; the command line's half is
 * ``de.fhdo.lemma.servicedsl.smells``. Both decide with [[ChannelVerdict]], so
 * the two agree by construction rather than by review.
 *
 * ## Why this reads the model directly
 *
 * Inside a running Xtext a cross-reference resolves, which it does not outside
 * one. So this validator follows ``required microservices`` to the callee
 * itself and reads its ``ServerEndpoint`` aspects, where the command line has
 * to match the target by name against what the models wrote. The editor
 * therefore judges with better information, not merely sooner.
 *
 * ## Why a warning on the microservice
 *
 * The smell is a property of a channel between two microservices declared in
 * two files, so there is no single line that is wrong. The warning goes on the
 * microservice that needs the other, which is where a reader can act on it, and
 * it names the channel and the refactoring.
 *
 * It is a warning rather than an error because the model is not wrong: the
 * architecture has a risk. Ponce et al. do not rank their smells, so the
 * severity is a presentation choice and not a finding.
 *
 * Composed into the Service DSL's validator, which is the one line this needs
 * of that bundle. This bundle requires only the metamodels, so nothing cycles.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class NonSecuredCommunicationValidator extends AbstractDeclarativeValidator {
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
    static val CLIENT_AUTH = "clientAuth"
    static val TRANSPORT_SECURITY = "transportSecurity"
    static val PORT = "port"

    /**
     * The issue code a quickfix binds to.
     *
     * The first issue code in this repository: every other validator here
     * raises uncoded messages, which no ``@Fix`` can attach to. Qualified with
     * the bundle so it cannot collide with a code added elsewhere later.
     */
    public static val NON_SECURED_COMMUNICATION =
        "de.fhdo.lemma.servicedsl.smells.validation.nonSecuredCommunication"

    /**
     * Issue data, in this order, so a quickfix can act without re-parsing the
     * aspect: what kind of channel it is, the root cause's key, and the
     * cause's label.
     */
    public static val DATA_CHANNEL_KIND = 0
    public static val DATA_ROOT_CAUSE_ID = 1
    public static val DATA_ROOT_CAUSE_LABEL = 2

    public static val KIND_CALL = "call"
    public static val KIND_QUEUE = "queue"
    public static val KIND_LISTENER = "listener"
    public static val KIND_BROKER = "broker"

    /**
     * A composed validator registers no EPackage of its own: the validator it
     * is composed into has done that.
     */
    override register(EValidatorRegistrar registrar) {
        // Deliberately empty, as Xtext requires of a composed validator.
    }

    /**
     * Warn for every unprotected channel this microservice is the near end of.
     */
    @Check
    def void checkNonSecuredCommunication(Microservice microservice) {
        for (aspect : microservice.aspects) {
            switch (aspect.aspectName) {
                case SERVICE_CALL: microservice.checkCall(aspect)
                case MESSAGE_CHANNEL: microservice.checkQueue(aspect)
                case GRPC_SERVER: microservice.checkListener(aspect)
                case MESSAGE_QUEUE: microservice.checkBrokerConnection(aspect)
                default: {}
            }
        }
    }

    private def void checkCall(Microservice microservice, ImportedServiceAspect aspect) {
        val values = aspect.valuesOf
        val target = values.get(TARGET)
        val verdict = ChannelVerdict.ofCall(values.get(SCHEME), values.get(TARGET_KIND),
            microservice.calleeAcceptsPlaintext(target), microservice.calleeClientAuth(target))

        if (verdict.smell) {
            aspect.warn(verdict, '''the call to «target ?: "another service"»''',
                KIND_CALL, RootCause.ofCall(target))
        }
    }

    private def void checkQueue(Microservice microservice, ImportedServiceAspect aspect) {
        val values = aspect.valuesOf
        val queue = values.get(QUEUE)
        val verdict = ChannelVerdict.ofQueue(values.get(ROLE), values.get(TRANSPORT),
            values.get(SCHEME), values.get(TARGET) !== null)

        if (verdict.smell) {
            aspect.warn(verdict,
                '''the queue «queue ?: "it produces to"» shared with «values.get(TARGET)»''',
                KIND_QUEUE, RootCause.ofQueue(values.get(BROKER), values.get(SCHEME)))
        }
    }

    /**
     * Warn for a gRPC endpoint this service binds without protecting it.
     *
     * Judged from this service alone, because the peer that calls the endpoint
     * need not be a microservice the models know - and a plaintext listener is
     * reachable in plaintext by whatever is on the network with it.
     */
    private def void checkListener(Microservice microservice, ImportedServiceAspect aspect) {
        val values = aspect.valuesOf
        val verdict = ChannelVerdict.ofListener(values.get(TRANSPORT_SECURITY),
            values.get(CLIENT_AUTH))

        if (verdict.smell) {
            aspect.warn(verdict,
                '''the gRPC endpoint on «values.get(PORT) ?: "the configured port"»''',
                KIND_LISTENER, RootCause.ofCall(microservice.simpleName))
        }
    }

    /**
     * Warn for a plaintext leg between this service and its broker.
     *
     * Not the channel [[checkQueue]] warns about. That one is the interaction
     * between two microservices through a queue; this is the connection this
     * service holds to the broker, over one of the broker's connectors - and
     * protecting another connector of the same broker does nothing for this
     * one.
     */
    private def void checkBrokerConnection(Microservice microservice,
        ImportedServiceAspect aspect) {
        val values = aspect.valuesOf
        val verdict = ChannelVerdict.ofBrokerConnection(values.get(TRANSPORT_SECURITY),
            values.get(SCHEME))

        if (verdict.smell) {
            aspect.warn(verdict,
                '''the «values.get(BROKER) ?: "message"» broker it reaches for «values.get(QUEUE) ?: "a queue"»''',
                KIND_BROKER, RootCause.ofQueue(values.get(BROKER), values.get(SCHEME)))
        }
    }

    /**
     * Whether the callee answers on a connector that accepts plaintext.
     *
     * Found by following ``required microservices`` to the microservice itself,
     * which resolves here. ``null`` where this model does not require the
     * target, or where the target declares no connector - neither of which
     * means it refuses plaintext.
     */
    private def Boolean calleeAcceptsPlaintext(Microservice microservice, String target) {
        val callee = microservice.calleeOf(target)
        if (callee === null) {
            return null
        }

        val connectors = callee.connectorsOf
        if (connectors.empty) {
            return null
        }
        return connectors.exists["false" == (valuesOf.get(TLS_ENABLED) ?: "false").toLowerCase]
    }

    /**
     * What the callee demands of a client, across its connectors.
     *
     * The weakest value wins, for the same reason the least protected
     * connector does: a callee that requires a certificate on one connector and
     * not on another is reachable without one. ``null`` where the callee or its
     * connectors cannot be found, which is not the same as requiring nothing.
     */
    private def String calleeClientAuth(Microservice microservice, String target) {
        val callee = microservice.calleeOf(target)
        if (callee === null) {
            return null
        }
        val values = callee.connectorsOf.map[valuesOf.get(CLIENT_AUTH)].toList
        if (values.empty) {
            return null
        }
        if (values.exists[it === null]) {
            // A connector that says nothing demands nothing.
            return null
        }
        if (values.forall["need".equalsIgnoreCase(it)]) {
            return "need"
        }
        return values.findFirst[!"need".equalsIgnoreCase(it)]
    }

    /**
     * The microservice a ``required microservices`` entry names.
     *
     * Resolves here, inside Eclipse; the command line reads the same link from
     * a parse tree instead.
     */
    /**
     * The service's own name without its qualifying parts.
     *
     * A cause's id has to read the same here and on the command line, and the
     * graph the command line builds carries the simple name - so a cause keyed
     * on a qualified one would split one cause into two depending on which of
     * the two tools found it.
     */
    private def String simpleName(Microservice microservice) {
        val name = microservice.name
        if (name === null) {
            return null
        }
        return name.substring(name.lastIndexOf(".") + 1)
    }

    private def Microservice calleeOf(Microservice microservice, String target) {
        if (target === null) {
            return null
        }
        return microservice.requiredMicroservices
            .map[it.microservice]
            .filterNull
            .findFirst[name !== null && (name == target || name.endsWith("." + target))]
    }

    private def connectorsOf(Microservice callee) {
        return callee.aspects.filter[aspectName == SERVER_ENDPOINT].toList
    }

    /**
     * Report one unprotected channel, on the aspect that states it.
     *
     * On the aspect rather than the microservice's name: a service with five
     * unprotected channels would otherwise show five identical squiggles in one
     * place, and a quickfix invoked there could not tell which channel it was
     * asked about. The aspect line is also where a reader looks to see what the
     * model claims.
     *
     * The code is what a ``@Fix`` binds to; the issue data lets the fix act
     * without parsing the aspect again.
     */
    private def void warn(ImportedServiceAspect aspect, ChannelVerdict verdict, String channel,
        String kind, RootCause cause) {
        warning(
            '''«ChannelVerdict.SMELL» («ChannelVerdict.REFERENCE»): «channel» is not secured - «
                verdict.reason». Suggested refactoring: «ChannelVerdict.REFACTORING» - «
                cause.label» need it.''',
            aspect,
            ServicePackage.Literals.IMPORTED_SERVICE_ASPECT__IMPORTED_ASPECT,
            NON_SECURED_COMMUNICATION,
            kind, cause.id, cause.label
        )
    }

    private def String aspectName(ImportedServiceAspect aspect) {
        return AspectValues.nameOf(aspect)
    }

    private def Map<String, String> valuesOf(ImportedServiceAspect aspect) {
        return AspectValues.of(aspect)
    }

}
