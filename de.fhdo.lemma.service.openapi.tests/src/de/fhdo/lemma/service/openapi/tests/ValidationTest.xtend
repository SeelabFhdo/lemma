package de.fhdo.lemma.service.openapi.tests

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotEquals

import org.junit.Test
import de.fhdo.lemma.service.openapi.LemmaGenerator

/**
 * This class tests the the generation of LEMMA models from an OpenAPI specification file (v3.0.3).
 *
 * @see <a href="https://www.openapis.org/">https://www.openapis.org/</a>
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
class ValidationTest {
    static val SCHEMA_PATH = "https://petstore3.swagger.io/api/v3/openapi.json"

    @Test
    def void schemaShouldNotHaveErrors() {
        val generator = new LemmaGenerator()
        val parsedSchema = generator.parse(SCHEMA_PATH)
        assertEquals(
                "Zero errors should be detected while parsing/validating",
                "No errors or warnings encountered!",
                parsedSchema.get(parsedSchema.length-2)
            )
        assertNotEquals(
            "Message Object must not be null while parsing",
            "There was an error generating the in-memory model for the given URL",
            parsedSchema.get(parsedSchema.length-1)
        )
    }
}
