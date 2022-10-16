/**
 */
package de.fhdo.lemma.service.intermediate.impl;

import de.fhdo.lemma.service.intermediate.*;

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
            case IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT: return createIntermediateApiOperationComment();
            case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT: return createIntermediateApiParameterComment();
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION: return createIntermediateReferredOperation();
            case IntermediatePackage.INTERMEDIATE_PARAMETER: return createIntermediateParameter();
            case IntermediatePackage.DATA_FIELD_ASPECTS: return createDataFieldAspects();
            case IntermediatePackage.MICROSERVICE_REFERENCE: return createMicroserviceReference();
            case IntermediatePackage.INTERFACE_REFERENCE: return createInterfaceReference();
            case IntermediatePackage.OPERATION_REFERENCE: return createOperationReference();
            case IntermediatePackage.INTERMEDIATE_TECHNOLOGY: return createIntermediateTechnology();
            case IntermediatePackage.INTERMEDIATE_ENDPOINT: return createIntermediateEndpoint();
            case IntermediatePackage.INTERMEDIATE_PROTOCOL_SPECIFICATION: return createIntermediateProtocolSpecification();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateServiceModel createIntermediateServiceModel() {
        IntermediateServiceModelImpl intermediateServiceModel = new IntermediateServiceModelImpl();
        return intermediateServiceModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateMicroservice createIntermediateMicroservice() {
        IntermediateMicroserviceImpl intermediateMicroservice = new IntermediateMicroserviceImpl();
        return intermediateMicroservice;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateInterface createIntermediateInterface() {
        IntermediateInterfaceImpl intermediateInterface = new IntermediateInterfaceImpl();
        return intermediateInterface;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateOperation createIntermediateOperation() {
        IntermediateOperationImpl intermediateOperation = new IntermediateOperationImpl();
        return intermediateOperation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateApiOperationComment createIntermediateApiOperationComment() {
        IntermediateApiOperationCommentImpl intermediateApiOperationComment = new IntermediateApiOperationCommentImpl();
        return intermediateApiOperationComment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateApiParameterComment createIntermediateApiParameterComment() {
        IntermediateApiParameterCommentImpl intermediateApiParameterComment = new IntermediateApiParameterCommentImpl();
        return intermediateApiParameterComment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateReferredOperation createIntermediateReferredOperation() {
        IntermediateReferredOperationImpl intermediateReferredOperation = new IntermediateReferredOperationImpl();
        return intermediateReferredOperation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateParameter createIntermediateParameter() {
        IntermediateParameterImpl intermediateParameter = new IntermediateParameterImpl();
        return intermediateParameter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataFieldAspects createDataFieldAspects() {
        DataFieldAspectsImpl dataFieldAspects = new DataFieldAspectsImpl();
        return dataFieldAspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MicroserviceReference createMicroserviceReference() {
        MicroserviceReferenceImpl microserviceReference = new MicroserviceReferenceImpl();
        return microserviceReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InterfaceReference createInterfaceReference() {
        InterfaceReferenceImpl interfaceReference = new InterfaceReferenceImpl();
        return interfaceReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationReference createOperationReference() {
        OperationReferenceImpl operationReference = new OperationReferenceImpl();
        return operationReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateTechnology createIntermediateTechnology() {
        IntermediateTechnologyImpl intermediateTechnology = new IntermediateTechnologyImpl();
        return intermediateTechnology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateEndpoint createIntermediateEndpoint() {
        IntermediateEndpointImpl intermediateEndpoint = new IntermediateEndpointImpl();
        return intermediateEndpoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateProtocolSpecification createIntermediateProtocolSpecification() {
        IntermediateProtocolSpecificationImpl intermediateProtocolSpecification = new IntermediateProtocolSpecificationImpl();
        return intermediateProtocolSpecification;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
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
