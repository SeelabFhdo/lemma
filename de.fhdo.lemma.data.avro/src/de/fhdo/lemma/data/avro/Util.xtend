package de.fhdo.lemma.data.avro

import org.eclipse.emf.ecore.EObject
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.common.util.URI
import java.io.File

import static de.fhdo.lemma.utils.LemmaUtils.*
import de.fhdo.lemma.data.intermediate.IntermediateDataModel
import java.util.Map
import java.util.List
import de.fhdo.lemma.data.intermediate.IntermediateType
import de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.data.Context
import de.fhdo.lemma.data.ComplexType
import de.fhdo.lemma.data.DataOperation
import de.fhdo.lemma.data.DataOperationParameter
import de.fhdo.lemma.data.DataField
import de.fhdo.lemma.data.EnumerationField
import de.fhdo.lemma.technology.mapping.ComplexTypeMapping
import java.util.Collection
import java.util.function.Function
import java.util.Set
import org.apache.commons.lang.StringUtils
import de.fhdo.lemma.data.intermediate.IntermediateVersion
import de.fhdo.lemma.data.intermediate.IntermediateContext
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.utils.LemmaUtils

/**
 * This class collects _static_ utility methods for the Avro plugin.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class Util {
    /**
     * Get all visible fields of an IntermediateDataStructure
     */
    static def List<IntermediateDataField> visibleFields(IntermediateDataStructure structure) {
        return structure.dataFields.filter[!it.hidden].toList
    }

    /**
     * Check if an EObject exhibits an aspect of the given qualifiedAspectName
     */
    static def boolean hasAspect(EObject eObject, String qualifiedAspectName) {
        val aspects = switch (eObject) {
            IntermediateDataStructure: eObject.aspects
            IntermediateDataField: eObject.aspects
            default: throw new IllegalArgumentException("EObject of type " +
                '''«eObject.class.simpleName» does not support having aspects''')
        }

        return aspects.exists[it.qualifiedName == qualifiedAspectName]
    }

    /**
     * Get the count of qualifying levels from a qualified string. This count corresponds to the
     * number of qualifying parts of the qualified string.
     */
    static def int qualifyingLevelCount(String qualifiedString) {
        val qualifyingParts = LemmaUtils.getQualifyingParts(qualifiedString)
        StringUtils.countMatches(qualifyingParts, ".")
    }

    /**
     * Convenience method to get the qualifying parts of a qualified string as list
     */
    static def List<String> getQualifyingPartsAsList(String qualifiedString) {
        val qualifyingParts = LemmaUtils.getQualifyingParts(qualifiedString)
        return qualifyingParts?.split("\\.")
    }

    /**
     * Split a given qualified string into its qualifying parts and simple name. Returns a pair
     * consisting of the qualifying parts and simple name.
     */
    static def Pair<String, String> splitNameParts(String qualifiedString) {
        return getQualifyingParts(qualifiedString) -> LemmaUtils.getSimpleName(qualifiedString)
    }

    /**
     * Load an intermediate data model in XMI format from the given file path
     */
    static def IntermediateDataModel loadIntermediateDataModel(String filepath) {
        val resourceSet = new ResourceSetImpl()
        val extensionFactoryMap = Resource.Factory.Registry.INSTANCE.extensionToFactoryMap
        extensionFactoryMap.put("xmi", new XMIResourceFactoryImpl())
        val absolutePath = new File(removeFileUri(filepath)).absolutePath
        val resource = resourceSet.createResource(URI.createURI(convertToFileUri(absolutePath)))
        resource.load(null)

        val modelRoot = resource.contents.get(0) as IntermediateDataModel
        modelRoot.imports.forEach[
            it.importUri = convertToAbsoluteFileUri(it.importUri, absolutePath)
        ]

        return modelRoot
    }

    /**
     * Add a value to a nested set inside a map. Suppose a map
     *      val map = {"key1" -> {"setValue1"}}
     *
     * Invoking this methods with
     *      addToValueSet(map, "key1", "setValue2")
     * will change the map to
     *      {"key1" -> {"setValue1", "setValue2"}}
     *
     * In case a nested set does not exist for the target key ("key1" above) or the target key
     * itself does not exist, a new nested set with the new value ("newValue" above) will be put to
     * the target map ("map" above).
     */
    static def <K, V> boolean addToValueSet(Map<K, Set<V>> targetMap, K targetKey, V newValue) {
        return addToValueCollection(targetMap, targetKey, newValue, [newHashSet])
    }

    /**
     * Generic function to add a value to a nested Collection of elements inside a map (cf.
     * addToValueSet). The newCollection function will be invoked to retrieve a new instance of the
     * nested Collection, if necessary.
     */
    static def <K, V, C extends Collection<V>> boolean addToValueCollection(
        Map<K, C> targetMap,
        K targetKey,
        V newValue,
        Function<Void, C> newCollection
    ) {
        val targetCollection = if (targetMap.containsKey(targetKey))
                targetMap.get(targetKey)
            else {
                val newList = newCollection.apply(null)
                targetMap.put(targetKey, newList)
                newList
            }

        return targetCollection.add(newValue)
    }

    /**
     * Generic function to remove a value from a nested Collection of elements inside a map
     */
    static def <K, V> boolean removeFromValueCollection(
        Map<K, ? extends Collection<V>> targetMap,
        K targetKey,
        V oldValue
    ) {
        val targetList = targetMap.get(targetKey)
        if (targetList === null)
            return false

        if (targetList.empty)
            targetMap.remove(targetKey)

        return targetList.remove(oldValue)
    }

    /**
     * Add a value to a nested map inside a map. Suppose a map
     *      val map = {"key1" -> {"nestedKey1" -> "nestedValue1"}}
     *
     * Invoking this methods with
     *      addToValueMap(map, "key1", "nestedKey1", "newValue")
     * will change the map to
     *      {"key1" -> {"nestedKey1" -> "newValue"}}
     *
     * In case a nested map does not exist for the target key ("key1" above) or the target key
     * itself does not exist, a new nested map with the new value ("newValue" above) will be put to
     * the target map ("map" above).
     */
    static def <K1, K2, V> V addToValueMap(Map<K1, Map<K2, V>> targetMap, K1 targetKey,
        K2 nestedKey, V newValue) {
        val nestedMap = if (targetMap.containsKey(targetKey))
                targetMap.get(targetKey)
            else {
                val newMap = newHashMap
                targetMap.put(targetKey, newMap)
                newMap
            }

        return nestedMap.put(nestedKey, newValue)
    }

    /**
     * Remove a key from a nested map inside a map. Suppose a map
     *      val map = {"key1" -> {"nestedKey1" -> "nestedValue1"}}
     *
     * Invoking this methods with
     *      removeFromValueMap(map, "key1", "nestedKey1")
     * will change the map to
     *      {"key1" -> {}}
     *
     * The result is the value, which was associated with the given nested key ("nestedValue1" for
     * "nestedKey1" above). If the nested key does not exist, the method returns null.
     */
    static def <K1, K2, V> V removeFromValueMap(Map<K1, Map<K2, V>> targetMap, K1 targetKey,
        K2 nestedKey
    ) {
        val nestedMap = targetMap.get(targetKey)
        return if (nestedMap !== null) {
                val nestedRemovalResult = nestedMap.remove(nestedKey)
                if (nestedMap.empty)
                    targetMap.remove(targetKey)
                nestedRemovalResult
            } else
                return null
    }

    /**
     * Check if the given LEMMA intermediate type is a primitive type with the given type name
     */
    static def boolean isPrimitiveType(IntermediateType type, String typeName) {
        return try {
            val primitiveType = type as IntermediatePrimitiveType
            primitiveType.name == typeName
        } catch (ClassCastException ex) {
            false
        }
    }

    /**
     * Get the qualified name of a LEMMA EObject instance. Throws an IllegalArgumentException, if
     * the EObject does not support having a qualified name.
     */
    static def String qualifiedName(EObject eObject) {
        return switch(eObject) {
            Context: eObject.buildQualifiedName(".")
            ComplexType: eObject.buildQualifiedName(".")
            DataOperation: eObject.buildQualifiedName(".")
            DataOperationParameter: eObject.buildQualifiedName(".")
            DataField: eObject.buildQualifiedName(".")
            EnumerationField: eObject.buildQualifiedName(".")

            ComplexTypeMapping: eObject.type.type.buildQualifiedName(".")

            IntermediateVersion: eObject.name
            IntermediateContext: eObject.qualifiedName
            IntermediateComplexType: eObject.qualifiedName

            default: throw new IllegalArgumentException("Building fully-qualified name for " +
                '''EObjects of type «eObject.class.simpleName» is not supported''')
        }
    }

    /**
     * Get the error message of an Exception. If the exception's error message is null or empty,
     * return the simple name of the Exception class.
     */
    static def String getErrorMessageOrSimpleClassName(Exception ex) {
        return if (!ex.message.nullOrEmpty) ex.message else ex.class.simpleName
    }

    /**
     * Get the top level type containers of a data model. A top level type container is an EObject
     * instance at the top level of a data model that may hold complex type definitions.
     * Effectively, only (Intermediate)Versions, (Intermediate)Contexts, or the
     * (Intermediate)DataModel itself may be a top level container.
     */
    static def List<? extends EObject> getTopLevelComplexTypeContainers(
        IntermediateDataModel dataModel
    ) {
        return switch(dataModel.complexTypeDefinitionKind) {
            case COMPLEX_TYPE_DEFINITION_KIND.VERSION,
            case COMPLEX_TYPE_DEFINITION_KIND.VERSION_CONTEXT:
                dataModel.versions
            case COMPLEX_TYPE_DEFINITION_KIND.CONTEXT:
                dataModel.contexts
            case COMPLEX_TYPE_DEFINITION_KIND.TOP_LEVEL:
                if (!dataModel.complexTypes.empty)
                    newArrayList(dataModel)
                else
                    emptyList
        }
    }

    /**
     * Enumeration for complex type definition kinds inside a data model
     */
    private static enum COMPLEX_TYPE_DEFINITION_KIND {
        VERSION,            // Complex types are defined inside versions
        VERSION_CONTEXT,    // Complex types are defined inside contexts of versions
        CONTEXT,            // Complex types are defined inside top-level contexts
        TOP_LEVEL           // Complex types are defined directly at the top level of the data model
    }

    /**
     * Get the complex type definition level of a data model. This is the level in the data model,
     * at which complex types may be defined (cf. the COMPLEX_TYPE_DEFINITION_KIND enumeration).
     */
    private static def COMPLEX_TYPE_DEFINITION_KIND complexTypeDefinitionKind(
        IntermediateDataModel dataModel
    ) {
        return if (!dataModel.versions.empty) {
                if (dataModel.contexts.empty) COMPLEX_TYPE_DEFINITION_KIND.VERSION
                else COMPLEX_TYPE_DEFINITION_KIND.VERSION_CONTEXT
            } else if (!dataModel.contexts.empty)
                COMPLEX_TYPE_DEFINITION_KIND.CONTEXT
            else
                COMPLEX_TYPE_DEFINITION_KIND.TOP_LEVEL
    }

    /**
     * Get all complex types defined in a data model
     */
    static def List<IntermediateComplexType> getComplexTypes(IntermediateDataModel dataModel) {
        return switch(dataModel.complexTypeDefinitionKind) {
            case COMPLEX_TYPE_DEFINITION_KIND.VERSION:
                dataModel.versions.map[it.complexTypes].flatten.toList
            case COMPLEX_TYPE_DEFINITION_KIND.VERSION_CONTEXT:
                dataModel.versions.map[it.contexts].flatten.map[it.complexTypes].flatten.toList
            case COMPLEX_TYPE_DEFINITION_KIND.CONTEXT:
                dataModel.contexts.map[it.complexTypes].flatten.toList
            case COMPLEX_TYPE_DEFINITION_KIND.TOP_LEVEL:
                dataModel.complexTypes
        }
    }
}