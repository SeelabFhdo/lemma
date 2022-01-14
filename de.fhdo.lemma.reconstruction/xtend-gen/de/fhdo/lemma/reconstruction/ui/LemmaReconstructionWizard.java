package de.fhdo.lemma.reconstruction.ui;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class LemmaReconstructionWizard extends Wizard implements INewWizard {
  private MongoDBConnectionPage mongoDBPage;
  
  public LemmaReconstructionWizard() {
    super();
    this.setNeedsProgressMonitor(true);
  }
  
  @Override
  public boolean performFinish() {
    boolean _xblockexpression = false;
    {
      InputOutput.<String>println("Finished");
      _xblockexpression = true;
    }
    return _xblockexpression;
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
