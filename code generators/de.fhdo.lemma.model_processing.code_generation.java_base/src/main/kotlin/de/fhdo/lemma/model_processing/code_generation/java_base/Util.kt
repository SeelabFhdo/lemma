package de.fhdo.lemma.model_processing.code_generation.java_base

import de.fhdo.lemma.data.ComplexType
import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.data.DataStructure
import de.fhdo.lemma.data.Enumeration
import de.fhdo.lemma.data.ListType
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.data.intermediate.IntermediateDataModel
import de.fhdo.lemma.data.intermediate.IntermediateDataOperation
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.data.intermediate.IntermediateImportedComplexType
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.DATA_DSL_LANGUAGE_DESCRIPTION
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.SERVICE_DSL_LANGUAGE_DESCRIPTION
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.ServicesContext.State as ServicesState
import de.fhdo.lemma.model_processing.languages.registerLanguage
import de.fhdo.lemma.model_processing.loadXtextResource
import de.fhdo.lemma.model_processing.utils.loadModelRoot
import de.fhdo.lemma.model_processing.utils.mainInterface
import de.fhdo.lemma.model_processing.utils.packageToPath
import de.fhdo.lemma.model_processing.utils.trimToSingleLine
import de.fhdo.lemma.service.Interface
import de.fhdo.lemma.service.Microservice
import de.fhdo.lemma.service.Operation
import de.fhdo.lemma.service.Parameter
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.service.intermediate.IntermediateInterface
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.service.intermediate.IntermediateParameter
import de.fhdo.lemma.service.intermediate.IntermediateReferredOperation
import de.fhdo.lemma.technology.CommunicationType
import de.fhdo.lemma.technology.ExchangePattern
import io.github.classgraph.ClassGraph
import io.github.classgraph.ClassInfo
import org.eclipse.emf.ecore.EObject
import java.lang.IllegalArgumentException

