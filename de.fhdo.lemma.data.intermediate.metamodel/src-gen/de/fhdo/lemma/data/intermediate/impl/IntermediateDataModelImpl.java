/**
 */
package de.fhdo.lemma.data.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateComplexType;
import de.fhdo.lemma.data.intermediate.IntermediateContext;
import de.fhdo.lemma.data.intermediate.IntermediateDataModel;
import de.fhdo.lemma.data.intermediate.IntermediateImport;
import de.fhdo.lemma.data.intermediate.IntermediatePackage;
import de.fhdo.lemma.data.intermediate.IntermediateVersion;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataModelImpl#getSourceModelUri <em>Source Model Uri</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataModelImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataModelImpl#getVersions <em>Versions</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataModelImpl#getContexts <em>Contexts</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataModelImpl#getComplexTypes <em>Complex Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateDataModelImpl extends MinimalEObjectImpl.Container implements IntermediateDataModel {
    /**
     * The default value of the '{@link #getSourceModelUri() <em>Source Model Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceModelUri()
     * @generated
     * @ordered
     */
    protected static final String SOURCE_MODEL_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSourceModelUri() <em>Source Model Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceModelUri()
     * @generated
     * @ordered
     */
    protected String sourceModelUri = SOURCE_MODEL_URI_EDEFAULT;

    /**
     * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImports()
     * @generated
     * @ordered
     */
    protected EList<IntermediateImport> imports;

    /**
     * The cached value of the '{@link #getVersions() <em>Versions</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVersions()
     * @generated
     * @ordered
     */
    protected EList<IntermediateVersion> versions;

    /**
     * The cached value of the '{@link #getContexts() <em>Contexts</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContexts()
     * @generated
     * @ordered
     */
    protected EList<IntermediateContext> contexts;

    /**
     * The cached value of the '{@link #getComplexTypes() <em>Complex Types</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getComplexTypes()
     * @generated
     * @ordered
     */
    protected EList<IntermediateComplexType> complexTypes;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediateDataModelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_DATA_MODEL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSourceModelUri() {
        return sourceModelUri;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSourceModelUri(String newSourceModelUri) {
        String oldSourceModelUri = sourceModelUri;
        sourceModelUri = newSourceModelUri;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_MODEL__SOURCE_MODEL_URI, oldSourceModelUri, sourceModelUri));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateImport> getImports() {
        if (imports == null) {
            imports = new EObjectContainmentWithInverseEList<IntermediateImport>(IntermediateImport.class, this, IntermediatePackage.INTERMEDIATE_DATA_MODEL__IMPORTS, IntermediatePackage.INTERMEDIATE_IMPORT__DATA_MODEL);
        }
        return imports;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateVersion> getVersions() {
        if (versions == null) {
            versions = new EObjectContainmentWithInverseEList<IntermediateVersion>(IntermediateVersion.class, this, IntermediatePackage.INTERMEDIATE_DATA_MODEL__VERSIONS, IntermediatePackage.INTERMEDIATE_VERSION__DATA_MODEL);
        }
        return versions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateContext> getContexts() {
        if (contexts == null) {
            contexts = new EObjectContainmentWithInverseEList<IntermediateContext>(IntermediateContext.class, this, IntermediatePackage.INTERMEDIATE_DATA_MODEL__CONTEXTS, IntermediatePackage.INTERMEDIATE_CONTEXT__DATA_MODEL);
        }
        return contexts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateComplexType> getComplexTypes() {
        if (complexTypes == null) {
            complexTypes = new EObjectContainmentWithInverseEList<IntermediateComplexType>(IntermediateComplexType.class, this, IntermediatePackage.INTERMEDIATE_DATA_MODEL__COMPLEX_TYPES, IntermediatePackage.INTERMEDIATE_COMPLEX_TYPE__DATA_MODEL);
        }
        return complexTypes;
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
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__IMPORTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getImports()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__VERSIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getVersions()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__CONTEXTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getContexts()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__COMPLEX_TYPES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getComplexTypes()).basicAdd(otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__IMPORTS:
                return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__VERSIONS:
                return ((InternalEList<?>)getVersions()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__CONTEXTS:
                return ((InternalEList<?>)getContexts()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__COMPLEX_TYPES:
                return ((InternalEList<?>)getComplexTypes()).basicRemove(otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__SOURCE_MODEL_URI:
                return getSourceModelUri();
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__IMPORTS:
                return getImports();
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__VERSIONS:
                return getVersions();
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__CONTEXTS:
                return getContexts();
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__COMPLEX_TYPES:
                return getComplexTypes();
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
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__SOURCE_MODEL_URI:
                setSourceModelUri((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__IMPORTS:
                getImports().clear();
                getImports().addAll((Collection<? extends IntermediateImport>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__VERSIONS:
                getVersions().clear();
                getVersions().addAll((Collection<? extends IntermediateVersion>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__CONTEXTS:
                getContexts().clear();
                getContexts().addAll((Collection<? extends IntermediateContext>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__COMPLEX_TYPES:
                getComplexTypes().clear();
                getComplexTypes().addAll((Collection<? extends IntermediateComplexType>)newValue);
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
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__SOURCE_MODEL_URI:
                setSourceModelUri(SOURCE_MODEL_URI_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__IMPORTS:
                getImports().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__VERSIONS:
                getVersions().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__CONTEXTS:
                getContexts().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__COMPLEX_TYPES:
                getComplexTypes().clear();
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
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__SOURCE_MODEL_URI:
                return SOURCE_MODEL_URI_EDEFAULT == null ? sourceModelUri != null : !SOURCE_MODEL_URI_EDEFAULT.equals(sourceModelUri);
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__IMPORTS:
                return imports != null && !imports.isEmpty();
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__VERSIONS:
                return versions != null && !versions.isEmpty();
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__CONTEXTS:
                return contexts != null && !contexts.isEmpty();
            case IntermediatePackage.INTERMEDIATE_DATA_MODEL__COMPLEX_TYPES:
                return complexTypes != null && !complexTypes.isEmpty();
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
        result.append(" (sourceModelUri: ");
        result.append(sourceModelUri);
        result.append(')');
        return result.toString();
    }

} //IntermediateDataModelImpl
