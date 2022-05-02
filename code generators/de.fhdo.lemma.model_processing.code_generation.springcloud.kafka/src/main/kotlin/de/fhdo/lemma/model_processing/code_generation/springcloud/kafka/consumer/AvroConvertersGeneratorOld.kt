package de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.consumer

import com.github.javaparser.StaticJavaParser
import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.ConstructorDeclaration
import com.github.javaparser.ast.body.EnumDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.body.TypeDeclaration
import com.github.javaparser.ast.expr.SimpleName
import com.github.javaparser.ast.stmt.BlockStmt
import com.github.javaparser.ast.stmt.ExpressionStmt
import com.github.javaparser.ast.stmt.Statement
import com.github.javaparser.ast.type.ClassOrInterfaceType
import de.fhdo.lemma.data.PrimitiveTypeConstants
import de.fhdo.lemma.data.intermediate.IntermediateCollectionType
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateEnumeration
import de.fhdo.lemma.data.intermediate.IntermediateImportedTechnologySpecificType
import de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType
import de.fhdo.lemma.data.intermediate.IntermediateType
import de.fhdo.lemma.data.intermediate.IntermediateTypeKind
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.appendStatement
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.attributes
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.instantiableClassName
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getItemClassnamesAndImports
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getObjectWrapperMapping
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getTypeMapping
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.typeArgumentObjectWrapperMapping
import de.fhdo.lemma.model_processing.code_generation.java_base.resolve
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.addRelocatableImport
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.avro.AvroConversionTypeManager
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.findMethod
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.getExistingGetter
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.getExistingSetter
import de.fhdo.lemma.model_processing.utils.trimToSingleLine

private const val AVRO_CONVERTER_PREFIX = "avro"
private const val AVRO_OBJECT = "avroObject"
private const val AVRO_ENTRY = "avroEntry"
private const val DOMAIN_CONVERTER_PREFIX = "domain"
private const val DOMAIN_OBJECT = "domainObject"
private const val DOMAIN_ENTRY = "domainEntry"

class AvroConvertersGeneratorOld(private val domainPackage: String) {
    private val createdAvroConverters = mutableMapOf<String, AbstractAvroConverter>()
    private val requiredAvroConverters = mutableMapOf<String, AvroSetterWithNestedAvroConverterInvocationInfo>()

    fun generateAvroConverters(rootStructure: IntermediateDataStructure, rootClass: ClassOrInterfaceDeclaration) {
        createdAvroConverters.clear()
        requiredAvroConverters.clear()
        createdDomainConverters.clear()
        requiredDomainConverters.clear()
        Callchains.reset()
        val helpersClass = AvroConversionTypeManager.getOrCreateHelpersClass(domainPackage, rootStructure)
        helpersClass.addAvroConverterForRootStructure(rootStructure)
        helpersClass.addDomainConverterForRootStructure(rootStructure)
    }

    private fun ClassOrInterfaceDeclaration.addAvroConverterForRootStructure(rootStructure: IntermediateDataStructure) {
        addAvroConverterForModeledType(rootStructure, rootStructure)

        createdAvroConverters.values.forEach { it.serializeBody() }
    }

    private fun ClassOrInterfaceDeclaration.addAvroConverterForModeledType(modeledType: IntermediateComplexType,
        rootStructure: IntermediateDataStructure) {

        val complexTypesRequiringAvroConverters = try {
                val avroConverter = when (modeledType) {
                    is IntermediateDataStructure -> AvroConverterForModeledStructure(this, modeledType, rootStructure)
                    is IntermediateCollectionType ->
                        AvroConverterForModeledCollectionType(this, modeledType, rootStructure)
                    is IntermediateEnumeration -> AvroConverterForModeledEnumeration(this, modeledType, rootStructure)
                    else -> throw IllegalArgumentException("Unsupported modeled type ${modeledType::class.java.name}")
                }

                avroConverter.createSignature()
                avroConverterSignatureSuccessfullyCreated(avroConverter)
                val nestedAvroConverterInvocations = avroConverter.deriveBody()
                avroConverterBodySuccessfullyCreated(nestedAvroConverterInvocations)
            } catch (ex: AvroConverterExistsException) {
                emptySet<IntermediateComplexType>()
            } catch (ex: AvroConverterRedundantException) {
                emptySet<IntermediateComplexType>()
            } catch (ex: ConverterCreationException) {
                appendBlockComment("Missing Avro converter: ${ex.message}")
                emptySet<IntermediateComplexType>()
            }

        complexTypesRequiringAvroConverters.forEach { addAvroConverterForModeledType(it, rootStructure) }
    }

    private fun avroConverterSignatureSuccessfullyCreated(avroConverter: AbstractAvroConverter) {
        val converterSignature = avroConverter.converterSignature
        createdAvroConverters[converterSignature] = avroConverter

        val requiredConverter = requiredAvroConverters[converterSignature]
        if (requiredConverter != null) {
            requiredConverter.setNestedAvroConverterCreated()
            requiredAvroConverters.remove(converterSignature)
        }
    }

    private fun avroConverterBodySuccessfullyCreated(
        nestedInvocationInfo: List<AvroSetterWithNestedAvroConverterInvocationInfo>
    ) : Set<IntermediateComplexType> {
        val requiredTypesToConvert = mutableSetOf<IntermediateComplexType>()

        for (info in nestedInvocationInfo) {
            val nestedConverterSignature = info.converterSignature
            if (nestedConverterSignature !in createdAvroConverters) {
                if (nestedConverterSignature !in requiredAvroConverters)
                    requiredAvroConverters[nestedConverterSignature] = info
                else
                    requiredAvroConverters[nestedConverterSignature]!!.mergeWith(info)

                requiredTypesToConvert.add(info.typeToConvert)
            }
        }

        return requiredTypesToConvert
    }

    private val createdDomainConverters = mutableMapOf<String, AbstractDomainConverter>()
    private val requiredDomainConverters = mutableMapOf<String, DomainParameterWithNestedDomainConverterInvocationInfo>()

    private fun ClassOrInterfaceDeclaration.addDomainConverterForRootStructure(
        rootStructure: IntermediateDataStructure
    ) {
        addDomainConverterForModeledType(rootStructure, rootStructure)

        createdDomainConverters.values.forEach { it.serializeBody() }
    }

    private fun ClassOrInterfaceDeclaration.addDomainConverterForModeledType(modeledType: IntermediateComplexType,
        rootStructure: IntermediateDataStructure) {

        val complexTypesRequiringDomainConverters = try {
            val domainConverter = when (modeledType) {
                is IntermediateDataStructure -> DomainConverterForModeledStructure(this, modeledType, rootStructure)
                is IntermediateCollectionType ->
                    DomainConverterForModeledCollectionType(this, modeledType, rootStructure)
                is IntermediateEnumeration -> DomainConverterForModeledEnumeration(this, modeledType, rootStructure)
                else -> throw IllegalArgumentException("Unsupported modeled type ${modeledType::class.java.name}")
            }

            domainConverter.createSignature()
            domainConverterSignatureSuccessfullyCreated(domainConverter)
            val nestedAvroConverterInvocations = domainConverter.deriveBody()
            domainConverterBodySuccessfullyCreated(nestedAvroConverterInvocations)
        } catch (ex: DomainConverterExistsException) {
            emptySet<IntermediateComplexType>()
        } catch (ex: DomainConverterRedundantException) {
            emptySet<IntermediateComplexType>()
        } catch (ex: ConverterCreationException) {
            appendBlockComment("Missing domain converter: ${ex.message}")
            emptySet<IntermediateComplexType>()
        }

        complexTypesRequiringDomainConverters.forEach { addDomainConverterForModeledType(it, rootStructure) }
    }

    private fun domainConverterSignatureSuccessfullyCreated(domainConverter: AbstractDomainConverter) {
        val converterSignature = domainConverter.converterSignature
        createdDomainConverters[converterSignature] = domainConverter

        val requiredConverter = requiredDomainConverters[converterSignature]
        if (requiredConverter != null) {
            requiredConverter.setNestedDomainConverterCreated()
            requiredDomainConverters.remove(converterSignature)
        }
    }

    private fun domainConverterBodySuccessfullyCreated(
        nestedInvocationInfo: List<DomainParameterWithNestedDomainConverterInvocationInfo>
    ) : Set<IntermediateComplexType> {
        val requiredTypesToReturn = mutableSetOf<IntermediateComplexType>()

        for (info in nestedInvocationInfo) {
            val nestedConverterSignature = info.converterSignature
            if (nestedConverterSignature !in createdDomainConverters) {
                if (nestedConverterSignature !in requiredDomainConverters)
                    requiredDomainConverters[nestedConverterSignature] = info
                else
                    requiredDomainConverters[nestedConverterSignature]!!.mergeWith(info)

                requiredTypesToReturn.add(info.typeToReturn)
            }
        }

        return requiredTypesToReturn
    }
}

