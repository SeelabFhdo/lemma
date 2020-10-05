/**
 */
package de.fhdo.lemma.service;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Possibly Imported Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * An operation possibly imported from another service model
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.PossiblyImportedOperation#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.PossiblyImportedOperation#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.PossiblyImportedOperation#getRequiringMicroservice <em>Requiring Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.PossiblyImportedOperation#getInitializedParameter <em>Initialized Parameter</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.PossiblyImportedOperation#isRequired <em>Required</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.PossiblyImportedOperation#isRequiredByInterface <em>Required By Interface</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.PossiblyImportedOperation#isRequiredByMicroservice <em>Required By Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.PossiblyImportedOperation#isRequiredByContainer <em>Required By Container</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.ServicePackage#getPossiblyImportedOperation()
 * @model
 * @generated
 */
public interface PossiblyImportedOperation extends EObject {
	/**
	 * Returns the value of the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import</em>' reference.
	 * @see #setImport(Import)
	 * @see de.fhdo.lemma.service.ServicePackage#getPossiblyImportedOperation_Import()
	 * @model
	 * @generated
	 */
	Import getImport();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.PossiblyImportedOperation#getImport <em>Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import</em>' reference.
	 * @see #getImport()
	 * @generated
	 */
	void setImport(Import value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(Operation)
	 * @see de.fhdo.lemma.service.ServicePackage#getPossiblyImportedOperation_Operation()
	 * @model
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.PossiblyImportedOperation#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operation value);

	/**
	 * Returns the value of the '<em><b>Requiring Microservice</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Microservice#getRequiredOperations <em>Required Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiring Microservice</em>' container reference.
	 * @see #setRequiringMicroservice(Microservice)
	 * @see de.fhdo.lemma.service.ServicePackage#getPossiblyImportedOperation_RequiringMicroservice()
	 * @see de.fhdo.lemma.service.Microservice#getRequiredOperations
	 * @model opposite="requiredOperations" transient="false"
	 * @generated
	 */
	Microservice getRequiringMicroservice();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.PossiblyImportedOperation#getRequiringMicroservice <em>Requiring Microservice</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requiring Microservice</em>' container reference.
	 * @see #getRequiringMicroservice()
	 * @generated
	 */
	void setRequiringMicroservice(Microservice value);

	/**
	 * Returns the value of the '<em><b>Initialized Parameter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Parameter#getInitializedByOperation <em>Initialized By Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialized Parameter</em>' container reference.
	 * @see #setInitializedParameter(Parameter)
	 * @see de.fhdo.lemma.service.ServicePackage#getPossiblyImportedOperation_InitializedParameter()
	 * @see de.fhdo.lemma.service.Parameter#getInitializedByOperation
	 * @model opposite="initializedByOperation" transient="false"
	 * @generated
	 */
	Parameter getInitializedParameter();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.PossiblyImportedOperation#getInitializedParameter <em>Initialized Parameter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialized Parameter</em>' container reference.
	 * @see #getInitializedParameter()
	 * @generated
	 */
	void setInitializedParameter(Parameter value);

	/**
	 * Returns the value of the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Flag to indicate if the operation is required by a microservice
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Required</em>' attribute.
	 * @see de.fhdo.lemma.service.ServicePackage#getPossiblyImportedOperation_Required()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Returns the value of the '<em><b>Required By Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Flag to indicate if the operation is already required, because its interface is required
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Required By Interface</em>' attribute.
	 * @see de.fhdo.lemma.service.ServicePackage#getPossiblyImportedOperation_RequiredByInterface()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isRequiredByInterface();

	/**
	 * Returns the value of the '<em><b>Required By Microservice</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Flag to indicate if the operation is already required, because its microservice is required
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Required By Microservice</em>' attribute.
	 * @see de.fhdo.lemma.service.ServicePackage#getPossiblyImportedOperation_RequiredByMicroservice()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isRequiredByMicroservice();

	/**
	 * Returns the value of the '<em><b>Required By Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Flag to indicate if the operation is already required, because its containers, i.e., its
	 * interface or indirectly containing microservice, is required
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Required By Container</em>' attribute.
	 * @see de.fhdo.lemma.service.ServicePackage#getPossiblyImportedOperation_RequiredByContainer()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isRequiredByContainer();

} // PossiblyImportedOperation
