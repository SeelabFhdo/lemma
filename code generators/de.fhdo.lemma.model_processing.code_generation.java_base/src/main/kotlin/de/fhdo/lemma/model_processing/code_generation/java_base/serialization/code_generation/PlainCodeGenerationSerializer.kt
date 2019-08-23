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

internal class PlainCodeGenerationSerializer : CodeGenerationSerializerI, KoinComponent {
    private val prettyPrinterConfiguration: PrettyPrinterConfiguration by inject()

    override fun serialize(node: Node, targetFolderPath: String, targetFilePath: String,
        intermediateEObject: EObject, intermediateModelFilePath: String, originalModelFilePath: String) {
        val content = when(node) {
            is CompilationUnit -> node.serialize()
            is ClassOrInterfaceDeclaration -> (node.parentNode.get() as CompilationUnit).serialize()
            else -> PhaseException("Serialization of nodes of type ${node::class.java.name} is not supported")
        }

        println("Going to serialize to $targetFolderPath/$targetFilePath")
        println(content)
        throw PhaseException("bye")
    }

    private fun CompilationUnit.serialize() : String {
        val prettyPrinter = PrettyPrinter(prettyPrinterConfiguration)
        return prettyPrinter.print(this)
    }
}