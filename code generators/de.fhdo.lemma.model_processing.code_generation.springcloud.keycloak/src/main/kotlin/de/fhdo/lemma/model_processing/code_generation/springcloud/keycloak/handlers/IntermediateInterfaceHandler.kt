package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.handlers

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.getAllAspects
import de.fhdo.lemma.model_processing.code_generation.java_base.getAspectPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.Context
import de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.model.PermissionsInterface
import de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.model.PermissionsOperation
import de.fhdo.lemma.service.intermediate.IntermediateInterface

@CodeGenerationHandler
internal class IntermediateInterfaceHandler
    : GenletCodeGenerationHandlerI<IntermediateInterface, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateInterface::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java

    override fun execute(
        eObject: IntermediateInterface,
        node: ClassOrInterfaceDeclaration,
        context: Nothing?
    ): GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration> {
        val interfaceRoles = mutableSetOf<String>()
        val interfacePaths = mutableSetOf<String>()
        val interfaceOperations = mutableListOf<PermissionsOperation>()


        eObject.getAllAspects("Keycloak.Role").forEach { aspect ->
            aspect.getPropertyValue("name")?.let { interfaceRoles.add(it) }
        }

        eObject.endpoints.forEach { endpoint ->
            endpoint.addresses.forEach { address ->
                interfacePaths.add(address)
            }
        }

        eObject.operations.filter { it.endpoints.isNotEmpty() }.forEach { intermediateOperation ->
            val operationRoles = mutableSetOf<String>()
            val operationPaths = mutableSetOf<String>()
            val operationPathVars = mutableSetOf<Pair<String, String>>()
            intermediateOperation.endpoints.forEach { endpoint ->
                endpoint.addresses.forEach { address ->
                    operationPaths.add(address)
                }
            }
            intermediateOperation.getAllAspects("Keycloak.Role").forEach { aspect ->
                aspect.getPropertyValue("name")?.let { operationRoles.add(it) }
            }

            intermediateOperation.parameters.filter { it.hasAspect("Spring.PathVariable") }.forEach { parameter ->
                parameter.getAspectPropertyValue("Spring.PathVariable", "value")?.let {
                    operationPathVars.add(it to parameter.type.name)
                }
            }
            interfaceOperations.add(
                PermissionsOperation(
                    operationRoles.toList(), operationPaths.toList(), operationPathVars.toList()
                )
            )
        }
        Context.State.addInterface(
            PermissionsInterface(
                interfaceRoles.toList(),
                interfacePaths.toList(),
                interfaceOperations
            )
        )
        return GenletCodeGenerationHandlerResult(node)
    }
}

