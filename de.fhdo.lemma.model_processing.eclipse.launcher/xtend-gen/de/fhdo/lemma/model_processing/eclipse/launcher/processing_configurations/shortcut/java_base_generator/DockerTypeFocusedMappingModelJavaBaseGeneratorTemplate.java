package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator;

import com.google.common.collect.Iterables;
import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelOfImportWithAliasArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.AbstractLaunchConfigurationTemplate;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.ProcessingConfigurationWithLaunchConfigurationName;
import de.fhdo.lemma.service.TechnologyReference;
import de.fhdo.lemma.technology.mapping.ComplexTypeMapping;
import de.fhdo.lemma.technology.mapping.TechnologyMapping;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Launch configuration template targeting code generation with the Java Base Generator from a
 * type-focused mapping model and in a Docker container based on a local image.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class DockerTypeFocusedMappingModelJavaBaseGeneratorTemplate extends DockerJavaBaseGeneratorTemplate {
  /**
   * Dialog for template completion. It extends the super dialog with a combo box to select the
   * service model comprising the relevant microservices including their technology-specific
   * configurations. That is because the template concerns type-focused mapping models that only
   * perform technology mapping for modeled types and not for microservices.
   */
  private static class TypeFocusedMappingModelTemplateCompletionDialog extends DockerJavaBaseGeneratorTemplate.TemplateCompletionDialog {
    private Argument alternativeIntermediateServiceModelArgument;
    
    /**
     * Constructor
     */
    public TypeFocusedMappingModelTemplateCompletionDialog(final Shell parentShell, final IProject project, final IFile file) {
      super(parentShell, project, file);
    }
    
    /**
     * Create the dialog area
     */
    @Override
    public final Control createDialogArea(final Composite parent) {
      final Control area = super.createDialogArea(parent);
      Shell _shell = parent.getShell();
      Point _point = new Point(AbstractLaunchConfigurationTemplate.AbstractTemplateCompletionDialog.DEFAULT_WIDTH, 380);
      _shell.setSize(_point);
      return area;
    }
    
    /**
     * Add additional controls to the dialog
     */
    @Override
    public final void insertAdditionalControlsAfterDefaults(final Composite parent) {
      super.insertAdditionalControlsAfterDefaults(parent);
      this.addAlternativeIntermediateServiceModel(parent);
    }
    
    /**
     * Add combo box for selecting the service model comprising the relevant microservices
     * including their technology-specific configurations
     */
    private void addAlternativeIntermediateServiceModel(final Composite parent) {
      Label _label = new Label(parent, SWT.NULL);
      _label.setText("Service model:");
      final IntermediateModelOfImportWithAliasArgumentTypeComboWrapper comboWrapper = new IntermediateModelOfImportWithAliasArgumentTypeComboWrapper(parent, 
        (SWT.DROP_DOWN | SWT.READ_ONLY), 
        this.configurationTemplate, 
        JavaBaseGeneratorParameters.ALTERNATIVE_INTERMEDIATE_SERVICE_MODEL_PARAMETER);
      final GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, false);
      layoutData.horizontalSpan = 2;
      Combo _combo = comboWrapper.getCombo();
      _combo.setLayoutData(layoutData);
      final Procedure1<String> _function = (String it) -> {
        AbstractArgumentType _type = comboWrapper.getArgument().getType();
        ((IntermediateModelOfImportWithAliasArgumentType) _type).validateValueInInternalRepresentation(this.configurationTemplate, it);
      };
      this.<Argument>bindWithValidationDecorationSupport(
        comboWrapper.getCombo(), 
        Argument.class, 
        "value", 
        comboWrapper.getArgument(), _function);
      this.alternativeIntermediateServiceModelArgument = comboWrapper.getArgument();
      this.alternativeIntermediateServiceModelArgument.addPropertyChangeListener(this);
    }
    
    /**
     * Complete the template with the Argument instance representing the intermediate version
     * of the selected service model
     */
    @Override
    public final void completeProcessingConfigurationTemplate(final ProcessingConfigurationWithLaunchConfigurationName templateToComplete) {
      templateToComplete.getArguments().add(this.alternativeIntermediateServiceModelArgument);
    }
    
    /**
     * Close the dialog
     */
    @Override
    public final boolean close() {
      boolean _xblockexpression = false;
      {
        this.alternativeIntermediateServiceModelArgument.removePropertyChangeListener(this);
        _xblockexpression = super.close();
      }
      return _xblockexpression;
    }
  }
  
  /**
   * Constructor
   */
  public DockerTypeFocusedMappingModelJavaBaseGeneratorTemplate(final Shell parentShell, final IProject project, final IFile file) {
    super(parentShell, new Function0<String>() {
      @Override
      public String apply() {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Type-focused mapping model: ");
        _builder.append(DockerJavaBaseGeneratorTemplate.TEMPLATE_NAME);
        return _builder.toString();
      }
    }.apply(), project, file);
  }
  
  /**
   * Return the dialog for template completion
   */
  @Override
  public final AbstractJavaBaseGeneratorCompletionDialog getJavaBaseGeneratorCompletionDialog() {
    return new DockerTypeFocusedMappingModelJavaBaseGeneratorTemplate.TypeFocusedMappingModelTemplateCompletionDialog(this.parentShell, this.project, this.file);
  }
  
  /**
   * The template is applicable when the source mapping model applies the Java technology to at
   * least one type
   */
  @Override
  public final Boolean isApplicable(final EObject modelRoot, final Map<String, String> technologyNamePerAlias) {
    Iterable<TechnologyReference> _switchResult = null;
    boolean _matched = false;
    if (modelRoot instanceof TechnologyMapping) {
      _matched=true;
      final Function1<ComplexTypeMapping, EList<TechnologyReference>> _function = (ComplexTypeMapping it) -> {
        return it.getTechnologyReferences();
      };
      _switchResult = Iterables.<TechnologyReference>concat(ListExtensions.<ComplexTypeMapping, EList<TechnologyReference>>map(((TechnologyMapping)modelRoot).getTypeMappings(), _function));
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
