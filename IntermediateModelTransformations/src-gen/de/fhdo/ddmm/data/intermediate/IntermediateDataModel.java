/**
 */
package de.fhdo.ddmm.data.intermediate;

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
 *   <li>{@link de.fhdo.ddmm.data.intermediate.IntermediateDataModel#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.intermediate.IntermediateDataModel#getVersions <em>Versions</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.intermediate.IntermediateDataModel#getContexts <em>Contexts</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.intermediate.IntermediateDataModel#getComplexTypes <em>Complex Types</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.data.intermediate.IntermediatePackage#getIntermediateDataModel()
 * @model
 * @generated
 */
public interface IntermediateDataModel extends EObject {
    /**
     * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.data.intermediate.IntermediateImport}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.data.intermediate.IntermediateImport#getDataModel <em>Data Model</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Imports</em>' containment reference list.
     * @see de.fhdo.ddmm.data.intermediate.IntermediatePackage#getIntermediateDataModel_Imports()
     * @see de.fhdo.ddmm.data.intermediate.IntermediateImport#getDataModel
     * @model opposite="dataModel" containment="true"
     * @generated
     */
    EList<IntermediateImport> getImports();

    /**
     * Returns the value of the '<em><b>Versions</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.data.intermediate.IntermediateVersion}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.data.intermediate.IntermediateVersion#getDataModel <em>Data Model</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Versions</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Versions</em>' containment reference list.
     * @see de.fhdo.ddmm.data.intermediate.IntermediatePackage#getIntermediateDataModel_Versions()
     * @see de.fhdo.ddmm.data.intermediate.IntermediateVersion#getDataModel
     * @model opposite="dataModel" containment="true"
     * @generated
     */
    EList<IntermediateVersion> getVersions();

    /**
     * Returns the value of the '<em><b>Contexts</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.data.intermediate.IntermediateContext}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.data.intermediate.IntermediateContext#getDataModel <em>Data Model</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Contexts</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Contexts</em>' containment reference list.
     * @see de.fhdo.ddmm.data.intermediate.IntermediatePackage#getIntermediateDataModel_Contexts()
     * @see de.fhdo.ddmm.data.intermediate.IntermediateContext#getDataModel
     * @model opposite="dataModel" containment="true"
     * @generated
     */
    EList<IntermediateContext> getContexts();

    /**
     * Returns the value of the '<em><b>Complex Types</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.data.intermediate.IntermediateComplexType}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.data.intermediate.IntermediateComplexType#getDataModel <em>Data Model</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Complex Types</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Complex Types</em>' containment reference list.
     * @see de.fhdo.ddmm.data.intermediate.IntermediatePackage#getIntermediateDataModel_ComplexTypes()
     * @see de.fhdo.ddmm.data.intermediate.IntermediateComplexType#getDataModel
     * @model opposite="dataModel" containment="true"
     * @generated
     */
    EList<IntermediateComplexType> getComplexTypes();

} // IntermediateDataModel