private fun ClassOrInterfaceDeclaration.appendBlockComment(s: String, separator: String = "\n") {
    if (!comment.isPresent)
        setBlockComment(s)
    else {
        var extendedComment = comment.get().content
        extendedComment += separator + s
        setBlockComment(extendedComment)
    }
}

private fun IntermediateComplexType.avroConverterName() = AVRO_CONVERTER_PREFIX + name.capitalize()

private abstract class AbstractAvroConverter(
    val targetClass: ClassOrInterfaceDeclaration,
    val modeledComplexType: IntermediateComplexType,
    val rootStructure: IntermediateDataStructure
) : MethodDeclaration() {
    lateinit var converterSignature: String
    lateinit var domainType: TypeDeclaration<*>
    lateinit var avroType: TypeDeclaration<*>
    private val avroObjectInitializationStatements = mutableListOf<Statement>()

    fun createSignature() {
        name = SimpleName(modeledComplexType.avroConverterName())
        addModifier(Modifier.Keyword.PUBLIC)
        addSerializationCharacteristic(SerializationCharacteristic.REMOVE_ON_RELOCATION)

        beginSignatureCreation()

        domainType = findDomainType()
        avroType = findAvroType(rootStructure)
        val (returnType, returnTypeImports) = getReturnType()
        val (domainObjectParameterType, domainObjectParameterTypeImports) = getDomainObjectParameterType()

        setType(returnType)
        addParameter(domainObjectParameterType, DOMAIN_OBJECT)
        if (targetClass.findMethod(nameAsString, domainObjectParameterType) != null)
            throw AvroConverterExistsException(nameAsString, targetClass)
        converterSignature = avroConverterSignature(targetClass, nameAsString, modeledComplexType)

        // Add method to super class here to enable propagation of import statements
        targetClass.addMember(this)
        val typeImports = mutableSetOf<String>()
        typeImports.addAll(returnTypeImports)
        typeImports.addAll(domainObjectParameterTypeImports)
        typeImports.forEach { addRelocatableImport(it, ImportTargetElementType.METHOD) }
    }

    protected open fun beginSignatureCreation() {
        // NOOP
    }

    protected abstract fun findDomainType() : TypeDeclaration<*>

    protected abstract fun findAvroType(rootStructure: IntermediateDataStructure) : TypeDeclaration<*>

    protected abstract fun getReturnType() : Pair<String, Set<String>>

    protected abstract fun getDomainObjectParameterType() : Pair<String, Set<String>>

    open fun deriveBody() = emptyList<AvroSetterWithNestedAvroConverterInvocationInfo>()

    fun addAvroObjectInitializationStatement(statement: Statement) {
        avroObjectInitializationStatements.add(statement)
    }

    fun addAvroObjectInitializationStatement(statement: String) {
        avroObjectInitializationStatements.add(StaticJavaParser.parseStatement(statement))
    }

    fun getAvroObjectInitializationStatements() = avroObjectInitializationStatements.toList()

    abstract fun serializeBody()
}

private class AvroSetterWithNestedAvroConverterInvocationInfo(
    caller: AbstractAvroConverter,
    private val domainGetterCall: String,
    private val avroSetter: MethodDeclaration,
    val typeToConvert: IntermediateComplexType
) {
    val nestedAvroConverterName: String = typeToConvert.avroConverterName()
    val converterSignature = avroConverterSignature(caller.targetClass, nestedAvroConverterName, typeToConvert)
    private val expressions = mutableListOf<AvroSetterWithNestedAvroConverterInvocationExpression>()
    private var nestedAvroConverterCreated = false

    constructor(caller: AbstractAvroConverter, domainGetter: MethodDeclaration, avroSetter: MethodDeclaration,
        typeToConvert: IntermediateComplexType) : this(caller, "$DOMAIN_OBJECT.${domainGetter.nameAsString}()",
            avroSetter, typeToConvert)

    /*override fun equals(other: Any?)
        = if (this === other) true
            else if (other == null) false
            else if (other is AvroSetterWithNestedAvroConverterInvocationInfo) signature() == other.signature()
            else false*/

    //override fun hashCode() = signature().hashCode()

    fun newExpression(avroObjectName: String = AVRO_OBJECT) : AvroSetterWithNestedAvroConverterInvocationExpression {
        val avroSetterArgument = "$nestedAvroConverterName($domainGetterCall)"
        val avroSetterCall = "$avroObjectName.${avroSetter.nameAsString}($avroSetterArgument)"
        val newExpression = AvroSetterWithNestedAvroConverterInvocationExpression(this, avroSetterCall)
        expressions.add(newExpression)
        return newExpression
    }

    fun setNestedAvroConverterCreated() {
        nestedAvroConverterCreated = true
        expressions.forEach { it.setConverterExists() }
    }

    fun mergeWith(other: AvroSetterWithNestedAvroConverterInvocationInfo) {
        expressions.addAll(other.expressions)
    }
}

private fun avroConverterSignature(avroConverterClass: ClassOrInterfaceDeclaration, avroConverterName: String,
    modeledParameterType: IntermediateComplexType)
    = "${avroConverterClass.fullyQualifiedName.get()}.$avroConverterName(${modeledParameterType.qualifiedName})"

private class AvroSetterWithNestedAvroConverterInvocationExpression(
    val info: AvroSetterWithNestedAvroConverterInvocationInfo,
    avroSetterCall: String
) : ExpressionStmt(StaticJavaParser.parseExpression(avroSetterCall)) {
    private var converterExists = false

    fun setConverterExists() {
        converterExists = true
    }

    fun converterExists() = converterExists
}

private class AvroConverterExistsException(avroConverterName: String, targetClass: ClassOrInterfaceDeclaration)
    : Exception("Avro converter $avroConverterName already exists in class ${targetClass.fullyQualifiedName.get()}")

private class AvroConverterRedundantException(avroConverterName: String, targetClass: ClassOrInterfaceDeclaration,
    reason: String)
    : Exception("Avro converter ${targetClass.fullyQualifiedName.get()}.$avroConverterName is redundant: $reason")

