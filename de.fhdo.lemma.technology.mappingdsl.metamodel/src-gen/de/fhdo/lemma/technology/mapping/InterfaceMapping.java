/**
 */
package de.fhdo.lemma.technology.mapping;

import de.fhdo.lemma.service.Interface;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Technology mapping for interfaces
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.mapping.InterfaceMapping#getInterface <em>Interface</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.InterfaceMapping#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.InterfaceMapping#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.InterfaceMapping#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.InterfaceMapping#getMicroserviceMapping <em>Microservice Mapping</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getInterfaceMapping()
 * @model
 * @generated
 */
public interface InterfaceMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) An interface may only be mapped once.
	 *          Ensured by: DSL validator.
	 *     (C2) Mapping must not be empty.
	 *          Ensured by: DSL validator.
	 *     (C3) Communication types of mapped protocol specifications must be unique.
	 *          Ensured by: DSL validator.
	 *     (C4) Endpoint protocols must be unique.
	 *          Ensured by: DSL validator.
	 *     (C5) Endpoint addresses must be unique.
	 *          Ensured by: DSL validator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Interface</em>' reference.
	 * @see #setInterface(Interface)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getInterfaceMapping_Interface()
	 * @model
	 * @generated
	 */
	Interface getInterface();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.InterfaceMapping#getInterface <em>Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' reference.
	 * @see #getInterface()
	 * @generated
	 */
	void setInterface(Interface value);

	/**
	 * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint#getInterfaceMapping <em>Interface Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoints</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getInterfaceMapping_Endpoints()
	 * @see de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint#getInterfaceMapping
	 * @model opposite="interfaceMapping" containment="true"
	 * @generated
	 */
	EList<TechnologySpecificEndpoint> getEndpoints();

	/**
	 * Returns the value of the '<em><b>Protocols</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.TechnologySpecificProtocolSpecification}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocols</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getInterfaceMapping_Protocols()
	 * @model containment="true"
	 * @generated
	 */
	EList<TechnologySpecificProtocolSpecification> getProtocols();

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getInterfaceMapping <em>Interface Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getInterfaceMapping_Aspects()
	 * @see de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getInterfaceMapping
	 * @model opposite="interfaceMapping" containment="true"
	 * @generated
	 */
	EList<TechnologySpecificImportedServiceAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Microservice Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.MicroserviceMapping#getInterfaceMappings <em>Interface Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Microservice Mapping</em>' container reference.
	 * @see #setMicroserviceMapping(MicroserviceMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getInterfaceMapping_MicroserviceMapping()
	 * @see de.fhdo.lemma.technology.mapping.MicroserviceMapping#getInterfaceMappings
	 * @model opposite="interfaceMappings" transient="false"
	 * @generated
	 */
	MicroserviceMapping getMicroserviceMapping();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.InterfaceMapping#getMicroserviceMapping <em>Microservice Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Microservice Mapping</em>' container reference.
	 * @see #getMicroserviceMapping()
	 * @generated
	 */
	void setMicroserviceMapping(MicroserviceMapping value);

} // InterfaceMapping
