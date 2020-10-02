/**
 */
package de.fhdo.lemma.operation.intermediate;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A intermediate container is the central operation node. It enables service deployment
 * and operation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer#getTechnologyReference <em>Technology Reference</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer#getOperationModel <em>Operation Model</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateContainer()
 * @model
 * @generated
 */
public interface IntermediateContainer extends IntermediateOperationNode {
	/**
	 * Returns the value of the '<em><b>Technology Reference</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Technology Reference</em>' containment reference.
	 * @see #setTechnologyReference(IntermediateDeploymentTechnologyReference)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateContainer_TechnologyReference()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	IntermediateDeploymentTechnologyReference getTechnologyReference();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer#getTechnologyReference <em>Technology Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Technology Reference</em>' containment reference.
	 * @see #getTechnologyReference()
	 * @generated
	 */
	void setTechnologyReference(IntermediateDeploymentTechnologyReference value);

	/**
	 * Returns the value of the '<em><b>Operation Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getContainers <em>Containers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Model</em>' container reference.
	 * @see #setOperationModel(IntermediateOperationModel)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateContainer_OperationModel()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getContainers
	 * @model opposite="containers" transient="false"
	 * @generated
	 */
	IntermediateOperationModel getOperationModel();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer#getOperationModel <em>Operation Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Model</em>' container reference.
	 * @see #getOperationModel()
	 * @generated
	 */
	void setOperationModel(IntermediateOperationModel value);

} // IntermediateContainer
