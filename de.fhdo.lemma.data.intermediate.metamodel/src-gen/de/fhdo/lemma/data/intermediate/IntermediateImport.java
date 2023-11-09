/**
 */
package de.fhdo.lemma.data.intermediate;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Import
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateImport#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateImport#getImportUri <em>Import Uri</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateImport#getImportTypeName <em>Import Type Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateImport#getDataModel <em>Data Model</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateImport#getImportTypeNameForDatatypes <em>Import Type Name For Datatypes</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateImport()
 * @model
 * @generated
 */
public interface IntermediateImport extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateImport_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateImport#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Import Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Uri</em>' attribute.
	 * @see #setImportUri(String)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateImport_ImportUri()
	 * @model unique="false"
	 * @generated
	 */
	String getImportUri();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateImport#getImportUri <em>Import Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import Uri</em>' attribute.
	 * @see #getImportUri()
	 * @generated
	 */
	void setImportUri(String value);

	/**
	 * Returns the value of the '<em><b>Import Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Type Name</em>' attribute.
	 * @see #setImportTypeName(String)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateImport_ImportTypeName()
	 * @model unique="false"
	 * @generated
	 */
	String getImportTypeName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateImport#getImportTypeName <em>Import Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import Type Name</em>' attribute.
	 * @see #getImportTypeName()
	 * @generated
	 */
	void setImportTypeName(String value);

	/**
	 * Returns the value of the '<em><b>Data Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateDataModel#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Model</em>' container reference.
	 * @see #setDataModel(IntermediateDataModel)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateImport_DataModel()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataModel#getImports
	 * @model opposite="imports" transient="false"
	 * @generated
	 */
	IntermediateDataModel getDataModel();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateImport#getDataModel <em>Data Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Model</em>' container reference.
	 * @see #getDataModel()
	 * @generated
	 */
	void setDataModel(IntermediateDataModel value);

	/**
	 * Returns the value of the '<em><b>Import Type Name For Datatypes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Helper to return the String representation of the DATATYPES ImportType enum constant in a
	 * type-safe way. This is necessary to cope with the bug in the XMI serializer (see above).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Import Type Name For Datatypes</em>' attribute.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateImport_ImportTypeNameForDatatypes()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getImportTypeNameForDatatypes();

} // IntermediateImport
