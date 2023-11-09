package de.fhdo.lemma.model_processing.eclipse.launcher;

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableTypesInformationManager;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui.LocalDockerImageSelectionDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.osgi.framework.BundleContext;

/**
 * Activate the launcher plugin.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class Activator extends AbstractUIPlugin {
  /**
   * Catch bundle start
   */
  @Override
  public final void start(final BundleContext context) {
    try {
      super.start(context);
      this.registerProcessorExecutableTypes();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Register the types of processor executables
   */
  private void registerProcessorExecutableTypes() {
    final Function2<Shell, ProcessingConfiguration, String> _function = (Shell shell, ProcessingConfiguration processingConfiguration) -> {
      String _basicProcessorExecutionCommand = processingConfiguration.getBasicProcessorExecutionCommand();
      final LocalDockerImageSelectionDialog dialog = new LocalDockerImageSelectionDialog(shell, _basicProcessorExecutionCommand);
      String _xifexpression = null;
      int _open = dialog.open();
      boolean _equals = (_open == Window.OK);
      if (_equals) {
        _xifexpression = dialog.getSelectedImage();
      } else {
        _xifexpression = null;
      }
      return _xifexpression;
    };
    ProcessorExecutableTypesInformationManager.ProcessorExecutableTypeInformation _processorExecutableTypeInformation = new ProcessorExecutableTypesInformationManager.ProcessorExecutableTypeInformation(
      ProcessorExecutableType.LOCAL_DOCKER_IMAGE, 
      "Local Docker Image", 
      "local Docker image", _function);
    final Function2<Shell, ProcessingConfiguration, String> _function_1 = (Shell shell, ProcessingConfiguration __) -> {
      String _xblockexpression = null;
      {
        final FileDialog dialog = new FileDialog(shell, SWT.OPEN);
        dialog.setText("Select local Java program");
        dialog.setFilterExtensions(new String[] { "*.jar" });
        _xblockexpression = dialog.open();
      }
      return _xblockexpression;
    };
    ProcessorExecutableTypesInformationManager.ProcessorExecutableTypeInformation _processorExecutableTypeInformation_1 = new ProcessorExecutableTypesInformationManager.ProcessorExecutableTypeInformation(
      ProcessorExecutableType.LOCAL_JAVA_PROGRAM, 
      "Local Java Program", 
      "local Java program", _function_1);
    ProcessorExecutableTypesInformationManager.ProcessorExecutableTypeInformation _processorExecutableTypeInformation_2 = new ProcessorExecutableTypesInformationManager.ProcessorExecutableTypeInformation(
      ProcessorExecutableType.RAW_EXECUTABLE, 
      "Raw executable", 
      "raw executable", 
      null);
    ProcessorExecutableTypesInformationManager.register(_processorExecutableTypeInformation, _processorExecutableTypeInformation_1, _processorExecutableTypeInformation_2);
  }
}
