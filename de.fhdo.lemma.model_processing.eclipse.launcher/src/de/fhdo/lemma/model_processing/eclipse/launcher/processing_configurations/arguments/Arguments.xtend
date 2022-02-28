package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments

import de.fhdo.lemma.model_processing.eclipse.launcher.ModelElementWithPropertyChangeSupport
import java.util.List
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import java.beans.PropertyChangeListener
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractArgumentType

/**
 * Domain concept representing a list of model processing configuration arguments.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class Arguments extends ModelElementWithPropertyChangeSupport {
    var List<Argument> arguments = newArrayList

    /**
     * Constructor. The creation of an Arguments instance will also fire a corresponding property
     * change event with a flat copy of the given list of Argument instances.
     */
    new(List<Argument> arguments) {
        firePropertyChange("arguments", flatCopy(this.arguments), this.arguments = arguments)
    }

    /**
     * Add a property change listener to the list of arguments. Note that property change listeners
     * on argument lists are transitive, i.e., they are assigned to the list but also all Argument
     * instances in the list. Thus, listeners get called not only when the list changes but also
     * when one of its Argument entries changes.
     */
    final override addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener)
        arguments.forEach[it.addPropertyChangeListener(listener)]
    }

    /**
     * Remove a property change listener from the arguments list and all of its entries
     */
    final override removePropertyChangeListener(PropertyChangeListener listener) {
        super.removePropertyChangeListener(listener)
        arguments.forEach[it.removePropertyChangeListener(listener)]
    }

    /**
     * Add a new Argument instance to the end of the list and fire a corresponding property change
     * event. Note that before firing the event, the argument also receives all previously added
     * property change listeners and thus will also be able to react to the fired event.
     */
    final def add(Argument argument) {
        propertyChangeListeners.forEach[argument.addPropertyChangeListener(it)]
        firePropertyChange("arguments", flatCopy(arguments),
            arguments = addInPlace(arguments, argument))
    }

    /**
     * Check if the given Argument instance is part of the list. Checking is based on the equality
     * of the given argument's kind, type, parameter, and value with at least one entry in the list.
     */
    final def contains(Argument argument) {
        return arguments.exists[
            kind == argument.kind &&
            type == argument.type &&
            parameter == argument.parameter &&
            value == argument.value
        ]
    }

    /**
     * Get all Argument instances
     */
    final def get() {
        return arguments.unmodifiableView
    }

    /**
     * Get all Argument instances whose types are of the given class
     */
    final def get(Class<? extends AbstractArgumentType> argumentTypeClass) {
        return arguments
            .filter[argumentTypeClass.isAssignableFrom(it.type.class)]
            .toList()
            .unmodifiableView
    }

    /**
     * Move the given Argument instance one index up the list and fire a corresponding property
     * change event
     */
    final def moveUp(Argument argument) {
        firePropertyChange("arguments", flatCopy(arguments),
            arguments = moveUpInPlace(arguments, argument))
    }

    /**
     * Move the given Argument instance one index down the list and fire a corresponding property
     * change event
     */
    final def moveDown(Argument argument) {
        firePropertyChange("arguments", flatCopy(arguments),
            arguments = moveDownInPlace(arguments, argument))
    }

    /**
     * Remove the given Argument instance from the list and fire a corresponding property change
     * event
     */
    final def remove(Argument argument) {
        propertyChangeListeners.forEach[argument.removePropertyChangeListener(it)]
        firePropertyChange("arguments", flatCopy(arguments),
            arguments = removeInPlace(arguments, argument))
    }

    /**
     * Remove all given Argument instances from the list and fire a corresponding property change
     * event
     */
    final def removeAll(List<Argument> argumentsToRemove) {
        propertyChangeListeners.forEach[propertyChangeListener |
            argumentsToRemove.forEach[it.removePropertyChangeListener(propertyChangeListener)]
        ]
        firePropertyChange("arguments", flatCopy(arguments),
            arguments = removeAllInPlace(arguments, argumentsToRemove))
    }
}