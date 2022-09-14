/**
 */
package de.fhdo.lemma.data.intermediate;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Intermediate concept for any possible type in the context of the languages, i.e., it may be of
 * one of the kinds primitive, collection, or data structure, and one of the origins built-in,
 * data model, technology. Note that currently only the following combinations are possible:
 *      kind                origins
 *      primitive           built-in, technology
 *      collection          data model, technology
 *      data structure      data model, technology
 * However, code generators should not depend on these combinations.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateType#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateType#getOrigin <em>Origin</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateType#getKind <em>Kind</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateType#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateType#getParameter <em>Parameter</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateType#getDataField <em>Data Field</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateType()
 * @model abstract="true"
 * @generated
 */
public interface IntermediateType extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateType_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateType#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Origin</b></em>' attribute.
     * The literals are from the enumeration {@link de.fhdo.lemma.data.intermediate.IntermediateTypeOrigin}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Origin</em>' attribute.
     * @see de.fhdo.lemma.data.intermediate.IntermediateTypeOrigin
     * @see #setOrigin(IntermediateTypeOrigin)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateType_Origin()
     * @model unique="false"
     * @generated
     */
    IntermediateTypeOrigin getOrigin();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateType#getOrigin <em>Origin</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Origin</em>' attribute.
     * @see de.fhdo.lemma.data.intermediate.IntermediateTypeOrigin
     * @see #getOrigin()
     * @generated
     */
    void setOrigin(IntermediateTypeOrigin value);

    /**
     * Returns the value of the '<em><b>Kind</b></em>' attribute.
     * The literals are from the enumeration {@link de.fhdo.lemma.data.intermediate.IntermediateTypeKind}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Kind</em>' attribute.
     * @see de.fhdo.lemma.data.intermediate.IntermediateTypeKind
     * @see #setKind(IntermediateTypeKind)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateType_Kind()
     * @model unique="false"
     * @generated
     */
    IntermediateTypeKind getKind();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateType#getKind <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Kind</em>' attribute.
     * @see de.fhdo.lemma.data.intermediate.IntermediateTypeKind
     * @see #getKind()
     * @generated
     */
    void setKind(IntermediateTypeKind value);

    /**
     * Returns the value of the '<em><b>Return Type</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Return Type</em>' container reference.
     * @see #setReturnType(IntermediateDataOperationReturnType)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateType_ReturnType()
     * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType#getType
     * @model opposite="type" transient="false"
     * @generated
     */
    IntermediateDataOperationReturnType getReturnType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateType#getReturnType <em>Return Type</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Return Type</em>' container reference.
     * @see #getReturnType()
     * @generated
     */
    void setReturnType(IntermediateDataOperationReturnType value);

    /**
     * Returns the value of the '<em><b>Parameter</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameter</em>' container reference.
     * @see #setParameter(IntermediateDataOperationParameter)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateType_Parameter()
     * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getType
     * @model opposite="type" transient="false"
     * @generated
     */
    IntermediateDataOperationParameter getParameter();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateType#getParameter <em>Parameter</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parameter</em>' container reference.
     * @see #getParameter()
     * @generated
     */
    void setParameter(IntermediateDataOperationParameter value);

    /**
     * Returns the value of the '<em><b>Data Field</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Field</em>' container reference.
     * @see #setDataField(IntermediateDataField)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateType_DataField()
     * @see de.fhdo.lemma.data.intermediate.IntermediateDataField#getType
     * @model opposite="type" transient="false"
     * @generated
     */
    IntermediateDataField getDataField();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateType#getDataField <em>Data Field</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Field</em>' container reference.
     * @see #getDataField()
     * @generated
     */
    void setDataField(IntermediateDataField value);

} // IntermediateType
