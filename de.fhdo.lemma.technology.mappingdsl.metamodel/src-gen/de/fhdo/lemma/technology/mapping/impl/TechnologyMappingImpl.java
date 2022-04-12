/**
 */
package de.fhdo.lemma.technology.mapping.impl;

import com.google.common.collect.Iterables;

import de.fhdo.lemma.service.Import;

import de.fhdo.lemma.technology.mapping.ComplexParameterMapping;
import de.fhdo.lemma.technology.mapping.ComplexTypeMapping;
import de.fhdo.lemma.technology.mapping.InterfaceMapping;
import de.fhdo.lemma.technology.mapping.MappingPackage;
import de.fhdo.lemma.technology.mapping.MicroserviceMapping;
import de.fhdo.lemma.technology.mapping.OperationMapping;
import de.fhdo.lemma.technology.mapping.ParameterMapping;
import de.fhdo.lemma.technology.mapping.ReferredOperationMapping;
import de.fhdo.lemma.technology.mapping.TechnologyMapping;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.Collection;

import java.util.function.Consumer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

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
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.TechnologyMappingImpl#getT_modelUri <em>Tmodel Uri</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.TechnologyMappingImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.TechnologyMappingImpl#getTypeMappings <em>Type Mappings</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.TechnologyMappingImpl#getServiceMappings <em>Service Mappings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TechnologyMappingImpl extends MinimalEObjectImpl.Container implements TechnologyMapping {
    /**
     * The default value of the '{@link #getT_modelUri() <em>Tmodel Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getT_modelUri()
     * @generated
     * @ordered
     */
    protected static final String TMODEL_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getT_modelUri() <em>Tmodel Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getT_modelUri()
     * @generated
     * @ordered
     */
    protected String t_modelUri = TMODEL_URI_EDEFAULT;

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
     * The cached value of the '{@link #getTypeMappings() <em>Type Mappings</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTypeMappings()
     * @generated
     * @ordered
     */
    protected EList<ComplexTypeMapping> typeMappings;

    /**
     * The cached value of the '{@link #getServiceMappings() <em>Service Mappings</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServiceMappings()
     * @generated
     * @ordered
     */
    protected EList<MicroserviceMapping> serviceMappings;

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
    public String getT_modelUri() {
        return t_modelUri;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setT_modelUri(String newT_modelUri) {
        String oldT_modelUri = t_modelUri;
        t_modelUri = newT_modelUri;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_MAPPING__TMODEL_URI, oldT_modelUri, t_modelUri));
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
    public EList<ComplexTypeMapping> getTypeMappings() {
        if (typeMappings == null) {
            typeMappings = new EObjectContainmentWithInverseEList<ComplexTypeMapping>(ComplexTypeMapping.class, this, MappingPackage.TECHNOLOGY_MAPPING__TYPE_MAPPINGS, MappingPackage.COMPLEX_TYPE_MAPPING__MAPPING_MODEL);
        }
        return typeMappings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<MicroserviceMapping> getServiceMappings() {
        if (serviceMappings == null) {
            serviceMappings = new EObjectContainmentWithInverseEList<MicroserviceMapping>(MicroserviceMapping.class, this, MappingPackage.TECHNOLOGY_MAPPING__SERVICE_MAPPINGS, MappingPackage.MICROSERVICE_MAPPING__MAPPING_MODEL);
        }
        return serviceMappings;
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
        return ECollections.<InterfaceMapping>asEList(IterableExtensions.<InterfaceMapping>toList(Iterables.<InterfaceMapping>concat(XcoreEListExtensions.<MicroserviceMapping, EList<InterfaceMapping>>map(this.getServiceMappings(), _function))));
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
        return ECollections.<OperationMapping>asEList(IterableExtensions.<OperationMapping>toList(Iterables.<OperationMapping>concat(XcoreEListExtensions.<MicroserviceMapping, EList<OperationMapping>>map(this.getServiceMappings(), _function))));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ComplexParameterMapping> getComplexParameterMappings() {
        final ArrayList<ComplexParameterMapping> mappings = CollectionLiterals.<ComplexParameterMapping>newArrayList();
        final Function1<OperationMapping, EList<ParameterMapping>> _function = new Function1<OperationMapping, EList<ParameterMapping>>() {
            public EList<ParameterMapping> apply(final OperationMapping it) {
                return it.getParameterMappings();
            }
        };
        final Consumer<ParameterMapping> _function_1 = new Consumer<ParameterMapping>() {
            public void accept(final ParameterMapping it) {
                if ((it instanceof ComplexParameterMapping)) {
                    mappings.add(((ComplexParameterMapping)it));
                }
            }
        };
        Iterables.<ParameterMapping>concat(XcoreEListExtensions.<OperationMapping, EList<ParameterMapping>>map(this.getMappedOperations(), _function)).forEach(_function_1);
        return ECollections.<ComplexParameterMapping>asEList(mappings);
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
        return ECollections.<ReferredOperationMapping>asEList(IterableExtensions.<ReferredOperationMapping>toList(Iterables.<ReferredOperationMapping>concat(XcoreEListExtensions.<MicroserviceMapping, EList<ReferredOperationMapping>>map(this.getServiceMappings(), _function))));
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
            case MappingPackage.TECHNOLOGY_MAPPING__TYPE_MAPPINGS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getTypeMappings()).basicAdd(otherEnd, msgs);
            case MappingPackage.TECHNOLOGY_MAPPING__SERVICE_MAPPINGS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getServiceMappings()).basicAdd(otherEnd, msgs);
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
            case MappingPackage.TECHNOLOGY_MAPPING__TYPE_MAPPINGS:
                return ((InternalEList<?>)getTypeMappings()).basicRemove(otherEnd, msgs);
            case MappingPackage.TECHNOLOGY_MAPPING__SERVICE_MAPPINGS:
                return ((InternalEList<?>)getServiceMappings()).basicRemove(otherEnd, msgs);
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
            case MappingPackage.TECHNOLOGY_MAPPING__TMODEL_URI:
                return getT_modelUri();
            case MappingPackage.TECHNOLOGY_MAPPING__IMPORTS:
                return getImports();
            case MappingPackage.TECHNOLOGY_MAPPING__TYPE_MAPPINGS:
                return getTypeMappings();
            case MappingPackage.TECHNOLOGY_MAPPING__SERVICE_MAPPINGS:
                return getServiceMappings();
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
            case MappingPackage.TECHNOLOGY_MAPPING__TMODEL_URI:
                setT_modelUri((String)newValue);
                return;
            case MappingPackage.TECHNOLOGY_MAPPING__IMPORTS:
                getImports().clear();
                getImports().addAll((Collection<? extends Import>)newValue);
                return;
            case MappingPackage.TECHNOLOGY_MAPPING__TYPE_MAPPINGS:
                getTypeMappings().clear();
                getTypeMappings().addAll((Collection<? extends ComplexTypeMapping>)newValue);
                return;
            case MappingPackage.TECHNOLOGY_MAPPING__SERVICE_MAPPINGS:
                getServiceMappings().clear();
                getServiceMappings().addAll((Collection<? extends MicroserviceMapping>)newValue);
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
            case MappingPackage.TECHNOLOGY_MAPPING__TMODEL_URI:
                setT_modelUri(TMODEL_URI_EDEFAULT);
                return;
            case MappingPackage.TECHNOLOGY_MAPPING__IMPORTS:
                getImports().clear();
                return;
            case MappingPackage.TECHNOLOGY_MAPPING__TYPE_MAPPINGS:
                getTypeMappings().clear();
                return;
            case MappingPackage.TECHNOLOGY_MAPPING__SERVICE_MAPPINGS:
                getServiceMappings().clear();
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
            case MappingPackage.TECHNOLOGY_MAPPING__TMODEL_URI:
                return TMODEL_URI_EDEFAULT == null ? t_modelUri != null : !TMODEL_URI_EDEFAULT.equals(t_modelUri);
            case MappingPackage.TECHNOLOGY_MAPPING__IMPORTS:
                return imports != null && !imports.isEmpty();
            case MappingPackage.TECHNOLOGY_MAPPING__TYPE_MAPPINGS:
                return typeMappings != null && !typeMappings.isEmpty();
            case MappingPackage.TECHNOLOGY_MAPPING__SERVICE_MAPPINGS:
                return serviceMappings != null && !serviceMappings.isEmpty();
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
            case MappingPackage.TECHNOLOGY_MAPPING___GET_COMPLEX_PARAMETER_MAPPINGS:
                return getComplexParameterMappings();
            case MappingPackage.TECHNOLOGY_MAPPING___GET_MAPPED_REFERRED_OPERATIONS:
                return getMappedReferredOperations();
        }
        return super.eInvoke(operationID, arguments);
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
        result.append(" (t_modelUri: ");
        result.append(t_modelUri);
        result.append(')');
        return result.toString();
    }

} //TechnologyMappingImpl
