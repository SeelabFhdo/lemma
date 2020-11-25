package de.fhdo.lemma.model_processing.code_generation.container_base.template

import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode
import de.fhdo.lemma.utils.LemmaUtils

/**
 * Template class for generating Kubernetes deployment files.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class KubernetesTemplate {
    /**
     * Create the operation node specific Kubernetes deployment file.
     */
    static def String buildKubernetesFile(IntermediateOperationNode node)'''
        apiVersion: apps/v1
        kind: Deployment
        metadata:
          creationTimestamp: null
          labels:
            app: «node.name.toLowerCase»
          name: «node.name.toLowerCase»
        spec:
          replicas: 1
          selector:
            matchLabels:
              app: «node.name.toLowerCase»
          strategy: {}
          template:
            metadata:
              creationTimestamp: null
              labels:
                app: «node.name.toLowerCase»
            spec:
              containers:
              - image: «node.name.toLowerCase»
                imagePullPolicy: "Never"
                name: «node.name.toLowerCase»
                resources: {}
        status: {}
        ---
        apiVersion: v1
        kind: Service
        metadata:
          creationTimestamp: null
          labels:
            app: «node.name.toLowerCase»
          name: «node.name.toLowerCase»
        spec:
          ports:
          «FOR endpoints : node.endpoints»
              «FOR address : endpoints.addresses»
                  - name: "«LemmaUtils.getPortFromAddress(address)»"
                    port: «LemmaUtils.getPortFromAddress(address)»
                    targetPort: «LemmaUtils.getPortFromAddress(address)»
              «ENDFOR»
          «ENDFOR»
          selector:
            app: «node.name.toLowerCase»
          type: ClusterIP
        status:
          loadBalancer: {}

    '''
}