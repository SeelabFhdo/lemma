/**
 */
package de.fhdo.lemma.data.intermediate;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Primitive type
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType#getSize <em>Size</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType#getInitializedDataField <em>Initialized Data Field</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType#getInitializedEnumerationField <em>Initialized Enumeration Field</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediatePrimitiveType()
 * @model
 * @generated
 */
public interface IntermediatePrimitiveType extends IntermediateType {
	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(Integer)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediatePrimitiveType_Size()
	 * @model unique="false"
	 * @generated
	 */
	Integer getSize();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(Integer value);

	/**
	 * Returns the value of the '<em><b>Initialized Data Field</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getInitializationValueCompatibleTypes <em>Initialization Value Compatible Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialized Data Field</em>' container reference.
	 * @see #setInitializedDataField(IntermediateDataField)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediatePrimitiveType_InitializedDataField()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataField#getInitializationValueCompatibleTypes
	 * @model opposite="initializationValueCompatibleTypes" transient="false"
	 * @generated
	 */
	IntermediateDataField getInitializedDataField();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType#getInitializedDataField <em>Initialized Data Field</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialized Data Field</em>' container reference.
	 * @see #getInitializedDataField()
	 * @generated
	 */
	void setInitializedDataField(IntermediateDataField value);

	/**
	 * Returns the value of the '<em><b>Initialized Enumeration Field</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateEnumerationField#getInitializationValueCompatibleTypes <em>Initialization Value Compatible Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialized Enumeration Field</em>' container reference.
	 * @see #setInitializedEnumerationField(IntermediateEnumerationField)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediatePrimitiveType_InitializedEnumerationField()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateEnumerationField#getInitializationValueCompatibleTypes
	 * @model opposite="initializationValueCompatibleTypes" transient="false"
	 * @generated
	 */
	IntermediateEnumerationField getInitializedEnumerationField();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType#getInitializedEnumerationField <em>Initialized Enumeration Field</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialized Enumeration Field</em>' container reference.
	 * @see #getInitializedEnumerationField()
	 * @generated
	 */
	void setInitializedEnumerationField(IntermediateEnumerationField value);

} // IntermediatePrimitiveType