/**
 * Property representing the simple name of an [EObject], e.g., an [IntermediateMicroservice] or
 * [IntermediateInterface].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
val EObject.simpleName
    get() = when(this) {
        is IntermediateMicroservice -> name.substringAfterLast(".")
        is IntermediateInterface -> name.substringAfterLast(".")
        else -> throw IllegalArgumentException("EObject of type ${this.mainInterface.name} does not have a simple name")
    }

/**
 * Property representing the classname of an [EObject], e.g., an [IntermediateMicroservice] or [IntermediateInterface].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
val EObject.classname
    get() = when(this) {
        is IntermediateComplexType -> name.capitalize()
        is IntermediateMicroservice -> simpleName.capitalize()
        is IntermediateInterface -> simpleName.capitalize()
        is IntermediateOperation -> name.capitalize()
        else -> throw IllegalArgumentException("EObject of type ${this.mainInterface.name} does not have a classname")
    }

/**
 * Property representing the Java filename of an [EObject], e.g., an [IntermediateMicroservice] or
 * [IntermediateInterface].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
val EObject.javaFileName
    get() = when(this) {
        is IntermediateMicroservice -> "$classname.java"
        is IntermediateInterface -> "$classname.java"
        else -> throw IllegalArgumentException("EObject of type ${this.mainInterface.name} does not have a simple " +
            "file name")
    }

/**
 * Property representing the qualified name of an [EObject], e.g., a [DataStructure] or [Microservice].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
val EObject.qualifiedName : String
    get() = when(this) {
        is DataStructure -> buildQualifiedName(".")
        is ListType -> buildQualifiedName(".")
        is Enumeration -> buildQualifiedName(".")
        is Microservice -> buildQualifiedName(".")
        is Interface -> buildQualifiedName(".")
        is Operation -> buildQualifiedName(".")
        is Parameter -> buildQualifiedName(".")
        else -> throw IllegalArgumentException("EObject of type ${this.mainInterface.name} does not have a qualified " +
            "name")
    }

/**
 * Property representing the package name of an [EObject], e.g., an [IntermediateComplexType] or an
 * [IntermediateMicroservice]. The package name corresponds to the [fullyQualifiedClassname] without the [classname]
 * part.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val EObject.packageName
    get() = when(this) {
        is IntermediateComplexType -> qualifiedName.substringBeforeLast(".")
        is IntermediateMicroservice -> qualifiedName.substringBeforeLast(".")
        else -> throw IllegalArgumentException("EObject of type ${this.mainInterface.name} does not have a package " +
            "name")
    }

/**
 * Property representing the fully-qualified classname of an [EObject], e.g., an [IntermediateComplexType] or an
 * [IntermediateMicroservice].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
val EObject.fullyQualifiedClassname
    get() = when(this) {
        is IntermediateComplexType -> "$packageName.$classname"
        is IntermediateMicroservice -> "$packageName.$classname"
        else -> throw IllegalArgumentException("EObject of type ${this.mainInterface.name} does not have a " +
            "fully-qualified classname")
    }

/**
 * Get endpoints of an [IntermediateMicroservice], [IntermediateInterface], or [IntermediateOperation] for the given
 * [protocol].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EObject.getEndpoint(protocol: String)
    = when(this) {
        is IntermediateMicroservice -> endpoints.find { it.protocol == protocol }
        is IntermediateInterface -> endpoints.find { it.protocol == protocol }
        is IntermediateOperation -> endpoints.find { it.protocol == protocol }
        else -> throw IllegalArgumentException("EObject of type ${this.mainInterface.name} does not have endpoints")
    }

/**
 * Determine if [IntermediateInterface], [IntermediateOperation], or [IntermediateReferredOperation] makes use of the
 * given [protocol].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EObject.usesProtocol(protocol: String) : Boolean {
    require(this is IntermediateInterface || this is IntermediateOperation || this is IntermediateReferredOperation)
        { "EObject of type ${this.mainInterface.name} does not use protocols" }

    val protocols = when (this) {
        is IntermediateInterface -> protocols
        is IntermediateOperation -> protocols
        is IntermediateReferredOperation -> protocols
        else -> null
    }

    val endpoints = when (this) {
        is IntermediateInterface -> endpoints
        is IntermediateOperation -> endpoints
        is IntermediateReferredOperation -> endpoints
        else -> null
    }

    val operations = when (this) {
        is IntermediateInterface -> operations
        else -> null
    }

    val referredOperations = when (this) {
        is IntermediateInterface -> referredOperations
        else -> null
    }

    return (protocols?.any { it.protocol == protocol } ?: false) ||
        (endpoints?.any { it.protocol == protocol } ?: false) ||
        // The following calls are recursive
        (operations?.any { it.usesProtocol(protocol) } ?: false) ||
        (referredOperations?.any { it.usesProtocol(protocol) } ?: false)
}

/**
 * Get all [IntermediateImportedAspect] instances of this [EObject]. Throws an [IllegalArgumentException] if the
 * [EObject] does not support having aspects.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun EObject.getAllAspects()
    = when(this) {
        is IntermediateDataStructure -> aspects
        is IntermediateDataOperation -> aspects
        is IntermediateMicroservice -> aspects
        else -> throw IllegalArgumentException("EObject of type ${this.mainInterface.name} does not have aspects")
    }

/**
 * Check if an [EObject] has a certain aspect with the given [fullyQualifiedAspectName] assigned. Throws an
 * [IllegalArgumentException] if the [EObject] does not support having aspects.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EObject.hasAspect(fullyQualifiedAspectName: String)
    = getAllAspects().any { it.qualifiedName == fullyQualifiedAspectName }

/**
 * Get the [IntermediateImportedAspect] of this [EObject] with the given [fullyQualifiedAspectName] assigned. Throws an
 * [IllegalArgumentException] if the [EObject] does not support having aspects.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EObject.getAspect(fullyQualifiedAspectName: String)
    = getAllAspects().find { it.qualifiedName == fullyQualifiedAspectName }

/**
 * Iterate over all [IntermediateImportedAspect] instances of this [EObject] with the given [fullyQualifiedAspectName].
 * Throws an [IllegalArgumentException] if the [EObject] does not support having aspects.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EObject.forEachAspect(fullyQualifiedAspectName: String, action: (IntermediateImportedAspect) -> Unit)
    = getAllAspects().forEach { if (it.qualifiedName == fullyQualifiedAspectName) action(it) }

/**
 * Get the value of the property [propertyName] of the aspect [fullyQualifiedAspectName] being specified for this
 * [EObject]. Throws an [IllegalArgumentException] if the [EObject] does not support having aspects.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EObject.getAspectPropertyValue(fullyQualifiedAspectName: String, propertyName: String)
    = getAspect(fullyQualifiedAspectName)?.getPropertyValue(propertyName)

/**
 * Load the original [EObject] of the given intermediate [EObject] from the specified [originalModelFilePath]. The
 * result depends on the concrete runtime type of this [EObject].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun EObject.loadOriginalEObject(originalModelFilePath: String) : EObject {
    val originalEObject = when (this) {
        is IntermediateComplexType -> loadOriginalEObject(originalModelFilePath)
        is IntermediateMicroservice -> loadOriginalEObject(originalModelFilePath)
        is IntermediateInterface -> loadOriginalEObject(originalModelFilePath)
        is IntermediateOperation -> loadOriginalEObject(originalModelFilePath)
        is IntermediateParameter -> loadOriginalEObject(originalModelFilePath)
        else -> throw IllegalArgumentException("Loading original EObject for intermediate EObject of type " +
            "${this.mainInterface.name} is not supported")
    }

    require(originalEObject != null) { "Original EObject of intermediate EObject of type ${this.mainInterface.name} " +
        "could not be loaded" }

    return originalEObject
}

/**
 * Load the root of the model file at the given [modelFilePath], which must point to an Xtext resource.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("UNCHECKED_CAST")
private fun <T: EObject> loadOriginalModelRoot(modelFilePath: String) : T {
    val alreadyLoadedModelRoot = loadedOriginalModelRootsCache[modelFilePath]
    if (alreadyLoadedModelRoot != null)
        return alreadyLoadedModelRoot as T

    val modelFile = modelFilePath.asFile()
    val languageSetup = when (modelFile.extension) {
        "data" -> {
            registerDataDsl()
            DATA_DSL_LANGUAGE_DESCRIPTION.languageSetup
        }
        "services" -> SERVICE_DSL_LANGUAGE_DESCRIPTION.languageSetup
        else -> throw IllegalArgumentException("Line counting in model files with extension ${modelFile.extension} " +
            "is not supported")
    }

    val loadedModel = loadXtextResource(languageSetup, modelFilePath, modelFile.inputStream())
    val loadedModelRoot = loadedModel.contents[0] as T
    loadedOriginalModelRootsCache[modelFilePath] = loadedModelRoot
    return loadedModelRoot
}

/**
 * Flag to indicate whether the [DATA_DSL_LANGUAGE_DESCRIPTION] was already added to the EPackage registry.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private var dataDslRegistered = false

/**
 * Add the [DATA_DSL_LANGUAGE_DESCRIPTION] to the EPackage registry, if this did not happen already.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun registerDataDsl() {
    if (!dataDslRegistered)
        registerLanguage(DATA_DSL_LANGUAGE_DESCRIPTION.nsUri)
    dataDslRegistered = true
}

/**
 * Cache of loaded model roots.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private val loadedOriginalModelRootsCache = mutableMapOf<String, EObject>()

/**
 * [fullyQualifiedClassname] of [IntermediateComplexType] turned into a path. That is, the separating dots are replaced
 * by OS-specific file separators.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateComplexType.fullyQualifiedClasspath(withExtension: Boolean = true)
    = """
        ${fullyQualifiedClassname.packageToPath()}
        ${if (withExtension) ".java" else ""}
      """.trimToSingleLine()

/**
 * Check if an [IntermediateDataField] exhibits a certain feature.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateDataField.hasFeature(feature: String) = featureNames.contains(feature)

/**
 * Resolve the original [IntermediateComplexType] from this instance. To keep the intermediate models is lightweight as
 * possible, references have been omitted where possible. Instead, types, for example, are embedded as containments
 * at most places and the "reference" to the original type is established leveraging the import URI (for
 * [IntermediateImportedComplexType] instances) and the type's [qualifiedName]. This functions allows for finding the
 * original [IntermediateComplexType] to which this [IntermediateComplexType] is referencing.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateComplexType.resolve() : IntermediateComplexType {
    /* Determine the defining model and referencing parts (version name, context name, and simple name) of this type */
    val definingModelUri = if (this is IntermediateImportedComplexType) import.importUri else null
    val definingModel = if (definingModelUri != null) loadModelRoot(definingModelUri) else getContainingDataModel()
    val (versionName, contextName, simpleName) = getQualifiedNameParts()

    /* Determine sources of this type's referencing parts (version and context instances) */
    val version = if (versionName != null) definingModel.versions.find { it.name == versionName } else null

    val context = if (contextName != null) {
        // A context may be part of a version or reside on the top-level of a data model
        if (version != null)
            version.contexts.find { it.name == contextName }
        else
            definingModel.contexts.find { it.name == contextName }
    } else
        null

    /* Resolve the type */
    val resolvedType = if (version != null && context != null)
    // According to its qualified name, the type is defined in a context within a version
        context.complexTypes.find { it.name == simpleName }
    else if (version != null && context == null)
    // According to its qualified name, the type is directly defined in a version
        version.complexTypes.find { it.name == simpleName }
    else if (context != null)
    // According to its qualified name, the type is directly defined in a context
        context.complexTypes.find { it.name == simpleName }
    else
    // There is neither a version nor a context surrounding the type (according to its qualified name), i.e.,
    // the type is defined on the top-level of the model itself
        definingModel.complexTypes.find { it.name == simpleName }

    require(resolvedType != null) { "Complex type $qualifiedName could not be resolved" }
    return resolvedType
}

