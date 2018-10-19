package de.fhdo.ddmm.eclipse.ui.transformation_dialog

import java.util.List
import de.fhdo.ddmm.eclipse.ui.ModelFile
import com.google.common.base.Predicate
import org.eclipse.swt.widgets.Display
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationException
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationExceptionKind
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Path

/**
 * Thread to perform actual intermediate model transformations.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class TransformationThread extends Thread {
    private List<ModelFile> modelFiles
    private volatile boolean stopTransformations
    private volatile boolean continueTransformationAfterWarning
    private Predicate<ModelFile> nextTransformationCallback
    private Predicate<IntermediateTransformationException> transformationWarningCallback
    private Predicate<Exception> transformationExceptionCallback
    private Predicate<Void> currentTransformationFinishedCallback
    private Predicate<Void> transformationsFinishedCallback
    private Display display

    /**
     * Constructor
     */
    new(List<ModelFile> modelFiles,
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
            val targetPath = modelFile.transformationTargetPath
            val fileTypeDescription = modelFile.fileTypeDescription
            val mainTransformationStrategy = fileTypeDescription.mainTransformationStrategy
            val importTargetPaths = modelFile.children.toMap([importAlias],
                [transformationTargetPath])

            // Perform main transformation
            mainTransformationStrategy.mainTransformation(sourceModelFile, targetPath,
                importTargetPaths, [internalTransformationWarningCallback])

            // Perform optional refining transformation
            fileTypeDescription.refiningTransformationStrategies.forEach[
                val sourceFilePath = new Path(targetPath)
                val sourceFile = ResourcesPlugin.getWorkspace().getRoot().getFile(sourceFilePath)
                // DEBUG
                val targetPathFragments = targetPath.split("/")
                targetPathFragments.set(targetPathFragments.length-1, "refined_" + targetPathFragments.last)
                var targetPath2 = targetPathFragments.join("/")
                refiningTransformation(sourceFile, targetPath2,
                    [internalTransformationWarningCallback])
            ]
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