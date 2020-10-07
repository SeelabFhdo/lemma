/**
 */
package de.fhdo.lemma.data.impl;

import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.DataOperation;
import de.fhdo.lemma.data.DataOperationParameter;
import de.fhdo.lemma.data.DataPackage;
import de.fhdo.lemma.data.ImportedComplexType;
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
 *   <li>{@link de.fhdo.lemma.data.impl.DataOperationParameterImpl#getImportedComplexType <em>Imported Complex Type</em>}</li>
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
    public ComplexType getComplexType() {
        if (complexType != null && complexType.eIsProxy()) {
            InternalEObject oldComplexType = (InternalEObject)complexType;
            complexType = (ComplexType)eResolveProxy(oldComplexType);
            if (complexType != oldComplexType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataPackage.DATA_OPERATION_PARAMETER__COMPLEX_TYPE, oldComplexType, complexType));
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
    @Override
    public void setComplexType(ComplexType newComplexType) {
        ComplexType oldComplexType = complexType;
        complexType = newComplexType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_OPERATION_PARAMETER__COMPLEX_TYPE, oldComplexType, complexType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataPackage.DATA_OPERATION_PARAMETER__IMPORTED_COMPLEX_TYPE, oldImportedComplexType, newImportedComplexType);
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
    public void setImportedComplexType(ImportedComplexType newImportedComplexType) {
        if (newImportedComplexType != importedComplexType) {
            NotificationChain msgs = null;
            if (importedComplexType != null)
                msgs = ((InternalEObject)importedComplexType).eInverseRemove(this, DataPackage.IMPORTED_COMPLEX_TYPE__PARAMETER, ImportedComplexType.class, msgs);
            if (newImportedComplexType != null)
                msgs = ((InternalEObject)newImportedComplexType).eInverseAdd(this, DataPackage.IMPORTED_COMPLEX_TYPE__PARAMETER, ImportedComplexType.class, msgs);
            msgs = basicSetImportedComplexType(newImportedComplexType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_OPERATION_PARAMETER__IMPORTED_COMPLEX_TYPE, newImportedComplexType, newImportedComplexType));
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
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case DataPackage.DATA_OPERATION_PARAMETER__IMPORTED_COMPLEX_TYPE:
                if (importedComplexType != null)
                    msgs = ((InternalEObject)importedComplexType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataPackage.DATA_OPERATION_PARAMETER__IMPORTED_COMPLEX_TYPE, null, msgs);
                return basicSetImportedComplexType((ImportedComplexType)otherEnd, msgs);
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
            case DataPackage.DATA_OPERATION_PARAMETER__IMPORTED_COMPLEX_TYPE:
                return basicSetImportedComplexType(null, msgs);
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
                if (resolve) return getComplexType();
                return basicGetComplexType();
            case DataPackage.DATA_OPERATION_PARAMETER__IMPORTED_COMPLEX_TYPE:
                return getImportedComplexType();
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
                setComplexType((ComplexType)newValue);
                return;
            case DataPackage.DATA_OPERATION_PARAMETER__IMPORTED_COMPLEX_TYPE:
                setImportedComplexType((ImportedComplexType)newValue);
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
                setComplexType((ComplexType)null);
                return;
            case DataPackage.DATA_OPERATION_PARAMETER__IMPORTED_COMPLEX_TYPE:
                setImportedComplexType((ImportedComplexType)null);
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
            case DataPackage.DATA_OPERATION_PARAMETER__IMPORTED_COMPLEX_TYPE:
                return importedComplexType != null;
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
