package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.handlers

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.FieldDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.DateUtils
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependencies
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addGetter
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addGetterForInheritedAttribute
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImports
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addPrivateAttribute
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSetter
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.insertStatement
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setInitializationValue
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.hasFeature
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getTypeMapping
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.isA
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.isNullable
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext
import de.fhdo.lemma.model_processing.utils.trimToSingleLine
import java.lang.IllegalArgumentException
import java.time.format.DateTimeFormatter

@CodeGenerationHandler
internal class CalledIntermediateDataFieldHandler :
    CallableCodeGenerationHandlerI<IntermediateDataField, FieldDeclaration, ClassOrInterfaceDeclaration> {
    private val currentDomainPackage: String by DomainContext.State

    override fun handlesEObjectsOfInstance() = IntermediateDataField::class.java
    override fun generatesNodesOfInstance() = FieldDeclaration::class.java
    override fun getAspects(field : IntermediateDataField) = field.aspects

    companion object {
        fun invoke(field: IntermediateDataField, parentClass: ClassOrInterfaceDeclaration)
            = CalledIntermediateDataFieldHandler().invoke(field, parentClass)
    }

    override fun execute(field: IntermediateDataField, parentClass: ClassOrInterfaceDeclaration?)
        : Pair<FieldDeclaration, String?>? {
        var generatedAttribute: FieldDeclaration? = null

        if (field.dataStructure !== null) {
            if (!field.visibilitySubsequentlyConstrained)
                generatedAttribute = field.generateJavaAttribute(parentClass!!)
            else
                field.generateNotImplementedGetter(parentClass!!)
        }

        return if (generatedAttribute !== null)
                generatedAttribute to null
            else
                null
    }

    private fun IntermediateDataField.generateJavaAttribute(parentClass: ClassOrInterfaceDeclaration)
        : FieldDeclaration? {
        val (typeName, isComplexTypeMapping, imports, dependencies) = this.type.getTypeMapping() ?: return null

        parentClass.addImports(imports)
        if (isComplexTypeMapping) {
            val fullyQualifiedClassname = (this.type as IntermediateComplexType).fullyQualifiedClassname
            parentClass.addImport("$currentDomainPackage.$fullyQualifiedClassname")
        }

        parentClass.addDependencies(dependencies)

        val generatedAttribute = parentClass.addPrivateAttribute(name, typeName)

        if (hasFeature("IDENTIFIER") && dataStructure.hasAspect("Table")) {
            parentClass.addImport("javax.persistence.Id")
            generatedAttribute.addAnnotation("Id")
        }

        if (needsGetter) {
            val getter = parentClass.addGetter(generatedAttribute)
            if (hasFeature("NEVER_EMPTY") && type.isNullable)
                addNeverEmptyCheckToGetter(getter)
        }

        if (needsSetter) {
            val setter = parentClass.addSetter(generatedAttribute)
            if (hasFeature("NEVER_EMPTY") && type.isNullable)
                addNeverEmptyCheckToSetter(setter)
        }

        if (willBeFinal)
            generatedAttribute.addModifier(Modifier.Keyword.FINAL)

        if (initializationValue !== null) {
            val (typeSpecificInitializationValue, additionalImports) = getTypeSpecificInitializationValueString()
            generatedAttribute.setInitializationValue(typeSpecificInitializationValue)
            parentClass.addImports(additionalImports)
        }

        return generatedAttribute
    }

    private fun IntermediateDataField.generateNotImplementedGetter(parentClass: ClassOrInterfaceDeclaration) {
        val (typeName, _) = this.type.getTypeMapping()!!
        val getter = parentClass.addGetterForInheritedAttribute(this.name, typeName)
        getter.addAnnotation("Override")
        getter.setBody(
            """
            throw new UnsupportedOperationException(
                "The method ${getter.nameAsString}" is not visible on this type
            );
            """.trimToSingleLine())
    }

    private fun addNeverEmptyCheckToGetter(getter: Pair<String, MethodDeclaration>) {
        val (fieldName, method) = getter
        method.insertStatement(
            """
            if ($fieldName == null)
                throw new IllegalStateException("Never empty field $fieldName has not been initialized yet");
            """.trimIndent()
        )
    }

    private fun addNeverEmptyCheckToSetter(setter: Pair<String, MethodDeclaration>) {
        val (fieldName, method) = setter
        method.insertStatement(
            """
            if ($fieldName == null)
                throw new IllegalArgumentException("Field $fieldName cannot be empty");
            """.trimIndent()
        )
    }

    private fun IntermediateDataField.getTypeSpecificInitializationValueString() : Pair<String, Set<String>> {
        if (initializationValue === null)
            return "" to emptySet()

        var valueString = ""
        val additionalImports = mutableSetOf<String>()

        when {
            type.isA("Character") -> valueString += "'"
            type.isA("String") -> valueString += '"'
        }

        if (!type.isA("Date"))
            valueString += initializationValue
        else {
            val (dateValueString, dateImports) = deriveInitializationValueForDate(initializationValue)
            valueString += dateValueString
            additionalImports.addAll(dateImports)
        }

        when {
            type.isA("Character") -> valueString += "'"
            type.isA("Float") -> valueString += "F"
            type.isA("Long") -> valueString += "L"
            type.isA("String") -> valueString += '"'
        }

        return valueString to additionalImports
    }

    private fun deriveInitializationValueForDate(dateString: String) : Pair<String, Set<String>> {
        val format = DateUtils.determineDateFormat(dateString)
        require(format !== null) {
            "Cannot derive initialization value for date string $dateString. Unsupported date format."
        }

        return when (format) {
            DateTimeFormatter.ISO_LOCAL_DATE -> {
                """ 
                    Date.from(LocalDate.parse("$dateString", DateTimeFormatter.ISO_LOCAL_DATE)
                        .atStartOfDay(ZoneId.systemDefault()).toInstant())
                """.trimToSingleLine() to setOf(
                    "java.time.format.DateTimeFormatter",
                    "java.time.LocalDate",
                    "java.time.ZoneId"
                )
            }

            DateTimeFormatter.ISO_OFFSET_DATE -> {
                """ 
                    Date.from(LocalDate.parse("$dateString", DateTimeFormatter.ISO_OFFSET_DATE)
                        .atStartOfDay(ZoneId.systemDefault()).toInstant())
                """.trimToSingleLine() to setOf(
                    "java.time.format.DateTimeFormatter",
                    "java.time.LocalDate",
                    "java.time.ZoneId"
                )
            }

            DateTimeFormatter.ISO_DATE -> {
                """ 
                    Date.from(LocalDate.parse("$dateString", DateTimeFormatter.ISO_DATE)
                        .atStartOfDay(ZoneId.systemDefault()).toInstant())
                """.trimToSingleLine() to setOf(
                    "java.time.format.DateTimeFormatter",
                    "java.time.LocalDate",
                    "java.time.ZoneId"
                )
            }

            DateTimeFormatter.ISO_LOCAL_TIME -> {
                """ 
                    Date.from(LocalTime.parse("$dateString", DateTimeFormatter.ISO_LOCAL_TIME)
                        .atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant()
                """.trimToSingleLine() to setOf(
                    "java.time.format.DateTimeFormatter",
                    "java.time.LocalTime",
                    "java.time.ZoneId"
                )
            }

            DateTimeFormatter.ISO_OFFSET_TIME -> {
                """ 
                    Date.from(LocalTime.parse("$dateString", DateTimeFormatter.ISO_OFFSET_TIME)
                        .atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant()
                """.trimToSingleLine() to setOf(
                    "java.time.format.DateTimeFormatter",
                    "java.time.LocalTime",
                    "java.time.ZoneId"
                )
            }
            DateTimeFormatter.ISO_TIME -> {
                """ 
                    Date.from(LocalTime.parse("$dateString", DateTimeFormatter.ISO_TIME)
                        .atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant()
                """.trimToSingleLine() to setOf(
                    "java.time.format.DateTimeFormatter",
                    "java.time.LocalTime",
                    "java.time.ZoneId"
                )
            }

            DateTimeFormatter.ISO_LOCAL_DATE_TIME -> {
                """ 
                    Date.from(LocalDateTime.parse("$dateString", DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                        .atZone(ZoneId.systemDefault()).toInstant()
                """.trimToSingleLine() to setOf(
                    "java.time.format.DateTimeFormatter",
                    "java.time.LocalDateTime",
                    "java.time.ZoneId"
                )
            }

            DateTimeFormatter.ISO_OFFSET_DATE_TIME -> {
                """ 
                    Date.from(LocalDateTime.parse("$dateString", DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                        .atZone(ZoneId.systemDefault()).toInstant()
                """.trimToSingleLine() to setOf(
                    "java.time.format.DateTimeFormatter",
                    "java.time.LocalDateTime",
                    "java.time.ZoneId"
                )
            }

            DateTimeFormatter.ISO_DATE_TIME -> {
                """ 
                    Date.from(LocalDateTime.parse("$dateString", DateTimeFormatter.ISO_DATE_TIME)
                        .atZone(ZoneId.systemDefault()).toInstant()
                """.trimToSingleLine() to setOf(
                    "java.time.format.DateTimeFormatter",
                    "java.time.LocalDateTime",
                    "java.time.ZoneId"
                )
            }

            else -> throw IllegalArgumentException("Cannot derive initialization value string for date string " +
                "$dateString")
        }
    }

    private val IntermediateDataField.visibilitySubsequentlyConstrained get() = isInherited && isHidden
    private val IntermediateDataField.needsGetter get() = !isHidden
    private val IntermediateDataField.needsSetter get() = !isImmutable && !isHidden
    private val IntermediateDataField.willBeFinal get() = isImmutable && initializationValue !== null
}