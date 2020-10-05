/**
 */
package de.fhdo.lemma.data.intermediate;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Complex type
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateComplexType#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateComplexType#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateComplexType#getDataModel <em>Data Model</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateComplexType#getVersion <em>Version</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateComplexType#getContext <em>Context</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateComplexType()
 * @model
 * @generated
 */
public interface IntermediateComplexType extends IntermediateType {
	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see #setQualifiedName(String)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateComplexType_QualifiedName()
	 * @model unique="false"
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateComplexType#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getComplexType <em>Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateComplexType_Aspects()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getComplexType
	 * @model opposite="complexType" containment="true"
	 * @generated
	 */
	EList<IntermediateImportedAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Data Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateDataModel#getComplexTypes <em>Complex Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Model</em>' container reference.
	 * @see #setDataModel(IntermediateDataModel)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateComplexType_DataModel()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataModel#getComplexTypes
	 * @model opposite="complexTypes" transient="false"
	 * @generated
	 */
	IntermediateDataModel getDataModel();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateComplexType#getDataModel <em>Data Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Model</em>' container reference.
	 * @see #getDataModel()
	 * @generated
	 */
	void setDataModel(IntermediateDataModel value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateVersion#getComplexTypes <em>Complex Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' container reference.
	 * @see #setVersion(IntermediateVersion)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateComplexType_Version()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateVersion#getComplexTypes
	 * @model opposite="complexTypes" transient="false"
	 * @generated
	 */
	IntermediateVersion getVersion();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateComplexType#getVersion <em>Version</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' container reference.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(IntermediateVersion value);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateContext#getComplexTypes <em>Complex Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' container reference.
	 * @see #setContext(IntermediateContext)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateComplexType_Context()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateContext#getComplexTypes
	 * @model opposite="complexTypes" transient="false"
	 * @generated
	 */
	IntermediateContext getContext();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateComplexType#getContext <em>Context</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' container reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(IntermediateContext value);

} // IntermediateComplexType
