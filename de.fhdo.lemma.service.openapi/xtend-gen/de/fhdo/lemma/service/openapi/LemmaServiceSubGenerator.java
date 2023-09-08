package de.fhdo.lemma.service.openapi;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.CollectionType;
import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.Context;
import de.fhdo.lemma.data.DataFactory;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.data.Type;
import de.fhdo.lemma.data.Version;
import de.fhdo.lemma.service.Endpoint;
import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.ImportType;
import de.fhdo.lemma.service.ImportedProtocolAndDataFormat;
import de.fhdo.lemma.service.ImportedServiceAspect;
import de.fhdo.lemma.service.ImportedType;
import de.fhdo.lemma.service.Interface;
import de.fhdo.lemma.service.Microservice;
import de.fhdo.lemma.service.MicroserviceType;
import de.fhdo.lemma.service.Operation;
import de.fhdo.lemma.service.Parameter;
import de.fhdo.lemma.service.ServiceFactory;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.service.Visibility;
import de.fhdo.lemma.technology.Protocol;
import de.fhdo.lemma.technology.ServiceAspect;
import de.fhdo.lemma.technology.Technology;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.slf4j.Logger;

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
  private static final Logger LOGGER /* Skipped initializer because of errors */;

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
  private /* OpenAPI */Object openApi;

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
  public LemmaServiceSubGenerator(final /* OpenAPI */Object openApi, final Pair<String, DataModel> dataModel, final Pair<String, Technology> technology, final String targetFile) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LemmaServiceSubGenerator.openApi refers to the missing type  */\n    OpenAPI");
  }

  /**
   * Generate LEMMA service model from a previously parsed OpenAPI specification file. This method
   * returns the created model instance and also serializes it to the user's harddrive.
   */
  public void generate(final String serviceQualifier) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field name is undefined"
      + "\nThe field LemmaServiceSubGenerator.openApi refers to the missing type  */\n    OpenAPI"
      + "\nThe field LemmaServiceSubGenerator.openApi refers to the missing type  */\n    OpenAPI"
      + "\nThe field LemmaServiceSubGenerator.openApi refers to the missing type  */\n    OpenAPI"
      + "\nThe field LemmaServiceSubGenerator.openApi refers to the missing type  */\n    OpenAPI"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nThe method createOperations(Microservice, String, PathItem) from the type LemmaServiceSubGenerator refers to the missing type PathItem"
      + "\ninfo cannot be resolved"
      + "\ntitle cannot be resolved"
      + "\ntags cannot be resolved"
      + "\n!== cannot be resolved"
      + "\ntags cannot be resolved"
      + "\nforEach cannot be resolved"
      + "\npaths cannot be resolved"
      + "\nforEach cannot be resolved");
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
  private void createOperations(final Microservice microservice, final String path, final /* PathItem */Object item) {
    throw new Error("Unresolved compilation problems:"
      + "\nservers cannot be resolved"
      + "\n!== cannot be resolved"
      + "\nparameters cannot be resolved"
      + "\n!== cannot be resolved"
      + "\ndelete cannot be resolved"
      + "\ntoLemmaOperation cannot be resolved"
      + "\nget cannot be resolved"
      + "\ntoLemmaOperation cannot be resolved"
      + "\nhead cannot be resolved"
      + "\ntoLemmaOperation cannot be resolved"
      + "\noptions cannot be resolved"
      + "\ntoLemmaOperation cannot be resolved"
      + "\npatch cannot be resolved"
      + "\ntoLemmaOperation cannot be resolved"
      + "\npost cannot be resolved"
      + "\ntoLemmaOperation cannot be resolved"
      + "\nput cannot be resolved"
      + "\ntoLemmaOperation cannot be resolved"
      + "\ntrace cannot be resolved"
      + "\ntoLemmaOperation cannot be resolved");
  }

  /**
   * Transform an OpenAPI operation to a LEMMA operation and add the operation to the
   * corresponding interface of the given LEMMA microservice
   */
  private boolean toLemmaOperation(final /* Operation */Object openApiOperation, final Microservice microservice, final String type, final String path) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method createLemmaOperation(String, String, Operation) from the type LemmaServiceSubGenerator refers to the missing type Operation"
      + "\ntags cannot be resolved"
      + "\nnullOrEmpty cannot be resolved"
      + "\n! cannot be resolved"
      + "\ntags cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Create a LEMMA Operation instances from the given HTTP verb, e.g., GET, PUT, or POST, the
   * given URI path, and OpenAPI Operation
   */
  private Operation createLemmaOperation(final String httpVerb, final String path, final /* Operation */Object openApiOperation) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method addRestEndpoint(Operation, String, Operation) from the type LemmaServiceSubGenerator refers to the missing type Operation"
      + "\nThe method addRestAspect(Operation, String, Operation) from the type LemmaServiceSubGenerator refers to the missing type Operation"
      + "\nThe method addComment(Operation, String, String, Operation) from the type LemmaServiceSubGenerator refers to the missing type Operation"
      + "\nThe method addParameters(Operation, Operation) from the type LemmaServiceSubGenerator refers to the missing type Operation"
      + "\noperationId cannot be resolved");
  }

  /**
   * Add a LEMMA Endpoint for the "rest" protocol from the OpenAPI technology model with the given
   * path to the given LEMMA Operation
   */
  private void addRestEndpoint(final Operation lemmaOperation, final String path, final /* Operation */Object openApiOperation) {
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
  private void addRestAspect(final Operation lemmaOperation, final String type, final /* Operation */Object openApiOperation) {
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
  private void addComment(final Operation lemmaOperation, final String httpVerb, final String path, final /* Operation */Object openApiOperation) {
    throw new Error("Unresolved compilation problems:"
      + "\nsummary cannot be resolved"
      + "\ndescription cannot be resolved");
  }

  /**
   * Derive LEMMA Parameters from the given OpenAPI Operation. According to OpenAPI 3.0.3, either
   * the "parameters" field is used as input for deriving the LEMMA Parameters or, in case the
   * HTTP method supports a body, the "requestBody" field is used (cf. RFC 7231).
   */
  private void addParameters(final Operation lemmaOperation, final /* Operation */Object openApiOperation) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method createLemmaInParameter(Parameter) from the type LemmaServiceSubGenerator refers to the missing type Parameter"
      + "\nThe method createLemmaInParameterFromMediaTypeValue(Schema) from the type LemmaServiceSubGenerator refers to the missing type Schema"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nThe method createLemmaOutParameter(ApiResponse) from the type LemmaServiceSubGenerator refers to the missing type ApiResponse"
      + "\nparameters cannot be resolved"
      + "\n!== cannot be resolved"
      + "\nparameters cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nrequestBody cannot be resolved"
      + "\n!== cannot be resolved"
      + "\nrequestBody cannot be resolved"
      + "\ncontent cannot be resolved"
      + "\n!== cannot be resolved"
      + "\nrequestBody cannot be resolved"
      + "\ncontent cannot be resolved"
      + "\nvalues cannot be resolved"
      + "\nget cannot be resolved"
      + "\nschema cannot be resolved"
      + "\nresponses cannot be resolved"
      + "\nforEach cannot be resolved");
  }

  /**
   * Create an incoming synchronous LEMMA Parameter from an OpenAPI Parameter
   */
  private Parameter createLemmaInParameter(final /* Parameter */Object openApiParameter) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method setPrimitiveOrArrayDataTypeFromSchema(Parameter, Schema) from the type LemmaServiceSubGenerator refers to the missing type Schema"
      + "\nname cannot be resolved"
      + "\ntoLowerCase cannot be resolved"
      + "\nrequired cannot be resolved"
      + "\n! cannot be resolved"
      + "\ncontent cannot be resolved"
      + "\n=== cannot be resolved"
      + "\nschema cannot be resolved"
      + "\nget$ref cannot be resolved"
      + "\nnullOrEmpty cannot be resolved"
      + "\n! cannot be resolved"
      + "\nget$ref cannot be resolved");
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
  private Parameter createLemmaInParameterFromMediaTypeValue(final /* Schema<?> */Object schema) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method setPrimitiveOrArrayDataTypeFromSchema(Parameter, Schema) from the type LemmaServiceSubGenerator refers to the missing type Schema"
      + "\nget$ref cannot be resolved"
      + "\nnullOrEmpty cannot be resolved"
      + "\n! cannot be resolved"
      + "\nget$ref cannot be resolved");
  }

  /**
   * Set the primitive or array type of the given LEMMA parameter based on the given OpenAPI
   * Schema
   */
  private void setPrimitiveOrArrayDataTypeFromSchema(final Parameter parameter, final /* Schema<?> */Object schema) {
    throw new Error("Unresolved compilation problems:"
      + "\nArraySchema cannot be resolved to a type."
      + "\nSchema cannot be resolved to a type."
      + "\nThe method getCollectionTypeName(ArraySchema) from the type LemmaDataSubGenerator refers to the missing type Object"
      + "\nThe method getOrCreateCollectionTypeFromSchema(ArraySchema) from the type LemmaServiceSubGenerator refers to the missing type ArraySchema"
      + "\nThe method setPrimitiveOrArrayDataTypeFromSchema(Parameter, Schema) from the type LemmaServiceSubGenerator refers to the missing type Schema"
      + "\ntype cannot be resolved"
      + "\nformat cannot be resolved"
      + "\nformat cannot be resolved"
      + "\nadditionalProperties cannot be resolved"
      + "\nformat cannot be resolved"
      + "\ntype cannot be resolved");
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
  private CollectionType getOrCreateCollectionTypeFromSchema(final /* ArraySchema */Object schema) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getCollectionTypeName(ArraySchema) from the type LemmaDataSubGenerator refers to the missing type Object"
      + "\nitems cannot be resolved"
      + "\ntype cannot be resolved"
      + "\nitems cannot be resolved"
      + "\nget$ref cannot be resolved"
      + "\ntype cannot be resolved");
  }

  /**
   * Create an outgoing synchronous LEMMA Parameter from the given OpenAPI ApiResponse
   */
  private Parameter createLemmaOutParameter(final /* ApiResponse */Object response) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method setPrimitiveOrArrayDataTypeFromSchema(Parameter, Schema) from the type LemmaServiceSubGenerator refers to the missing type Schema"
      + "\ncontent cannot be resolved"
      + "\nvalues cannot be resolved"
      + "\nget cannot be resolved"
      + "\nschema cannot be resolved"
      + "\nget$ref cannot be resolved"
      + "\nnullOrEmpty cannot be resolved"
      + "\n! cannot be resolved"
      + "\nget$ref cannot be resolved"
      + "\n!== cannot be resolved");
  }

  @Pure
  public ArrayList<String> getTransMsgs() {
    return this.transMsgs;
  }
}
