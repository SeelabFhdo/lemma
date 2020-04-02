package de.fhdo.lemma.eclipse.ui.transformation_dialog

import java.util.List
import de.fhdo.lemma.eclipse.ui.ModelFile
import com.google.common.base.Predicate
import org.eclipse.swt.widgets.Display
import de.fhdo.lemma.intermediate.transformations.IntermediateTransformationExceptionKind
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Path
import de.fhdo.lemma.eclipse.ui.ModelFileTypeDescription
import de.fhdo.lemma.intermediate.transformations.AbstractIntermediateModelTransformationStrategy.TransformationResult
import java.util.LinkedHashSet
import java.util.function.BiFunction
import de.fhdo.lemma.intermediate.transformations.IntermediateTransformationException
import de.fhdo.lemma.intermediate.transformations.AbstractIntermediateModelTransformationStrategy
import org.eclipse.core.resources.IFile
import java.util.Map
import de.fhdo.lemma.utils.LemmaUtils
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils
import java.util.LinkedList

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
    new(LinkedList<ModelFile> modelFiles,
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
        val transformationsFinishedListeners = <BiFunction<
            List<TransformationResult>,
            Predicate<IntermediateTransformationException>,
            Void
        >>newLinkedHashSet
        val transformationResults = <TransformationResult>newArrayList

        for (var i = 0; i < modelFiles.size && !stopTransformations; i++) {
            val modelFile = modelFiles.get(i)
            nextTransformationCallback.invokeGuiCallbackIfSpecified(modelFile)
            val transformationListenersAndResults = modelFile.executeTransformations
            transformationsFinishedListeners.addAll(transformationListenersAndResults.key)
            transformationResults.addAll(transformationListenersAndResults.value)
            currentTransformationFinishedCallback.invokeGuiCallbackIfSpecified()
        }

        executeTransformationsFinishedListeners(transformationsFinishedListeners,
            transformationResults)
        transformationsFinishedCallback.invokeGuiCallbackIfSpecified()
    }

    /**
     * Execute main and refining transformations on a model file
     */
    private def Pair<
        List<
            BiFunction<List<TransformationResult>,
            Predicate<IntermediateTransformationException>,
            Void>
        >,
        List<TransformationResult>
    > executeTransformations(ModelFile modelFile) {
        val transformationsFinishedListeners = <BiFunction<
            List<TransformationResult>,
            Predicate<IntermediateTransformationException>,
            Void
        >>newArrayList
        val results = <TransformationResult>newArrayList
        var exceptionOccurred = false

        try {
            /* Build output paths */
            val outputPaths = buildTransformationOutputPaths(modelFile.transformationTargetPath,
                modelFile.fileTypeDescription, outputRefinementModels)

            /* Perform main transformation */
            val mainTransformationResult = modelFile.mainTransformation(
                outputPaths.get(0),
                transformationsFinishedListeners
            )

            if (mainTransformationResult !== null)
                results.add(mainTransformationResult)
            else
                return emptyList -> emptyList

            /* Perform refining transformations */
            val refiningTransformationResults = modelFile.refiningTransformations(
                outputPaths,
                transformationsFinishedListeners
            )

            if (refiningTransformationResults !== null)
                results.addAll(refiningTransformationResults)
            else
                return emptyList -> emptyList
        } catch(IntermediateTransformationException ex) {
            if (ex.kind === IntermediateTransformationExceptionKind.WARNING)
                internalTransformationWarningCallback(ex)
            else
                transformationExceptionCallback.invokeGuiCallbackIfSpecified(ex)

            exceptionOccurred = true
        } catch (Exception ex) {
            ex.printStackTrace
            transformationExceptionCallback.invokeGuiCallbackIfSpecified(ex)
            exceptionOccurred = true
        }

        return if (!exceptionOccurred)
                transformationsFinishedListeners -> results
            else
                emptyList -> emptyList
    }

    /**
     * Build output paths for transformations by considering refining transformations
     */
    private def List<String> buildTransformationOutputPaths(String initialOutputPath,
        ModelFileTypeDescription fileTypeDescription, boolean outputRefinementModels) {
        val outputPaths = <String>newArrayList
        if (fileTypeDescription.refiningStrategiesCount > 0 && outputRefinementModels) {
            val basicFilename = LemmaUiUtils.removeExtension(initialOutputPath)
            val ext = LemmaUiUtils.getExtension(initialOutputPath)
            for (i : 0..<fileTypeDescription.refiningStrategiesCount)
                outputPaths.add(basicFilename + '''_«i+1».«ext»''')
        }

        outputPaths.add(initialOutputPath)
        return outputPaths
    }

    /**
     * Perform main transformation on a model file
     */
    private def TransformationResult mainTransformation(
        ModelFile modelFile,
        String outputPath,
        List<BiFunction<
            List<TransformationResult>,Predicate<IntermediateTransformationException>, Void
        >> transformationsFinishedListeners
    ) {
        val strategy = modelFile.fileTypeDescription.createMainTransformationStrategy
        val importTargetPaths = modelFile.children.toMap([importAlias], [transformationTargetPath])

        /* Enrich target paths of imports with children's children of current model if necessary */
        if (strategy.considerChildrensChildrenForImportTargetPaths)
            modelFile.children.forEach[
                importTargetPaths.putAll(
                    it.children.toMap([importAlias], [transformationTargetPath])
                )
            ]

        /* Execute the actual transformation */
        return modelFile.file.executeTransformation(
            strategy,
            outputPath,
            #{outputPath -> importTargetPaths},
            transformationsFinishedListeners
        )
    }

    /**
     * Perform refining transformations on a model file
     */
    private def List<TransformationResult> refiningTransformations(
        ModelFile modelFile,
        List<String> outputPaths,
        List<BiFunction<
            List<TransformationResult>,Predicate<IntermediateTransformationException>, Void
        >> transformationsFinishedListeners
    ) {
        val transformationResults = <TransformationResult>newArrayList

        var outputPathIndex = 0
        val fileTypeDescription = modelFile.fileTypeDescription
        for (strategyIndex : 0..<fileTypeDescription.refiningStrategiesCount) {
            /*
             * Determine input and output file path, depending on the user's decision to output
             * refined models or not
             */
            var Path inputFilePath
            var String outputFilePath

            if (outputRefinementModels) {
                inputFilePath = new Path(outputPaths.get(outputPathIndex))
                outputFilePath = outputPaths.get(outputPathIndex + 1)
                outputPathIndex++
            } else {
                inputFilePath = new Path(outputPaths.get(0))
                outputFilePath = outputPaths.get(0)
            }

            /* Execute the actual transformation */
            val strategy = fileTypeDescription.createRefiningTransformationStrategy(strategyIndex)
            val inputFile = ResourcesPlugin.getWorkspace().getRoot().getFile(inputFilePath)
            val transformationResult = inputFile.executeTransformation(
                strategy,
                outputFilePath,
                null,
                transformationsFinishedListeners
            )

            if (transformationResult !== null)
                transformationResults.add(transformationResult)
            else
                return null
        }

        return transformationResults
    }

    /**
     * Execute a single transformation strategy on an input file
     */
    private def TransformationResult executeTransformation(
        IFile inputFile,
        AbstractIntermediateModelTransformationStrategy strategy,
        String outputPath,
        Map<String, Map<String, String>> targetPathsOfImports,
        List<BiFunction<
            List<TransformationResult>,Predicate<IntermediateTransformationException>, Void
        >> transformationsFinishedListeners
    ) {
        /* Execute transformation */
        val transformationResult = strategy.doTransformationFromFiles(
            #[inputFile],
            #[outputPath],
            targetPathsOfImports,
            [internalTransformationWarningCallback]
        // We currently only support transformations with one output model
        )?.values?.get(0) as TransformationResult

        /* Register transformations finished listener */
        val finishedListener = strategy.registerTransformationsFinishedListener()
        if (finishedListener !== null && transformationResult !== null)
            transformationsFinishedListeners.add(finishedListener)

        return transformationResult
    }

    /**
     * Execute transformation finished listeners
     */
    private def executeTransformationsFinishedListeners(
        LinkedHashSet<BiFunction<
            List<TransformationResult>,
            Predicate<IntermediateTransformationException>,
            Void>> listeners,
        List<TransformationResult> results
    ) {
        /* Convert input and output model paths to file URIs */
        results.forEach[
            inputModels.forEach[
                // Input models' paths are always absolute already. Thus, add "file" scheme only.
                inputPath = LemmaUtils.convertToFileUri(inputPath)
            ]
            // Output models' paths are always relative to their project in the workspace. Thus,
            // convert them to absolute paths and add "file" scheme.
            outputModel.outputPath
                = LemmaUtils.convertProjectPathToAbsoluteFileUri(outputModel.outputPath)
        ]

        /* Execute listeners */
        try {
            listeners.forEach[apply(results, [internalTransformationWarningCallback])]
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
    private def internalTransformationWarningCallback(
        IntermediateTransformationException warning
    ) {
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