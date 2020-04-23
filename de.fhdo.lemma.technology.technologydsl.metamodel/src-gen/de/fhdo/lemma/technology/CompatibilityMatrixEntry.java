/**
 */
package de.fhdo.lemma.technology;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compatibility Matrix Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Entry for declaring technology-specific compatibility between a mapping type and a set of other
 * technology-specific types. The conversion direction is determined leveraging an
 * CompatibilityDirection-typed field.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.CompatibilityMatrixEntry#getDirection <em>Direction</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.CompatibilityMatrixEntry#getMappingType <em>Mapping Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.CompatibilityMatrixEntry#getCompatibleTypes <em>Compatible Types</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.CompatibilityMatrixEntry#getTechnology <em>Technology</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.TechnologyPackage#getCompatibilityMatrixEntry()
 * @model
 * @generated
 */
public interface CompatibilityMatrixEntry extends EObject {
    /**
     * Returns the value of the '<em><b>Direction</b></em>' attribute.
     * The literals are from the enumeration {@link de.fhdo.lemma.technology.CompatibilityDirection}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) No duplicate entries.
     *          Ensured by: DSL validator.
     *     (C2) No ambiguous entries in case of bidirectional compatibility, e.g., when comprising a
     *          Boolean <-> Character mapping the matrix may not have any of the entries Boolean ->
     *          Character or Character -> Boolean.
     *          Ensured by: DSL validator.
     *     (C3) For imported types, only the forms "imported compatible types -> local mapping type"
     *          or "local compatible types <- imported mapping type" is allowed. That is, the
     *          compatibility matrix must declare which imported types may be converted _into_ its
     *          types. A bidirectional compatibility direction is prevented, because then all
     *          imported technology models must be traversed to decide whether a compatibility
     *          entry exists. Furthermore, for an entry with imported types it must always be
     *          declared that imported types are convertible into local types. This follows the
     *          direction of an initialized parameter of a microservices that has a technology
     *          assigned.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Direction</em>' attribute.
     * @see de.fhdo.lemma.technology.CompatibilityDirection
     * @see #setDirection(CompatibilityDirection)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getCompatibilityMatrixEntry_Direction()
     * @model unique="false"
     * @generated
     */
    CompatibilityDirection getDirection();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.CompatibilityMatrixEntry#getDirection <em>Direction</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Direction</em>' attribute.
     * @see de.fhdo.lemma.technology.CompatibilityDirection
     * @see #getDirection()
     * @generated
     */
    void setDirection(CompatibilityDirection value);

    /**
     * Returns the value of the '<em><b>Mapping Type</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.PossiblyImportedTechnologySpecificType#getMappingEntry <em>Mapping Entry</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mapping Type</em>' containment reference.
     * @see #setMappingType(PossiblyImportedTechnologySpecificType)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getCompatibilityMatrixEntry_MappingType()
     * @see de.fhdo.lemma.technology.PossiblyImportedTechnologySpecificType#getMappingEntry
     * @model opposite="mappingEntry" containment="true"
     * @generated
     */
    PossiblyImportedTechnologySpecificType getMappingType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.CompatibilityMatrixEntry#getMappingType <em>Mapping Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mapping Type</em>' containment reference.
     * @see #getMappingType()
     * @generated
     */
    void setMappingType(PossiblyImportedTechnologySpecificType value);

    /**
     * Returns the value of the '<em><b>Compatible Types</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.technology.PossiblyImportedTechnologySpecificType}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.PossiblyImportedTechnologySpecificType#getCompatibleEntry <em>Compatible Entry</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Compatible Types</em>' containment reference list.
     * @see de.fhdo.lemma.technology.TechnologyPackage#getCompatibilityMatrixEntry_CompatibleTypes()
     * @see de.fhdo.lemma.technology.PossiblyImportedTechnologySpecificType#getCompatibleEntry
     * @model opposite="compatibleEntry" containment="true" required="true"
     * @generated
     */
    EList<PossiblyImportedTechnologySpecificType> getCompatibleTypes();

    /**
     * Returns the value of the '<em><b>Technology</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.Technology#getCompatibilityEntries <em>Compatibility Entries</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technology</em>' container reference.
     * @see #setTechnology(Technology)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getCompatibilityMatrixEntry_Technology()
     * @see de.fhdo.lemma.technology.Technology#getCompatibilityEntries
     * @model opposite="compatibilityEntries" transient="false"
     * @generated
     */
    Technology getTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.CompatibilityMatrixEntry#getTechnology <em>Technology</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Technology</em>' container reference.
     * @see #getTechnology()
     * @generated
     */
    void setTechnology(Technology value);

} // CompatibilityMatrixEntry
