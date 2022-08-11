package de.fhdo.lemma.service.openapi.tests

import org.junit.Test
import de.fhdo.lemma.service.openapi.LemmaGenerator

import static org.junit.Assert.*

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

        assertTrue(
            "Schema should not contain errors or warnings",
            parsedSchema.contains("No errors or warnings encountered")
        )

        assertFalse(
            "Generation of in-memory model must be possible from error- and warning-free schema",
            parsedSchema.contains("There was an error generating the in-memory model for the " +
                "given URL")
        )
    }
}
