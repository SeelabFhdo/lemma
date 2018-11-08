/**
 */
package de.fhdo.ddmm.technology;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Aspect Pointcut Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A selector of pointcuts for join points
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspectPointcutSelector#getPointcuts <em>Pointcuts</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspectPointcutSelector#getServiceAspect <em>Service Aspect</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.ServiceAspectPointcutSelector#getSelectorString <em>Selector String</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspectPointcutSelector()
 * @model
 * @generated
 */
public interface ServiceAspectPointcutSelector extends EObject {
    /**
     * Returns the value of the '<em><b>Pointcuts</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.ServiceAspectPointcut}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.ServiceAspectPointcut#getSelector <em>Selector</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Per pointcut type only one pointcut may be specified in a selector.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Pointcuts</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspectPointcutSelector_Pointcuts()
     * @see de.fhdo.ddmm.technology.ServiceAspectPointcut#getSelector
     * @model opposite="selector" containment="true" required="true"
     * @generated
     */
    EList<ServiceAspectPointcut> getPointcuts();

    /**
     * Returns the value of the '<em><b>Service Aspect</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.ServiceAspect#getPointcutSelectors <em>Pointcut Selectors</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service Aspect</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Service Aspect</em>' container reference.
     * @see #setServiceAspect(ServiceAspect)
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspectPointcutSelector_ServiceAspect()
     * @see de.fhdo.ddmm.technology.ServiceAspect#getPointcutSelectors
     * @model opposite="pointcutSelectors" transient="false"
     * @generated
     */
    ServiceAspect getServiceAspect();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.ServiceAspectPointcutSelector#getServiceAspect <em>Service Aspect</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Service Aspect</em>' container reference.
     * @see #getServiceAspect()
     * @generated
     */
    void setServiceAspect(ServiceAspect value);

