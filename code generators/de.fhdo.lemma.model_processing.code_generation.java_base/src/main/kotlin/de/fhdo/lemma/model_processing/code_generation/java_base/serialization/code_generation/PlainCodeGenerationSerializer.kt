package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation

import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.EnumDeclaration
import com.github.javaparser.printer.PrettyPrinter
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.appendStatement
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.asClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.hasReturnStatement
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.hasThrowStatement
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.serialize
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.MainContext.State as MainState
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.configuration.AbstractSerializationConfiguration
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.countLines
import de.fhdo.lemma.model_processing.phases.PhaseException
import org.eclipse.emf.ecore.EObject
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.io.File

/**
 * Serializes an AST [Node] to a plain Java file, i.e., as it was passed to the serializer.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationSerializer("plain")
internal open class PlainCodeGenerationSerializer : CodeGenerationSerializerI {
    /**
     * Do the serialization (delegates to [CodeGenerationSerializerBase])
     */
    override fun serialize(node: Node, targetFolderPath: String, targetFilePath: String, intermediateEObject: EObject?,
        originalModelFilePath: String?)
            = mapOf(CodeGenerationSerializerBase.serialize(node, targetFolderPath, targetFilePath))
}

/**
 * Serializes an AST [Node] to a plain Java file, i.e., as it was passed to the serializer,  and counts the generated
 * LOCs.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationSerializer("plain-loc", true)
internal class CountingPlainCodeGenerationSerializer : CodeGenerationSerializerI {
    /**
     * Do the serialization (delegates to [CodeGenerationSerializerBase])
     */
    override fun serialize(node: Node, targetFolderPath: String, targetFilePath: String, intermediateEObject: EObject?,
        originalModelFilePath: String?) : Map<String, Pair<String, Node?>> {
        val (resultPath, result) = CodeGenerationSerializerBase.serialize(node, targetFolderPath, targetFilePath)
        val (generatedCode, _) = result

        MainState.addOrUpdateGeneratedLineCountInfo(
            countLines(
                resultPath to generatedCode,
                intermediateEObject,
                originalModelFilePath
            )
        )

        return mapOf(resultPath to result)
    }
}

/**
 * Base delegate for plain code generation serializers.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private class CodeGenerationSerializerBase : KoinComponent {
    private val serializationConfiguration: AbstractSerializationConfiguration by inject()

    /**
     * Companion object to simplify calling [serialize] for clients
     */
    companion object {
        fun serialize(node: Node, targetFolderPath: String, targetFilePath: String)
            = CodeGenerationSerializerBase().serialize(node, targetFolderPath, targetFilePath)
    }

    /**
     * Do the actual serialization
     */
    fun serialize(node: Node, targetFolderPath: String, targetFilePath: String) : Pair<String, Pair<String, Node?>> {
        val originalClass = node.asClassOrInterfaceDeclaration()

        /* If the node does not comprise a class (e.g., it's an enum) do the plain serialization */
        if (originalClass == null) {
            val generatedCode = when(node) {
                is CompilationUnit -> node.serialize()
                is ClassOrInterfaceDeclaration -> (node.parentNode.get() as CompilationUnit).serialize()
                is EnumDeclaration -> node.serialize(serializationConfiguration)
                else -> throw PhaseException("Serialization of nodes of type ${node::class.java.name} is not supported")
            }

            val codeToNode = generatedCode to node
            return "$targetFolderPath${File.separator}$targetFilePath" to codeToNode
        }

        /* Otherwise, perform a plain serialization, but fix compilation errors */
        originalClass.methods.forEach {
            if (!it.type.isVoidType &&
                !it.hasReturnStatement &&
                !it.hasThrowStatement)
                it.appendStatement("""throw new UnsupportedOperationException("Not implemented yet");""")
        }

        val codeToNode = (node.parentNode.get() as CompilationUnit).serialize() to node
        return "$targetFolderPath${File.separator}$targetFilePath" to codeToNode
    }

    /**
     * Helper to serialize a [CompilationUnit]
     */
    private fun CompilationUnit.serialize() : String {
        val prettyPrinter = PrettyPrinter(serializationConfiguration)
        return prettyPrinter.print(this)
    }
}