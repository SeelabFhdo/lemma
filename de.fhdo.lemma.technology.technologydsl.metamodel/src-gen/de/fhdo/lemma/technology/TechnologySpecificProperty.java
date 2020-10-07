/**
 */
package de.fhdo.lemma.technology;

import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.data.PrimitiveValue;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specific Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A property, e.g., of an operation technology that may be set per associated service or an aspect
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.TechnologySpecificProperty#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.TechnologySpecificProperty#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.TechnologySpecificProperty#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.TechnologySpecificProperty#getFeatures <em>Features</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.TechnologySpecificProperty#getOperationTechnology <em>Operation Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.TechnologySpecificProperty#getTechnologyAspect <em>Technology Aspect</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.TechnologySpecificProperty#isIsMandatory <em>Is Mandatory</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologySpecificProperty()
 * @model
 * @generated
 */
public interface TechnologySpecificProperty extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) A property with the "mandatory" feature may not have a default value.
     *          Ensured by: DSL grammar.
     *     (C2) The assigned default value must be compatible with the poperty's type.
     *          Ensured by: DSL validator.
     *     (C3) Name must be unique.
     *          Ensured by: DSL validator.
     *     (C4) A feature may only be assigned once.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologySpecificProperty_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.TechnologySpecificProperty#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' containment reference.
     * @see #setType(PrimitiveType)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologySpecificProperty_Type()
     * @model containment="true"
     * @generated
     */
    PrimitiveType getType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.TechnologySpecificProperty#getType <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' containment reference.
     * @see #getType()
     * @generated
     */
    void setType(PrimitiveType value);

    /**
     * Returns the value of the '<em><b>Default Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Value</em>' containment reference.
     * @see #setDefaultValue(PrimitiveValue)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologySpecificProperty_DefaultValue()
     * @model containment="true"
     * @generated
     */
    PrimitiveValue getDefaultValue();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.TechnologySpecificProperty#getDefaultValue <em>Default Value</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Value</em>' containment reference.
     * @see #getDefaultValue()
     * @generated
     */
    void setDefaultValue(PrimitiveValue value);

    /**
     * Returns the value of the '<em><b>Features</b></em>' attribute list.
     * The list contents are of type {@link de.fhdo.lemma.technology.PropertyFeature}.
     * The literals are from the enumeration {@link de.fhdo.lemma.technology.PropertyFeature}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Features</em>' attribute list.
     * @see de.fhdo.lemma.technology.PropertyFeature
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologySpecificProperty_Features()
     * @model unique="false"
     * @generated
     */
    EList<PropertyFeature> getFeatures();

    /**
     * Returns the value of the '<em><b>Operation Technology</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.OperationTechnology#getServiceProperties <em>Service Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation Technology</em>' container reference.
     * @see #setOperationTechnology(OperationTechnology)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologySpecificProperty_OperationTechnology()
     * @see de.fhdo.lemma.technology.OperationTechnology#getServiceProperties
     * @model opposite="serviceProperties" transient="false"
     * @generated
     */
    OperationTechnology getOperationTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.TechnologySpecificProperty#getOperationTechnology <em>Operation Technology</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation Technology</em>' container reference.
     * @see #getOperationTechnology()
     * @generated
     */
    void setOperationTechnology(OperationTechnology value);

    /**
     * Returns the value of the '<em><b>Technology Aspect</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.TechnologyAspect#getProperties <em>Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technology Aspect</em>' container reference.
     * @see #setTechnologyAspect(TechnologyAspect)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologySpecificProperty_TechnologyAspect()
     * @see de.fhdo.lemma.technology.TechnologyAspect#getProperties
     * @model opposite="properties" transient="false"
     * @generated
     */
    TechnologyAspect getTechnologyAspect();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.TechnologySpecificProperty#getTechnologyAspect <em>Technology Aspect</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Technology Aspect</em>' container reference.
     * @see #getTechnologyAspect()
     * @generated
     */
    void setTechnologyAspect(TechnologyAspect value);

    /**
     * Returns the value of the '<em><b>Is Mandatory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Check if property exhibits the "mandatory" feature
     * <!-- end-model-doc -->
     * @return the value of the '<em>Is Mandatory</em>' attribute.
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologySpecificProperty_IsMandatory()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    boolean isIsMandatory();

} // TechnologySpecificProperty
