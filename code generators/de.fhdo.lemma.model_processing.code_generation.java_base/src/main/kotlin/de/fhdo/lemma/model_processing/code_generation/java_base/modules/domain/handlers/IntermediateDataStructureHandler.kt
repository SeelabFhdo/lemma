package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.handlers

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.Parameter
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setSuperclass
import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
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
    override fun getAspects(structure: IntermediateDataStructure) = structure.aspects!!

    private lateinit var generatedClass: ClassOrInterfaceDeclaration

    override fun execute(structure: IntermediateDataStructure, context: Nothing?)
        : Pair<ClassOrInterfaceDeclaration, String?>? {
        val packageName = "$currentDomainPackage.${structure.packageName}"

        generatedClass = newJavaClassOrInterface(packageName, structure.classname)
        if (structure.`super` !== null) {
            val fullyQualifiedClassname = structure.`super`.fullyQualifiedClassname
            generatedClass.setSuperclass("$currentDomainPackage.$fullyQualifiedClassname")
        }

        structure.dataFields.forEach { CalledIntermediateDataFieldHandler.invoke(it, generatedClass) }
        structure.operations.forEach { CalledIntermediateDataOperationHandler.invoke(it, generatedClass) }
        generatedClass.generateConstructors()
        return generatedClass to structure.fullyQualifiedClasspath()
    }

    private fun ClassOrInterfaceDeclaration.generateConstructors() {
        addConstructor(Modifier.Keyword.PUBLIC)

        if (fields.isEmpty())
            return

        val allFieldsConstructor = addConstructor(Modifier.Keyword.PUBLIC)
        val allFieldsConstructorBody = mutableListOf<String>()
        fields.map { it.variables[0] }.forEach {
            val parameter = Parameter()
            parameter.setType(it.typeAsString)
            parameter.setName(it.nameAsString)
            allFieldsConstructor.addParameter(parameter)
            allFieldsConstructorBody.add("""this.${it.nameAsString} = ${it.nameAsString};""")
        }
        allFieldsConstructor.setBody(*allFieldsConstructorBody.toTypedArray())
    }
}