package de.fhdo.lemma.model_processing.code_generation.mongodb.template

import de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode

/**
 * Template class for generating operation node specific MongoDB configurations.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class MongoDBTemplate {
    /**
     * Template for Spring-based application.properties files for Java or Kotlin.
     */
    static def String getPropertiesForMongoDBServiceConfig(
        IntermediateTechnologySpecificPropertyValue[] serviceProperties)'''
        «FOR property : serviceProperties»
            «IF 'springdatamongodbhost' == property.technologySpecificProperty.name.toLowerCase»
                spring.data.mongodb.host=«property.value.toLowerCase»
            «ENDIF»
            «IF 'springdatamongodbport' == property.technologySpecificProperty.name.toLowerCase»
                spring.data.mongodb.port=«property.value.toLowerCase»
            «ENDIF»
            «IF 'springdatamongodbdatabase' == property.technologySpecificProperty.name.toLowerCase»
                spring.data.mongodb.database=«property.value.toLowerCase»
            «ENDIF»
            «IF 'springdatamongodbusername' == property.technologySpecificProperty.name.toLowerCase»
                spring.data.mongodb.authentication-database=admin
                spring.data.mongodb.username=«property.value.toLowerCase»
            «ENDIF»
            «IF 'stringdatamongodbpassword' == property.technologySpecificProperty.name.toLowerCase»
                spring.data.mongodb.password=«property.value.toLowerCase»
            «ENDIF»
        «ENDFOR»
    '''

    /**
     * Kubernetes Deployment template for generating a MongoDB deployment files.
     */
    static def String getKubernetesDeploymentForMongoDB(IntermediateInfrastructureNode node)'''
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
              - image: mongo
                imagePullPolicy: "Never"
                name: «node.name.toLowerCase»
                «IF (node.name.toLowerCase == "mongodb")»
                env:
                «FOR property : node.defaultValues»
                    «IF(property.technologySpecificProperty.name.toLowerCase ==
                        "username")»
                    - name: MONGO_INITDB_ROOT_USERNAME
                      value: «property.value»
                    «ENDIF»
                    «IF(property.technologySpecificProperty.name.toLowerCase ==
                        "password")»
                    - name: MONGO_INITDB_ROOT_PASSWORD
                      value: «property.value»
                    «ENDIF»
                    «IF(property.technologySpecificProperty.name.toLowerCase ==
                        "database")»
                    - name: MONGO_INITDB_DATABASE
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
     * Docker compose deployment template for MongoDB infrastructure nodes.
     */
    static def String getDockerComposeForMongoDB(IntermediateInfrastructureNode node)'''
        «node.name.toLowerCase»:
          image: mongo
          container_name: «node.name.toLowerCase»
          environment:
          «FOR property : node.defaultValues»
              «IF(property.technologySpecificProperty.name.toLowerCase ==
                    "username")»
                  «""»  MONGO_INITDB_ROOT_USERNAME : «property.value»
              «ENDIF»
              «IF(property.technologySpecificProperty.name.toLowerCase ==
                    "password")»
                  «""»  MONGO_INITDB_ROOT_PASSWORD : «property.value»
              «ENDIF»
              «IF(property.technologySpecificProperty.name.toLowerCase ==
                    "database")»
                  «""»  MONGO_INITDB_DATABASE : «property.value»
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