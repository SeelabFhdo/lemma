/**
 */
package de.fhdo.lemma.service.impl;

import de.fhdo.lemma.data.DataPackage;

import de.fhdo.lemma.service.ApiOperationComment;
import de.fhdo.lemma.service.ApiParameterComment;
import de.fhdo.lemma.service.Endpoint;
import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.ImportType;
import de.fhdo.lemma.service.ImportedProtocolAndDataFormat;
import de.fhdo.lemma.service.ImportedServiceAspect;
import de.fhdo.lemma.service.ImportedType;
import de.fhdo.lemma.service.Interface;
import de.fhdo.lemma.service.MappedComplexType;
import de.fhdo.lemma.service.MappedDataOperation;
import de.fhdo.lemma.service.MappedDataOperationParameter;
import de.fhdo.lemma.service.MappedDataOperationReturnType;
import de.fhdo.lemma.service.MappedField;
import de.fhdo.lemma.service.Microservice;
import de.fhdo.lemma.service.MicroserviceType;
import de.fhdo.lemma.service.Operation;
import de.fhdo.lemma.service.Parameter;
import de.fhdo.lemma.service.PossiblyImportedInterface;
import de.fhdo.lemma.service.PossiblyImportedMicroservice;
import de.fhdo.lemma.service.PossiblyImportedOperation;
import de.fhdo.lemma.service.ProtocolSpecification;
import de.fhdo.lemma.service.ReferredOperation;
import de.fhdo.lemma.service.ServiceFactory;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.service.ServicePackage;
import de.fhdo.lemma.service.TechnologyReference;
import de.fhdo.lemma.service.Visibility;

import de.fhdo.lemma.technology.TechnologyPackage;

