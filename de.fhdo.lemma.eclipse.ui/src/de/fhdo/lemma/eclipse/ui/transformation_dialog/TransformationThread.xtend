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
import de.fhdo.lemma.intermediate.transformations.IntermediateTransformationException
import de.fhdo.lemma.intermediate.transformations.AbstractIntermediateModelTransformationStrategy
import org.eclipse.core.resources.IFile
import java.util.Map
import de.fhdo.lemma.utils.LemmaUtils
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils
import java.util.LinkedList
import java.util.LinkedHashMap
import java.util.HashMap

/**
 * Thread to perform actual intermediate model transformations.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class TransformationThread extends Thread {
    List<ModelFile> modelFiles
    boolean convertToRelativeUris
    boolean outputRefinementModels
    volatile boolean stopTransformations
    volatile boolean continueTransformationAfterWarning
    Predicate<ModelFile> nextTransformationCallback
    Predicate<IntermediateTransformationException> transformationWarningCallback
    Predicate<Exception> transformationExceptionCallback
    Predicate<List<TransformationResult>> currentTransformationFinishedCallback
    Predicate<List<TransformationResult>> transformationsFinishedCallback
    Display display

    LinkedHashMap<
        AbstractIntermediateModelTransformationStrategy<?, ?>,
        (List<TransformationResult>, Predicate<IntermediateTransformationException>)
            =>List<TransformationResult>
    > transformationsFinishedListeners

    /**
     * Constructor
     */
    new(
        LinkedList<ModelFile> modelFiles,
        boolean convertToRelativeUris,
        boolean outputRefinementModels,
        Display display,
        Predicate<ModelFile> nextTransformationCallback,
        Predicate<IntermediateTransformationException> transformationWarningCallback,
        Predicate<Exception> transformationExceptionCallback,
        Predicate<List<TransformationResult>> currentTransformationFinishedCallback,
        Predicate<List<TransformationResult>> transformationsFinishedCallback
    ) {
        super()

        if (modelFiles === null || modelFiles.empty)
            throw new IllegalArgumentException("Input models must not be null or empty")

        this.modelFiles = modelFiles
        this.convertToRelativeUris = convertToRelativeUris
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
        transformationsFinishedListeners = newLinkedHashMap
        val allTransformationStrategiesAndResults = new TransformationResultsPerStrategy()

        for (var i = 0; i < modelFiles.size && !stopTransformations; i++) {
            val modelFile = modelFiles.get(i)
            nextTransformationCallback.invokeCallbackIfSpecified(modelFile)

            val transformationStrategyAndResults = modelFile.executeTransformations
            if (transformationStrategyAndResults !== null) {
                val strategy = transformationStrategyAndResults.key
                val results = transformationStrategyAndResults.value
                allTransformationStrategiesAndResults.put(strategy, results)
                currentTransformationFinishedCallback.invokeCallbackIfSpecified(
                    results.unmodifiableView
                )
            } else
                currentTransformationFinishedCallback.invokeCallbackIfSpecified(emptyList)
        }

        val allTransformationResults = allTransformationStrategiesAndResults.values.flatten.toList
        allTransformationResults.convertModelPathsToAbsoluteFileUris()
        val additionalResults = executeTransformationsFinishedListeners(allTransformationResults)
        additionalResults.forEach[strategy, results |
            allTransformationStrategiesAndResults.putIfAbsent(strategy, results)?.addAll(results)
            allTransformationResults.addAll(results)
        ]
        transformationsFinishedCallback.invokeCallbackIfSpecified(
            allTransformationResults.unmodifiableView
        )

        if (convertToRelativeUris) {
            allTransformationStrategiesAndResults.forEach[strategy, results |
                results.forEach[
                    strategy.makeUrisRelative(it)
                    it.outputModel.resource.save(emptyMap())
                ]
            ]
        }
    }

    /**
     * Type alias for
     * HashMap<AbstractIntermediateModelTransformationStrategy<?, ?>, List<TransformationResult>>
     */
    private static class TransformationResultsPerStrategy extends
        HashMap<AbstractIntermediateModelTransformationStrategy<?, ?>, List<TransformationResult>>{}

    /**
     * Execute main and refining transformations on a model file
     */
    private def
    Pair<AbstractIntermediateModelTransformationStrategy<?, ?>, List<TransformationResult>>
    executeTransformations(ModelFile modelFile) {
        try {
            val results = <TransformationResult>newArrayList

            /* Build output paths */
            val outputPaths = buildTransformationOutputPaths(modelFile.transformationTargetPath,
                modelFile.fileTypeDescription, outputRefinementModels)

            /* Perform main transformation */
            val mainOutputPath = outputPaths.get(0)
            val mainTransformationResultAndStrategy = modelFile.mainTransformation(mainOutputPath)
            val maintransformationStrategy = mainTransformationResultAndStrategy.key
            val mainTransformationResult = mainTransformationResultAndStrategy.value

            if (mainTransformationResult !== null)
                results.add(mainTransformationResult)
            else
                return null

            /* Perform refining transformations */
            val refiningTransformationResults = modelFile.refiningTransformations(outputPaths)

            if (refiningTransformationResults !== null)
                results.addAll(refiningTransformationResults)
            else
                return null

            return maintransformationStrategy -> results
        } catch(IntermediateTransformationException ex) {
            if (ex.kind === IntermediateTransformationExceptionKind.WARNING)
                internalTransformationWarningCallback(ex)
            else
                transformationExceptionCallback.invokeCallbackIfSpecified(ex)

            return null
        } catch (Exception ex) {
            ex.printStackTrace
            transformationExceptionCallback.invokeCallbackIfSpecified(ex)
            return null
        }
    }

    /**
     * Build output paths for transformations by considering refining transformations
     */
    private def List<String> buildTransformationOutputPaths(
        String initialOutputPath,
        ModelFileTypeDescription fileTypeDescription,
        boolean outputRefinementModels
    ) {
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
     * Execute main transformation on a model file
     */
    private def Pair<AbstractIntermediateModelTransformationStrategy<?, ?>, TransformationResult>
    mainTransformation(ModelFile modelFile, String outputPath) {
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
        return strategy -> modelFile.file.executeTransformation(strategy, outputPath,
            #{outputPath -> importTargetPaths})
    }

    /**
     * Execute a single transformation strategy on an input file
     */
    private def TransformationResult executeTransformation(
        IFile inputFile,
        AbstractIntermediateModelTransformationStrategy<?, ?> strategy,
        String outputPath,
        Map<String, Map<String, String>> targetPathsOfImports
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
            transformationsFinishedListeners.put(strategy, finishedListener)

        return transformationResult
    }

    /**
     * Execute refining transformations on a model file
     */
    private def List<TransformationResult> refiningTransformations(ModelFile modelFile,
        List<String> outputPaths) {
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
            val transformationResult = inputFile.executeTransformation(strategy, outputFilePath,
                null)

            if (transformationResult !== null)
                transformationResults.add(transformationResult)
            else
                return null
        }

        return transformationResults
    }

    /**
     * Convert the paths of input and output models in the given set of transformation results to
     * absolute file URIs
     */
    private def convertModelPathsToAbsoluteFileUris(List<TransformationResult> results) {
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
    }

    /**
     * Execute transformation finished listeners
     */
    private def executeTransformationsFinishedListeners(List<TransformationResult> results) {
        // Collect additional transformation results originating from post-actions of
        // transformations finished listeners, e.g., on previous transformation results
        val additionalResultsPerStrategy = new TransformationResultsPerStrategy()

        try {
            transformationsFinishedListeners.forEach[strategy, listener |
            val additionalResults = listener.apply(results, [internalTransformationWarningCallback])
            if (additionalResults !== null && !additionalResults.empty)
                additionalResultsPerStrategy.put(strategy, additionalResults)
            ]
        } catch(IntermediateTransformationException ex) {
            if (ex.kind === IntermediateTransformationExceptionKind.WARNING)
                internalTransformationWarningCallback(ex)
            else
                transformationExceptionCallback.invokeCallbackIfSpecified(ex)
        } catch (Exception ex) {
            ex.printStackTrace
            transformationExceptionCallback.invokeCallbackIfSpecified(ex)
        }

        return additionalResultsPerStrategy
    }

    /**
     * Internal transformation warning callback
     */
    private def internalTransformationWarningCallback(IntermediateTransformationException warning) {
        if (transformationWarningCallback === null)
            return true

        if (display !== null)
            display.syncExec(new Runnable() {
                override run() {
                    continueTransformationAfterWarning =
                        transformationWarningCallback.apply(warning)
                }
            })
        else
            continueTransformationAfterWarning = transformationWarningCallback.apply(warning)

        return continueTransformationAfterWarning
    }

    /**
     * Helper to invoke a callback function. In case a Display instance is available, i.e., we're in
     * a GUI thread, the function invocation will happen in sync with GUI thread.
     */
    private def invokeCallbackIfSpecified(Predicate<ModelFile> function, ModelFile modelFile) {
        if (function === null) {
            return
        }

        if (display !== null)
            display.syncExec(new Runnable() {
                override run() {
                    stopTransformations = !function.apply(modelFile)
                }
            })
        else
            stopTransformations = !function.apply(modelFile)
    }

    /**
     * Helper to invoke a callback function. In case a Display instance is available, i.e., we're in
     * a GUI thread, the function invocation will happen in sync with GUI thread.
     */
    private def invokeCallbackIfSpecified(Predicate<Exception> function, Exception exception) {
        if (function === null) {
            return
        }

        if (display !== null)
            display.syncExec(new Runnable() {
                override run() {
                    stopTransformations = !function.apply(exception)
                }
            })
        else
            stopTransformations = !function.apply(exception)
    }

    /**
     * Helper to invoke a callback function. In case a Display instance is available, i.e., we're in
     * a GUI thread, the function invocation will happen in sync with GUI thread.
     */
    private def invokeCallbackIfSpecified(Predicate<List<TransformationResult>> function,
        List<TransformationResult> transformationResults) {
        if (function === null) {
            return
        }

        if (display !== null)
            display.syncExec(new Runnable() {
                override run() {
                    stopTransformations = !function.apply(transformationResults)
                }
            })
        else
            stopTransformations = !function.apply(transformationResults)
    }
}