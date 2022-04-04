package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.handlers

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.data.intermediate.IntermediateCollectionType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAllAttributesConstructor
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.VisitingCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.getJavaCollectionTypeDescription
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getFullyQualifiedCompoundItemClassName
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext
import de.fhdo.lemma.model_processing.utils.packageToPath
import java.io.File

/**
 * Code generation handler for IntermediateCollectionType instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class CollectionTypeHandler
    : VisitingCodeGenerationHandlerI<IntermediateCollectionType, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateCollectionType::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java
    override fun getAspects(eObject: IntermediateCollectionType) = eObject.aspects!!

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateCollectionType, context: Nothing?)
        : Pair<ClassOrInterfaceDeclaration, String?>? {
        /*
         * The handler maps IntermediateCollectionTypes to Java classes iff all of the following conditions apply:
         *      - The type doesn't require more than one type argument.
         *      - The type constitutes a structured collection.
         *      - The type defines more than one data field.
         * In this case, the handler produces a new Java class that represents the compound class for all data fields of
         * the collection type, i.e., its items. The compound item class comprises all data fields, setters and getters,
         * an empty constructor and an initializing constructor. Hence, the compound item class allows mapping of
         * LEMMA's semantics for structured collections with more than one data field to Java.
         */

        val collectionType = eObject.getJavaCollectionTypeDescription()
        if (collectionType.typeArgumentCount > 1 || !eObject.isStructuredCollection || eObject.dataFields.size == 1)
            return null

        // Create the compound item class
        val fullyQualifiedCompoundItemClassName = eObject.getFullyQualifiedCompoundItemClassName()
        val itemClassPackageName = fullyQualifiedCompoundItemClassName.substringBeforeLast(".")
        val itemClassName = fullyQualifiedCompoundItemClassName.substringAfterLast(".")
        val generatedClass = newJavaClassOrInterface(itemClassPackageName, itemClassName)

        // Add attributes for the collection type's data fields to the compound item class
        eObject.dataFields.forEach { DataFieldHandler.invoke(it, generatedClass) }

        // Add constructors to the compound item class
        generatedClass.addConstructor(Modifier.Keyword.PUBLIC)
        generatedClass.addAllAttributesConstructor()

        // Determine the package and file path of the compound item class
        val currentDomainPackage: String by DomainContext.State
        val targetPackage = generatedClass.getPackageName().removePrefix(currentDomainPackage).removePrefix(".")
        val generatedFilePath = "${targetPackage.packageToPath()}${File.separator}$itemClassName.java"
        return generatedClass to generatedFilePath
    }
}