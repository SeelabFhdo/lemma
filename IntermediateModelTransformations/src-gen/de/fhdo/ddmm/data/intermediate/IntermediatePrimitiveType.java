/**
 */
package de.fhdo.ddmm.data.intermediate;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Primitive type
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.data.intermediate.IntermediatePrimitiveType#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.data.intermediate.IntermediatePackage#getIntermediatePrimitiveType()
 * @model
 * @generated
 */
public interface IntermediatePrimitiveType extends IntermediateType {
    /**
     * Returns the value of the '<em><b>Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Size</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Size</em>' attribute.
     * @see #setSize(Integer)
     * @see de.fhdo.ddmm.data.intermediate.IntermediatePackage#getIntermediatePrimitiveType_Size()
     * @model unique="false"
     * @generated
     */
    Integer getSize();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.intermediate.IntermediatePrimitiveType#getSize <em>Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Size</em>' attribute.
     * @see #getSize()
     * @generated
     */
    void setSize(Integer value);

} // IntermediatePrimitiveType
