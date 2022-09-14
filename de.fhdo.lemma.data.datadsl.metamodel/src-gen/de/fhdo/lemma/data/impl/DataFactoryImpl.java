/**
 */
package de.fhdo.lemma.data.impl;

import de.fhdo.lemma.data.*;

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
public class DataFactoryImpl extends EFactoryImpl implements DataFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static DataFactory init() {
        try {
            DataFactory theDataFactory = (DataFactory)EPackage.Registry.INSTANCE.getEFactory(DataPackage.eNS_URI);
            if (theDataFactory != null) {
                return theDataFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new DataFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataFactoryImpl() {
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
            case DataPackage.DATA_MODEL: return createDataModel();
            case DataPackage.COMPLEX_TYPE_IMPORT: return createComplexTypeImport();
            case DataPackage.VERSION: return createVersion();
            case DataPackage.CONTEXT: return createContext();
            case DataPackage.PRIMITIVE_BOOLEAN: return createPrimitiveBoolean();
            case DataPackage.PRIMITIVE_BYTE: return createPrimitiveByte();
            case DataPackage.PRIMITIVE_CHARACTER: return createPrimitiveCharacter();
            case DataPackage.PRIMITIVE_DATE: return createPrimitiveDate();
            case DataPackage.PRIMITIVE_DOUBLE: return createPrimitiveDouble();
            case DataPackage.PRIMITIVE_FLOAT: return createPrimitiveFloat();
            case DataPackage.PRIMITIVE_INTEGER: return createPrimitiveInteger();
            case DataPackage.PRIMITIVE_LONG: return createPrimitiveLong();
            case DataPackage.PRIMITIVE_SHORT: return createPrimitiveShort();
            case DataPackage.PRIMITIVE_STRING: return createPrimitiveString();
            case DataPackage.PRIMITIVE_UNSPECIFIED: return createPrimitiveUnspecified();
            case DataPackage.IMPORTED_COMPLEX_TYPE: return createImportedComplexType();
            case DataPackage.DATA_STRUCTURE: return createDataStructure();
            case DataPackage.DATA_OPERATION: return createDataOperation();
            case DataPackage.DATA_OPERATION_PARAMETER: return createDataOperationParameter();
            case DataPackage.COLLECTION_TYPE: return createCollectionType();
            case DataPackage.DATA_FIELD: return createDataField();
            case DataPackage.ENUMERATION: return createEnumeration();
            case DataPackage.ENUMERATION_FIELD: return createEnumerationField();
            case DataPackage.PRIMITIVE_VALUE: return createPrimitiveValue();
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
            case DataPackage.PRIMITIVE_TYPE_CONSTANTS:
                return createPrimitiveTypeConstantsFromString(eDataType, initialValue);
            case DataPackage.COMPLEX_TYPE_FEATURE:
                return createComplexTypeFeatureFromString(eDataType, initialValue);
            case DataPackage.DATA_OPERATION_FEATURE:
                return createDataOperationFeatureFromString(eDataType, initialValue);
            case DataPackage.DATA_FIELD_FEATURE:
                return createDataFieldFeatureFromString(eDataType, initialValue);
            case DataPackage.TYPE_NAME_SIZE_MAP:
                return createTypeNameSizeMapFromString(eDataType, initialValue);
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
            case DataPackage.PRIMITIVE_TYPE_CONSTANTS:
                return convertPrimitiveTypeConstantsToString(eDataType, instanceValue);
            case DataPackage.COMPLEX_TYPE_FEATURE:
                return convertComplexTypeFeatureToString(eDataType, instanceValue);
            case DataPackage.DATA_OPERATION_FEATURE:
                return convertDataOperationFeatureToString(eDataType, instanceValue);
            case DataPackage.DATA_FIELD_FEATURE:
                return convertDataFieldFeatureToString(eDataType, instanceValue);
            case DataPackage.TYPE_NAME_SIZE_MAP:
                return convertTypeNameSizeMapToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataModel createDataModel() {
        DataModelImpl dataModel = new DataModelImpl();
        return dataModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComplexTypeImport createComplexTypeImport() {
        ComplexTypeImportImpl complexTypeImport = new ComplexTypeImportImpl();
        return complexTypeImport;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Version createVersion() {
        VersionImpl version = new VersionImpl();
        return version;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Context createContext() {
        ContextImpl context = new ContextImpl();
        return context;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveBoolean createPrimitiveBoolean() {
        PrimitiveBooleanImpl primitiveBoolean = new PrimitiveBooleanImpl();
        return primitiveBoolean;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveByte createPrimitiveByte() {
        PrimitiveByteImpl primitiveByte = new PrimitiveByteImpl();
        return primitiveByte;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveCharacter createPrimitiveCharacter() {
        PrimitiveCharacterImpl primitiveCharacter = new PrimitiveCharacterImpl();
        return primitiveCharacter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveDate createPrimitiveDate() {
        PrimitiveDateImpl primitiveDate = new PrimitiveDateImpl();
        return primitiveDate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveDouble createPrimitiveDouble() {
        PrimitiveDoubleImpl primitiveDouble = new PrimitiveDoubleImpl();
        return primitiveDouble;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveFloat createPrimitiveFloat() {
        PrimitiveFloatImpl primitiveFloat = new PrimitiveFloatImpl();
        return primitiveFloat;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveInteger createPrimitiveInteger() {
        PrimitiveIntegerImpl primitiveInteger = new PrimitiveIntegerImpl();
        return primitiveInteger;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveLong createPrimitiveLong() {
        PrimitiveLongImpl primitiveLong = new PrimitiveLongImpl();
        return primitiveLong;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveShort createPrimitiveShort() {
        PrimitiveShortImpl primitiveShort = new PrimitiveShortImpl();
        return primitiveShort;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveString createPrimitiveString() {
        PrimitiveStringImpl primitiveString = new PrimitiveStringImpl();
        return primitiveString;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveUnspecified createPrimitiveUnspecified() {
        PrimitiveUnspecifiedImpl primitiveUnspecified = new PrimitiveUnspecifiedImpl();
        return primitiveUnspecified;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ImportedComplexType createImportedComplexType() {
        ImportedComplexTypeImpl importedComplexType = new ImportedComplexTypeImpl();
        return importedComplexType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataStructure createDataStructure() {
        DataStructureImpl dataStructure = new DataStructureImpl();
        return dataStructure;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataOperation createDataOperation() {
        DataOperationImpl dataOperation = new DataOperationImpl();
        return dataOperation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataOperationParameter createDataOperationParameter() {
        DataOperationParameterImpl dataOperationParameter = new DataOperationParameterImpl();
        return dataOperationParameter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CollectionType createCollectionType() {
        CollectionTypeImpl collectionType = new CollectionTypeImpl();
        return collectionType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataField createDataField() {
        DataFieldImpl dataField = new DataFieldImpl();
        return dataField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Enumeration createEnumeration() {
        EnumerationImpl enumeration = new EnumerationImpl();
        return enumeration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EnumerationField createEnumerationField() {
        EnumerationFieldImpl enumerationField = new EnumerationFieldImpl();
        return enumerationField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveValue createPrimitiveValue() {
        PrimitiveValueImpl primitiveValue = new PrimitiveValueImpl();
        return primitiveValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveTypeConstants createPrimitiveTypeConstantsFromString(EDataType eDataType, String initialValue) {
        PrimitiveTypeConstants result = PrimitiveTypeConstants.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertPrimitiveTypeConstantsToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComplexTypeFeature createComplexTypeFeatureFromString(EDataType eDataType, String initialValue) {
        ComplexTypeFeature result = ComplexTypeFeature.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertComplexTypeFeatureToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataOperationFeature createDataOperationFeatureFromString(EDataType eDataType, String initialValue) {
        DataOperationFeature result = DataOperationFeature.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertDataOperationFeatureToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataFieldFeature createDataFieldFeatureFromString(EDataType eDataType, String initialValue) {
        DataFieldFeature result = DataFieldFeature.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertDataFieldFeatureToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public Map<String, Integer> createTypeNameSizeMapFromString(EDataType eDataType, String initialValue) {
        return (Map<String, Integer>)super.createFromString(initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertTypeNameSizeMapToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataPackage getDataPackage() {
        return (DataPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static DataPackage getPackage() {
        return DataPackage.eINSTANCE;
    }

} //DataFactoryImpl
