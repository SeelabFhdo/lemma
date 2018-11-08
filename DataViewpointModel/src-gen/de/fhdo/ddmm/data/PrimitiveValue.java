/**
 */
package de.fhdo.ddmm.data;

import java.math.BigDecimal;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Primitive type value. In general, there are three "kinds" of values supported by the metamodel:
 *      (i) Numbers: Comprises values of primitive types byte, short, integer, long, float, and
 *                   double.
 *      (ii) Strings: Comprises values of primitive types character, string, and date.
 *      (iii) Boolean: True and false values.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.data.PrimitiveValue#getStringValue <em>String Value</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.PrimitiveValue#getBooleanValue <em>Boolean Value</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.PrimitiveValue#getNumericValue <em>Numeric Value</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.data.DataPackage#getPrimitiveValue()
 * @model
 * @generated
 */
public interface PrimitiveValue extends EObject {
    /**
     * Returns the value of the '<em><b>String Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>String Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>String Value</em>' attribute.
     * @see #setStringValue(String)
     * @see de.fhdo.ddmm.data.DataPackage#getPrimitiveValue_StringValue()
     * @model unique="false"
     * @generated
     */
    String getStringValue();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.PrimitiveValue#getStringValue <em>String Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>String Value</em>' attribute.
     * @see #getStringValue()
     * @generated
     */
    void setStringValue(String value);

    /**
     * Returns the value of the '<em><b>Boolean Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Boolean Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Boolean Value</em>' attribute.
     * @see #setBooleanValue(Boolean)
     * @see de.fhdo.ddmm.data.DataPackage#getPrimitiveValue_BooleanValue()
     * @model unique="false"
     * @generated
     */
    Boolean getBooleanValue();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.PrimitiveValue#getBooleanValue <em>Boolean Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Boolean Value</em>' attribute.
     * @see #getBooleanValue()
     * @generated
     */
    void setBooleanValue(Boolean value);

