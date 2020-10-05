/**
 */
package de.fhdo.lemma.service;

import de.fhdo.lemma.technology.Technology;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapped Complex Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Concept to express technology-specific information, which was assigned to a complex type
 * leveraging the Mapping DSL
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.MappedComplexType#getT_sourceModelUri <em>Tsource Model Uri</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedComplexType#getT_typeDefinitionTechnologyImport <em>Ttype Definition Technology Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedComplexType#getT_typeDefinitionTechnology <em>Ttype Definition Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedComplexType#getTechnologyReferences <em>Technology References</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedComplexType#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedComplexType#getMappedFields <em>Mapped Fields</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedComplexType#getMappedOperations <em>Mapped Operations</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedComplexType#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.MappedComplexType#getServiceModel <em>Service Model</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.ServicePackage#getMappedComplexType()
 * @model
 * @generated
 */
public interface MappedComplexType extends EObject {
	/**
	 * Returns the value of the '<em><b>Tsource Model Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tsource Model Uri</em>' attribute.
	 * @see #setT_sourceModelUri(String)
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedComplexType_T_sourceModelUri()
	 * @model unique="false"
	 * @generated
	 */
	String getT_sourceModelUri();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.MappedComplexType#getT_sourceModelUri <em>Tsource Model Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tsource Model Uri</em>' attribute.
	 * @see #getT_sourceModelUri()
	 * @generated
	 */
	void setT_sourceModelUri(String value);

	/**
	 * Returns the value of the '<em><b>Ttype Definition Technology Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ttype Definition Technology Import</em>' reference.
	 * @see #setT_typeDefinitionTechnologyImport(Import)
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedComplexType_T_typeDefinitionTechnologyImport()
	 * @model
	 * @generated
	 */
	Import getT_typeDefinitionTechnologyImport();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.MappedComplexType#getT_typeDefinitionTechnologyImport <em>Ttype Definition Technology Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ttype Definition Technology Import</em>' reference.
	 * @see #getT_typeDefinitionTechnologyImport()
	 * @generated
	 */
	void setT_typeDefinitionTechnologyImport(Import value);

	/**
	 * Returns the value of the '<em><b>Ttype Definition Technology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ttype Definition Technology</em>' reference.
	 * @see #setT_typeDefinitionTechnology(Technology)
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedComplexType_T_typeDefinitionTechnology()
	 * @model
	 * @generated
	 */
	Technology getT_typeDefinitionTechnology();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.MappedComplexType#getT_typeDefinitionTechnology <em>Ttype Definition Technology</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ttype Definition Technology</em>' reference.
	 * @see #getT_typeDefinitionTechnology()
	 * @generated
	 */
	void setT_typeDefinitionTechnology(Technology value);

	/**
	 * Returns the value of the '<em><b>Technology References</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.TechnologyReference}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.TechnologyReference#getMappedComplexType <em>Mapped Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Technology References</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedComplexType_TechnologyReferences()
	 * @see de.fhdo.lemma.service.TechnologyReference#getMappedComplexType
	 * @model opposite="mappedComplexType" containment="true"
	 * @generated
	 */
	EList<TechnologyReference> getTechnologyReferences();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(ImportedType)
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedComplexType_Type()
	 * @model containment="true"
	 * @generated
	 */
	ImportedType getType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.MappedComplexType#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(ImportedType value);

	/**
	 * Returns the value of the '<em><b>Mapped Fields</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.MappedField}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.MappedField#getMappedComplexType <em>Mapped Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Fields</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedComplexType_MappedFields()
	 * @see de.fhdo.lemma.service.MappedField#getMappedComplexType
	 * @model opposite="mappedComplexType" containment="true"
	 * @generated
	 */
	EList<MappedField> getMappedFields();

	/**
	 * Returns the value of the '<em><b>Mapped Operations</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.MappedDataOperation}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.MappedDataOperation#getMappedComplexType <em>Mapped Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Operations</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedComplexType_MappedOperations()
	 * @see de.fhdo.lemma.service.MappedDataOperation#getMappedComplexType
	 * @model opposite="mappedComplexType" containment="true"
	 * @generated
	 */
	EList<MappedDataOperation> getMappedOperations();

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.ImportedServiceAspect}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.ImportedServiceAspect#getMappedComplexType <em>Mapped Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedComplexType_Aspects()
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getMappedComplexType
	 * @model opposite="mappedComplexType" containment="true"
	 * @generated
	 */
	EList<ImportedServiceAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Service Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.ServiceModel#getMappedComplexTypes <em>Mapped Complex Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Model</em>' container reference.
	 * @see #setServiceModel(ServiceModel)
	 * @see de.fhdo.lemma.service.ServicePackage#getMappedComplexType_ServiceModel()
	 * @see de.fhdo.lemma.service.ServiceModel#getMappedComplexTypes
	 * @model opposite="mappedComplexTypes" transient="false"
	 * @generated
	 */
	ServiceModel getServiceModel();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.MappedComplexType#getServiceModel <em>Service Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Model</em>' container reference.
	 * @see #getServiceModel()
	 * @generated
	 */
	void setServiceModel(ServiceModel value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get parts of the mapped complex type for creating a qualified name
	 * <!-- end-model-doc -->
	 * @model unique="false" withImportNameUnique="false"
	 * @generated
	 */
	EList<String> getQualifiedNameParts(boolean withImportName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Build qualified name from qualified name parts
	 * <!-- end-model-doc -->
	 * @model unique="false" separatorUnique="false" withImportNameUnique="false"
	 * @generated
	 */
	String buildQualifiedName(String separator, boolean withImportName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get all technology references that point to technology models defining types
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<TechnologyReference> getAllTypeDefinitionTechnologyReferences();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get import of type definition technology. If no explicit technology reference was marked as
	 * pointing to the default type definition technology, this corresponds to the first technology
	 * import in the list of type definition technology imports. This operation should only be
	 * executed if the model had been validated to refer to one type definition technology at most.
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Import getTypeDefinitionTechnologyImport();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get type definition technology
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Technology getTypeDefinitionTechnology();

} // MappedComplexType
