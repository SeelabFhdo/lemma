/**
 */
package de.fhdo.lemma.operation.intermediate;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage
 * @generated
 */
public interface IntermediateFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IntermediateFactory eINSTANCE = de.fhdo.lemma.operation.intermediate.impl.IntermediateFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Operation Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Model</em>'.
	 * @generated
	 */
	IntermediateOperationModel createIntermediateOperationModel();

	/**
	 * Returns a new object of class '<em>Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Container</em>'.
	 * @generated
	 */
	IntermediateContainer createIntermediateContainer();

	/**
	 * Returns a new object of class '<em>Infrastructure Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Infrastructure Node</em>'.
	 * @generated
	 */
	IntermediateInfrastructureNode createIntermediateInfrastructureNode();

	/**
	 * Returns a new object of class '<em>Service Deployment Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Deployment Specification</em>'.
	 * @generated
	 */
	IntermediateServiceDeploymentSpecification createIntermediateServiceDeploymentSpecification();

	/**
	 * Returns a new object of class '<em>Operation Environment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Environment</em>'.
	 * @generated
	 */
	IntermediateOperationEnvironment createIntermediateOperationEnvironment();

	/**
	 * Returns a new object of class '<em>Deployment Technology</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deployment Technology</em>'.
	 * @generated
	 */
	IntermediateDeploymentTechnology createIntermediateDeploymentTechnology();

	/**
	 * Returns a new object of class '<em>Infrastructure Technology</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Infrastructure Technology</em>'.
	 * @generated
	 */
	IntermediateInfrastructureTechnology createIntermediateInfrastructureTechnology();

	/**
	 * Returns a new object of class '<em>Infrastructure Technology Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Infrastructure Technology Reference</em>'.
	 * @generated
	 */
	IntermediateInfrastructureTechnologyReference createIntermediateInfrastructureTechnologyReference();

	/**
	 * Returns a new object of class '<em>Deployment Technology Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deployment Technology Reference</em>'.
	 * @generated
	 */
	IntermediateDeploymentTechnologyReference createIntermediateDeploymentTechnologyReference();

	/**
	 * Returns a new object of class '<em>Technology Specific Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Technology Specific Property</em>'.
	 * @generated
	 */
	IntermediateTechnologySpecificProperty createIntermediateTechnologySpecificProperty();

	/**
	 * Returns a new object of class '<em>Technology Specific Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Technology Specific Property Value</em>'.
	 * @generated
	 */
	IntermediateTechnologySpecificPropertyValue createIntermediateTechnologySpecificPropertyValue();

	/**
	 * Returns a new object of class '<em>Operation Microservice Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Microservice Reference</em>'.
	 * @generated
	 */
	OperationMicroserviceReference createOperationMicroserviceReference();

	/**
	 * Returns a new object of class '<em>Endpoint Technology</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Endpoint Technology</em>'.
	 * @generated
	 */
	IntermediateEndpointTechnology createIntermediateEndpointTechnology();

	/**
	 * Returns a new object of class '<em>Operation Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Endpoint</em>'.
	 * @generated
	 */
	IntermediateOperationEndpoint createIntermediateOperationEndpoint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	IntermediatePackage getIntermediatePackage();

} //IntermediateFactory
