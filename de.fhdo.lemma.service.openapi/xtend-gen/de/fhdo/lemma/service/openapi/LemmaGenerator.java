package de.fhdo.lemma.service.openapi;

import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.technology.Technology;
import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is the central entry point for the generation of LEMMA models from
 * an OpenAPI specification file (v3.0.3). It supports the generation from JSON as well as YAML
 * OpenAPI files, e.g.,
 * <a href="https://petstore3.swagger.io/api/v3/openapi.json">Swagger's PET Store example</a>
 * @see <a href="https://github.com/SeelabFhdo/lemma">LEMMA on GitHub</a>
 * @see <a href="https://www.openapis.org/">OpenAPI Specification</a>
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public class LemmaGenerator {
  /**
   * OpenAPI schema which will be used as source for generation
   */
  private OpenAPI openAPI;
  
  /**
   * SLF4j Logger
   */
  private Logger logger = LoggerFactory.getLogger(LemmaGenerator.class);
  
  /**
   * Log of all encountered exceptions during all transformations
   */
  @Accessors(AccessorType.PUBLIC_GETTER)
  private List<String> transMsgs = CollectionLiterals.<String>newArrayList();
  
  /**
   * Checks whether there currently is a parsed in-memory to start the generation process
   */
  public boolean isParsed() {
    boolean _xifexpression = false;
    if ((this.openAPI == null)) {
      _xifexpression = false;
    } else {
      _xifexpression = true;
    }
    return _xifexpression;
  }
  
  /**
   * Takes a URL pointing to an OpenAPI specification file (yaml or json) and parses it using
   * the swagger OpenAPI parsing framework. Returns a list of all encountered messages during
   * the parsing.
   */
  public List<String> parse(final String openapi) {
    final ArrayList<String> returnMessages = CollectionLiterals.<String>newArrayList();
    returnMessages.add("Encountered messages while parsing the URL...");
    final ParseOptions parseOptions = new ParseOptions();
    parseOptions.setResolve(true);
    parseOptions.setFlatten(true);
    final SwaggerParseResult result = new OpenAPIParser().readLocation(openapi, null, parseOptions);
    List<String> _messages = result.getMessages();
    boolean _tripleNotEquals = (_messages != null);
    if (_tripleNotEquals) {
      int _length = ((Object[])Conversions.unwrapArray(result.getMessages(), Object.class)).length;
      boolean _equals = (_length == 0);
      if (_equals) {
        returnMessages.add("No errors or warnings encountered!");
      } else {
        returnMessages.addAll(result.getMessages());
      }
    }
    OpenAPI _openAPI = result.getOpenAPI();
    boolean _tripleNotEquals_1 = (_openAPI != null);
    if (_tripleNotEquals_1) {
      this.openAPI = result.getOpenAPI();
      returnMessages.add("In memory model of OpenAPI model loaded!");
    } else {
      returnMessages.add(
        "There was an error generating the in memory model for the given URL :(");
    }
    return returnMessages;
  }
  
  /**
   * Central methods which generates all models
   */
  public boolean generateModels(final String genPath, final String dataFilename, final String serviceFilename, final String techFilename, final String prefixService) {
    boolean _xblockexpression = false;
    {
      this.logger.info("Starting generation of LEMMA Data Model...");
      final String dataModelPath = Paths.get(genPath, dataFilename).toString();
      final LemmaDataSubGenerator dataGenerator = new LemmaDataSubGenerator(this.openAPI, dataModelPath);
      DataModel _generate = dataGenerator.generate();
      final Pair<String, DataModel> dataModel = Pair.<String, DataModel>of(dataFilename, _generate);
      this.logger.debug("Adding encountered messages to log.");
      this.transMsgs.addAll(dataGenerator.getTransMsgs());
      this.logger.info("Starting generation of LEMMA Technology Model...");
      final String technologyModelPath = Paths.get(genPath, techFilename).toString();
      final LemmaTechnologySubGenerator technologyGenerator = new LemmaTechnologySubGenerator(this.openAPI, technologyModelPath);
      Technology _generate_1 = technologyGenerator.generate();
      final Pair<String, Technology> techModel = Pair.<String, Technology>of(techFilename, _generate_1);
      this.logger.debug("Adding encountered messages to log.");
      this.transMsgs.addAll(technologyGenerator.getTransMsgs());
      this.logger.info("Starting generation of LEMMA Service Model...");
      final String serviceModelPath = Paths.get(genPath, serviceFilename).toString();
      final LemmaServiceSubGenerator serviceGenerator = new LemmaServiceSubGenerator(this.openAPI, dataModel, techModel, serviceModelPath);
      serviceGenerator.generate(prefixService);
      this.logger.debug("Adding encountered messages to log.");
      _xblockexpression = this.transMsgs.addAll(serviceGenerator.getTransMsgs());
    }
    return _xblockexpression;
  }
  
  /**
   * Entrypoint for execution outside of eclipse.
   * Takes these parameters in the following order to call the OpenAPI2LEMMA Generator.
   * All parameters are mandatory.
   * <ul>
   * <li><i>openapiPath</i>
   * - URL pointing to the OpenAPI specification (file:/ or https://).</li>
   * <li><i>genPath</i>
   * - Path to the folder where the generated LEMMA models will be saved
   * (e.g. C:/myfolder/test ).</li>
   * <li><i>dataFilename</i> - Name for the generated LEMMA Domain Data Model.</li>
   * <li><i>serviceFilename</i> - Name for the generated LEMMA Service Model.</li>
   * <li><i>techFilename</i> - Name for the generated LEMMA Technology Model.</li>
   * <li><i>prefixService</i> - Prefix for the package of
   * the service model, (e.g. my.example.package)</li>
   * </ul>
   */
  public static void main(final String[] args) {
    try {
      final LemmaGenerator generator = new LemmaGenerator();
      generator.logger.info("Starting direct invocation of OpenAPI2LEMMA Generator.");
      generator.logger.info("Checking parameters...");
      int _length = args.length;
      boolean _notEquals = (_length != 6);
      if (_notEquals) {
        throw new IllegalArgumentException("Number of parameters insufficient.");
      }
      String _get = args[0];
      final URL fetchUrl = new URL(_get);
      final String targetLoc = args[1];
      final String dataName = args[2];
      final String servName = args[3];
      final String techName = args[4];
      final String servPre = args[5];
      if (((((targetLoc.trim().isEmpty() || dataName.trim().isEmpty()) || 
        servName.trim().isEmpty()) || techName.trim().isEmpty()) || 
        servPre.trim().isEmpty())) {
        throw new IllegalArgumentException("Empty parameters encountered.");
      }
      generator.logger.info("Parameter check successful.");
      generator.logger.info("Parsing the OpenAPI file...");
      final List<String> parsingMessages = generator.parse(fetchUrl.toString());
      boolean _isParsed = generator.isParsed();
      boolean _not = (!_isParsed);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(fetchUrl);
        _builder.append(" was not possible");
        String _plus = ("Generation of in-memory representation for file " + _builder);
        throw new IllegalStateException(_plus);
      }
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Encountered messages during parsing (empty if none):");
      _builder_1.newLine();
      {
        for(final String msg : parsingMessages) {
          _builder_1.append("            ");
          _builder_1.append(msg, "            ");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("            ");
        }
      }
      _builder_1.append(" END");
      generator.logger.info(_builder_1.toString());
      generator.logger.info("In-memory representation of OpenAPI model loaded.");
      generator.logger.info("Starting LEMMA model generation procedure...");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append(targetLoc);
      _builder_2.append("/");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append(dataName);
      _builder_3.append(".data");
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append(servName);
      _builder_4.append(".services");
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append(techName);
      _builder_5.append(".technology");
      generator.generateModels(_builder_2.toString(), _builder_3.toString(), _builder_4.toString(), _builder_5.toString(), servPre);
      generator.logger.info("The transformation was a success!");
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("Encountered problems during transformation (empty if none):");
      _builder_6.newLine();
      {
        for(final String msg_1 : generator.transMsgs) {
          _builder_6.append("            ");
          _builder_6.append(msg_1, "            ");
          _builder_6.newLineIfNotEmpty();
          _builder_6.append("            ");
        }
      }
      _builder_6.append(" END");
      generator.logger.info(_builder_6.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Pure
  public List<String> getTransMsgs() {
    return this.transMsgs;
  }
}
