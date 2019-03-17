package de.fhdo.ddmm.acceleo.generator

import de.fhdo.ddmm.ocl.OclQueryHelper
import org.eclipse.acceleo.engine.AcceleoEngineMessages
import org.eclipse.acceleo.engine.AcceleoEvaluationException
import org.eclipse.acceleo.engine.generation.strategy.IAcceleoGenerationStrategy
import org.eclipse.acceleo.engine.generation.strategy.PreviewStrategy
import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator
import org.eclipse.acceleo.engine.service.AcceleoService
import org.eclipse.acceleo.model.mtl.Module
import org.eclipse.acceleo.model.mtl.Template
import org.eclipse.acceleo.model.mtl.VisibilityKind
import org.eclipse.emf.common.util.BasicMonitor
import org.eclipse.emf.common.util.Monitor
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import java.io.File
import java.util.ArrayList
import java.util.HashMap

/**
 * Entry builder function for configuring and creating a [FilteringGenerator].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun generator(sourceModelPath: String, rootPath: String, initializer: GeneratorBuilder.() -> GeneratorBuilder)
    = GeneratorBuilder(sourceModelPath, rootPath).let(initializer).create()

/**
 * Builder for configuring and creating [FilteringGenerator] instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class GeneratorBuilder(private val sourceModelPath: String, private val rootPath: String) {
    private val templateNames = mutableListOf<String>()

    private lateinit var ePackage: EPackage
    private lateinit var moduleName: String

    /**
     * Configure domain-specific EPackage used in the generation process
     */
    fun ePackage(ePackage: EPackage) : GeneratorBuilder {
        this.ePackage = ePackage
        return this
    }

    /**
     * Add a template name to be considered in the generation process
     */
    fun template(templateName: String) : GeneratorBuilder {
        templateNames += templateName
        return this
    }

    /**
     * Set entry transformation module for the generation process
     */
    fun module(moduleName: String) : GeneratorBuilder {
        this.moduleName = moduleName
        return this
    }

    /**
     * Register EPackage and create a [FilteringGenerator] instance according to the configuration
     */
    fun create() : FilteringGenerator {
        EPackage.Registry.INSTANCE[ePackage.nsURI] = ePackage
        return FilteringGenerator(sourceModelPath, rootPath, templateNames.toTypedArray(), moduleName)
    }
}

