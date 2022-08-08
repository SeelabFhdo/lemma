package de.fhdo.lemma.service.openapi.tests;

import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.service.openapi.LemmaDataSubGenerator;
import de.fhdo.lemma.service.openapi.LemmaServiceSubGenerator;
import de.fhdo.lemma.service.openapi.LemmaTechnologySubGenerator;
import de.fhdo.lemma.technology.Technology;
import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import java.io.File;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the the generation of LEMMA models from
 * an OpenAPI specification file (v3.0.3).
 * It provides one test for each subgenerator of the openapi-bundle.
 * @see <a href="https://www.openapis.org/">https://www.openapis.org/</a>
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public class GeneratorsTest {
  private final String localSchema = new File("test-schemas/openapi.json").toURI().toString();
  
  private LemmaDataSubGenerator dataGenerator;
  
  private LemmaTechnologySubGenerator technologyGenerator;
  
  private LemmaServiceSubGenerator serviceGenerator;
  
  private OpenAPI openAPI;
  
  @Before
  public void setup() throws Exception {
    final ParseOptions parseOptions = new ParseOptions();
    parseOptions.setResolve(true);
    parseOptions.setFlatten(true);
    final SwaggerParseResult result = new OpenAPIParser().readLocation(this.localSchema, null, parseOptions);
    this.openAPI = result.getOpenAPI();
  }
  
  @Test
  public void dataTest() throws Exception {
    String _property = System.getProperty("user.dir");
    String _plus = (_property + 
      "/test-model-gen/");
    LemmaDataSubGenerator _lemmaDataSubGenerator = new LemmaDataSubGenerator(this.openAPI, _plus, "test.data");
    this.dataGenerator = _lemmaDataSubGenerator;
    this.dataGenerator.generate();
    String _property_1 = System.getProperty("user.dir");
    String _plus_1 = (_property_1 + "/test-model-gen/test.data");
    Assert.assertTrue(new File(_plus_1).exists());
  }
  
  @Test
  public void technologyTest() throws Exception {
    String _property = System.getProperty("user.dir");
    String _plus = (_property + 
      "/test-model-gen/");
    LemmaTechnologySubGenerator _lemmaTechnologySubGenerator = new LemmaTechnologySubGenerator(this.openAPI, _plus, "test.technology");
    this.technologyGenerator = _lemmaTechnologySubGenerator;
    this.technologyGenerator.generate();
    String _property_1 = System.getProperty("user.dir");
    String _plus_1 = (_property_1 + "/test-model-gen/test.technology");
    Assert.assertTrue(new File(_plus_1).exists());
  }
  
  @Test
  public void serviceTest() throws Exception {
    String _property = System.getProperty("user.dir");
    String _plus = (_property + 
      "/test-model-gen/");
    LemmaDataSubGenerator _lemmaDataSubGenerator = new LemmaDataSubGenerator(this.openAPI, _plus, "test.data");
    this.dataGenerator = _lemmaDataSubGenerator;
    DataModel _generate = this.dataGenerator.generate();
    final Pair<String, DataModel> dataModel = Pair.<String, DataModel>of("test.data", _generate);
    String _property_1 = System.getProperty("user.dir");
    String _plus_1 = (_property_1 + 
      "/test-model-gen/");
    LemmaTechnologySubGenerator _lemmaTechnologySubGenerator = new LemmaTechnologySubGenerator(this.openAPI, _plus_1, "test.technology");
    this.technologyGenerator = _lemmaTechnologySubGenerator;
    Technology _generate_1 = this.technologyGenerator.generate();
    final Pair<String, Technology> techModel = Pair.<String, Technology>of("test.technology", _generate_1);
    String _property_2 = System.getProperty("user.dir");
    String _plus_2 = (_property_2 + "/test-model-gen/");
    LemmaServiceSubGenerator _lemmaServiceSubGenerator = new LemmaServiceSubGenerator(this.openAPI, dataModel, techModel, _plus_2, "test.service");
    this.serviceGenerator = _lemmaServiceSubGenerator;
    this.serviceGenerator.generate("test");
    String _property_3 = System.getProperty("user.dir");
    String _plus_3 = (_property_3 + "/test-model-gen/test.service");
    Assert.assertTrue(new File(_plus_3).exists());
  }
}
