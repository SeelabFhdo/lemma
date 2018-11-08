/**
 */
package de.fhdo.ddmm.technology;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Aspect Pointcut</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Pointcut of a service aspect
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#isForExchangePattern <em>For Exchange Pattern</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#isForCommunicationType <em>For Communication Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#isForProtocol <em>For Protocol</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#isForDataFormat <em>For Data Format</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#getExchangePattern <em>Exchange Pattern</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#getDataFormat <em>Data Format</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#getSelector <em>Selector</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#getEffectiveType <em>Effective Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#getEffectiveSelectorName <em>Effective Selector Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#getEffectiveValue <em>Effective Value</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#getPrintableEffectiveValue <em>Printable Effective Value</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#getOrderedPointcutTypes <em>Ordered Pointcut Types</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspectPointcut()
 * @model
 * @generated
 */
public interface ServiceAspectPointcut extends EObject {
    /**
     * Returns the value of the '<em><b>For Exchange Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) For exchange pattern and communication type pointcuts the selector's join point must
     *          be parameters.
     *          Ensured by: DSL validator.
     *     (C2) If communication types were selected, protocols of parent selector must be of those
     *          types.
     *          Ensured by: DSL scope provider.
     *     (C3) If protocols were selected, data formats of parent selector must correspond to them.
     *          Ensured by: DSL scope provider.
     * <!-- end-model-doc -->
     * @return the value of the '<em>For Exchange Pattern</em>' attribute.
     * @see #setForExchangePattern(boolean)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspectPointcut_ForExchangePattern()
     * @model unique="false"
     * @generated
     */
    boolean isForExchangePattern();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#isForExchangePattern <em>For Exchange Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>For Exchange Pattern</em>' attribute.
     * @see #isForExchangePattern()
     * @generated
     */
    void setForExchangePattern(boolean value);

    /**
     * Returns the value of the '<em><b>For Communication Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>For Communication Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>For Communication Type</em>' attribute.
     * @see #setForCommunicationType(boolean)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspectPointcut_ForCommunicationType()
     * @model unique="false"
     * @generated
     */
    boolean isForCommunicationType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#isForCommunicationType <em>For Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>For Communication Type</em>' attribute.
     * @see #isForCommunicationType()
     * @generated
     */
    void setForCommunicationType(boolean value);

    /**
     * Returns the value of the '<em><b>For Protocol</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>For Protocol</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>For Protocol</em>' attribute.
     * @see #setForProtocol(boolean)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspectPointcut_ForProtocol()
     * @model unique="false"
     * @generated
     */
    boolean isForProtocol();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#isForProtocol <em>For Protocol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>For Protocol</em>' attribute.
     * @see #isForProtocol()
     * @generated
     */
    void setForProtocol(boolean value);

    /**
     * Returns the value of the '<em><b>For Data Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>For Data Format</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>For Data Format</em>' attribute.
     * @see #setForDataFormat(boolean)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspectPointcut_ForDataFormat()
     * @model unique="false"
     * @generated
     */
    boolean isForDataFormat();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#isForDataFormat <em>For Data Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>For Data Format</em>' attribute.
     * @see #isForDataFormat()
     * @generated
     */
    void setForDataFormat(boolean value);

    /**
     * Returns the value of the '<em><b>Exchange Pattern</b></em>' attribute.
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
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspectPointcut_ExchangePattern()
     * @model unique="false"
     * @generated
     */
    ExchangePattern getExchangePattern();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#getExchangePattern <em>Exchange Pattern</em>}' attribute.
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
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspectPointcut_CommunicationType()
     * @model unique="false"
     * @generated
     */
    CommunicationType getCommunicationType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#getCommunicationType <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Communication Type</em>' attribute.
     * @see de.fhdo.ddmm.technology.CommunicationType
     * @see #getCommunicationType()
     * @generated
     */
    void setCommunicationType(CommunicationType value);

