/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.operation.intermediate.IntermediateEndpointTechnology;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;

import de.fhdo.lemma.service.intermediate.impl.IntermediateTechnologyImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Endpoint Technology</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateEndpointTechnologyImpl#getEndpoint <em>Endpoint</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateEndpointTechnologyImpl extends IntermediateTechnologyImpl implements IntermediateEndpointTechnology {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediateEndpointTechnologyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_ENDPOINT_TECHNOLOGY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateOperationEndpoint getEndpoint() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT) return null;
        return (IntermediateOperationEndpoint)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateOperationEndpoint basicGetEndpoint() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT) return null;
        return (IntermediateOperationEndpoint)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetEndpoint(IntermediateOperationEndpoint newEndpoint, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newEndpoint, IntermediatePackage.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setEndpoint(IntermediateOperationEndpoint newEndpoint) {
        if (newEndpoint != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT && newEndpoint != null)) {
            if (EcoreUtil.isAncestor(this, newEndpoint))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newEndpoint != null)
                msgs = ((InternalEObject)newEndpoint).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__ENDPOINT_TECHNOLOGY, IntermediateOperationEndpoint.class, msgs);
            msgs = basicSetEndpoint(newEndpoint, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT, newEndpoint, newEndpoint));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case IntermediatePackage.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetEndpoint((IntermediateOperationEndpoint)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT:
                return basicSetEndpoint(null, msgs);
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
            case IntermediatePackage.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__ENDPOINT_TECHNOLOGY, IntermediateOperationEndpoint.class, msgs);
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
            case IntermediatePackage.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT:
                if (resolve) return getEndpoint();
                return basicGetEndpoint();
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
            case IntermediatePackage.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT:
                setEndpoint((IntermediateOperationEndpoint)newValue);
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
            case IntermediatePackage.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT:
                setEndpoint((IntermediateOperationEndpoint)null);
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
            case IntermediatePackage.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT:
                return basicGetEndpoint() != null;
        }
        return super.eIsSet(featureID);
    }

} //IntermediateEndpointTechnologyImpl
