/**
 */
package de.fhdo.lemma.service.impl;

import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.Type;

import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.ImportedServiceAspect;
import de.fhdo.lemma.service.ImportedType;
import de.fhdo.lemma.service.MappedComplexType;
import de.fhdo.lemma.service.MappedDataOperation;
import de.fhdo.lemma.service.MappedField;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.service.ServicePackage;
import de.fhdo.lemma.service.TechnologyReference;

import de.fhdo.lemma.technology.Technology;

import de.fhdo.lemma.utils.LemmaUtils;

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

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapped Complex Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedComplexTypeImpl#getT_sourceModelUri <em>Tsource Model Uri</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedComplexTypeImpl#getT_typeDefinitionTechnologyImport <em>Ttype Definition Technology Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedComplexTypeImpl#getT_typeDefinitionTechnology <em>Ttype Definition Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedComplexTypeImpl#getTechnologyReferences <em>Technology References</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedComplexTypeImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedComplexTypeImpl#getMappedFields <em>Mapped Fields</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedComplexTypeImpl#getMappedOperations <em>Mapped Operations</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedComplexTypeImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedComplexTypeImpl#getServiceModel <em>Service Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappedComplexTypeImpl extends MinimalEObjectImpl.Container implements MappedComplexType {
    /**
     * The default value of the '{@link #getT_sourceModelUri() <em>Tsource Model Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getT_sourceModelUri()
     * @generated
     * @ordered
     */
    protected static final String TSOURCE_MODEL_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getT_sourceModelUri() <em>Tsource Model Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getT_sourceModelUri()
     * @generated
     * @ordered
     */
    protected String t_sourceModelUri = TSOURCE_MODEL_URI_EDEFAULT;

    /**
     * The cached value of the '{@link #getT_typeDefinitionTechnologyImport() <em>Ttype Definition Technology Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getT_typeDefinitionTechnologyImport()
     * @generated
     * @ordered
     */
    protected Import t_typeDefinitionTechnologyImport;

    /**
     * The cached value of the '{@link #getT_typeDefinitionTechnology() <em>Ttype Definition Technology</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getT_typeDefinitionTechnology()
     * @generated
     * @ordered
     */
    protected Technology t_typeDefinitionTechnology;

    /**
     * The cached value of the '{@link #getTechnologyReferences() <em>Technology References</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTechnologyReferences()
     * @generated
     * @ordered
     */
    protected EList<TechnologyReference> technologyReferences;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected ImportedType type;

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
     * The cached value of the '{@link #getMappedOperations() <em>Mapped Operations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMappedOperations()
     * @generated
     * @ordered
     */
    protected EList<MappedDataOperation> mappedOperations;

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MappedComplexTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ServicePackage.Literals.MAPPED_COMPLEX_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getT_sourceModelUri() {
        return t_sourceModelUri;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setT_sourceModelUri(String newT_sourceModelUri) {
        String oldT_sourceModelUri = t_sourceModelUri;
        t_sourceModelUri = newT_sourceModelUri;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_COMPLEX_TYPE__TSOURCE_MODEL_URI, oldT_sourceModelUri, t_sourceModelUri));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Import getT_typeDefinitionTechnologyImport() {
        if (t_typeDefinitionTechnologyImport != null && t_typeDefinitionTechnologyImport.eIsProxy()) {
            InternalEObject oldT_typeDefinitionTechnologyImport = (InternalEObject)t_typeDefinitionTechnologyImport;
            t_typeDefinitionTechnologyImport = (Import)eResolveProxy(oldT_typeDefinitionTechnologyImport);
            if (t_typeDefinitionTechnologyImport != oldT_typeDefinitionTechnologyImport) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicePackage.MAPPED_COMPLEX_TYPE__TTYPE_DEFINITION_TECHNOLOGY_IMPORT, oldT_typeDefinitionTechnologyImport, t_typeDefinitionTechnologyImport));
            }
        }
        return t_typeDefinitionTechnologyImport;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Import basicGetT_typeDefinitionTechnologyImport() {
        return t_typeDefinitionTechnologyImport;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setT_typeDefinitionTechnologyImport(Import newT_typeDefinitionTechnologyImport) {
        Import oldT_typeDefinitionTechnologyImport = t_typeDefinitionTechnologyImport;
        t_typeDefinitionTechnologyImport = newT_typeDefinitionTechnologyImport;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_COMPLEX_TYPE__TTYPE_DEFINITION_TECHNOLOGY_IMPORT, oldT_typeDefinitionTechnologyImport, t_typeDefinitionTechnologyImport));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Technology getT_typeDefinitionTechnology() {
        if (t_typeDefinitionTechnology != null && t_typeDefinitionTechnology.eIsProxy()) {
            InternalEObject oldT_typeDefinitionTechnology = (InternalEObject)t_typeDefinitionTechnology;
            t_typeDefinitionTechnology = (Technology)eResolveProxy(oldT_typeDefinitionTechnology);
            if (t_typeDefinitionTechnology != oldT_typeDefinitionTechnology) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicePackage.MAPPED_COMPLEX_TYPE__TTYPE_DEFINITION_TECHNOLOGY, oldT_typeDefinitionTechnology, t_typeDefinitionTechnology));
            }
        }
        return t_typeDefinitionTechnology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Technology basicGetT_typeDefinitionTechnology() {
        return t_typeDefinitionTechnology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setT_typeDefinitionTechnology(Technology newT_typeDefinitionTechnology) {
        Technology oldT_typeDefinitionTechnology = t_typeDefinitionTechnology;
        t_typeDefinitionTechnology = newT_typeDefinitionTechnology;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_COMPLEX_TYPE__TTYPE_DEFINITION_TECHNOLOGY, oldT_typeDefinitionTechnology, t_typeDefinitionTechnology));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TechnologyReference> getTechnologyReferences() {
        if (technologyReferences == null) {
            technologyReferences = new EObjectContainmentWithInverseEList<TechnologyReference>(TechnologyReference.class, this, ServicePackage.MAPPED_COMPLEX_TYPE__TECHNOLOGY_REFERENCES, ServicePackage.TECHNOLOGY_REFERENCE__MAPPED_COMPLEX_TYPE);
        }
        return technologyReferences;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ImportedType getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetType(ImportedType newType, NotificationChain msgs) {
        ImportedType oldType = type;
        type = newType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_COMPLEX_TYPE__TYPE, oldType, newType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(ImportedType newType) {
        if (newType != type) {
            NotificationChain msgs = null;
            if (type != null)
                msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicePackage.MAPPED_COMPLEX_TYPE__TYPE, null, msgs);
            if (newType != null)
                msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServicePackage.MAPPED_COMPLEX_TYPE__TYPE, null, msgs);
            msgs = basicSetType(newType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_COMPLEX_TYPE__TYPE, newType, newType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<MappedField> getMappedFields() {
        if (mappedFields == null) {
            mappedFields = new EObjectContainmentWithInverseEList<MappedField>(MappedField.class, this, ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_FIELDS, ServicePackage.MAPPED_FIELD__MAPPED_COMPLEX_TYPE);
        }
        return mappedFields;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<MappedDataOperation> getMappedOperations() {
        if (mappedOperations == null) {
            mappedOperations = new EObjectContainmentWithInverseEList<MappedDataOperation>(MappedDataOperation.class, this, ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_OPERATIONS, ServicePackage.MAPPED_DATA_OPERATION__MAPPED_COMPLEX_TYPE);
        }
        return mappedOperations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ImportedServiceAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<ImportedServiceAspect>(ImportedServiceAspect.class, this, ServicePackage.MAPPED_COMPLEX_TYPE__ASPECTS, ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_COMPLEX_TYPE);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ServiceModel getServiceModel() {
        if (eContainerFeatureID() != ServicePackage.MAPPED_COMPLEX_TYPE__SERVICE_MODEL) return null;
        return (ServiceModel)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ServiceModel basicGetServiceModel() {
        if (eContainerFeatureID() != ServicePackage.MAPPED_COMPLEX_TYPE__SERVICE_MODEL) return null;
        return (ServiceModel)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetServiceModel(ServiceModel newServiceModel, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newServiceModel, ServicePackage.MAPPED_COMPLEX_TYPE__SERVICE_MODEL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setServiceModel(ServiceModel newServiceModel) {
        if (newServiceModel != eInternalContainer() || (eContainerFeatureID() != ServicePackage.MAPPED_COMPLEX_TYPE__SERVICE_MODEL && newServiceModel != null)) {
            if (EcoreUtil.isAncestor(this, newServiceModel))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newServiceModel != null)
                msgs = ((InternalEObject)newServiceModel).eInverseAdd(this, ServicePackage.SERVICE_MODEL__MAPPED_COMPLEX_TYPES, ServiceModel.class, msgs);
            msgs = basicSetServiceModel(newServiceModel, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_COMPLEX_TYPE__SERVICE_MODEL, newServiceModel, newServiceModel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getQualifiedNameParts(final boolean withImportName) {
        EList<String> _xblockexpression = null;
        {
            ImportedType _type = this.getType();
            Import _import = null;
            if (_type!=null) {
                _import=_type.getImport();
            }
            String _name = null;
            if (_import!=null) {
                _name=_import.getName();
            }
            final String importName = _name;
            if ((importName == null)) {
                return ECollections.<String>asEList(CollectionLiterals.<String>newArrayList());
            }
            ImportedType _type_1 = this.getType();
            Type _type_2 = null;
            if (_type_1!=null) {
                _type_2=_type_1.getType();
            }
            final EList<String> typeNameParts = ((ComplexType) _type_2).getQualifiedNameParts();
            if ((typeNameParts == null)) {
                return ECollections.<String>asEList(CollectionLiterals.<String>newArrayList());
            }
            ArrayList<String> _xifexpression = null;
            if (withImportName) {
                _xifexpression = CollectionLiterals.<String>newArrayList(importName);
            }
            else {
                _xifexpression = CollectionLiterals.<String>newArrayList();
            }
            final ArrayList<String> nameParts = _xifexpression;
            nameParts.addAll(typeNameParts);
            _xblockexpression = ECollections.<String>asEList(nameParts);
        }
        return _xblockexpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String buildQualifiedName(final String separator, final boolean withImportName) {
        if ((separator == null)) {
            return null;
        }
        String qualifiedName = "";
        EList<String> _qualifiedNameParts = this.getQualifiedNameParts(withImportName);
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
    public EList<TechnologyReference> getAllTypeDefinitionTechnologyReferences() {
        final Function1<TechnologyReference, Boolean> _function = new Function1<TechnologyReference, Boolean>() {
            public Boolean apply(final TechnologyReference it) {
                boolean _xblockexpression = false;
                {
                    final Resource resource = it.getTechnology().eResource();
                    final String importURI = it.getTechnology().getImportURI();
                    final Technology technologyModel = LemmaUtils.<Technology>getImportedModelRoot(resource, importURI, Technology.class);
                    _xblockexpression = (((!technologyModel.getPrimitiveTypes().isEmpty()) || 
                        (!technologyModel.getCollectionTypes().isEmpty())) || 
                        (!technologyModel.getDataStructures().isEmpty()));
                }
                return Boolean.valueOf(_xblockexpression);
            }
        };
        return ECollections.<TechnologyReference>toEList(IterableExtensions.<TechnologyReference>filter(this.getTechnologyReferences(), _function));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Import getTypeDefinitionTechnologyImport() {
        final Function1<TechnologyReference, Boolean> _function = new Function1<TechnologyReference, Boolean>() {
            public Boolean apply(final TechnologyReference it) {
                return Boolean.valueOf(it.isIsTypeDefinitionTechnology());
            }
        };
        TechnologyReference _findFirst = IterableExtensions.<TechnologyReference>findFirst(this.getTechnologyReferences(), _function);
        Import _technology = null;
        if (_findFirst!=null) {
            _technology=_findFirst.getTechnology();
        }
        final Import explicitTypeDefinitionTechnologyImport = _technology;
        if ((explicitTypeDefinitionTechnologyImport != null)) {
            return explicitTypeDefinitionTechnologyImport;
        }
        final EList<TechnologyReference> allTypeDefinitionTechnologyReferences = this.getAllTypeDefinitionTechnologyReferences();
        Import _xifexpression = null;
        boolean _isEmpty = allTypeDefinitionTechnologyReferences.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
            _xifexpression = allTypeDefinitionTechnologyReferences.get(0).getTechnology();
        }
        else {
            _xifexpression = null;
        }
        return _xifexpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Technology getTypeDefinitionTechnology() {
        final Import typeDefinitionTechnologyImport = this.getTypeDefinitionTechnologyImport();
        Technology _xifexpression = null;
        if ((typeDefinitionTechnologyImport != null)) {
            _xifexpression = LemmaUtils.<Technology>getImportedModelRoot(
                typeDefinitionTechnologyImport.eResource(), 
                typeDefinitionTechnologyImport.getImportURI(), 
                Technology.class);
        }
        else {
            _xifexpression = null;
        }
        return _xifexpression;
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
            case ServicePackage.MAPPED_COMPLEX_TYPE__TECHNOLOGY_REFERENCES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getTechnologyReferences()).basicAdd(otherEnd, msgs);
            case ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_FIELDS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getMappedFields()).basicAdd(otherEnd, msgs);
            case ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_OPERATIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getMappedOperations()).basicAdd(otherEnd, msgs);
            case ServicePackage.MAPPED_COMPLEX_TYPE__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case ServicePackage.MAPPED_COMPLEX_TYPE__SERVICE_MODEL:
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
            case ServicePackage.MAPPED_COMPLEX_TYPE__TECHNOLOGY_REFERENCES:
                return ((InternalEList<?>)getTechnologyReferences()).basicRemove(otherEnd, msgs);
            case ServicePackage.MAPPED_COMPLEX_TYPE__TYPE:
                return basicSetType(null, msgs);
            case ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_FIELDS:
                return ((InternalEList<?>)getMappedFields()).basicRemove(otherEnd, msgs);
            case ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_OPERATIONS:
                return ((InternalEList<?>)getMappedOperations()).basicRemove(otherEnd, msgs);
            case ServicePackage.MAPPED_COMPLEX_TYPE__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case ServicePackage.MAPPED_COMPLEX_TYPE__SERVICE_MODEL:
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
            case ServicePackage.MAPPED_COMPLEX_TYPE__SERVICE_MODEL:
                return eInternalContainer().eInverseRemove(this, ServicePackage.SERVICE_MODEL__MAPPED_COMPLEX_TYPES, ServiceModel.class, msgs);
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
            case ServicePackage.MAPPED_COMPLEX_TYPE__TSOURCE_MODEL_URI:
                return getT_sourceModelUri();
            case ServicePackage.MAPPED_COMPLEX_TYPE__TTYPE_DEFINITION_TECHNOLOGY_IMPORT:
                if (resolve) return getT_typeDefinitionTechnologyImport();
                return basicGetT_typeDefinitionTechnologyImport();
            case ServicePackage.MAPPED_COMPLEX_TYPE__TTYPE_DEFINITION_TECHNOLOGY:
                if (resolve) return getT_typeDefinitionTechnology();
                return basicGetT_typeDefinitionTechnology();
            case ServicePackage.MAPPED_COMPLEX_TYPE__TECHNOLOGY_REFERENCES:
                return getTechnologyReferences();
            case ServicePackage.MAPPED_COMPLEX_TYPE__TYPE:
                return getType();
            case ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_FIELDS:
                return getMappedFields();
            case ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_OPERATIONS:
                return getMappedOperations();
            case ServicePackage.MAPPED_COMPLEX_TYPE__ASPECTS:
                return getAspects();
            case ServicePackage.MAPPED_COMPLEX_TYPE__SERVICE_MODEL:
                if (resolve) return getServiceModel();
                return basicGetServiceModel();
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
            case ServicePackage.MAPPED_COMPLEX_TYPE__TSOURCE_MODEL_URI:
                setT_sourceModelUri((String)newValue);
                return;
            case ServicePackage.MAPPED_COMPLEX_TYPE__TTYPE_DEFINITION_TECHNOLOGY_IMPORT:
                setT_typeDefinitionTechnologyImport((Import)newValue);
                return;
            case ServicePackage.MAPPED_COMPLEX_TYPE__TTYPE_DEFINITION_TECHNOLOGY:
                setT_typeDefinitionTechnology((Technology)newValue);
                return;
            case ServicePackage.MAPPED_COMPLEX_TYPE__TECHNOLOGY_REFERENCES:
                getTechnologyReferences().clear();
                getTechnologyReferences().addAll((Collection<? extends TechnologyReference>)newValue);
                return;
            case ServicePackage.MAPPED_COMPLEX_TYPE__TYPE:
                setType((ImportedType)newValue);
                return;
            case ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_FIELDS:
                getMappedFields().clear();
                getMappedFields().addAll((Collection<? extends MappedField>)newValue);
                return;
            case ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_OPERATIONS:
                getMappedOperations().clear();
                getMappedOperations().addAll((Collection<? extends MappedDataOperation>)newValue);
                return;
            case ServicePackage.MAPPED_COMPLEX_TYPE__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends ImportedServiceAspect>)newValue);
                return;
            case ServicePackage.MAPPED_COMPLEX_TYPE__SERVICE_MODEL:
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
            case ServicePackage.MAPPED_COMPLEX_TYPE__TSOURCE_MODEL_URI:
                setT_sourceModelUri(TSOURCE_MODEL_URI_EDEFAULT);
                return;
            case ServicePackage.MAPPED_COMPLEX_TYPE__TTYPE_DEFINITION_TECHNOLOGY_IMPORT:
                setT_typeDefinitionTechnologyImport((Import)null);
                return;
            case ServicePackage.MAPPED_COMPLEX_TYPE__TTYPE_DEFINITION_TECHNOLOGY:
                setT_typeDefinitionTechnology((Technology)null);
                return;
            case ServicePackage.MAPPED_COMPLEX_TYPE__TECHNOLOGY_REFERENCES:
                getTechnologyReferences().clear();
                return;
            case ServicePackage.MAPPED_COMPLEX_TYPE__TYPE:
                setType((ImportedType)null);
                return;
            case ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_FIELDS:
                getMappedFields().clear();
                return;
            case ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_OPERATIONS:
                getMappedOperations().clear();
                return;
            case ServicePackage.MAPPED_COMPLEX_TYPE__ASPECTS:
                getAspects().clear();
                return;
            case ServicePackage.MAPPED_COMPLEX_TYPE__SERVICE_MODEL:
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
            case ServicePackage.MAPPED_COMPLEX_TYPE__TSOURCE_MODEL_URI:
                return TSOURCE_MODEL_URI_EDEFAULT == null ? t_sourceModelUri != null : !TSOURCE_MODEL_URI_EDEFAULT.equals(t_sourceModelUri);
            case ServicePackage.MAPPED_COMPLEX_TYPE__TTYPE_DEFINITION_TECHNOLOGY_IMPORT:
                return t_typeDefinitionTechnologyImport != null;
            case ServicePackage.MAPPED_COMPLEX_TYPE__TTYPE_DEFINITION_TECHNOLOGY:
                return t_typeDefinitionTechnology != null;
            case ServicePackage.MAPPED_COMPLEX_TYPE__TECHNOLOGY_REFERENCES:
                return technologyReferences != null && !technologyReferences.isEmpty();
            case ServicePackage.MAPPED_COMPLEX_TYPE__TYPE:
                return type != null;
            case ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_FIELDS:
                return mappedFields != null && !mappedFields.isEmpty();
            case ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_OPERATIONS:
                return mappedOperations != null && !mappedOperations.isEmpty();
            case ServicePackage.MAPPED_COMPLEX_TYPE__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case ServicePackage.MAPPED_COMPLEX_TYPE__SERVICE_MODEL:
                return basicGetServiceModel() != null;
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
            case ServicePackage.MAPPED_COMPLEX_TYPE___GET_QUALIFIED_NAME_PARTS__BOOLEAN:
                return getQualifiedNameParts((Boolean)arguments.get(0));
            case ServicePackage.MAPPED_COMPLEX_TYPE___BUILD_QUALIFIED_NAME__STRING_BOOLEAN:
                return buildQualifiedName((String)arguments.get(0), (Boolean)arguments.get(1));
            case ServicePackage.MAPPED_COMPLEX_TYPE___GET_ALL_TYPE_DEFINITION_TECHNOLOGY_REFERENCES:
                return getAllTypeDefinitionTechnologyReferences();
            case ServicePackage.MAPPED_COMPLEX_TYPE___GET_TYPE_DEFINITION_TECHNOLOGY_IMPORT:
                return getTypeDefinitionTechnologyImport();
            case ServicePackage.MAPPED_COMPLEX_TYPE___GET_TYPE_DEFINITION_TECHNOLOGY:
                return getTypeDefinitionTechnology();
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
        result.append(" (t_sourceModelUri: ");
        result.append(t_sourceModelUri);
        result.append(')');
        return result.toString();
    }

} //MappedComplexTypeImpl
