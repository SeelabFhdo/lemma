/**
 */
package de.fhdo.ddmm.technology.mapping;

import de.fhdo.ddmm.service.Import;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Technology Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Metamodel for technology mappings that provide an alternative to specifying technology in service
 * models. It aims to preserve the readability of service models and to keep them
 * technology-agnostic.
 *  * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologyMapping#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologyMapping#getComplexTypeMappings <em>Complex Type Mappings</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologyMapping#getServiceMappings <em>Service Mappings</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologyMapping()
 * @model
 * @generated
 */
public interface TechnologyMapping extends EObject {
    /**
     * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.Import}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Imported files must be unique.
     *          Ensured by: DSL validator.
     *     (C2) A microservice may only be mapped once.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Imports</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologyMapping_Imports()
     * @model containment="true" required="true"
     * @generated
     */
    EList<Import> getImports();

    /**
     * Returns the value of the '<em><b>Complex Type Mappings</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.mapping.ComplexTypeMapping}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.ComplexTypeMapping#getMappingModel <em>Mapping Model</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Complex Type Mappings</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Complex Type Mappings</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologyMapping_ComplexTypeMappings()
     * @see de.fhdo.ddmm.technology.mapping.ComplexTypeMapping#getMappingModel
     * @model opposite="mappingModel" containment="true"
     * @generated
     */
    EList<ComplexTypeMapping> getComplexTypeMappings();

    /**
     * Returns the value of the '<em><b>Service Mappings</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.mapping.MicroserviceMapping}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.MicroserviceMapping#getMappingModel <em>Mapping Model</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service Mappings</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Service Mappings</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologyMapping_ServiceMappings()
     * @see de.fhdo.ddmm.technology.mapping.MicroserviceMapping#getMappingModel
     * @model opposite="mappingModel" containment="true"
     * @generated
     */
    EList<MicroserviceMapping> getServiceMappings();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get all mapped interfaces of all mapped microservices
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     * @generated
     */
    EList<InterfaceMapping> getMappedInterfaces();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get all operations of all mapped microservices
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     * @generated
     */
    EList<OperationMapping> getMappedOperations();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get all mapped referred operations of all mapped microservices
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     * @generated
     */
    EList<ReferredOperationMapping> getMappedReferredOperations();

} // TechnologyMapping
