/**
 */
package de.fhdo.lemma.service.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect;

import de.fhdo.lemma.service.Visibility;

import de.fhdo.lemma.service.intermediate.IntermediateEndpoint;
import de.fhdo.lemma.service.intermediate.IntermediateInterface;
import de.fhdo.lemma.service.intermediate.IntermediateOperation;
import de.fhdo.lemma.service.intermediate.IntermediatePackage;
import de.fhdo.lemma.service.intermediate.IntermediateParameter;
import de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification;

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
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateOperationImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateOperationImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateOperationImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateOperationImpl#isNotImplemented <em>Not Implemented</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateOperationImpl#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateOperationImpl#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateOperationImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateOperationImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateOperationImpl#getInterface <em>Interface</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateOperationImpl extends MinimalEObjectImpl.Container implements IntermediateOperation {
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
     * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParameters()
     * @generated
     * @ordered
     */
    protected EList<IntermediateParameter> parameters;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediateOperationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_OPERATION;
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Visibility getVisibility() {
        return visibility;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setVisibility(Visibility newVisibility) {
        Visibility oldVisibility = visibility;
        visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION__VISIBILITY, oldVisibility, visibility));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isNotImplemented() {
        return notImplemented;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setNotImplemented(boolean newNotImplemented) {
        boolean oldNotImplemented = notImplemented;
        notImplemented = newNotImplemented;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION__NOT_IMPLEMENTED, oldNotImplemented, notImplemented));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<IntermediateEndpoint> getEndpoints() {
        if (endpoints == null) {
            endpoints = new EObjectContainmentWithInverseEList<IntermediateEndpoint>(IntermediateEndpoint.class, this, IntermediatePackage.INTERMEDIATE_OPERATION__ENDPOINTS, IntermediatePackage.INTERMEDIATE_ENDPOINT__OPERATION);
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
            protocols = new EObjectContainmentEList<IntermediateProtocolSpecification>(IntermediateProtocolSpecification.class, this, IntermediatePackage.INTERMEDIATE_OPERATION__PROTOCOLS);
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
            aspects = new EObjectContainmentEList<IntermediateImportedAspect>(IntermediateImportedAspect.class, this, IntermediatePackage.INTERMEDIATE_OPERATION__ASPECTS);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<IntermediateParameter> getParameters() {
        if (parameters == null) {
            parameters = new EObjectContainmentWithInverseEList<IntermediateParameter>(IntermediateParameter.class, this, IntermediatePackage.INTERMEDIATE_OPERATION__PARAMETERS, IntermediatePackage.INTERMEDIATE_PARAMETER__OPERATION);
        }
        return parameters;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateInterface getInterface() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_OPERATION__INTERFACE) return null;
        return (IntermediateInterface)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateInterface basicGetInterface() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_OPERATION__INTERFACE) return null;
        return (IntermediateInterface)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInterface(IntermediateInterface newInterface, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newInterface, IntermediatePackage.INTERMEDIATE_OPERATION__INTERFACE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setInterface(IntermediateInterface newInterface) {
        if (newInterface != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_OPERATION__INTERFACE && newInterface != null)) {
            if (EcoreUtil.isAncestor(this, newInterface))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newInterface != null)
                msgs = ((InternalEObject)newInterface).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_INTERFACE__OPERATIONS, IntermediateInterface.class, msgs);
            msgs = basicSetInterface(newInterface, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION__INTERFACE, newInterface, newInterface));
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
            case IntermediatePackage.INTERMEDIATE_OPERATION__ENDPOINTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getEndpoints()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION__PARAMETERS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameters()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION__INTERFACE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetInterface((IntermediateInterface)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_OPERATION__ENDPOINTS:
                return ((InternalEList<?>)getEndpoints()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION__PROTOCOLS:
                return ((InternalEList<?>)getProtocols()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION__PARAMETERS:
                return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION__INTERFACE:
                return basicSetInterface(null, msgs);
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
            case IntermediatePackage.INTERMEDIATE_OPERATION__INTERFACE:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_INTERFACE__OPERATIONS, IntermediateInterface.class, msgs);
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
            case IntermediatePackage.INTERMEDIATE_OPERATION__NAME:
                return getName();
            case IntermediatePackage.INTERMEDIATE_OPERATION__QUALIFIED_NAME:
                return getQualifiedName();
            case IntermediatePackage.INTERMEDIATE_OPERATION__VISIBILITY:
                return getVisibility();
            case IntermediatePackage.INTERMEDIATE_OPERATION__NOT_IMPLEMENTED:
                return isNotImplemented();
            case IntermediatePackage.INTERMEDIATE_OPERATION__ENDPOINTS:
                return getEndpoints();
            case IntermediatePackage.INTERMEDIATE_OPERATION__PROTOCOLS:
                return getProtocols();
            case IntermediatePackage.INTERMEDIATE_OPERATION__ASPECTS:
                return getAspects();
            case IntermediatePackage.INTERMEDIATE_OPERATION__PARAMETERS:
                return getParameters();
            case IntermediatePackage.INTERMEDIATE_OPERATION__INTERFACE:
                if (resolve) return getInterface();
                return basicGetInterface();
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
            case IntermediatePackage.INTERMEDIATE_OPERATION__NAME:
                setName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION__QUALIFIED_NAME:
                setQualifiedName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION__VISIBILITY:
                setVisibility((Visibility)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION__NOT_IMPLEMENTED:
                setNotImplemented((Boolean)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION__ENDPOINTS:
                getEndpoints().clear();
                getEndpoints().addAll((Collection<? extends IntermediateEndpoint>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION__PROTOCOLS:
                getProtocols().clear();
                getProtocols().addAll((Collection<? extends IntermediateProtocolSpecification>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends IntermediateImportedAspect>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION__PARAMETERS:
                getParameters().clear();
                getParameters().addAll((Collection<? extends IntermediateParameter>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION__INTERFACE:
                setInterface((IntermediateInterface)newValue);
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
            case IntermediatePackage.INTERMEDIATE_OPERATION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION__QUALIFIED_NAME:
                setQualifiedName(QUALIFIED_NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION__VISIBILITY:
                setVisibility(VISIBILITY_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION__NOT_IMPLEMENTED:
                setNotImplemented(NOT_IMPLEMENTED_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION__ENDPOINTS:
                getEndpoints().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION__PROTOCOLS:
                getProtocols().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION__ASPECTS:
                getAspects().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION__PARAMETERS:
                getParameters().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION__INTERFACE:
                setInterface((IntermediateInterface)null);
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
            case IntermediatePackage.INTERMEDIATE_OPERATION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case IntermediatePackage.INTERMEDIATE_OPERATION__QUALIFIED_NAME:
                return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
            case IntermediatePackage.INTERMEDIATE_OPERATION__VISIBILITY:
                return visibility != VISIBILITY_EDEFAULT;
            case IntermediatePackage.INTERMEDIATE_OPERATION__NOT_IMPLEMENTED:
                return notImplemented != NOT_IMPLEMENTED_EDEFAULT;
            case IntermediatePackage.INTERMEDIATE_OPERATION__ENDPOINTS:
                return endpoints != null && !endpoints.isEmpty();
            case IntermediatePackage.INTERMEDIATE_OPERATION__PROTOCOLS:
                return protocols != null && !protocols.isEmpty();
            case IntermediatePackage.INTERMEDIATE_OPERATION__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case IntermediatePackage.INTERMEDIATE_OPERATION__PARAMETERS:
                return parameters != null && !parameters.isEmpty();
            case IntermediatePackage.INTERMEDIATE_OPERATION__INTERFACE:
                return basicGetInterface() != null;
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
        result.append(", visibility: ");
        result.append(visibility);
        result.append(", notImplemented: ");
        result.append(notImplemented);
        result.append(')');
        return result.toString();
    }

} //IntermediateOperationImpl
