/**
 */
package de.fhdo.lemma.technology;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aspect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Abstract superclass for technology aspects
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.TechnologyAspect#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.TechnologyAspect#getFeatures <em>Features</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.TechnologyAspect#getJoinPoints <em>Join Points</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.TechnologyAspect#getProperties <em>Properties</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.TechnologyAspect#isIsSingleValued <em>Is Single Valued</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologyAspect()
 * @model abstract="true"
 * @generated
 */
public interface TechnologyAspect extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Join points must be unique.
     *          Ensured by: DSL validator.
     *     (C2) Properties must be unique.
     *          Ensured by: DSL validator.
     *     (C3) A feature may only be assigned once.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologyAspect_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.TechnologyAspect#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Features</b></em>' attribute list.
     * The list contents are of type {@link de.fhdo.lemma.technology.AspectFeature}.
     * The literals are from the enumeration {@link de.fhdo.lemma.technology.AspectFeature}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Features</em>' attribute list.
     * @see de.fhdo.lemma.technology.AspectFeature
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologyAspect_Features()
     * @model unique="false"
     * @generated
     */
    EList<AspectFeature> getFeatures();

    /**
     * Returns the value of the '<em><b>Join Points</b></em>' attribute list.
     * The list contents are of type {@link de.fhdo.lemma.technology.JoinPointType}.
     * The literals are from the enumeration {@link de.fhdo.lemma.technology.JoinPointType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Join Points</em>' attribute list.
     * @see de.fhdo.lemma.technology.JoinPointType
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologyAspect_JoinPoints()
     * @model unique="false" required="true"
     * @generated
     */
    EList<JoinPointType> getJoinPoints();

    /**
     * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.technology.TechnologySpecificProperty}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.TechnologySpecificProperty#getTechnologyAspect <em>Technology Aspect</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Properties</em>' containment reference list.
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologyAspect_Properties()
     * @see de.fhdo.lemma.technology.TechnologySpecificProperty#getTechnologyAspect
     * @model opposite="technologyAspect" containment="true"
     * @generated
     */
    EList<TechnologySpecificProperty> getProperties();

    /**
     * Returns the value of the '<em><b>Is Single Valued</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Convenience getter to determine if the aspect exhibits the "single-valued" feature
     * <!-- end-model-doc -->
     * @return the value of the '<em>Is Single Valued</em>' attribute.
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologyAspect_IsSingleValued()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    boolean isIsSingleValued();

} // TechnologyAspect
