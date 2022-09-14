/**
 */
package de.fhdo.lemma.technology.impl;

import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.technology.TechnologyImport;
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
 * An implementation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologyImportImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologyImportImpl#getImportURI <em>Import URI</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologyImportImpl#getTechnology <em>Technology</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TechnologyImportImpl extends MinimalEObjectImpl.Container implements TechnologyImport {
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
     * The default value of the '{@link #getImportURI() <em>Import URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImportURI()
     * @generated
     * @ordered
     */
    protected static final String IMPORT_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getImportURI() <em>Import URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImportURI()
     * @generated
     * @ordered
     */
    protected String importURI = IMPORT_URI_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TechnologyImportImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TechnologyPackage.Literals.TECHNOLOGY_IMPORT;
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
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.TECHNOLOGY_IMPORT__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getImportURI() {
        return importURI;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setImportURI(String newImportURI) {
        String oldImportURI = importURI;
        importURI = newImportURI;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.TECHNOLOGY_IMPORT__IMPORT_URI, oldImportURI, importURI));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Technology getTechnology() {
        if (eContainerFeatureID() != TechnologyPackage.TECHNOLOGY_IMPORT__TECHNOLOGY) return null;
        return (Technology)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Technology basicGetTechnology() {
        if (eContainerFeatureID() != TechnologyPackage.TECHNOLOGY_IMPORT__TECHNOLOGY) return null;
        return (Technology)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTechnology(Technology newTechnology, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newTechnology, TechnologyPackage.TECHNOLOGY_IMPORT__TECHNOLOGY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTechnology(Technology newTechnology) {
        if (newTechnology != eInternalContainer() || (eContainerFeatureID() != TechnologyPackage.TECHNOLOGY_IMPORT__TECHNOLOGY && newTechnology != null)) {
            if (EcoreUtil.isAncestor(this, newTechnology))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newTechnology != null)
                msgs = ((InternalEObject)newTechnology).eInverseAdd(this, TechnologyPackage.TECHNOLOGY__IMPORTS, Technology.class, msgs);
            msgs = basicSetTechnology(newTechnology, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.TECHNOLOGY_IMPORT__TECHNOLOGY, newTechnology, newTechnology));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TechnologyPackage.TECHNOLOGY_IMPORT__TECHNOLOGY:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetTechnology((Technology)otherEnd, msgs);
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
            case TechnologyPackage.TECHNOLOGY_IMPORT__TECHNOLOGY:
                return basicSetTechnology(null, msgs);
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
            case TechnologyPackage.TECHNOLOGY_IMPORT__TECHNOLOGY:
                return eInternalContainer().eInverseRemove(this, TechnologyPackage.TECHNOLOGY__IMPORTS, Technology.class, msgs);
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
            case TechnologyPackage.TECHNOLOGY_IMPORT__NAME:
                return getName();
            case TechnologyPackage.TECHNOLOGY_IMPORT__IMPORT_URI:
                return getImportURI();
            case TechnologyPackage.TECHNOLOGY_IMPORT__TECHNOLOGY:
                if (resolve) return getTechnology();
                return basicGetTechnology();
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
            case TechnologyPackage.TECHNOLOGY_IMPORT__NAME:
                setName((String)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY_IMPORT__IMPORT_URI:
                setImportURI((String)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY_IMPORT__TECHNOLOGY:
                setTechnology((Technology)newValue);
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
            case TechnologyPackage.TECHNOLOGY_IMPORT__NAME:
                setName(NAME_EDEFAULT);
                return;
            case TechnologyPackage.TECHNOLOGY_IMPORT__IMPORT_URI:
                setImportURI(IMPORT_URI_EDEFAULT);
                return;
            case TechnologyPackage.TECHNOLOGY_IMPORT__TECHNOLOGY:
                setTechnology((Technology)null);
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
            case TechnologyPackage.TECHNOLOGY_IMPORT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case TechnologyPackage.TECHNOLOGY_IMPORT__IMPORT_URI:
                return IMPORT_URI_EDEFAULT == null ? importURI != null : !IMPORT_URI_EDEFAULT.equals(importURI);
            case TechnologyPackage.TECHNOLOGY_IMPORT__TECHNOLOGY:
                return basicGetTechnology() != null;
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
        result.append(", importURI: ");
        result.append(importURI);
        result.append(')');
        return result.toString();
    }

} //TechnologyImportImpl
