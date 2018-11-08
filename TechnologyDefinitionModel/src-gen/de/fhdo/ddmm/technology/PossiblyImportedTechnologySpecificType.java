/**
 */
package de.fhdo.ddmm.technology;

import de.fhdo.ddmm.data.Type;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Possibly Imported Technology Specific Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A technology-specific type possibly imported from another technology model
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.PossiblyImportedTechnologySpecificType#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.PossiblyImportedTechnologySpecificType#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.PossiblyImportedTechnologySpecificType#getMappingEntry <em>Mapping Entry</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.PossiblyImportedTechnologySpecificType#getCompatibleEntry <em>Compatible Entry</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.TechnologyPackage#getPossiblyImportedTechnologySpecificType()
 * @model
 * @generated
 */
public interface PossiblyImportedTechnologySpecificType extends EObject {
    /**
     * Returns the value of the '<em><b>Import</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Import</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Import</em>' reference.
     * @see #setImport(TechnologyImport)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getPossiblyImportedTechnologySpecificType_Import()
     * @model
     * @generated
     */
    TechnologyImport getImport();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.PossiblyImportedTechnologySpecificType#getImport <em>Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Import</em>' reference.
     * @see #getImport()
     * @generated
     */
    void setImport(TechnologyImport value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' reference.
     * @see #setType(Type)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getPossiblyImportedTechnologySpecificType_Type()
     * @model
     * @generated
     */
    Type getType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.PossiblyImportedTechnologySpecificType#getType <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' reference.
     * @see #getType()
     * @generated
     */
    void setType(Type value);

    /**
     * Returns the value of the '<em><b>Mapping Entry</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.CompatibilityMatrixEntry#getMappingType <em>Mapping Type</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mapping Entry</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mapping Entry</em>' container reference.
     * @see #setMappingEntry(CompatibilityMatrixEntry)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getPossiblyImportedTechnologySpecificType_MappingEntry()
     * @see de.fhdo.ddmm.technology.CompatibilityMatrixEntry#getMappingType
     * @model opposite="mappingType" transient="false"
     * @generated
     */
    CompatibilityMatrixEntry getMappingEntry();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.PossiblyImportedTechnologySpecificType#getMappingEntry <em>Mapping Entry</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mapping Entry</em>' container reference.
     * @see #getMappingEntry()
     * @generated
     */
    void setMappingEntry(CompatibilityMatrixEntry value);

    /**
     * Returns the value of the '<em><b>Compatible Entry</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.CompatibilityMatrixEntry#getCompatibleTypes <em>Compatible Types</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Compatible Entry</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Compatible Entry</em>' container reference.
     * @see #setCompatibleEntry(CompatibilityMatrixEntry)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getPossiblyImportedTechnologySpecificType_CompatibleEntry()
     * @see de.fhdo.ddmm.technology.CompatibilityMatrixEntry#getCompatibleTypes
     * @model opposite="compatibleTypes" transient="false"
     * @generated
     */
    CompatibilityMatrixEntry getCompatibleEntry();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.PossiblyImportedTechnologySpecificType#getCompatibleEntry <em>Compatible Entry</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Compatible Entry</em>' container reference.
     * @see #getCompatibleEntry()
     * @generated
     */
    void setCompatibleEntry(CompatibilityMatrixEntry value);

} // PossiblyImportedTechnologySpecificType
