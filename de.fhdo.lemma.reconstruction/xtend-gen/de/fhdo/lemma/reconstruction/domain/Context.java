package de.fhdo.lemma.reconstruction.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Class for capturing information about a context.
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@SuppressWarnings("all")
public class Context {
  @Accessors
  @JsonProperty("qualified_name")
  private String qualifiedName;

  @Accessors
  private String name;

  @Accessors
  private String version;

  @Accessors
  @JsonProperty("data_structures")
  private List<DataStructure> dataStructures = CollectionLiterals.<DataStructure>newLinkedList();

  @Accessors
  @JsonProperty("enums")
  private List<EnumType> enums = CollectionLiterals.<EnumType>newLinkedList();

  public Context() {
  }

  public Context(final String qalifiedName, final String name, final String version) {
    this.qualifiedName = qalifiedName;
    this.name = name;
    this.version = version;
  }

  @Pure
  public String getQualifiedName() {
    return this.qualifiedName;
  }

  public void setQualifiedName(final String qualifiedName) {
    this.qualifiedName = qualifiedName;
  }

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
  public List<DataStructure> getDataStructures() {
    return this.dataStructures;
  }

  public void setDataStructures(final List<DataStructure> dataStructures) {
    this.dataStructures = dataStructures;
  }

  @Pure
  public List<EnumType> getEnums() {
    return this.enums;
  }

  public void setEnums(final List<EnumType> enums) {
    this.enums = enums;
  }
}