/**
 * Helper to find the data model that contains the [IntermediateComplexType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun IntermediateComplexType.getContainingDataModel() : IntermediateDataModel {
    var container = eContainer()
    while (container !is IntermediateDataModel)
        container = container.eContainer()
    return container
}

/**
 * Helper to get the parts of the [qualifiedName] of an [IntermediateComplexType]. The result is a [Triple], whose
 *      - first component is the type's version (or null, if the type has no version),
 *      - second component is the type's context (or null, if the type has no context),
 *      - third component is the type's name, without a qualifying part (i.e., its "simple" name).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun IntermediateComplexType.getQualifiedNameParts() : Triple<String?, String?, String> {
    val qualifiedNameParts = qualifiedName.split(".")

    val version = if (qualifiedNameParts.size == 3) qualifiedNameParts[0] else null

    val context = when(qualifiedNameParts.size) {
        3 -> qualifiedNameParts[1]
        2 -> qualifiedNameParts[0]
        else -> null
    }

    val simpleName = when(qualifiedNameParts.size) {
        3 -> qualifiedNameParts[2]
        2 -> qualifiedNameParts[1]
        else -> qualifiedNameParts[0]
    }

    return Triple(version, context, simpleName)
}

/**
 * Load the original [EObject] of this [IntermediateComplexType] from the specified [originalModelFilePath]. The result
 * will be an [EObject] of type [ComplexType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun IntermediateComplexType.loadOriginalEObject(originalModelFilePath: String) : EObject? {
    val modelRoot = loadOriginalModelRoot<DataModel>(originalModelFilePath)
    return modelRoot.containedComplexTypes.find { it.qualifiedName == this.qualifiedName }
}

/**
 * Property that indicates if any of the operations of this [IntermediateMicroservice] has an API comment.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
val IntermediateMicroservice.hasApiComments
    get() = interfaces.map { it.operations }.flatten().any { it.apiOperationComment != null }

/**
 * Load the original [EObject] of this [IntermediateMicroservice] from the specified [originalModelFilePath]. The result
 * will be an [EObject] of type Microservice.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun IntermediateMicroservice.loadOriginalEObject(originalModelFilePath: String) : EObject? {
    val modelRoot = loadOriginalModelRoot<ServiceModel>(originalModelFilePath)
    return modelRoot.microservices.find { it.qualifiedName == this.qualifiedName }
}

/**
 * Load the original [EObject] of this [IntermediateInterface] from the specified [originalModelFilePath]. The result
 * will be an [EObject] of type Interface.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateInterface.loadOriginalEObject(originalModelFilePath: String) : EObject? {
    val modelRoot = loadOriginalModelRoot<ServiceModel>(originalModelFilePath)
    return modelRoot.microservices.map { it.interfaces }.flatten().find { it.qualifiedName == this.qualifiedName }
}

/**
 * Determine if this [IntermediateOperation] has parameters of the specified [communicationType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateOperation.hasParametersOfCommunicationType(communicationType: CommunicationType)
    = parameters.any { it.communicationType == communicationType }

/**
 * Get non-fault parameters of this [IntermediateOperation] having the specified [communicationType] and whose exchange
 * pattern is IN or INOUT.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateOperation.getInputParameters(communicationType: CommunicationType)
    = parameters.filter { it.communicationType == communicationType && it.isInputParameter }

/**
 * Determine if this [IntermediateParameter] is an input parameter, i.e., it has the exchange pattern IN or INOUT and is
 * not a fault parameter.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private val IntermediateParameter.isInputParameter
    get() = !isCommunicatesFault && (exchangePattern == ExchangePattern.INOUT || exchangePattern == ExchangePattern.IN)

/**
 * Get non-optional input parameters of this [IntermediateOperation].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateOperation.getRequiredInputParameters(communicationType: CommunicationType)
    = getInputParameters(communicationType).filter { !it.isOptional }

/**
 * Get fault parameters of this [IntermediateOperation] having the specified [communicationType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateOperation.getFaultParameters(communicationType: CommunicationType)
    = parameters.filter { it.isCommunicatesFault }

/**
 * Get non-fault parameters of this [IntermediateOperation] having the specified [communicationType] and whose exchange
 * pattern is OUT or INOUT.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateOperation.getResultParameters(communicationType: CommunicationType)
    = parameters.filter { it.communicationType == communicationType && it.isResultParameter }

/**
 * Load the original [EObject] of this [IntermediateOperation] from the specified [originalModelFilePath]. The result
 * will be an [EObject] of type Operation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun IntermediateOperation.loadOriginalEObject(originalModelFilePath: String) : EObject? {
    val modelRoot = loadOriginalModelRoot<ServiceModel>(originalModelFilePath)
    return modelRoot.microservices.asSequence()
        .map { it.interfaces }.flatten()
        .map { it.operations }.flatten()
        .find { it.qualifiedName == this.qualifiedName }
}

/**
 * Determine if this [IntermediateParameter] is a result parameter, i.e., it has the exchange pattern IN or INOUT and is
 * not a fault parameter.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private val IntermediateParameter.isResultParameter
    get() = !isCommunicatesFault && (exchangePattern == ExchangePattern.INOUT || exchangePattern == ExchangePattern.OUT)

/**
 * Determine if this [IntermediateOperation] returns a composite result for the specified [communicationType]. That is,
 * it has more than one result parameter.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateOperation.hasCompositeResult(communicationType: CommunicationType)
    = parameters.count { it.communicationType == communicationType && it.isResultParameter } > 1

/**
 * Determine if this [IntermediateOperation] returns a single result for the specified [communicationType]. That is, it
 * has exactly one result parameter.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateOperation.hasSingleResult(communicationType: CommunicationType)
    = parameters.count { it.communicationType == communicationType && it.isResultParameter } == 1

/**
 * Load the original [EObject] of this [IntermediateParameter] from the specified [originalModelFilePath]. The result
 * will be an [EObject] of type Parameter.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun IntermediateParameter.loadOriginalEObject(originalModelFilePath: String) : EObject? {
    val modelRoot = loadOriginalModelRoot<ServiceModel>(originalModelFilePath)
    return modelRoot.microservices.asSequence()
        .map { it.interfaces }.flatten()
        .map { it.operations }.flatten()
        .map { it.parameters }.flatten()
        .find { it.qualifiedName == this.qualifiedName }
}

/**
 * Get the value of the property with the given name from an [IntermediateImportedAspect]. Returns the default value (if
 * any) in case the property does not have a value.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateImportedAspect.getPropertyValue(propertyName: String)
    = propertyValues.find { it.property.name == propertyName }?.value
        ?: properties.find { it.name == propertyName }?.defaultValue

/**
 * Helper to find annotated classes, possibly within other JAR archives leveraging the given [classLoaders].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun findAnnotatedClasses(searchPackage: String, annotation: String, vararg classLoaders: ClassLoader,
    filter: (ClassInfo) -> Boolean) : List<ClassInfo> {
    val classgraph = ClassGraph()
        .enableClassInfo()
        .enableAnnotationInfo()
        .whitelistPackages(searchPackage)

    if (classLoaders.isNotEmpty())
        classgraph.overrideClassLoaders(*classLoaders)

    return classgraph
        .scan()
        .getClassesWithAnnotation(annotation)
        .filter { filter(it) }
        .toList()
}

/**
 * Helper to find annotated classes that also implement a certain interface. When explicitly specifying [classLoaders]
 * other JAR archives than the current one might be searched.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("UNCHECKED_CAST")
internal inline fun <reified T> findAnnotatedClassesWithInterface(searchPackage: String, annotation: String,
    vararg classLoaders: ClassLoader, interfaceClassname: String = T::class.java.name)
    = findAnnotatedClasses(
            searchPackage,
            annotation,
            *classLoaders
        )
        { it.implementsInterface(interfaceClassname) }  // Interface filter
        .map { it.loadClass() as Class<T> }

/**
 * Helper to find annotated classes that also implement a certain interface. When explicitly specifying [classLoaders]
 * other JAR archives than the current one might be searched. The result of the function will be a map that assigns the
 * identifier string produced by the specified [identifierBuilder] to the found classes.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal inline fun <reified T> findAndMapAnnotatedClassesWithInterface(searchPackage: String, annotation: String,
    vararg classLoaders: ClassLoader, interfaceClassname: String = T::class.java.name,
    identifierBuilder: (T) -> String)
    : Map<String, Class<T>> {
    val foundClasses = findAnnotatedClassesWithInterface<T>(searchPackage, annotation, *classLoaders,
        interfaceClassname = interfaceClassname)

    val resultMap = mutableMapOf<String, Class<T>>()
    resultMap.putAll(
        pairs = foundClasses.map {
            val identifier = identifierBuilder(it.getDeclaredConstructor().newInstance())
            identifier to it
        }
    )
    return resultMap
}