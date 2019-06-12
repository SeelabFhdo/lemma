/**
 */
package de.fhdo.ddmm.service;

import de.fhdo.ddmm.data.DataField;
import de.fhdo.ddmm.data.EnumerationField;
import de.fhdo.ddmm.data.Type;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapped Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Concept to express technology-specific information, which was assigned to a data or enumeration
 * field leveraging the Mapping DSL
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.MappedField#getDataField <em>Data Field</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.MappedField#getEnumerationField <em>Enumeration Field</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.MappedField#getMappedType <em>Mapped Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.MappedField#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.MappedField#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.ServicePackage#getMappedField()
 * @model
 * @generated
 */
public interface MappedField extends EObject {
    /**
     * Returns the value of the '<em><b>Data Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Field</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Field</em>' reference.
     * @see #setDataField(DataField)
     * @see de.fhdo.ddmm.service.ServicePackage#getMappedField_DataField()
     * @model
     * @generated
     */
    DataField getDataField();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.MappedField#getDataField <em>Data Field</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Field</em>' reference.
     * @see #getDataField()
     * @generated
     */
    void setDataField(DataField value);

    /**
     * Returns the value of the '<em><b>Enumeration Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Enumeration Field</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Enumeration Field</em>' reference.
     * @see #setEnumerationField(EnumerationField)
     * @see de.fhdo.ddmm.service.ServicePackage#getMappedField_EnumerationField()
     * @model
     * @generated
     */
    EnumerationField getEnumerationField();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.MappedField#getEnumerationField <em>Enumeration Field</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enumeration Field</em>' reference.
     * @see #getEnumerationField()
     * @generated
     */
    void setEnumerationField(EnumerationField value);

    /**
     * Returns the value of the '<em><b>Mapped Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mapped Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mapped Type</em>' containment reference.
     * @see #setMappedType(ImportedType)
     * @see de.fhdo.ddmm.service.ServicePackage#getMappedField_MappedType()
     * @model containment="true"
     * @generated
     */
    ImportedType getMappedType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.MappedField#getMappedType <em>Mapped Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mapped Type</em>' containment reference.
     * @see #getMappedType()
     * @generated
     */
    void setMappedType(ImportedType value);

    /**
     * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.ImportedServiceAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.ImportedServiceAspect#getMappedField <em>Mapped Field</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getMappedField_Aspects()
     * @see de.fhdo.ddmm.service.ImportedServiceAspect#getMappedField
     * @model opposite="mappedField" containment="true"
     * @generated
     */
    EList<ImportedServiceAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Parameter</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Parameter#getMappedFields <em>Mapped Fields</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameter</em>' container reference.
     * @see #setParameter(Parameter)
     * @see de.fhdo.ddmm.service.ServicePackage#getMappedField_Parameter()
     * @see de.fhdo.ddmm.service.Parameter#getMappedFields
     * @model opposite="mappedFields" transient="false"
     * @generated
     */
    Parameter getParameter();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.MappedField#getParameter <em>Parameter</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parameter</em>' container reference.
     * @see #getParameter()
     * @generated
     */
    void setParameter(Parameter value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get parts of the parameter for creating a qualified name
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     * @generated
     */
    EList<String> getQualifiedNameParts();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Build qualified name from qualified name parts
     * <!-- end-model-doc -->
     * @model unique="false" separatorUnique="false"
     * @generated
     */
    String buildQualifiedName(String separator);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get the effective type of the mapped data field. The effective type corresponds to the mapped
     * type, if the field has one. Otherwise, it is the effective type of the field itself.
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     * @generated
     */
    Type getEffectiveType();

} // MappedField
