/**
 */
package de.fhdo.ddmm.service;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Referred Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents an operation to which an interface other than its defining interface refers. Used for
 * interface mashups.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.ReferredOperation#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.ReferredOperation#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.ReferredOperation#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.ReferredOperation#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.ReferredOperation#getInterface <em>Interface</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.ServicePackage#getReferredOperation()
 * @model
 * @generated
 */
public interface ReferredOperation extends EObject {
    /**
     * Returns the value of the '<em><b>Operation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) There might be at most one protocol per communication type assigned to a referred
     *          operation.
     *          Ensured by: DSL validator.
     *     (C2) Combination of endpoints' protocols and data formats must be unique.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Operation</em>' reference.
     * @see #setOperation(Operation)
     * @see de.fhdo.ddmm.service.ServicePackage#getReferredOperation_Operation()
     * @model
     * @generated
     */
    Operation getOperation();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.ReferredOperation#getOperation <em>Operation</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation</em>' reference.
     * @see #getOperation()
     * @generated
     */
    void setOperation(Operation value);

    /**
     * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.Endpoint}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Endpoint#getReferredOperation <em>Referred Operation</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoints</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoints</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getReferredOperation_Endpoints()
     * @see de.fhdo.ddmm.service.Endpoint#getReferredOperation
     * @model opposite="referredOperation" containment="true"
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
     * @see de.fhdo.ddmm.service.ServicePackage#getReferredOperation_Protocols()
     * @model containment="true" upper="2"
     * @generated
     */
    EList<ProtocolSpecification> getProtocols();

