/**
 */
package de.fhdo.ddmm.service;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapped Complex Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Concept to express technology-specific information, which was assigned to a complex type
 * leveraging the Mapping DSL
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.MappedComplexType#getT_sourceModelUri <em>Tsource Model Uri</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.MappedComplexType#getTechnologies <em>Technologies</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.MappedComplexType#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.MappedComplexType#getMappedFields <em>Mapped Fields</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.MappedComplexType#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.MappedComplexType#getServiceModel <em>Service Model</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.ServicePackage#getMappedComplexType()
 * @model
 * @generated
 */
public interface MappedComplexType extends EObject {
    /**
     * Returns the value of the '<em><b>Tsource Model Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tsource Model Uri</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tsource Model Uri</em>' attribute.
     * @see #setT_sourceModelUri(String)
     * @see de.fhdo.ddmm.service.ServicePackage#getMappedComplexType_T_sourceModelUri()
     * @model unique="false"
     * @generated
     */
    String getT_sourceModelUri();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.MappedComplexType#getT_sourceModelUri <em>Tsource Model Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Tsource Model Uri</em>' attribute.
     * @see #getT_sourceModelUri()
     * @generated
     */
    void setT_sourceModelUri(String value);

    /**
     * Returns the value of the '<em><b>Technologies</b></em>' reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.Import}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Technologies</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technologies</em>' reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getMappedComplexType_Technologies()
     * @model
     * @generated
     */
    EList<Import> getTechnologies();

    /**
     * Returns the value of the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' containment reference.
     * @see #setType(ImportedType)
     * @see de.fhdo.ddmm.service.ServicePackage#getMappedComplexType_Type()
     * @model containment="true"
     * @generated
     */
    ImportedType getType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.MappedComplexType#getType <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' containment reference.
     * @see #getType()
     * @generated
     */
    void setType(ImportedType value);

    /**
     * Returns the value of the '<em><b>Mapped Fields</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.MappedField}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.MappedField#getMappedComplexType <em>Mapped Complex Type</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mapped Fields</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mapped Fields</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getMappedComplexType_MappedFields()
     * @see de.fhdo.ddmm.service.MappedField#getMappedComplexType
     * @model opposite="mappedComplexType" containment="true"
     * @generated
     */
    EList<MappedField> getMappedFields();

    /**
     * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.ImportedServiceAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.ImportedServiceAspect#getMappedComplexType <em>Mapped Complex Type</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getMappedComplexType_Aspects()
     * @see de.fhdo.ddmm.service.ImportedServiceAspect#getMappedComplexType
     * @model opposite="mappedComplexType" containment="true"
     * @generated
     */
    EList<ImportedServiceAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Service Model</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.ServiceModel#getMappedComplexTypes <em>Mapped Complex Types</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service Model</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Service Model</em>' container reference.
     * @see #setServiceModel(ServiceModel)
     * @see de.fhdo.ddmm.service.ServicePackage#getMappedComplexType_ServiceModel()
     * @see de.fhdo.ddmm.service.ServiceModel#getMappedComplexTypes
     * @model opposite="mappedComplexTypes" transient="false"
     * @generated
     */
    ServiceModel getServiceModel();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.MappedComplexType#getServiceModel <em>Service Model</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Service Model</em>' container reference.
     * @see #getServiceModel()
     * @generated
     */
    void setServiceModel(ServiceModel value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get parts of the mapped complex type for creating a qualified name
     * <!-- end-model-doc -->
     * @model unique="false" withImportNameUnique="false"
     * @generated
     */
    EList<String> getQualifiedNameParts(boolean withImportName);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Build qualified name from qualified name parts
     * <!-- end-model-doc -->
     * @model unique="false" separatorUnique="false" withImportNameUnique="false"
     * @generated
     */
    String buildQualifiedName(String separator, boolean withImportName);

} // MappedComplexType
