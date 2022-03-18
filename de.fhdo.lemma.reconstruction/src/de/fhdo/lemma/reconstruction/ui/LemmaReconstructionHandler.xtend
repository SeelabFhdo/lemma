package de.fhdo.lemma.reconstruction.ui

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.ui.PlatformUI
import de.fhdo.lemma.reconstruction.MongoDbRepository
import java.util.List
import de.fhdo.lemma.reconstruction.domain.Context
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.DirectoryDialog
import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.data.datadsl.extractor.DataDslExtractor
import java.nio.file.Files
import java.io.File
import java.nio.file.Paths
import org.eclipse.jface.dialogs.MessageDialog
import de.fhdo.lemma.reconstruction.service.Microservice
import de.fhdo.lemma.reconstruction.domain.LemmaDomainGenerator
import de.fhdo.lemma.reconstruction.service.LemmaServiceGenerator
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.servicedsl.extractor.ServiceDslExtractor

class LemmaReconstructionHandler extends AbstractHandler {
    /**
     * Current shell
     */
    static val SHELL = PlatformUI.workbench.activeWorkbenchWindow.shell

    String mongoDbHostname
    String mongoDbPort

    List<Context> initialContexts = newLinkedList
    List<Context> selectedContexts = newLinkedList

    List<Microservice> initialMicroservices = newLinkedList
    List<Microservice> selectedMicroservices = newLinkedList

    String reconstructionPath

    List<DataModel> domainDataModels = newLinkedList
    List<ServiceModel> serviceModels = newLinkedList

    override execute(ExecutionEvent event) throws ExecutionException {
        receiveMongoDbEndpoints
        loadContextInformationFromMongoDb
        loadMicroservicesFromMongoDB

        displayReconstructionInforation
        selectTargetFolderForModelGeneration
        generateModels
        writeModelsToFolder
        showReconstructionInformationMessage




        resetDialogHandler
        return null
    }

    private def receiveMongoDbEndpoints() {
        val dialog = new LemmaReconstructionDialog(SHELL)
        dialog.create
        dialog.open
        mongoDbHostname = dialog.mongoDbHostname
        mongoDbPort = dialog.mongoDbPort
    }

    private def displayReconstructionInforation() {
        val dialog = new LemmaReconstructionResultsDialog(SHELL, initialContexts,
            initialMicroservices
        )
        dialog.create
        dialog.open
        selectedContexts = dialog.selectedContexts
        selectedMicroservices = dialog.selectedMicroservices
    }

    private def loadContextInformationFromMongoDb() {
        val repository = new MongoDbRepository(mongoDbHostname, Integer::parseInt(mongoDbPort))
        initialContexts.addAll(repository.getReconstructedContexts)
    }

    private def loadMicroservicesFromMongoDB() {
        val repository = new MongoDbRepository(mongoDbHostname, Integer::parseInt(mongoDbPort))
        initialMicroservices.addAll(repository.reconstructedMicroservices)

    }

    private def selectTargetFolderForModelGeneration() {
        val fileDialog = new DirectoryDialog( SHELL, SWT.OPEN );
        reconstructionPath = fileDialog.open
    }

    private def generateModels() {
        generateDomainModels
        generateServiceModels
    }

    private def generateDomainModels() {
        val generator = new LemmaDomainGenerator
        selectedContexts.forEach[
            domainDataModels.addAll(generator.generateDataModel(it))
        ]
    }

    private def generateServiceModels() {
        val generator = new LemmaServiceGenerator
        selectedMicroservices.forEach[
            val model = generator.generateModelFrom(it)
            serviceModels.add(model)
        ]
    }

    private def writeModelsToFolder() {
        domainDataModels.forEach[
            writeDomainDataModel(it)
        ]

        serviceModels.forEach[
            writeServiceModel(it)
        ]
    }

    private def writeDomainDataModel(DataModel model) {
        val dataModel = new DataDslExtractor().extractToString(model)
        val fileName = model.contexts.get(0).name
        val filePath
            = '''«reconstructionPath»«File.separator»domain«File.separator»«fileName».data'''

        Files.createDirectories(Paths.get('''«reconstructionPath»«File.separator»domain'''))
        Files.write(Paths.get(filePath), dataModel.bytes)
    }


    private def writeServiceModel(ServiceModel model) {
        val serviceModel = new ServiceDslExtractor().extractToString(model)
        val fileName = model.microservices.get(0).qualifiedNameParts.last
        val filePath
            = '''«reconstructionPath»«File.separator»service«File.separator»«fileName».services'''
        Files.createDirectories(Paths.get('''«reconstructionPath»«File.separator»service'''))
        Files.write(Paths.get(filePath), serviceModel.bytes)
    }

    private def showReconstructionInformationMessage() {
        val title = "Reconstruction Information Message"
        val generatedLemmaModels = <String>newLinkedList

        domainDataModels.forEach[ models |
            models.contexts.forEach[context |
                generatedLemmaModels.add('''«context.name».data''')
            ]
        ]

        selectedMicroservices.forEach[
            generatedLemmaModels.add('''«it.name.split("\\W").last».services''')
        ]

        val messageText = "Generated Models:"
        val messageModels = messageText + "\n\t- " + generatedLemmaModels.join("\n\t- ") + "\n\n"
        showInfoDialogMessage(title, messageModels)
    }

    private def showInfoDialogMessage(String title, String message) {
        MessageDialog.openInformation(SHELL, title, message)
    }

    private def resetDialogHandler() {
        initialContexts.clear
        selectedContexts.clear
        domainDataModels.clear

        initialMicroservices.clear
        selectedMicroservices.clear
        serviceModels.clear
    }

}