/**
 */
package de.fhdo.ddmm.technology;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Aspect Pointcut Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A selector of pointcuts for join points
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.OperationAspectPointcutSelector#getPointcuts <em>Pointcuts</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.OperationAspectPointcutSelector#getOperationAspect <em>Operation Aspect</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.OperationAspectPointcutSelector#getSelectorString <em>Selector String</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.TechnologyPackage#getOperationAspectPointcutSelector()
 * @model
 * @generated
 */
public interface OperationAspectPointcutSelector extends EObject {
    /**
     * Returns the value of the '<em><b>Pointcuts</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.OperationAspectPointcut}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.OperationAspectPointcut#getSelector <em>Selector</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Per pointcut type only one pointcut may be specified in a selector.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Pointcuts</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getOperationAspectPointcutSelector_Pointcuts()
     * @see de.fhdo.ddmm.technology.OperationAspectPointcut#getSelector
     * @model opposite="selector" containment="true" required="true"
     * @generated
     */
    EList<OperationAspectPointcut> getPointcuts();

    /**
     * Returns the value of the '<em><b>Operation Aspect</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.OperationAspect#getPointcutSelectors <em>Pointcut Selectors</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation Aspect</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation Aspect</em>' container reference.
     * @see #setOperationAspect(OperationAspect)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getOperationAspectPointcutSelector_OperationAspect()
     * @see de.fhdo.ddmm.technology.OperationAspect#getPointcutSelectors
     * @model opposite="pointcutSelectors" transient="false"
     * @generated
     */
    OperationAspect getOperationAspect();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.OperationAspectPointcutSelector#getOperationAspect <em>Operation Aspect</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation Aspect</em>' container reference.
     * @see #getOperationAspect()
     * @generated
     */
    void setOperationAspect(OperationAspect value);

    /**
     * Returns the value of the '<em><b>Selector String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Return the selector string of this pointcut based on the DSL's grammar
     * <!-- end-model-doc -->
     * @return the value of the '<em>Selector String</em>' attribute.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getOperationAspectPointcutSelector_SelectorString()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    String getSelectorString();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Check if the selector is more generic than the given selector. A selector is more generic
     * than another selector if it lacks certain pointcuts and overlapping pointcuts have the same
     * values in both selector. Take for instance the selector
     *      selector(protocol = rest, data_format = xml)
     * It is more generic than the selector
     *      selector(exchange_pattern = in, protocol = rest, data_format = xml)
     * but less generic than
     *      selector(protocol = rest)
     * <!-- end-model-doc -->
     * @model unique="false" otherSelectorUnique="false"
     * @generated
     */
    boolean isMoreGenericThan(OperationAspectPointcutSelector otherSelector);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Return values of the selector's pointcuts ordered by their types. The return type is a map
     * that preserves the insertion order and assigns a pointcut type to a list of values specified
     * for it in the selector. The ordering of the types matches the ordering as returned by
     * OperationAspectPointcut.orderedPointcutTypes.
     * <!-- end-model-doc -->
     * @model dataType="de.fhdo.ddmm.technology.PointcutTypeStringsMap" unique="false"
     * @generated
     */
    Map<PointcutType, List<String>> orderedSelectorValues();

} // OperationAspectPointcutSelector
