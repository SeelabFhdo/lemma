/**
 */
package de.fhdo.lemma.data;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Super-concept of complex types
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.ComplexType#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.ComplexType#getFeatures <em>Features</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.ComplexType#getDataModel <em>Data Model</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.ComplexType#getVersion <em>Version</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.ComplexType#getContext <em>Context</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.ComplexType#isIsStructure <em>Is Structure</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.ComplexType#isIsPrimitiveCollection <em>Is Primitive Collection</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.ComplexType#isIsStructuredCollection <em>Is Structured Collection</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.ComplexType#isIsEnumeration <em>Is Enumeration</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.DataPackage#getComplexType()
 * @model abstract="true"
 * @generated
 */
public interface ComplexType extends Type {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Name must be unique.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.lemma.data.DataPackage#getComplexType_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.ComplexType#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Features</b></em>' attribute list.
     * The list contents are of type {@link de.fhdo.lemma.data.ComplexTypeFeature}.
     * The literals are from the enumeration {@link de.fhdo.lemma.data.ComplexTypeFeature}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Features</em>' attribute list.
     * @see de.fhdo.lemma.data.ComplexTypeFeature
     * @see de.fhdo.lemma.data.DataPackage#getComplexType_Features()
     * @model unique="false"
     * @generated
     */
    EList<ComplexTypeFeature> getFeatures();

    /**
     * Returns the value of the '<em><b>Data Model</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.DataModel#getComplexTypes <em>Complex Types</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Model</em>' container reference.
     * @see #setDataModel(DataModel)
     * @see de.fhdo.lemma.data.DataPackage#getComplexType_DataModel()
     * @see de.fhdo.lemma.data.DataModel#getComplexTypes
     * @model opposite="complexTypes" transient="false"
     * @generated
     */
    DataModel getDataModel();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.ComplexType#getDataModel <em>Data Model</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Model</em>' container reference.
     * @see #getDataModel()
     * @generated
     */
    void setDataModel(DataModel value);

    /**
     * Returns the value of the '<em><b>Version</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.Version#getComplexTypes <em>Complex Types</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Version</em>' container reference.
     * @see #setVersion(Version)
     * @see de.fhdo.lemma.data.DataPackage#getComplexType_Version()
     * @see de.fhdo.lemma.data.Version#getComplexTypes
     * @model opposite="complexTypes" transient="false"
     * @generated
     */
    Version getVersion();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.ComplexType#getVersion <em>Version</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Version</em>' container reference.
     * @see #getVersion()
     * @generated
     */
    void setVersion(Version value);

    /**
     * Returns the value of the '<em><b>Context</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.Context#getComplexTypes <em>Complex Types</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Context</em>' container reference.
     * @see #setContext(Context)
     * @see de.fhdo.lemma.data.DataPackage#getComplexType_Context()
     * @see de.fhdo.lemma.data.Context#getComplexTypes
     * @model opposite="complexTypes" transient="false"
     * @generated
     */
    Context getContext();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.ComplexType#getContext <em>Context</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context</em>' container reference.
     * @see #getContext()
     * @generated
     */
    void setContext(Context value);

    /**
     * Returns the value of the '<em><b>Is Structure</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Flag indicating that the ComplexType instance is a DataStructure
     * <!-- end-model-doc -->
     * @return the value of the '<em>Is Structure</em>' attribute.
     * @see de.fhdo.lemma.data.DataPackage#getComplexType_IsStructure()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    boolean isIsStructure();

    /**
     * Returns the value of the '<em><b>Is Primitive Collection</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Flag indicating that the ComplexType instance is a CollectionType that holds a PrimitiveType
     * and hence does not consist of several named and typed DataFields
     * <!-- end-model-doc -->
     * @return the value of the '<em>Is Primitive Collection</em>' attribute.
     * @see de.fhdo.lemma.data.DataPackage#getComplexType_IsPrimitiveCollection()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    boolean isIsPrimitiveCollection();

    /**
     * Returns the value of the '<em><b>Is Structured Collection</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Flag indicating that the ComplexType instance is a CollectionType that consists of several
     * named and typed DataFields instead of a single "anonymous" PrimitiveType field
     * <!-- end-model-doc -->
     * @return the value of the '<em>Is Structured Collection</em>' attribute.
     * @see de.fhdo.lemma.data.DataPackage#getComplexType_IsStructuredCollection()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    boolean isIsStructuredCollection();

    /**
     * Returns the value of the '<em><b>Is Enumeration</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Flag indicating that the ComplexType instance is an Enumeration
     * <!-- end-model-doc -->
     * @return the value of the '<em>Is Enumeration</em>' attribute.
     * @see de.fhdo.lemma.data.DataPackage#getComplexType_IsEnumeration()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    boolean isIsEnumeration();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get parts of the complex type for creating a qualified name
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
     * Get closest encompassing namespace
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     * @generated
     */
    Object getClosestNamespace();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Helper operation for ComplexType-subclasses to compare the counts of two DataField lists. The
     * return value follows the semantics of Java's Comparator.compare() method. The comparison is
     * based on the numbers of concrete types of the DataFields, i.e., primitive types are compared
     * with primitive types, structures with structures, and collections with collections. The field
     * count of the first argument is greater, i.e., the operation returns 1, in case the
     * type-specific field counts are not equal and at least one type-specific field count is
     * greater than its counterpart in the second argument, e.g., there are more collection-typed
     * fields in the first than in the second argument.
     * <!-- end-model-doc -->
     * @model unique="false" fieldsUnique="false" fieldsMany="true" fieldsToCompareUnique="false" fieldsToCompareMany="true"
     * @generated
     */
    int compareFieldCounts(EList<DataField> fields, EList<DataField> fieldsToCompare);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get list of domain-driven-design-related features
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     * @generated
     */
    EList<ComplexTypeFeature> getAllDomainFeatures();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Check if the type has a specific feature assigned
     * <!-- end-model-doc -->
     * @model unique="false" featureUnique="false"
     * @generated
     */
    boolean hasFeature(ComplexTypeFeature feature);

} // ComplexType
