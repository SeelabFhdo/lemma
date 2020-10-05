/**
 */
package de.fhdo.lemma.service.intermediate;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Reference to an operation required by a microservice
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.intermediate.OperationReference#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.OperationReference#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.OperationReference#isImported <em>Imported</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.OperationReference#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.OperationReference#getLocalOperation <em>Local Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.OperationReference#getRequiringMicroservice <em>Requiring Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.OperationReference#getInitializedParameter <em>Initialized Parameter</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getOperationReference()
 * @model
 * @generated
 */
public interface OperationReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getOperationReference_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.OperationReference#getName <em>Name</em>}' attribute.
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
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getOperationReference_QualifiedName()
	 * @model unique="false"
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.OperationReference#getQualifiedName <em>Qualified Name</em>}' attribute.
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
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getOperationReference_Imported()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isImported();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.OperationReference#isImported <em>Imported</em>}' attribute.
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
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getOperationReference_Import()
	 * @model
	 * @generated
	 */
	IntermediateImport getImport();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.OperationReference#getImport <em>Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import</em>' reference.
	 * @see #getImport()
	 * @generated
	 */
	void setImport(IntermediateImport value);

	/**
	 * Returns the value of the '<em><b>Local Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Operation</em>' reference.
	 * @see #setLocalOperation(IntermediateOperation)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getOperationReference_LocalOperation()
	 * @model
	 * @generated
	 */
	IntermediateOperation getLocalOperation();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.OperationReference#getLocalOperation <em>Local Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Operation</em>' reference.
	 * @see #getLocalOperation()
	 * @generated
	 */
	void setLocalOperation(IntermediateOperation value);

	/**
	 * Returns the value of the '<em><b>Requiring Microservice</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getRequiredOperations <em>Required Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiring Microservice</em>' container reference.
	 * @see #setRequiringMicroservice(IntermediateMicroservice)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getOperationReference_RequiringMicroservice()
	 * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getRequiredOperations
	 * @model opposite="requiredOperations" transient="false"
	 * @generated
	 */
	IntermediateMicroservice getRequiringMicroservice();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.OperationReference#getRequiringMicroservice <em>Requiring Microservice</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requiring Microservice</em>' container reference.
	 * @see #getRequiringMicroservice()
	 * @generated
	 */
	void setRequiringMicroservice(IntermediateMicroservice value);

	/**
	 * Returns the value of the '<em><b>Initialized Parameter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getInitializedByOperation <em>Initialized By Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialized Parameter</em>' container reference.
	 * @see #setInitializedParameter(IntermediateParameter)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getOperationReference_InitializedParameter()
	 * @see de.fhdo.lemma.service.intermediate.IntermediateParameter#getInitializedByOperation
	 * @model opposite="initializedByOperation" transient="false"
	 * @generated
	 */
	IntermediateParameter getInitializedParameter();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.OperationReference#getInitializedParameter <em>Initialized Parameter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialized Parameter</em>' container reference.
	 * @see #getInitializedParameter()
	 * @generated
	 */
	void setInitializedParameter(IntermediateParameter value);

} // OperationReference
