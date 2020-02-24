/**
 */
package de.fhdo.lemma.service;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents the interface of a microservice
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.Interface#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Interface#getVersion <em>Version</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Interface#isNotImplemented <em>Not Implemented</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Interface#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Interface#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Interface#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Interface#getOperations <em>Operations</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Interface#getReferredOperations <em>Referred Operations</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Interface#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Interface#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Interface#getEffectiveVisibility <em>Effective Visibility</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Interface#isEffectivelyImplemented <em>Effectively Implemented</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Interface#isEffectivelyInternal <em>Effectively Internal</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.ServicePackage#getInterface()
 * @model
 * @generated
 */
public interface Interface extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Interface must define or refer to at least one operation.
     *          Ensured by: DSL validator.
     *     (C2) There might be at most one protocol per communication type assigned to an interface.
     *          Ensured by: DSL validator.
     *     (C3) Combination of endpoints' protocols and data formats must be unique.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.lemma.service.ServicePackage#getInterface_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.Interface#getName <em>Name</em>}' attribute.
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
     * @see de.fhdo.lemma.service.ServicePackage#getInterface_Version()
     * @model unique="false"
     * @generated
     */
    String getVersion();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.Interface#getVersion <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Version</em>' attribute.
     * @see #getVersion()
     * @generated
     */
    void setVersion(String value);

    /**
     * Returns the value of the '<em><b>Not Implemented</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Not Implemented</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Not Implemented</em>' attribute.
     * @see #setNotImplemented(boolean)
     * @see de.fhdo.lemma.service.ServicePackage#getInterface_NotImplemented()
     * @model default="false" unique="false"
     * @generated
     */
    boolean isNotImplemented();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.Interface#isNotImplemented <em>Not Implemented</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Not Implemented</em>' attribute.
     * @see #isNotImplemented()
     * @generated
     */
    void setNotImplemented(boolean value);

    /**
     * Returns the value of the '<em><b>Visibility</b></em>' attribute.
     * The default value is <code>"NONE"</code>.
     * The literals are from the enumeration {@link de.fhdo.lemma.service.Visibility}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Visibility</em>' attribute.
     * @see de.fhdo.lemma.service.Visibility
     * @see #setVisibility(Visibility)
     * @see de.fhdo.lemma.service.ServicePackage#getInterface_Visibility()
     * @model default="NONE" unique="false"
     * @generated
     */
    Visibility getVisibility();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.Interface#getVisibility <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Visibility</em>' attribute.
     * @see de.fhdo.lemma.service.Visibility
     * @see #getVisibility()
     * @generated
     */
    void setVisibility(Visibility value);

    /**
     * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.service.Endpoint}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Endpoint#getInterface <em>Interface</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoints</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoints</em>' containment reference list.
     * @see de.fhdo.lemma.service.ServicePackage#getInterface_Endpoints()
     * @see de.fhdo.lemma.service.Endpoint#getInterface
     * @model opposite="interface" containment="true"
     * @generated
     */
    EList<Endpoint> getEndpoints();

    /**
     * Returns the value of the '<em><b>Protocols</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.service.ProtocolSpecification}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Protocols</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocols</em>' containment reference list.
     * @see de.fhdo.lemma.service.ServicePackage#getInterface_Protocols()
     * @model containment="true" upper="2"
     * @generated
     */
    EList<ProtocolSpecification> getProtocols();

    /**
     * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.service.Operation}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Operation#getInterface <em>Interface</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operations</em>' containment reference list.
     * @see de.fhdo.lemma.service.ServicePackage#getInterface_Operations()
     * @see de.fhdo.lemma.service.Operation#getInterface
     * @model opposite="interface" containment="true"
     * @generated
     */
    EList<Operation> getOperations();

    /**
     * Returns the value of the '<em><b>Referred Operations</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.service.ReferredOperation}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.ReferredOperation#getInterface <em>Interface</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Referred Operations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Referred Operations</em>' containment reference list.
     * @see de.fhdo.lemma.service.ServicePackage#getInterface_ReferredOperations()
     * @see de.fhdo.lemma.service.ReferredOperation#getInterface
     * @model opposite="interface" containment="true"
     * @generated
     */
    EList<ReferredOperation> getReferredOperations();

    /**
     * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.service.ImportedServiceAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.ImportedServiceAspect#getInterface <em>Interface</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.lemma.service.ServicePackage#getInterface_Aspects()
     * @see de.fhdo.lemma.service.ImportedServiceAspect#getInterface
     * @model opposite="interface" containment="true"
     * @generated
     */
    EList<ImportedServiceAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Microservice</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Microservice#getInterfaces <em>Interfaces</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Microservice</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Microservice</em>' container reference.
     * @see #setMicroservice(Microservice)
     * @see de.fhdo.lemma.service.ServicePackage#getInterface_Microservice()
     * @see de.fhdo.lemma.service.Microservice#getInterfaces
     * @model opposite="interfaces" transient="false"
     * @generated
     */
    Microservice getMicroservice();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.Interface#getMicroservice <em>Microservice</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Microservice</em>' container reference.
     * @see #getMicroservice()
     * @generated
     */
    void setMicroservice(Microservice value);

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
     * @see de.fhdo.lemma.service.ServicePackage#getInterface_EffectiveVisibility()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    Visibility getEffectiveVisibility();

    /**
     * Returns the value of the '<em><b>Effectively Implemented</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Convenience method to check if an interface is effectively implemented
     * <!-- end-model-doc -->
     * @return the value of the '<em>Effectively Implemented</em>' attribute.
     * @see de.fhdo.lemma.service.ServicePackage#getInterface_EffectivelyImplemented()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    boolean isEffectivelyImplemented();

    /**
     * Returns the value of the '<em><b>Effectively Internal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Convenience method to check if an interface is effectively marked as being internal
     * <!-- end-model-doc -->
     * @return the value of the '<em>Effectively Internal</em>' attribute.
     * @see de.fhdo.lemma.service.ServicePackage#getInterface_EffectivelyInternal()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    boolean isEffectivelyInternal();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * TRANSFORMATION ONLY: Get effective protocols of the interface as combinations of Protocol
     * and DataFormat. The effective protocols are primarily determined by the interface's protocol
     * specifications. If a protocol specification for a communication type is missing, the type's
     * effective protocols are taken from the containing microservice.
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
     * Get parts of the interface for creating a qualified name
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

} // Interface
