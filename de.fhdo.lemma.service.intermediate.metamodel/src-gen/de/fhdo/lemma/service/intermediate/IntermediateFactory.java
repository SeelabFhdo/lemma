/**
 */
package de.fhdo.lemma.service.intermediate;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage
 * @generated
 */
public interface IntermediateFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IntermediateFactory eINSTANCE = de.fhdo.lemma.service.intermediate.impl.IntermediateFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Service Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Model</em>'.
	 * @generated
	 */
	IntermediateServiceModel createIntermediateServiceModel();

	/**
	 * Returns a new object of class '<em>Microservice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Microservice</em>'.
	 * @generated
	 */
	IntermediateMicroservice createIntermediateMicroservice();

	/**
	 * Returns a new object of class '<em>Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface</em>'.
	 * @generated
	 */
	IntermediateInterface createIntermediateInterface();

	/**
	 * Returns a new object of class '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation</em>'.
	 * @generated
	 */
	IntermediateOperation createIntermediateOperation();

	/**
	 * Returns a new object of class '<em>Api Operation Comment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Api Operation Comment</em>'.
	 * @generated
	 */
	IntermediateApiOperationComment createIntermediateApiOperationComment();

	/**
	 * Returns a new object of class '<em>Api Parameter Comment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Api Parameter Comment</em>'.
	 * @generated
	 */
	IntermediateApiParameterComment createIntermediateApiParameterComment();

	/**
	 * Returns a new object of class '<em>Referred Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Referred Operation</em>'.
	 * @generated
	 */
	IntermediateReferredOperation createIntermediateReferredOperation();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	IntermediateParameter createIntermediateParameter();

	/**
	 * Returns a new object of class '<em>Data Field Aspects</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Field Aspects</em>'.
	 * @generated
	 */
	DataFieldAspects createDataFieldAspects();

	/**
	 * Returns a new object of class '<em>Microservice Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Microservice Reference</em>'.
	 * @generated
	 */
	MicroserviceReference createMicroserviceReference();

	/**
	 * Returns a new object of class '<em>Interface Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Reference</em>'.
	 * @generated
	 */
	InterfaceReference createInterfaceReference();

	/**
	 * Returns a new object of class '<em>Operation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Reference</em>'.
	 * @generated
	 */
	OperationReference createOperationReference();

	/**
	 * Returns a new object of class '<em>Technology</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Technology</em>'.
	 * @generated
	 */
	IntermediateTechnology createIntermediateTechnology();

	/**
	 * Returns a new object of class '<em>Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Endpoint</em>'.
	 * @generated
	 */
	IntermediateEndpoint createIntermediateEndpoint();

	/**
	 * Returns a new object of class '<em>Protocol Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Protocol Specification</em>'.
	 * @generated
	 */
	IntermediateProtocolSpecification createIntermediateProtocolSpecification();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	IntermediatePackage getIntermediatePackage();

} //IntermediateFactory
