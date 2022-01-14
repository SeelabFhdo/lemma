package de.fhdo.lemma.reconstruction.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.fhdo.lemma.reconstruction.domain.ComplexType;
import de.fhdo.lemma.reconstruction.domain.MetaData;
import de.fhdo.lemma.reconstruction.domain.PrimitiveType;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class Parameter {
  @Accessors
  private String name;
  
  @Accessors
  private PrimitiveType primitiveType;
  
  @Accessors
  private ComplexType complexType;
  
  @Accessors
  private CommunicationType communicationType;
  
  @Accessors
  private ExchangePattern exchangePattern;
  
  @Accessors
  @JsonProperty("metaData")
  private List<MetaData> metaData = CollectionLiterals.<MetaData>newLinkedList();
  
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
  public CommunicationType getCommunicationType() {
    return this.communicationType;
  }
  
  public void setCommunicationType(final CommunicationType communicationType) {
    this.communicationType = communicationType;
  }
  
  @Pure
  public ExchangePattern getExchangePattern() {
    return this.exchangePattern;
  }
  
  public void setExchangePattern(final ExchangePattern exchangePattern) {
    this.exchangePattern = exchangePattern;
  }
  
  @Pure
  public List<MetaData> getMetaData() {
    return this.metaData;
  }
  
  public void setMetaData(final List<MetaData> metaData) {
    this.metaData = metaData;
  }
}
