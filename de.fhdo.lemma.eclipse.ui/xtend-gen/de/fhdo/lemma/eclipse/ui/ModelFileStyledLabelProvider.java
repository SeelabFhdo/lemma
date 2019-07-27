package de.fhdo.lemma.eclipse.ui;

import de.fhdo.lemma.eclipse.ui.ModelFile;
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

/**
 * Base class for styled label providers of model files.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ModelFileStyledLabelProvider extends LabelProvider implements DelegatingStyledCellLabelProvider.IStyledLabelProvider {
  protected ResourceManager resourceManager;
  
  protected Image errorIcon;
  
  protected Image warningIcon;
  
  /**
   * Constructor
   */
  public ModelFileStyledLabelProvider() {
    ResourceManager _resources = JFaceResources.getResources();
    LocalResourceManager _localResourceManager = new LocalResourceManager(_resources);
    this.resourceManager = _localResourceManager;
    this.errorIcon = LemmaUiUtils.createImage(this.resourceManager, this.getClass(), "error.gif");
    this.warningIcon = LemmaUiUtils.createImage(this.resourceManager, this.getClass(), "warning.gif");
  }
  
  /**
   * Get default styled text for element
   */
  @Override
  public StyledString getStyledText(final Object element) {
    if ((!(element instanceof ModelFile))) {
      return new StyledString("");
    }
    String _string = ((ModelFile) element).getFile().getFullPath().toString();
    return new StyledString(_string);
  }
  
  /**
   * Get image for element
   */
  @Override
  public Image getImage(final Object element) {
    if ((!(element instanceof ModelFile))) {
      return null;
    }
    return this.getFileIcon(((ModelFile) element));
  }
  
  /**
   * Garbage collector callback
   */
  @Override
  public void dispose() {
    super.dispose();
    this.resourceManager.dispose();
  }
  
  /**
   * Helper method to get the icon of a model file element
   */
  protected Image getFileIcon(final ModelFile modelFile) {
    Boolean _hasErrors = modelFile.hasErrors();
    if ((_hasErrors).booleanValue()) {
      return this.errorIcon;
    } else {
      Boolean _hasWarnings = modelFile.hasWarnings();
      if ((_hasWarnings).booleanValue()) {
        return this.warningIcon;
      }
    }
    return modelFile.getFileTypeDescription().getIcon();
  }
}
