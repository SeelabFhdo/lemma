/**
 */
package de.fhdo.lemma.technology.impl;

import de.fhdo.lemma.technology.CompatibilityDirection;
import de.fhdo.lemma.technology.CompatibilityMatrixEntry;
import de.fhdo.lemma.technology.PossiblyImportedTechnologySpecificType;
import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.technology.TechnologyPackage;

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
 * An implementation of the model object '<em><b>Compatibility Matrix Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.impl.CompatibilityMatrixEntryImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.CompatibilityMatrixEntryImpl#getMappingType <em>Mapping Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.CompatibilityMatrixEntryImpl#getCompatibleTypes <em>Compatible Types</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.CompatibilityMatrixEntryImpl#getTechnology <em>Technology</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompatibilityMatrixEntryImpl extends MinimalEObjectImpl.Container implements CompatibilityMatrixEntry {
    /**
     * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDirection()
     * @generated
     * @ordered
     */
    protected static final CompatibilityDirection DIRECTION_EDEFAULT = CompatibilityDirection.MAPPING_TO_COMPATIBLE_TYPES;

    /**
     * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDirection()
     * @generated
     * @ordered
     */
    protected CompatibilityDirection direction = DIRECTION_EDEFAULT;

    /**
     * The cached value of the '{@link #getMappingType() <em>Mapping Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMappingType()
     * @generated
     * @ordered
     */
    protected PossiblyImportedTechnologySpecificType mappingType;

    /**
     * The cached value of the '{@link #getCompatibleTypes() <em>Compatible Types</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCompatibleTypes()
     * @generated
     * @ordered
     */
    protected EList<PossiblyImportedTechnologySpecificType> compatibleTypes;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CompatibilityMatrixEntryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TechnologyPackage.Literals.COMPATIBILITY_MATRIX_ENTRY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CompatibilityDirection getDirection() {
        return direction;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDirection(CompatibilityDirection newDirection) {
        CompatibilityDirection oldDirection = direction;
        direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__DIRECTION, oldDirection, direction));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PossiblyImportedTechnologySpecificType getMappingType() {
        return mappingType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMappingType(PossiblyImportedTechnologySpecificType newMappingType, NotificationChain msgs) {
        PossiblyImportedTechnologySpecificType oldMappingType = mappingType;
        mappingType = newMappingType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__MAPPING_TYPE, oldMappingType, newMappingType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMappingType(PossiblyImportedTechnologySpecificType newMappingType) {
        if (newMappingType != mappingType) {
            NotificationChain msgs = null;
            if (mappingType != null)
                msgs = ((InternalEObject)mappingType).eInverseRemove(this, TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__MAPPING_ENTRY, PossiblyImportedTechnologySpecificType.class, msgs);
            if (newMappingType != null)
                msgs = ((InternalEObject)newMappingType).eInverseAdd(this, TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__MAPPING_ENTRY, PossiblyImportedTechnologySpecificType.class, msgs);
            msgs = basicSetMappingType(newMappingType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__MAPPING_TYPE, newMappingType, newMappingType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PossiblyImportedTechnologySpecificType> getCompatibleTypes() {
        if (compatibleTypes == null) {
            compatibleTypes = new EObjectContainmentWithInverseEList<PossiblyImportedTechnologySpecificType>(PossiblyImportedTechnologySpecificType.class, this, TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__COMPATIBLE_TYPES, TechnologyPackage.POSSIBLY_IMPORTED_TECHNOLOGY_SPECIFIC_TYPE__COMPATIBLE_ENTRY);
        }
        return compatibleTypes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Technology getTechnology() {
        if (eContainerFeatureID() != TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__TECHNOLOGY) return null;
        return (Technology)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Technology basicGetTechnology() {
        if (eContainerFeatureID() != TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__TECHNOLOGY) return null;
        return (Technology)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTechnology(Technology newTechnology, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newTechnology, TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__TECHNOLOGY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTechnology(Technology newTechnology) {
        if (newTechnology != eInternalContainer() || (eContainerFeatureID() != TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__TECHNOLOGY && newTechnology != null)) {
            if (EcoreUtil.isAncestor(this, newTechnology))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newTechnology != null)
                msgs = ((InternalEObject)newTechnology).eInverseAdd(this, TechnologyPackage.TECHNOLOGY__COMPATIBILITY_ENTRIES, Technology.class, msgs);
            msgs = basicSetTechnology(newTechnology, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__TECHNOLOGY, newTechnology, newTechnology));
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
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__MAPPING_TYPE:
                if (mappingType != null)
                    msgs = ((InternalEObject)mappingType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__MAPPING_TYPE, null, msgs);
                return basicSetMappingType((PossiblyImportedTechnologySpecificType)otherEnd, msgs);
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__COMPATIBLE_TYPES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getCompatibleTypes()).basicAdd(otherEnd, msgs);
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__TECHNOLOGY:
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
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__MAPPING_TYPE:
                return basicSetMappingType(null, msgs);
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__COMPATIBLE_TYPES:
                return ((InternalEList<?>)getCompatibleTypes()).basicRemove(otherEnd, msgs);
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__TECHNOLOGY:
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
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__TECHNOLOGY:
                return eInternalContainer().eInverseRemove(this, TechnologyPackage.TECHNOLOGY__COMPATIBILITY_ENTRIES, Technology.class, msgs);
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
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__DIRECTION:
                return getDirection();
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__MAPPING_TYPE:
                return getMappingType();
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__COMPATIBLE_TYPES:
                return getCompatibleTypes();
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__TECHNOLOGY:
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
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__DIRECTION:
                setDirection((CompatibilityDirection)newValue);
                return;
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__MAPPING_TYPE:
                setMappingType((PossiblyImportedTechnologySpecificType)newValue);
                return;
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__COMPATIBLE_TYPES:
                getCompatibleTypes().clear();
                getCompatibleTypes().addAll((Collection<? extends PossiblyImportedTechnologySpecificType>)newValue);
                return;
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__TECHNOLOGY:
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
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__DIRECTION:
                setDirection(DIRECTION_EDEFAULT);
                return;
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__MAPPING_TYPE:
                setMappingType((PossiblyImportedTechnologySpecificType)null);
                return;
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__COMPATIBLE_TYPES:
                getCompatibleTypes().clear();
                return;
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__TECHNOLOGY:
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
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__DIRECTION:
                return direction != DIRECTION_EDEFAULT;
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__MAPPING_TYPE:
                return mappingType != null;
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__COMPATIBLE_TYPES:
                return compatibleTypes != null && !compatibleTypes.isEmpty();
            case TechnologyPackage.COMPATIBILITY_MATRIX_ENTRY__TECHNOLOGY:
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
        result.append(" (direction: ");
        result.append(direction);
        result.append(')');
        return result.toString();
    }

} //CompatibilityMatrixEntryImpl
