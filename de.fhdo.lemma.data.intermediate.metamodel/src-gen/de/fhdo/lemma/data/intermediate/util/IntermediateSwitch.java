/**
 */
package de.fhdo.lemma.data.intermediate.util;

import de.fhdo.lemma.data.intermediate.*;

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
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage
 * @generated
 */
public class IntermediateSwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static IntermediatePackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateSwitch() {
        if (modelPackage == null) {
            modelPackage = IntermediatePackage.eINSTANCE;
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
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL: {
                IntermediateDataModel intermediateDataModel = (IntermediateDataModel)theEObject;
                T result = caseIntermediateDataModel(intermediateDataModel);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_IMPORT: {
                IntermediateImport intermediateImport = (IntermediateImport)theEObject;
                T result = caseIntermediateImport(intermediateImport);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_VERSION: {
                IntermediateVersion intermediateVersion = (IntermediateVersion)theEObject;
                T result = caseIntermediateVersion(intermediateVersion);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_CONTEXT: {
                IntermediateContext intermediateContext = (IntermediateContext)theEObject;
                T result = caseIntermediateContext(intermediateContext);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_TYPE: {
                IntermediateType intermediateType = (IntermediateType)theEObject;
                T result = caseIntermediateType(intermediateType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE: {
                IntermediatePrimitiveType intermediatePrimitiveType = (IntermediatePrimitiveType)theEObject;
                T result = caseIntermediatePrimitiveType(intermediatePrimitiveType);
                if (result == null) result = caseIntermediateType(intermediatePrimitiveType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE: {
                IntermediateComplexType intermediateComplexType = (IntermediateComplexType)theEObject;
                T result = caseIntermediateComplexType(intermediateComplexType);
                if (result == null) result = caseIntermediateType(intermediateComplexType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_IMPORTED_COMPLEX_TYPE: {
                IntermediateImportedComplexType intermediateImportedComplexType = (IntermediateImportedComplexType)theEObject;
                T result = caseIntermediateImportedComplexType(intermediateImportedComplexType);
                if (result == null) result = caseIntermediateComplexType(intermediateImportedComplexType);
                if (result == null) result = caseIntermediateType(intermediateImportedComplexType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE: {
                IntermediateImportedTechnologySpecificType intermediateImportedTechnologySpecificType = (IntermediateImportedTechnologySpecificType)theEObject;
                T result = caseIntermediateImportedTechnologySpecificType(intermediateImportedTechnologySpecificType);
                if (result == null) result = caseIntermediateType(intermediateImportedTechnologySpecificType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE: {
                IntermediateDataStructure intermediateDataStructure = (IntermediateDataStructure)theEObject;
                T result = caseIntermediateDataStructure(intermediateDataStructure);
                if (result == null) result = caseIntermediateComplexType(intermediateDataStructure);
                if (result == null) result = caseIntermediateType(intermediateDataStructure);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION: {
                IntermediateDataOperation intermediateDataOperation = (IntermediateDataOperation)theEObject;
                T result = caseIntermediateDataOperation(intermediateDataOperation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_RETURN_TYPE: {
                IntermediateDataOperationReturnType intermediateDataOperationReturnType = (IntermediateDataOperationReturnType)theEObject;
                T result = caseIntermediateDataOperationReturnType(intermediateDataOperationReturnType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER: {
                IntermediateDataOperationParameter intermediateDataOperationParameter = (IntermediateDataOperationParameter)theEObject;
                T result = caseIntermediateDataOperationParameter(intermediateDataOperationParameter);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE: {
                IntermediateCollectionType intermediateCollectionType = (IntermediateCollectionType)theEObject;
                T result = caseIntermediateCollectionType(intermediateCollectionType);
                if (result == null) result = caseIntermediateComplexType(intermediateCollectionType);
                if (result == null) result = caseIntermediateType(intermediateCollectionType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD: {
                IntermediateDataField intermediateDataField = (IntermediateDataField)theEObject;
                T result = caseIntermediateDataField(intermediateDataField);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_ENUMERATION: {
                IntermediateEnumeration intermediateEnumeration = (IntermediateEnumeration)theEObject;
                T result = caseIntermediateEnumeration(intermediateEnumeration);
                if (result == null) result = caseIntermediateComplexType(intermediateEnumeration);
                if (result == null) result = caseIntermediateType(intermediateEnumeration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD: {
                IntermediateEnumerationField intermediateEnumerationField = (IntermediateEnumerationField)theEObject;
                T result = caseIntermediateEnumerationField(intermediateEnumerationField);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT: {
                IntermediateImportedAspect intermediateImportedAspect = (IntermediateImportedAspect)theEObject;
                T result = caseIntermediateImportedAspect(intermediateImportedAspect);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY: {
                IntermediateAspectProperty intermediateAspectProperty = (IntermediateAspectProperty)theEObject;
                T result = caseIntermediateAspectProperty(intermediateAspectProperty);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE: {
                IntermediateAspectPropertyValue intermediateAspectPropertyValue = (IntermediateAspectPropertyValue)theEObject;
                T result = caseIntermediateAspectPropertyValue(intermediateAspectPropertyValue);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Model</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Model</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateDataModel(IntermediateDataModel object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Import</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateImport(IntermediateImport object) {
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
    public T caseIntermediateVersion(IntermediateVersion object) {
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
    public T caseIntermediateContext(IntermediateContext object) {
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
    public T caseIntermediateType(IntermediateType object) {
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
    public T caseIntermediatePrimitiveType(IntermediatePrimitiveType object) {
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
    public T caseIntermediateComplexType(IntermediateComplexType object) {
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
    public T caseIntermediateImportedComplexType(IntermediateImportedComplexType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Imported Technology Specific Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Imported Technology Specific Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateImportedTechnologySpecificType(IntermediateImportedTechnologySpecificType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Structure</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Structure</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateDataStructure(IntermediateDataStructure object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Operation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Operation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateDataOperation(IntermediateDataOperation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Operation Return Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Operation Return Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateDataOperationReturnType(IntermediateDataOperationReturnType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Operation Parameter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Operation Parameter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateDataOperationParameter(IntermediateDataOperationParameter object) {
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
    public T caseIntermediateCollectionType(IntermediateCollectionType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Field</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Field</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateDataField(IntermediateDataField object) {
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
    public T caseIntermediateEnumeration(IntermediateEnumeration object) {
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
    public T caseIntermediateEnumerationField(IntermediateEnumerationField object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Imported Aspect</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Imported Aspect</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateImportedAspect(IntermediateImportedAspect object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Aspect Property</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Aspect Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateAspectProperty(IntermediateAspectProperty object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Aspect Property Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Aspect Property Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntermediateAspectPropertyValue(IntermediateAspectPropertyValue object) {
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

} //IntermediateSwitch
