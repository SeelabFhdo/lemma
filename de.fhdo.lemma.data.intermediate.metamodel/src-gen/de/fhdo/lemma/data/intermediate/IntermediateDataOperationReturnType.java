/**
 */
package de.fhdo.lemma.data.intermediate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Operation Return Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Data operation return type
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType#getOriginalType <em>Original Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperationReturnType()
 * @model
 * @generated
 */
public interface IntermediateDataOperationReturnType extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateType#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(IntermediateType)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperationReturnType_Type()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateType#getReturnType
	 * @model opposite="returnType" containment="true"
	 * @generated
	 */
	IntermediateType getType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType#getType <em>Type</em>}' containment reference.
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
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperationReturnType_OriginalType()
	 * @model containment="true"
	 * @generated
	 */
	IntermediateType getOriginalType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType#getOriginalType <em>Original Type</em>}' containment reference.
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
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperationReturnType_Aspects()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getReturnType
	 * @model opposite="returnType" containment="true"
	 * @generated
	 */
	EList<IntermediateImportedAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' container reference.
	 * @see #setOperation(IntermediateDataOperation)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperationReturnType_Operation()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getReturnType
	 * @model opposite="returnType" transient="false"
	 * @generated
	 */
	IntermediateDataOperation getOperation();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType#getOperation <em>Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' container reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(IntermediateDataOperation value);

} // IntermediateDataOperationReturnType
