package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds;

import com.google.common.base.Objects;
import java.util.HashMap;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Factory for argument kind creation. Note that the factory caches created argument kinds and
 * returns the same AbstractArgumentKind instance for repeated factory queries for the same argument
 * kinds.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class ArgumentKindFactory {
  private static final HashMap<ArgumentKindIdentifier, AbstractArgumentKind> CREATED_KINDS = CollectionLiterals.<ArgumentKindIdentifier, AbstractArgumentKind>newHashMap();
  
  /**
   * Create an argument kind or return an already created argument kind from the given identifier
   * string. Return null if the identifier string is null or empty.
   */
  public static AbstractArgumentKind fromIdentifier(final String identifierString) {
    AbstractArgumentKind _xifexpression = null;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(identifierString);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      _xifexpression = ArgumentKindFactory.fromIdentifier(ArgumentKindIdentifier.valueOf(identifierString));
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  /**
   * Create an argument kind or return an already created argument kind from the given argument
   * kind identifier. Return null if the identifier is null.
   */
  public static AbstractArgumentKind fromIdentifier(final ArgumentKindIdentifier identifier) {
    if ((identifier == null)) {
      return null;
    }
    final AbstractArgumentKind existingKind = ArgumentKindFactory.CREATED_KINDS.get(identifier);
    if ((existingKind != null)) {
      return existingKind;
    }
    AbstractArgumentKind _switchResult = null;
    boolean _matched = false;
    if (Objects.equal(identifier, ConstantParameterArgumentKind.IDENTIFIER)) {
      _matched=true;
      _switchResult = new ConstantParameterArgumentKind();
    }
    if (!_matched) {
      if (Objects.equal(identifier, MultiValuedParameterArgumentKind.IDENTIFIER)) {
        _matched=true;
        _switchResult = new MultiValuedParameterArgumentKind();
      }
    }
    if (!_matched) {
      if (Objects.equal(identifier, SingleValuedParameterArgumentKind.IDENTIFIER)) {
        _matched=true;
        _switchResult = new SingleValuedParameterArgumentKind();
      }
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"");
      _builder.append(identifier);
      _builder.append("\" not supported");
      String _plus = ("Creation of argument kind with identifier " + _builder);
      throw new IllegalArgumentException(_plus);
    }
    final AbstractArgumentKind createdKind = _switchResult;
    ArgumentKindFactory.CREATED_KINDS.put(identifier, createdKind);
    return createdKind;
  }
}
