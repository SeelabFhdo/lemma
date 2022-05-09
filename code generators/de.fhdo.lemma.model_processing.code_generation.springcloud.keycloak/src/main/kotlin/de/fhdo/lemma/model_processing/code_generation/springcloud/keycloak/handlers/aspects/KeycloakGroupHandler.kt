package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.handlers.aspects


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
import de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.ast.addStringVariable
import de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.ast.addVariableCheck
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import java.io.File

@CodeGenerationHandler
internal class KeycloakGroupHandler
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
        val fileSet = mutableSetOf(
            generateSpringBypassConfigurationFile(node.getPackageName(), "mTLSBypassConfiguration"),
            generateSpringMtlsConfigurationFile(node.getPackageName(), "MTLSConfiguration")
        )
        return GenletCodeGenerationHandlerResult(node, fileSet)
    }

    private fun generateSpringBypassConfigurationFile(
        packageName: String,
        className: String
    ): GenletGeneratedFileContent {

        val node = newJavaClassOrInterface("${packageName}.${configFolder()}", className, isInterface = false)
        node.addImport(
            "org.springframework.boot.autoconfigure.condition.ConditionalOnExpression",
            ImportTargetElementType.ANNOTATION
        )
        node.addImport("org.springframework.context.annotation.Configuration", ImportTargetElementType.ANNOTATION)
        node.addImport("javax.net.ssl.HttpsURLConnection", ImportTargetElementType.METHOD_BODY)
        node.addAndGetAnnotation("Configuration")
        node.addAndGetAnnotation("ConditionalOnExpression")
            .addPair("value", "\"\${server.ssl.bypass.hostname-verifier:true}\"")

        node.addConstructor(Modifier.Keyword.PUBLIC)
            .body.addStatement("HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);")

        return GenletGeneratedFileContent(
            GenletPathSpecifier.CURRENT_MICROSERVICE_GENERATION_TARGET_PATH,
            "${configFolder()}${File.separator}${node.nameAsString}.java",
            node
        )
    }

    private fun generateSpringMtlsConfigurationFile(
        packageName: String,
        className: String
    ): GenletGeneratedFileContent {

        val node = newJavaClassOrInterface("${packageName}.${configFolder()}", className, isInterface = false)
            .addImplementedType("EnvironmentAware")
        node.addImport("org.springframework.context.EnvironmentAware", ImportTargetElementType.IMPLEMENTED_INTERFACE)
        node.addImport("org.springframework.core.env.Environment", ImportTargetElementType.METHOD_BODY)
        node.addImport("org.springframework.context.annotation.Configuration", ImportTargetElementType.ANNOTATION)
        node.addAndGetAnnotation("Configuration")

        val setEnvironmentMethod = node.addMethod("setEnvironment", Modifier.Keyword.PUBLIC)
            .setType("void")
            .addParameter("Environment", "environment")
            .addAnnotation("Override")

        val blockStmtSetEnvMethod = BlockStmt()
        blockStmtSetEnvMethod.addStatement(addStringVariable("keystoreLocation", "server.ssl.key-store"))
        blockStmtSetEnvMethod.addStatement(addStringVariable("keystorePassword", "server.ssl.key-store-password"))
        blockStmtSetEnvMethod.addStatement(addStringVariable("truststoreLocation", "server.ssl.trust-store"))
        blockStmtSetEnvMethod.addStatement(addStringVariable("truststorePassword", "server.ssl.trust-store-password"))
        blockStmtSetEnvMethod.addStatement(addVariableCheck("keystoreLocation", "server.ssl.key-store"))
        blockStmtSetEnvMethod.addStatement(addVariableCheck("keystorePassword", "server.ssl.key-store-password"))
        blockStmtSetEnvMethod.addStatement(addVariableCheck("truststoreLocation", "server.ssl.trust-store"))
        blockStmtSetEnvMethod.addStatement(addVariableCheck("truststorePassword", "server.ssl.trust-store-password"))
        setEnvironmentMethod.setBody(blockStmtSetEnvMethod)

        return GenletGeneratedFileContent(
            GenletPathSpecifier.CURRENT_MICROSERVICE_GENERATION_TARGET_PATH,
            "${configFolder()}${File.separator}${node.nameAsString}.java",
            node
        )
    }
}

