package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.handlers

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClass
import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClasspath
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.VisitingCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext
import de.fhdo.lemma.model_processing.code_generation.java_base.packageName

@CodeGenerationHandler
internal class IntermediateDataStructureHandler
    : VisitingCodeGenerationHandlerI<IntermediateDataStructure, ClassOrInterfaceDeclaration, Nothing> {
    private val currentDomainPackage: String by DomainContext.State

    override fun handlesEObjectsOfInstance() = IntermediateDataStructure::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java
    override fun getAspects(structure : IntermediateDataStructure) = structure.aspects!!

    private lateinit var generatedClass: ClassOrInterfaceDeclaration

    override fun execute(structure : IntermediateDataStructure, context : Nothing?)
        : Pair<ClassOrInterfaceDeclaration, String?>? {
        val packageName = "$currentDomainPackage.${structure.packageName}"

        generatedClass = newJavaClass(packageName, structure.classname)
        structure.dataFields.forEach { CalledIntermediateDataFieldHandler.invoke(it, generatedClass) }
        return generatedClass to structure.fullyQualifiedClasspath()
    }
}