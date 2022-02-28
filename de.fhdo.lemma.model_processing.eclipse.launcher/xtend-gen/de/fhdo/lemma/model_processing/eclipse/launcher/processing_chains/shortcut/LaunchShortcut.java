package de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains.shortcut;

import de.fhdo.lemma.model_processing.eclipse.launcher.LaunchConfigurationConstants;
import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains.ProcessingChain;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.ILaunchShortcut2;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * Launch shortcut for model processing chain launch configurations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class LaunchShortcut implements ILaunchShortcut2 {
  private static final ILaunchManager LAUNCH_MANAGER = DebugPlugin.getDefault().getLaunchManager();
  
  /**
   * Get the launch configurations associated with a selected file
   */
  @Override
  public final ILaunchConfiguration[] getLaunchConfigurations(final ISelection selection) {
    final IFile file = Utils.getSelectedFile(selection);
    Iterable<ILaunchConfiguration> _xifexpression = null;
    if ((file != null)) {
      _xifexpression = this.getLaunchConfigurations(file);
    } else {
      _xifexpression = null;
    }
    return ((ILaunchConfiguration[])Conversions.unwrapArray(_xifexpression, ILaunchConfiguration.class));
  }
  
  /**
   * Get the launch configurations applicable to the given IFile as a mapped resource
   */
  private Iterable<ILaunchConfiguration> getLaunchConfigurations(final IFile file) {
    return Utils.getLaunchConfigurationsForMappedResource(
      LaunchShortcut.LAUNCH_MANAGER, 
      LaunchConfigurationConstants.PROCESSING_CHAIN_LAUNCH_CONFIGURATION_TYPE, file);
  }
  
  /**
   * Get launchable resource associated with a selected file
   */
  @Override
  public final IResource getLaunchableResource(final ISelection selection) {
    return null;
  }
  
  /**
   * Execute the shortcut for the selected file in the given mode
   */
  @Override
  public final void launch(final ISelection selection, final String mode) {
    this.launch(Utils.getSelectedFile(selection), mode);
  }
  
  /**
   * Execute the shortcut on the given file in the given mode
   */
  private void launch(final IFile file, final String mode) {
    if ((file == null)) {
      return;
    }
    Shell _activeShell = Utils.getActiveShell();
    Map<String, ILaunchConfiguration> _modelProcessingLaunchConfigurations = Utils.getModelProcessingLaunchConfigurations();
    ProcessingChainWithLaunchConfigurationName _processingChainWithLaunchConfigurationName = new ProcessingChainWithLaunchConfigurationName();
    final Procedure2<ProcessingChainWithLaunchConfigurationName, Map<String, ILaunchConfiguration>> _function = (ProcessingChainWithLaunchConfigurationName processingChain, Map<String, ILaunchConfiguration> availableLaunchConfigurations) -> {
      this.storeAndRun(processingChain, availableLaunchConfigurations);
    };
    final Procedure2<ProcessingChainWithLaunchConfigurationName, Map<String, ILaunchConfiguration>> _function_1 = (ProcessingChainWithLaunchConfigurationName processingChain, Map<String, ILaunchConfiguration> availableLaunchConfigurations) -> {
      this.store(processingChain, availableLaunchConfigurations);
    };
    final LaunchConfigurationChainCreationDialog dialog = new LaunchConfigurationChainCreationDialog(_activeShell, _modelProcessingLaunchConfigurations, _processingChainWithLaunchConfigurationName, _function, _function_1);
    dialog.open();
  }
  
  /**
   * Store and run the given the model processing chain
   */
  private void storeAndRun(final ProcessingChainWithLaunchConfigurationName completedProcessingChain, final Map<String, ILaunchConfiguration> availableLaunchConfigurations) {
    DebugUITools.launch(this.store(completedProcessingChain, availableLaunchConfigurations), 
      ILaunchManager.RUN_MODE);
  }
  
  /**
   * Store the given model processing chain
   */
  private ILaunchConfiguration store(final ProcessingChainWithLaunchConfigurationName completedProcessingChain, final Map<String, ILaunchConfiguration> availableLaunchConfigurations) {
    try {
      try {
        completedProcessingChain.validate(availableLaunchConfigurations);
      } catch (final Throwable _t) {
        if (_t instanceof IllegalArgumentException) {
          final IllegalArgumentException ex = (IllegalArgumentException)_t;
          Shell _activeShell = Utils.getActiveShell();
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("chain is erroneous: ");
          String _message = ex.getMessage();
          _builder.append(_message);
          _builder.append(". Execution not possible.");
          String _plus = ("Processing " + _builder);
          MessageDialog.openError(_activeShell, "Erroneous processing chain", _plus);
          throw ex;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      final ILaunchConfigurationWorkingCopy newLaunchConfigurationWorkingCopy = LaunchConfigurationConstants.PROCESSING_CHAIN_LAUNCH_CONFIGURATION_TYPE.newInstance(null, completedProcessingChain.getLaunchConfigurationName());
      ProcessingChain.setProcessingChainAsAttribute(newLaunchConfigurationWorkingCopy, completedProcessingChain);
      return newLaunchConfigurationWorkingCopy.doSave(ILaunchConfiguration.UPDATE_PROTOTYPE_CHILDREN);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Get the launch configurations associated with the currently edited file
   */
  @Override
  public final ILaunchConfiguration[] getLaunchConfigurations(final IEditorPart editor) {
    final IFile file = Utils.getEditedFile(editor);
    Iterable<ILaunchConfiguration> _xifexpression = null;
    if ((file != null)) {
      _xifexpression = this.getLaunchConfigurations(file);
    } else {
      _xifexpression = null;
    }
    return ((ILaunchConfiguration[])Conversions.unwrapArray(_xifexpression, ILaunchConfiguration.class));
  }
  
  /**
   * Get launchable resource associated with the currently edited file
   */
  @Override
  public final IResource getLaunchableResource(final IEditorPart editor) {
    return null;
  }
  
  /**
   * Execute the shortcut for the currently edited file in the given mode
   */
  @Override
  public final void launch(final IEditorPart editor, final String mode) {
    this.launch(Utils.getEditedFile(editor), mode);
  }
}
