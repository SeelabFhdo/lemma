/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.operation.intermediate.IntermediateContainer;
import de.fhdo.lemma.operation.intermediate.IntermediateDeploymentTechnologyReference;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateContainerImpl#getQualifiedDeploymentTechnologyName <em>Qualified Deployment Technology Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateContainerImpl#getTechnologyReference <em>Technology Reference</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateContainerImpl#getOperationModel <em>Operation Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateContainerImpl extends IntermediateOperationNodeImpl implements IntermediateContainer {
    /**
     * The default value of the '{@link #getQualifiedDeploymentTechnologyName() <em>Qualified Deployment Technology Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQualifiedDeploymentTechnologyName()
     * @generated
     * @ordered
     */
    protected static final String QUALIFIED_DEPLOYMENT_TECHNOLOGY_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getQualifiedDeploymentTechnologyName() <em>Qualified Deployment Technology Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQualifiedDeploymentTechnologyName()
     * @generated
     * @ordered
     */
    protected String qualifiedDeploymentTechnologyName = QUALIFIED_DEPLOYMENT_TECHNOLOGY_NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getTechnologyReference() <em>Technology Reference</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTechnologyReference()
     * @generated
     * @ordered
     */
    protected IntermediateDeploymentTechnologyReference technologyReference;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediateContainerImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_CONTAINER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getQualifiedDeploymentTechnologyName() {
        return qualifiedDeploymentTechnologyName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setQualifiedDeploymentTechnologyName(String newQualifiedDeploymentTechnologyName) {
        String oldQualifiedDeploymentTechnologyName = qualifiedDeploymentTechnologyName;
        qualifiedDeploymentTechnologyName = newQualifiedDeploymentTechnologyName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_CONTAINER__QUALIFIED_DEPLOYMENT_TECHNOLOGY_NAME, oldQualifiedDeploymentTechnologyName, qualifiedDeploymentTechnologyName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateDeploymentTechnologyReference getTechnologyReference() {
        return technologyReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTechnologyReference(IntermediateDeploymentTechnologyReference newTechnologyReference, NotificationChain msgs) {
        IntermediateDeploymentTechnologyReference oldTechnologyReference = technologyReference;
        technologyReference = newTechnologyReference;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_CONTAINER__TECHNOLOGY_REFERENCE, oldTechnologyReference, newTechnologyReference);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTechnologyReference(IntermediateDeploymentTechnologyReference newTechnologyReference) {
        if (newTechnologyReference != technologyReference) {
            NotificationChain msgs = null;
            if (technologyReference != null)
                msgs = ((InternalEObject)technologyReference).eInverseRemove(this, IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER, IntermediateDeploymentTechnologyReference.class, msgs);
            if (newTechnologyReference != null)
                msgs = ((InternalEObject)newTechnologyReference).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER, IntermediateDeploymentTechnologyReference.class, msgs);
            msgs = basicSetTechnologyReference(newTechnologyReference, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_CONTAINER__TECHNOLOGY_REFERENCE, newTechnologyReference, newTechnologyReference));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateOperationModel getOperationModel() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_CONTAINER__OPERATION_MODEL) return null;
        return (IntermediateOperationModel)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateOperationModel basicGetOperationModel() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_CONTAINER__OPERATION_MODEL) return null;
        return (IntermediateOperationModel)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOperationModel(IntermediateOperationModel newOperationModel, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOperationModel, IntermediatePackage.INTERMEDIATE_CONTAINER__OPERATION_MODEL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setOperationModel(IntermediateOperationModel newOperationModel) {
        if (newOperationModel != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_CONTAINER__OPERATION_MODEL && newOperationModel != null)) {
            if (EcoreUtil.isAncestor(this, newOperationModel))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOperationModel != null)
                msgs = ((InternalEObject)newOperationModel).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__CONTAINERS, IntermediateOperationModel.class, msgs);
            msgs = basicSetOperationModel(newOperationModel, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_CONTAINER__OPERATION_MODEL, newOperationModel, newOperationModel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case IntermediatePackage.INTERMEDIATE_CONTAINER__TECHNOLOGY_REFERENCE:
                if (technologyReference != null)
                    msgs = ((InternalEObject)technologyReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_CONTAINER__TECHNOLOGY_REFERENCE, null, msgs);
                return basicSetTechnologyReference((IntermediateDeploymentTechnologyReference)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_CONTAINER__OPERATION_MODEL:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOperationModel((IntermediateOperationModel)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_CONTAINER__TECHNOLOGY_REFERENCE:
                return basicSetTechnologyReference(null, msgs);
            case IntermediatePackage.INTERMEDIATE_CONTAINER__OPERATION_MODEL:
                return basicSetOperationModel(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case IntermediatePackage.INTERMEDIATE_CONTAINER__OPERATION_MODEL:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_OPERATION_MODEL__CONTAINERS, IntermediateOperationModel.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case IntermediatePackage.INTERMEDIATE_CONTAINER__QUALIFIED_DEPLOYMENT_TECHNOLOGY_NAME:
                return getQualifiedDeploymentTechnologyName();
            case IntermediatePackage.INTERMEDIATE_CONTAINER__TECHNOLOGY_REFERENCE:
                return getTechnologyReference();
            case IntermediatePackage.INTERMEDIATE_CONTAINER__OPERATION_MODEL:
                if (resolve) return getOperationModel();
                return basicGetOperationModel();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case IntermediatePackage.INTERMEDIATE_CONTAINER__QUALIFIED_DEPLOYMENT_TECHNOLOGY_NAME:
                setQualifiedDeploymentTechnologyName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_CONTAINER__TECHNOLOGY_REFERENCE:
                setTechnologyReference((IntermediateDeploymentTechnologyReference)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_CONTAINER__OPERATION_MODEL:
                setOperationModel((IntermediateOperationModel)newValue);
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
            case IntermediatePackage.INTERMEDIATE_CONTAINER__QUALIFIED_DEPLOYMENT_TECHNOLOGY_NAME:
                setQualifiedDeploymentTechnologyName(QUALIFIED_DEPLOYMENT_TECHNOLOGY_NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_CONTAINER__TECHNOLOGY_REFERENCE:
                setTechnologyReference((IntermediateDeploymentTechnologyReference)null);
                return;
            case IntermediatePackage.INTERMEDIATE_CONTAINER__OPERATION_MODEL:
                setOperationModel((IntermediateOperationModel)null);
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
            case IntermediatePackage.INTERMEDIATE_CONTAINER__QUALIFIED_DEPLOYMENT_TECHNOLOGY_NAME:
                return QUALIFIED_DEPLOYMENT_TECHNOLOGY_NAME_EDEFAULT == null ? qualifiedDeploymentTechnologyName != null : !QUALIFIED_DEPLOYMENT_TECHNOLOGY_NAME_EDEFAULT.equals(qualifiedDeploymentTechnologyName);
            case IntermediatePackage.INTERMEDIATE_CONTAINER__TECHNOLOGY_REFERENCE:
                return technologyReference != null;
            case IntermediatePackage.INTERMEDIATE_CONTAINER__OPERATION_MODEL:
                return basicGetOperationModel() != null;
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
        result.append(" (qualifiedDeploymentTechnologyName: ");
        result.append(qualifiedDeploymentTechnologyName);
        result.append(')');
        return result.toString();
    }

} //IntermediateContainerImpl
