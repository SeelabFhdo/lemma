/**
 */
package de.fhdo.lemma.service.intermediate;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

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
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateServiceModel#getSourceModelUri <em>Source Model Uri</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateServiceModel#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateServiceModel#getMicroservices <em>Microservices</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateServiceModel()
 * @model
 * @generated
 */
public interface IntermediateServiceModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Model Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Model Uri</em>' attribute.
	 * @see #setSourceModelUri(String)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateServiceModel_SourceModelUri()
	 * @model unique="false"
	 * @generated
	 */
	String getSourceModelUri();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateServiceModel#getSourceModelUri <em>Source Model Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Model Uri</em>' attribute.
	 * @see #getSourceModelUri()
	 * @generated
	 */
	void setSourceModelUri(String value);

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateImport}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateServiceModel_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntermediateImport> getImports();

	/**
	 * Returns the value of the '<em><b>Microservices</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getServiceModel <em>Service Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Microservices</em>' containment reference list.
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateServiceModel_Microservices()
	 * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getServiceModel
	 * @model opposite="serviceModel" containment="true" required="true"
	 * @generated
	 */
	EList<IntermediateMicroservice> getMicroservices();

} // IntermediateServiceModel
