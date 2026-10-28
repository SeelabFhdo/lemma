package de.fhdo.lemma.data.datadsl.diagram

import de.fhdo.lemma.diagram.common.PlantUmlRenderer
import de.fhdo.lemma.data.DataDslStandaloneSetup
import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.data.DataPackage
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.swt.widgets.Shell
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.handlers.HandlerUtil
import org.eclipse.ui.ide.IDE
import org.eclipse.xtext.resource.XtextResourceSet

/**
 * Generate the diagram of the selected data models, and show it.
 *
 * A thin shell around [[DataModelDiagramGenerator]]: it finds the selected
 * files, loads each as a data model, writes the generated PlantUML beside it,
 * renders it into an image and opens the image. Everything that decides what
 * the diagram looks like is in the generator, which needs no Eclipse and can
 * therefore be checked without one.
 *
 * The PlantUML is kept beside the image rather than written to a temporary
 * file: it is the diffable source of the diagram, it renders in GitHub as it
 * is, and it is what a reader can correct by hand.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class GenerateDataModelDiagramHandler extends AbstractHandler {
    static val DATA_EXTENSION = "data"
    static val DIAGRAM_EXTENSION = "puml"
    static val TITLE = "LEMMA Data Model Diagram"

    override execute(ExecutionEvent event) throws ExecutionException {
        val shell = HandlerUtil.getActiveShell(event)
        val files = HandlerUtil.getCurrentStructuredSelection(event).toList
            .filter(IFile)
            .filter[DATA_EXTENSION == fileExtension]
            .toList

        if (files.empty) {
            MessageDialog.openInformation(shell, TITLE,
                '''Select one or more .«DATA_EXTENSION» files to generate a diagram from.''')
            return null
        }

        val generator = new DataModelDiagramGenerator
        val renderer = new PlantUmlRenderer
        val resourceSet = createResourceSet
        val written = <String>newLinkedList
        val images = <IFile>newLinkedList
        val failed = <String>newLinkedList

        for (file : files) {
            try {
                val diagram = generate(file, generator, resourceSet)
                written.add(diagram.name)
                if (renderer.available) {
                    images.add(render(diagram, renderer))
                }
            } catch (Exception exception) {
                // One unreadable model must not stop the others, and what went
                // wrong is more useful than that something did.
                failed.add('''«file.name»: «exception.message»''')
            }
        }

        // The diagram is the point of the command, so it is opened rather than
        // only announced. The first of them: opening twenty editors at once
        // would bury the result instead of showing it.
        images.head?.open
        report(shell, written, images, failed, renderer)
        return null
    }

    /**
     * Generate the diagram of one file and write it beside the model.
     */
    private def IFile generate(IFile file, DataModelDiagramGenerator generator,
        XtextResourceSet resourceSet) {
        val location = file.location.toFile
        val resource = resourceSet.createResource(
            URI.createFileURI(location.absolutePath))
        resource.load(resourceSet.loadOptions)

        if (resource.contents.empty) {
            throw new IllegalStateException("the file holds no data model")
        }
        val model = resource.contents.head
        if (!(model instanceof DataModel)) {
            throw new IllegalStateException("the file holds no data model")
        }

        val diagram = generator.generate(model as DataModel)
        val target = Paths.get(
            location.parent, '''«baseName(file.name)».«DIAGRAM_EXTENSION»'''.toString)
        Files.write(target, diagram.getBytes(StandardCharsets.UTF_8))
        return refresh(file, target)
    }

    /**
     * Render a written diagram into an image beside it.
     */
    private def IFile render(IFile diagram, PlantUmlRenderer renderer) {
        val image = renderer.render(Paths.get(diagram.location.toFile.absolutePath))
        return refresh(diagram, image)
    }

    /**
     * Make a file written outside the workspace visible in it.
     *
     * Both the PlantUML and the image are written through java.nio, which the
     * workspace knows nothing about, so the folder is refreshed and the new
     * file is looked up in it.
     */
    private def IFile refresh(IFile sibling, Path target) {
        val folder = sibling.parent
        folder.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor)
        return folder.getFile(
            new org.eclipse.core.runtime.Path(target.fileName.toString))
    }

    /**
     * Open an image in an editor, so the command ends in a diagram.
     *
     * Failing to open it is not failing to generate it, so it is not reported
     * as such: the file is there either way and the message names it.
     */
    private def void open(IFile image) {
        try {
            val page = PlatformUI.workbench?.activeWorkbenchWindow?.activePage
            if (page !== null) {
                IDE.openEditor(page, image)
            }
        } catch (Exception exception) {
            // No editor is registered for the format, or the workbench is going
            // down: the file is written either way and the message names it.
        }
    }

    /**
     * A resource set that can read a data model.
     *
     * The same standalone setup the reconstruction's writer uses, which works
     * inside a running Eclipse as well.
     */
    private def XtextResourceSet createResourceSet() {
        EPackage.Registry.INSTANCE.put(DataPackage.eNS_URI, DataPackage.eINSTANCE)
        val injector = new DataDslStandaloneSetup().createInjectorAndDoEMFRegistration
        return injector.getInstance(XtextResourceSet)
    }

    private def String baseName(String fileName) {
        val separator = fileName.lastIndexOf(".")
        return if (separator > 0) fileName.substring(0, separator) else fileName
    }

    /**
     * Say what was written, what was rendered and what was not.
     */
    private def report(Shell shell, Iterable<String> written, Iterable<IFile> images,
        Iterable<String> failed, PlantUmlRenderer renderer) {
        val summary = '''
            Generated «written.size» diagram(s)«IF !written.empty»:

            «written.join("\n")»«ENDIF»
        '''
        val rendering = if (renderer.available)
                '''Rendered «images.size» image(s).'''
            else
                renderer.installationHint

        if (failed.empty) {
            MessageDialog.openInformation(shell, TITLE,
                '''
                «summary»
                «rendering»
                '''.toString)
            return
        }

        MessageDialog.openWarning(shell, TITLE,
            '''
            «summary»
            «rendering»

            «failed.size» could not be read:

            «failed.join("\n")»
            '''.toString)
    }
}
