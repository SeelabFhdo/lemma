/**
 */
package de.fhdo.lemma.service.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import de.fhdo.lemma.service.intermediate.IntermediateMicroservice;
import de.fhdo.lemma.service.intermediate.IntermediatePackage;
import de.fhdo.lemma.service.intermediate.MicroserviceReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Microservice Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.MicroserviceReferenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.MicroserviceReferenceImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.MicroserviceReferenceImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.MicroserviceReferenceImpl#isImported <em>Imported</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.MicroserviceReferenceImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.MicroserviceReferenceImpl#getLocalMicroservice <em>Local Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.MicroserviceReferenceImpl#getRequiringMicroservice <em>Requiring Microservice</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MicroserviceReferenceImpl extends MinimalEObjectImpl.Container implements MicroserviceReference {
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
     * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected static final String VERSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected String version = VERSION_EDEFAULT;

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
     * The cached value of the '{@link #getLocalMicroservice() <em>Local Microservice</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocalMicroservice()
     * @generated
     * @ordered
     */
    protected IntermediateMicroservice localMicroservice;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MicroserviceReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.MICROSERVICE_REFERENCE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.MICROSERVICE_REFERENCE__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getVersion() {
        return version;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVersion(String newVersion) {
        String oldVersion = version;
        version = newVersion;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.MICROSERVICE_REFERENCE__VERSION, oldVersion, version));
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.MICROSERVICE_REFERENCE__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isImported() {
        return imported;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setImported(boolean newImported) {
        boolean oldImported = imported;
        imported = newImported;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.MICROSERVICE_REFERENCE__IMPORTED, oldImported, imported));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.MICROSERVICE_REFERENCE__IMPORT, oldImport, import_));
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.MICROSERVICE_REFERENCE__IMPORT, oldImport, import_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateMicroservice getLocalMicroservice() {
        if (localMicroservice != null && localMicroservice.eIsProxy()) {
            InternalEObject oldLocalMicroservice = (InternalEObject)localMicroservice;
            localMicroservice = (IntermediateMicroservice)eResolveProxy(oldLocalMicroservice);
            if (localMicroservice != oldLocalMicroservice) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.MICROSERVICE_REFERENCE__LOCAL_MICROSERVICE, oldLocalMicroservice, localMicroservice));
            }
        }
        return localMicroservice;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateMicroservice basicGetLocalMicroservice() {
        return localMicroservice;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLocalMicroservice(IntermediateMicroservice newLocalMicroservice) {
        IntermediateMicroservice oldLocalMicroservice = localMicroservice;
        localMicroservice = newLocalMicroservice;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.MICROSERVICE_REFERENCE__LOCAL_MICROSERVICE, oldLocalMicroservice, localMicroservice));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateMicroservice getRequiringMicroservice() {
        if (eContainerFeatureID() != IntermediatePackage.MICROSERVICE_REFERENCE__REQUIRING_MICROSERVICE) return null;
        return (IntermediateMicroservice)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateMicroservice basicGetRequiringMicroservice() {
        if (eContainerFeatureID() != IntermediatePackage.MICROSERVICE_REFERENCE__REQUIRING_MICROSERVICE) return null;
        return (IntermediateMicroservice)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetRequiringMicroservice(IntermediateMicroservice newRequiringMicroservice, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newRequiringMicroservice, IntermediatePackage.MICROSERVICE_REFERENCE__REQUIRING_MICROSERVICE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRequiringMicroservice(IntermediateMicroservice newRequiringMicroservice) {
        if (newRequiringMicroservice != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.MICROSERVICE_REFERENCE__REQUIRING_MICROSERVICE && newRequiringMicroservice != null)) {
            if (EcoreUtil.isAncestor(this, newRequiringMicroservice))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newRequiringMicroservice != null)
                msgs = ((InternalEObject)newRequiringMicroservice).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_MICROSERVICES, IntermediateMicroservice.class, msgs);
            msgs = basicSetRequiringMicroservice(newRequiringMicroservice, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.MICROSERVICE_REFERENCE__REQUIRING_MICROSERVICE, newRequiringMicroservice, newRequiringMicroservice));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case IntermediatePackage.MICROSERVICE_REFERENCE__REQUIRING_MICROSERVICE:
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
            case IntermediatePackage.MICROSERVICE_REFERENCE__REQUIRING_MICROSERVICE:
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
            case IntermediatePackage.MICROSERVICE_REFERENCE__REQUIRING_MICROSERVICE:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_MICROSERVICES, IntermediateMicroservice.class, msgs);
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
            case IntermediatePackage.MICROSERVICE_REFERENCE__NAME:
                return getName();
            case IntermediatePackage.MICROSERVICE_REFERENCE__VERSION:
                return getVersion();
            case IntermediatePackage.MICROSERVICE_REFERENCE__QUALIFIED_NAME:
                return getQualifiedName();
            case IntermediatePackage.MICROSERVICE_REFERENCE__IMPORTED:
                return isImported();
            case IntermediatePackage.MICROSERVICE_REFERENCE__IMPORT:
                if (resolve) return getImport();
                return basicGetImport();
            case IntermediatePackage.MICROSERVICE_REFERENCE__LOCAL_MICROSERVICE:
                if (resolve) return getLocalMicroservice();
                return basicGetLocalMicroservice();
            case IntermediatePackage.MICROSERVICE_REFERENCE__REQUIRING_MICROSERVICE:
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
            case IntermediatePackage.MICROSERVICE_REFERENCE__NAME:
                setName((String)newValue);
                return;
            case IntermediatePackage.MICROSERVICE_REFERENCE__VERSION:
                setVersion((String)newValue);
                return;
            case IntermediatePackage.MICROSERVICE_REFERENCE__QUALIFIED_NAME:
                setQualifiedName((String)newValue);
                return;
            case IntermediatePackage.MICROSERVICE_REFERENCE__IMPORTED:
                setImported((Boolean)newValue);
                return;
            case IntermediatePackage.MICROSERVICE_REFERENCE__IMPORT:
                setImport((IntermediateImport)newValue);
                return;
            case IntermediatePackage.MICROSERVICE_REFERENCE__LOCAL_MICROSERVICE:
                setLocalMicroservice((IntermediateMicroservice)newValue);
                return;
            case IntermediatePackage.MICROSERVICE_REFERENCE__REQUIRING_MICROSERVICE:
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
            case IntermediatePackage.MICROSERVICE_REFERENCE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case IntermediatePackage.MICROSERVICE_REFERENCE__VERSION:
                setVersion(VERSION_EDEFAULT);
                return;
            case IntermediatePackage.MICROSERVICE_REFERENCE__QUALIFIED_NAME:
                setQualifiedName(QUALIFIED_NAME_EDEFAULT);
                return;
            case IntermediatePackage.MICROSERVICE_REFERENCE__IMPORTED:
                setImported(IMPORTED_EDEFAULT);
                return;
            case IntermediatePackage.MICROSERVICE_REFERENCE__IMPORT:
                setImport((IntermediateImport)null);
                return;
            case IntermediatePackage.MICROSERVICE_REFERENCE__LOCAL_MICROSERVICE:
                setLocalMicroservice((IntermediateMicroservice)null);
                return;
            case IntermediatePackage.MICROSERVICE_REFERENCE__REQUIRING_MICROSERVICE:
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
            case IntermediatePackage.MICROSERVICE_REFERENCE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case IntermediatePackage.MICROSERVICE_REFERENCE__VERSION:
                return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
            case IntermediatePackage.MICROSERVICE_REFERENCE__QUALIFIED_NAME:
                return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
            case IntermediatePackage.MICROSERVICE_REFERENCE__IMPORTED:
                return imported != IMPORTED_EDEFAULT;
            case IntermediatePackage.MICROSERVICE_REFERENCE__IMPORT:
                return import_ != null;
            case IntermediatePackage.MICROSERVICE_REFERENCE__LOCAL_MICROSERVICE:
                return localMicroservice != null;
            case IntermediatePackage.MICROSERVICE_REFERENCE__REQUIRING_MICROSERVICE:
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
        result.append(", version: ");
        result.append(version);
        result.append(", qualifiedName: ");
        result.append(qualifiedName);
        result.append(", imported: ");
        result.append(imported);
        result.append(')');
        return result.toString();
    }

} //MicroserviceReferenceImpl
