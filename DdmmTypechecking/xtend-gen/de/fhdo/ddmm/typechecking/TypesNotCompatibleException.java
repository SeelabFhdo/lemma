package de.fhdo.ddmm.typechecking;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class TypesNotCompatibleException extends Exception {
  public TypesNotCompatibleException(final String targetTypeName, final String sourceTypeName) {
    super(new Function0<String>() {
      public String apply() {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Types ");
        _builder.append(targetTypeName);
        _builder.append(" and ");
        _builder.append(sourceTypeName);
        _builder.append(" are not compatible.");
        return _builder.toString();
      }
    }.apply());
  }
}
