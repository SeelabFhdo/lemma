/**
 */
package de.fhdo.lemma.operation.impl;

import de.fhdo.lemma.operation.*;

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
public class OperationFactoryImpl extends EFactoryImpl implements OperationFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static OperationFactory init() {
        try {
            OperationFactory theOperationFactory = (OperationFactory)EPackage.Registry.INSTANCE.getEFactory(OperationPackage.eNS_URI);
            if (theOperationFactory != null) {
                return theOperationFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new OperationFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationFactoryImpl() {
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
            case OperationPackage.OPERATION_MODEL: return createOperationModel();
            case OperationPackage.CONTAINER: return createContainer();
            case OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE: return createDeploymentTechnologyReference();
            case OperationPackage.INFRASTRUCTURE_NODE: return createInfrastructureNode();
            case OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE: return createInfrastructureTechnologyReference();
            case OperationPackage.IMPORTED_MICROSERVICE: return createImportedMicroservice();
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION: return createServiceDeploymentSpecification();
            case OperationPackage.PROTOCOL_AND_DATA_FORMAT: return createProtocolAndDataFormat();
            case OperationPackage.BASIC_ENDPOINT: return createBasicEndpoint();
            case OperationPackage.IMPORTED_OPERATION_ASPECT: return createImportedOperationAspect();
            case OperationPackage.POSSIBLY_IMPORTED_OPERATION_NODE: return createPossiblyImportedOperationNode();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationModel createOperationModel() {
        OperationModelImpl operationModel = new OperationModelImpl();
        return operationModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public de.fhdo.lemma.operation.Container createContainer() {
        ContainerImpl container = new ContainerImpl();
        return container;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DeploymentTechnologyReference createDeploymentTechnologyReference() {
        DeploymentTechnologyReferenceImpl deploymentTechnologyReference = new DeploymentTechnologyReferenceImpl();
        return deploymentTechnologyReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureNode createInfrastructureNode() {
        InfrastructureNodeImpl infrastructureNode = new InfrastructureNodeImpl();
        return infrastructureNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureTechnologyReference createInfrastructureTechnologyReference() {
        InfrastructureTechnologyReferenceImpl infrastructureTechnologyReference = new InfrastructureTechnologyReferenceImpl();
        return infrastructureTechnologyReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ImportedMicroservice createImportedMicroservice() {
        ImportedMicroserviceImpl importedMicroservice = new ImportedMicroserviceImpl();
        return importedMicroservice;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ServiceDeploymentSpecification createServiceDeploymentSpecification() {
        ServiceDeploymentSpecificationImpl serviceDeploymentSpecification = new ServiceDeploymentSpecificationImpl();
        return serviceDeploymentSpecification;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProtocolAndDataFormat createProtocolAndDataFormat() {
        ProtocolAndDataFormatImpl protocolAndDataFormat = new ProtocolAndDataFormatImpl();
        return protocolAndDataFormat;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BasicEndpoint createBasicEndpoint() {
        BasicEndpointImpl basicEndpoint = new BasicEndpointImpl();
        return basicEndpoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ImportedOperationAspect createImportedOperationAspect() {
        ImportedOperationAspectImpl importedOperationAspect = new ImportedOperationAspectImpl();
        return importedOperationAspect;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PossiblyImportedOperationNode createPossiblyImportedOperationNode() {
        PossiblyImportedOperationNodeImpl possiblyImportedOperationNode = new PossiblyImportedOperationNodeImpl();
        return possiblyImportedOperationNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationPackage getOperationPackage() {
        return (OperationPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static OperationPackage getPackage() {
        return OperationPackage.eINSTANCE;
    }

} //OperationFactoryImpl
