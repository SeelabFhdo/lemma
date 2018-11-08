/**
 */
package de.fhdo.ddmm.service;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents an operation within an interface of a microservice
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.Operation#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Operation#isNotImplemented <em>Not Implemented</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Operation#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Operation#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Operation#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Operation#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Operation#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Operation#getInterface <em>Interface</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Operation#isNotImplementedByContainer <em>Not Implemented By Container</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Operation#isEffectivelyNotImplemented <em>Effectively Not Implemented</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Operation#getEffectiveVisibility <em>Effective Visibility</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Operation#isEffectivelyInternal <em>Effectively Internal</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.ServicePackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) There might be at most one protocol per communication type assigned to an operation.
     *          Ensured by: DSL validator.
     *     (C2) Combination of endpoints' protocols and data formats must be unique.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.ddmm.service.ServicePackage#getOperation_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Operation#getName <em>Name</em>}' attribute.
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
     * @see de.fhdo.ddmm.service.ServicePackage#getOperation_NotImplemented()
     * @model default="false" unique="false"
     * @generated
     */
    boolean isNotImplemented();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Operation#isNotImplemented <em>Not Implemented</em>}' attribute.
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
     * @see de.fhdo.ddmm.service.ServicePackage#getOperation_Visibility()
     * @model default="NONE" unique="false"
     * @generated
     */
    Visibility getVisibility();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Operation#getVisibility <em>Visibility</em>}' attribute.
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
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Endpoint#getOperation <em>Operation</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoints</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoints</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getOperation_Endpoints()
     * @see de.fhdo.ddmm.service.Endpoint#getOperation
     * @model opposite="operation" containment="true"
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
     * @see de.fhdo.ddmm.service.ServicePackage#getOperation_Protocols()
     * @model containment="true" upper="2"
     * @generated
     */
    EList<ProtocolSpecification> getProtocols();

    /**
     * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.Parameter}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Parameter#getOperation <em>Operation</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameters</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getOperation_Parameters()
     * @see de.fhdo.ddmm.service.Parameter#getOperation
     * @model opposite="operation" containment="true"
     * @generated
     */
    EList<Parameter> getParameters();

    /**
     * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.ImportedServiceAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.ImportedServiceAspect#getOperation <em>Operation</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getOperation_Aspects()
     * @see de.fhdo.ddmm.service.ImportedServiceAspect#getOperation
     * @model opposite="operation" containment="true"
     * @generated
     */
    EList<ImportedServiceAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Interface</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Interface#getOperations <em>Operations</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Interface</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Interface</em>' container reference.
     * @see #setInterface(Interface)
     * @see de.fhdo.ddmm.service.ServicePackage#getOperation_Interface()
     * @see de.fhdo.ddmm.service.Interface#getOperations
     * @model opposite="operations" transient="false"
     * @generated
     */
    Interface getInterface();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Operation#getInterface <em>Interface</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Interface</em>' container reference.
     * @see #getInterface()
     * @generated
     */
    void setInterface(Interface value);

    /**
     * Returns the value of the '<em><b>Not Implemented By Container</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Check if the operation is indirectly not implemented, because its container, i.e., interface,
     * is already marked as being not implemented
     * <!-- end-model-doc -->
     * @return the value of the '<em>Not Implemented By Container</em>' attribute.
     * @see de.fhdo.ddmm.service.ServicePackage#getOperation_NotImplementedByContainer()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%de.fhdo.ddmm.service.Interface%&gt; _interface = this.getInterface();\nboolean _tripleEquals = (_interface == null);\nif (_tripleEquals)\n{\n\treturn false;\n}\nreturn this.getInterface().isNotImplemented();'"
     * @generated
     */
    boolean isNotImplementedByContainer();

    /**
     * Returns the value of the '<em><b>Effectively Not Implemented</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Check, if an operation is effectively not implemented, either directly or indirectly, i.e.,
     * because its interface is already marked as being not implemented
     * <!-- end-model-doc -->
     * @return the value of the '<em>Effectively Not Implemented</em>' attribute.
     * @see de.fhdo.ddmm.service.ServicePackage#getOperation_EffectivelyNotImplemented()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return (this.isNotImplemented() || this.isNotImplementedByContainer());'"
     * @generated
     */
    boolean isEffectivelyNotImplemented();

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
     * @see de.fhdo.ddmm.service.ServicePackage#getOperation_EffectiveVisibility()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%de.fhdo.ddmm.service.Interface%&gt; _interface = this.getInterface();\nboolean _tripleEquals = (_interface == null);\nif (_tripleEquals)\n{\n\treturn null;\n}\nfinal &lt;%de.fhdo.ddmm.service.Visibility%&gt; interfaceVisibility = this.getInterface().getEffectiveVisibility();\nif ((interfaceVisibility == null))\n{\n\treturn null;\n}\nif (interfaceVisibility != null)\n{\n\tswitch (interfaceVisibility)\n\t{\n\t\tcase IN_MODEL:\n\t\tcase INTERNAL:\n\t\t\t&lt;%de.fhdo.ddmm.service.Visibility%&gt; _visibility = this.getVisibility();\n\t\t\tboolean _tripleEquals_1 = (_visibility == &lt;%de.fhdo.ddmm.service.Visibility%&gt;.NONE);\n\t\t\tif (_tripleEquals_1)\n\t\t\t{\n\t\t\t\treturn interfaceVisibility;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\t&lt;%de.fhdo.ddmm.service.Visibility%&gt; _visibility_1 = this.getVisibility();\n\t\t\t\tboolean _tripleEquals_2 = (_visibility_1 == &lt;%de.fhdo.ddmm.service.Visibility%&gt;.INTERNAL);\n\t\t\t\tif (_tripleEquals_2)\n\t\t\t\t{\n\t\t\t\t\treturn this.getVisibility();\n\t\t\t\t}\n\t\t\t}\n\t\t\tbreak;\n\t\tcase ARCHITECTURE:\n\t\t\t&lt;%de.fhdo.ddmm.service.Visibility%&gt; _visibility_2 = this.getVisibility();\n\t\t\tboolean _tripleEquals_3 = (_visibility_2 == &lt;%de.fhdo.ddmm.service.Visibility%&gt;.NONE);\n\t\t\tif (_tripleEquals_3)\n\t\t\t{\n\t\t\t\treturn interfaceVisibility;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif (((this.getVisibility() == &lt;%de.fhdo.ddmm.service.Visibility%&gt;.INTERNAL) || \n\t\t\t\t\t(this.getVisibility() == &lt;%de.fhdo.ddmm.service.Visibility%&gt;.ARCHITECTURE)))\n\t\t\t\t{\n\t\t\t\t\treturn this.getVisibility();\n\t\t\t\t}\n\t\t\t}\n\t\t\tbreak;\n\t\tcase PUBLIC:\n\t\t\t&lt;%de.fhdo.ddmm.service.Visibility%&gt; _visibility_3 = this.getVisibility();\n\t\t\tboolean _tripleEquals_4 = (_visibility_3 == &lt;%de.fhdo.ddmm.service.Visibility%&gt;.NONE);\n\t\t\tif (_tripleEquals_4)\n\t\t\t{\n\t\t\t\treturn interfaceVisibility;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif ((((this.getVisibility() == &lt;%de.fhdo.ddmm.service.Visibility%&gt;.INTERNAL) || \n\t\t\t\t\t(this.getVisibility() == &lt;%de.fhdo.ddmm.service.Visibility%&gt;.ARCHITECTURE)) || \n\t\t\t\t\t(this.getVisibility() == &lt;%de.fhdo.ddmm.service.Visibility%&gt;.PUBLIC)))\n\t\t\t\t{\n\t\t\t\t\treturn this.getVisibility();\n\t\t\t\t}\n\t\t\t}\n\t\t\tbreak;\n\t\tdefault:\n\t\t\treturn null;\n\t}\n}\nelse\n{\n\treturn null;\n}\nreturn null;'"
     * @generated
     */
    Visibility getEffectiveVisibility();

    /**
     * Returns the value of the '<em><b>Effectively Internal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Convenience method to check if an interface is effectively marked as being internal
     * <!-- end-model-doc -->
     * @return the value of the '<em>Effectively Internal</em>' attribute.
     * @see de.fhdo.ddmm.service.ServicePackage#getOperation_EffectivelyInternal()
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
     * Get parts of the operation for creating a qualified name
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; _xblockexpression = null;\n{\n\tif (((this.getName() == null) || this.getName().isEmpty()))\n\t{\n\t\treturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(&lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;newArrayList());\n\t}\n\tfinal &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; nameParts = this.getInterface().getQualifiedNameParts();\n\t&lt;%org.eclipse.xtext.xbase.lib.CollectionExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;addAll(nameParts, this.getName());\n\t_xblockexpression = &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(nameParts);\n}\nreturn _xblockexpression;'"
     * @generated
     */
    EList<String> getQualifiedNameParts();

} // Operation
