/**
 */
package de.fhdo.ddmm.data;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Super-concept of complex types, i.e., lists and structures
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.data.ComplexType#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.ComplexType#getDataModel <em>Data Model</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.ComplexType#getVersion <em>Version</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.ComplexType#getContext <em>Context</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.ComplexType#isIsStructure <em>Is Structure</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.ComplexType#isIsPrimitiveList <em>Is Primitive List</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.ComplexType#isIsStructuredList <em>Is Structured List</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.data.DataPackage#getComplexType()
 * @model abstract="true"
 * @generated
 */
public interface ComplexType extends Type {
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
     * @see de.fhdo.ddmm.data.DataPackage#getComplexType_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.ComplexType#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Data Model</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.data.DataModel#getComplexTypes <em>Complex Types</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Model</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Model</em>' container reference.
     * @see #setDataModel(DataModel)
     * @see de.fhdo.ddmm.data.DataPackage#getComplexType_DataModel()
     * @see de.fhdo.ddmm.data.DataModel#getComplexTypes
     * @model opposite="complexTypes" transient="false"
     * @generated
     */
    DataModel getDataModel();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.ComplexType#getDataModel <em>Data Model</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Model</em>' container reference.
     * @see #getDataModel()
     * @generated
     */
    void setDataModel(DataModel value);

    /**
     * Returns the value of the '<em><b>Version</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.data.Version#getComplexTypes <em>Complex Types</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Version</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Version</em>' container reference.
     * @see #setVersion(Version)
     * @see de.fhdo.ddmm.data.DataPackage#getComplexType_Version()
     * @see de.fhdo.ddmm.data.Version#getComplexTypes
     * @model opposite="complexTypes" transient="false"
     * @generated
     */
    Version getVersion();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.ComplexType#getVersion <em>Version</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Version</em>' container reference.
     * @see #getVersion()
     * @generated
     */
    void setVersion(Version value);

    /**
     * Returns the value of the '<em><b>Context</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.data.Context#getComplexTypes <em>Complex Types</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Context</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Context</em>' container reference.
     * @see #setContext(Context)
     * @see de.fhdo.ddmm.data.DataPackage#getComplexType_Context()
     * @see de.fhdo.ddmm.data.Context#getComplexTypes
     * @model opposite="complexTypes" transient="false"
     * @generated
     */
    Context getContext();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.ComplexType#getContext <em>Context</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context</em>' container reference.
     * @see #getContext()
     * @generated
     */
    void setContext(Context value);

    /**
     * Returns the value of the '<em><b>Is Structure</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Flag indicating that the ComplexType instance is a DataStructure
     * <!-- end-model-doc -->
     * @return the value of the '<em>Is Structure</em>' attribute.
     * @see de.fhdo.ddmm.data.DataPackage#getComplexType_IsStructure()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return (this instanceof &lt;%de.fhdo.ddmm.data.DataStructure%&gt;);'"
     * @generated
     */
    boolean isIsStructure();

    /**
     * Returns the value of the '<em><b>Is Primitive List</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Flag indicating that the ComplexType instance is a ListType that holds a PrimitiveType and
     * hence does not consist of several named and typed DataFields
     * <!-- end-model-doc -->
     * @return the value of the '<em>Is Primitive List</em>' attribute.
     * @see de.fhdo.ddmm.data.DataPackage#getComplexType_IsPrimitiveList()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='if ((!(this instanceof &lt;%de.fhdo.ddmm.data.ListType%&gt;)))\n{\n\treturn false;\n}\n&lt;%de.fhdo.ddmm.data.PrimitiveType%&gt; _primitiveType = ((&lt;%de.fhdo.ddmm.data.ListType%&gt;) this).getPrimitiveType();\nreturn (_primitiveType != null);'"
     * @generated
     */
    boolean isIsPrimitiveList();

