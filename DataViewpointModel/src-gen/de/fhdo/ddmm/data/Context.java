/**
 */
package de.fhdo.ddmm.data;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Next to a version, a context may act as an additional, possibly subordinate, naming scope to
 * organize complex types
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.data.Context#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.Context#getComplexTypes <em>Complex Types</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.Context#getDataModel <em>Data Model</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.Context#getVersion <em>Version</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.data.DataPackage#getContext()
 * @model
 * @generated
 */
public interface Context extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Name must be unique.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.ddmm.data.DataPackage#getContext_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.Context#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Complex Types</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.data.ComplexType}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.data.ComplexType#getContext <em>Context</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Complex Types</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Complex Types</em>' containment reference list.
     * @see de.fhdo.ddmm.data.DataPackage#getContext_ComplexTypes()
     * @see de.fhdo.ddmm.data.ComplexType#getContext
     * @model opposite="context" containment="true" required="true"
     * @generated
     */
    EList<ComplexType> getComplexTypes();

    /**
     * Returns the value of the '<em><b>Data Model</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.data.DataModel#getContexts <em>Contexts</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Model</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Model</em>' container reference.
     * @see #setDataModel(DataModel)
     * @see de.fhdo.ddmm.data.DataPackage#getContext_DataModel()
     * @see de.fhdo.ddmm.data.DataModel#getContexts
     * @model opposite="contexts" transient="false"
     * @generated
     */
    DataModel getDataModel();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.Context#getDataModel <em>Data Model</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Model</em>' container reference.
     * @see #getDataModel()
     * @generated
     */
    void setDataModel(DataModel value);

    /**
     * Returns the value of the '<em><b>Version</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.data.Version#getContexts <em>Contexts</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Version</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Version</em>' container reference.
     * @see #setVersion(Version)
     * @see de.fhdo.ddmm.data.DataPackage#getContext_Version()
     * @see de.fhdo.ddmm.data.Version#getContexts
     * @model opposite="contexts" transient="false"
     * @generated
     */
    Version getVersion();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.Context#getVersion <em>Version</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Version</em>' container reference.
     * @see #getVersion()
     * @generated
     */
    void setVersion(Version value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get parts of the context for creating a qualified name
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; _xblockexpression = null;\n{\n\tif (((this.getName() == null) || this.getName().isEmpty()))\n\t{\n\t\treturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(&lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;newArrayList());\n\t}\n\tfinal &lt;%java.util.ArrayList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; nameParts = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;newArrayList();\n\t&lt;%de.fhdo.ddmm.data.Version%&gt; _version = this.getVersion();\n\tboolean _tripleNotEquals = (_version != null);\n\tif (_tripleNotEquals)\n\t{\n\t\tnameParts.addAll(this.getVersion().getQualifiedNameParts());\n\t}\n\tnameParts.add(this.getName());\n\t_xblockexpression = &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(nameParts);\n}\nreturn _xblockexpression;'"
     * @generated
     */
    EList<String> getQualifiedNameParts();

} // Context
