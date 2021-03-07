/**
 */
package de.fhdo.lemma.operation.intermediate;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Node Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * References to imported operation nodes
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNodeReference#isImported <em>Imported</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNodeReference#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNodeReference#getQualifiedTechnologyName <em>Qualified Technology Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNodeReference#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNodeReference#getDependOnNode <em>Depend On Node</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNodeReference#getUsedByNode <em>Used By Node</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNodeReference()
 * @model
 * @generated
 */
public interface IntermediateOperationNodeReference extends EObject {
    /**
     * Returns the value of the '<em><b>Imported</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Imported</em>' attribute.
     * @see #setImported(boolean)
     * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNodeReference_Imported()
     * @model default="false" unique="false"
     * @generated
     */
    boolean isImported();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNodeReference#isImported <em>Imported</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Imported</em>' attribute.
     * @see #isImported()
     * @generated
     */
    void setImported(boolean value);

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNodeReference_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNodeReference#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Qualified Technology Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Qualified Technology Name</em>' attribute.
     * @see #setQualifiedTechnologyName(String)
     * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNodeReference_QualifiedTechnologyName()
     * @model unique="false"
     * @generated
     */
    String getQualifiedTechnologyName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNodeReference#getQualifiedTechnologyName <em>Qualified Technology Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Qualified Technology Name</em>' attribute.
     * @see #getQualifiedTechnologyName()
     * @generated
     */
    void setQualifiedTechnologyName(String value);

    /**
     * Returns the value of the '<em><b>Import</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Import</em>' reference.
     * @see #setImport(IntermediateImport)
     * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNodeReference_Import()
     * @model
     * @generated
     */
    IntermediateImport getImport();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNodeReference#getImport <em>Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Import</em>' reference.
     * @see #getImport()
     * @generated
     */
    void setImport(IntermediateImport value);

    /**
     * Returns the value of the '<em><b>Depend On Node</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getDependsOnNodes <em>Depends On Nodes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Depend On Node</em>' container reference.
     * @see #setDependOnNode(IntermediateOperationNode)
     * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNodeReference_DependOnNode()
     * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getDependsOnNodes
     * @model opposite="dependsOnNodes" transient="false"
     * @generated
     */
    IntermediateOperationNode getDependOnNode();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNodeReference#getDependOnNode <em>Depend On Node</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Depend On Node</em>' container reference.
     * @see #getDependOnNode()
     * @generated
     */
    void setDependOnNode(IntermediateOperationNode value);

    /**
     * Returns the value of the '<em><b>Used By Node</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getUsedByNodes <em>Used By Nodes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Used By Node</em>' container reference.
     * @see #setUsedByNode(IntermediateOperationNode)
     * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationNodeReference_UsedByNode()
     * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getUsedByNodes
     * @model opposite="usedByNodes" transient="false"
     * @generated
     */
    IntermediateOperationNode getUsedByNode();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNodeReference#getUsedByNode <em>Used By Node</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Used By Node</em>' container reference.
     * @see #getUsedByNode()
     * @generated
     */
    void setUsedByNode(IntermediateOperationNode value);

} // IntermediateOperationNodeReference
