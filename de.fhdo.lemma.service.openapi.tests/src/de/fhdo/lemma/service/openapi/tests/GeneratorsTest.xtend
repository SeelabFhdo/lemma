package de.fhdo.lemma.service.openapi.tests

import static org.junit.Assert.assertTrue

import org.junit.Before
import de.fhdo.lemma.service.openapi.LemmaDataSubGenerator
import org.junit.Test
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.parser.OpenAPIParser
import io.swagger.v3.parser.core.models.ParseOptions
import java.io.File
import de.fhdo.lemma.service.openapi.LemmaTechnologySubGenerator
import de.fhdo.lemma.service.openapi.LemmaServiceSubGenerator

/**
 * This class tests the the generation of LEMMA models from an OpenAPI specification file (v3.0.3).
 * The class provides one test for each sub-generator of the OpenAPI-bundle.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class GeneratorsTest {
    static val DATA_MODEL_FILE = new File(System.getProperty("user.dir") +
        "/test-model-gen/test.data")
    static val LOCAL_SCHEMA_PATH = "test-schemas/openapi.json"
    static val SERVICE_MODEL_FILE = new File(System.getProperty("user.dir") +
        "/test-model-gen/test.service")
    static val TECHNOLOGY_MODEL_FILE = new File(System.getProperty("user.dir") +
        "/test-model-gen/test.technology")

    OpenAPI parsedSchema

    @Before
    def void setup() {
        val parseOptions = new ParseOptions()
        parseOptions.setResolve(true)
        parseOptions.setFlatten(true)

        parsedSchema = new OpenAPIParser().readLocation(
                new File(LOCAL_SCHEMA_PATH).toURI.toString,
                null,
                parseOptions
            ).openAPI
    }

    @Test
    def void dataTest() {
        generateDataModel()
        assertDataModelExists()
    }

    private def generateDataModel() {
        return new LemmaDataSubGenerator(parsedSchema, DATA_MODEL_FILE.path).generate
    }

    private def assertDataModelExists() {
        assertTrue(DATA_MODEL_FILE.exists)
    }

    @Test
    def void technologyTest() {
        generateTechnologyModel()
        assertTechnologyModelExists()
    }

    private def generateTechnologyModel() {
        return new LemmaTechnologySubGenerator(parsedSchema, TECHNOLOGY_MODEL_FILE.path).generate
    }

    private def assertTechnologyModelExists() {
        assertTrue(TECHNOLOGY_MODEL_FILE.exists)
    }

    @Test
    def void serviceTest() {
        val dataModel = generateDataModel()
        val technologyModel = generateTechnologyModel()
        new LemmaServiceSubGenerator(
                parsedSchema,
                DATA_MODEL_FILE.name -> dataModel,
                TECHNOLOGY_MODEL_FILE.name -> technologyModel,
                SERVICE_MODEL_FILE.path
            ).generate("test")

        assertDataModelExists()
        assertTechnologyModelExists()
        assertTrue(SERVICE_MODEL_FILE.exists)
    }
}