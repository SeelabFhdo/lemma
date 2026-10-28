package de.fhdo.lemma.reconstruction.ui

import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils
import de.fhdo.lemma.reconstruction.domain.Context
import de.fhdo.lemma.reconstruction.domain.DataStructure
import de.fhdo.lemma.reconstruction.domain.Field
import org.eclipse.jface.resource.JFaceResources
import org.eclipse.jface.resource.LocalResourceManager
import org.eclipse.jface.resource.ResourceManager
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider
import org.eclipse.jface.viewers.LabelProvider
import org.eclipse.jface.viewers.StyledString
import org.eclipse.swt.graphics.Image
import de.fhdo.lemma.reconstruction.service.Microservice
import de.fhdo.lemma.reconstruction.service.Interface
import de.fhdo.lemma.reconstruction.service.Operation
import de.fhdo.lemma.reconstruction.operation.OperationNode
import de.fhdo.lemma.reconstruction.operation.DeployedService

/**
 * User Interface class for displaying lables for the ReconstructionTreeProvider
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ReconstructionTreeLableProvider  extends LabelProvider implements IStyledLabelProvider {
	static val ResourceManager RESOURCE_MANAGER
        = new LocalResourceManager(JFaceResources.getResources())

 	/**
     * Icon for reconstruction part
     */
    public static val Image CONTEXT_ICON = LemmaUiUtils.createImage(
            RESOURCE_MANAGER,
            ReconstructionTreeLableProvider,
            "protocol.gif"
        )

	/**
     * Get styled text for element
     */
    override getStyledText(Object element) {
        val text = new StyledString(switch(element) {
            Context: element.qualifiedName
            DataStructure: element.name
            Field: element.name
            Microservice: element.name
            Interface: element.name
            Operation: element.name
            OperationNode: element.name
            DeployedService: element.name
            default: "default"
        })

        val detail = element.describe
        if (!detail.nullOrEmpty) {
            text.append('''  «detail»''', StyledString.QUALIFIER_STYLER)
        }
        return text
    }

    /**
     * Describe what an element holds, appended to its name in a quieter style.
     *
     * Two elements of the same name are otherwise indistinguishable in the
     * tree, which matters because the reconstruction of a system can be
     * stored next to an earlier and narrower one of the same system. What
     * tells them apart is their content.
     */
    private def dispatch String describe(Object element) {
        return null
    }

    private def dispatch String describe(Context context) {
        val parts = newLinkedList
        parts.add(context.dataStructures.size.count("structure", "structures"))
        if (!context.collections.empty) {
            parts.add(context.collections.size.count("collection", "collections"))
        }
        if (!context.enums.empty) {
            parts.add(context.enums.size.count("enumeration", "enumerations"))
        }
        return parts.join(", ")
    }

    private def dispatch String describe(Microservice microservice) {
        return microservice.interfaces.size.count("interface", "interfaces")
    }

    private def dispatch String describe(Interface ^interface) {
        return ^interface.operations.size.count("operation", "operations")
    }

    private def dispatch String describe(OperationNode node) {
        val environment = node.operationEnvironment
        val deployed = node.deployedServices.map[name]
        if (deployed.empty) {
            return if (environment.nullOrEmpty) null else environment
        }
        val deploys = '''deploys «deployed.join(", ")»'''
        return if (environment.nullOrEmpty)
                deploys.toString
            else
                '''«deploys» · «environment»'''.toString
    }

    private def String count(int amount, String singular, String plural) {
        return '''«amount» «IF amount == 1»«singular»«ELSE»«plural»«ENDIF»'''.toString
    }
}
