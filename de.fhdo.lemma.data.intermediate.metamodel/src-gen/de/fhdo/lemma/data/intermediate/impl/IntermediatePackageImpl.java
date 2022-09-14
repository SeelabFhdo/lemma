/**
 */
package de.fhdo.lemma.data.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateAspectProperty;
import de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue;
import de.fhdo.lemma.data.intermediate.IntermediateCollectionType;
import de.fhdo.lemma.data.intermediate.IntermediateComplexType;
import de.fhdo.lemma.data.intermediate.IntermediateContext;
import de.fhdo.lemma.data.intermediate.IntermediateDataField;
import de.fhdo.lemma.data.intermediate.IntermediateDataModel;
import de.fhdo.lemma.data.intermediate.IntermediateDataOperation;
import de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter;
import de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType;
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure;
import de.fhdo.lemma.data.intermediate.IntermediateEnumeration;
import de.fhdo.lemma.data.intermediate.IntermediateEnumerationField;
import de.fhdo.lemma.data.intermediate.IntermediateFactory;
import de.fhdo.lemma.data.intermediate.IntermediateImport;
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect;
import de.fhdo.lemma.data.intermediate.IntermediateImportedComplexType;
import de.fhdo.lemma.data.intermediate.IntermediateImportedTechnologySpecificType;
import de.fhdo.lemma.data.intermediate.IntermediatePackage;
import de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType;
import de.fhdo.lemma.data.intermediate.IntermediateType;
import de.fhdo.lemma.data.intermediate.IntermediateTypeKind;
import de.fhdo.lemma.data.intermediate.IntermediateTypeOrigin;
import de.fhdo.lemma.data.intermediate.IntermediateVersion;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
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
    private EClass intermediateImportedTechnologySpecificTypeEClass = null;

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
    private EClass intermediateDataOperationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateDataOperationReturnTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateDataOperationParameterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateCollectionTypeEClass = null;

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
    private EClass intermediateEnumerationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateEnumerationFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateImportedAspectEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateAspectPropertyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateAspectPropertyValueEClass = null;

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType effectivePropertyValuesMapEDataType = null;

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
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#eNS_URI
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
        Object registeredIntermediatePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        IntermediatePackageImpl theIntermediatePackage = registeredIntermediatePackage instanceof IntermediatePackageImpl ? (IntermediatePackageImpl)registeredIntermediatePackage : new IntermediatePackageImpl();

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
    public EAttribute getIntermediateDataModel_SourceModelUri() {
        return (EAttribute)intermediateDataModelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataModel_Imports() {
        return (EReference)intermediateDataModelEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataModel_Versions() {
        return (EReference)intermediateDataModelEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataModel_Contexts() {
        return (EReference)intermediateDataModelEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataModel_ComplexTypes() {
        return (EReference)intermediateDataModelEClass.getEStructuralFeatures().get(4);
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
    public EReference getIntermediateType_ReturnType() {
        return (EReference)intermediateTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateType_Parameter() {
        return (EReference)intermediateTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateType_DataField() {
        return (EReference)intermediateTypeEClass.getEStructuralFeatures().get(5);
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
    public EReference getIntermediatePrimitiveType_InitializedDataField() {
        return (EReference)intermediatePrimitiveTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediatePrimitiveType_InitializedEnumerationField() {
        return (EReference)intermediatePrimitiveTypeEClass.getEStructuralFeatures().get(2);
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
    public EReference getIntermediateComplexType_Aspects() {
        return (EReference)intermediateComplexTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateComplexType_DataModel() {
        return (EReference)intermediateComplexTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateComplexType_Version() {
        return (EReference)intermediateComplexTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateComplexType_Context() {
        return (EReference)intermediateComplexTypeEClass.getEStructuralFeatures().get(4);
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
    public EClass getIntermediateImportedTechnologySpecificType() {
        return intermediateImportedTechnologySpecificTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateImportedTechnologySpecificType_QualifiedName() {
        return (EAttribute)intermediateImportedTechnologySpecificTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateImportedTechnologySpecificType_Import() {
        return (EReference)intermediateImportedTechnologySpecificTypeEClass.getEStructuralFeatures().get(1);
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
    public EAttribute getIntermediateDataStructure_FeatureNames() {
        return (EAttribute)intermediateDataStructureEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataStructure_Super() {
        return (EReference)intermediateDataStructureEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataStructure_Operations() {
        return (EReference)intermediateDataStructureEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataStructure_DataFields() {
        return (EReference)intermediateDataStructureEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateDataOperation() {
        return intermediateDataOperationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateDataOperation_Name() {
        return (EAttribute)intermediateDataOperationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateDataOperation_QualifiedName() {
        return (EAttribute)intermediateDataOperationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateDataOperation_Hidden() {
        return (EAttribute)intermediateDataOperationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateDataOperation_Inherited() {
        return (EAttribute)intermediateDataOperationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateDataOperation_FeatureNames() {
        return (EAttribute)intermediateDataOperationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataOperation_ReturnType() {
        return (EReference)intermediateDataOperationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataOperation_Parameters() {
        return (EReference)intermediateDataOperationEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataOperation_Aspects() {
        return (EReference)intermediateDataOperationEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataOperation_DataStructure() {
        return (EReference)intermediateDataOperationEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateDataOperationReturnType() {
        return intermediateDataOperationReturnTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataOperationReturnType_Type() {
        return (EReference)intermediateDataOperationReturnTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataOperationReturnType_OriginalType() {
        return (EReference)intermediateDataOperationReturnTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataOperationReturnType_Aspects() {
        return (EReference)intermediateDataOperationReturnTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataOperationReturnType_Operation() {
        return (EReference)intermediateDataOperationReturnTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateDataOperationParameter() {
        return intermediateDataOperationParameterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateDataOperationParameter_Name() {
        return (EAttribute)intermediateDataOperationParameterEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateDataOperationParameter_QualifiedName() {
        return (EAttribute)intermediateDataOperationParameterEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataOperationParameter_Type() {
        return (EReference)intermediateDataOperationParameterEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataOperationParameter_OriginalType() {
        return (EReference)intermediateDataOperationParameterEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataOperationParameter_Aspects() {
        return (EReference)intermediateDataOperationParameterEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataOperationParameter_Operation() {
        return (EReference)intermediateDataOperationParameterEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateCollectionType() {
        return intermediateCollectionTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateCollectionType_PrimitiveCollection() {
        return (EAttribute)intermediateCollectionTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateCollectionType_StructuredCollection() {
        return (EAttribute)intermediateCollectionTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateCollectionType_PrimitiveType() {
        return (EReference)intermediateCollectionTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateCollectionType_DataFields() {
        return (EReference)intermediateCollectionTypeEClass.getEStructuralFeatures().get(3);
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
    public EAttribute getIntermediateDataField_Immutable() {
        return (EAttribute)intermediateDataFieldEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateDataField_Inherited() {
        return (EAttribute)intermediateDataFieldEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateDataField_FeatureNames() {
        return (EAttribute)intermediateDataFieldEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateDataField_InitializationValue() {
        return (EAttribute)intermediateDataFieldEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataField_InitializationValueCompatibleTypes() {
        return (EReference)intermediateDataFieldEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataField_Type() {
        return (EReference)intermediateDataFieldEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataField_OriginalType() {
        return (EReference)intermediateDataFieldEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataField_Aspects() {
        return (EReference)intermediateDataFieldEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataField_DataStructure() {
        return (EReference)intermediateDataFieldEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateDataField_CollectionType() {
        return (EReference)intermediateDataFieldEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getIntermediateDataField__GetEffectiveComplexType() {
        return intermediateDataFieldEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateEnumeration() {
        return intermediateEnumerationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateEnumeration_FeatureNames() {
        return (EAttribute)intermediateEnumerationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateEnumeration_Fields() {
        return (EReference)intermediateEnumerationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateEnumerationField() {
        return intermediateEnumerationFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateEnumerationField_Name() {
        return (EAttribute)intermediateEnumerationFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateEnumerationField_QualifiedName() {
        return (EAttribute)intermediateEnumerationFieldEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateEnumerationField_InitializationValue() {
        return (EAttribute)intermediateEnumerationFieldEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateEnumerationField_InitializationValueCompatibleTypes() {
        return (EReference)intermediateEnumerationFieldEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateEnumerationField_Enumeration() {
        return (EReference)intermediateEnumerationFieldEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateImportedAspect() {
        return intermediateImportedAspectEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateImportedAspect_Name() {
        return (EAttribute)intermediateImportedAspectEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateImportedAspect_QualifiedName() {
        return (EAttribute)intermediateImportedAspectEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateImportedAspect_FeatureNames() {
        return (EAttribute)intermediateImportedAspectEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateImportedAspect_Import() {
        return (EReference)intermediateImportedAspectEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateImportedAspect_Properties() {
        return (EReference)intermediateImportedAspectEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateImportedAspect_PropertyValues() {
        return (EReference)intermediateImportedAspectEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateImportedAspect_ComplexType() {
        return (EReference)intermediateImportedAspectEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateImportedAspect_Operation() {
        return (EReference)intermediateImportedAspectEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateImportedAspect_ReturnType() {
        return (EReference)intermediateImportedAspectEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateImportedAspect_Parameter() {
        return (EReference)intermediateImportedAspectEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateImportedAspect_DataField() {
        return (EReference)intermediateImportedAspectEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getIntermediateImportedAspect__GetEffectivePropertyValues() {
        return intermediateImportedAspectEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateAspectProperty() {
        return intermediateAspectPropertyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateAspectProperty_Name() {
        return (EAttribute)intermediateAspectPropertyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateAspectProperty_Type() {
        return (EAttribute)intermediateAspectPropertyEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateAspectProperty_DefaultValue() {
        return (EAttribute)intermediateAspectPropertyEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateAspectProperty_FeatureNames() {
        return (EAttribute)intermediateAspectPropertyEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateAspectProperty_Aspect() {
        return (EReference)intermediateAspectPropertyEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateAspectPropertyValue() {
        return intermediateAspectPropertyValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateAspectPropertyValue_Value() {
        return (EAttribute)intermediateAspectPropertyValueEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateAspectPropertyValue_Property() {
        return (EReference)intermediateAspectPropertyValueEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateAspectPropertyValue_Aspect() {
        return (EReference)intermediateAspectPropertyValueEClass.getEStructuralFeatures().get(2);
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
    public EDataType getEffectivePropertyValuesMap() {
        return effectivePropertyValuesMapEDataType;
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
        createEAttribute(intermediateDataModelEClass, INTERMEDIATE_DATA_MODEL__SOURCE_MODEL_URI);
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
        createEReference(intermediateTypeEClass, INTERMEDIATE_TYPE__RETURN_TYPE);
        createEReference(intermediateTypeEClass, INTERMEDIATE_TYPE__PARAMETER);
        createEReference(intermediateTypeEClass, INTERMEDIATE_TYPE__DATA_FIELD);

        intermediatePrimitiveTypeEClass = createEClass(INTERMEDIATE_PRIMITIVE_TYPE);
        createEAttribute(intermediatePrimitiveTypeEClass, INTERMEDIATE_PRIMITIVE_TYPE__SIZE);
        createEReference(intermediatePrimitiveTypeEClass, INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_DATA_FIELD);
        createEReference(intermediatePrimitiveTypeEClass, INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_ENUMERATION_FIELD);

        intermediateComplexTypeEClass = createEClass(INTERMEDIATE_COMPLEX_TYPE);
        createEAttribute(intermediateComplexTypeEClass, INTERMEDIATE_COMPLEX_TYPE__QUALIFIED_NAME);
        createEReference(intermediateComplexTypeEClass, INTERMEDIATE_COMPLEX_TYPE__ASPECTS);
        createEReference(intermediateComplexTypeEClass, INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL);
        createEReference(intermediateComplexTypeEClass, INTERMEDIATE_COMPLEX_TYPE__VERSION);
        createEReference(intermediateComplexTypeEClass, INTERMEDIATE_COMPLEX_TYPE__CONTEXT);

        intermediateImportedComplexTypeEClass = createEClass(INTERMEDIATE_IMPORTED_COMPLEX_TYPE);
        createEReference(intermediateImportedComplexTypeEClass, INTERMEDIATE_IMPORTED_COMPLEX_TYPE__IMPORT);

        intermediateImportedTechnologySpecificTypeEClass = createEClass(INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE);
        createEAttribute(intermediateImportedTechnologySpecificTypeEClass, INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__QUALIFIED_NAME);
        createEReference(intermediateImportedTechnologySpecificTypeEClass, INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__IMPORT);

        intermediateDataStructureEClass = createEClass(INTERMEDIATE_DATA_STRUCTURE);
        createEAttribute(intermediateDataStructureEClass, INTERMEDIATE_DATA_STRUCTURE__FEATURE_NAMES);
        createEReference(intermediateDataStructureEClass, INTERMEDIATE_DATA_STRUCTURE__SUPER);
        createEReference(intermediateDataStructureEClass, INTERMEDIATE_DATA_STRUCTURE__OPERATIONS);
        createEReference(intermediateDataStructureEClass, INTERMEDIATE_DATA_STRUCTURE__DATA_FIELDS);

        intermediateDataOperationEClass = createEClass(INTERMEDIATE_DATA_OPERATION);
        createEAttribute(intermediateDataOperationEClass, INTERMEDIATE_DATA_OPERATION__NAME);
        createEAttribute(intermediateDataOperationEClass, INTERMEDIATE_DATA_OPERATION__QUALIFIED_NAME);
        createEAttribute(intermediateDataOperationEClass, INTERMEDIATE_DATA_OPERATION__HIDDEN);
        createEAttribute(intermediateDataOperationEClass, INTERMEDIATE_DATA_OPERATION__INHERITED);
        createEAttribute(intermediateDataOperationEClass, INTERMEDIATE_DATA_OPERATION__FEATURE_NAMES);
        createEReference(intermediateDataOperationEClass, INTERMEDIATE_DATA_OPERATION__RETURN_TYPE);
        createEReference(intermediateDataOperationEClass, INTERMEDIATE_DATA_OPERATION__PARAMETERS);
        createEReference(intermediateDataOperationEClass, INTERMEDIATE_DATA_OPERATION__ASPECTS);
        createEReference(intermediateDataOperationEClass, INTERMEDIATE_DATA_OPERATION__DATA_STRUCTURE);

        intermediateDataOperationReturnTypeEClass = createEClass(INTERMEDIATE_DATA_OPERATION_RETURN_TYPE);
        createEReference(intermediateDataOperationReturnTypeEClass, INTERMEDIATE_DATA_OPERATION_RETURN_TYPE__TYPE);
        createEReference(intermediateDataOperationReturnTypeEClass, INTERMEDIATE_DATA_OPERATION_RETURN_TYPE__ORIGINAL_TYPE);
        createEReference(intermediateDataOperationReturnTypeEClass, INTERMEDIATE_DATA_OPERATION_RETURN_TYPE__ASPECTS);
        createEReference(intermediateDataOperationReturnTypeEClass, INTERMEDIATE_DATA_OPERATION_RETURN_TYPE__OPERATION);

        intermediateDataOperationParameterEClass = createEClass(INTERMEDIATE_DATA_OPERATION_PARAMETER);
        createEAttribute(intermediateDataOperationParameterEClass, INTERMEDIATE_DATA_OPERATION_PARAMETER__NAME);
        createEAttribute(intermediateDataOperationParameterEClass, INTERMEDIATE_DATA_OPERATION_PARAMETER__QUALIFIED_NAME);
        createEReference(intermediateDataOperationParameterEClass, INTERMEDIATE_DATA_OPERATION_PARAMETER__TYPE);
        createEReference(intermediateDataOperationParameterEClass, INTERMEDIATE_DATA_OPERATION_PARAMETER__ORIGINAL_TYPE);
        createEReference(intermediateDataOperationParameterEClass, INTERMEDIATE_DATA_OPERATION_PARAMETER__ASPECTS);
        createEReference(intermediateDataOperationParameterEClass, INTERMEDIATE_DATA_OPERATION_PARAMETER__OPERATION);

        intermediateCollectionTypeEClass = createEClass(INTERMEDIATE_COLLECTION_TYPE);
        createEAttribute(intermediateCollectionTypeEClass, INTERMEDIATE_COLLECTION_TYPE__PRIMITIVE_COLLECTION);
        createEAttribute(intermediateCollectionTypeEClass, INTERMEDIATE_COLLECTION_TYPE__STRUCTURED_COLLECTION);
        createEReference(intermediateCollectionTypeEClass, INTERMEDIATE_COLLECTION_TYPE__PRIMITIVE_TYPE);
        createEReference(intermediateCollectionTypeEClass, INTERMEDIATE_COLLECTION_TYPE__DATA_FIELDS);

        intermediateDataFieldEClass = createEClass(INTERMEDIATE_DATA_FIELD);
        createEAttribute(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD__NAME);
        createEAttribute(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD__QUALIFIED_NAME);
        createEAttribute(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD__HIDDEN);
        createEAttribute(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD__IMMUTABLE);
        createEAttribute(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD__INHERITED);
        createEAttribute(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD__FEATURE_NAMES);
        createEAttribute(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD__INITIALIZATION_VALUE);
        createEReference(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES);
        createEReference(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD__TYPE);
        createEReference(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD__ORIGINAL_TYPE);
        createEReference(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD__ASPECTS);
        createEReference(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD__DATA_STRUCTURE);
        createEReference(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD__COLLECTION_TYPE);
        createEOperation(intermediateDataFieldEClass, INTERMEDIATE_DATA_FIELD___GET_EFFECTIVE_COMPLEX_TYPE);

        intermediateEnumerationEClass = createEClass(INTERMEDIATE_ENUMERATION);
        createEAttribute(intermediateEnumerationEClass, INTERMEDIATE_ENUMERATION__FEATURE_NAMES);
        createEReference(intermediateEnumerationEClass, INTERMEDIATE_ENUMERATION__FIELDS);

        intermediateEnumerationFieldEClass = createEClass(INTERMEDIATE_ENUMERATION_FIELD);
        createEAttribute(intermediateEnumerationFieldEClass, INTERMEDIATE_ENUMERATION_FIELD__NAME);
        createEAttribute(intermediateEnumerationFieldEClass, INTERMEDIATE_ENUMERATION_FIELD__QUALIFIED_NAME);
        createEAttribute(intermediateEnumerationFieldEClass, INTERMEDIATE_ENUMERATION_FIELD__INITIALIZATION_VALUE);
        createEReference(intermediateEnumerationFieldEClass, INTERMEDIATE_ENUMERATION_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES);
        createEReference(intermediateEnumerationFieldEClass, INTERMEDIATE_ENUMERATION_FIELD__ENUMERATION);

        intermediateImportedAspectEClass = createEClass(INTERMEDIATE_IMPORTED_ASPECT);
        createEAttribute(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__NAME);
        createEAttribute(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__QUALIFIED_NAME);
        createEAttribute(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__FEATURE_NAMES);
        createEReference(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__IMPORT);
        createEReference(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__PROPERTIES);
        createEReference(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__PROPERTY_VALUES);
        createEReference(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__COMPLEX_TYPE);
        createEReference(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__OPERATION);
        createEReference(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__RETURN_TYPE);
        createEReference(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__PARAMETER);
        createEReference(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__DATA_FIELD);
        createEOperation(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT___GET_EFFECTIVE_PROPERTY_VALUES);

        intermediateAspectPropertyEClass = createEClass(INTERMEDIATE_ASPECT_PROPERTY);
        createEAttribute(intermediateAspectPropertyEClass, INTERMEDIATE_ASPECT_PROPERTY__NAME);
        createEAttribute(intermediateAspectPropertyEClass, INTERMEDIATE_ASPECT_PROPERTY__TYPE);
        createEAttribute(intermediateAspectPropertyEClass, INTERMEDIATE_ASPECT_PROPERTY__DEFAULT_VALUE);
        createEAttribute(intermediateAspectPropertyEClass, INTERMEDIATE_ASPECT_PROPERTY__FEATURE_NAMES);
        createEReference(intermediateAspectPropertyEClass, INTERMEDIATE_ASPECT_PROPERTY__ASPECT);

        intermediateAspectPropertyValueEClass = createEClass(INTERMEDIATE_ASPECT_PROPERTY_VALUE);
        createEAttribute(intermediateAspectPropertyValueEClass, INTERMEDIATE_ASPECT_PROPERTY_VALUE__VALUE);
        createEReference(intermediateAspectPropertyValueEClass, INTERMEDIATE_ASPECT_PROPERTY_VALUE__PROPERTY);
        createEReference(intermediateAspectPropertyValueEClass, INTERMEDIATE_ASPECT_PROPERTY_VALUE__ASPECT);

        // Create enums
        intermediateTypeKindEEnum = createEEnum(INTERMEDIATE_TYPE_KIND);
        intermediateTypeOriginEEnum = createEEnum(INTERMEDIATE_TYPE_ORIGIN);

        // Create data types
        effectivePropertyValuesMapEDataType = createEDataType(EFFECTIVE_PROPERTY_VALUES_MAP);
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
        intermediateImportedTechnologySpecificTypeEClass.getESuperTypes().add(this.getIntermediateType());
        intermediateDataStructureEClass.getESuperTypes().add(this.getIntermediateComplexType());
        intermediateCollectionTypeEClass.getESuperTypes().add(this.getIntermediateComplexType());
        intermediateEnumerationEClass.getESuperTypes().add(this.getIntermediateComplexType());

        // Initialize classes, features, and operations; add parameters
        initEClass(intermediateDataModelEClass, IntermediateDataModel.class, "IntermediateDataModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateDataModel_SourceModelUri(), theEcorePackage.getEString(), "sourceModelUri", null, 0, 1, IntermediateDataModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
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
        initEReference(getIntermediateType_ReturnType(), this.getIntermediateDataOperationReturnType(), this.getIntermediateDataOperationReturnType_Type(), "returnType", null, 0, 1, IntermediateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateType_Parameter(), this.getIntermediateDataOperationParameter(), this.getIntermediateDataOperationParameter_Type(), "parameter", null, 0, 1, IntermediateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateType_DataField(), this.getIntermediateDataField(), this.getIntermediateDataField_Type(), "dataField", null, 0, 1, IntermediateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediatePrimitiveTypeEClass, IntermediatePrimitiveType.class, "IntermediatePrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediatePrimitiveType_Size(), theEcorePackage.getEIntegerObject(), "size", null, 0, 1, IntermediatePrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediatePrimitiveType_InitializedDataField(), this.getIntermediateDataField(), this.getIntermediateDataField_InitializationValueCompatibleTypes(), "initializedDataField", null, 0, 1, IntermediatePrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediatePrimitiveType_InitializedEnumerationField(), this.getIntermediateEnumerationField(), this.getIntermediateEnumerationField_InitializationValueCompatibleTypes(), "initializedEnumerationField", null, 0, 1, IntermediatePrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateComplexTypeEClass, IntermediateComplexType.class, "IntermediateComplexType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateComplexType_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, IntermediateComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateComplexType_Aspects(), this.getIntermediateImportedAspect(), this.getIntermediateImportedAspect_ComplexType(), "aspects", null, 0, -1, IntermediateComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateComplexType_DataModel(), this.getIntermediateDataModel(), this.getIntermediateDataModel_ComplexTypes(), "dataModel", null, 0, 1, IntermediateComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateComplexType_Version(), this.getIntermediateVersion(), this.getIntermediateVersion_ComplexTypes(), "version", null, 0, 1, IntermediateComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateComplexType_Context(), this.getIntermediateContext(), this.getIntermediateContext_ComplexTypes(), "context", null, 0, 1, IntermediateComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateImportedComplexTypeEClass, IntermediateImportedComplexType.class, "IntermediateImportedComplexType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getIntermediateImportedComplexType_Import(), this.getIntermediateImport(), null, "import", null, 0, 1, IntermediateImportedComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateImportedTechnologySpecificTypeEClass, IntermediateImportedTechnologySpecificType.class, "IntermediateImportedTechnologySpecificType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateImportedTechnologySpecificType_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, IntermediateImportedTechnologySpecificType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateImportedTechnologySpecificType_Import(), this.getIntermediateImport(), null, "import", null, 0, 1, IntermediateImportedTechnologySpecificType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateDataStructureEClass, IntermediateDataStructure.class, "IntermediateDataStructure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateDataStructure_FeatureNames(), theEcorePackage.getEString(), "featureNames", null, 0, -1, IntermediateDataStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataStructure_Super(), this.getIntermediateDataStructure(), null, "super", null, 0, 1, IntermediateDataStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataStructure_Operations(), this.getIntermediateDataOperation(), this.getIntermediateDataOperation_DataStructure(), "operations", null, 0, -1, IntermediateDataStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataStructure_DataFields(), this.getIntermediateDataField(), this.getIntermediateDataField_DataStructure(), "dataFields", null, 0, -1, IntermediateDataStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateDataOperationEClass, IntermediateDataOperation.class, "IntermediateDataOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateDataOperation_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateDataOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateDataOperation_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, IntermediateDataOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateDataOperation_Hidden(), theEcorePackage.getEBoolean(), "hidden", null, 0, 1, IntermediateDataOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateDataOperation_Inherited(), theEcorePackage.getEBoolean(), "inherited", null, 0, 1, IntermediateDataOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateDataOperation_FeatureNames(), theEcorePackage.getEString(), "featureNames", null, 0, -1, IntermediateDataOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataOperation_ReturnType(), this.getIntermediateDataOperationReturnType(), this.getIntermediateDataOperationReturnType_Operation(), "returnType", null, 0, 1, IntermediateDataOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataOperation_Parameters(), this.getIntermediateDataOperationParameter(), this.getIntermediateDataOperationParameter_Operation(), "parameters", null, 0, -1, IntermediateDataOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataOperation_Aspects(), this.getIntermediateImportedAspect(), this.getIntermediateImportedAspect_Operation(), "aspects", null, 0, -1, IntermediateDataOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataOperation_DataStructure(), this.getIntermediateDataStructure(), this.getIntermediateDataStructure_Operations(), "dataStructure", null, 0, 1, IntermediateDataOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateDataOperationReturnTypeEClass, IntermediateDataOperationReturnType.class, "IntermediateDataOperationReturnType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getIntermediateDataOperationReturnType_Type(), this.getIntermediateType(), this.getIntermediateType_ReturnType(), "type", null, 0, 1, IntermediateDataOperationReturnType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataOperationReturnType_OriginalType(), this.getIntermediateType(), null, "originalType", null, 0, 1, IntermediateDataOperationReturnType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataOperationReturnType_Aspects(), this.getIntermediateImportedAspect(), this.getIntermediateImportedAspect_ReturnType(), "aspects", null, 0, -1, IntermediateDataOperationReturnType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataOperationReturnType_Operation(), this.getIntermediateDataOperation(), this.getIntermediateDataOperation_ReturnType(), "operation", null, 0, 1, IntermediateDataOperationReturnType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateDataOperationParameterEClass, IntermediateDataOperationParameter.class, "IntermediateDataOperationParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateDataOperationParameter_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateDataOperationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateDataOperationParameter_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, IntermediateDataOperationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataOperationParameter_Type(), this.getIntermediateType(), this.getIntermediateType_Parameter(), "type", null, 0, 1, IntermediateDataOperationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataOperationParameter_OriginalType(), this.getIntermediateType(), null, "originalType", null, 0, 1, IntermediateDataOperationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataOperationParameter_Aspects(), this.getIntermediateImportedAspect(), this.getIntermediateImportedAspect_Parameter(), "aspects", null, 0, -1, IntermediateDataOperationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataOperationParameter_Operation(), this.getIntermediateDataOperation(), this.getIntermediateDataOperation_Parameters(), "operation", null, 0, 1, IntermediateDataOperationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateCollectionTypeEClass, IntermediateCollectionType.class, "IntermediateCollectionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateCollectionType_PrimitiveCollection(), theEcorePackage.getEBoolean(), "primitiveCollection", null, 0, 1, IntermediateCollectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateCollectionType_StructuredCollection(), theEcorePackage.getEBoolean(), "structuredCollection", null, 0, 1, IntermediateCollectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateCollectionType_PrimitiveType(), this.getIntermediatePrimitiveType(), null, "primitiveType", null, 0, 1, IntermediateCollectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateCollectionType_DataFields(), this.getIntermediateDataField(), this.getIntermediateDataField_CollectionType(), "dataFields", null, 0, -1, IntermediateCollectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateDataFieldEClass, IntermediateDataField.class, "IntermediateDataField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateDataField_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateDataField_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, IntermediateDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateDataField_Hidden(), theEcorePackage.getEBoolean(), "hidden", null, 0, 1, IntermediateDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateDataField_Immutable(), theEcorePackage.getEBoolean(), "immutable", null, 0, 1, IntermediateDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateDataField_Inherited(), theEcorePackage.getEBoolean(), "inherited", null, 0, 1, IntermediateDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateDataField_FeatureNames(), theEcorePackage.getEString(), "featureNames", null, 0, -1, IntermediateDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateDataField_InitializationValue(), theEcorePackage.getEString(), "initializationValue", null, 0, 1, IntermediateDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataField_InitializationValueCompatibleTypes(), this.getIntermediatePrimitiveType(), this.getIntermediatePrimitiveType_InitializedDataField(), "initializationValueCompatibleTypes", null, 0, -1, IntermediateDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataField_Type(), this.getIntermediateType(), this.getIntermediateType_DataField(), "type", null, 0, 1, IntermediateDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataField_OriginalType(), this.getIntermediateType(), null, "originalType", null, 0, 1, IntermediateDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataField_Aspects(), this.getIntermediateImportedAspect(), this.getIntermediateImportedAspect_DataField(), "aspects", null, 0, -1, IntermediateDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataField_DataStructure(), this.getIntermediateDataStructure(), this.getIntermediateDataStructure_DataFields(), "dataStructure", null, 0, 1, IntermediateDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateDataField_CollectionType(), this.getIntermediateCollectionType(), this.getIntermediateCollectionType_DataFields(), "collectionType", null, 0, 1, IntermediateDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getIntermediateDataField__GetEffectiveComplexType(), this.getIntermediateComplexType(), "getEffectiveComplexType", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEClass(intermediateEnumerationEClass, IntermediateEnumeration.class, "IntermediateEnumeration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateEnumeration_FeatureNames(), theEcorePackage.getEString(), "featureNames", null, 0, -1, IntermediateEnumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateEnumeration_Fields(), this.getIntermediateEnumerationField(), this.getIntermediateEnumerationField_Enumeration(), "fields", null, 1, -1, IntermediateEnumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateEnumerationFieldEClass, IntermediateEnumerationField.class, "IntermediateEnumerationField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateEnumerationField_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateEnumerationField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateEnumerationField_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, IntermediateEnumerationField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateEnumerationField_InitializationValue(), theEcorePackage.getEString(), "initializationValue", null, 0, 1, IntermediateEnumerationField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateEnumerationField_InitializationValueCompatibleTypes(), this.getIntermediatePrimitiveType(), this.getIntermediatePrimitiveType_InitializedEnumerationField(), "initializationValueCompatibleTypes", null, 0, -1, IntermediateEnumerationField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateEnumerationField_Enumeration(), this.getIntermediateEnumeration(), this.getIntermediateEnumeration_Fields(), "enumeration", null, 0, 1, IntermediateEnumerationField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateImportedAspectEClass, IntermediateImportedAspect.class, "IntermediateImportedAspect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateImportedAspect_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateImportedAspect_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateImportedAspect_FeatureNames(), theEcorePackage.getEString(), "featureNames", null, 0, -1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateImportedAspect_Import(), this.getIntermediateImport(), null, "import", null, 0, 1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateImportedAspect_Properties(), this.getIntermediateAspectProperty(), this.getIntermediateAspectProperty_Aspect(), "properties", null, 0, -1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateImportedAspect_PropertyValues(), this.getIntermediateAspectPropertyValue(), this.getIntermediateAspectPropertyValue_Aspect(), "propertyValues", null, 0, -1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateImportedAspect_ComplexType(), this.getIntermediateComplexType(), this.getIntermediateComplexType_Aspects(), "complexType", null, 0, 1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateImportedAspect_Operation(), this.getIntermediateDataOperation(), this.getIntermediateDataOperation_Aspects(), "operation", null, 0, 1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateImportedAspect_ReturnType(), this.getIntermediateDataOperationReturnType(), this.getIntermediateDataOperationReturnType_Aspects(), "returnType", null, 0, 1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateImportedAspect_Parameter(), this.getIntermediateDataOperationParameter(), this.getIntermediateDataOperationParameter_Aspects(), "parameter", null, 0, 1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateImportedAspect_DataField(), this.getIntermediateDataField(), this.getIntermediateDataField_Aspects(), "dataField", null, 0, 1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getIntermediateImportedAspect__GetEffectivePropertyValues(), this.getEffectivePropertyValuesMap(), "getEffectivePropertyValues", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEClass(intermediateAspectPropertyEClass, IntermediateAspectProperty.class, "IntermediateAspectProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateAspectProperty_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateAspectProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateAspectProperty_Type(), theEcorePackage.getEString(), "type", null, 0, 1, IntermediateAspectProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateAspectProperty_DefaultValue(), theEcorePackage.getEString(), "defaultValue", null, 0, 1, IntermediateAspectProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateAspectProperty_FeatureNames(), theEcorePackage.getEString(), "featureNames", null, 0, -1, IntermediateAspectProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateAspectProperty_Aspect(), this.getIntermediateImportedAspect(), this.getIntermediateImportedAspect_Properties(), "aspect", null, 0, 1, IntermediateAspectProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateAspectPropertyValueEClass, IntermediateAspectPropertyValue.class, "IntermediateAspectPropertyValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateAspectPropertyValue_Value(), theEcorePackage.getEString(), "value", null, 0, 1, IntermediateAspectPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateAspectPropertyValue_Property(), this.getIntermediateAspectProperty(), null, "property", null, 0, 1, IntermediateAspectPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateAspectPropertyValue_Aspect(), this.getIntermediateImportedAspect(), this.getIntermediateImportedAspect_PropertyValues(), "aspect", null, 0, 1, IntermediateAspectPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(intermediateTypeKindEEnum, IntermediateTypeKind.class, "IntermediateTypeKind");
        addEEnumLiteral(intermediateTypeKindEEnum, IntermediateTypeKind.DUMMY_FOR_XMI_SERIALIZER_BUG);
        addEEnumLiteral(intermediateTypeKindEEnum, IntermediateTypeKind.COLLECTION);
        addEEnumLiteral(intermediateTypeKindEEnum, IntermediateTypeKind.ENUMERATION);
        addEEnumLiteral(intermediateTypeKindEEnum, IntermediateTypeKind.PRIMITIVE);
        addEEnumLiteral(intermediateTypeKindEEnum, IntermediateTypeKind.STRUCTURE);

        initEEnum(intermediateTypeOriginEEnum, IntermediateTypeOrigin.class, "IntermediateTypeOrigin");
        addEEnumLiteral(intermediateTypeOriginEEnum, IntermediateTypeOrigin.DUMMY_FOR_XMI_SERIALIZER_BUG);
        addEEnumLiteral(intermediateTypeOriginEEnum, IntermediateTypeOrigin.DATA_MODEL);
        addEEnumLiteral(intermediateTypeOriginEEnum, IntermediateTypeOrigin.BUILTIN);
        addEEnumLiteral(intermediateTypeOriginEEnum, IntermediateTypeOrigin.TECHNOLOGY);

        // Initialize data types
        initEDataType(effectivePropertyValuesMapEDataType, Map.class, "EffectivePropertyValuesMap", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.Map<de.fhdo.lemma.data.intermediate.IntermediateAspectProperty, java.lang.String>");

        // Create resource
        createResource(eNS_URI);
    }

} //IntermediatePackageImpl
