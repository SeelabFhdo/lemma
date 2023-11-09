package de.fhdo.lemma.model_processing.eclipse.launcher;

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType;
import java.util.Collections;
import java.util.Map;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Constants for model processing launch configurations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public interface LaunchConfigurationConstants {
  static final String COMMON_LAUNCH_CONFIGURATION_TAB_NAME = "Common";

  static final Image COMMON_LAUNCH_CONFIGURATION_TAB_IMAGE = DebugUITools.getImage("IMG_OBJS_COMMON_TAB");

  static final Color CONSOLE_ERROR_COLOR = PlatformUI.getWorkbench().getThemeManager().getCurrentTheme().getColorRegistry().get("org.eclipse.debug.ui.console.stream.err");

  static final ILaunchManager LAUNCH_MANAGER = DebugPlugin.getDefault().getLaunchManager();

  static final String PROCESSING_CHAIN_ATTRIBUTE = "processingChain";

  static final String PROCESSING_CHAIN_LAUNCH_CONFIGURATION_TYPE_NAME = ("de.fhdo.lemma." + 
    "model_processing.eclipse.launcher.ProcessingChainLaunchConfigurationType");

  static final ILaunchConfigurationType PROCESSING_CHAIN_LAUNCH_CONFIGURATION_TYPE = LaunchConfigurationConstants.LAUNCH_MANAGER.getLaunchConfigurationType(LaunchConfigurationConstants.PROCESSING_CHAIN_LAUNCH_CONFIGURATION_TYPE_NAME);

  static final String PROCESSING_CONFIGURATION_ATTRIBUTE = "processingConfiguration";

  static final String PROCESSING_CONFIGURATION_LAUNCH_CONFIGURATION_TYPE_NAME = ("de.fhdo.lemma." + 
    "model_processing.eclipse.launcher.ProcessingConfigurationLaunchConfigurationType");

  static final ILaunchConfigurationType PROCESSING_CONFIGURATION_LAUNCH_CONFIGURATION_TYPE = LaunchConfigurationConstants.LAUNCH_MANAGER.getLaunchConfigurationType(LaunchConfigurationConstants.PROCESSING_CONFIGURATION_LAUNCH_CONFIGURATION_TYPE_NAME);

  static final Map<ProcessorExecutableType, String> SUPPORTED_DEFAULT_BASIC_PROCESSOR_EXECUTION_COMMANDS = Collections.<ProcessorExecutableType, String>unmodifiableMap(CollectionLiterals.<ProcessorExecutableType, String>newHashMap(Pair.<ProcessorExecutableType, String>of(ProcessorExecutableType.LOCAL_DOCKER_IMAGE, "docker"), Pair.<ProcessorExecutableType, String>of(ProcessorExecutableType.LOCAL_JAVA_PROGRAM, "java")));
}
