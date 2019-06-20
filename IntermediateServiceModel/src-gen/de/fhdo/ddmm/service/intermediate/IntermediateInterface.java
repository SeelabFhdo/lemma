/**
 */
package de.fhdo.ddmm.service.intermediate;

import de.fhdo.ddmm.data.intermediate.IntermediateImportedAspect;

import de.fhdo.ddmm.service.Visibility;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Interface
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateInterface#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateInterface#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateInterface#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateInterface#isNotImplemented <em>Not Implemented</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateInterface#isHasImplementedOperations <em>Has Implemented Operations</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateInterface#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateInterface#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateInterface#getOperations <em>Operations</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateInterface#getReferredOperations <em>Referred Operations</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateInterface#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateInterface#getMicroservice <em>Microservice</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateInterface()
 * @model
 * @generated
 */
public interface IntermediateInterface extends EObject {
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
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateInterface_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateInterface#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

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
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateInterface_QualifiedName()
     * @model unique="false"
     * @generated
     */
    String getQualifiedName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateInterface#getQualifiedName <em>Qualified Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Qualified Name</em>' attribute.
     * @see #getQualifiedName()
     * @generated
     */
    void setQualifiedName(String value);

    /**
     * Returns the value of the '<em><b>Visibility</b></em>' attribute.
     * The literals are from the enumeration {@link de.fhdo.ddmm.service.Visibility}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Visibility</em>' attribute.
     * @see de.fhdo.ddmm.service.Visibility
     * @see #setVisibility(Visibility)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateInterface_Visibility()
     * @model unique="false"
     * @generated
     */
    Visibility getVisibility();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateInterface#getVisibility <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Visibility</em>' attribute.
     * @see de.fhdo.ddmm.service.Visibility
     * @see #getVisibility()
     * @generated
     */
    void setVisibility(Visibility value);

    /**
     * Returns the value of the '<em><b>Not Implemented</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Not Implemented</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Not Implemented</em>' attribute.
     * @see #setNotImplemented(boolean)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateInterface_NotImplemented()
     * @model unique="false"
     * @generated
     */
    boolean isNotImplemented();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateInterface#isNotImplemented <em>Not Implemented</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Not Implemented</em>' attribute.
     * @see #isNotImplemented()
     * @generated
     */
    void setNotImplemented(boolean value);

    /**
     * Returns the value of the '<em><b>Has Implemented Operations</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Has Implemented Operations</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Has Implemented Operations</em>' attribute.
     * @see #setHasImplementedOperations(boolean)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateInterface_HasImplementedOperations()
     * @model unique="false"
     * @generated
     */
    boolean isHasImplementedOperations();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateInterface#isHasImplementedOperations <em>Has Implemented Operations</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Has Implemented Operations</em>' attribute.
     * @see #isHasImplementedOperations()
     * @generated
     */
    void setHasImplementedOperations(boolean value);

    /**
     * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.intermediate.IntermediateEndpoint}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateEndpoint#getInterface <em>Interface</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoints</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoints</em>' containment reference list.
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateInterface_Endpoints()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateEndpoint#getInterface
     * @model opposite="interface" containment="true"
     * @generated
     */
    EList<IntermediateEndpoint> getEndpoints();

    /**
     * Returns the value of the '<em><b>Protocols</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.intermediate.IntermediateProtocolSpecification}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Protocols</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocols</em>' containment reference list.
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateInterface_Protocols()
     * @model containment="true" upper="2"
     * @generated
     */
    EList<IntermediateProtocolSpecification> getProtocols();

    /**
     * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.intermediate.IntermediateOperation}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateOperation#getInterface <em>Interface</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operations</em>' containment reference list.
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateInterface_Operations()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateOperation#getInterface
     * @model opposite="interface" containment="true"
     * @generated
     */
    EList<IntermediateOperation> getOperations();

    /**
     * Returns the value of the '<em><b>Referred Operations</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.intermediate.IntermediateReferredOperation}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateReferredOperation#getReferringInterface <em>Referring Interface</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Referred Operations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Referred Operations</em>' containment reference list.
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateInterface_ReferredOperations()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateReferredOperation#getReferringInterface
     * @model opposite="referringInterface" containment="true"
     * @generated
     */
    EList<IntermediateReferredOperation> getReferredOperations();

    /**
     * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.data.intermediate.IntermediateImportedAspect}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateInterface_Aspects()
     * @model containment="true"
     * @generated
     */
    EList<IntermediateImportedAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Microservice</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateMicroservice#getInterfaces <em>Interfaces</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Microservice</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Microservice</em>' container reference.
     * @see #setMicroservice(IntermediateMicroservice)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateInterface_Microservice()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateMicroservice#getInterfaces
     * @model opposite="interfaces" transient="false"
     * @generated
     */
    IntermediateMicroservice getMicroservice();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateInterface#getMicroservice <em>Microservice</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Microservice</em>' container reference.
     * @see #getMicroservice()
     * @generated
     */
    void setMicroservice(IntermediateMicroservice value);

} // IntermediateInterface
