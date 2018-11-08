/**
 */
package de.fhdo.ddmm.service;

import de.fhdo.ddmm.data.PrimitiveType;
import de.fhdo.ddmm.data.Type;

import de.fhdo.ddmm.technology.CommunicationType;
import de.fhdo.ddmm.technology.ExchangePattern;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.Parameter#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Parameter#getExchangePattern <em>Exchange Pattern</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Parameter#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Parameter#isCommunicatesFault <em>Communicates Fault</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Parameter#isOptional <em>Optional</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Parameter#getInitializedByOperation <em>Initialized By Operation</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Parameter#getImportedType <em>Imported Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Parameter#getPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Parameter#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.Parameter#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.ServicePackage#getParameter()
 * @model
 * @generated
 */
public interface Parameter extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Must have exactly one type, either imported or primitive.
     *          Ensured by: DSL grammar.
     *     (C2) Imported types may only come from a data or technology model.
     *          Ensured by: DSL scope provider.
     *     (C3) Import aliases for the initializing operation can only originate from imports of the
     *          concepts required by the parameter operation's microservice.
     *          Ensured by: DSL scope provider.
     *     (C4) Initializing operations can only originate from the list of directly or indirectly
     *          required operations of the microservice and they need to exhibit basic
     *          "initializability" (see the checking operation below).
     *          Ensured by: DSL scope provider.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.ddmm.service.ServicePackage#getParameter_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Parameter#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Exchange Pattern</b></em>' attribute.
     * The default value is <code>"IN"</code>.
     * The literals are from the enumeration {@link de.fhdo.ddmm.technology.ExchangePattern}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Exchange Pattern</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Exchange Pattern</em>' attribute.
     * @see de.fhdo.ddmm.technology.ExchangePattern
     * @see #setExchangePattern(ExchangePattern)
     * @see de.fhdo.ddmm.service.ServicePackage#getParameter_ExchangePattern()
     * @model default="IN" unique="false"
     * @generated
     */
    ExchangePattern getExchangePattern();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Parameter#getExchangePattern <em>Exchange Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Exchange Pattern</em>' attribute.
     * @see de.fhdo.ddmm.technology.ExchangePattern
     * @see #getExchangePattern()
     * @generated
     */
    void setExchangePattern(ExchangePattern value);

    /**
     * Returns the value of the '<em><b>Communication Type</b></em>' attribute.
     * The literals are from the enumeration {@link de.fhdo.ddmm.technology.CommunicationType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Communication Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Communication Type</em>' attribute.
     * @see de.fhdo.ddmm.technology.CommunicationType
     * @see #setCommunicationType(CommunicationType)
     * @see de.fhdo.ddmm.service.ServicePackage#getParameter_CommunicationType()
     * @model unique="false"
     * @generated
     */
    CommunicationType getCommunicationType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Parameter#getCommunicationType <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Communication Type</em>' attribute.
     * @see de.fhdo.ddmm.technology.CommunicationType
     * @see #getCommunicationType()
     * @generated
     */
    void setCommunicationType(CommunicationType value);

    /**
     * Returns the value of the '<em><b>Communicates Fault</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Communicates Fault</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Communicates Fault</em>' attribute.
     * @see #setCommunicatesFault(boolean)
     * @see de.fhdo.ddmm.service.ServicePackage#getParameter_CommunicatesFault()
     * @model default="false" unique="false"
     * @generated
     */
    boolean isCommunicatesFault();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Parameter#isCommunicatesFault <em>Communicates Fault</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Communicates Fault</em>' attribute.
     * @see #isCommunicatesFault()
     * @generated
     */
    void setCommunicatesFault(boolean value);

    /**
     * Returns the value of the '<em><b>Optional</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Optional</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Optional</em>' attribute.
     * @see #setOptional(boolean)
     * @see de.fhdo.ddmm.service.ServicePackage#getParameter_Optional()
     * @model default="false" unique="false"
     * @generated
     */
    boolean isOptional();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Parameter#isOptional <em>Optional</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Optional</em>' attribute.
     * @see #isOptional()
     * @generated
     */
    void setOptional(boolean value);

    /**
     * Returns the value of the '<em><b>Initialized By Operation</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.PossiblyImportedOperation#getInitializedParameter <em>Initialized Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Initialized By Operation</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Initialized By Operation</em>' containment reference.
     * @see #setInitializedByOperation(PossiblyImportedOperation)
     * @see de.fhdo.ddmm.service.ServicePackage#getParameter_InitializedByOperation()
     * @see de.fhdo.ddmm.service.PossiblyImportedOperation#getInitializedParameter
     * @model opposite="initializedParameter" containment="true"
     * @generated
     */
    PossiblyImportedOperation getInitializedByOperation();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Parameter#getInitializedByOperation <em>Initialized By Operation</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Initialized By Operation</em>' containment reference.
     * @see #getInitializedByOperation()
     * @generated
     */
    void setInitializedByOperation(PossiblyImportedOperation value);

    /**
     * Returns the value of the '<em><b>Imported Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Imported Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Imported Type</em>' containment reference.
     * @see #setImportedType(ImportedType)
     * @see de.fhdo.ddmm.service.ServicePackage#getParameter_ImportedType()
     * @model containment="true"
     * @generated
     */
    ImportedType getImportedType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Parameter#getImportedType <em>Imported Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Imported Type</em>' containment reference.
     * @see #getImportedType()
     * @generated
     */
    void setImportedType(ImportedType value);

    /**
     * Returns the value of the '<em><b>Primitive Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Primitive Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Primitive Type</em>' containment reference.
     * @see #setPrimitiveType(PrimitiveType)
     * @see de.fhdo.ddmm.service.ServicePackage#getParameter_PrimitiveType()
     * @model containment="true"
     * @generated
     */
    PrimitiveType getPrimitiveType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Parameter#getPrimitiveType <em>Primitive Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Primitive Type</em>' containment reference.
     * @see #getPrimitiveType()
     * @generated
     */
    void setPrimitiveType(PrimitiveType value);

    /**
     * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.ImportedServiceAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.ImportedServiceAspect#getParameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getParameter_Aspects()
     * @see de.fhdo.ddmm.service.ImportedServiceAspect#getParameter
     * @model opposite="parameter" containment="true"
     * @generated
     */
    EList<ImportedServiceAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Operation</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Operation#getParameters <em>Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation</em>' container reference.
     * @see #setOperation(Operation)
     * @see de.fhdo.ddmm.service.ServicePackage#getParameter_Operation()
     * @see de.fhdo.ddmm.service.Operation#getParameters
     * @model opposite="parameters" transient="false"
     * @generated
     */
    Operation getOperation();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.Parameter#getOperation <em>Operation</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation</em>' container reference.
     * @see #getOperation()
     * @generated
     */
    void setOperation(Operation value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Check if a parameter is _basically_ initializable by a given operation. This basic check does
     * not include the comparatively "expensive" type compatibility checking, but only those formal
     * checks that are based on direct characteristics of the parameter and the initializing
     * operation.
     * <!-- end-model-doc -->
     * @model unique="false" initializingOperationUnique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if ((((this.getOperation() == null) || \n\t(this.getOperation().getInterface() == null)) || \n\t(this.getOperation().getInterface().getMicroservice() == null)))\n{\n\treturn false;\n}\nif ((((initializingOperation == null) || \n\t(initializingOperation.getInterface() == null)) || \n\t(initializingOperation.getInterface().getMicroservice() == null)))\n{\n\treturn false;\n}\nif (((this.getExchangePattern() != &lt;%de.fhdo.ddmm.technology.ExchangePattern%&gt;.IN) &amp;&amp; \n\t(this.getExchangePattern() != &lt;%de.fhdo.ddmm.technology.ExchangePattern%&gt;.INOUT)))\n{\n\treturn false;\n}\n&lt;%de.fhdo.ddmm.service.Operation%&gt; _operation = this.getOperation();\nboolean _equals = &lt;%com.google.common.base.Objects%&gt;.equal(initializingOperation, _operation);\nif (_equals)\n{\n\treturn false;\n}\nboolean _isEffectivelyNotImplemented = initializingOperation.isEffectivelyNotImplemented();\nif (_isEffectivelyNotImplemented)\n{\n\treturn false;\n}\nfinal &lt;%de.fhdo.ddmm.service.Microservice%&gt; thisMicroservice = this.getOperation().getInterface().getMicroservice();\nfinal &lt;%de.fhdo.ddmm.service.Microservice%&gt; initializingMicroservice = initializingOperation.getInterface().getMicroservice();\nfinal boolean initializingOperationFromSameMicroservice = &lt;%com.google.common.base.Objects%&gt;.equal(thisMicroservice, initializingMicroservice);\nif ((initializingOperation.isEffectivelyInternal() &amp;&amp; (!initializingOperationFromSameMicroservice)))\n{\n\treturn false;\n}\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Parameter%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.Parameter%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.service.Parameter%&gt; it)\n\t{\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(((it.getExchangePattern() == &lt;%de.fhdo.ddmm.technology.ExchangePattern%&gt;.INOUT) || \n\t\t\t(it.getExchangePattern() == &lt;%de.fhdo.ddmm.technology.ExchangePattern%&gt;.OUT)));\n\t}\n};\nfinal boolean operationHasOutgoingParameters = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.Parameter%&gt;&gt;exists(initializingOperation.getParameters(), _function);\nif ((!operationHasOutgoingParameters))\n{\n\treturn false;\n}\nreturn true;'"
     * @generated
     */
    boolean basicallyInitializableBy(Operation initializingOperation);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get effective type of parameter, i.e., the primitive or imported type (null otherwise)
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%de.fhdo.ddmm.data.PrimitiveType%&gt; _primitiveType = this.getPrimitiveType();\nboolean _tripleNotEquals = (_primitiveType != null);\nif (_tripleNotEquals)\n{\n\treturn this.getPrimitiveType();\n}\nelse\n{\n\tif (((this.getImportedType() != null) &amp;&amp; (this.getImportedType().getType() != null)))\n\t{\n\t\treturn this.getImportedType().getType();\n\t}\n\telse\n\t{\n\t\treturn null;\n\t}\n}'"
     * @generated
     */
    Type getEffectiveType();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get parts of the parameter for creating a qualified name depending on its effective type
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%de.fhdo.ddmm.data.Type%&gt; effectiveType = this.getEffectiveType();\nif ((effectiveType == null))\n{\n\treturn null;\n}\nelse\n{\n\tif ((effectiveType instanceof &lt;%de.fhdo.ddmm.technology.TechnologySpecificPrimitiveType%&gt;))\n\t{\n\t\treturn ((&lt;%de.fhdo.ddmm.technology.TechnologySpecificPrimitiveType%&gt;)effectiveType).getQualifiedNameParts();\n\t}\n\telse\n\t{\n\t\tif ((effectiveType instanceof &lt;%de.fhdo.ddmm.data.PrimitiveType%&gt;))\n\t\t{\n\t\t\tfinal &lt;%java.util.ArrayList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; qualifiedNameParts = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;newArrayList();\n\t\t\tqualifiedNameParts.add(((&lt;%de.fhdo.ddmm.data.PrimitiveType%&gt;)effectiveType).getTypeName());\n\t\t\treturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(qualifiedNameParts);\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif ((effectiveType instanceof &lt;%de.fhdo.ddmm.data.ComplexType%&gt;))\n\t\t\t{\n\t\t\t\treturn ((&lt;%de.fhdo.ddmm.data.ComplexType%&gt;)effectiveType).getQualifiedNameParts();\n\t\t\t}\n\t\t}\n\t}\n}\nreturn null;'"
     * @generated
     */
    EList<String> getEffectiveTypeQualifiedNameParts();

} // Parameter
