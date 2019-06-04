/**
 */
package de.fhdo.ddmm.data.intermediate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Enumeration field
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.data.intermediate.IntermediateEnumerationField#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.intermediate.IntermediateEnumerationField#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.intermediate.IntermediateEnumerationField#getInitializationValue <em>Initialization Value</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.intermediate.IntermediateEnumerationField#getInitializationValueCompatibleTypes <em>Initialization Value Compatible Types</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.intermediate.IntermediateEnumerationField#getEnumeration <em>Enumeration</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.data.intermediate.IntermediatePackage#getIntermediateEnumerationField()
 * @model
 * @generated
 */
public interface IntermediateEnumerationField extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.ddmm.data.intermediate.IntermediatePackage#getIntermediateEnumerationField_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.intermediate.IntermediateEnumerationField#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Qualified Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Qualified Name</em>' attribute.
     * @see #setQualifiedName(String)
     * @see de.fhdo.ddmm.data.intermediate.IntermediatePackage#getIntermediateEnumerationField_QualifiedName()
     * @model unique="false"
     * @generated
     */
    String getQualifiedName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.intermediate.IntermediateEnumerationField#getQualifiedName <em>Qualified Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Qualified Name</em>' attribute.
     * @see #getQualifiedName()
     * @generated
     */
    void setQualifiedName(String value);

    /**
     * Returns the value of the '<em><b>Initialization Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Initialization Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Initialization Value</em>' attribute.
     * @see #setInitializationValue(String)
     * @see de.fhdo.ddmm.data.intermediate.IntermediatePackage#getIntermediateEnumerationField_InitializationValue()
     * @model unique="false"
     * @generated
     */
    String getInitializationValue();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.intermediate.IntermediateEnumerationField#getInitializationValue <em>Initialization Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Initialization Value</em>' attribute.
     * @see #getInitializationValue()
     * @generated
     */
    void setInitializationValue(String value);

    /**
     * Returns the value of the '<em><b>Initialization Value Compatible Types</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.data.intermediate.IntermediatePrimitiveType}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.data.intermediate.IntermediatePrimitiveType#getEnumerationField <em>Enumeration Field</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Initialization Value Compatible Types</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Initialization Value Compatible Types</em>' containment reference list.
     * @see de.fhdo.ddmm.data.intermediate.IntermediatePackage#getIntermediateEnumerationField_InitializationValueCompatibleTypes()
     * @see de.fhdo.ddmm.data.intermediate.IntermediatePrimitiveType#getEnumerationField
     * @model opposite="enumerationField" containment="true"
     * @generated
     */
    EList<IntermediatePrimitiveType> getInitializationValueCompatibleTypes();

    /**
     * Returns the value of the '<em><b>Enumeration</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.data.intermediate.IntermediateEnumeration#getFields <em>Fields</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Enumeration</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Enumeration</em>' container reference.
     * @see #setEnumeration(IntermediateEnumeration)
     * @see de.fhdo.ddmm.data.intermediate.IntermediatePackage#getIntermediateEnumerationField_Enumeration()
     * @see de.fhdo.ddmm.data.intermediate.IntermediateEnumeration#getFields
     * @model opposite="fields" transient="false"
     * @generated
     */
    IntermediateEnumeration getEnumeration();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.intermediate.IntermediateEnumerationField#getEnumeration <em>Enumeration</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enumeration</em>' container reference.
     * @see #getEnumeration()
     * @generated
     */
    void setEnumeration(IntermediateEnumeration value);

} // IntermediateEnumerationField
