/**
 */
package de.fhdo.lemma.data.impl;

import com.google.common.base.Objects;

import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataPackage;
import de.fhdo.lemma.data.DataStructure;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.impl.DataStructureImpl#getSuper <em>Super</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataStructureImpl#getDataFields <em>Data Fields</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataStructureImpl extends ComplexTypeImpl implements DataStructure {
    /**
     * The cached value of the '{@link #getSuper() <em>Super</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSuper()
     * @generated
     * @ordered
     */
    protected DataStructure super_;

    /**
     * The cached value of the '{@link #getDataFields() <em>Data Fields</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataFields()
     * @generated
     * @ordered
     */
    protected EList<DataField> dataFields;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DataStructureImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DataPackage.Literals.DATA_STRUCTURE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DataStructure getSuper() {
        if (super_ != null && super_.eIsProxy()) {
            InternalEObject oldSuper = (InternalEObject)super_;
            super_ = (DataStructure)eResolveProxy(oldSuper);
            if (super_ != oldSuper) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataPackage.DATA_STRUCTURE__SUPER, oldSuper, super_));
            }
        }
        return super_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataStructure basicGetSuper() {
        return super_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setSuper(DataStructure newSuper) {
        DataStructure oldSuper = super_;
        super_ = newSuper;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_STRUCTURE__SUPER, oldSuper, super_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<DataField> getDataFields() {
        if (dataFields == null) {
            dataFields = new EObjectContainmentWithInverseEList<DataField>(DataField.class, this, DataPackage.DATA_STRUCTURE__DATA_FIELDS, DataPackage.DATA_FIELD__DATA_STRUCTURE);
        }
        return dataFields;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<DataField> getEffectiveFields() {
        final ArrayList<DataField> effectiveFields = CollectionLiterals.<DataField>newArrayList();
        final HashSet<String> hiddenFields = CollectionLiterals.<String>newHashSet();
        DataStructure currentStructure = this;
        do {
            {
                final Function1<DataField, Boolean> _function = new Function1<DataField, Boolean>() {
                    public Boolean apply(final DataField it) {
                        String _name = it.getName();
                        return Boolean.valueOf((_name != null));
                    }
                };
                final Iterable<DataField> currentNamedFields = IterableExtensions.<DataField>filter(currentStructure.getDataFields(), _function);
                for (final DataField field : currentNamedFields) {
                    {
                        boolean _isHidden = field.isHidden();
                        if (_isHidden) {
                            hiddenFields.add(field.getName());
                        }
                        final Function1<DataField, Boolean> _function_1 = new Function1<DataField, Boolean>() {
                            public Boolean apply(final DataField it) {
                                String _name = field.getName();
                                String _name_1 = it.getName();
                                return Boolean.valueOf(Objects.equal(_name, _name_1));
                            }
                        };
                        final DataField existingEffectiveField = IterableExtensions.<DataField>findFirst(effectiveFields, _function_1);
                        final boolean fieldAlreadyCollected = (existingEffectiveField != null);
                        final boolean hiddenField = (field.isHidden() || hiddenFields.contains(field.getName()));
                        final boolean inheritedField = (currentStructure != this);
                        final boolean visibleInheritedField = ((!hiddenField) && inheritedField);
                        if (((!fieldAlreadyCollected) && ((!inheritedField) || visibleInheritedField))) {
                            effectiveFields.add(field);
                        }
                        else {
                            if ((fieldAlreadyCollected && hiddenField)) {
                                effectiveFields.remove(existingEffectiveField);
                                effectiveFields.add(field);
                            }
                        }
                    }
                }
                currentStructure = currentStructure.getSuper();
            }
        }
        while((currentStructure != null));
        return ECollections.<DataField>asEList(effectiveFields);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isExtensionOf(final DataStructure structure) {
        if ((structure == null)) {
            return false;
        }
        DataStructure currentStructure = this;
        while ((currentStructure.getSuper() != null)) {
            {
                DataStructure _super = currentStructure.getSuper();
                boolean _equals = Objects.equal(_super, structure);
                if (_equals) {
                    return true;
                }
                currentStructure = currentStructure.getSuper();
            }
        }
        return false;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int compareFieldCounts(final DataStructure structureToCompare) {
        if ((structureToCompare == null)) {
            return 1;
        }
        return super.compareFieldCounts(this.getEffectiveFields(), structureToCompare.getEffectiveFields());
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
            case DataPackage.DATA_STRUCTURE__DATA_FIELDS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getDataFields()).basicAdd(otherEnd, msgs);
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
            case DataPackage.DATA_STRUCTURE__DATA_FIELDS:
                return ((InternalEList<?>)getDataFields()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case DataPackage.DATA_STRUCTURE__SUPER:
                if (resolve) return getSuper();
                return basicGetSuper();
            case DataPackage.DATA_STRUCTURE__DATA_FIELDS:
                return getDataFields();
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
            case DataPackage.DATA_STRUCTURE__SUPER:
                setSuper((DataStructure)newValue);
                return;
            case DataPackage.DATA_STRUCTURE__DATA_FIELDS:
                getDataFields().clear();
                getDataFields().addAll((Collection<? extends DataField>)newValue);
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
            case DataPackage.DATA_STRUCTURE__SUPER:
                setSuper((DataStructure)null);
                return;
            case DataPackage.DATA_STRUCTURE__DATA_FIELDS:
                getDataFields().clear();
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
            case DataPackage.DATA_STRUCTURE__SUPER:
                return super_ != null;
            case DataPackage.DATA_STRUCTURE__DATA_FIELDS:
                return dataFields != null && !dataFields.isEmpty();
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
            case DataPackage.DATA_STRUCTURE___GET_EFFECTIVE_FIELDS:
                return getEffectiveFields();
            case DataPackage.DATA_STRUCTURE___IS_EXTENSION_OF__DATASTRUCTURE:
                return isExtensionOf((DataStructure)arguments.get(0));
            case DataPackage.DATA_STRUCTURE___COMPARE_FIELD_COUNTS__DATASTRUCTURE:
                return compareFieldCounts((DataStructure)arguments.get(0));
        }
        return super.eInvoke(operationID, arguments);
    }

} //DataStructureImpl
