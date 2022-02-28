package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator;

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.AbstractCodeGeneratorCompletionDialog;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.AbstractLaunchConfigurationTemplate;
import java.util.List;
import java.util.function.Function;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.typed.BeanProperties;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.typed.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;

/**
 * Abstract superclass for completion dialogs for launch configuration templates targeting code
 * generation with the Java Base Generator.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public abstract class AbstractJavaBaseGeneratorCompletionDialog extends AbstractCodeGeneratorCompletionDialog {
  private Argument generationSerializerArgument;
  
  protected Combo generationSerializer;
  
  /**
   * Constructor
   */
  public AbstractJavaBaseGeneratorCompletionDialog(final Shell parentShell, final IProject project, final IFile file) {
    super(parentShell, project, file, "Java Base Generator", "JBG");
  }
  
  /**
   * Assign the Argument that identifies the code generation serializer
   */
  protected final void setGenerationSerializerArgument(final Argument generationSerializerArgument) {
    this.generationSerializerArgument = generationSerializerArgument;
    this.generationSerializerArgument.addPropertyChangeListener(this);
  }
  
  /**
   * Create the dialog area
   */
  @Override
  public Control createDialogArea(final Composite parent) {
    final Control area = super.createDialogArea(parent);
    Shell _shell = parent.getShell();
    Point _point = new Point(AbstractLaunchConfigurationTemplate.AbstractTemplateCompletionDialog.DEFAULT_WIDTH, 350);
    _shell.setSize(_point);
    return area;
  }
  
  /**
   * Add additional controls to the dialog
   */
  @Override
  public void insertAdditionalControlsAfterDefaults(final Composite parent) {
    super.insertAdditionalControlsAfterDefaults(parent);
    this.addGenerationSerializer(parent);
  }
  
  /**
   * Add combo box for code generation serializer selection
   */
  private Binding addGenerationSerializer(final Composite parent) {
    Binding _xblockexpression = null;
    {
      Label _label = new Label(parent, SWT.NULL);
      _label.setText("Generation serializer:");
      Combo _combo = new Combo(parent, (SWT.DROP_DOWN | SWT.READ_ONLY));
      this.generationSerializer = _combo;
      final GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, false);
      layoutData.horizontalSpan = 2;
      this.generationSerializer.setLayoutData(layoutData);
      final JavaBaseGeneratorParameters generatorParameters = JavaBaseGeneratorParameters.instance();
      this.generationSerializer.setItems(((String[])Conversions.unwrapArray(generatorParameters.getSerializerLabels(), String.class)));
      final String defaultItem = generatorParameters.defaultSerializerLabel();
      this.generationSerializer.select(((List<String>)Conversions.doWrapArray(this.generationSerializer.getItems())).indexOf(defaultItem));
      final ISWTObservableValue<String> target = WidgetProperties.comboSelection().observe(this.generationSerializer);
      final IObservableValue<String> model = BeanProperties.<Argument, String>value(Argument.class, "value").observe(this.generationSerializerArgument);
      final UpdateValueStrategy<String, String> modelToTargetConverter = new UpdateValueStrategy<String, String>();
      final Function<String, String> _function = (String it) -> {
        return generatorParameters.getSerializerLabel(it);
      };
      modelToTargetConverter.setConverter(IConverter.<String, String>create(_function));
      final UpdateValueStrategy<String, String> targetToModelConverter = new UpdateValueStrategy<String, String>();
      final Function<String, String> _function_1 = (String it) -> {
        return generatorParameters.getSerializerParameter(it);
      };
      targetToModelConverter.setConverter(IConverter.<String, String>create(_function_1));
      _xblockexpression = this.dataBindingContext.<String, String>bindValue(target, model, targetToModelConverter, modelToTargetConverter);
    }
    return _xblockexpression;
  }
  
  /**
   * Retrieve a printable representation of the source model's file type
   */
  protected final String printableModelFileType() {
    String _switchResult = null;
    String _fileExtension = this.file.getFileExtension();
    if (_fileExtension != null) {
      switch (_fileExtension) {
        case "services":
          _switchResult = "service";
          break;
        case "mapping":
          _switchResult = "mapping";
          break;
        default:
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("\".");
          String _fileExtension_1 = this.file.getFileExtension();
          _builder.append(_fileExtension_1);
          _builder.append("\"");
          String _plus = ("Unsupported model file extension " + _builder);
          throw new IllegalStateException(_plus);
      }
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\".");
      String _fileExtension_1 = this.file.getFileExtension();
      _builder.append(_fileExtension_1);
      _builder.append("\"");
      String _plus = ("Unsupported model file extension " + _builder);
      throw new IllegalStateException(_plus);
    }
    return _switchResult;
  }
  
  /**
   * Close the dialog
   */
  @Override
  public boolean close() {
    boolean _xblockexpression = false;
    {
      this.generationSerializerArgument.removePropertyChangeListener(this);
      _xblockexpression = super.close();
    }
    return _xblockexpression;
  }
}
