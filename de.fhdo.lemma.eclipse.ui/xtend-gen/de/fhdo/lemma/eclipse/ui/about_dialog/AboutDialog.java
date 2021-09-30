package de.fhdo.lemma.eclipse.ui.about_dialog;

import java.io.InputStream;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.resource.JFaceColors;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * Implementation of the "About LEMMA" dialog.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class AboutDialog extends TrayDialog {
  private static final int MIN_DIALOG_WIDTH = 250;
  
  private static final int MIN_DIALOG_HEIGHT = 100;
  
  /**
   * Constructor
   */
  public AboutDialog(final Shell parentShell) {
    super(parentShell);
  }
  
  /**
   * Create buttons
   */
  @Override
  public void createButtonsForButtonBar(final Composite parent) {
    final Button okButton = this.createButton(parent, IDialogConstants.OK_ID, IDialogConstants.CLOSE_LABEL, 
      true);
    okButton.setFocus();
  }
  
  /**
   * Configure shell
   */
  @Override
  public void configureShell(final Shell shell) {
    super.configureShell(shell);
    shell.setText("About LEMMA");
  }
  
  /**
   * Create dialog area
   */
  @Override
  public Control createDialogArea(final Composite parent) {
    final Color background = JFaceColors.getBannerBackground(parent.getDisplay());
    final Color foreground = JFaceColors.getBannerForeground(parent.getDisplay());
    final GridLayout containerLayout = new GridLayout();
    containerLayout.numColumns = 1;
    containerLayout.marginHeight = 0;
    containerLayout.marginWidth = 0;
    containerLayout.verticalSpacing = 0;
    containerLayout.horizontalSpacing = 0;
    final Composite container = new Composite(parent, SWT.NONE);
    container.setLayout(containerLayout);
    container.setBackground(background);
    container.setForeground(foreground);
    final GridData containerData = new GridData();
    containerData.horizontalAlignment = GridData.FILL;
    containerData.verticalAlignment = GridData.FILL;
    containerData.grabExcessHorizontalSpace = true;
    containerData.grabExcessVerticalSpace = true;
    containerData.heightHint = AboutDialog.MIN_DIALOG_HEIGHT;
    container.setLayoutData(containerData);
    final Composite aboutTextContainer = new Composite(container, SWT.NONE);
    aboutTextContainer.setBackground(background);
    GridLayout _gridLayout = new GridLayout();
    aboutTextContainer.setLayout(_gridLayout);
    final InputStream aboutFile = this.getClass().getResourceAsStream("/About.md");
    final MarkdownToStyledTextConverter converter = new MarkdownToStyledTextConverter(aboutTextContainer, 
      ((SWT.MULTI | SWT.WRAP) | SWT.READ_ONLY));
    final StyledText aboutText = converter.convert(aboutFile);
    aboutText.setFont(parent.getFont());
    aboutText.setCursor(null);
    aboutText.setBackground(background);
    aboutText.setForeground(foreground);
    final GridData aboutTextData = new GridData();
    aboutTextData.verticalAlignment = GridData.BEGINNING;
    aboutTextData.horizontalAlignment = GridData.FILL;
    aboutTextData.grabExcessHorizontalSpace = true;
    aboutText.setLayoutData(aboutTextData);
    final Point aboutTextSize = aboutTextContainer.computeSize(AboutDialog.MIN_DIALOG_WIDTH, SWT.DEFAULT);
    aboutTextContainer.setSize(aboutTextSize.x, aboutTextSize.y);
    Label horizontalBar = new Label(container, (SWT.HORIZONTAL | SWT.SEPARATOR));
    final GridData barData = new GridData();
    barData.horizontalAlignment = GridData.FILL;
    horizontalBar.setLayoutData(barData);
    final GridData bottomData = new GridData();
    bottomData.horizontalAlignment = SWT.FILL;
    bottomData.verticalAlignment = SWT.FILL;
    bottomData.grabExcessHorizontalSpace = true;
    Control _createDialogArea = super.createDialogArea(container);
    final Composite bottomArea = ((Composite) _createDialogArea);
    GridLayout _gridLayout_1 = new GridLayout();
    bottomArea.setLayout(_gridLayout_1);
    bottomArea.setLayoutData(containerData);
    final Label spacer = new Label(bottomArea, SWT.NONE);
    final GridData spacerData = new GridData();
    spacerData.horizontalAlignment = GridData.FILL;
    spacer.setLayoutData(containerData);
    return container;
  }
  
  /**
   * Initial size
   */
  @Override
  public Point getInitialSize() {
    final Point shellSize = super.getInitialSize();
    int _max = Math.max(this.convertHorizontalDLUsToPixels(AboutDialog.MIN_DIALOG_WIDTH), shellSize.x);
    int _max_1 = Math.max(this.convertVerticalDLUsToPixels(AboutDialog.MIN_DIALOG_HEIGHT), shellSize.y);
    return new Point(_max, _max_1);
  }
}
