/**
 */
package de.fhdo.lemma.operation.intermediate;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Infrastructure Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * An intermediate infrastructure node is an operation node with supporting character,
 * e.g., a configuration provider
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getReference <em>Reference</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getOperationModel <em>Operation Model</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateInfrastructureNode()
 * @model
 * @generated
 */
public interface IntermediateInfrastructureNode extends IntermediateOperationNode {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getInfrastructureNode <em>Infrastructure Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' containment reference.
	 * @see #setReference(IntermediateInfrastructureTechnologyReference)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateInfrastructureNode_Reference()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getInfrastructureNode
	 * @model opposite="infrastructureNode" containment="true"
	 * @generated
	 */
	IntermediateInfrastructureTechnologyReference getReference();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getReference <em>Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' containment reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(IntermediateInfrastructureTechnologyReference value);

	/**
	 * Returns the value of the '<em><b>Operation Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getInfrastructureNodes <em>Infrastructure Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Model</em>' container reference.
	 * @see #setOperationModel(IntermediateOperationModel)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateInfrastructureNode_OperationModel()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getInfrastructureNodes
	 * @model opposite="infrastructureNodes" transient="false"
	 * @generated
	 */
	IntermediateOperationModel getOperationModel();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getOperationModel <em>Operation Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Model</em>' container reference.
	 * @see #getOperationModel()
	 * @generated
	 */
	void setOperationModel(IntermediateOperationModel value);

} // IntermediateInfrastructureNode
