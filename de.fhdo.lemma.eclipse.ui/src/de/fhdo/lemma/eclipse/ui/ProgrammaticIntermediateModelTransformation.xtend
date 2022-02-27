package de.fhdo.lemma.eclipse.ui

import org.eclipse.core.resources.IFile
import java.util.List
import de.fhdo.lemma.eclipse.ui.transformation_dialog.TransformationThread
import java.util.ArrayDeque
import com.google.common.base.Predicate
import de.fhdo.lemma.intermediate.transformations.AbstractIntermediateModelTransformationStrategy.TransformationResult
import org.eclipse.xtend.lib.annotations.Accessors
import de.fhdo.lemma.eclipse.ui.ModelFile
import java.util.Set
import org.eclipse.swt.widgets.Display

/**
 * Helper to programmatically execute intermediate model transformations on a model file and its
 * children.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ProgrammaticIntermediateModelTransformation {
    // List of all supported transformation strategies. We use explicit constructor calls here to
    // ensure that the introduction of parameterized constructors results in a compilation error.
    static val List<() => AbstractUiModelTransformationStrategy>
        AVAILABLE_TRANSFORMATION_STRATEGY_CONSTRUCTORS = #[
            [new ServiceModelTransformationStrategy()],
            [new OperationModelTransformationStrategy()]
        ]

    @Accessors(PUBLIC_GETTER)
    val AbstractUiModelTransformationStrategy strategy
    @Accessors(PUBLIC_GETTER)
    val ModelFile rootModelFile
    val Set<ModelFile> resolvedChildren

    var String intent
    var Object data
    var List<Predicate<ModelFile>> nextTransformationCallbacks
    var List<Predicate<ProgrammaticIntermediateModelTransformationException>>
        transformationExceptionCallbacks
    var List<
        Predicate<List<ProgrammaticIntermediateModelTransformationResult>>
    > transformationSuccessfulCallbacks
    // First list = results of all successful transformations, second list = all caught exceptions
    var List<(
            List<ProgrammaticIntermediateModelTransformationResult>,
            List<ProgrammaticIntermediateModelTransformationException>
        )=>Boolean
    > transformationsFinishedCallbacks
    var boolean exceptionInCurrentTransformation
    var List<ProgrammaticIntermediateModelTransformationException> transformationExceptions

    /**
     * Constructor
     */
    new(IFile rootFile) {
        if (rootFile === null)
            throw new IllegalArgumentException("Root file must not be null")

        // Get transformation strategy for the root model file
        strategy = rootFile.fileExtension.transformationStrategy
        if (strategy === null)
            throw new IllegalArgumentException("No transformation strategy found for file " +
                '''«rootFile.rawLocation.makeAbsolute.toString» of type *.''' +
                rootFile.fileExtension)

        // Convert the root model file to a ModelFile instance
        rootModelFile = rootFile.toModelFile(strategy)
        if (!rootModelFile.supportsTransformation)
            throw new IllegalArgumentException('''Intermediate model transformation is not ''' +
                '''supported for files of type *.«rootFile.fileExtension» ''')

        // Resolve all children of the root model file including transitive ones
        resolvedChildren = rootModelFile.resolveTransitiveChildren
    }

    /**
     * Retrieve a transformation strategy from a given model file extension
     */
    static def getTransformationStrategy(String fileExtension) {
        for (strategyConstructor : AVAILABLE_TRANSFORMATION_STRATEGY_CONSTRUCTORS) {
            val strategy = strategyConstructor.apply()
            if (strategy.modelFileTypeExtensions.contains(fileExtension))
                return strategy
        }

        return null
    }

    /**
     * Convert an IFile instance to a ModelFile instance if the given strategy permits it
     */
    private static def toModelFile(IFile file, AbstractUiModelTransformationStrategy strategy) {
        val modelFileTypeDescription = strategy.getModelFileTypeDescription(file.fileExtension)
        if (modelFileTypeDescription === null)
            return null

        val modelFile = new ModelFile(file, modelFileTypeDescription)
        modelFile.transformationTargetPath = file.buildTransformationTargetPath(strategy)
        return modelFile
    }

    /**
     * Build the strategy-specific transformation target path of the given IFile. The target path
     * consists of the IFile's project path and the strategy-specific default transformation target
     * path.
     */
    private static def buildTransformationTargetPath(IFile file,
        AbstractUiModelTransformationStrategy transformationStrategy) {
        val projectRelativePath = transformationStrategy.getDefaultTransformationTargetPath(file)
        return file.project.fullPath + projectRelativePath
    }

    /**
     * Check if a model clustered in an IFile instance supports transformation
     */
    static def supportsTranformation(IFile file) {
        val strategy = file?.fileExtension?.getTransformationStrategy
        return strategy !== null && file.toModelFile(strategy).supportsTransformation
    }

    /**
     * Helper to check if model represented by a ModelFile instance supports transformation
     */
    private static def supportsTransformation(ModelFile modelFile) {
        return modelFile !== null && modelFile.fileTypeDescription.canBeTransformed
    }

    /**
     * Resolve all transitive children of a ModelFile. The returned list will contain all transitive
     * children as ModelFile instances. The method takes care of their proper initialization which
     * also entails the resolution of childs' children.
     */
    private def resolveTransitiveChildren(ModelFile modelFile) {
        modelFile.children = modelFile.importedTransformableModelFiles
        val todoModelFiles = new ArrayDeque<ModelFile>
        todoModelFiles.addAll(modelFile.children)
        val resolvedChildren = <ModelFile>newHashSet

        while (!todoModelFiles.empty) {
            val currentModelFile = todoModelFiles.pop
            currentModelFile.children = currentModelFile.importedTransformableModelFiles

            if (resolvedChildren.add(currentModelFile)) {
                val nextModelFiles = currentModelFile.children
                    .filter[!resolvedChildren.contains(it)]
                todoModelFiles.addAll(nextModelFiles)
            }
        }

        return resolvedChildren
    }

    /**
     * Get the transformable model files imported by a given model file
     */
    private def getImportedTransformableModelFiles(ModelFile parentModelFile) {
        if (!parentModelFile.supportsTransformation)
            return emptyList

        val importedModelFiles = <ModelFile>newArrayList
        val importedFileByAlias = strategy.getImportedModelFiles(parentModelFile)
            .mapValues[toModelFile(strategy)]

        for (aliasAndFile : importedFileByAlias.entrySet) {
            val importedModelFile = aliasAndFile.value
            if (importedModelFile.supportsTransformation) {
                importedModelFile.importAlias = aliasAndFile.key
                importedModelFiles.add(importedModelFile)
            }
        }

        return importedModelFiles
    }

    /**
     * Run transformations on the root model file and its children.
     *
     * @param intent Supports the identification of the transformation intent by callbacks. Must not
     *               be null or empty.
     * @param data Arbitrary data that together with the intent is passed to callbacks. May be null.
     * @param display Reference to a Display instance in a GUI thread. May be null if the
     *                transformation takes place outside the GUI thread.
     * @param runBlocking Forces the thread that invoked the transformation to wait until all
     *                    transformations were finished.
     * @param nextTransformationCallback Callback that the next transformation is about to begin.
     *                                   May be null.
     * @param transformationExceptionCallback Callback that a transformation occurred. In this case,
     *                                        there will be no transformationSuccessfulCallback. May
     *                                        be null.
     * @param transformationSuccessfulCallback Callback that the transformation was successful. In
     *                                         this case, there will be no
     *                                         transformationExceptionCallback. May be null.
     * @param transformationSuccessfulCallback Callback that all transformations were finished.
     *                                         May be null.
     */
    def run(
        String intent,
        Object data,
        Display display,
        boolean runBlocking,
        Predicate<ModelFile> nextTransformationCallback,
        Predicate<ProgrammaticIntermediateModelTransformationException>
            transformationExceptionCallback,
        Predicate<List<
            ProgrammaticIntermediateModelTransformationResult
        >> transformationSuccessfulCallback,
        (
            List<ProgrammaticIntermediateModelTransformationResult>,
            List<ProgrammaticIntermediateModelTransformationException>
        )=>Boolean
        transformationsFinishedCallback
    ) {
        run(
            intent,
            data,
            display,
            runBlocking,
            #[nextTransformationCallback],
            #[transformationExceptionCallback],
            #[transformationSuccessfulCallback],
            #[transformationsFinishedCallback]
        )
    }

    /**
     * Bulk version of run() that can take more than one callback per transformation event
     */
    def run(
        String intent,
        Object data,
        Display display,
        boolean runBlocking,
        List<Predicate<ModelFile>> nextTransformationCallbacks,
        List<Predicate<ProgrammaticIntermediateModelTransformationException>>
            transformationExceptionCallbacks,
        List<
            Predicate<List<ProgrammaticIntermediateModelTransformationResult>>
        > transformationSuccessfulCallbacks,
        List<(
                List<ProgrammaticIntermediateModelTransformationResult>,
                List<ProgrammaticIntermediateModelTransformationException>
            )=>Boolean
        > transformationsFinishedCallbacks
    ) {
        if (intent.nullOrEmpty)
            throw new IllegalArgumentException("Transformation intent must not be null or empty")

        this.intent = intent
        this.data = data
        this.nextTransformationCallbacks = nextTransformationCallbacks
        this.transformationExceptionCallbacks = transformationExceptionCallbacks
        this.transformationSuccessfulCallbacks = transformationSuccessfulCallbacks
        this.transformationsFinishedCallbacks = transformationsFinishedCallbacks
        transformationExceptions = newArrayList

        val transformationThread = new TransformationThread(
            getModelFilesToTransform(),
            true,   // Always perform relative URI conversion
            false,  // Don't output refinement results
            display,
            [nextTransformationCallback],
            null,   // Ignore warnings
            [transformationExceptionCallback],
            [transformationSuccessfulCallback],
            [transformationsFinishedCallback]
        )
        transformationThread.start()

        if (runBlocking)
            transformationThread.join()
    }

    /**
     * Get all model files to transform. The resulting list contains the root model file and its
     * transitive children ordered by their strategy-specific transformation order.
     */
    private def getModelFilesToTransform() {
        val modelFilesToTransform = newArrayList(rootModelFile)
        modelFilesToTransform.addAll(resolvedChildren)
        return strategy.sortByTransformationOrder(modelFilesToTransform)
    }

    /**
     * Invoke callbacks that the next transformation is about to begin
     */
    private def nextTransformationCallback(ModelFile modelFile) {
        exceptionInCurrentTransformation = false
        return nextTransformationCallbacks.runTransformationCallbacks(modelFile)
    }

    /**
     * Helper to run a list of transformation callbacks. The return value indicates whether a
     * transformation signaled to continue transformations or stop them.
     */
    private def <T> runTransformationCallbacks(List<Predicate<T>> callbacks, T argument) {
        if (callbacks === null)
            return true

        for (callback : callbacks) {
            val continueTransformations = callback.apply(argument)
            if (!continueTransformations)
                return false
        }

        return true
    }

    /**
     * Invoke callbacks that a transformation exception occurred
     */
    private def transformationExceptionCallback(Exception exception) {
        exceptionInCurrentTransformation = true
        val transformationException = new ProgrammaticIntermediateModelTransformationException(
            exception,
            intent,
            data
        )
        transformationExceptions.add(transformationException)

        return transformationExceptionCallbacks.runTransformationCallbacks(transformationException)
    }

    /**
     * Class to bundle a transformation exception with transformation intent and data
     */
    static class ProgrammaticIntermediateModelTransformationException extends Exception {
        @Accessors(PUBLIC_GETTER)
        String intent
        @Accessors(PUBLIC_GETTER)
        Object data

        new (Exception cause, String intent, Object data) {
            super(cause.message, cause)
            this.intent = intent
            this.data = data
        }
    }

    /**
     * Invoke callbacks that the current transformation was finished successfully. In case there
     * occurred an exception before, the callbacks will not be invoked.
     */
    private def transformationSuccessfulCallback(List<TransformationResult> results) {
        // In case there occurred an exception and this method is still called, the exception
        // callbacks decided to continue the transformation. While we don't invoke the callbacks
        // for successful transformation, we still continue the transformation as per the decision
        // of the exception callbacks.
        if (exceptionInCurrentTransformation)
            return true

        val transformationResults = results.toProgrammaticTransformationResults()
        return transformationSuccessfulCallbacks.runTransformationCallbacks(transformationResults)
    }

    /**
     * Convert a list of transformation results to ProgrammaticIntermediateModelTransformationResult
     * instances
     */
    private def toProgrammaticTransformationResults(List<TransformationResult> results) {
        return results.map[new ProgrammaticIntermediateModelTransformationResult(it, intent, data)]
            .toList
    }

    /**
     * Class to bundle a transformation result with transformation intent and data
     */
    static class ProgrammaticIntermediateModelTransformationResult extends Exception {
        @Accessors(PUBLIC_GETTER)
        TransformationResult result
        @Accessors(PUBLIC_GETTER)
        String intent
        @Accessors(PUBLIC_GETTER)
        Object data

        new (TransformationResult result, String intent, Object data) {
            this.result = result
            this.intent = intent
            this.data = data
        }
    }

    /**
     * Invoke callbacks that the current transformation finished
     */
    private def transformationsFinishedCallback(List<TransformationResult> results) {
        val transformationResults = results.toProgrammaticTransformationResults()
        return transformationsFinishedCallbacks.runTransformationCallbacks(transformationResults,
            transformationExceptions)
    }

    /**
     * Helper to run a list of transformation callbacks of which each takes two arguments. The
     * return value indicates whether a transformation signaled to continue transformations or stop
     * them.
     */
    private def <T1, T2> runTransformationCallbacks(List<(T1, T2)=>Boolean> callbacks, T1 argument1,
        T2 argument2) {
        if (callbacks === null)
            return true

        for (callback : callbacks) {
            val continueTransformations = callback.apply(argument1, argument2)
            if (!continueTransformations)
                return false
        }

        return true
    }
}