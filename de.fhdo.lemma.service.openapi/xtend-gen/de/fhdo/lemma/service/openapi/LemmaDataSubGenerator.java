package de.fhdo.lemma.service.openapi;

import de.fhdo.lemma.data.CollectionType;
import de.fhdo.lemma.data.Context;
import de.fhdo.lemma.data.DataFactory;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.data.DataStructure;
import de.fhdo.lemma.data.Version;
import java.util.ArrayList;
import java.util.HashMap;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

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
  private static final Object LOGGER /* Skipped initializer because of errors */;

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
  private final /* OpenAPI */Object openAPI;

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
  public LemmaDataSubGenerator(final /* OpenAPI */Object openAPI, final String targetFile) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LemmaDataSubGenerator.openAPI refers to the missing type OpenAPI");
  }

  /**
   * Generate LEMMA data model from a previously parsed OpenAPI specification file. This method
   * returns the created model instance and also serializes it to the user's harddrive.
   */
  public DataModel generate() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LemmaDataSubGenerator.LOGGER refers to the missing type Object"
      + "\nThe field LemmaDataSubGenerator.LOGGER refers to the missing type Object"
      + "\nThe field LemmaDataSubGenerator.LOGGER refers to the missing type Object"
      + "\nThe field LemmaDataSubGenerator.openAPI refers to the missing type OpenAPI"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nThe method getOrCreateDataStructure(Context, String, Schema) from the type LemmaDataSubGenerator refers to the missing type Schema"
      + "\nThe field LemmaDataSubGenerator.LOGGER refers to the missing type Object"
      + "\nThe field LemmaDataSubGenerator.LOGGER refers to the missing type Object"
      + "\nThe field LemmaDataSubGenerator.LOGGER refers to the missing type Object"
      + "\nThe field LemmaDataSubGenerator.LOGGER refers to the missing type Object"
      + "\ndebug cannot be resolved"
      + "\ndebug cannot be resolved"
      + "\ndebug cannot be resolved"
      + "\ncomponents cannot be resolved"
      + "\nschemas cannot be resolved"
      + "\nforEach cannot be resolved"
      + "\ndebug cannot be resolved"
      + "\ndebug cannot be resolved"
      + "\ndebug cannot be resolved"
      + "\ndebug cannot be resolved");
  }

  /**
   * Initialize the data model instance
   */
  private void initialize() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LemmaDataSubGenerator.openAPI refers to the missing type OpenAPI"
      + "\nThe field LemmaDataSubGenerator.openAPI refers to the missing type OpenAPI"
      + "\ninfo cannot be resolved"
      + "\nversion cannot be resolved"
      + "\ninfo cannot be resolved"
      + "\ntitle cannot be resolved");
  }

  /**
   * Return a LEMMA data structure with the given name from an OpenAPI component object. In case a
   * data structure with the given name was already created, because OpenAPI allows the multiple
   * definition of a component object, it is returned. Otherwise, a new structure is created,
   * cached, and returned.
   */
  private DataStructure getOrCreateDataStructure(final Context context, final String name, final /* Schema<?> */Object schema) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LemmaDataSubGenerator.LOGGER refers to the missing type Object"
      + "\nThe method addDataFieldsFromSchema(DataStructure, Schema) from the type LemmaDataSubGenerator refers to the missing type Schema"
      + "\nThe field LemmaDataSubGenerator.LOGGER refers to the missing type Object"
      + "\ndebug cannot be resolved"
      + "\ndebug cannot be resolved");
  }

  /**
   * Add fields to a given LEMMA data structure from information of a given OpenAPI schema
   */
  private void addDataFieldsFromSchema(final DataStructure structure, final /* Schema<?> */Object structureSchema) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method addDataFieldsFromSchema(DataStructure, String, Schema) from the type LemmaDataSubGenerator refers to the missing type Schema");
  }

  /**
   * Add field of the given name to the given LEMMA data structure based on the given OpenAPI
   * schema. This method recursively creates fields for inline-defined OpenAPI structures
   * identified by schemas that have properties. In case a schema has no properties, a single data
   * field is added to the LEMMA data structure, which requires the given field name to be
   * non-null. In case a schema has no properties and no field name was given, the method yields
   * an IllegalArgumentException.
   */
  private void addDataFieldsFromSchema(final DataStructure structure, final String fieldName, final /* Schema<?> */Object structureSchema) {
    throw new Error("Unresolved compilation problems:"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nThe method addDataFieldsFromSchema(DataStructure, String, Schema) from the type LemmaDataSubGenerator refers to the missing type Schema"
      + "\nThe method generateDataField(String, Schema) from the type LemmaDataSubGenerator refers to the missing type Schema"
      + "\nproperties cannot be resolved"
      + "\n!== cannot be resolved"
      + "\nproperties cannot be resolved"
      + "\nforEach cannot be resolved");
  }

  /**
   * Generate a LEMMA data field with the given name from the type of an OpenAPI schema. Primitive
   * schema types such as "boolean" or "integer" are mapped to the corresponding LEMMA primitive
   * types. OpenAPI arrays and references are mapped to LEMMA collection types and data
   * structures, respectively.
   */
  private DataField generateDataField(final String name, final /* Schema<?> */Object structureSchema) {
    throw new Error("Unresolved compilation problems:"
      + "\nArraySchema cannot be resolved to a type."
      + "\nThe method getOrCreateStructuredCollectionType(Context, String, Schema) from the type LemmaDataSubGenerator refers to the missing type Schema"
      + "\nThe method throwUnsupportedSchemaType(Schema) from the type LemmaDataSubGenerator refers to the missing type Schema"
      + "\nThe field LemmaDataSubGenerator.openAPI refers to the missing type OpenAPI"
      + "\nThe method getOrCreateDataStructure(Context, String, Schema) from the type LemmaDataSubGenerator refers to the missing type Schema"
      + "\nThe field LemmaDataSubGenerator.LOGGER refers to the missing type Object"
      + "\nThe method throwUnsupportedSchemaType(Schema) from the type LemmaDataSubGenerator refers to the missing type Schema"
      + "\ntype cannot be resolved"
      + "\nitems cannot be resolved"
      + "\nformat cannot be resolved"
      + "\nformat cannot be resolved"
      + "\nformat cannot be resolved"
      + "\nget$ref cannot be resolved"
      + "\n=== cannot be resolved"
      + "\nget$ref cannot be resolved"
      + "\nsubstring cannot be resolved"
      + "\nlastIndexOf cannot be resolved"
      + "\n+ cannot be resolved"
      + "\ncomponents cannot be resolved"
      + "\nschemas cannot be resolved"
      + "\nget cannot be resolved"
      + "\n!== cannot be resolved"
      + "\n&& cannot be resolved"
      + "\n!== cannot be resolved"
      + "\ninfo cannot be resolved");
  }

  /**
   * Throw an IllegalArgumentException in case an OpenAPI schema type cannot be transformed into a
   * corresponding LEMMA type
   */
  private void throwUnsupportedSchemaType(final /* Schema<?> */Object schema) {
    throw new Error("Unresolved compilation problems:"
      + "\ntype cannot be resolved");
  }

  /**
   * Return a LEMMA collection type with the given name from an OpenAPI schema. In case a
   * collection type with the given name was already created, because OpenAPI allows the multiple
   * definition of schema types, it is returned. Otherwise, a new collection type is created,
   * cached, and returned.
   */
  private CollectionType getOrCreateStructuredCollectionType(final Context context, final String name, final /* Schema<?> */Object schema) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LemmaDataSubGenerator.LOGGER refers to the missing type Object"
      + "\nThe method generateDataField(String, Schema) from the type LemmaDataSubGenerator refers to the missing type Schema"
      + "\nThe field LemmaDataSubGenerator.LOGGER refers to the missing type Object"
      + "\ndebug cannot be resolved"
      + "\ndebug cannot be resolved");
  }

  /**
   * Helper method to get the name of a LEMMA collection type from an OpenAPI array schema
   */
  public static Object getCollectionTypeName(final /* ArraySchema */Object schema) {
    throw new Error("Unresolved compilation problems:"
      + "\ntype cannot be resolved"
      + "\ncollectionTypeName cannot be resolved");
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
