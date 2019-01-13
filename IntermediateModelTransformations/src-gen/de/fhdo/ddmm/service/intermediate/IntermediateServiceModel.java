/**
 */
package de.fhdo.ddmm.service.intermediate;

import de.fhdo.ddmm.data.intermediate.IntermediateImport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Metamodel of intermediate service models.
 *  * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateServiceModel#getSourceModelUri <em>Source Model Uri</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateServiceModel#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateServiceModel#getMicroservices <em>Microservices</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateServiceModel()
 * @model
 * @generated
 */
public interface IntermediateServiceModel extends EObject {
    /**
     * Returns the value of the '<em><b>Source Model Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Model Uri</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Model Uri</em>' attribute.
     * @see #setSourceModelUri(String)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateServiceModel_SourceModelUri()
     * @model unique="false"
     * @generated
     */
    String getSourceModelUri();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateServiceModel#getSourceModelUri <em>Source Model Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Model Uri</em>' attribute.
     * @see #getSourceModelUri()
     * @generated
     */
    void setSourceModelUri(String value);

    /**
     * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.data.intermediate.IntermediateImport}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Imports</em>' containment reference list.
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateServiceModel_Imports()
     * @model containment="true"
     * @generated
     */
    EList<IntermediateImport> getImports();

    /**
     * Returns the value of the '<em><b>Microservices</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.intermediate.IntermediateMicroservice}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateMicroservice#getServiceModel <em>Service Model</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Microservices</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Microservices</em>' containment reference list.
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateServiceModel_Microservices()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateMicroservice#getServiceModel
     * @model opposite="serviceModel" containment="true" required="true"
     * @generated
     */
    EList<IntermediateMicroservice> getMicroservices();

} // IntermediateServiceModel
