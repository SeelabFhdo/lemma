/**
 */
package de.fhdo.lemma.technology.impl;

import de.fhdo.lemma.technology.CommunicationType;
import de.fhdo.lemma.technology.DataFormat;
import de.fhdo.lemma.technology.Protocol;
import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.technology.TechnologyPackage;

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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Protocol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.impl.ProtocolImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ProtocolImpl#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ProtocolImpl#isDefault <em>Default</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ProtocolImpl#getDefaultFormat <em>Default Format</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ProtocolImpl#getDataFormats <em>Data Formats</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ProtocolImpl#getTechnology <em>Technology</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProtocolImpl extends MinimalEObjectImpl.Container implements Protocol {
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
     * The default value of the '{@link #getCommunicationType() <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCommunicationType()
     * @generated
     * @ordered
     */
    protected static final CommunicationType COMMUNICATION_TYPE_EDEFAULT = CommunicationType.SYNCHRONOUS;

    /**
     * The cached value of the '{@link #getCommunicationType() <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCommunicationType()
     * @generated
     * @ordered
     */
    protected CommunicationType communicationType = COMMUNICATION_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #isDefault() <em>Default</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDefault()
     * @generated
     * @ordered
     */
    protected static final boolean DEFAULT_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDefault() <em>Default</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDefault()
     * @generated
     * @ordered
     */
    protected boolean default_ = DEFAULT_EDEFAULT;

    /**
     * The cached value of the '{@link #getDefaultFormat() <em>Default Format</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultFormat()
     * @generated
     * @ordered
     */
    protected DataFormat defaultFormat;

    /**
     * The cached value of the '{@link #getDataFormats() <em>Data Formats</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataFormats()
     * @generated
     * @ordered
     */
    protected EList<DataFormat> dataFormats;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ProtocolImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TechnologyPackage.Literals.PROTOCOL;
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
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.PROTOCOL__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CommunicationType getCommunicationType() {
        return communicationType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCommunicationType(CommunicationType newCommunicationType) {
        CommunicationType oldCommunicationType = communicationType;
        communicationType = newCommunicationType == null ? COMMUNICATION_TYPE_EDEFAULT : newCommunicationType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.PROTOCOL__COMMUNICATION_TYPE, oldCommunicationType, communicationType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isDefault() {
        return default_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefault(boolean newDefault) {
        boolean oldDefault = default_;
        default_ = newDefault;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.PROTOCOL__DEFAULT, oldDefault, default_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataFormat getDefaultFormat() {
        if (defaultFormat != null && defaultFormat.eIsProxy()) {
            InternalEObject oldDefaultFormat = (InternalEObject)defaultFormat;
            defaultFormat = (DataFormat)eResolveProxy(oldDefaultFormat);
            if (defaultFormat != oldDefaultFormat) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TechnologyPackage.PROTOCOL__DEFAULT_FORMAT, oldDefaultFormat, defaultFormat));
            }
        }
        return defaultFormat;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataFormat basicGetDefaultFormat() {
        return defaultFormat;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultFormat(DataFormat newDefaultFormat) {
        DataFormat oldDefaultFormat = defaultFormat;
        defaultFormat = newDefaultFormat;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.PROTOCOL__DEFAULT_FORMAT, oldDefaultFormat, defaultFormat));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<DataFormat> getDataFormats() {
        if (dataFormats == null) {
            dataFormats = new EObjectContainmentWithInverseEList<DataFormat>(DataFormat.class, this, TechnologyPackage.PROTOCOL__DATA_FORMATS, TechnologyPackage.DATA_FORMAT__PROTOCOL);
        }
        return dataFormats;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Technology getTechnology() {
        if (eContainerFeatureID() != TechnologyPackage.PROTOCOL__TECHNOLOGY) return null;
        return (Technology)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Technology basicGetTechnology() {
        if (eContainerFeatureID() != TechnologyPackage.PROTOCOL__TECHNOLOGY) return null;
        return (Technology)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTechnology(Technology newTechnology, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newTechnology, TechnologyPackage.PROTOCOL__TECHNOLOGY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTechnology(Technology newTechnology) {
        if (newTechnology != eInternalContainer() || (eContainerFeatureID() != TechnologyPackage.PROTOCOL__TECHNOLOGY && newTechnology != null)) {
            if (EcoreUtil.isAncestor(this, newTechnology))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newTechnology != null)
                msgs = ((InternalEObject)newTechnology).eInverseAdd(this, TechnologyPackage.TECHNOLOGY__PROTOCOLS, Technology.class, msgs);
            msgs = basicSetTechnology(newTechnology, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.PROTOCOL__TECHNOLOGY, newTechnology, newTechnology));
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
            nameParts.add("_protocols");
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
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TechnologyPackage.PROTOCOL__DATA_FORMATS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getDataFormats()).basicAdd(otherEnd, msgs);
            case TechnologyPackage.PROTOCOL__TECHNOLOGY:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetTechnology((Technology)otherEnd, msgs);
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
            case TechnologyPackage.PROTOCOL__DATA_FORMATS:
                return ((InternalEList<?>)getDataFormats()).basicRemove(otherEnd, msgs);
            case TechnologyPackage.PROTOCOL__TECHNOLOGY:
                return basicSetTechnology(null, msgs);
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
            case TechnologyPackage.PROTOCOL__TECHNOLOGY:
                return eInternalContainer().eInverseRemove(this, TechnologyPackage.TECHNOLOGY__PROTOCOLS, Technology.class, msgs);
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
            case TechnologyPackage.PROTOCOL__NAME:
                return getName();
            case TechnologyPackage.PROTOCOL__COMMUNICATION_TYPE:
                return getCommunicationType();
            case TechnologyPackage.PROTOCOL__DEFAULT:
                return isDefault();
            case TechnologyPackage.PROTOCOL__DEFAULT_FORMAT:
                if (resolve) return getDefaultFormat();
                return basicGetDefaultFormat();
            case TechnologyPackage.PROTOCOL__DATA_FORMATS:
                return getDataFormats();
            case TechnologyPackage.PROTOCOL__TECHNOLOGY:
                if (resolve) return getTechnology();
                return basicGetTechnology();
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
            case TechnologyPackage.PROTOCOL__NAME:
                setName((String)newValue);
                return;
            case TechnologyPackage.PROTOCOL__COMMUNICATION_TYPE:
                setCommunicationType((CommunicationType)newValue);
                return;
            case TechnologyPackage.PROTOCOL__DEFAULT:
                setDefault((Boolean)newValue);
                return;
            case TechnologyPackage.PROTOCOL__DEFAULT_FORMAT:
                setDefaultFormat((DataFormat)newValue);
                return;
            case TechnologyPackage.PROTOCOL__DATA_FORMATS:
                getDataFormats().clear();
                getDataFormats().addAll((Collection<? extends DataFormat>)newValue);
                return;
            case TechnologyPackage.PROTOCOL__TECHNOLOGY:
                setTechnology((Technology)newValue);
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
            case TechnologyPackage.PROTOCOL__NAME:
                setName(NAME_EDEFAULT);
                return;
            case TechnologyPackage.PROTOCOL__COMMUNICATION_TYPE:
                setCommunicationType(COMMUNICATION_TYPE_EDEFAULT);
                return;
            case TechnologyPackage.PROTOCOL__DEFAULT:
                setDefault(DEFAULT_EDEFAULT);
                return;
            case TechnologyPackage.PROTOCOL__DEFAULT_FORMAT:
                setDefaultFormat((DataFormat)null);
                return;
            case TechnologyPackage.PROTOCOL__DATA_FORMATS:
                getDataFormats().clear();
                return;
            case TechnologyPackage.PROTOCOL__TECHNOLOGY:
                setTechnology((Technology)null);
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
            case TechnologyPackage.PROTOCOL__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case TechnologyPackage.PROTOCOL__COMMUNICATION_TYPE:
                return communicationType != COMMUNICATION_TYPE_EDEFAULT;
            case TechnologyPackage.PROTOCOL__DEFAULT:
                return default_ != DEFAULT_EDEFAULT;
            case TechnologyPackage.PROTOCOL__DEFAULT_FORMAT:
                return defaultFormat != null;
            case TechnologyPackage.PROTOCOL__DATA_FORMATS:
                return dataFormats != null && !dataFormats.isEmpty();
            case TechnologyPackage.PROTOCOL__TECHNOLOGY:
                return basicGetTechnology() != null;
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
            case TechnologyPackage.PROTOCOL___GET_QUALIFIED_NAME_PARTS:
                return getQualifiedNameParts();
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
        result.append(", communicationType: ");
        result.append(communicationType);
        result.append(", default: ");
        result.append(default_);
        result.append(')');
        return result.toString();
    }

} //ProtocolImpl
