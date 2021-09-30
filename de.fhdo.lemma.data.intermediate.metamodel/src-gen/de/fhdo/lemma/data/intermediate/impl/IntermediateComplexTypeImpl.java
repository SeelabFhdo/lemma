/**
 */
package de.fhdo.lemma.data.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateComplexType;
import de.fhdo.lemma.data.intermediate.IntermediateContext;
import de.fhdo.lemma.data.intermediate.IntermediateDataModel;
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect;
import de.fhdo.lemma.data.intermediate.IntermediatePackage;
import de.fhdo.lemma.data.intermediate.IntermediateVersion;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateComplexTypeImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateComplexTypeImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateComplexTypeImpl#getDataModel <em>Data Model</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateComplexTypeImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateComplexTypeImpl#getContext <em>Context</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateComplexTypeImpl extends IntermediateTypeImpl implements IntermediateComplexType {
    /**
     * The default value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQualifiedName()
     * @generated
     * @ordered
     */
    protected static final String QUALIFIED_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQualifiedName()
     * @generated
     * @ordered
     */
    protected String qualifiedName = QUALIFIED_NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getAspects() <em>Aspects</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAspects()
     * @generated
     * @ordered
     */
    protected EList<IntermediateImportedAspect> aspects;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediateComplexTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_COMPLEX_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getQualifiedName() {
        return qualifiedName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setQualifiedName(String newQualifiedName) {
        String oldQualifiedName = qualifiedName;
        qualifiedName = newQualifiedName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateImportedAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<IntermediateImportedAspect>(IntermediateImportedAspect.class, this, IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__ASPECTS, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__COMPLEX_TYPE);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataModel getDataModel() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL) return null;
        return (IntermediateDataModel)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataModel basicGetDataModel() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL) return null;
        return (IntermediateDataModel)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDataModel(IntermediateDataModel newDataModel, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDataModel, IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataModel(IntermediateDataModel newDataModel) {
        if (newDataModel != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL && newDataModel != null)) {
            if (EcoreUtil.isAncestor(this, newDataModel))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDataModel != null)
                msgs = ((InternalEObject)newDataModel).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_DATA_MODEL__COMPLEX_TYPES, IntermediateDataModel.class, msgs);
            msgs = basicSetDataModel(newDataModel, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL, newDataModel, newDataModel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateVersion getVersion() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__VERSION) return null;
        return (IntermediateVersion)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateVersion basicGetVersion() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__VERSION) return null;
        return (IntermediateVersion)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetVersion(IntermediateVersion newVersion, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newVersion, IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__VERSION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVersion(IntermediateVersion newVersion) {
        if (newVersion != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__VERSION && newVersion != null)) {
            if (EcoreUtil.isAncestor(this, newVersion))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newVersion != null)
                msgs = ((InternalEObject)newVersion).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_VERSION__COMPLEX_TYPES, IntermediateVersion.class, msgs);
            msgs = basicSetVersion(newVersion, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__VERSION, newVersion, newVersion));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateContext getContext() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__CONTEXT) return null;
        return (IntermediateContext)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateContext basicGetContext() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__CONTEXT) return null;
        return (IntermediateContext)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetContext(IntermediateContext newContext, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newContext, IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__CONTEXT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContext(IntermediateContext newContext) {
        if (newContext != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__CONTEXT && newContext != null)) {
            if (EcoreUtil.isAncestor(this, newContext))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newContext != null)
                msgs = ((InternalEObject)newContext).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_CONTEXT__COMPLEX_TYPES, IntermediateContext.class, msgs);
            msgs = basicSetContext(newContext, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__CONTEXT, newContext, newContext));
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
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDataModel((IntermediateDataModel)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__VERSION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetVersion((IntermediateVersion)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__CONTEXT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetContext((IntermediateContext)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL:
                return basicSetDataModel(null, msgs);
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__VERSION:
                return basicSetVersion(null, msgs);
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__CONTEXT:
                return basicSetContext(null, msgs);
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
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_DATA_MODEL__COMPLEX_TYPES, IntermediateDataModel.class, msgs);
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__VERSION:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_VERSION__COMPLEX_TYPES, IntermediateVersion.class, msgs);
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__CONTEXT:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_CONTEXT__COMPLEX_TYPES, IntermediateContext.class, msgs);
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
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__QUALIFIED_NAME:
                return getQualifiedName();
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__ASPECTS:
                return getAspects();
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL:
                if (resolve) return getDataModel();
                return basicGetDataModel();
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__VERSION:
                if (resolve) return getVersion();
                return basicGetVersion();
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__CONTEXT:
                if (resolve) return getContext();
                return basicGetContext();
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
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__QUALIFIED_NAME:
                setQualifiedName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends IntermediateImportedAspect>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL:
                setDataModel((IntermediateDataModel)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__VERSION:
                setVersion((IntermediateVersion)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__CONTEXT:
                setContext((IntermediateContext)newValue);
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
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__QUALIFIED_NAME:
                setQualifiedName(QUALIFIED_NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__ASPECTS:
                getAspects().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL:
                setDataModel((IntermediateDataModel)null);
                return;
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__VERSION:
                setVersion((IntermediateVersion)null);
                return;
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__CONTEXT:
                setContext((IntermediateContext)null);
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
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__QUALIFIED_NAME:
                return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL:
                return basicGetDataModel() != null;
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__VERSION:
                return basicGetVersion() != null;
            case IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__CONTEXT:
                return basicGetContext() != null;
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
        result.append(" (qualifiedName: ");
        result.append(qualifiedName);
        result.append(')');
        return result.toString();
    }

} //IntermediateComplexTypeImpl
