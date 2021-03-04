/**
 */
package de.fhdo.lemma.service;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see de.fhdo.lemma.service.ServiceFactory
 * @model kind="package"
 * @generated
 */
public interface ServicePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "service";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "de.fhdo.lemma.service";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "service";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ServicePackage eINSTANCE = de.fhdo.lemma.service.impl.ServicePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.ServiceModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.ServiceModelImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getServiceModel()
	 * @generated
	 */
	int SERVICE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Tmodel Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MODEL__TMODEL_URI = 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MODEL__IMPORTS = 1;

	/**
	 * The feature id for the '<em><b>Mapped Complex Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MODEL__MAPPED_COMPLEX_TYPES = 2;

	/**
	 * The feature id for the '<em><b>Microservices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MODEL__MICROSERVICES = 3;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MODEL_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Get Contained Operations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MODEL___GET_CONTAINED_OPERATIONS = 0;

	/**
	 * The operation id for the '<em>Get Contained Referred Operations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MODEL___GET_CONTAINED_REFERRED_OPERATIONS = 1;

	/**
	 * The operation id for the '<em>Get Contained Interfaces</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MODEL___GET_CONTAINED_INTERFACES = 2;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_MODEL_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.ImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.ImportImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getImport()
	 * @generated
	 */
	int IMPORT = 1;

	/**
	 * The feature id for the '<em><b>Trelated Import Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__TRELATED_IMPORT_ALIAS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Import URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__IMPORT_URI = 2;

	/**
	 * The feature id for the '<em><b>External URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__EXTERNAL_URI = 3;

	/**
	 * The feature id for the '<em><b>Import Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__IMPORT_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Service Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__SERVICE_MODEL = 5;

	/**
	 * The number of structural features of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.MappedComplexTypeImpl <em>Mapped Complex Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.MappedComplexTypeImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getMappedComplexType()
	 * @generated
	 */
	int MAPPED_COMPLEX_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Tsource Model Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_COMPLEX_TYPE__TSOURCE_MODEL_URI = 0;

	/**
	 * The feature id for the '<em><b>Ttype Definition Technology Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_COMPLEX_TYPE__TTYPE_DEFINITION_TECHNOLOGY_IMPORT = 1;

	/**
	 * The feature id for the '<em><b>Ttype Definition Technology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_COMPLEX_TYPE__TTYPE_DEFINITION_TECHNOLOGY = 2;

	/**
	 * The feature id for the '<em><b>Technology References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_COMPLEX_TYPE__TECHNOLOGY_REFERENCES = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_COMPLEX_TYPE__TYPE = 4;

	/**
	 * The feature id for the '<em><b>Mapped Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_COMPLEX_TYPE__MAPPED_FIELDS = 5;

	/**
	 * The feature id for the '<em><b>Mapped Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_COMPLEX_TYPE__MAPPED_OPERATIONS = 6;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_COMPLEX_TYPE__ASPECTS = 7;

	/**
	 * The feature id for the '<em><b>Service Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_COMPLEX_TYPE__SERVICE_MODEL = 8;

	/**
	 * The number of structural features of the '<em>Mapped Complex Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_COMPLEX_TYPE_FEATURE_COUNT = 9;

	/**
	 * The operation id for the '<em>Get Qualified Name Parts</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_COMPLEX_TYPE___GET_QUALIFIED_NAME_PARTS__BOOLEAN = 0;

	/**
	 * The operation id for the '<em>Build Qualified Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_COMPLEX_TYPE___BUILD_QUALIFIED_NAME__STRING_BOOLEAN = 1;

	/**
	 * The operation id for the '<em>Get All Type Definition Technology References</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_COMPLEX_TYPE___GET_ALL_TYPE_DEFINITION_TECHNOLOGY_REFERENCES = 2;

	/**
	 * The operation id for the '<em>Get Type Definition Technology Import</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_COMPLEX_TYPE___GET_TYPE_DEFINITION_TECHNOLOGY_IMPORT = 3;

	/**
	 * The operation id for the '<em>Get Type Definition Technology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_COMPLEX_TYPE___GET_TYPE_DEFINITION_TECHNOLOGY = 4;

	/**
	 * The number of operations of the '<em>Mapped Complex Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_COMPLEX_TYPE_OPERATION_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.MappedDataOperationImpl <em>Mapped Data Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.MappedDataOperationImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getMappedDataOperation()
	 * @generated
	 */
	int MAPPED_DATA_OPERATION = 3;

	/**
	 * The feature id for the '<em><b>Data Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_DATA_OPERATION__DATA_OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_DATA_OPERATION__ASPECTS = 1;

	/**
	 * The feature id for the '<em><b>Mapped Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_DATA_OPERATION__MAPPED_RETURN_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Mapped Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_DATA_OPERATION__MAPPED_PARAMETERS = 3;

	/**
	 * The feature id for the '<em><b>Mapped Complex Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_DATA_OPERATION__MAPPED_COMPLEX_TYPE = 4;

	/**
	 * The number of structural features of the '<em>Mapped Data Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_DATA_OPERATION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Mapped Data Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_DATA_OPERATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.MappedDataOperationReturnTypeImpl <em>Mapped Data Operation Return Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.MappedDataOperationReturnTypeImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getMappedDataOperationReturnType()
	 * @generated
	 */
	int MAPPED_DATA_OPERATION_RETURN_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Mapped Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_DATA_OPERATION_RETURN_TYPE__MAPPED_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_DATA_OPERATION_RETURN_TYPE__ASPECTS = 1;

	/**
	 * The feature id for the '<em><b>Mapped Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_DATA_OPERATION_RETURN_TYPE__MAPPED_OPERATION = 2;

	/**
	 * The number of structural features of the '<em>Mapped Data Operation Return Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_DATA_OPERATION_RETURN_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Mapped Data Operation Return Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_DATA_OPERATION_RETURN_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.MappedDataOperationParameterImpl <em>Mapped Data Operation Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.MappedDataOperationParameterImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getMappedDataOperationParameter()
	 * @generated
	 */
	int MAPPED_DATA_OPERATION_PARAMETER = 5;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_DATA_OPERATION_PARAMETER__PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Mapped Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_DATA_OPERATION_PARAMETER__MAPPED_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_DATA_OPERATION_PARAMETER__ASPECTS = 2;

	/**
	 * The feature id for the '<em><b>Mapped Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_DATA_OPERATION_PARAMETER__MAPPED_OPERATION = 3;

	/**
	 * The number of structural features of the '<em>Mapped Data Operation Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_DATA_OPERATION_PARAMETER_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Mapped Data Operation Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_DATA_OPERATION_PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.MappedFieldImpl <em>Mapped Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.MappedFieldImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getMappedField()
	 * @generated
	 */
	int MAPPED_FIELD = 6;

	/**
	 * The feature id for the '<em><b>Data Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_FIELD__DATA_FIELD = 0;

	/**
	 * The feature id for the '<em><b>Enumeration Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_FIELD__ENUMERATION_FIELD = 1;

	/**
	 * The feature id for the '<em><b>Mapped Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_FIELD__MAPPED_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_FIELD__ASPECTS = 3;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_FIELD__PARAMETER = 4;

	/**
	 * The feature id for the '<em><b>Mapped Complex Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_FIELD__MAPPED_COMPLEX_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_FIELD__NAME = 6;

	/**
	 * The number of structural features of the '<em>Mapped Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_FIELD_FEATURE_COUNT = 7;

	/**
	 * The operation id for the '<em>Get Qualified Name Parts</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_FIELD___GET_QUALIFIED_NAME_PARTS__BOOLEAN = 0;

	/**
	 * The operation id for the '<em>Build Qualified Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_FIELD___BUILD_QUALIFIED_NAME__STRING_BOOLEAN = 1;

	/**
	 * The operation id for the '<em>Get Effective Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_FIELD___GET_EFFECTIVE_TYPE = 2;

	/**
	 * The number of operations of the '<em>Mapped Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_FIELD_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.MicroserviceImpl <em>Microservice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.MicroserviceImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getMicroservice()
	 * @generated
	 */
	int MICROSERVICE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE__VERSION = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE__VISIBILITY = 3;

	/**
	 * The feature id for the '<em><b>Tdefault Protocols</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE__TDEFAULT_PROTOCOLS = 4;

	/**
	 * The feature id for the '<em><b>Tsource Model Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE__TSOURCE_MODEL_URI = 5;

	/**
	 * The feature id for the '<em><b>Technology References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE__TECHNOLOGY_REFERENCES = 6;

	/**
	 * The feature id for the '<em><b>Ttype Definition Technology Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE__TTYPE_DEFINITION_TECHNOLOGY_IMPORT = 7;

	/**
	 * The feature id for the '<em><b>Ttype Definition Technology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE__TTYPE_DEFINITION_TECHNOLOGY = 8;

	/**
	 * The feature id for the '<em><b>Endpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE__ENDPOINTS = 9;

	/**
	 * The feature id for the '<em><b>Required Microservices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE__REQUIRED_MICROSERVICES = 10;

	/**
	 * The feature id for the '<em><b>Required Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE__REQUIRED_INTERFACES = 11;

	/**
	 * The feature id for the '<em><b>Required Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE__REQUIRED_OPERATIONS = 12;

	/**
	 * The feature id for the '<em><b>Protocols</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE__PROTOCOLS = 13;

	/**
	 * The feature id for the '<em><b>Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE__INTERFACES = 14;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE__ASPECTS = 15;

	/**
	 * The feature id for the '<em><b>Service Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE__SERVICE_MODEL = 16;

	/**
	 * The feature id for the '<em><b>Effectively Implemented</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE__EFFECTIVELY_IMPLEMENTED = 17;

	/**
	 * The feature id for the '<em><b>Effective Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE__EFFECTIVE_VISIBILITY = 18;

	/**
	 * The feature id for the '<em><b>Effectively Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE__EFFECTIVELY_INTERNAL = 19;

	/**
	 * The number of structural features of the '<em>Microservice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE_FEATURE_COUNT = 20;

	/**
	 * The operation id for the '<em>Teffective Protocol Specifications</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE___TEFFECTIVE_PROTOCOL_SPECIFICATIONS = 0;

	/**
	 * The operation id for the '<em>Get All Type Definition Technology References</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE___GET_ALL_TYPE_DEFINITION_TECHNOLOGY_REFERENCES = 1;

	/**
	 * The operation id for the '<em>Get Type Definition Technology Import</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE___GET_TYPE_DEFINITION_TECHNOLOGY_IMPORT = 2;

	/**
	 * The operation id for the '<em>Get Type Definition Technology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE___GET_TYPE_DEFINITION_TECHNOLOGY = 3;

	/**
	 * The operation id for the '<em>Get Qualified Name Parts</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE___GET_QUALIFIED_NAME_PARTS = 4;

	/**
	 * The operation id for the '<em>Build Qualified Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE___BUILD_QUALIFIED_NAME__STRING = 5;

	/**
	 * The operation id for the '<em>Get Contained Operations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE___GET_CONTAINED_OPERATIONS = 6;

	/**
	 * The operation id for the '<em>Get Contained Referred Operations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE___GET_CONTAINED_REFERRED_OPERATIONS = 7;

	/**
	 * The operation id for the '<em>Get Required Imports</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE___GET_REQUIRED_IMPORTS = 8;

	/**
	 * The operation id for the '<em>Get All Required Operations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE___GET_ALL_REQUIRED_OPERATIONS__IMPORT = 9;

	/**
	 * The operation id for the '<em>Get All Required Microservices</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE___GET_ALL_REQUIRED_MICROSERVICES = 10;

	/**
	 * The operation id for the '<em>Get All Initializing Microservices</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE___GET_ALL_INITIALIZING_MICROSERVICES = 11;

	/**
	 * The operation id for the '<em>Can Require</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE___CAN_REQUIRE__MICROSERVICE_BOOLEAN = 12;

	/**
	 * The operation id for the '<em>Can Require</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE___CAN_REQUIRE__INTERFACE_BOOLEAN = 13;

	/**
	 * The operation id for the '<em>Can Require</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE___CAN_REQUIRE__OPERATION_BOOLEAN = 14;

	/**
	 * The number of operations of the '<em>Microservice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICROSERVICE_OPERATION_COUNT = 15;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.TechnologyReferenceImpl <em>Technology Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.TechnologyReferenceImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getTechnologyReference()
	 * @generated
	 */
	int TECHNOLOGY_REFERENCE = 8;

	/**
	 * The feature id for the '<em><b>Is Type Definition Technology</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNOLOGY_REFERENCE__IS_TYPE_DEFINITION_TECHNOLOGY = 0;

	/**
	 * The feature id for the '<em><b>Technology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNOLOGY_REFERENCE__TECHNOLOGY = 1;

	/**
	 * The feature id for the '<em><b>Microservice</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNOLOGY_REFERENCE__MICROSERVICE = 2;

	/**
	 * The feature id for the '<em><b>Mapped Complex Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNOLOGY_REFERENCE__MAPPED_COMPLEX_TYPE = 3;

	/**
	 * The number of structural features of the '<em>Technology Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNOLOGY_REFERENCE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Technology Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TECHNOLOGY_REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.InterfaceImpl <em>Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.InterfaceImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getInterface()
	 * @generated
	 */
	int INTERFACE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__VERSION = 1;

	/**
	 * The feature id for the '<em><b>Not Implemented</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__NOT_IMPLEMENTED = 2;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__VISIBILITY = 3;

	/**
	 * The feature id for the '<em><b>Endpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__ENDPOINTS = 4;

	/**
	 * The feature id for the '<em><b>Protocols</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__PROTOCOLS = 5;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__OPERATIONS = 6;

	/**
	 * The feature id for the '<em><b>Referred Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__REFERRED_OPERATIONS = 7;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__ASPECTS = 8;

	/**
	 * The feature id for the '<em><b>Microservice</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__MICROSERVICE = 9;

	/**
	 * The feature id for the '<em><b>Effective Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__EFFECTIVE_VISIBILITY = 10;

	/**
	 * The feature id for the '<em><b>Effectively Implemented</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__EFFECTIVELY_IMPLEMENTED = 11;

	/**
	 * The feature id for the '<em><b>Effectively Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__EFFECTIVELY_INTERNAL = 12;

	/**
	 * The number of structural features of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_FEATURE_COUNT = 13;

	/**
	 * The operation id for the '<em>Teffective Protocol Specifications</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE___TEFFECTIVE_PROTOCOL_SPECIFICATIONS = 0;

	/**
	 * The operation id for the '<em>Get Qualified Name Parts</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE___GET_QUALIFIED_NAME_PARTS = 1;

	/**
	 * The operation id for the '<em>Build Qualified Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE___BUILD_QUALIFIED_NAME__STRING = 2;

	/**
	 * The number of operations of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.OperationImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Not Implemented</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NOT_IMPLEMENTED = 1;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__VISIBILITY = 2;

	/**
	 * The feature id for the '<em><b>Api Operation Comment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__API_OPERATION_COMMENT = 3;

	/**
	 * The feature id for the '<em><b>Endpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__ENDPOINTS = 4;

	/**
	 * The feature id for the '<em><b>Protocols</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__PROTOCOLS = 5;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__PARAMETERS = 6;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__ASPECTS = 7;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__INTERFACE = 8;

	/**
	 * The feature id for the '<em><b>Not Implemented By Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NOT_IMPLEMENTED_BY_CONTAINER = 9;

	/**
	 * The feature id for the '<em><b>Effectively Not Implemented</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__EFFECTIVELY_NOT_IMPLEMENTED = 10;

	/**
	 * The feature id for the '<em><b>Effective Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__EFFECTIVE_VISIBILITY = 11;

	/**
	 * The feature id for the '<em><b>Effectively Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__EFFECTIVELY_INTERNAL = 12;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = 13;

	/**
	 * The operation id for the '<em>Teffective Protocol Specifications</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___TEFFECTIVE_PROTOCOL_SPECIFICATIONS = 0;

	/**
	 * The operation id for the '<em>Get Qualified Name Parts</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___GET_QUALIFIED_NAME_PARTS = 1;

	/**
	 * The operation id for the '<em>Build Qualified Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___BUILD_QUALIFIED_NAME__STRING = 2;

	/**
	 * The number of operations of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.ApiOperationCommentImpl <em>Api Operation Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.ApiOperationCommentImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getApiOperationComment()
	 * @generated
	 */
	int API_OPERATION_COMMENT = 11;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int API_OPERATION_COMMENT__COMMENT = 0;

	/**
	 * The feature id for the '<em><b>Parameter Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int API_OPERATION_COMMENT__PARAMETER_COMMENTS = 1;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int API_OPERATION_COMMENT__OPERATION = 2;

	/**
	 * The number of structural features of the '<em>Api Operation Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int API_OPERATION_COMMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Api Operation Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int API_OPERATION_COMMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.ApiParameterCommentImpl <em>Api Parameter Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.ApiParameterCommentImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getApiParameterComment()
	 * @generated
	 */
	int API_PARAMETER_COMMENT = 12;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int API_PARAMETER_COMMENT__COMMENT = 0;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int API_PARAMETER_COMMENT__REQUIRED = 1;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int API_PARAMETER_COMMENT__PARAMETER = 2;

	/**
	 * The feature id for the '<em><b>Operation Comment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int API_PARAMETER_COMMENT__OPERATION_COMMENT = 3;

	/**
	 * The number of structural features of the '<em>Api Parameter Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int API_PARAMETER_COMMENT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Api Parameter Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int API_PARAMETER_COMMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.ReferredOperationImpl <em>Referred Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.ReferredOperationImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getReferredOperation()
	 * @generated
	 */
	int REFERRED_OPERATION = 13;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERRED_OPERATION__OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Endpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERRED_OPERATION__ENDPOINTS = 1;

	/**
	 * The feature id for the '<em><b>Protocols</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERRED_OPERATION__PROTOCOLS = 2;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERRED_OPERATION__ASPECTS = 3;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERRED_OPERATION__INTERFACE = 4;

	/**
	 * The number of structural features of the '<em>Referred Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERRED_OPERATION_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Teffective Protocol Specifications</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERRED_OPERATION___TEFFECTIVE_PROTOCOL_SPECIFICATIONS = 0;

	/**
	 * The operation id for the '<em>Get Qualified Name Parts</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERRED_OPERATION___GET_QUALIFIED_NAME_PARTS = 1;

	/**
	 * The operation id for the '<em>Build Qualified Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERRED_OPERATION___BUILD_QUALIFIED_NAME__STRING = 2;

	/**
	 * The number of operations of the '<em>Referred Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERRED_OPERATION_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.ParameterImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Exchange Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__EXCHANGE_PATTERN = 1;

	/**
	 * The feature id for the '<em><b>Communication Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__COMMUNICATION_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Communicates Fault</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__COMMUNICATES_FAULT = 3;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__OPTIONAL = 4;

	/**
	 * The feature id for the '<em><b>Initialized By Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__INITIALIZED_BY_OPERATION = 5;

	/**
	 * The feature id for the '<em><b>Imported Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__IMPORTED_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__PRIMITIVE_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__ASPECTS = 8;

	/**
	 * The feature id for the '<em><b>Mapped Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__MAPPED_FIELDS = 9;

	/**
	 * The feature id for the '<em><b>Original Imported Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__ORIGINAL_IMPORTED_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Original Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__ORIGINAL_PRIMITIVE_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__OPERATION = 12;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 13;

	/**
	 * The operation id for the '<em>Get Qualified Name Parts</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER___GET_QUALIFIED_NAME_PARTS = 0;

	/**
	 * The operation id for the '<em>Build Qualified Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER___BUILD_QUALIFIED_NAME__STRING = 1;

	/**
	 * The operation id for the '<em>Basically Initializable By</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER___BASICALLY_INITIALIZABLE_BY__OPERATION = 2;

	/**
	 * The operation id for the '<em>Get Effective Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER___GET_EFFECTIVE_TYPE = 3;

	/**
	 * The operation id for the '<em>Is Technology Specific Effective Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER___IS_TECHNOLOGY_SPECIFIC_EFFECTIVE_TYPE = 4;

	/**
	 * The operation id for the '<em>Get Effective Type Qualified Name Parts</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER___GET_EFFECTIVE_TYPE_QUALIFIED_NAME_PARTS = 5;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = 6;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.PossiblyImportedMicroserviceImpl <em>Possibly Imported Microservice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.PossiblyImportedMicroserviceImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getPossiblyImportedMicroservice()
	 * @generated
	 */
	int POSSIBLY_IMPORTED_MICROSERVICE = 15;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_MICROSERVICE__IMPORT = 0;

	/**
	 * The feature id for the '<em><b>Microservice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_MICROSERVICE__MICROSERVICE = 1;

	/**
	 * The feature id for the '<em><b>Requiring Microservice</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_MICROSERVICE__REQUIRING_MICROSERVICE = 2;

	/**
	 * The number of structural features of the '<em>Possibly Imported Microservice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_MICROSERVICE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Possibly Imported Microservice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_MICROSERVICE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.PossiblyImportedInterfaceImpl <em>Possibly Imported Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.PossiblyImportedInterfaceImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getPossiblyImportedInterface()
	 * @generated
	 */
	int POSSIBLY_IMPORTED_INTERFACE = 16;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_INTERFACE__IMPORT = 0;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_INTERFACE__INTERFACE = 1;

	/**
	 * The feature id for the '<em><b>Requiring Microservice</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_INTERFACE__REQUIRING_MICROSERVICE = 2;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_INTERFACE__REQUIRED = 3;

	/**
	 * The feature id for the '<em><b>Required By Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_INTERFACE__REQUIRED_BY_CONTAINER = 4;

	/**
	 * The number of structural features of the '<em>Possibly Imported Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_INTERFACE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Possibly Imported Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_INTERFACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.PossiblyImportedOperationImpl <em>Possibly Imported Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.PossiblyImportedOperationImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getPossiblyImportedOperation()
	 * @generated
	 */
	int POSSIBLY_IMPORTED_OPERATION = 17;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_OPERATION__IMPORT = 0;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_OPERATION__OPERATION = 1;

	/**
	 * The feature id for the '<em><b>Requiring Microservice</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_OPERATION__REQUIRING_MICROSERVICE = 2;

	/**
	 * The feature id for the '<em><b>Initialized Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_OPERATION__INITIALIZED_PARAMETER = 3;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_OPERATION__REQUIRED = 4;

	/**
	 * The feature id for the '<em><b>Required By Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_OPERATION__REQUIRED_BY_INTERFACE = 5;

	/**
	 * The feature id for the '<em><b>Required By Microservice</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_OPERATION__REQUIRED_BY_MICROSERVICE = 6;

	/**
	 * The feature id for the '<em><b>Required By Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_OPERATION__REQUIRED_BY_CONTAINER = 7;

	/**
	 * The number of structural features of the '<em>Possibly Imported Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_OPERATION_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Possibly Imported Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLY_IMPORTED_OPERATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.ImportedTypeImpl <em>Imported Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.ImportedTypeImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getImportedType()
	 * @generated
	 */
	int IMPORTED_TYPE = 18;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_TYPE__IMPORT = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_TYPE__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Imported Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Imported Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.ImportedProtocolAndDataFormatImpl <em>Imported Protocol And Data Format</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.ImportedProtocolAndDataFormatImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getImportedProtocolAndDataFormat()
	 * @generated
	 */
	int IMPORTED_PROTOCOL_AND_DATA_FORMAT = 19;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_PROTOCOL_AND_DATA_FORMAT__IMPORT = 0;

	/**
	 * The feature id for the '<em><b>Imported Protocol</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_PROTOCOL_AND_DATA_FORMAT__IMPORTED_PROTOCOL = 1;

	/**
	 * The feature id for the '<em><b>Data Format</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_PROTOCOL_AND_DATA_FORMAT__DATA_FORMAT = 2;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_PROTOCOL_AND_DATA_FORMAT__SPECIFICATION = 3;

	/**
	 * The feature id for the '<em><b>Endpoint</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_PROTOCOL_AND_DATA_FORMAT__ENDPOINT = 4;

	/**
	 * The number of structural features of the '<em>Imported Protocol And Data Format</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_PROTOCOL_AND_DATA_FORMAT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Imported Protocol And Data Format</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_PROTOCOL_AND_DATA_FORMAT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.ProtocolSpecificationImpl <em>Protocol Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.ProtocolSpecificationImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getProtocolSpecification()
	 * @generated
	 */
	int PROTOCOL_SPECIFICATION = 20;

	/**
	 * The feature id for the '<em><b>Communication Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_SPECIFICATION__PROTOCOL = 1;

	/**
	 * The number of structural features of the '<em>Protocol Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_SPECIFICATION_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Effective Protocol Specifications</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_SPECIFICATION___EFFECTIVE_PROTOCOL_SPECIFICATIONS__ELIST = 0;

	/**
	 * The number of operations of the '<em>Protocol Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_SPECIFICATION_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.EndpointImpl <em>Endpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.EndpointImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getEndpoint()
	 * @generated
	 */
	int ENDPOINT = 21;

	/**
	 * The feature id for the '<em><b>Addresses</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDPOINT__ADDRESSES = 0;

	/**
	 * The feature id for the '<em><b>Protocols</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDPOINT__PROTOCOLS = 1;

	/**
	 * The feature id for the '<em><b>Microservice</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDPOINT__MICROSERVICE = 2;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDPOINT__INTERFACE = 3;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDPOINT__OPERATION = 4;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDPOINT__REFERRED_OPERATION = 5;

	/**
	 * The number of structural features of the '<em>Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDPOINT_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDPOINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.impl.ImportedServiceAspectImpl <em>Imported Service Aspect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.impl.ImportedServiceAspectImpl
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getImportedServiceAspect()
	 * @generated
	 */
	int IMPORTED_SERVICE_ASPECT = 22;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_SERVICE_ASPECT__IMPORT = 0;

	/**
	 * The feature id for the '<em><b>Imported Aspect</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_SERVICE_ASPECT__IMPORTED_ASPECT = 1;

	/**
	 * The feature id for the '<em><b>Single Property Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_SERVICE_ASPECT__VALUES = 3;

	/**
	 * The feature id for the '<em><b>Microservice</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_SERVICE_ASPECT__MICROSERVICE = 4;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_SERVICE_ASPECT__INTERFACE = 5;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_SERVICE_ASPECT__OPERATION = 6;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION = 7;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_SERVICE_ASPECT__PARAMETER = 8;

	/**
	 * The feature id for the '<em><b>Mapped Complex Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_SERVICE_ASPECT__MAPPED_COMPLEX_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Mapped Field</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_SERVICE_ASPECT__MAPPED_FIELD = 10;

	/**
	 * The feature id for the '<em><b>Mapped Data Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION = 11;

	/**
	 * The feature id for the '<em><b>Mapped Data Operation Return Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_RETURN_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Mapped Data Operation Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_PARAMETER = 13;

	/**
	 * The number of structural features of the '<em>Imported Service Aspect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_SERVICE_ASPECT_FEATURE_COUNT = 14;

	/**
	 * The number of operations of the '<em>Imported Service Aspect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_SERVICE_ASPECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.ImportType <em>Import Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.ImportType
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getImportType()
	 * @generated
	 */
	int IMPORT_TYPE = 23;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.MicroserviceType <em>Microservice Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.MicroserviceType
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getMicroserviceType()
	 * @generated
	 */
	int MICROSERVICE_TYPE = 24;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.service.Visibility <em>Visibility</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.service.Visibility
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getVisibility()
	 * @generated
	 */
	int VISIBILITY = 25;

	/**
	 * The meta object id for the '<em>Tuple List</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getTupleList()
	 * @generated
	 */
	int TUPLE_LIST = 26;

	/**
	 * The meta object id for the '<em>Microservice Import Map</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Map
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getMicroserviceImportMap()
	 * @generated
	 */
	int MICROSERVICE_IMPORT_MAP = 27;

	/**
	 * The meta object id for the '<em>Default Protocols</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Map
	 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getDefaultProtocols()
	 * @generated
	 */
	int DEFAULT_PROTOCOLS = 28;


	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.ServiceModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see de.fhdo.lemma.service.ServiceModel
	 * @generated
	 */
	EClass getServiceModel();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.ServiceModel#getT_modelUri <em>Tmodel Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tmodel Uri</em>'.
	 * @see de.fhdo.lemma.service.ServiceModel#getT_modelUri()
	 * @see #getServiceModel()
	 * @generated
	 */
	EAttribute getServiceModel_T_modelUri();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.ServiceModel#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see de.fhdo.lemma.service.ServiceModel#getImports()
	 * @see #getServiceModel()
	 * @generated
	 */
	EReference getServiceModel_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.ServiceModel#getMappedComplexTypes <em>Mapped Complex Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapped Complex Types</em>'.
	 * @see de.fhdo.lemma.service.ServiceModel#getMappedComplexTypes()
	 * @see #getServiceModel()
	 * @generated
	 */
	EReference getServiceModel_MappedComplexTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.ServiceModel#getMicroservices <em>Microservices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Microservices</em>'.
	 * @see de.fhdo.lemma.service.ServiceModel#getMicroservices()
	 * @see #getServiceModel()
	 * @generated
	 */
	EReference getServiceModel_Microservices();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.ServiceModel#getContainedOperations() <em>Get Contained Operations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Contained Operations</em>' operation.
	 * @see de.fhdo.lemma.service.ServiceModel#getContainedOperations()
	 * @generated
	 */
	EOperation getServiceModel__GetContainedOperations();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.ServiceModel#getContainedReferredOperations() <em>Get Contained Referred Operations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Contained Referred Operations</em>' operation.
	 * @see de.fhdo.lemma.service.ServiceModel#getContainedReferredOperations()
	 * @generated
	 */
	EOperation getServiceModel__GetContainedReferredOperations();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.ServiceModel#getContainedInterfaces() <em>Get Contained Interfaces</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Contained Interfaces</em>' operation.
	 * @see de.fhdo.lemma.service.ServiceModel#getContainedInterfaces()
	 * @generated
	 */
	EOperation getServiceModel__GetContainedInterfaces();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see de.fhdo.lemma.service.Import
	 * @generated
	 */
	EClass getImport();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Import#getT_relatedImportAlias <em>Trelated Import Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trelated Import Alias</em>'.
	 * @see de.fhdo.lemma.service.Import#getT_relatedImportAlias()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_T_relatedImportAlias();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Import#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.service.Import#getName()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Import#getImportURI <em>Import URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import URI</em>'.
	 * @see de.fhdo.lemma.service.Import#getImportURI()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_ImportURI();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Import#getExternalURI <em>External URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External URI</em>'.
	 * @see de.fhdo.lemma.service.Import#getExternalURI()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_ExternalURI();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Import#getImportType <em>Import Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import Type</em>'.
	 * @see de.fhdo.lemma.service.Import#getImportType()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_ImportType();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.Import#getServiceModel <em>Service Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Service Model</em>'.
	 * @see de.fhdo.lemma.service.Import#getServiceModel()
	 * @see #getImport()
	 * @generated
	 */
	EReference getImport_ServiceModel();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.MappedComplexType <em>Mapped Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Complex Type</em>'.
	 * @see de.fhdo.lemma.service.MappedComplexType
	 * @generated
	 */
	EClass getMappedComplexType();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.MappedComplexType#getT_sourceModelUri <em>Tsource Model Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tsource Model Uri</em>'.
	 * @see de.fhdo.lemma.service.MappedComplexType#getT_sourceModelUri()
	 * @see #getMappedComplexType()
	 * @generated
	 */
	EAttribute getMappedComplexType_T_sourceModelUri();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.MappedComplexType#getT_typeDefinitionTechnologyImport <em>Ttype Definition Technology Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ttype Definition Technology Import</em>'.
	 * @see de.fhdo.lemma.service.MappedComplexType#getT_typeDefinitionTechnologyImport()
	 * @see #getMappedComplexType()
	 * @generated
	 */
	EReference getMappedComplexType_T_typeDefinitionTechnologyImport();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.MappedComplexType#getT_typeDefinitionTechnology <em>Ttype Definition Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ttype Definition Technology</em>'.
	 * @see de.fhdo.lemma.service.MappedComplexType#getT_typeDefinitionTechnology()
	 * @see #getMappedComplexType()
	 * @generated
	 */
	EReference getMappedComplexType_T_typeDefinitionTechnology();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.MappedComplexType#getTechnologyReferences <em>Technology References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Technology References</em>'.
	 * @see de.fhdo.lemma.service.MappedComplexType#getTechnologyReferences()
	 * @see #getMappedComplexType()
	 * @generated
	 */
	EReference getMappedComplexType_TechnologyReferences();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.service.MappedComplexType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see de.fhdo.lemma.service.MappedComplexType#getType()
	 * @see #getMappedComplexType()
	 * @generated
	 */
	EReference getMappedComplexType_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.MappedComplexType#getMappedFields <em>Mapped Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapped Fields</em>'.
	 * @see de.fhdo.lemma.service.MappedComplexType#getMappedFields()
	 * @see #getMappedComplexType()
	 * @generated
	 */
	EReference getMappedComplexType_MappedFields();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.MappedComplexType#getMappedOperations <em>Mapped Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapped Operations</em>'.
	 * @see de.fhdo.lemma.service.MappedComplexType#getMappedOperations()
	 * @see #getMappedComplexType()
	 * @generated
	 */
	EReference getMappedComplexType_MappedOperations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.MappedComplexType#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see de.fhdo.lemma.service.MappedComplexType#getAspects()
	 * @see #getMappedComplexType()
	 * @generated
	 */
	EReference getMappedComplexType_Aspects();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.MappedComplexType#getServiceModel <em>Service Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Service Model</em>'.
	 * @see de.fhdo.lemma.service.MappedComplexType#getServiceModel()
	 * @see #getMappedComplexType()
	 * @generated
	 */
	EReference getMappedComplexType_ServiceModel();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.MappedComplexType#getQualifiedNameParts(boolean) <em>Get Qualified Name Parts</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Qualified Name Parts</em>' operation.
	 * @see de.fhdo.lemma.service.MappedComplexType#getQualifiedNameParts(boolean)
	 * @generated
	 */
	EOperation getMappedComplexType__GetQualifiedNameParts__boolean();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.MappedComplexType#buildQualifiedName(java.lang.String, boolean) <em>Build Qualified Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Build Qualified Name</em>' operation.
	 * @see de.fhdo.lemma.service.MappedComplexType#buildQualifiedName(java.lang.String, boolean)
	 * @generated
	 */
	EOperation getMappedComplexType__BuildQualifiedName__String_boolean();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.MappedComplexType#getAllTypeDefinitionTechnologyReferences() <em>Get All Type Definition Technology References</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get All Type Definition Technology References</em>' operation.
	 * @see de.fhdo.lemma.service.MappedComplexType#getAllTypeDefinitionTechnologyReferences()
	 * @generated
	 */
	EOperation getMappedComplexType__GetAllTypeDefinitionTechnologyReferences();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.MappedComplexType#getTypeDefinitionTechnologyImport() <em>Get Type Definition Technology Import</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Definition Technology Import</em>' operation.
	 * @see de.fhdo.lemma.service.MappedComplexType#getTypeDefinitionTechnologyImport()
	 * @generated
	 */
	EOperation getMappedComplexType__GetTypeDefinitionTechnologyImport();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.MappedComplexType#getTypeDefinitionTechnology() <em>Get Type Definition Technology</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Definition Technology</em>' operation.
	 * @see de.fhdo.lemma.service.MappedComplexType#getTypeDefinitionTechnology()
	 * @generated
	 */
	EOperation getMappedComplexType__GetTypeDefinitionTechnology();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.MappedDataOperation <em>Mapped Data Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Data Operation</em>'.
	 * @see de.fhdo.lemma.service.MappedDataOperation
	 * @generated
	 */
	EClass getMappedDataOperation();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.MappedDataOperation#getDataOperation <em>Data Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Operation</em>'.
	 * @see de.fhdo.lemma.service.MappedDataOperation#getDataOperation()
	 * @see #getMappedDataOperation()
	 * @generated
	 */
	EReference getMappedDataOperation_DataOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.MappedDataOperation#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see de.fhdo.lemma.service.MappedDataOperation#getAspects()
	 * @see #getMappedDataOperation()
	 * @generated
	 */
	EReference getMappedDataOperation_Aspects();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.service.MappedDataOperation#getMappedReturnType <em>Mapped Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapped Return Type</em>'.
	 * @see de.fhdo.lemma.service.MappedDataOperation#getMappedReturnType()
	 * @see #getMappedDataOperation()
	 * @generated
	 */
	EReference getMappedDataOperation_MappedReturnType();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.MappedDataOperation#getMappedParameters <em>Mapped Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapped Parameters</em>'.
	 * @see de.fhdo.lemma.service.MappedDataOperation#getMappedParameters()
	 * @see #getMappedDataOperation()
	 * @generated
	 */
	EReference getMappedDataOperation_MappedParameters();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.MappedDataOperation#getMappedComplexType <em>Mapped Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapped Complex Type</em>'.
	 * @see de.fhdo.lemma.service.MappedDataOperation#getMappedComplexType()
	 * @see #getMappedDataOperation()
	 * @generated
	 */
	EReference getMappedDataOperation_MappedComplexType();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.MappedDataOperationReturnType <em>Mapped Data Operation Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Data Operation Return Type</em>'.
	 * @see de.fhdo.lemma.service.MappedDataOperationReturnType
	 * @generated
	 */
	EClass getMappedDataOperationReturnType();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.service.MappedDataOperationReturnType#getMappedType <em>Mapped Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapped Type</em>'.
	 * @see de.fhdo.lemma.service.MappedDataOperationReturnType#getMappedType()
	 * @see #getMappedDataOperationReturnType()
	 * @generated
	 */
	EReference getMappedDataOperationReturnType_MappedType();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.MappedDataOperationReturnType#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see de.fhdo.lemma.service.MappedDataOperationReturnType#getAspects()
	 * @see #getMappedDataOperationReturnType()
	 * @generated
	 */
	EReference getMappedDataOperationReturnType_Aspects();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.MappedDataOperationReturnType#getMappedOperation <em>Mapped Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapped Operation</em>'.
	 * @see de.fhdo.lemma.service.MappedDataOperationReturnType#getMappedOperation()
	 * @see #getMappedDataOperationReturnType()
	 * @generated
	 */
	EReference getMappedDataOperationReturnType_MappedOperation();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.MappedDataOperationParameter <em>Mapped Data Operation Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Data Operation Parameter</em>'.
	 * @see de.fhdo.lemma.service.MappedDataOperationParameter
	 * @generated
	 */
	EClass getMappedDataOperationParameter();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.MappedDataOperationParameter#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see de.fhdo.lemma.service.MappedDataOperationParameter#getParameter()
	 * @see #getMappedDataOperationParameter()
	 * @generated
	 */
	EReference getMappedDataOperationParameter_Parameter();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.service.MappedDataOperationParameter#getMappedType <em>Mapped Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapped Type</em>'.
	 * @see de.fhdo.lemma.service.MappedDataOperationParameter#getMappedType()
	 * @see #getMappedDataOperationParameter()
	 * @generated
	 */
	EReference getMappedDataOperationParameter_MappedType();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.MappedDataOperationParameter#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see de.fhdo.lemma.service.MappedDataOperationParameter#getAspects()
	 * @see #getMappedDataOperationParameter()
	 * @generated
	 */
	EReference getMappedDataOperationParameter_Aspects();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.MappedDataOperationParameter#getMappedOperation <em>Mapped Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapped Operation</em>'.
	 * @see de.fhdo.lemma.service.MappedDataOperationParameter#getMappedOperation()
	 * @see #getMappedDataOperationParameter()
	 * @generated
	 */
	EReference getMappedDataOperationParameter_MappedOperation();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.MappedField <em>Mapped Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Field</em>'.
	 * @see de.fhdo.lemma.service.MappedField
	 * @generated
	 */
	EClass getMappedField();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.MappedField#getDataField <em>Data Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Field</em>'.
	 * @see de.fhdo.lemma.service.MappedField#getDataField()
	 * @see #getMappedField()
	 * @generated
	 */
	EReference getMappedField_DataField();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.MappedField#getEnumerationField <em>Enumeration Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Enumeration Field</em>'.
	 * @see de.fhdo.lemma.service.MappedField#getEnumerationField()
	 * @see #getMappedField()
	 * @generated
	 */
	EReference getMappedField_EnumerationField();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.service.MappedField#getMappedType <em>Mapped Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapped Type</em>'.
	 * @see de.fhdo.lemma.service.MappedField#getMappedType()
	 * @see #getMappedField()
	 * @generated
	 */
	EReference getMappedField_MappedType();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.MappedField#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see de.fhdo.lemma.service.MappedField#getAspects()
	 * @see #getMappedField()
	 * @generated
	 */
	EReference getMappedField_Aspects();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.MappedField#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parameter</em>'.
	 * @see de.fhdo.lemma.service.MappedField#getParameter()
	 * @see #getMappedField()
	 * @generated
	 */
	EReference getMappedField_Parameter();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.MappedField#getMappedComplexType <em>Mapped Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapped Complex Type</em>'.
	 * @see de.fhdo.lemma.service.MappedField#getMappedComplexType()
	 * @see #getMappedField()
	 * @generated
	 */
	EReference getMappedField_MappedComplexType();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.MappedField#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.service.MappedField#getName()
	 * @see #getMappedField()
	 * @generated
	 */
	EAttribute getMappedField_Name();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.MappedField#getQualifiedNameParts(boolean) <em>Get Qualified Name Parts</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Qualified Name Parts</em>' operation.
	 * @see de.fhdo.lemma.service.MappedField#getQualifiedNameParts(boolean)
	 * @generated
	 */
	EOperation getMappedField__GetQualifiedNameParts__boolean();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.MappedField#buildQualifiedName(java.lang.String, boolean) <em>Build Qualified Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Build Qualified Name</em>' operation.
	 * @see de.fhdo.lemma.service.MappedField#buildQualifiedName(java.lang.String, boolean)
	 * @generated
	 */
	EOperation getMappedField__BuildQualifiedName__String_boolean();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.MappedField#getEffectiveType() <em>Get Effective Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Effective Type</em>' operation.
	 * @see de.fhdo.lemma.service.MappedField#getEffectiveType()
	 * @generated
	 */
	EOperation getMappedField__GetEffectiveType();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.Microservice <em>Microservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Microservice</em>'.
	 * @see de.fhdo.lemma.service.Microservice
	 * @generated
	 */
	EClass getMicroservice();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Microservice#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.service.Microservice#getName()
	 * @see #getMicroservice()
	 * @generated
	 */
	EAttribute getMicroservice_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Microservice#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see de.fhdo.lemma.service.Microservice#getVersion()
	 * @see #getMicroservice()
	 * @generated
	 */
	EAttribute getMicroservice_Version();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Microservice#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.fhdo.lemma.service.Microservice#getType()
	 * @see #getMicroservice()
	 * @generated
	 */
	EAttribute getMicroservice_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Microservice#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see de.fhdo.lemma.service.Microservice#getVisibility()
	 * @see #getMicroservice()
	 * @generated
	 */
	EAttribute getMicroservice_Visibility();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Microservice#getT_defaultProtocols <em>Tdefault Protocols</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tdefault Protocols</em>'.
	 * @see de.fhdo.lemma.service.Microservice#getT_defaultProtocols()
	 * @see #getMicroservice()
	 * @generated
	 */
	EAttribute getMicroservice_T_defaultProtocols();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Microservice#getT_sourceModelUri <em>Tsource Model Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tsource Model Uri</em>'.
	 * @see de.fhdo.lemma.service.Microservice#getT_sourceModelUri()
	 * @see #getMicroservice()
	 * @generated
	 */
	EAttribute getMicroservice_T_sourceModelUri();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.Microservice#getTechnologyReferences <em>Technology References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Technology References</em>'.
	 * @see de.fhdo.lemma.service.Microservice#getTechnologyReferences()
	 * @see #getMicroservice()
	 * @generated
	 */
	EReference getMicroservice_TechnologyReferences();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.Microservice#getT_typeDefinitionTechnologyImport <em>Ttype Definition Technology Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ttype Definition Technology Import</em>'.
	 * @see de.fhdo.lemma.service.Microservice#getT_typeDefinitionTechnologyImport()
	 * @see #getMicroservice()
	 * @generated
	 */
	EReference getMicroservice_T_typeDefinitionTechnologyImport();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.Microservice#getT_typeDefinitionTechnology <em>Ttype Definition Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ttype Definition Technology</em>'.
	 * @see de.fhdo.lemma.service.Microservice#getT_typeDefinitionTechnology()
	 * @see #getMicroservice()
	 * @generated
	 */
	EReference getMicroservice_T_typeDefinitionTechnology();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.Microservice#getEndpoints <em>Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Endpoints</em>'.
	 * @see de.fhdo.lemma.service.Microservice#getEndpoints()
	 * @see #getMicroservice()
	 * @generated
	 */
	EReference getMicroservice_Endpoints();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.Microservice#getRequiredMicroservices <em>Required Microservices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Required Microservices</em>'.
	 * @see de.fhdo.lemma.service.Microservice#getRequiredMicroservices()
	 * @see #getMicroservice()
	 * @generated
	 */
	EReference getMicroservice_RequiredMicroservices();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.Microservice#getRequiredInterfaces <em>Required Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Required Interfaces</em>'.
	 * @see de.fhdo.lemma.service.Microservice#getRequiredInterfaces()
	 * @see #getMicroservice()
	 * @generated
	 */
	EReference getMicroservice_RequiredInterfaces();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.Microservice#getRequiredOperations <em>Required Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Required Operations</em>'.
	 * @see de.fhdo.lemma.service.Microservice#getRequiredOperations()
	 * @see #getMicroservice()
	 * @generated
	 */
	EReference getMicroservice_RequiredOperations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.Microservice#getProtocols <em>Protocols</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Protocols</em>'.
	 * @see de.fhdo.lemma.service.Microservice#getProtocols()
	 * @see #getMicroservice()
	 * @generated
	 */
	EReference getMicroservice_Protocols();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.Microservice#getInterfaces <em>Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Interfaces</em>'.
	 * @see de.fhdo.lemma.service.Microservice#getInterfaces()
	 * @see #getMicroservice()
	 * @generated
	 */
	EReference getMicroservice_Interfaces();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.Microservice#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see de.fhdo.lemma.service.Microservice#getAspects()
	 * @see #getMicroservice()
	 * @generated
	 */
	EReference getMicroservice_Aspects();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.Microservice#getServiceModel <em>Service Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Service Model</em>'.
	 * @see de.fhdo.lemma.service.Microservice#getServiceModel()
	 * @see #getMicroservice()
	 * @generated
	 */
	EReference getMicroservice_ServiceModel();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Microservice#isEffectivelyImplemented <em>Effectively Implemented</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effectively Implemented</em>'.
	 * @see de.fhdo.lemma.service.Microservice#isEffectivelyImplemented()
	 * @see #getMicroservice()
	 * @generated
	 */
	EAttribute getMicroservice_EffectivelyImplemented();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Microservice#getEffectiveVisibility <em>Effective Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effective Visibility</em>'.
	 * @see de.fhdo.lemma.service.Microservice#getEffectiveVisibility()
	 * @see #getMicroservice()
	 * @generated
	 */
	EAttribute getMicroservice_EffectiveVisibility();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Microservice#isEffectivelyInternal <em>Effectively Internal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effectively Internal</em>'.
	 * @see de.fhdo.lemma.service.Microservice#isEffectivelyInternal()
	 * @see #getMicroservice()
	 * @generated
	 */
	EAttribute getMicroservice_EffectivelyInternal();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Microservice#t_effectiveProtocolSpecifications() <em>Teffective Protocol Specifications</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Teffective Protocol Specifications</em>' operation.
	 * @see de.fhdo.lemma.service.Microservice#t_effectiveProtocolSpecifications()
	 * @generated
	 */
	EOperation getMicroservice__T_effectiveProtocolSpecifications();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Microservice#getAllTypeDefinitionTechnologyReferences() <em>Get All Type Definition Technology References</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get All Type Definition Technology References</em>' operation.
	 * @see de.fhdo.lemma.service.Microservice#getAllTypeDefinitionTechnologyReferences()
	 * @generated
	 */
	EOperation getMicroservice__GetAllTypeDefinitionTechnologyReferences();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Microservice#getTypeDefinitionTechnologyImport() <em>Get Type Definition Technology Import</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Definition Technology Import</em>' operation.
	 * @see de.fhdo.lemma.service.Microservice#getTypeDefinitionTechnologyImport()
	 * @generated
	 */
	EOperation getMicroservice__GetTypeDefinitionTechnologyImport();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Microservice#getTypeDefinitionTechnology() <em>Get Type Definition Technology</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Definition Technology</em>' operation.
	 * @see de.fhdo.lemma.service.Microservice#getTypeDefinitionTechnology()
	 * @generated
	 */
	EOperation getMicroservice__GetTypeDefinitionTechnology();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Microservice#getQualifiedNameParts() <em>Get Qualified Name Parts</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Qualified Name Parts</em>' operation.
	 * @see de.fhdo.lemma.service.Microservice#getQualifiedNameParts()
	 * @generated
	 */
	EOperation getMicroservice__GetQualifiedNameParts();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Microservice#buildQualifiedName(java.lang.String) <em>Build Qualified Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Build Qualified Name</em>' operation.
	 * @see de.fhdo.lemma.service.Microservice#buildQualifiedName(java.lang.String)
	 * @generated
	 */
	EOperation getMicroservice__BuildQualifiedName__String();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Microservice#getContainedOperations() <em>Get Contained Operations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Contained Operations</em>' operation.
	 * @see de.fhdo.lemma.service.Microservice#getContainedOperations()
	 * @generated
	 */
	EOperation getMicroservice__GetContainedOperations();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Microservice#getContainedReferredOperations() <em>Get Contained Referred Operations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Contained Referred Operations</em>' operation.
	 * @see de.fhdo.lemma.service.Microservice#getContainedReferredOperations()
	 * @generated
	 */
	EOperation getMicroservice__GetContainedReferredOperations();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Microservice#getRequiredImports() <em>Get Required Imports</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Required Imports</em>' operation.
	 * @see de.fhdo.lemma.service.Microservice#getRequiredImports()
	 * @generated
	 */
	EOperation getMicroservice__GetRequiredImports();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Microservice#getAllRequiredOperations(de.fhdo.lemma.service.Import) <em>Get All Required Operations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get All Required Operations</em>' operation.
	 * @see de.fhdo.lemma.service.Microservice#getAllRequiredOperations(de.fhdo.lemma.service.Import)
	 * @generated
	 */
	EOperation getMicroservice__GetAllRequiredOperations__Import();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Microservice#getAllRequiredMicroservices() <em>Get All Required Microservices</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get All Required Microservices</em>' operation.
	 * @see de.fhdo.lemma.service.Microservice#getAllRequiredMicroservices()
	 * @generated
	 */
	EOperation getMicroservice__GetAllRequiredMicroservices();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Microservice#getAllInitializingMicroservices() <em>Get All Initializing Microservices</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get All Initializing Microservices</em>' operation.
	 * @see de.fhdo.lemma.service.Microservice#getAllInitializingMicroservices()
	 * @generated
	 */
	EOperation getMicroservice__GetAllInitializingMicroservices();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Microservice#canRequire(de.fhdo.lemma.service.Microservice, boolean) <em>Can Require</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Can Require</em>' operation.
	 * @see de.fhdo.lemma.service.Microservice#canRequire(de.fhdo.lemma.service.Microservice, boolean)
	 * @generated
	 */
	EOperation getMicroservice__CanRequire__Microservice_boolean();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Microservice#canRequire(de.fhdo.lemma.service.Interface, boolean) <em>Can Require</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Can Require</em>' operation.
	 * @see de.fhdo.lemma.service.Microservice#canRequire(de.fhdo.lemma.service.Interface, boolean)
	 * @generated
	 */
	EOperation getMicroservice__CanRequire__Interface_boolean();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Microservice#canRequire(de.fhdo.lemma.service.Operation, boolean) <em>Can Require</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Can Require</em>' operation.
	 * @see de.fhdo.lemma.service.Microservice#canRequire(de.fhdo.lemma.service.Operation, boolean)
	 * @generated
	 */
	EOperation getMicroservice__CanRequire__Operation_boolean();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.TechnologyReference <em>Technology Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Technology Reference</em>'.
	 * @see de.fhdo.lemma.service.TechnologyReference
	 * @generated
	 */
	EClass getTechnologyReference();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.TechnologyReference#isIsTypeDefinitionTechnology <em>Is Type Definition Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Type Definition Technology</em>'.
	 * @see de.fhdo.lemma.service.TechnologyReference#isIsTypeDefinitionTechnology()
	 * @see #getTechnologyReference()
	 * @generated
	 */
	EAttribute getTechnologyReference_IsTypeDefinitionTechnology();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.TechnologyReference#getTechnology <em>Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Technology</em>'.
	 * @see de.fhdo.lemma.service.TechnologyReference#getTechnology()
	 * @see #getTechnologyReference()
	 * @generated
	 */
	EReference getTechnologyReference_Technology();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.TechnologyReference#getMicroservice <em>Microservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Microservice</em>'.
	 * @see de.fhdo.lemma.service.TechnologyReference#getMicroservice()
	 * @see #getTechnologyReference()
	 * @generated
	 */
	EReference getTechnologyReference_Microservice();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.TechnologyReference#getMappedComplexType <em>Mapped Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapped Complex Type</em>'.
	 * @see de.fhdo.lemma.service.TechnologyReference#getMappedComplexType()
	 * @see #getTechnologyReference()
	 * @generated
	 */
	EReference getTechnologyReference_MappedComplexType();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface</em>'.
	 * @see de.fhdo.lemma.service.Interface
	 * @generated
	 */
	EClass getInterface();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Interface#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.service.Interface#getName()
	 * @see #getInterface()
	 * @generated
	 */
	EAttribute getInterface_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Interface#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see de.fhdo.lemma.service.Interface#getVersion()
	 * @see #getInterface()
	 * @generated
	 */
	EAttribute getInterface_Version();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Interface#isNotImplemented <em>Not Implemented</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Not Implemented</em>'.
	 * @see de.fhdo.lemma.service.Interface#isNotImplemented()
	 * @see #getInterface()
	 * @generated
	 */
	EAttribute getInterface_NotImplemented();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Interface#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see de.fhdo.lemma.service.Interface#getVisibility()
	 * @see #getInterface()
	 * @generated
	 */
	EAttribute getInterface_Visibility();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.Interface#getEndpoints <em>Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Endpoints</em>'.
	 * @see de.fhdo.lemma.service.Interface#getEndpoints()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_Endpoints();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.Interface#getProtocols <em>Protocols</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Protocols</em>'.
	 * @see de.fhdo.lemma.service.Interface#getProtocols()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_Protocols();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.Interface#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see de.fhdo.lemma.service.Interface#getOperations()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_Operations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.Interface#getReferredOperations <em>Referred Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Referred Operations</em>'.
	 * @see de.fhdo.lemma.service.Interface#getReferredOperations()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_ReferredOperations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.Interface#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see de.fhdo.lemma.service.Interface#getAspects()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_Aspects();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.Interface#getMicroservice <em>Microservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Microservice</em>'.
	 * @see de.fhdo.lemma.service.Interface#getMicroservice()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_Microservice();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Interface#getEffectiveVisibility <em>Effective Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effective Visibility</em>'.
	 * @see de.fhdo.lemma.service.Interface#getEffectiveVisibility()
	 * @see #getInterface()
	 * @generated
	 */
	EAttribute getInterface_EffectiveVisibility();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Interface#isEffectivelyImplemented <em>Effectively Implemented</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effectively Implemented</em>'.
	 * @see de.fhdo.lemma.service.Interface#isEffectivelyImplemented()
	 * @see #getInterface()
	 * @generated
	 */
	EAttribute getInterface_EffectivelyImplemented();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Interface#isEffectivelyInternal <em>Effectively Internal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effectively Internal</em>'.
	 * @see de.fhdo.lemma.service.Interface#isEffectivelyInternal()
	 * @see #getInterface()
	 * @generated
	 */
	EAttribute getInterface_EffectivelyInternal();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Interface#t_effectiveProtocolSpecifications() <em>Teffective Protocol Specifications</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Teffective Protocol Specifications</em>' operation.
	 * @see de.fhdo.lemma.service.Interface#t_effectiveProtocolSpecifications()
	 * @generated
	 */
	EOperation getInterface__T_effectiveProtocolSpecifications();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Interface#getQualifiedNameParts() <em>Get Qualified Name Parts</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Qualified Name Parts</em>' operation.
	 * @see de.fhdo.lemma.service.Interface#getQualifiedNameParts()
	 * @generated
	 */
	EOperation getInterface__GetQualifiedNameParts();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Interface#buildQualifiedName(java.lang.String) <em>Build Qualified Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Build Qualified Name</em>' operation.
	 * @see de.fhdo.lemma.service.Interface#buildQualifiedName(java.lang.String)
	 * @generated
	 */
	EOperation getInterface__BuildQualifiedName__String();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see de.fhdo.lemma.service.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Operation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.service.Operation#getName()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Operation#isNotImplemented <em>Not Implemented</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Not Implemented</em>'.
	 * @see de.fhdo.lemma.service.Operation#isNotImplemented()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_NotImplemented();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Operation#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see de.fhdo.lemma.service.Operation#getVisibility()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Visibility();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.service.Operation#getApiOperationComment <em>Api Operation Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Api Operation Comment</em>'.
	 * @see de.fhdo.lemma.service.Operation#getApiOperationComment()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_ApiOperationComment();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.Operation#getEndpoints <em>Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Endpoints</em>'.
	 * @see de.fhdo.lemma.service.Operation#getEndpoints()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Endpoints();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.Operation#getProtocols <em>Protocols</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Protocols</em>'.
	 * @see de.fhdo.lemma.service.Operation#getProtocols()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Protocols();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.Operation#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see de.fhdo.lemma.service.Operation#getParameters()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.Operation#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see de.fhdo.lemma.service.Operation#getAspects()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Aspects();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.Operation#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Interface</em>'.
	 * @see de.fhdo.lemma.service.Operation#getInterface()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Interface();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Operation#isNotImplementedByContainer <em>Not Implemented By Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Not Implemented By Container</em>'.
	 * @see de.fhdo.lemma.service.Operation#isNotImplementedByContainer()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_NotImplementedByContainer();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Operation#isEffectivelyNotImplemented <em>Effectively Not Implemented</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effectively Not Implemented</em>'.
	 * @see de.fhdo.lemma.service.Operation#isEffectivelyNotImplemented()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_EffectivelyNotImplemented();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Operation#getEffectiveVisibility <em>Effective Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effective Visibility</em>'.
	 * @see de.fhdo.lemma.service.Operation#getEffectiveVisibility()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_EffectiveVisibility();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Operation#isEffectivelyInternal <em>Effectively Internal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effectively Internal</em>'.
	 * @see de.fhdo.lemma.service.Operation#isEffectivelyInternal()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_EffectivelyInternal();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Operation#t_effectiveProtocolSpecifications() <em>Teffective Protocol Specifications</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Teffective Protocol Specifications</em>' operation.
	 * @see de.fhdo.lemma.service.Operation#t_effectiveProtocolSpecifications()
	 * @generated
	 */
	EOperation getOperation__T_effectiveProtocolSpecifications();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Operation#getQualifiedNameParts() <em>Get Qualified Name Parts</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Qualified Name Parts</em>' operation.
	 * @see de.fhdo.lemma.service.Operation#getQualifiedNameParts()
	 * @generated
	 */
	EOperation getOperation__GetQualifiedNameParts();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Operation#buildQualifiedName(java.lang.String) <em>Build Qualified Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Build Qualified Name</em>' operation.
	 * @see de.fhdo.lemma.service.Operation#buildQualifiedName(java.lang.String)
	 * @generated
	 */
	EOperation getOperation__BuildQualifiedName__String();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.ApiOperationComment <em>Api Operation Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Api Operation Comment</em>'.
	 * @see de.fhdo.lemma.service.ApiOperationComment
	 * @generated
	 */
	EClass getApiOperationComment();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.ApiOperationComment#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.fhdo.lemma.service.ApiOperationComment#getComment()
	 * @see #getApiOperationComment()
	 * @generated
	 */
	EAttribute getApiOperationComment_Comment();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.ApiOperationComment#getParameterComments <em>Parameter Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Comments</em>'.
	 * @see de.fhdo.lemma.service.ApiOperationComment#getParameterComments()
	 * @see #getApiOperationComment()
	 * @generated
	 */
	EReference getApiOperationComment_ParameterComments();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.ApiOperationComment#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Operation</em>'.
	 * @see de.fhdo.lemma.service.ApiOperationComment#getOperation()
	 * @see #getApiOperationComment()
	 * @generated
	 */
	EReference getApiOperationComment_Operation();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.ApiParameterComment <em>Api Parameter Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Api Parameter Comment</em>'.
	 * @see de.fhdo.lemma.service.ApiParameterComment
	 * @generated
	 */
	EClass getApiParameterComment();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.ApiParameterComment#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.fhdo.lemma.service.ApiParameterComment#getComment()
	 * @see #getApiParameterComment()
	 * @generated
	 */
	EAttribute getApiParameterComment_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.ApiParameterComment#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see de.fhdo.lemma.service.ApiParameterComment#isRequired()
	 * @see #getApiParameterComment()
	 * @generated
	 */
	EAttribute getApiParameterComment_Required();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.ApiParameterComment#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see de.fhdo.lemma.service.ApiParameterComment#getParameter()
	 * @see #getApiParameterComment()
	 * @generated
	 */
	EReference getApiParameterComment_Parameter();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.ApiParameterComment#getOperationComment <em>Operation Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Operation Comment</em>'.
	 * @see de.fhdo.lemma.service.ApiParameterComment#getOperationComment()
	 * @see #getApiParameterComment()
	 * @generated
	 */
	EReference getApiParameterComment_OperationComment();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.ReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Referred Operation</em>'.
	 * @see de.fhdo.lemma.service.ReferredOperation
	 * @generated
	 */
	EClass getReferredOperation();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.ReferredOperation#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see de.fhdo.lemma.service.ReferredOperation#getOperation()
	 * @see #getReferredOperation()
	 * @generated
	 */
	EReference getReferredOperation_Operation();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.ReferredOperation#getEndpoints <em>Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Endpoints</em>'.
	 * @see de.fhdo.lemma.service.ReferredOperation#getEndpoints()
	 * @see #getReferredOperation()
	 * @generated
	 */
	EReference getReferredOperation_Endpoints();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.ReferredOperation#getProtocols <em>Protocols</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Protocols</em>'.
	 * @see de.fhdo.lemma.service.ReferredOperation#getProtocols()
	 * @see #getReferredOperation()
	 * @generated
	 */
	EReference getReferredOperation_Protocols();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.ReferredOperation#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see de.fhdo.lemma.service.ReferredOperation#getAspects()
	 * @see #getReferredOperation()
	 * @generated
	 */
	EReference getReferredOperation_Aspects();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.ReferredOperation#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Interface</em>'.
	 * @see de.fhdo.lemma.service.ReferredOperation#getInterface()
	 * @see #getReferredOperation()
	 * @generated
	 */
	EReference getReferredOperation_Interface();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.ReferredOperation#t_effectiveProtocolSpecifications() <em>Teffective Protocol Specifications</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Teffective Protocol Specifications</em>' operation.
	 * @see de.fhdo.lemma.service.ReferredOperation#t_effectiveProtocolSpecifications()
	 * @generated
	 */
	EOperation getReferredOperation__T_effectiveProtocolSpecifications();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.ReferredOperation#getQualifiedNameParts() <em>Get Qualified Name Parts</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Qualified Name Parts</em>' operation.
	 * @see de.fhdo.lemma.service.ReferredOperation#getQualifiedNameParts()
	 * @generated
	 */
	EOperation getReferredOperation__GetQualifiedNameParts();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.ReferredOperation#buildQualifiedName(java.lang.String) <em>Build Qualified Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Build Qualified Name</em>' operation.
	 * @see de.fhdo.lemma.service.ReferredOperation#buildQualifiedName(java.lang.String)
	 * @generated
	 */
	EOperation getReferredOperation__BuildQualifiedName__String();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see de.fhdo.lemma.service.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.service.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Parameter#getExchangePattern <em>Exchange Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exchange Pattern</em>'.
	 * @see de.fhdo.lemma.service.Parameter#getExchangePattern()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_ExchangePattern();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Parameter#getCommunicationType <em>Communication Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Communication Type</em>'.
	 * @see de.fhdo.lemma.service.Parameter#getCommunicationType()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_CommunicationType();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Parameter#isCommunicatesFault <em>Communicates Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Communicates Fault</em>'.
	 * @see de.fhdo.lemma.service.Parameter#isCommunicatesFault()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_CommunicatesFault();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.Parameter#isOptional <em>Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optional</em>'.
	 * @see de.fhdo.lemma.service.Parameter#isOptional()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Optional();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.service.Parameter#getInitializedByOperation <em>Initialized By Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initialized By Operation</em>'.
	 * @see de.fhdo.lemma.service.Parameter#getInitializedByOperation()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_InitializedByOperation();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.service.Parameter#getImportedType <em>Imported Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Imported Type</em>'.
	 * @see de.fhdo.lemma.service.Parameter#getImportedType()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_ImportedType();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.service.Parameter#getPrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Primitive Type</em>'.
	 * @see de.fhdo.lemma.service.Parameter#getPrimitiveType()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_PrimitiveType();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.Parameter#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see de.fhdo.lemma.service.Parameter#getAspects()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Aspects();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.Parameter#getMappedFields <em>Mapped Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapped Fields</em>'.
	 * @see de.fhdo.lemma.service.Parameter#getMappedFields()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_MappedFields();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.service.Parameter#getOriginalImportedType <em>Original Imported Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Original Imported Type</em>'.
	 * @see de.fhdo.lemma.service.Parameter#getOriginalImportedType()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_OriginalImportedType();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.service.Parameter#getOriginalPrimitiveType <em>Original Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Original Primitive Type</em>'.
	 * @see de.fhdo.lemma.service.Parameter#getOriginalPrimitiveType()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_OriginalPrimitiveType();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.Parameter#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Operation</em>'.
	 * @see de.fhdo.lemma.service.Parameter#getOperation()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Operation();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Parameter#getQualifiedNameParts() <em>Get Qualified Name Parts</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Qualified Name Parts</em>' operation.
	 * @see de.fhdo.lemma.service.Parameter#getQualifiedNameParts()
	 * @generated
	 */
	EOperation getParameter__GetQualifiedNameParts();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Parameter#buildQualifiedName(java.lang.String) <em>Build Qualified Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Build Qualified Name</em>' operation.
	 * @see de.fhdo.lemma.service.Parameter#buildQualifiedName(java.lang.String)
	 * @generated
	 */
	EOperation getParameter__BuildQualifiedName__String();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Parameter#basicallyInitializableBy(de.fhdo.lemma.service.Operation) <em>Basically Initializable By</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Basically Initializable By</em>' operation.
	 * @see de.fhdo.lemma.service.Parameter#basicallyInitializableBy(de.fhdo.lemma.service.Operation)
	 * @generated
	 */
	EOperation getParameter__BasicallyInitializableBy__Operation();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Parameter#getEffectiveType() <em>Get Effective Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Effective Type</em>' operation.
	 * @see de.fhdo.lemma.service.Parameter#getEffectiveType()
	 * @generated
	 */
	EOperation getParameter__GetEffectiveType();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Parameter#isTechnologySpecificEffectiveType() <em>Is Technology Specific Effective Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Technology Specific Effective Type</em>' operation.
	 * @see de.fhdo.lemma.service.Parameter#isTechnologySpecificEffectiveType()
	 * @generated
	 */
	EOperation getParameter__IsTechnologySpecificEffectiveType();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.Parameter#getEffectiveTypeQualifiedNameParts() <em>Get Effective Type Qualified Name Parts</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Effective Type Qualified Name Parts</em>' operation.
	 * @see de.fhdo.lemma.service.Parameter#getEffectiveTypeQualifiedNameParts()
	 * @generated
	 */
	EOperation getParameter__GetEffectiveTypeQualifiedNameParts();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.PossiblyImportedMicroservice <em>Possibly Imported Microservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Possibly Imported Microservice</em>'.
	 * @see de.fhdo.lemma.service.PossiblyImportedMicroservice
	 * @generated
	 */
	EClass getPossiblyImportedMicroservice();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.PossiblyImportedMicroservice#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Import</em>'.
	 * @see de.fhdo.lemma.service.PossiblyImportedMicroservice#getImport()
	 * @see #getPossiblyImportedMicroservice()
	 * @generated
	 */
	EReference getPossiblyImportedMicroservice_Import();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.PossiblyImportedMicroservice#getMicroservice <em>Microservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Microservice</em>'.
	 * @see de.fhdo.lemma.service.PossiblyImportedMicroservice#getMicroservice()
	 * @see #getPossiblyImportedMicroservice()
	 * @generated
	 */
	EReference getPossiblyImportedMicroservice_Microservice();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.PossiblyImportedMicroservice#getRequiringMicroservice <em>Requiring Microservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Requiring Microservice</em>'.
	 * @see de.fhdo.lemma.service.PossiblyImportedMicroservice#getRequiringMicroservice()
	 * @see #getPossiblyImportedMicroservice()
	 * @generated
	 */
	EReference getPossiblyImportedMicroservice_RequiringMicroservice();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.PossiblyImportedInterface <em>Possibly Imported Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Possibly Imported Interface</em>'.
	 * @see de.fhdo.lemma.service.PossiblyImportedInterface
	 * @generated
	 */
	EClass getPossiblyImportedInterface();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.PossiblyImportedInterface#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Import</em>'.
	 * @see de.fhdo.lemma.service.PossiblyImportedInterface#getImport()
	 * @see #getPossiblyImportedInterface()
	 * @generated
	 */
	EReference getPossiblyImportedInterface_Import();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.PossiblyImportedInterface#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Interface</em>'.
	 * @see de.fhdo.lemma.service.PossiblyImportedInterface#getInterface()
	 * @see #getPossiblyImportedInterface()
	 * @generated
	 */
	EReference getPossiblyImportedInterface_Interface();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.PossiblyImportedInterface#getRequiringMicroservice <em>Requiring Microservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Requiring Microservice</em>'.
	 * @see de.fhdo.lemma.service.PossiblyImportedInterface#getRequiringMicroservice()
	 * @see #getPossiblyImportedInterface()
	 * @generated
	 */
	EReference getPossiblyImportedInterface_RequiringMicroservice();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.PossiblyImportedInterface#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see de.fhdo.lemma.service.PossiblyImportedInterface#isRequired()
	 * @see #getPossiblyImportedInterface()
	 * @generated
	 */
	EAttribute getPossiblyImportedInterface_Required();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.PossiblyImportedInterface#isRequiredByContainer <em>Required By Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required By Container</em>'.
	 * @see de.fhdo.lemma.service.PossiblyImportedInterface#isRequiredByContainer()
	 * @see #getPossiblyImportedInterface()
	 * @generated
	 */
	EAttribute getPossiblyImportedInterface_RequiredByContainer();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.PossiblyImportedOperation <em>Possibly Imported Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Possibly Imported Operation</em>'.
	 * @see de.fhdo.lemma.service.PossiblyImportedOperation
	 * @generated
	 */
	EClass getPossiblyImportedOperation();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.PossiblyImportedOperation#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Import</em>'.
	 * @see de.fhdo.lemma.service.PossiblyImportedOperation#getImport()
	 * @see #getPossiblyImportedOperation()
	 * @generated
	 */
	EReference getPossiblyImportedOperation_Import();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.PossiblyImportedOperation#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see de.fhdo.lemma.service.PossiblyImportedOperation#getOperation()
	 * @see #getPossiblyImportedOperation()
	 * @generated
	 */
	EReference getPossiblyImportedOperation_Operation();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.PossiblyImportedOperation#getRequiringMicroservice <em>Requiring Microservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Requiring Microservice</em>'.
	 * @see de.fhdo.lemma.service.PossiblyImportedOperation#getRequiringMicroservice()
	 * @see #getPossiblyImportedOperation()
	 * @generated
	 */
	EReference getPossiblyImportedOperation_RequiringMicroservice();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.PossiblyImportedOperation#getInitializedParameter <em>Initialized Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Initialized Parameter</em>'.
	 * @see de.fhdo.lemma.service.PossiblyImportedOperation#getInitializedParameter()
	 * @see #getPossiblyImportedOperation()
	 * @generated
	 */
	EReference getPossiblyImportedOperation_InitializedParameter();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.PossiblyImportedOperation#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see de.fhdo.lemma.service.PossiblyImportedOperation#isRequired()
	 * @see #getPossiblyImportedOperation()
	 * @generated
	 */
	EAttribute getPossiblyImportedOperation_Required();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.PossiblyImportedOperation#isRequiredByInterface <em>Required By Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required By Interface</em>'.
	 * @see de.fhdo.lemma.service.PossiblyImportedOperation#isRequiredByInterface()
	 * @see #getPossiblyImportedOperation()
	 * @generated
	 */
	EAttribute getPossiblyImportedOperation_RequiredByInterface();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.PossiblyImportedOperation#isRequiredByMicroservice <em>Required By Microservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required By Microservice</em>'.
	 * @see de.fhdo.lemma.service.PossiblyImportedOperation#isRequiredByMicroservice()
	 * @see #getPossiblyImportedOperation()
	 * @generated
	 */
	EAttribute getPossiblyImportedOperation_RequiredByMicroservice();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.PossiblyImportedOperation#isRequiredByContainer <em>Required By Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required By Container</em>'.
	 * @see de.fhdo.lemma.service.PossiblyImportedOperation#isRequiredByContainer()
	 * @see #getPossiblyImportedOperation()
	 * @generated
	 */
	EAttribute getPossiblyImportedOperation_RequiredByContainer();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.ImportedType <em>Imported Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imported Type</em>'.
	 * @see de.fhdo.lemma.service.ImportedType
	 * @generated
	 */
	EClass getImportedType();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.ImportedType#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Import</em>'.
	 * @see de.fhdo.lemma.service.ImportedType#getImport()
	 * @see #getImportedType()
	 * @generated
	 */
	EReference getImportedType_Import();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.ImportedType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see de.fhdo.lemma.service.ImportedType#getType()
	 * @see #getImportedType()
	 * @generated
	 */
	EReference getImportedType_Type();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.ImportedProtocolAndDataFormat <em>Imported Protocol And Data Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imported Protocol And Data Format</em>'.
	 * @see de.fhdo.lemma.service.ImportedProtocolAndDataFormat
	 * @generated
	 */
	EClass getImportedProtocolAndDataFormat();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.ImportedProtocolAndDataFormat#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Import</em>'.
	 * @see de.fhdo.lemma.service.ImportedProtocolAndDataFormat#getImport()
	 * @see #getImportedProtocolAndDataFormat()
	 * @generated
	 */
	EReference getImportedProtocolAndDataFormat_Import();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.ImportedProtocolAndDataFormat#getImportedProtocol <em>Imported Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Imported Protocol</em>'.
	 * @see de.fhdo.lemma.service.ImportedProtocolAndDataFormat#getImportedProtocol()
	 * @see #getImportedProtocolAndDataFormat()
	 * @generated
	 */
	EReference getImportedProtocolAndDataFormat_ImportedProtocol();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.ImportedProtocolAndDataFormat#getDataFormat <em>Data Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Format</em>'.
	 * @see de.fhdo.lemma.service.ImportedProtocolAndDataFormat#getDataFormat()
	 * @see #getImportedProtocolAndDataFormat()
	 * @generated
	 */
	EReference getImportedProtocolAndDataFormat_DataFormat();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.ImportedProtocolAndDataFormat#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Specification</em>'.
	 * @see de.fhdo.lemma.service.ImportedProtocolAndDataFormat#getSpecification()
	 * @see #getImportedProtocolAndDataFormat()
	 * @generated
	 */
	EReference getImportedProtocolAndDataFormat_Specification();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.ImportedProtocolAndDataFormat#getEndpoint <em>Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Endpoint</em>'.
	 * @see de.fhdo.lemma.service.ImportedProtocolAndDataFormat#getEndpoint()
	 * @see #getImportedProtocolAndDataFormat()
	 * @generated
	 */
	EReference getImportedProtocolAndDataFormat_Endpoint();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.ProtocolSpecification <em>Protocol Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Protocol Specification</em>'.
	 * @see de.fhdo.lemma.service.ProtocolSpecification
	 * @generated
	 */
	EClass getProtocolSpecification();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.service.ProtocolSpecification#getCommunicationType <em>Communication Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Communication Type</em>'.
	 * @see de.fhdo.lemma.service.ProtocolSpecification#getCommunicationType()
	 * @see #getProtocolSpecification()
	 * @generated
	 */
	EAttribute getProtocolSpecification_CommunicationType();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.service.ProtocolSpecification#getProtocol <em>Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Protocol</em>'.
	 * @see de.fhdo.lemma.service.ProtocolSpecification#getProtocol()
	 * @see #getProtocolSpecification()
	 * @generated
	 */
	EReference getProtocolSpecification_Protocol();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.service.ProtocolSpecification#effectiveProtocolSpecifications(org.eclipse.emf.common.util.EList) <em>Effective Protocol Specifications</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Effective Protocol Specifications</em>' operation.
	 * @see de.fhdo.lemma.service.ProtocolSpecification#effectiveProtocolSpecifications(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getProtocolSpecification__EffectiveProtocolSpecifications__EList();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.Endpoint <em>Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Endpoint</em>'.
	 * @see de.fhdo.lemma.service.Endpoint
	 * @generated
	 */
	EClass getEndpoint();

	/**
	 * Returns the meta object for the attribute list '{@link de.fhdo.lemma.service.Endpoint#getAddresses <em>Addresses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Addresses</em>'.
	 * @see de.fhdo.lemma.service.Endpoint#getAddresses()
	 * @see #getEndpoint()
	 * @generated
	 */
	EAttribute getEndpoint_Addresses();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.Endpoint#getProtocols <em>Protocols</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Protocols</em>'.
	 * @see de.fhdo.lemma.service.Endpoint#getProtocols()
	 * @see #getEndpoint()
	 * @generated
	 */
	EReference getEndpoint_Protocols();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.Endpoint#getMicroservice <em>Microservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Microservice</em>'.
	 * @see de.fhdo.lemma.service.Endpoint#getMicroservice()
	 * @see #getEndpoint()
	 * @generated
	 */
	EReference getEndpoint_Microservice();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.Endpoint#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Interface</em>'.
	 * @see de.fhdo.lemma.service.Endpoint#getInterface()
	 * @see #getEndpoint()
	 * @generated
	 */
	EReference getEndpoint_Interface();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.Endpoint#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Operation</em>'.
	 * @see de.fhdo.lemma.service.Endpoint#getOperation()
	 * @see #getEndpoint()
	 * @generated
	 */
	EReference getEndpoint_Operation();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.Endpoint#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Referred Operation</em>'.
	 * @see de.fhdo.lemma.service.Endpoint#getReferredOperation()
	 * @see #getEndpoint()
	 * @generated
	 */
	EReference getEndpoint_ReferredOperation();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.service.ImportedServiceAspect <em>Imported Service Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imported Service Aspect</em>'.
	 * @see de.fhdo.lemma.service.ImportedServiceAspect
	 * @generated
	 */
	EClass getImportedServiceAspect();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.ImportedServiceAspect#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Import</em>'.
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getImport()
	 * @see #getImportedServiceAspect()
	 * @generated
	 */
	EReference getImportedServiceAspect_Import();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.service.ImportedServiceAspect#getImportedAspect <em>Imported Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Imported Aspect</em>'.
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getImportedAspect()
	 * @see #getImportedServiceAspect()
	 * @generated
	 */
	EReference getImportedServiceAspect_ImportedAspect();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.service.ImportedServiceAspect#getSinglePropertyValue <em>Single Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Single Property Value</em>'.
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getSinglePropertyValue()
	 * @see #getImportedServiceAspect()
	 * @generated
	 */
	EReference getImportedServiceAspect_SinglePropertyValue();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.service.ImportedServiceAspect#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getValues()
	 * @see #getImportedServiceAspect()
	 * @generated
	 */
	EReference getImportedServiceAspect_Values();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.ImportedServiceAspect#getMicroservice <em>Microservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Microservice</em>'.
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getMicroservice()
	 * @see #getImportedServiceAspect()
	 * @generated
	 */
	EReference getImportedServiceAspect_Microservice();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.ImportedServiceAspect#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Interface</em>'.
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getInterface()
	 * @see #getImportedServiceAspect()
	 * @generated
	 */
	EReference getImportedServiceAspect_Interface();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.ImportedServiceAspect#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Operation</em>'.
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getOperation()
	 * @see #getImportedServiceAspect()
	 * @generated
	 */
	EReference getImportedServiceAspect_Operation();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.ImportedServiceAspect#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Referred Operation</em>'.
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getReferredOperation()
	 * @see #getImportedServiceAspect()
	 * @generated
	 */
	EReference getImportedServiceAspect_ReferredOperation();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.ImportedServiceAspect#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parameter</em>'.
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getParameter()
	 * @see #getImportedServiceAspect()
	 * @generated
	 */
	EReference getImportedServiceAspect_Parameter();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.ImportedServiceAspect#getMappedComplexType <em>Mapped Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapped Complex Type</em>'.
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getMappedComplexType()
	 * @see #getImportedServiceAspect()
	 * @generated
	 */
	EReference getImportedServiceAspect_MappedComplexType();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.ImportedServiceAspect#getMappedField <em>Mapped Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapped Field</em>'.
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getMappedField()
	 * @see #getImportedServiceAspect()
	 * @generated
	 */
	EReference getImportedServiceAspect_MappedField();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.ImportedServiceAspect#getMappedDataOperation <em>Mapped Data Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapped Data Operation</em>'.
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getMappedDataOperation()
	 * @see #getImportedServiceAspect()
	 * @generated
	 */
	EReference getImportedServiceAspect_MappedDataOperation();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.ImportedServiceAspect#getMappedDataOperationReturnType <em>Mapped Data Operation Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapped Data Operation Return Type</em>'.
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getMappedDataOperationReturnType()
	 * @see #getImportedServiceAspect()
	 * @generated
	 */
	EReference getImportedServiceAspect_MappedDataOperationReturnType();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.service.ImportedServiceAspect#getMappedDataOperationParameter <em>Mapped Data Operation Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapped Data Operation Parameter</em>'.
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getMappedDataOperationParameter()
	 * @see #getImportedServiceAspect()
	 * @generated
	 */
	EReference getImportedServiceAspect_MappedDataOperationParameter();

	/**
	 * Returns the meta object for enum '{@link de.fhdo.lemma.service.ImportType <em>Import Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Import Type</em>'.
	 * @see de.fhdo.lemma.service.ImportType
	 * @generated
	 */
	EEnum getImportType();

	/**
	 * Returns the meta object for enum '{@link de.fhdo.lemma.service.MicroserviceType <em>Microservice Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Microservice Type</em>'.
	 * @see de.fhdo.lemma.service.MicroserviceType
	 * @generated
	 */
	EEnum getMicroserviceType();

	/**
	 * Returns the meta object for enum '{@link de.fhdo.lemma.service.Visibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Visibility</em>'.
	 * @see de.fhdo.lemma.service.Visibility
	 * @generated
	 */
	EEnum getVisibility();

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>Tuple List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Tuple List</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List&lt;java.util.Map&lt;java.lang.String, java.lang.Object&gt;&gt;"
	 * @generated
	 */
	EDataType getTupleList();

	/**
	 * Returns the meta object for data type '{@link java.util.Map <em>Microservice Import Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Microservice Import Map</em>'.
	 * @see java.util.Map
	 * @model instanceClass="java.util.Map&lt;de.fhdo.lemma.service.Microservice, de.fhdo.lemma.service.Import&gt;"
	 * @generated
	 */
	EDataType getMicroserviceImportMap();

	/**
	 * Returns the meta object for data type '{@link java.util.Map <em>Default Protocols</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Default Protocols</em>'.
	 * @see java.util.Map
	 * @model instanceClass="java.util.Map&lt;de.fhdo.lemma.technology.CommunicationType, org.eclipse.xtext.xbase.lib.Pair&lt;de.fhdo.lemma.service.Import, de.fhdo.lemma.technology.Protocol&gt;&gt;"
	 * @generated
	 */
	EDataType getDefaultProtocols();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ServiceFactory getServiceFactory();

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
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.ServiceModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.ServiceModelImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getServiceModel()
		 * @generated
		 */
		EClass SERVICE_MODEL = eINSTANCE.getServiceModel();

		/**
		 * The meta object literal for the '<em><b>Tmodel Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_MODEL__TMODEL_URI = eINSTANCE.getServiceModel_T_modelUri();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_MODEL__IMPORTS = eINSTANCE.getServiceModel_Imports();

		/**
		 * The meta object literal for the '<em><b>Mapped Complex Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_MODEL__MAPPED_COMPLEX_TYPES = eINSTANCE.getServiceModel_MappedComplexTypes();

		/**
		 * The meta object literal for the '<em><b>Microservices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_MODEL__MICROSERVICES = eINSTANCE.getServiceModel_Microservices();

		/**
		 * The meta object literal for the '<em><b>Get Contained Operations</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SERVICE_MODEL___GET_CONTAINED_OPERATIONS = eINSTANCE.getServiceModel__GetContainedOperations();

		/**
		 * The meta object literal for the '<em><b>Get Contained Referred Operations</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SERVICE_MODEL___GET_CONTAINED_REFERRED_OPERATIONS = eINSTANCE.getServiceModel__GetContainedReferredOperations();

		/**
		 * The meta object literal for the '<em><b>Get Contained Interfaces</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SERVICE_MODEL___GET_CONTAINED_INTERFACES = eINSTANCE.getServiceModel__GetContainedInterfaces();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.ImportImpl <em>Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.ImportImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getImport()
		 * @generated
		 */
		EClass IMPORT = eINSTANCE.getImport();

		/**
		 * The meta object literal for the '<em><b>Trelated Import Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__TRELATED_IMPORT_ALIAS = eINSTANCE.getImport_T_relatedImportAlias();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__NAME = eINSTANCE.getImport_Name();

		/**
		 * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__IMPORT_URI = eINSTANCE.getImport_ImportURI();

		/**
		 * The meta object literal for the '<em><b>External URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__EXTERNAL_URI = eINSTANCE.getImport_ExternalURI();

		/**
		 * The meta object literal for the '<em><b>Import Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__IMPORT_TYPE = eINSTANCE.getImport_ImportType();

		/**
		 * The meta object literal for the '<em><b>Service Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT__SERVICE_MODEL = eINSTANCE.getImport_ServiceModel();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.MappedComplexTypeImpl <em>Mapped Complex Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.MappedComplexTypeImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getMappedComplexType()
		 * @generated
		 */
		EClass MAPPED_COMPLEX_TYPE = eINSTANCE.getMappedComplexType();

		/**
		 * The meta object literal for the '<em><b>Tsource Model Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPED_COMPLEX_TYPE__TSOURCE_MODEL_URI = eINSTANCE.getMappedComplexType_T_sourceModelUri();

		/**
		 * The meta object literal for the '<em><b>Ttype Definition Technology Import</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_COMPLEX_TYPE__TTYPE_DEFINITION_TECHNOLOGY_IMPORT = eINSTANCE.getMappedComplexType_T_typeDefinitionTechnologyImport();

		/**
		 * The meta object literal for the '<em><b>Ttype Definition Technology</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_COMPLEX_TYPE__TTYPE_DEFINITION_TECHNOLOGY = eINSTANCE.getMappedComplexType_T_typeDefinitionTechnology();

		/**
		 * The meta object literal for the '<em><b>Technology References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_COMPLEX_TYPE__TECHNOLOGY_REFERENCES = eINSTANCE.getMappedComplexType_TechnologyReferences();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_COMPLEX_TYPE__TYPE = eINSTANCE.getMappedComplexType_Type();

		/**
		 * The meta object literal for the '<em><b>Mapped Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_COMPLEX_TYPE__MAPPED_FIELDS = eINSTANCE.getMappedComplexType_MappedFields();

		/**
		 * The meta object literal for the '<em><b>Mapped Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_COMPLEX_TYPE__MAPPED_OPERATIONS = eINSTANCE.getMappedComplexType_MappedOperations();

		/**
		 * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_COMPLEX_TYPE__ASPECTS = eINSTANCE.getMappedComplexType_Aspects();

		/**
		 * The meta object literal for the '<em><b>Service Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_COMPLEX_TYPE__SERVICE_MODEL = eINSTANCE.getMappedComplexType_ServiceModel();

		/**
		 * The meta object literal for the '<em><b>Get Qualified Name Parts</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPED_COMPLEX_TYPE___GET_QUALIFIED_NAME_PARTS__BOOLEAN = eINSTANCE.getMappedComplexType__GetQualifiedNameParts__boolean();

		/**
		 * The meta object literal for the '<em><b>Build Qualified Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPED_COMPLEX_TYPE___BUILD_QUALIFIED_NAME__STRING_BOOLEAN = eINSTANCE.getMappedComplexType__BuildQualifiedName__String_boolean();

		/**
		 * The meta object literal for the '<em><b>Get All Type Definition Technology References</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPED_COMPLEX_TYPE___GET_ALL_TYPE_DEFINITION_TECHNOLOGY_REFERENCES = eINSTANCE.getMappedComplexType__GetAllTypeDefinitionTechnologyReferences();

		/**
		 * The meta object literal for the '<em><b>Get Type Definition Technology Import</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPED_COMPLEX_TYPE___GET_TYPE_DEFINITION_TECHNOLOGY_IMPORT = eINSTANCE.getMappedComplexType__GetTypeDefinitionTechnologyImport();

		/**
		 * The meta object literal for the '<em><b>Get Type Definition Technology</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPED_COMPLEX_TYPE___GET_TYPE_DEFINITION_TECHNOLOGY = eINSTANCE.getMappedComplexType__GetTypeDefinitionTechnology();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.MappedDataOperationImpl <em>Mapped Data Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.MappedDataOperationImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getMappedDataOperation()
		 * @generated
		 */
		EClass MAPPED_DATA_OPERATION = eINSTANCE.getMappedDataOperation();

		/**
		 * The meta object literal for the '<em><b>Data Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_DATA_OPERATION__DATA_OPERATION = eINSTANCE.getMappedDataOperation_DataOperation();

		/**
		 * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_DATA_OPERATION__ASPECTS = eINSTANCE.getMappedDataOperation_Aspects();

		/**
		 * The meta object literal for the '<em><b>Mapped Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_DATA_OPERATION__MAPPED_RETURN_TYPE = eINSTANCE.getMappedDataOperation_MappedReturnType();

		/**
		 * The meta object literal for the '<em><b>Mapped Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_DATA_OPERATION__MAPPED_PARAMETERS = eINSTANCE.getMappedDataOperation_MappedParameters();

		/**
		 * The meta object literal for the '<em><b>Mapped Complex Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_DATA_OPERATION__MAPPED_COMPLEX_TYPE = eINSTANCE.getMappedDataOperation_MappedComplexType();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.MappedDataOperationReturnTypeImpl <em>Mapped Data Operation Return Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.MappedDataOperationReturnTypeImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getMappedDataOperationReturnType()
		 * @generated
		 */
		EClass MAPPED_DATA_OPERATION_RETURN_TYPE = eINSTANCE.getMappedDataOperationReturnType();

		/**
		 * The meta object literal for the '<em><b>Mapped Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_DATA_OPERATION_RETURN_TYPE__MAPPED_TYPE = eINSTANCE.getMappedDataOperationReturnType_MappedType();

		/**
		 * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_DATA_OPERATION_RETURN_TYPE__ASPECTS = eINSTANCE.getMappedDataOperationReturnType_Aspects();

		/**
		 * The meta object literal for the '<em><b>Mapped Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_DATA_OPERATION_RETURN_TYPE__MAPPED_OPERATION = eINSTANCE.getMappedDataOperationReturnType_MappedOperation();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.MappedDataOperationParameterImpl <em>Mapped Data Operation Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.MappedDataOperationParameterImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getMappedDataOperationParameter()
		 * @generated
		 */
		EClass MAPPED_DATA_OPERATION_PARAMETER = eINSTANCE.getMappedDataOperationParameter();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_DATA_OPERATION_PARAMETER__PARAMETER = eINSTANCE.getMappedDataOperationParameter_Parameter();

		/**
		 * The meta object literal for the '<em><b>Mapped Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_DATA_OPERATION_PARAMETER__MAPPED_TYPE = eINSTANCE.getMappedDataOperationParameter_MappedType();

		/**
		 * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_DATA_OPERATION_PARAMETER__ASPECTS = eINSTANCE.getMappedDataOperationParameter_Aspects();

		/**
		 * The meta object literal for the '<em><b>Mapped Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_DATA_OPERATION_PARAMETER__MAPPED_OPERATION = eINSTANCE.getMappedDataOperationParameter_MappedOperation();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.MappedFieldImpl <em>Mapped Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.MappedFieldImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getMappedField()
		 * @generated
		 */
		EClass MAPPED_FIELD = eINSTANCE.getMappedField();

		/**
		 * The meta object literal for the '<em><b>Data Field</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_FIELD__DATA_FIELD = eINSTANCE.getMappedField_DataField();

		/**
		 * The meta object literal for the '<em><b>Enumeration Field</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_FIELD__ENUMERATION_FIELD = eINSTANCE.getMappedField_EnumerationField();

		/**
		 * The meta object literal for the '<em><b>Mapped Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_FIELD__MAPPED_TYPE = eINSTANCE.getMappedField_MappedType();

		/**
		 * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_FIELD__ASPECTS = eINSTANCE.getMappedField_Aspects();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_FIELD__PARAMETER = eINSTANCE.getMappedField_Parameter();

		/**
		 * The meta object literal for the '<em><b>Mapped Complex Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_FIELD__MAPPED_COMPLEX_TYPE = eINSTANCE.getMappedField_MappedComplexType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPED_FIELD__NAME = eINSTANCE.getMappedField_Name();

		/**
		 * The meta object literal for the '<em><b>Get Qualified Name Parts</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPED_FIELD___GET_QUALIFIED_NAME_PARTS__BOOLEAN = eINSTANCE.getMappedField__GetQualifiedNameParts__boolean();

		/**
		 * The meta object literal for the '<em><b>Build Qualified Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPED_FIELD___BUILD_QUALIFIED_NAME__STRING_BOOLEAN = eINSTANCE.getMappedField__BuildQualifiedName__String_boolean();

		/**
		 * The meta object literal for the '<em><b>Get Effective Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPED_FIELD___GET_EFFECTIVE_TYPE = eINSTANCE.getMappedField__GetEffectiveType();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.MicroserviceImpl <em>Microservice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.MicroserviceImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getMicroservice()
		 * @generated
		 */
		EClass MICROSERVICE = eINSTANCE.getMicroservice();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MICROSERVICE__NAME = eINSTANCE.getMicroservice_Name();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MICROSERVICE__VERSION = eINSTANCE.getMicroservice_Version();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MICROSERVICE__TYPE = eINSTANCE.getMicroservice_Type();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MICROSERVICE__VISIBILITY = eINSTANCE.getMicroservice_Visibility();

		/**
		 * The meta object literal for the '<em><b>Tdefault Protocols</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MICROSERVICE__TDEFAULT_PROTOCOLS = eINSTANCE.getMicroservice_T_defaultProtocols();

		/**
		 * The meta object literal for the '<em><b>Tsource Model Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MICROSERVICE__TSOURCE_MODEL_URI = eINSTANCE.getMicroservice_T_sourceModelUri();

		/**
		 * The meta object literal for the '<em><b>Technology References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MICROSERVICE__TECHNOLOGY_REFERENCES = eINSTANCE.getMicroservice_TechnologyReferences();

		/**
		 * The meta object literal for the '<em><b>Ttype Definition Technology Import</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MICROSERVICE__TTYPE_DEFINITION_TECHNOLOGY_IMPORT = eINSTANCE.getMicroservice_T_typeDefinitionTechnologyImport();

		/**
		 * The meta object literal for the '<em><b>Ttype Definition Technology</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MICROSERVICE__TTYPE_DEFINITION_TECHNOLOGY = eINSTANCE.getMicroservice_T_typeDefinitionTechnology();

		/**
		 * The meta object literal for the '<em><b>Endpoints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MICROSERVICE__ENDPOINTS = eINSTANCE.getMicroservice_Endpoints();

		/**
		 * The meta object literal for the '<em><b>Required Microservices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MICROSERVICE__REQUIRED_MICROSERVICES = eINSTANCE.getMicroservice_RequiredMicroservices();

		/**
		 * The meta object literal for the '<em><b>Required Interfaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MICROSERVICE__REQUIRED_INTERFACES = eINSTANCE.getMicroservice_RequiredInterfaces();

		/**
		 * The meta object literal for the '<em><b>Required Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MICROSERVICE__REQUIRED_OPERATIONS = eINSTANCE.getMicroservice_RequiredOperations();

		/**
		 * The meta object literal for the '<em><b>Protocols</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MICROSERVICE__PROTOCOLS = eINSTANCE.getMicroservice_Protocols();

		/**
		 * The meta object literal for the '<em><b>Interfaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MICROSERVICE__INTERFACES = eINSTANCE.getMicroservice_Interfaces();

		/**
		 * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MICROSERVICE__ASPECTS = eINSTANCE.getMicroservice_Aspects();

		/**
		 * The meta object literal for the '<em><b>Service Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MICROSERVICE__SERVICE_MODEL = eINSTANCE.getMicroservice_ServiceModel();

		/**
		 * The meta object literal for the '<em><b>Effectively Implemented</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MICROSERVICE__EFFECTIVELY_IMPLEMENTED = eINSTANCE.getMicroservice_EffectivelyImplemented();

		/**
		 * The meta object literal for the '<em><b>Effective Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MICROSERVICE__EFFECTIVE_VISIBILITY = eINSTANCE.getMicroservice_EffectiveVisibility();

		/**
		 * The meta object literal for the '<em><b>Effectively Internal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MICROSERVICE__EFFECTIVELY_INTERNAL = eINSTANCE.getMicroservice_EffectivelyInternal();

		/**
		 * The meta object literal for the '<em><b>Teffective Protocol Specifications</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MICROSERVICE___TEFFECTIVE_PROTOCOL_SPECIFICATIONS = eINSTANCE.getMicroservice__T_effectiveProtocolSpecifications();

		/**
		 * The meta object literal for the '<em><b>Get All Type Definition Technology References</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MICROSERVICE___GET_ALL_TYPE_DEFINITION_TECHNOLOGY_REFERENCES = eINSTANCE.getMicroservice__GetAllTypeDefinitionTechnologyReferences();

		/**
		 * The meta object literal for the '<em><b>Get Type Definition Technology Import</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MICROSERVICE___GET_TYPE_DEFINITION_TECHNOLOGY_IMPORT = eINSTANCE.getMicroservice__GetTypeDefinitionTechnologyImport();

		/**
		 * The meta object literal for the '<em><b>Get Type Definition Technology</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MICROSERVICE___GET_TYPE_DEFINITION_TECHNOLOGY = eINSTANCE.getMicroservice__GetTypeDefinitionTechnology();

		/**
		 * The meta object literal for the '<em><b>Get Qualified Name Parts</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MICROSERVICE___GET_QUALIFIED_NAME_PARTS = eINSTANCE.getMicroservice__GetQualifiedNameParts();

		/**
		 * The meta object literal for the '<em><b>Build Qualified Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MICROSERVICE___BUILD_QUALIFIED_NAME__STRING = eINSTANCE.getMicroservice__BuildQualifiedName__String();

		/**
		 * The meta object literal for the '<em><b>Get Contained Operations</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MICROSERVICE___GET_CONTAINED_OPERATIONS = eINSTANCE.getMicroservice__GetContainedOperations();

		/**
		 * The meta object literal for the '<em><b>Get Contained Referred Operations</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MICROSERVICE___GET_CONTAINED_REFERRED_OPERATIONS = eINSTANCE.getMicroservice__GetContainedReferredOperations();

		/**
		 * The meta object literal for the '<em><b>Get Required Imports</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MICROSERVICE___GET_REQUIRED_IMPORTS = eINSTANCE.getMicroservice__GetRequiredImports();

		/**
		 * The meta object literal for the '<em><b>Get All Required Operations</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MICROSERVICE___GET_ALL_REQUIRED_OPERATIONS__IMPORT = eINSTANCE.getMicroservice__GetAllRequiredOperations__Import();

		/**
		 * The meta object literal for the '<em><b>Get All Required Microservices</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MICROSERVICE___GET_ALL_REQUIRED_MICROSERVICES = eINSTANCE.getMicroservice__GetAllRequiredMicroservices();

		/**
		 * The meta object literal for the '<em><b>Get All Initializing Microservices</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MICROSERVICE___GET_ALL_INITIALIZING_MICROSERVICES = eINSTANCE.getMicroservice__GetAllInitializingMicroservices();

		/**
		 * The meta object literal for the '<em><b>Can Require</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MICROSERVICE___CAN_REQUIRE__MICROSERVICE_BOOLEAN = eINSTANCE.getMicroservice__CanRequire__Microservice_boolean();

		/**
		 * The meta object literal for the '<em><b>Can Require</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MICROSERVICE___CAN_REQUIRE__INTERFACE_BOOLEAN = eINSTANCE.getMicroservice__CanRequire__Interface_boolean();

		/**
		 * The meta object literal for the '<em><b>Can Require</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MICROSERVICE___CAN_REQUIRE__OPERATION_BOOLEAN = eINSTANCE.getMicroservice__CanRequire__Operation_boolean();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.TechnologyReferenceImpl <em>Technology Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.TechnologyReferenceImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getTechnologyReference()
		 * @generated
		 */
		EClass TECHNOLOGY_REFERENCE = eINSTANCE.getTechnologyReference();

		/**
		 * The meta object literal for the '<em><b>Is Type Definition Technology</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TECHNOLOGY_REFERENCE__IS_TYPE_DEFINITION_TECHNOLOGY = eINSTANCE.getTechnologyReference_IsTypeDefinitionTechnology();

		/**
		 * The meta object literal for the '<em><b>Technology</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TECHNOLOGY_REFERENCE__TECHNOLOGY = eINSTANCE.getTechnologyReference_Technology();

		/**
		 * The meta object literal for the '<em><b>Microservice</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TECHNOLOGY_REFERENCE__MICROSERVICE = eINSTANCE.getTechnologyReference_Microservice();

		/**
		 * The meta object literal for the '<em><b>Mapped Complex Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TECHNOLOGY_REFERENCE__MAPPED_COMPLEX_TYPE = eINSTANCE.getTechnologyReference_MappedComplexType();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.InterfaceImpl <em>Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.InterfaceImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getInterface()
		 * @generated
		 */
		EClass INTERFACE = eINSTANCE.getInterface();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE__NAME = eINSTANCE.getInterface_Name();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE__VERSION = eINSTANCE.getInterface_Version();

		/**
		 * The meta object literal for the '<em><b>Not Implemented</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE__NOT_IMPLEMENTED = eINSTANCE.getInterface_NotImplemented();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE__VISIBILITY = eINSTANCE.getInterface_Visibility();

		/**
		 * The meta object literal for the '<em><b>Endpoints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__ENDPOINTS = eINSTANCE.getInterface_Endpoints();

		/**
		 * The meta object literal for the '<em><b>Protocols</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__PROTOCOLS = eINSTANCE.getInterface_Protocols();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__OPERATIONS = eINSTANCE.getInterface_Operations();

		/**
		 * The meta object literal for the '<em><b>Referred Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__REFERRED_OPERATIONS = eINSTANCE.getInterface_ReferredOperations();

		/**
		 * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__ASPECTS = eINSTANCE.getInterface_Aspects();

		/**
		 * The meta object literal for the '<em><b>Microservice</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__MICROSERVICE = eINSTANCE.getInterface_Microservice();

		/**
		 * The meta object literal for the '<em><b>Effective Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE__EFFECTIVE_VISIBILITY = eINSTANCE.getInterface_EffectiveVisibility();

		/**
		 * The meta object literal for the '<em><b>Effectively Implemented</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE__EFFECTIVELY_IMPLEMENTED = eINSTANCE.getInterface_EffectivelyImplemented();

		/**
		 * The meta object literal for the '<em><b>Effectively Internal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE__EFFECTIVELY_INTERNAL = eINSTANCE.getInterface_EffectivelyInternal();

		/**
		 * The meta object literal for the '<em><b>Teffective Protocol Specifications</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INTERFACE___TEFFECTIVE_PROTOCOL_SPECIFICATIONS = eINSTANCE.getInterface__T_effectiveProtocolSpecifications();

		/**
		 * The meta object literal for the '<em><b>Get Qualified Name Parts</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INTERFACE___GET_QUALIFIED_NAME_PARTS = eINSTANCE.getInterface__GetQualifiedNameParts();

		/**
		 * The meta object literal for the '<em><b>Build Qualified Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INTERFACE___BUILD_QUALIFIED_NAME__STRING = eINSTANCE.getInterface__BuildQualifiedName__String();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.OperationImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__NAME = eINSTANCE.getOperation_Name();

		/**
		 * The meta object literal for the '<em><b>Not Implemented</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__NOT_IMPLEMENTED = eINSTANCE.getOperation_NotImplemented();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__VISIBILITY = eINSTANCE.getOperation_Visibility();

		/**
		 * The meta object literal for the '<em><b>Api Operation Comment</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__API_OPERATION_COMMENT = eINSTANCE.getOperation_ApiOperationComment();

		/**
		 * The meta object literal for the '<em><b>Endpoints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__ENDPOINTS = eINSTANCE.getOperation_Endpoints();

		/**
		 * The meta object literal for the '<em><b>Protocols</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__PROTOCOLS = eINSTANCE.getOperation_Protocols();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__PARAMETERS = eINSTANCE.getOperation_Parameters();

		/**
		 * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__ASPECTS = eINSTANCE.getOperation_Aspects();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__INTERFACE = eINSTANCE.getOperation_Interface();

		/**
		 * The meta object literal for the '<em><b>Not Implemented By Container</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__NOT_IMPLEMENTED_BY_CONTAINER = eINSTANCE.getOperation_NotImplementedByContainer();

		/**
		 * The meta object literal for the '<em><b>Effectively Not Implemented</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__EFFECTIVELY_NOT_IMPLEMENTED = eINSTANCE.getOperation_EffectivelyNotImplemented();

		/**
		 * The meta object literal for the '<em><b>Effective Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__EFFECTIVE_VISIBILITY = eINSTANCE.getOperation_EffectiveVisibility();

		/**
		 * The meta object literal for the '<em><b>Effectively Internal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__EFFECTIVELY_INTERNAL = eINSTANCE.getOperation_EffectivelyInternal();

		/**
		 * The meta object literal for the '<em><b>Teffective Protocol Specifications</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATION___TEFFECTIVE_PROTOCOL_SPECIFICATIONS = eINSTANCE.getOperation__T_effectiveProtocolSpecifications();

		/**
		 * The meta object literal for the '<em><b>Get Qualified Name Parts</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATION___GET_QUALIFIED_NAME_PARTS = eINSTANCE.getOperation__GetQualifiedNameParts();

		/**
		 * The meta object literal for the '<em><b>Build Qualified Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATION___BUILD_QUALIFIED_NAME__STRING = eINSTANCE.getOperation__BuildQualifiedName__String();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.ApiOperationCommentImpl <em>Api Operation Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.ApiOperationCommentImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getApiOperationComment()
		 * @generated
		 */
		EClass API_OPERATION_COMMENT = eINSTANCE.getApiOperationComment();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute API_OPERATION_COMMENT__COMMENT = eINSTANCE.getApiOperationComment_Comment();

		/**
		 * The meta object literal for the '<em><b>Parameter Comments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference API_OPERATION_COMMENT__PARAMETER_COMMENTS = eINSTANCE.getApiOperationComment_ParameterComments();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference API_OPERATION_COMMENT__OPERATION = eINSTANCE.getApiOperationComment_Operation();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.ApiParameterCommentImpl <em>Api Parameter Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.ApiParameterCommentImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getApiParameterComment()
		 * @generated
		 */
		EClass API_PARAMETER_COMMENT = eINSTANCE.getApiParameterComment();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute API_PARAMETER_COMMENT__COMMENT = eINSTANCE.getApiParameterComment_Comment();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute API_PARAMETER_COMMENT__REQUIRED = eINSTANCE.getApiParameterComment_Required();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference API_PARAMETER_COMMENT__PARAMETER = eINSTANCE.getApiParameterComment_Parameter();

		/**
		 * The meta object literal for the '<em><b>Operation Comment</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference API_PARAMETER_COMMENT__OPERATION_COMMENT = eINSTANCE.getApiParameterComment_OperationComment();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.ReferredOperationImpl <em>Referred Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.ReferredOperationImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getReferredOperation()
		 * @generated
		 */
		EClass REFERRED_OPERATION = eINSTANCE.getReferredOperation();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERRED_OPERATION__OPERATION = eINSTANCE.getReferredOperation_Operation();

		/**
		 * The meta object literal for the '<em><b>Endpoints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERRED_OPERATION__ENDPOINTS = eINSTANCE.getReferredOperation_Endpoints();

		/**
		 * The meta object literal for the '<em><b>Protocols</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERRED_OPERATION__PROTOCOLS = eINSTANCE.getReferredOperation_Protocols();

		/**
		 * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERRED_OPERATION__ASPECTS = eINSTANCE.getReferredOperation_Aspects();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERRED_OPERATION__INTERFACE = eINSTANCE.getReferredOperation_Interface();

		/**
		 * The meta object literal for the '<em><b>Teffective Protocol Specifications</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REFERRED_OPERATION___TEFFECTIVE_PROTOCOL_SPECIFICATIONS = eINSTANCE.getReferredOperation__T_effectiveProtocolSpecifications();

		/**
		 * The meta object literal for the '<em><b>Get Qualified Name Parts</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REFERRED_OPERATION___GET_QUALIFIED_NAME_PARTS = eINSTANCE.getReferredOperation__GetQualifiedNameParts();

		/**
		 * The meta object literal for the '<em><b>Build Qualified Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REFERRED_OPERATION___BUILD_QUALIFIED_NAME__STRING = eINSTANCE.getReferredOperation__BuildQualifiedName__String();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.ParameterImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Exchange Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__EXCHANGE_PATTERN = eINSTANCE.getParameter_ExchangePattern();

		/**
		 * The meta object literal for the '<em><b>Communication Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__COMMUNICATION_TYPE = eINSTANCE.getParameter_CommunicationType();

		/**
		 * The meta object literal for the '<em><b>Communicates Fault</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__COMMUNICATES_FAULT = eINSTANCE.getParameter_CommunicatesFault();

		/**
		 * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__OPTIONAL = eINSTANCE.getParameter_Optional();

		/**
		 * The meta object literal for the '<em><b>Initialized By Operation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__INITIALIZED_BY_OPERATION = eINSTANCE.getParameter_InitializedByOperation();

		/**
		 * The meta object literal for the '<em><b>Imported Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__IMPORTED_TYPE = eINSTANCE.getParameter_ImportedType();

		/**
		 * The meta object literal for the '<em><b>Primitive Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__PRIMITIVE_TYPE = eINSTANCE.getParameter_PrimitiveType();

		/**
		 * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__ASPECTS = eINSTANCE.getParameter_Aspects();

		/**
		 * The meta object literal for the '<em><b>Mapped Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__MAPPED_FIELDS = eINSTANCE.getParameter_MappedFields();

		/**
		 * The meta object literal for the '<em><b>Original Imported Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__ORIGINAL_IMPORTED_TYPE = eINSTANCE.getParameter_OriginalImportedType();

		/**
		 * The meta object literal for the '<em><b>Original Primitive Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__ORIGINAL_PRIMITIVE_TYPE = eINSTANCE.getParameter_OriginalPrimitiveType();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__OPERATION = eINSTANCE.getParameter_Operation();

		/**
		 * The meta object literal for the '<em><b>Get Qualified Name Parts</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETER___GET_QUALIFIED_NAME_PARTS = eINSTANCE.getParameter__GetQualifiedNameParts();

		/**
		 * The meta object literal for the '<em><b>Build Qualified Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETER___BUILD_QUALIFIED_NAME__STRING = eINSTANCE.getParameter__BuildQualifiedName__String();

		/**
		 * The meta object literal for the '<em><b>Basically Initializable By</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETER___BASICALLY_INITIALIZABLE_BY__OPERATION = eINSTANCE.getParameter__BasicallyInitializableBy__Operation();

		/**
		 * The meta object literal for the '<em><b>Get Effective Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETER___GET_EFFECTIVE_TYPE = eINSTANCE.getParameter__GetEffectiveType();

		/**
		 * The meta object literal for the '<em><b>Is Technology Specific Effective Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETER___IS_TECHNOLOGY_SPECIFIC_EFFECTIVE_TYPE = eINSTANCE.getParameter__IsTechnologySpecificEffectiveType();

		/**
		 * The meta object literal for the '<em><b>Get Effective Type Qualified Name Parts</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETER___GET_EFFECTIVE_TYPE_QUALIFIED_NAME_PARTS = eINSTANCE.getParameter__GetEffectiveTypeQualifiedNameParts();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.PossiblyImportedMicroserviceImpl <em>Possibly Imported Microservice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.PossiblyImportedMicroserviceImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getPossiblyImportedMicroservice()
		 * @generated
		 */
		EClass POSSIBLY_IMPORTED_MICROSERVICE = eINSTANCE.getPossiblyImportedMicroservice();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POSSIBLY_IMPORTED_MICROSERVICE__IMPORT = eINSTANCE.getPossiblyImportedMicroservice_Import();

		/**
		 * The meta object literal for the '<em><b>Microservice</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POSSIBLY_IMPORTED_MICROSERVICE__MICROSERVICE = eINSTANCE.getPossiblyImportedMicroservice_Microservice();

		/**
		 * The meta object literal for the '<em><b>Requiring Microservice</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POSSIBLY_IMPORTED_MICROSERVICE__REQUIRING_MICROSERVICE = eINSTANCE.getPossiblyImportedMicroservice_RequiringMicroservice();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.PossiblyImportedInterfaceImpl <em>Possibly Imported Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.PossiblyImportedInterfaceImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getPossiblyImportedInterface()
		 * @generated
		 */
		EClass POSSIBLY_IMPORTED_INTERFACE = eINSTANCE.getPossiblyImportedInterface();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POSSIBLY_IMPORTED_INTERFACE__IMPORT = eINSTANCE.getPossiblyImportedInterface_Import();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POSSIBLY_IMPORTED_INTERFACE__INTERFACE = eINSTANCE.getPossiblyImportedInterface_Interface();

		/**
		 * The meta object literal for the '<em><b>Requiring Microservice</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POSSIBLY_IMPORTED_INTERFACE__REQUIRING_MICROSERVICE = eINSTANCE.getPossiblyImportedInterface_RequiringMicroservice();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSSIBLY_IMPORTED_INTERFACE__REQUIRED = eINSTANCE.getPossiblyImportedInterface_Required();

		/**
		 * The meta object literal for the '<em><b>Required By Container</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSSIBLY_IMPORTED_INTERFACE__REQUIRED_BY_CONTAINER = eINSTANCE.getPossiblyImportedInterface_RequiredByContainer();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.PossiblyImportedOperationImpl <em>Possibly Imported Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.PossiblyImportedOperationImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getPossiblyImportedOperation()
		 * @generated
		 */
		EClass POSSIBLY_IMPORTED_OPERATION = eINSTANCE.getPossiblyImportedOperation();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POSSIBLY_IMPORTED_OPERATION__IMPORT = eINSTANCE.getPossiblyImportedOperation_Import();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POSSIBLY_IMPORTED_OPERATION__OPERATION = eINSTANCE.getPossiblyImportedOperation_Operation();

		/**
		 * The meta object literal for the '<em><b>Requiring Microservice</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POSSIBLY_IMPORTED_OPERATION__REQUIRING_MICROSERVICE = eINSTANCE.getPossiblyImportedOperation_RequiringMicroservice();

		/**
		 * The meta object literal for the '<em><b>Initialized Parameter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POSSIBLY_IMPORTED_OPERATION__INITIALIZED_PARAMETER = eINSTANCE.getPossiblyImportedOperation_InitializedParameter();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSSIBLY_IMPORTED_OPERATION__REQUIRED = eINSTANCE.getPossiblyImportedOperation_Required();

		/**
		 * The meta object literal for the '<em><b>Required By Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSSIBLY_IMPORTED_OPERATION__REQUIRED_BY_INTERFACE = eINSTANCE.getPossiblyImportedOperation_RequiredByInterface();

		/**
		 * The meta object literal for the '<em><b>Required By Microservice</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSSIBLY_IMPORTED_OPERATION__REQUIRED_BY_MICROSERVICE = eINSTANCE.getPossiblyImportedOperation_RequiredByMicroservice();

		/**
		 * The meta object literal for the '<em><b>Required By Container</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSSIBLY_IMPORTED_OPERATION__REQUIRED_BY_CONTAINER = eINSTANCE.getPossiblyImportedOperation_RequiredByContainer();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.ImportedTypeImpl <em>Imported Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.ImportedTypeImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getImportedType()
		 * @generated
		 */
		EClass IMPORTED_TYPE = eINSTANCE.getImportedType();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_TYPE__IMPORT = eINSTANCE.getImportedType_Import();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_TYPE__TYPE = eINSTANCE.getImportedType_Type();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.ImportedProtocolAndDataFormatImpl <em>Imported Protocol And Data Format</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.ImportedProtocolAndDataFormatImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getImportedProtocolAndDataFormat()
		 * @generated
		 */
		EClass IMPORTED_PROTOCOL_AND_DATA_FORMAT = eINSTANCE.getImportedProtocolAndDataFormat();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_PROTOCOL_AND_DATA_FORMAT__IMPORT = eINSTANCE.getImportedProtocolAndDataFormat_Import();

		/**
		 * The meta object literal for the '<em><b>Imported Protocol</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_PROTOCOL_AND_DATA_FORMAT__IMPORTED_PROTOCOL = eINSTANCE.getImportedProtocolAndDataFormat_ImportedProtocol();

		/**
		 * The meta object literal for the '<em><b>Data Format</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_PROTOCOL_AND_DATA_FORMAT__DATA_FORMAT = eINSTANCE.getImportedProtocolAndDataFormat_DataFormat();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_PROTOCOL_AND_DATA_FORMAT__SPECIFICATION = eINSTANCE.getImportedProtocolAndDataFormat_Specification();

		/**
		 * The meta object literal for the '<em><b>Endpoint</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_PROTOCOL_AND_DATA_FORMAT__ENDPOINT = eINSTANCE.getImportedProtocolAndDataFormat_Endpoint();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.ProtocolSpecificationImpl <em>Protocol Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.ProtocolSpecificationImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getProtocolSpecification()
		 * @generated
		 */
		EClass PROTOCOL_SPECIFICATION = eINSTANCE.getProtocolSpecification();

		/**
		 * The meta object literal for the '<em><b>Communication Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE = eINSTANCE.getProtocolSpecification_CommunicationType();

		/**
		 * The meta object literal for the '<em><b>Protocol</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTOCOL_SPECIFICATION__PROTOCOL = eINSTANCE.getProtocolSpecification_Protocol();

		/**
		 * The meta object literal for the '<em><b>Effective Protocol Specifications</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROTOCOL_SPECIFICATION___EFFECTIVE_PROTOCOL_SPECIFICATIONS__ELIST = eINSTANCE.getProtocolSpecification__EffectiveProtocolSpecifications__EList();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.EndpointImpl <em>Endpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.EndpointImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getEndpoint()
		 * @generated
		 */
		EClass ENDPOINT = eINSTANCE.getEndpoint();

		/**
		 * The meta object literal for the '<em><b>Addresses</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENDPOINT__ADDRESSES = eINSTANCE.getEndpoint_Addresses();

		/**
		 * The meta object literal for the '<em><b>Protocols</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENDPOINT__PROTOCOLS = eINSTANCE.getEndpoint_Protocols();

		/**
		 * The meta object literal for the '<em><b>Microservice</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENDPOINT__MICROSERVICE = eINSTANCE.getEndpoint_Microservice();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENDPOINT__INTERFACE = eINSTANCE.getEndpoint_Interface();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENDPOINT__OPERATION = eINSTANCE.getEndpoint_Operation();

		/**
		 * The meta object literal for the '<em><b>Referred Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENDPOINT__REFERRED_OPERATION = eINSTANCE.getEndpoint_ReferredOperation();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.impl.ImportedServiceAspectImpl <em>Imported Service Aspect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.impl.ImportedServiceAspectImpl
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getImportedServiceAspect()
		 * @generated
		 */
		EClass IMPORTED_SERVICE_ASPECT = eINSTANCE.getImportedServiceAspect();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_SERVICE_ASPECT__IMPORT = eINSTANCE.getImportedServiceAspect_Import();

		/**
		 * The meta object literal for the '<em><b>Imported Aspect</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_SERVICE_ASPECT__IMPORTED_ASPECT = eINSTANCE.getImportedServiceAspect_ImportedAspect();

		/**
		 * The meta object literal for the '<em><b>Single Property Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE = eINSTANCE.getImportedServiceAspect_SinglePropertyValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_SERVICE_ASPECT__VALUES = eINSTANCE.getImportedServiceAspect_Values();

		/**
		 * The meta object literal for the '<em><b>Microservice</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_SERVICE_ASPECT__MICROSERVICE = eINSTANCE.getImportedServiceAspect_Microservice();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_SERVICE_ASPECT__INTERFACE = eINSTANCE.getImportedServiceAspect_Interface();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_SERVICE_ASPECT__OPERATION = eINSTANCE.getImportedServiceAspect_Operation();

		/**
		 * The meta object literal for the '<em><b>Referred Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION = eINSTANCE.getImportedServiceAspect_ReferredOperation();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_SERVICE_ASPECT__PARAMETER = eINSTANCE.getImportedServiceAspect_Parameter();

		/**
		 * The meta object literal for the '<em><b>Mapped Complex Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_SERVICE_ASPECT__MAPPED_COMPLEX_TYPE = eINSTANCE.getImportedServiceAspect_MappedComplexType();

		/**
		 * The meta object literal for the '<em><b>Mapped Field</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_SERVICE_ASPECT__MAPPED_FIELD = eINSTANCE.getImportedServiceAspect_MappedField();

		/**
		 * The meta object literal for the '<em><b>Mapped Data Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION = eINSTANCE.getImportedServiceAspect_MappedDataOperation();

		/**
		 * The meta object literal for the '<em><b>Mapped Data Operation Return Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_RETURN_TYPE = eINSTANCE.getImportedServiceAspect_MappedDataOperationReturnType();

		/**
		 * The meta object literal for the '<em><b>Mapped Data Operation Parameter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_PARAMETER = eINSTANCE.getImportedServiceAspect_MappedDataOperationParameter();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.ImportType <em>Import Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.ImportType
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getImportType()
		 * @generated
		 */
		EEnum IMPORT_TYPE = eINSTANCE.getImportType();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.MicroserviceType <em>Microservice Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.MicroserviceType
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getMicroserviceType()
		 * @generated
		 */
		EEnum MICROSERVICE_TYPE = eINSTANCE.getMicroserviceType();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.service.Visibility <em>Visibility</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.service.Visibility
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getVisibility()
		 * @generated
		 */
		EEnum VISIBILITY = eINSTANCE.getVisibility();

		/**
		 * The meta object literal for the '<em>Tuple List</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getTupleList()
		 * @generated
		 */
		EDataType TUPLE_LIST = eINSTANCE.getTupleList();

		/**
		 * The meta object literal for the '<em>Microservice Import Map</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Map
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getMicroserviceImportMap()
		 * @generated
		 */
		EDataType MICROSERVICE_IMPORT_MAP = eINSTANCE.getMicroserviceImportMap();

		/**
		 * The meta object literal for the '<em>Default Protocols</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Map
		 * @see de.fhdo.lemma.service.impl.ServicePackageImpl#getDefaultProtocols()
		 * @generated
		 */
		EDataType DEFAULT_PROTOCOLS = eINSTANCE.getDefaultProtocols();

	}

} //ServicePackage
