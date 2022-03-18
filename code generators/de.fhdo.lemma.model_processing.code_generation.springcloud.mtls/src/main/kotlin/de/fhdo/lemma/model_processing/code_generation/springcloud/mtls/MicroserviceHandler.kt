package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.shared.ApplicationProperties
import de.fhdo.lemma.model_processing.utils.hasTechnology
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice

private const val BOOTSTRAP_ADDRESS_PROPERTY = "kafka.bootstrapAddress"
private const val AVRO_REGISTRY_ADDRESS_PROPERTY = "kafka.avro.schemaRegistryAddress"

/**
 * Code generation handler for IntermediateMicroservice instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class MicroserviceHandler
    : GenletCodeGenerationHandlerI<IntermediateMicroservice, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateMicroservice::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateMicroservice, node: ClassOrInterfaceDeclaration, context: Nothing?)
        : GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration>? {
        println(eObject.qualifiedName)
        eObject.technologies.forEach { println(it.name) }
        if (!eObject.hasTechnology("mTLS"))
            return null
        println("Hallo ich habe mTLS ")

        return GenletCodeGenerationHandlerResult(node, ApplicationProperties.getGeneratedFile())
    }
}