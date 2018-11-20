/**
 */
package de.fhdo.ddmm.service;

import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Microservice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Concept to describe a microservices, its interfaces, and operations
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.Microservice#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Microservice#getVersion <em>Version</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Microservice#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Microservice#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Microservice#getTechnologies <em>Technologies</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Microservice#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Microservice#getRequiredMicroservices <em>Required Microservices</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Microservice#getRequiredInterfaces <em>Required Interfaces</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Microservice#getRequiredOperations <em>Required Operations</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Microservice#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Microservice#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Microservice#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Microservice#getServiceModel <em>Service Model</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Microservice#isEffectivelyImplemented <em>Effectively Implemented</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Microservice#getEffectiveVisibility <em>Effective Visibility</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Microservice#isEffectivelyInternal <em>Effectively Internal</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice()
 * @model
 * @generated
 */
public interface Microservice extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Name of a microservices must be qualified with at least one level, e.g.,
     *          "org.MyService".
     *          Ensured by: DSL grammar.
     *     (C2) No cyclic inheritance, i.e., within an inheritance hierarchy, a microservice must
     *          not occur twice.
     *          Ensured by: DSL validator.
     *     (C3) There might be at most one protocol per type for a microservice.
     *          Ensured by: DSL validator.
     *     (C4) A microservice may not require itself and only non-internal microservices from
     *          imported models.
     *          Ensured by: DSL scope provider.
     *     (C5) If a technology is assigned to the service, it must exhibit specifications for types
     *          and protocols. The rationale if this constraint is, that a technology might be
     *          assigned, but technology-specific types or protocols must not be explicitly assigned
     *          for convenience reasons. If they are missing, the defaults from the assigned
     *          technology are taken instead.
     *          Ensured by: DSL validator.
     *     (C6) Combination of endpoints' protocols and data formats must be unique.
     *          Ensured by: DSL validator.
     *     (C7) A technology might be assigned exactly once to a microservice.
     *          Ensured by: DSL validator.
     *     (C8) Only one assigned technology might comprise technology-specific types.
     *          Ensured by: DSL validator.
     *     (C9) Assigned technologies may not only define deployment-specific concepts.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Microservice#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Version</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Version</em>' attribute.
     * @see #setVersion(String)
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_Version()
     * @model unique="false"
     * @generated
     */
    String getVersion();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Microservice#getVersion <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Version</em>' attribute.
     * @see #getVersion()
     * @generated
     */
    void setVersion(String value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * The literals are from the enumeration {@link de.fhdo.ddmm.service.MicroserviceType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see de.fhdo.ddmm.service.MicroserviceType
     * @see #setType(MicroserviceType)
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_Type()
     * @model unique="false"
     * @generated
     */
    MicroserviceType getType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Microservice#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see de.fhdo.ddmm.service.MicroserviceType
     * @see #getType()
     * @generated
     */
    void setType(MicroserviceType value);

    /**
     * Returns the value of the '<em><b>Visibility</b></em>' attribute.
     * The default value is <code>"NONE"</code>.
     * The literals are from the enumeration {@link de.fhdo.ddmm.service.Visibility}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Visibility</em>' attribute.
     * @see de.fhdo.ddmm.service.Visibility
     * @see #setVisibility(Visibility)
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_Visibility()
     * @model default="NONE" unique="false"
     * @generated
     */
    Visibility getVisibility();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Microservice#getVisibility <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Visibility</em>' attribute.
     * @see de.fhdo.ddmm.service.Visibility
     * @see #getVisibility()
     * @generated
     */
    void setVisibility(Visibility value);

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
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_Technologies()
     * @model
     * @generated
     */
    EList<Import> getTechnologies();

    /**
     * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.Endpoint}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Endpoint#getMicroservice <em>Microservice</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoints</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoints</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_Endpoints()
     * @see de.fhdo.ddmm.service.Endpoint#getMicroservice
     * @model opposite="microservice" containment="true"
     * @generated
     */
    EList<Endpoint> getEndpoints();

    /**
     * Returns the value of the '<em><b>Required Microservices</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.PossiblyImportedMicroservice}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.PossiblyImportedMicroservice#getRequiringMicroservice <em>Requiring Microservice</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Required Microservices</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Required Microservices</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_RequiredMicroservices()
     * @see de.fhdo.ddmm.service.PossiblyImportedMicroservice#getRequiringMicroservice
     * @model opposite="requiringMicroservice" containment="true"
     * @generated
     */
    EList<PossiblyImportedMicroservice> getRequiredMicroservices();

    /**
     * Returns the value of the '<em><b>Required Interfaces</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.PossiblyImportedInterface}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.PossiblyImportedInterface#getRequiringMicroservice <em>Requiring Microservice</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Required Interfaces</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Required Interfaces</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_RequiredInterfaces()
     * @see de.fhdo.ddmm.service.PossiblyImportedInterface#getRequiringMicroservice
     * @model opposite="requiringMicroservice" containment="true"
     * @generated
     */
    EList<PossiblyImportedInterface> getRequiredInterfaces();

    /**
     * Returns the value of the '<em><b>Required Operations</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.PossiblyImportedOperation}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.PossiblyImportedOperation#getRequiringMicroservice <em>Requiring Microservice</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Required Operations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Required Operations</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_RequiredOperations()
     * @see de.fhdo.ddmm.service.PossiblyImportedOperation#getRequiringMicroservice
     * @model opposite="requiringMicroservice" containment="true"
     * @generated
     */
    EList<PossiblyImportedOperation> getRequiredOperations();

    /**
     * Returns the value of the '<em><b>Protocols</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.ProtocolSpecification}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Protocols</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocols</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_Protocols()
     * @model containment="true" upper="2"
     * @generated
     */
    EList<ProtocolSpecification> getProtocols();

    /**
     * Returns the value of the '<em><b>Interfaces</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.Interface}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Interface#getMicroservice <em>Microservice</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Interfaces</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Interfaces</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_Interfaces()
     * @see de.fhdo.ddmm.service.Interface#getMicroservice
     * @model opposite="microservice" containment="true" required="true"
     * @generated
     */
    EList<Interface> getInterfaces();

    /**
     * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.ImportedServiceAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.ImportedServiceAspect#getMicroservice <em>Microservice</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_Aspects()
     * @see de.fhdo.ddmm.service.ImportedServiceAspect#getMicroservice
     * @model opposite="microservice" containment="true"
     * @generated
     */
    EList<ImportedServiceAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Service Model</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.ServiceModel#getMicroservices <em>Microservices</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service Model</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Service Model</em>' container reference.
     * @see #setServiceModel(ServiceModel)
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_ServiceModel()
     * @see de.fhdo.ddmm.service.ServiceModel#getMicroservices
     * @model opposite="microservices" transient="false"
     * @generated
     */
    ServiceModel getServiceModel();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Microservice#getServiceModel <em>Service Model</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Service Model</em>' container reference.
     * @see #getServiceModel()
     * @generated
     */
    void setServiceModel(ServiceModel value);

    /**
     * Returns the value of the '<em><b>Effectively Implemented</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Check if microservice can extend another microservice as its super microservice
     * <!-- end-model-doc -->
     * @return the value of the '<em>Effectively Implemented</em>' attribute.
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_EffectivelyImplemented()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='final &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.Interface%&gt; it)\n\t{\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(it.isEffectivelyImplemented());\n\t}\n};\nreturn &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;&gt;exists(this.getInterfaces(), _function);'"
     * @generated
     */
    boolean isEffectivelyImplemented();

    /**
     * Returns the value of the '<em><b>Effective Visibility</b></em>' attribute.
     * The literals are from the enumeration {@link de.fhdo.ddmm.service.Visibility}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get effective visibility
     * <!-- end-model-doc -->
     * @return the value of the '<em>Effective Visibility</em>' attribute.
     * @see de.fhdo.ddmm.service.Visibility
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_EffectiveVisibility()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%de.fhdo.ddmm.service.Visibility%&gt; _visibility = this.getVisibility();\nboolean _tripleEquals = (_visibility == &lt;%de.fhdo.ddmm.service.Visibility%&gt;.NONE);\nif (_tripleEquals)\n{\n\treturn &lt;%de.fhdo.ddmm.service.Visibility%&gt;.ARCHITECTURE;\n}\nreturn this.getVisibility();'"
     * @generated
     */
    Visibility getEffectiveVisibility();

    /**
     * Returns the value of the '<em><b>Effectively Internal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Convenience method to check if a microservice is effectively marked as being internal
     * <!-- end-model-doc -->
     * @return the value of the '<em>Effectively Internal</em>' attribute.
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_EffectivelyInternal()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%de.fhdo.ddmm.service.Visibility%&gt; _effectiveVisibility = this.getEffectiveVisibility();\nreturn (_effectiveVisibility == &lt;%de.fhdo.ddmm.service.Visibility%&gt;.INTERNAL);'"
     * @generated
     */
    boolean isEffectivelyInternal();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get parts of the microservice for creating a qualified name
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; _xblockexpression = null;\n{\n\tif (((this.getName() == null) || this.getName().isEmpty()))\n\t{\n\t\treturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(&lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;newArrayList());\n\t}\n\tfinal &lt;%java.util.ArrayList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; nameParts = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;newArrayList();\n\t&lt;%java.lang.String%&gt; _version = this.getVersion();\n\tboolean _tripleNotEquals = (_version != null);\n\tif (_tripleNotEquals)\n\t{\n\t\tnameParts.add(this.getVersion());\n\t}\n\t&lt;%org.eclipse.xtext.xbase.lib.CollectionExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;addAll(nameParts, this.getName().split(\"\\\\.\"));\n\t_xblockexpression = &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(nameParts);\n}\nreturn _xblockexpression;'"
     * @generated
     */
    EList<String> getQualifiedNameParts();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get all operations of all interfaces of the microservice
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;&gt; _interfaces = this.getInterfaces();\nboolean _tripleEquals = (_interfaces == null);\nif (_tripleEquals)\n{\n\treturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;asEList(&lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;newArrayList());\n}\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.Interface%&gt; it)\n\t{\n\t\t&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt; _operations = it.getOperations();\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((_operations != null));\n\t}\n};\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;&gt;()\n{\n\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt; apply(final &lt;%de.fhdo.ddmm.service.Interface%&gt; it)\n\t{\n\t\treturn it.getOperations();\n\t}\n};\nreturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;toEList(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;concat(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;&gt;map(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;&gt;filter(this.getInterfaces(), _function), _function_1)));'"
     * @generated
     */
    EList<Operation> getContainedOperations();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get all referred operations of all interfaces of the microservice
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;&gt; _interfaces = this.getInterfaces();\nboolean _tripleEquals = (_interfaces == null);\nif (_tripleEquals)\n{\n\treturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ReferredOperation%&gt;&gt;asEList(&lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ReferredOperation%&gt;&gt;newArrayList());\n}\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.Interface%&gt; it)\n\t{\n\t\t&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ReferredOperation%&gt;&gt; _referredOperations = it.getReferredOperations();\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((_referredOperations != null));\n\t}\n};\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ReferredOperation%&gt;&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ReferredOperation%&gt;&gt;&gt;()\n{\n\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ReferredOperation%&gt;&gt; apply(final &lt;%de.fhdo.ddmm.service.Interface%&gt; it)\n\t{\n\t\treturn it.getReferredOperations();\n\t}\n};\nreturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ReferredOperation%&gt;&gt;toEList(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ReferredOperation%&gt;&gt;concat(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ReferredOperation%&gt;&gt;&gt;map(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Interface%&gt;&gt;filter(this.getInterfaces(), _function), _function_1)));'"
     * @generated
     */
    EList<ReferredOperation> getContainedReferredOperations();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get all import descriptions from imported, required concepts
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%java.util.HashSet%&gt;&lt;&lt;%de.fhdo.ddmm.service.Import%&gt;&gt; imports = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Import%&gt;&gt;newHashSet();\nif (((this.getRequiredMicroservices() != null) &amp;&amp; (!this.getRequiredMicroservices().isEmpty())))\n{\n\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t{\n\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt; it)\n\t\t{\n\t\t\t&lt;%de.fhdo.ddmm.service.Import%&gt; _import = it.getImport();\n\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((_import != null));\n\t\t}\n\t};\n\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt;, &lt;%de.fhdo.ddmm.service.Import%&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt;, &lt;%de.fhdo.ddmm.service.Import%&gt;&gt;()\n\t{\n\t\tpublic &lt;%de.fhdo.ddmm.service.Import%&gt; apply(final &lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt; it)\n\t\t{\n\t\t\treturn it.getImport();\n\t\t}\n\t};\n\t&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Import%&gt;&gt;addAll(imports, &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt;, &lt;%de.fhdo.ddmm.service.Import%&gt;&gt;map(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt;&gt;filter(this.getRequiredMicroservices(), _function), _function_1));\n}\nif (((this.getRequiredInterfaces() != null) &amp;&amp; (!this.getRequiredInterfaces().isEmpty())))\n{\n\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_2 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t{\n\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt; it)\n\t\t{\n\t\t\t&lt;%de.fhdo.ddmm.service.Import%&gt; _import = it.getImport();\n\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((_import != null));\n\t\t}\n\t};\n\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt;, &lt;%de.fhdo.ddmm.service.Import%&gt;&gt; _function_3 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt;, &lt;%de.fhdo.ddmm.service.Import%&gt;&gt;()\n\t{\n\t\tpublic &lt;%de.fhdo.ddmm.service.Import%&gt; apply(final &lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt; it)\n\t\t{\n\t\t\treturn it.getImport();\n\t\t}\n\t};\n\t&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Import%&gt;&gt;addAll(imports, &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt;, &lt;%de.fhdo.ddmm.service.Import%&gt;&gt;map(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt;&gt;filter(this.getRequiredInterfaces(), _function_2), _function_3));\n}\nif (((this.getRequiredOperations() != null) &amp;&amp; (!this.getRequiredOperations().isEmpty())))\n{\n\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_4 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t{\n\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt; it)\n\t\t{\n\t\t\t&lt;%de.fhdo.ddmm.service.Import%&gt; _import = it.getImport();\n\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((_import != null));\n\t\t}\n\t};\n\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt;, &lt;%de.fhdo.ddmm.service.Import%&gt;&gt; _function_5 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt;, &lt;%de.fhdo.ddmm.service.Import%&gt;&gt;()\n\t{\n\t\tpublic &lt;%de.fhdo.ddmm.service.Import%&gt; apply(final &lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt; it)\n\t\t{\n\t\t\treturn it.getImport();\n\t\t}\n\t};\n\t&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Import%&gt;&gt;addAll(imports, &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt;, &lt;%de.fhdo.ddmm.service.Import%&gt;&gt;map(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt;&gt;filter(this.getRequiredOperations(), _function_4), _function_5));\n}\nreturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Import%&gt;&gt;asEList(((&lt;%de.fhdo.ddmm.service.Import%&gt;[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(imports, &lt;%de.fhdo.ddmm.service.Import%&gt;.class)));'"
     * @generated
     */
    EList<Import> getRequiredImports();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get all operations that are directly or indirectly (i.e., from required interfaces and
     * microservices) required by this microservice from a given import
     * <!-- end-model-doc -->
     * @model unique="false" fromImportUnique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%java.util.HashSet%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt; operations = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;newHashSet();\nif (((this.getRequiredOperations() != null) &amp;&amp; (!this.getRequiredOperations().isEmpty())))\n{\n\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t{\n\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt; it)\n\t\t{\n\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((&lt;%com.google.common.base.Objects%&gt;.equal(it.getImport(), fromImport) &amp;&amp; \n\t\t\t\t(it.getOperation() != null)));\n\t\t}\n\t};\n\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt;, &lt;%de.fhdo.ddmm.service.Operation%&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt;, &lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;()\n\t{\n\t\tpublic &lt;%de.fhdo.ddmm.service.Operation%&gt; apply(final &lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt; it)\n\t\t{\n\t\t\treturn it.getOperation();\n\t\t}\n\t};\n\t&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;addAll(operations, \n\t\t&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt;, &lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;map(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt;&gt;filter(this.getRequiredOperations(), _function), _function_1));\n}\nif (((this.getRequiredInterfaces() != null) &amp;&amp; (!this.getRequiredInterfaces().isEmpty())))\n{\n\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_2 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t{\n\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt; it)\n\t\t{\n\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(((&lt;%com.google.common.base.Objects%&gt;.equal(it.getImport(), fromImport) &amp;&amp; \n\t\t\t\t(it.getInterface() != null)) &amp;&amp; \n\t\t\t\t(it.getInterface().getOperations() != null)));\n\t\t}\n\t};\n\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;&gt; _function_3 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;&gt;()\n\t{\n\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt; apply(final &lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt; it)\n\t\t{\n\t\t\treturn it.getInterface().getOperations();\n\t\t}\n\t};\n\t&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;addAll(operations, \n\t\t&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;concat(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;&gt;map(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt;&gt;filter(this.getRequiredInterfaces(), _function_2), _function_3)));\n}\nif (((this.getRequiredMicroservices() != null) &amp;&amp; (!this.getRequiredMicroservices().isEmpty())))\n{\n\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_4 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t{\n\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt; it)\n\t\t{\n\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((&lt;%com.google.common.base.Objects%&gt;.equal(it.getImport(), fromImport) &amp;&amp; \n\t\t\t\t(it.getMicroservice() != null)));\n\t\t}\n\t};\n\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;&gt; _function_5 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;&gt;()\n\t{\n\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt; apply(final &lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt; it)\n\t\t{\n\t\t\treturn it.getMicroservice().getContainedOperations();\n\t\t}\n\t};\n\t&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;addAll(operations, \n\t\t&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;concat(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;&gt;map(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt;&gt;filter(this.getRequiredMicroservices(), _function_4), _function_5)));\n}\nreturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;asEList(((&lt;%de.fhdo.ddmm.service.Operation%&gt;[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(operations, &lt;%de.fhdo.ddmm.service.Operation%&gt;.class)));'"
     * @generated
     */
    EList<Operation> getAllRequiredOperations(Import fromImport);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get all microservices that are directly or indirectly (i.e., from required interfaces and
     * operations) required by this microservice
     * <!-- end-model-doc -->
     * @model kind="operation" dataType="de.fhdo.ddmm.service.MicroserviceImportMap" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%java.util.HashMap%&gt;&lt;&lt;%de.fhdo.ddmm.service.Microservice%&gt;, &lt;%de.fhdo.ddmm.service.Import%&gt;&gt; microservices = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Microservice%&gt;, &lt;%de.fhdo.ddmm.service.Import%&gt;&gt;newHashMap();\n&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt;&gt; _requiredMicroservices = this.getRequiredMicroservices();\nboolean _tripleNotEquals = (_requiredMicroservices != null);\nif (_tripleNotEquals)\n{\n\tfinal &lt;%java.util.function.Consumer%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt;&gt; _function = new &lt;%java.util.function.Consumer%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt;&gt;()\n\t{\n\t\tpublic void accept(final &lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt; it)\n\t\t{\n\t\t\tmicroservices.put(it.getMicroservice(), it.getImport());\n\t\t}\n\t};\n\tthis.getRequiredMicroservices().forEach(_function);\n}\n&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt;&gt; _requiredInterfaces = this.getRequiredInterfaces();\nboolean _tripleNotEquals_1 = (_requiredInterfaces != null);\nif (_tripleNotEquals_1)\n{\n\tfinal &lt;%java.util.function.Consumer%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt;&gt; _function_1 = new &lt;%java.util.function.Consumer%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt;&gt;()\n\t{\n\t\tpublic void accept(final &lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt; it)\n\t\t{\n\t\t\tmicroservices.put(it.getInterface().getMicroservice(), it.getImport());\n\t\t}\n\t};\n\tthis.getRequiredInterfaces().forEach(_function_1);\n}\n&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt;&gt; _requiredOperations = this.getRequiredOperations();\nboolean _tripleNotEquals_2 = (_requiredOperations != null);\nif (_tripleNotEquals_2)\n{\n\tfinal &lt;%java.util.function.Consumer%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt;&gt; _function_2 = new &lt;%java.util.function.Consumer%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt;&gt;()\n\t{\n\t\tpublic void accept(final &lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt; it)\n\t\t{\n\t\t\tmicroservices.put(it.getOperation().getInterface().getMicroservice(), it.getImport());\n\t\t}\n\t};\n\tthis.getRequiredOperations().forEach(_function_2);\n}\nreturn microservices;'"
     * @generated
     */
    Map<Microservice, Import> getAllRequiredMicroservices();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Check if microservice can require another microservice
     * <!-- end-model-doc -->
     * @model unique="false" microserviceUnique="false" isImportedServiceUnique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if ((microservice == null))\n{\n\treturn false;\n}\nreturn ((microservice != this) &amp;&amp; ((!isImportedService) || (!microservice.isEffectivelyInternal())));'"
     * @generated
     */
    boolean canRequire(Microservice microservice, boolean isImportedService);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Check if microservice can require an interface
     * <!-- end-model-doc -->
     * @model unique="false" ifaceUnique="false" isImportedInterfaceUnique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (((iface == null) || (iface.getMicroservice() == null)))\n{\n\treturn false;\n}\nboolean canRequire = ((!iface.isNotImplemented()) &amp;&amp; (!iface.isEffectivelyInternal()));\nif (((this.getInterfaces() != null) &amp;&amp; (!this.getInterfaces().isEmpty())))\n{\n\tcanRequire = (canRequire &amp;&amp; (!this.getInterfaces().contains(iface)));\n}\nreturn canRequire;'"
     * @generated
     */
    boolean canRequire(Interface iface, boolean isImportedInterface);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Check if microservice can require an operation
     * <!-- end-model-doc -->
     * @model unique="false" operationUnique="false" isImportedOperationUnique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if ((((operation == null) || (operation.getInterface() == null)) || \n\t(operation.getInterface().getMicroservice() == null)))\n{\n\treturn false;\n}\nboolean canRequire = ((!operation.isEffectivelyNotImplemented()) &amp;&amp; (!operation.isEffectivelyInternal()));\nif (((this.getContainedOperations() != null) &amp;&amp; (!this.getContainedOperations().isEmpty())))\n{\n\tcanRequire = (canRequire &amp;&amp; (!this.getContainedOperations().contains(operation)));\n}\nreturn canRequire;'"
     * @generated
     */
    boolean canRequire(Operation operation, boolean isImportedOperation);

} // Microservice
