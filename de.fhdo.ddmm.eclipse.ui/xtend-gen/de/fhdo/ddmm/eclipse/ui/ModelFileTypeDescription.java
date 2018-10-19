package de.fhdo.ddmm.eclipse.ui;

import de.fhdo.ddmm.intermediate.transformations.AbstractIntermediateModelTransformationStrategy;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Description of a model file type.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ModelFileTypeDescription {
  @Accessors
  private Image icon;
  
  @Accessors
  private String description;
  
  @Accessors
  private List<String> extensions;
  
  @Accessors
  private AbstractIntermediateModelTransformationStrategy mainTransformationStrategy;
  
  @Accessors
  private LinkedList<AbstractIntermediateModelTransformationStrategy> refiningTransformationStrategies;
  
  /**
   * Constructor
   */
  public ModelFileTypeDescription(final Image icon, final String description, final List<String> extensions, final AbstractIntermediateModelTransformationStrategy mainTransformationStrategy, final AbstractIntermediateModelTransformationStrategy... refiningTransformationStrategies) {
    this.icon = icon;
    this.description = description;
    this.extensions = extensions;
    this.mainTransformationStrategy = mainTransformationStrategy;
    this.refiningTransformationStrategies = CollectionLiterals.<AbstractIntermediateModelTransformationStrategy>newLinkedList(refiningTransformationStrategies);
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
  
  @Pure
  public AbstractIntermediateModelTransformationStrategy getMainTransformationStrategy() {
    return this.mainTransformationStrategy;
  }
  
  public void setMainTransformationStrategy(final AbstractIntermediateModelTransformationStrategy mainTransformationStrategy) {
    this.mainTransformationStrategy = mainTransformationStrategy;
  }
  
  @Pure
  public LinkedList<AbstractIntermediateModelTransformationStrategy> getRefiningTransformationStrategies() {
    return this.refiningTransformationStrategies;
  }
  
  public void setRefiningTransformationStrategies(final LinkedList<AbstractIntermediateModelTransformationStrategy> refiningTransformationStrategies) {
    this.refiningTransformationStrategies = refiningTransformationStrategies;
  }
}
