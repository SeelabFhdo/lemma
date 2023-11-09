/**
 */
package de.fhdo.lemma.technology.mapping;

import de.fhdo.lemma.service.ReferredOperation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Referred Operation Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Technology mapping for referred operations
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.mapping.ReferredOperationMapping#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.ReferredOperationMapping#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.ReferredOperationMapping#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.ReferredOperationMapping#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.ReferredOperationMapping#getMicroserviceMapping <em>Microservice Mapping</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getReferredOperationMapping()
 * @model
 * @generated
 */
public interface ReferredOperationMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) An operation may only be mapped once.
	 *          Ensured by: DSL validator.
	 *     (C2) Mapping must not be empty.
	 *          Ensured by: DSL validator.
	 *     (C3) Communication types of mapped protocol specifications must be unique.
	 *          Ensured by: DSL validator.
	 *     (C4) Endpoint protocols must be unique.
	 *          Ensured by: DSL validator.
	 *     (C5) Endpoint addresses must be unique.
	 *          Ensured by: DSL validator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(ReferredOperation)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getReferredOperationMapping_Operation()
	 * @model
	 * @generated
	 */
	ReferredOperation getOperation();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.ReferredOperationMapping#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(ReferredOperation value);

	/**
	 * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint#getReferredOperationMapping <em>Referred Operation Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoints</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getReferredOperationMapping_Endpoints()
	 * @see de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint#getReferredOperationMapping
	 * @model opposite="referredOperationMapping" containment="true"
	 * @generated
	 */
	EList<TechnologySpecificEndpoint> getEndpoints();

	/**
	 * Returns the value of the '<em><b>Protocols</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.TechnologySpecificProtocolSpecification}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocols</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getReferredOperationMapping_Protocols()
	 * @model containment="true"
	 * @generated
	 */
	EList<TechnologySpecificProtocolSpecification> getProtocols();

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getReferredOperationMapping <em>Referred Operation Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getReferredOperationMapping_Aspects()
	 * @see de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getReferredOperationMapping
	 * @model opposite="referredOperationMapping" containment="true"
	 * @generated
	 */
	EList<TechnologySpecificImportedServiceAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Microservice Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.MicroserviceMapping#getReferredOperationMappings <em>Referred Operation Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Microservice Mapping</em>' container reference.
	 * @see #setMicroserviceMapping(MicroserviceMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getReferredOperationMapping_MicroserviceMapping()
	 * @see de.fhdo.lemma.technology.mapping.MicroserviceMapping#getReferredOperationMappings
	 * @model opposite="referredOperationMappings" transient="false"
	 * @generated
	 */
	MicroserviceMapping getMicroserviceMapping();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.ReferredOperationMapping#getMicroserviceMapping <em>Microservice Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Microservice Mapping</em>' container reference.
	 * @see #getMicroserviceMapping()
	 * @generated
	 */
	void setMicroserviceMapping(MicroserviceMapping value);

} // ReferredOperationMapping
