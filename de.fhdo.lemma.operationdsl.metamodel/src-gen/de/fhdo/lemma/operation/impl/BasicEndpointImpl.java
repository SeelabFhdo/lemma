/**
 */
package de.fhdo.lemma.operation.impl;

import de.fhdo.lemma.operation.BasicEndpoint;
import de.fhdo.lemma.operation.InfrastructureNode;
import de.fhdo.lemma.operation.OperationPackage;
import de.fhdo.lemma.operation.ProtocolAndDataFormat;
import de.fhdo.lemma.operation.ServiceDeploymentSpecification;

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
 * An implementation of the model object '<em><b>Basic Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.impl.BasicEndpointImpl#getAddresses <em>Addresses</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.BasicEndpointImpl#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.BasicEndpointImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.BasicEndpointImpl#getInfrastructureNode <em>Infrastructure Node</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.BasicEndpointImpl#getDeploymentSpecification <em>Deployment Specification</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BasicEndpointImpl extends MinimalEObjectImpl.Container implements BasicEndpoint {
    /**
     * The cached value of the '{@link #getAddresses() <em>Addresses</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAddresses()
     * @generated
     * @ordered
     */
    protected EList<String> addresses;

    /**
     * The cached value of the '{@link #getProtocols() <em>Protocols</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProtocols()
     * @generated
     * @ordered
     */
    protected EList<ProtocolAndDataFormat> protocols;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BasicEndpointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return OperationPackage.Literals.BASIC_ENDPOINT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getAddresses() {
        if (addresses == null) {
            addresses = new EDataTypeEList<String>(String.class, this, OperationPackage.BASIC_ENDPOINT__ADDRESSES);
        }
        return addresses;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ProtocolAndDataFormat> getProtocols() {
        if (protocols == null) {
            protocols = new EObjectContainmentWithInverseEList<ProtocolAndDataFormat>(ProtocolAndDataFormat.class, this, OperationPackage.BASIC_ENDPOINT__PROTOCOLS, OperationPackage.PROTOCOL_AND_DATA_FORMAT__ENDPOINT);
        }
        return protocols;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public de.fhdo.lemma.operation.Container getContainer() {
        if (eContainerFeatureID() != OperationPackage.BASIC_ENDPOINT__CONTAINER) return null;
        return (de.fhdo.lemma.operation.Container)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public de.fhdo.lemma.operation.Container basicGetContainer() {
        if (eContainerFeatureID() != OperationPackage.BASIC_ENDPOINT__CONTAINER) return null;
        return (de.fhdo.lemma.operation.Container)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetContainer(de.fhdo.lemma.operation.Container newContainer, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newContainer, OperationPackage.BASIC_ENDPOINT__CONTAINER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContainer(de.fhdo.lemma.operation.Container newContainer) {
        if (newContainer != eInternalContainer() || (eContainerFeatureID() != OperationPackage.BASIC_ENDPOINT__CONTAINER && newContainer != null)) {
            if (EcoreUtil.isAncestor(this, newContainer))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newContainer != null)
                msgs = ((InternalEObject)newContainer).eInverseAdd(this, OperationPackage.CONTAINER__DEFAULT_BASIC_ENDPOINTS, de.fhdo.lemma.operation.Container.class, msgs);
            msgs = basicSetContainer(newContainer, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.BASIC_ENDPOINT__CONTAINER, newContainer, newContainer));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureNode getInfrastructureNode() {
        if (eContainerFeatureID() != OperationPackage.BASIC_ENDPOINT__INFRASTRUCTURE_NODE) return null;
        return (InfrastructureNode)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureNode basicGetInfrastructureNode() {
        if (eContainerFeatureID() != OperationPackage.BASIC_ENDPOINT__INFRASTRUCTURE_NODE) return null;
        return (InfrastructureNode)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInfrastructureNode(InfrastructureNode newInfrastructureNode, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newInfrastructureNode, OperationPackage.BASIC_ENDPOINT__INFRASTRUCTURE_NODE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInfrastructureNode(InfrastructureNode newInfrastructureNode) {
        if (newInfrastructureNode != eInternalContainer() || (eContainerFeatureID() != OperationPackage.BASIC_ENDPOINT__INFRASTRUCTURE_NODE && newInfrastructureNode != null)) {
            if (EcoreUtil.isAncestor(this, newInfrastructureNode))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newInfrastructureNode != null)
                msgs = ((InternalEObject)newInfrastructureNode).eInverseAdd(this, OperationPackage.INFRASTRUCTURE_NODE__ENDPOINTS, InfrastructureNode.class, msgs);
            msgs = basicSetInfrastructureNode(newInfrastructureNode, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.BASIC_ENDPOINT__INFRASTRUCTURE_NODE, newInfrastructureNode, newInfrastructureNode));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ServiceDeploymentSpecification getDeploymentSpecification() {
        if (eContainerFeatureID() != OperationPackage.BASIC_ENDPOINT__DEPLOYMENT_SPECIFICATION) return null;
        return (ServiceDeploymentSpecification)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ServiceDeploymentSpecification basicGetDeploymentSpecification() {
        if (eContainerFeatureID() != OperationPackage.BASIC_ENDPOINT__DEPLOYMENT_SPECIFICATION) return null;
        return (ServiceDeploymentSpecification)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDeploymentSpecification(ServiceDeploymentSpecification newDeploymentSpecification, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDeploymentSpecification, OperationPackage.BASIC_ENDPOINT__DEPLOYMENT_SPECIFICATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDeploymentSpecification(ServiceDeploymentSpecification newDeploymentSpecification) {
        if (newDeploymentSpecification != eInternalContainer() || (eContainerFeatureID() != OperationPackage.BASIC_ENDPOINT__DEPLOYMENT_SPECIFICATION && newDeploymentSpecification != null)) {
            if (EcoreUtil.isAncestor(this, newDeploymentSpecification))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDeploymentSpecification != null)
                msgs = ((InternalEObject)newDeploymentSpecification).eInverseAdd(this, OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__BASIC_ENDPOINTS, ServiceDeploymentSpecification.class, msgs);
            msgs = basicSetDeploymentSpecification(newDeploymentSpecification, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.BASIC_ENDPOINT__DEPLOYMENT_SPECIFICATION, newDeploymentSpecification, newDeploymentSpecification));
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
            case OperationPackage.BASIC_ENDPOINT__PROTOCOLS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getProtocols()).basicAdd(otherEnd, msgs);
            case OperationPackage.BASIC_ENDPOINT__CONTAINER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetContainer((de.fhdo.lemma.operation.Container)otherEnd, msgs);
            case OperationPackage.BASIC_ENDPOINT__INFRASTRUCTURE_NODE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetInfrastructureNode((InfrastructureNode)otherEnd, msgs);
            case OperationPackage.BASIC_ENDPOINT__DEPLOYMENT_SPECIFICATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDeploymentSpecification((ServiceDeploymentSpecification)otherEnd, msgs);
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
            case OperationPackage.BASIC_ENDPOINT__PROTOCOLS:
                return ((InternalEList<?>)getProtocols()).basicRemove(otherEnd, msgs);
            case OperationPackage.BASIC_ENDPOINT__CONTAINER:
                return basicSetContainer(null, msgs);
            case OperationPackage.BASIC_ENDPOINT__INFRASTRUCTURE_NODE:
                return basicSetInfrastructureNode(null, msgs);
            case OperationPackage.BASIC_ENDPOINT__DEPLOYMENT_SPECIFICATION:
                return basicSetDeploymentSpecification(null, msgs);
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
            case OperationPackage.BASIC_ENDPOINT__CONTAINER:
                return eInternalContainer().eInverseRemove(this, OperationPackage.CONTAINER__DEFAULT_BASIC_ENDPOINTS, de.fhdo.lemma.operation.Container.class, msgs);
            case OperationPackage.BASIC_ENDPOINT__INFRASTRUCTURE_NODE:
                return eInternalContainer().eInverseRemove(this, OperationPackage.INFRASTRUCTURE_NODE__ENDPOINTS, InfrastructureNode.class, msgs);
            case OperationPackage.BASIC_ENDPOINT__DEPLOYMENT_SPECIFICATION:
                return eInternalContainer().eInverseRemove(this, OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__BASIC_ENDPOINTS, ServiceDeploymentSpecification.class, msgs);
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
            case OperationPackage.BASIC_ENDPOINT__ADDRESSES:
                return getAddresses();
            case OperationPackage.BASIC_ENDPOINT__PROTOCOLS:
                return getProtocols();
            case OperationPackage.BASIC_ENDPOINT__CONTAINER:
                if (resolve) return getContainer();
                return basicGetContainer();
            case OperationPackage.BASIC_ENDPOINT__INFRASTRUCTURE_NODE:
                if (resolve) return getInfrastructureNode();
                return basicGetInfrastructureNode();
            case OperationPackage.BASIC_ENDPOINT__DEPLOYMENT_SPECIFICATION:
                if (resolve) return getDeploymentSpecification();
                return basicGetDeploymentSpecification();
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
            case OperationPackage.BASIC_ENDPOINT__ADDRESSES:
                getAddresses().clear();
                getAddresses().addAll((Collection<? extends String>)newValue);
                return;
            case OperationPackage.BASIC_ENDPOINT__PROTOCOLS:
                getProtocols().clear();
                getProtocols().addAll((Collection<? extends ProtocolAndDataFormat>)newValue);
                return;
            case OperationPackage.BASIC_ENDPOINT__CONTAINER:
                setContainer((de.fhdo.lemma.operation.Container)newValue);
                return;
            case OperationPackage.BASIC_ENDPOINT__INFRASTRUCTURE_NODE:
                setInfrastructureNode((InfrastructureNode)newValue);
                return;
            case OperationPackage.BASIC_ENDPOINT__DEPLOYMENT_SPECIFICATION:
                setDeploymentSpecification((ServiceDeploymentSpecification)newValue);
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
            case OperationPackage.BASIC_ENDPOINT__ADDRESSES:
                getAddresses().clear();
                return;
            case OperationPackage.BASIC_ENDPOINT__PROTOCOLS:
                getProtocols().clear();
                return;
            case OperationPackage.BASIC_ENDPOINT__CONTAINER:
                setContainer((de.fhdo.lemma.operation.Container)null);
                return;
            case OperationPackage.BASIC_ENDPOINT__INFRASTRUCTURE_NODE:
                setInfrastructureNode((InfrastructureNode)null);
                return;
            case OperationPackage.BASIC_ENDPOINT__DEPLOYMENT_SPECIFICATION:
                setDeploymentSpecification((ServiceDeploymentSpecification)null);
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
            case OperationPackage.BASIC_ENDPOINT__ADDRESSES:
                return addresses != null && !addresses.isEmpty();
            case OperationPackage.BASIC_ENDPOINT__PROTOCOLS:
                return protocols != null && !protocols.isEmpty();
            case OperationPackage.BASIC_ENDPOINT__CONTAINER:
                return basicGetContainer() != null;
            case OperationPackage.BASIC_ENDPOINT__INFRASTRUCTURE_NODE:
                return basicGetInfrastructureNode() != null;
            case OperationPackage.BASIC_ENDPOINT__DEPLOYMENT_SPECIFICATION:
                return basicGetDeploymentSpecification() != null;
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
        result.append(" (addresses: ");
        result.append(addresses);
        result.append(')');
        return result.toString();
    }

} //BasicEndpointImpl
