/**
 */
package de.fhdo.lemma.service;

import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.EnumerationField;
import de.fhdo.lemma.data.Type;

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
 *   <li>{@link de.fhdo.lemma.service.MappedField#getDataField <em>Data Field</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedField#getEnumerationField <em>Enumeration Field</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedField#getMappedType <em>Mapped Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedField#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedField#getParameter <em>Parameter</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedField#getMappedComplexType <em>Mapped Complex Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedField#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.ServicePackage#getMappedField()
 * @model
 * @generated
 */
public interface MappedField extends EObject {
	/**
	 * Returns the value of the '<em><b>Data Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Field</em>' reference.
	 * @see #setDataField(DataField)
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedField_DataField()
	 * @model
	 * @generated
	 */
	DataField getDataField();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.MappedField#getDataField <em>Data Field</em>}' reference.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration Field</em>' reference.
	 * @see #setEnumerationField(EnumerationField)
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedField_EnumerationField()
	 * @model
	 * @generated
	 */
	EnumerationField getEnumerationField();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.MappedField#getEnumerationField <em>Enumeration Field</em>}' reference.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Type</em>' containment reference.
	 * @see #setMappedType(ImportedType)
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedField_MappedType()
	 * @model containment="true"
	 * @generated
	 */
	ImportedType getMappedType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.MappedField#getMappedType <em>Mapped Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped Type</em>' containment reference.
	 * @see #getMappedType()
	 * @generated
	 */
	void setMappedType(ImportedType value);

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.ImportedServiceAspect}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.ImportedServiceAspect#getMappedField <em>Mapped Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedField_Aspects()
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getMappedField
	 * @model opposite="mappedField" containment="true"
	 * @generated
	 */
	EList<ImportedServiceAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Parameter#getMappedFields <em>Mapped Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' container reference.
	 * @see #setParameter(Parameter)
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedField_Parameter()
	 * @see de.fhdo.lemma.service.Parameter#getMappedFields
	 * @model opposite="mappedFields" transient="false"
	 * @generated
	 */
	Parameter getParameter();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.MappedField#getParameter <em>Parameter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' container reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(Parameter value);

	/**
	 * Returns the value of the '<em><b>Mapped Complex Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.MappedComplexType#getMappedFields <em>Mapped Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Complex Type</em>' container reference.
	 * @see #setMappedComplexType(MappedComplexType)
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedField_MappedComplexType()
	 * @see de.fhdo.lemma.service.MappedComplexType#getMappedFields
	 * @model opposite="mappedFields" transient="false"
	 * @generated
	 */
	MappedComplexType getMappedComplexType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.MappedField#getMappedComplexType <em>Mapped Complex Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped Complex Type</em>' container reference.
	 * @see #getMappedComplexType()
	 * @generated
	 */
	void setMappedComplexType(MappedComplexType value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get name of mapped field
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedField_Name()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get parts of the mapped field for creating a fully-qualified name
	 * <!-- end-model-doc -->
	 * @model unique="false" withImportNameUnique="false"
	 * @generated
	 */
	EList<String> getQualifiedNameParts(boolean withImportName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Build qualified name from qualified name parts
	 * <!-- end-model-doc -->
	 * @model unique="false" separatorUnique="false" withImportNameUnique="false"
	 * @generated
	 */
	String buildQualifiedName(String separator, boolean withImportName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get the effective type of the mapped data field. The effective type corresponds to the mapped
	 * type, if the data field or enumeration field has one. Otherwise, it is the effective type of
	 * the data field itself or the enumeration that comprises the enumeration field.
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Type getEffectiveType();

} // MappedField
