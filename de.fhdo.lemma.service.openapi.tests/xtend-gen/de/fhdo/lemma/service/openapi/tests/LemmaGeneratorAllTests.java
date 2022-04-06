package de.fhdo.lemma.service.openapi.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * This class is the entrypoint for all tests regarding the
 * transformation of OpenAPI specifications into LEMMA models.
 * @see <a href="https://www.openapis.org/">https://www.openapis.org/</a>
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ ValidationTest.class, GeneratorsTest.class })
@SuppressWarnings("all")
public class LemmaGeneratorAllTests {
}
