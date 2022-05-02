package de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.avro

import com.github.javaparser.StaticJavaParser
import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.google.gson.Gson
import com.google.gson.JsonElement
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation.GENERATED_CODE_SUBFOLDER_NAME
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.isAvroProtocolFile
import de.fhdo.lemma.model_processing.utils.removeFileUri
import org.apache.avro.Protocol
import org.apache.avro.Schema
import org.apache.avro.compiler.specific.SpecificCompiler
import org.apache.avro.generic.GenericData
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

private const val AVRO_COMPILER_ENABLE_DECIMAL_LOGICAL_TYPE = true
private val AVRO_COMPILER_STRING_TYPE = GenericData.StringType.String
private const val AVRO_COMPILED_JAVA_CLASSES_SUB_PACKAGE = "avro"
private const val AVRO_COMPILED_JAVA_CLASSES_GEN_PACKAGE = "avro_$GENERATED_CODE_SUBFOLDER_NAME"

internal class AvroSchemaCompiler(
    private val compiledJavaFilesPackage: String,
    private val microserviceJavaPath: String,
    private val microserviceResourcePath: String
) {
    fun compileConfiguredSchema(structure: IntermediateDataStructure, avroSchemaAspect: IntermediateImportedAspect)
        : Map<File, CompilationUnit> {
        val schemaFilePath = getSchemaFileAbsolutePath(structure, avroSchemaAspect)
        val schemaContent = readSchemaFileContent(schemaFilePath) ?: return emptyMap()

        return if (schemaFilePath.isAvroProtocolFile())
            compileAvroProtocol(schemaFilePath, schemaContent, avroSchemaAspect.getPropertyValue("type"))
        else
            compileAvroSchema(schemaContent)
    }

    private fun getSchemaFileAbsolutePath(structure: IntermediateDataStructure,
        avroSchemaAspect: IntermediateImportedAspect) : String {
        val schemaFilePath = avroSchemaAspect.getPropertyValue("file")!!
        val fileFromResources = avroSchemaAspect.getPropertyValue("fromResources")?.toBoolean() ?: false
        return if (fileFromResources)
                microserviceResourcePath + File.separator + schemaFilePath
            else if (!File(schemaFilePath).isAbsolute)
                structure.sourceMappingModelUri.removeFileUri() + File.separator + schemaFilePath
            else
                schemaFilePath
    }

    private fun readSchemaFileContent(schemaFilePath: String) : String? {
        val schemaFile = File(schemaFilePath)
        return if (schemaFile.exists())
                schemaFile.readText()
            else
                null
    }

    private fun compileAvroProtocol(schemaFilePath: String, schemaContent: String, typeName: String?)
        : Map<File, CompilationUnit> {
        schemaFilePath.ensureTypeNameIfAvroProtocolFile(typeName)

        val parsedProtocol = Protocol.parse(schemaContent)
        require(parsedProtocol.getType(typeName) != null) {
            """Schema file "$schemaFilePath" does not define Avro type with name "$typeName" """
        }

        return parsedProtocol.getTypeSchemaWithPatchedNamespace(typeName!!).compileToMicroserviceJavaPath()
    }

    private fun Protocol.getTypeSchemaWithPatchedNamespace(typeName: String)
        = getType(typeName)!!.getWithPatchedNamespace()

    private fun Schema.getWithPatchedNamespace() : Schema {
        val gson = Gson()
        val jsonElement = gson.fromJson(toString(), JsonElement::class.java).asJsonObject!!

        val currentNamespace = jsonElement.get("namespace")?.asString ?: ""
        jsonElement.addProperty("namespace", currentNamespace.toAvroSchemaPackage())

        val schemaWithPatchedNamespace = gson.toJson(jsonElement)
        return Schema.Parser().parse(schemaWithPatchedNamespace)
    }

    private fun String.toAvroSchemaPackage() : String {
        val basePackage = if (startsWith(compiledJavaFilesPackage)) {
                // Schema namespace starts with the package name for the compiled Java classes. In this case, patch the
                // Avro-specific sub-package into the schema namespace. Suppose that the package name for the compiled
                // Java classes is "org.example", that the schema namespace is "org.example.MySchema", and that the
                // Avro-specific sub-package is "avro". Then, the base package is "org.example.avro.MySchema".
                val schemaSpecificPackage = removePrefix(compiledJavaFilesPackage)
                "$compiledJavaFilesPackage.$AVRO_COMPILED_JAVA_CLASSES_SUB_PACKAGE.$schemaSpecificPackage"
            } else if (isNotEmpty())
                // Schema namespace does not start with the package name for the compiled Java classes but is also not
                // empty. In this case, prefix the namespace with the package name for the compiled Java classes and the
                // Avro-specific sub-package. Suppose that the schema namespace is "MySchema", that the package name for
                // the compiled Java classes is "org.example", and that the Avro-specific sub-package is "avro". Then,
                // the base package is "org.example.avro.MySchema".
                "$compiledJavaFilesPackage.$AVRO_COMPILED_JAVA_CLASSES_SUB_PACKAGE.$this"
            else
                // Schema namespace is empty. In this case, the base package consists of the package name for the
                // compiled Java classes and the Avro-specific sub-package, e.g., "org.example.avro".
                "$compiledJavaFilesPackage.$AVRO_COMPILED_JAVA_CLASSES_SUB_PACKAGE"

        // Add the Avro-specific sub-package for generated Java classes resulting in complete schema namespaces like
        // "org.example.avro.MySchema.avro_gen" or "org.example.avro.avro_gen"
        return "$basePackage.$AVRO_COMPILED_JAVA_CLASSES_GEN_PACKAGE"
    }

    private fun Schema.compileToMicroserviceJavaPath() : Map<File, CompilationUnit> {
        /*
         * We first compile the schema to a temporary working directory. This approach enables us to unambiguously
         * recognize the Java files that were created by the Avro compiler from the schema.
         * FIXME: We have to take this approach because Avro's SpecificCompiler class doesn't yet provide direct access
         *        to the result of its package-private compile() method which is invoked by compileToDestination() and
         *        returns a Collection of virtual OutputFile instances. Maybe in a future Avro version there will be a
         *        possibility to directly access those virtual files so that callers can immediately determine which
         *        files were created by a specific call of compileToDestination().
         */
        val compiledJavaFilesPackage = File(compiledJavaFilesPackage)
        val workdir = try {
            Files.createTempDirectory(null)!!.toFile()
        } catch (ex: Exception) {
            Files.createTempDirectory(compiledJavaFilesPackage.path)!!.toFile()
        }

        val compiler = SpecificCompiler(this)
        compiler.setStringType(AVRO_COMPILER_STRING_TYPE)
        compiler.setEnableDecimalLogicalType(AVRO_COMPILER_ENABLE_DECIMAL_LOGICAL_TYPE)
        compiler.compileToDestination(null, workdir)

        /*
         * Copy the Java classes generated by the Avro compiler from the temporary working directory to the directory
         * for Java files in the current microservice.
         *
         * The following call to namespaceToFolderIn() ensures that only those files are copied that were created by the
         * Avro compiler in the Java package hierarchy resulting from the schema namespace. This approach deals with the
         * rare situation that files in the temporary working directory were not created by the previous invocation of
         * the Avro compiler.
         *
         * Note also that the following call to mapContainedJavaFilesToFilesIn() preserves the package structure of the
         * files generated by the Avro compiler in the temporary working directory.
         */
        val compiledJavaFilesInMicroservicePath = namespaceToFolderIn(workdir.absolutePath)
            .mapContainedJavaFilesToFilesIn(microserviceJavaPath)
            .copyAll()

        /* Delete the temporary working directory (note that invoking workdir.deleteOnExit() doesn't seem to work) */
        workdir.walkBottomUp().forEach { it.delete() }

        /**
         * Return the result of the method as a map whose keys are the File objects of the Java classes, which were
         * previously generated by the Avro compiler and then copied to the directory for Java files in the current
         * microservice, and the result of their parsing.
         */
        return compiledJavaFilesInMicroservicePath.associateWith { StaticJavaParser.parse(it) }
    }

    private fun Schema.namespaceToFolderIn(absoluteBasePath: String)
        = absoluteBasePath to Paths.get(absoluteBasePath, namespace.replace(".", File.separator)).toFile()

    private fun Pair<String, File>.mapContainedJavaFilesToFilesIn(targetBaseFolderAbsolutePath: String)
        : Map<File, File> {
        val (baseFolderAbsolutePath, baseFolderWithJavaPackageFolders) = this
        val baseFolderWithJavaPackageFoldersAbsolutePath = baseFolderWithJavaPackageFolders.absolutePath
        require(baseFolderWithJavaPackageFoldersAbsolutePath.startsWith(baseFolderAbsolutePath)) {
            """"$baseFolderWithJavaPackageFoldersAbsolutePath" is not a sub-directory of "$baseFolderAbsolutePath""""
        }
        require(baseFolderWithJavaPackageFolders.isDirectory) {
            """"$baseFolderWithJavaPackageFoldersAbsolutePath" is not a directory"""
        }

        return baseFolderWithJavaPackageFolders.walk()
            .filter { it.extension.equals("java", ignoreCase = true) }
            .map {
                val relativePath = it.parentFile.absolutePath.removePrefix(baseFolderAbsolutePath)
                it to Paths.get(targetBaseFolderAbsolutePath, relativePath, it.name).toFile()
            }.toMap()
    }

    private fun Map<File, File>.copyAll() = map { (source, target) -> source.copyTo(target, true) }

    private fun File.javaPackageAndClassName(baseFolderAbsolutePath: String) : Pair<String, String> {
        val relativeFolder = parentFile.absolutePath.removePrefix(baseFolderAbsolutePath + File.separator)
        val packageName = relativeFolder.replace(File.separator, ".")
        val classname = nameWithoutExtension
        return packageName to classname
    }

    private fun compileAvroSchema(schemaContent: String)
        = Schema.Parser().parse(schemaContent).getWithPatchedNamespace().compileToMicroserviceJavaPath()
}