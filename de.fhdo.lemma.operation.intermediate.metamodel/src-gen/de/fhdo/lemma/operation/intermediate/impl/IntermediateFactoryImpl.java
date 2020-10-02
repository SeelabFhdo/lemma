/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.operation.intermediate.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IntermediateFactoryImpl extends EFactoryImpl implements IntermediateFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IntermediateFactory init() {
		try {
			IntermediateFactory theIntermediateFactory = (IntermediateFactory)EPackage.Registry.INSTANCE.getEFactory(IntermediatePackage.eNS_URI);
			if (theIntermediateFactory != null) {
				return theIntermediateFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new IntermediateFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL: return createIntermediateOperationModel();
			case IntermediatePackage.INTERMEDIATE_CONTAINER: return createIntermediateContainer();
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE: return createIntermediateInfrastructureNode();
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION: return createIntermediateServiceDeploymentSpecification();
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT: return createIntermediateOperationEnvironment();
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY: return createIntermediateDeploymentTechnology();
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY: return createIntermediateInfrastructureTechnology();
			case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE: return createIntermediateInfrastructureTechnologyReference();
			case IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE: return createIntermediateDeploymentTechnologyReference();
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY: return createIntermediateTechnologySpecificProperty();
			case IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE: return createIntermediateTechnologySpecificPropertyValue();
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE: return createOperationMicroserviceReference();
			case IntermediatePackage.INTERMEDIATE_ENDPOINT_TECHNOLOGY: return createIntermediateEndpointTechnology();
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT: return createIntermediateOperationEndpoint();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateOperationModel createIntermediateOperationModel() {
		IntermediateOperationModelImpl intermediateOperationModel = new IntermediateOperationModelImpl();
		return intermediateOperationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateContainer createIntermediateContainer() {
		IntermediateContainerImpl intermediateContainer = new IntermediateContainerImpl();
		return intermediateContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateInfrastructureNode createIntermediateInfrastructureNode() {
		IntermediateInfrastructureNodeImpl intermediateInfrastructureNode = new IntermediateInfrastructureNodeImpl();
		return intermediateInfrastructureNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateServiceDeploymentSpecification createIntermediateServiceDeploymentSpecification() {
		IntermediateServiceDeploymentSpecificationImpl intermediateServiceDeploymentSpecification = new IntermediateServiceDeploymentSpecificationImpl();
		return intermediateServiceDeploymentSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateOperationEnvironment createIntermediateOperationEnvironment() {
		IntermediateOperationEnvironmentImpl intermediateOperationEnvironment = new IntermediateOperationEnvironmentImpl();
		return intermediateOperationEnvironment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateDeploymentTechnology createIntermediateDeploymentTechnology() {
		IntermediateDeploymentTechnologyImpl intermediateDeploymentTechnology = new IntermediateDeploymentTechnologyImpl();
		return intermediateDeploymentTechnology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateInfrastructureTechnology createIntermediateInfrastructureTechnology() {
		IntermediateInfrastructureTechnologyImpl intermediateInfrastructureTechnology = new IntermediateInfrastructureTechnologyImpl();
		return intermediateInfrastructureTechnology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateInfrastructureTechnologyReference createIntermediateInfrastructureTechnologyReference() {
		IntermediateInfrastructureTechnologyReferenceImpl intermediateInfrastructureTechnologyReference = new IntermediateInfrastructureTechnologyReferenceImpl();
		return intermediateInfrastructureTechnologyReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateDeploymentTechnologyReference createIntermediateDeploymentTechnologyReference() {
		IntermediateDeploymentTechnologyReferenceImpl intermediateDeploymentTechnologyReference = new IntermediateDeploymentTechnologyReferenceImpl();
		return intermediateDeploymentTechnologyReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateTechnologySpecificProperty createIntermediateTechnologySpecificProperty() {
		IntermediateTechnologySpecificPropertyImpl intermediateTechnologySpecificProperty = new IntermediateTechnologySpecificPropertyImpl();
		return intermediateTechnologySpecificProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateTechnologySpecificPropertyValue createIntermediateTechnologySpecificPropertyValue() {
		IntermediateTechnologySpecificPropertyValueImpl intermediateTechnologySpecificPropertyValue = new IntermediateTechnologySpecificPropertyValueImpl();
		return intermediateTechnologySpecificPropertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationMicroserviceReference createOperationMicroserviceReference() {
		OperationMicroserviceReferenceImpl operationMicroserviceReference = new OperationMicroserviceReferenceImpl();
		return operationMicroserviceReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateEndpointTechnology createIntermediateEndpointTechnology() {
		IntermediateEndpointTechnologyImpl intermediateEndpointTechnology = new IntermediateEndpointTechnologyImpl();
		return intermediateEndpointTechnology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateOperationEndpoint createIntermediateOperationEndpoint() {
		IntermediateOperationEndpointImpl intermediateOperationEndpoint = new IntermediateOperationEndpointImpl();
		return intermediateOperationEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediatePackage getIntermediatePackage() {
		return (IntermediatePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static IntermediatePackage getPackage() {
		return IntermediatePackage.eINSTANCE;
	}

} //IntermediateFactoryImpl
