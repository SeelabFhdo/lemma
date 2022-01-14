package de.fhdo.lemma.reconstruction.java.util.parser.domain

import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.EnumDeclaration
import com.github.javaparser.ast.body.VariableDeclarator
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.attributes
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
import de.fhdo.lemma.reconstruction.java.util.parser.JavaParseTree
import de.fhdo.lemma.reconstruction.java.util.parser.getJavaParseTree
import de.fhdo.lemma.reconstruction.java.util.parser.util.resolveContextFromName
import de.fhdo.reconstruction.framework.modules.AbstractReconstructionElement
import de.fhdo.reconstruction.framework.modules.domain.datastructure.ClassType
import de.fhdo.reconstruction.framework.modules.domain.datastructure.ComplexType
import de.fhdo.reconstruction.framework.modules.domain.datastructure.DataStructure
import de.fhdo.reconstruction.framework.modules.domain.datastructure.EnumType
import de.fhdo.reconstruction.framework.modules.domain.datastructure.Field
import de.fhdo.reconstruction.framework.modules.domain.datastructure.PrimitiveType
import de.fhdo.reconstruction.framework.modules.domain.datastructure.ReconstructionDataStructureFactory
import de.fhdo.reconstruction.framework.modules.domain.datastructure.ReconstructionFieldFactory
import de.fhdo.reconstruction.framework.modules.domain.getDomainReconstructionFilesAndParseTrees

fun createDataStructure(unit: CompilationUnit): DataStructure {
    val clazz = getClassFromCompilationUnit(unit)
    val contextName = resolveContextFromName(unit.storage.get().path.toString())
    val dataStructure = ReconstructionDataStructureFactory()
        .createDataStructure(contextName, clazz.nameAsString)
    clazz.attributes.forEach {
        val field = ReconstructionFieldFactory().createField(it.nameAsString)
        if (isPrimitiveTypeOrWrapper(it.typeAsString)) {
            field.primitiveType = PrimitiveType(it.typeAsString)
        } else {
            val path = unit.storage.get().path.toString()
            val qualifiedName = resolveContextFromName(path)
            field.complexType = ComplexType(it.typeAsString, qualifiedName, getCLassType(it))

        }
        dataStructure.fields.add(field)
    }
    return dataStructure
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


fun addDataStructureDependency(name: String, unit: CompilationUnit): DataStructure? {
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

private fun createDataStructureFromParseTree(parseTree: JavaParseTree): DataStructure? {
    val clazz = parseTree.compilationUnit.findFirst(ClassOrInterfaceDeclaration::class.java)
    { !it.isInterface }.orElse(null)
    if (clazz != null) {
        return createDataStructure(parseTree.compilationUnit)
    }
    return null
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