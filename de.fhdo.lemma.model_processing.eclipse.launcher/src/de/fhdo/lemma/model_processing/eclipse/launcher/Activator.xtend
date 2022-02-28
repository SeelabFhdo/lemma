package de.fhdo.lemma.model_processing.eclipse.launcher

import org.eclipse.ui.plugin.AbstractUIPlugin
import org.osgi.framework.BundleContext
import org.eclipse.swt.widgets.FileDialog
import org.eclipse.swt.SWT
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui.LocalDockerImageSelectionDialog
import org.eclipse.jface.window.Window
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableTypesInformationManager
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableTypesInformationManager.ProcessorExecutableTypeInformation

/**
 * Activate the launcher plugin.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class Activator extends AbstractUIPlugin {
    /**
     * Catch bundle start
     */
    final override start(BundleContext context) {
        super.start(context)

        registerProcessorExecutableTypes()
    }

    /**
     * Register the types of processor executables
     */
    private def registerProcessorExecutableTypes() {
        ProcessorExecutableTypesInformationManager.register(
            new ProcessorExecutableTypeInformation(
                ProcessorExecutableType.LOCAL_DOCKER_IMAGE,
                "Local Docker Image",
                "local Docker image",
                [shell, processingConfiguration |
                    val dialog = new LocalDockerImageSelectionDialog(shell,
                        processingConfiguration.basicProcessorExecutionCommand)
                    return if (dialog.open == Window.OK)
                            dialog.selectedImage
                        else
                            null
                ]
            ),

            new ProcessorExecutableTypeInformation(
                ProcessorExecutableType.LOCAL_JAVA_PROGRAM,
                "Local Java Program",
                "local Java program",
                [shell, _ |
                    val dialog = new FileDialog(shell, SWT.OPEN)
                    dialog.text = "Select local Java program"
                    dialog.filterExtensions = #["*.jar"]
                    dialog.open
                ]
            ),

            new ProcessorExecutableTypeInformation(
                ProcessorExecutableType.RAW_EXECUTABLE,
                "Raw executable",
                "raw executable",
                null
            )
        )
    }
}