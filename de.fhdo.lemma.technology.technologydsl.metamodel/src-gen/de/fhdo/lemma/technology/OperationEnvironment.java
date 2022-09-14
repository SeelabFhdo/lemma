/**
 */
package de.fhdo.lemma.technology;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Operation environment of an operation technology, e.g., an image of a deployment container
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.OperationEnvironment#getEnvironmentName <em>Environment Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.OperationEnvironment#isDefault <em>Default</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.OperationEnvironment#getOperationTechnology <em>Operation Technology</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.TechnologyPackage#getOperationEnvironment()
 * @model
 * @generated
 */
public interface OperationEnvironment extends EObject {
    /**
     * Returns the value of the '<em><b>Environment Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Name must be unique.
     *          Ensured by: DSL validator.
     *     (C2) If there is more than one operation environment within an operation technology, than
     *          there must be at least one default environment.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Environment Name</em>' attribute.
     * @see #setEnvironmentName(String)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getOperationEnvironment_EnvironmentName()
     * @model unique="false"
     * @generated
     */
    String getEnvironmentName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.OperationEnvironment#getEnvironmentName <em>Environment Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Environment Name</em>' attribute.
     * @see #getEnvironmentName()
     * @generated
     */
    void setEnvironmentName(String value);

    /**
     * Returns the value of the '<em><b>Default</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default</em>' attribute.
     * @see #setDefault(boolean)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getOperationEnvironment_Default()
     * @model default="false" unique="false"
     * @generated
     */
    boolean isDefault();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.OperationEnvironment#isDefault <em>Default</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default</em>' attribute.
     * @see #isDefault()
     * @generated
     */
    void setDefault(boolean value);

    /**
     * Returns the value of the '<em><b>Operation Technology</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.OperationTechnology#getOperationEnvironments <em>Operation Environments</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation Technology</em>' container reference.
     * @see #setOperationTechnology(OperationTechnology)
     * @see de.fhdo.lemma.technology.TechnologyPackage#getOperationEnvironment_OperationTechnology()
     * @see de.fhdo.lemma.technology.OperationTechnology#getOperationEnvironments
     * @model opposite="operationEnvironments" transient="false"
     * @generated
     */
    OperationTechnology getOperationTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.OperationEnvironment#getOperationTechnology <em>Operation Technology</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation Technology</em>' container reference.
     * @see #getOperationTechnology()
     * @generated
     */
    void setOperationTechnology(OperationTechnology value);

} // OperationEnvironment
