package de.fhdo.lemma.servicedsl.smells

import de.fhdo.lemma.servicedsl.diagram.ServiceModelReader
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.Path
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.handlers.HandlerUtil
import org.eclipse.ui.ide.IDE

/**
 * Detect security smells in the selected service models, and report them.
 *
 * Writes a report beside the first selected model and opens it. A report
 * rather than a marker in the editor: a finding is about a *pair* of
 * microservices declared in two files, so there is no one line to put a marker
 * on - and the evidence is worth more than a squiggle.
 *
 * A thin shell around [[NonSecuredCommunicationDetector]], which needs no
 * Eclipse and is therefore checked without one.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class DetectSmellsHandler extends AbstractHandler {
    static val SERVICES_EXTENSION = "services"
    static val REPORT_SUFFIX = "-smells"
    static val REPORT_EXTENSION = "md"
    static val TITLE = "LEMMA Security Smells"

    override execute(ExecutionEvent event) throws ExecutionException {
        val shell = HandlerUtil.getActiveShell(event)
        val files = HandlerUtil.getCurrentStructuredSelection(event).toList
            .filter(IFile)
            .filter[SERVICES_EXTENSION == fileExtension]
            .toList

        if (files.empty) {
            MessageDialog.openInformation(shell, TITLE,
                '''Select one or more .«SERVICES_EXTENSION» files to detect smells in.''')
            return null
        }

        try {
            // Every selected model and everything they import: a finding is
            // about two services, and the second may be in a model that was
            // not selected.
            val graph = new ServiceModelReader().read(
                files.map[java.nio.file.Path.of(location.toFile.absolutePath)].toList)
            val result = new NonSecuredCommunicationDetector().detect(graph)

            val report = new SmellReport().write(result, graph)
            val target = java.nio.file.Path.of(files.head.location.toFile.parent,
                '''«baseName(files.head.name)»«REPORT_SUFFIX».«REPORT_EXTENSION»'''.toString)
            Files.write(target, report.getBytes(StandardCharsets.UTF_8))

            val written = refresh(files.head, target.fileName.toString)
            written.open
            report(shell, result, target.fileName.toString)
        } catch (Exception exception) {
            MessageDialog.openError(shell, TITLE,
                '''Nothing was detected: «exception.message»''')
        }
        return null
    }

    private def IFile refresh(IFile sibling, String name) {
        val folder = sibling.parent
        folder.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor)
        return folder.getFile(new Path(name))
    }

    private def void open(IFile file) {
        try {
            val page = PlatformUI.workbench?.activeWorkbenchWindow?.activePage
            if (page !== null) {
                IDE.openEditor(page, file)
            }
        } catch (Exception exception) {
            // No editor for the format, or the workbench is going down: the
            // report is written either way and the message names it.
        }
    }

    private def String baseName(String fileName) {
        val separator = fileName.lastIndexOf(".")
        return if (separator > 0) fileName.substring(0, separator) else fileName
    }

    /**
     * Say what was found, in the counts that matter.
     *
     * The undecided count is shown beside the findings rather than hidden: a
     * reader has to be able to tell a system that does not smell from one
     * whose facts were not reconstructed.
     */
    private def void report(
        org.eclipse.swt.widgets.Shell shell, DetectionResult result, String file) {
        val summary = '''
            «result.findings.size» finding(s) of «NonSecuredCommunicationDetector.SMELL».

            «result.secured.size» channel(s) judged protected.
            «result.undecided.size» channel(s) could not be judged from the facts in the models.

            Written to «file».
        '''.toString

        if (result.findings.empty && result.undecided.empty) {
            MessageDialog.openInformation(shell, TITLE, summary)
        } else {
            MessageDialog.openWarning(shell, TITLE, summary)
        }
    }
}
