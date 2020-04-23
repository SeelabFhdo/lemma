/**
 */
package de.fhdo.lemma.technology;

import de.fhdo.lemma.data.PrimitiveType;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specific Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A primitive type that is specific to a certain technology, e.g., uint64 for Go
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.TechnologySpecificPrimitiveType#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.TechnologySpecificPrimitiveType#isDefault <em>Default</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.TechnologySpecificPrimitiveType#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.TechnologySpecificPrimitiveType#getBasicBuiltinPrimitiveTypes <em>Basic Builtin Primitive Types</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologySpecificPrimitiveType()
 * @model
 * @generated
 */
public interface TechnologySpecificPrimitiveType extends PrimitiveType {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) There might be no duplicates in the basic built-ins of a technology-specific
     *          primitive type.
     *          Ensured by: DSL validator.
     *     (C2) There might be only one technology-specific primitive type that is marked as the
     *          default for a built-in primitive type. Otherwise, the code generator could not
     *          unambiguously decide which technology-specific primitive type to use, when no
     *          explicit mapping of a built-in primitive types was specified.
     *          Ensured by: DSL validator.
     *     (C3) Name must be unique.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologySpecificPrimitiveType_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.TechnologySpecificPrimitiveType#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Default</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default</em>' attribute.
     * @see #setDefault(boolean)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologySpecificPrimitiveType_Default()
     * @model default="false" unique="false"
     * @generated
     */
    boolean isDefault();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.TechnologySpecificPrimitiveType#isDefault <em>Default</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default</em>' attribute.
     * @see #isDefault()
     * @generated
     */
    void setDefault(boolean value);

    /**
     * Returns the value of the '<em><b>Technology</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.Technology#getPrimitiveTypes <em>Primitive Types</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technology</em>' container reference.
     * @see #setTechnology(Technology)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologySpecificPrimitiveType_Technology()
     * @see de.fhdo.lemma.technology.Technology#getPrimitiveTypes
     * @model opposite="primitiveTypes" transient="false"
     * @generated
     */
    Technology getTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.TechnologySpecificPrimitiveType#getTechnology <em>Technology</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Technology</em>' container reference.
     * @see #getTechnology()
     * @generated
     */
    void setTechnology(Technology value);

    /**
     * Returns the value of the '<em><b>Basic Builtin Primitive Types</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.data.PrimitiveType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Basic Builtin Primitive Types</em>' containment reference list.
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologySpecificPrimitiveType_BasicBuiltinPrimitiveTypes()
     * @model containment="true"
     * @generated
     */
    EList<PrimitiveType> getBasicBuiltinPrimitiveTypes();

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

} // TechnologySpecificPrimitiveType
