package de.fhdo.lemma.reconstruction.plugin.spring.web.service.operation


import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.body.VariableDeclarator
import com.github.javaparser.ast.type.ClassOrInterfaceType
import com.github.javaparser.ast.type.Type
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.hasAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.methodsExcludingPropertyAccessors
import de.fhdo.lemma.reconstruction.framework.modules.AbstractReconstructionElement
import de.fhdo.lemma.reconstruction.framework.modules.common.createMetaData
import de.fhdo.lemma.reconstruction.framework.modules.domain.datastructure.ClassType
import de.fhdo.lemma.reconstruction.framework.modules.domain.datastructure.ComplexType
import de.fhdo.lemma.reconstruction.framework.modules.domain.datastructure.ReconstructionDataStructureFactory
import de.fhdo.lemma.reconstruction.framework.modules.domain.datastructure.ReconstructionFieldFactory
import de.fhdo.lemma.reconstruction.framework.modules.service.operation.CommunicationType
import de.fhdo.lemma.reconstruction.framework.modules.service.operation.ExchangePattern
import de.fhdo.lemma.reconstruction.framework.modules.service.operation.Parameter
import de.fhdo.lemma.reconstruction.framework.modules.service.operation.ReconstructionOperationFactory
import de.fhdo.lemma.reconstruction.framework.modules.service.operation.ReconstructionParameterFactory
import de.fhdo.lemma.reconstruction.java.util.parser.JavaParseTree
import de.fhdo.lemma.reconstruction.java.util.parser.domain.addDataStructureDependency
import de.fhdo.lemma.reconstruction.java.util.parser.domain.getClassFromCompilationUnit
import de.fhdo.lemma.reconstruction.java.util.parser.domain.getCompilationUnitForDependency
import de.fhdo.lemma.reconstruction.java.util.parser.domain.getEnumFromCompilationUnit
import de.fhdo.lemma.reconstruction.java.util.parser.domain.getEnumerationDependency
import de.fhdo.lemma.reconstruction.java.util.parser.domain.isClass
import de.fhdo.lemma.reconstruction.java.util.parser.domain.isEnum
import de.fhdo.lemma.reconstruction.java.util.parser.domain.isPrimitiveTypeOrWrapper
import de.fhdo.lemma.reconstruction.java.util.parser.util.getComplexName
import de.fhdo.lemma.reconstruction.java.util.parser.util.handlePrimitiveTypeAttribute

/**
 * Object for storing the reconstructed data structures. The handling of the reconstructed information is realized via
 * the singleton pattern to enable the management of complex types as dependencies.
 */
internal object ReconstructionServiceInformation {
    private val reconstructionElements = mutableListOf<AbstractReconstructionElement>()

    internal fun init() {
        reconstructionElements.clear()
    }

    internal fun add(reconstructionElement: AbstractReconstructionElement) {
        reconstructionElements.add(reconstructionElement)
    }

    internal fun addAll(reconstructionElementList: List<AbstractReconstructionElement>) {
        reconstructionElements.addAll(reconstructionElementList)
    }

    internal fun getAllReconstructedElements(): List<AbstractReconstructionElement> {
        return reconstructionElements
    }

    internal fun purgeElements() {
        reconstructionElements.clear()
    }
}

internal fun findOperations(parseTree: JavaParseTree): List<AbstractReconstructionElement> {
    ReconstructionServiceInformation.purgeElements()
    val clazz = getClassFromCompilationUnit(parseTree.compilationUnit)

    if (clazz != null && clazz.hasAnnotation("RestController")) {
        clazz.methodsExcludingPropertyAccessors.forEach {
            // Return parameter
            val operation = ReconstructionOperationFactory().createOperation(it.nameAsString)
            if (it.typeAsString !== "void") {
                operation.parameters.add(handleOutGoingType(it, parseTree.compilationUnit))
            }

            operation.interfaceName = "${clazz.getPackageName()}.${clazz.nameAsString}"

            // Handle incoming parameters
            it.parameters.forEach {
                operation.parameters.add(handleInComingType(it, parseTree.compilationUnit))
            }

            ReconstructionServiceInformation.add(operation)
        }
    }
    return ReconstructionServiceInformation.getAllReconstructedElements()
}

/**
 * Handle out going data structures for an operation
 */
private fun handleOutGoingType(method: MethodDeclaration, unit: CompilationUnit): Parameter {
    val typeClass: ClassOrInterfaceType?
    val typeName: String
    when (method.type.childNodes.size) {
        0 -> {
            typeName = method.typeAsString
            typeClass = null
        }
        1 -> {
            println("Test")
            typeName = method.typeAsString
            typeClass = method.type as ClassOrInterfaceType
        }
        2 -> {
            typeClass = method.type.childNodes[1] as ClassOrInterfaceType
            typeName = typeClass.nameAsString
        }
        else -> throw Exception("ReturnType of Method not supported")
    }

    return when {
        isPrimitiveTypeOrWrapper(typeName) -> {
            handleReturnPrimitiveType(typeName, "return${typeName}", ExchangePattern.OUT)
        }
        else -> {
            return handleComplexType("return${typeName}", typeName, typeClass!!, unit, ExchangePattern.OUT)
        }
    }
}

/**
 * Handle in coming data structures for an operation
 */
