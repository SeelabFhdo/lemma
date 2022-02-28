package de.fhdo.lemma.model_processing.eclipse.launcher

import java.beans.PropertyChangeSupport
import java.beans.PropertyChangeListener

/**
 * Superclass for all concepts of the domain model of the model processing launch configuration that
 * support property changes and that must immediately inform dependent elements ("listeners") about
 * property changes.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ModelElementWithPropertyChangeSupport {
    val changeSupport = new PropertyChangeSupport(this)

    /**
     * Register a property change listener
     */
    def void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    /**
     * Remove a property change listener
     */
    def void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener)
    }

    /**
     * Inform listeners about a property change
     */
    protected def void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        changeSupport.firePropertyChange(propertyName, oldValue, newValue)
    }

    /**
     * Get all registered property change listeners
     */
    protected def getPropertyChangeListeners() {
        return changeSupport.getPropertyChangeListeners()
    }
}