package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.handlers

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.Parameter
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAllAttributesConstructor
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setSuperclass
import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClasspath
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.VisitingCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext.State as DomainState
import de.fhdo.lemma.model_processing.code_generation.java_base.packageName

@CodeGenerationHandler
internal class IntermediateDataStructureHandler
    : VisitingCodeGenerationHandlerI<IntermediateDataStructure, ClassOrInterfaceDeclaration, Nothing> {
    private val currentDomainPackage: String by DomainState

    override fun handlesEObjectsOfInstance() = IntermediateDataStructure::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java
    override fun getAspects(structure: IntermediateDataStructure) = structure.aspects!!

    override fun execute(structure: IntermediateDataStructure, context: Nothing?)
        : Pair<ClassOrInterfaceDeclaration, String?>? {
        val packageName = "$currentDomainPackage.${structure.packageName}"

        val generatedClass = newJavaClassOrInterface(packageName, structure.classname)
        if (structure.`super` != null) {
            val fullyQualifiedClassname = structure.`super`.fullyQualifiedClassname
            generatedClass.setSuperclass("$currentDomainPackage.$fullyQualifiedClassname")
        }

        structure.dataFields.forEach { CalledIntermediateDataFieldHandler.invoke(it, generatedClass) }
        structure.operations.forEach { CalledIntermediateDataOperationHandler.invoke(it, generatedClass) }

        generatedClass.addConstructor(Modifier.Keyword.PUBLIC)
        generatedClass.addAllAttributesConstructor()

        return generatedClass to structure.fullyQualifiedClasspath()
    }
}