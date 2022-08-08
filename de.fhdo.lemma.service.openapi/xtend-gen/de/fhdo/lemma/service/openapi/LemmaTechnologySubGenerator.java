package de.fhdo.lemma.service.openapi;

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
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
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
  /**
   * Factory to actually create and manipulate a LEMMA Technology
   */
  private final TechnologyFactory TECHNOLOGY_FACTORY = TechnologyFactory.eINSTANCE;
  
  /**
   * Factory to actually create and manipulate a LEMMA DataModel
   */
  private final DataFactory DATA_FACTORY = DataFactory.eINSTANCE;
  
  /**
   * Predefined instance of the <strong>TechnologyModel</strong>. This instance is populated
   * with the various technologies from the OpenAPI model, e.g., media types.
   */
  private final Technology myTechModel = this.TECHNOLOGY_FACTORY.createTechnology();
  
  /**
   * OpenAPI schema which will be used as source for generation.
   */
  private OpenAPI openApi;
  
  /**
   * Log of all encountered exceptions during the data transformation
   */
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final ArrayList<String> transMsgs = CollectionLiterals.<String>newArrayList();
  
  /**
   * SLF4j Logger
   */
  private static final Logger logger = LoggerFactory.getLogger(LemmaServiceSubGenerator.class);
  
  /**
   * Location where the generated file is written
   */
  private String targetFile;
  
  /**
   * List of all unique media types.
   */
  private final HashSet<String> mediaTypes = CollectionLiterals.<String>newHashSet();
  
  public LemmaTechnologySubGenerator(final OpenAPI api, final String targetFile) {
    super();
    LemmaTechnologySubGenerator.logger.debug("Creating new Technology Sub Generator...");
    this.openApi = api;
    this.targetFile = targetFile;
  }
  
  public Technology generate() {
    try {
      LemmaTechnologySubGenerator.logger.debug("Starting generation...");
      LemmaTechnologySubGenerator.logger.debug("Initializing model instance...");
      this.initilize();
      LemmaTechnologySubGenerator.logger.debug("...Technology Model initialized!");
      LemmaTechnologySubGenerator.logger.debug("Creating protocols...");
      this.createProtocols();
      LemmaTechnologySubGenerator.logger.debug("...Data Structures created!");
      boolean _writeModel = OpenApiUtil.writeModel(this.myTechModel, this.targetFile);
      if (_writeModel) {
        LemmaTechnologySubGenerator.logger.info("Technology model generation successful!");
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Model written to ");
        _builder.append(this.targetFile);
        LemmaTechnologySubGenerator.logger.info(_builder.toString());
      } else {
        throw new Exception("Technology model generation failed :(");
      }
      return this.myTechModel;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean createProtocols() {
    boolean _xblockexpression = false;
    {
      final Protocol rest = this.TECHNOLOGY_FACTORY.createProtocol();
      rest.setName("rest");
      final BiConsumer<String, PathItem> _function = (String path, PathItem pathSchema) -> {
        this.searchMediaTimes(pathSchema);
      };
      this.openApi.getPaths().forEach(_function);
      final Consumer<String> _function_1 = (String type) -> {
        final DataFormat df = this.TECHNOLOGY_FACTORY.createDataFormat();
        df.setFormatName(type);
        rest.getDataFormats().add(df);
      };
      this.mediaTypes.forEach(_function_1);
      DataFormat _elvis = null;
      final Function1<DataFormat, Boolean> _function_2 = (DataFormat it) -> {
        return Boolean.valueOf(it.getFormatName().equals("application/json"));
      };
      DataFormat _findFirst = IterableExtensions.<DataFormat>findFirst(rest.getDataFormats(), _function_2);
      if (_findFirst != null) {
        _elvis = _findFirst;
      } else {
        DataFormat _get = rest.getDataFormats().get(0);
        _elvis = _get;
      }
      rest.setDefaultFormat(_elvis);
      _xblockexpression = this.myTechModel.getProtocols().add(rest);
    }
    return _xblockexpression;
  }
  
  public void searchMediaTimes(final PathItem item) {
    final ArrayList<Operation> httpVerbList = CollectionLiterals.<Operation>newArrayList();
    CollectionExtensions.<Operation>addAll(httpVerbList, item.getGet(), item.getDelete(), item.getPut(), 
      item.getPost(), item.getPatch(), item.getHead(), item.getOptions());
    final Consumer<Operation> _function = (Operation verb) -> {
      if ((verb != null)) {
        ApiResponses _responses = verb.getResponses();
        if (_responses!=null) {
          final BiConsumer<String, ApiResponse> _function_1 = (String responseCode, ApiResponse responseSchema) -> {
            Content _content = null;
            if (responseSchema!=null) {
              _content=responseSchema.getContent();
            }
            Set<String> _keySet = null;
            if (_content!=null) {
              _keySet=_content.keySet();
            }
            this.addToMediaTypes(_keySet);
          };
          _responses.forEach(_function_1);
        }
        RequestBody _requestBody = verb.getRequestBody();
        Content _content = null;
        if (_requestBody!=null) {
          _content=_requestBody.getContent();
        }
        Set<String> _keySet = null;
        if (_content!=null) {
          _keySet=_content.keySet();
        }
        this.addToMediaTypes(_keySet);
      }
    };
    httpVerbList.forEach(_function);
  }
  
  public void addToMediaTypes(final Set<String> strings) {
    if ((strings != null)) {
      final Consumer<String> _function = (String mediaType) -> {
        this.mediaTypes.add(mediaType);
      };
      strings.forEach(_function);
    }
  }
  
  public void initilize() {
    this.myTechModel.setName(OpenApiUtil.removeInvalidCharsFromName("OpenApi"));
    this.initPrimitives(this.myTechModel);
    this.initAspects(this.myTechModel);
  }
  
  /**
   * Creates Default Aspects for HTTP-based communication,
   * i.e., request methods and response codes.
   */
  public void initAspects(final Technology technology) {
    final ArrayList<ServiceAspect> httpVerbs = CollectionLiterals.<ServiceAspect>newArrayList();
    httpVerbs.add(this.createServiceAspect("GetMapping"));
    httpVerbs.add(this.createServiceAspect("PutMapping"));
    httpVerbs.add(this.createServiceAspect("PostMapping"));
    httpVerbs.add(this.createServiceAspect("DeleteMapping"));
    httpVerbs.add(this.createServiceAspect("OptionsMapping"));
    httpVerbs.add(this.createServiceAspect("HeadMapping"));
    httpVerbs.add(this.createServiceAspect("PatchMapping"));
    httpVerbs.add(this.createServiceAspect("TraceMapping"));
    httpVerbs.add(this.createServiceAspect("Unspecified"));
    this.myTechModel.getServiceAspects().addAll(httpVerbs);
    this.myTechModel.getServiceAspects().add(this.createParameterAspect("RequestBody"));
  }
  
  public ServiceAspect createServiceAspect(final String name) {
    final ServiceAspect ret = this.TECHNOLOGY_FACTORY.createServiceAspect();
    ret.setName(name);
    ret.getJoinPoints().add(JoinPointType.OPERATIONS);
    ret.getFeatures().add(AspectFeature.SINGLE_VALUED);
    return ret;
  }
  
  public ServiceAspect createParameterAspect(final String name) {
    final ServiceAspect ret = this.TECHNOLOGY_FACTORY.createServiceAspect();
    ret.setName(name);
    ret.getJoinPoints().add(JoinPointType.PARAMETERS);
    ret.getFeatures().add(AspectFeature.SINGLE_VALUED);
    return ret;
  }
  
  /**
   * Creates OpenApi data types corresponding to <italic>OpenApi v3.0.3 - Data Types</italic>.
   * OpenApi data type formats are represented as individual types.
   */
  public void initPrimitives(final Technology technology) {
    final ArrayList<TechnologySpecificPrimitiveType> primTypes = CollectionLiterals.<TechnologySpecificPrimitiveType>newArrayList();
    primTypes.add(this.createPrimitive("Integer", true, this.DATA_FACTORY.createPrimitiveInteger()));
    primTypes.add(this.createPrimitive("Int32", false, this.DATA_FACTORY.createPrimitiveInteger()));
    primTypes.add(this.createPrimitive("Int64", true, this.DATA_FACTORY.createPrimitiveLong()));
    primTypes.add(this.createPrimitive("Number", true, this.DATA_FACTORY.createPrimitiveFloat()));
    primTypes.add(this.createPrimitive("Float", false, this.DATA_FACTORY.createPrimitiveFloat()));
    primTypes.add(this.createPrimitive("Double", true, this.DATA_FACTORY.createPrimitiveDouble()));
    primTypes.add(this.createPrimitive("String", true, this.DATA_FACTORY.createPrimitiveString()));
    primTypes.add(this.createPrimitive("Byte", true, this.DATA_FACTORY.createPrimitiveByte()));
    primTypes.add(this.createPrimitive("Binary", false, this.DATA_FACTORY.createPrimitiveString()));
    primTypes.add(this.createPrimitive("Boolean", true, this.DATA_FACTORY.createPrimitiveBoolean()));
    primTypes.add(this.createPrimitive("Date", true, this.DATA_FACTORY.createPrimitiveDate()));
    primTypes.add(this.createPrimitive("DateTime", false, this.DATA_FACTORY.createPrimitiveString()));
    primTypes.add(this.createPrimitive("Password", false, this.DATA_FACTORY.createPrimitiveString()));
    primTypes.add(this.createPrimitive("Unspecified", true, this.DATA_FACTORY.createPrimitiveUnspecified()));
    primTypes.add(this.createPrimitive("Short", true, this.DATA_FACTORY.createPrimitiveShort()));
    primTypes.add(this.createPrimitive("Char", true, this.DATA_FACTORY.createPrimitiveCharacter()));
    technology.getPrimitiveTypes().addAll(primTypes);
  }
  
  public TechnologySpecificPrimitiveType createPrimitive(final String name, final boolean default_, final PrimitiveType type) {
    final TechnologySpecificPrimitiveType ret = this.TECHNOLOGY_FACTORY.createTechnologySpecificPrimitiveType();
    ret.setName(name);
    ret.setDefault(default_);
    ret.getBasicBuiltinPrimitiveTypes().add(type);
    return ret;
  }
  
  @Pure
  public ArrayList<String> getTransMsgs() {
    return this.transMsgs;
  }
}
