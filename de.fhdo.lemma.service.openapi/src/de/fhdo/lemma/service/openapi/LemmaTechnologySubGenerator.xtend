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
 * technology from an OpenAPI file in the JSON or YAML format.
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
     * Predefined instance of the TechnologyModel. This instance is populated with
     * the various technologies from the OpenAPI model, e.g., media types.
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
	 * Constructor for the TechnologySubGenerator. Sets up the generator by linking the
	 * given target location and the openapi model to process.
	 */
    new(OpenAPI api, String targetFile) {
        LOGGER.debug("Creating new Technology Sub Generator...")
        this.openApi = api
        this.targetFile = targetFile
    }

    /**
     * Entrypoint which starts the actual generation of a LEMMA technology model.
     * Writes the generated TechnologyModel to the hard drive as well as
     * returns the populated <strong>Technology</strong>.
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
     * Initially names the technology model as well as adds LEMMA primitive types and
     * technology aspects, including data formats, based off the
     * OpenAPI model (<strong>openApi</strong> class attribute).
     *
     * <i>Currently the generation of ResponseCodes and Operation Types are not supported.</i>
     */
    private def initialize() {
        technology.name = OpenApiUtil.removeInvalidCharsFromName(TECHNOLOGY_MODEL_NAME)
        technology.addPrimitiveTypes
        technology.addAspects
    }

    /**
     * Adds "rest" as a protocol to the technology model for OpenAPI.
     * Formats are added based on media types included in the given openapi specification.
     *
     * Default format is set if the given OpenAPI file comprises one.
     * Otherwise, the first encountered media type is set as default.
     */
    private def addRestProtocol(Technology technology) {
        // Create "rest" as the default OpenAPI protocol
        val rest = TECHNOLOGY_FACTORY.createProtocol
        rest.name = "rest"

        // Generate media types as data formats
        val mediaTypes = <String>newHashSet
        openApi.paths.forEach[path, pathSchema | mediaTypes.addAll(searchMediaTypes(pathSchema))]
        mediaTypes.forEach[type |
            val dataFormat = TECHNOLOGY_FACTORY.createDataFormat
            dataFormat.formatName = type
            rest.dataFormats.add(dataFormat)
        ]

		// If no format can be derived during processing, a placeholder is created.
		if(rest.dataFormats.isEmpty) {
			val emptyFormat = TECHNOLOGY_FACTORY.createDataFormat
			emptyFormat.formatName = "NO_FORMAT_ENCOUNTERED_DURING_PARSING"
			rest.dataFormats.add(emptyFormat)
		}

        // Set default format if the given OpenAPI file comprises it. Otherwise, the first
        // encountered media type is set as default.
        rest.defaultFormat = rest.dataFormats.findFirst[formatName == DEFAULT_DATA_FORMAT]
            ?: rest.dataFormats.get(0)

		//adding 'rest' to the technology model protocols
        technology.protocols.add(rest)
    }

    /**
     * Processes the requests and responses from the
     * given OpenAPI <strong>PathItem</strong> for media types.
     * Encountered media types are stored in a HashSet.
     * HashSet is returned.
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
     * Creates OpenApi data types corresponding to <italic>OpenApi v3.0.3 - Data Types</italic>.
     * OpenApi data type formats are represented as individual types.
     */
    private def void addPrimitiveTypes(Technology technology) {
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Integer", true,
            dataFactory.createPrimitiveInteger))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Int32", false,
            dataFactory.createPrimitiveInteger
        ))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Int64", true,
            dataFactory.createPrimitiveLong))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Number", true,
            dataFactory.createPrimitiveFloat))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Float", false,
            dataFactory.createPrimitiveFloat))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Double", true,
            dataFactory.createPrimitiveDouble))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("String", true,
            dataFactory.createPrimitiveString))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Byte", true,
            dataFactory.createPrimitiveByte))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Binary", false,
            dataFactory.createPrimitiveString))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Boolean", true,
            dataFactory.createPrimitiveBoolean))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Date", true,
            dataFactory.createPrimitiveDate))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("DateTime", false,
            dataFactory.createPrimitiveString))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Password", false,
            dataFactory.createPrimitiveString))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Unspecified", true,
            dataFactory.createPrimitiveUnspecified))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Short", true,
            dataFactory.createPrimitiveShort))
        technology.primitiveTypes.add(createTechnologySpecificPrimitiveType("Char", true,
            dataFactory.createPrimitiveCharacter))
    }

    /**
     * Helper method to create and return a LEMMA <strong>TechnologySpecificPrimitiveType</strong>.
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
     * Create default aspects for HTTP-based communication,
     * i.e., request methods and response codes
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
     * Creates a LEMMA <code>ServiceAspect</code>
     * for <code>JointPointType.OPERATIONS</code> with the given name.
     */
    private def createOperationsAspect(String name) {
        val aspect = TECHNOLOGY_FACTORY.createServiceAspect
        aspect.name = name
        aspect.joinPoints.add(JoinPointType.OPERATIONS)
        aspect.features.add(AspectFeature.SINGLE_VALUED)
        return aspect
    }


    /**
     * Creates a LEMMA <code>ServiceAspect</code>
     * for <code>JointPointType.PARAMETERS</code> with the given name.
     */
    private def createParametersAspect(String name) {
        val aspect = TECHNOLOGY_FACTORY.createServiceAspect
        aspect.name = name
        aspect.joinPoints.add(JoinPointType.PARAMETERS)
        aspect.features.add(AspectFeature.SINGLE_VALUED)
        return aspect
    }
}