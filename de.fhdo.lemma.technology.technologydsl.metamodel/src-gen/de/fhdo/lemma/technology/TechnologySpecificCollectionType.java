/**
 */
package de.fhdo.lemma.technology;

import de.fhdo.lemma.data.ComplexType;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specific Collection Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A collection type that is specific to a certain technology, e.g., Queue for Java
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.TechnologySpecificCollectionType#getTechnology <em>Technology</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologySpecificCollectionType()
 * @model
 * @generated
 */
public interface TechnologySpecificCollectionType extends ComplexType {
    /**
     * Returns the value of the '<em><b>Technology</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.Technology#getCollectionTypes <em>Collection Types</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Name must be unique.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Technology</em>' container reference.
     * @see #setTechnology(Technology)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologySpecificCollectionType_Technology()
     * @see de.fhdo.lemma.technology.Technology#getCollectionTypes
     * @model opposite="collectionTypes" transient="false"
     * @generated
     */
    Technology getTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.TechnologySpecificCollectionType#getTechnology <em>Technology</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Technology</em>' container reference.
     * @see #getTechnology()
     * @generated
     */
    void setTechnology(Technology value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get parts of the type for creating a qualified name
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     * @generated
     */
    EList<String> getQualifiedNameParts();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Build qualified name from qualified name parts
     * <!-- end-model-doc -->
     * @model unique="false" separatorUnique="false"
     * @generated
     */
    String buildQualifiedName(String separator);

} // TechnologySpecificCollectionType
