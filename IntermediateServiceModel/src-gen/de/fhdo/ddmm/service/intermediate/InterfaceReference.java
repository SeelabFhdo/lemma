/**
 */
package de.fhdo.ddmm.service.intermediate;

import de.fhdo.ddmm.data.intermediate.IntermediateImport;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Reference to an interface required by a microservice
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.InterfaceReference#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.InterfaceReference#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.InterfaceReference#isImported <em>Imported</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.InterfaceReference#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.InterfaceReference#getLocalInterface <em>Local Interface</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.InterfaceReference#getRequiringMicroservice <em>Requiring Microservice</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getInterfaceReference()
 * @model
 * @generated
 */
public interface InterfaceReference extends EObject {
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
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getInterfaceReference_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.InterfaceReference#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Qualified Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Qualified Name</em>' attribute.
     * @see #setQualifiedName(String)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getInterfaceReference_QualifiedName()
     * @model unique="false"
     * @generated
     */
    String getQualifiedName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.InterfaceReference#getQualifiedName <em>Qualified Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Qualified Name</em>' attribute.
     * @see #getQualifiedName()
     * @generated
     */
    void setQualifiedName(String value);

    /**
     * Returns the value of the '<em><b>Imported</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Imported</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Imported</em>' attribute.
     * @see #setImported(boolean)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getInterfaceReference_Imported()
     * @model default="false" unique="false"
     * @generated
     */
    boolean isImported();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.InterfaceReference#isImported <em>Imported</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Imported</em>' attribute.
     * @see #isImported()
     * @generated
     */
    void setImported(boolean value);

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
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getInterfaceReference_Import()
     * @model
     * @generated
     */
    IntermediateImport getImport();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.InterfaceReference#getImport <em>Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Import</em>' reference.
     * @see #getImport()
     * @generated
     */
    void setImport(IntermediateImport value);

    /**
     * Returns the value of the '<em><b>Local Interface</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Local Interface</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Local Interface</em>' reference.
     * @see #setLocalInterface(IntermediateInterface)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getInterfaceReference_LocalInterface()
     * @model
     * @generated
     */
    IntermediateInterface getLocalInterface();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.InterfaceReference#getLocalInterface <em>Local Interface</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Local Interface</em>' reference.
     * @see #getLocalInterface()
     * @generated
     */
    void setLocalInterface(IntermediateInterface value);

    /**
     * Returns the value of the '<em><b>Requiring Microservice</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.intermediate.IntermediateMicroservice#getRequiredInterfaces <em>Required Interfaces</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Requiring Microservice</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Requiring Microservice</em>' container reference.
     * @see #setRequiringMicroservice(IntermediateMicroservice)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getInterfaceReference_RequiringMicroservice()
     * @see de.fhdo.ddmm.service.intermediate.IntermediateMicroservice#getRequiredInterfaces
     * @model opposite="requiredInterfaces" transient="false"
     * @generated
     */
    IntermediateMicroservice getRequiringMicroservice();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.InterfaceReference#getRequiringMicroservice <em>Requiring Microservice</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Requiring Microservice</em>' container reference.
     * @see #getRequiringMicroservice()
     * @generated
     */
    void setRequiringMicroservice(IntermediateMicroservice value);

} // InterfaceReference
