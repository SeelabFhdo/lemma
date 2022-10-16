package de.fhdo.lemma.service.openapi

import io.swagger.v3.oas.models.OpenAPI
import de.fhdo.lemma.technology.TechnologyFactory
import de.fhdo.lemma.technology.Technology
import org.slf4j.LoggerFactory
import de.fhdo.lemma.data.DataFactory
import de.fhdo.lemma.technology.JoinPointType
import de.fhdo.lemma.technology.AspectFeature
import de.fhdo.lemma.data.PrimitiveType
import io.swagger.v3.oas.models.PathItem
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.HashSet

/**
 * This class is responsible for handling the generation of a LEMMA technology model for the OpenAPI
 * technology from an OpenAPI specification file in the JSON or YAML format.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class LemmaTechnologySubGenerator {
    public static val HTTP_DELETE_ASPECT_NAME = "DeleteMapping"
    public static val HTTP_GET_ASPECT_NAME = "GetMapping"
    public static val HTTP_HEAD_ASPECT_NAME = "HeadMapping"
    public static val HTTP_OPTIONS_ASPECT_NAME = "OptionsMapping"
    public static val HTTP_PATCH_ASPECT_NAME = "PatchMapping"
    public static val HTTP_POST_ASPECT_NAME = "PostMapping"
    public static val HTTP_PUT_ASPECT_NAME = "PutMapping"
    public static val HTTP_REQUEST_BODY_ASPECT_NAME = "RequestBody"
    public static val HTTP_TRACE_ASPECT_NAME = "TraceMapping"
    public static val UNSPECIFIED_ASPECT_NAME = "Unspecified"

    public static val TECHNOLOGY_MODEL_NAME = "OpenApi"

    static val DEFAULT_DATA_FORMAT = "application/json"

    /* SLF4j LOGGER */
    static val LOGGER = LoggerFactory.getLogger(LemmaTechnologySubGenerator)

    /* Factory to actually create and manipulate a LEMMA Technology */
    val TECHNOLOGY_FACTORY = TechnologyFactory.eINSTANCE

    /* Factory to actually create and manipulate a LEMMA DataModel */
    val dataFactory = DataFactory.eINSTANCE

    /*
     * Predefined instance of the TechnologyModel. This instance is populated with technology
     * information relevant to OpenAPI, e.g., media types.
     */
    val technology = TECHNOLOGY_FACTORY.createTechnology

    /* OpenAPI schema which will be used as source for generation */
    OpenAPI openApi

    /* Log of all encountered exceptions during the data transformation */
    @Accessors(PUBLIC_GETTER)
    val transMsgs = <String>newArrayList

    /* Location where the generated file is written */
    String targetFile


    /**
     * Constructor
     */
    new(OpenAPI api, String targetFile) {
        LOGGER.debug("Creating new Technology Sub Generator...")
        this.openApi = api
        this.targetFile = targetFile
    }

    /**
     * Generate the LEMMA technology model for OpenAPI. This method returns the created model
     * instance and also serializes it to the user's harddrive.
     */
    def Technology generate() {
        LOGGER.debug("Initializing model instance...")
        initialize()
        LOGGER.debug("... technology model initialized")

        LOGGER.debug("Creating protocols...")
        technology.addRestProtocol()
        LOGGER.debug("... protocols created")

        if (OpenApiUtil.writeModel(technology, targetFile)) {
            LOGGER.info("Technology model generation successful")
            LOGGER.info('''Model written to «targetFile»''')
        } else
            throw new Exception("Generated technology model could not be written to hard disk")

        return technology
    }

    /**
     * Initialize the technology model instance
     */
    private def initialize() {
        technology.name = OpenApiUtil.removeInvalidCharsFromName(TECHNOLOGY_MODEL_NAME)
        technology.addPrimitiveTypes
        technology.addAspects
    }

    /**
     * Add "rest" protocol to the technology model and derive the protocol's data formats from the
     * media types of the given OpenAPI specification. The default format will be JSON if the
     * specification comprises it, otherwise the format derived from the first defined media type
     * will be set as default.
     */
    private def addRestProtocol(Technology technology) {
        /* Create "rest" as the default OpenAPI protocol */
        val rest = TECHNOLOGY_FACTORY.createProtocol
        rest.name = "rest"

        /* Generate media types as data formats */
        val mediaTypes = <String>newHashSet
        openApi.paths.forEach[path, pathSchema | mediaTypes.addAll(searchMediaTypes(pathSchema))]
        mediaTypes.forEach[type |
            val dataFormat = TECHNOLOGY_FACTORY.createDataFormat
            dataFormat.formatName = type
            rest.dataFormats.add(dataFormat)
        ]

        // Create a dummy data format in none could be derived from the media types
        if (rest.dataFormats.isEmpty) {
            val emptyFormat = TECHNOLOGY_FACTORY.createDataFormat
            emptyFormat.formatName = "NO_FORMAT_ENCOUNTERED_DURING_PARSING"
            rest.dataFormats.add(emptyFormat)
        }

        // Set default format if the given OpenAPI file comprises it. Otherwise, the first
        // encountered media type is set as default.
        rest.defaultFormat = rest.dataFormats.findFirst[formatName == DEFAULT_DATA_FORMAT]
            ?: rest.dataFormats.get(0)

        /* Add "rest" protocol to technology model */
        technology.protocols.add(rest)
    }

    /**
     * Search media types in the requests and responses of the OpenAPI specification
     */
    private def HashSet<String> searchMediaTypes(PathItem item) {
        val httpVerbs = newArrayList(item.delete, item.get, item.head, item.options, item.patch,
            item.post, item.put).filterNull

        val mediaTypes = <String>newHashSet
        httpVerbs.forEach [verb |
            // Get media types from requests
            if (verb.requestBody?.content !== null)
                mediaTypes.addAll(verb.requestBody.content.keySet)

            // Get media types from responses
            verb.responses?.forEach[responseCode, responseSchema |
                if (responseSchema?.content !== null)
                    mediaTypes.addAll(responseSchema.content.keySet)
            ]
        ]
        return mediaTypes
    }

    /**
     * Add primitive types to the given LEMMA technology model following the OpenAPI 3.0.3
     * specification
     */
    private def void addPrimitiveTypes(Technology technology) {
        // Note that OpenAPI doesn't support LEMMA's short and char primitive types. However,
        // LEMMA's Technology Modeling Language requires default type mappings for none or all
        // built-in primitive types. Thus, we have to add those types to the OpenAPI technology
        // model.
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Binary", false,
            dataFactory.createPrimitiveString))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Boolean", true,
            dataFactory.createPrimitiveBoolean))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Byte", true,
            dataFactory.createPrimitiveByte))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Char", true,
            dataFactory.createPrimitiveCharacter))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Date", true,
            dataFactory.createPrimitiveDate))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("DateTime", false,
            dataFactory.createPrimitiveString))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Double", true,
            dataFactory.createPrimitiveDouble))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Float", false,
            dataFactory.createPrimitiveFloat))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Int32", false,
            dataFactory.createPrimitiveInteger))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Int64", true,
            dataFactory.createPrimitiveLong))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Integer", true,
            dataFactory.createPrimitiveInteger))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Number", true,
            dataFactory.createPrimitiveFloat))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Password", false,
            dataFactory.createPrimitiveString))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Short", true,
            dataFactory.createPrimitiveShort))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("String", true,
            dataFactory.createPrimitiveString))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Unspecified", true,
            dataFactory.createPrimitiveUnspecified))
    }

    /**
     * Helper method to create a technology specific LEMMA type
     */
    private def createTechnologySpecificPrimitiveType(String name, boolean ^default,
        PrimitiveType baseType) {
        val type = TECHNOLOGY_FACTORY.createTechnologySpecificPrimitiveType
        type.name = name
        type.^default = ^default
        type.basicBuiltinPrimitiveTypes.add(baseType)
        return type
    }

    /**
     * Add OpenAPI-related aspects to the technology model
     */
    private def void addAspects(Technology technology) {
        technology.serviceAspects.add(HTTP_DELETE_ASPECT_NAME.createOperationsAspect)
        technology.serviceAspects.add(HTTP_GET_ASPECT_NAME.createOperationsAspect)
        technology.serviceAspects.add(HTTP_HEAD_ASPECT_NAME.createOperationsAspect)
        technology.serviceAspects.add(HTTP_OPTIONS_ASPECT_NAME.createOperationsAspect)
        technology.serviceAspects.add(HTTP_PATCH_ASPECT_NAME.createOperationsAspect)
        technology.serviceAspects.add(HTTP_POST_ASPECT_NAME.createOperationsAspect)
        technology.serviceAspects.add(HTTP_PUT_ASPECT_NAME.createOperationsAspect)
        technology.serviceAspects.add(HTTP_REQUEST_BODY_ASPECT_NAME.createParametersAspect)
        technology.serviceAspects.add(HTTP_TRACE_ASPECT_NAME.createOperationsAspect)
        technology.serviceAspects.add(UNSPECIFIED_ASPECT_NAME.createOperationsAspect)
    }

    /**
     * Create a single-valued LEMMA service aspect with microservice operations as join point type
     */
    private def createOperationsAspect(String name) {
        val aspect = TECHNOLOGY_FACTORY.createServiceAspect
        aspect.name = name
        aspect.joinPoints.add(JoinPointType.OPERATIONS)
        aspect.features.add(AspectFeature.SINGLE_VALUED)
        return aspect
    }


    /**
     * Create a single-valued LEMMA service aspect with microservice operation parameters as join
     * point type
     */
    private def createParametersAspect(String name) {
        val aspect = TECHNOLOGY_FACTORY.createServiceAspect
        aspect.name = name
        aspect.joinPoints.add(JoinPointType.PARAMETERS)
        aspect.features.add(AspectFeature.SINGLE_VALUED)
        return aspect
    }
}