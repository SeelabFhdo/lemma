/**
 */
package de.fhdo.ddmm.service.intermediate;

import de.fhdo.ddmm.data.intermediate.IntermediateImport;

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
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getProperties <em>Properties</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getPropertyValues <em>Property Values</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getInterface <em>Interface</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getReferredOperation <em>Referred Operation</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getParameter <em>Parameter</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getMappedField <em>Mapped Field</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateImportedAspect()
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
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateImportedAspect_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getName <em>Name</em>}' attribute.
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
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateImportedAspect_Import()
     * @model
     * @generated
     */
    IntermediateImport getImport();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getImport <em>Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Import</em>' reference.
     * @see #getImport()
     * @generated
     */
    void setImport(IntermediateImport value);

    /**
     * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.intermediate.IntermediateAspectProperty}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateAspectProperty#getAspect <em>Aspect</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Properties</em>' containment reference list.
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateImportedAspect_Properties()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateAspectProperty#getAspect
     * @model opposite="aspect" containment="true"
     * @generated
     */
    EList<IntermediateAspectProperty> getProperties();

    /**
     * Returns the value of the '<em><b>Property Values</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.intermediate.IntermediateAspectPropertyValue}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateAspectPropertyValue#getAspect <em>Aspect</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Property Values</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Property Values</em>' containment reference list.
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateImportedAspect_PropertyValues()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateAspectPropertyValue#getAspect
     * @model opposite="aspect" containment="true"
     * @generated
     */
    EList<IntermediateAspectPropertyValue> getPropertyValues();

    /**
     * Returns the value of the '<em><b>Microservice</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateMicroservice#getAspects <em>Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Microservice</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Microservice</em>' container reference.
     * @see #setMicroservice(IntermediateMicroservice)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateImportedAspect_Microservice()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateMicroservice#getAspects
     * @model opposite="aspects" transient="false"
     * @generated
     */
    IntermediateMicroservice getMicroservice();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getMicroservice <em>Microservice</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Microservice</em>' container reference.
     * @see #getMicroservice()
     * @generated
     */
    void setMicroservice(IntermediateMicroservice value);

    /**
     * Returns the value of the '<em><b>Interface</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateInterface#getAspects <em>Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Interface</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Interface</em>' container reference.
     * @see #setInterface(IntermediateInterface)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateImportedAspect_Interface()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateInterface#getAspects
     * @model opposite="aspects" transient="false"
     * @generated
     */
    IntermediateInterface getInterface();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getInterface <em>Interface</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Interface</em>' container reference.
     * @see #getInterface()
     * @generated
     */
    void setInterface(IntermediateInterface value);

    /**
     * Returns the value of the '<em><b>Operation</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateOperation#getAspects <em>Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation</em>' container reference.
     * @see #setOperation(IntermediateOperation)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateImportedAspect_Operation()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateOperation#getAspects
     * @model opposite="aspects" transient="false"
     * @generated
     */
    IntermediateOperation getOperation();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getOperation <em>Operation</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation</em>' container reference.
     * @see #getOperation()
     * @generated
     */
    void setOperation(IntermediateOperation value);

    /**
     * Returns the value of the '<em><b>Referred Operation</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateReferredOperation#getAspects <em>Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Referred Operation</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Referred Operation</em>' container reference.
     * @see #setReferredOperation(IntermediateReferredOperation)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateImportedAspect_ReferredOperation()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateReferredOperation#getAspects
     * @model opposite="aspects" transient="false"
     * @generated
     */
    IntermediateReferredOperation getReferredOperation();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getReferredOperation <em>Referred Operation</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Referred Operation</em>' container reference.
     * @see #getReferredOperation()
     * @generated
     */
    void setReferredOperation(IntermediateReferredOperation value);

    /**
     * Returns the value of the '<em><b>Parameter</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateParameter#getAspects <em>Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameter</em>' container reference.
     * @see #setParameter(IntermediateParameter)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateImportedAspect_Parameter()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateParameter#getAspects
     * @model opposite="aspects" transient="false"
     * @generated
     */
    IntermediateParameter getParameter();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getParameter <em>Parameter</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parameter</em>' container reference.
     * @see #getParameter()
     * @generated
     */
    void setParameter(IntermediateParameter value);

    /**
     * Returns the value of the '<em><b>Mapped Field</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateMappedField#getAspects <em>Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mapped Field</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mapped Field</em>' container reference.
     * @see #setMappedField(IntermediateMappedField)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateImportedAspect_MappedField()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateMappedField#getAspects
     * @model opposite="aspects" transient="false"
     * @generated
     */
    IntermediateMappedField getMappedField();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect#getMappedField <em>Mapped Field</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mapped Field</em>' container reference.
     * @see #getMappedField()
     * @generated
     */
    void setMappedField(IntermediateMappedField value);

} // IntermediateImportedAspect
