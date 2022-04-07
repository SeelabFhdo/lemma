package de.fhdo.lemma.model_processing.code_generation.springcloud

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.FieldDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.expr.NameExpr
import com.github.javaparser.ast.expr.NormalAnnotationExpr
import com.github.javaparser.ast.type.Type
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
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
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.TypeMappingDescription
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.setJavaTypeFrom
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
 * Helper to get the Java type from this [IntermediateType] and invoke the given [addImportToTargetNode] callback to
 * directly add related imports to a generated node.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateType.javaType(addImportToTargetNode: (String) -> Unit) : Type {
    val fakeMethod = MethodDeclaration()
    fakeMethod.setJavaTypeFrom(this, fakeMethod) { addImportToTargetNode(it) }
    return fakeMethod.type
}

/**
 * Helper to check if this [NormalAnnotationExpr] has a [property] with value [checkValue].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun NormalAnnotationExpr.hasValue(property: String, checkValue: String) : Boolean {
    val annotationValue = getValueAsString(property) ?: return false
    val values = parseMultiValueAnnotation(annotationValue) ?: return checkValue == annotationValue
    return checkValue in values
}

/**
 * Helper to parse the [value] of a multi-value annotation property. Those values have the form
 *      {"foo", "bar"} or {foo, bar}
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun parseMultiValueAnnotation(value: String) : List<String>? {
    if (!value.startsWith("{") && !value.endsWith("}"))
        return null

    return value.trimStart('{').trimEnd('}').split(",")
}

/**
 * Add the specified [value] to the property called [property] of this [NormalAnnotationExpr]. If the [property] is
 * already present, the [value] will be added to the [property] in the form of a multi-value annotation property. Note,
 * that no duplicate check will be performed.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun NormalAnnotationExpr.addValue(property: String, value: String) {
    /* Get and parse the existing value*/
    val existingValue = getValueAsString(property)
    val existingMultipleValues = if (existingValue != null)
        parseMultiValueAnnotation(existingValue)
    else
        null

    /*
     * Prepare the value to be added. This either extends an existing multi-value property's value, creates a new
     * multi-value property's value, or an all-new value.
     */
    val valueToAdd = when {
        existingMultipleValues != null -> "{" + existingMultipleValues.joinToString(",") + ", $value}"
        existingValue != null -> "{$existingValue, $value}"
        else -> value
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
 * Build the [Set] of qualified aspect names for all supported technologies from this [String] representing a simple
 * aspect name. For instance, for the simple name "Access" this function returns the [Set] {"Java.Accesss",
 * "java.Accesss", "Spring.Accesss", "spring.Accesss"}.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun String.forAllTechnologies() = forTechnologies(ALL_TECHNOLOGY_NAMES)

/**
 * Generic helper to build the [Set] of qualified aspect names from the given [Set] of [technologyNames] for this
 * [String] representing a simple aspect name.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun String.forTechnologies(technologyNames: Set<String>) = technologyNames.map { "$it.$this" }.toSet()

/**
 * Build the [Set] of qualified aspect names for the Java technology from this [String] representing a simple aspect
 * name. For instance, for the simple name "Constant" this function returns the [Set] {"Java.Constant",
 * "java.Constant"}.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun String.forJavaTechnology() = forTechnologies(JAVA_TECHNOLOGY_NAMES)

/**
 * Build the [Set] of qualified aspect names for the Spring technology from this [String] representing a simple aspect
 * name. For instance, for the simple name "Value" this function returns the [Set] {"Spring.Value", "spring.Value"}.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun String.forSpringTechnology() = forTechnologies(SPRING_TECHNOLOGY_NAMES)

/**
 * Build the [Set] of qualified aspect names for all supported technologies from this [Set] clustering simple aspect
 * name synonyms. For instance, for the [Set] of simple aspect names {"DecimalMax", "DecimalMin"} this function returns
 * the [Set] {"Java.DecimalMax", "java.DecimalMax", "Spring.DecimalMax", "spring.DecimalMax", "Java.DecimalMin",
 * "java.DecimalMin", "Spring.DecimalMin", "spring.DecimalMin"}.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Set<String>.forAllTechnologies() = forTechnologies(ALL_TECHNOLOGY_NAMES)

/**
 * Generic helper to build the [Set] of qualified aspect names from the given [Set] of [technologyNames] for this [Set]
 * clustering simple aspect name synonyms.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun Set<String>.forTechnologies(technologyNames: Set<String>)
    = technologyNames.map { technologyName -> this.map { aspectName ->
        "$technologyName.$aspectName"
    }}.flatten().toSet()

/**
 * Build the [Set] of qualified aspect names for the Spring technology from this [Set] clustering simple aspect
 * name synonyms. For instance, for the [Set] of simple aspect names {"MessageMapping", "SendTo"} this function returns
 * the [Set] {"Spring.MessageMapping", "spring.MessageMapping", "Spring.SendTo", "spring.SendTo"}.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Set<String>.forSpringTechnology() = forTechnologies(SPRING_TECHNOLOGY_NAMES)