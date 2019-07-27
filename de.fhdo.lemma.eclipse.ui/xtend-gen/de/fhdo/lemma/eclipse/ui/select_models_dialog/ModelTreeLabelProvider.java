package de.fhdo.lemma.eclipse.ui.select_models_dialog;

import de.fhdo.lemma.eclipse.ui.ModelFile;
import de.fhdo.lemma.eclipse.ui.ModelFileStyledLabelProvider;
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

/**
 * Provider of styled labels for model tree elements.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ModelTreeLabelProvider extends ModelFileStyledLabelProvider {
  private Image projectIcon;
  
  /**
   * Constructor
   */
  public ModelTreeLabelProvider() {
    super();
    this.projectIcon = LemmaUiUtils.createImage(this.resourceManager, this.getClass(), "project.gif");
  }
  
  /**
   * Get styled text for element
   */
  @Override
  public StyledString getStyledText(final Object element) {
    StyledString _switchResult = null;
    boolean _matched = false;
    if (element instanceof IProject) {
      _matched=true;
      String _name = ((IProject)element).getName();
      _switchResult = new StyledString(_name);
    }
    if (!_matched) {
      if (element instanceof ModelFile) {
        _matched=true;
        String _name = ((ModelFile)element).getFile().getName();
        _switchResult = new StyledString(_name);
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  /**
   * Get image for element
   */
  @Override
  public Image getImage(final Object element) {
    Image _switchResult = null;
    boolean _matched = false;
    if (element instanceof IProject) {
      _matched=true;
      _switchResult = this.projectIcon;
    }
    if (!_matched) {
      if (element instanceof ModelFile) {
        _matched=true;
        _switchResult = this.getFileIcon(((ModelFile)element));
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
}
