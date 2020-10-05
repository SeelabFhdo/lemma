/**
 */
package de.fhdo.lemma.technology.mapping;

import de.fhdo.lemma.service.Import;

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
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologyMapping#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologyMapping#getTypeMappings <em>Type Mappings</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.TechnologyMapping#getServiceMappings <em>Service Mappings</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologyMapping()
 * @model
 * @generated
 */
public interface TechnologyMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.Import}.
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
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologyMapping_Imports()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Import> getImports();

	/**
	 * Returns the value of the '<em><b>Type Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.ComplexTypeMapping}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.ComplexTypeMapping#getMappingModel <em>Mapping Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Mappings</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologyMapping_TypeMappings()
	 * @see de.fhdo.lemma.technology.mapping.ComplexTypeMapping#getMappingModel
	 * @model opposite="mappingModel" containment="true"
	 * @generated
	 */
	EList<ComplexTypeMapping> getTypeMappings();

	/**
	 * Returns the value of the '<em><b>Service Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.mapping.MicroserviceMapping}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.MicroserviceMapping#getMappingModel <em>Mapping Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Mappings</em>' containment reference list.
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getTechnologyMapping_ServiceMappings()
	 * @see de.fhdo.lemma.technology.mapping.MicroserviceMapping#getMappingModel
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
	 * Get all complex parameter mappings of all mapped operations
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<ComplexParameterMapping> getComplexParameterMappings();

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
