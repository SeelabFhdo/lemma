/**
 */
package de.fhdo.lemma.service;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapped Data Operation Return Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Concept to express technology-specific information, which was assigned to the return type of a
 * data operation leveraging the Mapping DSL
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.MappedDataOperationReturnType#getMappedType <em>Mapped Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedDataOperationReturnType#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedDataOperationReturnType#getMappedOperation <em>Mapped Operation</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.ServicePackage#getMappedDataOperationReturnType()
 * @model
 * @generated
 */
public interface MappedDataOperationReturnType extends EObject {
	/**
	 * Returns the value of the '<em><b>Mapped Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Type</em>' containment reference.
	 * @see #setMappedType(ImportedType)
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedDataOperationReturnType_MappedType()
	 * @model containment="true"
	 * @generated
	 */
	ImportedType getMappedType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.MappedDataOperationReturnType#getMappedType <em>Mapped Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped Type</em>' containment reference.
	 * @see #getMappedType()
	 * @generated
	 */
	void setMappedType(ImportedType value);

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.ImportedServiceAspect}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.ImportedServiceAspect#getMappedDataOperationReturnType <em>Mapped Data Operation Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedDataOperationReturnType_Aspects()
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getMappedDataOperationReturnType
	 * @model opposite="mappedDataOperationReturnType" containment="true"
	 * @generated
	 */
	EList<ImportedServiceAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Mapped Operation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.MappedDataOperation#getMappedReturnType <em>Mapped Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Operation</em>' container reference.
	 * @see #setMappedOperation(MappedDataOperation)
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedDataOperationReturnType_MappedOperation()
	 * @see de.fhdo.lemma.service.MappedDataOperation#getMappedReturnType
	 * @model opposite="mappedReturnType" transient="false"
	 * @generated
	 */
	MappedDataOperation getMappedOperation();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.MappedDataOperationReturnType#getMappedOperation <em>Mapped Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped Operation</em>' container reference.
	 * @see #getMappedOperation()
	 * @generated
	 */
	void setMappedOperation(MappedDataOperation value);

} // MappedDataOperationReturnType