private class AvroConverterForModeledStructure(
    targetClass: ClassOrInterfaceDeclaration,
    private val modeledStructure: IntermediateDataStructure,
    rootStructure: IntermediateDataStructure
) : AbstractAvroConverter(targetClass, modeledStructure, rootStructure) {
    override fun findDomainType()
        = AvroConversionTypeManager.getJavaTypeGeneratedFromModel(modeledComplexType)
            ?: throw DomainTypeNotFoundException(modeledComplexType)

    override fun findAvroType(rootStructure: IntermediateDataStructure)
        = AvroConversionTypeManager.getJavaTypeCompiledFromSchemaOfRootStructure(rootStructure, domainType.nameAsString)
            ?: throw AvroTypeNotFoundException(rootStructure, domainType)

    override fun getReturnType() = avroType.fullyQualifiedName.get() to emptySet<String>()

    override fun getDomainObjectParameterType() = domainType.nameAsString to setOf(domainType.fullyQualifiedName.get())

    override fun deriveBody() : List<AvroSetterWithNestedAvroConverterInvocationInfo> {
        val nestedInvocationInformation = mutableListOf<AvroSetterWithNestedAvroConverterInvocationInfo>()
        val missingSetterInvocationMessages = StringBuilder()
        val domainClass = domainType as ClassOrInterfaceDeclaration
        val avroClass = avroType as ClassOrInterfaceDeclaration

        for (field in modeledStructure.avroRelevantFields()) {
            val domainGetter = domainClass.getExistingGetter(field)
            if (domainGetter == null) {
                missingSetterInvocationMessages.appendln("Generated domain class " +
                    "${domainClass.fullyQualifiedName.get()} does not comprise a getter for the modeled field " +
                    "${field.qualifiedName} and its type ${field.type.name} of kind ${field.type.kind.literal} and " +
                    "origin ${field.type.origin}")
                continue
            }

            if (field.name == "myDateComplexCollection")
                println()

            val avroSetterAndResolvedParameterType = avroClass.findAvroSetter(rootStructure, field)
            if (avroSetterAndResolvedParameterType == null) {
                missingSetterInvocationMessages.appendln("Schema-compiled Avro class " +
                    "${avroClass.fullyQualifiedName.get()} does not comprise a setter corresponding to the modeled field " +
                    "${field.qualifiedName} and its type ${field.type.name} of kind ${field.type.kind.literal} and " +
                    "origin ${field.type.origin}")
                continue
            }

            val (avroSetter, avroSetterParameterType) = avroSetterAndResolvedParameterType
            if (avroSetterParameterType is IntermediateCollectionType &&
                avroSetterParameterType.isPrimitiveCollection) {
                val collectionTypeInfo = avroSetterParameterType.typeInfo()
                val avroTypeArgument = (avroSetter.parameters.first().type as ClassOrInterfaceType)
                    .typeArguments.get().first().asString()
                val domainGetterCall = if (avroTypeArgument == "java.time.Instant" &&
                    collectionTypeInfo.typeArgumentQualifiedName != "java.time.Instant") {
                    val collectorsFactoryMethod = when (avroSetterParameterType.instantiableClassName) {
                        "java.util.ArrayList", "java.util.LinkedList" -> "toList"
                        "java.util.HashSet" -> "toSet"
                        else -> {
                            missingSetterInvocationMessages.appendln("Avro setter ${avroSetter.nameAsString} " +
                                "requires conversion to a ${avroSetterParameterType.instantiableClassName} of " +
                                "java.time.Instant instances. However, the collection type " +
                                "${avroSetterParameterType.instantiableClassName} is currently not supported for " +
                                "java.time.Instant conversion.")
                            null
                        }
                    } ?: continue

                    addRelocatableImport("java.util.Date", ImportTargetElementType.METHOD_BODY)
                    addRelocatableImport("java.util.stream.Collectors", ImportTargetElementType.METHOD_BODY)
                    "$DOMAIN_OBJECT.${domainGetter.nameAsString}().stream().map(Date::toInstant)" +
                        ".collect(Collectors.$collectorsFactoryMethod())"
                } else
                    "$DOMAIN_OBJECT.${domainGetter.nameAsString}()"

                val avroSetterCall = "$AVRO_OBJECT.${avroSetter.nameAsString}($domainGetterCall);"
                addAvroObjectInitializationStatement(StaticJavaParser.parseStatement(avroSetterCall))
                continue
            }

            if (avroSetterParameterType is IntermediateComplexType) {
                val nestedInfo = AvroSetterWithNestedAvroConverterInvocationInfo(this, domainGetter, avroSetter,
                    avroSetterParameterType)
                nestedInvocationInformation.add(nestedInfo)
                addAvroObjectInitializationStatement(nestedInfo.newExpression())
            } else if (avroSetter.parameters.first().typeAsString == "java.time.Instant" &&
                domainGetter.typeAsString != "Instant") {
                val domainGetterCall = "$DOMAIN_OBJECT.${domainGetter.nameAsString}()"
                val avroSetterArgument = "$domainGetterCall.toInstant()"
                val avroSetterCall = "$AVRO_OBJECT.${avroSetter.nameAsString}($avroSetterArgument);"
                addAvroObjectInitializationStatement(StaticJavaParser.parseStatement(avroSetterCall))
            } else {
                val domainGetterCall = "$DOMAIN_OBJECT.${domainGetter.nameAsString}()"
                val avroSetterCall = "$AVRO_OBJECT.${avroSetter.nameAsString}($domainGetterCall);"
                addAvroObjectInitializationStatement(StaticJavaParser.parseStatement(avroSetterCall))
            }
        }

        if (missingSetterInvocationMessages.isNotEmpty())
            setBlockComment("Missing Avro setter invocations:\n" + missingSetterInvocationMessages.toString().trim())

        return nestedInvocationInformation
    }

    override fun serializeBody() = serializeAvroObjectInitializationStatements()
}

private fun ClassOrInterfaceDeclaration.findAvroMethod(
    rootStructure: IntermediateDataStructure,
    modeledField: IntermediateDataField,
    searchFunction: ClassOrInterfaceDeclaration.(String, String)->MethodDeclaration?
) : Pair<MethodDeclaration, IntermediateType>? {
    val type = modeledField.type
    val resolvedType = if (type is IntermediateComplexType)
            type.resolve()
        else if (type is IntermediateImportedTechnologySpecificType && type.kind == IntermediateTypeKind.PRIMITIVE)
            modeledField.originalType
        else
            type
    val typeMapping = resolvedType.getTypeMapping() ?: return null

    val avroTypeNames = when (resolvedType) {
        is IntermediatePrimitiveType -> {
            if (resolvedType.name == PrimitiveTypeConstants.DATE.literal)
                listOf("java.time.Instant")
            else if (typeMapping.getImports().isNotEmpty()) {
                val fullyQualifiedTypeName = typeMapping.getImports().first {
                    val importedClassSimpleName = it.substringAfterLast(".")
                    typeMapping.mappedTypeName.startsWith(importedClassSimpleName)
                }
                listOf(fullyQualifiedTypeName)
            } else
                listOf(typeMapping.mappedTypeName, "java.lang." + resolvedType.getObjectWrapperMapping().mappedTypeName)
        }

        is IntermediateImportedTechnologySpecificType -> {
            if (typeMapping.getImports().isNotEmpty()) {
                val fullyQualifiedTypeName = typeMapping.getImports().first {
                    val importedClassSimpleName = it.substringAfterLast(".")
                    typeMapping.mappedTypeName.startsWith(importedClassSimpleName)
                }
                listOf(fullyQualifiedTypeName)
            } else
                listOf(typeMapping.mappedTypeName)
        }

        is IntermediateDataStructure,
        is IntermediateEnumeration -> {
            val compiledType = AvroConversionTypeManager.getJavaTypeCompiledFromSchemaOfRootStructure(rootStructure,
                resolvedType.name)
            listOf(compiledType?.fullyQualifiedName?.get())
        }

        is IntermediateCollectionType -> {
            try {
                val typeInfo = resolvedType.typeInfo()
                val fullyQualifiedTypeArgument = if (resolvedType.isPrimitiveCollection)
                        typeInfo.typeArgumentQualifiedName
                    else
                        AvroConversionTypeManager
                            .getJavaTypeCompiledFromSchemaOfRootStructure(rootStructure, resolvedType.name)
                            ?.fullyQualifiedName?.get()

                if (fullyQualifiedTypeArgument == "java.util.Date")
                    listOf("${typeInfo.collectionTypeQualifiedName}<java.time.Instant>")
                else if (fullyQualifiedTypeArgument != null)
                    listOf("${typeInfo.collectionTypeQualifiedName}<$fullyQualifiedTypeArgument>")
                else
                    emptyList()
            } catch(ex: IllegalArgumentException) {
                emptyList<String>()
            }
        }

        else -> throw IllegalArgumentException("Unsupported type kind ${resolvedType.javaClass.name}")
    }

    for (typeName in avroTypeNames.filterNotNull()) {
        val method = searchFunction(modeledField.name, typeName)
        if (method != null)
            return method to resolvedType
    }

    return null
}

private fun IntermediateDataStructure.avroRelevantFields() = dataFields.filter { !it.isHidden }

private fun AbstractAvroConverter.serializeAvroObjectInitializationStatements(
    validStatementsContainer: ((validStatements: List<Statement>)->Statement)? = null
) {
    val validStatements = mutableListOf<Statement>()

    getAvroObjectInitializationStatements().forEach {
        val errorMessage = checkAvroObjectInitializationStatementIsValid(it)

        if (errorMessage == null)
            validStatements.add(it)
        else
            appendBlockComment("\n\t-$errorMessage", "Missing Avro setter invocations:")
    }

    if (validStatements.isNotEmpty()) {
        appendStatement("var $AVRO_OBJECT = new ${getInstantiableAvroObjectName()}();")
        if (validStatementsContainer != null)
            body.get().statements.add(validStatementsContainer(validStatements))
        else
            validStatements.forEach { body.get().statements.add(it) }
        appendStatement("return $AVRO_OBJECT;")
    } else
        appendStatement("return new ${getInstantiableAvroObjectName()}();")
}

private fun MethodDeclaration.appendBlockComment(s: String, introduction: String = "", introductionSep: String = "\n") {
    if (!comment.isPresent) {
        setBlockComment(introduction + s)
        return
    }

    var extendedComment = comment.get().content
    if (introduction.isNotEmpty() && !extendedComment.startsWith(introduction))
        extendedComment += introductionSep + introduction
    extendedComment += s
    setBlockComment(extendedComment)
}

private fun AbstractAvroConverter.getInstantiableAvroObjectName() : String {
    val avroTypeFullyQualifiedName = (avroType as ClassOrInterfaceDeclaration).fullyQualifiedName.get()
    return if (modeledComplexType is IntermediateCollectionType) {
        val instantiableType = modeledComplexType.instantiableClassName
        addRelocatableImport(instantiableType, ImportTargetElementType.METHOD_BODY)

        val instantiableSimpleType = instantiableType.substringAfterLast(".")
        return "$instantiableSimpleType<$avroTypeFullyQualifiedName>"
    } else
        avroTypeFullyQualifiedName
}

private fun AbstractAvroConverter.checkAvroObjectInitializationStatementIsValid(statement: Statement) : String? {
    if (statement !is AvroSetterWithNestedAvroConverterInvocationExpression)
        return null

    return if (!statement.converterExists())
        "Converter ${statement.info.nestedAvroConverterName} was not generated"
    else
        try {
            Callchains.addCall(converterSignature, statement.info.converterSignature)
            null
        } catch (ex: Callchains.InfiniteRecursionException) {
            ex.message!!
        }
}

