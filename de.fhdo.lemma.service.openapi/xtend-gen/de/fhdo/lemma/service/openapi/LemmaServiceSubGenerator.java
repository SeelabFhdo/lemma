package de.fhdo.lemma.service.openapi;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.Context;
import de.fhdo.lemma.data.DataFactory;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.data.ListType;
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
import de.fhdo.lemma.service.openapi.exceptions.ComplexTypeException;
import de.fhdo.lemma.service.openapi.exceptions.MatchingException;
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
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is responsible for handling the generation of a LEMMA service model from an
 * OpenAPI file in the JSON or YAML format.
 * It depends on previous execution of the LemmaDataSubGenerator.
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public class LemmaServiceSubGenerator {
  /**
   * Factory to actually create and manipulate a LEMMA DataModel
   */
  private final ServiceFactory SERVICE_FACTORY = ServiceFactory.eINSTANCE;
  
  /**
   * Factory to actually create and manipulate a LEMMA DataModel
   */
  private final DataFactory DATA_FACTORY = DataFactory.eINSTANCE;
  
  /**
   * Predefined instance of the <strong>ServiceModel</strong>. This instance is populated
   * with the various services and interfaces from the OpenAPI model. It is the central artifact
   * which gets serialized as an <italic>.services</italic> file.
   */
  private final ServiceModel myServiceModel = this.SERVICE_FACTORY.createServiceModel();
  
  /**
   * Name of the protocol which is used as default for endpoint generation
   */
  private final String DEFAULT_PROTOCOL = "rest";
  
  /**
   * OpenAPI schema which will be used as source for generation.
   */
  private OpenAPI openAPI;
  
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
   * Contains the previous generated OpenApi <italic>LEMMA Data Model</italic>
   * which is handed over by the LemmaGenerator
   */
  private Pair<String, DataModel> dataModel;
  
  /**
   * Contains the previous generated OpenApi <italic>LEMMA Tech Model</italic>
   * which is handed over by the LemmaGenerator
   */
  private Pair<String, Technology> techModel;
  
  private String targetFile;
  
  /**
   * Default name if no tags are encountered in the OpenAPI description
   */
  private final String defaultName = "defaultInterface";
  
  private String dataModelLoc;
  
  public LemmaServiceSubGenerator(final OpenAPI openAPI, final Pair<String, DataModel> dataModel, final Pair<String, Technology> techModel, final String targetFile) {
    super();
    LemmaServiceSubGenerator.logger.debug("Creating new Service Sub Generator...");
    this.openAPI = openAPI;
    this.targetFile = targetFile;
    this.dataModel = dataModel;
    this.techModel = techModel;
    this.dataModelLoc = Paths.get(new File(targetFile).getParent(), dataModel.getKey()).toString();
  }
  
  public void generate(final String servicePrefix) {
    LemmaServiceSubGenerator.logger.debug("Starting generation...");
    LemmaServiceSubGenerator.logger.debug("Adding data model import...");
    this.createDataImport(this.dataModel.getKey(), this.dataModel.getValue());
    LemmaServiceSubGenerator.logger.debug("Adding technology import...");
    this.createTechnologyImport(this.techModel.getKey(), this.techModel.getValue());
    LemmaServiceSubGenerator.logger.debug("Adding microservice...");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(servicePrefix);
    _builder.append(".");
    String _removeInvalidCharsFromName = OpenApiUtil.removeInvalidCharsFromName(this.openAPI.getInfo().getTitle());
    _builder.append(_removeInvalidCharsFromName);
    final Microservice myMicroservice = this.createFunctionalMicroservice(_builder.toString());
    LemmaServiceSubGenerator.logger.debug("Adding interfaces...");
    final ArrayList<Interface> interfaces = CollectionLiterals.<Interface>newArrayList();
    List<Tag> _tags = this.openAPI.getTags();
    if (_tags!=null) {
      final Consumer<Tag> _function = (Tag tag) -> {
        try {
          if (interfaces!=null) {
            interfaces.add(this.createInterface(myMicroservice, tag.getName()));
          }
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception e = (Exception)_t;
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("Error while creating interface ");
            _builder_1.append(tag);
            _builder_1.append(". Interface is skipped.");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("                    ");
            _builder_1.append("For details access debug log.");
            this.transMsgs.add(_builder_1.toString());
            LemmaServiceSubGenerator.logger.debug(e.getMessage());
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      };
      _tags.forEach(_function);
    }
    int _size = interfaces.size();
    boolean _equals = (_size == 0);
    if (_equals) {
      interfaces.add(this.createInterface(myMicroservice, this.defaultName));
    }
    LemmaServiceSubGenerator.logger.debug("Creating interface operations for each path item...");
    final BiConsumer<String, PathItem> _function_1 = (String key, PathItem value) -> {
      try {
        this.createOperations(interfaces, key, value);
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("Error while creating operation ");
          _builder_1.append(key);
          _builder_1.append(". Operation is skipped.");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("                    ");
          _builder_1.append("For details access debug log.");
          this.transMsgs.add(_builder_1.toString());
          LemmaServiceSubGenerator.logger.debug(e.getMessage());
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    };
    this.openAPI.getPaths().forEach(_function_1);
    LemmaServiceSubGenerator.logger.debug("...Services created!");
    boolean _writeModel = OpenApiUtil.writeModel(this.myServiceModel, this.targetFile);
    if (_writeModel) {
      LemmaServiceSubGenerator.logger.info("Service model generation successful!");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Model written to ");
      _builder_1.append(this.targetFile);
      LemmaServiceSubGenerator.logger.info(_builder_1.toString());
    } else {
      LemmaServiceSubGenerator.logger.info("Service model generation failed. See debug for more info.");
    }
  }
  
  public ArrayList<Interface> createOperations(final ArrayList<Interface> interfaces, final String path, final PathItem item) {
    Operation _get = item.getGet();
    if (_get!=null) {
      this.addOperation(_get, interfaces, "GET", path);
    }
    Operation _put = item.getPut();
    if (_put!=null) {
      this.addOperation(_put, interfaces, "PUT", path);
    }
    Operation _post = item.getPost();
    if (_post!=null) {
      this.addOperation(_post, interfaces, "POST", path);
    }
    Operation _delete = item.getDelete();
    if (_delete!=null) {
      this.addOperation(_delete, interfaces, "DELETE", path);
    }
    Operation _options = item.getOptions();
    if (_options!=null) {
      this.addOperation(_options, interfaces, "OPTIONS", path);
    }
    Operation _head = item.getHead();
    if (_head!=null) {
      this.addOperation(_head, interfaces, "HEAD", path);
    }
    Operation _patch = item.getPatch();
    if (_patch!=null) {
      this.addOperation(_patch, interfaces, "PATCH", path);
    }
    Operation _trace = item.getTrace();
    if (_trace!=null) {
      this.addOperation(_trace, interfaces, "TRACE", path);
    }
    List<Server> _servers = item.getServers();
    boolean _tripleNotEquals = (_servers != null);
    if (_tripleNotEquals) {
      throw new UnsupportedOperationException("Servers Operation currently not supported");
    }
    List<Parameter> _parameters = item.getParameters();
    boolean _tripleNotEquals_1 = (_parameters != null);
    if (_tripleNotEquals_1) {
      throw new UnsupportedOperationException("Parameters Operation currently not supported");
    }
    return interfaces;
  }
  
  public boolean addOperation(final Operation swop, final ArrayList<Interface> interfaces, final String type, final String path) {
    boolean _xblockexpression = false;
    {
      final de.fhdo.lemma.service.Operation newOp = this.createLemmaOperation(type, path, swop);
      String _xifexpression = null;
      boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(swop.getTags());
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        _xifexpression = swop.getTags().get(0);
      } else {
        _xifexpression = this.defaultName;
      }
      final String tag = _xifexpression;
      final Function1<Interface, Boolean> _function = (Interface it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, tag));
      };
      Interface _findFirst = IterableExtensions.<Interface>findFirst(interfaces, _function);
      EList<de.fhdo.lemma.service.Operation> _operations = null;
      if (_findFirst!=null) {
        _operations=_findFirst.getOperations();
      }
      _xblockexpression = _operations.add(newOp);
    }
    return _xblockexpression;
  }
  
  /**
   * Creates and returns a <strong>Lemma Operation</strong> based on
   * the <strong>Type</strong>, e.g., GET, PUT, or POST, the <strong>URI path</strong>,
   * and the <strong>Swagger Operation</strong>.
   * The import is added to <italic>myServiceModel</italic>
   */
  public de.fhdo.lemma.service.Operation createLemmaOperation(final String type, final String path, final Operation swop) {
    final de.fhdo.lemma.service.Operation lemmaOp = this.SERVICE_FACTORY.createOperation();
    lemmaOp.setName(swop.getOperationId());
    this.CreateEndpoints(lemmaOp, type, path, swop);
    this.CreateRestAspect(lemmaOp, type, swop);
    this.createCommentary(lemmaOp, type, path, swop);
    this.createParameters(lemmaOp, swop);
    return lemmaOp;
  }
  
  /**
   * Iterates through the given Swagger <strong>operation</strong> returns a list of Lemma
   * Parameters. According to the Swagger Spec 3.0.2 either the <italic>parameters</italic> field
   * is used as input for generating the Lemma Parameters or, only when the HTTP methods
   * support a body, the <italic>requestBody</italic> (compare RFC7231).
   */
  public void createParameters(final de.fhdo.lemma.service.Operation operation, final Operation swop) {
    final ArrayList<de.fhdo.lemma.service.Parameter> lemmaParams = CollectionLiterals.<de.fhdo.lemma.service.Parameter>newArrayList();
    List<Parameter> _parameters = swop.getParameters();
    boolean _tripleNotEquals = (_parameters != null);
    if (_tripleNotEquals) {
      List<Parameter> _parameters_1 = swop.getParameters();
      if (_parameters_1!=null) {
        final Consumer<Parameter> _function = (Parameter it) -> {
          final de.fhdo.lemma.service.Parameter lemmaParam = this.createLemmaInParameter(((Parameter) it));
          lemmaParams.add(lemmaParam);
        };
        _parameters_1.forEach(_function);
      }
    }
    RequestBody _requestBody = swop.getRequestBody();
    boolean _tripleNotEquals_1 = (_requestBody != null);
    if (_tripleNotEquals_1) {
      Content _content = swop.getRequestBody().getContent();
      Collection<MediaType> _values = null;
      if (_content!=null) {
        _values=_content.values();
      }
      final Schema outSchema = (((MediaType[])Conversions.unwrapArray(_values, MediaType.class))[0]).getSchema();
      final de.fhdo.lemma.service.Parameter lemmaParam = this.createLemmaInParameterFromMediaTypeValue(outSchema);
      lemmaParams.add(lemmaParam);
    }
    ApiResponses _responses = swop.getResponses();
    boolean _tripleNotEquals_2 = (_responses != null);
    if (_tripleNotEquals_2) {
      ApiResponses _responses_1 = swop.getResponses();
      if (_responses_1!=null) {
        final BiConsumer<String, ApiResponse> _function_1 = (String key, ApiResponse value) -> {
          boolean _equals = key.equals("200");
          if (_equals) {
            final de.fhdo.lemma.service.Parameter lemmaParam_1 = this.createLemmaOutParameter(((ApiResponse) value));
            lemmaParams.add(lemmaParam_1);
          } else {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Unsupported HTTP Code found: ");
            _builder.append(key);
            LemmaServiceSubGenerator.logger.info(_builder.toString());
          }
        };
        _responses_1.forEach(_function_1);
      }
    }
    operation.getParameters().addAll(lemmaParams);
  }
  
  /**
   * Creates and returns a <strong>Lemma Parameter</strong> based on
   * a <strong>Swagger Parameter</strong>. This method uses <italic>dataModels</italic> to
   * add complex data types.
   */
  public de.fhdo.lemma.service.Parameter createLemmaInParameterFromMediaTypeValue(final Schema schema) {
    de.fhdo.lemma.service.Parameter newLemmaParam = this.SERVICE_FACTORY.createParameter();
    newLemmaParam.setName(StringUtils.uncapitalize("requestBody"));
    newLemmaParam.setOptional(false);
    newLemmaParam.setExchangePattern(ExchangePattern.IN);
    final ImportedServiceAspect aspect = this.SERVICE_FACTORY.createImportedServiceAspect();
    final Function1<ServiceAspect, Boolean> _function = (ServiceAspect it) -> {
      return Boolean.valueOf(it.getName().equals("RequestBody"));
    };
    aspect.setImportedAspect(IteratorExtensions.<ServiceAspect>findFirst(this.techModel.getValue().getServiceAspects().iterator(), _function));
    newLemmaParam.getAspects().add(aspect);
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(schema.get$ref());
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      newLemmaParam.setImportedType(this.getImportedComplexDataTypeFromRef(schema.get$ref()));
    } else {
      newLemmaParam = this.getPrimitiveOrArrayDataTypeFromSchema(newLemmaParam, schema);
    }
    return newLemmaParam;
  }
  
  public de.fhdo.lemma.service.Parameter createLemmaOutParameter(final ApiResponse response) {
    de.fhdo.lemma.service.Parameter newLemmaParam = this.SERVICE_FACTORY.createParameter();
    newLemmaParam.setExchangePattern(ExchangePattern.OUT);
    newLemmaParam.setCommunicationType(CommunicationType.SYNCHRONOUS);
    newLemmaParam.setOptional(false);
    newLemmaParam.setName(StringUtils.uncapitalize("returnValue"));
    final MediaType responseSchema = ((MediaType[])Conversions.unwrapArray(response.getContent().values(), MediaType.class))[0];
    Schema _schema = responseSchema.getSchema();
    boolean _tripleEquals = (_schema == null);
    if (_tripleEquals) {
      newLemmaParam.setPrimitiveType(this.DATA_FACTORY.createPrimitiveUnspecified());
    } else {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(responseSchema.getSchema().get$ref());
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        newLemmaParam.setImportedType(this.getImportedComplexDataTypeFromRef(
          responseSchema.getSchema().get$ref()));
      } else {
        newLemmaParam = this.getPrimitiveOrArrayDataTypeFromSchema(newLemmaParam, 
          responseSchema.getSchema());
      }
    }
    return newLemmaParam;
  }
  
  /**
   * Creates and returns a new <strong>PrimitiveType</strong> based on a given OpenAPI schema.
   */
  public de.fhdo.lemma.service.Parameter getPrimitiveOrArrayDataTypeFromSchema(final de.fhdo.lemma.service.Parameter para, final Schema schema) {
    try {
      de.fhdo.lemma.service.Parameter returnPara = para;
      String _type = schema.getType();
      if (_type != null) {
        switch (_type) {
          case "integer":
            returnPara.setPrimitiveType(OpenApiUtil.deriveIntType(schema.getFormat()));
            break;
          case "number":
            returnPara.setPrimitiveType(OpenApiUtil.deriveNumberType(schema.getFormat()));
            break;
          case "string":
            returnPara.setPrimitiveType(OpenApiUtil.deriveStringType(schema.getFormat()));
            break;
          case "boolean":
            returnPara.setPrimitiveType(this.DATA_FACTORY.createPrimitiveBoolean());
            break;
          case "object":
            Object _additionalProperties = schema.getAdditionalProperties();
            returnPara = this.getPrimitiveOrArrayDataTypeFromSchema(para, ((Schema) _additionalProperties));
            break;
          case "array":
            final ArraySchema arSchema = ((ArraySchema) schema);
            String _firstUpper = StringExtensions.toFirstUpper(arSchema.getItems().getType());
            String _plus = (_firstUpper + "List");
            final ImportedType findings = this.getImportedComplexDataTypeFromName(_plus);
            if ((findings != null)) {
              returnPara.setImportedType(findings);
            } else {
              final ListType arrayList = this.createListTypeFromArraySchema(arSchema);
              returnPara.setImportedType(this.getImportedComplexDataTypeFromName(arrayList.getName()));
            }
            break;
          default:
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Could not find fitting Type for ");
            String _type_1 = schema.getType();
            _builder.append(_type_1);
            throw new MatchingException(_builder.toString());
        }
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Could not find fitting Type for ");
        String _type_1 = schema.getType();
        _builder.append(_type_1);
        throw new MatchingException(_builder.toString());
      }
      return returnPara;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ListType createListTypeFromArraySchema(final ArraySchema arSchema) {
    try {
      final ListType arrayList = this.DATA_FACTORY.createListType();
      String _firstUpper = StringExtensions.toFirstUpper(arSchema.getItems().getType());
      String _plus = (_firstUpper + "List");
      arrayList.setName(_plus);
      String _type = arSchema.getItems().getType();
      boolean _matched = false;
      if (Objects.equal(_type, "string")) {
        _matched=true;
        arrayList.setPrimitiveType(this.DATA_FACTORY.createPrimitiveString());
      }
      if (!_matched) {
        if (Objects.equal(_type, "integer")) {
          _matched=true;
          arrayList.setPrimitiveType(this.DATA_FACTORY.createPrimitiveInteger());
        }
      }
      if (!_matched) {
        if (Objects.equal(_type, "number")) {
          _matched=true;
          arrayList.setPrimitiveType(this.DATA_FACTORY.createPrimitiveFloat());
        }
      }
      if (!_matched) {
        if (Objects.equal(_type, "boolean")) {
          _matched=true;
          arrayList.setPrimitiveType(this.DATA_FACTORY.createPrimitiveBoolean());
        }
      }
      if (!_matched) {
        if (Objects.equal(_type, null)) {
          _matched=true;
          final DataField myField = this.DATA_FACTORY.createDataField();
          myField.setComplexType(this.getComplexDataTypeFromRef(arSchema.getItems().get$ref()));
          myField.setName(myField.getComplexType().getName().toLowerCase());
          String _firstUpper_1 = StringExtensions.toFirstUpper(myField.getComplexType().getName());
          String _plus_1 = (_firstUpper_1 + "List");
          arrayList.setName(_plus_1);
          arrayList.getDataFields().add(myField);
        }
      }
      if (!_matched) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Could not handle Array type. ");
        _builder.append(arSchema);
        _builder.append(" is not supported!");
        throw new NotImplementedException(_builder.toString());
      }
      final DataModel dataModel = this.dataModel.getValue();
      final Function1<ComplexType, Boolean> _function = (ComplexType it) -> {
        return Boolean.valueOf(it.getName().equals(arrayList.getName()));
      };
      boolean _isEmpty = IterableExtensions.isEmpty(IterableExtensions.<ComplexType>filter(dataModel.getContainedComplexTypes(), _function));
      if (_isEmpty) {
        Version _get = dataModel.getVersions().get(0);
        EList<Context> _contexts = null;
        if (_get!=null) {
          _contexts=_get.getContexts();
        }
        Context _get_1 = _contexts.get(0);
        EList<ComplexType> _complexTypes = null;
        if (_get_1!=null) {
          _complexTypes=_get_1.getComplexTypes();
        }
        _complexTypes.add(arrayList);
        boolean _writeModel = OpenApiUtil.writeModel(dataModel, this.dataModelLoc);
        if (_writeModel) {
          LemmaServiceSubGenerator.logger.info("Data model alteration successful!");
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("Model written to ");
          _builder_1.append(this.dataModelLoc);
          LemmaServiceSubGenerator.logger.info(_builder_1.toString());
        } else {
          throw new Exception("Data model alteration failed :(");
        }
      } else {
        LemmaServiceSubGenerator.logger.info("Skipped: ComplexType already in Data Model.");
      }
      return arrayList;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void CreateEndpoints(final de.fhdo.lemma.service.Operation leOp, final String type, final String path, final Operation swOp) {
    final Endpoint endpoint = this.SERVICE_FACTORY.createEndpoint();
    final ImportedProtocolAndDataFormat proto = this.SERVICE_FACTORY.createImportedProtocolAndDataFormat();
    final Function1<Protocol, Boolean> _function = (Protocol it) -> {
      String _name = it.getName();
      return Boolean.valueOf((_name == this.DEFAULT_PROTOCOL));
    };
    proto.setImportedProtocol(IterableExtensions.<Protocol>findFirst(this.techModel.getValue().getProtocols(), _function));
    endpoint.getProtocols().add(proto);
    endpoint.getAddresses().add(path);
    leOp.getEndpoints().add(endpoint);
  }
  
  public void CreateRestAspect(final de.fhdo.lemma.service.Operation leOp, final String type, final Operation swOp) {
    final ImportedServiceAspect aspect = this.SERVICE_FACTORY.createImportedServiceAspect();
    final EList<ServiceAspect> opAspects = this.techModel.getValue().getServiceAspects();
    ServiceAspect _switchResult = null;
    if (type != null) {
      switch (type) {
        case "GET":
          final Function1<ServiceAspect, Boolean> _function = (ServiceAspect it) -> {
            String _name = it.getName();
            return Boolean.valueOf(Objects.equal(_name, "GetMapping"));
          };
          _switchResult = IterableExtensions.<ServiceAspect>head(IterableExtensions.<ServiceAspect>filter(opAspects, _function));
          break;
        case "PUT":
          final Function1<ServiceAspect, Boolean> _function_1 = (ServiceAspect it) -> {
            String _name = it.getName();
            return Boolean.valueOf(Objects.equal(_name, "PutMapping"));
          };
          _switchResult = IterableExtensions.<ServiceAspect>head(IterableExtensions.<ServiceAspect>filter(opAspects, _function_1));
          break;
        case "POST":
          final Function1<ServiceAspect, Boolean> _function_2 = (ServiceAspect it) -> {
            String _name = it.getName();
            return Boolean.valueOf(Objects.equal(_name, "PostMapping"));
          };
          _switchResult = IterableExtensions.<ServiceAspect>head(IterableExtensions.<ServiceAspect>filter(opAspects, _function_2));
          break;
        case "DELETE":
          final Function1<ServiceAspect, Boolean> _function_3 = (ServiceAspect it) -> {
            String _name = it.getName();
            return Boolean.valueOf(Objects.equal(_name, "DeleteMapping"));
          };
          _switchResult = IterableExtensions.<ServiceAspect>head(IterableExtensions.<ServiceAspect>filter(opAspects, _function_3));
          break;
        case "OPTIONS":
          final Function1<ServiceAspect, Boolean> _function_4 = (ServiceAspect it) -> {
            String _name = it.getName();
            return Boolean.valueOf(Objects.equal(_name, "OptionsMapping"));
          };
          _switchResult = IterableExtensions.<ServiceAspect>head(IterableExtensions.<ServiceAspect>filter(opAspects, _function_4));
          break;
        case "HEAD":
          final Function1<ServiceAspect, Boolean> _function_5 = (ServiceAspect it) -> {
            String _name = it.getName();
            return Boolean.valueOf(Objects.equal(_name, "HeadMapping"));
          };
          _switchResult = IterableExtensions.<ServiceAspect>head(IterableExtensions.<ServiceAspect>filter(opAspects, _function_5));
          break;
        case "PATCH":
          final Function1<ServiceAspect, Boolean> _function_6 = (ServiceAspect it) -> {
            String _name = it.getName();
            return Boolean.valueOf(Objects.equal(_name, "PatchMapping"));
          };
          _switchResult = IterableExtensions.<ServiceAspect>head(IterableExtensions.<ServiceAspect>filter(opAspects, _function_6));
          break;
        case "TRACE":
          final Function1<ServiceAspect, Boolean> _function_7 = (ServiceAspect it) -> {
            String _name = it.getName();
            return Boolean.valueOf(Objects.equal(_name, "TraceMapping"));
          };
          _switchResult = IterableExtensions.<ServiceAspect>head(IterableExtensions.<ServiceAspect>filter(opAspects, _function_7));
          break;
        default:
          final Function1<ServiceAspect, Boolean> _function_8 = (ServiceAspect it) -> {
            String _name = it.getName();
            return Boolean.valueOf(Objects.equal(_name, "Unspecified"));
          };
          _switchResult = IterableExtensions.<ServiceAspect>head(IterableExtensions.<ServiceAspect>filter(opAspects, _function_8));
          break;
      }
    } else {
      final Function1<ServiceAspect, Boolean> _function_8 = (ServiceAspect it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, "Unspecified"));
      };
      _switchResult = IterableExtensions.<ServiceAspect>head(IterableExtensions.<ServiceAspect>filter(opAspects, _function_8));
    }
    aspect.setImportedAspect(_switchResult);
    leOp.getAspects().add(aspect);
  }
  
  public void createCommentary(final de.fhdo.lemma.service.Operation leOp, final String type, final String path, final Operation swOp) {
    final ApiOperationComment comment = this.SERVICE_FACTORY.createApiOperationComment();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("**Type** ");
    _builder.append(type);
    _builder.append(" Operation for path ");
    _builder.append(path);
    _builder.newLineIfNotEmpty();
    _builder.append("**Summary** ");
    String _summary = swOp.getSummary();
    _builder.append(_summary);
    _builder.newLineIfNotEmpty();
    _builder.append("**Description** ");
    String _description = swOp.getDescription();
    _builder.append(_description);
    _builder.newLineIfNotEmpty();
    comment.setComment(_builder.toString());
    comment.setOperation(leOp);
  }
  
  /**
   * Creates and returns a <strong>Lemma Parameter</strong> based on
   * a <strong>Swagger Parameter</strong>. This method uses <italic>dataModels</italic> to
   * add complex data types.
   */
  public de.fhdo.lemma.service.Parameter createLemmaInParameter(final Parameter parameter) {
    final de.fhdo.lemma.service.Parameter newLemmaParam = this.SERVICE_FACTORY.createParameter();
    newLemmaParam.setName(StringUtils.lowerCase(parameter.getName()));
    Boolean _elvis = null;
    Boolean _required = parameter.getRequired();
    if (_required != null) {
      _elvis = _required;
    } else {
      _elvis = Boolean.valueOf(false);
    }
    newLemmaParam.setOptional((_elvis).booleanValue());
    newLemmaParam.setExchangePattern(ExchangePattern.IN);
    Schema schema = null;
    Content _content = parameter.getContent();
    boolean _tripleNotEquals = (_content != null);
    if (_tripleNotEquals) {
      InputOutput.<Parameter>println(parameter);
    } else {
      schema = parameter.getSchema();
    }
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(parameter.get$ref());
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      newLemmaParam.setImportedType(this.getImportedComplexDataTypeFromRef(parameter.get$ref()));
    } else {
      this.getPrimitiveOrArrayDataTypeFromSchema(newLemmaParam, schema);
    }
    return newLemmaParam;
  }
  
  /**
   * Creates and returns a <strong>Data Model Import</strong> based on
   * the given <strong>uri</strong> and <strong>model</strong>.
   * The import is added to <italic>myServiceModel</italic>
   */
  public Import createDataImport(final String uri, final DataModel model) {
    final Import dataImport = this.SERVICE_FACTORY.createImport();
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
    dataImport.setName(_name.concat("Data"));
    dataImport.setServiceModel(this.myServiceModel);
    LemmaServiceSubGenerator.logger.debug("Added data model import.");
    return dataImport;
  }
  
  /**
   * Creates and returns a <strong>Technology Import</strong> based on
   * the given <strong>uri</strong> and <strong>model</strong>.
   * The import is added to <italic>myServiceModel</italic>
   */
  public Import createTechnologyImport(final String uri, final Technology technology) {
    final Import techImport = this.SERVICE_FACTORY.createImport();
    techImport.setImportType(ImportType.TECHNOLOGY);
    techImport.setImportURI(uri);
    techImport.setName(technology.getName());
    techImport.setServiceModel(this.myServiceModel);
    LemmaServiceSubGenerator.logger.debug("Added technology import.");
    return techImport;
  }
  
  /**
   * Creates and returns a <strong>Microservice</strong> with the given <strong>name</strong>.
   * The service is added to <italic>myServiceModel</italic>
   */
  public Microservice createFunctionalMicroservice(final String name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("NAME DES MICROSERVICE: ");
    _builder.append(name);
    LemmaServiceSubGenerator.logger.info(_builder.toString());
    final Microservice functionalService = this.SERVICE_FACTORY.createMicroservice();
    functionalService.setServiceModel(this.myServiceModel);
    functionalService.setName(name);
    functionalService.setVisibility(Visibility.PUBLIC);
    functionalService.setType(MicroserviceType.FUNCTIONAL);
    this.myServiceModel.getMicroservices().add(functionalService);
    LemmaServiceSubGenerator.logger.debug("Added functional microservice.");
    return functionalService;
  }
  
  /**
   * Creates and returns a new <strong>Interface</strong> with the given <strong>name</strong>.
   * The service is added to the <italic>microservice</italic>.
   */
  public Interface createInterface(final Microservice microservice, final String name) {
    final Interface interface_ = this.SERVICE_FACTORY.createInterface();
    interface_.setName(name);
    interface_.setMicroservice(microservice);
    microservice.getInterfaces().add(interface_);
    return interface_;
  }
  
  /**
   * Finds a previously created <strong>ComplexType</strong> from the data model with
   * from the given <strong>ref</strong> string (c.f. OpenAPI Spec).
   * If no fitting ComplexType is found throws a ComplexTypeException.
   */
  public ComplexType getComplexDataTypeFromRef(final String ref) throws ComplexTypeException {
    final DataModel dataModel = this.dataModel.getValue();
    final EList<ComplexType> complexTypes = dataModel.getVersions().get(0).getContexts().get(0).getComplexTypes();
    final String[] parts = ref.split("/");
    int _size = ((List<String>)Conversions.doWrapArray(parts)).size();
    boolean _greaterEqualsThan = (_size >= 4);
    if (_greaterEqualsThan) {
      if (((parts[1]).equals("components") && (parts[2]).equals("schemas"))) {
        final Function1<ComplexType, Boolean> _function = (ComplexType it) -> {
          return Boolean.valueOf(it.getName().equals(StringUtils.capitalize(parts[3])));
        };
        return IterableExtensions.<ComplexType>findFirst(complexTypes, _function);
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Could not find fitting type for ");
    _builder.append(ref);
    _builder.append(" in Data Model");
    throw new ComplexTypeException(_builder.toString());
  }
  
  /**
   * Creates and returns a new <strong>ImportedType</strong> from a given
   * OpenAPI <strong>ref</strong> object.
   */
  public ImportedType getImportedComplexDataTypeFromRef(final String ref) {
    final ImportedType importedType = this.SERVICE_FACTORY.createImportedType();
    importedType.setImport(this.myServiceModel.getImports().get(0));
    try {
      importedType.setType(this.getComplexDataTypeFromRef(ref));
    } catch (final Throwable _t) {
      if (_t instanceof ComplexTypeException) {
        final ComplexTypeException cte = (ComplexTypeException)_t;
        LemmaServiceSubGenerator.logger.error(cte.getMessage());
        cte.printStackTrace();
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    Type _type = importedType.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      return importedType;
    } else {
      return null;
    }
  }
  
  /**
   * Finds and returns a new <strong>ImportedType</strong> from the imported data model
   *  based on the <strong>name</strong> of an domain entity.
   */
  public ImportedType getImportedComplexDataTypeFromName(final String name) {
    final DataModel dataModel = this.dataModel.getValue();
    final EList<ComplexType> complexTypes = dataModel.getVersions().get(0).getContexts().get(0).getComplexTypes();
    final ImportedType importedType = this.SERVICE_FACTORY.createImportedType();
    importedType.setImport(this.myServiceModel.getImports().get(0));
    try {
      final Function1<ComplexType, Boolean> _function = (ComplexType it) -> {
        return Boolean.valueOf(it.getName().equals(name));
      };
      importedType.setType(IterableExtensions.<ComplexType>findFirst(complexTypes, _function));
    } catch (final Throwable _t) {
      if (_t instanceof ComplexTypeException) {
        final ComplexTypeException cte = (ComplexTypeException)_t;
        LemmaServiceSubGenerator.logger.error(cte.getMessage());
        cte.printStackTrace();
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    Type _type = importedType.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      return importedType;
    } else {
      return null;
    }
  }
  
  @Pure
  public ArrayList<String> getTransMsgs() {
    return this.transMsgs;
  }
}
