/**
 */
package de.fhdo.lemma.service;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Possibly Imported Microservice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A microservice possibly imported from another service model
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.PossiblyImportedMicroservice#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.PossiblyImportedMicroservice#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.PossiblyImportedMicroservice#getRequiringMicroservice <em>Requiring Microservice</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.ServicePackage#getPossiblyImportedMicroservice()
 * @model
 * @generated
 */
public interface PossiblyImportedMicroservice extends EObject {
	/**
	 * Returns the value of the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import</em>' reference.
	 * @see #setImport(Import)
	 * @see de.fhdo.lemma.service.ServicePackage#getPossiblyImportedMicroservice_Import()
	 * @model
	 * @generated
	 */
	Import getImport();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.PossiblyImportedMicroservice#getImport <em>Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import</em>' reference.
	 * @see #getImport()
	 * @generated
	 */
	void setImport(Import value);

	/**
	 * Returns the value of the '<em><b>Microservice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Microservice</em>' reference.
	 * @see #setMicroservice(Microservice)
	 * @see de.fhdo.lemma.service.ServicePackage#getPossiblyImportedMicroservice_Microservice()
	 * @model
	 * @generated
	 */
	Microservice getMicroservice();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.PossiblyImportedMicroservice#getMicroservice <em>Microservice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Microservice</em>' reference.
	 * @see #getMicroservice()
	 * @generated
	 */
	void setMicroservice(Microservice value);

	/**
	 * Returns the value of the '<em><b>Requiring Microservice</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Microservice#getRequiredMicroservices <em>Required Microservices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiring Microservice</em>' container reference.
	 * @see #setRequiringMicroservice(Microservice)
	 * @see de.fhdo.lemma.service.ServicePackage#getPossiblyImportedMicroservice_RequiringMicroservice()
	 * @see de.fhdo.lemma.service.Microservice#getRequiredMicroservices
	 * @model opposite="requiredMicroservices" transient="false"
	 * @generated
	 */
	Microservice getRequiringMicroservice();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.PossiblyImportedMicroservice#getRequiringMicroservice <em>Requiring Microservice</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requiring Microservice</em>' container reference.
	 * @see #getRequiringMicroservice()
	 * @generated
	 */
	void setRequiringMicroservice(Microservice value);

} // PossiblyImportedMicroservice
