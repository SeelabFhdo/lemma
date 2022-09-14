/**
 */
package de.fhdo.lemma.data.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateDataOperation;
import de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter;
import de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType;
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure;
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect;
import de.fhdo.lemma.data.intermediate.IntermediatePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationImpl#isHidden <em>Hidden</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationImpl#isInherited <em>Inherited</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationImpl#getFeatureNames <em>Feature Names</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataOperationImpl#getDataStructure <em>Data Structure</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateDataOperationImpl extends MinimalEObjectImpl.Container implements IntermediateDataOperation {
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
     * The default value of the '{@link #isHidden() <em>Hidden</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isHidden()
     * @generated
     * @ordered
     */
    protected static final boolean HIDDEN_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isHidden() <em>Hidden</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isHidden()
     * @generated
     * @ordered
     */
    protected boolean hidden = HIDDEN_EDEFAULT;

    /**
     * The default value of the '{@link #isInherited() <em>Inherited</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isInherited()
     * @generated
     * @ordered
     */
    protected static final boolean INHERITED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isInherited() <em>Inherited</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isInherited()
     * @generated
     * @ordered
     */
    protected boolean inherited = INHERITED_EDEFAULT;

    /**
     * The cached value of the '{@link #getFeatureNames() <em>Feature Names</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFeatureNames()
     * @generated
     * @ordered
     */
    protected EList<String> featureNames;

    /**
     * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReturnType()
     * @generated
     * @ordered
     */
    protected IntermediateDataOperationReturnType returnType;

    /**
     * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParameters()
     * @generated
     * @ordered
     */
    protected EList<IntermediateDataOperationParameter> parameters;

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
    protected IntermediateDataOperationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_DATA_OPERATION;
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_OPERATION__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_OPERATION__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHidden(boolean newHidden) {
        boolean oldHidden = hidden;
        hidden = newHidden;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_OPERATION__HIDDEN, oldHidden, hidden));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isInherited() {
        return inherited;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInherited(boolean newInherited) {
        boolean oldInherited = inherited;
        inherited = newInherited;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_OPERATION__INHERITED, oldInherited, inherited));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getFeatureNames() {
        if (featureNames == null) {
            featureNames = new EDataTypeEList<String>(String.class, this, IntermediatePackage.INTERMEDIATE_DATA_OPERATION__FEATURE_NAMES);
        }
        return featureNames;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataOperationReturnType getReturnType() {
        return returnType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetReturnType(IntermediateDataOperationReturnType newReturnType, NotificationChain msgs) {
        IntermediateDataOperationReturnType oldReturnType = returnType;
        returnType = newReturnType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_OPERATION__RETURN_TYPE, oldReturnType, newReturnType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReturnType(IntermediateDataOperationReturnType newReturnType) {
        if (newReturnType != returnType) {
            NotificationChain msgs = null;
            if (returnType != null)
                msgs = ((InternalEObject)returnType).eInverseRemove(this, IntermediatePackage.INTERMEDIATE_DATA_OPERATION_RETURN_TYPE__OPERATION, IntermediateDataOperationReturnType.class, msgs);
            if (newReturnType != null)
                msgs = ((InternalEObject)newReturnType).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_DATA_OPERATION_RETURN_TYPE__OPERATION, IntermediateDataOperationReturnType.class, msgs);
            msgs = basicSetReturnType(newReturnType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_OPERATION__RETURN_TYPE, newReturnType, newReturnType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateDataOperationParameter> getParameters() {
        if (parameters == null) {
            parameters = new EObjectContainmentWithInverseEList<IntermediateDataOperationParameter>(IntermediateDataOperationParameter.class, this, IntermediatePackage.INTERMEDIATE_DATA_OPERATION__PARAMETERS, IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__OPERATION);
        }
        return parameters;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateImportedAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<IntermediateImportedAspect>(IntermediateImportedAspect.class, this, IntermediatePackage.INTERMEDIATE_DATA_OPERATION__ASPECTS, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataStructure getDataStructure() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_DATA_OPERATION__DATA_STRUCTURE) return null;
        return (IntermediateDataStructure)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataStructure basicGetDataStructure() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_DATA_OPERATION__DATA_STRUCTURE) return null;
        return (IntermediateDataStructure)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDataStructure(IntermediateDataStructure newDataStructure, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDataStructure, IntermediatePackage.INTERMEDIATE_DATA_OPERATION__DATA_STRUCTURE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataStructure(IntermediateDataStructure newDataStructure) {
        if (newDataStructure != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_DATA_OPERATION__DATA_STRUCTURE && newDataStructure != null)) {
            if (EcoreUtil.isAncestor(this, newDataStructure))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDataStructure != null)
                msgs = ((InternalEObject)newDataStructure).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__OPERATIONS, IntermediateDataStructure.class, msgs);
            msgs = basicSetDataStructure(newDataStructure, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_OPERATION__DATA_STRUCTURE, newDataStructure, newDataStructure));
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
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__RETURN_TYPE:
                if (returnType != null)
                    msgs = ((InternalEObject)returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_DATA_OPERATION__RETURN_TYPE, null, msgs);
                return basicSetReturnType((IntermediateDataOperationReturnType)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__PARAMETERS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameters()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__DATA_STRUCTURE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDataStructure((IntermediateDataStructure)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__RETURN_TYPE:
                return basicSetReturnType(null, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__PARAMETERS:
                return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__DATA_STRUCTURE:
                return basicSetDataStructure(null, msgs);
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
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__DATA_STRUCTURE:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__OPERATIONS, IntermediateDataStructure.class, msgs);
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
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__NAME:
                return getName();
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__QUALIFIED_NAME:
                return getQualifiedName();
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__HIDDEN:
                return isHidden();
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__INHERITED:
                return isInherited();
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__FEATURE_NAMES:
                return getFeatureNames();
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__RETURN_TYPE:
                return getReturnType();
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__PARAMETERS:
                return getParameters();
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__ASPECTS:
                return getAspects();
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__DATA_STRUCTURE:
                if (resolve) return getDataStructure();
                return basicGetDataStructure();
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
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__NAME:
                setName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__QUALIFIED_NAME:
                setQualifiedName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__HIDDEN:
                setHidden((Boolean)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__INHERITED:
                setInherited((Boolean)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__FEATURE_NAMES:
                getFeatureNames().clear();
                getFeatureNames().addAll((Collection<? extends String>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__RETURN_TYPE:
                setReturnType((IntermediateDataOperationReturnType)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__PARAMETERS:
                getParameters().clear();
                getParameters().addAll((Collection<? extends IntermediateDataOperationParameter>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends IntermediateImportedAspect>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__DATA_STRUCTURE:
                setDataStructure((IntermediateDataStructure)newValue);
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
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__QUALIFIED_NAME:
                setQualifiedName(QUALIFIED_NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__HIDDEN:
                setHidden(HIDDEN_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__INHERITED:
                setInherited(INHERITED_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__FEATURE_NAMES:
                getFeatureNames().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__RETURN_TYPE:
                setReturnType((IntermediateDataOperationReturnType)null);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__PARAMETERS:
                getParameters().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__ASPECTS:
                getAspects().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__DATA_STRUCTURE:
                setDataStructure((IntermediateDataStructure)null);
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
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__QUALIFIED_NAME:
                return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__HIDDEN:
                return hidden != HIDDEN_EDEFAULT;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__INHERITED:
                return inherited != INHERITED_EDEFAULT;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__FEATURE_NAMES:
                return featureNames != null && !featureNames.isEmpty();
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__RETURN_TYPE:
                return returnType != null;
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__PARAMETERS:
                return parameters != null && !parameters.isEmpty();
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case IntermediatePackage.INTERMEDIATE_DATA_OPERATION__DATA_STRUCTURE:
                return basicGetDataStructure() != null;
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
        result.append(", hidden: ");
        result.append(hidden);
        result.append(", inherited: ");
        result.append(inherited);
        result.append(", featureNames: ");
        result.append(featureNames);
        result.append(')');
        return result.toString();
    }

} //IntermediateDataOperationImpl
