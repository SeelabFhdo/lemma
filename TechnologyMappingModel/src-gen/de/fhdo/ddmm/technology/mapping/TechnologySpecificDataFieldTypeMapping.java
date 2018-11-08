/**
 */
package de.fhdo.ddmm.technology.mapping;

import de.fhdo.ddmm.data.Type;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Technology Specific Data Field Type Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Technology mapping for data fields of complexly typed parameters
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificDataFieldTypeMapping#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificDataFieldTypeMapping#getDataFieldHierarchy <em>Data Field Hierarchy</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificDataFieldTypeMapping#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificDataFieldTypeMapping#getParameterMapping <em>Parameter Mapping</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologySpecificDataFieldTypeMapping()
 * @model
 * @generated
 */
public interface TechnologySpecificDataFieldTypeMapping extends EObject {
    /**
     * Returns the value of the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Type must be a technology-specific primitive or complex type from the parent
     *          microservice mapping's assigned technology.
     *          Ensured by: DSL scope provider.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Type</em>' reference.
     * @see #setType(Type)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologySpecificDataFieldTypeMapping_Type()
     * @model
     * @generated
     */
    Type getType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificDataFieldTypeMapping#getType <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' reference.
     * @see #getType()
     * @generated
     */
    void setType(Type value);

    /**
     * Returns the value of the '<em><b>Data Field Hierarchy</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.DataFieldHierarchy#getMapping <em>Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Field Hierarchy</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Field Hierarchy</em>' containment reference.
     * @see #setDataFieldHierarchy(DataFieldHierarchy)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologySpecificDataFieldTypeMapping_DataFieldHierarchy()
     * @see de.fhdo.ddmm.technology.mapping.DataFieldHierarchy#getMapping
     * @model opposite="mapping" containment="true"
     * @generated
     */
    DataFieldHierarchy getDataFieldHierarchy();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificDataFieldTypeMapping#getDataFieldHierarchy <em>Data Field Hierarchy</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Field Hierarchy</em>' containment reference.
     * @see #getDataFieldHierarchy()
     * @generated
     */
    void setDataFieldHierarchy(DataFieldHierarchy value);

    /**
     * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.mapping.TechnologySpecificImportedServiceAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificImportedServiceAspect#getDataFieldMapping <em>Data Field Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologySpecificDataFieldTypeMapping_Aspects()
     * @see de.fhdo.ddmm.technology.mapping.TechnologySpecificImportedServiceAspect#getDataFieldMapping
     * @model opposite="dataFieldMapping" containment="true"
     * @generated
     */
    EList<TechnologySpecificImportedServiceAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Parameter Mapping</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.ComplexParameterMapping#getDataFieldMappings <em>Data Field Mappings</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter Mapping</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameter Mapping</em>' container reference.
     * @see #setParameterMapping(ComplexParameterMapping)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologySpecificDataFieldTypeMapping_ParameterMapping()
     * @see de.fhdo.ddmm.technology.mapping.ComplexParameterMapping#getDataFieldMappings
     * @model opposite="dataFieldMappings" transient="false"
     * @generated
     */
    ComplexParameterMapping getParameterMapping();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificDataFieldTypeMapping#getParameterMapping <em>Parameter Mapping</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parameter Mapping</em>' container reference.
     * @see #getParameterMapping()
     * @generated
     */
    void setParameterMapping(ComplexParameterMapping value);

} // TechnologySpecificDataFieldTypeMapping
