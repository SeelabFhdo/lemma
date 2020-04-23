/**
 */
package de.fhdo.lemma.technology;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Concept for importing another technology
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.TechnologyImport#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.TechnologyImport#getImportURI <em>Import URI</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.TechnologyImport#getTechnology <em>Technology</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologyImport()
 * @model
 * @generated
 */
public interface TechnologyImport extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) The import URI must point to a valid file.
     *          Ensured by: DSL validator.
     *     (C2) Model may not import itself. However, cyclic imports are allowed, because otherwise
     *          it would not be possible to declare that types of two different technologies are
     *          bidirectionally compatible (see implicit constraints of CompatibilityMatrixEntry for
     *          details on this).
     *          Ensured by: DSL validator.
     *     (C3) Import names, i.e., "aliases", must be unique.
     *          Ensured by: DSL validator.
     *     (C4) Imported file must define a technology model.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologyImport_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.TechnologyImport#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Import URI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Import URI</em>' attribute.
     * @see #setImportURI(String)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologyImport_ImportURI()
     * @model unique="false"
     * @generated
     */
    String getImportURI();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.TechnologyImport#getImportURI <em>Import URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Import URI</em>' attribute.
     * @see #getImportURI()
     * @generated
     */
    void setImportURI(String value);

    /**
     * Returns the value of the '<em><b>Technology</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.Technology#getImports <em>Imports</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technology</em>' container reference.
     * @see #setTechnology(Technology)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologyImport_Technology()
     * @see de.fhdo.lemma.technology.Technology#getImports
     * @model opposite="imports" transient="false"
     * @generated
     */
    Technology getTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.TechnologyImport#getTechnology <em>Technology</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Technology</em>' container reference.
     * @see #getTechnology()
     * @generated
     */
    void setTechnology(Technology value);

} // TechnologyImport
