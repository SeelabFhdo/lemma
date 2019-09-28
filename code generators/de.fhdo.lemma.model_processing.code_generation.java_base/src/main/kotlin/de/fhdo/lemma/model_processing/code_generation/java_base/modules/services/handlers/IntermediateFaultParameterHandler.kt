package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAllAttributesConstructor
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAttribute
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependencies
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.insertStatement
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setSuperclass
import de.fhdo.lemma.model_processing.code_generation.java_base.buildOperationPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.VisitingCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getTypeMapping
import de.fhdo.lemma.model_processing.utils.packageToPath
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext.State as DomainState
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.ServicesContext.State as ServicesState
import de.fhdo.lemma.service.intermediate.IntermediateParameter
import de.fhdo.lemma.technology.CommunicationType
import java.io.File

@CodeGenerationHandler
class IntermediateFaultParameterHandler
    : VisitingCodeGenerationHandlerI<IntermediateParameter, ClassOrInterfaceDeclaration, Nothing> {
    companion object {
        private val currentDomainPackage: String by DomainState

        fun buildExceptionClassFullyQualifiedName(parameter: IntermediateParameter) : String {
            return "${parameter.buildOperationPackageName()}.${buildExceptionClassName(parameter)}"
        }

        fun buildExceptionClassName(parameter: IntermediateParameter) : String {
            return "${parameter.name.capitalize()}Exception"
        }
    }

    private val interfaceSubFolderName: String by ServicesState

    override fun handlesEObjectsOfInstance() = IntermediateParameter::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java
    override fun getAspects(parameter: IntermediateParameter) = parameter.aspects!!

    override fun execute(parameter: IntermediateParameter, context : Nothing?)
        : Pair<ClassOrInterfaceDeclaration, String?>? {
        if (!parameter.isCommunicatesFault || parameter.communicationType == CommunicationType.ASYNCHRONOUS)
            return null

        val packageName = parameter.buildOperationPackageName()
        val classname = buildExceptionClassName(parameter)
        val generatedClass = newJavaClassOrInterface(packageName, classname)
        generatedClass.setSuperclass("RuntimeException", isExternalSuperclass = true)

        val parameterType = parameter.determineType(generatedClass)
        generatedClass.addAttribute(parameter.name, parameterType, Modifier.Keyword.PROTECTED)

        val errorMessageAttribute = if (parameter.name == "errorMessage")
            "errorMessage2"
        else
            "errorMessage"
        generatedClass.addAttribute(errorMessageAttribute, "String", Modifier.Keyword.PROTECTED)

        if (parameter.isOptional) {
            val parameterlessConstructor = generatedClass.addConstructor(Modifier.Keyword.PUBLIC)
            parameterlessConstructor.setBody("super();")

            if (parameterType != "String") {
                val errorMessageConstructor = generatedClass.addConstructor(Modifier.Keyword.PUBLIC)
                errorMessageConstructor.addParameter("String", errorMessageAttribute)
                errorMessageConstructor.setBody(
                    "super($errorMessageAttribute);",
                    "this.$errorMessageAttribute = $errorMessageAttribute;"
                )
            }
        }

        val parameterConstructor = generatedClass.addConstructor(Modifier.Keyword.PUBLIC)
        parameterConstructor.addParameter(parameterType, parameter.name)
        parameterConstructor.setBody(
            "super();",
            "this.${parameter.name} = ${parameter.name};"
        )

        generatedClass.addAllAttributesConstructor()!!
            .insertStatement("super($errorMessageAttribute);")

        val operationSubFolder = parameter.buildOperationPackageName(subPackageOnly = true).packageToPath()
        val generatedFilePath = listOf(interfaceSubFolderName, operationSubFolder, "$classname.java")
            .joinToString(File.separator)
        return generatedClass to generatedFilePath
    }

    private fun IntermediateParameter.determineType(generatedClass: ClassOrInterfaceDeclaration) : String {
        val typeMapping = type.getTypeMapping()
        return if (typeMapping != null) {
            val (mappedTypeName, isComplexTypeMapping, imports, dependencies) = typeMapping
            imports.forEach { generatedClass.addImport(it, ImportTargetElementType.METHOD) }
            generatedClass.addDependencies(dependencies)

            if (isComplexTypeMapping) {
                val fullyQualifiedClassname = (type as IntermediateComplexType).fullyQualifiedClassname
                val complexTypeFullyQualifiedName = "$currentDomainPackage.$fullyQualifiedClassname"
                generatedClass.addImport(complexTypeFullyQualifiedName, ImportTargetElementType.METHOD)
            }

            mappedTypeName
        } else
            "${type.name}_ExpectedFromGenlet"
    }
}