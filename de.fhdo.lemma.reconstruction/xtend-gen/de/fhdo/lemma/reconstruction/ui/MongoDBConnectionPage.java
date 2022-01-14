package de.fhdo.lemma.reconstruction.ui;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

@SuppressWarnings("all")
public class MongoDBConnectionPage extends WizardPage implements IWizardPage {
  private Text text;
  
  private Composite container;
  
  protected MongoDBConnectionPage(final String pageName) {
    super(pageName);
    this.setTitle("MongoDB Page");
    this.setDescription("Page for connecting to a MongoDB database");
  }
  
  @Override
  public void createControl(final Composite parent) {
    Composite _composite = new Composite(parent, SWT.NONE);
    this.container = _composite;
    final GridLayout layout = new GridLayout();
    this.container.setLayout(layout);
    layout.numColumns = 2;
    final Label label1 = new Label(this.container, SWT.NONE);
    label1.setText("Dome text 1");
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
  
  public String getText() {
    return this.text.getText();
  }
}