private object Callchains {
    private val callchains = mutableMapOf<String, MutableList<String>>()

    fun addCall(caller: String, callee: String) {
        ensureNoRecursion(caller, callee)
        if (caller !in callchains)
            callchains[caller] = mutableListOf()
        callchains[caller]!!.add(callee)
    }

    private fun ensureNoRecursion(caller: String, callee: String) {
        if (caller == callee)
            throw InfiniteRecursionException(caller, callee)

        val calleeChain = callchains[callee] ?: return
        if (caller in calleeChain)
            throw InfiniteRecursionException(caller, callee)
    }

    class InfiniteRecursionException(caller: String, callee: String) : Exception("Invocation of $callee by " +
        "$caller is ${if (callee == caller) "directly" else "indirectly" } recursive and would lead to an infinite " +
        "execution of $caller")

    fun reset() {
        callchains.clear()
    }
}

private open class ConverterCreationException(message: String) : Exception(message)

private class DomainTypeNotFoundException(modeledComplexType: IntermediateComplexType)
    : ConverterCreationException("Domain type for modeled complex type ${modeledComplexType.qualifiedName} was not " +
        "generated")

private class AvroTypeNotFoundException(rootStructure: IntermediateDataStructure, domainType: TypeDeclaration<*>)
    : ConverterCreationException("Avro class corresponding to generated domain class " +
        "${domainType.fullyQualifiedName.get()} was not compiled from Avro schema configured for the modeled root " +
        "structure ${rootStructure.qualifiedName}")

private class AvroConverterForModeledEnumeration(
    targetClass: ClassOrInterfaceDeclaration,
    modeledEnumeration: IntermediateEnumeration,
    rootStructure: IntermediateDataStructure
) : AbstractAvroConverter(targetClass, modeledEnumeration, rootStructure) {
    override fun findDomainType()
        = AvroConversionTypeManager.getJavaTypeGeneratedFromModel(modeledComplexType)
            ?: throw DomainTypeNotFoundException(modeledComplexType)

    override fun findAvroType(rootStructure: IntermediateDataStructure)
        = AvroConversionTypeManager.getJavaTypeCompiledFromSchemaOfRootStructure(rootStructure, domainType.nameAsString)
            ?: throw AvroTypeNotFoundException(rootStructure, domainType)

    override fun getReturnType() = avroType.fullyQualifiedName.get() to emptySet<String>()

    override fun getDomainObjectParameterType() = domainType.nameAsString to setOf(domainType.fullyQualifiedName.get())

    override fun serializeBody() {
        val domainEnumeration = domainType as EnumDeclaration
        val domainEnumerationName = domainEnumeration.nameAsString
        val domainLiterals = domainEnumeration.entries.map { it.nameAsString }.toSet()

        val avroEnumeration = avroType as EnumDeclaration
        val avroEnumerationName = avroEnumeration.fullyQualifiedName.get()
        val avroLiterals = avroEnumeration.entries.map { it.nameAsString }.toSet()

        val sharedLiterals = domainLiterals.filter { it in avroLiterals }.toSet()

        if (sharedLiterals.isEmpty()) {
            setBody("""throw new UnsupportedOperationException("$domainEnumerationName and $avroEnumerationName do """ +
                """not share any eponymous literals")""")
            setBlockComment("Consider overriding this method which always throws an exception upon invocation")
            return
        }

        val caseStatements = sharedLiterals.joinToString("\n") { "case $it: result = $avroEnumerationName.$it; break;" }
        val defaultStatement = """
                default: throw new IllegalArgumentException("Unrecognized literal in Avro conversion of " +
                    $DOMAIN_OBJECT.getClass().getName() + ": " + $DOMAIN_OBJECT);
            """.trimToSingleLine()
        setBody(StaticJavaParser.parseStatement(
            """{
                |$avroEnumerationName result;
                |switch($DOMAIN_OBJECT) {
                |   $caseStatements
                |   $defaultStatement
                |}
                |return result;
            }""".trimMargin()) as BlockStmt)

        val missingComponentsCommentContent = StringBuilder()
        val missingDomainLiterals = domainLiterals.filter { it !in sharedLiterals }.joinToString("\n") { "\t- $it" }
        if (missingDomainLiterals.isNotEmpty())
            missingComponentsCommentContent.appendln("The method will fail for the following input literals:\n" +
                "$missingDomainLiterals\nConsider overriding the method if one or more of these literals require " +
                "Avro conversion.")

        val missingAvroLiterals = avroLiterals.filter { it !in sharedLiterals }.joinToString("\n") { "\t- $it" }
        if (missingAvroLiterals.isNotEmpty())
            missingComponentsCommentContent.append("The following literals of $avroEnumerationName do not have " +
                "corresponding eponymous literals in $domainEnumerationName:\n$missingAvroLiterals\nConsider " +
                "overriding the method if one or more of these literals must be returned.")

        if (missingComponentsCommentContent.isNotEmpty())
            setBlockComment(missingComponentsCommentContent.toString().trim())
    }
}

