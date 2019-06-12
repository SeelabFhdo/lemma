/**
 */
package de.fhdo.ddmm.service.intermediate.util;

import de.fhdo.ddmm.data.intermediate.IntermediateType;

import de.fhdo.ddmm.service.intermediate.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage
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
            public Adapter caseIntermediateServiceModel(IntermediateServiceModel object) {
                return createIntermediateServiceModelAdapter();
            }
            @Override
            public Adapter caseIntermediateMicroservice(IntermediateMicroservice object) {
                return createIntermediateMicroserviceAdapter();
            }
            @Override
            public Adapter caseIntermediateInterface(IntermediateInterface object) {
                return createIntermediateInterfaceAdapter();
            }
            @Override
            public Adapter caseIntermediateOperation(IntermediateOperation object) {
                return createIntermediateOperationAdapter();
            }
            @Override
            public Adapter caseIntermediateReferredOperation(IntermediateReferredOperation object) {
                return createIntermediateReferredOperationAdapter();
            }
            @Override
            public Adapter caseIntermediateParameter(IntermediateParameter object) {
                return createIntermediateParameterAdapter();
            }
            @Override
            public Adapter caseIntermediateMappedField(IntermediateMappedField object) {
                return createIntermediateMappedFieldAdapter();
            }
            @Override
            public Adapter caseMicroserviceReference(MicroserviceReference object) {
                return createMicroserviceReferenceAdapter();
            }
            @Override
            public Adapter caseInterfaceReference(InterfaceReference object) {
                return createInterfaceReferenceAdapter();
            }
            @Override
            public Adapter caseOperationReference(OperationReference object) {
                return createOperationReferenceAdapter();
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
            public Adapter caseIntermediateProtocolSpecification(IntermediateProtocolSpecification object) {
                return createIntermediateProtocolSpecificationAdapter();
            }
            @Override
            public Adapter caseIntermediateImportedAspect(IntermediateImportedAspect object) {
                return createIntermediateImportedAspectAdapter();
            }
            @Override
            public Adapter caseIntermediateAspectProperty(IntermediateAspectProperty object) {
                return createIntermediateAspectPropertyAdapter();
            }
            @Override
            public Adapter caseIntermediateAspectPropertyValue(IntermediateAspectPropertyValue object) {
                return createIntermediateAspectPropertyValueAdapter();
            }
            @Override
            public Adapter caseIntermediateImportedTechnologySpecificType(IntermediateImportedTechnologySpecificType object) {
                return createIntermediateImportedTechnologySpecificTypeAdapter();
            }
            @Override
            public Adapter caseIntermediateType(IntermediateType object) {
                return createIntermediateTypeAdapter();
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
     * Creates a new adapter for an object of class '{@link de.fhdo.ddmm.service.intermediate.IntermediateServiceModel <em>Service Model</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.ddmm.service.intermediate.IntermediateServiceModel
     * @generated
     */
    public Adapter createIntermediateServiceModelAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.ddmm.service.intermediate.IntermediateMicroservice <em>Microservice</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.ddmm.service.intermediate.IntermediateMicroservice
     * @generated
     */
    public Adapter createIntermediateMicroserviceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.ddmm.service.intermediate.IntermediateInterface <em>Interface</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.ddmm.service.intermediate.IntermediateInterface
     * @generated
     */
    public Adapter createIntermediateInterfaceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.ddmm.service.intermediate.IntermediateOperation <em>Operation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.ddmm.service.intermediate.IntermediateOperation
     * @generated
     */
    public Adapter createIntermediateOperationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.ddmm.service.intermediate.IntermediateReferredOperation <em>Referred Operation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.ddmm.service.intermediate.IntermediateReferredOperation
     * @generated
     */
    public Adapter createIntermediateReferredOperationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.ddmm.service.intermediate.IntermediateParameter
     * @generated
     */
    public Adapter createIntermediateParameterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedField <em>Mapped Field</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.ddmm.service.intermediate.IntermediateMappedField
     * @generated
     */
    public Adapter createIntermediateMappedFieldAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.ddmm.service.intermediate.MicroserviceReference <em>Microservice Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.ddmm.service.intermediate.MicroserviceReference
     * @generated
     */
    public Adapter createMicroserviceReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.ddmm.service.intermediate.InterfaceReference <em>Interface Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.ddmm.service.intermediate.InterfaceReference
     * @generated
     */
    public Adapter createInterfaceReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.ddmm.service.intermediate.OperationReference <em>Operation Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.ddmm.service.intermediate.OperationReference
     * @generated
     */
    public Adapter createOperationReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.ddmm.service.intermediate.IntermediateTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.ddmm.service.intermediate.IntermediateTechnology
     * @generated
     */
    public Adapter createIntermediateTechnologyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.ddmm.service.intermediate.IntermediateEndpoint <em>Endpoint</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.ddmm.service.intermediate.IntermediateEndpoint
     * @generated
     */
    public Adapter createIntermediateEndpointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.ddmm.service.intermediate.IntermediateProtocolSpecification <em>Protocol Specification</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.ddmm.service.intermediate.IntermediateProtocolSpecification
     * @generated
     */
    public Adapter createIntermediateProtocolSpecificationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect <em>Imported Aspect</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect
     * @generated
     */
    public Adapter createIntermediateImportedAspectAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.ddmm.service.intermediate.IntermediateAspectProperty <em>Aspect Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.ddmm.service.intermediate.IntermediateAspectProperty
     * @generated
     */
    public Adapter createIntermediateAspectPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.ddmm.service.intermediate.IntermediateAspectPropertyValue <em>Aspect Property Value</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.ddmm.service.intermediate.IntermediateAspectPropertyValue
     * @generated
     */
    public Adapter createIntermediateAspectPropertyValueAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedTechnologySpecificType <em>Imported Technology Specific Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.ddmm.service.intermediate.IntermediateImportedTechnologySpecificType
     * @generated
     */
    public Adapter createIntermediateImportedTechnologySpecificTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fhdo.ddmm.data.intermediate.IntermediateType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateType
     * @generated
     */
    public Adapter createIntermediateTypeAdapter() {
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
