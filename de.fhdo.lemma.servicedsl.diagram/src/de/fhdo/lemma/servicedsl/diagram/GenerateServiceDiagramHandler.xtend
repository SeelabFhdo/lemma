package de.fhdo.lemma.servicedsl.diagram

import de.fhdo.lemma.diagram.common.PlantUmlRenderer
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.util.List
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.Path
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.swt.widgets.Shell
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.handlers.HandlerUtil
import org.eclipse.ui.ide.IDE

/**
 * Generate the diagrams of the selected service models, and show them.
 *
 * Three diagrams: the interfaces of each selected model, and - once, for the
 * whole selection - the overview and the detail of what the services require of
 * each other. The interface diagram is per model because a reader who opens one
 * service model is asking what that service offers; the dependency diagrams are
 * for the selection as a whole because a dependency crosses model files.
 *
 * A thin shell around the generators, which need no Eclipse and are therefore
 * checked without one by ``ServiceGraphTest``.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class GenerateServiceDiagramHandler extends AbstractHandler {
    static val SERVICES_EXTENSION = "services"
    static val DIAGRAM_EXTENSION = "puml"
    static val TITLE = "LEMMA Service Model Diagrams"

    static val INTERFACES_SUFFIX = "-interfaces"
    static val DEPENDENCIES_SUFFIX = "-dependencies"
    static val DETAIL_SUFFIX = "-dependencies-detail"

    override execute(ExecutionEvent event) throws ExecutionException {
        val shell = HandlerUtil.getActiveShell(event)
        val files = HandlerUtil.getCurrentStructuredSelection(event).toList
            .filter(IFile)
            .filter[SERVICES_EXTENSION == fileExtension]
            .toList

        if (files.empty) {
            MessageDialog.openInformation(shell, TITLE,
                '''Select one or more .«SERVICES_EXTENSION» files to generate diagrams from.''')
            return null
        }

        val renderer = new PlantUmlRenderer
        val written = <String>newLinkedList
        val images = <IFile>newLinkedList
        val failed = <String>newLinkedList

        for (file : files) {
            try {
                // A reader of its own per diagram set, so one unreadable model
                // cannot leave a half-read graph behind for the next.
                val graph = new ServiceModelReader().read(pathOf(file))
                graph.problems.forEach[failed.add('''«file.name»: «it»''')]
                write(file, INTERFACES_SUFFIX,
                    new InterfaceDiagramGenerator().generate(graph),
                    renderer, written, images)
            } catch (Exception exception) {
                // One unreadable model must not stop the others, and what went
                // wrong is more useful than that something did.
                failed.add('''«file.name»: «exception.message»''')
            }
        }

        // Once for the selection: the dependencies of everything reachable from
        // it. Written beside the first selected model, because the diagram
        // belongs to no single one of them.
        try {
            val generator = new DependencyDiagramGenerator
            val graph = new ServiceModelReader().read(files.map[pathOf(it)].toList)
            graph.problems.forEach[failed.add('''dependencies: «it»''')]
            write(files.head, DEPENDENCIES_SUFFIX, generator.generateOverview(graph),
                renderer, written, images)
            write(files.head, DETAIL_SUFFIX, generator.generateDetail(graph),
                renderer, written, images)
        } catch (Exception exception) {
            failed.add('''dependencies: «exception.message»''')
        }

        // The first of them: opening six editors at once would bury the result
        // instead of showing it.
        images.head?.open
        report(shell, written, images, failed, renderer)
        return null
    }

    /**
     * Write one diagram beside a model, render it, and remember both.
     */
    private def void write(IFile model, String suffix, String diagram,
        PlantUmlRenderer renderer, List<String> written, List<IFile> images) {
        val target = java.nio.file.Path.of(model.location.toFile.parent,
            '''«baseName(model.name)»«suffix».«DIAGRAM_EXTENSION»'''.toString)
        Files.write(target, diagram.getBytes(StandardCharsets.UTF_8))
        written.add(target.fileName.toString)
        refresh(model, target.fileName.toString)

        if (renderer.available) {
            val image = renderer.render(target)
            images.add(refresh(model, image.fileName.toString))
        }
    }

    /**
     * Make a file written outside the workspace visible in it.
     *
     * The diagrams are written through java.nio, which the workspace knows
     * nothing about, so the folder is refreshed and the new file looked up.
     */
    private def IFile refresh(IFile sibling, String name) {
        val folder = sibling.parent
        folder.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor)
        return folder.getFile(new Path(name))
    }

    /**
     * Open an image in an editor, so the command ends in a diagram.
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

    private def java.nio.file.Path pathOf(IFile file) {
        return java.nio.file.Path.of(file.location.toFile.absolutePath)
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

            «failed.size» problem(s):

            «failed.join("\n")»
            '''.toString)
    }
}
