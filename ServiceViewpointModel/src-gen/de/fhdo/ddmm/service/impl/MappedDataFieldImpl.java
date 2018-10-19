/**
 */
package de.fhdo.ddmm.service.impl;

import de.fhdo.ddmm.data.DataField;
import de.fhdo.ddmm.data.Type;

import de.fhdo.ddmm.service.ImportedServiceAspect;
import de.fhdo.ddmm.service.ImportedType;
import de.fhdo.ddmm.service.MappedDataField;
import de.fhdo.ddmm.service.Parameter;
import de.fhdo.ddmm.service.ServicePackage;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapped Data Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.impl.MappedDataFieldImpl#getDataField <em>Data Field</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MappedDataFieldImpl#getMappedType <em>Mapped Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MappedDataFieldImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MappedDataFieldImpl#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappedDataFieldImpl extends MinimalEObjectImpl.Container implements MappedDataField {
    /**
     * The cached value of the '{@link #getDataField() <em>Data Field</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataField()
     * @generated
     * @ordered
     */
    protected DataField dataField;

    /**
     * The cached value of the '{@link #getMappedType() <em>Mapped Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMappedType()
     * @generated
     * @ordered
     */
    protected ImportedType mappedType;

    /**
     * The cached value of the '{@link #getAspects() <em>Aspects</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAspects()
     * @generated
     * @ordered
     */
    protected EList<ImportedServiceAspect> aspects;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MappedDataFieldImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ServicePackage.Literals.MAPPED_DATA_FIELD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataField getDataField() {
        if (dataField != null && dataField.eIsProxy()) {
            InternalEObject oldDataField = (InternalEObject)dataField;
            dataField = (DataField)eResolveProxy(oldDataField);
            if (dataField != oldDataField) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicePackage.MAPPED_DATA_FIELD__DATA_FIELD, oldDataField, dataField));
            }
        }
        return dataField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataField basicGetDataField() {
        return dataField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataField(DataField newDataField) {
        DataField oldDataField = dataField;
        dataField = newDataField;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_DATA_FIELD__DATA_FIELD, oldDataField, dataField));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ImportedType getMappedType() {
        return mappedType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMappedType(ImportedType newMappedType, NotificationChain msgs) {
        ImportedType oldMappedType = mappedType;
        mappedType = newMappedType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_DATA_FIELD__MAPPED_TYPE, oldMappedType, newMappedType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMappedType(ImportedType newMappedType) {
        if (newMappedType != mappedType) {
            NotificationChain msgs = null;
            if (mappedType != null)
                msgs = ((InternalEObject)mappedType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicePackage.MAPPED_DATA_FIELD__MAPPED_TYPE, null, msgs);
            if (newMappedType != null)
                msgs = ((InternalEObject)newMappedType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServicePackage.MAPPED_DATA_FIELD__MAPPED_TYPE, null, msgs);
            msgs = basicSetMappedType(newMappedType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_DATA_FIELD__MAPPED_TYPE, newMappedType, newMappedType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ImportedServiceAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<ImportedServiceAspect>(ImportedServiceAspect.class, this, ServicePackage.MAPPED_DATA_FIELD__ASPECTS, ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_FIELD);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Parameter getParameter() {
        if (eContainerFeatureID() != ServicePackage.MAPPED_DATA_FIELD__PARAMETER) return null;
        return (Parameter)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Parameter basicGetParameter() {
        if (eContainerFeatureID() != ServicePackage.MAPPED_DATA_FIELD__PARAMETER) return null;
        return (Parameter)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParameter(Parameter newParameter, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newParameter, ServicePackage.MAPPED_DATA_FIELD__PARAMETER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParameter(Parameter newParameter) {
        if (newParameter != eInternalContainer() || (eContainerFeatureID() != ServicePackage.MAPPED_DATA_FIELD__PARAMETER && newParameter != null)) {
            if (EcoreUtil.isAncestor(this, newParameter))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParameter != null)
                msgs = ((InternalEObject)newParameter).eInverseAdd(this, ServicePackage.PARAMETER__MAPPED_DATA_FIELDS, Parameter.class, msgs);
            msgs = basicSetParameter(newParameter, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_DATA_FIELD__PARAMETER, newParameter, newParameter));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getQualifiedNameParts() {
        EList<String> _xblockexpression = null;
        {
            if (((this.getDataField() == null) || this.getDataField().getName().isEmpty())) {
                return ECollections.<String>asEList(CollectionLiterals.<String>newArrayList());
            }
            final EList<String> nameParts = this.getParameter().getQualifiedNameParts();
            CollectionExtensions.<String>addAll(nameParts, this.getDataField().getName());
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
    public Type getEffectiveType() {
        ImportedType _mappedType = this.getMappedType();
        boolean _tripleNotEquals = (_mappedType != null);
        if (_tripleNotEquals) {
            return this.getMappedType().getType();
        }
        else {
            DataField _dataField = this.getDataField();
            boolean _tripleNotEquals_1 = (_dataField != null);
            if (_tripleNotEquals_1) {
                return this.getDataField().getEffectiveType();
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
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ServicePackage.MAPPED_DATA_FIELD__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case ServicePackage.MAPPED_DATA_FIELD__PARAMETER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetParameter((Parameter)otherEnd, msgs);
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
            case ServicePackage.MAPPED_DATA_FIELD__MAPPED_TYPE:
                return basicSetMappedType(null, msgs);
            case ServicePackage.MAPPED_DATA_FIELD__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case ServicePackage.MAPPED_DATA_FIELD__PARAMETER:
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
            case ServicePackage.MAPPED_DATA_FIELD__PARAMETER:
                return eInternalContainer().eInverseRemove(this, ServicePackage.PARAMETER__MAPPED_DATA_FIELDS, Parameter.class, msgs);
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
            case ServicePackage.MAPPED_DATA_FIELD__DATA_FIELD:
                if (resolve) return getDataField();
                return basicGetDataField();
            case ServicePackage.MAPPED_DATA_FIELD__MAPPED_TYPE:
                return getMappedType();
            case ServicePackage.MAPPED_DATA_FIELD__ASPECTS:
                return getAspects();
            case ServicePackage.MAPPED_DATA_FIELD__PARAMETER:
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
            case ServicePackage.MAPPED_DATA_FIELD__DATA_FIELD:
                setDataField((DataField)newValue);
                return;
            case ServicePackage.MAPPED_DATA_FIELD__MAPPED_TYPE:
                setMappedType((ImportedType)newValue);
                return;
            case ServicePackage.MAPPED_DATA_FIELD__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends ImportedServiceAspect>)newValue);
                return;
            case ServicePackage.MAPPED_DATA_FIELD__PARAMETER:
                setParameter((Parameter)newValue);
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
            case ServicePackage.MAPPED_DATA_FIELD__DATA_FIELD:
                setDataField((DataField)null);
                return;
            case ServicePackage.MAPPED_DATA_FIELD__MAPPED_TYPE:
                setMappedType((ImportedType)null);
                return;
            case ServicePackage.MAPPED_DATA_FIELD__ASPECTS:
                getAspects().clear();
                return;
            case ServicePackage.MAPPED_DATA_FIELD__PARAMETER:
                setParameter((Parameter)null);
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
            case ServicePackage.MAPPED_DATA_FIELD__DATA_FIELD:
                return dataField != null;
            case ServicePackage.MAPPED_DATA_FIELD__MAPPED_TYPE:
                return mappedType != null;
            case ServicePackage.MAPPED_DATA_FIELD__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case ServicePackage.MAPPED_DATA_FIELD__PARAMETER:
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
    public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
        switch (operationID) {
            case ServicePackage.MAPPED_DATA_FIELD___GET_QUALIFIED_NAME_PARTS:
                return getQualifiedNameParts();
            case ServicePackage.MAPPED_DATA_FIELD___BUILD_QUALIFIED_NAME__STRING:
                return buildQualifiedName((String)arguments.get(0));
            case ServicePackage.MAPPED_DATA_FIELD___GET_EFFECTIVE_TYPE:
                return getEffectiveType();
        }
        return super.eInvoke(operationID, arguments);
    }

} //MappedDataFieldImpl
