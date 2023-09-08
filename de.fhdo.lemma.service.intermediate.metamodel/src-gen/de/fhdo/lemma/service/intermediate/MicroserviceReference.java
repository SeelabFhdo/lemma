/**
 */
package de.fhdo.lemma.service.intermediate;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Microservice Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Reference to a microservice required by another microservice
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#getVersion <em>Version</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#isImported <em>Imported</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#getLocalMicroservice <em>Local Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#getRequiringMicroservice <em>Requiring Microservice</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getMicroserviceReference()
 * @model
 * @generated
 */
public interface MicroserviceReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getMicroserviceReference_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getMicroserviceReference_Version()
	 * @model unique="false"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see #setQualifiedName(String)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getMicroserviceReference_QualifiedName()
	 * @model unique="false"
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Imported</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported</em>' attribute.
	 * @see #setImported(boolean)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getMicroserviceReference_Imported()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isImported();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#isImported <em>Imported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported</em>' attribute.
	 * @see #isImported()
	 * @generated
	 */
	void setImported(boolean value);

	/**
	 * Returns the value of the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import</em>' reference.
	 * @see #setImport(IntermediateImport)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getMicroserviceReference_Import()
	 * @model
	 * @generated
	 */
	IntermediateImport getImport();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#getImport <em>Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import</em>' reference.
	 * @see #getImport()
	 * @generated
	 */
	void setImport(IntermediateImport value);

	/**
	 * Returns the value of the '<em><b>Local Microservice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Microservice</em>' reference.
	 * @see #setLocalMicroservice(IntermediateMicroservice)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getMicroserviceReference_LocalMicroservice()
	 * @model
	 * @generated
	 */
	IntermediateMicroservice getLocalMicroservice();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#getLocalMicroservice <em>Local Microservice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Microservice</em>' reference.
	 * @see #getLocalMicroservice()
	 * @generated
	 */
	void setLocalMicroservice(IntermediateMicroservice value);

	/**
	 * Returns the value of the '<em><b>Requiring Microservice</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getRequiredMicroservices <em>Required Microservices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiring Microservice</em>' container reference.
	 * @see #setRequiringMicroservice(IntermediateMicroservice)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getMicroserviceReference_RequiringMicroservice()
	 * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getRequiredMicroservices
	 * @model opposite="requiredMicroservices" transient="false"
	 * @generated
	 */
	IntermediateMicroservice getRequiringMicroservice();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#getRequiringMicroservice <em>Requiring Microservice</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requiring Microservice</em>' container reference.
	 * @see #getRequiringMicroservice()
	 * @generated
	 */
	void setRequiringMicroservice(IntermediateMicroservice value);

} // MicroserviceReference
