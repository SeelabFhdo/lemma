package de.fhdo.lemma.model_processing.code_generation.java_base

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.data.ComplexType
import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.data.DataStructure
import de.fhdo.lemma.data.Enumeration
import de.fhdo.lemma.data.ListType
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.data.intermediate.IntermediateDataModel
import de.fhdo.lemma.data.intermediate.IntermediateDataOperation
import de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateEnumeration
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.data.intermediate.IntermediateImportedComplexType
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addGetter
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addPrivateAttribute
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSetter
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.DATA_DSL_LANGUAGE_DESCRIPTION
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.SERVICE_DSL_LANGUAGE_DESCRIPTION
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getTypeMapping
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.PropertyFile
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.ServicesContext.State as ServicesState
import de.fhdo.lemma.model_processing.languages.registerLanguage
import de.fhdo.lemma.model_processing.loadXtextResource
import de.fhdo.lemma.model_processing.utils.loadModelRootRelative
import de.fhdo.lemma.model_processing.utils.mainInterface
import de.fhdo.lemma.model_processing.utils.packageToPath
import de.fhdo.lemma.model_processing.utils.putValue
import de.fhdo.lemma.model_processing.utils.removeFileUri
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
import java.io.File
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
internal val EObject.eObjectPackageName
    get() = when(this) {
        is IntermediateComplexType -> qualifiedName.substringBeforeLast(".")
        is IntermediateMicroservice -> qualifiedName.substringBeforeLast(".")
        else -> throw IllegalArgumentException("EObject of type ${this.mainInterface.name} does not have a package " +
            "name")
    }

