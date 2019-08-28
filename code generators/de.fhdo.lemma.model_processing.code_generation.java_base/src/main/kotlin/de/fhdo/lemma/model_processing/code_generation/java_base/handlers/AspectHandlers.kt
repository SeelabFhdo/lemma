package de.fhdo.lemma.model_processing.code_generation.java_base.handlers

import com.github.javaparser.ast.Node
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.findAnnotatedClassesWithInterface
import de.fhdo.lemma.model_processing.utils.mainInterface
import de.fhdo.lemma.model_processing.utils.map
import org.eclipse.emf.ecore.EObject
import java.lang.IllegalStateException

/**
 * Annotation for aspect handlers. Aspect handlers provide the Java base generator and Genlets with an easy-to-use
 * approach towards enriching generated AST nodes with technology-specific information expressed with aspects. For
 * example, a Table aspect that reflects the javax.persistence.Table annotation can be handles this way. See the
 * [de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.handlers] package for examples of aspect
 * handlers.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.CLASS)
annotation class AspectHandler

/**
 * Base interface for aspect handlers (cf. [AspectHandler]).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface AspectHandlerI {
    /**
     * Provide combinations of [EObject] and AST [Node] classes that can be handled by the aspect handler. For example,
     * the combination of IntermediateDataStructure and ClassOrInterfaceDeclaration makes it possible to react to
     * aspects of data structures that result in Java classes. There can only be one aspect handler per combination
     * within the Java base generator and one aspect handler per combination per Genlet.
     */
    fun handlesEObjectNodeCombinations() : EObjectNodeCombinations

    /**
     * Provide the fully-qualified names of aspects that can be handled by this handler. A fully-qualified aspect name
     * consists of the name of an aspect's defining technology, as well as the aspect's name, separated by a dot. For
     * instance, "java.Table" is a fully-qualified aspect name.
     */
    fun handlesAspects() : Set<String>

    /**
     * Execution logic of the handler
     */
    fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node

    /**
     * Function to execute the handler. Never override or call this directly in case you want to implement an aspect
     * handler. This will be called automatically.
     */
    fun invoke(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        val adaptedNode = execute(eObject, node, aspect)
        if (adaptedNode !== node)
            throw IllegalStateException("Aspect handler for aspect $aspect did not return the same Node instance for " +
                    "EObject type ${eObject::class.java.name} and input Node type ${node::class.java.name}")
        return adaptedNode
    }
}

/**
 * Represents combinations of [EObject] and AST [Node] classes as expected to be provided by an [AspectHandler] (cf.
 * [AspectHandlerI.handlesEObjectNodeCombinations].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class EObjectNodeCombinations {
    private val combinations: MutableSet<Pair<Class<out EObject>, Class<out Node>>> = mutableSetOf()

    /**
     * Convenience function to create and register an [EObject] and AST [Node] combination.
     */
    infix fun Class<out EObject>.with(nodeClass : Class<out Node>) {
        combinations.add(this to nodeClass)
    }

    /**
     * Function to enable iterating over the set of registered [EObject] and AST [Node] combinations.
     */
    fun forEach(action: (Pair<Class<out EObject>, Class<out Node>>) -> Unit) {
        combinations.forEach(action)
    }

    /**
     * Function to enable iterating over the set of registered [EObject] and AST [Node] combinations.
     */
    operator fun iterator() = combinations.iterator()
}

/**
 * Convenience builder function to create and collect [EObject] and AST [Node] combinations in an
 * [EObjectNodeCombinations] instance.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun combinations(initializer: EObjectNodeCombinations.() -> Unit) = EObjectNodeCombinations().apply(initializer)

/**
 * Constant for separator of aspect handler name parts.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private const val ASPECT_HANDLER_PART_SEP = "::"

/**
 * Build the fully-qualified name of an aspect's handler considering the [EObject] and [Node] combination it can handle.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun buildAspectHandlerQualifiedName(eObjectNodeCombination: Pair<Class<out EObject>, Class<out Node>>,
    aspectName: String) : String {
    val (eObjectClassname, nodeClassname) = eObjectNodeCombination.map { it::class.java.name }
    return "$eObjectClassname$ASPECT_HANDLER_PART_SEP$nodeClassname$ASPECT_HANDLER_PART_SEP$aspectName"
}

/**
 * Build the fully-qualified name of an aspect's handler considering the [EObject] and [Node] combination it can handle.
 * The combination is derived from the classnames of the [EObject] and [Node] instances passed to the function.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun buildAspectHandlerQualifiedName(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : String {
    val eObjectClass = eObject.mainInterface
    val nodeClass = node::class.java
    return buildAspectHandlerQualifiedName(eObjectClass to nodeClass, aspect.qualifiedName)
}

/**
 * Find [AspectHandlerI] implementations from the given [searchPackage] and possibly within other JAR archives
 * leveraging the passed [classLoaders].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun findAspectHandlers(searchPackage: String, vararg classLoaders: ClassLoader)
    : Map<String, Class<AspectHandlerI>> {
    val annotationName = AspectHandler::class.qualifiedName!!
    val aspectHandlers = findAnnotatedClassesWithInterface<AspectHandlerI>(searchPackage, annotationName,
        *classLoaders)

    // From the found aspect handlers we build a map that comprises an entry for each aspect handler class, and the
    // combination of EObjects, AST nodes, and aspects it is capable in dealing with. For example, if a handler can
    // handle the combinations
    //      (IntermediateDataStructure, ClassOrInterfaceDeclaration)
    //      (IntermediateDataField, FieldDeclaration)
    // for the aspects
    //      "java.Table"
    //      "java.Entity"
    // the map will consist of the following entries
    //      (fqn(IntermediateDataStructure, ClassOrInterfaceDeclaration, "java.Table"), handlerClass)
    //      (fqn(IntermediateDataStructure, ClassOrInterfaceDeclaration, "java.Entity"), handlerClass)
    //      (fqn((IntermediateDataField, FieldDeclaration, "java.Table")), handlerClass)
    //      (fqn((IntermediateDataField, FieldDeclaration, "java.Entity")), handlerClass)
    // which later on gives a convenient way in accessing and invoking aspect handler classes.
    val aspectHandlersToCombinations = mutableMapOf<String, Class<AspectHandlerI>>()
    aspectHandlers.map { handler ->
        val instance = handler.getConstructor().newInstance()
        for (combination in instance.handlesEObjectNodeCombinations()) {
            val handledAspects = instance.handlesAspects()
            val qualifiedNames = handledAspects.map { buildAspectHandlerQualifiedName(combination, it) }
            aspectHandlersToCombinations.putAll(qualifiedNames.map { it to handler })
        }
    }
    return aspectHandlersToCombinations
}