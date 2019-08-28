package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation

import com.github.javaparser.ast.Node
import de.fhdo.lemma.model_processing.code_generation.java_base.findAnnotatedClassesWithInterface
import de.fhdo.lemma.model_processing.phases.PhaseException
import org.eclipse.emf.ecore.EObject
import java.nio.charset.Charset

/**
 * Annotation for code generation serializers.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.CLASS)
internal annotation class CodeGenerationSerializer(val name: String, val supportsLineCounting: Boolean = false,
    val default: Boolean = false)

/**
 * Base interface for code generation serializers.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal interface CodeGenerationSerializerI {
    /**
     * Serialization callback
     */
    fun serialize(node: Node, targetFolderPath: String, targetFilePath: String, intermediateEObject: EObject,
        intermediateModelFilePath: String, originalModelFilePath: String) : Map<String, String>

    /**
     * Callback for when the code generation phase has completed. Code generation serializers might adapt the passed
     * [allGeneratedFiles] by returning a map of adapted (or even completely new) file paths and their contents.
     */
    fun codeGenerationPhaseCompleted(allGeneratedFiles: Map<String, Pair<String, Charset>>)
        : Map<String, String> = emptyMap()
}

/**
 * Find local [CodeGenerationSerializerI] implementations.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun findCodeGenerationSerializers(searchPackage: String) : Map<String, CodeGenerationSerializerInfo> {
    val annotationName = CodeGenerationSerializer::class.qualifiedName!!
    val foundSerializers = findAnnotatedClassesWithInterface<CodeGenerationSerializerI>(searchPackage, annotationName)

    // From the found code generation serializers we build a map that assigns the name of each code generation serializer
    // to its class and the flag that indicates whether the serializer supports line counting or not.
    val serializerInfo = mutableMapOf<String, CodeGenerationSerializerInfo>()
    var defaultSerializerFound = false
    foundSerializers.forEach { serializerClass ->
        val annotationInstance = serializerClass.getAnnotation(CodeGenerationSerializer::class.java)
        val serializerName = annotationInstance.name
        val serializerSupportsLineCounting = annotationInstance.supportsLineCounting
        val isDefaultSerializer = annotationInstance.default

        if (serializerName in serializerInfo)
            throw PhaseException("Duplicate code generation serializer $serializerName")

        if (isDefaultSerializer) {
            if (!defaultSerializerFound)
                defaultSerializerFound = true
            else
                throw PhaseException("$serializerName is declared as being the default code generation serializer. " +
                    "However, there exists another code generation serializer that has also been marked as the " +
                    "default one.")
        }

        serializerInfo[serializerName] = CodeGenerationSerializerInfo(serializerName, serializerClass,
            isDefaultSerializer, serializerSupportsLineCounting)
    }

    if (!defaultSerializerFound)
        throw PhaseException("There either exist no code generation serializers or none of the existing ones was " +
            "marked as being the default one.")

    return serializerInfo
}

/**
 * Class to store information about a [CodeGenerationSerializerI] implementation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class CodeGenerationSerializerInfo(val name: String, val clazz: Class<CodeGenerationSerializerI>,
    val default: Boolean, val supportsLineCounting: Boolean)