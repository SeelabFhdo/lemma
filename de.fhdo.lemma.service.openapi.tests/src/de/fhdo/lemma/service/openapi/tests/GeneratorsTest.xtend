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
 * This class tests the the generation of LEMMA models from
 * an OpenAPI specification file (v3.0.3).
 * It provides one test for each subgenerator of the openapi-bundle.
 * @see <a href="https://www.openapis.org/">https://www.openapis.org/</a>
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class GeneratorsTest {
    static val LOCAL_SCHEMA_PATH = "test-schemas/openapi.json"

    LemmaDataSubGenerator dataGenerator
    LemmaTechnologySubGenerator technologyGenerator
    LemmaServiceSubGenerator serviceGenerator
    OpenAPI openAPI

    @Before
    def void setup() throws Exception {
        // Retrieval of parsed openapi
        val parseOptions = new ParseOptions()
        parseOptions.setResolve(true)
        parseOptions.setFlatten(true)
        val result = new OpenAPIParser().readLocation(
            new File(LOCAL_SCHEMA_PATH).toURI.toString,
            null,
            parseOptions
        )
        openAPI = result.openAPI
    }

    @Test
    def void dataTest() throws Exception {
        dataGenerator= new LemmaDataSubGenerator(openAPI, System.getProperty("user.dir")+
          "/test-model-gen/", "test.data")
        dataGenerator.generate
        assertTrue(new File(System.getProperty("user.dir")+"/test-model-gen/test.data").exists)
    }

    @Test
    def void technologyTest() throws Exception {
        technologyGenerator= new LemmaTechnologySubGenerator(openAPI, System.getProperty("user.dir")+
          "/test-model-gen/", "test.technology")
        technologyGenerator.generate
        assertTrue(new File(System.getProperty("user.dir")+"/test-model-gen/test.technology").exists)
    }

    @Test
    def void serviceTest() throws Exception {
        dataGenerator= new LemmaDataSubGenerator(openAPI, System.getProperty("user.dir")+
          "/test-model-gen/", "test.data")
        val dataModel = "test.data" -> dataGenerator.generate

        technologyGenerator= new LemmaTechnologySubGenerator(openAPI, System.getProperty("user.dir")+
          "/test-model-gen/", "test.technology")
        val techModel = "test.technology" -> technologyGenerator.generate

        serviceGenerator = new LemmaServiceSubGenerator(openAPI, dataModel, techModel,
            System.getProperty("user.dir")+"/test-model-gen/", "test.service")
        serviceGenerator.generate("test")

        assertTrue(new File(System.getProperty("user.dir")+"/test-model-gen/test.service").exists)
    }
}