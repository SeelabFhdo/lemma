/**
 */
package de.fhdo.lemma.service.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateImport;

import de.fhdo.lemma.service.intermediate.IntermediateMicroservice;
import de.fhdo.lemma.service.intermediate.IntermediatePackage;
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateServiceModelImpl#getSourceModelUri <em>Source Model Uri</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateServiceModelImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateServiceModelImpl#getMicroservices <em>Microservices</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateServiceModelImpl extends MinimalEObjectImpl.Container implements IntermediateServiceModel {
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
	 * The cached value of the '{@link #getMicroservices() <em>Microservices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMicroservices()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateMicroservice> microservices;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntermediateServiceModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.INTERMEDIATE_SERVICE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSourceModelUri() {
		return sourceModelUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSourceModelUri(String newSourceModelUri) {
		String oldSourceModelUri = sourceModelUri;
		sourceModelUri = newSourceModelUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_SERVICE_MODEL__SOURCE_MODEL_URI, oldSourceModelUri, sourceModelUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IntermediateImport> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<IntermediateImport>(IntermediateImport.class, this, IntermediatePackage.INTERMEDIATE_SERVICE_MODEL__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IntermediateMicroservice> getMicroservices() {
		if (microservices == null) {
			microservices = new EObjectContainmentWithInverseEList<IntermediateMicroservice>(IntermediateMicroservice.class, this, IntermediatePackage.INTERMEDIATE_SERVICE_MODEL__MICROSERVICES, IntermediatePackage.INTERMEDIATE_MICROSERVICE__SERVICE_MODEL);
		}
		return microservices;
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
			case IntermediatePackage.INTERMEDIATE_SERVICE_MODEL__MICROSERVICES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMicroservices()).basicAdd(otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_SERVICE_MODEL__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_SERVICE_MODEL__MICROSERVICES:
				return ((InternalEList<?>)getMicroservices()).basicRemove(otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_SERVICE_MODEL__SOURCE_MODEL_URI:
				return getSourceModelUri();
			case IntermediatePackage.INTERMEDIATE_SERVICE_MODEL__IMPORTS:
				return getImports();
			case IntermediatePackage.INTERMEDIATE_SERVICE_MODEL__MICROSERVICES:
				return getMicroservices();
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
			case IntermediatePackage.INTERMEDIATE_SERVICE_MODEL__SOURCE_MODEL_URI:
				setSourceModelUri((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_SERVICE_MODEL__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends IntermediateImport>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_SERVICE_MODEL__MICROSERVICES:
				getMicroservices().clear();
				getMicroservices().addAll((Collection<? extends IntermediateMicroservice>)newValue);
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
			case IntermediatePackage.INTERMEDIATE_SERVICE_MODEL__SOURCE_MODEL_URI:
				setSourceModelUri(SOURCE_MODEL_URI_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_SERVICE_MODEL__IMPORTS:
				getImports().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_SERVICE_MODEL__MICROSERVICES:
				getMicroservices().clear();
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
			case IntermediatePackage.INTERMEDIATE_SERVICE_MODEL__SOURCE_MODEL_URI:
				return SOURCE_MODEL_URI_EDEFAULT == null ? sourceModelUri != null : !SOURCE_MODEL_URI_EDEFAULT.equals(sourceModelUri);
			case IntermediatePackage.INTERMEDIATE_SERVICE_MODEL__IMPORTS:
				return imports != null && !imports.isEmpty();
			case IntermediatePackage.INTERMEDIATE_SERVICE_MODEL__MICROSERVICES:
				return microservices != null && !microservices.isEmpty();
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

} //IntermediateServiceModelImpl
