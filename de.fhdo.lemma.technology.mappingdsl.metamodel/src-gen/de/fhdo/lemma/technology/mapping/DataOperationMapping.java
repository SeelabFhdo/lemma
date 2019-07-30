/**
 */
package de.fhdo.lemma.technology.mapping;

import de.fhdo.lemma.data.DataOperation;
import de.fhdo.lemma.data.Type;

import de.fhdo.lemma.service.Import;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Operation Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Technology mapping for data operations
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.mapping.DataOperationMapping#getDataOperation <em>Data Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.DataOperationMapping#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.DataOperationMapping#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.DataOperationMapping#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.DataOperationMapping#getParameterMappings <em>Parameter Mappings</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.DataOperationMapping#getTypeMapping <em>Type Mapping</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.technology.mapping.MappingPackage#getDataOperationMapping()
 * @model
 * @generated
 */
public interface DataOperationMapping extends EObject {
    /**
     * Returns the value of the '<em><b>Data Operation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) If the original data operation has no return type, the return type may not be mapped
     *          to a new type.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Data Operation</em>' reference.
     * @see #setDataOperation(DataOperation)
     * @see de.fhdo.lemma.technology.mapping.MappingPackage#getDataOperationMapping_DataOperation()
     * @model
     * @generated
     */
    DataOperation getDataOperation();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.DataOperationMapping#getDataOperation <em>Data Operation</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Operation</em>' reference.
     * @see #getDataOperation()
     * @generated
     */
    void setDataOperation(DataOperation value);

    /**
     * Returns the value of the '<em><b>Technology</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Technology</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technology</em>' reference.
     * @see #setTechnology(Import)
     * @see de.fhdo.lemma.technology.mapping.MappingPackage#getDataOperationMapping_Technology()
     * @model
     * @generated
     */
    Import getTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.DataOperationMapping#getTechnology <em>Technology</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Technology</em>' reference.
     * @see #getTechnology()
     * @generated
     */
    void setTechnology(Import value);

    /**
     * Returns the value of the '<em><b>Return Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Return Type</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Return Type</em>' reference.
     * @see #setReturnType(Type)
     * @see de.fhdo.lemma.technology.mapping.MappingPackage#getDataOperationMapping_ReturnType()
     * @model
     * @generated
     */
    Type getReturnType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.DataOperationMapping#getReturnType <em>Return Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Return Type</em>' reference.
     * @see #getReturnType()
     * @generated
     */
    void setReturnType(Type value);

    /**
     * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getDataOperationMapping <em>Data Operation Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.lemma.technology.mapping.MappingPackage#getDataOperationMapping_Aspects()
     * @see de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect#getDataOperationMapping
     * @model opposite="dataOperationMapping" containment="true"
     * @generated
     */
    EList<TechnologySpecificImportedServiceAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Parameter Mappings</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.lemma.technology.mapping.DataOperationParameterMapping}.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.DataOperationParameterMapping#getOperationMapping <em>Operation Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter Mappings</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameter Mappings</em>' containment reference list.
     * @see de.fhdo.lemma.technology.mapping.MappingPackage#getDataOperationMapping_ParameterMappings()
     * @see de.fhdo.lemma.technology.mapping.DataOperationParameterMapping#getOperationMapping
     * @model opposite="operationMapping" containment="true"
     * @generated
     */
    EList<DataOperationParameterMapping> getParameterMappings();

    /**
     * Returns the value of the '<em><b>Type Mapping</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.technology.mapping.ComplexTypeMapping#getOperationMappings <em>Operation Mappings</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type Mapping</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type Mapping</em>' container reference.
     * @see #setTypeMapping(ComplexTypeMapping)
     * @see de.fhdo.lemma.technology.mapping.MappingPackage#getDataOperationMapping_TypeMapping()
     * @see de.fhdo.lemma.technology.mapping.ComplexTypeMapping#getOperationMappings
     * @model opposite="operationMappings" transient="false"
     * @generated
     */
    ComplexTypeMapping getTypeMapping();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.technology.mapping.DataOperationMapping#getTypeMapping <em>Type Mapping</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type Mapping</em>' container reference.
     * @see #getTypeMapping()
     * @generated
     */
    void setTypeMapping(ComplexTypeMapping value);

} // DataOperationMapping
