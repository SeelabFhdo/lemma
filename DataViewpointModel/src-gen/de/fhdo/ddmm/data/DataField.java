/**
 */
package de.fhdo.ddmm.data;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents a typed and named field in a data structure or structured list
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.data.DataField#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.DataField#isHidden <em>Hidden</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.DataField#getComplexType <em>Complex Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.DataField#getPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.DataField#getDataStructure <em>Data Structure</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.DataField#getListType <em>List Type</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.data.DataPackage#getDataField()
 * @model
 * @generated
 */
public interface DataField extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) May either have a complex or primitive type, not both.
     *          Ensured by: DSL grammar.
     *     (C2) Must have a type or be hidden.
     *          Ensured by: DSL validator.
     *     (C3) The field must have a type if either no field with an equal name exists in a super
     *          data structure, or if an eponymous super field exists that is hidden.
     *          Ensured by: DSL validator.
     *     (C3) If an eponymous super field exists that is not hidden, than this field must not have
     *          a type, i.e., a visible super field cannot be redefined in a sub-structure.
     *          Ensured by: DSL validator.
     *     (C4) Name must be unique within a data structure.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.ddmm.data.DataPackage#getDataField_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.DataField#getName <em>Name</em>}' attribute.
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
     * <p>
     * If the meaning of the '<em>Hidden</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hidden</em>' attribute.
     * @see #setHidden(boolean)
     * @see de.fhdo.ddmm.data.DataPackage#getDataField_Hidden()
     * @model unique="false"
     * @generated
     */
    boolean isHidden();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.DataField#isHidden <em>Hidden</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Hidden</em>' attribute.
     * @see #isHidden()
     * @generated
     */
    void setHidden(boolean value);

    /**
     * Returns the value of the '<em><b>Complex Type</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.data.PossiblyImportedComplexType#getDataField <em>Data Field</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Complex Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Complex Type</em>' containment reference.
     * @see #setComplexType(PossiblyImportedComplexType)
     * @see de.fhdo.ddmm.data.DataPackage#getDataField_ComplexType()
     * @see de.fhdo.ddmm.data.PossiblyImportedComplexType#getDataField
     * @model opposite="dataField" containment="true"
     * @generated
     */
    PossiblyImportedComplexType getComplexType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.DataField#getComplexType <em>Complex Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Complex Type</em>' containment reference.
     * @see #getComplexType()
     * @generated
     */
    void setComplexType(PossiblyImportedComplexType value);

    /**
     * Returns the value of the '<em><b>Primitive Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Primitive Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Primitive Type</em>' containment reference.
     * @see #setPrimitiveType(PrimitiveType)
     * @see de.fhdo.ddmm.data.DataPackage#getDataField_PrimitiveType()
     * @model containment="true"
     * @generated
     */
    PrimitiveType getPrimitiveType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.DataField#getPrimitiveType <em>Primitive Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Primitive Type</em>' containment reference.
     * @see #getPrimitiveType()
     * @generated
     */
    void setPrimitiveType(PrimitiveType value);

    /**
     * Returns the value of the '<em><b>Data Structure</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.data.DataStructure#getDataFields <em>Data Fields</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Structure</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Structure</em>' container reference.
     * @see #setDataStructure(DataStructure)
     * @see de.fhdo.ddmm.data.DataPackage#getDataField_DataStructure()
     * @see de.fhdo.ddmm.data.DataStructure#getDataFields
     * @model opposite="dataFields" transient="false"
     * @generated
     */
    DataStructure getDataStructure();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.DataField#getDataStructure <em>Data Structure</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Structure</em>' container reference.
     * @see #getDataStructure()
     * @generated
     */
    void setDataStructure(DataStructure value);

    /**
     * Returns the value of the '<em><b>List Type</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.data.ListType#getDataFields <em>Data Fields</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>List Type</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>List Type</em>' container reference.
     * @see #setListType(ListType)
     * @see de.fhdo.ddmm.data.DataPackage#getDataField_ListType()
     * @see de.fhdo.ddmm.data.ListType#getDataFields
     * @model opposite="dataFields" transient="false"
     * @generated
     */
    ListType getListType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.data.DataField#getListType <em>List Type</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>List Type</em>' container reference.
     * @see #getListType()
     * @generated
     */
    void setListType(ListType value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get the effective type (complex type, possibly imported, or primitive type) of the field
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%de.fhdo.ddmm.data.PossiblyImportedComplexType%&gt; _complexType = this.getComplexType();\nboolean _tripleNotEquals = (_complexType != null);\nif (_tripleNotEquals)\n{\n\treturn this.getComplexType().getComplexType();\n}\nelse\n{\n\t&lt;%de.fhdo.ddmm.data.PrimitiveType%&gt; _primitiveType = this.getPrimitiveType();\n\tboolean _tripleNotEquals_1 = (_primitiveType != null);\n\tif (_tripleNotEquals_1)\n\t{\n\t\treturn this.getPrimitiveType();\n\t}\n\telse\n\t{\n\t\treturn null;\n\t}\n}'"
     * @generated
     */
    Type getEffectiveType();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get parts of the data field for creating a qualified name
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; _xblockexpression = null;\n{\n\tif (((this.getName() == null) || this.getName().isEmpty()))\n\t{\n\t\treturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(&lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;newArrayList());\n\t}\n\tfinal &lt;%java.util.ArrayList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; nameParts = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;newArrayList();\n\t&lt;%de.fhdo.ddmm.data.DataStructure%&gt; _dataStructure = this.getDataStructure();\n\tboolean _tripleNotEquals = (_dataStructure != null);\n\tif (_tripleNotEquals)\n\t{\n\t\tnameParts.addAll(this.getDataStructure().getQualifiedNameParts());\n\t}\n\telse\n\t{\n\t\t&lt;%de.fhdo.ddmm.data.ListType%&gt; _listType = this.getListType();\n\t\tboolean _tripleNotEquals_1 = (_listType != null);\n\t\tif (_tripleNotEquals_1)\n\t\t{\n\t\t\tnameParts.addAll(this.getListType().getQualifiedNameParts());\n\t\t}\n\t}\n\tnameParts.add(this.getName());\n\t_xblockexpression = &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(nameParts);\n}\nreturn _xblockexpression;'"
     * @generated
     */
    EList<String> getQualifiedNameParts();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Find an eponymous field in the inheritance hierarchy of this field's data structure. Returns
     * null, if this field is not part of a data structure, as only data structures may extend other
     * data structures.
     * <!-- end-model-doc -->
     * @model unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%de.fhdo.ddmm.data.DataStructure%&gt; _dataStructure = this.getDataStructure();\nboolean _tripleEquals = (_dataStructure == null);\nif (_tripleEquals)\n{\n\treturn null;\n}\nif (((this.getName() == null) || this.getName().isEmpty()))\n{\n\treturn null;\n}\n&lt;%de.fhdo.ddmm.data.DataStructure%&gt; superStructure = this.getDataStructure().getSuper();\nwhile ((superStructure != null))\n{\n\t{\n\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t\t{\n\t\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%de.fhdo.ddmm.data.DataField%&gt; it)\n\t\t\t{\n\t\t\t\t&lt;%java.lang.String%&gt; _name = &lt;%this%&gt;.getName();\n\t\t\t\t&lt;%java.lang.String%&gt; _name_1 = it.getName();\n\t\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(&lt;%com.google.common.base.Objects%&gt;.equal(_name, _name_1));\n\t\t\t}\n\t\t};\n\t\tfinal &lt;%de.fhdo.ddmm.data.DataField%&gt; overridenField = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.data.DataField%&gt;&gt;findFirst(superStructure.getDataFields(), _function);\n\t\tif ((overridenField != null))\n\t\t{\n\t\t\treturn overridenField;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tsuperStructure = superStructure.getSuper();\n\t\t}\n\t}\n}\nreturn null;'"
     * @generated
     */
    DataField findEponymousSuperField();

} // DataField
