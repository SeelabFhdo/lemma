/**
 */
package de.fhdo.lemma.technology.impl;

import de.fhdo.lemma.data.PrimitiveType;

import de.fhdo.lemma.data.impl.PrimitiveTypeImpl;

import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.technology.TechnologyPackage;
import de.fhdo.lemma.technology.TechnologySpecificPrimitiveType;

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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specific Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologySpecificPrimitiveTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologySpecificPrimitiveTypeImpl#isDefault <em>Default</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologySpecificPrimitiveTypeImpl#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologySpecificPrimitiveTypeImpl#getBasicBuiltinPrimitiveTypes <em>Basic Builtin Primitive Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TechnologySpecificPrimitiveTypeImpl extends PrimitiveTypeImpl implements TechnologySpecificPrimitiveType {
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
     * The cached value of the '{@link #getBasicBuiltinPrimitiveTypes() <em>Basic Builtin Primitive Types</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBasicBuiltinPrimitiveTypes()
     * @generated
     * @ordered
     */
    protected EList<PrimitiveType> basicBuiltinPrimitiveTypes;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TechnologySpecificPrimitiveTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TechnologyPackage.Literals.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__DEFAULT, oldDefault, default_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Technology getTechnology() {
        if (eContainerFeatureID() != TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__TECHNOLOGY) return null;
        return (Technology)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Technology basicGetTechnology() {
        if (eContainerFeatureID() != TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__TECHNOLOGY) return null;
        return (Technology)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTechnology(Technology newTechnology, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newTechnology, TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__TECHNOLOGY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTechnology(Technology newTechnology) {
        if (newTechnology != eInternalContainer() || (eContainerFeatureID() != TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__TECHNOLOGY && newTechnology != null)) {
            if (EcoreUtil.isAncestor(this, newTechnology))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newTechnology != null)
                msgs = ((InternalEObject)newTechnology).eInverseAdd(this, TechnologyPackage.TECHNOLOGY__PRIMITIVE_TYPES, Technology.class, msgs);
            msgs = basicSetTechnology(newTechnology, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__TECHNOLOGY, newTechnology, newTechnology));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PrimitiveType> getBasicBuiltinPrimitiveTypes() {
        if (basicBuiltinPrimitiveTypes == null) {
            basicBuiltinPrimitiveTypes = new EObjectContainmentEList<PrimitiveType>(PrimitiveType.class, this, TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__BASIC_BUILTIN_PRIMITIVE_TYPES);
        }
        return basicBuiltinPrimitiveTypes;
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
            nameParts.add("_types");
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
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__TECHNOLOGY:
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
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__TECHNOLOGY:
                return basicSetTechnology(null, msgs);
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__BASIC_BUILTIN_PRIMITIVE_TYPES:
                return ((InternalEList<?>)getBasicBuiltinPrimitiveTypes()).basicRemove(otherEnd, msgs);
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
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__TECHNOLOGY:
                return eInternalContainer().eInverseRemove(this, TechnologyPackage.TECHNOLOGY__PRIMITIVE_TYPES, Technology.class, msgs);
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
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__NAME:
                return getName();
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__DEFAULT:
                return isDefault();
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__TECHNOLOGY:
                if (resolve) return getTechnology();
                return basicGetTechnology();
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__BASIC_BUILTIN_PRIMITIVE_TYPES:
                return getBasicBuiltinPrimitiveTypes();
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
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__NAME:
                setName((String)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__DEFAULT:
                setDefault((Boolean)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__TECHNOLOGY:
                setTechnology((Technology)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__BASIC_BUILTIN_PRIMITIVE_TYPES:
                getBasicBuiltinPrimitiveTypes().clear();
                getBasicBuiltinPrimitiveTypes().addAll((Collection<? extends PrimitiveType>)newValue);
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
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__DEFAULT:
                setDefault(DEFAULT_EDEFAULT);
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__TECHNOLOGY:
                setTechnology((Technology)null);
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__BASIC_BUILTIN_PRIMITIVE_TYPES:
                getBasicBuiltinPrimitiveTypes().clear();
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
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__DEFAULT:
                return default_ != DEFAULT_EDEFAULT;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__TECHNOLOGY:
                return basicGetTechnology() != null;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE__BASIC_BUILTIN_PRIMITIVE_TYPES:
                return basicBuiltinPrimitiveTypes != null && !basicBuiltinPrimitiveTypes.isEmpty();
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
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE___GET_QUALIFIED_NAME_PARTS:
                return getQualifiedNameParts();
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PRIMITIVE_TYPE___BUILD_QUALIFIED_NAME__STRING:
                return buildQualifiedName((String)arguments.get(0));
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
        result.append(", default: ");
        result.append(default_);
        result.append(')');
        return result.toString();
    }

} //TechnologySpecificPrimitiveTypeImpl
