/**
 */
package de.fhdo.lemma.technology;

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
 *   <li>{@link de.fhdo.lemma.technology.OperationAspectPointcutSelector#getPointcuts <em>Pointcuts</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.OperationAspectPointcutSelector#getOperationAspect <em>Operation Aspect</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.OperationAspectPointcutSelector#getSelectorString <em>Selector String</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.TechnologyPackage#getOperationAspectPointcutSelector()
 * @model
 * @generated
 */
public interface OperationAspectPointcutSelector extends EObject {
    /**
     * Returns the value of the '<em><b>Pointcuts</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.technology.OperationAspectPointcut}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.OperationAspectPointcut#getSelector <em>Selector</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Per pointcut type only one pointcut may be specified in a selector.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Pointcuts</em>' containment reference list.
     * @see de.fhdo.lemma.technology.TechnologyPackage#getOperationAspectPointcutSelector_Pointcuts()
     * @see de.fhdo.lemma.technology.OperationAspectPointcut#getSelector
     * @model opposite="selector" containment="true" required="true"
     * @generated
     */
    EList<OperationAspectPointcut> getPointcuts();

    /**
     * Returns the value of the '<em><b>Operation Aspect</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.OperationAspect#getPointcutSelectors <em>Pointcut Selectors</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation Aspect</em>' container reference.
     * @see #setOperationAspect(OperationAspect)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getOperationAspectPointcutSelector_OperationAspect()
     * @see de.fhdo.lemma.technology.OperationAspect#getPointcutSelectors
     * @model opposite="pointcutSelectors" transient="false"
     * @generated
     */
    OperationAspect getOperationAspect();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.OperationAspectPointcutSelector#getOperationAspect <em>Operation Aspect</em>}' container reference.
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
     * @see de.fhdo.lemma.technology.TechnologyPackage#getOperationAspectPointcutSelector_SelectorString()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    String getSelectorString();

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
     * @model dataType="de.fhdo.lemma.technology.PointcutTypeStringsMap" unique="false"
     * @generated
     */
    Map<PointcutType, List<String>> orderedSelectorValues();

} // OperationAspectPointcutSelector
