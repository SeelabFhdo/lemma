package de.fhdo.ddmm.eclipse.ui.transformation_dialog

import java.util.List
import de.fhdo.ddmm.eclipse.ui.ModelFile
import com.google.common.base.Predicate
import org.eclipse.swt.widgets.Display
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationException
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationExceptionKind
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Path
import de.fhdo.ddmm.eclipse.ui.utils.DdmmUiUtils
import de.fhdo.ddmm.eclipse.ui.ModelFileTypeDescription
import java.util.ArrayDeque
import java.util.Deque

/**
 * Thread to perform actual intermediate model transformations.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class TransformationThread extends Thread {
    List<ModelFile> modelFiles
    boolean outputRefinementModels
    volatile boolean stopTransformations
    volatile boolean continueTransformationAfterWarning
    Predicate<ModelFile> nextTransformationCallback
    Predicate<IntermediateTransformationException> transformationWarningCallback
    Predicate<Exception> transformationExceptionCallback
    Predicate<Void> currentTransformationFinishedCallback
    Predicate<Void> transformationsFinishedCallback
    Display display

    /**
     * Constructor
     */
    new(List<ModelFile> modelFiles,
        boolean outputRefinementModels,
        Display display,
        Predicate<ModelFile> nextTransformationCallback,
        Predicate<IntermediateTransformationException> transformationWarningCallback,
        Predicate<Exception> transformationExceptionCallback,
        Predicate<Void> currentTransformationFinishedCallback,
        Predicate<Void> transformationsFinishedCallback) {
        super()

        if (modelFiles === null || modelFiles.empty)
            throw new IllegalArgumentException("Input models must not be null or empty")

        this.modelFiles = modelFiles
        this.outputRefinementModels = outputRefinementModels
        this.nextTransformationCallback = nextTransformationCallback
        this.transformationExceptionCallback = transformationExceptionCallback
        this.transformationWarningCallback = transformationWarningCallback
        this.currentTransformationFinishedCallback = currentTransformationFinishedCallback
        this.transformationsFinishedCallback = transformationsFinishedCallback
        this.display = display
    }

    /**
     * Run model transformations on given files
     */
    override void run() {
        var int i
        while (i < modelFiles.size && !stopTransformations) {
            val modelFile = modelFiles.get(i)
            nextTransformationCallback.invokeGuiCallbackIfSpecified(modelFile)
            doTransformation(modelFile)
            currentTransformationFinishedCallback.invokeGuiCallbackIfSpecified()
            i++
        }
        transformationsFinishedCallback.invokeGuiCallbackIfSpecified()
    }

    /**
     * Perform transformation on a model file
     */
    private def doTransformation(ModelFile modelFile) {
        try {
            val sourceModelFile = modelFile.file
            val fileTypeDescription = modelFile.fileTypeDescription
            val targetPaths = buildTransformationTargetPaths(modelFile.transformationTargetPath,
                fileTypeDescription, outputRefinementModels)
            val mainTransformationStrategy = fileTypeDescription.mainTransformationStrategy
            val importTargetPaths = modelFile.children.toMap([importAlias],
                [transformationTargetPath])

            // Depending on strategy, enrich target paths of imports with children's children of
            // current model
            if (mainTransformationStrategy.considerChildrensChildrenForImportTargetPaths)
                modelFile.children.forEach[
                    importTargetPaths.putAll(
                        it.children.toMap([importAlias], [transformationTargetPath])
                    )
                ]

            // Perform main transformation
            var targetPath = targetPaths.pop()
            mainTransformationStrategy.mainTransformation(sourceModelFile, targetPath,
                importTargetPaths, [internalTransformationWarningCallback])

            // Perform optional refining transformations
            var previousTargetPath = targetPath
            for (i : 0..<fileTypeDescription.refiningTransformationStrategies.size) {
                // Get next path for refinement model output, if the user requested it. Otherwise,
                // each refinement step will overwrite the previous refinement model and the result
                // of the transformation will be the last refinement model located at the
                // transformation target path as specified in the dialog.
                if (outputRefinementModels)
                    targetPath = targetPaths.pop()

                val sourceFilePath = new Path(previousTargetPath)
                val sourceFile = ResourcesPlugin.getWorkspace().getRoot().getFile(sourceFilePath)

                val refiningStrategy = fileTypeDescription.refiningTransformationStrategies.get(i)
                refiningStrategy.refiningTransformation(sourceFile, targetPath,
                    [internalTransformationWarningCallback])

                previousTargetPath = targetPath
            }
        } catch(IntermediateTransformationException ex) {
            if (ex.kind === IntermediateTransformationExceptionKind.WARNING)
                internalTransformationWarningCallback(ex)
            else
                transformationExceptionCallback.invokeGuiCallbackIfSpecified(ex)
        } catch (Exception ex) {
            ex.printStackTrace
            transformationExceptionCallback.invokeGuiCallbackIfSpecified(ex)
        }
    }

    /**
     * Build target paths for transformations by considering refining transformations
     */
    private def Deque<String> buildTransformationTargetPaths(String initialTargetPath,
        ModelFileTypeDescription fileTypeDescription, boolean outputRefinementModels) {
        val targetPaths = new ArrayDeque()
        val refiningStrategiesCount = fileTypeDescription.refiningTransformationStrategies.size
        if (refiningStrategiesCount > 0 && outputRefinementModels) {
            val basicFilename = DdmmUiUtils.removeExtension(initialTargetPath)
            val ext = DdmmUiUtils.getExtension(initialTargetPath)
            for (i : 0..<refiningStrategiesCount)
                targetPaths.add(basicFilename + '''_«i+1».«ext»''')
        }

        targetPaths.add(initialTargetPath)
        return targetPaths
    }

    /**
     * Internal transformation warning callback
     */
    private def internalTransformationWarningCallback(IntermediateTransformationException warning) {
        return if (transformationWarningCallback !== null) {
            display.syncExec(new Runnable() {
                override run() {
                    continueTransformationAfterWarning =
                        transformationWarningCallback.apply(warning)
                }
            })

            continueTransformationAfterWarning
        } else
            true
    }

    /**
     * Helper to invoke a callback function in sync with the current display, i.e., the GUI. May
     * lead to aborting all transformations.
     */
    private def invokeGuiCallbackIfSpecified(Predicate<ModelFile> function, ModelFile arg) {
        if (function === null) {
            return
        }

        display.syncExec(new Runnable() {
            override run() {
                stopTransformations = !function.apply(arg)
            }
        })
    }

    /**
     * Helper to invoke a callback function in sync with the current display, i.e., the GUI. May
     * lead to aborting all transformations.
     */
    private def invokeGuiCallbackIfSpecified(Predicate<Exception> function, Exception arg) {
        if (function === null) {
            return
        }

        display.syncExec(new Runnable() {
            override run() {
                stopTransformations = !function.apply(arg)
            }
        })
    }

    /**
     * Helper to invoke a callback function in sync with the current display, i.e., the GUI. May
     * lead to aborting all transformations.
     */
    private def invokeGuiCallbackIfSpecified(Predicate<Void> function) {
        if (function === null) {
            return
        }

        display.syncExec(new Runnable() {
            override run() {
                stopTransformations = !function.apply(null)
            }
        })
    }
}