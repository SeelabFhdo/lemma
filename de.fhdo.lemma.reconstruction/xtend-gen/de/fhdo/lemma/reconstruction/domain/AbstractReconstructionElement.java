package de.fhdo.lemma.reconstruction.domain;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractReconstructionElement {
  @Accessors
  private String name;
  
  @Accessors
  private String qualifiedContextName;
  
  public AbstractReconstructionElement() {
  }
  
  public AbstractReconstructionElement(final String name, final String qualifiedContextName) {
    this.name = name;
    this.qualifiedContextName = qualifiedContextName;
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  @Pure
  public String getQualifiedContextName() {
    return this.qualifiedContextName;
  }
  
  public void setQualifiedContextName(final String qualifiedContextName) {
    this.qualifiedContextName = qualifiedContextName;
  }
}
