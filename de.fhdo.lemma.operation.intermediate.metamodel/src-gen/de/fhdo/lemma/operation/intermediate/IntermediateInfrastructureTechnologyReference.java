/**
 */
package de.fhdo.lemma.operation.intermediate;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Infrastructure Technology Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Reference to a infrastructure technology
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getInfrastructureNode <em>Infrastructure Node</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateInfrastructureTechnologyReference()
 * @model
 * @generated
 */
public interface IntermediateInfrastructureTechnologyReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import</em>' reference.
	 * @see #setImport(IntermediateImport)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateInfrastructureTechnologyReference_Import()
	 * @model
	 * @generated
	 */
	IntermediateImport getImport();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getImport <em>Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import</em>' reference.
	 * @see #getImport()
	 * @generated
	 */
	void setImport(IntermediateImport value);

	/**
	 * Returns the value of the '<em><b>Technology</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnology#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Technology</em>' containment reference.
	 * @see #setTechnology(IntermediateInfrastructureTechnology)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateInfrastructureTechnologyReference_Technology()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnology#getReference
	 * @model opposite="reference" containment="true"
	 * @generated
	 */
	IntermediateInfrastructureTechnology getTechnology();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getTechnology <em>Technology</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Technology</em>' containment reference.
	 * @see #getTechnology()
	 * @generated
	 */
	void setTechnology(IntermediateInfrastructureTechnology value);

	/**
	 * Returns the value of the '<em><b>Infrastructure Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infrastructure Node</em>' container reference.
	 * @see #setInfrastructureNode(IntermediateInfrastructureNode)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateInfrastructureTechnologyReference_InfrastructureNode()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getReference
	 * @model opposite="reference" transient="false"
	 * @generated
	 */
	IntermediateInfrastructureNode getInfrastructureNode();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getInfrastructureNode <em>Infrastructure Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Infrastructure Node</em>' container reference.
	 * @see #getInfrastructureNode()
	 * @generated
	 */
	void setInfrastructureNode(IntermediateInfrastructureNode value);

} // IntermediateInfrastructureTechnologyReference
