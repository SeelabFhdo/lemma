/**
 */
package de.fhdo.lemma.data.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateAspectProperty;
import de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue;
import de.fhdo.lemma.data.intermediate.IntermediateComplexType;
import de.fhdo.lemma.data.intermediate.IntermediateDataField;
import de.fhdo.lemma.data.intermediate.IntermediateDataOperation;
import de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter;
import de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType;
import de.fhdo.lemma.data.intermediate.IntermediateImport;
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect;
import de.fhdo.lemma.data.intermediate.IntermediatePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Imported Aspect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportedAspectImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportedAspectImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportedAspectImpl#getFeatureNames <em>Feature Names</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportedAspectImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportedAspectImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportedAspectImpl#getPropertyValues <em>Property Values</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportedAspectImpl#getComplexType <em>Complex Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportedAspectImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportedAspectImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportedAspectImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportedAspectImpl#getDataField <em>Data Field</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateImportedAspectImpl extends MinimalEObjectImpl.Container implements IntermediateImportedAspect {
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
     * The default value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQualifiedName()
     * @generated
     * @ordered
     */
    protected static final String QUALIFIED_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQualifiedName()
     * @generated
     * @ordered
     */
    protected String qualifiedName = QUALIFIED_NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getFeatureNames() <em>Feature Names</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFeatureNames()
     * @generated
     * @ordered
     */
    protected EList<String> featureNames;

    /**
     * The cached value of the '{@link #getImport() <em>Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImport()
     * @generated
     * @ordered
     */
    protected IntermediateImport import_;

    /**
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProperties()
     * @generated
     * @ordered
     */
    protected EList<IntermediateAspectProperty> properties;

    /**
     * The cached value of the '{@link #getPropertyValues() <em>Property Values</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPropertyValues()
     * @generated
     * @ordered
     */
    protected EList<IntermediateAspectPropertyValue> propertyValues;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediateImportedAspectImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_IMPORTED_ASPECT;
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getQualifiedName() {
        return qualifiedName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setQualifiedName(String newQualifiedName) {
        String oldQualifiedName = qualifiedName;
        qualifiedName = newQualifiedName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getFeatureNames() {
        if (featureNames == null) {
            featureNames = new EDataTypeEList<String>(String.class, this, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__FEATURE_NAMES);
        }
        return featureNames;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateImport getImport() {
        if (import_ != null && import_.eIsProxy()) {
            InternalEObject oldImport = (InternalEObject)import_;
            import_ = (IntermediateImport)eResolveProxy(oldImport);
            if (import_ != oldImport) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__IMPORT, oldImport, import_));
            }
        }
        return import_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateImport basicGetImport() {
        return import_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setImport(IntermediateImport newImport) {
        IntermediateImport oldImport = import_;
        import_ = newImport;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__IMPORT, oldImport, import_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateAspectProperty> getProperties() {
        if (properties == null) {
            properties = new EObjectContainmentWithInverseEList<IntermediateAspectProperty>(IntermediateAspectProperty.class, this, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTIES, IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY__ASPECT);
        }
        return properties;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateAspectPropertyValue> getPropertyValues() {
        if (propertyValues == null) {
            propertyValues = new EObjectContainmentWithInverseEList<IntermediateAspectPropertyValue>(IntermediateAspectPropertyValue.class, this, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTY_VALUES, IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__ASPECT);
        }
        return propertyValues;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateComplexType getComplexType() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__COMPLEX_TYPE) return null;
        return (IntermediateComplexType)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateComplexType basicGetComplexType() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__COMPLEX_TYPE) return null;
        return (IntermediateComplexType)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetComplexType(IntermediateComplexType newComplexType, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newComplexType, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__COMPLEX_TYPE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setComplexType(IntermediateComplexType newComplexType) {
        if (newComplexType != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__COMPLEX_TYPE && newComplexType != null)) {
            if (EcoreUtil.isAncestor(this, newComplexType))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newComplexType != null)
                msgs = ((InternalEObject)newComplexType).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__ASPECTS, IntermediateComplexType.class, msgs);
            msgs = basicSetComplexType(newComplexType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__COMPLEX_TYPE, newComplexType, newComplexType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataOperation getOperation() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION) return null;
        return (IntermediateDataOperation)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataOperation basicGetOperation() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION) return null;
        return (IntermediateDataOperation)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOperation(IntermediateDataOperation newOperation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOperation, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperation(IntermediateDataOperation newOperation) {
        if (newOperation != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION && newOperation != null)) {
            if (EcoreUtil.isAncestor(this, newOperation))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOperation != null)
                msgs = ((InternalEObject)newOperation).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_DATA_OPERATION__ASPECTS, IntermediateDataOperation.class, msgs);
            msgs = basicSetOperation(newOperation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION, newOperation, newOperation));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataOperationReturnType getReturnType() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__RETURN_TYPE) return null;
        return (IntermediateDataOperationReturnType)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataOperationReturnType basicGetReturnType() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__RETURN_TYPE) return null;
        return (IntermediateDataOperationReturnType)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetReturnType(IntermediateDataOperationReturnType newReturnType, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newReturnType, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__RETURN_TYPE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReturnType(IntermediateDataOperationReturnType newReturnType) {
        if (newReturnType != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__RETURN_TYPE && newReturnType != null)) {
            if (EcoreUtil.isAncestor(this, newReturnType))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newReturnType != null)
                msgs = ((InternalEObject)newReturnType).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_DATA_OPERATION_RETURN_TYPE__ASPECTS, IntermediateDataOperationReturnType.class, msgs);
            msgs = basicSetReturnType(newReturnType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__RETURN_TYPE, newReturnType, newReturnType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataOperationParameter getParameter() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER) return null;
        return (IntermediateDataOperationParameter)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataOperationParameter basicGetParameter() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER) return null;
        return (IntermediateDataOperationParameter)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParameter(IntermediateDataOperationParameter newParameter, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newParameter, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParameter(IntermediateDataOperationParameter newParameter) {
        if (newParameter != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER && newParameter != null)) {
            if (EcoreUtil.isAncestor(this, newParameter))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParameter != null)
                msgs = ((InternalEObject)newParameter).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__ASPECTS, IntermediateDataOperationParameter.class, msgs);
            msgs = basicSetParameter(newParameter, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER, newParameter, newParameter));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataField getDataField() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__DATA_FIELD) return null;
        return (IntermediateDataField)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataField basicGetDataField() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__DATA_FIELD) return null;
        return (IntermediateDataField)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDataField(IntermediateDataField newDataField, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDataField, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__DATA_FIELD, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataField(IntermediateDataField newDataField) {
        if (newDataField != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__DATA_FIELD && newDataField != null)) {
            if (EcoreUtil.isAncestor(this, newDataField))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDataField != null)
                msgs = ((InternalEObject)newDataField).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_DATA_FIELD__ASPECTS, IntermediateDataField.class, msgs);
            msgs = basicSetDataField(newDataField, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__DATA_FIELD, newDataField, newDataField));
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
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTIES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getProperties()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTY_VALUES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getPropertyValues()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__COMPLEX_TYPE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetComplexType((IntermediateComplexType)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOperation((IntermediateDataOperation)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__RETURN_TYPE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetReturnType((IntermediateDataOperationReturnType)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetParameter((IntermediateDataOperationParameter)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__DATA_FIELD:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDataField((IntermediateDataField)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTIES:
                return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTY_VALUES:
                return ((InternalEList<?>)getPropertyValues()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__COMPLEX_TYPE:
                return basicSetComplexType(null, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION:
                return basicSetOperation(null, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__RETURN_TYPE:
                return basicSetReturnType(null, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER:
                return basicSetParameter(null, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__DATA_FIELD:
                return basicSetDataField(null, msgs);
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
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__COMPLEX_TYPE:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__ASPECTS, IntermediateComplexType.class, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_DATA_OPERATION__ASPECTS, IntermediateDataOperation.class, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__RETURN_TYPE:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_DATA_OPERATION_RETURN_TYPE__ASPECTS, IntermediateDataOperationReturnType.class, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__ASPECTS, IntermediateDataOperationParameter.class, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__DATA_FIELD:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_DATA_FIELD__ASPECTS, IntermediateDataField.class, msgs);
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
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__NAME:
                return getName();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__QUALIFIED_NAME:
                return getQualifiedName();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__FEATURE_NAMES:
                return getFeatureNames();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__IMPORT:
                if (resolve) return getImport();
                return basicGetImport();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTIES:
                return getProperties();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTY_VALUES:
                return getPropertyValues();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__COMPLEX_TYPE:
                if (resolve) return getComplexType();
                return basicGetComplexType();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION:
                if (resolve) return getOperation();
                return basicGetOperation();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__RETURN_TYPE:
                if (resolve) return getReturnType();
                return basicGetReturnType();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER:
                if (resolve) return getParameter();
                return basicGetParameter();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__DATA_FIELD:
                if (resolve) return getDataField();
                return basicGetDataField();
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
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__NAME:
                setName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__QUALIFIED_NAME:
                setQualifiedName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__FEATURE_NAMES:
                getFeatureNames().clear();
                getFeatureNames().addAll((Collection<? extends String>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__IMPORT:
                setImport((IntermediateImport)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTIES:
                getProperties().clear();
                getProperties().addAll((Collection<? extends IntermediateAspectProperty>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTY_VALUES:
                getPropertyValues().clear();
                getPropertyValues().addAll((Collection<? extends IntermediateAspectPropertyValue>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__COMPLEX_TYPE:
                setComplexType((IntermediateComplexType)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION:
                setOperation((IntermediateDataOperation)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__RETURN_TYPE:
                setReturnType((IntermediateDataOperationReturnType)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER:
                setParameter((IntermediateDataOperationParameter)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__DATA_FIELD:
                setDataField((IntermediateDataField)newValue);
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
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__NAME:
                setName(NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__QUALIFIED_NAME:
                setQualifiedName(QUALIFIED_NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__FEATURE_NAMES:
                getFeatureNames().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__IMPORT:
                setImport((IntermediateImport)null);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTIES:
                getProperties().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTY_VALUES:
                getPropertyValues().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__COMPLEX_TYPE:
                setComplexType((IntermediateComplexType)null);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION:
                setOperation((IntermediateDataOperation)null);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__RETURN_TYPE:
                setReturnType((IntermediateDataOperationReturnType)null);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER:
                setParameter((IntermediateDataOperationParameter)null);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__DATA_FIELD:
                setDataField((IntermediateDataField)null);
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
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__QUALIFIED_NAME:
                return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__FEATURE_NAMES:
                return featureNames != null && !featureNames.isEmpty();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__IMPORT:
                return import_ != null;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTIES:
                return properties != null && !properties.isEmpty();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTY_VALUES:
                return propertyValues != null && !propertyValues.isEmpty();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__COMPLEX_TYPE:
                return basicGetComplexType() != null;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION:
                return basicGetOperation() != null;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__RETURN_TYPE:
                return basicGetReturnType() != null;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER:
                return basicGetParameter() != null;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__DATA_FIELD:
                return basicGetDataField() != null;
        }
        return super.eIsSet(featureID);
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
        result.append(", qualifiedName: ");
        result.append(qualifiedName);
        result.append(", featureNames: ");
        result.append(featureNames);
        result.append(')');
        return result.toString();
    }

} //IntermediateImportedAspectImpl
