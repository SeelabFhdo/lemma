/**
 */
package de.fhdo.lemma.operation.intermediate;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Metamodel of intermediate operation models.
 *  * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getSourceModelUri <em>Source Model Uri</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getContainers <em>Containers</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getInfrastructureNodes <em>Infrastructure Nodes</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationModel()
 * @model
 * @generated
 */
public interface IntermediateOperationModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Model Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Model Uri</em>' attribute.
	 * @see #setSourceModelUri(String)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationModel_SourceModelUri()
	 * @model unique="false"
	 * @generated
	 */
	String getSourceModelUri();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getSourceModelUri <em>Source Model Uri</em>}' attribute.
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
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationModel_Imports()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<IntermediateImport> getImports();

	/**
	 * Returns the value of the '<em><b>Containers</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.intermediate.IntermediateContainer}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer#getOperationModel <em>Operation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containers</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationModel_Containers()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateContainer#getOperationModel
	 * @model opposite="operationModel" containment="true"
	 * @generated
	 */
	EList<IntermediateContainer> getContainers();

	/**
	 * Returns the value of the '<em><b>Infrastructure Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getOperationModel <em>Operation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infrastructure Nodes</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationModel_InfrastructureNodes()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getOperationModel
	 * @model opposite="operationModel" containment="true"
	 * @generated
	 */
	EList<IntermediateInfrastructureNode> getInfrastructureNodes();

} // IntermediateOperationModel
