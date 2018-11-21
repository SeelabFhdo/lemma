/**
 */
package de.fhdo.ddmm.technology.mapping;

import de.fhdo.ddmm.data.ComplexType;

import de.fhdo.ddmm.service.Import;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Parameter Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Technology mapping for complexly typed parameters
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.ComplexParameterMapping#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.ComplexParameterMapping#getTechnologySpecificComplexType <em>Technology Specific Complex Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.ComplexParameterMapping#getDataFieldMappings <em>Data Field Mappings</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getComplexParameterMapping()
 * @model
 * @generated
 */
public interface ComplexParameterMapping extends ParameterMapping {
    /**
     * Returns the value of the '<em><b>Technology</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) A parameter may be mapped only once.
     *          Ensured by: DSL validator.
     *     (C2) Maps either a technology-specific complex type directly or individual data fields.
     *          Ensured by: DSL scope provider.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Technology</em>' reference.
     * @see #setTechnology(Import)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getComplexParameterMapping_Technology()
     * @model
     * @generated
     */
    Import getTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.ComplexParameterMapping#getTechnology <em>Technology</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Technology</em>' reference.
     * @see #getTechnology()
     * @generated
     */
    void setTechnology(Import value);

    /**
     * Returns the value of the '<em><b>Technology Specific Complex Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Technology Specific Complex Type</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technology Specific Complex Type</em>' reference.
     * @see #setTechnologySpecificComplexType(ComplexType)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getComplexParameterMapping_TechnologySpecificComplexType()
     * @model
     * @generated
     */
    ComplexType getTechnologySpecificComplexType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.ComplexParameterMapping#getTechnologySpecificComplexType <em>Technology Specific Complex Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Technology Specific Complex Type</em>' reference.
     * @see #getTechnologySpecificComplexType()
     * @generated
     */
    void setTechnologySpecificComplexType(ComplexType value);

    /**
     * Returns the value of the '<em><b>Data Field Mappings</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.mapping.TechnologySpecificDataFieldTypeMapping}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificDataFieldTypeMapping#getParameterMapping <em>Parameter Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Field Mappings</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Field Mappings</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getComplexParameterMapping_DataFieldMappings()
     * @see de.fhdo.ddmm.technology.mapping.TechnologySpecificDataFieldTypeMapping#getParameterMapping
     * @model opposite="parameterMapping" containment="true"
     * @generated
     */
    EList<TechnologySpecificDataFieldTypeMapping> getDataFieldMappings();

} // ComplexParameterMapping
