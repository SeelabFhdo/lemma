/**
 */
package de.fhdo.lemma.service.impl;

import com.google.common.base.Objects;

import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.data.Type;

import de.fhdo.lemma.service.ImportedServiceAspect;
import de.fhdo.lemma.service.ImportedType;
import de.fhdo.lemma.service.MappedField;
import de.fhdo.lemma.service.Microservice;
import de.fhdo.lemma.service.Operation;
import de.fhdo.lemma.service.Parameter;
import de.fhdo.lemma.service.PossiblyImportedOperation;
import de.fhdo.lemma.service.ServicePackage;

import de.fhdo.lemma.technology.CommunicationType;
import de.fhdo.lemma.technology.ExchangePattern;
import de.fhdo.lemma.technology.TechnologySpecificCollectionType;
import de.fhdo.lemma.technology.TechnologySpecificDataStructure;
import de.fhdo.lemma.technology.TechnologySpecificPrimitiveType;

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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.impl.ParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ParameterImpl#getExchangePattern <em>Exchange Pattern</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ParameterImpl#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ParameterImpl#isCommunicatesFault <em>Communicates Fault</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ParameterImpl#isOptional <em>Optional</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ParameterImpl#getInitializedByOperation <em>Initialized By Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ParameterImpl#getImportedType <em>Imported Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ParameterImpl#getPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ParameterImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ParameterImpl#getMappedFields <em>Mapped Fields</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ParameterImpl#getOriginalImportedType <em>Original Imported Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ParameterImpl#getOriginalPrimitiveType <em>Original Primitive Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ParameterImpl#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParameterImpl extends MinimalEObjectImpl.Container implements Parameter {
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
     * The default value of the '{@link #getExchangePattern() <em>Exchange Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExchangePattern()
     * @generated
     * @ordered
     */
    protected static final ExchangePattern EXCHANGE_PATTERN_EDEFAULT = ExchangePattern.IN;

    /**
     * The cached value of the '{@link #getExchangePattern() <em>Exchange Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExchangePattern()
     * @generated
     * @ordered
     */
    protected ExchangePattern exchangePattern = EXCHANGE_PATTERN_EDEFAULT;

    /**
     * The default value of the '{@link #getCommunicationType() <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCommunicationType()
     * @generated
     * @ordered
     */
    protected static final CommunicationType COMMUNICATION_TYPE_EDEFAULT = CommunicationType.SYNCHRONOUS;

    /**
     * The cached value of the '{@link #getCommunicationType() <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCommunicationType()
     * @generated
     * @ordered
     */
    protected CommunicationType communicationType = COMMUNICATION_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #isCommunicatesFault() <em>Communicates Fault</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isCommunicatesFault()
     * @generated
     * @ordered
     */
    protected static final boolean COMMUNICATES_FAULT_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isCommunicatesFault() <em>Communicates Fault</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isCommunicatesFault()
     * @generated
     * @ordered
     */
    protected boolean communicatesFault = COMMUNICATES_FAULT_EDEFAULT;

    /**
     * The default value of the '{@link #isOptional() <em>Optional</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isOptional()
     * @generated
     * @ordered
     */
    protected static final boolean OPTIONAL_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isOptional() <em>Optional</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isOptional()
     * @generated
     * @ordered
     */
    protected boolean optional = OPTIONAL_EDEFAULT;

    /**
     * The cached value of the '{@link #getInitializedByOperation() <em>Initialized By Operation</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInitializedByOperation()
     * @generated
     * @ordered
     */
    protected PossiblyImportedOperation initializedByOperation;

    /**
     * The cached value of the '{@link #getImportedType() <em>Imported Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImportedType()
     * @generated
     * @ordered
     */
    protected ImportedType importedType;

    /**
     * The cached value of the '{@link #getPrimitiveType() <em>Primitive Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrimitiveType()
     * @generated
     * @ordered
     */
    protected PrimitiveType primitiveType;

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
     * The cached value of the '{@link #getMappedFields() <em>Mapped Fields</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMappedFields()
     * @generated
     * @ordered
     */
    protected EList<MappedField> mappedFields;

    /**
     * The cached value of the '{@link #getOriginalImportedType() <em>Original Imported Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOriginalImportedType()
     * @generated
     * @ordered
     */
    protected ImportedType originalImportedType;

    /**
     * The cached value of the '{@link #getOriginalPrimitiveType() <em>Original Primitive Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOriginalPrimitiveType()
     * @generated
     * @ordered
     */
    protected PrimitiveType originalPrimitiveType;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ParameterImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ServicePackage.Literals.PARAMETER;
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
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.PARAMETER__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExchangePattern getExchangePattern() {
        return exchangePattern;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExchangePattern(ExchangePattern newExchangePattern) {
        ExchangePattern oldExchangePattern = exchangePattern;
        exchangePattern = newExchangePattern == null ? EXCHANGE_PATTERN_EDEFAULT : newExchangePattern;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.PARAMETER__EXCHANGE_PATTERN, oldExchangePattern, exchangePattern));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CommunicationType getCommunicationType() {
        return communicationType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCommunicationType(CommunicationType newCommunicationType) {
        CommunicationType oldCommunicationType = communicationType;
        communicationType = newCommunicationType == null ? COMMUNICATION_TYPE_EDEFAULT : newCommunicationType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.PARAMETER__COMMUNICATION_TYPE, oldCommunicationType, communicationType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isCommunicatesFault() {
        return communicatesFault;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCommunicatesFault(boolean newCommunicatesFault) {
        boolean oldCommunicatesFault = communicatesFault;
        communicatesFault = newCommunicatesFault;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.PARAMETER__COMMUNICATES_FAULT, oldCommunicatesFault, communicatesFault));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isOptional() {
        return optional;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOptional(boolean newOptional) {
        boolean oldOptional = optional;
        optional = newOptional;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.PARAMETER__OPTIONAL, oldOptional, optional));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PossiblyImportedOperation getInitializedByOperation() {
        return initializedByOperation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInitializedByOperation(PossiblyImportedOperation newInitializedByOperation, NotificationChain msgs) {
        PossiblyImportedOperation oldInitializedByOperation = initializedByOperation;
        initializedByOperation = newInitializedByOperation;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicePackage.PARAMETER__INITIALIZED_BY_OPERATION, oldInitializedByOperation, newInitializedByOperation);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInitializedByOperation(PossiblyImportedOperation newInitializedByOperation) {
        if (newInitializedByOperation != initializedByOperation) {
            NotificationChain msgs = null;
            if (initializedByOperation != null)
                msgs = ((InternalEObject)initializedByOperation).eInverseRemove(this, ServicePackage.POSSIBLY_IMPORTED_OPERATION__INITIALIZED_PARAMETER, PossiblyImportedOperation.class, msgs);
            if (newInitializedByOperation != null)
                msgs = ((InternalEObject)newInitializedByOperation).eInverseAdd(this, ServicePackage.POSSIBLY_IMPORTED_OPERATION__INITIALIZED_PARAMETER, PossiblyImportedOperation.class, msgs);
            msgs = basicSetInitializedByOperation(newInitializedByOperation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.PARAMETER__INITIALIZED_BY_OPERATION, newInitializedByOperation, newInitializedByOperation));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ImportedType getImportedType() {
        return importedType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetImportedType(ImportedType newImportedType, NotificationChain msgs) {
        ImportedType oldImportedType = importedType;
        importedType = newImportedType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicePackage.PARAMETER__IMPORTED_TYPE, oldImportedType, newImportedType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setImportedType(ImportedType newImportedType) {
        if (newImportedType != importedType) {
            NotificationChain msgs = null;
            if (importedType != null)
                msgs = ((InternalEObject)importedType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicePackage.PARAMETER__IMPORTED_TYPE, null, msgs);
            if (newImportedType != null)
                msgs = ((InternalEObject)newImportedType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServicePackage.PARAMETER__IMPORTED_TYPE, null, msgs);
            msgs = basicSetImportedType(newImportedType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.PARAMETER__IMPORTED_TYPE, newImportedType, newImportedType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveType getPrimitiveType() {
        return primitiveType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPrimitiveType(PrimitiveType newPrimitiveType, NotificationChain msgs) {
        PrimitiveType oldPrimitiveType = primitiveType;
        primitiveType = newPrimitiveType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicePackage.PARAMETER__PRIMITIVE_TYPE, oldPrimitiveType, newPrimitiveType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPrimitiveType(PrimitiveType newPrimitiveType) {
        if (newPrimitiveType != primitiveType) {
            NotificationChain msgs = null;
            if (primitiveType != null)
                msgs = ((InternalEObject)primitiveType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicePackage.PARAMETER__PRIMITIVE_TYPE, null, msgs);
            if (newPrimitiveType != null)
                msgs = ((InternalEObject)newPrimitiveType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServicePackage.PARAMETER__PRIMITIVE_TYPE, null, msgs);
            msgs = basicSetPrimitiveType(newPrimitiveType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.PARAMETER__PRIMITIVE_TYPE, newPrimitiveType, newPrimitiveType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ImportedServiceAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<ImportedServiceAspect>(ImportedServiceAspect.class, this, ServicePackage.PARAMETER__ASPECTS, ServicePackage.IMPORTED_SERVICE_ASPECT__PARAMETER);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<MappedField> getMappedFields() {
        if (mappedFields == null) {
            mappedFields = new EObjectContainmentWithInverseEList<MappedField>(MappedField.class, this, ServicePackage.PARAMETER__MAPPED_FIELDS, ServicePackage.MAPPED_FIELD__PARAMETER);
        }
        return mappedFields;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ImportedType getOriginalImportedType() {
        return originalImportedType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOriginalImportedType(ImportedType newOriginalImportedType, NotificationChain msgs) {
        ImportedType oldOriginalImportedType = originalImportedType;
        originalImportedType = newOriginalImportedType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicePackage.PARAMETER__ORIGINAL_IMPORTED_TYPE, oldOriginalImportedType, newOriginalImportedType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOriginalImportedType(ImportedType newOriginalImportedType) {
        if (newOriginalImportedType != originalImportedType) {
            NotificationChain msgs = null;
            if (originalImportedType != null)
                msgs = ((InternalEObject)originalImportedType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicePackage.PARAMETER__ORIGINAL_IMPORTED_TYPE, null, msgs);
            if (newOriginalImportedType != null)
                msgs = ((InternalEObject)newOriginalImportedType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServicePackage.PARAMETER__ORIGINAL_IMPORTED_TYPE, null, msgs);
            msgs = basicSetOriginalImportedType(newOriginalImportedType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.PARAMETER__ORIGINAL_IMPORTED_TYPE, newOriginalImportedType, newOriginalImportedType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveType getOriginalPrimitiveType() {
        return originalPrimitiveType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOriginalPrimitiveType(PrimitiveType newOriginalPrimitiveType, NotificationChain msgs) {
        PrimitiveType oldOriginalPrimitiveType = originalPrimitiveType;
        originalPrimitiveType = newOriginalPrimitiveType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicePackage.PARAMETER__ORIGINAL_PRIMITIVE_TYPE, oldOriginalPrimitiveType, newOriginalPrimitiveType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOriginalPrimitiveType(PrimitiveType newOriginalPrimitiveType) {
        if (newOriginalPrimitiveType != originalPrimitiveType) {
            NotificationChain msgs = null;
            if (originalPrimitiveType != null)
                msgs = ((InternalEObject)originalPrimitiveType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicePackage.PARAMETER__ORIGINAL_PRIMITIVE_TYPE, null, msgs);
            if (newOriginalPrimitiveType != null)
                msgs = ((InternalEObject)newOriginalPrimitiveType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServicePackage.PARAMETER__ORIGINAL_PRIMITIVE_TYPE, null, msgs);
            msgs = basicSetOriginalPrimitiveType(newOriginalPrimitiveType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.PARAMETER__ORIGINAL_PRIMITIVE_TYPE, newOriginalPrimitiveType, newOriginalPrimitiveType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Operation getOperation() {
        if (eContainerFeatureID() != ServicePackage.PARAMETER__OPERATION) return null;
        return (Operation)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Operation basicGetOperation() {
        if (eContainerFeatureID() != ServicePackage.PARAMETER__OPERATION) return null;
        return (Operation)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOperation(Operation newOperation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOperation, ServicePackage.PARAMETER__OPERATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperation(Operation newOperation) {
        if (newOperation != eInternalContainer() || (eContainerFeatureID() != ServicePackage.PARAMETER__OPERATION && newOperation != null)) {
            if (EcoreUtil.isAncestor(this, newOperation))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOperation != null)
                msgs = ((InternalEObject)newOperation).eInverseAdd(this, ServicePackage.OPERATION__PARAMETERS, Operation.class, msgs);
            msgs = basicSetOperation(newOperation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.PARAMETER__OPERATION, newOperation, newOperation));
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
            final EList<String> nameParts = this.getOperation().getQualifiedNameParts();
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
    public boolean basicallyInitializableBy(final Operation initializingOperation) {
        if ((((this.getOperation() == null) || 
            (this.getOperation().getInterface() == null)) || 
            (this.getOperation().getInterface().getMicroservice() == null))) {
            return false;
        }
        if ((((initializingOperation == null) || 
            (initializingOperation.getInterface() == null)) || 
            (initializingOperation.getInterface().getMicroservice() == null))) {
            return false;
        }
        if (((this.getExchangePattern() != ExchangePattern.IN) && 
            (this.getExchangePattern() != ExchangePattern.INOUT))) {
            return false;
        }
        Operation _operation = this.getOperation();
        boolean _equals = Objects.equal(initializingOperation, _operation);
        if (_equals) {
            return false;
        }
        boolean _isEffectivelyNotImplemented = initializingOperation.isEffectivelyNotImplemented();
        if (_isEffectivelyNotImplemented) {
            return false;
        }
        final Microservice thisMicroservice = this.getOperation().getInterface().getMicroservice();
        final Microservice initializingMicroservice = initializingOperation.getInterface().getMicroservice();
        final boolean initializingOperationFromSameMicroservice = Objects.equal(thisMicroservice, initializingMicroservice);
        if ((initializingOperation.isEffectivelyInternal() && (!initializingOperationFromSameMicroservice))) {
            return false;
        }
        final Function1<Parameter, Boolean> _function = new Function1<Parameter, Boolean>() {
            public Boolean apply(final Parameter it) {
                return Boolean.valueOf(((it.getExchangePattern() == ExchangePattern.INOUT) || 
                    (it.getExchangePattern() == ExchangePattern.OUT)));
            }
        };
        final boolean operationHasOutgoingParameters = IterableExtensions.<Parameter>exists(initializingOperation.getParameters(), _function);
        if ((!operationHasOutgoingParameters)) {
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Type getEffectiveType() {
        PrimitiveType _primitiveType = this.getPrimitiveType();
        boolean _tripleNotEquals = (_primitiveType != null);
        if (_tripleNotEquals) {
            return this.getPrimitiveType();
        }
        else {
            if (((this.getImportedType() != null) && (this.getImportedType().getType() != null))) {
                return this.getImportedType().getType();
            }
            else {
                return null;
            }
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isTechnologySpecificEffectiveType() {
        final Type effectiveType = this.getEffectiveType();
        if ((effectiveType == null)) {
            return false;
        }
        return (((effectiveType instanceof TechnologySpecificDataStructure) || 
            (effectiveType instanceof TechnologySpecificCollectionType)) || 
            (effectiveType instanceof TechnologySpecificPrimitiveType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getEffectiveTypeQualifiedNameParts() {
        final Type effectiveType = this.getEffectiveType();
        if ((effectiveType == null)) {
            return null;
        }
        else {
            if ((effectiveType instanceof TechnologySpecificPrimitiveType)) {
                return ((TechnologySpecificPrimitiveType)effectiveType).getQualifiedNameParts();
            }
            else {
                if ((effectiveType instanceof PrimitiveType)) {
                    final ArrayList<String> qualifiedNameParts = CollectionLiterals.<String>newArrayList();
                    qualifiedNameParts.add(((PrimitiveType)effectiveType).getTypeName());
                    return ECollections.<String>asEList(qualifiedNameParts);
                }
                else {
                    if ((effectiveType instanceof ComplexType)) {
                        return ((ComplexType)effectiveType).getQualifiedNameParts();
                    }
                }
            }
        }
        return null;
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
            case ServicePackage.PARAMETER__INITIALIZED_BY_OPERATION:
                if (initializedByOperation != null)
                    msgs = ((InternalEObject)initializedByOperation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicePackage.PARAMETER__INITIALIZED_BY_OPERATION, null, msgs);
                return basicSetInitializedByOperation((PossiblyImportedOperation)otherEnd, msgs);
            case ServicePackage.PARAMETER__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case ServicePackage.PARAMETER__MAPPED_FIELDS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getMappedFields()).basicAdd(otherEnd, msgs);
            case ServicePackage.PARAMETER__OPERATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOperation((Operation)otherEnd, msgs);
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
            case ServicePackage.PARAMETER__INITIALIZED_BY_OPERATION:
                return basicSetInitializedByOperation(null, msgs);
            case ServicePackage.PARAMETER__IMPORTED_TYPE:
                return basicSetImportedType(null, msgs);
            case ServicePackage.PARAMETER__PRIMITIVE_TYPE:
                return basicSetPrimitiveType(null, msgs);
            case ServicePackage.PARAMETER__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case ServicePackage.PARAMETER__MAPPED_FIELDS:
                return ((InternalEList<?>)getMappedFields()).basicRemove(otherEnd, msgs);
            case ServicePackage.PARAMETER__ORIGINAL_IMPORTED_TYPE:
                return basicSetOriginalImportedType(null, msgs);
            case ServicePackage.PARAMETER__ORIGINAL_PRIMITIVE_TYPE:
                return basicSetOriginalPrimitiveType(null, msgs);
            case ServicePackage.PARAMETER__OPERATION:
                return basicSetOperation(null, msgs);
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
            case ServicePackage.PARAMETER__OPERATION:
                return eInternalContainer().eInverseRemove(this, ServicePackage.OPERATION__PARAMETERS, Operation.class, msgs);
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
            case ServicePackage.PARAMETER__NAME:
                return getName();
            case ServicePackage.PARAMETER__EXCHANGE_PATTERN:
                return getExchangePattern();
            case ServicePackage.PARAMETER__COMMUNICATION_TYPE:
                return getCommunicationType();
            case ServicePackage.PARAMETER__COMMUNICATES_FAULT:
                return isCommunicatesFault();
            case ServicePackage.PARAMETER__OPTIONAL:
                return isOptional();
            case ServicePackage.PARAMETER__INITIALIZED_BY_OPERATION:
                return getInitializedByOperation();
            case ServicePackage.PARAMETER__IMPORTED_TYPE:
                return getImportedType();
            case ServicePackage.PARAMETER__PRIMITIVE_TYPE:
                return getPrimitiveType();
            case ServicePackage.PARAMETER__ASPECTS:
                return getAspects();
            case ServicePackage.PARAMETER__MAPPED_FIELDS:
                return getMappedFields();
            case ServicePackage.PARAMETER__ORIGINAL_IMPORTED_TYPE:
                return getOriginalImportedType();
            case ServicePackage.PARAMETER__ORIGINAL_PRIMITIVE_TYPE:
                return getOriginalPrimitiveType();
            case ServicePackage.PARAMETER__OPERATION:
                if (resolve) return getOperation();
                return basicGetOperation();
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
            case ServicePackage.PARAMETER__NAME:
                setName((String)newValue);
                return;
            case ServicePackage.PARAMETER__EXCHANGE_PATTERN:
                setExchangePattern((ExchangePattern)newValue);
                return;
            case ServicePackage.PARAMETER__COMMUNICATION_TYPE:
                setCommunicationType((CommunicationType)newValue);
                return;
            case ServicePackage.PARAMETER__COMMUNICATES_FAULT:
                setCommunicatesFault((Boolean)newValue);
                return;
            case ServicePackage.PARAMETER__OPTIONAL:
                setOptional((Boolean)newValue);
                return;
            case ServicePackage.PARAMETER__INITIALIZED_BY_OPERATION:
                setInitializedByOperation((PossiblyImportedOperation)newValue);
                return;
            case ServicePackage.PARAMETER__IMPORTED_TYPE:
                setImportedType((ImportedType)newValue);
                return;
            case ServicePackage.PARAMETER__PRIMITIVE_TYPE:
                setPrimitiveType((PrimitiveType)newValue);
                return;
            case ServicePackage.PARAMETER__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends ImportedServiceAspect>)newValue);
                return;
            case ServicePackage.PARAMETER__MAPPED_FIELDS:
                getMappedFields().clear();
                getMappedFields().addAll((Collection<? extends MappedField>)newValue);
                return;
            case ServicePackage.PARAMETER__ORIGINAL_IMPORTED_TYPE:
                setOriginalImportedType((ImportedType)newValue);
                return;
            case ServicePackage.PARAMETER__ORIGINAL_PRIMITIVE_TYPE:
                setOriginalPrimitiveType((PrimitiveType)newValue);
                return;
            case ServicePackage.PARAMETER__OPERATION:
                setOperation((Operation)newValue);
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
            case ServicePackage.PARAMETER__NAME:
                setName(NAME_EDEFAULT);
                return;
            case ServicePackage.PARAMETER__EXCHANGE_PATTERN:
                setExchangePattern(EXCHANGE_PATTERN_EDEFAULT);
                return;
            case ServicePackage.PARAMETER__COMMUNICATION_TYPE:
                setCommunicationType(COMMUNICATION_TYPE_EDEFAULT);
                return;
            case ServicePackage.PARAMETER__COMMUNICATES_FAULT:
                setCommunicatesFault(COMMUNICATES_FAULT_EDEFAULT);
                return;
            case ServicePackage.PARAMETER__OPTIONAL:
                setOptional(OPTIONAL_EDEFAULT);
                return;
            case ServicePackage.PARAMETER__INITIALIZED_BY_OPERATION:
                setInitializedByOperation((PossiblyImportedOperation)null);
                return;
            case ServicePackage.PARAMETER__IMPORTED_TYPE:
                setImportedType((ImportedType)null);
                return;
            case ServicePackage.PARAMETER__PRIMITIVE_TYPE:
                setPrimitiveType((PrimitiveType)null);
                return;
            case ServicePackage.PARAMETER__ASPECTS:
                getAspects().clear();
                return;
            case ServicePackage.PARAMETER__MAPPED_FIELDS:
                getMappedFields().clear();
                return;
            case ServicePackage.PARAMETER__ORIGINAL_IMPORTED_TYPE:
                setOriginalImportedType((ImportedType)null);
                return;
            case ServicePackage.PARAMETER__ORIGINAL_PRIMITIVE_TYPE:
                setOriginalPrimitiveType((PrimitiveType)null);
                return;
            case ServicePackage.PARAMETER__OPERATION:
                setOperation((Operation)null);
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
            case ServicePackage.PARAMETER__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case ServicePackage.PARAMETER__EXCHANGE_PATTERN:
                return exchangePattern != EXCHANGE_PATTERN_EDEFAULT;
            case ServicePackage.PARAMETER__COMMUNICATION_TYPE:
                return communicationType != COMMUNICATION_TYPE_EDEFAULT;
            case ServicePackage.PARAMETER__COMMUNICATES_FAULT:
                return communicatesFault != COMMUNICATES_FAULT_EDEFAULT;
            case ServicePackage.PARAMETER__OPTIONAL:
                return optional != OPTIONAL_EDEFAULT;
            case ServicePackage.PARAMETER__INITIALIZED_BY_OPERATION:
                return initializedByOperation != null;
            case ServicePackage.PARAMETER__IMPORTED_TYPE:
                return importedType != null;
            case ServicePackage.PARAMETER__PRIMITIVE_TYPE:
                return primitiveType != null;
            case ServicePackage.PARAMETER__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case ServicePackage.PARAMETER__MAPPED_FIELDS:
                return mappedFields != null && !mappedFields.isEmpty();
            case ServicePackage.PARAMETER__ORIGINAL_IMPORTED_TYPE:
                return originalImportedType != null;
            case ServicePackage.PARAMETER__ORIGINAL_PRIMITIVE_TYPE:
                return originalPrimitiveType != null;
            case ServicePackage.PARAMETER__OPERATION:
                return basicGetOperation() != null;
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
            case ServicePackage.PARAMETER___GET_QUALIFIED_NAME_PARTS:
                return getQualifiedNameParts();
            case ServicePackage.PARAMETER___BUILD_QUALIFIED_NAME__STRING:
                return buildQualifiedName((String)arguments.get(0));
            case ServicePackage.PARAMETER___BASICALLY_INITIALIZABLE_BY__OPERATION:
                return basicallyInitializableBy((Operation)arguments.get(0));
            case ServicePackage.PARAMETER___GET_EFFECTIVE_TYPE:
                return getEffectiveType();
            case ServicePackage.PARAMETER___IS_TECHNOLOGY_SPECIFIC_EFFECTIVE_TYPE:
                return isTechnologySpecificEffectiveType();
            case ServicePackage.PARAMETER___GET_EFFECTIVE_TYPE_QUALIFIED_NAME_PARTS:
                return getEffectiveTypeQualifiedNameParts();
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
        result.append(", exchangePattern: ");
        result.append(exchangePattern);
        result.append(", communicationType: ");
        result.append(communicationType);
        result.append(", communicatesFault: ");
        result.append(communicatesFault);
        result.append(", optional: ");
        result.append(optional);
        result.append(')');
        return result.toString();
    }

} //ParameterImpl
