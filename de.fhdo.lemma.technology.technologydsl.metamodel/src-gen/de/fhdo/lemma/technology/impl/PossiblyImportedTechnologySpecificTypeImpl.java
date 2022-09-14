/**
 */
package de.fhdo.lemma.technology.impl;

import de.fhdo.lemma.data.Type;

import de.fhdo.lemma.technology.CompatibilityMatrixEntry;
import de.fhdo.lemma.technology.PossiblyImportedTechnologySpecificType;
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
 * An implementation of the model object '<em><b>Possibly Imported Technology Specific Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.impl.PossiblyImportedTechnologySpecificTypeImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.PossiblyImportedTechnologySpecificTypeImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.PossiblyImportedTechnologySpecificTypeImpl#getMappingEntry <em>Mapping Entry</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.PossiblyImportedTechnologySpecificTypeImpl#getCompatibleEntry <em>Compatible Entry</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PossiblyImportedTechnologySpecificTypeImpl extends MinimalEObjectImpl.Container implements PossiblyImportedTechnologySpecificType {
    /**
     * The cached value of the '{@link #getImport() <em>Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImport()
     * @generated
     * @ordered
     */
    protected TechnologyImport import_;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected Type type;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PossiblyImportedTechnologySpecificTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TechnologyPackage.Literals.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologyImport getImport() {
        if (import_ != null && import_.eIsProxy()) {
            InternalEObject oldImport = (InternalEObject)import_;
            import_ = (TechnologyImport)eResolveProxy(oldImport);
            if (import_ != oldImport) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__IMPORT, oldImport, import_));
            }
        }
        return import_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologyImport basicGetImport() {
        return import_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setImport(TechnologyImport newImport) {
        TechnologyImport oldImport = import_;
        import_ = newImport;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__IMPORT, oldImport, import_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Type getType() {
        if (type != null && type.eIsProxy()) {
            InternalEObject oldType = (InternalEObject)type;
            type = (Type)eResolveProxy(oldType);
            if (type != oldType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__TYPE, oldType, type));
            }
        }
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Type basicGetType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(Type newType) {
        Type oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CompatibilityMatrixEntry getMappingEntry() {
        if (eContainerFeatureID() != TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__MAPPING_ENTRY) return null;
        return (CompatibilityMatrixEntry)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CompatibilityMatrixEntry basicGetMappingEntry() {
        if (eContainerFeatureID() != TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__MAPPING_ENTRY) return null;
        return (CompatibilityMatrixEntry)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMappingEntry(CompatibilityMatrixEntry newMappingEntry, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newMappingEntry, TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__MAPPING_ENTRY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMappingEntry(CompatibilityMatrixEntry newMappingEntry) {
        if (newMappingEntry != eInternalContainer() || (eContainerFeatureID() != TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__MAPPING_ENTRY && newMappingEntry != null)) {
            if (EcoreUtil.isAncestor(this, newMappingEntry))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newMappingEntry != null)
                msgs = ((InternalEObject)newMappingEntry).eInverseAdd(this, TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__MAPPING_TYPE, CompatibilityMatrixEntry.class, msgs);
            msgs = basicSetMappingEntry(newMappingEntry, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__MAPPING_ENTRY, newMappingEntry, newMappingEntry));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CompatibilityMatrixEntry getCompatibleEntry() {
        if (eContainerFeatureID() != TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__COMPATIBLE_ENTRY) return null;
        return (CompatibilityMatrixEntry)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CompatibilityMatrixEntry basicGetCompatibleEntry() {
        if (eContainerFeatureID() != TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__COMPATIBLE_ENTRY) return null;
        return (CompatibilityMatrixEntry)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCompatibleEntry(CompatibilityMatrixEntry newCompatibleEntry, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newCompatibleEntry, TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__COMPATIBLE_ENTRY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCompatibleEntry(CompatibilityMatrixEntry newCompatibleEntry) {
        if (newCompatibleEntry != eInternalContainer() || (eContainerFeatureID() != TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__COMPATIBLE_ENTRY && newCompatibleEntry != null)) {
            if (EcoreUtil.isAncestor(this, newCompatibleEntry))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newCompatibleEntry != null)
                msgs = ((InternalEObject)newCompatibleEntry).eInverseAdd(this, TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__COMPATIBLE_TYPES, CompatibilityMatrixEntry.class, msgs);
            msgs = basicSetCompatibleEntry(newCompatibleEntry, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__COMPATIBLE_ENTRY, newCompatibleEntry, newCompatibleEntry));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__MAPPING_ENTRY:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetMappingEntry((CompatibilityMatrixEntry)otherEnd, msgs);
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__COMPATIBLE_ENTRY:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetCompatibleEntry((CompatibilityMatrixEntry)otherEnd, msgs);
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
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__MAPPING_ENTRY:
                return basicSetMappingEntry(null, msgs);
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__COMPATIBLE_ENTRY:
                return basicSetCompatibleEntry(null, msgs);
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
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__MAPPING_ENTRY:
                return eInternalContainer().eInverseRemove(this, TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__MAPPING_TYPE, CompatibilityMatrixEntry.class, msgs);
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__COMPATIBLE_ENTRY:
                return eInternalContainer().eInverseRemove(this, TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__COMPATIBLE_TYPES, CompatibilityMatrixEntry.class, msgs);
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
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__IMPORT:
                if (resolve) return getImport();
                return basicGetImport();
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__TYPE:
                if (resolve) return getType();
                return basicGetType();
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__MAPPING_ENTRY:
                if (resolve) return getMappingEntry();
                return basicGetMappingEntry();
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__COMPATIBLE_ENTRY:
                if (resolve) return getCompatibleEntry();
                return basicGetCompatibleEntry();
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
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__IMPORT:
                setImport((TechnologyImport)newValue);
                return;
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__TYPE:
                setType((Type)newValue);
                return;
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__MAPPING_ENTRY:
                setMappingEntry((CompatibilityMatrixEntry)newValue);
                return;
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__COMPATIBLE_ENTRY:
                setCompatibleEntry((CompatibilityMatrixEntry)newValue);
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
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__IMPORT:
                setImport((TechnologyImport)null);
                return;
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__TYPE:
                setType((Type)null);
                return;
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__MAPPING_ENTRY:
                setMappingEntry((CompatibilityMatrixEntry)null);
                return;
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__COMPATIBLE_ENTRY:
                setCompatibleEntry((CompatibilityMatrixEntry)null);
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
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__IMPORT:
                return import_ != null;
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__TYPE:
                return type != null;
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__MAPPING_ENTRY:
                return basicGetMappingEntry() != null;
            case TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__COMPATIBLE_ENTRY:
                return basicGetCompatibleEntry() != null;
        }
        return super.eIsSet(featureID);
    }

} //PossiblyImportedTechnologySpecificTypeImpl
