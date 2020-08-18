package de.fhdo.lemma.data.avro.ui.to_lemma

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.ui.PlatformUI

import static de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils.*
import static de.fhdo.lemma.data.avro.Util.*
import static de.fhdo.lemma.data.avro.ui.Util.*
import org.apache.avro.Schema
import org.apache.avro.Protocol
import java.io.File
import java.util.function.Function
import org.apache.avro.JsonProperties
import org.eclipse.core.resources.IFile
import java.util.List
import org.eclipse.jface.window.Window
import java.util.Map
import org.eclipse.emf.ecore.EObject
import de.fhdo.lemma.data.avro.LemmaGenerator
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.technology.Technology
import java.nio.file.Files
import java.nio.file.Paths
import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.data.datadsl.extractor.DataDslExtractor
import de.fhdo.lemma.technology.mapping.TechnologyMapping
import de.fhdo.lemma.technology.mappingdsl.extractor.MappingDslExtractor
import de.fhdo.lemma.data.avro.Shared
import de.fhdo.lemma.data.avro.ui.Util
import de.fhdo.lemma.data.avro.ui.to_lemma.SpecifyLemmaPathsDialog

/**
 * Handler to control the conversion of Avro schema specification files to LEMMA models.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class TransformToLemmaHandler extends AbstractHandler {
    /**
     * Current shell
     */
    static val SHELL = PlatformUI.workbench.activeWorkbenchWindow.shell

    /**
     * Execute handler
     */
    override execute(ExecutionEvent event) throws ExecutionException {
        if (event.command.id != "de.fhdo.lemma.data.avro.commands.transformToLemma")
            return null

        /* Parse Avro schemas from selected file */
        val selectedFile = getSelectedFile(event)
        val parsingResult = try {
                selectedFile.parseSchemas
            } catch (Exception ex) {
                showError("Schema Parsing Error", "An error occurred while parsing Avro " +
                    '''«IF selectedFile.isProtocol»protocol«ELSE»schema«ENDIF»: ''' +
                    getErrorMessageOrSimpleClassName(ex))
                return null
            }

        if (parsingResult.schemas.empty) {
            showError("Schema Parsing Error", "No named Avro types found in Avro " +
                '''«IF selectedFile.isProtocol»protocol«ELSE»schema«ENDIF».''')
            return null
        }

        /* Let user select Avro schema elements for transformation to LEMMA models */
        val selectedElements = selectElementsForTransformationDialog(
            selectedFile.name,
            parsingResult.name,
            parsingResult.namespace,
            parsingResult.documentation,
            parsingResult.schemas,
            parsingResult.protocol
        )

        if (selectedElements === null)
            return null
        else if (selectedElements instanceof List)
            if (selectedElements.empty)
                return null

        /* Let user select specify paths for LEMMA model kinds */
        val modelKindTargetPaths = specifyModelKindPathsDialog(selectedFile)
        if (modelKindTargetPaths === null)
            return null

        /* Generate LEMMA models */
        val generatedLemmaModels = lemmaGeneration(selectedElements, modelKindTargetPaths)
        if (generatedLemmaModels !== null) {
            val generatedLemmaModelsString = "\n\t- " + generatedLemmaModels.join("\n\t- ") + "\n\n"
            showInfo("LEMMA model transformation successful", "Selected schemas were " +
                "successfully transformed to the following LEMMA model files: " +
                generatedLemmaModelsString)
        }

        return null
    }

    /**
     * Parse Avro schemas from IFile
     */
    private def TransformToLemmaHandler.SchemasParsingResult parseSchemas(IFile file) {
        val Function<File, JsonProperties> parseFunction = if (file.isProtocol)
                [Protocol.parse(it)]
            else
                [new Schema.Parser().parse(it)]

        val parsedJsonProperties = parseFunction.apply(file.location.toFile)
        return switch(parsedJsonProperties) {
            Schema: new SchemasParsingResult(parsedJsonProperties)
            Protocol: new SchemasParsingResult(parsedJsonProperties)
            default: null
        }
    }

    /**
     * Check if the given IFile is expected to represent an Avro protocol depending on its extension
     */
    private def boolean isProtocol(IFile file) {
        return hasExtension(file, Util.PROTOCOL_FILE_EXTENSION)
    }

    /**
     * Helper class to represent schema parsing results
     */
    private static class SchemasParsingResult {
        var List<Schema> schemas = emptyList
        var String name = ""
        var String namespace = ""
        var String documentation = ""
        var Protocol protocol

        /**
         * Constructor from Schema instance
         */
        new(Schema schema) {
            if (schema === null) {
                return
            }

            schemas = if (schema.type == Schema.Type.UNION)
                    schema.types
                else
                    newArrayList(schema)

            if (schemas.size === 1) {
                name = schema.name
                namespace = schema.namespace
                documentation = schema.doc
            }
        }

        /**
         * Constructor from Protocol instance
         */
        new(Protocol protocol) {
            if (protocol === null) {
                return
            }

            this.schemas = protocol.types.toList
            this.name = protocol.name
            this.namespace = protocol.namespace
            this.documentation = protocol.doc
            this.protocol = protocol
        }
    }

    /**
     * Display Avro-to-LEMMA dialog to user and return the results
     */
    private def Object selectElementsForTransformationDialog(String avroFilename, String schemaName,
        String schemaNamespace, String schemaDocumentation, List<Schema> initialSchemas,
        Protocol protocol) {
        val dialog = new AvroToLemmaDialog(SHELL, avroFilename, schemaName, schemaNamespace,
            schemaDocumentation, initialSchemas, protocol)
        dialog.create()

        return switch(dialog.open()) {
            case Window.CANCEL:
                null
            case dialog.selectedProtocol !== null:
                dialog.selectedProtocol
            default:
                dialog.getSelectedSchemas
        }
    }

    /**
     * Display LEMMA paths specification dialog to user and return the results
     */
    private def Map<Class<? extends EObject>, Pair<String, String>> specifyModelKindPathsDialog(
        IFile file
    ) {
        val dialog = new SpecifyLemmaPathsDialog(SHELL, file.parent)
        dialog.create()

        return switch(dialog.open()) {
            case Window.CANCEL:
                null
            default:
                dialog.modelKindPaths
        }
    }

    /**
     * Generate LEMMA models
     */
    private def List<String> lemmaGeneration(Object source,
        Map<Class<? extends EObject>, Pair<String, String>> modelKindTargetPaths) {
        /* Generate data and mapping model */
        val serviceModelPath = modelKindTargetPaths.fullModelPath(ServiceModel)
        val avroModelPath = modelKindTargetPaths.fullModelPath(Technology)
        val generatedDataAndMappingModel = source.generateModelsFrom(serviceModelPath,
            avroModelPath)

        /* Serialize static content of Avro technology model */
        val writtenProjectRelativeFilepaths = <String>newArrayList
        if (writeFile(avroModelPath, Shared.StaticAvroTechnologyModel.content))
            writtenProjectRelativeFilepaths.add(modelKindTargetPaths.relativeModelPath(Technology))

        /* Serialize generated data model */
        val generatedDataModel = generatedDataAndMappingModel.key
        val dataModelPath = modelKindTargetPaths.fullModelPath(DataModel)
        if (writeModel(generatedDataModel, dataModelPath))
            writtenProjectRelativeFilepaths.add(modelKindTargetPaths.relativeModelPath(DataModel))

        /* Serialize generated mapping model */
        val generatedMappingModel = generatedDataAndMappingModel.value
        val mappingModelPath = modelKindTargetPaths.fullModelPath(TechnologyMapping)
        if (writeModel(generatedMappingModel, mappingModelPath))
            writtenProjectRelativeFilepaths.add(
                modelKindTargetPaths.relativeModelPath(TechnologyMapping)
            )

        return writtenProjectRelativeFilepaths
    }

    /**
     * Retrieve the full path of a model kind from a list of model kind paths
     */
    private def String fullModelPath(
        Map<Class<? extends EObject>, Pair<String, String>> modelKindPaths,
        Class<? extends EObject> modelKind
    ) {
        return modelKindPaths.get(modelKind)?.value ?: ""
    }

    /**
     * Generate LEMMA models from the given source, which may either be a Protocol instance or a
     * list of Avro schemas
     */
    private def generateModelsFrom(Object source, String serviceModelPath, String avroModelPath) {
        val generator = new LemmaGenerator()
        return try {
            if (source instanceof Protocol)
                generator.generateModelsFrom(source, serviceModelPath, avroModelPath)
            else {
                val schemas = source as List<Schema>
                generator.generateModelsFrom(schemas, serviceModelPath, avroModelPath)
            }
        } catch(ClassCastException ex) {
            showError("LEMMA model transformation error", "An error occurred while transforming " +
                "selected schemas to LEMMA models: " + getErrorMessageOrSimpleClassName(ex))
            null
        }
    }

    /**
     * Retrieve the project-relative path of a model kind from a list of model kind paths
     */
    private def String relativeModelPath(
        Map<Class<? extends EObject>, Pair<String, String>> modelKindPaths,
        Class<? extends EObject> modelKind
    ) {
        return modelKindPaths.get(modelKind)?.key ?: ""
    }

    /**
     * Write string contents to the given file path. Returns true if the file path and the contents
     * are not empty.
     */
    private def boolean writeFile(String filepath, String content) {
        if (filepath.nullOrEmpty || content.nullOrEmpty) {
            return false
        }

        Files.write(Paths.get(filepath), content.bytes)
        return true
    }

    /**
     * Serialize a LEMMA data or mapping model to the given file path. Returns true if the file path
     * and the contents extracted from the model's root are not empty.
     */
    private def boolean writeModel(EObject modelRoot, String filepath) {
        if (filepath.nullOrEmpty)
            return false

        val content = switch(modelRoot) {
            DataModel: new DataDslExtractor().extractToString(modelRoot)
            TechnologyMapping: new MappingDslExtractor().extractToString(modelRoot)
        }

        return filepath.writeFile(content)
    }
}