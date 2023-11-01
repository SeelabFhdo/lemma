package de.fhdo.lemma.service.openapi;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;

/**
 * Entrypoint for the generation of LEMMA models from an OpenAPI specification file (v3.0.3). The
 * class supports the generation of LEMMA models from JSON-based and YAML-based OpenAPI
 * specification files.
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
/* @Command(, ) */@SuppressWarnings("all")
public class LemmaGenerator implements Runnable {
  /**
   * SLF4j LOGGER
   */
  private static final Object LOGGER /* Skipped initializer because of errors */;

  /**
   * CLI options for standalone execution
   */
  /* @Option(, , )
   */private String fetchUrl;

  /* @Option(, , )
   */private String targetFolder;

  /* @Option(, , )
   */private String dataModelName;

  /* @Option(, , )
   */private String serviceModelName;

  /* @Option(, , )
   */private String technologyModelName;

  /* @Option(, , )
   */private String serviceQualifier;

  /**
   * OpenAPI schema which will be used as source for the generation
   */
  private /* OpenAPI */Object openAPI;

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
  public Object isParsed() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LemmaGenerator.openAPI refers to the missing type /* OpenAPI schema which will be used as source for the generation */\n    OpenAPI"
      + "\n!== cannot be resolved");
  }

  /**
   * Take a URL pointing to an OpenAPI specification file (JSON or YAML) and parse it using the
   * Swagger OpenAPI parsing framework. Return a list of all encountered messages during the
   * parsing.
   */
  public LinkedList<String> parse(final String location) {
    throw new Error("Unresolved compilation problems:"
      + "\nParseOptions cannot be resolved."
      + "\nOpenAPIParser cannot be resolved."
      + "\nThe field LemmaGenerator.openAPI refers to the missing type /* OpenAPI schema which will be used as source for the generation */\n    OpenAPI"
      + "\nsetResolve cannot be resolved"
      + "\nsetFlatten cannot be resolved"
      + "\nreadLocation cannot be resolved"
      + "\nmessages cannot be resolved"
      + "\n!== cannot be resolved"
      + "\nmessages cannot be resolved"
      + "\nopenAPI cannot be resolved"
      + "\n=== cannot be resolved"
      + "\nopenAPI cannot be resolved");
  }

  /**
   * Central method which generates all models
   */
  public boolean generateModels(final String targetPath, final String dataFilename, final String technologyFilename, final String serviceFilename, final String serviceQualifier) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LemmaGenerator.LOGGER refers to the missing type Object"
      + "\nThe constructor LemmaDataSubGenerator(OpenAPI, String) refers to the missing type OpenAPI"
      + "\nThe field LemmaGenerator.openAPI refers to the missing type /* OpenAPI schema which will be used as source for the generation */\n    OpenAPI"
      + "\nThe field LemmaGenerator.LOGGER refers to the missing type Object"
      + "\nThe constructor LemmaTechnologySubGenerator(OpenAPI, String) refers to the missing type OpenAPI"
      + "\nThe field LemmaGenerator.openAPI refers to the missing type /* OpenAPI schema which will be used as source for the generation */\n    OpenAPI"
      + "\nThe field LemmaGenerator.LOGGER refers to the missing type Object"
      + "\nThe constructor LemmaServiceSubGenerator(OpenAPI, Pair<String, DataModel>, Pair<String, Technology>, String) refers to the missing type OpenAPI"
      + "\nThe field LemmaGenerator.openAPI refers to the missing type /* OpenAPI schema which will be used as source for the generation */\n    OpenAPI"
      + "\nThe method generate(String) from the type LemmaServiceSubGenerator refers to the missing type Object"
      + "\ninfo cannot be resolved"
      + "\ninfo cannot be resolved"
      + "\ninfo cannot be resolved");
  }

  /**
   * Entrypoint for CLI-based standalone execution of the OpenAPI2LEMMA generator
   */
  public static void main(final String[] args) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field CommandLine is undefined"
      + "\nrun cannot be resolved");
  }

  /**
   * Logic for the thread-based standalone execution of the OpenAPI2LEMMA generator
   */
  @Override
  public void run() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LemmaGenerator.LOGGER refers to the missing type Object"
      + "\nThe field LemmaGenerator.LOGGER refers to the missing type Object"
      + "\nThe method isParsed() from the type LemmaGenerator refers to the missing type Object"
      + "\nThe field LemmaGenerator.LOGGER refers to the missing type Object"
      + "\nThe field LemmaGenerator.LOGGER refers to the missing type Object"
      + "\nThe field LemmaGenerator.LOGGER refers to the missing type Object"
      + "\nThe field LemmaGenerator.LOGGER refers to the missing type Object"
      + "\nThe field LemmaGenerator.LOGGER refers to the missing type Object"
      + "\ninfo cannot be resolved"
      + "\ninfo cannot be resolved"
      + "\n! cannot be resolved"
      + "\ninfo cannot be resolved"
      + "\ninfo cannot be resolved"
      + "\ninfo cannot be resolved"
      + "\ninfo cannot be resolved"
      + "\ninfo cannot be resolved");
  }

  /**
   * Exit standalone execution with error return code
   */
  private static void exitWithError(final String message) {
    InputOutput.<String>println(message);
    System.exit(1);
  }
}
