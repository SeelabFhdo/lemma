/**
 */
package de.fhdo.lemma.data.intermediate;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Imported Technology Specific Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Imported technology-specific type
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateImportedTechnologySpecificType#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateImportedTechnologySpecificType#getImport <em>Import</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateImportedTechnologySpecificType()
 * @model
 * @generated
 */
public interface IntermediateImportedTechnologySpecificType extends IntermediateType {
	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see #setQualifiedName(String)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateImportedTechnologySpecificType_QualifiedName()
	 * @model unique="false"
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedTechnologySpecificType#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import</em>' reference.
	 * @see #setImport(IntermediateImport)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateImportedTechnologySpecificType_Import()
	 * @model
	 * @generated
	 */
	IntermediateImport getImport();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedTechnologySpecificType#getImport <em>Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import</em>' reference.
	 * @see #getImport()
	 * @generated
	 */
	void setImport(IntermediateImport value);

} // IntermediateImportedTechnologySpecificType
