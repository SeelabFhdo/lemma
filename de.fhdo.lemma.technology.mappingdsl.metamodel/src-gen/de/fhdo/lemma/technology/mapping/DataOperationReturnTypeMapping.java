/**
 */
package de.fhdo.lemma.technology.mapping;

import de.fhdo.lemma.data.Type;

import de.fhdo.lemma.service.Import;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Operation Return Type Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Technology mapping for return types of data operations
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.mapping.DataOperationReturnTypeMapping#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.DataOperationReturnTypeMapping#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.DataOperationReturnTypeMapping#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.DataOperationReturnTypeMapping#getOperationMapping <em>Operation Mapping</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getDataOperationReturnTypeMapping()
 * @model
 * @generated
 */
public interface DataOperationReturnTypeMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Technology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) A return type may be mapped only once.
	 *          Ensured by: DSL validator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Technology</em>' reference.
	 * @see #setTechnology(Import)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getDataOperationReturnTypeMapping_Technology()
	 * @model
	 * @generated
	 */
	Import getTechnology();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.DataOperationReturnTypeMapping#getTechnology <em>Technology</em>}' reference.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Type)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getDataOperationReturnTypeMapping_Type()
	 * @model
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.DataOperationReturnTypeMapping#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getDataOperationReturnTypeMapping <em>Data Operation Return Type Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getDataOperationReturnTypeMapping_Aspects()
	 * @see de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getDataOperationReturnTypeMapping
	 * @model opposite="dataOperationReturnTypeMapping" containment="true"
	 * @generated
	 */
	EList<TechnologySpecificImportedServiceAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Operation Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.DataOperationMapping#getReturnTypeMapping <em>Return Type Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Mapping</em>' container reference.
	 * @see #setOperationMapping(DataOperationMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getDataOperationReturnTypeMapping_OperationMapping()
	 * @see de.fhdo.lemma.technology.mapping.DataOperationMapping#getReturnTypeMapping
	 * @model opposite="returnTypeMapping" transient="false"
	 * @generated
	 */
	DataOperationMapping getOperationMapping();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.DataOperationReturnTypeMapping#getOperationMapping <em>Operation Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Mapping</em>' container reference.
	 * @see #getOperationMapping()
	 * @generated
	 */
	void setOperationMapping(DataOperationMapping value);

} // DataOperationReturnTypeMapping
