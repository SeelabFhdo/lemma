/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNodeReference;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Node Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeReferenceImpl#isImported <em>Imported</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeReferenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeReferenceImpl#getQualifiedTechnologyName <em>Qualified Technology Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeReferenceImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeReferenceImpl#getDependOnNode <em>Depend On Node</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeReferenceImpl#getUsedByNode <em>Used By Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateOperationNodeReferenceImpl extends MinimalEObjectImpl.Container implements IntermediateOperationNodeReference {
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
     * The default value of the '{@link #getQualifiedTechnologyName() <em>Qualified Technology Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQualifiedTechnologyName()
     * @generated
     * @ordered
     */
    protected static final String QUALIFIED_TECHNOLOGY_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getQualifiedTechnologyName() <em>Qualified Technology Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQualifiedTechnologyName()
     * @generated
     * @ordered
     */
    protected String qualifiedTechnologyName = QUALIFIED_TECHNOLOGY_NAME_EDEFAULT;

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediateOperationNodeReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE_REFERENCE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__IMPORTED, oldImported, imported));
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getQualifiedTechnologyName() {
        return qualifiedTechnologyName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setQualifiedTechnologyName(String newQualifiedTechnologyName) {
        String oldQualifiedTechnologyName = qualifiedTechnologyName;
        qualifiedTechnologyName = newQualifiedTechnologyName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__QUALIFIED_TECHNOLOGY_NAME, oldQualifiedTechnologyName, qualifiedTechnologyName));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__IMPORT, oldImport, import_));
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__IMPORT, oldImport, import_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateOperationNode getDependOnNode() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__DEPEND_ON_NODE) return null;
        return (IntermediateOperationNode)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateOperationNode basicGetDependOnNode() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__DEPEND_ON_NODE) return null;
        return (IntermediateOperationNode)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDependOnNode(IntermediateOperationNode newDependOnNode, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDependOnNode, IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__DEPEND_ON_NODE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDependOnNode(IntermediateOperationNode newDependOnNode) {
        if (newDependOnNode != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__DEPEND_ON_NODE && newDependOnNode != null)) {
            if (EcoreUtil.isAncestor(this, newDependOnNode))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDependOnNode != null)
                msgs = ((InternalEObject)newDependOnNode).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPENDS_ON_NODES, IntermediateOperationNode.class, msgs);
            msgs = basicSetDependOnNode(newDependOnNode, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__DEPEND_ON_NODE, newDependOnNode, newDependOnNode));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateOperationNode getUsedByNode() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__USED_BY_NODE) return null;
        return (IntermediateOperationNode)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateOperationNode basicGetUsedByNode() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__USED_BY_NODE) return null;
        return (IntermediateOperationNode)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetUsedByNode(IntermediateOperationNode newUsedByNode, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newUsedByNode, IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__USED_BY_NODE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUsedByNode(IntermediateOperationNode newUsedByNode) {
        if (newUsedByNode != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__USED_BY_NODE && newUsedByNode != null)) {
            if (EcoreUtil.isAncestor(this, newUsedByNode))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newUsedByNode != null)
                msgs = ((InternalEObject)newUsedByNode).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__USED_BY_NODES, IntermediateOperationNode.class, msgs);
            msgs = basicSetUsedByNode(newUsedByNode, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__USED_BY_NODE, newUsedByNode, newUsedByNode));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__DEPEND_ON_NODE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDependOnNode((IntermediateOperationNode)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__USED_BY_NODE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetUsedByNode((IntermediateOperationNode)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__DEPEND_ON_NODE:
                return basicSetDependOnNode(null, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__USED_BY_NODE:
                return basicSetUsedByNode(null, msgs);
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__DEPEND_ON_NODE:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPENDS_ON_NODES, IntermediateOperationNode.class, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__USED_BY_NODE:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__USED_BY_NODES, IntermediateOperationNode.class, msgs);
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__IMPORTED:
                return isImported();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__NAME:
                return getName();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__QUALIFIED_TECHNOLOGY_NAME:
                return getQualifiedTechnologyName();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__IMPORT:
                if (resolve) return getImport();
                return basicGetImport();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__DEPEND_ON_NODE:
                if (resolve) return getDependOnNode();
                return basicGetDependOnNode();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__USED_BY_NODE:
                if (resolve) return getUsedByNode();
                return basicGetUsedByNode();
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__IMPORTED:
                setImported((Boolean)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__NAME:
                setName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__QUALIFIED_TECHNOLOGY_NAME:
                setQualifiedTechnologyName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__IMPORT:
                setImport((IntermediateImport)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__DEPEND_ON_NODE:
                setDependOnNode((IntermediateOperationNode)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__USED_BY_NODE:
                setUsedByNode((IntermediateOperationNode)newValue);
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__IMPORTED:
                setImported(IMPORTED_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__QUALIFIED_TECHNOLOGY_NAME:
                setQualifiedTechnologyName(QUALIFIED_TECHNOLOGY_NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__IMPORT:
                setImport((IntermediateImport)null);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__DEPEND_ON_NODE:
                setDependOnNode((IntermediateOperationNode)null);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__USED_BY_NODE:
                setUsedByNode((IntermediateOperationNode)null);
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__IMPORTED:
                return imported != IMPORTED_EDEFAULT;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__QUALIFIED_TECHNOLOGY_NAME:
                return QUALIFIED_TECHNOLOGY_NAME_EDEFAULT == null ? qualifiedTechnologyName != null : !QUALIFIED_TECHNOLOGY_NAME_EDEFAULT.equals(qualifiedTechnologyName);
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__IMPORT:
                return import_ != null;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__DEPEND_ON_NODE:
                return basicGetDependOnNode() != null;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE_REFERENCE__USED_BY_NODE:
                return basicGetUsedByNode() != null;
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
        result.append(" (imported: ");
        result.append(imported);
        result.append(", name: ");
        result.append(name);
        result.append(", qualifiedTechnologyName: ");
        result.append(qualifiedTechnologyName);
        result.append(')');
        return result.toString();
    }

} //IntermediateOperationNodeReferenceImpl
