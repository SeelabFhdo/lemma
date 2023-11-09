/**
 */
package de.fhdo.lemma.data.intermediate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Metamodel of intermediate data models.
 *  * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataModel#getSourceModelUri <em>Source Model Uri</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataModel#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataModel#getVersions <em>Versions</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataModel#getContexts <em>Contexts</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataModel#getComplexTypes <em>Complex Types</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataModel()
 * @model
 * @generated
 */
public interface IntermediateDataModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Model Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Model Uri</em>' attribute.
	 * @see #setSourceModelUri(String)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataModel_SourceModelUri()
	 * @model unique="false"
	 * @generated
	 */
	String getSourceModelUri();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataModel#getSourceModelUri <em>Source Model Uri</em>}' attribute.
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
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateImport#getDataModel <em>Data Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataModel_Imports()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImport#getDataModel
	 * @model opposite="dataModel" containment="true"
	 * @generated
	 */
	EList<IntermediateImport> getImports();

	/**
	 * Returns the value of the '<em><b>Versions</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateVersion}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateVersion#getDataModel <em>Data Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Versions</em>' containment reference list.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataModel_Versions()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateVersion#getDataModel
	 * @model opposite="dataModel" containment="true"
	 * @generated
	 */
	EList<IntermediateVersion> getVersions();

	/**
	 * Returns the value of the '<em><b>Contexts</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateContext}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateContext#getDataModel <em>Data Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contexts</em>' containment reference list.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataModel_Contexts()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateContext#getDataModel
	 * @model opposite="dataModel" containment="true"
	 * @generated
	 */
	EList<IntermediateContext> getContexts();

	/**
	 * Returns the value of the '<em><b>Complex Types</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateComplexType}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateComplexType#getDataModel <em>Data Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complex Types</em>' containment reference list.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataModel_ComplexTypes()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateComplexType#getDataModel
	 * @model opposite="dataModel" containment="true"
	 * @generated
	 */
	EList<IntermediateComplexType> getComplexTypes();

} // IntermediateDataModel
