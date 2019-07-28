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
            case DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE: return createPossiblyImportedComplexType();
            case DataPackage.DATA_STRUCTURE: return createDataStructure();
            case DataPackage.LIST_TYPE: return createListType();
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
            case DataPackage.FIELD_FEATURE:
                return createFieldFeatureFromString(eDataType, initialValue);
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
            case DataPackage.FIELD_FEATURE:
                return convertFieldFeatureToString(eDataType, instanceValue);
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
    @Override
    public DataModel createDataModel() {
        DataModelImpl dataModel = new DataModelImpl();
        return dataModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ComplexTypeImport createComplexTypeImport() {
        ComplexTypeImportImpl complexTypeImport = new ComplexTypeImportImpl();
        return complexTypeImport;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Version createVersion() {
        VersionImpl version = new VersionImpl();
        return version;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Context createContext() {
        ContextImpl context = new ContextImpl();
        return context;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PrimitiveBoolean createPrimitiveBoolean() {
        PrimitiveBooleanImpl primitiveBoolean = new PrimitiveBooleanImpl();
        return primitiveBoolean;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PrimitiveByte createPrimitiveByte() {
        PrimitiveByteImpl primitiveByte = new PrimitiveByteImpl();
        return primitiveByte;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PrimitiveCharacter createPrimitiveCharacter() {
        PrimitiveCharacterImpl primitiveCharacter = new PrimitiveCharacterImpl();
        return primitiveCharacter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PrimitiveDate createPrimitiveDate() {
        PrimitiveDateImpl primitiveDate = new PrimitiveDateImpl();
        return primitiveDate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PrimitiveDouble createPrimitiveDouble() {
        PrimitiveDoubleImpl primitiveDouble = new PrimitiveDoubleImpl();
        return primitiveDouble;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PrimitiveFloat createPrimitiveFloat() {
        PrimitiveFloatImpl primitiveFloat = new PrimitiveFloatImpl();
        return primitiveFloat;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PrimitiveInteger createPrimitiveInteger() {
        PrimitiveIntegerImpl primitiveInteger = new PrimitiveIntegerImpl();
        return primitiveInteger;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PrimitiveLong createPrimitiveLong() {
        PrimitiveLongImpl primitiveLong = new PrimitiveLongImpl();
        return primitiveLong;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PrimitiveShort createPrimitiveShort() {
        PrimitiveShortImpl primitiveShort = new PrimitiveShortImpl();
        return primitiveShort;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PrimitiveString createPrimitiveString() {
        PrimitiveStringImpl primitiveString = new PrimitiveStringImpl();
        return primitiveString;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PossiblyImportedComplexType createPossiblyImportedComplexType() {
        PossiblyImportedComplexTypeImpl possiblyImportedComplexType = new PossiblyImportedComplexTypeImpl();
        return possiblyImportedComplexType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DataStructure createDataStructure() {
        DataStructureImpl dataStructure = new DataStructureImpl();
        return dataStructure;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ListType createListType() {
        ListTypeImpl listType = new ListTypeImpl();
        return listType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DataField createDataField() {
        DataFieldImpl dataField = new DataFieldImpl();
        return dataField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Enumeration createEnumeration() {
        EnumerationImpl enumeration = new EnumerationImpl();
        return enumeration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EnumerationField createEnumerationField() {
        EnumerationFieldImpl enumerationField = new EnumerationFieldImpl();
        return enumerationField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
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
    public FieldFeature createFieldFeatureFromString(EDataType eDataType, String initialValue) {
        FieldFeature result = FieldFeature.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertFieldFeatureToString(EDataType eDataType, Object instanceValue) {
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
    @Override
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
