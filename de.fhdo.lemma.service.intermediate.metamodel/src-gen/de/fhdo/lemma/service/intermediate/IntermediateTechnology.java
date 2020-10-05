/**
 */
package de.fhdo.lemma.service.intermediate;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Technology</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Technology
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateTechnology#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateTechnology#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateTechnology#getMicroservice <em>Microservice</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateTechnology()
 * @model
 * @generated
 */
public interface IntermediateTechnology extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateTechnology_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateTechnology#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import</em>' reference.
	 * @see #setImport(IntermediateImport)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateTechnology_Import()
	 * @model
	 * @generated
	 */
	IntermediateImport getImport();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateTechnology#getImport <em>Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import</em>' reference.
	 * @see #getImport()
	 * @generated
	 */
	void setImport(IntermediateImport value);

	/**
	 * Returns the value of the '<em><b>Microservice</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getTechnologies <em>Technologies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Microservice</em>' container reference.
	 * @see #setMicroservice(IntermediateMicroservice)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateTechnology_Microservice()
	 * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getTechnologies
	 * @model opposite="technologies" transient="false"
	 * @generated
	 */
	IntermediateMicroservice getMicroservice();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateTechnology#getMicroservice <em>Microservice</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Microservice</em>' container reference.
	 * @see #getMicroservice()
	 * @generated
	 */
	void setMicroservice(IntermediateMicroservice value);

} // IntermediateTechnology
