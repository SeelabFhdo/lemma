package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.handlers.aspects


import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.stmt.BlockStmt
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedFileContent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletPathSpecifier
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.openPropertyFile
import de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.Context.State
import de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.ast.addStringVariable
import de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.ast.addVariableCheck
import de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.getAspectValueOrDefault
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import java.io.File

@CodeGenerationHandler
internal class MtlsPropertiesHandler
    : GenletCodeGenerationHandlerI<IntermediateMicroservice, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateMicroservice::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java
    private fun handlesAspects() = setOf("mTLS.mtls", "mTLS.mtlsdev")
    private fun configFolder() = "configuration"

    override fun execute(
        eObject: IntermediateMicroservice,
        node: ClassOrInterfaceDeclaration,
        context: Nothing?
    ): GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration> {
        if (!eObject.hasAspect(*handlesAspects().toTypedArray()))
            return GenletCodeGenerationHandlerResult(node)

        eObject.aspects.filter { it.qualifiedName in handlesAspects() }.forEach { aspect ->
            State.addPropertiesToFile(
                "application-${aspect.name}.properties",
                eObject.getAspectValueOrDefault(aspect.qualifiedName)
            )
        }
        return GenletCodeGenerationHandlerResult(node, generateSpringBootPropertyFiles())
    }

    private fun generateSpringBootPropertyFiles(): MutableSet<GenletGeneratedFileContent> {
        val propertyFiles = mutableSetOf<GenletGeneratedFileContent>()
        State.getPropertyFiles().forEach { propertyFile ->
            println("Filename: ${propertyFile.key}")
            val propFile =
                openPropertyFile(GenletPathSpecifier.CURRENT_MICROSERVICE_RESOURCES_PATH, propertyFile.key)
            propertyFile.value.forEach { property ->
                propFile[property.first] = property.second
            }
            propertyFiles.add(GenletGeneratedFileContent(propFile))
        }
        return propertyFiles
    }
}

