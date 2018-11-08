/**
 */
package de.fhdo.ddmm.data.impl;

import de.fhdo.ddmm.data.ComplexType;
import de.fhdo.ddmm.data.Context;
import de.fhdo.ddmm.data.DataModel;
import de.fhdo.ddmm.data.DataPackage;
import de.fhdo.ddmm.data.Version;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.data.impl.ContextImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.ContextImpl#getComplexTypes <em>Complex Types</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.ContextImpl#getDataModel <em>Data Model</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.ContextImpl#getVersion <em>Version</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContextImpl extends MinimalEObjectImpl.Container implements Context {
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
    protected EList<ComplexType> complexTypes;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ContextImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DataPackage.Literals.CONTEXT;
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
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CONTEXT__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ComplexType> getComplexTypes() {
        if (complexTypes == null) {
            complexTypes = new EObjectContainmentWithInverseEList<ComplexType>(ComplexType.class, this, DataPackage.CONTEXT__COMPLEX_TYPES, DataPackage.COMPLEX_TYPE__CONTEXT);
        }
        return complexTypes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataModel getDataModel() {
        if (eContainerFeatureID() != DataPackage.CONTEXT__DATA_MODEL) return null;
        return (DataModel)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataModel basicGetDataModel() {
        if (eContainerFeatureID() != DataPackage.CONTEXT__DATA_MODEL) return null;
        return (DataModel)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDataModel(DataModel newDataModel, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDataModel, DataPackage.CONTEXT__DATA_MODEL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataModel(DataModel newDataModel) {
        if (newDataModel != eInternalContainer() || (eContainerFeatureID() != DataPackage.CONTEXT__DATA_MODEL && newDataModel != null)) {
            if (EcoreUtil.isAncestor(this, newDataModel))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDataModel != null)
                msgs = ((InternalEObject)newDataModel).eInverseAdd(this, DataPackage.DATA_MODEL__CONTEXTS, DataModel.class, msgs);
            msgs = basicSetDataModel(newDataModel, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CONTEXT__DATA_MODEL, newDataModel, newDataModel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Version getVersion() {
        if (eContainerFeatureID() != DataPackage.CONTEXT__VERSION) return null;
        return (Version)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Version basicGetVersion() {
        if (eContainerFeatureID() != DataPackage.CONTEXT__VERSION) return null;
        return (Version)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetVersion(Version newVersion, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newVersion, DataPackage.CONTEXT__VERSION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVersion(Version newVersion) {
        if (newVersion != eInternalContainer() || (eContainerFeatureID() != DataPackage.CONTEXT__VERSION && newVersion != null)) {
            if (EcoreUtil.isAncestor(this, newVersion))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newVersion != null)
                msgs = ((InternalEObject)newVersion).eInverseAdd(this, DataPackage.VERSION__CONTEXTS, Version.class, msgs);
            msgs = basicSetVersion(newVersion, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CONTEXT__VERSION, newVersion, newVersion));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getQualifiedNameParts() {
        EList<String> _xblockexpression = null;
        {
            if (((this.getName() == null) || this.getName().isEmpty())) {
                return ECollections.<String>asEList(CollectionLiterals.<String>newArrayList());
            }
            final ArrayList<String> nameParts = CollectionLiterals.<String>newArrayList();
            Version _version = this.getVersion();
            boolean _tripleNotEquals = (_version != null);
            if (_tripleNotEquals) {
                nameParts.addAll(this.getVersion().getQualifiedNameParts());
            }
            nameParts.add(this.getName());
            _xblockexpression = ECollections.<String>asEList(nameParts);
        }
        return _xblockexpression;
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
            case DataPackage.CONTEXT__COMPLEX_TYPES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getComplexTypes()).basicAdd(otherEnd, msgs);
            case DataPackage.CONTEXT__DATA_MODEL:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDataModel((DataModel)otherEnd, msgs);
            case DataPackage.CONTEXT__VERSION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetVersion((Version)otherEnd, msgs);
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
            case DataPackage.CONTEXT__COMPLEX_TYPES:
                return ((InternalEList<?>)getComplexTypes()).basicRemove(otherEnd, msgs);
            case DataPackage.CONTEXT__DATA_MODEL:
                return basicSetDataModel(null, msgs);
            case DataPackage.CONTEXT__VERSION:
                return basicSetVersion(null, msgs);
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
            case DataPackage.CONTEXT__DATA_MODEL:
                return eInternalContainer().eInverseRemove(this, DataPackage.DATA_MODEL__CONTEXTS, DataModel.class, msgs);
            case DataPackage.CONTEXT__VERSION:
                return eInternalContainer().eInverseRemove(this, DataPackage.VERSION__CONTEXTS, Version.class, msgs);
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
            case DataPackage.CONTEXT__NAME:
                return getName();
            case DataPackage.CONTEXT__COMPLEX_TYPES:
                return getComplexTypes();
            case DataPackage.CONTEXT__DATA_MODEL:
                if (resolve) return getDataModel();
                return basicGetDataModel();
            case DataPackage.CONTEXT__VERSION:
                if (resolve) return getVersion();
                return basicGetVersion();
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
            case DataPackage.CONTEXT__NAME:
                setName((String)newValue);
                return;
            case DataPackage.CONTEXT__COMPLEX_TYPES:
                getComplexTypes().clear();
                getComplexTypes().addAll((Collection<? extends ComplexType>)newValue);
                return;
            case DataPackage.CONTEXT__DATA_MODEL:
                setDataModel((DataModel)newValue);
                return;
            case DataPackage.CONTEXT__VERSION:
                setVersion((Version)newValue);
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
            case DataPackage.CONTEXT__NAME:
                setName(NAME_EDEFAULT);
                return;
            case DataPackage.CONTEXT__COMPLEX_TYPES:
                getComplexTypes().clear();
                return;
            case DataPackage.CONTEXT__DATA_MODEL:
                setDataModel((DataModel)null);
                return;
            case DataPackage.CONTEXT__VERSION:
                setVersion((Version)null);
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
            case DataPackage.CONTEXT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case DataPackage.CONTEXT__COMPLEX_TYPES:
                return complexTypes != null && !complexTypes.isEmpty();
            case DataPackage.CONTEXT__DATA_MODEL:
                return basicGetDataModel() != null;
            case DataPackage.CONTEXT__VERSION:
                return basicGetVersion() != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
        switch (operationID) {
            case DataPackage.CONTEXT___GET_QUALIFIED_NAME_PARTS:
                return getQualifiedNameParts();
        }
        return super.eInvoke(operationID, arguments);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //ContextImpl
