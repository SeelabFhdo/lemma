/**
 */
package de.fhdo.ddmm.data.impl;

import com.google.common.base.Objects;

import de.fhdo.ddmm.data.DataField;
import de.fhdo.ddmm.data.DataPackage;
import de.fhdo.ddmm.data.DataStructure;
import de.fhdo.ddmm.data.ListType;
import de.fhdo.ddmm.data.PossiblyImportedComplexType;
import de.fhdo.ddmm.data.PrimitiveType;
import de.fhdo.ddmm.data.Type;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

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
 *   <li>{@link de.fhdo.ddmm.data.impl.DataFieldImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.DataFieldImpl#isHidden <em>Hidden</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.DataFieldImpl#getComplexType <em>Complex Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.DataFieldImpl#getPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.DataFieldImpl#getDataStructure <em>Data Structure</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.DataFieldImpl#getListType <em>List Type</em>}</li>
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
     * The cached value of the '{@link #getComplexType() <em>Complex Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getComplexType()
     * @generated
     * @ordered
     */
    protected PossiblyImportedComplexType complexType;

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
    @Override
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
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
    @Override
    public boolean isHidden() {
        return hidden;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
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
    @Override
    public PossiblyImportedComplexType getComplexType() {
        return complexType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetComplexType(PossiblyImportedComplexType newComplexType, NotificationChain msgs) {
        PossiblyImportedComplexType oldComplexType = complexType;
        complexType = newComplexType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataPackage.DATA_FIELD__COMPLEX_TYPE, oldComplexType, newComplexType);
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
    public void setComplexType(PossiblyImportedComplexType newComplexType) {
        if (newComplexType != complexType) {
            NotificationChain msgs = null;
            if (complexType != null)
                msgs = ((InternalEObject)complexType).eInverseRemove(this, DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__DATA_FIELD, PossiblyImportedComplexType.class, msgs);
            if (newComplexType != null)
                msgs = ((InternalEObject)newComplexType).eInverseAdd(this, DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__DATA_FIELD, PossiblyImportedComplexType.class, msgs);
            msgs = basicSetComplexType(newComplexType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_FIELD__COMPLEX_TYPE, newComplexType, newComplexType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
    public ListType getListType() {
        if (eContainerFeatureID() != DataPackage.DATA_FIELD__LIST_TYPE) return null;
        return (ListType)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ListType basicGetListType() {
        if (eContainerFeatureID() != DataPackage.DATA_FIELD__LIST_TYPE) return null;
        return (ListType)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetListType(ListType newListType, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newListType, DataPackage.DATA_FIELD__LIST_TYPE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setListType(ListType newListType) {
        if (newListType != eInternalContainer() || (eContainerFeatureID() != DataPackage.DATA_FIELD__LIST_TYPE && newListType != null)) {
            if (EcoreUtil.isAncestor(this, newListType))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newListType != null)
                msgs = ((InternalEObject)newListType).eInverseAdd(this, DataPackage.LIST_TYPE__DATA_FIELDS, ListType.class, msgs);
            msgs = basicSetListType(newListType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_FIELD__LIST_TYPE, newListType, newListType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Type getEffectiveType() {
        PossiblyImportedComplexType _complexType = this.getComplexType();
        boolean _tripleNotEquals = (_complexType != null);
        if (_tripleNotEquals) {
            return this.getComplexType().getComplexType();
        }
        else {
            PrimitiveType _primitiveType = this.getPrimitiveType();
            boolean _tripleNotEquals_1 = (_primitiveType != null);
            if (_tripleNotEquals_1) {
                return this.getPrimitiveType();
            }
            else {
                return null;
            }
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
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
                ListType _listType = this.getListType();
                boolean _tripleNotEquals_1 = (_listType != null);
                if (_tripleNotEquals_1) {
                    nameParts.addAll(this.getListType().getQualifiedNameParts());
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
    @Override
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
    @Override
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
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case DataPackage.DATA_FIELD__COMPLEX_TYPE:
                if (complexType != null)
                    msgs = ((InternalEObject)complexType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataPackage.DATA_FIELD__COMPLEX_TYPE, null, msgs);
                return basicSetComplexType((PossiblyImportedComplexType)otherEnd, msgs);
            case DataPackage.DATA_FIELD__DATA_STRUCTURE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDataStructure((DataStructure)otherEnd, msgs);
            case DataPackage.DATA_FIELD__LIST_TYPE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetListType((ListType)otherEnd, msgs);
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
            case DataPackage.DATA_FIELD__COMPLEX_TYPE:
                return basicSetComplexType(null, msgs);
            case DataPackage.DATA_FIELD__PRIMITIVE_TYPE:
                return basicSetPrimitiveType(null, msgs);
            case DataPackage.DATA_FIELD__DATA_STRUCTURE:
                return basicSetDataStructure(null, msgs);
            case DataPackage.DATA_FIELD__LIST_TYPE:
                return basicSetListType(null, msgs);
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
            case DataPackage.DATA_FIELD__LIST_TYPE:
                return eInternalContainer().eInverseRemove(this, DataPackage.LIST_TYPE__DATA_FIELDS, ListType.class, msgs);
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
            case DataPackage.DATA_FIELD__COMPLEX_TYPE:
                return getComplexType();
            case DataPackage.DATA_FIELD__PRIMITIVE_TYPE:
                return getPrimitiveType();
            case DataPackage.DATA_FIELD__DATA_STRUCTURE:
                if (resolve) return getDataStructure();
                return basicGetDataStructure();
            case DataPackage.DATA_FIELD__LIST_TYPE:
                if (resolve) return getListType();
                return basicGetListType();
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
            case DataPackage.DATA_FIELD__NAME:
                setName((String)newValue);
                return;
            case DataPackage.DATA_FIELD__HIDDEN:
                setHidden((Boolean)newValue);
                return;
            case DataPackage.DATA_FIELD__COMPLEX_TYPE:
                setComplexType((PossiblyImportedComplexType)newValue);
                return;
            case DataPackage.DATA_FIELD__PRIMITIVE_TYPE:
                setPrimitiveType((PrimitiveType)newValue);
                return;
            case DataPackage.DATA_FIELD__DATA_STRUCTURE:
                setDataStructure((DataStructure)newValue);
                return;
            case DataPackage.DATA_FIELD__LIST_TYPE:
                setListType((ListType)newValue);
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
            case DataPackage.DATA_FIELD__COMPLEX_TYPE:
                setComplexType((PossiblyImportedComplexType)null);
                return;
            case DataPackage.DATA_FIELD__PRIMITIVE_TYPE:
                setPrimitiveType((PrimitiveType)null);
                return;
            case DataPackage.DATA_FIELD__DATA_STRUCTURE:
                setDataStructure((DataStructure)null);
                return;
            case DataPackage.DATA_FIELD__LIST_TYPE:
                setListType((ListType)null);
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
            case DataPackage.DATA_FIELD__COMPLEX_TYPE:
                return complexType != null;
            case DataPackage.DATA_FIELD__PRIMITIVE_TYPE:
                return primitiveType != null;
            case DataPackage.DATA_FIELD__DATA_STRUCTURE:
                return basicGetDataStructure() != null;
            case DataPackage.DATA_FIELD__LIST_TYPE:
                return basicGetListType() != null;
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
        result.append(')');
        return result.toString();
    }

} //DataFieldImpl
