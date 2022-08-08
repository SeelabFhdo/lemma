package de.fhdo.lemma.service.openapi.tests;

import de.fhdo.lemma.service.openapi.LemmaGenerator;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
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
    final List<String> parsedSchema = generator.parse(ValidationTest.SCHEMA_PATH);
    int _length = ((Object[])Conversions.unwrapArray(parsedSchema, Object.class)).length;
    int _minus = (_length - 2);
    Assert.assertEquals(
      "Zero errors should be detected while parsing/validating", 
      parsedSchema.get(_minus), 
      "No errors or warnings encountered!");
    int _length_1 = ((Object[])Conversions.unwrapArray(parsedSchema, Object.class)).length;
    int _minus_1 = (_length_1 - 1);
    Assert.assertNotEquals(
      "Message Object must not be null while parsing", 
      parsedSchema.get(_minus_1), 
      "There was an error generating the in-memory model for the given URL");
  }
}
