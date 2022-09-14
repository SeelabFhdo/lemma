/**
 */
package de.fhdo.lemma.technology.impl;

import de.fhdo.lemma.data.DataPackage;

import de.fhdo.lemma.technology.AspectFeature;
import de.fhdo.lemma.technology.CommunicationType;
import de.fhdo.lemma.technology.CompatibilityDirection;
import de.fhdo.lemma.technology.CompatibilityMatrixEntry;
import de.fhdo.lemma.technology.DataFormat;
import de.fhdo.lemma.technology.DeploymentTechnology;
import de.fhdo.lemma.technology.ExchangePattern;
import de.fhdo.lemma.technology.InfrastructureTechnology;
import de.fhdo.lemma.technology.JoinPointType;
import de.fhdo.lemma.technology.OperationAspect;
import de.fhdo.lemma.technology.OperationAspectPointcut;
import de.fhdo.lemma.technology.OperationAspectPointcutSelector;
import de.fhdo.lemma.technology.OperationEnvironment;
import de.fhdo.lemma.technology.OperationTechnology;
import de.fhdo.lemma.technology.PointcutType;
import de.fhdo.lemma.technology.PossiblyImportedTechnologySpecificType;
import de.fhdo.lemma.technology.PropertyFeature;
import de.fhdo.lemma.technology.Protocol;
import de.fhdo.lemma.technology.ServiceAspect;
import de.fhdo.lemma.technology.ServiceAspectPointcut;
import de.fhdo.lemma.technology.ServiceAspectPointcutSelector;
import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.technology.TechnologyAspect;
import de.fhdo.lemma.technology.TechnologyFactory;
import de.fhdo.lemma.technology.TechnologyImport;
import de.fhdo.lemma.technology.TechnologyPackage;
import de.fhdo.lemma.technology.TechnologySpecificCollectionType;
import de.fhdo.lemma.technology.TechnologySpecificDataStructure;
import de.fhdo.lemma.technology.TechnologySpecificPrimitiveType;
import de.fhdo.lemma.technology.TechnologySpecificProperty;
import de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment;

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
public class TechnologyPackageImpl extends EPackageImpl implements TechnologyPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technologyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technologyImportEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass protocolEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataFormatEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technologySpecificPrimitiveTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technologySpecificCollectionTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technologySpecificDataStructureEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass compatibilityMatrixEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass possiblyImportedTechnologySpecificTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass operationTechnologyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass operationEnvironmentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technologySpecificPropertyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technologySpecificPropertyValueAssignmentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass deploymentTechnologyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass infrastructureTechnologyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technologyAspectEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass serviceAspectEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass serviceAspectPointcutEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass serviceAspectPointcutSelectorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass operationAspectEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass operationAspectPointcutEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass operationAspectPointcutSelectorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum exchangePatternEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum communicationTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum compatibilityDirectionEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum propertyFeatureEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum joinPointTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum pointcutTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum aspectFeatureEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType pointcutTypeStringsMapEDataType = null;

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
     * @see de.fhdo.lemma.technology.TechnologyPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private TechnologyPackageImpl() {
        super(eNS_URI, TechnologyFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link TechnologyPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static TechnologyPackage init() {
        if (isInited) return (TechnologyPackage)EPackage.Registry.INSTANCE.getEPackage(TechnologyPackage.eNS_URI);

        // Obtain or create and register package
        Object registeredTechnologyPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        TechnologyPackageImpl theTechnologyPackage = registeredTechnologyPackage instanceof TechnologyPackageImpl ? (TechnologyPackageImpl)registeredTechnologyPackage : new TechnologyPackageImpl();

        isInited = true;

        // Initialize simple dependencies
        EcorePackage.eINSTANCE.eClass();
        DataPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theTechnologyPackage.createPackageContents();

        // Initialize created meta-data
        theTechnologyPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theTechnologyPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(TechnologyPackage.eNS_URI, theTechnologyPackage);
        return theTechnologyPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnology() {
        return technologyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTechnology_Name() {
        return (EAttribute)technologyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnology_Imports() {
        return (EReference)technologyEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnology_PrimitiveTypes() {
        return (EReference)technologyEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnology_CollectionTypes() {
        return (EReference)technologyEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnology_DataStructures() {
        return (EReference)technologyEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnology_CompatibilityEntries() {
        return (EReference)technologyEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnology_Protocols() {
        return (EReference)technologyEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnology_ServiceAspects() {
        return (EReference)technologyEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnology_DeploymentTechnologies() {
        return (EReference)technologyEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnology_InfrastructureTechnologies() {
        return (EReference)technologyEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnology_OperationAspects() {
        return (EReference)technologyEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnologyImport() {
        return technologyImportEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTechnologyImport_Name() {
        return (EAttribute)technologyImportEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTechnologyImport_ImportURI() {
        return (EAttribute)technologyImportEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologyImport_Technology() {
        return (EReference)technologyImportEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getProtocol() {
        return protocolEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProtocol_Name() {
        return (EAttribute)protocolEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProtocol_CommunicationType() {
        return (EAttribute)protocolEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProtocol_Default() {
        return (EAttribute)protocolEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProtocol_DefaultFormat() {
        return (EReference)protocolEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProtocol_DataFormats() {
        return (EReference)protocolEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProtocol_Technology() {
        return (EReference)protocolEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getProtocol__GetQualifiedNameParts() {
        return protocolEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDataFormat() {
        return dataFormatEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDataFormat_FormatName() {
        return (EAttribute)dataFormatEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataFormat_Protocol() {
        return (EReference)dataFormatEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnologySpecificPrimitiveType() {
        return technologySpecificPrimitiveTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTechnologySpecificPrimitiveType_Name() {
        return (EAttribute)technologySpecificPrimitiveTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTechnologySpecificPrimitiveType_Default() {
        return (EAttribute)technologySpecificPrimitiveTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificPrimitiveType_Technology() {
        return (EReference)technologySpecificPrimitiveTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificPrimitiveType_BasicBuiltinPrimitiveTypes() {
        return (EReference)technologySpecificPrimitiveTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getTechnologySpecificPrimitiveType__GetQualifiedNameParts() {
        return technologySpecificPrimitiveTypeEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getTechnologySpecificPrimitiveType__BuildQualifiedName__String() {
        return technologySpecificPrimitiveTypeEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnologySpecificCollectionType() {
        return technologySpecificCollectionTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificCollectionType_Technology() {
        return (EReference)technologySpecificCollectionTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getTechnologySpecificCollectionType__GetQualifiedNameParts() {
        return technologySpecificCollectionTypeEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getTechnologySpecificCollectionType__BuildQualifiedName__String() {
        return technologySpecificCollectionTypeEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnologySpecificDataStructure() {
        return technologySpecificDataStructureEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificDataStructure_Technology() {
        return (EReference)technologySpecificDataStructureEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getTechnologySpecificDataStructure__GetQualifiedNameParts() {
        return technologySpecificDataStructureEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getTechnologySpecificDataStructure__BuildQualifiedName__String() {
        return technologySpecificDataStructureEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCompatibilityMatrixEntry() {
        return compatibilityMatrixEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCompatibilityMatrixEntry_Direction() {
        return (EAttribute)compatibilityMatrixEntryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCompatibilityMatrixEntry_MappingType() {
        return (EReference)compatibilityMatrixEntryEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCompatibilityMatrixEntry_CompatibleTypes() {
        return (EReference)compatibilityMatrixEntryEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCompatibilityMatrixEntry_Technology() {
        return (EReference)compatibilityMatrixEntryEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPossiblyImportedTechnologySpecificType() {
        return possiblyImportedTechnologySpecificTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPossiblyImportedTechnologySpecificType_Import() {
        return (EReference)possiblyImportedTechnologySpecificTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPossiblyImportedTechnologySpecificType_Type() {
        return (EReference)possiblyImportedTechnologySpecificTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPossiblyImportedTechnologySpecificType_MappingEntry() {
        return (EReference)possiblyImportedTechnologySpecificTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPossiblyImportedTechnologySpecificType_CompatibleEntry() {
        return (EReference)possiblyImportedTechnologySpecificTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOperationTechnology() {
        return operationTechnologyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperationTechnology_Name() {
        return (EAttribute)operationTechnologyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationTechnology_OperationEnvironments() {
        return (EReference)operationTechnologyEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationTechnology_ServiceProperties() {
        return (EReference)operationTechnologyEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOperationEnvironment() {
        return operationEnvironmentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperationEnvironment_EnvironmentName() {
        return (EAttribute)operationEnvironmentEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperationEnvironment_Default() {
        return (EAttribute)operationEnvironmentEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationEnvironment_OperationTechnology() {
        return (EReference)operationEnvironmentEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnologySpecificProperty() {
        return technologySpecificPropertyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTechnologySpecificProperty_Name() {
        return (EAttribute)technologySpecificPropertyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificProperty_Type() {
        return (EReference)technologySpecificPropertyEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificProperty_DefaultValue() {
        return (EReference)technologySpecificPropertyEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTechnologySpecificProperty_Features() {
        return (EAttribute)technologySpecificPropertyEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificProperty_OperationTechnology() {
        return (EReference)technologySpecificPropertyEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificProperty_TechnologyAspect() {
        return (EReference)technologySpecificPropertyEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTechnologySpecificProperty_IsMandatory() {
        return (EAttribute)technologySpecificPropertyEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnologySpecificPropertyValueAssignment() {
        return technologySpecificPropertyValueAssignmentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificPropertyValueAssignment_Property() {
        return (EReference)technologySpecificPropertyValueAssignmentEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificPropertyValueAssignment_Value() {
        return (EReference)technologySpecificPropertyValueAssignmentEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDeploymentTechnology() {
        return deploymentTechnologyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDeploymentTechnology_Technology() {
        return (EReference)deploymentTechnologyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getDeploymentTechnology__GetQualifiedNameParts() {
        return deploymentTechnologyEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getDeploymentTechnology__BuildQualifiedName__String_boolean_boolean() {
        return deploymentTechnologyEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInfrastructureTechnology() {
        return infrastructureTechnologyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInfrastructureTechnology_Technology() {
        return (EReference)infrastructureTechnologyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getInfrastructureTechnology__GetQualifiedNameParts() {
        return infrastructureTechnologyEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getInfrastructureTechnology__BuildQualifiedName__String_boolean_boolean() {
        return infrastructureTechnologyEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnologyAspect() {
        return technologyAspectEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTechnologyAspect_Name() {
        return (EAttribute)technologyAspectEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTechnologyAspect_Features() {
        return (EAttribute)technologyAspectEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTechnologyAspect_JoinPoints() {
        return (EAttribute)technologyAspectEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologyAspect_Properties() {
        return (EReference)technologyAspectEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTechnologyAspect_IsSingleValued() {
        return (EAttribute)technologyAspectEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getServiceAspect() {
        return serviceAspectEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getServiceAspect_PointcutSelectors() {
        return (EReference)serviceAspectEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getServiceAspect_Technology() {
        return (EReference)serviceAspectEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getServiceAspect__GetQualifiedNameParts__boolean_boolean() {
        return serviceAspectEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getServiceAspect__BuildQualifiedName__String_boolean_boolean() {
        return serviceAspectEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getServiceAspect__IsValidSelectorForJoinPoint__JoinPointType_ServiceAspectPointcutSelector() {
        return serviceAspectEClass.getEOperations().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getServiceAspect__IsValidSelectorForJoinPoint__JoinPointType_ExchangePattern_CommunicationType_Protocol_DataFormat() {
        return serviceAspectEClass.getEOperations().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getServiceAspect__HasMatchingSelector__ExchangePattern_CommunicationType_Protocol_DataFormat() {
        return serviceAspectEClass.getEOperations().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getServiceAspectPointcut() {
        return serviceAspectPointcutEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getServiceAspectPointcut_ForExchangePattern() {
        return (EAttribute)serviceAspectPointcutEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getServiceAspectPointcut_ForCommunicationType() {
        return (EAttribute)serviceAspectPointcutEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getServiceAspectPointcut_ForProtocol() {
        return (EAttribute)serviceAspectPointcutEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getServiceAspectPointcut_ForDataFormat() {
        return (EAttribute)serviceAspectPointcutEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getServiceAspectPointcut_ExchangePattern() {
        return (EAttribute)serviceAspectPointcutEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getServiceAspectPointcut_CommunicationType() {
        return (EAttribute)serviceAspectPointcutEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getServiceAspectPointcut_Protocol() {
        return (EReference)serviceAspectPointcutEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getServiceAspectPointcut_DataFormat() {
        return (EReference)serviceAspectPointcutEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getServiceAspectPointcut_Selector() {
        return (EReference)serviceAspectPointcutEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getServiceAspectPointcut_EffectiveType() {
        return (EAttribute)serviceAspectPointcutEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getServiceAspectPointcut_EffectiveSelectorName() {
        return (EAttribute)serviceAspectPointcutEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getServiceAspectPointcut_EffectiveValue() {
        return (EAttribute)serviceAspectPointcutEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getServiceAspectPointcut_PrintableEffectiveValue() {
        return (EAttribute)serviceAspectPointcutEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getServiceAspectPointcut_OrderedPointcutTypes() {
        return (EAttribute)serviceAspectPointcutEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getServiceAspectPointcut__IsValidSelectorFor__JoinPointType() {
        return serviceAspectPointcutEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getServiceAspectPointcutSelector() {
        return serviceAspectPointcutSelectorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getServiceAspectPointcutSelector_Pointcuts() {
        return (EReference)serviceAspectPointcutSelectorEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getServiceAspectPointcutSelector_ServiceAspect() {
        return (EReference)serviceAspectPointcutSelectorEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getServiceAspectPointcutSelector_SelectorString() {
        return (EAttribute)serviceAspectPointcutSelectorEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getServiceAspectPointcutSelector__OrderedSelectorValues() {
        return serviceAspectPointcutSelectorEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOperationAspect() {
        return operationAspectEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationAspect_PointcutSelectors() {
        return (EReference)operationAspectEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationAspect_Technology() {
        return (EReference)operationAspectEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperationAspect__GetQualifiedNameParts__boolean_boolean() {
        return operationAspectEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperationAspect__BuildQualifiedName__String_boolean_boolean() {
        return operationAspectEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperationAspect__HasMatchingSelector__EObject() {
        return operationAspectEClass.getEOperations().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOperationAspectPointcut() {
        return operationAspectPointcutEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperationAspectPointcut_ForTechnology() {
        return (EAttribute)operationAspectPointcutEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationAspectPointcut_Technology() {
        return (EReference)operationAspectPointcutEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationAspectPointcut_Selector() {
        return (EReference)operationAspectPointcutEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperationAspectPointcut_EffectiveType() {
        return (EAttribute)operationAspectPointcutEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperationAspectPointcut_EffectiveSelectorName() {
        return (EAttribute)operationAspectPointcutEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperationAspectPointcut_EffectiveValue() {
        return (EAttribute)operationAspectPointcutEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperationAspectPointcut_PrintableEffectiveValue() {
        return (EAttribute)operationAspectPointcutEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperationAspectPointcut_OrderedPointcutTypes() {
        return (EAttribute)operationAspectPointcutEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOperationAspectPointcutSelector() {
        return operationAspectPointcutSelectorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationAspectPointcutSelector_Pointcuts() {
        return (EReference)operationAspectPointcutSelectorEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationAspectPointcutSelector_OperationAspect() {
        return (EReference)operationAspectPointcutSelectorEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperationAspectPointcutSelector_SelectorString() {
        return (EAttribute)operationAspectPointcutSelectorEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperationAspectPointcutSelector__OrderedSelectorValues() {
        return operationAspectPointcutSelectorEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getExchangePattern() {
        return exchangePatternEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getCommunicationType() {
        return communicationTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getCompatibilityDirection() {
        return compatibilityDirectionEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getPropertyFeature() {
        return propertyFeatureEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getJoinPointType() {
        return joinPointTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getPointcutType() {
        return pointcutTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getAspectFeature() {
        return aspectFeatureEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getPointcutTypeStringsMap() {
        return pointcutTypeStringsMapEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologyFactory getTechnologyFactory() {
        return (TechnologyFactory)getEFactoryInstance();
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
        technologyEClass = createEClass(TECHNOLOGY);
        createEAttribute(technologyEClass, TECHNOLOGY__NAME);
        createEReference(technologyEClass, TECHNOLOGY__IMPORTS);
        createEReference(technologyEClass, TECHNOLOGY__PRIMITIVE_TYPES);
        createEReference(technologyEClass, TECHNOLOGY__COLLECTION_TYPES);
        createEReference(technologyEClass, TECHNOLOGY__DATA_STRUCTURES);
        createEReference(technologyEClass, TECHNOLOGY__COMPATIBILITY_ENTRIES);
        createEReference(technologyEClass, TECHNOLOGY__PROTOCOLS);
        createEReference(technologyEClass, TECHNOLOGY__SERVICE_ASPECTS);
        createEReference(technologyEClass, TECHNOLOGY__DEPLOYMENT_TECHNOLOGIES);
        createEReference(technologyEClass, TECHNOLOGY__INFRASTRUCTURE_TECHNOLOGIES);
        createEReference(technologyEClass, TECHNOLOGY__OPERATION_ASPECTS);

        technologyImportEClass = createEClass(TECHNOLOGY_IMPORT);
        createEAttribute(technologyImportEClass, TECHNOLOGY_IMPORT__NAME);
        createEAttribute(technologyImportEClass, TECHNOLOGY_IMPORT__IMPORT_URI);
        createEReference(technologyImportEClass, TECHNOLOGY_IMPORT__TECHNOLOGY);

        protocolEClass = createEClass(PROTOCOL);
        createEAttribute(protocolEClass, PROTOCOL__NAME);
        createEAttribute(protocolEClass, PROTOCOL__COMMUNICATION_TYPE);
        createEAttribute(protocolEClass, PROTOCOL__DEFAULT);
        createEReference(protocolEClass, PROTOCOL__DEFAULT_FORMAT);
        createEReference(protocolEClass, PROTOCOL__DATA_FORMATS);
        createEReference(protocolEClass, PROTOCOL__TECHNOLOGY);
        createEOperation(protocolEClass, PROTOCOL___GET_QUALIFIED_NAME_PARTS);

        dataFormatEClass = createEClass(DATA_FORMAT);
        createEAttribute(dataFormatEClass, DATA_FORMAT__FORMAT_NAME);
        createEReference(dataFormatEClass, DATA_FORMAT__PROTOCOL);

        technologySpecificPrimitiveTypeEClass = createEClass(TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE);
        createEAttribute(technologySpecificPrimitiveTypeEClass, TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__NAME);
        createEAttribute(technologySpecificPrimitiveTypeEClass, TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__DEFAULT);
        createEReference(technologySpecificPrimitiveTypeEClass, TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__TECHNOLOGY);
        createEReference(technologySpecificPrimitiveTypeEClass, TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__BASIC_BUILTIN_PRIMITIVE_TYPES);
        createEOperation(technologySpecificPrimitiveTypeEClass, TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE___GET_QUALIFIED_NAME_PARTS);
        createEOperation(technologySpecificPrimitiveTypeEClass, TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE___BUILD_QUALIFIED_NAME__STRING);

        technologySpecificCollectionTypeEClass = createEClass(TECHNOLOGY_SPECIFIC_COLLECTION_TYPE);
        createEReference(technologySpecificCollectionTypeEClass, TECHNOLOGY_SPECIFIC_COLLECTION_TYPE__TECHNOLOGY);
        createEOperation(technologySpecificCollectionTypeEClass, TECHNOLOGY_SPECIFIC_COLLECTION_TYPE___GET_QUALIFIED_NAME_PARTS);
        createEOperation(technologySpecificCollectionTypeEClass, TECHNOLOGY_SPECIFIC_COLLECTION_TYPE___BUILD_QUALIFIED_NAME__STRING);

        technologySpecificDataStructureEClass = createEClass(TECHNOLOGY_SPECIFIC_DATA_STRUCTURE);
        createEReference(technologySpecificDataStructureEClass, TECHNOLOGY_SPECIFIC_DATA_STRUCTURE__TECHNOLOGY);
        createEOperation(technologySpecificDataStructureEClass, TECHNOLOGY_SPECIFIC_DATA_STRUCTURE___GET_QUALIFIED_NAME_PARTS);
        createEOperation(technologySpecificDataStructureEClass, TECHNOLOGY_SPECIFIC_DATA_STRUCTURE___BUILD_QUALIFIED_NAME__STRING);

        compatibilityMatrixEntryEClass = createEClass(COMPATIBILITY_MATRIX_ENTRY);
        createEAttribute(compatibilityMatrixEntryEClass, COMPATIBILITY_MATRIX_ENTRY__DIRECTION);
        createEReference(compatibilityMatrixEntryEClass, COMPATIBILITY_MATRIX_ENTRY__MAPPING_TYPE);
        createEReference(compatibilityMatrixEntryEClass, COMPATIBILITY_MATRIX_ENTRY__COMPATIBLE_TYPES);
        createEReference(compatibilityMatrixEntryEClass, COMPATIBILITY_MATRIX_ENTRY__TECHNOLOGY);

        possiblyImportedTechnologySpecificTypeEClass = createEClass(POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE);
        createEReference(possiblyImportedTechnologySpecificTypeEClass, POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__IMPORT);
        createEReference(possiblyImportedTechnologySpecificTypeEClass, POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__TYPE);
        createEReference(possiblyImportedTechnologySpecificTypeEClass, POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__MAPPING_ENTRY);
        createEReference(possiblyImportedTechnologySpecificTypeEClass, POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__COMPATIBLE_ENTRY);

        operationTechnologyEClass = createEClass(OPERATION_TECHNOLOGY);
        createEAttribute(operationTechnologyEClass, OPERATION_TECHNOLOGY__NAME);
        createEReference(operationTechnologyEClass, OPERATION_TECHNOLOGY__OPERATION_ENVIRONMENTS);
        createEReference(operationTechnologyEClass, OPERATION_TECHNOLOGY__SERVICE_PROPERTIES);

        operationEnvironmentEClass = createEClass(OPERATION_ENVIRONMENT);
        createEAttribute(operationEnvironmentEClass, OPERATION_ENVIRONMENT__ENVIRONMENT_NAME);
        createEAttribute(operationEnvironmentEClass, OPERATION_ENVIRONMENT__DEFAULT);
        createEReference(operationEnvironmentEClass, OPERATION_ENVIRONMENT__OPERATION_TECHNOLOGY);

        technologySpecificPropertyEClass = createEClass(TECHNOLOGY_SPECIFIC_PROPERTY);
        createEAttribute(technologySpecificPropertyEClass, TECHNOLOGY_SPECIFIC_PROPERTY__NAME);
        createEReference(technologySpecificPropertyEClass, TECHNOLOGY_SPECIFIC_PROPERTY__TYPE);
        createEReference(technologySpecificPropertyEClass, TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE);
        createEAttribute(technologySpecificPropertyEClass, TECHNOLOGY_SPECIFIC_PROPERTY__FEATURES);
        createEReference(technologySpecificPropertyEClass, TECHNOLOGY_SPECIFIC_PROPERTY__OPERATION_TECHNOLOGY);
        createEReference(technologySpecificPropertyEClass, TECHNOLOGY_SPECIFIC_PROPERTY__TECHNOLOGY_ASPECT);
        createEAttribute(technologySpecificPropertyEClass, TECHNOLOGY_SPECIFIC_PROPERTY__IS_MANDATORY);

        technologySpecificPropertyValueAssignmentEClass = createEClass(TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT);
        createEReference(technologySpecificPropertyValueAssignmentEClass, TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT__PROPERTY);
        createEReference(technologySpecificPropertyValueAssignmentEClass, TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT__VALUE);

        deploymentTechnologyEClass = createEClass(DEPLOYMENT_TECHNOLOGY);
        createEReference(deploymentTechnologyEClass, DEPLOYMENT_TECHNOLOGY__TECHNOLOGY);
        createEOperation(deploymentTechnologyEClass, DEPLOYMENT_TECHNOLOGY___GET_QUALIFIED_NAME_PARTS);
        createEOperation(deploymentTechnologyEClass, DEPLOYMENT_TECHNOLOGY___BUILD_QUALIFIED_NAME__STRING_BOOLEAN_BOOLEAN);

        infrastructureTechnologyEClass = createEClass(INFRASTRUCTURE_TECHNOLOGY);
        createEReference(infrastructureTechnologyEClass, INFRASTRUCTURE_TECHNOLOGY__TECHNOLOGY);
        createEOperation(infrastructureTechnologyEClass, INFRASTRUCTURE_TECHNOLOGY___GET_QUALIFIED_NAME_PARTS);
        createEOperation(infrastructureTechnologyEClass, INFRASTRUCTURE_TECHNOLOGY___BUILD_QUALIFIED_NAME__STRING_BOOLEAN_BOOLEAN);

        technologyAspectEClass = createEClass(TECHNOLOGY_ASPECT);
        createEAttribute(technologyAspectEClass, TECHNOLOGY_ASPECT__NAME);
        createEAttribute(technologyAspectEClass, TECHNOLOGY_ASPECT__FEATURES);
        createEAttribute(technologyAspectEClass, TECHNOLOGY_ASPECT__JOIN_POINTS);
        createEReference(technologyAspectEClass, TECHNOLOGY_ASPECT__PROPERTIES);
        createEAttribute(technologyAspectEClass, TECHNOLOGY_ASPECT__IS_SINGLE_VALUED);

        serviceAspectEClass = createEClass(SERVICE_ASPECT);
        createEReference(serviceAspectEClass, SERVICE_ASPECT__POINTCUT_SELECTORS);
        createEReference(serviceAspectEClass, SERVICE_ASPECT__TECHNOLOGY);
        createEOperation(serviceAspectEClass, SERVICE_ASPECT___GET_QUALIFIED_NAME_PARTS__BOOLEAN_BOOLEAN);
        createEOperation(serviceAspectEClass, SERVICE_ASPECT___BUILD_QUALIFIED_NAME__STRING_BOOLEAN_BOOLEAN);
        createEOperation(serviceAspectEClass, SERVICE_ASPECT___IS_VALID_SELECTOR_FOR_JOIN_POINT__JOINPOINTTYPE_SERVICEASPECTPOINTCUTSELECTOR);
        createEOperation(serviceAspectEClass, SERVICE_ASPECT___IS_VALID_SELECTOR_FOR_JOIN_POINT__JOINPOINTTYPE_EXCHANGEPATTERN_COMMUNICATIONTYPE_PROTOCOL_DATAFORMAT);
        createEOperation(serviceAspectEClass, SERVICE_ASPECT___HAS_MATCHING_SELECTOR__EXCHANGEPATTERN_COMMUNICATIONTYPE_PROTOCOL_DATAFORMAT);

        serviceAspectPointcutEClass = createEClass(SERVICE_ASPECT_POINTCUT);
        createEAttribute(serviceAspectPointcutEClass, SERVICE_ASPECT_POINTCUT__FOR_EXCHANGE_PATTERN);
        createEAttribute(serviceAspectPointcutEClass, SERVICE_ASPECT_POINTCUT__FOR_COMMUNICATION_TYPE);
        createEAttribute(serviceAspectPointcutEClass, SERVICE_ASPECT_POINTCUT__FOR_PROTOCOL);
        createEAttribute(serviceAspectPointcutEClass, SERVICE_ASPECT_POINTCUT__FOR_DATA_FORMAT);
        createEAttribute(serviceAspectPointcutEClass, SERVICE_ASPECT_POINTCUT__EXCHANGE_PATTERN);
        createEAttribute(serviceAspectPointcutEClass, SERVICE_ASPECT_POINTCUT__COMMUNICATION_TYPE);
        createEReference(serviceAspectPointcutEClass, SERVICE_ASPECT_POINTCUT__PROTOCOL);
        createEReference(serviceAspectPointcutEClass, SERVICE_ASPECT_POINTCUT__DATA_FORMAT);
        createEReference(serviceAspectPointcutEClass, SERVICE_ASPECT_POINTCUT__SELECTOR);
        createEAttribute(serviceAspectPointcutEClass, SERVICE_ASPECT_POINTCUT__EFFECTIVE_TYPE);
        createEAttribute(serviceAspectPointcutEClass, SERVICE_ASPECT_POINTCUT__EFFECTIVE_SELECTOR_NAME);
        createEAttribute(serviceAspectPointcutEClass, SERVICE_ASPECT_POINTCUT__EFFECTIVE_VALUE);
        createEAttribute(serviceAspectPointcutEClass, SERVICE_ASPECT_POINTCUT__PRINTABLE_EFFECTIVE_VALUE);
        createEAttribute(serviceAspectPointcutEClass, SERVICE_ASPECT_POINTCUT__ORDERED_POINTCUT_TYPES);
        createEOperation(serviceAspectPointcutEClass, SERVICE_ASPECT_POINTCUT___IS_VALID_SELECTOR_FOR__JOINPOINTTYPE);

        serviceAspectPointcutSelectorEClass = createEClass(SERVICE_ASPECT_POINTCUT_SELECTOR);
        createEReference(serviceAspectPointcutSelectorEClass, SERVICE_ASPECT_POINTCUT_SELECTOR__POINTCUTS);
        createEReference(serviceAspectPointcutSelectorEClass, SERVICE_ASPECT_POINTCUT_SELECTOR__SERVICE_ASPECT);
        createEAttribute(serviceAspectPointcutSelectorEClass, SERVICE_ASPECT_POINTCUT_SELECTOR__SELECTOR_STRING);
        createEOperation(serviceAspectPointcutSelectorEClass, SERVICE_ASPECT_POINTCUT_SELECTOR___ORDERED_SELECTOR_VALUES);

        operationAspectEClass = createEClass(OPERATION_ASPECT);
        createEReference(operationAspectEClass, OPERATION_ASPECT__POINTCUT_SELECTORS);
        createEReference(operationAspectEClass, OPERATION_ASPECT__TECHNOLOGY);
        createEOperation(operationAspectEClass, OPERATION_ASPECT___GET_QUALIFIED_NAME_PARTS__BOOLEAN_BOOLEAN);
        createEOperation(operationAspectEClass, OPERATION_ASPECT___BUILD_QUALIFIED_NAME__STRING_BOOLEAN_BOOLEAN);
        createEOperation(operationAspectEClass, OPERATION_ASPECT___HAS_MATCHING_SELECTOR__EOBJECT);

        operationAspectPointcutEClass = createEClass(OPERATION_ASPECT_POINTCUT);
        createEAttribute(operationAspectPointcutEClass, OPERATION_ASPECT_POINTCUT__FOR_TECHNOLOGY);
        createEReference(operationAspectPointcutEClass, OPERATION_ASPECT_POINTCUT__TECHNOLOGY);
        createEReference(operationAspectPointcutEClass, OPERATION_ASPECT_POINTCUT__SELECTOR);
        createEAttribute(operationAspectPointcutEClass, OPERATION_ASPECT_POINTCUT__EFFECTIVE_TYPE);
        createEAttribute(operationAspectPointcutEClass, OPERATION_ASPECT_POINTCUT__EFFECTIVE_SELECTOR_NAME);
        createEAttribute(operationAspectPointcutEClass, OPERATION_ASPECT_POINTCUT__EFFECTIVE_VALUE);
        createEAttribute(operationAspectPointcutEClass, OPERATION_ASPECT_POINTCUT__PRINTABLE_EFFECTIVE_VALUE);
        createEAttribute(operationAspectPointcutEClass, OPERATION_ASPECT_POINTCUT__ORDERED_POINTCUT_TYPES);

        operationAspectPointcutSelectorEClass = createEClass(OPERATION_ASPECT_POINTCUT_SELECTOR);
        createEReference(operationAspectPointcutSelectorEClass, OPERATION_ASPECT_POINTCUT_SELECTOR__POINTCUTS);
        createEReference(operationAspectPointcutSelectorEClass, OPERATION_ASPECT_POINTCUT_SELECTOR__OPERATION_ASPECT);
        createEAttribute(operationAspectPointcutSelectorEClass, OPERATION_ASPECT_POINTCUT_SELECTOR__SELECTOR_STRING);
        createEOperation(operationAspectPointcutSelectorEClass, OPERATION_ASPECT_POINTCUT_SELECTOR___ORDERED_SELECTOR_VALUES);

        // Create enums
        exchangePatternEEnum = createEEnum(EXCHANGE_PATTERN);
        communicationTypeEEnum = createEEnum(COMMUNICATION_TYPE);
        compatibilityDirectionEEnum = createEEnum(COMPATIBILITY_DIRECTION);
        propertyFeatureEEnum = createEEnum(PROPERTY_FEATURE);
        joinPointTypeEEnum = createEEnum(JOIN_POINT_TYPE);
        pointcutTypeEEnum = createEEnum(POINTCUT_TYPE);
        aspectFeatureEEnum = createEEnum(ASPECT_FEATURE);

        // Create data types
        pointcutTypeStringsMapEDataType = createEDataType(POINTCUT_TYPE_STRINGS_MAP);
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
        DataPackage theDataPackage = (DataPackage)EPackage.Registry.INSTANCE.getEPackage(DataPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        technologySpecificPrimitiveTypeEClass.getESuperTypes().add(theDataPackage.getPrimitiveType());
        technologySpecificCollectionTypeEClass.getESuperTypes().add(theDataPackage.getComplexType());
        technologySpecificDataStructureEClass.getESuperTypes().add(theDataPackage.getComplexType());
        deploymentTechnologyEClass.getESuperTypes().add(this.getOperationTechnology());
        infrastructureTechnologyEClass.getESuperTypes().add(this.getOperationTechnology());
        serviceAspectEClass.getESuperTypes().add(this.getTechnologyAspect());
        operationAspectEClass.getESuperTypes().add(this.getTechnologyAspect());

        // Initialize classes, features, and operations; add parameters
        initEClass(technologyEClass, Technology.class, "Technology", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTechnology_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Technology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnology_Imports(), this.getTechnologyImport(), this.getTechnologyImport_Technology(), "imports", null, 0, -1, Technology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnology_PrimitiveTypes(), this.getTechnologySpecificPrimitiveType(), this.getTechnologySpecificPrimitiveType_Technology(), "primitiveTypes", null, 0, -1, Technology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnology_CollectionTypes(), this.getTechnologySpecificCollectionType(), this.getTechnologySpecificCollectionType_Technology(), "collectionTypes", null, 0, -1, Technology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnology_DataStructures(), this.getTechnologySpecificDataStructure(), this.getTechnologySpecificDataStructure_Technology(), "dataStructures", null, 0, -1, Technology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnology_CompatibilityEntries(), this.getCompatibilityMatrixEntry(), this.getCompatibilityMatrixEntry_Technology(), "compatibilityEntries", null, 0, -1, Technology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnology_Protocols(), this.getProtocol(), this.getProtocol_Technology(), "protocols", null, 0, -1, Technology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnology_ServiceAspects(), this.getServiceAspect(), this.getServiceAspect_Technology(), "serviceAspects", null, 0, -1, Technology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnology_DeploymentTechnologies(), this.getDeploymentTechnology(), this.getDeploymentTechnology_Technology(), "deploymentTechnologies", null, 0, -1, Technology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnology_InfrastructureTechnologies(), this.getInfrastructureTechnology(), this.getInfrastructureTechnology_Technology(), "infrastructureTechnologies", null, 0, -1, Technology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnology_OperationAspects(), this.getOperationAspect(), this.getOperationAspect_Technology(), "operationAspects", null, 0, -1, Technology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(technologyImportEClass, TechnologyImport.class, "TechnologyImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTechnologyImport_Name(), theEcorePackage.getEString(), "name", null, 0, 1, TechnologyImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTechnologyImport_ImportURI(), theEcorePackage.getEString(), "importURI", null, 0, 1, TechnologyImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologyImport_Technology(), this.getTechnology(), this.getTechnology_Imports(), "technology", null, 0, 1, TechnologyImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(protocolEClass, Protocol.class, "Protocol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getProtocol_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProtocol_CommunicationType(), this.getCommunicationType(), "communicationType", null, 0, 1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProtocol_Default(), theEcorePackage.getEBoolean(), "default", "false", 0, 1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getProtocol_DefaultFormat(), this.getDataFormat(), null, "defaultFormat", null, 0, 1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getProtocol_DataFormats(), this.getDataFormat(), this.getDataFormat_Protocol(), "dataFormats", null, 1, -1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getProtocol_Technology(), this.getTechnology(), this.getTechnology_Protocols(), "technology", null, 0, 1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getProtocol__GetQualifiedNameParts(), theEcorePackage.getEString(), "getQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);

        initEClass(dataFormatEClass, DataFormat.class, "DataFormat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDataFormat_FormatName(), theEcorePackage.getEString(), "formatName", null, 0, 1, DataFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataFormat_Protocol(), this.getProtocol(), this.getProtocol_DataFormats(), "protocol", null, 0, 1, DataFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(technologySpecificPrimitiveTypeEClass, TechnologySpecificPrimitiveType.class, "TechnologySpecificPrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTechnologySpecificPrimitiveType_Name(), theEcorePackage.getEString(), "name", null, 0, 1, TechnologySpecificPrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTechnologySpecificPrimitiveType_Default(), theEcorePackage.getEBoolean(), "default", "false", 0, 1, TechnologySpecificPrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificPrimitiveType_Technology(), this.getTechnology(), this.getTechnology_PrimitiveTypes(), "technology", null, 0, 1, TechnologySpecificPrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificPrimitiveType_BasicBuiltinPrimitiveTypes(), theDataPackage.getPrimitiveType(), null, "basicBuiltinPrimitiveTypes", null, 0, -1, TechnologySpecificPrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getTechnologySpecificPrimitiveType__GetQualifiedNameParts(), theEcorePackage.getEString(), "getQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);

        EOperation op = initEOperation(getTechnologySpecificPrimitiveType__BuildQualifiedName__String(), theEcorePackage.getEString(), "buildQualifiedName", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEString(), "separator", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEClass(technologySpecificCollectionTypeEClass, TechnologySpecificCollectionType.class, "TechnologySpecificCollectionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTechnologySpecificCollectionType_Technology(), this.getTechnology(), this.getTechnology_CollectionTypes(), "technology", null, 0, 1, TechnologySpecificCollectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getTechnologySpecificCollectionType__GetQualifiedNameParts(), theEcorePackage.getEString(), "getQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getTechnologySpecificCollectionType__BuildQualifiedName__String(), theEcorePackage.getEString(), "buildQualifiedName", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEString(), "separator", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEClass(technologySpecificDataStructureEClass, TechnologySpecificDataStructure.class, "TechnologySpecificDataStructure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTechnologySpecificDataStructure_Technology(), this.getTechnology(), this.getTechnology_DataStructures(), "technology", null, 0, 1, TechnologySpecificDataStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getTechnologySpecificDataStructure__GetQualifiedNameParts(), theEcorePackage.getEString(), "getQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getTechnologySpecificDataStructure__BuildQualifiedName__String(), theEcorePackage.getEString(), "buildQualifiedName", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEString(), "separator", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEClass(compatibilityMatrixEntryEClass, CompatibilityMatrixEntry.class, "CompatibilityMatrixEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCompatibilityMatrixEntry_Direction(), this.getCompatibilityDirection(), "direction", null, 0, 1, CompatibilityMatrixEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCompatibilityMatrixEntry_MappingType(), this.getPossiblyImportedTechnologySpecificType(), this.getPossiblyImportedTechnologySpecificType_MappingEntry(), "mappingType", null, 0, 1, CompatibilityMatrixEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCompatibilityMatrixEntry_CompatibleTypes(), this.getPossiblyImportedTechnologySpecificType(), this.getPossiblyImportedTechnologySpecificType_CompatibleEntry(), "compatibleTypes", null, 1, -1, CompatibilityMatrixEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCompatibilityMatrixEntry_Technology(), this.getTechnology(), this.getTechnology_CompatibilityEntries(), "technology", null, 0, 1, CompatibilityMatrixEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(possiblyImportedTechnologySpecificTypeEClass, PossiblyImportedTechnologySpecificType.class, "PossiblyImportedTechnologySpecificType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPossiblyImportedTechnologySpecificType_Import(), this.getTechnologyImport(), null, "import", null, 0, 1, PossiblyImportedTechnologySpecificType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPossiblyImportedTechnologySpecificType_Type(), theDataPackage.getType(), null, "type", null, 0, 1, PossiblyImportedTechnologySpecificType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPossiblyImportedTechnologySpecificType_MappingEntry(), this.getCompatibilityMatrixEntry(), this.getCompatibilityMatrixEntry_MappingType(), "mappingEntry", null, 0, 1, PossiblyImportedTechnologySpecificType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPossiblyImportedTechnologySpecificType_CompatibleEntry(), this.getCompatibilityMatrixEntry(), this.getCompatibilityMatrixEntry_CompatibleTypes(), "compatibleEntry", null, 0, 1, PossiblyImportedTechnologySpecificType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(operationTechnologyEClass, OperationTechnology.class, "OperationTechnology", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getOperationTechnology_Name(), theEcorePackage.getEString(), "name", null, 0, 1, OperationTechnology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationTechnology_OperationEnvironments(), this.getOperationEnvironment(), this.getOperationEnvironment_OperationTechnology(), "operationEnvironments", null, 1, -1, OperationTechnology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationTechnology_ServiceProperties(), this.getTechnologySpecificProperty(), this.getTechnologySpecificProperty_OperationTechnology(), "serviceProperties", null, 0, -1, OperationTechnology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(operationEnvironmentEClass, OperationEnvironment.class, "OperationEnvironment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getOperationEnvironment_EnvironmentName(), theEcorePackage.getEString(), "environmentName", null, 0, 1, OperationEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getOperationEnvironment_Default(), theEcorePackage.getEBoolean(), "default", "false", 0, 1, OperationEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationEnvironment_OperationTechnology(), this.getOperationTechnology(), this.getOperationTechnology_OperationEnvironments(), "operationTechnology", null, 0, 1, OperationEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(technologySpecificPropertyEClass, TechnologySpecificProperty.class, "TechnologySpecificProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTechnologySpecificProperty_Name(), theEcorePackage.getEString(), "name", null, 0, 1, TechnologySpecificProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificProperty_Type(), theDataPackage.getPrimitiveType(), null, "type", null, 0, 1, TechnologySpecificProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificProperty_DefaultValue(), theDataPackage.getPrimitiveValue(), null, "defaultValue", null, 0, 1, TechnologySpecificProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTechnologySpecificProperty_Features(), this.getPropertyFeature(), "features", null, 0, -1, TechnologySpecificProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificProperty_OperationTechnology(), this.getOperationTechnology(), this.getOperationTechnology_ServiceProperties(), "operationTechnology", null, 0, 1, TechnologySpecificProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificProperty_TechnologyAspect(), this.getTechnologyAspect(), this.getTechnologyAspect_Properties(), "technologyAspect", null, 0, 1, TechnologySpecificProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTechnologySpecificProperty_IsMandatory(), theEcorePackage.getEBoolean(), "isMandatory", null, 0, 1, TechnologySpecificProperty.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(technologySpecificPropertyValueAssignmentEClass, TechnologySpecificPropertyValueAssignment.class, "TechnologySpecificPropertyValueAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTechnologySpecificPropertyValueAssignment_Property(), this.getTechnologySpecificProperty(), null, "property", null, 0, 1, TechnologySpecificPropertyValueAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificPropertyValueAssignment_Value(), theDataPackage.getPrimitiveValue(), null, "value", null, 0, 1, TechnologySpecificPropertyValueAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(deploymentTechnologyEClass, DeploymentTechnology.class, "DeploymentTechnology", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDeploymentTechnology_Technology(), this.getTechnology(), this.getTechnology_DeploymentTechnologies(), "technology", null, 0, 1, DeploymentTechnology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getDeploymentTechnology__GetQualifiedNameParts(), theEcorePackage.getEString(), "getQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getDeploymentTechnology__BuildQualifiedName__String_boolean_boolean(), theEcorePackage.getEString(), "buildQualifiedName", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEString(), "separator", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEBoolean(), "withTechnologyName", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEBoolean(), "withNamespace", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEClass(infrastructureTechnologyEClass, InfrastructureTechnology.class, "InfrastructureTechnology", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getInfrastructureTechnology_Technology(), this.getTechnology(), this.getTechnology_InfrastructureTechnologies(), "technology", null, 0, 1, InfrastructureTechnology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getInfrastructureTechnology__GetQualifiedNameParts(), theEcorePackage.getEString(), "getQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getInfrastructureTechnology__BuildQualifiedName__String_boolean_boolean(), theEcorePackage.getEString(), "buildQualifiedName", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEString(), "separator", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEBoolean(), "withTechnologyName", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEBoolean(), "withNamespace", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEClass(technologyAspectEClass, TechnologyAspect.class, "TechnologyAspect", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTechnologyAspect_Name(), theEcorePackage.getEString(), "name", null, 0, 1, TechnologyAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTechnologyAspect_Features(), this.getAspectFeature(), "features", null, 0, -1, TechnologyAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTechnologyAspect_JoinPoints(), this.getJoinPointType(), "joinPoints", null, 1, -1, TechnologyAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologyAspect_Properties(), this.getTechnologySpecificProperty(), this.getTechnologySpecificProperty_TechnologyAspect(), "properties", null, 0, -1, TechnologyAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTechnologyAspect_IsSingleValued(), theEcorePackage.getEBoolean(), "isSingleValued", null, 0, 1, TechnologyAspect.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(serviceAspectEClass, ServiceAspect.class, "ServiceAspect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getServiceAspect_PointcutSelectors(), this.getServiceAspectPointcutSelector(), this.getServiceAspectPointcutSelector_ServiceAspect(), "pointcutSelectors", null, 0, -1, ServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getServiceAspect_Technology(), this.getTechnology(), this.getTechnology_ServiceAspects(), "technology", null, 0, 1, ServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        op = initEOperation(getServiceAspect__GetQualifiedNameParts__boolean_boolean(), theEcorePackage.getEString(), "getQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEBoolean(), "withTechnologyName", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEBoolean(), "withNamespace", 0, 1, !IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getServiceAspect__BuildQualifiedName__String_boolean_boolean(), theEcorePackage.getEString(), "buildQualifiedName", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEString(), "separator", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEBoolean(), "withTechnologyName", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEBoolean(), "withNamespace", 0, 1, !IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getServiceAspect__IsValidSelectorForJoinPoint__JoinPointType_ServiceAspectPointcutSelector(), theEcorePackage.getEBoolean(), "isValidSelectorForJoinPoint", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getJoinPointType(), "joinPoint", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getServiceAspectPointcutSelector(), "selector", 0, 1, !IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getServiceAspect__IsValidSelectorForJoinPoint__JoinPointType_ExchangePattern_CommunicationType_Protocol_DataFormat(), theEcorePackage.getEBoolean(), "isValidSelectorForJoinPoint", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getJoinPointType(), "joinPoint", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getExchangePattern(), "exchangePattern", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getCommunicationType(), "communicationType", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getProtocol(), "protocol", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getDataFormat(), "dataFormat", 0, 1, !IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getServiceAspect__HasMatchingSelector__ExchangePattern_CommunicationType_Protocol_DataFormat(), theEcorePackage.getEBoolean(), "hasMatchingSelector", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getExchangePattern(), "forExchangePattern", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getCommunicationType(), "forCommunicationType", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getProtocol(), "forProtocol", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getDataFormat(), "forDataFormat", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEClass(serviceAspectPointcutEClass, ServiceAspectPointcut.class, "ServiceAspectPointcut", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getServiceAspectPointcut_ForExchangePattern(), theEcorePackage.getEBoolean(), "forExchangePattern", null, 0, 1, ServiceAspectPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getServiceAspectPointcut_ForCommunicationType(), theEcorePackage.getEBoolean(), "forCommunicationType", null, 0, 1, ServiceAspectPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getServiceAspectPointcut_ForProtocol(), theEcorePackage.getEBoolean(), "forProtocol", null, 0, 1, ServiceAspectPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getServiceAspectPointcut_ForDataFormat(), theEcorePackage.getEBoolean(), "forDataFormat", null, 0, 1, ServiceAspectPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getServiceAspectPointcut_ExchangePattern(), this.getExchangePattern(), "exchangePattern", null, 0, 1, ServiceAspectPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getServiceAspectPointcut_CommunicationType(), this.getCommunicationType(), "communicationType", null, 0, 1, ServiceAspectPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getServiceAspectPointcut_Protocol(), this.getProtocol(), null, "protocol", null, 0, 1, ServiceAspectPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getServiceAspectPointcut_DataFormat(), this.getDataFormat(), null, "dataFormat", null, 0, 1, ServiceAspectPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getServiceAspectPointcut_Selector(), this.getServiceAspectPointcutSelector(), this.getServiceAspectPointcutSelector_Pointcuts(), "selector", null, 0, 1, ServiceAspectPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getServiceAspectPointcut_EffectiveType(), this.getPointcutType(), "effectiveType", null, 0, 1, ServiceAspectPointcut.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getServiceAspectPointcut_EffectiveSelectorName(), theEcorePackage.getEString(), "effectiveSelectorName", null, 0, 1, ServiceAspectPointcut.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getServiceAspectPointcut_EffectiveValue(), theEcorePackage.getEString(), "effectiveValue", null, 0, 1, ServiceAspectPointcut.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getServiceAspectPointcut_PrintableEffectiveValue(), theEcorePackage.getEString(), "printableEffectiveValue", null, 0, 1, ServiceAspectPointcut.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getServiceAspectPointcut_OrderedPointcutTypes(), this.getPointcutType(), "orderedPointcutTypes", null, 0, -1, ServiceAspectPointcut.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        op = initEOperation(getServiceAspectPointcut__IsValidSelectorFor__JoinPointType(), theEcorePackage.getEBoolean(), "isValidSelectorFor", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getJoinPointType(), "joinPoint", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEClass(serviceAspectPointcutSelectorEClass, ServiceAspectPointcutSelector.class, "ServiceAspectPointcutSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getServiceAspectPointcutSelector_Pointcuts(), this.getServiceAspectPointcut(), this.getServiceAspectPointcut_Selector(), "pointcuts", null, 1, -1, ServiceAspectPointcutSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getServiceAspectPointcutSelector_ServiceAspect(), this.getServiceAspect(), this.getServiceAspect_PointcutSelectors(), "serviceAspect", null, 0, 1, ServiceAspectPointcutSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getServiceAspectPointcutSelector_SelectorString(), theEcorePackage.getEString(), "selectorString", null, 0, 1, ServiceAspectPointcutSelector.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEOperation(getServiceAspectPointcutSelector__OrderedSelectorValues(), this.getPointcutTypeStringsMap(), "orderedSelectorValues", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEClass(operationAspectEClass, OperationAspect.class, "OperationAspect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getOperationAspect_PointcutSelectors(), this.getOperationAspectPointcutSelector(), this.getOperationAspectPointcutSelector_OperationAspect(), "pointcutSelectors", null, 0, -1, OperationAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationAspect_Technology(), this.getTechnology(), this.getTechnology_OperationAspects(), "technology", null, 0, 1, OperationAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        op = initEOperation(getOperationAspect__GetQualifiedNameParts__boolean_boolean(), theEcorePackage.getEString(), "getQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEBoolean(), "withTechnologyName", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEBoolean(), "withNamespace", 0, 1, !IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getOperationAspect__BuildQualifiedName__String_boolean_boolean(), theEcorePackage.getEString(), "buildQualifiedName", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEString(), "separator", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEBoolean(), "withTechnologyName", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEBoolean(), "withNamespace", 0, 1, !IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getOperationAspect__HasMatchingSelector__EObject(), theEcorePackage.getEBoolean(), "hasMatchingSelector", 0, 1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theEcorePackage.getEObject(), "forTechnology", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEClass(operationAspectPointcutEClass, OperationAspectPointcut.class, "OperationAspectPointcut", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getOperationAspectPointcut_ForTechnology(), theEcorePackage.getEBoolean(), "forTechnology", null, 0, 1, OperationAspectPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationAspectPointcut_Technology(), theEcorePackage.getEObject(), null, "technology", null, 0, 1, OperationAspectPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationAspectPointcut_Selector(), this.getOperationAspectPointcutSelector(), this.getOperationAspectPointcutSelector_Pointcuts(), "selector", null, 0, 1, OperationAspectPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getOperationAspectPointcut_EffectiveType(), this.getPointcutType(), "effectiveType", null, 0, 1, OperationAspectPointcut.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getOperationAspectPointcut_EffectiveSelectorName(), theEcorePackage.getEString(), "effectiveSelectorName", null, 0, 1, OperationAspectPointcut.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getOperationAspectPointcut_EffectiveValue(), theEcorePackage.getEString(), "effectiveValue", null, 0, 1, OperationAspectPointcut.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getOperationAspectPointcut_PrintableEffectiveValue(), theEcorePackage.getEString(), "printableEffectiveValue", null, 0, 1, OperationAspectPointcut.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getOperationAspectPointcut_OrderedPointcutTypes(), this.getPointcutType(), "orderedPointcutTypes", null, 0, -1, OperationAspectPointcut.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(operationAspectPointcutSelectorEClass, OperationAspectPointcutSelector.class, "OperationAspectPointcutSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getOperationAspectPointcutSelector_Pointcuts(), this.getOperationAspectPointcut(), this.getOperationAspectPointcut_Selector(), "pointcuts", null, 1, -1, OperationAspectPointcutSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationAspectPointcutSelector_OperationAspect(), this.getOperationAspect(), this.getOperationAspect_PointcutSelectors(), "operationAspect", null, 0, 1, OperationAspectPointcutSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getOperationAspectPointcutSelector_SelectorString(), theEcorePackage.getEString(), "selectorString", null, 0, 1, OperationAspectPointcutSelector.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEOperation(getOperationAspectPointcutSelector__OrderedSelectorValues(), this.getPointcutTypeStringsMap(), "orderedSelectorValues", 0, 1, !IS_UNIQUE, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(exchangePatternEEnum, ExchangePattern.class, "ExchangePattern");
        addEEnumLiteral(exchangePatternEEnum, ExchangePattern.IN);
        addEEnumLiteral(exchangePatternEEnum, ExchangePattern.OUT);
        addEEnumLiteral(exchangePatternEEnum, ExchangePattern.INOUT);

        initEEnum(communicationTypeEEnum, CommunicationType.class, "CommunicationType");
        addEEnumLiteral(communicationTypeEEnum, CommunicationType.SYNCHRONOUS);
        addEEnumLiteral(communicationTypeEEnum, CommunicationType.ASYNCHRONOUS);

        initEEnum(compatibilityDirectionEEnum, CompatibilityDirection.class, "CompatibilityDirection");
        addEEnumLiteral(compatibilityDirectionEEnum, CompatibilityDirection.MAPPING_TO_COMPATIBLE_TYPES);
        addEEnumLiteral(compatibilityDirectionEEnum, CompatibilityDirection.COMPATIBLE_TYPES_TO_MAPPING);
        addEEnumLiteral(compatibilityDirectionEEnum, CompatibilityDirection.BIDIRECTIONAL);

        initEEnum(propertyFeatureEEnum, PropertyFeature.class, "PropertyFeature");
        addEEnumLiteral(propertyFeatureEEnum, PropertyFeature.MANDATORY);
        addEEnumLiteral(propertyFeatureEEnum, PropertyFeature.SINGLE_VALUED);

        initEEnum(joinPointTypeEEnum, JoinPointType.class, "JoinPointType");
        addEEnumLiteral(joinPointTypeEEnum, JoinPointType.DATA_OPERATIONS);
        addEEnumLiteral(joinPointTypeEEnum, JoinPointType.DATA_OPERATION_PARAMETERS);
        addEEnumLiteral(joinPointTypeEEnum, JoinPointType.MICROSERVICES);
        addEEnumLiteral(joinPointTypeEEnum, JoinPointType.INTERFACES);
        addEEnumLiteral(joinPointTypeEEnum, JoinPointType.OPERATIONS);
        addEEnumLiteral(joinPointTypeEEnum, JoinPointType.PARAMETERS);
        addEEnumLiteral(joinPointTypeEEnum, JoinPointType.COMPLEX_TYPES);
        addEEnumLiteral(joinPointTypeEEnum, JoinPointType.DATA_FIELDS);
        addEEnumLiteral(joinPointTypeEEnum, JoinPointType.CONTAINERS);
        addEEnumLiteral(joinPointTypeEEnum, JoinPointType.INFRASTRUCTURE_NODES);

        initEEnum(pointcutTypeEEnum, PointcutType.class, "PointcutType");
        addEEnumLiteral(pointcutTypeEEnum, PointcutType.EXCHANGE_PATTERN);
        addEEnumLiteral(pointcutTypeEEnum, PointcutType.COMMUNICATION_TYPE);
        addEEnumLiteral(pointcutTypeEEnum, PointcutType.PROTOCOL);
        addEEnumLiteral(pointcutTypeEEnum, PointcutType.DATA_FORMAT);
        addEEnumLiteral(pointcutTypeEEnum, PointcutType.TECHNOLOGY);

        initEEnum(aspectFeatureEEnum, AspectFeature.class, "AspectFeature");
        addEEnumLiteral(aspectFeatureEEnum, AspectFeature.SINGLE_VALUED);

        // Initialize data types
        initEDataType(pointcutTypeStringsMapEDataType, Map.class, "PointcutTypeStringsMap", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.Map<de.fhdo.lemma.technology.PointcutType, java.util.List<java.lang.String>>");

        // Create resource
        createResource(eNS_URI);
    }

} //TechnologyPackageImpl
