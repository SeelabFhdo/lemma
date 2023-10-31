package de.fhdo.lemma.eclipse.ui;

import de.fhdo.lemma.intermediate.transformations.AbstractIntermediateModelTransformationStrategy;
import de.fhdo.lemma.intermediate.transformations.TransformationModelType;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Description of a model file type.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ModelFileTypeDescription {
  @Accessors
  private String fileType;

  @Accessors
  private Image icon;

  @Accessors
  private String description;

  @Accessors
  private List<String> extensions;

  private Class<? extends AbstractIntermediateModelTransformationStrategy<?, ?>> mainTransformationStrategy;

  private List<TransformationModelType> outputModelTypes;

  private LinkedList<Class<? extends AbstractIntermediateModelTransformationStrategy<?, ?>>> refiningTransformationStrategies;

  /**
   * Constructor
   */
  public ModelFileTypeDescription(final String fileType, final Image icon, final String description, final List<String> extensions, final Class<? extends AbstractIntermediateModelTransformationStrategy<?, ?>> mainTransformationStrategy, final Class<? extends AbstractIntermediateModelTransformationStrategy<?, ?>>... refiningTransformationStrategies) {
    this.fileType = fileType;
    this.icon = icon;
    this.description = description;
    this.extensions = extensions;
    this.mainTransformationStrategy = mainTransformationStrategy;
    this.refiningTransformationStrategies = CollectionLiterals.<Class<? extends AbstractIntermediateModelTransformationStrategy<?, ?>>>newLinkedList(refiningTransformationStrategies);
  }

  /**
   * Factory method to create a new instance of the main transformation strategy
   */
  public AbstractIntermediateModelTransformationStrategy<?, ?> createMainTransformationStrategy() {
    try {
      AbstractIntermediateModelTransformationStrategy<?, ?> _xifexpression = null;
      if ((this.mainTransformationStrategy != null)) {
        _xifexpression = this.mainTransformationStrategy.getDeclaredConstructor().newInstance();
      } else {
        _xifexpression = null;
      }
      return _xifexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check if the model file type can be transformed to another file
   */
  public boolean canBeTransformed() {
    return (this.mainTransformationStrategy != null);
  }

  /**
   * If the model file type can be transformed, get output model types
   */
  public List<TransformationModelType> getOutputModelTypes() {
    try {
      boolean _canBeTransformed = this.canBeTransformed();
      boolean _not = (!_canBeTransformed);
      if (_not) {
        return CollectionLiterals.<TransformationModelType>emptyList();
      }
      if ((this.outputModelTypes == null)) {
        this.outputModelTypes = this.mainTransformationStrategy.getDeclaredConstructor().newInstance().getOutputModelTypes();
      }
      return this.outputModelTypes;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Factory method to create a new instance of a certain refining transformation strategy
   */
  public AbstractIntermediateModelTransformationStrategy<?, ?> createRefiningTransformationStrategy(final int index) {
    try {
      AbstractIntermediateModelTransformationStrategy<?, ?> _xifexpression = null;
      if ((((this.refiningTransformationStrategies != null) && (index >= 0)) && 
        (index < this.refiningTransformationStrategies.size()))) {
        _xifexpression = this.refiningTransformationStrategies.get(index).getDeclaredConstructor().newInstance();
      } else {
        _xifexpression = null;
      }
      return _xifexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Get count of refining strategies
   */
  public int refiningStrategiesCount() {
    int _xifexpression = (int) 0;
    if ((this.refiningTransformationStrategies != null)) {
      _xifexpression = this.refiningTransformationStrategies.size();
    } else {
      _xifexpression = (-1);
    }
    return _xifexpression;
  }

  @Pure
  public String getFileType() {
    return this.fileType;
  }

  public void setFileType(final String fileType) {
    this.fileType = fileType;
  }

  @Pure
  public Image getIcon() {
    return this.icon;
  }

  public void setIcon(final Image icon) {
    this.icon = icon;
  }

  @Pure
  public String getDescription() {
    return this.description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  @Pure
  public List<String> getExtensions() {
    return this.extensions;
  }

  public void setExtensions(final List<String> extensions) {
    this.extensions = extensions;
  }
}
