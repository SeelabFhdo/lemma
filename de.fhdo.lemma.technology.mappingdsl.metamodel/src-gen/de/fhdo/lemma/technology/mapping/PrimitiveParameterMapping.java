/**
 */
package de.fhdo.lemma.technology.mapping;

import de.fhdo.lemma.service.Import;

import de.fhdo.lemma.technology.TechnologySpecificPrimitiveType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Parameter Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Technology mapping for primitively typed parameters
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.mapping.PrimitiveParameterMapping#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.PrimitiveParameterMapping#getPrimitiveType <em>Primitive Type</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getPrimitiveParameterMapping()
 * @model
 * @generated
 */
public interface PrimitiveParameterMapping extends ParameterMapping {
	/**
	 * Returns the value of the '<em><b>Technology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Technology</em>' reference.
	 * @see #setTechnology(Import)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getPrimitiveParameterMapping_Technology()
	 * @model
	 * @generated
	 */
	Import getTechnology();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.PrimitiveParameterMapping#getTechnology <em>Technology</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Technology</em>' reference.
	 * @see #getTechnology()
	 * @generated
	 */
	void setTechnology(Import value);

	/**
	 * Returns the value of the '<em><b>Primitive Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive Type</em>' reference.
	 * @see #setPrimitiveType(TechnologySpecificPrimitiveType)
	 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getPrimitiveParameterMapping_PrimitiveType()
	 * @model
	 * @generated
	 */
	TechnologySpecificPrimitiveType getPrimitiveType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.PrimitiveParameterMapping#getPrimitiveType <em>Primitive Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive Type</em>' reference.
	 * @see #getPrimitiveType()
	 * @generated
	 */
	void setPrimitiveType(TechnologySpecificPrimitiveType value);

} // PrimitiveParameterMapping
