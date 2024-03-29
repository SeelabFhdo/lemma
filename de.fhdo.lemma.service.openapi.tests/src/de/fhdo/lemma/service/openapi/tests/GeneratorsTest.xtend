package de.fhdo.lemma.service.openapi.tests

import static org.junit.Assert.assertTrue

import de.fhdo.lemma.service.openapi.LemmaDataSubGenerator
import org.junit.Test
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.parser.OpenAPIParser
import io.swagger.v3.parser.core.models.ParseOptions
import java.io.File
import de.fhdo.lemma.service.openapi.LemmaTechnologySubGenerator
import de.fhdo.lemma.service.openapi.LemmaServiceSubGenerator
import java.nio.file.Paths
import org.junit.BeforeClass
import org.junit.Before
import org.apache.commons.io.FileUtils
import org.junit.AfterClass

/**
 * This class tests the the generation of LEMMA models from an OpenAPI specification file (v3.0.3).
 * The class provides one test for each sub-generator of the OpenAPI-bundle.
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class GeneratorsTest {
    static val TEST_MODEL_BASEPATH = Paths.get(System.getProperty("user.dir"), "test-model-gen")
        .toString
    static val DATA_MODEL_FILE = Paths.get(TEST_MODEL_BASEPATH, "test.data").toFile
    static val LOCAL_SCHEMA_PATH = Paths.get("test-schemas", "openapi.json").toString
    static val SERVICE_MODEL_FILE = Paths.get(TEST_MODEL_BASEPATH, "test.services").toFile
    static val TECHNOLOGY_MODEL_FILE = Paths.get(TEST_MODEL_BASEPATH, "test.technology").toFile
    static OpenAPI parsedSchema

    @BeforeClass
    static def void setup() {
        val parseOptions = new ParseOptions()
        parseOptions.setResolve(true)
        parseOptions.setFlatten(true)

        parsedSchema = new OpenAPIParser().readLocation(
                new File(LOCAL_SCHEMA_PATH).toURI.toString,
                null,
                parseOptions
            ).openAPI
    }

    @Before
    def void prepareNextTest() {
        removeTestModelBaseFolder()
    }

    static def removeTestModelBaseFolder() {
        FileUtils.deleteDirectory(new File(TEST_MODEL_BASEPATH))
    }

    @AfterClass
    static def void cleanup() {
        removeTestModelBaseFolder()
    }

    @Test
    def void dataTest() {
        assertDataModelDoesNotExist()
        generateDataModel()
        assertDataModelExists()
    }

    private def assertDataModelDoesNotExist() {
        assertTrue(!DATA_MODEL_FILE.exists)
    }

    private def generateDataModel() {
        return new LemmaDataSubGenerator(parsedSchema, DATA_MODEL_FILE.path).generate
    }

    private def assertDataModelExists() {
        assertTrue(DATA_MODEL_FILE.exists)
    }

    @Test
    def void technologyTest() {
        assertTechnologyModelDoesNotExist()
        generateTechnologyModel()
        assertTechnologyModelExists()
    }

    private def assertTechnologyModelDoesNotExist() {
        assertTrue(!TECHNOLOGY_MODEL_FILE.exists)
    }

    private def generateTechnologyModel() {
        return new LemmaTechnologySubGenerator(parsedSchema, TECHNOLOGY_MODEL_FILE.path).generate
    }

    private def assertTechnologyModelExists() {
        assertTrue(TECHNOLOGY_MODEL_FILE.exists)
    }

    @Test
    def void serviceTest() {
        assertDataModelDoesNotExist()
        assertTechnologyModelDoesNotExist()
        assertTrue(!SERVICE_MODEL_FILE.exists)

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