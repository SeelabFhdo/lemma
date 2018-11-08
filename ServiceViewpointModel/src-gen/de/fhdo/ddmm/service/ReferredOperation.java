/**
 */
package de.fhdo.ddmm.service;

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
 * interface mashups
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
     * Get parts of the referred operation for creating a qualified name
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; _xblockexpression = null;\n{\n\tif (((this.getOperation().getName() == null) || this.getOperation().getName().isEmpty()))\n\t{\n\t\treturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(&lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;newArrayList());\n\t}\n\tfinal &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; nameParts = this.getInterface().getQualifiedNameParts();\n\t&lt;%org.eclipse.xtext.xbase.lib.CollectionExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;addAll(nameParts, this.getOperation().getName());\n\t_xblockexpression = &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(nameParts);\n}\nreturn _xblockexpression;'"
     * @generated
     */
    EList<String> getQualifiedNameParts();

} // ReferredOperation
