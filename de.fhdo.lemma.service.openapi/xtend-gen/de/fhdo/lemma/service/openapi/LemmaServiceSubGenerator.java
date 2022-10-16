package de.fhdo.lemma.service.openapi;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.CollectionType;
import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.Context;
import de.fhdo.lemma.data.DataFactory;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.data.Type;
import de.fhdo.lemma.data.Version;
import de.fhdo.lemma.service.ApiOperationComment;
import de.fhdo.lemma.service.Endpoint;
import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.ImportType;
import de.fhdo.lemma.service.ImportedProtocolAndDataFormat;
import de.fhdo.lemma.service.ImportedServiceAspect;
import de.fhdo.lemma.service.ImportedType;
import de.fhdo.lemma.service.Interface;
import de.fhdo.lemma.service.Microservice;
import de.fhdo.lemma.service.MicroserviceType;
import de.fhdo.lemma.service.ServiceFactory;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.service.Visibility;
import de.fhdo.lemma.technology.CommunicationType;
import de.fhdo.lemma.technology.ExchangePattern;
import de.fhdo.lemma.technology.Protocol;
import de.fhdo.lemma.technology.ServiceAspect;
import de.fhdo.lemma.technology.Technology;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is responsible for handling the generation of a LEMMA service model from an OpenAPI
 * file in the JSON or YAML format.
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public class LemmaServiceSubGenerator {
  /**
   * Default name if no tags are encountered in the OpenAPI description
   */
  private static final String DEFAULT_INTERFACE_NAME = "defaultInterface";
  
  private static final Map<String, String> HTTP_METHOD_TO_ASPECT = Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(Pair.<String, String>of("DELETE", LemmaTechnologySubGenerator.HTTP_DELETE_ASPECT_NAME), Pair.<String, String>of("GET", LemmaTechnologySubGenerator.HTTP_GET_ASPECT_NAME), Pair.<String, String>of("HEAD", LemmaTechnologySubGenerator.HTTP_HEAD_ASPECT_NAME), Pair.<String, String>of("OPTIONS", LemmaTechnologySubGenerator.HTTP_OPTIONS_ASPECT_NAME), Pair.<String, String>of("PATCH", LemmaTechnologySubGenerator.HTTP_PATCH_ASPECT_NAME), Pair.<String, String>of("POST", LemmaTechnologySubGenerator.HTTP_POST_ASPECT_NAME), Pair.<String, String>of("PUT", LemmaTechnologySubGenerator.HTTP_PUT_ASPECT_NAME), Pair.<String, String>of("TRACE", LemmaTechnologySubGenerator.HTTP_TRACE_ASPECT_NAME)));
  
  /**
   * SLF4j LOGGER
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(LemmaTechnologySubGenerator.class);
  
  /**
   * Name of the protocol which is used as default for endpoint generation
   */
  private static final String REST_PROTOCOL = "rest";
  
  /**
   * Factory to actually create and manipulate a LEMMA DataModel
   */
  private final DataFactory dataFactory = DataFactory.eINSTANCE;
  
  /**
   * Factory to actually create and manipulate a LEMMA ServiceModel
   */
  private final ServiceFactory serviceFactory = ServiceFactory.eINSTANCE;
  
  /**
   * Predefined instance of the <strong>ServiceModel</strong>. This instance is populated with the
   * various services and interfaces from the OpenAPI model. It is the central artifact which gets
   * serialized as a ".services" file.
   */
  private final ServiceModel serviceModel = this.serviceFactory.createServiceModel();
  
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
   * Contains the previous generated OpenApi LEMMA DataModel which is handed over by the
   * LemmaGenerator
   */
  private Pair<String, DataModel> dataModel;
  
  /**
   * Contains the previous generated OpenApi LEMMA Technology which is handed over by the
   * LemmaGenerator
   */
  private Pair<String, Technology> technology;
  
  /**
   * Location where the generated file is written
   */
  private String targetFile;
  
  private String dataModelLoc;
  
  /**
   * Constructor
   */
  public LemmaServiceSubGenerator(final OpenAPI openApi, final Pair<String, DataModel> dataModel, final Pair<String, Technology> technology, final String targetFile) {
    LemmaServiceSubGenerator.LOGGER.debug("Creating new Service Sub Generator...");
    this.openApi = openApi;
    this.targetFile = targetFile;
    this.dataModel = dataModel;
    this.technology = technology;
    this.dataModelLoc = Paths.get(new File(targetFile).getParent(), dataModel.getKey()).toString();
  }
  
  /**
   * Generate LEMMA service model from a previously parsed OpenAPI specification file. This method
   * returns the created model instance and also serializes it to the user's harddrive.
   */
  public void generate(final String serviceQualifier) {
    try {
      LemmaServiceSubGenerator.LOGGER.debug("Adding data model import...");
      this.createDataImport(this.dataModel.getKey(), this.dataModel.getValue());
      LemmaServiceSubGenerator.LOGGER.debug("... data model import added");
      LemmaServiceSubGenerator.LOGGER.debug("Adding technology import...");
      this.createTechnologyImport(this.technology.getKey(), this.technology.getValue());
      LemmaServiceSubGenerator.LOGGER.debug("... technology import added");
      LemmaServiceSubGenerator.LOGGER.debug("Adding microservice...");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(serviceQualifier);
      _builder.append(".");
      String _removeInvalidCharsFromName = OpenApiUtil.removeInvalidCharsFromName(this.openApi.getInfo().getTitle());
      final String microserviceName = (_builder.toString() + _removeInvalidCharsFromName);
      final Microservice microservice = this.createFunctionalMicroservice(microserviceName);
      LemmaServiceSubGenerator.LOGGER.debug("... microservice added");
      LemmaServiceSubGenerator.LOGGER.debug("Adding interfaces...");
      List<Tag> _tags = this.openApi.getTags();
      boolean _tripleNotEquals = (_tags != null);
      if (_tripleNotEquals) {
        final Consumer<Tag> _function = (Tag it) -> {
          this.createInterface(microservice, it.getName());
        };
        this.openApi.getTags().forEach(_function);
      } else {
        this.createInterface(microservice, LemmaServiceSubGenerator.DEFAULT_INTERFACE_NAME);
      }
      LemmaServiceSubGenerator.LOGGER.debug("... interfaces added");
      LemmaServiceSubGenerator.LOGGER.debug("Creating interface operations for each path item...");
      final BiConsumer<String, PathItem> _function_1 = (String key, PathItem value) -> {
        try {
          this.createOperations(microservice, key, value);
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception ex = (Exception)_t;
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("Error while creating operation ");
            _builder_1.append(key);
            _builder_1.append(". Operation is skipped. ");
            String _plus = (_builder_1.toString() + 
              "Please refer to the debug log for details.");
            this.transMsgs.add(_plus);
            LemmaServiceSubGenerator.LOGGER.debug(ex.getMessage());
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      };
      this.openApi.getPaths().forEach(_function_1);
      LemmaServiceSubGenerator.LOGGER.debug("... operations created");
      LemmaServiceSubGenerator.LOGGER.debug("... services created");
      boolean _writeModel = OpenApiUtil.writeModel(this.serviceModel, this.targetFile);
      if (_writeModel) {
        LemmaServiceSubGenerator.LOGGER.info("Service model generation successful");
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Model written to ");
        _builder_1.append(this.targetFile);
        LemmaServiceSubGenerator.LOGGER.info(_builder_1.toString());
      } else {
        throw new Exception("Generated service model could not be written to hard disk.");
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Create an Import instance for the given URI and within the context of the given data model.
   * The import is added to the current serviceModel.
   */
  private Import createDataImport(final String uri, final DataModel model) {
    try {
      final Import dataImport = this.serviceFactory.createImport();
      dataImport.setImportType(ImportType.DATATYPES);
      dataImport.setImportURI(uri);
      Version _get = model.getVersions().get(0);
      EList<Context> _contexts = null;
      if (_get!=null) {
        _contexts=_get.getContexts();
      }
      Context _get_1 = _contexts.get(0);
      String _name = null;
      if (_get_1!=null) {
        _name=_get_1.getName();
      }
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_name);
      if (_isNullOrEmpty) {
        throw new Exception("Name of Data Model to be imported not set.");
      }
      Version _get_2 = model.getVersions().get(0);
      EList<Context> _contexts_1 = null;
      if (_get_2!=null) {
        _contexts_1=_get_2.getContexts();
      }
      Context _get_3 = _contexts_1.get(0);
      String _name_1 = null;
      if (_get_3!=null) {
        _name_1=_get_3.getName();
      }
      dataImport.setName(_name_1.concat("Data"));
      dataImport.setServiceModel(this.serviceModel);
      LemmaServiceSubGenerator.LOGGER.debug("Data model import added");
      return dataImport;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Create an Import instance for the given URI and within the context of the given technology
   * model. The import is added to the current serviceModel.
   */
  private Import createTechnologyImport(final String uri, final Technology technology) {
    final Import techImport = this.serviceFactory.createImport();
    techImport.setImportType(ImportType.TECHNOLOGY);
    techImport.setImportURI(uri);
    techImport.setName(technology.getName());
    techImport.setServiceModel(this.serviceModel);
    LemmaServiceSubGenerator.LOGGER.debug("Technology import added");
    return techImport;
  }
  
  /**
   * Create a functional Microservice instance with the given name. The microservice is added to
   * the current serviceModel.
   */
  private Microservice createFunctionalMicroservice(final String name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Microservice name: ");
    _builder.append(name);
    LemmaServiceSubGenerator.LOGGER.info(_builder.toString());
    final Microservice functionalService = this.serviceFactory.createMicroservice();
    functionalService.setServiceModel(this.serviceModel);
    functionalService.setName(name);
    functionalService.setVisibility(Visibility.PUBLIC);
    functionalService.setType(MicroserviceType.FUNCTIONAL);
    this.serviceModel.getMicroservices().add(functionalService);
    LemmaServiceSubGenerator.LOGGER.debug("Functional microservice added");
    return functionalService;
  }
  
  /**
   * Create an Interface instance for the given microservice and with the given name. The import
   * is added to the current serviceModel.
   */
  private Interface createInterface(final Microservice microservice, final String name) {
    final Interface interface_ = this.serviceFactory.createInterface();
    interface_.setName(name);
    interface_.setMicroservice(microservice);
    microservice.getInterfaces().add(interface_);
    return interface_;
  }
  
  /**
   * Create Operation instances for the OpenAPI operations in the given path item within an
   * interface of the given LEMMA microservice. The target interface depends on the first tag of
   * the currently processed OpenAPI operation.
   */
  private void createOperations(final Microservice microservice, final String path, final PathItem item) {
    List<Server> _servers = item.getServers();
    boolean _tripleNotEquals = (_servers != null);
    if (_tripleNotEquals) {
      throw new UnsupportedOperationException("Servers operation currently not supported");
    } else {
      List<Parameter> _parameters = item.getParameters();
      boolean _tripleNotEquals_1 = (_parameters != null);
      if (_tripleNotEquals_1) {
        throw new UnsupportedOperationException("Parameters operation currently not supported");
      }
    }
    Operation _delete = item.getDelete();
    if (_delete!=null) {
      this.toLemmaOperation(_delete, microservice, "DELETE", path);
    }
    Operation _get = item.getGet();
    if (_get!=null) {
      this.toLemmaOperation(_get, microservice, "GET", path);
    }
    Operation _head = item.getHead();
    if (_head!=null) {
      this.toLemmaOperation(_head, microservice, "HEAD", path);
    }
    Operation _options = item.getOptions();
    if (_options!=null) {
      this.toLemmaOperation(_options, microservice, "OPTIONS", path);
    }
    Operation _patch = item.getPatch();
    if (_patch!=null) {
      this.toLemmaOperation(_patch, microservice, "PATCH", path);
    }
    Operation _post = item.getPost();
    if (_post!=null) {
      this.toLemmaOperation(_post, microservice, "POST", path);
    }
    Operation _put = item.getPut();
    if (_put!=null) {
      this.toLemmaOperation(_put, microservice, "PUT", path);
    }
    Operation _trace = item.getTrace();
    if (_trace!=null) {
      this.toLemmaOperation(_trace, microservice, "TRACE", path);
    }
  }
  
  /**
   * Transform an OpenAPI operation to a LEMMA operation and add the operation to the
   * corresponding interface of the given LEMMA microservice
   */
  private boolean toLemmaOperation(final Operation openApiOperation, final Microservice microservice, final String type, final String path) {
    boolean _xblockexpression = false;
    {
      String _xifexpression = null;
      boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(openApiOperation.getTags());
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        _xifexpression = openApiOperation.getTags().get(0);
      } else {
        _xifexpression = LemmaServiceSubGenerator.DEFAULT_INTERFACE_NAME;
      }
      final String interfaceName = _xifexpression;
      final Function1<Interface, Boolean> _function = (Interface it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, interfaceName));
      };
      Interface _findFirst = IterableExtensions.<Interface>findFirst(microservice.getInterfaces(), _function);
      EList<de.fhdo.lemma.service.Operation> _operations = null;
      if (_findFirst!=null) {
        _operations=_findFirst.getOperations();
      }
      _xblockexpression = _operations.add(this.createLemmaOperation(type, path, openApiOperation));
    }
    return _xblockexpression;
  }
  
  /**
   * Create a LEMMA Operation instances from the given HTTP verb, e.g., GET, PUT, or POST, the
   * given URI path, and OpenAPI Operation
   */
  private de.fhdo.lemma.service.Operation createLemmaOperation(final String type, final String path, final Operation openApiOperation) {
    final de.fhdo.lemma.service.Operation lemmaOperation = this.serviceFactory.createOperation();
    lemmaOperation.setName(openApiOperation.getOperationId());
    this.addRestEndpoint(lemmaOperation, type, path, openApiOperation);
    this.addRestAspect(lemmaOperation, type, openApiOperation);
    this.addComment(lemmaOperation, type, path, openApiOperation);
    this.addParameters(lemmaOperation, openApiOperation);
    return lemmaOperation;
  }
  
  /**
   * Add a LEMMA Endpoint for the "rest" protocol from the OpenAPI technology model with the given
   * path to the given LEMMA Operation
   */
  private void addRestEndpoint(final de.fhdo.lemma.service.Operation lemmaOperation, final String type, final String path, final Operation openApiOperation) {
    final Endpoint endpoint = this.serviceFactory.createEndpoint();
    final ImportedProtocolAndDataFormat protocol = this.serviceFactory.createImportedProtocolAndDataFormat();
    final Function1<Protocol, Boolean> _function = (Protocol it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, LemmaServiceSubGenerator.REST_PROTOCOL));
    };
    protocol.setImportedProtocol(IterableExtensions.<Protocol>findFirst(this.technology.getValue().getProtocols(), _function));
    endpoint.getProtocols().add(protocol);
    endpoint.getAddresses().add(path);
    lemmaOperation.getEndpoints().add(endpoint);
  }
  
  /**
   * Add a LEMMA ImportedServiceAspect for the given HTTP verb from the OpenAPI technology model
   * to the given LEMMA Operation
   */
  private void addRestAspect(final de.fhdo.lemma.service.Operation lemmaOperation, final String type, final Operation openApiOperation) {
    final ImportedServiceAspect aspect = this.serviceFactory.createImportedServiceAspect();
    ServiceAspect _xifexpression = null;
    boolean _containsKey = LemmaServiceSubGenerator.HTTP_METHOD_TO_ASPECT.containsKey(type);
    if (_containsKey) {
      final Function1<ServiceAspect, Boolean> _function = (ServiceAspect it) -> {
        String _name = it.getName();
        String _get = LemmaServiceSubGenerator.HTTP_METHOD_TO_ASPECT.get(type);
        return Boolean.valueOf(Objects.equal(_name, _get));
      };
      _xifexpression = IterableExtensions.<ServiceAspect>findFirst(this.technology.getValue().getServiceAspects(), _function);
    } else {
      final Function1<ServiceAspect, Boolean> _function_1 = (ServiceAspect it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, LemmaTechnologySubGenerator.UNSPECIFIED_ASPECT_NAME));
      };
      _xifexpression = IterableExtensions.<ServiceAspect>findFirst(this.technology.getValue().getServiceAspects(), _function_1);
    }
    aspect.setImportedAspect(_xifexpression);
    lemmaOperation.getAspects().add(aspect);
  }
  
  /**
   * Add a LEMMA ApiOperationComment that identifies the HTTP verb, path, summary, and description
   * of the given OpenAPI Operation on the corresponding LEMMA Operation
   */
  private void addComment(final de.fhdo.lemma.service.Operation lemmaOperation, final String type, final String path, final Operation openApiOperation) {
    final ApiOperationComment comment = this.serviceFactory.createApiOperationComment();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("**Type** ");
    _builder.append(type);
    _builder.append(" Operation for path ");
    _builder.append(path);
    _builder.newLineIfNotEmpty();
    _builder.append("**Summary** ");
    String _summary = openApiOperation.getSummary();
    _builder.append(_summary);
    _builder.newLineIfNotEmpty();
    _builder.append("**Description** ");
    String _description = openApiOperation.getDescription();
    _builder.append(_description);
    _builder.newLineIfNotEmpty();
    comment.setComment(_builder.toString());
    comment.setOperation(lemmaOperation);
  }
  
  /**
   * Derive LEMMA Parameters from the given OpenAPI Operation. According to OpenAPI 3.0.3, either
   * the "parameters" field is used as input for deriving the LEMMA Parameters or, in case the
   * HTTP method supports a body, the "requestBody" field is used (cf. RFC 7231).
   */
  private void addParameters(final de.fhdo.lemma.service.Operation lemmaOperation, final Operation openApiOperation) {
    List<Parameter> _parameters = openApiOperation.getParameters();
    boolean _tripleNotEquals = (_parameters != null);
    if (_tripleNotEquals) {
      final Function1<Parameter, de.fhdo.lemma.service.Parameter> _function = (Parameter it) -> {
        return this.createLemmaInParameter(it);
      };
      lemmaOperation.getParameters().addAll(
        ListExtensions.<Parameter, de.fhdo.lemma.service.Parameter>map(openApiOperation.getParameters(), _function));
    }
    RequestBody _requestBody = openApiOperation.getRequestBody();
    boolean _tripleNotEquals_1 = (_requestBody != null);
    if (_tripleNotEquals_1) {
      Content _content = openApiOperation.getRequestBody().getContent();
      boolean _tripleNotEquals_2 = (_content != null);
      if (_tripleNotEquals_2) {
        Content _content_1 = openApiOperation.getRequestBody().getContent();
        Collection<MediaType> _values = null;
        if (_content_1!=null) {
          _values=_content_1.values();
        }
        final Schema schema = (((MediaType[])Conversions.unwrapArray(_values, MediaType.class))[0]).getSchema();
        lemmaOperation.getParameters().add(this.createLemmaInParameterFromMediaTypeValue(schema));
      }
    }
    ApiResponses _responses = openApiOperation.getResponses();
    if (_responses!=null) {
      final BiConsumer<String, ApiResponse> _function_1 = (String key, ApiResponse value) -> {
        boolean _equals = Objects.equal(key, "200");
        if (_equals) {
          lemmaOperation.getParameters().add(this.createLemmaOutParameter(value));
        } else {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Unsupported HTTP code: ");
          _builder.append(key);
          LemmaServiceSubGenerator.LOGGER.info(_builder.toString());
        }
      };
      _responses.forEach(_function_1);
    }
  }
  
  /**
   * Create an incoming synchronous LEMMA Parameter from an OpenAPI Parameter
   */
  private de.fhdo.lemma.service.Parameter createLemmaInParameter(final Parameter openApiParameter) {
    final de.fhdo.lemma.service.Parameter lemmaParameter = this.serviceFactory.createParameter();
    lemmaParameter.setCommunicationType(CommunicationType.SYNCHRONOUS);
    lemmaParameter.setExchangePattern(ExchangePattern.IN);
    lemmaParameter.setName(openApiParameter.getName().toLowerCase());
    Boolean _required = openApiParameter.getRequired();
    boolean _not = (!(_required).booleanValue());
    lemmaParameter.setOptional(_not);
    Schema _xifexpression = null;
    Content _content = openApiParameter.getContent();
    boolean _tripleEquals = (_content == null);
    if (_tripleEquals) {
      _xifexpression = openApiParameter.getSchema();
    } else {
      _xifexpression = null;
    }
    final Schema schema = _xifexpression;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(openApiParameter.get$ref());
    boolean _not_1 = (!_isNullOrEmpty);
    if (_not_1) {
      lemmaParameter.setImportedType(this.createImportedComplexTypeFromRef(openApiParameter.get$ref()));
    } else {
      this.setPrimitiveOrArrayDataTypeFromSchema(lemmaParameter, schema);
    }
    return lemmaParameter;
  }
  
  /**
   * Create a LEMMA ImportedType instance from an OpenAPI "ref" string
   */
  private ImportedType createImportedComplexTypeFromRef(final String ref) {
    final ImportedType importedType = this.serviceFactory.createImportedType();
    importedType.setImport(this.serviceModel.getImports().get(0));
    ImportedType _xtrycatchfinallyexpression = null;
    try {
      ImportedType _xblockexpression = null;
      {
        importedType.setType(this.findComplexTypeFromRef(ref));
        ImportedType _xifexpression = null;
        Type _type = importedType.getType();
        boolean _tripleNotEquals = (_type != null);
        if (_tripleNotEquals) {
          _xifexpression = importedType;
        } else {
          _xifexpression = null;
        }
        _xblockexpression = _xifexpression;
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        final IllegalArgumentException ex = (IllegalArgumentException)_t;
        Object _xblockexpression_1 = null;
        {
          LemmaServiceSubGenerator.LOGGER.error(ex.getMessage());
          _xblockexpression_1 = null;
        }
        _xtrycatchfinallyexpression = ((ImportedType)_xblockexpression_1);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  /**
   * Find a previously created LEMMA ComplexType for the given OpenAPI "ref" string in the current
   * data model. Throws an IllegalArgumentException in case no matching ComplexType was found.
   */
  private ComplexType findComplexTypeFromRef(final String ref) {
    final String[] parts = ref.split("/");
    if (((((List<String>)Conversions.doWrapArray(parts)).size() < 4) && (!ref.startsWith("#/components/schemas/")))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Could not find matching complex type for ref ");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(ref);
      _builder_1.append(" in data model");
      String _plus = (_builder.toString() + _builder_1);
      throw new IllegalArgumentException(_plus);
    }
    final Function1<ComplexType, Boolean> _function = (ComplexType it) -> {
      String _name = it.getName();
      String _firstUpper = StringExtensions.toFirstUpper(parts[3]);
      return Boolean.valueOf(Objects.equal(_name, _firstUpper));
    };
    return IterableExtensions.<ComplexType>findFirst(this.dataModel.getValue().getVersions().get(0).getContexts().get(0).getComplexTypes(), _function);
  }
  
  /**
   * Create an incoming synchronous LEMMA Parameter from a given OpenAPI Schema
   */
  private de.fhdo.lemma.service.Parameter createLemmaInParameterFromMediaTypeValue(final Schema<?> schema) {
    final de.fhdo.lemma.service.Parameter lemmaParameter = this.serviceFactory.createParameter();
    lemmaParameter.setCommunicationType(CommunicationType.SYNCHRONOUS);
    lemmaParameter.setExchangePattern(ExchangePattern.IN);
    lemmaParameter.setName("requestBody");
    lemmaParameter.setOptional(false);
    final ImportedServiceAspect aspect = this.serviceFactory.createImportedServiceAspect();
    final Function1<ServiceAspect, Boolean> _function = (ServiceAspect it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, LemmaTechnologySubGenerator.HTTP_REQUEST_BODY_ASPECT_NAME));
    };
    aspect.setImportedAspect(IterableExtensions.<ServiceAspect>findFirst(this.technology.getValue().getServiceAspects(), _function));
    lemmaParameter.getAspects().add(aspect);
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(schema.get$ref());
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      lemmaParameter.setImportedType(this.createImportedComplexTypeFromRef(schema.get$ref()));
    } else {
      this.setPrimitiveOrArrayDataTypeFromSchema(lemmaParameter, schema);
    }
    return lemmaParameter;
  }
  
  /**
   * Set the primitive or array type of the given LEMMA parameter based on the given OpenAPI
   * Schema
   */
  private void setPrimitiveOrArrayDataTypeFromSchema(final de.fhdo.lemma.service.Parameter parameter, final Schema<?> schema) {
    String _type = schema.getType();
    if (_type != null) {
      switch (_type) {
        case "array":
          final ArraySchema arraySchema = ((ArraySchema) schema);
          final ImportedType existingType = this.createImportedComplexTypeFromDomainConcept(
            LemmaDataSubGenerator.getCollectionTypeName(arraySchema));
          if ((existingType != null)) {
            parameter.setImportedType(existingType);
          } else {
            final CollectionType collectionType = this.getOrCreateCollectionTypeFromSchema(arraySchema);
            parameter.setImportedType(this.createImportedComplexTypeFromDomainConcept(collectionType.getName()));
          }
          break;
        case "boolean":
          parameter.setPrimitiveType(this.dataFactory.createPrimitiveBoolean());
          break;
        case "integer":
          parameter.setPrimitiveType(OpenApiUtil.deriveIntType(schema.getFormat()));
          break;
        case "number":
          parameter.setPrimitiveType(OpenApiUtil.deriveNumberType(schema.getFormat()));
          break;
        case "object":
          Object _additionalProperties = schema.getAdditionalProperties();
          this.setPrimitiveOrArrayDataTypeFromSchema(parameter, 
            ((Schema<?>) _additionalProperties));
          break;
        case "string":
          parameter.setPrimitiveType(OpenApiUtil.deriveStringType(schema.getFormat()));
          break;
        default:
          String _type_1 = schema.getType();
          String _plus = ("Could not find matching type for " + _type_1);
          throw new IllegalArgumentException(_plus);
      }
    } else {
      String _type_1 = schema.getType();
      String _plus = ("Could not find matching type for " + _type_1);
      throw new IllegalArgumentException(_plus);
    }
  }
  
  /**
   * Creates a LEMMA ImportedType instance for a domain concept of the given name in the current
   * data model
   */
  private ImportedType createImportedComplexTypeFromDomainConcept(final String domainConceptName) {
    final ImportedType importedType = this.serviceFactory.createImportedType();
    importedType.setImport(this.serviceModel.getImports().get(0));
    final Function1<ComplexType, Boolean> _function = (ComplexType it) -> {
      return Boolean.valueOf(it.getName().equals(it.getName()));
    };
    importedType.setType(IterableExtensions.<ComplexType>findFirst(this.dataModel.getValue().getVersions().get(0).getContexts().get(0).getComplexTypes(), _function));
    ImportedType _xifexpression = null;
    Type _type = importedType.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      _xifexpression = importedType;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  /**
   * Create or retrieve a previously created CollectionType from an OpenAPI ArraySchema in the
   * current data model
   */
  private CollectionType getOrCreateCollectionTypeFromSchema(final ArraySchema schema) {
    try {
      final CollectionType collectionType = this.dataFactory.createCollectionType();
      collectionType.setName(LemmaDataSubGenerator.getCollectionTypeName(schema));
      String _type = schema.getItems().getType();
      boolean _matched = false;
      if (Objects.equal(_type, "string")) {
        _matched=true;
        collectionType.setPrimitiveType(this.dataFactory.createPrimitiveString());
      }
      if (!_matched) {
        if (Objects.equal(_type, "integer")) {
          _matched=true;
          collectionType.setPrimitiveType(this.dataFactory.createPrimitiveInteger());
        }
      }
      if (!_matched) {
        if (Objects.equal(_type, "number")) {
          _matched=true;
          collectionType.setPrimitiveType(this.dataFactory.createPrimitiveFloat());
        }
      }
      if (!_matched) {
        if (Objects.equal(_type, "boolean")) {
          _matched=true;
          collectionType.setPrimitiveType(this.dataFactory.createPrimitiveBoolean());
        }
      }
      if (!_matched) {
        if (Objects.equal(_type, null)) {
          _matched=true;
          final DataField field = this.dataFactory.createDataField();
          field.setComplexType(this.findComplexTypeFromRef(schema.getItems().get$ref()));
          field.setName(field.getComplexType().getName().toLowerCase());
          collectionType.setName(LemmaDataSubGenerator.getCollectionTypeName(field.getComplexType().getName()));
          collectionType.getDataFields().add(field);
        }
      }
      if (!_matched) {
        StringConcatenation _builder = new StringConcatenation();
        String _type_1 = schema.getType();
        _builder.append(_type_1);
        _builder.append(" is not supported");
        String _plus = ("Array type " + _builder);
        throw new UnsupportedOperationException(_plus);
      }
      Version _get = this.dataModel.getValue().getVersions().get(0);
      EList<Context> _contexts = null;
      if (_get!=null) {
        _contexts=_get.getContexts();
      }
      Context _get_1 = _contexts.get(0);
      EList<ComplexType> _complexTypes = null;
      if (_get_1!=null) {
        _complexTypes=_get_1.getComplexTypes();
      }
      final EList<ComplexType> complexTypes = _complexTypes;
      final Function1<ComplexType, Boolean> _function = (ComplexType it) -> {
        String _name = it.getName();
        String _name_1 = collectionType.getName();
        return Boolean.valueOf(Objects.equal(_name, _name_1));
      };
      boolean _exists = IterableExtensions.<ComplexType>exists(complexTypes, _function);
      boolean _not = (!_exists);
      if (_not) {
        complexTypes.add(collectionType);
        boolean _writeModel = OpenApiUtil.writeModel(this.dataModel.getValue(), this.dataModelLoc);
        if (_writeModel) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("Data model ");
          _builder_1.append(this.dataModelLoc);
          _builder_1.append(" was successfully altered");
          LemmaServiceSubGenerator.LOGGER.info(_builder_1.toString());
        } else {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("Data model ");
          _builder_2.append(this.dataModelLoc);
          _builder_2.append(" could not be altered");
          throw new Exception(_builder_2.toString());
        }
      } else {
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("Collection type ");
        String _name = collectionType.getName();
        _builder_3.append(_name);
        _builder_3.append(" already exists in data model");
        LemmaServiceSubGenerator.LOGGER.info(_builder_3.toString());
      }
      return collectionType;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Create an outgoing synchronous LEMMA Parameter from the given OpenAPI ApiResponse
   */
  private de.fhdo.lemma.service.Parameter createLemmaOutParameter(final ApiResponse response) {
    final de.fhdo.lemma.service.Parameter lemmaParameter = this.serviceFactory.createParameter();
    lemmaParameter.setCommunicationType(CommunicationType.SYNCHRONOUS);
    lemmaParameter.setExchangePattern(ExchangePattern.OUT);
    lemmaParameter.setName("returnValue");
    lemmaParameter.setOptional(false);
    MediaType _get = (((MediaType[])Conversions.unwrapArray(response.getContent().values(), MediaType.class))[0]);
    Schema _schema = null;
    if (_get!=null) {
      _schema=_get.getSchema();
    }
    final Schema schema = _schema;
    String _$ref = null;
    if (schema!=null) {
      _$ref=schema.get$ref();
    }
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_$ref);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      lemmaParameter.setImportedType(this.createImportedComplexTypeFromRef(schema.get$ref()));
    } else {
      if ((schema != null)) {
        this.setPrimitiveOrArrayDataTypeFromSchema(lemmaParameter, schema);
      } else {
        lemmaParameter.setPrimitiveType(this.dataFactory.createPrimitiveUnspecified());
      }
    }
    return lemmaParameter;
  }
  
  @Pure
  public ArrayList<String> getTransMsgs() {
    return this.transMsgs;
  }
}
