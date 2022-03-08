package de.fhdo.lemma.model_processing.code_generation.java_base.commandline

import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation.CodeGenerationSerializerI
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation.CodeGenerationSerializerInfo
import picocli.CommandLine
import picocli.CommandLine.Model.CommandSpec

/**
 * Object to represent the basic commandline of the Java base generator.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object CommandLine {
    @CommandLine.Spec
    private lateinit var commandSpec: CommandSpec

    private lateinit var defaultCodeGenerationSerializer: CodeGenerationSerializerInfo
    private lateinit var supportedCodeGenerationSerializers: Map<String, CodeGenerationSerializerInfo>

    /* Attribute to gather all arguments that couldn't be matched by the commandline object */
    @CommandLine.Unmatched
    var unmatched: Array<String> = emptyArray()

    /*
     * Commandline option that specifies an alternative intermediate service model file to be used
     */
    var alternativeIntermediateServiceModelFile: String? = null
        @CommandLine.Option(
            names = ["--alternative_intermediate_service_model"],
            paramLabel = "INTERMEDIATE_SERVICE_MODEL_FILE",
            description = ["an alternative intermediate model to generate microservices from"]
        )
        set(value) {
            if (value != null && !value.asFile().exists())
                throw CommandLine.ParameterException(commandSpec.commandLine(), "Alternative intermediate service " +
                    "model file $value does not exist")

            field = value
        }

    /* Commandline option for a path to a Genlet's JAR archive */
    private var parameterGenlets: Set<String>? = null
        @CommandLine.Option(
            names = ["--genlet"],
            paramLabel = "GENLET",
            description = ["path to a Genlet's JAR archive"]
        )
        set(value) {
            value?.forEach {
                if (!it.asFile().exists())
                    throw CommandLine.ParameterException(commandSpec.commandLine(), "Genlet file $it does not " +
                        "exist")
            }

            field = value
        }

    /*
     * Commandline option for a path to a Genlet's JAR archive in combination with the fully-qualified name of the
     * Genlet's entry class. That is, because otherwise the Java base generator will try to infer the fully-qualified
     * name of the Genlet's entry class in a static way (cf. the String.inferDefaultGenletClassname() function).
     */
    private var parameterFullQualifiedGenlets: Map<String, String>? = null
        @CommandLine.Option(
            names = ["--genlet_full_qualified"],
            paramLabel = "GENLET_FULL_QUALIFIED",
            description = ["path to a Genlet's JAR archive and full qualified name of the Genlet class to load"]
        )
        set(value) {
            value?.keys?.forEach {
                if (!it.asFile().exists())
                    throw CommandLine.ParameterException(commandSpec.commandLine(), "Genlet file $it does not " +
                        "exist")
            }

            field = value
        }

    /* Commandline option for the code generation serializer to use */
    private var parameterCodeGenerationSerializerName: String? = null
        @CommandLine.Option(
            names = ["--code_generation_serializer"],
            paramLabel = "CODE_GENERATION_SERIALIZER",
            description = ["name of the code generation serializer to use"]
        )
        set(value) {
            if (value != null && value !in supportedCodeGenerationSerializers)
                throw CommandLine.ParameterException(commandSpec.commandLine(), "Unknown code generation serializer" +
                    "$value")

            field = value
        }

    /*
     * Convenience property to retrieve the chosen code generation serializer instance (or the default one) in
     * combination with its info object
     */
    internal val codeGenerationSerializer: Pair<CodeGenerationSerializerI, CodeGenerationSerializerInfo>
        get() {
            val serializerInfo = if (parameterCodeGenerationSerializerName != null)
                    supportedCodeGenerationSerializers[parameterCodeGenerationSerializerName!!]!!
                else
                    defaultCodeGenerationSerializer

            val serializerInstance = serializerInfo.clazz.getConstructor().newInstance()
            return serializerInstance to serializerInfo
        }

    /* Commandline option for a path to a file in which line count information will be stored */
    @CommandLine.Option(
        names = ["--line_count_file_path"],
        paramLabel = "LINE_COUNT_FILE_PATH",
        description = ["path to a file in which line count information will be stored"]
    )
    var parameterLineCountFile: String? = null

    /**
     * Get paths to all Genlets. The key of the map is the Genlet path and the value is the name of the explicitly
     * passed fully-qualified Genlet entry classname. It may be null, if it shall be automatically inferred.
     */
    fun genlets() : Map<String, String?> {
        val genlets = mutableMapOf<String, String?>()
        if (parameterFullQualifiedGenlets != null)
            genlets.putAll(parameterFullQualifiedGenlets!!)
        if (parameterGenlets != null)
            genlets.putAll(parameterGenlets!!.map { it to null })
        return genlets
    }

    /**
     * Invoke the singleton instance to parse the commandline arguments
     */
    internal operator fun invoke(args: Array<String>,
        supportedCodeGenerationSerializers: Map<String, CodeGenerationSerializerInfo>) {
        this.supportedCodeGenerationSerializers = supportedCodeGenerationSerializers
        defaultCodeGenerationSerializer = supportedCodeGenerationSerializers.values.find { it.default }!!
        CommandLine(this)
            .setOverwrittenOptionsAllowed(true)
            .parse(*args)
    }
}