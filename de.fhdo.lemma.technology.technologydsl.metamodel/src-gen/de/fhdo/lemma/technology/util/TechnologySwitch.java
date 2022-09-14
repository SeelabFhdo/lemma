/**
 */
package de.fhdo.lemma.technology.util;

import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.data.Type;

import de.fhdo.lemma.technology.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.fhdo.lemma.technology.TechnologyPackage
 * @generated
 */
public class TechnologySwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static TechnologyPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologySwitch() {
        if (modelPackage == null) {
            modelPackage = TechnologyPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case TechnologyPackage.TECHNOLOGY: {
                Technology technology = (Technology)theEObject;
                T result = caseTechnology(technology);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.TECHNOLOGY_IMPORT: {
                TechnologyImport technologyImport = (TechnologyImport)theEObject;
                T result = caseTechnologyImport(technologyImport);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.PROTOCOL: {
                Protocol protocol = (Protocol)theEObject;
                T result = caseProtocol(protocol);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.DATA_FORMAT: {
                DataFormat dataFormat = (DataFormat)theEObject;
                T result = caseDataFormat(dataFormat);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE: {
                TechnologySpecificPrimitiveType technologySpecificPrimitiveType = (TechnologySpecificPrimitiveType)theEObject;
                T result = caseTechnologySpecificPrimitiveType(technologySpecificPrimitiveType);
                if (result == null) result = casePrimitiveType(technologySpecificPrimitiveType);
                if (result == null) result = caseType(technologySpecificPrimitiveType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_COLLECTION_TYPE: {
                TechnologySpecificCollectionType technologySpecificCollectionType = (TechnologySpecificCollectionType)theEObject;
                T result = caseTechnologySpecificCollectionType(technologySpecificCollectionType);
                if (result == null) result = caseComplexType(technologySpecificCollectionType);
                if (result == null) result = caseType(technologySpecificCollectionType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_DATA_STRUCTURE: {
                TechnologySpecificDataStructure technologySpecificDataStructure = (TechnologySpecificDataStructure)theEObject;
                T result = caseTechnologySpecificDataStructure(technologySpecificDataStructure);
                if (result == null) result = caseComplexType(technologySpecificDataStructure);
                if (result == null) result = caseType(technologySpecificDataStructure);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY: {
                CompatibilityMatrixEntry compatibilityMatrixEntry = (CompatibilityMatrixEntry)theEObject;
                T result = caseCompatibilityMatrixEntry(compatibilityMatrixEntry);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE: {
                PossiblyImportedTechnologySpecificType possiblyImportedTechnologySpecificType = (PossiblyImportedTechnologySpecificType)theEObject;
                T result = casePossiblyImportedTechnologySpecificType(possiblyImportedTechnologySpecificType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.OPERATION_TECHNOLOGY: {
                OperationTechnology operationTechnology = (OperationTechnology)theEObject;
                T result = caseOperationTechnology(operationTechnology);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.OPERATION_ENVIRONMENT: {
                OperationEnvironment operationEnvironment = (OperationEnvironment)theEObject;
                T result = caseOperationEnvironment(operationEnvironment);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY: {
                TechnologySpecificProperty technologySpecificProperty = (TechnologySpecificProperty)theEObject;
                T result = caseTechnologySpecificProperty(technologySpecificProperty);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT: {
                TechnologySpecificPropertyValueAssignment technologySpecificPropertyValueAssignment = (TechnologySpecificPropertyValueAssignment)theEObject;
                T result = caseTechnologySpecificPropertyValueAssignment(technologySpecificPropertyValueAssignment);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.DEPLOYMENT_TECHNOLOGY: {
                DeploymentTechnology deploymentTechnology = (DeploymentTechnology)theEObject;
                T result = caseDeploymentTechnology(deploymentTechnology);
                if (result == null) result = caseOperationTechnology(deploymentTechnology);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.INFRASTRUCTURE_TECHNOLOGY: {
                InfrastructureTechnology infrastructureTechnology = (InfrastructureTechnology)theEObject;
                T result = caseInfrastructureTechnology(infrastructureTechnology);
                if (result == null) result = caseOperationTechnology(infrastructureTechnology);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.TECHNOLOGY_ASPECT: {
                TechnologyAspect technologyAspect = (TechnologyAspect)theEObject;
                T result = caseTechnologyAspect(technologyAspect);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.SERVICE_ASPECT: {
                ServiceAspect serviceAspect = (ServiceAspect)theEObject;
                T result = caseServiceAspect(serviceAspect);
                if (result == null) result = caseTechnologyAspect(serviceAspect);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT: {
                ServiceAspectPointcut serviceAspectPointcut = (ServiceAspectPointcut)theEObject;
                T result = caseServiceAspectPointcut(serviceAspectPointcut);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR: {
                ServiceAspectPointcutSelector serviceAspectPointcutSelector = (ServiceAspectPointcutSelector)theEObject;
                T result = caseServiceAspectPointcutSelector(serviceAspectPointcutSelector);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.OPERATION_ASPECT: {
                OperationAspect operationAspect = (OperationAspect)theEObject;
                T result = caseOperationAspect(operationAspect);
                if (result == null) result = caseTechnologyAspect(operationAspect);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT: {
                OperationAspectPointcut operationAspectPointcut = (OperationAspectPointcut)theEObject;
                T result = caseOperationAspectPointcut(operationAspectPointcut);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR: {
                OperationAspectPointcutSelector operationAspectPointcutSelector = (OperationAspectPointcutSelector)theEObject;
                T result = caseOperationAspectPointcutSelector(operationAspectPointcutSelector);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Technology</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Technology</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTechnology(Technology object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Import</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTechnologyImport(TechnologyImport object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Protocol</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Protocol</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseProtocol(Protocol object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Format</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Format</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataFormat(DataFormat object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Specific Primitive Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Specific Primitive Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTechnologySpecificPrimitiveType(TechnologySpecificPrimitiveType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Specific Collection Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Specific Collection Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTechnologySpecificCollectionType(TechnologySpecificCollectionType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Specific Data Structure</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Specific Data Structure</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTechnologySpecificDataStructure(TechnologySpecificDataStructure object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Compatibility Matrix Entry</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Compatibility Matrix Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCompatibilityMatrixEntry(CompatibilityMatrixEntry object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Possibly Imported Technology Specific Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Possibly Imported Technology Specific Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePossiblyImportedTechnologySpecificType(PossiblyImportedTechnologySpecificType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operation Technology</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation Technology</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOperationTechnology(OperationTechnology object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operation Environment</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation Environment</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOperationEnvironment(OperationEnvironment object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Specific Property</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Specific Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTechnologySpecificProperty(TechnologySpecificProperty object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Specific Property Value Assignment</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Specific Property Value Assignment</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTechnologySpecificPropertyValueAssignment(TechnologySpecificPropertyValueAssignment object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Deployment Technology</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Deployment Technology</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDeploymentTechnology(DeploymentTechnology object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Infrastructure Technology</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Infrastructure Technology</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInfrastructureTechnology(InfrastructureTechnology object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Aspect</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Aspect</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTechnologyAspect(TechnologyAspect object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Service Aspect</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Service Aspect</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseServiceAspect(ServiceAspect object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Service Aspect Pointcut</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Service Aspect Pointcut</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseServiceAspectPointcut(ServiceAspectPointcut object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Service Aspect Pointcut Selector</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Service Aspect Pointcut Selector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseServiceAspectPointcutSelector(ServiceAspectPointcutSelector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operation Aspect</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation Aspect</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOperationAspect(OperationAspect object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operation Aspect Pointcut</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation Aspect Pointcut</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOperationAspectPointcut(OperationAspectPointcut object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operation Aspect Pointcut Selector</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation Aspect Pointcut Selector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOperationAspectPointcutSelector(OperationAspectPointcutSelector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseType(Type object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrimitiveType(PrimitiveType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Complex Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Complex Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseComplexType(ComplexType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} //TechnologySwitch
