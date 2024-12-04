package de.fhdo.lemma.reconstruction.util;

import de.fhdo.lemma.data.DataFactory;
import de.fhdo.lemma.data.PrimitiveType;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Utility class for creating LEMMA models from reconstructed architecture information
 * in a database.
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@SuppressWarnings("all")
public class Util {
  private static final DataFactory DATA_FACTORY = DataFactory.eINSTANCE;

  /**
   * Get a LEMMA primitive type based on a string
   */
  public static PrimitiveType getPrimitiveFrom(final String type) {
    PrimitiveType _switchResult = null;
    String _lowerCase = type.toLowerCase();
    if (_lowerCase != null) {
      switch (_lowerCase) {
        case "boolean":
          _switchResult = Util.DATA_FACTORY.createPrimitiveBoolean();
          break;
        case "byte":
          _switchResult = Util.DATA_FACTORY.createPrimitiveByte();
          break;
        case "character":
          _switchResult = Util.DATA_FACTORY.createPrimitiveCharacter();
          break;
        case "date":
          _switchResult = Util.DATA_FACTORY.createPrimitiveDate();
          break;
        case "double":
          _switchResult = Util.DATA_FACTORY.createPrimitiveDouble();
          break;
        case "float":
          _switchResult = Util.DATA_FACTORY.createPrimitiveFloat();
          break;
        case "int":
          _switchResult = Util.DATA_FACTORY.createPrimitiveInteger();
          break;
        case "integer":
          _switchResult = Util.DATA_FACTORY.createPrimitiveInteger();
          break;
        case "long":
          _switchResult = Util.DATA_FACTORY.createPrimitiveLong();
          break;
        case "short":
          _switchResult = Util.DATA_FACTORY.createPrimitiveShort();
          break;
        case "string":
          _switchResult = Util.DATA_FACTORY.createPrimitiveString();
          break;
        default:
          _switchResult = Util.DATA_FACTORY.createPrimitiveUnspecified();
          break;
      }
    } else {
      _switchResult = Util.DATA_FACTORY.createPrimitiveUnspecified();
    }
    return _switchResult;
  }

  /**
   * Capitalizes a word in a string after a given split operator
   */
  public static String capitalizeWords(final String splitOperator, final String term) {
    final String[] parts = term.split(splitOperator);
    final StringBuilder stringBuilder = new StringBuilder();
    final Consumer<String> _function = (String it) -> {
      stringBuilder.append(StringExtensions.toFirstUpper(it));
    };
    ((List<String>)Conversions.doWrapArray(parts)).forEach(_function);
    return stringBuilder.toString();
  }

  /**
   * Get the context name for a element based on it's qualified name
   */
  public static String getContextNameFromQualifedName(final String qualifedName) {
    final String[] nameParts = qualifedName.split("\\W");
    int _size = ((List<String>)Conversions.doWrapArray(nameParts)).size();
    int _minus = (_size - 2);
    final String contextName = StringExtensions.toFirstUpper(nameParts[_minus]);
    return contextName;
  }

  /**
   * Mask a model a adding a '^' in front of LEMMA specific key word in order to
   * avoid syntax errors in generated models based on reconstructed architecture information
   */
  public static List<String> maskModel(final String path, final List<Issue> issues) {
    try {
      final String idMessage = "(mismatched input \'){1}(.)+(expecting RULE_ID)";
      FileReader _fileReader = new FileReader(path);
      final BufferedReader reader = new BufferedReader(_fileReader);
      final List<String> lines = IteratorExtensions.<String>toList(reader.lines().iterator());
      final Consumer<Issue> _function = (Issue issue) -> {
        boolean _matches = issue.getMessage().matches(idMessage);
        if (_matches) {
          Integer _lineNumber = issue.getLineNumber();
          final int lineNumber = ((_lineNumber).intValue() - 1);
          Integer _column = issue.getColumn();
          final int position = ((_column).intValue() - 1);
          final String line = lines.get(lineNumber);
          String _substring = line.substring(0, position);
          String _plus = (_substring + "^");
          String _substring_1 = line.substring(position);
          final String maskedLine = (_plus + _substring_1);
          lines.set(lineNumber, maskedLine);
        }
      };
      issues.forEach(_function);
      return lines;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Mask LEMMA-specifc keyword in a given line of a lemma model
   */
  public static String maskLemmaKeywords(final String line, final char markChar, final int position) {
    String _substring = line.substring(0, position);
    String _plus = (_substring + Character.valueOf(markChar));
    String _substring_1 = line.substring(position);
    return (_plus + _substring_1);
  }

  /**
   * Remove the last part of a URI to get the folder of a given URI
   */
  public static String removeLastFolderFromURI(final String uri) {
    final int lastIndex = uri.lastIndexOf("/");
    final String shortUri = uri.substring(0, lastIndex);
    return shortUri;
  }

  /**
   * Remove leading and ending quotation marks of a text
   */
  public static String removeFirstAndLastQuotationMark(final String text) {
    if ((((text.length() > 1) && text.startsWith("\"")) && text.endsWith("\""))) {
      int _length = text.length();
      int _minus = (_length - 1);
      final String result = text.substring(1, _minus);
      return result;
    } else {
      return text;
    }
  }
}
