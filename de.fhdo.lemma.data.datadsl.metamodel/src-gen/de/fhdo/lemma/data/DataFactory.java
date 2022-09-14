/**
 */
package de.fhdo.lemma.data;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.fhdo.lemma.data.DataPackage
 * @generated
 */
public interface DataFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    DataFactory eINSTANCE = de.fhdo.lemma.data.impl.DataFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Model</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Model</em>'.
     * @generated
     */
    DataModel createDataModel();

    /**
     * Returns a new object of class '<em>Complex Type Import</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Complex Type Import</em>'.
     * @generated
     */
    ComplexTypeImport createComplexTypeImport();

    /**
     * Returns a new object of class '<em>Version</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Version</em>'.
     * @generated
     */
    Version createVersion();

    /**
     * Returns a new object of class '<em>Context</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Context</em>'.
     * @generated
     */
    Context createContext();

    /**
     * Returns a new object of class '<em>Primitive Boolean</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Primitive Boolean</em>'.
     * @generated
     */
    PrimitiveBoolean createPrimitiveBoolean();

    /**
     * Returns a new object of class '<em>Primitive Byte</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Primitive Byte</em>'.
     * @generated
     */
    PrimitiveByte createPrimitiveByte();

    /**
     * Returns a new object of class '<em>Primitive Character</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Primitive Character</em>'.
     * @generated
     */
    PrimitiveCharacter createPrimitiveCharacter();

    /**
     * Returns a new object of class '<em>Primitive Date</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Primitive Date</em>'.
     * @generated
     */
    PrimitiveDate createPrimitiveDate();

    /**
     * Returns a new object of class '<em>Primitive Double</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Primitive Double</em>'.
     * @generated
     */
    PrimitiveDouble createPrimitiveDouble();

    /**
     * Returns a new object of class '<em>Primitive Float</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Primitive Float</em>'.
     * @generated
     */
    PrimitiveFloat createPrimitiveFloat();

    /**
     * Returns a new object of class '<em>Primitive Integer</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Primitive Integer</em>'.
     * @generated
     */
    PrimitiveInteger createPrimitiveInteger();

    /**
     * Returns a new object of class '<em>Primitive Long</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Primitive Long</em>'.
     * @generated
     */
    PrimitiveLong createPrimitiveLong();

    /**
     * Returns a new object of class '<em>Primitive Short</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Primitive Short</em>'.
     * @generated
     */
    PrimitiveShort createPrimitiveShort();

    /**
     * Returns a new object of class '<em>Primitive String</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Primitive String</em>'.
     * @generated
     */
    PrimitiveString createPrimitiveString();

    /**
     * Returns a new object of class '<em>Primitive Unspecified</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Primitive Unspecified</em>'.
     * @generated
     */
    PrimitiveUnspecified createPrimitiveUnspecified();

    /**
     * Returns a new object of class '<em>Imported Complex Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Imported Complex Type</em>'.
     * @generated
     */
    ImportedComplexType createImportedComplexType();

    /**
     * Returns a new object of class '<em>Structure</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Structure</em>'.
     * @generated
     */
    DataStructure createDataStructure();

    /**
     * Returns a new object of class '<em>Operation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Operation</em>'.
     * @generated
     */
    DataOperation createDataOperation();

    /**
     * Returns a new object of class '<em>Operation Parameter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Operation Parameter</em>'.
     * @generated
     */
    DataOperationParameter createDataOperationParameter();

    /**
     * Returns a new object of class '<em>Collection Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Collection Type</em>'.
     * @generated
     */
    CollectionType createCollectionType();

    /**
     * Returns a new object of class '<em>Field</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Field</em>'.
     * @generated
     */
    DataField createDataField();

    /**
     * Returns a new object of class '<em>Enumeration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Enumeration</em>'.
     * @generated
     */
    Enumeration createEnumeration();

    /**
     * Returns a new object of class '<em>Enumeration Field</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Enumeration Field</em>'.
     * @generated
     */
    EnumerationField createEnumerationField();

    /**
     * Returns a new object of class '<em>Primitive Value</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Primitive Value</em>'.
     * @generated
     */
    PrimitiveValue createPrimitiveValue();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    DataPackage getDataPackage();

} //DataFactory
