/**
 */
package de.fhdo.ddmm.service;

import de.fhdo.ddmm.technology.CommunicationType;
import de.fhdo.ddmm.technology.Protocol;
import de.fhdo.ddmm.technology.Technology;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.lib.Pair;

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
 *   <li>{@link de.fhdo.ddmm.service.Microservice#getT_defaultProtocols <em>Tdefault Protocols</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Microservice#getT_sourceModelUri <em>Tsource Model Uri</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Microservice#getTechnologies <em>Technologies</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Microservice#getT_typeDefinitionTechnologyImport <em>Ttype Definition Technology Import</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Microservice#getT_typeDefinitionTechnology <em>Ttype Definition Technology</em>}</li>
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
     *     (C10) If the service does not specify explicit protocols for a communication type, only
     *           one technology may comprise a default protocol specification for that type.
     *           Ensured by: DSL validator.
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
     * Returns the value of the '<em><b>Tdefault Protocols</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tdefault Protocols</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tdefault Protocols</em>' attribute.
     * @see #setT_defaultProtocols(Map)
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_T_defaultProtocols()
     * @model unique="false" dataType="de.fhdo.ddmm.service.DefaultProtocols"
     * @generated
     */
    Map<CommunicationType, Pair<Import, Protocol>> getT_defaultProtocols();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Microservice#getT_defaultProtocols <em>Tdefault Protocols</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Tdefault Protocols</em>' attribute.
     * @see #getT_defaultProtocols()
     * @generated
     */
    void setT_defaultProtocols(Map<CommunicationType, Pair<Import, Protocol>> value);

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
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_T_sourceModelUri()
     * @model unique="false"
     * @generated
     */
    String getT_sourceModelUri();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Microservice#getT_sourceModelUri <em>Tsource Model Uri</em>}' attribute.
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
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_Technologies()
     * @model
     * @generated
     */
    EList<Import> getTechnologies();

    /**
     * Returns the value of the '<em><b>Ttype Definition Technology Import</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ttype Definition Technology Import</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ttype Definition Technology Import</em>' reference.
     * @see #setT_typeDefinitionTechnologyImport(Import)
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_T_typeDefinitionTechnologyImport()
     * @model
     * @generated
     */
    Import getT_typeDefinitionTechnologyImport();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Microservice#getT_typeDefinitionTechnologyImport <em>Ttype Definition Technology Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ttype Definition Technology Import</em>' reference.
     * @see #getT_typeDefinitionTechnologyImport()
     * @generated
     */
    void setT_typeDefinitionTechnologyImport(Import value);

    /**
     * Returns the value of the '<em><b>Ttype Definition Technology</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ttype Definition Technology</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ttype Definition Technology</em>' reference.
     * @see #setT_typeDefinitionTechnology(Technology)
     * @see de.fhdo.ddmm.service.ServicePackage#getMicroservice_T_typeDefinitionTechnology()
     * @model
     * @generated
     */
    Technology getT_typeDefinitionTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Microservice#getT_typeDefinitionTechnology <em>Ttype Definition Technology</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ttype Definition Technology</em>' reference.
     * @see #getT_typeDefinitionTechnology()
     * @generated
     */
    void setT_typeDefinitionTechnology(Technology value);

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
     * TRANSFORMATION ONLY: Get those effective protocols and data formats of the microservice that
     * are not used in an endpoint of the microservice.
     * <!-- end-model-doc -->
     * @model dataType="de.fhdo.ddmm.service.TupleList" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (((this.getT_defaultProtocols() == null) || this.getT_defaultProtocols().isEmpty()))\n{\n\treturn null;\n}\nfinal &lt;%java.util.List%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt; effectiveProtocols = this.t_effectiveProtocolSpecifications();\nif ((effectiveProtocols == null))\n{\n\treturn null;\n}\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Endpoint%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Endpoint%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;&gt;()\n{\n\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt; apply(final &lt;%de.fhdo.ddmm.service.Endpoint%&gt; it)\n\t{\n\t\treturn it.getProtocols();\n\t}\n};\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt; it)\n\t{\n\t\t&lt;%de.fhdo.ddmm.technology.DataFormat%&gt; _dataFormat = it.getDataFormat();\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((_dataFormat == null));\n\t}\n};\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%de.fhdo.ddmm.technology.Protocol%&gt;&gt; _function_2 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%de.fhdo.ddmm.technology.Protocol%&gt;&gt;()\n{\n\tpublic &lt;%de.fhdo.ddmm.technology.Protocol%&gt; apply(final &lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt; it)\n\t{\n\t\treturn it.getImportedProtocol();\n\t}\n};\nfinal &lt;%java.util.List%&gt;&lt;&lt;%de.fhdo.ddmm.technology.Protocol%&gt;&gt; endpointProtocolsWithoutDataFormats = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.Protocol%&gt;&gt;toList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%de.fhdo.ddmm.technology.Protocol%&gt;&gt;map(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;filter(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Endpoint%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;&gt;map(this.getEndpoints(), _function)), _function_1), _function_2));\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_3 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt; it)\n\t{\n\t\tboolean _xblockexpression = false;\n\t\t{\n\t\t\t&lt;%java.lang.Object%&gt; _get = it.get(\"protocol\");\n\t\t\tfinal &lt;%de.fhdo.ddmm.technology.Protocol%&gt; protocol = ((&lt;%de.fhdo.ddmm.technology.Protocol%&gt;) _get);\n\t\t\tboolean _contains = endpointProtocolsWithoutDataFormats.contains(protocol);\n\t\t\t_xblockexpression = (!_contains);\n\t\t}\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(_xblockexpression);\n\t}\n};\n&lt;%java.util.List%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt; resultProtocols = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt;toList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt;filter(effectiveProtocols, _function_3));\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Endpoint%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;&gt; _function_4 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Endpoint%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;&gt;()\n{\n\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt; apply(final &lt;%de.fhdo.ddmm.service.Endpoint%&gt; it)\n\t{\n\t\treturn it.getProtocols();\n\t}\n};\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_5 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt; it)\n\t{\n\t\t&lt;%de.fhdo.ddmm.technology.DataFormat%&gt; _dataFormat = it.getDataFormat();\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((_dataFormat != null));\n\t}\n};\nfinal &lt;%java.util.List%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt; endpointProtocolsWithDataFormats = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;toList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;filter(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Endpoint%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;&gt;map(this.getEndpoints(), _function_4)), _function_5));\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_6 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt; it)\n\t{\n\t\tboolean _xblockexpression = false;\n\t\t{\n\t\t\t&lt;%java.lang.Object%&gt; _get = it.get(\"protocol\");\n\t\t\tfinal &lt;%de.fhdo.ddmm.technology.Protocol%&gt; protocol = ((&lt;%de.fhdo.ddmm.technology.Protocol%&gt;) _get);\n\t\t\t&lt;%java.lang.Object%&gt; _get_1 = it.get(\"dataFormat\");\n\t\t\tfinal &lt;%de.fhdo.ddmm.technology.DataFormat%&gt; dataFormat = ((&lt;%de.fhdo.ddmm.technology.DataFormat%&gt;) _get_1);\n\t\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t\t\t{\n\t\t\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt; it)\n\t\t\t\t{\n\t\t\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((&lt;%com.google.common.base.Objects%&gt;.equal(it.getImportedProtocol(), protocol) &amp;&amp; &lt;%com.google.common.base.Objects%&gt;.equal(it.getDataFormat(), dataFormat)));\n\t\t\t\t}\n\t\t\t};\n\t\t\tboolean _exists = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;exists(endpointProtocolsWithDataFormats, _function);\n\t\t\t_xblockexpression = (!_exists);\n\t\t}\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(_xblockexpression);\n\t}\n};\nreturn &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt;toList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt;filter(resultProtocols, _function_6));'"
     * @generated
     */
    List<Map<String, Object>> t_missingEndpointEffectiveProtocols();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * TRANSFORMATION ONLY: Get effective protocols of the microservice as combinations of Protocol
     * and DataFormat. The effective protocols are primarily determined by the microservice's
     * protocol specifications. If a protocol specification for a communication type is missing, the
     * default protocol and data format for the communication type are taken from the service's
     * default protocol technology.
     * <!-- end-model-doc -->
     * @model dataType="de.fhdo.ddmm.service.TupleList" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (((this.getT_defaultProtocols() == null) || this.getT_defaultProtocols().isEmpty()))\n{\n\treturn null;\n}\n&lt;%java.util.List%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt; _xifexpression = null;\nboolean _isEmpty = this.getProtocols().isEmpty();\nboolean _not = (!_isEmpty);\nif (_not)\n{\n\t_xifexpression = this.getProtocols().get(0).effectiveProtocolSpecifications(this.getProtocols());\n}\nelse\n{\n\t_xifexpression = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt;newArrayList();\n}\nfinal &lt;%java.util.List%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt; effectiveProtocolSpecifications = _xifexpression;\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ProtocolSpecification%&gt;, &lt;%de.fhdo.ddmm.technology.CommunicationType%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ProtocolSpecification%&gt;, &lt;%de.fhdo.ddmm.technology.CommunicationType%&gt;&gt;()\n{\n\tpublic &lt;%de.fhdo.ddmm.technology.CommunicationType%&gt; apply(final &lt;%de.fhdo.ddmm.service.ProtocolSpecification%&gt; it)\n\t{\n\t\treturn it.getProtocol().getImportedProtocol().getCommunicationType();\n\t}\n};\nfinal &lt;%java.util.Set%&gt;&lt;&lt;%de.fhdo.ddmm.technology.CommunicationType%&gt;&gt; protocolSpecificationsCommunicationTypes = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.CommunicationType%&gt;&gt;toSet(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ProtocolSpecification%&gt;, &lt;%de.fhdo.ddmm.technology.CommunicationType%&gt;&gt;map(this.getProtocols(), _function));\nfinal &lt;%java.util.function.BiConsumer%&gt;&lt;&lt;%de.fhdo.ddmm.technology.CommunicationType%&gt;, &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%de.fhdo.ddmm.service.Import%&gt;, &lt;%de.fhdo.ddmm.technology.Protocol%&gt;&gt;&gt; _function_1 = new &lt;%java.util.function.BiConsumer%&gt;&lt;&lt;%de.fhdo.ddmm.technology.CommunicationType%&gt;, &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%de.fhdo.ddmm.service.Import%&gt;, &lt;%de.fhdo.ddmm.technology.Protocol%&gt;&gt;&gt;()\n{\n\tpublic void accept(final &lt;%de.fhdo.ddmm.technology.CommunicationType%&gt; communicationType, final &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%de.fhdo.ddmm.service.Import%&gt;, &lt;%de.fhdo.ddmm.technology.Protocol%&gt;&gt; importAndProtocol)\n\t{\n\t\tboolean _contains = protocolSpecificationsCommunicationTypes.contains(communicationType);\n\t\tboolean _not = (!_contains);\n\t\tif (_not)\n\t\t{\n\t\t\tfinal &lt;%java.util.HashMap%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt; entry = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;newHashMap();\n\t\t\tfinal &lt;%de.fhdo.ddmm.technology.Protocol%&gt; protocol = importAndProtocol.getValue();\n\t\t\tentry.put(\"protocol\", protocol);\n\t\t\tentry.put(\"dataFormat\", protocol.getDefaultFormat());\n\t\t\tentry.put(\"import\", importAndProtocol.getKey());\n\t\t\teffectiveProtocolSpecifications.add(entry);\n\t\t}\n\t}\n};\nthis.getT_defaultProtocols().forEach(_function_1);\nreturn effectiveProtocolSpecifications;'"
     * @generated
     */
    List<Map<String, Object>> t_effectiveProtocolSpecifications();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get imports of type definition technologies
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Import%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Import%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.Import%&gt; it)\n\t{\n\t\tboolean _xblockexpression = false;\n\t\t{\n\t\t\tfinal &lt;%de.fhdo.ddmm.technology.Technology%&gt; technologyModel = &lt;%de.fhdo.ddmm.utils.DdmmUtils%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.Technology%&gt;&gt;getImportedModelRoot(it.eResource(), it.getImportURI(), &lt;%de.fhdo.ddmm.technology.Technology%&gt;.class);\n\t\t\t_xblockexpression = (((!technologyModel.getPrimitiveTypes().isEmpty()) || \n\t\t\t\t(!technologyModel.getListTypes().isEmpty())) || \n\t\t\t\t(!technologyModel.getDataStructures().isEmpty()));\n\t\t}\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(_xblockexpression);\n\t}\n};\nreturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Import%&gt;&gt;toEList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Import%&gt;&gt;filter(this.getTechnologies(), _function));'"
     * @generated
     */
    EList<Import> getTypeDefinitionTechnologyImports();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get import of type definition technology. Note that this corresponds to the first technology
     * import in the list of type definition technology imports and should only be executed if the
     * model had been validated to refer to one type definition technology at most.
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Import%&gt;&gt; typeDefinitionTechnologyImports = this.getTypeDefinitionTechnologyImports();\n&lt;%de.fhdo.ddmm.service.Import%&gt; _xifexpression = null;\nboolean _isEmpty = typeDefinitionTechnologyImports.isEmpty();\nboolean _not = (!_isEmpty);\nif (_not)\n{\n\t_xifexpression = typeDefinitionTechnologyImports.get(0);\n}\nelse\n{\n\t_xifexpression = null;\n}\nreturn _xifexpression;'"
     * @generated
     */
    Import getTypeDefinitionTechnologyImport();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get type definition technology models
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Import%&gt;, &lt;%de.fhdo.ddmm.technology.Technology%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Import%&gt;, &lt;%de.fhdo.ddmm.technology.Technology%&gt;&gt;()\n{\n\tpublic &lt;%de.fhdo.ddmm.technology.Technology%&gt; apply(final &lt;%de.fhdo.ddmm.service.Import%&gt; it)\n\t{\n\t\treturn &lt;%de.fhdo.ddmm.utils.DdmmUtils%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.Technology%&gt;&gt;getImportedModelRoot(it.eResource(), it.getImportURI(), &lt;%de.fhdo.ddmm.technology.Technology%&gt;.class);\n\t}\n};\nreturn &lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Import%&gt;, &lt;%de.fhdo.ddmm.technology.Technology%&gt;&gt;map(this.getTypeDefinitionTechnologyImports(), _function);'"
     * @generated
     */
    EList<Technology> getTypeDefinitionTechnologies();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get type definition technology. Note that this corresponds to the first technology model in
     * the list of type definition technology models and should only be executed if the service
     * model had been validated to refer to one type definition technology at most.
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.technology.Technology%&gt;&gt; typeDefinitionTechnologies = this.getTypeDefinitionTechnologies();\n&lt;%de.fhdo.ddmm.technology.Technology%&gt; _xifexpression = null;\nboolean _isEmpty = typeDefinitionTechnologies.isEmpty();\nboolean _not = (!_isEmpty);\nif (_not)\n{\n\t_xifexpression = typeDefinitionTechnologies.get(0);\n}\nelse\n{\n\t_xifexpression = null;\n}\nreturn _xifexpression;'"
     * @generated
     */
    Technology getTypeDefinitionTechnology();

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
     * Build qualified name from qualified name parts
     * <!-- end-model-doc -->
     * @model unique="false" separatorUnique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if ((separator == null))\n{\n\treturn null;\n}\n&lt;%java.lang.String%&gt; qualifiedName = \"\";\n&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; _qualifiedNameParts = this.getQualifiedNameParts();\nfor (final &lt;%java.lang.String%&gt; part : _qualifiedNameParts)\n{\n\t&lt;%java.lang.String%&gt; _qualifiedName = qualifiedName;\n\tqualifiedName = (_qualifiedName + (separator + part));\n}\nboolean _isEmpty = qualifiedName.isEmpty();\nboolean _not = (!_isEmpty);\nif (_not)\n{\n\tqualifiedName = qualifiedName.substring(separator.length());\n}\nreturn qualifiedName;'"
     * @generated
     */
    String buildQualifiedName(String separator);

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
     * Get all microservices whose operations' initializing parameters belong to operations of this
     * microservice
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%java.util.HashSet%&gt;&lt;&lt;%de.fhdo.ddmm.service.Microservice%&gt;&gt; microservices = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Microservice%&gt;&gt;newHashSet();\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Parameter%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Parameter%&gt;&gt;&gt;()\n{\n\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Parameter%&gt;&gt; apply(final &lt;%de.fhdo.ddmm.service.Operation%&gt; it)\n\t{\n\t\treturn it.getParameters();\n\t}\n};\nfinal &lt;%java.util.function.Consumer%&gt;&lt;&lt;%de.fhdo.ddmm.service.Parameter%&gt;&gt; _function_1 = new &lt;%java.util.function.Consumer%&gt;&lt;&lt;%de.fhdo.ddmm.service.Parameter%&gt;&gt;()\n{\n\tpublic void accept(final &lt;%de.fhdo.ddmm.service.Parameter%&gt; it)\n\t{\n\t\t&lt;%de.fhdo.ddmm.service.PossiblyImportedOperation%&gt; _initializedByOperation = it.getInitializedByOperation();\n\t\tboolean _tripleNotEquals = (_initializedByOperation != null);\n\t\tif (_tripleNotEquals)\n\t\t{\n\t\t\tmicroservices.add(it.getOperation().getInterface().getMicroservice());\n\t\t}\n\t}\n};\n&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Parameter%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.Parameter%&gt;&gt;&gt;map(this.getContainedOperations(), _function)).forEach(_function_1);\nreturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Microservice%&gt;&gt;asEList(((&lt;%de.fhdo.ddmm.service.Microservice%&gt;[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(microservices, &lt;%de.fhdo.ddmm.service.Microservice%&gt;.class)));'"
     * @generated
     */
    EList<Microservice> getAllInitializingMicroservices();

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
