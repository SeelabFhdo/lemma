package de.fhdo.lemma.service.openapi

import de.fhdo.lemma.data.ComplexType
import de.fhdo.lemma.data.DataFactory
import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.data.ListType
import de.fhdo.lemma.service.Import
import de.fhdo.lemma.service.ImportType
import de.fhdo.lemma.service.ImportedType
import de.fhdo.lemma.service.Interface
import de.fhdo.lemma.service.Microservice
import de.fhdo.lemma.service.MicroserviceType
import de.fhdo.lemma.service.ServiceFactory
import de.fhdo.lemma.service.Visibility
import de.fhdo.lemma.service.openapi.exceptions.ComplexTypeException
import de.fhdo.lemma.service.openapi.exceptions.MatchingException
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
import java.util.ArrayList
import org.apache.commons.lang3.StringUtils
import org.slf4j.LoggerFactory
import org.apache.commons.lang3.NotImplementedException
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * This class is responsible for handling the generation of a LEMMA service model from an
 * OpenAPI file in the JSON or YAML format.
 * It depends on previous execution of the LemmaDataSubGenerator.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class LemmaServiceSubGenerator {
    /** Factory to actually create and manipulate a LEMMA DataModel */
    val SERVICE_FACTORY = ServiceFactory.eINSTANCE
    /** Factory to actually create and manipulate a LEMMA DataModel */
    val DATA_FACTORY = DataFactory.eINSTANCE
    /** Predefined instance of the <strong>ServiceModel</strong>. This instance is populated
     * with the various services and interfaces from the OpenAPI model. It is the central artifact
     * which gets serialized as an <italic>.services</italic> file.
     */
    val myServiceModel = SERVICE_FACTORY.createServiceModel

    /** Name of the protocol which is used as default for endpoint generation */
    val DEFAULT_PROTOCOL = "rest"
    /** OpenAPI schema which will be used as source for generation. */
    OpenAPI openAPI

    /** Log of all encountered exceptions during the data transformation */
    @Accessors(PUBLIC_GETTER) val transMsgs = <String>newArrayList

    /** SLF4j Logger */
    val static logger = LoggerFactory.getLogger(LemmaServiceSubGenerator);
    /** Contains the previous generated OpenApi <italic>LEMMA Data Model</italic>
     * which is handed over by the LemmaGenerator
     */
    Pair<String, DataModel> dataModel
    /** Contains the previous generated OpenApi <italic>LEMMA Tech Model</italic>
     * which is handed over by the LemmaGenerator
     */
    Pair<String, Technology> techModel
    String targetFolder
    /** Default name if no tags are encountered in the OpenAPI description */
    val defaultName = "defaultInterface"

    String dataModelLoc

    new(OpenAPI openAPI, Pair<String, DataModel> dataModel,Pair<String, Technology> techModel,
        String genPath, String serviceFilename) {
        super()
        logger.debug("Creating new Service Sub Generator...")
        this.openAPI = openAPI
        this.targetFolder = genPath + serviceFilename
        this.dataModel = dataModel
        this.techModel = techModel
        this.dataModelLoc = genPath + dataModel.key
    }

    def generate(String servicePrefix) {
        logger.debug("Starting generation...")
        logger.debug("Adding data model import...")
        createDataImport(dataModel.key, dataModel.value)
        logger.debug("Adding technology import...")
        createTechnologyImport(techModel.key, techModel.value)
        logger.debug("Adding microservice...")
        val myMicroservice = createFunctionalMicroservice(
            '''«servicePrefix».«OpenApiUtil.removeInvalidCharsFromName(openAPI.info.title)»''')
        logger.debug("Adding interfaces...")
        val interfaces = <Interface>newArrayList
        openAPI.tags?.forEach[tag|
            try {
                interfaces?.add(createInterface(myMicroservice, tag.name))
            } catch (Exception e) {
                transMsgs.add(
                    '''Error while creating interface «tag». Interface is skipped.
                    For details access debug log.''')
                logger.debug(e.message)
            }
        ]
        // If no interfaces can be generated from tags create a default Interface
        if (interfaces.size == 0) {
            interfaces.add(createInterface(myMicroservice, defaultName))
        }
        logger.debug("Creating interface operations for each path item...")
        openAPI.paths.forEach[key, value|
            try {
                createOperations(interfaces, key, value)
            } catch (Exception e) {
                transMsgs.add(
                    '''Error while creating operation «key». Operation is skipped.
                    For details access debug log.''')
                logger.debug(e.message)
            }
        ]
        logger.debug("...Services created!")
        if (OpenApiUtil.writeModel(myServiceModel, targetFolder)) {
            logger.info("Service model generation successful!")
            logger.info('''Model written to «targetFolder»''')
        } else
            logger.info("Service model generation failed. See debug for more info.")
    }

    def ArrayList<Interface> createOperations(
        ArrayList<Interface> interfaces,
        String path,
        PathItem item
    ) {
        item.get?.addOperation(interfaces, "GET", path)
        item.put?.addOperation(interfaces, "PUT", path)
        item.post?.addOperation(interfaces, "POST", path)
        item.delete?.addOperation(interfaces, "DELETE", path)
        item.options?.addOperation(interfaces, "OPTIONS", path)
        item.head?.addOperation(interfaces, "HEAD", path)
        item.patch?.addOperation(interfaces, "PATCH", path)
        item.trace?.addOperation(interfaces, "TRACE", path)
        if (item.servers !== null)
            throw new UnsupportedOperationException("Servers Operation currently not supported")
        if (item.parameters !== null)
            throw new UnsupportedOperationException("Parameters Operation currently not supported")
        return interfaces
    }

    def addOperation(Operation swop, ArrayList<Interface> interfaces, String type, String path) {
        val newOp = createLemmaOperation(type, path, swop)
        val tag = if(!swop.tags.isNullOrEmpty) swop.tags.get(0) else defaultName
        interfaces.findFirst[it.name == (tag)]?.operations.add(newOp)
    }

    /** Creates and returns a <strong>Lemma Operation</strong> based on
     * the <strong>Type</strong>, e.g., GET, PUT, or POST, the <strong>URI path</strong>,
     * and the <strong>Swagger Operation</strong>.
     * The import is added to <italic>myServiceModel</italic>
     */
    def de.fhdo.lemma.service.Operation createLemmaOperation(
        String type, String path, Operation swop
    ) {
        val lemmaOp = SERVICE_FACTORY.createOperation
        lemmaOp.name = swop.operationId
        lemmaOp.CreateEndpoints(type, path, swop)
        lemmaOp.CreateRestAspect(type, swop)
        lemmaOp.createCommentary(type, path, swop)
        lemmaOp.createParameters(swop)
        return lemmaOp
    }

    /** Iterates through the given Swagger <strong>operation</strong> returns a list of Lemma
     * Parameters. According to the Swagger Spec 3.0.2 either the <italic>parameters</italic> field
     * is used as input for generating the Lemma Parameters or, only when the HTTP methods
     * support a body, the <italic>requestBody</italic> (compare RFC7231).
     */
    def void createParameters(de.fhdo.lemma.service.Operation operation, Operation swop) {
        val lemmaParams = <de.fhdo.lemma.service.Parameter>newArrayList

        // IN Parameters
        // If the parameter is a PATH Parameter
        if (swop.parameters !== null) {
            swop.parameters?.forEach [
                val lemmaParam = createLemmaInParameter(it as Parameter)
                lemmaParams.add(lemmaParam)
            ]
        }
        // If the parameter is a Body Parameter
        if (swop.requestBody !== null) {
            // Currently only one MediaType is selected from the Body
            // because the json structure comprises a type multiple times
            // for different media types
            val outSchema = swop.requestBody.content?.values.get(0).schema
            val lemmaParam = createLemmaInParameterFromMediaTypeValue(outSchema)
            lemmaParams.add(lemmaParam)
        }
        // OUT Parameters
        // Currently only successful http requests are support, i.e. HTTP Code 200
        if (swop.responses !== null) {
            swop.responses?.forEach [ key, value |
                if (key.equals("200")) {
                    val lemmaParam = createLemmaOutParameter(value as ApiResponse)
                    lemmaParams.add(lemmaParam)
                } else {
                    logger.info('''Unsupported HTTP Code found: «key»''')
                }
            ]
        }
        operation.parameters.addAll(lemmaParams)
    }

    /** Creates and returns a <strong>Lemma Parameter</strong> based on
     * a <strong>Swagger Parameter</strong>. This method uses <italic>dataModels</italic> to
     * add complex data types.
     */
    def de.fhdo.lemma.service.Parameter createLemmaInParameterFromMediaTypeValue(Schema schema) {
        var newLemmaParam = SERVICE_FACTORY.createParameter
        newLemmaParam.name = StringUtils.uncapitalize("requestBody")
        // In case a bodyRequest parameter is encountered it is always required
        newLemmaParam.optional = false
        newLemmaParam.exchangePattern = ExchangePattern.IN
        //setting the requestBody aspect
        val aspect = SERVICE_FACTORY.createImportedServiceAspect
        aspect.importedAspect = techModel.value.serviceAspects.iterator.findFirst[
            it.name.equals("RequestBody")
        ]
        newLemmaParam.aspects.add(aspect)
        // select proper type
        if (!schema.get$ref.isNullOrEmpty)
            newLemmaParam.importedType = getImportedComplexDataTypeFromRef(schema.get$ref)
        else
            newLemmaParam = newLemmaParam.getPrimitiveOrArrayDataTypeFromSchema(schema)
        return newLemmaParam
    }

    def de.fhdo.lemma.service.Parameter createLemmaOutParameter(ApiResponse response) {
        var newLemmaParam = SERVICE_FACTORY.createParameter
        newLemmaParam.exchangePattern = ExchangePattern.OUT
        newLemmaParam.communicationType = CommunicationType.SYNCHRONOUS
        newLemmaParam.optional = false
        // OpenAPI does not specify names for responses
        newLemmaParam.name = StringUtils.uncapitalize("returnValue")
        // Currently only takes one of all the described mediatypes
        val responseSchema = response.content.values.get(0)
        if(responseSchema.schema === null) {
            //happens when the OpenAPI response only contains examples but no actual schemas
            newLemmaParam.primitiveType = DATA_FACTORY.createPrimitiveUnspecified
        } else {
            if (!responseSchema.schema.get$ref.isNullOrEmpty) {
                newLemmaParam.importedType = getImportedComplexDataTypeFromRef(
                    responseSchema.schema.get$ref
                )
            } else {
                // If it is not a reference but a primitive type or an array
                newLemmaParam = newLemmaParam.getPrimitiveOrArrayDataTypeFromSchema(
                    responseSchema.schema
                )
            }
        }
        return newLemmaParam
    }

    /** Creates and returns a new <strong>PrimitiveType</strong> based on a given OpenAPI schema.
     */
    def de.fhdo.lemma.service.Parameter getPrimitiveOrArrayDataTypeFromSchema(
        de.fhdo.lemma.service.Parameter para,
        Schema schema) {
        var returnPara = para
        switch (schema.type) {
            case "integer": {
                returnPara.primitiveType = OpenApiUtil.deriveIntType(schema.format)
            }
            case "number": {
                returnPara.primitiveType = OpenApiUtil.deriveNumberType(schema.format)
            }
            case "string": {
                returnPara.primitiveType = OpenApiUtil.deriveStringType(schema.format)
            }
            case "boolean": {
                returnPara.primitiveType = DATA_FACTORY.createPrimitiveBoolean
            }
            case "object": {
                //recursive call
                returnPara = getPrimitiveOrArrayDataTypeFromSchema(
                    para, schema.additionalProperties as Schema
                )
            }
            case "array": {
                // In this case the actual data model is altered and persisted again,
                // because the normal DataSubGenerator does not scan for occurrences of array types
                // in operations
                val arSchema = schema as ArraySchema
                // check if List-Type already exists
                val findings = getImportedComplexDataTypeFromName(
                    arSchema.items.type.toFirstUpper + "List"
                )
                if (findings !== null) {
                    returnPara.importedType = findings
                } else {
                    val arrayList = createListTypeFromArraySchema(arSchema)
                    returnPara.importedType = getImportedComplexDataTypeFromName(arrayList.name)
                }
            }
            default:
                throw new MatchingException('''Could not find fitting Type for «schema.type»''')
        }
        return returnPara
    }

    def ListType createListTypeFromArraySchema(ArraySchema arSchema) {
        // type of array does not exist
        // need to create a new type
        val arrayList = DATA_FACTORY.createListType
        arrayList.name = arSchema.items.type.toFirstUpper + "List"
        switch (arSchema.items.type) {
            case "string":
                arrayList.primitiveType = DATA_FACTORY.createPrimitiveString
            case "integer":
                arrayList.primitiveType = DATA_FACTORY.createPrimitiveInteger
            case "number":
                arrayList.primitiveType = DATA_FACTORY.createPrimitiveFloat
            case "boolean":
                arrayList.primitiveType = DATA_FACTORY.createPrimitiveBoolean
            case null: {
                val myField = DATA_FACTORY.createDataField
                myField.complexType = getComplexDataTypeFromRef(arSchema.items.get$ref)
                myField.name = myField.complexType.name.toLowerCase
                arrayList.name = myField.complexType.name.toFirstUpper + "List"
                arrayList.dataFields.add(myField)
            }
            default: {
                throw new NotImplementedException(
                    '''Could not handle Array type. «arSchema» is not supported!'''
                )
            }
        }
        // adding new primitive list to data model
        // Loading and altering of existing data model
        val dataModel = this.dataModel.value
        if(dataModel.containedComplexTypes.filter[it.name.equals(arrayList.name)].isEmpty) {
            dataModel.versions.get(0)?.contexts.get(0)?.complexTypes.add(arrayList)
            // persisting the model
            if (OpenApiUtil.writeModel(dataModel, dataModelLoc)) {
                logger.info("Data model alteration successful!")
                logger.info('''Model written to «dataModelLoc»''')
            } else {
                throw new Exception("Data model alteration failed :(")
            }
        } else {
            logger.info("Skipped: ComplexType already in Data Model.")
        }
        return arrayList
    }

    def void CreateEndpoints(
        de.fhdo.lemma.service.Operation leOp, String type, String path, Operation swOp
    ) {
        val endpoint = SERVICE_FACTORY.createEndpoint
        val proto = SERVICE_FACTORY.createImportedProtocolAndDataFormat
        // always sets "rest" as protocol to the endpoint,
        // because OpenAPI is a specification to describe RESTful Interfaces
        proto.importedProtocol = techModel.value.protocols.findFirst[it.name === DEFAULT_PROTOCOL]
        endpoint.protocols.add(proto)
        endpoint.addresses.add(path)
        leOp.endpoints.add(endpoint)
    }

    def void CreateRestAspect(
        de.fhdo.lemma.service.Operation leOp,
        String type,
        Operation swOp
    ) {
        val aspect = SERVICE_FACTORY.createImportedServiceAspect
        val opAspects = techModel.value.serviceAspects
        aspect.importedAspect = switch (type) {
            case "GET": {
                opAspects.filter[it.name == "GetMapping"].head
            }
            case "PUT": {
                opAspects.filter[it.name == "PutMapping"].head
            }
            case "POST": {
                opAspects.filter[it.name == "PostMapping"].head
            }
            case "DELETE": {
                opAspects.filter[it.name == "DeleteMapping"].head
            }
            case "OPTIONS": {
                opAspects.filter[it.name == "OptionsMapping"].head
            }
            case "HEAD": {
                opAspects.filter[it.name == "HeadMapping"].head
            }
            case "PATCH": {
                opAspects.filter[it.name == "PatchMapping"].head
            }
            case "TRACE": {
                opAspects.filter[it.name == "TraceMapping"].head
            }
            default: {
                opAspects.filter[it.name == "Unspecified"].head
            }
        }
        leOp.aspects.add(aspect)
    }

    def void createCommentary(
        de.fhdo.lemma.service.Operation leOp,
        String type,
        String path,
        Operation swOp
    ) {
        val comment = SERVICE_FACTORY.createApiOperationComment
        comment.comment = '''
            **Type** «type» Operation for path «path»
            **Summary** «swOp.summary»
            **Description** «swOp.description»
        '''
        comment.operation = leOp
    }

    /** Creates and returns a <strong>Lemma Parameter</strong> based on
     * a <strong>Swagger Parameter</strong>. This method uses <italic>dataModels</italic> to
     * add complex data types.
     */
    def de.fhdo.lemma.service.Parameter createLemmaInParameter(Parameter parameter) {
        val newLemmaParam = SERVICE_FACTORY.createParameter
        newLemmaParam.name = StringUtils.lowerCase(parameter.name)
        newLemmaParam.optional = parameter.required ?: false
        newLemmaParam.exchangePattern = ExchangePattern.IN
        var Schema schema
        if (parameter.content !== null) {
            println(parameter)
        } else {
            schema = parameter.schema
        }
        if (!parameter.get$ref.isNullOrEmpty)
            newLemmaParam.importedType = getImportedComplexDataTypeFromRef(parameter.get$ref)
        else
            newLemmaParam.getPrimitiveOrArrayDataTypeFromSchema(schema)
        return newLemmaParam
    }

    /** Creates and returns a <strong>Data Model Import</strong> based on
     * the given <strong>uri</strong> and <strong>model</strong>.
     * The import is added to <italic>myServiceModel</italic>
     */
    def Import createDataImport(String uri, DataModel model) {
        val dataImport = SERVICE_FACTORY.createImport
        dataImport.importType = ImportType.DATATYPES
        dataImport.importURI = uri
        dataImport.name = model.versions.get(0)?.contexts.get(0)?.name.concat("Data")
        dataImport.serviceModel = myServiceModel
        logger.debug("Added data model import.")
        return dataImport
    }

    /** Creates and returns a <strong>Technology Import</strong> based on
     * the given <strong>uri</strong> and <strong>model</strong>.
     * The import is added to <italic>myServiceModel</italic>
     */
    def createTechnologyImport(String uri, Technology technology) {
        val techImport = SERVICE_FACTORY.createImport
        techImport.importType = ImportType.TECHNOLOGY
        techImport.importURI = uri
        techImport.name = technology.name
        techImport.serviceModel = myServiceModel
        logger.debug("Added technology import.")
        return techImport
    }

    /** Creates and returns a <strong>Microservice</strong> with the given <strong>name</strong>.
     * The service is added to <italic>myServiceModel</italic>
     */
    def Microservice createFunctionalMicroservice(String name) {
        logger.info('''NAME DES MICROSERVICE: «name»''')
        val functionalService = SERVICE_FACTORY.createMicroservice
        functionalService.serviceModel = myServiceModel
        functionalService.name = name
        functionalService.visibility = Visibility.PUBLIC
        functionalService.type = MicroserviceType.FUNCTIONAL
        myServiceModel.microservices.add(functionalService)
        logger.debug("Added functional microservice.")
        return functionalService
    }

    /** Creates and returns a new <strong>Interface</strong> with the given <strong>name</strong>.
     * The service is added to the <italic>microservice</italic>.
     */
    def Interface createInterface(Microservice microservice, String name) {
        val interface = SERVICE_FACTORY.createInterface
        interface.name = name
        interface.microservice = microservice
        microservice.interfaces.add(interface)
        return interface
    }

    /** Finds a previously created <strong>ComplexType</strong> from the data model with
     * from the given <strong>ref</strong> string (c.f. OpenAPI Spec).
     * If no fitting ComplexType is found throws a ComplexTypeException.
     */
    def ComplexType getComplexDataTypeFromRef(String ref) throws ComplexTypeException {
        val dataModel = dataModel.value
        val complexTypes = dataModel.versions.get(0).contexts.get(0).complexTypes
        val parts = ref.split("/")
        if (parts.size >= 4)
        //Always assumes the path is "#/components/schemas/{Name}"
            if (parts.get(1).equals("components") && parts.get(2).equals("schemas"))
                return complexTypes.findFirst[it.name.equals(StringUtils.capitalize(parts.get(3)))]
        throw new ComplexTypeException('''Could not find fitting type for «ref» in Data Model''')
    }

    /** Creates and returns a new <strong>ImportedType</strong> from a given
     * OpenAPI <strong>ref</strong> object.
     */
    def ImportedType getImportedComplexDataTypeFromRef(String ref) {
        val importedType = SERVICE_FACTORY.createImportedType
        importedType.import = myServiceModel.imports.get(0)
        try {
            importedType.type = getComplexDataTypeFromRef(ref)
        } catch (ComplexTypeException cte) {
            logger.error(cte.message)
            cte.printStackTrace()
            return null
        }
        if (importedType.type !== null)
            return importedType
        else
            return null
    }

    /** Finds and returns a new <strong>ImportedType</strong> from the imported data model
     *  based on the <strong>name</strong> of an domain entity.
     */
    def ImportedType getImportedComplexDataTypeFromName(String name) {
        val dataModel = dataModel.value
        val complexTypes = dataModel.versions.get(0).contexts.get(0).complexTypes
        //
        val importedType = SERVICE_FACTORY.createImportedType
        importedType.import = myServiceModel.imports.get(0)
        try {
            importedType.type = complexTypes.findFirst[it.name.equals(name)]
        } catch (ComplexTypeException cte) {
            logger.error(cte.message)
            cte.printStackTrace()
            return null
        }
        if (importedType.type !== null)
            return importedType
        else
            return null
    }
}
