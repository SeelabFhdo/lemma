/**
 */
package de.fhdo.ddmm.technology.mapping;

import de.fhdo.ddmm.service.Import;

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
 *   <li>{@link de.fhdo.ddmm.technology.mapping.MicroserviceMapping#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.MicroserviceMapping#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.MicroserviceMapping#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.MicroserviceMapping#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.MicroserviceMapping#getInterfaceMappings <em>Interface Mappings</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.MicroserviceMapping#getOperationMappings <em>Operation Mappings</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.MicroserviceMapping#getReferredOperationMappings <em>Referred Operation Mappings</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.MicroserviceMapping#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.MicroserviceMapping#getMappingModel <em>Mapping Model</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getMicroserviceMapping()
 * @model
 * @generated
 */
public interface MicroserviceMapping extends EObject {
    /**
     * Returns the value of the '<em><b>Technology</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Mapping must not be empty.
     *          Ensured by: DSL validator.
     *     (C2) Communication types of mapped protocol specifications must be unique.
     *          Ensured by: DSL validator.
     *     (C3) Endpoint protocols must be unique.
     *          Ensured by: DSL validator.
     *     (C4) Endpoint addresses must be unique.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Technology</em>' reference.
     * @see #setTechnology(Import)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getMicroserviceMapping_Technology()
     * @model
     * @generated
     */
    Import getTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.MicroserviceMapping#getTechnology <em>Technology</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Technology</em>' reference.
     * @see #getTechnology()
     * @generated
     */
    void setTechnology(Import value);

    /**
     * Returns the value of the '<em><b>Microservice</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.ImportedMicroservice#getMicroserviceMapping <em>Microservice Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Microservice</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Microservice</em>' containment reference.
     * @see #setMicroservice(ImportedMicroservice)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getMicroserviceMapping_Microservice()
     * @see de.fhdo.ddmm.technology.mapping.ImportedMicroservice#getMicroserviceMapping
     * @model opposite="microserviceMapping" containment="true"
     * @generated
     */
    ImportedMicroservice getMicroservice();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.MicroserviceMapping#getMicroservice <em>Microservice</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Microservice</em>' containment reference.
     * @see #getMicroservice()
     * @generated
     */
    void setMicroservice(ImportedMicroservice value);

    /**
     * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.mapping.TechnologySpecificEndpoint}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificEndpoint#getMicroserviceMapping <em>Microservice Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoints</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoints</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getMicroserviceMapping_Endpoints()
     * @see de.fhdo.ddmm.technology.mapping.TechnologySpecificEndpoint#getMicroserviceMapping
     * @model opposite="microserviceMapping" containment="true"
     * @generated
     */
    EList<TechnologySpecificEndpoint> getEndpoints();

    /**
     * Returns the value of the '<em><b>Protocols</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocolSpecification}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Protocols</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocols</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getMicroserviceMapping_Protocols()
     * @model containment="true"
     * @generated
     */
    EList<TechnologySpecificProtocolSpecification> getProtocols();

    /**
     * Returns the value of the '<em><b>Interface Mappings</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.mapping.InterfaceMapping}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.InterfaceMapping#getMicroserviceMapping <em>Microservice Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Interface Mappings</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Interface Mappings</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getMicroserviceMapping_InterfaceMappings()
     * @see de.fhdo.ddmm.technology.mapping.InterfaceMapping#getMicroserviceMapping
     * @model opposite="microserviceMapping" containment="true"
     * @generated
     */
    EList<InterfaceMapping> getInterfaceMappings();

    /**
     * Returns the value of the '<em><b>Operation Mappings</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.mapping.OperationMapping}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.OperationMapping#getMicroserviceMapping <em>Microservice Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation Mappings</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation Mappings</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getMicroserviceMapping_OperationMappings()
     * @see de.fhdo.ddmm.technology.mapping.OperationMapping#getMicroserviceMapping
     * @model opposite="microserviceMapping" containment="true"
     * @generated
     */
    EList<OperationMapping> getOperationMappings();

    /**
     * Returns the value of the '<em><b>Referred Operation Mappings</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.mapping.ReferredOperationMapping}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.ReferredOperationMapping#getMicroserviceMapping <em>Microservice Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Referred Operation Mappings</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Referred Operation Mappings</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getMicroserviceMapping_ReferredOperationMappings()
     * @see de.fhdo.ddmm.technology.mapping.ReferredOperationMapping#getMicroserviceMapping
     * @model opposite="microserviceMapping" containment="true"
     * @generated
     */
    EList<ReferredOperationMapping> getReferredOperationMappings();

    /**
     * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.mapping.TechnologySpecificImportedServiceAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificImportedServiceAspect#getMicroserviceMapping <em>Microservice Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getMicroserviceMapping_Aspects()
     * @see de.fhdo.ddmm.technology.mapping.TechnologySpecificImportedServiceAspect#getMicroserviceMapping
     * @model opposite="microserviceMapping" containment="true"
     * @generated
     */
    EList<TechnologySpecificImportedServiceAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Mapping Model</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.TechnologyMapping#getMappings <em>Mappings</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mapping Model</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mapping Model</em>' container reference.
     * @see #setMappingModel(TechnologyMapping)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getMicroserviceMapping_MappingModel()
     * @see de.fhdo.ddmm.technology.mapping.TechnologyMapping#getMappings
     * @model opposite="mappings" transient="false"
     * @generated
     */
    TechnologyMapping getMappingModel();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.MicroserviceMapping#getMappingModel <em>Mapping Model</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mapping Model</em>' container reference.
     * @see #getMappingModel()
     * @generated
     */
    void setMappingModel(TechnologyMapping value);

} // MicroserviceMapping
