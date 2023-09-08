package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Abstract superclass for argument types that are based on enumerations whose literals determine
 * types' valid values.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public abstract class AbstractArgumentTypeWithEnumValueSelection<T extends Enum<?>> extends AbstractArgumentType {
  private final List<String> literalDescriptionsSorted;

  private final String enumClassName;

  private final BiMap<String, String> literalNamesAndDescriptions;

  /**
   * Constructor. Note that the descriptions in the map of literal descriptions must be unique to
   * allow unambiguous identification of a literal from its description (which is the user
   * representation of the value of an argument with this enumeration-based type).
   */
  public AbstractArgumentTypeWithEnumValueSelection(final ArgumentTypeIdentifier identifier, final String name, final Map<T, String> literalsAndDescriptions) {
    super(identifier, name);
    boolean _isEmpty = literalsAndDescriptions.isEmpty();
    if (_isEmpty) {
      throw new IllegalArgumentException("No literal descriptions given");
    }
    this.literalDescriptionsSorted = IterableExtensions.<String>sort(literalsAndDescriptions.values());
    this.enumClassName = IterableExtensions.<T>toList(literalsAndDescriptions.keySet()).get(0).getClass().getSimpleName();
    int _size = literalsAndDescriptions.values().size();
    int _size_1 = IterableExtensions.<String>toSet(literalsAndDescriptions.values()).size();
    boolean _notEquals = (_size != _size_1);
    if (_notEquals) {
      throw new IllegalArgumentException(("Duplicate descriptions for enum " + this.enumClassName));
    }
    final Function1<T, String> _function = (T it) -> {
      return it.name();
    };
    final Function1<T, String> _function_1 = (T it) -> {
      return literalsAndDescriptions.get(it);
    };
    this.literalNamesAndDescriptions = HashBiMap.<String, String>create(
      IterableExtensions.<T, String, String>toMap(literalsAndDescriptions.keySet(), _function, _function_1));
  }

  /**
   * Get the description of the given literal
   */
  public final String getLiteralDescription(final T literal) {
    return this.getLiteralDescription(literal.name());
  }

  /**
   * Convert the given literal description into its internal representation, i.e., the name of the
   * the literal, for this enumeration-based type
   */
  @Override
  public final String convertValueToInternalRepresentation(final String literalDescription) {
    return this.getLiteralName(literalDescription);
  }

  /**
   * Get the name of the literal from the given description
   */
  public final String getLiteralName(final String literalDescription) {
    return this.literalNamesAndDescriptions.inverse().get(literalDescription);
  }

  /**
   * Validate the internal value, i.e., the name of the literal, of an argument of this
   * enumeration-based type
   */
  @Override
  public final void validateValueInInternalRepresentation(final ProcessingConfiguration processingConfiguration, final String literalName) {
    boolean _contains = this.literalNamesAndDescriptions.keySet().contains(literalName);
    boolean _not = (!_contains);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Invalid literal name \"");
      _builder.append(literalName);
      _builder.append("\" for ");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("enum ");
      _builder_1.append(this.enumClassName);
      String _plus = (_builder.toString() + _builder_1);
      throw new IllegalArgumentException(_plus);
    }
  }

  /**
   * Convert the given literal name into its user representation, i.e., the description of the
   * the literal, for this enumeration-based type
   */
  @Override
  public final String convertValueToUserRepresentation(final String literalName) {
    return this.getLiteralDescription(literalName);
  }

  /**
   * Get the description of the literal with the given name
   */
  public final String getLiteralDescription(final String literalName) {
    return this.literalNamesAndDescriptions.get(literalName);
  }

  /**
   * Validate the user value, i.e., the description of the literal, of an argument of this
   * enumeration-based type. Implementers may override this method to accompany user validation
   * with additional checks. However, overridden methods must invoke this method on the
   * superclass.
   */
  @Override
  public void validateValueInUserRepresentation(final ProcessingConfiguration configuration, final String literalDescription) {
    boolean _contains = this.literalNamesAndDescriptions.inverse().keySet().contains(literalDescription);
    boolean _not = (!_contains);
    if (_not) {
      String _join = IterableExtensions.join(this.literalDescriptionsSorted, ", ");
      String _plus = ("Please select a value from the following: " + _join);
      throw new IllegalArgumentException(_plus);
    }
  }

  /**
   * Get the literal descriptions in alphabetic order
   */
  public final List<String> getLiteralDescriptionsSorted() {
    return Collections.<String>unmodifiableList(this.literalDescriptionsSorted);
  }
}
