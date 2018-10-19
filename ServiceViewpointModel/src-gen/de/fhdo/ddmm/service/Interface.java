/**
 */
package de.fhdo.ddmm.service;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents the interface of a microservice
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.Interface#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Interface#isNotImplemented <em>Not Implemented</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Interface#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Interface#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Interface#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Interface#getOperations <em>Operations</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Interface#getReferredOperations <em>Referred Operations</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Interface#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Interface#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Interface#getEffectiveVisibility <em>Effective Visibility</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Interface#isEffectivelyImplemented <em>Effectively Implemented</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Interface#isEffectivelyInternal <em>Effectively Internal</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.ServicePackage#getInterface()
 * @model
 * @generated
 */
public interface Interface extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Interface must define or refer to at least one operation.
     *          Ensured by: DSL validator.
     *     (C2) There might be at most one protocol per communication type assigned to an interface.
     *          Ensured by: DSL validator.
     *     (C3) Combination of endpoints' protocols and data formats must be unique.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.ddmm.service.ServicePackage#getInterface_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Interface#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Not Implemented</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Not Implemented</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Not Implemented</em>' attribute.
     * @see #setNotImplemented(boolean)
     * @see de.fhdo.ddmm.service.ServicePackage#getInterface_NotImplemented()
     * @model default="false" unique="false"
     * @generated
     */
    boolean isNotImplemented();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Interface#isNotImplemented <em>Not Implemented</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Not Implemented</em>' attribute.
     * @see #isNotImplemented()
     * @generated
     */
    void setNotImplemented(boolean value);

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
     * @see de.fhdo.ddmm.service.ServicePackage#getInterface_Visibility()
     * @model default="NONE" unique="false"
     * @generated
     */
    Visibility getVisibility();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Interface#getVisibility <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Visibility</em>' attribute.
     * @see de.fhdo.ddmm.service.Visibility
     * @see #getVisibility()
     * @generated
     */
    void setVisibility(Visibility value);

    /**
     * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.Endpoint}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Endpoint#getInterface <em>Interface</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoints</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoints</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getInterface_Endpoints()
     * @see de.fhdo.ddmm.service.Endpoint#getInterface
     * @model opposite="interface" containment="true"
     * @generated
     */
    EList<Endpoint> getEndpoints();

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
     * @see de.fhdo.ddmm.service.ServicePackage#getInterface_Protocols()
     * @model containment="true" upper="2"
     * @generated
     */
    EList<ProtocolSpecification> getProtocols();

    /**
     * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.Operation}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Operation#getInterface <em>Interface</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operations</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getInterface_Operations()
     * @see de.fhdo.ddmm.service.Operation#getInterface
     * @model opposite="interface" containment="true"
     * @generated
     */
    EList<Operation> getOperations();

    /**
     * Returns the value of the '<em><b>Referred Operations</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.ReferredOperation}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.ReferredOperation#getInterface <em>Interface</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Referred Operations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Referred Operations</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getInterface_ReferredOperations()
     * @see de.fhdo.ddmm.service.ReferredOperation#getInterface
     * @model opposite="interface" containment="true"
     * @generated
     */
    EList<ReferredOperation> getReferredOperations();

    /**
     * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.ImportedServiceAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.ImportedServiceAspect#getInterface <em>Interface</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getInterface_Aspects()
     * @see de.fhdo.ddmm.service.ImportedServiceAspect#getInterface
     * @model opposite="interface" containment="true"
     * @generated
     */
    EList<ImportedServiceAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Microservice</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Microservice#getInterfaces <em>Interfaces</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Microservice</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Microservice</em>' container reference.
     * @see #setMicroservice(Microservice)
     * @see de.fhdo.ddmm.service.ServicePackage#getInterface_Microservice()
     * @see de.fhdo.ddmm.service.Microservice#getInterfaces
     * @model opposite="interfaces" transient="false"
     * @generated
     */
    Microservice getMicroservice();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Interface#getMicroservice <em>Microservice</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Microservice</em>' container reference.
     * @see #getMicroservice()
     * @generated
     */
    void setMicroservice(Microservice value);

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
     * @see de.fhdo.ddmm.service.ServicePackage#getInterface_EffectiveVisibility()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%de.fhdo.ddmm.service.Microservice%&gt; _microservice = this.getMicroservice();\nboolean _tripleEquals = (_microservice == null);\nif (_tripleEquals)\n{\n\treturn null;\n}\nfinal &lt;%de.fhdo.ddmm.service.Visibility%&gt; serviceVisibility = this.getMicroservice().getEffectiveVisibility();\nif (serviceVisibility != null)\n{\n\tswitch (serviceVisibility)\n\t{\n\t\tcase INTERNAL:\n\t\t\t&lt;%de.fhdo.ddmm.service.Visibility%&gt; _visibility = this.getVisibility();\n\t\t\tboolean _tripleEquals_1 = (_visibility == &lt;%de.fhdo.ddmm.service.Visibility%&gt;.NONE);\n\t\t\tif (_tripleEquals_1)\n\t\t\t{\n\t\t\t\treturn &lt;%de.fhdo.ddmm.service.Visibility%&gt;.IN_MODEL;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\t&lt;%de.fhdo.ddmm.service.Visibility%&gt; _visibility_1 = this.getVisibility();\n\t\t\t\tboolean _tripleEquals_2 = (_visibility_1 == &lt;%de.fhdo.ddmm.service.Visibility%&gt;.INTERNAL);\n\t\t\t\tif (_tripleEquals_2)\n\t\t\t\t{\n\t\t\t\t\treturn this.getVisibility();\n\t\t\t\t}\n\t\t\t}\n\t\t\tbreak;\n\t\tcase ARCHITECTURE:\n\t\t\t&lt;%de.fhdo.ddmm.service.Visibility%&gt; _visibility_2 = this.getVisibility();\n\t\t\tboolean _tripleEquals_3 = (_visibility_2 == &lt;%de.fhdo.ddmm.service.Visibility%&gt;.NONE);\n\t\t\tif (_tripleEquals_3)\n\t\t\t{\n\t\t\t\treturn serviceVisibility;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif (((this.getVisibility() == &lt;%de.fhdo.ddmm.service.Visibility%&gt;.INTERNAL) || \n\t\t\t\t\t(this.getVisibility() == &lt;%de.fhdo.ddmm.service.Visibility%&gt;.ARCHITECTURE)))\n\t\t\t\t{\n\t\t\t\t\treturn this.getVisibility();\n\t\t\t\t}\n\t\t\t}\n\t\t\tbreak;\n\t\tcase PUBLIC:\n\t\t\t&lt;%de.fhdo.ddmm.service.Visibility%&gt; _visibility_3 = this.getVisibility();\n\t\t\tboolean _tripleEquals_4 = (_visibility_3 == &lt;%de.fhdo.ddmm.service.Visibility%&gt;.NONE);\n\t\t\tif (_tripleEquals_4)\n\t\t\t{\n\t\t\t\treturn serviceVisibility;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif ((((this.getVisibility() == &lt;%de.fhdo.ddmm.service.Visibility%&gt;.INTERNAL) || \n\t\t\t\t\t(this.getVisibility() == &lt;%de.fhdo.ddmm.service.Visibility%&gt;.ARCHITECTURE)) || \n\t\t\t\t\t(this.getVisibility() == &lt;%de.fhdo.ddmm.service.Visibility%&gt;.PUBLIC)))\n\t\t\t\t{\n\t\t\t\t\treturn this.getVisibility();\n\t\t\t\t}\n\t\t\t}\n\t\t\tbreak;\n\t\tdefault:\n\t\t\treturn null;\n\t}\n}\nelse\n{\n\treturn null;\n}\nreturn null;'"
     * @generated
     */
    Visibility getEffectiveVisibility();

    /**
     * Returns the value of the '<em><b>Effectively Implemented</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Convenience method to check if an interface is effectively implemented
     * <!-- end-model-doc -->
     * @return the value of the '<em>Effectively Implemented</em>' attribute.
     * @see de.fhdo.ddmm.service.ServicePackage#getInterface_EffectivelyImplemented()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return ((!this.isNotImplemented()) &amp;&amp; &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;&gt;exists(this.getOperations(), new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Operation%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.Operation%&gt; it)\n\t{\n\t\tboolean _isNotImplemented = it.isNotImplemented();\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((!_isNotImplemented));\n\t}\n}));'"
     * @generated
     */
    boolean isEffectivelyImplemented();

    /**
     * Returns the value of the '<em><b>Effectively Internal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Convenience method to check if an interface is effectively marked as being internal
     * <!-- end-model-doc -->
     * @return the value of the '<em>Effectively Internal</em>' attribute.
     * @see de.fhdo.ddmm.service.ServicePackage#getInterface_EffectivelyInternal()
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
     * TRANSFORMATION ONLY: Get those effective protocols and data formats of the interface that
     * are not used in an endpoint of the interface.
     * <!-- end-model-doc -->
     * @model dataType="de.fhdo.ddmm.service.TupleList" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if ((((this.getMicroservice() == null) || \n\t(this.getMicroservice().getT_defaultProtocols() == null)) || \n\tthis.getMicroservice().getT_defaultProtocols().isEmpty()))\n{\n\treturn null;\n}\nfinal &lt;%java.util.List%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt; effectiveProtocols = this.t_effectiveProtocolSpecifications();\nif ((effectiveProtocols == null))\n{\n\treturn null;\n}\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Endpoint%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Endpoint%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;&gt;()\n{\n\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt; apply(final &lt;%de.fhdo.ddmm.service.Endpoint%&gt; it)\n\t{\n\t\treturn it.getProtocols();\n\t}\n};\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt; it)\n\t{\n\t\t&lt;%de.fhdo.ddmm.technology.DataFormat%&gt; _dataFormat = it.getDataFormat();\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((_dataFormat == null));\n\t}\n};\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%de.fhdo.ddmm.technology.Protocol%&gt;&gt; _function_2 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%de.fhdo.ddmm.technology.Protocol%&gt;&gt;()\n{\n\tpublic &lt;%de.fhdo.ddmm.technology.Protocol%&gt; apply(final &lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt; it)\n\t{\n\t\treturn it.getImportedProtocol();\n\t}\n};\nfinal &lt;%java.util.List%&gt;&lt;&lt;%de.fhdo.ddmm.technology.Protocol%&gt;&gt; endpointProtocolsWithoutDataFormats = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.Protocol%&gt;&gt;toList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%de.fhdo.ddmm.technology.Protocol%&gt;&gt;map(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;filter(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Endpoint%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;&gt;map(this.getEndpoints(), _function)), _function_1), _function_2));\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_3 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt; it)\n\t{\n\t\tboolean _xblockexpression = false;\n\t\t{\n\t\t\t&lt;%java.lang.Object%&gt; _get = it.get(\"protocol\");\n\t\t\tfinal &lt;%de.fhdo.ddmm.technology.Protocol%&gt; protocol = ((&lt;%de.fhdo.ddmm.technology.Protocol%&gt;) _get);\n\t\t\tboolean _contains = endpointProtocolsWithoutDataFormats.contains(protocol);\n\t\t\t_xblockexpression = (!_contains);\n\t\t}\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(_xblockexpression);\n\t}\n};\n&lt;%java.util.List%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt; resultProtocols = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt;toList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt;filter(effectiveProtocols, _function_3));\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Endpoint%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;&gt; _function_4 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Endpoint%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;&gt;()\n{\n\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt; apply(final &lt;%de.fhdo.ddmm.service.Endpoint%&gt; it)\n\t{\n\t\treturn it.getProtocols();\n\t}\n};\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_5 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt; it)\n\t{\n\t\t&lt;%de.fhdo.ddmm.technology.DataFormat%&gt; _dataFormat = it.getDataFormat();\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((_dataFormat != null));\n\t}\n};\nfinal &lt;%java.util.List%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt; endpointProtocolsWithDataFormats = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;toList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;filter(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Endpoint%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;&gt;map(this.getEndpoints(), _function_4)), _function_5));\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_6 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt; it)\n\t{\n\t\tboolean _xblockexpression = false;\n\t\t{\n\t\t\t&lt;%java.lang.Object%&gt; _get = it.get(\"protocol\");\n\t\t\tfinal &lt;%de.fhdo.ddmm.technology.Protocol%&gt; protocol = ((&lt;%de.fhdo.ddmm.technology.Protocol%&gt;) _get);\n\t\t\t&lt;%java.lang.Object%&gt; _get_1 = it.get(\"dataFormat\");\n\t\t\tfinal &lt;%de.fhdo.ddmm.technology.DataFormat%&gt; dataFormat = ((&lt;%de.fhdo.ddmm.technology.DataFormat%&gt;) _get_1);\n\t\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t\t\t{\n\t\t\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt; it)\n\t\t\t\t{\n\t\t\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((&lt;%com.google.common.base.Objects%&gt;.equal(it.getImportedProtocol(), protocol) &amp;&amp; &lt;%com.google.common.base.Objects%&gt;.equal(it.getDataFormat(), dataFormat)));\n\t\t\t\t}\n\t\t\t};\n\t\t\tboolean _exists = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;exists(endpointProtocolsWithDataFormats, _function);\n\t\t\t_xblockexpression = (!_exists);\n\t\t}\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(_xblockexpression);\n\t}\n};\nreturn &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt;toList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt;filter(resultProtocols, _function_6));'"
     * @generated
     */
    List<Map<String, Object>> t_missingEndpointEffectiveProtocols();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * TRANSFORMATION ONLY: Get effective protocols of the interface as combinations of Protocol
     * and DataFormat. The effective protocols are primarily determined by the interface's protocol
     * specifications. If a protocol specification for a communication type is missing, the type's
     * effective protocols are taken from the containing microservice.
     * <!-- end-model-doc -->
     * @model dataType="de.fhdo.ddmm.service.TupleList" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if ((((this.getMicroservice() == null) || \n\t(this.getMicroservice().getT_defaultProtocols() == null)) || \n\tthis.getMicroservice().getT_defaultProtocols().isEmpty()))\n{\n\treturn null;\n}\n&lt;%java.util.List%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt; _xifexpression = null;\nboolean _isEmpty = this.getProtocols().isEmpty();\nboolean _not = (!_isEmpty);\nif (_not)\n{\n\t_xifexpression = this.getProtocols().get(0).effectiveProtocolSpecifications(this.getProtocols());\n}\nelse\n{\n\t_xifexpression = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt;newArrayList();\n}\nfinal &lt;%java.util.List%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt; effectiveProtocolSpecifications = _xifexpression;\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ProtocolSpecification%&gt;, &lt;%de.fhdo.ddmm.technology.CommunicationType%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ProtocolSpecification%&gt;, &lt;%de.fhdo.ddmm.technology.CommunicationType%&gt;&gt;()\n{\n\tpublic &lt;%de.fhdo.ddmm.technology.CommunicationType%&gt; apply(final &lt;%de.fhdo.ddmm.service.ProtocolSpecification%&gt; it)\n\t{\n\t\treturn it.getProtocol().getImportedProtocol().getCommunicationType();\n\t}\n};\nfinal &lt;%java.util.Set%&gt;&lt;&lt;%de.fhdo.ddmm.technology.CommunicationType%&gt;&gt; protocolSpecificationsCommunicationTypes = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.CommunicationType%&gt;&gt;toSet(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ProtocolSpecification%&gt;, &lt;%de.fhdo.ddmm.technology.CommunicationType%&gt;&gt;map(this.getProtocols(), _function));\nfinal &lt;%java.util.function.Consumer%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt; _function_1 = new &lt;%java.util.function.Consumer%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt;()\n{\n\tpublic void accept(final &lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt; microserviceEffectiveProtocolTuple)\n\t{\n\t\t&lt;%java.lang.Object%&gt; _get = microserviceEffectiveProtocolTuple.get(\"protocol\");\n\t\tfinal &lt;%de.fhdo.ddmm.technology.Protocol%&gt; protocol = ((&lt;%de.fhdo.ddmm.technology.Protocol%&gt;) _get);\n\t\tboolean _contains = protocolSpecificationsCommunicationTypes.contains(protocol.getCommunicationType());\n\t\tboolean _not = (!_contains);\n\t\tif (_not)\n\t\t{\n\t\t\teffectiveProtocolSpecifications.add(microserviceEffectiveProtocolTuple);\n\t\t}\n\t}\n};\nthis.getMicroservice().t_effectiveProtocolSpecifications().forEach(_function_1);\nreturn effectiveProtocolSpecifications;'"
     * @generated
     */
    List<Map<String, Object>> t_effectiveProtocolSpecifications();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get parts of the interface for creating a qualified name
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; _xblockexpression = null;\n{\n\tif (((this.getName() == null) || this.getName().isEmpty()))\n\t{\n\t\treturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(&lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;newArrayList());\n\t}\n\tfinal &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; nameParts = this.getMicroservice().getQualifiedNameParts();\n\t&lt;%org.eclipse.xtext.xbase.lib.CollectionExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;addAll(nameParts, this.getName());\n\t_xblockexpression = &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(nameParts);\n}\nreturn _xblockexpression;'"
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

} // Interface
