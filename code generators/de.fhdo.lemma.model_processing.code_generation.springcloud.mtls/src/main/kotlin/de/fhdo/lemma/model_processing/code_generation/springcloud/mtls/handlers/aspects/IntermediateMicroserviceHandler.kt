package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.handlers.aspects

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedFileContent
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.openPropertyFile
import de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.Context.State
import de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.FileType
import de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.fixPath
import de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.getAspectValueOrDefault
import de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.springPropertyMapping
import de.fhdo.lemma.model_processing.utils.packageToPath
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import java.io.File

@CodeGenerationHandler
internal class IntermediateMicroserviceHandler
    : GenletCodeGenerationHandlerI<IntermediateMicroservice, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateMicroservice::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java
    private fun handlesAspects() = setOf("mTLS.Mtls", "mTLS.MtlsDev")

    override fun execute(
        eObject: IntermediateMicroservice,
        node: ClassOrInterfaceDeclaration,
        context: Nothing?
    ): GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration> {
        if (!eObject.hasAspect(*handlesAspects().toTypedArray()))
            return GenletCodeGenerationHandlerResult(node)

        State.initialize()

        eObject.aspects.filter { it.qualifiedName in handlesAspects() }.forEach { aspect ->
            val aspectsSet = eObject.getAspectValueOrDefault(aspect.qualifiedName)
            State.addPropertiesToFile(
                "application-${aspect.name}.properties",
                aspectsSet,
                FileType.APPLICATION_PROPERTIES
            )
            State.addPropertiesToFile(
                setOf(
                    eObject.qualifiedName.packageToPath(),
                    "certs",
                    "Certificate-${eObject.qualifiedName}-${aspect.name}.var"
                ).joinToString(File.separator),
                aspectsSet,
                FileType.CLIENT_CERTIFICATE_PROPERTIES
            )
        }

        return GenletCodeGenerationHandlerResult(node, generateSpringBootPropertyFiles())
    }

    private fun generateSpringBootPropertyFiles(): MutableSet<GenletGeneratedFileContent> {
        val propertyFiles = mutableSetOf<GenletGeneratedFileContent>()
        State.getPropertyFiles().forEach { propertyFile ->
            val propFile =
                openPropertyFile(FileType.filePath(propertyFile.value.fileType), propertyFile.key)
            propertyFile.value.propertiesSet.filter { it.first in FileType.filter(propertyFile.value.fileType) }
                .forEach { property ->
                    when (property.first) {
                        "keyStoreRelativePath", "trustStoreRelativePath", "qualifiedName" -> {}
                        "keyStoreFileName", "trustStoreFileName" -> {
                            val applicationName =
                                propertyFile.value.propertiesSet.find { it.first == "qualifiedName" }!!.second
                            propFile[springPropertyMapping(property.first)] =
                                property.second.replace("##applicationName##", applicationName.packageToPath())
                                    .fixPath()
                        }
                        "caDomain" -> {
                            val applicationName =
                                propertyFile.value.propertiesSet.find { it.first == "applicationName" }!!.second
                            propFile[springPropertyMapping("subject")] = "$applicationName.${property.second}"
                        }
                        else -> {
                            propFile[springPropertyMapping(property.first)] = property.second
                        }
                    }
                }
            propertyFiles.add(GenletGeneratedFileContent(propFile))
        }
        return propertyFiles
    }
}

