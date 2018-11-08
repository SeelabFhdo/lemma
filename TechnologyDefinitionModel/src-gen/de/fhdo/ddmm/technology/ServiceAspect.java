/**
 */
package de.fhdo.ddmm.technology;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Aspect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Metamodel concept for aspects related to microservices and their elements
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspect#getPointcutSelectors <em>Pointcut Selectors</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspect#getTechnology <em>Technology</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspect()
 * @model
 * @generated
 */
public interface ServiceAspect extends TechnologyAspect {
    /**
     * Returns the value of the '<em><b>Pointcut Selectors</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.ServiceAspectPointcutSelector}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.ServiceAspectPointcutSelector#getServiceAspect <em>Service Aspect</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Selectors must be unique.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Pointcut Selectors</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspect_PointcutSelectors()
     * @see de.fhdo.ddmm.technology.ServiceAspectPointcutSelector#getServiceAspect
     * @model opposite="serviceAspect" containment="true"
     * @generated
     */
    EList<ServiceAspectPointcutSelector> getPointcutSelectors();

    /**
     * Returns the value of the '<em><b>Technology</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.Technology#getServiceAspects <em>Service Aspects</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Technology</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technology</em>' container reference.
     * @see #setTechnology(Technology)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspect_Technology()
     * @see de.fhdo.ddmm.technology.Technology#getServiceAspects
     * @model opposite="serviceAspects" transient="false"
     * @generated
     */
    Technology getTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.ServiceAspect#getTechnology <em>Technology</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Technology</em>' container reference.
     * @see #getTechnology()
     * @generated
     */
    void setTechnology(Technology value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Check if the aspect has a matching selector for the given pointcuts and their values.
     * Therefore, all pointcut values of a selector must be equal to the given values, i.e., the
     * matching is based on the logical conjunction of all pointcuts ("AND" semantics) as long as
     * their types differ. For pointcuts that receive more than one value in a selector (currently
     * prevented on the language-level by the validator), logical disjunction ("OR" semantics) is
     * applied. The pointcut values themselves are compared with the given values on the basis of
     * identify matching ("equal" semantics).
     * <!-- end-model-doc -->
     * @model unique="false" forExchangePatternUnique="false" forCommunicationTypeUnique="false" forProtocolUnique="false" forDataFormatUnique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _isEmpty = this.getPointcutSelectors().isEmpty();\nif (_isEmpty)\n{\n\treturn true;\n}\n&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.technology.ServiceAspectPointcutSelector%&gt;&gt; _pointcutSelectors = this.getPointcutSelectors();\nfor (final &lt;%de.fhdo.ddmm.technology.ServiceAspectPointcutSelector%&gt; selector : _pointcutSelectors)\n{\n\t{\n\t\t&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.technology.PointcutType%&gt;&gt; pointcutTypes = selector.getPointcuts().get(0).getOrderedPointcutTypes();\n\t\tboolean allPointcutsMatch = true;\n\t\tint pointcutTypeIndex = 0;\n\t\twhile ((allPointcutsMatch &amp;&amp; (pointcutTypeIndex &lt; pointcutTypes.size())))\n\t\t{\n\t\t\t{\n\t\t\t\tfinal &lt;%de.fhdo.ddmm.technology.PointcutType%&gt; pointcutType = pointcutTypes.get(pointcutTypeIndex);\n\t\t\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t\t\t\t{\n\t\t\t\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt; it)\n\t\t\t\t\t{\n\t\t\t\t\t\t&lt;%de.fhdo.ddmm.technology.PointcutType%&gt; _effectiveType = it.getEffectiveType();\n\t\t\t\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(&lt;%com.google.common.base.Objects%&gt;.equal(_effectiveType, pointcutType));\n\t\t\t\t\t}\n\t\t\t\t};\n\t\t\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt;, &lt;%java.lang.String%&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt;, &lt;%java.lang.String%&gt;&gt;()\n\t\t\t\t{\n\t\t\t\t\tpublic &lt;%java.lang.String%&gt; apply(final &lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt; it)\n\t\t\t\t\t{\n\t\t\t\t\t\treturn it.getEffectiveValue();\n\t\t\t\t\t}\n\t\t\t\t};\n\t\t\t\t&lt;%java.util.List%&gt;&lt;&lt;%java.lang.String%&gt;&gt; pointcutValuesOfType = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;toList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt;, &lt;%java.lang.String%&gt;&gt;map(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt;&gt;filter(selector.getPointcuts(), _function), _function_1));\n\t\t\t\t&lt;%java.lang.String%&gt; _switchResult = null;\n\t\t\t\tif (pointcutType != null)\n\t\t\t\t{\n\t\t\t\t\tswitch (pointcutType)\n\t\t\t\t\t{\n\t\t\t\t\t\tcase EXCHANGE_PATTERN:\n\t\t\t\t\t\t\t&lt;%java.lang.String%&gt; _xifexpression = null;\n\t\t\t\t\t\t\tif ((forExchangePattern != null))\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t_xifexpression = forExchangePattern.getName();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t_switchResult = _xifexpression;\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\tcase COMMUNICATION_TYPE:\n\t\t\t\t\t\t\t&lt;%java.lang.String%&gt; _xifexpression_1 = null;\n\t\t\t\t\t\t\tif ((forCommunicationType != null))\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t_xifexpression_1 = forCommunicationType.getName();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t_switchResult = _xifexpression_1;\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\tcase PROTOCOL:\n\t\t\t\t\t\t\t&lt;%java.lang.String%&gt; _xifexpression_2 = null;\n\t\t\t\t\t\t\tif ((forProtocol != null))\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t_xifexpression_2 = forProtocol.getName();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t_switchResult = _xifexpression_2;\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\tcase DATA_FORMAT:\n\t\t\t\t\t\t\t&lt;%java.lang.String%&gt; _xifexpression_3 = null;\n\t\t\t\t\t\t\tif ((forDataFormat != null))\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t_xifexpression_3 = forDataFormat.getFormatName();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t_switchResult = _xifexpression_3;\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\tdefault:\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t&lt;%java.lang.String%&gt; forValue = _switchResult;\n\t\t\t\tboolean _isEmpty_1 = pointcutValuesOfType.isEmpty();\n\t\t\t\tboolean _not = (!_isEmpty_1);\n\t\t\t\tif (_not)\n\t\t\t\t{\n\t\t\t\t\tif ((forValue != null))\n\t\t\t\t\t{\n\t\t\t\t\t\tallPointcutsMatch = pointcutValuesOfType.contains(forValue);\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tallPointcutsMatch = false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tpointcutTypeIndex++;\n\t\t\t}\n\t\t}\n\t\tif (allPointcutsMatch)\n\t\t{\n\t\t\treturn true;\n\t\t}\n\t}\n}\nreturn false;'"
     * @generated
     */
    boolean hasMatchingSelector(ExchangePattern forExchangePattern, CommunicationType forCommunicationType, Protocol forProtocol, DataFormat forDataFormat);

} // ServiceAspect
