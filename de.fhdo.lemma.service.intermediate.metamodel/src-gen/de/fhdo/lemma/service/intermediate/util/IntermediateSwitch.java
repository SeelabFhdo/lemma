/**
 */
package de.fhdo.lemma.service.intermediate.util;

import de.fhdo.lemma.service.intermediate.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage
 * @generated
 */
public class IntermediateSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static IntermediatePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateSwitch() {
		if (modelPackage == null) {
			modelPackage = IntermediatePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case IntermediatePackage.INTERMEDIATE_SERVICE_MODEL: {
				IntermediateServiceModel intermediateServiceModel = (IntermediateServiceModel)theEObject;
				T result = caseIntermediateServiceModel(intermediateServiceModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE: {
				IntermediateMicroservice intermediateMicroservice = (IntermediateMicroservice)theEObject;
				T result = caseIntermediateMicroservice(intermediateMicroservice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntermediatePackage.INTERMEDIATE_INTERFACE: {
				IntermediateInterface intermediateInterface = (IntermediateInterface)theEObject;
				T result = caseIntermediateInterface(intermediateInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntermediatePackage.INTERMEDIATE_OPERATION: {
				IntermediateOperation intermediateOperation = (IntermediateOperation)theEObject;
				T result = caseIntermediateOperation(intermediateOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT: {
				IntermediateApiOperationComment intermediateApiOperationComment = (IntermediateApiOperationComment)theEObject;
				T result = caseIntermediateApiOperationComment(intermediateApiOperationComment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT: {
				IntermediateApiParameterComment intermediateApiParameterComment = (IntermediateApiParameterComment)theEObject;
				T result = caseIntermediateApiParameterComment(intermediateApiParameterComment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION: {
				IntermediateReferredOperation intermediateReferredOperation = (IntermediateReferredOperation)theEObject;
				T result = caseIntermediateReferredOperation(intermediateReferredOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntermediatePackage.INTERMEDIATE_PARAMETER: {
				IntermediateParameter intermediateParameter = (IntermediateParameter)theEObject;
				T result = caseIntermediateParameter(intermediateParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntermediatePackage.DATA_FIELD_ASPECTS: {
				DataFieldAspects dataFieldAspects = (DataFieldAspects)theEObject;
				T result = caseDataFieldAspects(dataFieldAspects);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntermediatePackage.MICROSERVICE_REFERENCE: {
				MicroserviceReference microserviceReference = (MicroserviceReference)theEObject;
				T result = caseMicroserviceReference(microserviceReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntermediatePackage.INTERFACE_REFERENCE: {
				InterfaceReference interfaceReference = (InterfaceReference)theEObject;
				T result = caseInterfaceReference(interfaceReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntermediatePackage.OPERATION_REFERENCE: {
				OperationReference operationReference = (OperationReference)theEObject;
				T result = caseOperationReference(operationReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY: {
				IntermediateTechnology intermediateTechnology = (IntermediateTechnology)theEObject;
				T result = caseIntermediateTechnology(intermediateTechnology);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntermediatePackage.INTERMEDIATE_ENDPOINT: {
				IntermediateEndpoint intermediateEndpoint = (IntermediateEndpoint)theEObject;
				T result = caseIntermediateEndpoint(intermediateEndpoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntermediatePackage.INTERMEDIATE_PROTOCOL_SPECIFICATION: {
				IntermediateProtocolSpecification intermediateProtocolSpecification = (IntermediateProtocolSpecification)theEObject;
				T result = caseIntermediateProtocolSpecification(intermediateProtocolSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntermediateServiceModel(IntermediateServiceModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Microservice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Microservice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntermediateMicroservice(IntermediateMicroservice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntermediateInterface(IntermediateInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntermediateOperation(IntermediateOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Api Operation Comment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Api Operation Comment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntermediateApiOperationComment(IntermediateApiOperationComment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Api Parameter Comment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Api Parameter Comment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntermediateApiParameterComment(IntermediateApiParameterComment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Referred Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Referred Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntermediateReferredOperation(IntermediateReferredOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntermediateParameter(IntermediateParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Field Aspects</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Field Aspects</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataFieldAspects(DataFieldAspects object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Microservice Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Microservice Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMicroserviceReference(MicroserviceReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceReference(InterfaceReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationReference(OperationReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Technology</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Technology</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntermediateTechnology(IntermediateTechnology object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Endpoint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntermediateEndpoint(IntermediateEndpoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protocol Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protocol Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntermediateProtocolSpecification(IntermediateProtocolSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //IntermediateSwitch