private class AvroConverterForModeledCollectionType(
    targetClass: ClassOrInterfaceDeclaration,
    private val modeledCollectionType: IntermediateCollectionType,
    rootStructure: IntermediateDataStructure
) : AbstractAvroConverter(targetClass, modeledCollectionType, rootStructure) {
    private lateinit var collectionTypeInfo: CollectionTypeInfo
    private var domainTypeIsCompoundItemClass = false

    override fun beginSignatureCreation() {
        super.beginSignatureCreation()

        try {
            collectionTypeInfo = modeledCollectionType.typeInfo()
        } catch (ex: IllegalArgumentException) {
            throw ConverterCreationException(ex.message!!)
        }

        if (modeledCollectionType.isPrimitiveCollection)
            throw AvroConverterRedundantException(nameAsString, targetClass, "Java type argument of " +
                "${modeledCollectionType.qualifiedName} (${collectionTypeInfo.typeArgumentQualifiedName}) maps to a " +
                "LEMMA primitive type and thus does not require an Avro converter")
    }

    override fun findDomainType() : TypeDeclaration<*> {
        // Try to get compound item class generated for modeled collection type (see CollectionTypeHandler)
        var domainType = AvroConversionTypeManager.getJavaTypeGeneratedFromModel(modeledCollectionType)
        if (domainType != null) {
            domainTypeIsCompoundItemClass = true
            return domainType
        }

        if (collectionTypeInfo.typeArgumentIsPrimitiveBoxedType) {
            return StaticJavaParser.parseTypeDeclaration("class ${collectionTypeInfo.typeArgumentSimpleName} {}")
        }

        // Collection has one field with a complex type because it has no compound item argument (i.e., more than one
        // field)
        val modeledItemType = modeledCollectionType.dataFields.first().type as IntermediateComplexType
        domainType = AvroConversionTypeManager.getJavaTypeGeneratedFromModel(modeledItemType)
        if (domainType != null)
            return domainType

        throw DomainItemTypeNotFoundException(modeledCollectionType, modeledItemType)
    }

    override fun findAvroType(rootStructure: IntermediateDataStructure) : TypeDeclaration<*> {
        /*val avroType = if (!listTypeInfo.typeArgumentIsPrimitiveBoxedType)
                AvroConversionTypeManager.getJavaTypeCompiledFromSchemaOfRootStructure(rootStructure,
                    modeledListType.name)
            else
                 StaticJavaParser.parseTypeDeclaration("class ${listTypeInfo.typeArgumentSimpleName} {}")

        return avroType ?: throw AvroListTypeNotFoundException(rootStructure, modeledListType)*/
        return AvroConversionTypeManager.getJavaTypeCompiledFromSchemaOfRootStructure(rootStructure,
            modeledCollectionType.name) ?:
                throw AvroCollectionTypeNotFoundException(rootStructure, modeledCollectionType)
    }

    override fun getReturnType()
        = "${collectionTypeInfo.collectionTypeSimpleName}<${avroType.fullyQualifiedName.get()}>" to
            setOf(collectionTypeInfo.collectionTypeQualifiedName)

    override fun getDomainObjectParameterType()
        = "${collectionTypeInfo.collectionTypeSimpleName}<${domainType.nameAsString}>" to collectionTypeInfo.imports

    override fun deriveBody() : List<AvroSetterWithNestedAvroConverterInvocationInfo> {
        val nestedInvocationInformation = mutableListOf<AvroSetterWithNestedAvroConverterInvocationInfo>()
        val missingSetterInvocationMessages = StringBuilder()
        val domainClass = domainType as ClassOrInterfaceDeclaration
        val avroClass = avroType as ClassOrInterfaceDeclaration

        for (field in modeledCollectionType.dataFields) {
            val domainGetter = domainClass.getExistingGetter(field)
            // A compound item domain class will have a getter. However, for a list of a single complex typed field,
            // there is no getter to search for in the domain class. Instead, the object of the domain entry itself is
            // the source of information to set on the Avro class.
            val domainEntryIsInformationSource = domainGetter == null && !domainTypeIsCompoundItemClass
            if (domainGetter == null && domainTypeIsCompoundItemClass) {
                missingSetterInvocationMessages.appendln("Generated domain class " +
                    "${domainClass.fullyQualifiedName.get()} does not comprise a getter for the modeled field " +
                    "${field.qualifiedName} and its type ${field.type.name} of kind ${field.type.kind.literal} and " +
                    "origin ${field.type.origin}")
                continue
            }

            val avroSetterAndResolvedParameterType = avroClass.findAvroSetter(rootStructure, field)
            if (avroSetterAndResolvedParameterType == null) {
                missingSetterInvocationMessages.appendln("Schema-compiled Avro class " +
                    "${avroClass.fullyQualifiedName.get()} does not comprise a setter corresponding to the modeled field " +
                    "${field.qualifiedName} and its type ${field.type.name} of kind ${field.type.kind.literal} and " +
                    "origin ${field.type.origin}")
                continue
            }

            val (avroSetter, avroSetterParameterType) = avroSetterAndResolvedParameterType
            if (avroSetterParameterType is IntermediateComplexType) {
                val nestedInfo = if (domainEntryIsInformationSource)
                        AvroSetterWithNestedAvroConverterInvocationInfo(this, DOMAIN_ENTRY, avroSetter,
                            avroSetterParameterType)
                    else
                        AvroSetterWithNestedAvroConverterInvocationInfo(this, domainGetter!!, avroSetter,
                            avroSetterParameterType)

                nestedInvocationInformation.add(nestedInfo)
                addAvroObjectInitializationStatement(nestedInfo.newExpression(AVRO_ENTRY))
            } else if (avroSetter.parameters.first().typeAsString == "java.time.Instant" &&
                (domainEntryIsInformationSource || domainGetter!!.typeAsString != "Instant")) {
                val domainInfoSource = if (domainEntryIsInformationSource)
                        DOMAIN_ENTRY
                    else
                        "$DOMAIN_ENTRY.${domainGetter!!.nameAsString}()"
                val avroSetterArgument = "$domainInfoSource.toInstant()"
                val avroSetterCall = "$AVRO_ENTRY.${avroSetter.nameAsString}($avroSetterArgument);"
                addAvroObjectInitializationStatement(StaticJavaParser.parseStatement(avroSetterCall))
            } else {
                val domainInfoSource = if (domainEntryIsInformationSource)
                        DOMAIN_ENTRY
                    else
                        "$DOMAIN_ENTRY.${domainGetter!!.nameAsString}()"
                val avroSetterCall = "$AVRO_ENTRY.${avroSetter.nameAsString}($domainInfoSource);"
                addAvroObjectInitializationStatement(StaticJavaParser.parseStatement(avroSetterCall))
            }
        }

        if (missingSetterInvocationMessages.isNotEmpty())
            setBlockComment("Missing Avro setter invocations:\n" + missingSetterInvocationMessages.toString().trim())

        return nestedInvocationInformation
    }

    override fun serializeBody() = serializeAvroObjectInitializationStatements() {
            StaticJavaParser.parseStatement(
                    """
                        |for (var $DOMAIN_ENTRY : $DOMAIN_OBJECT) {
                        |   var $AVRO_ENTRY = new ${avroType.fullyQualifiedName.get()}();
                        |   ${it.joinToString("\n") { it.toString() }}
                        |   $AVRO_OBJECT.add($AVRO_ENTRY);
                        |}   
                    """.trimMargin())

            /*val forEachContainer = StaticJavaParser.parseStatement("for (var domainEntry : domainObject) { }")
                as ForEachStmt
            val forEachBody = BlockStmt()
            forEachBody.statements.add(
                StaticJavaParser.parseStatement("var $AVRO_ENTRY = new ${avroType.fullyQualifiedName.get()}();")
            )
            forEachBody.statements.addAll(it)
            forEachBody.statements.add(
                StaticJavaParser.parseStatement("$AVRO_OBJECT.add($AVRO_ENTRY);")
            )
            forEachContainer.body = forEachBody
            forEachContainer*/
        }
}

private fun IntermediateCollectionType.typeInfo() : CollectionTypeInfo {
    val (itemClassnames, _) = getItemClassnamesAndImports()
    // FIXME: Currently, we do not support collection types which require more than one type argument, e.g., maps
    require(itemClassnames.size == 1) {
        "Modeled collection type $qualifiedName requires more than one Java item class which is currently not " +
        "supported for Avro converter generation"
    }

    val typeMapping = getTypeMapping()!!

    val effectivePrimitiveTypeArgumentMapping = typeArgumentObjectWrapperMapping()
    val typeArgumentQualifiedName = effectivePrimitiveTypeArgumentMapping?.fullyQualifiedMappedTypeName
        ?: typeMapping.getImports().first {
            val simpleTypeName = it.substringAfterLast(".")
            itemClassnames.first().startsWith(simpleTypeName)
        }

    val collectionTypeQualifiedName = typeMapping.getImports().first {
            val simpleTypeName = it.substringAfterLast(".")
            typeMapping.mappedTypeName.startsWith(simpleTypeName)
        }

    return CollectionTypeInfo(
        typeMapping.mappedTypeName,
        typeMapping.fullyQualifiedMappedTypeName!!,
        collectionTypeQualifiedName.substringAfterLast("."),
        collectionTypeQualifiedName,
        typeArgumentQualifiedName.substringAfterLast("."),
        typeArgumentQualifiedName,
        typeArgumentObjectWrapperMapping() != null,
        typeMapping.getImports()
    )
}

private data class CollectionTypeInfo(
    val simpleName: String,
    val fullyQualifiedName: String,
    val collectionTypeSimpleName: String,
    val collectionTypeQualifiedName: String,
    val typeArgumentSimpleName: String,
    val typeArgumentQualifiedName: String,
    val typeArgumentIsPrimitiveBoxedType: Boolean,
    val imports: Set<String>
)

private class DomainItemTypeNotFoundException(
    modeledCollectionType: IntermediateCollectionType,
    modeledItemType: IntermediateComplexType
) : ConverterCreationException("Domain type for item type ${modeledItemType.name} of modeled collection type " +
        "${modeledCollectionType.qualifiedName} was not generated")

private class AvroCollectionTypeNotFoundException(
    rootStructure: IntermediateDataStructure,
    modeledCollectionType: IntermediateCollectionType
) : ConverterCreationException("Avro class corresponding to modeled collection type " +
    "${modeledCollectionType.qualifiedName} was not compiled from Avro schema configured for the modeled root "+
    "structure ${rootStructure.qualifiedName}")

private abstract class AbstractDomainConverter(
    val targetClass: ClassOrInterfaceDeclaration,
    val modeledComplexType: IntermediateComplexType,
    val rootStructure: IntermediateDataStructure
) : MethodDeclaration() {
    lateinit var converterSignature: String
    lateinit var domainType: TypeDeclaration<*>
    lateinit var avroType: TypeDeclaration<*>

    fun createSignature() {
        name = SimpleName(modeledComplexType.domainConverterName())
        addModifier(Modifier.Keyword.PUBLIC)
        addSerializationCharacteristic(SerializationCharacteristic.REMOVE_ON_RELOCATION)

        beginSignatureCreation()

        domainType = findDomainType()
        avroType = findAvroType(rootStructure)
        val (returnType, returnTypeImports) = getReturnType()
        val (avroObjectParameterType, avroObjectParameterTypeImports) = getAvroObjectParameterType()

        setType(returnType)
        addParameter(avroObjectParameterType, AVRO_OBJECT)
        if (targetClass.findMethod(nameAsString, avroObjectParameterType) != null)
            throw DomainConverterExistsException(nameAsString, targetClass)
        converterSignature = domainConverterSignature(targetClass, nameAsString, avroObjectParameterType)

        // Add method to super class here to enable propagation of import statements
        targetClass.addMember(this)
        val typeImports = mutableSetOf<String>()
        typeImports.addAll(returnTypeImports)
        typeImports.addAll(avroObjectParameterTypeImports)
        typeImports.forEach { addRelocatableImport(it, ImportTargetElementType.METHOD) }
    }

    protected open fun beginSignatureCreation() {
        // NOOP
    }

    protected abstract fun findDomainType() : TypeDeclaration<*>

    protected abstract fun findAvroType(rootStructure: IntermediateDataStructure) : TypeDeclaration<*>

    protected abstract fun getReturnType() : Pair<String, Set<String>>

    protected abstract fun getAvroObjectParameterType() : Pair<String, Set<String>>

    open fun deriveBody() = emptyList<DomainParameterWithNestedDomainConverterInvocationInfo>()

    abstract fun serializeBody()
}

