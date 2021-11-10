/**
 */
package de.fhdo.lemma.technology.mapping.impl;

import de.fhdo.lemma.service.Parameter;

import de.fhdo.lemma.technology.mapping.MappingPackage;
import de.fhdo.lemma.technology.mapping.OperationMapping;
import de.fhdo.lemma.technology.mapping.ParameterMapping;
import de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.ParameterMappingImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.ParameterMappingImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.ParameterMappingImpl#getOperationMapping <em>Operation Mapping</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ParameterMappingImpl extends MinimalEObjectImpl.Container implements ParameterMapping {
    /**
     * The cached value of the '{@link #getParameter() <em>Parameter</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParameter()
     * @generated
     * @ordered
     */
    protected Parameter parameter;

    /**
     * The cached value of the '{@link #getAspects() <em>Aspects</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAspects()
     * @generated
     * @ordered
     */
    protected EList<TechnologySpecificImportedServiceAspect> aspects;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ParameterMappingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.PARAMETER_MAPPING;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Parameter getParameter() {
        if (parameter != null && parameter.eIsProxy()) {
            InternalEObject oldParameter = (InternalEObject)parameter;
            parameter = (Parameter)eResolveProxy(oldParameter);
            if (parameter != oldParameter) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.PARAMETER_MAPPING__PARAMETER, oldParameter, parameter));
            }
        }
        return parameter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Parameter basicGetParameter() {
        return parameter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParameter(Parameter newParameter) {
        Parameter oldParameter = parameter;
        parameter = newParameter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.PARAMETER_MAPPING__PARAMETER, oldParameter, parameter));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TechnologySpecificImportedServiceAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<TechnologySpecificImportedServiceAspect>(TechnologySpecificImportedServiceAspect.class, this, MappingPackage.PARAMETER_MAPPING__ASPECTS, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__PARAMETER_MAPPING);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationMapping getOperationMapping() {
        if (eContainerFeatureID() != MappingPackage.PARAMETER_MAPPING__OPERATION_MAPPING) return null;
        return (OperationMapping)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationMapping basicGetOperationMapping() {
        if (eContainerFeatureID() != MappingPackage.PARAMETER_MAPPING__OPERATION_MAPPING) return null;
        return (OperationMapping)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOperationMapping(OperationMapping newOperationMapping, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOperationMapping, MappingPackage.PARAMETER_MAPPING__OPERATION_MAPPING, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperationMapping(OperationMapping newOperationMapping) {
        if (newOperationMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.PARAMETER_MAPPING__OPERATION_MAPPING && newOperationMapping != null)) {
            if (EcoreUtil.isAncestor(this, newOperationMapping))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOperationMapping != null)
                msgs = ((InternalEObject)newOperationMapping).eInverseAdd(this, MappingPackage.OPERATION_MAPPING__PARAMETER_MAPPINGS, OperationMapping.class, msgs);
            msgs = basicSetOperationMapping(newOperationMapping, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.PARAMETER_MAPPING__OPERATION_MAPPING, newOperationMapping, newOperationMapping));
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
            case MappingPackage.PARAMETER_MAPPING__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case MappingPackage.PARAMETER_MAPPING__OPERATION_MAPPING:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOperationMapping((OperationMapping)otherEnd, msgs);
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
            case MappingPackage.PARAMETER_MAPPING__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case MappingPackage.PARAMETER_MAPPING__OPERATION_MAPPING:
                return basicSetOperationMapping(null, msgs);
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
            case MappingPackage.PARAMETER_MAPPING__OPERATION_MAPPING:
                return eInternalContainer().eInverseRemove(this, MappingPackage.OPERATION_MAPPING__PARAMETER_MAPPINGS, OperationMapping.class, msgs);
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
            case MappingPackage.PARAMETER_MAPPING__PARAMETER:
                if (resolve) return getParameter();
                return basicGetParameter();
            case MappingPackage.PARAMETER_MAPPING__ASPECTS:
                return getAspects();
            case MappingPackage.PARAMETER_MAPPING__OPERATION_MAPPING:
                if (resolve) return getOperationMapping();
                return basicGetOperationMapping();
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
            case MappingPackage.PARAMETER_MAPPING__PARAMETER:
                setParameter((Parameter)newValue);
                return;
            case MappingPackage.PARAMETER_MAPPING__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends TechnologySpecificImportedServiceAspect>)newValue);
                return;
            case MappingPackage.PARAMETER_MAPPING__OPERATION_MAPPING:
                setOperationMapping((OperationMapping)newValue);
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
            case MappingPackage.PARAMETER_MAPPING__PARAMETER:
                setParameter((Parameter)null);
                return;
            case MappingPackage.PARAMETER_MAPPING__ASPECTS:
                getAspects().clear();
                return;
            case MappingPackage.PARAMETER_MAPPING__OPERATION_MAPPING:
                setOperationMapping((OperationMapping)null);
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
            case MappingPackage.PARAMETER_MAPPING__PARAMETER:
                return parameter != null;
            case MappingPackage.PARAMETER_MAPPING__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case MappingPackage.PARAMETER_MAPPING__OPERATION_MAPPING:
                return basicGetOperationMapping() != null;
        }
        return super.eIsSet(featureID);
    }

} //ParameterMappingImpl
