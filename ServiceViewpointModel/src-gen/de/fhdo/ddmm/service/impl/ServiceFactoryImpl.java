/**
 */
package de.fhdo.ddmm.service.impl;

import de.fhdo.ddmm.service.*;

import java.util.Map;

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
public class ServiceFactoryImpl extends EFactoryImpl implements ServiceFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ServiceFactory init() {
        try {
            ServiceFactory theServiceFactory = (ServiceFactory)EPackage.Registry.INSTANCE.getEFactory(ServicePackage.eNS_URI);
            if (theServiceFactory != null) {
                return theServiceFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ServiceFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ServiceFactoryImpl() {
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
            case ServicePackage.SERVICE_MODEL: return createServiceModel();
            case ServicePackage.IMPORT: return createImport();
            case ServicePackage.MICROSERVICE: return createMicroservice();
            case ServicePackage.INTERFACE: return createInterface();
            case ServicePackage.OPERATION: return createOperation();
            case ServicePackage.REFERRED_OPERATION: return createReferredOperation();
            case ServicePackage.PARAMETER: return createParameter();
            case ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE: return createPossiblyImportedMicroservice();
            case ServicePackage.POSSIBLY_IMPORTED_INTERFACE: return createPossiblyImportedInterface();
            case ServicePackage.POSSIBLY_IMPORTED_OPERATION: return createPossiblyImportedOperation();
            case ServicePackage.IMPORTED_TYPE: return createImportedType();
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT: return createImportedProtocolAndDataFormat();
            case ServicePackage.PROTOCOL_SPECIFICATION: return createProtocolSpecification();
            case ServicePackage.ENDPOINT: return createEndpoint();
            case ServicePackage.IMPORTED_SERVICE_ASPECT: return createImportedServiceAspect();
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
            case ServicePackage.IMPORT_TYPE:
                return createImportTypeFromString(eDataType, initialValue);
            case ServicePackage.MICROSERVICE_TYPE:
                return createMicroserviceTypeFromString(eDataType, initialValue);
            case ServicePackage.VISIBILITY:
                return createVisibilityFromString(eDataType, initialValue);
            case ServicePackage.MICROSERVICE_IMPORT_MAP:
                return createMicroserviceImportMapFromString(eDataType, initialValue);
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
            case ServicePackage.IMPORT_TYPE:
                return convertImportTypeToString(eDataType, instanceValue);
            case ServicePackage.MICROSERVICE_TYPE:
                return convertMicroserviceTypeToString(eDataType, instanceValue);
            case ServicePackage.VISIBILITY:
                return convertVisibilityToString(eDataType, instanceValue);
            case ServicePackage.MICROSERVICE_IMPORT_MAP:
                return convertMicroserviceImportMapToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ServiceModel createServiceModel() {
        ServiceModelImpl serviceModel = new ServiceModelImpl();
        return serviceModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Import createImport() {
        ImportImpl import_ = new ImportImpl();
        return import_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Microservice createMicroservice() {
        MicroserviceImpl microservice = new MicroserviceImpl();
        return microservice;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Interface createInterface() {
        InterfaceImpl interface_ = new InterfaceImpl();
        return interface_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Operation createOperation() {
        OperationImpl operation = new OperationImpl();
        return operation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ReferredOperation createReferredOperation() {
        ReferredOperationImpl referredOperation = new ReferredOperationImpl();
        return referredOperation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Parameter createParameter() {
        ParameterImpl parameter = new ParameterImpl();
        return parameter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PossiblyImportedMicroservice createPossiblyImportedMicroservice() {
        PossiblyImportedMicroserviceImpl possiblyImportedMicroservice = new PossiblyImportedMicroserviceImpl();
        return possiblyImportedMicroservice;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PossiblyImportedInterface createPossiblyImportedInterface() {
        PossiblyImportedInterfaceImpl possiblyImportedInterface = new PossiblyImportedInterfaceImpl();
        return possiblyImportedInterface;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PossiblyImportedOperation createPossiblyImportedOperation() {
        PossiblyImportedOperationImpl possiblyImportedOperation = new PossiblyImportedOperationImpl();
        return possiblyImportedOperation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ImportedType createImportedType() {
        ImportedTypeImpl importedType = new ImportedTypeImpl();
        return importedType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ImportedProtocolAndDataFormat createImportedProtocolAndDataFormat() {
        ImportedProtocolAndDataFormatImpl importedProtocolAndDataFormat = new ImportedProtocolAndDataFormatImpl();
        return importedProtocolAndDataFormat;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProtocolSpecification createProtocolSpecification() {
        ProtocolSpecificationImpl protocolSpecification = new ProtocolSpecificationImpl();
        return protocolSpecification;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Endpoint createEndpoint() {
        EndpointImpl endpoint = new EndpointImpl();
        return endpoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ImportedServiceAspect createImportedServiceAspect() {
        ImportedServiceAspectImpl importedServiceAspect = new ImportedServiceAspectImpl();
        return importedServiceAspect;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ImportType createImportTypeFromString(EDataType eDataType, String initialValue) {
        ImportType result = ImportType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertImportTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MicroserviceType createMicroserviceTypeFromString(EDataType eDataType, String initialValue) {
        MicroserviceType result = MicroserviceType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertMicroserviceTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Visibility createVisibilityFromString(EDataType eDataType, String initialValue) {
        Visibility result = Visibility.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertVisibilityToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public Map<Microservice, Import> createMicroserviceImportMapFromString(EDataType eDataType, String initialValue) {
        return (Map<Microservice, Import>)super.createFromString(initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertMicroserviceImportMapToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ServicePackage getServicePackage() {
        return (ServicePackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ServicePackage getPackage() {
        return ServicePackage.eINSTANCE;
    }

} //ServiceFactoryImpl
