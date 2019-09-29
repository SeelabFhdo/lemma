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

@CodeGenerationHandler
internal class InterfaceHandler
    : GenletCodeGenerationHandlerI<IntermediateInterface, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateInterface::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java

    override fun execute(iface: IntermediateInterface, ifaceClass: ClassOrInterfaceDeclaration, context: Nothing?)
        : GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration>? {
        if (!iface.usesProtocol("rest"))
            return GenletCodeGenerationHandlerResult(ifaceClass)

        ifaceClass.addImport("org.springframework.web.bind.annotation.RestController",
            ImportTargetElementType.ANNOTATION, SerializationCharacteristic.DONT_RELOCATE)
        ifaceClass.addDependency("org.springframework.boot:spring-boot-starter-web")
        ifaceClass.addSerializationCharacteristic(SerializationCharacteristic.NO_CONSTRUCTORS)
        ifaceClass.addAnnotation("RestController", SerializationCharacteristic.DONT_RELOCATE)

        val restEndpoint = iface.getEndpoint("rest") ?: return GenletCodeGenerationHandlerResult(ifaceClass)
        ifaceClass.addImport("org.springframework.web.bind.annotation.RequestMapping",
            ImportTargetElementType.ANNOTATION, SerializationCharacteristic.REMOVE_ON_RELOCATION)
        val requestMappingAnnotation = ifaceClass.addAndGetAnnotation("RequestMapping",
            SerializationCharacteristic.REMOVE_ON_RELOCATION)
        val addressesAnnotationValue = "{" + buildEndpointAddresses(restEndpoint) + "}"
        requestMappingAnnotation.addPair("value", addressesAnnotationValue)

        return GenletCodeGenerationHandlerResult(ifaceClass)
    }

    private fun buildEndpointAddresses(restEndpoint: IntermediateEndpoint) : String {
        val microservice = restEndpoint.`interface`.microservice
        val serviceVersion = microservice.version ?: ""
        val serviceVersionPrefix = if (serviceVersion.isNotEmpty()) "/$serviceVersion/" else ""
        val addressesPrefixes = mutableListOf<String>()
        microservice.getEndpoint("rest")?.addresses?.forEach {
            addressesPrefixes.add("$serviceVersionPrefix$it")
        }

        val endpointAddresses = mutableListOf<String>()
        restEndpoint.addresses.forEach { address ->
            if (addressesPrefixes.isEmpty())
                endpointAddresses.add("$serviceVersionPrefix$address")
            else
                addressesPrefixes.forEach { endpointAddresses.add("$it$address") }
        }

        return endpointAddresses.joinToString { "\"$it\"" }
    }
}