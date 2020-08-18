package de.fhdo.lemma.data.avro.ui.to_avro

import org.eclipse.ui.model.BaseWorkbenchContentProvider
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IContainer

/**
 * Workbench provider for Eclipse projects
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ProjectWorkbenchContentProvider extends BaseWorkbenchContentProvider {
    var IProject project

    /**
     * Constructor
     */
    new(IProject project) {
        this.project = project
    }

    /**
     * Get project elements from workbench
     */
    override getElements(Object inputElement) {
        val elements = super.getElements(inputElement)
        return #[elements.findFirst[it instanceof IProject && (it as IProject) == project]]
    }

    /**
     * Get IContainer children of a parent workbench element
     */
    override getChildren(Object parentElement) {
        val children = super.getChildren(parentElement)
        return children.filter[it instanceof IContainer]
    }
}