/**
 */
package de.fhdo.ddmm.data.intermediate;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aspect Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Aspect property
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.data.intermediate.IntermediateAspectProperty#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.intermediate.IntermediateAspectProperty#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.intermediate.IntermediateAspectProperty#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.intermediate.IntermediateAspectProperty#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.intermediate.IntermediateAspectProperty#getAspect <em>Aspect</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.data.intermediate.IntermediatePackage#getIntermediateAspectProperty()
 * @model
 * @generated
 */
public interface IntermediateAspectProperty extends EObject {
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
     * @see de.fhdo.ddmm.data.intermediate.IntermediatePackage#getIntermediateAspectProperty_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.intermediate.IntermediateAspectProperty#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see #setType(String)
     * @see de.fhdo.ddmm.data.intermediate.IntermediatePackage#getIntermediateAspectProperty_Type()
     * @model unique="false"
     * @generated
     */
    String getType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.intermediate.IntermediateAspectProperty#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see #getType()
     * @generated
     */
    void setType(String value);

    /**
     * Returns the value of the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Value</em>' attribute.
     * @see #setDefaultValue(String)
     * @see de.fhdo.ddmm.data.intermediate.IntermediatePackage#getIntermediateAspectProperty_DefaultValue()
     * @model unique="false"
     * @generated
     */
    String getDefaultValue();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.intermediate.IntermediateAspectProperty#getDefaultValue <em>Default Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Value</em>' attribute.
     * @see #getDefaultValue()
     * @generated
     */
    void setDefaultValue(String value);

    /**
     * Returns the value of the '<em><b>Mandatory</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mandatory</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mandatory</em>' attribute.
     * @see #setMandatory(boolean)
     * @see de.fhdo.ddmm.data.intermediate.IntermediatePackage#getIntermediateAspectProperty_Mandatory()
     * @model default="false" unique="false"
     * @generated
     */
    boolean isMandatory();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.intermediate.IntermediateAspectProperty#isMandatory <em>Mandatory</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mandatory</em>' attribute.
     * @see #isMandatory()
     * @generated
     */
    void setMandatory(boolean value);

    /**
     * Returns the value of the '<em><b>Aspect</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.data.intermediate.IntermediateImportedAspect#getProperties <em>Properties</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspect</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspect</em>' container reference.
     * @see #setAspect(IntermediateImportedAspect)
     * @see de.fhdo.ddmm.data.intermediate.IntermediatePackage#getIntermediateAspectProperty_Aspect()
     * @see de.fhdo.ddmm.data.intermediate.IntermediateImportedAspect#getProperties
     * @model opposite="properties" transient="false"
     * @generated
     */
    IntermediateImportedAspect getAspect();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.intermediate.IntermediateAspectProperty#getAspect <em>Aspect</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Aspect</em>' container reference.
     * @see #getAspect()
     * @generated
     */
    void setAspect(IntermediateImportedAspect value);

} // IntermediateAspectProperty
