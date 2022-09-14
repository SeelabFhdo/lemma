/**
 */
package de.fhdo.lemma.data.util;

import de.fhdo.lemma.data.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.fhdo.lemma.data.DataPackage
 * @generated
 */
public class DataSwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static DataPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataSwitch() {
        if (modelPackage == null) {
            modelPackage = DataPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case DataPackage.DATA_MODEL: {
                DataModel dataModel = (DataModel)theEObject;
                T result = caseDataModel(dataModel);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.COMPLEX_TYPE_IMPORT: {
                ComplexTypeImport complexTypeImport = (ComplexTypeImport)theEObject;
                T result = caseComplexTypeImport(complexTypeImport);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.VERSION: {
                Version version = (Version)theEObject;
                T result = caseVersion(version);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.CONTEXT: {
                Context context = (Context)theEObject;
                T result = caseContext(context);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.TYPE: {
                Type type = (Type)theEObject;
                T result = caseType(type);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.PRIMITIVE_TYPE: {
                PrimitiveType primitiveType = (PrimitiveType)theEObject;
                T result = casePrimitiveType(primitiveType);
                if (result == null) result = caseType(primitiveType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.PRIMITIVE_BOOLEAN: {
                PrimitiveBoolean primitiveBoolean = (PrimitiveBoolean)theEObject;
                T result = casePrimitiveBoolean(primitiveBoolean);
                if (result == null) result = casePrimitiveType(primitiveBoolean);
                if (result == null) result = caseType(primitiveBoolean);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.PRIMITIVE_BYTE: {
                PrimitiveByte primitiveByte = (PrimitiveByte)theEObject;
                T result = casePrimitiveByte(primitiveByte);
                if (result == null) result = casePrimitiveType(primitiveByte);
                if (result == null) result = caseType(primitiveByte);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.PRIMITIVE_CHARACTER: {
                PrimitiveCharacter primitiveCharacter = (PrimitiveCharacter)theEObject;
                T result = casePrimitiveCharacter(primitiveCharacter);
                if (result == null) result = casePrimitiveType(primitiveCharacter);
                if (result == null) result = caseType(primitiveCharacter);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.PRIMITIVE_DATE: {
                PrimitiveDate primitiveDate = (PrimitiveDate)theEObject;
                T result = casePrimitiveDate(primitiveDate);
                if (result == null) result = casePrimitiveType(primitiveDate);
                if (result == null) result = caseType(primitiveDate);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.PRIMITIVE_DOUBLE: {
                PrimitiveDouble primitiveDouble = (PrimitiveDouble)theEObject;
                T result = casePrimitiveDouble(primitiveDouble);
                if (result == null) result = casePrimitiveType(primitiveDouble);
                if (result == null) result = caseType(primitiveDouble);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.PRIMITIVE_FLOAT: {
                PrimitiveFloat primitiveFloat = (PrimitiveFloat)theEObject;
                T result = casePrimitiveFloat(primitiveFloat);
                if (result == null) result = casePrimitiveType(primitiveFloat);
                if (result == null) result = caseType(primitiveFloat);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.PRIMITIVE_INTEGER: {
                PrimitiveInteger primitiveInteger = (PrimitiveInteger)theEObject;
                T result = casePrimitiveInteger(primitiveInteger);
                if (result == null) result = casePrimitiveType(primitiveInteger);
                if (result == null) result = caseType(primitiveInteger);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.PRIMITIVE_LONG: {
                PrimitiveLong primitiveLong = (PrimitiveLong)theEObject;
                T result = casePrimitiveLong(primitiveLong);
                if (result == null) result = casePrimitiveType(primitiveLong);
                if (result == null) result = caseType(primitiveLong);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.PRIMITIVE_SHORT: {
                PrimitiveShort primitiveShort = (PrimitiveShort)theEObject;
                T result = casePrimitiveShort(primitiveShort);
                if (result == null) result = casePrimitiveType(primitiveShort);
                if (result == null) result = caseType(primitiveShort);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.PRIMITIVE_STRING: {
                PrimitiveString primitiveString = (PrimitiveString)theEObject;
                T result = casePrimitiveString(primitiveString);
                if (result == null) result = casePrimitiveType(primitiveString);
                if (result == null) result = caseType(primitiveString);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.PRIMITIVE_UNSPECIFIED: {
                PrimitiveUnspecified primitiveUnspecified = (PrimitiveUnspecified)theEObject;
                T result = casePrimitiveUnspecified(primitiveUnspecified);
                if (result == null) result = casePrimitiveType(primitiveUnspecified);
                if (result == null) result = caseType(primitiveUnspecified);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.COMPLEX_TYPE: {
                ComplexType complexType = (ComplexType)theEObject;
                T result = caseComplexType(complexType);
                if (result == null) result = caseType(complexType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.IMPORTED_COMPLEX_TYPE: {
                ImportedComplexType importedComplexType = (ImportedComplexType)theEObject;
                T result = caseImportedComplexType(importedComplexType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.DATA_STRUCTURE: {
                DataStructure dataStructure = (DataStructure)theEObject;
                T result = caseDataStructure(dataStructure);
                if (result == null) result = caseComplexType(dataStructure);
                if (result == null) result = caseType(dataStructure);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.DATA_OPERATION: {
                DataOperation dataOperation = (DataOperation)theEObject;
                T result = caseDataOperation(dataOperation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.DATA_OPERATION_PARAMETER: {
                DataOperationParameter dataOperationParameter = (DataOperationParameter)theEObject;
                T result = caseDataOperationParameter(dataOperationParameter);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.COLLECTION_TYPE: {
                CollectionType collectionType = (CollectionType)theEObject;
                T result = caseCollectionType(collectionType);
                if (result == null) result = caseComplexType(collectionType);
                if (result == null) result = caseType(collectionType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.DATA_FIELD: {
                DataField dataField = (DataField)theEObject;
                T result = caseDataField(dataField);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.ENUMERATION: {
                Enumeration enumeration = (Enumeration)theEObject;
                T result = caseEnumeration(enumeration);
                if (result == null) result = caseComplexType(enumeration);
                if (result == null) result = caseType(enumeration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.ENUMERATION_FIELD: {
                EnumerationField enumerationField = (EnumerationField)theEObject;
                T result = caseEnumerationField(enumerationField);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DataPackage.PRIMITIVE_VALUE: {
                PrimitiveValue primitiveValue = (PrimitiveValue)theEObject;
                T result = casePrimitiveValue(primitiveValue);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Model</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataModel(DataModel object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Complex Type Import</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Complex Type Import</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseComplexTypeImport(ComplexTypeImport object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Version</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Version</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseVersion(Version object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Context</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Context</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseContext(Context object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseType(Type object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrimitiveType(PrimitiveType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Boolean</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Boolean</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrimitiveBoolean(PrimitiveBoolean object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Byte</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Byte</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrimitiveByte(PrimitiveByte object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Character</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Character</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrimitiveCharacter(PrimitiveCharacter object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Date</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Date</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrimitiveDate(PrimitiveDate object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Double</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Double</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrimitiveDouble(PrimitiveDouble object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Float</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Float</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrimitiveFloat(PrimitiveFloat object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Integer</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Integer</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrimitiveInteger(PrimitiveInteger object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Long</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Long</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrimitiveLong(PrimitiveLong object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Short</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Short</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrimitiveShort(PrimitiveShort object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primitive String</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive String</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrimitiveString(PrimitiveString object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Unspecified</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Unspecified</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrimitiveUnspecified(PrimitiveUnspecified object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Complex Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Complex Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseComplexType(ComplexType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Imported Complex Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Imported Complex Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseImportedComplexType(ImportedComplexType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Structure</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Structure</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataStructure(DataStructure object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataOperation(DataOperation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operation Parameter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation Parameter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataOperationParameter(DataOperationParameter object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Collection Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCollectionType(CollectionType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Field</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Field</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataField(DataField object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Enumeration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Enumeration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEnumeration(Enumeration object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Enumeration Field</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Enumeration Field</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEnumerationField(EnumerationField object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrimitiveValue(PrimitiveValue object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} //DataSwitch
