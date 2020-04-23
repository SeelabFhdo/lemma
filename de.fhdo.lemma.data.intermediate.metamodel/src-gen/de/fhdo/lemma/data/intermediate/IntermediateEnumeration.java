/**
 */
package de.fhdo.lemma.data.intermediate;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Enumeration
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateEnumeration#getFields <em>Fields</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateEnumeration()
 * @model
 * @generated
 */
public interface IntermediateEnumeration extends IntermediateComplexType {
    /**
     * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateEnumerationField}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateEnumerationField#getEnumeration <em>Enumeration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Fields</em>' containment reference list.
     * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateEnumeration_Fields()
     * @see de.fhdo.lemma.data.intermediate.IntermediateEnumerationField#getEnumeration
     * @model opposite="enumeration" containment="true" required="true"
     * @generated
     */
    EList<IntermediateEnumerationField> getFields();

} // IntermediateEnumeration
