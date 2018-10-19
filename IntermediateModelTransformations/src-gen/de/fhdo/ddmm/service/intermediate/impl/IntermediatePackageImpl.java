/**
 */
package de.fhdo.ddmm.service.intermediate.impl;

import de.fhdo.ddmm.data.DataPackage;

import de.fhdo.ddmm.service.ServicePackage;

import de.fhdo.ddmm.service.intermediate.InterfaceReference;
import de.fhdo.ddmm.service.intermediate.IntermediateAspectProperty;
import de.fhdo.ddmm.service.intermediate.IntermediateAspectPropertyValue;
import de.fhdo.ddmm.service.intermediate.IntermediateEndpoint;
import de.fhdo.ddmm.service.intermediate.IntermediateFactory;
import de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect;
import de.fhdo.ddmm.service.intermediate.IntermediateImportedTechnologySpecificType;
import de.fhdo.ddmm.service.intermediate.IntermediateInterface;
import de.fhdo.ddmm.service.intermediate.IntermediateMappedDataField;
import de.fhdo.ddmm.service.intermediate.IntermediateMicroservice;
import de.fhdo.ddmm.service.intermediate.IntermediateOperation;
import de.fhdo.ddmm.service.intermediate.IntermediatePackage;
import de.fhdo.ddmm.service.intermediate.IntermediateParameter;
import de.fhdo.ddmm.service.intermediate.IntermediateProtocolSpecification;
import de.fhdo.ddmm.service.intermediate.IntermediateReferredOperation;
import de.fhdo.ddmm.service.intermediate.IntermediateServiceModel;
import de.fhdo.ddmm.service.intermediate.IntermediateTechnology;
import de.fhdo.ddmm.service.intermediate.MicroserviceReference;
import de.fhdo.ddmm.service.intermediate.OperationReference;

