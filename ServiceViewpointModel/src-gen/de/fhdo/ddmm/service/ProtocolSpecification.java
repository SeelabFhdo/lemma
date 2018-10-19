/**
 */
package de.fhdo.ddmm.service;

import de.fhdo.ddmm.technology.CommunicationType;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Protocol specification that combines a communication type with an imported protocol. Used to
 * specify, e.g., the default asynchronous and/or synchronous protocol of services, interfaces, and
 * operations.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.ProtocolSpecification#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.ProtocolSpecification#getProtocol <em>Protocol</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.ServicePackage#getProtocolSpecification()
 * @model
 * @generated
 */
public interface ProtocolSpecification extends EObject {
    /**
     * Returns the value of the '<em><b>Communication Type</b></em>' attribute.
     * The literals are from the enumeration {@link de.fhdo.ddmm.technology.CommunicationType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Communication Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Communication Type</em>' attribute.
     * @see de.fhdo.ddmm.technology.CommunicationType
     * @see #setCommunicationType(CommunicationType)
     * @see de.fhdo.ddmm.service.ServicePackage#getProtocolSpecification_CommunicationType()
     * @model unique="false"
     * @generated
     */
    CommunicationType getCommunicationType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.ProtocolSpecification#getCommunicationType <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Communication Type</em>' attribute.
     * @see de.fhdo.ddmm.technology.CommunicationType
     * @see #getCommunicationType()
     * @generated
     */
    void setCommunicationType(CommunicationType value);

    /**
     * Returns the value of the '<em><b>Protocol</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.ImportedProtocolAndDataFormat#getSpecification <em>Specification</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Protocol</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocol</em>' containment reference.
     * @see #setProtocol(ImportedProtocolAndDataFormat)
     * @see de.fhdo.ddmm.service.ServicePackage#getProtocolSpecification_Protocol()
     * @see de.fhdo.ddmm.service.ImportedProtocolAndDataFormat#getSpecification
     * @model opposite="specification" containment="true"
     * @generated
     */
    ImportedProtocolAndDataFormat getProtocol();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.ProtocolSpecification#getProtocol <em>Protocol</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Protocol</em>' containment reference.
     * @see #getProtocol()
     * @generated
     */
    void setProtocol(ImportedProtocolAndDataFormat value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Reusable helper method to determine effective protocol specifications from a list of
     * ProtocolSpecification instances as combinations of Protocol and DataFormat. In case a
     * ProtocolSpecification instance does not specify a data format, the effective protocol
     * specifications correspond to the ProtocolSpecification's Protocol being combined with all of
     * its DataFormats.
     * <!-- end-model-doc -->
     * @model dataType="de.fhdo.ddmm.service.TupleList" unique="false" specificationsUnique="false" specificationsMany="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if ((specifications == null))\n{\n\treturn null;\n}\nfinal &lt;%java.util.ArrayList%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt; results = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt;newArrayList();\nfinal &lt;%java.util.function.Consumer%&gt;&lt;&lt;%de.fhdo.ddmm.service.ProtocolSpecification%&gt;&gt; _function = new &lt;%java.util.function.Consumer%&gt;&lt;&lt;%de.fhdo.ddmm.service.ProtocolSpecification%&gt;&gt;()\n{\n\tpublic void accept(final &lt;%de.fhdo.ddmm.service.ProtocolSpecification%&gt; specification)\n\t{\n\t\tfinal &lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt; protocol = specification.getProtocol();\n\t\tfinal &lt;%de.fhdo.ddmm.technology.Protocol%&gt; importedProtocol = protocol.getImportedProtocol();\n\t\t&lt;%de.fhdo.ddmm.technology.DataFormat%&gt; _dataFormat = protocol.getDataFormat();\n\t\tboolean _tripleNotEquals = (_dataFormat != null);\n\t\tif (_tripleNotEquals)\n\t\t{\n\t\t\tfinal &lt;%java.util.HashMap%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt; entry = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;newHashMap();\n\t\t\tentry.put(\"protocol\", importedProtocol);\n\t\t\tentry.put(\"dataFormat\", protocol.getDataFormat());\n\t\t\tentry.put(\"import\", protocol.getImport());\n\t\t\tresults.add(entry);\n\t\t}\n\t\telse\n\t\t{\n\t\t\tfinal &lt;%java.util.function.Consumer%&gt;&lt;&lt;%de.fhdo.ddmm.technology.DataFormat%&gt;&gt; _function = new &lt;%java.util.function.Consumer%&gt;&lt;&lt;%de.fhdo.ddmm.technology.DataFormat%&gt;&gt;()\n\t\t\t{\n\t\t\t\tpublic void accept(final &lt;%de.fhdo.ddmm.technology.DataFormat%&gt; dataFormat)\n\t\t\t\t{\n\t\t\t\t\tfinal &lt;%java.util.HashMap%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt; entry = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;newHashMap();\n\t\t\t\t\tentry.put(\"protocol\", importedProtocol);\n\t\t\t\t\tentry.put(\"dataFormat\", dataFormat);\n\t\t\t\t\tentry.put(\"import\", protocol.getImport());\n\t\t\t\t\tresults.add(entry);\n\t\t\t\t}\n\t\t\t};\n\t\t\timportedProtocol.getDataFormats().forEach(_function);\n\t\t}\n\t}\n};\nspecifications.forEach(_function);\nreturn results;'"
     * @generated
     */
    List<Map<String, Object>> effectiveProtocolSpecifications(EList<ProtocolSpecification> specifications);

} // ProtocolSpecification
