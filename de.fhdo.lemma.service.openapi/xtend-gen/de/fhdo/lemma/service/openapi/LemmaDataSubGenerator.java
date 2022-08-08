package de.fhdo.lemma.service.openapi;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.Context;
import de.fhdo.lemma.data.DataFactory;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.data.DataStructure;
import de.fhdo.lemma.data.ListType;
import de.fhdo.lemma.data.Version;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.Schema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is responsible for handling the generation of a LEMMA data model from an
 * OpenAPI file in the JSON or YAML format.
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public class LemmaDataSubGenerator {
  /**
   * Map of all created DataStructures during a generation. The key contains the full-qualified
   * name while the value contains the actual data structure created.
   */
  private final HashMap<String, DataStructure> createdDataStructures = CollectionLiterals.<String, DataStructure>newHashMap();
  
  /**
   * Map of all created Lists during a generation. The key contains the full-qualified
   * name while the value contains the actual list structure created.
   */
  private final HashMap<String, ListType> createdListStructures = CollectionLiterals.<String, ListType>newHashMap();
  
  /**
   * Factory to actually create and manipulate a LEMMA DataModel
   */
  private final DataFactory DATA_FACTORY = DataFactory.eINSTANCE;
  
  /**
   * Predefined instances of the data model, version, and context
   * which are enriched with the data structures from the OpenAPI source
   */
  private final DataModel myDataModel = this.DATA_FACTORY.createDataModel();
  
  private final Version myVersion = this.DATA_FACTORY.createVersion();
  
  private final Context myContext = this.DATA_FACTORY.createContext();
  
  /**
   * Separator is used to build the full qualified names during the generation
   */
  private final String separator = ".";
  
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
   * SLF4j Logger
   */
  private static final Logger logger = LoggerFactory.getLogger(LemmaDataSubGenerator.class);
  
  /**
   * Location where the generated file is written
   */
  private final String targetFile;
  
  public LemmaDataSubGenerator(final OpenAPI openAPI, final String targetFile) {
    super();
    LemmaDataSubGenerator.logger.debug("Creating new Data Sub Generator...");
    this.openAPI = openAPI;
    this.targetFile = targetFile;
  }
  
  public DataModel generate() {
    try {
      LemmaDataSubGenerator.logger.debug("Starting generation...");
      LemmaDataSubGenerator.logger.debug("Initializing model instance...");
      this.initilize();
      LemmaDataSubGenerator.logger.debug("...data model initialized!");
      LemmaDataSubGenerator.logger.debug("Creating data structures...");
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
            this.getOrCreateDataStructure(this.myContext, key, value);
          } catch (final Throwable _t) {
            if (_t instanceof Exception) {
              final Exception e = (Exception)_t;
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("Error for DataStructure ");
              _builder.append(key);
              _builder.append(", structure is skipped.");
              _builder.newLineIfNotEmpty();
              _builder.append("                        ");
              _builder.append("For details access debug log.");
              this.transMsgs.add(_builder.toString());
              LemmaDataSubGenerator.logger.debug(e.getMessage());
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        };
        _schemas.forEach(_function);
      }
      LemmaDataSubGenerator.logger.debug("...data structures created!");
      boolean _writeModel = OpenApiUtil.writeModel(this.myDataModel, this.targetFile);
      if (_writeModel) {
        LemmaDataSubGenerator.logger.info("Data model generation successful!");
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Model written to ");
        _builder.append(this.targetFile);
        LemmaDataSubGenerator.logger.info(_builder.toString());
      } else {
        throw new Exception("Data model generation failed.");
      }
      return this.myDataModel;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void initilize() {
    this.myDataModel.getVersions().add(this.myVersion);
    this.myVersion.setName(OpenApiUtil.removeInvalidCharsFromName(this.openAPI.getInfo().getVersion()));
    this.myVersion.getContexts().add(this.myContext);
    this.myContext.setName(OpenApiUtil.removeInvalidCharsFromName(this.openAPI.getInfo().getTitle()));
    this.myContext.setVersion(this.myVersion);
  }
  
  public DataStructure getOrCreateDataStructure(final Context c, final String name, final Schema schema) {
    DataStructure foundObject = this.findDataStructure(c, StringUtils.capitalize(name));
    if ((foundObject == null)) {
      final DataStructure newDataStructure = this.DATA_FACTORY.createDataStructure();
      newDataStructure.setName(StringUtils.capitalize(name));
      c.getComplexTypes().add(newDataStructure);
      this.addDataFieldsToDataStructure(newDataStructure, name, schema);
      this.createdDataStructures.put(
        newDataStructure.buildQualifiedName(this.separator), newDataStructure);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Created new data structure ");
      String _name = newDataStructure.getName();
      _builder.append(_name);
      LemmaDataSubGenerator.logger.debug(_builder.toString());
      return newDataStructure;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Found and reuse existing data structure ");
      String _name_1 = foundObject.getName();
      _builder_1.append(_name_1);
      LemmaDataSubGenerator.logger.debug(_builder_1.toString());
      return foundObject;
    }
  }
  
  public ListType getOrCreateListStructure(final Context c, final String name, final Schema schema) {
    ListType foundObject = this.findListStructure(c, name);
    if ((foundObject == null)) {
      final ListType newListStructure = this.DATA_FACTORY.createListType();
      StringConcatenation _builder = new StringConcatenation();
      String _capitalize = StringUtils.capitalize(name);
      _builder.append(_capitalize);
      _builder.append("List");
      newListStructure.setName(_builder.toString());
      c.getComplexTypes().add(newListStructure);
      this.addDataFieldsToListStructure(newListStructure, name, schema);
      this.createdListStructures.put(
        newListStructure.buildQualifiedName(this.separator), newListStructure);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Created new list structure ");
      String _name = newListStructure.getName();
      _builder_1.append(_name);
      LemmaDataSubGenerator.logger.debug(_builder_1.toString());
      return newListStructure;
    } else {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("Found and reuse existing list structure ");
      String _name_1 = foundObject.getName();
      _builder_2.append(_name_1);
      LemmaDataSubGenerator.logger.debug(_builder_2.toString());
      return foundObject;
    }
  }
  
  public void addDataFieldsToDataStructure(final DataStructure ds, final String structureName, final Schema structureSchema) {
    Map _properties = structureSchema.getProperties();
    boolean _tripleNotEquals = (_properties != null);
    if (_tripleNotEquals) {
      final BiConsumer<String, Schema> _function = (String name, Schema schema) -> {
        this.addDataFieldsToDataStructure(ds, name, schema);
      };
      structureSchema.getProperties().forEach(_function);
    } else {
      final DataField newDataField = this.generateDataField(structureName, structureSchema);
      ds.getDataFields().add(newDataField);
    }
  }
  
  public boolean addDataFieldsToListStructure(final ListType ds, final String structureName, final Schema structureSchema) {
    boolean _xblockexpression = false;
    {
      final DataField newDataField = this.generateDataField(structureName, structureSchema);
      _xblockexpression = ds.getDataFields().add(newDataField);
    }
    return _xblockexpression;
  }
  
  public DataField generateDataField(final String structureName, final Schema structureSchema) {
    final DataField newDataField = this.DATA_FACTORY.createDataField();
    newDataField.setName(StringUtils.lowerCase(structureName));
    String _type = structureSchema.getType();
    boolean _matched = false;
    if (Objects.equal(_type, "integer")) {
      _matched=true;
      newDataField.setPrimitiveType(OpenApiUtil.deriveIntType(structureSchema.getFormat()));
    }
    if (!_matched) {
      if (Objects.equal(_type, "number")) {
        _matched=true;
        newDataField.setPrimitiveType(OpenApiUtil.deriveNumberType(structureSchema.getFormat()));
      }
    }
    if (!_matched) {
      if (Objects.equal(_type, "string")) {
        _matched=true;
        newDataField.setPrimitiveType(OpenApiUtil.deriveStringType(structureSchema.getFormat()));
      }
    }
    if (!_matched) {
      if (Objects.equal(_type, "boolean")) {
        _matched=true;
        newDataField.setPrimitiveType(this.DATA_FACTORY.createPrimitiveBoolean());
      }
    }
    if (!_matched) {
      if (Objects.equal(_type, "array")) {
        _matched=true;
        final ArraySchema itemSchema = ((ArraySchema) structureSchema);
        final ListType listStructure = this.getOrCreateListStructure(
          this.myContext, structureName, itemSchema.getItems());
        newDataField.setComplexType(listStructure);
      }
    }
    if (!_matched) {
      if (Objects.equal(_type, null)) {
        _matched=true;
        String _$ref = structureSchema.get$ref();
        boolean _tripleNotEquals = (_$ref != null);
        if (_tripleNotEquals) {
          final String s = structureSchema.get$ref();
          int _lastIndexOf = s.lastIndexOf("/");
          int _plus = (_lastIndexOf + 1);
          final String key = s.substring(_plus);
          final Schema value = this.openAPI.getComponents().getSchemas().get(key);
          if (((key != null) && (value != null))) {
            newDataField.setComplexType(this.getOrCreateDataStructure(
              this.myContext, key, value));
          }
        }
      }
    }
    if (!_matched) {
      String _type_1 = structureSchema.getType();
      String _plus_1 = ("schema type " + _type_1);
      String _plus_2 = (_plus_1 + " not supported");
      throw new IllegalArgumentException(_plus_2);
    }
    return newDataField;
  }
  
  public DataStructure findDataStructure(final Context context, final String name) {
    StringConcatenation _builder = new StringConcatenation();
    String _buildQualifiedName = context.buildQualifiedName(this.separator);
    _builder.append(_buildQualifiedName);
    _builder.append(".");
    _builder.append(name);
    final String searchName = _builder.toString();
    return this.createdDataStructures.get(searchName);
  }
  
  public ListType findListStructure(final Context context, final String name) {
    StringConcatenation _builder = new StringConcatenation();
    String _buildQualifiedName = context.buildQualifiedName(this.separator);
    _builder.append(_buildQualifiedName);
    _builder.append(".");
    _builder.append(name);
    final String searchName = _builder.toString();
    return this.createdListStructures.get(searchName);
  }
  
  @Pure
  public ArrayList<String> getTransMsgs() {
    return this.transMsgs;
  }
}
