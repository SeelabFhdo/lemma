/**
 */
package de.fhdo.lemma.service.intermediate;

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Microservice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Microservice
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getSourceModelUri <em>Source Model Uri</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getVersion <em>Version</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#isEffectivelyImplemented <em>Effectively Implemented</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getTechnologies <em>Technologies</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getRequiredMicroservices <em>Required Microservices</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getRequiredInterfaces <em>Required Interfaces</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getRequiredOperations <em>Required Operations</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getServiceModel <em>Service Model</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateMicroservice()
 * @model
 * @generated
 */
public interface IntermediateMicroservice extends EObject {
    /**
     * Returns the value of the '<em><b>Source Model Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Model Uri</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Model Uri</em>' attribute.
     * @see #setSourceModelUri(String)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateMicroservice_SourceModelUri()
     * @model unique="false"
     * @generated
     */
    String getSourceModelUri();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getSourceModelUri <em>Source Model Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Model Uri</em>' attribute.
     * @see #getSourceModelUri()
     * @generated
     */
    void setSourceModelUri(String value);

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateMicroservice_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getName <em>Name</em>}' attribute.
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
     * <p>
     * If the meaning of the '<em>Version</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Version</em>' attribute.
     * @see #setVersion(String)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateMicroservice_Version()
     * @model unique="false"
     * @generated
     */
    String getVersion();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getVersion <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Version</em>' attribute.
     * @see #getVersion()
     * @generated
     */
    void setVersion(String value);

    /**
     * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Qualified Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Qualified Name</em>' attribute.
     * @see #setQualifiedName(String)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateMicroservice_QualifiedName()
     * @model unique="false"
     * @generated
     */
    String getQualifiedName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getQualifiedName <em>Qualified Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Qualified Name</em>' attribute.
     * @see #getQualifiedName()
     * @generated
     */
    void setQualifiedName(String value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see #setType(String)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateMicroservice_Type()
     * @model unique="false"
     * @generated
     */
    String getType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see #getType()
     * @generated
     */
    void setType(String value);

    /**
     * Returns the value of the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Visibility</em>' attribute.
     * @see #setVisibility(String)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateMicroservice_Visibility()
     * @model unique="false"
     * @generated
     */
    String getVisibility();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getVisibility <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Visibility</em>' attribute.
     * @see #getVisibility()
     * @generated
     */
    void setVisibility(String value);

    /**
     * Returns the value of the '<em><b>Effectively Implemented</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Effectively Implemented</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Effectively Implemented</em>' attribute.
     * @see #setEffectivelyImplemented(boolean)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateMicroservice_EffectivelyImplemented()
     * @model unique="false"
     * @generated
     */
    boolean isEffectivelyImplemented();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#isEffectivelyImplemented <em>Effectively Implemented</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Effectively Implemented</em>' attribute.
     * @see #isEffectivelyImplemented()
     * @generated
     */
    void setEffectivelyImplemented(boolean value);

    /**
     * Returns the value of the '<em><b>Technologies</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.service.intermediate.IntermediateTechnology}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateTechnology#getMicroservice <em>Microservice</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Technologies</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technologies</em>' containment reference list.
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateMicroservice_Technologies()
     * @see de.fhdo.lemma.service.intermediate.IntermediateTechnology#getMicroservice
     * @model opposite="microservice" containment="true"
     * @generated
     */
    EList<IntermediateTechnology> getTechnologies();

    /**
     * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getMicroservice <em>Microservice</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoints</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoints</em>' containment reference list.
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateMicroservice_Endpoints()
     * @see de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getMicroservice
     * @model opposite="microservice" containment="true"
     * @generated
     */
    EList<IntermediateEndpoint> getEndpoints();

    /**
     * Returns the value of the '<em><b>Protocols</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Protocols</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocols</em>' containment reference list.
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateMicroservice_Protocols()
     * @model containment="true" upper="2"
     * @generated
     */
    EList<IntermediateProtocolSpecification> getProtocols();

    /**
     * Returns the value of the '<em><b>Required Microservices</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.service.intermediate.MicroserviceReference}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#getRequiringMicroservice <em>Requiring Microservice</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Required Microservices</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Required Microservices</em>' containment reference list.
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateMicroservice_RequiredMicroservices()
     * @see de.fhdo.lemma.service.intermediate.MicroserviceReference#getRequiringMicroservice
     * @model opposite="requiringMicroservice" containment="true"
     * @generated
     */
    EList<MicroserviceReference> getRequiredMicroservices();

    /**
     * Returns the value of the '<em><b>Required Interfaces</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.service.intermediate.InterfaceReference}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.InterfaceReference#getRequiringMicroservice <em>Requiring Microservice</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Required Interfaces</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Required Interfaces</em>' containment reference list.
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateMicroservice_RequiredInterfaces()
     * @see de.fhdo.lemma.service.intermediate.InterfaceReference#getRequiringMicroservice
     * @model opposite="requiringMicroservice" containment="true"
     * @generated
     */
    EList<InterfaceReference> getRequiredInterfaces();

    /**
     * Returns the value of the '<em><b>Required Operations</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.service.intermediate.OperationReference}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.OperationReference#getRequiringMicroservice <em>Requiring Microservice</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Required Operations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Required Operations</em>' containment reference list.
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateMicroservice_RequiredOperations()
     * @see de.fhdo.lemma.service.intermediate.OperationReference#getRequiringMicroservice
     * @model opposite="requiringMicroservice" containment="true"
     * @generated
     */
    EList<OperationReference> getRequiredOperations();

    /**
     * Returns the value of the '<em><b>Interfaces</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.service.intermediate.IntermediateInterface}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateInterface#getMicroservice <em>Microservice</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Interfaces</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Interfaces</em>' containment reference list.
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateMicroservice_Interfaces()
     * @see de.fhdo.lemma.service.intermediate.IntermediateInterface#getMicroservice
     * @model opposite="microservice" containment="true" required="true"
     * @generated
     */
    EList<IntermediateInterface> getInterfaces();

    /**
     * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateMicroservice_Aspects()
     * @model containment="true"
     * @generated
     */
    EList<IntermediateImportedAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Service Model</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateServiceModel#getMicroservices <em>Microservices</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service Model</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Service Model</em>' container reference.
     * @see #setServiceModel(IntermediateServiceModel)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateMicroservice_ServiceModel()
     * @see de.fhdo.lemma.service.intermediate.IntermediateServiceModel#getMicroservices
     * @model opposite="microservices" transient="false"
     * @generated
     */
    IntermediateServiceModel getServiceModel();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getServiceModel <em>Service Model</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Service Model</em>' container reference.
     * @see #getServiceModel()
     * @generated
     */
    void setServiceModel(IntermediateServiceModel value);

} // IntermediateMicroservice
