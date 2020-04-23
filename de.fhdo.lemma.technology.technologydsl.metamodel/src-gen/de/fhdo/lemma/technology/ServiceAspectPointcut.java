/**
 */
package de.fhdo.lemma.technology;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Aspect Pointcut</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Pointcut of a service aspect
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.ServiceAspectPointcut#isForExchangePattern <em>For Exchange Pattern</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.ServiceAspectPointcut#isForCommunicationType <em>For Communication Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.ServiceAspectPointcut#isForProtocol <em>For Protocol</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.ServiceAspectPointcut#isForDataFormat <em>For Data Format</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.ServiceAspectPointcut#getExchangePattern <em>Exchange Pattern</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.ServiceAspectPointcut#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.ServiceAspectPointcut#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.ServiceAspectPointcut#getDataFormat <em>Data Format</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.ServiceAspectPointcut#getSelector <em>Selector</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.ServiceAspectPointcut#getEffectiveType <em>Effective Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.ServiceAspectPointcut#getEffectiveSelectorName <em>Effective Selector Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.ServiceAspectPointcut#getEffectiveValue <em>Effective Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.ServiceAspectPointcut#getPrintableEffectiveValue <em>Printable Effective Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.ServiceAspectPointcut#getOrderedPointcutTypes <em>Ordered Pointcut Types</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.TechnologyPackage#getServiceAspectPointcut()
 * @model
 * @generated
 */
public interface ServiceAspectPointcut extends EObject {
    /**
     * Returns the value of the '<em><b>For Exchange Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Pointcut must be applicable to join point.
     *          Ensured by: DSL validator.
     *     (C2) If communication types were selected, protocols of parent selector must be of those
     *          types.
     *          Ensured by: DSL scope provider.
     *     (C3) If protocols were selected, data formats of parent selector must correspond to them.
     *          Ensured by: DSL scope provider.
     * <!-- end-model-doc -->
     * @return the value of the '<em>For Exchange Pattern</em>' attribute.
     * @see #setForExchangePattern(boolean)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getServiceAspectPointcut_ForExchangePattern()
     * @model unique="false"
     * @generated
     */
    boolean isForExchangePattern();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.ServiceAspectPointcut#isForExchangePattern <em>For Exchange Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>For Exchange Pattern</em>' attribute.
     * @see #isForExchangePattern()
     * @generated
     */
    void setForExchangePattern(boolean value);

    /**
     * Returns the value of the '<em><b>For Communication Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>For Communication Type</em>' attribute.
     * @see #setForCommunicationType(boolean)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getServiceAspectPointcut_ForCommunicationType()
     * @model unique="false"
     * @generated
     */
    boolean isForCommunicationType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.ServiceAspectPointcut#isForCommunicationType <em>For Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>For Communication Type</em>' attribute.
     * @see #isForCommunicationType()
     * @generated
     */
    void setForCommunicationType(boolean value);

    /**
     * Returns the value of the '<em><b>For Protocol</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>For Protocol</em>' attribute.
     * @see #setForProtocol(boolean)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getServiceAspectPointcut_ForProtocol()
     * @model unique="false"
     * @generated
     */
    boolean isForProtocol();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.ServiceAspectPointcut#isForProtocol <em>For Protocol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>For Protocol</em>' attribute.
     * @see #isForProtocol()
     * @generated
     */
    void setForProtocol(boolean value);

    /**
     * Returns the value of the '<em><b>For Data Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>For Data Format</em>' attribute.
     * @see #setForDataFormat(boolean)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getServiceAspectPointcut_ForDataFormat()
     * @model unique="false"
     * @generated
     */
    boolean isForDataFormat();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.ServiceAspectPointcut#isForDataFormat <em>For Data Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>For Data Format</em>' attribute.
     * @see #isForDataFormat()
     * @generated
     */
    void setForDataFormat(boolean value);

    /**
     * Returns the value of the '<em><b>Exchange Pattern</b></em>' attribute.
     * The literals are from the enumeration {@link de.fhdo.lemma.technology.ExchangePattern}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Exchange Pattern</em>' attribute.
     * @see de.fhdo.lemma.technology.ExchangePattern
     * @see #setExchangePattern(ExchangePattern)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getServiceAspectPointcut_ExchangePattern()
     * @model unique="false"
     * @generated
     */
    ExchangePattern getExchangePattern();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.ServiceAspectPointcut#getExchangePattern <em>Exchange Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Exchange Pattern</em>' attribute.
     * @see de.fhdo.lemma.technology.ExchangePattern
     * @see #getExchangePattern()
     * @generated
     */
    void setExchangePattern(ExchangePattern value);

