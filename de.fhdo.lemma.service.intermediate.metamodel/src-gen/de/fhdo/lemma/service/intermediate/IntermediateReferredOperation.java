/**
 */
package de.fhdo.lemma.service.intermediate;

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Referred Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Referred operation
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getNameInReferringInterface <em>Name In Referring Interface</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getQualifiedNameInReferringInterface <em>Qualified Name In Referring Interface</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getReferringInterface <em>Referring Interface</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateReferredOperation()
 * @model
 * @generated
 */
public interface IntermediateReferredOperation extends EObject {
	/**
	 * Returns the value of the '<em><b>Name In Referring Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name In Referring Interface</em>' attribute.
	 * @see #setNameInReferringInterface(String)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateReferredOperation_NameInReferringInterface()
	 * @model unique="false"
	 * @generated
	 */
	String getNameInReferringInterface();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getNameInReferringInterface <em>Name In Referring Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name In Referring Interface</em>' attribute.
	 * @see #getNameInReferringInterface()
	 * @generated
	 */
	void setNameInReferringInterface(String value);

	/**
	 * Returns the value of the '<em><b>Qualified Name In Referring Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name In Referring Interface</em>' attribute.
	 * @see #setQualifiedNameInReferringInterface(String)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateReferredOperation_QualifiedNameInReferringInterface()
	 * @model unique="false"
	 * @generated
	 */
	String getQualifiedNameInReferringInterface();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getQualifiedNameInReferringInterface <em>Qualified Name In Referring Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name In Referring Interface</em>' attribute.
	 * @see #getQualifiedNameInReferringInterface()
	 * @generated
	 */
	void setQualifiedNameInReferringInterface(String value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(IntermediateOperation)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateReferredOperation_Operation()
	 * @model
	 * @generated
	 */
	IntermediateOperation getOperation();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(IntermediateOperation value);

	/**
	 * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoints</em>' containment reference list.
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateReferredOperation_Endpoints()
	 * @see de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getReferredOperation
	 * @model opposite="referredOperation" containment="true"
	 * @generated
	 */
	EList<IntermediateEndpoint> getEndpoints();

	/**
	 * Returns the value of the '<em><b>Protocols</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocols</em>' containment reference list.
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateReferredOperation_Protocols()
	 * @model containment="true" upper="2"
	 * @generated
	 */
	EList<IntermediateProtocolSpecification> getProtocols();

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateReferredOperation_Aspects()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntermediateImportedAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Referring Interface</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateInterface#getReferredOperations <em>Referred Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referring Interface</em>' container reference.
	 * @see #setReferringInterface(IntermediateInterface)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateReferredOperation_ReferringInterface()
	 * @see de.fhdo.lemma.service.intermediate.IntermediateInterface#getReferredOperations
	 * @model opposite="referredOperations" transient="false"
	 * @generated
	 */
	IntermediateInterface getReferringInterface();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getReferringInterface <em>Referring Interface</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referring Interface</em>' container reference.
	 * @see #getReferringInterface()
	 * @generated
	 */
	void setReferringInterface(IntermediateInterface value);

} // IntermediateReferredOperation
