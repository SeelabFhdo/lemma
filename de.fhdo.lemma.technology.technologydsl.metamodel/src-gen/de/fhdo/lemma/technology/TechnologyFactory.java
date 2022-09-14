/**
 */
package de.fhdo.lemma.technology;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.fhdo.lemma.technology.TechnologyPackage
 * @generated
 */
public interface TechnologyFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    TechnologyFactory eINSTANCE = de.fhdo.lemma.technology.impl.TechnologyFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Technology</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Technology</em>'.
     * @generated
     */
    Technology createTechnology();

    /**
     * Returns a new object of class '<em>Import</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Import</em>'.
     * @generated
     */
    TechnologyImport createTechnologyImport();

    /**
     * Returns a new object of class '<em>Protocol</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Protocol</em>'.
     * @generated
     */
    Protocol createProtocol();

    /**
     * Returns a new object of class '<em>Data Format</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data Format</em>'.
     * @generated
     */
    DataFormat createDataFormat();

    /**
     * Returns a new object of class '<em>Specific Primitive Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Specific Primitive Type</em>'.
     * @generated
     */
    TechnologySpecificPrimitiveType createTechnologySpecificPrimitiveType();

    /**
     * Returns a new object of class '<em>Specific Collection Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Specific Collection Type</em>'.
     * @generated
     */
    TechnologySpecificCollectionType createTechnologySpecificCollectionType();

    /**
     * Returns a new object of class '<em>Specific Data Structure</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Specific Data Structure</em>'.
     * @generated
     */
    TechnologySpecificDataStructure createTechnologySpecificDataStructure();

    /**
     * Returns a new object of class '<em>Compatibility Matrix Entry</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Compatibility Matrix Entry</em>'.
     * @generated
     */
    CompatibilityMatrixEntry createCompatibilityMatrixEntry();

    /**
     * Returns a new object of class '<em>Possibly Imported Technology Specific Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Possibly Imported Technology Specific Type</em>'.
     * @generated
     */
    PossiblyImportedTechnologySpecificType createPossiblyImportedTechnologySpecificType();

    /**
     * Returns a new object of class '<em>Operation Environment</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Operation Environment</em>'.
     * @generated
     */
    OperationEnvironment createOperationEnvironment();

    /**
     * Returns a new object of class '<em>Specific Property</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Specific Property</em>'.
     * @generated
     */
    TechnologySpecificProperty createTechnologySpecificProperty();

    /**
     * Returns a new object of class '<em>Specific Property Value Assignment</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Specific Property Value Assignment</em>'.
     * @generated
     */
    TechnologySpecificPropertyValueAssignment createTechnologySpecificPropertyValueAssignment();

    /**
     * Returns a new object of class '<em>Deployment Technology</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Deployment Technology</em>'.
     * @generated
     */
    DeploymentTechnology createDeploymentTechnology();

    /**
     * Returns a new object of class '<em>Infrastructure Technology</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Infrastructure Technology</em>'.
     * @generated
     */
    InfrastructureTechnology createInfrastructureTechnology();

    /**
     * Returns a new object of class '<em>Service Aspect</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Service Aspect</em>'.
     * @generated
     */
    ServiceAspect createServiceAspect();

    /**
     * Returns a new object of class '<em>Service Aspect Pointcut</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Service Aspect Pointcut</em>'.
     * @generated
     */
    ServiceAspectPointcut createServiceAspectPointcut();

    /**
     * Returns a new object of class '<em>Service Aspect Pointcut Selector</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Service Aspect Pointcut Selector</em>'.
     * @generated
     */
    ServiceAspectPointcutSelector createServiceAspectPointcutSelector();

    /**
     * Returns a new object of class '<em>Operation Aspect</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Operation Aspect</em>'.
     * @generated
     */
    OperationAspect createOperationAspect();

    /**
     * Returns a new object of class '<em>Operation Aspect Pointcut</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Operation Aspect Pointcut</em>'.
     * @generated
     */
    OperationAspectPointcut createOperationAspectPointcut();

    /**
     * Returns a new object of class '<em>Operation Aspect Pointcut Selector</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Operation Aspect Pointcut Selector</em>'.
     * @generated
     */
    OperationAspectPointcutSelector createOperationAspectPointcutSelector();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    TechnologyPackage getTechnologyPackage();

} //TechnologyFactory
