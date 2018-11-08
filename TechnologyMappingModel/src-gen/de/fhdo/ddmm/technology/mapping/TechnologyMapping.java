/**
 */
package de.fhdo.ddmm.technology.mapping;

import de.fhdo.ddmm.service.Import;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Technology Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Metamodel for technology mappings that provide an alternative to specifying technology in service
 * models. It aims to preserve the readability of service models and to keep them
 * technology-agnostic.
 *  * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologyMapping#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.TechnologyMapping#getMappings <em>Mappings</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologyMapping()
 * @model
 * @generated
 */
public interface TechnologyMapping extends EObject {
    /**
     * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.Import}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Imported files must be unique.
     *          Ensured by: DSL validator.
     *     (C2) A microservice may only be mapped once.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Imports</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologyMapping_Imports()
     * @model containment="true" required="true"
     * @generated
     */
    EList<Import> getImports();

    /**
     * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.mapping.MicroserviceMapping}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.MicroserviceMapping#getMappingModel <em>Mapping Model</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mappings</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getTechnologyMapping_Mappings()
     * @see de.fhdo.ddmm.technology.mapping.MicroserviceMapping#getMappingModel
     * @model opposite="mappingModel" containment="true" required="true"
     * @generated
     */
    EList<MicroserviceMapping> getMappings();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get all mapped interfaces of all mapped microservices
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.technology.mapping.MicroserviceMapping%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.technology.mapping.InterfaceMapping%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.technology.mapping.MicroserviceMapping%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.technology.mapping.InterfaceMapping%&gt;&gt;&gt;()\n{\n\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.technology.mapping.InterfaceMapping%&gt;&gt; apply(final &lt;%de.fhdo.ddmm.technology.mapping.MicroserviceMapping%&gt; it)\n\t{\n\t\treturn it.getInterfaceMappings();\n\t}\n};\nreturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.mapping.InterfaceMapping%&gt;&gt;asEList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.mapping.InterfaceMapping%&gt;&gt;toList(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.mapping.InterfaceMapping%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.mapping.MicroserviceMapping%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.technology.mapping.InterfaceMapping%&gt;&gt;&gt;map(this.getMappings(), _function))));'"
     * @generated
     */
    EList<InterfaceMapping> getMappedInterfaces();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get all operations of all mapped microservices
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.technology.mapping.MicroserviceMapping%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.technology.mapping.OperationMapping%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.technology.mapping.MicroserviceMapping%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.technology.mapping.OperationMapping%&gt;&gt;&gt;()\n{\n\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.technology.mapping.OperationMapping%&gt;&gt; apply(final &lt;%de.fhdo.ddmm.technology.mapping.MicroserviceMapping%&gt; it)\n\t{\n\t\treturn it.getOperationMappings();\n\t}\n};\nreturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.mapping.OperationMapping%&gt;&gt;asEList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.mapping.OperationMapping%&gt;&gt;toList(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.mapping.OperationMapping%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.mapping.MicroserviceMapping%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.technology.mapping.OperationMapping%&gt;&gt;&gt;map(this.getMappings(), _function))));'"
     * @generated
     */
    EList<OperationMapping> getMappedOperations();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get all mapped referred operations of all mapped microservices
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.technology.mapping.MicroserviceMapping%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.technology.mapping.ReferredOperationMapping%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.technology.mapping.MicroserviceMapping%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.technology.mapping.ReferredOperationMapping%&gt;&gt;&gt;()\n{\n\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.technology.mapping.ReferredOperationMapping%&gt;&gt; apply(final &lt;%de.fhdo.ddmm.technology.mapping.MicroserviceMapping%&gt; it)\n\t{\n\t\treturn it.getReferredOperationMappings();\n\t}\n};\nreturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.mapping.ReferredOperationMapping%&gt;&gt;asEList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.mapping.ReferredOperationMapping%&gt;&gt;toList(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.mapping.ReferredOperationMapping%&gt;&gt;concat(&lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.mapping.MicroserviceMapping%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.technology.mapping.ReferredOperationMapping%&gt;&gt;&gt;map(this.getMappings(), _function))));'"
     * @generated
     */
    EList<ReferredOperationMapping> getMappedReferredOperations();

} // TechnologyMapping
