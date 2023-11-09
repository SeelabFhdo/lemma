/**
 */
package de.fhdo.lemma.data.intermediate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Intermediate context
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateContext#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateContext#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateContext#getComplexTypes <em>Complex Types</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateContext#getDataModel <em>Data Model</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateContext#getVersion <em>Version</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateContext()
 * @model
 * @generated
 */
public interface IntermediateContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateContext_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateContext#getName <em>Name</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see #setQualifiedName(String)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateContext_QualifiedName()
	 * @model unique="false"
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateContext#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Complex Types</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateComplexType}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateComplexType#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complex Types</em>' containment reference list.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateContext_ComplexTypes()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateComplexType#getContext
	 * @model opposite="context" containment="true" required="true"
	 * @generated
	 */
	EList<IntermediateComplexType> getComplexTypes();

	/**
	 * Returns the value of the '<em><b>Data Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateDataModel#getContexts <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Model</em>' container reference.
	 * @see #setDataModel(IntermediateDataModel)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateContext_DataModel()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataModel#getContexts
	 * @model opposite="contexts" transient="false"
	 * @generated
	 */
	IntermediateDataModel getDataModel();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateContext#getDataModel <em>Data Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Model</em>' container reference.
	 * @see #getDataModel()
	 * @generated
	 */
	void setDataModel(IntermediateDataModel value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateVersion#getContexts <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' container reference.
	 * @see #setVersion(IntermediateVersion)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateContext_Version()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateVersion#getContexts
	 * @model opposite="contexts" transient="false"
	 * @generated
	 */
	IntermediateVersion getVersion();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateContext#getVersion <em>Version</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' container reference.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(IntermediateVersion value);

} // IntermediateContext
