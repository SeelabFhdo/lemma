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
import java.util.Properties

/**
 * Code generation handler for IntermediateMicroservice instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class MicroserviceHandler
    : VisitingCodeGenerationHandlerI<IntermediateMicroservice, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateMicroservice::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java
    override fun getAspects(eObject: IntermediateMicroservice) = eObject.aspects!!

    private val currentMicroserviceGenerationPackage: String by ServicesState

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateMicroservice, context: Nothing?)
        : Pair<ClassOrInterfaceDeclaration, String?>? {
        /*
         * Each IntermediateMicroservice will be mapped to its own Java class in the current microservice generation
         * package
         */
        val generatedClass = newJavaClassOrInterface(currentMicroserviceGenerationPackage, eObject.classname)

        /*
         * The class is marked with the LemmaMicroservice annotation in order to determine the type of the microservice,
         * i.e., functional, infrastructure, or utility, as specified in the service model
         */
        generatedClass.addDependency("de.fhdo.lemma.msa:de.fhdo.lemma.msa:${getLemmaMsaVersion()}")

        generatedClass.addImport("de.fhdo.lemma.msa.services.LemmaMicroservice", ImportTargetElementType.ANNOTATION,
            SerializationCharacteristic.DONT_RELOCATE)
        generatedClass.addImport("de.fhdo.lemma.msa.services.LemmaMicroserviceType", ImportTargetElementType.ANNOTATION,
            SerializationCharacteristic.DONT_RELOCATE)

        val serviceAnnotation = generatedClass.addAndGetAnnotation(
            "LemmaMicroservice",
            SerializationCharacteristic.DONT_RELOCATE
        )
        serviceAnnotation.addPair("type", "LemmaMicroserviceType.${eObject.type}")

        return generatedClass to eObject.javaFileName
    }

    /**
     * Helper to get the version of the de.fhdo.lemma.msa:de.fhdo.lemma.msa dependency from the Java Base Generator's
     * configuration file
     */
    private fun getLemmaMsaVersion() =
        this::class.java.classLoader.getResourceAsStream("java.base.generator.properties")
            ?.use { Properties().apply { load(it) } }
            ?.getProperty("lemma.msa.version")
            ?: "0.0.1-SNAPSHOT"
}