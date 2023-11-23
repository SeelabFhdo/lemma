/**
 */
package de.fhdo.lemma.technology.mapping;

import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.TechnologyReference;

import de.fhdo.lemma.technology.Technology;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Microservice Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Technology mapping for microservices
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.mapping.MicroserviceMapping#getTechnologyReferences <em>Technology References</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.MicroserviceMapping#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.MicroserviceMapping#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.MicroserviceMapping#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.MicroserviceMapping#getInterfaceMappings <em>Interface Mappings</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.MicroserviceMapping#getOperationMappings <em>Operation Mappings</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.MicroserviceMapping#getReferredOperationMappings <em>Referred Operation Mappings</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.MicroserviceMapping#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.MicroserviceMapping#getMappingModel <em>Mapping Model</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getMicroserviceMapping()
 * @model
 * @generated
 */
public interface MicroserviceMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Technology References</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.TechnologyReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) Communication types of mapped protocol specifications must be unique.
	 *          Ensured by: DSL validator.
	 *     (C2) Endpoint protocols must be unique.
	 *          Ensured by: DSL validator.
	 *     (C3) Endpoint addresses must be unique.
	 *          Ensured by: DSL validator.
	 *     (C4) A technology might be assigned exactly once to a microservice mapping.
	 *          Ensured by: DSL validator.
	 *     (C5) If more than one technology comprises technology-specific types, it must be declared
	 *          as the default type definition technology.
	 *          Ensured by: DSL validator.
	 *     (C6) Assigned technologies may not only define deployment-specific concepts.
	 *          Ensured by: DSL validator.
	 *     (C7) Type definition technologies of microservices cannot differ in service and mapping
	 *          model in case the service model refers to technology-specific types. Otherwise, the
	 *          transformation of the mapping to a service model would not be possible, because the
	 *          technology-specific types could not be mapped, as both service and mapping model
	 *          refer to different technologies for the service.
	 *          Ensured by: DSL validator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Technology References</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getMicroserviceMapping_TechnologyReferences()
	 * @model containment="true"
	 * @generated
	 */
	EList<TechnologyReference> getTechnologyReferences();

	/**
	 * Returns the value of the '<em><b>Microservice</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.ImportedMicroservice#getMicroserviceMapping <em>Microservice Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Microservice</em>' containment reference.
	 * @see #setMicroservice(ImportedMicroservice)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getMicroserviceMapping_Microservice()
	 * @see de.fhdo.lemma.technology.mapping.ImportedMicroservice#getMicroserviceMapping
	 * @model opposite="microserviceMapping" containment="true"
	 * @generated
	 */
	ImportedMicroservice getMicroservice();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.MicroserviceMapping#getMicroservice <em>Microservice</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Microservice</em>' containment reference.
	 * @see #getMicroservice()
	 * @generated
	 */
	void setMicroservice(ImportedMicroservice value);

	/**
	 * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint#getMicroserviceMapping <em>Microservice Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoints</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getMicroserviceMapping_Endpoints()
	 * @see de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint#getMicroserviceMapping
	 * @model opposite="microserviceMapping" containment="true"
	 * @generated
	 */
	EList<TechnologySpecificEndpoint> getEndpoints();

	/**
	 * Returns the value of the '<em><b>Protocols</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.TechnologySpecificProtocolSpecification}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocols</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getMicroserviceMapping_Protocols()
	 * @model containment="true"
	 * @generated
	 */
	EList<TechnologySpecificProtocolSpecification> getProtocols();

	/**
	 * Returns the value of the '<em><b>Interface Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.InterfaceMapping}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.InterfaceMapping#getMicroserviceMapping <em>Microservice Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface Mappings</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getMicroserviceMapping_InterfaceMappings()
	 * @see de.fhdo.lemma.technology.mapping.InterfaceMapping#getMicroserviceMapping
	 * @model opposite="microserviceMapping" containment="true"
	 * @generated
	 */
	EList<InterfaceMapping> getInterfaceMappings();

	/**
	 * Returns the value of the '<em><b>Operation Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.OperationMapping}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.OperationMapping#getMicroserviceMapping <em>Microservice Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Mappings</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getMicroserviceMapping_OperationMappings()
	 * @see de.fhdo.lemma.technology.mapping.OperationMapping#getMicroserviceMapping
	 * @model opposite="microserviceMapping" containment="true"
	 * @generated
	 */
	EList<OperationMapping> getOperationMappings();

	/**
	 * Returns the value of the '<em><b>Referred Operation Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.ReferredOperationMapping}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.ReferredOperationMapping#getMicroserviceMapping <em>Microservice Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Operation Mappings</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getMicroserviceMapping_ReferredOperationMappings()
	 * @see de.fhdo.lemma.technology.mapping.ReferredOperationMapping#getMicroserviceMapping
	 * @model opposite="microserviceMapping" containment="true"
	 * @generated
	 */
	EList<ReferredOperationMapping> getReferredOperationMappings();

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getMicroserviceMapping <em>Microservice Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getMicroserviceMapping_Aspects()
	 * @see de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getMicroserviceMapping
	 * @model opposite="microserviceMapping" containment="true"
	 * @generated
	 */
	EList<TechnologySpecificImportedServiceAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Mapping Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.TechnologyMapping#getServiceMappings <em>Service Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Model</em>' container reference.
	 * @see #setMappingModel(TechnologyMapping)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getMicroserviceMapping_MappingModel()
	 * @see de.fhdo.lemma.technology.mapping.TechnologyMapping#getServiceMappings
	 * @model opposite="serviceMappings" transient="false"
	 * @generated
	 */
	TechnologyMapping getMappingModel();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.MicroserviceMapping#getMappingModel <em>Mapping Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Model</em>' container reference.
	 * @see #getMappingModel()
	 * @generated
	 */
	void setMappingModel(TechnologyMapping value);

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

} // MicroserviceMapping
