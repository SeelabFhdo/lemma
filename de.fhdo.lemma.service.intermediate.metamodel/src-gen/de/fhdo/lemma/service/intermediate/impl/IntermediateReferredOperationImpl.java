/**
 */
package de.fhdo.lemma.service.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect;

import de.fhdo.lemma.service.intermediate.IntermediateEndpoint;
import de.fhdo.lemma.service.intermediate.IntermediateInterface;
import de.fhdo.lemma.service.intermediate.IntermediateOperation;
import de.fhdo.lemma.service.intermediate.IntermediatePackage;
import de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification;
import de.fhdo.lemma.service.intermediate.IntermediateReferredOperation;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Referred Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateReferredOperationImpl#getNameInReferringInterface <em>Name In Referring Interface</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateReferredOperationImpl#getQualifiedNameInReferringInterface <em>Qualified Name In Referring Interface</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateReferredOperationImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateReferredOperationImpl#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateReferredOperationImpl#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateReferredOperationImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateReferredOperationImpl#getReferringInterface <em>Referring Interface</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateReferredOperationImpl extends MinimalEObjectImpl.Container implements IntermediateReferredOperation {
    /**
     * The default value of the '{@link #getNameInReferringInterface() <em>Name In Referring Interface</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNameInReferringInterface()
     * @generated
     * @ordered
     */
    protected static final String NAME_IN_REFERRING_INTERFACE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getNameInReferringInterface() <em>Name In Referring Interface</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNameInReferringInterface()
     * @generated
     * @ordered
     */
    protected String nameInReferringInterface = NAME_IN_REFERRING_INTERFACE_EDEFAULT;

    /**
     * The default value of the '{@link #getQualifiedNameInReferringInterface() <em>Qualified Name In Referring Interface</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQualifiedNameInReferringInterface()
     * @generated
     * @ordered
     */
    protected static final String QUALIFIED_NAME_IN_REFERRING_INTERFACE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getQualifiedNameInReferringInterface() <em>Qualified Name In Referring Interface</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQualifiedNameInReferringInterface()
     * @generated
     * @ordered
     */
    protected String qualifiedNameInReferringInterface = QUALIFIED_NAME_IN_REFERRING_INTERFACE_EDEFAULT;

    /**
     * The cached value of the '{@link #getOperation() <em>Operation</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperation()
     * @generated
     * @ordered
     */
    protected IntermediateOperation operation;

    /**
     * The cached value of the '{@link #getEndpoints() <em>Endpoints</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEndpoints()
     * @generated
     * @ordered
     */
    protected EList<IntermediateEndpoint> endpoints;

    /**
     * The cached value of the '{@link #getProtocols() <em>Protocols</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProtocols()
     * @generated
     * @ordered
     */
    protected EList<IntermediateProtocolSpecification> protocols;

    /**
     * The cached value of the '{@link #getAspects() <em>Aspects</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAspects()
     * @generated
     * @ordered
     */
    protected EList<IntermediateImportedAspect> aspects;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediateReferredOperationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_REFERRED_OPERATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getNameInReferringInterface() {
        return nameInReferringInterface;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setNameInReferringInterface(String newNameInReferringInterface) {
        String oldNameInReferringInterface = nameInReferringInterface;
        nameInReferringInterface = newNameInReferringInterface;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__NAME_IN_REFERRING_INTERFACE, oldNameInReferringInterface, nameInReferringInterface));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getQualifiedNameInReferringInterface() {
        return qualifiedNameInReferringInterface;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setQualifiedNameInReferringInterface(String newQualifiedNameInReferringInterface) {
        String oldQualifiedNameInReferringInterface = qualifiedNameInReferringInterface;
        qualifiedNameInReferringInterface = newQualifiedNameInReferringInterface;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__QUALIFIED_NAME_IN_REFERRING_INTERFACE, oldQualifiedNameInReferringInterface, qualifiedNameInReferringInterface));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateOperation getOperation() {
        if (operation != null && operation.eIsProxy()) {
            InternalEObject oldOperation = (InternalEObject)operation;
            operation = (IntermediateOperation)eResolveProxy(oldOperation);
            if (operation != oldOperation) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__OPERATION, oldOperation, operation));
            }
        }
        return operation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateOperation basicGetOperation() {
        return operation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setOperation(IntermediateOperation newOperation) {
        IntermediateOperation oldOperation = operation;
        operation = newOperation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__OPERATION, oldOperation, operation));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<IntermediateEndpoint> getEndpoints() {
        if (endpoints == null) {
            endpoints = new EObjectContainmentWithInverseEList<IntermediateEndpoint>(IntermediateEndpoint.class, this, IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__ENDPOINTS, IntermediatePackage.INTERMEDIATE_ENDPOINT__REFERRED_OPERATION);
        }
        return endpoints;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<IntermediateProtocolSpecification> getProtocols() {
        if (protocols == null) {
            protocols = new EObjectContainmentEList<IntermediateProtocolSpecification>(IntermediateProtocolSpecification.class, this, IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__PROTOCOLS);
        }
        return protocols;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<IntermediateImportedAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentEList<IntermediateImportedAspect>(IntermediateImportedAspect.class, this, IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__ASPECTS);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateInterface getReferringInterface() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__REFERRING_INTERFACE) return null;
        return (IntermediateInterface)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateInterface basicGetReferringInterface() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__REFERRING_INTERFACE) return null;
        return (IntermediateInterface)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetReferringInterface(IntermediateInterface newReferringInterface, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newReferringInterface, IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__REFERRING_INTERFACE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setReferringInterface(IntermediateInterface newReferringInterface) {
        if (newReferringInterface != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__REFERRING_INTERFACE && newReferringInterface != null)) {
            if (EcoreUtil.isAncestor(this, newReferringInterface))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newReferringInterface != null)
                msgs = ((InternalEObject)newReferringInterface).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_INTERFACE__REFERRED_OPERATIONS, IntermediateInterface.class, msgs);
            msgs = basicSetReferringInterface(newReferringInterface, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__REFERRING_INTERFACE, newReferringInterface, newReferringInterface));
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
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__ENDPOINTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getEndpoints()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__REFERRING_INTERFACE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetReferringInterface((IntermediateInterface)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__ENDPOINTS:
                return ((InternalEList<?>)getEndpoints()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__PROTOCOLS:
                return ((InternalEList<?>)getProtocols()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__REFERRING_INTERFACE:
                return basicSetReferringInterface(null, msgs);
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
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__REFERRING_INTERFACE:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_INTERFACE__REFERRED_OPERATIONS, IntermediateInterface.class, msgs);
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
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__NAME_IN_REFERRING_INTERFACE:
                return getNameInReferringInterface();
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__QUALIFIED_NAME_IN_REFERRING_INTERFACE:
                return getQualifiedNameInReferringInterface();
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__OPERATION:
                if (resolve) return getOperation();
                return basicGetOperation();
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__ENDPOINTS:
                return getEndpoints();
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__PROTOCOLS:
                return getProtocols();
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__ASPECTS:
                return getAspects();
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__REFERRING_INTERFACE:
                if (resolve) return getReferringInterface();
                return basicGetReferringInterface();
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
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__NAME_IN_REFERRING_INTERFACE:
                setNameInReferringInterface((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__QUALIFIED_NAME_IN_REFERRING_INTERFACE:
                setQualifiedNameInReferringInterface((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__OPERATION:
                setOperation((IntermediateOperation)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__ENDPOINTS:
                getEndpoints().clear();
                getEndpoints().addAll((Collection<? extends IntermediateEndpoint>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__PROTOCOLS:
                getProtocols().clear();
                getProtocols().addAll((Collection<? extends IntermediateProtocolSpecification>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends IntermediateImportedAspect>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__REFERRING_INTERFACE:
                setReferringInterface((IntermediateInterface)newValue);
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
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__NAME_IN_REFERRING_INTERFACE:
                setNameInReferringInterface(NAME_IN_REFERRING_INTERFACE_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__QUALIFIED_NAME_IN_REFERRING_INTERFACE:
                setQualifiedNameInReferringInterface(QUALIFIED_NAME_IN_REFERRING_INTERFACE_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__OPERATION:
                setOperation((IntermediateOperation)null);
                return;
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__ENDPOINTS:
                getEndpoints().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__PROTOCOLS:
                getProtocols().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__ASPECTS:
                getAspects().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__REFERRING_INTERFACE:
                setReferringInterface((IntermediateInterface)null);
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
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__NAME_IN_REFERRING_INTERFACE:
                return NAME_IN_REFERRING_INTERFACE_EDEFAULT == null ? nameInReferringInterface != null : !NAME_IN_REFERRING_INTERFACE_EDEFAULT.equals(nameInReferringInterface);
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__QUALIFIED_NAME_IN_REFERRING_INTERFACE:
                return QUALIFIED_NAME_IN_REFERRING_INTERFACE_EDEFAULT == null ? qualifiedNameInReferringInterface != null : !QUALIFIED_NAME_IN_REFERRING_INTERFACE_EDEFAULT.equals(qualifiedNameInReferringInterface);
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__OPERATION:
                return operation != null;
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__ENDPOINTS:
                return endpoints != null && !endpoints.isEmpty();
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__PROTOCOLS:
                return protocols != null && !protocols.isEmpty();
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__REFERRING_INTERFACE:
                return basicGetReferringInterface() != null;
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
        result.append(" (nameInReferringInterface: ");
        result.append(nameInReferringInterface);
        result.append(", qualifiedNameInReferringInterface: ");
        result.append(qualifiedNameInReferringInterface);
        result.append(')');
        return result.toString();
    }

} //IntermediateReferredOperationImpl
