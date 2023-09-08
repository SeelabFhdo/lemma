package de.fhdo.lemma.service.openapi;

import de.fhdo.lemma.data.DataFactory;
import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.technology.AspectFeature;
import de.fhdo.lemma.technology.JoinPointType;
import de.fhdo.lemma.technology.ServiceAspect;
import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.technology.TechnologyFactory;
import de.fhdo.lemma.technology.TechnologySpecificPrimitiveType;
import java.util.ArrayList;
import java.util.HashSet;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.slf4j.Logger;

/**
 * This class is responsible for handling the generation of a LEMMA technology model for the OpenAPI
 * technology from an OpenAPI specification file in the JSON or YAML format.
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public class LemmaTechnologySubGenerator {
  public static final String HTTP_DELETE_ASPECT_NAME = "DeleteMapping";

  public static final String HTTP_GET_ASPECT_NAME = "GetMapping";

  public static final String HTTP_HEAD_ASPECT_NAME = "HeadMapping";

  public static final String HTTP_OPTIONS_ASPECT_NAME = "OptionsMapping";

  public static final String HTTP_PATCH_ASPECT_NAME = "PatchMapping";

  public static final String HTTP_POST_ASPECT_NAME = "PostMapping";

  public static final String HTTP_PUT_ASPECT_NAME = "PutMapping";

  public static final String HTTP_REQUEST_BODY_ASPECT_NAME = "RequestBody";

  public static final String HTTP_TRACE_ASPECT_NAME = "TraceMapping";

  public static final String UNSPECIFIED_ASPECT_NAME = "Unspecified";

  public static final String TECHNOLOGY_MODEL_NAME = "OpenApi";

  private static final String DEFAULT_DATA_FORMAT = "application/json";

  /**
   * SLF4j LOGGER
   */
  private static final Logger LOGGER /* Skipped initializer because of errors */;

  /**
   * Factory to actually create and manipulate a LEMMA Technology
   */
  private final TechnologyFactory TECHNOLOGY_FACTORY = TechnologyFactory.eINSTANCE;

  /**
   * Factory to actually create and manipulate a LEMMA DataModel
   */
  private final DataFactory dataFactory = DataFactory.eINSTANCE;

  /**
   * Predefined instance of the TechnologyModel. This instance is populated with technology
   * information relevant to OpenAPI, e.g., media types.
   */
  private final Technology technology = this.TECHNOLOGY_FACTORY.createTechnology();

  /**
   * OpenAPI schema which will be used as source for generation
   */
  private /* OpenAPI */Object openApi;

  /**
   * Log of all encountered exceptions during the data transformation
   */
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final ArrayList<String> transMsgs = CollectionLiterals.<String>newArrayList();

  /**
   * Location where the generated file is written
   */
  private String targetFile;

  /**
   * Constructor
   */
  public LemmaTechnologySubGenerator(final /* OpenAPI */Object api, final String targetFile) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LemmaTechnologySubGenerator.openApi refers to the missing type /* OpenAPI schema which will be used as source for generation */\n    OpenAPI");
  }

  /**
   * Generate the LEMMA technology model for OpenAPI. This method returns the created model
   * instance and also serializes it to the user's harddrive.
   */
  public Technology generate() {
    try {
      LemmaTechnologySubGenerator.LOGGER.debug("Initializing model instance...");
      this.initialize();
      LemmaTechnologySubGenerator.LOGGER.debug("... technology model initialized");
      LemmaTechnologySubGenerator.LOGGER.debug("Creating protocols...");
      this.addRestProtocol(this.technology);
      LemmaTechnologySubGenerator.LOGGER.debug("... protocols created");
      boolean _writeModel = OpenApiUtil.writeModel(this.technology, this.targetFile);
      if (_writeModel) {
        LemmaTechnologySubGenerator.LOGGER.info("Technology model generation successful");
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Model written to ");
        _builder.append(this.targetFile);
        LemmaTechnologySubGenerator.LOGGER.info(_builder.toString());
      } else {
        throw new Exception("Generated technology model could not be written to hard disk");
      }
      return this.technology;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Initialize the technology model instance
   */
  private void initialize() {
    this.technology.setName(OpenApiUtil.removeInvalidCharsFromName(LemmaTechnologySubGenerator.TECHNOLOGY_MODEL_NAME));
    this.addPrimitiveTypes(this.technology);
    this.addAspects(this.technology);
  }

  /**
   * Add "rest" protocol to the technology model and derive the protocol's data formats from the
   * media types of the given OpenAPI specification. The default format will be JSON if the
   * specification comprises it, otherwise the format derived from the first defined media type
   * will be set as default.
   */
  private boolean addRestProtocol(final Technology technology) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LemmaTechnologySubGenerator.openApi refers to the missing type /* OpenAPI schema which will be used as source for generation */\n    OpenAPI"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nThe method searchMediaTypes(PathItem) from the type LemmaTechnologySubGenerator refers to the missing type PathItem"
      + "\npaths cannot be resolved"
      + "\nforEach cannot be resolved");
  }

  /**
   * Search media types in the requests and responses of the OpenAPI specification
   */
  private HashSet<String> searchMediaTypes(final /* PathItem */Object item) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field requestBody is undefined for the type Object"
      + "\nThe method or field requestBody is undefined for the type Object"
      + "\nThe method or field responses is undefined for the type Object"
      + "\nThe method or field content is undefined for the type Object"
      + "\nThe method or field content is undefined for the type Object"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\ndelete cannot be resolved"
      + "\nget cannot be resolved"
      + "\nhead cannot be resolved"
      + "\noptions cannot be resolved"
      + "\npatch cannot be resolved"
      + "\npost cannot be resolved"
      + "\nput cannot be resolved"
      + "\ncontent cannot be resolved"
      + "\n!== cannot be resolved"
      + "\ncontent cannot be resolved"
      + "\nkeySet cannot be resolved"
      + "\nforEach cannot be resolved"
      + "\n!== cannot be resolved"
      + "\nkeySet cannot be resolved");
  }

  /**
   * Add primitive types to the given LEMMA technology model following the OpenAPI 3.0.3
   * specification
   */
  private void addPrimitiveTypes(final Technology technology) {
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Binary", false, 
      this.dataFactory.createPrimitiveString()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Boolean", true, 
      this.dataFactory.createPrimitiveBoolean()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Byte", true, 
      this.dataFactory.createPrimitiveByte()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Char", true, 
      this.dataFactory.createPrimitiveCharacter()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Date", true, 
      this.dataFactory.createPrimitiveDate()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("DateTime", false, 
      this.dataFactory.createPrimitiveString()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Double", true, 
      this.dataFactory.createPrimitiveDouble()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Float", false, 
      this.dataFactory.createPrimitiveFloat()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Int32", false, 
      this.dataFactory.createPrimitiveInteger()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Int64", true, 
      this.dataFactory.createPrimitiveLong()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Integer", true, 
      this.dataFactory.createPrimitiveInteger()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Number", true, 
      this.dataFactory.createPrimitiveFloat()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Password", false, 
      this.dataFactory.createPrimitiveString()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Short", true, 
      this.dataFactory.createPrimitiveShort()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("String", true, 
      this.dataFactory.createPrimitiveString()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Unspecified", true, 
      this.dataFactory.createPrimitiveUnspecified()));
  }

  /**
   * Helper method to create a technology specific LEMMA type
   */
  private TechnologySpecificPrimitiveType createTechnologySpecificPrimitiveType(final String name, final boolean default_, final PrimitiveType baseType) {
    final TechnologySpecificPrimitiveType type = this.TECHNOLOGY_FACTORY.createTechnologySpecificPrimitiveType();
    type.setName(name);
    type.setDefault(default_);
    type.getBasicBuiltinPrimitiveTypes().add(baseType);
    return type;
  }

  /**
   * Add OpenAPI-related aspects to the technology model
   */
  private void addAspects(final Technology technology) {
    technology.getServiceAspects().add(this.createOperationsAspect(LemmaTechnologySubGenerator.HTTP_DELETE_ASPECT_NAME));
    technology.getServiceAspects().add(this.createOperationsAspect(LemmaTechnologySubGenerator.HTTP_GET_ASPECT_NAME));
    technology.getServiceAspects().add(this.createOperationsAspect(LemmaTechnologySubGenerator.HTTP_HEAD_ASPECT_NAME));
    technology.getServiceAspects().add(this.createOperationsAspect(LemmaTechnologySubGenerator.HTTP_OPTIONS_ASPECT_NAME));
    technology.getServiceAspects().add(this.createOperationsAspect(LemmaTechnologySubGenerator.HTTP_PATCH_ASPECT_NAME));
    technology.getServiceAspects().add(this.createOperationsAspect(LemmaTechnologySubGenerator.HTTP_POST_ASPECT_NAME));
    technology.getServiceAspects().add(this.createOperationsAspect(LemmaTechnologySubGenerator.HTTP_PUT_ASPECT_NAME));
    technology.getServiceAspects().add(this.createParametersAspect(LemmaTechnologySubGenerator.HTTP_REQUEST_BODY_ASPECT_NAME));
    technology.getServiceAspects().add(this.createOperationsAspect(LemmaTechnologySubGenerator.HTTP_TRACE_ASPECT_NAME));
    technology.getServiceAspects().add(this.createOperationsAspect(LemmaTechnologySubGenerator.UNSPECIFIED_ASPECT_NAME));
  }

  /**
   * Create a single-valued LEMMA service aspect with microservice operations as join point type
   */
  private ServiceAspect createOperationsAspect(final String name) {
    final ServiceAspect aspect = this.TECHNOLOGY_FACTORY.createServiceAspect();
    aspect.setName(name);
    aspect.getJoinPoints().add(JoinPointType.OPERATIONS);
    aspect.getFeatures().add(AspectFeature.SINGLE_VALUED);
    return aspect;
  }

  /**
   * Create a single-valued LEMMA service aspect with microservice operation parameters as join
   * point type
   */
  private ServiceAspect createParametersAspect(final String name) {
    final ServiceAspect aspect = this.TECHNOLOGY_FACTORY.createServiceAspect();
    aspect.setName(name);
    aspect.getJoinPoints().add(JoinPointType.PARAMETERS);
    aspect.getFeatures().add(AspectFeature.SINGLE_VALUED);
    return aspect;
  }

  @Pure
  public ArrayList<String> getTransMsgs() {
    return this.transMsgs;
  }
}
