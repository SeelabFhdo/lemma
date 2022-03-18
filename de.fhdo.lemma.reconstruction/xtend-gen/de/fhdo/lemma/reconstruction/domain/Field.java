package de.fhdo.lemma.reconstruction.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class Field {
  @Accessors
  private String name;
  
  @Accessors
  private PrimitiveType primitiveType;
  
  @Accessors
  private ComplexType complexType;
  
  @Accessors
  @JsonProperty("metaData")
  private List<MetaData> metaData = CollectionLiterals.<MetaData>newLinkedList();
  
  public Field() {
  }
  
  public Field(final String name, final String visibility) {
    this.name = name;
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  @Pure
  public PrimitiveType getPrimitiveType() {
    return this.primitiveType;
  }
  
  public void setPrimitiveType(final PrimitiveType primitiveType) {
    this.primitiveType = primitiveType;
  }
  
  @Pure
  public ComplexType getComplexType() {
    return this.complexType;
  }
  
  public void setComplexType(final ComplexType complexType) {
    this.complexType = complexType;
  }
  
  @Pure
  public List<MetaData> getMetaData() {
    return this.metaData;
  }
  
  public void setMetaData(final List<MetaData> metaData) {
    this.metaData = metaData;
  }
}
