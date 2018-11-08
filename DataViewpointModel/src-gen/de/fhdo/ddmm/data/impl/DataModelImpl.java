/**
 */
package de.fhdo.ddmm.data.impl;

import de.fhdo.ddmm.data.ComplexType;
import de.fhdo.ddmm.data.ComplexTypeImport;
import de.fhdo.ddmm.data.Context;
import de.fhdo.ddmm.data.DataModel;
import de.fhdo.ddmm.data.DataPackage;
import de.fhdo.ddmm.data.Version;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.Collection;

import java.util.function.Consumer;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.data.impl.DataModelImpl#getComplexTypeImports <em>Complex Type Imports</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.DataModelImpl#getVersions <em>Versions</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.DataModelImpl#getContexts <em>Contexts</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.DataModelImpl#getComplexTypes <em>Complex Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataModelImpl extends MinimalEObjectImpl.Container implements DataModel {
    /**
     * The cached value of the '{@link #getComplexTypeImports() <em>Complex Type Imports</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getComplexTypeImports()
     * @generated
     * @ordered
     */
    protected EList<ComplexTypeImport> complexTypeImports;

    /**
     * The cached value of the '{@link #getVersions() <em>Versions</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVersions()
     * @generated
     * @ordered
     */
    protected EList<Version> versions;

    /**
     * The cached value of the '{@link #getContexts() <em>Contexts</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContexts()
     * @generated
     * @ordered
     */
    protected EList<Context> contexts;

    /**
     * The cached value of the '{@link #getComplexTypes() <em>Complex Types</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getComplexTypes()
     * @generated
     * @ordered
     */
    protected EList<ComplexType> complexTypes;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DataModelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DataPackage.Literals.DATA_MODEL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ComplexTypeImport> getComplexTypeImports() {
        if (complexTypeImports == null) {
            complexTypeImports = new EObjectContainmentWithInverseEList<ComplexTypeImport>(ComplexTypeImport.class, this, DataPackage.DATA_MODEL__COMPLEX_TYPE_IMPORTS, DataPackage.COMPLEX_TYPE_IMPORT__DATA_MODEL);
        }
        return complexTypeImports;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Version> getVersions() {
        if (versions == null) {
            versions = new EObjectContainmentWithInverseEList<Version>(Version.class, this, DataPackage.DATA_MODEL__VERSIONS, DataPackage.VERSION__DATA_MODEL);
        }
        return versions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Context> getContexts() {
        if (contexts == null) {
            contexts = new EObjectContainmentWithInverseEList<Context>(Context.class, this, DataPackage.DATA_MODEL__CONTEXTS, DataPackage.CONTEXT__DATA_MODEL);
        }
        return contexts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ComplexType> getComplexTypes() {
        if (complexTypes == null) {
            complexTypes = new EObjectContainmentWithInverseEList<ComplexType>(ComplexType.class, this, DataPackage.DATA_MODEL__COMPLEX_TYPES, DataPackage.COMPLEX_TYPE__DATA_MODEL);
        }
        return complexTypes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ComplexType> getContainedComplexTypes() {
        final ArrayList<ComplexType> containedComplexTypes = CollectionLiterals.<ComplexType>newArrayList();
        EList<Version> _versions = this.getVersions();
        boolean _tripleNotEquals = (_versions != null);
        if (_tripleNotEquals) {
            final Consumer<Version> _function = new Consumer<Version>() {
                public void accept(final Version it) {
                    containedComplexTypes.addAll(it.getContainedComplexTypes());
                }
            };
            this.getVersions().forEach(_function);
        }
        EList<Context> _contexts = this.getContexts();
        boolean _tripleNotEquals_1 = (_contexts != null);
        if (_tripleNotEquals_1) {
            final Consumer<Context> _function_1 = new Consumer<Context>() {
                public void accept(final Context it) {
                    containedComplexTypes.addAll(it.getComplexTypes());
                }
            };
            this.getContexts().forEach(_function_1);
        }
        containedComplexTypes.addAll(this.getComplexTypes());
        return ECollections.<ComplexType>asEList(containedComplexTypes);
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
            case DataPackage.DATA_MODEL__COMPLEX_TYPE_IMPORTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getComplexTypeImports()).basicAdd(otherEnd, msgs);
            case DataPackage.DATA_MODEL__VERSIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getVersions()).basicAdd(otherEnd, msgs);
            case DataPackage.DATA_MODEL__CONTEXTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getContexts()).basicAdd(otherEnd, msgs);
            case DataPackage.DATA_MODEL__COMPLEX_TYPES:
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
            case DataPackage.DATA_MODEL__COMPLEX_TYPE_IMPORTS:
                return ((InternalEList<?>)getComplexTypeImports()).basicRemove(otherEnd, msgs);
            case DataPackage.DATA_MODEL__VERSIONS:
                return ((InternalEList<?>)getVersions()).basicRemove(otherEnd, msgs);
            case DataPackage.DATA_MODEL__CONTEXTS:
                return ((InternalEList<?>)getContexts()).basicRemove(otherEnd, msgs);
            case DataPackage.DATA_MODEL__COMPLEX_TYPES:
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
            case DataPackage.DATA_MODEL__COMPLEX_TYPE_IMPORTS:
                return getComplexTypeImports();
            case DataPackage.DATA_MODEL__VERSIONS:
                return getVersions();
            case DataPackage.DATA_MODEL__CONTEXTS:
                return getContexts();
            case DataPackage.DATA_MODEL__COMPLEX_TYPES:
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
            case DataPackage.DATA_MODEL__COMPLEX_TYPE_IMPORTS:
                getComplexTypeImports().clear();
                getComplexTypeImports().addAll((Collection<? extends ComplexTypeImport>)newValue);
                return;
            case DataPackage.DATA_MODEL__VERSIONS:
                getVersions().clear();
                getVersions().addAll((Collection<? extends Version>)newValue);
                return;
            case DataPackage.DATA_MODEL__CONTEXTS:
                getContexts().clear();
                getContexts().addAll((Collection<? extends Context>)newValue);
                return;
            case DataPackage.DATA_MODEL__COMPLEX_TYPES:
                getComplexTypes().clear();
                getComplexTypes().addAll((Collection<? extends ComplexType>)newValue);
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
            case DataPackage.DATA_MODEL__COMPLEX_TYPE_IMPORTS:
                getComplexTypeImports().clear();
                return;
            case DataPackage.DATA_MODEL__VERSIONS:
                getVersions().clear();
                return;
            case DataPackage.DATA_MODEL__CONTEXTS:
                getContexts().clear();
                return;
            case DataPackage.DATA_MODEL__COMPLEX_TYPES:
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
            case DataPackage.DATA_MODEL__COMPLEX_TYPE_IMPORTS:
                return complexTypeImports != null && !complexTypeImports.isEmpty();
            case DataPackage.DATA_MODEL__VERSIONS:
                return versions != null && !versions.isEmpty();
            case DataPackage.DATA_MODEL__CONTEXTS:
                return contexts != null && !contexts.isEmpty();
            case DataPackage.DATA_MODEL__COMPLEX_TYPES:
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
    public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
        switch (operationID) {
            case DataPackage.DATA_MODEL___GET_CONTAINED_COMPLEX_TYPES:
                return getContainedComplexTypes();
        }
        return super.eInvoke(operationID, arguments);
    }

} //DataModelImpl
