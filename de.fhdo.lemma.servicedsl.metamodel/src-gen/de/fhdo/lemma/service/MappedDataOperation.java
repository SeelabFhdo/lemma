/**
 */
package de.fhdo.lemma.service;

import de.fhdo.lemma.data.DataOperation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapped Data Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Concept to express technology-specific information, which was assigned to a data operation
 * leveraging the Mapping DSL
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.MappedDataOperation#getDataOperation <em>Data Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedDataOperation#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedDataOperation#getMappedReturnType <em>Mapped Return Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedDataOperation#getMappedParameters <em>Mapped Parameters</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedDataOperation#getMappedComplexType <em>Mapped Complex Type</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.ServicePackage#getMappedDataOperation()
 * @model
 * @generated
 */
public interface MappedDataOperation extends EObject {
	/**
	 * Returns the value of the '<em><b>Data Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Operation</em>' reference.
	 * @see #setDataOperation(DataOperation)
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedDataOperation_DataOperation()
	 * @model
	 * @generated
	 */
	DataOperation getDataOperation();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.MappedDataOperation#getDataOperation <em>Data Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Operation</em>' reference.
	 * @see #getDataOperation()
	 * @generated
	 */
	void setDataOperation(DataOperation value);

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.ImportedServiceAspect}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.ImportedServiceAspect#getMappedDataOperation <em>Mapped Data Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedDataOperation_Aspects()
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getMappedDataOperation
	 * @model opposite="mappedDataOperation" containment="true"
	 * @generated
	 */
	EList<ImportedServiceAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Mapped Return Type</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.MappedDataOperationReturnType#getMappedOperation <em>Mapped Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Return Type</em>' containment reference.
	 * @see #setMappedReturnType(MappedDataOperationReturnType)
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedDataOperation_MappedReturnType()
	 * @see de.fhdo.lemma.service.MappedDataOperationReturnType#getMappedOperation
	 * @model opposite="mappedOperation" containment="true"
	 * @generated
	 */
	MappedDataOperationReturnType getMappedReturnType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.MappedDataOperation#getMappedReturnType <em>Mapped Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped Return Type</em>' containment reference.
	 * @see #getMappedReturnType()
	 * @generated
	 */
	void setMappedReturnType(MappedDataOperationReturnType value);

	/**
	 * Returns the value of the '<em><b>Mapped Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.MappedDataOperationParameter}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.MappedDataOperationParameter#getMappedOperation <em>Mapped Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Parameters</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedDataOperation_MappedParameters()
	 * @see de.fhdo.lemma.service.MappedDataOperationParameter#getMappedOperation
	 * @model opposite="mappedOperation" containment="true"
	 * @generated
	 */
	EList<MappedDataOperationParameter> getMappedParameters();

	/**
	 * Returns the value of the '<em><b>Mapped Complex Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.MappedComplexType#getMappedOperations <em>Mapped Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Complex Type</em>' container reference.
	 * @see #setMappedComplexType(MappedComplexType)
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedDataOperation_MappedComplexType()
	 * @see de.fhdo.lemma.service.MappedComplexType#getMappedOperations
	 * @model opposite="mappedOperations" transient="false"
	 * @generated
	 */
	MappedComplexType getMappedComplexType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.MappedDataOperation#getMappedComplexType <em>Mapped Complex Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped Complex Type</em>' container reference.
	 * @see #getMappedComplexType()
	 * @generated
	 */
	void setMappedComplexType(MappedComplexType value);

} // MappedDataOperation
