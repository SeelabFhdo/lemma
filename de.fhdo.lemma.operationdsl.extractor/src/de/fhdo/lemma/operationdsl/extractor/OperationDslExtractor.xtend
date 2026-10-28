package de.fhdo.lemma.operationdsl.extractor

import de.fhdo.lemma.data.PrimitiveValue
import de.fhdo.lemma.operation.Container
import de.fhdo.lemma.operation.ImportedMicroservice
import de.fhdo.lemma.operation.ImportedOperationAspect
import de.fhdo.lemma.operation.InfrastructureNode
import de.fhdo.lemma.operation.OperationModel
import de.fhdo.lemma.operation.OperationNode
import de.fhdo.lemma.operation.PossiblyImportedOperationNode
import de.fhdo.lemma.service.Import
import de.fhdo.lemma.service.ImportType
import de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment

/**
 * Model-to-text extractor for the Operation DSL.
 *
 * Written for the reconstruction of operation models, and therefore covering
 * the parts of the DSL a reconstruction produces: the imports, containers with
 * the microservices they deploy, infrastructure nodes, the dependencies
 * between nodes, and default values of service properties. Aspects, endpoints
 * and per-service deployment specifications are extracted where a model
 * carries them, so that a model read back in is not silently emptied.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class OperationDslExtractor {
    /**
     * Extract an OperationModel
     */
    def String extractToString(OperationModel operationModel) {
        val imports = operationModel.imports.map[generate]
        val importStatements = if (!imports.empty)
                String.join("\n", imports) + "\n\n"
            else
                ""

        val nodes = newArrayList
        nodes.addAll(operationModel.containers.map[generate as CharSequence])
        nodes.addAll(operationModel.infrastructureNodes.map[generate as CharSequence])

        '''«importStatements»«String.join("\n\n", nodes)»'''
    }

    /**
     * Extract an Import
     */
    private def generate(Import ^import) {
        val importTypeKeyword = switch (^import.importType) {
            case TECHNOLOGY: "technology"
            case MICROSERVICES: "microservices"
            case OPERATION_NODES: "nodes"
            default: throw new IllegalArgumentException(
                '''Import type «^import.importType» is not supported by an ''' +
                "operation model.")
        }

        '''import «importTypeKeyword» from "«^import.importURI»" as «^import.name»'''
    }

    /**
     * Extract a Container
     */
    private def generate(Container container) {
        '''
        «container.generateTechnologyAnnotations»
        container «container.name»
            deployment technology «container.deploymentTechnology.^import.name»::«
                »«container.deploymentTechnology.deploymentTechnology.qualifiedNameParts.join(".")»«
            »«container.generateOperationEnvironment»
            deploys «container.deployedServices.map[generate].join(", ")»«
            »«container.generateDependsOnNodes»«
            »«container.generateUsedByNodes» {
            «container.generateAspects»
            «container.generateDefaultValues»
        }'''
    }

    /**
     * Extract an InfrastructureNode
     */
    private def generate(InfrastructureNode node) {
        '''
        «node.generateTechnologyAnnotations»
        «node.name» is «node.infrastructureTechnology.^import.name»::«
            »«node.infrastructureTechnology.infrastructureTechnology.qualifiedNameParts.join(".")»«
        »«node.generateOperationEnvironment»«
        »«node.generateDependsOnNodes»«
        »«node.generateUsedByNodes» {
            «node.generateAspects»
            «node.generateDefaultValues»
        }'''
    }

    /**
     * Extract the technology annotations of an OperationNode. At least one is
     * mandatory, so this never yields an empty line for a valid model.
     */
    private def generateTechnologyAnnotations(OperationNode node) {
        '''«FOR technology : node.technologies SEPARATOR "\n"»@technology(«technology.name»)«ENDFOR»'''
    }

    /**
     * Extract the operation environment of an OperationNode, which is optional
     */
    private def generateOperationEnvironment(OperationNode node) {
        if (node.operationEnvironment === null)
            return ""
        '''

            with operation environment "«node.operationEnvironment.environmentName»"'''
    }

    /**
     * Extract the nodes an OperationNode depends on, which is optional
     */
    private def generateDependsOnNodes(OperationNode node) {
        if (node.dependsOnNodes.empty)
            return ""
        '''

            depends on nodes «node.dependsOnNodes.map[generate].join(", ")»'''
    }

    /**
     * Extract the nodes an OperationNode is used by, which is optional
     */
    private def generateUsedByNodes(OperationNode node) {
        if (node.usedByNodes.empty)
            return ""
        '''

            used by nodes «node.usedByNodes.map[generate].join(", ")»'''
    }

    /**
     * Extract a reference to an OperationNode, which may come from another
     * operation model
     */
    private def generate(PossiblyImportedOperationNode node) {
        if (node.^import !== null)
            '''«node.^import.name»::«node.node.name»'''
        else
            '''«node.node.name»'''
    }

    /**
     * Extract a reference to a deployed Microservice
     */
    private def generate(ImportedMicroservice microservice) {
        '''«microservice.^import.name»::«microservice.microservice.qualifiedNameParts.join(".")»'''
    }

    /**
     * Extract the aspects of an OperationNode, which are optional
     */
    private def generateAspects(OperationNode node) {
        if (node.aspects.empty)
            return ""
        '''
        aspects {
            «FOR aspect : node.aspects»
                «aspect.generate»
            «ENDFOR»
        }'''
    }

    /**
     * Extract an ImportedOperationAspect
     */
    private def generate(ImportedOperationAspect aspect) {
        '''«aspect.technology.name»::«aspect.aspect.getQualifiedNameParts(false, true).join(".")»;'''
    }

    /**
     * Extract the default values of an OperationNode, which are optional. The
     * DSL forbids an empty block, so nothing is written without a value.
     */
    private def generateDefaultValues(OperationNode node) {
        if (node.defaultServicePropertyValues.empty)
            return ""
        '''
        default values {
            «FOR value : node.defaultServicePropertyValues»
                «value.generate»
            «ENDFOR»
        }'''
    }

    /**
     * Extract the value assigned to a technology specific property
     */
    private def generate(TechnologySpecificPropertyValueAssignment assignment) {
        '''«assignment.property.name» = «assignment.value.generate»'''
    }

    /**
     * Extract a primitive value
     */
    private def generate(PrimitiveValue value) {
        if (value.stringValue !== null)
            '''"«value.stringValue»"'''
        else if (value.booleanValue !== null)
            '''«value.booleanValue»'''
        else if (value.numericValue !== null)
            '''«value.numericValue»'''
        else
            '''""'''
    }
}
