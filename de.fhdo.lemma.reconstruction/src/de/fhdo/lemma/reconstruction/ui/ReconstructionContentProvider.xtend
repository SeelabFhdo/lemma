package de.fhdo.lemma.reconstruction.ui

import org.eclipse.jface.viewers.ITreeContentProvider
import java.util.List
import de.fhdo.lemma.reconstruction.domain.Context
import de.fhdo.lemma.reconstruction.domain.DataStructure
import de.fhdo.lemma.reconstruction.domain.Field
import de.fhdo.lemma.reconstruction.service.Microservice
import de.fhdo.lemma.reconstruction.service.Interface
import de.fhdo.lemma.reconstruction.service.Operation

class ReconstructionContentProvider implements ITreeContentProvider {
	
	override getChildren(Object parentElement) {
        return switch (parentElement) {
        	Context: parentElement.dataStructures
        	DataStructure: parentElement.fields
        	Microservice: parentElement.interfaces
        	Interface: parentElement.operations
        }    
	}
	
	override getElements(Object inputElement) {
		inputElement as List <?>
	}
	
	override getParent(Object element) {
		return switch(element) {
			Context: element.parent
            DataStructure: element.parent
            Field: element.parent
            Microservice: element.parent
            Interface: element.parent
            Operation: element.parent
            default: null
        }
	}
	
	override hasChildren(Object element) {
		switch (element) {
			Context: return !element.dataStructures.empty
			DataStructure: return !element.fields.empty
			Microservice: return !element.interfaces.empty
			Interface: return !element.operations.empty
			default: false
		}
	}
	
}