package de.fhdo.lemma.service.openapi.tests;

import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.service.openapi.LemmaDataSubGenerator;
import de.fhdo.lemma.service.openapi.LemmaServiceSubGenerator;
import de.fhdo.lemma.service.openapi.LemmaTechnologySubGenerator;
import de.fhdo.lemma.technology.Technology;
import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.core.models.ParseOptions;
import java.io.File;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the the generation of LEMMA models from an OpenAPI specification file (v3.0.3).
 * The class provides one test for each sub-generator of the OpenAPI-bundle.
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public class GeneratorsTest {
  private static final File DATA_MODEL_FILE = new File((System.getProperty("user.dir") + 
    "/test-model-gen/test.data"));
  
  private static final String LOCAL_SCHEMA_PATH = "test-schemas/openapi.json";
  
  private static final File SERVICE_MODEL_FILE = new File((System.getProperty("user.dir") + 
    "/test-model-gen/test.service"));
  
  private static final File TECHNOLOGY_MODEL_FILE = new File((System.getProperty("user.dir") + 
    "/test-model-gen/test.technology"));
  
  private OpenAPI parsedSchema;
  
  @Before
  public void setup() {
    final ParseOptions parseOptions = new ParseOptions();
    parseOptions.setResolve(true);
    parseOptions.setFlatten(true);
    this.parsedSchema = new OpenAPIParser().readLocation(
      new File(GeneratorsTest.LOCAL_SCHEMA_PATH).toURI().toString(), 
      null, parseOptions).getOpenAPI();
  }
  
  @Test
  public void dataTest() {
    this.generateDataModel();
    this.assertDataModelExists();
  }
  
  private DataModel generateDataModel() {
    String _path = GeneratorsTest.DATA_MODEL_FILE.getPath();
    return new LemmaDataSubGenerator(this.parsedSchema, _path).generate();
  }
  
  private void assertDataModelExists() {
    Assert.assertTrue(GeneratorsTest.DATA_MODEL_FILE.exists());
  }
  
  @Test
  public void technologyTest() {
    this.generateTechnologyModel();
    this.assertTechnologyModelExists();
  }
  
  private Technology generateTechnologyModel() {
    String _path = GeneratorsTest.TECHNOLOGY_MODEL_FILE.getPath();
    return new LemmaTechnologySubGenerator(this.parsedSchema, _path).generate();
  }
  
  private void assertTechnologyModelExists() {
    Assert.assertTrue(GeneratorsTest.TECHNOLOGY_MODEL_FILE.exists());
  }
  
  @Test
  public void serviceTest() {
    final DataModel dataModel = this.generateDataModel();
    final Technology technologyModel = this.generateTechnologyModel();
    String _name = GeneratorsTest.DATA_MODEL_FILE.getName();
    Pair<String, DataModel> _mappedTo = Pair.<String, DataModel>of(_name, dataModel);
    String _name_1 = GeneratorsTest.TECHNOLOGY_MODEL_FILE.getName();
    Pair<String, Technology> _mappedTo_1 = Pair.<String, Technology>of(_name_1, technologyModel);
    String _path = GeneratorsTest.SERVICE_MODEL_FILE.getPath();
    new LemmaServiceSubGenerator(
      this.parsedSchema, _mappedTo, _mappedTo_1, _path).generate("test");
    this.assertDataModelExists();
    this.assertTechnologyModelExists();
    Assert.assertTrue(GeneratorsTest.SERVICE_MODEL_FILE.exists());
  }
}
