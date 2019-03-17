package de.fhdo.ddmm.acceleo.generator

import org.eclipse.acceleo.engine.AcceleoEngineMessages
import org.eclipse.acceleo.engine.AcceleoEvaluationCancelledException
import org.eclipse.acceleo.engine.AcceleoEvaluationException
import org.eclipse.acceleo.engine.generation.AcceleoEngine
import org.eclipse.acceleo.engine.generation.strategy.IAcceleoGenerationStrategy
import org.eclipse.acceleo.model.mtl.Module
import org.eclipse.acceleo.model.mtl.Template
import org.eclipse.emf.common.util.Monitor
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EObject
import org.eclipse.ocl.ecore.AnyType
import org.eclipse.ocl.ecore.OCL
import java.io.File

/**
 * This is a custom implementation of [AcceleoEngine] that allows for passing those model element instances from the
 * source model that shall be considered for the transformation. All other model element instances will be ignored.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class FilteringAcceleoEngine : AcceleoEngine() {
    /*
     * Unfortunately, a significant amount of code needed to be copied from [AcceleoEngine], which was seemingly not
     * provided with possible extensions in mind. All code that was copied from Acceleo 3.7 is encapsulated within
     * comments that start with
     *
     *     /* [BEGIN COPIED CODE FROM AcceleoEngine 3.7] */
     *
     * and end with
     *
     *     /* [END COPIED CODE FROM AcceleoEngine 3.7] */
     *
     * Custom code within copied methods is separated from copied code via
     *
     *     /* [BEGIN CUSTOM CODE] ----------------------------------------------------------------------------------- */
     *
     * and
     *
     *     /* [END CUSTOM CODE] ------------------------------------------------------------------------------------- */
     */

    /* [BEGIN COPIED CODE FROM AcceleoEngine 3.7] */
    companion object {
        private const val SELF_CONTEXT_VARIABLE_NAME = "context$0"
        private const val SELF_VARIABLE_NAME = "self"
        private const val ARGUMENT_MISMATCH_KEY = "AcceleoEngine.ArgumentMismatch"
    }

    private lateinit var ocl: OCL
    /* [END COPIED CODE FROM AcceleoEngine 3.7] */

    /**
     * Evaluate an Acceleo template
     */
    override fun evaluate(template: Template, arguments: List<Any>, generationRoot: File?,
        strategy: IAcceleoGenerationStrategy, monitor: Monitor?): Map<String, String> {
        return evaluate(template, arguments, generationRoot, strategy, monitor, null)
    }

    /**
     * Evaluate an Acceleo template and only take into account selected, relevant objects. Significant parts of the code
     * were copied from evaluate(Template, List<? extends Object>, File, IAcceleoGenerationStrategy, Monitor).
     */
    fun evaluate(template: Template, arguments: List<Any>, generationRoot: File?, strategy: IAcceleoGenerationStrategy,
        monitor: Monitor?, relevantObjects: Collection<EObject>?): Map<String, String> {
        /*
         * [BEGIN COPIED CODE FROM AcceleoEngine 3.7]
         * method: evaluate(Template, List<? extends Object>, File, IAcceleoGenerationStrategy, Monitor)
         */
        checkEvaluation(template, arguments)

        // We need to create an OCL instance for each generation since the environment factory is contextual
        val factory = createEnvironmentFactory(generationRoot, template.eContainer() as Module, strategy, monitor)
        ocl = OCL.newInstance(factory)

        try {
        /* [END COPIED CODE FROM AcceleoEngine 3.7] */

        /* [BEGIN CUSTOM CODE] -------------------------------------------------------------------------------------- */
            // Consider relevant object selection in actual template evaluation
            doEvaluate(template, arguments, relevantObjects)
        /* [END CUSTOM CODE] -------------------------------------------------------------------------------------- */

        /*
         * [BEGIN COPIED CODE FROM AcceleoEngine 3.7]
         * method: evaluate(Template, List<? extends Object>, File, IAcceleoGenerationStrategy, Monitor)
         */
        } catch (ex: AcceleoEvaluationCancelledException) {
            // All necessary disposal should have been made
        }

        hookGenerationEnd(factory)

        var result = emptyMap<String, String>()
        if (strategy.willReturnPreview()) {
            result = factory.evaluationPreview
        }
        factory.dispose()

        return result
        /* [END COPIED CODE FROM AcceleoEngine 3.7] */
    }

    /**
     * Helper to do the actual evaluation. Significant parts of the code were copied from doEvaluate(Template,
     * List<? extends Object>).
     */
    private fun doEvaluate(template: Template, arguments: List<Any>, relevantObjects: Collection<EObject>?): Any? {
        /*
         * [BEGIN COPIED CODE FROM AcceleoEngine 3.7]
         * method: doEvaluate(Template, List<? extends Object>)
         */
        // Guard Evaluation
        var guardValue = true
        if (template.guard != null) {
            val guard = ocl.createQuery(template.guard)
            // Sets all needed variables for the guard evaluation
            for (i in 0 until template.parameter.size) {
                val param = template.parameter[i]
                val value = arguments[i]
                if (isInstance(param.type, value)) {
                    guard.evaluationEnvironment.add(param.name, value)
                } else {
                    throw AcceleoEvaluationException(
                        AcceleoEngineMessages.getString(ARGUMENT_MISMATCH_KEY, template.name)
                    )
                }
                // [255379] also sets "self" variable to match the very first parameter
                if (i == 0) {
                    guard.evaluationEnvironment.add(SELF_VARIABLE_NAME, value)
                    guard.evaluationEnvironment.add(SELF_CONTEXT_VARIABLE_NAME, value)
                }
            }
            // FIXME [362056]
            val result = guard.evaluate()
            if (result is Boolean) {
                guardValue = result
            }
            // reset variables
            for (`var` in template.parameter) {
                guard.evaluationEnvironment.remove(`var`.name)
            }
            if (template.parameter.size > 0) {
                guard.evaluationEnvironment.remove(SELF_VARIABLE_NAME)
                guard.evaluationEnvironment.remove(SELF_CONTEXT_VARIABLE_NAME)
            }
        }

        // If there were no guard or its condition is verified, evaluate the template now.
        if (guardValue) {
            val query = ocl.createQuery(template)
            // Sets all needed variables for the template evaluation
            var doEvaluate = true
            for (i in 0 until template.parameter.size) {
                val param = template.parameter[i]
                val value = arguments[i]
        /* [END COPIED CODE FROM AcceleoEngine 3.7] */

        /* [BEGIN CUSTOM CODE] -------------------------------------------------------------------------------------- */
                // Only evaluate if the template parameter's value is a relevant object
                if (!isRelevant(value, relevantObjects)) {
                    doEvaluate = false
                    continue
                }
        /* [END CUSTOM CODE] ---------------------------------------------------------------------------------------- */

        /*
         * [BEGIN COPIED CODE FROM AcceleoEngine 3.7]
         * method: doEvaluate(Template, List<? extends Object>)
         */
                if (param.type is AnyType || isInstance(param.type, value)) {
                    query.evaluationEnvironment.add(param.name, value)
                } else {
                    throw AcceleoEvaluationException(
                        AcceleoEngineMessages.getString(ARGUMENT_MISMATCH_KEY, template.name)
                    )
                }
                // [255379] also sets "self" variable to match the very first parameter
                if (i == 0) {
                    query.evaluationEnvironment.add(SELF_VARIABLE_NAME, value)
                    query.evaluationEnvironment.add(SELF_CONTEXT_VARIABLE_NAME, value)
                }
            }
            try {
                if (doEvaluate)
                    return query.evaluate()
            } finally {
                // reset variables
                for (`var` in template.parameter) {
                    query.evaluationEnvironment.remove(`var`.name)
                }
                if (template.parameter.size > 0) {
                    query.evaluationEnvironment.remove(SELF_VARIABLE_NAME)
                    query.evaluationEnvironment.remove(SELF_CONTEXT_VARIABLE_NAME)
                }
            }
        }

        return null
        /* [END COPIED CODE FROM AcceleoEngine 3.7] */
    }

    /**
     * Check if an object is a relevant object by also taking into account children of relevant objects
     */
    private fun isRelevant(relevantCandidate: Any, relevantObjects: Collection<EObject>?) : Boolean {
        if (relevantObjects == null)
            return true

        relevantObjects.forEach {
            if (relevantCandidate == it)
                return true

            // Consider children of relevant objects
            val iter = it.eAllContents()
            while (iter.hasNext()) {
                val relevantChildObject = iter.next()
                if (relevantCandidate == relevantChildObject)
                    return true
            }
        }

        return false
    }

    /* [BEGIN COPIED CODE FROM AcceleoEngine 3.7] */
    private fun isInstance(classifier: EClassifier, value: Any): Boolean {
        var isInstance = false
        if (classifier.instanceClass != null) {
            isInstance = classifier.instanceClass.isInstance(value)
        }
        if (!isInstance) {
            isInstance = classifier.isInstance(value)
        }
        return isInstance
    }
    /* [END COPIED CODE FROM AcceleoEngine 3.7] */
}