/**
 */
package de.fhdo.lemma.technology.mapping.impl;

import de.fhdo.lemma.data.DataPackage;

import de.fhdo.lemma.service.ServicePackage;

import de.fhdo.lemma.technology.TechnologyPackage;

import de.fhdo.lemma.technology.mapping.ComplexParameterMapping;
import de.fhdo.lemma.technology.mapping.ComplexTypeMapping;
import de.fhdo.lemma.technology.mapping.DataOperationMapping;
import de.fhdo.lemma.technology.mapping.DataOperationParameterMapping;
import de.fhdo.lemma.technology.mapping.DataOperationReturnTypeMapping;
import de.fhdo.lemma.technology.mapping.ImportedComplexTypeToMap;
import de.fhdo.lemma.technology.mapping.ImportedMicroservice;
import de.fhdo.lemma.technology.mapping.InterfaceMapping;
import de.fhdo.lemma.technology.mapping.MappingFactory;
import de.fhdo.lemma.technology.mapping.MappingPackage;
import de.fhdo.lemma.technology.mapping.MicroserviceMapping;
import de.fhdo.lemma.technology.mapping.OperationMapping;
import de.fhdo.lemma.technology.mapping.ParameterMapping;
import de.fhdo.lemma.technology.mapping.PrimitiveParameterMapping;
import de.fhdo.lemma.technology.mapping.ReferredOperationMapping;
import de.fhdo.lemma.technology.mapping.TechnologyMapping;
import de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint;
import de.fhdo.lemma.technology.mapping.TechnologySpecificFieldMapping;
import de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect;
import de.fhdo.lemma.technology.mapping.TechnologySpecificProtocol;
import de.fhdo.lemma.technology.mapping.TechnologySpecificProtocolSpecification;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class MappingPackageImpl extends EPackageImpl implements MappingPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technologyMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass complexTypeMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass importedComplexTypeToMapEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass microserviceMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass importedMicroserviceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass interfaceMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass operationMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass referredOperationMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass parameterMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass primitiveParameterMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass complexParameterMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technologySpecificFieldMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataOperationMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataOperationReturnTypeMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataOperationParameterMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technologySpecificProtocolSpecificationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technologySpecificProtocolEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technologySpecificEndpointEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technologySpecificImportedServiceAspectEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType dataFieldListEDataType = null;

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
     * @see de.fhdo.lemma.technology.mapping.MappingPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private MappingPackageImpl() {
        super(eNS_URI, MappingFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link MappingPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static MappingPackage init() {
        if (isInited) return (MappingPackage)EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI);

        // Obtain or create and register package
        Object registeredMappingPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        MappingPackageImpl theMappingPackage = registeredMappingPackage instanceof MappingPackageImpl ? (MappingPackageImpl)registeredMappingPackage : new MappingPackageImpl();

        isInited = true;

        // Initialize simple dependencies
        ServicePackage.eINSTANCE.eClass();
        TechnologyPackage.eINSTANCE.eClass();
        EcorePackage.eINSTANCE.eClass();
        DataPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theMappingPackage.createPackageContents();

        // Initialize created meta-data
        theMappingPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theMappingPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(MappingPackage.eNS_URI, theMappingPackage);
        return theMappingPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnologyMapping() {
        return technologyMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologyMapping_Imports() {
        return (EReference)technologyMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologyMapping_TypeMappings() {
        return (EReference)technologyMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologyMapping_ServiceMappings() {
        return (EReference)technologyMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getTechnologyMapping__GetMappedInterfaces() {
        return technologyMappingEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getTechnologyMapping__GetMappedOperations() {
        return technologyMappingEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getTechnologyMapping__GetComplexParameterMappings() {
        return technologyMappingEClass.getEOperations().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getTechnologyMapping__GetMappedReferredOperations() {
        return technologyMappingEClass.getEOperations().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getComplexTypeMapping() {
        return complexTypeMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getComplexTypeMapping_T_sourceModelUri() {
        return (EAttribute)complexTypeMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComplexTypeMapping_TechnologyReferences() {
        return (EReference)complexTypeMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComplexTypeMapping_Type() {
        return (EReference)complexTypeMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComplexTypeMapping_FieldMappings() {
        return (EReference)complexTypeMappingEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComplexTypeMapping_OperationMappings() {
        return (EReference)complexTypeMappingEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComplexTypeMapping_Aspects() {
        return (EReference)complexTypeMappingEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComplexTypeMapping_MappingModel() {
        return (EReference)complexTypeMappingEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getComplexTypeMapping__GetAllTypeDefinitionTechnologyReferences() {
        return complexTypeMappingEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getComplexTypeMapping__GetTypeDefinitionTechnologyImport() {
        return complexTypeMappingEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getComplexTypeMapping__GetTypeDefinitionTechnology() {
        return complexTypeMappingEClass.getEOperations().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getImportedComplexTypeToMap() {
        return importedComplexTypeToMapEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getImportedComplexTypeToMap_ServiceModelImport() {
        return (EReference)importedComplexTypeToMapEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getImportedComplexTypeToMap_DataModelImport() {
        return (EReference)importedComplexTypeToMapEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getImportedComplexTypeToMap_Type() {
        return (EReference)importedComplexTypeToMapEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getImportedComplexTypeToMap_TypeMapping() {
        return (EReference)importedComplexTypeToMapEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMicroserviceMapping() {
        return microserviceMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceMapping_TechnologyReferences() {
        return (EReference)microserviceMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceMapping_Microservice() {
        return (EReference)microserviceMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceMapping_Endpoints() {
        return (EReference)microserviceMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceMapping_Protocols() {
        return (EReference)microserviceMappingEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceMapping_InterfaceMappings() {
        return (EReference)microserviceMappingEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceMapping_OperationMappings() {
        return (EReference)microserviceMappingEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceMapping_ReferredOperationMappings() {
        return (EReference)microserviceMappingEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceMapping_Aspects() {
        return (EReference)microserviceMappingEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMicroserviceMapping_MappingModel() {
        return (EReference)microserviceMappingEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getMicroserviceMapping__GetAllTypeDefinitionTechnologyReferences() {
        return microserviceMappingEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getMicroserviceMapping__GetTypeDefinitionTechnologyImport() {
        return microserviceMappingEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getMicroserviceMapping__GetTypeDefinitionTechnology() {
        return microserviceMappingEClass.getEOperations().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getImportedMicroservice() {
        return importedMicroserviceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getImportedMicroservice_Import() {
        return (EReference)importedMicroserviceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getImportedMicroservice_Microservice() {
        return (EReference)importedMicroserviceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getImportedMicroservice_MicroserviceMapping() {
        return (EReference)importedMicroserviceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInterfaceMapping() {
        return interfaceMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInterfaceMapping_Interface() {
        return (EReference)interfaceMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInterfaceMapping_Endpoints() {
        return (EReference)interfaceMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInterfaceMapping_Protocols() {
        return (EReference)interfaceMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInterfaceMapping_Aspects() {
        return (EReference)interfaceMappingEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInterfaceMapping_MicroserviceMapping() {
        return (EReference)interfaceMappingEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOperationMapping() {
        return operationMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationMapping_Operation() {
        return (EReference)operationMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationMapping_Endpoints() {
        return (EReference)operationMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationMapping_Protocols() {
        return (EReference)operationMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationMapping_ParameterMappings() {
        return (EReference)operationMappingEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationMapping_Aspects() {
        return (EReference)operationMappingEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationMapping_MicroserviceMapping() {
        return (EReference)operationMappingEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getReferredOperationMapping() {
        return referredOperationMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getReferredOperationMapping_Operation() {
        return (EReference)referredOperationMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getReferredOperationMapping_Endpoints() {
        return (EReference)referredOperationMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getReferredOperationMapping_Protocols() {
        return (EReference)referredOperationMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getReferredOperationMapping_Aspects() {
        return (EReference)referredOperationMappingEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getReferredOperationMapping_MicroserviceMapping() {
        return (EReference)referredOperationMappingEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getParameterMapping() {
        return parameterMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getParameterMapping_Parameter() {
        return (EReference)parameterMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getParameterMapping_Aspects() {
        return (EReference)parameterMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getParameterMapping_OperationMapping() {
        return (EReference)parameterMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPrimitiveParameterMapping() {
        return primitiveParameterMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPrimitiveParameterMapping_Technology() {
        return (EReference)primitiveParameterMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPrimitiveParameterMapping_PrimitiveType() {
        return (EReference)primitiveParameterMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getComplexParameterMapping() {
        return complexParameterMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComplexParameterMapping_Technology() {
        return (EReference)complexParameterMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComplexParameterMapping_TechnologySpecificComplexType() {
        return (EReference)complexParameterMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComplexParameterMapping_FieldMappings() {
        return (EReference)complexParameterMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnologySpecificFieldMapping() {
        return technologySpecificFieldMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificFieldMapping_Technology() {
        return (EReference)technologySpecificFieldMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificFieldMapping_Type() {
        return (EReference)technologySpecificFieldMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificFieldMapping_EnumerationField() {
        return (EReference)technologySpecificFieldMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificFieldMapping_DataField() {
        return (EReference)technologySpecificFieldMappingEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificFieldMapping_Aspects() {
        return (EReference)technologySpecificFieldMappingEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificFieldMapping_TypeMapping() {
        return (EReference)technologySpecificFieldMappingEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificFieldMapping_ParameterMapping() {
        return (EReference)technologySpecificFieldMappingEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getTechnologySpecificFieldMapping__GetOriginalTypeOfMappedElement() {
        return technologySpecificFieldMappingEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDataOperationMapping() {
        return dataOperationMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataOperationMapping_DataOperation() {
        return (EReference)dataOperationMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataOperationMapping_Aspects() {
        return (EReference)dataOperationMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataOperationMapping_ReturnTypeMapping() {
        return (EReference)dataOperationMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataOperationMapping_ParameterMappings() {
        return (EReference)dataOperationMappingEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataOperationMapping_TypeMapping() {
        return (EReference)dataOperationMappingEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDataOperationReturnTypeMapping() {
        return dataOperationReturnTypeMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataOperationReturnTypeMapping_Technology() {
        return (EReference)dataOperationReturnTypeMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataOperationReturnTypeMapping_Type() {
        return (EReference)dataOperationReturnTypeMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataOperationReturnTypeMapping_Aspects() {
        return (EReference)dataOperationReturnTypeMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataOperationReturnTypeMapping_OperationMapping() {
        return (EReference)dataOperationReturnTypeMappingEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDataOperationParameterMapping() {
        return dataOperationParameterMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataOperationParameterMapping_Parameter() {
        return (EReference)dataOperationParameterMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataOperationParameterMapping_Technology() {
        return (EReference)dataOperationParameterMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataOperationParameterMapping_Type() {
        return (EReference)dataOperationParameterMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataOperationParameterMapping_Aspects() {
        return (EReference)dataOperationParameterMappingEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataOperationParameterMapping_OperationMapping() {
        return (EReference)dataOperationParameterMappingEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnologySpecificProtocolSpecification() {
        return technologySpecificProtocolSpecificationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTechnologySpecificProtocolSpecification_CommunicationType() {
        return (EAttribute)technologySpecificProtocolSpecificationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificProtocolSpecification_TechnologySpecificProtocol() {
        return (EReference)technologySpecificProtocolSpecificationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnologySpecificProtocol() {
        return technologySpecificProtocolEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificProtocol_Technology() {
        return (EReference)technologySpecificProtocolEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificProtocol_Protocol() {
        return (EReference)technologySpecificProtocolEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificProtocol_DataFormat() {
        return (EReference)technologySpecificProtocolEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificProtocol_ProtocolSpecification() {
        return (EReference)technologySpecificProtocolEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificProtocol_Endpoint() {
        return (EReference)technologySpecificProtocolEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnologySpecificEndpoint() {
        return technologySpecificEndpointEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTechnologySpecificEndpoint_Addresses() {
        return (EAttribute)technologySpecificEndpointEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificEndpoint_TechnologySpecificProtocols() {
        return (EReference)technologySpecificEndpointEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificEndpoint_MicroserviceMapping() {
        return (EReference)technologySpecificEndpointEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificEndpoint_InterfaceMapping() {
        return (EReference)technologySpecificEndpointEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificEndpoint_OperationMapping() {
        return (EReference)technologySpecificEndpointEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificEndpoint_ReferredOperationMapping() {
        return (EReference)technologySpecificEndpointEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnologySpecificImportedServiceAspect() {
        return technologySpecificImportedServiceAspectEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_Technology() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_Aspect() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_SinglePropertyValue() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_Values() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_TypeMapping() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_MicroserviceMapping() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_InterfaceMapping() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_OperationMapping() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_ReferredOperationMapping() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_ParameterMapping() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_FieldMapping() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_DataOperationMapping() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_DataOperationReturnTypeMapping() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTechnologySpecificImportedServiceAspect_DataOperationParameterMapping() {
        return (EReference)technologySpecificImportedServiceAspectEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getDataFieldList() {
        return dataFieldListEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MappingFactory getMappingFactory() {
        return (MappingFactory)getEFactoryInstance();
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
        technologyMappingEClass = createEClass(TECHNOLOGY_MAPPING);
        createEReference(technologyMappingEClass, TECHNOLOGY_MAPPING__IMPORTS);
        createEReference(technologyMappingEClass, TECHNOLOGY_MAPPING__TYPE_MAPPINGS);
        createEReference(technologyMappingEClass, TECHNOLOGY_MAPPING__SERVICE_MAPPINGS);
        createEOperation(technologyMappingEClass, TECHNOLOGY_MAPPING___GET_MAPPED_INTERFACES);
        createEOperation(technologyMappingEClass, TECHNOLOGY_MAPPING___GET_MAPPED_OPERATIONS);
        createEOperation(technologyMappingEClass, TECHNOLOGY_MAPPING___GET_COMPLEX_PARAMETER_MAPPINGS);
        createEOperation(technologyMappingEClass, TECHNOLOGY_MAPPING___GET_MAPPED_REFERRED_OPERATIONS);

        complexTypeMappingEClass = createEClass(COMPLEX_TYPE_MAPPING);
        createEAttribute(complexTypeMappingEClass, COMPLEX_TYPE_MAPPING__TSOURCE_MODEL_URI);
        createEReference(complexTypeMappingEClass, COMPLEX_TYPE_MAPPING__TECHNOLOGY_REFERENCES);
        createEReference(complexTypeMappingEClass, COMPLEX_TYPE_MAPPING__TYPE);
        createEReference(complexTypeMappingEClass, COMPLEX_TYPE_MAPPING__FIELD_MAPPINGS);
        createEReference(complexTypeMappingEClass, COMPLEX_TYPE_MAPPING__OPERATION_MAPPINGS);
        createEReference(complexTypeMappingEClass, COMPLEX_TYPE_MAPPING__ASPECTS);
        createEReference(complexTypeMappingEClass, COMPLEX_TYPE_MAPPING__MAPPING_MODEL);
        createEOperation(complexTypeMappingEClass, COMPLEX_TYPE_MAPPING___GET_ALL_TYPE_DEFINITION_TECHNOLOGY_REFERENCES);
        createEOperation(complexTypeMappingEClass, COMPLEX_TYPE_MAPPING___GET_TYPE_DEFINITION_TECHNOLOGY_IMPORT);
        createEOperation(complexTypeMappingEClass, COMPLEX_TYPE_MAPPING___GET_TYPE_DEFINITION_TECHNOLOGY);

        importedComplexTypeToMapEClass = createEClass(IMPORTED_COMPLEX_TYPE_TO_MAP);
        createEReference(importedComplexTypeToMapEClass, IMPORTED_COMPLEX_TYPE_TO_MAP__SERVICE_MODEL_IMPORT);
        createEReference(importedComplexTypeToMapEClass, IMPORTED_COMPLEX_TYPE_TO_MAP__DATA_MODEL_IMPORT);
        createEReference(importedComplexTypeToMapEClass, IMPORTED_COMPLEX_TYPE_TO_MAP__TYPE);
        createEReference(importedComplexTypeToMapEClass, IMPORTED_COMPLEX_TYPE_TO_MAP__TYPE_MAPPING);

        microserviceMappingEClass = createEClass(MICROSERVICE_MAPPING);
        createEReference(microserviceMappingEClass, MICROSERVICE_MAPPING__TECHNOLOGY_REFERENCES);
        createEReference(microserviceMappingEClass, MICROSERVICE_MAPPING__MICROSERVICE);
        createEReference(microserviceMappingEClass, MICROSERVICE_MAPPING__ENDPOINTS);
        createEReference(microserviceMappingEClass, MICROSERVICE_MAPPING__PROTOCOLS);
        createEReference(microserviceMappingEClass, MICROSERVICE_MAPPING__INTERFACE_MAPPINGS);
        createEReference(microserviceMappingEClass, MICROSERVICE_MAPPING__OPERATION_MAPPINGS);
        createEReference(microserviceMappingEClass, MICROSERVICE_MAPPING__REFERRED_OPERATION_MAPPINGS);
        createEReference(microserviceMappingEClass, MICROSERVICE_MAPPING__ASPECTS);
        createEReference(microserviceMappingEClass, MICROSERVICE_MAPPING__MAPPING_MODEL);
        createEOperation(microserviceMappingEClass, MICROSERVICE_MAPPING___GET_ALL_TYPE_DEFINITION_TECHNOLOGY_REFERENCES);
        createEOperation(microserviceMappingEClass, MICROSERVICE_MAPPING___GET_TYPE_DEFINITION_TECHNOLOGY_IMPORT);
        createEOperation(microserviceMappingEClass, MICROSERVICE_MAPPING___GET_TYPE_DEFINITION_TECHNOLOGY);

        importedMicroserviceEClass = createEClass(IMPORTED_MICROSERVICE);
        createEReference(importedMicroserviceEClass, IMPORTED_MICROSERVICE__IMPORT);
        createEReference(importedMicroserviceEClass, IMPORTED_MICROSERVICE__MICROSERVICE);
        createEReference(importedMicroserviceEClass, IMPORTED_MICROSERVICE__MICROSERVICE_MAPPING);

        interfaceMappingEClass = createEClass(INTERFACE_MAPPING);
        createEReference(interfaceMappingEClass, INTERFACE_MAPPING__INTERFACE);
        createEReference(interfaceMappingEClass, INTERFACE_MAPPING__ENDPOINTS);
        createEReference(interfaceMappingEClass, INTERFACE_MAPPING__PROTOCOLS);
        createEReference(interfaceMappingEClass, INTERFACE_MAPPING__ASPECTS);
        createEReference(interfaceMappingEClass, INTERFACE_MAPPING__MICROSERVICE_MAPPING);

        operationMappingEClass = createEClass(OPERATION_MAPPING);
        createEReference(operationMappingEClass, OPERATION_MAPPING__OPERATION);
        createEReference(operationMappingEClass, OPERATION_MAPPING__ENDPOINTS);
        createEReference(operationMappingEClass, OPERATION_MAPPING__PROTOCOLS);
        createEReference(operationMappingEClass, OPERATION_MAPPING__PARAMETER_MAPPINGS);
        createEReference(operationMappingEClass, OPERATION_MAPPING__ASPECTS);
        createEReference(operationMappingEClass, OPERATION_MAPPING__MICROSERVICE_MAPPING);

        referredOperationMappingEClass = createEClass(REFERRED_OPERATION_MAPPING);
        createEReference(referredOperationMappingEClass, REFERRED_OPERATION_MAPPING__OPERATION);
        createEReference(referredOperationMappingEClass, REFERRED_OPERATION_MAPPING__ENDPOINTS);
        createEReference(referredOperationMappingEClass, REFERRED_OPERATION_MAPPING__PROTOCOLS);
        createEReference(referredOperationMappingEClass, REFERRED_OPERATION_MAPPING__ASPECTS);
        createEReference(referredOperationMappingEClass, REFERRED_OPERATION_MAPPING__MICROSERVICE_MAPPING);

        parameterMappingEClass = createEClass(PARAMETER_MAPPING);
        createEReference(parameterMappingEClass, PARAMETER_MAPPING__PARAMETER);
        createEReference(parameterMappingEClass, PARAMETER_MAPPING__ASPECTS);
        createEReference(parameterMappingEClass, PARAMETER_MAPPING__OPERATION_MAPPING);

        primitiveParameterMappingEClass = createEClass(PRIMITIVE_PARAMETER_MAPPING);
        createEReference(primitiveParameterMappingEClass, PRIMITIVE_PARAMETER_MAPPING__TECHNOLOGY);
        createEReference(primitiveParameterMappingEClass, PRIMITIVE_PARAMETER_MAPPING__PRIMITIVE_TYPE);

        complexParameterMappingEClass = createEClass(COMPLEX_PARAMETER_MAPPING);
        createEReference(complexParameterMappingEClass, COMPLEX_PARAMETER_MAPPING__TECHNOLOGY);
        createEReference(complexParameterMappingEClass, COMPLEX_PARAMETER_MAPPING__TECHNOLOGY_SPECIFIC_COMPLEX_TYPE);
        createEReference(complexParameterMappingEClass, COMPLEX_PARAMETER_MAPPING__FIELD_MAPPINGS);

        technologySpecificFieldMappingEClass = createEClass(TECHNOLOGY_SPECIFIC_FIELD_MAPPING);
        createEReference(technologySpecificFieldMappingEClass, TECHNOLOGY_SPECIFIC_FIELD_MAPPING__TECHNOLOGY);
        createEReference(technologySpecificFieldMappingEClass, TECHNOLOGY_SPECIFIC_FIELD_MAPPING__TYPE);
        createEReference(technologySpecificFieldMappingEClass, TECHNOLOGY_SPECIFIC_FIELD_MAPPING__ENUMERATION_FIELD);
        createEReference(technologySpecificFieldMappingEClass, TECHNOLOGY_SPECIFIC_FIELD_MAPPING__DATA_FIELD);
        createEReference(technologySpecificFieldMappingEClass, TECHNOLOGY_SPECIFIC_FIELD_MAPPING__ASPECTS);
        createEReference(technologySpecificFieldMappingEClass, TECHNOLOGY_SPECIFIC_FIELD_MAPPING__TYPE_MAPPING);
        createEReference(technologySpecificFieldMappingEClass, TECHNOLOGY_SPECIFIC_FIELD_MAPPING__PARAMETER_MAPPING);
        createEOperation(technologySpecificFieldMappingEClass, TECHNOLOGY_SPECIFIC_FIELD_MAPPING___GET_ORIGINAL_TYPE_OF_MAPPED_ELEMENT);

        dataOperationMappingEClass = createEClass(DATA_OPERATION_MAPPING);
        createEReference(dataOperationMappingEClass, DATA_OPERATION_MAPPING__DATA_OPERATION);
        createEReference(dataOperationMappingEClass, DATA_OPERATION_MAPPING__ASPECTS);
        createEReference(dataOperationMappingEClass, DATA_OPERATION_MAPPING__RETURN_TYPE_MAPPING);
        createEReference(dataOperationMappingEClass, DATA_OPERATION_MAPPING__PARAMETER_MAPPINGS);
        createEReference(dataOperationMappingEClass, DATA_OPERATION_MAPPING__TYPE_MAPPING);

        dataOperationReturnTypeMappingEClass = createEClass(DATA_OPERATION_RETURN_TYPE_MAPPING);
        createEReference(dataOperationReturnTypeMappingEClass, DATA_OPERATION_RETURN_TYPE_MAPPING__TECHNOLOGY);
        createEReference(dataOperationReturnTypeMappingEClass, DATA_OPERATION_RETURN_TYPE_MAPPING__TYPE);
        createEReference(dataOperationReturnTypeMappingEClass, DATA_OPERATION_RETURN_TYPE_MAPPING__ASPECTS);
        createEReference(dataOperationReturnTypeMappingEClass, DATA_OPERATION_RETURN_TYPE_MAPPING__OPERATION_MAPPING);

        dataOperationParameterMappingEClass = createEClass(DATA_OPERATION_PARAMETER_MAPPING);
        createEReference(dataOperationParameterMappingEClass, DATA_OPERATION_PARAMETER_MAPPING__PARAMETER);
        createEReference(dataOperationParameterMappingEClass, DATA_OPERATION_PARAMETER_MAPPING__TECHNOLOGY);
        createEReference(dataOperationParameterMappingEClass, DATA_OPERATION_PARAMETER_MAPPING__TYPE);
        createEReference(dataOperationParameterMappingEClass, DATA_OPERATION_PARAMETER_MAPPING__ASPECTS);
        createEReference(dataOperationParameterMappingEClass, DATA_OPERATION_PARAMETER_MAPPING__OPERATION_MAPPING);

        technologySpecificProtocolSpecificationEClass = createEClass(TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION);
        createEAttribute(technologySpecificProtocolSpecificationEClass, TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE);
        createEReference(technologySpecificProtocolSpecificationEClass, TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__TECHNOLOGY_SPECIFIC_PROTOCOL);

        technologySpecificProtocolEClass = createEClass(TECHNOLOGY_SPECIFIC_PROTOCOL);
        createEReference(technologySpecificProtocolEClass, TECHNOLOGY_SPECIFIC_PROTOCOL__TECHNOLOGY);
        createEReference(technologySpecificProtocolEClass, TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL);
        createEReference(technologySpecificProtocolEClass, TECHNOLOGY_SPECIFIC_PROTOCOL__DATA_FORMAT);
        createEReference(technologySpecificProtocolEClass, TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL_SPECIFICATION);
        createEReference(technologySpecificProtocolEClass, TECHNOLOGY_SPECIFIC_PROTOCOL__ENDPOINT);

        technologySpecificEndpointEClass = createEClass(TECHNOLOGY_SPECIFIC_ENDPOINT);
        createEAttribute(technologySpecificEndpointEClass, TECHNOLOGY_SPECIFIC_ENDPOINT__ADDRESSES);
        createEReference(technologySpecificEndpointEClass, TECHNOLOGY_SPECIFIC_ENDPOINT__TECHNOLOGY_SPECIFIC_PROTOCOLS);
        createEReference(technologySpecificEndpointEClass, TECHNOLOGY_SPECIFIC_ENDPOINT__MICROSERVICE_MAPPING);
        createEReference(technologySpecificEndpointEClass, TECHNOLOGY_SPECIFIC_ENDPOINT__INTERFACE_MAPPING);
        createEReference(technologySpecificEndpointEClass, TECHNOLOGY_SPECIFIC_ENDPOINT__OPERATION_MAPPING);
        createEReference(technologySpecificEndpointEClass, TECHNOLOGY_SPECIFIC_ENDPOINT__REFERRED_OPERATION_MAPPING);

        technologySpecificImportedServiceAspectEClass = createEClass(TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TECHNOLOGY);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__ASPECT);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__VALUES);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TYPE_MAPPING);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__MICROSERVICE_MAPPING);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__INTERFACE_MAPPING);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__OPERATION_MAPPING);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION_MAPPING);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__PARAMETER_MAPPING);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__FIELD_MAPPING);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_MAPPING);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_RETURN_TYPE_MAPPING);
        createEReference(technologySpecificImportedServiceAspectEClass, TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_PARAMETER_MAPPING);

        // Create data types
        dataFieldListEDataType = createEDataType(DATA_FIELD_LIST);
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
        ServicePackage theServicePackage = (ServicePackage)EPackage.Registry.INSTANCE.getEPackage(ServicePackage.eNS_URI);
        EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
        TechnologyPackage theTechnologyPackage = (TechnologyPackage)EPackage.Registry.INSTANCE.getEPackage(TechnologyPackage.eNS_URI);
        DataPackage theDataPackage = (DataPackage)EPackage.Registry.INSTANCE.getEPackage(DataPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        primitiveParameterMappingEClass.getESuperTypes().add(this.getParameterMapping());
        complexParameterMappingEClass.getESuperTypes().add(this.getParameterMapping());

        // Initialize classes, features, and operations; add parameters
        initEClass(technologyMappingEClass, TechnologyMapping.class, "TechnologyMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTechnologyMapping_Imports(), theServicePackage.getImport(), null, "imports", null, 1, -1, TechnologyMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologyMapping_TypeMappings(), this.getComplexTypeMapping(), this.getComplexTypeMapping_MappingModel(), "typeMappings", null, 0, -1, TechnologyMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologyMapping_ServiceMappings(), this.getMicroserviceMapping(), this.getMicroserviceMapping_MappingModel(), "serviceMappings", null, 0, -1, TechnologyMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getTechnologyMapping__GetMappedInterfaces(), this.getInterfaceMapping(), "getMappedInterfaces", 0, -1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getTechnologyMapping__GetMappedOperations(), this.getOperationMapping(), "getMappedOperations", 0, -1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getTechnologyMapping__GetComplexParameterMappings(), this.getComplexParameterMapping(), "getComplexParameterMappings", 0, -1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getTechnologyMapping__GetMappedReferredOperations(), this.getReferredOperationMapping(), "getMappedReferredOperations", 0, -1, !IS_UNIQUE, IS_ORDERED);

        initEClass(complexTypeMappingEClass, ComplexTypeMapping.class, "ComplexTypeMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getComplexTypeMapping_T_sourceModelUri(), theEcorePackage.getEString(), "t_sourceModelUri", null, 0, 1, ComplexTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComplexTypeMapping_TechnologyReferences(), theServicePackage.getTechnologyReference(), null, "technologyReferences", null, 0, -1, ComplexTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComplexTypeMapping_Type(), this.getImportedComplexTypeToMap(), this.getImportedComplexTypeToMap_TypeMapping(), "type", null, 0, 1, ComplexTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComplexTypeMapping_FieldMappings(), this.getTechnologySpecificFieldMapping(), this.getTechnologySpecificFieldMapping_TypeMapping(), "fieldMappings", null, 0, -1, ComplexTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComplexTypeMapping_OperationMappings(), this.getDataOperationMapping(), this.getDataOperationMapping_TypeMapping(), "operationMappings", null, 0, -1, ComplexTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComplexTypeMapping_Aspects(), this.getTechnologySpecificImportedServiceAspect(), this.getTechnologySpecificImportedServiceAspect_TypeMapping(), "aspects", null, 0, -1, ComplexTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComplexTypeMapping_MappingModel(), this.getTechnologyMapping(), this.getTechnologyMapping_TypeMappings(), "mappingModel", null, 0, 1, ComplexTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getComplexTypeMapping__GetAllTypeDefinitionTechnologyReferences(), theServicePackage.getTechnologyReference(), "getAllTypeDefinitionTechnologyReferences", 0, -1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getComplexTypeMapping__GetTypeDefinitionTechnologyImport(), theServicePackage.getImport(), "getTypeDefinitionTechnologyImport", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getComplexTypeMapping__GetTypeDefinitionTechnology(), theTechnologyPackage.getTechnology(), "getTypeDefinitionTechnology", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEClass(importedComplexTypeToMapEClass, ImportedComplexTypeToMap.class, "ImportedComplexTypeToMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getImportedComplexTypeToMap_ServiceModelImport(), theServicePackage.getImport(), null, "serviceModelImport", null, 0, 1, ImportedComplexTypeToMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getImportedComplexTypeToMap_DataModelImport(), theServicePackage.getImport(), null, "dataModelImport", null, 0, 1, ImportedComplexTypeToMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getImportedComplexTypeToMap_Type(), theDataPackage.getComplexType(), null, "type", null, 0, 1, ImportedComplexTypeToMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getImportedComplexTypeToMap_TypeMapping(), this.getComplexTypeMapping(), this.getComplexTypeMapping_Type(), "typeMapping", null, 0, 1, ImportedComplexTypeToMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(microserviceMappingEClass, MicroserviceMapping.class, "MicroserviceMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getMicroserviceMapping_TechnologyReferences(), theServicePackage.getTechnologyReference(), null, "technologyReferences", null, 0, -1, MicroserviceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicroserviceMapping_Microservice(), this.getImportedMicroservice(), this.getImportedMicroservice_MicroserviceMapping(), "microservice", null, 0, 1, MicroserviceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicroserviceMapping_Endpoints(), this.getTechnologySpecificEndpoint(), this.getTechnologySpecificEndpoint_MicroserviceMapping(), "endpoints", null, 0, -1, MicroserviceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicroserviceMapping_Protocols(), this.getTechnologySpecificProtocolSpecification(), null, "protocols", null, 0, -1, MicroserviceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicroserviceMapping_InterfaceMappings(), this.getInterfaceMapping(), this.getInterfaceMapping_MicroserviceMapping(), "interfaceMappings", null, 0, -1, MicroserviceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicroserviceMapping_OperationMappings(), this.getOperationMapping(), this.getOperationMapping_MicroserviceMapping(), "operationMappings", null, 0, -1, MicroserviceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicroserviceMapping_ReferredOperationMappings(), this.getReferredOperationMapping(), this.getReferredOperationMapping_MicroserviceMapping(), "referredOperationMappings", null, 0, -1, MicroserviceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicroserviceMapping_Aspects(), this.getTechnologySpecificImportedServiceAspect(), this.getTechnologySpecificImportedServiceAspect_MicroserviceMapping(), "aspects", null, 0, -1, MicroserviceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicroserviceMapping_MappingModel(), this.getTechnologyMapping(), this.getTechnologyMapping_ServiceMappings(), "mappingModel", null, 0, 1, MicroserviceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getMicroserviceMapping__GetAllTypeDefinitionTechnologyReferences(), theServicePackage.getTechnologyReference(), "getAllTypeDefinitionTechnologyReferences", 0, -1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getMicroserviceMapping__GetTypeDefinitionTechnologyImport(), theServicePackage.getImport(), "getTypeDefinitionTechnologyImport", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEOperation(getMicroserviceMapping__GetTypeDefinitionTechnology(), theTechnologyPackage.getTechnology(), "getTypeDefinitionTechnology", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEClass(importedMicroserviceEClass, ImportedMicroservice.class, "ImportedMicroservice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getImportedMicroservice_Import(), theServicePackage.getImport(), null, "import", null, 0, 1, ImportedMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getImportedMicroservice_Microservice(), theServicePackage.getMicroservice(), null, "microservice", null, 0, 1, ImportedMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getImportedMicroservice_MicroserviceMapping(), this.getMicroserviceMapping(), this.getMicroserviceMapping_Microservice(), "microserviceMapping", null, 0, 1, ImportedMicroservice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(interfaceMappingEClass, InterfaceMapping.class, "InterfaceMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getInterfaceMapping_Interface(), theServicePackage.getInterface(), null, "interface", null, 0, 1, InterfaceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInterfaceMapping_Endpoints(), this.getTechnologySpecificEndpoint(), this.getTechnologySpecificEndpoint_InterfaceMapping(), "endpoints", null, 0, -1, InterfaceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInterfaceMapping_Protocols(), this.getTechnologySpecificProtocolSpecification(), null, "protocols", null, 0, -1, InterfaceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInterfaceMapping_Aspects(), this.getTechnologySpecificImportedServiceAspect(), this.getTechnologySpecificImportedServiceAspect_InterfaceMapping(), "aspects", null, 0, -1, InterfaceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInterfaceMapping_MicroserviceMapping(), this.getMicroserviceMapping(), this.getMicroserviceMapping_InterfaceMappings(), "microserviceMapping", null, 0, 1, InterfaceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(operationMappingEClass, OperationMapping.class, "OperationMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getOperationMapping_Operation(), theServicePackage.getOperation(), null, "operation", null, 0, 1, OperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationMapping_Endpoints(), this.getTechnologySpecificEndpoint(), this.getTechnologySpecificEndpoint_OperationMapping(), "endpoints", null, 0, -1, OperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationMapping_Protocols(), this.getTechnologySpecificProtocolSpecification(), null, "protocols", null, 0, -1, OperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationMapping_ParameterMappings(), this.getParameterMapping(), this.getParameterMapping_OperationMapping(), "parameterMappings", null, 0, -1, OperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationMapping_Aspects(), this.getTechnologySpecificImportedServiceAspect(), this.getTechnologySpecificImportedServiceAspect_OperationMapping(), "aspects", null, 0, -1, OperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationMapping_MicroserviceMapping(), this.getMicroserviceMapping(), this.getMicroserviceMapping_OperationMappings(), "microserviceMapping", null, 0, 1, OperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(referredOperationMappingEClass, ReferredOperationMapping.class, "ReferredOperationMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getReferredOperationMapping_Operation(), theServicePackage.getReferredOperation(), null, "operation", null, 0, 1, ReferredOperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReferredOperationMapping_Endpoints(), this.getTechnologySpecificEndpoint(), this.getTechnologySpecificEndpoint_ReferredOperationMapping(), "endpoints", null, 0, -1, ReferredOperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReferredOperationMapping_Protocols(), this.getTechnologySpecificProtocolSpecification(), null, "protocols", null, 0, -1, ReferredOperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReferredOperationMapping_Aspects(), this.getTechnologySpecificImportedServiceAspect(), this.getTechnologySpecificImportedServiceAspect_ReferredOperationMapping(), "aspects", null, 0, -1, ReferredOperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReferredOperationMapping_MicroserviceMapping(), this.getMicroserviceMapping(), this.getMicroserviceMapping_ReferredOperationMappings(), "microserviceMapping", null, 0, 1, ReferredOperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(parameterMappingEClass, ParameterMapping.class, "ParameterMapping", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getParameterMapping_Parameter(), theServicePackage.getParameter(), null, "parameter", null, 0, 1, ParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getParameterMapping_Aspects(), this.getTechnologySpecificImportedServiceAspect(), this.getTechnologySpecificImportedServiceAspect_ParameterMapping(), "aspects", null, 0, -1, ParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getParameterMapping_OperationMapping(), this.getOperationMapping(), this.getOperationMapping_ParameterMappings(), "operationMapping", null, 0, 1, ParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(primitiveParameterMappingEClass, PrimitiveParameterMapping.class, "PrimitiveParameterMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPrimitiveParameterMapping_Technology(), theServicePackage.getImport(), null, "technology", null, 0, 1, PrimitiveParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPrimitiveParameterMapping_PrimitiveType(), theTechnologyPackage.getTechnologySpecificPrimitiveType(), null, "primitiveType", null, 0, 1, PrimitiveParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(complexParameterMappingEClass, ComplexParameterMapping.class, "ComplexParameterMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getComplexParameterMapping_Technology(), theServicePackage.getImport(), null, "technology", null, 0, 1, ComplexParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComplexParameterMapping_TechnologySpecificComplexType(), theDataPackage.getComplexType(), null, "technologySpecificComplexType", null, 0, 1, ComplexParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getComplexParameterMapping_FieldMappings(), this.getTechnologySpecificFieldMapping(), this.getTechnologySpecificFieldMapping_ParameterMapping(), "fieldMappings", null, 0, -1, ComplexParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(technologySpecificFieldMappingEClass, TechnologySpecificFieldMapping.class, "TechnologySpecificFieldMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTechnologySpecificFieldMapping_Technology(), theServicePackage.getImport(), null, "technology", null, 0, 1, TechnologySpecificFieldMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificFieldMapping_Type(), theDataPackage.getType(), null, "type", null, 0, 1, TechnologySpecificFieldMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificFieldMapping_EnumerationField(), theDataPackage.getEnumerationField(), null, "enumerationField", null, 0, 1, TechnologySpecificFieldMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificFieldMapping_DataField(), theDataPackage.getDataField(), null, "dataField", null, 0, 1, TechnologySpecificFieldMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificFieldMapping_Aspects(), this.getTechnologySpecificImportedServiceAspect(), this.getTechnologySpecificImportedServiceAspect_FieldMapping(), "aspects", null, 0, -1, TechnologySpecificFieldMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificFieldMapping_TypeMapping(), this.getComplexTypeMapping(), this.getComplexTypeMapping_FieldMappings(), "typeMapping", null, 0, 1, TechnologySpecificFieldMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificFieldMapping_ParameterMapping(), this.getComplexParameterMapping(), this.getComplexParameterMapping_FieldMappings(), "parameterMapping", null, 0, 1, TechnologySpecificFieldMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getTechnologySpecificFieldMapping__GetOriginalTypeOfMappedElement(), theDataPackage.getType(), "getOriginalTypeOfMappedElement", 0, 1, !IS_UNIQUE, IS_ORDERED);

        initEClass(dataOperationMappingEClass, DataOperationMapping.class, "DataOperationMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDataOperationMapping_DataOperation(), theDataPackage.getDataOperation(), null, "dataOperation", null, 0, 1, DataOperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataOperationMapping_Aspects(), this.getTechnologySpecificImportedServiceAspect(), this.getTechnologySpecificImportedServiceAspect_DataOperationMapping(), "aspects", null, 0, -1, DataOperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataOperationMapping_ReturnTypeMapping(), this.getDataOperationReturnTypeMapping(), this.getDataOperationReturnTypeMapping_OperationMapping(), "returnTypeMapping", null, 0, 1, DataOperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataOperationMapping_ParameterMappings(), this.getDataOperationParameterMapping(), this.getDataOperationParameterMapping_OperationMapping(), "parameterMappings", null, 0, -1, DataOperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataOperationMapping_TypeMapping(), this.getComplexTypeMapping(), this.getComplexTypeMapping_OperationMappings(), "typeMapping", null, 0, 1, DataOperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dataOperationReturnTypeMappingEClass, DataOperationReturnTypeMapping.class, "DataOperationReturnTypeMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDataOperationReturnTypeMapping_Technology(), theServicePackage.getImport(), null, "technology", null, 0, 1, DataOperationReturnTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataOperationReturnTypeMapping_Type(), theDataPackage.getType(), null, "type", null, 0, 1, DataOperationReturnTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataOperationReturnTypeMapping_Aspects(), this.getTechnologySpecificImportedServiceAspect(), this.getTechnologySpecificImportedServiceAspect_DataOperationReturnTypeMapping(), "aspects", null, 0, -1, DataOperationReturnTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataOperationReturnTypeMapping_OperationMapping(), this.getDataOperationMapping(), this.getDataOperationMapping_ReturnTypeMapping(), "operationMapping", null, 0, 1, DataOperationReturnTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dataOperationParameterMappingEClass, DataOperationParameterMapping.class, "DataOperationParameterMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDataOperationParameterMapping_Parameter(), theDataPackage.getDataOperationParameter(), null, "parameter", null, 0, 1, DataOperationParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataOperationParameterMapping_Technology(), theServicePackage.getImport(), null, "technology", null, 0, 1, DataOperationParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataOperationParameterMapping_Type(), theDataPackage.getType(), null, "type", null, 0, 1, DataOperationParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataOperationParameterMapping_Aspects(), this.getTechnologySpecificImportedServiceAspect(), this.getTechnologySpecificImportedServiceAspect_DataOperationParameterMapping(), "aspects", null, 0, -1, DataOperationParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataOperationParameterMapping_OperationMapping(), this.getDataOperationMapping(), this.getDataOperationMapping_ParameterMappings(), "operationMapping", null, 0, 1, DataOperationParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(technologySpecificProtocolSpecificationEClass, TechnologySpecificProtocolSpecification.class, "TechnologySpecificProtocolSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTechnologySpecificProtocolSpecification_CommunicationType(), theTechnologyPackage.getCommunicationType(), "communicationType", null, 0, 1, TechnologySpecificProtocolSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificProtocolSpecification_TechnologySpecificProtocol(), this.getTechnologySpecificProtocol(), this.getTechnologySpecificProtocol_ProtocolSpecification(), "technologySpecificProtocol", null, 0, 1, TechnologySpecificProtocolSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(technologySpecificProtocolEClass, TechnologySpecificProtocol.class, "TechnologySpecificProtocol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTechnologySpecificProtocol_Technology(), theServicePackage.getImport(), null, "technology", null, 0, 1, TechnologySpecificProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificProtocol_Protocol(), theTechnologyPackage.getProtocol(), null, "protocol", null, 0, 1, TechnologySpecificProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificProtocol_DataFormat(), theTechnologyPackage.getDataFormat(), null, "dataFormat", null, 0, 1, TechnologySpecificProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificProtocol_ProtocolSpecification(), this.getTechnologySpecificProtocolSpecification(), this.getTechnologySpecificProtocolSpecification_TechnologySpecificProtocol(), "protocolSpecification", null, 0, 1, TechnologySpecificProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificProtocol_Endpoint(), this.getTechnologySpecificEndpoint(), this.getTechnologySpecificEndpoint_TechnologySpecificProtocols(), "endpoint", null, 0, 1, TechnologySpecificProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(technologySpecificEndpointEClass, TechnologySpecificEndpoint.class, "TechnologySpecificEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTechnologySpecificEndpoint_Addresses(), theEcorePackage.getEString(), "addresses", null, 1, -1, TechnologySpecificEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificEndpoint_TechnologySpecificProtocols(), this.getTechnologySpecificProtocol(), this.getTechnologySpecificProtocol_Endpoint(), "technologySpecificProtocols", null, 1, -1, TechnologySpecificEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificEndpoint_MicroserviceMapping(), this.getMicroserviceMapping(), this.getMicroserviceMapping_Endpoints(), "microserviceMapping", null, 0, 1, TechnologySpecificEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificEndpoint_InterfaceMapping(), this.getInterfaceMapping(), this.getInterfaceMapping_Endpoints(), "interfaceMapping", null, 0, 1, TechnologySpecificEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificEndpoint_OperationMapping(), this.getOperationMapping(), this.getOperationMapping_Endpoints(), "operationMapping", null, 0, 1, TechnologySpecificEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificEndpoint_ReferredOperationMapping(), this.getReferredOperationMapping(), this.getReferredOperationMapping_Endpoints(), "referredOperationMapping", null, 0, 1, TechnologySpecificEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(technologySpecificImportedServiceAspectEClass, TechnologySpecificImportedServiceAspect.class, "TechnologySpecificImportedServiceAspect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTechnologySpecificImportedServiceAspect_Technology(), theServicePackage.getImport(), null, "technology", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_Aspect(), theTechnologyPackage.getServiceAspect(), null, "aspect", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_SinglePropertyValue(), theDataPackage.getPrimitiveValue(), null, "singlePropertyValue", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_Values(), theTechnologyPackage.getTechnologySpecificPropertyValueAssignment(), null, "values", null, 0, -1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_TypeMapping(), this.getComplexTypeMapping(), this.getComplexTypeMapping_Aspects(), "typeMapping", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_MicroserviceMapping(), this.getMicroserviceMapping(), this.getMicroserviceMapping_Aspects(), "microserviceMapping", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_InterfaceMapping(), this.getInterfaceMapping(), this.getInterfaceMapping_Aspects(), "interfaceMapping", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_OperationMapping(), this.getOperationMapping(), this.getOperationMapping_Aspects(), "operationMapping", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_ReferredOperationMapping(), this.getReferredOperationMapping(), this.getReferredOperationMapping_Aspects(), "referredOperationMapping", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_ParameterMapping(), this.getParameterMapping(), this.getParameterMapping_Aspects(), "parameterMapping", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_FieldMapping(), this.getTechnologySpecificFieldMapping(), this.getTechnologySpecificFieldMapping_Aspects(), "fieldMapping", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_DataOperationMapping(), this.getDataOperationMapping(), this.getDataOperationMapping_Aspects(), "dataOperationMapping", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_DataOperationReturnTypeMapping(), this.getDataOperationReturnTypeMapping(), this.getDataOperationReturnTypeMapping_Aspects(), "dataOperationReturnTypeMapping", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTechnologySpecificImportedServiceAspect_DataOperationParameterMapping(), this.getDataOperationParameterMapping(), this.getDataOperationParameterMapping_Aspects(), "dataOperationParameterMapping", null, 0, 1, TechnologySpecificImportedServiceAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize data types
        initEDataType(dataFieldListEDataType, List.class, "DataFieldList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.List<de.fhdo.lemma.data.DataField>");

        // Create resource
        createResource(eNS_URI);
    }

} //MappingPackageImpl