/**
 * Acceleo-based generator that allows for selecting the relevant source model element instances for the generation
 * process leveraging OCL. All other model element instances will be ignored.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class FilteringGenerator(sourceModelPath: String, generationRootPath: String, private val _templateNames: Array<String>,
    private val _moduleName: String) : AbstractAcceleoGenerator() {
    /*
     * Unfortunately, a significant amount of code needed to be copied from [AbstractAcceleoGenerator] to alter the
     * generation behavior (cf. https://www.eclipse.org/forums/index.php/t/379554/). All code that was copied from
     * Acceleo 3.7 is encapsulated within comments that start with
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
        private val TEMPLATE_CALL_NPE = AcceleoEngineMessages.getString("AcceleoService.NullArguments")
        private const val UNDEFINED_TEMPLATE = "AcceleoService.UndefinedTemplate"
    }

    private val strategy : IAcceleoGenerationStrategy = PreviewStrategy()
    private var generationIsOccurring = false
    private var generationHasOccurred = false
    private lateinit var service : AcceleoService
    /* [END COPIED CODE FROM AcceleoEngine 3.7] */

    /* [BEGIN CUSTOM CODE] ------------------------------------------------------------------------------------------ */
    // Set [FilteringAcceleoEngine] as transformation engine
    private val generationEngine = FilteringAcceleoEngine()
    /* [END CUSTOM CODE] -------------------------------------------------------------------------------------------- */

    /* [BEGIN COPIED CODE FROM AcceleoEngine 3.7] */
    init {
        initialize(URI.createFileURI(sourceModelPath), File(generationRootPath), emptyList<Any>())
    }
    /* [END COPIED CODE FROM AcceleoEngine 3.7] */

    override fun getTemplateNames() = this._templateNames
    override fun getModuleName() = this._moduleName
    override fun getGenerationStrategy() = this.strategy

    /**
     * Trigger a generation process, possibly with an OCL-based [filteringQuery]. By default, the generation process
     * prints status outputs on STDOUT ([silent] set to true). This behavior can be altered by setting [silent] set to
     * false.
     */
    fun generate(filteringQuery: String? = null, silent: Boolean = false)
        = generate(if (silent) BasicMonitor() else BasicMonitor.Printing(System.out), filteringQuery)

    override fun generate(monitor: Monitor?): MutableMap<String, String> = generate(monitor, true)
    override fun generate(monitor: Monitor?, recursive: Boolean) = generate(monitor, recursive, null)
    fun generate(monitor: Monitor?, filteringQuery: String?) = generate(monitor, true, filteringQuery)

    /**
     * Trigger a generation process, possibly with an OCL-based [filteringQuery]. The [filteringQuery] is executed on
     * the source model of the generation and only the resulting object are considered relevant in the generation
     * process. Note that the query has to return the relevant objects as an instance of [Collection]. That is, the OCL
     * query needs to return an instance of OCL's Collection type (or one of its sub-types Sequence, Bag, OrderedSet,
     * Set. If the collection of relevant objects is empty, no generation will occur. If it's null, the generation
     * process will run on the whole model, i.e., as if [generate] was called.
     *
     * Significant parts of the code were copied from generate(Monitor, boolean).
     */
    fun generate(monitor: Monitor?, recursive: Boolean, filteringQuery: String?) : MutableMap<String, String> {
        /*
         * [BEGIN COPIED CODE FROM AcceleoEngine 3.7]
         * method: generate(Monitor, boolean)
         */
        val target = getTargetFolder()
        checkTargetExists(target)
        service = createAcceleoService()
        val templateNames = templateNames
        val result = HashMap<String, String>()

        // Start
        service.doPrepareGeneration(monitor, target)

        acceleoPropertiesLoaderService = getPropertiesLoaderService(service)
        if (acceleoPropertiesLoaderService != null)
            acceleoPropertiesLoaderService.initializeService(properties)
        /* [END COPIED CODE FROM AcceleoEngine 3.7] */

        /* [BEGIN CUSTOM CODE] --------------------------------------------------------------------------------------- */
        // Execute OCL filtering query to determine the collection of model element instances that are relevant for the
        // generation process
        var relevantObjects : Collection<EObject>? = null
        if (filteringQuery != null) {
            relevantObjects = try {
                @Suppress("UNCHECKED_CAST")
                OclQueryHelper.queryCollection(model, filteringQuery) as Collection<EObject>?
            } catch (ex: Exception) {
                throw AcceleoEvaluationException("Error when executing OCL query: ${ex.message}")
            } ?: throw AcceleoEvaluationException("OCL query did not return an instance of " +
                    "${Collection::class.java.name}")
        }

        // Execute the actual generation on the collection of relevant model element instances
        templateNames.forEach {
            result.putAll(
                doGenerate(getModule(), it, getModel(), recursive, arguments, target, monitor, relevantObjects)
            )
        }
        /* [END CUSTOM CODE] ---------------------------------------------------------------------------------------- */

        /*
         * [BEGIN COPIED CODE FROM AcceleoEngine 3.7]
         * method: generate(Monitor, boolean)
         */
        // End
        service.finalizeGeneration()

        postGenerate(getModule().eResource().resourceSet)
        originalResources.clear()
        service.clearCaches()

        if (!generationHasOccurred)
            System.err.println(AcceleoEngineMessages.getString("AcceleoService.NoGenerationHasOccurred")) //$NON-NLS-1$
        return result
        /* [END COPIED CODE FROM AcceleoEngine 3.7] */
    }

    /**
     * Helper to do the actual generation. Significant parts of the code were copied from generate(Module, String,
     * EObject, Boolean, List<? extends EObject>, File, Monitor).
     */
    private fun doGenerate(module: Module, templateName: String, model: EObject?, recursive: Boolean,
        arguments: List<Any>?, generationRoot: File?, monitor: Monitor?, relevantObjects: Collection<EObject>?)
        : Map<String, String> {
        /*
         * [BEGIN COPIED CODE FROM AcceleoEngine 3.7]
         * method: generate(Module, String, EObject, Boolean, List<? extends EObject>, File, Monitor)
         */
        // Start
        var shouldNotify = false
        if (!generationIsOccurring) {
            generationIsOccurring = true
            shouldNotify = true
            service.doPrepareGeneration(monitor, generationRoot)
        }

        if (model == null || arguments == null
            || strategy !is PreviewStrategy && generationRoot == null
        ) {
            throw NullPointerException(TEMPLATE_CALL_NPE)
        }
        val templates = findTemplates(module, templateName, arguments.size + 1)
        // #findTemplate never returns private templates.

        val mainTemplates = ArrayList<Template>()
        for (template in templates) {
            if (template.isMain) {
                mainTemplates.add(template)
            }
        }

        val previewResult = HashMap<String, String>()

        for (template in mainTemplates) {
            // Calls the template with each potential arguments
            val argumentType = template.parameter[0].type
            if (argumentType.eIsProxy()) {
                throw AcceleoEvaluationException(
                    AcceleoEngineMessages.getString(
                        "AcceleoService.TypeIsProxy", templateName
                    )
                ) //$NON-NLS-1$
            }

            // The input model itself is a potential argument
            if (argumentType.isInstance(model)) {
                val actualArguments = ArrayList<Any>()
                actualArguments.add(model)
                actualArguments.addAll(arguments)
        /* [END COPIED CODE FROM AcceleoEngine 3.7] */

        /* [BEGIN CUSTOM CODE] -------------------------------------------------------------------------------------- */
                // Consider relevant object selection in actual generation
                previewResult.putAll(
                    doGenerateTemplate(template, actualArguments, generationRoot, monitor, relevantObjects)
                )
        /* [END CUSTOM CODE] ---------------------------------------------------------------------------------------- */

        /*
         * [BEGIN COPIED CODE FROM AcceleoEngine 3.7]
         * method: generate(Module, String, EObject, Boolean, List<? extends EObject>, File, Monitor)
         */
                generationHasOccurred = true
            }
            if (recursive) {
                val targetElements = model.eAllContents()
                while (targetElements.hasNext()) {
                    val potentialTarget = targetElements.next()
                    if (argumentType.isInstance(potentialTarget)) {
                        val actualArguments = ArrayList<Any>()
                        actualArguments.add(potentialTarget)
                        actualArguments.addAll(arguments)
        /* [END COPIED CODE FROM AcceleoEngine 3.7] */

        /* [BEGIN CUSTOM CODE] -------------------------------------------------------------------------------------- */
                        // Consider relevant object selection in actual generation
                        previewResult.putAll(
                            doGenerateTemplate(template, actualArguments, generationRoot, monitor, relevantObjects)
                        )
        /* [END CUSTOM CODE] ---------------------------------------------------------------------------------------- */

        /*
         * [BEGIN COPIED CODE FROM AcceleoEngine 3.7]
         * method: generate(Module, String, EObject, Boolean, List<? extends EObject>, File, Monitor)
         */
                        generationHasOccurred = true
                    }
                }
                // There is a possibility that "model" is but one of the resource's roots.
                if (model.eResource() != null) {
                    val roots = ArrayList(model.eResource().contents)
                    roots.remove(model)
                    for (root in roots) {
                        if (argumentType.isInstance(root)) {
                            val actualArguments = ArrayList<Any>()
                            actualArguments.add(root)
                            actualArguments.addAll(arguments)
        /* [END COPIED CODE FROM AcceleoEngine 3.7] */

        /* [BEGIN CUSTOM CODE] -------------------------------------------------------------------------------------- */
                            // Consider relevant object selection in actual generation
                            previewResult.putAll(
                                doGenerateTemplate(template, actualArguments, generationRoot, monitor, relevantObjects)
                            )
        /* [END CUSTOM CODE] ---------------------------------------------------------------------------------------- */

        /*
         * [BEGIN COPIED CODE FROM AcceleoEngine 3.7]
         * method: generate(Module, String, EObject, Boolean, List<? extends EObject>, File, Monitor)
         */
                            generationHasOccurred = true
                        }
                    }
                }
            }
        }

        // End
        if (shouldNotify) {
            shouldNotify = false
            this.generationIsOccurring = false
            service.finalizeGeneration()
        }

        return previewResult
        /* [END COPIED CODE FROM AcceleoEngine 3.7] */
    }

    /* [BEGIN COPIED CODE FROM AcceleoEngine 3.7] */
    private fun findTemplates(module: Module, templateName: String, argumentCount: Int): List<Template> {
        val templates = ArrayList<Template>()
        for (element in module.ownedModuleElement) {
            if (element is Template) {
                if (element.visibility == VisibilityKind.PUBLIC
                    && templateName == element.name
                    && element.parameter.size == argumentCount
                ) {
                    templates.add(element)
                }
            }
        }
        if (templates.isEmpty()) {
            throw AcceleoEvaluationException(AcceleoEngineMessages.getString(UNDEFINED_TEMPLATE,
                templateName, module.name))
        }
        return templates
    }
    /* [END COPIED CODE FROM AcceleoEngine 3.7] */

    /**
     * Invoke template-based generation leveraging the [FilteringAcceleoEngine]
     */
    private fun doGenerateTemplate(template: Template, arguments: List<Any>, generationRoot: File?, monitor: Monitor?,
        relevantObjects: Collection<EObject>?) : Map<String, String> {
        try {
            return generationEngine.evaluate(template, arguments, generationRoot, strategy, monitor, relevantObjects)
        } finally {
            // do nothing, just catch everything
        }
    }
}