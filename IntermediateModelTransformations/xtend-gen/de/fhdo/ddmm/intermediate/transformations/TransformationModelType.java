package de.fhdo.ddmm.intermediate.transformations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * A type of a transformation model.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class TransformationModelType {
  /**
   * URI of the Ecore namespace
   */
  @Accessors
  private String namespaceUri;
  
  /**
   * EPackage instance
   */
  @Accessors
  private EPackage ecorePackage;
  
  /**
   * Root class of the model
   */
  @Accessors
  private Class<? extends EObject> rootClass;
  
  /**
   * Constructor
   */
  public TransformationModelType(final String namespaceUri, final EPackage ePackage, final Class<? extends EObject> rootClass) {
    this.namespaceUri = namespaceUri;
    this.ecorePackage = ePackage;
    this.rootClass = rootClass;
  }
  
  @Pure
  public String getNamespaceUri() {
    return this.namespaceUri;
  }
  
  public void setNamespaceUri(final String namespaceUri) {
    this.namespaceUri = namespaceUri;
  }
  
  @Pure
  public EPackage getEcorePackage() {
    return this.ecorePackage;
  }
  
  public void setEcorePackage(final EPackage ecorePackage) {
    this.ecorePackage = ecorePackage;
  }
  
  @Pure
  public Class<? extends EObject> getRootClass() {
    return this.rootClass;
  }
  
  public void setRootClass(final Class<? extends EObject> rootClass) {
    this.rootClass = rootClass;
  }
}
