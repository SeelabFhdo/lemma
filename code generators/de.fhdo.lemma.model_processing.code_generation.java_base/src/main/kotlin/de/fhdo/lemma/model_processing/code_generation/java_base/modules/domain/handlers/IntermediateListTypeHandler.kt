package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.handlers

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.data.intermediate.IntermediateListType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAllAttributesConstructor
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newInnerJavaClass
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setSuperclass
import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClasspath
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.VisitingCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getObjectTypeMapping
import de.fhdo.lemma.model_processing.code_generation.java_base.packageName
import de.fhdo.lemma.model_processing.phases.PhaseException
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext.State as DomainState

@CodeGenerationHandler
internal class IntermediateListTypeHandler
    : VisitingCodeGenerationHandlerI<IntermediateListType, ClassOrInterfaceDeclaration, Nothing> {
    private val currentDomainPackage: String by DomainState
    private lateinit var generatedClass: ClassOrInterfaceDeclaration

    override fun handlesEObjectsOfInstance() = IntermediateListType::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java
    override fun getAspects(list: IntermediateListType) = list.aspects!!

    override fun execute(list: IntermediateListType, context: Nothing?) : Pair<ClassOrInterfaceDeclaration, String?>? {
        val packageName = "$currentDomainPackage.${list.packageName}"

        generatedClass = newJavaClassOrInterface(packageName, list.classname)
        val collectionTypeDescription = list.determineJavaCollectionType()
        val typeParameterNames = if (list.isStructuredList)
                generatedClass.addNestedItemClasses(list, collectionTypeDescription.typeParameterCount)
            else
                listOf(list.primitiveType.getObjectTypeMapping().mappedTypeName)
        generatedClass.setCollectionTypeSuperclass(collectionTypeDescription, typeParameterNames)

        return generatedClass to list.fullyQualifiedClasspath()
    }

    private fun ClassOrInterfaceDeclaration.setCollectionTypeSuperclass(
        collectionTypeDescription: JavaCollectionTypeDescription,
        typeParameterNames: List<String>
    ) {
        collectionTypeDescription.imports.forEach { addImport(it, ImportTargetElementType.SUPER) }
        setSuperclass(collectionTypeDescription.fullyQualifiedCollectionClassName, typeParameterNames)
    }

    private fun ClassOrInterfaceDeclaration.addNestedItemClasses(list: IntermediateListType,
        collectionTypeParameterCount: Int) : List<String> {
        val fullyQualifiedItemClassnames = mutableListOf<String>()
        if (collectionTypeParameterCount > 1 && collectionTypeParameterCount == list.dataFields.size)
            list.dataFields.forEach {
                val itemClassname = "${it.name}Item"
                createNestedItemClass(listOf(it), itemClassname, this)
                fullyQualifiedItemClassnames.add("$nameAsString.$itemClassname")
            }
        else {
            val itemClassname = "${nameAsString}Item"
            createNestedItemClass(list.dataFields, itemClassname, this)
            fullyQualifiedItemClassnames.add("$nameAsString.$itemClassname")
        }
        return fullyQualifiedItemClassnames
    }

    private fun createNestedItemClass(fields: List<IntermediateDataField>, itemClassName: String,
        parentClass: ClassOrInterfaceDeclaration) : ClassOrInterfaceDeclaration {
        val itemClass = newInnerJavaClass(itemClassName, parentClass, true)
        fields.forEach { CalledIntermediateDataFieldHandler.invoke(it, itemClass) }
        itemClass.addConstructor(Modifier.Keyword.PUBLIC)
        itemClass.addAllAttributesConstructor()
        return itemClass
    }
}

private class JavaCollectionTypeDescription(val fullyQualifiedCollectionClassName: String, val typeParameterCount: Int,
    val imports: Set<String>) {
    constructor(fullyQualifiedCollectionClassName: String, typeParameterCount: Int, initialImport: String)
        : this(fullyQualifiedCollectionClassName, typeParameterCount, mutableSetOf(initialImport))

    override fun equals(other : Any?)
        = when {
            this === other -> true
            other == null -> false
            other !is JavaCollectionTypeDescription -> false
            else -> fullyQualifiedCollectionClassName == other.fullyQualifiedCollectionClassName
        }

    override fun hashCode() = fullyQualifiedCollectionClassName.hashCode()
}

private const val DEFAULT_JAVA_COLLECTION_ASPECT = "java.List"

private val SUPPORTED_JAVA_COLLECTION_TYPES = mapOf(
    DEFAULT_JAVA_COLLECTION_ASPECT to JavaCollectionTypeDescription("java.util.ArrayList", -1, "java.util.ArrayList"),
    "java.LinkedList" to JavaCollectionTypeDescription("java.util.LinkedList", -1, "java.util.LinkedList"),
    "java.Map" to JavaCollectionTypeDescription("java.util.HashMap", 2, "java.util.HashMap"),
    "java.Set" to JavaCollectionTypeDescription("java.util.HashSet", -1, "java.util.HashSet")
)

private fun IntermediateListType.determineJavaCollectionType() : JavaCollectionTypeDescription {
    val collectionAspect = aspects.find { it.qualifiedName in SUPPORTED_JAVA_COLLECTION_TYPES }?.qualifiedName
        ?: DEFAULT_JAVA_COLLECTION_ASPECT
    val collectionTypeDescription = SUPPORTED_JAVA_COLLECTION_TYPES[collectionAspect]!!

    val expectedTypeParameterCount = collectionTypeDescription.typeParameterCount
    if (expectedTypeParameterCount != -1 && dataFields.size != expectedTypeParameterCount)
        throw PhaseException("Cannot determine Java collection type for list type $name: The number of data fields " +
            "(${dataFields.size}) does not match the number of data fields expected by the collection type " +
            "$collectionAspect (${expectedTypeParameterCount})")

    return collectionTypeDescription
}