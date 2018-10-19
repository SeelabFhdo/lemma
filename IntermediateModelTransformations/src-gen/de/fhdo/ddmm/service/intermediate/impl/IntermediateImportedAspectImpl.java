/**
 */
package de.fhdo.ddmm.service.intermediate.impl;

import de.fhdo.ddmm.data.intermediate.IntermediateImport;

import de.fhdo.ddmm.service.intermediate.IntermediateAspectProperty;
import de.fhdo.ddmm.service.intermediate.IntermediateAspectPropertyValue;
import de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect;
import de.fhdo.ddmm.service.intermediate.IntermediateInterface;
import de.fhdo.ddmm.service.intermediate.IntermediateMappedDataField;
import de.fhdo.ddmm.service.intermediate.IntermediateMicroservice;
import de.fhdo.ddmm.service.intermediate.IntermediateOperation;
import de.fhdo.ddmm.service.intermediate.IntermediatePackage;
import de.fhdo.ddmm.service.intermediate.IntermediateParameter;
import de.fhdo.ddmm.service.intermediate.IntermediateReferredOperation;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

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
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateImportedAspectImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateImportedAspectImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateImportedAspectImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateImportedAspectImpl#getPropertyValues <em>Property Values</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateImportedAspectImpl#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateImportedAspectImpl#getInterface <em>Interface</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateImportedAspectImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateImportedAspectImpl#getReferredOperation <em>Referred Operation</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateImportedAspectImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateImportedAspectImpl#getMappedDataField <em>Mapped Data Field</em>}</li>
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
    public IntermediateMicroservice getMicroservice() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MICROSERVICE) return null;
        return (IntermediateMicroservice)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateMicroservice basicGetMicroservice() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MICROSERVICE) return null;
        return (IntermediateMicroservice)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMicroservice(IntermediateMicroservice newMicroservice, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newMicroservice, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MICROSERVICE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMicroservice(IntermediateMicroservice newMicroservice) {
        if (newMicroservice != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MICROSERVICE && newMicroservice != null)) {
            if (EcoreUtil.isAncestor(this, newMicroservice))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newMicroservice != null)
                msgs = ((InternalEObject)newMicroservice).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_MICROSERVICE__ASPECTS, IntermediateMicroservice.class, msgs);
            msgs = basicSetMicroservice(newMicroservice, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MICROSERVICE, newMicroservice, newMicroservice));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateInterface getInterface() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__INTERFACE) return null;
        return (IntermediateInterface)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateInterface basicGetInterface() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__INTERFACE) return null;
        return (IntermediateInterface)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInterface(IntermediateInterface newInterface, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newInterface, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__INTERFACE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInterface(IntermediateInterface newInterface) {
        if (newInterface != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__INTERFACE && newInterface != null)) {
            if (EcoreUtil.isAncestor(this, newInterface))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newInterface != null)
                msgs = ((InternalEObject)newInterface).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_INTERFACE__ASPECTS, IntermediateInterface.class, msgs);
            msgs = basicSetInterface(newInterface, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__INTERFACE, newInterface, newInterface));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateOperation getOperation() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION) return null;
        return (IntermediateOperation)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateOperation basicGetOperation() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION) return null;
        return (IntermediateOperation)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOperation(IntermediateOperation newOperation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOperation, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperation(IntermediateOperation newOperation) {
        if (newOperation != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION && newOperation != null)) {
            if (EcoreUtil.isAncestor(this, newOperation))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOperation != null)
                msgs = ((InternalEObject)newOperation).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_OPERATION__ASPECTS, IntermediateOperation.class, msgs);
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
    public IntermediateReferredOperation getReferredOperation() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__REFERRED_OPERATION) return null;
        return (IntermediateReferredOperation)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateReferredOperation basicGetReferredOperation() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__REFERRED_OPERATION) return null;
        return (IntermediateReferredOperation)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetReferredOperation(IntermediateReferredOperation newReferredOperation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newReferredOperation, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__REFERRED_OPERATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReferredOperation(IntermediateReferredOperation newReferredOperation) {
        if (newReferredOperation != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__REFERRED_OPERATION && newReferredOperation != null)) {
            if (EcoreUtil.isAncestor(this, newReferredOperation))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newReferredOperation != null)
                msgs = ((InternalEObject)newReferredOperation).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__ASPECTS, IntermediateReferredOperation.class, msgs);
            msgs = basicSetReferredOperation(newReferredOperation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__REFERRED_OPERATION, newReferredOperation, newReferredOperation));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateParameter getParameter() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER) return null;
        return (IntermediateParameter)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateParameter basicGetParameter() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER) return null;
        return (IntermediateParameter)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParameter(IntermediateParameter newParameter, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newParameter, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParameter(IntermediateParameter newParameter) {
        if (newParameter != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER && newParameter != null)) {
            if (EcoreUtil.isAncestor(this, newParameter))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParameter != null)
                msgs = ((InternalEObject)newParameter).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_PARAMETER__ASPECTS, IntermediateParameter.class, msgs);
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
    public IntermediateMappedDataField getMappedDataField() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MAPPED_DATA_FIELD) return null;
        return (IntermediateMappedDataField)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateMappedDataField basicGetMappedDataField() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MAPPED_DATA_FIELD) return null;
        return (IntermediateMappedDataField)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMappedDataField(IntermediateMappedDataField newMappedDataField, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newMappedDataField, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MAPPED_DATA_FIELD, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMappedDataField(IntermediateMappedDataField newMappedDataField) {
        if (newMappedDataField != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MAPPED_DATA_FIELD && newMappedDataField != null)) {
            if (EcoreUtil.isAncestor(this, newMappedDataField))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newMappedDataField != null)
                msgs = ((InternalEObject)newMappedDataField).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_MAPPED_DATA_FIELD__ASPECTS, IntermediateMappedDataField.class, msgs);
            msgs = basicSetMappedDataField(newMappedDataField, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MAPPED_DATA_FIELD, newMappedDataField, newMappedDataField));
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
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MICROSERVICE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetMicroservice((IntermediateMicroservice)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__INTERFACE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetInterface((IntermediateInterface)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOperation((IntermediateOperation)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__REFERRED_OPERATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetReferredOperation((IntermediateReferredOperation)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetParameter((IntermediateParameter)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MAPPED_DATA_FIELD:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetMappedDataField((IntermediateMappedDataField)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MICROSERVICE:
                return basicSetMicroservice(null, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__INTERFACE:
                return basicSetInterface(null, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION:
                return basicSetOperation(null, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__REFERRED_OPERATION:
                return basicSetReferredOperation(null, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER:
                return basicSetParameter(null, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MAPPED_DATA_FIELD:
                return basicSetMappedDataField(null, msgs);
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
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MICROSERVICE:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_MICROSERVICE__ASPECTS, IntermediateMicroservice.class, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__INTERFACE:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_INTERFACE__ASPECTS, IntermediateInterface.class, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_OPERATION__ASPECTS, IntermediateOperation.class, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__REFERRED_OPERATION:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__ASPECTS, IntermediateReferredOperation.class, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_PARAMETER__ASPECTS, IntermediateParameter.class, msgs);
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MAPPED_DATA_FIELD:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_MAPPED_DATA_FIELD__ASPECTS, IntermediateMappedDataField.class, msgs);
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
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__IMPORT:
                if (resolve) return getImport();
                return basicGetImport();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTIES:
                return getProperties();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTY_VALUES:
                return getPropertyValues();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MICROSERVICE:
                if (resolve) return getMicroservice();
                return basicGetMicroservice();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__INTERFACE:
                if (resolve) return getInterface();
                return basicGetInterface();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION:
                if (resolve) return getOperation();
                return basicGetOperation();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__REFERRED_OPERATION:
                if (resolve) return getReferredOperation();
                return basicGetReferredOperation();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER:
                if (resolve) return getParameter();
                return basicGetParameter();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MAPPED_DATA_FIELD:
                if (resolve) return getMappedDataField();
                return basicGetMappedDataField();
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
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MICROSERVICE:
                setMicroservice((IntermediateMicroservice)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__INTERFACE:
                setInterface((IntermediateInterface)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION:
                setOperation((IntermediateOperation)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__REFERRED_OPERATION:
                setReferredOperation((IntermediateReferredOperation)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER:
                setParameter((IntermediateParameter)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MAPPED_DATA_FIELD:
                setMappedDataField((IntermediateMappedDataField)newValue);
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
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__IMPORT:
                setImport((IntermediateImport)null);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTIES:
                getProperties().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTY_VALUES:
                getPropertyValues().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MICROSERVICE:
                setMicroservice((IntermediateMicroservice)null);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__INTERFACE:
                setInterface((IntermediateInterface)null);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION:
                setOperation((IntermediateOperation)null);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__REFERRED_OPERATION:
                setReferredOperation((IntermediateReferredOperation)null);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER:
                setParameter((IntermediateParameter)null);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MAPPED_DATA_FIELD:
                setMappedDataField((IntermediateMappedDataField)null);
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
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__IMPORT:
                return import_ != null;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTIES:
                return properties != null && !properties.isEmpty();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTY_VALUES:
                return propertyValues != null && !propertyValues.isEmpty();
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MICROSERVICE:
                return basicGetMicroservice() != null;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__INTERFACE:
                return basicGetInterface() != null;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__OPERATION:
                return basicGetOperation() != null;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__REFERRED_OPERATION:
                return basicGetReferredOperation() != null;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PARAMETER:
                return basicGetParameter() != null;
            case IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__MAPPED_DATA_FIELD:
                return basicGetMappedDataField() != null;
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

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //IntermediateImportedAspectImpl
