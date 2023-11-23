/**
 */
package de.fhdo.lemma.data;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Type Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents the import of ComplexType from other DataModel instances
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.ComplexTypeImport#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.ComplexTypeImport#getImportURI <em>Import URI</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.ComplexTypeImport#getDataModel <em>Data Model</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.DataPackage#getComplexTypeImport()
 * @model
 * @generated
 */
public interface ComplexTypeImport extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) The import URI must point to a valid file.
	 *          Ensured by: DSL validator.
	 *     (C2) Imports must not be cyclic, i.e., the imported model must not directly or indirectly
	 *          import this model.
	 *          Ensured by: DSL validator.
	 *     (C3) Name (= import alias) must be unique.
	 *          Ensured by: DSL validator.
	 *     (C4) Imported file must define a data model.
	 *          Ensured by: DSL validator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.data.DataPackage#getComplexTypeImport_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.ComplexTypeImport#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Import URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import URI</em>' attribute.
	 * @see #setImportURI(String)
	 * @see de.fhdo.lemma.data.DataPackage#getComplexTypeImport_ImportURI()
	 * @model unique="false"
	 * @generated
	 */
	String getImportURI();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.ComplexTypeImport#getImportURI <em>Import URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import URI</em>' attribute.
	 * @see #getImportURI()
	 * @generated
	 */
	void setImportURI(String value);

	/**
	 * Returns the value of the '<em><b>Data Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.DataModel#getComplexTypeImports <em>Complex Type Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Model</em>' container reference.
	 * @see #setDataModel(DataModel)
	 * @see de.fhdo.lemma.data.DataPackage#getComplexTypeImport_DataModel()
	 * @see de.fhdo.lemma.data.DataModel#getComplexTypeImports
	 * @model opposite="complexTypeImports" transient="false"
	 * @generated
	 */
	DataModel getDataModel();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.ComplexTypeImport#getDataModel <em>Data Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Model</em>' container reference.
	 * @see #getDataModel()
	 * @generated
	 */
	void setDataModel(DataModel value);

} // ComplexTypeImport
