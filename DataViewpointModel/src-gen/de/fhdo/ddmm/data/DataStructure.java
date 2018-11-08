/**
 */
package de.fhdo.ddmm.data;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Concept for data structures, i.e., complex types probably consisting of named and typed fields,
 * but that may also be empty though
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.data.DataStructure#getSuper <em>Super</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.DataStructure#getDataFields <em>Data Fields</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.data.DataPackage#getDataStructure()
 * @model
 * @generated
 */
public interface DataStructure extends ComplexType {
    /**
     * Returns the value of the '<em><b>Super</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) No cyclic inheritance, i.e., within an inheritance hierarchy, a data structure must
     *          not occur twice.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Super</em>' reference.
     * @see #setSuper(DataStructure)
     * @see de.fhdo.ddmm.data.DataPackage#getDataStructure_Super()
     * @model
     * @generated
     */
    DataStructure getSuper();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.DataStructure#getSuper <em>Super</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Super</em>' reference.
     * @see #getSuper()
     * @generated
     */
    void setSuper(DataStructure value);

    /**
     * Returns the value of the '<em><b>Data Fields</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.data.DataField}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.data.DataField#getDataStructure <em>Data Structure</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Fields</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Fields</em>' containment reference list.
     * @see de.fhdo.ddmm.data.DataPackage#getDataStructure_DataFields()
     * @see de.fhdo.ddmm.data.DataField#getDataStructure
     * @model opposite="dataStructure" containment="true"
     * @generated
     */
    EList<DataField> getDataFields();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get the effective fields of the structure considering possible direct and indirect
     * inheritance relationships
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%java.util.ArrayList%&gt;&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;&gt; effectiveFields = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;&gt;newArrayList();\nfinal &lt;%java.util.HashSet%&gt;&lt;&lt;%java.lang.String%&gt;&gt; hiddenFields = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;newHashSet();\n&lt;%de.fhdo.ddmm.data.DataStructure%&gt; currentStructure = this;\ndo\n{\n\t{\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.data.DataField%&gt; it)\n\t\t\t{\n\t\t\t\t&lt;%java.lang.String%&gt; _name = it.getName();\n\t\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((_name != null));\n\t\t\t}\n\t\t};\n\t\tfinal &lt;%java.lang.Iterable%&gt;&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;&gt; currentNamedFields = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;&gt;filter(currentStructure.getDataFields(), _function);\n\t\tfor (final &lt;%de.fhdo.ddmm.data.DataField%&gt; field : currentNamedFields)\n\t\t{\n\t\t\t{\n\t\t\t\tboolean _isHidden = field.isHidden();\n\t\t\t\tif (_isHidden)\n\t\t\t\t{\n\t\t\t\t\thiddenFields.add(field.getName());\n\t\t\t\t}\n\t\t\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t\t\t\t{\n\t\t\t\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.data.DataField%&gt; it)\n\t\t\t\t\t{\n\t\t\t\t\t\t&lt;%java.lang.String%&gt; _name = field.getName();\n\t\t\t\t\t\t&lt;%java.lang.String%&gt; _name_1 = it.getName();\n\t\t\t\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(&lt;%com.google.common.base.Objects%&gt;.equal(_name, _name_1));\n\t\t\t\t\t}\n\t\t\t\t};\n\t\t\t\tfinal &lt;%de.fhdo.ddmm.data.DataField%&gt; existingEffectiveField = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;&gt;findFirst(effectiveFields, _function_1);\n\t\t\t\tfinal boolean fieldAlreadyCollected = (existingEffectiveField != null);\n\t\t\t\tfinal boolean hiddenField = (field.isHidden() || hiddenFields.contains(field.getName()));\n\t\t\t\tfinal boolean inheritedField = (currentStructure != this);\n\t\t\t\tfinal boolean visibleInheritedField = ((!hiddenField) &amp;&amp; inheritedField);\n\t\t\t\tif (((!fieldAlreadyCollected) &amp;&amp; ((!inheritedField) || visibleInheritedField)))\n\t\t\t\t{\n\t\t\t\t\teffectiveFields.add(field);\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif ((fieldAlreadyCollected &amp;&amp; hiddenField))\n\t\t\t\t\t{\n\t\t\t\t\t\teffectiveFields.remove(existingEffectiveField);\n\t\t\t\t\t\teffectiveFields.add(field);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tcurrentStructure = currentStructure.getSuper();\n\t}\n}\nwhile((currentStructure != null));\nreturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;&gt;asEList(effectiveFields);'"
     * @generated
     */
    EList<DataField> getEffectiveFields();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Check if this data structure is a direct or indirect extension of, i.e., if it inherits from,
     * another data structure
     * <!-- end-model-doc -->
     * @model unique="false" structureUnique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if ((structure == null))\n{\n\treturn false;\n}\n&lt;%de.fhdo.ddmm.data.DataStructure%&gt; currentStructure = this;\nwhile ((currentStructure.getSuper() != null))\n{\n\t{\n\t\t&lt;%de.fhdo.ddmm.data.DataStructure%&gt; _super = currentStructure.getSuper();\n\t\tboolean _equals = &lt;%com.google.common.base.Objects%&gt;.equal(_super, structure);\n\t\tif (_equals)\n\t\t{\n\t\t\treturn true;\n\t\t}\n\t\tcurrentStructure = currentStructure.getSuper();\n\t}\n}\nreturn false;'"
     * @generated
     */
    boolean isExtensionOf(DataStructure structure);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Convenience methods to compare two data structures by field counts
     * <!-- end-model-doc -->
     * @model unique="false" structureToCompareUnique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if ((structureToCompare == null))\n{\n\treturn 1;\n}\nreturn super.compareFieldCounts(this.getEffectiveFields(), structureToCompare.getEffectiveFields());'"
     * @generated
     */
    int compareFieldCounts(DataStructure structureToCompare);

} // DataStructure