    /**
     * Returns the value of the '<em><b>Protocol</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Protocol</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocol</em>' reference.
     * @see #setProtocol(Protocol)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspectPointcut_Protocol()
     * @model
     * @generated
     */
    Protocol getProtocol();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#getProtocol <em>Protocol</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Protocol</em>' reference.
     * @see #getProtocol()
     * @generated
     */
    void setProtocol(Protocol value);

    /**
     * Returns the value of the '<em><b>Data Format</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Format</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Format</em>' reference.
     * @see #setDataFormat(DataFormat)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspectPointcut_DataFormat()
     * @model
     * @generated
     */
    DataFormat getDataFormat();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#getDataFormat <em>Data Format</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Format</em>' reference.
     * @see #getDataFormat()
     * @generated
     */
    void setDataFormat(DataFormat value);

    /**
     * Returns the value of the '<em><b>Selector</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.ServiceAspectPointcutSelector#getPointcuts <em>Pointcuts</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Selector</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Selector</em>' container reference.
     * @see #setSelector(ServiceAspectPointcutSelector)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspectPointcut_Selector()
     * @see de.fhdo.ddmm.technology.ServiceAspectPointcutSelector#getPointcuts
     * @model opposite="pointcuts" transient="false"
     * @generated
     */
    ServiceAspectPointcutSelector getSelector();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#getSelector <em>Selector</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Selector</em>' container reference.
     * @see #getSelector()
     * @generated
     */
    void setSelector(ServiceAspectPointcutSelector value);

    /**
     * Returns the value of the '<em><b>Effective Type</b></em>' attribute.
     * The literals are from the enumeration {@link de.fhdo.ddmm.technology.PointcutType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Convenience method to get type of pointcut depending on the boolean flags that actually
     * determine its semantics
     * <!-- end-model-doc -->
     * @return the value of the '<em>Effective Type</em>' attribute.
     * @see de.fhdo.ddmm.technology.PointcutType
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspectPointcut_EffectiveType()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%de.fhdo.ddmm.technology.PointcutType%&gt; _xifexpression = null;\nboolean _isForExchangePattern = this.isForExchangePattern();\nif (_isForExchangePattern)\n{\n\t_xifexpression = &lt;%de.fhdo.ddmm.technology.PointcutType%&gt;.EXCHANGE_PATTERN;\n}\nelse\n{\n\t&lt;%de.fhdo.ddmm.technology.PointcutType%&gt; _xifexpression_1 = null;\n\tboolean _isForCommunicationType = this.isForCommunicationType();\n\tif (_isForCommunicationType)\n\t{\n\t\t_xifexpression_1 = &lt;%de.fhdo.ddmm.technology.PointcutType%&gt;.COMMUNICATION_TYPE;\n\t}\n\telse\n\t{\n\t\t&lt;%de.fhdo.ddmm.technology.PointcutType%&gt; _xifexpression_2 = null;\n\t\tboolean _isForProtocol = this.isForProtocol();\n\t\tif (_isForProtocol)\n\t\t{\n\t\t\t_xifexpression_2 = &lt;%de.fhdo.ddmm.technology.PointcutType%&gt;.PROTOCOL;\n\t\t}\n\t\telse\n\t\t{\n\t\t\t&lt;%de.fhdo.ddmm.technology.PointcutType%&gt; _xifexpression_3 = null;\n\t\t\tboolean _isForDataFormat = this.isForDataFormat();\n\t\t\tif (_isForDataFormat)\n\t\t\t{\n\t\t\t\t_xifexpression_3 = &lt;%de.fhdo.ddmm.technology.PointcutType%&gt;.DATA_FORMAT;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\t_xifexpression_3 = null;\n\t\t\t}\n\t\t\t_xifexpression_2 = _xifexpression_3;\n\t\t}\n\t\t_xifexpression_1 = _xifexpression_2;\n\t}\n\t_xifexpression = _xifexpression_1;\n}\nreturn _xifexpression;'"
     * @generated
     */
    PointcutType getEffectiveType();

