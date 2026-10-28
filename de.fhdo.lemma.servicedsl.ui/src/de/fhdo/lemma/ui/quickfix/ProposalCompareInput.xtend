package de.fhdo.lemma.ui.quickfix

import de.fhdo.lemma.servicedsl.smells.refactoring.ProposalApplier
import de.fhdo.lemma.servicedsl.smells.refactoring.RecordedProposal
import java.io.ByteArrayInputStream
import java.io.File
import java.io.InputStream
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import org.eclipse.compare.CompareConfiguration
import org.eclipse.compare.CompareEditorInput
import org.eclipse.compare.IStreamContentAccessor
import org.eclipse.compare.ITypedElement
import org.eclipse.compare.structuremergeviewer.DiffNode
import org.eclipse.compare.structuremergeviewer.Differencer
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.swt.graphics.Image

/**
 * Shows a proposal as a before-and-after comparison, file by file.
 *
 * Eclipse's own compare viewer, which this bundle already depends on, rather
 * than a wall of unified diff: 669 lines of patch is not something to read in
 * a text box, and a reviewer wants to see the files, not the diff format.
 *
 * The *after* side is produced by **applying the patch in a throwaway
 * worktree** rather than by interpreting the diff. git already knows how to
 * apply a patch; a second implementation of that would be a second thing to
 * get wrong, and a viewer that showed a subtly different result from what
 * applying would produce is worse than no viewer.
 *
 * Nothing here writes to the user's checkout. The worktree is made from the
 * commit the proposal was produced against and released when the dialog
 * closes.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ProposalCompareInput extends CompareEditorInput {
    val RecordedProposal proposal
    val String root
    var Path patched

    new(RecordedProposal proposal, String root) {
        super(new CompareConfiguration => [
            leftLabel = "Now"
            rightLabel = "With this proposal applied"
            leftEditable = false
            rightEditable = false
        ])
        this.proposal = proposal
        this.root = root
        title = '''Proposal: «proposal.cause ?: proposal.folder.fileName»'''.toString
    }

    override protected prepareInput(IProgressMonitor monitor) {
        monitor?.beginTask("Applying the proposal to a throwaway copy", 2)
        try {
            // Clear anything a previous review left registered before adding
            // another: disposal races with this method, which runs on another
            // thread, so a dialog closed early can leak the worktree it was
            // still creating.
            ProposalApplier.releaseStaleWorktrees(root)
            patched = ProposalApplier.patchedCopy(root, proposal.base, proposal.patch)
            if (patched === null) {
                // Said plainly rather than shown as an empty tree: an empty
                // comparison looks like "no changes", which is the opposite of
                // the truth.
                throw new RuntimeException(
                    "The proposal could not be applied to a copy of the checkout, so there "
                        + "is nothing to compare. Its base commit may not exist here.")
            }
            monitor?.worked(1)

            // CHANGE, not NO_CHANGE: the root describes the tree below it, and
            // a root claiming no change invites the viewer to report that the
            // sides are identical.
            val tree = new DiffNode(Differencer.CHANGE)
            val nodes = <DiffNode>newLinkedList
            for (path : proposal.changedPaths) {
                val before = new File(this.root, path)
                val after = patched.resolve(path).toFile
                nodes.add(new DiffNode(kindOf(before, after),
                    null, element(path, before), element(path, after)))
            }
            monitor?.worked(1)

            // A single-file proposal opens straight onto its diff. With a
            // parent node it would open on an empty content pane and wait to
            // be clicked, which is right for a tree of thirteen files and
            // pointless for one.
            if (nodes.size == 1) {
                return nodes.head
            }
            nodes.forEach[tree.add(it)]
            return tree
        } finally {
            monitor?.done
        }
    }

    /**
     * Whether the file is added, removed or changed, so the viewer's icons and
     * its summary line say the right thing.
     */
    private def int kindOf(File before, File after) {
        if (!before.exists) {
            return Differencer.CHANGE.bitwiseOr(Differencer.RIGHT)
        }
        if (!after.exists) {
            return Differencer.CHANGE.bitwiseOr(Differencer.LEFT)
        }
        return Differencer.CHANGE
    }

    private def ITypedElement element(String path, File file) {
        return new FileContents(path, file)
    }

    /**
     * Release the throwaway worktree.
     *
     * Called when the dialog closes. A leaked worktree would show up in the
     * user's own ``git worktree list`` long after, which is the kind of mess a
     * tool has no business leaving behind.
     */
    def synchronized void dispose() {
        val worktree = patched
        patched = null
        // Even when this ran before prepareInput recorded one, the sweep
        // catches it: release with null still prunes, and a worktree created
        // afterwards is removed when the next review begins.
        ProposalApplier.release(root, worktree)
    }

    /**
     * One side of one file, read as text.
     */
    private static class FileContents implements ITypedElement, IStreamContentAccessor {
        val String path
        val File file

        new(String path, File file) {
            this.path = path
            this.file = file
        }

        override String getName() { path }

        override Image getImage() { null }

        /**
         * The extension, so the viewer picks a syntax-aware compare for a
         * known type and plain text otherwise.
         */
        override String getType() {
            val dot = path.lastIndexOf(".")
            return if (dot > 0 && dot < path.length - 1) path.substring(dot + 1) else ITypedElement.TEXT_TYPE
        }

        override InputStream getContents() {
            if (!file.exists) {
                // A file one side does not have: an empty stream, so the
                // viewer shows it as wholly added or wholly removed.
                return new ByteArrayInputStream(newByteArrayOfSize(0))
            }
            return new ByteArrayInputStream(Files.readAllBytes(file.toPath))
        }

        override String toString() {
            return '''«path» («if (file.exists) file.length else 0» bytes)'''.toString
        }
    }

    /**
     * The charset files are read as. UTF-8, as the reconstruction writes them.
     */
    static def charset() {
        return StandardCharsets.UTF_8
    }
}
