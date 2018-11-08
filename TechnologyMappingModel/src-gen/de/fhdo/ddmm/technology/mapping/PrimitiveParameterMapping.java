/**
 */
package de.fhdo.ddmm.technology.mapping;

import de.fhdo.ddmm.technology.TechnologySpecificPrimitiveType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Parameter Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Technology mapping for primitively typed parameters
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.PrimitiveParameterMapping#getPrimitiveType <em>Primitive Type</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getPrimitiveParameterMapping()
 * @model
 * @generated
 */
public interface PrimitiveParameterMapping extends ParameterMapping {
    /**
     * Returns the value of the '<em><b>Primitive Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Type must be a technology-specific primitive from the parent microservice mapping's
     *          assigned technology.
     *          Ensured by: DSL scope provider.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Primitive Type</em>' reference.
     * @see #setPrimitiveType(TechnologySpecificPrimitiveType)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getPrimitiveParameterMapping_PrimitiveType()
     * @model
     * @generated
     */
    TechnologySpecificPrimitiveType getPrimitiveType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.PrimitiveParameterMapping#getPrimitiveType <em>Primitive Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Primitive Type</em>' reference.
     * @see #getPrimitiveType()
     * @generated
     */
    void setPrimitiveType(TechnologySpecificPrimitiveType value);

} // PrimitiveParameterMapping
