/**
 */
package de.fhdo.lemma.service.intermediate.impl;

import de.fhdo.lemma.service.intermediate.IntermediatePackage;
import de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Protocol Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateProtocolSpecificationImpl#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateProtocolSpecificationImpl#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateProtocolSpecificationImpl#getDataFormat <em>Data Format</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateProtocolSpecificationImpl extends MinimalEObjectImpl.Container implements IntermediateProtocolSpecification {
    /**
     * The default value of the '{@link #getCommunicationType() <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCommunicationType()
     * @generated
     * @ordered
     */
    protected static final String COMMUNICATION_TYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCommunicationType() <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCommunicationType()
     * @generated
     * @ordered
     */
    protected String communicationType = COMMUNICATION_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getProtocol() <em>Protocol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProtocol()
     * @generated
     * @ordered
     */
    protected static final String PROTOCOL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getProtocol() <em>Protocol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProtocol()
     * @generated
     * @ordered
     */
    protected String protocol = PROTOCOL_EDEFAULT;

    /**
     * The default value of the '{@link #getDataFormat() <em>Data Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataFormat()
     * @generated
     * @ordered
     */
    protected static final String DATA_FORMAT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDataFormat() <em>Data Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataFormat()
     * @generated
     * @ordered
     */
    protected String dataFormat = DATA_FORMAT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediateProtocolSpecificationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_PROTOCOL_SPECIFICATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getCommunicationType() {
        return communicationType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setCommunicationType(String newCommunicationType) {
        String oldCommunicationType = communicationType;
        communicationType = newCommunicationType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE, oldCommunicationType, communicationType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getProtocol() {
        return protocol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setProtocol(String newProtocol) {
        String oldProtocol = protocol;
        protocol = newProtocol;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_PROTOCOL_SPECIFICATION__PROTOCOL, oldProtocol, protocol));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getDataFormat() {
        return dataFormat;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDataFormat(String newDataFormat) {
        String oldDataFormat = dataFormat;
        dataFormat = newDataFormat;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_PROTOCOL_SPECIFICATION__DATA_FORMAT, oldDataFormat, dataFormat));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case IntermediatePackage.INTERMEDIATE_PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE:
                return getCommunicationType();
            case IntermediatePackage.INTERMEDIATE_PROTOCOL_SPECIFICATION__PROTOCOL:
                return getProtocol();
            case IntermediatePackage.INTERMEDIATE_PROTOCOL_SPECIFICATION__DATA_FORMAT:
                return getDataFormat();
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
            case IntermediatePackage.INTERMEDIATE_PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE:
                setCommunicationType((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_PROTOCOL_SPECIFICATION__PROTOCOL:
                setProtocol((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_PROTOCOL_SPECIFICATION__DATA_FORMAT:
                setDataFormat((String)newValue);
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
            case IntermediatePackage.INTERMEDIATE_PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE:
                setCommunicationType(COMMUNICATION_TYPE_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_PROTOCOL_SPECIFICATION__PROTOCOL:
                setProtocol(PROTOCOL_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_PROTOCOL_SPECIFICATION__DATA_FORMAT:
                setDataFormat(DATA_FORMAT_EDEFAULT);
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
            case IntermediatePackage.INTERMEDIATE_PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE:
                return COMMUNICATION_TYPE_EDEFAULT == null ? communicationType != null : !COMMUNICATION_TYPE_EDEFAULT.equals(communicationType);
            case IntermediatePackage.INTERMEDIATE_PROTOCOL_SPECIFICATION__PROTOCOL:
                return PROTOCOL_EDEFAULT == null ? protocol != null : !PROTOCOL_EDEFAULT.equals(protocol);
            case IntermediatePackage.INTERMEDIATE_PROTOCOL_SPECIFICATION__DATA_FORMAT:
                return DATA_FORMAT_EDEFAULT == null ? dataFormat != null : !DATA_FORMAT_EDEFAULT.equals(dataFormat);
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
        result.append(" (communicationType: ");
        result.append(communicationType);
        result.append(", protocol: ");
        result.append(protocol);
        result.append(", dataFormat: ");
        result.append(dataFormat);
        result.append(')');
        return result.toString();
    }

} //IntermediateProtocolSpecificationImpl
