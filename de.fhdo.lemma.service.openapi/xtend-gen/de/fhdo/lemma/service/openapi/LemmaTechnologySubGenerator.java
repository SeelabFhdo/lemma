package de.fhdo.lemma.service.openapi;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.DataFactory;
import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.technology.AspectFeature;
import de.fhdo.lemma.technology.DataFormat;
import de.fhdo.lemma.technology.JoinPointType;
import de.fhdo.lemma.technology.Protocol;
import de.fhdo.lemma.technology.ServiceAspect;
import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.technology.TechnologyFactory;
import de.fhdo.lemma.technology.TechnologySpecificPrimitiveType;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is responsible for handling the generation of a LEMMA technology model for the OpenAPI
 * technology from an OpenAPI file in the JSON or YAML format.
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
  
  private static final String TECHNOLOGY_MODEL_NAME = "OpenApi";
  
  private static final String DEFAULT_DATA_FORMAT = "application/json";
  
  /**
   * SLF4j LOGGER
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(LemmaTechnologySubGenerator.class);
  
  /**
   * Factory to actually create and manipulate a LEMMA Technology
   */
  private final TechnologyFactory TECHNOLOGY_FACTORY = TechnologyFactory.eINSTANCE;
  
  /**
   * Factory to actually create and manipulate a LEMMA DataModel
   */
  private final DataFactory dataFactory = DataFactory.eINSTANCE;
  
  /**
   * Predefined instance of the <strong>TechnologyModel</strong>. This instance is populated with
   * the various technologies from the OpenAPI model, e.g., media types.
   */
  private final Technology technology = this.TECHNOLOGY_FACTORY.createTechnology();
  
  /**
   * OpenAPI schema which will be used as source for generation
   */
  private OpenAPI openApi;
  
  /**
   * Log of all encountered exceptions during the data transformation
   */
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final ArrayList<String> transMsgs = CollectionLiterals.<String>newArrayList();
  
  /**
   * Location where the generated file is written
   */
  private String targetFile;
  
  public LemmaTechnologySubGenerator(final OpenAPI api, final String targetFile) {
    LemmaTechnologySubGenerator.LOGGER.debug("Creating new Technology Sub Generator...");
    this.openApi = api;
    this.targetFile = targetFile;
  }
  
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
  
  private void initialize() {
    this.technology.setName(OpenApiUtil.removeInvalidCharsFromName(LemmaTechnologySubGenerator.TECHNOLOGY_MODEL_NAME));
    this.addPrimitiveTypes(this.technology);
    this.addAspects(this.technology);
  }
  
  private boolean addRestProtocol(final Technology technology) {
    boolean _xblockexpression = false;
    {
      final Protocol rest = this.TECHNOLOGY_FACTORY.createProtocol();
      rest.setName("rest");
      final HashSet<String> mediaTypes = CollectionLiterals.<String>newHashSet();
      final BiConsumer<String, PathItem> _function = (String path, PathItem pathSchema) -> {
        mediaTypes.addAll(this.searchMediaTypes(pathSchema));
      };
      this.openApi.getPaths().forEach(_function);
      final Consumer<String> _function_1 = (String type) -> {
        final DataFormat dataFormat = this.TECHNOLOGY_FACTORY.createDataFormat();
        dataFormat.setFormatName(type);
        rest.getDataFormats().add(dataFormat);
      };
      mediaTypes.forEach(_function_1);
      DataFormat _elvis = null;
      final Function1<DataFormat, Boolean> _function_2 = (DataFormat it) -> {
        String _formatName = it.getFormatName();
        return Boolean.valueOf(Objects.equal(_formatName, LemmaTechnologySubGenerator.DEFAULT_DATA_FORMAT));
      };
      DataFormat _findFirst = IterableExtensions.<DataFormat>findFirst(rest.getDataFormats(), _function_2);
      if (_findFirst != null) {
        _elvis = _findFirst;
      } else {
        DataFormat _get = rest.getDataFormats().get(0);
        _elvis = _get;
      }
      rest.setDefaultFormat(_elvis);
      _xblockexpression = technology.getProtocols().add(rest);
    }
    return _xblockexpression;
  }
  
  private HashSet<String> searchMediaTypes(final PathItem item) {
    final Iterable<Operation> httpVerbs = IterableExtensions.<Operation>filterNull(CollectionLiterals.<Operation>newArrayList(item.getDelete(), item.getGet(), item.getHead(), item.getOptions(), item.getPatch(), 
      item.getPost(), item.getPut()));
    final HashSet<String> mediaTypes = CollectionLiterals.<String>newHashSet();
    final Consumer<Operation> _function = (Operation verb) -> {
      RequestBody _requestBody = verb.getRequestBody();
      Content _content = null;
      if (_requestBody!=null) {
        _content=_requestBody.getContent();
      }
      boolean _tripleNotEquals = (_content != null);
      if (_tripleNotEquals) {
        mediaTypes.addAll(verb.getRequestBody().getContent().keySet());
      }
      ApiResponses _responses = verb.getResponses();
      if (_responses!=null) {
        final BiConsumer<String, ApiResponse> _function_1 = (String responseCode, ApiResponse responseSchema) -> {
          Content _content_1 = null;
          if (responseSchema!=null) {
            _content_1=responseSchema.getContent();
          }
          boolean _tripleNotEquals_1 = (_content_1 != null);
          if (_tripleNotEquals_1) {
            mediaTypes.addAll(responseSchema.getContent().keySet());
          }
        };
        _responses.forEach(_function_1);
      }
    };
    httpVerbs.forEach(_function);
    return mediaTypes;
  }
  
  /**
   * Creates OpenApi data types corresponding to <italic>OpenApi v3.0.3 - Data Types</italic>.
   * OpenApi data type formats are represented as individual types.
   */
  private void addPrimitiveTypes(final Technology technology) {
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Integer", true, 
      this.dataFactory.createPrimitiveInteger()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Int32", false, 
      this.dataFactory.createPrimitiveInteger()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Int64", true, 
      this.dataFactory.createPrimitiveLong()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Number", true, 
      this.dataFactory.createPrimitiveFloat()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Float", false, 
      this.dataFactory.createPrimitiveFloat()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Double", true, 
      this.dataFactory.createPrimitiveDouble()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("String", true, 
      this.dataFactory.createPrimitiveString()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Byte", true, 
      this.dataFactory.createPrimitiveByte()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Binary", false, 
      this.dataFactory.createPrimitiveString()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Boolean", true, 
      this.dataFactory.createPrimitiveBoolean()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Date", true, 
      this.dataFactory.createPrimitiveDate()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("DateTime", false, 
      this.dataFactory.createPrimitiveString()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Password", false, 
      this.dataFactory.createPrimitiveString()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Unspecified", true, 
      this.dataFactory.createPrimitiveUnspecified()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Short", true, 
      this.dataFactory.createPrimitiveShort()));
    technology.getPrimitiveTypes().add(this.createTechnologySpecificPrimitiveType("Char", true, 
      this.dataFactory.createPrimitiveCharacter()));
  }
  
  private TechnologySpecificPrimitiveType createTechnologySpecificPrimitiveType(final String name, final boolean default_, final PrimitiveType baseType) {
    final TechnologySpecificPrimitiveType type = this.TECHNOLOGY_FACTORY.createTechnologySpecificPrimitiveType();
    type.setName(name);
    type.setDefault(default_);
    type.getBasicBuiltinPrimitiveTypes().add(baseType);
    return type;
  }
  
  /**
   * Create default aspects for HTTP-based communication, i.e., request methods and response codes
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
  
  private ServiceAspect createOperationsAspect(final String name) {
    final ServiceAspect aspect = this.TECHNOLOGY_FACTORY.createServiceAspect();
    aspect.setName(name);
    aspect.getJoinPoints().add(JoinPointType.OPERATIONS);
    aspect.getFeatures().add(AspectFeature.SINGLE_VALUED);
    return aspect;
  }
  
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
