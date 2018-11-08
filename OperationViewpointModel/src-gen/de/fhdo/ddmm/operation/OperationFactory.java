/**
 */
package de.fhdo.ddmm.operation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.fhdo.ddmm.operation.OperationPackage
 * @generated
 */
public interface OperationFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    OperationFactory eINSTANCE = de.fhdo.ddmm.operation.impl.OperationFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Model</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Model</em>'.
     * @generated
     */
    OperationModel createOperationModel();

    /**
     * Returns a new object of class '<em>Container</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Container</em>'.
     * @generated
     */
    Container createContainer();

    /**
     * Returns a new object of class '<em>Infrastructure Node</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Infrastructure Node</em>'.
     * @generated
     */
    InfrastructureNode createInfrastructureNode();

    /**
     * Returns a new object of class '<em>Imported Microservice</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Imported Microservice</em>'.
     * @generated
     */
    ImportedMicroservice createImportedMicroservice();

    /**
     * Returns a new object of class '<em>Service Deployment Specification</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Service Deployment Specification</em>'.
     * @generated
     */
    ServiceDeploymentSpecification createServiceDeploymentSpecification();

    /**
     * Returns a new object of class '<em>Protocol And Data Format</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Protocol And Data Format</em>'.
     * @generated
     */
    ProtocolAndDataFormat createProtocolAndDataFormat();

    /**
     * Returns a new object of class '<em>Basic Endpoint</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Basic Endpoint</em>'.
     * @generated
     */
    BasicEndpoint createBasicEndpoint();

    /**
     * Returns a new object of class '<em>Imported Operation Aspect</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Imported Operation Aspect</em>'.
     * @generated
     */
    ImportedOperationAspect createImportedOperationAspect();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    OperationPackage getOperationPackage();

} //OperationFactory
