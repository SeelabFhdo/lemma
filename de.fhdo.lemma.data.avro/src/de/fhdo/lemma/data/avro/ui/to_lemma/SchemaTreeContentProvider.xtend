package de.fhdo.lemma.data.avro.ui.to_lemma

import org.eclipse.jface.viewers.ITreeContentProvider
import java.util.Comparator

import java.util.List
import de.fhdo.lemma.data.avro.ui.to_lemma.AvroToLemmaDialog.AvroProtocol
import de.fhdo.lemma.data.avro.ui.to_lemma.AvroToLemmaDialog.AvroNamespace
import de.fhdo.lemma.data.avro.ui.to_lemma.AvroToLemmaDialog.AvroSchemaWithNamespace

/**
 * Content provider for the tree viewer in the Avro-to-LEMMA conversion dialog.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class SchemaTreeContentProvider implements ITreeContentProvider {
    /**
     * Get root elements
     */
    override getElements(Object inputElement) {
        return (inputElement as List<?>).sortByName
    }

    /**
     * Helper to sort Avro protocols, namespaces, and schemas in the form of elements as expected by
     * the tree viewer by their names
     */
    private def List<?> sortByName(List<?> elements) {
        return elements.sortWith(new Comparator<Object>() {
            override compare(Object o1, Object o2) {
                val s1 = o1.sortableString
                val s2 = o2.sortableString
                return if (s1 === null && s2 === null)
                        0
                    else if (s1 === null)
                        1
                     else if (s2 === null)
                        -1
                    else
                        s1.compareTo(s2)
            }
        })
    }

    /**
     * Get sortable string from Avro protocols, namespaces, and schemas
     */
    private def String sortableString(Object o) {
        return switch(o) {
            AvroProtocol: o.protocol.name
            AvroNamespace: o.namespace
            AvroSchemaWithNamespace: o.schema.name
        }
    }

    /**
     * Get children of parent element
     */
    override getChildren(Object parentElement) {
        return switch(parentElement) {
            AvroProtocol: parentElement.children
            AvroNamespace: parentElement.children
            AvroSchemaWithNamespace: parentElement.children
            default: emptyList
        }
    }

    /**
     * Get parent of an element
     */
    override getParent(Object element) {
        return switch(element) {
            AvroNamespace: element.parent
            AvroSchemaWithNamespace: element.parent
            default: null
        }
    }

    /**
     * Determine if the given element has children
     */
    override hasChildren(Object element) {
        return !element.children.empty
    }
}