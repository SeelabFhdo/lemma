/**
 */
package de.fhdo.lemma.data.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateDataOperation;
import de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter;
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect;
import de.fhdo.lemma.data.intermediate.IntermediatePackage;
import de.fhdo.lemma.data.intermediate.IntermediateType;

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
 * An implementation of the model object '<em><b>Data Operation Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationParameterImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationParameterImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationParameterImpl#getOriginalType <em>Original Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationParameterImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationParameterImpl#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateDataOperationParameterImpl extends MinimalEObjectImpl.Container implements IntermediateDataOperationParameter {
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
     * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected IntermediateType type;

    /**
     * The cached value of the '{@link #getOriginalType() <em>Original Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOriginalType()
     * @generated
     * @ordered
     */
    protected IntermediateType originalType;

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
    protected IntermediateDataOperationParameterImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_DATA_OPERATION_PARAMETER;
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateType getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetType(IntermediateType newType, NotificationChain msgs) {
        IntermediateType oldType = type;
        type = newType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__TYPE, oldType, newType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(IntermediateType newType) {
        if (newType != type) {
            NotificationChain msgs = null;
            if (type != null)
                msgs = ((InternalEObject)type).eInverseRemove(this, IntermediatePackage.INTERMEDIATE_TYPE__PARAMETER, IntermediateType.class, msgs);
            if (newType != null)
                msgs = ((InternalEObject)newType).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_TYPE__PARAMETER, IntermediateType.class, msgs);
            msgs = basicSetType(newType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__TYPE, newType, newType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateType getOriginalType() {
        return originalType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOriginalType(IntermediateType newOriginalType, NotificationChain msgs) {
        IntermediateType oldOriginalType = originalType;
        originalType = newOriginalType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__ORIGINAL_TYPE, oldOriginalType, newOriginalType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOriginalType(IntermediateType newOriginalType) {
        if (newOriginalType != originalType) {
            NotificationChain msgs = null;
            if (originalType != null)
                msgs = ((InternalEObject)originalType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__ORIGINAL_TYPE, null, msgs);
            if (newOriginalType != null)
                msgs = ((InternalEObject)newOriginalType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__ORIGINAL_TYPE, null, msgs);
            msgs = basicSetOriginalType(newOriginalType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__ORIGINAL_TYPE, newOriginalType, newOriginalType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateImportedAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<IntermediateImportedAspect>(IntermediateImportedAspect.class, this, IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__ASPECTS, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataOperation getOperation() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__OPERATION) return null;
        return (IntermediateDataOperation)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataOperation basicGetOperation() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__OPERATION) return null;
        return (IntermediateDataOperation)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOperation(IntermediateDataOperation newOperation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOperation, IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__OPERATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperation(IntermediateDataOperation newOperation) {
        if (newOperation != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__OPERATION && newOperation != null)) {
            if (EcoreUtil.isAncestor(this, newOperation))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOperation != null)
                msgs = ((InternalEObject)newOperation).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_DATA_OPERATION__PARAMETERS, IntermediateDataOperation.class, msgs);
            msgs = basicSetOperation(newOperation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__OPERATION, newOperation, newOperation));
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
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__TYPE:
                if (type != null)
                    msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__TYPE, null, msgs);
                return basicSetType((IntermediateType)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__OPERATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOperation((IntermediateDataOperation)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__TYPE:
                return basicSetType(null, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__ORIGINAL_TYPE:
                return basicSetOriginalType(null, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__OPERATION:
                return basicSetOperation(null, msgs);
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
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__OPERATION:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_DATA_OPERATION__PARAMETERS, IntermediateDataOperation.class, msgs);
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
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__NAME:
                return getName();
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__QUALIFIED_NAME:
                return getQualifiedName();
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__TYPE:
                return getType();
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__ORIGINAL_TYPE:
                return getOriginalType();
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__ASPECTS:
                return getAspects();
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__OPERATION:
                if (resolve) return getOperation();
                return basicGetOperation();
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
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__NAME:
                setName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__QUALIFIED_NAME:
                setQualifiedName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__TYPE:
                setType((IntermediateType)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__ORIGINAL_TYPE:
                setOriginalType((IntermediateType)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends IntermediateImportedAspect>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__OPERATION:
                setOperation((IntermediateDataOperation)newValue);
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
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__NAME:
                setName(NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__QUALIFIED_NAME:
                setQualifiedName(QUALIFIED_NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__TYPE:
                setType((IntermediateType)null);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__ORIGINAL_TYPE:
                setOriginalType((IntermediateType)null);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__ASPECTS:
                getAspects().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__OPERATION:
                setOperation((IntermediateDataOperation)null);
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
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__QUALIFIED_NAME:
                return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__TYPE:
                return type != null;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__ORIGINAL_TYPE:
                return originalType != null;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__OPERATION:
                return basicGetOperation() != null;
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
        result.append(", qualifiedName: ");
        result.append(qualifiedName);
        result.append(')');
        return result.toString();
    }

} //IntermediateDataOperationParameterImpl
