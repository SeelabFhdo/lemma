/**
 */
package de.fhdo.lemma.technology;

import de.fhdo.lemma.data.ComplexType;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specific Data Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A data structure type that is specific to a certain technology
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.TechnologySpecificDataStructure#getTechnology <em>Technology</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologySpecificDataStructure()
 * @model
 * @generated
 */
public interface TechnologySpecificDataStructure extends ComplexType {
	/**
	 * Returns the value of the '<em><b>Technology</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.Technology#getDataStructures <em>Data Structures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) Name must be unique.
	 *          Ensured by: DSL validator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Technology</em>' container reference.
	 * @see #setTechnology(Technology)
	 * @see de.fhdo.lemma.technology.TechnologyPackage#getTechnologySpecificDataStructure_Technology()
	 * @see de.fhdo.lemma.technology.Technology#getDataStructures
	 * @model opposite="dataStructures" transient="false"
	 * @generated
	 */
	Technology getTechnology();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.technology.TechnologySpecificDataStructure#getTechnology <em>Technology</em>}' container reference.
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
	 * Get parts of the type for creating a qualified name
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<String> getQualifiedNameParts();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Build qualified name from qualified name parts
	 * <!-- end-model-doc -->
	 * @model unique="false" separatorUnique="false"
	 * @generated
	 */
	String buildQualifiedName(String separator);

} // TechnologySpecificDataStructure
