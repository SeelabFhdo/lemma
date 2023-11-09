/**
 */
package de.fhdo.lemma.data;

import java.math.BigDecimal;

import java.util.Date;
import java.util.Map;

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
 *   <li>{@link de.fhdo.lemma.data.PrimitiveValue#getStringValue <em>String Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.PrimitiveValue#getBooleanValue <em>Boolean Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.PrimitiveValue#getNumericValue <em>Numeric Value</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.DataPackage#getPrimitiveValue()
 * @model
 * @generated
 */
public interface PrimitiveValue extends EObject {
	/**
	 * Returns the value of the '<em><b>String Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Value</em>' attribute.
	 * @see #setStringValue(String)
	 * @see de.fhdo.lemma.data.DataPackage#getPrimitiveValue_StringValue()
	 * @model unique="false"
	 * @generated
	 */
	String getStringValue();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.PrimitiveValue#getStringValue <em>String Value</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boolean Value</em>' attribute.
	 * @see #setBooleanValue(Boolean)
	 * @see de.fhdo.lemma.data.DataPackage#getPrimitiveValue_BooleanValue()
	 * @model unique="false"
	 * @generated
	 */
	Boolean getBooleanValue();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.PrimitiveValue#getBooleanValue <em>Boolean Value</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numeric Value</em>' attribute.
	 * @see #setNumericValue(BigDecimal)
	 * @see de.fhdo.lemma.data.DataPackage#getPrimitiveValue_NumericValue()
	 * @model unique="false"
	 * @generated
	 */
	BigDecimal getNumericValue();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.PrimitiveValue#getNumericValue <em>Numeric Value</em>}' attribute.
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
	 * @generated
	 */
	Object asValueOfType(PrimitiveType primitiveType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get value as string. Returns an empty string if the instance hasNoValue(), i.e., when its
	 * effectively null.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 * @generated
	 */
	String valueAsString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Return value as boolean or null, if value is no boolean
	 * <!-- end-model-doc -->
	 * @model unique="false"
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
	 * @generated
	 */
	String asString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Infer names and sizes of all compatible types into which this value can be converted
	 * <!-- end-model-doc -->
	 * @model dataType="de.fhdo.lemma.data.TypeNameSizeMap" unique="false"
	 * @generated
	 */
	Map<String, Integer> inferCompatibleTypes();

} // PrimitiveValue
