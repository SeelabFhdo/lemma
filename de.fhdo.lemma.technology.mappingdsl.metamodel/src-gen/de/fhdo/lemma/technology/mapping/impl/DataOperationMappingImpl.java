/**
 */
package de.fhdo.lemma.technology.mapping.impl;

import de.fhdo.lemma.data.DataOperation;
import de.fhdo.lemma.data.Type;

import de.fhdo.lemma.service.Import;

import de.fhdo.lemma.technology.mapping.ComplexTypeMapping;
import de.fhdo.lemma.technology.mapping.DataOperationMapping;
import de.fhdo.lemma.technology.mapping.DataOperationParameterMapping;
import de.fhdo.lemma.technology.mapping.MappingPackage;
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
 * An implementation of the model object '<em><b>Data Operation Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.DataOperationMappingImpl#getDataOperation <em>Data Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.DataOperationMappingImpl#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.DataOperationMappingImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.DataOperationMappingImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.DataOperationMappingImpl#getParameterMappings <em>Parameter Mappings</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.DataOperationMappingImpl#getTypeMapping <em>Type Mapping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataOperationMappingImpl extends MinimalEObjectImpl.Container implements DataOperationMapping {
    /**
     * The cached value of the '{@link #getDataOperation() <em>Data Operation</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataOperation()
     * @generated
     * @ordered
     */
    protected DataOperation dataOperation;

    /**
     * The cached value of the '{@link #getTechnology() <em>Technology</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTechnology()
     * @generated
     * @ordered
     */
    protected Import technology;

    /**
     * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReturnType()
     * @generated
     * @ordered
     */
    protected Type returnType;

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
     * The cached value of the '{@link #getParameterMappings() <em>Parameter Mappings</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParameterMappings()
     * @generated
     * @ordered
     */
    protected EList<DataOperationParameterMapping> parameterMappings;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DataOperationMappingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.DATA_OPERATION_MAPPING;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DataOperation getDataOperation() {
        if (dataOperation != null && dataOperation.eIsProxy()) {
            InternalEObject oldDataOperation = (InternalEObject)dataOperation;
            dataOperation = (DataOperation)eResolveProxy(oldDataOperation);
            if (dataOperation != oldDataOperation) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.DATA_OPERATION_MAPPING__DATA_OPERATION, oldDataOperation, dataOperation));
            }
        }
        return dataOperation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataOperation basicGetDataOperation() {
        return dataOperation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDataOperation(DataOperation newDataOperation) {
        DataOperation oldDataOperation = dataOperation;
        dataOperation = newDataOperation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.DATA_OPERATION_MAPPING__DATA_OPERATION, oldDataOperation, dataOperation));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Import getTechnology() {
        if (technology != null && technology.eIsProxy()) {
            InternalEObject oldTechnology = (InternalEObject)technology;
            technology = (Import)eResolveProxy(oldTechnology);
            if (technology != oldTechnology) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.DATA_OPERATION_MAPPING__TECHNOLOGY, oldTechnology, technology));
            }
        }
        return technology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Import basicGetTechnology() {
        return technology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTechnology(Import newTechnology) {
        Import oldTechnology = technology;
        technology = newTechnology;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.DATA_OPERATION_MAPPING__TECHNOLOGY, oldTechnology, technology));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Type getReturnType() {
        if (returnType != null && returnType.eIsProxy()) {
            InternalEObject oldReturnType = (InternalEObject)returnType;
            returnType = (Type)eResolveProxy(oldReturnType);
            if (returnType != oldReturnType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.DATA_OPERATION_MAPPING__RETURN_TYPE, oldReturnType, returnType));
            }
        }
        return returnType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Type basicGetReturnType() {
        return returnType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setReturnType(Type newReturnType) {
        Type oldReturnType = returnType;
        returnType = newReturnType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.DATA_OPERATION_MAPPING__RETURN_TYPE, oldReturnType, returnType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<TechnologySpecificImportedServiceAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<TechnologySpecificImportedServiceAspect>(TechnologySpecificImportedServiceAspect.class, this, MappingPackage.DATA_OPERATION_MAPPING__ASPECTS, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_MAPPING);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<DataOperationParameterMapping> getParameterMappings() {
        if (parameterMappings == null) {
            parameterMappings = new EObjectContainmentWithInverseEList<DataOperationParameterMapping>(DataOperationParameterMapping.class, this, MappingPackage.DATA_OPERATION_MAPPING__PARAMETER_MAPPINGS, MappingPackage.DATA_OPERATION_PARAMETER_MAPPING__OPERATION_MAPPING);
        }
        return parameterMappings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ComplexTypeMapping getTypeMapping() {
        if (eContainerFeatureID() != MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING) return null;
        return (ComplexTypeMapping)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComplexTypeMapping basicGetTypeMapping() {
        if (eContainerFeatureID() != MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING) return null;
        return (ComplexTypeMapping)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTypeMapping(ComplexTypeMapping newTypeMapping, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newTypeMapping, MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTypeMapping(ComplexTypeMapping newTypeMapping) {
        if (newTypeMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING && newTypeMapping != null)) {
            if (EcoreUtil.isAncestor(this, newTypeMapping))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newTypeMapping != null)
                msgs = ((InternalEObject)newTypeMapping).eInverseAdd(this, MappingPackage.COMPLEX_TYPE_MAPPING__OPERATION_MAPPINGS, ComplexTypeMapping.class, msgs);
            msgs = basicSetTypeMapping(newTypeMapping, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING, newTypeMapping, newTypeMapping));
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
            case MappingPackage.DATA_OPERATION_MAPPING__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case MappingPackage.DATA_OPERATION_MAPPING__PARAMETER_MAPPINGS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameterMappings()).basicAdd(otherEnd, msgs);
            case MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetTypeMapping((ComplexTypeMapping)otherEnd, msgs);
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
            case MappingPackage.DATA_OPERATION_MAPPING__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case MappingPackage.DATA_OPERATION_MAPPING__PARAMETER_MAPPINGS:
                return ((InternalEList<?>)getParameterMappings()).basicRemove(otherEnd, msgs);
            case MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING:
                return basicSetTypeMapping(null, msgs);
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
            case MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING:
                return eInternalContainer().eInverseRemove(this, MappingPackage.COMPLEX_TYPE_MAPPING__OPERATION_MAPPINGS, ComplexTypeMapping.class, msgs);
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
            case MappingPackage.DATA_OPERATION_MAPPING__DATA_OPERATION:
                if (resolve) return getDataOperation();
                return basicGetDataOperation();
            case MappingPackage.DATA_OPERATION_MAPPING__TECHNOLOGY:
                if (resolve) return getTechnology();
                return basicGetTechnology();
            case MappingPackage.DATA_OPERATION_MAPPING__RETURN_TYPE:
                if (resolve) return getReturnType();
                return basicGetReturnType();
            case MappingPackage.DATA_OPERATION_MAPPING__ASPECTS:
                return getAspects();
            case MappingPackage.DATA_OPERATION_MAPPING__PARAMETER_MAPPINGS:
                return getParameterMappings();
            case MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING:
                if (resolve) return getTypeMapping();
                return basicGetTypeMapping();
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
            case MappingPackage.DATA_OPERATION_MAPPING__DATA_OPERATION:
                setDataOperation((DataOperation)newValue);
                return;
            case MappingPackage.DATA_OPERATION_MAPPING__TECHNOLOGY:
                setTechnology((Import)newValue);
                return;
            case MappingPackage.DATA_OPERATION_MAPPING__RETURN_TYPE:
                setReturnType((Type)newValue);
                return;
            case MappingPackage.DATA_OPERATION_MAPPING__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends TechnologySpecificImportedServiceAspect>)newValue);
                return;
            case MappingPackage.DATA_OPERATION_MAPPING__PARAMETER_MAPPINGS:
                getParameterMappings().clear();
                getParameterMappings().addAll((Collection<? extends DataOperationParameterMapping>)newValue);
                return;
            case MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING:
                setTypeMapping((ComplexTypeMapping)newValue);
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
            case MappingPackage.DATA_OPERATION_MAPPING__DATA_OPERATION:
                setDataOperation((DataOperation)null);
                return;
            case MappingPackage.DATA_OPERATION_MAPPING__TECHNOLOGY:
                setTechnology((Import)null);
                return;
            case MappingPackage.DATA_OPERATION_MAPPING__RETURN_TYPE:
                setReturnType((Type)null);
                return;
            case MappingPackage.DATA_OPERATION_MAPPING__ASPECTS:
                getAspects().clear();
                return;
            case MappingPackage.DATA_OPERATION_MAPPING__PARAMETER_MAPPINGS:
                getParameterMappings().clear();
                return;
            case MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING:
                setTypeMapping((ComplexTypeMapping)null);
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
            case MappingPackage.DATA_OPERATION_MAPPING__DATA_OPERATION:
                return dataOperation != null;
            case MappingPackage.DATA_OPERATION_MAPPING__TECHNOLOGY:
                return technology != null;
            case MappingPackage.DATA_OPERATION_MAPPING__RETURN_TYPE:
                return returnType != null;
            case MappingPackage.DATA_OPERATION_MAPPING__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case MappingPackage.DATA_OPERATION_MAPPING__PARAMETER_MAPPINGS:
                return parameterMappings != null && !parameterMappings.isEmpty();
            case MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING:
                return basicGetTypeMapping() != null;
        }
        return super.eIsSet(featureID);
    }

} //DataOperationMappingImpl
