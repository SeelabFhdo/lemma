/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnology;
import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureTechnologyReference;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infrastructure Technology</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateInfrastructureTechnologyImpl#getReference <em>Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateInfrastructureTechnologyImpl extends IntermediateOperationTechnologyImpl implements IntermediateInfrastructureTechnology {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediateInfrastructureTechnologyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateInfrastructureTechnologyReference getReference() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY__REFERENCE) return null;
        return (IntermediateInfrastructureTechnologyReference)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateInfrastructureTechnologyReference basicGetReference() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY__REFERENCE) return null;
        return (IntermediateInfrastructureTechnologyReference)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetReference(IntermediateInfrastructureTechnologyReference newReference, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newReference, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY__REFERENCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setReference(IntermediateInfrastructureTechnologyReference newReference) {
        if (newReference != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY__REFERENCE && newReference != null)) {
            if (EcoreUtil.isAncestor(this, newReference))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newReference != null)
                msgs = ((InternalEObject)newReference).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__TECHNOLOGY, IntermediateInfrastructureTechnologyReference.class, msgs);
            msgs = basicSetReference(newReference, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY__REFERENCE, newReference, newReference));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY__REFERENCE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetReference((IntermediateInfrastructureTechnologyReference)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY__REFERENCE:
                return basicSetReference(null, msgs);
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
            case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY__REFERENCE:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY_REFERENCE__TECHNOLOGY, IntermediateInfrastructureTechnologyReference.class, msgs);
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
            case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY__REFERENCE:
                if (resolve) return getReference();
                return basicGetReference();
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
            case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY__REFERENCE:
                setReference((IntermediateInfrastructureTechnologyReference)newValue);
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
            case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY__REFERENCE:
                setReference((IntermediateInfrastructureTechnologyReference)null);
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
            case IntermediatePackage.INTERMEDIATE_INFRASTRUCTURE_TECHNOLOGY__REFERENCE:
                return basicGetReference() != null;
        }
        return super.eIsSet(featureID);
    }

} //IntermediateInfrastructureTechnologyImpl
