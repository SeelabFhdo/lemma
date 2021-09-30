/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import de.fhdo.lemma.operation.intermediate.IntermediateContainer;
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationModelImpl#getSourceModelUri <em>Source Model Uri</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationModelImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationModelImpl#getContainers <em>Containers</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationModelImpl#getInfrastructureNodes <em>Infrastructure Nodes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateOperationModelImpl extends MinimalEObjectImpl.Container implements IntermediateOperationModel {
    /**
     * The default value of the '{@link #getSourceModelUri() <em>Source Model Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceModelUri()
     * @generated
     * @ordered
     */
    protected static final String SOURCE_MODEL_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSourceModelUri() <em>Source Model Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceModelUri()
     * @generated
     * @ordered
     */
    protected String sourceModelUri = SOURCE_MODEL_URI_EDEFAULT;

    /**
     * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImports()
     * @generated
     * @ordered
     */
    protected EList<IntermediateImport> imports;

    /**
     * The cached value of the '{@link #getContainers() <em>Containers</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContainers()
     * @generated
     * @ordered
     */
    protected EList<IntermediateContainer> containers;

    /**
     * The cached value of the '{@link #getInfrastructureNodes() <em>Infrastructure Nodes</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInfrastructureNodes()
     * @generated
     * @ordered
     */
    protected EList<IntermediateInfrastructureNode> infrastructureNodes;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediateOperationModelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_OPERATION_MODEL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSourceModelUri() {
        return sourceModelUri;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSourceModelUri(String newSourceModelUri) {
        String oldSourceModelUri = sourceModelUri;
        sourceModelUri = newSourceModelUri;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__SOURCE_MODEL_URI, oldSourceModelUri, sourceModelUri));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateImport> getImports() {
        if (imports == null) {
            imports = new EObjectContainmentEList<IntermediateImport>(IntermediateImport.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__IMPORTS);
        }
        return imports;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateContainer> getContainers() {
        if (containers == null) {
            containers = new EObjectContainmentWithInverseEList<IntermediateContainer>(IntermediateContainer.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__CONTAINERS, IntermediatePackage.INTERMEDIATE_CONTAINER__OPERATION_MODEL);
        }
        return containers;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateInfrastructureNode> getInfrastructureNodes() {
        if (infrastructureNodes == null) {
            infrastructureNodes = new EObjectContainmentWithInverseEList<IntermediateInfrastructureNode>(IntermediateInfrastructureNode.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INFRASTRUCTURE_NODES, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_NODE__OPERATION_MODEL);
        }
        return infrastructureNodes;
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__CONTAINERS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getContainers()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INFRASTRUCTURE_NODES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getInfrastructureNodes()).basicAdd(otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__IMPORTS:
                return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__CONTAINERS:
                return ((InternalEList<?>)getContainers()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INFRASTRUCTURE_NODES:
                return ((InternalEList<?>)getInfrastructureNodes()).basicRemove(otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__SOURCE_MODEL_URI:
                return getSourceModelUri();
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__IMPORTS:
                return getImports();
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__CONTAINERS:
                return getContainers();
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INFRASTRUCTURE_NODES:
                return getInfrastructureNodes();
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__SOURCE_MODEL_URI:
                setSourceModelUri((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__IMPORTS:
                getImports().clear();
                getImports().addAll((Collection<? extends IntermediateImport>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__CONTAINERS:
                getContainers().clear();
                getContainers().addAll((Collection<? extends IntermediateContainer>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INFRASTRUCTURE_NODES:
                getInfrastructureNodes().clear();
                getInfrastructureNodes().addAll((Collection<? extends IntermediateInfrastructureNode>)newValue);
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__SOURCE_MODEL_URI:
                setSourceModelUri(SOURCE_MODEL_URI_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__IMPORTS:
                getImports().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__CONTAINERS:
                getContainers().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INFRASTRUCTURE_NODES:
                getInfrastructureNodes().clear();
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__SOURCE_MODEL_URI:
                return SOURCE_MODEL_URI_EDEFAULT == null ? sourceModelUri != null : !SOURCE_MODEL_URI_EDEFAULT.equals(sourceModelUri);
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__IMPORTS:
                return imports != null && !imports.isEmpty();
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__CONTAINERS:
                return containers != null && !containers.isEmpty();
            case IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__INFRASTRUCTURE_NODES:
                return infrastructureNodes != null && !infrastructureNodes.isEmpty();
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
        result.append(" (sourceModelUri: ");
        result.append(sourceModelUri);
        result.append(')');
        return result.toString();
    }

} //IntermediateOperationModelImpl
