/**
 */
package de.fhdo.ddmm.technology.mapping.impl;

import de.fhdo.ddmm.data.DataPackage;

import de.fhdo.ddmm.service.ServicePackage;

import de.fhdo.ddmm.technology.TechnologyPackage;

import de.fhdo.ddmm.technology.mapping.ComplexParameterMapping;
import de.fhdo.ddmm.technology.mapping.DataFieldHierarchy;
import de.fhdo.ddmm.technology.mapping.ImportedMicroservice;
import de.fhdo.ddmm.technology.mapping.InterfaceMapping;
import de.fhdo.ddmm.technology.mapping.MappingFactory;
import de.fhdo.ddmm.technology.mapping.MappingPackage;
import de.fhdo.ddmm.technology.mapping.MicroserviceMapping;
import de.fhdo.ddmm.technology.mapping.OperationMapping;
import de.fhdo.ddmm.technology.mapping.ParameterMapping;
import de.fhdo.ddmm.technology.mapping.PrimitiveParameterMapping;
import de.fhdo.ddmm.technology.mapping.ReferredOperationMapping;
import de.fhdo.ddmm.technology.mapping.TechnologyMapping;
import de.fhdo.ddmm.technology.mapping.TechnologySpecificDataFieldTypeMapping;
import de.fhdo.ddmm.technology.mapping.TechnologySpecificEndpoint;
import de.fhdo.ddmm.technology.mapping.TechnologySpecificImportedServiceAspect;
import de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocol;
import de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocolSpecification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
public class MappingPackageImpl extends EPackageImpl implements MappingPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technologyMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass microserviceMappingEClass = null;

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
    private EClass interfaceMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass operationMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass referredOperationMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass parameterMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass primitiveParameterMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass complexParameterMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technologySpecificDataFieldTypeMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataFieldHierarchyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technologySpecificProtocolSpecificationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technologySpecificProtocolEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technologySpecificEndpointEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technologySpecificImportedServiceAspectEClass = null;

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
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private MappingPackageImpl() {
        super(eNS_URI, MappingFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link MappingPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static MappingPackage init() {
        if (isInited) return (MappingPackage)EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI);

        // Obtain or create and register package
        MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MappingPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        ServicePackage.eINSTANCE.eClass();
        TechnologyPackage.eINSTANCE.eClass();
        DataPackage.eINSTANCE.eClass();
        EcorePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theMappingPackage.createPackageContents();

        // Initialize created meta-data
        theMappingPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theMappingPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(MappingPackage.eNS_URI, theMappingPackage);
        return theMappingPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnologyMapping() {
        return technologyMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologyMapping_Imports() {
        return (EReference)technologyMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologyMapping_Mappings() {
        return (EReference)technologyMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getTechnologyMapping__GetMappedInterfaces() {
        return technologyMappingEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getTechnologyMapping__GetMappedOperations() {
        return technologyMappingEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getTechnologyMapping__GetMappedReferredOperations() {
        return technologyMappingEClass.getEOperations().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMicroserviceMapping() {
        return microserviceMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceMapping_Technologies() {
        return (EReference)microserviceMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceMapping_Microservice() {
        return (EReference)microserviceMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceMapping_Endpoints() {
        return (EReference)microserviceMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceMapping_Protocols() {
        return (EReference)microserviceMappingEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceMapping_InterfaceMappings() {
        return (EReference)microserviceMappingEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceMapping_OperationMappings() {
        return (EReference)microserviceMappingEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceMapping_ReferredOperationMappings() {
        return (EReference)microserviceMappingEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceMapping_Aspects() {
        return (EReference)microserviceMappingEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceMapping_MappingModel() {
        return (EReference)microserviceMappingEClass.getEStructuralFeatures().get(8);
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
    public EReference getImportedMicroservice_MicroserviceMapping() {
        return (EReference)importedMicroserviceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInterfaceMapping() {
        return interfaceMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInterfaceMapping_Interface() {
        return (EReference)interfaceMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInterfaceMapping_Endpoints() {
        return (EReference)interfaceMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInterfaceMapping_Protocols() {
        return (EReference)interfaceMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInterfaceMapping_Aspects() {
        return (EReference)interfaceMappingEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInterfaceMapping_MicroserviceMapping() {
        return (EReference)interfaceMappingEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOperationMapping() {
        return operationMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationMapping_Operation() {
        return (EReference)operationMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationMapping_Endpoints() {
        return (EReference)operationMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationMapping_Protocols() {
        return (EReference)operationMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationMapping_ParameterMappings() {
        return (EReference)operationMappingEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationMapping_Aspects() {
        return (EReference)operationMappingEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationMapping_MicroserviceMapping() {
        return (EReference)operationMappingEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getReferredOperationMapping() {
        return referredOperationMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getReferredOperationMapping_Operation() {
        return (EReference)referredOperationMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getReferredOperationMapping_Endpoints() {
        return (EReference)referredOperationMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getReferredOperationMapping_Protocols() {
        return (EReference)referredOperationMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getReferredOperationMapping_Aspects() {
        return (EReference)referredOperationMappingEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getReferredOperationMapping_MicroserviceMapping() {
        return (EReference)referredOperationMappingEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getParameterMapping() {
        return parameterMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getParameterMapping_Parameter() {
        return (EReference)parameterMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getParameterMapping_Aspects() {
        return (EReference)parameterMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getParameterMapping_OperationMapping() {
        return (EReference)parameterMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPrimitiveParameterMapping() {
        return primitiveParameterMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPrimitiveParameterMapping_Technology() {
        return (EReference)primitiveParameterMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPrimitiveParameterMapping_PrimitiveType() {
        return (EReference)primitiveParameterMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getComplexParameterMapping() {
        return complexParameterMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComplexParameterMapping_Technology() {
        return (EReference)complexParameterMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComplexParameterMapping_TechnologySpecificComplexType() {
        return (EReference)complexParameterMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComplexParameterMapping_DataFieldMappings() {
        return (EReference)complexParameterMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnologySpecificDataFieldTypeMapping() {
        return technologySpecificDataFieldTypeMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificDataFieldTypeMapping_Technology() {
        return (EReference)technologySpecificDataFieldTypeMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificDataFieldTypeMapping_Type() {
        return (EReference)technologySpecificDataFieldTypeMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificDataFieldTypeMapping_DataFieldHierarchy() {
        return (EReference)technologySpecificDataFieldTypeMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificDataFieldTypeMapping_Aspects() {
        return (EReference)technologySpecificDataFieldTypeMappingEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificDataFieldTypeMapping_ParameterMapping() {
        return (EReference)technologySpecificDataFieldTypeMappingEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDataFieldHierarchy() {
        return dataFieldHierarchyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataFieldHierarchy_DataFields() {
        return (EReference)dataFieldHierarchyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataFieldHierarchy_Previous() {
        return (EReference)dataFieldHierarchyEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataFieldHierarchy_Mapping() {
        return (EReference)dataFieldHierarchyEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnologySpecificProtocolSpecification() {
        return technologySpecificProtocolSpecificationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTechnologySpecificProtocolSpecification_CommunicationType() {
        return (EAttribute)technologySpecificProtocolSpecificationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificProtocolSpecification_TechnologySpecificProtocol() {
        return (EReference)technologySpecificProtocolSpecificationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnologySpecificProtocol() {
        return technologySpecificProtocolEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificProtocol_Technology() {
        return (EReference)technologySpecificProtocolEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificProtocol_Protocol() {
        return (EReference)technologySpecificProtocolEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificProtocol_DataFormat() {
        return (EReference)technologySpecificProtocolEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificProtocol_ProtocolSpecification() {
        return (EReference)technologySpecificProtocolEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificProtocol_Endpoint() {
        return (EReference)technologySpecificProtocolEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnologySpecificEndpoint() {
        return technologySpecificEndpointEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTechnologySpecificEndpoint_Addresses() {
        return (EAttribute)technologySpecificEndpointEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificEndpoint_TechnologySpecificProtocols() {
        return (EReference)technologySpecificEndpointEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificEndpoint_MicroserviceMapping() {
        return (EReference)technologySpecificEndpointEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificEndpoint_InterfaceMapping() {
        return (EReference)technologySpecificEndpointEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificEndpoint_OperationMapping() {
        return (EReference)technologySpecificEndpointEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificEndpoint_ReferredOperationMapping() {
        return (EReference)technologySpecificEndpointEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnologySpecificImportedServiceAspect() {
        return technologySpecificImportedServiceAspectEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_Technology() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_Aspect() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_SinglePropertyValue() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_Values() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_MicroserviceMapping() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_InterfaceMapping() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_OperationMapping() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_ReferredOperationMapping() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_ParameterMapping() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_DataFieldMapping() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MappingFactory getMappingFactory() {
        return (MappingFactory)getEFactoryInstance();
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
        technologyMappingEClass = createEClass(TECHNOLOGY_MAPPING);
        createEReference(technologyMappingEClass, TECHNOLOGY_MAPPING__IMPORTS);
        createEReference(technologyMappingEClass, TECHNOLOGY_MAPPING__MAPPINGS);
        createEOperation(technologyMappingEClass, TECHNOLOGY_MAPPING___GET_MAPPED_INTERFACES);
        createEOperation(technologyMappingEClass, TECHNOLOGY_MAPPING___GET_MAPPED_OPERATIONS);
        createEOperation(technologyMappingEClass, TECHNOLOGY_MAPPING___GET_MAPPED_REFERRED_OPERATIONS);

        microserviceMappingEClass = createEClass(MICROSERVICE_MAPPING);
        createEReference(microserviceMappingEClass, MICROSERVICE_MAPPING__TECHNOLOGIES);
        createEReference(microserviceMappingEClass, MICROSERVICE_MAPPING__MICROSERVICE);
        createEReference(microserviceMappingEClass, MICROSERVICE_MAPPING__ENDPOINTS);
        createEReference(microserviceMappingEClass, MICROSERVICE_MAPPING__PROTOCOLS);
        createEReference(microserviceMappingEClass, MICROSERVICE_MAPPING__INTERFACE_MAPPINGS);
        createEReference(microserviceMappingEClass, MICROSERVICE_MAPPING__OPERATION_MAPPINGS);
        createEReference(microserviceMappingEClass, MICROSERVICE_MAPPING__REFERRED_OPERATION_MAPPINGS);
        createEReference(microserviceMappingEClass, MICROSERVICE_MAPPING__ASPECTS);
        createEReference(microserviceMappingEClass, MICROSERVICE_MAPPING__MAPPING_MODEL);

        importedMicroserviceEClass = createEClass(IMPORTED_MICROSERVICE);
        createEReference(importedMicroserviceEClass, IMPORTED_MICROSERVICE__IMPORT);
        createEReference(importedMicroserviceEClass, IMPORTED_MICROSERVICE__MICROSERVICE);
        createEReference(importedMicroserviceEClass, IMPORTED_MICROSERVICE__MICROSERVICE_MAPPING);

        interfaceMappingEClass = createEClass(INTERFACE_MAPPING);
        createEReference(interfaceMappingEClass, INTERFACE_MAPPING__INTERFACE);
        createEReference(interfaceMappingEClass, INTERFACE_MAPPING__ENDPOINTS);
        createEReference(interfaceMappingEClass, INTERFACE_MAPPING__PROTOCOLS);
        createEReference(interfaceMappingEClass, INTERFACE_MAPPING__ASPECTS);
        createEReference(interfaceMappingEClass, INTERFACE_MAPPING__MICROSERVICE_MAPPING);

        operationMappingEClass = createEClass(OPERATION_MAPPING);
        createEReference(operationMappingEClass, OPERATION_MAPPING__OPERATION);
        createEReference(operationMappingEClass, OPERATION_MAPPING__ENDPOINTS);
        createEReference(operationMappingEClass, OPERATION_MAPPING__PROTOCOLS);
        createEReference(operationMappingEClass, OPERATION_MAPPING__PARAMETER_MAPPINGS);
        createEReference(operationMappingEClass, OPERATION_MAPPING__ASPECTS);
        createEReference(operationMappingEClass, OPERATION_MAPPING__MICROSERVICE_MAPPING);

        referredOperationMappingEClass = createEClass(REFERRED_OPERATION_MAPPING);
        createEReference(referredOperationMappingEClass, REFERRED_OPERATION_MAPPING__OPERATION);
        createEReference(referredOperationMappingEClass, REFERRED_OPERATION_MAPPING__ENDPOINTS);
        createEReference(referredOperationMappingEClass, REFERRED_OPERATION_MAPPING__PROTOCOLS);
        createEReference(referredOperationMappingEClass, REFERRED_OPERATION_MAPPING__ASPECTS);
        createEReference(referredOperationMappingEClass, REFERRED_OPERATION_MAPPING__MICROSERVICE_MAPPING);

        parameterMappingEClass = createEClass(PARAMETER_MAPPING);
        createEReference(parameterMappingEClass, PARAMETER_MAPPING__PARAMETER);
        createEReference(parameterMappingEClass, PARAMETER_MAPPING__ASPECTS);
        createEReference(parameterMappingEClass, PARAMETER_MAPPING__OPERATION_MAPPING);

        primitiveParameterMappingEClass = createEClass(PRIMITIVE_PARAMETER_MAPPING);
        createEReference(primitiveParameterMappingEClass, PRIMITIVE_PARAMETER_MAPPING__TECHNOLOGY);
        createEReference(primitiveParameterMappingEClass, PRIMITIVE_PARAMETER_MAPPING__PRIMITIVE_TYPE);

        complexParameterMappingEClass = createEClass(COMPLEX_PARAMETER_MAPPING);
        createEReference(complexParameterMappingEClass, COMPLEX_PARAMETER_MAPPING__TECHNOLOGY);
        createEReference(complexParameterMappingEClass, COMPLEX_PARAMETER_MAPPING__TECHNOLOGY_SPECIFIC_COMPLEX_TYPE);
        createEReference(complexParameterMappingEClass, COMPLEX_PARAMETER_MAPPING__DATA_FIELD_MAPPINGS);

        technologySpecificDataFieldTypeMappingEClass = createEClass(TECHNOLOGY_SPECIFIC_DATA_FIELD_TYPE_MAPPING);
        createEReference(technologySpecificDataFieldTypeMappingEClass, TECHNOLOGY_SPECIFIC_DATA_FIELD_TYPE_MAPPING__TECHNOLOGY);
        createEReference(technologySpecificDataFieldTypeMappingEClass, TECHNOLOGY_SPECIFIC_DATA_FIELD_TYPE_MAPPING__TYPE);
        createEReference(technologySpecificDataFieldTypeMappingEClass, TECHNOLOGY_SPECIFIC_DATA_FIELD_TYPE_MAPPING__DATA_FIELD_HIERARCHY);
        createEReference(technologySpecificDataFieldTypeMappingEClass, TECHNOLOGY_SPECIFIC_DATA_FIELD_TYPE_MAPPING__ASPECTS);
        createEReference(technologySpecificDataFieldTypeMappingEClass, TECHNOLOGY_SPECIFIC_DATA_FIELD_TYPE_MAPPING__PARAMETER_MAPPING);

        dataFieldHierarchyEClass = createEClass(DATA_FIELD_HIERARCHY);
        createEReference(dataFieldHierarchyEClass, DATA_FIELD_HIERARCHY__DATA_FIELDS);
        createEReference(dataFieldHierarchyEClass, DATA_FIELD_HIERARCHY__PREVIOUS);
        createEReference(dataFieldHierarchyEClass, DATA_FIELD_HIERARCHY__MAPPING);

        technologySpecificProtocolSpecificationEClass = createEClass(TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION);
        createEAttribute(technologySpecificProtocolSpecificationEClass, TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE);
        createEReference(technologySpecificProtocolSpecificationEClass, TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__TECHNOLOGY_SPECIFIC_PROTOCOL);

        technologySpecificProtocolEClass = createEClass(TECHNOLOGY_SPECIFIC_PROTOCOL);
        createEReference(technologySpecificProtocolEClass, TECHNOLOGY_SPECIFIC_PROTOCOL__TECHNOLOGY);
        createEReference(technologySpecificProtocolEClass, TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL);
        createEReference(technologySpecificProtocolEClass, TECHNOLOGY_SPECIFIC_PROTOCOL__DATA_FORMAT);
        createEReference(technologySpecificProtocolEClass, TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL_SPECIFICATION);
        createEReference(technologySpecificProtocolEClass, TECHNOLOGY_SPECIFIC_PROTOCOL__ENDPOINT);

        technologySpecificEndpointEClass = createEClass(TECHNOLOGY_SPECIFIC_ENDPOINT);
        createEAttribute(technologySpecificEndpointEClass, TECHNOLOGY_SPECIFIC_ENDPOINT__ADDRESSES);
        createEReference(technologySpecificEndpointEClass, TECHNOLOGY_SPECIFIC_ENDPOINT__TECHNOLOGY_SPECIFIC_PROTOCOLS);
        createEReference(technologySpecificEndpointEClass, TECHNOLOGY_SPECIFIC_ENDPOINT__MICROSERVICE_MAPPING);
        createEReference(technologySpecificEndpointEClass, TECHNOLOGY_SPECIFIC_ENDPOINT__INTERFACE_MAPPING);
        createEReference(technologySpecificEndpointEClass, TECHNOLOGY_SPECIFIC_ENDPOINT__OPERATION_MAPPING);
        createEReference(technologySpecificEndpointEClass, TECHNOLOGY_SPECIFIC_ENDPOINT__REFERRED_OPERATION_MAPPING);

        technologySpecificImportedServiceAspectEClass = createEClass(TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TECHNOLOGY);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__ASPECT);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__VALUES);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__MICROSERVICE_MAPPING);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__INTERFACE_MAPPING);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__OPERATION_MAPPING);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION_MAPPING);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__PARAMETER_MAPPING);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_FIELD_MAPPING);
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
        TechnologyPackage theTechnologyPackage = (TechnologyPackage)EPackage.Registry.INSTANCE.getEPackage(TechnologyPackage.eNS_URI);
        DataPackage theDataPackage = (DataPackage)EPackage.Registry.INSTANCE.getEPackage(DataPackage.eNS_URI);
        EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        primitiveParameterMappingEClass.getESuperTypes().add(this.getParameterMapping());
        complexParameterMappingEClass.getESuperTypes().add(this.getParameterMapping());

        // Initialize classes, features, and operations; add parameters
        initEClass(technologyMappingEClass, TechnologyMapping.class, "TechnologyMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTechnologyMapping_Imports(), theServicePackage.getImport(), null, "imports", null, 1, -1, TechnologyMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologyMapping_Mappings(), this.getMicroserviceMapping(), this.getMicroserviceMapping_MappingModel(), "mappings", null, 1, -1, TechnologyMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getTechnologyMapping__GetMappedInterfaces(), this.getInterfaceMapping(), "getMappedInterfaces", 0, -1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getTechnologyMapping__GetMappedOperations(), this.getOperationMapping(), "getMappedOperations", 0, -1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getTechnologyMapping__GetMappedReferredOperations(), this.getReferredOperationMapping(), "getMappedReferredOperations", 0, -1, !IS_UNIQUE, IS_ORDERED);

        initEClass(microserviceMappingEClass, MicroserviceMapping.class, "MicroserviceMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getMicroserviceMapping_Technologies(), theServicePackage.getImport(), null, "technologies", null, 1, -1, MicroserviceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicroserviceMapping_Microservice(), this.getImportedMicroservice(), this.getImportedMicroservice_MicroserviceMapping(), "microservice", null, 0, 1, MicroserviceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicroserviceMapping_Endpoints(), this.getTechnologySpecificEndpoint(), this.getTechnologySpecificEndpoint_MicroserviceMapping(), "endpoints", null, 0, -1, MicroserviceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicroserviceMapping_Protocols(), this.getTechnologySpecificProtocolSpecification(), null, "protocols", null, 0, -1, MicroserviceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicroserviceMapping_InterfaceMappings(), this.getInterfaceMapping(), this.getInterfaceMapping_MicroserviceMapping(), "interfaceMappings", null, 0, -1, MicroserviceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicroserviceMapping_OperationMappings(), this.getOperationMapping(), this.getOperationMapping_MicroserviceMapping(), "operationMappings", null, 0, -1, MicroserviceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicroserviceMapping_ReferredOperationMappings(), this.getReferredOperationMapping(), this.getReferredOperationMapping_MicroserviceMapping(), "referredOperationMappings", null, 0, -1, MicroserviceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicroserviceMapping_Aspects(), this.getTechnologySpecificImportedServiceAspect(), this.getTechnologySpecificImportedServiceAspect_MicroserviceMapping(), "aspects", null, 0, -1, MicroserviceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicroserviceMapping_MappingModel(), this.getTechnologyMapping(), this.getTechnologyMapping_Mappings(), "mappingModel", null, 0, 1, MicroserviceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(importedMicroserviceEClass, ImportedMicroservice.class, "ImportedMicroservice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getImportedMicroservice_Import(), theServicePackage.getImport(), null, "import", null, 0, 1, ImportedMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getImportedMicroservice_Microservice(), theServicePackage.getMicroservice(), null, "microservice", null, 0, 1, ImportedMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getImportedMicroservice_MicroserviceMapping(), this.getMicroserviceMapping(), this.getMicroserviceMapping_Microservice(), "microserviceMapping", null, 0, 1, ImportedMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(interfaceMappingEClass, InterfaceMapping.class, "InterfaceMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getInterfaceMapping_Interface(), theServicePackage.getInterface(), null, "interface", null, 0, 1, InterfaceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInterfaceMapping_Endpoints(), this.getTechnologySpecificEndpoint(), this.getTechnologySpecificEndpoint_InterfaceMapping(), "endpoints", null, 0, -1, InterfaceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInterfaceMapping_Protocols(), this.getTechnologySpecificProtocolSpecification(), null, "protocols", null, 0, -1, InterfaceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInterfaceMapping_Aspects(), this.getTechnologySpecificImportedServiceAspect(), this.getTechnologySpecificImportedServiceAspect_InterfaceMapping(), "aspects", null, 0, -1, InterfaceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInterfaceMapping_MicroserviceMapping(), this.getMicroserviceMapping(), this.getMicroserviceMapping_InterfaceMappings(), "microserviceMapping", null, 0, 1, InterfaceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(operationMappingEClass, OperationMapping.class, "OperationMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getOperationMapping_Operation(), theServicePackage.getOperation(), null, "operation", null, 0, 1, OperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationMapping_Endpoints(), this.getTechnologySpecificEndpoint(), this.getTechnologySpecificEndpoint_OperationMapping(), "endpoints", null, 0, -1, OperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationMapping_Protocols(), this.getTechnologySpecificProtocolSpecification(), null, "protocols", null, 0, -1, OperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationMapping_ParameterMappings(), this.getParameterMapping(), this.getParameterMapping_OperationMapping(), "parameterMappings", null, 0, -1, OperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationMapping_Aspects(), this.getTechnologySpecificImportedServiceAspect(), this.getTechnologySpecificImportedServiceAspect_OperationMapping(), "aspects", null, 0, -1, OperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationMapping_MicroserviceMapping(), this.getMicroserviceMapping(), this.getMicroserviceMapping_OperationMappings(), "microserviceMapping", null, 0, 1, OperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(referredOperationMappingEClass, ReferredOperationMapping.class, "ReferredOperationMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getReferredOperationMapping_Operation(), theServicePackage.getReferredOperation(), null, "operation", null, 0, 1, ReferredOperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReferredOperationMapping_Endpoints(), this.getTechnologySpecificEndpoint(), this.getTechnologySpecificEndpoint_ReferredOperationMapping(), "endpoints", null, 0, -1, ReferredOperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReferredOperationMapping_Protocols(), this.getTechnologySpecificProtocolSpecification(), null, "protocols", null, 0, -1, ReferredOperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReferredOperationMapping_Aspects(), this.getTechnologySpecificImportedServiceAspect(), this.getTechnologySpecificImportedServiceAspect_ReferredOperationMapping(), "aspects", null, 0, -1, ReferredOperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReferredOperationMapping_MicroserviceMapping(), this.getMicroserviceMapping(), this.getMicroserviceMapping_ReferredOperationMappings(), "microserviceMapping", null, 0, 1, ReferredOperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(parameterMappingEClass, ParameterMapping.class, "ParameterMapping", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getParameterMapping_Parameter(), theServicePackage.getParameter(), null, "parameter", null, 0, 1, ParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getParameterMapping_Aspects(), this.getTechnologySpecificImportedServiceAspect(), this.getTechnologySpecificImportedServiceAspect_ParameterMapping(), "aspects", null, 0, -1, ParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getParameterMapping_OperationMapping(), this.getOperationMapping(), this.getOperationMapping_ParameterMappings(), "operationMapping", null, 0, 1, ParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(primitiveParameterMappingEClass, PrimitiveParameterMapping.class, "PrimitiveParameterMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPrimitiveParameterMapping_Technology(), theServicePackage.getImport(), null, "technology", null, 0, 1, PrimitiveParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPrimitiveParameterMapping_PrimitiveType(), theTechnologyPackage.getTechnologySpecificPrimitiveType(), null, "primitiveType", null, 0, 1, PrimitiveParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(complexParameterMappingEClass, ComplexParameterMapping.class, "ComplexParameterMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getComplexParameterMapping_Technology(), theServicePackage.getImport(), null, "technology", null, 0, 1, ComplexParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComplexParameterMapping_TechnologySpecificComplexType(), theDataPackage.getComplexType(), null, "technologySpecificComplexType", null, 0, 1, ComplexParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComplexParameterMapping_DataFieldMappings(), this.getTechnologySpecificDataFieldTypeMapping(), this.getTechnologySpecificDataFieldTypeMapping_ParameterMapping(), "dataFieldMappings", null, 0, -1, ComplexParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(technologySpecificDataFieldTypeMappingEClass, TechnologySpecificDataFieldTypeMapping.class, "TechnologySpecificDataFieldTypeMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTechnologySpecificDataFieldTypeMapping_Technology(), theServicePackage.getImport(), null, "technology", null, 0, 1, TechnologySpecificDataFieldTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificDataFieldTypeMapping_Type(), theDataPackage.getType(), null, "type", null, 0, 1, TechnologySpecificDataFieldTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificDataFieldTypeMapping_DataFieldHierarchy(), this.getDataFieldHierarchy(), this.getDataFieldHierarchy_Mapping(), "dataFieldHierarchy", null, 0, 1, TechnologySpecificDataFieldTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificDataFieldTypeMapping_Aspects(), this.getTechnologySpecificImportedServiceAspect(), this.getTechnologySpecificImportedServiceAspect_DataFieldMapping(), "aspects", null, 0, -1, TechnologySpecificDataFieldTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificDataFieldTypeMapping_ParameterMapping(), this.getComplexParameterMapping(), this.getComplexParameterMapping_DataFieldMappings(), "parameterMapping", null, 0, 1, TechnologySpecificDataFieldTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dataFieldHierarchyEClass, DataFieldHierarchy.class, "DataFieldHierarchy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDataFieldHierarchy_DataFields(), theDataPackage.getDataField(), null, "dataFields", null, 0, -1, DataFieldHierarchy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataFieldHierarchy_Previous(), this.getDataFieldHierarchy(), null, "previous", null, 0, 1, DataFieldHierarchy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataFieldHierarchy_Mapping(), this.getTechnologySpecificDataFieldTypeMapping(), this.getTechnologySpecificDataFieldTypeMapping_DataFieldHierarchy(), "mapping", null, 0, 1, DataFieldHierarchy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(technologySpecificProtocolSpecificationEClass, TechnologySpecificProtocolSpecification.class, "TechnologySpecificProtocolSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTechnologySpecificProtocolSpecification_CommunicationType(), theTechnologyPackage.getCommunicationType(), "communicationType", null, 0, 1, TechnologySpecificProtocolSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificProtocolSpecification_TechnologySpecificProtocol(), this.getTechnologySpecificProtocol(), this.getTechnologySpecificProtocol_ProtocolSpecification(), "technologySpecificProtocol", null, 0, 1, TechnologySpecificProtocolSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(technologySpecificProtocolEClass, TechnologySpecificProtocol.class, "TechnologySpecificProtocol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTechnologySpecificProtocol_Technology(), theServicePackage.getImport(), null, "technology", null, 0, 1, TechnologySpecificProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificProtocol_Protocol(), theTechnologyPackage.getProtocol(), null, "protocol", null, 0, 1, TechnologySpecificProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificProtocol_DataFormat(), theTechnologyPackage.getDataFormat(), null, "dataFormat", null, 0, 1, TechnologySpecificProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificProtocol_ProtocolSpecification(), this.getTechnologySpecificProtocolSpecification(), this.getTechnologySpecificProtocolSpecification_TechnologySpecificProtocol(), "protocolSpecification", null, 0, 1, TechnologySpecificProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificProtocol_Endpoint(), this.getTechnologySpecificEndpoint(), this.getTechnologySpecificEndpoint_TechnologySpecificProtocols(), "endpoint", null, 0, 1, TechnologySpecificProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(technologySpecificEndpointEClass, TechnologySpecificEndpoint.class, "TechnologySpecificEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTechnologySpecificEndpoint_Addresses(), theEcorePackage.getEString(), "addresses", null, 1, -1, TechnologySpecificEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificEndpoint_TechnologySpecificProtocols(), this.getTechnologySpecificProtocol(), this.getTechnologySpecificProtocol_Endpoint(), "technologySpecificProtocols", null, 1, -1, TechnologySpecificEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificEndpoint_MicroserviceMapping(), this.getMicroserviceMapping(), this.getMicroserviceMapping_Endpoints(), "microserviceMapping", null, 0, 1, TechnologySpecificEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificEndpoint_InterfaceMapping(), this.getInterfaceMapping(), this.getInterfaceMapping_Endpoints(), "interfaceMapping", null, 0, 1, TechnologySpecificEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificEndpoint_OperationMapping(), this.getOperationMapping(), this.getOperationMapping_Endpoints(), "operationMapping", null, 0, 1, TechnologySpecificEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificEndpoint_ReferredOperationMapping(), this.getReferredOperationMapping(), this.getReferredOperationMapping_Endpoints(), "referredOperationMapping", null, 0, 1, TechnologySpecificEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(technologySpecificImportedServiceAspectEClass, TechnologySpecificImportedServiceAspect.class, "TechnologySpecificImportedServiceAspect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTechnologySpecificImportedServiceAspect_Technology(), theServicePackage.getImport(), null, "technology", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_Aspect(), theTechnologyPackage.getServiceAspect(), null, "aspect", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_SinglePropertyValue(), theDataPackage.getPrimitiveValue(), null, "singlePropertyValue", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_Values(), theTechnologyPackage.getTechnologySpecificPropertyValueAssignment(), null, "values", null, 0, -1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_MicroserviceMapping(), this.getMicroserviceMapping(), this.getMicroserviceMapping_Aspects(), "microserviceMapping", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_InterfaceMapping(), this.getInterfaceMapping(), this.getInterfaceMapping_Aspects(), "interfaceMapping", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_OperationMapping(), this.getOperationMapping(), this.getOperationMapping_Aspects(), "operationMapping", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_ReferredOperationMapping(), this.getReferredOperationMapping(), this.getReferredOperationMapping_Aspects(), "referredOperationMapping", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_ParameterMapping(), this.getParameterMapping(), this.getParameterMapping_Aspects(), "parameterMapping", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_DataFieldMapping(), this.getTechnologySpecificDataFieldTypeMapping(), this.getTechnologySpecificDataFieldTypeMapping_Aspects(), "dataFieldMapping", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //MappingPackageImpl
