package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation

import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.printer.PrettyPrinter
import com.github.javaparser.printer.PrettyPrinterConfiguration
import de.fhdo.lemma.model_processing.phases.PhaseException
import org.eclipse.emf.ecore.EObject
import org.koin.core.KoinComponent
import org.koin.core.inject

internal open class PlainCodeGenerationSerializer : CodeGenerationSerializerI {
    override fun serialize(node: Node, targetFolderPath: String, targetFilePath: String,
        intermediateEObject: EObject, intermediateModelFilePath: String, originalModelFilePath: String) {
        val serializationResult = CodeGenerationSerializer.serialize(node)
        println("Going to serialize to $targetFolderPath/$targetFilePath")
        println(serializationResult)
        throw PhaseException("bye")
    }
}

internal class CountingPlainCodeGenerationSerializer : CodeGenerationSerializerI {
    override fun serialize(node: Node, targetFolderPath: String, targetFilePath: String,
        intermediateEObject: EObject, intermediateModelFilePath: String, originalModelFilePath: String) {
        val serializationResult = CodeGenerationSerializer.serialize(node)
        println(serializationResult)

        val lineCountInfo = countLines(serializationResult, intermediateEObject, originalModelFilePath)
        println(
            """
                Original line count: ${lineCountInfo.originalEObjectLineCount}
                Generated line count: ${lineCountInfo.serializationResultLineCount}
                Target file: $targetFolderPath/$targetFilePath
                Additional info: ${lineCountInfo.additionalInfo}
            """.trimIndent()
        )

        throw PhaseException("bye")
    }
}

private class CodeGenerationSerializer : KoinComponent {
    private val prettyPrinterConfiguration: PrettyPrinterConfiguration by inject()

    companion object {
        fun serialize(node: Node) = CodeGenerationSerializer().serialize(node)
    }

    fun serialize(node: Node) : String {
        return when(node) {
            is CompilationUnit -> node.serialize()
            is ClassOrInterfaceDeclaration -> (node.parentNode.get() as CompilationUnit).serialize()
            else -> throw PhaseException("Serialization of nodes of type ${node::class.java.name} is not supported")
        }
    }

    private fun CompilationUnit.serialize() : String {
        val prettyPrinter = PrettyPrinter(prettyPrinterConfiguration)
        return prettyPrinter.print(this)
    }
}