/**
 */
package de.fhdo.ddmm.service;

import de.fhdo.ddmm.data.PrimitiveValue;

import de.fhdo.ddmm.technology.ServiceAspect;
import de.fhdo.ddmm.technology.TechnologySpecificPropertyValueAssignment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Imported Service Aspect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Metamodel concept for service aspects being imported from a technology model
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.ImportedServiceAspect#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.ImportedServiceAspect#getImportedAspect <em>Imported Aspect</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.ImportedServiceAspect#getSinglePropertyValue <em>Single Property Value</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.ImportedServiceAspect#getValues <em>Values</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.ImportedServiceAspect#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.ImportedServiceAspect#getInterface <em>Interface</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.ImportedServiceAspect#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.ImportedServiceAspect#getReferredOperation <em>Referred Operation</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.ImportedServiceAspect#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.ServicePackage#getImportedServiceAspect()
 * @model
 * @generated
 */
public interface ImportedServiceAspect extends EObject {
    /**
     * Returns the value of the '<em><b>Import</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) An aspect may not be assigned twice to a concept instance.
     *          Ensured by: DSL validator.
     *     (C2) A single property value may only be assigned if the aspect has exactly one property.
     *          Ensured by: DSL validator.
     *     (C3) Property values must match the type of the aspect property as defined in the
     *          technology being assigned to the parent microservice mapping.
     *          Ensured by: DSL validator.
     *     (C4) Mandatory properties must have values assigned.
     *          Ensured by: DSL validator.
     *     (C5) Aspect may only be assigned to a concept if all of its selectors match.
     *          Ensured by: DSL scope provider.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Import</em>' reference.
     * @see #setImport(Import)
     * @see de.fhdo.ddmm.service.ServicePackage#getImportedServiceAspect_Import()
     * @model
     * @generated
     */
    Import getImport();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.ImportedServiceAspect#getImport <em>Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Import</em>' reference.
     * @see #getImport()
     * @generated
     */
    void setImport(Import value);

    /**
     * Returns the value of the '<em><b>Imported Aspect</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Imported Aspect</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Imported Aspect</em>' reference.
     * @see #setImportedAspect(ServiceAspect)
     * @see de.fhdo.ddmm.service.ServicePackage#getImportedServiceAspect_ImportedAspect()
     * @model
     * @generated
     */
    ServiceAspect getImportedAspect();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.ImportedServiceAspect#getImportedAspect <em>Imported Aspect</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Imported Aspect</em>' reference.
     * @see #getImportedAspect()
     * @generated
     */
    void setImportedAspect(ServiceAspect value);

    /**
     * Returns the value of the '<em><b>Single Property Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Single Property Value</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Single Property Value</em>' containment reference.
     * @see #setSinglePropertyValue(PrimitiveValue)
     * @see de.fhdo.ddmm.service.ServicePackage#getImportedServiceAspect_SinglePropertyValue()
     * @model containment="true"
     * @generated
     */
    PrimitiveValue getSinglePropertyValue();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.ImportedServiceAspect#getSinglePropertyValue <em>Single Property Value</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Single Property Value</em>' containment reference.
     * @see #getSinglePropertyValue()
     * @generated
     */
    void setSinglePropertyValue(PrimitiveValue value);

    /**
     * Returns the value of the '<em><b>Values</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.TechnologySpecificPropertyValueAssignment}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Values</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getImportedServiceAspect_Values()
     * @model containment="true"
     * @generated
     */
    EList<TechnologySpecificPropertyValueAssignment> getValues();

    /**
     * Returns the value of the '<em><b>Microservice</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Microservice#getAspects <em>Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Microservice</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Microservice</em>' container reference.
     * @see #setMicroservice(Microservice)
     * @see de.fhdo.ddmm.service.ServicePackage#getImportedServiceAspect_Microservice()
     * @see de.fhdo.ddmm.service.Microservice#getAspects
     * @model opposite="aspects" transient="false"
     * @generated
     */
    Microservice getMicroservice();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.ImportedServiceAspect#getMicroservice <em>Microservice</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Microservice</em>' container reference.
     * @see #getMicroservice()
     * @generated
     */
    void setMicroservice(Microservice value);

    /**
     * Returns the value of the '<em><b>Interface</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Interface#getAspects <em>Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Interface</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Interface</em>' container reference.
     * @see #setInterface(Interface)
     * @see de.fhdo.ddmm.service.ServicePackage#getImportedServiceAspect_Interface()
     * @see de.fhdo.ddmm.service.Interface#getAspects
     * @model opposite="aspects" transient="false"
     * @generated
     */
    Interface getInterface();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.ImportedServiceAspect#getInterface <em>Interface</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Interface</em>' container reference.
     * @see #getInterface()
     * @generated
     */
    void setInterface(Interface value);

    /**
     * Returns the value of the '<em><b>Operation</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Operation#getAspects <em>Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation</em>' container reference.
     * @see #setOperation(Operation)
     * @see de.fhdo.ddmm.service.ServicePackage#getImportedServiceAspect_Operation()
     * @see de.fhdo.ddmm.service.Operation#getAspects
     * @model opposite="aspects" transient="false"
     * @generated
     */
    Operation getOperation();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.ImportedServiceAspect#getOperation <em>Operation</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation</em>' container reference.
     * @see #getOperation()
     * @generated
     */
    void setOperation(Operation value);

    /**
     * Returns the value of the '<em><b>Referred Operation</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.ReferredOperation#getAspects <em>Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Referred Operation</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Referred Operation</em>' container reference.
     * @see #setReferredOperation(ReferredOperation)
     * @see de.fhdo.ddmm.service.ServicePackage#getImportedServiceAspect_ReferredOperation()
     * @see de.fhdo.ddmm.service.ReferredOperation#getAspects
     * @model opposite="aspects" transient="false"
     * @generated
     */
    ReferredOperation getReferredOperation();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.ImportedServiceAspect#getReferredOperation <em>Referred Operation</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Referred Operation</em>' container reference.
     * @see #getReferredOperation()
     * @generated
     */
    void setReferredOperation(ReferredOperation value);

    /**
     * Returns the value of the '<em><b>Parameter</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Parameter#getAspects <em>Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameter</em>' container reference.
     * @see #setParameter(Parameter)
     * @see de.fhdo.ddmm.service.ServicePackage#getImportedServiceAspect_Parameter()
     * @see de.fhdo.ddmm.service.Parameter#getAspects
     * @model opposite="aspects" transient="false"
     * @generated
     */
    Parameter getParameter();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.ImportedServiceAspect#getParameter <em>Parameter</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parameter</em>' container reference.
     * @see #getParameter()
     * @generated
     */
    void setParameter(Parameter value);

} // ImportedServiceAspect
