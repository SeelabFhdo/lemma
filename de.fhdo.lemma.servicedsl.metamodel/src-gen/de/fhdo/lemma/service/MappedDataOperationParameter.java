/**
 */
package de.fhdo.lemma.service;

import de.fhdo.lemma.data.DataOperationParameter;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapped Data Operation Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Concept to express technology-specific information, which was assigned to a data operation
 * parameter leveraging the Mapping DSL
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.MappedDataOperationParameter#getParameter <em>Parameter</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedDataOperationParameter#getMappedType <em>Mapped Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedDataOperationParameter#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedDataOperationParameter#getMappedOperation <em>Mapped Operation</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.ServicePackage#getMappedDataOperationParameter()
 * @model
 * @generated
 */
public interface MappedDataOperationParameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' reference.
	 * @see #setParameter(DataOperationParameter)
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedDataOperationParameter_Parameter()
	 * @model
	 * @generated
	 */
	DataOperationParameter getParameter();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.MappedDataOperationParameter#getParameter <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(DataOperationParameter value);

	/**
	 * Returns the value of the '<em><b>Mapped Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Type</em>' containment reference.
	 * @see #setMappedType(ImportedType)
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedDataOperationParameter_MappedType()
	 * @model containment="true"
	 * @generated
	 */
	ImportedType getMappedType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.MappedDataOperationParameter#getMappedType <em>Mapped Type</em>}' containment reference.
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
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.ImportedServiceAspect#getMappedDataOperationParameter <em>Mapped Data Operation Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedDataOperationParameter_Aspects()
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getMappedDataOperationParameter
	 * @model opposite="mappedDataOperationParameter" containment="true"
	 * @generated
	 */
	EList<ImportedServiceAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Mapped Operation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.MappedDataOperation#getMappedParameters <em>Mapped Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Operation</em>' container reference.
	 * @see #setMappedOperation(MappedDataOperation)
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedDataOperationParameter_MappedOperation()
	 * @see de.fhdo.lemma.service.MappedDataOperation#getMappedParameters
	 * @model opposite="mappedParameters" transient="false"
	 * @generated
	 */
	MappedDataOperation getMappedOperation();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.MappedDataOperationParameter#getMappedOperation <em>Mapped Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped Operation</em>' container reference.
	 * @see #getMappedOperation()
	 * @generated
	 */
	void setMappedOperation(MappedDataOperation value);

} // MappedDataOperationParameter