private fun IntermediateComplexType.domainConverterName() = DOMAIN_CONVERTER_PREFIX + name.capitalize()

private class DomainConverterExistsException(domainConverterName: String, targetClass: ClassOrInterfaceDeclaration)
    : Exception("Domain converter $domainConverterName already exists in class ${targetClass.fullyQualifiedName.get()}")

private class DomainConverterRedundantException(domainConverterName: String, targetClass: ClassOrInterfaceDeclaration,
    reason: String)
    : Exception("Domain converter ${targetClass.fullyQualifiedName.get()}.$domainConverterName is redundant: $reason")

private fun domainConverterSignature(domainConverterClass: ClassOrInterfaceDeclaration, domainConverterName: String,
    avroParameterType: String)
    = "${domainConverterClass.fullyQualifiedName.get()}.$domainConverterName(${avroParameterType})"

private class DomainConverterForModeledStructure(
    targetClass: ClassOrInterfaceDeclaration,
    private val modeledStructure: IntermediateDataStructure,
    rootStructure: IntermediateDataStructure
) : AbstractDomainConverter(targetClass, modeledStructure, rootStructure) {
    private var emptyConstructor: ConstructorDeclaration? = null
    private val fieldConstructors = mutableMapOf<ConstructorDeclaration, List<IntermediateDataField>>()
    private val constructorArgumentStatements = mutableMapOf<ConstructorDeclaration, List<Statement>>()

    override fun findDomainType()
        = AvroConversionTypeManager.getJavaTypeGeneratedFromModel(modeledComplexType)
            ?: throw DomainTypeNotFoundException(modeledComplexType)

    override fun findAvroType(rootStructure: IntermediateDataStructure)
        = AvroConversionTypeManager.getJavaTypeCompiledFromSchemaOfRootStructure(rootStructure, domainType.nameAsString)
            ?: throw AvroTypeNotFoundException(rootStructure, domainType)

    override fun getReturnType() = domainType.nameAsString to setOf(domainType.fullyQualifiedName.get())

    override fun getAvroObjectParameterType() = avroType.fullyQualifiedName.get() to emptySet<String>()

    override fun deriveBody() : List<DomainParameterWithNestedDomainConverterInvocationInfo> {
        val nestedInvocationInformation = mutableListOf<DomainParameterWithNestedDomainConverterInvocationInfo>()

        val domainClass = domainType as ClassOrInterfaceDeclaration
        emptyConstructor = domainClass.constructors.firstOrNull {
                it.hasModifier(Modifier.Keyword.PUBLIC) &&
                it.parameters.isEmpty()
            }

        val avroRelevantFields = modeledStructure.avroRelevantFields().associateBy { it.name }
        val avroRelevantAttributes = domainClass.attributes
            .filter { it.nameAsString in avroRelevantFields }
            .associate { it.nameAsString to it.type }

        for (constructor in domainClass.constructors) {
            if (constructor.parameters.isEmpty())
                continue

            val coveredAvroRelevantFields = mutableListOf<IntermediateDataField>()
            var onlyAvroRelevantFieldsCovered = true
            for (parameter in constructor.parameters) {
                val correspondingAttributeType = avroRelevantAttributes[parameter.nameAsString]
                if (correspondingAttributeType == null || parameter.type != correspondingAttributeType) {
                    onlyAvroRelevantFieldsCovered = false
                    break
                }

                coveredAvroRelevantFields.add(avroRelevantFields[parameter.nameAsString]!!)
            }

            if (!onlyAvroRelevantFieldsCovered)
                continue

            fieldConstructors[constructor] = coveredAvroRelevantFields
        }

        val avroClass = avroType as ClassOrInterfaceDeclaration
        for ((constructor, coveredFields) in fieldConstructors) {
            val argumentStatements = mutableListOf<Statement>()
            for (field in coveredFields) {
                val avroGetterAndResolvedReturnType = avroClass.findAvroGetter(rootStructure, field) ?: continue
                val (avroGetter, avroGetterReturnType) = avroGetterAndResolvedReturnType

                if (avroGetterReturnType is IntermediateCollectionType && avroGetterReturnType.isPrimitiveCollection) {
                    val collectionTypeInfo = avroGetterReturnType.typeInfo()
                    val avroTypeArgument = (avroGetter.type as ClassOrInterfaceType).typeArguments.get().first()
                        .asString()
                    val avroGetterCall = if (avroTypeArgument == "java.time.Instant" &&
                        collectionTypeInfo.typeArgumentQualifiedName != "java.time.Instant") {
                        val collectorsFactoryMethod = when (avroGetterReturnType.instantiableClassName) {
                            "java.util.ArrayList", "java.util.LinkedList" -> "toList"
                            "java.util.HashSet" -> "toSet"
                            else -> null
                        } ?: continue

                        addRelocatableImport("java.util.Date", ImportTargetElementType.METHOD_BODY)
                        addRelocatableImport("java.util.stream.Collectors", ImportTargetElementType.METHOD_BODY)
                        "$AVRO_OBJECT.${avroGetter.nameAsString}().stream().map(Date::from)" +
                            ".collect(Collectors.$collectorsFactoryMethod())"
                    } else
                        "$AVRO_OBJECT.${avroGetter.nameAsString}()"

                    argumentStatements.add(ExpressionStmt(StaticJavaParser.parseExpression(avroGetterCall)))
                    continue
                }

                if (avroGetterReturnType is IntermediateComplexType) {
                    val nestedInfo = DomainParameterWithNestedDomainConverterInvocationInfo(this, avroGetter,
                        avroGetterReturnType)
                    nestedInvocationInformation.add(nestedInfo)
                    argumentStatements.add(nestedInfo.newExpression())
                } else if (avroGetter.typeAsString == "java.time.Instant" &&
                    // Comparing for equality with ignore case to cover technology-specific "Date" type
                    field.type.name.equals(PrimitiveTypeConstants.DATE.literal, ignoreCase = true)) {
                    val avroGetterCall = "Date.from($AVRO_OBJECT.${avroGetter.nameAsString}())"
                    addRelocatableImport("java.util.Date", ImportTargetElementType.METHOD_BODY)
                    argumentStatements.add(ExpressionStmt(StaticJavaParser.parseExpression(avroGetterCall)))
                } else {
                    val avroGetterCall = "$AVRO_OBJECT.${avroGetter.nameAsString}()"
                    argumentStatements.add(ExpressionStmt(StaticJavaParser.parseExpression(avroGetterCall)))
                }
            }
            constructorArgumentStatements[constructor] = argumentStatements
        }

        return nestedInvocationInformation
    }

    override fun serializeBody() {
        var constructorAndArgumentStatements: Pair<ConstructorDeclaration, List<Statement>>? = null

        val fieldConstructorsByLength = fieldConstructors.entries
            .sortedByDescending { (_, fields) -> fields.size }
            .map { it.key }
        for (fieldConstructor in fieldConstructorsByLength) {
            val argumentStatements = constructorArgumentStatements[fieldConstructor]!!
            val allStatementsValid = argumentStatements.all { checkDomainParameterStatementIsValid(it) == null }
            if (allStatementsValid) {
                constructorAndArgumentStatements = fieldConstructor to argumentStatements
                break
            }
        }

        if (constructorAndArgumentStatements == null && emptyConstructor != null)
            constructorAndArgumentStatements = emptyConstructor!! to emptyList()

        if (constructorAndArgumentStatements != null) {
            val (constructor, argumentStatements) = constructorAndArgumentStatements
            val constructorParameters = argumentStatements.joinToString(", ") { it.toString().removeSuffix(";") }
            appendStatement("return new ${constructor.nameAsString}($constructorParameters);")

            if (constructor == emptyConstructor)
                setBlockComment("Domain converter invokes empty constructor because there are no constructors in " +
                    "${domainType.fullyQualifiedName.get()} with parameters being compatible to the getters in " +
                    avroType.fullyQualifiedName.get())
        } else {
            appendStatement("return null;")
            setBlockComment("Domain converter returns null because ${domainType.fullyQualifiedName.get()} neither " +
                "has constructors compatible to the getters in ${avroType.fullyQualifiedName.get()} nor has it an " +
                "empty constructor")
        }
    }
}

private fun AbstractDomainConverter.checkDomainParameterStatementIsValid(statement: Statement) : String? {
    if (statement !is DomainParameterWithNestedDomainConverterExpression)
        return null

    return if (!statement.converterExists())
        "Converter ${statement.info.nestedDomainConverterName} was not generated"
    else
        try {
            Callchains.addCall(converterSignature, statement.info.converterSignature)
            null
        } catch (ex: Callchains.InfiniteRecursionException) {
            ex.message!!
        }
}

