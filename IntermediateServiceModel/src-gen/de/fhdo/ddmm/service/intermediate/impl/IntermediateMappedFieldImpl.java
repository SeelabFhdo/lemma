/**
 */
package de.fhdo.ddmm.service.intermediate.impl;

import de.fhdo.ddmm.data.intermediate.IntermediateType;
import de.fhdo.ddmm.data.intermediate.IntermediateTypeKind;

import de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect;
import de.fhdo.ddmm.service.intermediate.IntermediateMappedField;
import de.fhdo.ddmm.service.intermediate.IntermediatePackage;
import de.fhdo.ddmm.service.intermediate.IntermediateParameter;

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
 * An implementation of the model object '<em><b>Mapped Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateMappedFieldImpl#getMappedFieldName <em>Mapped Field Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateMappedFieldImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateMappedFieldImpl#getOriginalTypeKind <em>Original Type Kind</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateMappedFieldImpl#getMappedType <em>Mapped Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateMappedFieldImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateMappedFieldImpl#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateMappedFieldImpl extends MinimalEObjectImpl.Container implements IntermediateMappedField {
    /**
     * The default value of the '{@link #getMappedFieldName() <em>Mapped Field Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMappedFieldName()
     * @generated
     * @ordered
     */
    protected static final String MAPPED_FIELD_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMappedFieldName() <em>Mapped Field Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMappedFieldName()
     * @generated
     * @ordered
     */
    protected String mappedFieldName = MAPPED_FIELD_NAME_EDEFAULT;

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
     * The default value of the '{@link #getOriginalTypeKind() <em>Original Type Kind</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOriginalTypeKind()
     * @generated
     * @ordered
     */
    protected static final IntermediateTypeKind ORIGINAL_TYPE_KIND_EDEFAULT = IntermediateTypeKind.DUMMY_FOR_XMI_SERIALIZER_BUG;

    /**
     * The cached value of the '{@link #getOriginalTypeKind() <em>Original Type Kind</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOriginalTypeKind()
     * @generated
     * @ordered
     */
    protected IntermediateTypeKind originalTypeKind = ORIGINAL_TYPE_KIND_EDEFAULT;

    /**
     * The cached value of the '{@link #getMappedType() <em>Mapped Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMappedType()
     * @generated
     * @ordered
     */
    protected IntermediateType mappedType;

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
    protected IntermediateMappedFieldImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_MAPPED_FIELD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getMappedFieldName() {
        return mappedFieldName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setMappedFieldName(String newMappedFieldName) {
        String oldMappedFieldName = mappedFieldName;
        mappedFieldName = newMappedFieldName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__MAPPED_FIELD_NAME, oldMappedFieldName, mappedFieldName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getQualifiedName() {
        return qualifiedName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setQualifiedName(String newQualifiedName) {
        String oldQualifiedName = qualifiedName;
        qualifiedName = newQualifiedName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateTypeKind getOriginalTypeKind() {
        return originalTypeKind;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setOriginalTypeKind(IntermediateTypeKind newOriginalTypeKind) {
        IntermediateTypeKind oldOriginalTypeKind = originalTypeKind;
        originalTypeKind = newOriginalTypeKind == null ? ORIGINAL_TYPE_KIND_EDEFAULT : newOriginalTypeKind;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__ORIGINAL_TYPE_KIND, oldOriginalTypeKind, originalTypeKind));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateType getMappedType() {
        return mappedType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMappedType(IntermediateType newMappedType, NotificationChain msgs) {
        IntermediateType oldMappedType = mappedType;
        mappedType = newMappedType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__MAPPED_TYPE, oldMappedType, newMappedType);
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
    public void setMappedType(IntermediateType newMappedType) {
        if (newMappedType != mappedType) {
            NotificationChain msgs = null;
            if (mappedType != null)
                msgs = ((InternalEObject)mappedType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__MAPPED_TYPE, null, msgs);
            if (newMappedType != null)
                msgs = ((InternalEObject)newMappedType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__MAPPED_TYPE, null, msgs);
            msgs = basicSetMappedType(newMappedType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__MAPPED_TYPE, newMappedType, newMappedType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<IntermediateImportedAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<IntermediateImportedAspect>(IntermediateImportedAspect.class, this, IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__ASPECTS, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MAPPED_FIELD);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateParameter getParameter() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__PARAMETER) return null;
        return (IntermediateParameter)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateParameter basicGetParameter() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__PARAMETER) return null;
        return (IntermediateParameter)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParameter(IntermediateParameter newParameter, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newParameter, IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__PARAMETER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setParameter(IntermediateParameter newParameter) {
        if (newParameter != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__PARAMETER && newParameter != null)) {
            if (EcoreUtil.isAncestor(this, newParameter))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParameter != null)
                msgs = ((InternalEObject)newParameter).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_PARAMETER__MAPPED_FIELDS, IntermediateParameter.class, msgs);
            msgs = basicSetParameter(newParameter, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__PARAMETER, newParameter, newParameter));
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
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__PARAMETER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetParameter((IntermediateParameter)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__MAPPED_TYPE:
                return basicSetMappedType(null, msgs);
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__PARAMETER:
                return basicSetParameter(null, msgs);
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
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__PARAMETER:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_PARAMETER__MAPPED_FIELDS, IntermediateParameter.class, msgs);
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
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__MAPPED_FIELD_NAME:
                return getMappedFieldName();
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__QUALIFIED_NAME:
                return getQualifiedName();
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__ORIGINAL_TYPE_KIND:
                return getOriginalTypeKind();
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__MAPPED_TYPE:
                return getMappedType();
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__ASPECTS:
                return getAspects();
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__PARAMETER:
                if (resolve) return getParameter();
                return basicGetParameter();
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
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__MAPPED_FIELD_NAME:
                setMappedFieldName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__QUALIFIED_NAME:
                setQualifiedName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__ORIGINAL_TYPE_KIND:
                setOriginalTypeKind((IntermediateTypeKind)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__MAPPED_TYPE:
                setMappedType((IntermediateType)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends IntermediateImportedAspect>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__PARAMETER:
                setParameter((IntermediateParameter)newValue);
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
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__MAPPED_FIELD_NAME:
                setMappedFieldName(MAPPED_FIELD_NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__QUALIFIED_NAME:
                setQualifiedName(QUALIFIED_NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__ORIGINAL_TYPE_KIND:
                setOriginalTypeKind(ORIGINAL_TYPE_KIND_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__MAPPED_TYPE:
                setMappedType((IntermediateType)null);
                return;
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__ASPECTS:
                getAspects().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__PARAMETER:
                setParameter((IntermediateParameter)null);
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
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__MAPPED_FIELD_NAME:
                return MAPPED_FIELD_NAME_EDEFAULT == null ? mappedFieldName != null : !MAPPED_FIELD_NAME_EDEFAULT.equals(mappedFieldName);
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__QUALIFIED_NAME:
                return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__ORIGINAL_TYPE_KIND:
                return originalTypeKind != ORIGINAL_TYPE_KIND_EDEFAULT;
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__MAPPED_TYPE:
                return mappedType != null;
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case IntermediatePackage.INTERMEDIATE_MAPPED_FIELD__PARAMETER:
                return basicGetParameter() != null;
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
        result.append(" (mappedFieldName: ");
        result.append(mappedFieldName);
        result.append(", qualifiedName: ");
        result.append(qualifiedName);
        result.append(", originalTypeKind: ");
        result.append(originalTypeKind);
        result.append(')');
        return result.toString();
    }

} //IntermediateMappedFieldImpl
