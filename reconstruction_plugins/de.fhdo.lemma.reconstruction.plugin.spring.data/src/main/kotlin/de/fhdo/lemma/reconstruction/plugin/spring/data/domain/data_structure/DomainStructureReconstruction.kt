package de.fhdo.lemma.reconstruction.plugin.spring.data.domain.data_structure

import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.VariableDeclarator
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.attributes
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.hasAnnotation
import de.fhdo.lemma.reconstruction.java.util.parser.JavaParseTree
import de.fhdo.lemma.reconstruction.java.util.parser.domain.FieldWithDependencies
import de.fhdo.lemma.reconstruction.java.util.parser.domain.addDataStructureDependency
import de.fhdo.lemma.reconstruction.java.util.parser.domain.getCompilationUnitForDependency
import de.fhdo.lemma.reconstruction.java.util.parser.domain.getEnumerationDependency
import de.fhdo.lemma.reconstruction.java.util.parser.domain.handleComplexType
import de.fhdo.lemma.reconstruction.java.util.parser.domain.isClass
import de.fhdo.lemma.reconstruction.java.util.parser.domain.isEnum
import de.fhdo.lemma.reconstruction.java.util.parser.domain.isPrimitiveTypeOrWrapper
import de.fhdo.lemma.reconstruction.java.util.parser.util.getComplexName
import de.fhdo.lemma.reconstruction.java.util.parser.util.handlePrimitiveTypeAttribute
import de.fhdo.reconstruction.framework.modules.AbstractReconstructionElement
import de.fhdo.reconstruction.framework.modules.common.createMetaData
import de.fhdo.reconstruction.framework.modules.domain.datastructure.ClassType
import de.fhdo.reconstruction.framework.modules.domain.datastructure.ComplexType
import de.fhdo.reconstruction.framework.modules.domain.datastructure.DataStructure
import de.fhdo.reconstruction.framework.modules.domain.datastructure.Field
import de.fhdo.reconstruction.framework.modules.domain.datastructure.ReconstructionDataStructureFactory
import de.fhdo.reconstruction.framework.modules.domain.datastructure.ReconstructionFieldFactory

/**
 * Object for storing the reconstructed data structures. The handling of the reconstructed information is realized via
 * the singleton pattern to enable the management of complex types as dependencies.
 */
internal object ReconstructionDomainInformation {
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

/**
 * Main methode for reconstructing the data structure information
 */
internal fun findDataStructure(parseTree: JavaParseTree): List<AbstractReconstructionElement> {
    ReconstructionDomainInformation.purgeElements()
    val clazz = parseTree.compilationUnit.findFirst(ClassOrInterfaceDeclaration::class.java)
        { !it.isInterface }.orElse(null)

    if (clazz != null ) {
        reconstructDataStructuresFromClass(clazz, parseTree.compilationUnit)
    }
    return ReconstructionDomainInformation.getAllReconstructedElements()
}

/**
 * Methode for restoring data structure information from a Java class, annotated with @Entity or @Document.
 * This annotation are generally used to persint information in a database, e.g., MySQL or MongoDB.
 */
private fun reconstructDataStructuresFromClass(clazz: ClassOrInterfaceDeclaration, unit: CompilationUnit) {
    if (clazz.hasAnnotation("Entity") || clazz.hasAnnotation("Document")) {
        val contextName = getComplexName(unit)
        val dataStructure = reconstructDataStructureInformation(contextName, clazz)

        val fields = reconstructDataStructureAttributes(clazz, contextName, unit)
        dataStructure.fields.addAll(fields)
        ReconstructionDomainInformation.add(dataStructure)
    }
}

/**
 * Method for the reconstruction of general data structure information, e.g., its name or context name.
 */
private fun reconstructDataStructureInformation(contextName: String, clazz: ClassOrInterfaceDeclaration)
    : DataStructure {
    val dataStructure = ReconstructionDataStructureFactory()
        .createDataStructure(contextName, clazz.nameAsString)

    val metadata = createMetaData("Entity")
    dataStructure.metaData.add(metadata)
    return dataStructure
}

/**
 * Methode for the reconstruction of attributes, assigned to the data structure.
 */
private fun reconstructDataStructureAttributes(clazz: ClassOrInterfaceDeclaration, contextName: String,
    unit: CompilationUnit): List<Field> {
    val fields = mutableListOf<Field>()
    clazz.attributes.forEach {
        val field = ReconstructionFieldFactory().createField(it.nameAsString)
        if (isPrimitiveTypeOrWrapper(it.typeAsString)) {
            field.primitiveType = handlePrimitiveTypeAttribute(it.typeAsString)
            fields.add(field)
        } else {
            val fieldWithDependencies = handleComplexType(it, unit)
            fields.add(fieldWithDependencies.field)
            ReconstructionDomainInformation.addAll(fieldWithDependencies.dependencies)
        }
    }
    return fields
}
