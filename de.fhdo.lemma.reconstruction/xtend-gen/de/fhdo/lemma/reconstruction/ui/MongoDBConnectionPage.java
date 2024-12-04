package de.fhdo.lemma.reconstruction.ui;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * User Interface class configuring the connection to the MongoDB.
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@SuppressWarnings("all")
public class MongoDBConnectionPage extends WizardPage implements IWizardPage {
  private Text text;

  private Composite container;

  protected MongoDBConnectionPage(final String pageName) {
    super(pageName);
    this.setTitle("MongoDB Page");
    this.setDescription("Page for connecting to a MongoDB database");
  }

  /**
   * Control to manage the input for the MongoDB connection.
   */
  @Override
  public void createControl(final Composite parent) {
    Composite _composite = new Composite(parent, SWT.NONE);
    this.container = _composite;
    final GridLayout layout = new GridLayout();
    this.container.setLayout(layout);
    layout.numColumns = 2;
    Text _text = new Text(this.container, SWT.BORDER);
    this.text = _text;
    this.text.setText("");
    this.text.addKeyListener(new KeyListener() {
      @Override
      public void keyPressed(final KeyEvent e) {
      }

      @Override
      public void keyReleased(final KeyEvent e) {
        boolean _isEmpty = MongoDBConnectionPage.this.text.getText().isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          MongoDBConnectionPage.this.setPageComplete(true);
        }
      }
    });
    final GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
    this.text.setLayoutData(gridData);
    this.setControl(this.container);
    this.setPageComplete(false);
  }

  /**
   * Get the database information from the input
   */
  public String getText() {
    return this.text.getText();
  }
}