    /**
     * Returns the value of the '<em><b>Effective Selector Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get selector name of pointcut depending on its type. It must match the one declared in the
     * grammar of the DSL
     * <!-- end-model-doc -->
     * @return the value of the '<em>Effective Selector Name</em>' attribute.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspectPointcut_EffectiveSelectorName()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%java.lang.String%&gt; _switchResult = null;\n&lt;%de.fhdo.ddmm.technology.PointcutType%&gt; _effectiveType = this.getEffectiveType();\nif (_effectiveType != null)\n{\n\tswitch (_effectiveType)\n\t{\n\t\tcase EXCHANGE_PATTERN:\n\t\t\t_switchResult = \"exchange_pattern\";\n\t\t\tbreak;\n\t\tcase COMMUNICATION_TYPE:\n\t\t\t_switchResult = \"communication_type\";\n\t\t\tbreak;\n\t\tcase PROTOCOL:\n\t\t\t_switchResult = \"protocol\";\n\t\t\tbreak;\n\t\tcase DATA_FORMAT:\n\t\t\t_switchResult = \"data_format\";\n\t\t\tbreak;\n\t\tdefault:\n\t\t\t_switchResult = null;\n\t\t\tbreak;\n\t}\n}\nelse\n{\n\t_switchResult = null;\n}\nreturn _switchResult;'"
     * @generated
     */
    String getEffectiveSelectorName();

    /**
     * Returns the value of the '<em><b>Effective Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get effective value of pointcut depending on its type
     * <!-- end-model-doc -->
     * @return the value of the '<em>Effective Value</em>' attribute.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspectPointcut_EffectiveValue()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%java.lang.String%&gt; _xifexpression = null;\nif (((this.getEffectiveType() == &lt;%de.fhdo.ddmm.technology.PointcutType%&gt;.EXCHANGE_PATTERN) &amp;&amp; (this.getExchangePattern() != null)))\n{\n\t_xifexpression = this.getExchangePattern().getName();\n}\nelse\n{\n\t&lt;%java.lang.String%&gt; _xifexpression_1 = null;\n\tif (((this.getEffectiveType() == &lt;%de.fhdo.ddmm.technology.PointcutType%&gt;.COMMUNICATION_TYPE) &amp;&amp; (this.getCommunicationType() != null)))\n\t{\n\t\t_xifexpression_1 = this.getCommunicationType().getName();\n\t}\n\telse\n\t{\n\t\t&lt;%java.lang.String%&gt; _xifexpression_2 = null;\n\t\tif (((this.getEffectiveType() == &lt;%de.fhdo.ddmm.technology.PointcutType%&gt;.PROTOCOL) &amp;&amp; (this.getProtocol() != null)))\n\t\t{\n\t\t\t_xifexpression_2 = this.getProtocol().getName();\n\t\t}\n\t\telse\n\t\t{\n\t\t\t&lt;%java.lang.String%&gt; _xifexpression_3 = null;\n\t\t\tif (((this.getEffectiveType() == &lt;%de.fhdo.ddmm.technology.PointcutType%&gt;.DATA_FORMAT) &amp;&amp; (this.getDataFormat() != null)))\n\t\t\t{\n\t\t\t\t_xifexpression_3 = this.getDataFormat().getFormatName();\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\t_xifexpression_3 = null;\n\t\t\t}\n\t\t\t_xifexpression_2 = _xifexpression_3;\n\t\t}\n\t\t_xifexpression_1 = _xifexpression_2;\n\t}\n\t_xifexpression = _xifexpression_1;\n}\nreturn _xifexpression;'"
     * @generated
     */
    String getEffectiveValue();

