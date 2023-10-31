/**
 */
package de.fhdo.lemma.operation.impl;

import de.fhdo.lemma.operation.ImportedMicroservice;
import de.fhdo.lemma.operation.ImportedOperationAspect;
import de.fhdo.lemma.operation.OperationNode;
import de.fhdo.lemma.operation.OperationPackage;
import de.fhdo.lemma.operation.PossiblyImportedOperationNode;
import de.fhdo.lemma.operation.ServiceDeploymentSpecification;

import de.fhdo.lemma.service.Import;

import de.fhdo.lemma.technology.OperationEnvironment;
import de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.Collection;

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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.impl.OperationNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.OperationNodeImpl#getTechnologies <em>Technologies</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.OperationNodeImpl#getOperationEnvironment <em>Operation Environment</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.OperationNodeImpl#getDeployedServices <em>Deployed Services</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.OperationNodeImpl#getDefaultServicePropertyValues <em>Default Service Property Values</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.OperationNodeImpl#getDeploymentSpecifications <em>Deployment Specifications</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.OperationNodeImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.OperationNodeImpl#getUsedByNodes <em>Used By Nodes</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.OperationNodeImpl#getDependsOnNodes <em>Depends On Nodes</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class OperationNodeImpl extends MinimalEObjectImpl.Container implements OperationNode {
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
	 * The cached value of the '{@link #getTechnologies() <em>Technologies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTechnologies()
	 * @generated
	 * @ordered
	 */
	protected EList<Import> technologies;

	/**
	 * The cached value of the '{@link #getOperationEnvironment() <em>Operation Environment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationEnvironment()
	 * @generated
	 * @ordered
	 */
	protected OperationEnvironment operationEnvironment;

	/**
	 * The cached value of the '{@link #getDeployedServices() <em>Deployed Services</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeployedServices()
	 * @generated
	 * @ordered
	 */
	protected EList<ImportedMicroservice> deployedServices;

	/**
	 * The cached value of the '{@link #getDefaultServicePropertyValues() <em>Default Service Property Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultServicePropertyValues()
	 * @generated
	 * @ordered
	 */
	protected EList<TechnologySpecificPropertyValueAssignment> defaultServicePropertyValues;

	/**
	 * The cached value of the '{@link #getDeploymentSpecifications() <em>Deployment Specifications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeploymentSpecifications()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceDeploymentSpecification> deploymentSpecifications;

	/**
	 * The cached value of the '{@link #getAspects() <em>Aspects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAspects()
	 * @generated
	 * @ordered
	 */
	protected EList<ImportedOperationAspect> aspects;

	/**
	 * The cached value of the '{@link #getUsedByNodes() <em>Used By Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedByNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<PossiblyImportedOperationNode> usedByNodes;

	/**
	 * The cached value of the '{@link #getDependsOnNodes() <em>Depends On Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependsOnNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<PossiblyImportedOperationNode> dependsOnNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationPackage.Literals.OPERATION_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.OPERATION_NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Import> getTechnologies() {
		if (technologies == null) {
			technologies = new EObjectResolvingEList<Import>(Import.class, this, OperationPackage.OPERATION_NODE__TECHNOLOGIES);
		}
		return technologies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationEnvironment getOperationEnvironment() {
		if (operationEnvironment != null && operationEnvironment.eIsProxy()) {
			InternalEObject oldOperationEnvironment = (InternalEObject)operationEnvironment;
			operationEnvironment = (OperationEnvironment)eResolveProxy(oldOperationEnvironment);
			if (operationEnvironment != oldOperationEnvironment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.OPERATION_NODE__OPERATION_ENVIRONMENT, oldOperationEnvironment, operationEnvironment));
			}
		}
		return operationEnvironment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationEnvironment basicGetOperationEnvironment() {
		return operationEnvironment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperationEnvironment(OperationEnvironment newOperationEnvironment) {
		OperationEnvironment oldOperationEnvironment = operationEnvironment;
		operationEnvironment = newOperationEnvironment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.OPERATION_NODE__OPERATION_ENVIRONMENT, oldOperationEnvironment, operationEnvironment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ImportedMicroservice> getDeployedServices() {
		if (deployedServices == null) {
			deployedServices = new EObjectContainmentWithInverseEList<ImportedMicroservice>(ImportedMicroservice.class, this, OperationPackage.OPERATION_NODE__DEPLOYED_SERVICES, OperationPackage.IMPORTED_MICROSERVICE__OPERATION_NODE);
		}
		return deployedServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TechnologySpecificPropertyValueAssignment> getDefaultServicePropertyValues() {
		if (defaultServicePropertyValues == null) {
			defaultServicePropertyValues = new EObjectContainmentEList<TechnologySpecificPropertyValueAssignment>(TechnologySpecificPropertyValueAssignment.class, this, OperationPackage.OPERATION_NODE__DEFAULT_SERVICE_PROPERTY_VALUES);
		}
		return defaultServicePropertyValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ServiceDeploymentSpecification> getDeploymentSpecifications() {
		if (deploymentSpecifications == null) {
			deploymentSpecifications = new EObjectContainmentWithInverseEList<ServiceDeploymentSpecification>(ServiceDeploymentSpecification.class, this, OperationPackage.OPERATION_NODE__DEPLOYMENT_SPECIFICATIONS, OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE);
		}
		return deploymentSpecifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ImportedOperationAspect> getAspects() {
		if (aspects == null) {
			aspects = new EObjectContainmentWithInverseEList<ImportedOperationAspect>(ImportedOperationAspect.class, this, OperationPackage.OPERATION_NODE__ASPECTS, OperationPackage.IMPORTED_OPERATION_ASPECT__OPERATION_NODE);
		}
		return aspects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PossiblyImportedOperationNode> getUsedByNodes() {
		if (usedByNodes == null) {
			usedByNodes = new EObjectContainmentEList<PossiblyImportedOperationNode>(PossiblyImportedOperationNode.class, this, OperationPackage.OPERATION_NODE__USED_BY_NODES);
		}
		return usedByNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PossiblyImportedOperationNode> getDependsOnNodes() {
		if (dependsOnNodes == null) {
			dependsOnNodes = new EObjectContainmentEList<PossiblyImportedOperationNode>(PossiblyImportedOperationNode.class, this, OperationPackage.OPERATION_NODE__DEPENDS_ON_NODES);
		}
		return dependsOnNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getQualifiedNameParts() {
		EList<String> _xblockexpression = null;
		{
			if (((this.getName() == null) || this.getName().isEmpty())) {
				return ECollections.<String>asEList(CollectionLiterals.<String>newArrayList());
			}
			final ArrayList<String> nameParts = CollectionLiterals.<String>newArrayList();
			CollectionExtensions.<String>addAll(nameParts, this.getName());
			_xblockexpression = ECollections.<String>asEList(nameParts);
		}
		return _xblockexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String buildQualifiedName(final String separator) {
		if ((separator == null)) {
			return null;
		}
		String qualifiedName = "";
		EList<String> _qualifiedNameParts = this.getQualifiedNameParts();
		for (final String part : _qualifiedNameParts) {
			String _qualifiedName = qualifiedName;
			qualifiedName = (_qualifiedName + (separator + part));
		}
		boolean _isEmpty = qualifiedName.isEmpty();
		boolean _not = (!_isEmpty);
		if (_not) {
			qualifiedName = qualifiedName.substring(separator.length());
		}
		return qualifiedName;
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
			case OperationPackage.OPERATION_NODE__DEPLOYED_SERVICES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDeployedServices()).basicAdd(otherEnd, msgs);
			case OperationPackage.OPERATION_NODE__DEPLOYMENT_SPECIFICATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDeploymentSpecifications()).basicAdd(otherEnd, msgs);
			case OperationPackage.OPERATION_NODE__ASPECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
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
			case OperationPackage.OPERATION_NODE__DEPLOYED_SERVICES:
				return ((InternalEList<?>)getDeployedServices()).basicRemove(otherEnd, msgs);
			case OperationPackage.OPERATION_NODE__DEFAULT_SERVICE_PROPERTY_VALUES:
				return ((InternalEList<?>)getDefaultServicePropertyValues()).basicRemove(otherEnd, msgs);
			case OperationPackage.OPERATION_NODE__DEPLOYMENT_SPECIFICATIONS:
				return ((InternalEList<?>)getDeploymentSpecifications()).basicRemove(otherEnd, msgs);
			case OperationPackage.OPERATION_NODE__ASPECTS:
				return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
			case OperationPackage.OPERATION_NODE__USED_BY_NODES:
				return ((InternalEList<?>)getUsedByNodes()).basicRemove(otherEnd, msgs);
			case OperationPackage.OPERATION_NODE__DEPENDS_ON_NODES:
				return ((InternalEList<?>)getDependsOnNodes()).basicRemove(otherEnd, msgs);
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
			case OperationPackage.OPERATION_NODE__NAME:
				return getName();
			case OperationPackage.OPERATION_NODE__TECHNOLOGIES:
				return getTechnologies();
			case OperationPackage.OPERATION_NODE__OPERATION_ENVIRONMENT:
				if (resolve) return getOperationEnvironment();
				return basicGetOperationEnvironment();
			case OperationPackage.OPERATION_NODE__DEPLOYED_SERVICES:
				return getDeployedServices();
			case OperationPackage.OPERATION_NODE__DEFAULT_SERVICE_PROPERTY_VALUES:
				return getDefaultServicePropertyValues();
			case OperationPackage.OPERATION_NODE__DEPLOYMENT_SPECIFICATIONS:
				return getDeploymentSpecifications();
			case OperationPackage.OPERATION_NODE__ASPECTS:
				return getAspects();
			case OperationPackage.OPERATION_NODE__USED_BY_NODES:
				return getUsedByNodes();
			case OperationPackage.OPERATION_NODE__DEPENDS_ON_NODES:
				return getDependsOnNodes();
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
			case OperationPackage.OPERATION_NODE__NAME:
				setName((String)newValue);
				return;
			case OperationPackage.OPERATION_NODE__TECHNOLOGIES:
				getTechnologies().clear();
				getTechnologies().addAll((Collection<? extends Import>)newValue);
				return;
			case OperationPackage.OPERATION_NODE__OPERATION_ENVIRONMENT:
				setOperationEnvironment((OperationEnvironment)newValue);
				return;
			case OperationPackage.OPERATION_NODE__DEPLOYED_SERVICES:
				getDeployedServices().clear();
				getDeployedServices().addAll((Collection<? extends ImportedMicroservice>)newValue);
				return;
			case OperationPackage.OPERATION_NODE__DEFAULT_SERVICE_PROPERTY_VALUES:
				getDefaultServicePropertyValues().clear();
				getDefaultServicePropertyValues().addAll((Collection<? extends TechnologySpecificPropertyValueAssignment>)newValue);
				return;
			case OperationPackage.OPERATION_NODE__DEPLOYMENT_SPECIFICATIONS:
				getDeploymentSpecifications().clear();
				getDeploymentSpecifications().addAll((Collection<? extends ServiceDeploymentSpecification>)newValue);
				return;
			case OperationPackage.OPERATION_NODE__ASPECTS:
				getAspects().clear();
				getAspects().addAll((Collection<? extends ImportedOperationAspect>)newValue);
				return;
			case OperationPackage.OPERATION_NODE__USED_BY_NODES:
				getUsedByNodes().clear();
				getUsedByNodes().addAll((Collection<? extends PossiblyImportedOperationNode>)newValue);
				return;
			case OperationPackage.OPERATION_NODE__DEPENDS_ON_NODES:
				getDependsOnNodes().clear();
				getDependsOnNodes().addAll((Collection<? extends PossiblyImportedOperationNode>)newValue);
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
			case OperationPackage.OPERATION_NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OperationPackage.OPERATION_NODE__TECHNOLOGIES:
				getTechnologies().clear();
				return;
			case OperationPackage.OPERATION_NODE__OPERATION_ENVIRONMENT:
				setOperationEnvironment((OperationEnvironment)null);
				return;
			case OperationPackage.OPERATION_NODE__DEPLOYED_SERVICES:
				getDeployedServices().clear();
				return;
			case OperationPackage.OPERATION_NODE__DEFAULT_SERVICE_PROPERTY_VALUES:
				getDefaultServicePropertyValues().clear();
				return;
			case OperationPackage.OPERATION_NODE__DEPLOYMENT_SPECIFICATIONS:
				getDeploymentSpecifications().clear();
				return;
			case OperationPackage.OPERATION_NODE__ASPECTS:
				getAspects().clear();
				return;
			case OperationPackage.OPERATION_NODE__USED_BY_NODES:
				getUsedByNodes().clear();
				return;
			case OperationPackage.OPERATION_NODE__DEPENDS_ON_NODES:
				getDependsOnNodes().clear();
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
			case OperationPackage.OPERATION_NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OperationPackage.OPERATION_NODE__TECHNOLOGIES:
				return technologies != null && !technologies.isEmpty();
			case OperationPackage.OPERATION_NODE__OPERATION_ENVIRONMENT:
				return operationEnvironment != null;
			case OperationPackage.OPERATION_NODE__DEPLOYED_SERVICES:
				return deployedServices != null && !deployedServices.isEmpty();
			case OperationPackage.OPERATION_NODE__DEFAULT_SERVICE_PROPERTY_VALUES:
				return defaultServicePropertyValues != null && !defaultServicePropertyValues.isEmpty();
			case OperationPackage.OPERATION_NODE__DEPLOYMENT_SPECIFICATIONS:
				return deploymentSpecifications != null && !deploymentSpecifications.isEmpty();
			case OperationPackage.OPERATION_NODE__ASPECTS:
				return aspects != null && !aspects.isEmpty();
			case OperationPackage.OPERATION_NODE__USED_BY_NODES:
				return usedByNodes != null && !usedByNodes.isEmpty();
			case OperationPackage.OPERATION_NODE__DEPENDS_ON_NODES:
				return dependsOnNodes != null && !dependsOnNodes.isEmpty();
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
			case OperationPackage.OPERATION_NODE___GET_QUALIFIED_NAME_PARTS:
				return getQualifiedNameParts();
			case OperationPackage.OPERATION_NODE___BUILD_QUALIFIED_NAME__STRING:
				return buildQualifiedName((String)arguments.get(0));
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //OperationNodeImpl
