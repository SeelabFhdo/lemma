/**
 */
package de.fhdo.ddmm.technology.mapping;

import de.fhdo.ddmm.data.DataField;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Field Hierarchy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents the "hierarchy" of data fields in complexly typed parameters. That is, if a data field
 * itself is again complexly typed then its structure resides on the second level of the hierarchy.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.DataFieldHierarchy#getDataFields <em>Data Fields</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.DataFieldHierarchy#getPrevious <em>Previous</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.DataFieldHierarchy#getMapping <em>Mapping</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getDataFieldHierarchy()
 * @model
 * @generated
 */
public interface DataFieldHierarchy extends EObject {
    /**
     * Returns the value of the '<em><b>Data Fields</b></em>' reference list.
     * The list contents are of type {@link de.fhdo.ddmm.data.DataField}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Fields</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Fields</em>' reference list.
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getDataFieldHierarchy_DataFields()
     * @model
     * @generated
     */
    EList<DataField> getDataFields();

    /**
     * Returns the value of the '<em><b>Previous</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Previous</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Previous</em>' containment reference.
     * @see #setPrevious(DataFieldHierarchy)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getDataFieldHierarchy_Previous()
     * @model containment="true"
     * @generated
     */
    DataFieldHierarchy getPrevious();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.DataFieldHierarchy#getPrevious <em>Previous</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Previous</em>' containment reference.
     * @see #getPrevious()
     * @generated
     */
    void setPrevious(DataFieldHierarchy value);

    /**
     * Returns the value of the '<em><b>Mapping</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificDataFieldTypeMapping#getDataFieldHierarchy <em>Data Field Hierarchy</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mapping</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mapping</em>' container reference.
     * @see #setMapping(TechnologySpecificDataFieldTypeMapping)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getDataFieldHierarchy_Mapping()
     * @see de.fhdo.ddmm.technology.mapping.TechnologySpecificDataFieldTypeMapping#getDataFieldHierarchy
     * @model opposite="dataFieldHierarchy" transient="false"
     * @generated
     */
    TechnologySpecificDataFieldTypeMapping getMapping();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.DataFieldHierarchy#getMapping <em>Mapping</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mapping</em>' container reference.
     * @see #getMapping()
     * @generated
     */
    void setMapping(TechnologySpecificDataFieldTypeMapping value);

} // DataFieldHierarchy
