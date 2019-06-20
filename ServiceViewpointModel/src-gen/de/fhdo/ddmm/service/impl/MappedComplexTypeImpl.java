/**
 */
package de.fhdo.ddmm.service.impl;

import de.fhdo.ddmm.data.ComplexType;
import de.fhdo.ddmm.data.Type;

import de.fhdo.ddmm.service.Import;
import de.fhdo.ddmm.service.ImportedServiceAspect;
import de.fhdo.ddmm.service.ImportedType;
import de.fhdo.ddmm.service.MappedComplexType;
import de.fhdo.ddmm.service.MappedField;
import de.fhdo.ddmm.service.ServiceModel;
import de.fhdo.ddmm.service.ServicePackage;

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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapped Complex Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.impl.MappedComplexTypeImpl#getT_sourceModelUri <em>Tsource Model Uri</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MappedComplexTypeImpl#getTechnologies <em>Technologies</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MappedComplexTypeImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MappedComplexTypeImpl#getMappedFields <em>Mapped Fields</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MappedComplexTypeImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.MappedComplexTypeImpl#getServiceModel <em>Service Model</em>}</li>
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
     * The cached value of the '{@link #getTechnologies() <em>Technologies</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTechnologies()
     * @generated
     * @ordered
     */
    protected EList<Import> technologies;

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
    @Override
    public String getT_sourceModelUri() {
        return t_sourceModelUri;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
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
    @Override
    public EList<Import> getTechnologies() {
        if (technologies == null) {
            technologies = new EObjectResolvingEList<Import>(Import.class, this, ServicePackage.MAPPED_COMPLEX_TYPE__TECHNOLOGIES);
        }
        return technologies;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_FIELDS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getMappedFields()).basicAdd(otherEnd, msgs);
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
            case ServicePackage.MAPPED_COMPLEX_TYPE__TYPE:
                return basicSetType(null, msgs);
            case ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_FIELDS:
                return ((InternalEList<?>)getMappedFields()).basicRemove(otherEnd, msgs);
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
            case ServicePackage.MAPPED_COMPLEX_TYPE__TECHNOLOGIES:
                return getTechnologies();
            case ServicePackage.MAPPED_COMPLEX_TYPE__TYPE:
                return getType();
            case ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_FIELDS:
                return getMappedFields();
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
            case ServicePackage.MAPPED_COMPLEX_TYPE__TECHNOLOGIES:
                getTechnologies().clear();
                getTechnologies().addAll((Collection<? extends Import>)newValue);
                return;
            case ServicePackage.MAPPED_COMPLEX_TYPE__TYPE:
                setType((ImportedType)newValue);
                return;
            case ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_FIELDS:
                getMappedFields().clear();
                getMappedFields().addAll((Collection<? extends MappedField>)newValue);
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
            case ServicePackage.MAPPED_COMPLEX_TYPE__TECHNOLOGIES:
                getTechnologies().clear();
                return;
            case ServicePackage.MAPPED_COMPLEX_TYPE__TYPE:
                setType((ImportedType)null);
                return;
            case ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_FIELDS:
                getMappedFields().clear();
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
            case ServicePackage.MAPPED_COMPLEX_TYPE__TECHNOLOGIES:
                return technologies != null && !technologies.isEmpty();
            case ServicePackage.MAPPED_COMPLEX_TYPE__TYPE:
                return type != null;
            case ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_FIELDS:
                return mappedFields != null && !mappedFields.isEmpty();
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
