/**
 */
package de.fhdo.lemma.technology.mapping;

import de.fhdo.lemma.data.PrimitiveValue;

import de.fhdo.lemma.service.Import;

import de.fhdo.lemma.technology.ServiceAspect;
import de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Technology Specific Imported Service Aspect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Metamodel concept for service aspects being imported from a technology model
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getAspect <em>Aspect</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getSinglePropertyValue <em>Single Property Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getValues <em>Values</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getTypeMapping <em>Type Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getMicroserviceMapping <em>Microservice Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getInterfaceMapping <em>Interface Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getOperationMapping <em>Operation Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getReferredOperationMapping <em>Referred Operation Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getParameterMapping <em>Parameter Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getFieldMapping <em>Field Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getDataOperationMapping <em>Data Operation Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getDataOperationReturnTypeMapping <em>Data Operation Return Type Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getDataOperationParameterMapping <em>Data Operation Parameter Mapping</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificImportedServiceAspect()
 * @model
 * @generated
 */
public interface TechnologySpecificImportedServiceAspect extends EObject {
	/**
	 * Returns the value of the '<em><b>Technology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) An aspect may not be assigned twice to a concept instance.
	 *          Ensured by: DSL validator.
	 *     (C2) A single property value may only be assigned if the aspect has exactly one property.
	 *          Ensured by: DSL validator.
	 *     (C3) Property values must match the type of the aspect property as defined in the
	 *          technology being assigned to the parent microservice mapping.
	 *          Ensured by: DSL validator.
	 *     (C4) Mandatory properties must have values assigned.
	 *          Ensured by: DSL validator.
	 *     (C5) Aspect may only be assigned to a concept if all of its selectors match.
	 *          Ensured by: DSL scope provider.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Technology</em>' reference.
	 * @see #setTechnology(Import)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificImportedServiceAspect_Technology()
	 * @model
	 * @generated
	 */
	Import getTechnology();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getTechnology <em>Technology</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Technology</em>' reference.
	 * @see #getTechnology()
	 * @generated
	 */
	void setTechnology(Import value);

	/**
	 * Returns the value of the '<em><b>Aspect</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspect</em>' reference.
	 * @see #setAspect(ServiceAspect)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificImportedServiceAspect_Aspect()
	 * @model
	 * @generated
	 */
	ServiceAspect getAspect();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getAspect <em>Aspect</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aspect</em>' reference.
	 * @see #getAspect()
	 * @generated
	 */
	void setAspect(ServiceAspect value);

	/**
	 * Returns the value of the '<em><b>Single Property Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Property Value</em>' containment reference.
	 * @see #setSinglePropertyValue(PrimitiveValue)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificImportedServiceAspect_SinglePropertyValue()
	 * @model containment="true"
	 * @generated
	 */
	PrimitiveValue getSinglePropertyValue();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getSinglePropertyValue <em>Single Property Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single Property Value</em>' containment reference.
	 * @see #getSinglePropertyValue()
	 * @generated
	 */
	void setSinglePropertyValue(PrimitiveValue value);

	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificImportedServiceAspect_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<TechnologySpecificPropertyValueAssignment> getValues();

	/**
	 * Returns the value of the '<em><b>Type Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.ComplexTypeMapping#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Mapping</em>' container reference.
	 * @see #setTypeMapping(ComplexTypeMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificImportedServiceAspect_TypeMapping()
	 * @see de.fhdo.lemma.technology.mapping.ComplexTypeMapping#getAspects
	 * @model opposite="aspects" transient="false"
	 * @generated
	 */
	ComplexTypeMapping getTypeMapping();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getTypeMapping <em>Type Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Mapping</em>' container reference.
	 * @see #getTypeMapping()
	 * @generated
	 */
	void setTypeMapping(ComplexTypeMapping value);

	/**
	 * Returns the value of the '<em><b>Microservice Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.MicroserviceMapping#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Microservice Mapping</em>' container reference.
	 * @see #setMicroserviceMapping(MicroserviceMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificImportedServiceAspect_MicroserviceMapping()
	 * @see de.fhdo.lemma.technology.mapping.MicroserviceMapping#getAspects
	 * @model opposite="aspects" transient="false"
	 * @generated
	 */
	MicroserviceMapping getMicroserviceMapping();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getMicroserviceMapping <em>Microservice Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Microservice Mapping</em>' container reference.
	 * @see #getMicroserviceMapping()
	 * @generated
	 */
	void setMicroserviceMapping(MicroserviceMapping value);

	/**
	 * Returns the value of the '<em><b>Interface Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.InterfaceMapping#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface Mapping</em>' container reference.
	 * @see #setInterfaceMapping(InterfaceMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificImportedServiceAspect_InterfaceMapping()
	 * @see de.fhdo.lemma.technology.mapping.InterfaceMapping#getAspects
	 * @model opposite="aspects" transient="false"
	 * @generated
	 */
	InterfaceMapping getInterfaceMapping();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getInterfaceMapping <em>Interface Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface Mapping</em>' container reference.
	 * @see #getInterfaceMapping()
	 * @generated
	 */
	void setInterfaceMapping(InterfaceMapping value);

