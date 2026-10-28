package de.fhdo.lemma.servicedsl.smells

import de.fhdo.lemma.operationdsl.diagram.NodeInfo
import de.fhdo.lemma.operationdsl.diagram.OperationGraph
import de.fhdo.lemma.servicedsl.diagram.ServiceGraph
import java.util.List

/**
 * Where the judged system ends and the deployed one carries on.
 *
 * The detection judges channels between reconstructed microservices. A
 * deployment holds more than those: Lakeside Mutual's compose file brings up a
 * monitoring server, which the reconstruction skips as infrastructure, and an
 * NGINX load-balancing demonstration, which it does not read at all. Both are
 * real clients of the Customer Core's connector, and a refactoring that was
 * given the sources found them where one given only the models did not.
 *
 * So the coverage question - how far does the detector's view reach? - cannot be
 * answered by counting services with no fact: those two have no service model to
 * miss a fact in. It is answered here, from facts already reconstructed, by
 * comparing the deployment against the service models and naming every node that
 * deploys no microservice any read model declares.
 *
 * These are **not** findings. Nothing here says such a node talks to anything,
 * or that it does so insecurely. It says the detector cannot see whether it
 * does, which is what a report has to admit rather than imply by silence.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class DeploymentCoverage {
    /**
     * The deployment nodes that deploy no reconstructed microservice.
     *
     * @param deployment the operation models' nodes
     * @param services the service models the detection judged
     * @return one line per node, as the report prints it
     */
    def static List<String> potentialUnmodelledClients(OperationGraph deployment,
        ServiceGraph services) {
        if (deployment === null || services === null) {
            return emptyList
        }
        return deployment.nodes
            .filter[resolved]
            .filter[node | !deploysSomethingModelled(node, services)]
            .map[label]
            .toList
    }

    /**
     * Whether this node deploys a microservice a read service model declares.
     *
     * A container writes the service as the model wrote it,
     * ``CustomerCore::com.lakesidemutual.customercore.CustomerCore``, so the
     * simple names are compared and the written form is accepted when it ends
     * with a declared qualified name. Two services of the same simple name in
     * different contexts would otherwise need the alias resolved, which does
     * not resolve outside a running Xtext.
     */
    private def static boolean deploysSomethingModelled(NodeInfo node, ServiceGraph services) {
        return node.artifacts.exists[artifact |
            services.services.exists[service |
                service.resolved && (service.name == artifact.name
                    || (artifact.written !== null
                        && artifact.written.endsWith(service.qualifiedName)))
            ]
        ]
    }

    /**
     * What the report prints for one node: its name, what kind it is, and the
     * technology or image it runs, because that is what identifies it to
     * somebody reading the deployment.
     */
    private def static String label(NodeInfo node) {
        val kind = if (node.container) "container" else "infrastructure node"
        val technology = node.technology ?: "technology not stated"
        val environment = if (node.operationEnvironment !== null)
                ''', «node.operationEnvironment»'''
            else
                ""
        return '''`«node.name»` — «kind», «technology»«environment»; deploys no reconstructed microservice'''
    }
}
