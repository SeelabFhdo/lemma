package de.fhdo.lemma.model_processing.code_generation.springcloud.kafka

import com.github.javaparser.StaticJavaParser
import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.FieldDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.type.ClassOrInterfaceType
import com.github.javaparser.ast.type.Type
import com.github.javaparser.ast.type.WildcardType
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataModel
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateType
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAndGetAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addPrivateAttribute
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.getAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.hasInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.hasResultParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.setJavaTypeFrom
import de.fhdo.lemma.model_processing.code_generation.java_base.resolve
import de.fhdo.lemma.model_processing.utils.findAliasForTechnology
import de.fhdo.lemma.service.Microservice
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.service.intermediate.IntermediateParameter
import de.fhdo.lemma.technology.CommunicationType
import de.fhdo.lemma.technology.ExchangePattern
import de.fhdo.lemma.technology.mapping.ComplexTypeMapping
import org.eclipse.emf.ecore.EObject

/**
 * Get alias of Kafka technology model from [Microservice].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val Microservice.kafkaAlias
    get() = technologyReferences.findAliasForTechnology("Kafka")

/**
 * Get alias of Kafka technology model from [ComplexTypeMapping].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val ComplexTypeMapping.kafkaAlias
    get() = technologyReferences.findAliasForTechnology("Kafka")

/**
 * Get alias of Domain Events technology model from [Microservice].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val Microservice.domainEventsAlias
    get() = technologyReferences.findAliasForTechnology("DomainEvents")

/**
 * Get alias of CQRS technology model from [Microservice].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val Microservice.cqrsAlias
    get() = technologyReferences.findAliasForTechnology("CQRS")

/**
 * Check if an [IntermediateOperation] has parameters with the given [communicationType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateOperation.hasParametersOfCommunicationType(communicationType: CommunicationType)
    = hasInputParameters(communicationType) || hasResultParameters(communicationType)

/**
 * Check if an [IntermediateParameter] communicates a result.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateParameter.isResultParameter()
    = exchangePattern == ExchangePattern.OUT.name || exchangePattern == ExchangePattern.INOUT.name

/**
 * Check if an [IntermediateParameter] is an input parameter.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateParameter.isInputParameter()
    = exchangePattern == ExchangePattern.IN.name || exchangePattern == ExchangePattern.INOUT.name

/**
 * Helper to create a [ClassOrInterfaceType] that is a generic type with two type arguments. The generic type is a
 * [ClassOrInterfaceType], whose name corresponds to this [String]. The first type argument is [String]. The second type
 * argument is the [ClassOrInterfaceType] passed by [secondArgType].
 *
 * The Java template for the resulting [ClassOrInterfaceType] thus looks like
 *      this<String, secondArgType>
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun String.toGenericTypeWithStringKey(secondArgType: ClassOrInterfaceType) : ClassOrInterfaceType {
    val baseType = StaticJavaParser.parseClassOrInterfaceType(this)
    baseType.setTypeArguments(StaticJavaParser.parseClassOrInterfaceType("String"), secondArgType)
    return baseType
}

/**
 * Create a generic wildcard [ClassOrInterfaceType] from this [String] with given [wildcardCount].
 *
 * For [wildcardCount] = 3, the Java template for the resulting [ClassOrInterfaceType] thus looks like
 *      this<?, ?, ?>
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun String.nArgGenericWildcardType(wildcardCount: Int = 1)
    = StaticJavaParser.parseClassOrInterfaceType(this)
        .setTypeArguments(*List(wildcardCount) { WildcardType() }.toTypedArray())

/**
 * Get the type argument with the given [index] from this generic [Type] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Type.getTypeArg(index: Int) : Type? {
    val classOrInterfaceType = this as? ClassOrInterfaceType ?: return null
    val typeArgs = classOrInterfaceType.typeArguments.orElseGet(null) ?: return null

    return if (index in 0 until typeArgs.size)
        typeArgs[index]
    else
        null
}

/**
 * Get the type of this [IntermediateParameter] as a [ClassOrInterfaceType] and the set of required type imports.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateParameter.classOrInterfaceType() : Pair<ClassOrInterfaceType, Set<String>>? {
    val (javaType, typeImports) = type.javaType()
    val classOrInterfaceType = javaType as? ClassOrInterfaceType ?: return null
    return classOrInterfaceType to typeImports
}

/**
 * Get the corresponding Java type of this [IntermediateType] and the set of required type imports.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateType.javaType() : Pair<Type, Set<String>> {
    val fakeMethod = MethodDeclaration()
    val typeImports = mutableSetOf<String>()
    fakeMethod.setJavaTypeFrom(this, fakeMethod) { typeImports.add(it) }
    return fakeMethod.type to typeImports
}

/**
 * Convenience function to add an import with [SerializationCharacteristic] REMOVE_ON_RELOCATION to this
 * [MethodDeclaration]. The default [ImportTargetElementType] is METHOD_BODY.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun MethodDeclaration.addRelocatableImport(import: String,
    targetElementType: ImportTargetElementType = ImportTargetElementType.METHOD_BODY)
    = addImport(import, targetElementType, SerializationCharacteristic.REMOVE_ON_RELOCATION)

/**
 * Check if setter for the given [attribute] exists in this [ClassOrInterfaceDeclaration].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.setterExists(attribute: FieldDeclaration) : Boolean {
    val fakeSetter = attribute.createSetter()
    remove(fakeSetter)
    return methodExists(fakeSetter.nameAsString, fakeSetter.parameters.map { it.type })
}

/**
 * Check if a method with the given signature ([methodName] and [parameterTypes]) exists in this
 * [ClassOrInterfaceDeclaration].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.methodExists(methodName: String, parameterTypes: List<Type> = emptyList())
    = findMethod(methodName, parameterTypes) != null

/**
 * Find method with the given signature ([methodName] and [parameterTypes]) in this [ClassOrInterfaceDeclaration].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.findMethod(methodName: String, parameterTypes: List<Type> = emptyList())
    = methods.find { method ->
            method.nameAsString == methodName &&
            method.parameters.size == parameterTypes.size &&
            method.parameters
                .map { it.type }
                .withIndex()
                .all { (index, type) -> type.asString() == parameterTypes[index].asString() }
        }

/**
 * Count all methods with the given [prefix] and [parameterTypes] in this [ClassOrInterfaceDeclaration].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.countMethodsWithPrefix(prefix: String,
    parameterTypes: List<Type> = emptyList())
    = methods.count { method ->
            method.nameAsString.startsWith(prefix) &&
            method.parameters.size == parameterTypes.size &&
            method.parameters
                .map { it.type }
                .withIndex()
                .all { (index, type) -> type.asString() == parameterTypes[index].asString() }
        }

/**
 * Add a method with the given [methodName] and Spring's Bean annotation to this [ClassOrInterfaceDeclaration].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.addBeanMethod(methodName: String) : MethodDeclaration {
    val method = addMethod(methodName, Modifier.Keyword.PUBLIC)
    method.addSerializationCharacteristic(SerializationCharacteristic.REMOVE_ON_RELOCATION)
    method.addAnnotation("Bean")
    method.addRelocatableImport("org.springframework.context.annotation.Bean", ImportTargetElementType.ANNOTATION)
    return method
}

/**
 * Get value of property with name [propertyName] of this EObject's aspect with name [qualifiedAspectName] as Boolean.
 * Returns true if the value of the property is the case-sensitive String "true" and false otherwise.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun EObject.booleanAspectPropertyValueOrFalse(qualifiedAspectName: String, propertyName: String) : Boolean {
    val aspect = getAspect(qualifiedAspectName) ?: return false
    val propertyValue = aspect.getPropertyValue(propertyName) ?: return false
    return when(propertyValue) {
        "true" -> true
        else -> false
    }
}

/**
 * Check if the file represented by this [String] is an Avro protocol file with the extension "avpr".
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun String.isAvroProtocolFile() = asFile().extension.toLowerCase() == "avpr"

/**
 * Get the name of the getter method for the attribute, whose name corresponds to this [String].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun String.getterName() : String {
    val fakeClass = ClassOrInterfaceDeclaration()
    val fakeAttribute = fakeClass.addPrivateAttribute(this, "String")
    return fakeAttribute.createGetter().nameAsString
}

/**
 * Get the name of the setter method for the attribute, whose name corresponds to this [String].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun String.setterName() : String {
    val fakeClass = ClassOrInterfaceDeclaration()
    val fakeAttribute = fakeClass.addPrivateAttribute(this, "String")
    return fakeAttribute.createSetter().nameAsString
}

/**
 * Add an attribute, whose value shall be injected by Spring at runtime via the @Value annotation from a property, to
 * this [ClassOrInterfaceDeclaration].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.addPropertyInjectedAttribute(attributeName: String, propertyName: String,
    attributeTypeName: String = "String") {
    if (this.fields.find { it.variables[0].nameAsString == attributeName } != null)
        return

    val attribute = this.addPrivateAttribute(attributeName, attributeTypeName)
    attribute.addSerializationCharacteristic(SerializationCharacteristic.REMOVE_ON_RELOCATION)
    val annotation = attribute.addAndGetAnnotation("Value", SerializationCharacteristic.REMOVE_ON_RELOCATION)
    annotation.addPair("value", "\"\${$propertyName}\"")
    attribute.addImport(
        "org.springframework.beans.factory.annotation.Value",
        ImportTargetElementType.ANNOTATION
    )
}

/**
 * Get all visible fields and their resolved types from this [IntermediateDataStructure]. If [mutableFieldsOnly] is set
 * to true, only those fields, whose isImmutable flag is false, will be returned.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateDataStructure.visibleFieldsAndTypes(mutableFieldsOnly: Boolean = false)
    = dataFields
        .filter { !it.isHidden && (!mutableFieldsOnly || !it.isImmutable) }
        .map { field ->
            val type = if (field.type is IntermediateComplexType)
                (field.type as IntermediateComplexType).resolve()
            else
                field.type

            field to type
        }

/**
 * Helper to find the data model that contains the [IntermediateComplexType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateComplexType.getContainingDataModel() : IntermediateDataModel {
    var container = eContainer()
    while (container !is IntermediateDataModel)
        container = container.eContainer()
    return container
}