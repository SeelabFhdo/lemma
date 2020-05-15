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
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext.State as DomainState
import de.fhdo.lemma.model_processing.code_generation.java_base.packageName

/**
 * Code generation handler for IntermediateEnumeration instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class EnumerationHandler
    : VisitingCodeGenerationHandlerI<IntermediateEnumeration, EnumDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateEnumeration::class.java
    override fun generatesNodesOfInstance() = EnumDeclaration::class.java
    override fun getAspects(eObject: IntermediateEnumeration) = eObject.aspects!!

    companion object {
        private const val VALUE_ATTRIBUTE_NAME = "value";
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateEnumeration, context: Nothing?) : Pair<EnumDeclaration, String?>? {
        /* Each IntermediateEnumeration becomes a Java Enumeration */
        val currentDomainPackage: String by DomainState
        val packageName = "$currentDomainPackage.${eObject.packageName}"
        val generatedEnum = newEnum(packageName, eObject.name)

        /* Handle IntermediateEnumerationField instances, which become Java Enumeration constants */
        var hasInitializationValue = false
        for (field in eObject.fields) {
            val enumConstant = generatedEnum.addEnumConstant(field.name)
            if (field.initializationValue == null)
                continue

            hasInitializationValue = true
            // The type of the initialization value of the enumeration field is the one from the set of compatible types
            // that has the lowest bit-size
            val initValueType = field.initializationValueCompatibleTypes.sortedBy { it.size }[0]
            val (initValueString, imports) = initValueType.createTypeSpecificValueString(field.initializationValue)
            enumConstant.addArgument(initValueString)
            imports.forEach { generatedEnum.addImport(it, ImportTargetElementType.ATTRIBUTE) }
        }

        /*
         * In case one or more of the enumeration fields has an initialization value assigned, we adapt the Java
         * Enumeration to allow for initializing its constants. That is, an Object field to store values of arbitrary
         * Java types, a value constructor for the constants to initialize, an Object-type as well as a convenience
         * typed getter will be added.
         */
        if (hasInitializationValue) {
            generatedEnum.addPrivateField("Object", VALUE_ATTRIBUTE_NAME)
            generatedEnum.addConstructor()
            generatedEnum.addObjectValueConstructor(VALUE_ATTRIBUTE_NAME)
            generatedEnum.addObjectValueGetter(VALUE_ATTRIBUTE_NAME)
            generatedEnum.addTypedValueGetter(VALUE_ATTRIBUTE_NAME)
        }

        return generatedEnum to eObject.fullyQualifiedClasspath()
    }

    /**
     * Helper to add a constructor for an Object-typed value to the Java Enumeration for the given [valueFieldName]
     */
    private fun EnumDeclaration.addObjectValueConstructor(valueFieldName: String) {
        val valueConstructor = addConstructor()
        val valueConstructorParameter = Parameter()
        valueConstructorParameter.setType("Object")
        valueConstructorParameter.setName(valueFieldName)
        valueConstructor.addParameter(valueConstructorParameter)
        valueConstructor.setBody("this.$valueFieldName = $valueFieldName;")
    }

    /**
     * Helper to add a getter for an Object-typed value to the Java Enumeration for the given [valueFieldName]
     */
    private fun EnumDeclaration.addObjectValueGetter(valueFieldName: String) {
        val rawValueGetter = addMethod("rawValue", Modifier.Keyword.PUBLIC)
        rawValueGetter.setType("Object")
        rawValueGetter.setBody("return $valueFieldName")
    }

    /**
     * Helper to add a getter to the Java Enumeration for the given [valueFieldName], whose return type can be
     * parameterized leveraging generics and that will cast the return value to the type argument
     */
    private fun EnumDeclaration.addTypedValueGetter(valueFieldName: String) {
        val rawValueGetter = addMethod("value", Modifier.Keyword.PUBLIC)
        rawValueGetter.addTypeParameter("T")
        rawValueGetter.setType("T")
        rawValueGetter.setBody("return (T) $valueFieldName")
    }
}