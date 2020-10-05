/**
 */
package de.fhdo.lemma.service;

import de.fhdo.lemma.technology.CommunicationType;
import de.fhdo.lemma.technology.Protocol;
import de.fhdo.lemma.technology.Technology;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Microservice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Concept to describe a microservices, its interfaces, and operations
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.Microservice#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Microservice#getVersion <em>Version</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Microservice#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Microservice#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Microservice#getT_defaultProtocols <em>Tdefault Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Microservice#getT_sourceModelUri <em>Tsource Model Uri</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Microservice#getTechnologyReferences <em>Technology References</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Microservice#getT_typeDefinitionTechnologyImport <em>Ttype Definition Technology Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Microservice#getT_typeDefinitionTechnology <em>Ttype Definition Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Microservice#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Microservice#getRequiredMicroservices <em>Required Microservices</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Microservice#getRequiredInterfaces <em>Required Interfaces</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Microservice#getRequiredOperations <em>Required Operations</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Microservice#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Microservice#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Microservice#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Microservice#getServiceModel <em>Service Model</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Microservice#isEffectivelyImplemented <em>Effectively Implemented</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Microservice#getEffectiveVisibility <em>Effective Visibility</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Microservice#isEffectivelyInternal <em>Effectively Internal</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice()
 * @model
 * @generated
 */
