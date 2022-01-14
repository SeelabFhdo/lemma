package de.fhdo.lemma.reconstruction.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.fhdo.lemma.reconstruction.domain.MetaData;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class Interface {
  @Accessors
  private String name;
  
  @Accessors
  private String version;
  
  @Accessors
  private String visibility;
  
  @Accessors
  @JsonProperty("metaData")
  private List<MetaData> metaData = CollectionLiterals.<MetaData>newLinkedList();
  
  @Accessors
  @JsonProperty("operations")
  private List<Operation> operations = CollectionLiterals.<Operation>newLinkedList();
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  @Pure
  public String getVersion() {
    return this.version;
  }
  
  public void setVersion(final String version) {
    this.version = version;
  }
  
  @Pure
  public String getVisibility() {
    return this.visibility;
  }
  
  public void setVisibility(final String visibility) {
    this.visibility = visibility;
  }
  
  @Pure
  public List<MetaData> getMetaData() {
    return this.metaData;
  }
  
  public void setMetaData(final List<MetaData> metaData) {
    this.metaData = metaData;
  }
  
  @Pure
  public List<Operation> getOperations() {
    return this.operations;
  }
  
  public void setOperations(final List<Operation> operations) {
    this.operations = operations;
  }
}
