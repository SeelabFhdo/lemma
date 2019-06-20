package de.fhdo.ddmm.eclipse.ui.file_container_selection_dialog

import org.eclipse.jface.viewers.ITreeContentProvider
import org.eclipse.core.resources.IWorkspace
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IResource
import de.fhdo.ddmm.eclipse.ui.utils.DdmmUiUtils
import org.eclipse.core.resources.IFile
import org.eclipse.emf.ecore.EObject

/**
 * Content provider for the tree in file container selection dialog.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class FileContainerSelectionTreeContentProvider implements ITreeContentProvider {
    Class<? extends EObject> intermediateModelClass

    /**
     * Constructor
     */
    new(Class<? extends EObject> intermediateModelClass) {
        this.intermediateModelClass = intermediateModelClass
    }

    /**
     * Get children of parent element
     */
    override getChildren(Object parentElement) {
        if (parentElement instanceof IWorkspace)
            return parentElement.root.projects
        else if (parentElement instanceof IContainer && (parentElement as IContainer).accessible) {
            val container = parentElement as IContainer
            val children = container.members.filter[type != IResource.FILE].toList

            // Filter for XMI files that are instances of the given intermediate model class
            val applicableXmiFiles = if (intermediateModelClass !== null)
                    container.members.filter[
                        if (type !== IResource.FILE || fileExtension != "xmi")
                            return false

                        val xmiResource = DdmmUiUtils.loadXmiResource(it as IFile)
                        if (xmiResource.contents.empty)
                            return false

                        val root = xmiResource.contents.get(0)
                        return intermediateModelClass.isAssignableFrom(root.class)
                    ]
                else
                    emptyList

            children.addAll(applicableXmiFiles)
            return children
        }

        return newArrayOfSize(0)
    }

    /**
     * Get root elements
     */
    override getElements(Object inputElement) {
        return getChildren(inputElement)
    }

    /**
     * Get parent of an element
     */
    override getParent(Object element) {
        return if (element instanceof IResource)
                element.parent
            else
                null
    }

    /**
     * Determine if the given element has children
     */
    override hasChildren(Object element) {
        return !getChildren(element).empty
    }

}