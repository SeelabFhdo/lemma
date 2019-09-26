package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.*
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasApiComments
import de.fhdo.lemma.model_processing.utils.trimToSingleLine
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice

@CodeGenerationHandler
internal class MicroserviceHandler
    : GenletCodeGenerationHandlerI<IntermediateMicroservice, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateMicroservice::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java

    override fun execute(intermediateService: IntermediateMicroservice, serviceClass: ClassOrInterfaceDeclaration,
        context: Nothing?) : GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration>? {
        serviceClass.addSerializationCharacteristic(SerializationCharacteristic.NO_CONSTRUCTORS)
        serviceClass.addImport("org.springframework.boot.SpringApplication", ImportTargetElementType.ANNOTATION,
            SerializationCharacteristic.DONT_RELOCATE)
        serviceClass.addImport("org.springframework.boot.autoconfigure.SpringBootApplication",
            ImportTargetElementType.ANNOTATION, SerializationCharacteristic.DONT_RELOCATE)

        if (intermediateService.hasApiComments) {
            serviceClass.addDependency("io.springfox:springfox-swagger2:2.9.2")
            serviceClass.addImport("springfox.documentation.swagger2.annotations.EnableSwagger2",
                ImportTargetElementType.ANNOTATION, SerializationCharacteristic.DONT_RELOCATE)
            serviceClass.addAnnotation("EnableSwagger2", SerializationCharacteristic.DONT_RELOCATE)
        }

        serviceClass.addAnnotation("SpringBootApplication", SerializationCharacteristic.DONT_RELOCATE)
        val mainMethod = serviceClass.addMethod("main", Modifier.Keyword.PUBLIC, Modifier.Keyword.STATIC)
        mainMethod.addParameter("String[]", "args")
        mainMethod.setBody(
            """
                SpringApplication.run(${serviceClass.nameAsString}.class, args);
            """.trimToSingleLine()
        )
        mainMethod.addSerializationCharacteristic(SerializationCharacteristic.DONT_RELOCATE)

        return GenletCodeGenerationHandlerResult(serviceClass)
    }
}