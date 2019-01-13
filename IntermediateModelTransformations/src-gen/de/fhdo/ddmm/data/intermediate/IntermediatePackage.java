/**
 */
package de.fhdo.ddmm.data.intermediate;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see de.fhdo.ddmm.data.intermediate.IntermediateFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel basePackage='de.fhdo.ddmm.data'"
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
    String eNS_URI = "de.fhdo.ddmm.data.intermediate";

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
    IntermediatePackage eINSTANCE = de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl.init();

    /**
     * The meta object id for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateDataModelImpl <em>Data Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediateDataModelImpl
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateDataModel()
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
     * The meta object id for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediateImportImpl
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateImport()
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
     * The meta object id for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateVersionImpl <em>Version</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediateVersionImpl
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateVersion()
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
     * The meta object id for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateContextImpl <em>Context</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediateContextImpl
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateContext()
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
     * The meta object id for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateTypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediateTypeImpl
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateType()
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
     * The feature id for the '<em><b>Data Field</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_TYPE__DATA_FIELD = 3;

    /**
     * The number of structural features of the '<em>Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_TYPE_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediatePrimitiveTypeImpl <em>Primitive Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePrimitiveTypeImpl
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediatePrimitiveType()
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
     * The number of structural features of the '<em>Primitive Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PRIMITIVE_TYPE_FEATURE_COUNT = INTERMEDIATE_TYPE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Primitive Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_PRIMITIVE_TYPE_OPERATION_COUNT = INTERMEDIATE_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateComplexTypeImpl <em>Complex Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediateComplexTypeImpl
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateComplexType()
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
     * The feature id for the '<em><b>Data Model</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL = INTERMEDIATE_TYPE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Version</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_COMPLEX_TYPE__VERSION = INTERMEDIATE_TYPE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Context</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_COMPLEX_TYPE__CONTEXT = INTERMEDIATE_TYPE_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Complex Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_COMPLEX_TYPE_FEATURE_COUNT = INTERMEDIATE_TYPE_FEATURE_COUNT + 4;

    /**
     * The number of operations of the '<em>Complex Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_COMPLEX_TYPE_OPERATION_COUNT = INTERMEDIATE_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateImportedComplexTypeImpl <em>Imported Complex Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediateImportedComplexTypeImpl
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateImportedComplexType()
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
     * The meta object id for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateDataStructureImpl <em>Data Structure</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediateDataStructureImpl
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateDataStructure()
     * @generated
     */
    int INTERMEDIATE_DATA_STRUCTURE = 8;

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
     * The feature id for the '<em><b>Super</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_DATA_STRUCTURE__SUPER = INTERMEDIATE_COMPLEX_TYPE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Data Fields</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_DATA_STRUCTURE__DATA_FIELDS = INTERMEDIATE_COMPLEX_TYPE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Data Structure</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_DATA_STRUCTURE_FEATURE_COUNT = INTERMEDIATE_COMPLEX_TYPE_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Data Structure</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_DATA_STRUCTURE_OPERATION_COUNT = INTERMEDIATE_COMPLEX_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateListTypeImpl <em>List Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediateListTypeImpl
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateListType()
     * @generated
     */
    int INTERMEDIATE_LIST_TYPE = 9;

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
     * The meta object id for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateDataFieldImpl <em>Data Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediateDataFieldImpl
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateDataField()
     * @generated
     */
    int INTERMEDIATE_DATA_FIELD = 10;

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
     * The feature id for the '<em><b>Derived</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_DATA_FIELD__DERIVED = 3;

    /**
     * The feature id for the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_DATA_FIELD__TYPE = 4;

    /**
     * The feature id for the '<em><b>Data Structure</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_DATA_FIELD__DATA_STRUCTURE = 5;

    /**
     * The feature id for the '<em><b>List Type</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_DATA_FIELD__LIST_TYPE = 6;

    /**
     * The number of structural features of the '<em>Data Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_DATA_FIELD_FEATURE_COUNT = 7;

    /**
     * The number of operations of the '<em>Data Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTERMEDIATE_DATA_FIELD_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.fhdo.ddmm.data.intermediate.IntermediateTypeKind <em>Type Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.ddmm.data.intermediate.IntermediateTypeKind
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateTypeKind()
     * @generated
     */
    int INTERMEDIATE_TYPE_KIND = 11;

    /**
     * The meta object id for the '{@link de.fhdo.ddmm.data.intermediate.IntermediateTypeOrigin <em>Type Origin</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.fhdo.ddmm.data.intermediate.IntermediateTypeOrigin
     * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateTypeOrigin()
     * @generated
     */
    int INTERMEDIATE_TYPE_ORIGIN = 12;


    /**
     * Returns the meta object for class '{@link de.fhdo.ddmm.data.intermediate.IntermediateDataModel <em>Data Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Model</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateDataModel
     * @generated
     */
    EClass getIntermediateDataModel();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.ddmm.data.intermediate.IntermediateDataModel#getSourceModelUri <em>Source Model Uri</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Source Model Uri</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateDataModel#getSourceModelUri()
     * @see #getIntermediateDataModel()
     * @generated
     */
    EAttribute getIntermediateDataModel_SourceModelUri();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.ddmm.data.intermediate.IntermediateDataModel#getImports <em>Imports</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Imports</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateDataModel#getImports()
     * @see #getIntermediateDataModel()
     * @generated
     */
    EReference getIntermediateDataModel_Imports();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.ddmm.data.intermediate.IntermediateDataModel#getVersions <em>Versions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Versions</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateDataModel#getVersions()
     * @see #getIntermediateDataModel()
     * @generated
     */
    EReference getIntermediateDataModel_Versions();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.ddmm.data.intermediate.IntermediateDataModel#getContexts <em>Contexts</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Contexts</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateDataModel#getContexts()
     * @see #getIntermediateDataModel()
     * @generated
     */
    EReference getIntermediateDataModel_Contexts();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.ddmm.data.intermediate.IntermediateDataModel#getComplexTypes <em>Complex Types</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Complex Types</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateDataModel#getComplexTypes()
     * @see #getIntermediateDataModel()
     * @generated
     */
    EReference getIntermediateDataModel_ComplexTypes();

    /**
     * Returns the meta object for class '{@link de.fhdo.ddmm.data.intermediate.IntermediateImport <em>Import</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Import</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateImport
     * @generated
     */
    EClass getIntermediateImport();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.ddmm.data.intermediate.IntermediateImport#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateImport#getName()
     * @see #getIntermediateImport()
     * @generated
     */
    EAttribute getIntermediateImport_Name();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.ddmm.data.intermediate.IntermediateImport#getImportUri <em>Import Uri</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Import Uri</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateImport#getImportUri()
     * @see #getIntermediateImport()
     * @generated
     */
    EAttribute getIntermediateImport_ImportUri();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.ddmm.data.intermediate.IntermediateImport#getImportTypeName <em>Import Type Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Import Type Name</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateImport#getImportTypeName()
     * @see #getIntermediateImport()
     * @generated
     */
    EAttribute getIntermediateImport_ImportTypeName();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.ddmm.data.intermediate.IntermediateImport#getDataModel <em>Data Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Data Model</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateImport#getDataModel()
     * @see #getIntermediateImport()
     * @generated
     */
    EReference getIntermediateImport_DataModel();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.ddmm.data.intermediate.IntermediateImport#getImportTypeNameForDatatypes <em>Import Type Name For Datatypes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Import Type Name For Datatypes</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateImport#getImportTypeNameForDatatypes()
     * @see #getIntermediateImport()
     * @generated
     */
    EAttribute getIntermediateImport_ImportTypeNameForDatatypes();

    /**
     * Returns the meta object for class '{@link de.fhdo.ddmm.data.intermediate.IntermediateVersion <em>Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Version</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateVersion
     * @generated
     */
    EClass getIntermediateVersion();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.ddmm.data.intermediate.IntermediateVersion#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateVersion#getName()
     * @see #getIntermediateVersion()
     * @generated
     */
    EAttribute getIntermediateVersion_Name();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.ddmm.data.intermediate.IntermediateVersion#getComplexTypes <em>Complex Types</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Complex Types</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateVersion#getComplexTypes()
     * @see #getIntermediateVersion()
     * @generated
     */
    EReference getIntermediateVersion_ComplexTypes();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.ddmm.data.intermediate.IntermediateVersion#getContexts <em>Contexts</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Contexts</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateVersion#getContexts()
     * @see #getIntermediateVersion()
     * @generated
     */
    EReference getIntermediateVersion_Contexts();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.ddmm.data.intermediate.IntermediateVersion#getDataModel <em>Data Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Data Model</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateVersion#getDataModel()
     * @see #getIntermediateVersion()
     * @generated
     */
    EReference getIntermediateVersion_DataModel();

    /**
     * Returns the meta object for class '{@link de.fhdo.ddmm.data.intermediate.IntermediateContext <em>Context</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Context</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateContext
     * @generated
     */
    EClass getIntermediateContext();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.ddmm.data.intermediate.IntermediateContext#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateContext#getName()
     * @see #getIntermediateContext()
     * @generated
     */
    EAttribute getIntermediateContext_Name();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.ddmm.data.intermediate.IntermediateContext#getQualifiedName <em>Qualified Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Qualified Name</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateContext#getQualifiedName()
     * @see #getIntermediateContext()
     * @generated
     */
    EAttribute getIntermediateContext_QualifiedName();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.ddmm.data.intermediate.IntermediateContext#getComplexTypes <em>Complex Types</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Complex Types</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateContext#getComplexTypes()
     * @see #getIntermediateContext()
     * @generated
     */
    EReference getIntermediateContext_ComplexTypes();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.ddmm.data.intermediate.IntermediateContext#getDataModel <em>Data Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Data Model</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateContext#getDataModel()
     * @see #getIntermediateContext()
     * @generated
     */
    EReference getIntermediateContext_DataModel();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.ddmm.data.intermediate.IntermediateContext#getVersion <em>Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Version</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateContext#getVersion()
     * @see #getIntermediateContext()
     * @generated
     */
    EReference getIntermediateContext_Version();

    /**
     * Returns the meta object for class '{@link de.fhdo.ddmm.data.intermediate.IntermediateType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateType
     * @generated
     */
    EClass getIntermediateType();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.ddmm.data.intermediate.IntermediateType#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateType#getName()
     * @see #getIntermediateType()
     * @generated
     */
    EAttribute getIntermediateType_Name();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.ddmm.data.intermediate.IntermediateType#getOrigin <em>Origin</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Origin</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateType#getOrigin()
     * @see #getIntermediateType()
     * @generated
     */
    EAttribute getIntermediateType_Origin();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.ddmm.data.intermediate.IntermediateType#getKind <em>Kind</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Kind</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateType#getKind()
     * @see #getIntermediateType()
     * @generated
     */
    EAttribute getIntermediateType_Kind();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.ddmm.data.intermediate.IntermediateType#getDataField <em>Data Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Data Field</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateType#getDataField()
     * @see #getIntermediateType()
     * @generated
     */
    EReference getIntermediateType_DataField();

    /**
     * Returns the meta object for class '{@link de.fhdo.ddmm.data.intermediate.IntermediatePrimitiveType <em>Primitive Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Primitive Type</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediatePrimitiveType
     * @generated
     */
    EClass getIntermediatePrimitiveType();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.ddmm.data.intermediate.IntermediatePrimitiveType#getSize <em>Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Size</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediatePrimitiveType#getSize()
     * @see #getIntermediatePrimitiveType()
     * @generated
     */
    EAttribute getIntermediatePrimitiveType_Size();

    /**
     * Returns the meta object for class '{@link de.fhdo.ddmm.data.intermediate.IntermediateComplexType <em>Complex Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Complex Type</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateComplexType
     * @generated
     */
    EClass getIntermediateComplexType();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.ddmm.data.intermediate.IntermediateComplexType#getQualifiedName <em>Qualified Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Qualified Name</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateComplexType#getQualifiedName()
     * @see #getIntermediateComplexType()
     * @generated
     */
    EAttribute getIntermediateComplexType_QualifiedName();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.ddmm.data.intermediate.IntermediateComplexType#getDataModel <em>Data Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Data Model</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateComplexType#getDataModel()
     * @see #getIntermediateComplexType()
     * @generated
     */
    EReference getIntermediateComplexType_DataModel();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.ddmm.data.intermediate.IntermediateComplexType#getVersion <em>Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Version</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateComplexType#getVersion()
     * @see #getIntermediateComplexType()
     * @generated
     */
    EReference getIntermediateComplexType_Version();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.ddmm.data.intermediate.IntermediateComplexType#getContext <em>Context</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Context</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateComplexType#getContext()
     * @see #getIntermediateComplexType()
     * @generated
     */
    EReference getIntermediateComplexType_Context();

    /**
     * Returns the meta object for class '{@link de.fhdo.ddmm.data.intermediate.IntermediateImportedComplexType <em>Imported Complex Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Imported Complex Type</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateImportedComplexType
     * @generated
     */
    EClass getIntermediateImportedComplexType();

    /**
     * Returns the meta object for the reference '{@link de.fhdo.ddmm.data.intermediate.IntermediateImportedComplexType#getImport <em>Import</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Import</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateImportedComplexType#getImport()
     * @see #getIntermediateImportedComplexType()
     * @generated
     */
    EReference getIntermediateImportedComplexType_Import();

    /**
     * Returns the meta object for class '{@link de.fhdo.ddmm.data.intermediate.IntermediateDataStructure <em>Data Structure</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Structure</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateDataStructure
     * @generated
     */
    EClass getIntermediateDataStructure();

    /**
     * Returns the meta object for the reference '{@link de.fhdo.ddmm.data.intermediate.IntermediateDataStructure#getSuper <em>Super</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Super</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateDataStructure#getSuper()
     * @see #getIntermediateDataStructure()
     * @generated
     */
    EReference getIntermediateDataStructure_Super();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.ddmm.data.intermediate.IntermediateDataStructure#getDataFields <em>Data Fields</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Data Fields</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateDataStructure#getDataFields()
     * @see #getIntermediateDataStructure()
     * @generated
     */
    EReference getIntermediateDataStructure_DataFields();

    /**
     * Returns the meta object for class '{@link de.fhdo.ddmm.data.intermediate.IntermediateListType <em>List Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>List Type</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateListType
     * @generated
     */
    EClass getIntermediateListType();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.ddmm.data.intermediate.IntermediateListType#isPrimitiveList <em>Primitive List</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Primitive List</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateListType#isPrimitiveList()
     * @see #getIntermediateListType()
     * @generated
     */
    EAttribute getIntermediateListType_PrimitiveList();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.ddmm.data.intermediate.IntermediateListType#isStructuredList <em>Structured List</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Structured List</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateListType#isStructuredList()
     * @see #getIntermediateListType()
     * @generated
     */
    EAttribute getIntermediateListType_StructuredList();

    /**
     * Returns the meta object for the containment reference '{@link de.fhdo.ddmm.data.intermediate.IntermediateListType#getPrimitiveType <em>Primitive Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Primitive Type</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateListType#getPrimitiveType()
     * @see #getIntermediateListType()
     * @generated
     */
    EReference getIntermediateListType_PrimitiveType();

    /**
     * Returns the meta object for the containment reference list '{@link de.fhdo.ddmm.data.intermediate.IntermediateListType#getDataFields <em>Data Fields</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Data Fields</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateListType#getDataFields()
     * @see #getIntermediateListType()
     * @generated
     */
    EReference getIntermediateListType_DataFields();

    /**
     * Returns the meta object for class '{@link de.fhdo.ddmm.data.intermediate.IntermediateDataField <em>Data Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Field</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateDataField
     * @generated
     */
    EClass getIntermediateDataField();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.ddmm.data.intermediate.IntermediateDataField#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateDataField#getName()
     * @see #getIntermediateDataField()
     * @generated
     */
    EAttribute getIntermediateDataField_Name();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.ddmm.data.intermediate.IntermediateDataField#getQualifiedName <em>Qualified Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Qualified Name</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateDataField#getQualifiedName()
     * @see #getIntermediateDataField()
     * @generated
     */
    EAttribute getIntermediateDataField_QualifiedName();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.ddmm.data.intermediate.IntermediateDataField#isHidden <em>Hidden</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Hidden</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateDataField#isHidden()
     * @see #getIntermediateDataField()
     * @generated
     */
    EAttribute getIntermediateDataField_Hidden();

    /**
     * Returns the meta object for the attribute '{@link de.fhdo.ddmm.data.intermediate.IntermediateDataField#isDerived <em>Derived</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Derived</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateDataField#isDerived()
     * @see #getIntermediateDataField()
     * @generated
     */
    EAttribute getIntermediateDataField_Derived();

    /**
     * Returns the meta object for the containment reference '{@link de.fhdo.ddmm.data.intermediate.IntermediateDataField#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Type</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateDataField#getType()
     * @see #getIntermediateDataField()
     * @generated
     */
    EReference getIntermediateDataField_Type();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.ddmm.data.intermediate.IntermediateDataField#getDataStructure <em>Data Structure</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Data Structure</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateDataField#getDataStructure()
     * @see #getIntermediateDataField()
     * @generated
     */
    EReference getIntermediateDataField_DataStructure();

    /**
     * Returns the meta object for the container reference '{@link de.fhdo.ddmm.data.intermediate.IntermediateDataField#getListType <em>List Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>List Type</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateDataField#getListType()
     * @see #getIntermediateDataField()
     * @generated
     */
    EReference getIntermediateDataField_ListType();

    /**
     * Returns the meta object for enum '{@link de.fhdo.ddmm.data.intermediate.IntermediateTypeKind <em>Type Kind</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Type Kind</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateTypeKind
     * @generated
     */
    EEnum getIntermediateTypeKind();

    /**
     * Returns the meta object for enum '{@link de.fhdo.ddmm.data.intermediate.IntermediateTypeOrigin <em>Type Origin</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Type Origin</em>'.
     * @see de.fhdo.ddmm.data.intermediate.IntermediateTypeOrigin
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
         * The meta object literal for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateDataModelImpl <em>Data Model</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediateDataModelImpl
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateDataModel()
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
         * The meta object literal for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateImportImpl <em>Import</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediateImportImpl
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateImport()
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
         * The meta object literal for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateVersionImpl <em>Version</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediateVersionImpl
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateVersion()
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
         * The meta object literal for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateContextImpl <em>Context</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediateContextImpl
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateContext()
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
         * The meta object literal for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateTypeImpl <em>Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediateTypeImpl
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateType()
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
         * The meta object literal for the '<em><b>Data Field</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_TYPE__DATA_FIELD = eINSTANCE.getIntermediateType_DataField();

        /**
         * The meta object literal for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediatePrimitiveTypeImpl <em>Primitive Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePrimitiveTypeImpl
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediatePrimitiveType()
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
         * The meta object literal for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateComplexTypeImpl <em>Complex Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediateComplexTypeImpl
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateComplexType()
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
         * The meta object literal for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateImportedComplexTypeImpl <em>Imported Complex Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediateImportedComplexTypeImpl
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateImportedComplexType()
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
         * The meta object literal for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateDataStructureImpl <em>Data Structure</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediateDataStructureImpl
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateDataStructure()
         * @generated
         */
        EClass INTERMEDIATE_DATA_STRUCTURE = eINSTANCE.getIntermediateDataStructure();

        /**
         * The meta object literal for the '<em><b>Super</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_DATA_STRUCTURE__SUPER = eINSTANCE.getIntermediateDataStructure_Super();

        /**
         * The meta object literal for the '<em><b>Data Fields</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_DATA_STRUCTURE__DATA_FIELDS = eINSTANCE.getIntermediateDataStructure_DataFields();

        /**
         * The meta object literal for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateListTypeImpl <em>List Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediateListTypeImpl
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateListType()
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
         * The meta object literal for the '{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateDataFieldImpl <em>Data Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediateDataFieldImpl
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateDataField()
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
         * The meta object literal for the '<em><b>Derived</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTERMEDIATE_DATA_FIELD__DERIVED = eINSTANCE.getIntermediateDataField_Derived();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INTERMEDIATE_DATA_FIELD__TYPE = eINSTANCE.getIntermediateDataField_Type();

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
         * The meta object literal for the '{@link de.fhdo.ddmm.data.intermediate.IntermediateTypeKind <em>Type Kind</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.ddmm.data.intermediate.IntermediateTypeKind
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateTypeKind()
         * @generated
         */
        EEnum INTERMEDIATE_TYPE_KIND = eINSTANCE.getIntermediateTypeKind();

        /**
         * The meta object literal for the '{@link de.fhdo.ddmm.data.intermediate.IntermediateTypeOrigin <em>Type Origin</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.fhdo.ddmm.data.intermediate.IntermediateTypeOrigin
         * @see de.fhdo.ddmm.data.intermediate.impl.IntermediatePackageImpl#getIntermediateTypeOrigin()
         * @generated
         */
        EEnum INTERMEDIATE_TYPE_ORIGIN = eINSTANCE.getIntermediateTypeOrigin();

    }

} //IntermediatePackage
