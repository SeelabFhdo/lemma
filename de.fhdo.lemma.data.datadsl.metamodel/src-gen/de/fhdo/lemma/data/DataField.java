/**
 */
package de.fhdo.lemma.data;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents a typed and named field
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.DataField#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.DataField#isHidden <em>Hidden</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.DataField#isImmutable <em>Immutable</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.DataField#getComplexType <em>Complex Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.DataField#getImportedComplexType <em>Imported Complex Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.DataField#getPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.DataField#getInitializationValue <em>Initialization Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.DataField#getFeatures <em>Features</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.DataField#getDataStructure <em>Data Structure</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.DataField#getCollectionType <em>Collection Type</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.DataPackage#getDataField()
 * @model
 * @generated
 */
public interface DataField extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) May either have a complex or primitive type, not both.
     *          Ensured by: DSL grammar.
     *     (C2) Must have a type or be hidden.
     *          Ensured by: DSL validator.
     *     (C3) The field must have a type if either no field with an equal name exists in a super
     *          data structure, or if an eponymous super field exists that is hidden.
     *          Ensured by: DSL validator.
     *     (C3) If an eponymous super field exists that is not hidden, than this field must not have
     *          a type, i.e., a visible super field cannot be redefined in a sub-structure.
     *          Ensured by: DSL validator.
     *     (C4) Name must be unique within a data structure.
     *          Ensured by: DSL validator.
     *     (C5) A feature may only be assigned once.
     *          Ensured by: DSL validator.
     *     (C6) Inherited fields cannot be immutable.
     *          Ensured by: DSL validator.     *
     *     (C7) Only data fields within structures are initializable.
     *          Ensured by: DSL validator.
     *     (C8) Only primitive data fields are initializable. Together with C3 this automatically
     *          ensures that inherited fields cannot be initialized (which is desired behavior).
     *          Ensured by: DSL validator.
     *     (C9) Initialization value must be compatible to primitive type.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.lemma.data.DataPackage#getDataField_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.DataField#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Hidden</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hidden</em>' attribute.
     * @see #setHidden(boolean)
     * @see de.fhdo.lemma.data.DataPackage#getDataField_Hidden()
     * @model unique="false"
     * @generated
     */
    boolean isHidden();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.DataField#isHidden <em>Hidden</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Hidden</em>' attribute.
     * @see #isHidden()
     * @generated
     */
    void setHidden(boolean value);

    /**
     * Returns the value of the '<em><b>Immutable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Immutable</em>' attribute.
     * @see #setImmutable(boolean)
     * @see de.fhdo.lemma.data.DataPackage#getDataField_Immutable()
     * @model unique="false"
     * @generated
     */
    boolean isImmutable();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.DataField#isImmutable <em>Immutable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Immutable</em>' attribute.
     * @see #isImmutable()
     * @generated
     */
    void setImmutable(boolean value);

    /**
     * Returns the value of the '<em><b>Complex Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Complex Type</em>' reference.
     * @see #setComplexType(ComplexType)
     * @see de.fhdo.lemma.data.DataPackage#getDataField_ComplexType()
     * @model
     * @generated
     */
    ComplexType getComplexType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.DataField#getComplexType <em>Complex Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Complex Type</em>' reference.
     * @see #getComplexType()
     * @generated
     */
    void setComplexType(ComplexType value);

    /**
     * Returns the value of the '<em><b>Imported Complex Type</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.ImportedComplexType#getDataField <em>Data Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Imported Complex Type</em>' containment reference.
     * @see #setImportedComplexType(ImportedComplexType)
     * @see de.fhdo.lemma.data.DataPackage#getDataField_ImportedComplexType()
     * @see de.fhdo.lemma.data.ImportedComplexType#getDataField
     * @model opposite="dataField" containment="true"
     * @generated
     */
    ImportedComplexType getImportedComplexType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.DataField#getImportedComplexType <em>Imported Complex Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Imported Complex Type</em>' containment reference.
     * @see #getImportedComplexType()
     * @generated
     */
    void setImportedComplexType(ImportedComplexType value);

    /**
     * Returns the value of the '<em><b>Primitive Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Primitive Type</em>' containment reference.
     * @see #setPrimitiveType(PrimitiveType)
     * @see de.fhdo.lemma.data.DataPackage#getDataField_PrimitiveType()
     * @model containment="true"
     * @generated
     */
    PrimitiveType getPrimitiveType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.DataField#getPrimitiveType <em>Primitive Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Primitive Type</em>' containment reference.
     * @see #getPrimitiveType()
     * @generated
     */
    void setPrimitiveType(PrimitiveType value);

    /**
     * Returns the value of the '<em><b>Initialization Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Initialization Value</em>' containment reference.
     * @see #setInitializationValue(PrimitiveValue)
     * @see de.fhdo.lemma.data.DataPackage#getDataField_InitializationValue()
     * @model containment="true"
     * @generated
     */
    PrimitiveValue getInitializationValue();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.DataField#getInitializationValue <em>Initialization Value</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Initialization Value</em>' containment reference.
     * @see #getInitializationValue()
     * @generated
     */
    void setInitializationValue(PrimitiveValue value);

    /**
     * Returns the value of the '<em><b>Features</b></em>' attribute list.
     * The list contents are of type {@link de.fhdo.lemma.data.DataFieldFeature}.
     * The literals are from the enumeration {@link de.fhdo.lemma.data.DataFieldFeature}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Features</em>' attribute list.
     * @see de.fhdo.lemma.data.DataFieldFeature
     * @see de.fhdo.lemma.data.DataPackage#getDataField_Features()
     * @model unique="false"
     * @generated
     */
    EList<DataFieldFeature> getFeatures();

    /**
     * Returns the value of the '<em><b>Data Structure</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.DataStructure#getDataFields <em>Data Fields</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Structure</em>' container reference.
     * @see #setDataStructure(DataStructure)
     * @see de.fhdo.lemma.data.DataPackage#getDataField_DataStructure()
     * @see de.fhdo.lemma.data.DataStructure#getDataFields
     * @model opposite="dataFields" transient="false"
     * @generated
     */
    DataStructure getDataStructure();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.DataField#getDataStructure <em>Data Structure</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Structure</em>' container reference.
     * @see #getDataStructure()
     * @generated
     */
    void setDataStructure(DataStructure value);

    /**
     * Returns the value of the '<em><b>Collection Type</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.CollectionType#getDataFields <em>Data Fields</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Collection Type</em>' container reference.
     * @see #setCollectionType(CollectionType)
     * @see de.fhdo.lemma.data.DataPackage#getDataField_CollectionType()
     * @see de.fhdo.lemma.data.CollectionType#getDataFields
     * @model opposite="dataFields" transient="false"
     * @generated
     */
    CollectionType getCollectionType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.DataField#getCollectionType <em>Collection Type</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Collection Type</em>' container reference.
     * @see #getCollectionType()
     * @generated
     */
    void setCollectionType(CollectionType value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get the effective type (complex type, possibly imported, or primitive type) of the field
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     * @generated
     */
    Type getEffectiveType();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get parts of the data field for creating a qualified name
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

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Find an eponymous field in the inheritance hierarchy of this field's data structure. Returns
     * null, if this field is not part of a data structure, as only data structures may extend other
     * data structures.
     * <!-- end-model-doc -->
     * @model unique="false"
     * @generated
     */
    DataField findEponymousSuperField();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Check if the field has a specific feature assigned
     * <!-- end-model-doc -->
     * @model unique="false" featureUnique="false"
     * @generated
     */
    boolean hasFeature(DataFieldFeature feature);

} // DataField
