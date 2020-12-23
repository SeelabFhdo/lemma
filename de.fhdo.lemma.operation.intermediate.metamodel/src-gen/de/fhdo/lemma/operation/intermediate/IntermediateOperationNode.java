/**
 */
package de.fhdo.lemma.operation.intermediate;

import de.fhdo.lemma.data.intermediate.IntermediateImport;
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * An intermediate operation node is a node to which services may be deployed, e.g., a container or
 * some infrastructure component like a configuration provider or database
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#isImported <em>Imported</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getOperationEnvironment <em>Operation Environment</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getDeployedServices <em>Deployed Services</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getSpecifications <em>Specifications</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getDefaultValues <em>Default Values</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getDependsOnNodes <em>Depends On Nodes</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getUsedByNodes <em>Used By Nodes</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNode()
 * @model abstract="true"
 * @generated
 */
public interface IntermediateOperationNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNode_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Imported</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported</em>' attribute.
	 * @see #setImported(boolean)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNode_Imported()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isImported();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#isImported <em>Imported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported</em>' attribute.
	 * @see #isImported()
	 * @generated
	 */
	void setImported(boolean value);

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateImport}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNode_Imports()
	 * @model required="true"
	 * @generated
	 */
	EList<IntermediateImport> getImports();

	/**
	 * Returns the value of the '<em><b>Operation Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Environment</em>' reference.
	 * @see #setOperationEnvironment(IntermediateOperationEnvironment)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNode_OperationEnvironment()
	 * @model
	 * @generated
	 */
	IntermediateOperationEnvironment getOperationEnvironment();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getOperationEnvironment <em>Operation Environment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Environment</em>' reference.
	 * @see #getOperationEnvironment()
	 * @generated
	 */
	void setOperationEnvironment(IntermediateOperationEnvironment value);

	/**
	 * Returns the value of the '<em><b>Deployed Services</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deployed Services</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNode_DeployedServices()
	 * @see de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getNode
	 * @model opposite="node" containment="true"
	 * @generated
	 */
	EList<OperationMicroserviceReference> getDeployedServices();

	/**
	 * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoints</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNode_Endpoints()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint#getNode
	 * @model opposite="node" containment="true" required="true"
	 * @generated
	 */
	EList<IntermediateOperationEndpoint> getEndpoints();

	/**
	 * Returns the value of the '<em><b>Specifications</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getOperationNode <em>Operation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specifications</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNode_Specifications()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getOperationNode
	 * @model opposite="operationNode" containment="true"
	 * @generated
	 */
	EList<IntermediateServiceDeploymentSpecification> getSpecifications();

	/**
	 * Returns the value of the '<em><b>Default Values</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getOperationNode <em>Operation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Values</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNode_DefaultValues()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getOperationNode
	 * @model opposite="operationNode" containment="true"
	 * @generated
	 */
	EList<IntermediateTechnologySpecificPropertyValue> getDefaultValues();

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNode_Aspects()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntermediateImportedAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Depends On Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNodeReference}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNodeReference#getDependOnNode <em>Depend On Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depends On Nodes</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNode_DependsOnNodes()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNodeReference#getDependOnNode
	 * @model opposite="dependOnNode" containment="true"
	 * @generated
	 */
	EList<IntermediateOperationNodeReference> getDependsOnNodes();

	/**
	 * Returns the value of the '<em><b>Used By Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNodeReference}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNodeReference#getUsedByNode <em>Used By Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used By Nodes</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNode_UsedByNodes()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNodeReference#getUsedByNode
	 * @model opposite="usedByNode" containment="true"
	 * @generated
	 */
	EList<IntermediateOperationNodeReference> getUsedByNodes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" deployedServiceUnique="false"
	 * @generated
	 */
	EList<IntermediateTechnologySpecificPropertyValue> getEffectiveConfigurationValues(OperationMicroserviceReference deployedService);

} // IntermediateOperationNode
