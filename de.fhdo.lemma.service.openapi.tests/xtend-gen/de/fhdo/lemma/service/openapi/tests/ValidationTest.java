package de.fhdo.lemma.service.openapi.tests;

import de.fhdo.lemma.service.openapi.LemmaGenerator;
import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Test;

/**
 * This class tests the the generation of LEMMA models from an OpenAPI specification file (v3.0.3).
 * 
 * @see <a href="https://www.openapis.org/">https://www.openapis.org/</a>
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public class ValidationTest {
  private static final String SCHEMA_PATH = "https://petstore3.swagger.io/api/v3/openapi.json";
  
  @Test
  public void schemaShouldNotHaveErrors() {
    final LemmaGenerator generator = new LemmaGenerator();
    final LinkedList<String> parsedSchema = generator.parse(ValidationTest.SCHEMA_PATH);
    Assert.assertTrue("Schema should not contain errors or warnings", parsedSchema.isEmpty());
    Assert.assertFalse(
      "Generation of in-memory model must be possible from error- and warning-free schema", 
      parsedSchema.contains(("\t- There was an error generating the in-memory model for the " + 
        "given URL")));
  }
}
