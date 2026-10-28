package de.fhdo.lemma.operationdsl.diagram

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
 * Generate the diagrams of the selected operation models, and show them.
 *
 * Two diagrams, once for the whole selection: the deployment topology, and what
 * each node is configured with. Both cover everything reachable through
 * `import nodes` rather than only what was selected, because a node relation
 * crosses model files - the topology of
 * `examples/charging-station-management` is split across three of them, so a
 * diagram of one file could not show it.
 *
 * A thin shell around the generators, which need no Eclipse and are therefore
 * checked without one by `OperationGraphTest`.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class GenerateOperationDiagramHandler extends AbstractHandler {
    static val OPERATION_EXTENSION = "operation"
    static val DIAGRAM_EXTENSION = "puml"
    static val TITLE = "LEMMA Operation Model Diagrams"

    static val TOPOLOGY_SUFFIX = "-topology"
    static val NODES_SUFFIX = "-nodes"

    override execute(ExecutionEvent event) throws ExecutionException {
        val shell = HandlerUtil.getActiveShell(event)
        val files = HandlerUtil.getCurrentStructuredSelection(event).toList
            .filter(IFile)
            .filter[OPERATION_EXTENSION == fileExtension]
            .toList

        if (files.empty) {
            MessageDialog.openInformation(shell, TITLE,
                '''Select one or more .«OPERATION_EXTENSION» files to generate diagrams from.''')
            return null
        }

        val renderer = new PlantUmlRenderer
        val written = <String>newLinkedList
        val images = <IFile>newLinkedList
        val failed = <String>newLinkedList

        try {
            val graph = new OperationModelReader().read(files.map[pathOf(it)].toList)
            graph.problems.forEach[failed.add(it)]

            // Written beside the first selected model: both diagrams cover the
            // selection as a whole and belong to no single one of them.
            write(files.head, TOPOLOGY_SUFFIX,
                new TopologyDiagramGenerator().generate(graph), renderer, written, images)
            write(files.head, NODES_SUFFIX,
                new NodeDetailDiagramGenerator().generate(graph), renderer, written, images)
        } catch (Exception exception) {
            failed.add(exception.message)
        }

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
     */
    private def IFile refresh(IFile sibling, String name) {
        val folder = sibling.parent
        folder.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor)
        return folder.getFile(new Path(name))
    }

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
