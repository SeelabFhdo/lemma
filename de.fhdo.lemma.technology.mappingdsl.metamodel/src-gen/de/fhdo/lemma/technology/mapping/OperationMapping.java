/**
 */
package de.fhdo.lemma.technology.mapping;

import de.fhdo.lemma.service.Operation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Technology mapping for operations
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.mapping.OperationMapping#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.OperationMapping#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.OperationMapping#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.OperationMapping#getParameterMappings <em>Parameter Mappings</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.OperationMapping#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.OperationMapping#getMicroserviceMapping <em>Microservice Mapping</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getOperationMapping()
 * @model
 * @generated
 */
public interface OperationMapping extends EObject {
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
	 *     (C6) A parameter may be mapped only once.
	 *          Ensured by: DSL validator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(Operation)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getOperationMapping_Operation()
	 * @model
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.OperationMapping#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operation value);

	/**
	 * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint#getOperationMapping <em>Operation Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoints</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getOperationMapping_Endpoints()
	 * @see de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint#getOperationMapping
	 * @model opposite="operationMapping" containment="true"
	 * @generated
	 */
	EList<TechnologySpecificEndpoint> getEndpoints();

	/**
	 * Returns the value of the '<em><b>Protocols</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.TechnologySpecificProtocolSpecification}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocols</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getOperationMapping_Protocols()
	 * @model containment="true"
	 * @generated
	 */
	EList<TechnologySpecificProtocolSpecification> getProtocols();

	/**
	 * Returns the value of the '<em><b>Parameter Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.ParameterMapping}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.ParameterMapping#getOperationMapping <em>Operation Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Mappings</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getOperationMapping_ParameterMappings()
	 * @see de.fhdo.lemma.technology.mapping.ParameterMapping#getOperationMapping
	 * @model opposite="operationMapping" containment="true"
	 * @generated
	 */
	EList<ParameterMapping> getParameterMappings();

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getOperationMapping <em>Operation Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getOperationMapping_Aspects()
	 * @see de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getOperationMapping
	 * @model opposite="operationMapping" containment="true"
	 * @generated
	 */
	EList<TechnologySpecificImportedServiceAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Microservice Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.MicroserviceMapping#getOperationMappings <em>Operation Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Microservice Mapping</em>' container reference.
	 * @see #setMicroserviceMapping(MicroserviceMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getOperationMapping_MicroserviceMapping()
	 * @see de.fhdo.lemma.technology.mapping.MicroserviceMapping#getOperationMappings
	 * @model opposite="operationMappings" transient="false"
	 * @generated
	 */
	MicroserviceMapping getMicroserviceMapping();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.OperationMapping#getMicroserviceMapping <em>Microservice Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Microservice Mapping</em>' container reference.
	 * @see #getMicroserviceMapping()
	 * @generated
	 */
	void setMicroserviceMapping(MicroserviceMapping value);

} // OperationMapping
