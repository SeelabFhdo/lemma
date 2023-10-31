/**
 */
package de.fhdo.lemma.operation.util;

import de.fhdo.lemma.operation.*;

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
 * @see de.fhdo.lemma.operation.OperationPackage
 * @generated
 */
public class OperationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OperationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationSwitch() {
		if (modelPackage == null) {
			modelPackage = OperationPackage.eINSTANCE;
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
			case OperationPackage.OPERATION_MODEL: {
				OperationModel operationModel = (OperationModel)theEObject;
				T result = caseOperationModel(operationModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.OPERATION_NODE: {
				OperationNode operationNode = (OperationNode)theEObject;
				T result = caseOperationNode(operationNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.CONTAINER: {
				Container container = (Container)theEObject;
				T result = caseContainer(container);
				if (result == null) result = caseOperationNode(container);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE: {
				DeploymentTechnologyReference deploymentTechnologyReference = (DeploymentTechnologyReference)theEObject;
				T result = caseDeploymentTechnologyReference(deploymentTechnologyReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.INFRASTRUCTURE_NODE: {
				InfrastructureNode infrastructureNode = (InfrastructureNode)theEObject;
				T result = caseInfrastructureNode(infrastructureNode);
				if (result == null) result = caseOperationNode(infrastructureNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE: {
				InfrastructureTechnologyReference infrastructureTechnologyReference = (InfrastructureTechnologyReference)theEObject;
				T result = caseInfrastructureTechnologyReference(infrastructureTechnologyReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.IMPORTED_MICROSERVICE: {
				ImportedMicroservice importedMicroservice = (ImportedMicroservice)theEObject;
				T result = caseImportedMicroservice(importedMicroservice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION: {
				ServiceDeploymentSpecification serviceDeploymentSpecification = (ServiceDeploymentSpecification)theEObject;
				T result = caseServiceDeploymentSpecification(serviceDeploymentSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.PROTOCOL_AND_DATA_FORMAT: {
				ProtocolAndDataFormat protocolAndDataFormat = (ProtocolAndDataFormat)theEObject;
				T result = caseProtocolAndDataFormat(protocolAndDataFormat);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.BASIC_ENDPOINT: {
				BasicEndpoint basicEndpoint = (BasicEndpoint)theEObject;
				T result = caseBasicEndpoint(basicEndpoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.IMPORTED_OPERATION_ASPECT: {
				ImportedOperationAspect importedOperationAspect = (ImportedOperationAspect)theEObject;
				T result = caseImportedOperationAspect(importedOperationAspect);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationPackage.POSSIBLY_IMPORTED_OPERATION_NODE: {
				PossiblyImportedOperationNode possiblyImportedOperationNode = (PossiblyImportedOperationNode)theEObject;
				T result = casePossiblyImportedOperationNode(possiblyImportedOperationNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationModel(OperationModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationNode(OperationNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainer(Container object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deployment Technology Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deployment Technology Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeploymentTechnologyReference(DeploymentTechnologyReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Infrastructure Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Infrastructure Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInfrastructureNode(InfrastructureNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Infrastructure Technology Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Infrastructure Technology Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInfrastructureTechnologyReference(InfrastructureTechnologyReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imported Microservice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imported Microservice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImportedMicroservice(ImportedMicroservice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Deployment Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Deployment Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceDeploymentSpecification(ServiceDeploymentSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protocol And Data Format</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protocol And Data Format</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProtocolAndDataFormat(ProtocolAndDataFormat object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Endpoint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicEndpoint(BasicEndpoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imported Operation Aspect</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imported Operation Aspect</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImportedOperationAspect(ImportedOperationAspect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Possibly Imported Operation Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Possibly Imported Operation Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePossiblyImportedOperationNode(PossiblyImportedOperationNode object) {
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

} //OperationSwitch
