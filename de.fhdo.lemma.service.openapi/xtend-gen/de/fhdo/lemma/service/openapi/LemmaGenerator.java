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
import java.util.LinkedList;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;

/**
 * Entrypoint for the generation of LEMMA models from an OpenAPI specification file (v3.0.3). The
 * class supports the generation of LEMMA models from JSON-based and YAML-based OpenAPI
 * specification files.
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@CommandLine.Command(name = "transform", description = ("Transform OpenAPI specification files into LEMMA " + 
  "domain, service, and technology models."))
@SuppressWarnings("all")
public class LemmaGenerator implements Runnable {
  /**
   * SLF4j LOGGER
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(LemmaGenerator.class);

  /**
   * CLI options for standalone execution
   */
  @CommandLine.Option(names = { "-u", "--url" }, description = ("URL pointing to the OpenAPI specification " + 
    "file (file:/ or https:// URI)"), required = true)
  private String fetchUrl;

  @CommandLine.Option(names = { "-f", "--target_folder" }, description = ("Path to the folder where the " + 
    "generated LEMMA models shall be saved"), required = true)
  private String targetFolder;

  @CommandLine.Option(names = { "-d", "--data_model_name" }, description = ("Name for the generated LEMMA " + 
    "data model"), required = true)
  private String dataModelName;

  @CommandLine.Option(names = { "-s", "--service_model_name" }, description = ("Name for the generated LEMMA " + 
    "service model"), required = true)
  private String serviceModelName;

  @CommandLine.Option(names = { "-t", "--technology_model_name" }, description = ("Name for the generated " + 
    "LEMMA technology model"), required = true)
  private String technologyModelName;

  @CommandLine.Option(names = { "-p", "--service_qualifier" }, description = ("Qualifier for generated " + 
    "LEMMA microservice definitions in Java package notation"), required = true)
  private String serviceQualifier;

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
  public LinkedList<String> parse(final String location) {
    final ParseOptions parseOptions = new ParseOptions();
    parseOptions.setResolve(true);
    parseOptions.setFlatten(true);
    final SwaggerParseResult result = new OpenAPIParser().readLocation(location, null, parseOptions);
    final ArrayList<String> returnMessages = CollectionLiterals.<String>newArrayList();
    List<String> _messages = result.getMessages();
    boolean _tripleNotEquals = (_messages != null);
    if (_tripleNotEquals) {
      returnMessages.addAll(result.getMessages());
    }
    OpenAPI _openAPI = result.getOpenAPI();
    boolean _tripleEquals = (_openAPI == null);
    if (_tripleEquals) {
      returnMessages.add(("There were errors generating the in-memory model for the given " + 
        "OpenAPI specification URL"));
    }
    this.openAPI = result.getOpenAPI();
    final LinkedList<String> itemizedReturnMessages = CollectionLiterals.<String>newLinkedList();
    boolean _isEmpty = returnMessages.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      itemizedReturnMessages.add("Encountered messages while parsing the URL:");
      final Function1<String, String> _function = (String it) -> {
        return ("\t- " + it);
      };
      itemizedReturnMessages.addAll(ListExtensions.<String, String>map(returnMessages, _function));
    }
    return itemizedReturnMessages;
  }

  /**
   * Central method which generates all models
   */
  public boolean generateModels(final String targetPath, final String dataFilename, final String technologyFilename, final String serviceFilename, final String serviceQualifier) {
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
      serviceGenerator.generate(serviceQualifier);
      _xblockexpression = this.transMsgs.addAll(serviceGenerator.getTransMsgs());
    }
    return _xblockexpression;
  }

  /**
   * Entrypoint for CLI-based standalone execution of the OpenAPI2LEMMA generator
   */
  public static void main(final String[] args) {
    LemmaGenerator _lemmaGenerator = new LemmaGenerator();
    CommandLine.<LemmaGenerator>run(_lemmaGenerator, args);
  }

  /**
   * Logic for the thread-based standalone execution of the OpenAPI2LEMMA generator
   */
  @Override
  public void run() {
    try {
      LemmaGenerator.LOGGER.info("Starting standalone execution of OpenAPI2LEMMA generator");
      final URL fetchUrl = new URL(this.fetchUrl);
      final String targetFolder = this.targetFolder.trim();
      final String dataModelName = this.dataModelName.trim();
      final String serviceModelName = this.serviceModelName.trim();
      final String technologyModelName = this.technologyModelName.trim();
      final String serviceQualifier = this.serviceQualifier.trim();
      if (((((targetFolder.isEmpty() || 
        dataModelName.isEmpty()) || 
        serviceModelName.isEmpty()) || 
        technologyModelName.isEmpty()) || 
        serviceQualifier.isEmpty())) {
        LemmaGenerator.exitWithError("Arguments must not be empty");
      }
      LemmaGenerator.LOGGER.info("Parsing the OpenAPI specification URL...");
      final LinkedList<String> parsingMessages = this.parse(fetchUrl.toString());
      boolean _isParsed = this.isParsed();
      boolean _not = (!_isParsed);
      if (_not) {
        LemmaGenerator.exitWithError("OpenAPI specification URL could not be parsed");
      }
      boolean _isEmpty = parsingMessages.isEmpty();
      boolean _not_1 = (!_isEmpty);
      if (_not_1) {
        StringConcatenation _builder = new StringConcatenation();
        {
          for(final String msg : parsingMessages) {
            _builder.newLineIfNotEmpty();
            _builder.append(msg);
            _builder.newLineIfNotEmpty();
            _builder.append("                ");
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
      this.generateModels(targetFolder, _builder_1.toString(), _builder_2.toString(), _builder_3.toString(), serviceQualifier);
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
            _builder_4.append(("\t- " + msg_1), "                ");
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

  /**
   * Exit standalone execution with error return code
   */
  private static void exitWithError(final String message) {
    InputOutput.<String>println(message);
    System.exit(1);
  }
}
