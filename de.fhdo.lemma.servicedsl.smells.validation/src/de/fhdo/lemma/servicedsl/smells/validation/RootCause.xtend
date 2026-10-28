package de.fhdo.lemma.servicedsl.smells.validation

import org.eclipse.xtend.lib.annotations.Accessors

/**
 * What one finding is actually caused by.
 *
 * A finding names a channel, but a channel is rarely the thing to fix. On
 * Lakeside Mutual nine findings reduce to two causes: one microservice answers
 * on a single plaintext connector, which explains all three synchronous
 * findings, and one broker is reached over a plaintext transport, which
 * explains all six asynchronous ones. Grouping by cause is therefore what turns
 * a list of symptoms into a list of repairs - and it is also the right unit for
 * a refactoring, because mutual TLS has to be applied to both ends of every
 * channel a cause covers at once.
 *
 * Here beside [[ChannelVerdict]] rather than in either consumer, so that the
 * editor and the command line group a system identically. Plain values in, a
 * key out: no model, no EMF, no Xtext.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class RootCause {
    public static val KIND_ENDPOINT = "endpoint"
    public static val KIND_BROKER = "broker"

    static val UNKNOWN = "<unknown>"

    /**
     * ``endpoint`` or ``broker``: what has to change.
     */
    @Accessors
    val String kind

    /**
     * What groups findings together. Two findings with one id have one cause
     * and want one patch.
     */
    @Accessors
    val String id

    /**
     * How the cause reads in a report or a quickfix label.
     */
    @Accessors
    val String label

    private new(String kind, String id, String label) {
        this.kind = kind
        this.id = id
        this.label = label
    }

    /**
     * The cause behind an unprotected call: the callee's connectors.
     *
     * The callee rather than the caller, because that is where the change
     * belongs. Three services calling one plaintext connector is one cause, and
     * enabling TLS on that connector without touching its callers would break
     * all three - so the callers come along with it.
     *
     * @param target name of the callee, or null where the model does not say
     * @return the cause
     */
    static def RootCause ofCall(String target) {
        val name = if (target.nullOrEmpty) UNKNOWN else target
        return new RootCause(KIND_ENDPOINT, '''«KIND_ENDPOINT»:«name»'''.toString,
            '''the connectors of «name»'''.toString)
    }

    /**
     * The cause behind an unprotected queue: the broker.
     *
     * Keyed by the broker and the scheme it is reached over, which is all a
     * ``MessageChannel`` carries. **A model names the broker's technology, not
     * the instance**, so two distinct brokers of the same technology reached
     * over the same scheme group as one cause. Lakeside Mutual has a single
     * broker, so the limit does not bite there; a system with two would need
     * the broker's address reconstructed into the model to tell them apart.
     *
     * @param broker the broker technology, or null where the model does not say
     * @param scheme the scheme its address uses, or null
     * @return the cause
     */
    static def RootCause ofQueue(String broker, String scheme) {
        val name = if (broker.nullOrEmpty) UNKNOWN else broker
        val over = if (scheme.nullOrEmpty) UNKNOWN else scheme
        return new RootCause(KIND_BROKER, '''«KIND_BROKER»:«name»:«over»'''.toString,
            '''the «name» broker, reached over «over»'''.toString)
    }

    override equals(Object other) {
        if (other instanceof RootCause) {
            return id == other.id
        }
        return false
    }

    override hashCode() {
        return id.hashCode
    }

    override toString() {
        return id
    }
}
