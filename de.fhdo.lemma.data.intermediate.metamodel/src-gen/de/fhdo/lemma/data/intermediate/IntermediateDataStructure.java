/**
 */
package de.fhdo.lemma.data.intermediate;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Data structure
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataStructure#getFeatureNames <em>Feature Names</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataStructure#getSuper <em>Super</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataStructure#getOperations <em>Operations</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataStructure#getDataFields <em>Data Fields</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataStructure()
 * @model
 * @generated
 */
public interface IntermediateDataStructure extends IntermediateComplexType {
	/**
	 * Returns the value of the '<em><b>Feature Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Names</em>' attribute list.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataStructure_FeatureNames()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getFeatureNames();

	/**
	 * Returns the value of the '<em><b>Super</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super</em>' reference.
	 * @see #setSuper(IntermediateDataStructure)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataStructure_Super()
	 * @model
	 * @generated
	 */
	IntermediateDataStructure getSuper();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataStructure#getSuper <em>Super</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super</em>' reference.
	 * @see #getSuper()
	 * @generated
	 */
	void setSuper(IntermediateDataStructure value);

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getDataStructure <em>Data Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataStructure_Operations()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getDataStructure
	 * @model opposite="dataStructure" containment="true"
	 * @generated
	 */
	EList<IntermediateDataOperation> getOperations();

	/**
	 * Returns the value of the '<em><b>Data Fields</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateDataField}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getDataStructure <em>Data Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Fields</em>' containment reference list.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataStructure_DataFields()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataField#getDataStructure
	 * @model opposite="dataStructure" containment="true"
	 * @generated
	 */
	EList<IntermediateDataField> getDataFields();

} // IntermediateDataStructure
