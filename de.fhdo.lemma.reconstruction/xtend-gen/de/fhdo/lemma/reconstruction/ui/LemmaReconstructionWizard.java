package de.fhdo.lemma.reconstruction.ui;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

/**
 * User Interface class for displaying reconstruction wizard to guide the reconstruction
 * dialog.
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@SuppressWarnings("all")
public class LemmaReconstructionWizard extends Wizard implements INewWizard {
  private MongoDBConnectionPage mongoDBPage;

  public LemmaReconstructionWizard() {
    super();
    this.setNeedsProgressMonitor(true);
  }

  @Override
  public boolean performFinish() {
    return true;
  }

  @Override
  public void init(final IWorkbench workbench, final IStructuredSelection selection) {
    MongoDBConnectionPage _mongoDBConnectionPage = new MongoDBConnectionPage("MongoDB Connection Page.");
    this.mongoDBPage = _mongoDBConnectionPage;
    this.addPage(this.mongoDBPage);
    Shell _shell = this.getShell();
    LemmaReconstructionWizard _lemmaReconstructionWizard = new LemmaReconstructionWizard();
    final WizardDialog dialog = new WizardDialog(_shell, _lemmaReconstructionWizard);
    dialog.open();
  }

  @Override
  public String getWindowTitle() {
    return "LEMMA Reconstruction";
  }

  @Override
  public void addPage(final IWizardPage page) {
    this.addPage(page);
  }
}
