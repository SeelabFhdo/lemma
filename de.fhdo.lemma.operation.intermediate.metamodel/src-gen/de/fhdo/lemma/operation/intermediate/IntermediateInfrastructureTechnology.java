/**
 */
package de.fhdo.lemma.operation.intermediate;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Infrastructure Technology</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Intermediate operation technology for infrastructure deployment
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnology#getReference <em>Reference</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateInfrastructureTechnology()
 * @model
 * @generated
 */
public interface IntermediateInfrastructureTechnology extends IntermediateOperationTechnology {
    /**
     * Returns the value of the '<em><b>Reference</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Reference</em>' container reference.
     * @see #setReference(IntermediateInfrastructureTechnologyReference)
     * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateInfrastructureTechnology_Reference()
     * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getTechnology
     * @model opposite="technology" transient="false"
     * @generated
     */
    IntermediateInfrastructureTechnologyReference getReference();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnology#getReference <em>Reference</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reference</em>' container reference.
     * @see #getReference()
     * @generated
     */
    void setReference(IntermediateInfrastructureTechnologyReference value);

} // IntermediateInfrastructureTechnology
