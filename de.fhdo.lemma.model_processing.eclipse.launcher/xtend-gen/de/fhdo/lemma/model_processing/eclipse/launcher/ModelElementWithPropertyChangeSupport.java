package de.fhdo.lemma.model_processing.eclipse.launcher;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Superclass for all concepts of the domain model of the model processing launch configuration that
 * support property changes and that must immediately inform dependent elements ("listeners") about
 * property changes.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ModelElementWithPropertyChangeSupport {
  private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

  /**
   * Register a property change listener
   */
  public void addPropertyChangeListener(final PropertyChangeListener listener) {
    this.changeSupport.addPropertyChangeListener(listener);
  }

  /**
   * Remove a property change listener
   */
  public void removePropertyChangeListener(final PropertyChangeListener listener) {
    this.changeSupport.removePropertyChangeListener(listener);
  }

  /**
   * Inform listeners about a property change
   */
  protected void firePropertyChange(final String propertyName, final Object oldValue, final Object newValue) {
    this.changeSupport.firePropertyChange(propertyName, oldValue, newValue);
  }

  /**
   * Get all registered property change listeners
   */
  protected PropertyChangeListener[] getPropertyChangeListeners() {
    return this.changeSupport.getPropertyChangeListeners();
  }
}
