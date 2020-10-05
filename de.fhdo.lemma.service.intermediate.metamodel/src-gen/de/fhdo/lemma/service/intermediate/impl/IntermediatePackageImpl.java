/**
 */
package de.fhdo.lemma.service.intermediate.impl;

import de.fhdo.lemma.service.intermediate.DataFieldAspects;
import de.fhdo.lemma.service.intermediate.InterfaceReference;
import de.fhdo.lemma.service.intermediate.IntermediateApiOperationComment;
import de.fhdo.lemma.service.intermediate.IntermediateApiParameterComment;
import de.fhdo.lemma.service.intermediate.IntermediateEndpoint;
import de.fhdo.lemma.service.intermediate.IntermediateFactory;
import de.fhdo.lemma.service.intermediate.IntermediateInterface;
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice;
import de.fhdo.lemma.service.intermediate.IntermediateOperation;
import de.fhdo.lemma.service.intermediate.IntermediatePackage;
import de.fhdo.lemma.service.intermediate.IntermediateParameter;
import de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification;
import de.fhdo.lemma.service.intermediate.IntermediateReferredOperation;
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel;
import de.fhdo.lemma.service.intermediate.IntermediateTechnology;
import de.fhdo.lemma.service.intermediate.MicroserviceReference;
import de.fhdo.lemma.service.intermediate.OperationReference;

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
	private EClass intermediateApiOperationCommentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intermediateApiParameterCommentEClass = null;

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
	private EClass dataFieldAspectsEClass = null;

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
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#eNS_URI
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
		de.fhdo.lemma.data.intermediate.IntermediatePackage.eINSTANCE.eClass();

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
	@Override
	public EClass getIntermediateServiceModel() {
		return intermediateServiceModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateServiceModel_SourceModelUri() {
		return (EAttribute)intermediateServiceModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateServiceModel_Imports() {
		return (EReference)intermediateServiceModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateServiceModel_Microservices() {
		return (EReference)intermediateServiceModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntermediateMicroservice() {
		return intermediateMicroserviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateMicroservice_SourceModelUri() {
		return (EAttribute)intermediateMicroserviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateMicroservice_Name() {
		return (EAttribute)intermediateMicroserviceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateMicroservice_Version() {
		return (EAttribute)intermediateMicroserviceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateMicroservice_QualifiedName() {
		return (EAttribute)intermediateMicroserviceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateMicroservice_Type() {
		return (EAttribute)intermediateMicroserviceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateMicroservice_Visibility() {
		return (EAttribute)intermediateMicroserviceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateMicroservice_EffectivelyImplemented() {
		return (EAttribute)intermediateMicroserviceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateMicroservice_Technologies() {
		return (EReference)intermediateMicroserviceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateMicroservice_Endpoints() {
		return (EReference)intermediateMicroserviceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateMicroservice_Protocols() {
		return (EReference)intermediateMicroserviceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateMicroservice_RequiredMicroservices() {
		return (EReference)intermediateMicroserviceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateMicroservice_RequiredInterfaces() {
		return (EReference)intermediateMicroserviceEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateMicroservice_RequiredOperations() {
		return (EReference)intermediateMicroserviceEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateMicroservice_Interfaces() {
		return (EReference)intermediateMicroserviceEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateMicroservice_Aspects() {
		return (EReference)intermediateMicroserviceEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateMicroservice_ServiceModel() {
		return (EReference)intermediateMicroserviceEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntermediateInterface() {
		return intermediateInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateInterface_Name() {
		return (EAttribute)intermediateInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateInterface_Version() {
		return (EAttribute)intermediateInterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateInterface_QualifiedName() {
		return (EAttribute)intermediateInterfaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateInterface_Visibility() {
		return (EAttribute)intermediateInterfaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateInterface_NotImplemented() {
		return (EAttribute)intermediateInterfaceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateInterface_HasImplementedOperations() {
		return (EAttribute)intermediateInterfaceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateInterface_Endpoints() {
		return (EReference)intermediateInterfaceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateInterface_Protocols() {
		return (EReference)intermediateInterfaceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateInterface_Operations() {
		return (EReference)intermediateInterfaceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateInterface_ReferredOperations() {
		return (EReference)intermediateInterfaceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateInterface_Aspects() {
		return (EReference)intermediateInterfaceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateInterface_Microservice() {
		return (EReference)intermediateInterfaceEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntermediateOperation() {
		return intermediateOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateOperation_Name() {
		return (EAttribute)intermediateOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateOperation_QualifiedName() {
		return (EAttribute)intermediateOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateOperation_Visibility() {
		return (EAttribute)intermediateOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateOperation_NotImplemented() {
		return (EAttribute)intermediateOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateOperation_ApiOperationComment() {
		return (EReference)intermediateOperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateOperation_Endpoints() {
		return (EReference)intermediateOperationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateOperation_Protocols() {
		return (EReference)intermediateOperationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateOperation_Aspects() {
		return (EReference)intermediateOperationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateOperation_Parameters() {
		return (EReference)intermediateOperationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateOperation_Interface() {
		return (EReference)intermediateOperationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntermediateApiOperationComment() {
		return intermediateApiOperationCommentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateApiOperationComment_Comment() {
		return (EAttribute)intermediateApiOperationCommentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateApiOperationComment_ParameterComments() {
		return (EReference)intermediateApiOperationCommentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateApiOperationComment_Operation() {
		return (EReference)intermediateApiOperationCommentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntermediateApiParameterComment() {
		return intermediateApiParameterCommentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateApiParameterComment_Comment() {
		return (EAttribute)intermediateApiParameterCommentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateApiParameterComment_Required() {
		return (EAttribute)intermediateApiParameterCommentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateApiParameterComment_Parameter() {
		return (EReference)intermediateApiParameterCommentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateApiParameterComment_OperationComment() {
		return (EReference)intermediateApiParameterCommentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntermediateReferredOperation() {
		return intermediateReferredOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateReferredOperation_NameInReferringInterface() {
		return (EAttribute)intermediateReferredOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateReferredOperation_QualifiedNameInReferringInterface() {
		return (EAttribute)intermediateReferredOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateReferredOperation_Operation() {
		return (EReference)intermediateReferredOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateReferredOperation_Endpoints() {
		return (EReference)intermediateReferredOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateReferredOperation_Protocols() {
		return (EReference)intermediateReferredOperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateReferredOperation_Aspects() {
		return (EReference)intermediateReferredOperationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateReferredOperation_ReferringInterface() {
		return (EReference)intermediateReferredOperationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntermediateParameter() {
		return intermediateParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateParameter_Name() {
		return (EAttribute)intermediateParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateParameter_QualifiedName() {
		return (EAttribute)intermediateParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateParameter_ExchangePattern() {
		return (EAttribute)intermediateParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateParameter_CommunicationType() {
		return (EAttribute)intermediateParameterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateParameter_CommunicatesFault() {
		return (EAttribute)intermediateParameterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateParameter_Optional() {
		return (EAttribute)intermediateParameterEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateParameter_Type() {
		return (EReference)intermediateParameterEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateParameter_OriginalType() {
		return (EReference)intermediateParameterEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateParameter_InitializedByOperation() {
		return (EReference)intermediateParameterEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateParameter_Aspects() {
		return (EReference)intermediateParameterEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateParameter_FieldAspects() {
		return (EReference)intermediateParameterEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateParameter_Operation() {
		return (EReference)intermediateParameterEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataFieldAspects() {
		return dataFieldAspectsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataFieldAspects_Name() {
		return (EAttribute)dataFieldAspectsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataFieldAspects_QualifiedName() {
		return (EAttribute)dataFieldAspectsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataFieldAspects_Aspects() {
		return (EReference)dataFieldAspectsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataFieldAspects_Parameter() {
		return (EReference)dataFieldAspectsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMicroserviceReference() {
		return microserviceReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMicroserviceReference_Name() {
		return (EAttribute)microserviceReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMicroserviceReference_Version() {
		return (EAttribute)microserviceReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMicroserviceReference_QualifiedName() {
		return (EAttribute)microserviceReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMicroserviceReference_Imported() {
		return (EAttribute)microserviceReferenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMicroserviceReference_Import() {
		return (EReference)microserviceReferenceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMicroserviceReference_LocalMicroservice() {
		return (EReference)microserviceReferenceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMicroserviceReference_RequiringMicroservice() {
		return (EReference)microserviceReferenceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInterfaceReference() {
		return interfaceReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterfaceReference_Name() {
		return (EAttribute)interfaceReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterfaceReference_Version() {
		return (EAttribute)interfaceReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterfaceReference_QualifiedName() {
		return (EAttribute)interfaceReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterfaceReference_Imported() {
		return (EAttribute)interfaceReferenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterfaceReference_Import() {
		return (EReference)interfaceReferenceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterfaceReference_LocalInterface() {
		return (EReference)interfaceReferenceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterfaceReference_RequiringMicroservice() {
		return (EReference)interfaceReferenceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperationReference() {
		return operationReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperationReference_Name() {
		return (EAttribute)operationReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperationReference_QualifiedName() {
		return (EAttribute)operationReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperationReference_Imported() {
		return (EAttribute)operationReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationReference_Import() {
		return (EReference)operationReferenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationReference_LocalOperation() {
		return (EReference)operationReferenceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationReference_RequiringMicroservice() {
		return (EReference)operationReferenceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationReference_InitializedParameter() {
		return (EReference)operationReferenceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntermediateTechnology() {
		return intermediateTechnologyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateTechnology_Name() {
		return (EAttribute)intermediateTechnologyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateTechnology_Import() {
		return (EReference)intermediateTechnologyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateTechnology_Microservice() {
		return (EReference)intermediateTechnologyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntermediateEndpoint() {
		return intermediateEndpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateEndpoint_CommunicationType() {
		return (EAttribute)intermediateEndpointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateEndpoint_Protocol() {
		return (EAttribute)intermediateEndpointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateEndpoint_DataFormat() {
		return (EAttribute)intermediateEndpointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateEndpoint_Addresses() {
		return (EAttribute)intermediateEndpointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateEndpoint_Technology() {
		return (EReference)intermediateEndpointEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateEndpoint_Microservice() {
		return (EReference)intermediateEndpointEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateEndpoint_Interface() {
		return (EReference)intermediateEndpointEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateEndpoint_Operation() {
		return (EReference)intermediateEndpointEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntermediateEndpoint_ReferredOperation() {
		return (EReference)intermediateEndpointEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntermediateProtocolSpecification() {
		return intermediateProtocolSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateProtocolSpecification_CommunicationType() {
		return (EAttribute)intermediateProtocolSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateProtocolSpecification_Protocol() {
		return (EAttribute)intermediateProtocolSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntermediateProtocolSpecification_DataFormat() {
		return (EAttribute)intermediateProtocolSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
		createEAttribute(intermediateServiceModelEClass, INTERMEDIATE_SERVICE_MODEL__SOURCE_MODEL_URI);
		createEReference(intermediateServiceModelEClass, INTERMEDIATE_SERVICE_MODEL__IMPORTS);
		createEReference(intermediateServiceModelEClass, INTERMEDIATE_SERVICE_MODEL__MICROSERVICES);

		intermediateMicroserviceEClass = createEClass(INTERMEDIATE_MICROSERVICE);
		createEAttribute(intermediateMicroserviceEClass, INTERMEDIATE_MICROSERVICE__SOURCE_MODEL_URI);
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
		createEAttribute(intermediateInterfaceEClass, INTERMEDIATE_INTERFACE__VERSION);
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
		createEReference(intermediateOperationEClass, INTERMEDIATE_OPERATION__API_OPERATION_COMMENT);
		createEReference(intermediateOperationEClass, INTERMEDIATE_OPERATION__ENDPOINTS);
		createEReference(intermediateOperationEClass, INTERMEDIATE_OPERATION__PROTOCOLS);
		createEReference(intermediateOperationEClass, INTERMEDIATE_OPERATION__ASPECTS);
		createEReference(intermediateOperationEClass, INTERMEDIATE_OPERATION__PARAMETERS);
		createEReference(intermediateOperationEClass, INTERMEDIATE_OPERATION__INTERFACE);

		intermediateApiOperationCommentEClass = createEClass(INTERMEDIATE_API_OPERATION_COMMENT);
		createEAttribute(intermediateApiOperationCommentEClass, INTERMEDIATE_API_OPERATION_COMMENT__COMMENT);
		createEReference(intermediateApiOperationCommentEClass, INTERMEDIATE_API_OPERATION_COMMENT__PARAMETER_COMMENTS);
		createEReference(intermediateApiOperationCommentEClass, INTERMEDIATE_API_OPERATION_COMMENT__OPERATION);

		intermediateApiParameterCommentEClass = createEClass(INTERMEDIATE_API_PARAMETER_COMMENT);
		createEAttribute(intermediateApiParameterCommentEClass, INTERMEDIATE_API_PARAMETER_COMMENT__COMMENT);
		createEAttribute(intermediateApiParameterCommentEClass, INTERMEDIATE_API_PARAMETER_COMMENT__REQUIRED);
		createEReference(intermediateApiParameterCommentEClass, INTERMEDIATE_API_PARAMETER_COMMENT__PARAMETER);
		createEReference(intermediateApiParameterCommentEClass, INTERMEDIATE_API_PARAMETER_COMMENT__OPERATION_COMMENT);

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
		createEReference(intermediateParameterEClass, INTERMEDIATE_PARAMETER__ORIGINAL_TYPE);
		createEReference(intermediateParameterEClass, INTERMEDIATE_PARAMETER__INITIALIZED_BY_OPERATION);
		createEReference(intermediateParameterEClass, INTERMEDIATE_PARAMETER__ASPECTS);
		createEReference(intermediateParameterEClass, INTERMEDIATE_PARAMETER__FIELD_ASPECTS);
		createEReference(intermediateParameterEClass, INTERMEDIATE_PARAMETER__OPERATION);

		dataFieldAspectsEClass = createEClass(DATA_FIELD_ASPECTS);
		createEAttribute(dataFieldAspectsEClass, DATA_FIELD_ASPECTS__NAME);
		createEAttribute(dataFieldAspectsEClass, DATA_FIELD_ASPECTS__QUALIFIED_NAME);
		createEReference(dataFieldAspectsEClass, DATA_FIELD_ASPECTS__ASPECTS);
		createEReference(dataFieldAspectsEClass, DATA_FIELD_ASPECTS__PARAMETER);

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
		createEAttribute(interfaceReferenceEClass, INTERFACE_REFERENCE__VERSION);
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
		de.fhdo.lemma.data.intermediate.IntermediatePackage theIntermediatePackage_1 = (de.fhdo.lemma.data.intermediate.IntermediatePackage)EPackage.Registry.INSTANCE.getEPackage(de.fhdo.lemma.data.intermediate.IntermediatePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(intermediateServiceModelEClass, IntermediateServiceModel.class, "IntermediateServiceModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntermediateServiceModel_SourceModelUri(), theEcorePackage.getEString(), "sourceModelUri", null, 0, 1, IntermediateServiceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateServiceModel_Imports(), theIntermediatePackage_1.getIntermediateImport(), null, "imports", null, 0, -1, IntermediateServiceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateServiceModel_Microservices(), this.getIntermediateMicroservice(), this.getIntermediateMicroservice_ServiceModel(), "microservices", null, 1, -1, IntermediateServiceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intermediateMicroserviceEClass, IntermediateMicroservice.class, "IntermediateMicroservice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntermediateMicroservice_SourceModelUri(), theEcorePackage.getEString(), "sourceModelUri", null, 0, 1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateMicroservice_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateMicroservice_Version(), theEcorePackage.getEString(), "version", null, 0, 1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateMicroservice_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateMicroservice_Type(), theEcorePackage.getEString(), "type", null, 0, 1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateMicroservice_Visibility(), theEcorePackage.getEString(), "visibility", null, 0, 1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateMicroservice_EffectivelyImplemented(), theEcorePackage.getEBoolean(), "effectivelyImplemented", null, 0, 1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateMicroservice_Technologies(), this.getIntermediateTechnology(), this.getIntermediateTechnology_Microservice(), "technologies", null, 0, -1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateMicroservice_Endpoints(), this.getIntermediateEndpoint(), this.getIntermediateEndpoint_Microservice(), "endpoints", null, 0, -1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateMicroservice_Protocols(), this.getIntermediateProtocolSpecification(), null, "protocols", null, 0, 2, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateMicroservice_RequiredMicroservices(), this.getMicroserviceReference(), this.getMicroserviceReference_RequiringMicroservice(), "requiredMicroservices", null, 0, -1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateMicroservice_RequiredInterfaces(), this.getInterfaceReference(), this.getInterfaceReference_RequiringMicroservice(), "requiredInterfaces", null, 0, -1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateMicroservice_RequiredOperations(), this.getOperationReference(), this.getOperationReference_RequiringMicroservice(), "requiredOperations", null, 0, -1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateMicroservice_Interfaces(), this.getIntermediateInterface(), this.getIntermediateInterface_Microservice(), "interfaces", null, 1, -1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateMicroservice_Aspects(), theIntermediatePackage_1.getIntermediateImportedAspect(), null, "aspects", null, 0, -1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateMicroservice_ServiceModel(), this.getIntermediateServiceModel(), this.getIntermediateServiceModel_Microservices(), "serviceModel", null, 0, 1, IntermediateMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intermediateInterfaceEClass, IntermediateInterface.class, "IntermediateInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntermediateInterface_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateInterface_Version(), theEcorePackage.getEString(), "version", null, 0, 1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateInterface_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateInterface_Visibility(), theEcorePackage.getEString(), "visibility", null, 0, 1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateInterface_NotImplemented(), theEcorePackage.getEBoolean(), "notImplemented", null, 0, 1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateInterface_HasImplementedOperations(), theEcorePackage.getEBoolean(), "hasImplementedOperations", null, 0, 1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateInterface_Endpoints(), this.getIntermediateEndpoint(), this.getIntermediateEndpoint_Interface(), "endpoints", null, 0, -1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateInterface_Protocols(), this.getIntermediateProtocolSpecification(), null, "protocols", null, 0, 2, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateInterface_Operations(), this.getIntermediateOperation(), this.getIntermediateOperation_Interface(), "operations", null, 0, -1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateInterface_ReferredOperations(), this.getIntermediateReferredOperation(), this.getIntermediateReferredOperation_ReferringInterface(), "referredOperations", null, 0, -1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateInterface_Aspects(), theIntermediatePackage_1.getIntermediateImportedAspect(), null, "aspects", null, 0, -1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateInterface_Microservice(), this.getIntermediateMicroservice(), this.getIntermediateMicroservice_Interfaces(), "microservice", null, 0, 1, IntermediateInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intermediateOperationEClass, IntermediateOperation.class, "IntermediateOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntermediateOperation_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateOperation_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, IntermediateOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateOperation_Visibility(), theEcorePackage.getEString(), "visibility", null, 0, 1, IntermediateOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateOperation_NotImplemented(), theEcorePackage.getEBoolean(), "notImplemented", null, 0, 1, IntermediateOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateOperation_ApiOperationComment(), this.getIntermediateApiOperationComment(), this.getIntermediateApiOperationComment_Operation(), "apiOperationComment", null, 0, 1, IntermediateOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateOperation_Endpoints(), this.getIntermediateEndpoint(), this.getIntermediateEndpoint_Operation(), "endpoints", null, 0, -1, IntermediateOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateOperation_Protocols(), this.getIntermediateProtocolSpecification(), null, "protocols", null, 0, 2, IntermediateOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateOperation_Aspects(), theIntermediatePackage_1.getIntermediateImportedAspect(), null, "aspects", null, 0, -1, IntermediateOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateOperation_Parameters(), this.getIntermediateParameter(), this.getIntermediateParameter_Operation(), "parameters", null, 0, -1, IntermediateOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateOperation_Interface(), this.getIntermediateInterface(), this.getIntermediateInterface_Operations(), "interface", null, 0, 1, IntermediateOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intermediateApiOperationCommentEClass, IntermediateApiOperationComment.class, "IntermediateApiOperationComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntermediateApiOperationComment_Comment(), theEcorePackage.getEString(), "comment", null, 0, 1, IntermediateApiOperationComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateApiOperationComment_ParameterComments(), this.getIntermediateApiParameterComment(), this.getIntermediateApiParameterComment_OperationComment(), "parameterComments", null, 0, -1, IntermediateApiOperationComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateApiOperationComment_Operation(), this.getIntermediateOperation(), this.getIntermediateOperation_ApiOperationComment(), "operation", null, 0, 1, IntermediateApiOperationComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intermediateApiParameterCommentEClass, IntermediateApiParameterComment.class, "IntermediateApiParameterComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntermediateApiParameterComment_Comment(), theEcorePackage.getEString(), "comment", null, 0, 1, IntermediateApiParameterComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateApiParameterComment_Required(), theEcorePackage.getEBoolean(), "required", null, 0, 1, IntermediateApiParameterComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateApiParameterComment_Parameter(), this.getIntermediateParameter(), null, "parameter", null, 0, 1, IntermediateApiParameterComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateApiParameterComment_OperationComment(), this.getIntermediateApiOperationComment(), this.getIntermediateApiOperationComment_ParameterComments(), "operationComment", null, 0, 1, IntermediateApiParameterComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intermediateReferredOperationEClass, IntermediateReferredOperation.class, "IntermediateReferredOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntermediateReferredOperation_NameInReferringInterface(), theEcorePackage.getEString(), "nameInReferringInterface", null, 0, 1, IntermediateReferredOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateReferredOperation_QualifiedNameInReferringInterface(), theEcorePackage.getEString(), "qualifiedNameInReferringInterface", null, 0, 1, IntermediateReferredOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateReferredOperation_Operation(), this.getIntermediateOperation(), null, "operation", null, 0, 1, IntermediateReferredOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateReferredOperation_Endpoints(), this.getIntermediateEndpoint(), this.getIntermediateEndpoint_ReferredOperation(), "endpoints", null, 0, -1, IntermediateReferredOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateReferredOperation_Protocols(), this.getIntermediateProtocolSpecification(), null, "protocols", null, 0, 2, IntermediateReferredOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateReferredOperation_Aspects(), theIntermediatePackage_1.getIntermediateImportedAspect(), null, "aspects", null, 0, -1, IntermediateReferredOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateReferredOperation_ReferringInterface(), this.getIntermediateInterface(), this.getIntermediateInterface_ReferredOperations(), "referringInterface", null, 0, 1, IntermediateReferredOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intermediateParameterEClass, IntermediateParameter.class, "IntermediateParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntermediateParameter_Name(), theEcorePackage.getEString(), "name", null, 0, 1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateParameter_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateParameter_ExchangePattern(), theEcorePackage.getEString(), "exchangePattern", null, 0, 1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateParameter_CommunicationType(), theEcorePackage.getEString(), "communicationType", null, 0, 1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateParameter_CommunicatesFault(), theEcorePackage.getEBoolean(), "communicatesFault", null, 0, 1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateParameter_Optional(), theEcorePackage.getEBoolean(), "optional", null, 0, 1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateParameter_Type(), theIntermediatePackage_1.getIntermediateType(), null, "type", null, 0, 1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateParameter_OriginalType(), theIntermediatePackage_1.getIntermediateType(), null, "originalType", null, 0, 1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateParameter_InitializedByOperation(), this.getOperationReference(), this.getOperationReference_InitializedParameter(), "initializedByOperation", null, 0, 1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateParameter_Aspects(), theIntermediatePackage_1.getIntermediateImportedAspect(), null, "aspects", null, 0, -1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateParameter_FieldAspects(), this.getDataFieldAspects(), this.getDataFieldAspects_Parameter(), "fieldAspects", null, 0, -1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateParameter_Operation(), this.getIntermediateOperation(), this.getIntermediateOperation_Parameters(), "operation", null, 0, 1, IntermediateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataFieldAspectsEClass, DataFieldAspects.class, "DataFieldAspects", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataFieldAspects_Name(), theEcorePackage.getEString(), "name", null, 0, 1, DataFieldAspects.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataFieldAspects_QualifiedName(), theEcorePackage.getEString(), "qualifiedName", null, 0, 1, DataFieldAspects.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataFieldAspects_Aspects(), theIntermediatePackage_1.getIntermediateImportedAspect(), null, "aspects", null, 0, -1, DataFieldAspects.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataFieldAspects_Parameter(), this.getIntermediateParameter(), this.getIntermediateParameter_FieldAspects(), "parameter", null, 0, 1, DataFieldAspects.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		initEAttribute(getInterfaceReference_Version(), theEcorePackage.getEString(), "version", null, 0, 1, InterfaceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
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
		initEAttribute(getIntermediateEndpoint_CommunicationType(), theEcorePackage.getEString(), "communicationType", null, 0, 1, IntermediateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateEndpoint_Protocol(), theEcorePackage.getEString(), "protocol", null, 0, 1, IntermediateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateEndpoint_DataFormat(), theEcorePackage.getEString(), "dataFormat", null, 0, 1, IntermediateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateEndpoint_Addresses(), theEcorePackage.getEString(), "addresses", null, 0, -1, IntermediateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateEndpoint_Technology(), this.getIntermediateTechnology(), null, "technology", null, 0, 1, IntermediateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateEndpoint_Microservice(), this.getIntermediateMicroservice(), this.getIntermediateMicroservice_Endpoints(), "microservice", null, 0, 1, IntermediateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateEndpoint_Interface(), this.getIntermediateInterface(), this.getIntermediateInterface_Endpoints(), "interface", null, 0, 1, IntermediateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateEndpoint_Operation(), this.getIntermediateOperation(), this.getIntermediateOperation_Endpoints(), "operation", null, 0, 1, IntermediateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntermediateEndpoint_ReferredOperation(), this.getIntermediateReferredOperation(), this.getIntermediateReferredOperation_Endpoints(), "referredOperation", null, 0, 1, IntermediateEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intermediateProtocolSpecificationEClass, IntermediateProtocolSpecification.class, "IntermediateProtocolSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntermediateProtocolSpecification_CommunicationType(), theEcorePackage.getEString(), "communicationType", null, 0, 1, IntermediateProtocolSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateProtocolSpecification_Protocol(), theEcorePackage.getEString(), "protocol", null, 0, 1, IntermediateProtocolSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntermediateProtocolSpecification_DataFormat(), theEcorePackage.getEString(), "dataFormat", null, 0, 1, IntermediateProtocolSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //IntermediatePackageImpl
