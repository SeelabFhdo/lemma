/**
 */
package de.fhdo.ddmm.service.intermediate;

import de.fhdo.ddmm.data.intermediate.IntermediateType;

import de.fhdo.ddmm.technology.CommunicationType;
import de.fhdo.ddmm.technology.ExchangePattern;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Parameter
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#getExchangePattern <em>Exchange Pattern</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#isCommunicatesFault <em>Communicates Fault</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#isOptional <em>Optional</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#getInitializedByOperation <em>Initialized By Operation</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#getMappedDataFields <em>Mapped Data Fields</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateParameter()
 * @model
 * @generated
 */
public interface IntermediateParameter extends EObject {
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
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateParameter_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#getName <em>Name</em>}' attribute.
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
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateParameter_QualifiedName()
     * @model unique="false"
     * @generated
     */
    String getQualifiedName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#getQualifiedName <em>Qualified Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Qualified Name</em>' attribute.
     * @see #getQualifiedName()
     * @generated
     */
    void setQualifiedName(String value);

    /**
     * Returns the value of the '<em><b>Exchange Pattern</b></em>' attribute.
     * The literals are from the enumeration {@link de.fhdo.ddmm.technology.ExchangePattern}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Exchange Pattern</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Exchange Pattern</em>' attribute.
     * @see de.fhdo.ddmm.technology.ExchangePattern
     * @see #setExchangePattern(ExchangePattern)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateParameter_ExchangePattern()
     * @model unique="false"
     * @generated
     */
    ExchangePattern getExchangePattern();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#getExchangePattern <em>Exchange Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Exchange Pattern</em>' attribute.
     * @see de.fhdo.ddmm.technology.ExchangePattern
     * @see #getExchangePattern()
     * @generated
     */
    void setExchangePattern(ExchangePattern value);

    /**
     * Returns the value of the '<em><b>Communication Type</b></em>' attribute.
     * The literals are from the enumeration {@link de.fhdo.ddmm.technology.CommunicationType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Communication Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Communication Type</em>' attribute.
     * @see de.fhdo.ddmm.technology.CommunicationType
     * @see #setCommunicationType(CommunicationType)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateParameter_CommunicationType()
     * @model unique="false"
     * @generated
     */
    CommunicationType getCommunicationType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#getCommunicationType <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Communication Type</em>' attribute.
     * @see de.fhdo.ddmm.technology.CommunicationType
     * @see #getCommunicationType()
     * @generated
     */
    void setCommunicationType(CommunicationType value);

    /**
     * Returns the value of the '<em><b>Communicates Fault</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Communicates Fault</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Communicates Fault</em>' attribute.
     * @see #setCommunicatesFault(boolean)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateParameter_CommunicatesFault()
     * @model unique="false"
     * @generated
     */
    boolean isCommunicatesFault();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#isCommunicatesFault <em>Communicates Fault</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Communicates Fault</em>' attribute.
     * @see #isCommunicatesFault()
     * @generated
     */
    void setCommunicatesFault(boolean value);

    /**
     * Returns the value of the '<em><b>Optional</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Optional</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Optional</em>' attribute.
     * @see #setOptional(boolean)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateParameter_Optional()
     * @model unique="false"
     * @generated
     */
    boolean isOptional();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#isOptional <em>Optional</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Optional</em>' attribute.
     * @see #isOptional()
     * @generated
     */
    void setOptional(boolean value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' containment reference.
     * @see #setType(IntermediateType)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateParameter_Type()
     * @model containment="true"
     * @generated
     */
    IntermediateType getType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#getType <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' containment reference.
     * @see #getType()
     * @generated
     */
    void setType(IntermediateType value);

    /**
     * Returns the value of the '<em><b>Initialized By Operation</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.OperationReference#getInitializedParameter <em>Initialized Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Initialized By Operation</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Initialized By Operation</em>' containment reference.
     * @see #setInitializedByOperation(OperationReference)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateParameter_InitializedByOperation()
     * @see de.fhdo.ddmm.service.intermediate.OperationReference#getInitializedParameter
     * @model opposite="initializedParameter" containment="true"
     * @generated
     */
    OperationReference getInitializedByOperation();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#getInitializedByOperation <em>Initialized By Operation</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Initialized By Operation</em>' containment reference.
     * @see #getInitializedByOperation()
     * @generated
     */
    void setInitializedByOperation(OperationReference value);

    /**
     * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getParameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateParameter_Aspects()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getParameter
     * @model opposite="parameter" containment="true"
     * @generated
     */
    EList<IntermediateImportedAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Mapped Data Fields</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.intermediate.IntermediateMappedDataField}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedDataField#getParameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mapped Data Fields</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mapped Data Fields</em>' containment reference list.
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateParameter_MappedDataFields()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateMappedDataField#getParameter
     * @model opposite="parameter" containment="true"
     * @generated
     */
    EList<IntermediateMappedDataField> getMappedDataFields();

    /**
     * Returns the value of the '<em><b>Operation</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateOperation#getParameters <em>Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation</em>' container reference.
     * @see #setOperation(IntermediateOperation)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateParameter_Operation()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateOperation#getParameters
     * @model opposite="parameters" transient="false"
     * @generated
     */
    IntermediateOperation getOperation();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#getOperation <em>Operation</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation</em>' container reference.
     * @see #getOperation()
     * @generated
     */
    void setOperation(IntermediateOperation value);

} // IntermediateParameter
