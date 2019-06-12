/**
 */
package de.fhdo.ddmm.technology.mapping;

import de.fhdo.ddmm.data.EnumerationField;
import de.fhdo.ddmm.data.Type;

import de.fhdo.ddmm.service.Import;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Technology Specific Field Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Technology mapping for data or enumeration fields
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificFieldMapping#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificFieldMapping#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificFieldMapping#getEnumerationField <em>Enumeration Field</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificFieldMapping#getDataFieldHierarchy <em>Data Field Hierarchy</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificFieldMapping#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificFieldMapping#getParameterMapping <em>Parameter Mapping</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologySpecificFieldMapping()
 * @model
 * @generated
 */
public interface TechnologySpecificFieldMapping extends EObject {
    /**
     * Returns the value of the '<em><b>Technology</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Enumeration fields cannot exhibit mapped types.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Technology</em>' reference.
     * @see #setTechnology(Import)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologySpecificFieldMapping_Technology()
     * @model
     * @generated
     */
    Import getTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificFieldMapping#getTechnology <em>Technology</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Technology</em>' reference.
     * @see #getTechnology()
     * @generated
     */
    void setTechnology(Import value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' reference.
     * @see #setType(Type)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologySpecificFieldMapping_Type()
     * @model
     * @generated
     */
    Type getType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificFieldMapping#getType <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' reference.
     * @see #getType()
     * @generated
     */
    void setType(Type value);

    /**
     * Returns the value of the '<em><b>Enumeration Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Enumeration Field</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Enumeration Field</em>' reference.
     * @see #setEnumerationField(EnumerationField)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologySpecificFieldMapping_EnumerationField()
     * @model
     * @generated
     */
    EnumerationField getEnumerationField();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificFieldMapping#getEnumerationField <em>Enumeration Field</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enumeration Field</em>' reference.
     * @see #getEnumerationField()
     * @generated
     */
    void setEnumerationField(EnumerationField value);

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
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologySpecificFieldMapping_DataFieldHierarchy()
     * @see de.fhdo.ddmm.technology.mapping.DataFieldHierarchy#getMapping
     * @model opposite="mapping" containment="true"
     * @generated
     */
    DataFieldHierarchy getDataFieldHierarchy();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificFieldMapping#getDataFieldHierarchy <em>Data Field Hierarchy</em>}' containment reference.
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
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificImportedServiceAspect#getFieldMapping <em>Field Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologySpecificFieldMapping_Aspects()
     * @see de.fhdo.ddmm.technology.mapping.TechnologySpecificImportedServiceAspect#getFieldMapping
     * @model opposite="fieldMapping" containment="true"
     * @generated
     */
    EList<TechnologySpecificImportedServiceAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Parameter Mapping</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.ComplexParameterMapping#getFieldMappings <em>Field Mappings</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter Mapping</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameter Mapping</em>' container reference.
     * @see #setParameterMapping(ComplexParameterMapping)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologySpecificFieldMapping_ParameterMapping()
     * @see de.fhdo.ddmm.technology.mapping.ComplexParameterMapping#getFieldMappings
     * @model opposite="fieldMappings" transient="false"
     * @generated
     */
    ComplexParameterMapping getParameterMapping();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificFieldMapping#getParameterMapping <em>Parameter Mapping</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parameter Mapping</em>' container reference.
     * @see #getParameterMapping()
     * @generated
     */
    void setParameterMapping(ComplexParameterMapping value);

} // TechnologySpecificFieldMapping
