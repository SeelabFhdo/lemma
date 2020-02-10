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
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getObjectWrapperMapping
import de.fhdo.lemma.model_processing.code_generation.java_base.packageName
import de.fhdo.lemma.model_processing.phases.PhaseException
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext.State as DomainState

/**
 * Code generation handler for IntermediateListType instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class ListTypeHandler
    : VisitingCodeGenerationHandlerI<IntermediateListType, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateListType::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java
    override fun getAspects(list: IntermediateListType) = list.aspects!!

    companion object {
        private const val DEFAULT_JAVA_COLLECTION_ASPECT = "java.List"

        // Map of supported Java Collection aspects and their type descriptions
        private val SUPPORTED_JAVA_COLLECTION_TYPES = mapOf(
            DEFAULT_JAVA_COLLECTION_ASPECT to JavaCollectionTypeDescription("java.util.ArrayList", -1),
            "java.LinkedList" to JavaCollectionTypeDescription("java.util.LinkedList", -1),
            "java.Map" to JavaCollectionTypeDescription("java.util.HashMap", 2),
            "java.Set" to JavaCollectionTypeDescription("java.util.HashSet", -1)
        )
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(list: IntermediateListType, context: Nothing?) : Pair<ClassOrInterfaceDeclaration, String?>? {
        /* Each IntermediateListType becomes a Java class that inherits from a class of the Java Collection Framework */
        val currentDomainPackage: String by DomainState
        val packageName = "$currentDomainPackage.${list.packageName}"
        val generatedClass = newJavaClassOrInterface(packageName, list.classname)

        /* Determine the Collection type from which the list type's class inherits */
        val collectionType = list.determineJavaCollectionType()

        // The type arguments of the Collection type depend on whether this list type is a structured list or not. For
        // structured lists, we add nested item classes to the generated Java class. For non-structured, i.e.,
        // primitively typed lists, the type argument is the object wrapper class of the primitive type
        val typeArguments = if (list.isStructuredList)
                generatedClass.addNestedItemClasses(list, collectionType.typeArgumentCount)
            else
                listOf(list.primitiveType.getObjectWrapperMapping().mappedTypeName)

        generatedClass.setCollectionTypeSuperclass(collectionType, typeArguments)
        return generatedClass to list.fullyQualifiedClasspath()
    }

    /**
     * Helper to determine the Java Collection type from this [IntermediateListType]
     */
    private fun IntermediateListType.determineJavaCollectionType() : JavaCollectionTypeDescription {
        // The Java Collection type can be prescribed by modelers leveraging aspects. If no supported aspect was
        // specified, the default one, i.e., for the List Collection type is used
        val collectionAspect = aspects.find { it.qualifiedName in SUPPORTED_JAVA_COLLECTION_TYPES }?.qualifiedName
            ?: DEFAULT_JAVA_COLLECTION_ASPECT
        val collectionTypeDescription = SUPPORTED_JAVA_COLLECTION_TYPES[collectionAspect]!!

        // Some Collection types only make sense, when they are parameterized with other types, e.g., Map. In LEMMA, we
        // force the modeler to use structured list types for such Collection types. For instance, a list type like
        //      @java::_aspects.Map
        //      list type MyMap { int key, string value }
        // becomes a Java class that inherits from HashMap<Integer, String>. Without both data fields, the Map
        // inheritance would not make sense.
        val expectedTypeArgumentCount = collectionTypeDescription.typeArgumentCount
        if (expectedTypeArgumentCount != -1 && dataFields.size != expectedTypeArgumentCount)
            throw PhaseException("Cannot determine Java collection type for list type $name: The number of data " +
                "fields (${dataFields.size}) does not match the number of data fields expected by the collection " +
                "type $collectionAspect (${expectedTypeArgumentCount})")

        return collectionTypeDescription
    }

    /**
     * Helper to add nested item classes to this [ClassOrInterfaceDeclaration] based on the given [list] type and
     * [typeArgumentCount]
     */
    private fun ClassOrInterfaceDeclaration.addNestedItemClasses(list: IntermediateListType, typeArgumentCount: Int)
        : List<String> {
        val qualifiedItemClassesNames = mutableListOf<String>()

        // If there is more than one type argument and the type argument count matches the data field count of the list,
        // we add a nested item class for each data field
        if (typeArgumentCount > 1 && typeArgumentCount == list.dataFields.size)
            list.dataFields.forEach {
                val itemClassName = addNestedItemClass(it.name, it)
                qualifiedItemClassesNames.add("$nameAsString.$itemClassName")
            }

        // If there is only one type argument or the type argument count does not match the data field count (which
        // should not be the case given the check in determineJavaCollectionType()), we add a single item class for
        // all data fields
        else {
            val itemClassName = addNestedItemClass(nameAsString, *list.dataFields.toTypedArray())
            qualifiedItemClassesNames.add("$nameAsString.$itemClassName")
        }

        return qualifiedItemClassesNames
    }

    /**
     * Helper to add a nested item class to this [ClassOrInterfaceDeclaration]. Note that the final name of the item
     * class is the given [itemClassName] with the "Item" suffix.
     */
    private fun ClassOrInterfaceDeclaration.addNestedItemClass(itemClassName: String,
        vararg fields: IntermediateDataField) : String {
        val finalItemClassNameWithSuffix = "${itemClassName}Item"
        val itemClass = newInnerJavaClass(finalItemClassNameWithSuffix, this, true)
        itemClass.addConstructor(Modifier.Keyword.PUBLIC)

        // Add attributes, getters, and setters for data fields to item class, as well as a constructor for initializing
        // all fields
        fields.forEach { DataFieldHandler.invoke(it, itemClass) }
        itemClass.addAllAttributesConstructor()

        return finalItemClassNameWithSuffix
    }

    /**
     * Helper to set the superclass of this [ClassOrInterfaceDeclaration] based on a [collectionType]
     */
    private fun ClassOrInterfaceDeclaration.setCollectionTypeSuperclass(collectionType: JavaCollectionTypeDescription,
        typeArguments: List<String>) {
        collectionType.imports.forEach { addImport(it, ImportTargetElementType.SUPER) }
        setSuperclass(collectionType.classname, isExternalSuperclass = true, typeParameters = typeArguments)
    }
}

/**
 * Helper class that reflects the description of Java Collection types
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private class JavaCollectionTypeDescription(val classname: String, val typeArgumentCount: Int,
    val imports: Set<String>) {
    /**
     * Convenience constructor for single imports. The fully-qualified [classname] is also treated as the initial entry
     * of the [imports] set.
     */
    constructor(classname: String, typeArgumentCount: Int)
        : this(classname, typeArgumentCount, mutableSetOf(classname))


    /**
     * Two [JavaCollectionTypeDescription] instances are equal, if their [classname] values are equal
     */
    override fun equals(other : Any?)
        = when {
        this === other -> true
        other == null -> false
        other !is JavaCollectionTypeDescription -> false
        else -> classname == other.classname
    }

    /**
     * The hash code of a [JavaCollectionTypeDescription] is equal to the hash code of its [classname]
     */
    override fun hashCode() = classname.hashCode()
}