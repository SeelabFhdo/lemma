package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.handlers.aspects

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
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedFileContent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletPathSpecifier
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import java.io.File

@CodeGenerationHandler
internal class KeycloakClientHandler
    : GenletCodeGenerationHandlerI<IntermediateMicroservice, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateMicroservice::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java

    private fun handlesAspects() = setOf("keycloakClient")

    override fun execute(
        eObject: IntermediateMicroservice,
        node: ClassOrInterfaceDeclaration,
        context: Nothing?
    ): GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration> {
//        if (!eObject.hasAspect(*handlesAspects().toTypedArray()))
//            return GenletCodeGenerationHandlerResult(node)
        val fileSet = mutableSetOf<GenletGeneratedFileContent>()
        fileSet.add(generateSecurityConfig())
        return GenletCodeGenerationHandlerResult(node, fileSet)
    }
}

fun generateSecurityConfig(): GenletGeneratedFileContent {
    val className = "SecurityConfig"
    val path = "path"
    val packageName = "package.name"
    val configFolder = "configFolder"

    val node =
        newJavaClassOrInterface(
            "${packageName}.${configFolder}",
            className,
            isInterface = false
        ).addExtendedType("KeycloakWebSecurityConfigurerAdapter")

    addImports(node)

    node.addMarkerAnnotation("EnableWebSecurity")
    node.addMarkerAnnotation("KeycloakConfiguration")
    node.addAndGetAnnotation("ComponentScan").addPair("basePackageClasses", "KeycloakSecurityComponents.class")

    node.addPublicField("KeycloakClientRequestFactory", "keycloakClientRequestFactory")
    node.addConstructor(Modifier.Keyword.PUBLIC).body
        .addStatement("this.keycloakClientRequestFactory = keycloakClientRequestFactory;")
        .addStatement("SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);")

    methodKeycloakRestTemplate(node)
    methodConfigureGlobal(node)
    methodSessionAuthenticationStrategy(node)
    methodConfigure(node)

    return GenletGeneratedFileContent(
        GenletPathSpecifier.CURRENT_MICROSERVICE_GENERATION_TARGET_PATH,
        setOf(path, "$className.java").joinToString(File.separator),
        node
    )
}

private fun methodKeycloakRestTemplate(node: ClassOrInterfaceDeclaration) {
    val method = node.addMethod("keycloakRestTemplate")
    method.addMarkerAnnotation("Bean")
    method.type = ClassOrInterfaceType().setName("KeycloakRestTemplate")
    method.addSingleMemberAnnotation(
        "Scope",
        FieldAccessExpr(NameExpr("ConfigurableBeanFactory"), "SCOPE_PROTOTYPE")
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
            ClassOrInterfaceType().setName("AuthenticationManagerBuilder"),
            "auth"
        )
    )
    method.addThrownException(ClassOrInterfaceType().setName("Exception"))
    method.addStatements("KeycloakAuthenticationProvider keycloakAuthenticationProvider " +
            "= keycloakAuthenticationProvider();")
    method.addStatements("keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());")
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
            ClassOrInterfaceType().setName("HttpSecurity"),
            "http"
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
    // todo get permission from Context.State
    val methodPermissionList = listOf(
        Pair("antMatchers", listOf("/api/boy*")),
        Pair("hasRole", listOf("user")),
        Pair("antMatchers", listOf("/api/admin*")),
        Pair("hasRole", listOf("admin")),
        Pair("antMatchers", listOf("/api/test*")),
        Pair("hasAnyRole", listOf("admin", "user")),
    )
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
    val arguments =
        if (functionList[0].second.first().isEmpty()) NodeList()
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
    if (arguments.isNullOrEmpty())
        MethodCallExpr(scope, name)
    else
        MethodCallExpr(scope, name, arguments)


private fun addImports(node: ClassOrInterfaceDeclaration) {
    node.addImport("org.keycloak.adapters.springsecurity.KeycloakConfiguration", ImportTargetElementType.ANNOTATION)
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