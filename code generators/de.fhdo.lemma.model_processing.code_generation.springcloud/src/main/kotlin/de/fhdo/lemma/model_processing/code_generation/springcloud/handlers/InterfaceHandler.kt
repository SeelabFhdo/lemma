package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAndGetAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependency
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.getEndpoint
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.usesProtocol
import de.fhdo.lemma.service.intermediate.IntermediateEndpoint
import de.fhdo.lemma.service.intermediate.IntermediateInterface

/**
 * Code generation handler for IntermediateInterface instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class InterfaceHandler
    : GenletCodeGenerationHandlerI<IntermediateInterface, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateInterface::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java

    /**
     * Execution logic of the handler
     */
    override fun execute(iface: IntermediateInterface, ifaceClass: ClassOrInterfaceDeclaration, context: Nothing?)
        : GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration>? {
        /*
         * Intermediate interfaces are mapped to Java classes by the base generator. These become Spring Components now.
         */
        ifaceClass.addImport("org.springframework.stereotype.Component", ImportTargetElementType.ANNOTATION,
            SerializationCharacteristic.DONT_RELOCATE)
        ifaceClass.addAnnotation("Component", SerializationCharacteristic.DONT_RELOCATE)

        /* Handle REST mappings */
        if (!iface.usesProtocol("rest"))
            return GenletCodeGenerationHandlerResult(ifaceClass)

        // Turn the interface into a REST controller
        ifaceClass.addImport(
            "org.springframework.web.bind.annotation.RestController",
            ImportTargetElementType.ANNOTATION,
            SerializationCharacteristic.DONT_RELOCATE
        )
        ifaceClass.addDependency("org.springframework.boot:spring-boot-starter-web")
        ifaceClass.addAnnotation("RestController", SerializationCharacteristic.DONT_RELOCATE)

        // Don't' generate constructors for the interface, because the creation of instances is handled by Spring's DI
        // mechanism
        ifaceClass.addSerializationCharacteristic(SerializationCharacteristic.NO_CONSTRUCTORS)

        // In case the interface defines a separated REST endpoint, the class will be annotated with RequestMapping in
        // order to determine its endpoint addresses
        val restEndpoint = iface.getEndpoint("rest") ?: return GenletCodeGenerationHandlerResult(ifaceClass)
        ifaceClass.addImport(
            "org.springframework.web.bind.annotation.RequestMapping",
            ImportTargetElementType.ANNOTATION, SerializationCharacteristic.REMOVE_ON_RELOCATION
        )
        val requestMappingAnnotation = ifaceClass.addAndGetAnnotation(
            "RequestMapping",
            SerializationCharacteristic.REMOVE_ON_RELOCATION
        )
        requestMappingAnnotation.addPair("value", restEndpoint.addressesToAnnotationMultiValue())

        return GenletCodeGenerationHandlerResult(ifaceClass)
    }

    /**
     * Helper to turn the addresses of this [IntermediateEndpoint] to an annotation multi-value as expected by the
     * RequestMapping annotation
     */
    private fun IntermediateEndpoint.addressesToAnnotationMultiValue() : String {
        // Prefix endpoint addresses with service version, if any
        val microservice = `interface`.microservice
        val serviceVersion = microservice.version ?: ""
        val serviceVersionPrefix = if (serviceVersion.isNotEmpty()) "/$serviceVersion/" else ""
        val addressesPrefixes = mutableListOf<String>()
        microservice.getEndpoint("rest")?.addresses?.forEach { addressesPrefixes.add("$serviceVersionPrefix$it") }

        // Build the endpoint addresses
        val endpointAddresses = mutableListOf<String>()
        addresses.forEach { address ->
            if (addressesPrefixes.isEmpty())
                endpointAddresses.add("$serviceVersionPrefix$address")
            else
                addressesPrefixes.forEach { endpointAddresses.add("$it$address") }
        }

        // Return the endpoint addresses in the form of a multi-value annotation String property
        val addressesString = endpointAddresses.joinToString { "\"$it\"" }
        return "{$addressesString}"
    }
}