package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.handlers

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.NodeList
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.Parameter
import com.github.javaparser.ast.expr.Expression
import com.github.javaparser.ast.expr.FieldAccessExpr
import com.github.javaparser.ast.expr.MethodCallExpr
import com.github.javaparser.ast.expr.NameExpr
import com.github.javaparser.ast.expr.StringLiteralExpr
import com.github.javaparser.ast.expr.SuperExpr
import com.github.javaparser.ast.stmt.BlockStmt
import com.github.javaparser.ast.stmt.ExpressionStmt
import com.github.javaparser.ast.stmt.Statement
import com.github.javaparser.ast.type.ClassOrInterfaceType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addStatements
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedFileContent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedNode
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletPathSpecifier
import de.fhdo.lemma.model_processing.code_generation.java_base.getAspectPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.openPropertyFile
import de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.Context
import de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.getAspectValueOrDefault
import de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.model.getPermissions
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.Context.State
import de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.FileType
import de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.springPropertyMapping
import java.io.File

@CodeGenerationHandler
class IntermediateMicroserviceHandler :
    GenletCodeGenerationHandlerI<IntermediateMicroservice, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateMicroservice::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java
    private fun handlesAspects() = listOf("Keycloak.KeycloakClient", "Keycloak.KeycloakPropertiesConfig")
    override fun execute(
        eObject: IntermediateMicroservice, node: ClassOrInterfaceDeclaration, context: Nothing?
    ): GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration> {
        State.initialize(eObject)
        val properties = eObject.getAspectValueOrDefault("Keycloak.KeycloakPropertiesConfig").toMutableSet()
        val clientId =
            eObject.getAspectPropertyValue("Keycloak.KeycloakClient", "clientId")
                ?: eObject.classname.lowercase()
        properties.add("resource" to clientId)
        State.addPropertiesToFile(
            "application-keycloak.properties",
            properties,
            FileType.APPLICATION_PROPERTIES
        )
        return GenletCodeGenerationHandlerResult(node, generateSpringBootPropertyFiles())
    }

    private fun generateSpringBootPropertyFiles(): MutableSet<GenletGeneratedFileContent> {
        val propertyFiles = mutableSetOf<GenletGeneratedFileContent>()
        State.getPropertyFiles().forEach { propertyFile ->
            val propFile =
                openPropertyFile(FileType.filePath(propertyFile.value.fileType), propertyFile.key)
            propertyFile.value.propertiesSet.filter { it.first in FileType.filter(propertyFile.value.fileType) }
                .forEach { property ->
                    propFile[springPropertyMapping(property.first)] = property.second
                }
            propertyFiles.add(GenletGeneratedFileContent(propFile))
        }
        return propertyFiles
    }

    companion object {
        private const val CONFIG_FOLDER = "configuration"
        fun handleMicroserviceGenerationFinished(): Pair<Set<GenletGeneratedNode>, Set<GenletGeneratedFileContent>> {
            val classNameSecurityConfig = "SecurityConfig"
            val classNameKeycloakConfig = "KeycloakConfig"
            val generatedStaticClasses = mutableSetOf<GenletGeneratedFileContent>()

            generatedStaticClasses.add(
                GenletGeneratedFileContent(
                    GenletPathSpecifier.CURRENT_MICROSERVICE_JAVA_ROOT_PATH,
                    setOf(CONFIG_FOLDER, "$classNameSecurityConfig.java").joinToString(File.separator),
                    generateSecurityConfig(classNameSecurityConfig)
                )
            )
            generatedStaticClasses.add(
                GenletGeneratedFileContent(
                    GenletPathSpecifier.CURRENT_MICROSERVICE_JAVA_ROOT_PATH,
                    setOf(CONFIG_FOLDER, "$classNameKeycloakConfig.java").joinToString(File.separator),
                    generateKeycloakConfig(classNameKeycloakConfig)
                )
            )
            return mutableSetOf<GenletGeneratedNode>() to generatedStaticClasses
        }

        private fun generateSecurityConfig(className: String): ClassOrInterfaceDeclaration {
            val node = newJavaClassOrInterface(
                setOf(Context.State.getPackage()!!, CONFIG_FOLDER).joinToString("."), className, isInterface = false
            ).addExtendedType("KeycloakWebSecurityConfigurerAdapter")
            node.removeModifier(Modifier.Keyword.PUBLIC)
            addImports(node)

            node.addMarkerAnnotation("EnableWebSecurity")
            node.addMarkerAnnotation("KeycloakConfiguration")
            node.addAndGetAnnotation("ComponentScan").addPair("basePackageClasses", "KeycloakSecurityComponents.class")

            node.addPublicField("KeycloakClientRequestFactory", "keycloakClientRequestFactory")
            val constructor = node.addConstructor(Modifier.Keyword.PUBLIC)
            constructor.body.addStatement("this.keycloakClientRequestFactory = keycloakClientRequestFactory;")
                .addStatement(
                    "SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);"
                )
            constructor.parameters.add(
                Parameter(
                    ClassOrInterfaceType().setName("KeycloakClientRequestFactory"), "keycloakClientRequestFactory"
                )
            )

            methodKeycloakRestTemplate(node)
            methodConfigureGlobal(node)
            methodSessionAuthenticationStrategy(node)
            methodConfigure(node)

            return node
        }

        private fun methodKeycloakRestTemplate(node: ClassOrInterfaceDeclaration) {
            val method = node.addMethod("keycloakRestTemplate")
            method.addMarkerAnnotation("Bean")
            method.type = ClassOrInterfaceType().setName("KeycloakRestTemplate")
            method.addSingleMemberAnnotation(
                "Scope", FieldAccessExpr(NameExpr("ConfigurableBeanFactory"), "SCOPE_PROTOTYPE")
            )
            method.modifiers.add(Modifier().setKeyword(Modifier.Keyword.PUBLIC))
            method.addStatements("return new KeycloakRestTemplate(keycloakClientRequestFactory);")
        }

        private fun methodConfigureGlobal(node: ClassOrInterfaceDeclaration) {
            val method = node.addMethod("configureGlobal")
            method.addMarkerAnnotation("Autowired")
            method.modifiers.add(Modifier().setKeyword(Modifier.Keyword.PUBLIC))
            method.parameters.add(
                Parameter(
                    ClassOrInterfaceType().setName("AuthenticationManagerBuilder"), "auth"
                )
            )
            method.addThrownException(ClassOrInterfaceType().setName("Exception"))
            method.addStatements(
                "KeycloakAuthenticationProvider keycloakAuthenticationProvider " + "= keycloakAuthenticationProvider();"
            )
            method.addStatements(
                "keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());"
            )
            method.addStatements("auth.authenticationProvider(keycloakAuthenticationProvider);")
        }

        private fun methodSessionAuthenticationStrategy(node: ClassOrInterfaceDeclaration) {
            val method = node.addMethod("sessionAuthenticationStrategy")
            method.type = ClassOrInterfaceType().setName("SessionAuthenticationStrategy")
            method.addMarkerAnnotation("Bean")
            method.addMarkerAnnotation("Override")
            method.modifiers.add(Modifier().setKeyword(Modifier.Keyword.PROTECTED))
            method.addStatements("return new NullAuthenticatedSessionStrategy();")
        }

        private fun methodConfigure(node: ClassOrInterfaceDeclaration) {
            val method = node.addMethod("configure")
            method.parameters.add(
                Parameter(
                    ClassOrInterfaceType().setName("HttpSecurity"), "http"
                )
            )
            method.addMarkerAnnotation("Override")
            method.modifiers.add(Modifier().setKeyword(Modifier.Keyword.PROTECTED))
            method.addThrownException(ClassOrInterfaceType().setName("Exception"))
            val nodeList = NodeList<Statement>()
            val expressionStmt = ExpressionStmt(MethodCallExpr(SuperExpr(), "configure", NodeList(NameExpr("http"))))
            nodeList.add(expressionStmt)

            val methodBeginList = listOf(
                Pair("http", listOf("")),
                Pair("cors", listOf("")),
                Pair("and", listOf("")),
                Pair("csrf", listOf("")),
                Pair("disable", listOf("")),
                Pair("authorizeRequests", listOf("")),
            )
            val methodPermissionList = mutableListOf<Pair<String, List<String>>>()

            Context.State.getInterfaces().forEach {
                methodPermissionList.addAll(it.getPermissions())
            }

            val methodEndList = listOf(
                Pair("anyRequest", listOf("")),
                Pair("permitAll", listOf("")),
            )
            nodeList.add(
                ExpressionStmt(
                    recursiveConfigureStatement((methodBeginList + methodPermissionList + methodEndList).asReversed())
                )
            )
            method.setBody(BlockStmt(nodeList))
        }

        private fun recursiveConfigureStatement(functionList: List<Pair<String, List<String>>>): MethodCallExpr {
            val arguments = if (functionList[0].second.isEmpty() || functionList[0].second.first().isEmpty()) NodeList()
            else {
                val list = mutableListOf<Expression>()
                functionList[0].second.forEach {
                    list.add(StringLiteralExpr(it) as Expression)
                }
                NodeList(list)
            }

            if (functionList.size == 2) {
                return createMethodCallExpr(NameExpr(functionList[1].first), functionList[0].first, arguments)
            }
            return createMethodCallExpr(
                recursiveConfigureStatement(functionList.subList(1, functionList.size)),
                functionList[0].first,
                arguments
            )
        }

        private fun createMethodCallExpr(scope: Expression, name: String, arguments: NodeList<Expression>?) =
            if (arguments.isNullOrEmpty()) MethodCallExpr(scope, name)
            else MethodCallExpr(scope, name, arguments)


        private fun addImports(node: ClassOrInterfaceDeclaration) {
            node.addImport(
                "org.keycloak.adapters.springsecurity.KeycloakConfiguration", ImportTargetElementType.ANNOTATION
            )
            node.addImport(
                "org.keycloak.adapters.springsecurity.KeycloakSecurityComponents",
                ImportTargetElementType.IMPLEMENTED_INTERFACE
            )
            node.addImport(
                "org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider",
                ImportTargetElementType.ATTRIBUTE_TYPE
            )
            node.addImport(
                "org.keycloak.adapters.springsecurity.client.KeycloakClientRequestFactory",
                ImportTargetElementType.ATTRIBUTE_TYPE
            )
            node.addImport(
                "org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate",
                ImportTargetElementType.ATTRIBUTE_TYPE
            )
            node.addImport(
                "org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter",
                ImportTargetElementType.SUPER
            )
            node.addImport("org.springframework.beans.factory.annotation.Autowired", ImportTargetElementType.ANNOTATION)
            node.addImport(
                "org.springframework.beans.factory.config.ConfigurableBeanFactory",
                ImportTargetElementType.IMPLEMENTED_INTERFACE
            )
            node.addImport("org.springframework.context.annotation.Bean", ImportTargetElementType.ANNOTATION)
            node.addImport("org.springframework.context.annotation.ComponentScan", ImportTargetElementType.ANNOTATION)
            node.addImport("org.springframework.context.annotation.Scope", ImportTargetElementType.ANNOTATION)
            node.addImport(
                "org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder",
                ImportTargetElementType.ATTRIBUTE_TYPE
            )
            node.addImport(
                "org.springframework.security.config.annotation.web.builders.HttpSecurity",
                ImportTargetElementType.ATTRIBUTE_TYPE
            )
            node.addImport(
                "org.springframework.security.config.annotation.web.configuration.EnableWebSecurity",
                ImportTargetElementType.ANNOTATION
            )
            node.addImport(
                "org.springframework.security.core.authority.mapping.SimpleAuthorityMapper",
                ImportTargetElementType.ATTRIBUTE_TYPE
            )
            node.addImport(
                "org.springframework.security.core.context.SecurityContextHolder",
                ImportTargetElementType.ATTRIBUTE_TYPE
            )
            node.addImport(
                "org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy",
                ImportTargetElementType.ATTRIBUTE_TYPE
            )
            node.addImport(
                "org.springframework.security.web.authentication.session.SessionAuthenticationStrategy",
                ImportTargetElementType.METHOD
            )
        }

        private fun generateKeycloakConfig(className: String): ClassOrInterfaceDeclaration {

            val node = newJavaClassOrInterface(
                setOf(Context.State.getPackage()!!, CONFIG_FOLDER).joinToString("."), className, isInterface = false
            )
            node.addImport(
                "org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver", ImportTargetElementType.METHOD
            )
            node.addImport("org.springframework.context.annotation.Bean", ImportTargetElementType.ANNOTATION)
            node.addImport("org.springframework.context.annotation.Configuration", ImportTargetElementType.ANNOTATION)

            node.addMarkerAnnotation("Configuration")

            val method = node.addMethod("keycloakConfigResolver")
            method.type = ClassOrInterfaceType().setName("KeycloakSpringBootConfigResolver")

            method.addMarkerAnnotation("Bean")
            method.modifiers.add(Modifier().setKeyword(Modifier.Keyword.PROTECTED))
            method.addStatements("return new KeycloakSpringBootConfigResolver();")

            return node
        }
    }
}
