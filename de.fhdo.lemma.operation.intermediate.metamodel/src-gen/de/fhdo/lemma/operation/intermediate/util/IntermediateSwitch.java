/**
 */
package de.fhdo.lemma.operation.intermediate.util;

import de.fhdo.lemma.operation.intermediate.*;

import de.fhdo.lemma.service.intermediate.IntermediateEndpoint;
import de.fhdo.lemma.service.intermediate.IntermediateTechnology;
import de.fhdo.lemma.service.intermediate.MicroserviceReference;

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
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL: {
                IntermediateOperationModel intermediateOperationModel = (IntermediateOperationModel)theEObject;
                T result = caseIntermediateOperationModel(intermediateOperationModel);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE: {
                IntermediateOperationNode intermediateOperationNode = (IntermediateOperationNode)theEObject;
                T result = caseIntermediateOperationNode(intermediateOperationNode);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_CONTAINER: {
                IntermediateContainer intermediateContainer = (IntermediateContainer)theEObject;
                T result = caseIntermediateContainer(intermediateContainer);
                if (result == null) result = caseIntermediateOperationNode(intermediateContainer);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE: {
                IntermediateInfrastructureNode intermediateInfrastructureNode = (IntermediateInfrastructureNode)theEObject;
                T result = caseIntermediateInfrastructureNode(intermediateInfrastructureNode);
                if (result == null) result = caseIntermediateOperationNode(intermediateInfrastructureNode);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION: {
                IntermediateServiceDeploymentSpecification intermediateServiceDeploymentSpecification = (IntermediateServiceDeploymentSpecification)theEObject;
                T result = caseIntermediateServiceDeploymentSpecification(intermediateServiceDeploymentSpecification);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT: {
                IntermediateOperationEnvironment intermediateOperationEnvironment = (IntermediateOperationEnvironment)theEObject;
                T result = caseIntermediateOperationEnvironment(intermediateOperationEnvironment);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY: {
                IntermediateOperationTechnology intermediateOperationTechnology = (IntermediateOperationTechnology)theEObject;
                T result = caseIntermediateOperationTechnology(intermediateOperationTechnology);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY: {
                IntermediateDeploymentTechnology intermediateDeploymentTechnology = (IntermediateDeploymentTechnology)theEObject;
                T result = caseIntermediateDeploymentTechnology(intermediateDeploymentTechnology);
                if (result == null) result = caseIntermediateOperationTechnology(intermediateDeploymentTechnology);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY: {
                IntermediateInfrastructureTechnology intermediateInfrastructureTechnology = (IntermediateInfrastructureTechnology)theEObject;
                T result = caseIntermediateInfrastructureTechnology(intermediateInfrastructureTechnology);
                if (result == null) result = caseIntermediateOperationTechnology(intermediateInfrastructureTechnology);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE: {
                IntermediateInfrastructureTechnologyReference intermediateInfrastructureTechnologyReference = (IntermediateInfrastructureTechnologyReference)theEObject;
                T result = caseIntermediateInfrastructureTechnologyReference(intermediateInfrastructureTechnologyReference);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE: {
                IntermediateDeploymentTechnologyReference intermediateDeploymentTechnologyReference = (IntermediateDeploymentTechnologyReference)theEObject;
                T result = caseIntermediateDeploymentTechnologyReference(intermediateDeploymentTechnologyReference);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY: {
                IntermediateTechnologySpecificProperty intermediateTechnologySpecificProperty = (IntermediateTechnologySpecificProperty)theEObject;
                T result = caseIntermediateTechnologySpecificProperty(intermediateTechnologySpecificProperty);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE: {
                IntermediateTechnologySpecificPropertyValue intermediateTechnologySpecificPropertyValue = (IntermediateTechnologySpecificPropertyValue)theEObject;
                T result = caseIntermediateTechnologySpecificPropertyValue(intermediateTechnologySpecificPropertyValue);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE: {
                OperationMicroserviceReference operationMicroserviceReference = (OperationMicroserviceReference)theEObject;
                T result = caseOperationMicroserviceReference(operationMicroserviceReference);
                if (result == null) result = caseMicroserviceReference(operationMicroserviceReference);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_ENDPOINT_TECHNOLOGY: {
                IntermediateEndpointTechnology intermediateEndpointTechnology = (IntermediateEndpointTechnology)theEObject;
                T result = caseIntermediateEndpointTechnology(intermediateEndpointTechnology);
                if (result == null) result = caseIntermediateTechnology(intermediateEndpointTechnology);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT: {
                IntermediateOperationEndpoint intermediateOperationEndpoint = (IntermediateOperationEndpoint)theEObject;
                T result = caseIntermediateOperationEndpoint(intermediateOperationEndpoint);
                if (result == null) result = caseIntermediateEndpoint(intermediateOperationEndpoint);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operation Model</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation Model</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateOperationModel(IntermediateOperationModel object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operation Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateOperationNode(IntermediateOperationNode object) {
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
    public T caseIntermediateContainer(IntermediateContainer object) {
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
    public T caseIntermediateInfrastructureNode(IntermediateInfrastructureNode object) {
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
    public T caseIntermediateServiceDeploymentSpecification(IntermediateServiceDeploymentSpecification object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operation Environment</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation Environment</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateOperationEnvironment(IntermediateOperationEnvironment object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operation Technology</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation Technology</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateOperationTechnology(IntermediateOperationTechnology object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Deployment Technology</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Deployment Technology</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateDeploymentTechnology(IntermediateDeploymentTechnology object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Infrastructure Technology</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Infrastructure Technology</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateInfrastructureTechnology(IntermediateInfrastructureTechnology object) {
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
    public T caseIntermediateInfrastructureTechnologyReference(IntermediateInfrastructureTechnologyReference object) {
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
    public T caseIntermediateDeploymentTechnologyReference(IntermediateDeploymentTechnologyReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Technology Specific Property</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Technology Specific Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateTechnologySpecificProperty(IntermediateTechnologySpecificProperty object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Technology Specific Property Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Technology Specific Property Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateTechnologySpecificPropertyValue(IntermediateTechnologySpecificPropertyValue object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operation Microservice Reference</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation Microservice Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOperationMicroserviceReference(OperationMicroserviceReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Endpoint Technology</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Endpoint Technology</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateEndpointTechnology(IntermediateEndpointTechnology object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operation Endpoint</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation Endpoint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateOperationEndpoint(IntermediateOperationEndpoint object) {
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
