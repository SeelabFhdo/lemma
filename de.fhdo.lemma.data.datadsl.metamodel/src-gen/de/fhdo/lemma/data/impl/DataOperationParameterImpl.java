/**
 */
package de.fhdo.lemma.data.impl;

import de.fhdo.lemma.data.DataOperation;
import de.fhdo.lemma.data.DataOperationParameter;
import de.fhdo.lemma.data.DataPackage;
import de.fhdo.lemma.data.PossiblyImportedComplexType;
import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.data.Type;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.impl.DataOperationParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataOperationParameterImpl#getComplexType <em>Complex Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataOperationParameterImpl#getPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataOperationParameterImpl#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataOperationParameterImpl extends MinimalEObjectImpl.Container implements DataOperationParameter {
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
    protected DataOperationParameterImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DataPackage.Literals.DATA_OPERATION_PARAMETER;
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
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_OPERATION_PARAMETER__NAME, oldName, name));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataPackage.DATA_OPERATION_PARAMETER__COMPLEX_TYPE, oldComplexType, newComplexType);
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
                msgs = ((InternalEObject)complexType).eInverseRemove(this, DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__PARAMETER, PossiblyImportedComplexType.class, msgs);
            if (newComplexType != null)
                msgs = ((InternalEObject)newComplexType).eInverseAdd(this, DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__PARAMETER, PossiblyImportedComplexType.class, msgs);
            msgs = basicSetComplexType(newComplexType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_OPERATION_PARAMETER__COMPLEX_TYPE, newComplexType, newComplexType));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataPackage.DATA_OPERATION_PARAMETER__PRIMITIVE_TYPE, oldPrimitiveType, newPrimitiveType);
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
                msgs = ((InternalEObject)primitiveType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataPackage.DATA_OPERATION_PARAMETER__PRIMITIVE_TYPE, null, msgs);
            if (newPrimitiveType != null)
                msgs = ((InternalEObject)newPrimitiveType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataPackage.DATA_OPERATION_PARAMETER__PRIMITIVE_TYPE, null, msgs);
            msgs = basicSetPrimitiveType(newPrimitiveType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_OPERATION_PARAMETER__PRIMITIVE_TYPE, newPrimitiveType, newPrimitiveType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DataOperation getOperation() {
        if (eContainerFeatureID() != DataPackage.DATA_OPERATION_PARAMETER__OPERATION) return null;
        return (DataOperation)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataOperation basicGetOperation() {
        if (eContainerFeatureID() != DataPackage.DATA_OPERATION_PARAMETER__OPERATION) return null;
        return (DataOperation)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOperation(DataOperation newOperation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOperation, DataPackage.DATA_OPERATION_PARAMETER__OPERATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setOperation(DataOperation newOperation) {
        if (newOperation != eInternalContainer() || (eContainerFeatureID() != DataPackage.DATA_OPERATION_PARAMETER__OPERATION && newOperation != null)) {
            if (EcoreUtil.isAncestor(this, newOperation))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOperation != null)
                msgs = ((InternalEObject)newOperation).eInverseAdd(this, DataPackage.DATA_OPERATION__PARAMETERS, DataOperation.class, msgs);
            msgs = basicSetOperation(newOperation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_OPERATION_PARAMETER__OPERATION, newOperation, newOperation));
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
            final EList<String> nameParts = this.getOperation().getQualifiedNameParts();
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
    public Type getEffectiveType() {
        PrimitiveType _primitiveType = this.getPrimitiveType();
        boolean _tripleNotEquals = (_primitiveType != null);
        if (_tripleNotEquals) {
            return this.getPrimitiveType();
        }
        else {
            if (((this.getComplexType() != null) && (this.getComplexType().getComplexType() != null))) {
                return this.getComplexType().getComplexType();
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
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case DataPackage.DATA_OPERATION_PARAMETER__COMPLEX_TYPE:
                if (complexType != null)
                    msgs = ((InternalEObject)complexType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataPackage.DATA_OPERATION_PARAMETER__COMPLEX_TYPE, null, msgs);
                return basicSetComplexType((PossiblyImportedComplexType)otherEnd, msgs);
            case DataPackage.DATA_OPERATION_PARAMETER__OPERATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOperation((DataOperation)otherEnd, msgs);
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
            case DataPackage.DATA_OPERATION_PARAMETER__COMPLEX_TYPE:
                return basicSetComplexType(null, msgs);
            case DataPackage.DATA_OPERATION_PARAMETER__PRIMITIVE_TYPE:
                return basicSetPrimitiveType(null, msgs);
            case DataPackage.DATA_OPERATION_PARAMETER__OPERATION:
                return basicSetOperation(null, msgs);
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
            case DataPackage.DATA_OPERATION_PARAMETER__OPERATION:
                return eInternalContainer().eInverseRemove(this, DataPackage.DATA_OPERATION__PARAMETERS, DataOperation.class, msgs);
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
            case DataPackage.DATA_OPERATION_PARAMETER__NAME:
                return getName();
            case DataPackage.DATA_OPERATION_PARAMETER__COMPLEX_TYPE:
                return getComplexType();
            case DataPackage.DATA_OPERATION_PARAMETER__PRIMITIVE_TYPE:
                return getPrimitiveType();
            case DataPackage.DATA_OPERATION_PARAMETER__OPERATION:
                if (resolve) return getOperation();
                return basicGetOperation();
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
            case DataPackage.DATA_OPERATION_PARAMETER__NAME:
                setName((String)newValue);
                return;
            case DataPackage.DATA_OPERATION_PARAMETER__COMPLEX_TYPE:
                setComplexType((PossiblyImportedComplexType)newValue);
                return;
            case DataPackage.DATA_OPERATION_PARAMETER__PRIMITIVE_TYPE:
                setPrimitiveType((PrimitiveType)newValue);
                return;
            case DataPackage.DATA_OPERATION_PARAMETER__OPERATION:
                setOperation((DataOperation)newValue);
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
            case DataPackage.DATA_OPERATION_PARAMETER__NAME:
                setName(NAME_EDEFAULT);
                return;
            case DataPackage.DATA_OPERATION_PARAMETER__COMPLEX_TYPE:
                setComplexType((PossiblyImportedComplexType)null);
                return;
            case DataPackage.DATA_OPERATION_PARAMETER__PRIMITIVE_TYPE:
                setPrimitiveType((PrimitiveType)null);
                return;
            case DataPackage.DATA_OPERATION_PARAMETER__OPERATION:
                setOperation((DataOperation)null);
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
            case DataPackage.DATA_OPERATION_PARAMETER__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case DataPackage.DATA_OPERATION_PARAMETER__COMPLEX_TYPE:
                return complexType != null;
            case DataPackage.DATA_OPERATION_PARAMETER__PRIMITIVE_TYPE:
                return primitiveType != null;
            case DataPackage.DATA_OPERATION_PARAMETER__OPERATION:
                return basicGetOperation() != null;
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
            case DataPackage.DATA_OPERATION_PARAMETER___GET_QUALIFIED_NAME_PARTS:
                return getQualifiedNameParts();
            case DataPackage.DATA_OPERATION_PARAMETER___BUILD_QUALIFIED_NAME__STRING:
                return buildQualifiedName((String)arguments.get(0));
            case DataPackage.DATA_OPERATION_PARAMETER___GET_EFFECTIVE_TYPE:
                return getEffectiveType();
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

} //DataOperationParameterImpl
