/**
 */
package de.fhdo.lemma.technology;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Infrastructure Technology</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Infrastructure technology for service operation
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.InfrastructureTechnology#getTechnology <em>Technology</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.TechnologyPackage#getInfrastructureTechnology()
 * @model
 * @generated
 */
public interface InfrastructureTechnology extends OperationTechnology {
    /**
     * Returns the value of the '<em><b>Technology</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.Technology#getInfrastructureTechnologies <em>Infrastructure Technologies</em>}'.
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
     * @see de.fhdo.lemma.technology.TechnologyPackage#getInfrastructureTechnology_Technology()
     * @see de.fhdo.lemma.technology.Technology#getInfrastructureTechnologies
     * @model opposite="infrastructureTechnologies" transient="false"
     * @generated
     */
    Technology getTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.InfrastructureTechnology#getTechnology <em>Technology</em>}' container reference.
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
     * Get parts of the technology for creating a qualified name
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
     * Build qualified name name based in the technology and infrastructure technology name
     * <!-- end-model-doc -->
     * @model unique="false" separatorUnique="false" withTechnologyNameUnique="false" withNamespaceUnique="false"
     * @generated
     */
    String buildQualifiedName(String separator, boolean withTechnologyName, boolean withNamespace);

} // InfrastructureTechnology
