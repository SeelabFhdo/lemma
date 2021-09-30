package de.fhdo.lemma.intermediate.transformations.ui.select_models_dialog.commands

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.ui.PlatformUI
import org.eclipse.core.resources.IProject
import java.util.Map
import java.util.List
import org.eclipse.core.resources.IFile
import org.eclipse.jface.window.Window
import de.fhdo.lemma.intermediate.transformations.ui.ModelFile
import de.fhdo.lemma.intermediate.transformations.ui.select_models_dialog.SelectModelsDialog
import de.fhdo.lemma.intermediate.transformations.ui.AbstractUiModelTransformationStrategy

/**
 * Handler for selecting models for intermediate model transformation.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class SelectModelsHandler extends AbstractHandler {
    val SHELL = PlatformUI.workbench.activeWorkbenchWindow.shell

    AbstractUiModelTransformationStrategy transformationStrategy
    Map<IProject, List<IFile>> inputModelFiles

    /**
     * Constructor
     */
    new(AbstractUiModelTransformationStrategy transformationStrategy,
        Map<IProject, List<IFile>> inputModelFiles) {
        if (transformationStrategy === null)
            throw new IllegalArgumentException("Transformation strategy must not be null")

        this.transformationStrategy = transformationStrategy
        this.inputModelFiles = inputModelFiles
    }

    /**
     * Execute handler
     */
    override execute(ExecutionEvent event) throws ExecutionException {
        if (inputModelFiles === null || inputModelFiles.empty) {
            val modelTypePrefix = transformationStrategy.modelTypePrefix
            MessageDialog.openInformation(SHELL, '''No «modelTypePrefix» models found''',
                '''No «modelTypePrefix» model files found. Transformation not possible.''')
            return null
        }

        /* Create dialog */
        val modelFiles = convertToModelFiles(inputModelFiles)
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