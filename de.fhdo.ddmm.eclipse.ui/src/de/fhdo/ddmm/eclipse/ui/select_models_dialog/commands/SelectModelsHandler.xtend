package de.fhdo.ddmm.eclipse.ui.select_models_dialog.commands

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import de.fhdo.ddmm.eclipse.ui.utils.DdmmUiUtils
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.ui.PlatformUI
import org.eclipse.core.resources.IProject
import java.util.Map
import java.util.List
import org.eclipse.core.resources.IFile
import org.eclipse.jface.window.Window
import de.fhdo.ddmm.eclipse.ui.ModelFile
import de.fhdo.ddmm.eclipse.ui.select_models_dialog.SelectModelsDialog
import de.fhdo.ddmm.eclipse.ui.AbstractUiModelTransformationStrategy

/**
 * Handler for selecting models for intermediate model transformation.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class SelectModelsHandler extends AbstractHandler {
    private val SHELL = PlatformUI.workbench.activeWorkbenchWindow.shell

    private AbstractUiModelTransformationStrategy transformationStrategy

    /**
     * Constructor
     */
    new(AbstractUiModelTransformationStrategy transformationStrategy) {
        if (transformationStrategy === null)
            throw new IllegalArgumentException("Transformation strategy must not be null")

        this.transformationStrategy = transformationStrategy
    }

    /**
     * Execute handler
     */
    override execute(ExecutionEvent event) throws ExecutionException {
        /* Find project-specific model files */
        val projectSpecificModelFiles = findProjectSpecificModelFiles()
        if (projectSpecificModelFiles === null || projectSpecificModelFiles.empty) {
            val modelTypePrefix = transformationStrategy.modelTypePrefix
            MessageDialog.openInformation(SHELL, '''No «modelTypePrefix» models found''',
                '''No «modelTypePrefix» model files found in the wokspace. Transformation not ''' +
                '''possible''')
            return null
        }

        /* Create dialog */
        val modelFiles = convertToModelFiles(projectSpecificModelFiles)
        val dialog = new SelectModelsDialog(SHELL, transformationStrategy, modelFiles)
        dialog.create()

        /*
         * Show dialog and handle user interactions
         */
        val dialogResult = dialog.open()
        if (dialogResult === Window.CANCEL)
            return null

        return if (dialogResult === Window.OK)
            dialog.selectedModelFiles
        else
            null
    }

    /**
     * Find model files according to strategy
     */
    private def findProjectSpecificModelFiles() {
        val modelTypePrefix = transformationStrategy.modelTypePrefix
        val modelTypeFileExtensions = transformationStrategy.modelFileTypeExtensions

        if (modelTypeFileExtensions === null || modelTypeFileExtensions.empty) {
            MessageDialog.openError(SHELL, '''No «modelTypePrefix» models found''', '''No ''' +
                '''«modelTypePrefix» model files could be found, because there were no editors ''' +
                '''associated with the respective file types. Do you have the editor plugins ''' +
                '''for creating «modelTypePrefix» models installed?''')

            return null
        }

        val modelFiles = transformationStrategy.findProjectSpecificModelFiles
        if (modelFiles === null || modelFiles.empty) {
            val extensionEnumeration = DdmmUiUtils.createEnumerationText(modelTypeFileExtensions)
            MessageDialog.openError(SHELL, '''No «modelTypePrefix» models found''', '''No ''' +
                '''«modelTypePrefix» model files with extensions «extensionEnumeration» could ''' +
                ''' be found in the workspace's projects.''')

            return null
        }

        return modelFiles
    }

    /**
     * Helper to convert the values of a map of source model files to ModelFile instances
     */
    private def convertToModelFiles(Map<IProject, List<IFile>> sourceModelFiles) {
        val convertedSourceModelFiles = <IProject, List<ModelFile>> newHashMap

        sourceModelFiles.forEach[project, files |
            val modelFiles = <ModelFile> newArrayList

            files.forEach[file |
                val modelFileTypeDescription = transformationStrategy
                    .getModelFileTypeDescription(file.fileExtension)
                val modelFile = new ModelFile(file, modelFileTypeDescription, project, null)
                modelFiles.add(modelFile)
            ]

            convertedSourceModelFiles.put(project, modelFiles)
        ]

        return convertedSourceModelFiles
    }
}