/**
 * Build the name of the package for operation-related, generated types like Exception classes for fault parameters or
 * composite result classes. This function works for [IntermediateOperation] and [IntermediateParameter] instances. In
 * case no [targetInterfaceName] is passed, the interface comprising this operation or this parameter's operation is
 * used. If [subPackageOnly] is specified, only the sub-package for the operation and not the fully-qualified package
 * (including the interface name) is returned.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun EObject.buildOperationPackageName(targetInterfaceName: String = "", subPackageOnly: Boolean = false)
    : String {
    val (parentInterfaceName, operationName) = when(this) {
        is IntermediateOperation -> `interface`.name to name
        is IntermediateParameter -> operation.`interface`.name to operation.name
        else -> throw IllegalArgumentException("EObject of type ${this.mainInterface.name} does not have a elements " +
            "that support building of an operation package name")
    }

    val interfaceName = if (targetInterfaceName.isEmpty()) parentInterfaceName else targetInterfaceName
    val subPackage = "operations.$interfaceName.$operationName"
    return if (subPackageOnly)
            subPackage
        else {
            val currentInterfacesGenerationPackage: String by ServicesState
            "$currentInterfacesGenerationPackage.$subPackage"
        }
}

/**
 * Property representing the fully-qualified classname of an [EObject], e.g., an [IntermediateComplexType] or an
 * [IntermediateMicroservice].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
val EObject.fullyQualifiedClassname
    get() = when(this) {
        is IntermediateComplexType -> "$eObjectPackageName.$classname"
        is IntermediateMicroservice -> "$eObjectPackageName.$classname"
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
 * Determine if [IntermediateMicroservice], [IntermediateInterface], [IntermediateOperation], or
 * [IntermediateReferredOperation] makes use of the given [protocol].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EObject.usesProtocol(protocol: String) : Boolean {
    require(
        this is IntermediateMicroservice ||
        this is IntermediateInterface ||
        this is IntermediateOperation ||
        this is IntermediateReferredOperation
    ) { "EObject of type ${this.mainInterface.name} does not use protocols" }

    val protocols = when (this) {
        is IntermediateMicroservice -> protocols
        is IntermediateInterface -> protocols
        is IntermediateOperation -> protocols
        is IntermediateReferredOperation -> protocols
        else -> null
    }

    val endpoints = when (this) {
        is IntermediateMicroservice -> endpoints
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
        is IntermediateDataField -> aspects
        is IntermediateDataOperation -> aspects
        is IntermediateDataOperationReturnType -> aspects
        is IntermediateDataStructure -> aspects
        is IntermediateMicroservice -> aspects
        is IntermediateInterface -> aspects
        is IntermediateOperation -> aspects
        is IntermediateParameter -> aspects
        else -> throw IllegalArgumentException("EObject of type ${this.mainInterface.name} does not have aspects")
    }

/**
 * Get all [IntermediateImportedAspect] instances of this [EObject] with one of the given [fullyQualifiedAspectNames]
 * assigned. Throws an [IllegalArgumentException] if the [EObject] does not support having aspects.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EObject.getAllAspects(vararg fullyQualifiedAspectNames: String)
    = getAllAspects().filter { it.qualifiedName in fullyQualifiedAspectNames }

/**
 * Check if an [EObject] has one of the aspects with the given [fullyQualifiedAspectNames] assigned. Throws an
 * [IllegalArgumentException] if the [EObject] does not support having aspects.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EObject.hasAspect(vararg fullyQualifiedAspectNames: String)
    = getAllAspects().any { it.qualifiedName in fullyQualifiedAspectNames }

/**
 * Get the [IntermediateImportedAspect] instances of this [EObject] with one of the given [fullyQualifiedAspectNames]
 * assigned. Throws an [IllegalArgumentException] if the [EObject] does not support having aspects.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EObject.getAspect(vararg fullyQualifiedAspectNames: String)
    = getAllAspects().find { it.qualifiedName in fullyQualifiedAspectNames }

/**
 * Iterate over all [IntermediateImportedAspect] instances of this [EObject] with the given [fullyQualifiedAspectNames].
 * Throws an [IllegalArgumentException] if the [EObject] does not support having aspects.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun EObject.forEachAspect(vararg fullyQualifiedAspectNames: String, action: (IntermediateImportedAspect) -> Unit)
    = getAllAspects().forEach { if (it.qualifiedName in fullyQualifiedAspectNames) action(it) }

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
 * Check if an [IntermediateComplexType] exhibits a certain feature.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateComplexType.hasFeature(feature: String) =
    when(this) {
        is IntermediateDataStructure -> featureNames.contains(feature)
        is IntermediateEnumeration -> featureNames.contains(feature)
        else -> false
    }

/**
 * Check if an [IntermediateDataField] exhibits a certain feature.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateDataField.hasFeature(feature: String) = featureNames.contains(feature)

/**
 * Resolve the original [IntermediateComplexType] from this instance. To keep the intermediate models as lightweight as
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
    val definingModel = if (definingModelUri != null) {
            val importingModelFilePath = eResource().uri.toString().removeFileUri()
            loadModelRootRelative(definingModelUri, importingModelFilePath)
        } else
            getContainingDataModel()
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
        // There is neither a version nor a context surrounding the type (according to its qualified name), i.e., the
        // type is defined on the top-level of the model itself
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
 * Determine if this [IntermediateOperation] has input parameters of the specified [communicationType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateOperation.hasInputParameters(communicationType: CommunicationType)
    = parameters.any { it.communicationType == communicationType.name && it.isInputParameter }

/**
 * Determine if this [IntermediateParameter] is an input parameter, i.e., it has the exchange pattern IN or INOUT and is
 * not a fault parameter.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
val IntermediateParameter.isInputParameter
    get() = !isCommunicatesFault &&
            (exchangePattern == ExchangePattern.INOUT.name || exchangePattern == ExchangePattern.IN.name)

/**
 * Get all input parameters of this [IntermediateOperation] for the specified [communicationType]. In case no
 * [communicationType] is passed, all input parameters will be returned.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateOperation.getInputParameters(communicationType: CommunicationType? = null)
    = parameters.filter {
        (communicationType == null || it.communicationType == communicationType.name) && it.isInputParameter
    }

/**
 * Determine if this [IntermediateOperation] has required input parameters of the specified [communicationType]. In case
 * no [communicationType] is passed, the function will return true if there is at least one required input parameter.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateOperation.hasRequiredInputParameters(communicationType: CommunicationType? = null)
    = getInputParameters(communicationType).any { !it.isOptional }

/**
 * Get all required input parameters of this [IntermediateOperation] for the specified [communicationType]. In case no
 * [communicationType] is passed, all required input parameters will be returned.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateOperation.getRequiredInputParameters(communicationType: CommunicationType? = null)
    = getInputParameters(communicationType).filter { !it.isOptional }

/**
 * Determine if this [IntermediateOperation] has result parameters of the specified [communicationType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateOperation.hasResultParameters(communicationType: CommunicationType)
    = parameters.any { it.communicationType == communicationType.name && it.isResultParameter }

/**
 * Determine if this [IntermediateParameter] is a result parameter, i.e., it has the exchange pattern IN or INOUT and is
 * not a fault parameter.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
val IntermediateParameter.isResultParameter
    get() = !isCommunicatesFault &&
            (exchangePattern == ExchangePattern.INOUT.name || exchangePattern == ExchangePattern.OUT.name)

/**
 * Get result parameters of this [IntermediateOperation] having the specified [communicationType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateOperation.getResultParameters(communicationType: CommunicationType)
    = parameters.filter { it.communicationType == communicationType.name && it.isResultParameter }

/**
 * Get fault parameters of this [IntermediateOperation] having the specified [communicationType] and for which an
 * Exception class is generated or not.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateOperation.getFaultParameters(communicationType: CommunicationType,
    withCustomExceptionClass: Boolean = true) = parameters.filter {
        it.communicationType == communicationType.name &&
        it.isCommunicatesFault &&
        it.generateCustomExceptionClassFor() == withCustomExceptionClass
    }

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
 * Determine if this [IntermediateOperation] returns a composite result for the specified [communicationType]. That is,
 * it has more than one result parameter.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateOperation.hasCompositeResult(communicationType: CommunicationType)
    = parameters.count { it.communicationType == communicationType.name && it.isResultParameter } > 1

/**
 * Constant to be used when a generated element refers to synchronous parameters and/or behavior.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private const val SYNCHRONOUS_NAME_FRAGMENT = ""

/**
 * Constant to be used when a generated element refers to asynchronous parameters and/or behavior.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private const val ASYNCHRONOUS_NAME_FRAGMENT = "Async"

/**
 * Determine the name of a composite class that represents a composite input or result object of this
 * [IntermediateOperation] depending on the passed [communicationType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateOperation.buildCompositeClassName(communicationType: CommunicationType, forResult: Boolean = false)
    : String {
    val communicationTypeSuffix = when(communicationType) {
        CommunicationType.SYNCHRONOUS -> SYNCHRONOUS_NAME_FRAGMENT
        CommunicationType.ASYNCHRONOUS -> ASYNCHRONOUS_NAME_FRAGMENT
    }

    val resultSuffix = if (forResult) "Result" else ""
    return "$classname$communicationTypeSuffix$resultSuffix"
}

/**
 * Build the fully-qualified name of a composite class related to this [IntermediateOperation] (cf.
 * [buildCompositeClassName]).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateOperation.buildFullyQualifiedCompositeClassName(communicationType: CommunicationType,
    forResult: Boolean = false)
    = "${buildOperationPackageName()}.${buildCompositeClassName(communicationType, forResult)}"

/**
 * Build the name of the guard method for checking required input parameters of this [IntermediateOperation] with the
 * given [communicationType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateOperation.buildRequiredInputParameterGuardName(communicationType: CommunicationType) : String {
    val prefix = if (communicationType == CommunicationType.ASYNCHRONOUS)
            ASYNCHRONOUS_NAME_FRAGMENT
        else
            SYNCHRONOUS_NAME_FRAGMENT

    return "checkRequired${prefix}ParametersOf${name.capitalize()}"
}

/**
 * Determine the name of the Exception class in case this parameter is a fault parameter.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateParameter.buildExceptionClassName()
    = "${name.capitalize()}Exception"

/**
 * Determine if for this fault parameter a custom Exception class is to be generated.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateParameter.generateCustomExceptionClassFor()
    = isCommunicatesFault && type.getTypeMapping() != null

/**
 * Determine the fully-qualified name of the Exception class in case this parameter is a fault parameter.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateParameter.buildFullyQualifiedExceptionClassName()
    = "${buildOperationPackageName()}.${buildExceptionClassName()}"

/**
 * Build a composite class from this list of [IntermediateParameter] instances. The composite class is a POJO with
 * fields, getters, and setters corresponding to the [IntermediateParameter] instances in the list. This function will
 * return a [ClassOrInterfaceDeclaration] instance, which represents the class, and the path in which the class shall be
 * serialized.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun List<IntermediateParameter>.toCompositeClass(communicationType: CommunicationType,
    forResult: Boolean = false) : Pair<ClassOrInterfaceDeclaration, String> {
    require(isNotEmpty()) { "List of parameters for building composite class must not be empty" }
    val operation = first().operation
    require(!any { it.operation != operation })
        { "When building composite class for parameters, all parameters must belong to the same operation" }

    val packageName = operation.buildOperationPackageName()
    val classname = operation.buildCompositeClassName(communicationType, forResult)
    val generatedClass = newJavaClassOrInterface(packageName, classname)

    // Generate fields, getters, and setters for each IntermediateParameter instance in this list
    val interfaceSubFolderName: String by ServicesState
    forEach { parameter ->
        /* Add attribute */
        val attributeTypeImports = mutableListOf<String>()
        val parameterAttribute = generatedClass.addPrivateAttribute(parameter.name, parameter.type, generatedClass) {
            // Collect imports for getter and setter (see below)
            attributeTypeImports.add(it)
            generatedClass.addImport(it, ImportTargetElementType.ATTRIBUTE_TYPE)
        }

        /* Add getter and setter */
        val (_, getter) = generatedClass.addGetter(parameterAttribute)
        val (_, setter) = generatedClass.addSetter(parameterAttribute)

        // Add imports to getter and setter. The imports need to be directly associated with the getter and setter, so
        // that they will, e.g., get copied into interfaces by code generation serializers.
        attributeTypeImports.forEach {
            getter.addImport(it, ImportTargetElementType.METHOD)
            setter.addImport(it, ImportTargetElementType.METHOD)
        }
    }

    val operationSubFolder = operation.buildOperationPackageName(subPackageOnly = true).packageToPath()
    val generatedFilePath = listOf(interfaceSubFolderName, operationSubFolder, "$classname.java")
        .joinToString(File.separator)
    return generatedClass to generatedFilePath
}

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
 * Helper to add the value of a property of this [IntermediateImportedAspect] named [aspectPropertyName] to the given
 * [propertyFile] file as a property named [targetPropertyName]. Returns null, if [getPropertyValue] returns null.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun IntermediateImportedAspect.toProperty(aspectPropertyName: String, propertyFile: PropertyFile,
    targetPropertyName: String) : String? {
    val propertyValue = getPropertyValue(aspectPropertyName) ?: return null
    propertyFile[targetPropertyName] = propertyValue
    return propertyValue
}

/**
 * Get the value of the property with the given name from an [IntermediateImportedAspect]. Returns the default value (if
 * any) in case the property does not have a value. Returns null, the property could not be found for the aspect.
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
    identifierBuilder: (T) -> String) : Map<String, Set<Class<T>>> {
    val foundClasses = findAnnotatedClassesWithInterface<T>(searchPackage, annotation, *classLoaders,
        interfaceClassname = interfaceClassname)

    val resultMap = mutableMapOf<String, MutableSet<Class<T>>>()
    foundClasses.forEach {
        val identifier = identifierBuilder(it.getDeclaredConstructor().newInstance())
        resultMap.putValue(identifier, it)
    }

    return resultMap
}