package de.fhdo.lemma.reconstruction.domain;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class PrimitiveType {
  @Accessors
  private String name;
  
  public PrimitiveType() {
  }
  
  public PrimitiveType(final String name) {
    this.name = name;
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
}
