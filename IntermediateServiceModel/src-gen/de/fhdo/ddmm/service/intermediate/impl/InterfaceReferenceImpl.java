/**
 */
package de.fhdo.ddmm.service.intermediate.impl;

import de.fhdo.ddmm.data.intermediate.IntermediateImport;

import de.fhdo.ddmm.service.intermediate.InterfaceReference;
import de.fhdo.ddmm.service.intermediate.IntermediateInterface;
import de.fhdo.ddmm.service.intermediate.IntermediateMicroservice;
import de.fhdo.ddmm.service.intermediate.IntermediatePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.InterfaceReferenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.InterfaceReferenceImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.InterfaceReferenceImpl#isImported <em>Imported</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.InterfaceReferenceImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.InterfaceReferenceImpl#getLocalInterface <em>Local Interface</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.impl.InterfaceReferenceImpl#getRequiringMicroservice <em>Requiring Microservice</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InterfaceReferenceImpl extends MinimalEObjectImpl.Container implements InterfaceReference {
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
     * The cached value of the '{@link #getLocalInterface() <em>Local Interface</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocalInterface()
     * @generated
     * @ordered
     */
    protected IntermediateInterface localInterface;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected InterfaceReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERFACE_REFERENCE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERFACE_REFERENCE__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERFACE_REFERENCE__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERFACE_REFERENCE__IMPORTED, oldImported, imported));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERFACE_REFERENCE__IMPORT, oldImport, import_));
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERFACE_REFERENCE__IMPORT, oldImport, import_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateInterface getLocalInterface() {
        if (localInterface != null && localInterface.eIsProxy()) {
            InternalEObject oldLocalInterface = (InternalEObject)localInterface;
            localInterface = (IntermediateInterface)eResolveProxy(oldLocalInterface);
            if (localInterface != oldLocalInterface) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERFACE_REFERENCE__LOCAL_INTERFACE, oldLocalInterface, localInterface));
            }
        }
        return localInterface;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateInterface basicGetLocalInterface() {
        return localInterface;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setLocalInterface(IntermediateInterface newLocalInterface) {
        IntermediateInterface oldLocalInterface = localInterface;
        localInterface = newLocalInterface;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERFACE_REFERENCE__LOCAL_INTERFACE, oldLocalInterface, localInterface));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateMicroservice getRequiringMicroservice() {
        if (eContainerFeatureID() != IntermediatePackage.INTERFACE_REFERENCE__REQUIRING_MICROSERVICE) return null;
        return (IntermediateMicroservice)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateMicroservice basicGetRequiringMicroservice() {
        if (eContainerFeatureID() != IntermediatePackage.INTERFACE_REFERENCE__REQUIRING_MICROSERVICE) return null;
        return (IntermediateMicroservice)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetRequiringMicroservice(IntermediateMicroservice newRequiringMicroservice, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newRequiringMicroservice, IntermediatePackage.INTERFACE_REFERENCE__REQUIRING_MICROSERVICE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setRequiringMicroservice(IntermediateMicroservice newRequiringMicroservice) {
        if (newRequiringMicroservice != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERFACE_REFERENCE__REQUIRING_MICROSERVICE && newRequiringMicroservice != null)) {
            if (EcoreUtil.isAncestor(this, newRequiringMicroservice))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newRequiringMicroservice != null)
                msgs = ((InternalEObject)newRequiringMicroservice).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_INTERFACES, IntermediateMicroservice.class, msgs);
            msgs = basicSetRequiringMicroservice(newRequiringMicroservice, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERFACE_REFERENCE__REQUIRING_MICROSERVICE, newRequiringMicroservice, newRequiringMicroservice));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case IntermediatePackage.INTERFACE_REFERENCE__REQUIRING_MICROSERVICE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetRequiringMicroservice((IntermediateMicroservice)otherEnd, msgs);
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
            case IntermediatePackage.INTERFACE_REFERENCE__REQUIRING_MICROSERVICE:
                return basicSetRequiringMicroservice(null, msgs);
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
            case IntermediatePackage.INTERFACE_REFERENCE__REQUIRING_MICROSERVICE:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_INTERFACES, IntermediateMicroservice.class, msgs);
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
            case IntermediatePackage.INTERFACE_REFERENCE__NAME:
                return getName();
            case IntermediatePackage.INTERFACE_REFERENCE__QUALIFIED_NAME:
                return getQualifiedName();
            case IntermediatePackage.INTERFACE_REFERENCE__IMPORTED:
                return isImported();
            case IntermediatePackage.INTERFACE_REFERENCE__IMPORT:
                if (resolve) return getImport();
                return basicGetImport();
            case IntermediatePackage.INTERFACE_REFERENCE__LOCAL_INTERFACE:
                if (resolve) return getLocalInterface();
                return basicGetLocalInterface();
            case IntermediatePackage.INTERFACE_REFERENCE__REQUIRING_MICROSERVICE:
                if (resolve) return getRequiringMicroservice();
                return basicGetRequiringMicroservice();
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
            case IntermediatePackage.INTERFACE_REFERENCE__NAME:
                setName((String)newValue);
                return;
            case IntermediatePackage.INTERFACE_REFERENCE__QUALIFIED_NAME:
                setQualifiedName((String)newValue);
                return;
            case IntermediatePackage.INTERFACE_REFERENCE__IMPORTED:
                setImported((Boolean)newValue);
                return;
            case IntermediatePackage.INTERFACE_REFERENCE__IMPORT:
                setImport((IntermediateImport)newValue);
                return;
            case IntermediatePackage.INTERFACE_REFERENCE__LOCAL_INTERFACE:
                setLocalInterface((IntermediateInterface)newValue);
                return;
            case IntermediatePackage.INTERFACE_REFERENCE__REQUIRING_MICROSERVICE:
                setRequiringMicroservice((IntermediateMicroservice)newValue);
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
            case IntermediatePackage.INTERFACE_REFERENCE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERFACE_REFERENCE__QUALIFIED_NAME:
                setQualifiedName(QUALIFIED_NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERFACE_REFERENCE__IMPORTED:
                setImported(IMPORTED_EDEFAULT);
                return;
            case IntermediatePackage.INTERFACE_REFERENCE__IMPORT:
                setImport((IntermediateImport)null);
                return;
            case IntermediatePackage.INTERFACE_REFERENCE__LOCAL_INTERFACE:
                setLocalInterface((IntermediateInterface)null);
                return;
            case IntermediatePackage.INTERFACE_REFERENCE__REQUIRING_MICROSERVICE:
                setRequiringMicroservice((IntermediateMicroservice)null);
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
            case IntermediatePackage.INTERFACE_REFERENCE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case IntermediatePackage.INTERFACE_REFERENCE__QUALIFIED_NAME:
                return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
            case IntermediatePackage.INTERFACE_REFERENCE__IMPORTED:
                return imported != IMPORTED_EDEFAULT;
            case IntermediatePackage.INTERFACE_REFERENCE__IMPORT:
                return import_ != null;
            case IntermediatePackage.INTERFACE_REFERENCE__LOCAL_INTERFACE:
                return localInterface != null;
            case IntermediatePackage.INTERFACE_REFERENCE__REQUIRING_MICROSERVICE:
                return basicGetRequiringMicroservice() != null;
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

} //InterfaceReferenceImpl