public interface Microservice extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) Name of a microservices must be qualified with at least one level, e.g.,
	 *          "org.MyService".
	 *          Ensured by: DSL grammar.
	 *     (C2) No cyclic inheritance, i.e., within an inheritance hierarchy, a microservice must
	 *          not occur twice.
	 *          Ensured by: DSL validator.
	 *     (C3) There might be at most one protocol per type for a microservice.
	 *          Ensured by: DSL validator.
	 *     (C4) A microservice may not require itself and only non-internal microservices from
	 *          imported models.
	 *          Ensured by: DSL scope provider.
	 *     (C5) If a technology is assigned to the service, it must exhibit specifications for types
	 *          and protocols. The rationale of this constraint is, that a technology might be
	 *          assigned, but technology-specific types or protocols must not be explicitly assigned
	 *          for convenience reasons. If they are missing, the defaults from the assigned
	 *          technology are taken instead.
	 *          Ensured by: DSL validator.
	 *     (C6) Combination of endpoints' protocols and data formats must be unique.
	 *          Ensured by: DSL validator.
	 *     (C7) A technology might be assigned exactly once to a microservice.
	 *          Ensured by: DSL validator.
	 *     (C8) If more than one technology comprises technology-specific types, it must be declared
	 *          as the default type definition technology.
	 *          Ensured by: DSL validator.
	 *     (C9) Assigned technologies may not only define deployment-specific concepts.
	 *          Ensured by: DSL validator.
	 *     (C10) If the service does not specify explicit protocols for a communication type, only
	 *           one technology may comprise a default protocol specification for that type.
	 *           Ensured by: DSL validator.
	 *     (C11) If technology models were assigned to the service it must exhibit a protocol for
	 *           each of its operation parameters' communication types.
	 *           Ensured by: DSL validator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Microservice#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice_Version()
	 * @model unique="false"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Microservice#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.fhdo.lemma.service.MicroserviceType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.fhdo.lemma.service.MicroserviceType
	 * @see #setType(MicroserviceType)
	 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice_Type()
	 * @model unique="false"
	 * @generated
	 */
	MicroserviceType getType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Microservice#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.fhdo.lemma.service.MicroserviceType
	 * @see #getType()
	 * @generated
	 */
	void setType(MicroserviceType value);

	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The default value is <code>"NONE"</code>.
	 * The literals are from the enumeration {@link de.fhdo.lemma.service.Visibility}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see de.fhdo.lemma.service.Visibility
	 * @see #setVisibility(Visibility)
	 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice_Visibility()
	 * @model default="NONE" unique="false"
	 * @generated
	 */
	Visibility getVisibility();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Microservice#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see de.fhdo.lemma.service.Visibility
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(Visibility value);

	/**
	 * Returns the value of the '<em><b>Tdefault Protocols</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tdefault Protocols</em>' attribute.
	 * @see #setT_defaultProtocols(Map)
	 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice_T_defaultProtocols()
	 * @model unique="false" dataType="de.fhdo.lemma.service.DefaultProtocols"
	 * @generated
	 */
	Map<CommunicationType, Pair<Import, Protocol>> getT_defaultProtocols();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Microservice#getT_defaultProtocols <em>Tdefault Protocols</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tdefault Protocols</em>' attribute.
	 * @see #getT_defaultProtocols()
	 * @generated
	 */
	void setT_defaultProtocols(Map<CommunicationType, Pair<Import, Protocol>> value);

	/**
	 * Returns the value of the '<em><b>Tsource Model Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tsource Model Uri</em>' attribute.
	 * @see #setT_sourceModelUri(String)
	 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice_T_sourceModelUri()
	 * @model unique="false"
	 * @generated
	 */
	String getT_sourceModelUri();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Microservice#getT_sourceModelUri <em>Tsource Model Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tsource Model Uri</em>' attribute.
	 * @see #getT_sourceModelUri()
	 * @generated
	 */
	void setT_sourceModelUri(String value);

	/**
	 * Returns the value of the '<em><b>Technology References</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.TechnologyReference}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.TechnologyReference#getMicroservice <em>Microservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Technology References</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice_TechnologyReferences()
	 * @see de.fhdo.lemma.service.TechnologyReference#getMicroservice
	 * @model opposite="microservice" containment="true"
	 * @generated
	 */
	EList<TechnologyReference> getTechnologyReferences();

	/**
	 * Returns the value of the '<em><b>Ttype Definition Technology Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ttype Definition Technology Import</em>' reference.
	 * @see #setT_typeDefinitionTechnologyImport(Import)
	 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice_T_typeDefinitionTechnologyImport()
	 * @model
	 * @generated
	 */
	Import getT_typeDefinitionTechnologyImport();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Microservice#getT_typeDefinitionTechnologyImport <em>Ttype Definition Technology Import</em>}' reference.
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
	 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice_T_typeDefinitionTechnology()
	 * @model
	 * @generated
	 */
	Technology getT_typeDefinitionTechnology();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Microservice#getT_typeDefinitionTechnology <em>Ttype Definition Technology</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ttype Definition Technology</em>' reference.
	 * @see #getT_typeDefinitionTechnology()
	 * @generated
	 */
	void setT_typeDefinitionTechnology(Technology value);

	/**
	 * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.Endpoint}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Endpoint#getMicroservice <em>Microservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoints</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice_Endpoints()
	 * @see de.fhdo.lemma.service.Endpoint#getMicroservice
	 * @model opposite="microservice" containment="true"
	 * @generated
	 */
	EList<Endpoint> getEndpoints();

	/**
	 * Returns the value of the '<em><b>Required Microservices</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.PossiblyImportedMicroservice}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.PossiblyImportedMicroservice#getRequiringMicroservice <em>Requiring Microservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Microservices</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice_RequiredMicroservices()
	 * @see de.fhdo.lemma.service.PossiblyImportedMicroservice#getRequiringMicroservice
	 * @model opposite="requiringMicroservice" containment="true"
	 * @generated
	 */
	EList<PossiblyImportedMicroservice> getRequiredMicroservices();

	/**
	 * Returns the value of the '<em><b>Required Interfaces</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.PossiblyImportedInterface}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.PossiblyImportedInterface#getRequiringMicroservice <em>Requiring Microservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Interfaces</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice_RequiredInterfaces()
	 * @see de.fhdo.lemma.service.PossiblyImportedInterface#getRequiringMicroservice
	 * @model opposite="requiringMicroservice" containment="true"
	 * @generated
	 */
	EList<PossiblyImportedInterface> getRequiredInterfaces();

	/**
	 * Returns the value of the '<em><b>Required Operations</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.PossiblyImportedOperation}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.PossiblyImportedOperation#getRequiringMicroservice <em>Requiring Microservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Operations</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice_RequiredOperations()
	 * @see de.fhdo.lemma.service.PossiblyImportedOperation#getRequiringMicroservice
	 * @model opposite="requiringMicroservice" containment="true"
	 * @generated
	 */
	EList<PossiblyImportedOperation> getRequiredOperations();

	/**
	 * Returns the value of the '<em><b>Protocols</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.ProtocolSpecification}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocols</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice_Protocols()
	 * @model containment="true" upper="2"
	 * @generated
	 */
	EList<ProtocolSpecification> getProtocols();

	/**
	 * Returns the value of the '<em><b>Interfaces</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.Interface}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Interface#getMicroservice <em>Microservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interfaces</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice_Interfaces()
	 * @see de.fhdo.lemma.service.Interface#getMicroservice
	 * @model opposite="microservice" containment="true" required="true"
	 * @generated
	 */
	EList<Interface> getInterfaces();

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.ImportedServiceAspect}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.ImportedServiceAspect#getMicroservice <em>Microservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice_Aspects()
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getMicroservice
	 * @model opposite="microservice" containment="true"
	 * @generated
	 */
	EList<ImportedServiceAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Service Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.ServiceModel#getMicroservices <em>Microservices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Model</em>' container reference.
	 * @see #setServiceModel(ServiceModel)
	 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice_ServiceModel()
	 * @see de.fhdo.lemma.service.ServiceModel#getMicroservices
	 * @model opposite="microservices" transient="false"
	 * @generated
	 */
	ServiceModel getServiceModel();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Microservice#getServiceModel <em>Service Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Model</em>' container reference.
	 * @see #getServiceModel()
	 * @generated
	 */
	void setServiceModel(ServiceModel value);

	/**
	 * Returns the value of the '<em><b>Effectively Implemented</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Check if microservice can extend another microservice as its super microservice
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Effectively Implemented</em>' attribute.
	 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice_EffectivelyImplemented()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isEffectivelyImplemented();

	/**
	 * Returns the value of the '<em><b>Effective Visibility</b></em>' attribute.
	 * The literals are from the enumeration {@link de.fhdo.lemma.service.Visibility}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get effective visibility
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Effective Visibility</em>' attribute.
	 * @see de.fhdo.lemma.service.Visibility
	 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice_EffectiveVisibility()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Visibility getEffectiveVisibility();

	/**
	 * Returns the value of the '<em><b>Effectively Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Convenience method to check if a microservice is effectively marked as being internal
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Effectively Internal</em>' attribute.
	 * @see de.fhdo.lemma.service.ServicePackage#getMicroservice_EffectivelyInternal()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isEffectivelyInternal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * TRANSFORMATION ONLY: Get effective protocols of the microservice as combinations of Protocol
	 * and DataFormat. The effective protocols are primarily determined by the microservice's
	 * protocol specifications. If a protocol specification for a communication type is missing, the
	 * default protocol and data format for the communication type are taken from the service's
	 * default protocol technology.
	 * <!-- end-model-doc -->
	 * @model dataType="de.fhdo.lemma.service.TupleList" unique="false"
	 * @generated
	 */
	List<Map<String, Object>> t_effectiveProtocolSpecifications();

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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get parts of the microservice for creating a qualified name
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<String> getQualifiedNameParts();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Build qualified name from qualified name parts
	 * <!-- end-model-doc -->
	 * @model unique="false" separatorUnique="false"
	 * @generated
	 */
	String buildQualifiedName(String separator);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get all operations of all interfaces of the microservice
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<Operation> getContainedOperations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get all referred operations of all interfaces of the microservice
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<ReferredOperation> getContainedReferredOperations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get all import descriptions from imported, required concepts
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<Import> getRequiredImports();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get all operations that are directly or indirectly (i.e., from required interfaces and
	 * microservices) required by this microservice from a given import
	 * <!-- end-model-doc -->
	 * @model unique="false" fromImportUnique="false"
	 * @generated
	 */
	EList<Operation> getAllRequiredOperations(Import fromImport);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get all microservices that are directly or indirectly (i.e., from required interfaces and
	 * operations) required by this microservice
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="de.fhdo.lemma.service.MicroserviceImportMap" unique="false"
	 * @generated
	 */
	Map<Microservice, Import> getAllRequiredMicroservices();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get all microservices whose operations' initializing parameters belong to operations of this
	 * microservice
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<Microservice> getAllInitializingMicroservices();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Check if microservice can require another microservice
	 * <!-- end-model-doc -->
	 * @model unique="false" microserviceUnique="false" isImportedServiceUnique="false"
	 * @generated
	 */
	boolean canRequire(Microservice microservice, boolean isImportedService);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Check if microservice can require an interface
	 * <!-- end-model-doc -->
	 * @model unique="false" ifaceUnique="false" isImportedInterfaceUnique="false"
	 * @generated
	 */
	boolean canRequire(Interface iface, boolean isImportedInterface);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Check if microservice can require an operation
	 * <!-- end-model-doc -->
	 * @model unique="false" operationUnique="false" isImportedOperationUnique="false"
	 * @generated
	 */
	boolean canRequire(Operation operation, boolean isImportedOperation);

} // Microservice
