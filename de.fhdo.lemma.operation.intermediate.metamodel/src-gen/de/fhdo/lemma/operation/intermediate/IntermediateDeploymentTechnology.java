/**
 */
package de.fhdo.lemma.operation.intermediate;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deployment Technology</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Intermediate operation technology for service deployment
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnology#getReference <em>Reference</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateDeploymentTechnology()
 * @model
 * @generated
 */
public interface IntermediateDeploymentTechnology extends IntermediateOperationTechnology {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getTechnology <em>Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' container reference.
	 * @see #setReference(IntermediateDeploymentTechnologyReference)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateDeploymentTechnology_Reference()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getTechnology
	 * @model opposite="technology" transient="false"
	 * @generated
	 */
	IntermediateDeploymentTechnologyReference getReference();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnology#getReference <em>Reference</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' container reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(IntermediateDeploymentTechnologyReference value);

} // IntermediateDeploymentTechnology
