package de.fhdo.lemma.service.openapi.tests

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue
import static org.junit.Assert.assertNotEquals

import org.junit.Before
import org.slf4j.LoggerFactory
import org.slf4j.Logger
import org.junit.Test
import de.fhdo.lemma.service.openapi.LemmaGenerator

/**
 * This class tests the the generation of LEMMA models from
 * an OpenAPI specification file (v3.0.3).
 * @see <a href="https://www.openapis.org/">https://www.openapis.org/</a>
 *
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class ValidationTest {
    Logger logger;
    val schemaLocation = "https://petstore3.swagger.io/api/v3/openapi.json"

    @Before
    def void setup() throws Exception {
        logger = LoggerFactory.getLogger(ValidationTest)
    }

    @Test
    def void schemaShouldHaveNoErrors() {
        val generator = new LemmaGenerator()
        val parRes = generator.parse(schemaLocation)
        parRes.forEach[logger.info(it)]
        assertEquals("Zero errors should be detected while parsing/validating",
            parRes.get(parRes.length-2), "No errors or warnings encountered!"
        )
        assertNotEquals("Message Object must not be null while parsing",
            parRes.get(parRes.length-1), "There was an error generating the" +
            "in memory model for the given URL :("
        )
    }

    @Test
    def void testShouldBeTrue() {
        assertTrue(true)
    }
}
