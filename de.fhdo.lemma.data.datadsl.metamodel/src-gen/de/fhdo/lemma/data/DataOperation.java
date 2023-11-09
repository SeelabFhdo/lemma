/**
 */
package de.fhdo.lemma.data;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents an operation within a data structure
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.DataOperation#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.DataOperation#isHidden <em>Hidden</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.DataOperation#isHasNoReturnType <em>Has No Return Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.DataOperation#getFeatures <em>Features</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.DataOperation#getComplexReturnType <em>Complex Return Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.DataOperation#getImportedComplexReturnType <em>Imported Complex Return Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.DataOperation#getPrimitiveReturnType <em>Primitive Return Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.DataOperation#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.DataOperation#getDataStructure <em>Data Structure</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.DataOperation#isLacksReturnTypeSpecification <em>Lacks Return Type Specification</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.DataOperation#isInherited <em>Inherited</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.DataPackage#getDataOperation()
 * @model
 * @generated
 */
public interface DataOperation extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) The operation must have a return type specification (which can be a complex return
	 *          type, a primitive return type, or an _explicit_ specification that the operation has
	 *          no return type) if either no operation with an equal name exists in a super data
	 *          structure, or if an eponymous super operation exists that is hidden.
	 *          Ensured by: DSL validator.
	 *     (C2) If an eponymous super operation exists that is not hidden, than this operation must
	 *          not have a return type specification, i.e., a visible super operation cannot be
	 *          redefined in a sub-structure.
	 *          Ensured by: DSL validator.
	 *     (C3) Name must be unique within a data structure.
	 *          Ensured by: DSL validator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.data.DataPackage#getDataOperation_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.DataOperation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Hidden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hidden</em>' attribute.
	 * @see #setHidden(boolean)
	 * @see de.fhdo.lemma.data.DataPackage#getDataOperation_Hidden()
	 * @model unique="false"
	 * @generated
	 */
	boolean isHidden();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.DataOperation#isHidden <em>Hidden</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hidden</em>' attribute.
	 * @see #isHidden()
	 * @generated
	 */
	void setHidden(boolean value);

	/**
	 * Returns the value of the '<em><b>Has No Return Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has No Return Type</em>' attribute.
	 * @see #setHasNoReturnType(boolean)
	 * @see de.fhdo.lemma.data.DataPackage#getDataOperation_HasNoReturnType()
	 * @model unique="false"
	 * @generated
	 */
	boolean isHasNoReturnType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.DataOperation#isHasNoReturnType <em>Has No Return Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has No Return Type</em>' attribute.
	 * @see #isHasNoReturnType()
	 * @generated
	 */
	void setHasNoReturnType(boolean value);

	/**
	 * Returns the value of the '<em><b>Features</b></em>' attribute list.
	 * The list contents are of type {@link de.fhdo.lemma.data.DataOperationFeature}.
	 * The literals are from the enumeration {@link de.fhdo.lemma.data.DataOperationFeature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' attribute list.
	 * @see de.fhdo.lemma.data.DataOperationFeature
	 * @see de.fhdo.lemma.data.DataPackage#getDataOperation_Features()
	 * @model unique="false"
	 * @generated
	 */
	EList<DataOperationFeature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Complex Return Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complex Return Type</em>' reference.
	 * @see #setComplexReturnType(ComplexType)
	 * @see de.fhdo.lemma.data.DataPackage#getDataOperation_ComplexReturnType()
	 * @model
	 * @generated
	 */
	ComplexType getComplexReturnType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.DataOperation#getComplexReturnType <em>Complex Return Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Complex Return Type</em>' reference.
	 * @see #getComplexReturnType()
	 * @generated
	 */
	void setComplexReturnType(ComplexType value);

	/**
	 * Returns the value of the '<em><b>Imported Complex Return Type</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.ImportedComplexType#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Complex Return Type</em>' containment reference.
	 * @see #setImportedComplexReturnType(ImportedComplexType)
	 * @see de.fhdo.lemma.data.DataPackage#getDataOperation_ImportedComplexReturnType()
	 * @see de.fhdo.lemma.data.ImportedComplexType#getOperation
	 * @model opposite="operation" containment="true"
	 * @generated
	 */
	ImportedComplexType getImportedComplexReturnType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.DataOperation#getImportedComplexReturnType <em>Imported Complex Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported Complex Return Type</em>' containment reference.
	 * @see #getImportedComplexReturnType()
	 * @generated
	 */
	void setImportedComplexReturnType(ImportedComplexType value);

	/**
	 * Returns the value of the '<em><b>Primitive Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive Return Type</em>' containment reference.
	 * @see #setPrimitiveReturnType(PrimitiveType)
	 * @see de.fhdo.lemma.data.DataPackage#getDataOperation_PrimitiveReturnType()
	 * @model containment="true"
	 * @generated
	 */
	PrimitiveType getPrimitiveReturnType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.DataOperation#getPrimitiveReturnType <em>Primitive Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive Return Type</em>' containment reference.
	 * @see #getPrimitiveReturnType()
	 * @generated
	 */
	void setPrimitiveReturnType(PrimitiveType value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.DataOperationParameter}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.DataOperationParameter#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see de.fhdo.lemma.data.DataPackage#getDataOperation_Parameters()
	 * @see de.fhdo.lemma.data.DataOperationParameter#getOperation
	 * @model opposite="operation" containment="true"
	 * @generated
	 */
	EList<DataOperationParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Data Structure</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.DataStructure#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Structure</em>' container reference.
	 * @see #setDataStructure(DataStructure)
	 * @see de.fhdo.lemma.data.DataPackage#getDataOperation_DataStructure()
	 * @see de.fhdo.lemma.data.DataStructure#getOperations
	 * @model opposite="operations" transient="false"
	 * @generated
	 */
	DataStructure getDataStructure();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.DataOperation#getDataStructure <em>Data Structure</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Structure</em>' container reference.
	 * @see #getDataStructure()
	 * @generated
	 */
	void setDataStructure(DataStructure value);

	/**
	 * Returns the value of the '<em><b>Lacks Return Type Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Flag to indicate that this operation lacks a return type specification, i.e., it was not
	 * explicitly specified as having no return type and also does not return a primitive or complex
	 * type
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Lacks Return Type Specification</em>' attribute.
	 * @see de.fhdo.lemma.data.DataPackage#getDataOperation_LacksReturnTypeSpecification()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isLacksReturnTypeSpecification();

	/**
	 * Returns the value of the '<em><b>Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Flag to indicate if this operation is inherited from a super structure
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inherited</em>' attribute.
	 * @see de.fhdo.lemma.data.DataPackage#getDataOperation_Inherited()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isInherited();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get parts of the operation for creating a qualified name
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Find an eponymous operation in the inheritance hierarchy of this operations's data structure.
	 * Returns null, if this operation is not part of a data structure, as only data structures may
	 * extend other data structures.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 * @generated
	 */
	DataOperation findEponymousSuperOperation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get the return type of the operation, if any. Will return null if the operation has no
	 * primitive or complex type.
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Type getPrimitiveOrComplexReturnType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Check if the operation has a specific feature assigned
	 * <!-- end-model-doc -->
	 * @model unique="false" featureUnique="false"
	 * @generated
	 */
	boolean hasFeature(DataOperationFeature feature);

} // DataOperation
