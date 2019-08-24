package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation

import com.github.javaparser.ast.Node
import org.eclipse.emf.ecore.EObject

/**
 * Base interface for code generation serializers.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal interface CodeGenerationSerializerI {
    fun serialize(
        node: Node,
        targetFolderPath: String,
        targetFilePath: String,
        intermediateEObject: EObject,
        intermediateModelFilePath: String,
        originalModelFilePath: String
    ) : Pair<String, String>
}