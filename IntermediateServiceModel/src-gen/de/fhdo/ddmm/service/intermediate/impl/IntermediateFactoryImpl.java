/**
 */
package de.fhdo.ddmm.service.intermediate.impl;

import de.fhdo.ddmm.service.intermediate.*;

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
            case IntermediatePackage.INTERMEDIATE_SERVICE_MODEL: return createIntermediateServiceModel();
            case IntermediatePackage.INTERMEDIATE_MICROSERVICE: return createIntermediateMicroservice();
            case IntermediatePackage.INTERMEDIATE_INTERFACE: return createIntermediateInterface();
            case IntermediatePackage.INTERMEDIATE_OPERATION: return createIntermediateOperation();
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION: return createIntermediateReferredOperation();
            case IntermediatePackage.INTERMEDIATE_PARAMETER: return createIntermediateParameter();
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD: return createIntermediateMappedField();
            case IntermediatePackage.MICROSERVICE_REFERENCE: return createMicroserviceReference();
            case IntermediatePackage.INTERFACE_REFERENCE: return createInterfaceReference();
            case IntermediatePackage.OPERATION_REFERENCE: return createOperationReference();
            case IntermediatePackage.INTERMEDIATE_TECHNOLOGY: return createIntermediateTechnology();
            case IntermediatePackage.INTERMEDIATE_ENDPOINT: return createIntermediateEndpoint();
            case IntermediatePackage.INTERMEDIATE_PROTOCOL_SPECIFICATION: return createIntermediateProtocolSpecification();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT: return createIntermediateImportedAspect();
            case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY: return createIntermediateAspectProperty();
            case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE: return createIntermediateAspectPropertyValue();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE: return createIntermediateImportedTechnologySpecificType();
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
    public IntermediateServiceModel createIntermediateServiceModel() {
        IntermediateServiceModelImpl intermediateServiceModel = new IntermediateServiceModelImpl();
        return intermediateServiceModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateMicroservice createIntermediateMicroservice() {
        IntermediateMicroserviceImpl intermediateMicroservice = new IntermediateMicroserviceImpl();
        return intermediateMicroservice;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateInterface createIntermediateInterface() {
        IntermediateInterfaceImpl intermediateInterface = new IntermediateInterfaceImpl();
        return intermediateInterface;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateOperation createIntermediateOperation() {
        IntermediateOperationImpl intermediateOperation = new IntermediateOperationImpl();
        return intermediateOperation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateReferredOperation createIntermediateReferredOperation() {
        IntermediateReferredOperationImpl intermediateReferredOperation = new IntermediateReferredOperationImpl();
        return intermediateReferredOperation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateParameter createIntermediateParameter() {
        IntermediateParameterImpl intermediateParameter = new IntermediateParameterImpl();
        return intermediateParameter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateMappedField createIntermediateMappedField() {
        IntermediateMappedFieldImpl intermediateMappedField = new IntermediateMappedFieldImpl();
        return intermediateMappedField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public MicroserviceReference createMicroserviceReference() {
        MicroserviceReferenceImpl microserviceReference = new MicroserviceReferenceImpl();
        return microserviceReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public InterfaceReference createInterfaceReference() {
        InterfaceReferenceImpl interfaceReference = new InterfaceReferenceImpl();
        return interfaceReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public OperationReference createOperationReference() {
        OperationReferenceImpl operationReference = new OperationReferenceImpl();
        return operationReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateTechnology createIntermediateTechnology() {
        IntermediateTechnologyImpl intermediateTechnology = new IntermediateTechnologyImpl();
        return intermediateTechnology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateEndpoint createIntermediateEndpoint() {
        IntermediateEndpointImpl intermediateEndpoint = new IntermediateEndpointImpl();
        return intermediateEndpoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateProtocolSpecification createIntermediateProtocolSpecification() {
        IntermediateProtocolSpecificationImpl intermediateProtocolSpecification = new IntermediateProtocolSpecificationImpl();
        return intermediateProtocolSpecification;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateImportedAspect createIntermediateImportedAspect() {
        IntermediateImportedAspectImpl intermediateImportedAspect = new IntermediateImportedAspectImpl();
        return intermediateImportedAspect;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateAspectProperty createIntermediateAspectProperty() {
        IntermediateAspectPropertyImpl intermediateAspectProperty = new IntermediateAspectPropertyImpl();
        return intermediateAspectProperty;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateAspectPropertyValue createIntermediateAspectPropertyValue() {
        IntermediateAspectPropertyValueImpl intermediateAspectPropertyValue = new IntermediateAspectPropertyValueImpl();
        return intermediateAspectPropertyValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateImportedTechnologySpecificType createIntermediateImportedTechnologySpecificType() {
        IntermediateImportedTechnologySpecificTypeImpl intermediateImportedTechnologySpecificType = new IntermediateImportedTechnologySpecificTypeImpl();
        return intermediateImportedTechnologySpecificType;
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
