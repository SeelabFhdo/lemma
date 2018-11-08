/**
 */
package de.fhdo.ddmm.technology;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Aspect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Metamodel concept for operation aspects
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.OperationAspect#getTechnology <em>Technology</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.TechnologyPackage#getOperationAspect()
 * @model
 * @generated
 */
public interface OperationAspect extends TechnologyAspect {
    /**
     * Returns the value of the '<em><b>Technology</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.Technology#getOperationAspects <em>Operation Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Technology</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technology</em>' container reference.
     * @see #setTechnology(Technology)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getOperationAspect_Technology()
     * @see de.fhdo.ddmm.technology.Technology#getOperationAspects
     * @model opposite="operationAspects" transient="false"
     * @generated
     */
    Technology getTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.OperationAspect#getTechnology <em>Technology</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Technology</em>' container reference.
     * @see #getTechnology()
     * @generated
     */
    void setTechnology(Technology value);

} // OperationAspect
