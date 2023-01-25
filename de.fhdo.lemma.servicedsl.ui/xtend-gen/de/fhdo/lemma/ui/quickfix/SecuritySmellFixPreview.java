package de.fhdo.lemma.ui.quickfix;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

@SuppressWarnings("all")
public class SecuritySmellFixPreview extends TitleAreaDialog {
  public SecuritySmellFixPreview(final Shell parentShell) {
    super(parentShell);
  }
  
  /**
   * Create dialog (to be called after constructor and before open())
   */
  public void create(final String operationName, final String smellName) {
    super.create();
    this.setTitle("Security Smell Analysis Dialog.");
    this.setMessage(smellName, IMessageProvider.INFORMATION);
  }
  
  @Override
  public Control createDialogArea(final Composite parent) {
    Control _createDialogArea = super.createDialogArea(parent);
    final Composite area = ((Composite) _createDialogArea);
    final Composite container = new Composite(area, SWT.NONE);
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    container.setLayoutData(_gridData);
    GridLayout _gridLayout = new GridLayout(2, false);
    container.setLayout(_gridLayout);
    return area;
  }
}