private fun ClassOrInterfaceDeclaration.findAvroGetter(rootStructure: IntermediateDataStructure,
    modeledField: IntermediateDataField)
    = findAvroMethod(rootStructure, modeledField, ClassOrInterfaceDeclaration::getExistingGetter)

private fun ClassOrInterfaceDeclaration.findAvroSetter(rootStructure: IntermediateDataStructure,
    modeledField: IntermediateDataField)
    = findAvroMethod(rootStructure, modeledField, ClassOrInterfaceDeclaration::getExistingSetter)

private class DomainParameterWithNestedDomainConverterInvocationInfo(
    caller: AbstractDomainConverter,
    private val avroGetter: MethodDeclaration,
    val typeToReturn: IntermediateComplexType
) {
    val nestedDomainConverterName: String = typeToReturn.domainConverterName()
    val converterSignature = domainConverterSignature(caller.targetClass, nestedDomainConverterName,
        avroGetter.typeAsString)
    private val expressions = mutableListOf<DomainParameterWithNestedDomainConverterExpression>()
    private var nestedDomainConverterCreated = false

    /*override fun equals(other: Any?)
        = if (this === other) true
            else if (other == null) false
            else if (other is AvroSetterWithNestedAvroConverterInvocationInfo) signature() == other.signature()
            else false*/

    //override fun hashCode() = signature().hashCode()

    fun newExpression(avroObjectName: String = AVRO_OBJECT) : DomainParameterWithNestedDomainConverterExpression {
        val domainConverterCall = "$nestedDomainConverterName($avroObjectName.${avroGetter.nameAsString}())"
        val newExpression = DomainParameterWithNestedDomainConverterExpression(this, domainConverterCall)
        expressions.add(newExpression)
        return newExpression
    }

    fun setNestedDomainConverterCreated() {
        nestedDomainConverterCreated = true
        expressions.forEach { it.setConverterExists() }
    }

    fun mergeWith(other: DomainParameterWithNestedDomainConverterInvocationInfo) {
        expressions.addAll(other.expressions)
    }
}

private class DomainParameterWithNestedDomainConverterExpression(
    val info: DomainParameterWithNestedDomainConverterInvocationInfo,
    domainConverterCall: String
) : ExpressionStmt(StaticJavaParser.parseExpression(domainConverterCall)) {
    private var converterExists = false

    fun setConverterExists() {
        converterExists = true
    }

    fun converterExists() = converterExists
}

private class DomainConverterForModeledCollectionType(
    targetClass: ClassOrInterfaceDeclaration,
    private val modeledCollectionType: IntermediateCollectionType,
    rootStructure: IntermediateDataStructure
) : AbstractDomainConverter(targetClass, modeledCollectionType, rootStructure) {
    private lateinit var collectionTypeInfo: CollectionTypeInfo
    private var domainTypeIsCompoundItemClass = false
    private var entryInitializationStatement: Statement? = null
    private var emptyConstructor: ConstructorDeclaration? = null
    private val fieldConstructors = mutableMapOf<ConstructorDeclaration, List<IntermediateDataField>>()
    private val constructorArgumentStatements = mutableMapOf<ConstructorDeclaration, List<Statement>>()

    override fun beginSignatureCreation() {
        super.beginSignatureCreation()

        try {
            collectionTypeInfo = modeledCollectionType.typeInfo()
        } catch (ex: IllegalArgumentException) {
            throw ConverterCreationException(ex.message!!)
        }

        if (modeledCollectionType.isPrimitiveCollection)
            throw DomainConverterRedundantException(nameAsString, targetClass, "Java type argument of " +
                "${modeledCollectionType.qualifiedName} (${collectionTypeInfo.typeArgumentQualifiedName}) maps to a " +
                "LEMMA primitive type and thus does not require a domain converter")
    }

    override fun findDomainType() : TypeDeclaration<*> {
        // Try to get compound item class generated for modeled collection type (see CollectionTypeHandler)
        var domainType = AvroConversionTypeManager.getJavaTypeGeneratedFromModel(modeledCollectionType)
        if (domainType != null) {
            domainTypeIsCompoundItemClass = true
            return domainType
        }

        if (collectionTypeInfo.typeArgumentIsPrimitiveBoxedType) {
            return StaticJavaParser.parseTypeDeclaration("class ${collectionTypeInfo.typeArgumentSimpleName} {}")
        }

        val modeledItemType = modeledCollectionType.dataFields.first().type as IntermediateComplexType
        domainType = AvroConversionTypeManager.getJavaTypeGeneratedFromModel(modeledItemType)
        if (domainType != null)
            return domainType

        throw DomainItemTypeNotFoundException(modeledCollectionType, modeledItemType)
    }

    override fun findAvroType(rootStructure: IntermediateDataStructure)
        = AvroConversionTypeManager.getJavaTypeCompiledFromSchemaOfRootStructure(rootStructure,
            modeledCollectionType.name)
                ?: throw AvroCollectionTypeNotFoundException(rootStructure, modeledCollectionType)

    override fun getReturnType() = "${collectionTypeInfo.collectionTypeSimpleName}<${domainType.nameAsString}>" to
        collectionTypeInfo.imports

    override fun getAvroObjectParameterType()
        // Use fully-qualified collection type name here because the generated Avro getter signature also specifies the
        // fully-qualified collection type
        = "${collectionTypeInfo.collectionTypeQualifiedName}<${avroType.fullyQualifiedName.get()}>" to
            setOf(collectionTypeInfo.collectionTypeQualifiedName)

    override fun deriveBody() : List<DomainParameterWithNestedDomainConverterInvocationInfo> {
        val domainClass = domainType as ClassOrInterfaceDeclaration
        emptyConstructor = domainClass.constructors.firstOrNull {
                it.hasModifier(Modifier.Keyword.PUBLIC) &&
                it.parameters.isEmpty()
            }

        if (avroType.nameAsString == "MyDateComplexCollection")
            println()

        val avroClass = avroType as ClassOrInterfaceDeclaration
        if (!domainTypeIsCompoundItemClass) {
            // There can only be one field in this case which must also have a complex type
            val field = modeledCollectionType.dataFields.first()
            val avroGetterAndResolvedReturnType = avroClass.findAvroGetter(rootStructure, field)
            if (avroGetterAndResolvedReturnType == null) {
                setBlockComment("Domain converter does not return an initialized domain object because the " +
                    "schema-compiled Avro class ${avroClass.fullyQualifiedName.get()} does not comprise a getter " +
                    "corresponding to the modeled ${field.qualifiedName} and its type ${field.type.name} of kind " +
                    "${field.type.kind.literal} and origin ${field.type.origin}")
                return emptyList()
            }

            val (avroGetter, resolvedReturnType) = avroGetterAndResolvedReturnType
            if (resolvedReturnType is IntermediateComplexType) {
                val nestedInfo = DomainParameterWithNestedDomainConverterInvocationInfo(this, avroGetter,
                    resolvedReturnType)
                entryInitializationStatement = nestedInfo.newExpression(AVRO_ENTRY)
                return listOf(nestedInfo)
            } else if (avroGetter.typeAsString == "java.time.Instant" &&
                // Comparing for equality with ignore case to cover technology-specific "Date" type
                field.type.name.equals(PrimitiveTypeConstants.DATE.literal, ignoreCase = true)) {
                val avroGetterCall = "Date.from($AVRO_ENTRY.${avroGetter.nameAsString}())"
                addRelocatableImport("java.util.Date", ImportTargetElementType.METHOD_BODY)
                entryInitializationStatement = ExpressionStmt(StaticJavaParser.parseExpression(avroGetterCall))
                return emptyList()
            } else {
                val avroGetterCall = "$AVRO_ENTRY.${avroGetter.nameAsString}()"
                entryInitializationStatement = ExpressionStmt(StaticJavaParser.parseExpression(avroGetterCall))
                return emptyList()
            }
        }

        // Version for compound item classes
        val avroRelevantFields = modeledCollectionType.dataFields.associateBy { it.name }
        val avroRelevantAttributes = domainClass.attributes
            .filter { it.nameAsString in avroRelevantFields }
            .associate { it.nameAsString to it.type }

        for (constructor in domainClass.constructors) {
            if (constructor.parameters.isEmpty())
                continue

            val coveredAvroRelevantFields = mutableListOf<IntermediateDataField>()
            var onlyAvroRelevantFieldsCovered = true
            for (parameter in constructor.parameters) {
                val correspondingAttributeType = avroRelevantAttributes[parameter.nameAsString]
                if (correspondingAttributeType == null || parameter.type != correspondingAttributeType) {
                    onlyAvroRelevantFieldsCovered = false
                    break
                }

                coveredAvroRelevantFields.add(avroRelevantFields[parameter.nameAsString]!!)
            }

            if (!onlyAvroRelevantFieldsCovered)
                continue

            fieldConstructors[constructor] = coveredAvroRelevantFields
        }

        val nestedInvocationInformation = mutableListOf<DomainParameterWithNestedDomainConverterInvocationInfo>()
        for ((constructor, coveredFields) in fieldConstructors) {
            val argumentStatements = mutableListOf<Statement>()
            for (field in coveredFields) {
                val avroGetterAndResolvedReturnType = avroClass.findAvroGetter(rootStructure, field) ?: continue
                val (avroGetter, avroGetterReturnType) = avroGetterAndResolvedReturnType
                if (avroGetterReturnType is IntermediateComplexType) {
                    val nestedInfo = DomainParameterWithNestedDomainConverterInvocationInfo(this, avroGetter,
                        avroGetterReturnType)
                    nestedInvocationInformation.add(nestedInfo)
                    argumentStatements.add(nestedInfo.newExpression(AVRO_ENTRY))
                } else if (avroGetter.typeAsString == "java.time.Instant" &&
                    // Comparing for equality with ignore case to cover technology-specific "Date" type
                    field.type.name.equals(PrimitiveTypeConstants.DATE.literal, ignoreCase = true)) {
                    val avroGetterCall = "Date.from($AVRO_ENTRY.${avroGetter.nameAsString}())"
                    addRelocatableImport("java.util.Date", ImportTargetElementType.METHOD_BODY)
                    argumentStatements.add(ExpressionStmt(StaticJavaParser.parseExpression(avroGetterCall)))
                } else {
                    val avroGetterCall = "$AVRO_ENTRY.${avroGetter.nameAsString}()"
                    argumentStatements.add(ExpressionStmt(StaticJavaParser.parseExpression(avroGetterCall)))
                }
            }
            constructorArgumentStatements[constructor] = argumentStatements
        }
        return nestedInvocationInformation
    }

    override fun serializeBody() {
        val hasInitializationStatement = entryInitializationStatement != null
        val initializationStatementValidationError = if (hasInitializationStatement)
                checkDomainParameterStatementIsValid(entryInitializationStatement!!)
            else
                null

        val instantiableType = modeledCollectionType.instantiableClassName
        addRelocatableImport(instantiableType, ImportTargetElementType.METHOD_BODY)
        val instantiableSimpleType = instantiableType.substringAfterLast(".")
        val domainCollectionInstantiationExpression = "new $instantiableSimpleType<${domainType.nameAsString}>()"

        if (!domainTypeIsCompoundItemClass) {
            if (!hasInitializationStatement || initializationStatementValidationError != null) {
                appendStatement("return $domainCollectionInstantiationExpression;")

                if (initializationStatementValidationError != null)
                    appendBlockComment(initializationStatementValidationError)
            } else
                setBody(StaticJavaParser.parseStatement(
                    """{
                        |var $DOMAIN_OBJECT = $domainCollectionInstantiationExpression;
                        |for (var $AVRO_ENTRY : $AVRO_OBJECT)
                        |   $DOMAIN_OBJECT.add(${entryInitializationStatement.toString().removeSuffix(";")});
                        |return $DOMAIN_OBJECT;   
                    }""".trimMargin()) as BlockStmt)

            return
        }

        // Version for compound item classes
        var constructorAndArgumentStatements: Pair<ConstructorDeclaration, List<Statement>>? = null

        val fieldConstructorsByLength = fieldConstructors.entries
            .sortedByDescending { (_, fields) -> fields.size }
            .map { it.key }
        for (fieldConstructor in fieldConstructorsByLength) {
            val argumentStatements = constructorArgumentStatements[fieldConstructor]!!
            val allStatementsValid = argumentStatements.all { checkDomainParameterStatementIsValid(it) == null }
            if (allStatementsValid) {
                constructorAndArgumentStatements = fieldConstructor to argumentStatements
                break
            }
        }

        if (constructorAndArgumentStatements == null && emptyConstructor != null)
            constructorAndArgumentStatements = emptyConstructor!! to emptyList()

        if (constructorAndArgumentStatements != null) {
            val (constructor, argumentStatements) = constructorAndArgumentStatements
            val constructorParameters = argumentStatements.joinToString(", ") { it.toString().removeSuffix(";") }
            val itemClassConstructorCall = "new ${constructor.nameAsString}($constructorParameters)"
            setBody(StaticJavaParser.parseStatement(
                    """{
                        |var $DOMAIN_OBJECT = $domainCollectionInstantiationExpression;
                        |for (var $AVRO_ENTRY : $AVRO_OBJECT)
                        |   $DOMAIN_OBJECT.add($itemClassConstructorCall);
                        |return $DOMAIN_OBJECT;   
                    }""".trimMargin()) as BlockStmt)

            if (constructor == emptyConstructor)
                setBlockComment("Domain converter initializes $DOMAIN_OBJECT entries with empty constructor because " +
                    "there are no constructors in ${domainType.fullyQualifiedName.get()} with parameters being " +
                    "compatible to the getters in ${avroType.fullyQualifiedName.get()}")
        } else {
            appendStatement("return null;")
            setBlockComment("Domain converter returns null because ${domainType.fullyQualifiedName.get()} neither " +
                "has constructors compatible to the getters in ${avroType.fullyQualifiedName.get()} nor has it an " +
                "empty constructor")
        }
    }
}

