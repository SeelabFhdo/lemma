/**
 */
package de.fhdo.ddmm.technology.mapping;

import de.fhdo.ddmm.data.ComplexType;

import de.fhdo.ddmm.service.Import;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Imported Complex Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents an imported complex type
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.ImportedComplexType#getServiceModelImport <em>Service Model Import</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.ImportedComplexType#getDataModelImport <em>Data Model Import</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.ImportedComplexType#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.ImportedComplexType#getTypeMapping <em>Type Mapping</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getImportedComplexType()
 * @model
 * @generated
 */
public interface ImportedComplexType extends EObject {
    /**
     * Returns the value of the '<em><b>Service Model Import</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service Model Import</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Service Model Import</em>' reference.
     * @see #setServiceModelImport(Import)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getImportedComplexType_ServiceModelImport()
     * @model
     * @generated
     */
    Import getServiceModelImport();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.ImportedComplexType#getServiceModelImport <em>Service Model Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Service Model Import</em>' reference.
     * @see #getServiceModelImport()
     * @generated
     */
    void setServiceModelImport(Import value);

    /**
     * Returns the value of the '<em><b>Data Model Import</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Model Import</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Model Import</em>' reference.
     * @see #setDataModelImport(Import)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getImportedComplexType_DataModelImport()
     * @model
     * @generated
     */
    Import getDataModelImport();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.ImportedComplexType#getDataModelImport <em>Data Model Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Model Import</em>' reference.
     * @see #getDataModelImport()
     * @generated
     */
    void setDataModelImport(Import value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' reference.
     * @see #setType(ComplexType)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getImportedComplexType_Type()
     * @model
     * @generated
     */
    ComplexType getType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.ImportedComplexType#getType <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' reference.
     * @see #getType()
     * @generated
     */
    void setType(ComplexType value);

    /**
     * Returns the value of the '<em><b>Type Mapping</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.ComplexTypeMapping#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type Mapping</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type Mapping</em>' container reference.
     * @see #setTypeMapping(ComplexTypeMapping)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getImportedComplexType_TypeMapping()
     * @see de.fhdo.ddmm.technology.mapping.ComplexTypeMapping#getType
     * @model opposite="type" transient="false"
     * @generated
     */
    ComplexTypeMapping getTypeMapping();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.ImportedComplexType#getTypeMapping <em>Type Mapping</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type Mapping</em>' container reference.
     * @see #getTypeMapping()
     * @generated
     */
    void setTypeMapping(ComplexTypeMapping value);

} // ImportedComplexType
