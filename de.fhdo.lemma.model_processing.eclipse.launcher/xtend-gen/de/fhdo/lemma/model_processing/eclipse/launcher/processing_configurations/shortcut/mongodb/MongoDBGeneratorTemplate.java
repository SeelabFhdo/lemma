package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.mongodb;

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.AbstractCodeGeneratorCompletionDialog;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Launch configuration template targeting code generation with the MongoDB Generator as a local
 * Java program.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class MongoDBGeneratorTemplate extends AbstractMongoDBGeneratorTemplate {
  /**
   * Dialog for template completion
   */
  public static final class TemplateCompletionDialog extends AbstractCodeGeneratorCompletionDialog {
    /**
     * Constructor
     */
    public TemplateCompletionDialog(final Shell parentShell, final IProject project, final IFile file) {
      super(parentShell, project, file, MongoDBGeneratorConstants.GENERATOR_LONG_NAME, 
        MongoDBGeneratorConstants.GENERATOR_SHORT_NAME);
    }

    /**
     * Addendum for generator long name as part of the label for the generator executable path's
     * text field
     */
    @Override
    public final String getGeneratorExecutableLabelTextAddendum() {
      return "path";
    }

    /**
     * Create the dialog
     */
    @Override
    public final void create() {
      super.create();
      this.setTitle("Generate MongoDB Artifacts From LEMMA Models");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Use this dialog to configure and run LEMMA\'s ");
      _builder.append(this.generatorLongName);
      _builder.append(" on ");
      String _plus = (_builder.toString() + 
        "the selected operation model");
      this.setMessage(_plus);
    }
  }

  /**
   * Constructor
   */
  public MongoDBGeneratorTemplate(final Shell parentShell, final IProject project, final IFile file) {
    super(ProcessorExecutableType.LOCAL_JAVA_PROGRAM, parentShell, ("MongoDB artifact " + 
      "generation"), project, file);
  }

  /**
   * Return the dialog for template completion
   */
  @Override
  public final AbstractCodeGeneratorCompletionDialog getCodeGeneratorCompletionDialog() {
    return new MongoDBGeneratorTemplate.TemplateCompletionDialog(this.parentShell, this.project, this.file);
  }
}
