package de.fhdo.lemma.reconstruction.domain;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class ComplexType {
  @Accessors
  private String name;
  
  @Accessors
  private String qualifiedName;
  
  @Accessors
  private ClassType classType;
  
  public ComplexType() {
  }
  
  public ComplexType(final String name, final String qualifedName, final ClassType classType) {
    this.name = name;
    this.qualifiedName = qualifedName;
    this.classType = classType;
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  @Pure
  public String getQualifiedName() {
    return this.qualifiedName;
  }
  
  public void setQualifiedName(final String qualifiedName) {
    this.qualifiedName = qualifiedName;
  }
  
  @Pure
  public ClassType getClassType() {
    return this.classType;
  }
  
  public void setClassType(final ClassType classType) {
    this.classType = classType;
  }
}
