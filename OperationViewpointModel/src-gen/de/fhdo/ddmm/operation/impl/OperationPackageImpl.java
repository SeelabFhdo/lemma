/**
 */
package de.fhdo.ddmm.operation.impl;

import de.fhdo.ddmm.data.DataPackage;

import de.fhdo.ddmm.operation.BasicEndpoint;
import de.fhdo.ddmm.operation.DeploymentTechnologyReference;
import de.fhdo.ddmm.operation.ImportType;
import de.fhdo.ddmm.operation.ImportedMicroservice;
import de.fhdo.ddmm.operation.ImportedOperationAspect;
import de.fhdo.ddmm.operation.InfrastructureNode;
import de.fhdo.ddmm.operation.InfrastructureTechnologyReference;
import de.fhdo.ddmm.operation.OperationFactory;
import de.fhdo.ddmm.operation.OperationModel;
import de.fhdo.ddmm.operation.OperationNode;
import de.fhdo.ddmm.operation.OperationPackage;
import de.fhdo.ddmm.operation.ProtocolAndDataFormat;
import de.fhdo.ddmm.operation.ServiceDeploymentSpecification;

import de.fhdo.ddmm.service.ServicePackage;

import de.fhdo.ddmm.technology.TechnologyPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OperationPackageImpl extends EPackageImpl implements OperationPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass operationModelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass operationNodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass containerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass deploymentTechnologyReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass infrastructureNodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass infrastructureTechnologyReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass importedMicroserviceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass serviceDeploymentSpecificationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass protocolAndDataFormatEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass basicEndpointEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass importedOperationAspectEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum importTypeEEnum = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see de.fhdo.ddmm.operation.OperationPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private OperationPackageImpl() {
        super(eNS_URI, OperationFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link OperationPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static OperationPackage init() {
        if (isInited) return (OperationPackage)EPackage.Registry.INSTANCE.getEPackage(OperationPackage.eNS_URI);

        // Obtain or create and register package
        OperationPackageImpl theOperationPackage = (OperationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OperationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OperationPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        ServicePackage.eINSTANCE.eClass();
        EcorePackage.eINSTANCE.eClass();
        TechnologyPackage.eINSTANCE.eClass();
        DataPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theOperationPackage.createPackageContents();

        // Initialize created meta-data
        theOperationPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theOperationPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(OperationPackage.eNS_URI, theOperationPackage);
        return theOperationPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOperationModel() {
        return operationModelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationModel_Imports() {
        return (EReference)operationModelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationModel_Containers() {
        return (EReference)operationModelEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationModel_InfrastructureNodes() {
        return (EReference)operationModelEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOperationNode() {
        return operationNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperationNode_Name() {
        return (EAttribute)operationNodeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationNode_Technologies() {
        return (EReference)operationNodeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationNode_OperationEnvironment() {
        return (EReference)operationNodeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationNode_DeployedServices() {
        return (EReference)operationNodeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationNode_DefaultServicePropertyValues() {
        return (EReference)operationNodeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationNode_DeploymentSpecifications() {
        return (EReference)operationNodeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationNode_Aspects() {
        return (EReference)operationNodeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getContainer() {
        return containerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getContainer_DeploymentTechnology() {
        return (EReference)containerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getContainer_DefaultBasicEndpoints() {
        return (EReference)containerEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getContainer_OperationModel() {
        return (EReference)containerEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDeploymentTechnologyReference() {
        return deploymentTechnologyReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDeploymentTechnologyReference_Import() {
        return (EReference)deploymentTechnologyReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDeploymentTechnologyReference_DeploymentTechnology() {
        return (EReference)deploymentTechnologyReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDeploymentTechnologyReference_Container() {
        return (EReference)deploymentTechnologyReferenceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInfrastructureNode() {
        return infrastructureNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInfrastructureNode_InfrastructureTechnology() {
        return (EReference)infrastructureNodeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInfrastructureNode_Endpoints() {
        return (EReference)infrastructureNodeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInfrastructureNode_OperationModel() {
        return (EReference)infrastructureNodeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInfrastructureTechnologyReference() {
        return infrastructureTechnologyReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInfrastructureTechnologyReference_Import() {
        return (EReference)infrastructureTechnologyReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInfrastructureTechnologyReference_InfrastructureTechnology() {
        return (EReference)infrastructureTechnologyReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInfrastructureTechnologyReference_InfrastructureNode() {
        return (EReference)infrastructureTechnologyReferenceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getImportedMicroservice() {
        return importedMicroserviceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getImportedMicroservice_Import() {
        return (EReference)importedMicroserviceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getImportedMicroservice_Microservice() {
        return (EReference)importedMicroserviceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getImportedMicroservice_OperationNode() {
        return (EReference)importedMicroserviceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getServiceDeploymentSpecification() {
        return serviceDeploymentSpecificationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getServiceDeploymentSpecification_Import() {
        return (EReference)serviceDeploymentSpecificationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getServiceDeploymentSpecification_Service() {
        return (EReference)serviceDeploymentSpecificationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getServiceDeploymentSpecification_ServicePropertyValues() {
        return (EReference)serviceDeploymentSpecificationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getServiceDeploymentSpecification_BasicEndpoints() {
        return (EReference)serviceDeploymentSpecificationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getServiceDeploymentSpecification_OperationNode() {
        return (EReference)serviceDeploymentSpecificationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getProtocolAndDataFormat() {
        return protocolAndDataFormatEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProtocolAndDataFormat_Technology() {
        return (EReference)protocolAndDataFormatEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProtocolAndDataFormat_Protocol() {
        return (EReference)protocolAndDataFormatEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProtocolAndDataFormat_DataFormat() {
        return (EReference)protocolAndDataFormatEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProtocolAndDataFormat_Endpoint() {
        return (EReference)protocolAndDataFormatEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBasicEndpoint() {
        return basicEndpointEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBasicEndpoint_Addresses() {
        return (EAttribute)basicEndpointEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBasicEndpoint_Protocols() {
        return (EReference)basicEndpointEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBasicEndpoint_Container() {
        return (EReference)basicEndpointEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBasicEndpoint_InfrastructureNode() {
        return (EReference)basicEndpointEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBasicEndpoint_DeploymentSpecification() {
        return (EReference)basicEndpointEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getImportedOperationAspect() {
        return importedOperationAspectEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getImportedOperationAspect_Technology() {
        return (EReference)importedOperationAspectEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getImportedOperationAspect_Aspect() {
        return (EReference)importedOperationAspectEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getImportedOperationAspect_SinglePropertyValue() {
        return (EReference)importedOperationAspectEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getImportedOperationAspect_Values() {
        return (EReference)importedOperationAspectEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getImportedOperationAspect_OperationNode() {
        return (EReference)importedOperationAspectEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getImportType() {
        return importTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationFactory getOperationFactory() {
        return (OperationFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        operationModelEClass = createEClass(OPERATION_MODEL);
        createEReference(operationModelEClass, OPERATION_MODEL__IMPORTS);
        createEReference(operationModelEClass, OPERATION_MODEL__CONTAINERS);
        createEReference(operationModelEClass, OPERATION_MODEL__INFRASTRUCTURE_NODES);

        operationNodeEClass = createEClass(OPERATION_NODE);
        createEAttribute(operationNodeEClass, OPERATION_NODE__NAME);
        createEReference(operationNodeEClass, OPERATION_NODE__TECHNOLOGIES);
        createEReference(operationNodeEClass, OPERATION_NODE__OPERATION_ENVIRONMENT);
        createEReference(operationNodeEClass, OPERATION_NODE__DEPLOYED_SERVICES);
        createEReference(operationNodeEClass, OPERATION_NODE__DEFAULT_SERVICE_PROPERTY_VALUES);
        createEReference(operationNodeEClass, OPERATION_NODE__DEPLOYMENT_SPECIFICATIONS);
        createEReference(operationNodeEClass, OPERATION_NODE__ASPECTS);

        containerEClass = createEClass(CONTAINER);
        createEReference(containerEClass, CONTAINER__DEPLOYMENT_TECHNOLOGY);
        createEReference(containerEClass, CONTAINER__DEFAULT_BASIC_ENDPOINTS);
        createEReference(containerEClass, CONTAINER__OPERATION_MODEL);

        deploymentTechnologyReferenceEClass = createEClass(DEPLOYMENT_TECHNOLOGY_REFERENCE);
        createEReference(deploymentTechnologyReferenceEClass, DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT);
        createEReference(deploymentTechnologyReferenceEClass, DEPLOYMENT_TECHNOLOGY_REFERENCE__DEPLOYMENT_TECHNOLOGY);
        createEReference(deploymentTechnologyReferenceEClass, DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER);

        infrastructureNodeEClass = createEClass(INFRASTRUCTURE_NODE);
        createEReference(infrastructureNodeEClass, INFRASTRUCTURE_NODE__INFRASTRUCTURE_TECHNOLOGY);
        createEReference(infrastructureNodeEClass, INFRASTRUCTURE_NODE__ENDPOINTS);
        createEReference(infrastructureNodeEClass, INFRASTRUCTURE_NODE__OPERATION_MODEL);

        infrastructureTechnologyReferenceEClass = createEClass(INFRASTRUCTURE_TECHNOLOGY_REFERENCE);
        createEReference(infrastructureTechnologyReferenceEClass, INFRASTRUCTURE_TECHNOLOGY_REFERENCE__IMPORT);
        createEReference(infrastructureTechnologyReferenceEClass, INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_TECHNOLOGY);
        createEReference(infrastructureTechnologyReferenceEClass, INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE);

        importedMicroserviceEClass = createEClass(IMPORTED_MICROSERVICE);
        createEReference(importedMicroserviceEClass, IMPORTED_MICROSERVICE__IMPORT);
        createEReference(importedMicroserviceEClass, IMPORTED_MICROSERVICE__MICROSERVICE);
        createEReference(importedMicroserviceEClass, IMPORTED_MICROSERVICE__OPERATION_NODE);

        serviceDeploymentSpecificationEClass = createEClass(SERVICE_DEPLOYMENT_SPECIFICATION);
        createEReference(serviceDeploymentSpecificationEClass, SERVICE_DEPLOYMENT_SPECIFICATION__IMPORT);
        createEReference(serviceDeploymentSpecificationEClass, SERVICE_DEPLOYMENT_SPECIFICATION__SERVICE);
        createEReference(serviceDeploymentSpecificationEClass, SERVICE_DEPLOYMENT_SPECIFICATION__SERVICE_PROPERTY_VALUES);
        createEReference(serviceDeploymentSpecificationEClass, SERVICE_DEPLOYMENT_SPECIFICATION__BASIC_ENDPOINTS);
        createEReference(serviceDeploymentSpecificationEClass, SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE);

        protocolAndDataFormatEClass = createEClass(PROTOCOL_AND_DATA_FORMAT);
        createEReference(protocolAndDataFormatEClass, PROTOCOL_AND_DATA_FORMAT__TECHNOLOGY);
        createEReference(protocolAndDataFormatEClass, PROTOCOL_AND_DATA_FORMAT__PROTOCOL);
        createEReference(protocolAndDataFormatEClass, PROTOCOL_AND_DATA_FORMAT__DATA_FORMAT);
        createEReference(protocolAndDataFormatEClass, PROTOCOL_AND_DATA_FORMAT__ENDPOINT);

        basicEndpointEClass = createEClass(BASIC_ENDPOINT);
        createEAttribute(basicEndpointEClass, BASIC_ENDPOINT__ADDRESSES);
        createEReference(basicEndpointEClass, BASIC_ENDPOINT__PROTOCOLS);
        createEReference(basicEndpointEClass, BASIC_ENDPOINT__CONTAINER);
        createEReference(basicEndpointEClass, BASIC_ENDPOINT__INFRASTRUCTURE_NODE);
        createEReference(basicEndpointEClass, BASIC_ENDPOINT__DEPLOYMENT_SPECIFICATION);

        importedOperationAspectEClass = createEClass(IMPORTED_OPERATION_ASPECT);
        createEReference(importedOperationAspectEClass, IMPORTED_OPERATION_ASPECT__TECHNOLOGY);
        createEReference(importedOperationAspectEClass, IMPORTED_OPERATION_ASPECT__ASPECT);
        createEReference(importedOperationAspectEClass, IMPORTED_OPERATION_ASPECT__SINGLE_PROPERTY_VALUE);
        createEReference(importedOperationAspectEClass, IMPORTED_OPERATION_ASPECT__VALUES);
        createEReference(importedOperationAspectEClass, IMPORTED_OPERATION_ASPECT__OPERATION_NODE);

        // Create enums
        importTypeEEnum = createEEnum(IMPORT_TYPE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        ServicePackage theServicePackage = (ServicePackage)EPackage.Registry.INSTANCE.getEPackage(ServicePackage.eNS_URI);
        EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
        TechnologyPackage theTechnologyPackage = (TechnologyPackage)EPackage.Registry.INSTANCE.getEPackage(TechnologyPackage.eNS_URI);
        DataPackage theDataPackage = (DataPackage)EPackage.Registry.INSTANCE.getEPackage(DataPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        containerEClass.getESuperTypes().add(this.getOperationNode());
        infrastructureNodeEClass.getESuperTypes().add(this.getOperationNode());

        // Initialize classes, features, and operations; add parameters
        initEClass(operationModelEClass, OperationModel.class, "OperationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getOperationModel_Imports(), theServicePackage.getImport(), null, "imports", null, 1, -1, OperationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationModel_Containers(), this.getContainer(), this.getContainer_OperationModel(), "containers", null, 0, -1, OperationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationModel_InfrastructureNodes(), this.getInfrastructureNode(), this.getInfrastructureNode_OperationModel(), "infrastructureNodes", null, 0, -1, OperationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(operationNodeEClass, OperationNode.class, "OperationNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getOperationNode_Name(), theEcorePackage.getEString(), "name", null, 0, 1, OperationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationNode_Technologies(), theServicePackage.getImport(), null, "technologies", null, 1, -1, OperationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationNode_OperationEnvironment(), theTechnologyPackage.getOperationEnvironment(), null, "operationEnvironment", null, 0, 1, OperationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationNode_DeployedServices(), this.getImportedMicroservice(), this.getImportedMicroservice_OperationNode(), "deployedServices", null, 1, -1, OperationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationNode_DefaultServicePropertyValues(), theTechnologyPackage.getTechnologySpecificPropertyValueAssignment(), null, "defaultServicePropertyValues", null, 0, -1, OperationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationNode_DeploymentSpecifications(), this.getServiceDeploymentSpecification(), this.getServiceDeploymentSpecification_OperationNode(), "deploymentSpecifications", null, 0, -1, OperationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationNode_Aspects(), this.getImportedOperationAspect(), this.getImportedOperationAspect_OperationNode(), "aspects", null, 0, -1, OperationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(containerEClass, de.fhdo.ddmm.operation.Container.class, "Container", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getContainer_DeploymentTechnology(), this.getDeploymentTechnologyReference(), this.getDeploymentTechnologyReference_Container(), "deploymentTechnology", null, 0, 1, de.fhdo.ddmm.operation.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getContainer_DefaultBasicEndpoints(), this.getBasicEndpoint(), this.getBasicEndpoint_Container(), "defaultBasicEndpoints", null, 0, -1, de.fhdo.ddmm.operation.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getContainer_OperationModel(), this.getOperationModel(), this.getOperationModel_Containers(), "operationModel", null, 0, 1, de.fhdo.ddmm.operation.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(deploymentTechnologyReferenceEClass, DeploymentTechnologyReference.class, "DeploymentTechnologyReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDeploymentTechnologyReference_Import(), theServicePackage.getImport(), null, "import", null, 0, 1, DeploymentTechnologyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDeploymentTechnologyReference_DeploymentTechnology(), theTechnologyPackage.getDeploymentTechnology(), null, "deploymentTechnology", null, 0, 1, DeploymentTechnologyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDeploymentTechnologyReference_Container(), this.getContainer(), this.getContainer_DeploymentTechnology(), "container", null, 0, 1, DeploymentTechnologyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(infrastructureNodeEClass, InfrastructureNode.class, "InfrastructureNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getInfrastructureNode_InfrastructureTechnology(), this.getInfrastructureTechnologyReference(), this.getInfrastructureTechnologyReference_InfrastructureNode(), "infrastructureTechnology", null, 0, 1, InfrastructureNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInfrastructureNode_Endpoints(), this.getBasicEndpoint(), this.getBasicEndpoint_InfrastructureNode(), "endpoints", null, 0, -1, InfrastructureNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInfrastructureNode_OperationModel(), this.getOperationModel(), this.getOperationModel_InfrastructureNodes(), "operationModel", null, 0, 1, InfrastructureNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(infrastructureTechnologyReferenceEClass, InfrastructureTechnologyReference.class, "InfrastructureTechnologyReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getInfrastructureTechnologyReference_Import(), theServicePackage.getImport(), null, "import", null, 0, 1, InfrastructureTechnologyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInfrastructureTechnologyReference_InfrastructureTechnology(), theTechnologyPackage.getInfrastructureTechnology(), null, "infrastructureTechnology", null, 0, 1, InfrastructureTechnologyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInfrastructureTechnologyReference_InfrastructureNode(), this.getInfrastructureNode(), this.getInfrastructureNode_InfrastructureTechnology(), "infrastructureNode", null, 0, 1, InfrastructureTechnologyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(importedMicroserviceEClass, ImportedMicroservice.class, "ImportedMicroservice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getImportedMicroservice_Import(), theServicePackage.getImport(), null, "import", null, 0, 1, ImportedMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getImportedMicroservice_Microservice(), theServicePackage.getMicroservice(), null, "microservice", null, 0, 1, ImportedMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getImportedMicroservice_OperationNode(), this.getOperationNode(), this.getOperationNode_DeployedServices(), "operationNode", null, 0, 1, ImportedMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(serviceDeploymentSpecificationEClass, ServiceDeploymentSpecification.class, "ServiceDeploymentSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getServiceDeploymentSpecification_Import(), theServicePackage.getImport(), null, "import", null, 0, 1, ServiceDeploymentSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getServiceDeploymentSpecification_Service(), this.getImportedMicroservice(), null, "service", null, 0, 1, ServiceDeploymentSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getServiceDeploymentSpecification_ServicePropertyValues(), theTechnologyPackage.getTechnologySpecificPropertyValueAssignment(), null, "servicePropertyValues", null, 0, -1, ServiceDeploymentSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getServiceDeploymentSpecification_BasicEndpoints(), this.getBasicEndpoint(), this.getBasicEndpoint_DeploymentSpecification(), "basicEndpoints", null, 0, -1, ServiceDeploymentSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getServiceDeploymentSpecification_OperationNode(), this.getOperationNode(), this.getOperationNode_DeploymentSpecifications(), "operationNode", null, 0, 1, ServiceDeploymentSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(protocolAndDataFormatEClass, ProtocolAndDataFormat.class, "ProtocolAndDataFormat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getProtocolAndDataFormat_Technology(), theServicePackage.getImport(), null, "technology", null, 0, 1, ProtocolAndDataFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getProtocolAndDataFormat_Protocol(), theTechnologyPackage.getProtocol(), null, "protocol", null, 0, 1, ProtocolAndDataFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getProtocolAndDataFormat_DataFormat(), theTechnologyPackage.getDataFormat(), null, "dataFormat", null, 0, 1, ProtocolAndDataFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getProtocolAndDataFormat_Endpoint(), this.getBasicEndpoint(), this.getBasicEndpoint_Protocols(), "endpoint", null, 0, 1, ProtocolAndDataFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(basicEndpointEClass, BasicEndpoint.class, "BasicEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getBasicEndpoint_Addresses(), theEcorePackage.getEString(), "addresses", null, 1, -1, BasicEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getBasicEndpoint_Protocols(), this.getProtocolAndDataFormat(), this.getProtocolAndDataFormat_Endpoint(), "protocols", null, 1, -1, BasicEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getBasicEndpoint_Container(), this.getContainer(), this.getContainer_DefaultBasicEndpoints(), "container", null, 0, 1, BasicEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getBasicEndpoint_InfrastructureNode(), this.getInfrastructureNode(), this.getInfrastructureNode_Endpoints(), "infrastructureNode", null, 0, 1, BasicEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getBasicEndpoint_DeploymentSpecification(), this.getServiceDeploymentSpecification(), this.getServiceDeploymentSpecification_BasicEndpoints(), "deploymentSpecification", null, 0, 1, BasicEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(importedOperationAspectEClass, ImportedOperationAspect.class, "ImportedOperationAspect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getImportedOperationAspect_Technology(), theServicePackage.getImport(), null, "technology", null, 0, 1, ImportedOperationAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getImportedOperationAspect_Aspect(), theTechnologyPackage.getOperationAspect(), null, "aspect", null, 0, 1, ImportedOperationAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getImportedOperationAspect_SinglePropertyValue(), theDataPackage.getPrimitiveValue(), null, "singlePropertyValue", null, 0, 1, ImportedOperationAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getImportedOperationAspect_Values(), theTechnologyPackage.getTechnologySpecificPropertyValueAssignment(), null, "values", null, 0, -1, ImportedOperationAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getImportedOperationAspect_OperationNode(), this.getOperationNode(), this.getOperationNode_Aspects(), "operationNode", null, 0, 1, ImportedOperationAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(importTypeEEnum, ImportType.class, "ImportType");
        addEEnumLiteral(importTypeEEnum, ImportType.TECHNOLOGY);
        addEEnumLiteral(importTypeEEnum, ImportType.MICROSERVICES);

        // Create resource
        createResource(eNS_URI);
    }

} //OperationPackageImpl
