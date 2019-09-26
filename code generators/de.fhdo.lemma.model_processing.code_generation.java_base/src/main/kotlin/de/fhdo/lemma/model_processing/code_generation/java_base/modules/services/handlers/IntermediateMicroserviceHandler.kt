package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAndGetAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependency
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.VisitingCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.ServicesContext.State as ServicesState
import de.fhdo.lemma.model_processing.code_generation.java_base.javaFileName
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice

@CodeGenerationHandler
internal class IntermediateMicroserviceHandler
    : VisitingCodeGenerationHandlerI<IntermediateMicroservice, ClassOrInterfaceDeclaration, Nothing> {
    private val currentMicroserviceGenerationPackage: String by ServicesState

    override fun handlesEObjectsOfInstance() = IntermediateMicroservice::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java
    override fun getAspects(microservice: IntermediateMicroservice) = microservice.aspects!!

    override fun execute(microservice: IntermediateMicroservice, context: Nothing?)
        : Pair<ClassOrInterfaceDeclaration, String?>? {
        val generatedClass = newJavaClassOrInterface(currentMicroserviceGenerationPackage, microservice.classname)

        generatedClass.addDependency("de.fhdo.lemma.msa:de.fhdo.lemma.msa:0.0.1-SNAPSHOT")
        generatedClass.addImport("de.fhdo.lemma.msa.services.LemmaMicroservice", ImportTargetElementType.ANNOTATION,
            SerializationCharacteristic.DONT_RELOCATE)
        generatedClass.addImport("de.fhdo.lemma.msa.services.LemmaMicroserviceType", ImportTargetElementType.ANNOTATION,
            SerializationCharacteristic.DONT_RELOCATE)
        val serviceAnnotation = generatedClass.addAndGetAnnotation("LemmaMicroservice",
            SerializationCharacteristic.DONT_RELOCATE)
        serviceAnnotation.addPair("type", "LemmaMicroserviceType.${microservice.type.name}")

        return generatedClass to microservice.javaFileName
    }
}