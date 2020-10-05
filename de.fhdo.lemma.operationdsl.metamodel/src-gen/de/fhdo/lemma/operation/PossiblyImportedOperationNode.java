/**
 */
package de.fhdo.lemma.operation;

import de.fhdo.lemma.service.Import;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Possibly Imported Operation Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A operation node possibly imported from another operation model
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.PossiblyImportedOperationNode#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.PossiblyImportedOperationNode#getNode <em>Node</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.OperationPackage#getPossiblyImportedOperationNode()
 * @model
 * @generated
 */
public interface PossiblyImportedOperationNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import</em>' reference.
	 * @see #setImport(Import)
	 * @see de.fhdo.lemma.operation.OperationPackage#getPossiblyImportedOperationNode_Import()
	 * @model
	 * @generated
	 */
	Import getImport();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.PossiblyImportedOperationNode#getImport <em>Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import</em>' reference.
	 * @see #getImport()
	 * @generated
	 */
	void setImport(Import value);

	/**
	 * Returns the value of the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' reference.
	 * @see #setNode(OperationNode)
	 * @see de.fhdo.lemma.operation.OperationPackage#getPossiblyImportedOperationNode_Node()
	 * @model
	 * @generated
	 */
	OperationNode getNode();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.PossiblyImportedOperationNode#getNode <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(OperationNode value);

} // PossiblyImportedOperationNode
