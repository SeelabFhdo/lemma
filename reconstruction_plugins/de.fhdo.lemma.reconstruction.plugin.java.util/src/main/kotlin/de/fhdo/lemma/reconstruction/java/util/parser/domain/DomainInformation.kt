package de.fhdo.lemma.reconstruction.java.util.parser.domain

import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.EnumDeclaration
import com.github.javaparser.ast.body.VariableDeclarator
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.attributes
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
import de.fhdo.lemma.reconstruction.java.util.parser.JavaParseTree
import de.fhdo.lemma.reconstruction.java.util.parser.getJavaParseTree
import de.fhdo.lemma.reconstruction.java.util.parser.util.getComplexName
import de.fhdo.lemma.reconstruction.java.util.parser.util.resolveContextFromName
import de.fhdo.reconstruction.framework.modules.AbstractReconstructionElement
import de.fhdo.reconstruction.framework.modules.common.createMetaData
import de.fhdo.reconstruction.framework.modules.domain.datastructure.ClassType
import de.fhdo.reconstruction.framework.modules.domain.datastructure.ComplexType
import de.fhdo.reconstruction.framework.modules.domain.datastructure.DataStructure
import de.fhdo.reconstruction.framework.modules.domain.datastructure.EnumType
import de.fhdo.reconstruction.framework.modules.domain.datastructure.Field
import de.fhdo.reconstruction.framework.modules.domain.datastructure.PrimitiveType
import de.fhdo.reconstruction.framework.modules.domain.datastructure.ReconstructionDataStructureFactory
import de.fhdo.reconstruction.framework.modules.domain.datastructure.ReconstructionFieldFactory
import de.fhdo.reconstruction.framework.modules.domain.getDomainReconstructionFilesAndParseTrees

data class FieldWithDependencies(
    val field: Field,
    val dependencies: MutableList<AbstractReconstructionElement> = mutableListOf<AbstractReconstructionElement>()
)

fun createDataStructure(unit: CompilationUnit): List<AbstractReconstructionElement> {
    val clazz = getClassFromCompilationUnit(unit)
    val contextName = resolveContextFromName(unit.storage.get().path.toString())
    val dataStructure = ReconstructionDataStructureFactory()
        .createDataStructure(contextName, clazz.nameAsString)
    val dataStructures = mutableListOf<AbstractReconstructionElement>()
    clazz.attributes.forEach {
        val field = ReconstructionFieldFactory().createField(it.nameAsString)
        if (isPrimitiveTypeOrWrapper(it.typeAsString)) {
            field.primitiveType = PrimitiveType(it.typeAsString)
        } else {

            val path = unit.storage.get().path.toString()
            val qualifiedName = resolveContextFromName(path)

            val fieldWithDependencies = handleComplexType(it, unit)
            field.complexType = fieldWithDependencies.field.complexType
            dataStructures.addAll(fieldWithDependencies.dependencies)
        }
        dataStructure.fields.add(field)
    }
    dataStructures.add(dataStructure)
    return dataStructures
}

fun getClassFromCompilationUnit(unit: CompilationUnit)
    = unit.findFirst(ClassOrInterfaceDeclaration::class.java).orElse(null)

fun getEnumFromCompilationUnit(unit: CompilationUnit)
    = unit.findFirst(EnumDeclaration::class.java).orElseGet(null)

fun CompilationUnit.isClass() = getClassFromCompilationUnit(this) !== null

fun CompilationUnit.isEnum(): Boolean {
    println("Methode: IsEnum. - Start")
    val enum = this.findFirst(ClassOrInterfaceDeclaration::class.java)

    println("Methode: IsEnum. - End")
    return enum !== null
}


private fun getCLassType(variable:  VariableDeclarator): ClassType {
    println(variable.type)
    return when {
        variable.type.isClassOrInterfaceType -> ClassType.DATA_STRUCTURE
        variable.type.isArrayType -> ClassType.COLLECTION
        else -> ClassType.DATA_STRUCTURE
    }
}

