package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * Custom implementation of org.eclipse.debug.internal.ui.launchConfigurations.ShowCommandLineDialog
 * which is internal. By contrast to the Eclipse dialog, this dialog expects the commandline to
 * display as a String parameter in the constructor.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class ShowCommandLineDialog extends Dialog {
  private final String commandLine;

  private Text commandLineTextField;

  /**
   * Constructor
   */
  public ShowCommandLineDialog(final Shell parentShell, final String commandLine) {
    super(parentShell);
    this.setShellStyle((SWT.RESIZE | this.getShellStyle()));
    this.commandLine = commandLine;
  }

  /**
   * Configure the shell
   */
  @Override
  public final void configureShell(final Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("Command Line");
  }

  /**
   * Create the dialog's buttons
   */
  @Override
  public final void createButtonsForButtonBar(final Composite parent) {
    this.createButton(parent, IDialogConstants.CANCEL_ID, "Close", true);
    this.createButton(parent, IDialogConstants.OK_ID, "Copy && Close", true);
  }

  /**
   * Create the dialog area
   */
  @Override
  public final Control createDialogArea(final Composite parent) {
    Control _createDialogArea = super.createDialogArea(parent);
    final Composite container = ((Composite) _createDialogArea);
    final Group group = new Group(container, SWT.NONE);
    final GridLayout topLayout = new GridLayout();
    group.setLayout(topLayout);
    GridData gridData = new GridData(GridData.FILL_BOTH);
    gridData.heightHint = this.convertHeightInCharsToPixels(20);
    gridData.widthHint = this.convertWidthInCharsToPixels(90);
    group.setLayoutData(gridData);
    Text _text = new Text(group, 
      (((SWT.MULTI | SWT.WRAP) | SWT.BORDER) | SWT.V_SCROLL));
    this.commandLineTextField = _text;
    GridData _gridData = new GridData(GridData.FILL_BOTH);
    gridData = _gridData;
    gridData.heightHint = this.convertHeightInCharsToPixels(10);
    gridData.widthHint = this.convertWidthInCharsToPixels(60);
    this.commandLineTextField.setLayoutData(gridData);
    this.commandLineTextField.setText(this.commandLine);
    this.commandLineTextField.setEditable(false);
    return container;
  }

  /**
   * Catch button press
   */
  @Override
  public final void buttonPressed(final int buttonId) {
    if ((buttonId != IDialogConstants.OK_ID)) {
      super.buttonPressed(buttonId);
      return;
    }
    final Clipboard clipboard = new Clipboard(null);
    try {
      final TextTransfer textTransfer = TextTransfer.getInstance();
      final Transfer[] transfers = { textTransfer };
      String _text = this.commandLineTextField.getText();
      final Object[] data = new Object[] { _text };
      clipboard.setContents(data, transfers);
    } finally {
      clipboard.dispose();
    }
  }

  /**
   * Get the dialog's bounds settings
   */
  @Override
  public final IDialogSettings getDialogBoundsSettings() {
    final Bundle bundle = FrameworkUtil.getBundle(ShowCommandLineDialog.class);
    final IDialogSettings settings = PlatformUI.getDialogSettingsProvider(bundle).getDialogSettings();
    IDialogSettings _elvis = null;
    IDialogSettings _section = settings.getSection(this.getDialogSettingsSectionName());
    if (_section != null) {
      _elvis = _section;
    } else {
      IDialogSettings _addNewSection = settings.addNewSection(this.getDialogSettingsSectionName());
      _elvis = _addNewSection;
    }
    return _elvis;
  }

  /**
   * Get the dialog's section name
   */
  protected String getDialogSettingsSectionName() {
    return "SHOW_COMMAND_LINE_DIALOG";
  }
}
