/**
 */
package de.fhdo.lemma.operation;

import de.fhdo.lemma.data.PrimitiveValue;

import de.fhdo.lemma.service.Import;

import de.fhdo.lemma.technology.OperationAspect;
import de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Imported Operation Aspect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Metamodel concept for operation aspects being implicitly imported from a technology model
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.ImportedOperationAspect#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.ImportedOperationAspect#getAspect <em>Aspect</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.ImportedOperationAspect#getSinglePropertyValue <em>Single Property Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.ImportedOperationAspect#getValues <em>Values</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.ImportedOperationAspect#getOperationNode <em>Operation Node</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.OperationPackage#getImportedOperationAspect()
 * @model
 * @generated
 */
public interface ImportedOperationAspect extends EObject {
	/**
	 * Returns the value of the '<em><b>Technology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) An aspect may not be assigned twice to a concept instance.
	 *          Ensured by: DSL validator.
	 *     (C2) A single property value may only be assigned if the aspect has exactly one property.
	 *          Ensured by: DSL validator.
	 *     (C3) Property values must match the type of the aspect property as defined in the
	 *          technology being assigned to the parent microservice mapping.
	 *          Ensured by: DSL validator.
	 *     (C4) Mandatory properties must have values assigned.
	 *          Ensured by: DSL validator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Technology</em>' reference.
	 * @see #setTechnology(Import)
	 * @see de.fhdo.lemma.operation.OperationPackage#getImportedOperationAspect_Technology()
	 * @model
	 * @generated
	 */
	Import getTechnology();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.ImportedOperationAspect#getTechnology <em>Technology</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Technology</em>' reference.
	 * @see #getTechnology()
	 * @generated
	 */
	void setTechnology(Import value);

	/**
	 * Returns the value of the '<em><b>Aspect</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspect</em>' reference.
	 * @see #setAspect(OperationAspect)
	 * @see de.fhdo.lemma.operation.OperationPackage#getImportedOperationAspect_Aspect()
	 * @model
	 * @generated
	 */
	OperationAspect getAspect();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.ImportedOperationAspect#getAspect <em>Aspect</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aspect</em>' reference.
	 * @see #getAspect()
	 * @generated
	 */
	void setAspect(OperationAspect value);

	/**
	 * Returns the value of the '<em><b>Single Property Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Property Value</em>' containment reference.
	 * @see #setSinglePropertyValue(PrimitiveValue)
	 * @see de.fhdo.lemma.operation.OperationPackage#getImportedOperationAspect_SinglePropertyValue()
	 * @model containment="true"
	 * @generated
	 */
	PrimitiveValue getSinglePropertyValue();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.ImportedOperationAspect#getSinglePropertyValue <em>Single Property Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single Property Value</em>' containment reference.
	 * @see #getSinglePropertyValue()
	 * @generated
	 */
	void setSinglePropertyValue(PrimitiveValue value);

	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.OperationPackage#getImportedOperationAspect_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<TechnologySpecificPropertyValueAssignment> getValues();

	/**
	 * Returns the value of the '<em><b>Operation Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.OperationNode#getAspects <em>Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Node</em>' container reference.
	 * @see #setOperationNode(OperationNode)
	 * @see de.fhdo.lemma.operation.OperationPackage#getImportedOperationAspect_OperationNode()
	 * @see de.fhdo.lemma.operation.OperationNode#getAspects
	 * @model opposite="aspects" transient="false"
	 * @generated
	 */
	OperationNode getOperationNode();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.ImportedOperationAspect#getOperationNode <em>Operation Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Node</em>' container reference.
	 * @see #getOperationNode()
	 * @generated
	 */
	void setOperationNode(OperationNode value);

} // ImportedOperationAspect
