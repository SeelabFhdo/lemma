package de.fhdo.lemma.data.avro.ui.to_avro

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IFile

import static de.fhdo.lemma.data.avro.Util.*
import static de.fhdo.lemma.data.avro.Shared.*
import static de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils.*
import static de.fhdo.lemma.data.avro.ui.Util.*
import de.fhdo.lemma.data.intermediate.IntermediateDataModel
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.model.WorkbenchLabelProvider
import org.eclipse.core.resources.ResourcesPlugin
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.window.Window
import de.fhdo.lemma.data.avro.AvroGenerator
import de.fhdo.lemma.data.intermediate.IntermediateVersion
import de.fhdo.lemma.data.intermediate.IntermediateContext
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import org.apache.avro.Schema
import java.nio.file.Paths
import java.nio.file.Files
import java.io.PrintStream
import java.io.FileOutputStream
import de.fhdo.lemma.data.avro.ui.Util
import org.eclipse.emf.ecore.xmi.XMIResource
import org.apache.avro.Protocol
import de.fhdo.lemma.utils.LemmaUtils
import de.fhdo.lemma.eclipse.ui.ProgrammaticIntermediateModelTransformation
import de.fhdo.lemma.eclipse.ui.ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult

/**
 * Handler to control the conversion of LEMMA models to Avro schema specification files.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class TransformToAvroHandler extends AbstractHandler {
    /**
     * Current shell
     */
    static val SHELL = PlatformUI.workbench.activeWorkbenchWindow.shell

    var boolean intermediateDataModelTransformationExceptionOccurred

    /**
     * Execute handler
     */
    override execute(ExecutionEvent event) throws ExecutionException {
        if (event.command.id != "de.fhdo.lemma.data.avro.commands.transformToAvro")
            return null

        /* Load IntermediateDataModel instance from selected file */
        val selectedFile = getSelectedFile(event)
        if (selectedFile === null)
            return null

        if (selectedFile.fileExtension == "xmi")
            selectedFile.triggerAvroGeneration()
        else if (selectedFile.fileExtension == "data")
            selectedFile.performIntermediateTransformationAndTriggerAvroGeneration()

        return null
    }

    /**
     * Trigger Avro generation from the given IFile which must comprise an intermediate data model
     * in the XMI format
     */
    private def triggerAvroGeneration(IFile intermediateDataModelFile) {
        intermediateDataModelFile.triggerAvroGeneration(intermediateDataModelFile.asXmiResource)
    }

    /**
     * Trigger Avro generation for the given IFile and intermediate data model XMI resource
     */
    private def triggerAvroGeneration(IFile intermediateDataModelFile,
        XMIResource intermediateDataModelResource) {
        val selectedDataModelRoot = intermediateDataModelResource.intermediateDataModelRoot
        if (selectedDataModelRoot === null)
            return null

        /*
         * Get top-level complex type containers from loaded model as initial model elements from
         * which the user may select the source LEMMA model elements to derive Avro schemas from
         */
        val initialModelElements = getTopLevelComplexTypeContainers(selectedDataModelRoot)
        if (initialModelElements.empty) {
            showError("Avro Schema Transformation Error", "Intermediate LEMMA domain model is " +
                "empty.")
            return null
        }

        /*
         * Get selected source LEMMA model elements to derive Avro schemas from as well as the
         * target file path for the Avro schema file
         */
        val selectModelElementsInfo = selectModelElements(intermediateDataModelFile,
            initialModelElements)
        if (selectModelElementsInfo === null)
            return null

        val selectElementsResult = selectModelElementsInfo.key
        val avroSchemaFilepath = selectModelElementsInfo.value

        /*
         * Perform actual Avro generation
         */
        if (avroGeneration(selectElementsResult, avroSchemaFilepath))
            showInfo("Avro Schema Transformation Successful", "Selected model elements were " +
                "successfully transformed to Avro schema specifications in file " +
                '''«avroSchemaFilepath».''')

        return null
    }

    /**
     * Load given IFile as XMI resource
     */
    private def XMIResource asXmiResource(IFile file) {
        return try {
            loadXmiResource(file)
        } catch (Exception ex) {
            showError("Avro Schema Transformation Error", "An error occurred while loading the " +
                '''XMI resource from «file.fullPath»: «getErrorMessageOrSimpleClassName(ex)»''')
            null
        }
    }

    /**
     * Get root of given XMI resource as IntermediateDataModel
     */
    private def IntermediateDataModel getIntermediateDataModelRoot(XMIResource xmiResource) {
        return try {
            xmiResource.contents.get(0) as IntermediateDataModel
        } catch (Exception ex) {
            showError("Avro Schema Transformation Error", "XMI resource is not an intermediate " +
                "LEMMA domain model.")
            null
        }
    }

    /**
     * Get the selection of source LEMMA elements to be transformed to Avro schemas as well as the
     * file path for the derived Avro schema specification file from the user
     */
    private def Pair<SelectElementsDialogResult, String> selectModelElements(IFile selectedFile,
        List<? extends EObject> initialModelElements) {
        /* Get the selection of source LEMMA elements */
        val selectResult = selectElementsDialog(selectedFile.name, initialModelElements)
        if (selectResult === null)
            return null

        // Determine target file extension
        val isProtocolTransformation = !selectResult.protocolName.nullOrEmpty
        val filenameAndExtension = if (isProtocolTransformation)
                LemmaUtils.getSimpleName(selectResult.protocolName) -> Util.PROTOCOL_FILE_EXTENSION
            else
                LemmaUtils.getSimpleName(qualifiedName(selectResult.elements.get(0)))
                    -> Util.SCHEMA_FILE_EXTENSION

        /*
         * Let user select file path for Avro schema specification file from the project of the
         * selected XMI file
         */
        val avroSchemaFilepath = selectProjectFileDialog(selectedFile, filenameAndExtension.value,
            filenameAndExtension.key)
        if (avroSchemaFilepath.nullOrEmpty)
            return null

        return selectResult -> avroSchemaFilepath
    }

    /**
     * Helper class to encapsulate the elements, protocol name and documentation from an instance of
     * the LemmaToAvroDialog
     */
    private static class SelectElementsDialogResult {
        List<? extends EObject> elements
        String protocolName
        String protocolDocumentation

        new(LemmaToAvroDialog dialog) {
            elements = dialog.selectedElements
            protocolName = dialog.protocolName
            protocolDocumentation = dialog.protocolDocumentation
        }
    }

    /**
     * Let the user select the source LEMMA elements to be transformed to Avro schemas
     */
    private def SelectElementsDialogResult selectElementsDialog(String modelFilename,
        List<? extends EObject> initialElements) {
        val dialog = new LemmaToAvroDialog(SHELL, modelFilename, initialElements)
        dialog.create()

        return if (dialog.open() != Window.CANCEL)
                new SelectElementsDialogResult(dialog)
            else
                null
    }

    /**
     * Let the user specify the file path for the target Avro schema specification file
     */
    private def String selectProjectFileDialog(IFile file, String fileExtension,
        String initialFilename) {
        val dialog = new ProjectFileSelectionDialog(SHELL, file.project, initialFilename,
            fileExtension, new WorkbenchLabelProvider())
        dialog.input = ResourcesPlugin.workspace.root
        dialog.message = "Specify project-relative target file for generated Avro schemas"
        dialog.initialElementSelections = newArrayList(file.parent)

        return if (dialog.open() != Window.CANCEL)
                dialog.targetFilepath
            else
                null
    }

    /**
     * Perform Avro schema generation from user input
     */
    private def boolean avroGeneration(SelectElementsDialogResult elementSelectionResult,
        String targetFilepath) {
        /* Schemas generation */
        val schemas = elementSelectionResult.elements.generateSchemas
        if (schemas === null)
            return false

        /* Write schemas to disk, either in plain form or bundled as an Avro protocol */
        val generateProtocol = !elementSelectionResult.protocolName.nullOrEmpty
        if (!generateProtocol)
            schemas.writeToFile(targetFilepath)
        else
            schemas.generateProtocol(elementSelectionResult.protocolName,
                elementSelectionResult.protocolDocumentation).writeToFile(targetFilepath)

        return true
    }

    /**
     * Generate Avro schemas from a list of LEMMA model elements
     */
    private def List<Schema> generateSchemas(List<? extends EObject> modelElements) {
        val schemas = <Schema>newArrayList

        for (element : modelElements) {
            try {
                schemas.addAll(element.generateSchemas)
            } catch (Exception ex) {
                showError("Avro Schema Transformation Error", "An error occurred while trying to " +
                    '''transform model element «qualifiedName(element)» to an Avro schema: ''' +
                    getErrorMessageOrSimpleClassName(ex))
                return null
            }
        }

        return schemas
    }

    /**
     * Generate Avro schemas from single LEMMA model element
     */
    private def List<Schema> generateSchemas(EObject eObject) {
        val schemas = switch(eObject) {
            IntermediateVersion: new AvroGenerator().generateSchemasFrom(eObject)
            IntermediateContext: new AvroGenerator().generateSchemasFrom(eObject)
            IntermediateComplexType: {
                val typeSchema = new AvroGenerator().generateSchemasFrom(eObject).key
                newArrayList(typeSchema)
            }
            default: emptyList
        }

        return schemas.filter[isNamedSchema(it)].toList
    }

    /**
     * Serialize a list of Avro schemas to a file
     */
    private def void writeToFile(List<Schema> schemas, String targetFilepath) {
        try (val out = new PrintStream(new FileOutputStream(targetFilepath))) {
            schemas.forEach[out.println(it.toString(true))]
        }
    }

    /**
     * Generate an Avro protocol from the given list of Avro schemas
     */
    private def Protocol generateProtocol(List<Schema> schemas, String protocolName,
        String protocolDocumentation) {
        val name = LemmaUtils.getSimpleName(protocolName)
        val namespace = LemmaUtils.getQualifyingParts(protocolName)
        return new AvroGenerator().toProtocol(schemas, name, protocolDocumentation, namespace)
    }

    /**
     * Serialize Avro protocol to a file
     */
    private def void writeToFile(Protocol protocol, String targetFilepath) {
        Files.write(Paths.get(targetFilepath), protocol.toString(true).bytes)
    }

    /**
     * Transform the given IFile which must comprise a LEMMA data model into the corresponding
     * intermediate representation and then trigger Avro generation for this representation
     */
    private def performIntermediateTransformationAndTriggerAvroGeneration(IFile dataModelFile) {
        intermediateDataModelTransformationExceptionOccurred = false

        val transformation = new ProgrammaticIntermediateModelTransformation(dataModelFile)
        transformation.run(
            "AVRO_INTERMEDIATE_TRANSFORMATION",
            dataModelFile,
            SHELL.display,
            false,
            [true],
            [transformationExceptionOccurred],
            [triggerAvroGeneration],
            [true]
        )
    }

    /**
     * Catch exceptions occurred during the intermediate transformation of the selected LEMMA data
     * model
     */
    private def transformationExceptionOccurred(Exception exception) {
        intermediateDataModelTransformationExceptionOccurred = true
        showError("Avro Schema Transformation Error", "Intermediate transformation of LEMMA " +
            '''domain model failed: «exception.message».''')
        return false
    }

    /**
     * Trigger Avro generation for the successfully transformed intermediate LEMMA data model
     */
    private def boolean triggerAvroGeneration(
        List<ProgrammaticIntermediateModelTransformationResult> results
    ) {
        if (intermediateDataModelTransformationExceptionOccurred || results.empty)
            return false

        val result = results.get(0)
        val intermediateDataModelResource = result.result.outputModel.resource as XMIResource
        triggerAvroGeneration(result.data as IFile, intermediateDataModelResource)

        return true
     }
}