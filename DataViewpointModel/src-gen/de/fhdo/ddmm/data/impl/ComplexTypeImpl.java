/**
 */
package de.fhdo.ddmm.data.impl;

import de.fhdo.ddmm.data.ComplexType;
import de.fhdo.ddmm.data.Context;
import de.fhdo.ddmm.data.DataField;
import de.fhdo.ddmm.data.DataModel;
import de.fhdo.ddmm.data.DataPackage;
import de.fhdo.ddmm.data.DataStructure;
import de.fhdo.ddmm.data.Enumeration;
import de.fhdo.ddmm.data.ListType;
import de.fhdo.ddmm.data.PrimitiveType;
import de.fhdo.ddmm.data.Type;
import de.fhdo.ddmm.data.Version;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.data.impl.ComplexTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.ComplexTypeImpl#getDataModel <em>Data Model</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.ComplexTypeImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.ComplexTypeImpl#getContext <em>Context</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.ComplexTypeImpl#isIsStructure <em>Is Structure</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.ComplexTypeImpl#isIsPrimitiveList <em>Is Primitive List</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.ComplexTypeImpl#isIsStructuredList <em>Is Structured List</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.ComplexTypeImpl#isIsEnumeration <em>Is Enumeration</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ComplexTypeImpl extends TypeImpl implements ComplexType {
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
     * The default value of the '{@link #isIsStructure() <em>Is Structure</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsStructure()
     * @generated
     * @ordered
     */
    protected static final boolean IS_STRUCTURE_EDEFAULT = false;

    /**
     * The default value of the '{@link #isIsPrimitiveList() <em>Is Primitive List</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsPrimitiveList()
     * @generated
     * @ordered
     */
    protected static final boolean IS_PRIMITIVE_LIST_EDEFAULT = false;

    /**
     * The default value of the '{@link #isIsStructuredList() <em>Is Structured List</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsStructuredList()
     * @generated
     * @ordered
     */
    protected static final boolean IS_STRUCTURED_LIST_EDEFAULT = false;

    /**
     * The default value of the '{@link #isIsEnumeration() <em>Is Enumeration</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsEnumeration()
     * @generated
     * @ordered
     */
    protected static final boolean IS_ENUMERATION_EDEFAULT = false;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ComplexTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DataPackage.Literals.COMPLEX_TYPE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.COMPLEX_TYPE__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DataModel getDataModel() {
        if (eContainerFeatureID() != DataPackage.COMPLEX_TYPE__DATA_MODEL) return null;
        return (DataModel)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataModel basicGetDataModel() {
        if (eContainerFeatureID() != DataPackage.COMPLEX_TYPE__DATA_MODEL) return null;
        return (DataModel)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDataModel(DataModel newDataModel, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDataModel, DataPackage.COMPLEX_TYPE__DATA_MODEL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDataModel(DataModel newDataModel) {
        if (newDataModel != eInternalContainer() || (eContainerFeatureID() != DataPackage.COMPLEX_TYPE__DATA_MODEL && newDataModel != null)) {
            if (EcoreUtil.isAncestor(this, newDataModel))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDataModel != null)
                msgs = ((InternalEObject)newDataModel).eInverseAdd(this, DataPackage.DATA_MODEL__COMPLEX_TYPES, DataModel.class, msgs);
            msgs = basicSetDataModel(newDataModel, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.COMPLEX_TYPE__DATA_MODEL, newDataModel, newDataModel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Version getVersion() {
        if (eContainerFeatureID() != DataPackage.COMPLEX_TYPE__VERSION) return null;
        return (Version)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Version basicGetVersion() {
        if (eContainerFeatureID() != DataPackage.COMPLEX_TYPE__VERSION) return null;
        return (Version)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetVersion(Version newVersion, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newVersion, DataPackage.COMPLEX_TYPE__VERSION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setVersion(Version newVersion) {
        if (newVersion != eInternalContainer() || (eContainerFeatureID() != DataPackage.COMPLEX_TYPE__VERSION && newVersion != null)) {
            if (EcoreUtil.isAncestor(this, newVersion))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newVersion != null)
                msgs = ((InternalEObject)newVersion).eInverseAdd(this, DataPackage.VERSION__COMPLEX_TYPES, Version.class, msgs);
            msgs = basicSetVersion(newVersion, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.COMPLEX_TYPE__VERSION, newVersion, newVersion));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Context getContext() {
        if (eContainerFeatureID() != DataPackage.COMPLEX_TYPE__CONTEXT) return null;
        return (Context)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Context basicGetContext() {
        if (eContainerFeatureID() != DataPackage.COMPLEX_TYPE__CONTEXT) return null;
        return (Context)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetContext(Context newContext, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newContext, DataPackage.COMPLEX_TYPE__CONTEXT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setContext(Context newContext) {
        if (newContext != eInternalContainer() || (eContainerFeatureID() != DataPackage.COMPLEX_TYPE__CONTEXT && newContext != null)) {
            if (EcoreUtil.isAncestor(this, newContext))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newContext != null)
                msgs = ((InternalEObject)newContext).eInverseAdd(this, DataPackage.CONTEXT__COMPLEX_TYPES, Context.class, msgs);
            msgs = basicSetContext(newContext, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.COMPLEX_TYPE__CONTEXT, newContext, newContext));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isIsStructure() {
        return (this instanceof DataStructure);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isIsPrimitiveList() {
        if ((!(this instanceof ListType))) {
            return false;
        }
        PrimitiveType _primitiveType = ((ListType) this).getPrimitiveType();
        return (_primitiveType != null);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isIsStructuredList() {
        if ((!(this instanceof ListType))) {
            return false;
        }
        return ((((ListType) this).getDataFields() != null) && 
            (!((ListType) this).getDataFields().isEmpty()));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isIsEnumeration() {
        return (this instanceof Enumeration);
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
            Version _version = this.getVersion();
            boolean _tripleNotEquals = (_version != null);
            if (_tripleNotEquals) {
                nameParts.addAll(this.getVersion().getQualifiedNameParts());
            }
            Context _context = this.getContext();
            boolean _tripleNotEquals_1 = (_context != null);
            if (_tripleNotEquals_1) {
                nameParts.addAll(this.getContext().getQualifiedNameParts());
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
    public int compareFieldCounts(final EList<DataField> fields, final EList<DataField> fieldsToCompare) {
        if (((fields == null) && (fieldsToCompare == null))) {
            return 0;
        }
        else {
            if ((fields == null)) {
                return (-1);
            }
            else {
                if ((fieldsToCompare == null)) {
                    return 1;
                }
            }
        }
        final Function1<DataField, Boolean> _function = new Function1<DataField, Boolean>() {
            public Boolean apply(final DataField it) {
                Type _effectiveType = it.getEffectiveType();
                return Boolean.valueOf((_effectiveType instanceof PrimitiveType));
            }
        };
        final int fieldsPrimitiveCounts = ((Object[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(IterableExtensions.<DataField>filter(fields, _function), Object.class)).length;
        final Function1<DataField, Boolean> _function_1 = new Function1<DataField, Boolean>() {
            public Boolean apply(final DataField it) {
                Type _effectiveType = it.getEffectiveType();
                return Boolean.valueOf((_effectiveType instanceof DataStructure));
            }
        };
        final int fieldsStructureCounts = ((Object[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(IterableExtensions.<DataField>filter(fields, _function_1), Object.class)).length;
        final Function1<DataField, Boolean> _function_2 = new Function1<DataField, Boolean>() {
            public Boolean apply(final DataField it) {
                Type _effectiveType = it.getEffectiveType();
                return Boolean.valueOf((_effectiveType instanceof ListType));
            }
        };
        final int fieldsListCounts = ((Object[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(IterableExtensions.<DataField>filter(fields, _function_2), Object.class)).length;
        final Function1<DataField, Boolean> _function_3 = new Function1<DataField, Boolean>() {
            public Boolean apply(final DataField it) {
                Type _effectiveType = it.getEffectiveType();
                return Boolean.valueOf((_effectiveType instanceof PrimitiveType));
            }
        };
        final int primitiveCountsToCompare = ((Object[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(IterableExtensions.<DataField>filter(fieldsToCompare, _function_3), Object.class)).length;
        final Function1<DataField, Boolean> _function_4 = new Function1<DataField, Boolean>() {
            public Boolean apply(final DataField it) {
                Type _effectiveType = it.getEffectiveType();
                return Boolean.valueOf((_effectiveType instanceof DataStructure));
            }
        };
        final int structureCountsToCompare = ((Object[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(IterableExtensions.<DataField>filter(fieldsToCompare, _function_4), Object.class)).length;
        final Function1<DataField, Boolean> _function_5 = new Function1<DataField, Boolean>() {
            public Boolean apply(final DataField it) {
                Type _effectiveType = it.getEffectiveType();
                return Boolean.valueOf((_effectiveType instanceof ListType));
            }
        };
        final int listCountsToCompare = ((Object[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(IterableExtensions.<DataField>filter(fieldsToCompare, _function_5), Object.class)).length;
        if ((((fieldsPrimitiveCounts == primitiveCountsToCompare) && 
            (fieldsStructureCounts == structureCountsToCompare)) && 
            (fieldsListCounts == listCountsToCompare))) {
            return 0;
        }
        else {
            if ((((fieldsPrimitiveCounts >= primitiveCountsToCompare) && 
                (fieldsStructureCounts >= structureCountsToCompare)) && 
                (fieldsListCounts >= listCountsToCompare))) {
                return 1;
            }
        }
        return (-1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case DataPackage.COMPLEX_TYPE__DATA_MODEL:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDataModel((DataModel)otherEnd, msgs);
            case DataPackage.COMPLEX_TYPE__VERSION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetVersion((Version)otherEnd, msgs);
            case DataPackage.COMPLEX_TYPE__CONTEXT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetContext((Context)otherEnd, msgs);
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
            case DataPackage.COMPLEX_TYPE__DATA_MODEL:
                return basicSetDataModel(null, msgs);
            case DataPackage.COMPLEX_TYPE__VERSION:
                return basicSetVersion(null, msgs);
            case DataPackage.COMPLEX_TYPE__CONTEXT:
                return basicSetContext(null, msgs);
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
            case DataPackage.COMPLEX_TYPE__DATA_MODEL:
                return eInternalContainer().eInverseRemove(this, DataPackage.DATA_MODEL__COMPLEX_TYPES, DataModel.class, msgs);
            case DataPackage.COMPLEX_TYPE__VERSION:
                return eInternalContainer().eInverseRemove(this, DataPackage.VERSION__COMPLEX_TYPES, Version.class, msgs);
            case DataPackage.COMPLEX_TYPE__CONTEXT:
                return eInternalContainer().eInverseRemove(this, DataPackage.CONTEXT__COMPLEX_TYPES, Context.class, msgs);
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
            case DataPackage.COMPLEX_TYPE__NAME:
                return getName();
            case DataPackage.COMPLEX_TYPE__DATA_MODEL:
                if (resolve) return getDataModel();
                return basicGetDataModel();
            case DataPackage.COMPLEX_TYPE__VERSION:
                if (resolve) return getVersion();
                return basicGetVersion();
            case DataPackage.COMPLEX_TYPE__CONTEXT:
                if (resolve) return getContext();
                return basicGetContext();
            case DataPackage.COMPLEX_TYPE__IS_STRUCTURE:
                return isIsStructure();
            case DataPackage.COMPLEX_TYPE__IS_PRIMITIVE_LIST:
                return isIsPrimitiveList();
            case DataPackage.COMPLEX_TYPE__IS_STRUCTURED_LIST:
                return isIsStructuredList();
            case DataPackage.COMPLEX_TYPE__IS_ENUMERATION:
                return isIsEnumeration();
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
            case DataPackage.COMPLEX_TYPE__NAME:
                setName((String)newValue);
                return;
            case DataPackage.COMPLEX_TYPE__DATA_MODEL:
                setDataModel((DataModel)newValue);
                return;
            case DataPackage.COMPLEX_TYPE__VERSION:
                setVersion((Version)newValue);
                return;
            case DataPackage.COMPLEX_TYPE__CONTEXT:
                setContext((Context)newValue);
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
            case DataPackage.COMPLEX_TYPE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case DataPackage.COMPLEX_TYPE__DATA_MODEL:
                setDataModel((DataModel)null);
                return;
            case DataPackage.COMPLEX_TYPE__VERSION:
                setVersion((Version)null);
                return;
            case DataPackage.COMPLEX_TYPE__CONTEXT:
                setContext((Context)null);
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
            case DataPackage.COMPLEX_TYPE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case DataPackage.COMPLEX_TYPE__DATA_MODEL:
                return basicGetDataModel() != null;
            case DataPackage.COMPLEX_TYPE__VERSION:
                return basicGetVersion() != null;
            case DataPackage.COMPLEX_TYPE__CONTEXT:
                return basicGetContext() != null;
            case DataPackage.COMPLEX_TYPE__IS_STRUCTURE:
                return isIsStructure() != IS_STRUCTURE_EDEFAULT;
            case DataPackage.COMPLEX_TYPE__IS_PRIMITIVE_LIST:
                return isIsPrimitiveList() != IS_PRIMITIVE_LIST_EDEFAULT;
            case DataPackage.COMPLEX_TYPE__IS_STRUCTURED_LIST:
                return isIsStructuredList() != IS_STRUCTURED_LIST_EDEFAULT;
            case DataPackage.COMPLEX_TYPE__IS_ENUMERATION:
                return isIsEnumeration() != IS_ENUMERATION_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
        switch (operationID) {
            case DataPackage.COMPLEX_TYPE___GET_QUALIFIED_NAME_PARTS:
                return getQualifiedNameParts();
            case DataPackage.COMPLEX_TYPE___BUILD_QUALIFIED_NAME__STRING:
                return buildQualifiedName((String)arguments.get(0));
            case DataPackage.COMPLEX_TYPE___COMPARE_FIELD_COUNTS__ELIST_ELIST:
                return compareFieldCounts((EList<DataField>)arguments.get(0), (EList<DataField>)arguments.get(1));
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
        result.append(')');
        return result.toString();
    }

} //ComplexTypeImpl
