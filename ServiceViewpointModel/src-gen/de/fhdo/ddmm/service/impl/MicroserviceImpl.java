/**
 */
package de.fhdo.ddmm.service.impl;

import com.google.common.base.Objects;

import com.google.common.collect.Iterables;

import de.fhdo.ddmm.service.Endpoint;
import de.fhdo.ddmm.service.Import;
import de.fhdo.ddmm.service.ImportedServiceAspect;
import de.fhdo.ddmm.service.Interface;
import de.fhdo.ddmm.service.Microservice;
import de.fhdo.ddmm.service.MicroserviceType;
import de.fhdo.ddmm.service.Operation;
import de.fhdo.ddmm.service.PossiblyImportedInterface;
import de.fhdo.ddmm.service.PossiblyImportedMicroservice;
import de.fhdo.ddmm.service.PossiblyImportedOperation;
import de.fhdo.ddmm.service.ProtocolSpecification;
import de.fhdo.ddmm.service.ReferredOperation;
import de.fhdo.ddmm.service.ServiceModel;
import de.fhdo.ddmm.service.ServicePackage;
import de.fhdo.ddmm.service.Visibility;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Microservice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.impl.MicroserviceImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MicroserviceImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MicroserviceImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MicroserviceImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MicroserviceImpl#getTechnologies <em>Technologies</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MicroserviceImpl#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MicroserviceImpl#getRequiredMicroservices <em>Required Microservices</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MicroserviceImpl#getRequiredInterfaces <em>Required Interfaces</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MicroserviceImpl#getRequiredOperations <em>Required Operations</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MicroserviceImpl#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MicroserviceImpl#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MicroserviceImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MicroserviceImpl#getServiceModel <em>Service Model</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MicroserviceImpl#isEffectivelyImplemented <em>Effectively Implemented</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MicroserviceImpl#getEffectiveVisibility <em>Effective Visibility</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MicroserviceImpl#isEffectivelyInternal <em>Effectively Internal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MicroserviceImpl extends MinimalEObjectImpl.Container implements Microservice {
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
     * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected static final String VERSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected String version = VERSION_EDEFAULT;

    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final MicroserviceType TYPE_EDEFAULT = MicroserviceType.FUNCTIONAL;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected MicroserviceType type = TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVisibility()
     * @generated
     * @ordered
     */
    protected static final Visibility VISIBILITY_EDEFAULT = Visibility.NONE;

    /**
     * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVisibility()
     * @generated
     * @ordered
     */
    protected Visibility visibility = VISIBILITY_EDEFAULT;

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
     * The cached value of the '{@link #getEndpoints() <em>Endpoints</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEndpoints()
     * @generated
     * @ordered
     */
    protected EList<Endpoint> endpoints;

    /**
     * The cached value of the '{@link #getRequiredMicroservices() <em>Required Microservices</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRequiredMicroservices()
     * @generated
     * @ordered
     */
    protected EList<PossiblyImportedMicroservice> requiredMicroservices;

    /**
     * The cached value of the '{@link #getRequiredInterfaces() <em>Required Interfaces</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRequiredInterfaces()
     * @generated
     * @ordered
     */
    protected EList<PossiblyImportedInterface> requiredInterfaces;

    /**
     * The cached value of the '{@link #getRequiredOperations() <em>Required Operations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRequiredOperations()
     * @generated
     * @ordered
     */
    protected EList<PossiblyImportedOperation> requiredOperations;

    /**
     * The cached value of the '{@link #getProtocols() <em>Protocols</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProtocols()
     * @generated
     * @ordered
     */
    protected EList<ProtocolSpecification> protocols;

    /**
     * The cached value of the '{@link #getInterfaces() <em>Interfaces</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInterfaces()
     * @generated
     * @ordered
     */
    protected EList<Interface> interfaces;

    /**
     * The cached value of the '{@link #getAspects() <em>Aspects</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAspects()
     * @generated
     * @ordered
     */
    protected EList<ImportedServiceAspect> aspects;

    /**
     * The default value of the '{@link #isEffectivelyImplemented() <em>Effectively Implemented</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEffectivelyImplemented()
     * @generated
     * @ordered
     */
    protected static final boolean EFFECTIVELY_IMPLEMENTED_EDEFAULT = false;

    /**
     * The default value of the '{@link #getEffectiveVisibility() <em>Effective Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEffectiveVisibility()
     * @generated
     * @ordered
     */
    protected static final Visibility EFFECTIVE_VISIBILITY_EDEFAULT = Visibility.NONE;

    /**
     * The default value of the '{@link #isEffectivelyInternal() <em>Effectively Internal</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEffectivelyInternal()
     * @generated
     * @ordered
     */
    protected static final boolean EFFECTIVELY_INTERNAL_EDEFAULT = false;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MicroserviceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ServicePackage.Literals.MICROSERVICE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MICROSERVICE__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getVersion() {
        return version;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVersion(String newVersion) {
        String oldVersion = version;
        version = newVersion;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MICROSERVICE__VERSION, oldVersion, version));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MicroserviceType getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(MicroserviceType newType) {
        MicroserviceType oldType = type;
        type = newType == null ? TYPE_EDEFAULT : newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MICROSERVICE__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Visibility getVisibility() {
        return visibility;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVisibility(Visibility newVisibility) {
        Visibility oldVisibility = visibility;
        visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MICROSERVICE__VISIBILITY, oldVisibility, visibility));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Import> getTechnologies() {
        if (technologies == null) {
            technologies = new EObjectResolvingEList<Import>(Import.class, this, ServicePackage.MICROSERVICE__TECHNOLOGIES);
        }
        return technologies;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Endpoint> getEndpoints() {
        if (endpoints == null) {
            endpoints = new EObjectContainmentWithInverseEList<Endpoint>(Endpoint.class, this, ServicePackage.MICROSERVICE__ENDPOINTS, ServicePackage.ENDPOINT__MICROSERVICE);
        }
        return endpoints;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PossiblyImportedMicroservice> getRequiredMicroservices() {
        if (requiredMicroservices == null) {
            requiredMicroservices = new EObjectContainmentWithInverseEList<PossiblyImportedMicroservice>(PossiblyImportedMicroservice.class, this, ServicePackage.MICROSERVICE__REQUIRED_MICROSERVICES, ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__REQUIRING_MICROSERVICE);
        }
        return requiredMicroservices;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PossiblyImportedInterface> getRequiredInterfaces() {
        if (requiredInterfaces == null) {
            requiredInterfaces = new EObjectContainmentWithInverseEList<PossiblyImportedInterface>(PossiblyImportedInterface.class, this, ServicePackage.MICROSERVICE__REQUIRED_INTERFACES, ServicePackage.POSSIBLY_IMPORTED_INTERFACE__REQUIRING_MICROSERVICE);
        }
        return requiredInterfaces;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PossiblyImportedOperation> getRequiredOperations() {
        if (requiredOperations == null) {
            requiredOperations = new EObjectContainmentWithInverseEList<PossiblyImportedOperation>(PossiblyImportedOperation.class, this, ServicePackage.MICROSERVICE__REQUIRED_OPERATIONS, ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRING_MICROSERVICE);
        }
        return requiredOperations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ProtocolSpecification> getProtocols() {
        if (protocols == null) {
            protocols = new EObjectContainmentEList<ProtocolSpecification>(ProtocolSpecification.class, this, ServicePackage.MICROSERVICE__PROTOCOLS);
        }
        return protocols;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Interface> getInterfaces() {
        if (interfaces == null) {
            interfaces = new EObjectContainmentWithInverseEList<Interface>(Interface.class, this, ServicePackage.MICROSERVICE__INTERFACES, ServicePackage.INTERFACE__MICROSERVICE);
        }
        return interfaces;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ImportedServiceAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<ImportedServiceAspect>(ImportedServiceAspect.class, this, ServicePackage.MICROSERVICE__ASPECTS, ServicePackage.IMPORTED_SERVICE_ASPECT__MICROSERVICE);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ServiceModel getServiceModel() {
        if (eContainerFeatureID() != ServicePackage.MICROSERVICE__SERVICE_MODEL) return null;
        return (ServiceModel)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ServiceModel basicGetServiceModel() {
        if (eContainerFeatureID() != ServicePackage.MICROSERVICE__SERVICE_MODEL) return null;
        return (ServiceModel)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetServiceModel(ServiceModel newServiceModel, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newServiceModel, ServicePackage.MICROSERVICE__SERVICE_MODEL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setServiceModel(ServiceModel newServiceModel) {
        if (newServiceModel != eInternalContainer() || (eContainerFeatureID() != ServicePackage.MICROSERVICE__SERVICE_MODEL && newServiceModel != null)) {
            if (EcoreUtil.isAncestor(this, newServiceModel))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newServiceModel != null)
                msgs = ((InternalEObject)newServiceModel).eInverseAdd(this, ServicePackage.SERVICE_MODEL__MICROSERVICES, ServiceModel.class, msgs);
            msgs = basicSetServiceModel(newServiceModel, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MICROSERVICE__SERVICE_MODEL, newServiceModel, newServiceModel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isEffectivelyImplemented() {
        final Function1<Interface, Boolean> _function = new Function1<Interface, Boolean>() {
            public Boolean apply(final Interface it) {
                return Boolean.valueOf(it.isEffectivelyImplemented());
            }
        };
        return IterableExtensions.<Interface>exists(this.getInterfaces(), _function);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Visibility getEffectiveVisibility() {
        Visibility _visibility = this.getVisibility();
        boolean _tripleEquals = (_visibility == Visibility.NONE);
        if (_tripleEquals) {
            return Visibility.ARCHITECTURE;
        }
        return this.getVisibility();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isEffectivelyInternal() {
        Visibility _effectiveVisibility = this.getEffectiveVisibility();
        return (_effectiveVisibility == Visibility.INTERNAL);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getQualifiedNameParts() {
        EList<String> _xblockexpression = null;
        {
            if (((this.getName() == null) || this.getName().isEmpty())) {
                return ECollections.<String>asEList(CollectionLiterals.<String>newArrayList());
            }
            final ArrayList<String> nameParts = CollectionLiterals.<String>newArrayList();
            String _version = this.getVersion();
            boolean _tripleNotEquals = (_version != null);
            if (_tripleNotEquals) {
                nameParts.add(this.getVersion());
            }
            CollectionExtensions.<String>addAll(nameParts, this.getName().split("\\."));
            _xblockexpression = ECollections.<String>asEList(nameParts);
        }
        return _xblockexpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Operation> getContainedOperations() {
        EList<Interface> _interfaces = this.getInterfaces();
        boolean _tripleEquals = (_interfaces == null);
        if (_tripleEquals) {
            return ECollections.<Operation>asEList(CollectionLiterals.<Operation>newArrayList());
        }
        final Function1<Interface, Boolean> _function = new Function1<Interface, Boolean>() {
            public Boolean apply(final Interface it) {
                EList<Operation> _operations = it.getOperations();
                return Boolean.valueOf((_operations != null));
            }
        };
        final Function1<Interface, EList<Operation>> _function_1 = new Function1<Interface, EList<Operation>>() {
            public EList<Operation> apply(final Interface it) {
                return it.getOperations();
            }
        };
        return ECollections.<Operation>toEList(Iterables.<Operation>concat(IterableExtensions.<Interface, EList<Operation>>map(IterableExtensions.<Interface>filter(this.getInterfaces(), _function), _function_1)));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ReferredOperation> getContainedReferredOperations() {
        EList<Interface> _interfaces = this.getInterfaces();
        boolean _tripleEquals = (_interfaces == null);
        if (_tripleEquals) {
            return ECollections.<ReferredOperation>asEList(CollectionLiterals.<ReferredOperation>newArrayList());
        }
        final Function1<Interface, Boolean> _function = new Function1<Interface, Boolean>() {
            public Boolean apply(final Interface it) {
                EList<ReferredOperation> _referredOperations = it.getReferredOperations();
                return Boolean.valueOf((_referredOperations != null));
            }
        };
        final Function1<Interface, EList<ReferredOperation>> _function_1 = new Function1<Interface, EList<ReferredOperation>>() {
            public EList<ReferredOperation> apply(final Interface it) {
                return it.getReferredOperations();
            }
        };
        return ECollections.<ReferredOperation>toEList(Iterables.<ReferredOperation>concat(IterableExtensions.<Interface, EList<ReferredOperation>>map(IterableExtensions.<Interface>filter(this.getInterfaces(), _function), _function_1)));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Import> getRequiredImports() {
        final HashSet<Import> imports = CollectionLiterals.<Import>newHashSet();
        if (((this.getRequiredMicroservices() != null) && (!this.getRequiredMicroservices().isEmpty()))) {
            final Function1<PossiblyImportedMicroservice, Boolean> _function = new Function1<PossiblyImportedMicroservice, Boolean>() {
                public Boolean apply(final PossiblyImportedMicroservice it) {
                    Import _import = it.getImport();
                    return Boolean.valueOf((_import != null));
                }
            };
            final Function1<PossiblyImportedMicroservice, Import> _function_1 = new Function1<PossiblyImportedMicroservice, Import>() {
                public Import apply(final PossiblyImportedMicroservice it) {
                    return it.getImport();
                }
            };
            Iterables.<Import>addAll(imports, IterableExtensions.<PossiblyImportedMicroservice, Import>map(IterableExtensions.<PossiblyImportedMicroservice>filter(this.getRequiredMicroservices(), _function), _function_1));
        }
        if (((this.getRequiredInterfaces() != null) && (!this.getRequiredInterfaces().isEmpty()))) {
            final Function1<PossiblyImportedInterface, Boolean> _function_2 = new Function1<PossiblyImportedInterface, Boolean>() {
                public Boolean apply(final PossiblyImportedInterface it) {
                    Import _import = it.getImport();
                    return Boolean.valueOf((_import != null));
                }
            };
            final Function1<PossiblyImportedInterface, Import> _function_3 = new Function1<PossiblyImportedInterface, Import>() {
                public Import apply(final PossiblyImportedInterface it) {
                    return it.getImport();
                }
            };
            Iterables.<Import>addAll(imports, IterableExtensions.<PossiblyImportedInterface, Import>map(IterableExtensions.<PossiblyImportedInterface>filter(this.getRequiredInterfaces(), _function_2), _function_3));
        }
        if (((this.getRequiredOperations() != null) && (!this.getRequiredOperations().isEmpty()))) {
            final Function1<PossiblyImportedOperation, Boolean> _function_4 = new Function1<PossiblyImportedOperation, Boolean>() {
                public Boolean apply(final PossiblyImportedOperation it) {
                    Import _import = it.getImport();
                    return Boolean.valueOf((_import != null));
                }
            };
            final Function1<PossiblyImportedOperation, Import> _function_5 = new Function1<PossiblyImportedOperation, Import>() {
                public Import apply(final PossiblyImportedOperation it) {
                    return it.getImport();
                }
            };
            Iterables.<Import>addAll(imports, IterableExtensions.<PossiblyImportedOperation, Import>map(IterableExtensions.<PossiblyImportedOperation>filter(this.getRequiredOperations(), _function_4), _function_5));
        }
        return ECollections.<Import>asEList(((Import[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(imports, Import.class)));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Operation> getAllRequiredOperations(final Import fromImport) {
        final HashSet<Operation> operations = CollectionLiterals.<Operation>newHashSet();
        if (((this.getRequiredOperations() != null) && (!this.getRequiredOperations().isEmpty()))) {
            final Function1<PossiblyImportedOperation, Boolean> _function = new Function1<PossiblyImportedOperation, Boolean>() {
                public Boolean apply(final PossiblyImportedOperation it) {
                    return Boolean.valueOf((Objects.equal(it.getImport(), fromImport) && 
                        (it.getOperation() != null)));
                }
            };
            final Function1<PossiblyImportedOperation, Operation> _function_1 = new Function1<PossiblyImportedOperation, Operation>() {
                public Operation apply(final PossiblyImportedOperation it) {
                    return it.getOperation();
                }
            };
            Iterables.<Operation>addAll(operations, 
                IterableExtensions.<PossiblyImportedOperation, Operation>map(IterableExtensions.<PossiblyImportedOperation>filter(this.getRequiredOperations(), _function), _function_1));
        }
        if (((this.getRequiredInterfaces() != null) && (!this.getRequiredInterfaces().isEmpty()))) {
            final Function1<PossiblyImportedInterface, Boolean> _function_2 = new Function1<PossiblyImportedInterface, Boolean>() {
                public Boolean apply(final PossiblyImportedInterface it) {
                    return Boolean.valueOf(((Objects.equal(it.getImport(), fromImport) && 
                        (it.getInterface() != null)) && 
                        (it.getInterface().getOperations() != null)));
                }
            };
            final Function1<PossiblyImportedInterface, EList<Operation>> _function_3 = new Function1<PossiblyImportedInterface, EList<Operation>>() {
                public EList<Operation> apply(final PossiblyImportedInterface it) {
                    return it.getInterface().getOperations();
                }
            };
            Iterables.<Operation>addAll(operations, 
                Iterables.<Operation>concat(IterableExtensions.<PossiblyImportedInterface, EList<Operation>>map(IterableExtensions.<PossiblyImportedInterface>filter(this.getRequiredInterfaces(), _function_2), _function_3)));
        }
        if (((this.getRequiredMicroservices() != null) && (!this.getRequiredMicroservices().isEmpty()))) {
            final Function1<PossiblyImportedMicroservice, Boolean> _function_4 = new Function1<PossiblyImportedMicroservice, Boolean>() {
                public Boolean apply(final PossiblyImportedMicroservice it) {
                    return Boolean.valueOf((Objects.equal(it.getImport(), fromImport) && 
                        (it.getMicroservice() != null)));
                }
            };
            final Function1<PossiblyImportedMicroservice, EList<Operation>> _function_5 = new Function1<PossiblyImportedMicroservice, EList<Operation>>() {
                public EList<Operation> apply(final PossiblyImportedMicroservice it) {
                    return it.getMicroservice().getContainedOperations();
                }
            };
            Iterables.<Operation>addAll(operations, 
                Iterables.<Operation>concat(IterableExtensions.<PossiblyImportedMicroservice, EList<Operation>>map(IterableExtensions.<PossiblyImportedMicroservice>filter(this.getRequiredMicroservices(), _function_4), _function_5)));
        }
        return ECollections.<Operation>asEList(((Operation[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(operations, Operation.class)));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Map<Microservice, Import> getAllRequiredMicroservices() {
        final HashMap<Microservice, Import> microservices = CollectionLiterals.<Microservice, Import>newHashMap();
        EList<PossiblyImportedMicroservice> _requiredMicroservices = this.getRequiredMicroservices();
        boolean _tripleNotEquals = (_requiredMicroservices != null);
        if (_tripleNotEquals) {
            final Consumer<PossiblyImportedMicroservice> _function = new Consumer<PossiblyImportedMicroservice>() {
                public void accept(final PossiblyImportedMicroservice it) {
                    microservices.put(it.getMicroservice(), it.getImport());
                }
            };
            this.getRequiredMicroservices().forEach(_function);
        }
        EList<PossiblyImportedInterface> _requiredInterfaces = this.getRequiredInterfaces();
        boolean _tripleNotEquals_1 = (_requiredInterfaces != null);
        if (_tripleNotEquals_1) {
            final Consumer<PossiblyImportedInterface> _function_1 = new Consumer<PossiblyImportedInterface>() {
                public void accept(final PossiblyImportedInterface it) {
                    microservices.put(it.getInterface().getMicroservice(), it.getImport());
                }
            };
            this.getRequiredInterfaces().forEach(_function_1);
        }
        EList<PossiblyImportedOperation> _requiredOperations = this.getRequiredOperations();
        boolean _tripleNotEquals_2 = (_requiredOperations != null);
        if (_tripleNotEquals_2) {
            final Consumer<PossiblyImportedOperation> _function_2 = new Consumer<PossiblyImportedOperation>() {
                public void accept(final PossiblyImportedOperation it) {
                    microservices.put(it.getOperation().getInterface().getMicroservice(), it.getImport());
                }
            };
            this.getRequiredOperations().forEach(_function_2);
        }
        return microservices;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean canRequire(final Microservice microservice, final boolean isImportedService) {
        if ((microservice == null)) {
            return false;
        }
        return ((microservice != this) && ((!isImportedService) || (!microservice.isEffectivelyInternal())));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean canRequire(final Interface iface, final boolean isImportedInterface) {
        if (((iface == null) || (iface.getMicroservice() == null))) {
            return false;
        }
        boolean canRequire = ((!iface.isNotImplemented()) && (!iface.isEffectivelyInternal()));
        if (((this.getInterfaces() != null) && (!this.getInterfaces().isEmpty()))) {
            canRequire = (canRequire && (!this.getInterfaces().contains(iface)));
        }
        return canRequire;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean canRequire(final Operation operation, final boolean isImportedOperation) {
        if ((((operation == null) || (operation.getInterface() == null)) || 
            (operation.getInterface().getMicroservice() == null))) {
            return false;
        }
        boolean canRequire = ((!operation.isEffectivelyNotImplemented()) && (!operation.isEffectivelyInternal()));
        if (((this.getContainedOperations() != null) && (!this.getContainedOperations().isEmpty()))) {
            canRequire = (canRequire && (!this.getContainedOperations().contains(operation)));
        }
        return canRequire;
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
            case ServicePackage.MICROSERVICE__ENDPOINTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getEndpoints()).basicAdd(otherEnd, msgs);
            case ServicePackage.MICROSERVICE__REQUIRED_MICROSERVICES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequiredMicroservices()).basicAdd(otherEnd, msgs);
            case ServicePackage.MICROSERVICE__REQUIRED_INTERFACES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequiredInterfaces()).basicAdd(otherEnd, msgs);
            case ServicePackage.MICROSERVICE__REQUIRED_OPERATIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequiredOperations()).basicAdd(otherEnd, msgs);
            case ServicePackage.MICROSERVICE__INTERFACES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getInterfaces()).basicAdd(otherEnd, msgs);
            case ServicePackage.MICROSERVICE__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case ServicePackage.MICROSERVICE__SERVICE_MODEL:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetServiceModel((ServiceModel)otherEnd, msgs);
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
            case ServicePackage.MICROSERVICE__ENDPOINTS:
                return ((InternalEList<?>)getEndpoints()).basicRemove(otherEnd, msgs);
            case ServicePackage.MICROSERVICE__REQUIRED_MICROSERVICES:
                return ((InternalEList<?>)getRequiredMicroservices()).basicRemove(otherEnd, msgs);
            case ServicePackage.MICROSERVICE__REQUIRED_INTERFACES:
                return ((InternalEList<?>)getRequiredInterfaces()).basicRemove(otherEnd, msgs);
            case ServicePackage.MICROSERVICE__REQUIRED_OPERATIONS:
                return ((InternalEList<?>)getRequiredOperations()).basicRemove(otherEnd, msgs);
            case ServicePackage.MICROSERVICE__PROTOCOLS:
                return ((InternalEList<?>)getProtocols()).basicRemove(otherEnd, msgs);
            case ServicePackage.MICROSERVICE__INTERFACES:
                return ((InternalEList<?>)getInterfaces()).basicRemove(otherEnd, msgs);
            case ServicePackage.MICROSERVICE__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case ServicePackage.MICROSERVICE__SERVICE_MODEL:
                return basicSetServiceModel(null, msgs);
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
            case ServicePackage.MICROSERVICE__SERVICE_MODEL:
                return eInternalContainer().eInverseRemove(this, ServicePackage.SERVICE_MODEL__MICROSERVICES, ServiceModel.class, msgs);
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
            case ServicePackage.MICROSERVICE__NAME:
                return getName();
            case ServicePackage.MICROSERVICE__VERSION:
                return getVersion();
            case ServicePackage.MICROSERVICE__TYPE:
                return getType();
            case ServicePackage.MICROSERVICE__VISIBILITY:
                return getVisibility();
            case ServicePackage.MICROSERVICE__TECHNOLOGIES:
                return getTechnologies();
            case ServicePackage.MICROSERVICE__ENDPOINTS:
                return getEndpoints();
            case ServicePackage.MICROSERVICE__REQUIRED_MICROSERVICES:
                return getRequiredMicroservices();
            case ServicePackage.MICROSERVICE__REQUIRED_INTERFACES:
                return getRequiredInterfaces();
            case ServicePackage.MICROSERVICE__REQUIRED_OPERATIONS:
                return getRequiredOperations();
            case ServicePackage.MICROSERVICE__PROTOCOLS:
                return getProtocols();
            case ServicePackage.MICROSERVICE__INTERFACES:
                return getInterfaces();
            case ServicePackage.MICROSERVICE__ASPECTS:
                return getAspects();
            case ServicePackage.MICROSERVICE__SERVICE_MODEL:
                if (resolve) return getServiceModel();
                return basicGetServiceModel();
            case ServicePackage.MICROSERVICE__EFFECTIVELY_IMPLEMENTED:
                return isEffectivelyImplemented();
            case ServicePackage.MICROSERVICE__EFFECTIVE_VISIBILITY:
                return getEffectiveVisibility();
            case ServicePackage.MICROSERVICE__EFFECTIVELY_INTERNAL:
                return isEffectivelyInternal();
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
            case ServicePackage.MICROSERVICE__NAME:
                setName((String)newValue);
                return;
            case ServicePackage.MICROSERVICE__VERSION:
                setVersion((String)newValue);
                return;
            case ServicePackage.MICROSERVICE__TYPE:
                setType((MicroserviceType)newValue);
                return;
            case ServicePackage.MICROSERVICE__VISIBILITY:
                setVisibility((Visibility)newValue);
                return;
            case ServicePackage.MICROSERVICE__TECHNOLOGIES:
                getTechnologies().clear();
                getTechnologies().addAll((Collection<? extends Import>)newValue);
                return;
            case ServicePackage.MICROSERVICE__ENDPOINTS:
                getEndpoints().clear();
                getEndpoints().addAll((Collection<? extends Endpoint>)newValue);
                return;
            case ServicePackage.MICROSERVICE__REQUIRED_MICROSERVICES:
                getRequiredMicroservices().clear();
                getRequiredMicroservices().addAll((Collection<? extends PossiblyImportedMicroservice>)newValue);
                return;
            case ServicePackage.MICROSERVICE__REQUIRED_INTERFACES:
                getRequiredInterfaces().clear();
                getRequiredInterfaces().addAll((Collection<? extends PossiblyImportedInterface>)newValue);
                return;
            case ServicePackage.MICROSERVICE__REQUIRED_OPERATIONS:
                getRequiredOperations().clear();
                getRequiredOperations().addAll((Collection<? extends PossiblyImportedOperation>)newValue);
                return;
            case ServicePackage.MICROSERVICE__PROTOCOLS:
                getProtocols().clear();
                getProtocols().addAll((Collection<? extends ProtocolSpecification>)newValue);
                return;
            case ServicePackage.MICROSERVICE__INTERFACES:
                getInterfaces().clear();
                getInterfaces().addAll((Collection<? extends Interface>)newValue);
                return;
            case ServicePackage.MICROSERVICE__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends ImportedServiceAspect>)newValue);
                return;
            case ServicePackage.MICROSERVICE__SERVICE_MODEL:
                setServiceModel((ServiceModel)newValue);
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
            case ServicePackage.MICROSERVICE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case ServicePackage.MICROSERVICE__VERSION:
                setVersion(VERSION_EDEFAULT);
                return;
            case ServicePackage.MICROSERVICE__TYPE:
                setType(TYPE_EDEFAULT);
                return;
            case ServicePackage.MICROSERVICE__VISIBILITY:
                setVisibility(VISIBILITY_EDEFAULT);
                return;
            case ServicePackage.MICROSERVICE__TECHNOLOGIES:
                getTechnologies().clear();
                return;
            case ServicePackage.MICROSERVICE__ENDPOINTS:
                getEndpoints().clear();
                return;
            case ServicePackage.MICROSERVICE__REQUIRED_MICROSERVICES:
                getRequiredMicroservices().clear();
                return;
            case ServicePackage.MICROSERVICE__REQUIRED_INTERFACES:
                getRequiredInterfaces().clear();
                return;
            case ServicePackage.MICROSERVICE__REQUIRED_OPERATIONS:
                getRequiredOperations().clear();
                return;
            case ServicePackage.MICROSERVICE__PROTOCOLS:
                getProtocols().clear();
                return;
            case ServicePackage.MICROSERVICE__INTERFACES:
                getInterfaces().clear();
                return;
            case ServicePackage.MICROSERVICE__ASPECTS:
                getAspects().clear();
                return;
            case ServicePackage.MICROSERVICE__SERVICE_MODEL:
                setServiceModel((ServiceModel)null);
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
            case ServicePackage.MICROSERVICE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case ServicePackage.MICROSERVICE__VERSION:
                return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
            case ServicePackage.MICROSERVICE__TYPE:
                return type != TYPE_EDEFAULT;
            case ServicePackage.MICROSERVICE__VISIBILITY:
                return visibility != VISIBILITY_EDEFAULT;
            case ServicePackage.MICROSERVICE__TECHNOLOGIES:
                return technologies != null && !technologies.isEmpty();
            case ServicePackage.MICROSERVICE__ENDPOINTS:
                return endpoints != null && !endpoints.isEmpty();
            case ServicePackage.MICROSERVICE__REQUIRED_MICROSERVICES:
                return requiredMicroservices != null && !requiredMicroservices.isEmpty();
            case ServicePackage.MICROSERVICE__REQUIRED_INTERFACES:
                return requiredInterfaces != null && !requiredInterfaces.isEmpty();
            case ServicePackage.MICROSERVICE__REQUIRED_OPERATIONS:
                return requiredOperations != null && !requiredOperations.isEmpty();
            case ServicePackage.MICROSERVICE__PROTOCOLS:
                return protocols != null && !protocols.isEmpty();
            case ServicePackage.MICROSERVICE__INTERFACES:
                return interfaces != null && !interfaces.isEmpty();
            case ServicePackage.MICROSERVICE__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case ServicePackage.MICROSERVICE__SERVICE_MODEL:
                return basicGetServiceModel() != null;
            case ServicePackage.MICROSERVICE__EFFECTIVELY_IMPLEMENTED:
                return isEffectivelyImplemented() != EFFECTIVELY_IMPLEMENTED_EDEFAULT;
            case ServicePackage.MICROSERVICE__EFFECTIVE_VISIBILITY:
                return getEffectiveVisibility() != EFFECTIVE_VISIBILITY_EDEFAULT;
            case ServicePackage.MICROSERVICE__EFFECTIVELY_INTERNAL:
                return isEffectivelyInternal() != EFFECTIVELY_INTERNAL_EDEFAULT;
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
            case ServicePackage.MICROSERVICE___GET_QUALIFIED_NAME_PARTS:
                return getQualifiedNameParts();
            case ServicePackage.MICROSERVICE___GET_CONTAINED_OPERATIONS:
                return getContainedOperations();
            case ServicePackage.MICROSERVICE___GET_CONTAINED_REFERRED_OPERATIONS:
                return getContainedReferredOperations();
            case ServicePackage.MICROSERVICE___GET_REQUIRED_IMPORTS:
                return getRequiredImports();
            case ServicePackage.MICROSERVICE___GET_ALL_REQUIRED_OPERATIONS__IMPORT:
                return getAllRequiredOperations((Import)arguments.get(0));
            case ServicePackage.MICROSERVICE___GET_ALL_REQUIRED_MICROSERVICES:
                return getAllRequiredMicroservices();
            case ServicePackage.MICROSERVICE___CAN_REQUIRE__MICROSERVICE_BOOLEAN:
                return canRequire((Microservice)arguments.get(0), (Boolean)arguments.get(1));
            case ServicePackage.MICROSERVICE___CAN_REQUIRE__INTERFACE_BOOLEAN:
                return canRequire((Interface)arguments.get(0), (Boolean)arguments.get(1));
            case ServicePackage.MICROSERVICE___CAN_REQUIRE__OPERATION_BOOLEAN:
                return canRequire((Operation)arguments.get(0), (Boolean)arguments.get(1));
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

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(", version: ");
        result.append(version);
        result.append(", type: ");
        result.append(type);
        result.append(", visibility: ");
        result.append(visibility);
        result.append(')');
        return result.toString();
    }

} //MicroserviceImpl
