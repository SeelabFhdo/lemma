package de.fhdo.lemma.servicedsl.smells.test

import de.fhdo.lemma.operationdsl.diagram.ArtifactInfo
import de.fhdo.lemma.operationdsl.diagram.NodeInfo
import de.fhdo.lemma.operationdsl.diagram.NodeKind
import de.fhdo.lemma.operationdsl.diagram.OperationGraph
import de.fhdo.lemma.servicedsl.diagram.AspectReference
import de.fhdo.lemma.servicedsl.diagram.ServiceModelReader
import de.fhdo.lemma.servicedsl.smells.DeploymentCoverage
import de.fhdo.lemma.servicedsl.smells.DetectionResult
import de.fhdo.lemma.servicedsl.smells.Finding
import de.fhdo.lemma.servicedsl.smells.NonSecuredCommunicationDetector
import de.fhdo.lemma.servicedsl.smells.SmellReport
import de.fhdo.lemma.servicedsl.smells.validation.ChannelVerdict
import de.fhdo.lemma.servicedsl.smells.validation.Outcome
import de.fhdo.lemma.servicedsl.smells.validation.RootCause
import de.fhdo.lemma.servicedsl.smells.refactoring.PatchGuard
import de.fhdo.lemma.servicedsl.smells.refactoring.ProposalApplication
import de.fhdo.lemma.servicedsl.smells.refactoring.RecordedProposal
import de.fhdo.lemma.servicedsl.smells.refactoring.PromptBuilder
import de.fhdo.lemma.servicedsl.smells.refactoring.ProposalRecord
import de.fhdo.lemma.servicedsl.smells.refactoring.RecordedProposer
import de.fhdo.lemma.servicedsl.smells.refactoring.RefactoringRequest
import de.fhdo.lemma.servicedsl.smells.refactoring.RefactoringRequests
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

