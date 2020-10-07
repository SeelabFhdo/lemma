/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import com.google.common.base.Objects;

import de.fhdo.lemma.data.intermediate.IntermediateImport;
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect;

import de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;
import de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification;
import de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue;
import de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#isImported <em>Imported</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#getOperationEnvironment <em>Operation Environment</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#getDeployedServices <em>Deployed Services</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#getSpecifications <em>Specifications</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#getDefaultValues <em>Default Values</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#getDependsOnNodes <em>Depends On Nodes</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationNodeImpl#getUsedByNodes <em>Used By Nodes</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class IntermediateOperationNodeImpl extends MinimalEObjectImpl.Container implements IntermediateOperationNode {
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
     * The cached value of the '{@link #getImports() <em>Imports</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImports()
     * @generated
     * @ordered
     */
    protected EList<IntermediateImport> imports;

    /**
     * The cached value of the '{@link #getOperationEnvironment() <em>Operation Environment</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperationEnvironment()
     * @generated
     * @ordered
     */
    protected IntermediateOperationEnvironment operationEnvironment;

    /**
     * The cached value of the '{@link #getDeployedServices() <em>Deployed Services</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDeployedServices()
     * @generated
     * @ordered
     */
    protected EList<OperationMicroserviceReference> deployedServices;

    /**
     * The cached value of the '{@link #getEndpoints() <em>Endpoints</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEndpoints()
     * @generated
     * @ordered
     */
    protected EList<IntermediateOperationEndpoint> endpoints;

    /**
     * The cached value of the '{@link #getSpecifications() <em>Specifications</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSpecifications()
     * @generated
     * @ordered
     */
    protected EList<IntermediateServiceDeploymentSpecification> specifications;

    /**
     * The cached value of the '{@link #getDefaultValues() <em>Default Values</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultValues()
     * @generated
     * @ordered
     */
    protected EList<IntermediateTechnologySpecificPropertyValue> defaultValues;

    /**
     * The cached value of the '{@link #getAspects() <em>Aspects</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAspects()
     * @generated
     * @ordered
     */
    protected EList<IntermediateImportedAspect> aspects;

    /**
     * The cached value of the '{@link #getDependsOnNodes() <em>Depends On Nodes</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDependsOnNodes()
     * @generated
     * @ordered
     */
    protected EList<IntermediateOperationNode> dependsOnNodes;

    /**
     * The cached value of the '{@link #getUsedByNodes() <em>Used By Nodes</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUsedByNodes()
     * @generated
     * @ordered
     */
    protected EList<IntermediateOperationNode> usedByNodes;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediateOperationNodeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_OPERATION_NODE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isImported() {
        return imported;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setImported(boolean newImported) {
        boolean oldImported = imported;
        imported = newImported;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__IMPORTED, oldImported, imported));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<IntermediateImport> getImports() {
        if (imports == null) {
            imports = new EObjectResolvingEList<IntermediateImport>(IntermediateImport.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__IMPORTS);
        }
        return imports;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateOperationEnvironment getOperationEnvironment() {
        if (operationEnvironment != null && operationEnvironment.eIsProxy()) {
            InternalEObject oldOperationEnvironment = (InternalEObject)operationEnvironment;
            operationEnvironment = (IntermediateOperationEnvironment)eResolveProxy(oldOperationEnvironment);
            if (operationEnvironment != oldOperationEnvironment) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__OPERATION_ENVIRONMENT, oldOperationEnvironment, operationEnvironment));
            }
        }
        return operationEnvironment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateOperationEnvironment basicGetOperationEnvironment() {
        return operationEnvironment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setOperationEnvironment(IntermediateOperationEnvironment newOperationEnvironment) {
        IntermediateOperationEnvironment oldOperationEnvironment = operationEnvironment;
        operationEnvironment = newOperationEnvironment;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__OPERATION_ENVIRONMENT, oldOperationEnvironment, operationEnvironment));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<OperationMicroserviceReference> getDeployedServices() {
        if (deployedServices == null) {
            deployedServices = new EObjectContainmentWithInverseEList<OperationMicroserviceReference>(OperationMicroserviceReference.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES, IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__NODE);
        }
        return deployedServices;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<IntermediateOperationEndpoint> getEndpoints() {
        if (endpoints == null) {
            endpoints = new EObjectContainmentWithInverseEList<IntermediateOperationEndpoint>(IntermediateOperationEndpoint.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ENDPOINTS, IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__NODE);
        }
        return endpoints;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<IntermediateServiceDeploymentSpecification> getSpecifications() {
        if (specifications == null) {
            specifications = new EObjectContainmentWithInverseEList<IntermediateServiceDeploymentSpecification>(IntermediateServiceDeploymentSpecification.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS, IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE);
        }
        return specifications;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<IntermediateTechnologySpecificPropertyValue> getDefaultValues() {
        if (defaultValues == null) {
            defaultValues = new EObjectContainmentWithInverseEList<IntermediateTechnologySpecificPropertyValue>(IntermediateTechnologySpecificPropertyValue.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEFAULT_VALUES, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__OPERATION_NODE);
        }
        return defaultValues;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<IntermediateImportedAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentEList<IntermediateImportedAspect>(IntermediateImportedAspect.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ASPECTS);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<IntermediateOperationNode> getDependsOnNodes() {
        if (dependsOnNodes == null) {
            dependsOnNodes = new EObjectContainmentEList<IntermediateOperationNode>(IntermediateOperationNode.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPENDS_ON_NODES);
        }
        return dependsOnNodes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<IntermediateOperationNode> getUsedByNodes() {
        if (usedByNodes == null) {
            usedByNodes = new EObjectContainmentEList<IntermediateOperationNode>(IntermediateOperationNode.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__USED_BY_NODES);
        }
        return usedByNodes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<IntermediateTechnologySpecificPropertyValue> getEffectiveConfigurationValues(final OperationMicroserviceReference deployedService) {
        final IntermediateTechnologySpecificPropertyValue[] effectiveConfigurationValues = ((IntermediateTechnologySpecificPropertyValue[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(this.getDefaultValues(), IntermediateTechnologySpecificPropertyValue.class));
        final Function1<IntermediateServiceDeploymentSpecification, Boolean> _function = new Function1<IntermediateServiceDeploymentSpecification, Boolean>() {
            public Boolean apply(final IntermediateServiceDeploymentSpecification it) {
                OperationMicroserviceReference _operationMicroserviceReference = it.getOperationMicroserviceReference();
                return Boolean.valueOf(Objects.equal(_operationMicroserviceReference, deployedService));
            }
        };
        final IntermediateServiceDeploymentSpecification serviceSpecification = IterableExtensions.<IntermediateServiceDeploymentSpecification>findFirst(this.getSpecifications(), _function);
        if ((serviceSpecification == null)) {
            return ECollections.<IntermediateTechnologySpecificPropertyValue>toEList(((Iterable<? extends IntermediateTechnologySpecificPropertyValue>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(effectiveConfigurationValues)));
        }
        final Function1<IntermediateTechnologySpecificPropertyValue, String> _function_1 = new Function1<IntermediateTechnologySpecificPropertyValue, String>() {
            public String apply(final IntermediateTechnologySpecificPropertyValue it) {
                return it.getTechnologySpecificProperty().getName();
            }
        };
        final Function1<IntermediateTechnologySpecificPropertyValue, String> _function_2 = new Function1<IntermediateTechnologySpecificPropertyValue, String>() {
            public String apply(final IntermediateTechnologySpecificPropertyValue it) {
                return it.getValue();
            }
        };
        final Map<String, String> serviceConfigurationValues = IterableExtensions.<IntermediateTechnologySpecificPropertyValue, String, String>toMap(serviceSpecification.getPropertyValues(), _function_1, _function_2);
        final Function1<IntermediateTechnologySpecificPropertyValue, IntermediateTechnologySpecificPropertyValue> _function_3 = new Function1<IntermediateTechnologySpecificPropertyValue, IntermediateTechnologySpecificPropertyValue>() {
            public IntermediateTechnologySpecificPropertyValue apply(final IntermediateTechnologySpecificPropertyValue it) {
                IntermediateTechnologySpecificPropertyValue _xblockexpression = null;
                {
                    final String propertyName = it.getTechnologySpecificProperty().getName();
                    final String serviceSpecificValue = serviceConfigurationValues.get(propertyName);
                    if ((serviceSpecificValue != null)) {
                        it.setValue(serviceSpecificValue);
                    }
                    _xblockexpression = it;
                }
                return _xblockexpression;
            }
        };
        return ECollections.<IntermediateTechnologySpecificPropertyValue>toEList(ListExtensions.<IntermediateTechnologySpecificPropertyValue, IntermediateTechnologySpecificPropertyValue>map(((List<IntermediateTechnologySpecificPropertyValue>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(effectiveConfigurationValues)), _function_3));
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getDeployedServices()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ENDPOINTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getEndpoints()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecifications()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEFAULT_VALUES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getDefaultValues()).basicAdd(otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES:
                return ((InternalEList<?>)getDeployedServices()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ENDPOINTS:
                return ((InternalEList<?>)getEndpoints()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS:
                return ((InternalEList<?>)getSpecifications()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEFAULT_VALUES:
                return ((InternalEList<?>)getDefaultValues()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPENDS_ON_NODES:
                return ((InternalEList<?>)getDependsOnNodes()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__USED_BY_NODES:
                return ((InternalEList<?>)getUsedByNodes()).basicRemove(otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__NAME:
                return getName();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__IMPORTED:
                return isImported();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__IMPORTS:
                return getImports();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__OPERATION_ENVIRONMENT:
                if (resolve) return getOperationEnvironment();
                return basicGetOperationEnvironment();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES:
                return getDeployedServices();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ENDPOINTS:
                return getEndpoints();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS:
                return getSpecifications();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEFAULT_VALUES:
                return getDefaultValues();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ASPECTS:
                return getAspects();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPENDS_ON_NODES:
                return getDependsOnNodes();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__USED_BY_NODES:
                return getUsedByNodes();
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__NAME:
                setName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__IMPORTED:
                setImported((Boolean)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__IMPORTS:
                getImports().clear();
                getImports().addAll((Collection<? extends IntermediateImport>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__OPERATION_ENVIRONMENT:
                setOperationEnvironment((IntermediateOperationEnvironment)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES:
                getDeployedServices().clear();
                getDeployedServices().addAll((Collection<? extends OperationMicroserviceReference>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ENDPOINTS:
                getEndpoints().clear();
                getEndpoints().addAll((Collection<? extends IntermediateOperationEndpoint>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS:
                getSpecifications().clear();
                getSpecifications().addAll((Collection<? extends IntermediateServiceDeploymentSpecification>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEFAULT_VALUES:
                getDefaultValues().clear();
                getDefaultValues().addAll((Collection<? extends IntermediateTechnologySpecificPropertyValue>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends IntermediateImportedAspect>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPENDS_ON_NODES:
                getDependsOnNodes().clear();
                getDependsOnNodes().addAll((Collection<? extends IntermediateOperationNode>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__USED_BY_NODES:
                getUsedByNodes().clear();
                getUsedByNodes().addAll((Collection<? extends IntermediateOperationNode>)newValue);
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__IMPORTED:
                setImported(IMPORTED_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__IMPORTS:
                getImports().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__OPERATION_ENVIRONMENT:
                setOperationEnvironment((IntermediateOperationEnvironment)null);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES:
                getDeployedServices().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ENDPOINTS:
                getEndpoints().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS:
                getSpecifications().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEFAULT_VALUES:
                getDefaultValues().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ASPECTS:
                getAspects().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPENDS_ON_NODES:
                getDependsOnNodes().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__USED_BY_NODES:
                getUsedByNodes().clear();
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__IMPORTED:
                return imported != IMPORTED_EDEFAULT;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__IMPORTS:
                return imports != null && !imports.isEmpty();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__OPERATION_ENVIRONMENT:
                return operationEnvironment != null;
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES:
                return deployedServices != null && !deployedServices.isEmpty();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ENDPOINTS:
                return endpoints != null && !endpoints.isEmpty();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS:
                return specifications != null && !specifications.isEmpty();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEFAULT_VALUES:
                return defaultValues != null && !defaultValues.isEmpty();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPENDS_ON_NODES:
                return dependsOnNodes != null && !dependsOnNodes.isEmpty();
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE__USED_BY_NODES:
                return usedByNodes != null && !usedByNodes.isEmpty();
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_NODE___GET_EFFECTIVE_CONFIGURATION_VALUES__OPERATIONMICROSERVICEREFERENCE:
                return getEffectiveConfigurationValues((OperationMicroserviceReference)arguments.get(0));
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
        result.append(", imported: ");
        result.append(imported);
        result.append(')');
        return result.toString();
    }

} //IntermediateOperationNodeImpl
