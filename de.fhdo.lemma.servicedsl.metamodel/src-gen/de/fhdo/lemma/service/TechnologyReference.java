/**
 */
package de.fhdo.lemma.service;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Technology Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents a reference to a technology
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.TechnologyReference#isIsTypeDefinitionTechnology <em>Is Type Definition Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.TechnologyReference#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.TechnologyReference#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.TechnologyReference#getMappedComplexType <em>Mapped Complex Type</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.ServicePackage#getTechnologyReference()
 * @model
 * @generated
 */
public interface TechnologyReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Is Type Definition Technology</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) Only one technology reference can be marked for pointing to the default type
	 *          definition technology.
	 *          Ensured by: DSL validator.
	 *     (C2) Only technology models that define types can be marked for pointing to the default
	 *                 type definition.
	 *          technology.
	 *          Ensured by: DSL validator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Type Definition Technology</em>' attribute.
	 * @see #setIsTypeDefinitionTechnology(boolean)
	 * @see de.fhdo.lemma.service.ServicePackage#getTechnologyReference_IsTypeDefinitionTechnology()
	 * @model unique="false"
	 * @generated
	 */
	boolean isIsTypeDefinitionTechnology();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.TechnologyReference#isIsTypeDefinitionTechnology <em>Is Type Definition Technology</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Type Definition Technology</em>' attribute.
	 * @see #isIsTypeDefinitionTechnology()
	 * @generated
	 */
	void setIsTypeDefinitionTechnology(boolean value);

	/**
	 * Returns the value of the '<em><b>Technology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Technology</em>' reference.
	 * @see #setTechnology(Import)
	 * @see de.fhdo.lemma.service.ServicePackage#getTechnologyReference_Technology()
	 * @model
	 * @generated
	 */
	Import getTechnology();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.TechnologyReference#getTechnology <em>Technology</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Technology</em>' reference.
	 * @see #getTechnology()
	 * @generated
	 */
	void setTechnology(Import value);

	/**
	 * Returns the value of the '<em><b>Microservice</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Microservice#getTechnologyReferences <em>Technology References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Microservice</em>' container reference.
	 * @see #setMicroservice(Microservice)
	 * @see de.fhdo.lemma.service.ServicePackage#getTechnologyReference_Microservice()
	 * @see de.fhdo.lemma.service.Microservice#getTechnologyReferences
	 * @model opposite="technologyReferences" transient="false"
	 * @generated
	 */
	Microservice getMicroservice();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.TechnologyReference#getMicroservice <em>Microservice</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Microservice</em>' container reference.
	 * @see #getMicroservice()
	 * @generated
	 */
	void setMicroservice(Microservice value);

	/**
	 * Returns the value of the '<em><b>Mapped Complex Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.MappedComplexType#getTechnologyReferences <em>Technology References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Complex Type</em>' container reference.
	 * @see #setMappedComplexType(MappedComplexType)
	 * @see de.fhdo.lemma.service.ServicePackage#getTechnologyReference_MappedComplexType()
	 * @see de.fhdo.lemma.service.MappedComplexType#getTechnologyReferences
	 * @model opposite="technologyReferences" transient="false"
	 * @generated
	 */
	MappedComplexType getMappedComplexType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.TechnologyReference#getMappedComplexType <em>Mapped Complex Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped Complex Type</em>' container reference.
	 * @see #getMappedComplexType()
	 * @generated
	 */
	void setMappedComplexType(MappedComplexType value);

} // TechnologyReference
