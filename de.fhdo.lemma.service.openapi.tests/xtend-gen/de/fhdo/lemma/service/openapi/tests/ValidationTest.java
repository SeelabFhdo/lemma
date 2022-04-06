package de.fhdo.lemma.service.openapi.tests;

import de.fhdo.lemma.service.openapi.LemmaGenerator;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class tests the the generation of LEMMA models from
 * an OpenAPI specification file (v3.0.3).
 * @see <a href="https://www.openapis.org/">https://www.openapis.org/</a>
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public class ValidationTest {
  private Logger logger;
  
  private final String schemaLocation = "https://petstore3.swagger.io/api/v3/openapi.json";
  
  @Before
  public void setup() throws Exception {
    this.logger = LoggerFactory.getLogger(ValidationTest.class);
  }
  
  @Test
  public void schemaShouldHaveNoErrors() {
    final LemmaGenerator generator = new LemmaGenerator();
    final List<String> parRes = generator.parse(this.schemaLocation);
    final Consumer<String> _function = (String it) -> {
      this.logger.info(it);
    };
    parRes.forEach(_function);
    int _length = ((Object[])Conversions.unwrapArray(parRes, Object.class)).length;
    int _minus = (_length - 2);
    Assert.assertEquals("Zero errors should be detected while parsing/validating", 
      parRes.get(_minus), "No errors or warnings encountered!");
    int _length_1 = ((Object[])Conversions.unwrapArray(parRes, Object.class)).length;
    int _minus_1 = (_length_1 - 1);
    Assert.assertNotEquals("Message Object must not be null while parsing", 
      parRes.get(_minus_1), ("There was an error generating the" + 
      "in memory model for the given URL :("));
  }
  
  @Test
  public void testShouldBeTrue() {
    Assert.assertTrue(true);
  }
}
