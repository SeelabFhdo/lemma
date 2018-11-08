/**
 */
package de.fhdo.ddmm.technology.mapping;

import de.fhdo.ddmm.technology.CommunicationType;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Technology Specific Protocol Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Metamodel concept which represents a technology-specific protocol specification
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocolSpecification#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocolSpecification#getTechnologySpecificProtocol <em>Technology Specific Protocol</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologySpecificProtocolSpecification()
 * @model
 * @generated
 */
public interface TechnologySpecificProtocolSpecification extends EObject {
    /**
     * Returns the value of the '<em><b>Communication Type</b></em>' attribute.
     * The literals are from the enumeration {@link de.fhdo.ddmm.technology.CommunicationType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Only one protocol per communication type may be mapped.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Communication Type</em>' attribute.
     * @see de.fhdo.ddmm.technology.CommunicationType
     * @see #setCommunicationType(CommunicationType)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologySpecificProtocolSpecification_CommunicationType()
     * @model unique="false"
     * @generated
     */
    CommunicationType getCommunicationType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocolSpecification#getCommunicationType <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Communication Type</em>' attribute.
     * @see de.fhdo.ddmm.technology.CommunicationType
     * @see #getCommunicationType()
     * @generated
     */
    void setCommunicationType(CommunicationType value);

    /**
     * Returns the value of the '<em><b>Technology Specific Protocol</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocol#getProtocolSpecification <em>Protocol Specification</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Technology Specific Protocol</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technology Specific Protocol</em>' containment reference.
     * @see #setTechnologySpecificProtocol(TechnologySpecificProtocol)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologySpecificProtocolSpecification_TechnologySpecificProtocol()
     * @see de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocol#getProtocolSpecification
     * @model opposite="protocolSpecification" containment="true"
     * @generated
     */
    TechnologySpecificProtocol getTechnologySpecificProtocol();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocolSpecification#getTechnologySpecificProtocol <em>Technology Specific Protocol</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Technology Specific Protocol</em>' containment reference.
     * @see #getTechnologySpecificProtocol()
     * @generated
     */
    void setTechnologySpecificProtocol(TechnologySpecificProtocol value);

} // TechnologySpecificProtocolSpecification
