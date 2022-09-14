package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.handlers

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.FieldDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.data.intermediate.IntermediateType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
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
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.invokeCodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.hasFeature
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.TypeMappingDescription
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.createTypeSpecificValueString
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getBasicType
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getTypeMapping
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.isNullable
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.setJavaTypeFrom
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext.State as DomainState
import de.fhdo.lemma.model_processing.utils.trimToSingleLine

/**
 * Called code generation handler for IntermediateDataField instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class DataFieldHandler :
    CallableCodeGenerationHandlerI<IntermediateDataField, FieldDeclaration, ClassOrInterfaceDeclaration> {
    override fun handlesEObjectsOfInstance() = IntermediateDataField::class.java
    override fun generatesNodesOfInstance() = FieldDeclaration::class.java
    override fun getAspects(eObject: IntermediateDataField) = eObject.aspects!!

    companion object {
        /**
         * Convenience companion method to invoke the handler
         */
        fun invoke(field: IntermediateDataField, parentClass: ClassOrInterfaceDeclaration)
            = invokeCodeGenerationHandler(DataFieldHandler(), field, parentClass)
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateDataField, context: ClassOrInterfaceDeclaration?)
        : Pair<FieldDeclaration, String?>? {
        /*
         * If the field is not an inherited field, add a normal Java attribute and corresponding accessors to the given
         * parent class. Otherwise, if the field is inherited and also hidden, we add a getter to the parent class that
         * throws an Exception when being called. That is, because LEMMA allows for subsequently constraining the
         * visibility of inherited fields, while Java does not.
         */
        return if (!eObject.isInherited)
                context!!.addAttributeAndAccessorsFrom(eObject) to null
            else if (eObject.isHidden) {
                context!!.addNotImplementedGetterFrom(eObject)
                null
            } else
                null
    }

    /**
     * Helper to add an attribute and corresponding accessors to this [ClassOrInterfaceDeclaration] from the specified
     * [field]
     */
    private fun ClassOrInterfaceDeclaration.addAttributeAndAccessorsFrom(field: IntermediateDataField)
        : FieldDeclaration {
        val attribute = addPrivateAttribute(field.name, "TODO")
        attribute.setInitializationValueIfNeeded(field)
        attribute.isFinal = field.isImmutable && field.initializationValue != null
        val (typeMapping, intermediateType) = attribute.determineAndGetTypeMapping(field)

        if (typeMapping != null) {
            addGetterFromIfNeeded(field, attribute, typeMapping, intermediateType)
            addSetterFromIfNeeded(field, attribute, typeMapping, intermediateType)
        }

        return attribute
    }

    /**
     * Helper to determine the [TypeMappingDescription] for this attribute based on the given intermediate [field]
     */
    private fun FieldDeclaration.determineAndGetTypeMapping(field: IntermediateDataField)
        : Pair<TypeMappingDescription?, IntermediateType> {
        /*
         * Handle multi-value aspects, such as Array or Collection. When the intermediate field exhibits one of those
         * aspects, its basic type for the multi-value specification will be determined. In all cases except for an
         * intermediate collection type, this basic type corresponds to the intermediate field's type. For intermediate
         * collection types, however, the basic type is either the primitive type of the collection or the type of a
         * single data field in a structured collection. Ultimately, this results in type mappings such as "String[]"
         * (i.e., the aspect is "Array" and the basic type is String, which could be the type of a primitive collection)
         * or "Collection<Address>" (i.e., the aspect is "Collection" and the basic type is Address, which could be the
         * type of the single data field of a structured collection).
         */
        var mappedForMultiValueAspect = false
        val intermediateType = if (field.hasAspect("java.Array") || field.hasAspect("java.Collection")) {
            val basicTypeForMultiValueAspect = field.type.getBasicType()
            mappedForMultiValueAspect = basicTypeForMultiValueAspect != null
            basicTypeForMultiValueAspect ?: field.type
        } else
            field.type

        /* Set the (basic) type of the attribute */
        val typeMapping = variables[0].setJavaTypeFrom(intermediateType, this) {
            addImport(it, ImportTargetElementType.ATTRIBUTE_TYPE)
        }

        if (!mappedForMultiValueAspect || typeMapping == null)
            return typeMapping to intermediateType

        /* Adapt the basic type of the attribute to multi-value aspects */
        val mappedTypeName = if (field.hasAspect("java.Array"))
                "${variables[0].typeAsString}[]"
            else {
                typeMapping.addImport("java.util.Collection")
                addImport("java.util.Collection", ImportTargetElementType.ATTRIBUTE_TYPE)
                "Collection<${variables[0].typeAsString}>"
            }

        variables[0].setType(mappedTypeName)
        typeMapping.mappedTypeName = mappedTypeName
        return typeMapping to intermediateType
    }

    /**
     * Helper to set the initialization value of this [FieldDeclaration] from the given [field]
     */
    private fun FieldDeclaration.setInitializationValueIfNeeded(field: IntermediateDataField) {
        if (field.initializationValue == null)
            return

        val (typeSpecificInitValue, imports) = field.type.createTypeSpecificValueString(field.initializationValue)
        setInitializationValue(typeSpecificInitValue)
        imports.forEach { addImport(it, ImportTargetElementType.ATTRIBUTE) }
    }

    /**
     * Helper to add a getter for the [field] to this [ClassOrInterfaceDeclaration]
     */
    private fun ClassOrInterfaceDeclaration.addGetterFromIfNeeded(field: IntermediateDataField,
        generatedAttribute: FieldDeclaration, typeMapping: TypeMappingDescription, type: IntermediateType) {
        if (field.isHidden)
            return

        val (backingAttributeName, getterMethod) = addGetter(generatedAttribute)
        getterMethod.addTypeMappingInformation(typeMapping, type)

        // If the field must never be empty, add a null-check to the method if possible
        if (field.hasFeature("NEVER_EMPTY") && field.type.isNullable) {
            getterMethod.insertStatement(
                """
                    if ($backingAttributeName == null)
                        throw new IllegalStateException(
                            "Never empty field $backingAttributeName has not been initialized yet"
                        );
                """.trimIndent()
            )
        }
    }

    /**
     * Helper to add [typeMapping] information to this [MethodDeclaration]
     */
    private fun MethodDeclaration.addTypeMappingInformation(typeMapping: TypeMappingDescription,
        intermediateType : IntermediateType) {
        typeMapping.getImports().forEach { addImport(it, ImportTargetElementType.METHOD) }

        if (typeMapping.isComplexTypeMapping) {
            val currentDomainPackage: String by DomainState
            val typeClassname = (intermediateType as IntermediateComplexType).fullyQualifiedClassname
            val complexTypeFullyQualifiedName = "$currentDomainPackage.$typeClassname"
            addImport(complexTypeFullyQualifiedName, ImportTargetElementType.METHOD)
        }
    }

    /**
     * Helper to add a setter for the [field] to this [ClassOrInterfaceDeclaration]
     */
    private fun ClassOrInterfaceDeclaration.addSetterFromIfNeeded(field: IntermediateDataField,
        generatedAttribute: FieldDeclaration, typeMapping: TypeMappingDescription, intermediateType: IntermediateType) {
        if (field.isImmutable || field.isHidden)
            return

        val (backingAttributeName, setterMethod) = addSetter(generatedAttribute)
        setterMethod.addTypeMappingInformation(typeMapping, intermediateType)

        // If the field must never be empty, add a null-check to the method if possible
        if (field.hasFeature("NEVER_EMPTY") && field.type.isNullable) {
            setterMethod.insertStatement(
                """
                    if ($backingAttributeName == null)
                        throw new IllegalArgumentException("Field $backingAttributeName cannot be empty");
                """.trimIndent()
            )
        }
    }

    /**
     * Helper to add a getter to this [ClassOrInterfaceDeclaration] from the given [field], that throws an Exception
     * when being called. This is needed, because Java does not allow to subsequently constrain the visbility of an
     * inherited attribute as LEMMA does. A getter that throws an Exception mimics this behavior, however.
     */
    private fun ClassOrInterfaceDeclaration.addNotImplementedGetterFrom(field: IntermediateDataField) {
        val (typeName, _) = field.type.getTypeMapping()!!
        val getterMethod = addGetterForInheritedAttribute(field.name, typeName)
        getterMethod.addAnnotation("Override")
        getterMethod.setBody(
            """
                throw new UnsupportedOperationException(
                    "The method \"${getterMethod.nameAsString}\" is not visible on this type"
                )
            """.trimToSingleLine()
        )
    }
}