private class DomainConverterForModeledEnumeration(
    targetClass: ClassOrInterfaceDeclaration,
    modeledEnumeration: IntermediateEnumeration,
    rootStructure: IntermediateDataStructure
) : AbstractDomainConverter(targetClass, modeledEnumeration, rootStructure) {
    override fun findDomainType()
        = AvroConversionTypeManager.getJavaTypeGeneratedFromModel(modeledComplexType)
            ?: throw DomainTypeNotFoundException(modeledComplexType)

    override fun findAvroType(rootStructure: IntermediateDataStructure)
        = AvroConversionTypeManager.getJavaTypeCompiledFromSchemaOfRootStructure(rootStructure, domainType.nameAsString)
            ?: throw AvroTypeNotFoundException(rootStructure, domainType)

    override fun getReturnType() = domainType.nameAsString to setOf(domainType.fullyQualifiedName.get())

    override fun getAvroObjectParameterType() = avroType.fullyQualifiedName.get() to emptySet<String>()

    override fun serializeBody() {
        val domainEnumeration = domainType as EnumDeclaration
        val domainEnumerationName = domainEnumeration.nameAsString
        val domainLiterals = domainEnumeration.entries.map { it.nameAsString }.toSet()

        val avroEnumeration = avroType as EnumDeclaration
        val avroEnumerationName = avroEnumeration.fullyQualifiedName.get()
        val avroLiterals = avroEnumeration.entries.map { it.nameAsString }.toSet()

        val sharedLiterals = domainLiterals.filter { it in avroLiterals }.toSet()

        if (sharedLiterals.isEmpty()) {
            setBody("""throw new UnsupportedOperationException("$domainEnumerationName and $avroEnumerationName do """ +
                """not share any eponymous literals")""")
            setBlockComment("Consider overriding this method which always throws an exception upon invocation")
            return
        }

        val caseStatements = sharedLiterals.joinToString("\n") {
                "case $it: result = ${domainEnumerationName}.$it; break;"
            }
        val defaultStatement = """
                default: throw new IllegalArgumentException("Unrecognized literal in domain conversion of " +
                    $AVRO_OBJECT.getClass().getName() + ": " + $AVRO_OBJECT);
            """.trimToSingleLine()

        setBody(StaticJavaParser.parseStatement(
            """{
                |$domainEnumerationName result;
                |switch($AVRO_OBJECT) {
                |   $caseStatements
                |   $defaultStatement
                |}
                |return result;
            }""".trimMargin()) as BlockStmt)

        val missingComponentsCommentContent = StringBuilder()
        val missingDomainLiterals = domainLiterals.filter { it !in sharedLiterals }.joinToString("\n") { "\t- $it" }
        if (missingDomainLiterals.isNotEmpty())
            missingComponentsCommentContent.appendln("The method will fail for the following input literals:\n" +
                "$missingDomainLiterals\nConsider overriding the method if one or more of these literals require " +
                "domain conversion.")

        val missingAvroLiterals = avroLiterals.filter { it !in sharedLiterals }.joinToString("\n") { "\t- $it" }
        if (missingAvroLiterals.isNotEmpty())
            missingComponentsCommentContent.append("The following literals of $avroEnumerationName do not have " +
                "corresponding eponymous literals in $domainEnumerationName:\n$missingAvroLiterals\nConsider " +
                "overriding the method if one or more of these literals must be returned.")

        if (missingComponentsCommentContent.isNotEmpty())
            setBlockComment(missingComponentsCommentContent.toString().trim())
    }
}