    /**
     * Returns the value of the '<em><b>Selector String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Return the selector string of this pointcut based on the DSL's grammar
     * <!-- end-model-doc -->
     * @return the value of the '<em>Selector String</em>' attribute.
     * @see de.fhdo.ddmm.technology.TechnologyPackage#getServiceAspectPointcutSelector_SelectorString()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='boolean _isEmpty = this.getPointcuts().isEmpty();\nif (_isEmpty)\n{\n\treturn \"\";\n}\nfinal &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.technology.PointcutType%&gt;&gt; orderedPointcutTypes = this.getPointcuts().get(0).getOrderedPointcutTypes();\n&lt;%java.lang.String%&gt; selectorString = \"\";\nfor (final &lt;%de.fhdo.ddmm.technology.PointcutType%&gt; pointcutType : orderedPointcutTypes)\n{\n\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t{\n\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt; it)\n\t\t{\n\t\t\t&lt;%de.fhdo.ddmm.technology.PointcutType%&gt; _effectiveType = it.getEffectiveType();\n\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(&lt;%com.google.common.base.Objects%&gt;.equal(_effectiveType, pointcutType));\n\t\t}\n\t};\n\t&lt;%java.lang.Iterable%&gt;&lt;&lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt;&gt; _filter = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt;&gt;filter(this.getPointcuts(), _function);\n\tfor (final &lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt; pointcut : _filter)\n\t{\n\t\t{\n\t\t\t&lt;%java.lang.String%&gt; _selectorString = selectorString;\n\t\t\t&lt;%java.lang.String%&gt; _effectiveSelectorName = pointcut.getEffectiveSelectorName();\n\t\t\t&lt;%java.lang.String%&gt; _plus = (_effectiveSelectorName + \" = \");\n\t\t\t&lt;%java.lang.String%&gt; _printableEffectiveValue = pointcut.getPrintableEffectiveValue();\n\t\t\t&lt;%java.lang.String%&gt; _plus_1 = (_plus + _printableEffectiveValue);\n\t\t\tselectorString = (_selectorString + _plus_1);\n\t\t\t&lt;%java.lang.String%&gt; _selectorString_1 = selectorString;\n\t\t\tselectorString = (_selectorString_1 + \", \");\n\t\t}\n\t}\n}\nint _length = selectorString.length();\nboolean _greaterThan = (_length &gt; 2);\nif (_greaterThan)\n{\n\tint _length_1 = selectorString.length();\n\tfinal int trailingCommaBegin = (_length_1 - 2);\n\tselectorString = selectorString.substring(0, trailingCommaBegin);\n}\nreturn selectorString;'"
     * @generated
     */
    String getSelectorString();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Check if the selector is more generic than the given selector. A selector is more generic
     * than another selector if it lacks certain pointcuts and overlapping pointcuts have the same
     * values in both selector. Take for instance the selector
     *      selector(protocol = rest, data_format = xml)
     * It is more generic than the selector
     *      selector(exchange_pattern = in, protocol = rest, data_format = xml)
     * but less generic than
     *      selector(protocol = rest)
     * <!-- end-model-doc -->
     * @model unique="false" otherSelectorUnique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if ((otherSelector == null))\n{\n\treturn true;\n}\nelse\n{\n\tif ((this == otherSelector))\n\t{\n\t\treturn false;\n\t}\n}\nfinal &lt;%java.util.Map%&gt;&lt;&lt;%de.fhdo.ddmm.technology.PointcutType%&gt;, &lt;%java.util.List%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt; thisSelectorValues = this.orderedSelectorValues();\nfinal &lt;%java.util.Map%&gt;&lt;&lt;%de.fhdo.ddmm.technology.PointcutType%&gt;, &lt;%java.util.List%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt; otherSelectorValues = otherSelector.orderedSelectorValues();\n&lt;%java.util.Set%&gt;&lt;&lt;%java.util.Map.Entry%&gt;&lt;&lt;%de.fhdo.ddmm.technology.PointcutType%&gt;, &lt;%java.util.List%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt;&gt; _entrySet = thisSelectorValues.entrySet();\nfor (final &lt;%java.util.Map.Entry%&gt;&lt;&lt;%de.fhdo.ddmm.technology.PointcutType%&gt;, &lt;%java.util.List%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt; entry : _entrySet)\n{\n\t{\n\t\tfinal &lt;%de.fhdo.ddmm.technology.PointcutType%&gt; thisType = entry.getKey();\n\t\tfinal &lt;%java.util.List%&gt;&lt;&lt;%java.lang.String%&gt;&gt; thisValuesOfType = entry.getValue();\n\t\tfinal &lt;%java.util.List%&gt;&lt;&lt;%java.lang.String%&gt;&gt; otherValuesOfType = otherSelectorValues.get(thisType);\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%java.lang.String%&gt; it)\n\t\t\t{\n\t\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(otherValuesOfType.contains(it));\n\t\t\t}\n\t\t};\n\t\tboolean _exists = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;exists(thisValuesOfType, _function);\n\t\tif (_exists)\n\t\t{\n\t\t\totherValuesOfType.removeAll(thisValuesOfType);\n\t\t\tboolean _isEmpty = otherValuesOfType.isEmpty();\n\t\t\tif (_isEmpty)\n\t\t\t{\n\t\t\t\totherSelectorValues.remove(thisType);\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\treturn false;\n\t\t}\n\t}\n}\nboolean thisHasMorePointcuts = otherSelectorValues.isEmpty();\nreturn (!thisHasMorePointcuts);'"
     * @generated
     */
    boolean isMoreGenericThan(ServiceAspectPointcutSelector otherSelector);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Return values of the selector's pointcuts ordered by their types. The return type is a map
     * that preserves the insertion order and assigns a pointcut type to a list of values specified
     * for it in the selector. The ordering of the types matches the ordering as returned by
     * ServiceAspectPointcut.orderedPointcutTypes.
     * <!-- end-model-doc -->
     * @model dataType="de.fhdo.ddmm.technology.PointcutTypeStringsMap" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _isEmpty = this.getPointcuts().isEmpty();\nif (_isEmpty)\n{\n\treturn null;\n}\nfinal &lt;%java.util.LinkedHashMap%&gt;&lt;&lt;%de.fhdo.ddmm.technology.PointcutType%&gt;, &lt;%java.util.List%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt; orderedValues = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.PointcutType%&gt;, &lt;%java.util.List%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt;newLinkedHashMap();\nfinal &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%de.fhdo.ddmm.technology.PointcutType%&gt;&gt; orderedPointcutTypes = this.getPointcuts().get(0).getOrderedPointcutTypes();\nfinal &lt;%java.util.function.Consumer%&gt;&lt;&lt;%de.fhdo.ddmm.technology.PointcutType%&gt;&gt; _function = new &lt;%java.util.function.Consumer%&gt;&lt;&lt;%de.fhdo.ddmm.technology.PointcutType%&gt;&gt;()\n{\n\tpublic void accept(final &lt;%de.fhdo.ddmm.technology.PointcutType%&gt; pointcutType)\n\t{\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt; it)\n\t\t\t{\n\t\t\t\t&lt;%de.fhdo.ddmm.technology.PointcutType%&gt; _effectiveType = it.getEffectiveType();\n\t\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(&lt;%com.google.common.base.Objects%&gt;.equal(_effectiveType, pointcutType));\n\t\t\t}\n\t\t};\n\t\tfinal &lt;%java.util.function.Consumer%&gt;&lt;&lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt;&gt; _function_1 = new &lt;%java.util.function.Consumer%&gt;&lt;&lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt;&gt;()\n\t\t{\n\t\t\tpublic void accept(final &lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt; it)\n\t\t\t{\n\t\t\t\t&lt;%java.util.List%&gt;&lt;&lt;%java.lang.String%&gt;&gt; pointcutStrings = orderedValues.get(pointcutType);\n\t\t\t\tif ((pointcutStrings == null))\n\t\t\t\t{\n\t\t\t\t\tpointcutStrings = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;newArrayList();\n\t\t\t\t\torderedValues.put(pointcutType, pointcutStrings);\n\t\t\t\t}\n\t\t\t\tpointcutStrings.add(it.getEffectiveValue());\n\t\t\t}\n\t\t};\n\t\t&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.technology.ServiceAspectPointcut%&gt;&gt;filter(&lt;%this%&gt;.getPointcuts(), _function).forEach(_function_1);\n\t}\n};\norderedPointcutTypes.forEach(_function);\nreturn orderedValues;'"
     * @generated
     */
    Map<PointcutType, List<String>> orderedSelectorValues();

} // ServiceAspectPointcutSelector
