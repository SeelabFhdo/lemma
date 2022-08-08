package de.fhdo.lemma.service.openapi.tests

import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses

/**
 * Entrypoint for all tests regarding the transformation of OpenAPI specifications into LEMMA
 * models.
 *
 * @see <a href="https://www.openapis.org/">https://www.openapis.org/</a>
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@RunWith(Suite)
@SuiteClasses(ValidationTest, GeneratorsTest)
class LemmaGeneratorAllTests { }