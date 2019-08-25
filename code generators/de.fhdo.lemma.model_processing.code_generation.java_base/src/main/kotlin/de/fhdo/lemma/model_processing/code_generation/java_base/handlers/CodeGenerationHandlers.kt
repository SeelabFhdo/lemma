package de.fhdo.lemma.model_processing.code_generation.java_base.handlers

import com.github.javaparser.ast.Node
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.findAndMapAnnotatedClassesWithInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.Genlet
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext
import org.eclipse.emf.ecore.EObject

/**
 * Annotation for code generation handlers. Code generation handlers allow for implementing (automatically) visited or
 * (explicitly) called code generation actions. Basically, they transform an intermediate [EObject] instance into an
 * AST [Node] instance, which is then later serialized into Java code (cf. the
 * [de.fhdo.lemma.model_processing.code_generation.java_base.serialization] package).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.CLASS)
annotation class CodeGenerationHandler

/**
 * Base interface for code generation handlers (cf. [CodeGenerationHandler]).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface CodeGenerationHandlerI<T: EObject, N: Node, C: Any> {
    /**
     * The [EObject] class, for which this handler can generate an AST [Node]. There can only be one code generation
     * handler per [EObject] class within the Java base generator and one code generation handler per [EObject] class
     * per Genlet.
     */
    fun handlesEObjectsOfInstance() : Class<T>

    /**
     * The [Node] class that this handler generates
     */
    fun generatesNodesOfInstance() : Class<N>

    /**
     * Get aspects from an [EObject] instance. The handler must implement this function in order to enable subsequent
     * invocation of [AspectHandlerI] realizations.
     */
    fun getAspects(eObject: T) : List<IntermediateImportedAspect> = emptyList()

    /**
     * Function to invoke this handler. It is not meant to be implemented by concrete handler implementations. They
     * need to implement [execute] instead. Moreover, never call this function directly. It will be called
     * automatically.
     */
    fun invoke(eObject: T, context: C? = null) : Pair<N, String?>? {
        val result = execute(eObject, context) ?: return null
        val (generatedNode, generatedFilePath) = result
        val adaptedNode = executeSubActions(eObject, generatedNode)
        return adaptedNode to generatedFilePath
    }

    /**
     * Function which needs to be realized by concrete handlers. The context is an optional information that may be
     * passed to a handler, e.g., the previously generated parent [Node] of the yet-to-generate [Node]. Currently,
     * no context is passed to [VisitingCodeGenerationHandlerI] implementations, while these are free to pass contextual
     * information to [CallableCodeGenerationHandlerI] implementations depending on whether they need such information
     * to properly generate/reify an AST [Node].
     *
     * A code generation handler can either return null (i.e., no AST [Node] was generated/reified at all for the given
     * [EObject] and context), or a pair that holds the generated [Node] and possibly a target file path. If no target
     * file path is returned, a generated [Node] will not be serialized in case the handler is a
     * [VisitingCodeGenerationHandlerI].
     */
    fun execute(eObject: T, context: C? = null) : Pair<N, String?>?

    /**
     * Execute subsequent actions like local aspect handlers, Genlet-specific code generation and aspect handlers, on a
     * a generated AST [Node] in order to adapt it
     */
    @Suppress("UNCHECKED_CAST")
    fun executeSubActions(eObject: T, node: N) : N {
        /* Execute local aspect handlers */
        val aspects = getAspects(eObject)
        var adaptedNode = MainContext.invokeLocalAspectHandlers(eObject, node, aspects)

        /* Execute Genlets' code generation and aspect handlers */
        val genlets: Set<Genlet> by MainContext.State
        genlets.forEach {
            val (reifiedNode, generatedFiles) = MainContext.invokeGenletCodeGenerationHandler(eObject, adaptedNode, it)
            adaptedNode = reifiedNode
            generatedFiles.forEach { fileContent ->
                MainContext.State.addGeneratedFileContent(fileContent.generatedContent, fileContent.getFullPath())
            }
            adaptedNode = MainContext.invokeAspectHandlers(eObject, node, aspects, it)
        }

        return adaptedNode as N
    }
}

/**
 * Base interface for code generation handlers that automatically get executed when an intermediate model's elements are
 * visited.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface VisitingCodeGenerationHandlerI<T: EObject, N: Node, C: Any> : CodeGenerationHandlerI<T, N, C>

/**
 * Base interface for code generation handlers that can be called explicitly, e.g., to reify generated AST [Node]
 * instances and make the reifying code reusable by [VisitingCodeGenerationHandlerI] implementations.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface CallableCodeGenerationHandlerI<T: EObject, N: Node, C: Any> : CodeGenerationHandlerI<T, N, C>

/**
 * Helper to find [CodeGenerationHandlerI] implementations, possibly in other JAR archives by providing the respective
 * [classLoaders].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal inline fun <reified T: CodeGenerationHandlerI<*, *, *>> findCodeGenerationHandlers(searchPackage: String,
    vararg classLoaders: ClassLoader) : Map<String, Class<T>> {
    return findAndMapAnnotatedClassesWithInterface(searchPackage, CodeGenerationHandler::class.qualifiedName!!,
        *classLoaders) { it.handlesEObjectsOfInstance().name }
}