/**
 */
package de.fhdo.lemma.data.intermediate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Operation Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Data operation parameter
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getOriginalType <em>Original Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperationParameter()
 * @model
 * @generated
 */
public interface IntermediateDataOperationParameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperationParameter_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getName <em>Name</em>}' attribute.
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
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperationParameter_QualifiedName()
	 * @model unique="false"
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateType#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(IntermediateType)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperationParameter_Type()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateType#getParameter
	 * @model opposite="parameter" containment="true"
	 * @generated
	 */
	IntermediateType getType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(IntermediateType value);

	/**
	 * Returns the value of the '<em><b>Original Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Type</em>' containment reference.
	 * @see #setOriginalType(IntermediateType)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperationParameter_OriginalType()
	 * @model containment="true"
	 * @generated
	 */
	IntermediateType getOriginalType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getOriginalType <em>Original Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Type</em>' containment reference.
	 * @see #getOriginalType()
	 * @generated
	 */
	void setOriginalType(IntermediateType value);

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperationParameter_Aspects()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getParameter
	 * @model opposite="parameter" containment="true"
	 * @generated
	 */
	EList<IntermediateImportedAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' container reference.
	 * @see #setOperation(IntermediateDataOperation)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperationParameter_Operation()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getParameters
	 * @model opposite="parameters" transient="false"
	 * @generated
	 */
	IntermediateDataOperation getOperation();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getOperation <em>Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' container reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(IntermediateDataOperation value);

} // IntermediateDataOperationParameter