    /**
     * Returns the value of the '<em><b>Communication Type</b></em>' attribute.
     * The literals are from the enumeration {@link de.fhdo.lemma.technology.CommunicationType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Communication Type</em>' attribute.
     * @see de.fhdo.lemma.technology.CommunicationType
     * @see #setCommunicationType(CommunicationType)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getServiceAspectPointcut_CommunicationType()
     * @model unique="false"
     * @generated
     */
    CommunicationType getCommunicationType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.ServiceAspectPointcut#getCommunicationType <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Communication Type</em>' attribute.
     * @see de.fhdo.lemma.technology.CommunicationType
     * @see #getCommunicationType()
     * @generated
     */
    void setCommunicationType(CommunicationType value);

    /**
     * Returns the value of the '<em><b>Protocol</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocol</em>' reference.
     * @see #setProtocol(Protocol)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getServiceAspectPointcut_Protocol()
     * @model
     * @generated
     */
    Protocol getProtocol();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.ServiceAspectPointcut#getProtocol <em>Protocol</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Protocol</em>' reference.
     * @see #getProtocol()
     * @generated
     */
    void setProtocol(Protocol value);

    /**
     * Returns the value of the '<em><b>Data Format</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Format</em>' reference.
     * @see #setDataFormat(DataFormat)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getServiceAspectPointcut_DataFormat()
     * @model
     * @generated
     */
    DataFormat getDataFormat();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.ServiceAspectPointcut#getDataFormat <em>Data Format</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Format</em>' reference.
     * @see #getDataFormat()
     * @generated
     */
    void setDataFormat(DataFormat value);

    /**
     * Returns the value of the '<em><b>Selector</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.ServiceAspectPointcutSelector#getPointcuts <em>Pointcuts</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Selector</em>' container reference.
     * @see #setSelector(ServiceAspectPointcutSelector)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getServiceAspectPointcut_Selector()
     * @see de.fhdo.lemma.technology.ServiceAspectPointcutSelector#getPointcuts
     * @model opposite="pointcuts" transient="false"
     * @generated
     */
    ServiceAspectPointcutSelector getSelector();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.ServiceAspectPointcut#getSelector <em>Selector</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Selector</em>' container reference.
     * @see #getSelector()
     * @generated
     */
    void setSelector(ServiceAspectPointcutSelector value);

    /**
     * Returns the value of the '<em><b>Effective Type</b></em>' attribute.
     * The literals are from the enumeration {@link de.fhdo.lemma.technology.PointcutType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Convenience method to get type of pointcut depending on the boolean flags that actually
     * determine its semantics
     * <!-- end-model-doc -->
     * @return the value of the '<em>Effective Type</em>' attribute.
     * @see de.fhdo.lemma.technology.PointcutType
     * @see de.fhdo.lemma.technology.TechnologyPackage#getServiceAspectPointcut_EffectiveType()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    PointcutType getEffectiveType();

    /**
     * Returns the value of the '<em><b>Effective Selector Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get selector name of pointcut depending on its type. It must match the one declared in the
     * grammar of the DSL
     * <!-- end-model-doc -->
     * @return the value of the '<em>Effective Selector Name</em>' attribute.
     * @see de.fhdo.lemma.technology.TechnologyPackage#getServiceAspectPointcut_EffectiveSelectorName()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    String getEffectiveSelectorName();

    /**
     * Returns the value of the '<em><b>Effective Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get effective value of pointcut depending on its type
     * <!-- end-model-doc -->
     * @return the value of the '<em>Effective Value</em>' attribute.
     * @see de.fhdo.lemma.technology.TechnologyPackage#getServiceAspectPointcut_EffectiveValue()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    String getEffectiveValue();

    /**
     * Returns the value of the '<em><b>Printable Effective Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Return printable effective value of pointcut as it would occur in the grammar of the DSL
     * <!-- end-model-doc -->
     * @return the value of the '<em>Printable Effective Value</em>' attribute.
     * @see de.fhdo.lemma.technology.TechnologyPackage#getServiceAspectPointcut_PrintableEffectiveValue()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    String getPrintableEffectiveValue();

    /**
     * Returns the value of the '<em><b>Ordered Pointcut Types</b></em>' attribute list.
     * The list contents are of type {@link de.fhdo.lemma.technology.PointcutType}.
     * The literals are from the enumeration {@link de.fhdo.lemma.technology.PointcutType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get all possible types of pointcuts in an ordered manner
     * <!-- end-model-doc -->
     * @return the value of the '<em>Ordered Pointcut Types</em>' attribute list.
     * @see de.fhdo.lemma.technology.PointcutType
     * @see de.fhdo.lemma.technology.TechnologyPackage#getServiceAspectPointcut_OrderedPointcutTypes()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    EList<PointcutType> getOrderedPointcutTypes();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Convenience method to check if pointcut is applicable at a given join point
     * <!-- end-model-doc -->
     * @model unique="false" joinPointUnique="false"
     * @generated
     */
    boolean isValidSelectorFor(JoinPointType joinPoint);

} // ServiceAspectPointcut
