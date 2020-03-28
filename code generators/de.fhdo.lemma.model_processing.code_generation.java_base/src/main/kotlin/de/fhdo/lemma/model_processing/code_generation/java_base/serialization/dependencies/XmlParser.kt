package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies

import org.redundent.kotlin.xml.Node
import org.redundent.kotlin.xml.XmlVersion
import org.redundent.kotlin.xml.node
import org.redundent.kotlin.xml.xml
import java.io.FileReader
import java.util.ArrayDeque
import javax.xml.stream.XMLInputFactory
import javax.xml.stream.XMLStreamReader

/**
 * Helper class to parse an XML document into a [Node] as expected by kotlin-xml-builder, which does not support parsing
 * but only building XML documents from scratch and in-memory. The parsing is realized with StAX.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class XmlParser {
    companion object {
        /**
         * Start parsing the XML file in the specified [xmlFilePath]
         */
        fun parse(xmlFilePath : String) : Node? {
            val reader = XMLInputFactory.newInstance().createXMLStreamReader(FileReader(xmlFilePath))
            val parser = XmlParser()
            return parser.parse(reader)
        }
    }

    private lateinit var reader: XMLStreamReader
    private var resultRootNode: Node? = null
    private var rootElementVisited = false
    private val nodeStack = ArrayDeque<Node>()
    private var currentNode: Node? = null

    /**
     * Do the actual parsing
     */
    private fun parse(reader: XMLStreamReader) : Node? {
        this.reader = reader
        while (reader.hasNext()) {
            when(reader.next()) {
                XMLStreamReader.START_ELEMENT -> startElement()
                XMLStreamReader.END_ELEMENT -> endElement()
                XMLStreamReader.CHARACTERS -> characters()
            }
        }

        return resultRootNode
    }

    /**
     * StAX callback for the start of an XML element
     */
    private fun startElement() {
        /* Build initialization function for newly created Node instances */
        val nodeInit : (Node) -> Unit = {
            // Add namespace attributes to node
            for (i in 0 until reader.namespaceCount) {
                val namespacePrefix = reader.getNamespacePrefix(i) ?: ""
                val namespaceAttributeName = "xmlns" + if (namespacePrefix.isNotEmpty()) ":$namespacePrefix" else ""
                it.attribute(namespaceAttributeName, reader.getNamespaceURI(i))
            }

            // Add attributes to nodes
            for (i in 0 until reader.attributeCount) {
                val attributePrefix = reader.getAttributePrefix(0)
                val attributeLocalName = reader.getAttributeLocalName(i)
                val attributeName = (if (attributePrefix != null) "$attributePrefix:" else "") + attributeLocalName
                it.attribute(attributeName, reader.getAttributeValue(i))
            }
        }

        /* Create a new Node instance for the element */
        currentNode = if (!rootElementVisited) {
            rootElementVisited = true
            val xmlVersion = if (reader.version == "1.0") XmlVersion.V10 else XmlVersion.V11
            resultRootNode = xml(reader.localName, reader.encoding, xmlVersion, nodeInit)
            resultRootNode!!
        } else {
            val newNode = node(reader.localName, nodeInit)
            nodeStack.first.addNode(newNode)
            newNode
        }

        /* The node stack keeps track of all created nodes in their order of creation */
        nodeStack.addFirst(currentNode)
    }

    /**
     * StAX callback characters. It is used here to capture plain text between XML start and elements, such as "foo" in
     * <bar>foo</bar>.
     */
    private fun characters() {
        // In case the current node is empty, we're outside an XML element
        currentNode?.text(reader.text)
    }

    /**
     * StAX callback for the end of an XML element
     */
    private fun endElement() {
        // Remove current node from stack
        nodeStack.removeFirst()

        // Set current node to the previously created XML element, i.e., the element that contains the current node
        currentNode = nodeStack.peekFirst()
    }
}