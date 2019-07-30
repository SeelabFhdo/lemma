/**
 */
package de.fhdo.lemma.data.impl;

import com.google.common.base.Objects;

import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.DataOperation;
import de.fhdo.lemma.data.DataOperationParameter;
import de.fhdo.lemma.data.DataPackage;
import de.fhdo.lemma.data.DataStructure;
import de.fhdo.lemma.data.PossiblyImportedComplexType;
import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.data.Type;

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

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.impl.DataOperationImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataOperationImpl#isHidden <em>Hidden</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataOperationImpl#isHasNoReturnType <em>Has No Return Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataOperationImpl#getComplexReturnType <em>Complex Return Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataOperationImpl#getPrimitiveReturnType <em>Primitive Return Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataOperationImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataOperationImpl#getDataStructure <em>Data Structure</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataOperationImpl#isLacksReturnTypeSpecification <em>Lacks Return Type Specification</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.DataOperationImpl#isInherited <em>Inherited</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataOperationImpl extends MinimalEObjectImpl.Container implements DataOperation {
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
     * The default value of the '{@link #isHasNoReturnType() <em>Has No Return Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isHasNoReturnType()
     * @generated
     * @ordered
     */
    protected static final boolean HAS_NO_RETURN_TYPE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isHasNoReturnType() <em>Has No Return Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isHasNoReturnType()
     * @generated
     * @ordered
     */
    protected boolean hasNoReturnType = HAS_NO_RETURN_TYPE_EDEFAULT;

    /**
     * The cached value of the '{@link #getComplexReturnType() <em>Complex Return Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getComplexReturnType()
     * @generated
     * @ordered
     */
    protected PossiblyImportedComplexType complexReturnType;

    /**
     * The cached value of the '{@link #getPrimitiveReturnType() <em>Primitive Return Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrimitiveReturnType()
     * @generated
     * @ordered
     */
    protected PrimitiveType primitiveReturnType;

    /**
     * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParameters()
     * @generated
     * @ordered
     */
    protected EList<DataOperationParameter> parameters;

    /**
     * The default value of the '{@link #isLacksReturnTypeSpecification() <em>Lacks Return Type Specification</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLacksReturnTypeSpecification()
     * @generated
     * @ordered
     */
    protected static final boolean LACKS_RETURN_TYPE_SPECIFICATION_EDEFAULT = false;

    /**
     * The default value of the '{@link #isInherited() <em>Inherited</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isInherited()
     * @generated
     * @ordered
     */
    protected static final boolean INHERITED_EDEFAULT = false;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DataOperationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DataPackage.Literals.DATA_OPERATION;
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
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_OPERATION__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_OPERATION__HIDDEN, oldHidden, hidden));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isHasNoReturnType() {
        return hasNoReturnType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setHasNoReturnType(boolean newHasNoReturnType) {
        boolean oldHasNoReturnType = hasNoReturnType;
        hasNoReturnType = newHasNoReturnType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_OPERATION__HAS_NO_RETURN_TYPE, oldHasNoReturnType, hasNoReturnType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PossiblyImportedComplexType getComplexReturnType() {
        return complexReturnType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetComplexReturnType(PossiblyImportedComplexType newComplexReturnType, NotificationChain msgs) {
        PossiblyImportedComplexType oldComplexReturnType = complexReturnType;
        complexReturnType = newComplexReturnType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataPackage.DATA_OPERATION__COMPLEX_RETURN_TYPE, oldComplexReturnType, newComplexReturnType);
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
    public void setComplexReturnType(PossiblyImportedComplexType newComplexReturnType) {
        if (newComplexReturnType != complexReturnType) {
            NotificationChain msgs = null;
            if (complexReturnType != null)
                msgs = ((InternalEObject)complexReturnType).eInverseRemove(this, DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__OPERATION, PossiblyImportedComplexType.class, msgs);
            if (newComplexReturnType != null)
                msgs = ((InternalEObject)newComplexReturnType).eInverseAdd(this, DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__OPERATION, PossiblyImportedComplexType.class, msgs);
            msgs = basicSetComplexReturnType(newComplexReturnType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_OPERATION__COMPLEX_RETURN_TYPE, newComplexReturnType, newComplexReturnType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PrimitiveType getPrimitiveReturnType() {
        return primitiveReturnType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPrimitiveReturnType(PrimitiveType newPrimitiveReturnType, NotificationChain msgs) {
        PrimitiveType oldPrimitiveReturnType = primitiveReturnType;
        primitiveReturnType = newPrimitiveReturnType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataPackage.DATA_OPERATION__PRIMITIVE_RETURN_TYPE, oldPrimitiveReturnType, newPrimitiveReturnType);
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
    public void setPrimitiveReturnType(PrimitiveType newPrimitiveReturnType) {
        if (newPrimitiveReturnType != primitiveReturnType) {
            NotificationChain msgs = null;
            if (primitiveReturnType != null)
                msgs = ((InternalEObject)primitiveReturnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataPackage.DATA_OPERATION__PRIMITIVE_RETURN_TYPE, null, msgs);
            if (newPrimitiveReturnType != null)
                msgs = ((InternalEObject)newPrimitiveReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataPackage.DATA_OPERATION__PRIMITIVE_RETURN_TYPE, null, msgs);
            msgs = basicSetPrimitiveReturnType(newPrimitiveReturnType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_OPERATION__PRIMITIVE_RETURN_TYPE, newPrimitiveReturnType, newPrimitiveReturnType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<DataOperationParameter> getParameters() {
        if (parameters == null) {
            parameters = new EObjectContainmentWithInverseEList<DataOperationParameter>(DataOperationParameter.class, this, DataPackage.DATA_OPERATION__PARAMETERS, DataPackage.DATA_OPERATION_PARAMETER__OPERATION);
        }
        return parameters;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DataStructure getDataStructure() {
        if (eContainerFeatureID() != DataPackage.DATA_OPERATION__DATA_STRUCTURE) return null;
        return (DataStructure)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataStructure basicGetDataStructure() {
        if (eContainerFeatureID() != DataPackage.DATA_OPERATION__DATA_STRUCTURE) return null;
        return (DataStructure)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDataStructure(DataStructure newDataStructure, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDataStructure, DataPackage.DATA_OPERATION__DATA_STRUCTURE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDataStructure(DataStructure newDataStructure) {
        if (newDataStructure != eInternalContainer() || (eContainerFeatureID() != DataPackage.DATA_OPERATION__DATA_STRUCTURE && newDataStructure != null)) {
            if (EcoreUtil.isAncestor(this, newDataStructure))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDataStructure != null)
                msgs = ((InternalEObject)newDataStructure).eInverseAdd(this, DataPackage.DATA_STRUCTURE__OPERATIONS, DataStructure.class, msgs);
            msgs = basicSetDataStructure(newDataStructure, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_OPERATION__DATA_STRUCTURE, newDataStructure, newDataStructure));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isLacksReturnTypeSpecification() {
        return ((!this.isHasNoReturnType()) && (this.getPrimitiveOrComplexReturnType() == null));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isInherited() {
        DataOperation _findEponymousSuperOperation = this.findEponymousSuperOperation();
        return (_findEponymousSuperOperation != null);
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
            final EList<String> nameParts = this.getDataStructure().getQualifiedNameParts();
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
    public DataOperation findEponymousSuperOperation() {
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
                final Function1<DataOperation, Boolean> _function = new Function1<DataOperation, Boolean>() {
                    public Boolean apply(final DataOperation it) {
                        String _name = DataOperationImpl.this.getName();
                        String _name_1 = it.getName();
                        return Boolean.valueOf(Objects.equal(_name, _name_1));
                    }
                };
                final DataOperation overridenOperation = IterableExtensions.<DataOperation>findFirst(superStructure.getOperations(), _function);
                if ((overridenOperation != null)) {
                    return overridenOperation;
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
    public Type getPrimitiveOrComplexReturnType() {
        Type _xifexpression = null;
        PrimitiveType _primitiveReturnType = this.getPrimitiveReturnType();
        boolean _tripleNotEquals = (_primitiveReturnType != null);
        if (_tripleNotEquals) {
            _xifexpression = this.getPrimitiveReturnType();
        }
        else {
            ComplexType _xifexpression_1 = null;
            if (((this.getComplexReturnType() != null) && (this.getComplexReturnType().getComplexType() != null))) {
                _xifexpression_1 = this.getComplexReturnType().getComplexType();
            }
            else {
                _xifexpression_1 = null;
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
            case DataPackage.DATA_OPERATION__COMPLEX_RETURN_TYPE:
                if (complexReturnType != null)
                    msgs = ((InternalEObject)complexReturnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataPackage.DATA_OPERATION__COMPLEX_RETURN_TYPE, null, msgs);
                return basicSetComplexReturnType((PossiblyImportedComplexType)otherEnd, msgs);
            case DataPackage.DATA_OPERATION__PARAMETERS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameters()).basicAdd(otherEnd, msgs);
            case DataPackage.DATA_OPERATION__DATA_STRUCTURE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDataStructure((DataStructure)otherEnd, msgs);
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
            case DataPackage.DATA_OPERATION__COMPLEX_RETURN_TYPE:
                return basicSetComplexReturnType(null, msgs);
            case DataPackage.DATA_OPERATION__PRIMITIVE_RETURN_TYPE:
                return basicSetPrimitiveReturnType(null, msgs);
            case DataPackage.DATA_OPERATION__PARAMETERS:
                return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
            case DataPackage.DATA_OPERATION__DATA_STRUCTURE:
                return basicSetDataStructure(null, msgs);
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
            case DataPackage.DATA_OPERATION__DATA_STRUCTURE:
                return eInternalContainer().eInverseRemove(this, DataPackage.DATA_STRUCTURE__OPERATIONS, DataStructure.class, msgs);
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
            case DataPackage.DATA_OPERATION__NAME:
                return getName();
            case DataPackage.DATA_OPERATION__HIDDEN:
                return isHidden();
            case DataPackage.DATA_OPERATION__HAS_NO_RETURN_TYPE:
                return isHasNoReturnType();
            case DataPackage.DATA_OPERATION__COMPLEX_RETURN_TYPE:
                return getComplexReturnType();
            case DataPackage.DATA_OPERATION__PRIMITIVE_RETURN_TYPE:
                return getPrimitiveReturnType();
            case DataPackage.DATA_OPERATION__PARAMETERS:
                return getParameters();
            case DataPackage.DATA_OPERATION__DATA_STRUCTURE:
                if (resolve) return getDataStructure();
                return basicGetDataStructure();
            case DataPackage.DATA_OPERATION__LACKS_RETURN_TYPE_SPECIFICATION:
                return isLacksReturnTypeSpecification();
            case DataPackage.DATA_OPERATION__INHERITED:
                return isInherited();
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
            case DataPackage.DATA_OPERATION__NAME:
                setName((String)newValue);
                return;
            case DataPackage.DATA_OPERATION__HIDDEN:
                setHidden((Boolean)newValue);
                return;
            case DataPackage.DATA_OPERATION__HAS_NO_RETURN_TYPE:
                setHasNoReturnType((Boolean)newValue);
                return;
            case DataPackage.DATA_OPERATION__COMPLEX_RETURN_TYPE:
                setComplexReturnType((PossiblyImportedComplexType)newValue);
                return;
            case DataPackage.DATA_OPERATION__PRIMITIVE_RETURN_TYPE:
                setPrimitiveReturnType((PrimitiveType)newValue);
                return;
            case DataPackage.DATA_OPERATION__PARAMETERS:
                getParameters().clear();
                getParameters().addAll((Collection<? extends DataOperationParameter>)newValue);
                return;
            case DataPackage.DATA_OPERATION__DATA_STRUCTURE:
                setDataStructure((DataStructure)newValue);
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
            case DataPackage.DATA_OPERATION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case DataPackage.DATA_OPERATION__HIDDEN:
                setHidden(HIDDEN_EDEFAULT);
                return;
            case DataPackage.DATA_OPERATION__HAS_NO_RETURN_TYPE:
                setHasNoReturnType(HAS_NO_RETURN_TYPE_EDEFAULT);
                return;
            case DataPackage.DATA_OPERATION__COMPLEX_RETURN_TYPE:
                setComplexReturnType((PossiblyImportedComplexType)null);
                return;
            case DataPackage.DATA_OPERATION__PRIMITIVE_RETURN_TYPE:
                setPrimitiveReturnType((PrimitiveType)null);
                return;
            case DataPackage.DATA_OPERATION__PARAMETERS:
                getParameters().clear();
                return;
            case DataPackage.DATA_OPERATION__DATA_STRUCTURE:
                setDataStructure((DataStructure)null);
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
            case DataPackage.DATA_OPERATION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case DataPackage.DATA_OPERATION__HIDDEN:
                return hidden != HIDDEN_EDEFAULT;
            case DataPackage.DATA_OPERATION__HAS_NO_RETURN_TYPE:
                return hasNoReturnType != HAS_NO_RETURN_TYPE_EDEFAULT;
            case DataPackage.DATA_OPERATION__COMPLEX_RETURN_TYPE:
                return complexReturnType != null;
            case DataPackage.DATA_OPERATION__PRIMITIVE_RETURN_TYPE:
                return primitiveReturnType != null;
            case DataPackage.DATA_OPERATION__PARAMETERS:
                return parameters != null && !parameters.isEmpty();
            case DataPackage.DATA_OPERATION__DATA_STRUCTURE:
                return basicGetDataStructure() != null;
            case DataPackage.DATA_OPERATION__LACKS_RETURN_TYPE_SPECIFICATION:
                return isLacksReturnTypeSpecification() != LACKS_RETURN_TYPE_SPECIFICATION_EDEFAULT;
            case DataPackage.DATA_OPERATION__INHERITED:
                return isInherited() != INHERITED_EDEFAULT;
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
            case DataPackage.DATA_OPERATION___GET_QUALIFIED_NAME_PARTS:
                return getQualifiedNameParts();
            case DataPackage.DATA_OPERATION___BUILD_QUALIFIED_NAME__STRING:
                return buildQualifiedName((String)arguments.get(0));
            case DataPackage.DATA_OPERATION___FIND_EPONYMOUS_SUPER_OPERATION:
                return findEponymousSuperOperation();
            case DataPackage.DATA_OPERATION___GET_PRIMITIVE_OR_COMPLEX_RETURN_TYPE:
                return getPrimitiveOrComplexReturnType();
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
        result.append(", hasNoReturnType: ");
        result.append(hasNoReturnType);
        result.append(')');
        return result.toString();
    }

} //DataOperationImpl
