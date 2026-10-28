package de.fhdo.lemma.servicedsl.smells

import de.fhdo.lemma.servicedsl.diagram.ServiceGraph
import java.util.List

/**
 * The report a detection run writes.
 *
 * Markdown, for the same reasons the diagrams are PlantUML: it is diffable, it
 * renders where the models are read, and it needs nothing installed. A function
 * of the result and the graph, so what it says can be checked without an
 * Eclipse.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class SmellReport {
    /**
     * Write the report of one detection run.
     *
     * @param result what was found
     * @param graph the services it was found in
     * @return the Markdown of the report
     */
    def String write(DetectionResult result, ServiceGraph graph) {
        return write(result, graph, emptyList)
    }

    /**
     * Write the report, with what the deployment holds beside the judged
     * services.
     *
     * @param result what was found
     * @param graph the services it was found in
     * @param unmodelled deployment nodes that deploy no reconstructed
     *     microservice, from [[DeploymentCoverage]]
     * @return the Markdown of the report
     */
    def String write(DetectionResult result, ServiceGraph graph, List<String> unmodelled) {
        return '''
            # Security smells

            Detected in «graph.services.filter[resolved].size» microservice(s) of the selected service models and the models they import.

            | | |
            |---|---|
            | Findings | «result.findings.size» |
            | Root causes behind them | «result.byRootCause.size» |
            | Channels judged protected | «result.secured.size» |
            | Channels encrypted but not mutually authenticated | «result.notMutual.size» |
            | Channels that could not be judged | «result.undecided.size» |
            | Services with no fact about a channel | «result.unjudged.size» |
            «IF !unmodelled.empty»
                | Deployment nodes deploying no reconstructed microservice | «unmodelled.size» |
            «ENDIF»

            ## «NonSecuredCommunicationDetector.SMELL»

            «NonSecuredCommunicationDetector.REFERENCE». The smell holds whenever two microservices interact without a secure channel, *even if they are within the same network*. Suggested refactoring: **«NonSecuredCommunicationDetector.REFACTORING»** — mutual rather than plain TLS, because it also authenticates the peers.

            «IF result.findings.empty»
                No finding.«IF !result.undecided.empty» That is not the same as a system without the smell: «result.undecided.size» channel(s) below could not be judged.«ENDIF»«IF !result.unjudged.empty» «result.unjudged.size» service(s) carry no fact about any channel of theirs, so they were not judged at all.«ENDIF»

            «ELSE»
                «FOR finding : result.findings»
                    ### «finding.caller» → «finding.callee»

                    - **Channel:** «finding.channel»
                    - **Why:** «finding.reason»
                    - **Refactoring:** «finding.refactoring»
                    «IF !finding.evidence.empty»
                        - **Evidence, as the models state it:**
                        «FOR item : finding.evidence»
                            «"  "»- `«item»`
                        «ENDFOR»
                    «ENDIF»

                «ENDFOR»
            «ENDIF»
            «IF !result.byRootCause.empty»
                ### What has to change

                «result.findings.size» finding(s) come from «result.byRootCause.size» cause(s). A cause is the unit a refactoring acts on, because mutual TLS has to be applied to both ends of every channel it covers at once.

                The cause's id is quoted so that a verification can ask whether
                *this* cause still has findings, rather than only whether the
                total fell.

                «FOR cause : result.byRootCause.entrySet»
                    - **«cause.value.head.rootCauseLabel ?: cause.key»** (`«cause.key»`) — «cause.value.size» finding(s)
                «ENDFOR»

            «ENDIF»
            «IF !result.notMutual.empty»
                ### Encrypted, but not mutually authenticated

                Not findings: §3.7 is resolved by TLS. But the refactoring the paper prescribes
                for it is *mutual* TLS, so these channels were secured by a weaker means than the
                one cited, and this is where §3.8 Unauthenticated traffic begins.

                «FOR entry : result.notMutual»
                    - «entry»
                «ENDFOR»

            «ENDIF»
            «IF !result.secured.empty»
                ## Judged protected

                «FOR entry : result.secured»
                    - «entry»
                «ENDFOR»

            «ENDIF»
            «IF !result.undecided.empty»
                ## Could not be judged

                The facts in the models do not settle these. Reported rather than counted as protected, so a system that does not smell and a system whose facts were not reconstructed do not look alike.

                «FOR entry : result.undecided»
                    - «entry»
                «ENDFOR»

            «ENDIF»
            «IF !result.unjudged.empty»
                ## Not judged at all

                These services carry no fact about any channel of theirs, so nothing above is about them. That is a gap in what was reconstructed, not a statement that they communicate securely or that they communicate at all — and a channel nobody can see is a channel no verification can measure.

                «FOR entry : result.unjudged»
                    - «entry»
                «ENDFOR»

            «ENDIF»
            «IF !unmodelled.empty»
                ## Potential unmodelled clients

                These nodes are brought up by the same deployment as the judged services, and no service model declares what they deploy. Nothing above is about them, and nothing here says they communicate at all, let alone insecurely: it says the detection cannot see whether they do. Counting services with no fact does not catch them, because they have no service model to miss a fact in.

                Measured, and it is why this section exists: both of Lakeside Mutual's are real clients of a connector the detection judged, and a refactoring given the sources secured them where one given only the models did not.

                «FOR entry : unmodelled»
                    - «entry»
                «ENDFOR»

            «ENDIF»
            «IF !result.problems.empty»
                ## Problems

                «FOR problem : result.problems»
                    - «problem»
                «ENDFOR»
            «ENDIF»
        '''.toString
    }
}
