/**
 */
package de.fhdo.ddmm.service;

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
 *   <li>{@link de.fhdo.ddmm.service.ServiceModel#getT_modelUri <em>Tmodel Uri</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.ServiceModel#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.ServiceModel#getMicroservices <em>Microservices</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.ServicePackage#getServiceModel()
 * @model
 * @generated
 */
public interface ServiceModel extends EObject {
    /**
     * Returns the value of the '<em><b>Tmodel Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tmodel Uri</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tmodel Uri</em>' attribute.
     * @see #setT_modelUri(String)
     * @see de.fhdo.ddmm.service.ServicePackage#getServiceModel_T_modelUri()
     * @model unique="false"
     * @generated
     */
    String getT_modelUri();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.ServiceModel#getT_modelUri <em>Tmodel Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Tmodel Uri</em>' attribute.
     * @see #getT_modelUri()
     * @generated
     */
    void setT_modelUri(String value);

    /**
     * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.Import}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Import#getServiceModel <em>Service Model</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Imports</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getServiceModel_Imports()
     * @see de.fhdo.ddmm.service.Import#getServiceModel
     * @model opposite="serviceModel" containment="true"
     * @generated
     */
    EList<Import> getImports();

    /**
     * Returns the value of the '<em><b>Microservices</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.Microservice}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Microservice#getServiceModel <em>Service Model</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Microservices</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Microservices</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getServiceModel_Microservices()
     * @see de.fhdo.ddmm.service.Microservice#getServiceModel
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
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Microservice%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Microservice%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;&gt;()\n{\n\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt; apply(final &lt;%de.fhdo.ddmm.service.Microservice%&gt; it)\n\t{\n\t\treturn it.getContainedOperations();\n\t}\n};\nreturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;asEList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;toList(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Microservice%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;&gt;map(this.getMicroservices(), _function))));'"
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
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Microservice%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ReferredOperation%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Microservice%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ReferredOperation%&gt;&gt;&gt;()\n{\n\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ReferredOperation%&gt;&gt; apply(final &lt;%de.fhdo.ddmm.service.Microservice%&gt; it)\n\t{\n\t\treturn it.getContainedReferredOperations();\n\t}\n};\nreturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ReferredOperation%&gt;&gt;asEList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ReferredOperation%&gt;&gt;toList(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ReferredOperation%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Microservice%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ReferredOperation%&gt;&gt;&gt;map(this.getMicroservices(), _function))));'"
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
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Microservice%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Microservice%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;&gt;&gt;()\n{\n\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;&gt; apply(final &lt;%de.fhdo.ddmm.service.Microservice%&gt; it)\n\t{\n\t\treturn it.getInterfaces();\n\t}\n};\nreturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;&gt;asEList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;&gt;toList(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Microservice%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;&gt;&gt;map(this.getMicroservices(), _function))));'"
     * @generated
     */
    EList<Interface> getContainedInterfaces();

} // ServiceModel
