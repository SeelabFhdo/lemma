package de.fhdo.lemma.data.avro.ui.to_lemma

import org.eclipse.jface.viewers.LabelProvider
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider

import org.eclipse.jface.viewers.StyledString
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils
import org.eclipse.jface.resource.ResourceManager
import org.eclipse.jface.resource.LocalResourceManager
import org.eclipse.jface.resource.JFaceResources
import org.eclipse.swt.graphics.Image
import de.fhdo.lemma.data.avro.ui.to_lemma.AvroToLemmaDialog.AvroNamespace
import de.fhdo.lemma.data.avro.ui.to_lemma.AvroToLemmaDialog.AvroSchemaWithNamespace
import de.fhdo.lemma.data.avro.ui.to_lemma.AvroToLemmaDialog.AvroProtocol

/**
 * Provider of styled labels for the tree viewer in the Avro-to-LEMMA conversion dialog.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class SchemaTreeLabelProvider extends LabelProvider implements IStyledLabelProvider {
    static val ResourceManager RESOURCE_MANAGER
        = new LocalResourceManager(JFaceResources.getResources())

    /**
     * Icon for Avro protocols
     */
    public static val Image PROTOCOL_ICON = LemmaUiUtils.createImage(
            RESOURCE_MANAGER,
            SchemaTreeLabelProvider,
            "protocol.gif"
        )

    /**
     * Icon for Avro namespaces
     */
    public static val Image NAMESPACE_ICON = LemmaUiUtils.createImage(
            RESOURCE_MANAGER,
            SchemaTreeLabelProvider,
            "namespace.gif"
        )

    /**
     * Icon for Avro schemas
     */
    public static val Image SCHEMA_ICON = LemmaUiUtils.createImage(
            RESOURCE_MANAGER,
            SchemaTreeLabelProvider,
            "schema.gif"
        )

    /**
     * Get styled text for element
     */
    override getStyledText(Object element) {
        return new StyledString(switch(element) {
            AvroProtocol: element.protocol.name
            AvroNamespace: if (element.namespace !== null) element.namespace else "No namespace"
            AvroSchemaWithNamespace: element.schema.name
        })
    }

    /**
     * Get image for element
     */
    override getImage(Object element) {
        return switch(element) {
            AvroProtocol: PROTOCOL_ICON
            AvroNamespace: NAMESPACE_ICON
            AvroSchemaWithNamespace: SCHEMA_ICON
        }
    }
}