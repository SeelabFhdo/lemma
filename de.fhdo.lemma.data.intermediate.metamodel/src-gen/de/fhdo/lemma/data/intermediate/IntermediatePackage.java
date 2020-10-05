/**
 */
package de.fhdo.lemma.data.intermediate;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see de.fhdo.lemma.data.intermediate.IntermediateFactory
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
	String eNS_URI = "http://www.fhdo.de/lemma/data/intermediate";

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
	IntermediatePackage eINSTANCE = de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataModelImpl <em>Data Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateDataModelImpl
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateDataModel()
	 * @generated
	 */
	int INTERMEDIATE_DATA_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Source Model Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_MODEL__SOURCE_MODEL_URI = 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_MODEL__IMPORTS = 1;

	/**
	 * The feature id for the '<em><b>Versions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_MODEL__VERSIONS = 2;

	/**
	 * The feature id for the '<em><b>Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_MODEL__CONTEXTS = 3;

	/**
	 * The feature id for the '<em><b>Complex Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_MODEL__COMPLEX_TYPES = 4;

	/**
	 * The number of structural features of the '<em>Data Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_MODEL_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Data Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateImportImpl
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateImport()
	 * @generated
	 */
	int INTERMEDIATE_IMPORT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Import Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORT__IMPORT_URI = 1;

	/**
	 * The feature id for the '<em><b>Import Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORT__IMPORT_TYPE_NAME = 2;

	/**
	 * The feature id for the '<em><b>Data Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORT__DATA_MODEL = 3;

	/**
	 * The feature id for the '<em><b>Import Type Name For Datatypes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORT__IMPORT_TYPE_NAME_FOR_DATATYPES = 4;

	/**
	 * The number of structural features of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateVersionImpl <em>Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateVersionImpl
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateVersion()
	 * @generated
	 */
	int INTERMEDIATE_VERSION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_VERSION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Complex Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_VERSION__COMPLEX_TYPES = 1;

	/**
	 * The feature id for the '<em><b>Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_VERSION__CONTEXTS = 2;

	/**
	 * The feature id for the '<em><b>Data Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_VERSION__DATA_MODEL = 3;

	/**
	 * The number of structural features of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_VERSION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_VERSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateContextImpl
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateContext()
	 * @generated
	 */
	int INTERMEDIATE_CONTEXT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTEXT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTEXT__QUALIFIED_NAME = 1;

	/**
	 * The feature id for the '<em><b>Complex Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTEXT__COMPLEX_TYPES = 2;

	/**
	 * The feature id for the '<em><b>Data Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTEXT__DATA_MODEL = 3;

	/**
	 * The feature id for the '<em><b>Version</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTEXT__VERSION = 4;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTEXT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CONTEXT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateTypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateTypeImpl
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateType()
	 * @generated
	 */
	int INTERMEDIATE_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TYPE__ORIGIN = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TYPE__KIND = 2;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TYPE__RETURN_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TYPE__PARAMETER = 4;

	/**
	 * The feature id for the '<em><b>Data Field</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TYPE__DATA_FIELD = 5;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TYPE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediatePrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePrimitiveTypeImpl
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediatePrimitiveType()
	 * @generated
	 */
	int INTERMEDIATE_PRIMITIVE_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_PRIMITIVE_TYPE__NAME = INTERMEDIATE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_PRIMITIVE_TYPE__ORIGIN = INTERMEDIATE_TYPE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_PRIMITIVE_TYPE__KIND = INTERMEDIATE_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_PRIMITIVE_TYPE__RETURN_TYPE = INTERMEDIATE_TYPE__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_PRIMITIVE_TYPE__PARAMETER = INTERMEDIATE_TYPE__PARAMETER;

	/**
	 * The feature id for the '<em><b>Data Field</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_PRIMITIVE_TYPE__DATA_FIELD = INTERMEDIATE_TYPE__DATA_FIELD;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_PRIMITIVE_TYPE__SIZE = INTERMEDIATE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initialized Data Field</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_DATA_FIELD = INTERMEDIATE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initialized Enumeration Field</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_ENUMERATION_FIELD = INTERMEDIATE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_PRIMITIVE_TYPE_FEATURE_COUNT = INTERMEDIATE_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_PRIMITIVE_TYPE_OPERATION_COUNT = INTERMEDIATE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateComplexTypeImpl <em>Complex Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateComplexTypeImpl
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateComplexType()
	 * @generated
	 */
	int INTERMEDIATE_COMPLEX_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_COMPLEX_TYPE__NAME = INTERMEDIATE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_COMPLEX_TYPE__ORIGIN = INTERMEDIATE_TYPE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_COMPLEX_TYPE__KIND = INTERMEDIATE_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_COMPLEX_TYPE__RETURN_TYPE = INTERMEDIATE_TYPE__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_COMPLEX_TYPE__PARAMETER = INTERMEDIATE_TYPE__PARAMETER;

	/**
	 * The feature id for the '<em><b>Data Field</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_COMPLEX_TYPE__DATA_FIELD = INTERMEDIATE_TYPE__DATA_FIELD;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_COMPLEX_TYPE__QUALIFIED_NAME = INTERMEDIATE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_COMPLEX_TYPE__ASPECTS = INTERMEDIATE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Data Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL = INTERMEDIATE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Version</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_COMPLEX_TYPE__VERSION = INTERMEDIATE_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_COMPLEX_TYPE__CONTEXT = INTERMEDIATE_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Complex Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_COMPLEX_TYPE_FEATURE_COUNT = INTERMEDIATE_TYPE_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Complex Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_COMPLEX_TYPE_OPERATION_COUNT = INTERMEDIATE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportedComplexTypeImpl <em>Imported Complex Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateImportedComplexTypeImpl
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateImportedComplexType()
	 * @generated
	 */
	int INTERMEDIATE_IMPORTED_COMPLEX_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_COMPLEX_TYPE__NAME = INTERMEDIATE_COMPLEX_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_COMPLEX_TYPE__ORIGIN = INTERMEDIATE_COMPLEX_TYPE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_COMPLEX_TYPE__KIND = INTERMEDIATE_COMPLEX_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_COMPLEX_TYPE__RETURN_TYPE = INTERMEDIATE_COMPLEX_TYPE__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_COMPLEX_TYPE__PARAMETER = INTERMEDIATE_COMPLEX_TYPE__PARAMETER;

	/**
	 * The feature id for the '<em><b>Data Field</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_COMPLEX_TYPE__DATA_FIELD = INTERMEDIATE_COMPLEX_TYPE__DATA_FIELD;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_COMPLEX_TYPE__QUALIFIED_NAME = INTERMEDIATE_COMPLEX_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_COMPLEX_TYPE__ASPECTS = INTERMEDIATE_COMPLEX_TYPE__ASPECTS;

	/**
	 * The feature id for the '<em><b>Data Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_COMPLEX_TYPE__DATA_MODEL = INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL;

	/**
	 * The feature id for the '<em><b>Version</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_COMPLEX_TYPE__VERSION = INTERMEDIATE_COMPLEX_TYPE__VERSION;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_COMPLEX_TYPE__CONTEXT = INTERMEDIATE_COMPLEX_TYPE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_COMPLEX_TYPE__IMPORT = INTERMEDIATE_COMPLEX_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Imported Complex Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_COMPLEX_TYPE_FEATURE_COUNT = INTERMEDIATE_COMPLEX_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Imported Complex Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_COMPLEX_TYPE_OPERATION_COUNT = INTERMEDIATE_COMPLEX_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportedTechnologySpecificTypeImpl <em>Imported Technology Specific Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateImportedTechnologySpecificTypeImpl
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateImportedTechnologySpecificType()
	 * @generated
	 */
	int INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__NAME = INTERMEDIATE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__ORIGIN = INTERMEDIATE_TYPE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__KIND = INTERMEDIATE_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__RETURN_TYPE = INTERMEDIATE_TYPE__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__PARAMETER = INTERMEDIATE_TYPE__PARAMETER;

	/**
	 * The feature id for the '<em><b>Data Field</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__DATA_FIELD = INTERMEDIATE_TYPE__DATA_FIELD;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__QUALIFIED_NAME = INTERMEDIATE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__IMPORT = INTERMEDIATE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Imported Technology Specific Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE_FEATURE_COUNT = INTERMEDIATE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Imported Technology Specific Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE_OPERATION_COUNT = INTERMEDIATE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataStructureImpl <em>Data Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateDataStructureImpl
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateDataStructure()
	 * @generated
	 */
	int INTERMEDIATE_DATA_STRUCTURE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_STRUCTURE__NAME = INTERMEDIATE_COMPLEX_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_STRUCTURE__ORIGIN = INTERMEDIATE_COMPLEX_TYPE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_STRUCTURE__KIND = INTERMEDIATE_COMPLEX_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_STRUCTURE__RETURN_TYPE = INTERMEDIATE_COMPLEX_TYPE__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_STRUCTURE__PARAMETER = INTERMEDIATE_COMPLEX_TYPE__PARAMETER;

	/**
	 * The feature id for the '<em><b>Data Field</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_STRUCTURE__DATA_FIELD = INTERMEDIATE_COMPLEX_TYPE__DATA_FIELD;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_STRUCTURE__QUALIFIED_NAME = INTERMEDIATE_COMPLEX_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_STRUCTURE__ASPECTS = INTERMEDIATE_COMPLEX_TYPE__ASPECTS;

	/**
	 * The feature id for the '<em><b>Data Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_STRUCTURE__DATA_MODEL = INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL;

	/**
	 * The feature id for the '<em><b>Version</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_STRUCTURE__VERSION = INTERMEDIATE_COMPLEX_TYPE__VERSION;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_STRUCTURE__CONTEXT = INTERMEDIATE_COMPLEX_TYPE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Feature Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_STRUCTURE__FEATURE_NAMES = INTERMEDIATE_COMPLEX_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Super</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_STRUCTURE__SUPER = INTERMEDIATE_COMPLEX_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_STRUCTURE__OPERATIONS = INTERMEDIATE_COMPLEX_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Data Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_STRUCTURE__DATA_FIELDS = INTERMEDIATE_COMPLEX_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Data Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_STRUCTURE_FEATURE_COUNT = INTERMEDIATE_COMPLEX_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Data Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_STRUCTURE_OPERATION_COUNT = INTERMEDIATE_COMPLEX_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationImpl <em>Data Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationImpl
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateDataOperation()
	 * @generated
	 */
	int INTERMEDIATE_DATA_OPERATION = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION__QUALIFIED_NAME = 1;

	/**
	 * The feature id for the '<em><b>Hidden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION__HIDDEN = 2;

	/**
	 * The feature id for the '<em><b>Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION__INHERITED = 3;

	/**
	 * The feature id for the '<em><b>Feature Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION__FEATURE_NAMES = 4;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION__RETURN_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION__PARAMETERS = 6;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION__ASPECTS = 7;

	/**
	 * The feature id for the '<em><b>Data Structure</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION__DATA_STRUCTURE = 8;

	/**
	 * The number of structural features of the '<em>Data Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION_FEATURE_COUNT = 9;

	/**
	 * The number of operations of the '<em>Data Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationReturnTypeImpl <em>Data Operation Return Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationReturnTypeImpl
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateDataOperationReturnType()
	 * @generated
	 */
	int INTERMEDIATE_DATA_OPERATION_RETURN_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION_RETURN_TYPE__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Original Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION_RETURN_TYPE__ORIGINAL_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION_RETURN_TYPE__ASPECTS = 2;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION_RETURN_TYPE__OPERATION = 3;

	/**
	 * The number of structural features of the '<em>Data Operation Return Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION_RETURN_TYPE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Data Operation Return Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION_RETURN_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationParameterImpl <em>Data Operation Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationParameterImpl
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateDataOperationParameter()
	 * @generated
	 */
	int INTERMEDIATE_DATA_OPERATION_PARAMETER = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION_PARAMETER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION_PARAMETER__QUALIFIED_NAME = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION_PARAMETER__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Original Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION_PARAMETER__ORIGINAL_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION_PARAMETER__ASPECTS = 4;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION_PARAMETER__OPERATION = 5;

	/**
	 * The number of structural features of the '<em>Data Operation Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION_PARAMETER_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Data Operation Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_OPERATION_PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateListTypeImpl <em>List Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateListTypeImpl
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateListType()
	 * @generated
	 */
	int INTERMEDIATE_LIST_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_LIST_TYPE__NAME = INTERMEDIATE_COMPLEX_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_LIST_TYPE__ORIGIN = INTERMEDIATE_COMPLEX_TYPE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_LIST_TYPE__KIND = INTERMEDIATE_COMPLEX_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_LIST_TYPE__RETURN_TYPE = INTERMEDIATE_COMPLEX_TYPE__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_LIST_TYPE__PARAMETER = INTERMEDIATE_COMPLEX_TYPE__PARAMETER;

	/**
	 * The feature id for the '<em><b>Data Field</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_LIST_TYPE__DATA_FIELD = INTERMEDIATE_COMPLEX_TYPE__DATA_FIELD;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_LIST_TYPE__QUALIFIED_NAME = INTERMEDIATE_COMPLEX_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_LIST_TYPE__ASPECTS = INTERMEDIATE_COMPLEX_TYPE__ASPECTS;

	/**
	 * The feature id for the '<em><b>Data Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_LIST_TYPE__DATA_MODEL = INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL;

	/**
	 * The feature id for the '<em><b>Version</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_LIST_TYPE__VERSION = INTERMEDIATE_COMPLEX_TYPE__VERSION;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_LIST_TYPE__CONTEXT = INTERMEDIATE_COMPLEX_TYPE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Primitive List</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_LIST_TYPE__PRIMITIVE_LIST = INTERMEDIATE_COMPLEX_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Structured List</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_LIST_TYPE__STRUCTURED_LIST = INTERMEDIATE_COMPLEX_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_LIST_TYPE__PRIMITIVE_TYPE = INTERMEDIATE_COMPLEX_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Data Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_LIST_TYPE__DATA_FIELDS = INTERMEDIATE_COMPLEX_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>List Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_LIST_TYPE_FEATURE_COUNT = INTERMEDIATE_COMPLEX_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>List Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_LIST_TYPE_OPERATION_COUNT = INTERMEDIATE_COMPLEX_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataFieldImpl <em>Data Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateDataFieldImpl
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateDataField()
	 * @generated
	 */
	int INTERMEDIATE_DATA_FIELD = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_FIELD__NAME = 0;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_FIELD__QUALIFIED_NAME = 1;

	/**
	 * The feature id for the '<em><b>Hidden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_FIELD__HIDDEN = 2;

	/**
	 * The feature id for the '<em><b>Immutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_FIELD__IMMUTABLE = 3;

	/**
	 * The feature id for the '<em><b>Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_FIELD__INHERITED = 4;

	/**
	 * The feature id for the '<em><b>Feature Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_FIELD__FEATURE_NAMES = 5;

	/**
	 * The feature id for the '<em><b>Initialization Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_FIELD__INITIALIZATION_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Initialization Value Compatible Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES = 7;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_FIELD__TYPE = 8;

	/**
	 * The feature id for the '<em><b>Original Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_FIELD__ORIGINAL_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_FIELD__ASPECTS = 10;

	/**
	 * The feature id for the '<em><b>Data Structure</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_FIELD__DATA_STRUCTURE = 11;

	/**
	 * The feature id for the '<em><b>List Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_FIELD__LIST_TYPE = 12;

	/**
	 * The number of structural features of the '<em>Data Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_FIELD_FEATURE_COUNT = 13;

	/**
	 * The operation id for the '<em>Get Effective Complex Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_FIELD___GET_EFFECTIVE_COMPLEX_TYPE = 0;

	/**
	 * The number of operations of the '<em>Data Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_DATA_FIELD_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateEnumerationImpl <em>Enumeration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateEnumerationImpl
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateEnumeration()
	 * @generated
	 */
	int INTERMEDIATE_ENUMERATION = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION__NAME = INTERMEDIATE_COMPLEX_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION__ORIGIN = INTERMEDIATE_COMPLEX_TYPE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION__KIND = INTERMEDIATE_COMPLEX_TYPE__KIND;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION__RETURN_TYPE = INTERMEDIATE_COMPLEX_TYPE__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION__PARAMETER = INTERMEDIATE_COMPLEX_TYPE__PARAMETER;

	/**
	 * The feature id for the '<em><b>Data Field</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION__DATA_FIELD = INTERMEDIATE_COMPLEX_TYPE__DATA_FIELD;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION__QUALIFIED_NAME = INTERMEDIATE_COMPLEX_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Aspects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION__ASPECTS = INTERMEDIATE_COMPLEX_TYPE__ASPECTS;

	/**
	 * The feature id for the '<em><b>Data Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION__DATA_MODEL = INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL;

	/**
	 * The feature id for the '<em><b>Version</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION__VERSION = INTERMEDIATE_COMPLEX_TYPE__VERSION;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION__CONTEXT = INTERMEDIATE_COMPLEX_TYPE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Feature Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION__FEATURE_NAMES = INTERMEDIATE_COMPLEX_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION__FIELDS = INTERMEDIATE_COMPLEX_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Enumeration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION_FEATURE_COUNT = INTERMEDIATE_COMPLEX_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Enumeration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION_OPERATION_COUNT = INTERMEDIATE_COMPLEX_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateEnumerationFieldImpl <em>Enumeration Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateEnumerationFieldImpl
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateEnumerationField()
	 * @generated
	 */
	int INTERMEDIATE_ENUMERATION_FIELD = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION_FIELD__NAME = 0;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION_FIELD__QUALIFIED_NAME = 1;

	/**
	 * The feature id for the '<em><b>Initialization Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION_FIELD__INITIALIZATION_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Initialization Value Compatible Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES = 3;

	/**
	 * The feature id for the '<em><b>Enumeration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION_FIELD__ENUMERATION = 4;

	/**
	 * The number of structural features of the '<em>Enumeration Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION_FIELD_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Enumeration Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ENUMERATION_FIELD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportedAspectImpl <em>Imported Aspect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateImportedAspectImpl
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateImportedAspect()
	 * @generated
	 */
	int INTERMEDIATE_IMPORTED_ASPECT = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_ASPECT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_ASPECT__QUALIFIED_NAME = 1;

	/**
	 * The feature id for the '<em><b>Feature Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_ASPECT__FEATURE_NAMES = 2;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_ASPECT__IMPORT = 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_ASPECT__PROPERTIES = 4;

	/**
	 * The feature id for the '<em><b>Property Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_ASPECT__PROPERTY_VALUES = 5;

	/**
	 * The feature id for the '<em><b>Complex Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_ASPECT__COMPLEX_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_ASPECT__OPERATION = 7;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_ASPECT__RETURN_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_ASPECT__PARAMETER = 9;

	/**
	 * The feature id for the '<em><b>Data Field</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_ASPECT__DATA_FIELD = 10;

	/**
	 * The number of structural features of the '<em>Imported Aspect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_ASPECT_FEATURE_COUNT = 11;

	/**
	 * The number of operations of the '<em>Imported Aspect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_IMPORTED_ASPECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateAspectPropertyImpl <em>Aspect Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateAspectPropertyImpl
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateAspectProperty()
	 * @generated
	 */
	int INTERMEDIATE_ASPECT_PROPERTY = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ASPECT_PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ASPECT_PROPERTY__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ASPECT_PROPERTY__DEFAULT_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Feature Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ASPECT_PROPERTY__FEATURE_NAMES = 3;

	/**
	 * The feature id for the '<em><b>Aspect</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ASPECT_PROPERTY__ASPECT = 4;

	/**
	 * The number of structural features of the '<em>Aspect Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ASPECT_PROPERTY_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Aspect Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ASPECT_PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateAspectPropertyValueImpl <em>Aspect Property Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateAspectPropertyValueImpl
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateAspectPropertyValue()
	 * @generated
	 */
	int INTERMEDIATE_ASPECT_PROPERTY_VALUE = 19;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ASPECT_PROPERTY_VALUE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ASPECT_PROPERTY_VALUE__PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Aspect</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ASPECT_PROPERTY_VALUE__ASPECT = 2;

	/**
	 * The number of structural features of the '<em>Aspect Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ASPECT_PROPERTY_VALUE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Aspect Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_ASPECT_PROPERTY_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.IntermediateTypeKind <em>Type Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.IntermediateTypeKind
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateTypeKind()
	 * @generated
	 */
	int INTERMEDIATE_TYPE_KIND = 20;

	/**
	 * The meta object id for the '{@link de.fhdo.lemma.data.intermediate.IntermediateTypeOrigin <em>Type Origin</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fhdo.lemma.data.intermediate.IntermediateTypeOrigin
	 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateTypeOrigin()
	 * @generated
	 */
	int INTERMEDIATE_TYPE_ORIGIN = 21;


	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.data.intermediate.IntermediateDataModel <em>Data Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Model</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataModel
	 * @generated
	 */
	EClass getIntermediateDataModel();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateDataModel#getSourceModelUri <em>Source Model Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Model Uri</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataModel#getSourceModelUri()
	 * @see #getIntermediateDataModel()
	 * @generated
	 */
	EAttribute getIntermediateDataModel_SourceModelUri();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateDataModel#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataModel#getImports()
	 * @see #getIntermediateDataModel()
	 * @generated
	 */
	EReference getIntermediateDataModel_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateDataModel#getVersions <em>Versions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Versions</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataModel#getVersions()
	 * @see #getIntermediateDataModel()
	 * @generated
	 */
	EReference getIntermediateDataModel_Versions();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateDataModel#getContexts <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contexts</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataModel#getContexts()
	 * @see #getIntermediateDataModel()
	 * @generated
	 */
	EReference getIntermediateDataModel_Contexts();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateDataModel#getComplexTypes <em>Complex Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Complex Types</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataModel#getComplexTypes()
	 * @see #getIntermediateDataModel()
	 * @generated
	 */
	EReference getIntermediateDataModel_ComplexTypes();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.data.intermediate.IntermediateImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImport
	 * @generated
	 */
	EClass getIntermediateImport();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateImport#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImport#getName()
	 * @see #getIntermediateImport()
	 * @generated
	 */
	EAttribute getIntermediateImport_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateImport#getImportUri <em>Import Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import Uri</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImport#getImportUri()
	 * @see #getIntermediateImport()
	 * @generated
	 */
	EAttribute getIntermediateImport_ImportUri();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateImport#getImportTypeName <em>Import Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import Type Name</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImport#getImportTypeName()
	 * @see #getIntermediateImport()
	 * @generated
	 */
	EAttribute getIntermediateImport_ImportTypeName();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateImport#getDataModel <em>Data Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Data Model</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImport#getDataModel()
	 * @see #getIntermediateImport()
	 * @generated
	 */
	EReference getIntermediateImport_DataModel();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateImport#getImportTypeNameForDatatypes <em>Import Type Name For Datatypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import Type Name For Datatypes</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImport#getImportTypeNameForDatatypes()
	 * @see #getIntermediateImport()
	 * @generated
	 */
	EAttribute getIntermediateImport_ImportTypeNameForDatatypes();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.data.intermediate.IntermediateVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateVersion
	 * @generated
	 */
	EClass getIntermediateVersion();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateVersion#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateVersion#getName()
	 * @see #getIntermediateVersion()
	 * @generated
	 */
	EAttribute getIntermediateVersion_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateVersion#getComplexTypes <em>Complex Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Complex Types</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateVersion#getComplexTypes()
	 * @see #getIntermediateVersion()
	 * @generated
	 */
	EReference getIntermediateVersion_ComplexTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateVersion#getContexts <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contexts</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateVersion#getContexts()
	 * @see #getIntermediateVersion()
	 * @generated
	 */
	EReference getIntermediateVersion_Contexts();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateVersion#getDataModel <em>Data Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Data Model</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateVersion#getDataModel()
	 * @see #getIntermediateVersion()
	 * @generated
	 */
	EReference getIntermediateVersion_DataModel();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.data.intermediate.IntermediateContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateContext
	 * @generated
	 */
	EClass getIntermediateContext();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateContext#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateContext#getName()
	 * @see #getIntermediateContext()
	 * @generated
	 */
	EAttribute getIntermediateContext_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateContext#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateContext#getQualifiedName()
	 * @see #getIntermediateContext()
	 * @generated
	 */
	EAttribute getIntermediateContext_QualifiedName();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateContext#getComplexTypes <em>Complex Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Complex Types</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateContext#getComplexTypes()
	 * @see #getIntermediateContext()
	 * @generated
	 */
	EReference getIntermediateContext_ComplexTypes();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateContext#getDataModel <em>Data Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Data Model</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateContext#getDataModel()
	 * @see #getIntermediateContext()
	 * @generated
	 */
	EReference getIntermediateContext_DataModel();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateContext#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Version</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateContext#getVersion()
	 * @see #getIntermediateContext()
	 * @generated
	 */
	EReference getIntermediateContext_Version();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.data.intermediate.IntermediateType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateType
	 * @generated
	 */
	EClass getIntermediateType();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateType#getName()
	 * @see #getIntermediateType()
	 * @generated
	 */
	EAttribute getIntermediateType_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateType#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Origin</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateType#getOrigin()
	 * @see #getIntermediateType()
	 * @generated
	 */
	EAttribute getIntermediateType_Origin();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateType#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateType#getKind()
	 * @see #getIntermediateType()
	 * @generated
	 */
	EAttribute getIntermediateType_Kind();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateType#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Return Type</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateType#getReturnType()
	 * @see #getIntermediateType()
	 * @generated
	 */
	EReference getIntermediateType_ReturnType();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateType#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parameter</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateType#getParameter()
	 * @see #getIntermediateType()
	 * @generated
	 */
	EReference getIntermediateType_Parameter();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateType#getDataField <em>Data Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Data Field</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateType#getDataField()
	 * @see #getIntermediateType()
	 * @generated
	 */
	EReference getIntermediateType_DataField();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType
	 * @generated
	 */
	EClass getIntermediatePrimitiveType();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType#getSize()
	 * @see #getIntermediatePrimitiveType()
	 * @generated
	 */
	EAttribute getIntermediatePrimitiveType_Size();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType#getInitializedDataField <em>Initialized Data Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Initialized Data Field</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType#getInitializedDataField()
	 * @see #getIntermediatePrimitiveType()
	 * @generated
	 */
	EReference getIntermediatePrimitiveType_InitializedDataField();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType#getInitializedEnumerationField <em>Initialized Enumeration Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Initialized Enumeration Field</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType#getInitializedEnumerationField()
	 * @see #getIntermediatePrimitiveType()
	 * @generated
	 */
	EReference getIntermediatePrimitiveType_InitializedEnumerationField();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.data.intermediate.IntermediateComplexType <em>Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Type</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateComplexType
	 * @generated
	 */
	EClass getIntermediateComplexType();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateComplexType#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateComplexType#getQualifiedName()
	 * @see #getIntermediateComplexType()
	 * @generated
	 */
	EAttribute getIntermediateComplexType_QualifiedName();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateComplexType#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateComplexType#getAspects()
	 * @see #getIntermediateComplexType()
	 * @generated
	 */
	EReference getIntermediateComplexType_Aspects();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateComplexType#getDataModel <em>Data Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Data Model</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateComplexType#getDataModel()
	 * @see #getIntermediateComplexType()
	 * @generated
	 */
	EReference getIntermediateComplexType_DataModel();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateComplexType#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Version</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateComplexType#getVersion()
	 * @see #getIntermediateComplexType()
	 * @generated
	 */
	EReference getIntermediateComplexType_Version();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateComplexType#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Context</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateComplexType#getContext()
	 * @see #getIntermediateComplexType()
	 * @generated
	 */
	EReference getIntermediateComplexType_Context();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedComplexType <em>Imported Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imported Complex Type</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedComplexType
	 * @generated
	 */
	EClass getIntermediateImportedComplexType();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedComplexType#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Import</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedComplexType#getImport()
	 * @see #getIntermediateImportedComplexType()
	 * @generated
	 */
	EReference getIntermediateImportedComplexType_Import();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedTechnologySpecificType <em>Imported Technology Specific Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imported Technology Specific Type</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedTechnologySpecificType
	 * @generated
	 */
	EClass getIntermediateImportedTechnologySpecificType();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedTechnologySpecificType#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedTechnologySpecificType#getQualifiedName()
	 * @see #getIntermediateImportedTechnologySpecificType()
	 * @generated
	 */
	EAttribute getIntermediateImportedTechnologySpecificType_QualifiedName();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedTechnologySpecificType#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Import</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedTechnologySpecificType#getImport()
	 * @see #getIntermediateImportedTechnologySpecificType()
	 * @generated
	 */
	EReference getIntermediateImportedTechnologySpecificType_Import();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.data.intermediate.IntermediateDataStructure <em>Data Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Structure</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataStructure
	 * @generated
	 */
	EClass getIntermediateDataStructure();

	/**
	 * Returns the meta object for the attribute list '{@link de.fhdo.lemma.data.intermediate.IntermediateDataStructure#getFeatureNames <em>Feature Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Names</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataStructure#getFeatureNames()
	 * @see #getIntermediateDataStructure()
	 * @generated
	 */
	EAttribute getIntermediateDataStructure_FeatureNames();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.data.intermediate.IntermediateDataStructure#getSuper <em>Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataStructure#getSuper()
	 * @see #getIntermediateDataStructure()
	 * @generated
	 */
	EReference getIntermediateDataStructure_Super();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateDataStructure#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataStructure#getOperations()
	 * @see #getIntermediateDataStructure()
	 * @generated
	 */
	EReference getIntermediateDataStructure_Operations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateDataStructure#getDataFields <em>Data Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Fields</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataStructure#getDataFields()
	 * @see #getIntermediateDataStructure()
	 * @generated
	 */
	EReference getIntermediateDataStructure_DataFields();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation <em>Data Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Operation</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperation
	 * @generated
	 */
	EClass getIntermediateDataOperation();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getName()
	 * @see #getIntermediateDataOperation()
	 * @generated
	 */
	EAttribute getIntermediateDataOperation_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getQualifiedName()
	 * @see #getIntermediateDataOperation()
	 * @generated
	 */
	EAttribute getIntermediateDataOperation_QualifiedName();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#isHidden <em>Hidden</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hidden</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperation#isHidden()
	 * @see #getIntermediateDataOperation()
	 * @generated
	 */
	EAttribute getIntermediateDataOperation_Hidden();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#isInherited <em>Inherited</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inherited</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperation#isInherited()
	 * @see #getIntermediateDataOperation()
	 * @generated
	 */
	EAttribute getIntermediateDataOperation_Inherited();

	/**
	 * Returns the meta object for the attribute list '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getFeatureNames <em>Feature Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Names</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getFeatureNames()
	 * @see #getIntermediateDataOperation()
	 * @generated
	 */
	EAttribute getIntermediateDataOperation_FeatureNames();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getReturnType()
	 * @see #getIntermediateDataOperation()
	 * @generated
	 */
	EReference getIntermediateDataOperation_ReturnType();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getParameters()
	 * @see #getIntermediateDataOperation()
	 * @generated
	 */
	EReference getIntermediateDataOperation_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getAspects()
	 * @see #getIntermediateDataOperation()
	 * @generated
	 */
	EReference getIntermediateDataOperation_Aspects();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getDataStructure <em>Data Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Data Structure</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperation#getDataStructure()
	 * @see #getIntermediateDataOperation()
	 * @generated
	 */
	EReference getIntermediateDataOperation_DataStructure();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType <em>Data Operation Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Operation Return Type</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType
	 * @generated
	 */
	EClass getIntermediateDataOperationReturnType();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType#getType()
	 * @see #getIntermediateDataOperationReturnType()
	 * @generated
	 */
	EReference getIntermediateDataOperationReturnType_Type();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType#getOriginalType <em>Original Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Original Type</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType#getOriginalType()
	 * @see #getIntermediateDataOperationReturnType()
	 * @generated
	 */
	EReference getIntermediateDataOperationReturnType_OriginalType();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType#getAspects()
	 * @see #getIntermediateDataOperationReturnType()
	 * @generated
	 */
	EReference getIntermediateDataOperationReturnType_Aspects();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Operation</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType#getOperation()
	 * @see #getIntermediateDataOperationReturnType()
	 * @generated
	 */
	EReference getIntermediateDataOperationReturnType_Operation();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter <em>Data Operation Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Operation Parameter</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter
	 * @generated
	 */
	EClass getIntermediateDataOperationParameter();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getName()
	 * @see #getIntermediateDataOperationParameter()
	 * @generated
	 */
	EAttribute getIntermediateDataOperationParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getQualifiedName()
	 * @see #getIntermediateDataOperationParameter()
	 * @generated
	 */
	EAttribute getIntermediateDataOperationParameter_QualifiedName();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getType()
	 * @see #getIntermediateDataOperationParameter()
	 * @generated
	 */
	EReference getIntermediateDataOperationParameter_Type();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getOriginalType <em>Original Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Original Type</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getOriginalType()
	 * @see #getIntermediateDataOperationParameter()
	 * @generated
	 */
	EReference getIntermediateDataOperationParameter_OriginalType();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getAspects()
	 * @see #getIntermediateDataOperationParameter()
	 * @generated
	 */
	EReference getIntermediateDataOperationParameter_Aspects();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Operation</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter#getOperation()
	 * @see #getIntermediateDataOperationParameter()
	 * @generated
	 */
	EReference getIntermediateDataOperationParameter_Operation();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.data.intermediate.IntermediateListType <em>List Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Type</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateListType
	 * @generated
	 */
	EClass getIntermediateListType();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateListType#isPrimitiveList <em>Primitive List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primitive List</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateListType#isPrimitiveList()
	 * @see #getIntermediateListType()
	 * @generated
	 */
	EAttribute getIntermediateListType_PrimitiveList();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateListType#isStructuredList <em>Structured List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Structured List</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateListType#isStructuredList()
	 * @see #getIntermediateListType()
	 * @generated
	 */
	EAttribute getIntermediateListType_StructuredList();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.data.intermediate.IntermediateListType#getPrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Primitive Type</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateListType#getPrimitiveType()
	 * @see #getIntermediateListType()
	 * @generated
	 */
	EReference getIntermediateListType_PrimitiveType();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateListType#getDataFields <em>Data Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Fields</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateListType#getDataFields()
	 * @see #getIntermediateListType()
	 * @generated
	 */
	EReference getIntermediateListType_DataFields();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField <em>Data Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Field</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataField
	 * @generated
	 */
	EClass getIntermediateDataField();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataField#getName()
	 * @see #getIntermediateDataField()
	 * @generated
	 */
	EAttribute getIntermediateDataField_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataField#getQualifiedName()
	 * @see #getIntermediateDataField()
	 * @generated
	 */
	EAttribute getIntermediateDataField_QualifiedName();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#isHidden <em>Hidden</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hidden</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataField#isHidden()
	 * @see #getIntermediateDataField()
	 * @generated
	 */
	EAttribute getIntermediateDataField_Hidden();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#isImmutable <em>Immutable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Immutable</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataField#isImmutable()
	 * @see #getIntermediateDataField()
	 * @generated
	 */
	EAttribute getIntermediateDataField_Immutable();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#isInherited <em>Inherited</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inherited</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataField#isInherited()
	 * @see #getIntermediateDataField()
	 * @generated
	 */
	EAttribute getIntermediateDataField_Inherited();

	/**
	 * Returns the meta object for the attribute list '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getFeatureNames <em>Feature Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Names</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataField#getFeatureNames()
	 * @see #getIntermediateDataField()
	 * @generated
	 */
	EAttribute getIntermediateDataField_FeatureNames();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getInitializationValue <em>Initialization Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialization Value</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataField#getInitializationValue()
	 * @see #getIntermediateDataField()
	 * @generated
	 */
	EAttribute getIntermediateDataField_InitializationValue();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getInitializationValueCompatibleTypes <em>Initialization Value Compatible Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Initialization Value Compatible Types</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataField#getInitializationValueCompatibleTypes()
	 * @see #getIntermediateDataField()
	 * @generated
	 */
	EReference getIntermediateDataField_InitializationValueCompatibleTypes();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataField#getType()
	 * @see #getIntermediateDataField()
	 * @generated
	 */
	EReference getIntermediateDataField_Type();

	/**
	 * Returns the meta object for the containment reference '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getOriginalType <em>Original Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Original Type</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataField#getOriginalType()
	 * @see #getIntermediateDataField()
	 * @generated
	 */
	EReference getIntermediateDataField_OriginalType();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspects</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataField#getAspects()
	 * @see #getIntermediateDataField()
	 * @generated
	 */
	EReference getIntermediateDataField_Aspects();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getDataStructure <em>Data Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Data Structure</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataField#getDataStructure()
	 * @see #getIntermediateDataField()
	 * @generated
	 */
	EReference getIntermediateDataField_DataStructure();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getListType <em>List Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>List Type</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataField#getListType()
	 * @see #getIntermediateDataField()
	 * @generated
	 */
	EReference getIntermediateDataField_ListType();

	/**
	 * Returns the meta object for the '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getEffectiveComplexType() <em>Get Effective Complex Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Effective Complex Type</em>' operation.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataField#getEffectiveComplexType()
	 * @generated
	 */
	EOperation getIntermediateDataField__GetEffectiveComplexType();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.data.intermediate.IntermediateEnumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateEnumeration
	 * @generated
	 */
	EClass getIntermediateEnumeration();

	/**
	 * Returns the meta object for the attribute list '{@link de.fhdo.lemma.data.intermediate.IntermediateEnumeration#getFeatureNames <em>Feature Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Names</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateEnumeration#getFeatureNames()
	 * @see #getIntermediateEnumeration()
	 * @generated
	 */
	EAttribute getIntermediateEnumeration_FeatureNames();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateEnumeration#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fields</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateEnumeration#getFields()
	 * @see #getIntermediateEnumeration()
	 * @generated
	 */
	EReference getIntermediateEnumeration_Fields();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.data.intermediate.IntermediateEnumerationField <em>Enumeration Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Field</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateEnumerationField
	 * @generated
	 */
	EClass getIntermediateEnumerationField();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateEnumerationField#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateEnumerationField#getName()
	 * @see #getIntermediateEnumerationField()
	 * @generated
	 */
	EAttribute getIntermediateEnumerationField_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateEnumerationField#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateEnumerationField#getQualifiedName()
	 * @see #getIntermediateEnumerationField()
	 * @generated
	 */
	EAttribute getIntermediateEnumerationField_QualifiedName();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateEnumerationField#getInitializationValue <em>Initialization Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialization Value</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateEnumerationField#getInitializationValue()
	 * @see #getIntermediateEnumerationField()
	 * @generated
	 */
	EAttribute getIntermediateEnumerationField_InitializationValue();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateEnumerationField#getInitializationValueCompatibleTypes <em>Initialization Value Compatible Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Initialization Value Compatible Types</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateEnumerationField#getInitializationValueCompatibleTypes()
	 * @see #getIntermediateEnumerationField()
	 * @generated
	 */
	EReference getIntermediateEnumerationField_InitializationValueCompatibleTypes();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateEnumerationField#getEnumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Enumeration</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateEnumerationField#getEnumeration()
	 * @see #getIntermediateEnumerationField()
	 * @generated
	 */
	EReference getIntermediateEnumerationField_Enumeration();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect <em>Imported Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imported Aspect</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
	 * @generated
	 */
	EClass getIntermediateImportedAspect();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getName()
	 * @see #getIntermediateImportedAspect()
	 * @generated
	 */
	EAttribute getIntermediateImportedAspect_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getQualifiedName()
	 * @see #getIntermediateImportedAspect()
	 * @generated
	 */
	EAttribute getIntermediateImportedAspect_QualifiedName();

	/**
	 * Returns the meta object for the attribute list '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getFeatureNames <em>Feature Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Names</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getFeatureNames()
	 * @see #getIntermediateImportedAspect()
	 * @generated
	 */
	EAttribute getIntermediateImportedAspect_FeatureNames();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Import</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getImport()
	 * @see #getIntermediateImportedAspect()
	 * @generated
	 */
	EReference getIntermediateImportedAspect_Import();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getProperties()
	 * @see #getIntermediateImportedAspect()
	 * @generated
	 */
	EReference getIntermediateImportedAspect_Properties();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getPropertyValues <em>Property Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Values</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getPropertyValues()
	 * @see #getIntermediateImportedAspect()
	 * @generated
	 */
	EReference getIntermediateImportedAspect_PropertyValues();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getComplexType <em>Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Complex Type</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getComplexType()
	 * @see #getIntermediateImportedAspect()
	 * @generated
	 */
	EReference getIntermediateImportedAspect_ComplexType();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Operation</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getOperation()
	 * @see #getIntermediateImportedAspect()
	 * @generated
	 */
	EReference getIntermediateImportedAspect_Operation();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Return Type</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getReturnType()
	 * @see #getIntermediateImportedAspect()
	 * @generated
	 */
	EReference getIntermediateImportedAspect_ReturnType();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parameter</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getParameter()
	 * @see #getIntermediateImportedAspect()
	 * @generated
	 */
	EReference getIntermediateImportedAspect_Parameter();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getDataField <em>Data Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Data Field</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getDataField()
	 * @see #getIntermediateImportedAspect()
	 * @generated
	 */
	EReference getIntermediateImportedAspect_DataField();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.data.intermediate.IntermediateAspectProperty <em>Aspect Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aspect Property</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateAspectProperty
	 * @generated
	 */
	EClass getIntermediateAspectProperty();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getName()
	 * @see #getIntermediateAspectProperty()
	 * @generated
	 */
	EAttribute getIntermediateAspectProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getType()
	 * @see #getIntermediateAspectProperty()
	 * @generated
	 */
	EAttribute getIntermediateAspectProperty_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getDefaultValue()
	 * @see #getIntermediateAspectProperty()
	 * @generated
	 */
	EAttribute getIntermediateAspectProperty_DefaultValue();

	/**
	 * Returns the meta object for the attribute list '{@link de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getFeatureNames <em>Feature Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Names</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getFeatureNames()
	 * @see #getIntermediateAspectProperty()
	 * @generated
	 */
	EAttribute getIntermediateAspectProperty_FeatureNames();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getAspect <em>Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Aspect</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getAspect()
	 * @see #getIntermediateAspectProperty()
	 * @generated
	 */
	EReference getIntermediateAspectProperty_Aspect();

	/**
	 * Returns the meta object for class '{@link de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue <em>Aspect Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aspect Property Value</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue
	 * @generated
	 */
	EClass getIntermediateAspectPropertyValue();

	/**
	 * Returns the meta object for the attribute '{@link de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue#getValue()
	 * @see #getIntermediateAspectPropertyValue()
	 * @generated
	 */
	EAttribute getIntermediateAspectPropertyValue_Value();

	/**
	 * Returns the meta object for the reference '{@link de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue#getProperty()
	 * @see #getIntermediateAspectPropertyValue()
	 * @generated
	 */
	EReference getIntermediateAspectPropertyValue_Property();

	/**
	 * Returns the meta object for the container reference '{@link de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue#getAspect <em>Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Aspect</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue#getAspect()
	 * @see #getIntermediateAspectPropertyValue()
	 * @generated
	 */
	EReference getIntermediateAspectPropertyValue_Aspect();

	/**
	 * Returns the meta object for enum '{@link de.fhdo.lemma.data.intermediate.IntermediateTypeKind <em>Type Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Kind</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateTypeKind
	 * @generated
	 */
	EEnum getIntermediateTypeKind();

	/**
	 * Returns the meta object for enum '{@link de.fhdo.lemma.data.intermediate.IntermediateTypeOrigin <em>Type Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Origin</em>'.
	 * @see de.fhdo.lemma.data.intermediate.IntermediateTypeOrigin
	 * @generated
	 */
	EEnum getIntermediateTypeOrigin();

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
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataModelImpl <em>Data Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateDataModelImpl
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateDataModel()
		 * @generated
		 */
		EClass INTERMEDIATE_DATA_MODEL = eINSTANCE.getIntermediateDataModel();

		/**
		 * The meta object literal for the '<em><b>Source Model Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_DATA_MODEL__SOURCE_MODEL_URI = eINSTANCE.getIntermediateDataModel_SourceModelUri();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_MODEL__IMPORTS = eINSTANCE.getIntermediateDataModel_Imports();

		/**
		 * The meta object literal for the '<em><b>Versions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_MODEL__VERSIONS = eINSTANCE.getIntermediateDataModel_Versions();

		/**
		 * The meta object literal for the '<em><b>Contexts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_MODEL__CONTEXTS = eINSTANCE.getIntermediateDataModel_Contexts();

		/**
		 * The meta object literal for the '<em><b>Complex Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_MODEL__COMPLEX_TYPES = eINSTANCE.getIntermediateDataModel_ComplexTypes();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportImpl <em>Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateImportImpl
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateImport()
		 * @generated
		 */
		EClass INTERMEDIATE_IMPORT = eINSTANCE.getIntermediateImport();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_IMPORT__NAME = eINSTANCE.getIntermediateImport_Name();

		/**
		 * The meta object literal for the '<em><b>Import Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_IMPORT__IMPORT_URI = eINSTANCE.getIntermediateImport_ImportUri();

		/**
		 * The meta object literal for the '<em><b>Import Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_IMPORT__IMPORT_TYPE_NAME = eINSTANCE.getIntermediateImport_ImportTypeName();

		/**
		 * The meta object literal for the '<em><b>Data Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_IMPORT__DATA_MODEL = eINSTANCE.getIntermediateImport_DataModel();

		/**
		 * The meta object literal for the '<em><b>Import Type Name For Datatypes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_IMPORT__IMPORT_TYPE_NAME_FOR_DATATYPES = eINSTANCE.getIntermediateImport_ImportTypeNameForDatatypes();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateVersionImpl <em>Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateVersionImpl
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateVersion()
		 * @generated
		 */
		EClass INTERMEDIATE_VERSION = eINSTANCE.getIntermediateVersion();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_VERSION__NAME = eINSTANCE.getIntermediateVersion_Name();

		/**
		 * The meta object literal for the '<em><b>Complex Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_VERSION__COMPLEX_TYPES = eINSTANCE.getIntermediateVersion_ComplexTypes();

		/**
		 * The meta object literal for the '<em><b>Contexts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_VERSION__CONTEXTS = eINSTANCE.getIntermediateVersion_Contexts();

		/**
		 * The meta object literal for the '<em><b>Data Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_VERSION__DATA_MODEL = eINSTANCE.getIntermediateVersion_DataModel();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateContextImpl
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateContext()
		 * @generated
		 */
		EClass INTERMEDIATE_CONTEXT = eINSTANCE.getIntermediateContext();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_CONTEXT__NAME = eINSTANCE.getIntermediateContext_Name();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_CONTEXT__QUALIFIED_NAME = eINSTANCE.getIntermediateContext_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Complex Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_CONTEXT__COMPLEX_TYPES = eINSTANCE.getIntermediateContext_ComplexTypes();

		/**
		 * The meta object literal for the '<em><b>Data Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_CONTEXT__DATA_MODEL = eINSTANCE.getIntermediateContext_DataModel();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_CONTEXT__VERSION = eINSTANCE.getIntermediateContext_Version();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateTypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateTypeImpl
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateType()
		 * @generated
		 */
		EClass INTERMEDIATE_TYPE = eINSTANCE.getIntermediateType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_TYPE__NAME = eINSTANCE.getIntermediateType_Name();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_TYPE__ORIGIN = eINSTANCE.getIntermediateType_Origin();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_TYPE__KIND = eINSTANCE.getIntermediateType_Kind();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_TYPE__RETURN_TYPE = eINSTANCE.getIntermediateType_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_TYPE__PARAMETER = eINSTANCE.getIntermediateType_Parameter();

		/**
		 * The meta object literal for the '<em><b>Data Field</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_TYPE__DATA_FIELD = eINSTANCE.getIntermediateType_DataField();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediatePrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePrimitiveTypeImpl
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediatePrimitiveType()
		 * @generated
		 */
		EClass INTERMEDIATE_PRIMITIVE_TYPE = eINSTANCE.getIntermediatePrimitiveType();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_PRIMITIVE_TYPE__SIZE = eINSTANCE.getIntermediatePrimitiveType_Size();

		/**
		 * The meta object literal for the '<em><b>Initialized Data Field</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_DATA_FIELD = eINSTANCE.getIntermediatePrimitiveType_InitializedDataField();

		/**
		 * The meta object literal for the '<em><b>Initialized Enumeration Field</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_ENUMERATION_FIELD = eINSTANCE.getIntermediatePrimitiveType_InitializedEnumerationField();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateComplexTypeImpl <em>Complex Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateComplexTypeImpl
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateComplexType()
		 * @generated
		 */
		EClass INTERMEDIATE_COMPLEX_TYPE = eINSTANCE.getIntermediateComplexType();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_COMPLEX_TYPE__QUALIFIED_NAME = eINSTANCE.getIntermediateComplexType_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_COMPLEX_TYPE__ASPECTS = eINSTANCE.getIntermediateComplexType_Aspects();

		/**
		 * The meta object literal for the '<em><b>Data Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL = eINSTANCE.getIntermediateComplexType_DataModel();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_COMPLEX_TYPE__VERSION = eINSTANCE.getIntermediateComplexType_Version();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_COMPLEX_TYPE__CONTEXT = eINSTANCE.getIntermediateComplexType_Context();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportedComplexTypeImpl <em>Imported Complex Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateImportedComplexTypeImpl
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateImportedComplexType()
		 * @generated
		 */
		EClass INTERMEDIATE_IMPORTED_COMPLEX_TYPE = eINSTANCE.getIntermediateImportedComplexType();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_IMPORTED_COMPLEX_TYPE__IMPORT = eINSTANCE.getIntermediateImportedComplexType_Import();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportedTechnologySpecificTypeImpl <em>Imported Technology Specific Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateImportedTechnologySpecificTypeImpl
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateImportedTechnologySpecificType()
		 * @generated
		 */
		EClass INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE = eINSTANCE.getIntermediateImportedTechnologySpecificType();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__QUALIFIED_NAME = eINSTANCE.getIntermediateImportedTechnologySpecificType_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__IMPORT = eINSTANCE.getIntermediateImportedTechnologySpecificType_Import();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataStructureImpl <em>Data Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateDataStructureImpl
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateDataStructure()
		 * @generated
		 */
		EClass INTERMEDIATE_DATA_STRUCTURE = eINSTANCE.getIntermediateDataStructure();

		/**
		 * The meta object literal for the '<em><b>Feature Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_DATA_STRUCTURE__FEATURE_NAMES = eINSTANCE.getIntermediateDataStructure_FeatureNames();

		/**
		 * The meta object literal for the '<em><b>Super</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_STRUCTURE__SUPER = eINSTANCE.getIntermediateDataStructure_Super();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_STRUCTURE__OPERATIONS = eINSTANCE.getIntermediateDataStructure_Operations();

		/**
		 * The meta object literal for the '<em><b>Data Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_STRUCTURE__DATA_FIELDS = eINSTANCE.getIntermediateDataStructure_DataFields();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationImpl <em>Data Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationImpl
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateDataOperation()
		 * @generated
		 */
		EClass INTERMEDIATE_DATA_OPERATION = eINSTANCE.getIntermediateDataOperation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_DATA_OPERATION__NAME = eINSTANCE.getIntermediateDataOperation_Name();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_DATA_OPERATION__QUALIFIED_NAME = eINSTANCE.getIntermediateDataOperation_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Hidden</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_DATA_OPERATION__HIDDEN = eINSTANCE.getIntermediateDataOperation_Hidden();

		/**
		 * The meta object literal for the '<em><b>Inherited</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_DATA_OPERATION__INHERITED = eINSTANCE.getIntermediateDataOperation_Inherited();

		/**
		 * The meta object literal for the '<em><b>Feature Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_DATA_OPERATION__FEATURE_NAMES = eINSTANCE.getIntermediateDataOperation_FeatureNames();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_OPERATION__RETURN_TYPE = eINSTANCE.getIntermediateDataOperation_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_OPERATION__PARAMETERS = eINSTANCE.getIntermediateDataOperation_Parameters();

		/**
		 * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_OPERATION__ASPECTS = eINSTANCE.getIntermediateDataOperation_Aspects();

		/**
		 * The meta object literal for the '<em><b>Data Structure</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_OPERATION__DATA_STRUCTURE = eINSTANCE.getIntermediateDataOperation_DataStructure();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationReturnTypeImpl <em>Data Operation Return Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationReturnTypeImpl
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateDataOperationReturnType()
		 * @generated
		 */
		EClass INTERMEDIATE_DATA_OPERATION_RETURN_TYPE = eINSTANCE.getIntermediateDataOperationReturnType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_OPERATION_RETURN_TYPE__TYPE = eINSTANCE.getIntermediateDataOperationReturnType_Type();

		/**
		 * The meta object literal for the '<em><b>Original Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_OPERATION_RETURN_TYPE__ORIGINAL_TYPE = eINSTANCE.getIntermediateDataOperationReturnType_OriginalType();

		/**
		 * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_OPERATION_RETURN_TYPE__ASPECTS = eINSTANCE.getIntermediateDataOperationReturnType_Aspects();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_OPERATION_RETURN_TYPE__OPERATION = eINSTANCE.getIntermediateDataOperationReturnType_Operation();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationParameterImpl <em>Data Operation Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationParameterImpl
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateDataOperationParameter()
		 * @generated
		 */
		EClass INTERMEDIATE_DATA_OPERATION_PARAMETER = eINSTANCE.getIntermediateDataOperationParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_DATA_OPERATION_PARAMETER__NAME = eINSTANCE.getIntermediateDataOperationParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_DATA_OPERATION_PARAMETER__QUALIFIED_NAME = eINSTANCE.getIntermediateDataOperationParameter_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_OPERATION_PARAMETER__TYPE = eINSTANCE.getIntermediateDataOperationParameter_Type();

		/**
		 * The meta object literal for the '<em><b>Original Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_OPERATION_PARAMETER__ORIGINAL_TYPE = eINSTANCE.getIntermediateDataOperationParameter_OriginalType();

		/**
		 * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_OPERATION_PARAMETER__ASPECTS = eINSTANCE.getIntermediateDataOperationParameter_Aspects();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_OPERATION_PARAMETER__OPERATION = eINSTANCE.getIntermediateDataOperationParameter_Operation();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateListTypeImpl <em>List Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateListTypeImpl
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateListType()
		 * @generated
		 */
		EClass INTERMEDIATE_LIST_TYPE = eINSTANCE.getIntermediateListType();

		/**
		 * The meta object literal for the '<em><b>Primitive List</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_LIST_TYPE__PRIMITIVE_LIST = eINSTANCE.getIntermediateListType_PrimitiveList();

		/**
		 * The meta object literal for the '<em><b>Structured List</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_LIST_TYPE__STRUCTURED_LIST = eINSTANCE.getIntermediateListType_StructuredList();

		/**
		 * The meta object literal for the '<em><b>Primitive Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_LIST_TYPE__PRIMITIVE_TYPE = eINSTANCE.getIntermediateListType_PrimitiveType();

		/**
		 * The meta object literal for the '<em><b>Data Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_LIST_TYPE__DATA_FIELDS = eINSTANCE.getIntermediateListType_DataFields();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataFieldImpl <em>Data Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateDataFieldImpl
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateDataField()
		 * @generated
		 */
		EClass INTERMEDIATE_DATA_FIELD = eINSTANCE.getIntermediateDataField();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_DATA_FIELD__NAME = eINSTANCE.getIntermediateDataField_Name();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_DATA_FIELD__QUALIFIED_NAME = eINSTANCE.getIntermediateDataField_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Hidden</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_DATA_FIELD__HIDDEN = eINSTANCE.getIntermediateDataField_Hidden();

		/**
		 * The meta object literal for the '<em><b>Immutable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_DATA_FIELD__IMMUTABLE = eINSTANCE.getIntermediateDataField_Immutable();

		/**
		 * The meta object literal for the '<em><b>Inherited</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_DATA_FIELD__INHERITED = eINSTANCE.getIntermediateDataField_Inherited();

		/**
		 * The meta object literal for the '<em><b>Feature Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_DATA_FIELD__FEATURE_NAMES = eINSTANCE.getIntermediateDataField_FeatureNames();

		/**
		 * The meta object literal for the '<em><b>Initialization Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_DATA_FIELD__INITIALIZATION_VALUE = eINSTANCE.getIntermediateDataField_InitializationValue();

		/**
		 * The meta object literal for the '<em><b>Initialization Value Compatible Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES = eINSTANCE.getIntermediateDataField_InitializationValueCompatibleTypes();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_FIELD__TYPE = eINSTANCE.getIntermediateDataField_Type();

		/**
		 * The meta object literal for the '<em><b>Original Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_FIELD__ORIGINAL_TYPE = eINSTANCE.getIntermediateDataField_OriginalType();

		/**
		 * The meta object literal for the '<em><b>Aspects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_FIELD__ASPECTS = eINSTANCE.getIntermediateDataField_Aspects();

		/**
		 * The meta object literal for the '<em><b>Data Structure</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_FIELD__DATA_STRUCTURE = eINSTANCE.getIntermediateDataField_DataStructure();

		/**
		 * The meta object literal for the '<em><b>List Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_DATA_FIELD__LIST_TYPE = eINSTANCE.getIntermediateDataField_ListType();

		/**
		 * The meta object literal for the '<em><b>Get Effective Complex Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INTERMEDIATE_DATA_FIELD___GET_EFFECTIVE_COMPLEX_TYPE = eINSTANCE.getIntermediateDataField__GetEffectiveComplexType();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateEnumerationImpl <em>Enumeration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateEnumerationImpl
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateEnumeration()
		 * @generated
		 */
		EClass INTERMEDIATE_ENUMERATION = eINSTANCE.getIntermediateEnumeration();

		/**
		 * The meta object literal for the '<em><b>Feature Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_ENUMERATION__FEATURE_NAMES = eINSTANCE.getIntermediateEnumeration_FeatureNames();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_ENUMERATION__FIELDS = eINSTANCE.getIntermediateEnumeration_Fields();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateEnumerationFieldImpl <em>Enumeration Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateEnumerationFieldImpl
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateEnumerationField()
		 * @generated
		 */
		EClass INTERMEDIATE_ENUMERATION_FIELD = eINSTANCE.getIntermediateEnumerationField();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_ENUMERATION_FIELD__NAME = eINSTANCE.getIntermediateEnumerationField_Name();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_ENUMERATION_FIELD__QUALIFIED_NAME = eINSTANCE.getIntermediateEnumerationField_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Initialization Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_ENUMERATION_FIELD__INITIALIZATION_VALUE = eINSTANCE.getIntermediateEnumerationField_InitializationValue();

		/**
		 * The meta object literal for the '<em><b>Initialization Value Compatible Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_ENUMERATION_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES = eINSTANCE.getIntermediateEnumerationField_InitializationValueCompatibleTypes();

		/**
		 * The meta object literal for the '<em><b>Enumeration</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_ENUMERATION_FIELD__ENUMERATION = eINSTANCE.getIntermediateEnumerationField_Enumeration();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportedAspectImpl <em>Imported Aspect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateImportedAspectImpl
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateImportedAspect()
		 * @generated
		 */
		EClass INTERMEDIATE_IMPORTED_ASPECT = eINSTANCE.getIntermediateImportedAspect();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_IMPORTED_ASPECT__NAME = eINSTANCE.getIntermediateImportedAspect_Name();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_IMPORTED_ASPECT__QUALIFIED_NAME = eINSTANCE.getIntermediateImportedAspect_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Feature Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_IMPORTED_ASPECT__FEATURE_NAMES = eINSTANCE.getIntermediateImportedAspect_FeatureNames();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_IMPORTED_ASPECT__IMPORT = eINSTANCE.getIntermediateImportedAspect_Import();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_IMPORTED_ASPECT__PROPERTIES = eINSTANCE.getIntermediateImportedAspect_Properties();

		/**
		 * The meta object literal for the '<em><b>Property Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_IMPORTED_ASPECT__PROPERTY_VALUES = eINSTANCE.getIntermediateImportedAspect_PropertyValues();

		/**
		 * The meta object literal for the '<em><b>Complex Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_IMPORTED_ASPECT__COMPLEX_TYPE = eINSTANCE.getIntermediateImportedAspect_ComplexType();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_IMPORTED_ASPECT__OPERATION = eINSTANCE.getIntermediateImportedAspect_Operation();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_IMPORTED_ASPECT__RETURN_TYPE = eINSTANCE.getIntermediateImportedAspect_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_IMPORTED_ASPECT__PARAMETER = eINSTANCE.getIntermediateImportedAspect_Parameter();

		/**
		 * The meta object literal for the '<em><b>Data Field</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_IMPORTED_ASPECT__DATA_FIELD = eINSTANCE.getIntermediateImportedAspect_DataField();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateAspectPropertyImpl <em>Aspect Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateAspectPropertyImpl
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateAspectProperty()
		 * @generated
		 */
		EClass INTERMEDIATE_ASPECT_PROPERTY = eINSTANCE.getIntermediateAspectProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_ASPECT_PROPERTY__NAME = eINSTANCE.getIntermediateAspectProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_ASPECT_PROPERTY__TYPE = eINSTANCE.getIntermediateAspectProperty_Type();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_ASPECT_PROPERTY__DEFAULT_VALUE = eINSTANCE.getIntermediateAspectProperty_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Feature Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_ASPECT_PROPERTY__FEATURE_NAMES = eINSTANCE.getIntermediateAspectProperty_FeatureNames();

		/**
		 * The meta object literal for the '<em><b>Aspect</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_ASPECT_PROPERTY__ASPECT = eINSTANCE.getIntermediateAspectProperty_Aspect();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.impl.IntermediateAspectPropertyValueImpl <em>Aspect Property Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediateAspectPropertyValueImpl
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateAspectPropertyValue()
		 * @generated
		 */
		EClass INTERMEDIATE_ASPECT_PROPERTY_VALUE = eINSTANCE.getIntermediateAspectPropertyValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERMEDIATE_ASPECT_PROPERTY_VALUE__VALUE = eINSTANCE.getIntermediateAspectPropertyValue_Value();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_ASPECT_PROPERTY_VALUE__PROPERTY = eINSTANCE.getIntermediateAspectPropertyValue_Property();

		/**
		 * The meta object literal for the '<em><b>Aspect</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE_ASPECT_PROPERTY_VALUE__ASPECT = eINSTANCE.getIntermediateAspectPropertyValue_Aspect();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.IntermediateTypeKind <em>Type Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.IntermediateTypeKind
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateTypeKind()
		 * @generated
		 */
		EEnum INTERMEDIATE_TYPE_KIND = eINSTANCE.getIntermediateTypeKind();

		/**
		 * The meta object literal for the '{@link de.fhdo.lemma.data.intermediate.IntermediateTypeOrigin <em>Type Origin</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fhdo.lemma.data.intermediate.IntermediateTypeOrigin
		 * @see de.fhdo.lemma.data.intermediate.impl.IntermediatePackageImpl#getIntermediateTypeOrigin()
		 * @generated
		 */
		EEnum INTERMEDIATE_TYPE_ORIGIN = eINSTANCE.getIntermediateTypeOrigin();

	}

} //IntermediatePackage
