/**
 */
package de.fhdo.lemma.technology.mapping;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Technology Specific Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Default and service-specific basic endpoints
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint#getAddresses <em>Addresses</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint#getTechnologySpecificProtocols <em>Technology Specific Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint#getMicroserviceMapping <em>Microservice Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint#getInterfaceMapping <em>Interface Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint#getOperationMapping <em>Operation Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint#getReferredOperationMapping <em>Referred Operation Mapping</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificEndpoint()
 * @model
 * @generated
 */
public interface TechnologySpecificEndpoint extends EObject {
	/**
	 * Returns the value of the '<em><b>Addresses</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) Addresses must be unique.
	 *          Ensured by: DSL validator.
	 *     (C2) Protocol/data format combinations must be unique.
	 *          Ensured by: DSL validator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Addresses</em>' attribute list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificEndpoint_Addresses()
	 * @model unique="false" required="true"
	 * @generated
	 */
	EList<String> getAddresses();

	/**
	 * Returns the value of the '<em><b>Technology Specific Protocols</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.TechnologySpecificProtocol}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificProtocol#getEndpoint <em>Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Technology Specific Protocols</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificEndpoint_TechnologySpecificProtocols()
	 * @see de.fhdo.lemma.technology.mapping.TechnologySpecificProtocol#getEndpoint
	 * @model opposite="endpoint" containment="true" required="true"
	 * @generated
	 */
	EList<TechnologySpecificProtocol> getTechnologySpecificProtocols();

	/**
	 * Returns the value of the '<em><b>Microservice Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.MicroserviceMapping#getEndpoints <em>Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Microservice Mapping</em>' container reference.
	 * @see #setMicroserviceMapping(MicroserviceMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificEndpoint_MicroserviceMapping()
	 * @see de.fhdo.lemma.technology.mapping.MicroserviceMapping#getEndpoints
	 * @model opposite="endpoints" transient="false"
	 * @generated
	 */
	MicroserviceMapping getMicroserviceMapping();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint#getMicroserviceMapping <em>Microservice Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Microservice Mapping</em>' container reference.
	 * @see #getMicroserviceMapping()
	 * @generated
	 */
	void setMicroserviceMapping(MicroserviceMapping value);

	/**
	 * Returns the value of the '<em><b>Interface Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.InterfaceMapping#getEndpoints <em>Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface Mapping</em>' container reference.
	 * @see #setInterfaceMapping(InterfaceMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificEndpoint_InterfaceMapping()
	 * @see de.fhdo.lemma.technology.mapping.InterfaceMapping#getEndpoints
	 * @model opposite="endpoints" transient="false"
	 * @generated
	 */
	InterfaceMapping getInterfaceMapping();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint#getInterfaceMapping <em>Interface Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface Mapping</em>' container reference.
	 * @see #getInterfaceMapping()
	 * @generated
	 */
	void setInterfaceMapping(InterfaceMapping value);

	/**
	 * Returns the value of the '<em><b>Operation Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.OperationMapping#getEndpoints <em>Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Mapping</em>' container reference.
	 * @see #setOperationMapping(OperationMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificEndpoint_OperationMapping()
	 * @see de.fhdo.lemma.technology.mapping.OperationMapping#getEndpoints
	 * @model opposite="endpoints" transient="false"
	 * @generated
	 */
	OperationMapping getOperationMapping();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint#getOperationMapping <em>Operation Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Mapping</em>' container reference.
	 * @see #getOperationMapping()
	 * @generated
	 */
	void setOperationMapping(OperationMapping value);

	/**
	 * Returns the value of the '<em><b>Referred Operation Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.ReferredOperationMapping#getEndpoints <em>Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Operation Mapping</em>' container reference.
	 * @see #setReferredOperationMapping(ReferredOperationMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificEndpoint_ReferredOperationMapping()
	 * @see de.fhdo.lemma.technology.mapping.ReferredOperationMapping#getEndpoints
	 * @model opposite="endpoints" transient="false"
	 * @generated
	 */
	ReferredOperationMapping getReferredOperationMapping();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint#getReferredOperationMapping <em>Referred Operation Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Operation Mapping</em>' container reference.
	 * @see #getReferredOperationMapping()
	 * @generated
	 */
	void setReferredOperationMapping(ReferredOperationMapping value);

} // TechnologySpecificEndpoint
