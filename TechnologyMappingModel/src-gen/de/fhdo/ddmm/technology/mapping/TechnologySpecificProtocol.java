/**
 */
package de.fhdo.ddmm.technology.mapping;

import de.fhdo.ddmm.technology.DataFormat;
import de.fhdo.ddmm.technology.Protocol;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Technology Specific Protocol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Technology-specific protocol. It differs from the ImportedProtocolAndDataFormat concept of the
 * Service Viewpoint metamodel in that it does not have a reference to an Import, because it always
 * originates from the technology being assigned to the mapped microservice.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocol#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocol#getDataFormat <em>Data Format</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocol#getProtocolSpecification <em>Protocol Specification</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocol#getEndpoint <em>Endpoint</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologySpecificProtocol()
 * @model
 * @generated
 */
public interface TechnologySpecificProtocol extends EObject {
    /**
     * Returns the value of the '<em><b>Protocol</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Protocol must be one from the technology assigned to the parent microservice
     *          mapping.
     *          Ensured by: DSL scope provider.
     *     (C2) Data format must be one from the technology assigned to the parent microservice
     *          mapping and correspond to the protocol.
     *          Ensured by: DSL scope provider.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Protocol</em>' reference.
     * @see #setProtocol(Protocol)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologySpecificProtocol_Protocol()
     * @model
     * @generated
     */
    Protocol getProtocol();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocol#getProtocol <em>Protocol</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Protocol</em>' reference.
     * @see #getProtocol()
     * @generated
     */
    void setProtocol(Protocol value);

    /**
     * Returns the value of the '<em><b>Data Format</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Format</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Format</em>' reference.
     * @see #setDataFormat(DataFormat)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologySpecificProtocol_DataFormat()
     * @model
     * @generated
     */
    DataFormat getDataFormat();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocol#getDataFormat <em>Data Format</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Format</em>' reference.
     * @see #getDataFormat()
     * @generated
     */
    void setDataFormat(DataFormat value);

    /**
     * Returns the value of the '<em><b>Protocol Specification</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocolSpecification#getTechnologySpecificProtocol <em>Technology Specific Protocol</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Protocol Specification</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocol Specification</em>' container reference.
     * @see #setProtocolSpecification(TechnologySpecificProtocolSpecification)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologySpecificProtocol_ProtocolSpecification()
     * @see de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocolSpecification#getTechnologySpecificProtocol
     * @model opposite="technologySpecificProtocol" transient="false"
     * @generated
     */
    TechnologySpecificProtocolSpecification getProtocolSpecification();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocol#getProtocolSpecification <em>Protocol Specification</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Protocol Specification</em>' container reference.
     * @see #getProtocolSpecification()
     * @generated
     */
    void setProtocolSpecification(TechnologySpecificProtocolSpecification value);

    /**
     * Returns the value of the '<em><b>Endpoint</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificEndpoint#getTechnologySpecificProtocols <em>Technology Specific Protocols</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoint</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoint</em>' container reference.
     * @see #setEndpoint(TechnologySpecificEndpoint)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologySpecificProtocol_Endpoint()
     * @see de.fhdo.ddmm.technology.mapping.TechnologySpecificEndpoint#getTechnologySpecificProtocols
     * @model opposite="technologySpecificProtocols" transient="false"
     * @generated
     */
    TechnologySpecificEndpoint getEndpoint();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocol#getEndpoint <em>Endpoint</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Endpoint</em>' container reference.
     * @see #getEndpoint()
     * @generated
     */
    void setEndpoint(TechnologySpecificEndpoint value);

} // TechnologySpecificProtocol