	/**
	 * Returns the value of the '<em><b>Operation Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.OperationMapping#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Mapping</em>' container reference.
	 * @see #setOperationMapping(OperationMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificImportedServiceAspect_OperationMapping()
	 * @see de.fhdo.lemma.technology.mapping.OperationMapping#getAspects
	 * @model opposite="aspects" transient="false"
	 * @generated
	 */
	OperationMapping getOperationMapping();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getOperationMapping <em>Operation Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Mapping</em>' container reference.
	 * @see #getOperationMapping()
	 * @generated
	 */
	void setOperationMapping(OperationMapping value);

	/**
	 * Returns the value of the '<em><b>Referred Operation Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.ReferredOperationMapping#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Operation Mapping</em>' container reference.
	 * @see #setReferredOperationMapping(ReferredOperationMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificImportedServiceAspect_ReferredOperationMapping()
	 * @see de.fhdo.lemma.technology.mapping.ReferredOperationMapping#getAspects
	 * @model opposite="aspects" transient="false"
	 * @generated
	 */
	ReferredOperationMapping getReferredOperationMapping();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getReferredOperationMapping <em>Referred Operation Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Operation Mapping</em>' container reference.
	 * @see #getReferredOperationMapping()
	 * @generated
	 */
	void setReferredOperationMapping(ReferredOperationMapping value);

	/**
	 * Returns the value of the '<em><b>Parameter Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.ParameterMapping#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Mapping</em>' container reference.
	 * @see #setParameterMapping(ParameterMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificImportedServiceAspect_ParameterMapping()
	 * @see de.fhdo.lemma.technology.mapping.ParameterMapping#getAspects
	 * @model opposite="aspects" transient="false"
	 * @generated
	 */
	ParameterMapping getParameterMapping();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getParameterMapping <em>Parameter Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Mapping</em>' container reference.
	 * @see #getParameterMapping()
	 * @generated
	 */
	void setParameterMapping(ParameterMapping value);

	/**
	 * Returns the value of the '<em><b>Field Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificFieldMapping#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Mapping</em>' container reference.
	 * @see #setFieldMapping(TechnologySpecificFieldMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificImportedServiceAspect_FieldMapping()
	 * @see de.fhdo.lemma.technology.mapping.TechnologySpecificFieldMapping#getAspects
	 * @model opposite="aspects" transient="false"
	 * @generated
	 */
	TechnologySpecificFieldMapping getFieldMapping();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getFieldMapping <em>Field Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field Mapping</em>' container reference.
	 * @see #getFieldMapping()
	 * @generated
	 */
	void setFieldMapping(TechnologySpecificFieldMapping value);

	/**
	 * Returns the value of the '<em><b>Data Operation Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.DataOperationMapping#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Operation Mapping</em>' container reference.
	 * @see #setDataOperationMapping(DataOperationMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificImportedServiceAspect_DataOperationMapping()
	 * @see de.fhdo.lemma.technology.mapping.DataOperationMapping#getAspects
	 * @model opposite="aspects" transient="false"
	 * @generated
	 */
	DataOperationMapping getDataOperationMapping();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getDataOperationMapping <em>Data Operation Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Operation Mapping</em>' container reference.
	 * @see #getDataOperationMapping()
	 * @generated
	 */
	void setDataOperationMapping(DataOperationMapping value);

	/**
	 * Returns the value of the '<em><b>Data Operation Return Type Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.DataOperationReturnTypeMapping#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Operation Return Type Mapping</em>' container reference.
	 * @see #setDataOperationReturnTypeMapping(DataOperationReturnTypeMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificImportedServiceAspect_DataOperationReturnTypeMapping()
	 * @see de.fhdo.lemma.technology.mapping.DataOperationReturnTypeMapping#getAspects
	 * @model opposite="aspects" transient="false"
	 * @generated
	 */
	DataOperationReturnTypeMapping getDataOperationReturnTypeMapping();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getDataOperationReturnTypeMapping <em>Data Operation Return Type Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Operation Return Type Mapping</em>' container reference.
	 * @see #getDataOperationReturnTypeMapping()
	 * @generated
	 */
	void setDataOperationReturnTypeMapping(DataOperationReturnTypeMapping value);

	/**
	 * Returns the value of the '<em><b>Data Operation Parameter Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.DataOperationParameterMapping#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Operation Parameter Mapping</em>' container reference.
	 * @see #setDataOperationParameterMapping(DataOperationParameterMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologySpecificImportedServiceAspect_DataOperationParameterMapping()
	 * @see de.fhdo.lemma.technology.mapping.DataOperationParameterMapping#getAspects
	 * @model opposite="aspects" transient="false"
	 * @generated
	 */
	DataOperationParameterMapping getDataOperationParameterMapping();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getDataOperationParameterMapping <em>Data Operation Parameter Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Operation Parameter Mapping</em>' container reference.
	 * @see #getDataOperationParameterMapping()
	 * @generated
	 */
	void setDataOperationParameterMapping(DataOperationParameterMapping value);

} // TechnologySpecificImportedServiceAspect