fun createFieldWithPrimitiveType(variable: VariableDeclarator): Field {
    val field = ReconstructionFieldFactory().createField(variable.nameAsString)
    field.primitiveType = PrimitiveType(variable.typeAsString)
    return field
}

fun createFieldWithComplexType(variable: VariableDeclarator, packageName: String): Field {
    val field = ReconstructionFieldFactory().createField(variable.nameAsString)
    val qualifiedName = "${packageName}.${variable.typeAsString}"
    field.complexType = ComplexType(variable.typeAsString, qualifiedName, ClassType.DATA_STRUCTURE)
    return field
}

fun isPrimitiveTypeOrWrapper(type: String): Boolean {
    return when (type.lowercase()) {
        "byte" -> true
        "short" -> true
        "int" -> true
        "long" -> true
        "float" -> true
        "double" -> true
        "char" -> true
        "boolean" -> true
        "string" -> true
        "date" -> true
        "void" -> true
        else -> false
    }
}


fun addDataStructureDependency(name: String, unit: CompilationUnit): List<AbstractReconstructionElement> {
    var importName = unit.imports.find { it.nameAsString.endsWith(name) }?.nameAsString
    val parseTree: JavaParseTree
    println("Importname: $importName")
    if (importName !== null) {
        println("addDataStructureDependency: before parse tree")
        parseTree = getJavaParseTreeForImport(importName)
        println("addDataStructureDependency: after parse tree")
        return createDataStructureFromParseTree(parseTree)
    } else {
        importName = "${unit.getPackageName()}.$name"
        println("Test")
        parseTree = getJavaParseTreeForImport(importName)
        println("addDataStructureDependency: after parse tree")
        return createDataStructureFromParseTree(parseTree)
    }
}

fun getCompilationUnitForDependency(name: String, type: String, unit: CompilationUnit): CompilationUnit {
    val importName: String
    println("getEnumFromCompilationUnit: $name")
    if (unit.imports.find { it.nameAsString.endsWith(type) } != null) {
        importName  = unit.imports.find { it.nameAsString.endsWith(type) }?.nameAsString.toString()
        println("In different package:")
        println(importName)
    } else {
        val clazz = getClassFromCompilationUnit(unit)
        importName = "${clazz.getPackageName()}.${type}"
        println("In the same  package: $importName")
        println(importName)
    }
    val test = getJavaParseTreeForImport(importName).compilationUnit
    println("getCompUnitForDependency: ${test.primaryTypeName}")
    return test
}

private fun getJavaParseTreeForImport(importName: String): JavaParseTree {
    val path = getPathFromImport(importName)
    println(path)
    val tree = getJavaParseTree(path).second
    println("Tree: ${tree.compilationUnit.primaryTypeName}")
    return tree
}

private fun getPathFromImport(importName: String): String {
    val fileName = "${importName.replaceBeforeLast(".", "").replace(".", "")}.java"
    println("FileName: $fileName")
    val filesAndTrees = getDomainReconstructionFilesAndParseTrees()
    val path = filesAndTrees.keys.find { it.endsWith(fileName) }?: "unknown"
    println("Path: $path")
    return path
}

private fun createDataStructureFromParseTree(parseTree: JavaParseTree): List<AbstractReconstructionElement> {
    val dataStructures = mutableListOf<AbstractReconstructionElement>()
    dataStructures.addAll(createDataStructure(parseTree.compilationUnit))
    return dataStructures
}

fun getEnumerationDependency(unit: CompilationUnit): EnumType{
    val contextName = resolveContextFromName(unit.storage.get().path.toString())
    val enumField = getEnumFromCompilationUnit(unit)
    val values = mutableListOf<String>()
    enumField.entries.forEach {
        values.add(it.nameAsString)
    }
    val reconstructedEnum = EnumType(contextName, enumField.nameAsString, values)
    return reconstructedEnum
}

