package de.fhdo.lemma.reconstruction.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class EnumType extends AbstractReconstructionElement {
  @Accessors
  @JsonProperty("values")
  private List<String> values = CollectionLiterals.<String>newLinkedList();
  
  @Accessors
  @JsonProperty("MetaData")
  private List<MetaData> MetaData = CollectionLiterals.<de.fhdo.lemma.reconstruction.domain.MetaData>newLinkedList();
  
  public EnumType() {
  }
  
  public EnumType(final String name, final String qualifiedContextName) {
    super(name, qualifiedContextName);
  }
  
  @Pure
  public List<String> getValues() {
    return this.values;
  }
  
  public void setValues(final List<String> values) {
    this.values = values;
  }
  
  @Pure
  public List<MetaData> getMetaData() {
    return this.MetaData;
  }
  
  public void setMetaData(final List<MetaData> MetaData) {
    this.MetaData = MetaData;
  }
}
