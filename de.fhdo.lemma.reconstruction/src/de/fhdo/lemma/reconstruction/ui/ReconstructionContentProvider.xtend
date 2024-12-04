package de.fhdo.lemma.reconstruction.ui

import de.fhdo.lemma.reconstruction.domain.Context
import de.fhdo.lemma.reconstruction.domain.DataStructure
import de.fhdo.lemma.reconstruction.domain.Field
import java.util.List
import org.eclipse.jface.viewers.ITreeContentProvider

/**
 * Content provider to display information from the architecture information, 
 * loaded form the MongoDb. 
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ReconstructionContentProvider implements ITreeContentProvider {

	/** 
	 * Get child information from reconstructed elements, e.g., context have
	 * data structures and child elements in the tree. 
	 */
	override getChildren(Object parentElement) {
        return switch (parentElement) {
        	Context: parentElement.dataStructures
        	DataStructure: parentElement.fields
        }
	}

	/**
	 * Handle input elements as a list
	 */
	override getElements(Object inputElement) {
		inputElement as List <?>
	}
	
	/**
	 * Get parents for reconstructed elements
	 */
	override getParent(Object element) {
		return switch(element) {
			Context: element.parent
            DataStructure: element.parent
            Field: element.parent
            default: null
        }
	}

	/**
	 * Check if elements have children
	 */
	override hasChildren(Object element) {
		switch (element) {
			Context: return !element.dataStructures.empty
			DataStructure: return !element.fields.empty
			default: false
		}
	}
}