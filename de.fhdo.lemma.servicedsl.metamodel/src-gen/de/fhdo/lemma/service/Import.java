/**
 */
package de.fhdo.lemma.service;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Concept for importing data types, technologies, and microservices into the metamodel
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.Import#getT_relatedImportAlias <em>Trelated Import Alias</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Import#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Import#getImportURI <em>Import URI</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Import#getExternalURI <em>External URI</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Import#getImportType <em>Import Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Import#getServiceModel <em>Service Model</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.ServicePackage#getImport()
 * @model
 * @generated
 */
public interface Import extends EObject {
	/**
	 * Returns the value of the '<em><b>Trelated Import Alias</b></em>' attribute.
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
	 * @return the value of the '<em>Trelated Import Alias</em>' attribute.
	 * @see #setT_relatedImportAlias(String)
	 * @see de.fhdo.lemma.service.ServicePackage#getImport_T_relatedImportAlias()
	 * @model unique="false"
	 * @generated
	 */
	String getT_relatedImportAlias();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Import#getT_relatedImportAlias <em>Trelated Import Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trelated Import Alias</em>' attribute.
	 * @see #getT_relatedImportAlias()
	 * @generated
	 */
	void setT_relatedImportAlias(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.service.ServicePackage#getImport_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Import#getName <em>Name</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import URI</em>' attribute.
	 * @see #setImportURI(String)
	 * @see de.fhdo.lemma.service.ServicePackage#getImport_ImportURI()
	 * @model unique="false"
	 * @generated
	 */
	String getImportURI();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Import#getImportURI <em>Import URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import URI</em>' attribute.
	 * @see #getImportURI()
	 * @generated
	 */
	void setImportURI(String value);

	/**
	 * Returns the value of the '<em><b>External URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External URI</em>' attribute.
	 * @see #setExternalURI(String)
	 * @see de.fhdo.lemma.service.ServicePackage#getImport_ExternalURI()
	 * @model unique="false"
	 * @generated
	 */
	String getExternalURI();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Import#getExternalURI <em>External URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External URI</em>' attribute.
	 * @see #getExternalURI()
	 * @generated
	 */
	void setExternalURI(String value);

	/**
	 * Returns the value of the '<em><b>Import Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.fhdo.lemma.service.ImportType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Type</em>' attribute.
	 * @see de.fhdo.lemma.service.ImportType
	 * @see #setImportType(ImportType)
	 * @see de.fhdo.lemma.service.ServicePackage#getImport_ImportType()
	 * @model unique="false"
	 * @generated
	 */
	ImportType getImportType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Import#getImportType <em>Import Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import Type</em>' attribute.
	 * @see de.fhdo.lemma.service.ImportType
	 * @see #getImportType()
	 * @generated
	 */
	void setImportType(ImportType value);

	/**
	 * Returns the value of the '<em><b>Service Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.ServiceModel#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Model</em>' container reference.
	 * @see #setServiceModel(ServiceModel)
	 * @see de.fhdo.lemma.service.ServicePackage#getImport_ServiceModel()
	 * @see de.fhdo.lemma.service.ServiceModel#getImports
	 * @model opposite="imports" transient="false"
	 * @generated
	 */
	ServiceModel getServiceModel();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Import#getServiceModel <em>Service Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Model</em>' container reference.
	 * @see #getServiceModel()
	 * @generated
	 */
	void setServiceModel(ServiceModel value);

} // Import
