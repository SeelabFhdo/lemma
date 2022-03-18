package de.fhdo.lemma.reconstruction.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.fhdo.lemma.reconstruction.domain.MetaData;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class Operation {
  @Accessors
  private String name;
  
  @Accessors
  @JsonProperty("parameters")
  private List<Parameter> parameters = CollectionLiterals.<Parameter>newLinkedList();
  
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
  public List<Parameter> getParameters() {
    return this.parameters;
  }
  
  public void setParameters(final List<Parameter> parameters) {
    this.parameters = parameters;
  }
  
  @Pure
  public List<MetaData> getMetaData() {
    return this.metaData;
  }
  
  public void setMetaData(final List<MetaData> metaData) {
    this.metaData = metaData;
  }
}
