/**
 */
package de.fhdo.ddmm.technology.mapping.impl;

import com.google.common.collect.Iterables;

import de.fhdo.ddmm.service.Import;

import de.fhdo.ddmm.technology.mapping.InterfaceMapping;
import de.fhdo.ddmm.technology.mapping.MappingPackage;
import de.fhdo.ddmm.technology.mapping.MicroserviceMapping;
import de.fhdo.ddmm.technology.mapping.OperationMapping;
import de.fhdo.ddmm.technology.mapping.ReferredOperationMapping;
import de.fhdo.ddmm.technology.mapping.TechnologyMapping;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Technology Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologyMappingImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologyMappingImpl#getMappings <em>Mappings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TechnologyMappingImpl extends MinimalEObjectImpl.Container implements TechnologyMapping {
    /**
     * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImports()
     * @generated
     * @ordered
     */
    protected EList<Import> imports;

    /**
     * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMappings()
     * @generated
     * @ordered
     */
    protected EList<MicroserviceMapping> mappings;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TechnologyMappingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.TECHNOLOGY_MAPPING;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Import> getImports() {
        if (imports == null) {
            imports = new EObjectContainmentEList<Import>(Import.class, this, MappingPackage.TECHNOLOGY_MAPPING__IMPORTS);
        }
        return imports;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<MicroserviceMapping> getMappings() {
        if (mappings == null) {
            mappings = new EObjectContainmentWithInverseEList<MicroserviceMapping>(MicroserviceMapping.class, this, MappingPackage.TECHNOLOGY_MAPPING__MAPPINGS, MappingPackage.MICROSERVICE_MAPPING__MAPPING_MODEL);
        }
        return mappings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<InterfaceMapping> getMappedInterfaces() {
        final Function1<MicroserviceMapping, EList<InterfaceMapping>> _function = new Function1<MicroserviceMapping, EList<InterfaceMapping>>() {
            public EList<InterfaceMapping> apply(final MicroserviceMapping it) {
                return it.getInterfaceMappings();
            }
        };
        return ECollections.<InterfaceMapping>asEList(IterableExtensions.<InterfaceMapping>toList(Iterables.<InterfaceMapping>concat(XcoreEListExtensions.<MicroserviceMapping, EList<InterfaceMapping>>map(this.getMappings(), _function))));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<OperationMapping> getMappedOperations() {
        final Function1<MicroserviceMapping, EList<OperationMapping>> _function = new Function1<MicroserviceMapping, EList<OperationMapping>>() {
            public EList<OperationMapping> apply(final MicroserviceMapping it) {
                return it.getOperationMappings();
            }
        };
        return ECollections.<OperationMapping>asEList(IterableExtensions.<OperationMapping>toList(Iterables.<OperationMapping>concat(XcoreEListExtensions.<MicroserviceMapping, EList<OperationMapping>>map(this.getMappings(), _function))));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ReferredOperationMapping> getMappedReferredOperations() {
        final Function1<MicroserviceMapping, EList<ReferredOperationMapping>> _function = new Function1<MicroserviceMapping, EList<ReferredOperationMapping>>() {
            public EList<ReferredOperationMapping> apply(final MicroserviceMapping it) {
                return it.getReferredOperationMappings();
            }
        };
        return ECollections.<ReferredOperationMapping>asEList(IterableExtensions.<ReferredOperationMapping>toList(Iterables.<ReferredOperationMapping>concat(XcoreEListExtensions.<MicroserviceMapping, EList<ReferredOperationMapping>>map(this.getMappings(), _function))));
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
            case MappingPackage.TECHNOLOGY_MAPPING__MAPPINGS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getMappings()).basicAdd(otherEnd, msgs);
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
            case MappingPackage.TECHNOLOGY_MAPPING__IMPORTS:
                return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
            case MappingPackage.TECHNOLOGY_MAPPING__MAPPINGS:
                return ((InternalEList<?>)getMappings()).basicRemove(otherEnd, msgs);
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
            case MappingPackage.TECHNOLOGY_MAPPING__IMPORTS:
                return getImports();
            case MappingPackage.TECHNOLOGY_MAPPING__MAPPINGS:
                return getMappings();
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
            case MappingPackage.TECHNOLOGY_MAPPING__IMPORTS:
                getImports().clear();
                getImports().addAll((Collection<? extends Import>)newValue);
                return;
            case MappingPackage.TECHNOLOGY_MAPPING__MAPPINGS:
                getMappings().clear();
                getMappings().addAll((Collection<? extends MicroserviceMapping>)newValue);
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
            case MappingPackage.TECHNOLOGY_MAPPING__IMPORTS:
                getImports().clear();
                return;
            case MappingPackage.TECHNOLOGY_MAPPING__MAPPINGS:
                getMappings().clear();
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
            case MappingPackage.TECHNOLOGY_MAPPING__IMPORTS:
                return imports != null && !imports.isEmpty();
            case MappingPackage.TECHNOLOGY_MAPPING__MAPPINGS:
                return mappings != null && !mappings.isEmpty();
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
            case MappingPackage.TECHNOLOGY_MAPPING___GET_MAPPED_INTERFACES:
                return getMappedInterfaces();
            case MappingPackage.TECHNOLOGY_MAPPING___GET_MAPPED_OPERATIONS:
                return getMappedOperations();
            case MappingPackage.TECHNOLOGY_MAPPING___GET_MAPPED_REFERRED_OPERATIONS:
                return getMappedReferredOperations();
        }
        return super.eInvoke(operationID, arguments);
    }

} //TechnologyMappingImpl