private fun handleInComingType(parameter: com.github.javaparser.ast.body.Parameter, unit: CompilationUnit): Parameter {
    return when {
        isPrimitiveTypeOrWrapper(parameter.typeAsString) -> {
            handleReturnPrimitiveType(parameter.typeAsString, parameter.nameAsString, ExchangePattern.IN)
        }
        else -> {
            return handleComplexType(parameter.nameAsString, parameter.typeAsString, parameter.type as ClassOrInterfaceType, unit,
                ExchangePattern.IN)
        }
    }
}

private fun handleReturnPrimitiveType(type: String, name:String, pattern: ExchangePattern): Parameter {
    val parameter = ReconstructionParameterFactory().createParameter(name,
        CommunicationType.SYNCHRONOUS, pattern)
    parameter.primitiveType = handlePrimitiveTypeAttribute(type)
    return parameter
}

private fun handleComplexType(name: String, type: String, clazz: ClassOrInterfaceType, unit: CompilationUnit,
    pattern: ExchangePattern): Parameter {
    val dependencyUnit = getCompilationUnitForDependency(type, clazz.nameAsString, unit)
    return when {
        dependencyUnit === null -> handleUnknownParameter(type, clazz, pattern)
        clazz.nameAsString.contains("List") -> handleListParameter(name, clazz, pattern, unit)
        clazz.nameAsString.contains("Map") -> handleMapParameter(name, clazz, pattern)
        dependencyUnit.isClass() -> handleDataStructureParameter(type, clazz, unit, pattern)
        dependencyUnit.isEnum() -> handleEnumParameter(type, clazz, unit, pattern)
        else -> handleUnknownParameter(type, clazz, pattern)
    }
}

private fun handleListParameter(name: String, clazz: ClassOrInterfaceType, pattern: ExchangePattern,
    unit: CompilationUnit): Parameter {
    val listType = clazz.childNodes.get(1).toString()
    val listName = "${listType}${clazz.childNodes.get(0)}"
    val contextName = getComplexName(unit)
    val structure = ReconstructionDataStructureFactory().createDataStructure(contextName, "${listName}Structure")


    val parameter = ReconstructionParameterFactory().createParameter(structure.name,
        CommunicationType.SYNCHRONOUS, pattern)

    val qualifiedName = "$contextName.${structure.name}"
    val complexType = ComplexType(structure.name, qualifiedName, ClassType.COLLECTION)
    val metadata = createMetaData("CollectionType")
    metadata.values.put("Type", listType)
    metadata.values.put("Name", listName)
    parameter.complexType = complexType
    parameter.metaData.add(metadata)

    // Add list type data structure
    val dependency = addDataStructureDependency(clazz.childNodes.get(1).toString(), unit)
    ReconstructionServiceInformation.addAll(dependency)

    // Add data structure for list

    val field = ReconstructionFieldFactory().createField(listName)
    field.complexType = complexType
    field.metaData.add(metadata)
    structure.fields.add(field)
    ReconstructionServiceInformation.add(structure)
    return parameter
}

private fun handleMapParameter(name: String, clazz: ClassOrInterfaceType, pattern: ExchangePattern): Parameter {
    val parameter = ReconstructionParameterFactory().createParameter(name,
        CommunicationType.SYNCHRONOUS, pattern)
    val complexType = ComplexType("Map", "java.util.Map", ClassType.MAP)
    val metadata = createMetaData("MapType")
    metadata.values.put("Class", clazz.childNodes.get(0).toString())
    metadata.values.put("Key", clazz.childNodes.get(1).toString())
    metadata.values.put("Value", clazz.childNodes.get(2).toString())
    parameter.complexType = complexType
    parameter.metaData.add(metadata)
    return parameter
}

private fun handleDataStructureParameter(name: String, clazz: ClassOrInterfaceType, unit: CompilationUnit,
    pattern: ExchangePattern): Parameter {
    val parameter = ReconstructionParameterFactory().createParameter(name,
        CommunicationType.SYNCHRONOUS, pattern)
    val qualifiedName = "${getComplexName(unit)}.${clazz.nameAsString}"

    val dependencies = addDataStructureDependency(clazz.nameAsString, unit)
    ReconstructionServiceInformation.addAll(dependencies)

    //val qualifiedName = "${dependency.qualifiedContextName}.${dependency.name}"
    val complexType = ComplexType(name, qualifiedName, ClassType.DATA_STRUCTURE)
    parameter.complexType = complexType
    return parameter
}

private fun handleEnumParameter(name: String, clazz: ClassOrInterfaceType, unit: CompilationUnit,
    pattern: ExchangePattern): Parameter {
    val dependencyUnit = getCompilationUnitForDependency(name, clazz.nameAsString, unit)
    val qualifiedName = "${getComplexName(unit)}.${clazz.nameAsString}"
    val complexType = ComplexType(name, qualifiedName, ClassType.ENUMERATION)
    val parameter = ReconstructionParameterFactory().createParameter(name,
        CommunicationType.SYNCHRONOUS, pattern)
    parameter.complexType = complexType
    if (dependencyUnit !== null) {
        val enumType = getEnumerationDependency(dependencyUnit)
        ReconstructionServiceInformation.add(enumType)
    }
    return parameter
}

private fun handleUnknownParameter(name: String, clazz: ClassOrInterfaceType, pattern: ExchangePattern): Parameter {
    val parameter = ReconstructionParameterFactory().createParameter(name,
        CommunicationType.SYNCHRONOUS, pattern)
    val complexType = ComplexType("unspecified", "unspecified", ClassType.UNSPECIFIED)
    parameter.complexType = complexType
    return parameter
}