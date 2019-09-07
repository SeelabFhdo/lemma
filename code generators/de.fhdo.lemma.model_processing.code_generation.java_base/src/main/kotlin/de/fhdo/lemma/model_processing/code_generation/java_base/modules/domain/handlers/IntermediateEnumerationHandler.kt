package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.handlers

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.EnumDeclaration
import com.github.javaparser.ast.body.Parameter
import de.fhdo.lemma.data.intermediate.IntermediateEnumeration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newEnum
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClasspath
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.VisitingCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.createTypeSpecificValueString
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext
import de.fhdo.lemma.model_processing.code_generation.java_base.packageName

@CodeGenerationHandler
internal class IntermediateEnumerationHandler
    : VisitingCodeGenerationHandlerI<IntermediateEnumeration, EnumDeclaration, Nothing> {
    companion object {
        private const val VALUE_ATTRIBUTE_NAME = "value";
    }

    private val currentDomainPackage: String by DomainContext.State

    override fun handlesEObjectsOfInstance() = IntermediateEnumeration::class.java
    override fun generatesNodesOfInstance() = EnumDeclaration::class.java
    override fun getAspects(enumeration: IntermediateEnumeration) = enumeration.aspects!!

    override fun execute(enumeration: IntermediateEnumeration, context : Nothing?) : Pair<EnumDeclaration, String?>? {
        val packageName = "$currentDomainPackage.${enumeration.packageName}"
        val generatedEnum = newEnum(packageName, enumeration.name)

        var initializationValueFound = false
        enumeration.fields.forEach { field ->
            val enumConstant = generatedEnum.addEnumConstant(field.name)
            if (field.initializationValue != null) {
                initializationValueFound = true
                val compatibleType = field.initializationValueCompatibleTypes.sortedBy { it.size }[0]
                val (typeSpecificValueString, additionalImports)
                    = compatibleType.createTypeSpecificValueString(field.initializationValue)
                enumConstant.addArgument(typeSpecificValueString)
                additionalImports.forEach { generatedEnum.addImport(it, ImportTargetElementType.ATTRIBUTE) }
            }
        }

        if (initializationValueFound) {
            generatedEnum.addPrivateField("Object", VALUE_ATTRIBUTE_NAME)
            generatedEnum.addConstructor()
            generatedEnum.addValueConstructor(VALUE_ATTRIBUTE_NAME)
            generatedEnum.addRawValueGetter(VALUE_ATTRIBUTE_NAME)
            generatedEnum.addTypedValueGetter(VALUE_ATTRIBUTE_NAME)
        }

        return generatedEnum to enumeration.fullyQualifiedClasspath()
    }

    private fun EnumDeclaration.addValueConstructor(valueFieldName: String) {
        val valueConstructor = addConstructor()
        val valueConstructorParameter = Parameter()
        valueConstructorParameter.setType("Object")
        valueConstructorParameter.setName(valueFieldName)
        valueConstructor.addParameter(valueConstructorParameter)
        valueConstructor.setBody("this.$valueFieldName = $valueFieldName;")
    }

    private fun EnumDeclaration.addRawValueGetter(valueFieldName: String) {
        val rawValueGetter = addMethod("rawValue", Modifier.Keyword.PUBLIC)
        rawValueGetter.setType("Object")
        rawValueGetter.setBody("return $valueFieldName;")
    }

    private fun EnumDeclaration.addTypedValueGetter(valueFieldName: String) {
        val rawValueGetter = addMethod("value", Modifier.Keyword.PUBLIC)
        rawValueGetter.addTypeParameter("T")
        rawValueGetter.setType("T")
        rawValueGetter.setBody("return (T) $valueFieldName;")
    }
}