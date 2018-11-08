/**
 */
package de.fhdo.ddmm.technology.mapping;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.fhdo.ddmm.technology.mapping.MappingPackage
 * @generated
 */
public interface MappingFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    MappingFactory eINSTANCE = de.fhdo.ddmm.technology.mapping.impl.MappingFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Technology Mapping</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Technology Mapping</em>'.
     * @generated
     */
    TechnologyMapping createTechnologyMapping();

    /**
     * Returns a new object of class '<em>Microservice Mapping</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Microservice Mapping</em>'.
     * @generated
     */
    MicroserviceMapping createMicroserviceMapping();

    /**
     * Returns a new object of class '<em>Imported Microservice</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Imported Microservice</em>'.
     * @generated
     */
    ImportedMicroservice createImportedMicroservice();

    /**
     * Returns a new object of class '<em>Interface Mapping</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Interface Mapping</em>'.
     * @generated
     */
    InterfaceMapping createInterfaceMapping();

    /**
     * Returns a new object of class '<em>Operation Mapping</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Operation Mapping</em>'.
     * @generated
     */
    OperationMapping createOperationMapping();

    /**
     * Returns a new object of class '<em>Referred Operation Mapping</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Referred Operation Mapping</em>'.
     * @generated
     */
    ReferredOperationMapping createReferredOperationMapping();

    /**
     * Returns a new object of class '<em>Primitive Parameter Mapping</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Primitive Parameter Mapping</em>'.
     * @generated
     */
    PrimitiveParameterMapping createPrimitiveParameterMapping();

    /**
     * Returns a new object of class '<em>Complex Parameter Mapping</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Complex Parameter Mapping</em>'.
     * @generated
     */
    ComplexParameterMapping createComplexParameterMapping();

    /**
     * Returns a new object of class '<em>Technology Specific Data Field Type Mapping</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Technology Specific Data Field Type Mapping</em>'.
     * @generated
     */
    TechnologySpecificDataFieldTypeMapping createTechnologySpecificDataFieldTypeMapping();

    /**
     * Returns a new object of class '<em>Data Field Hierarchy</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data Field Hierarchy</em>'.
     * @generated
     */
    DataFieldHierarchy createDataFieldHierarchy();

    /**
     * Returns a new object of class '<em>Technology Specific Protocol Specification</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Technology Specific Protocol Specification</em>'.
     * @generated
     */
    TechnologySpecificProtocolSpecification createTechnologySpecificProtocolSpecification();

    /**
     * Returns a new object of class '<em>Technology Specific Protocol</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Technology Specific Protocol</em>'.
     * @generated
     */
    TechnologySpecificProtocol createTechnologySpecificProtocol();

    /**
     * Returns a new object of class '<em>Technology Specific Endpoint</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Technology Specific Endpoint</em>'.
     * @generated
     */
    TechnologySpecificEndpoint createTechnologySpecificEndpoint();

    /**
     * Returns a new object of class '<em>Technology Specific Imported Service Aspect</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Technology Specific Imported Service Aspect</em>'.
     * @generated
     */
    TechnologySpecificImportedServiceAspect createTechnologySpecificImportedServiceAspect();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    MappingPackage getMappingPackage();

} //MappingFactory
