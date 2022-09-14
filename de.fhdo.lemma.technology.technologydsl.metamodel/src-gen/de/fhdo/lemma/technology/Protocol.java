/**
 */
package de.fhdo.lemma.technology;

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
 *   <li>{@link de.fhdo.lemma.technology.Protocol#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.Protocol#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.Protocol#isDefault <em>Default</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.Protocol#getDefaultFormat <em>Default Format</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.Protocol#getDataFormats <em>Data Formats</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.Protocol#getTechnology <em>Technology</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.TechnologyPackage#getProtocol()
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
     * @see de.fhdo.lemma.technology.TechnologyPackage#getProtocol_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.Protocol#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Communication Type</b></em>' attribute.
     * The literals are from the enumeration {@link de.fhdo.lemma.technology.CommunicationType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Communication Type</em>' attribute.
     * @see de.fhdo.lemma.technology.CommunicationType
     * @see #setCommunicationType(CommunicationType)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getProtocol_CommunicationType()
     * @model unique="false"
     * @generated
     */
    CommunicationType getCommunicationType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.Protocol#getCommunicationType <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Communication Type</em>' attribute.
     * @see de.fhdo.lemma.technology.CommunicationType
     * @see #getCommunicationType()
     * @generated
     */
    void setCommunicationType(CommunicationType value);

    /**
     * Returns the value of the '<em><b>Default</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default</em>' attribute.
     * @see #setDefault(boolean)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getProtocol_Default()
     * @model default="false" unique="false"
     * @generated
     */
    boolean isDefault();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.Protocol#isDefault <em>Default</em>}' attribute.
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
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Format</em>' reference.
     * @see #setDefaultFormat(DataFormat)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getProtocol_DefaultFormat()
     * @model
     * @generated
     */
    DataFormat getDefaultFormat();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.Protocol#getDefaultFormat <em>Default Format</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Format</em>' reference.
     * @see #getDefaultFormat()
     * @generated
     */
    void setDefaultFormat(DataFormat value);

    /**
     * Returns the value of the '<em><b>Data Formats</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.technology.DataFormat}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.DataFormat#getProtocol <em>Protocol</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Formats</em>' containment reference list.
     * @see de.fhdo.lemma.technology.TechnologyPackage#getProtocol_DataFormats()
     * @see de.fhdo.lemma.technology.DataFormat#getProtocol
     * @model opposite="protocol" containment="true" required="true"
     * @generated
     */
    EList<DataFormat> getDataFormats();

    /**
     * Returns the value of the '<em><b>Technology</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.Technology#getProtocols <em>Protocols</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technology</em>' container reference.
     * @see #setTechnology(Technology)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getProtocol_Technology()
     * @see de.fhdo.lemma.technology.Technology#getProtocols
     * @model opposite="protocols" transient="false"
     * @generated
     */
    Technology getTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.Protocol#getTechnology <em>Technology</em>}' container reference.
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
     * @generated
     */
    EList<String> getQualifiedNameParts();

} // Protocol
