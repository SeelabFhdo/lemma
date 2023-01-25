package de.fhdo.lemma.ui.quickfix

import org.eclipse.jface.viewers.ITreeContentProvider
import java.util.List

class SecuritySmellContextProvider implements ITreeContentProvider {
	List<String> options = newLinkedList
	
	override getChildren(Object parentElement) {
		return switch (parentElement) {
			String: parentElement.children
		}
	}
	
	override getElements(Object inputElement) {
		return options
	}
	
	override getParent(Object element) {
		return switch (element) {
			String: element.parent
			default: null
		}
	}
	
	override hasChildren(Object element) {
		return false
	}
	
	def setOption(List<String> list) {
		this.option = list
	}
	
}