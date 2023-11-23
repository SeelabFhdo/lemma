/**
 */
package de.fhdo.lemma.service;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * This metamodel represents the Service Modeling Viewpoint, which is used for defining services.
 *  * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.ServiceModel#getT_modelUri <em>Tmodel Uri</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.ServiceModel#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.ServiceModel#getMappedComplexTypes <em>Mapped Complex Types</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.ServiceModel#getMicroservices <em>Microservices</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.ServicePackage#getServiceModel()
 * @model
 * @generated
 */
public interface ServiceModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Tmodel Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tmodel Uri</em>' attribute.
	 * @see #setT_modelUri(String)
	 * @see de.fhdo.lemma.service.ServicePackage#getServiceModel_T_modelUri()
	 * @model unique="false"
	 * @generated
	 */
	String getT_modelUri();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.ServiceModel#getT_modelUri <em>Tmodel Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tmodel Uri</em>' attribute.
	 * @see #getT_modelUri()
	 * @generated
	 */
	void setT_modelUri(String value);

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.Import}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Import#getServiceModel <em>Service Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getServiceModel_Imports()
	 * @see de.fhdo.lemma.service.Import#getServiceModel
	 * @model opposite="serviceModel" containment="true"
	 * @generated
	 */
	EList<Import> getImports();

	/**
	 * Returns the value of the '<em><b>Mapped Complex Types</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.MappedComplexType}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.MappedComplexType#getServiceModel <em>Service Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Complex Types</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getServiceModel_MappedComplexTypes()
	 * @see de.fhdo.lemma.service.MappedComplexType#getServiceModel
	 * @model opposite="serviceModel" containment="true"
	 * @generated
	 */
	EList<MappedComplexType> getMappedComplexTypes();

	/**
	 * Returns the value of the '<em><b>Microservices</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.Microservice}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Microservice#getServiceModel <em>Service Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Microservices</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getServiceModel_Microservices()
	 * @see de.fhdo.lemma.service.Microservice#getServiceModel
	 * @model opposite="serviceModel" containment="true" required="true"
	 * @generated
	 */
	EList<Microservice> getMicroservices();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get all operations of all defined microservices
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<Operation> getContainedOperations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get all referred operations of all defined microservices
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<ReferredOperation> getContainedReferredOperations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get all interfaces of all defined microservices
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<Interface> getContainedInterfaces();

} // ServiceModel
