package de.fhdo.ddmm.eclipse.ui.specify_paths_dialog.commands

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import java.util.List
import de.fhdo.ddmm.eclipse.ui.ModelFile
import de.fhdo.ddmm.eclipse.ui.AbstractUiModelTransformationStrategy
import java.util.ArrayDeque
import de.fhdo.ddmm.eclipse.ui.specify_paths_dialog.SpecifyPathsDialog
import org.eclipse.ui.PlatformUI
import org.eclipse.jface.window.Window

/**
 * Handler for specifying paths on selected models.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class SpecifyPathsHandler extends AbstractHandler {
    val SHELL = PlatformUI.workbench.activeWorkbenchWindow.shell

    List<ModelFile> inputModelFiles
    AbstractUiModelTransformationStrategy strategy

    /**
     * Constructor
     */
    new(List<ModelFile> inputModelFiles, AbstractUiModelTransformationStrategy strategy) {
        if (inputModelFiles === null)
            throw new IllegalArgumentException("Model files must not be null")
        else if (inputModelFiles.empty)
            throw new IllegalArgumentException("Model files must not be empty")
        else if (strategy === null)
            throw new IllegalArgumentException("Strategy must not be null")

        this.inputModelFiles = inputModelFiles
        this.strategy = strategy
    }

    /**
     * Execute handler
     */
    override execute(ExecutionEvent event) throws ExecutionException {
        /* Create dialog */
        val dialog = new SpecifyPathsDialog(SHELL, strategy, createModelTableFiles())
        dialog.create()

        /*
         * Show dialog and handle user interactions
         */
        val dialogResult = dialog.open()

        return if (dialogResult === Window.OK)
            dialog.selectedModelFiles
        else
            null
    }

    /**
     * Create entries for the dialog's model file table. The result is a map that assigns model file
     * instances to their type identifiers. Thus, the dialog is able to display the model files in
     * the table according to the ordering of the model file types being specified in the current
     * UI-specific transformation strategy.
     */
    private def createModelTableFiles() {
        val result = <String, List<ModelFile>> newLinkedHashMap

        /*
         * Setup data structures to keep track of the iteration for model table entries resulting
         * from model files being directly or indirectly, i.e., transitively, imported by the input
         * model files.
         */
        val filesTodo = new ArrayDeque<ModelFile>(inputModelFiles)
        val filesDone = <String> newHashSet

        /*
         * Iterate over model files and scan for additional table entries, i.e., imported model
         * files as children of the already found model files.
         */
        while (!filesTodo.empty) {
            val currentFile = prepareModelFile(filesTodo.pop)
            val currentFileFullPath = currentFile.file.location.toString

            // Scan for additional children only, if the file hasn't been treated already
            if (!filesDone.contains(currentFileFullPath)) {
                /* Add file to result map */
                val fileTypeId = strategy
                    .getModelFileTypeIdentifierAndDescription(currentFile.file.fileExtension)
                    .key
                var resultModelFilesByTypeList = result.get(fileTypeId)
                if (resultModelFilesByTypeList === null) {
                    resultModelFilesByTypeList = <ModelFile> newArrayList
                    result.put(fileTypeId, resultModelFilesByTypeList)
                }
                resultModelFilesByTypeList.add(currentFile)

                /* Handle "children" model files being imported by current file */
                val preparedImportedModelFiles = prepareImportedModelFiles(currentFile)

                // Add the prepared, imported model files as children to the current file if it
                // hasn't already been scanned for children before
                if (!currentFile.scannedForChildren) {
                    currentFile.children.addAll(preparedImportedModelFiles)
                    currentFile.scannedForChildren = true
                }

                // Add (possibly new) children to the iteration stack
                filesTodo.addAll(preparedImportedModelFiles)

                /* Mark current file as having been treated before the next iteration step begins */
                filesDone.add(currentFileFullPath)
            }
        }

        return result
    }

    /**
     * Get model files being imported by a given model file and prepare them for the model table
     */
    private def prepareImportedModelFiles(ModelFile modelFile) {
        /*
         * Prepare existing child entries if the file has already been scanned for children. This is
         * the case if the user expanded the parent entry in the previous model tree dialog
         */
        return if (modelFile.scannedForChildren)
            modelFile.children.map[prepareModelFile(it)]
        /*
         * If the model file hasn't been scanned for children before, create new ModelFile instances
         * for the model files it imports and prepare them for the table
         */
        else {
            val preparedModelFiles = <ModelFile> newArrayList
            strategy.getImportedModelFiles(modelFile).forEach[importAlias, file |
                val newModelFile = new ModelFile(
                    file,
                    strategy.getModelFileTypeDescription(file.fileExtension),
                    null,
                    importAlias
                )
                preparedModelFiles.add(prepareModelFile(newModelFile))
            ]
            preparedModelFiles
        }
    }

    /**
     * Prepare model file for the table of model files
     */
    private def prepareModelFile(ModelFile modelFile) {
        // Select model files for transformation by default
        modelFile.selectedForTransformation = true

        // Default transformation target path
        modelFile.transformationTargetPath =
            strategy.getDefaultTransformationTargetPath(modelFile.file)

        return modelFile
    }
}