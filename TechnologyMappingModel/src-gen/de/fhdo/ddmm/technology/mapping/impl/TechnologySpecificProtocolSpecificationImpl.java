/**
 */
package de.fhdo.ddmm.technology.mapping.impl;

import de.fhdo.ddmm.technology.CommunicationType;

import de.fhdo.ddmm.technology.mapping.MappingPackage;
import de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocol;
import de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocolSpecification;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Technology Specific Protocol Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologySpecificProtocolSpecificationImpl#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologySpecificProtocolSpecificationImpl#getTechnologySpecificProtocol <em>Technology Specific Protocol</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TechnologySpecificProtocolSpecificationImpl extends MinimalEObjectImpl.Container implements TechnologySpecificProtocolSpecification {
    /**
     * The default value of the '{@link #getCommunicationType() <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCommunicationType()
     * @generated
     * @ordered
     */
    protected static final CommunicationType COMMUNICATION_TYPE_EDEFAULT = CommunicationType.SYNCHRONOUS;

    /**
     * The cached value of the '{@link #getCommunicationType() <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCommunicationType()
     * @generated
     * @ordered
     */
    protected CommunicationType communicationType = COMMUNICATION_TYPE_EDEFAULT;

    /**
     * The cached value of the '{@link #getTechnologySpecificProtocol() <em>Technology Specific Protocol</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTechnologySpecificProtocol()
     * @generated
     * @ordered
     */
    protected TechnologySpecificProtocol technologySpecificProtocol;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TechnologySpecificProtocolSpecificationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CommunicationType getCommunicationType() {
        return communicationType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCommunicationType(CommunicationType newCommunicationType) {
        CommunicationType oldCommunicationType = communicationType;
        communicationType = newCommunicationType == null ? COMMUNICATION_TYPE_EDEFAULT : newCommunicationType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE, oldCommunicationType, communicationType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologySpecificProtocol getTechnologySpecificProtocol() {
        return technologySpecificProtocol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTechnologySpecificProtocol(TechnologySpecificProtocol newTechnologySpecificProtocol, NotificationChain msgs) {
        TechnologySpecificProtocol oldTechnologySpecificProtocol = technologySpecificProtocol;
        technologySpecificProtocol = newTechnologySpecificProtocol;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__TECHNOLOGY_SPECIFIC_PROTOCOL, oldTechnologySpecificProtocol, newTechnologySpecificProtocol);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTechnologySpecificProtocol(TechnologySpecificProtocol newTechnologySpecificProtocol) {
        if (newTechnologySpecificProtocol != technologySpecificProtocol) {
            NotificationChain msgs = null;
            if (technologySpecificProtocol != null)
                msgs = ((InternalEObject)technologySpecificProtocol).eInverseRemove(this, MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL_SPECIFICATION, TechnologySpecificProtocol.class, msgs);
            if (newTechnologySpecificProtocol != null)
                msgs = ((InternalEObject)newTechnologySpecificProtocol).eInverseAdd(this, MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL_SPECIFICATION, TechnologySpecificProtocol.class, msgs);
            msgs = basicSetTechnologySpecificProtocol(newTechnologySpecificProtocol, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__TECHNOLOGY_SPECIFIC_PROTOCOL, newTechnologySpecificProtocol, newTechnologySpecificProtocol));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__TECHNOLOGY_SPECIFIC_PROTOCOL:
                if (technologySpecificProtocol != null)
                    msgs = ((InternalEObject)technologySpecificProtocol).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__TECHNOLOGY_SPECIFIC_PROTOCOL, null, msgs);
                return basicSetTechnologySpecificProtocol((TechnologySpecificProtocol)otherEnd, msgs);
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__TECHNOLOGY_SPECIFIC_PROTOCOL:
                return basicSetTechnologySpecificProtocol(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE:
                return getCommunicationType();
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__TECHNOLOGY_SPECIFIC_PROTOCOL:
                return getTechnologySpecificProtocol();
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE:
                setCommunicationType((CommunicationType)newValue);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__TECHNOLOGY_SPECIFIC_PROTOCOL:
                setTechnologySpecificProtocol((TechnologySpecificProtocol)newValue);
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE:
                setCommunicationType(COMMUNICATION_TYPE_EDEFAULT);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__TECHNOLOGY_SPECIFIC_PROTOCOL:
                setTechnologySpecificProtocol((TechnologySpecificProtocol)null);
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE:
                return communicationType != COMMUNICATION_TYPE_EDEFAULT;
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__TECHNOLOGY_SPECIFIC_PROTOCOL:
                return technologySpecificProtocol != null;
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
        result.append(" (communicationType: ");
        result.append(communicationType);
        result.append(')');
        return result.toString();
    }

} //TechnologySpecificProtocolSpecificationImpl
