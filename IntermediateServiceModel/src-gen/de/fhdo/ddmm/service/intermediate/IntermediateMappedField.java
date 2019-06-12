/**
 */
package de.fhdo.ddmm.service.intermediate;

import de.fhdo.ddmm.data.intermediate.IntermediateType;
import de.fhdo.ddmm.data.intermediate.IntermediateTypeKind;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapped Field</b></em>'.
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
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedField#getMappedFieldName <em>Mapped Field Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedField#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedField#getOriginalTypeKind <em>Original Type Kind</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedField#getMappedType <em>Mapped Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedField#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedField#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateMappedField()
 * @model
 * @generated
 */
public interface IntermediateMappedField extends EObject {
    /**
     * Returns the value of the '<em><b>Mapped Field Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mapped Field Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mapped Field Name</em>' attribute.
     * @see #setMappedFieldName(String)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateMappedField_MappedFieldName()
     * @model unique="false"
     * @generated
     */
    String getMappedFieldName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedField#getMappedFieldName <em>Mapped Field Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mapped Field Name</em>' attribute.
     * @see #getMappedFieldName()
     * @generated
     */
    void setMappedFieldName(String value);

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
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateMappedField_QualifiedName()
     * @model unique="false"
     * @generated
     */
    String getQualifiedName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedField#getQualifiedName <em>Qualified Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Qualified Name</em>' attribute.
     * @see #getQualifiedName()
     * @generated
     */
    void setQualifiedName(String value);

    /**
     * Returns the value of the '<em><b>Original Type Kind</b></em>' attribute.
     * The literals are from the enumeration {@link de.fhdo.ddmm.data.intermediate.IntermediateTypeKind}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Original Type Kind</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Original Type Kind</em>' attribute.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateTypeKind
     * @see #setOriginalTypeKind(IntermediateTypeKind)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateMappedField_OriginalTypeKind()
     * @model unique="false"
     * @generated
     */
    IntermediateTypeKind getOriginalTypeKind();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedField#getOriginalTypeKind <em>Original Type Kind</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Original Type Kind</em>' attribute.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateTypeKind
     * @see #getOriginalTypeKind()
     * @generated
     */
    void setOriginalTypeKind(IntermediateTypeKind value);

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
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateMappedField_MappedType()
     * @model containment="true"
     * @generated
     */
    IntermediateType getMappedType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedField#getMappedType <em>Mapped Type</em>}' containment reference.
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
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getMappedField <em>Mapped Field</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateMappedField_Aspects()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getMappedField
     * @model opposite="mappedField" containment="true"
     * @generated
     */
    EList<IntermediateImportedAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Parameter</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#getMappedFields <em>Mapped Fields</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameter</em>' container reference.
     * @see #setParameter(IntermediateParameter)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateMappedField_Parameter()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateParameter#getMappedFields
     * @model opposite="mappedFields" transient="false"
     * @generated
     */
    IntermediateParameter getParameter();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedField#getParameter <em>Parameter</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parameter</em>' container reference.
     * @see #getParameter()
     * @generated
     */
    void setParameter(IntermediateParameter value);

} // IntermediateMappedField
