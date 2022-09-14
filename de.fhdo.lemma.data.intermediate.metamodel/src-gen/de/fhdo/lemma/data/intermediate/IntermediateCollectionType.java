/**
 */
package de.fhdo.lemma.data.intermediate;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Collection type
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateCollectionType#isPrimitiveCollection <em>Primitive Collection</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateCollectionType#isStructuredCollection <em>Structured Collection</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateCollectionType#getPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateCollectionType#getDataFields <em>Data Fields</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateCollectionType()
 * @model
 * @generated
 */
public interface IntermediateCollectionType extends IntermediateComplexType {
    /**
     * Returns the value of the '<em><b>Primitive Collection</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Primitive Collection</em>' attribute.
     * @see #setPrimitiveCollection(boolean)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateCollectionType_PrimitiveCollection()
     * @model unique="false"
     * @generated
     */
    boolean isPrimitiveCollection();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateCollectionType#isPrimitiveCollection <em>Primitive Collection</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Primitive Collection</em>' attribute.
     * @see #isPrimitiveCollection()
     * @generated
     */
    void setPrimitiveCollection(boolean value);

    /**
     * Returns the value of the '<em><b>Structured Collection</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Structured Collection</em>' attribute.
     * @see #setStructuredCollection(boolean)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateCollectionType_StructuredCollection()
     * @model unique="false"
     * @generated
     */
    boolean isStructuredCollection();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateCollectionType#isStructuredCollection <em>Structured Collection</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Structured Collection</em>' attribute.
     * @see #isStructuredCollection()
     * @generated
     */
    void setStructuredCollection(boolean value);

    /**
     * Returns the value of the '<em><b>Primitive Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Primitive Type</em>' containment reference.
     * @see #setPrimitiveType(IntermediatePrimitiveType)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateCollectionType_PrimitiveType()
     * @model containment="true"
     * @generated
     */
    IntermediatePrimitiveType getPrimitiveType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateCollectionType#getPrimitiveType <em>Primitive Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Primitive Type</em>' containment reference.
     * @see #getPrimitiveType()
     * @generated
     */
    void setPrimitiveType(IntermediatePrimitiveType value);

    /**
     * Returns the value of the '<em><b>Data Fields</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateDataField}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getCollectionType <em>Collection Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Fields</em>' containment reference list.
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateCollectionType_DataFields()
     * @see de.fhdo.lemma.data.intermediate.IntermediateDataField#getCollectionType
     * @model opposite="collectionType" containment="true"
     * @generated
     */
    EList<IntermediateDataField> getDataFields();

} // IntermediateCollectionType
