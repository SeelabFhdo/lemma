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
            case MappingPackage.IMPORTED_COMPLEX_TYPE: return createImportedComplexType();
            case MappingPackage.MICROSERVICE_MAPPING: return createMicroserviceMapping();
            case MappingPackage.IMPORTED_MICROSERVICE: return createImportedMicroservice();
            case MappingPackage.INTERFACE_MAPPING: return createInterfaceMapping();
            case MappingPackage.OPERATION_MAPPING: return createOperationMapping();
            case MappingPackage.REFERRED_OPERATION_MAPPING: return createReferredOperationMapping();
            case MappingPackage.PRIMITIVE_PARAMETER_MAPPING: return createPrimitiveParameterMapping();
            case MappingPackage.COMPLEX_PARAMETER_MAPPING: return createComplexParameterMapping();
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING: return createTechnologySpecificFieldMapping();
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
    public ComplexTypeMapping createComplexTypeMapping() {
        ComplexTypeMappingImpl complexTypeMapping = new ComplexTypeMappingImpl();
        return complexTypeMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ImportedComplexType createImportedComplexType() {
        ImportedComplexTypeImpl importedComplexType = new ImportedComplexTypeImpl();
        return importedComplexType;
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
    public TechnologySpecificFieldMapping createTechnologySpecificFieldMapping() {
        TechnologySpecificFieldMappingImpl technologySpecificFieldMapping = new TechnologySpecificFieldMappingImpl();
        return technologySpecificFieldMapping;
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
