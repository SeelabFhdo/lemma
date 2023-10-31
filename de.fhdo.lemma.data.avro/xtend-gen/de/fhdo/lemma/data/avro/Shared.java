package de.fhdo.lemma.data.avro;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.DataFactory;
import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.data.PrimitiveTypeConstants;
import de.fhdo.lemma.data.PrimitiveValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import org.apache.avro.JsonProperties;
import org.apache.avro.LogicalType;
import org.apache.avro.Schema;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Information being shared and that need to be kept consistent between Avro and LEMMA generator.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class Shared {
  /**
   * Static content of the Avro technology model
   */
  public static class StaticAvroTechnologyModel {
    public static String content() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("technology Avro {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("service aspects {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("aspect ");
      _builder.append(Shared.ERROR_ASPECT, "        ");
      _builder.append(" for types;");
      _builder.newLineIfNotEmpty();
      _builder.append("        ");
      _builder.append("aspect ");
      _builder.append(Shared.FIXED_ASPECT, "        ");
      _builder.append(" for types;");
      _builder.newLineIfNotEmpty();
      _builder.append("        ");
      _builder.append("aspect ");
      _builder.append(Shared.FIXED_SIZE_ASPECT, "        ");
      _builder.append(" for fields;");
      _builder.newLineIfNotEmpty();
      _builder.append("        ");
      _builder.append("aspect ");
      _builder.append(Shared.MAP_ASPECT, "        ");
      _builder.append(" for types;");
      _builder.newLineIfNotEmpty();
      _builder.append("        ");
      _builder.append("aspect ");
      _builder.append(Shared.MAP_KEY_ASPECT, "        ");
      _builder.append(" for fields;");
      _builder.newLineIfNotEmpty();
      _builder.append("        ");
      _builder.append("aspect ");
      _builder.append(Shared.MAP_VALUE_ASPECT, "        ");
      _builder.append(" for fields;");
      _builder.newLineIfNotEmpty();
      _builder.append("        ");
      _builder.append("aspect ");
      _builder.append(Shared.UNION_ASPECT, "        ");
      _builder.append(" for types;");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      return _builder.toString();
    }
  }

  /**
   * Name of the Avro technology within the corresponding LEMMA technology model
   */
  public static final String AVRO_TECHNOLOGY_NAME = "Avro";

  /**
   * Names of LEMMA technology aspects to identify Avro records that represent errors
   */
  public static final String ERROR_ASPECT = "AvroError";

  public static final String ERROR_ASPECT_FULLY_QUALIFIED = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(Shared.AVRO_TECHNOLOGY_NAME);
      _builder.append(".");
      _builder.append(Shared.ERROR_ASPECT);
      return _builder.toString();
    }
  }.apply();

  /**
   * Names of LEMMA technology aspects for Avro Fixed types
   */
  public static final String FIXED_ASPECT = "AvroFixed";

  public static final String FIXED_ASPECT_FULLY_QUALIFIED = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(Shared.AVRO_TECHNOLOGY_NAME);
      _builder.append(".");
      _builder.append(Shared.FIXED_ASPECT);
      return _builder.toString();
    }
  }.apply();

  public static final String FIXED_SIZE_ASPECT = "AvroFixedSize";

  public static final String FIXED_SIZE_ASPECT_FULLY_QUALIFIED = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(Shared.AVRO_TECHNOLOGY_NAME);
      _builder.append(".");
      String _plus = (_builder.toString() + 
        Shared.FIXED_SIZE_ASPECT);
      return _plus;
    }
  }.apply();

  /**
   * Names of LEMMA technology aspects for Avro Map types
   */
  public static final String MAP_ASPECT = "AvroMap";

  public static final String MAP_ASPECT_FULLY_QUALIFIED = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(Shared.AVRO_TECHNOLOGY_NAME);
      _builder.append(".");
      _builder.append(Shared.MAP_ASPECT);
      return _builder.toString();
    }
  }.apply();

  public static final String MAP_KEY_ASPECT = "AvroMapKey";

  public static final String MAP_KEY_ASPECT_FULLY_QUALIFIED = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(Shared.AVRO_TECHNOLOGY_NAME);
      _builder.append(".");
      _builder.append(Shared.MAP_KEY_ASPECT);
      return _builder.toString();
    }
  }.apply();

  public static final String MAP_VALUE_ASPECT = "AvroMapValue";

  public static final String MAP_VALUE_ASPECT_FULLY_QUALIFIED = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(Shared.AVRO_TECHNOLOGY_NAME);
      _builder.append(".");
      String _plus = (_builder.toString() + 
        Shared.MAP_VALUE_ASPECT);
      return _plus;
    }
  }.apply();

  /**
   * Names of LEMMA technology aspects for Avro Union types
   */
  public static final String UNION_ASPECT = "AvroUnion";

  public static final String UNION_ASPECT_FULLY_QUALIFIED = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(Shared.AVRO_TECHNOLOGY_NAME);
      _builder.append(".");
      _builder.append(Shared.UNION_ASPECT);
      return _builder.toString();
    }
  }.apply();

  /**
   * Convert the given qualified string to a LEMMA-compatible namespace
   */
  public static String toLemmaNamespace(final String qualifiedString) {
    String _replaceAll = null;
    if (qualifiedString!=null) {
      _replaceAll=qualifiedString.replaceAll("\\.", "_");
    }
    return _replaceAll;
  }

  /**
   * Convert the given qualified string to an Avro-compatible namespace
   */
  public static String toAvroNamespace(final String qualifiedString) {
    String _replaceAll = null;
    if (qualifiedString!=null) {
      _replaceAll=qualifiedString.replaceAll("_", "\\.");
    }
    return _replaceAll;
  }

  /**
   * Convert a value in a primitive LEMMA type to the corresponding Avro primitive value
   */
  public static Object toPrimitiveAvroValue(final String value, final String primitiveLemmaType) {
    if ((value == null)) {
      return null;
    }
    Object _switchResult = null;
    boolean _matched = false;
    String _literal = PrimitiveTypeConstants.BOOLEAN.getLiteral();
    if (Objects.equal(primitiveLemmaType, _literal)) {
      _matched=true;
      _switchResult = Boolean.valueOf(Boolean.parseBoolean(value));
    }
    if (!_matched) {
      String _literal_1 = PrimitiveTypeConstants.BYTE.getLiteral();
      if (Objects.equal(primitiveLemmaType, _literal_1)) {
        _matched=true;
        CharSequence _xblockexpression = null;
        {
          boolean _startsWith = value.startsWith("-");
          if (_startsWith) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append(value);
            _builder.append(" to Avro bytes value, because Avro bytes are ");
            String _plus = ("Cannot convert negative byte value " + _builder);
            String _plus_1 = (_plus + 
              "unsigned");
            throw new IllegalArgumentException(_plus_1);
          }
          final int intValue = Integer.parseInt(value);
          String hexString = Integer.toHexString(intValue).toUpperCase();
          int _length = hexString.length();
          boolean _equals = (_length == 1);
          if (_equals) {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("0");
            _builder_1.append(hexString);
            hexString = _builder_1.toString();
          }
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("\\\\u00");
          _builder_2.append(hexString);
          _xblockexpression = _builder_2;
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      String _literal_2 = PrimitiveTypeConstants.CHARACTER.getLiteral();
      if (Objects.equal(primitiveLemmaType, _literal_2)) {
        _matched=true;
      }
      if (!_matched) {
        String _literal_3 = PrimitiveTypeConstants.DATE.getLiteral();
        if (Objects.equal(primitiveLemmaType, _literal_3)) {
          _matched=true;
        }
      }
      if (!_matched) {
        String _literal_4 = PrimitiveTypeConstants.STRING.getLiteral();
        if (Objects.equal(primitiveLemmaType, _literal_4)) {
          _matched=true;
        }
      }
      if (_matched) {
        _switchResult = new String(value);
      }
    }
    if (!_matched) {
      String _literal_5 = PrimitiveTypeConstants.DOUBLE.getLiteral();
      if (Objects.equal(primitiveLemmaType, _literal_5)) {
        _matched=true;
        _switchResult = Double.valueOf(Double.parseDouble(value));
      }
    }
    if (!_matched) {
      String _literal_6 = PrimitiveTypeConstants.FLOAT.getLiteral();
      if (Objects.equal(primitiveLemmaType, _literal_6)) {
        _matched=true;
        _switchResult = Float.valueOf(Float.parseFloat(value));
      }
    }
    if (!_matched) {
      String _literal_7 = PrimitiveTypeConstants.INTEGER.getLiteral();
      if (Objects.equal(primitiveLemmaType, _literal_7)) {
        _matched=true;
      }
      if (!_matched) {
        String _literal_8 = PrimitiveTypeConstants.SHORT.getLiteral();
        if (Objects.equal(primitiveLemmaType, _literal_8)) {
          _matched=true;
        }
      }
      if (_matched) {
        _switchResult = Integer.valueOf(Integer.parseInt(value));
      }
    }
    if (!_matched) {
      String _literal_9 = PrimitiveTypeConstants.LONG.getLiteral();
      if (Objects.equal(primitiveLemmaType, _literal_9)) {
        _matched=true;
        _switchResult = Long.valueOf(Long.parseLong(value));
      }
    }
    if (!_matched) {
      String _literal_10 = PrimitiveTypeConstants.UNSPECIFIED.getLiteral();
      if (Objects.equal(primitiveLemmaType, _literal_10)) {
        _matched=true;
        _switchResult = null;
      }
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("LEMMA value ");
      _builder.append(value);
      _builder.append(" of type ");
      _builder.append(primitiveLemmaType);
      String _plus = ("Unsupported Avro mapping of primitive " + _builder);
      throw new IllegalArgumentException(_plus);
    }
    return _switchResult;
  }

  /**
   * Get the default value for a complex Avro type that represents the type-specific "empty"
   * value
   */
  public static Object getEmptyComplexAvroValue(final Schema complexType) {
    final Object result = Shared.getEmptyComplexAvroValueInternal(complexType);
    Shared.complexTypeVisitingStack.clear();
    return result;
  }

  /**
   * Internal stack and helper to get the type-specific "empty" default value for a complex Avro
   * type. The stack is used in the traversal of Avro Record types, whose fields may again have
   * Avro Record types, to prevent infinite looping.
   */
  private static final ArrayList<String> complexTypeVisitingStack = CollectionLiterals.<String>newArrayList();

  private static Object getEmptyComplexAvroValueInternal(final Schema complexType) {
    Object _switchResult = null;
    Schema.Type _type = complexType.getType();
    if (_type != null) {
      switch (_type) {
        case ARRAY:
          _switchResult = CollectionLiterals.<Object>emptyList();
          break;
        case ENUM:
          _switchResult = complexType.getEnumSymbols().get(0);
          break;
        case MAP:
          _switchResult = CollectionLiterals.<Object, Object>emptyMap();
          break;
        case RECORD:
          Map<String, Object> _xblockexpression = null;
          {
            boolean _contains = Shared.complexTypeVisitingStack.contains(complexType.getFullName());
            if (_contains) {
              return null;
            }
            Shared.complexTypeVisitingStack.add(complexType.getFullName());
            final Function1<Schema.Field, String> _function = (Schema.Field it) -> {
              return it.name();
            };
            final Function1<Schema.Field, Object> _function_1 = (Schema.Field it) -> {
              return Shared.getDefaultValue(it.schema());
            };
            _xblockexpression = IterableExtensions.<Schema.Field, String, Object>toMap(complexType.getFields(), _function, _function_1);
          }
          _switchResult = _xblockexpression;
          break;
        case UNION:
          _switchResult = complexType.getTypes().get(0);
          break;
        default:
          _switchResult = null;
          break;
      }
    } else {
      _switchResult = null;
    }
    return _switchResult;
  }

  /**
   * Get the type-specific default value of the given Avro schema
   */
  private static Object getDefaultValue(final Schema schema) {
    Object _xifexpression = null;
    LogicalType _logicalType = schema.getLogicalType();
    String _name = null;
    if (_logicalType!=null) {
      _name=_logicalType.getName();
    }
    boolean _equals = Objects.equal(_name, Shared.PRIMITIVE_DATE_AVRO_SCHEMA_NAME);
    if (_equals) {
      _xifexpression = Shared.PRIMITIVE_AVRO_TYPE_SCHEMAS.get(Shared.PRIMITIVE_DATE_AVRO_SCHEMA_NAME).getValue();
    } else {
      Object _xifexpression_1 = null;
      boolean _isPrimitiveAvroType = Shared.isPrimitiveAvroType(schema);
      if (_isPrimitiveAvroType) {
        _xifexpression_1 = Shared.PRIMITIVE_AVRO_TYPE_SCHEMAS.get(schema.getType().getName()).getValue();
      } else {
        _xifexpression_1 = Shared.getEmptyComplexAvroValueInternal(schema);
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }

  /**
   * Avro Logical Type for LEMMA's built-in date primitive
   */
  private static final String PRIMITIVE_DATE_AVRO_SCHEMA_NAME = "timestamp-micros";

  private static final Schema PRIMITIVE_DATE_AVRO_SCHEMA = Shared.logicalType("long", 
    Shared.PRIMITIVE_DATE_AVRO_SCHEMA_NAME);

  /**
   * Map of Avro primitive schemas and instances of their corresponding default value
   */
  private static final Map<String, Pair<Schema, ?>> PRIMITIVE_AVRO_TYPE_SCHEMAS = Collections.<String, Pair<Schema, ?>>unmodifiableMap(CollectionLiterals.<String, Pair<Schema, ?>>newHashMap(Pair.<String, Pair<Schema, Boolean>>of("boolean", Pair.<Schema, Boolean>of(Schema.create(Schema.Type.BOOLEAN), new Boolean(false))), Pair.<String, Pair<Schema, String>>of("bytes", Pair.<Schema, String>of(Schema.create(Schema.Type.BYTES), new String("0"))), Pair.<String, Pair<Schema, Integer>>of("double", Pair.<Schema, Integer>of(Schema.create(Schema.Type.DOUBLE), new Integer(0))), Pair.<String, Pair<Schema, Integer>>of("float", Pair.<Schema, Integer>of(Schema.create(Schema.Type.FLOAT), new Integer(0))), Pair.<String, Pair<Schema, Integer>>of("int", Pair.<Schema, Integer>of(Schema.create(Schema.Type.INT), new Integer(0))), Pair.<String, Pair<Schema, Integer>>of("long", Pair.<Schema, Integer>of(Schema.create(Schema.Type.LONG), new Integer(0))), Pair.<String, Pair<Schema, JsonProperties.Null>>of("null", Pair.<Schema, JsonProperties.Null>of(Schema.create(Schema.Type.NULL), Schema.NULL_VALUE)), Pair.<String, Pair<Schema, String>>of("string", Pair.<Schema, String>of(Schema.create(Schema.Type.STRING), new String(""))), Pair.<String, Pair<Schema, Integer>>of(Shared.PRIMITIVE_DATE_AVRO_SCHEMA_NAME, Pair.<Schema, Integer>of(Shared.PRIMITIVE_DATE_AVRO_SCHEMA, new Integer(0)))));

  /**
   * Helper to create an Avo Logical Type
   */
  private static Schema logicalType(final String typeName, final String logicalTypeName) {
    Schema.Parser _parser = new Schema.Parser();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"type\": \"");
    _builder.append(typeName, "  ");
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("\"logicalType\": \"");
    _builder.append(logicalTypeName, "  ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _parser.parse(_builder.toString());
  }

  /**
   * Convert an Avro schema into a LEMMA PrimitiveType instance
   */
  public static PrimitiveType toPrimitiveLemmaType(final Schema schema) {
    boolean _isPrimitiveAvroType = Shared.isPrimitiveAvroType(schema);
    boolean _not = (!_isPrimitiveAvroType);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Avro schema type ");
      Schema.Type _type = schema.getType();
      _builder.append(_type);
      String _plus = ("Unsupported LEMMA mapping of primitive " + _builder);
      throw new IllegalArgumentException(_plus);
    }
    final DataFactory factory = DataFactory.eINSTANCE;
    LogicalType _logicalType = schema.getLogicalType();
    String _name = null;
    if (_logicalType!=null) {
      _name=_logicalType.getName();
    }
    boolean _equals = Objects.equal(_name, Shared.PRIMITIVE_DATE_AVRO_SCHEMA_NAME);
    if (_equals) {
      return factory.createPrimitiveDate();
    }
    PrimitiveType _switchResult = null;
    Schema.Type _type_1 = schema.getType();
    if (_type_1 != null) {
      switch (_type_1) {
        case BOOLEAN:
          _switchResult = factory.createPrimitiveBoolean();
          break;
        case BYTES:
          _switchResult = factory.createPrimitiveByte();
          break;
        case DOUBLE:
          _switchResult = factory.createPrimitiveDouble();
          break;
        case FLOAT:
          _switchResult = factory.createPrimitiveFloat();
          break;
        case INT:
          _switchResult = factory.createPrimitiveInteger();
          break;
        case LONG:
          _switchResult = factory.createPrimitiveLong();
          break;
        case STRING:
          _switchResult = factory.createPrimitiveString();
          break;
        default:
          _switchResult = factory.createPrimitiveUnspecified();
          break;
      }
    } else {
      _switchResult = factory.createPrimitiveUnspecified();
    }
    return _switchResult;
  }

  /**
   * Check if the given Avro schema represents an Avro primitive type
   */
  public static boolean isPrimitiveAvroType(final Schema schema) {
    boolean _or = false;
    if ((((((((Objects.equal(schema.getType(), Schema.Type.BOOLEAN) || 
      Objects.equal(schema.getType(), Schema.Type.BYTES)) || 
      Objects.equal(schema.getType(), Schema.Type.DOUBLE)) || 
      Objects.equal(schema.getType(), Schema.Type.FLOAT)) || 
      Objects.equal(schema.getType(), Schema.Type.INT)) || 
      Objects.equal(schema.getType(), Schema.Type.LONG)) || 
      Objects.equal(schema.getType(), Schema.Type.NULL)) || 
      Objects.equal(schema.getType(), Schema.Type.STRING))) {
      _or = true;
    } else {
      LogicalType _logicalType = schema.getLogicalType();
      String _name = null;
      if (_logicalType!=null) {
        _name=_logicalType.getName();
      }
      boolean _equals = Objects.equal(_name, Shared.PRIMITIVE_DATE_AVRO_SCHEMA_NAME);
      _or = _equals;
    }
    return _or;
  }

  /**
   * Check if the given Avro schema represents an Avro complex type
   */
  public static boolean isComplexAvroType(final Schema schema) {
    return (((((Objects.equal(schema.getType(), Schema.Type.ARRAY) || 
      Objects.equal(schema.getType(), Schema.Type.ENUM)) || 
      Objects.equal(schema.getType(), Schema.Type.FIXED)) || 
      Objects.equal(schema.getType(), Schema.Type.MAP)) || 
      Objects.equal(schema.getType(), Schema.Type.RECORD)) || 
      Objects.equal(schema.getType(), Schema.Type.UNION));
  }

  /**
   * Retrieve the Avro primitive type for the given LEMMA primitive type identified by its name
   */
  public static Schema toPrimitiveAvroType(final String primitiveLemmaTypeName) {
    Schema _switchResult = null;
    boolean _matched = false;
    String _literal = PrimitiveTypeConstants.BYTE.getLiteral();
    if (Objects.equal(primitiveLemmaTypeName, _literal)) {
      _matched=true;
      _switchResult = Shared.PRIMITIVE_AVRO_TYPE_SCHEMAS.get("bytes").getKey();
    }
    if (!_matched) {
      String _literal_1 = PrimitiveTypeConstants.CHARACTER.getLiteral();
      if (Objects.equal(primitiveLemmaTypeName, _literal_1)) {
        _matched=true;
        _switchResult = Shared.PRIMITIVE_AVRO_TYPE_SCHEMAS.get("string").getKey();
      }
    }
    if (!_matched) {
      String _literal_2 = PrimitiveTypeConstants.DATE.getLiteral();
      if (Objects.equal(primitiveLemmaTypeName, _literal_2)) {
        _matched=true;
        _switchResult = Shared.PRIMITIVE_AVRO_TYPE_SCHEMAS.get(Shared.PRIMITIVE_DATE_AVRO_SCHEMA_NAME).getKey();
      }
    }
    if (!_matched) {
      String _literal_3 = PrimitiveTypeConstants.SHORT.getLiteral();
      if (Objects.equal(primitiveLemmaTypeName, _literal_3)) {
        _matched=true;
        _switchResult = Shared.PRIMITIVE_AVRO_TYPE_SCHEMAS.get("int").getKey();
      }
    }
    if (!_matched) {
      String _literal_4 = PrimitiveTypeConstants.UNSPECIFIED.getLiteral();
      if (Objects.equal(primitiveLemmaTypeName, _literal_4)) {
        _matched=true;
        _switchResult = Shared.PRIMITIVE_AVRO_TYPE_SCHEMAS.get("null").getKey();
      }
    }
    if (!_matched) {
      String _literal_5 = PrimitiveTypeConstants.BOOLEAN.getLiteral();
      if (Objects.equal(primitiveLemmaTypeName, _literal_5)) {
        _matched=true;
      }
      if (!_matched) {
        String _literal_6 = PrimitiveTypeConstants.DOUBLE.getLiteral();
        if (Objects.equal(primitiveLemmaTypeName, _literal_6)) {
          _matched=true;
        }
      }
      if (!_matched) {
        String _literal_7 = PrimitiveTypeConstants.FLOAT.getLiteral();
        if (Objects.equal(primitiveLemmaTypeName, _literal_7)) {
          _matched=true;
        }
      }
      if (!_matched) {
        String _literal_8 = PrimitiveTypeConstants.INTEGER.getLiteral();
        if (Objects.equal(primitiveLemmaTypeName, _literal_8)) {
          _matched=true;
        }
      }
      if (!_matched) {
        String _literal_9 = PrimitiveTypeConstants.LONG.getLiteral();
        if (Objects.equal(primitiveLemmaTypeName, _literal_9)) {
          _matched=true;
        }
      }
      if (!_matched) {
        String _literal_10 = PrimitiveTypeConstants.STRING.getLiteral();
        if (Objects.equal(primitiveLemmaTypeName, _literal_10)) {
          _matched=true;
        }
      }
      if (_matched) {
        _switchResult = Shared.PRIMITIVE_AVRO_TYPE_SCHEMAS.get(primitiveLemmaTypeName).getKey();
      }
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("LEMMA type ");
      _builder.append(primitiveLemmaTypeName);
      String _plus = ("Unsupported Avro mapping of primitive " + _builder);
      throw new IllegalArgumentException(_plus);
    }
    return _switchResult;
  }

  /**
   * Convert an Avro value string to a LEMMA PrimitiveValue for the given LEMMA PrimitiveType
   */
  public static PrimitiveValue toPrimitiveLemmaValue(final String avroValue, final PrimitiveType primitiveType) {
    throw new Error("Unresolved compilation problems:"
      + "\nAccess restriction: The type Hex is not accessible due to restriction on required project de.fhdo.lemma.data.avro");
  }

  /**
   * Helper to check if an Avro schema is a named schema
   */
  public static boolean isNamedSchema(final Schema schema) {
    return ((Objects.equal(schema.getType(), Schema.Type.ENUM) || 
      Objects.equal(schema.getType(), Schema.Type.FIXED)) || 
      Objects.equal(schema.getType(), Schema.Type.RECORD));
  }

  /**
   * Name of JSON property for the original LEMMA qualified name of a derived schema. It is used,
   * e.g., to convert Avro schemas back to LEMMA models. In case the name is present, it will
   * become the name of the resulting LEMMA model element.
   */
  private static final String LEMMA_NAME_PROP = "lemmaName";

  /**
   * Add original LEMMA qualified name to a given schema
   */
  public static void setLemmaName(final Schema schema, final String name) {
    boolean _hasProp = Shared.hasProp(schema, Shared.LEMMA_NAME_PROP);
    boolean _not = (!_hasProp);
    if (_not) {
      schema.addProp(Shared.LEMMA_NAME_PROP, name);
    }
  }

  /**
   * Check if an Avro schema has the JSON property for LEMMA qualified names
   */
  public static boolean hasProp(final Schema schema, final String name) {
    return schema.getObjectProps().keySet().contains(name);
  }

  /**
   * Retrieve the original qualified LEMMA name from the given schema. Returns elseStr, if the
   * schema does not exhibit the JSON property for LEMMA qualified names.
   */
  public static String lemmaNameOrElse(final Schema schema, final String elseStr) {
    String _elvis = null;
    String _lemmaName = Shared.lemmaName(schema);
    if (_lemmaName != null) {
      _elvis = _lemmaName;
    } else {
      _elvis = elseStr;
    }
    final String name = _elvis;
    return name;
  }

  /**
   * Retrieve the original qualified LEMMA name from the given schema, which is the value of the
   * JSON property for LEMMA qualified names. Returns null, if the JSON property is not present
   * in the schema.
   */
  public static String lemmaName(final Schema schema) {
    return schema.getProp(Shared.LEMMA_NAME_PROP);
  }
}
