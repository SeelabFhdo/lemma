/**
 */
package de.fhdo.lemma.technology.impl;

import de.fhdo.lemma.technology.DataFormat;
import de.fhdo.lemma.technology.Protocol;
import de.fhdo.lemma.technology.TechnologyPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Format</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.impl.DataFormatImpl#getFormatName <em>Format Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.DataFormatImpl#getProtocol <em>Protocol</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataFormatImpl extends MinimalEObjectImpl.Container implements DataFormat {
    /**
     * The default value of the '{@link #getFormatName() <em>Format Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFormatName()
     * @generated
     * @ordered
     */
    protected static final String FORMAT_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFormatName() <em>Format Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFormatName()
     * @generated
     * @ordered
     */
    protected String formatName = FORMAT_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DataFormatImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TechnologyPackage.Literals.DATA_FORMAT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFormatName() {
        return formatName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFormatName(String newFormatName) {
        String oldFormatName = formatName;
        formatName = newFormatName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.DATA_FORMAT__FORMAT_NAME, oldFormatName, formatName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Protocol getProtocol() {
        if (eContainerFeatureID() != TechnologyPackage.DATA_FORMAT__PROTOCOL) return null;
        return (Protocol)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Protocol basicGetProtocol() {
        if (eContainerFeatureID() != TechnologyPackage.DATA_FORMAT__PROTOCOL) return null;
        return (Protocol)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetProtocol(Protocol newProtocol, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newProtocol, TechnologyPackage.DATA_FORMAT__PROTOCOL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProtocol(Protocol newProtocol) {
        if (newProtocol != eInternalContainer() || (eContainerFeatureID() != TechnologyPackage.DATA_FORMAT__PROTOCOL && newProtocol != null)) {
            if (EcoreUtil.isAncestor(this, newProtocol))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newProtocol != null)
                msgs = ((InternalEObject)newProtocol).eInverseAdd(this, TechnologyPackage.PROTOCOL__DATA_FORMATS, Protocol.class, msgs);
            msgs = basicSetProtocol(newProtocol, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.DATA_FORMAT__PROTOCOL, newProtocol, newProtocol));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TechnologyPackage.DATA_FORMAT__PROTOCOL:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetProtocol((Protocol)otherEnd, msgs);
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
            case TechnologyPackage.DATA_FORMAT__PROTOCOL:
                return basicSetProtocol(null, msgs);
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
            case TechnologyPackage.DATA_FORMAT__PROTOCOL:
                return eInternalContainer().eInverseRemove(this, TechnologyPackage.PROTOCOL__DATA_FORMATS, Protocol.class, msgs);
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
            case TechnologyPackage.DATA_FORMAT__FORMAT_NAME:
                return getFormatName();
            case TechnologyPackage.DATA_FORMAT__PROTOCOL:
                if (resolve) return getProtocol();
                return basicGetProtocol();
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
            case TechnologyPackage.DATA_FORMAT__FORMAT_NAME:
                setFormatName((String)newValue);
                return;
            case TechnologyPackage.DATA_FORMAT__PROTOCOL:
                setProtocol((Protocol)newValue);
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
            case TechnologyPackage.DATA_FORMAT__FORMAT_NAME:
                setFormatName(FORMAT_NAME_EDEFAULT);
                return;
            case TechnologyPackage.DATA_FORMAT__PROTOCOL:
                setProtocol((Protocol)null);
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
            case TechnologyPackage.DATA_FORMAT__FORMAT_NAME:
                return FORMAT_NAME_EDEFAULT == null ? formatName != null : !FORMAT_NAME_EDEFAULT.equals(formatName);
            case TechnologyPackage.DATA_FORMAT__PROTOCOL:
                return basicGetProtocol() != null;
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
        result.append(" (formatName: ");
        result.append(formatName);
        result.append(')');
        return result.toString();
    }

} //DataFormatImpl
