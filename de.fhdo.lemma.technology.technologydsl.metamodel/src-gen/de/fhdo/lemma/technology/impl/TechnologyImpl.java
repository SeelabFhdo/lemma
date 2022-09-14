/**
 */
package de.fhdo.lemma.technology.impl;

import de.fhdo.lemma.technology.CompatibilityMatrixEntry;
import de.fhdo.lemma.technology.DeploymentTechnology;
import de.fhdo.lemma.technology.InfrastructureTechnology;
import de.fhdo.lemma.technology.OperationAspect;
import de.fhdo.lemma.technology.Protocol;
import de.fhdo.lemma.technology.ServiceAspect;
import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.technology.TechnologyImport;
import de.fhdo.lemma.technology.TechnologyPackage;
import de.fhdo.lemma.technology.TechnologySpecificCollectionType;
import de.fhdo.lemma.technology.TechnologySpecificDataStructure;
import de.fhdo.lemma.technology.TechnologySpecificPrimitiveType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Technology</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologyImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologyImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologyImpl#getPrimitiveTypes <em>Primitive Types</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologyImpl#getCollectionTypes <em>Collection Types</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologyImpl#getDataStructures <em>Data Structures</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologyImpl#getCompatibilityEntries <em>Compatibility Entries</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologyImpl#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologyImpl#getServiceAspects <em>Service Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologyImpl#getDeploymentTechnologies <em>Deployment Technologies</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologyImpl#getInfrastructureTechnologies <em>Infrastructure Technologies</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologyImpl#getOperationAspects <em>Operation Aspects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TechnologyImpl extends MinimalEObjectImpl.Container implements Technology {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImports()
     * @generated
     * @ordered
     */
    protected EList<TechnologyImport> imports;

    /**
     * The cached value of the '{@link #getPrimitiveTypes() <em>Primitive Types</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrimitiveTypes()
     * @generated
     * @ordered
     */
    protected EList<TechnologySpecificPrimitiveType> primitiveTypes;

    /**
     * The cached value of the '{@link #getCollectionTypes() <em>Collection Types</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCollectionTypes()
     * @generated
     * @ordered
     */
    protected EList<TechnologySpecificCollectionType> collectionTypes;

    /**
     * The cached value of the '{@link #getDataStructures() <em>Data Structures</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataStructures()
     * @generated
     * @ordered
     */
    protected EList<TechnologySpecificDataStructure> dataStructures;

    /**
     * The cached value of the '{@link #getCompatibilityEntries() <em>Compatibility Entries</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCompatibilityEntries()
     * @generated
     * @ordered
     */
    protected EList<CompatibilityMatrixEntry> compatibilityEntries;

    /**
     * The cached value of the '{@link #getProtocols() <em>Protocols</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProtocols()
     * @generated
     * @ordered
     */
    protected EList<Protocol> protocols;

    /**
     * The cached value of the '{@link #getServiceAspects() <em>Service Aspects</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServiceAspects()
     * @generated
     * @ordered
     */
    protected EList<ServiceAspect> serviceAspects;

    /**
     * The cached value of the '{@link #getDeploymentTechnologies() <em>Deployment Technologies</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDeploymentTechnologies()
     * @generated
     * @ordered
     */
    protected EList<DeploymentTechnology> deploymentTechnologies;

    /**
     * The cached value of the '{@link #getInfrastructureTechnologies() <em>Infrastructure Technologies</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInfrastructureTechnologies()
     * @generated
     * @ordered
     */
    protected EList<InfrastructureTechnology> infrastructureTechnologies;

    /**
     * The cached value of the '{@link #getOperationAspects() <em>Operation Aspects</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperationAspects()
     * @generated
     * @ordered
     */
    protected EList<OperationAspect> operationAspects;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TechnologyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TechnologyPackage.Literals.TECHNOLOGY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.TECHNOLOGY__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TechnologyImport> getImports() {
        if (imports == null) {
            imports = new EObjectContainmentWithInverseEList<TechnologyImport>(TechnologyImport.class, this, TechnologyPackage.TECHNOLOGY__IMPORTS, TechnologyPackage.TECHNOLOGY_IMPORT__TECHNOLOGY);
        }
        return imports;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TechnologySpecificPrimitiveType> getPrimitiveTypes() {
        if (primitiveTypes == null) {
            primitiveTypes = new EObjectContainmentWithInverseEList<TechnologySpecificPrimitiveType>(TechnologySpecificPrimitiveType.class, this, TechnologyPackage.TECHNOLOGY__PRIMITIVE_TYPES, TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__TECHNOLOGY);
        }
        return primitiveTypes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TechnologySpecificCollectionType> getCollectionTypes() {
        if (collectionTypes == null) {
            collectionTypes = new EObjectContainmentWithInverseEList<TechnologySpecificCollectionType>(TechnologySpecificCollectionType.class, this, TechnologyPackage.TECHNOLOGY__COLLECTION_TYPES, TechnologyPackage.TECHNOLOGY_SPECIFIC_COLLECTION_TYPE__TECHNOLOGY);
        }
        return collectionTypes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TechnologySpecificDataStructure> getDataStructures() {
        if (dataStructures == null) {
            dataStructures = new EObjectContainmentWithInverseEList<TechnologySpecificDataStructure>(TechnologySpecificDataStructure.class, this, TechnologyPackage.TECHNOLOGY__DATA_STRUCTURES, TechnologyPackage.TECHNOLOGY_SPECIFIC_DATA_STRUCTURE__TECHNOLOGY);
        }
        return dataStructures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<CompatibilityMatrixEntry> getCompatibilityEntries() {
        if (compatibilityEntries == null) {
            compatibilityEntries = new EObjectContainmentWithInverseEList<CompatibilityMatrixEntry>(CompatibilityMatrixEntry.class, this, TechnologyPackage.TECHNOLOGY__COMPATIBILITY_ENTRIES, TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__TECHNOLOGY);
        }
        return compatibilityEntries;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Protocol> getProtocols() {
        if (protocols == null) {
            protocols = new EObjectContainmentWithInverseEList<Protocol>(Protocol.class, this, TechnologyPackage.TECHNOLOGY__PROTOCOLS, TechnologyPackage.PROTOCOL__TECHNOLOGY);
        }
        return protocols;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ServiceAspect> getServiceAspects() {
        if (serviceAspects == null) {
            serviceAspects = new EObjectContainmentWithInverseEList<ServiceAspect>(ServiceAspect.class, this, TechnologyPackage.TECHNOLOGY__SERVICE_ASPECTS, TechnologyPackage.SERVICE_ASPECT__TECHNOLOGY);
        }
        return serviceAspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<DeploymentTechnology> getDeploymentTechnologies() {
        if (deploymentTechnologies == null) {
            deploymentTechnologies = new EObjectContainmentWithInverseEList<DeploymentTechnology>(DeploymentTechnology.class, this, TechnologyPackage.TECHNOLOGY__DEPLOYMENT_TECHNOLOGIES, TechnologyPackage.DEPLOYMENT_TECHNOLOGY__TECHNOLOGY);
        }
        return deploymentTechnologies;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<InfrastructureTechnology> getInfrastructureTechnologies() {
        if (infrastructureTechnologies == null) {
            infrastructureTechnologies = new EObjectContainmentWithInverseEList<InfrastructureTechnology>(InfrastructureTechnology.class, this, TechnologyPackage.TECHNOLOGY__INFRASTRUCTURE_TECHNOLOGIES, TechnologyPackage.INFRASTRUCTURE_TECHNOLOGY__TECHNOLOGY);
        }
        return infrastructureTechnologies;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<OperationAspect> getOperationAspects() {
        if (operationAspects == null) {
            operationAspects = new EObjectContainmentWithInverseEList<OperationAspect>(OperationAspect.class, this, TechnologyPackage.TECHNOLOGY__OPERATION_ASPECTS, TechnologyPackage.OPERATION_ASPECT__TECHNOLOGY);
        }
        return operationAspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TechnologyPackage.TECHNOLOGY__IMPORTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getImports()).basicAdd(otherEnd, msgs);
            case TechnologyPackage.TECHNOLOGY__PRIMITIVE_TYPES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getPrimitiveTypes()).basicAdd(otherEnd, msgs);
            case TechnologyPackage.TECHNOLOGY__COLLECTION_TYPES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getCollectionTypes()).basicAdd(otherEnd, msgs);
            case TechnologyPackage.TECHNOLOGY__DATA_STRUCTURES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getDataStructures()).basicAdd(otherEnd, msgs);
            case TechnologyPackage.TECHNOLOGY__COMPATIBILITY_ENTRIES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getCompatibilityEntries()).basicAdd(otherEnd, msgs);
            case TechnologyPackage.TECHNOLOGY__PROTOCOLS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getProtocols()).basicAdd(otherEnd, msgs);
            case TechnologyPackage.TECHNOLOGY__SERVICE_ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getServiceAspects()).basicAdd(otherEnd, msgs);
            case TechnologyPackage.TECHNOLOGY__DEPLOYMENT_TECHNOLOGIES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getDeploymentTechnologies()).basicAdd(otherEnd, msgs);
            case TechnologyPackage.TECHNOLOGY__INFRASTRUCTURE_TECHNOLOGIES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getInfrastructureTechnologies()).basicAdd(otherEnd, msgs);
            case TechnologyPackage.TECHNOLOGY__OPERATION_ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getOperationAspects()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TechnologyPackage.TECHNOLOGY__IMPORTS:
                return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
            case TechnologyPackage.TECHNOLOGY__PRIMITIVE_TYPES:
                return ((InternalEList<?>)getPrimitiveTypes()).basicRemove(otherEnd, msgs);
            case TechnologyPackage.TECHNOLOGY__COLLECTION_TYPES:
                return ((InternalEList<?>)getCollectionTypes()).basicRemove(otherEnd, msgs);
            case TechnologyPackage.TECHNOLOGY__DATA_STRUCTURES:
                return ((InternalEList<?>)getDataStructures()).basicRemove(otherEnd, msgs);
            case TechnologyPackage.TECHNOLOGY__COMPATIBILITY_ENTRIES:
                return ((InternalEList<?>)getCompatibilityEntries()).basicRemove(otherEnd, msgs);
            case TechnologyPackage.TECHNOLOGY__PROTOCOLS:
                return ((InternalEList<?>)getProtocols()).basicRemove(otherEnd, msgs);
            case TechnologyPackage.TECHNOLOGY__SERVICE_ASPECTS:
                return ((InternalEList<?>)getServiceAspects()).basicRemove(otherEnd, msgs);
            case TechnologyPackage.TECHNOLOGY__DEPLOYMENT_TECHNOLOGIES:
                return ((InternalEList<?>)getDeploymentTechnologies()).basicRemove(otherEnd, msgs);
            case TechnologyPackage.TECHNOLOGY__INFRASTRUCTURE_TECHNOLOGIES:
                return ((InternalEList<?>)getInfrastructureTechnologies()).basicRemove(otherEnd, msgs);
            case TechnologyPackage.TECHNOLOGY__OPERATION_ASPECTS:
                return ((InternalEList<?>)getOperationAspects()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case TechnologyPackage.TECHNOLOGY__NAME:
                return getName();
            case TechnologyPackage.TECHNOLOGY__IMPORTS:
                return getImports();
            case TechnologyPackage.TECHNOLOGY__PRIMITIVE_TYPES:
                return getPrimitiveTypes();
            case TechnologyPackage.TECHNOLOGY__COLLECTION_TYPES:
                return getCollectionTypes();
            case TechnologyPackage.TECHNOLOGY__DATA_STRUCTURES:
                return getDataStructures();
            case TechnologyPackage.TECHNOLOGY__COMPATIBILITY_ENTRIES:
                return getCompatibilityEntries();
            case TechnologyPackage.TECHNOLOGY__PROTOCOLS:
                return getProtocols();
            case TechnologyPackage.TECHNOLOGY__SERVICE_ASPECTS:
                return getServiceAspects();
            case TechnologyPackage.TECHNOLOGY__DEPLOYMENT_TECHNOLOGIES:
                return getDeploymentTechnologies();
            case TechnologyPackage.TECHNOLOGY__INFRASTRUCTURE_TECHNOLOGIES:
                return getInfrastructureTechnologies();
            case TechnologyPackage.TECHNOLOGY__OPERATION_ASPECTS:
                return getOperationAspects();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case TechnologyPackage.TECHNOLOGY__NAME:
                setName((String)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY__IMPORTS:
                getImports().clear();
                getImports().addAll((Collection<? extends TechnologyImport>)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY__PRIMITIVE_TYPES:
                getPrimitiveTypes().clear();
                getPrimitiveTypes().addAll((Collection<? extends TechnologySpecificPrimitiveType>)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY__COLLECTION_TYPES:
                getCollectionTypes().clear();
                getCollectionTypes().addAll((Collection<? extends TechnologySpecificCollectionType>)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY__DATA_STRUCTURES:
                getDataStructures().clear();
                getDataStructures().addAll((Collection<? extends TechnologySpecificDataStructure>)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY__COMPATIBILITY_ENTRIES:
                getCompatibilityEntries().clear();
                getCompatibilityEntries().addAll((Collection<? extends CompatibilityMatrixEntry>)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY__PROTOCOLS:
                getProtocols().clear();
                getProtocols().addAll((Collection<? extends Protocol>)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY__SERVICE_ASPECTS:
                getServiceAspects().clear();
                getServiceAspects().addAll((Collection<? extends ServiceAspect>)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY__DEPLOYMENT_TECHNOLOGIES:
                getDeploymentTechnologies().clear();
                getDeploymentTechnologies().addAll((Collection<? extends DeploymentTechnology>)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY__INFRASTRUCTURE_TECHNOLOGIES:
                getInfrastructureTechnologies().clear();
                getInfrastructureTechnologies().addAll((Collection<? extends InfrastructureTechnology>)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY__OPERATION_ASPECTS:
                getOperationAspects().clear();
                getOperationAspects().addAll((Collection<? extends OperationAspect>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case TechnologyPackage.TECHNOLOGY__NAME:
                setName(NAME_EDEFAULT);
                return;
            case TechnologyPackage.TECHNOLOGY__IMPORTS:
                getImports().clear();
                return;
            case TechnologyPackage.TECHNOLOGY__PRIMITIVE_TYPES:
                getPrimitiveTypes().clear();
                return;
            case TechnologyPackage.TECHNOLOGY__COLLECTION_TYPES:
                getCollectionTypes().clear();
                return;
            case TechnologyPackage.TECHNOLOGY__DATA_STRUCTURES:
                getDataStructures().clear();
                return;
            case TechnologyPackage.TECHNOLOGY__COMPATIBILITY_ENTRIES:
                getCompatibilityEntries().clear();
                return;
            case TechnologyPackage.TECHNOLOGY__PROTOCOLS:
                getProtocols().clear();
                return;
            case TechnologyPackage.TECHNOLOGY__SERVICE_ASPECTS:
                getServiceAspects().clear();
                return;
            case TechnologyPackage.TECHNOLOGY__DEPLOYMENT_TECHNOLOGIES:
                getDeploymentTechnologies().clear();
                return;
            case TechnologyPackage.TECHNOLOGY__INFRASTRUCTURE_TECHNOLOGIES:
                getInfrastructureTechnologies().clear();
                return;
            case TechnologyPackage.TECHNOLOGY__OPERATION_ASPECTS:
                getOperationAspects().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case TechnologyPackage.TECHNOLOGY__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case TechnologyPackage.TECHNOLOGY__IMPORTS:
                return imports != null && !imports.isEmpty();
            case TechnologyPackage.TECHNOLOGY__PRIMITIVE_TYPES:
                return primitiveTypes != null && !primitiveTypes.isEmpty();
            case TechnologyPackage.TECHNOLOGY__COLLECTION_TYPES:
                return collectionTypes != null && !collectionTypes.isEmpty();
            case TechnologyPackage.TECHNOLOGY__DATA_STRUCTURES:
                return dataStructures != null && !dataStructures.isEmpty();
            case TechnologyPackage.TECHNOLOGY__COMPATIBILITY_ENTRIES:
                return compatibilityEntries != null && !compatibilityEntries.isEmpty();
            case TechnologyPackage.TECHNOLOGY__PROTOCOLS:
                return protocols != null && !protocols.isEmpty();
            case TechnologyPackage.TECHNOLOGY__SERVICE_ASPECTS:
                return serviceAspects != null && !serviceAspects.isEmpty();
            case TechnologyPackage.TECHNOLOGY__DEPLOYMENT_TECHNOLOGIES:
                return deploymentTechnologies != null && !deploymentTechnologies.isEmpty();
            case TechnologyPackage.TECHNOLOGY__INFRASTRUCTURE_TECHNOLOGIES:
                return infrastructureTechnologies != null && !infrastructureTechnologies.isEmpty();
            case TechnologyPackage.TECHNOLOGY__OPERATION_ASPECTS:
                return operationAspects != null && !operationAspects.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //TechnologyImpl
