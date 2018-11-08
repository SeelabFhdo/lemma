/**
 */
package de.fhdo.ddmm.technology;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents a data exchange protocol for microservice communications, e.g., AMQP
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.Protocol#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.Protocol#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.Protocol#isDefault <em>Default</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.Protocol#getDefaultFormat <em>Default Format</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.Protocol#getDataFormats <em>Data Formats</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.Protocol#getTechnology <em>Technology</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.TechnologyPackage#getProtocol()
 * @model
 * @generated
 */
public interface Protocol extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) The default format must be one of the data formats assigned to the protocol.
     *          Ensured by: DSL scope provider.
     *     (C2) Name must be unique.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getProtocol_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.Protocol#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

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
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getProtocol_CommunicationType()
     * @model unique="false"
     * @generated
     */
    CommunicationType getCommunicationType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.Protocol#getCommunicationType <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Communication Type</em>' attribute.
     * @see de.fhdo.ddmm.technology.CommunicationType
     * @see #getCommunicationType()
     * @generated
     */
    void setCommunicationType(CommunicationType value);

    /**
     * Returns the value of the '<em><b>Default</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default</em>' attribute.
     * @see #setDefault(boolean)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getProtocol_Default()
     * @model default="false" unique="false"
     * @generated
     */
    boolean isDefault();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.Protocol#isDefault <em>Default</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default</em>' attribute.
     * @see #isDefault()
     * @generated
     */
    void setDefault(boolean value);

    /**
     * Returns the value of the '<em><b>Default Format</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Format</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Format</em>' reference.
     * @see #setDefaultFormat(DataFormat)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getProtocol_DefaultFormat()
     * @model
     * @generated
     */
    DataFormat getDefaultFormat();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.Protocol#getDefaultFormat <em>Default Format</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Format</em>' reference.
     * @see #getDefaultFormat()
     * @generated
     */
    void setDefaultFormat(DataFormat value);

    /**
     * Returns the value of the '<em><b>Data Formats</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.DataFormat}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.DataFormat#getProtocol <em>Protocol</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Formats</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Formats</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getProtocol_DataFormats()
     * @see de.fhdo.ddmm.technology.DataFormat#getProtocol
     * @model opposite="protocol" containment="true" required="true"
     * @generated
     */
    EList<DataFormat> getDataFormats();

    /**
     * Returns the value of the '<em><b>Technology</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.Technology#getProtocols <em>Protocols</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Technology</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technology</em>' container reference.
     * @see #setTechnology(Technology)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getProtocol_Technology()
     * @see de.fhdo.ddmm.technology.Technology#getProtocols
     * @model opposite="protocols" transient="false"
     * @generated
     */
    Technology getTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.Protocol#getTechnology <em>Technology</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Technology</em>' container reference.
     * @see #getTechnology()
     * @generated
     */
    void setTechnology(Technology value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get parts of the protocol for creating a qualified name
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; _xblockexpression = null;\n{\n\tif (((this.getName() == null) || this.getName().isEmpty()))\n\t{\n\t\treturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(&lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;newArrayList());\n\t}\n\tfinal &lt;%java.util.ArrayList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; nameParts = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;newArrayList();\n\tnameParts.add(\"protocols\");\n\tnameParts.add(this.getName());\n\t_xblockexpression = &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(nameParts);\n}\nreturn _xblockexpression;'"
     * @generated
     */
    EList<String> getQualifiedNameParts();

} // Protocol
