/**
 */
package de.fhdo.ddmm.technology;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Aspect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Metamodel concept for aspects related to microservices and their elements
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspect#getPointcutSelectors <em>Pointcut Selectors</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspect#getTechnology <em>Technology</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspect()
 * @model
 * @generated
 */
public interface ServiceAspect extends TechnologyAspect {
    /**
     * Returns the value of the '<em><b>Pointcut Selectors</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.ServiceAspectPointcutSelector}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.ServiceAspectPointcutSelector#getServiceAspect <em>Service Aspect</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Selectors must be unique.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Pointcut Selectors</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspect_PointcutSelectors()
     * @see de.fhdo.ddmm.technology.ServiceAspectPointcutSelector#getServiceAspect
     * @model opposite="serviceAspect" containment="true"
     * @generated
     */
    EList<ServiceAspectPointcutSelector> getPointcutSelectors();

    /**
     * Returns the value of the '<em><b>Technology</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.Technology#getServiceAspects <em>Service Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Technology</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technology</em>' container reference.
     * @see #setTechnology(Technology)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspect_Technology()
     * @see de.fhdo.ddmm.technology.Technology#getServiceAspects
     * @model opposite="serviceAspects" transient="false"
     * @generated
     */
    Technology getTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.ServiceAspect#getTechnology <em>Technology</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Technology</em>' container reference.
     * @see #getTechnology()
     * @generated
     */
    void setTechnology(Technology value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Check if the aspect has a matching selector for the given pointcuts and their values.
     * Therefore, all pointcut values of a selector must be equal to the given values, i.e., the
     * matching is based on the logical conjunction of all pointcuts ("AND" semantics) as long as
     * their types differ. For pointcuts that receive more than one value in a selector (currently
     * prevented on the language-level by the validator), logical disjunction ("OR" semantics) is
     * applied. The pointcut values themselves are compared with the given values on the basis of
     * identify matching ("equal" semantics).
     * <!-- end-model-doc -->
     * @model unique="false" forExchangePatternUnique="false" forCommunicationTypeUnique="false" forProtocolUnique="false" forDataFormatUnique="false"
     * @generated
     */
    boolean hasMatchingSelector(ExchangePattern forExchangePattern, CommunicationType forCommunicationType, Protocol forProtocol, DataFormat forDataFormat);

} // ServiceAspect
