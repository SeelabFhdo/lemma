/**
 */
package de.fhdo.lemma.operation.intermediate;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deployment Technology Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents a reference to an intermediate technology
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getContainer <em>Container</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateDeploymentTechnologyReference()
 * @model
 * @generated
 */
public interface IntermediateDeploymentTechnologyReference extends EObject {
    /**
     * Returns the value of the '<em><b>Import</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Import</em>' reference.
     * @see #setImport(IntermediateImport)
     * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateDeploymentTechnologyReference_Import()
     * @model
     * @generated
     */
    IntermediateImport getImport();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getImport <em>Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Import</em>' reference.
     * @see #getImport()
     * @generated
     */
    void setImport(IntermediateImport value);

    /**
     * Returns the value of the '<em><b>Technology</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnology#getReference <em>Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technology</em>' containment reference.
     * @see #setTechnology(IntermediateDeploymentTechnology)
     * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateDeploymentTechnologyReference_Technology()
     * @see de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnology#getReference
     * @model opposite="reference" containment="true"
     * @generated
     */
    IntermediateDeploymentTechnology getTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getTechnology <em>Technology</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Technology</em>' containment reference.
     * @see #getTechnology()
     * @generated
     */
    void setTechnology(IntermediateDeploymentTechnology value);

    /**
     * Returns the value of the '<em><b>Container</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer#getTechnologyReference <em>Technology Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Container</em>' container reference.
     * @see #setContainer(IntermediateContainer)
     * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateDeploymentTechnologyReference_Container()
     * @see de.fhdo.lemma.operation.intermediate.IntermediateContainer#getTechnologyReference
     * @model opposite="technologyReference" transient="false"
     * @generated
     */
    IntermediateContainer getContainer();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getContainer <em>Container</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Container</em>' container reference.
     * @see #getContainer()
     * @generated
     */
    void setContainer(IntermediateContainer value);

} // IntermediateDeploymentTechnologyReference
