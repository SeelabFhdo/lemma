/**
 */
package de.fhdo.lemma.service.impl;

import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.Enumeration;
import de.fhdo.lemma.data.EnumerationField;
import de.fhdo.lemma.data.Type;

import de.fhdo.lemma.service.ImportedServiceAspect;
import de.fhdo.lemma.service.ImportedType;
import de.fhdo.lemma.service.MappedComplexType;
import de.fhdo.lemma.service.MappedField;
import de.fhdo.lemma.service.Parameter;
import de.fhdo.lemma.service.ServicePackage;

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
 * An implementation of the model object '<em><b>Mapped Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedFieldImpl#getDataField <em>Data Field</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedFieldImpl#getEnumerationField <em>Enumeration Field</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedFieldImpl#getMappedType <em>Mapped Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedFieldImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedFieldImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedFieldImpl#getMappedComplexType <em>Mapped Complex Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedFieldImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappedFieldImpl extends MinimalEObjectImpl.Container implements MappedField {
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
     * The cached value of the '{@link #getEnumerationField() <em>Enumeration Field</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEnumerationField()
     * @generated
     * @ordered
     */
    protected EnumerationField enumerationField;

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
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MappedFieldImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ServicePackage.Literals.MAPPED_FIELD;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicePackage.MAPPED_FIELD__DATA_FIELD, oldDataField, dataField));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_FIELD__DATA_FIELD, oldDataField, dataField));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EnumerationField getEnumerationField() {
        if (enumerationField != null && enumerationField.eIsProxy()) {
            InternalEObject oldEnumerationField = (InternalEObject)enumerationField;
            enumerationField = (EnumerationField)eResolveProxy(oldEnumerationField);
            if (enumerationField != oldEnumerationField) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicePackage.MAPPED_FIELD__ENUMERATION_FIELD, oldEnumerationField, enumerationField));
            }
        }
        return enumerationField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EnumerationField basicGetEnumerationField() {
        return enumerationField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEnumerationField(EnumerationField newEnumerationField) {
        EnumerationField oldEnumerationField = enumerationField;
        enumerationField = newEnumerationField;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_FIELD__ENUMERATION_FIELD, oldEnumerationField, enumerationField));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_FIELD__MAPPED_TYPE, oldMappedType, newMappedType);
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
                msgs = ((InternalEObject)mappedType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicePackage.MAPPED_FIELD__MAPPED_TYPE, null, msgs);
            if (newMappedType != null)
                msgs = ((InternalEObject)newMappedType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServicePackage.MAPPED_FIELD__MAPPED_TYPE, null, msgs);
            msgs = basicSetMappedType(newMappedType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_FIELD__MAPPED_TYPE, newMappedType, newMappedType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ImportedServiceAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<ImportedServiceAspect>(ImportedServiceAspect.class, this, ServicePackage.MAPPED_FIELD__ASPECTS, ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_FIELD);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Parameter getParameter() {
        if (eContainerFeatureID() != ServicePackage.MAPPED_FIELD__PARAMETER) return null;
        return (Parameter)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Parameter basicGetParameter() {
        if (eContainerFeatureID() != ServicePackage.MAPPED_FIELD__PARAMETER) return null;
        return (Parameter)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParameter(Parameter newParameter, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newParameter, ServicePackage.MAPPED_FIELD__PARAMETER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParameter(Parameter newParameter) {
        if (newParameter != eInternalContainer() || (eContainerFeatureID() != ServicePackage.MAPPED_FIELD__PARAMETER && newParameter != null)) {
            if (EcoreUtil.isAncestor(this, newParameter))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParameter != null)
                msgs = ((InternalEObject)newParameter).eInverseAdd(this, ServicePackage.PARAMETER__MAPPED_FIELDS, Parameter.class, msgs);
            msgs = basicSetParameter(newParameter, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_FIELD__PARAMETER, newParameter, newParameter));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MappedComplexType getMappedComplexType() {
        if (eContainerFeatureID() != ServicePackage.MAPPED_FIELD__MAPPED_COMPLEX_TYPE) return null;
        return (MappedComplexType)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MappedComplexType basicGetMappedComplexType() {
        if (eContainerFeatureID() != ServicePackage.MAPPED_FIELD__MAPPED_COMPLEX_TYPE) return null;
        return (MappedComplexType)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMappedComplexType(MappedComplexType newMappedComplexType, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newMappedComplexType, ServicePackage.MAPPED_FIELD__MAPPED_COMPLEX_TYPE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMappedComplexType(MappedComplexType newMappedComplexType) {
        if (newMappedComplexType != eInternalContainer() || (eContainerFeatureID() != ServicePackage.MAPPED_FIELD__MAPPED_COMPLEX_TYPE && newMappedComplexType != null)) {
            if (EcoreUtil.isAncestor(this, newMappedComplexType))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newMappedComplexType != null)
                msgs = ((InternalEObject)newMappedComplexType).eInverseAdd(this, ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_FIELDS, MappedComplexType.class, msgs);
            msgs = basicSetMappedComplexType(newMappedComplexType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_FIELD__MAPPED_COMPLEX_TYPE, newMappedComplexType, newMappedComplexType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        String _xifexpression = null;
        DataField _dataField = this.getDataField();
        boolean _tripleNotEquals = (_dataField != null);
        if (_tripleNotEquals) {
            _xifexpression = this.getDataField().getName();
        }
        else {
            String _xifexpression_1 = null;
            EnumerationField _enumerationField = this.getEnumerationField();
            boolean _tripleNotEquals_1 = (_enumerationField != null);
            if (_tripleNotEquals_1) {
                _xifexpression_1 = this.getEnumerationField().getName();
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
    public EList<String> getQualifiedNameParts(final boolean withImportName) {
        EList<String> _xblockexpression = null;
        {
            if (((this.getName() == null) || this.getName().isEmpty())) {
                return ECollections.<String>asEList(CollectionLiterals.<String>newArrayList());
            }
            EList<String> _xifexpression = null;
            MappedComplexType _mappedComplexType = this.getMappedComplexType();
            boolean _tripleNotEquals = (_mappedComplexType != null);
            if (_tripleNotEquals) {
                _xifexpression = this.getMappedComplexType().getQualifiedNameParts(withImportName);
            }
            else {
                _xifexpression = this.getParameter().getQualifiedNameParts();
            }
            final EList<String> nameParts = _xifexpression;
            CollectionExtensions.<String>addAll(nameParts, this.getName());
            _xblockexpression = ECollections.<String>asEList(nameParts);
        }
        return _xblockexpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String buildQualifiedName(final String separator, final boolean withImportName) {
        if ((separator == null)) {
            return null;
        }
        String qualifiedName = "";
        EList<String> _qualifiedNameParts = this.getQualifiedNameParts(withImportName);
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
        Type _xifexpression = null;
        ImportedType _mappedType = this.getMappedType();
        boolean _tripleNotEquals = (_mappedType != null);
        if (_tripleNotEquals) {
            _xifexpression = this.getMappedType().getType();
        }
        else {
            Type _xifexpression_1 = null;
            DataField _dataField = this.getDataField();
            boolean _tripleNotEquals_1 = (_dataField != null);
            if (_tripleNotEquals_1) {
                _xifexpression_1 = this.getDataField().getEffectiveType();
            }
            else {
                Enumeration _xifexpression_2 = null;
                EnumerationField _enumerationField = this.getEnumerationField();
                boolean _tripleNotEquals_2 = (_enumerationField != null);
                if (_tripleNotEquals_2) {
                    _xifexpression_2 = this.getEnumerationField().getEnumeration();
                }
                else {
                    return null;
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
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ServicePackage.MAPPED_FIELD__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case ServicePackage.MAPPED_FIELD__PARAMETER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetParameter((Parameter)otherEnd, msgs);
            case ServicePackage.MAPPED_FIELD__MAPPED_COMPLEX_TYPE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetMappedComplexType((MappedComplexType)otherEnd, msgs);
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
            case ServicePackage.MAPPED_FIELD__MAPPED_TYPE:
                return basicSetMappedType(null, msgs);
            case ServicePackage.MAPPED_FIELD__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case ServicePackage.MAPPED_FIELD__PARAMETER:
                return basicSetParameter(null, msgs);
            case ServicePackage.MAPPED_FIELD__MAPPED_COMPLEX_TYPE:
                return basicSetMappedComplexType(null, msgs);
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
            case ServicePackage.MAPPED_FIELD__PARAMETER:
                return eInternalContainer().eInverseRemove(this, ServicePackage.PARAMETER__MAPPED_FIELDS, Parameter.class, msgs);
            case ServicePackage.MAPPED_FIELD__MAPPED_COMPLEX_TYPE:
                return eInternalContainer().eInverseRemove(this, ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_FIELDS, MappedComplexType.class, msgs);
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
            case ServicePackage.MAPPED_FIELD__DATA_FIELD:
                if (resolve) return getDataField();
                return basicGetDataField();
            case ServicePackage.MAPPED_FIELD__ENUMERATION_FIELD:
                if (resolve) return getEnumerationField();
                return basicGetEnumerationField();
            case ServicePackage.MAPPED_FIELD__MAPPED_TYPE:
                return getMappedType();
            case ServicePackage.MAPPED_FIELD__ASPECTS:
                return getAspects();
            case ServicePackage.MAPPED_FIELD__PARAMETER:
                if (resolve) return getParameter();
                return basicGetParameter();
            case ServicePackage.MAPPED_FIELD__MAPPED_COMPLEX_TYPE:
                if (resolve) return getMappedComplexType();
                return basicGetMappedComplexType();
            case ServicePackage.MAPPED_FIELD__NAME:
                return getName();
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
            case ServicePackage.MAPPED_FIELD__DATA_FIELD:
                setDataField((DataField)newValue);
                return;
            case ServicePackage.MAPPED_FIELD__ENUMERATION_FIELD:
                setEnumerationField((EnumerationField)newValue);
                return;
            case ServicePackage.MAPPED_FIELD__MAPPED_TYPE:
                setMappedType((ImportedType)newValue);
                return;
            case ServicePackage.MAPPED_FIELD__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends ImportedServiceAspect>)newValue);
                return;
            case ServicePackage.MAPPED_FIELD__PARAMETER:
                setParameter((Parameter)newValue);
                return;
            case ServicePackage.MAPPED_FIELD__MAPPED_COMPLEX_TYPE:
                setMappedComplexType((MappedComplexType)newValue);
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
            case ServicePackage.MAPPED_FIELD__DATA_FIELD:
                setDataField((DataField)null);
                return;
            case ServicePackage.MAPPED_FIELD__ENUMERATION_FIELD:
                setEnumerationField((EnumerationField)null);
                return;
            case ServicePackage.MAPPED_FIELD__MAPPED_TYPE:
                setMappedType((ImportedType)null);
                return;
            case ServicePackage.MAPPED_FIELD__ASPECTS:
                getAspects().clear();
                return;
            case ServicePackage.MAPPED_FIELD__PARAMETER:
                setParameter((Parameter)null);
                return;
            case ServicePackage.MAPPED_FIELD__MAPPED_COMPLEX_TYPE:
                setMappedComplexType((MappedComplexType)null);
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
            case ServicePackage.MAPPED_FIELD__DATA_FIELD:
                return dataField != null;
            case ServicePackage.MAPPED_FIELD__ENUMERATION_FIELD:
                return enumerationField != null;
            case ServicePackage.MAPPED_FIELD__MAPPED_TYPE:
                return mappedType != null;
            case ServicePackage.MAPPED_FIELD__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case ServicePackage.MAPPED_FIELD__PARAMETER:
                return basicGetParameter() != null;
            case ServicePackage.MAPPED_FIELD__MAPPED_COMPLEX_TYPE:
                return basicGetMappedComplexType() != null;
            case ServicePackage.MAPPED_FIELD__NAME:
                return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
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
            case ServicePackage.MAPPED_FIELD___GET_QUALIFIED_NAME_PARTS__BOOLEAN:
                return getQualifiedNameParts((Boolean)arguments.get(0));
            case ServicePackage.MAPPED_FIELD___BUILD_QUALIFIED_NAME__STRING_BOOLEAN:
                return buildQualifiedName((String)arguments.get(0), (Boolean)arguments.get(1));
            case ServicePackage.MAPPED_FIELD___GET_EFFECTIVE_TYPE:
                return getEffectiveType();
        }
        return super.eInvoke(operationID, arguments);
    }

} //MappedFieldImpl
