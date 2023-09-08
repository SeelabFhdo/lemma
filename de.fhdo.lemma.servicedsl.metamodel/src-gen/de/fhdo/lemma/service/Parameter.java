/**
 */
package de.fhdo.lemma.service;

import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.data.Type;

import de.fhdo.lemma.technology.CommunicationType;
import de.fhdo.lemma.technology.ExchangePattern;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.Parameter#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Parameter#getExchangePattern <em>Exchange Pattern</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Parameter#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Parameter#isCommunicatesFault <em>Communicates Fault</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Parameter#isOptional <em>Optional</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Parameter#getInitializedByOperation <em>Initialized By Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Parameter#getImportedType <em>Imported Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Parameter#getPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Parameter#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Parameter#getMappedFields <em>Mapped Fields</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Parameter#getOriginalImportedType <em>Original Imported Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Parameter#getOriginalPrimitiveType <em>Original Primitive Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Parameter#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.ServicePackage#getParameter()
 * @model
 * @generated
 */
public interface Parameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) Must have exactly one type, either imported or primitive.
	 *          Ensured by: DSL grammar.
	 *     (C2) Imported types may only come from a data or technology model.
	 *          Ensured by: DSL scope provider.
	 *     (C3) Import aliases for the initializing operation can only originate from imports of the
	 *          concepts required by the parameter operation's microservice.
	 *          Ensured by: DSL scope provider.
	 *     (C4) Initializing operations can only originate from the list of directly or indirectly
	 *          required operations of the microservice and they need to exhibit basic
	 *          "initializability" (see the checking operation below).
	 *          Ensured by: DSL scope provider.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.service.ServicePackage#getParameter_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Parameter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Exchange Pattern</b></em>' attribute.
	 * The default value is <code>"IN"</code>.
	 * The literals are from the enumeration {@link de.fhdo.lemma.technology.ExchangePattern}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exchange Pattern</em>' attribute.
	 * @see de.fhdo.lemma.technology.ExchangePattern
	 * @see #setExchangePattern(ExchangePattern)
	 * @see de.fhdo.lemma.service.ServicePackage#getParameter_ExchangePattern()
	 * @model default="IN" unique="false"
	 * @generated
	 */
	ExchangePattern getExchangePattern();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Parameter#getExchangePattern <em>Exchange Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exchange Pattern</em>' attribute.
	 * @see de.fhdo.lemma.technology.ExchangePattern
	 * @see #getExchangePattern()
	 * @generated
	 */
	void setExchangePattern(ExchangePattern value);

	/**
	 * Returns the value of the '<em><b>Communication Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.fhdo.lemma.technology.CommunicationType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Communication Type</em>' attribute.
	 * @see de.fhdo.lemma.technology.CommunicationType
	 * @see #setCommunicationType(CommunicationType)
	 * @see de.fhdo.lemma.service.ServicePackage#getParameter_CommunicationType()
	 * @model unique="false"
	 * @generated
	 */
	CommunicationType getCommunicationType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Parameter#getCommunicationType <em>Communication Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Communication Type</em>' attribute.
	 * @see de.fhdo.lemma.technology.CommunicationType
	 * @see #getCommunicationType()
	 * @generated
	 */
	void setCommunicationType(CommunicationType value);

	/**
	 * Returns the value of the '<em><b>Communicates Fault</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Communicates Fault</em>' attribute.
	 * @see #setCommunicatesFault(boolean)
	 * @see de.fhdo.lemma.service.ServicePackage#getParameter_CommunicatesFault()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isCommunicatesFault();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Parameter#isCommunicatesFault <em>Communicates Fault</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Communicates Fault</em>' attribute.
	 * @see #isCommunicatesFault()
	 * @generated
	 */
	void setCommunicatesFault(boolean value);

	/**
	 * Returns the value of the '<em><b>Optional</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional</em>' attribute.
	 * @see #setOptional(boolean)
	 * @see de.fhdo.lemma.service.ServicePackage#getParameter_Optional()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isOptional();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Parameter#isOptional <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional</em>' attribute.
	 * @see #isOptional()
	 * @generated
	 */
	void setOptional(boolean value);

	/**
	 * Returns the value of the '<em><b>Initialized By Operation</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.PossiblyImportedOperation#getInitializedParameter <em>Initialized Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialized By Operation</em>' containment reference.
	 * @see #setInitializedByOperation(PossiblyImportedOperation)
	 * @see de.fhdo.lemma.service.ServicePackage#getParameter_InitializedByOperation()
	 * @see de.fhdo.lemma.service.PossiblyImportedOperation#getInitializedParameter
	 * @model opposite="initializedParameter" containment="true"
	 * @generated
	 */
	PossiblyImportedOperation getInitializedByOperation();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Parameter#getInitializedByOperation <em>Initialized By Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialized By Operation</em>' containment reference.
	 * @see #getInitializedByOperation()
	 * @generated
	 */
	void setInitializedByOperation(PossiblyImportedOperation value);

	/**
	 * Returns the value of the '<em><b>Imported Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Type</em>' containment reference.
	 * @see #setImportedType(ImportedType)
	 * @see de.fhdo.lemma.service.ServicePackage#getParameter_ImportedType()
	 * @model containment="true"
	 * @generated
	 */
	ImportedType getImportedType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Parameter#getImportedType <em>Imported Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported Type</em>' containment reference.
	 * @see #getImportedType()
	 * @generated
	 */
	void setImportedType(ImportedType value);

	/**
	 * Returns the value of the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive Type</em>' containment reference.
	 * @see #setPrimitiveType(PrimitiveType)
	 * @see de.fhdo.lemma.service.ServicePackage#getParameter_PrimitiveType()
	 * @model containment="true"
	 * @generated
	 */
	PrimitiveType getPrimitiveType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Parameter#getPrimitiveType <em>Primitive Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive Type</em>' containment reference.
	 * @see #getPrimitiveType()
	 * @generated
	 */
	void setPrimitiveType(PrimitiveType value);

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.ImportedServiceAspect}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.ImportedServiceAspect#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getParameter_Aspects()
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getParameter
	 * @model opposite="parameter" containment="true"
	 * @generated
	 */
	EList<ImportedServiceAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Mapped Fields</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.MappedField}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.MappedField#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Fields</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getParameter_MappedFields()
	 * @see de.fhdo.lemma.service.MappedField#getParameter
	 * @model opposite="parameter" containment="true"
	 * @generated
	 */
	EList<MappedField> getMappedFields();

	/**
	 * Returns the value of the '<em><b>Original Imported Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Imported Type</em>' containment reference.
	 * @see #setOriginalImportedType(ImportedType)
	 * @see de.fhdo.lemma.service.ServicePackage#getParameter_OriginalImportedType()
	 * @model containment="true"
	 * @generated
	 */
	ImportedType getOriginalImportedType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Parameter#getOriginalImportedType <em>Original Imported Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Imported Type</em>' containment reference.
	 * @see #getOriginalImportedType()
	 * @generated
	 */
	void setOriginalImportedType(ImportedType value);

	/**
	 * Returns the value of the '<em><b>Original Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Primitive Type</em>' containment reference.
	 * @see #setOriginalPrimitiveType(PrimitiveType)
	 * @see de.fhdo.lemma.service.ServicePackage#getParameter_OriginalPrimitiveType()
	 * @model containment="true"
	 * @generated
	 */
	PrimitiveType getOriginalPrimitiveType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Parameter#getOriginalPrimitiveType <em>Original Primitive Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Primitive Type</em>' containment reference.
	 * @see #getOriginalPrimitiveType()
	 * @generated
	 */
	void setOriginalPrimitiveType(PrimitiveType value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Operation#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' container reference.
	 * @see #setOperation(Operation)
	 * @see de.fhdo.lemma.service.ServicePackage#getParameter_Operation()
	 * @see de.fhdo.lemma.service.Operation#getParameters
	 * @model opposite="parameters" transient="false"
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Parameter#getOperation <em>Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' container reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operation value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get parts of the parameter for creating a qualified name
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
	 * Check if a parameter is _basically_ initializable by a given operation. This basic check does
	 * not include the comparatively "expensive" type compatibility checking, but only those formal
	 * checks that are based on direct characteristics of the parameter and the initializing
	 * operation.
	 * <!-- end-model-doc -->
	 * @model unique="false" initializingOperationUnique="false"
	 * @generated
	 */
	boolean basicallyInitializableBy(Operation initializingOperation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get effective type of parameter, i.e., the primitive or imported type (null otherwise)
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Type getEffectiveType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Check if the effective type of the parameter is technology-specific
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	boolean isTechnologySpecificEffectiveType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get parts of the parameter for creating a qualified name depending on its effective type
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<String> getEffectiveTypeQualifiedNameParts();

} // Parameter
