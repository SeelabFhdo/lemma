package de.fhdo.lemma.model_processing.code_generation.mariadb.template

import de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode

/**
 * Template class for generating operation node specific build scripts.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class MariaDBTemplate {
    /**
     * Template for Spring-based application.properties files for Java or Kotlin.
     */
    static def String getPropertiesForMariaDBServiceConfig(
        IntermediateTechnologySpecificPropertyValue[] serviceProperties
    )'''
        «FOR property : serviceProperties»
            «IF 'springdatasourceurl' == property.technologySpecificProperty.name.toLowerCase»
                spring.datasource.url=«property.value.toLowerCase»
            «ENDIF»
            «IF 'springdatasourceusername' == property.technologySpecificProperty.name.toLowerCase»
                spring.datasource.username=«property.value.toLowerCase»
            «ENDIF»
            «IF 'springdatasourcepassword' == property.technologySpecificProperty.name.toLowerCase»
                spring.datasource.password=«property.value.toLowerCase»
                spring.jpa.hibernate.ddl-auto=update
            «ENDIF»
        «ENDFOR»
    '''

    /**
     * Kubernetes Deployment template for generating a MariaDB deployment.
     */
    static def String getKubernetesDeploymentForMariaDb(IntermediateOperationNode node)'''
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
                «IF (node.name.toLowerCase == "mariadb")»
                env:
                «FOR property : node.defaultValues»
                    «IF(property.technologySpecificProperty.name.toLowerCase == "rootpassword")»
                    - name: MYSQL_ROOT_PASSWORD
                      value: «property.value»
                    «ENDIF»
                    «IF(property.technologySpecificProperty.name.toLowerCase == "userpassword")»
                    - name: MYSQL_PASSWORD
                      value: «property.value»
                    «ENDIF»
                    «IF(property.technologySpecificProperty.name.toLowerCase == "username")»
                    - name: MYSQL_USER
                      value: «property.value»
                    «ENDIF»
                    «IF(property.technologySpecificProperty.name.toLowerCase == "database")»
                    - name: MYSQL_DATABASE
                      value: «property.value»
                    «ENDIF»
                «ENDFOR»
                «ENDIF»
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
          «FOR property : node.defaultValues»
            «IF(property.technologySpecificProperty.name.toLowerCase == "port")»
                  - name: "«property.value»"
                    port: «property.value»
                    targetPort: «property.value»
            «ENDIF»
          «ENDFOR»
          selector:
            app: «node.name.toLowerCase»
          type: ClusterIP
        status:
          loadBalancer: {}
    '''

    /**
     * Create Docker-Compose component for MariaDB
     */
    static def String getDockerComposeForMariaDB(IntermediateInfrastructureNode node)'''
        «node.name.toLowerCase»:
          image: mariadb
          container_name: «node.name.toLowerCase»
          environment:
          «FOR property : node.defaultValues»
              «IF(property.technologySpecificProperty.name.toLowerCase == "username")»
                  «""»  MYSQL_USER : «property.value»
              «ENDIF»
              «IF(property.technologySpecificProperty.name.toLowerCase == "userpassword")»
                  «""»  MYSQL_PASSWORD : «property.value»
              «ENDIF»
              «IF(property.technologySpecificProperty.name.toLowerCase == "rootpassword")»
                  «""»  MYSQL_ROOT_PASSWORD : «property.value»
              «ENDIF»
              «IF(property.technologySpecificProperty.name.toLowerCase == "database")»
                  «""»  MYSQL_DATABASE : «property.value»
              «ENDIF»
          «ENDFOR»
          «FOR property : node.defaultValues»
              «IF(property.technologySpecificProperty.name.toLowerCase == "port")»
                ports:
                  - "«property.value»:«property.value»"
              «ENDIF»
          «ENDFOR»
          networks:
            - default-network
    '''
}