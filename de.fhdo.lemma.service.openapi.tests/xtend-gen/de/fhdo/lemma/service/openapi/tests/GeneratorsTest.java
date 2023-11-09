package de.fhdo.lemma.service.openapi.tests;

import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.technology.Technology;
import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.core.models.ParseOptions;
import java.io.File;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This class tests the the generation of LEMMA models from an OpenAPI specification file (v3.0.3).
 * The class provides one test for each sub-generator of the OpenAPI-bundle.
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public class GeneratorsTest {
  private static final String TEST_MODEL_BASEPATH = Paths.get(System.getProperty("user.dir"), "test-model-gen").toString();

  private static final File DATA_MODEL_FILE = Paths.get(GeneratorsTest.TEST_MODEL_BASEPATH, "test.data").toFile();

  private static final String LOCAL_SCHEMA_PATH = Paths.get("test-schemas", "openapi.json").toString();

  private static final File SERVICE_MODEL_FILE = Paths.get(GeneratorsTest.TEST_MODEL_BASEPATH, "test.services").toFile();

  private static final File TECHNOLOGY_MODEL_FILE = Paths.get(GeneratorsTest.TEST_MODEL_BASEPATH, "test.technology").toFile();

  private static OpenAPI parsedSchema;

  @BeforeClass
  public static void setup() {
    final ParseOptions parseOptions = new ParseOptions();
    parseOptions.setResolve(true);
    parseOptions.setFlatten(true);
    GeneratorsTest.parsedSchema = new OpenAPIParser().readLocation(
      new File(GeneratorsTest.LOCAL_SCHEMA_PATH).toURI().toString(), 
      null, parseOptions).getOpenAPI();
  }

  @Before
  public void prepareNextTest() {
    GeneratorsTest.removeTestModelBaseFolder();
  }

  public static void removeTestModelBaseFolder() {
    try {
      File _file = new File(GeneratorsTest.TEST_MODEL_BASEPATH);
      FileUtils.deleteDirectory(_file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @AfterClass
  public static void cleanup() {
    GeneratorsTest.removeTestModelBaseFolder();
  }

  @Test
  public void dataTest() {
    this.assertDataModelDoesNotExist();
    this.generateDataModel();
    this.assertDataModelExists();
  }

  private void assertDataModelDoesNotExist() {
    boolean _exists = GeneratorsTest.DATA_MODEL_FILE.exists();
    boolean _not = (!_exists);
    Assert.assertTrue(_not);
  }

  private DataModel generateDataModel() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe constructor LemmaDataSubGenerator(Object, String) refers to the missing type Object");
  }

  private void assertDataModelExists() {
    Assert.assertTrue(GeneratorsTest.DATA_MODEL_FILE.exists());
  }

  @Test
  public void technologyTest() {
    this.assertTechnologyModelDoesNotExist();
    this.generateTechnologyModel();
    this.assertTechnologyModelExists();
  }

  private void assertTechnologyModelDoesNotExist() {
    boolean _exists = GeneratorsTest.TECHNOLOGY_MODEL_FILE.exists();
    boolean _not = (!_exists);
    Assert.assertTrue(_not);
  }

  private Technology generateTechnologyModel() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe constructor LemmaTechnologySubGenerator(Object, String) refers to the missing type Object");
  }

  private void assertTechnologyModelExists() {
    Assert.assertTrue(GeneratorsTest.TECHNOLOGY_MODEL_FILE.exists());
  }

  @Test
  public void serviceTest() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method generate(String) from the type LemmaServiceSubGenerator refers to the missing type Object"
      + "\nThe constructor LemmaServiceSubGenerator(Object, Pair<String, DataModel>, Pair<String, Technology>, String) refers to the missing type Object");
  }
}
