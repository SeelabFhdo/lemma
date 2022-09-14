/**
 */
package de.fhdo.lemma.data.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateComplexType;
import de.fhdo.lemma.data.intermediate.IntermediateContext;
import de.fhdo.lemma.data.intermediate.IntermediateDataModel;
import de.fhdo.lemma.data.intermediate.IntermediatePackage;
import de.fhdo.lemma.data.intermediate.IntermediateVersion;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Version</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateVersionImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateVersionImpl#getComplexTypes <em>Complex Types</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateVersionImpl#getContexts <em>Contexts</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateVersionImpl#getDataModel <em>Data Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateVersionImpl extends MinimalEObjectImpl.Container implements IntermediateVersion {
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
     * The cached value of the '{@link #getComplexTypes() <em>Complex Types</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getComplexTypes()
     * @generated
     * @ordered
     */
    protected EList<IntermediateComplexType> complexTypes;

    /**
     * The cached value of the '{@link #getContexts() <em>Contexts</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContexts()
     * @generated
     * @ordered
     */
    protected EList<IntermediateContext> contexts;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediateVersionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_VERSION;
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_VERSION__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateComplexType> getComplexTypes() {
        if (complexTypes == null) {
            complexTypes = new EObjectContainmentWithInverseEList<IntermediateComplexType>(IntermediateComplexType.class, this, IntermediatePackage.INTERMEDIATE_VERSION__COMPLEX_TYPES, IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__VERSION);
        }
        return complexTypes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateContext> getContexts() {
        if (contexts == null) {
            contexts = new EObjectContainmentWithInverseEList<IntermediateContext>(IntermediateContext.class, this, IntermediatePackage.INTERMEDIATE_VERSION__CONTEXTS, IntermediatePackage.INTERMEDIATE_CONTEXT__VERSION);
        }
        return contexts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataModel getDataModel() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_VERSION__DATA_MODEL) return null;
        return (IntermediateDataModel)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataModel basicGetDataModel() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_VERSION__DATA_MODEL) return null;
        return (IntermediateDataModel)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDataModel(IntermediateDataModel newDataModel, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDataModel, IntermediatePackage.INTERMEDIATE_VERSION__DATA_MODEL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataModel(IntermediateDataModel newDataModel) {
        if (newDataModel != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_VERSION__DATA_MODEL && newDataModel != null)) {
            if (EcoreUtil.isAncestor(this, newDataModel))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDataModel != null)
                msgs = ((InternalEObject)newDataModel).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_DATA_MODEL__VERSIONS, IntermediateDataModel.class, msgs);
            msgs = basicSetDataModel(newDataModel, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_VERSION__DATA_MODEL, newDataModel, newDataModel));
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
            case IntermediatePackage.INTERMEDIATE_VERSION__COMPLEX_TYPES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getComplexTypes()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_VERSION__CONTEXTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getContexts()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_VERSION__DATA_MODEL:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDataModel((IntermediateDataModel)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_VERSION__COMPLEX_TYPES:
                return ((InternalEList<?>)getComplexTypes()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_VERSION__CONTEXTS:
                return ((InternalEList<?>)getContexts()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_VERSION__DATA_MODEL:
                return basicSetDataModel(null, msgs);
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
            case IntermediatePackage.INTERMEDIATE_VERSION__DATA_MODEL:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_DATA_MODEL__VERSIONS, IntermediateDataModel.class, msgs);
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
            case IntermediatePackage.INTERMEDIATE_VERSION__NAME:
                return getName();
            case IntermediatePackage.INTERMEDIATE_VERSION__COMPLEX_TYPES:
                return getComplexTypes();
            case IntermediatePackage.INTERMEDIATE_VERSION__CONTEXTS:
                return getContexts();
            case IntermediatePackage.INTERMEDIATE_VERSION__DATA_MODEL:
                if (resolve) return getDataModel();
                return basicGetDataModel();
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
            case IntermediatePackage.INTERMEDIATE_VERSION__NAME:
                setName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_VERSION__COMPLEX_TYPES:
                getComplexTypes().clear();
                getComplexTypes().addAll((Collection<? extends IntermediateComplexType>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_VERSION__CONTEXTS:
                getContexts().clear();
                getContexts().addAll((Collection<? extends IntermediateContext>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_VERSION__DATA_MODEL:
                setDataModel((IntermediateDataModel)newValue);
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
            case IntermediatePackage.INTERMEDIATE_VERSION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_VERSION__COMPLEX_TYPES:
                getComplexTypes().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_VERSION__CONTEXTS:
                getContexts().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_VERSION__DATA_MODEL:
                setDataModel((IntermediateDataModel)null);
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
            case IntermediatePackage.INTERMEDIATE_VERSION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case IntermediatePackage.INTERMEDIATE_VERSION__COMPLEX_TYPES:
                return complexTypes != null && !complexTypes.isEmpty();
            case IntermediatePackage.INTERMEDIATE_VERSION__CONTEXTS:
                return contexts != null && !contexts.isEmpty();
            case IntermediatePackage.INTERMEDIATE_VERSION__DATA_MODEL:
                return basicGetDataModel() != null;
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

} //IntermediateVersionImpl
