package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.handlers

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAllAttributesConstructor
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setSuperclass
import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClasspath
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.VisitingCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.handlers.data_operations.DataOperationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext.State as DomainState
import de.fhdo.lemma.model_processing.code_generation.java_base.eObjectPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.getAspectPropertyValue

/**
 * Code generation handler for IntermediateDataStructure instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class DataStructureHandler
    : VisitingCodeGenerationHandlerI<IntermediateDataStructure, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateDataStructure::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java
    override fun getAspects(eObject: IntermediateDataStructure) = eObject.aspects!!

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateDataStructure, context: Nothing?)
        : Pair<ClassOrInterfaceDeclaration, String?>? {
        /* Each data structure becomes a new Java class in the current domain package with an empty constructor */
        val currentDomainPackage: String by DomainState
        val generatedClass = newJavaClassOrInterface("$currentDomainPackage.${eObject.eObjectPackageName}",
            eObject.classname)
        generatedClass.addConstructor(Modifier.Keyword.PUBLIC)

        /* Set superclass, if any */
        if (eObject.`super` != null) {
            val fullyQualifiedClassname = eObject.`super`.fullyQualifiedClassname
            generatedClass.setSuperclass("$currentDomainPackage.$fullyQualifiedClassname")
        }

        /* Handle data fields */
        eObject.dataFields.forEach { DataFieldHandler.invoke(it, generatedClass) }
        // Add constructor for initializing all data fields
        if (eObject.shallHaveAttributesConstructor()) {
            val attributesConstructorVisibility = eObject.attributesConstructorVisibility()
            generatedClass.addAllAttributesConstructor(attributesConstructorVisibility)
        }

        /* Handle data operations */
        eObject.operations.forEach { DataOperationHandler.invoke(it, generatedClass) }

        return generatedClass to eObject.fullyQualifiedClasspath()
    }

    /**
     * Determine if generated class shall have a constructor for initializing all data fields. By default, this is the
     * case. However, the modeler may deactivate it by means of technology aspects.
     */
    private fun IntermediateDataStructure.shallHaveAttributesConstructor()
        = getAspectPropertyValue("java.constructor", "initializing")?.equals("true") ?: true

    /**
     * Determine visibility of a constructor for initializing all data fields. By default, such constructors are public.
     * However, the modeler may constrain their visibility by means of technology aspects.
     */
    private fun IntermediateDataStructure.attributesConstructorVisibility() : Modifier.Keyword {
        val protectAttributesConstructor = getAspectPropertyValue("java.constructor", "protectInitializing") == "true"
        return if (protectAttributesConstructor)
                Modifier.Keyword.PROTECTED
            else
                Modifier.Keyword.PUBLIC
    }
}