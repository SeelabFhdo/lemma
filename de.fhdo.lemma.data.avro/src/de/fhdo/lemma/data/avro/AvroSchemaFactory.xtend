package de.fhdo.lemma.data.avro

import static de.fhdo.lemma.data.avro.Util.*
import static de.fhdo.lemma.data.avro.Shared.*
import org.apache.avro.Schema
import java.util.List

/**
 * Helper factory to create Avro schemas of different types and from LEMMA-specific information.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class AvroSchemaFactory {
    /**
     * Create Avro Array
     */
    static def Schema createArray(String lemmaQualifiedName, Schema elementType) {
        val schema = Schema.createArray(elementType)
        setLemmaName(schema, lemmaQualifiedName)
        return schema
    }

    /**
     * Split a LEMMA qualified name into the qualifying and the name part. Additionally, the
     * qualifying part is converted to an Avro-compatible namespace.
     */
    private static def Pair<String, String> nameParts(String lemmaQualifiedName) {
        val parts = splitNameParts(lemmaQualifiedName)
        val avroNamespace = toAvroNamespace(parts.key)
        return avroNamespace -> parts.value
    }

    /**
     * Create Avro Enum
     */
    static def Schema createEnum(String lemmaQualifiedName, String doc, List<String> values) {
        val nameParts = lemmaQualifiedName.nameParts
        val schema = Schema.createEnum(nameParts.value, doc, nameParts.key, values)
        setLemmaName(schema, lemmaQualifiedName)
        return schema
    }

    /**
     * Create Avro Fixed
     */
    static def Schema createFixed(String lemmaQualifiedName, String doc, int size) {
        val nameParts = lemmaQualifiedName.nameParts
        val schema = Schema.createFixed(nameParts.value, doc, nameParts.key, size)
        setLemmaName(schema, lemmaQualifiedName)
        return schema
    }

    /**
     * Create Avro Map
     */
    static def Schema createMap(String lemmaQualifiedName, Schema valueType) {
        val schema = Schema.createMap(valueType)
        setLemmaName(schema, lemmaQualifiedName)
        return schema
    }

    /**
     * Create Avro Record
     */
    static def Schema createRecord(String lemmaQualifiedName, String doc, boolean isError) {
        val nameParts = lemmaQualifiedName.nameParts
        val schema = Schema.createRecord(nameParts.value, doc, nameParts.key, isError)
        setLemmaName(schema, lemmaQualifiedName)
        return schema
    }

    /**
     * Create Avro Union. Setting includeNullSchema to true, results in adding Avro's NULL schema
     * type to the union.
     */
    static def Schema createUnion(String lemmaQualifiedName, List<Schema> types,
        boolean includeNullSchema) {
        val schema = if (includeNullSchema && !types.exists[it.type == Schema.Type.NULL])
                Schema.createUnion(types)
            else {
                val typesWithNull = <Schema>newArrayList
                typesWithNull.add(Schema.create(Schema.Type.NULL))
                typesWithNull.addAll(types)
                Schema.createUnion(typesWithNull)
            }

        setLemmaName(schema, lemmaQualifiedName)
        return schema
    }
}