    /**
     * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.ImportedServiceAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.ImportedServiceAspect#getReferredOperation <em>Referred Operation</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getReferredOperation_Aspects()
     * @see de.fhdo.ddmm.service.ImportedServiceAspect#getReferredOperation
     * @model opposite="referredOperation" containment="true"
     * @generated
     */
    EList<ImportedServiceAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Interface</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Interface#getReferredOperations <em>Referred Operations</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Interface</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Interface</em>' container reference.
     * @see #setInterface(Interface)
     * @see de.fhdo.ddmm.service.ServicePackage#getReferredOperation_Interface()
     * @see de.fhdo.ddmm.service.Interface#getReferredOperations
     * @model opposite="referredOperations" transient="false"
     * @generated
     */
    Interface getInterface();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.ReferredOperation#getInterface <em>Interface</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Interface</em>' container reference.
     * @see #getInterface()
     * @generated
     */
    void setInterface(Interface value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * TRANSFORMATION ONLY: Get those effective protocols and data formats of the referred operation
     * that are not used in an endpoint of the referred operation. Note that a referred operation
     * "inherits" its effective protocols from its surrounding interface that refers to the original
     * operation and hence particularly _not_ from the interface in which the operation being
     * referred to is declared.
     * <!-- end-model-doc -->
     * @model dataType="de.fhdo.ddmm.service.TupleList" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (((((this.getInterface() == null) || \n\t(this.getInterface().getMicroservice() == null)) || \n\t(this.getInterface().getMicroservice().getT_defaultProtocols() == null)) || \n\tthis.getInterface().getMicroservice().getT_defaultProtocols().isEmpty()))\n{\n\treturn null;\n}\nfinal &lt;%java.util.List%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt; effectiveProtocols = this.t_effectiveProtocolSpecifications();\nif ((effectiveProtocols == null))\n{\n\treturn null;\n}\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Endpoint%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Endpoint%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;&gt;()\n{\n\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt; apply(final &lt;%de.fhdo.ddmm.service.Endpoint%&gt; it)\n\t{\n\t\treturn it.getProtocols();\n\t}\n};\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt; it)\n\t{\n\t\t&lt;%de.fhdo.ddmm.technology.DataFormat%&gt; _dataFormat = it.getDataFormat();\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((_dataFormat == null));\n\t}\n};\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%de.fhdo.ddmm.technology.Protocol%&gt;&gt; _function_2 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%de.fhdo.ddmm.technology.Protocol%&gt;&gt;()\n{\n\tpublic &lt;%de.fhdo.ddmm.technology.Protocol%&gt; apply(final &lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt; it)\n\t{\n\t\treturn it.getImportedProtocol();\n\t}\n};\nfinal &lt;%java.util.List%&gt;&lt;&lt;%de.fhdo.ddmm.technology.Protocol%&gt;&gt; endpointProtocolsWithoutDataFormats = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.Protocol%&gt;&gt;toList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%de.fhdo.ddmm.technology.Protocol%&gt;&gt;map(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;filter(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Endpoint%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;&gt;map(this.getEndpoints(), _function)), _function_1), _function_2));\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_3 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt; it)\n\t{\n\t\tboolean _xblockexpression = false;\n\t\t{\n\t\t\t&lt;%java.lang.Object%&gt; _get = it.get(\"protocol\");\n\t\t\tfinal &lt;%de.fhdo.ddmm.technology.Protocol%&gt; protocol = ((&lt;%de.fhdo.ddmm.technology.Protocol%&gt;) _get);\n\t\t\tboolean _contains = endpointProtocolsWithoutDataFormats.contains(protocol);\n\t\t\t_xblockexpression = (!_contains);\n\t\t}\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(_xblockexpression);\n\t}\n};\n&lt;%java.util.List%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt; resultProtocols = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt;toList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt;filter(effectiveProtocols, _function_3));\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Endpoint%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;&gt; _function_4 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Endpoint%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;&gt;()\n{\n\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt; apply(final &lt;%de.fhdo.ddmm.service.Endpoint%&gt; it)\n\t{\n\t\treturn it.getProtocols();\n\t}\n};\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_5 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt; it)\n\t{\n\t\t&lt;%de.fhdo.ddmm.technology.DataFormat%&gt; _dataFormat = it.getDataFormat();\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((_dataFormat != null));\n\t}\n};\nfinal &lt;%java.util.List%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt; endpointProtocolsWithDataFormats = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;toList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;filter(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Endpoint%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;&gt;map(this.getEndpoints(), _function_4)), _function_5));\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_6 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt; it)\n\t{\n\t\tboolean _xblockexpression = false;\n\t\t{\n\t\t\t&lt;%java.lang.Object%&gt; _get = it.get(\"protocol\");\n\t\t\tfinal &lt;%de.fhdo.ddmm.technology.Protocol%&gt; protocol = ((&lt;%de.fhdo.ddmm.technology.Protocol%&gt;) _get);\n\t\t\t&lt;%java.lang.Object%&gt; _get_1 = it.get(\"dataFormat\");\n\t\t\tfinal &lt;%de.fhdo.ddmm.technology.DataFormat%&gt; dataFormat = ((&lt;%de.fhdo.ddmm.technology.DataFormat%&gt;) _get_1);\n\t\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t\t\t{\n\t\t\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt; it)\n\t\t\t\t{\n\t\t\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((&lt;%com.google.common.base.Objects%&gt;.equal(it.getImportedProtocol(), protocol) &amp;&amp; &lt;%com.google.common.base.Objects%&gt;.equal(it.getDataFormat(), dataFormat)));\n\t\t\t\t}\n\t\t\t};\n\t\t\tboolean _exists = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ImportedProtocolAndDataFormat%&gt;&gt;exists(endpointProtocolsWithDataFormats, _function);\n\t\t\t_xblockexpression = (!_exists);\n\t\t}\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(_xblockexpression);\n\t}\n};\nreturn &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt;toList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt;filter(resultProtocols, _function_6));'"
     * @generated
     */
    List<Map<String, Object>> t_missingEndpointEffectiveProtocols();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * TRANSFORMATION ONLY: Get effective protocols of the referred operation as combinations of
     * Protocol and DataFormat. The effective protocols are primarily determined by the referred
     * operations _own_ (i.e., _not_ the operation it refers to) protocol specifications. If a
     * protocol specification for a communication type is missing, the type's effective protocols
     * are taken from the interface that surrounds the referred operation (i.e., _not_ the interface
     * of the operation being referred to).
     * <!-- end-model-doc -->
     * @model dataType="de.fhdo.ddmm.service.TupleList" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (((((this.getInterface() == null) || \n\t(this.getInterface().getMicroservice() == null)) || \n\t(this.getInterface().getMicroservice().getT_defaultProtocols() == null)) || \n\tthis.getInterface().getMicroservice().getT_defaultProtocols().isEmpty()))\n{\n\treturn null;\n}\n&lt;%java.util.List%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt; _xifexpression = null;\nboolean _isEmpty = this.getProtocols().isEmpty();\nboolean _not = (!_isEmpty);\nif (_not)\n{\n\t_xifexpression = this.getProtocols().get(0).effectiveProtocolSpecifications(this.getProtocols());\n}\nelse\n{\n\t_xifexpression = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt;newArrayList();\n}\nfinal &lt;%java.util.List%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt; effectiveProtocolSpecifications = _xifexpression;\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ProtocolSpecification%&gt;, &lt;%de.fhdo.ddmm.technology.CommunicationType%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.ProtocolSpecification%&gt;, &lt;%de.fhdo.ddmm.technology.CommunicationType%&gt;&gt;()\n{\n\tpublic &lt;%de.fhdo.ddmm.technology.CommunicationType%&gt; apply(final &lt;%de.fhdo.ddmm.service.ProtocolSpecification%&gt; it)\n\t{\n\t\treturn it.getProtocol().getImportedProtocol().getCommunicationType();\n\t}\n};\nfinal &lt;%java.util.Set%&gt;&lt;&lt;%de.fhdo.ddmm.technology.CommunicationType%&gt;&gt; protocolSpecificationsCommunicationTypes = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.CommunicationType%&gt;&gt;toSet(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.ProtocolSpecification%&gt;, &lt;%de.fhdo.ddmm.technology.CommunicationType%&gt;&gt;map(this.getProtocols(), _function));\nfinal &lt;%java.util.function.Consumer%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt; _function_1 = new &lt;%java.util.function.Consumer%&gt;&lt;&lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt;&gt;()\n{\n\tpublic void accept(final &lt;%java.util.Map%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Object%&gt;&gt; microserviceEffectiveProtocolTuple)\n\t{\n\t\t&lt;%java.lang.Object%&gt; _get = microserviceEffectiveProtocolTuple.get(\"protocol\");\n\t\tfinal &lt;%de.fhdo.ddmm.technology.Protocol%&gt; protocol = ((&lt;%de.fhdo.ddmm.technology.Protocol%&gt;) _get);\n\t\tboolean _contains = protocolSpecificationsCommunicationTypes.contains(protocol.getCommunicationType());\n\t\tboolean _not = (!_contains);\n\t\tif (_not)\n\t\t{\n\t\t\teffectiveProtocolSpecifications.add(microserviceEffectiveProtocolTuple);\n\t\t}\n\t}\n};\nthis.getInterface().t_effectiveProtocolSpecifications().forEach(_function_1);\nreturn effectiveProtocolSpecifications;'"
     * @generated
     */
    List<Map<String, Object>> t_effectiveProtocolSpecifications();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get parts of the referred operation for creating a qualified name
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; _xblockexpression = null;\n{\n\tif (((this.getOperation().getName() == null) || this.getOperation().getName().isEmpty()))\n\t{\n\t\treturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(&lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;newArrayList());\n\t}\n\tfinal &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; nameParts = this.getInterface().getQualifiedNameParts();\n\t&lt;%org.eclipse.xtext.xbase.lib.CollectionExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;addAll(nameParts, this.getOperation().getName());\n\t_xblockexpression = &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(nameParts);\n}\nreturn _xblockexpression;'"
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

} // ReferredOperation
