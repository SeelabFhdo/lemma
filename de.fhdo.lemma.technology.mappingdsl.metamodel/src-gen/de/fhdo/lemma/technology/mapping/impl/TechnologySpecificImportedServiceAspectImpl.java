/**
 */
package de.fhdo.lemma.technology.mapping.impl;

import de.fhdo.lemma.data.PrimitiveValue;

import de.fhdo.lemma.service.Import;

import de.fhdo.lemma.technology.ServiceAspect;
import de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment;

import de.fhdo.lemma.technology.mapping.ComplexTypeMapping;
import de.fhdo.lemma.technology.mapping.DataOperationMapping;
import de.fhdo.lemma.technology.mapping.DataOperationParameterMapping;
import de.fhdo.lemma.technology.mapping.DataOperationReturnTypeMapping;
import de.fhdo.lemma.technology.mapping.InterfaceMapping;
import de.fhdo.lemma.technology.mapping.MappingPackage;
import de.fhdo.lemma.technology.mapping.MicroserviceMapping;
import de.fhdo.lemma.technology.mapping.OperationMapping;
import de.fhdo.lemma.technology.mapping.ParameterMapping;
import de.fhdo.lemma.technology.mapping.ReferredOperationMapping;
import de.fhdo.lemma.technology.mapping.TechnologySpecificFieldMapping;
import de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Technology Specific Imported Service Aspect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.TechnologySpecificImportedServiceAspectImpl#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.TechnologySpecificImportedServiceAspectImpl#getAspect <em>Aspect</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.TechnologySpecificImportedServiceAspectImpl#getSinglePropertyValue <em>Single Property Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.TechnologySpecificImportedServiceAspectImpl#getValues <em>Values</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.TechnologySpecificImportedServiceAspectImpl#getTypeMapping <em>Type Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.TechnologySpecificImportedServiceAspectImpl#getMicroserviceMapping <em>Microservice Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.TechnologySpecificImportedServiceAspectImpl#getInterfaceMapping <em>Interface Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.TechnologySpecificImportedServiceAspectImpl#getOperationMapping <em>Operation Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.TechnologySpecificImportedServiceAspectImpl#getReferredOperationMapping <em>Referred Operation Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.TechnologySpecificImportedServiceAspectImpl#getParameterMapping <em>Parameter Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.TechnologySpecificImportedServiceAspectImpl#getFieldMapping <em>Field Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.TechnologySpecificImportedServiceAspectImpl#getDataOperationMapping <em>Data Operation Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.TechnologySpecificImportedServiceAspectImpl#getDataOperationReturnTypeMapping <em>Data Operation Return Type Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.TechnologySpecificImportedServiceAspectImpl#getDataOperationParameterMapping <em>Data Operation Parameter Mapping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TechnologySpecificImportedServiceAspectImpl extends MinimalEObjectImpl.Container implements TechnologySpecificImportedServiceAspect {
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
	 * The cached value of the '{@link #getAspect() <em>Aspect</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAspect()
	 * @generated
	 * @ordered
	 */
	protected ServiceAspect aspect;

	/**
	 * The cached value of the '{@link #getSinglePropertyValue() <em>Single Property Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSinglePropertyValue()
	 * @generated
	 * @ordered
	 */
	protected PrimitiveValue singlePropertyValue;

	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<TechnologySpecificPropertyValueAssignment> values;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TechnologySpecificImportedServiceAspectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TECHNOLOGY, oldTechnology, technology));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TECHNOLOGY, oldTechnology, technology));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ServiceAspect getAspect() {
		if (aspect != null && aspect.eIsProxy()) {
			InternalEObject oldAspect = (InternalEObject)aspect;
			aspect = (ServiceAspect)eResolveProxy(oldAspect);
			if (aspect != oldAspect) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__ASPECT, oldAspect, aspect));
			}
		}
		return aspect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceAspect basicGetAspect() {
		return aspect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAspect(ServiceAspect newAspect) {
		ServiceAspect oldAspect = aspect;
		aspect = newAspect;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__ASPECT, oldAspect, aspect));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimitiveValue getSinglePropertyValue() {
		return singlePropertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSinglePropertyValue(PrimitiveValue newSinglePropertyValue, NotificationChain msgs) {
		PrimitiveValue oldSinglePropertyValue = singlePropertyValue;
		singlePropertyValue = newSinglePropertyValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE, oldSinglePropertyValue, newSinglePropertyValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSinglePropertyValue(PrimitiveValue newSinglePropertyValue) {
		if (newSinglePropertyValue != singlePropertyValue) {
			NotificationChain msgs = null;
			if (singlePropertyValue != null)
				msgs = ((InternalEObject)singlePropertyValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE, null, msgs);
			if (newSinglePropertyValue != null)
				msgs = ((InternalEObject)newSinglePropertyValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE, null, msgs);
			msgs = basicSetSinglePropertyValue(newSinglePropertyValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE, newSinglePropertyValue, newSinglePropertyValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TechnologySpecificPropertyValueAssignment> getValues() {
		if (values == null) {
			values = new EObjectContainmentEList<TechnologySpecificPropertyValueAssignment>(TechnologySpecificPropertyValueAssignment.class, this, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComplexTypeMapping getTypeMapping() {
		if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TYPE_MAPPING) return null;
		return (ComplexTypeMapping)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexTypeMapping basicGetTypeMapping() {
		if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TYPE_MAPPING) return null;
		return (ComplexTypeMapping)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeMapping(ComplexTypeMapping newTypeMapping, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTypeMapping, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TYPE_MAPPING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTypeMapping(ComplexTypeMapping newTypeMapping) {
		if (newTypeMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TYPE_MAPPING && newTypeMapping != null)) {
			if (EcoreUtil.isAncestor(this, newTypeMapping))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTypeMapping != null)
				msgs = ((InternalEObject)newTypeMapping).eInverseAdd(this, MappingPackage.COMPLEX_TYPE_MAPPING__ASPECTS, ComplexTypeMapping.class, msgs);
			msgs = basicSetTypeMapping(newTypeMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TYPE_MAPPING, newTypeMapping, newTypeMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MicroserviceMapping getMicroserviceMapping() {
		if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__MICROSERVICE_MAPPING) return null;
		return (MicroserviceMapping)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MicroserviceMapping basicGetMicroserviceMapping() {
		if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__MICROSERVICE_MAPPING) return null;
		return (MicroserviceMapping)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMicroserviceMapping(MicroserviceMapping newMicroserviceMapping, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMicroserviceMapping, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__MICROSERVICE_MAPPING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMicroserviceMapping(MicroserviceMapping newMicroserviceMapping) {
		if (newMicroserviceMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__MICROSERVICE_MAPPING && newMicroserviceMapping != null)) {
			if (EcoreUtil.isAncestor(this, newMicroserviceMapping))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMicroserviceMapping != null)
				msgs = ((InternalEObject)newMicroserviceMapping).eInverseAdd(this, MappingPackage.MICROSERVICE_MAPPING__ASPECTS, MicroserviceMapping.class, msgs);
			msgs = basicSetMicroserviceMapping(newMicroserviceMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__MICROSERVICE_MAPPING, newMicroserviceMapping, newMicroserviceMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InterfaceMapping getInterfaceMapping() {
		if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__INTERFACE_MAPPING) return null;
		return (InterfaceMapping)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceMapping basicGetInterfaceMapping() {
		if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__INTERFACE_MAPPING) return null;
		return (InterfaceMapping)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterfaceMapping(InterfaceMapping newInterfaceMapping, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInterfaceMapping, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__INTERFACE_MAPPING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInterfaceMapping(InterfaceMapping newInterfaceMapping) {
		if (newInterfaceMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__INTERFACE_MAPPING && newInterfaceMapping != null)) {
			if (EcoreUtil.isAncestor(this, newInterfaceMapping))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInterfaceMapping != null)
				msgs = ((InternalEObject)newInterfaceMapping).eInverseAdd(this, MappingPackage.INTERFACE_MAPPING__ASPECTS, InterfaceMapping.class, msgs);
			msgs = basicSetInterfaceMapping(newInterfaceMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__INTERFACE_MAPPING, newInterfaceMapping, newInterfaceMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationMapping getOperationMapping() {
		if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__OPERATION_MAPPING) return null;
		return (OperationMapping)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationMapping basicGetOperationMapping() {
		if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__OPERATION_MAPPING) return null;
		return (OperationMapping)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperationMapping(OperationMapping newOperationMapping, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOperationMapping, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__OPERATION_MAPPING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperationMapping(OperationMapping newOperationMapping) {
		if (newOperationMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__OPERATION_MAPPING && newOperationMapping != null)) {
			if (EcoreUtil.isAncestor(this, newOperationMapping))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOperationMapping != null)
				msgs = ((InternalEObject)newOperationMapping).eInverseAdd(this, MappingPackage.OPERATION_MAPPING__ASPECTS, OperationMapping.class, msgs);
			msgs = basicSetOperationMapping(newOperationMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__OPERATION_MAPPING, newOperationMapping, newOperationMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReferredOperationMapping getReferredOperationMapping() {
		if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION_MAPPING) return null;
		return (ReferredOperationMapping)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferredOperationMapping basicGetReferredOperationMapping() {
		if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION_MAPPING) return null;
		return (ReferredOperationMapping)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferredOperationMapping(ReferredOperationMapping newReferredOperationMapping, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newReferredOperationMapping, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION_MAPPING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredOperationMapping(ReferredOperationMapping newReferredOperationMapping) {
		if (newReferredOperationMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION_MAPPING && newReferredOperationMapping != null)) {
			if (EcoreUtil.isAncestor(this, newReferredOperationMapping))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newReferredOperationMapping != null)
				msgs = ((InternalEObject)newReferredOperationMapping).eInverseAdd(this, MappingPackage.REFERRED_OPERATION_MAPPING__ASPECTS, ReferredOperationMapping.class, msgs);
			msgs = basicSetReferredOperationMapping(newReferredOperationMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION_MAPPING, newReferredOperationMapping, newReferredOperationMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParameterMapping getParameterMapping() {
		if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__PARAMETER_MAPPING) return null;
		return (ParameterMapping)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterMapping basicGetParameterMapping() {
		if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__PARAMETER_MAPPING) return null;
		return (ParameterMapping)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameterMapping(ParameterMapping newParameterMapping, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParameterMapping, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__PARAMETER_MAPPING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParameterMapping(ParameterMapping newParameterMapping) {
		if (newParameterMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__PARAMETER_MAPPING && newParameterMapping != null)) {
			if (EcoreUtil.isAncestor(this, newParameterMapping))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParameterMapping != null)
				msgs = ((InternalEObject)newParameterMapping).eInverseAdd(this, MappingPackage.PARAMETER_MAPPING__ASPECTS, ParameterMapping.class, msgs);
			msgs = basicSetParameterMapping(newParameterMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__PARAMETER_MAPPING, newParameterMapping, newParameterMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TechnologySpecificFieldMapping getFieldMapping() {
		if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__FIELD_MAPPING) return null;
		return (TechnologySpecificFieldMapping)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TechnologySpecificFieldMapping basicGetFieldMapping() {
		if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__FIELD_MAPPING) return null;
		return (TechnologySpecificFieldMapping)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFieldMapping(TechnologySpecificFieldMapping newFieldMapping, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFieldMapping, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__FIELD_MAPPING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFieldMapping(TechnologySpecificFieldMapping newFieldMapping) {
		if (newFieldMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__FIELD_MAPPING && newFieldMapping != null)) {
			if (EcoreUtil.isAncestor(this, newFieldMapping))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFieldMapping != null)
				msgs = ((InternalEObject)newFieldMapping).eInverseAdd(this, MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__ASPECTS, TechnologySpecificFieldMapping.class, msgs);
			msgs = basicSetFieldMapping(newFieldMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__FIELD_MAPPING, newFieldMapping, newFieldMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataOperationMapping getDataOperationMapping() {
		if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_MAPPING) return null;
		return (DataOperationMapping)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataOperationMapping basicGetDataOperationMapping() {
		if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_MAPPING) return null;
		return (DataOperationMapping)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataOperationMapping(DataOperationMapping newDataOperationMapping, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDataOperationMapping, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_MAPPING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataOperationMapping(DataOperationMapping newDataOperationMapping) {
		if (newDataOperationMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_MAPPING && newDataOperationMapping != null)) {
			if (EcoreUtil.isAncestor(this, newDataOperationMapping))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDataOperationMapping != null)
				msgs = ((InternalEObject)newDataOperationMapping).eInverseAdd(this, MappingPackage.DATA_OPERATION_MAPPING__ASPECTS, DataOperationMapping.class, msgs);
			msgs = basicSetDataOperationMapping(newDataOperationMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_MAPPING, newDataOperationMapping, newDataOperationMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataOperationReturnTypeMapping getDataOperationReturnTypeMapping() {
		if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_RETURN_TYPE_MAPPING) return null;
		return (DataOperationReturnTypeMapping)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataOperationReturnTypeMapping basicGetDataOperationReturnTypeMapping() {
		if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_RETURN_TYPE_MAPPING) return null;
		return (DataOperationReturnTypeMapping)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataOperationReturnTypeMapping(DataOperationReturnTypeMapping newDataOperationReturnTypeMapping, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDataOperationReturnTypeMapping, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_RETURN_TYPE_MAPPING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataOperationReturnTypeMapping(DataOperationReturnTypeMapping newDataOperationReturnTypeMapping) {
		if (newDataOperationReturnTypeMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_RETURN_TYPE_MAPPING && newDataOperationReturnTypeMapping != null)) {
			if (EcoreUtil.isAncestor(this, newDataOperationReturnTypeMapping))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDataOperationReturnTypeMapping != null)
				msgs = ((InternalEObject)newDataOperationReturnTypeMapping).eInverseAdd(this, MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__ASPECTS, DataOperationReturnTypeMapping.class, msgs);
			msgs = basicSetDataOperationReturnTypeMapping(newDataOperationReturnTypeMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_RETURN_TYPE_MAPPING, newDataOperationReturnTypeMapping, newDataOperationReturnTypeMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataOperationParameterMapping getDataOperationParameterMapping() {
		if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_PARAMETER_MAPPING) return null;
		return (DataOperationParameterMapping)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataOperationParameterMapping basicGetDataOperationParameterMapping() {
		if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_PARAMETER_MAPPING) return null;
		return (DataOperationParameterMapping)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataOperationParameterMapping(DataOperationParameterMapping newDataOperationParameterMapping, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDataOperationParameterMapping, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_PARAMETER_MAPPING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataOperationParameterMapping(DataOperationParameterMapping newDataOperationParameterMapping) {
		if (newDataOperationParameterMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_PARAMETER_MAPPING && newDataOperationParameterMapping != null)) {
			if (EcoreUtil.isAncestor(this, newDataOperationParameterMapping))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDataOperationParameterMapping != null)
				msgs = ((InternalEObject)newDataOperationParameterMapping).eInverseAdd(this, MappingPackage.DATA_OPERATION_PARAMETER_MAPPING__ASPECTS, DataOperationParameterMapping.class, msgs);
			msgs = basicSetDataOperationParameterMapping(newDataOperationParameterMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_PARAMETER_MAPPING, newDataOperationParameterMapping, newDataOperationParameterMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TYPE_MAPPING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTypeMapping((ComplexTypeMapping)otherEnd, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__MICROSERVICE_MAPPING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMicroserviceMapping((MicroserviceMapping)otherEnd, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__INTERFACE_MAPPING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInterfaceMapping((InterfaceMapping)otherEnd, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__OPERATION_MAPPING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOperationMapping((OperationMapping)otherEnd, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION_MAPPING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetReferredOperationMapping((ReferredOperationMapping)otherEnd, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__PARAMETER_MAPPING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParameterMapping((ParameterMapping)otherEnd, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__FIELD_MAPPING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFieldMapping((TechnologySpecificFieldMapping)otherEnd, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_MAPPING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDataOperationMapping((DataOperationMapping)otherEnd, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_RETURN_TYPE_MAPPING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDataOperationReturnTypeMapping((DataOperationReturnTypeMapping)otherEnd, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_PARAMETER_MAPPING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDataOperationParameterMapping((DataOperationParameterMapping)otherEnd, msgs);
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
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE:
				return basicSetSinglePropertyValue(null, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__VALUES:
				return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TYPE_MAPPING:
				return basicSetTypeMapping(null, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__MICROSERVICE_MAPPING:
				return basicSetMicroserviceMapping(null, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__INTERFACE_MAPPING:
				return basicSetInterfaceMapping(null, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__OPERATION_MAPPING:
				return basicSetOperationMapping(null, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION_MAPPING:
				return basicSetReferredOperationMapping(null, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__PARAMETER_MAPPING:
				return basicSetParameterMapping(null, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__FIELD_MAPPING:
				return basicSetFieldMapping(null, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_MAPPING:
				return basicSetDataOperationMapping(null, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_RETURN_TYPE_MAPPING:
				return basicSetDataOperationReturnTypeMapping(null, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_PARAMETER_MAPPING:
				return basicSetDataOperationParameterMapping(null, msgs);
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
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TYPE_MAPPING:
				return eInternalContainer().eInverseRemove(this, MappingPackage.COMPLEX_TYPE_MAPPING__ASPECTS, ComplexTypeMapping.class, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__MICROSERVICE_MAPPING:
				return eInternalContainer().eInverseRemove(this, MappingPackage.MICROSERVICE_MAPPING__ASPECTS, MicroserviceMapping.class, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__INTERFACE_MAPPING:
				return eInternalContainer().eInverseRemove(this, MappingPackage.INTERFACE_MAPPING__ASPECTS, InterfaceMapping.class, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__OPERATION_MAPPING:
				return eInternalContainer().eInverseRemove(this, MappingPackage.OPERATION_MAPPING__ASPECTS, OperationMapping.class, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION_MAPPING:
				return eInternalContainer().eInverseRemove(this, MappingPackage.REFERRED_OPERATION_MAPPING__ASPECTS, ReferredOperationMapping.class, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__PARAMETER_MAPPING:
				return eInternalContainer().eInverseRemove(this, MappingPackage.PARAMETER_MAPPING__ASPECTS, ParameterMapping.class, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__FIELD_MAPPING:
				return eInternalContainer().eInverseRemove(this, MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__ASPECTS, TechnologySpecificFieldMapping.class, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_MAPPING:
				return eInternalContainer().eInverseRemove(this, MappingPackage.DATA_OPERATION_MAPPING__ASPECTS, DataOperationMapping.class, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_RETURN_TYPE_MAPPING:
				return eInternalContainer().eInverseRemove(this, MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__ASPECTS, DataOperationReturnTypeMapping.class, msgs);
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_PARAMETER_MAPPING:
				return eInternalContainer().eInverseRemove(this, MappingPackage.DATA_OPERATION_PARAMETER_MAPPING__ASPECTS, DataOperationParameterMapping.class, msgs);
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
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TECHNOLOGY:
				if (resolve) return getTechnology();
				return basicGetTechnology();
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__ASPECT:
				if (resolve) return getAspect();
				return basicGetAspect();
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE:
				return getSinglePropertyValue();
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__VALUES:
				return getValues();
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TYPE_MAPPING:
				if (resolve) return getTypeMapping();
				return basicGetTypeMapping();
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__MICROSERVICE_MAPPING:
				if (resolve) return getMicroserviceMapping();
				return basicGetMicroserviceMapping();
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__INTERFACE_MAPPING:
				if (resolve) return getInterfaceMapping();
				return basicGetInterfaceMapping();
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__OPERATION_MAPPING:
				if (resolve) return getOperationMapping();
				return basicGetOperationMapping();
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION_MAPPING:
				if (resolve) return getReferredOperationMapping();
				return basicGetReferredOperationMapping();
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__PARAMETER_MAPPING:
				if (resolve) return getParameterMapping();
				return basicGetParameterMapping();
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__FIELD_MAPPING:
				if (resolve) return getFieldMapping();
				return basicGetFieldMapping();
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_MAPPING:
				if (resolve) return getDataOperationMapping();
				return basicGetDataOperationMapping();
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_RETURN_TYPE_MAPPING:
				if (resolve) return getDataOperationReturnTypeMapping();
				return basicGetDataOperationReturnTypeMapping();
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_PARAMETER_MAPPING:
				if (resolve) return getDataOperationParameterMapping();
				return basicGetDataOperationParameterMapping();
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
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TECHNOLOGY:
				setTechnology((Import)newValue);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__ASPECT:
				setAspect((ServiceAspect)newValue);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE:
				setSinglePropertyValue((PrimitiveValue)newValue);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends TechnologySpecificPropertyValueAssignment>)newValue);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TYPE_MAPPING:
				setTypeMapping((ComplexTypeMapping)newValue);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__MICROSERVICE_MAPPING:
				setMicroserviceMapping((MicroserviceMapping)newValue);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__INTERFACE_MAPPING:
				setInterfaceMapping((InterfaceMapping)newValue);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__OPERATION_MAPPING:
				setOperationMapping((OperationMapping)newValue);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION_MAPPING:
				setReferredOperationMapping((ReferredOperationMapping)newValue);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__PARAMETER_MAPPING:
				setParameterMapping((ParameterMapping)newValue);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__FIELD_MAPPING:
				setFieldMapping((TechnologySpecificFieldMapping)newValue);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_MAPPING:
				setDataOperationMapping((DataOperationMapping)newValue);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_RETURN_TYPE_MAPPING:
				setDataOperationReturnTypeMapping((DataOperationReturnTypeMapping)newValue);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_PARAMETER_MAPPING:
				setDataOperationParameterMapping((DataOperationParameterMapping)newValue);
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
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TECHNOLOGY:
				setTechnology((Import)null);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__ASPECT:
				setAspect((ServiceAspect)null);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE:
				setSinglePropertyValue((PrimitiveValue)null);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__VALUES:
				getValues().clear();
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TYPE_MAPPING:
				setTypeMapping((ComplexTypeMapping)null);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__MICROSERVICE_MAPPING:
				setMicroserviceMapping((MicroserviceMapping)null);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__INTERFACE_MAPPING:
				setInterfaceMapping((InterfaceMapping)null);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__OPERATION_MAPPING:
				setOperationMapping((OperationMapping)null);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION_MAPPING:
				setReferredOperationMapping((ReferredOperationMapping)null);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__PARAMETER_MAPPING:
				setParameterMapping((ParameterMapping)null);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__FIELD_MAPPING:
				setFieldMapping((TechnologySpecificFieldMapping)null);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_MAPPING:
				setDataOperationMapping((DataOperationMapping)null);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_RETURN_TYPE_MAPPING:
				setDataOperationReturnTypeMapping((DataOperationReturnTypeMapping)null);
				return;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_PARAMETER_MAPPING:
				setDataOperationParameterMapping((DataOperationParameterMapping)null);
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
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TECHNOLOGY:
				return technology != null;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__ASPECT:
				return aspect != null;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE:
				return singlePropertyValue != null;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__VALUES:
				return values != null && !values.isEmpty();
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TYPE_MAPPING:
				return basicGetTypeMapping() != null;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__MICROSERVICE_MAPPING:
				return basicGetMicroserviceMapping() != null;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__INTERFACE_MAPPING:
				return basicGetInterfaceMapping() != null;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__OPERATION_MAPPING:
				return basicGetOperationMapping() != null;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION_MAPPING:
				return basicGetReferredOperationMapping() != null;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__PARAMETER_MAPPING:
				return basicGetParameterMapping() != null;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__FIELD_MAPPING:
				return basicGetFieldMapping() != null;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_MAPPING:
				return basicGetDataOperationMapping() != null;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_RETURN_TYPE_MAPPING:
				return basicGetDataOperationReturnTypeMapping() != null;
			case MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_PARAMETER_MAPPING:
				return basicGetDataOperationParameterMapping() != null;
		}
		return super.eIsSet(featureID);
	}

} //TechnologySpecificImportedServiceAspectImpl
