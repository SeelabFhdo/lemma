/**
 */
package de.fhdo.ddmm.service.intermediate;

import de.fhdo.ddmm.data.intermediate.IntermediateType;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapped Data Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Mapped data field
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedDataField#getMappedDataFieldName <em>Mapped Data Field Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedDataField#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedDataField#getMappedType <em>Mapped Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedDataField#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedDataField#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateMappedDataField()
 * @model
 * @generated
 */
public interface IntermediateMappedDataField extends EObject {
    /**
     * Returns the value of the '<em><b>Mapped Data Field Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mapped Data Field Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mapped Data Field Name</em>' attribute.
     * @see #setMappedDataFieldName(String)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateMappedDataField_MappedDataFieldName()
     * @model unique="false"
     * @generated
     */
    String getMappedDataFieldName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedDataField#getMappedDataFieldName <em>Mapped Data Field Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mapped Data Field Name</em>' attribute.
     * @see #getMappedDataFieldName()
     * @generated
     */
    void setMappedDataFieldName(String value);

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
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateMappedDataField_QualifiedName()
     * @model unique="false"
     * @generated
     */
    String getQualifiedName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedDataField#getQualifiedName <em>Qualified Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Qualified Name</em>' attribute.
     * @see #getQualifiedName()
     * @generated
     */
    void setQualifiedName(String value);

    /**
     * Returns the value of the '<em><b>Mapped Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mapped Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mapped Type</em>' containment reference.
     * @see #setMappedType(IntermediateType)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateMappedDataField_MappedType()
     * @model containment="true"
     * @generated
     */
    IntermediateType getMappedType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedDataField#getMappedType <em>Mapped Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mapped Type</em>' containment reference.
     * @see #getMappedType()
     * @generated
     */
    void setMappedType(IntermediateType value);

    /**
     * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getMappedDataField <em>Mapped Data Field</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateMappedDataField_Aspects()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getMappedDataField
     * @model opposite="mappedDataField" containment="true"
     * @generated
     */
    EList<IntermediateImportedAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Parameter</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#getMappedDataFields <em>Mapped Data Fields</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameter</em>' container reference.
     * @see #setParameter(IntermediateParameter)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateMappedDataField_Parameter()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateParameter#getMappedDataFields
     * @model opposite="mappedDataFields" transient="false"
     * @generated
     */
    IntermediateParameter getParameter();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedDataField#getParameter <em>Parameter</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parameter</em>' container reference.
     * @see #getParameter()
     * @generated
     */
    void setParameter(IntermediateParameter value);

} // IntermediateMappedDataField
