/**
 */
package de.fhdo.ddmm.data;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Possibly Imported Complex Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents a complex type that may be imported from another data model. In fact, this is used by
 * the DSL for referring to complex types in data fields to allow field-typing with imported data
 * structures and lists.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.data.PossiblyImportedComplexType#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.PossiblyImportedComplexType#getComplexType <em>Complex Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.PossiblyImportedComplexType#getDataField <em>Data Field</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.data.DataPackage#getPossiblyImportedComplexType()
 * @model
 * @generated
 */
public interface PossiblyImportedComplexType extends EObject {
    /**
     * Returns the value of the '<em><b>Import</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Import</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Import</em>' reference.
     * @see #setImport(ComplexTypeImport)
     * @see de.fhdo.ddmm.data.DataPackage#getPossiblyImportedComplexType_Import()
     * @model
     * @generated
     */
    ComplexTypeImport getImport();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.PossiblyImportedComplexType#getImport <em>Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Import</em>' reference.
     * @see #getImport()
     * @generated
     */
    void setImport(ComplexTypeImport value);

    /**
     * Returns the value of the '<em><b>Complex Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Complex Type</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Complex Type</em>' reference.
     * @see #setComplexType(ComplexType)
     * @see de.fhdo.ddmm.data.DataPackage#getPossiblyImportedComplexType_ComplexType()
     * @model
     * @generated
     */
    ComplexType getComplexType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.PossiblyImportedComplexType#getComplexType <em>Complex Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Complex Type</em>' reference.
     * @see #getComplexType()
     * @generated
     */
    void setComplexType(ComplexType value);

    /**
     * Returns the value of the '<em><b>Data Field</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.data.DataField#getComplexType <em>Complex Type</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Field</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Field</em>' container reference.
     * @see #setDataField(DataField)
     * @see de.fhdo.ddmm.data.DataPackage#getPossiblyImportedComplexType_DataField()
     * @see de.fhdo.ddmm.data.DataField#getComplexType
     * @model opposite="complexType" transient="false"
     * @generated
     */
    DataField getDataField();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.PossiblyImportedComplexType#getDataField <em>Data Field</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Field</em>' container reference.
     * @see #getDataField()
     * @generated
     */
    void setDataField(DataField value);

} // PossiblyImportedComplexType
