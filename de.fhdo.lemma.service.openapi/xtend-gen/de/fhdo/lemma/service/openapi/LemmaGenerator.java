package de.fhdo.lemma.service.openapi;

import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.technology.Technology;
import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;

/**
 * This class is the central entrypoint for the generation of LEMMA models from an OpenAPI
 * specification file (v3.0.3). The class supports the generation from JSON as well as YAML OpenAPI
 * files.
 * It calls the sub-generators, namely, the
 * {@link de.fhdo.lemma.service.openapi.LemmaDataSubGenerator LemmaDataSubGenerator},
 * {@link de.fhdo.lemma.service.openapi.LemmaServiceSubGenerator LemmaServiceSubGenerator},
 * {@link de.fhdo.lemma.service.openapi.LemmaTechnologySubGenerator LemmaTechnologySubGenerator},
 * for the respective LEMMA model kinds.
 * 
 * @see <a href="https://github.com/SeelabFhdo/lemma">LEMMA on GitHub</a>
 * @see <a href="https://www.openapis.org/">OpenAPI Specification</a>
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@CommandLine.Command(name = "transform", description = "Transforms a OpenAPI document into LEMMA Data, Service, and Technology models.\n\tRequires the following options:\n\t -url: URL pointing to the OpenAPI specification (file:/ or https://).\n     -tf: Path to the folder where the generated LEMMA models will be saved (e.g. C:\\myfolder\\test).\n     -d: Name for the generated LEMMA data model.\n     -s: Name for the generated LEMMA service model.\n     -t: Name for the generated LEMMA technology model.\n     \'-sp: Prefix for the package of the service model (e.g. \'my.example.package\').")
@SuppressWarnings("all")
public class LemmaGenerator implements Runnable {
  /**
   * SLF4j LOGGER
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(LemmaGenerator.class);
  
  /**
   * For stand-alone execution, the generator provides several CLI options
   */
  @CommandLine.Option(names = { "-u" }, required = true)
  private String fetchUrl;
  
  @CommandLine.Option(names = { "-tf" }, required = true)
  private String targetFolder;
  
  @CommandLine.Option(names = { "-d" }, required = true)
  private String dataModelName;
  
  @CommandLine.Option(names = { "-s" }, required = true)
  private String serviceModelName;
  
  @CommandLine.Option(names = { "-t" }, required = true)
  private String technologyModelName;
  
  @CommandLine.Option(names = { "-sp" }, required = true)
  private String servicePrefix;
  
  /**
   * OpenAPI schema which will be used as source for the generation
   */
  private OpenAPI openAPI;
  
  /**
   * Log of all encountered exceptions during all transformations
   */
  private List<String> transMsgs = CollectionLiterals.<String>newArrayList();
  
  public List<String> getTransMsgs() {
    return Collections.<String>unmodifiableList(this.transMsgs);
  }
  
  /**
   * Checks whether there currently is a parsed in-memory to start the generation process
   */
  public boolean isParsed() {
    return (this.openAPI != null);
  }
  
  /**
   * Take a URL pointing to an OpenAPI specification file (JSON or YAML) and parse it using the
   * Swagger OpenAPI parsing framework. Return a list of all encountered messages during the
   * parsing.
   */
  public ArrayList<String> parse(final String location) {
    final ArrayList<String> returnMessages = CollectionLiterals.<String>newArrayList("Encountered messages while parsing the URL");
    final ParseOptions parseOptions = new ParseOptions();
    parseOptions.setResolve(true);
    parseOptions.setFlatten(true);
    final SwaggerParseResult result = new OpenAPIParser().readLocation(location, null, parseOptions);
    List<String> _messages = result.getMessages();
    boolean _tripleNotEquals = (_messages != null);
    if (_tripleNotEquals) {
      boolean _isEmpty = result.getMessages().isEmpty();
      if (_isEmpty) {
        returnMessages.add("No errors or warnings encountered");
      } else {
        returnMessages.addAll(result.getMessages());
      }
    }
    OpenAPI _openAPI = result.getOpenAPI();
    boolean _tripleNotEquals_1 = (_openAPI != null);
    if (_tripleNotEquals_1) {
      this.openAPI = result.getOpenAPI();
      returnMessages.add("In-memory model of OpenAPI specification URL loaded");
    } else {
      returnMessages.add(("There was an error generating the in-memory model for the given " + 
        "OpenAPI specification URL"));
    }
    return returnMessages;
  }
  
  /**
   * Central method which generates all models
   */
  public boolean generateModels(final String targetPath, final String dataFilename, final String technologyFilename, final String serviceFilename, final String servicePrefix) {
    boolean _xblockexpression = false;
    {
      String _xifexpression = null;
      boolean _endsWith = targetPath.endsWith(File.separator);
      boolean _not = (!_endsWith);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(targetPath);
        _builder.append(File.separator);
        _xifexpression = _builder.toString();
      } else {
        _xifexpression = targetPath;
      }
      final String terminatedTargetPath = _xifexpression;
      LemmaGenerator.LOGGER.info("Starting generation of LEMMA data model...");
      final String dataModelPath = Paths.get(terminatedTargetPath, dataFilename).toString();
      final LemmaDataSubGenerator dataGenerator = new LemmaDataSubGenerator(this.openAPI, dataModelPath);
      DataModel _generate = dataGenerator.generate();
      final Pair<String, DataModel> dataModel = Pair.<String, DataModel>of(dataFilename, _generate);
      this.transMsgs.addAll(dataGenerator.getTransMsgs());
      LemmaGenerator.LOGGER.info("Starting generation of LEMMA technology model...");
      final String technologyModelPath = Paths.get(terminatedTargetPath, technologyFilename).toString();
      final LemmaTechnologySubGenerator technologyGenerator = new LemmaTechnologySubGenerator(this.openAPI, technologyModelPath);
      Technology _generate_1 = technologyGenerator.generate();
      final Pair<String, Technology> technology = Pair.<String, Technology>of(technologyFilename, _generate_1);
      this.transMsgs.addAll(technologyGenerator.getTransMsgs());
      LemmaGenerator.LOGGER.info("Starting generation of LEMMA service model...");
      final String serviceModelPath = Paths.get(terminatedTargetPath, serviceFilename).toString();
      final LemmaServiceSubGenerator serviceGenerator = new LemmaServiceSubGenerator(this.openAPI, dataModel, technology, serviceModelPath);
      serviceGenerator.generate(servicePrefix);
      _xblockexpression = this.transMsgs.addAll(serviceGenerator.getTransMsgs());
    }
    return _xblockexpression;
  }
  
  /**
   * Entrypoint for standalone execution. It takes the following mandatory parameters in the given
   * order to call the OpenAPI2LEMMA generator.
   * <ul>
   * <li><i>openapiPath</i>: URL pointing to the OpenAPI specification (file:/ or https://).</li>
   * <li><i>genPath</i>: Path to the folder where the generated LEMMA models will be saved (e.g.,
   * C:\myfolder\test).</li>
   * <li><i>dataFilename</i>: Name for the generated LEMMA data model.</li>
   * <li><i>serviceFilename</i>: Name for the generated LEMMA service model.</li>
   * <li><i>techFilename</i>: Name for the generated LEMMA technology model.</li>
   * <li><i>prefixService</i>: Prefix for the package of the service model (e.g.,
   * "my.example.package")</li>
   * </ul>
   */
  public static void main(final String[] args) {
    LemmaGenerator _lemmaGenerator = new LemmaGenerator();
    CommandLine.<LemmaGenerator>run(_lemmaGenerator, args);
  }
  
  /**
   * Exit standalone execution with error return code
   */
  private static void exitWithError(final String message) {
    InputOutput.<String>println(message);
    System.exit(1);
  }
  
  @Override
  public void run() {
    try {
      LemmaGenerator.LOGGER.info("Starting standalone execution of OpenAPI2LEMMA Generator");
      final URL fetchUrl = new URL(this.fetchUrl);
      final String targetFolder = this.targetFolder.trim();
      final String dataModelName = this.dataModelName.trim();
      final String serviceModelName = this.serviceModelName.trim();
      final String technologyModelName = this.technologyModelName.trim();
      final String servicePrefix = this.servicePrefix.trim();
      if (((((targetFolder.isEmpty() || 
        dataModelName.isEmpty()) || 
        serviceModelName.isEmpty()) || 
        technologyModelName.isEmpty()) || 
        servicePrefix.isEmpty())) {
        LemmaGenerator.exitWithError("Arguments must not be empty");
      }
      LemmaGenerator.LOGGER.info("Parsing the OpenAPI specification URL...");
      final ArrayList<String> parsingMessages = this.parse(fetchUrl.toString());
      boolean _isParsed = this.isParsed();
      boolean _not = (!_isParsed);
      if (_not) {
        LemmaGenerator.exitWithError("OpenAPI specification URL could not be parsed");
      }
      boolean _isEmpty = parsingMessages.isEmpty();
      boolean _not_1 = (!_isEmpty);
      if (_not_1) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Encountered messages during parsing:");
        _builder.newLine();
        {
          for(final String msg : parsingMessages) {
            _builder.append("            ");
            _builder.append("- ");
            _builder.append(msg, "            ");
            _builder.newLineIfNotEmpty();
            _builder.append("            ");
          }
        }
        LemmaGenerator.LOGGER.info(_builder.toString());
      }
      LemmaGenerator.LOGGER.info("... in-memory representation of OpenAPI specification URL parsed");
      LemmaGenerator.LOGGER.info("Starting LEMMA model generation...");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(dataModelName);
      _builder_1.append(".data");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append(technologyModelName);
      _builder_2.append(".technology");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append(serviceModelName);
      _builder_3.append(".services");
      this.generateModels(targetFolder, _builder_1.toString(), _builder_2.toString(), _builder_3.toString(), servicePrefix);
      boolean _isEmpty_1 = this.transMsgs.isEmpty();
      if (_isEmpty_1) {
        LemmaGenerator.LOGGER.info("Transformation successful");
      } else {
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("Encountered problems during transformation:");
        _builder_4.newLine();
        {
          for(final String msg_1 : this.transMsgs) {
            _builder_4.append("                ");
            _builder_4.append(msg_1, "                ");
            _builder_4.newLineIfNotEmpty();
            _builder_4.append("                ");
          }
        }
        LemmaGenerator.LOGGER.info(_builder_4.toString());
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
