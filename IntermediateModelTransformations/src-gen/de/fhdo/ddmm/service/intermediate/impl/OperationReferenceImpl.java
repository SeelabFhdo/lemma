/**
 */
package de.fhdo.ddmm.service.intermediate.impl;

import de.fhdo.ddmm.data.intermediate.IntermediateImport;

import de.fhdo.ddmm.service.intermediate.IntermediateMicroservice;
import de.fhdo.ddmm.service.intermediate.IntermediateOperation;
import de.fhdo.ddmm.service.intermediate.IntermediatePackage;
import de.fhdo.ddmm.service.intermediate.IntermediateParameter;
import de.fhdo.ddmm.service.intermediate.OperationReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.OperationReferenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.OperationReferenceImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.OperationReferenceImpl#isImported <em>Imported</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.OperationReferenceImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.OperationReferenceImpl#getLocalOperation <em>Local Operation</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.OperationReferenceImpl#getRequiringMicroservice <em>Requiring Microservice</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.OperationReferenceImpl#getInitializedParameter <em>Initialized Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationReferenceImpl extends MinimalEObjectImpl.Container implements OperationReference {
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
     * The default value of the '{@link #isImported() <em>Imported</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isImported()
     * @generated
     * @ordered
     */
    protected static final boolean IMPORTED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isImported() <em>Imported</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isImported()
     * @generated
     * @ordered
     */
    protected boolean imported = IMPORTED_EDEFAULT;

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
     * The cached value of the '{@link #getLocalOperation() <em>Local Operation</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocalOperation()
     * @generated
     * @ordered
     */
    protected IntermediateOperation localOperation;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected OperationReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.OPERATION_REFERENCE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.OPERATION_REFERENCE__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getQualifiedName() {
        return qualifiedName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setQualifiedName(String newQualifiedName) {
        String oldQualifiedName = qualifiedName;
        qualifiedName = newQualifiedName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.OPERATION_REFERENCE__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isImported() {
        return imported;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setImported(boolean newImported) {
        boolean oldImported = imported;
        imported = newImported;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.OPERATION_REFERENCE__IMPORTED, oldImported, imported));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateImport getImport() {
        if (import_ != null && import_.eIsProxy()) {
            InternalEObject oldImport = (InternalEObject)import_;
            import_ = (IntermediateImport)eResolveProxy(oldImport);
            if (import_ != oldImport) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.OPERATION_REFERENCE__IMPORT, oldImport, import_));
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
    @Override
    public void setImport(IntermediateImport newImport) {
        IntermediateImport oldImport = import_;
        import_ = newImport;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.OPERATION_REFERENCE__IMPORT, oldImport, import_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateOperation getLocalOperation() {
        if (localOperation != null && localOperation.eIsProxy()) {
            InternalEObject oldLocalOperation = (InternalEObject)localOperation;
            localOperation = (IntermediateOperation)eResolveProxy(oldLocalOperation);
            if (localOperation != oldLocalOperation) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.OPERATION_REFERENCE__LOCAL_OPERATION, oldLocalOperation, localOperation));
            }
        }
        return localOperation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateOperation basicGetLocalOperation() {
        return localOperation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setLocalOperation(IntermediateOperation newLocalOperation) {
        IntermediateOperation oldLocalOperation = localOperation;
        localOperation = newLocalOperation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.OPERATION_REFERENCE__LOCAL_OPERATION, oldLocalOperation, localOperation));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateMicroservice getRequiringMicroservice() {
        if (eContainerFeatureID() != IntermediatePackage.OPERATION_REFERENCE__REQUIRING_MICROSERVICE) return null;
        return (IntermediateMicroservice)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateMicroservice basicGetRequiringMicroservice() {
        if (eContainerFeatureID() != IntermediatePackage.OPERATION_REFERENCE__REQUIRING_MICROSERVICE) return null;
        return (IntermediateMicroservice)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetRequiringMicroservice(IntermediateMicroservice newRequiringMicroservice, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newRequiringMicroservice, IntermediatePackage.OPERATION_REFERENCE__REQUIRING_MICROSERVICE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setRequiringMicroservice(IntermediateMicroservice newRequiringMicroservice) {
        if (newRequiringMicroservice != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.OPERATION_REFERENCE__REQUIRING_MICROSERVICE && newRequiringMicroservice != null)) {
            if (EcoreUtil.isAncestor(this, newRequiringMicroservice))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newRequiringMicroservice != null)
                msgs = ((InternalEObject)newRequiringMicroservice).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_OPERATIONS, IntermediateMicroservice.class, msgs);
            msgs = basicSetRequiringMicroservice(newRequiringMicroservice, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.OPERATION_REFERENCE__REQUIRING_MICROSERVICE, newRequiringMicroservice, newRequiringMicroservice));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateParameter getInitializedParameter() {
        if (eContainerFeatureID() != IntermediatePackage.OPERATION_REFERENCE__INITIALIZED_PARAMETER) return null;
        return (IntermediateParameter)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateParameter basicGetInitializedParameter() {
        if (eContainerFeatureID() != IntermediatePackage.OPERATION_REFERENCE__INITIALIZED_PARAMETER) return null;
        return (IntermediateParameter)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInitializedParameter(IntermediateParameter newInitializedParameter, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newInitializedParameter, IntermediatePackage.OPERATION_REFERENCE__INITIALIZED_PARAMETER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setInitializedParameter(IntermediateParameter newInitializedParameter) {
        if (newInitializedParameter != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.OPERATION_REFERENCE__INITIALIZED_PARAMETER && newInitializedParameter != null)) {
            if (EcoreUtil.isAncestor(this, newInitializedParameter))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newInitializedParameter != null)
                msgs = ((InternalEObject)newInitializedParameter).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_PARAMETER__INITIALIZED_BY_OPERATION, IntermediateParameter.class, msgs);
            msgs = basicSetInitializedParameter(newInitializedParameter, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.OPERATION_REFERENCE__INITIALIZED_PARAMETER, newInitializedParameter, newInitializedParameter));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case IntermediatePackage.OPERATION_REFERENCE__REQUIRING_MICROSERVICE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetRequiringMicroservice((IntermediateMicroservice)otherEnd, msgs);
            case IntermediatePackage.OPERATION_REFERENCE__INITIALIZED_PARAMETER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetInitializedParameter((IntermediateParameter)otherEnd, msgs);
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
            case IntermediatePackage.OPERATION_REFERENCE__REQUIRING_MICROSERVICE:
                return basicSetRequiringMicroservice(null, msgs);
            case IntermediatePackage.OPERATION_REFERENCE__INITIALIZED_PARAMETER:
                return basicSetInitializedParameter(null, msgs);
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
            case IntermediatePackage.OPERATION_REFERENCE__REQUIRING_MICROSERVICE:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_OPERATIONS, IntermediateMicroservice.class, msgs);
            case IntermediatePackage.OPERATION_REFERENCE__INITIALIZED_PARAMETER:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_PARAMETER__INITIALIZED_BY_OPERATION, IntermediateParameter.class, msgs);
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
            case IntermediatePackage.OPERATION_REFERENCE__NAME:
                return getName();
            case IntermediatePackage.OPERATION_REFERENCE__QUALIFIED_NAME:
                return getQualifiedName();
            case IntermediatePackage.OPERATION_REFERENCE__IMPORTED:
                return isImported();
            case IntermediatePackage.OPERATION_REFERENCE__IMPORT:
                if (resolve) return getImport();
                return basicGetImport();
            case IntermediatePackage.OPERATION_REFERENCE__LOCAL_OPERATION:
                if (resolve) return getLocalOperation();
                return basicGetLocalOperation();
            case IntermediatePackage.OPERATION_REFERENCE__REQUIRING_MICROSERVICE:
                if (resolve) return getRequiringMicroservice();
                return basicGetRequiringMicroservice();
            case IntermediatePackage.OPERATION_REFERENCE__INITIALIZED_PARAMETER:
                if (resolve) return getInitializedParameter();
                return basicGetInitializedParameter();
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
            case IntermediatePackage.OPERATION_REFERENCE__NAME:
                setName((String)newValue);
                return;
            case IntermediatePackage.OPERATION_REFERENCE__QUALIFIED_NAME:
                setQualifiedName((String)newValue);
                return;
            case IntermediatePackage.OPERATION_REFERENCE__IMPORTED:
                setImported((Boolean)newValue);
                return;
            case IntermediatePackage.OPERATION_REFERENCE__IMPORT:
                setImport((IntermediateImport)newValue);
                return;
            case IntermediatePackage.OPERATION_REFERENCE__LOCAL_OPERATION:
                setLocalOperation((IntermediateOperation)newValue);
                return;
            case IntermediatePackage.OPERATION_REFERENCE__REQUIRING_MICROSERVICE:
                setRequiringMicroservice((IntermediateMicroservice)newValue);
                return;
            case IntermediatePackage.OPERATION_REFERENCE__INITIALIZED_PARAMETER:
                setInitializedParameter((IntermediateParameter)newValue);
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
            case IntermediatePackage.OPERATION_REFERENCE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case IntermediatePackage.OPERATION_REFERENCE__QUALIFIED_NAME:
                setQualifiedName(QUALIFIED_NAME_EDEFAULT);
                return;
            case IntermediatePackage.OPERATION_REFERENCE__IMPORTED:
                setImported(IMPORTED_EDEFAULT);
                return;
            case IntermediatePackage.OPERATION_REFERENCE__IMPORT:
                setImport((IntermediateImport)null);
                return;
            case IntermediatePackage.OPERATION_REFERENCE__LOCAL_OPERATION:
                setLocalOperation((IntermediateOperation)null);
                return;
            case IntermediatePackage.OPERATION_REFERENCE__REQUIRING_MICROSERVICE:
                setRequiringMicroservice((IntermediateMicroservice)null);
                return;
            case IntermediatePackage.OPERATION_REFERENCE__INITIALIZED_PARAMETER:
                setInitializedParameter((IntermediateParameter)null);
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
            case IntermediatePackage.OPERATION_REFERENCE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case IntermediatePackage.OPERATION_REFERENCE__QUALIFIED_NAME:
                return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
            case IntermediatePackage.OPERATION_REFERENCE__IMPORTED:
                return imported != IMPORTED_EDEFAULT;
            case IntermediatePackage.OPERATION_REFERENCE__IMPORT:
                return import_ != null;
            case IntermediatePackage.OPERATION_REFERENCE__LOCAL_OPERATION:
                return localOperation != null;
            case IntermediatePackage.OPERATION_REFERENCE__REQUIRING_MICROSERVICE:
                return basicGetRequiringMicroservice() != null;
            case IntermediatePackage.OPERATION_REFERENCE__INITIALIZED_PARAMETER:
                return basicGetInitializedParameter() != null;
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
        result.append(", imported: ");
        result.append(imported);
        result.append(')');
        return result.toString();
    }

} //OperationReferenceImpl
