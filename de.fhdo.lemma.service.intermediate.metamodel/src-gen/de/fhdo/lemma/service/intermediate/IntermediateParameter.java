/**
 */
package de.fhdo.lemma.service.intermediate;

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect;
import de.fhdo.lemma.data.intermediate.IntermediateType;

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
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getExchangePattern <em>Exchange Pattern</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#isCommunicatesFault <em>Communicates Fault</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#isOptional <em>Optional</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getInitializedByOperation <em>Initialized By Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getFieldAspects <em>Field Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateParameter()
 * @model
 * @generated
 */
public interface IntermediateParameter extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateParameter_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getName <em>Name</em>}' attribute.
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
     * <!-- end-user-doc -->
     * @return the value of the '<em>Qualified Name</em>' attribute.
     * @see #setQualifiedName(String)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateParameter_QualifiedName()
     * @model unique="false"
     * @generated
     */
    String getQualifiedName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getQualifiedName <em>Qualified Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Qualified Name</em>' attribute.
     * @see #getQualifiedName()
     * @generated
     */
    void setQualifiedName(String value);

    /**
     * Returns the value of the '<em><b>Exchange Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Exchange Pattern</em>' attribute.
     * @see #setExchangePattern(String)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateParameter_ExchangePattern()
     * @model unique="false"
     * @generated
     */
    String getExchangePattern();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getExchangePattern <em>Exchange Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Exchange Pattern</em>' attribute.
     * @see #getExchangePattern()
     * @generated
     */
    void setExchangePattern(String value);

    /**
     * Returns the value of the '<em><b>Communication Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Communication Type</em>' attribute.
     * @see #setCommunicationType(String)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateParameter_CommunicationType()
     * @model unique="false"
     * @generated
     */
    String getCommunicationType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getCommunicationType <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Communication Type</em>' attribute.
     * @see #getCommunicationType()
     * @generated
     */
    void setCommunicationType(String value);

    /**
     * Returns the value of the '<em><b>Communicates Fault</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Communicates Fault</em>' attribute.
     * @see #setCommunicatesFault(boolean)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateParameter_CommunicatesFault()
     * @model unique="false"
     * @generated
     */
    boolean isCommunicatesFault();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#isCommunicatesFault <em>Communicates Fault</em>}' attribute.
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
     * <!-- end-user-doc -->
     * @return the value of the '<em>Optional</em>' attribute.
     * @see #setOptional(boolean)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateParameter_Optional()
     * @model unique="false"
     * @generated
     */
    boolean isOptional();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#isOptional <em>Optional</em>}' attribute.
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
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' containment reference.
     * @see #setType(IntermediateType)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateParameter_Type()
     * @model containment="true"
     * @generated
     */
    IntermediateType getType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getType <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' containment reference.
     * @see #getType()
     * @generated
     */
    void setType(IntermediateType value);

    /**
     * Returns the value of the '<em><b>Initialized By Operation</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.OperationReference#getInitializedParameter <em>Initialized Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Initialized By Operation</em>' containment reference.
     * @see #setInitializedByOperation(OperationReference)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateParameter_InitializedByOperation()
     * @see de.fhdo.lemma.service.intermediate.OperationReference#getInitializedParameter
     * @model opposite="initializedParameter" containment="true"
     * @generated
     */
    OperationReference getInitializedByOperation();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getInitializedByOperation <em>Initialized By Operation</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Initialized By Operation</em>' containment reference.
     * @see #getInitializedByOperation()
     * @generated
     */
    void setInitializedByOperation(OperationReference value);

    /**
     * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateParameter_Aspects()
     * @model containment="true"
     * @generated
     */
    EList<IntermediateImportedAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Field Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.service.intermediate.DataFieldAspects}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.DataFieldAspects#getParameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Field Aspects</em>' containment reference list.
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateParameter_FieldAspects()
     * @see de.fhdo.lemma.service.intermediate.DataFieldAspects#getParameter
     * @model opposite="parameter" containment="true"
     * @generated
     */
    EList<DataFieldAspects> getFieldAspects();

    /**
     * Returns the value of the '<em><b>Operation</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getParameters <em>Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation</em>' container reference.
     * @see #setOperation(IntermediateOperation)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateParameter_Operation()
     * @see de.fhdo.lemma.service.intermediate.IntermediateOperation#getParameters
     * @model opposite="parameters" transient="false"
     * @generated
     */
    IntermediateOperation getOperation();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getOperation <em>Operation</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation</em>' container reference.
     * @see #getOperation()
     * @generated
     */
    void setOperation(IntermediateOperation value);

} // IntermediateParameter
