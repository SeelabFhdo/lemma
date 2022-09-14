package de.fhdo.lemma.data.avro;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import de.fhdo.lemma.data.PrimitiveTypeConstants;
import de.fhdo.lemma.data.intermediate.IntermediateCollectionType;
import de.fhdo.lemma.data.intermediate.IntermediateComplexType;
import de.fhdo.lemma.data.intermediate.IntermediateContext;
import de.fhdo.lemma.data.intermediate.IntermediateDataField;
import de.fhdo.lemma.data.intermediate.IntermediateDataModel;
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure;
import de.fhdo.lemma.data.intermediate.IntermediateEnumeration;
import de.fhdo.lemma.data.intermediate.IntermediateEnumerationField;
import de.fhdo.lemma.data.intermediate.IntermediateImportedComplexType;
import de.fhdo.lemma.data.intermediate.IntermediateType;
import de.fhdo.lemma.data.intermediate.IntermediateTypeKind;
import de.fhdo.lemma.data.intermediate.IntermediateTypeOrigin;
import de.fhdo.lemma.data.intermediate.IntermediateVersion;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import org.apache.avro.Protocol;
import org.apache.avro.Schema;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Generate Avro schema specifications from LEMMA intermediate data models.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class AvroGenerator {
  /**
   * Generate schemas from IntermediateVersion
   */
  public List<Schema> generateSchemasFrom(final IntermediateVersion version) {
    Iterable<IntermediateComplexType> _xifexpression = null;
    boolean _isEmpty = version.getContexts().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Function1<IntermediateContext, EList<IntermediateComplexType>> _function = (IntermediateContext it) -> {
        return it.getComplexTypes();
      };
      _xifexpression = Iterables.<IntermediateComplexType>concat(ListExtensions.<IntermediateContext, EList<IntermediateComplexType>>map(version.getContexts(), _function));
    } else {
      _xifexpression = version.getComplexTypes();
    }
    final Iterable<IntermediateComplexType> complexTypes = _xifexpression;
    final Function1<IntermediateComplexType, List<Schema>> _function_1 = (IntermediateComplexType it) -> {
      return this.generateSchemasFrom(it).getValue();
    };
    return this.withoutDuplicates(IterableExtensions.<Schema>toList(Iterables.<Schema>concat(IterableExtensions.<IntermediateComplexType, List<Schema>>map(complexTypes, _function_1))));
  }
  
  /**
   * Helper to remove duplicate schemas from a given list of schemas. Duplicate schemas are
   * identified by their LEMMA name (based on the custom helper JSON property LEMMA_NAME_PROP).
   */
  private List<Schema> withoutDuplicates(final List<Schema> schemas) {
    final LinkedHashMap<String, Schema> uniqueSchemas = CollectionLiterals.<String, Schema>newLinkedHashMap();
    final Consumer<Schema> _function = (Schema it) -> {
      uniqueSchemas.put(Shared.lemmaName(it), it);
    };
    schemas.forEach(_function);
    return IterableExtensions.<Schema>toList(uniqueSchemas.values());
  }
  
  /**
   * Generate schemas from IntermediateContext
   */
  public List<Schema> generateSchemasFrom(final IntermediateContext context) {
    final Function1<IntermediateComplexType, List<Schema>> _function = (IntermediateComplexType it) -> {
      return this.generateSchemasFrom(it).getValue();
    };
    return this.withoutDuplicates(IterableExtensions.<Schema>toList(Iterables.<Schema>concat(ListExtensions.<IntermediateComplexType, List<Schema>>map(context.getComplexTypes(), _function))));
  }
  
  /**
   * Generate schemas from IntermediateComplexType. The return value is a pair consisting of the
   * schema specifically derived from the passed complex type and all other schemas that were
   * derived during schema generation in the context of the passed complex type, e.g., those of a
   * structure's data fields' types.
   */
  public Pair<Schema, List<Schema>> generateSchemasFrom(final IntermediateComplexType complexType) {
    Pair<Schema, List<Schema>> _switchResult = null;
    boolean _matched = false;
    if (complexType instanceof IntermediateDataStructure) {
      _matched=true;
      _switchResult = this.generateSchemasFrom(((IntermediateDataStructure)complexType));
    }
    if (!_matched) {
      if (complexType instanceof IntermediateCollectionType) {
        _matched=true;
        _switchResult = this.generateSchemasFrom(((IntermediateCollectionType)complexType));
      }
    }
    if (!_matched) {
      if (complexType instanceof IntermediateEnumeration) {
        _matched=true;
        _switchResult = this.generateSchemasFrom(((IntermediateEnumeration)complexType));
      }
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      String _simpleName = complexType.getClass().getSimpleName();
      _builder.append(_simpleName);
      _builder.append(" complex types is not supported");
      String _plus = ("Schemas\' generation for " + _builder);
      throw new IllegalArgumentException(_plus);
    }
    return _switchResult;
  }
  
  /**
   * Generate schemas from IntermediateDataStructure. The return value is a pair consisting of the
   * schema specifically derived from the passed structure and all other schemas that were derived
   * during schema generation in the context of the passed structure, e.g., those of its data
   * fields' types.
   */
  public Pair<Schema, List<Schema>> generateSchemasFrom(final IntermediateDataStructure structure) {
    Pair<Schema, List<Schema>> _xifexpression = null;
    boolean _isFixedSchemaType = this.isFixedSchemaType(structure);
    if (_isFixedSchemaType) {
      _xifexpression = this.toFixed(structure, null);
    } else {
      Pair<Schema, List<Schema>> _xifexpression_1 = null;
      boolean _isMapSchemaType = this.isMapSchemaType(structure);
      if (_isMapSchemaType) {
        _xifexpression_1 = this.toMap(structure, null);
      } else {
        Pair<Schema, List<Schema>> _xifexpression_2 = null;
        boolean _isUnionSchemaType = this.isUnionSchemaType(structure);
        if (_isUnionSchemaType) {
          _xifexpression_2 = this.toUnion(structure, null);
        } else {
          _xifexpression_2 = this.toRecord(structure, null);
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  /**
   * Helper to determine if an IntermediateDataStructure represents an Avro Fixed type. This is
   * the case, if the structure has the "AvroFixed" aspect, and the first visible data field is an
   * integer with an initialization value greater zero and exhibits the "AvroFixedSize" aspect.
   */
  private boolean isFixedSchemaType(final IntermediateDataStructure structure) {
    final List<IntermediateDataField> visibleFields = Util.visibleFields(structure);
    if (((!Util.hasAspect(structure, Shared.FIXED_ASPECT_FULLY_QUALIFIED)) || (visibleFields.size() != 1))) {
      return false;
    }
    final IntermediateDataField sizeField = visibleFields.get(0);
    return (((Util.hasAspect(sizeField, Shared.FIXED_SIZE_ASPECT_FULLY_QUALIFIED) && 
      Util.isPrimitiveType(sizeField.getOriginalType(), PrimitiveTypeConstants.INTEGER.getLiteral())) && 
      (sizeField.getInitializationValue() != null)) && 
      (Integer.parseInt(sizeField.getInitializationValue()) > 0));
  }
  
  /**
   * Internal helper to generate schemas from an IntermediateDataStructure, which represents an
   * Avro Fixed type. By contrast to the public toFixed(IntermediateDataStructure) method for
   * external callers, this internal helper is model-URI-aware.
   */
  private Pair<Schema, List<Schema>> toFixed(final IntermediateDataStructure structure, final String modelUri) {
    boolean _isFixedSchemaType = this.isFixedSchemaType(structure);
    boolean _not = (!_isFixedSchemaType);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Structure ");
      String _qualifiedName = structure.getQualifiedName();
      _builder.append(_qualifiedName);
      _builder.append(" cannot ");
      String _plus = (_builder.toString() + 
        "be converted to Avro Fixed type");
      throw new IllegalArgumentException(_plus);
    }
    final Function1<IntermediateDataField, Boolean> _function = (IntermediateDataField it) -> {
      return Boolean.valueOf(Util.hasAspect(it, Shared.FIXED_SIZE_ASPECT_FULLY_QUALIFIED));
    };
    final IntermediateDataField sizeField = IterableExtensions.<IntermediateDataField>findFirst(Util.visibleFields(structure), _function);
    final int size = Integer.parseInt(sizeField.getInitializationValue());
    final Schema fixed = AvroSchemaFactory.createFixed(structure.getQualifiedName(), "", size);
    this.finishedComplexTypeSchemaCreation(fixed, modelUri);
    List<Schema> _createdSchemasForModel = this.createdSchemasForModel(modelUri);
    return Pair.<Schema, List<Schema>>of(fixed, _createdSchemasForModel);
  }
  
  /**
   * Handle finishing of schema creation for IntermediateComplexTypes
   */
  private void finishedComplexTypeSchemaCreation(final Schema schema, final String modelUri) {
    Util.<String, String, Schema>addToValueMap(this.createdSchemas, modelUri, Shared.lemmaName(schema), schema);
    Util.<String, String, Schema>removeFromValueMap(this.schemasCreationStack, modelUri, Shared.lemmaName(schema));
  }
  
  /**
   * Map of all Avro schemas created by this instance of AvroGenerator. Note, that the map is not
   * reset after a schema generation run. The key of the map is the URI of the LEMMA model, for
   * which schemas were created. The value of the map is a nested map, whose key is the LEMMA name
   * of the schema and whose value is the schema itself.
   */
  private final LinkedHashMap<String, Map<String, Schema>> createdSchemas = CollectionLiterals.<String, Map<String, Schema>>newLinkedHashMap();
  
  /**
   * Map of all Avro schemas, whose creation is not finished yet, e.g., because nested schemas are
   * currently generated. An entry is removed from the stack, as soon as the corresponding schema
   * for a model got fully created. The structure of the map is the same as for the
   * "createdSchemas" map.
   */
  private final LinkedHashMap<String, Map<String, Schema>> schemasCreationStack = CollectionLiterals.<String, Map<String, Schema>>newLinkedHashMap();
  
  /**
   * Get all created schemas for the given modelUri
   */
  private List<Schema> createdSchemasForModel(final String modelUri) {
    Map<String, Schema> _get = this.createdSchemas.get(modelUri);
    Collection<Schema> _values = null;
    if (_get!=null) {
      _values=_get.values();
    }
    return IterableExtensions.<Schema>toList(_values);
  }
  
  /**
   * Generate schemas from IntermediateDataStructure, which represents an Avro Fixed type. Returns
   * a pair consisting of the schema for the IntermediateDataStructure and all schemas that were
   * created during generation.
   */
  public Pair<Schema, List<Schema>> toFixed(final IntermediateDataStructure structure) {
    final Schema fixed = this.toFixed(structure, null).getKey();
    List<Schema> _allCreatedSchemas = this.allCreatedSchemas();
    return Pair.<Schema, List<Schema>>of(fixed, _allCreatedSchemas);
  }
  
  /**
   * Get all fully created schemas across all models
   */
  private List<Schema> allCreatedSchemas() {
    final Function1<Map<String, Schema>, Collection<Schema>> _function = (Map<String, Schema> it) -> {
      return it.values();
    };
    return IterableExtensions.<Schema>toList(Iterables.<Schema>concat(IterableExtensions.<Map<String, Schema>, Collection<Schema>>map(this.createdSchemas.values(), _function)));
  }
  
  /**
   * Helper to determine if an IntermediateDataStructure represents an Avro Map type. This is the
   * case, if the structure has the "AvroMap" aspect and exactly two visible data fields. The
   * first visible data field must exhibit the "AvroMapKey" aspect and be of type string. The
   * second visible data field must exhibit the "AvroMapValue" aspect and may have an arbitrary
   * type.
   */
  private boolean isMapSchemaType(final IntermediateDataStructure structure) {
    final List<IntermediateDataField> visibleFields = Util.visibleFields(structure);
    if (((!Util.hasAspect(structure, Shared.MAP_ASPECT_FULLY_QUALIFIED)) || (visibleFields.size() != 2))) {
      return false;
    }
    final IntermediateDataField firstField = visibleFields.get(0);
    final IntermediateDataField secondField = visibleFields.get(1);
    return ((Util.hasAspect(firstField, Shared.MAP_KEY_ASPECT_FULLY_QUALIFIED) && 
      Util.isPrimitiveType(firstField.getOriginalType(), PrimitiveTypeConstants.STRING.getLiteral())) && 
      Util.hasAspect(secondField, Shared.MAP_VALUE_ASPECT_FULLY_QUALIFIED));
  }
  
  /**
   * Helper to determine if an IntermediateDataStructure represents an Avro Union type. This is
   * the case, if the structure has the "AvroUnion" aspect and visible data fields.
   */
  private boolean isUnionSchemaType(final IntermediateDataStructure structure) {
    return (Util.hasAspect(structure, Shared.UNION_ASPECT_FULLY_QUALIFIED) && 
      (!Util.visibleFields(structure).isEmpty()));
  }
  
  /**
   * Generate schemas from IntermediateDataStructure, which represents an Avro Map type. Returns
   * a pair consisting of the schema for the IntermediateDataStructure and all schemas that were
   * created during generation.
   */
  public Pair<Schema, List<Schema>> toMap(final IntermediateDataStructure structure) {
    final Schema map = this.toMap(structure, null).getKey();
    List<Schema> _allCreatedSchemas = this.allCreatedSchemas();
    return Pair.<Schema, List<Schema>>of(map, _allCreatedSchemas);
  }
  
  /**
   * Internal helper to generate schemas from an IntermediateDataStructure, which represents an
   * Avro Map type. By contrast to the public toMap(IntermediateDataStructure) method for external
   * callers, this internal helper is model-URI-aware.
   */
  private Pair<Schema, List<Schema>> toMap(final IntermediateDataStructure structure, final String modelUri) {
    boolean _isMapSchemaType = this.isMapSchemaType(structure);
    boolean _not = (!_isMapSchemaType);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Structure ");
      String _qualifiedName = structure.getQualifiedName();
      _builder.append(_qualifiedName);
      _builder.append(" cannot ");
      String _plus = (_builder.toString() + 
        "be converted to Avro Map");
      throw new IllegalArgumentException(_plus);
    }
    final Function1<IntermediateDataField, Boolean> _function = (IntermediateDataField it) -> {
      return Boolean.valueOf(Util.hasAspect(it, Shared.MAP_VALUE_ASPECT_FULLY_QUALIFIED));
    };
    final IntermediateDataField mapValueField = IterableExtensions.<IntermediateDataField>findFirst(Util.visibleFields(structure), _function);
    final Schema valueType = this.toRecord(CollectionLiterals.<IntermediateDataField>newArrayList(mapValueField), modelUri, structure.getQualifiedName());
    final Schema avroMap = AvroSchemaFactory.createMap(structure.getQualifiedName(), valueType);
    this.finishedComplexTypeSchemaCreation(avroMap, modelUri);
    List<Schema> _createdSchemasForModel = this.createdSchemasForModel(modelUri);
    return Pair.<Schema, List<Schema>>of(avroMap, _createdSchemasForModel);
  }
  
  /**
   * Create an Avro Record type from a list of IntermediateDataFields. Convenience method, which
   * creates Avro records that do not represent errors.
   */
  private Schema toRecord(final List<IntermediateDataField> dataFields, final String modelUri, final String qualifiedName) {
    return this.toRecord(dataFields, modelUri, qualifiedName, false);
  }
  
  /**
   * Create an Avro Record type from a list of IntermediateDataFields for model with the given URI
   * and with the qualifiedName. isError may be set to true, if the created Avro record shall
   * represent an error.
   */
  private Schema toRecord(final List<IntermediateDataField> dataFields, final String modelUri, final String qualifiedName, final boolean isError) {
    final Schema record = AvroSchemaFactory.createRecord(qualifiedName, "", isError);
    Util.<String, String, Schema>addToValueMap(this.schemasCreationStack, modelUri, Shared.lemmaName(record), record);
    final Function1<IntermediateDataField, Schema.Field> _function = (IntermediateDataField it) -> {
      return this.toField(it);
    };
    record.setFields(ListExtensions.<IntermediateDataField, Schema.Field>map(dataFields, _function));
    this.finishedComplexTypeSchemaCreation(record, modelUri);
    return record;
  }
  
  /**
   * Create an Avro Schema Field from an IntermediateDataField
   */
  private Schema.Field toField(final IntermediateDataField field) {
    final Schema type = this.getSchema(field);
    Object _xifexpression = null;
    String _initializationValue = field.getInitializationValue();
    boolean _tripleNotEquals = (_initializationValue != null);
    if (_tripleNotEquals) {
      _xifexpression = Shared.toPrimitiveAvroValue(field.getInitializationValue(), field.getOriginalType().getName());
    } else {
      Object _xifexpression_1 = null;
      boolean _isComplexAvroType = Shared.isComplexAvroType(type);
      if (_isComplexAvroType) {
        _xifexpression_1 = Shared.getEmptyComplexAvroValue(type);
      }
      _xifexpression = _xifexpression_1;
    }
    final Object defaultValue = _xifexpression;
    String _name = field.getName();
    return new Schema.Field(_name, type, "", defaultValue);
  }
  
  /**
   * Create an Avro Schema from the type of an IntermediateDataField
   */
  private Schema getSchema(final IntermediateDataField dataField) {
    Schema _switchResult = null;
    IntermediateTypeKind _kind = dataField.getType().getKind();
    if (_kind != null) {
      switch (_kind) {
        case PRIMITIVE:
          _switchResult = Shared.toPrimitiveAvroType(dataField.getOriginalType().getName());
          break;
        case ENUMERATION:
        case STRUCTURE:
        case COLLECTION:
          _switchResult = this.<IntermediateComplexType>resolveSchema(dataField.getType());
          break;
        default:
          StringConcatenation _builder = new StringConcatenation();
          String _name = dataField.getType().getName();
          _builder.append(_name);
          _builder.append(" with kind ");
          IntermediateTypeKind _kind_1 = dataField.getType().getKind();
          _builder.append(_kind_1);
          _builder.append(" and origin ");
          String _plus = ("Mapping of LEMMA type " + _builder);
          StringConcatenation _builder_1 = new StringConcatenation();
          IntermediateTypeOrigin _origin = dataField.getType().getOrigin();
          _builder_1.append(_origin);
          _builder_1.append(" is not supported");
          String _plus_1 = (_plus + _builder_1);
          throw new IllegalArgumentException(_plus_1);
      }
    } else {
      StringConcatenation _builder = new StringConcatenation();
      String _name = dataField.getType().getName();
      _builder.append(_name);
      _builder.append(" with kind ");
      IntermediateTypeKind _kind_1 = dataField.getType().getKind();
      _builder.append(_kind_1);
      _builder.append(" and origin ");
      String _plus = ("Mapping of LEMMA type " + _builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      IntermediateTypeOrigin _origin = dataField.getType().getOrigin();
      _builder_1.append(_origin);
      _builder_1.append(" is not supported");
      String _plus_1 = (_plus + _builder_1);
      throw new IllegalArgumentException(_plus_1);
    }
    return _switchResult;
  }
  
  /**
   * Helper to resolve a type reference inside an intermediate LEMMA model to the referenced
   * type's definition and return the corresponding Avro schema
   */
  private <RT extends IntermediateComplexType> Schema resolveSchema(final IntermediateType typeReference) {
    BiFunction<String, RT, Pair<Schema, List<Schema>>> _switchResult = null;
    IntermediateTypeKind _kind = typeReference.getKind();
    if (_kind != null) {
      switch (_kind) {
        case STRUCTURE:
          final BiFunction<String, RT, Pair<Schema, List<Schema>>> _function = (String modelUri, RT complexType) -> {
            return this.toRecord(((IntermediateDataStructure) complexType), modelUri);
          };
          _switchResult = _function;
          break;
        case ENUMERATION:
          final BiFunction<String, RT, Pair<Schema, List<Schema>>> _function_1 = (String modelUri, RT complexType) -> {
            return this.toEnum(((IntermediateEnumeration) complexType), modelUri);
          };
          _switchResult = _function_1;
          break;
        case COLLECTION:
          final BiFunction<String, RT, Pair<Schema, List<Schema>>> _function_2 = (String modelUri, RT complexType) -> {
            return this.toArray(((IntermediateCollectionType) complexType), modelUri);
          };
          _switchResult = _function_2;
          break;
        default:
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("complex type ");
          String _name = typeReference.getName();
          _builder.append(_name);
          _builder.append(" with kind ");
          IntermediateTypeKind _kind_1 = typeReference.getKind();
          _builder.append(_kind_1);
          _builder.append(" and ");
          String _plus = ("Schema resolution of intermediate " + _builder);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("origin ");
          IntermediateTypeOrigin _origin = typeReference.getOrigin();
          _builder_1.append(_origin);
          _builder_1.append(" is not supported");
          String _plus_1 = (_plus + _builder_1);
          throw new IllegalArgumentException(_plus_1);
      }
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("complex type ");
      String _name = typeReference.getName();
      _builder.append(_name);
      _builder.append(" with kind ");
      IntermediateTypeKind _kind_1 = typeReference.getKind();
      _builder.append(_kind_1);
      _builder.append(" and ");
      String _plus = ("Schema resolution of intermediate " + _builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("origin ");
      IntermediateTypeOrigin _origin = typeReference.getOrigin();
      _builder_1.append(_origin);
      _builder_1.append(" is not supported");
      String _plus_1 = (_plus + _builder_1);
      throw new IllegalArgumentException(_plus_1);
    }
    final BiFunction<String, RT, Pair<Schema, List<Schema>>> conversionFunction = _switchResult;
    final Pair<String, IntermediateComplexType> modelUriAndResolvedType = this.<IntermediateComplexType>resolve(((RT) typeReference));
    final String modelUri = modelUriAndResolvedType.getKey();
    IntermediateComplexType _value = modelUriAndResolvedType.getValue();
    final RT resolvedType = ((RT) _value);
    Schema _elvis = null;
    Schema _schemaFrom = this.getSchemaFrom(modelUri, resolvedType);
    if (_schemaFrom != null) {
      _elvis = _schemaFrom;
    } else {
      Schema _key = conversionFunction.apply(modelUri, resolvedType).getKey();
      _elvis = _key;
    }
    return _elvis;
  }
  
  /**
   * Helper to resolve a type reference inside an intermediate LEMMA model to the referenced
   * type's definition. The helper returns a pair consisting of the URI of the model, which
   * specifies the type, and the type definition itself. In case the referenced type is not
   * imported from another model, the model URI is null.
   */
  private <RT extends IntermediateComplexType> Pair<String, RT> resolve(final IntermediateComplexType typeReference) {
    Pair<String, IntermediateComplexType> _switchResult = null;
    boolean _matched = false;
    if (typeReference instanceof IntermediateImportedComplexType) {
      _matched=true;
      _switchResult = this.resolve(((IntermediateImportedComplexType)typeReference));
    }
    if (!_matched) {
      if (typeReference instanceof IntermediateComplexType) {
        _matched=true;
        Pair<String, IntermediateComplexType> _xblockexpression = null;
        {
          final IntermediateDataModel localModel = EcoreUtil2.<IntermediateDataModel>getContainerOfType(typeReference, IntermediateDataModel.class);
          IntermediateComplexType _findComplexTypeDefinition = this.findComplexTypeDefinition(localModel, null, typeReference);
          _xblockexpression = Pair.<String, IntermediateComplexType>of(null, _findComplexTypeDefinition);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type ");
      String _name = typeReference.getName();
      _builder.append(_name);
      _builder.append(" with kind ");
      IntermediateTypeKind _kind = typeReference.getKind();
      _builder.append(_kind);
      _builder.append(" and origin ");
      String _plus = ("Could not resolve intermediate complex " + _builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      IntermediateTypeOrigin _origin = typeReference.getOrigin();
      _builder_1.append(_origin);
      String _plus_1 = (_plus + _builder_1);
      throw new IllegalArgumentException(_plus_1);
    }
    final Pair<String, IntermediateComplexType> modelUriAndResolvedType = _switchResult;
    String _key = modelUriAndResolvedType.getKey();
    IntermediateComplexType _value = modelUriAndResolvedType.getValue();
    return Pair.<String, RT>of(_key, ((RT) _value));
  }
  
  /**
   * Cache for searched and found type definitions
   */
  private final HashMap<String, IntermediateComplexType> foundTypeDefinitionsCache = CollectionLiterals.<String, IntermediateComplexType>newHashMap();
  
  /**
   * Helper to find a complex type's definition from a given data model and reference to the type
   */
  private IntermediateComplexType findComplexTypeDefinition(final IntermediateDataModel dataModel, final String modelUri, final IntermediateComplexType typeReference) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((modelUri != null)) {
        _builder.append(modelUri);
        _builder.append("$");
      }
    }
    String _qualifiedName = typeReference.getQualifiedName();
    final String typeIdentifier = (_builder.toString() + _qualifiedName);
    IntermediateComplexType type = this.foundTypeDefinitionsCache.get(typeIdentifier);
    if ((type != null)) {
      return type;
    }
    final Function1<IntermediateComplexType, Boolean> _function = (IntermediateComplexType it) -> {
      return Boolean.valueOf(((it instanceof IntermediateComplexType) && 
        Objects.equal(Util.qualifiedName(it), typeReference.getQualifiedName())));
    };
    type = IterableExtensions.<IntermediateComplexType>findFirst(this.getComplexTypeDefinitions(dataModel, modelUri), _function);
    IntermediateComplexType _xifexpression = null;
    if ((type != null)) {
      IntermediateComplexType _xblockexpression = null;
      {
        final IntermediateComplexType complexType = ((IntermediateComplexType) type);
        this.foundTypeDefinitionsCache.put(typeIdentifier, complexType);
        _xblockexpression = complexType;
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  /**
   * Cache for all complex type definitions contained in traversed data models
   */
  private final HashMap<String, List<IntermediateComplexType>> complexTypeDefinitionsCache = CollectionLiterals.<String, List<IntermediateComplexType>>newHashMap();
  
  /**
   * Get all complex type definitions from a data model
   */
  private List<IntermediateComplexType> getComplexTypeDefinitions(final IntermediateDataModel dataModel, final String modelUri) {
    List<IntermediateComplexType> complexTypeDefinitions = this.complexTypeDefinitionsCache.get(modelUri);
    if ((complexTypeDefinitions != null)) {
      return complexTypeDefinitions;
    }
    complexTypeDefinitions = Util.getComplexTypes(dataModel);
    this.complexTypeDefinitionsCache.put(modelUri, complexTypeDefinitions);
    return complexTypeDefinitions;
  }
  
  /**
   * Helper to resolve a reference to an imported complex type. The helper returns a pair
   * consisting of the import URI of the model, which defines the complex type, and the complex
   * type definition itself.
   */
  private Pair<String, IntermediateComplexType> resolve(final IntermediateImportedComplexType importedType) {
    final String importUri = importedType.getImport().getImportUri();
    final IntermediateDataModel externalModel = this.loadExternalModel(importUri);
    IntermediateComplexType complexType = this.findComplexTypeDefinition(externalModel, importUri, importedType);
    if ((complexType == null)) {
      StringConcatenation _builder = new StringConcatenation();
      String _qualifiedName = importedType.getQualifiedName();
      _builder.append(_qualifiedName);
      _builder.append(" in intermediate data model ");
      _builder.append(importUri);
      String _plus = ("Could not resolve imported complex type " + _builder);
      throw new IllegalArgumentException(_plus);
    }
    return Pair.<String, IntermediateComplexType>of(importUri, complexType);
  }
  
  /**
   * Cache for loaded external models
   */
  private final HashMap<String, IntermediateDataModel> loadedExternalModelsCache = CollectionLiterals.<String, IntermediateDataModel>newHashMap();
  
  /**
   * Load a data model from the given absolute model URI
   */
  private IntermediateDataModel loadExternalModel(final String absoluteModelUri) {
    IntermediateDataModel externalModel = this.loadedExternalModelsCache.get(absoluteModelUri);
    if ((externalModel != null)) {
      return externalModel;
    }
    externalModel = Util.loadIntermediateDataModel(absoluteModelUri);
    if ((externalModel == null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("URI ");
      _builder.append(absoluteModelUri);
      String _plus = ("Could not load intermediate data model with " + _builder);
      throw new IllegalArgumentException(_plus);
    }
    this.loadedExternalModelsCache.put(absoluteModelUri, externalModel);
    return externalModel;
  }
  
  /**
   * Get an already created Avro schema specification for the given model URI and EObject. Returns
   * null if the EObject was not handled by the Avro generator thus far.
   */
  private Schema getSchemaFrom(final String modelUri, final EObject eObject) {
    String _switchResult = null;
    boolean _matched = false;
    if (eObject instanceof IntermediateComplexType) {
      _matched=true;
      _switchResult = ((IntermediateComplexType)eObject).getQualifiedName();
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      String _simpleName = eObject.getClass().getSimpleName();
      _builder.append(_simpleName);
      _builder.append(" is not supported");
      String _plus = ("Finding schema for EObject of type " + _builder);
      throw new IllegalArgumentException(_plus);
    }
    final String lemmaName = _switchResult;
    Map<String, Schema> _get = this.createdSchemas.get(modelUri);
    Schema _get_1 = null;
    if (_get!=null) {
      _get_1=_get.get(lemmaName);
    }
    Schema schema = _get_1;
    if ((schema == null)) {
      Map<String, Schema> _get_2 = this.schemasCreationStack.get(modelUri);
      Schema _get_3 = null;
      if (_get_2!=null) {
        _get_3=_get_2.get(lemmaName);
      }
      schema = _get_3;
    }
    return null;
  }
  
  /**
   * Generate schemas from IntermediateDataStructure, which represents an Avro Union type. Returns
   * a pair consisting of the schema for the IntermediateDataStructure and all schemas that were
   * created during generation.
   */
  public Pair<Schema, List<Schema>> toUnion(final IntermediateDataStructure structure) {
    final Schema union = this.toUnion(structure, null).getKey();
    List<Schema> _allCreatedSchemas = this.allCreatedSchemas();
    return Pair.<Schema, List<Schema>>of(union, _allCreatedSchemas);
  }
  
  /**
   * Internal helper to generate schemas from an IntermediateDataStructure, which represents an
   * Avro Union type. By contrast to the public toUnion(IntermediateDataStructure) method for
   * external callers, this internal helper is model-URI-aware.
   */
  private Pair<Schema, List<Schema>> toUnion(final IntermediateDataStructure structure, final String modelUri) {
    boolean _isUnionSchemaType = this.isUnionSchemaType(structure);
    boolean _not = (!_isUnionSchemaType);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Structure ");
      String _qualifiedName = structure.getQualifiedName();
      _builder.append(_qualifiedName);
      _builder.append(" cannot ");
      String _plus = (_builder.toString() + 
        "be converted to Avro Union");
      throw new IllegalArgumentException(_plus);
    }
    final Function1<IntermediateDataField, Schema> _function = (IntermediateDataField it) -> {
      return this.getSchema(it);
    };
    final List<Schema> unionSchemas = ListExtensions.<IntermediateDataField, Schema>map(Util.visibleFields(structure), _function);
    final Schema union = AvroSchemaFactory.createUnion(structure.getQualifiedName(), unionSchemas, true);
    this.finishedComplexTypeSchemaCreation(union, modelUri);
    List<Schema> _createdSchemasForModel = this.createdSchemasForModel(modelUri);
    return Pair.<Schema, List<Schema>>of(union, _createdSchemasForModel);
  }
  
  /**
   * Generate schemas from IntermediateDataStructure, which represents an Avro Record type.
   * Returns a pair consisting of the schema for the IntermediateDataStructure and all schemas
   * that were created during generation.
   */
  public Pair<Schema, List<Schema>> toRecord(final IntermediateDataStructure structure) {
    final Schema record = this.toRecord(structure, null).getKey();
    List<Schema> _allCreatedSchemas = this.allCreatedSchemas();
    return Pair.<Schema, List<Schema>>of(record, _allCreatedSchemas);
  }
  
  /**
   * Internal helper to generate schemas from an IntermediateDataStructure, which represents an
   * Avro Record type. By contrast to the public toUnion(IntermediateDataStructure) method for
   * external callers, this internal helper is model-URI-aware.
   */
  private Pair<Schema, List<Schema>> toRecord(final IntermediateDataStructure structure, final String modelUri) {
    final boolean isError = Util.hasAspect(structure, Shared.ERROR_ASPECT_FULLY_QUALIFIED);
    final Schema record = this.toRecord(Util.visibleFields(structure), modelUri, structure.getQualifiedName(), isError);
    List<Schema> _createdSchemasForModel = this.createdSchemasForModel(modelUri);
    return Pair.<Schema, List<Schema>>of(record, _createdSchemasForModel);
  }
  
  /**
   * Generate schemas from IntermediateEnumeration. The return value is a pair consisting of the
   * schema specifically derived from the passed enumeration and all other schemas that were
   * derived during schema generation in the context of the passed enumeration.
   */
  public Pair<Schema, List<Schema>> generateSchemasFrom(final IntermediateEnumeration enumeration) {
    final Schema enum_ = this.toEnum(enumeration, null).getKey();
    List<Schema> _allCreatedSchemas = this.allCreatedSchemas();
    return Pair.<Schema, List<Schema>>of(enum_, _allCreatedSchemas);
  }
  
  /**
   * Internal helper to generate schemas from an IntermediateEnumeration, which represents an Avro
   * Enum type. By contrast to the public generateSchemasFrom(IntermediateEnumeration) method for
   * external callers, this internal helper is model-URI-aware.
   */
  private Pair<Schema, List<Schema>> toEnum(final IntermediateEnumeration enumeration, final String modelUri) {
    final Function1<IntermediateEnumerationField, String> _function = (IntermediateEnumerationField it) -> {
      return it.getName();
    };
    final Schema avroEnum = AvroSchemaFactory.createEnum(enumeration.getQualifiedName(), "", 
      ListExtensions.<IntermediateEnumerationField, String>map(enumeration.getFields(), _function));
    this.finishedComplexTypeSchemaCreation(avroEnum, modelUri);
    List<Schema> _createdSchemasForModel = this.createdSchemasForModel(modelUri);
    return Pair.<Schema, List<Schema>>of(avroEnum, _createdSchemasForModel);
  }
  
  /**
   * Generate schemas from IntermediateCollectionType. The return value is a pair consisting of
   * the schema specifically derived from the passed collection type and all other schemas that
   * were derived during schema generation in the context of the passed collection type.
   */
  public Pair<Schema, List<Schema>> generateSchemasFrom(final IntermediateCollectionType collectionType) {
    final Schema array = this.toArray(collectionType, null).getKey();
    List<Schema> _allCreatedSchemas = this.allCreatedSchemas();
    return Pair.<Schema, List<Schema>>of(array, _allCreatedSchemas);
  }
  
  /**
   * Internal helper to generate schemas from an IntermediateCollectionType, which represents an
   * Avro Array type. By contrast to the public generateSchemasFrom(IntermediateCollectionType)
   * method for external callers, this internal helper is model-URI-aware.
   */
  private Pair<Schema, List<Schema>> toArray(final IntermediateCollectionType collectionType, final String modelUri) {
    Schema _xifexpression = null;
    boolean _isPrimitiveCollection = collectionType.isPrimitiveCollection();
    if (_isPrimitiveCollection) {
      _xifexpression = Shared.toPrimitiveAvroType(collectionType.getPrimitiveType().getName());
    } else {
      _xifexpression = this.toRecord(collectionType.getDataFields(), modelUri, collectionType.getQualifiedName());
    }
    final Schema elementType = _xifexpression;
    final Schema array = AvroSchemaFactory.createArray(collectionType.getQualifiedName(), elementType);
    this.finishedComplexTypeSchemaCreation(array, modelUri);
    List<Schema> _createdSchemasForModel = this.createdSchemasForModel(modelUri);
    return Pair.<Schema, List<Schema>>of(array, _createdSchemasForModel);
  }
  
  /**
   * Cluster all schemas derived for the given IntermediateDataModel in an Avro protocol with the
   * specified name and namespace
   */
  public Protocol toProtocol(final IntermediateDataModel dataModel, final String name, final String namespace) {
    return this.toProtocol(dataModel, name, "", namespace);
  }
  
  /**
   * Cluster all schemas derived for the given IntermediateDataModel in an Avro protocol with the
   * specified name, docstring, and namespace
   */
  public Protocol toProtocol(final IntermediateDataModel dataModel, final String name, final String doc, final String namespace) {
    List<List<Schema>> _xifexpression = null;
    boolean _isEmpty = dataModel.getVersions().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Function1<IntermediateVersion, List<Schema>> _function = (IntermediateVersion it) -> {
        return this.generateSchemasFrom(it);
      };
      _xifexpression = ListExtensions.<IntermediateVersion, List<Schema>>map(dataModel.getVersions(), _function);
    } else {
      List<List<Schema>> _xifexpression_1 = null;
      boolean _isEmpty_1 = dataModel.getContexts().isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      if (_not_1) {
        final Function1<IntermediateContext, List<Schema>> _function_1 = (IntermediateContext it) -> {
          return this.generateSchemasFrom(it);
        };
        _xifexpression_1 = ListExtensions.<IntermediateContext, List<Schema>>map(dataModel.getContexts(), _function_1);
      } else {
        final Function1<IntermediateComplexType, List<Schema>> _function_2 = (IntermediateComplexType it) -> {
          return this.generateSchemasFrom(it).getValue();
        };
        _xifexpression_1 = ListExtensions.<IntermediateComplexType, List<Schema>>map(dataModel.getComplexTypes(), _function_2);
      }
      _xifexpression = _xifexpression_1;
    }
    final List<List<Schema>> schemas = _xifexpression;
    return this.toProtocol(this.withoutDuplicates(IterableExtensions.<Schema>toList(Iterables.<Schema>concat(schemas))), name, doc, namespace);
  }
  
  /**
   * Cluster all schemas derived for the given IntermediateVersion in an Avro protocol with the
   * specified name and namespace
   */
  public Protocol toProtocol(final IntermediateVersion version, final String name, final String namespace) {
    return this.toProtocol(version, name, "", namespace);
  }
  
  /**
   * Cluster all schemas derived for the given IntermediateVersion in an Avro protocol with the
   * specified name, docstring, and namespace
   */
  public Protocol toProtocol(final IntermediateVersion version, final String name, final String doc, final String namespace) {
    final Function1<IntermediateContext, List<Schema>> _function = (IntermediateContext it) -> {
      return this.generateSchemasFrom(it);
    };
    final List<Schema> schemas = this.withoutDuplicates(IterableExtensions.<Schema>toList(Iterables.<Schema>concat(ListExtensions.<IntermediateContext, List<Schema>>map(version.getContexts(), _function))));
    return this.toProtocol(schemas, name, doc, namespace);
  }
  
  /**
   * Cluster all schemas derived for the given IntermediateContext in an Avro protocol with the
   * specified name and namespace
   */
  public Protocol toProtocol(final IntermediateContext context, final String name, final String namespace) {
    return this.toProtocol(context, name, "", namespace);
  }
  
  /**
   * Cluster all schemas derived for the given IntermediateContext in an Avro protocol with the
   * specified name, docstring, and namespace
   */
  public Protocol toProtocol(final IntermediateContext context, final String name, final String doc, final String namespace) {
    return this.toProtocol(this.generateSchemasFrom(context), name, doc, namespace);
  }
  
  /**
   * Cluster the given Avro schemas in an Avro protocol with the given name and namespace
   */
  public Protocol toProtocol(final List<Schema> types, final String name, final String namespace) {
    return this.toProtocol(types, name, "", namespace);
  }
  
  /**
   * Cluster the given Avro schemas in an Avro protocol with the given name, docstring, and
   * namespace
   */
  public Protocol toProtocol(final List<Schema> types, final String name, final String doc, final String namespace) {
    final Protocol protocol = new Protocol(name, doc, namespace);
    final Function1<Schema, Boolean> _function = (Schema it) -> {
      return Boolean.valueOf(Shared.isNamedSchema(it));
    };
    protocol.setTypes(IterableExtensions.<Schema>toList(IterableExtensions.<Schema>filter(types, _function)));
    return protocol;
  }
}