/**
 * Checks the detection of Non-Secured Service-to-Service Communications.
 *
 * Run it from the IDE with "Run As -> Java Application", with this bundle as
 * the working directory. No database and no running Eclipse are needed.
 *
 * Each check states what it would catch. The fixtures carry the cases no
 * sample system has: TLS anywhere, a TLS broker, a mixed callee.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class SmellDetectionTest {
    static val FIXTURES = "test/fixtures"

    static var failures = 0
    static var checks = 0

    def static void main(String[] args) {
        aPlaintextCallIsTheSmell
        tlsOnBothEndsIsNotTheSmell
        aCalleeWithAPlaintextConnectorIsStillTheSmell
        aThirdPartyIsNotThisSmell
        whatCannotBeDecidedIsNotCalledSecure
        aPlaintextQueueIsTheSmell
        aChannelIsJudgedOnceNotTwice
        aPlaintextListenerIsTheSmell
        aListenerIsMutualOnlyWithAClientCertificate
        aPlaintextLegToTheBrokerIsItsOwnFinding
        aServiceWithNoFactIsReportedAsNotJudged
        aDeploymentNodeWithNoModelledServiceIsReported
        theNodeChannelsBecomeRequests
        aFindingCarriesItsEvidenceAndRefactoring
        anAspectsValuesAreRead
        tlsIsNotTheSameAsMutualTls
        findingsGroupByTheirCause
        findingsBecomeOneRequestPerCause
        thePromptSaysWhatWasLearned
        aPatchIsCheckedNotTrusted
        aProposalIsRecorded
        aSecuredSystemYieldsNothingToResolve
        aProposalBelongsToOneCommit
        aDeclaredLossIsAPartialRepair
        applyingRefusesRatherThanGuesses
        anApplyIsPlannedBeforeItRuns
        applyingStagesOnlyThePatchsFiles

        println('''
        ---
        «checks» check(s), «failures» failed''')
        if (failures > 0) {
            System.exit(1)
        }
    }

    /**
     * A gRPC endpoint bound without TLS.
     *
     * Catches a detector that judges only what a caller states. This endpoint
     * has no reconstructed caller at all - Lakeside Mutual's is addressed by a
     * command line tool that nothing deploys - and the smell holds "even if
     * within the same network", so a plaintext listener is a finding. Until
     * this case existed, the one in Lakeside Mutual was invisible, and the
     * proposal that secured it and the one that did not looked alike.
     */
    private def static void aPlaintextListenerIsTheSmell() {
        val result = judge("/node-channels.services")
        val finding = result.findings.findFirst[callee == "PlaintextListener"]

        check("a gRPC endpoint bound without TLS is a finding", finding !== null, true)
        check("the channel names the address", finding?.channel?.contains("0.0.0.0:50051"),
            true)
        check("and the reason says no caller of it was identified",
            finding?.reason?.contains("no reconstructed microservice calls it"), true)
        check("its cause is the connectors of the service that serves it",
            finding?.rootCauseId, "endpoint:PlaintextListener")
    }

    /**
     * The same endpoint with TLS, with and without a client certificate.
     *
     * Catches a listener rule that stops at encryption. §3.7 is resolved by
     * TLS, so the encrypted endpoint is no finding - and the refactoring the
     * paper prescribes is *mutual* TLS, so it is not secured either.
     */
    private def static void aListenerIsMutualOnlyWithAClientCertificate() {
        val result = judge("/node-channels.services")

        check("a TLS endpoint that requires a client certificate is secured",
            result.secured.exists[contains("MutualListener")], true)
        check("a TLS endpoint without one is not a finding",
            result.findings.exists[callee == "EncryptedListener"], false)
        check("it is reported as encrypted but not mutually authenticated",
            result.notMutual.exists[contains("EncryptedListener")], true)
        check("an endpoint whose binding the sources do not state is undecided",
            result.undecided.exists[contains("UnknownListener")], true)
        check("and it is not called secure",
            result.secured.exists[contains("UnknownListener")], false)
    }

    /**
     * The leg between a service and its broker, over a scheme of its own.
     *
     * Catches a rule that treats the consumer's leg as the producer's channel
     * seen twice. A broker offers one connector per transport: Lakeside
     * Mutual's producers reach it over TCP and its Node consumer over STOMP, so
     * securing the producers leaves this leg plaintext and the queue readable
     * there. Two legs, two causes, two patches.
     */
    private def static void aPlaintextLegToTheBrokerIsItsOwnFinding() {
        val result = judge("/node-channels.services")
        val finding = result.findings.findFirst[caller == "PlaintextConsumer"]

        check("a plaintext leg to the broker is a finding", finding !== null, true)
        check("the peer is the broker, not the service at the other end",
            finding?.callee, "the activemq broker")
        check("the channel names the queue and the scheme",
            finding?.channel, "queue orders over stomp")
        check("its cause is keyed by the broker and the scheme",
            finding?.rootCauseId, "broker:activemq:stomp")
        check("a protected leg is secured instead",
            result.secured.exists[contains("SecuredConsumer")], true)
    }

    /**
     * A service that carries no fact about any channel of its own.
     *
     * Catches a report that cannot tell "nothing to report" from "nothing was
     * read". This is the state Lakeside Mutual's Risk Management server was in
     * while its two channels went unjudged, and nothing in the report said so.
     */
    private def static void aServiceWithNoFactIsReportedAsNotJudged() {
        val result = judge("/node-channels.services")

        check("a service with no communication fact is named as not judged",
            result.unjudged.contains("Silent"), true)
        check("it is not a finding", result.findings.exists[callee == "Silent"], false)
        check("and not called secure", result.secured.exists[contains("Silent")], false)
        check("a service that does carry one is not named",
            result.unjudged.contains("PlaintextListener"), false)
    }

    /**
     * The case the paper defines, and the one Lakeside Mutual is in.
     *
     * Catches a detector that requires the callee to be unreachable or the
     * network to be public: the smell holds "even if they are within the same
     * network".
     */
    /**
     * A deployment node that deploys nothing the models declare.
     *
     * Catches a coverage report that only counts services with no fact: the two
     * clients Lakeside Mutual's refactoring found in the sources have no service
     * model to miss a fact in - the monitoring server is skipped as
     * infrastructure, the NGINX demonstration is not read at all - so counting
     * facts says nothing about them. Built by hand rather than from an operation
     * model, because the question is what the comparison does with a node, not
     * whether the reader parses one.
     */
    private def static void aDeploymentNodeWithNoModelledServiceIsReported() {
        val services = new ServiceModelReader().read(#[
            Paths.get(FIXTURES + "/node-channels.services") as Path
        ])

        val deployment = new OperationGraph
        val deployed = new NodeInfo("ListenerContainer", NodeKind.CONTAINER)
        deployed.technology = "Docker"
        deployed.artifacts.add(new ArtifactInfo("PlaintextListener",
            "Channels::com.example.PlaintextListener"))
        deployment.add(deployed)

        val monitoring = new NodeInfo("SpringBootAdmin", NodeKind.INFRASTRUCTURE)
        monitoring.technology = "SpringBootAdmin"
        monitoring.operationEnvironment = "eclipse-temurin:21-jre"
        deployment.add(monitoring)

        val proxy = new NodeInfo("Proxy", NodeKind.CONTAINER)
        proxy.technology = "Docker"
        proxy.operationEnvironment = "nginx"
        deployment.add(proxy)

        val unmodelled = DeploymentCoverage.potentialUnmodelledClients(deployment, services)

        check("a node deploying no reconstructed microservice is reported",
            unmodelled.exists[contains("SpringBootAdmin")], true)
        check("so is a container that deploys nothing at all",
            unmodelled.exists[contains("Proxy")], true)
        check("a node deploying a service the models declare is not",
            unmodelled.exists[contains("ListenerContainer")], false)
        check("and that is all of them", unmodelled.size, 2)
        check("the line says what kind of node it is",
            unmodelled.exists[contains("infrastructure node")], true)

        val report = new SmellReport().write(
            new NonSecuredCommunicationDetector().detect(services), services, unmodelled)
        check("the report names them as potential unmodelled clients, not findings",
            report.contains("## Potential unmodelled clients"), true)
        check("and counts them in its table",
            report.contains("| Deployment nodes deploying no reconstructed microservice | 2 |"),
            true)
    }

    private def static void aPlaintextCallIsTheSmell() {
        val result = judge("/judged.services")

        check("a plaintext call to a service of the system is a finding",
            result.findings.exists[caller == "PlaintextCaller" && callee == "Callee"], true)
        check("and the reason names the scheme",
            result.findings.findFirst[caller == "PlaintextCaller"]?.reason?.contains("http"),
            true)
    }

    /**
     * TLS on both ends.
     *
     * Catches a detector that reports every call: a channel the model shows to
     * be protected is not a finding, and a rule that cannot clear anything
     * says nothing.
     */
    private def static void tlsOnBothEndsIsNotTheSmell() {
        val result = judge("/judged.services")

        check("a TLS call to a TLS-only callee is not a finding",
            result.findings.exists[caller == "TlsCaller"], false)
        check("it is reported as secured instead",
            result.secured.exists[contains("TlsCaller")], true)
    }

    /**
     * The callee answers on TLS *and* on a plaintext management connector.
     *
     * Catches judging the caller's scheme alone. The smell is about the
     * channel, and a callee that accepts plaintext can be reached over
     * plaintext however this caller happens to call it.
     */
    private def static void aCalleeWithAPlaintextConnectorIsStillTheSmell() {
        val result = judge("/judged.services")
        val finding = result.findings.findFirst[caller == "TlsCallerToMixed"]

        check("a TLS call to a callee that also accepts plaintext is a finding",
            finding !== null, true)
        check("and the reason says why",
            finding?.reason?.contains("plaintext connector"), true)
    }

    /**
     * A call to something outside the application.
     *
     * Catches reporting a third party: the paper's smell is about two
     * microservices *of the application*, so an external call is neither a
     * finding nor something this rule can clear.
     */
    private def static void aThirdPartyIsNotThisSmell() {
        val result = judge("/judged.services")

        check("an external target is not a finding",
            result.findings.exists[caller == "ExternalCaller"], false)
        check("and not reported as secured either",
            result.secured.exists[contains("ExternalCaller")], false)
        check("nor as undecided",
            result.undecided.exists[contains("ExternalCaller")], false)
    }

    /**
     * Facts that do not settle the question.
     *
     * Catches an unresolved scheme or transport being read as safe. A system
     * that does not smell and a system whose facts were never reconstructed
     * must not look alike - which is the difference between a rule and a
     * guess.
     */
    private def static void whatCannotBeDecidedIsNotCalledSecure() {
        val calls = judge("/judged.services")
        val channels = judge("/channels.services")

        check("an unresolved scheme is undecided",
            calls.undecided.exists[contains("UnknownSchemeCaller")], true)
        check("and not secured", calls.secured.exists[contains("UnknownSchemeCaller")], false)
        check("and not a finding",
            calls.findings.exists[caller == "UnknownSchemeCaller"], false)
        check("an unresolved broker transport is undecided",
            channels.undecided.exists[contains("UnknownProducer")], true)
        check("a consumer with nothing at the other end is undecided",
            channels.undecided.exists[contains("reports")], true)
    }

    /**
     * A queue over a plaintext broker.
     *
     * Catches a detector that judges only synchronous calls, which would miss
     * six of the nine interactions of Lakeside Mutual.
     */
    private def static void aPlaintextQueueIsTheSmell() {
        val result = judge("/channels.services")
        val finding = result.findings.findFirst[caller == "Producer"]

        check("a plaintext queue is a finding", finding !== null, true)
        check("the channel names the queue", finding?.channel?.contains("orders"), true)
        check("a TLS broker is secured instead",
            result.secured.exists[contains("SecureProducer")], true)
    }

    /**
     * Both ends of a queue carry the fact, and it is one interaction.
     *
     * Catches judging the consumer's end as well, which reports the same
     * channel twice - once from each side - and doubles every asynchronous
     * finding.
     */
    private def static void aChannelIsJudgedOnceNotTwice() {
        val result = judge("/channels.services")

        check("the orders queue yields one finding",
            result.findings.filter[channel !== null && channel.contains("orders")].size, 1)
        check("from the producer's end", result.findings.findFirst[
            channel !== null && channel.contains("orders")]?.caller, "Producer")
    }

    /**
     * What a finding has to carry to be worth reading.
     *
     * Catches a finding that states a verdict without the facts behind it, and
     * one that does not say what to do about it.
     */
    private def static void aFindingCarriesItsEvidenceAndRefactoring() {
        val finding = judge("/judged.services").findings.findFirst[caller == "PlaintextCaller"]

        check("it names the smell", finding?.smell,
            NonSecuredCommunicationDetector.SMELL)
        check("and where the smell is defined", finding?.reference,
            NonSecuredCommunicationDetector.REFERENCE)
        check("it suggests the literature's refactoring", finding?.refactoring,
            NonSecuredCommunicationDetector.REFACTORING)
        check("it carries the call it was decided from",
            finding?.evidence?.exists[contains("ServiceCall")], true)
        check("and the callee's connector",
            finding?.evidence?.exists[contains("ServerEndpoint")], true)
    }

    /**
     * An aspect's property values, read from what the model wrote.
     *
     * Catches a parser that splits on every comma: a value may hold one, and
     * splitting inside a quoted value loses the rest of it.
     */
    private def static void anAspectsValuesAreRead() {
        val values = AspectReference.valuesOf(
            '''@t::_aspects.MessageChannel(role = "producer", queue = "a,b", transport = "plaintext")''')

        check("every property is read", values.size, 3)
        check("a value holding a comma survives", values.get("queue"), "a,b")
        check("and the quotes are gone", values.get("role"), "producer")
        check("an aspect with no values yields none",
            AspectReference.valuesOf("@t::_aspects.Autowired").size, 0)
    }

    private def static DetectionResult judge(String fixture) {
        val graph = new ServiceModelReader().read(#[
            Paths.get(FIXTURES + fixture) as Path
        ])
        return new NonSecuredCommunicationDetector().detect(graph)
    }

    private def static void check(String what, Object actual, Object expected) {
        checks++
        if (expected == actual) {
            println('''  ok    «what»''')
        } else {
            failures++
            println('''  FAIL  «what»: expected «expected», got «actual»''')
        }
    }

    /**
     * Mutual TLS is the refactoring §3.7 prescribes, so plain TLS and mutual
     * TLS must not read alike.
     *
     * Catches a rule that treats any TLS as the refactoring applied, which
     * would let the verifier certify something weaker than the paper cites.
     * Tested against the rule directly: plain values in, verdict out, no model
     * needed - which is the property that lets the editor and the command line
     * share it.
     */
    private def static void tlsIsNotTheSameAsMutualTls() {
        val mutual = ChannelVerdict.ofCall("https", "SERVICE", false, "need")
        check("a TLS call to a callee requiring a client certificate is protected",
            mutual.outcome, Outcome.PROTECTED)
        check("and is not a finding", mutual.smell, false)
        check("and the reason says it is mutual",
            mutual.reason.contains("mutual TLS"), true)

        val notMutual = ChannelVerdict.ofCall("https", "SERVICE", false, "none")
        check("a TLS call to a callee requiring nothing is not mutual",
            notMutual.outcome, Outcome.PROTECTED_NOT_MUTUAL)
        check("which is still not a §3.7 finding", notMutual.smell, false)
        check("but is reported as protected", notMutual.protected, true)
        check("and flagged as not mutual", notMutual.protectedButNotMutual, true)

        // "want" asks for a certificate and then serves the request without
        // one, so it authenticates nobody. The trap this exists for.
        val want = ChannelVerdict.ofCall("https", "SERVICE", false, "want")
        check("clientAuth=want is not mutual either",
            want.outcome, Outcome.PROTECTED_NOT_MUTUAL)
        check("and the reason says why",
            want.reason.contains("serves the request without one"), true)

        // Absent is Spring's "none", and the reconstruction records absence
        // rather than defaulting it.
        check("an absent clientAuth is not mutual",
            ChannelVerdict.ofCall("https", "SERVICE", false, null).outcome,
            Outcome.PROTECTED_NOT_MUTUAL)

        // Mutuality must not rescue a callee that also answers on plaintext.
        check("a plaintext connector still wins over clientAuth=need",
            ChannelVerdict.ofCall("https", "SERVICE", true, "need").outcome,
            Outcome.SMELL)

        // A queue carries no client-authentication fact, so it must never be
        // guessed at in either direction.
        check("a TLS queue is protected, not judged on mutuality",
            ChannelVerdict.ofQueue("producer", "tls", "ssl", true).outcome,
            Outcome.PROTECTED)
    }

    /**
     * Findings group by what causes them, because a cause is what gets fixed.
     *
     * Catches a grouping keyed by the caller, which would make three services
     * calling one plaintext connector look like three separate repairs.
     */
    private def static void findingsGroupByTheirCause() {
        val callee = RootCause.ofCall("CustomerCore")
        check("two callers of one callee share a cause",
            RootCause.ofCall("CustomerCore").id, callee.id)
        check("a different callee is a different cause",
            RootCause.ofCall("PolicyManagement").id == callee.id, false)
        check("the cause names what has to change",
            callee.label.contains("connectors of CustomerCore"), true)
        check("and says which kind it is", callee.kind, RootCause.KIND_ENDPOINT)

        val broker = RootCause.ofQueue("activemq", "tcp")
        check("two queues of one broker share a cause",
            RootCause.ofQueue("activemq", "tcp").id, broker.id)
        check("a broker reached over another scheme is another cause",
            RootCause.ofQueue("activemq", "ssl").id == broker.id, false)
        check("a call and a queue never share a cause",
            broker.id == callee.id, false)

        // Equality is by id, so a cause can key a map.
        check("a cause equals another with the same id",
            broker == RootCause.ofQueue("activemq", "tcp"), true)
    }


    /**
     * Nine findings become two requests, each knowing what it must not touch.
     *
     * Catches a machinery that proposes per finding, which would ask for the
     * same repair three times, and one that forgets the other causes, which
     * lets a proposal quietly widen into a second one.
     */
    private def static void findingsBecomeOneRequestPerCause() {
        // Built by hand rather than taken from a fixture: every finding in
        // channels.services shares one cause, so a fixture-based check of what
        // a request knows about the OTHER causes cannot fail. Two causes here,
        // asserted to be two, so the checks below bite.
        val result = new DetectionResult
        result.add(finding("CustomerManagement", "CustomerCore", "call to CustomerCore",
            RootCause.ofCall("CustomerCore")))
        result.add(finding("CustomerSelfService", "CustomerCore", "call to CustomerCore",
            RootCause.ofCall("CustomerCore")))
        result.add(finding("PolicyManagement", "RiskManagement", "queue newpolicies",
            RootCause.ofQueue("activemq", "tcp")))

        check("the fixture for this check really has two causes",
            result.byRootCause.size, 2)

        val requests = RefactoringRequests.of(result, "/tmp/system", "a-skill")
        check("a request per cause, not per finding", requests.size, 2)
        check("every finding lands in a request",
            requests.map[findings.size].reduce[a, b | a + b], 3)
        check("the two callers of one callee share a request",
            requests.findFirst[rootCauseId.contains("CustomerCore")].findings.size, 2)
        check("a request carries its cause's label",
            requests.forall[!rootCauseLabel.nullOrEmpty], true)
        check("and the source root and skill it was built with",
            requests.forall[sourceRoot == "/tmp/system" && skill == "a-skill"], true)
        check("a request names the other cause as out of scope",
            requests.forall[otherCauses.size == 1], true)
        check("and never names its own cause among them",
            requests.forall[!otherCauses.contains(rootCauseLabel)], true)
        check("a request with a finding is valid", requests.forall[valid], true)
        check("one without is not", new RefactoringRequest().valid, false)

        // The fixture still has to group, which is a different claim.
        val fromFixture = RefactoringRequests.of(judge("/channels.services"),
            "/tmp/system", "a-skill")
        check("a fixture whose findings share one cause yields one request",
            fromFixture.size, 1)
        check("with no other cause to avoid", fromFixture.head.otherCauses.empty, true)
    }

    /**
     * The two Node channels reach the request stage, not only the report.
     *
     * A finding nobody can ask for is a finding nobody fixes: the gRPC endpoint
     * of Lakeside Mutual went unresolved through three proposals because it
     * reached no model, hence no cause, hence no request. This check closes
     * that chain for both Node facts - one request per cause, the listener's
     * cause among them, carrying the evidence a proposal has to act on.
     */
    private def static void theNodeChannelsBecomeRequests() {
        val result = judge("/node-channels.services")
        val requests = RefactoringRequests.of(result, "/tmp/system", "a-skill")

        check("every cause of the Node fixture yields a request",
            requests.size, result.byRootCause.size)
        val listener = requests.findFirst[rootCauseId == "endpoint:PlaintextListener"]
        check("the plaintext gRPC endpoint has a request of its own",
            listener !== null, true)
        check("it carries the finding", listener?.findings?.size, 1)
        check("and is valid", listener?.valid, true)

        val leg = requests.findFirst[rootCauseId == "broker:activemq:stomp"]
        check("the plaintext leg to the broker has one too", leg !== null, true)

        val prompt = PromptBuilder.request(listener)
        check("the prompt names the endpoint's address",
            prompt.contains("0.0.0.0:50051"), true)
        check("it carries the aspect as evidence",
            prompt.contains("GrpcServer"), true)
        check("and it states the cause the patch must resolve",
            prompt.contains(listener.rootCauseLabel), true)
    }

    /**
     * A finding as the detector would build it, for a check that needs a shape
     * no fixture provides.
     */
    private def static Finding finding(String caller, String callee, String channel,
        RootCause cause) {
        val finding = new Finding(ChannelVerdict.SMELL, ChannelVerdict.REFERENCE, caller, callee)
        finding.channel = channel
        finding.refactoring = ChannelVerdict.REFACTORING
        finding.reason = "test"
        finding.rootCauseId = cause.id
        finding.rootCauseLabel = cause.label
        return finding
    }

    /**
     * The prompt is deterministic and says the things that must be said.
     *
     * Catches a builder that leaves out the scope fence or the clean-checkout
     * criterion - both of which were learned from a proposal that got them
     * wrong.
     */
    private def static void thePromptSaysWhatWasLearned() {
        val result = judge("/channels.services")
        val request = RefactoringRequests.of(result, "/tmp/system",
            "lemma-smell-refactoring:resolve-non-secured-communication").head

        val prompt = PromptBuilder.request(request)
        check("the prompt is deterministic", prompt, PromptBuilder.request(request))
        check("it names the skill to use",
            prompt.contains("lemma-smell-refactoring:resolve-non-secured-communication"), true)
        check("it names the smell", prompt.contains(ChannelVerdict.SMELL), true)
        check("and cites the paper", prompt.contains(ChannelVerdict.REFERENCE), true)
        check("it carries the cause's label", prompt.contains(request.rootCauseLabel), true)
        check("it says the models carry no paths",
            prompt.contains("no file paths"), true)
        check("it demands the clean-checkout criterion",
            prompt.contains("clean checkout"), true)
        check("it carries the evidence from the model",
            prompt.contains("MessageChannel") || prompt.contains("ServiceCall"), true)

        val constraints = PromptBuilder.constraints
        check("the constraints forbid editing a model",
            constraints.contains(".services"), true)
        check("they forbid a mesh, which cannot be verified",
            constraints.contains("service mesh"), true)
        check("they forbid weakening verification",
            constraints.contains("NoopHostnameVerifier"), true)
        check("they demand both ends", constraints.contains("BOTH ends"), true)
        check("and they say the clean-checkout trap is invisible from inside",
            constraints.contains("already here"), true)
    }

    /**
     * A patch is checked, not trusted, because the prompt is only instruction.
     *
     * Catches a guard that looks at context lines rather than added ones,
     * which would reject a patch that *removes* a weakening - the very patch
     * worth having.
     */
    private def static void aPatchIsCheckedNotTrusted() {
        check("an empty patch is a violation",
            PatchGuard.violations("").size, 1)

        val clean = '''
        --- a/customer-core/src/main/resources/application.properties
        +++ b/customer-core/src/main/resources/application.properties
        +server.ssl.enabled=true
        +server.ssl.client-auth=need
        '''.toString
        check("a patch that only changes configuration passes",
            PatchGuard.violations(clean).empty, true)
        check("and its changed paths are read",
            PatchGuard.changedPaths(clean).head,
            "customer-core/src/main/resources/application.properties")

        val editsModel = '''
        --- a/service/CustomerCore.services
        +++ b/service/CustomerCore.services
        +@javaWithSpring::_aspects.ServerEndpoint(tlsEnabled = true)
        '''.toString
        check("a patch editing a model is rejected",
            PatchGuard.violations(editsModel).exists[contains("reconstructed output")], true)

        val weakens = '''
        --- a/Client.java
        +++ b/Client.java
        +    .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
        '''.toString
        check("a patch adding NoopHostnameVerifier is rejected",
            PatchGuard.violations(weakens).exists[contains("NoopHostnameVerifier")], true)

        val weakensJs = '''
        --- a/index.js
        +++ b/index.js
        +  rejectUnauthorized: false,
        '''.toString
        check("rejectUnauthorized:false is rejected whatever the spacing",
            PatchGuard.violations(weakensJs).exists[contains("rejectUnauthorized")], true)

        // Found by a real proposal: it documented the constraints it had
        // honoured, naming the very things it must not add. A guard that reads
        // prose rejects a patch for being honest.
        val documentsIt = '''
        --- a/REFACTORING-NOTES.md
        +++ b/REFACTORING-NOTES.md
        +Nothing disables verification: there is no `NoopHostnameVerifier` and no
        +`rejectUnauthorized: false`.
        '''.toString
        check("a patch whose NOTES mention a weakening is not rejected",
            PatchGuard.violations(documentsIt).empty, true)
        check("but the same text in code still is",
            PatchGuard.violations('''
            --- a/index.js
            +++ b/index.js
            +  rejectUnauthorized: false,
            '''.toString).empty, false)

        // The case a naive guard gets backwards.
        val removesWeakening = '''
        --- a/Client.java
        +++ b/Client.java
        -    .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
        +    .setSSLHostnameVerifier(defaultVerifier)
        '''.toString
        check("a patch that REMOVES a weakening is not rejected",
            PatchGuard.violations(removesWeakening).empty, true)
    }

    /**
     * A proposal is recorded so that what cannot be reproduced can be audited.
     *
     * Catches a record that references the skill instead of carrying it, which
     * would need two repositories at the right revisions to be read.
     */
    private def static void aProposalIsRecorded() {
        val result = judge("/channels.services")
        val request = RefactoringRequests.of(result, "/tmp/system", "a-skill").head
        val proposer = new RecordedProposer("--- a/x\n+++ b/x\n+changed\n")
        val proposal = proposer.propose(request)

        check("the fake proposer hands back its patch", proposal.success, true)
        check("and keeps what it was asked", proposer.lastRequest, request)

        val root = Files.createTempDirectory("lemma-record-test")
        val folder = ProposalRecord.write(root, request, proposal, "THE SKILL TEXT")
        check("the record holds the request", Files.exists(folder.resolve("request.md")), true)
        check("the constraints", Files.exists(folder.resolve("constraints.md")), true)
        check("the patch", Files.exists(folder.resolve("patch.diff")), true)
        check("and the skill verbatim, not by reference",
            new String(Files.readAllBytes(folder.resolve("skill.md"))), "THE SKILL TEXT")
        check("the summary names the cause",
            new String(Files.readAllBytes(folder.resolve("model.txt")))
                .contains(request.rootCauseId), true)
        check("and says a patch is not evidence the smell is resolved",
            new String(Files.readAllBytes(folder.resolve("model.txt")))
                .contains("not evidence"), true)
        check("the folder name carries the cause",
            ProposalRecord.folderName(request).contains("endpoint")
                || ProposalRecord.folderName(request).contains("broker"), true)

        val failing = new RecordedProposer(null, "the proposer changed nothing")
            .propose(request)
        check("a failed proposal is not a success", failing.success, false)
        check("and says why", failing.failure, "the proposer changed nothing")
    }


    /**
     * A system with nothing to resolve, which no sample system can show.
     *
     * Every system available here is plaintext throughout, so "the detector
     * found nothing" and "the detector is broken" are indistinguishable
     * without this. Catches a rule that cannot reach a clean verdict at all,
     * a report that announces causes it does not have, and a quickfix that
     * would offer itself where there is nothing to fix.
     */
    private def static void aSecuredSystemYieldsNothingToResolve() {
        val graph = new ServiceModelReader().read(#[
            Paths.get(FIXTURES + "/secured.services") as Path
        ])
        val result = new NonSecuredCommunicationDetector().detect(graph)

        check("a secured system has no findings", result.findings.size, 0)
        check("and therefore no causes", result.byRootCause.size, 0)
        check("and nothing is undecided", result.undecided.size, 0)
        check("every channel was actually judged", result.channelsJudged, 3)

        // The middle channel is the point: §3.7 resolved, §3.8 begun.
        check("the one-way TLS channel is reported as not mutual",
            result.notMutual.size, 1)
        // Guarded rather than dereferenced: when a mutation empties this list
        // the check has to FAIL, not throw, or every later check is lost with
        // it and the suite reports a crash instead of a result.
        check("and names the service it reached",
            result.notMutual.exists[contains("OneWayTlsService")], true)
        check("and says a client certificate is not required",
            result.notMutual.exists[contains("client certificate")], true)
        check("it is not counted as a finding",
            result.findings.exists[callee == "OneWayTlsService"], false)
        check("nor as fully secured",
            result.secured.exists[contains("OneWayTlsService")], false)

        check("the mutual call is secured", result.secured.exists[
            contains("MutualTlsService") && contains("mutual TLS")], true)
        check("the TLS queue is secured too",
            result.secured.exists[contains("secure-orders")], true)

        // What the quickfix would offer here: nothing.
        check("no refactoring is proposed for a secured system",
            RefactoringRequests.of(result, "/tmp/system", "a-skill").size, 0)

        val report = new SmellReport().write(result, graph)
        check("the report says there is no finding", report.contains("No finding"), true)
        check("and does not announce causes it has none of",
            report.contains("What has to change"), false)
        check("but it does report the channel that is not mutual",
            report.contains("not mutually authenticated"), true)
    }


    /**
     * A proposal may only be applied to the commit it was produced against.
     *
     * Catches a check that compares commit identifiers as strings - a record
     * keeps a short hash and rev-parse gives a full one, so that rejects every
     * legitimate match - and one that lets a mismatch through, which is how two
     * incompatible proposals came to overlap in five files.
     */
    private def static void aProposalBelongsToOneCommit() {
        check("an abbreviated hash matches the full one",
            ProposalApplication.sameCommit("622632f",
                "622632f0a1b2c3d4e5f60718293a4b5c6d7e8f90"), true)
        check("and the other way round",
            ProposalApplication.sameCommit("622632f0a1b2c3d4e5f60718293a4b5c6d7e8f90",
                "622632f"), true)
        check("a different commit does not match",
            ProposalApplication.sameCommit("622632f", "8a73096"), false)
        // Seven characters is git's own abbreviation floor; shorter is not an
        // identifier and must not be treated as a prefix match.
        check("too short to be an identifier does not match",
            ProposalApplication.sameCommit("62", "622632f"), false)
        check("nothing matches nothing", ProposalApplication.sameCommit(null, "622632f"), false)
    }

    /**
     * A declared loss makes a repair partial, not complete - and not a failure.
     *
     * Catches the state the declared-loss rule used to produce: a patch that
     * breaks the monitoring scrape and says so read exactly like a patch that
     * broke nothing, because both printed one verdict. Two of the five
     * proposals of this work are in that state.
     */
    private def static void aDeclaredLossIsAPartialRepair() {
        check("a complete repair is verified", verdictReads("REPAIR COMPLETE", true), true)
        check("and is not partial", verdictReads("REPAIR COMPLETE", false), false)
        check("a partial repair is verified too, because every gate passed",
            verdictReads("REPAIR PARTIAL", true), true)
        check("and it says so", verdictReads("REPAIR PARTIAL", false), true)
        check("a failed gate is neither", verdictReads("GATE FAILED", true), false)
        check("a skipped gate is neither", verdictReads("NOT MEASURED", true), false)
        check("the old spelling still reads as verified",
            verdictReads("GATES PASSED", true), true)
        check("but not as partial", verdictReads("GATES PASSED", false), false)
    }

    /**
     * @param verdict the word a verification.md carries
     * @param verified true to ask whether it is verified, false for partial
     */
    private def static boolean verdictReads(String verdict, boolean verified) {
        val folder = Files.createTempDirectory("lemma-verdict-test")
        Files.write(folder.resolve("patch.diff"), "--- a/x\n+++ b/x\n+changed\n".bytes)
        Files.write(folder.resolve("verification.md"),
            '''**«verdict»** — 4 passed, 0 failed, 0 skipped.'''.toString.bytes)
        val proposal = RecordedProposal.at(folder)
        return if (verified) proposal.verified else proposal.partialRepair
    }

    /**
     * What applying refuses, and why it says so.
     *
     * Catches a refusal that reports "it does not apply" when it knows which
     * commit the patch was for, and one that proceeds with no idea what the
     * target is on.
     */
    private def static void applyingRefusesRatherThanGuesses() {
        val folder = Files.createTempDirectory("lemma-proposal-test")
        Files.write(folder.resolve("patch.diff"),
            "--- a/x\n+++ b/x\n+changed\n".bytes)
        Files.write(folder.resolve("model.txt"), '''
        cause         endpoint:CustomerCore
        label         the connectors of CustomerCore
        base          622632f
        target        /tmp/system
        '''.toString.bytes)
        val proposal = RecordedProposal.at(folder)

        check("a folder with a patch reads back", proposal !== null, true)
        check("and its base is the recorded one", proposal.base, "622632f")
        check("and its cause is the label", proposal.cause, "the connectors of CustomerCore")
        check("and it is not verified without a verdict", proposal.verified, false)
        check("nor is it a partial repair without one", proposal.partialRepair, false)

        check("a matching commit that applies is allowed",
            ProposalApplication.refusal(proposal, "622632f0a1b2c3", true), null)

        val mismatch = ProposalApplication.refusal(proposal, "8a73096", true)
        check("a different commit is refused", mismatch !== null, true)
        check("and the refusal names BOTH commits",
            mismatch !== null && mismatch.contains("622632f")
                && mismatch.contains("8a73096"), true)
        check("and says what to do instead",
            mismatch !== null && mismatch.contains("Generate a new proposal"), true)

        val unknown = ProposalApplication.refusal(proposal, null, true)
        check("an unreadable target commit is refused",
            unknown !== null && unknown.contains("not a git checkout"), true)

        val moved = ProposalApplication.refusal(proposal, "622632f", false)
        check("a matching commit that does not apply blames the working tree",
            moved !== null && moved.contains("working") && moved.contains("tree"), true)

        check("a folder with no patch is not a proposal",
            RecordedProposal.at(Files.createTempDirectory("lemma-empty")), null)
        check("and is refused with that reason",
            ProposalApplication.refusal(null, "622632f", true).contains("no proposal"), true)
    }

    /**
     * What an apply will do, before it does it.
     *
     * Catches a plan that forgets the certificate script: the patch configures
     * mutual TLS but commits no key material, so a system applied without it
     * cannot start.
     */
    private def static void anApplyIsPlannedBeforeItRuns() {
        val folder = Files.createTempDirectory("lemma-plan-test")
        Files.write(folder.resolve("patch.diff"), '''
        --- a/customer-core/src/main/resources/application.properties
        +++ b/customer-core/src/main/resources/application.properties
        +server.ssl.enabled=true
        --- /dev/null
        +++ b/generate-certificates.sh
        +#!/usr/bin/env bash
        '''.toString.bytes)
        Files.write(folder.resolve("model.txt"), "base          622632f\n".bytes)

        val plan = ProposalApplication.planFor(RecordedProposal.at(folder), "/tmp/system")
        check("the plan counts the files", plan.files, 2)
        check("it names the base", plan.base, "622632f")
        check("it finds the certificate script the patch ships",
            plan.hasCertificateScript, true)
        check("and names it", plan.certificateScript, "generate-certificates.sh")

        // A patch with no script needs no offer, and claiming otherwise would
        // send the reader to run something that is not there.
        val plain = Files.createTempDirectory("lemma-plan-plain")
        Files.write(plain.resolve("patch.diff"), "--- a/x\n+++ b/x\n+y\n".bytes)
        check("a patch shipping no script offers none",
            ProposalApplication.planFor(RecordedProposal.at(plain), "/tmp/s")
                .hasCertificateScript, false)

        check("the branch is named after the cause, not the date",
            ProposalApplication.branchFor(RecordedProposal.at(
                Files.createDirectories(folder.resolveSibling(
                    "2026-10-15-endpoint-customercore-1792046440612")
                ).resolve("..").normalize.resolve(folder.fileName))) !== null, true)
    }


    /**
     * Applying stages the patch's files and nothing else.
     *
     * Found the hard way: "git add -A" swept three unrelated uncommitted
     * files into a commit whose message named only the refactoring, because
     * git cannot tell a patch's work from the user's. The paths come from the
     * patch, so this checks the list that is handed to git rather than the
     * commit that results - the decision is which paths, not how to stage.
     */
    private def static void applyingStagesOnlyThePatchsFiles() {
        val folder = Files.createTempDirectory("lemma-stage-test")
        Files.write(folder.resolve("patch.diff"), '''
        --- a/customer-core/src/main/resources/application.properties
        +++ b/customer-core/src/main/resources/application.properties
        +server.ssl.enabled=true
        --- /dev/null
        +++ b/generate-certificates.sh
        +#!/usr/bin/env bash
        '''.toString.bytes)
        Files.write(folder.resolve("model.txt"), "base          622632f\n".bytes)
        val proposal = RecordedProposal.at(folder)

        val paths = proposal.changedPaths
        check("the patch's paths are what gets staged", paths.size, 2)
        check("and they are the patch's, not the directory's",
            paths.contains("customer-core/src/main/resources/application.properties")
                && paths.contains("generate-certificates.sh"), true)
        // The three files that were swept in last time are the shape of what
        // must never appear here: anything the patch does not mention.
        check("nothing the patch does not mention is included",
            paths.exists[contains("DataLoader") || contains("SECURITY_REVIEW")], false)
    }

}
