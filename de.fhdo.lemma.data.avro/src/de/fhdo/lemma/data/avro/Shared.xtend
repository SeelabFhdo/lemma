package de.fhdo.lemma.data.avro

import org.apache.avro.Schema
import de.fhdo.lemma.data.PrimitiveTypeConstants
import de.fhdo.lemma.data.PrimitiveType
import de.fhdo.lemma.data.DataFactory
import de.fhdo.lemma.data.PrimitiveValue
import de.fhdo.lemma.data.PrimitiveBoolean
import de.fhdo.lemma.data.PrimitiveByte
import org.apache.commons.codec.binary.Hex
import de.fhdo.lemma.utils.LemmaUtils
import java.math.BigDecimal
import de.fhdo.lemma.data.PrimitiveCharacter
import de.fhdo.lemma.data.PrimitiveString
import de.fhdo.lemma.data.PrimitiveDate
import de.fhdo.lemma.data.PrimitiveDouble
import de.fhdo.lemma.data.PrimitiveFloat
import de.fhdo.lemma.data.PrimitiveInteger
import de.fhdo.lemma.data.PrimitiveLong
import de.fhdo.lemma.data.PrimitiveShort

/**
 * Information being shared and that need to be kept consistent between Avro and LEMMA generator.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class Shared {
    /**
     * Name of the Avro technology within the corresponding LEMMA technology model
     */
    public static val AVRO_TECHNOLOGY_NAME = "Avro"

    /**
     * Names of LEMMA technology aspects to identify Avro records that represent errors
     */
    public static val ERROR_ASPECT = "AvroError"
    public static val ERROR_ASPECT_FULLY_QUALIFIED = '''«AVRO_TECHNOLOGY_NAME».«ERROR_ASPECT»'''

    /**
     * Names of LEMMA technology aspects for Avro Fixed types
     */
    public static val FIXED_ASPECT = "AvroFixed"
    public static val FIXED_ASPECT_FULLY_QUALIFIED = '''«AVRO_TECHNOLOGY_NAME».«FIXED_ASPECT»'''
    public static val FIXED_SIZE_ASPECT = "AvroFixedSize"
    public static val FIXED_SIZE_ASPECT_FULLY_QUALIFIED = '''«AVRO_TECHNOLOGY_NAME».''' +
        FIXED_SIZE_ASPECT

    /**
     * Names of LEMMA technology aspects for Avro Map types
     */
    public static val MAP_ASPECT = "AvroMap"
    public static val MAP_ASPECT_FULLY_QUALIFIED = '''«AVRO_TECHNOLOGY_NAME».«MAP_ASPECT»'''
    public static val MAP_KEY_ASPECT = "AvroMapKey"
    public static val MAP_KEY_ASPECT_FULLY_QUALIFIED = '''«AVRO_TECHNOLOGY_NAME».«MAP_KEY_ASPECT»'''
    public static val MAP_VALUE_ASPECT = "AvroMapValue"
    public static val MAP_VALUE_ASPECT_FULLY_QUALIFIED = '''«AVRO_TECHNOLOGY_NAME».''' +
        MAP_VALUE_ASPECT

    /**
     * Names of LEMMA technology aspects for Avro Union types
     */
    public static val UNION_ASPECT = "AvroUnion"
    public static val UNION_ASPECT_FULLY_QUALIFIED = '''«AVRO_TECHNOLOGY_NAME».«UNION_ASPECT»'''

    /**
     * Convert the given qualified string to a LEMMA-compatible namespace
     */
    static def String toLemmaNamespace(String qualifiedString) {
        return qualifiedString?.replaceAll("\\.", "_")
    }

    /**
     * Convert the given qualified string to an Avro-compatible namespace
     */
    static def String toAvroNamespace(String qualifiedString) {
        return qualifiedString?.replaceAll("_", "\\.")
    }

    /**
     * Convert a value in a primitive LEMMA type to the corresponding Avro primitive value
     */
    static def Object toPrimitiveAvroValue(String value, String primitiveLemmaType) {
        if (value === null)
            return null

        return switch(primitiveLemmaType) {
            case PrimitiveTypeConstants.BOOLEAN.literal:
                Boolean.parseBoolean(value)

            case PrimitiveTypeConstants.BYTE.literal: {
                if (value.startsWith("-"))
                    throw new IllegalArgumentException("Cannot convert negative byte value " +
                        '''«value» to Avro bytes value, because Avro bytes are ''' +
                        "unsigned")
                val intValue = Integer.parseInt(value)
                var hexString = Integer.toHexString(intValue).toUpperCase
                if (hexString.length == 1)
                    hexString = '''0«hexString»'''
                '''\\u00«hexString»'''
            }

            case PrimitiveTypeConstants.CHARACTER.literal,
            case PrimitiveTypeConstants.DATE.literal,
            case PrimitiveTypeConstants.STRING.literal:
                new String(value)

            case PrimitiveTypeConstants.DOUBLE.literal:
                Double.parseDouble(value)

            case PrimitiveTypeConstants.FLOAT.literal:
                Float.parseFloat(value)

            case PrimitiveTypeConstants.INTEGER.literal,
            case PrimitiveTypeConstants.SHORT.literal:
                Integer.parseInt(value)

            case PrimitiveTypeConstants.LONG.literal:
                Long.parseLong(value)

            case PrimitiveTypeConstants.UNSPECIFIED.literal:
                null

            default: throw new IllegalArgumentException("Unsupported Avro mapping of primitive " +
                '''LEMMA value «value» of type «primitiveLemmaType»''')
        }
    }

    /**
     * Get the default value for a complex Avro type that represents the type-specific "empty"
     * value
     */
    static def Object getEmptyComplexAvroValue(Schema complexType) {
        val result = getEmptyComplexAvroValueInternal(complexType)
        complexTypeVisitingStack.clear
        return result
    }

    /**
     * Internal stack and helper to get the type-specific "empty" default value for a complex Avro
     * type. The stack is used in the traversal of Avro Record types, whose fields may again have
     * Avro Record types, to prevent infinite looping.
     */
    static val complexTypeVisitingStack = <String>newArrayList
    private static def Object getEmptyComplexAvroValueInternal(Schema complexType) {
        return switch(complexType.type) {
            case Schema.Type.ARRAY: emptyList
            case Schema.Type.ENUM: complexType.enumSymbols.get(0)
            case Schema.Type.MAP: emptyMap
            case Schema.Type.RECORD: {
                if (complexTypeVisitingStack.contains(complexType.fullName))
                    return null
                complexTypeVisitingStack.add(complexType.fullName)
                complexType.fields.toMap([it.name], [it.schema.getDefaultValue])
            }
            case Schema.Type.UNION: complexType.types.get(0)
            default: null
        }
    }

    /**
     * Get the type-specific default value of the given Avro schema
     */
    private static def Object getDefaultValue(Schema schema) {
        return if (schema.logicalType?.name == PRIMITIVE_DATE_AVRO_SCHEMA_NAME)
                PRIMITIVE_AVRO_TYPE_SCHEMAS.get(PRIMITIVE_DATE_AVRO_SCHEMA_NAME).value
            else if (schema.isPrimitiveAvroType)
                PRIMITIVE_AVRO_TYPE_SCHEMAS.get(schema.type.getName()).value
            else
                getEmptyComplexAvroValueInternal(schema)
    }

    /**
     * Avro Logical Type for LEMMA's built-in date primitive
     */
    static val PRIMITIVE_DATE_AVRO_SCHEMA_NAME = "timestamp-micros"
    static val Schema PRIMITIVE_DATE_AVRO_SCHEMA = logicalType("long",
        PRIMITIVE_DATE_AVRO_SCHEMA_NAME)

    /**
     * Map of Avro primitive schemas and instances of their corresponding default value
     */
    static val PRIMITIVE_AVRO_TYPE_SCHEMAS = #{
        "boolean" -> (Schema.create(Schema.Type.BOOLEAN) -> new Boolean(false)),
        "bytes" -> (Schema.create(Schema.Type.BYTES) -> new String("0")),
        "double" -> (Schema.create(Schema.Type.DOUBLE) -> new Integer(0)),
        "float" -> (Schema.create(Schema.Type.FLOAT) -> new Integer(0)),
        "int" -> (Schema.create(Schema.Type.INT) -> new Integer(0)),
        "long" -> (Schema.create(Schema.Type.LONG) -> new Integer(0)),
        "null" -> (Schema.create(Schema.Type.NULL) -> Schema.NULL_VALUE),
        "string" -> (Schema.create(Schema.Type.STRING) -> new String("")),
        PRIMITIVE_DATE_AVRO_SCHEMA_NAME -> (PRIMITIVE_DATE_AVRO_SCHEMA -> new Integer(0))
    }

    /**
     * Helper to create an Avo Logical Type
     */
    private static def Schema logicalType(String typeName, String logicalTypeName) {
        return new Schema.Parser().parse('''
            {
              "type": "«typeName»",
              "logicalType": "«logicalTypeName»"
            }
        ''')
    }

    /**
     * Convert an Avro schema into a LEMMA PrimitiveType instance
     */
    static def PrimitiveType toPrimitiveLemmaType(Schema schema) {
        if (!schema.isPrimitiveAvroType)
            throw new IllegalArgumentException("Unsupported LEMMA mapping of primitive " +
                '''Avro schema type «schema.type»''')

        val factory = DataFactory.eINSTANCE

        if (schema.logicalType?.name == PRIMITIVE_DATE_AVRO_SCHEMA_NAME)
            return factory.createPrimitiveDate

        return switch(schema.type) {
            case Schema.Type.BOOLEAN: factory.createPrimitiveBoolean
            case Schema.Type.BYTES: factory.createPrimitiveByte
            case Schema.Type.DOUBLE: factory.createPrimitiveDouble
            case Schema.Type.FLOAT: factory.createPrimitiveFloat
            case Schema.Type.INT: factory.createPrimitiveInteger
            case Schema.Type.LONG: factory.createPrimitiveLong
            case Schema.Type.STRING: factory.createPrimitiveString
            default: factory.createPrimitiveUnspecified  // also covers Avro schema "null"
        }
    }

    /**
     * Check if the given Avro schema represents an Avro primitive type
     */
    static def boolean isPrimitiveAvroType(Schema schema) {
        return schema.type == Schema.Type.BOOLEAN ||
            schema.type == Schema.Type.BYTES ||
            schema.type == Schema.Type.DOUBLE ||
            schema.type == Schema.Type.FLOAT ||
            schema.type == Schema.Type.INT ||
            schema.type == Schema.Type.LONG ||
            schema.type == Schema.Type.NULL ||
            schema.type == Schema.Type.STRING ||
            schema.logicalType?.name == PRIMITIVE_DATE_AVRO_SCHEMA_NAME
    }

    /**
     * Check if the given Avro schema represents an Avro complex type
     */
    static def boolean isComplexAvroType(Schema schema) {
        return schema.type == Schema.Type.ARRAY ||
            schema.type == Schema.Type.ENUM ||
            schema.type == Schema.Type.FIXED ||
            schema.type == Schema.Type.MAP ||
            schema.type == Schema.Type.RECORD ||
            schema.type == Schema.Type.UNION
    }

    /**
     * Retrieve the Avro primitive type for the given LEMMA primitive type identified by its name
     */
    static def Schema toPrimitiveAvroType(String primitiveLemmaTypeName) {
        return switch(primitiveLemmaTypeName) {
            case PrimitiveTypeConstants.BYTE.literal:
                PRIMITIVE_AVRO_TYPE_SCHEMAS.get("bytes").key
            case PrimitiveTypeConstants.CHARACTER.literal:
                PRIMITIVE_AVRO_TYPE_SCHEMAS.get("string").key
            case PrimitiveTypeConstants.DATE.literal:
                PRIMITIVE_AVRO_TYPE_SCHEMAS.get(PRIMITIVE_DATE_AVRO_SCHEMA_NAME).key
            case PrimitiveTypeConstants.SHORT.literal:
                PRIMITIVE_AVRO_TYPE_SCHEMAS.get("int").key
            case PrimitiveTypeConstants.UNSPECIFIED.literal:
                PRIMITIVE_AVRO_TYPE_SCHEMAS.get("null").key
            case PrimitiveTypeConstants.BOOLEAN.literal,
            case PrimitiveTypeConstants.DOUBLE.literal,
            case PrimitiveTypeConstants.FLOAT.literal,
            case PrimitiveTypeConstants.INTEGER.literal,
            case PrimitiveTypeConstants.LONG.literal,
            case PrimitiveTypeConstants.STRING.literal:
                PRIMITIVE_AVRO_TYPE_SCHEMAS.get(primitiveLemmaTypeName).key

            default: throw new IllegalArgumentException("Unsupported Avro mapping of primitive " +
                '''LEMMA type «primitiveLemmaTypeName»''')
        }
    }

    /**
     * Convert an Avro value string to a LEMMA PrimitiveValue for the given LEMMA PrimitiveType
     */
    static def PrimitiveValue toPrimitiveLemmaValue(String avroValue, PrimitiveType primitiveType) {
        if (avroValue === null)
            return null

        val lemmaValue = DataFactory.eINSTANCE.createPrimitiveValue
        switch(primitiveType) {
            PrimitiveBoolean:
                lemmaValue.booleanValue = Boolean.parseBoolean(avroValue)

            PrimitiveByte: {
                try {
                    val bytes = Hex.decodeHex(
                        LemmaUtils.removePrefix(avroValue, "\\\\u", false)
                    )
                    lemmaValue.numericValue = new BigDecimal(Byte.toUnsignedInt(bytes.last))
                    if (!lemmaValue.isInClosedSet(BigDecimal.ZERO, new BigDecimal(255)))
                        throw new IllegalArgumentException("Not an unsigned byte value")
                } catch (Exception ex) {
                    throw new IllegalArgumentException('''Value «avroValue» cannot be converted''' +
                        '''to LEMMA byte value: «ex.message»''')
                }
            }

            PrimitiveCharacter,
            PrimitiveString:
                lemmaValue.stringValue = avroValue

            PrimitiveDate: {
                lemmaValue.stringValue = avroValue
                if (lemmaValue.asDate() === null)
                    throw new IllegalArgumentException('''Value «avroValue» cannot be converted''' +
                        "to LEMMA date value: Not an ISO-8601 date ")
            }

            PrimitiveDouble:
                lemmaValue.numericValue = new BigDecimal(Double.parseDouble(avroValue))

            PrimitiveFloat:
                lemmaValue.numericValue = new BigDecimal(Float.parseFloat(avroValue))

            PrimitiveInteger:
                lemmaValue.numericValue = new BigDecimal(Integer.parseInt(avroValue))

            PrimitiveLong:
                lemmaValue.numericValue = new BigDecimal(Long.parseLong(avroValue))

            PrimitiveShort:
                lemmaValue.numericValue = new BigDecimal(Short.parseShort(avroValue))

            default: throw new IllegalArgumentException("Unsupported LEMMA mapping of primitive " +
                '''Avro value «avroValue» of type «primitiveType.class.simpleName»''')
        }

        return lemmaValue
    }

    /**
     * Helper to check if an Avro schema is a named schema
     */
    static def boolean isNamedSchema(Schema schema) {
        return schema.type == Schema.Type.ENUM ||
            schema.type == Schema.Type.FIXED ||
            schema.type == Schema.Type.RECORD
    }

    /**
     * Name of JSON property for the original LEMMA qualified name of a derived schema. It is used,
     * e.g., to convert Avro schemas back to LEMMA models. In case the name is present, it will
     * become the name of the resulting LEMMA model element.
     */
    static val LEMMA_NAME_PROP = "lemmaName"

    /**
     * Add original LEMMA qualified name to a given schema
     */
    static def void setLemmaName(Schema schema, String name) {
        if (!schema.hasProp(LEMMA_NAME_PROP))
            schema.addProp(LEMMA_NAME_PROP, name)
    }

    /**
     * Check if an Avro schema has the JSON property for LEMMA qualified names
     */
    static def boolean hasProp(Schema schema, String name) {
        return schema.objectProps.keySet.contains(name)
    }

    /**
     * Retrieve the original qualified LEMMA name from the given schema. Returns elseStr, if the
     * schema does not exhibit the JSON property for LEMMA qualified names.
     */
    static def String lemmaNameOrElse(Schema schema, String elseStr) {
        val name = lemmaName(schema) ?: elseStr
        return name
    }

    /**
     * Retrieve the original qualified LEMMA name from the given schema, which is the value of the
     * JSON property for LEMMA qualified names. Returns null, if the JSON property is not present
     * in the schema.
     */
    static def String lemmaName(Schema schema) {
        return schema.getProp(LEMMA_NAME_PROP)
    }

    /**
     * Static content of the Avro technology model
     */
    static class StaticAvroTechnologyModel {
        static def String content() {
            '''
            technology Avro {
                service aspects {
                    aspect «ERROR_ASPECT» for types;
                    aspect «FIXED_ASPECT» for types;
                    aspect «FIXED_SIZE_ASPECT» for fields;
                    aspect «MAP_ASPECT» for types;
                    aspect «MAP_KEY_ASPECT» for fields;
                    aspect «MAP_VALUE_ASPECT» for fields;
                    aspect «UNION_ASPECT» for types;
                }
            }'''
        }
    }
}