import java.util.List;
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
public class ServicePackageImpl extends EPackageImpl implements ServicePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappedComplexTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappedDataOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappedDataOperationReturnTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappedDataOperationParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappedFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass microserviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass technologyReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass apiOperationCommentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass apiParameterCommentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referredOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass possiblyImportedMicroserviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass possiblyImportedInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass possiblyImportedOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importedTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importedProtocolAndDataFormatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass protocolSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importedServiceAspectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum importTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum microserviceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum visibilityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType tupleListEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType microserviceImportMapEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType defaultProtocolsEDataType = null;

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
	 * @see de.fhdo.lemma.service.ServicePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ServicePackageImpl() {
		super(eNS_URI, ServiceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ServicePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ServicePackage init() {
		if (isInited) return (ServicePackage)EPackage.Registry.INSTANCE.getEPackage(ServicePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredServicePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ServicePackageImpl theServicePackage = registeredServicePackage instanceof ServicePackageImpl ? (ServicePackageImpl)registeredServicePackage : new ServicePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		TechnologyPackage.eINSTANCE.eClass();
		DataPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theServicePackage.createPackageContents();

		// Initialize created meta-data
		theServicePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theServicePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ServicePackage.eNS_URI, theServicePackage);
		return theServicePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getServiceModel() {
		return serviceModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getServiceModel_T_modelUri() {
		return (EAttribute)serviceModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getServiceModel_Imports() {
		return (EReference)serviceModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getServiceModel_MappedComplexTypes() {
		return (EReference)serviceModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getServiceModel_Microservices() {
		return (EReference)serviceModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getServiceModel__GetContainedOperations() {
		return serviceModelEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getServiceModel__GetContainedReferredOperations() {
		return serviceModelEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getServiceModel__GetContainedInterfaces() {
		return serviceModelEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImport() {
		return importEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImport_T_relatedImportAlias() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImport_Name() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImport_ImportURI() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImport_ExternalURI() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImport_ImportType() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImport_ServiceModel() {
		return (EReference)importEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappedComplexType() {
		return mappedComplexTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMappedComplexType_T_sourceModelUri() {
		return (EAttribute)mappedComplexTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedComplexType_T_typeDefinitionTechnologyImport() {
		return (EReference)mappedComplexTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedComplexType_T_typeDefinitionTechnology() {
		return (EReference)mappedComplexTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedComplexType_TechnologyReferences() {
		return (EReference)mappedComplexTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedComplexType_Type() {
		return (EReference)mappedComplexTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedComplexType_MappedFields() {
		return (EReference)mappedComplexTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedComplexType_MappedOperations() {
		return (EReference)mappedComplexTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedComplexType_Aspects() {
		return (EReference)mappedComplexTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedComplexType_ServiceModel() {
		return (EReference)mappedComplexTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMappedComplexType__GetQualifiedNameParts__boolean() {
		return mappedComplexTypeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMappedComplexType__BuildQualifiedName__String_boolean() {
		return mappedComplexTypeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMappedComplexType__GetAllTypeDefinitionTechnologyReferences() {
		return mappedComplexTypeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMappedComplexType__GetTypeDefinitionTechnologyImport() {
		return mappedComplexTypeEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMappedComplexType__GetTypeDefinitionTechnology() {
		return mappedComplexTypeEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappedDataOperation() {
		return mappedDataOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedDataOperation_DataOperation() {
		return (EReference)mappedDataOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedDataOperation_Aspects() {
		return (EReference)mappedDataOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedDataOperation_MappedReturnType() {
		return (EReference)mappedDataOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedDataOperation_MappedParameters() {
		return (EReference)mappedDataOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedDataOperation_MappedComplexType() {
		return (EReference)mappedDataOperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappedDataOperationReturnType() {
		return mappedDataOperationReturnTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedDataOperationReturnType_MappedType() {
		return (EReference)mappedDataOperationReturnTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedDataOperationReturnType_Aspects() {
		return (EReference)mappedDataOperationReturnTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedDataOperationReturnType_MappedOperation() {
		return (EReference)mappedDataOperationReturnTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappedDataOperationParameter() {
		return mappedDataOperationParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedDataOperationParameter_Parameter() {
		return (EReference)mappedDataOperationParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedDataOperationParameter_MappedType() {
		return (EReference)mappedDataOperationParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedDataOperationParameter_Aspects() {
		return (EReference)mappedDataOperationParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedDataOperationParameter_MappedOperation() {
		return (EReference)mappedDataOperationParameterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappedField() {
		return mappedFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedField_DataField() {
		return (EReference)mappedFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedField_EnumerationField() {
		return (EReference)mappedFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedField_MappedType() {
		return (EReference)mappedFieldEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedField_Aspects() {
		return (EReference)mappedFieldEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedField_Parameter() {
		return (EReference)mappedFieldEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedField_MappedComplexType() {
		return (EReference)mappedFieldEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMappedField_Name() {
		return (EAttribute)mappedFieldEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMappedField__GetQualifiedNameParts__boolean() {
		return mappedFieldEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMappedField__BuildQualifiedName__String_boolean() {
		return mappedFieldEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMappedField__GetEffectiveType() {
		return mappedFieldEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMicroservice() {
		return microserviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMicroservice_Name() {
		return (EAttribute)microserviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMicroservice_Version() {
		return (EAttribute)microserviceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMicroservice_Type() {
		return (EAttribute)microserviceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMicroservice_Visibility() {
		return (EAttribute)microserviceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMicroservice_T_defaultProtocols() {
		return (EAttribute)microserviceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMicroservice_T_sourceModelUri() {
		return (EAttribute)microserviceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMicroservice_TechnologyReferences() {
		return (EReference)microserviceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMicroservice_T_typeDefinitionTechnologyImport() {
		return (EReference)microserviceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMicroservice_T_typeDefinitionTechnology() {
		return (EReference)microserviceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMicroservice_Endpoints() {
		return (EReference)microserviceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMicroservice_RequiredMicroservices() {
		return (EReference)microserviceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMicroservice_RequiredInterfaces() {
		return (EReference)microserviceEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMicroservice_RequiredOperations() {
		return (EReference)microserviceEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMicroservice_Protocols() {
		return (EReference)microserviceEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMicroservice_Interfaces() {
		return (EReference)microserviceEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMicroservice_Aspects() {
		return (EReference)microserviceEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMicroservice_ServiceModel() {
		return (EReference)microserviceEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMicroservice_EffectivelyImplemented() {
		return (EAttribute)microserviceEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMicroservice_EffectiveVisibility() {
		return (EAttribute)microserviceEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMicroservice_EffectivelyInternal() {
		return (EAttribute)microserviceEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMicroservice__T_effectiveProtocolSpecifications() {
		return microserviceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMicroservice__GetAllTypeDefinitionTechnologyReferences() {
		return microserviceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMicroservice__GetTypeDefinitionTechnologyImport() {
		return microserviceEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMicroservice__GetTypeDefinitionTechnology() {
		return microserviceEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMicroservice__GetQualifiedNameParts() {
		return microserviceEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMicroservice__BuildQualifiedName__String() {
		return microserviceEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMicroservice__GetContainedOperations() {
		return microserviceEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMicroservice__GetContainedReferredOperations() {
		return microserviceEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMicroservice__GetRequiredImports() {
		return microserviceEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMicroservice__GetAllRequiredOperations__Import() {
		return microserviceEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMicroservice__GetAllRequiredMicroservices() {
		return microserviceEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMicroservice__GetAllInitializingMicroservices() {
		return microserviceEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMicroservice__CanRequire__Microservice_boolean() {
		return microserviceEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMicroservice__CanRequire__Interface_boolean() {
		return microserviceEClass.getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMicroservice__CanRequire__Operation_boolean() {
		return microserviceEClass.getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTechnologyReference() {
		return technologyReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTechnologyReference_IsTypeDefinitionTechnology() {
		return (EAttribute)technologyReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTechnologyReference_Technology() {
		return (EReference)technologyReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTechnologyReference_Microservice() {
		return (EReference)technologyReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTechnologyReference_MappedComplexType() {
		return (EReference)technologyReferenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInterface() {
		return interfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterface_Name() {
		return (EAttribute)interfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterface_Version() {
		return (EAttribute)interfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterface_NotImplemented() {
		return (EAttribute)interfaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterface_Visibility() {
		return (EAttribute)interfaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterface_Endpoints() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterface_Protocols() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterface_Operations() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterface_ReferredOperations() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterface_Aspects() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterface_Microservice() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterface_EffectiveVisibility() {
		return (EAttribute)interfaceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterface_EffectivelyImplemented() {
		return (EAttribute)interfaceEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterface_EffectivelyInternal() {
		return (EAttribute)interfaceEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getInterface__T_effectiveProtocolSpecifications() {
		return interfaceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getInterface__GetQualifiedNameParts() {
		return interfaceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getInterface__BuildQualifiedName__String() {
		return interfaceEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperation() {
		return operationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperation_Name() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperation_NotImplemented() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperation_Visibility() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperation_ApiOperationComment() {
		return (EReference)operationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperation_Endpoints() {
		return (EReference)operationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperation_Protocols() {
		return (EReference)operationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperation_Parameters() {
		return (EReference)operationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperation_Aspects() {
		return (EReference)operationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperation_Interface() {
		return (EReference)operationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperation_NotImplementedByContainer() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperation_EffectivelyNotImplemented() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperation_EffectiveVisibility() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperation_EffectivelyInternal() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getOperation__T_effectiveProtocolSpecifications() {
		return operationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getOperation__GetQualifiedNameParts() {
		return operationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getOperation__BuildQualifiedName__String() {
		return operationEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getApiOperationComment() {
		return apiOperationCommentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getApiOperationComment_Comment() {
		return (EAttribute)apiOperationCommentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApiOperationComment_ParameterComments() {
		return (EReference)apiOperationCommentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApiOperationComment_Operation() {
		return (EReference)apiOperationCommentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getApiParameterComment() {
		return apiParameterCommentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getApiParameterComment_Comment() {
		return (EAttribute)apiParameterCommentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getApiParameterComment_Required() {
		return (EAttribute)apiParameterCommentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApiParameterComment_Parameter() {
		return (EReference)apiParameterCommentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getApiParameterComment_OperationComment() {
		return (EReference)apiParameterCommentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReferredOperation() {
		return referredOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getReferredOperation_Operation() {
		return (EReference)referredOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getReferredOperation_Endpoints() {
		return (EReference)referredOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getReferredOperation_Protocols() {
		return (EReference)referredOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getReferredOperation_Aspects() {
		return (EReference)referredOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getReferredOperation_Interface() {
		return (EReference)referredOperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getReferredOperation__T_effectiveProtocolSpecifications() {
		return referredOperationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getReferredOperation__GetQualifiedNameParts() {
		return referredOperationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getReferredOperation__BuildQualifiedName__String() {
		return referredOperationEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getParameter_Name() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getParameter_ExchangePattern() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getParameter_CommunicationType() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getParameter_CommunicatesFault() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getParameter_Optional() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParameter_InitializedByOperation() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParameter_ImportedType() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParameter_PrimitiveType() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParameter_Aspects() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParameter_MappedFields() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParameter_OriginalImportedType() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParameter_OriginalPrimitiveType() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParameter_Operation() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getParameter__GetQualifiedNameParts() {
		return parameterEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getParameter__BuildQualifiedName__String() {
		return parameterEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getParameter__BasicallyInitializableBy__Operation() {
		return parameterEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getParameter__GetEffectiveType() {
		return parameterEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getParameter__IsTechnologySpecificEffectiveType() {
		return parameterEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getParameter__GetEffectiveTypeQualifiedNameParts() {
		return parameterEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPossiblyImportedMicroservice() {
		return possiblyImportedMicroserviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPossiblyImportedMicroservice_Import() {
		return (EReference)possiblyImportedMicroserviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPossiblyImportedMicroservice_Microservice() {
		return (EReference)possiblyImportedMicroserviceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPossiblyImportedMicroservice_RequiringMicroservice() {
		return (EReference)possiblyImportedMicroserviceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPossiblyImportedInterface() {
		return possiblyImportedInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPossiblyImportedInterface_Import() {
		return (EReference)possiblyImportedInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPossiblyImportedInterface_Interface() {
		return (EReference)possiblyImportedInterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPossiblyImportedInterface_RequiringMicroservice() {
		return (EReference)possiblyImportedInterfaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPossiblyImportedInterface_Required() {
		return (EAttribute)possiblyImportedInterfaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPossiblyImportedInterface_RequiredByContainer() {
		return (EAttribute)possiblyImportedInterfaceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPossiblyImportedOperation() {
		return possiblyImportedOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPossiblyImportedOperation_Import() {
		return (EReference)possiblyImportedOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPossiblyImportedOperation_Operation() {
		return (EReference)possiblyImportedOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPossiblyImportedOperation_RequiringMicroservice() {
		return (EReference)possiblyImportedOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPossiblyImportedOperation_InitializedParameter() {
		return (EReference)possiblyImportedOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPossiblyImportedOperation_Required() {
		return (EAttribute)possiblyImportedOperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPossiblyImportedOperation_RequiredByInterface() {
		return (EAttribute)possiblyImportedOperationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPossiblyImportedOperation_RequiredByMicroservice() {
		return (EAttribute)possiblyImportedOperationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPossiblyImportedOperation_RequiredByContainer() {
		return (EAttribute)possiblyImportedOperationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImportedType() {
		return importedTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedType_Import() {
		return (EReference)importedTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedType_Type() {
		return (EReference)importedTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImportedProtocolAndDataFormat() {
		return importedProtocolAndDataFormatEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedProtocolAndDataFormat_Import() {
		return (EReference)importedProtocolAndDataFormatEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedProtocolAndDataFormat_ImportedProtocol() {
		return (EReference)importedProtocolAndDataFormatEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedProtocolAndDataFormat_DataFormat() {
		return (EReference)importedProtocolAndDataFormatEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedProtocolAndDataFormat_Specification() {
		return (EReference)importedProtocolAndDataFormatEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedProtocolAndDataFormat_Endpoint() {
		return (EReference)importedProtocolAndDataFormatEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProtocolSpecification() {
		return protocolSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProtocolSpecification_CommunicationType() {
		return (EAttribute)protocolSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProtocolSpecification_Protocol() {
		return (EReference)protocolSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getProtocolSpecification__EffectiveProtocolSpecifications__EList() {
		return protocolSpecificationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEndpoint() {
		return endpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEndpoint_Addresses() {
		return (EAttribute)endpointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEndpoint_Protocols() {
		return (EReference)endpointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEndpoint_Microservice() {
		return (EReference)endpointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEndpoint_Interface() {
		return (EReference)endpointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEndpoint_Operation() {
		return (EReference)endpointEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEndpoint_ReferredOperation() {
		return (EReference)endpointEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImportedServiceAspect() {
		return importedServiceAspectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedServiceAspect_Import() {
		return (EReference)importedServiceAspectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedServiceAspect_ImportedAspect() {
		return (EReference)importedServiceAspectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedServiceAspect_SinglePropertyValue() {
		return (EReference)importedServiceAspectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedServiceAspect_Values() {
		return (EReference)importedServiceAspectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedServiceAspect_Microservice() {
		return (EReference)importedServiceAspectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedServiceAspect_Interface() {
		return (EReference)importedServiceAspectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedServiceAspect_Operation() {
		return (EReference)importedServiceAspectEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedServiceAspect_ReferredOperation() {
		return (EReference)importedServiceAspectEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedServiceAspect_Parameter() {
		return (EReference)importedServiceAspectEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedServiceAspect_MappedComplexType() {
		return (EReference)importedServiceAspectEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedServiceAspect_MappedField() {
		return (EReference)importedServiceAspectEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedServiceAspect_MappedDataOperation() {
		return (EReference)importedServiceAspectEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedServiceAspect_MappedDataOperationReturnType() {
		return (EReference)importedServiceAspectEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportedServiceAspect_MappedDataOperationParameter() {
		return (EReference)importedServiceAspectEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getImportType() {
		return importTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getMicroserviceType() {
		return microserviceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getVisibility() {
		return visibilityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getTupleList() {
		return tupleListEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getMicroserviceImportMap() {
		return microserviceImportMapEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getDefaultProtocols() {
		return defaultProtocolsEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ServiceFactory getServiceFactory() {
		return (ServiceFactory)getEFactoryInstance();
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
		serviceModelEClass = createEClass(SERVICE_MODEL);
		createEAttribute(serviceModelEClass, SERVICE_MODEL__TMODEL_URI);
		createEReference(serviceModelEClass, SERVICE_MODEL__IMPORTS);
		createEReference(serviceModelEClass, SERVICE_MODEL__MAPPED_COMPLEX_TYPES);
		createEReference(serviceModelEClass, SERVICE_MODEL__MICROSERVICES);
		createEOperation(serviceModelEClass, SERVICE_MODEL___GET_CONTAINED_OPERATIONS);
		createEOperation(serviceModelEClass, SERVICE_MODEL___GET_CONTAINED_REFERRED_OPERATIONS);
		createEOperation(serviceModelEClass, SERVICE_MODEL___GET_CONTAINED_INTERFACES);

		importEClass = createEClass(IMPORT);
		createEAttribute(importEClass, IMPORT__TRELATED_IMPORT_ALIAS);
		createEAttribute(importEClass, IMPORT__NAME);
		createEAttribute(importEClass, IMPORT__IMPORT_URI);
		createEAttribute(importEClass, IMPORT__EXTERNAL_URI);
		createEAttribute(importEClass, IMPORT__IMPORT_TYPE);
		createEReference(importEClass, IMPORT__SERVICE_MODEL);

		mappedComplexTypeEClass = createEClass(MAPPED_COMPLEX_TYPE);
		createEAttribute(mappedComplexTypeEClass, MAPPED_COMPLEX_TYPE__TSOURCE_MODEL_URI);
		createEReference(mappedComplexTypeEClass, MAPPED_COMPLEX_TYPE__TTYPE_DEFINITION_TECHNOLOGY_IMPORT);
		createEReference(mappedComplexTypeEClass, MAPPED_COMPLEX_TYPE__TTYPE_DEFINITION_TECHNOLOGY);
		createEReference(mappedComplexTypeEClass, MAPPED_COMPLEX_TYPE__TECHNOLOGY_REFERENCES);
		createEReference(mappedComplexTypeEClass, MAPPED_COMPLEX_TYPE__TYPE);
		createEReference(mappedComplexTypeEClass, MAPPED_COMPLEX_TYPE__MAPPED_FIELDS);
		createEReference(mappedComplexTypeEClass, MAPPED_COMPLEX_TYPE__MAPPED_OPERATIONS);
		createEReference(mappedComplexTypeEClass, MAPPED_COMPLEX_TYPE__ASPECTS);
		createEReference(mappedComplexTypeEClass, MAPPED_COMPLEX_TYPE__SERVICE_MODEL);
		createEOperation(mappedComplexTypeEClass, MAPPED_COMPLEX_TYPE___GET_QUALIFIED_NAME_PARTS__BOOLEAN);
		createEOperation(mappedComplexTypeEClass, MAPPED_COMPLEX_TYPE___BUILD_QUALIFIED_NAME__STRING_BOOLEAN);
		createEOperation(mappedComplexTypeEClass, MAPPED_COMPLEX_TYPE___GET_ALL_TYPE_DEFINITION_TECHNOLOGY_REFERENCES);
		createEOperation(mappedComplexTypeEClass, MAPPED_COMPLEX_TYPE___GET_TYPE_DEFINITION_TECHNOLOGY_IMPORT);
		createEOperation(mappedComplexTypeEClass, MAPPED_COMPLEX_TYPE___GET_TYPE_DEFINITION_TECHNOLOGY);

		mappedDataOperationEClass = createEClass(MAPPED_DATA_OPERATION);
		createEReference(mappedDataOperationEClass, MAPPED_DATA_OPERATION__DATA_OPERATION);
		createEReference(mappedDataOperationEClass, MAPPED_DATA_OPERATION__ASPECTS);
		createEReference(mappedDataOperationEClass, MAPPED_DATA_OPERATION__MAPPED_RETURN_TYPE);
		createEReference(mappedDataOperationEClass, MAPPED_DATA_OPERATION__MAPPED_PARAMETERS);
		createEReference(mappedDataOperationEClass, MAPPED_DATA_OPERATION__MAPPED_COMPLEX_TYPE);

		mappedDataOperationReturnTypeEClass = createEClass(MAPPED_DATA_OPERATION_RETURN_TYPE);
		createEReference(mappedDataOperationReturnTypeEClass, MAPPED_DATA_OPERATION_RETURN_TYPE__MAPPED_TYPE);
		createEReference(mappedDataOperationReturnTypeEClass, MAPPED_DATA_OPERATION_RETURN_TYPE__ASPECTS);
		createEReference(mappedDataOperationReturnTypeEClass, MAPPED_DATA_OPERATION_RETURN_TYPE__MAPPED_OPERATION);

		mappedDataOperationParameterEClass = createEClass(MAPPED_DATA_OPERATION_PARAMETER);
		createEReference(mappedDataOperationParameterEClass, MAPPED_DATA_OPERATION_PARAMETER__PARAMETER);
		createEReference(mappedDataOperationParameterEClass, MAPPED_DATA_OPERATION_PARAMETER__MAPPED_TYPE);
		createEReference(mappedDataOperationParameterEClass, MAPPED_DATA_OPERATION_PARAMETER__ASPECTS);
		createEReference(mappedDataOperationParameterEClass, MAPPED_DATA_OPERATION_PARAMETER__MAPPED_OPERATION);

		mappedFieldEClass = createEClass(MAPPED_FIELD);
		createEReference(mappedFieldEClass, MAPPED_FIELD__DATA_FIELD);
		createEReference(mappedFieldEClass, MAPPED_FIELD__ENUMERATION_FIELD);
		createEReference(mappedFieldEClass, MAPPED_FIELD__MAPPED_TYPE);
		createEReference(mappedFieldEClass, MAPPED_FIELD__ASPECTS);
		createEReference(mappedFieldEClass, MAPPED_FIELD__PARAMETER);
		createEReference(mappedFieldEClass, MAPPED_FIELD__MAPPED_COMPLEX_TYPE);
		createEAttribute(mappedFieldEClass, MAPPED_FIELD__NAME);
		createEOperation(mappedFieldEClass, MAPPED_FIELD___GET_QUALIFIED_NAME_PARTS__BOOLEAN);
		createEOperation(mappedFieldEClass, MAPPED_FIELD___BUILD_QUALIFIED_NAME__STRING_BOOLEAN);
		createEOperation(mappedFieldEClass, MAPPED_FIELD___GET_EFFECTIVE_TYPE);

		microserviceEClass = createEClass(MICROSERVICE);
		createEAttribute(microserviceEClass, MICROSERVICE__NAME);
		createEAttribute(microserviceEClass, MICROSERVICE__VERSION);
		createEAttribute(microserviceEClass, MICROSERVICE__TYPE);
		createEAttribute(microserviceEClass, MICROSERVICE__VISIBILITY);
		createEAttribute(microserviceEClass, MICROSERVICE__TDEFAULT_PROTOCOLS);
		createEAttribute(microserviceEClass, MICROSERVICE__TSOURCE_MODEL_URI);
		createEReference(microserviceEClass, MICROSERVICE__TECHNOLOGY_REFERENCES);
		createEReference(microserviceEClass, MICROSERVICE__TTYPE_DEFINITION_TECHNOLOGY_IMPORT);
		createEReference(microserviceEClass, MICROSERVICE__TTYPE_DEFINITION_TECHNOLOGY);
		createEReference(microserviceEClass, MICROSERVICE__ENDPOINTS);
		createEReference(microserviceEClass, MICROSERVICE__REQUIRED_MICROSERVICES);
		createEReference(microserviceEClass, MICROSERVICE__REQUIRED_INTERFACES);
		createEReference(microserviceEClass, MICROSERVICE__REQUIRED_OPERATIONS);
		createEReference(microserviceEClass, MICROSERVICE__PROTOCOLS);
		createEReference(microserviceEClass, MICROSERVICE__INTERFACES);
		createEReference(microserviceEClass, MICROSERVICE__ASPECTS);
		createEReference(microserviceEClass, MICROSERVICE__SERVICE_MODEL);
		createEAttribute(microserviceEClass, MICROSERVICE__EFFECTIVELY_IMPLEMENTED);
		createEAttribute(microserviceEClass, MICROSERVICE__EFFECTIVE_VISIBILITY);
		createEAttribute(microserviceEClass, MICROSERVICE__EFFECTIVELY_INTERNAL);
		createEOperation(microserviceEClass, MICROSERVICE___TEFFECTIVE_PROTOCOL_SPECIFICATIONS);
		createEOperation(microserviceEClass, MICROSERVICE___GET_ALL_TYPE_DEFINITION_TECHNOLOGY_REFERENCES);
		createEOperation(microserviceEClass, MICROSERVICE___GET_TYPE_DEFINITION_TECHNOLOGY_IMPORT);
		createEOperation(microserviceEClass, MICROSERVICE___GET_TYPE_DEFINITION_TECHNOLOGY);
		createEOperation(microserviceEClass, MICROSERVICE___GET_QUALIFIED_NAME_PARTS);
		createEOperation(microserviceEClass, MICROSERVICE___BUILD_QUALIFIED_NAME__STRING);
		createEOperation(microserviceEClass, MICROSERVICE___GET_CONTAINED_OPERATIONS);
		createEOperation(microserviceEClass, MICROSERVICE___GET_CONTAINED_REFERRED_OPERATIONS);
		createEOperation(microserviceEClass, MICROSERVICE___GET_REQUIRED_IMPORTS);
		createEOperation(microserviceEClass, MICROSERVICE___GET_ALL_REQUIRED_OPERATIONS__IMPORT);
		createEOperation(microserviceEClass, MICROSERVICE___GET_ALL_REQUIRED_MICROSERVICES);
		createEOperation(microserviceEClass, MICROSERVICE___GET_ALL_INITIALIZING_MICROSERVICES);
		createEOperation(microserviceEClass, MICROSERVICE___CAN_REQUIRE__MICROSERVICE_BOOLEAN);
		createEOperation(microserviceEClass, MICROSERVICE___CAN_REQUIRE__INTERFACE_BOOLEAN);
		createEOperation(microserviceEClass, MICROSERVICE___CAN_REQUIRE__OPERATION_BOOLEAN);

		technologyReferenceEClass = createEClass(TECHNOLOGY_REFERENCE);
		createEAttribute(technologyReferenceEClass, TECHNOLOGY_REFERENCE__IS_TYPE_DEFINITION_TECHNOLOGY);
		createEReference(technologyReferenceEClass, TECHNOLOGY_REFERENCE__TECHNOLOGY);
		createEReference(technologyReferenceEClass, TECHNOLOGY_REFERENCE__MICROSERVICE);
		createEReference(technologyReferenceEClass, TECHNOLOGY_REFERENCE__MAPPED_COMPLEX_TYPE);

		interfaceEClass = createEClass(INTERFACE);
		createEAttribute(interfaceEClass, INTERFACE__NAME);
		createEAttribute(interfaceEClass, INTERFACE__VERSION);
		createEAttribute(interfaceEClass, INTERFACE__NOT_IMPLEMENTED);
		createEAttribute(interfaceEClass, INTERFACE__VISIBILITY);
		createEReference(interfaceEClass, INTERFACE__ENDPOINTS);
		createEReference(interfaceEClass, INTERFACE__PROTOCOLS);
		createEReference(interfaceEClass, INTERFACE__OPERATIONS);
		createEReference(interfaceEClass, INTERFACE__REFERRED_OPERATIONS);
		createEReference(interfaceEClass, INTERFACE__ASPECTS);
		createEReference(interfaceEClass, INTERFACE__MICROSERVICE);
		createEAttribute(interfaceEClass, INTERFACE__EFFECTIVE_VISIBILITY);
		createEAttribute(interfaceEClass, INTERFACE__EFFECTIVELY_IMPLEMENTED);
		createEAttribute(interfaceEClass, INTERFACE__EFFECTIVELY_INTERNAL);
		createEOperation(interfaceEClass, INTERFACE___TEFFECTIVE_PROTOCOL_SPECIFICATIONS);
		createEOperation(interfaceEClass, INTERFACE___GET_QUALIFIED_NAME_PARTS);
		createEOperation(interfaceEClass, INTERFACE___BUILD_QUALIFIED_NAME__STRING);

		operationEClass = createEClass(OPERATION);
		createEAttribute(operationEClass, OPERATION__NAME);
		createEAttribute(operationEClass, OPERATION__NOT_IMPLEMENTED);
		createEAttribute(operationEClass, OPERATION__VISIBILITY);
		createEReference(operationEClass, OPERATION__API_OPERATION_COMMENT);
		createEReference(operationEClass, OPERATION__ENDPOINTS);
		createEReference(operationEClass, OPERATION__PROTOCOLS);
		createEReference(operationEClass, OPERATION__PARAMETERS);
		createEReference(operationEClass, OPERATION__ASPECTS);
		createEReference(operationEClass, OPERATION__INTERFACE);
		createEAttribute(operationEClass, OPERATION__NOT_IMPLEMENTED_BY_CONTAINER);
		createEAttribute(operationEClass, OPERATION__EFFECTIVELY_NOT_IMPLEMENTED);
		createEAttribute(operationEClass, OPERATION__EFFECTIVE_VISIBILITY);
		createEAttribute(operationEClass, OPERATION__EFFECTIVELY_INTERNAL);
		createEOperation(operationEClass, OPERATION___TEFFECTIVE_PROTOCOL_SPECIFICATIONS);
		createEOperation(operationEClass, OPERATION___GET_QUALIFIED_NAME_PARTS);
		createEOperation(operationEClass, OPERATION___BUILD_QUALIFIED_NAME__STRING);

		apiOperationCommentEClass = createEClass(API_OPERATION_COMMENT);
		createEAttribute(apiOperationCommentEClass, API_OPERATION_COMMENT__COMMENT);
		createEReference(apiOperationCommentEClass, API_OPERATION_COMMENT__PARAMETER_COMMENTS);
		createEReference(apiOperationCommentEClass, API_OPERATION_COMMENT__OPERATION);

		apiParameterCommentEClass = createEClass(API_PARAMETER_COMMENT);
		createEAttribute(apiParameterCommentEClass, API_PARAMETER_COMMENT__COMMENT);
		createEAttribute(apiParameterCommentEClass, API_PARAMETER_COMMENT__REQUIRED);
		createEReference(apiParameterCommentEClass, API_PARAMETER_COMMENT__PARAMETER);
		createEReference(apiParameterCommentEClass, API_PARAMETER_COMMENT__OPERATION_COMMENT);

		referredOperationEClass = createEClass(REFERRED_OPERATION);
		createEReference(referredOperationEClass, REFERRED_OPERATION__OPERATION);
		createEReference(referredOperationEClass, REFERRED_OPERATION__ENDPOINTS);
		createEReference(referredOperationEClass, REFERRED_OPERATION__PROTOCOLS);
		createEReference(referredOperationEClass, REFERRED_OPERATION__ASPECTS);
		createEReference(referredOperationEClass, REFERRED_OPERATION__INTERFACE);
		createEOperation(referredOperationEClass, REFERRED_OPERATION___TEFFECTIVE_PROTOCOL_SPECIFICATIONS);
		createEOperation(referredOperationEClass, REFERRED_OPERATION___GET_QUALIFIED_NAME_PARTS);
		createEOperation(referredOperationEClass, REFERRED_OPERATION___BUILD_QUALIFIED_NAME__STRING);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__NAME);
		createEAttribute(parameterEClass, PARAMETER__EXCHANGE_PATTERN);
		createEAttribute(parameterEClass, PARAMETER__COMMUNICATION_TYPE);
		createEAttribute(parameterEClass, PARAMETER__COMMUNICATES_FAULT);
		createEAttribute(parameterEClass, PARAMETER__OPTIONAL);
		createEReference(parameterEClass, PARAMETER__INITIALIZED_BY_OPERATION);
		createEReference(parameterEClass, PARAMETER__IMPORTED_TYPE);
		createEReference(parameterEClass, PARAMETER__PRIMITIVE_TYPE);
		createEReference(parameterEClass, PARAMETER__ASPECTS);
		createEReference(parameterEClass, PARAMETER__MAPPED_FIELDS);
		createEReference(parameterEClass, PARAMETER__ORIGINAL_IMPORTED_TYPE);
		createEReference(parameterEClass, PARAMETER__ORIGINAL_PRIMITIVE_TYPE);
		createEReference(parameterEClass, PARAMETER__OPERATION);
		createEOperation(parameterEClass, PARAMETER___GET_QUALIFIED_NAME_PARTS);
		createEOperation(parameterEClass, PARAMETER___BUILD_QUALIFIED_NAME__STRING);
		createEOperation(parameterEClass, PARAMETER___BASICALLY_INITIALIZABLE_BY__OPERATION);
		createEOperation(parameterEClass, PARAMETER___GET_EFFECTIVE_TYPE);
		createEOperation(parameterEClass, PARAMETER___IS_TECHNOLOGY_SPECIFIC_EFFECTIVE_TYPE);
		createEOperation(parameterEClass, PARAMETER___GET_EFFECTIVE_TYPE_QUALIFIED_NAME_PARTS);

		possiblyImportedMicroserviceEClass = createEClass(POSSIBLY_IMPORTED_MICROSERVICE);
		createEReference(possiblyImportedMicroserviceEClass, POSSIBLY_IMPORTED_MICROSERVICE__IMPORT);
		createEReference(possiblyImportedMicroserviceEClass, POSSIBLY_IMPORTED_MICROSERVICE__MICROSERVICE);
		createEReference(possiblyImportedMicroserviceEClass, POSSIBLY_IMPORTED_MICROSERVICE__REQUIRING_MICROSERVICE);

		possiblyImportedInterfaceEClass = createEClass(POSSIBLY_IMPORTED_INTERFACE);
		createEReference(possiblyImportedInterfaceEClass, POSSIBLY_IMPORTED_INTERFACE__IMPORT);
		createEReference(possiblyImportedInterfaceEClass, POSSIBLY_IMPORTED_INTERFACE__INTERFACE);
		createEReference(possiblyImportedInterfaceEClass, POSSIBLY_IMPORTED_INTERFACE__REQUIRING_MICROSERVICE);
		createEAttribute(possiblyImportedInterfaceEClass, POSSIBLY_IMPORTED_INTERFACE__REQUIRED);
		createEAttribute(possiblyImportedInterfaceEClass, POSSIBLY_IMPORTED_INTERFACE__REQUIRED_BY_CONTAINER);

		possiblyImportedOperationEClass = createEClass(POSSIBLY_IMPORTED_OPERATION);
		createEReference(possiblyImportedOperationEClass, POSSIBLY_IMPORTED_OPERATION__IMPORT);
		createEReference(possiblyImportedOperationEClass, POSSIBLY_IMPORTED_OPERATION__OPERATION);
		createEReference(possiblyImportedOperationEClass, POSSIBLY_IMPORTED_OPERATION__REQUIRING_MICROSERVICE);
		createEReference(possiblyImportedOperationEClass, POSSIBLY_IMPORTED_OPERATION__INITIALIZED_PARAMETER);
		createEAttribute(possiblyImportedOperationEClass, POSSIBLY_IMPORTED_OPERATION__REQUIRED);
		createEAttribute(possiblyImportedOperationEClass, POSSIBLY_IMPORTED_OPERATION__REQUIRED_BY_INTERFACE);
		createEAttribute(possiblyImportedOperationEClass, POSSIBLY_IMPORTED_OPERATION__REQUIRED_BY_MICROSERVICE);
		createEAttribute(possiblyImportedOperationEClass, POSSIBLY_IMPORTED_OPERATION__REQUIRED_BY_CONTAINER);

		importedTypeEClass = createEClass(IMPORTED_TYPE);
		createEReference(importedTypeEClass, IMPORTED_TYPE__IMPORT);
		createEReference(importedTypeEClass, IMPORTED_TYPE__TYPE);

		importedProtocolAndDataFormatEClass = createEClass(IMPORTED_PROTOCOL_AND_DATA_FORMAT);
		createEReference(importedProtocolAndDataFormatEClass, IMPORTED_PROTOCOL_AND_DATA_FORMAT__IMPORT);
		createEReference(importedProtocolAndDataFormatEClass, IMPORTED_PROTOCOL_AND_DATA_FORMAT__IMPORTED_PROTOCOL);
		createEReference(importedProtocolAndDataFormatEClass, IMPORTED_PROTOCOL_AND_DATA_FORMAT__DATA_FORMAT);
		createEReference(importedProtocolAndDataFormatEClass, IMPORTED_PROTOCOL_AND_DATA_FORMAT__SPECIFICATION);
		createEReference(importedProtocolAndDataFormatEClass, IMPORTED_PROTOCOL_AND_DATA_FORMAT__ENDPOINT);

		protocolSpecificationEClass = createEClass(PROTOCOL_SPECIFICATION);
		createEAttribute(protocolSpecificationEClass, PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE);
		createEReference(protocolSpecificationEClass, PROTOCOL_SPECIFICATION__PROTOCOL);
		createEOperation(protocolSpecificationEClass, PROTOCOL_SPECIFICATION___EFFECTIVE_PROTOCOL_SPECIFICATIONS__ELIST);

		endpointEClass = createEClass(ENDPOINT);
		createEAttribute(endpointEClass, ENDPOINT__ADDRESSES);
		createEReference(endpointEClass, ENDPOINT__PROTOCOLS);
		createEReference(endpointEClass, ENDPOINT__MICROSERVICE);
		createEReference(endpointEClass, ENDPOINT__INTERFACE);
		createEReference(endpointEClass, ENDPOINT__OPERATION);
		createEReference(endpointEClass, ENDPOINT__REFERRED_OPERATION);

		importedServiceAspectEClass = createEClass(IMPORTED_SERVICE_ASPECT);
		createEReference(importedServiceAspectEClass, IMPORTED_SERVICE_ASPECT__IMPORT);
		createEReference(importedServiceAspectEClass, IMPORTED_SERVICE_ASPECT__IMPORTED_ASPECT);
		createEReference(importedServiceAspectEClass, IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE);
		createEReference(importedServiceAspectEClass, IMPORTED_SERVICE_ASPECT__VALUES);
		createEReference(importedServiceAspectEClass, IMPORTED_SERVICE_ASPECT__MICROSERVICE);
		createEReference(importedServiceAspectEClass, IMPORTED_SERVICE_ASPECT__INTERFACE);
		createEReference(importedServiceAspectEClass, IMPORTED_SERVICE_ASPECT__OPERATION);
		createEReference(importedServiceAspectEClass, IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION);
		createEReference(importedServiceAspectEClass, IMPORTED_SERVICE_ASPECT__PARAMETER);
		createEReference(importedServiceAspectEClass, IMPORTED_SERVICE_ASPECT__MAPPED_COMPLEX_TYPE);
		createEReference(importedServiceAspectEClass, IMPORTED_SERVICE_ASPECT__MAPPED_FIELD);
		createEReference(importedServiceAspectEClass, IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION);
		createEReference(importedServiceAspectEClass, IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_RETURN_TYPE);
		createEReference(importedServiceAspectEClass, IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_PARAMETER);

		// Create enums
		importTypeEEnum = createEEnum(IMPORT_TYPE);
		microserviceTypeEEnum = createEEnum(MICROSERVICE_TYPE);
		visibilityEEnum = createEEnum(VISIBILITY);

		// Create data types
		tupleListEDataType = createEDataType(TUPLE_LIST);
		microserviceImportMapEDataType = createEDataType(MICROSERVICE_IMPORT_MAP);
		defaultProtocolsEDataType = createEDataType(DEFAULT_PROTOCOLS);
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
		TechnologyPackage theTechnologyPackage = (TechnologyPackage)EPackage.Registry.INSTANCE.getEPackage(TechnologyPackage.eNS_URI);
		DataPackage theDataPackage = (DataPackage)EPackage.Registry.INSTANCE.getEPackage(DataPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(serviceModelEClass, ServiceModel.class, "ServiceModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceModel_T_modelUri(), theEcorePackage.getEString(), "t_modelUri", null, 0, 1, ServiceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceModel_Imports(), this.getImport(), this.getImport_ServiceModel(), "imports", null, 0, -1, ServiceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceModel_MappedComplexTypes(), this.getMappedComplexType(), this.getMappedComplexType_ServiceModel(), "mappedComplexTypes", null, 0, -1, ServiceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceModel_Microservices(), this.getMicroservice(), this.getMicroservice_ServiceModel(), "microservices", null, 1, -1, ServiceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getServiceModel__GetContainedOperations(), this.getOperation(), "getContainedOperations", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getServiceModel__GetContainedReferredOperations(), this.getReferredOperation(), "getContainedReferredOperations", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getServiceModel__GetContainedInterfaces(), this.getInterface(), "getContainedInterfaces", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImport_T_relatedImportAlias(), theEcorePackage.getEString(), "t_relatedImportAlias", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImport_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImport_ImportURI(), theEcorePackage.getEString(), "importURI", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImport_ExternalURI(), theEcorePackage.getEString(), "externalURI", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImport_ImportType(), this.getImportType(), "importType", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImport_ServiceModel(), this.getServiceModel(), this.getServiceModel_Imports(), "serviceModel", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappedComplexTypeEClass, MappedComplexType.class, "MappedComplexType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappedComplexType_T_sourceModelUri(), theEcorePackage.getEString(), "t_sourceModelUri", null, 0, 1, MappedComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedComplexType_T_typeDefinitionTechnologyImport(), this.getImport(), null, "t_typeDefinitionTechnologyImport", null, 0, 1, MappedComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedComplexType_T_typeDefinitionTechnology(), theTechnologyPackage.getTechnology(), null, "t_typeDefinitionTechnology", null, 0, 1, MappedComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedComplexType_TechnologyReferences(), this.getTechnologyReference(), this.getTechnologyReference_MappedComplexType(), "technologyReferences", null, 0, -1, MappedComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedComplexType_Type(), this.getImportedType(), null, "type", null, 0, 1, MappedComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedComplexType_MappedFields(), this.getMappedField(), this.getMappedField_MappedComplexType(), "mappedFields", null, 0, -1, MappedComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedComplexType_MappedOperations(), this.getMappedDataOperation(), this.getMappedDataOperation_MappedComplexType(), "mappedOperations", null, 0, -1, MappedComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedComplexType_Aspects(), this.getImportedServiceAspect(), this.getImportedServiceAspect_MappedComplexType(), "aspects", null, 0, -1, MappedComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedComplexType_ServiceModel(), this.getServiceModel(), this.getServiceModel_MappedComplexTypes(), "serviceModel", null, 0, 1, MappedComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getMappedComplexType__GetQualifiedNameParts__boolean(), theEcorePackage.getEString(), "getQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEBoolean(), "withImportName", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMappedComplexType__BuildQualifiedName__String_boolean(), theEcorePackage.getEString(), "buildQualifiedName", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "separator", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEBoolean(), "withImportName", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getMappedComplexType__GetAllTypeDefinitionTechnologyReferences(), this.getTechnologyReference(), "getAllTypeDefinitionTechnologyReferences", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getMappedComplexType__GetTypeDefinitionTechnologyImport(), this.getImport(), "getTypeDefinitionTechnologyImport", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getMappedComplexType__GetTypeDefinitionTechnology(), theTechnologyPackage.getTechnology(), "getTypeDefinitionTechnology", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(mappedDataOperationEClass, MappedDataOperation.class, "MappedDataOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappedDataOperation_DataOperation(), theDataPackage.getDataOperation(), null, "dataOperation", null, 0, 1, MappedDataOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedDataOperation_Aspects(), this.getImportedServiceAspect(), this.getImportedServiceAspect_MappedDataOperation(), "aspects", null, 0, -1, MappedDataOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedDataOperation_MappedReturnType(), this.getMappedDataOperationReturnType(), this.getMappedDataOperationReturnType_MappedOperation(), "mappedReturnType", null, 0, 1, MappedDataOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedDataOperation_MappedParameters(), this.getMappedDataOperationParameter(), this.getMappedDataOperationParameter_MappedOperation(), "mappedParameters", null, 0, -1, MappedDataOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedDataOperation_MappedComplexType(), this.getMappedComplexType(), this.getMappedComplexType_MappedOperations(), "mappedComplexType", null, 0, 1, MappedDataOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappedDataOperationReturnTypeEClass, MappedDataOperationReturnType.class, "MappedDataOperationReturnType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappedDataOperationReturnType_MappedType(), this.getImportedType(), null, "mappedType", null, 0, 1, MappedDataOperationReturnType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedDataOperationReturnType_Aspects(), this.getImportedServiceAspect(), this.getImportedServiceAspect_MappedDataOperationReturnType(), "aspects", null, 0, -1, MappedDataOperationReturnType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedDataOperationReturnType_MappedOperation(), this.getMappedDataOperation(), this.getMappedDataOperation_MappedReturnType(), "mappedOperation", null, 0, 1, MappedDataOperationReturnType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappedDataOperationParameterEClass, MappedDataOperationParameter.class, "MappedDataOperationParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappedDataOperationParameter_Parameter(), theDataPackage.getDataOperationParameter(), null, "parameter", null, 0, 1, MappedDataOperationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedDataOperationParameter_MappedType(), this.getImportedType(), null, "mappedType", null, 0, 1, MappedDataOperationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedDataOperationParameter_Aspects(), this.getImportedServiceAspect(), this.getImportedServiceAspect_MappedDataOperationParameter(), "aspects", null, 0, -1, MappedDataOperationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedDataOperationParameter_MappedOperation(), this.getMappedDataOperation(), this.getMappedDataOperation_MappedParameters(), "mappedOperation", null, 0, 1, MappedDataOperationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappedFieldEClass, MappedField.class, "MappedField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappedField_DataField(), theDataPackage.getDataField(), null, "dataField", null, 0, 1, MappedField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedField_EnumerationField(), theDataPackage.getEnumerationField(), null, "enumerationField", null, 0, 1, MappedField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedField_MappedType(), this.getImportedType(), null, "mappedType", null, 0, 1, MappedField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedField_Aspects(), this.getImportedServiceAspect(), this.getImportedServiceAspect_MappedField(), "aspects", null, 0, -1, MappedField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedField_Parameter(), this.getParameter(), this.getParameter_MappedFields(), "parameter", null, 0, 1, MappedField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedField_MappedComplexType(), this.getMappedComplexType(), this.getMappedComplexType_MappedFields(), "mappedComplexType", null, 0, 1, MappedField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappedField_Name(), theEcorePackage.getEString(), "name", null, 0, 1, MappedField.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = initEOperation(getMappedField__GetQualifiedNameParts__boolean(), theEcorePackage.getEString(), "getQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEBoolean(), "withImportName", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMappedField__BuildQualifiedName__String_boolean(), theEcorePackage.getEString(), "buildQualifiedName", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "separator", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEBoolean(), "withImportName", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getMappedField__GetEffectiveType(), theDataPackage.getType(), "getEffectiveType", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(microserviceEClass, Microservice.class, "Microservice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMicroservice_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Microservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMicroservice_Version(), theEcorePackage.getEString(), "version", null, 0, 1, Microservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMicroservice_Type(), this.getMicroserviceType(), "type", null, 0, 1, Microservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMicroservice_Visibility(), this.getVisibility(), "visibility", "NONE", 0, 1, Microservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMicroservice_T_defaultProtocols(), this.getDefaultProtocols(), "t_defaultProtocols", null, 0, 1, Microservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMicroservice_T_sourceModelUri(), theEcorePackage.getEString(), "t_sourceModelUri", null, 0, 1, Microservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMicroservice_TechnologyReferences(), this.getTechnologyReference(), this.getTechnologyReference_Microservice(), "technologyReferences", null, 0, -1, Microservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMicroservice_T_typeDefinitionTechnologyImport(), this.getImport(), null, "t_typeDefinitionTechnologyImport", null, 0, 1, Microservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMicroservice_T_typeDefinitionTechnology(), theTechnologyPackage.getTechnology(), null, "t_typeDefinitionTechnology", null, 0, 1, Microservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMicroservice_Endpoints(), this.getEndpoint(), this.getEndpoint_Microservice(), "endpoints", null, 0, -1, Microservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMicroservice_RequiredMicroservices(), this.getPossiblyImportedMicroservice(), this.getPossiblyImportedMicroservice_RequiringMicroservice(), "requiredMicroservices", null, 0, -1, Microservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMicroservice_RequiredInterfaces(), this.getPossiblyImportedInterface(), this.getPossiblyImportedInterface_RequiringMicroservice(), "requiredInterfaces", null, 0, -1, Microservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMicroservice_RequiredOperations(), this.getPossiblyImportedOperation(), this.getPossiblyImportedOperation_RequiringMicroservice(), "requiredOperations", null, 0, -1, Microservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMicroservice_Protocols(), this.getProtocolSpecification(), null, "protocols", null, 0, 2, Microservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMicroservice_Interfaces(), this.getInterface(), this.getInterface_Microservice(), "interfaces", null, 1, -1, Microservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMicroservice_Aspects(), this.getImportedServiceAspect(), this.getImportedServiceAspect_Microservice(), "aspects", null, 0, -1, Microservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMicroservice_ServiceModel(), this.getServiceModel(), this.getServiceModel_Microservices(), "serviceModel", null, 0, 1, Microservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMicroservice_EffectivelyImplemented(), theEcorePackage.getEBoolean(), "effectivelyImplemented", null, 0, 1, Microservice.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getMicroservice_EffectiveVisibility(), this.getVisibility(), "effectiveVisibility", null, 0, 1, Microservice.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getMicroservice_EffectivelyInternal(), theEcorePackage.getEBoolean(), "effectivelyInternal", null, 0, 1, Microservice.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getMicroservice__T_effectiveProtocolSpecifications(), this.getTupleList(), "t_effectiveProtocolSpecifications", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getMicroservice__GetAllTypeDefinitionTechnologyReferences(), this.getTechnologyReference(), "getAllTypeDefinitionTechnologyReferences", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getMicroservice__GetTypeDefinitionTechnologyImport(), this.getImport(), "getTypeDefinitionTechnologyImport", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getMicroservice__GetTypeDefinitionTechnology(), theTechnologyPackage.getTechnology(), "getTypeDefinitionTechnology", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getMicroservice__GetQualifiedNameParts(), theEcorePackage.getEString(), "getQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMicroservice__BuildQualifiedName__String(), theEcorePackage.getEString(), "buildQualifiedName", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "separator", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getMicroservice__GetContainedOperations(), this.getOperation(), "getContainedOperations", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getMicroservice__GetContainedReferredOperations(), this.getReferredOperation(), "getContainedReferredOperations", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getMicroservice__GetRequiredImports(), this.getImport(), "getRequiredImports", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMicroservice__GetAllRequiredOperations__Import(), this.getOperation(), "getAllRequiredOperations", 0, -1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImport(), "fromImport", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getMicroservice__GetAllRequiredMicroservices(), this.getMicroserviceImportMap(), "getAllRequiredMicroservices", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getMicroservice__GetAllInitializingMicroservices(), this.getMicroservice(), "getAllInitializingMicroservices", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMicroservice__CanRequire__Microservice_boolean(), theEcorePackage.getEBoolean(), "canRequire", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMicroservice(), "microservice", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEBoolean(), "isImportedService", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMicroservice__CanRequire__Interface_boolean(), theEcorePackage.getEBoolean(), "canRequire", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getInterface(), "iface", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEBoolean(), "isImportedInterface", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMicroservice__CanRequire__Operation_boolean(), theEcorePackage.getEBoolean(), "canRequire", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOperation(), "operation", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEBoolean(), "isImportedOperation", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(technologyReferenceEClass, TechnologyReference.class, "TechnologyReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTechnologyReference_IsTypeDefinitionTechnology(), theEcorePackage.getEBoolean(), "isTypeDefinitionTechnology", null, 0, 1, TechnologyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTechnologyReference_Technology(), this.getImport(), null, "technology", null, 0, 1, TechnologyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTechnologyReference_Microservice(), this.getMicroservice(), this.getMicroservice_TechnologyReferences(), "microservice", null, 0, 1, TechnologyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTechnologyReference_MappedComplexType(), this.getMappedComplexType(), this.getMappedComplexType_TechnologyReferences(), "mappedComplexType", null, 0, 1, TechnologyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceEClass, Interface.class, "Interface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInterface_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterface_Version(), theEcorePackage.getEString(), "version", null, 0, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterface_NotImplemented(), theEcorePackage.getEBoolean(), "notImplemented", "false", 0, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterface_Visibility(), this.getVisibility(), "visibility", "NONE", 0, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterface_Endpoints(), this.getEndpoint(), this.getEndpoint_Interface(), "endpoints", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterface_Protocols(), this.getProtocolSpecification(), null, "protocols", null, 0, 2, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterface_Operations(), this.getOperation(), this.getOperation_Interface(), "operations", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterface_ReferredOperations(), this.getReferredOperation(), this.getReferredOperation_Interface(), "referredOperations", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterface_Aspects(), this.getImportedServiceAspect(), this.getImportedServiceAspect_Interface(), "aspects", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterface_Microservice(), this.getMicroservice(), this.getMicroservice_Interfaces(), "microservice", null, 0, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterface_EffectiveVisibility(), this.getVisibility(), "effectiveVisibility", null, 0, 1, Interface.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterface_EffectivelyImplemented(), theEcorePackage.getEBoolean(), "effectivelyImplemented", null, 0, 1, Interface.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterface_EffectivelyInternal(), theEcorePackage.getEBoolean(), "effectivelyInternal", null, 0, 1, Interface.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getInterface__T_effectiveProtocolSpecifications(), this.getTupleList(), "t_effectiveProtocolSpecifications", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getInterface__GetQualifiedNameParts(), theEcorePackage.getEString(), "getQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getInterface__BuildQualifiedName__String(), theEcorePackage.getEString(), "buildQualifiedName", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "separator", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperation_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperation_NotImplemented(), theEcorePackage.getEBoolean(), "notImplemented", "false", 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperation_Visibility(), this.getVisibility(), "visibility", "NONE", 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperation_ApiOperationComment(), this.getApiOperationComment(), this.getApiOperationComment_Operation(), "apiOperationComment", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperation_Endpoints(), this.getEndpoint(), this.getEndpoint_Operation(), "endpoints", null, 0, -1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperation_Protocols(), this.getProtocolSpecification(), null, "protocols", null, 0, 2, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperation_Parameters(), this.getParameter(), this.getParameter_Operation(), "parameters", null, 0, -1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperation_Aspects(), this.getImportedServiceAspect(), this.getImportedServiceAspect_Operation(), "aspects", null, 0, -1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperation_Interface(), this.getInterface(), this.getInterface_Operations(), "interface", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperation_NotImplementedByContainer(), theEcorePackage.getEBoolean(), "notImplementedByContainer", null, 0, 1, Operation.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperation_EffectivelyNotImplemented(), theEcorePackage.getEBoolean(), "effectivelyNotImplemented", null, 0, 1, Operation.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperation_EffectiveVisibility(), this.getVisibility(), "effectiveVisibility", null, 0, 1, Operation.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperation_EffectivelyInternal(), theEcorePackage.getEBoolean(), "effectivelyInternal", null, 0, 1, Operation.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getOperation__T_effectiveProtocolSpecifications(), this.getTupleList(), "t_effectiveProtocolSpecifications", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getOperation__GetQualifiedNameParts(), theEcorePackage.getEString(), "getQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getOperation__BuildQualifiedName__String(), theEcorePackage.getEString(), "buildQualifiedName", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "separator", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(apiOperationCommentEClass, ApiOperationComment.class, "ApiOperationComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getApiOperationComment_Comment(), theEcorePackage.getEString(), "comment", null, 0, 1, ApiOperationComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApiOperationComment_ParameterComments(), this.getApiParameterComment(), this.getApiParameterComment_OperationComment(), "parameterComments", null, 0, -1, ApiOperationComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApiOperationComment_Operation(), this.getOperation(), this.getOperation_ApiOperationComment(), "operation", null, 0, 1, ApiOperationComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(apiParameterCommentEClass, ApiParameterComment.class, "ApiParameterComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getApiParameterComment_Comment(), theEcorePackage.getEString(), "comment", null, 0, 1, ApiParameterComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApiParameterComment_Required(), theEcorePackage.getEBoolean(), "required", null, 0, 1, ApiParameterComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApiParameterComment_Parameter(), this.getParameter(), null, "parameter", null, 0, 1, ApiParameterComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApiParameterComment_OperationComment(), this.getApiOperationComment(), this.getApiOperationComment_ParameterComments(), "operationComment", null, 0, 1, ApiParameterComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referredOperationEClass, ReferredOperation.class, "ReferredOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferredOperation_Operation(), this.getOperation(), null, "operation", null, 0, 1, ReferredOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferredOperation_Endpoints(), this.getEndpoint(), this.getEndpoint_ReferredOperation(), "endpoints", null, 0, -1, ReferredOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferredOperation_Protocols(), this.getProtocolSpecification(), null, "protocols", null, 0, 2, ReferredOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferredOperation_Aspects(), this.getImportedServiceAspect(), this.getImportedServiceAspect_ReferredOperation(), "aspects", null, 0, -1, ReferredOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferredOperation_Interface(), this.getInterface(), this.getInterface_ReferredOperations(), "interface", null, 0, 1, ReferredOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getReferredOperation__T_effectiveProtocolSpecifications(), this.getTupleList(), "t_effectiveProtocolSpecifications", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReferredOperation__GetQualifiedNameParts(), theEcorePackage.getEString(), "getQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getReferredOperation__BuildQualifiedName__String(), theEcorePackage.getEString(), "buildQualifiedName", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "separator", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_ExchangePattern(), theTechnologyPackage.getExchangePattern(), "exchangePattern", "IN", 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_CommunicationType(), theTechnologyPackage.getCommunicationType(), "communicationType", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_CommunicatesFault(), theEcorePackage.getEBoolean(), "communicatesFault", "false", 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Optional(), theEcorePackage.getEBoolean(), "optional", "false", 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameter_InitializedByOperation(), this.getPossiblyImportedOperation(), this.getPossiblyImportedOperation_InitializedParameter(), "initializedByOperation", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameter_ImportedType(), this.getImportedType(), null, "importedType", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameter_PrimitiveType(), theDataPackage.getPrimitiveType(), null, "primitiveType", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameter_Aspects(), this.getImportedServiceAspect(), this.getImportedServiceAspect_Parameter(), "aspects", null, 0, -1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameter_MappedFields(), this.getMappedField(), this.getMappedField_Parameter(), "mappedFields", null, 0, -1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameter_OriginalImportedType(), this.getImportedType(), null, "originalImportedType", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameter_OriginalPrimitiveType(), theDataPackage.getPrimitiveType(), null, "originalPrimitiveType", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameter_Operation(), this.getOperation(), this.getOperation_Parameters(), "operation", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getParameter__GetQualifiedNameParts(), theEcorePackage.getEString(), "getQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getParameter__BuildQualifiedName__String(), theEcorePackage.getEString(), "buildQualifiedName", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "separator", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getParameter__BasicallyInitializableBy__Operation(), theEcorePackage.getEBoolean(), "basicallyInitializableBy", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOperation(), "initializingOperation", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getParameter__GetEffectiveType(), theDataPackage.getType(), "getEffectiveType", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getParameter__IsTechnologySpecificEffectiveType(), theEcorePackage.getEBoolean(), "isTechnologySpecificEffectiveType", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getParameter__GetEffectiveTypeQualifiedNameParts(), theEcorePackage.getEString(), "getEffectiveTypeQualifiedNameParts", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(possiblyImportedMicroserviceEClass, PossiblyImportedMicroservice.class, "PossiblyImportedMicroservice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPossiblyImportedMicroservice_Import(), this.getImport(), null, "import", null, 0, 1, PossiblyImportedMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPossiblyImportedMicroservice_Microservice(), this.getMicroservice(), null, "microservice", null, 0, 1, PossiblyImportedMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPossiblyImportedMicroservice_RequiringMicroservice(), this.getMicroservice(), this.getMicroservice_RequiredMicroservices(), "requiringMicroservice", null, 0, 1, PossiblyImportedMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(possiblyImportedInterfaceEClass, PossiblyImportedInterface.class, "PossiblyImportedInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPossiblyImportedInterface_Import(), this.getImport(), null, "import", null, 0, 1, PossiblyImportedInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPossiblyImportedInterface_Interface(), this.getInterface(), null, "interface", null, 0, 1, PossiblyImportedInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPossiblyImportedInterface_RequiringMicroservice(), this.getMicroservice(), this.getMicroservice_RequiredInterfaces(), "requiringMicroservice", null, 0, 1, PossiblyImportedInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPossiblyImportedInterface_Required(), theEcorePackage.getEBoolean(), "required", null, 0, 1, PossiblyImportedInterface.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPossiblyImportedInterface_RequiredByContainer(), theEcorePackage.getEBoolean(), "requiredByContainer", null, 0, 1, PossiblyImportedInterface.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(possiblyImportedOperationEClass, PossiblyImportedOperation.class, "PossiblyImportedOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPossiblyImportedOperation_Import(), this.getImport(), null, "import", null, 0, 1, PossiblyImportedOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPossiblyImportedOperation_Operation(), this.getOperation(), null, "operation", null, 0, 1, PossiblyImportedOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPossiblyImportedOperation_RequiringMicroservice(), this.getMicroservice(), this.getMicroservice_RequiredOperations(), "requiringMicroservice", null, 0, 1, PossiblyImportedOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPossiblyImportedOperation_InitializedParameter(), this.getParameter(), this.getParameter_InitializedByOperation(), "initializedParameter", null, 0, 1, PossiblyImportedOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPossiblyImportedOperation_Required(), theEcorePackage.getEBoolean(), "required", null, 0, 1, PossiblyImportedOperation.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPossiblyImportedOperation_RequiredByInterface(), theEcorePackage.getEBoolean(), "requiredByInterface", null, 0, 1, PossiblyImportedOperation.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPossiblyImportedOperation_RequiredByMicroservice(), theEcorePackage.getEBoolean(), "requiredByMicroservice", null, 0, 1, PossiblyImportedOperation.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPossiblyImportedOperation_RequiredByContainer(), theEcorePackage.getEBoolean(), "requiredByContainer", null, 0, 1, PossiblyImportedOperation.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(importedTypeEClass, ImportedType.class, "ImportedType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImportedType_Import(), this.getImport(), null, "import", null, 0, 1, ImportedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportedType_Type(), theDataPackage.getType(), null, "type", null, 0, 1, ImportedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(importedProtocolAndDataFormatEClass, ImportedProtocolAndDataFormat.class, "ImportedProtocolAndDataFormat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImportedProtocolAndDataFormat_Import(), this.getImport(), null, "import", null, 0, 1, ImportedProtocolAndDataFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportedProtocolAndDataFormat_ImportedProtocol(), theTechnologyPackage.getProtocol(), null, "importedProtocol", null, 0, 1, ImportedProtocolAndDataFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportedProtocolAndDataFormat_DataFormat(), theTechnologyPackage.getDataFormat(), null, "dataFormat", null, 0, 1, ImportedProtocolAndDataFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportedProtocolAndDataFormat_Specification(), this.getProtocolSpecification(), this.getProtocolSpecification_Protocol(), "specification", null, 0, 1, ImportedProtocolAndDataFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportedProtocolAndDataFormat_Endpoint(), this.getEndpoint(), this.getEndpoint_Protocols(), "endpoint", null, 0, 1, ImportedProtocolAndDataFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(protocolSpecificationEClass, ProtocolSpecification.class, "ProtocolSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProtocolSpecification_CommunicationType(), theTechnologyPackage.getCommunicationType(), "communicationType", null, 0, 1, ProtocolSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProtocolSpecification_Protocol(), this.getImportedProtocolAndDataFormat(), this.getImportedProtocolAndDataFormat_Specification(), "protocol", null, 0, 1, ProtocolSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getProtocolSpecification__EffectiveProtocolSpecifications__EList(), this.getTupleList(), "effectiveProtocolSpecifications", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProtocolSpecification(), "specifications", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(endpointEClass, Endpoint.class, "Endpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEndpoint_Addresses(), theEcorePackage.getEString(), "addresses", null, 1, -1, Endpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEndpoint_Protocols(), this.getImportedProtocolAndDataFormat(), this.getImportedProtocolAndDataFormat_Endpoint(), "protocols", null, 1, -1, Endpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEndpoint_Microservice(), this.getMicroservice(), this.getMicroservice_Endpoints(), "microservice", null, 0, 1, Endpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEndpoint_Interface(), this.getInterface(), this.getInterface_Endpoints(), "interface", null, 0, 1, Endpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEndpoint_Operation(), this.getOperation(), this.getOperation_Endpoints(), "operation", null, 0, 1, Endpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEndpoint_ReferredOperation(), this.getReferredOperation(), this.getReferredOperation_Endpoints(), "referredOperation", null, 0, 1, Endpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(importedServiceAspectEClass, ImportedServiceAspect.class, "ImportedServiceAspect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImportedServiceAspect_Import(), this.getImport(), null, "import", null, 0, 1, ImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportedServiceAspect_ImportedAspect(), theTechnologyPackage.getServiceAspect(), null, "importedAspect", null, 0, 1, ImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportedServiceAspect_SinglePropertyValue(), theDataPackage.getPrimitiveValue(), null, "singlePropertyValue", null, 0, 1, ImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportedServiceAspect_Values(), theTechnologyPackage.getTechnologySpecificPropertyValueAssignment(), null, "values", null, 0, -1, ImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportedServiceAspect_Microservice(), this.getMicroservice(), this.getMicroservice_Aspects(), "microservice", null, 0, 1, ImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportedServiceAspect_Interface(), this.getInterface(), this.getInterface_Aspects(), "interface", null, 0, 1, ImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportedServiceAspect_Operation(), this.getOperation(), this.getOperation_Aspects(), "operation", null, 0, 1, ImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportedServiceAspect_ReferredOperation(), this.getReferredOperation(), this.getReferredOperation_Aspects(), "referredOperation", null, 0, 1, ImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportedServiceAspect_Parameter(), this.getParameter(), this.getParameter_Aspects(), "parameter", null, 0, 1, ImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportedServiceAspect_MappedComplexType(), this.getMappedComplexType(), this.getMappedComplexType_Aspects(), "mappedComplexType", null, 0, 1, ImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportedServiceAspect_MappedField(), this.getMappedField(), this.getMappedField_Aspects(), "mappedField", null, 0, 1, ImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportedServiceAspect_MappedDataOperation(), this.getMappedDataOperation(), this.getMappedDataOperation_Aspects(), "mappedDataOperation", null, 0, 1, ImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportedServiceAspect_MappedDataOperationReturnType(), this.getMappedDataOperationReturnType(), this.getMappedDataOperationReturnType_Aspects(), "mappedDataOperationReturnType", null, 0, 1, ImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportedServiceAspect_MappedDataOperationParameter(), this.getMappedDataOperationParameter(), this.getMappedDataOperationParameter_Aspects(), "mappedDataOperationParameter", null, 0, 1, ImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(importTypeEEnum, ImportType.class, "ImportType");
		addEEnumLiteral(importTypeEEnum, ImportType.DATATYPES);
		addEEnumLiteral(importTypeEEnum, ImportType.TECHNOLOGY);
		addEEnumLiteral(importTypeEEnum, ImportType.MICROSERVICES);
		addEEnumLiteral(importTypeEEnum, ImportType.OPERATION_NODES);

		initEEnum(microserviceTypeEEnum, MicroserviceType.class, "MicroserviceType");
		addEEnumLiteral(microserviceTypeEEnum, MicroserviceType.FUNCTIONAL);
		addEEnumLiteral(microserviceTypeEEnum, MicroserviceType.UTILITY);
		addEEnumLiteral(microserviceTypeEEnum, MicroserviceType.INFRASTRUCTURE);

		initEEnum(visibilityEEnum, Visibility.class, "Visibility");
		addEEnumLiteral(visibilityEEnum, Visibility.NONE);
		addEEnumLiteral(visibilityEEnum, Visibility.INTERNAL);
		addEEnumLiteral(visibilityEEnum, Visibility.IN_MODEL);
		addEEnumLiteral(visibilityEEnum, Visibility.ARCHITECTURE);
		addEEnumLiteral(visibilityEEnum, Visibility.PUBLIC);

		// Initialize data types
		initEDataType(tupleListEDataType, List.class, "TupleList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.List<java.util.Map<java.lang.String, java.lang.Object>>");
		initEDataType(microserviceImportMapEDataType, Map.class, "MicroserviceImportMap", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.Map<de.fhdo.lemma.service.Microservice, de.fhdo.lemma.service.Import>");
		initEDataType(defaultProtocolsEDataType, Map.class, "DefaultProtocols", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.Map<de.fhdo.lemma.technology.CommunicationType, org.eclipse.xtext.xbase.lib.Pair<de.fhdo.lemma.service.Import, de.fhdo.lemma.technology.Protocol>>");

		// Create resource
		createResource(eNS_URI);
	}

} //ServicePackageImpl
