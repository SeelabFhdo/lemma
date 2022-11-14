/**
 */
package de.fhdo.lemma.service.intermediate;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see de.fhdo.lemma.service.intermediate.IntermediateFactory
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
    String eNS_URI = "http://www.fhdo.de/lemma/service/intermediate";

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
    IntermediatePackage eINSTANCE = de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl.init();

    /**
     * The meta object id for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateServiceModelImpl <em>Service Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediateServiceModelImpl
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateServiceModel()
     * @generated
     */
    int INTERMEDIATE_SERVICE_MODEL = 0;

    /**
     * The feature id for the '<em><b>Source Model Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_SERVICE_MODEL__SOURCE_MODEL_URI = 0;

    /**
     * The feature id for the '<em><b>Imports</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_SERVICE_MODEL__IMPORTS = 1;

    /**
     * The feature id for the '<em><b>Microservices</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_SERVICE_MODEL__MICROSERVICES = 2;

    /**
     * The number of structural features of the '<em>Service Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_SERVICE_MODEL_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Service Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_SERVICE_MODEL_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl <em>Microservice</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateMicroservice()
     * @generated
     */
    int INTERMEDIATE_MICROSERVICE = 1;

    /**
     * The feature id for the '<em><b>Source Model Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_MICROSERVICE__SOURCE_MODEL_URI = 0;

    /**
     * The feature id for the '<em><b>Source Mapping Model Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_MICROSERVICE__SOURCE_MAPPING_MODEL_URI = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_MICROSERVICE__NAME = 2;

    /**
     * The feature id for the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_MICROSERVICE__VERSION = 3;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_MICROSERVICE__QUALIFIED_NAME = 4;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_MICROSERVICE__TYPE = 5;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_MICROSERVICE__VISIBILITY = 6;

    /**
     * The feature id for the '<em><b>Effectively Implemented</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_MICROSERVICE__EFFECTIVELY_IMPLEMENTED = 7;

    /**
     * The feature id for the '<em><b>Technologies</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_MICROSERVICE__TECHNOLOGIES = 8;

    /**
     * The feature id for the '<em><b>Endpoints</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_MICROSERVICE__ENDPOINTS = 9;

    /**
     * The feature id for the '<em><b>Protocols</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_MICROSERVICE__PROTOCOLS = 10;

    /**
     * The feature id for the '<em><b>Required Microservices</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_MICROSERVICE__REQUIRED_MICROSERVICES = 11;

    /**
     * The feature id for the '<em><b>Required Interfaces</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_MICROSERVICE__REQUIRED_INTERFACES = 12;

    /**
     * The feature id for the '<em><b>Required Operations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_MICROSERVICE__REQUIRED_OPERATIONS = 13;

    /**
     * The feature id for the '<em><b>Interfaces</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_MICROSERVICE__INTERFACES = 14;

    /**
     * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_MICROSERVICE__ASPECTS = 15;

    /**
     * The feature id for the '<em><b>Service Model</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_MICROSERVICE__SERVICE_MODEL = 16;

    /**
     * The number of structural features of the '<em>Microservice</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_MICROSERVICE_FEATURE_COUNT = 17;

    /**
     * The number of operations of the '<em>Microservice</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_MICROSERVICE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateInterfaceImpl <em>Interface</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediateInterfaceImpl
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateInterface()
     * @generated
     */
    int INTERMEDIATE_INTERFACE = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_INTERFACE__NAME = 0;

    /**
     * The feature id for the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_INTERFACE__VERSION = 1;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_INTERFACE__QUALIFIED_NAME = 2;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_INTERFACE__VISIBILITY = 3;

    /**
     * The feature id for the '<em><b>Not Implemented</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_INTERFACE__NOT_IMPLEMENTED = 4;

    /**
     * The feature id for the '<em><b>Has Implemented Operations</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_INTERFACE__HAS_IMPLEMENTED_OPERATIONS = 5;

    /**
     * The feature id for the '<em><b>Endpoints</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_INTERFACE__ENDPOINTS = 6;

    /**
     * The feature id for the '<em><b>Protocols</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_INTERFACE__PROTOCOLS = 7;

    /**
     * The feature id for the '<em><b>Operations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_INTERFACE__OPERATIONS = 8;

    /**
     * The feature id for the '<em><b>Referred Operations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_INTERFACE__REFERRED_OPERATIONS = 9;

    /**
     * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_INTERFACE__ASPECTS = 10;

    /**
     * The feature id for the '<em><b>Microservice</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_INTERFACE__MICROSERVICE = 11;

    /**
     * The number of structural features of the '<em>Interface</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_INTERFACE_FEATURE_COUNT = 12;

    /**
     * The number of operations of the '<em>Interface</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_INTERFACE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateOperationImpl <em>Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediateOperationImpl
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateOperation()
     * @generated
     */
    int INTERMEDIATE_OPERATION = 3;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_OPERATION__NAME = 0;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_OPERATION__QUALIFIED_NAME = 1;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_OPERATION__VISIBILITY = 2;

    /**
     * The feature id for the '<em><b>Not Implemented</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_OPERATION__NOT_IMPLEMENTED = 3;

    /**
     * The feature id for the '<em><b>Api Operation Comment</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_OPERATION__API_OPERATION_COMMENT = 4;

    /**
     * The feature id for the '<em><b>Endpoints</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_OPERATION__ENDPOINTS = 5;

    /**
     * The feature id for the '<em><b>Protocols</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_OPERATION__PROTOCOLS = 6;

    /**
     * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_OPERATION__ASPECTS = 7;

    /**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_OPERATION__PARAMETERS = 8;

    /**
     * The feature id for the '<em><b>Interface</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_OPERATION__INTERFACE = 9;

    /**
     * The number of structural features of the '<em>Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_OPERATION_FEATURE_COUNT = 10;

    /**
     * The number of operations of the '<em>Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_OPERATION_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateApiOperationCommentImpl <em>Api Operation Comment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediateApiOperationCommentImpl
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateApiOperationComment()
     * @generated
     */
    int INTERMEDIATE_API_OPERATION_COMMENT = 4;

    /**
     * The feature id for the '<em><b>Comment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_API_OPERATION_COMMENT__COMMENT = 0;

    /**
     * The feature id for the '<em><b>Parameter Comments</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_API_OPERATION_COMMENT__PARAMETER_COMMENTS = 1;

    /**
     * The feature id for the '<em><b>Operation</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_API_OPERATION_COMMENT__OPERATION = 2;

    /**
     * The number of structural features of the '<em>Api Operation Comment</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_API_OPERATION_COMMENT_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Api Operation Comment</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_API_OPERATION_COMMENT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateApiParameterCommentImpl <em>Api Parameter Comment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediateApiParameterCommentImpl
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateApiParameterComment()
     * @generated
     */
    int INTERMEDIATE_API_PARAMETER_COMMENT = 5;

    /**
     * The feature id for the '<em><b>Comment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_API_PARAMETER_COMMENT__COMMENT = 0;

    /**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_API_PARAMETER_COMMENT__REQUIRED = 1;

    /**
     * The feature id for the '<em><b>Returned</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_API_PARAMETER_COMMENT__RETURNED = 2;

    /**
     * The feature id for the '<em><b>Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_API_PARAMETER_COMMENT__PARAMETER = 3;

    /**
     * The feature id for the '<em><b>Operation Comment</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_API_PARAMETER_COMMENT__OPERATION_COMMENT = 4;

    /**
     * The number of structural features of the '<em>Api Parameter Comment</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_API_PARAMETER_COMMENT_FEATURE_COUNT = 5;

    /**
     * The number of operations of the '<em>Api Parameter Comment</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_API_PARAMETER_COMMENT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateReferredOperationImpl <em>Referred Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediateReferredOperationImpl
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateReferredOperation()
     * @generated
     */
    int INTERMEDIATE_REFERRED_OPERATION = 6;

    /**
     * The feature id for the '<em><b>Name In Referring Interface</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_REFERRED_OPERATION__NAME_IN_REFERRING_INTERFACE = 0;

    /**
     * The feature id for the '<em><b>Qualified Name In Referring Interface</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_REFERRED_OPERATION__QUALIFIED_NAME_IN_REFERRING_INTERFACE = 1;

    /**
     * The feature id for the '<em><b>Operation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_REFERRED_OPERATION__OPERATION = 2;

    /**
     * The feature id for the '<em><b>Endpoints</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_REFERRED_OPERATION__ENDPOINTS = 3;

    /**
     * The feature id for the '<em><b>Protocols</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_REFERRED_OPERATION__PROTOCOLS = 4;

    /**
     * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_REFERRED_OPERATION__ASPECTS = 5;

    /**
     * The feature id for the '<em><b>Referring Interface</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_REFERRED_OPERATION__REFERRING_INTERFACE = 6;

    /**
     * The number of structural features of the '<em>Referred Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_REFERRED_OPERATION_FEATURE_COUNT = 7;

    /**
     * The number of operations of the '<em>Referred Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_REFERRED_OPERATION_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediateParameterImpl
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateParameter()
     * @generated
     */
    int INTERMEDIATE_PARAMETER = 7;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PARAMETER__NAME = 0;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PARAMETER__QUALIFIED_NAME = 1;

    /**
     * The feature id for the '<em><b>Exchange Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PARAMETER__EXCHANGE_PATTERN = 2;

    /**
     * The feature id for the '<em><b>Communication Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PARAMETER__COMMUNICATION_TYPE = 3;

    /**
     * The feature id for the '<em><b>Communicates Fault</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PARAMETER__COMMUNICATES_FAULT = 4;

    /**
     * The feature id for the '<em><b>Optional</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PARAMETER__OPTIONAL = 5;

    /**
     * The feature id for the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PARAMETER__TYPE = 6;

    /**
     * The feature id for the '<em><b>Original Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PARAMETER__ORIGINAL_TYPE = 7;

    /**
     * The feature id for the '<em><b>Initialized By Operation</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PARAMETER__INITIALIZED_BY_OPERATION = 8;

    /**
     * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PARAMETER__ASPECTS = 9;

    /**
     * The feature id for the '<em><b>Field Aspects</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PARAMETER__FIELD_ASPECTS = 10;

    /**
     * The feature id for the '<em><b>Operation</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PARAMETER__OPERATION = 11;

    /**
     * The number of structural features of the '<em>Parameter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PARAMETER_FEATURE_COUNT = 12;

    /**
     * The number of operations of the '<em>Parameter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PARAMETER_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.fhdo.lemma.service.intermediate.impl.DataFieldAspectsImpl <em>Data Field Aspects</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.lemma.service.intermediate.impl.DataFieldAspectsImpl
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getDataFieldAspects()
     * @generated
     */
    int DATA_FIELD_ASPECTS = 8;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_FIELD_ASPECTS__NAME = 0;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_FIELD_ASPECTS__QUALIFIED_NAME = 1;

    /**
     * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_FIELD_ASPECTS__ASPECTS = 2;

    /**
     * The feature id for the '<em><b>Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_FIELD_ASPECTS__PARAMETER = 3;

    /**
     * The number of structural features of the '<em>Data Field Aspects</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_FIELD_ASPECTS_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>Data Field Aspects</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_FIELD_ASPECTS_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.fhdo.lemma.service.intermediate.impl.MicroserviceReferenceImpl <em>Microservice Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.lemma.service.intermediate.impl.MicroserviceReferenceImpl
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getMicroserviceReference()
     * @generated
     */
    int MICROSERVICE_REFERENCE = 9;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MICROSERVICE_REFERENCE__NAME = 0;

    /**
     * The feature id for the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MICROSERVICE_REFERENCE__VERSION = 1;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MICROSERVICE_REFERENCE__QUALIFIED_NAME = 2;

    /**
     * The feature id for the '<em><b>Imported</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MICROSERVICE_REFERENCE__IMPORTED = 3;

    /**
     * The feature id for the '<em><b>Import</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MICROSERVICE_REFERENCE__IMPORT = 4;

    /**
     * The feature id for the '<em><b>Local Microservice</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MICROSERVICE_REFERENCE__LOCAL_MICROSERVICE = 5;

    /**
     * The feature id for the '<em><b>Requiring Microservice</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MICROSERVICE_REFERENCE__REQUIRING_MICROSERVICE = 6;

    /**
     * The number of structural features of the '<em>Microservice Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MICROSERVICE_REFERENCE_FEATURE_COUNT = 7;

    /**
     * The number of operations of the '<em>Microservice Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MICROSERVICE_REFERENCE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.fhdo.lemma.service.intermediate.impl.InterfaceReferenceImpl <em>Interface Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.lemma.service.intermediate.impl.InterfaceReferenceImpl
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getInterfaceReference()
     * @generated
     */
    int INTERFACE_REFERENCE = 10;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERFACE_REFERENCE__NAME = 0;

    /**
     * The feature id for the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERFACE_REFERENCE__VERSION = 1;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERFACE_REFERENCE__QUALIFIED_NAME = 2;

    /**
     * The feature id for the '<em><b>Imported</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERFACE_REFERENCE__IMPORTED = 3;

    /**
     * The feature id for the '<em><b>Import</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERFACE_REFERENCE__IMPORT = 4;

    /**
     * The feature id for the '<em><b>Local Interface</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERFACE_REFERENCE__LOCAL_INTERFACE = 5;

    /**
     * The feature id for the '<em><b>Requiring Microservice</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERFACE_REFERENCE__REQUIRING_MICROSERVICE = 6;

    /**
     * The number of structural features of the '<em>Interface Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERFACE_REFERENCE_FEATURE_COUNT = 7;

    /**
     * The number of operations of the '<em>Interface Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERFACE_REFERENCE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.fhdo.lemma.service.intermediate.impl.OperationReferenceImpl <em>Operation Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.lemma.service.intermediate.impl.OperationReferenceImpl
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getOperationReference()
     * @generated
     */
    int OPERATION_REFERENCE = 11;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPERATION_REFERENCE__NAME = 0;

    /**
     * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPERATION_REFERENCE__QUALIFIED_NAME = 1;

    /**
     * The feature id for the '<em><b>Imported</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPERATION_REFERENCE__IMPORTED = 2;

    /**
     * The feature id for the '<em><b>Import</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPERATION_REFERENCE__IMPORT = 3;

    /**
     * The feature id for the '<em><b>Local Operation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPERATION_REFERENCE__LOCAL_OPERATION = 4;

    /**
     * The feature id for the '<em><b>Requiring Microservice</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPERATION_REFERENCE__REQUIRING_MICROSERVICE = 5;

    /**
     * The feature id for the '<em><b>Initialized Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPERATION_REFERENCE__INITIALIZED_PARAMETER = 6;

    /**
     * The number of structural features of the '<em>Operation Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPERATION_REFERENCE_FEATURE_COUNT = 7;

    /**
     * The number of operations of the '<em>Operation Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPERATION_REFERENCE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateTechnologyImpl <em>Technology</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediateTechnologyImpl
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateTechnology()
     * @generated
     */
    int INTERMEDIATE_TECHNOLOGY = 12;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_TECHNOLOGY__NAME = 0;

    /**
     * The feature id for the '<em><b>Import</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_TECHNOLOGY__IMPORT = 1;

    /**
     * The feature id for the '<em><b>Microservice</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_TECHNOLOGY__MICROSERVICE = 2;

    /**
     * The number of structural features of the '<em>Technology</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_TECHNOLOGY_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Technology</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_TECHNOLOGY_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateEndpointImpl <em>Endpoint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediateEndpointImpl
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateEndpoint()
     * @generated
     */
    int INTERMEDIATE_ENDPOINT = 13;

    /**
     * The feature id for the '<em><b>Communication Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_ENDPOINT__COMMUNICATION_TYPE = 0;

    /**
     * The feature id for the '<em><b>Protocol</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_ENDPOINT__PROTOCOL = 1;

    /**
     * The feature id for the '<em><b>Data Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_ENDPOINT__DATA_FORMAT = 2;

    /**
     * The feature id for the '<em><b>Addresses</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_ENDPOINT__ADDRESSES = 3;

    /**
     * The feature id for the '<em><b>Technology</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_ENDPOINT__TECHNOLOGY = 4;

    /**
     * The feature id for the '<em><b>Microservice</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_ENDPOINT__MICROSERVICE = 5;

    /**
     * The feature id for the '<em><b>Interface</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_ENDPOINT__INTERFACE = 6;

    /**
     * The feature id for the '<em><b>Operation</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_ENDPOINT__OPERATION = 7;

    /**
     * The feature id for the '<em><b>Referred Operation</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_ENDPOINT__REFERRED_OPERATION = 8;

    /**
     * The number of structural features of the '<em>Endpoint</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_ENDPOINT_FEATURE_COUNT = 9;

    /**
     * The number of operations of the '<em>Endpoint</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_ENDPOINT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateProtocolSpecificationImpl <em>Protocol Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediateProtocolSpecificationImpl
     * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateProtocolSpecification()
     * @generated
     */
    int INTERMEDIATE_PROTOCOL_SPECIFICATION = 14;

    /**
     * The feature id for the '<em><b>Communication Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE = 0;

    /**
     * The feature id for the '<em><b>Protocol</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PROTOCOL_SPECIFICATION__PROTOCOL = 1;

    /**
     * The feature id for the '<em><b>Data Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PROTOCOL_SPECIFICATION__DATA_FORMAT = 2;

    /**
     * The number of structural features of the '<em>Protocol Specification</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PROTOCOL_SPECIFICATION_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Protocol Specification</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PROTOCOL_SPECIFICATION_OPERATION_COUNT = 0;


    /**
     * Returns the meta object for class '{@link de.fhdo.lemma.service.intermediate.IntermediateServiceModel <em>Service Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Service Model</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateServiceModel
     * @generated
     */
    EClass getIntermediateServiceModel();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateServiceModel#getSourceModelUri <em>Source Model Uri</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Source Model Uri</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateServiceModel#getSourceModelUri()
     * @see #getIntermediateServiceModel()
     * @generated
     */
    EAttribute getIntermediateServiceModel_SourceModelUri();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateServiceModel#getImports <em>Imports</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Imports</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateServiceModel#getImports()
     * @see #getIntermediateServiceModel()
     * @generated
     */
    EReference getIntermediateServiceModel_Imports();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateServiceModel#getMicroservices <em>Microservices</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Microservices</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateServiceModel#getMicroservices()
     * @see #getIntermediateServiceModel()
     * @generated
     */
    EReference getIntermediateServiceModel_Microservices();

    /**
     * Returns the meta object for class '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice <em>Microservice</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Microservice</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice
     * @generated
     */
    EClass getIntermediateMicroservice();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getSourceModelUri <em>Source Model Uri</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Source Model Uri</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getSourceModelUri()
     * @see #getIntermediateMicroservice()
     * @generated
     */
    EAttribute getIntermediateMicroservice_SourceModelUri();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getSourceMappingModelUri <em>Source Mapping Model Uri</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Source Mapping Model Uri</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getSourceMappingModelUri()
     * @see #getIntermediateMicroservice()
     * @generated
     */
    EAttribute getIntermediateMicroservice_SourceMappingModelUri();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getName()
     * @see #getIntermediateMicroservice()
     * @generated
     */
    EAttribute getIntermediateMicroservice_Name();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getVersion <em>Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Version</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getVersion()
     * @see #getIntermediateMicroservice()
     * @generated
     */
    EAttribute getIntermediateMicroservice_Version();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getQualifiedName <em>Qualified Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Qualified Name</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getQualifiedName()
     * @see #getIntermediateMicroservice()
     * @generated
     */
    EAttribute getIntermediateMicroservice_QualifiedName();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getType()
     * @see #getIntermediateMicroservice()
     * @generated
     */
    EAttribute getIntermediateMicroservice_Type();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getVisibility <em>Visibility</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Visibility</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getVisibility()
     * @see #getIntermediateMicroservice()
     * @generated
     */
    EAttribute getIntermediateMicroservice_Visibility();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#isEffectivelyImplemented <em>Effectively Implemented</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Effectively Implemented</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#isEffectivelyImplemented()
     * @see #getIntermediateMicroservice()
     * @generated
     */
    EAttribute getIntermediateMicroservice_EffectivelyImplemented();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getTechnologies <em>Technologies</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Technologies</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getTechnologies()
     * @see #getIntermediateMicroservice()
     * @generated
     */
    EReference getIntermediateMicroservice_Technologies();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getEndpoints <em>Endpoints</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Endpoints</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getEndpoints()
     * @see #getIntermediateMicroservice()
     * @generated
     */
    EReference getIntermediateMicroservice_Endpoints();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getProtocols <em>Protocols</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Protocols</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getProtocols()
     * @see #getIntermediateMicroservice()
     * @generated
     */
    EReference getIntermediateMicroservice_Protocols();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getRequiredMicroservices <em>Required Microservices</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Required Microservices</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getRequiredMicroservices()
     * @see #getIntermediateMicroservice()
     * @generated
     */
    EReference getIntermediateMicroservice_RequiredMicroservices();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getRequiredInterfaces <em>Required Interfaces</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Required Interfaces</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getRequiredInterfaces()
     * @see #getIntermediateMicroservice()
     * @generated
     */
    EReference getIntermediateMicroservice_RequiredInterfaces();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getRequiredOperations <em>Required Operations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Required Operations</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getRequiredOperations()
     * @see #getIntermediateMicroservice()
     * @generated
     */
    EReference getIntermediateMicroservice_RequiredOperations();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getInterfaces <em>Interfaces</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Interfaces</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getInterfaces()
     * @see #getIntermediateMicroservice()
     * @generated
     */
    EReference getIntermediateMicroservice_Interfaces();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getAspects <em>Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Aspects</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getAspects()
     * @see #getIntermediateMicroservice()
     * @generated
     */
    EReference getIntermediateMicroservice_Aspects();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getServiceModel <em>Service Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Service Model</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getServiceModel()
     * @see #getIntermediateMicroservice()
     * @generated
     */
    EReference getIntermediateMicroservice_ServiceModel();

    /**
     * Returns the meta object for class '{@link de.fhdo.lemma.service.intermediate.IntermediateInterface <em>Interface</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Interface</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateInterface
     * @generated
     */
    EClass getIntermediateInterface();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateInterface#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateInterface#getName()
     * @see #getIntermediateInterface()
     * @generated
     */
    EAttribute getIntermediateInterface_Name();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateInterface#getVersion <em>Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Version</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateInterface#getVersion()
     * @see #getIntermediateInterface()
     * @generated
     */
    EAttribute getIntermediateInterface_Version();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateInterface#getQualifiedName <em>Qualified Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Qualified Name</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateInterface#getQualifiedName()
     * @see #getIntermediateInterface()
     * @generated
     */
    EAttribute getIntermediateInterface_QualifiedName();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateInterface#getVisibility <em>Visibility</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Visibility</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateInterface#getVisibility()
     * @see #getIntermediateInterface()
     * @generated
     */
    EAttribute getIntermediateInterface_Visibility();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateInterface#isNotImplemented <em>Not Implemented</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Not Implemented</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateInterface#isNotImplemented()
     * @see #getIntermediateInterface()
     * @generated
     */
    EAttribute getIntermediateInterface_NotImplemented();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateInterface#isHasImplementedOperations <em>Has Implemented Operations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Has Implemented Operations</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateInterface#isHasImplementedOperations()
     * @see #getIntermediateInterface()
     * @generated
     */
    EAttribute getIntermediateInterface_HasImplementedOperations();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateInterface#getEndpoints <em>Endpoints</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Endpoints</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateInterface#getEndpoints()
     * @see #getIntermediateInterface()
     * @generated
     */
    EReference getIntermediateInterface_Endpoints();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateInterface#getProtocols <em>Protocols</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Protocols</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateInterface#getProtocols()
     * @see #getIntermediateInterface()
     * @generated
     */
    EReference getIntermediateInterface_Protocols();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateInterface#getOperations <em>Operations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Operations</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateInterface#getOperations()
     * @see #getIntermediateInterface()
     * @generated
     */
    EReference getIntermediateInterface_Operations();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateInterface#getReferredOperations <em>Referred Operations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Referred Operations</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateInterface#getReferredOperations()
     * @see #getIntermediateInterface()
     * @generated
     */
    EReference getIntermediateInterface_ReferredOperations();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateInterface#getAspects <em>Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Aspects</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateInterface#getAspects()
     * @see #getIntermediateInterface()
     * @generated
     */
    EReference getIntermediateInterface_Aspects();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.intermediate.IntermediateInterface#getMicroservice <em>Microservice</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Microservice</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateInterface#getMicroservice()
     * @see #getIntermediateInterface()
     * @generated
     */
    EReference getIntermediateInterface_Microservice();

    /**
     * Returns the meta object for class '{@link de.fhdo.lemma.service.intermediate.IntermediateOperation <em>Operation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Operation</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateOperation
     * @generated
     */
    EClass getIntermediateOperation();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateOperation#getName()
     * @see #getIntermediateOperation()
     * @generated
     */
    EAttribute getIntermediateOperation_Name();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getQualifiedName <em>Qualified Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Qualified Name</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateOperation#getQualifiedName()
     * @see #getIntermediateOperation()
     * @generated
     */
    EAttribute getIntermediateOperation_QualifiedName();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getVisibility <em>Visibility</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Visibility</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateOperation#getVisibility()
     * @see #getIntermediateOperation()
     * @generated
     */
    EAttribute getIntermediateOperation_Visibility();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#isNotImplemented <em>Not Implemented</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Not Implemented</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateOperation#isNotImplemented()
     * @see #getIntermediateOperation()
     * @generated
     */
    EAttribute getIntermediateOperation_NotImplemented();

    /**
     * Returns the meta object for the containment reference '{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getApiOperationComment <em>Api Operation Comment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Api Operation Comment</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateOperation#getApiOperationComment()
     * @see #getIntermediateOperation()
     * @generated
     */
    EReference getIntermediateOperation_ApiOperationComment();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getEndpoints <em>Endpoints</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Endpoints</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateOperation#getEndpoints()
     * @see #getIntermediateOperation()
     * @generated
     */
    EReference getIntermediateOperation_Endpoints();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getProtocols <em>Protocols</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Protocols</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateOperation#getProtocols()
     * @see #getIntermediateOperation()
     * @generated
     */
    EReference getIntermediateOperation_Protocols();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getAspects <em>Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Aspects</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateOperation#getAspects()
     * @see #getIntermediateOperation()
     * @generated
     */
    EReference getIntermediateOperation_Aspects();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getParameters <em>Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Parameters</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateOperation#getParameters()
     * @see #getIntermediateOperation()
     * @generated
     */
    EReference getIntermediateOperation_Parameters();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getInterface <em>Interface</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Interface</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateOperation#getInterface()
     * @see #getIntermediateOperation()
     * @generated
     */
    EReference getIntermediateOperation_Interface();

    /**
     * Returns the meta object for class '{@link de.fhdo.lemma.service.intermediate.IntermediateApiOperationComment <em>Api Operation Comment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Api Operation Comment</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateApiOperationComment
     * @generated
     */
    EClass getIntermediateApiOperationComment();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateApiOperationComment#getComment <em>Comment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Comment</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateApiOperationComment#getComment()
     * @see #getIntermediateApiOperationComment()
     * @generated
     */
    EAttribute getIntermediateApiOperationComment_Comment();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateApiOperationComment#getParameterComments <em>Parameter Comments</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Parameter Comments</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateApiOperationComment#getParameterComments()
     * @see #getIntermediateApiOperationComment()
     * @generated
     */
    EReference getIntermediateApiOperationComment_ParameterComments();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.intermediate.IntermediateApiOperationComment#getOperation <em>Operation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Operation</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateApiOperationComment#getOperation()
     * @see #getIntermediateApiOperationComment()
     * @generated
     */
    EReference getIntermediateApiOperationComment_Operation();

    /**
     * Returns the meta object for class '{@link de.fhdo.lemma.service.intermediate.IntermediateApiParameterComment <em>Api Parameter Comment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Api Parameter Comment</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateApiParameterComment
     * @generated
     */
    EClass getIntermediateApiParameterComment();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateApiParameterComment#getComment <em>Comment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Comment</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateApiParameterComment#getComment()
     * @see #getIntermediateApiParameterComment()
     * @generated
     */
    EAttribute getIntermediateApiParameterComment_Comment();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateApiParameterComment#isRequired <em>Required</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Required</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateApiParameterComment#isRequired()
     * @see #getIntermediateApiParameterComment()
     * @generated
     */
    EAttribute getIntermediateApiParameterComment_Required();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateApiParameterComment#isReturned <em>Returned</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Returned</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateApiParameterComment#isReturned()
     * @see #getIntermediateApiParameterComment()
     * @generated
     */
    EAttribute getIntermediateApiParameterComment_Returned();

    /**
     * Returns the meta object for the reference '{@link de.fhdo.lemma.service.intermediate.IntermediateApiParameterComment#getParameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Parameter</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateApiParameterComment#getParameter()
     * @see #getIntermediateApiParameterComment()
     * @generated
     */
    EReference getIntermediateApiParameterComment_Parameter();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.intermediate.IntermediateApiParameterComment#getOperationComment <em>Operation Comment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Operation Comment</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateApiParameterComment#getOperationComment()
     * @see #getIntermediateApiParameterComment()
     * @generated
     */
    EReference getIntermediateApiParameterComment_OperationComment();

    /**
     * Returns the meta object for class '{@link de.fhdo.lemma.service.intermediate.IntermediateReferredOperation <em>Referred Operation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Referred Operation</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateReferredOperation
     * @generated
     */
    EClass getIntermediateReferredOperation();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getNameInReferringInterface <em>Name In Referring Interface</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name In Referring Interface</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getNameInReferringInterface()
     * @see #getIntermediateReferredOperation()
     * @generated
     */
    EAttribute getIntermediateReferredOperation_NameInReferringInterface();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getQualifiedNameInReferringInterface <em>Qualified Name In Referring Interface</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Qualified Name In Referring Interface</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getQualifiedNameInReferringInterface()
     * @see #getIntermediateReferredOperation()
     * @generated
     */
    EAttribute getIntermediateReferredOperation_QualifiedNameInReferringInterface();

    /**
     * Returns the meta object for the reference '{@link de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getOperation <em>Operation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Operation</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getOperation()
     * @see #getIntermediateReferredOperation()
     * @generated
     */
    EReference getIntermediateReferredOperation_Operation();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getEndpoints <em>Endpoints</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Endpoints</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getEndpoints()
     * @see #getIntermediateReferredOperation()
     * @generated
     */
    EReference getIntermediateReferredOperation_Endpoints();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getProtocols <em>Protocols</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Protocols</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getProtocols()
     * @see #getIntermediateReferredOperation()
     * @generated
     */
    EReference getIntermediateReferredOperation_Protocols();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getAspects <em>Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Aspects</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getAspects()
     * @see #getIntermediateReferredOperation()
     * @generated
     */
    EReference getIntermediateReferredOperation_Aspects();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getReferringInterface <em>Referring Interface</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Referring Interface</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getReferringInterface()
     * @see #getIntermediateReferredOperation()
     * @generated
     */
    EReference getIntermediateReferredOperation_ReferringInterface();

    /**
     * Returns the meta object for class '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Parameter</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateParameter
     * @generated
     */
    EClass getIntermediateParameter();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateParameter#getName()
     * @see #getIntermediateParameter()
     * @generated
     */
    EAttribute getIntermediateParameter_Name();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getQualifiedName <em>Qualified Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Qualified Name</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateParameter#getQualifiedName()
     * @see #getIntermediateParameter()
     * @generated
     */
    EAttribute getIntermediateParameter_QualifiedName();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getExchangePattern <em>Exchange Pattern</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Exchange Pattern</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateParameter#getExchangePattern()
     * @see #getIntermediateParameter()
     * @generated
     */
    EAttribute getIntermediateParameter_ExchangePattern();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getCommunicationType <em>Communication Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Communication Type</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateParameter#getCommunicationType()
     * @see #getIntermediateParameter()
     * @generated
     */
    EAttribute getIntermediateParameter_CommunicationType();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#isCommunicatesFault <em>Communicates Fault</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Communicates Fault</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateParameter#isCommunicatesFault()
     * @see #getIntermediateParameter()
     * @generated
     */
    EAttribute getIntermediateParameter_CommunicatesFault();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#isOptional <em>Optional</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Optional</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateParameter#isOptional()
     * @see #getIntermediateParameter()
     * @generated
     */
    EAttribute getIntermediateParameter_Optional();

    /**
     * Returns the meta object for the containment reference '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Type</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateParameter#getType()
     * @see #getIntermediateParameter()
     * @generated
     */
    EReference getIntermediateParameter_Type();

    /**
     * Returns the meta object for the containment reference '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getOriginalType <em>Original Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Original Type</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateParameter#getOriginalType()
     * @see #getIntermediateParameter()
     * @generated
     */
    EReference getIntermediateParameter_OriginalType();

    /**
     * Returns the meta object for the containment reference '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getInitializedByOperation <em>Initialized By Operation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Initialized By Operation</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateParameter#getInitializedByOperation()
     * @see #getIntermediateParameter()
     * @generated
     */
    EReference getIntermediateParameter_InitializedByOperation();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getAspects <em>Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Aspects</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateParameter#getAspects()
     * @see #getIntermediateParameter()
     * @generated
     */
    EReference getIntermediateParameter_Aspects();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getFieldAspects <em>Field Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Field Aspects</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateParameter#getFieldAspects()
     * @see #getIntermediateParameter()
     * @generated
     */
    EReference getIntermediateParameter_FieldAspects();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getOperation <em>Operation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Operation</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateParameter#getOperation()
     * @see #getIntermediateParameter()
     * @generated
     */
    EReference getIntermediateParameter_Operation();

    /**
     * Returns the meta object for class '{@link de.fhdo.lemma.service.intermediate.DataFieldAspects <em>Data Field Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Field Aspects</em>'.
     * @see de.fhdo.lemma.service.intermediate.DataFieldAspects
     * @generated
     */
    EClass getDataFieldAspects();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.DataFieldAspects#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.fhdo.lemma.service.intermediate.DataFieldAspects#getName()
     * @see #getDataFieldAspects()
     * @generated
     */
    EAttribute getDataFieldAspects_Name();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.DataFieldAspects#getQualifiedName <em>Qualified Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Qualified Name</em>'.
     * @see de.fhdo.lemma.service.intermediate.DataFieldAspects#getQualifiedName()
     * @see #getDataFieldAspects()
     * @generated
     */
    EAttribute getDataFieldAspects_QualifiedName();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.intermediate.DataFieldAspects#getAspects <em>Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Aspects</em>'.
     * @see de.fhdo.lemma.service.intermediate.DataFieldAspects#getAspects()
     * @see #getDataFieldAspects()
     * @generated
     */
    EReference getDataFieldAspects_Aspects();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.intermediate.DataFieldAspects#getParameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Parameter</em>'.
     * @see de.fhdo.lemma.service.intermediate.DataFieldAspects#getParameter()
     * @see #getDataFieldAspects()
     * @generated
     */
    EReference getDataFieldAspects_Parameter();

    /**
     * Returns the meta object for class '{@link de.fhdo.lemma.service.intermediate.MicroserviceReference <em>Microservice Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Microservice Reference</em>'.
     * @see de.fhdo.lemma.service.intermediate.MicroserviceReference
     * @generated
     */
    EClass getMicroserviceReference();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.fhdo.lemma.service.intermediate.MicroserviceReference#getName()
     * @see #getMicroserviceReference()
     * @generated
     */
    EAttribute getMicroserviceReference_Name();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#getVersion <em>Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Version</em>'.
     * @see de.fhdo.lemma.service.intermediate.MicroserviceReference#getVersion()
     * @see #getMicroserviceReference()
     * @generated
     */
    EAttribute getMicroserviceReference_Version();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#getQualifiedName <em>Qualified Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Qualified Name</em>'.
     * @see de.fhdo.lemma.service.intermediate.MicroserviceReference#getQualifiedName()
     * @see #getMicroserviceReference()
     * @generated
     */
    EAttribute getMicroserviceReference_QualifiedName();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#isImported <em>Imported</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Imported</em>'.
     * @see de.fhdo.lemma.service.intermediate.MicroserviceReference#isImported()
     * @see #getMicroserviceReference()
     * @generated
     */
    EAttribute getMicroserviceReference_Imported();

    /**
     * Returns the meta object for the reference '{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#getImport <em>Import</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Import</em>'.
     * @see de.fhdo.lemma.service.intermediate.MicroserviceReference#getImport()
     * @see #getMicroserviceReference()
     * @generated
     */
    EReference getMicroserviceReference_Import();

    /**
     * Returns the meta object for the reference '{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#getLocalMicroservice <em>Local Microservice</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Local Microservice</em>'.
     * @see de.fhdo.lemma.service.intermediate.MicroserviceReference#getLocalMicroservice()
     * @see #getMicroserviceReference()
     * @generated
     */
    EReference getMicroserviceReference_LocalMicroservice();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.intermediate.MicroserviceReference#getRequiringMicroservice <em>Requiring Microservice</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Requiring Microservice</em>'.
     * @see de.fhdo.lemma.service.intermediate.MicroserviceReference#getRequiringMicroservice()
     * @see #getMicroserviceReference()
     * @generated
     */
    EReference getMicroserviceReference_RequiringMicroservice();

    /**
     * Returns the meta object for class '{@link de.fhdo.lemma.service.intermediate.InterfaceReference <em>Interface Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Interface Reference</em>'.
     * @see de.fhdo.lemma.service.intermediate.InterfaceReference
     * @generated
     */
    EClass getInterfaceReference();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.InterfaceReference#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.fhdo.lemma.service.intermediate.InterfaceReference#getName()
     * @see #getInterfaceReference()
     * @generated
     */
    EAttribute getInterfaceReference_Name();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.InterfaceReference#getVersion <em>Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Version</em>'.
     * @see de.fhdo.lemma.service.intermediate.InterfaceReference#getVersion()
     * @see #getInterfaceReference()
     * @generated
     */
    EAttribute getInterfaceReference_Version();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.InterfaceReference#getQualifiedName <em>Qualified Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Qualified Name</em>'.
     * @see de.fhdo.lemma.service.intermediate.InterfaceReference#getQualifiedName()
     * @see #getInterfaceReference()
     * @generated
     */
    EAttribute getInterfaceReference_QualifiedName();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.InterfaceReference#isImported <em>Imported</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Imported</em>'.
     * @see de.fhdo.lemma.service.intermediate.InterfaceReference#isImported()
     * @see #getInterfaceReference()
     * @generated
     */
    EAttribute getInterfaceReference_Imported();

    /**
     * Returns the meta object for the reference '{@link de.fhdo.lemma.service.intermediate.InterfaceReference#getImport <em>Import</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Import</em>'.
     * @see de.fhdo.lemma.service.intermediate.InterfaceReference#getImport()
     * @see #getInterfaceReference()
     * @generated
     */
    EReference getInterfaceReference_Import();

    /**
     * Returns the meta object for the reference '{@link de.fhdo.lemma.service.intermediate.InterfaceReference#getLocalInterface <em>Local Interface</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Local Interface</em>'.
     * @see de.fhdo.lemma.service.intermediate.InterfaceReference#getLocalInterface()
     * @see #getInterfaceReference()
     * @generated
     */
    EReference getInterfaceReference_LocalInterface();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.intermediate.InterfaceReference#getRequiringMicroservice <em>Requiring Microservice</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Requiring Microservice</em>'.
     * @see de.fhdo.lemma.service.intermediate.InterfaceReference#getRequiringMicroservice()
     * @see #getInterfaceReference()
     * @generated
     */
    EReference getInterfaceReference_RequiringMicroservice();

    /**
     * Returns the meta object for class '{@link de.fhdo.lemma.service.intermediate.OperationReference <em>Operation Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Operation Reference</em>'.
     * @see de.fhdo.lemma.service.intermediate.OperationReference
     * @generated
     */
    EClass getOperationReference();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.OperationReference#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.fhdo.lemma.service.intermediate.OperationReference#getName()
     * @see #getOperationReference()
     * @generated
     */
    EAttribute getOperationReference_Name();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.OperationReference#getQualifiedName <em>Qualified Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Qualified Name</em>'.
     * @see de.fhdo.lemma.service.intermediate.OperationReference#getQualifiedName()
     * @see #getOperationReference()
     * @generated
     */
    EAttribute getOperationReference_QualifiedName();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.OperationReference#isImported <em>Imported</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Imported</em>'.
     * @see de.fhdo.lemma.service.intermediate.OperationReference#isImported()
     * @see #getOperationReference()
     * @generated
     */
    EAttribute getOperationReference_Imported();

    /**
     * Returns the meta object for the reference '{@link de.fhdo.lemma.service.intermediate.OperationReference#getImport <em>Import</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Import</em>'.
     * @see de.fhdo.lemma.service.intermediate.OperationReference#getImport()
     * @see #getOperationReference()
     * @generated
     */
    EReference getOperationReference_Import();

    /**
     * Returns the meta object for the reference '{@link de.fhdo.lemma.service.intermediate.OperationReference#getLocalOperation <em>Local Operation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Local Operation</em>'.
     * @see de.fhdo.lemma.service.intermediate.OperationReference#getLocalOperation()
     * @see #getOperationReference()
     * @generated
     */
    EReference getOperationReference_LocalOperation();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.intermediate.OperationReference#getRequiringMicroservice <em>Requiring Microservice</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Requiring Microservice</em>'.
     * @see de.fhdo.lemma.service.intermediate.OperationReference#getRequiringMicroservice()
     * @see #getOperationReference()
     * @generated
     */
    EReference getOperationReference_RequiringMicroservice();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.intermediate.OperationReference#getInitializedParameter <em>Initialized Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Initialized Parameter</em>'.
     * @see de.fhdo.lemma.service.intermediate.OperationReference#getInitializedParameter()
     * @see #getOperationReference()
     * @generated
     */
    EReference getOperationReference_InitializedParameter();

    /**
     * Returns the meta object for class '{@link de.fhdo.lemma.service.intermediate.IntermediateTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Technology</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateTechnology
     * @generated
     */
    EClass getIntermediateTechnology();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateTechnology#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateTechnology#getName()
     * @see #getIntermediateTechnology()
     * @generated
     */
    EAttribute getIntermediateTechnology_Name();

    /**
     * Returns the meta object for the reference '{@link de.fhdo.lemma.service.intermediate.IntermediateTechnology#getImport <em>Import</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Import</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateTechnology#getImport()
     * @see #getIntermediateTechnology()
     * @generated
     */
    EReference getIntermediateTechnology_Import();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.intermediate.IntermediateTechnology#getMicroservice <em>Microservice</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Microservice</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateTechnology#getMicroservice()
     * @see #getIntermediateTechnology()
     * @generated
     */
    EReference getIntermediateTechnology_Microservice();

    /**
     * Returns the meta object for class '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint <em>Endpoint</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Endpoint</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateEndpoint
     * @generated
     */
    EClass getIntermediateEndpoint();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getCommunicationType <em>Communication Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Communication Type</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getCommunicationType()
     * @see #getIntermediateEndpoint()
     * @generated
     */
    EAttribute getIntermediateEndpoint_CommunicationType();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getProtocol <em>Protocol</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Protocol</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getProtocol()
     * @see #getIntermediateEndpoint()
     * @generated
     */
    EAttribute getIntermediateEndpoint_Protocol();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getDataFormat <em>Data Format</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Data Format</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getDataFormat()
     * @see #getIntermediateEndpoint()
     * @generated
     */
    EAttribute getIntermediateEndpoint_DataFormat();

    /**
     * Returns the meta object for the attribute list '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getAddresses <em>Addresses</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Addresses</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getAddresses()
     * @see #getIntermediateEndpoint()
     * @generated
     */
    EAttribute getIntermediateEndpoint_Addresses();

    /**
     * Returns the meta object for the reference '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getTechnology <em>Technology</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Technology</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getTechnology()
     * @see #getIntermediateEndpoint()
     * @generated
     */
    EReference getIntermediateEndpoint_Technology();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getMicroservice <em>Microservice</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Microservice</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getMicroservice()
     * @see #getIntermediateEndpoint()
     * @generated
     */
    EReference getIntermediateEndpoint_Microservice();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getInterface <em>Interface</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Interface</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getInterface()
     * @see #getIntermediateEndpoint()
     * @generated
     */
    EReference getIntermediateEndpoint_Interface();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getOperation <em>Operation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Operation</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getOperation()
     * @see #getIntermediateEndpoint()
     * @generated
     */
    EReference getIntermediateEndpoint_Operation();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getReferredOperation <em>Referred Operation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Referred Operation</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getReferredOperation()
     * @see #getIntermediateEndpoint()
     * @generated
     */
    EReference getIntermediateEndpoint_ReferredOperation();

    /**
     * Returns the meta object for class '{@link de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification <em>Protocol Specification</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Protocol Specification</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification
     * @generated
     */
    EClass getIntermediateProtocolSpecification();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification#getCommunicationType <em>Communication Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Communication Type</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification#getCommunicationType()
     * @see #getIntermediateProtocolSpecification()
     * @generated
     */
    EAttribute getIntermediateProtocolSpecification_CommunicationType();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification#getProtocol <em>Protocol</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Protocol</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification#getProtocol()
     * @see #getIntermediateProtocolSpecification()
     * @generated
     */
    EAttribute getIntermediateProtocolSpecification_Protocol();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification#getDataFormat <em>Data Format</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Data Format</em>'.
     * @see de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification#getDataFormat()
     * @see #getIntermediateProtocolSpecification()
     * @generated
     */
    EAttribute getIntermediateProtocolSpecification_DataFormat();

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
         * The meta object literal for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateServiceModelImpl <em>Service Model</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediateServiceModelImpl
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateServiceModel()
         * @generated
         */
        EClass INTERMEDIATE_SERVICE_MODEL = eINSTANCE.getIntermediateServiceModel();

        /**
         * The meta object literal for the '<em><b>Source Model Uri</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_SERVICE_MODEL__SOURCE_MODEL_URI = eINSTANCE.getIntermediateServiceModel_SourceModelUri();

        /**
         * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_SERVICE_MODEL__IMPORTS = eINSTANCE.getIntermediateServiceModel_Imports();

        /**
         * The meta object literal for the '<em><b>Microservices</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_SERVICE_MODEL__MICROSERVICES = eINSTANCE.getIntermediateServiceModel_Microservices();

        /**
         * The meta object literal for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl <em>Microservice</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateMicroservice()
         * @generated
         */
        EClass INTERMEDIATE_MICROSERVICE = eINSTANCE.getIntermediateMicroservice();

        /**
         * The meta object literal for the '<em><b>Source Model Uri</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_MICROSERVICE__SOURCE_MODEL_URI = eINSTANCE.getIntermediateMicroservice_SourceModelUri();

        /**
         * The meta object literal for the '<em><b>Source Mapping Model Uri</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_MICROSERVICE__SOURCE_MAPPING_MODEL_URI = eINSTANCE.getIntermediateMicroservice_SourceMappingModelUri();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_MICROSERVICE__NAME = eINSTANCE.getIntermediateMicroservice_Name();

        /**
         * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_MICROSERVICE__VERSION = eINSTANCE.getIntermediateMicroservice_Version();

        /**
         * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_MICROSERVICE__QUALIFIED_NAME = eINSTANCE.getIntermediateMicroservice_QualifiedName();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_MICROSERVICE__TYPE = eINSTANCE.getIntermediateMicroservice_Type();

        /**
         * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_MICROSERVICE__VISIBILITY = eINSTANCE.getIntermediateMicroservice_Visibility();

        /**
         * The meta object literal for the '<em><b>Effectively Implemented</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_MICROSERVICE__EFFECTIVELY_IMPLEMENTED = eINSTANCE.getIntermediateMicroservice_EffectivelyImplemented();

        /**
         * The meta object literal for the '<em><b>Technologies</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_MICROSERVICE__TECHNOLOGIES = eINSTANCE.getIntermediateMicroservice_Technologies();

        /**
         * The meta object literal for the '<em><b>Endpoints</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_MICROSERVICE__ENDPOINTS = eINSTANCE.getIntermediateMicroservice_Endpoints();

        /**
         * The meta object literal for the '<em><b>Protocols</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_MICROSERVICE__PROTOCOLS = eINSTANCE.getIntermediateMicroservice_Protocols();

        /**
         * The meta object literal for the '<em><b>Required Microservices</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_MICROSERVICE__REQUIRED_MICROSERVICES = eINSTANCE.getIntermediateMicroservice_RequiredMicroservices();

        /**
         * The meta object literal for the '<em><b>Required Interfaces</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_MICROSERVICE__REQUIRED_INTERFACES = eINSTANCE.getIntermediateMicroservice_RequiredInterfaces();

        /**
         * The meta object literal for the '<em><b>Required Operations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_MICROSERVICE__REQUIRED_OPERATIONS = eINSTANCE.getIntermediateMicroservice_RequiredOperations();

        /**
         * The meta object literal for the '<em><b>Interfaces</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_MICROSERVICE__INTERFACES = eINSTANCE.getIntermediateMicroservice_Interfaces();

        /**
         * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_MICROSERVICE__ASPECTS = eINSTANCE.getIntermediateMicroservice_Aspects();

        /**
         * The meta object literal for the '<em><b>Service Model</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_MICROSERVICE__SERVICE_MODEL = eINSTANCE.getIntermediateMicroservice_ServiceModel();

        /**
         * The meta object literal for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateInterfaceImpl <em>Interface</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediateInterfaceImpl
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateInterface()
         * @generated
         */
        EClass INTERMEDIATE_INTERFACE = eINSTANCE.getIntermediateInterface();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_INTERFACE__NAME = eINSTANCE.getIntermediateInterface_Name();

        /**
         * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_INTERFACE__VERSION = eINSTANCE.getIntermediateInterface_Version();

        /**
         * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_INTERFACE__QUALIFIED_NAME = eINSTANCE.getIntermediateInterface_QualifiedName();

        /**
         * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_INTERFACE__VISIBILITY = eINSTANCE.getIntermediateInterface_Visibility();

        /**
         * The meta object literal for the '<em><b>Not Implemented</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_INTERFACE__NOT_IMPLEMENTED = eINSTANCE.getIntermediateInterface_NotImplemented();

        /**
         * The meta object literal for the '<em><b>Has Implemented Operations</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_INTERFACE__HAS_IMPLEMENTED_OPERATIONS = eINSTANCE.getIntermediateInterface_HasImplementedOperations();

        /**
         * The meta object literal for the '<em><b>Endpoints</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_INTERFACE__ENDPOINTS = eINSTANCE.getIntermediateInterface_Endpoints();

        /**
         * The meta object literal for the '<em><b>Protocols</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_INTERFACE__PROTOCOLS = eINSTANCE.getIntermediateInterface_Protocols();

        /**
         * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_INTERFACE__OPERATIONS = eINSTANCE.getIntermediateInterface_Operations();

        /**
         * The meta object literal for the '<em><b>Referred Operations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_INTERFACE__REFERRED_OPERATIONS = eINSTANCE.getIntermediateInterface_ReferredOperations();

        /**
         * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_INTERFACE__ASPECTS = eINSTANCE.getIntermediateInterface_Aspects();

        /**
         * The meta object literal for the '<em><b>Microservice</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_INTERFACE__MICROSERVICE = eINSTANCE.getIntermediateInterface_Microservice();

        /**
         * The meta object literal for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateOperationImpl <em>Operation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediateOperationImpl
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateOperation()
         * @generated
         */
        EClass INTERMEDIATE_OPERATION = eINSTANCE.getIntermediateOperation();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_OPERATION__NAME = eINSTANCE.getIntermediateOperation_Name();

        /**
         * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_OPERATION__QUALIFIED_NAME = eINSTANCE.getIntermediateOperation_QualifiedName();

        /**
         * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_OPERATION__VISIBILITY = eINSTANCE.getIntermediateOperation_Visibility();

        /**
         * The meta object literal for the '<em><b>Not Implemented</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_OPERATION__NOT_IMPLEMENTED = eINSTANCE.getIntermediateOperation_NotImplemented();

        /**
         * The meta object literal for the '<em><b>Api Operation Comment</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_OPERATION__API_OPERATION_COMMENT = eINSTANCE.getIntermediateOperation_ApiOperationComment();

        /**
         * The meta object literal for the '<em><b>Endpoints</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_OPERATION__ENDPOINTS = eINSTANCE.getIntermediateOperation_Endpoints();

        /**
         * The meta object literal for the '<em><b>Protocols</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_OPERATION__PROTOCOLS = eINSTANCE.getIntermediateOperation_Protocols();

        /**
         * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_OPERATION__ASPECTS = eINSTANCE.getIntermediateOperation_Aspects();

        /**
         * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_OPERATION__PARAMETERS = eINSTANCE.getIntermediateOperation_Parameters();

        /**
         * The meta object literal for the '<em><b>Interface</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_OPERATION__INTERFACE = eINSTANCE.getIntermediateOperation_Interface();

        /**
         * The meta object literal for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateApiOperationCommentImpl <em>Api Operation Comment</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediateApiOperationCommentImpl
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateApiOperationComment()
         * @generated
         */
        EClass INTERMEDIATE_API_OPERATION_COMMENT = eINSTANCE.getIntermediateApiOperationComment();

        /**
         * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_API_OPERATION_COMMENT__COMMENT = eINSTANCE.getIntermediateApiOperationComment_Comment();

        /**
         * The meta object literal for the '<em><b>Parameter Comments</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_API_OPERATION_COMMENT__PARAMETER_COMMENTS = eINSTANCE.getIntermediateApiOperationComment_ParameterComments();

        /**
         * The meta object literal for the '<em><b>Operation</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_API_OPERATION_COMMENT__OPERATION = eINSTANCE.getIntermediateApiOperationComment_Operation();

        /**
         * The meta object literal for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateApiParameterCommentImpl <em>Api Parameter Comment</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediateApiParameterCommentImpl
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateApiParameterComment()
         * @generated
         */
        EClass INTERMEDIATE_API_PARAMETER_COMMENT = eINSTANCE.getIntermediateApiParameterComment();

        /**
         * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_API_PARAMETER_COMMENT__COMMENT = eINSTANCE.getIntermediateApiParameterComment_Comment();

        /**
         * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_API_PARAMETER_COMMENT__REQUIRED = eINSTANCE.getIntermediateApiParameterComment_Required();

        /**
         * The meta object literal for the '<em><b>Returned</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_API_PARAMETER_COMMENT__RETURNED = eINSTANCE.getIntermediateApiParameterComment_Returned();

        /**
         * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_API_PARAMETER_COMMENT__PARAMETER = eINSTANCE.getIntermediateApiParameterComment_Parameter();

        /**
         * The meta object literal for the '<em><b>Operation Comment</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_API_PARAMETER_COMMENT__OPERATION_COMMENT = eINSTANCE.getIntermediateApiParameterComment_OperationComment();

        /**
         * The meta object literal for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateReferredOperationImpl <em>Referred Operation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediateReferredOperationImpl
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateReferredOperation()
         * @generated
         */
        EClass INTERMEDIATE_REFERRED_OPERATION = eINSTANCE.getIntermediateReferredOperation();

        /**
         * The meta object literal for the '<em><b>Name In Referring Interface</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_REFERRED_OPERATION__NAME_IN_REFERRING_INTERFACE = eINSTANCE.getIntermediateReferredOperation_NameInReferringInterface();

        /**
         * The meta object literal for the '<em><b>Qualified Name In Referring Interface</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_REFERRED_OPERATION__QUALIFIED_NAME_IN_REFERRING_INTERFACE = eINSTANCE.getIntermediateReferredOperation_QualifiedNameInReferringInterface();

        /**
         * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_REFERRED_OPERATION__OPERATION = eINSTANCE.getIntermediateReferredOperation_Operation();

        /**
         * The meta object literal for the '<em><b>Endpoints</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_REFERRED_OPERATION__ENDPOINTS = eINSTANCE.getIntermediateReferredOperation_Endpoints();

        /**
         * The meta object literal for the '<em><b>Protocols</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_REFERRED_OPERATION__PROTOCOLS = eINSTANCE.getIntermediateReferredOperation_Protocols();

        /**
         * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_REFERRED_OPERATION__ASPECTS = eINSTANCE.getIntermediateReferredOperation_Aspects();

        /**
         * The meta object literal for the '<em><b>Referring Interface</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_REFERRED_OPERATION__REFERRING_INTERFACE = eINSTANCE.getIntermediateReferredOperation_ReferringInterface();

        /**
         * The meta object literal for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateParameterImpl <em>Parameter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediateParameterImpl
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateParameter()
         * @generated
         */
        EClass INTERMEDIATE_PARAMETER = eINSTANCE.getIntermediateParameter();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_PARAMETER__NAME = eINSTANCE.getIntermediateParameter_Name();

        /**
         * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_PARAMETER__QUALIFIED_NAME = eINSTANCE.getIntermediateParameter_QualifiedName();

        /**
         * The meta object literal for the '<em><b>Exchange Pattern</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_PARAMETER__EXCHANGE_PATTERN = eINSTANCE.getIntermediateParameter_ExchangePattern();

        /**
         * The meta object literal for the '<em><b>Communication Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_PARAMETER__COMMUNICATION_TYPE = eINSTANCE.getIntermediateParameter_CommunicationType();

        /**
         * The meta object literal for the '<em><b>Communicates Fault</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_PARAMETER__COMMUNICATES_FAULT = eINSTANCE.getIntermediateParameter_CommunicatesFault();

        /**
         * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_PARAMETER__OPTIONAL = eINSTANCE.getIntermediateParameter_Optional();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_PARAMETER__TYPE = eINSTANCE.getIntermediateParameter_Type();

        /**
         * The meta object literal for the '<em><b>Original Type</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_PARAMETER__ORIGINAL_TYPE = eINSTANCE.getIntermediateParameter_OriginalType();

        /**
         * The meta object literal for the '<em><b>Initialized By Operation</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_PARAMETER__INITIALIZED_BY_OPERATION = eINSTANCE.getIntermediateParameter_InitializedByOperation();

        /**
         * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_PARAMETER__ASPECTS = eINSTANCE.getIntermediateParameter_Aspects();

        /**
         * The meta object literal for the '<em><b>Field Aspects</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_PARAMETER__FIELD_ASPECTS = eINSTANCE.getIntermediateParameter_FieldAspects();

        /**
         * The meta object literal for the '<em><b>Operation</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_PARAMETER__OPERATION = eINSTANCE.getIntermediateParameter_Operation();

        /**
         * The meta object literal for the '{@link de.fhdo.lemma.service.intermediate.impl.DataFieldAspectsImpl <em>Data Field Aspects</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.lemma.service.intermediate.impl.DataFieldAspectsImpl
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getDataFieldAspects()
         * @generated
         */
        EClass DATA_FIELD_ASPECTS = eINSTANCE.getDataFieldAspects();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DATA_FIELD_ASPECTS__NAME = eINSTANCE.getDataFieldAspects_Name();

        /**
         * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DATA_FIELD_ASPECTS__QUALIFIED_NAME = eINSTANCE.getDataFieldAspects_QualifiedName();

        /**
         * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DATA_FIELD_ASPECTS__ASPECTS = eINSTANCE.getDataFieldAspects_Aspects();

        /**
         * The meta object literal for the '<em><b>Parameter</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DATA_FIELD_ASPECTS__PARAMETER = eINSTANCE.getDataFieldAspects_Parameter();

        /**
         * The meta object literal for the '{@link de.fhdo.lemma.service.intermediate.impl.MicroserviceReferenceImpl <em>Microservice Reference</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.lemma.service.intermediate.impl.MicroserviceReferenceImpl
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getMicroserviceReference()
         * @generated
         */
        EClass MICROSERVICE_REFERENCE = eINSTANCE.getMicroserviceReference();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MICROSERVICE_REFERENCE__NAME = eINSTANCE.getMicroserviceReference_Name();

        /**
         * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MICROSERVICE_REFERENCE__VERSION = eINSTANCE.getMicroserviceReference_Version();

        /**
         * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MICROSERVICE_REFERENCE__QUALIFIED_NAME = eINSTANCE.getMicroserviceReference_QualifiedName();

        /**
         * The meta object literal for the '<em><b>Imported</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MICROSERVICE_REFERENCE__IMPORTED = eINSTANCE.getMicroserviceReference_Imported();

        /**
         * The meta object literal for the '<em><b>Import</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MICROSERVICE_REFERENCE__IMPORT = eINSTANCE.getMicroserviceReference_Import();

        /**
         * The meta object literal for the '<em><b>Local Microservice</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MICROSERVICE_REFERENCE__LOCAL_MICROSERVICE = eINSTANCE.getMicroserviceReference_LocalMicroservice();

        /**
         * The meta object literal for the '<em><b>Requiring Microservice</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MICROSERVICE_REFERENCE__REQUIRING_MICROSERVICE = eINSTANCE.getMicroserviceReference_RequiringMicroservice();

        /**
         * The meta object literal for the '{@link de.fhdo.lemma.service.intermediate.impl.InterfaceReferenceImpl <em>Interface Reference</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.lemma.service.intermediate.impl.InterfaceReferenceImpl
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getInterfaceReference()
         * @generated
         */
        EClass INTERFACE_REFERENCE = eINSTANCE.getInterfaceReference();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERFACE_REFERENCE__NAME = eINSTANCE.getInterfaceReference_Name();

        /**
         * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERFACE_REFERENCE__VERSION = eINSTANCE.getInterfaceReference_Version();

        /**
         * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERFACE_REFERENCE__QUALIFIED_NAME = eINSTANCE.getInterfaceReference_QualifiedName();

        /**
         * The meta object literal for the '<em><b>Imported</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERFACE_REFERENCE__IMPORTED = eINSTANCE.getInterfaceReference_Imported();

        /**
         * The meta object literal for the '<em><b>Import</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERFACE_REFERENCE__IMPORT = eINSTANCE.getInterfaceReference_Import();

        /**
         * The meta object literal for the '<em><b>Local Interface</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERFACE_REFERENCE__LOCAL_INTERFACE = eINSTANCE.getInterfaceReference_LocalInterface();

        /**
         * The meta object literal for the '<em><b>Requiring Microservice</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERFACE_REFERENCE__REQUIRING_MICROSERVICE = eINSTANCE.getInterfaceReference_RequiringMicroservice();

        /**
         * The meta object literal for the '{@link de.fhdo.lemma.service.intermediate.impl.OperationReferenceImpl <em>Operation Reference</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.lemma.service.intermediate.impl.OperationReferenceImpl
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getOperationReference()
         * @generated
         */
        EClass OPERATION_REFERENCE = eINSTANCE.getOperationReference();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OPERATION_REFERENCE__NAME = eINSTANCE.getOperationReference_Name();

        /**
         * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OPERATION_REFERENCE__QUALIFIED_NAME = eINSTANCE.getOperationReference_QualifiedName();

        /**
         * The meta object literal for the '<em><b>Imported</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OPERATION_REFERENCE__IMPORTED = eINSTANCE.getOperationReference_Imported();

        /**
         * The meta object literal for the '<em><b>Import</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference OPERATION_REFERENCE__IMPORT = eINSTANCE.getOperationReference_Import();

        /**
         * The meta object literal for the '<em><b>Local Operation</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference OPERATION_REFERENCE__LOCAL_OPERATION = eINSTANCE.getOperationReference_LocalOperation();

        /**
         * The meta object literal for the '<em><b>Requiring Microservice</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference OPERATION_REFERENCE__REQUIRING_MICROSERVICE = eINSTANCE.getOperationReference_RequiringMicroservice();

        /**
         * The meta object literal for the '<em><b>Initialized Parameter</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference OPERATION_REFERENCE__INITIALIZED_PARAMETER = eINSTANCE.getOperationReference_InitializedParameter();

        /**
         * The meta object literal for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateTechnologyImpl <em>Technology</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediateTechnologyImpl
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateTechnology()
         * @generated
         */
        EClass INTERMEDIATE_TECHNOLOGY = eINSTANCE.getIntermediateTechnology();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_TECHNOLOGY__NAME = eINSTANCE.getIntermediateTechnology_Name();

        /**
         * The meta object literal for the '<em><b>Import</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_TECHNOLOGY__IMPORT = eINSTANCE.getIntermediateTechnology_Import();

        /**
         * The meta object literal for the '<em><b>Microservice</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_TECHNOLOGY__MICROSERVICE = eINSTANCE.getIntermediateTechnology_Microservice();

        /**
         * The meta object literal for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateEndpointImpl <em>Endpoint</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediateEndpointImpl
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateEndpoint()
         * @generated
         */
        EClass INTERMEDIATE_ENDPOINT = eINSTANCE.getIntermediateEndpoint();

        /**
         * The meta object literal for the '<em><b>Communication Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_ENDPOINT__COMMUNICATION_TYPE = eINSTANCE.getIntermediateEndpoint_CommunicationType();

        /**
         * The meta object literal for the '<em><b>Protocol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_ENDPOINT__PROTOCOL = eINSTANCE.getIntermediateEndpoint_Protocol();

        /**
         * The meta object literal for the '<em><b>Data Format</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_ENDPOINT__DATA_FORMAT = eINSTANCE.getIntermediateEndpoint_DataFormat();

        /**
         * The meta object literal for the '<em><b>Addresses</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_ENDPOINT__ADDRESSES = eINSTANCE.getIntermediateEndpoint_Addresses();

        /**
         * The meta object literal for the '<em><b>Technology</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_ENDPOINT__TECHNOLOGY = eINSTANCE.getIntermediateEndpoint_Technology();

        /**
         * The meta object literal for the '<em><b>Microservice</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_ENDPOINT__MICROSERVICE = eINSTANCE.getIntermediateEndpoint_Microservice();

        /**
         * The meta object literal for the '<em><b>Interface</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_ENDPOINT__INTERFACE = eINSTANCE.getIntermediateEndpoint_Interface();

        /**
         * The meta object literal for the '<em><b>Operation</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_ENDPOINT__OPERATION = eINSTANCE.getIntermediateEndpoint_Operation();

        /**
         * The meta object literal for the '<em><b>Referred Operation</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_ENDPOINT__REFERRED_OPERATION = eINSTANCE.getIntermediateEndpoint_ReferredOperation();

        /**
         * The meta object literal for the '{@link de.fhdo.lemma.service.intermediate.impl.IntermediateProtocolSpecificationImpl <em>Protocol Specification</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediateProtocolSpecificationImpl
         * @see de.fhdo.lemma.service.intermediate.impl.IntermediatePackageImpl#getIntermediateProtocolSpecification()
         * @generated
         */
        EClass INTERMEDIATE_PROTOCOL_SPECIFICATION = eINSTANCE.getIntermediateProtocolSpecification();

        /**
         * The meta object literal for the '<em><b>Communication Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE = eINSTANCE.getIntermediateProtocolSpecification_CommunicationType();

        /**
         * The meta object literal for the '<em><b>Protocol</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_PROTOCOL_SPECIFICATION__PROTOCOL = eINSTANCE.getIntermediateProtocolSpecification_Protocol();

        /**
         * The meta object literal for the '<em><b>Data Format</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_PROTOCOL_SPECIFICATION__DATA_FORMAT = eINSTANCE.getIntermediateProtocolSpecification_DataFormat();

    }

} //IntermediatePackage
