package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.mongodb;

import com.google.common.collect.Iterables;
import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.AbstractCodeGeneratorTemplate;
import de.fhdo.lemma.operation.InfrastructureNode;
import de.fhdo.lemma.operation.OperationModel;
import de.fhdo.lemma.service.Import;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Abstract superclass for launch configuration templates targeting code generation with the MongoDB
 * Generator.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public abstract class AbstractMongoDBGeneratorTemplate extends AbstractCodeGeneratorTemplate {
  /**
   * Constructor
   */
  public AbstractMongoDBGeneratorTemplate(final ProcessorExecutableType generatorExecutableType, final Shell parentShell, final String name, final IProject project, final IFile file) {
    super(generatorExecutableType, parentShell, name, project, file);
  }

  /**
   * The template is applicable when the source operation model applies the MongoDB technology to
   * at least one infrastructure node
   */
  @Override
  public final Boolean isApplicable(final EObject modelRoot, final Map<String, String> technologyNamePerAlias) {
    final Function1<InfrastructureNode, EList<Import>> _function = (InfrastructureNode it) -> {
      return it.getTechnologies();
    };
    final Iterable<Import> technologyReferences = Iterables.<Import>concat(ListExtensions.<InfrastructureNode, EList<Import>>map(((OperationModel) modelRoot).getInfrastructureNodes(), _function));
    Utils.makeImportPathsAbsolute(modelRoot, this.file);
    final Function1<Import, Boolean> _function_1 = (Import it) -> {
      boolean _xblockexpression = false;
      {
        final String alias = it.getName();
        final String technologyName = technologyNamePerAlias.get(alias);
        _xblockexpression = "mongodb".equalsIgnoreCase(technologyName);
      }
      return Boolean.valueOf(_xblockexpression);
    };
    return Boolean.valueOf(IterableExtensions.<Import>exists(technologyReferences, _function_1));
  }
}
