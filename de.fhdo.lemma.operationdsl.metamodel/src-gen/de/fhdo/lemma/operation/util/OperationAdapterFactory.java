/**
 */
package de.fhdo.lemma.operation.util;

import de.fhdo.lemma.operation.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.fhdo.lemma.operation.OperationPackage
 * @generated
 */
public class OperationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OperationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = OperationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationSwitch<Adapter> modelSwitch =
		new OperationSwitch<Adapter>() {
			@Override
			public Adapter caseOperationModel(OperationModel object) {
				return createOperationModelAdapter();
			}
			@Override
			public Adapter caseOperationNode(OperationNode object) {
				return createOperationNodeAdapter();
			}
			@Override
			public Adapter caseContainer(Container object) {
				return createContainerAdapter();
			}
			@Override
			public Adapter caseDeploymentTechnologyReference(DeploymentTechnologyReference object) {
				return createDeploymentTechnologyReferenceAdapter();
			}
			@Override
			public Adapter caseInfrastructureNode(InfrastructureNode object) {
				return createInfrastructureNodeAdapter();
			}
			@Override
			public Adapter caseInfrastructureTechnologyReference(InfrastructureTechnologyReference object) {
				return createInfrastructureTechnologyReferenceAdapter();
			}
			@Override
			public Adapter caseImportedMicroservice(ImportedMicroservice object) {
				return createImportedMicroserviceAdapter();
			}
			@Override
			public Adapter caseServiceDeploymentSpecification(ServiceDeploymentSpecification object) {
				return createServiceDeploymentSpecificationAdapter();
			}
			@Override
			public Adapter caseProtocolAndDataFormat(ProtocolAndDataFormat object) {
				return createProtocolAndDataFormatAdapter();
			}
			@Override
			public Adapter caseBasicEndpoint(BasicEndpoint object) {
				return createBasicEndpointAdapter();
			}
			@Override
			public Adapter caseImportedOperationAspect(ImportedOperationAspect object) {
				return createImportedOperationAspectAdapter();
			}
			@Override
			public Adapter casePossiblyImportedOperationNode(PossiblyImportedOperationNode object) {
				return createPossiblyImportedOperationNodeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.OperationModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fhdo.lemma.operation.OperationModel
	 * @generated
	 */
	public Adapter createOperationModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.OperationNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fhdo.lemma.operation.OperationNode
	 * @generated
	 */
	public Adapter createOperationNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.Container <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fhdo.lemma.operation.Container
	 * @generated
	 */
	public Adapter createContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.DeploymentTechnologyReference <em>Deployment Technology Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fhdo.lemma.operation.DeploymentTechnologyReference
	 * @generated
	 */
	public Adapter createDeploymentTechnologyReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.InfrastructureNode <em>Infrastructure Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fhdo.lemma.operation.InfrastructureNode
	 * @generated
	 */
	public Adapter createInfrastructureNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.InfrastructureTechnologyReference <em>Infrastructure Technology Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fhdo.lemma.operation.InfrastructureTechnologyReference
	 * @generated
	 */
	public Adapter createInfrastructureTechnologyReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.ImportedMicroservice <em>Imported Microservice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fhdo.lemma.operation.ImportedMicroservice
	 * @generated
	 */
	public Adapter createImportedMicroserviceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.ServiceDeploymentSpecification <em>Service Deployment Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fhdo.lemma.operation.ServiceDeploymentSpecification
	 * @generated
	 */
	public Adapter createServiceDeploymentSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.ProtocolAndDataFormat <em>Protocol And Data Format</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fhdo.lemma.operation.ProtocolAndDataFormat
	 * @generated
	 */
	public Adapter createProtocolAndDataFormatAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.BasicEndpoint <em>Basic Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fhdo.lemma.operation.BasicEndpoint
	 * @generated
	 */
	public Adapter createBasicEndpointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.ImportedOperationAspect <em>Imported Operation Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fhdo.lemma.operation.ImportedOperationAspect
	 * @generated
	 */
	public Adapter createImportedOperationAspectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.PossiblyImportedOperationNode <em>Possibly Imported Operation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fhdo.lemma.operation.PossiblyImportedOperationNode
	 * @generated
	 */
	public Adapter createPossiblyImportedOperationNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //OperationAdapterFactory
