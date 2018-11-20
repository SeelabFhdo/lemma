/**
 */
package de.fhdo.ddmm.service;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Concept for importing data types, technology, and microservices into the metamodel
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.Import#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Import#getImportURI <em>Import URI</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Import#getImportType <em>Import Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Import#getServiceModel <em>Service Model</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.ServicePackage#getImport()
 * @model
 * @generated
 */
public interface Import extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) The import URI must point to a valid file.
     *          Ensured by: DSL validator.
     *     (C2) Imports must not be cyclic, i.e., the imported model must not directly or indirectly
     *          import this model.
     *          Ensured by: DSL validator.
     *     (C3) Imported file must define a model that corresponds to the import type.
     *          Ensured by: DSL validator.
     *     (C4) Import alias must be unique.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.ddmm.service.ServicePackage#getImport_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Import#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Import URI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Import URI</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Import URI</em>' attribute.
     * @see #setImportURI(String)
     * @see de.fhdo.ddmm.service.ServicePackage#getImport_ImportURI()
     * @model unique="false"
     * @generated
     */
    String getImportURI();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Import#getImportURI <em>Import URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Import URI</em>' attribute.
     * @see #getImportURI()
     * @generated
     */
    void setImportURI(String value);

    /**
     * Returns the value of the '<em><b>Import Type</b></em>' attribute.
     * The literals are from the enumeration {@link de.fhdo.ddmm.service.ImportType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Import Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Import Type</em>' attribute.
     * @see de.fhdo.ddmm.service.ImportType
     * @see #setImportType(ImportType)
     * @see de.fhdo.ddmm.service.ServicePackage#getImport_ImportType()
     * @model unique="false"
     * @generated
     */
    ImportType getImportType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Import#getImportType <em>Import Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Import Type</em>' attribute.
     * @see de.fhdo.ddmm.service.ImportType
     * @see #getImportType()
     * @generated
     */
    void setImportType(ImportType value);

    /**
     * Returns the value of the '<em><b>Service Model</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.ServiceModel#getImports <em>Imports</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service Model</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Service Model</em>' container reference.
     * @see #setServiceModel(ServiceModel)
     * @see de.fhdo.ddmm.service.ServicePackage#getImport_ServiceModel()
     * @see de.fhdo.ddmm.service.ServiceModel#getImports
     * @model opposite="imports" transient="false"
     * @generated
     */
    ServiceModel getServiceModel();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Import#getServiceModel <em>Service Model</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Service Model</em>' container reference.
     * @see #getServiceModel()
     * @generated
     */
    void setServiceModel(ServiceModel value);

} // Import
