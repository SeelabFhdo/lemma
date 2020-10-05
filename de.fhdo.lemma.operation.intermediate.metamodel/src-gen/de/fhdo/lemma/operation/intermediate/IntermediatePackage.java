/**
 */
package de.fhdo.lemma.operation.intermediate;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.fhdo.lemma.operation.intermediate.IntermediateFactory
 * @model kind="package"
 * @generated
 */
public interface IntermediatePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "intermediate";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.fhdo.de/lemma/operation/intermediate";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "intermediate";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IntermediatePackage eINSTANCE = de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationModelImpl <em>Operation Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationModelImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateOperationModel()
	 * @generated
	 */
	int INTERMEDIATE_OPERATION_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Source Model Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_MODEL__SOURCE_MODEL_URI = 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_MODEL__IMPORTS = 1;

	/**
	 * The feature id for the '<em><b>Containers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_MODEL__CONTAINERS = 2;

	/**
	 * The feature id for the '<em><b>Infrastructure Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_MODEL__INFRASTRUCTURE_NODES = 3;

	/**
	 * The number of structural features of the '<em>Operation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_MODEL_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Operation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl <em>Operation Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateOperationNode()
	 * @generated
	 */
	int INTERMEDIATE_OPERATION_NODE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Imported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE__IMPORTED = 1;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE__IMPORTS = 2;

	/**
	 * The feature id for the '<em><b>Operation Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE__OPERATION_ENVIRONMENT = 3;

	/**
	 * The feature id for the '<em><b>Deployed Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES = 4;

	/**
	 * The feature id for the '<em><b>Endpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE__ENDPOINTS = 5;

	/**
	 * The feature id for the '<em><b>Specifications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS = 6;

	/**
	 * The feature id for the '<em><b>Default Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE__DEFAULT_VALUES = 7;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE__ASPECTS = 8;

	/**
	 * The feature id for the '<em><b>Depends On Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE__DEPENDS_ON_NODES = 9;

	/**
	 * The feature id for the '<em><b>Used By Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE__USED_BY_NODES = 10;

	/**
	 * The number of structural features of the '<em>Operation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE_FEATURE_COUNT = 11;

	/**
	 * The operation id for the '<em>Get Effective Configuration Values</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE___GET_EFFECTIVE_CONFIGURATION_VALUES__OPERATIONMICROSERVICEREFERENCE = 0;

	/**
	 * The number of operations of the '<em>Operation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_NODE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateContainerImpl <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateContainerImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateContainer()
	 * @generated
	 */
	int INTERMEDIATE_CONTAINER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__NAME = INTERMEDIATE_OPERATION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Imported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__IMPORTED = INTERMEDIATE_OPERATION_NODE__IMPORTED;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__IMPORTS = INTERMEDIATE_OPERATION_NODE__IMPORTS;

	/**
	 * The feature id for the '<em><b>Operation Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__OPERATION_ENVIRONMENT = INTERMEDIATE_OPERATION_NODE__OPERATION_ENVIRONMENT;

	/**
	 * The feature id for the '<em><b>Deployed Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__DEPLOYED_SERVICES = INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES;

	/**
	 * The feature id for the '<em><b>Endpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__ENDPOINTS = INTERMEDIATE_OPERATION_NODE__ENDPOINTS;

	/**
	 * The feature id for the '<em><b>Specifications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__SPECIFICATIONS = INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS;

	/**
	 * The feature id for the '<em><b>Default Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__DEFAULT_VALUES = INTERMEDIATE_OPERATION_NODE__DEFAULT_VALUES;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__ASPECTS = INTERMEDIATE_OPERATION_NODE__ASPECTS;

	/**
	 * The feature id for the '<em><b>Depends On Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__DEPENDS_ON_NODES = INTERMEDIATE_OPERATION_NODE__DEPENDS_ON_NODES;

	/**
	 * The feature id for the '<em><b>Used By Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__USED_BY_NODES = INTERMEDIATE_OPERATION_NODE__USED_BY_NODES;

	/**
	 * The feature id for the '<em><b>Technology Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__TECHNOLOGY_REFERENCE = INTERMEDIATE_OPERATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operation Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER__OPERATION_MODEL = INTERMEDIATE_OPERATION_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER_FEATURE_COUNT = INTERMEDIATE_OPERATION_NODE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Effective Configuration Values</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER___GET_EFFECTIVE_CONFIGURATION_VALUES__OPERATIONMICROSERVICEREFERENCE = INTERMEDIATE_OPERATION_NODE___GET_EFFECTIVE_CONFIGURATION_VALUES__OPERATIONMICROSERVICEREFERENCE;

	/**
	 * The number of operations of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTAINER_OPERATION_COUNT = INTERMEDIATE_OPERATION_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureNodeImpl <em>Infrastructure Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureNodeImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateInfrastructureNode()
	 * @generated
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__NAME = INTERMEDIATE_OPERATION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Imported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__IMPORTED = INTERMEDIATE_OPERATION_NODE__IMPORTED;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__IMPORTS = INTERMEDIATE_OPERATION_NODE__IMPORTS;

	/**
	 * The feature id for the '<em><b>Operation Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__OPERATION_ENVIRONMENT = INTERMEDIATE_OPERATION_NODE__OPERATION_ENVIRONMENT;

	/**
	 * The feature id for the '<em><b>Deployed Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__DEPLOYED_SERVICES = INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES;

	/**
	 * The feature id for the '<em><b>Endpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__ENDPOINTS = INTERMEDIATE_OPERATION_NODE__ENDPOINTS;

	/**
	 * The feature id for the '<em><b>Specifications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__SPECIFICATIONS = INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS;

	/**
	 * The feature id for the '<em><b>Default Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__DEFAULT_VALUES = INTERMEDIATE_OPERATION_NODE__DEFAULT_VALUES;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__ASPECTS = INTERMEDIATE_OPERATION_NODE__ASPECTS;

	/**
	 * The feature id for the '<em><b>Depends On Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__DEPENDS_ON_NODES = INTERMEDIATE_OPERATION_NODE__DEPENDS_ON_NODES;

	/**
	 * The feature id for the '<em><b>Used By Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__USED_BY_NODES = INTERMEDIATE_OPERATION_NODE__USED_BY_NODES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__REFERENCE = INTERMEDIATE_OPERATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operation Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE__OPERATION_MODEL = INTERMEDIATE_OPERATION_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Infrastructure Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE_FEATURE_COUNT = INTERMEDIATE_OPERATION_NODE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Effective Configuration Values</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE___GET_EFFECTIVE_CONFIGURATION_VALUES__OPERATIONMICROSERVICEREFERENCE = INTERMEDIATE_OPERATION_NODE___GET_EFFECTIVE_CONFIGURATION_VALUES__OPERATIONMICROSERVICEREFERENCE;

	/**
	 * The number of operations of the '<em>Infrastructure Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_NODE_OPERATION_COUNT = INTERMEDIATE_OPERATION_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateServiceDeploymentSpecificationImpl <em>Service Deployment Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateServiceDeploymentSpecificationImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateServiceDeploymentSpecification()
	 * @generated
	 */
	int INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION = 4;

	/**
	 * The feature id for the '<em><b>Operation Microservice Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_MICROSERVICE_REFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Endpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__ENDPOINTS = 1;

	/**
	 * The feature id for the '<em><b>Property Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__PROPERTY_VALUES = 2;

	/**
	 * The feature id for the '<em><b>Operation Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE = 3;

	/**
	 * The number of structural features of the '<em>Service Deployment Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Service Deployment Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationEnvironmentImpl <em>Operation Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationEnvironmentImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateOperationEnvironment()
	 * @generated
	 */
	int INTERMEDIATE_OPERATION_ENVIRONMENT = 5;

	/**
	 * The feature id for the '<em><b>Environment Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENVIRONMENT__ENVIRONMENT_NAME = 0;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENVIRONMENT__DEFAULT = 1;

	/**
	 * The feature id for the '<em><b>Operation Technology</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENVIRONMENT__OPERATION_TECHNOLOGY = 2;

	/**
	 * The number of structural features of the '<em>Operation Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENVIRONMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Operation Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENVIRONMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationTechnologyImpl <em>Operation Technology</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationTechnologyImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateOperationTechnology()
	 * @generated
	 */
	int INTERMEDIATE_OPERATION_TECHNOLOGY = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_TECHNOLOGY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Environment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_TECHNOLOGY__ENVIRONMENT = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_TECHNOLOGY__PROPERTIES = 2;

	/**
	 * The number of structural features of the '<em>Operation Technology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_TECHNOLOGY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Operation Technology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_TECHNOLOGY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyImpl <em>Deployment Technology</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateDeploymentTechnology()
	 * @generated
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY__NAME = INTERMEDIATE_OPERATION_TECHNOLOGY__NAME;

	/**
	 * The feature id for the '<em><b>Environment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY__ENVIRONMENT = INTERMEDIATE_OPERATION_TECHNOLOGY__ENVIRONMENT;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY__PROPERTIES = INTERMEDIATE_OPERATION_TECHNOLOGY__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY__REFERENCE = INTERMEDIATE_OPERATION_TECHNOLOGY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Deployment Technology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_FEATURE_COUNT = INTERMEDIATE_OPERATION_TECHNOLOGY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Deployment Technology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_OPERATION_COUNT = INTERMEDIATE_OPERATION_TECHNOLOGY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyImpl <em>Infrastructure Technology</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateInfrastructureTechnology()
	 * @generated
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY__NAME = INTERMEDIATE_OPERATION_TECHNOLOGY__NAME;

	/**
	 * The feature id for the '<em><b>Environment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY__ENVIRONMENT = INTERMEDIATE_OPERATION_TECHNOLOGY__ENVIRONMENT;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY__PROPERTIES = INTERMEDIATE_OPERATION_TECHNOLOGY__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY__REFERENCE = INTERMEDIATE_OPERATION_TECHNOLOGY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Infrastructure Technology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_FEATURE_COUNT = INTERMEDIATE_OPERATION_TECHNOLOGY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Infrastructure Technology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_OPERATION_COUNT = INTERMEDIATE_OPERATION_TECHNOLOGY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyReferenceImpl <em>Infrastructure Technology Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyReferenceImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateInfrastructureTechnologyReference()
	 * @generated
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE = 9;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__IMPORT = 0;

	/**
	 * The feature id for the '<em><b>Technology</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__TECHNOLOGY = 1;

	/**
	 * The feature id for the '<em><b>Infrastructure Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE = 2;

	/**
	 * The number of structural features of the '<em>Infrastructure Technology Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Infrastructure Technology Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyReferenceImpl <em>Deployment Technology Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyReferenceImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateDeploymentTechnologyReference()
	 * @generated
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE = 10;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT = 0;

	/**
	 * The feature id for the '<em><b>Technology</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__TECHNOLOGY = 1;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER = 2;

	/**
	 * The number of structural features of the '<em>Deployment Technology Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Deployment Technology Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyImpl <em>Technology Specific Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateTechnologySpecificProperty()
	 * @generated
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Feature Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__FEATURE_NAMES = 3;

	/**
	 * The feature id for the '<em><b>Operation Technology</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__OPERATION_TECHNOLOGY = 4;

	/**
	 * The number of structural features of the '<em>Technology Specific Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Technology Specific Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyValueImpl <em>Technology Specific Property Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyValueImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateTechnologySpecificPropertyValue()
	 * @generated
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE = 12;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Technology Specific Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__TECHNOLOGY_SPECIFIC_PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__SPECIFICATION = 2;

	/**
	 * The feature id for the '<em><b>Operation Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__OPERATION_NODE = 3;

	/**
	 * The number of structural features of the '<em>Technology Specific Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Technology Specific Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.OperationMicroserviceReferenceImpl <em>Operation Microservice Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.OperationMicroserviceReferenceImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getOperationMicroserviceReference()
	 * @generated
	 */
	int OPERATION_MICROSERVICE_REFERENCE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__NAME = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__VERSION = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE__VERSION;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__QUALIFIED_NAME = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Imported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__IMPORTED = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE__IMPORTED;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__IMPORT = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE__IMPORT;

	/**
	 * The feature id for the '<em><b>Local Microservice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__LOCAL_MICROSERVICE = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE__LOCAL_MICROSERVICE;

	/**
	 * The feature id for the '<em><b>Requiring Microservice</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__REQUIRING_MICROSERVICE = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE__REQUIRING_MICROSERVICE;

	/**
	 * The feature id for the '<em><b>Effectively Implemented</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__EFFECTIVELY_IMPLEMENTED = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Microservice Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__MICROSERVICE_TYPE = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__VISIBILITY = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE__NODE = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Operation Microservice Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE_FEATURE_COUNT = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Operation Microservice Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MICROSERVICE_REFERENCE_OPERATION_COUNT = de.fhdo.lemma.service.intermediate.IntermediatePackage.MICROSERVICE_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateEndpointTechnologyImpl <em>Endpoint Technology</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateEndpointTechnologyImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateEndpointTechnology()
	 * @generated
	 */
	int INTERMEDIATE_ENDPOINT_TECHNOLOGY = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENDPOINT_TECHNOLOGY__NAME = de.fhdo.lemma.service.intermediate.IntermediatePackage.INTERMEDIATE_TECHNOLOGY__NAME;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENDPOINT_TECHNOLOGY__IMPORT = de.fhdo.lemma.service.intermediate.IntermediatePackage.INTERMEDIATE_TECHNOLOGY__IMPORT;

	/**
	 * The feature id for the '<em><b>Microservice</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENDPOINT_TECHNOLOGY__MICROSERVICE = de.fhdo.lemma.service.intermediate.IntermediatePackage.INTERMEDIATE_TECHNOLOGY__MICROSERVICE;

	/**
	 * The feature id for the '<em><b>Endpoint</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT = de.fhdo.lemma.service.intermediate.IntermediatePackage.INTERMEDIATE_TECHNOLOGY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Endpoint Technology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENDPOINT_TECHNOLOGY_FEATURE_COUNT = de.fhdo.lemma.service.intermediate.IntermediatePackage.INTERMEDIATE_TECHNOLOGY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Endpoint Technology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENDPOINT_TECHNOLOGY_OPERATION_COUNT = de.fhdo.lemma.service.intermediate.IntermediatePackage.INTERMEDIATE_TECHNOLOGY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationEndpointImpl <em>Operation Endpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationEndpointImpl
	 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateOperationEndpoint()
	 * @generated
	 */
	int INTERMEDIATE_OPERATION_ENDPOINT = 15;

	/**
	 * The feature id for the '<em><b>Communication Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENDPOINT__COMMUNICATION_TYPE = de.fhdo.lemma.service.intermediate.IntermediatePackage.INTERMEDIATE_ENDPOINT__COMMUNICATION_TYPE;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENDPOINT__PROTOCOL = de.fhdo.lemma.service.intermediate.IntermediatePackage.INTERMEDIATE_ENDPOINT__PROTOCOL;

	/**
	 * The feature id for the '<em><b>Data Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENDPOINT__DATA_FORMAT = de.fhdo.lemma.service.intermediate.IntermediatePackage.INTERMEDIATE_ENDPOINT__DATA_FORMAT;

	/**
	 * The feature id for the '<em><b>Addresses</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENDPOINT__ADDRESSES = de.fhdo.lemma.service.intermediate.IntermediatePackage.INTERMEDIATE_ENDPOINT__ADDRESSES;

	/**
	 * The feature id for the '<em><b>Technology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENDPOINT__TECHNOLOGY = de.fhdo.lemma.service.intermediate.IntermediatePackage.INTERMEDIATE_ENDPOINT__TECHNOLOGY;

	/**
	 * The feature id for the '<em><b>Microservice</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENDPOINT__MICROSERVICE = de.fhdo.lemma.service.intermediate.IntermediatePackage.INTERMEDIATE_ENDPOINT__MICROSERVICE;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENDPOINT__INTERFACE = de.fhdo.lemma.service.intermediate.IntermediatePackage.INTERMEDIATE_ENDPOINT__INTERFACE;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENDPOINT__OPERATION = de.fhdo.lemma.service.intermediate.IntermediatePackage.INTERMEDIATE_ENDPOINT__OPERATION;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENDPOINT__REFERRED_OPERATION = de.fhdo.lemma.service.intermediate.IntermediatePackage.INTERMEDIATE_ENDPOINT__REFERRED_OPERATION;

	/**
	 * The feature id for the '<em><b>Endpoint Technology</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENDPOINT__ENDPOINT_TECHNOLOGY = de.fhdo.lemma.service.intermediate.IntermediatePackage.INTERMEDIATE_ENDPOINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENDPOINT__NODE = de.fhdo.lemma.service.intermediate.IntermediatePackage.INTERMEDIATE_ENDPOINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operation Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENDPOINT_FEATURE_COUNT = de.fhdo.lemma.service.intermediate.IntermediatePackage.INTERMEDIATE_ENDPOINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Operation Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_OPERATION_ENDPOINT_OPERATION_COUNT = de.fhdo.lemma.service.intermediate.IntermediatePackage.INTERMEDIATE_ENDPOINT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel <em>Operation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Model</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
	 * @generated
	 */
	EClass getIntermediateOperationModel();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getSourceModelUri <em>Source Model Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Model Uri</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getSourceModelUri()
	 * @see #getIntermediateOperationModel()
	 * @generated
	 */
	EAttribute getIntermediateOperationModel_SourceModelUri();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getImports()
	 * @see #getIntermediateOperationModel()
	 * @generated
	 */
	EReference getIntermediateOperationModel_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getContainers <em>Containers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Containers</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getContainers()
	 * @see #getIntermediateOperationModel()
	 * @generated
	 */
	EReference getIntermediateOperationModel_Containers();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getInfrastructureNodes <em>Infrastructure Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Infrastructure Nodes</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationModel#getInfrastructureNodes()
	 * @see #getIntermediateOperationModel()
	 * @generated
	 */
	EReference getIntermediateOperationModel_InfrastructureNodes();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode <em>Operation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Node</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode
	 * @generated
	 */
	EClass getIntermediateOperationNode();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getName()
	 * @see #getIntermediateOperationNode()
	 * @generated
	 */
	EAttribute getIntermediateOperationNode_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#isImported <em>Imported</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Imported</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#isImported()
	 * @see #getIntermediateOperationNode()
	 * @generated
	 */
	EAttribute getIntermediateOperationNode_Imported();

	/**
	 * Returns the meta object for the reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Imports</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getImports()
	 * @see #getIntermediateOperationNode()
	 * @generated
	 */
	EReference getIntermediateOperationNode_Imports();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getOperationEnvironment <em>Operation Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation Environment</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getOperationEnvironment()
	 * @see #getIntermediateOperationNode()
	 * @generated
	 */
	EReference getIntermediateOperationNode_OperationEnvironment();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getDeployedServices <em>Deployed Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Deployed Services</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getDeployedServices()
	 * @see #getIntermediateOperationNode()
	 * @generated
	 */
	EReference getIntermediateOperationNode_DeployedServices();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getEndpoints <em>Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Endpoints</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getEndpoints()
	 * @see #getIntermediateOperationNode()
	 * @generated
	 */
	EReference getIntermediateOperationNode_Endpoints();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getSpecifications <em>Specifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Specifications</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getSpecifications()
	 * @see #getIntermediateOperationNode()
	 * @generated
	 */
	EReference getIntermediateOperationNode_Specifications();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getDefaultValues <em>Default Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Default Values</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getDefaultValues()
	 * @see #getIntermediateOperationNode()
	 * @generated
	 */
	EReference getIntermediateOperationNode_DefaultValues();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getAspects()
	 * @see #getIntermediateOperationNode()
	 * @generated
	 */
	EReference getIntermediateOperationNode_Aspects();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getDependsOnNodes <em>Depends On Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Depends On Nodes</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getDependsOnNodes()
	 * @see #getIntermediateOperationNode()
	 * @generated
	 */
	EReference getIntermediateOperationNode_DependsOnNodes();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getUsedByNodes <em>Used By Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Used By Nodes</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getUsedByNodes()
	 * @see #getIntermediateOperationNode()
	 * @generated
	 */
	EReference getIntermediateOperationNode_UsedByNodes();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getEffectiveConfigurationValues(de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference) <em>Get Effective Configuration Values</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Effective Configuration Values</em>' operation.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getEffectiveConfigurationValues(de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference)
	 * @generated
	 */
	EOperation getIntermediateOperationNode__GetEffectiveConfigurationValues__OperationMicroserviceReference();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateContainer
	 * @generated
	 */
	EClass getIntermediateContainer();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer#getTechnologyReference <em>Technology Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Technology Reference</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateContainer#getTechnologyReference()
	 * @see #getIntermediateContainer()
	 * @generated
	 */
	EReference getIntermediateContainer_TechnologyReference();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateContainer#getOperationModel <em>Operation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Operation Model</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateContainer#getOperationModel()
	 * @see #getIntermediateContainer()
	 * @generated
	 */
	EReference getIntermediateContainer_OperationModel();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode <em>Infrastructure Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infrastructure Node</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
	 * @generated
	 */
	EClass getIntermediateInfrastructureNode();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reference</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getReference()
	 * @see #getIntermediateInfrastructureNode()
	 * @generated
	 */
	EReference getIntermediateInfrastructureNode_Reference();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getOperationModel <em>Operation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Operation Model</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode#getOperationModel()
	 * @see #getIntermediateInfrastructureNode()
	 * @generated
	 */
	EReference getIntermediateInfrastructureNode_OperationModel();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification <em>Service Deployment Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Deployment Specification</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification
	 * @generated
	 */
	EClass getIntermediateServiceDeploymentSpecification();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getOperationMicroserviceReference <em>Operation Microservice Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation Microservice Reference</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getOperationMicroserviceReference()
	 * @see #getIntermediateServiceDeploymentSpecification()
	 * @generated
	 */
	EReference getIntermediateServiceDeploymentSpecification_OperationMicroserviceReference();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getEndpoints <em>Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Endpoints</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getEndpoints()
	 * @see #getIntermediateServiceDeploymentSpecification()
	 * @generated
	 */
	EReference getIntermediateServiceDeploymentSpecification_Endpoints();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getPropertyValues <em>Property Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Values</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getPropertyValues()
	 * @see #getIntermediateServiceDeploymentSpecification()
	 * @generated
	 */
	EReference getIntermediateServiceDeploymentSpecification_PropertyValues();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getOperationNode <em>Operation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Operation Node</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification#getOperationNode()
	 * @see #getIntermediateServiceDeploymentSpecification()
	 * @generated
	 */
	EReference getIntermediateServiceDeploymentSpecification_OperationNode();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment <em>Operation Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Environment</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment
	 * @generated
	 */
	EClass getIntermediateOperationEnvironment();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#getEnvironmentName <em>Environment Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Environment Name</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#getEnvironmentName()
	 * @see #getIntermediateOperationEnvironment()
	 * @generated
	 */
	EAttribute getIntermediateOperationEnvironment_EnvironmentName();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#isDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#isDefault()
	 * @see #getIntermediateOperationEnvironment()
	 * @generated
	 */
	EAttribute getIntermediateOperationEnvironment_Default();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#getOperationTechnology <em>Operation Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Operation Technology</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#getOperationTechnology()
	 * @see #getIntermediateOperationEnvironment()
	 * @generated
	 */
	EReference getIntermediateOperationEnvironment_OperationTechnology();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology <em>Operation Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Technology</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology
	 * @generated
	 */
	EClass getIntermediateOperationTechnology();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getName()
	 * @see #getIntermediateOperationTechnology()
	 * @generated
	 */
	EAttribute getIntermediateOperationTechnology_Name();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getEnvironment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Environment</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getEnvironment()
	 * @see #getIntermediateOperationTechnology()
	 * @generated
	 */
	EReference getIntermediateOperationTechnology_Environment();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getProperties()
	 * @see #getIntermediateOperationTechnology()
	 * @generated
	 */
	EReference getIntermediateOperationTechnology_Properties();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnology <em>Deployment Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment Technology</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnology
	 * @generated
	 */
	EClass getIntermediateDeploymentTechnology();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnology#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Reference</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnology#getReference()
	 * @see #getIntermediateDeploymentTechnology()
	 * @generated
	 */
	EReference getIntermediateDeploymentTechnology_Reference();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnology <em>Infrastructure Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infrastructure Technology</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnology
	 * @generated
	 */
	EClass getIntermediateInfrastructureTechnology();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnology#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Reference</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnology#getReference()
	 * @see #getIntermediateInfrastructureTechnology()
	 * @generated
	 */
	EReference getIntermediateInfrastructureTechnology_Reference();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference <em>Infrastructure Technology Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infrastructure Technology Reference</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference
	 * @generated
	 */
	EClass getIntermediateInfrastructureTechnologyReference();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Import</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getImport()
	 * @see #getIntermediateInfrastructureTechnologyReference()
	 * @generated
	 */
	EReference getIntermediateInfrastructureTechnologyReference_Import();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getTechnology <em>Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Technology</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getTechnology()
	 * @see #getIntermediateInfrastructureTechnologyReference()
	 * @generated
	 */
	EReference getIntermediateInfrastructureTechnologyReference_Technology();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getInfrastructureNode <em>Infrastructure Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Infrastructure Node</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference#getInfrastructureNode()
	 * @see #getIntermediateInfrastructureTechnologyReference()
	 * @generated
	 */
	EReference getIntermediateInfrastructureTechnologyReference_InfrastructureNode();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference <em>Deployment Technology Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment Technology Reference</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference
	 * @generated
	 */
	EClass getIntermediateDeploymentTechnologyReference();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Import</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getImport()
	 * @see #getIntermediateDeploymentTechnologyReference()
	 * @generated
	 */
	EReference getIntermediateDeploymentTechnologyReference_Import();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getTechnology <em>Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Technology</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getTechnology()
	 * @see #getIntermediateDeploymentTechnologyReference()
	 * @generated
	 */
	EReference getIntermediateDeploymentTechnologyReference_Technology();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference#getContainer()
	 * @see #getIntermediateDeploymentTechnologyReference()
	 * @generated
	 */
	EReference getIntermediateDeploymentTechnologyReference_Container();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty <em>Technology Specific Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Technology Specific Property</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty
	 * @generated
	 */
	EClass getIntermediateTechnologySpecificProperty();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getName()
	 * @see #getIntermediateTechnologySpecificProperty()
	 * @generated
	 */
	EAttribute getIntermediateTechnologySpecificProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getType()
	 * @see #getIntermediateTechnologySpecificProperty()
	 * @generated
	 */
	EAttribute getIntermediateTechnologySpecificProperty_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getDefaultValue()
	 * @see #getIntermediateTechnologySpecificProperty()
	 * @generated
	 */
	EAttribute getIntermediateTechnologySpecificProperty_DefaultValue();

	/**
	 * Returns the meta object for the attribute list '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getFeatureNames <em>Feature Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Names</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getFeatureNames()
	 * @see #getIntermediateTechnologySpecificProperty()
	 * @generated
	 */
	EAttribute getIntermediateTechnologySpecificProperty_FeatureNames();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getOperationTechnology <em>Operation Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Operation Technology</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getOperationTechnology()
	 * @see #getIntermediateTechnologySpecificProperty()
	 * @generated
	 */
	EReference getIntermediateTechnologySpecificProperty_OperationTechnology();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue <em>Technology Specific Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Technology Specific Property Value</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue
	 * @generated
	 */
	EClass getIntermediateTechnologySpecificPropertyValue();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getValue()
	 * @see #getIntermediateTechnologySpecificPropertyValue()
	 * @generated
	 */
	EAttribute getIntermediateTechnologySpecificPropertyValue_Value();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getTechnologySpecificProperty <em>Technology Specific Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Technology Specific Property</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getTechnologySpecificProperty()
	 * @see #getIntermediateTechnologySpecificPropertyValue()
	 * @generated
	 */
	EReference getIntermediateTechnologySpecificPropertyValue_TechnologySpecificProperty();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Specification</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getSpecification()
	 * @see #getIntermediateTechnologySpecificPropertyValue()
	 * @generated
	 */
	EReference getIntermediateTechnologySpecificPropertyValue_Specification();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getOperationNode <em>Operation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Operation Node</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue#getOperationNode()
	 * @see #getIntermediateTechnologySpecificPropertyValue()
	 * @generated
	 */
	EReference getIntermediateTechnologySpecificPropertyValue_OperationNode();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference <em>Operation Microservice Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Microservice Reference</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference
	 * @generated
	 */
	EClass getOperationMicroserviceReference();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#isEffectivelyImplemented <em>Effectively Implemented</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effectively Implemented</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#isEffectivelyImplemented()
	 * @see #getOperationMicroserviceReference()
	 * @generated
	 */
	EAttribute getOperationMicroserviceReference_EffectivelyImplemented();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getMicroserviceType <em>Microservice Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Microservice Type</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getMicroserviceType()
	 * @see #getOperationMicroserviceReference()
	 * @generated
	 */
	EAttribute getOperationMicroserviceReference_MicroserviceType();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getVisibility()
	 * @see #getOperationMicroserviceReference()
	 * @generated
	 */
	EAttribute getOperationMicroserviceReference_Visibility();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Node</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getNode()
	 * @see #getOperationMicroserviceReference()
	 * @generated
	 */
	EReference getOperationMicroserviceReference_Node();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateEndpointTechnology <em>Endpoint Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Endpoint Technology</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateEndpointTechnology
	 * @generated
	 */
	EClass getIntermediateEndpointTechnology();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateEndpointTechnology#getEndpoint <em>Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Endpoint</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateEndpointTechnology#getEndpoint()
	 * @see #getIntermediateEndpointTechnology()
	 * @generated
	 */
	EReference getIntermediateEndpointTechnology_Endpoint();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint <em>Operation Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Endpoint</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint
	 * @generated
	 */
	EClass getIntermediateOperationEndpoint();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint#getEndpointTechnology <em>Endpoint Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Endpoint Technology</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint#getEndpointTechnology()
	 * @see #getIntermediateOperationEndpoint()
	 * @generated
	 */
	EReference getIntermediateOperationEndpoint_EndpointTechnology();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Node</em>'.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint#getNode()
	 * @see #getIntermediateOperationEndpoint()
	 * @generated
	 */
	EReference getIntermediateOperationEndpoint_Node();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IntermediateFactory getIntermediateFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationModelImpl <em>Operation Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationModelImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateOperationModel()
		 * @generated
		 */
		EClass INTERMEDIATE_OPERATION_MODEL = eINSTANCE.getIntermediateOperationModel();

		/**
		 * The meta object literal for the '<em><b>Source Model Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_OPERATION_MODEL__SOURCE_MODEL_URI = eINSTANCE.getIntermediateOperationModel_SourceModelUri();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_MODEL__IMPORTS = eINSTANCE.getIntermediateOperationModel_Imports();

		/**
		 * The meta object literal for the '<em><b>Containers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_MODEL__CONTAINERS = eINSTANCE.getIntermediateOperationModel_Containers();

		/**
		 * The meta object literal for the '<em><b>Infrastructure Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_MODEL__INFRASTRUCTURE_NODES = eINSTANCE.getIntermediateOperationModel_InfrastructureNodes();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl <em>Operation Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateOperationNode()
		 * @generated
		 */
		EClass INTERMEDIATE_OPERATION_NODE = eINSTANCE.getIntermediateOperationNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_OPERATION_NODE__NAME = eINSTANCE.getIntermediateOperationNode_Name();

		/**
		 * The meta object literal for the '<em><b>Imported</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_OPERATION_NODE__IMPORTED = eINSTANCE.getIntermediateOperationNode_Imported();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_NODE__IMPORTS = eINSTANCE.getIntermediateOperationNode_Imports();

		/**
		 * The meta object literal for the '<em><b>Operation Environment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_NODE__OPERATION_ENVIRONMENT = eINSTANCE.getIntermediateOperationNode_OperationEnvironment();

		/**
		 * The meta object literal for the '<em><b>Deployed Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES = eINSTANCE.getIntermediateOperationNode_DeployedServices();

		/**
		 * The meta object literal for the '<em><b>Endpoints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_NODE__ENDPOINTS = eINSTANCE.getIntermediateOperationNode_Endpoints();

		/**
		 * The meta object literal for the '<em><b>Specifications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS = eINSTANCE.getIntermediateOperationNode_Specifications();

		/**
		 * The meta object literal for the '<em><b>Default Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_NODE__DEFAULT_VALUES = eINSTANCE.getIntermediateOperationNode_DefaultValues();

		/**
		 * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_NODE__ASPECTS = eINSTANCE.getIntermediateOperationNode_Aspects();

		/**
		 * The meta object literal for the '<em><b>Depends On Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_NODE__DEPENDS_ON_NODES = eINSTANCE.getIntermediateOperationNode_DependsOnNodes();

		/**
		 * The meta object literal for the '<em><b>Used By Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_NODE__USED_BY_NODES = eINSTANCE.getIntermediateOperationNode_UsedByNodes();

		/**
		 * The meta object literal for the '<em><b>Get Effective Configuration Values</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INTERMEDIATE_OPERATION_NODE___GET_EFFECTIVE_CONFIGURATION_VALUES__OPERATIONMICROSERVICEREFERENCE = eINSTANCE.getIntermediateOperationNode__GetEffectiveConfigurationValues__OperationMicroserviceReference();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateContainerImpl <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateContainerImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateContainer()
		 * @generated
		 */
		EClass INTERMEDIATE_CONTAINER = eINSTANCE.getIntermediateContainer();

		/**
		 * The meta object literal for the '<em><b>Technology Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_CONTAINER__TECHNOLOGY_REFERENCE = eINSTANCE.getIntermediateContainer_TechnologyReference();

		/**
		 * The meta object literal for the '<em><b>Operation Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_CONTAINER__OPERATION_MODEL = eINSTANCE.getIntermediateContainer_OperationModel();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureNodeImpl <em>Infrastructure Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureNodeImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateInfrastructureNode()
		 * @generated
		 */
		EClass INTERMEDIATE_INFRASTRUCTURE_NODE = eINSTANCE.getIntermediateInfrastructureNode();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_INFRASTRUCTURE_NODE__REFERENCE = eINSTANCE.getIntermediateInfrastructureNode_Reference();

		/**
		 * The meta object literal for the '<em><b>Operation Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_INFRASTRUCTURE_NODE__OPERATION_MODEL = eINSTANCE.getIntermediateInfrastructureNode_OperationModel();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateServiceDeploymentSpecificationImpl <em>Service Deployment Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateServiceDeploymentSpecificationImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateServiceDeploymentSpecification()
		 * @generated
		 */
		EClass INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION = eINSTANCE.getIntermediateServiceDeploymentSpecification();

		/**
		 * The meta object literal for the '<em><b>Operation Microservice Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_MICROSERVICE_REFERENCE = eINSTANCE.getIntermediateServiceDeploymentSpecification_OperationMicroserviceReference();

		/**
		 * The meta object literal for the '<em><b>Endpoints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__ENDPOINTS = eINSTANCE.getIntermediateServiceDeploymentSpecification_Endpoints();

		/**
		 * The meta object literal for the '<em><b>Property Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__PROPERTY_VALUES = eINSTANCE.getIntermediateServiceDeploymentSpecification_PropertyValues();

		/**
		 * The meta object literal for the '<em><b>Operation Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE = eINSTANCE.getIntermediateServiceDeploymentSpecification_OperationNode();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationEnvironmentImpl <em>Operation Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationEnvironmentImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateOperationEnvironment()
		 * @generated
		 */
		EClass INTERMEDIATE_OPERATION_ENVIRONMENT = eINSTANCE.getIntermediateOperationEnvironment();

		/**
		 * The meta object literal for the '<em><b>Environment Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_OPERATION_ENVIRONMENT__ENVIRONMENT_NAME = eINSTANCE.getIntermediateOperationEnvironment_EnvironmentName();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_OPERATION_ENVIRONMENT__DEFAULT = eINSTANCE.getIntermediateOperationEnvironment_Default();

		/**
		 * The meta object literal for the '<em><b>Operation Technology</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_ENVIRONMENT__OPERATION_TECHNOLOGY = eINSTANCE.getIntermediateOperationEnvironment_OperationTechnology();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationTechnologyImpl <em>Operation Technology</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationTechnologyImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateOperationTechnology()
		 * @generated
		 */
		EClass INTERMEDIATE_OPERATION_TECHNOLOGY = eINSTANCE.getIntermediateOperationTechnology();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_OPERATION_TECHNOLOGY__NAME = eINSTANCE.getIntermediateOperationTechnology_Name();

		/**
		 * The meta object literal for the '<em><b>Environment</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_TECHNOLOGY__ENVIRONMENT = eINSTANCE.getIntermediateOperationTechnology_Environment();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_TECHNOLOGY__PROPERTIES = eINSTANCE.getIntermediateOperationTechnology_Properties();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyImpl <em>Deployment Technology</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateDeploymentTechnology()
		 * @generated
		 */
		EClass INTERMEDIATE_DEPLOYMENT_TECHNOLOGY = eINSTANCE.getIntermediateDeploymentTechnology();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DEPLOYMENT_TECHNOLOGY__REFERENCE = eINSTANCE.getIntermediateDeploymentTechnology_Reference();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyImpl <em>Infrastructure Technology</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateInfrastructureTechnology()
		 * @generated
		 */
		EClass INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY = eINSTANCE.getIntermediateInfrastructureTechnology();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY__REFERENCE = eINSTANCE.getIntermediateInfrastructureTechnology_Reference();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyReferenceImpl <em>Infrastructure Technology Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyReferenceImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateInfrastructureTechnologyReference()
		 * @generated
		 */
		EClass INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE = eINSTANCE.getIntermediateInfrastructureTechnologyReference();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__IMPORT = eINSTANCE.getIntermediateInfrastructureTechnologyReference_Import();

		/**
		 * The meta object literal for the '<em><b>Technology</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__TECHNOLOGY = eINSTANCE.getIntermediateInfrastructureTechnologyReference_Technology();

		/**
		 * The meta object literal for the '<em><b>Infrastructure Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE = eINSTANCE.getIntermediateInfrastructureTechnologyReference_InfrastructureNode();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyReferenceImpl <em>Deployment Technology Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateDeploymentTechnologyReferenceImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateDeploymentTechnologyReference()
		 * @generated
		 */
		EClass INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE = eINSTANCE.getIntermediateDeploymentTechnologyReference();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT = eINSTANCE.getIntermediateDeploymentTechnologyReference_Import();

		/**
		 * The meta object literal for the '<em><b>Technology</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__TECHNOLOGY = eINSTANCE.getIntermediateDeploymentTechnologyReference_Technology();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER = eINSTANCE.getIntermediateDeploymentTechnologyReference_Container();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyImpl <em>Technology Specific Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateTechnologySpecificProperty()
		 * @generated
		 */
		EClass INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY = eINSTANCE.getIntermediateTechnologySpecificProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__NAME = eINSTANCE.getIntermediateTechnologySpecificProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__TYPE = eINSTANCE.getIntermediateTechnologySpecificProperty_Type();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE = eINSTANCE.getIntermediateTechnologySpecificProperty_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Feature Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__FEATURE_NAMES = eINSTANCE.getIntermediateTechnologySpecificProperty_FeatureNames();

		/**
		 * The meta object literal for the '<em><b>Operation Technology</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__OPERATION_TECHNOLOGY = eINSTANCE.getIntermediateTechnologySpecificProperty_OperationTechnology();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyValueImpl <em>Technology Specific Property Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateTechnologySpecificPropertyValueImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateTechnologySpecificPropertyValue()
		 * @generated
		 */
		EClass INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE = eINSTANCE.getIntermediateTechnologySpecificPropertyValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__VALUE = eINSTANCE.getIntermediateTechnologySpecificPropertyValue_Value();

		/**
		 * The meta object literal for the '<em><b>Technology Specific Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__TECHNOLOGY_SPECIFIC_PROPERTY = eINSTANCE.getIntermediateTechnologySpecificPropertyValue_TechnologySpecificProperty();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__SPECIFICATION = eINSTANCE.getIntermediateTechnologySpecificPropertyValue_Specification();

		/**
		 * The meta object literal for the '<em><b>Operation Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__OPERATION_NODE = eINSTANCE.getIntermediateTechnologySpecificPropertyValue_OperationNode();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.OperationMicroserviceReferenceImpl <em>Operation Microservice Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.OperationMicroserviceReferenceImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getOperationMicroserviceReference()
		 * @generated
		 */
		EClass OPERATION_MICROSERVICE_REFERENCE = eINSTANCE.getOperationMicroserviceReference();

		/**
		 * The meta object literal for the '<em><b>Effectively Implemented</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_MICROSERVICE_REFERENCE__EFFECTIVELY_IMPLEMENTED = eINSTANCE.getOperationMicroserviceReference_EffectivelyImplemented();

		/**
		 * The meta object literal for the '<em><b>Microservice Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_MICROSERVICE_REFERENCE__MICROSERVICE_TYPE = eINSTANCE.getOperationMicroserviceReference_MicroserviceType();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_MICROSERVICE_REFERENCE__VISIBILITY = eINSTANCE.getOperationMicroserviceReference_Visibility();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_MICROSERVICE_REFERENCE__NODE = eINSTANCE.getOperationMicroserviceReference_Node();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateEndpointTechnologyImpl <em>Endpoint Technology</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateEndpointTechnologyImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateEndpointTechnology()
		 * @generated
		 */
		EClass INTERMEDIATE_ENDPOINT_TECHNOLOGY = eINSTANCE.getIntermediateEndpointTechnology();

		/**
		 * The meta object literal for the '<em><b>Endpoint</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT = eINSTANCE.getIntermediateEndpointTechnology_Endpoint();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationEndpointImpl <em>Operation Endpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationEndpointImpl
		 * @see de.fhdo.lemma.operation.intermediate.impl.IntermediatePackageImpl#getIntermediateOperationEndpoint()
		 * @generated
		 */
		EClass INTERMEDIATE_OPERATION_ENDPOINT = eINSTANCE.getIntermediateOperationEndpoint();

		/**
		 * The meta object literal for the '<em><b>Endpoint Technology</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_ENDPOINT__ENDPOINT_TECHNOLOGY = eINSTANCE.getIntermediateOperationEndpoint_EndpointTechnology();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_OPERATION_ENDPOINT__NODE = eINSTANCE.getIntermediateOperationEndpoint_Node();

	}

} //IntermediatePackage
