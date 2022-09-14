/**
 */
package de.fhdo.lemma.data.intermediate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Data field
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#isHidden <em>Hidden</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#isImmutable <em>Immutable</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#isInherited <em>Inherited</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getFeatureNames <em>Feature Names</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getInitializationValue <em>Initialization Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getInitializationValueCompatibleTypes <em>Initialization Value Compatible Types</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getOriginalType <em>Original Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getDataStructure <em>Data Structure</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getCollectionType <em>Collection Type</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataField()
 * @model
 * @generated
 */
public interface IntermediateDataField extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataField_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Qualified Name</em>' attribute.
     * @see #setQualifiedName(String)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataField_QualifiedName()
     * @model unique="false"
     * @generated
     */
    String getQualifiedName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getQualifiedName <em>Qualified Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Qualified Name</em>' attribute.
     * @see #getQualifiedName()
     * @generated
     */
    void setQualifiedName(String value);

    /**
     * Returns the value of the '<em><b>Hidden</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hidden</em>' attribute.
     * @see #setHidden(boolean)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataField_Hidden()
     * @model unique="false"
     * @generated
     */
    boolean isHidden();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#isHidden <em>Hidden</em>}' attribute.
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
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataField_Immutable()
     * @model unique="false"
     * @generated
     */
    boolean isImmutable();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#isImmutable <em>Immutable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Immutable</em>' attribute.
     * @see #isImmutable()
     * @generated
     */
    void setImmutable(boolean value);

    /**
     * Returns the value of the '<em><b>Inherited</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inherited</em>' attribute.
     * @see #setInherited(boolean)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataField_Inherited()
     * @model unique="false"
     * @generated
     */
    boolean isInherited();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#isInherited <em>Inherited</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inherited</em>' attribute.
     * @see #isInherited()
     * @generated
     */
    void setInherited(boolean value);

    /**
     * Returns the value of the '<em><b>Feature Names</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Feature Names</em>' attribute list.
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataField_FeatureNames()
     * @model unique="false"
     * @generated
     */
    EList<String> getFeatureNames();

    /**
     * Returns the value of the '<em><b>Initialization Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Initialization Value</em>' attribute.
     * @see #setInitializationValue(String)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataField_InitializationValue()
     * @model unique="false"
     * @generated
     */
    String getInitializationValue();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getInitializationValue <em>Initialization Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Initialization Value</em>' attribute.
     * @see #getInitializationValue()
     * @generated
     */
    void setInitializationValue(String value);

    /**
     * Returns the value of the '<em><b>Initialization Value Compatible Types</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType#getInitializedDataField <em>Initialized Data Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Initialization Value Compatible Types</em>' containment reference list.
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataField_InitializationValueCompatibleTypes()
     * @see de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType#getInitializedDataField
     * @model opposite="initializedDataField" containment="true"
     * @generated
     */
    EList<IntermediatePrimitiveType> getInitializationValueCompatibleTypes();

    /**
     * Returns the value of the '<em><b>Type</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateType#getDataField <em>Data Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' containment reference.
     * @see #setType(IntermediateType)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataField_Type()
     * @see de.fhdo.lemma.data.intermediate.IntermediateType#getDataField
     * @model opposite="dataField" containment="true"
     * @generated
     */
    IntermediateType getType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getType <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' containment reference.
     * @see #getType()
     * @generated
     */
    void setType(IntermediateType value);

    /**
     * Returns the value of the '<em><b>Original Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Original Type</em>' containment reference.
     * @see #setOriginalType(IntermediateType)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataField_OriginalType()
     * @model containment="true"
     * @generated
     */
    IntermediateType getOriginalType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getOriginalType <em>Original Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Original Type</em>' containment reference.
     * @see #getOriginalType()
     * @generated
     */
    void setOriginalType(IntermediateType value);

    /**
     * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getDataField <em>Data Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataField_Aspects()
     * @see de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getDataField
     * @model opposite="dataField" containment="true"
     * @generated
     */
    EList<IntermediateImportedAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Data Structure</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateDataStructure#getDataFields <em>Data Fields</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Structure</em>' container reference.
     * @see #setDataStructure(IntermediateDataStructure)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataField_DataStructure()
     * @see de.fhdo.lemma.data.intermediate.IntermediateDataStructure#getDataFields
     * @model opposite="dataFields" transient="false"
     * @generated
     */
    IntermediateDataStructure getDataStructure();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getDataStructure <em>Data Structure</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Structure</em>' container reference.
     * @see #getDataStructure()
     * @generated
     */
    void setDataStructure(IntermediateDataStructure value);

    /**
     * Returns the value of the '<em><b>Collection Type</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateCollectionType#getDataFields <em>Data Fields</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Collection Type</em>' container reference.
     * @see #setCollectionType(IntermediateCollectionType)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateDataField_CollectionType()
     * @see de.fhdo.lemma.data.intermediate.IntermediateCollectionType#getDataFields
     * @model opposite="dataFields" transient="false"
     * @generated
     */
    IntermediateCollectionType getCollectionType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getCollectionType <em>Collection Type</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Collection Type</em>' container reference.
     * @see #getCollectionType()
     * @generated
     */
    void setCollectionType(IntermediateCollectionType value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get the effective containing complex type of this data field
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     * @generated
     */
    IntermediateComplexType getEffectiveComplexType();

} // IntermediateDataField
