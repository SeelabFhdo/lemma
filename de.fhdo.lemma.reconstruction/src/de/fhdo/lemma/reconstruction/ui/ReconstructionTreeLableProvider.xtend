package de.fhdo.lemma.reconstruction.ui

import org.eclipse.jface.viewers.LabelProvider
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider
import org.eclipse.jface.resource.ResourceManager
import org.eclipse.jface.resource.LocalResourceManager
import org.eclipse.jface.resource.JFaceResources
import org.eclipse.swt.graphics.Image
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils
import org.eclipse.jface.viewers.StyledString
import de.fhdo.lemma.reconstruction.domain.Context
import de.fhdo.lemma.reconstruction.domain.DataStructure
import de.fhdo.lemma.reconstruction.domain.Field
import de.fhdo.lemma.reconstruction.service.Microservice
import de.fhdo.lemma.reconstruction.service.Interface
import de.fhdo.lemma.reconstruction.service.Operation

class ReconstructionTreeLableProvider  extends LabelProvider implements IStyledLabelProvider {
	static val ResourceManager RESOURCE_MANAGER
        = new LocalResourceManager(JFaceResources.getResources())

 	/**
     * Icon for Avro protocols
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
    	val data = element
        return new StyledString(switch(element) {
            Context: element.qualifiedName
            DataStructure: element.name
            Field: element.name
            Microservice: element.name
            Interface: element.name
            Operation: element.name
            default: "default"
        })
    }
}