/**
 */
package de.fhdo.lemma.technology;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Aspect Pointcut</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Pointcut of an operation aspect
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.OperationAspectPointcut#isForTechnology <em>For Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.OperationAspectPointcut#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.OperationAspectPointcut#getSelector <em>Selector</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.OperationAspectPointcut#getEffectiveType <em>Effective Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.OperationAspectPointcut#getEffectiveSelectorName <em>Effective Selector Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.OperationAspectPointcut#getEffectiveValue <em>Effective Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.OperationAspectPointcut#getPrintableEffectiveValue <em>Printable Effective Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.OperationAspectPointcut#getOrderedPointcutTypes <em>Ordered Pointcut Types</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.TechnologyPackage#getOperationAspectPointcut()
 * @model
 * @generated
 */
public interface OperationAspectPointcut extends EObject {
    /**
     * Returns the value of the '<em><b>For Technology</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>For Technology</em>' attribute.
     * @see #setForTechnology(boolean)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getOperationAspectPointcut_ForTechnology()
     * @model unique="false"
     * @generated
     */
    boolean isForTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.OperationAspectPointcut#isForTechnology <em>For Technology</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>For Technology</em>' attribute.
     * @see #isForTechnology()
     * @generated
     */
    void setForTechnology(boolean value);

    /**
     * Returns the value of the '<em><b>Technology</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technology</em>' reference.
     * @see #setTechnology(EObject)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getOperationAspectPointcut_Technology()
     * @model
     * @generated
     */
    EObject getTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.OperationAspectPointcut#getTechnology <em>Technology</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Technology</em>' reference.
     * @see #getTechnology()
     * @generated
     */
    void setTechnology(EObject value);

    /**
     * Returns the value of the '<em><b>Selector</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.OperationAspectPointcutSelector#getPointcuts <em>Pointcuts</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Selector</em>' container reference.
     * @see #setSelector(OperationAspectPointcutSelector)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getOperationAspectPointcut_Selector()
     * @see de.fhdo.lemma.technology.OperationAspectPointcutSelector#getPointcuts
     * @model opposite="pointcuts" transient="false"
     * @generated
     */
    OperationAspectPointcutSelector getSelector();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.OperationAspectPointcut#getSelector <em>Selector</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Selector</em>' container reference.
     * @see #getSelector()
     * @generated
     */
    void setSelector(OperationAspectPointcutSelector value);

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
     * @see de.fhdo.lemma.technology.TechnologyPackage#getOperationAspectPointcut_EffectiveType()
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
     * @see de.fhdo.lemma.technology.TechnologyPackage#getOperationAspectPointcut_EffectiveSelectorName()
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
     * @see de.fhdo.lemma.technology.TechnologyPackage#getOperationAspectPointcut_EffectiveValue()
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
     * @see de.fhdo.lemma.technology.TechnologyPackage#getOperationAspectPointcut_PrintableEffectiveValue()
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
     * @see de.fhdo.lemma.technology.TechnologyPackage#getOperationAspectPointcut_OrderedPointcutTypes()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    EList<PointcutType> getOrderedPointcutTypes();

} // OperationAspectPointcut
