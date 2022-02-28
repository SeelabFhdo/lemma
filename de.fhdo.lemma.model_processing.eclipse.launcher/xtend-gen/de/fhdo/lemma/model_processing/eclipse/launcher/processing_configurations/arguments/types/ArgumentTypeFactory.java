package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types;

import com.google.common.base.Objects;
import java.util.HashMap;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Factory for argument type creation. Note that the factory caches created argument types and
 * returns the same AbstractArgumentType instance for repeated factory queries for the same argument
 * types.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class ArgumentTypeFactory {
  private static final HashMap<ArgumentTypeIdentifier, AbstractArgumentType> CREATED_TYPES = CollectionLiterals.<ArgumentTypeIdentifier, AbstractArgumentType>newHashMap();
  
  /**
   * Create an argument type or return an already created argument type from the given identifier
   * string. Return null if the identifier string is null or empty.
   */
  public static AbstractArgumentType fromIdentifier(final String identifierString) {
    AbstractArgumentType _xifexpression = null;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(identifierString);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      _xifexpression = ArgumentTypeFactory.fromIdentifier(ArgumentTypeIdentifier.valueOf(identifierString));
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  /**
   * Create an argument type or return an already created argument type from the given argument
   * type identifier. Return null if the identifier is null.
   */
  public static AbstractArgumentType fromIdentifier(final ArgumentTypeIdentifier identifier) {
    if ((identifier == null)) {
      return null;
    }
    final AbstractArgumentType existingType = ArgumentTypeFactory.CREATED_TYPES.get(identifier);
    if ((existingType != null)) {
      return existingType;
    }
    AbstractArgumentType _switchResult = null;
    boolean _matched = false;
    if (Objects.equal(identifier, FileArgumentType.IDENTIFIER)) {
      _matched=true;
      _switchResult = new FileArgumentType();
    }
    if (!_matched) {
      if (Objects.equal(identifier, FolderArgumentType.IDENTIFIER)) {
        _matched=true;
        _switchResult = new FolderArgumentType();
      }
    }
    if (!_matched) {
      if (Objects.equal(identifier, IntermediateModelArgumentType.IDENTIFIER)) {
        _matched=true;
        _switchResult = new IntermediateModelArgumentType();
      }
    }
    if (!_matched) {
      if (Objects.equal(identifier, IntermediateModelOfFirstImportArgumentType.IDENTIFIER)) {
        _matched=true;
        _switchResult = new IntermediateModelOfFirstImportArgumentType();
      }
    }
    if (!_matched) {
      if (Objects.equal(identifier, IntermediateModelsOfAllImportsArgumentType.IDENTIFIER)) {
        _matched=true;
        _switchResult = new IntermediateModelsOfAllImportsArgumentType();
      }
    }
    if (!_matched) {
      if (Objects.equal(identifier, IntermediateModelOfImportWithAliasArgumentType.IDENTIFIER)) {
        _matched=true;
        _switchResult = new IntermediateModelOfImportWithAliasArgumentType();
      }
    }
    if (!_matched) {
      if (Objects.equal(identifier, RawStringArgumentType.IDENTIFIER)) {
        _matched=true;
        _switchResult = new RawStringArgumentType();
      }
    }
    if (!_matched) {
      if (Objects.equal(identifier, SourceModelArgumentType.IDENTIFIER)) {
        _matched=true;
        _switchResult = new SourceModelArgumentType();
      }
    }
    if (!_matched) {
      if (Objects.equal(identifier, StringPairArgumentType.IDENTIFIER)) {
        _matched=true;
        _switchResult = new StringPairArgumentType();
      }
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"");
      _builder.append(identifier);
      _builder.append("\" not supported");
      String _plus = ("Creation of argument type with identifier " + _builder);
      throw new IllegalArgumentException(_plus);
    }
    final AbstractArgumentType createdType = _switchResult;
    ArgumentTypeFactory.CREATED_TYPES.put(identifier, createdType);
    return createdType;
  }
}
