package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator;

import com.google.common.collect.Iterables;
import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.AbstractCodeGeneratorCompletionDialog;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.AbstractCodeGeneratorTemplate;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.ProcessingConfigurationWithLaunchConfigurationName;
import de.fhdo.lemma.service.Microservice;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.service.TechnologyReference;
import de.fhdo.lemma.technology.mapping.MicroserviceMapping;
import de.fhdo.lemma.technology.mapping.TechnologyMapping;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Abstract superclass for launch configuration templates targeting code generation with the Java
 * Base Generator.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public abstract class AbstractJavaBaseGeneratorTemplate extends AbstractCodeGeneratorTemplate {
  private Argument generationSerializerArgument;

  /**
   * Constructor
   */
  public AbstractJavaBaseGeneratorTemplate(final ProcessorExecutableType generatorExecutableType, final Shell parentShell, final String name, final IProject project, final IFile file) {
    super(generatorExecutableType, parentShell, name, project, file);
  }

  /**
   * Extend the model processing configuration template initialized by the superclass
   */
  @Override
  public ProcessingConfigurationWithLaunchConfigurationName extendInitializedProcessingConfigurationTemplate(final ProcessingConfigurationWithLaunchConfigurationName configuration) {
    super.extendInitializedProcessingConfigurationTemplate(configuration);
    this.generationSerializerArgument = Argument.newArgument().singleValued().stringPair().parameter(JavaBaseGeneratorParameters.GENERATION_SERIALIZER_PARAMETER).value(JavaBaseGeneratorParameters.instance().getDefaultGenerationSerializer());
    configuration.getArguments().add(this.generationSerializerArgument);
    return configuration;
  }

  /**
   * Return the dialog for template completion
   */
  @Override
  public final AbstractCodeGeneratorCompletionDialog getCodeGeneratorCompletionDialog() {
    final AbstractJavaBaseGeneratorCompletionDialog dialog = this.getJavaBaseGeneratorCompletionDialog();
    dialog.setGenerationSerializerArgument(this.generationSerializerArgument);
    return dialog;
  }

  /**
   * Implementers must provide a specialized completion dialog. getCodeGeneratorCompletionDialog()
   * invokes this method to retrieve the specialized dialog and assign it the argument for the
   * selected code generation serializer.
   */
  public abstract AbstractJavaBaseGeneratorCompletionDialog getJavaBaseGeneratorCompletionDialog();

  /**
   * The template is applicable when the source service or mapping model applies the Java
   * technology to at least one microservice
   */
  @Override
  public Boolean isApplicable(final EObject modelRoot, final Map<String, String> technologyNamePerAlias) {
    Iterable<TechnologyReference> _switchResult = null;
    boolean _matched = false;
    if (modelRoot instanceof ServiceModel) {
      _matched=true;
      final Function1<Microservice, EList<TechnologyReference>> _function = (Microservice it) -> {
        return it.getTechnologyReferences();
      };
      _switchResult = Iterables.<TechnologyReference>concat(ListExtensions.<Microservice, EList<TechnologyReference>>map(((ServiceModel)modelRoot).getMicroservices(), _function));
    }
    if (!_matched) {
      if (modelRoot instanceof TechnologyMapping) {
        _matched=true;
        final Function1<MicroserviceMapping, EList<TechnologyReference>> _function = (MicroserviceMapping it) -> {
          return it.getTechnologyReferences();
        };
        _switchResult = Iterables.<TechnologyReference>concat(ListExtensions.<MicroserviceMapping, EList<TechnologyReference>>map(((TechnologyMapping)modelRoot).getServiceMappings(), _function));
      }
    }
    if (!_matched) {
      _switchResult = CollectionLiterals.<TechnologyReference>emptyList();
    }
    final Iterable<TechnologyReference> technologyReferences = _switchResult;
    Utils.makeImportPathsAbsolute(modelRoot, this.file);
    final Function1<TechnologyReference, Boolean> _function = (TechnologyReference it) -> {
      boolean _xblockexpression = false;
      {
        final String alias = it.getTechnology().getName();
        final String technologyName = technologyNamePerAlias.get(alias);
        _xblockexpression = "java".equalsIgnoreCase(technologyName);
      }
      return Boolean.valueOf(_xblockexpression);
    };
    return Boolean.valueOf(IterableExtensions.<TechnologyReference>exists(technologyReferences, _function));
  }
}
