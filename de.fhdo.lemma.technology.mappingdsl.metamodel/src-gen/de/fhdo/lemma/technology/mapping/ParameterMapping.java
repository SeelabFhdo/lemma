/**
 */
package de.fhdo.lemma.technology.mapping;

import de.fhdo.lemma.service.Parameter;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Abstract superclass for technology mapping of operation parameters
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.mapping.ParameterMapping#getParameter <em>Parameter</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.ParameterMapping#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.ParameterMapping#getOperationMapping <em>Operation Mapping</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getParameterMapping()
 * @model abstract="true"
 * @generated
 */
public interface ParameterMapping extends EObject {
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
	 * @see #setParameter(Parameter)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getParameterMapping_Parameter()
	 * @model
	 * @generated
	 */
	Parameter getParameter();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.ParameterMapping#getParameter <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(Parameter value);

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getParameterMapping <em>Parameter Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getParameterMapping_Aspects()
	 * @see de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getParameterMapping
	 * @model opposite="parameterMapping" containment="true"
	 * @generated
	 */
	EList<TechnologySpecificImportedServiceAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Operation Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.OperationMapping#getParameterMappings <em>Parameter Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Mapping</em>' container reference.
	 * @see #setOperationMapping(OperationMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getParameterMapping_OperationMapping()
	 * @see de.fhdo.lemma.technology.mapping.OperationMapping#getParameterMappings
	 * @model opposite="parameterMappings" transient="false"
	 * @generated
	 */
	OperationMapping getOperationMapping();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.ParameterMapping#getOperationMapping <em>Operation Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Mapping</em>' container reference.
	 * @see #getOperationMapping()
	 * @generated
	 */
	void setOperationMapping(OperationMapping value);

} // ParameterMapping
