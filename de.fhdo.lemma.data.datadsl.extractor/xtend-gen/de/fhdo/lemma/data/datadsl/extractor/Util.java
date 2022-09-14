package de.fhdo.lemma.data.datadsl.extractor;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.Context;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataOperation;
import de.fhdo.lemma.data.DataOperationParameter;
import de.fhdo.lemma.data.EnumerationField;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * This class collects _static_ utility methods for the Data DSL extractor.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class Util {
  /**
   * Build the qualified name for an EObject that is an instance of a concept from the Data DSL
   */
  public static String qualifiedName(final EObject eObject) {
    String _switchResult = null;
    boolean _matched = false;
    if (eObject instanceof Context) {
      _matched=true;
      _switchResult = ((Context)eObject).buildQualifiedName(".");
    }
    if (!_matched) {
      if (eObject instanceof ComplexType) {
        _matched=true;
        _switchResult = ((ComplexType)eObject).buildQualifiedName(".");
      }
    }
    if (!_matched) {
      if (eObject instanceof DataOperation) {
        _matched=true;
        _switchResult = ((DataOperation)eObject).buildQualifiedName(".");
      }
    }
    if (!_matched) {
      if (eObject instanceof DataOperationParameter) {
        _matched=true;
        _switchResult = ((DataOperationParameter)eObject).buildQualifiedName(".");
      }
    }
    if (!_matched) {
      if (eObject instanceof DataField) {
        _matched=true;
        _switchResult = ((DataField)eObject).buildQualifiedName(".");
      }
    }
    if (!_matched) {
      if (eObject instanceof EnumerationField) {
        _matched=true;
        _switchResult = ((EnumerationField)eObject).buildQualifiedName(".");
      }
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("EObjects of type ");
      String _simpleName = eObject.getClass().getSimpleName();
      _builder.append(_simpleName);
      _builder.append(" is not supported");
      String _plus = ("Building fully-qualified name for " + _builder);
      throw new IllegalArgumentException(_plus);
    }
    return _switchResult;
  }
  
  /**
   * Calculate the relative qualifier of a full qualifier relative to another full qualifier. For
   * example, the relative qualifier of the full qualifier "org.example.lemma.data.Structure" in
   * the context of another full qualifier "org.example.lemma" is "data.Structure".
   */
  public static String calculateRelativeQualifier(final String qualifier, final String relativeTo) {
    final List<String> qualifierParts = IterableExtensions.<String>toList(((Iterable<String>)Conversions.doWrapArray(qualifier.split("\\."))));
    final String[] relativeToParts = relativeTo.split("\\.");
    final int minIndex = Math.min(qualifierParts.size(), ((List<String>)Conversions.doWrapArray(relativeToParts)).size());
    int index = 0;
    int differenceIndex = (-1);
    while (((index < minIndex) && (differenceIndex == (-1)))) {
      {
        String _get = qualifierParts.get(index);
        Object _get_1 = relativeToParts[index];
        boolean _notEquals = (!Objects.equal(_get, _get_1));
        if (_notEquals) {
          differenceIndex = index;
        }
        index++;
      }
    }
    return Util.joinFromIndex(qualifierParts, ".", differenceIndex);
  }
  
  /**
   * Join entries of an Iterable separated by an arbitrary String and starting from a given
   * (inclusive) index
   */
  public static String joinFromIndex(final Iterable<?> iterable, final String separator, final int index) {
    final Function1<Pair<Integer, Object>, Boolean> _function = (Pair<Integer, Object> it) -> {
      Integer _key = it.getKey();
      return Boolean.valueOf(((_key).intValue() >= index));
    };
    final Function1<Pair<Integer, Object>, Object> _function_1 = (Pair<Integer, Object> it) -> {
      return it.getValue();
    };
    final Iterable<Object> joinElements = IterableExtensions.<Pair<Integer, Object>, Object>map(IterableExtensions.<Pair<Integer, Object>>filter(IterableExtensions.<Object>indexed(iterable), _function), _function_1);
    return IterableExtensions.join(joinElements, separator);
  }
  
  /**
   * List of reserved keywords of the Data DSL
   */
  private static final List<String> RESERVED_KEYWORDS = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("as", "collection", "context", "datatypes", "enum", "from", "import", "structure", "version"));
  
  /**
   * Escape Data DSL keyword
   */
  public static String lemmaName(final String name) {
    String _xifexpression = null;
    boolean _contains = Util.RESERVED_KEYWORDS.contains(name);
    if (_contains) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("^");
      _builder.append(name);
      _xifexpression = _builder.toString();
    } else {
      _xifexpression = name;
    }
    return _xifexpression;
  }
}
