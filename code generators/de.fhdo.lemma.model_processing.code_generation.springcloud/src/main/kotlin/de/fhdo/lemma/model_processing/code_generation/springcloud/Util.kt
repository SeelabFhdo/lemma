package de.fhdo.lemma.model_processing.code_generation.springcloud

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.FieldDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.expr.NameExpr
import com.github.javaparser.ast.expr.NormalAnnotationExpr
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.data.intermediate.IntermediateType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependencies
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addPrivateAttribute
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addStatements
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getValueAsString
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletStateAccess
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.TypeMappingDescription
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.PropertyFile
import de.fhdo.lemma.model_processing.code_generation.springcloud.Context.State as State
import de.fhdo.lemma.model_processing.code_generation.springcloud.languages.getGenletTypeMapping

/**
 * Helper to add type-mapping-related imports and dependencies to the specified [targetNode] based on this
 * [IntermediateType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun <P: Node> IntermediateType.addTypeInformationTo(targetNode: P,
    addImportToTargetNode: P.(String) -> Unit) : TypeMappingDescription? {
    val typeMapping = getGenletTypeMapping() ?: return null

    val (_, complexTypeMapping, imports, dependencies) = typeMapping
    imports.forEach { addImportToTargetNode(targetNode, it) }
    targetNode.addDependencies(dependencies)

    if (complexTypeMapping) {
        val currentDomainPackage: String by GenletStateAccess
        val fullyQualifiedClassname = (this as IntermediateComplexType).fullyQualifiedClassname
        val complexTypeFullyQualifiedName = "$currentDomainPackage.$fullyQualifiedClassname"
        addImportToTargetNode(targetNode, complexTypeFullyQualifiedName)
    }

    return typeMapping
}

/**
 * Helper to check if this [NormalAnnotationExpr] has a String [property] with value [checkValue].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun NormalAnnotationExpr.hasStringValue(property: String, checkValue: String) : Boolean {
    val annotationValue = getValueAsString(property) ?: return false
    val values = parseMultipleAnnotationStringValue(annotationValue) ?: return checkValue == annotationValue
    return checkValue in values
}

/**
 * Helper to parse the [value] of a multi-value annotation String property. Those values have the form
 *      {"foo", "bar"}
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun parseMultipleAnnotationStringValue(value: String) : List<String>? {
    if (!value.startsWith("{") && !value.endsWith("}"))
        return null

    val containedValues = value.trimStart('}').trimEnd('}').split(",")
    val allContainedValuesAreStrings = !containedValues.any { !it.startsWith("\"") && !it.endsWith("\"") }
    return if (allContainedValuesAreStrings)
        containedValues
    else
        null
}

/**
 * Add the specified String [value] to the property called [property] of this [NormalAnnotationExpr]. If the [property]
 * is already present, the [value] will be added to the [property] in the form of a multi-value String. Note, that no
 * duplicate check will be performed.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun NormalAnnotationExpr.addStringValue(property: String, value: String) {
    /* Get and parse the existing value*/
    val existingValue = getValueAsString(property)
    val existingMultipleValues = if (existingValue != null)
        parseMultipleAnnotationStringValue(existingValue)
    else
        null

    /*
     * Prepare the value to be added. This either extends an existing multi-value property's value, creates a new
     * multi-value property's value, or an all-new String value.
     */
    val valueToAdd = when {
        existingMultipleValues != null -> "{" + existingMultipleValues.joinToString(",") + ", \"$value\"" + "}"
        existingValue != null -> "{$existingValue, \"$value\"}"
        else -> "\"$value\""
    }

    /* Add the prepared value to the annotation */
    val existingPair = pairs.find { it.nameAsString == property }
    if (existingPair == null)
        addPair(property, valueToAdd)
    else
        existingPair.value = NameExpr(valueToAdd)
}

/**
 * Helper to add a protected method annotated with Spring's Bean annotation to this [ClassOrInterfaceDeclaration].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.addProtectedBeanMethod(name: String, returnType: String,
    parameters: Map<String, String> = emptyMap(), methodImports: Set<String> = emptySet(), body: String,
    bodyImports: Set<String> = emptySet()) : MethodDeclaration {
    /* Add the method together with the annotation */
    val beanMethod = addMethod(name, Modifier.Keyword.PROTECTED)
    beanMethod.setType(returnType)
    beanMethod.addImport("org.springframework.context.annotation.Bean", ImportTargetElementType.ANNOTATION,
        SerializationCharacteristic.DONT_RELOCATE)
    beanMethod.addAnnotation("Bean", SerializationCharacteristic.DONT_RELOCATE)
    beanMethod.addSerializationCharacteristic(SerializationCharacteristic.DONT_RELOCATE)

    /* Add method parameters */
    parameters.forEach { (name, type) -> beanMethod.addParameter(type, name) }

    /* Add signature-specific imports */
    methodImports.forEach {
        beanMethod.addImport(it, ImportTargetElementType.METHOD, SerializationCharacteristic.DONT_RELOCATE)
    }

    /* Add body and body-related imports */
    beanMethod.addStatements(body)
    bodyImports.forEach {
        beanMethod.addImport(it, ImportTargetElementType.METHOD_BODY, SerializationCharacteristic.DONT_RELOCATE)
    }

    return beanMethod
}

/**
 * Helper to add a private constant, i.e., a private final static attribute, to this [ClassOrInterfaceDeclaration].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.addPrivateConstant(name: String, type: String, initializer: String ? = null)
    : FieldDeclaration {
    val newConstant = addPrivateAttribute(name, type, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL,
        initializer = initializer)
    newConstant.addSerializationCharacteristic(SerializationCharacteristic.DONT_RELOCATE)
    return newConstant
}

/**
 * Helper to add the value of a property of this [IntermediateImportedAspect] named [aspectPropertyName] to the current
 * application properties file as a property named [targetPropertyName].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateImportedAspect.toApplicationProperty(aspectPropertyName: String, targetPropertyName: String)
    : String? {
    val propertyValue = getPropertyValue(aspectPropertyName) ?: return null
    val currentApplicationPropertiesFile: PropertyFile by State
    currentApplicationPropertiesFile[targetPropertyName] = propertyValue
    return propertyValue
}