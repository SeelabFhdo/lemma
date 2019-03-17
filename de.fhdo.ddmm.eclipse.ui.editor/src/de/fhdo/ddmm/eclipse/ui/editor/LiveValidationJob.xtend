package de.fhdo.ddmm.eclipse.ui.editor

import org.eclipse.xtext.util.concurrent.IReadAccess
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.ui.editor.validation.ValidationJob
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import java.util.Collections
import org.eclipse.xtext.validation.Issue
import java.util.List
import de.fhdo.ddmm.eclipse.ui.editor.server.ServerConnection
import de.fhdo.lemma.utils.LemmaUtils

/**
 * Custom Xtext validation job for Live Validation. It connects to a Live Validation server and
 * triggers the actual validations.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class LiveValidationJob extends ValidationJob {
    ServerConnection liveValidationServerConnection

    /**
     * Constructor
     */
    new(IResourceValidator xtextResourceChecker, IReadAccess<XtextResource> xtextDocument,
        IValidationIssueProcessor validationIssueProcessor, CheckMode checkMode,
        ServerConnection liveValidationServerConnection) {
        super(xtextResourceChecker, xtextDocument, validationIssueProcessor, checkMode)
        this.liveValidationServerConnection = liveValidationServerConnection
    }

    /**
     * Callback for issue creation during the job's processing
     */
    override createIssues(IProgressMonitor monitor) {
        val issues = super.createIssues(monitor)
        if (!liveValidationServerConnection.connected)
            return issues

        // Prepare worker to trigger validations
        val getLiveValidationIssues = new CancelableUnitOfWork<List<Issue>, XtextResource>() {
            override exec(XtextResource resource, CancelIndicator outerIndicator) {
                if (resource === null || resource.isValidationDisabled())
                    return Collections.emptyList()

                val resourceFile = LemmaUtils.getFileForResource(resource)
                if (resourceFile === null)
                    return Collections.emptyList()

                // Prepare and send a PerformValidation request to the connected Live Validation
                // server. Note that the call to ServerConnection.validate() is blocking and relies
                // in the server implementation to timeout at some point, if validators don't send
                // validations results on time. Moreover, the publishIssues()-callback in
                // ServerConnection.LiveValidationClient is actually responsible for adding the
                // received validation results as Xtext issues to the correct Live Validation editor
                // instance in the workbench.
                val documentUri = resourceFile.locationURI.toString
                val sourceCode = NodeModelUtils.getNode(resource.contents.get(0)).text
                liveValidationServerConnection.validate(documentUri, sourceCode)
                return Collections.emptyList()
            }
        }

        // Run worker
        xtextDocument.readOnly(getLiveValidationIssues)

        return issues
    }
}