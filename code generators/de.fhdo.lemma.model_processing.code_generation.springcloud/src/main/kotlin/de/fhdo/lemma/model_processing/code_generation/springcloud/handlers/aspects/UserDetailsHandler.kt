package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.java.ast.utils.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.addDependency
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import org.eclipse.emf.ecore.EObject

/**
 * Handler for the UserDetails aspect.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@AspectHandler
internal class UserDetailsHandler : AspectHandlerI {
    override fun handlesAspects() = setOf("java.UserDetails", "Spring.UserDetails")
    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateDataStructure::class.java with ClassOrInterfaceDeclaration::class.java
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        val generatedClass = node as ClassOrInterfaceDeclaration
        generatedClass.addDependency("org.springframework.security:spring-security-core:5.1.6.RELEASE")
        generatedClass.addImport("org.springframework.security.core.userdetails.UserDetails",
            ImportTargetElementType.IMPLEMENTED_INTERFACE)
        generatedClass.addImplementedType("UserDetails")

        generatedClass.addOverriddenMethodIfNotExists("getAuthorities", "Collection<? extends GrantedAuthority>",
            "java.util.Collection", "org.springframework.security.core.GrantedAuthority")
        generatedClass.addOverriddenMethodIfNotExists("getPassword", "String")
        generatedClass.addOverriddenMethodIfNotExists("getUsername", "String")
        generatedClass.addOverriddenMethodIfNotExists("isAccountNonExpired", "boolean")
        generatedClass.addOverriddenMethodIfNotExists("isAccountNonLocked", "boolean")
        generatedClass.addOverriddenMethodIfNotExists("isCredentialsNonExpired", "boolean")
        generatedClass.addOverriddenMethodIfNotExists("isEnabled", "boolean")

        return node
    }

    /**
     * Helper to add an overridden method with the given [name] and return [type] to this [ClassOrInterfaceDeclaration]
     * if it does not yet exist.
     */
    private fun ClassOrInterfaceDeclaration.addOverriddenMethodIfNotExists(name: String, type: String,
        vararg imports: String) {
        if (name in methods.map { it.nameAsString })
            return

        val method = addMethod(name, Modifier.Keyword.PUBLIC)
        method.setType(type)
        method.addMarkerAnnotation("Override")
        imports.forEach { method.addImport(it, ImportTargetElementType.METHOD) }
    }
}