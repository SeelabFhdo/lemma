package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.handlers.aspects

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedFileContent
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.openPropertyFile
import de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.FileType
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import java.io.File


@CodeGenerationHandler
internal class IntermediateMicroserviceSelfSignedCAHandler
    : GenletCodeGenerationHandlerI<IntermediateMicroservice, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateMicroservice::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java
    private fun handlesAspects() = setOf("mTLS.mtlsdev")

    val TEST_CA = mapOf(
        Pair("server.ssl.bitLength", "4096"),
        Pair("server.ssl.ca-Cert.file", "ca_test_cert.pem"),
        Pair("server.ssl.ca-domain.name", "localhost"),
        Pair("server.ssl.ca-key.file", "ca_test_key_privat.pem"),
        Pair("server.ssl.ca-name", "ca"),
        Pair("server.ssl.certificateStandard", "x509"),
        Pair("server.ssl.cipher", "aes256"),
        Pair("server.ssl.key-store.validityInDays", "365"),
        Pair("server.ssl.server.ca-password", "\${CA_TEST_PASSWORD}"),
        Pair("server.ssl.subject", "ca.localhost")
    )


    override fun execute(
        eObject: IntermediateMicroservice, node: ClassOrInterfaceDeclaration, context: Nothing?
    ): GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration> {
        if (!eObject.hasAspect(*handlesAspects().toTypedArray()))
            return GenletCodeGenerationHandlerResult(node)

        return GenletCodeGenerationHandlerResult(node, generateTestCaConfigFile())
    }

    private fun generateTestCaConfigFile(): MutableSet<GenletGeneratedFileContent> {
        val propertyFiles = mutableSetOf<GenletGeneratedFileContent>()
        val propFile =
            openPropertyFile(
                FileType.filePath(FileType.CA_CERTIFICATE_PROPERTIES),
                setOf(
                    "CertificationAuthority",
                    "certs",
                    "CertificationAuthority-mtlsdev.var"
                ).joinToString(File.separator)
            )
        TEST_CA.filter { it.key in FileType.filter(FileType.CA_CERTIFICATE_PROPERTIES) }.forEach { property ->
            propFile[property.key] = property.value
        }
        propertyFiles.add(GenletGeneratedFileContent(propFile))
        return propertyFiles
    }
}

