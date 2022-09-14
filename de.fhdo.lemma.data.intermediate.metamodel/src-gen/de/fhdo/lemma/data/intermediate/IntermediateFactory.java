/**
 */
package de.fhdo.lemma.data.intermediate;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage
 * @generated
 */
public interface IntermediateFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    IntermediateFactory eINSTANCE = de.fhdo.lemma.data.intermediate.impl.IntermediateFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Data Model</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data Model</em>'.
     * @generated
     */
    IntermediateDataModel createIntermediateDataModel();

    /**
     * Returns a new object of class '<em>Import</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Import</em>'.
     * @generated
     */
    IntermediateImport createIntermediateImport();

    /**
     * Returns a new object of class '<em>Version</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Version</em>'.
     * @generated
     */
    IntermediateVersion createIntermediateVersion();

    /**
     * Returns a new object of class '<em>Context</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Context</em>'.
     * @generated
     */
    IntermediateContext createIntermediateContext();

    /**
     * Returns a new object of class '<em>Primitive Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Primitive Type</em>'.
     * @generated
     */
    IntermediatePrimitiveType createIntermediatePrimitiveType();

    /**
     * Returns a new object of class '<em>Complex Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Complex Type</em>'.
     * @generated
     */
    IntermediateComplexType createIntermediateComplexType();

    /**
     * Returns a new object of class '<em>Imported Complex Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Imported Complex Type</em>'.
     * @generated
     */
    IntermediateImportedComplexType createIntermediateImportedComplexType();

    /**
     * Returns a new object of class '<em>Imported Technology Specific Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Imported Technology Specific Type</em>'.
     * @generated
     */
    IntermediateImportedTechnologySpecificType createIntermediateImportedTechnologySpecificType();

    /**
     * Returns a new object of class '<em>Data Structure</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data Structure</em>'.
     * @generated
     */
    IntermediateDataStructure createIntermediateDataStructure();

    /**
     * Returns a new object of class '<em>Data Operation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data Operation</em>'.
     * @generated
     */
    IntermediateDataOperation createIntermediateDataOperation();

    /**
     * Returns a new object of class '<em>Data Operation Return Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data Operation Return Type</em>'.
     * @generated
     */
    IntermediateDataOperationReturnType createIntermediateDataOperationReturnType();

    /**
     * Returns a new object of class '<em>Data Operation Parameter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data Operation Parameter</em>'.
     * @generated
     */
    IntermediateDataOperationParameter createIntermediateDataOperationParameter();

    /**
     * Returns a new object of class '<em>Collection Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Collection Type</em>'.
     * @generated
     */
    IntermediateCollectionType createIntermediateCollectionType();

    /**
     * Returns a new object of class '<em>Data Field</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data Field</em>'.
     * @generated
     */
    IntermediateDataField createIntermediateDataField();

    /**
     * Returns a new object of class '<em>Enumeration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Enumeration</em>'.
     * @generated
     */
    IntermediateEnumeration createIntermediateEnumeration();

    /**
     * Returns a new object of class '<em>Enumeration Field</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Enumeration Field</em>'.
     * @generated
     */
    IntermediateEnumerationField createIntermediateEnumerationField();

    /**
     * Returns a new object of class '<em>Imported Aspect</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Imported Aspect</em>'.
     * @generated
     */
    IntermediateImportedAspect createIntermediateImportedAspect();

    /**
     * Returns a new object of class '<em>Aspect Property</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Aspect Property</em>'.
     * @generated
     */
    IntermediateAspectProperty createIntermediateAspectProperty();

    /**
     * Returns a new object of class '<em>Aspect Property Value</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Aspect Property Value</em>'.
     * @generated
     */
    IntermediateAspectPropertyValue createIntermediateAspectPropertyValue();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    IntermediatePackage getIntermediatePackage();

} //IntermediateFactory
