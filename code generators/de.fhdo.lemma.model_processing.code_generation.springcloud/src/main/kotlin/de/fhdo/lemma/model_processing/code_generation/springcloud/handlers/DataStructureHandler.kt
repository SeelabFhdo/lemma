package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasFeature

/**
 * Code generation handler for IntermediateDataStructure instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class DataStructureHandler
    : GenletCodeGenerationHandlerI<IntermediateDataStructure, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateDataStructure::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateDataStructure, node: ClassOrInterfaceDeclaration, context: Nothing?)
        : GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration>? {
        /* Determine annotations from data structure features */
        val annotation = when {
            eObject.hasFeature("ENTITY") -> {
                node.addImport("javax.persistence.Entity", ImportTargetElementType.ANNOTATION)
                "Entity"
            }

            eObject.hasFeature("REPOSITORY") -> {
                node.addImport("org.springframework.stereotype.Repository", ImportTargetElementType.ANNOTATION)
                "Repository"
            }

            eObject.hasFeature("APPLICATION_SERVICE") ||
            eObject.hasFeature("DOMAIN_SERVICE") ||
            eObject.hasFeature("INFRASTRUCTURE_SERVICE") ||
            eObject.hasFeature("SERVICE") -> {
                node.addImport("org.springframework.stereotype.Service", ImportTargetElementType.ANNOTATION)
                "Service"
            }

            else -> return GenletCodeGenerationHandlerResult(node)
        }

        node.addAnnotation(annotation)
        return GenletCodeGenerationHandlerResult(node)
    }
}