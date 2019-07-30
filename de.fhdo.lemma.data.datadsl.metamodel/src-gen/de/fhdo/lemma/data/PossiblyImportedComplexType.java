/**
 */
package de.fhdo.lemma.data;

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
 *   <li>{@link de.fhdo.lemma.data.PossiblyImportedComplexType#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.PossiblyImportedComplexType#getComplexType <em>Complex Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.PossiblyImportedComplexType#getDataField <em>Data Field</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.PossiblyImportedComplexType#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.PossiblyImportedComplexType#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.DataPackage#getPossiblyImportedComplexType()
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
     * @see de.fhdo.lemma.data.DataPackage#getPossiblyImportedComplexType_Import()
     * @model
     * @generated
     */
    ComplexTypeImport getImport();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.PossiblyImportedComplexType#getImport <em>Import</em>}' reference.
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
     * @see de.fhdo.lemma.data.DataPackage#getPossiblyImportedComplexType_ComplexType()
     * @model
     * @generated
     */
    ComplexType getComplexType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.PossiblyImportedComplexType#getComplexType <em>Complex Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Complex Type</em>' reference.
     * @see #getComplexType()
     * @generated
     */
    void setComplexType(ComplexType value);

    /**
     * Returns the value of the '<em><b>Data Field</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.DataField#getComplexType <em>Complex Type</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Field</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Field</em>' container reference.
     * @see #setDataField(DataField)
     * @see de.fhdo.lemma.data.DataPackage#getPossiblyImportedComplexType_DataField()
     * @see de.fhdo.lemma.data.DataField#getComplexType
     * @model opposite="complexType" transient="false"
     * @generated
     */
    DataField getDataField();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.PossiblyImportedComplexType#getDataField <em>Data Field</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Field</em>' container reference.
     * @see #getDataField()
     * @generated
     */
    void setDataField(DataField value);

    /**
     * Returns the value of the '<em><b>Operation</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.DataOperation#getComplexReturnType <em>Complex Return Type</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation</em>' container reference.
     * @see #setOperation(DataOperation)
     * @see de.fhdo.lemma.data.DataPackage#getPossiblyImportedComplexType_Operation()
     * @see de.fhdo.lemma.data.DataOperation#getComplexReturnType
     * @model opposite="complexReturnType" transient="false"
     * @generated
     */
    DataOperation getOperation();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.PossiblyImportedComplexType#getOperation <em>Operation</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation</em>' container reference.
     * @see #getOperation()
     * @generated
     */
    void setOperation(DataOperation value);

    /**
     * Returns the value of the '<em><b>Parameter</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.DataOperationParameter#getComplexType <em>Complex Type</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameter</em>' container reference.
     * @see #setParameter(DataOperationParameter)
     * @see de.fhdo.lemma.data.DataPackage#getPossiblyImportedComplexType_Parameter()
     * @see de.fhdo.lemma.data.DataOperationParameter#getComplexType
     * @model opposite="complexType" transient="false"
     * @generated
     */
    DataOperationParameter getParameter();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.PossiblyImportedComplexType#getParameter <em>Parameter</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parameter</em>' container reference.
     * @see #getParameter()
     * @generated
     */
    void setParameter(DataOperationParameter value);

} // PossiblyImportedComplexType
