package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.handlers

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.FieldDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependencies
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addGetter
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addGetterForInheritedAttribute
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addPrivateAttribute
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSetter
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.insertStatement
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setInitializationValue
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasFeature
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.createTypeSpecificValueString
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getTypeMapping
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.isNullable
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext.State as DomainState
import de.fhdo.lemma.model_processing.utils.trimToSingleLine

@CodeGenerationHandler
internal class CalledIntermediateDataFieldHandler :
    CallableCodeGenerationHandlerI<IntermediateDataField, FieldDeclaration, ClassOrInterfaceDeclaration> {
    private val currentDomainPackage: String by DomainState

    override fun handlesEObjectsOfInstance() = IntermediateDataField::class.java
    override fun generatesNodesOfInstance() = FieldDeclaration::class.java
    override fun getAspects(field: IntermediateDataField) = field.aspects!!

    companion object {
        fun invoke(field: IntermediateDataField, parentClass: ClassOrInterfaceDeclaration)
            = CalledIntermediateDataFieldHandler().invoke(field, parentClass)
    }

    override fun execute(field: IntermediateDataField, parentClass: ClassOrInterfaceDeclaration?)
        : Pair<FieldDeclaration, String?>? {
        var generatedAttribute: FieldDeclaration? = null

        if (!field.isInherited)
            generatedAttribute = field.generateJavaAttribute(parentClass!!)
        else if (field.visibilitySubsequentlyConstrained)
            field.generateNotImplementedGetter(parentClass!!)

        return if (generatedAttribute != null)
                generatedAttribute to null
            else
                null
    }

    private fun IntermediateDataField.generateJavaAttribute(parentClass: ClassOrInterfaceDeclaration)
        : FieldDeclaration? {
        val typeMapping = type.getTypeMapping()
        val generatedAttribute = if (typeMapping != null) {
            val (mappedTypeName, isComplexTypeMapping, imports, dependencies) = typeMapping
            val attribute = parentClass.addPrivateAttribute(name, mappedTypeName)
            imports.forEach { attribute.addImport(it, ImportTargetElementType.ATTRIBUTE_TYPE) }
            parentClass.addDependencies(dependencies)

            val getterMethod = if (needsGetter) {
                    val (getterName, getterMethod) = parentClass.addGetter(attribute)
                    imports.forEach { getterMethod.addImport(it, ImportTargetElementType.METHOD) }
                    if (hasFeature("NEVER_EMPTY") && type.isNullable)
                        addNeverEmptyCheckToGetter(getterName, getterMethod)
                    getterMethod
                } else
                    null

            val setterMethod = if (needsSetter) {
                    val (setterName, setterMethod) = parentClass.addSetter(attribute)
                    if (hasFeature("NEVER_EMPTY") && type.isNullable)
                        addNeverEmptyCheckToSetter(setterName, setterMethod)
                    imports.forEach { setterMethod.addImport(it, ImportTargetElementType.METHOD) }
                    setterMethod
                } else
                    null

            if (isComplexTypeMapping) {
                val fullyQualifiedClassname = (type as IntermediateComplexType).fullyQualifiedClassname
                val complexTypeFullyQualifiedName = "$currentDomainPackage.$fullyQualifiedClassname"
                attribute.addImport(complexTypeFullyQualifiedName, ImportTargetElementType.ATTRIBUTE_TYPE)

                // Add them for copy purposes, e.g., by code generation serializers for Extended Generation Gap Pattern
                getterMethod?.addImport(complexTypeFullyQualifiedName, ImportTargetElementType.METHOD)
                setterMethod?.addImport(complexTypeFullyQualifiedName, ImportTargetElementType.METHOD)
            }

            attribute
        } else
            parentClass.addPrivateAttribute(name, "${type.name}_ExpectedFromGenlet")

        if (willBeFinal)
            generatedAttribute.addModifier(Modifier.Keyword.FINAL)

        if (initializationValue != null) {
            val (typeSpecificInitializationValue, additionalImports)
                = type.createTypeSpecificValueString(initializationValue)
            generatedAttribute.setInitializationValue(typeSpecificInitializationValue)
            additionalImports.forEach { generatedAttribute.addImport(it, ImportTargetElementType.ATTRIBUTE) }
        }

        return generatedAttribute
    }

    private fun IntermediateDataField.generateNotImplementedGetter(parentClass: ClassOrInterfaceDeclaration) {
        val (typeName, _) = type.getTypeMapping()!!
        val getter = parentClass.addGetterForInheritedAttribute(name, typeName)
        getter.addAnnotation("Override")
        getter.setBody(
            """
                throw new UnsupportedOperationException(
                    "The method \"${getter.nameAsString}\" is not visible on this type"
            );
            """.trimToSingleLine()
        )
    }

    private fun addNeverEmptyCheckToGetter(fieldName: String, method: MethodDeclaration) {
        method.insertStatement(
            """
            if ($fieldName == null)
                throw new IllegalStateException("Never empty field $fieldName has not been initialized yet");
            """.trimIndent()
        )
    }

    private fun addNeverEmptyCheckToSetter(fieldName: String, method: MethodDeclaration) {
        method.insertStatement(
            """
            if ($fieldName == null)
                throw new IllegalArgumentException("Field $fieldName cannot be empty");
            """.trimIndent()
        )
    }

    private val IntermediateDataField.visibilitySubsequentlyConstrained get() = isInherited && isHidden
    private val IntermediateDataField.needsGetter get() = !isHidden
    private val IntermediateDataField.needsSetter get() = !isImmutable && !isHidden
    private val IntermediateDataField.willBeFinal get() = isImmutable && initializationValue != null
}