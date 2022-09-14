/**
 */
package de.fhdo.lemma.data.impl;

import com.google.common.base.Objects;

import de.fhdo.lemma.data.CollectionType;
import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataFieldFeature;
import de.fhdo.lemma.data.DataPackage;
import de.fhdo.lemma.data.DataStructure;
import de.fhdo.lemma.data.ImportedComplexType;
import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.data.PrimitiveValue;
import de.fhdo.lemma.data.Type;

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

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.impl.DataFieldImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataFieldImpl#isHidden <em>Hidden</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataFieldImpl#isImmutable <em>Immutable</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataFieldImpl#getComplexType <em>Complex Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataFieldImpl#getImportedComplexType <em>Imported Complex Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataFieldImpl#getPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataFieldImpl#getInitializationValue <em>Initialization Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataFieldImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataFieldImpl#getDataStructure <em>Data Structure</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataFieldImpl#getCollectionType <em>Collection Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataFieldImpl extends MinimalEObjectImpl.Container implements DataField {
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
     * The cached value of the '{@link #getComplexType() <em>Complex Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getComplexType()
     * @generated
     * @ordered
     */
    protected ComplexType complexType;

    /**
     * The cached value of the '{@link #getImportedComplexType() <em>Imported Complex Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImportedComplexType()
     * @generated
     * @ordered
     */
    protected ImportedComplexType importedComplexType;

    /**
     * The cached value of the '{@link #getPrimitiveType() <em>Primitive Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrimitiveType()
     * @generated
     * @ordered
     */
    protected PrimitiveType primitiveType;

    /**
     * The cached value of the '{@link #getInitializationValue() <em>Initialization Value</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInitializationValue()
     * @generated
     * @ordered
     */
    protected PrimitiveValue initializationValue;

    /**
     * The cached value of the '{@link #getFeatures() <em>Features</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFeatures()
     * @generated
     * @ordered
     */
    protected EList<DataFieldFeature> features;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DataFieldImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DataPackage.Literals.DATA_FIELD;
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
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_FIELD__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_FIELD__HIDDEN, oldHidden, hidden));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_FIELD__IMMUTABLE, oldImmutable, immutable));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComplexType getComplexType() {
        if (complexType != null && complexType.eIsProxy()) {
            InternalEObject oldComplexType = (InternalEObject)complexType;
            complexType = (ComplexType)eResolveProxy(oldComplexType);
            if (complexType != oldComplexType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataPackage.DATA_FIELD__COMPLEX_TYPE, oldComplexType, complexType));
            }
        }
        return complexType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComplexType basicGetComplexType() {
        return complexType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setComplexType(ComplexType newComplexType) {
        ComplexType oldComplexType = complexType;
        complexType = newComplexType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_FIELD__COMPLEX_TYPE, oldComplexType, complexType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ImportedComplexType getImportedComplexType() {
        return importedComplexType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetImportedComplexType(ImportedComplexType newImportedComplexType, NotificationChain msgs) {
        ImportedComplexType oldImportedComplexType = importedComplexType;
        importedComplexType = newImportedComplexType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataPackage.DATA_FIELD__IMPORTED_COMPLEX_TYPE, oldImportedComplexType, newImportedComplexType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setImportedComplexType(ImportedComplexType newImportedComplexType) {
        if (newImportedComplexType != importedComplexType) {
            NotificationChain msgs = null;
            if (importedComplexType != null)
                msgs = ((InternalEObject)importedComplexType).eInverseRemove(this, DataPackage.IMPORTED_COMPLEX_TYPE__DATA_FIELD, ImportedComplexType.class, msgs);
            if (newImportedComplexType != null)
                msgs = ((InternalEObject)newImportedComplexType).eInverseAdd(this, DataPackage.IMPORTED_COMPLEX_TYPE__DATA_FIELD, ImportedComplexType.class, msgs);
            msgs = basicSetImportedComplexType(newImportedComplexType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_FIELD__IMPORTED_COMPLEX_TYPE, newImportedComplexType, newImportedComplexType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveType getPrimitiveType() {
        return primitiveType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPrimitiveType(PrimitiveType newPrimitiveType, NotificationChain msgs) {
        PrimitiveType oldPrimitiveType = primitiveType;
        primitiveType = newPrimitiveType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataPackage.DATA_FIELD__PRIMITIVE_TYPE, oldPrimitiveType, newPrimitiveType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPrimitiveType(PrimitiveType newPrimitiveType) {
        if (newPrimitiveType != primitiveType) {
            NotificationChain msgs = null;
            if (primitiveType != null)
                msgs = ((InternalEObject)primitiveType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataPackage.DATA_FIELD__PRIMITIVE_TYPE, null, msgs);
            if (newPrimitiveType != null)
                msgs = ((InternalEObject)newPrimitiveType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataPackage.DATA_FIELD__PRIMITIVE_TYPE, null, msgs);
            msgs = basicSetPrimitiveType(newPrimitiveType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_FIELD__PRIMITIVE_TYPE, newPrimitiveType, newPrimitiveType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveValue getInitializationValue() {
        return initializationValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInitializationValue(PrimitiveValue newInitializationValue, NotificationChain msgs) {
        PrimitiveValue oldInitializationValue = initializationValue;
        initializationValue = newInitializationValue;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataPackage.DATA_FIELD__INITIALIZATION_VALUE, oldInitializationValue, newInitializationValue);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInitializationValue(PrimitiveValue newInitializationValue) {
        if (newInitializationValue != initializationValue) {
            NotificationChain msgs = null;
            if (initializationValue != null)
                msgs = ((InternalEObject)initializationValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataPackage.DATA_FIELD__INITIALIZATION_VALUE, null, msgs);
            if (newInitializationValue != null)
                msgs = ((InternalEObject)newInitializationValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataPackage.DATA_FIELD__INITIALIZATION_VALUE, null, msgs);
            msgs = basicSetInitializationValue(newInitializationValue, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_FIELD__INITIALIZATION_VALUE, newInitializationValue, newInitializationValue));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<DataFieldFeature> getFeatures() {
        if (features == null) {
            features = new EDataTypeEList<DataFieldFeature>(DataFieldFeature.class, this, DataPackage.DATA_FIELD__FEATURES);
        }
        return features;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataStructure getDataStructure() {
        if (eContainerFeatureID() != DataPackage.DATA_FIELD__DATA_STRUCTURE) return null;
        return (DataStructure)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataStructure basicGetDataStructure() {
        if (eContainerFeatureID() != DataPackage.DATA_FIELD__DATA_STRUCTURE) return null;
        return (DataStructure)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDataStructure(DataStructure newDataStructure, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDataStructure, DataPackage.DATA_FIELD__DATA_STRUCTURE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataStructure(DataStructure newDataStructure) {
        if (newDataStructure != eInternalContainer() || (eContainerFeatureID() != DataPackage.DATA_FIELD__DATA_STRUCTURE && newDataStructure != null)) {
            if (EcoreUtil.isAncestor(this, newDataStructure))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDataStructure != null)
                msgs = ((InternalEObject)newDataStructure).eInverseAdd(this, DataPackage.DATA_STRUCTURE__DATA_FIELDS, DataStructure.class, msgs);
            msgs = basicSetDataStructure(newDataStructure, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_FIELD__DATA_STRUCTURE, newDataStructure, newDataStructure));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CollectionType getCollectionType() {
        if (eContainerFeatureID() != DataPackage.DATA_FIELD__COLLECTION_TYPE) return null;
        return (CollectionType)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CollectionType basicGetCollectionType() {
        if (eContainerFeatureID() != DataPackage.DATA_FIELD__COLLECTION_TYPE) return null;
        return (CollectionType)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCollectionType(CollectionType newCollectionType, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newCollectionType, DataPackage.DATA_FIELD__COLLECTION_TYPE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCollectionType(CollectionType newCollectionType) {
        if (newCollectionType != eInternalContainer() || (eContainerFeatureID() != DataPackage.DATA_FIELD__COLLECTION_TYPE && newCollectionType != null)) {
            if (EcoreUtil.isAncestor(this, newCollectionType))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newCollectionType != null)
                msgs = ((InternalEObject)newCollectionType).eInverseAdd(this, DataPackage.COLLECTION_TYPE__DATA_FIELDS, CollectionType.class, msgs);
            msgs = basicSetCollectionType(newCollectionType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_FIELD__COLLECTION_TYPE, newCollectionType, newCollectionType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Type getEffectiveType() {
        Type _xifexpression = null;
        PrimitiveType _primitiveType = this.getPrimitiveType();
        boolean _tripleNotEquals = (_primitiveType != null);
        if (_tripleNotEquals) {
            _xifexpression = this.getPrimitiveType();
        }
        else {
            Type _xifexpression_1 = null;
            ComplexType _complexType = this.getComplexType();
            boolean _tripleNotEquals_1 = (_complexType != null);
            if (_tripleNotEquals_1) {
                _xifexpression_1 = this.getComplexType();
            }
            else {
                Type _xifexpression_2 = null;
                ImportedComplexType _importedComplexType = this.getImportedComplexType();
                boolean _tripleNotEquals_2 = (_importedComplexType != null);
                if (_tripleNotEquals_2) {
                    _xifexpression_2 = this.getImportedComplexType().getImportedType();
                }
                else {
                    _xifexpression_2 = null;
                }
                _xifexpression_1 = _xifexpression_2;
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
    public EList<String> getQualifiedNameParts() {
        EList<String> _xblockexpression = null;
        {
            if (((this.getName() == null) || this.getName().isEmpty())) {
                return ECollections.<String>asEList(CollectionLiterals.<String>newArrayList());
            }
            final ArrayList<String> nameParts = CollectionLiterals.<String>newArrayList();
            DataStructure _dataStructure = this.getDataStructure();
            boolean _tripleNotEquals = (_dataStructure != null);
            if (_tripleNotEquals) {
                nameParts.addAll(this.getDataStructure().getQualifiedNameParts());
            }
            else {
                CollectionType _collectionType = this.getCollectionType();
                boolean _tripleNotEquals_1 = (_collectionType != null);
                if (_tripleNotEquals_1) {
                    nameParts.addAll(this.getCollectionType().getQualifiedNameParts());
                }
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
    public String buildQualifiedName(final String separator) {
        if ((separator == null)) {
            return null;
        }
        String qualifiedName = "";
        EList<String> _qualifiedNameParts = this.getQualifiedNameParts();
        for (final String part : _qualifiedNameParts) {
            String _qualifiedName = qualifiedName;
            qualifiedName = (_qualifiedName + (separator + part));
        }
        boolean _isEmpty = qualifiedName.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
            qualifiedName = qualifiedName.substring(separator.length());
        }
        return qualifiedName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataField findEponymousSuperField() {
        DataStructure _dataStructure = this.getDataStructure();
        boolean _tripleEquals = (_dataStructure == null);
        if (_tripleEquals) {
            return null;
        }
        if (((this.getName() == null) || this.getName().isEmpty())) {
            return null;
        }
        DataStructure superStructure = this.getDataStructure().getSuper();
        while ((superStructure != null)) {
            {
                final Function1<DataField, Boolean> _function = new Function1<DataField, Boolean>() {
                    public Boolean apply(final DataField it) {
                        String _name = DataFieldImpl.this.getName();
                        String _name_1 = it.getName();
                        return Boolean.valueOf(Objects.equal(_name, _name_1));
                    }
                };
                final DataField overridenField = IterableExtensions.<DataField>findFirst(superStructure.getDataFields(), _function);
                if ((overridenField != null)) {
                    return overridenField;
                }
                else {
                    superStructure = superStructure.getSuper();
                }
            }
        }
        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean hasFeature(final DataFieldFeature feature) {
        return this.getFeatures().contains(feature);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case DataPackage.DATA_FIELD__IMPORTED_COMPLEX_TYPE:
                if (importedComplexType != null)
                    msgs = ((InternalEObject)importedComplexType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataPackage.DATA_FIELD__IMPORTED_COMPLEX_TYPE, null, msgs);
                return basicSetImportedComplexType((ImportedComplexType)otherEnd, msgs);
            case DataPackage.DATA_FIELD__DATA_STRUCTURE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDataStructure((DataStructure)otherEnd, msgs);
            case DataPackage.DATA_FIELD__COLLECTION_TYPE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetCollectionType((CollectionType)otherEnd, msgs);
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
            case DataPackage.DATA_FIELD__IMPORTED_COMPLEX_TYPE:
                return basicSetImportedComplexType(null, msgs);
            case DataPackage.DATA_FIELD__PRIMITIVE_TYPE:
                return basicSetPrimitiveType(null, msgs);
            case DataPackage.DATA_FIELD__INITIALIZATION_VALUE:
                return basicSetInitializationValue(null, msgs);
            case DataPackage.DATA_FIELD__DATA_STRUCTURE:
                return basicSetDataStructure(null, msgs);
            case DataPackage.DATA_FIELD__COLLECTION_TYPE:
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
            case DataPackage.DATA_FIELD__DATA_STRUCTURE:
                return eInternalContainer().eInverseRemove(this, DataPackage.DATA_STRUCTURE__DATA_FIELDS, DataStructure.class, msgs);
            case DataPackage.DATA_FIELD__COLLECTION_TYPE:
                return eInternalContainer().eInverseRemove(this, DataPackage.COLLECTION_TYPE__DATA_FIELDS, CollectionType.class, msgs);
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
            case DataPackage.DATA_FIELD__NAME:
                return getName();
            case DataPackage.DATA_FIELD__HIDDEN:
                return isHidden();
            case DataPackage.DATA_FIELD__IMMUTABLE:
                return isImmutable();
            case DataPackage.DATA_FIELD__COMPLEX_TYPE:
                if (resolve) return getComplexType();
                return basicGetComplexType();
            case DataPackage.DATA_FIELD__IMPORTED_COMPLEX_TYPE:
                return getImportedComplexType();
            case DataPackage.DATA_FIELD__PRIMITIVE_TYPE:
                return getPrimitiveType();
            case DataPackage.DATA_FIELD__INITIALIZATION_VALUE:
                return getInitializationValue();
            case DataPackage.DATA_FIELD__FEATURES:
                return getFeatures();
            case DataPackage.DATA_FIELD__DATA_STRUCTURE:
                if (resolve) return getDataStructure();
                return basicGetDataStructure();
            case DataPackage.DATA_FIELD__COLLECTION_TYPE:
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
            case DataPackage.DATA_FIELD__NAME:
                setName((String)newValue);
                return;
            case DataPackage.DATA_FIELD__HIDDEN:
                setHidden((Boolean)newValue);
                return;
            case DataPackage.DATA_FIELD__IMMUTABLE:
                setImmutable((Boolean)newValue);
                return;
            case DataPackage.DATA_FIELD__COMPLEX_TYPE:
                setComplexType((ComplexType)newValue);
                return;
            case DataPackage.DATA_FIELD__IMPORTED_COMPLEX_TYPE:
                setImportedComplexType((ImportedComplexType)newValue);
                return;
            case DataPackage.DATA_FIELD__PRIMITIVE_TYPE:
                setPrimitiveType((PrimitiveType)newValue);
                return;
            case DataPackage.DATA_FIELD__INITIALIZATION_VALUE:
                setInitializationValue((PrimitiveValue)newValue);
                return;
            case DataPackage.DATA_FIELD__FEATURES:
                getFeatures().clear();
                getFeatures().addAll((Collection<? extends DataFieldFeature>)newValue);
                return;
            case DataPackage.DATA_FIELD__DATA_STRUCTURE:
                setDataStructure((DataStructure)newValue);
                return;
            case DataPackage.DATA_FIELD__COLLECTION_TYPE:
                setCollectionType((CollectionType)newValue);
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
            case DataPackage.DATA_FIELD__NAME:
                setName(NAME_EDEFAULT);
                return;
            case DataPackage.DATA_FIELD__HIDDEN:
                setHidden(HIDDEN_EDEFAULT);
                return;
            case DataPackage.DATA_FIELD__IMMUTABLE:
                setImmutable(IMMUTABLE_EDEFAULT);
                return;
            case DataPackage.DATA_FIELD__COMPLEX_TYPE:
                setComplexType((ComplexType)null);
                return;
            case DataPackage.DATA_FIELD__IMPORTED_COMPLEX_TYPE:
                setImportedComplexType((ImportedComplexType)null);
                return;
            case DataPackage.DATA_FIELD__PRIMITIVE_TYPE:
                setPrimitiveType((PrimitiveType)null);
                return;
            case DataPackage.DATA_FIELD__INITIALIZATION_VALUE:
                setInitializationValue((PrimitiveValue)null);
                return;
            case DataPackage.DATA_FIELD__FEATURES:
                getFeatures().clear();
                return;
            case DataPackage.DATA_FIELD__DATA_STRUCTURE:
                setDataStructure((DataStructure)null);
                return;
            case DataPackage.DATA_FIELD__COLLECTION_TYPE:
                setCollectionType((CollectionType)null);
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
            case DataPackage.DATA_FIELD__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case DataPackage.DATA_FIELD__HIDDEN:
                return hidden != HIDDEN_EDEFAULT;
            case DataPackage.DATA_FIELD__IMMUTABLE:
                return immutable != IMMUTABLE_EDEFAULT;
            case DataPackage.DATA_FIELD__COMPLEX_TYPE:
                return complexType != null;
            case DataPackage.DATA_FIELD__IMPORTED_COMPLEX_TYPE:
                return importedComplexType != null;
            case DataPackage.DATA_FIELD__PRIMITIVE_TYPE:
                return primitiveType != null;
            case DataPackage.DATA_FIELD__INITIALIZATION_VALUE:
                return initializationValue != null;
            case DataPackage.DATA_FIELD__FEATURES:
                return features != null && !features.isEmpty();
            case DataPackage.DATA_FIELD__DATA_STRUCTURE:
                return basicGetDataStructure() != null;
            case DataPackage.DATA_FIELD__COLLECTION_TYPE:
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
            case DataPackage.DATA_FIELD___GET_EFFECTIVE_TYPE:
                return getEffectiveType();
            case DataPackage.DATA_FIELD___GET_QUALIFIED_NAME_PARTS:
                return getQualifiedNameParts();
            case DataPackage.DATA_FIELD___BUILD_QUALIFIED_NAME__STRING:
                return buildQualifiedName((String)arguments.get(0));
            case DataPackage.DATA_FIELD___FIND_EPONYMOUS_SUPER_FIELD:
                return findEponymousSuperField();
            case DataPackage.DATA_FIELD___HAS_FEATURE__DATAFIELDFEATURE:
                return hasFeature((DataFieldFeature)arguments.get(0));
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
        result.append(", hidden: ");
        result.append(hidden);
        result.append(", immutable: ");
        result.append(immutable);
        result.append(", features: ");
        result.append(features);
        result.append(')');
        return result.toString();
    }

} //DataFieldImpl