    /**
     * Returns the value of the '<em><b>Is Structured List</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Flag indicating that the ComplexType instance is a ListType that consists of several named
     * and typed DataFields instead of a single "anonymous" PrimitiveType field
     * <!-- end-model-doc -->
     * @return the value of the '<em>Is Structured List</em>' attribute.
     * @see de.fhdo.ddmm.data.DataPackage#getComplexType_IsStructuredList()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='if ((!(this instanceof &lt;%de.fhdo.ddmm.data.ListType%&gt;)))\n{\n\treturn false;\n}\nreturn ((((&lt;%de.fhdo.ddmm.data.ListType%&gt;) this).getDataFields() != null) &amp;&amp; \n\t(!((&lt;%de.fhdo.ddmm.data.ListType%&gt;) this).getDataFields().isEmpty()));'"
     * @generated
     */
    boolean isIsStructuredList();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get parts of the complex type for creating a qualified name
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; _xblockexpression = null;\n{\n\tif (((this.getName() == null) || this.getName().isEmpty()))\n\t{\n\t\treturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(&lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;newArrayList());\n\t}\n\tfinal &lt;%java.util.ArrayList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; nameParts = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;newArrayList();\n\t&lt;%de.fhdo.ddmm.data.Version%&gt; _version = this.getVersion();\n\tboolean _tripleNotEquals = (_version != null);\n\tif (_tripleNotEquals)\n\t{\n\t\tnameParts.addAll(this.getVersion().getQualifiedNameParts());\n\t}\n\t&lt;%de.fhdo.ddmm.data.Context%&gt; _context = this.getContext();\n\tboolean _tripleNotEquals_1 = (_context != null);\n\tif (_tripleNotEquals_1)\n\t{\n\t\tnameParts.addAll(this.getContext().getQualifiedNameParts());\n\t}\n\tnameParts.add(this.getName());\n\t_xblockexpression = &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(nameParts);\n}\nreturn _xblockexpression;'"
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
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if ((separator == null))\n{\n\treturn null;\n}\n&lt;%java.lang.String%&gt; qualifiedName = \"\";\n&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; _qualifiedNameParts = this.getQualifiedNameParts();\nfor (final &lt;%java.lang.String%&gt; part : _qualifiedNameParts)\n{\n\t&lt;%java.lang.String%&gt; _qualifiedName = qualifiedName;\n\tqualifiedName = (_qualifiedName + (separator + part));\n}\nboolean _isEmpty = qualifiedName.isEmpty();\nboolean _not = (!_isEmpty);\nif (_not)\n{\n\tqualifiedName = qualifiedName.substring(separator.length());\n}\nreturn qualifiedName;'"
     * @generated
     */
    String buildQualifiedName(String separator);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Helper operation for ComplexType-subclasses to compare the counts of two DataField lists. The
     * return value follows the semantics of Java's Comparator.compare() method. The comparison is
     * based on the numbers of concrete types of the DataFields, i.e., primitive types are compared
     * with primitive types, structures with structures, and lists with lists. The field count of
     * the first argument is greater, i.e., the operation returns 1, in case the type-specific field
     * counts are not equal and at least one type-specific field count is greater than its
     * counterpart in the second argument, e.g., there are more list-typed fields in the first than
     * in the second argument.
     * <!-- end-model-doc -->
     * @model unique="false" fieldsUnique="false" fieldsMany="true" fieldsToCompareUnique="false" fieldsToCompareMany="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (((fields == null) &amp;&amp; (fieldsToCompare == null)))\n{\n\treturn 0;\n}\nelse\n{\n\tif ((fields == null))\n\t{\n\t\treturn (-1);\n\t}\n\telse\n\t{\n\t\tif ((fieldsToCompare == null))\n\t\t{\n\t\t\treturn 1;\n\t\t}\n\t}\n}\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.data.DataField%&gt; it)\n\t{\n\t\t&lt;%de.fhdo.ddmm.data.Type%&gt; _effectiveType = it.getEffectiveType();\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((_effectiveType instanceof &lt;%de.fhdo.ddmm.data.PrimitiveType%&gt;));\n\t}\n};\nfinal int fieldsPrimitiveCounts = ((&lt;%java.lang.Object%&gt;[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;&gt;filter(fields, _function), &lt;%java.lang.Object%&gt;.class)).length;\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.data.DataField%&gt; it)\n\t{\n\t\t&lt;%de.fhdo.ddmm.data.Type%&gt; _effectiveType = it.getEffectiveType();\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((_effectiveType instanceof &lt;%de.fhdo.ddmm.data.DataStructure%&gt;));\n\t}\n};\nfinal int fieldsStructureCounts = ((&lt;%java.lang.Object%&gt;[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;&gt;filter(fields, _function_1), &lt;%java.lang.Object%&gt;.class)).length;\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_2 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.data.DataField%&gt; it)\n\t{\n\t\t&lt;%de.fhdo.ddmm.data.Type%&gt; _effectiveType = it.getEffectiveType();\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((_effectiveType instanceof &lt;%de.fhdo.ddmm.data.ListType%&gt;));\n\t}\n};\nfinal int fieldsListCounts = ((&lt;%java.lang.Object%&gt;[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;&gt;filter(fields, _function_2), &lt;%java.lang.Object%&gt;.class)).length;\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_3 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.data.DataField%&gt; it)\n\t{\n\t\t&lt;%de.fhdo.ddmm.data.Type%&gt; _effectiveType = it.getEffectiveType();\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((_effectiveType instanceof &lt;%de.fhdo.ddmm.data.PrimitiveType%&gt;));\n\t}\n};\nfinal int primitiveCountsToCompare = ((&lt;%java.lang.Object%&gt;[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;&gt;filter(fieldsToCompare, _function_3), &lt;%java.lang.Object%&gt;.class)).length;\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_4 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.data.DataField%&gt; it)\n\t{\n\t\t&lt;%de.fhdo.ddmm.data.Type%&gt; _effectiveType = it.getEffectiveType();\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((_effectiveType instanceof &lt;%de.fhdo.ddmm.data.DataStructure%&gt;));\n\t}\n};\nfinal int structureCountsToCompare = ((&lt;%java.lang.Object%&gt;[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;&gt;filter(fieldsToCompare, _function_4), &lt;%java.lang.Object%&gt;.class)).length;\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_5 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.data.DataField%&gt; it)\n\t{\n\t\t&lt;%de.fhdo.ddmm.data.Type%&gt; _effectiveType = it.getEffectiveType();\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((_effectiveType instanceof &lt;%de.fhdo.ddmm.data.ListType%&gt;));\n\t}\n};\nfinal int listCountsToCompare = ((&lt;%java.lang.Object%&gt;[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;&gt;filter(fieldsToCompare, _function_5), &lt;%java.lang.Object%&gt;.class)).length;\nif ((((fieldsPrimitiveCounts == primitiveCountsToCompare) &amp;&amp; \n\t(fieldsStructureCounts == structureCountsToCompare)) &amp;&amp; \n\t(fieldsListCounts == listCountsToCompare)))\n{\n\treturn 0;\n}\nelse\n{\n\tif ((((fieldsPrimitiveCounts &gt;= primitiveCountsToCompare) &amp;&amp; \n\t\t(fieldsStructureCounts &gt;= structureCountsToCompare)) &amp;&amp; \n\t\t(fieldsListCounts &gt;= listCountsToCompare)))\n\t{\n\t\treturn 1;\n\t}\n}\nreturn (-1);'"
     * @generated
     */
    int compareFieldCounts(EList<DataField> fields, EList<DataField> fieldsToCompare);

} // ComplexType
