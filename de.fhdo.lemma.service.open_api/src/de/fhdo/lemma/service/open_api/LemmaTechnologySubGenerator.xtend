package de.fhdo.lemma.service.open_api

import io.swagger.v3.oas.models.OpenAPI
import de.fhdo.lemma.technology.TechnologyFactory
import de.fhdo.lemma.technology.Technology
import org.slf4j.LoggerFactory
import de.fhdo.lemma.data.DataFactory
import de.fhdo.lemma.technology.JoinPointType
import de.fhdo.lemma.technology.AspectFeature
import de.fhdo.lemma.data.PrimitiveType
import de.fhdo.lemma.technology.TechnologySpecificPrimitiveType
import io.swagger.v3.oas.models.PathItem
import io.swagger.v3.oas.models.Operation
import java.util.Set
import de.fhdo.lemma.technology.ServiceAspect


/**
 * This class is responsible for handling the generation of a LEMMA technology model for the OpenAPI
 * technology from an OpenAPI file in the JSON or YAML format.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class LemmaTechnologySubGenerator {
    /** Factory to actually create and manipulate a LEMMA Technology */
    val TECHNOLOGY_FACTORY = TechnologyFactory.eINSTANCE
    /** Factory to actually create and manipulate a LEMMA DataModel */
    val DATA_FACTORY = DataFactory.eINSTANCE
    /** Predefined instance of the <strong>TechnologyModel</strong>. This instance is populated
     * with the various technologies from the OpenAPI model, e.g., media types.
     */
    val myTechModel = TECHNOLOGY_FACTORY.createTechnology
    /** OpenAPI schema which will be used as source for generation. */
    OpenAPI openApi
    /** SLF4j Logger */
    val static logger = LoggerFactory.getLogger(LemmaServiceSubGenerator);
    /** Location where the generated file is written */
    String targetFolder
    /** List of all unique media types. */
    val mediaTypes = <String>newHashSet

    new(OpenAPI api, String genPath, String techFilename) {
        super()
        logger.debug("Creating new Technology Sub Generator...")
        this.openApi = api
        this.targetFolder = genPath + techFilename
    }

    def Technology generate() {
        logger.debug("Starting generation...")
        logger.debug("Initializing model instance...")
        initilize()
        logger.debug("...Technology Model initialized!")
        logger.debug("Creating protocols...")
        createProtocols()
        logger.debug("...Data Structures created!")

        if (OpenApiUtil.writeModel(myTechModel, targetFolder)) {
            logger.info("Technology model generation successful!")
            logger.info('''Model written to «targetFolder»''')
        } else
            throw new Exception("Technology model generation failed :(")
        return myTechModel
    }

    def createProtocols() {
        //creates "rest" as the default openapi protocol
        val rest = TECHNOLOGY_FACTORY.createProtocol
        rest.name = "rest"
        openApi.paths.forEach[path, pathSchema|searchMediaTimes(pathSchema)]
        mediaTypes.forEach [ type |
            val df = TECHNOLOGY_FACTORY.createDataFormat
            df.formatName = type
            rest.dataFormats.add(df)
        ]
        //Sets "application/json" as default format if the OpenAPI desc entails it at all.
        // If not, the first encountered media type is set as default.
        rest.defaultFormat = rest.dataFormats.findFirst[
            it.formatName.equals("application/json")
        ] ?: rest.dataFormats.get(0)
        myTechModel.protocols.add(rest)
    }

    def searchMediaTimes(PathItem item) {
        val httpVerbList = <Operation>newArrayList
        httpVerbList.addAll(item.get, item.delete, item.put,
            item.post, item.patch, item.head, item.options
        )
        httpVerbList.forEach [ verb |
            if (verb !== null) {
                // Getting MediaTypes from responses
                verb.responses?.forEach[
                    responseCode, responseSchema|addToMediaTypes(responseSchema?.content?.keySet)
                ]
                // Getting MediaTypes from requests
                addToMediaTypes(verb.requestBody?.content?.keySet)
            }

        ]
    }

    def addToMediaTypes(Set<String> strings) {
        if (strings !== null) {
            strings.forEach[mediaType|mediaTypes.add(mediaType)]
        }
    }

    def initilize() {
        myTechModel.name = OpenApiUtil.removeInvalidCharsFromName("OpenApi")
        // Adding Primitive Types for OpenApi Technology
        myTechModel.initPrimitives
        myTechModel.initAspects
        // TODO ResponseCodes, Operation Types, Formats
    }

    /** Creates Default Aspects for HTTP-based communication,
     * i.e., request methods and response codes.
     */
    def void initAspects(Technology technology) {
        val httpVerbs = <ServiceAspect>newArrayList
        httpVerbs.add("GetMapping".createServiceAspect)
        httpVerbs.add("PutMapping".createServiceAspect)
        httpVerbs.add("PostMapping".createServiceAspect)
        httpVerbs.add("DeleteMapping".createServiceAspect)
        httpVerbs.add("OptionsMapping".createServiceAspect)
        httpVerbs.add("HeadMapping".createServiceAspect)
        httpVerbs.add("PatchMapping".createServiceAspect)
        httpVerbs.add("TraceMapping".createServiceAspect)
        httpVerbs.add("Unspecified".createServiceAspect)
        myTechModel.serviceAspects.addAll(httpVerbs)
        myTechModel.serviceAspects.add("RequestBody".createParameterAspect)
    }

    def ServiceAspect createServiceAspect(String name) {
        val ret = TECHNOLOGY_FACTORY.createServiceAspect
        ret.name = name
        ret.joinPoints.add(JoinPointType.OPERATIONS)
        ret.features.add(AspectFeature.SINGLE_VALUED)
        return ret
    }

    def ServiceAspect createParameterAspect(String name) {
        val ret = TECHNOLOGY_FACTORY.createServiceAspect
        ret.name = name
        ret.joinPoints.add(JoinPointType.PARAMETERS)
        ret.features.add(AspectFeature.SINGLE_VALUED)
        return ret
    }
    /** Creates OpenApi data types corresponding to <italic>OpenApi v3.0.3 - Data Types</italic>.
     * OpenApi data type formats are represented as individual types.
     */
    def void initPrimitives(Technology technology) {
        val primTypes = <TechnologySpecificPrimitiveType>newArrayList

        primTypes.add(createPrimitive("Integer", true, DATA_FACTORY.createPrimitiveInteger))
        primTypes.add(createPrimitive("Int32", false, DATA_FACTORY.createPrimitiveInteger))
        primTypes.add(createPrimitive("Int64", true, DATA_FACTORY.createPrimitiveLong))
        primTypes.add(createPrimitive("Number", true, DATA_FACTORY.createPrimitiveFloat))
        primTypes.add(createPrimitive("Float", false, DATA_FACTORY.createPrimitiveFloat))
        primTypes.add(createPrimitive("Double", true, DATA_FACTORY.createPrimitiveDouble))
        primTypes.add(createPrimitive("String", true, DATA_FACTORY.createPrimitiveString))
        primTypes.add(createPrimitive("Byte", true, DATA_FACTORY.createPrimitiveByte))
        primTypes.add(createPrimitive("Binary", false, DATA_FACTORY.createPrimitiveString))
        primTypes.add(createPrimitive("Boolean", true, DATA_FACTORY.createPrimitiveBoolean))
        primTypes.add(createPrimitive("Date", true, DATA_FACTORY.createPrimitiveDate))
        primTypes.add(createPrimitive("DateTime", false, DATA_FACTORY.createPrimitiveString))
        primTypes.add(createPrimitive("Password", false, DATA_FACTORY.createPrimitiveString))
        primTypes.add(createPrimitive("Unspecified", true, DATA_FACTORY.createPrimitiveUnspecified))
        // Because LEMMA needs default values short and char are added.
        // However, OpenAPI v3.0.3 does not specifically describe these.
        primTypes.add(createPrimitive("Short", true, DATA_FACTORY.createPrimitiveShort))
        primTypes.add(createPrimitive("Char", true, DATA_FACTORY.createPrimitiveCharacter))

        technology.primitiveTypes.addAll(primTypes)
    }

    def TechnologySpecificPrimitiveType createPrimitive(
        String name,
        boolean ^default,
        PrimitiveType type
    ) {
        val ret = TECHNOLOGY_FACTORY.createTechnologySpecificPrimitiveType
        ret.name = name
        ret.^default = ^default
        ret.basicBuiltinPrimitiveTypes.add(type)
        return ret
    }

}
