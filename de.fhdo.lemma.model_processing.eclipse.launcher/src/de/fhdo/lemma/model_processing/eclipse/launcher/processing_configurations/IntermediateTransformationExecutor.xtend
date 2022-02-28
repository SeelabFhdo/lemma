package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations

import org.eclipse.ui.console.MessageConsoleStream
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration
import de.fhdo.lemma.eclipse.ui.ProgrammaticIntermediateModelTransformation
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Status
import de.fhdo.lemma.eclipse.ui.ModelFile
import de.fhdo.lemma.eclipse.ui.ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException
import java.util.List
import de.fhdo.lemma.eclipse.ui.ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult
import org.eclipse.core.runtime.SubMonitor
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*

/**
 * Class to execute intermediate model transformations from a given model processing launch
 * configuration. Basically, the executor is a wrapper for programmatic intermediate transformations
 * on LEMMA models to let them run using Eclipse's Job Framework.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class IntermediateTransformationExecutor {
    val ProcessingConfiguration configuration
    val MessageConsoleStream infoStream
    val MessageConsoleStream errorStream
    val ()=>void successfulCallback
    val ()=>void errorOrCancelCallback
    var IProgressMonitor monitor
    var boolean stopTransformations

    /**
     * Constructor. The successfulCallback will be invoked when all transformations were executed
     * without a single error and the user canceling transformation execution. The
     * errorOrCancelCallback will be invoked when a transformation occurred or the user canceled
     * transformation execution.
     */
    new(
        ProcessingConfiguration configuration,
        MessageConsoleStream infoStream,
        MessageConsoleStream errorStream,
        ()=>void successfulCallback,
        ()=>void errorOrCancelCallback
    ) {
        this.configuration = configuration
        this.infoStream = infoStream
        this.errorStream = errorStream
        this.successfulCallback = successfulCallback
        this.errorOrCancelCallback = errorOrCancelCallback
    }

    /**
     * Run the intermediate model transformation in a new Eclipse Job
     */
    final def run() {
        val job = new Job("LEMMA intermediate transformation") {
            override IStatus run(IProgressMonitor monitor) {
                val subMonitor = SubMonitor.convert(monitor, 1)
                IntermediateTransformationExecutor.this.monitor = subMonitor

                new ProgrammaticIntermediateModelTransformation(configuration.sourceModelFile).run(
                    "PROCESSING_CONFIGURATION_EXECUTION",
                    null,
                    null,
                    true,
                    [nextIntermediateTransformation],
                    [intermediateTransformationException],
                    [transformationSuccessful],
                    [results, exceptions | transformationsFinished(results, exceptions)]
                )

                return if (!subMonitor.canceled)
                        Status.OK_STATUS
                    else
                        Status.CANCEL_STATUS
            }
        }
        job.schedule()
    }

    /**
     * Callback when the next intermediate transformation is about to start
     */
    private def boolean nextIntermediateTransformation(ModelFile modelFile) {
        if (stopTransformations())
            return false

        infoStream.println("Running intermediate transformation of model file " +
            '''"«modelFile.file.project.fullPath»/«modelFile.file.projectRelativePath»"''')
        return !canceledByUser()
    }

    /**
     * Indicate whether all transformations shall be stopped which is the case when either the
     * stopTransformations flag was set or the user actively canceled the transformations
     */
    private def stopTransformations() {
        if (stopTransformations)
            return true
        else if (canceledByUser()) {
            stopTransformations = true
            return true
        } else
            return false
    }

    /**
     * Check whether the user actively canceled the transformations. If so, also print a message to
     * the error stream.
     */
    private def canceledByUser() {
        if (monitor.isCanceled) {
            errorStream.println("Transformations aborted by user")
            errorOrCancelCallback.apply()
        }

        return monitor.isCanceled
    }

    /**
     * Callback for transformation exceptions. The occurrence of an exception leads to a stop of all
     * transformations.
     */
    private def boolean intermediateTransformationException(
        ProgrammaticIntermediateModelTransformationException ex
    ) {
        if (!stopTransformations()) {
            errorStream.println("\t" + '''Error: «ex.message»''' + "\n\tTransformations aborted.")
            stopTransformations = true
        }
        monitor.worked(1)
        errorOrCancelCallback.apply()
        return false
    }

    /**
     * Callback for a successful transformation
     */
    private def boolean transformationSuccessful(
        List<ProgrammaticIntermediateModelTransformationResult> results
    ) {
        if (stopTransformations())
            return false

        printlnIndent(infoStream, "Successful.")
        infoStream.println()

        return !canceledByUser()
    }

    /**
     * Callback after all transformations were finished
     */
    private def boolean transformationsFinished(
        List<ProgrammaticIntermediateModelTransformationResult> allResults,
        List<ProgrammaticIntermediateModelTransformationException> allExceptions
    ) {
        if (stopTransformations())
            return false

        val errorCount = allExceptions.size
        val errorsSuffix = errorCount === 1 ? "error" : "errors"
        val resultCount = allResults.uniqueOutputPaths.size
        val resultsSuffix = resultCount === 1 ? "result file" : "result files"

        if (!allExceptions.empty)
            infoStream.println('''Transformations finished («errorCount» «errorsSuffix», '''+
            '''«resultCount» «resultsSuffix» from successful transformations)''')
        else
            infoStream.println('''All transformations finished successfully («resultCount» ''' +
                '''«resultsSuffix»)''')

        if (!allResults.empty) {
            printlnIndent(infoStream, "Resulting model files:")
            // Filter duplicate output paths which can occur from refinement transformations
            allResults.uniqueOutputPaths.sort.forEach[printlnIndent(infoStream, '''- «it»''', 2)]
        }

        if (allExceptions.empty && !canceledByUser())
            successfulCallback.apply()

        monitor.worked(1)
        return true
    }

    /**
     * Helper to filter duplicate output paths of intermediate models from a given list of
     * ProgrammaticIntermediateModelTransformationResult instances. The result will be a Set of
     * Strings comprising the output paths.
     */
    private def getUniqueOutputPaths(
        List<ProgrammaticIntermediateModelTransformationResult> results
    ) {
        return results.map[it.result.outputModel.outputPath].toSet
    }
}