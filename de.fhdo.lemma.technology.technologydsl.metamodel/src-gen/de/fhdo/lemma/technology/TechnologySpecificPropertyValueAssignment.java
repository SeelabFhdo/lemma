/**
 */
package de.fhdo.lemma.technology;

import de.fhdo.lemma.data.PrimitiveValue;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specific Property Value Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Value assignment to a property
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment#getProperty <em>Property</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologySpecificPropertyValueAssignment()
 * @model
 * @generated
 */
public interface TechnologySpecificPropertyValueAssignment extends EObject {
    /**
     * Returns the value of the '<em><b>Property</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Assigned value must match property type.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Property</em>' reference.
     * @see #setProperty(TechnologySpecificProperty)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologySpecificPropertyValueAssignment_Property()
     * @model
     * @generated
     */
    TechnologySpecificProperty getProperty();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment#getProperty <em>Property</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Property</em>' reference.
     * @see #getProperty()
     * @generated
     */
    void setProperty(TechnologySpecificProperty value);

    /**
     * Returns the value of the '<em><b>Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' containment reference.
     * @see #setValue(PrimitiveValue)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologySpecificPropertyValueAssignment_Value()
     * @model containment="true"
     * @generated
     */
    PrimitiveValue getValue();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment#getValue <em>Value</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' containment reference.
     * @see #getValue()
     * @generated
     */
    void setValue(PrimitiveValue value);

} // TechnologySpecificPropertyValueAssignment
