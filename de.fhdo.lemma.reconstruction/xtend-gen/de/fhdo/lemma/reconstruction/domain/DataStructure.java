package de.fhdo.lemma.reconstruction.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Class for capturing information about a data structure.
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@SuppressWarnings("all")
public class DataStructure extends AbstractReconstructionElement {
  @Accessors
  @JsonProperty("fields")
  private List<Field> fields = CollectionLiterals.<Field>newLinkedList();

  @Accessors
  @JsonProperty("data")
  private List<MetaData> metaData = CollectionLiterals.<MetaData>newLinkedList();

  public DataStructure() {
  }

  public DataStructure(final String name, final String qualifiedContextName) {
    super(name, qualifiedContextName);
  }

  @Pure
  public List<Field> getFields() {
    return this.fields;
  }

  public void setFields(final List<Field> fields) {
    this.fields = fields;
  }

  @Pure
  public List<MetaData> getMetaData() {
    return this.metaData;
  }

  public void setMetaData(final List<MetaData> metaData) {
    this.metaData = metaData;
  }
}
