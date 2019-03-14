/**
 */
package de.fhdo.ddmm.technology;

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
 *   <li>{@link de.fhdo.ddmm.technology.TechnologyAspect#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.TechnologyAspect#getJoinPoints <em>Join Points</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.TechnologyAspect#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.TechnologyPackage#getTechnologyAspect()
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
     * <!-- end-model-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getTechnologyAspect_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.TechnologyAspect#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Join Points</b></em>' attribute list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.JoinPointType}.
     * The literals are from the enumeration {@link de.fhdo.ddmm.technology.JoinPointType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Join Points</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Join Points</em>' attribute list.
     * @see de.fhdo.ddmm.technology.JoinPointType
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getTechnologyAspect_JoinPoints()
     * @model unique="false" required="true"
     * @generated
     */
    EList<JoinPointType> getJoinPoints();

    /**
     * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.TechnologySpecificProperty}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.TechnologySpecificProperty#getTechnologyAspect <em>Technology Aspect</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Properties</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getTechnologyAspect_Properties()
     * @see de.fhdo.ddmm.technology.TechnologySpecificProperty#getTechnologyAspect
     * @model opposite="technologyAspect" containment="true"
     * @generated
     */
    EList<TechnologySpecificProperty> getProperties();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get parts of the technology aspect for creating a qualified name
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     * @generated
     */
    EList<String> getQualifiedNameParts();

} // TechnologyAspect
