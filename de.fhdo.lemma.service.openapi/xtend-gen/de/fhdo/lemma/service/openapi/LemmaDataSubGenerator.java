package de.fhdo.lemma.service.openapi;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.CollectionType;
import de.fhdo.lemma.data.Context;
import de.fhdo.lemma.data.DataFactory;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.data.DataStructure;
import de.fhdo.lemma.data.Version;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.Schema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is responsible for handling the generation of a LEMMA data model from an OpenAPI file
 * in the JSON or YAML format.
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public class LemmaDataSubGenerator {
  /**
   * SLF4j LOGGER
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(LemmaDataSubGenerator.class);
  
  /**
   * Separator is used to build the full qualified names during the generation
   */
  private static final String SEP = ".";
  
  /**
   * Map of all created DataStructures during a generation. The key contains the fully-qualified
   * name while the value contains the actual data structure created.
   */
  private final HashMap<String, DataStructure> createdDataStructures = CollectionLiterals.<String, DataStructure>newHashMap();
  
  /**
   * Map of all collection types created during a generation. The key contains the fully-qualified
   * name while the value contains the actual structured collection type created.
   */
  private final HashMap<String, CollectionType> createdStructuredCollectionTypes = CollectionLiterals.<String, CollectionType>newHashMap();
  
  /**
   * Factory to actually create and manipulate a LEMMA DataModel
   */
  private final DataFactory dataFactory = DataFactory.eINSTANCE;
  
  /**
   * Predefined instances of the data model, version, and context which are enriched with the data
   * structures from the OpenAPI source
   */
  private final DataModel targetDataModel = this.dataFactory.createDataModel();
  
  private final Version targetVersion = this.dataFactory.createVersion();
  
  private final Context targetContext = this.dataFactory.createContext();
  
  /**
   * OpenAPI schema which will be used as source for generation
   */
  private final OpenAPI openAPI;
  
  /**
   * Log of all encountered exceptions during the data transformation
   */
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final ArrayList<String> transMsgs = CollectionLiterals.<String>newArrayList();
  
  /**
   * Location where the generated file is written
   */
  private final String targetFile;
  
  /**
   * Constructor
   */
  public LemmaDataSubGenerator(final OpenAPI openAPI, final String targetFile) {
    this.openAPI = openAPI;
    this.targetFile = targetFile;
  }
  
  /**
   * Generate LEMMA data model from a previously parsed OpenAPI specification file. This method
   * returns the created model instance and also serializes it to the user's harddrive.
   */
  public DataModel generate() {
    try {
      LemmaDataSubGenerator.LOGGER.debug("Initializing model instance...");
      this.initialize();
      LemmaDataSubGenerator.LOGGER.debug("... data model initialized");
      LemmaDataSubGenerator.LOGGER.debug("Creating data structures...");
      Components _components = null;
      if (this.openAPI!=null) {
        _components=this.openAPI.getComponents();
      }
      Map<String, Schema> _schemas = null;
      if (_components!=null) {
        _schemas=_components.getSchemas();
      }
      if (_schemas!=null) {
        final BiConsumer<String, Schema> _function = (String key, Schema value) -> {
          try {
            this.getOrCreateDataStructure(this.targetContext, key, value);
          } catch (final Throwable _t) {
            if (_t instanceof Exception) {
              final Exception ex = (Exception)_t;
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("Error for DataStructure ");
              _builder.append(key);
              _builder.append(". Structure will be skipped. ");
              String _plus = (_builder.toString() + 
                "Please refer to the debug log for details.");
              this.transMsgs.add(_plus);
              LemmaDataSubGenerator.LOGGER.debug(ex.getMessage());
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        };
        _schemas.forEach(_function);
      }
      LemmaDataSubGenerator.LOGGER.debug("...data structures created");
      boolean _writeModel = OpenApiUtil.writeModel(this.targetDataModel, this.targetFile);
      if (_writeModel) {
        LemmaDataSubGenerator.LOGGER.debug("Data model generation successful");
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Model written to ");
        _builder.append(this.targetFile);
        LemmaDataSubGenerator.LOGGER.debug(_builder.toString());
      } else {
        throw new Exception("Generated data model could not be written to hard disk");
      }
      return this.targetDataModel;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Initialize the data model instance
   */
  private void initialize() {
    this.targetDataModel.getVersions().add(this.targetVersion);
    this.targetVersion.setName(OpenApiUtil.removeInvalidCharsFromName(this.openAPI.getInfo().getVersion()));
    this.targetVersion.getContexts().add(this.targetContext);
    this.targetContext.setName(OpenApiUtil.removeInvalidCharsFromName(this.openAPI.getInfo().getTitle()));
    this.targetContext.setVersion(this.targetVersion);
  }
  
  /**
   * Return a LEMMA data structure with the given name from an OpenAPI component object. In case a
   * data structure with the given name was already created, because OpenAPI allows the multiple
   * definition of a component object, it is returned. Otherwise, a new structure is created,
   * cached, and returned.
   */
  private DataStructure getOrCreateDataStructure(final Context context, final String name, final Schema<?> schema) {
    final String structureName = StringExtensions.toFirstUpper(name);
    StringConcatenation _builder = new StringConcatenation();
    String _buildQualifiedName = context.buildQualifiedName(LemmaDataSubGenerator.SEP);
    _builder.append(_buildQualifiedName);
    _builder.append(LemmaDataSubGenerator.SEP);
    final String fullyQualifiedStructureName = (_builder.toString() + structureName);
    final DataStructure existingStructure = this.createdDataStructures.get(fullyQualifiedStructureName);
    if ((existingStructure != null)) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Found and reuse existing data structure ");
      String _name = existingStructure.getName();
      _builder_1.append(_name);
      LemmaDataSubGenerator.LOGGER.debug(_builder_1.toString());
      return existingStructure;
    }
    final DataStructure newStructure = this.dataFactory.createDataStructure();
    newStructure.setName(structureName);
    context.getComplexTypes().add(newStructure);
    this.addDataFieldsFromSchema(newStructure, schema);
    this.createdDataStructures.put(fullyQualifiedStructureName, newStructure);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("Created new data structure ");
    String _name_1 = newStructure.getName();
    _builder_2.append(_name_1);
    LemmaDataSubGenerator.LOGGER.debug(_builder_2.toString());
    return newStructure;
  }
  
  /**
   * Add fields to a given LEMMA data structure from information of a given OpenAPI schema
   */
  private void addDataFieldsFromSchema(final DataStructure structure, final Schema<?> structureSchema) {
    this.addDataFieldsFromSchema(structure, null, structureSchema);
  }
  
  /**
   * Add field of the given name to the given LEMMA data structure based on the given OpenAPI
   * schema. This method recursively creates fields for inline-defined OpenAPI structures
   * identified by schemas that have properties. In case a schema has no properties, a single data
   * field is added to the LEMMA data structure, which requires the given field name to be
   * non-null. In case a schema has no properties and no field name was given, the method yields
   * an IllegalArgumentException.
   */
  private void addDataFieldsFromSchema(final DataStructure structure, final String fieldName, final Schema<?> structureSchema) {
    Map<String, Schema> _properties = structureSchema.getProperties();
    boolean _tripleNotEquals = (_properties != null);
    if (_tripleNotEquals) {
      final BiConsumer<String, Schema> _function = (String name, Schema schema) -> {
        this.addDataFieldsFromSchema(structure, name, schema);
      };
      structureSchema.getProperties().forEach(_function);
    } else {
      if ((fieldName != null)) {
        structure.getDataFields().add(this.generateDataField(fieldName, structureSchema));
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("structure ");
        String _buildQualifiedName = structure.buildQualifiedName(".");
        _builder.append(_buildQualifiedName);
        _builder.append(" because the schema has no ");
        String _plus = ("Can\'t add data field(s) from OpenAPI schema to " + _builder);
        String _plus_1 = (_plus + 
          "properties and no field name was given");
        throw new IllegalArgumentException(_plus_1);
      }
    }
  }
  
  /**
   * Generate a LEMMA data field with the given name from the type of an OpenAPI schema. Primitive
   * schema types such as "boolean" or "integer" are mapped to the corresponding LEMMA primitive
   * types. OpenAPI arrays and references are mapped to LEMMA collection types and data
   * structures, respectively.
   */
  private DataField generateDataField(final String name, final Schema<?> structureSchema) {
    final DataField newDataField = this.dataFactory.createDataField();
    newDataField.setName(name);
    String _type = structureSchema.getType();
    boolean _matched = false;
    if (Objects.equal(_type, "array")) {
      _matched=true;
      newDataField.setComplexType(this.getOrCreateStructuredCollectionType(this.targetContext, name, 
        ((ArraySchema) structureSchema).getItems()));
    }
    if (!_matched) {
      if (Objects.equal(_type, "boolean")) {
        _matched=true;
        newDataField.setPrimitiveType(this.dataFactory.createPrimitiveBoolean());
      }
    }
    if (!_matched) {
      if (Objects.equal(_type, "integer")) {
        _matched=true;
        newDataField.setPrimitiveType(OpenApiUtil.deriveIntType(structureSchema.getFormat()));
      }
    }
    if (!_matched) {
      if (Objects.equal(_type, "number")) {
        _matched=true;
        newDataField.setPrimitiveType(OpenApiUtil.deriveFloatType(structureSchema.getFormat()));
      }
    }
    if (!_matched) {
      if (Objects.equal(_type, "string")) {
        _matched=true;
        newDataField.setPrimitiveType(OpenApiUtil.deriveStringType(structureSchema.getFormat()));
      }
    }
    if (!_matched) {
      if (Objects.equal(_type, null)) {
        _matched=true;
        String _$ref = structureSchema.get$ref();
        boolean _tripleEquals = (_$ref == null);
        if (_tripleEquals) {
          this.throwUnsupportedSchemaType(structureSchema);
        }
        final String ref = structureSchema.get$ref();
        int _lastIndexOf = ref.lastIndexOf("/");
        int _plus = (_lastIndexOf + 1);
        final String refName = ref.substring(_plus);
        final Schema refSchema = this.openAPI.getComponents().getSchemas().get(refName);
        if (((refName != null) && (refSchema != null))) {
          newDataField.setComplexType(this.getOrCreateDataStructure(this.targetContext, refName, refSchema));
        } else {
          LemmaDataSubGenerator.LOGGER.info(("Encountered reference without a parseable name and/or schema. " + 
            "The generated LEMMA data model may be incomplete."));
        }
      }
    }
    if (!_matched) {
      this.throwUnsupportedSchemaType(structureSchema);
    }
    return newDataField;
  }
  
  /**
   * Throw an IllegalArgumentException in case an OpenAPI schema type cannot be transformed into a
   * corresponding LEMMA type
   */
  private void throwUnsupportedSchemaType(final Schema<?> schema) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Schema type ");
    String _type = schema.getType();
    _builder.append(_type);
    _builder.append(" is not supported.");
    throw new IllegalArgumentException(_builder.toString());
  }
  
  /**
   * Return a LEMMA collection type with the given name from an OpenAPI schema. In case a
   * collection type with the given name was already created, because OpenAPI allows the multiple
   * definition of schema types, it is returned. Otherwise, a new collection type is created,
   * cached, and returned.
   */
  private CollectionType getOrCreateStructuredCollectionType(final Context context, final String name, final Schema<?> schema) {
    final String typeName = LemmaDataSubGenerator.getCollectionTypeName(name);
    StringConcatenation _builder = new StringConcatenation();
    String _buildQualifiedName = context.buildQualifiedName(LemmaDataSubGenerator.SEP);
    _builder.append(_buildQualifiedName);
    _builder.append(LemmaDataSubGenerator.SEP);
    _builder.append(typeName);
    final String fullyQualifiedTypeName = _builder.toString();
    final CollectionType existingType = this.createdStructuredCollectionTypes.get(fullyQualifiedTypeName);
    if ((existingType != null)) {
      String _name = existingType.getName();
      String _plus = ("Found and reuse existing structured collection type " + _name);
      LemmaDataSubGenerator.LOGGER.debug(_plus);
      return existingType;
    }
    final CollectionType newType = this.dataFactory.createCollectionType();
    newType.setName(typeName);
    context.getComplexTypes().add(newType);
    newType.getDataFields().add(this.generateDataField(name, schema));
    this.createdStructuredCollectionTypes.put(fullyQualifiedTypeName, newType);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Created new structured collection type ");
    String _name_1 = newType.getName();
    _builder_1.append(_name_1);
    LemmaDataSubGenerator.LOGGER.debug(_builder_1.toString());
    return newType;
  }
  
  /**
   * Helper method to get the name of a LEMMA collection type from an OpenAPI array schema
   */
  public static String getCollectionTypeName(final ArraySchema schema) {
    return LemmaDataSubGenerator.getCollectionTypeName(schema.getType());
  }
  
  /**
   * Helper method to derive the name of a LEMMA collection type from a given base name
   */
  public static String getCollectionTypeName(final String name) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(name);
    _builder.append(_firstUpper);
    _builder.append("Collection");
    return _builder.toString();
  }
  
  @Pure
  public ArrayList<String> getTransMsgs() {
    return this.transMsgs;
  }
}