    /**
     * Returns the value of the '<em><b>Numeric Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Numeric Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Numeric Value</em>' attribute.
     * @see #setNumericValue(BigDecimal)
     * @see de.fhdo.ddmm.data.DataPackage#getPrimitiveValue_NumericValue()
     * @model unique="false"
     * @generated
     */
    BigDecimal getNumericValue();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.PrimitiveValue#getNumericValue <em>Numeric Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Numeric Value</em>' attribute.
     * @see #getNumericValue()
     * @generated
     */
    void setNumericValue(BigDecimal value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Check if numeric primitive value is in closed set [lowerBound, upperBound]. Returns false if
     * value is not numeric.
     * <!-- end-model-doc -->
     * @model unique="false" lowerBoundUnique="false" upperBoundUnique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.math.BigDecimal%&gt; _numericValue = this.getNumericValue();\nboolean _tripleEquals = (_numericValue == null);\nif (_tripleEquals)\n{\n\treturn false;\n}\nint _compareTo = this.getNumericValue().compareTo(lowerBound);\nfinal boolean outOfBoundLower = (_compareTo &lt; 0);\nint _compareTo_1 = this.getNumericValue().compareTo(upperBound);\nfinal boolean outOfBoundUpper = (_compareTo_1 &gt; 0);\nreturn ((!outOfBoundLower) &amp;&amp; (!outOfBoundUpper));'"
     * @generated
     */
    boolean isInClosedSet(BigDecimal lowerBound, BigDecimal upperBound);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Check if numeric value has decimals. Returns false if value is not numeric.
     * <!-- end-model-doc -->
     * @model unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.math.BigDecimal%&gt; _numericValue = this.getNumericValue();\nboolean _tripleEquals = (_numericValue == null);\nif (_tripleEquals)\n{\n\treturn false;\n}\n&lt;%java.math.BigDecimal%&gt; _numericValue_1 = this.getNumericValue();\n&lt;%java.math.BigDecimal%&gt; _bigDecimal = new &lt;%java.math.BigDecimal%&gt;(\"1\");\nfinal &lt;%java.math.BigDecimal%&gt; moduloOne = _numericValue_1.remainder(_bigDecimal);\nint _compareTo = moduloOne.compareTo(&lt;%java.math.BigDecimal%&gt;.ZERO);\nreturn (_compareTo != 0);'"
     * @generated
     */
    boolean hasDecimals();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Check if value is _exactly_ of the given primitive type
     * <!-- end-model-doc -->
     * @model unique="false" primitiveTypeUnique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.Object%&gt; _asValueOfType = this.asValueOfType(primitiveType);\nreturn (_asValueOfType != null);'"
     * @generated
     */
    boolean isOfType(PrimitiveType primitiveType);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Check if value does not contain a value of a primitive type
     * <!-- end-model-doc -->
     * @model unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (((this.getStringValue() == null) &amp;&amp; (this.getNumericValue() == null)) &amp;&amp; (this.getBooleanValue() == null));'"
     * @generated
     */
    boolean hasNoValue();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Cast encapsulated value to _exactly_ the given primitive type. If no _exact_ casting is
     * possible or the no primitive value is contained, return null.
     * <!-- end-model-doc -->
     * @model unique="false" primitiveTypeUnique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (((primitiveType == null) || this.hasNoValue()))\n{\n\treturn null;\n}\n&lt;%java.lang.Object%&gt; _switchResult = null;\nboolean _matched = false;\nif (primitiveType instanceof &lt;%de.fhdo.ddmm.data.PrimitiveBoolean%&gt;)\n{\n\t_matched=true;\n\t_switchResult = this.asBoolean();\n}\nif (!_matched)\n{\n\tif (primitiveType instanceof &lt;%de.fhdo.ddmm.data.PrimitiveByte%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = this.asByte();\n\t}\n}\nif (!_matched)\n{\n\tif (primitiveType instanceof &lt;%de.fhdo.ddmm.data.PrimitiveCharacter%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = this.asCharacter();\n\t}\n}\nif (!_matched)\n{\n\tif (primitiveType instanceof &lt;%de.fhdo.ddmm.data.PrimitiveDate%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = this.asDate();\n\t}\n}\nif (!_matched)\n{\n\tif (primitiveType instanceof &lt;%de.fhdo.ddmm.data.PrimitiveDouble%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = this.asDouble();\n\t}\n}\nif (!_matched)\n{\n\tif (primitiveType instanceof &lt;%de.fhdo.ddmm.data.PrimitiveFloat%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = this.asFloat();\n\t}\n}\nif (!_matched)\n{\n\tif (primitiveType instanceof &lt;%de.fhdo.ddmm.data.PrimitiveInteger%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = this.asInteger();\n\t}\n}\nif (!_matched)\n{\n\tif (primitiveType instanceof &lt;%de.fhdo.ddmm.data.PrimitiveLong%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = this.asLong();\n\t}\n}\nif (!_matched)\n{\n\tif (primitiveType instanceof &lt;%de.fhdo.ddmm.data.PrimitiveShort%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = this.asShort();\n\t}\n}\nif (!_matched)\n{\n\tif (primitiveType instanceof &lt;%de.fhdo.ddmm.data.PrimitiveString%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = this.asString();\n\t}\n}\nreturn _switchResult;'"
     * @generated
     */
    Object asValueOfType(PrimitiveType primitiveType);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Return value as boolean or null, if value is no boolean
     * <!-- end-model-doc -->
     * @model unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getBooleanValue();'"
     * @generated
     */
    Boolean asBoolean();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Return value as byte or null, if value is no byte
     * <!-- end-model-doc -->
     * @model unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.math.BigDecimal%&gt; _numericValue = this.getNumericValue();\nboolean _tripleEquals = (_numericValue == null);\nif (_tripleEquals)\n{\n\treturn null;\n}\nboolean _hasDecimals = this.hasDecimals();\nif (_hasDecimals)\n{\n\treturn null;\n}\n&lt;%java.math.BigDecimal%&gt; _bigDecimal = new &lt;%java.math.BigDecimal%&gt;(&lt;%java.lang.Byte%&gt;.MIN_VALUE);\n&lt;%java.math.BigDecimal%&gt; _bigDecimal_1 = new &lt;%java.math.BigDecimal%&gt;(&lt;%java.lang.Byte%&gt;.MAX_VALUE);\nboolean _isInClosedSet = this.isInClosedSet(_bigDecimal, _bigDecimal_1);\nboolean _not = (!_isInClosedSet);\nif (_not)\n{\n\treturn null;\n}\nreturn &lt;%java.lang.Byte%&gt;.valueOf(this.getNumericValue().byteValue());'"
     * @generated
     */
    Byte asByte();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Return value as character or null, if value is no character
     * <!-- end-model-doc -->
     * @model unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.String%&gt; _stringValue = this.getStringValue();\nboolean _tripleEquals = (_stringValue == null);\nif (_tripleEquals)\n{\n\treturn null;\n}\nboolean _isEmpty = this.getStringValue().isEmpty();\nif (_isEmpty)\n{\n\treturn &lt;%java.lang.Character%&gt;.valueOf(&lt;%java.lang.Character%&gt;.MIN_VALUE);\n}\nelse\n{\n\tint _length = this.getStringValue().length();\n\tboolean _tripleEquals_1 = (_length == 1);\n\tif (_tripleEquals_1)\n\t{\n\t\treturn &lt;%java.lang.Character%&gt;.valueOf(this.getStringValue().charAt(0));\n\t}\n}\nreturn null;'"
     * @generated
     */
    Character asCharacter();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Return value as date or null, if value is no date in Java's DateFormat.SHORT format
     * <!-- end-model-doc -->
     * @model unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.String%&gt; _stringValue = this.getStringValue();\nboolean _tripleEquals = (_stringValue == null);\nif (_tripleEquals)\n{\n\treturn null;\n}\ntry\n{\n\tfinal &lt;%java.text.DateFormat%&gt; dateFormatter = &lt;%java.text.DateFormat%&gt;.getDateInstance(&lt;%java.text.DateFormat%&gt;.SHORT);\n\treturn dateFormatter.parse(this.getStringValue());\n}\ncatch (final Throwable _t) {\n\tif (_t instanceof &lt;%java.text.ParseException%&gt;) {\n\t\tfinal &lt;%java.text.ParseException%&gt; ex = (&lt;%java.text.ParseException%&gt;)_t;\n\t\treturn null;\n\t}\n\telse\n\t{\n\t\tthrow &lt;%org.eclipse.xtext.xbase.lib.Exceptions%&gt;.sneakyThrow(_t);\n\t}\n}'"
     * @generated
     */
    Date asDate();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Return value as double or null, if value is no double
     * <!-- end-model-doc -->
     * @model unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.math.BigDecimal%&gt; _numericValue = this.getNumericValue();\nboolean _tripleEquals = (_numericValue == null);\nif (_tripleEquals)\n{\n\treturn null;\n}\n&lt;%java.math.BigDecimal%&gt; _bigDecimal = new &lt;%java.math.BigDecimal%&gt;(&lt;%java.lang.Double%&gt;.MIN_VALUE);\n&lt;%java.math.BigDecimal%&gt; _bigDecimal_1 = new &lt;%java.math.BigDecimal%&gt;(&lt;%java.lang.Double%&gt;.MAX_VALUE);\nboolean _isInClosedSet = this.isInClosedSet(_bigDecimal, _bigDecimal_1);\nboolean _not = (!_isInClosedSet);\nif (_not)\n{\n\treturn null;\n}\nfinal double doubleValue = this.getNumericValue().doubleValue();\nif (((!&lt;%java.lang.Double%&gt;.isNaN(doubleValue)) &amp;&amp; (!&lt;%java.lang.Double%&gt;.isInfinite(doubleValue))))\n{\n\treturn &lt;%java.lang.Double%&gt;.valueOf(doubleValue);\n}\nreturn null;'"
     * @generated
     */
    Double asDouble();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Return value as float or null, if value is no float
     * <!-- end-model-doc -->
     * @model unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.math.BigDecimal%&gt; _numericValue = this.getNumericValue();\nboolean _tripleEquals = (_numericValue == null);\nif (_tripleEquals)\n{\n\treturn null;\n}\n&lt;%java.math.BigDecimal%&gt; _bigDecimal = new &lt;%java.math.BigDecimal%&gt;(&lt;%java.lang.Float%&gt;.MIN_VALUE);\n&lt;%java.math.BigDecimal%&gt; _bigDecimal_1 = new &lt;%java.math.BigDecimal%&gt;(&lt;%java.lang.Float%&gt;.MAX_VALUE);\nboolean _isInClosedSet = this.isInClosedSet(_bigDecimal, _bigDecimal_1);\nboolean _not = (!_isInClosedSet);\nif (_not)\n{\n\treturn null;\n}\nfinal float floatValue = this.getNumericValue().floatValue();\nif (((!&lt;%java.lang.Float%&gt;.isNaN(floatValue)) &amp;&amp; (!&lt;%java.lang.Float%&gt;.isInfinite(floatValue))))\n{\n\treturn &lt;%java.lang.Float%&gt;.valueOf(floatValue);\n}\nreturn null;'"
     * @generated
     */
    Float asFloat();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Return value as integer or null, if value is no integer
     * <!-- end-model-doc -->
     * @model unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.math.BigDecimal%&gt; _numericValue = this.getNumericValue();\nboolean _tripleEquals = (_numericValue == null);\nif (_tripleEquals)\n{\n\treturn null;\n}\nboolean _hasDecimals = this.hasDecimals();\nif (_hasDecimals)\n{\n\treturn null;\n}\n&lt;%java.math.BigDecimal%&gt; _bigDecimal = new &lt;%java.math.BigDecimal%&gt;(&lt;%java.lang.Integer%&gt;.MIN_VALUE);\n&lt;%java.math.BigDecimal%&gt; _bigDecimal_1 = new &lt;%java.math.BigDecimal%&gt;(&lt;%java.lang.Integer%&gt;.MAX_VALUE);\nboolean _isInClosedSet = this.isInClosedSet(_bigDecimal, _bigDecimal_1);\nboolean _not = (!_isInClosedSet);\nif (_not)\n{\n\treturn null;\n}\ntry\n{\n\treturn &lt;%java.lang.Integer%&gt;.valueOf(this.getNumericValue().intValueExact());\n}\ncatch (final Throwable _t) {\n\tif (_t instanceof &lt;%java.lang.ArithmeticException%&gt;) {\n\t\tfinal &lt;%java.lang.ArithmeticException%&gt; ex = (&lt;%java.lang.ArithmeticException%&gt;)_t;\n\t\treturn null;\n\t}\n\telse\n\t{\n\t\tthrow &lt;%org.eclipse.xtext.xbase.lib.Exceptions%&gt;.sneakyThrow(_t);\n\t}\n}'"
     * @generated
     */
    Integer asInteger();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Return value as long or null, if value is no long
     * <!-- end-model-doc -->
     * @model unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.math.BigDecimal%&gt; _numericValue = this.getNumericValue();\nboolean _tripleEquals = (_numericValue == null);\nif (_tripleEquals)\n{\n\treturn null;\n}\nboolean _hasDecimals = this.hasDecimals();\nif (_hasDecimals)\n{\n\treturn null;\n}\n&lt;%java.math.BigDecimal%&gt; _bigDecimal = new &lt;%java.math.BigDecimal%&gt;(&lt;%java.lang.Long%&gt;.MIN_VALUE);\n&lt;%java.math.BigDecimal%&gt; _bigDecimal_1 = new &lt;%java.math.BigDecimal%&gt;(&lt;%java.lang.Long%&gt;.MAX_VALUE);\nboolean _isInClosedSet = this.isInClosedSet(_bigDecimal, _bigDecimal_1);\nboolean _not = (!_isInClosedSet);\nif (_not)\n{\n\treturn null;\n}\ntry\n{\n\treturn &lt;%java.lang.Long%&gt;.valueOf(this.getNumericValue().longValueExact());\n}\ncatch (final Throwable _t) {\n\tif (_t instanceof &lt;%java.lang.ArithmeticException%&gt;) {\n\t\tfinal &lt;%java.lang.ArithmeticException%&gt; ex = (&lt;%java.lang.ArithmeticException%&gt;)_t;\n\t\treturn null;\n\t}\n\telse\n\t{\n\t\tthrow &lt;%org.eclipse.xtext.xbase.lib.Exceptions%&gt;.sneakyThrow(_t);\n\t}\n}'"
     * @generated
     */
    Long asLong();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Return value as short or null, if value is no short
     * <!-- end-model-doc -->
     * @model unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.math.BigDecimal%&gt; _numericValue = this.getNumericValue();\nboolean _tripleEquals = (_numericValue == null);\nif (_tripleEquals)\n{\n\treturn null;\n}\nboolean _hasDecimals = this.hasDecimals();\nif (_hasDecimals)\n{\n\treturn null;\n}\n&lt;%java.math.BigDecimal%&gt; _bigDecimal = new &lt;%java.math.BigDecimal%&gt;(&lt;%java.lang.Short%&gt;.MIN_VALUE);\n&lt;%java.math.BigDecimal%&gt; _bigDecimal_1 = new &lt;%java.math.BigDecimal%&gt;(&lt;%java.lang.Short%&gt;.MAX_VALUE);\nboolean _isInClosedSet = this.isInClosedSet(_bigDecimal, _bigDecimal_1);\nboolean _not = (!_isInClosedSet);\nif (_not)\n{\n\treturn null;\n}\ntry\n{\n\treturn &lt;%java.lang.Short%&gt;.valueOf(this.getNumericValue().shortValueExact());\n}\ncatch (final Throwable _t) {\n\tif (_t instanceof &lt;%java.lang.ArithmeticException%&gt;) {\n\t\tfinal &lt;%java.lang.ArithmeticException%&gt; ex = (&lt;%java.lang.ArithmeticException%&gt;)_t;\n\t\treturn null;\n\t}\n\telse\n\t{\n\t\tthrow &lt;%org.eclipse.xtext.xbase.lib.Exceptions%&gt;.sneakyThrow(_t);\n\t}\n}'"
     * @generated
     */
    Short asShort();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Return value as string or null, if value is no string
     * <!-- end-model-doc -->
     * @model unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getStringValue();'"
     * @generated
     */
    String asString();

} // PrimitiveValue
