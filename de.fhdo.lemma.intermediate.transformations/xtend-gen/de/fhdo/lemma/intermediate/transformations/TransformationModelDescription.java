package de.fhdo.lemma.intermediate.transformations;

import java.util.Objects;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Description of a model in a model-to-model transformation.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class TransformationModelDescription {
  /**
   * Name of the model in the transformation, e.g., "IN" or "OUT"
   */
  @Accessors
  private String nameInModelTransformation;

  /**
   * Reference name of the model in the transformation, e.g., "Service" or "Intermediate"
   */
  @Accessors
  private String referenceModelName;

  /**
   * Direction of the model in the transformation
   */
  @Accessors
  private TransformationModelDirection direction;

  /**
   * Constructor
   */
  public TransformationModelDescription(final String nameInModelTransformation, final String referenceModelName, final TransformationModelDirection direction) {
    this.nameInModelTransformation = nameInModelTransformation;
    this.referenceModelName = referenceModelName;
    this.direction = direction;
  }

  /**
   * Two model descriptions are equal if they have the same name in model transformations
   */
  @Override
  public boolean equals(final Object o) {
    if ((o == this)) {
      return true;
    }
    if ((!(o instanceof TransformationModelDescription))) {
      return false;
    }
    return (((TransformationModelDescription) o).nameInModelTransformation == this.nameInModelTransformation);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.nameInModelTransformation);
  }

  @Pure
  public String getNameInModelTransformation() {
    return this.nameInModelTransformation;
  }

  public void setNameInModelTransformation(final String nameInModelTransformation) {
    this.nameInModelTransformation = nameInModelTransformation;
  }

  @Pure
  public String getReferenceModelName() {
    return this.referenceModelName;
  }

  public void setReferenceModelName(final String referenceModelName) {
    this.referenceModelName = referenceModelName;
  }

  @Pure
  public TransformationModelDirection getDirection() {
    return this.direction;
  }

  public void setDirection(final TransformationModelDirection direction) {
    this.direction = direction;
  }
}
