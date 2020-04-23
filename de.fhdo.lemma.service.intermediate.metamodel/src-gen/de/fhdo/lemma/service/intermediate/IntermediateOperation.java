/**
 */
package de.fhdo.lemma.service.intermediate;

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Operation
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#isNotImplemented <em>Not Implemented</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getApiOperationComment <em>Api Operation Comment</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getInterface <em>Interface</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateOperation()
 * @model
 * @generated
 */
public interface IntermediateOperation extends EObject {
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
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateOperation_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getName <em>Name</em>}' attribute.
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
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateOperation_QualifiedName()
     * @model unique="false"
     * @generated
     */
    String getQualifiedName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getQualifiedName <em>Qualified Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Qualified Name</em>' attribute.
     * @see #getQualifiedName()
     * @generated
     */
    void setQualifiedName(String value);

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
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateOperation_Visibility()
     * @model unique="false"
     * @generated
     */
    String getVisibility();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getVisibility <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Visibility</em>' attribute.
     * @see #getVisibility()
     * @generated
     */
    void setVisibility(String value);

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
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateOperation_NotImplemented()
     * @model unique="false"
     * @generated
     */
    boolean isNotImplemented();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#isNotImplemented <em>Not Implemented</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Not Implemented</em>' attribute.
     * @see #isNotImplemented()
     * @generated
     */
    void setNotImplemented(boolean value);

    /**
     * Returns the value of the '<em><b>Api Operation Comment</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateApiOperationComment#getOperation <em>Operation</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Api Operation Comment</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Api Operation Comment</em>' containment reference.
     * @see #setApiOperationComment(IntermediateApiOperationComment)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateOperation_ApiOperationComment()
     * @see de.fhdo.lemma.service.intermediate.IntermediateApiOperationComment#getOperation
     * @model opposite="operation" containment="true"
     * @generated
     */
    IntermediateApiOperationComment getApiOperationComment();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getApiOperationComment <em>Api Operation Comment</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Api Operation Comment</em>' containment reference.
     * @see #getApiOperationComment()
     * @generated
     */
    void setApiOperationComment(IntermediateApiOperationComment value);

    /**
     * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getOperation <em>Operation</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoints</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoints</em>' containment reference list.
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateOperation_Endpoints()
     * @see de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getOperation
     * @model opposite="operation" containment="true"
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
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateOperation_Protocols()
     * @model containment="true" upper="2"
     * @generated
     */
    EList<IntermediateProtocolSpecification> getProtocols();

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
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateOperation_Aspects()
     * @model containment="true"
     * @generated
     */
    EList<IntermediateImportedAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.service.intermediate.IntermediateParameter}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getOperation <em>Operation</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameters</em>' containment reference list.
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateOperation_Parameters()
     * @see de.fhdo.lemma.service.intermediate.IntermediateParameter#getOperation
     * @model opposite="operation" containment="true"
     * @generated
     */
    EList<IntermediateParameter> getParameters();

    /**
     * Returns the value of the '<em><b>Interface</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateInterface#getOperations <em>Operations</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Interface</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Interface</em>' container reference.
     * @see #setInterface(IntermediateInterface)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateOperation_Interface()
     * @see de.fhdo.lemma.service.intermediate.IntermediateInterface#getOperations
     * @model opposite="operations" transient="false"
     * @generated
     */
    IntermediateInterface getInterface();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getInterface <em>Interface</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Interface</em>' container reference.
     * @see #getInterface()
     * @generated
     */
    void setInterface(IntermediateInterface value);

} // IntermediateOperation
