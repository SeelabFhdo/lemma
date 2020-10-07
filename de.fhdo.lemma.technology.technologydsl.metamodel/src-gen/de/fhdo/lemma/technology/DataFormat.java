/**
 */
package de.fhdo.lemma.technology;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Format</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Protocol-specific data format, e.g., XML for AMQP
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.DataFormat#getFormatName <em>Format Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.DataFormat#getProtocol <em>Protocol</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.TechnologyPackage#getDataFormat()
 * @model
 * @generated
 */
public interface DataFormat extends EObject {
    /**
     * Returns the value of the '<em><b>Format Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Name must be unique within a protocol.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Format Name</em>' attribute.
     * @see #setFormatName(String)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getDataFormat_FormatName()
     * @model unique="false"
     * @generated
     */
    String getFormatName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.DataFormat#getFormatName <em>Format Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Format Name</em>' attribute.
     * @see #getFormatName()
     * @generated
     */
    void setFormatName(String value);

    /**
     * Returns the value of the '<em><b>Protocol</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.Protocol#getDataFormats <em>Data Formats</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocol</em>' container reference.
     * @see #setProtocol(Protocol)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getDataFormat_Protocol()
     * @see de.fhdo.lemma.technology.Protocol#getDataFormats
     * @model opposite="dataFormats" transient="false"
     * @generated
     */
    Protocol getProtocol();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.DataFormat#getProtocol <em>Protocol</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Protocol</em>' container reference.
     * @see #getProtocol()
     * @generated
     */
    void setProtocol(Protocol value);

} // DataFormat
