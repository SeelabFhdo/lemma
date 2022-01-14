package de.fhdo.lemma.reconstruction.util;

import de.fhdo.lemma.data.DataFactory;
import de.fhdo.lemma.data.PrimitiveType;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Util {
  private static final DataFactory DATA_FACTORY = DataFactory.eINSTANCE;
  
  public static PrimitiveType getPrimitiveFrom(final String type) {
    PrimitiveType _switchResult = null;
    if (type != null) {
      switch (type) {
        case "boolean":
          _switchResult = Util.DATA_FACTORY.createPrimitiveBoolean();
          break;
        case "Byte":
          _switchResult = Util.DATA_FACTORY.createPrimitiveByte();
          break;
        case "Character":
          _switchResult = Util.DATA_FACTORY.createPrimitiveCharacter();
          break;
        case "Date":
          _switchResult = Util.DATA_FACTORY.createPrimitiveDate();
          break;
        case "Double":
          _switchResult = Util.DATA_FACTORY.createPrimitiveDouble();
          break;
        case "float":
          _switchResult = Util.DATA_FACTORY.createPrimitiveFloat();
          break;
        case "int":
          _switchResult = Util.DATA_FACTORY.createPrimitiveInteger();
          break;
        case "Long":
          _switchResult = Util.DATA_FACTORY.createPrimitiveLong();
          break;
        case "Short":
          _switchResult = Util.DATA_FACTORY.createPrimitiveShort();
          break;
        case "String":
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
  
  public static String capitalizeWords(final String splitOperator, final String term) {
    final String[] parts = term.split(splitOperator);
    final StringBuilder stringBuilder = new StringBuilder();
    final Consumer<String> _function = (String it) -> {
      stringBuilder.append(StringExtensions.toFirstUpper(it));
    };
    ((List<String>)Conversions.doWrapArray(parts)).forEach(_function);
    return stringBuilder.toString();
  }
}