import de.fhdo.ddmm.technology.TechnologyPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
    private EClass intermediateServiceModelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateMicroserviceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateInterfaceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateOperationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateReferredOperationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateParameterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateMappedDataFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass microserviceReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass interfaceReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass operationReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateTechnologyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateEndpointEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass intermediateProtocolSpecificationEClass = null;

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
    private EClass intermediateImportedTechnologySpecificTypeEClass = null;

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
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#eNS_URI
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
        de.fhdo.ddmm.data.intermediate.IntermediatePackage.eINSTANCE.eClass();
        EcorePackage.eINSTANCE.eClass();
        ServicePackage.eINSTANCE.eClass();
        TechnologyPackage.eINSTANCE.eClass();
        DataPackage.eINSTANCE.eClass();

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
    public EClass getIntermediateServiceModel() {
        return intermediateServiceModelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateServiceModel_Imports() {
        return (EReference)intermediateServiceModelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateServiceModel_Microservices() {
        return (EReference)intermediateServiceModelEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateMicroservice() {
        return intermediateMicroserviceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateMicroservice_Name() {
        return (EAttribute)intermediateMicroserviceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateMicroservice_Version() {
        return (EAttribute)intermediateMicroserviceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateMicroservice_QualifiedName() {
        return (EAttribute)intermediateMicroserviceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateMicroservice_Type() {
        return (EAttribute)intermediateMicroserviceEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateMicroservice_Visibility() {
        return (EAttribute)intermediateMicroserviceEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateMicroservice_EffectivelyImplemented() {
        return (EAttribute)intermediateMicroserviceEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateMicroservice_Technologies() {
        return (EReference)intermediateMicroserviceEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateMicroservice_Endpoints() {
        return (EReference)intermediateMicroserviceEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateMicroservice_Protocols() {
        return (EReference)intermediateMicroserviceEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateMicroservice_RequiredMicroservices() {
        return (EReference)intermediateMicroserviceEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateMicroservice_RequiredInterfaces() {
        return (EReference)intermediateMicroserviceEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateMicroservice_RequiredOperations() {
        return (EReference)intermediateMicroserviceEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateMicroservice_Interfaces() {
        return (EReference)intermediateMicroserviceEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateMicroservice_Aspects() {
        return (EReference)intermediateMicroserviceEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateMicroservice_ServiceModel() {
        return (EReference)intermediateMicroserviceEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateInterface() {
        return intermediateInterfaceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateInterface_Name() {
        return (EAttribute)intermediateInterfaceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateInterface_QualifiedName() {
        return (EAttribute)intermediateInterfaceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateInterface_Visibility() {
        return (EAttribute)intermediateInterfaceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateInterface_NotImplemented() {
        return (EAttribute)intermediateInterfaceEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateInterface_HasImplementedOperations() {
        return (EAttribute)intermediateInterfaceEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateInterface_Endpoints() {
        return (EReference)intermediateInterfaceEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateInterface_Protocols() {
        return (EReference)intermediateInterfaceEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateInterface_Operations() {
        return (EReference)intermediateInterfaceEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateInterface_ReferredOperations() {
        return (EReference)intermediateInterfaceEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateInterface_Aspects() {
        return (EReference)intermediateInterfaceEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateInterface_Microservice() {
        return (EReference)intermediateInterfaceEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateOperation() {
        return intermediateOperationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateOperation_Name() {
        return (EAttribute)intermediateOperationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateOperation_QualifiedName() {
        return (EAttribute)intermediateOperationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateOperation_Visibility() {
        return (EAttribute)intermediateOperationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateOperation_NotImplemented() {
        return (EAttribute)intermediateOperationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateOperation_Endpoints() {
        return (EReference)intermediateOperationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateOperation_Protocols() {
        return (EReference)intermediateOperationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateOperation_Aspects() {
        return (EReference)intermediateOperationEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateOperation_Parameters() {
        return (EReference)intermediateOperationEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateOperation_Interface() {
        return (EReference)intermediateOperationEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateReferredOperation() {
        return intermediateReferredOperationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateReferredOperation_NameInReferringInterface() {
        return (EAttribute)intermediateReferredOperationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateReferredOperation_QualifiedNameInReferringInterface() {
        return (EAttribute)intermediateReferredOperationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateReferredOperation_Operation() {
        return (EReference)intermediateReferredOperationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateReferredOperation_Endpoints() {
        return (EReference)intermediateReferredOperationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateReferredOperation_Protocols() {
        return (EReference)intermediateReferredOperationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateReferredOperation_Aspects() {
        return (EReference)intermediateReferredOperationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateReferredOperation_ReferringInterface() {
        return (EReference)intermediateReferredOperationEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateParameter() {
        return intermediateParameterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateParameter_Name() {
        return (EAttribute)intermediateParameterEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateParameter_QualifiedName() {
        return (EAttribute)intermediateParameterEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateParameter_ExchangePattern() {
        return (EAttribute)intermediateParameterEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateParameter_CommunicationType() {
        return (EAttribute)intermediateParameterEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateParameter_CommunicatesFault() {
        return (EAttribute)intermediateParameterEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateParameter_Optional() {
        return (EAttribute)intermediateParameterEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateParameter_Type() {
        return (EReference)intermediateParameterEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateParameter_InitializedByOperation() {
        return (EReference)intermediateParameterEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateParameter_Aspects() {
        return (EReference)intermediateParameterEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateParameter_MappedDataFields() {
        return (EReference)intermediateParameterEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateParameter_Operation() {
        return (EReference)intermediateParameterEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateMappedDataField() {
        return intermediateMappedDataFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateMappedDataField_MappedDataFieldName() {
        return (EAttribute)intermediateMappedDataFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateMappedDataField_QualifiedName() {
        return (EAttribute)intermediateMappedDataFieldEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateMappedDataField_MappedType() {
        return (EReference)intermediateMappedDataFieldEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateMappedDataField_Aspects() {
        return (EReference)intermediateMappedDataFieldEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateMappedDataField_Parameter() {
        return (EReference)intermediateMappedDataFieldEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMicroserviceReference() {
        return microserviceReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMicroserviceReference_Name() {
        return (EAttribute)microserviceReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMicroserviceReference_Version() {
        return (EAttribute)microserviceReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMicroserviceReference_QualifiedName() {
        return (EAttribute)microserviceReferenceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMicroserviceReference_Imported() {
        return (EAttribute)microserviceReferenceEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceReference_Import() {
        return (EReference)microserviceReferenceEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceReference_LocalMicroservice() {
        return (EReference)microserviceReferenceEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceReference_RequiringMicroservice() {
        return (EReference)microserviceReferenceEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInterfaceReference() {
        return interfaceReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getInterfaceReference_Name() {
        return (EAttribute)interfaceReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getInterfaceReference_QualifiedName() {
        return (EAttribute)interfaceReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getInterfaceReference_Imported() {
        return (EAttribute)interfaceReferenceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInterfaceReference_Import() {
        return (EReference)interfaceReferenceEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInterfaceReference_LocalInterface() {
        return (EReference)interfaceReferenceEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInterfaceReference_RequiringMicroservice() {
        return (EReference)interfaceReferenceEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOperationReference() {
        return operationReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperationReference_Name() {
        return (EAttribute)operationReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperationReference_QualifiedName() {
        return (EAttribute)operationReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperationReference_Imported() {
        return (EAttribute)operationReferenceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationReference_Import() {
        return (EReference)operationReferenceEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationReference_LocalOperation() {
        return (EReference)operationReferenceEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationReference_RequiringMicroservice() {
        return (EReference)operationReferenceEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationReference_InitializedParameter() {
        return (EReference)operationReferenceEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateTechnology() {
        return intermediateTechnologyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateTechnology_Name() {
        return (EAttribute)intermediateTechnologyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateTechnology_Import() {
        return (EReference)intermediateTechnologyEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateTechnology_Microservice() {
        return (EReference)intermediateTechnologyEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateEndpoint() {
        return intermediateEndpointEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateEndpoint_CommunicationType() {
        return (EAttribute)intermediateEndpointEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateEndpoint_Protocol() {
        return (EAttribute)intermediateEndpointEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateEndpoint_DataFormat() {
        return (EAttribute)intermediateEndpointEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateEndpoint_Addresses() {
        return (EAttribute)intermediateEndpointEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateEndpoint_Technology() {
        return (EReference)intermediateEndpointEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateEndpoint_Microservice() {
        return (EReference)intermediateEndpointEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateEndpoint_Interface() {
        return (EReference)intermediateEndpointEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateEndpoint_Operation() {
        return (EReference)intermediateEndpointEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateEndpoint_ReferredOperation() {
        return (EReference)intermediateEndpointEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntermediateProtocolSpecification() {
        return intermediateProtocolSpecificationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateProtocolSpecification_CommunicationType() {
        return (EAttribute)intermediateProtocolSpecificationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateProtocolSpecification_Protocol() {
        return (EAttribute)intermediateProtocolSpecificationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntermediateProtocolSpecification_DataFormat() {
        return (EAttribute)intermediateProtocolSpecificationEClass.getEStructuralFeatures().get(2);
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
    public EReference getIntermediateImportedAspect_Import() {
        return (EReference)intermediateImportedAspectEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateImportedAspect_Properties() {
        return (EReference)intermediateImportedAspectEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateImportedAspect_PropertyValues() {
        return (EReference)intermediateImportedAspectEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateImportedAspect_Microservice() {
        return (EReference)intermediateImportedAspectEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateImportedAspect_Interface() {
        return (EReference)intermediateImportedAspectEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateImportedAspect_Operation() {
        return (EReference)intermediateImportedAspectEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateImportedAspect_ReferredOperation() {
        return (EReference)intermediateImportedAspectEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateImportedAspect_Parameter() {
        return (EReference)intermediateImportedAspectEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIntermediateImportedAspect_MappedDataField() {
        return (EReference)intermediateImportedAspectEClass.getEStructuralFeatures().get(9);
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
    public EAttribute getIntermediateAspectProperty_Mandatory() {
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
        intermediateServiceModelEClass = createEClass(INTERMEDIATE_SERVICE_MODEL);
        createEReference(intermediateServiceModelEClass, INTERMEDIATE_SERVICE_MODEL__IMPORTS);
        createEReference(intermediateServiceModelEClass, INTERMEDIATE_SERVICE_MODEL__MICROSERVICES);

        intermediateMicroserviceEClass = createEClass(INTERMEDIATE_MICROSERVICE);
        createEAttribute(intermediateMicroserviceEClass, INTERMEDIATE_MICROSERVICE__NAME);
        createEAttribute(intermediateMicroserviceEClass, INTERMEDIATE_MICROSERVICE__VERSION);
        createEAttribute(intermediateMicroserviceEClass, INTERMEDIATE_MICROSERVICE__QUALIFIED_NAME);
        createEAttribute(intermediateMicroserviceEClass, INTERMEDIATE_MICROSERVICE__TYPE);
        createEAttribute(intermediateMicroserviceEClass, INTERMEDIATE_MICROSERVICE__VISIBILITY);
        createEAttribute(intermediateMicroserviceEClass, INTERMEDIATE_MICROSERVICE__EFFECTIVELY_IMPLEMENTED);
        createEReference(intermediateMicroserviceEClass, INTERMEDIATE_MICROSERVICE__TECHNOLOGIES);
        createEReference(intermediateMicroserviceEClass, INTERMEDIATE_MICROSERVICE__ENDPOINTS);
        createEReference(intermediateMicroserviceEClass, INTERMEDIATE_MICROSERVICE__PROTOCOLS);
        createEReference(intermediateMicroserviceEClass, INTERMEDIATE_MICROSERVICE__REQUIRED_MICROSERVICES);
        createEReference(intermediateMicroserviceEClass, INTERMEDIATE_MICROSERVICE__REQUIRED_INTERFACES);
        createEReference(intermediateMicroserviceEClass, INTERMEDIATE_MICROSERVICE__REQUIRED_OPERATIONS);
        createEReference(intermediateMicroserviceEClass, INTERMEDIATE_MICROSERVICE__INTERFACES);
        createEReference(intermediateMicroserviceEClass, INTERMEDIATE_MICROSERVICE__ASPECTS);
        createEReference(intermediateMicroserviceEClass, INTERMEDIATE_MICROSERVICE__SERVICE_MODEL);

        intermediateInterfaceEClass = createEClass(INTERMEDIATE_INTERFACE);
        createEAttribute(intermediateInterfaceEClass, INTERMEDIATE_INTERFACE__NAME);
        createEAttribute(intermediateInterfaceEClass, INTERMEDIATE_INTERFACE__QUALIFIED_NAME);
        createEAttribute(intermediateInterfaceEClass, INTERMEDIATE_INTERFACE__VISIBILITY);
        createEAttribute(intermediateInterfaceEClass, INTERMEDIATE_INTERFACE__NOT_IMPLEMENTED);
        createEAttribute(intermediateInterfaceEClass, INTERMEDIATE_INTERFACE__HAS_IMPLEMENTED_OPERATIONS);
        createEReference(intermediateInterfaceEClass, INTERMEDIATE_INTERFACE__ENDPOINTS);
        createEReference(intermediateInterfaceEClass, INTERMEDIATE_INTERFACE__PROTOCOLS);
        createEReference(intermediateInterfaceEClass, INTERMEDIATE_INTERFACE__OPERATIONS);
        createEReference(intermediateInterfaceEClass, INTERMEDIATE_INTERFACE__REFERRED_OPERATIONS);
        createEReference(intermediateInterfaceEClass, INTERMEDIATE_INTERFACE__ASPECTS);
        createEReference(intermediateInterfaceEClass, INTERMEDIATE_INTERFACE__MICROSERVICE);

        intermediateOperationEClass = createEClass(INTERMEDIATE_OPERATION);
        createEAttribute(intermediateOperationEClass, INTERMEDIATE_OPERATION__NAME);
        createEAttribute(intermediateOperationEClass, INTERMEDIATE_OPERATION__QUALIFIED_NAME);
        createEAttribute(intermediateOperationEClass, INTERMEDIATE_OPERATION__VISIBILITY);
        createEAttribute(intermediateOperationEClass, INTERMEDIATE_OPERATION__NOT_IMPLEMENTED);
        createEReference(intermediateOperationEClass, INTERMEDIATE_OPERATION__ENDPOINTS);
        createEReference(intermediateOperationEClass, INTERMEDIATE_OPERATION__PROTOCOLS);
        createEReference(intermediateOperationEClass, INTERMEDIATE_OPERATION__ASPECTS);
        createEReference(intermediateOperationEClass, INTERMEDIATE_OPERATION__PARAMETERS);
        createEReference(intermediateOperationEClass, INTERMEDIATE_OPERATION__INTERFACE);

        intermediateReferredOperationEClass = createEClass(INTERMEDIATE_REFERRED_OPERATION);
        createEAttribute(intermediateReferredOperationEClass, INTERMEDIATE_REFERRED_OPERATION__NAME_IN_REFERRING_INTERFACE);
        createEAttribute(intermediateReferredOperationEClass, INTERMEDIATE_REFERRED_OPERATION__QUALIFIED_NAME_IN_REFERRING_INTERFACE);
        createEReference(intermediateReferredOperationEClass, INTERMEDIATE_REFERRED_OPERATION__OPERATION);
        createEReference(intermediateReferredOperationEClass, INTERMEDIATE_REFERRED_OPERATION__ENDPOINTS);
        createEReference(intermediateReferredOperationEClass, INTERMEDIATE_REFERRED_OPERATION__PROTOCOLS);
        createEReference(intermediateReferredOperationEClass, INTERMEDIATE_REFERRED_OPERATION__ASPECTS);
        createEReference(intermediateReferredOperationEClass, INTERMEDIATE_REFERRED_OPERATION__REFERRING_INTERFACE);

        intermediateParameterEClass = createEClass(INTERMEDIATE_PARAMETER);
        createEAttribute(intermediateParameterEClass, INTERMEDIATE_PARAMETER__NAME);
        createEAttribute(intermediateParameterEClass, INTERMEDIATE_PARAMETER__QUALIFIED_NAME);
        createEAttribute(intermediateParameterEClass, INTERMEDIATE_PARAMETER__EXCHANGE_PATTERN);
        createEAttribute(intermediateParameterEClass, INTERMEDIATE_PARAMETER__COMMUNICATION_TYPE);
        createEAttribute(intermediateParameterEClass, INTERMEDIATE_PARAMETER__COMMUNICATES_FAULT);
        createEAttribute(intermediateParameterEClass, INTERMEDIATE_PARAMETER__OPTIONAL);
        createEReference(intermediateParameterEClass, INTERMEDIATE_PARAMETER__TYPE);
        createEReference(intermediateParameterEClass, INTERMEDIATE_PARAMETER__INITIALIZED_BY_OPERATION);
        createEReference(intermediateParameterEClass, INTERMEDIATE_PARAMETER__ASPECTS);
        createEReference(intermediateParameterEClass, INTERMEDIATE_PARAMETER__MAPPED_DATA_FIELDS);
        createEReference(intermediateParameterEClass, INTERMEDIATE_PARAMETER__OPERATION);

        intermediateMappedDataFieldEClass = createEClass(INTERMEDIATE_MAPPED_DATA_FIELD);
        createEAttribute(intermediateMappedDataFieldEClass, INTERMEDIATE_MAPPED_DATA_FIELD__MAPPED_DATA_FIELD_NAME);
        createEAttribute(intermediateMappedDataFieldEClass, INTERMEDIATE_MAPPED_DATA_FIELD__QUALIFIED_NAME);
        createEReference(intermediateMappedDataFieldEClass, INTERMEDIATE_MAPPED_DATA_FIELD__MAPPED_TYPE);
        createEReference(intermediateMappedDataFieldEClass, INTERMEDIATE_MAPPED_DATA_FIELD__ASPECTS);
        createEReference(intermediateMappedDataFieldEClass, INTERMEDIATE_MAPPED_DATA_FIELD__PARAMETER);

        microserviceReferenceEClass = createEClass(MICROSERVICE_REFERENCE);
        createEAttribute(microserviceReferenceEClass, MICROSERVICE_REFERENCE__NAME);
        createEAttribute(microserviceReferenceEClass, MICROSERVICE_REFERENCE__VERSION);
        createEAttribute(microserviceReferenceEClass, MICROSERVICE_REFERENCE__QUALIFIED_NAME);
        createEAttribute(microserviceReferenceEClass, MICROSERVICE_REFERENCE__IMPORTED);
        createEReference(microserviceReferenceEClass, MICROSERVICE_REFERENCE__IMPORT);
        createEReference(microserviceReferenceEClass, MICROSERVICE_REFERENCE__LOCAL_MICROSERVICE);
        createEReference(microserviceReferenceEClass, MICROSERVICE_REFERENCE__REQUIRING_MICROSERVICE);

        interfaceReferenceEClass = createEClass(INTERFACE_REFERENCE);
        createEAttribute(interfaceReferenceEClass, INTERFACE_REFERENCE__NAME);
        createEAttribute(interfaceReferenceEClass, INTERFACE_REFERENCE__QUALIFIED_NAME);
        createEAttribute(interfaceReferenceEClass, INTERFACE_REFERENCE__IMPORTED);
        createEReference(interfaceReferenceEClass, INTERFACE_REFERENCE__IMPORT);
        createEReference(interfaceReferenceEClass, INTERFACE_REFERENCE__LOCAL_INTERFACE);
        createEReference(interfaceReferenceEClass, INTERFACE_REFERENCE__REQUIRING_MICROSERVICE);

        operationReferenceEClass = createEClass(OPERATION_REFERENCE);
        createEAttribute(operationReferenceEClass, OPERATION_REFERENCE__NAME);
        createEAttribute(operationReferenceEClass, OPERATION_REFERENCE__QUALIFIED_NAME);
        createEAttribute(operationReferenceEClass, OPERATION_REFERENCE__IMPORTED);
        createEReference(operationReferenceEClass, OPERATION_REFERENCE__IMPORT);
        createEReference(operationReferenceEClass, OPERATION_REFERENCE__LOCAL_OPERATION);
        createEReference(operationReferenceEClass, OPERATION_REFERENCE__REQUIRING_MICROSERVICE);
        createEReference(operationReferenceEClass, OPERATION_REFERENCE__INITIALIZED_PARAMETER);

        intermediateTechnologyEClass = createEClass(INTERMEDIATE_TECHNOLOGY);
        createEAttribute(intermediateTechnologyEClass, INTERMEDIATE_TECHNOLOGY__NAME);
        createEReference(intermediateTechnologyEClass, INTERMEDIATE_TECHNOLOGY__IMPORT);
        createEReference(intermediateTechnologyEClass, INTERMEDIATE_TECHNOLOGY__MICROSERVICE);

        intermediateEndpointEClass = createEClass(INTERMEDIATE_ENDPOINT);
        createEAttribute(intermediateEndpointEClass, INTERMEDIATE_ENDPOINT__COMMUNICATION_TYPE);
        createEAttribute(intermediateEndpointEClass, INTERMEDIATE_ENDPOINT__PROTOCOL);
        createEAttribute(intermediateEndpointEClass, INTERMEDIATE_ENDPOINT__DATA_FORMAT);
        createEAttribute(intermediateEndpointEClass, INTERMEDIATE_ENDPOINT__ADDRESSES);
        createEReference(intermediateEndpointEClass, INTERMEDIATE_ENDPOINT__TECHNOLOGY);
        createEReference(intermediateEndpointEClass, INTERMEDIATE_ENDPOINT__MICROSERVICE);
        createEReference(intermediateEndpointEClass, INTERMEDIATE_ENDPOINT__INTERFACE);
        createEReference(intermediateEndpointEClass, INTERMEDIATE_ENDPOINT__OPERATION);
        createEReference(intermediateEndpointEClass, INTERMEDIATE_ENDPOINT__REFERRED_OPERATION);

        intermediateProtocolSpecificationEClass = createEClass(INTERMEDIATE_PROTOCOL_SPECIFICATION);
        createEAttribute(intermediateProtocolSpecificationEClass, INTERMEDIATE_PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE);
        createEAttribute(intermediateProtocolSpecificationEClass, INTERMEDIATE_PROTOCOL_SPECIFICATION__PROTOCOL);
        createEAttribute(intermediateProtocolSpecificationEClass, INTERMEDIATE_PROTOCOL_SPECIFICATION__DATA_FORMAT);

        intermediateImportedAspectEClass = createEClass(INTERMEDIATE_IMPORTED_ASPECT);
        createEAttribute(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__NAME);
        createEReference(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__IMPORT);
        createEReference(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__PROPERTIES);
        createEReference(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__PROPERTY_VALUES);
        createEReference(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__MICROSERVICE);
        createEReference(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__INTERFACE);
        createEReference(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__OPERATION);
        createEReference(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__REFERRED_OPERATION);
        createEReference(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__PARAMETER);
        createEReference(intermediateImportedAspectEClass, INTERMEDIATE_IMPORTED_ASPECT__MAPPED_DATA_FIELD);

        intermediateAspectPropertyEClass = createEClass(INTERMEDIATE_ASPECT_PROPERTY);
        createEAttribute(intermediateAspectPropertyEClass, INTERMEDIATE_ASPECT_PROPERTY__NAME);
        createEAttribute(intermediateAspectPropertyEClass, INTERMEDIATE_ASPECT_PROPERTY__TYPE);
        createEAttribute(intermediateAspectPropertyEClass, INTERMEDIATE_ASPECT_PROPERTY__DEFAULT_VALUE);
        createEAttribute(intermediateAspectPropertyEClass, INTERMEDIATE_ASPECT_PROPERTY__MANDATORY);
        createEReference(intermediateAspectPropertyEClass, INTERMEDIATE_ASPECT_PROPERTY__ASPECT);

        intermediateAspectPropertyValueEClass = createEClass(INTERMEDIATE_ASPECT_PROPERTY_VALUE);
        createEAttribute(intermediateAspectPropertyValueEClass, INTERMEDIATE_ASPECT_PROPERTY_VALUE__VALUE);
        createEReference(intermediateAspectPropertyValueEClass, INTERMEDIATE_ASPECT_PROPERTY_VALUE__PROPERTY);
        createEReference(intermediateAspectPropertyValueEClass, INTERMEDIATE_ASPECT_PROPERTY_VALUE__ASPECT);

        intermediateImportedTechnologySpecificTypeEClass = createEClass(INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE);
        createEAttribute(intermediateImportedTechnologySpecificTypeEClass, INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__QUALIFIED_NAME);
        createEReference(intermediateImportedTechnologySpecificTypeEClass, INTERMEDIATE_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__IMPORT);
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
        de.fhdo.ddmm.data.intermediate.IntermediatePackage theIntermediatePackage_1 = (de.fhdo.ddmm.data.intermediate.IntermediatePackage)EPackage.Registry.INSTANCE.getEPackage(de.fhdo.ddmm.data.intermediate.IntermediatePackage.eNS_URI);
        EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
        ServicePackage theServicePackage = (ServicePackage)EPackage.Registry.INSTANCE.getEPackage(ServicePackage.eNS_URI);
        TechnologyPackage theTechnologyPackage = (TechnologyPackage)EPackage.Registry.INSTANCE.getEPackage(TechnologyPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        intermediateImportedTechnologySpecificTypeEClass.getESuperTypes().add(theIntermediatePackage_1.getIntermediateType());

        // Initialize classes, features, and operations; add parameters
        initEClass(intermediateServiceModelEClass, IntermediateServiceModel.class, "IntermediateServiceModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getIntermediateServiceModel_Imports(), theIntermediatePackage_1.getIntermediateImport(), null, "imports", null, 0, -1, IntermediateServiceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateServiceModel_Microservices(), this.getIntermediateMicroservice(), this.getIntermediateMicroservice_ServiceModel(), "microservices", null, 1, -1, IntermediateServiceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateMicroserviceEClass, IntermediateMicroservice.class, "IntermediateMicroservice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateMicroservice_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateMicroservice_Version(), theEcorePackage.getEString(), "version", null, 0, 1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateMicroservice_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateMicroservice_Type(), theServicePackage.getMicroserviceType(), "type", null, 0, 1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateMicroservice_Visibility(), theServicePackage.getVisibility(), "visibility", null, 0, 1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateMicroservice_EffectivelyImplemented(), theEcorePackage.getEBoolean(), "effectivelyImplemented", null, 0, 1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateMicroservice_Technologies(), this.getIntermediateTechnology(), this.getIntermediateTechnology_Microservice(), "technologies", null, 0, -1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateMicroservice_Endpoints(), this.getIntermediateEndpoint(), this.getIntermediateEndpoint_Microservice(), "endpoints", null, 0, -1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateMicroservice_Protocols(), this.getIntermediateProtocolSpecification(), null, "protocols", null, 0, 2, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateMicroservice_RequiredMicroservices(), this.getMicroserviceReference(), this.getMicroserviceReference_RequiringMicroservice(), "requiredMicroservices", null, 0, -1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateMicroservice_RequiredInterfaces(), this.getInterfaceReference(), this.getInterfaceReference_RequiringMicroservice(), "requiredInterfaces", null, 0, -1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateMicroservice_RequiredOperations(), this.getOperationReference(), this.getOperationReference_RequiringMicroservice(), "requiredOperations", null, 0, -1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateMicroservice_Interfaces(), this.getIntermediateInterface(), this.getIntermediateInterface_Microservice(), "interfaces", null, 1, -1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateMicroservice_Aspects(), this.getIntermediateImportedAspect(), this.getIntermediateImportedAspect_Microservice(), "aspects", null, 0, -1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateMicroservice_ServiceModel(), this.getIntermediateServiceModel(), this.getIntermediateServiceModel_Microservices(), "serviceModel", null, 0, 1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateInterfaceEClass, IntermediateInterface.class, "IntermediateInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateInterface_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateInterface_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateInterface_Visibility(), theServicePackage.getVisibility(), "visibility", null, 0, 1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateInterface_NotImplemented(), theEcorePackage.getEBoolean(), "notImplemented", null, 0, 1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateInterface_HasImplementedOperations(), theEcorePackage.getEBoolean(), "hasImplementedOperations", null, 0, 1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateInterface_Endpoints(), this.getIntermediateEndpoint(), this.getIntermediateEndpoint_Interface(), "endpoints", null, 0, -1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateInterface_Protocols(), this.getIntermediateProtocolSpecification(), null, "protocols", null, 0, 2, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateInterface_Operations(), this.getIntermediateOperation(), this.getIntermediateOperation_Interface(), "operations", null, 0, -1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateInterface_ReferredOperations(), this.getIntermediateReferredOperation(), this.getIntermediateReferredOperation_ReferringInterface(), "referredOperations", null, 0, -1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateInterface_Aspects(), this.getIntermediateImportedAspect(), this.getIntermediateImportedAspect_Interface(), "aspects", null, 0, -1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateInterface_Microservice(), this.getIntermediateMicroservice(), this.getIntermediateMicroservice_Interfaces(), "microservice", null, 0, 1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateOperationEClass, IntermediateOperation.class, "IntermediateOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateOperation_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateOperation_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, IntermediateOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateOperation_Visibility(), theServicePackage.getVisibility(), "visibility", null, 0, 1, IntermediateOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateOperation_NotImplemented(), theEcorePackage.getEBoolean(), "notImplemented", null, 0, 1, IntermediateOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateOperation_Endpoints(), this.getIntermediateEndpoint(), this.getIntermediateEndpoint_Operation(), "endpoints", null, 0, -1, IntermediateOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateOperation_Protocols(), this.getIntermediateProtocolSpecification(), null, "protocols", null, 0, 2, IntermediateOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateOperation_Aspects(), this.getIntermediateImportedAspect(), this.getIntermediateImportedAspect_Operation(), "aspects", null, 0, -1, IntermediateOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateOperation_Parameters(), this.getIntermediateParameter(), this.getIntermediateParameter_Operation(), "parameters", null, 0, -1, IntermediateOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateOperation_Interface(), this.getIntermediateInterface(), this.getIntermediateInterface_Operations(), "interface", null, 0, 1, IntermediateOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateReferredOperationEClass, IntermediateReferredOperation.class, "IntermediateReferredOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateReferredOperation_NameInReferringInterface(), theEcorePackage.getEString(), "nameInReferringInterface", null, 0, 1, IntermediateReferredOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateReferredOperation_QualifiedNameInReferringInterface(), theEcorePackage.getEString(), "qualifiedNameInReferringInterface", null, 0, 1, IntermediateReferredOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateReferredOperation_Operation(), this.getIntermediateOperation(), null, "operation", null, 0, 1, IntermediateReferredOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateReferredOperation_Endpoints(), this.getIntermediateEndpoint(), this.getIntermediateEndpoint_ReferredOperation(), "endpoints", null, 0, -1, IntermediateReferredOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateReferredOperation_Protocols(), this.getIntermediateProtocolSpecification(), null, "protocols", null, 0, 2, IntermediateReferredOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateReferredOperation_Aspects(), this.getIntermediateImportedAspect(), this.getIntermediateImportedAspect_ReferredOperation(), "aspects", null, 0, -1, IntermediateReferredOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateReferredOperation_ReferringInterface(), this.getIntermediateInterface(), this.getIntermediateInterface_ReferredOperations(), "referringInterface", null, 0, 1, IntermediateReferredOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateParameterEClass, IntermediateParameter.class, "IntermediateParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateParameter_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateParameter_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateParameter_ExchangePattern(), theTechnologyPackage.getExchangePattern(), "exchangePattern", null, 0, 1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateParameter_CommunicationType(), theTechnologyPackage.getCommunicationType(), "communicationType", null, 0, 1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateParameter_CommunicatesFault(), theEcorePackage.getEBoolean(), "communicatesFault", null, 0, 1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateParameter_Optional(), theEcorePackage.getEBoolean(), "optional", null, 0, 1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateParameter_Type(), theIntermediatePackage_1.getIntermediateType(), null, "type", null, 0, 1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateParameter_InitializedByOperation(), this.getOperationReference(), this.getOperationReference_InitializedParameter(), "initializedByOperation", null, 0, 1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateParameter_Aspects(), this.getIntermediateImportedAspect(), this.getIntermediateImportedAspect_Parameter(), "aspects", null, 0, -1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateParameter_MappedDataFields(), this.getIntermediateMappedDataField(), this.getIntermediateMappedDataField_Parameter(), "mappedDataFields", null, 0, -1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateParameter_Operation(), this.getIntermediateOperation(), this.getIntermediateOperation_Parameters(), "operation", null, 0, 1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateMappedDataFieldEClass, IntermediateMappedDataField.class, "IntermediateMappedDataField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateMappedDataField_MappedDataFieldName(), theEcorePackage.getEString(), "mappedDataFieldName", null, 0, 1, IntermediateMappedDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateMappedDataField_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, IntermediateMappedDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateMappedDataField_MappedType(), theIntermediatePackage_1.getIntermediateType(), null, "mappedType", null, 0, 1, IntermediateMappedDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateMappedDataField_Aspects(), this.getIntermediateImportedAspect(), this.getIntermediateImportedAspect_MappedDataField(), "aspects", null, 0, -1, IntermediateMappedDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateMappedDataField_Parameter(), this.getIntermediateParameter(), this.getIntermediateParameter_MappedDataFields(), "parameter", null, 0, 1, IntermediateMappedDataField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(microserviceReferenceEClass, MicroserviceReference.class, "MicroserviceReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getMicroserviceReference_Name(), theEcorePackage.getEString(), "name", null, 0, 1, MicroserviceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMicroserviceReference_Version(), theEcorePackage.getEString(), "version", null, 0, 1, MicroserviceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMicroserviceReference_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, MicroserviceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMicroserviceReference_Imported(), theEcorePackage.getEBoolean(), "imported", "false", 0, 1, MicroserviceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicroserviceReference_Import(), theIntermediatePackage_1.getIntermediateImport(), null, "import", null, 0, 1, MicroserviceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicroserviceReference_LocalMicroservice(), this.getIntermediateMicroservice(), null, "localMicroservice", null, 0, 1, MicroserviceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicroserviceReference_RequiringMicroservice(), this.getIntermediateMicroservice(), this.getIntermediateMicroservice_RequiredMicroservices(), "requiringMicroservice", null, 0, 1, MicroserviceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(interfaceReferenceEClass, InterfaceReference.class, "InterfaceReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getInterfaceReference_Name(), theEcorePackage.getEString(), "name", null, 0, 1, InterfaceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getInterfaceReference_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, InterfaceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getInterfaceReference_Imported(), theEcorePackage.getEBoolean(), "imported", "false", 0, 1, InterfaceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInterfaceReference_Import(), theIntermediatePackage_1.getIntermediateImport(), null, "import", null, 0, 1, InterfaceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInterfaceReference_LocalInterface(), this.getIntermediateInterface(), null, "localInterface", null, 0, 1, InterfaceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInterfaceReference_RequiringMicroservice(), this.getIntermediateMicroservice(), this.getIntermediateMicroservice_RequiredInterfaces(), "requiringMicroservice", null, 0, 1, InterfaceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(operationReferenceEClass, OperationReference.class, "OperationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getOperationReference_Name(), theEcorePackage.getEString(), "name", null, 0, 1, OperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getOperationReference_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, OperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getOperationReference_Imported(), theEcorePackage.getEBoolean(), "imported", "false", 0, 1, OperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationReference_Import(), theIntermediatePackage_1.getIntermediateImport(), null, "import", null, 0, 1, OperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationReference_LocalOperation(), this.getIntermediateOperation(), null, "localOperation", null, 0, 1, OperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationReference_RequiringMicroservice(), this.getIntermediateMicroservice(), this.getIntermediateMicroservice_RequiredOperations(), "requiringMicroservice", null, 0, 1, OperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationReference_InitializedParameter(), this.getIntermediateParameter(), this.getIntermediateParameter_InitializedByOperation(), "initializedParameter", null, 0, 1, OperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateTechnologyEClass, IntermediateTechnology.class, "IntermediateTechnology", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateTechnology_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateTechnology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateTechnology_Import(), theIntermediatePackage_1.getIntermediateImport(), null, "import", null, 0, 1, IntermediateTechnology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateTechnology_Microservice(), this.getIntermediateMicroservice(), this.getIntermediateMicroservice_Technologies(), "microservice", null, 0, 1, IntermediateTechnology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateEndpointEClass, IntermediateEndpoint.class, "IntermediateEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateEndpoint_CommunicationType(), theTechnologyPackage.getCommunicationType(), "communicationType", null, 0, 1, IntermediateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateEndpoint_Protocol(), theEcorePackage.getEString(), "protocol", null, 0, 1, IntermediateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateEndpoint_DataFormat(), theEcorePackage.getEString(), "dataFormat", null, 0, 1, IntermediateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateEndpoint_Addresses(), theEcorePackage.getEString(), "addresses", null, 0, -1, IntermediateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateEndpoint_Technology(), this.getIntermediateTechnology(), null, "technology", null, 0, 1, IntermediateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateEndpoint_Microservice(), this.getIntermediateMicroservice(), this.getIntermediateMicroservice_Endpoints(), "microservice", null, 0, 1, IntermediateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateEndpoint_Interface(), this.getIntermediateInterface(), this.getIntermediateInterface_Endpoints(), "interface", null, 0, 1, IntermediateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateEndpoint_Operation(), this.getIntermediateOperation(), this.getIntermediateOperation_Endpoints(), "operation", null, 0, 1, IntermediateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateEndpoint_ReferredOperation(), this.getIntermediateReferredOperation(), this.getIntermediateReferredOperation_Endpoints(), "referredOperation", null, 0, 1, IntermediateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateProtocolSpecificationEClass, IntermediateProtocolSpecification.class, "IntermediateProtocolSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateProtocolSpecification_CommunicationType(), theTechnologyPackage.getCommunicationType(), "communicationType", null, 0, 1, IntermediateProtocolSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateProtocolSpecification_Protocol(), theEcorePackage.getEString(), "protocol", null, 0, 1, IntermediateProtocolSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateProtocolSpecification_DataFormat(), theEcorePackage.getEString(), "dataFormat", null, 0, 1, IntermediateProtocolSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateImportedAspectEClass, IntermediateImportedAspect.class, "IntermediateImportedAspect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateImportedAspect_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateImportedAspect_Import(), theIntermediatePackage_1.getIntermediateImport(), null, "import", null, 0, 1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateImportedAspect_Properties(), this.getIntermediateAspectProperty(), this.getIntermediateAspectProperty_Aspect(), "properties", null, 0, -1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateImportedAspect_PropertyValues(), this.getIntermediateAspectPropertyValue(), this.getIntermediateAspectPropertyValue_Aspect(), "propertyValues", null, 0, -1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateImportedAspect_Microservice(), this.getIntermediateMicroservice(), this.getIntermediateMicroservice_Aspects(), "microservice", null, 0, 1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateImportedAspect_Interface(), this.getIntermediateInterface(), this.getIntermediateInterface_Aspects(), "interface", null, 0, 1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateImportedAspect_Operation(), this.getIntermediateOperation(), this.getIntermediateOperation_Aspects(), "operation", null, 0, 1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateImportedAspect_ReferredOperation(), this.getIntermediateReferredOperation(), this.getIntermediateReferredOperation_Aspects(), "referredOperation", null, 0, 1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateImportedAspect_Parameter(), this.getIntermediateParameter(), this.getIntermediateParameter_Aspects(), "parameter", null, 0, 1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateImportedAspect_MappedDataField(), this.getIntermediateMappedDataField(), this.getIntermediateMappedDataField_Aspects(), "mappedDataField", null, 0, 1, IntermediateImportedAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateAspectPropertyEClass, IntermediateAspectProperty.class, "IntermediateAspectProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateAspectProperty_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateAspectProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateAspectProperty_Type(), theEcorePackage.getEString(), "type", null, 0, 1, IntermediateAspectProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateAspectProperty_DefaultValue(), theEcorePackage.getEString(), "defaultValue", null, 0, 1, IntermediateAspectProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIntermediateAspectProperty_Mandatory(), theEcorePackage.getEBoolean(), "mandatory", "false", 0, 1, IntermediateAspectProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateAspectProperty_Aspect(), this.getIntermediateImportedAspect(), this.getIntermediateImportedAspect_Properties(), "aspect", null, 0, 1, IntermediateAspectProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateAspectPropertyValueEClass, IntermediateAspectPropertyValue.class, "IntermediateAspectPropertyValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateAspectPropertyValue_Value(), theEcorePackage.getEString(), "value", null, 0, 1, IntermediateAspectPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateAspectPropertyValue_Property(), this.getIntermediateAspectProperty(), null, "property", null, 0, 1, IntermediateAspectPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateAspectPropertyValue_Aspect(), this.getIntermediateImportedAspect(), this.getIntermediateImportedAspect_PropertyValues(), "aspect", null, 0, 1, IntermediateAspectPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(intermediateImportedTechnologySpecificTypeEClass, IntermediateImportedTechnologySpecificType.class, "IntermediateImportedTechnologySpecificType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntermediateImportedTechnologySpecificType_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, IntermediateImportedTechnologySpecificType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getIntermediateImportedTechnologySpecificType_Import(), theIntermediatePackage_1.getIntermediateImport(), null, "import", null, 0, 1, IntermediateImportedTechnologySpecificType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //IntermediatePackageImpl
