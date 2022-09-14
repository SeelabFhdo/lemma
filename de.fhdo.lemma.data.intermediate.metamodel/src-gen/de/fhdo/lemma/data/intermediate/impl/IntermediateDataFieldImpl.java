/**
 */
package de.fhdo.lemma.data.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateCollectionType;
import de.fhdo.lemma.data.intermediate.IntermediateComplexType;
import de.fhdo.lemma.data.intermediate.IntermediateDataField;
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure;
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect;
import de.fhdo.lemma.data.intermediate.IntermediatePackage;
import de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType;
import de.fhdo.lemma.data.intermediate.IntermediateType;

import java.lang.reflect.InvocationTargetException;

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
 * An implementation of the model object '<em><b>Data Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataFieldImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataFieldImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataFieldImpl#isHidden <em>Hidden</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataFieldImpl#isImmutable <em>Immutable</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataFieldImpl#isInherited <em>Inherited</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataFieldImpl#getFeatureNames <em>Feature Names</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataFieldImpl#getInitializationValue <em>Initialization Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataFieldImpl#getInitializationValueCompatibleTypes <em>Initialization Value Compatible Types</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataFieldImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataFieldImpl#getOriginalType <em>Original Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataFieldImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataFieldImpl#getDataStructure <em>Data Structure</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataFieldImpl#getCollectionType <em>Collection Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateDataFieldImpl extends MinimalEObjectImpl.Container implements IntermediateDataField {
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
     * The default value of the '{@link #isImmutable() <em>Immutable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isImmutable()
     * @generated
     * @ordered
     */
    protected static final boolean IMMUTABLE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isImmutable() <em>Immutable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isImmutable()
     * @generated
     * @ordered
     */
    protected boolean immutable = IMMUTABLE_EDEFAULT;

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
     * The default value of the '{@link #getInitializationValue() <em>Initialization Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInitializationValue()
     * @generated
     * @ordered
     */
    protected static final String INITIALIZATION_VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getInitializationValue() <em>Initialization Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInitializationValue()
     * @generated
     * @ordered
     */
    protected String initializationValue = INITIALIZATION_VALUE_EDEFAULT;

    /**
     * The cached value of the '{@link #getInitializationValueCompatibleTypes() <em>Initialization Value Compatible Types</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInitializationValueCompatibleTypes()
     * @generated
     * @ordered
     */
    protected EList<IntermediatePrimitiveType> initializationValueCompatibleTypes;

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
    protected IntermediateDataFieldImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_DATA_FIELD;
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_FIELD__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_FIELD__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_FIELD__HIDDEN, oldHidden, hidden));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isImmutable() {
        return immutable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setImmutable(boolean newImmutable) {
        boolean oldImmutable = immutable;
        immutable = newImmutable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_FIELD__IMMUTABLE, oldImmutable, immutable));
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_FIELD__INHERITED, oldInherited, inherited));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getFeatureNames() {
        if (featureNames == null) {
            featureNames = new EDataTypeEList<String>(String.class, this, IntermediatePackage.INTERMEDIATE_DATA_FIELD__FEATURE_NAMES);
        }
        return featureNames;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getInitializationValue() {
        return initializationValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInitializationValue(String newInitializationValue) {
        String oldInitializationValue = initializationValue;
        initializationValue = newInitializationValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_FIELD__INITIALIZATION_VALUE, oldInitializationValue, initializationValue));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediatePrimitiveType> getInitializationValueCompatibleTypes() {
        if (initializationValueCompatibleTypes == null) {
            initializationValueCompatibleTypes = new EObjectContainmentWithInverseEList<IntermediatePrimitiveType>(IntermediatePrimitiveType.class, this, IntermediatePackage.INTERMEDIATE_DATA_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES, IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_DATA_FIELD);
        }
        return initializationValueCompatibleTypes;
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_FIELD__TYPE, oldType, newType);
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
                msgs = ((InternalEObject)type).eInverseRemove(this, IntermediatePackage.INTERMEDIATE_TYPE__DATA_FIELD, IntermediateType.class, msgs);
            if (newType != null)
                msgs = ((InternalEObject)newType).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_TYPE__DATA_FIELD, IntermediateType.class, msgs);
            msgs = basicSetType(newType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_FIELD__TYPE, newType, newType));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_FIELD__ORIGINAL_TYPE, oldOriginalType, newOriginalType);
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
                msgs = ((InternalEObject)originalType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_DATA_FIELD__ORIGINAL_TYPE, null, msgs);
            if (newOriginalType != null)
                msgs = ((InternalEObject)newOriginalType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_DATA_FIELD__ORIGINAL_TYPE, null, msgs);
            msgs = basicSetOriginalType(newOriginalType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_FIELD__ORIGINAL_TYPE, newOriginalType, newOriginalType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateImportedAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<IntermediateImportedAspect>(IntermediateImportedAspect.class, this, IntermediatePackage.INTERMEDIATE_DATA_FIELD__ASPECTS, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__DATA_FIELD);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataStructure getDataStructure() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_DATA_FIELD__DATA_STRUCTURE) return null;
        return (IntermediateDataStructure)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataStructure basicGetDataStructure() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_DATA_FIELD__DATA_STRUCTURE) return null;
        return (IntermediateDataStructure)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDataStructure(IntermediateDataStructure newDataStructure, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDataStructure, IntermediatePackage.INTERMEDIATE_DATA_FIELD__DATA_STRUCTURE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataStructure(IntermediateDataStructure newDataStructure) {
        if (newDataStructure != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_DATA_FIELD__DATA_STRUCTURE && newDataStructure != null)) {
            if (EcoreUtil.isAncestor(this, newDataStructure))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDataStructure != null)
                msgs = ((InternalEObject)newDataStructure).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__DATA_FIELDS, IntermediateDataStructure.class, msgs);
            msgs = basicSetDataStructure(newDataStructure, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_FIELD__DATA_STRUCTURE, newDataStructure, newDataStructure));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateCollectionType getCollectionType() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_DATA_FIELD__COLLECTION_TYPE) return null;
        return (IntermediateCollectionType)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateCollectionType basicGetCollectionType() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_DATA_FIELD__COLLECTION_TYPE) return null;
        return (IntermediateCollectionType)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCollectionType(IntermediateCollectionType newCollectionType, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newCollectionType, IntermediatePackage.INTERMEDIATE_DATA_FIELD__COLLECTION_TYPE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCollectionType(IntermediateCollectionType newCollectionType) {
        if (newCollectionType != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_DATA_FIELD__COLLECTION_TYPE && newCollectionType != null)) {
            if (EcoreUtil.isAncestor(this, newCollectionType))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newCollectionType != null)
                msgs = ((InternalEObject)newCollectionType).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__DATA_FIELDS, IntermediateCollectionType.class, msgs);
            msgs = basicSetCollectionType(newCollectionType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_FIELD__COLLECTION_TYPE, newCollectionType, newCollectionType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateComplexType getEffectiveComplexType() {
        IntermediateComplexType _xifexpression = null;
        IntermediateDataStructure _dataStructure = this.getDataStructure();
        boolean _tripleNotEquals = (_dataStructure != null);
        if (_tripleNotEquals) {
            _xifexpression = this.getDataStructure();
        }
        else {
            IntermediateCollectionType _xifexpression_1 = null;
            IntermediateCollectionType _collectionType = this.getCollectionType();
            boolean _tripleNotEquals_1 = (_collectionType != null);
            if (_tripleNotEquals_1) {
                _xifexpression_1 = this.getCollectionType();
            }
            else {
                _xifexpression_1 = null;
            }
            _xifexpression = _xifexpression_1;
        }
        return _xifexpression;
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
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getInitializationValueCompatibleTypes()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__TYPE:
                if (type != null)
                    msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_DATA_FIELD__TYPE, null, msgs);
                return basicSetType((IntermediateType)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__DATA_STRUCTURE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDataStructure((IntermediateDataStructure)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__COLLECTION_TYPE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetCollectionType((IntermediateCollectionType)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES:
                return ((InternalEList<?>)getInitializationValueCompatibleTypes()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__TYPE:
                return basicSetType(null, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__ORIGINAL_TYPE:
                return basicSetOriginalType(null, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__DATA_STRUCTURE:
                return basicSetDataStructure(null, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__COLLECTION_TYPE:
                return basicSetCollectionType(null, msgs);
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
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__DATA_STRUCTURE:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__DATA_FIELDS, IntermediateDataStructure.class, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__COLLECTION_TYPE:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__DATA_FIELDS, IntermediateCollectionType.class, msgs);
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
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__NAME:
                return getName();
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__QUALIFIED_NAME:
                return getQualifiedName();
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__HIDDEN:
                return isHidden();
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__IMMUTABLE:
                return isImmutable();
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__INHERITED:
                return isInherited();
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__FEATURE_NAMES:
                return getFeatureNames();
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__INITIALIZATION_VALUE:
                return getInitializationValue();
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES:
                return getInitializationValueCompatibleTypes();
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__TYPE:
                return getType();
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__ORIGINAL_TYPE:
                return getOriginalType();
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__ASPECTS:
                return getAspects();
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__DATA_STRUCTURE:
                if (resolve) return getDataStructure();
                return basicGetDataStructure();
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__COLLECTION_TYPE:
                if (resolve) return getCollectionType();
                return basicGetCollectionType();
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
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__NAME:
                setName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__QUALIFIED_NAME:
                setQualifiedName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__HIDDEN:
                setHidden((Boolean)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__IMMUTABLE:
                setImmutable((Boolean)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__INHERITED:
                setInherited((Boolean)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__FEATURE_NAMES:
                getFeatureNames().clear();
                getFeatureNames().addAll((Collection<? extends String>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__INITIALIZATION_VALUE:
                setInitializationValue((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES:
                getInitializationValueCompatibleTypes().clear();
                getInitializationValueCompatibleTypes().addAll((Collection<? extends IntermediatePrimitiveType>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__TYPE:
                setType((IntermediateType)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__ORIGINAL_TYPE:
                setOriginalType((IntermediateType)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends IntermediateImportedAspect>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__DATA_STRUCTURE:
                setDataStructure((IntermediateDataStructure)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__COLLECTION_TYPE:
                setCollectionType((IntermediateCollectionType)newValue);
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
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__NAME:
                setName(NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__QUALIFIED_NAME:
                setQualifiedName(QUALIFIED_NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__HIDDEN:
                setHidden(HIDDEN_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__IMMUTABLE:
                setImmutable(IMMUTABLE_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__INHERITED:
                setInherited(INHERITED_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__FEATURE_NAMES:
                getFeatureNames().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__INITIALIZATION_VALUE:
                setInitializationValue(INITIALIZATION_VALUE_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES:
                getInitializationValueCompatibleTypes().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__TYPE:
                setType((IntermediateType)null);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__ORIGINAL_TYPE:
                setOriginalType((IntermediateType)null);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__ASPECTS:
                getAspects().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__DATA_STRUCTURE:
                setDataStructure((IntermediateDataStructure)null);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__COLLECTION_TYPE:
                setCollectionType((IntermediateCollectionType)null);
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
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__QUALIFIED_NAME:
                return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__HIDDEN:
                return hidden != HIDDEN_EDEFAULT;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__IMMUTABLE:
                return immutable != IMMUTABLE_EDEFAULT;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__INHERITED:
                return inherited != INHERITED_EDEFAULT;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__FEATURE_NAMES:
                return featureNames != null && !featureNames.isEmpty();
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__INITIALIZATION_VALUE:
                return INITIALIZATION_VALUE_EDEFAULT == null ? initializationValue != null : !INITIALIZATION_VALUE_EDEFAULT.equals(initializationValue);
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES:
                return initializationValueCompatibleTypes != null && !initializationValueCompatibleTypes.isEmpty();
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__TYPE:
                return type != null;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__ORIGINAL_TYPE:
                return originalType != null;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__DATA_STRUCTURE:
                return basicGetDataStructure() != null;
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD__COLLECTION_TYPE:
                return basicGetCollectionType() != null;
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
            case IntermediatePackage.INTERMEDIATE_DATA_FIELD___GET_EFFECTIVE_COMPLEX_TYPE:
                return getEffectiveComplexType();
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

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(", qualifiedName: ");
        result.append(qualifiedName);
        result.append(", hidden: ");
        result.append(hidden);
        result.append(", immutable: ");
        result.append(immutable);
        result.append(", inherited: ");
        result.append(inherited);
        result.append(", featureNames: ");
        result.append(featureNames);
        result.append(", initializationValue: ");
        result.append(initializationValue);
        result.append(')');
        return result.toString();
    }

} //IntermediateDataFieldImpl