    /**
     * Returns the value of the '<em><b>Printable Effective Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Return printable effective value of pointcut as it would occur in the grammar of the DSL
     * <!-- end-model-doc -->
     * @return the value of the '<em>Printable Effective Value</em>' attribute.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspectPointcut_PrintableEffectiveValue()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%java.lang.String%&gt; _xifexpression = null;\nif (((this.getEffectiveType() == &lt;%de.fhdo.ddmm.technology.PointcutType%&gt;.EXCHANGE_PATTERN) &amp;&amp; (this.getExchangePattern() != null)))\n{\n\t_xifexpression = this.getExchangePattern().getName().toLowerCase();\n}\nelse\n{\n\t&lt;%java.lang.String%&gt; _xifexpression_1 = null;\n\tif (((this.getEffectiveType() == &lt;%de.fhdo.ddmm.technology.PointcutType%&gt;.COMMUNICATION_TYPE) &amp;&amp; \n\t\t&lt;%com.google.common.base.Objects%&gt;.equal(&lt;%de.fhdo.ddmm.technology.CommunicationType%&gt;.ASYNCHRONOUS, this.getCommunicationType())))\n\t{\n\t\t_xifexpression_1 = \"async\";\n\t}\n\telse\n\t{\n\t\t&lt;%java.lang.String%&gt; _xifexpression_2 = null;\n\t\tif (((this.getEffectiveType() == &lt;%de.fhdo.ddmm.technology.PointcutType%&gt;.COMMUNICATION_TYPE) &amp;&amp; \n\t\t\t&lt;%com.google.common.base.Objects%&gt;.equal(&lt;%de.fhdo.ddmm.technology.CommunicationType%&gt;.SYNCHRONOUS, this.getCommunicationType())))\n\t\t{\n\t\t\t_xifexpression_2 = \"sync\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\t&lt;%java.lang.String%&gt; _xifexpression_3 = null;\n\t\t\tif (((this.getEffectiveType() == &lt;%de.fhdo.ddmm.technology.PointcutType%&gt;.PROTOCOL) &amp;&amp; (this.getProtocol() != null)))\n\t\t\t{\n\t\t\t\t_xifexpression_3 = this.getProtocol().getName();\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\t&lt;%java.lang.String%&gt; _xifexpression_4 = null;\n\t\t\t\tif (((this.getEffectiveType() == &lt;%de.fhdo.ddmm.technology.PointcutType%&gt;.DATA_FORMAT) &amp;&amp; (this.getDataFormat() != null)))\n\t\t\t\t{\n\t\t\t\t\t_xifexpression_4 = this.getDataFormat().getFormatName();\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t_xifexpression_4 = null;\n\t\t\t\t}\n\t\t\t\t_xifexpression_3 = _xifexpression_4;\n\t\t\t}\n\t\t\t_xifexpression_2 = _xifexpression_3;\n\t\t}\n\t\t_xifexpression_1 = _xifexpression_2;\n\t}\n\t_xifexpression = _xifexpression_1;\n}\nreturn _xifexpression;'"
     * @generated
     */
    String getPrintableEffectiveValue();

    /**
     * Returns the value of the '<em><b>Ordered Pointcut Types</b></em>' attribute list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.PointcutType}.
     * The literals are from the enumeration {@link de.fhdo.ddmm.technology.PointcutType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get all possible types of pointcuts in an ordered manner
     * <!-- end-model-doc -->
     * @return the value of the '<em>Ordered Pointcut Types</em>' attribute list.
     * @see de.fhdo.ddmm.technology.PointcutType
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspectPointcut_OrderedPointcutTypes()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.PointcutType%&gt;&gt;asEList(java.util.Collections.&lt;&lt;%de.fhdo.ddmm.technology.PointcutType%&gt;&gt;unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.&lt;&lt;%de.fhdo.ddmm.technology.PointcutType%&gt;&gt;newArrayList(&lt;%de.fhdo.ddmm.technology.PointcutType%&gt;.EXCHANGE_PATTERN, &lt;%de.fhdo.ddmm.technology.PointcutType%&gt;.COMMUNICATION_TYPE, &lt;%de.fhdo.ddmm.technology.PointcutType%&gt;.PROTOCOL, &lt;%de.fhdo.ddmm.technology.PointcutType%&gt;.DATA_FORMAT)));'"
     * @generated
     */
    EList<PointcutType> getOrderedPointcutTypes();

} // ServiceAspectPointcut
