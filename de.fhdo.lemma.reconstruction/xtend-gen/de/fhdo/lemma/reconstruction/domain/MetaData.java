package de.fhdo.lemma.reconstruction.domain;

import java.util.Map;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Class collection meta data information from reconstructed elements
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@SuppressWarnings("all")
public class MetaData {
  @Accessors
  private String name;

  @Accessors
  private Map<String, String> values = CollectionLiterals.<String, String>newHashMap();

  public MetaData() {
  }

  public MetaData(final String name) {
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
  public Map<String, String> getValues() {
    return this.values;
  }

  public void setValues(final Map<String, String> values) {
    this.values = values;
  }
}
