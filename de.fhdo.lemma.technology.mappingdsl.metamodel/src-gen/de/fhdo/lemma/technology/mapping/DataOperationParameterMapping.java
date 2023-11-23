/**
 */
package de.fhdo.lemma.technology.mapping;

import de.fhdo.lemma.data.DataOperationParameter;
import de.fhdo.lemma.data.Type;

import de.fhdo.lemma.service.Import;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Operation Parameter Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Technology mapping for parameters of data operations
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.mapping.DataOperationParameterMapping#getParameter <em>Parameter</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.DataOperationParameterMapping#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.DataOperationParameterMapping#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.DataOperationParameterMapping#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.DataOperationParameterMapping#getOperationMapping <em>Operation Mapping</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getDataOperationParameterMapping()
 * @model
 * @generated
 */
public interface DataOperationParameterMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) A parameter may be mapped only once.
	 *          Ensured by: DSL validator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameter</em>' reference.
	 * @see #setParameter(DataOperationParameter)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getDataOperationParameterMapping_Parameter()
	 * @model
	 * @generated
	 */
	DataOperationParameter getParameter();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.DataOperationParameterMapping#getParameter <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(DataOperationParameter value);

	/**
	 * Returns the value of the '<em><b>Technology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Technology</em>' reference.
	 * @see #setTechnology(Import)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getDataOperationParameterMapping_Technology()
	 * @model
	 * @generated
	 */
	Import getTechnology();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.DataOperationParameterMapping#getTechnology <em>Technology</em>}' reference.
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
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getDataOperationParameterMapping_Type()
	 * @model
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.DataOperationParameterMapping#getType <em>Type</em>}' reference.
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
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getDataOperationParameterMapping <em>Data Operation Parameter Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getDataOperationParameterMapping_Aspects()
	 * @see de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getDataOperationParameterMapping
	 * @model opposite="dataOperationParameterMapping" containment="true"
	 * @generated
	 */
	EList<TechnologySpecificImportedServiceAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Operation Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.DataOperationMapping#getParameterMappings <em>Parameter Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Mapping</em>' container reference.
	 * @see #setOperationMapping(DataOperationMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getDataOperationParameterMapping_OperationMapping()
	 * @see de.fhdo.lemma.technology.mapping.DataOperationMapping#getParameterMappings
	 * @model opposite="parameterMappings" transient="false"
	 * @generated
	 */
	DataOperationMapping getOperationMapping();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.DataOperationParameterMapping#getOperationMapping <em>Operation Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Mapping</em>' container reference.
	 * @see #getOperationMapping()
	 * @generated
	 */
	void setOperationMapping(DataOperationMapping value);

} // DataOperationParameterMapping
