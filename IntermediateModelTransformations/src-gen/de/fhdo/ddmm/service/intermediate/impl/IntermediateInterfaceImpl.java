/**
 */
package de.fhdo.ddmm.service.intermediate.impl;

import de.fhdo.ddmm.service.Visibility;

import de.fhdo.ddmm.service.intermediate.IntermediateEndpoint;
import de.fhdo.ddmm.service.intermediate.IntermediateImportedAspect;
import de.fhdo.ddmm.service.intermediate.IntermediateInterface;
import de.fhdo.ddmm.service.intermediate.IntermediateMicroservice;
import de.fhdo.ddmm.service.intermediate.IntermediateOperation;
import de.fhdo.ddmm.service.intermediate.IntermediatePackage;
import de.fhdo.ddmm.service.intermediate.IntermediateProtocolSpecification;
import de.fhdo.ddmm.service.intermediate.IntermediateReferredOperation;

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
 * An implementation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateInterfaceImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateInterfaceImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateInterfaceImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateInterfaceImpl#isNotImplemented <em>Not Implemented</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateInterfaceImpl#isHasImplementedOperations <em>Has Implemented Operations</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateInterfaceImpl#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateInterfaceImpl#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateInterfaceImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateInterfaceImpl#getReferredOperations <em>Referred Operations</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateInterfaceImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.IntermediateInterfaceImpl#getMicroservice <em>Microservice</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateInterfaceImpl extends MinimalEObjectImpl.Container implements IntermediateInterface {
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
     * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVisibility()
     * @generated
     * @ordered
     */
    protected static final Visibility VISIBILITY_EDEFAULT = Visibility.NONE;

    /**
     * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVisibility()
     * @generated
     * @ordered
     */
    protected Visibility visibility = VISIBILITY_EDEFAULT;

    /**
     * The default value of the '{@link #isNotImplemented() <em>Not Implemented</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isNotImplemented()
     * @generated
     * @ordered
     */
    protected static final boolean NOT_IMPLEMENTED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isNotImplemented() <em>Not Implemented</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isNotImplemented()
     * @generated
     * @ordered
     */
    protected boolean notImplemented = NOT_IMPLEMENTED_EDEFAULT;

    /**
     * The default value of the '{@link #isHasImplementedOperations() <em>Has Implemented Operations</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isHasImplementedOperations()
     * @generated
     * @ordered
     */
    protected static final boolean HAS_IMPLEMENTED_OPERATIONS_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isHasImplementedOperations() <em>Has Implemented Operations</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isHasImplementedOperations()
     * @generated
     * @ordered
     */
    protected boolean hasImplementedOperations = HAS_IMPLEMENTED_OPERATIONS_EDEFAULT;

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
     * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperations()
     * @generated
     * @ordered
     */
    protected EList<IntermediateOperation> operations;

    /**
     * The cached value of the '{@link #getReferredOperations() <em>Referred Operations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReferredOperations()
     * @generated
     * @ordered
     */
    protected EList<IntermediateReferredOperation> referredOperations;

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
    protected IntermediateInterfaceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_INTERFACE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_INTERFACE__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_INTERFACE__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Visibility getVisibility() {
        return visibility;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVisibility(Visibility newVisibility) {
        Visibility oldVisibility = visibility;
        visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_INTERFACE__VISIBILITY, oldVisibility, visibility));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isNotImplemented() {
        return notImplemented;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNotImplemented(boolean newNotImplemented) {
        boolean oldNotImplemented = notImplemented;
        notImplemented = newNotImplemented;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_INTERFACE__NOT_IMPLEMENTED, oldNotImplemented, notImplemented));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isHasImplementedOperations() {
        return hasImplementedOperations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHasImplementedOperations(boolean newHasImplementedOperations) {
        boolean oldHasImplementedOperations = hasImplementedOperations;
        hasImplementedOperations = newHasImplementedOperations;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_INTERFACE__HAS_IMPLEMENTED_OPERATIONS, oldHasImplementedOperations, hasImplementedOperations));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateEndpoint> getEndpoints() {
        if (endpoints == null) {
            endpoints = new EObjectContainmentWithInverseEList<IntermediateEndpoint>(IntermediateEndpoint.class, this, IntermediatePackage.INTERMEDIATE_INTERFACE__ENDPOINTS, IntermediatePackage.INTERMEDIATE_ENDPOINT__INTERFACE);
        }
        return endpoints;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateProtocolSpecification> getProtocols() {
        if (protocols == null) {
            protocols = new EObjectContainmentEList<IntermediateProtocolSpecification>(IntermediateProtocolSpecification.class, this, IntermediatePackage.INTERMEDIATE_INTERFACE__PROTOCOLS);
        }
        return protocols;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateOperation> getOperations() {
        if (operations == null) {
            operations = new EObjectContainmentWithInverseEList<IntermediateOperation>(IntermediateOperation.class, this, IntermediatePackage.INTERMEDIATE_INTERFACE__OPERATIONS, IntermediatePackage.INTERMEDIATE_OPERATION__INTERFACE);
        }
        return operations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateReferredOperation> getReferredOperations() {
        if (referredOperations == null) {
            referredOperations = new EObjectContainmentWithInverseEList<IntermediateReferredOperation>(IntermediateReferredOperation.class, this, IntermediatePackage.INTERMEDIATE_INTERFACE__REFERRED_OPERATIONS, IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__REFERRING_INTERFACE);
        }
        return referredOperations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateImportedAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<IntermediateImportedAspect>(IntermediateImportedAspect.class, this, IntermediatePackage.INTERMEDIATE_INTERFACE__ASPECTS, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__INTERFACE);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateMicroservice getMicroservice() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_INTERFACE__MICROSERVICE) return null;
        return (IntermediateMicroservice)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateMicroservice basicGetMicroservice() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_INTERFACE__MICROSERVICE) return null;
        return (IntermediateMicroservice)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMicroservice(IntermediateMicroservice newMicroservice, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newMicroservice, IntermediatePackage.INTERMEDIATE_INTERFACE__MICROSERVICE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMicroservice(IntermediateMicroservice newMicroservice) {
        if (newMicroservice != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_INTERFACE__MICROSERVICE && newMicroservice != null)) {
            if (EcoreUtil.isAncestor(this, newMicroservice))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newMicroservice != null)
                msgs = ((InternalEObject)newMicroservice).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_MICROSERVICE__INTERFACES, IntermediateMicroservice.class, msgs);
            msgs = basicSetMicroservice(newMicroservice, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_INTERFACE__MICROSERVICE, newMicroservice, newMicroservice));
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
            case IntermediatePackage.INTERMEDIATE_INTERFACE__ENDPOINTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getEndpoints()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_INTERFACE__OPERATIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getOperations()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_INTERFACE__REFERRED_OPERATIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getReferredOperations()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_INTERFACE__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_INTERFACE__MICROSERVICE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetMicroservice((IntermediateMicroservice)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_INTERFACE__ENDPOINTS:
                return ((InternalEList<?>)getEndpoints()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_INTERFACE__PROTOCOLS:
                return ((InternalEList<?>)getProtocols()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_INTERFACE__OPERATIONS:
                return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_INTERFACE__REFERRED_OPERATIONS:
                return ((InternalEList<?>)getReferredOperations()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_INTERFACE__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_INTERFACE__MICROSERVICE:
                return basicSetMicroservice(null, msgs);
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
            case IntermediatePackage.INTERMEDIATE_INTERFACE__MICROSERVICE:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_MICROSERVICE__INTERFACES, IntermediateMicroservice.class, msgs);
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
            case IntermediatePackage.INTERMEDIATE_INTERFACE__NAME:
                return getName();
            case IntermediatePackage.INTERMEDIATE_INTERFACE__QUALIFIED_NAME:
                return getQualifiedName();
            case IntermediatePackage.INTERMEDIATE_INTERFACE__VISIBILITY:
                return getVisibility();
            case IntermediatePackage.INTERMEDIATE_INTERFACE__NOT_IMPLEMENTED:
                return isNotImplemented();
            case IntermediatePackage.INTERMEDIATE_INTERFACE__HAS_IMPLEMENTED_OPERATIONS:
                return isHasImplementedOperations();
            case IntermediatePackage.INTERMEDIATE_INTERFACE__ENDPOINTS:
                return getEndpoints();
            case IntermediatePackage.INTERMEDIATE_INTERFACE__PROTOCOLS:
                return getProtocols();
            case IntermediatePackage.INTERMEDIATE_INTERFACE__OPERATIONS:
                return getOperations();
            case IntermediatePackage.INTERMEDIATE_INTERFACE__REFERRED_OPERATIONS:
                return getReferredOperations();
            case IntermediatePackage.INTERMEDIATE_INTERFACE__ASPECTS:
                return getAspects();
            case IntermediatePackage.INTERMEDIATE_INTERFACE__MICROSERVICE:
                if (resolve) return getMicroservice();
                return basicGetMicroservice();
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
            case IntermediatePackage.INTERMEDIATE_INTERFACE__NAME:
                setName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__QUALIFIED_NAME:
                setQualifiedName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__VISIBILITY:
                setVisibility((Visibility)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__NOT_IMPLEMENTED:
                setNotImplemented((Boolean)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__HAS_IMPLEMENTED_OPERATIONS:
                setHasImplementedOperations((Boolean)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__ENDPOINTS:
                getEndpoints().clear();
                getEndpoints().addAll((Collection<? extends IntermediateEndpoint>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__PROTOCOLS:
                getProtocols().clear();
                getProtocols().addAll((Collection<? extends IntermediateProtocolSpecification>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__OPERATIONS:
                getOperations().clear();
                getOperations().addAll((Collection<? extends IntermediateOperation>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__REFERRED_OPERATIONS:
                getReferredOperations().clear();
                getReferredOperations().addAll((Collection<? extends IntermediateReferredOperation>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends IntermediateImportedAspect>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__MICROSERVICE:
                setMicroservice((IntermediateMicroservice)newValue);
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
            case IntermediatePackage.INTERMEDIATE_INTERFACE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__QUALIFIED_NAME:
                setQualifiedName(QUALIFIED_NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__VISIBILITY:
                setVisibility(VISIBILITY_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__NOT_IMPLEMENTED:
                setNotImplemented(NOT_IMPLEMENTED_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__HAS_IMPLEMENTED_OPERATIONS:
                setHasImplementedOperations(HAS_IMPLEMENTED_OPERATIONS_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__ENDPOINTS:
                getEndpoints().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__PROTOCOLS:
                getProtocols().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__OPERATIONS:
                getOperations().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__REFERRED_OPERATIONS:
                getReferredOperations().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__ASPECTS:
                getAspects().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__MICROSERVICE:
                setMicroservice((IntermediateMicroservice)null);
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
            case IntermediatePackage.INTERMEDIATE_INTERFACE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case IntermediatePackage.INTERMEDIATE_INTERFACE__QUALIFIED_NAME:
                return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
            case IntermediatePackage.INTERMEDIATE_INTERFACE__VISIBILITY:
                return visibility != VISIBILITY_EDEFAULT;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__NOT_IMPLEMENTED:
                return notImplemented != NOT_IMPLEMENTED_EDEFAULT;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__HAS_IMPLEMENTED_OPERATIONS:
                return hasImplementedOperations != HAS_IMPLEMENTED_OPERATIONS_EDEFAULT;
            case IntermediatePackage.INTERMEDIATE_INTERFACE__ENDPOINTS:
                return endpoints != null && !endpoints.isEmpty();
            case IntermediatePackage.INTERMEDIATE_INTERFACE__PROTOCOLS:
                return protocols != null && !protocols.isEmpty();
            case IntermediatePackage.INTERMEDIATE_INTERFACE__OPERATIONS:
                return operations != null && !operations.isEmpty();
            case IntermediatePackage.INTERMEDIATE_INTERFACE__REFERRED_OPERATIONS:
                return referredOperations != null && !referredOperations.isEmpty();
            case IntermediatePackage.INTERMEDIATE_INTERFACE__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case IntermediatePackage.INTERMEDIATE_INTERFACE__MICROSERVICE:
                return basicGetMicroservice() != null;
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
        result.append(", qualifiedName: ");
        result.append(qualifiedName);
        result.append(", visibility: ");
        result.append(visibility);
        result.append(", notImplemented: ");
        result.append(notImplemented);
        result.append(", hasImplementedOperations: ");
        result.append(hasImplementedOperations);
        result.append(')');
        return result.toString();
    }

} //IntermediateInterfaceImpl
