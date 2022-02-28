package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types;

import com.google.common.base.Objects;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Abstract superclass for argument types.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public abstract class AbstractArgumentType {
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final ArgumentTypeIdentifier identifier;
  
  /**
   * Two argument types are equal if they have the same identifier
   */
  @Override
  public final boolean equals(final Object o) {
    boolean _xifexpression = false;
    if ((o == this)) {
      _xifexpression = true;
    } else {
      boolean _xifexpression_1 = false;
      if ((!(o instanceof AbstractArgumentType))) {
        _xifexpression_1 = false;
      } else {
        _xifexpression_1 = Objects.equal(this.identifier, ((AbstractArgumentType) o).identifier);
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final String name;
  
  private final List<String> possibleValues;
  
  /**
   * Constructor argument types without constrained possible values
   */
  public AbstractArgumentType(final ArgumentTypeIdentifier identifier, final String name) {
    this(identifier, name, CollectionLiterals.<String>emptyList());
  }
  
  /**
   * Constructor
   */
  public AbstractArgumentType(final ArgumentTypeIdentifier identifier, final String name, final List<String> possibleValues) {
    if ((identifier == null)) {
      throw new IllegalArgumentException("Argument type identifier must not be null");
    } else {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(name);
      if (_isNullOrEmpty) {
        throw new IllegalArgumentException("Argument type name must not be null or empty");
      } else {
        if ((possibleValues == null)) {
          throw new IllegalArgumentException("List of possible values must not be null");
        }
      }
    }
    this.identifier = identifier;
    this.name = name;
    this.possibleValues = CollectionLiterals.<String>newArrayList(((String[])Conversions.unwrapArray(possibleValues, String.class)));
    Collections.<String>sort(this.possibleValues);
  }
  
  /**
   * Convert the given value into its internal representation. By default, the given value will be
   * returned. Implementers can override this method to provide argument-type-specific conversion
   * behavior.
   */
  public String convertValueToInternalRepresentation(final String value) {
    return value;
  }
  
  /**
   * Validate the given value in its internal representation w.r.t. a concrete argument type
   * implementation and in the context of the given model processing configuration
   */
  public abstract void validateValueInInternalRepresentation(final ProcessingConfiguration processingConfiguration, final String value);
  
  /**
   * Convert the given value into its user representation. By default, the given value will be
   * returned. Implementers can override this method to provide argument-type-specific conversion
   * behavior.
   */
  public String convertValueToUserRepresentation(final String value) {
    return value;
  }
  
  /**
   * Validate the given value in user representation w.r.t. a concrete argument type
   * implementation and in the context of the given model processing configuration. By default,
   * the method delegates to validateValueInInternalRepresentation(). However, implementers may
   * override it in case a value has a user representation that differs from its internal
   * representation. For example, a value may internally constitute the literal of an enumeration
   * but will be represented to the user as some descriptive text of the literal's semantics. By
   * overriding the method, implementers can react to validation requests resulting from user
   * interactions, e.g., the selection of the descriptive text for a literal of an argument of an
   * enumeration-based type in the arguments table.
   */
  public void validateValueInUserRepresentation(final ProcessingConfiguration processingConfiguration, final String value) {
    this.validateValueInInternalRepresentation(processingConfiguration, value);
  }
  
  /**
   * Get the list of the type's possible values
   */
  public final List<String> getPossibleValues() {
    return Collections.<String>unmodifiableList(this.possibleValues);
  }
  
  @Pure
  public ArgumentTypeIdentifier getIdentifier() {
    return this.identifier;
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
}
