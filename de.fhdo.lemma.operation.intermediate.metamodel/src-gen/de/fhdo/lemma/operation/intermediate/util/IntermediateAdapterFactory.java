/**
 */
package de.fhdo.lemma.operation.intermediate.util;

import de.fhdo.lemma.operation.intermediate.*;

import de.fhdo.lemma.service.intermediate.IntermediateEndpoint;
import de.fhdo.lemma.service.intermediate.IntermediateTechnology;
import de.fhdo.lemma.service.intermediate.MicroserviceReference;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage
 * @generated
 */
public class IntermediateAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static IntermediatePackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = IntermediatePackage.eINSTANCE;
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
    protected IntermediateSwitch<Adapter> modelSwitch =
        new IntermediateSwitch<Adapter>() {
            @Override
            public Adapter caseIntermediateOperationModel(IntermediateOperationModel object) {
                return createIntermediateOperationModelAdapter();
            }
            @Override
            public Adapter caseIntermediateOperationNode(IntermediateOperationNode object) {
                return createIntermediateOperationNodeAdapter();
            }
            @Override
            public Adapter caseIntermediateContainer(IntermediateContainer object) {
                return createIntermediateContainerAdapter();
            }
            @Override
            public Adapter caseIntermediateInfrastructureNode(IntermediateInfrastructureNode object) {
                return createIntermediateInfrastructureNodeAdapter();
            }
            @Override
            public Adapter caseIntermediateServiceDeploymentSpecification(IntermediateServiceDeploymentSpecification object) {
                return createIntermediateServiceDeploymentSpecificationAdapter();
            }
            @Override
            public Adapter caseIntermediateOperationEnvironment(IntermediateOperationEnvironment object) {
                return createIntermediateOperationEnvironmentAdapter();
            }
            @Override
            public Adapter caseIntermediateOperationTechnology(IntermediateOperationTechnology object) {
                return createIntermediateOperationTechnologyAdapter();
            }
            @Override
            public Adapter caseIntermediateDeploymentTechnology(IntermediateDeploymentTechnology object) {
                return createIntermediateDeploymentTechnologyAdapter();
            }
            @Override
            public Adapter caseIntermediateInfrastructureTechnology(IntermediateInfrastructureTechnology object) {
                return createIntermediateInfrastructureTechnologyAdapter();
            }
            @Override
            public Adapter caseIntermediateInfrastructureTechnologyReference(IntermediateInfrastructureTechnologyReference object) {
                return createIntermediateInfrastructureTechnologyReferenceAdapter();
            }
            @Override
            public Adapter caseIntermediateDeploymentTechnologyReference(IntermediateDeploymentTechnologyReference object) {
                return createIntermediateDeploymentTechnologyReferenceAdapter();
            }
            @Override
            public Adapter caseIntermediateTechnologySpecificProperty(IntermediateTechnologySpecificProperty object) {
                return createIntermediateTechnologySpecificPropertyAdapter();
            }
            @Override
            public Adapter caseIntermediateTechnologySpecificPropertyValue(IntermediateTechnologySpecificPropertyValue object) {
                return createIntermediateTechnologySpecificPropertyValueAdapter();
            }
            @Override
            public Adapter caseOperationMicroserviceReference(OperationMicroserviceReference object) {
                return createOperationMicroserviceReferenceAdapter();
            }
            @Override
            public Adapter caseIntermediateEndpointTechnology(IntermediateEndpointTechnology object) {
                return createIntermediateEndpointTechnologyAdapter();
            }
            @Override
            public Adapter caseIntermediateOperationEndpoint(IntermediateOperationEndpoint object) {
                return createIntermediateOperationEndpointAdapter();
            }
            @Override
            public Adapter caseMicroserviceReference(MicroserviceReference object) {
                return createMicroserviceReferenceAdapter();
            }
            @Override
            public Adapter caseIntermediateTechnology(IntermediateTechnology object) {
                return createIntermediateTechnologyAdapter();
            }
            @Override
            public Adapter caseIntermediateEndpoint(IntermediateEndpoint object) {
                return createIntermediateEndpointAdapter();
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
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel <em>Operation Model</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
     * @generated
     */
    public Adapter createIntermediateOperationModelAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode <em>Operation Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode
     * @generated
     */
    public Adapter createIntermediateOperationNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer <em>Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.operation.intermediate.IntermediateContainer
     * @generated
     */
    public Adapter createIntermediateContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode <em>Infrastructure Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
     * @generated
     */
    public Adapter createIntermediateInfrastructureNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification <em>Service Deployment Specification</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification
     * @generated
     */
    public Adapter createIntermediateServiceDeploymentSpecificationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment <em>Operation Environment</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment
     * @generated
     */
    public Adapter createIntermediateOperationEnvironmentAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology <em>Operation Technology</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology
     * @generated
     */
    public Adapter createIntermediateOperationTechnologyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnology <em>Deployment Technology</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnology
     * @generated
     */
    public Adapter createIntermediateDeploymentTechnologyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnology <em>Infrastructure Technology</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnology
     * @generated
     */
    public Adapter createIntermediateInfrastructureTechnologyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference <em>Infrastructure Technology Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference
     * @generated
     */
    public Adapter createIntermediateInfrastructureTechnologyReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference <em>Deployment Technology Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference
     * @generated
     */
    public Adapter createIntermediateDeploymentTechnologyReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty <em>Technology Specific Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty
     * @generated
     */
    public Adapter createIntermediateTechnologySpecificPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue <em>Technology Specific Property Value</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue
     * @generated
     */
    public Adapter createIntermediateTechnologySpecificPropertyValueAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference <em>Operation Microservice Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference
     * @generated
     */
    public Adapter createOperationMicroserviceReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.intermediate.IntermediateEndpointTechnology <em>Endpoint Technology</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.operation.intermediate.IntermediateEndpointTechnology
     * @generated
     */
    public Adapter createIntermediateEndpointTechnologyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint <em>Operation Endpoint</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint
     * @generated
     */
    public Adapter createIntermediateOperationEndpointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.service.intermediate.MicroserviceReference <em>Microservice Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.service.intermediate.MicroserviceReference
     * @generated
     */
    public Adapter createMicroserviceReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.service.intermediate.IntermediateTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.service.intermediate.IntermediateTechnology
     * @generated
     */
    public Adapter createIntermediateTechnologyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint <em>Endpoint</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.lemma.service.intermediate.IntermediateEndpoint
     * @generated
     */
    public Adapter createIntermediateEndpointAdapter() {
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

} //IntermediateAdapterFactory
