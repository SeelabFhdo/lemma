/**
 */
package de.fhdo.ddmm.technology.mapping.impl;

import de.fhdo.ddmm.technology.mapping.*;

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
public class MappingFactoryImpl extends EFactoryImpl implements MappingFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static MappingFactory init() {
        try {
            MappingFactory theMappingFactory = (MappingFactory)EPackage.Registry.INSTANCE.getEFactory(MappingPackage.eNS_URI);
            if (theMappingFactory != null) {
                return theMappingFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new MappingFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MappingFactoryImpl() {
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
            case MappingPackage.TECHNOLOGY_MAPPING: return createTechnologyMapping();
            case MappingPackage.MICROSERVICE_MAPPING: return createMicroserviceMapping();
            case MappingPackage.IMPORTED_MICROSERVICE: return createImportedMicroservice();
            case MappingPackage.INTERFACE_MAPPING: return createInterfaceMapping();
            case MappingPackage.OPERATION_MAPPING: return createOperationMapping();
            case MappingPackage.REFERRED_OPERATION_MAPPING: return createReferredOperationMapping();
            case MappingPackage.PRIMITIVE_PARAMETER_MAPPING: return createPrimitiveParameterMapping();
            case MappingPackage.COMPLEX_PARAMETER_MAPPING: return createComplexParameterMapping();
            case MappingPackage.TECHNOLOGY_SPECIFIC_DATA_FIELD_TYPE_MAPPING: return createTechnologySpecificDataFieldTypeMapping();
            case MappingPackage.DATA_FIELD_HIERARCHY: return createDataFieldHierarchy();
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION: return createTechnologySpecificProtocolSpecification();
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL: return createTechnologySpecificProtocol();
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT: return createTechnologySpecificEndpoint();
            case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT: return createTechnologySpecificImportedServiceAspect();
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
    public TechnologyMapping createTechnologyMapping() {
        TechnologyMappingImpl technologyMapping = new TechnologyMappingImpl();
        return technologyMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public MicroserviceMapping createMicroserviceMapping() {
        MicroserviceMappingImpl microserviceMapping = new MicroserviceMappingImpl();
        return microserviceMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ImportedMicroservice createImportedMicroservice() {
        ImportedMicroserviceImpl importedMicroservice = new ImportedMicroserviceImpl();
        return importedMicroservice;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public InterfaceMapping createInterfaceMapping() {
        InterfaceMappingImpl interfaceMapping = new InterfaceMappingImpl();
        return interfaceMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public OperationMapping createOperationMapping() {
        OperationMappingImpl operationMapping = new OperationMappingImpl();
        return operationMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ReferredOperationMapping createReferredOperationMapping() {
        ReferredOperationMappingImpl referredOperationMapping = new ReferredOperationMappingImpl();
        return referredOperationMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PrimitiveParameterMapping createPrimitiveParameterMapping() {
        PrimitiveParameterMappingImpl primitiveParameterMapping = new PrimitiveParameterMappingImpl();
        return primitiveParameterMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ComplexParameterMapping createComplexParameterMapping() {
        ComplexParameterMappingImpl complexParameterMapping = new ComplexParameterMappingImpl();
        return complexParameterMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public TechnologySpecificDataFieldTypeMapping createTechnologySpecificDataFieldTypeMapping() {
        TechnologySpecificDataFieldTypeMappingImpl technologySpecificDataFieldTypeMapping = new TechnologySpecificDataFieldTypeMappingImpl();
        return technologySpecificDataFieldTypeMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DataFieldHierarchy createDataFieldHierarchy() {
        DataFieldHierarchyImpl dataFieldHierarchy = new DataFieldHierarchyImpl();
        return dataFieldHierarchy;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public TechnologySpecificProtocolSpecification createTechnologySpecificProtocolSpecification() {
        TechnologySpecificProtocolSpecificationImpl technologySpecificProtocolSpecification = new TechnologySpecificProtocolSpecificationImpl();
        return technologySpecificProtocolSpecification;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public TechnologySpecificProtocol createTechnologySpecificProtocol() {
        TechnologySpecificProtocolImpl technologySpecificProtocol = new TechnologySpecificProtocolImpl();
        return technologySpecificProtocol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public TechnologySpecificEndpoint createTechnologySpecificEndpoint() {
        TechnologySpecificEndpointImpl technologySpecificEndpoint = new TechnologySpecificEndpointImpl();
        return technologySpecificEndpoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public TechnologySpecificImportedServiceAspect createTechnologySpecificImportedServiceAspect() {
        TechnologySpecificImportedServiceAspectImpl technologySpecificImportedServiceAspect = new TechnologySpecificImportedServiceAspectImpl();
        return technologySpecificImportedServiceAspect;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public MappingPackage getMappingPackage() {
        return (MappingPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static MappingPackage getPackage() {
        return MappingPackage.eINSTANCE;
    }

} //MappingFactoryImpl
