/**
 */
package de.fhdo.lemma.data.intermediate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Intermediate version
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateVersion#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateVersion#getComplexTypes <em>Complex Types</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateVersion#getContexts <em>Contexts</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateVersion#getDataModel <em>Data Model</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateVersion()
 * @model
 * @generated
 */
public interface IntermediateVersion extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateVersion_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateVersion#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Complex Types</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateComplexType}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateComplexType#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complex Types</em>' containment reference list.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateVersion_ComplexTypes()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateComplexType#getVersion
	 * @model opposite="version" containment="true"
	 * @generated
	 */
	EList<IntermediateComplexType> getComplexTypes();

	/**
	 * Returns the value of the '<em><b>Contexts</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateContext}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateContext#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contexts</em>' containment reference list.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateVersion_Contexts()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateContext#getVersion
	 * @model opposite="version" containment="true"
	 * @generated
	 */
	EList<IntermediateContext> getContexts();

	/**
	 * Returns the value of the '<em><b>Data Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateDataModel#getVersions <em>Versions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Model</em>' container reference.
	 * @see #setDataModel(IntermediateDataModel)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateVersion_DataModel()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataModel#getVersions
	 * @model opposite="versions" transient="false"
	 * @generated
	 */
	IntermediateDataModel getDataModel();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateVersion#getDataModel <em>Data Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Model</em>' container reference.
	 * @see #getDataModel()
	 * @generated
	 */
	void setDataModel(IntermediateDataModel value);

} // IntermediateVersion
