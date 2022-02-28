package de.fhdo.lemma.model_processing.eclipse.launcher

import org.eclipse.debug.core.DebugPlugin
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType
import org.eclipse.debug.ui.DebugUITools
import org.eclipse.ui.PlatformUI

/**
 * Constants for model processing launch configurations.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
interface LaunchConfigurationConstants {
    static val COMMON_LAUNCH_CONFIGURATION_TAB_NAME = "Common"
    static val COMMON_LAUNCH_CONFIGURATION_TAB_IMAGE = DebugUITools.getImage("IMG_OBJS_COMMON_TAB")
    static val CONSOLE_ERROR_COLOR = PlatformUI.workbench.themeManager.currentTheme.colorRegistry
        .get("org.eclipse.debug.ui.console.stream.err")

    static val LAUNCH_MANAGER = DebugPlugin.^default.launchManager

    static val PROCESSING_CHAIN_ATTRIBUTE = "processingChain"
    static val PROCESSING_CHAIN_LAUNCH_CONFIGURATION_TYPE_NAME = "de.fhdo.lemma." +
        "model_processing.eclipse.launcher.ProcessingChainLaunchConfigurationType"
    static val PROCESSING_CHAIN_LAUNCH_CONFIGURATION_TYPE = LAUNCH_MANAGER
        .getLaunchConfigurationType(PROCESSING_CHAIN_LAUNCH_CONFIGURATION_TYPE_NAME)

    static val PROCESSING_CONFIGURATION_ATTRIBUTE = "processingConfiguration"
    static val PROCESSING_CONFIGURATION_LAUNCH_CONFIGURATION_TYPE_NAME = "de.fhdo.lemma." +
        "model_processing.eclipse.launcher.ProcessingConfigurationLaunchConfigurationType"
    static val PROCESSING_CONFIGURATION_LAUNCH_CONFIGURATION_TYPE = LAUNCH_MANAGER
        .getLaunchConfigurationType(PROCESSING_CONFIGURATION_LAUNCH_CONFIGURATION_TYPE_NAME)

    static val SUPPORTED_DEFAULT_BASIC_PROCESSOR_EXECUTION_COMMANDS = #{
        ProcessorExecutableType.LOCAL_DOCKER_IMAGE -> "docker",
        ProcessorExecutableType.LOCAL_JAVA_PROGRAM -> "java"
    }
}