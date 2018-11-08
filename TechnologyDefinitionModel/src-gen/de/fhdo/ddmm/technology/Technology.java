/**
 */
package de.fhdo.ddmm.technology;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Technology</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Root model concept, which represents all concept related to a certain technology that maps
 * microservices to technology
 *  * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.Technology#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.Technology#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.Technology#getPrimitiveTypes <em>Primitive Types</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.Technology#getListTypes <em>List Types</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.Technology#getDataStructures <em>Data Structures</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.Technology#getCompatibilityEntries <em>Compatibility Entries</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.Technology#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.Technology#getServiceAspects <em>Service Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.Technology#getDeploymentTechnologies <em>Deployment Technologies</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.Technology#getInfrastructureTechnologies <em>Infrastructure Technologies</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.Technology#getOperationAspects <em>Operation Aspects</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.TechnologyPackage#getTechnology()
 * @model
 * @generated
 */
public interface Technology extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) A technology must define at least one default technology-specific primitive type for
     *          each built-in primitive type. This ensures, that even if there is no mapping of a
     *          built-in primitive type to a technology-specific one, we can deduce a
     *          technology-specific type for it when code gets generated.
     *          Ensured by: DSL validator.
     *     (C2) A technology must define at least one default communication protocol for either type
     *          of communication.
     *          Ensured by: DSL validator.
     *     (C3) Technology models must not be empty.
     *          Ensured by: DSL validator.
     *     (C4) Aspects must be unique per type (service or operation) and join point. That is,
     *          there might exist duplicate service or operation aspects as long as their join
     *          points do not overlap.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getTechnology_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.Technology#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.TechnologyImport}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.TechnologyImport#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Imports</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getTechnology_Imports()
     * @see de.fhdo.ddmm.technology.TechnologyImport#getTechnology
     * @model opposite="technology" containment="true"
     * @generated
     */
    EList<TechnologyImport> getImports();

    /**
     * Returns the value of the '<em><b>Primitive Types</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.TechnologySpecificPrimitiveType}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.TechnologySpecificPrimitiveType#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Primitive Types</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Primitive Types</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getTechnology_PrimitiveTypes()
     * @see de.fhdo.ddmm.technology.TechnologySpecificPrimitiveType#getTechnology
     * @model opposite="technology" containment="true"
     * @generated
     */
    EList<TechnologySpecificPrimitiveType> getPrimitiveTypes();

    /**
     * Returns the value of the '<em><b>List Types</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.TechnologySpecificListType}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.TechnologySpecificListType#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>List Types</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>List Types</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getTechnology_ListTypes()
     * @see de.fhdo.ddmm.technology.TechnologySpecificListType#getTechnology
     * @model opposite="technology" containment="true"
     * @generated
     */
    EList<TechnologySpecificListType> getListTypes();

    /**
     * Returns the value of the '<em><b>Data Structures</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.TechnologySpecificDataStructure}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.TechnologySpecificDataStructure#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Structures</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Structures</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getTechnology_DataStructures()
     * @see de.fhdo.ddmm.technology.TechnologySpecificDataStructure#getTechnology
     * @model opposite="technology" containment="true"
     * @generated
     */
    EList<TechnologySpecificDataStructure> getDataStructures();

    /**
     * Returns the value of the '<em><b>Compatibility Entries</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.CompatibilityMatrixEntry}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.CompatibilityMatrixEntry#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Compatibility Entries</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Compatibility Entries</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getTechnology_CompatibilityEntries()
     * @see de.fhdo.ddmm.technology.CompatibilityMatrixEntry#getTechnology
     * @model opposite="technology" containment="true"
     * @generated
     */
    EList<CompatibilityMatrixEntry> getCompatibilityEntries();

    /**
     * Returns the value of the '<em><b>Protocols</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.Protocol}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.Protocol#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Protocols</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocols</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getTechnology_Protocols()
     * @see de.fhdo.ddmm.technology.Protocol#getTechnology
     * @model opposite="technology" containment="true"
     * @generated
     */
    EList<Protocol> getProtocols();

    /**
     * Returns the value of the '<em><b>Service Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.ServiceAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.ServiceAspect#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Service Aspects</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getTechnology_ServiceAspects()
     * @see de.fhdo.ddmm.technology.ServiceAspect#getTechnology
     * @model opposite="technology" containment="true"
     * @generated
     */
    EList<ServiceAspect> getServiceAspects();

    /**
     * Returns the value of the '<em><b>Deployment Technologies</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.DeploymentTechnology}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.DeploymentTechnology#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Deployment Technologies</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Deployment Technologies</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getTechnology_DeploymentTechnologies()
     * @see de.fhdo.ddmm.technology.DeploymentTechnology#getTechnology
     * @model opposite="technology" containment="true"
     * @generated
     */
    EList<DeploymentTechnology> getDeploymentTechnologies();

    /**
     * Returns the value of the '<em><b>Infrastructure Technologies</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.InfrastructureTechnology}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.InfrastructureTechnology#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Infrastructure Technologies</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Infrastructure Technologies</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getTechnology_InfrastructureTechnologies()
     * @see de.fhdo.ddmm.technology.InfrastructureTechnology#getTechnology
     * @model opposite="technology" containment="true"
     * @generated
     */
    EList<InfrastructureTechnology> getInfrastructureTechnologies();

    /**
     * Returns the value of the '<em><b>Operation Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.OperationAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.OperationAspect#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation Aspects</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getTechnology_OperationAspects()
     * @see de.fhdo.ddmm.technology.OperationAspect#getTechnology
     * @model opposite="technology" containment="true"
     * @generated
     */
    EList<OperationAspect> getOperationAspects();

} // Technology
