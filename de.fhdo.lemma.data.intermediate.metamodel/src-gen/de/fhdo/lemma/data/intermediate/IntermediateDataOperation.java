/**
 */
package de.fhdo.lemma.data.intermediate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Data operation
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#isHidden <em>Hidden</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#isInherited <em>Inherited</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getFeatureNames <em>Feature Names</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getDataStructure <em>Data Structure</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperation()
 * @model
 * @generated
 */
public interface IntermediateDataOperation extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperation_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getName <em>Name</em>}' attribute.
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
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperation_QualifiedName()
	 * @model unique="false"
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Hidden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hidden</em>' attribute.
	 * @see #setHidden(boolean)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperation_Hidden()
	 * @model unique="false"
	 * @generated
	 */
	boolean isHidden();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#isHidden <em>Hidden</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hidden</em>' attribute.
	 * @see #isHidden()
	 * @generated
	 */
	void setHidden(boolean value);

	/**
	 * Returns the value of the '<em><b>Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited</em>' attribute.
	 * @see #setInherited(boolean)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperation_Inherited()
	 * @model unique="false"
	 * @generated
	 */
	boolean isInherited();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#isInherited <em>Inherited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inherited</em>' attribute.
	 * @see #isInherited()
	 * @generated
	 */
	void setInherited(boolean value);

	/**
	 * Returns the value of the '<em><b>Feature Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Names</em>' attribute list.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperation_FeatureNames()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getFeatureNames();

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' containment reference.
	 * @see #setReturnType(IntermediateDataOperationReturnType)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperation_ReturnType()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType#getOperation
	 * @model opposite="operation" containment="true"
	 * @generated
	 */
	IntermediateDataOperationReturnType getReturnType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getReturnType <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' containment reference.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(IntermediateDataOperationReturnType value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperation_Parameters()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getOperation
	 * @model opposite="operation" containment="true"
	 * @generated
	 */
	EList<IntermediateDataOperationParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperation_Aspects()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getOperation
	 * @model opposite="operation" containment="true"
	 * @generated
	 */
	EList<IntermediateImportedAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Data Structure</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateDataStructure#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Structure</em>' container reference.
	 * @see #setDataStructure(IntermediateDataStructure)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataOperation_DataStructure()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataStructure#getOperations
	 * @model opposite="operations" transient="false"
	 * @generated
	 */
	IntermediateDataStructure getDataStructure();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getDataStructure <em>Data Structure</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Structure</em>' container reference.
	 * @see #getDataStructure()
	 * @generated
	 */
	void setDataStructure(IntermediateDataStructure value);

} // IntermediateDataOperation
