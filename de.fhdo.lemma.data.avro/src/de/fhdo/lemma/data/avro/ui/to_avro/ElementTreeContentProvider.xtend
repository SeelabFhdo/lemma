package de.fhdo.lemma.data.avro.ui.to_avro

import org.eclipse.jface.viewers.ITreeContentProvider
import java.util.Comparator
import org.eclipse.emf.ecore.EObject

import static de.fhdo.lemma.data.avro.Util.*
import java.util.List
import de.fhdo.lemma.data.intermediate.IntermediateVersion
import de.fhdo.lemma.data.intermediate.IntermediateContext
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.utils.LemmaUtils

/**
 * Content provider for the model element selection tree in the LEMMA to Avro dialog.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ElementTreeContentProvider implements ITreeContentProvider {
    /**
     * Get root elements
     */
    override getElements(Object inputElement) {
        return (inputElement as List<? extends EObject>).sortByName
    }

    /**
     * Helper to sort a list of LEMMA EObjects by their simple, i.e., non fully-qualified, names
     */
    private def List<? extends EObject> sortByName(List<? extends EObject> eObjects) {
        return eObjects.sortWith(new Comparator<EObject>() {
            override compare(EObject o1, EObject o2) {
                val name1 = LemmaUtils.getSimpleName(qualifiedName(o1))
                val name2 = LemmaUtils.getSimpleName(qualifiedName(o2))
                return name1.compareTo(name2)
            }
        })
    }

    /**
     * Get children of parent element
     */
    override getChildren(Object parentElement) {
        return switch(parentElement) {
            IntermediateVersion: if (!parentElement.contexts.empty)
                    parentElement.contexts.sortByName
                else
                    parentElement.complexTypes.sortByName

            IntermediateContext: parentElement.complexTypes.sortByName
        }
    }

    /**
     * Get parent of an element
     */
    override getParent(Object element) {
        return switch(element) {
            IntermediateContext: element.version
            IntermediateComplexType: element.context ?: element.version
        }
    }

    /**
     * Determine if the given element has children
     */
    override hasChildren(Object element) {
        return switch(element) {
            IntermediateVersion: !element.contexts.empty || !element.complexTypes.empty
            IntermediateContext: !element.complexTypes.empty
            default: false
        }
    }
}