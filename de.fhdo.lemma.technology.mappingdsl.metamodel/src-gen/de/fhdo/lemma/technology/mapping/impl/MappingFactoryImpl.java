/**
 */
package de.fhdo.lemma.technology.mapping.impl;

import de.fhdo.lemma.data.DataField;

import de.fhdo.lemma.technology.mapping.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
            case MappingPackage.COMPLEX_TYPE_MAPPING: return createComplexTypeMapping();
            case MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP: return createImportedComplexTypeToMap();
            case MappingPackage.MICROSERVICE_MAPPING: return createMicroserviceMapping();
            case MappingPackage.IMPORTED_MICROSERVICE: return createImportedMicroservice();
            case MappingPackage.INTERFACE_MAPPING: return createInterfaceMapping();
            case MappingPackage.OPERATION_MAPPING: return createOperationMapping();
            case MappingPackage.REFERRED_OPERATION_MAPPING: return createReferredOperationMapping();
            case MappingPackage.PRIMITIVE_PARAMETER_MAPPING: return createPrimitiveParameterMapping();
            case MappingPackage.COMPLEX_PARAMETER_MAPPING: return createComplexParameterMapping();
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING: return createTechnologySpecificFieldMapping();
            case MappingPackage.DATA_OPERATION_MAPPING: return createDataOperationMapping();
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING: return createDataOperationReturnTypeMapping();
            case MappingPackage.DATA_OPERATION_PARAMETER_MAPPING: return createDataOperationParameterMapping();
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
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case MappingPackage.DATA_FIELD_LIST:
                return createDataFieldListFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case MappingPackage.DATA_FIELD_LIST:
                return convertDataFieldListToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologyMapping createTechnologyMapping() {
        TechnologyMappingImpl technologyMapping = new TechnologyMappingImpl();
        return technologyMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComplexTypeMapping createComplexTypeMapping() {
        ComplexTypeMappingImpl complexTypeMapping = new ComplexTypeMappingImpl();
        return complexTypeMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ImportedComplexTypeToMap createImportedComplexTypeToMap() {
        ImportedComplexTypeToMapImpl importedComplexTypeToMap = new ImportedComplexTypeToMapImpl();
        return importedComplexTypeToMap;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MicroserviceMapping createMicroserviceMapping() {
        MicroserviceMappingImpl microserviceMapping = new MicroserviceMappingImpl();
        return microserviceMapping;
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
    public InterfaceMapping createInterfaceMapping() {
        InterfaceMappingImpl interfaceMapping = new InterfaceMappingImpl();
        return interfaceMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationMapping createOperationMapping() {
        OperationMappingImpl operationMapping = new OperationMappingImpl();
        return operationMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ReferredOperationMapping createReferredOperationMapping() {
        ReferredOperationMappingImpl referredOperationMapping = new ReferredOperationMappingImpl();
        return referredOperationMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveParameterMapping createPrimitiveParameterMapping() {
        PrimitiveParameterMappingImpl primitiveParameterMapping = new PrimitiveParameterMappingImpl();
        return primitiveParameterMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComplexParameterMapping createComplexParameterMapping() {
        ComplexParameterMappingImpl complexParameterMapping = new ComplexParameterMappingImpl();
        return complexParameterMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologySpecificFieldMapping createTechnologySpecificFieldMapping() {
        TechnologySpecificFieldMappingImpl technologySpecificFieldMapping = new TechnologySpecificFieldMappingImpl();
        return technologySpecificFieldMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataOperationMapping createDataOperationMapping() {
        DataOperationMappingImpl dataOperationMapping = new DataOperationMappingImpl();
        return dataOperationMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataOperationReturnTypeMapping createDataOperationReturnTypeMapping() {
        DataOperationReturnTypeMappingImpl dataOperationReturnTypeMapping = new DataOperationReturnTypeMappingImpl();
        return dataOperationReturnTypeMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataOperationParameterMapping createDataOperationParameterMapping() {
        DataOperationParameterMappingImpl dataOperationParameterMapping = new DataOperationParameterMappingImpl();
        return dataOperationParameterMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologySpecificProtocolSpecification createTechnologySpecificProtocolSpecification() {
        TechnologySpecificProtocolSpecificationImpl technologySpecificProtocolSpecification = new TechnologySpecificProtocolSpecificationImpl();
        return technologySpecificProtocolSpecification;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologySpecificProtocol createTechnologySpecificProtocol() {
        TechnologySpecificProtocolImpl technologySpecificProtocol = new TechnologySpecificProtocolImpl();
        return technologySpecificProtocol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologySpecificEndpoint createTechnologySpecificEndpoint() {
        TechnologySpecificEndpointImpl technologySpecificEndpoint = new TechnologySpecificEndpointImpl();
        return technologySpecificEndpoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologySpecificImportedServiceAspect createTechnologySpecificImportedServiceAspect() {
        TechnologySpecificImportedServiceAspectImpl technologySpecificImportedServiceAspect = new TechnologySpecificImportedServiceAspectImpl();
        return technologySpecificImportedServiceAspect;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public List<DataField> createDataFieldListFromString(EDataType eDataType, String initialValue) {
        return (List<DataField>)super.createFromString(initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertDataFieldListToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
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
