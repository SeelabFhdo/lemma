/**
 */
package de.fhdo.lemma.data.intermediate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Imported Aspect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Aspect
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getProperties <em>Properties</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getPropertyValues <em>Property Values</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getComplexType <em>Complex Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getDataField <em>Data Field</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateImportedAspect()
 * @model
 * @generated
 */
public interface IntermediateImportedAspect extends EObject {
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
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateImportedAspect_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Import</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Import</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Import</em>' reference.
     * @see #setImport(IntermediateImport)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateImportedAspect_Import()
     * @model
     * @generated
     */
    IntermediateImport getImport();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getImport <em>Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Import</em>' reference.
     * @see #getImport()
     * @generated
     */
    void setImport(IntermediateImport value);

    /**
     * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateAspectProperty}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getAspect <em>Aspect</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Properties</em>' containment reference list.
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateImportedAspect_Properties()
     * @see de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getAspect
     * @model opposite="aspect" containment="true"
     * @generated
     */
    EList<IntermediateAspectProperty> getProperties();

    /**
     * Returns the value of the '<em><b>Property Values</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue#getAspect <em>Aspect</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Property Values</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Property Values</em>' containment reference list.
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateImportedAspect_PropertyValues()
     * @see de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue#getAspect
     * @model opposite="aspect" containment="true"
     * @generated
     */
    EList<IntermediateAspectPropertyValue> getPropertyValues();

    /**
     * Returns the value of the '<em><b>Complex Type</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateComplexType#getAspects <em>Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Complex Type</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Complex Type</em>' container reference.
     * @see #setComplexType(IntermediateComplexType)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateImportedAspect_ComplexType()
     * @see de.fhdo.lemma.data.intermediate.IntermediateComplexType#getAspects
     * @model opposite="aspects" transient="false"
     * @generated
     */
    IntermediateComplexType getComplexType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getComplexType <em>Complex Type</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Complex Type</em>' container reference.
     * @see #getComplexType()
     * @generated
     */
    void setComplexType(IntermediateComplexType value);

    /**
     * Returns the value of the '<em><b>Data Field</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getAspects <em>Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Field</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Field</em>' container reference.
     * @see #setDataField(IntermediateDataField)
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateImportedAspect_DataField()
     * @see de.fhdo.lemma.data.intermediate.IntermediateDataField#getAspects
     * @model opposite="aspects" transient="false"
     * @generated
     */
    IntermediateDataField getDataField();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getDataField <em>Data Field</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Field</em>' container reference.
     * @see #getDataField()
     * @generated
     */
    void setDataField(IntermediateDataField value);

} // IntermediateImportedAspect
