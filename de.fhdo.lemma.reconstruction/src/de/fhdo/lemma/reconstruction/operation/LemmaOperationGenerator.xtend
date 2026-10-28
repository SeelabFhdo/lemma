package de.fhdo.lemma.reconstruction.operation

import de.fhdo.lemma.operation.OperationModel
import de.fhdo.lemma.data.DataFactory
import de.fhdo.lemma.operation.Container
import de.fhdo.lemma.operation.OperationFactory
import de.fhdo.lemma.service.ImportType
import de.fhdo.lemma.service.ServiceFactory
import de.fhdo.lemma.technology.TechnologyFactory
import java.io.File
import java.math.BigDecimal
import java.util.HashMap
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Generator of a LEMMA operation model from reconstructed operation nodes.
 *
 * The deployment technology and the technology annotations are not
 * reconstructed. They are references into a technology model, which is written
 * by hand and lives in the models folder of this bundle, so they are chosen
 * here. See ADR-0008 of the reconstruction framework.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class LemmaOperationGenerator {
    static val OPERATION_FACTORY = OperationFactory.eINSTANCE
    static val SERVICE_FACTORY = ServiceFactory.eINSTANCE
    static val TECHNOLOGY_FACTORY = TechnologyFactory.eINSTANCE
    static val DATA_FACTORY = DataFactory.eINSTANCE

    /**
     * Alias and location of the technology model the generated nodes
     * reference. The strict model marks springApplicationName and serverPort
     * as mandatory, which a container may be held to because the
     * reconstruction reads both from its application.properties, and a
     * container for which it reads neither deploys no microservice and is left
     * out anyway.
     */
    static val TECHNOLOGY_ALIAS = "deploymentBase"
    static val TECHNOLOGY_MODEL = "deployment_base.technology"

    /**
     * Meta-data name under which the reconstruction reports the configuration
     * of a node, already keyed by the names a technology model declares.
     */
    static val SERVICE_PROPERTIES = "ServiceProperties"
    static val DEPLOYMENT_TECHNOLOGY = "Kubernetes"

    /**
     * Technology model an infrastructure node is assigned a technology from.
     * The node's own name is the name of the technology, so Eureka becomes
     * javaWithSpring::_infrastructure.Eureka: a node the reconstruction
     * recognises by name is one the technology model is expected to declare
     * under that name, and adding a kind of infrastructure is a change to the
     * model rather than to this generator.
     */
    static val INFRASTRUCTURE_TECHNOLOGY_ALIAS = "javaWithSpring"
    static val INFRASTRUCTURE_TECHNOLOGY_MODEL = "spring.technology"

    val model = OPERATION_FACTORY.createOperationModel

    /**
     * Import of the service model of each microservice, by its name. A
     * microservice is defined in the model named after it, so a container
     * deploying several of them needs several imports.
     */
    val serviceImports = new HashMap<String, de.fhdo.lemma.service.Import>

    /**
     * Nodes left out because they deploy no microservice, reported by the
     * wizard so that their absence is visible.
     */
    @Accessors(PUBLIC_GETTER)
    val skippedNodes = <String>newLinkedList

    var de.fhdo.lemma.service.Import infrastructureImport

    var String technologyFolder

    /**
     * Generate an operation model from the reconstructed nodes of a system.
     *
     * All nodes of a system go into one model: they refer to each other by
     * name, and a reference to a node of another model would need an import of
     * that model rather than a plain name.
     */
    def OperationModel generateModelFrom(List<OperationNode> reconstructedNodes,
        String technologyFolder) {
        this.technologyFolder = technologyFolder
        val technologyImport = createImport(TECHNOLOGY_ALIAS,
            '''..«File.separator»«technologyFolder»«File.separator»«TECHNOLOGY_MODEL»'''.toString,
            ImportType.TECHNOLOGY)
        model.imports.add(technologyImport)

        reconstructedNodes.forEach[
            if (nodeType === NodeType.INFRASTRUCTURE) {
                model.infrastructureNodes.add(
                    generateInfrastructureNodeFrom(it, technologyImport))
            } else if (deployedServices.empty) {
                // A container has to deploy a microservice. A Compose service
                // with none reconstructed for it - a user interface, say -
                // cannot be expressed, so it is left out rather than written
                // as a container the Operation DSL rejects.
                skippedNodes.add(name)
            } else {
                model.containers.add(
                    generateContainerFrom(it, technologyImport))
            }
        ]

        // A node is referenced by name, so the nodes it depends on can only be
        // resolved once all of them exist.
        reconstructedNodes.forEach[ reconstructedNode |
            val node = model.findNode(reconstructedNode.name)
            if (node !== null) {
                reconstructedNode.dependsOn.forEach[ dependency |
                    val dependsOn = model.findNode(dependency)
                    if (dependsOn !== null) {
                        val reference = OPERATION_FACTORY
                            .createPossiblyImportedOperationNode
                        reference.node = dependsOn
                        node.dependsOnNodes.add(reference)
                    }
                ]
            }
        ]

        return model
    }

    /**
     * Generate a container, which deploys the microservices of the
     * reconstructed node.
     */
    private def generateContainerFrom(OperationNode reconstructedNode,
        de.fhdo.lemma.service.Import technologyImport) {
        val container = OPERATION_FACTORY.createContainer
        container.name = reconstructedNode.name
        container.technologies.add(technologyImport)

        val deploymentTechnology = TECHNOLOGY_FACTORY.createDeploymentTechnology
        deploymentTechnology.name = DEPLOYMENT_TECHNOLOGY
        val reference = OPERATION_FACTORY.createDeploymentTechnologyReference
        reference.^import = technologyImport
        reference.deploymentTechnology = deploymentTechnology
        container.deploymentTechnology = reference

        container.operationEnvironment =
            createOperationEnvironment(reconstructedNode.operationEnvironment)

        assignDefaultValues(container, reconstructedNode)

        reconstructedNode.deployedServices.forEach[
            val importedMicroservice = OPERATION_FACTORY.createImportedMicroservice
            // Every microservice lives in its own service model, so each needs
            // the import of that model rather than one shared import.
            importedMicroservice.^import = serviceImportFor(name)
            importedMicroservice.microservice = createMicroservice(qualifiedName)
            container.deployedServices.add(importedMicroservice)
        ]

        return container
    }

    /**
     * Generate an infrastructure node.
     */
    private def generateInfrastructureNodeFrom(OperationNode reconstructedNode,
        de.fhdo.lemma.service.Import deploymentImport) {
        val node = OPERATION_FACTORY.createInfrastructureNode
        node.name = reconstructedNode.name
        node.technologies.add(deploymentImport)

        val technologyOfNode = infrastructureTechnologyImport
        node.technologies.add(technologyOfNode)

        val infrastructureTechnology = TECHNOLOGY_FACTORY
            .createInfrastructureTechnology
        infrastructureTechnology.name = reconstructedNode.name
        val reference = OPERATION_FACTORY.createInfrastructureTechnologyReference
        reference.^import = technologyOfNode
        reference.infrastructureTechnology = infrastructureTechnology
        node.infrastructureTechnology = reference

        node.operationEnvironment =
            createOperationEnvironment(reconstructedNode.operationEnvironment)

        // The configuration is not carried over to an infrastructure node. Its
        // service properties are declared by its infrastructure technology,
        // which names them differently - SpringBootAdmin declares
        // applicationName and port where a deployment technology declares
        // springApplicationName and serverPort - so the values the
        // reconstruction reports would refer to properties that do not exist.

        return node
    }

    /**
     * Assign the configuration of a node as the default values of its service
     * properties.
     *
     * The reconstruction reports them under the names a technology model
     * declares, so the name is carried over unchanged. A value the model does
     * not declare is written all the same and reported by the editor, which
     * names the missing declaration rather than dropping what was found.
     */
    private def assignDefaultValues(Container container,
        OperationNode reconstructedNode) {
        val configuration = reconstructedNode.metaData.findFirst[
            name == SERVICE_PROPERTIES
        ]
        if (configuration === null || configuration.values === null ||
            configuration.values.empty) {
            return
        }

        configuration.values.forEach[ propertyName, value |
            val property = TECHNOLOGY_FACTORY.createTechnologySpecificProperty
            property.name = propertyName

            val assignment = TECHNOLOGY_FACTORY
                .createTechnologySpecificPropertyValueAssignment
            assignment.property = property
            assignment.value = createPrimitiveValue(value)
            container.defaultServicePropertyValues.add(assignment)
        ]
    }

    /**
     * Create the value of a property. A configuration is text, so a number is
     * recognised here rather than reported as one by the reconstruction.
     */
    private def createPrimitiveValue(String value) {
        val primitiveValue = DATA_FACTORY.createPrimitiveValue
        try {
            primitiveValue.numericValue = new BigDecimal(value)
        } catch (NumberFormatException e) {
            primitiveValue.stringValue = value
        }
        return primitiveValue
    }

    /**
     * Create the operation environment of a node. A node without a Dockerfile
     * has none, and the clause is optional, so null is a valid result.
     */
    private def createOperationEnvironment(String environmentName) {
        if (environmentName.nullOrEmpty)
            return null
        val environment = TECHNOLOGY_FACTORY.createOperationEnvironment
        environment.environmentName = environmentName
        return environment
    }

    /**
     * Create the microservice a container deploys. Only its name is needed:
     * the microservice itself is defined in the imported service model.
     */
    private def createMicroservice(String qualifiedName) {
        val microservice = SERVICE_FACTORY.createMicroservice
        microservice.name = qualifiedName
        return microservice
    }

    /**
     * The import of the technology model the infrastructure technologies are
     * declared in, created on first use.
     */
    private def getInfrastructureTechnologyImport() {
        if (infrastructureImport === null) {
            infrastructureImport = createImport(INFRASTRUCTURE_TECHNOLOGY_ALIAS,
                '''..«File.separator»«technologyFolder»«File.separator»«
                    »«INFRASTRUCTURE_TECHNOLOGY_MODEL»'''.toString,
                ImportType.TECHNOLOGY)
            model.imports.add(infrastructureImport)
        }
        return infrastructureImport
    }

    /**
     * The import of the service model a microservice is defined in, created on
     * first use.
     */
    private def serviceImportFor(String microserviceName) {
        if (!serviceImports.containsKey(microserviceName)) {
            val ^import = createImport(microserviceName,
                '''..«File.separator»service«File.separator»«microserviceName».services'''
                    .toString,
                ImportType.MICROSERVICES)
            model.imports.add(^import)
            serviceImports.put(microserviceName, ^import)
        }
        return serviceImports.get(microserviceName)
    }

    private def createImport(String name, String importUri, ImportType type) {
        val ^import = SERVICE_FACTORY.createImport
        ^import.name = name
        ^import.importURI = importUri
        ^import.importType = type
        return ^import
    }

    private def findNode(OperationModel operationModel, String name) {
        val container = operationModel.containers.findFirst[it.name == name]
        if (container !== null)
            return container as de.fhdo.lemma.operation.OperationNode
        return operationModel.infrastructureNodes.findFirst[it.name == name]
            as de.fhdo.lemma.operation.OperationNode
    }
}
