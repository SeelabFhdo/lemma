package de.fhdo.lemma.servicedsl.smells.cli

import de.fhdo.lemma.operationdsl.diagram.OperationModelReader
import de.fhdo.lemma.servicedsl.diagram.ServiceModelReader
import de.fhdo.lemma.servicedsl.smells.DeploymentCoverage
import de.fhdo.lemma.servicedsl.smells.DetectionResult
import de.fhdo.lemma.servicedsl.smells.NonSecuredCommunicationDetector
import de.fhdo.lemma.servicedsl.smells.SmellReport
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.List

/**
 * Detect security smells in LEMMA service models, from the command line.
 *
 * The second way of running the detection, beside the warning the model editor
 * shows. This one judges whole systems at once and writes a report, which is
 * what a result to keep or to cite needs; the editor's warning is what tells
 * someone editing a model that the system it belongs to has a smell.
 *
 * Needs neither a database nor a running Eclipse.
 *
 * <pre>
 * SmellDetectionCli &lt;model-or-folder&gt;… [--report &lt;file&gt;] [--quiet]
 * </pre>
 *
 * Exits 1 when a smell was found, so a script can act on it, and 2 when
 * nothing could be read at all - the difference between a system without
 * findings and a run that judged nothing.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class SmellDetectionCli {
    static val SERVICES_EXTENSION = ".services"
    static val OPERATION_EXTENSION = ".operation"
    static val DEPLOYMENT_OPTION = "--deployment"
    static val REPORT_OPTION = "--report"
    static val QUIET_OPTION = "--quiet"
    static val HELP_OPTION = "--help"

    static val EXIT_FINDINGS = 1
    static val EXIT_NOTHING_READ = 2

    def static void main(String[] args) {
        if (args.empty || args.contains(HELP_OPTION)) {
            println(usage)
            return
        }

        val models = <Path>newLinkedList
        val deploymentModels = <Path>newLinkedList
        var String reportFile = null
        var boolean quiet = false

        var int index = 0
        while (index < args.length) {
            switch (args.get(index)) {
                case REPORT_OPTION: {
                    index++
                    if (index >= args.length) {
                        System.err.println('''«REPORT_OPTION» needs a file.''')
                        System.exit(EXIT_NOTHING_READ)
                    }
                    reportFile = args.get(index)
                }
                case DEPLOYMENT_OPTION: {
                    index++
                    if (index >= args.length) {
                        System.err.println('''«DEPLOYMENT_OPTION» needs a model or folder.''')
                        System.exit(EXIT_NOTHING_READ)
                    }
                    deploymentModels.addAll(modelsAt(args.get(index), OPERATION_EXTENSION))
                }
                case QUIET_OPTION:
                    quiet = true
                default:
                    models.addAll(modelsAt(args.get(index), SERVICES_EXTENSION))
            }
            index++
        }

        if (models.empty) {
            System.err.println("No .services model was found at the given paths.")
            System.exit(EXIT_NOTHING_READ)
        }

        val graph = new ServiceModelReader().read(models)
        val result = new NonSecuredCommunicationDetector().detect(graph)

        // What the deployment holds beside the judged services. Optional
        // because the detection does not need it to judge anything - it needs
        // it to say where its view ends, and an operation model is not always
        // reconstructed.
        var List<String> unmodelled = emptyList
        if (!deploymentModels.empty) {
            val deployment = new OperationModelReader().read(deploymentModels)
            unmodelled = DeploymentCoverage.potentialUnmodelledClients(deployment, graph)
        }

        if (reportFile !== null) {
            val report = new SmellReport().write(result, graph, unmodelled)
            Files.write(Paths.get(reportFile), report.getBytes(StandardCharsets.UTF_8))
            println('''Report written to «reportFile».''')
        }
        if (!quiet) {
            print(summary(result, models.size))
            if (!unmodelled.empty) {
                println('''
                «unmodelled.size» deployment node(s) deploy no reconstructed microservice, so no channel of theirs was judged:''')
                unmodelled.forEach[println('''    «it»''')]
            }
        }

        if (graph.empty) {
            System.exit(EXIT_NOTHING_READ)
        }
        if (!result.findings.empty) {
            System.exit(EXIT_FINDINGS)
        }
    }

    /**
     * The models at one path: the file itself, or every model whose name ends
     * with this suffix below a folder.
     */
    private def static List<Path> modelsAt(String path, String suffix) {
        val start = Paths.get(path)
        if (!Files.exists(start)) {
            System.err.println('''No such file or folder: «path»''')
            return emptyList
        }
        if (Files.isRegularFile(start)) {
            return #[start]
        }
        val found = <Path>newLinkedList
        val stream = Files.walk(start)
        try {
            stream.filter[Files.isRegularFile(it)]
                .filter[fileName.toString.endsWith(suffix)]
                .forEach[found.add(it)]
        } finally {
            stream.close
        }
        // Sorted, so two runs over the same folder report in the same order.
        return found.sort
    }

    /**
     * What a reader needs on the terminal: the findings, and how much was not
     * decided.
     */
    private def static String summary(DetectionResult result, int models) {
        return '''
        «NonSecuredCommunicationDetector.SMELL»
        «NonSecuredCommunicationDetector.REFERENCE»

        «models» model(s) read.
        «result.findings.size» finding(s), «result.secured.size» channel(s) judged protected, «
            result.notMutual.size» encrypted but not mutually authenticated, «
            result.undecided.size» not decidable from the models.
        «FOR finding : result.findings»
            «finding.caller» -> «finding.callee» («finding.channel»)
                «finding.reason»
        «ENDFOR»
        «IF !result.undecided.empty»

            Not decidable:
            «FOR entry : result.undecided»
                «entry»
            «ENDFOR»
        «ENDIF»
        «IF !result.problems.empty»

            Problems:
            «FOR problem : result.problems»
                «problem»
            «ENDFOR»
        «ENDIF»
        '''.toString
    }

    private def static String usage() {
        return '''
        Detect security smells in LEMMA service models.

        Usage:
          SmellDetectionCli <model-or-folder>… [options]

        Arguments:
          <model-or-folder>   A .services model, or a folder to search for them.
                              Every model the given ones import is read as well,
                              because a finding is about a pair of services.

        Options:
          «DEPLOYMENT_OPTION» <path> An operation model, or a folder of them. Their
                              nodes are compared against the service models,
                              and a node deploying no reconstructed
                              microservice is reported as a potential
                              unmodelled client - not as a finding
          «REPORT_OPTION» <file>     Write the full report, with the evidence of
                              each finding, as Markdown
          «QUIET_OPTION»             Write nothing to the terminal
          «HELP_OPTION»              Print this text

        Exit status:
          0   nothing found
          «EXIT_FINDINGS»   at least one finding
          «EXIT_NOTHING_READ»   no model could be read, which is not the same as
              nothing found
        '''.toString
    }
}