/**
 * Handle complex type fields. The complex fields distinguish between collection, enumerations, data structures and
 * maps.
 */
fun handleComplexType(variable: VariableDeclarator, unit: CompilationUnit): FieldWithDependencies {
    return when {
        variable.typeAsString.contains("List") -> handleListField(variable)
        variable.typeAsString.contains("Map") -> handleMapField(variable)
        getCompilationUnitForDependency(variable.nameAsString, variable.typeAsString, unit).isClass()
        -> handleDataStructureField(variable, unit)
        getCompilationUnitForDependency(variable.nameAsString, variable.typeAsString, unit).isEnum()
        -> handleEnumField(variable, unit)
        else -> handleUnknownField(variable)
    }
}

private fun handleListField(variable: VariableDeclarator): FieldWithDependencies {
    val complexType = ComplexType("Collection", "java.util.List", ClassType.COLLECTION)
    val metadata = createMetaData("CollectionType")
    metadata.values.put("Type", variable.type.childNodes.get(1).toString())
    metadata.values.put("Name", variable.childNodes.get(1).toString())
    val field = ReconstructionFieldFactory().createField(variable.nameAsString)
    field.complexType = complexType
    field.metaData.add(metadata)
    val fieldWithDependencies = FieldWithDependencies(field)
    return fieldWithDependencies
}

private fun handleMapField(variable: VariableDeclarator): FieldWithDependencies {
    val complexType = ComplexType("Map", "java.util.Map", ClassType.MAP)
    val metadata = createMetaData("MapType")
    metadata.values.put("Class", variable.childNodes.get(0).toString())
    metadata.values.put("Key", variable.childNodes.get(1).toString())
    metadata.values.put("Value", variable.childNodes.get(2).toString())
    val field = ReconstructionFieldFactory().createField(variable.nameAsString)
    field.complexType = complexType
    field.metaData.add(metadata)
    val fieldWithDependencies = FieldWithDependencies(field)
    return fieldWithDependencies
}

private fun handleDataStructureField(variable: VariableDeclarator, unit: CompilationUnit): FieldWithDependencies {
    val field = ReconstructionFieldFactory().createField(variable.nameAsString)
    val qualifiedName = "${getComplexName(unit)}.${variable.typeAsString}"
    val complexType = ComplexType(variable.typeAsString, qualifiedName, ClassType.DATA_STRUCTURE)
    field.complexType = complexType

    val dependency = addDataStructureDependency(variable.typeAsString, unit)
    val fieldWithDependencies = FieldWithDependencies(field)

    fieldWithDependencies.dependencies.addAll(dependency)

    return fieldWithDependencies
}

private fun handleEnumField(variable: VariableDeclarator, unit: CompilationUnit): FieldWithDependencies {
    println("Handle Enum Test!")
    val dependencyUnit = getCompilationUnitForDependency(variable.nameAsString, variable.typeAsString, unit)
    val qualifiedName = "${getComplexName(unit)}.${variable.typeAsString}"
    val complexType = ComplexType(variable.nameAsString, qualifiedName, ClassType.ENUMERATION)
    val field = ReconstructionFieldFactory().createField(variable.nameAsString)
    field.complexType = complexType
    val enumType = getEnumerationDependency(dependencyUnit)
    val fieldWithDependencies = FieldWithDependencies(field)
    fieldWithDependencies.dependencies.add(enumType)
    return fieldWithDependencies
}

private fun handleUnknownField(variable: VariableDeclarator): FieldWithDependencies {
    val field = ReconstructionFieldFactory().createField(variable.nameAsString)
    val complexType = ComplexType("unspecified", "unspecified", ClassType.UNSPECIFIED)
    field.complexType = complexType
    val fieldWithDependencies = FieldWithDependencies(field)
    return fieldWithDependencies
}