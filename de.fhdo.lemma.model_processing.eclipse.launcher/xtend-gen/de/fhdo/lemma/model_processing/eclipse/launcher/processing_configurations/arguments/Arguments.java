package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments;

import com.google.common.base.Objects;
import de.fhdo.lemma.model_processing.eclipse.launcher.ModelElementWithPropertyChangeSupport;
import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractArgumentType;
import java.beans.PropertyChangeListener;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Domain concept representing a list of model processing configuration arguments.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class Arguments extends ModelElementWithPropertyChangeSupport {
  private List<Argument> arguments = CollectionLiterals.<Argument>newArrayList();

  /**
   * Constructor. The creation of an Arguments instance will also fire a corresponding property
   * change event with a flat copy of the given list of Argument instances.
   */
  public Arguments(final List<Argument> arguments) {
    this.firePropertyChange("arguments", Utils.<Argument>flatCopy(this.arguments), this.arguments = arguments);
  }

  /**
   * Add a property change listener to the list of arguments. Note that property change listeners
   * on argument lists are transitive, i.e., they are assigned to the list but also all Argument
   * instances in the list. Thus, listeners get called not only when the list changes but also
   * when one of its Argument entries changes.
   */
  @Override
  public final void addPropertyChangeListener(final PropertyChangeListener listener) {
    super.addPropertyChangeListener(listener);
    final Consumer<Argument> _function = (Argument it) -> {
      it.addPropertyChangeListener(listener);
    };
    this.arguments.forEach(_function);
  }

  /**
   * Remove a property change listener from the arguments list and all of its entries
   */
  @Override
  public final void removePropertyChangeListener(final PropertyChangeListener listener) {
    super.removePropertyChangeListener(listener);
    final Consumer<Argument> _function = (Argument it) -> {
      it.removePropertyChangeListener(listener);
    };
    this.arguments.forEach(_function);
  }

  /**
   * Add a new Argument instance to the end of the list and fire a corresponding property change
   * event. Note that before firing the event, the argument also receives all previously added
   * property change listeners and thus will also be able to react to the fired event.
   */
  public final void add(final Argument argument) {
    final Consumer<PropertyChangeListener> _function = (PropertyChangeListener it) -> {
      argument.addPropertyChangeListener(it);
    };
    ((List<PropertyChangeListener>)Conversions.doWrapArray(this.getPropertyChangeListeners())).forEach(_function);
    this.firePropertyChange("arguments", Utils.<Argument>flatCopy(this.arguments), 
      this.arguments = Utils.<Argument>addInPlace(this.arguments, argument));
  }

  /**
   * Check if the given Argument instance is part of the list. Checking is based on the equality
   * of the given argument's kind, type, parameter, and value with at least one entry in the list.
   */
  public final boolean contains(final Argument argument) {
    final Function1<Argument, Boolean> _function = (Argument it) -> {
      return Boolean.valueOf((((Objects.equal(it.getKind(), argument.getKind()) && 
        Objects.equal(it.getType(), argument.getType())) && 
        Objects.equal(it.getParameter(), argument.getParameter())) && 
        Objects.equal(it.getValue(), argument.getValue())));
    };
    return IterableExtensions.<Argument>exists(this.arguments, _function);
  }

  /**
   * Get all Argument instances
   */
  public final List<Argument> get() {
    return Collections.<Argument>unmodifiableList(this.arguments);
  }

  /**
   * Get all Argument instances whose types are of the given class
   */
  public final List<Argument> get(final Class<? extends AbstractArgumentType> argumentTypeClass) {
    final Function1<Argument, Boolean> _function = (Argument it) -> {
      return Boolean.valueOf(argumentTypeClass.isAssignableFrom(it.getType().getClass()));
    };
    return Collections.<Argument>unmodifiableList(IterableExtensions.<Argument>toList(IterableExtensions.<Argument>filter(this.arguments, _function)));
  }

  /**
   * Move the given Argument instance one index up the list and fire a corresponding property
   * change event
   */
  public final void moveUp(final Argument argument) {
    this.firePropertyChange("arguments", Utils.<Argument>flatCopy(this.arguments), 
      this.arguments = Utils.<Argument>moveUpInPlace(this.arguments, argument));
  }

  /**
   * Move the given Argument instance one index down the list and fire a corresponding property
   * change event
   */
  public final void moveDown(final Argument argument) {
    this.firePropertyChange("arguments", Utils.<Argument>flatCopy(this.arguments), 
      this.arguments = Utils.<Argument>moveDownInPlace(this.arguments, argument));
  }

  /**
   * Remove the given Argument instance from the list and fire a corresponding property change
   * event
   */
  public final void remove(final Argument argument) {
    final Consumer<PropertyChangeListener> _function = (PropertyChangeListener it) -> {
      argument.removePropertyChangeListener(it);
    };
    ((List<PropertyChangeListener>)Conversions.doWrapArray(this.getPropertyChangeListeners())).forEach(_function);
    this.firePropertyChange("arguments", Utils.<Argument>flatCopy(this.arguments), 
      this.arguments = Utils.<Argument>removeInPlace(this.arguments, argument));
  }

  /**
   * Remove all given Argument instances from the list and fire a corresponding property change
   * event
   */
  public final void removeAll(final List<Argument> argumentsToRemove) {
    final Consumer<PropertyChangeListener> _function = (PropertyChangeListener propertyChangeListener) -> {
      final Consumer<Argument> _function_1 = (Argument it) -> {
        it.removePropertyChangeListener(propertyChangeListener);
      };
      argumentsToRemove.forEach(_function_1);
    };
    ((List<PropertyChangeListener>)Conversions.doWrapArray(this.getPropertyChangeListeners())).forEach(_function);
    this.firePropertyChange("arguments", Utils.<Argument>flatCopy(this.arguments), 
      this.arguments = Utils.<Argument>removeAllInPlace(this.arguments, argumentsToRemove));
  }
}
