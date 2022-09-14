/**
 */
package de.fhdo.lemma.technology.impl;

import de.fhdo.lemma.technology.*;

import java.util.List;
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
public class TechnologyFactoryImpl extends EFactoryImpl implements TechnologyFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static TechnologyFactory init() {
        try {
            TechnologyFactory theTechnologyFactory = (TechnologyFactory)EPackage.Registry.INSTANCE.getEFactory(TechnologyPackage.eNS_URI);
            if (theTechnologyFactory != null) {
                return theTechnologyFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new TechnologyFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologyFactoryImpl() {
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
            case TechnologyPackage.TECHNOLOGY: return createTechnology();
            case TechnologyPackage.TECHNOLOGY_IMPORT: return createTechnologyImport();
            case TechnologyPackage.PROTOCOL: return createProtocol();
            case TechnologyPackage.DATA_FORMAT: return createDataFormat();
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE: return createTechnologySpecificPrimitiveType();
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_COLLECTION_TYPE: return createTechnologySpecificCollectionType();
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_DATA_STRUCTURE: return createTechnologySpecificDataStructure();
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY: return createCompatibilityMatrixEntry();
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE: return createPossiblyImportedTechnologySpecificType();
            case TechnologyPackage.OPERATION_ENVIRONMENT: return createOperationEnvironment();
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY: return createTechnologySpecificProperty();
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT: return createTechnologySpecificPropertyValueAssignment();
            case TechnologyPackage.DEPLOYMENT_TECHNOLOGY: return createDeploymentTechnology();
            case TechnologyPackage.INFRASTRUCTURE_TECHNOLOGY: return createInfrastructureTechnology();
            case TechnologyPackage.SERVICE_ASPECT: return createServiceAspect();
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT: return createServiceAspectPointcut();
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR: return createServiceAspectPointcutSelector();
            case TechnologyPackage.OPERATION_ASPECT: return createOperationAspect();
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT: return createOperationAspectPointcut();
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR: return createOperationAspectPointcutSelector();
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
            case TechnologyPackage.EXCHANGE_PATTERN:
                return createExchangePatternFromString(eDataType, initialValue);
            case TechnologyPackage.COMMUNICATION_TYPE:
                return createCommunicationTypeFromString(eDataType, initialValue);
            case TechnologyPackage.COMPATIBILITY_DIRECTION:
                return createCompatibilityDirectionFromString(eDataType, initialValue);
            case TechnologyPackage.PROPERTY_FEATURE:
                return createPropertyFeatureFromString(eDataType, initialValue);
            case TechnologyPackage.JOIN_POINT_TYPE:
                return createJoinPointTypeFromString(eDataType, initialValue);
            case TechnologyPackage.POINTCUT_TYPE:
                return createPointcutTypeFromString(eDataType, initialValue);
            case TechnologyPackage.ASPECT_FEATURE:
                return createAspectFeatureFromString(eDataType, initialValue);
            case TechnologyPackage.POINTCUT_TYPE_STRINGS_MAP:
                return createPointcutTypeStringsMapFromString(eDataType, initialValue);
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
            case TechnologyPackage.EXCHANGE_PATTERN:
                return convertExchangePatternToString(eDataType, instanceValue);
            case TechnologyPackage.COMMUNICATION_TYPE:
                return convertCommunicationTypeToString(eDataType, instanceValue);
            case TechnologyPackage.COMPATIBILITY_DIRECTION:
                return convertCompatibilityDirectionToString(eDataType, instanceValue);
            case TechnologyPackage.PROPERTY_FEATURE:
                return convertPropertyFeatureToString(eDataType, instanceValue);
            case TechnologyPackage.JOIN_POINT_TYPE:
                return convertJoinPointTypeToString(eDataType, instanceValue);
            case TechnologyPackage.POINTCUT_TYPE:
                return convertPointcutTypeToString(eDataType, instanceValue);
            case TechnologyPackage.ASPECT_FEATURE:
                return convertAspectFeatureToString(eDataType, instanceValue);
            case TechnologyPackage.POINTCUT_TYPE_STRINGS_MAP:
                return convertPointcutTypeStringsMapToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Technology createTechnology() {
        TechnologyImpl technology = new TechnologyImpl();
        return technology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologyImport createTechnologyImport() {
        TechnologyImportImpl technologyImport = new TechnologyImportImpl();
        return technologyImport;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Protocol createProtocol() {
        ProtocolImpl protocol = new ProtocolImpl();
        return protocol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataFormat createDataFormat() {
        DataFormatImpl dataFormat = new DataFormatImpl();
        return dataFormat;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologySpecificPrimitiveType createTechnologySpecificPrimitiveType() {
        TechnologySpecificPrimitiveTypeImpl technologySpecificPrimitiveType = new TechnologySpecificPrimitiveTypeImpl();
        return technologySpecificPrimitiveType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologySpecificCollectionType createTechnologySpecificCollectionType() {
        TechnologySpecificCollectionTypeImpl technologySpecificCollectionType = new TechnologySpecificCollectionTypeImpl();
        return technologySpecificCollectionType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologySpecificDataStructure createTechnologySpecificDataStructure() {
        TechnologySpecificDataStructureImpl technologySpecificDataStructure = new TechnologySpecificDataStructureImpl();
        return technologySpecificDataStructure;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CompatibilityMatrixEntry createCompatibilityMatrixEntry() {
        CompatibilityMatrixEntryImpl compatibilityMatrixEntry = new CompatibilityMatrixEntryImpl();
        return compatibilityMatrixEntry;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PossiblyImportedTechnologySpecificType createPossiblyImportedTechnologySpecificType() {
        PossiblyImportedTechnologySpecificTypeImpl possiblyImportedTechnologySpecificType = new PossiblyImportedTechnologySpecificTypeImpl();
        return possiblyImportedTechnologySpecificType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationEnvironment createOperationEnvironment() {
        OperationEnvironmentImpl operationEnvironment = new OperationEnvironmentImpl();
        return operationEnvironment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologySpecificProperty createTechnologySpecificProperty() {
        TechnologySpecificPropertyImpl technologySpecificProperty = new TechnologySpecificPropertyImpl();
        return technologySpecificProperty;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologySpecificPropertyValueAssignment createTechnologySpecificPropertyValueAssignment() {
        TechnologySpecificPropertyValueAssignmentImpl technologySpecificPropertyValueAssignment = new TechnologySpecificPropertyValueAssignmentImpl();
        return technologySpecificPropertyValueAssignment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DeploymentTechnology createDeploymentTechnology() {
        DeploymentTechnologyImpl deploymentTechnology = new DeploymentTechnologyImpl();
        return deploymentTechnology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureTechnology createInfrastructureTechnology() {
        InfrastructureTechnologyImpl infrastructureTechnology = new InfrastructureTechnologyImpl();
        return infrastructureTechnology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ServiceAspect createServiceAspect() {
        ServiceAspectImpl serviceAspect = new ServiceAspectImpl();
        return serviceAspect;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ServiceAspectPointcut createServiceAspectPointcut() {
        ServiceAspectPointcutImpl serviceAspectPointcut = new ServiceAspectPointcutImpl();
        return serviceAspectPointcut;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ServiceAspectPointcutSelector createServiceAspectPointcutSelector() {
        ServiceAspectPointcutSelectorImpl serviceAspectPointcutSelector = new ServiceAspectPointcutSelectorImpl();
        return serviceAspectPointcutSelector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationAspect createOperationAspect() {
        OperationAspectImpl operationAspect = new OperationAspectImpl();
        return operationAspect;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationAspectPointcut createOperationAspectPointcut() {
        OperationAspectPointcutImpl operationAspectPointcut = new OperationAspectPointcutImpl();
        return operationAspectPointcut;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationAspectPointcutSelector createOperationAspectPointcutSelector() {
        OperationAspectPointcutSelectorImpl operationAspectPointcutSelector = new OperationAspectPointcutSelectorImpl();
        return operationAspectPointcutSelector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExchangePattern createExchangePatternFromString(EDataType eDataType, String initialValue) {
        ExchangePattern result = ExchangePattern.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertExchangePatternToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CommunicationType createCommunicationTypeFromString(EDataType eDataType, String initialValue) {
        CommunicationType result = CommunicationType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertCommunicationTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CompatibilityDirection createCompatibilityDirectionFromString(EDataType eDataType, String initialValue) {
        CompatibilityDirection result = CompatibilityDirection.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertCompatibilityDirectionToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PropertyFeature createPropertyFeatureFromString(EDataType eDataType, String initialValue) {
        PropertyFeature result = PropertyFeature.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertPropertyFeatureToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JoinPointType createJoinPointTypeFromString(EDataType eDataType, String initialValue) {
        JoinPointType result = JoinPointType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertJoinPointTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PointcutType createPointcutTypeFromString(EDataType eDataType, String initialValue) {
        PointcutType result = PointcutType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertPointcutTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AspectFeature createAspectFeatureFromString(EDataType eDataType, String initialValue) {
        AspectFeature result = AspectFeature.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertAspectFeatureToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public Map<PointcutType, List<String>> createPointcutTypeStringsMapFromString(EDataType eDataType, String initialValue) {
        return (Map<PointcutType, List<String>>)super.createFromString(initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertPointcutTypeStringsMapToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologyPackage getTechnologyPackage() {
        return (TechnologyPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static TechnologyPackage getPackage() {
        return TechnologyPackage.eINSTANCE;
    }

} //TechnologyFactoryImpl
