/**
 */
package de.fhdo.lemma.technology;

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
 *   <li>{@link de.fhdo.lemma.technology.Technology#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.Technology#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.Technology#getPrimitiveTypes <em>Primitive Types</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.Technology#getCollectionTypes <em>Collection Types</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.Technology#getDataStructures <em>Data Structures</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.Technology#getCompatibilityEntries <em>Compatibility Entries</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.Technology#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.Technology#getServiceAspects <em>Service Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.Technology#getDeploymentTechnologies <em>Deployment Technologies</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.Technology#getInfrastructureTechnologies <em>Infrastructure Technologies</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.Technology#getOperationAspects <em>Operation Aspects</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnology()
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
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnology_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.Technology#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.technology.TechnologyImport}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.TechnologyImport#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Imports</em>' containment reference list.
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnology_Imports()
     * @see de.fhdo.lemma.technology.TechnologyImport#getTechnology
     * @model opposite="technology" containment="true"
     * @generated
     */
    EList<TechnologyImport> getImports();

    /**
     * Returns the value of the '<em><b>Primitive Types</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.technology.TechnologySpecificPrimitiveType}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.TechnologySpecificPrimitiveType#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Primitive Types</em>' containment reference list.
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnology_PrimitiveTypes()
     * @see de.fhdo.lemma.technology.TechnologySpecificPrimitiveType#getTechnology
     * @model opposite="technology" containment="true"
     * @generated
     */
    EList<TechnologySpecificPrimitiveType> getPrimitiveTypes();

    /**
     * Returns the value of the '<em><b>Collection Types</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.technology.TechnologySpecificCollectionType}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.TechnologySpecificCollectionType#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Collection Types</em>' containment reference list.
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnology_CollectionTypes()
     * @see de.fhdo.lemma.technology.TechnologySpecificCollectionType#getTechnology
     * @model opposite="technology" containment="true"
     * @generated
     */
    EList<TechnologySpecificCollectionType> getCollectionTypes();

    /**
     * Returns the value of the '<em><b>Data Structures</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.technology.TechnologySpecificDataStructure}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.TechnologySpecificDataStructure#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Structures</em>' containment reference list.
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnology_DataStructures()
     * @see de.fhdo.lemma.technology.TechnologySpecificDataStructure#getTechnology
     * @model opposite="technology" containment="true"
     * @generated
     */
    EList<TechnologySpecificDataStructure> getDataStructures();

    /**
     * Returns the value of the '<em><b>Compatibility Entries</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.technology.CompatibilityMatrixEntry}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.CompatibilityMatrixEntry#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Compatibility Entries</em>' containment reference list.
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnology_CompatibilityEntries()
     * @see de.fhdo.lemma.technology.CompatibilityMatrixEntry#getTechnology
     * @model opposite="technology" containment="true"
     * @generated
     */
    EList<CompatibilityMatrixEntry> getCompatibilityEntries();

    /**
     * Returns the value of the '<em><b>Protocols</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.technology.Protocol}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.Protocol#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocols</em>' containment reference list.
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnology_Protocols()
     * @see de.fhdo.lemma.technology.Protocol#getTechnology
     * @model opposite="technology" containment="true"
     * @generated
     */
    EList<Protocol> getProtocols();

    /**
     * Returns the value of the '<em><b>Service Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.technology.ServiceAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.ServiceAspect#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Service Aspects</em>' containment reference list.
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnology_ServiceAspects()
     * @see de.fhdo.lemma.technology.ServiceAspect#getTechnology
     * @model opposite="technology" containment="true"
     * @generated
     */
    EList<ServiceAspect> getServiceAspects();

    /**
     * Returns the value of the '<em><b>Deployment Technologies</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.technology.DeploymentTechnology}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.DeploymentTechnology#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Deployment Technologies</em>' containment reference list.
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnology_DeploymentTechnologies()
     * @see de.fhdo.lemma.technology.DeploymentTechnology#getTechnology
     * @model opposite="technology" containment="true"
     * @generated
     */
    EList<DeploymentTechnology> getDeploymentTechnologies();

    /**
     * Returns the value of the '<em><b>Infrastructure Technologies</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.technology.InfrastructureTechnology}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.InfrastructureTechnology#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Infrastructure Technologies</em>' containment reference list.
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnology_InfrastructureTechnologies()
     * @see de.fhdo.lemma.technology.InfrastructureTechnology#getTechnology
     * @model opposite="technology" containment="true"
     * @generated
     */
    EList<InfrastructureTechnology> getInfrastructureTechnologies();

    /**
     * Returns the value of the '<em><b>Operation Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.technology.OperationAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.OperationAspect#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation Aspects</em>' containment reference list.
     * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnology_OperationAspects()
     * @see de.fhdo.lemma.technology.OperationAspect#getTechnology
     * @model opposite="technology" containment="true"
     * @generated
     */
    EList<OperationAspect> getOperationAspects();

} // Technology
