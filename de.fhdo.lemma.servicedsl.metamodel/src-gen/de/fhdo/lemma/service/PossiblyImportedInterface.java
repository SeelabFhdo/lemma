/**
 */
package de.fhdo.lemma.service;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Possibly Imported Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * An interface possibly imported from another service model
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.PossiblyImportedInterface#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.PossiblyImportedInterface#getInterface <em>Interface</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.PossiblyImportedInterface#getRequiringMicroservice <em>Requiring Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.PossiblyImportedInterface#isRequired <em>Required</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.PossiblyImportedInterface#isRequiredByContainer <em>Required By Container</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.ServicePackage#getPossiblyImportedInterface()
 * @model
 * @generated
 */
public interface PossiblyImportedInterface extends EObject {
	/**
	 * Returns the value of the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import</em>' reference.
	 * @see #setImport(Import)
	 * @see de.fhdo.lemma.service.ServicePackage#getPossiblyImportedInterface_Import()
	 * @model
	 * @generated
	 */
	Import getImport();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.PossiblyImportedInterface#getImport <em>Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import</em>' reference.
	 * @see #getImport()
	 * @generated
	 */
	void setImport(Import value);

	/**
	 * Returns the value of the '<em><b>Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface</em>' reference.
	 * @see #setInterface(Interface)
	 * @see de.fhdo.lemma.service.ServicePackage#getPossiblyImportedInterface_Interface()
	 * @model
	 * @generated
	 */
	Interface getInterface();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.PossiblyImportedInterface#getInterface <em>Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' reference.
	 * @see #getInterface()
	 * @generated
	 */
	void setInterface(Interface value);

	/**
	 * Returns the value of the '<em><b>Requiring Microservice</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Microservice#getRequiredInterfaces <em>Required Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiring Microservice</em>' container reference.
	 * @see #setRequiringMicroservice(Microservice)
	 * @see de.fhdo.lemma.service.ServicePackage#getPossiblyImportedInterface_RequiringMicroservice()
	 * @see de.fhdo.lemma.service.Microservice#getRequiredInterfaces
	 * @model opposite="requiredInterfaces" transient="false"
	 * @generated
	 */
	Microservice getRequiringMicroservice();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.PossiblyImportedInterface#getRequiringMicroservice <em>Requiring Microservice</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requiring Microservice</em>' container reference.
	 * @see #getRequiringMicroservice()
	 * @generated
	 */
	void setRequiringMicroservice(Microservice value);

	/**
	 * Returns the value of the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Flag to indicate if the interface is required by a microservice
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Required</em>' attribute.
	 * @see de.fhdo.lemma.service.ServicePackage#getPossiblyImportedInterface_Required()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Returns the value of the '<em><b>Required By Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Flag to indicate if the interface is already required, because its container, i.e., its
	 * containing microservice, is required
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Required By Container</em>' attribute.
	 * @see de.fhdo.lemma.service.ServicePackage#getPossiblyImportedInterface_RequiredByContainer()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isRequiredByContainer();

} // PossiblyImportedInterface
