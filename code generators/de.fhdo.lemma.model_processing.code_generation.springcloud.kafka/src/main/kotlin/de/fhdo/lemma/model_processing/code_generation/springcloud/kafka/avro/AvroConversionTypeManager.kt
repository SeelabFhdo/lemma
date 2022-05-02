package de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.avro

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.TypeDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedNode
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletPathSpecifier
import de.fhdo.lemma.model_processing.code_generation.java_base.qualifiedName
import org.checkerframework.checker.signature.qual.FullyQualifiedName
import java.io.File

private const val HELPERS_CLASSNAME = "AvroConversionHelpers"
private const val HELPERS_PARENT_PACKAGE_NAME = "avro"
//private val helpersRelativeFilepath = HELPERS_PARENT_PACKAGE_NAME + File.separator + HELPERS_CLASSNAME

internal object AvroConversionTypeManager {
    private val typesGeneratedFromModel = mutableMapOf<String, TypeDeclaration<*>>()
    private val rootTypes = mutableMapOf<String, Pair<IntermediateDataStructure, ClassOrInterfaceDeclaration>>()
    //private val typesGeneratedFromModelPerQualifiedName = mutableMapOf<String, TypeDeclaration<*>>()
    private val typesCompiledFromSchemaOfRootStructure = mutableMapOf<String, List<TypeDeclaration<*>>>()
    private val typesCompiledFromSchemaOfRootStructurePerSimpleName
        = mutableMapOf<String, MutableMap<String, TypeDeclaration<*>>>()
    private val helpersClasses = mutableMapOf<String, AvroConversionHelpersInfo>()

    // TODO: Complete
    fun reset() {
        typesGeneratedFromModel.clear()
        //typesGeneratedFromModelPerQualifiedName.clear()
        typesCompiledFromSchemaOfRootStructure.clear()
        typesCompiledFromSchemaOfRootStructurePerSimpleName.clear()
        helpersClasses.clear()
    }

    fun registerJavaTypeGeneratedFromModel(complexType: IntermediateComplexType,
        generatedJavaType: TypeDeclaration<*>) {
        typesGeneratedFromModel[complexType.qualifiedName] = generatedJavaType
        //typesGeneratedFromModelPerQualifiedName[complexType.qualifiedName] = generatedJavaType
    }

    fun registerJavaTypesCompiledFromSchemaOfRootStructure(rootStructure: IntermediateDataStructure,
        compiledJavaTypes: List<TypeDeclaration<*>>) {
        val rootType = compiledJavaTypes.firstOrNull { it.nameAsString == rootStructure.name } ?: return
        rootTypes[rootStructure.qualifiedName] = rootStructure to rootType as ClassOrInterfaceDeclaration
        typesCompiledFromSchemaOfRootStructure[rootStructure.qualifiedName] = compiledJavaTypes
        typesCompiledFromSchemaOfRootStructurePerSimpleName[rootStructure.qualifiedName] = mutableMapOf()
        compiledJavaTypes.forEach {
            typesCompiledFromSchemaOfRootStructurePerSimpleName[rootStructure.qualifiedName]!![it.nameAsString] = it
        }
    }

    fun getRootTypesOfCompiledSchemas()
        = rootTypes.values.toMap()

    fun getRootType(rootStructureQualifiedName: String) = rootTypes[rootStructureQualifiedName]?.second

    fun getJavaTypeCompiledFromSchemaOfRootStructure(rootStructure: IntermediateDataStructure, simpleName: String)
        = typesCompiledFromSchemaOfRootStructurePerSimpleName[rootStructure.qualifiedName]?.get(simpleName)

    fun getJavaTypeGeneratedFromModel(complexType: IntermediateComplexType)
        = typesGeneratedFromModel[complexType.qualifiedName]

    fun getOrCreateHelpersClass(domainPackage: String, structure: IntermediateDataStructure)
        : ClassOrInterfaceDeclaration {
        val structurePackage = structure.javaPackageName(domainPackage)
        if (structurePackage !in helpersClasses) {
            val helpersClass = newHelpersClass(structurePackage)
            helpersClasses[structurePackage] = AvroConversionHelpersInfo(domainPackage, structure, helpersClass)
        } else
            helpersClasses[structurePackage]!!.addHandledStructure(structure)

        return helpersClasses[structurePackage]!!.helpersClass
    }

    private fun IntermediateDataStructure.javaPackageName(basePackage: String = "") : String {
        val structurePackage = qualifiedName.substringBeforeLast(".")
        return if (basePackage.isNotEmpty())
                "$basePackage.$structurePackage"
            else
                structurePackage
    }

    private fun newHelpersClass(basePackage: String)
        = newJavaClassOrInterface("$basePackage.$HELPERS_PARENT_PACKAGE_NAME", HELPERS_CLASSNAME)

    /**
     * Return the generated class as a [GenletGeneratedNode]
     */
    fun getGeneratedNodes() : Set<GenletGeneratedNode> {
        return helpersClasses
            .filter { (_, info) -> info.helpersClass.members.isNotEmpty() }
            .map { (_, info) ->
                GenletGeneratedNode(
                    GenletPathSpecifier.CURRENT_DOMAIN_GENERATION_TARGET_PATH,
                    info.relativeFilepathOfHelpersClass,
                    info.helpersClass
                )
            }.toSet()
    }
}

private class AvroConversionHelpersInfo(domainPackage: String, initialStructure: IntermediateDataStructure,
    val helpersClass: ClassOrInterfaceDeclaration) {
    private val handledStructures = mutableMapOf(initialStructure.qualifiedName to initialStructure)

    val relativeFilepathOfHelpersClass = helpersClass.getPackageName().removePrefix(domainPackage)
        .replace(".", File.separator) + "${File.separator}${helpersClass.nameAsString}.java"

    fun addHandledStructure(structure: IntermediateDataStructure) {
        handledStructures[structure.qualifiedName] = structure
    }
}