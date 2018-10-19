/**
 */
package de.fhdo.ddmm.data.intermediate.impl;

import de.fhdo.ddmm.data.intermediate.IntermediateComplexType;
import de.fhdo.ddmm.data.intermediate.IntermediateContext;
import de.fhdo.ddmm.data.intermediate.IntermediateDataField;
import de.fhdo.ddmm.data.intermediate.IntermediateDataModel;
import de.fhdo.ddmm.data.intermediate.IntermediateDataStructure;
import de.fhdo.ddmm.data.intermediate.IntermediateFactory;
import de.fhdo.ddmm.data.intermediate.IntermediateImport;
import de.fhdo.ddmm.data.intermediate.IntermediateImportedComplexType;
import de.fhdo.ddmm.data.intermediate.IntermediateListType;
import de.fhdo.ddmm.data.intermediate.IntermediatePackage;
import de.fhdo.ddmm.data.intermediate.IntermediatePrimitiveType;
import de.fhdo.ddmm.data.intermediate.IntermediateType;
import de.fhdo.ddmm.data.intermediate.IntermediateTypeKind;
import de.fhdo.ddmm.data.intermediate.IntermediateTypeOrigin;
import de.fhdo.ddmm.data.intermediate.IntermediateVersion;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IntermediatePackageImpl extends EPackageImpl implements IntermediatePackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateDataModelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateImportEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateVersionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateContextEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediatePrimitiveTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateComplexTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateImportedComplexTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateDataStructureEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateListTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateDataFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum intermediateTypeKindEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum intermediateTypeOriginEEnum = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see de.fhdo.ddmm.data.intermediate.IntermediatePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private IntermediatePackageImpl() {
        super(eNS_URI, IntermediateFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link IntermediatePackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static IntermediatePackage init() {
        if (isInited) return (IntermediatePackage)EPackage.Registry.INSTANCE.getEPackage(IntermediatePackage.eNS_URI);

        // Obtain or create and register package
        IntermediatePackageImpl theIntermediatePackage = (IntermediatePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof IntermediatePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new IntermediatePackageImpl());

        isInited = true;

        // Initialize simple dependencies
        EcorePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theIntermediatePackage.createPackageContents();

        // Initialize created meta-data
        theIntermediatePackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theIntermediatePackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(IntermediatePackage.eNS_URI, theIntermediatePackage);
        return theIntermediatePackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateDataModel() {
        return intermediateDataModelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataModel_Imports() {
        return (EReference)intermediateDataModelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataModel_Versions() {
        return (EReference)intermediateDataModelEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataModel_Contexts() {
        return (EReference)intermediateDataModelEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataModel_ComplexTypes() {
        return (EReference)intermediateDataModelEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateImport() {
        return intermediateImportEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateImport_Name() {
        return (EAttribute)intermediateImportEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateImport_ImportUri() {
        return (EAttribute)intermediateImportEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateImport_ImportTypeName() {
        return (EAttribute)intermediateImportEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateImport_DataModel() {
        return (EReference)intermediateImportEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateImport_ImportTypeNameForDatatypes() {
        return (EAttribute)intermediateImportEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateVersion() {
        return intermediateVersionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateVersion_Name() {
        return (EAttribute)intermediateVersionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateVersion_ComplexTypes() {
        return (EReference)intermediateVersionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateVersion_Contexts() {
        return (EReference)intermediateVersionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateVersion_DataModel() {
        return (EReference)intermediateVersionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateContext() {
        return intermediateContextEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateContext_Name() {
        return (EAttribute)intermediateContextEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateContext_QualifiedName() {
        return (EAttribute)intermediateContextEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateContext_ComplexTypes() {
        return (EReference)intermediateContextEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateContext_DataModel() {
        return (EReference)intermediateContextEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateContext_Version() {
        return (EReference)intermediateContextEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateType() {
        return intermediateTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateType_Name() {
        return (EAttribute)intermediateTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateType_Origin() {
        return (EAttribute)intermediateTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateType_Kind() {
        return (EAttribute)intermediateTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateType_DataField() {
        return (EReference)intermediateTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediatePrimitiveType() {
        return intermediatePrimitiveTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediatePrimitiveType_Size() {
        return (EAttribute)intermediatePrimitiveTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateComplexType() {
        return intermediateComplexTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateComplexType_QualifiedName() {
        return (EAttribute)intermediateComplexTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateComplexType_DataModel() {
        return (EReference)intermediateComplexTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateComplexType_Version() {
        return (EReference)intermediateComplexTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateComplexType_Context() {
        return (EReference)intermediateComplexTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateImportedComplexType() {
        return intermediateImportedComplexTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateImportedComplexType_Import() {
        return (EReference)intermediateImportedComplexTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateDataStructure() {
        return intermediateDataStructureEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataStructure_Super() {
        return (EReference)intermediateDataStructureEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataStructure_DataFields() {
        return (EReference)intermediateDataStructureEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateListType() {
        return intermediateListTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateListType_PrimitiveList() {
        return (EAttribute)intermediateListTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateListType_StructuredList() {
        return (EAttribute)intermediateListTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateListType_PrimitiveType() {
        return (EReference)intermediateListTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateListType_DataFields() {
        return (EReference)intermediateListTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateDataField() {
        return intermediateDataFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateDataField_Name() {
        return (EAttribute)intermediateDataFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateDataField_QualifiedName() {
        return (EAttribute)intermediateDataFieldEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateDataField_Hidden() {
        return (EAttribute)intermediateDataFieldEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateDataField_Derived() {
        return (EAttribute)intermediateDataFieldEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataField_Type() {
        return (EReference)intermediateDataFieldEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataField_DataStructure() {
        return (EReference)intermediateDataFieldEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataField_ListType() {
        return (EReference)intermediateDataFieldEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getIntermediateTypeKind() {
        return intermediateTypeKindEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getIntermediateTypeOrigin() {
        return intermediateTypeOriginEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateFactory getIntermediateFactory() {
        return (IntermediateFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        intermediateDataModelEClass = createEClass(INTERMEDIATE_DATA_MODEL);
        createEReference(intermediateDataModelEClass, INTERMEDIATE_DATA_MODEL__IMPORTS);
        createEReference(intermediateDataModelEClass, INTERMEDIATE_DATA_MODEL__VERSIONS);
        createEReference(intermediateDataModelEClass, INTERMEDIATE_DATA_MODEL__CONTEXTS);
        createEReference(intermediateDataModelEClass, INTERMEDIATE_DATA_MODEL__COMPLEX_TYPES);

        intermediateImportEClass = createEClass(INTERMEDIATE_IMPORT);
        createEAttribute(intermediateImportEClass, INTERMEDIATE_IMPORT__NAME);
        createEAttribute(intermediateImportEClass, INTERMEDIATE_IMPORT__IMPORT_URI);
        createEAttribute(intermediateImportEClass, INTERMEDIATE_IMPORT__IMPORT_TYPE_NAME);
        createEReference(intermediateImportEClass, INTERMEDIATE_IMPORT__DATA_MODEL);
        createEAttribute(intermediateImportEClass, INTERMEDIATE_IMPORT__IMPORT_TYPE_NAME_FOR_DATATYPES);

        intermediateVersionEClass = createEClass(INTERMEDIATE_VERSION);
        createEAttribute(intermediateVersionEClass, INTERMEDIATE_VERSION__NAME);
        createEReference(intermediateVersionEClass, INTERMEDIATE_VERSION__COMPLEX_TYPES);
        createEReference(intermediateVersionEClass, INTERMEDIATE_VERSION__CONTEXTS);
        createEReference(intermediateVersionEClass, INTERMEDIATE_VERSION__DATA_MODEL);

        intermediateContextEClass = createEClass(INTERMEDIATE_CONTEXT);
        createEAttribute(intermediateContextEClass, INTERMEDIATE_CONTEXT__NAME);
        createEAttribute(intermediateContextEClass, INTERMEDIATE_CONTEXT__QUALIFIED_NAME);
        createEReference(intermediateContextEClass, INTERMEDIATE_CONTEXT__COMPLEX_TYPES);
        createEReference(intermediateContextEClass, INTERMEDIATE_CONTEXT__DATA_MODEL);
        createEReference(intermediateContextEClass, INTERMEDIATE_CONTEXT__VERSION);

        intermediateTypeEClass = createEClass(INTERMEDIATE_TYPE);
        createEAttribute(intermediateTypeEClass, INTERMEDIATE_TYPE__NAME);
        createEAttribute(intermediateTypeEClass, INTERMEDIATE_TYPE__ORIGIN);
        createEAttribute(intermediateTypeEClass, INTERMEDIATE_TYPE__KIND);
        createEReference(intermediateTypeEClass, INTERMEDIATE_TYPE__DATA_FIELD);

        intermediatePrimitiveTypeEClass = createEClass(INTERMEDIATE_PRIMITIVE_TYPE);
        createEAttribute(intermediatePrimitiveTypeEClass, INTERMEDIATE_PRIMITIVE_TYPE__SIZE);

        intermediateComplexTypeEClass = createEClass(INTERMEDIATE_COMPLEX_TYPE);
        createEAttribute(intermediateComplexTypeEClass, INTERMEDIATE_COMPLEX_TYPE__QUALIFIED_NAME);
        createEReference(intermediateComplexTypeEClass, INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL);
        createEReference(intermediateComplexTypeEClass, INTERMEDIATE_COMPLEX_TYPE__VERSION);
        createEReference(intermediateComplexTypeEClass, INTERMEDIATE_COMPLEX_TYPE__CONTEXT);

        intermediateImportedComplexTypeEClass = createEClass(INTERMEDIATE_IMPORTED_COMPLEX_TYPE);
        createEReference(intermediateImportedComplexTypeEClass, INTERMEDIATE_IMPORTED_COMPLEX_TYPE__IMPORT);

        intermediateDataStructureEClass = createEClass(INTERMEDIATE_DATA_STRUCTURE);
        createEReference(intermediateDataStructureEClass, INTERMEDIATE_DATA_STRUCTURE__SUPER);
        createEReference(intermediateDataStructureEClass, INTERMEDIATE_DATA_STRUCTURE__DATA_FIELDS);

        intermediateListTypeEClass = createEClass(INTERMEDIATE_LIST_TYPE);
        createEAttribute(intermediateListTypeEClass, INTERMEDIATE_LIST_TYPE__PRIMITIVE_LIST);
        createEAttribute(intermediateListTypeEClass, INTERMEDIATE_LIST_TYPE__STRUCTURED_LIST);
        createEReference(intermediateListTypeEClass, INTERMEDIATE_LIST_TYPE__PRIMITIVE_TYPE);
        createEReference(intermediateListTypeEClass, INTERMEDIATE_LIST_TYPE__DATA_FIELDS);

        intermediateDataFieldEClass = createEClass(INTERMEDIATE_DATA_FIELD);
        createEAttribute(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD__NAME);
        createEAttribute(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD__QUALIFIED_NAME);
        createEAttribute(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD__HIDDEN);
        createEAttribute(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD__DERIVED);
        createEReference(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD__TYPE);
        createEReference(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD__DATA_STRUCTURE);
        createEReference(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD__LIST_TYPE);

        // Create enums
        intermediateTypeKindEEnum = createEEnum(INTERMEDIATE_TYPE_KIND);
        intermediateTypeOriginEEnum = createEEnum(INTERMEDIATE_TYPE_ORIGIN);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        intermediatePrimitiveTypeEClass.getESuperTypes().add(this.getIntermediateType());
        intermediateComplexTypeEClass.getESuperTypes().add(this.getIntermediateType());
        intermediateImportedComplexTypeEClass.getESuperTypes().add(this.getIntermediateComplexType());
        intermediateDataStructureEClass.getESuperTypes().add(this.getIntermediateComplexType());
        intermediateListTypeEClass.getESuperTypes().add(this.getIntermediateComplexType());

        // Initialize classes, features, and operations; add parameters
        initEClass(intermediateDataModelEClass, IntermediateDataModel.class, "IntermediateDataModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getIntermediateDataModel_Imports(), this.getIntermediateImport(), this.getIntermediateImport_DataModel(), "imports", null, 0, -1, IntermediateDataModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataModel_Versions(), this.getIntermediateVersion(), this.getIntermediateVersion_DataModel(), "versions", null, 0, -1, IntermediateDataModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataModel_Contexts(), this.getIntermediateContext(), this.getIntermediateContext_DataModel(), "contexts", null, 0, -1, IntermediateDataModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataModel_ComplexTypes(), this.getIntermediateComplexType(), this.getIntermediateComplexType_DataModel(), "complexTypes", null, 0, -1, IntermediateDataModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateImportEClass, IntermediateImport.class, "IntermediateImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateImport_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateImport_ImportUri(), theEcorePackage.getEString(), "importUri", null, 0, 1, IntermediateImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateImport_ImportTypeName(), theEcorePackage.getEString(), "importTypeName", null, 0, 1, IntermediateImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateImport_DataModel(), this.getIntermediateDataModel(), this.getIntermediateDataModel_Imports(), "dataModel", null, 0, 1, IntermediateImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateImport_ImportTypeNameForDatatypes(), theEcorePackage.getEString(), "importTypeNameForDatatypes", null, 0, 1, IntermediateImport.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(intermediateVersionEClass, IntermediateVersion.class, "IntermediateVersion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateVersion_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateVersion_ComplexTypes(), this.getIntermediateComplexType(), this.getIntermediateComplexType_Version(), "complexTypes", null, 0, -1, IntermediateVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateVersion_Contexts(), this.getIntermediateContext(), this.getIntermediateContext_Version(), "contexts", null, 0, -1, IntermediateVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateVersion_DataModel(), this.getIntermediateDataModel(), this.getIntermediateDataModel_Versions(), "dataModel", null, 0, 1, IntermediateVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateContextEClass, IntermediateContext.class, "IntermediateContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateContext_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateContext_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, IntermediateContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateContext_ComplexTypes(), this.getIntermediateComplexType(), this.getIntermediateComplexType_Context(), "complexTypes", null, 1, -1, IntermediateContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateContext_DataModel(), this.getIntermediateDataModel(), this.getIntermediateDataModel_Contexts(), "dataModel", null, 0, 1, IntermediateContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateContext_Version(), this.getIntermediateVersion(), this.getIntermediateVersion_Contexts(), "version", null, 0, 1, IntermediateContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateTypeEClass, IntermediateType.class, "IntermediateType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateType_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateType_Origin(), this.getIntermediateTypeOrigin(), "origin", null, 0, 1, IntermediateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateType_Kind(), this.getIntermediateTypeKind(), "kind", null, 0, 1, IntermediateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateType_DataField(), this.getIntermediateDataField(), this.getIntermediateDataField_Type(), "dataField", null, 0, 1, IntermediateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediatePrimitiveTypeEClass, IntermediatePrimitiveType.class, "IntermediatePrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediatePrimitiveType_Size(), theEcorePackage.getEIntegerObject(), "size", null, 0, 1, IntermediatePrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateComplexTypeEClass, IntermediateComplexType.class, "IntermediateComplexType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateComplexType_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, IntermediateComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateComplexType_DataModel(), this.getIntermediateDataModel(), this.getIntermediateDataModel_ComplexTypes(), "dataModel", null, 0, 1, IntermediateComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateComplexType_Version(), this.getIntermediateVersion(), this.getIntermediateVersion_ComplexTypes(), "version", null, 0, 1, IntermediateComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateComplexType_Context(), this.getIntermediateContext(), this.getIntermediateContext_ComplexTypes(), "context", null, 0, 1, IntermediateComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateImportedComplexTypeEClass, IntermediateImportedComplexType.class, "IntermediateImportedComplexType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getIntermediateImportedComplexType_Import(), this.getIntermediateImport(), null, "import", null, 0, 1, IntermediateImportedComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateDataStructureEClass, IntermediateDataStructure.class, "IntermediateDataStructure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getIntermediateDataStructure_Super(), this.getIntermediateDataStructure(), null, "super", null, 0, 1, IntermediateDataStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataStructure_DataFields(), this.getIntermediateDataField(), this.getIntermediateDataField_DataStructure(), "dataFields", null, 0, -1, IntermediateDataStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateListTypeEClass, IntermediateListType.class, "IntermediateListType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateListType_PrimitiveList(), theEcorePackage.getEBoolean(), "primitiveList", null, 0, 1, IntermediateListType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateListType_StructuredList(), theEcorePackage.getEBoolean(), "structuredList", null, 0, 1, IntermediateListType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateListType_PrimitiveType(), this.getIntermediatePrimitiveType(), null, "primitiveType", null, 0, 1, IntermediateListType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateListType_DataFields(), this.getIntermediateDataField(), this.getIntermediateDataField_ListType(), "dataFields", null, 0, -1, IntermediateListType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateDataFieldEClass, IntermediateDataField.class, "IntermediateDataField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateDataField_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateDataField_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, IntermediateDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateDataField_Hidden(), theEcorePackage.getEBoolean(), "hidden", null, 0, 1, IntermediateDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateDataField_Derived(), theEcorePackage.getEBoolean(), "derived", null, 0, 1, IntermediateDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataField_Type(), this.getIntermediateType(), this.getIntermediateType_DataField(), "type", null, 0, 1, IntermediateDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataField_DataStructure(), this.getIntermediateDataStructure(), this.getIntermediateDataStructure_DataFields(), "dataStructure", null, 0, 1, IntermediateDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataField_ListType(), this.getIntermediateListType(), this.getIntermediateListType_DataFields(), "listType", null, 0, 1, IntermediateDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(intermediateTypeKindEEnum, IntermediateTypeKind.class, "IntermediateTypeKind");
        addEEnumLiteral(intermediateTypeKindEEnum, IntermediateTypeKind.DUMMY_FOR_XMI_SERIALIZER_BUG);
        addEEnumLiteral(intermediateTypeKindEEnum, IntermediateTypeKind.LIST);
        addEEnumLiteral(intermediateTypeKindEEnum, IntermediateTypeKind.PRIMITIVE);
        addEEnumLiteral(intermediateTypeKindEEnum, IntermediateTypeKind.STRUCTURE);

        initEEnum(intermediateTypeOriginEEnum, IntermediateTypeOrigin.class, "IntermediateTypeOrigin");
        addEEnumLiteral(intermediateTypeOriginEEnum, IntermediateTypeOrigin.DUMMY_FOR_XMI_SERIALIZER_BUG);
        addEEnumLiteral(intermediateTypeOriginEEnum, IntermediateTypeOrigin.DATA_MODEL);
        addEEnumLiteral(intermediateTypeOriginEEnum, IntermediateTypeOrigin.BUILTIN);
        addEEnumLiteral(intermediateTypeOriginEEnum, IntermediateTypeOrigin.TECHNOLOGY);

        // Create resource
        createResource(eNS_URI);
    }

} //IntermediatePackageImpl
