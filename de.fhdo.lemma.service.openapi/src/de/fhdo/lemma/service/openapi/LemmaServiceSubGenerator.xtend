package de.fhdo.lemma.service.openapi

import de.fhdo.lemma.data.DataFactory
import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.service.ImportType
import de.fhdo.lemma.service.Microservice
import de.fhdo.lemma.service.MicroserviceType
import de.fhdo.lemma.service.ServiceFactory
import de.fhdo.lemma.service.Visibility
import de.fhdo.lemma.technology.CommunicationType
import de.fhdo.lemma.technology.ExchangePattern
import de.fhdo.lemma.technology.Technology
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.Operation
import io.swagger.v3.oas.models.PathItem
import io.swagger.v3.oas.models.media.ArraySchema
import io.swagger.v3.oas.models.media.Schema
import io.swagger.v3.oas.models.parameters.Parameter
import io.swagger.v3.oas.models.responses.ApiResponse
import org.slf4j.LoggerFactory
import org.eclipse.xtend.lib.annotations.Accessors
import java.io.File
import java.nio.file.Paths

import static de.fhdo.lemma.service.openapi.LemmaTechnologySubGenerator.*

/**
 * This class is responsible for handling the generation of a LEMMA service model from an OpenAPI
 * file in the JSON or YAML format.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class LemmaServiceSubGenerator {
    /* Default name if no tags are encountered in the OpenAPI description */
    static val DEFAULT_INTERFACE_NAME = "defaultInterface"

    static val HTTP_METHOD_TO_ASPECT = #{
        "DELETE" -> HTTP_DELETE_ASPECT_NAME,
        "GET" -> HTTP_GET_ASPECT_NAME,
        "HEAD" -> HTTP_HEAD_ASPECT_NAME,
        "OPTIONS" -> HTTP_OPTIONS_ASPECT_NAME,
        "PATCH" -> HTTP_PATCH_ASPECT_NAME,
        "POST" -> HTTP_POST_ASPECT_NAME,
        "PUT" -> HTTP_PUT_ASPECT_NAME,
        "TRACE" -> HTTP_TRACE_ASPECT_NAME
    }

    /* SLF4j LOGGER */
    static val LOGGER = LoggerFactory.getLogger(LemmaTechnologySubGenerator)

    /* Name of the protocol which is used as default for endpoint generation */
    static val REST_PROTOCOL = "rest"

    /* Factory to actually create and manipulate a LEMMA DataModel */
    val dataFactory = DataFactory.eINSTANCE

    /* Factory to actually create and manipulate a LEMMA ServiceModel */
    val serviceFactory = ServiceFactory.eINSTANCE

    /*
     * Predefined instance of the <strong>ServiceModel</strong>. This instance is populated with the
     * various services and interfaces from the OpenAPI model. It is the central artifact which gets
     * serialized as a ".services" file.
     */
    val serviceModel = serviceFactory.createServiceModel

    /* OpenAPI schema which will be used as source for generation. */
    OpenAPI openApi

    /* Log of all encountered exceptions during the data transformation */
    @Accessors(PUBLIC_GETTER)
    val transMsgs = <String>newArrayList

    /*
     * Contains the previous generated OpenApi LEMMA DataModel which is handed over by the
     * LemmaGenerator
     */
    Pair<String, DataModel> dataModel

    /*
     * Contains the previous generated OpenApi LEMMA Technology which is handed over by the
     * LemmaGenerator
     */
    Pair<String, Technology> technology

    /* Location where the generated file is written */
    String targetFile

    String dataModelLoc

	/**
	 * Constructor for the ServiceSubGenerator. Sets up the generator by linking the
	 * given data and technology models because they are needed to be edited
	 * during generation.
	 */
    new(OpenAPI openApi, Pair<String, DataModel> dataModel,Pair<String, Technology> technology,
        String targetFile) {
        LOGGER.debug("Creating new Service Sub Generator...")
        this.openApi = openApi
        this.targetFile = targetFile
        this.dataModel = dataModel
        this.technology = technology
        dataModelLoc = Paths.get(new File(targetFile).parent, dataModel.key).toString
    }

    /**
     * Entrypoint which starts the actual generation of a LEMMA service model.
     * The last stage writes the generated ServiceModel to the hard drive
     * at the location given during instantiation (see constructor).
     */
    def generate(String servicePrefix) {
        LOGGER.debug("Adding data model import...")
        createDataImport(dataModel.key, dataModel.value)
        LOGGER.debug("... data model import added")

        LOGGER.debug("Adding technology import...")
        createTechnologyImport(technology.key, technology.value)
        LOGGER.debug("... technology import added")

        LOGGER.debug("Adding microservice...")
        val microserviceName = '''«servicePrefix».''' +
            OpenApiUtil.removeInvalidCharsFromName(openApi.info.title)
        val microservice = createFunctionalMicroservice(microserviceName)
        LOGGER.debug("... microservice added")

        LOGGER.debug("Adding interfaces...")
        if (openApi.tags !== null)
            openApi.tags.forEach[createInterface(microservice, name)]
        else
            createInterface(microservice, DEFAULT_INTERFACE_NAME)
        LOGGER.debug("... interfaces added")

        LOGGER.debug("Creating interface operations for each path item...")
        openApi.paths.forEach[key, value |
            try {
                createOperations(microservice, key, value)
            } catch (Exception ex) {
                transMsgs.add('''Error while creating operation «key». Operation is skipped. ''' +
                    "Please refer to the debug log for details.")
                LOGGER.debug(ex.message)
            }
        ]
        LOGGER.debug("... operations created")

        LOGGER.debug("... services created")

        if (OpenApiUtil.writeModel(serviceModel, targetFile)) {
            LOGGER.info("Service model generation successful")
            LOGGER.info('''Model written to «targetFile»''')
        } else
            throw new Exception("Generated service model could not be written to hard disk.")
    }

    /**
     * Creates and returns a data model Import based on the given <strong>uri</strong> and
     * <strong>model</strong>. The import is added to <italic>serviceModel</italic>.
     */
    private def createDataImport(String uri, DataModel model) {
        val dataImport = serviceFactory.createImport
        dataImport.importType = ImportType.DATATYPES
        dataImport.importURI = uri
        if(model.versions.get(0)?.contexts.get(0)?.name.isNullOrEmpty)
        	throw new Exception("Name of Data Model to be imported not set.")
        dataImport.name = model.versions.get(0)?.contexts.get(0)?.name.concat("Data")
        dataImport.serviceModel = serviceModel
        LOGGER.debug("Data model import added")
        return dataImport
    }

    /**
     * Creates and returns a technology Import based on the given <strong>uri</strong> and
     * <strong>model</strong>. The import is added to <italic>serviceModel</italic>.
     */
    private def createTechnologyImport(String uri, Technology technology) {
        val techImport = serviceFactory.createImport
        techImport.importType = ImportType.TECHNOLOGY
        techImport.importURI = uri
        techImport.name = technology.name
        techImport.serviceModel = serviceModel
        LOGGER.debug("Technology import added")
        return techImport
    }

    /**
     * Creates and returns a <strong>Microservice</strong> with the given <strong>name</strong>. The
     * service is added to <italic>serviceModel</italic>.
     */
    private def createFunctionalMicroservice(String name) {
        LOGGER.info('''Microservice name: «name»''')
        val functionalService = serviceFactory.createMicroservice
        functionalService.serviceModel = serviceModel
        functionalService.name = name
        functionalService.visibility = Visibility.PUBLIC
        functionalService.type = MicroserviceType.FUNCTIONAL
        serviceModel.microservices.add(functionalService)
        LOGGER.debug("Functional microservice added")
        return functionalService
    }

    /**
     * Creates and returns a new <strong>Interface</strong> with the given <strong>name</strong>. The
     * service is added to the given <strong>microservice</strong>.
     */
    private def createInterface(Microservice microservice, String name) {
        val interface = serviceFactory.createInterface
        interface.name = name
        interface.microservice = microservice
        microservice.interfaces.add(interface)
        return interface
    }

    /**
     * Triggers the creation of operations according to the given item.
     * Based on the item type (e.g. DELETE or GET) a transformation
     * to a corresponding LEMMA operation is triggered.
     */
    private def void createOperations(Microservice microservice, String path, PathItem item) {
        if (item.servers !== null)
            throw new UnsupportedOperationException("Servers operation currently not supported")
        else if (item.parameters !== null)
            throw new UnsupportedOperationException("Parameters operation currently not supported")

        item.delete?.toLemmaOperation(microservice, "DELETE", path)
        item.get?.toLemmaOperation(microservice, "GET", path)
        item.head?.toLemmaOperation(microservice, "HEAD", path)
        item.options?.toLemmaOperation(microservice, "OPTIONS", path)
        item.patch?.toLemmaOperation(microservice, "PATCH", path)
        item.post?.toLemmaOperation(microservice, "POST", path)
        item.put?.toLemmaOperation(microservice, "PUT", path)
        item.trace?.toLemmaOperation(microservice, "TRACE", path)
    }

    /**
     * Transforms an OpenAPI operation for a given microservice to a LEMMA operation.
     */
    private def toLemmaOperation(Operation openApiOperation, Microservice microservice, String type,
        String path) {
        val lemmaOperation = createLemmaOperation(type, path, openApiOperation)
        val tag = if (!openApiOperation.tags.nullOrEmpty)
                openApiOperation.tags.get(0)
            else
                DEFAULT_INTERFACE_NAME
        microservice.interfaces.findFirst[name == tag]?.operations.add(lemmaOperation)
    }

    /**
     * Creates and returns a LEMMA </strong>Operation</strong> based on the <strong>Type</strong>,
     * e.g., GET, PUT, or POST, the <strong>URI path</strong>, and the OpenAPI
     * <strong>Operation</strong>.
     */
    private def createLemmaOperation(String type, String path, Operation openApiOperation) {
        val lemmaOperation = serviceFactory.createOperation
        lemmaOperation.name = openApiOperation.operationId
        lemmaOperation.addRestEndpoint(type, path, openApiOperation)
        lemmaOperation.addRestAspect(type, openApiOperation)
        lemmaOperation.addComment(type, path, openApiOperation)
        lemmaOperation.addParameters(openApiOperation)
        return lemmaOperation
    }

    /**
     * Creates and adds an <strong>Endpoint</strong> with the given path and the rest protocol from
     * the technology model set in the constructor to the given lemmaOperation.
     */
    private def void addRestEndpoint(de.fhdo.lemma.service.Operation lemmaOperation, String type,
        String path, Operation openApiOperation) {
        val endpoint = serviceFactory.createEndpoint
        val protocol = serviceFactory.createImportedProtocolAndDataFormat
        // OpenAPI is a REST-focused specification. Thus, always use REST as protocol.
        protocol.importedProtocol = technology.value.protocols.findFirst[name == REST_PROTOCOL]
        endpoint.protocols.add(protocol)
        endpoint.addresses.add(path)
        lemmaOperation.endpoints.add(endpoint)
    }

    /**
     * Creates and adds an imported <strong>ServiceAspect</strong> from the technology model set
     * in the constructor to the given lemmaOperation.
     */
    private def void addRestAspect(de.fhdo.lemma.service.Operation lemmaOperation, String type,
        Operation openApiOperation) {
        val aspect = serviceFactory.createImportedServiceAspect
        aspect.importedAspect = if (HTTP_METHOD_TO_ASPECT.containsKey(type))
                technology.value.serviceAspects.findFirst[name == HTTP_METHOD_TO_ASPECT.get(type)]
            else
                technology.value.serviceAspects.findFirst[name == UNSPECIFIED_ASPECT_NAME]
        lemmaOperation.aspects.add(aspect)
    }

    /**
     * Adds an <strong>ApiOperationComment</strong> to a LEMMA operation based on type,
     * path, and description from the OpenAPI specification.
     */
    private def void addComment(de.fhdo.lemma.service.Operation lemmaOperation, String type,
        String path, Operation openApiOperation) {
        val comment = serviceFactory.createApiOperationComment
        comment.comment = '''
            **Type** «type» Operation for path «path»
            **Summary** «openApiOperation.summary»
            **Description** «openApiOperation.description»
        '''
        comment.operation = lemmaOperation
    }

    /**
     * Derive LEMMA Parameters from the given OpenAPI <strong>operation</strong>. According to
     * OpenAPI 3.0.3 either the <italic>parameters</italic> field is used as input for generating
     * the LEMMA Parameters or, in case the HTTP method supports a body, the
     * <italic>requestBody</italic> is used (cf. RFC 7231).
     */
    private def void addParameters(de.fhdo.lemma.service.Operation lemmaOperation,
        Operation openApiOperation) {
        if (openApiOperation.parameters !== null)
            lemmaOperation.parameters.addAll(
                openApiOperation.parameters.map[createLemmaInParameter(it)]
            )

        if (openApiOperation.requestBody !== null) {
            // Currently, only one media type is selected from the body because the JSON structure
            // comprises a type multiple times for different media types
            if(openApiOperation.requestBody.content !== null) {
	            val schema = openApiOperation.requestBody.content?.values.get(0).schema
	            lemmaOperation.parameters.add(createLemmaInParameterFromMediaTypeValue(schema))
            }
        }

        // Currently, only successful HTTP requests (return code 200) are supported as LEMMA OUT
        // parameters
        openApiOperation.responses?.forEach[key, value |
            if (key == "200")
                lemmaOperation.parameters.add(createLemmaOutParameter(value))
            else
                LOGGER.info('''Unsupported HTTP code: «key»''')
        ]
    }

    /**
     * Create and return a LEMMA <strong>Parameter</strong> from an OpenAPI
     * <strong>Parameter</strong>
     */
    private def createLemmaInParameter(Parameter openApiParameter) {
        val lemmaParameter = serviceFactory.createParameter
        lemmaParameter.communicationType = CommunicationType.SYNCHRONOUS
        lemmaParameter.exchangePattern = ExchangePattern.IN
        lemmaParameter.name = openApiParameter.name.toLowerCase
        lemmaParameter.optional = !openApiParameter.required

        val schema = if (openApiParameter.content === null) openApiParameter.schema else null

        if (!openApiParameter.get$ref.nullOrEmpty)
            lemmaParameter.importedType = createImportedComplexTypeFromRef(openApiParameter.get$ref)
        else
            lemmaParameter.setPrimitiveOrArrayDataTypeFromSchema(schema)

        return lemmaParameter
    }

    /**
     * Create and return a new <strong>ImportedType</strong> from a given OpenAPI
     * <strong>ref</strong> string
     */
    private def createImportedComplexTypeFromRef(String ref) {
        val importedType = serviceFactory.createImportedType
        importedType.import = serviceModel.imports.get(0)

        return try {
            importedType.type = findComplexTypeFromRef(ref)
            if (importedType.type !== null)
                importedType
            else
                null
        } catch (IllegalArgumentException ex) {
        	LOGGER.error('''Could not import complex data type from «ref»''')
            LOGGER.error(ex.message)
            null
        }
    }

    /**
     * Find a previously created <strong>ComplexType</strong> for the given OpenAPI
     * <strong>ref</strong> string from the data model. Throw a ComplexTypeException in case no
     * matching ComplexType was found.
     */
    private def findComplexTypeFromRef(String ref) {
        val parts = ref.split("/")
        if (parts.size < 4 && !ref.startsWith("#/components/schemas/"))
            throw new IllegalArgumentException('''Could not find matching type for «ref» in ''' +
                "data model")

        return dataModel.value.versions.get(0).contexts.get(0).complexTypes
            .findFirst[name == parts.get(3).toFirstUpper]
    }

    /**
     * Create and return a LEMMA <strong>Parameter</strong> based on an OpenAPI
     * <strong>Parameter</strong>
     */
    private def createLemmaInParameterFromMediaTypeValue(Schema<?> schema) {
        val lemmaParameter = serviceFactory.createParameter
        lemmaParameter.communicationType = CommunicationType.SYNCHRONOUS
        lemmaParameter.exchangePattern = ExchangePattern.IN
        lemmaParameter.name = "requestBody"
        lemmaParameter.optional = false

        // Assign RequestBody aspect
        val aspect = serviceFactory.createImportedServiceAspect
        aspect.importedAspect = technology.value.serviceAspects
            .findFirst[name == HTTP_REQUEST_BODY_ASPECT_NAME]
        lemmaParameter.aspects.add(aspect)

        // Set type
        if (!schema.get$ref.nullOrEmpty)
            lemmaParameter.importedType = createImportedComplexTypeFromRef(schema.get$ref)
        else
            lemmaParameter.setPrimitiveOrArrayDataTypeFromSchema(schema)

        return lemmaParameter
    }

    /**
     * Sets LEMMA parameter type based on the given OpenAPI schema.
     */
    private def void setPrimitiveOrArrayDataTypeFromSchema(
        de.fhdo.lemma.service.Parameter parameter,
        Schema<?> schema
    ) {
        switch (schema.type) {
            case "array": {
                // In this case the actual data model is altered and persisted again because the
                // data sub-generator does not scan for occurrences of array types in operations
                val arraySchema = schema as ArraySchema
                val existingType = createImportedComplexTypeFromDomainConcept(
                        LemmaDataSubGenerator.getCollectionTypeName(arraySchema)
                    )

                if (existingType !== null)
                    parameter.importedType = existingType
                else {
                    val collectionType = getOrCreateCollectionTypeFromSchema(arraySchema)
                    parameter.importedType
                        = createImportedComplexTypeFromDomainConcept(collectionType.name)
                }
            }

            case "boolean":
                parameter.primitiveType = dataFactory.createPrimitiveBoolean

            case "integer":
                parameter.primitiveType = OpenApiUtil.deriveIntType(schema.format)

            case "number":
                parameter.primitiveType = OpenApiUtil.deriveNumberType(schema.format)

            case "object": {
                parameter.setPrimitiveOrArrayDataTypeFromSchema(
                    schema.additionalProperties as Schema<?>
                )
            }

            case "string":
                parameter.primitiveType = OpenApiUtil.deriveStringType(schema.format)

            default:
                throw new IllegalArgumentException("Could not find matching type for " +
                    schema.type)
        }
    }

    /**
     * Creates and returns an <strong>ImportedType</strong> instance for a domain concept from the
     * data model.
     */
    private def createImportedComplexTypeFromDomainConcept(String domainConceptName) {
        val importedType = serviceFactory.createImportedType
        importedType.import = serviceModel.imports.get(0)
        importedType.type = dataModel.value.versions.get(0).contexts.get(0).complexTypes
            .findFirst[it.name.equals(name)]

        return if (importedType.type !== null)
            importedType
        else
            null
    }

    /**
     * Creates or retrieves a previously created <strong>CollectionType</strong>
     * from an OpenAPI ArraySchema.
     */
    private def getOrCreateCollectionTypeFromSchema(ArraySchema schema) {
        val collectionType = dataFactory.createCollectionType
        collectionType.name = LemmaDataSubGenerator.getCollectionTypeName(schema)

        switch (schema.items.type) {
            case "string":
                collectionType.primitiveType = dataFactory.createPrimitiveString

            case "integer":
                collectionType.primitiveType = dataFactory.createPrimitiveInteger

            case "number":
                collectionType.primitiveType = dataFactory.createPrimitiveFloat

            case "boolean":
                collectionType.primitiveType = dataFactory.createPrimitiveBoolean

            case null: {
                val field = dataFactory.createDataField
                field.complexType = findComplexTypeFromRef(schema.items.get$ref)
                field.name = field.complexType.name.toLowerCase
                collectionType.name = LemmaDataSubGenerator
                    .getCollectionTypeName(field.complexType.name)
                collectionType.dataFields.add(field)
            }

            default:
                throw new UnsupportedOperationException("Array type " +
                    '''«schema.type» is not supported''')
        }

        // Add new collection type to data model
        val complexTypes = dataModel.value.versions.get(0)?.contexts.get(0)?.complexTypes
        if (!complexTypes.exists[name == collectionType.name]) {
            complexTypes.add(collectionType)

            if (OpenApiUtil.writeModel(dataModel.value, dataModelLoc))
                LOGGER.info('''Data model «dataModelLoc» was successfully altered''')
            else
                throw new Exception('''Data model «dataModelLoc» could not be altered''')
        } else
            LOGGER.info('''Collection type «collectionType.name» already exists in data model''')

        return collectionType
    }

    /**
     * Creates a LEMMA <strong>Parameter</strong> with
     * exchange pattern OUT and communication type SYNCHRONOUS based on the given
     * OpenAPI <strong>ApiResponse</strong>.
     */
    private def createLemmaOutParameter(ApiResponse response) {
        val lemmaParameter = serviceFactory.createParameter
        lemmaParameter.communicationType = CommunicationType.SYNCHRONOUS
        lemmaParameter.exchangePattern = ExchangePattern.OUT
        lemmaParameter.name = "returnValue"
        lemmaParameter.optional = false

        val schema = response.content.values.get(0)?.schema
        if (!schema?.get$ref.nullOrEmpty)
            lemmaParameter.importedType = createImportedComplexTypeFromRef(schema.get$ref)
        else if (schema !== null)
            lemmaParameter.setPrimitiveOrArrayDataTypeFromSchema(schema)
        else
            // OpenAPI response contains only examples but no actual schemas
            lemmaParameter.primitiveType = dataFactory.createPrimitiveUnspecified

        return lemmaParameter
    }
}
