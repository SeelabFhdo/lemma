/**
 */
package de.fhdo.lemma.data.impl;

import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.ComplexTypeImport;
import de.fhdo.lemma.data.Context;
import de.fhdo.lemma.data.DataFactory;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.data.DataPackage;
import de.fhdo.lemma.data.DataStructure;
import de.fhdo.lemma.data.Enumeration;
import de.fhdo.lemma.data.EnumerationField;
import de.fhdo.lemma.data.FieldFeature;
import de.fhdo.lemma.data.ListType;
import de.fhdo.lemma.data.PossiblyImportedComplexType;
import de.fhdo.lemma.data.PrimitiveBoolean;
import de.fhdo.lemma.data.PrimitiveByte;
import de.fhdo.lemma.data.PrimitiveCharacter;
import de.fhdo.lemma.data.PrimitiveDate;
import de.fhdo.lemma.data.PrimitiveDouble;
import de.fhdo.lemma.data.PrimitiveFloat;
import de.fhdo.lemma.data.PrimitiveInteger;
import de.fhdo.lemma.data.PrimitiveLong;
import de.fhdo.lemma.data.PrimitiveShort;
import de.fhdo.lemma.data.PrimitiveString;
import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.data.PrimitiveTypeConstants;
import de.fhdo.lemma.data.PrimitiveValue;
import de.fhdo.lemma.data.Type;
import de.fhdo.lemma.data.Version;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
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
public class DataPackageImpl extends EPackageImpl implements DataPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataModelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass complexTypeImportEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass versionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass contextEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass primitiveTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass primitiveBooleanEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass primitiveByteEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass primitiveCharacterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass primitiveDateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass primitiveDoubleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass primitiveFloatEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass primitiveIntegerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass primitiveLongEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass primitiveShortEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass primitiveStringEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass complexTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass possiblyImportedComplexTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataStructureEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass listTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass enumerationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass enumerationFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass primitiveValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum primitiveTypeConstantsEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum fieldFeatureEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType typeNameSizeMapEDataType = null;

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
     * @see de.fhdo.lemma.data.DataPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private DataPackageImpl() {
        super(eNS_URI, DataFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link DataPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static DataPackage init() {
        if (isInited) return (DataPackage)EPackage.Registry.INSTANCE.getEPackage(DataPackage.eNS_URI);

        // Obtain or create and register package
        Object registeredDataPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        DataPackageImpl theDataPackage = registeredDataPackage instanceof DataPackageImpl ? (DataPackageImpl)registeredDataPackage : new DataPackageImpl();

        isInited = true;

        // Initialize simple dependencies
        EcorePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theDataPackage.createPackageContents();

        // Initialize created meta-data
        theDataPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theDataPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(DataPackage.eNS_URI, theDataPackage);
        return theDataPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDataModel() {
        return dataModelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getDataModel_T_modelUri() {
        return (EAttribute)dataModelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDataModel_ComplexTypeImports() {
        return (EReference)dataModelEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDataModel_Versions() {
        return (EReference)dataModelEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDataModel_Contexts() {
        return (EReference)dataModelEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDataModel_ComplexTypes() {
        return (EReference)dataModelEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getDataModel__GetContainedComplexTypes() {
        return dataModelEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getComplexTypeImport() {
        return complexTypeImportEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getComplexTypeImport_Name() {
        return (EAttribute)complexTypeImportEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getComplexTypeImport_ImportURI() {
        return (EAttribute)complexTypeImportEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getComplexTypeImport_DataModel() {
        return (EReference)complexTypeImportEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getVersion() {
        return versionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getVersion_Name() {
        return (EAttribute)versionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getVersion_ComplexTypes() {
        return (EReference)versionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getVersion_Contexts() {
        return (EReference)versionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getVersion_DataModel() {
        return (EReference)versionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getVersion__GetContainedComplexTypes() {
        return versionEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getVersion__GetQualifiedNameParts() {
        return versionEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getContext() {
        return contextEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getContext_Name() {
        return (EAttribute)contextEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getContext_ComplexTypes() {
        return (EReference)contextEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getContext_DataModel() {
        return (EReference)contextEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getContext_Version() {
        return (EReference)contextEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getContext__GetQualifiedNameParts() {
        return contextEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getContext__BuildQualifiedName__String() {
        return contextEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getType() {
        return typeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPrimitiveType() {
        return primitiveTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getPrimitiveType_TypeName() {
        return (EAttribute)primitiveTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getPrimitiveType_TypeSize() {
        return (EAttribute)primitiveTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPrimitiveType__SizeCompare__PrimitiveType() {
        return primitiveTypeEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPrimitiveType__IsCompatibleWith__PrimitiveType() {
        return primitiveTypeEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPrimitiveType__GetBuiltinPrimitiveTypes() {
        return primitiveTypeEClass.getEOperations().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPrimitiveBoolean() {
        return primitiveBooleanEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPrimitiveByte() {
        return primitiveByteEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPrimitiveCharacter() {
        return primitiveCharacterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPrimitiveDate() {
        return primitiveDateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPrimitiveDouble() {
        return primitiveDoubleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPrimitiveFloat() {
        return primitiveFloatEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPrimitiveInteger() {
        return primitiveIntegerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPrimitiveLong() {
        return primitiveLongEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPrimitiveShort() {
        return primitiveShortEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPrimitiveString() {
        return primitiveStringEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getComplexType() {
        return complexTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getComplexType_Name() {
        return (EAttribute)complexTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getComplexType_DataModel() {
        return (EReference)complexTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getComplexType_Version() {
        return (EReference)complexTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getComplexType_Context() {
        return (EReference)complexTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getComplexType_IsStructure() {
        return (EAttribute)complexTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getComplexType_IsPrimitiveList() {
        return (EAttribute)complexTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getComplexType_IsStructuredList() {
        return (EAttribute)complexTypeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getComplexType_IsEnumeration() {
        return (EAttribute)complexTypeEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getComplexType__GetQualifiedNameParts() {
        return complexTypeEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getComplexType__BuildQualifiedName__String() {
        return complexTypeEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getComplexType__CompareFieldCounts__EList_EList() {
        return complexTypeEClass.getEOperations().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPossiblyImportedComplexType() {
        return possiblyImportedComplexTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getPossiblyImportedComplexType_Import() {
        return (EReference)possiblyImportedComplexTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getPossiblyImportedComplexType_ComplexType() {
        return (EReference)possiblyImportedComplexTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getPossiblyImportedComplexType_DataField() {
        return (EReference)possiblyImportedComplexTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDataStructure() {
        return dataStructureEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDataStructure_Super() {
        return (EReference)dataStructureEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDataStructure_DataFields() {
        return (EReference)dataStructureEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getDataStructure__GetEffectiveFields() {
        return dataStructureEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getDataStructure__IsExtensionOf__DataStructure() {
        return dataStructureEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getDataStructure__CompareFieldCounts__DataStructure() {
        return dataStructureEClass.getEOperations().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getListType() {
        return listTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getListType_PrimitiveType() {
        return (EReference)listTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getListType_DataFields() {
        return (EReference)listTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getListType__CompareFieldCounts__ListType() {
        return listTypeEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDataField() {
        return dataFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getDataField_Name() {
        return (EAttribute)dataFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getDataField_Hidden() {
        return (EAttribute)dataFieldEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDataField_ComplexType() {
        return (EReference)dataFieldEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDataField_PrimitiveType() {
        return (EReference)dataFieldEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getDataField_Features() {
        return (EAttribute)dataFieldEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDataField_DataStructure() {
        return (EReference)dataFieldEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDataField_ListType() {
        return (EReference)dataFieldEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getDataField__GetEffectiveType() {
        return dataFieldEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getDataField__GetQualifiedNameParts() {
        return dataFieldEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getDataField__BuildQualifiedName__String() {
        return dataFieldEClass.getEOperations().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getDataField__FindEponymousSuperField() {
        return dataFieldEClass.getEOperations().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getEnumeration() {
        return enumerationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getEnumeration_Fields() {
        return (EReference)enumerationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getEnumerationField() {
        return enumerationFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getEnumerationField_Name() {
        return (EAttribute)enumerationFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getEnumerationField_InitializationValue() {
        return (EReference)enumerationFieldEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getEnumerationField_Enumeration() {
        return (EReference)enumerationFieldEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getEnumerationField__GetQualifiedNameParts() {
        return enumerationFieldEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getEnumerationField__BuildQualifiedName__String() {
        return enumerationFieldEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPrimitiveValue() {
        return primitiveValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getPrimitiveValue_StringValue() {
        return (EAttribute)primitiveValueEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getPrimitiveValue_BooleanValue() {
        return (EAttribute)primitiveValueEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getPrimitiveValue_NumericValue() {
        return (EAttribute)primitiveValueEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPrimitiveValue__IsInClosedSet__BigDecimal_BigDecimal() {
        return primitiveValueEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPrimitiveValue__HasDecimals() {
        return primitiveValueEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPrimitiveValue__IsOfType__PrimitiveType() {
        return primitiveValueEClass.getEOperations().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPrimitiveValue__HasNoValue() {
        return primitiveValueEClass.getEOperations().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPrimitiveValue__AsValueOfType__PrimitiveType() {
        return primitiveValueEClass.getEOperations().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPrimitiveValue__ValueAsString() {
        return primitiveValueEClass.getEOperations().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPrimitiveValue__AsBoolean() {
        return primitiveValueEClass.getEOperations().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPrimitiveValue__AsByte() {
        return primitiveValueEClass.getEOperations().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPrimitiveValue__AsCharacter() {
        return primitiveValueEClass.getEOperations().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPrimitiveValue__AsDate() {
        return primitiveValueEClass.getEOperations().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPrimitiveValue__AsDouble() {
        return primitiveValueEClass.getEOperations().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPrimitiveValue__AsFloat() {
        return primitiveValueEClass.getEOperations().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPrimitiveValue__AsInteger() {
        return primitiveValueEClass.getEOperations().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPrimitiveValue__AsLong() {
        return primitiveValueEClass.getEOperations().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPrimitiveValue__AsShort() {
        return primitiveValueEClass.getEOperations().get(14);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPrimitiveValue__AsString() {
        return primitiveValueEClass.getEOperations().get(15);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPrimitiveValue__InferCompatibleTypes() {
        return primitiveValueEClass.getEOperations().get(16);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EEnum getPrimitiveTypeConstants() {
        return primitiveTypeConstantsEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EEnum getFieldFeature() {
        return fieldFeatureEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EDataType getTypeNameSizeMap() {
        return typeNameSizeMapEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DataFactory getDataFactory() {
        return (DataFactory)getEFactoryInstance();
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
        dataModelEClass = createEClass(DATA_MODEL);
        createEAttribute(dataModelEClass, DATA_MODEL__TMODEL_URI);
        createEReference(dataModelEClass, DATA_MODEL__COMPLEX_TYPE_IMPORTS);
        createEReference(dataModelEClass, DATA_MODEL__VERSIONS);
        createEReference(dataModelEClass, DATA_MODEL__CONTEXTS);
        createEReference(dataModelEClass, DATA_MODEL__COMPLEX_TYPES);
        createEOperation(dataModelEClass, DATA_MODEL___GET_CONTAINED_COMPLEX_TYPES);

        complexTypeImportEClass = createEClass(COMPLEX_TYPE_IMPORT);
        createEAttribute(complexTypeImportEClass, COMPLEX_TYPE_IMPORT__NAME);
        createEAttribute(complexTypeImportEClass, COMPLEX_TYPE_IMPORT__IMPORT_URI);
        createEReference(complexTypeImportEClass, COMPLEX_TYPE_IMPORT__DATA_MODEL);

        versionEClass = createEClass(VERSION);
        createEAttribute(versionEClass, VERSION__NAME);
        createEReference(versionEClass, VERSION__COMPLEX_TYPES);
        createEReference(versionEClass, VERSION__CONTEXTS);
        createEReference(versionEClass, VERSION__DATA_MODEL);
        createEOperation(versionEClass, VERSION___GET_CONTAINED_COMPLEX_TYPES);
        createEOperation(versionEClass, VERSION___GET_QUALIFIED_NAME_PARTS);

        contextEClass = createEClass(CONTEXT);
        createEAttribute(contextEClass, CONTEXT__NAME);
        createEReference(contextEClass, CONTEXT__COMPLEX_TYPES);
        createEReference(contextEClass, CONTEXT__DATA_MODEL);
        createEReference(contextEClass, CONTEXT__VERSION);
        createEOperation(contextEClass, CONTEXT___GET_QUALIFIED_NAME_PARTS);
        createEOperation(contextEClass, CONTEXT___BUILD_QUALIFIED_NAME__STRING);

        typeEClass = createEClass(TYPE);

        primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);
        createEAttribute(primitiveTypeEClass, PRIMITIVE_TYPE__TYPE_NAME);
        createEAttribute(primitiveTypeEClass, PRIMITIVE_TYPE__TYPE_SIZE);
        createEOperation(primitiveTypeEClass, PRIMITIVE_TYPE___SIZE_COMPARE__PRIMITIVETYPE);
        createEOperation(primitiveTypeEClass, PRIMITIVE_TYPE___IS_COMPATIBLE_WITH__PRIMITIVETYPE);
        createEOperation(primitiveTypeEClass, PRIMITIVE_TYPE___GET_BUILTIN_PRIMITIVE_TYPES);

        primitiveBooleanEClass = createEClass(PRIMITIVE_BOOLEAN);

        primitiveByteEClass = createEClass(PRIMITIVE_BYTE);

        primitiveCharacterEClass = createEClass(PRIMITIVE_CHARACTER);

        primitiveDateEClass = createEClass(PRIMITIVE_DATE);

        primitiveDoubleEClass = createEClass(PRIMITIVE_DOUBLE);

        primitiveFloatEClass = createEClass(PRIMITIVE_FLOAT);

        primitiveIntegerEClass = createEClass(PRIMITIVE_INTEGER);

        primitiveLongEClass = createEClass(PRIMITIVE_LONG);

        primitiveShortEClass = createEClass(PRIMITIVE_SHORT);

        primitiveStringEClass = createEClass(PRIMITIVE_STRING);

        complexTypeEClass = createEClass(COMPLEX_TYPE);
        createEAttribute(complexTypeEClass, COMPLEX_TYPE__NAME);
        createEReference(complexTypeEClass, COMPLEX_TYPE__DATA_MODEL);
        createEReference(complexTypeEClass, COMPLEX_TYPE__VERSION);
        createEReference(complexTypeEClass, COMPLEX_TYPE__CONTEXT);
        createEAttribute(complexTypeEClass, COMPLEX_TYPE__IS_STRUCTURE);
        createEAttribute(complexTypeEClass, COMPLEX_TYPE__IS_PRIMITIVE_LIST);
        createEAttribute(complexTypeEClass, COMPLEX_TYPE__IS_STRUCTURED_LIST);
        createEAttribute(complexTypeEClass, COMPLEX_TYPE__IS_ENUMERATION);
        createEOperation(complexTypeEClass, COMPLEX_TYPE___GET_QUALIFIED_NAME_PARTS);
        createEOperation(complexTypeEClass, COMPLEX_TYPE___BUILD_QUALIFIED_NAME__STRING);
        createEOperation(complexTypeEClass, COMPLEX_TYPE___COMPARE_FIELD_COUNTS__ELIST_ELIST);

        possiblyImportedComplexTypeEClass = createEClass(POSSIBLY_IMPORTED_COMPLEX_TYPE);
        createEReference(possiblyImportedComplexTypeEClass, POSSIBLY_IMPORTED_COMPLEX_TYPE__IMPORT);
        createEReference(possiblyImportedComplexTypeEClass, POSSIBLY_IMPORTED_COMPLEX_TYPE__COMPLEX_TYPE);
        createEReference(possiblyImportedComplexTypeEClass, POSSIBLY_IMPORTED_COMPLEX_TYPE__DATA_FIELD);

        dataStructureEClass = createEClass(DATA_STRUCTURE);
        createEReference(dataStructureEClass, DATA_STRUCTURE__SUPER);
        createEReference(dataStructureEClass, DATA_STRUCTURE__DATA_FIELDS);
        createEOperation(dataStructureEClass, DATA_STRUCTURE___GET_EFFECTIVE_FIELDS);
        createEOperation(dataStructureEClass, DATA_STRUCTURE___IS_EXTENSION_OF__DATASTRUCTURE);
        createEOperation(dataStructureEClass, DATA_STRUCTURE___COMPARE_FIELD_COUNTS__DATASTRUCTURE);

        listTypeEClass = createEClass(LIST_TYPE);
        createEReference(listTypeEClass, LIST_TYPE__PRIMITIVE_TYPE);
        createEReference(listTypeEClass, LIST_TYPE__DATA_FIELDS);
        createEOperation(listTypeEClass, LIST_TYPE___COMPARE_FIELD_COUNTS__LISTTYPE);

        dataFieldEClass = createEClass(DATA_FIELD);
        createEAttribute(dataFieldEClass, DATA_FIELD__NAME);
        createEAttribute(dataFieldEClass, DATA_FIELD__HIDDEN);
        createEReference(dataFieldEClass, DATA_FIELD__COMPLEX_TYPE);
        createEReference(dataFieldEClass, DATA_FIELD__PRIMITIVE_TYPE);
        createEAttribute(dataFieldEClass, DATA_FIELD__FEATURES);
        createEReference(dataFieldEClass, DATA_FIELD__DATA_STRUCTURE);
        createEReference(dataFieldEClass, DATA_FIELD__LIST_TYPE);
        createEOperation(dataFieldEClass, DATA_FIELD___GET_EFFECTIVE_TYPE);
        createEOperation(dataFieldEClass, DATA_FIELD___GET_QUALIFIED_NAME_PARTS);
        createEOperation(dataFieldEClass, DATA_FIELD___BUILD_QUALIFIED_NAME__STRING);
        createEOperation(dataFieldEClass, DATA_FIELD___FIND_EPONYMOUS_SUPER_FIELD);

        enumerationEClass = createEClass(ENUMERATION);
        createEReference(enumerationEClass, ENUMERATION__FIELDS);

        enumerationFieldEClass = createEClass(ENUMERATION_FIELD);
        createEAttribute(enumerationFieldEClass, ENUMERATION_FIELD__NAME);
        createEReference(enumerationFieldEClass, ENUMERATION_FIELD__INITIALIZATION_VALUE);
        createEReference(enumerationFieldEClass, ENUMERATION_FIELD__ENUMERATION);
        createEOperation(enumerationFieldEClass, ENUMERATION_FIELD___GET_QUALIFIED_NAME_PARTS);
        createEOperation(enumerationFieldEClass, ENUMERATION_FIELD___BUILD_QUALIFIED_NAME__STRING);

        primitiveValueEClass = createEClass(PRIMITIVE_VALUE);
        createEAttribute(primitiveValueEClass, PRIMITIVE_VALUE__STRING_VALUE);
        createEAttribute(primitiveValueEClass, PRIMITIVE_VALUE__BOOLEAN_VALUE);
        createEAttribute(primitiveValueEClass, PRIMITIVE_VALUE__NUMERIC_VALUE);
        createEOperation(primitiveValueEClass, PRIMITIVE_VALUE___IS_IN_CLOSED_SET__BIGDECIMAL_BIGDECIMAL);
        createEOperation(primitiveValueEClass, PRIMITIVE_VALUE___HAS_DECIMALS);
        createEOperation(primitiveValueEClass, PRIMITIVE_VALUE___IS_OF_TYPE__PRIMITIVETYPE);
        createEOperation(primitiveValueEClass, PRIMITIVE_VALUE___HAS_NO_VALUE);
        createEOperation(primitiveValueEClass, PRIMITIVE_VALUE___AS_VALUE_OF_TYPE__PRIMITIVETYPE);
        createEOperation(primitiveValueEClass, PRIMITIVE_VALUE___VALUE_AS_STRING);
        createEOperation(primitiveValueEClass, PRIMITIVE_VALUE___AS_BOOLEAN);
        createEOperation(primitiveValueEClass, PRIMITIVE_VALUE___AS_BYTE);
        createEOperation(primitiveValueEClass, PRIMITIVE_VALUE___AS_CHARACTER);
        createEOperation(primitiveValueEClass, PRIMITIVE_VALUE___AS_DATE);
        createEOperation(primitiveValueEClass, PRIMITIVE_VALUE___AS_DOUBLE);
        createEOperation(primitiveValueEClass, PRIMITIVE_VALUE___AS_FLOAT);
        createEOperation(primitiveValueEClass, PRIMITIVE_VALUE___AS_INTEGER);
        createEOperation(primitiveValueEClass, PRIMITIVE_VALUE___AS_LONG);
        createEOperation(primitiveValueEClass, PRIMITIVE_VALUE___AS_SHORT);
        createEOperation(primitiveValueEClass, PRIMITIVE_VALUE___AS_STRING);
        createEOperation(primitiveValueEClass, PRIMITIVE_VALUE___INFER_COMPATIBLE_TYPES);

        // Create enums
        primitiveTypeConstantsEEnum = createEEnum(PRIMITIVE_TYPE_CONSTANTS);
        fieldFeatureEEnum = createEEnum(FIELD_FEATURE);

        // Create data types
        typeNameSizeMapEDataType = createEDataType(TYPE_NAME_SIZE_MAP);
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
        primitiveTypeEClass.getESuperTypes().add(this.getType());
        primitiveBooleanEClass.getESuperTypes().add(this.getPrimitiveType());
        primitiveByteEClass.getESuperTypes().add(this.getPrimitiveType());
        primitiveCharacterEClass.getESuperTypes().add(this.getPrimitiveType());
        primitiveDateEClass.getESuperTypes().add(this.getPrimitiveType());
        primitiveDoubleEClass.getESuperTypes().add(this.getPrimitiveType());
        primitiveFloatEClass.getESuperTypes().add(this.getPrimitiveType());
        primitiveIntegerEClass.getESuperTypes().add(this.getPrimitiveType());
        primitiveLongEClass.getESuperTypes().add(this.getPrimitiveType());
        primitiveShortEClass.getESuperTypes().add(this.getPrimitiveType());
        primitiveStringEClass.getESuperTypes().add(this.getPrimitiveType());
        complexTypeEClass.getESuperTypes().add(this.getType());
        dataStructureEClass.getESuperTypes().add(this.getComplexType());
        listTypeEClass.getESuperTypes().add(this.getComplexType());
        enumerationEClass.getESuperTypes().add(this.getComplexType());

        // Initialize classes, features, and operations; add parameters
        initEClass(dataModelEClass, DataModel.class, "DataModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDataModel_T_modelUri(), theEcorePackage.getEString(), "t_modelUri", null, 0, 1, DataModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataModel_ComplexTypeImports(), this.getComplexTypeImport(), this.getComplexTypeImport_DataModel(), "complexTypeImports", null, 0, -1, DataModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataModel_Versions(), this.getVersion(), this.getVersion_DataModel(), "versions", null, 0, -1, DataModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataModel_Contexts(), this.getContext(), this.getContext_DataModel(), "contexts", null, 0, -1, DataModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataModel_ComplexTypes(), this.getComplexType(), this.getComplexType_DataModel(), "complexTypes", null, 0, -1, DataModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getDataModel__GetContainedComplexTypes(), this.getComplexType(), "getContainedComplexTypes", 0, -1, !IS_UNIQUE, IS_ORDERED);

        initEClass(complexTypeImportEClass, ComplexTypeImport.class, "ComplexTypeImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getComplexTypeImport_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ComplexTypeImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getComplexTypeImport_ImportURI(), theEcorePackage.getEString(), "importURI", null, 0, 1, ComplexTypeImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComplexTypeImport_DataModel(), this.getDataModel(), this.getDataModel_ComplexTypeImports(), "dataModel", null, 0, 1, ComplexTypeImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(versionEClass, Version.class, "Version", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getVersion_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getVersion_ComplexTypes(), this.getComplexType(), this.getComplexType_Version(), "complexTypes", null, 0, -1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getVersion_Contexts(), this.getContext(), this.getContext_Version(), "contexts", null, 0, -1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getVersion_DataModel(), this.getDataModel(), this.getDataModel_Versions(), "dataModel", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getVersion__GetContainedComplexTypes(), this.getComplexType(), "getContainedComplexTypes", 0, -1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getVersion__GetQualifiedNameParts(), theEcorePackage.getEString(), "getQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);

        initEClass(contextEClass, Context.class, "Context", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getContext_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getContext_ComplexTypes(), this.getComplexType(), this.getComplexType_Context(), "complexTypes", null, 1, -1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getContext_DataModel(), this.getDataModel(), this.getDataModel_Contexts(), "dataModel", null, 0, 1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getContext_Version(), this.getVersion(), this.getVersion_Contexts(), "version", null, 0, 1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getContext__GetQualifiedNameParts(), theEcorePackage.getEString(), "getQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);

        EOperation op = initEOperation(getContext__BuildQualifiedName__String(), theEcorePackage.getEString(), "buildQualifiedName", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEString(), "separator", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPrimitiveType_TypeName(), theEcorePackage.getEString(), "typeName", null, 0, 1, PrimitiveType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getPrimitiveType_TypeSize(), theEcorePackage.getEIntegerObject(), "typeSize", null, 0, 1, PrimitiveType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        op = initEOperation(getPrimitiveType__SizeCompare__PrimitiveType(), theEcorePackage.getEInt(), "sizeCompare", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getPrimitiveType(), "typeToCompare", 0, 1, !IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getPrimitiveType__IsCompatibleWith__PrimitiveType(), theEcorePackage.getEBoolean(), "isCompatibleWith", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getPrimitiveType(), "typeToCheck", 0, 1, !IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getPrimitiveType__GetBuiltinPrimitiveTypes(), null, "getBuiltinPrimitiveTypes", 0, -1, !IS_UNIQUE, IS_ORDERED);
        EGenericType g1 = createEGenericType(theEcorePackage.getEJavaClass());
        EGenericType g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        initEClass(primitiveBooleanEClass, PrimitiveBoolean.class, "PrimitiveBoolean", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(primitiveByteEClass, PrimitiveByte.class, "PrimitiveByte", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(primitiveCharacterEClass, PrimitiveCharacter.class, "PrimitiveCharacter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(primitiveDateEClass, PrimitiveDate.class, "PrimitiveDate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(primitiveDoubleEClass, PrimitiveDouble.class, "PrimitiveDouble", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(primitiveFloatEClass, PrimitiveFloat.class, "PrimitiveFloat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(primitiveIntegerEClass, PrimitiveInteger.class, "PrimitiveInteger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(primitiveLongEClass, PrimitiveLong.class, "PrimitiveLong", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(primitiveShortEClass, PrimitiveShort.class, "PrimitiveShort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(primitiveStringEClass, PrimitiveString.class, "PrimitiveString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(complexTypeEClass, ComplexType.class, "ComplexType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getComplexType_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComplexType_DataModel(), this.getDataModel(), this.getDataModel_ComplexTypes(), "dataModel", null, 0, 1, ComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComplexType_Version(), this.getVersion(), this.getVersion_ComplexTypes(), "version", null, 0, 1, ComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComplexType_Context(), this.getContext(), this.getContext_ComplexTypes(), "context", null, 0, 1, ComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getComplexType_IsStructure(), theEcorePackage.getEBoolean(), "isStructure", null, 0, 1, ComplexType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getComplexType_IsPrimitiveList(), theEcorePackage.getEBoolean(), "isPrimitiveList", null, 0, 1, ComplexType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getComplexType_IsStructuredList(), theEcorePackage.getEBoolean(), "isStructuredList", null, 0, 1, ComplexType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getComplexType_IsEnumeration(), theEcorePackage.getEBoolean(), "isEnumeration", null, 0, 1, ComplexType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEOperation(getComplexType__GetQualifiedNameParts(), theEcorePackage.getEString(), "getQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getComplexType__BuildQualifiedName__String(), theEcorePackage.getEString(), "buildQualifiedName", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEString(), "separator", 0, 1, !IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getComplexType__CompareFieldCounts__EList_EList(), theEcorePackage.getEInt(), "compareFieldCounts", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getDataField(), "fields", 0, -1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getDataField(), "fieldsToCompare", 0, -1, !IS_UNIQUE, IS_ORDERED);

        initEClass(possiblyImportedComplexTypeEClass, PossiblyImportedComplexType.class, "PossiblyImportedComplexType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPossiblyImportedComplexType_Import(), this.getComplexTypeImport(), null, "import", null, 0, 1, PossiblyImportedComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPossiblyImportedComplexType_ComplexType(), this.getComplexType(), null, "complexType", null, 0, 1, PossiblyImportedComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPossiblyImportedComplexType_DataField(), this.getDataField(), this.getDataField_ComplexType(), "dataField", null, 0, 1, PossiblyImportedComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dataStructureEClass, DataStructure.class, "DataStructure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDataStructure_Super(), this.getDataStructure(), null, "super", null, 0, 1, DataStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataStructure_DataFields(), this.getDataField(), this.getDataField_DataStructure(), "dataFields", null, 0, -1, DataStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getDataStructure__GetEffectiveFields(), this.getDataField(), "getEffectiveFields", 0, -1, !IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getDataStructure__IsExtensionOf__DataStructure(), theEcorePackage.getEBoolean(), "isExtensionOf", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getDataStructure(), "structure", 0, 1, !IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getDataStructure__CompareFieldCounts__DataStructure(), theEcorePackage.getEInt(), "compareFieldCounts", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getDataStructure(), "structureToCompare", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEClass(listTypeEClass, ListType.class, "ListType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getListType_PrimitiveType(), this.getPrimitiveType(), null, "primitiveType", null, 0, 1, ListType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getListType_DataFields(), this.getDataField(), this.getDataField_ListType(), "dataFields", null, 0, -1, ListType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        op = initEOperation(getListType__CompareFieldCounts__ListType(), theEcorePackage.getEInt(), "compareFieldCounts", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getListType(), "listToCompare", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEClass(dataFieldEClass, DataField.class, "DataField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDataField_Name(), theEcorePackage.getEString(), "name", null, 0, 1, DataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDataField_Hidden(), theEcorePackage.getEBoolean(), "hidden", null, 0, 1, DataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataField_ComplexType(), this.getPossiblyImportedComplexType(), this.getPossiblyImportedComplexType_DataField(), "complexType", null, 0, 1, DataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataField_PrimitiveType(), this.getPrimitiveType(), null, "primitiveType", null, 0, 1, DataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDataField_Features(), this.getFieldFeature(), "features", null, 0, -1, DataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataField_DataStructure(), this.getDataStructure(), this.getDataStructure_DataFields(), "dataStructure", null, 0, 1, DataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataField_ListType(), this.getListType(), this.getListType_DataFields(), "listType", null, 0, 1, DataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getDataField__GetEffectiveType(), this.getType(), "getEffectiveType", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getDataField__GetQualifiedNameParts(), theEcorePackage.getEString(), "getQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getDataField__BuildQualifiedName__String(), theEcorePackage.getEString(), "buildQualifiedName", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEString(), "separator", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getDataField__FindEponymousSuperField(), this.getDataField(), "findEponymousSuperField", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEClass(enumerationEClass, Enumeration.class, "Enumeration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEnumeration_Fields(), this.getEnumerationField(), this.getEnumerationField_Enumeration(), "fields", null, 1, -1, Enumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(enumerationFieldEClass, EnumerationField.class, "EnumerationField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEnumerationField_Name(), theEcorePackage.getEString(), "name", null, 0, 1, EnumerationField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEnumerationField_InitializationValue(), this.getPrimitiveValue(), null, "initializationValue", null, 0, 1, EnumerationField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEnumerationField_Enumeration(), this.getEnumeration(), this.getEnumeration_Fields(), "enumeration", null, 0, 1, EnumerationField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getEnumerationField__GetQualifiedNameParts(), theEcorePackage.getEString(), "getQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getEnumerationField__BuildQualifiedName__String(), theEcorePackage.getEString(), "buildQualifiedName", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEString(), "separator", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEClass(primitiveValueEClass, PrimitiveValue.class, "PrimitiveValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPrimitiveValue_StringValue(), theEcorePackage.getEString(), "stringValue", null, 0, 1, PrimitiveValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPrimitiveValue_BooleanValue(), theEcorePackage.getEBooleanObject(), "booleanValue", null, 0, 1, PrimitiveValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPrimitiveValue_NumericValue(), theEcorePackage.getEBigDecimal(), "numericValue", null, 0, 1, PrimitiveValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        op = initEOperation(getPrimitiveValue__IsInClosedSet__BigDecimal_BigDecimal(), theEcorePackage.getEBoolean(), "isInClosedSet", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEBigDecimal(), "lowerBound", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEBigDecimal(), "upperBound", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getPrimitiveValue__HasDecimals(), theEcorePackage.getEBoolean(), "hasDecimals", 0, 1, !IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getPrimitiveValue__IsOfType__PrimitiveType(), theEcorePackage.getEBoolean(), "isOfType", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getPrimitiveType(), "primitiveType", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getPrimitiveValue__HasNoValue(), theEcorePackage.getEBoolean(), "hasNoValue", 0, 1, !IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getPrimitiveValue__AsValueOfType__PrimitiveType(), theEcorePackage.getEJavaObject(), "asValueOfType", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getPrimitiveType(), "primitiveType", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getPrimitiveValue__ValueAsString(), theEcorePackage.getEString(), "valueAsString", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getPrimitiveValue__AsBoolean(), theEcorePackage.getEBooleanObject(), "asBoolean", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getPrimitiveValue__AsByte(), theEcorePackage.getEByteObject(), "asByte", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getPrimitiveValue__AsCharacter(), theEcorePackage.getECharacterObject(), "asCharacter", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getPrimitiveValue__AsDate(), theEcorePackage.getEDate(), "asDate", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getPrimitiveValue__AsDouble(), theEcorePackage.getEDoubleObject(), "asDouble", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getPrimitiveValue__AsFloat(), theEcorePackage.getEFloatObject(), "asFloat", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getPrimitiveValue__AsInteger(), theEcorePackage.getEIntegerObject(), "asInteger", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getPrimitiveValue__AsLong(), theEcorePackage.getELongObject(), "asLong", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getPrimitiveValue__AsShort(), theEcorePackage.getEShortObject(), "asShort", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getPrimitiveValue__AsString(), theEcorePackage.getEString(), "asString", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getPrimitiveValue__InferCompatibleTypes(), this.getTypeNameSizeMap(), "inferCompatibleTypes", 0, 1, !IS_UNIQUE, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(primitiveTypeConstantsEEnum, PrimitiveTypeConstants.class, "PrimitiveTypeConstants");
        addEEnumLiteral(primitiveTypeConstantsEEnum, PrimitiveTypeConstants.BOOLEAN);
        addEEnumLiteral(primitiveTypeConstantsEEnum, PrimitiveTypeConstants.BYTE);
        addEEnumLiteral(primitiveTypeConstantsEEnum, PrimitiveTypeConstants.CHARACTER);
        addEEnumLiteral(primitiveTypeConstantsEEnum, PrimitiveTypeConstants.DATE);
        addEEnumLiteral(primitiveTypeConstantsEEnum, PrimitiveTypeConstants.DOUBLE);
        addEEnumLiteral(primitiveTypeConstantsEEnum, PrimitiveTypeConstants.FLOAT);
        addEEnumLiteral(primitiveTypeConstantsEEnum, PrimitiveTypeConstants.INTEGER);
        addEEnumLiteral(primitiveTypeConstantsEEnum, PrimitiveTypeConstants.LONG);
        addEEnumLiteral(primitiveTypeConstantsEEnum, PrimitiveTypeConstants.SHORT);
        addEEnumLiteral(primitiveTypeConstantsEEnum, PrimitiveTypeConstants.STRING);

        initEEnum(fieldFeatureEEnum, FieldFeature.class, "FieldFeature");
        addEEnumLiteral(fieldFeatureEEnum, FieldFeature.DERIVED);

        // Initialize data types
        initEDataType(typeNameSizeMapEDataType, Map.class, "TypeNameSizeMap", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.Map<java.lang.String, java.lang.Integer>");

        // Create resource
        createResource(eNS_URI);
    }

} //DataPackageImpl
