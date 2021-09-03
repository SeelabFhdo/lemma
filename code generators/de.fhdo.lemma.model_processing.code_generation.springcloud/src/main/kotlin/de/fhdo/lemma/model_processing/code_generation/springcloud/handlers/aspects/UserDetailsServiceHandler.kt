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
 * Handler for the UserDetailsService aspect.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@AspectHandler
internal class UserDetailsServiceHandler : AspectHandlerI {
    override fun handlesAspects() = setOf("java.UserDetailsService", "Spring.UserDetailsService")
    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateDataStructure::class.java with ClassOrInterfaceDeclaration::class.java
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        val generatedClass = node as ClassOrInterfaceDeclaration

        /* Turn generated class into a Spring component and let it implement the UserDetailsService interface */
        generatedClass.addImport("org.springframework.stereotype.Component", ImportTargetElementType.ANNOTATION)
        generatedClass.addMarkerAnnotation("Component")

        generatedClass.addDependency("org.springframework.security:spring-security-core:5.1.6.RELEASE")
        generatedClass.addImport("org.springframework.security.core.userdetails.UserDetailsService",
            ImportTargetElementType.IMPLEMENTED_INTERFACE)
        generatedClass.addImplementedType("UserDetailsService")

        /*
         * Add loadByUsername(String) method required by the UserDetailsService interface or adapt an existing version
         */
        var loadByUsernameMethod = generatedClass.methods.firstOrNull {
            it.nameAsString == "loadUserByUsername" &&
            it.parameters.size == 1 &&
            it.parameters[0].typeAsString == "String"
        }

        // Add non-existing loadByUsername(String)
        if (loadByUsernameMethod == null) {
            loadByUsernameMethod = generatedClass.addMethod("loadUserByUsername", Modifier.Keyword.PUBLIC)
            loadByUsernameMethod.addParameter("String", "username")

            generatedClass.addImport("org.springframework.security.core.userdetails.UserDetails",
                ImportTargetElementType.METHOD)
            loadByUsernameMethod.setType("UserDetails")
        }

        // Add @Override annotation to new or existing loadByUsername(String), because the method is required by the
        // UserDetailsService interface
        if (loadByUsernameMethod!!.isPublic && loadByUsernameMethod.annotations.any { it.nameAsString == "Override" })
            loadByUsernameMethod.addMarkerAnnotation("Override")

        return node
    }
}