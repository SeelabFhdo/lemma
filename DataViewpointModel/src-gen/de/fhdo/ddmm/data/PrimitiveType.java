/**
 */
package de.fhdo.ddmm.data;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents built-in primitive types that correspond to Java's primitive types in syntax,
 * semantics, namingm and size. Strings and dates, however, are also treated as primitive types.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.data.PrimitiveType#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.PrimitiveType#getTypeSize <em>Type Size</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.data.DataPackage#getPrimitiveType()
 * @model abstract="true"
 * @generated
 */
public interface PrimitiveType extends Type {
    /**
     * Returns the value of the '<em><b>Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get printable name of PrimitiveType instance
     * <!-- end-model-doc -->
     * @return the value of the '<em>Type Name</em>' attribute.
     * @see de.fhdo.ddmm.data.DataPackage#getPrimitiveType_TypeName()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%java.lang.String%&gt; _switchResult = null;\nboolean _matched = false;\nif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveBoolean%&gt;)\n{\n\t_matched=true;\n\t_switchResult = \"boolean\";\n}\nif (!_matched)\n{\n\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveByte%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = \"byte\";\n\t}\n}\nif (!_matched)\n{\n\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveCharacter%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = \"char\";\n\t}\n}\nif (!_matched)\n{\n\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveDate%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = \"date\";\n\t}\n}\nif (!_matched)\n{\n\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveDouble%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = \"double\";\n\t}\n}\nif (!_matched)\n{\n\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveFloat%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = \"float\";\n\t}\n}\nif (!_matched)\n{\n\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveInteger%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = \"int\";\n\t}\n}\nif (!_matched)\n{\n\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveLong%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = \"long\";\n\t}\n}\nif (!_matched)\n{\n\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveShort%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = \"short\";\n\t}\n}\nif (!_matched)\n{\n\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveString%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = \"string\";\n\t}\n}\nif (!_matched)\n{\n\t_switchResult = null;\n}\nreturn _switchResult;'"
     * @generated
     */
    String getTypeName();

    /**
     * Returns the value of the '<em><b>Type Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get size of built-in primitive type
     * <!-- end-model-doc -->
     * @return the value of the '<em>Type Size</em>' attribute.
     * @see de.fhdo.ddmm.data.DataPackage#getPrimitiveType_TypeSize()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%java.lang.Integer%&gt; _switchResult = null;\nboolean _matched = false;\nif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveBoolean%&gt;)\n{\n\t_matched=true;\n\t_switchResult = &lt;%java.lang.Integer%&gt;.valueOf(1);\n}\nif (!_matched)\n{\n\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveByte%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = &lt;%java.lang.Integer%&gt;.valueOf(8);\n\t}\n}\nif (!_matched)\n{\n\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveCharacter%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = &lt;%java.lang.Integer%&gt;.valueOf(16);\n\t}\n}\nif (!_matched)\n{\n\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveDate%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = null;\n\t}\n}\nif (!_matched)\n{\n\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveDouble%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = &lt;%java.lang.Integer%&gt;.valueOf(64);\n\t}\n}\nif (!_matched)\n{\n\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveFloat%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = &lt;%java.lang.Integer%&gt;.valueOf(32);\n\t}\n}\nif (!_matched)\n{\n\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveInteger%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = &lt;%java.lang.Integer%&gt;.valueOf(32);\n\t}\n}\nif (!_matched)\n{\n\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveLong%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = &lt;%java.lang.Integer%&gt;.valueOf(64);\n\t}\n}\nif (!_matched)\n{\n\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveShort%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = &lt;%java.lang.Integer%&gt;.valueOf(16);\n\t}\n}\nif (!_matched)\n{\n\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveString%&gt;)\n\t{\n\t\t_matched=true;\n\t\t_switchResult = null;\n\t}\n}\nif (!_matched)\n{\n\t_switchResult = null;\n}\nreturn _switchResult;'"
     * @generated
     */
    Integer getTypeSize();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Compare the size of two built-in primitive types, following the semantics of Java's
     * Comparator.compare() method
     * <!-- end-model-doc -->
     * @model unique="false" typeToCompareUnique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if ((typeToCompare == null))\n{\n\treturn 1;\n}\nif (((this.getTypeName() != null) &amp;&amp; &lt;%com.google.common.base.Objects%&gt;.equal(this.getTypeName(), typeToCompare.getTypeName())))\n{\n\treturn 0;\n}\nfinal &lt;%java.lang.Integer%&gt; typeToCompareSize = typeToCompare.getTypeSize();\n&lt;%java.lang.Integer%&gt; _typeSize = this.getTypeSize();\nboolean _tripleEquals = (_typeSize == null);\nif (_tripleEquals)\n{\n\tif ((typeToCompareSize == null))\n\t{\n\t\treturn 0;\n\t}\n\telse\n\t{\n\t\treturn 1;\n\t}\n}\nelse\n{\n\tif ((typeToCompareSize == null))\n\t{\n\t\treturn (-1);\n\t}\n\telse\n\t{\n\t\t&lt;%java.lang.Integer%&gt; _typeSize_1 = this.getTypeSize();\n\t\tboolean _greaterThan = (_typeSize_1.compareTo(typeToCompareSize) &gt; 0);\n\t\tif (_greaterThan)\n\t\t{\n\t\t\treturn 1;\n\t\t}\n\t\telse\n\t\t{\n\t\t\t&lt;%java.lang.Integer%&gt; _typeSize_2 = this.getTypeSize();\n\t\t\tboolean _lessThan = (_typeSize_2.compareTo(typeToCompareSize) &lt; 0);\n\t\t\tif (_lessThan)\n\t\t\t{\n\t\t\t\treturn (-1);\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\treturn 0;\n\t\t\t}\n\t\t}\n\t}\n}'"
     * @generated
     */
    int sizeCompare(PrimitiveType typeToCompare);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Check if type is compatible with another built-in primitive type
     * <!-- end-model-doc -->
     * @model unique="false" typeToCheckUnique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (((typeToCheck != null) &amp;&amp; &lt;%com.google.common.base.Objects%&gt;.equal(typeToCheck.getTypeName(), this.getTypeName())))\n{\n\treturn true;\n}\nif ((typeToCheck instanceof &lt;%de.fhdo.ddmm.data.PrimitiveByte%&gt;))\n{\n\tboolean _matched = false;\n\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveShort%&gt;)\n\t{\n\t\t_matched=true;\n\t}\n\tif (!_matched)\n\t{\n\t\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveInteger%&gt;)\n\t\t{\n\t\t\t_matched=true;\n\t\t}\n\t}\n\tif (!_matched)\n\t{\n\t\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveLong%&gt;)\n\t\t{\n\t\t\t_matched=true;\n\t\t}\n\t}\n\tif (!_matched)\n\t{\n\t\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveFloat%&gt;)\n\t\t{\n\t\t\t_matched=true;\n\t\t}\n\t}\n\tif (!_matched)\n\t{\n\t\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveDouble%&gt;)\n\t\t{\n\t\t\t_matched=true;\n\t\t}\n\t}\n\tif (_matched)\n\t{\n\t\treturn true;\n\t}\n}\nelse\n{\n\tif ((typeToCheck instanceof &lt;%de.fhdo.ddmm.data.PrimitiveShort%&gt;))\n\t{\n\t\tboolean _matched_1 = false;\n\t\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveInteger%&gt;)\n\t\t{\n\t\t\t_matched_1=true;\n\t\t}\n\t\tif (!_matched_1)\n\t\t{\n\t\t\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveLong%&gt;)\n\t\t\t{\n\t\t\t\t_matched_1=true;\n\t\t\t}\n\t\t}\n\t\tif (!_matched_1)\n\t\t{\n\t\t\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveFloat%&gt;)\n\t\t\t{\n\t\t\t\t_matched_1=true;\n\t\t\t}\n\t\t}\n\t\tif (!_matched_1)\n\t\t{\n\t\t\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveDouble%&gt;)\n\t\t\t{\n\t\t\t\t_matched_1=true;\n\t\t\t}\n\t\t}\n\t\tif (_matched_1)\n\t\t{\n\t\t\treturn true;\n\t\t}\n\t}\n\telse\n\t{\n\t\tif ((typeToCheck instanceof &lt;%de.fhdo.ddmm.data.PrimitiveCharacter%&gt;))\n\t\t{\n\t\t\tboolean _matched_2 = false;\n\t\t\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveInteger%&gt;)\n\t\t\t{\n\t\t\t\t_matched_2=true;\n\t\t\t}\n\t\t\tif (!_matched_2)\n\t\t\t{\n\t\t\t\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveLong%&gt;)\n\t\t\t\t{\n\t\t\t\t\t_matched_2=true;\n\t\t\t\t}\n\t\t\t}\n\t\t\tif (!_matched_2)\n\t\t\t{\n\t\t\t\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveFloat%&gt;)\n\t\t\t\t{\n\t\t\t\t\t_matched_2=true;\n\t\t\t\t}\n\t\t\t}\n\t\t\tif (!_matched_2)\n\t\t\t{\n\t\t\t\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveDouble%&gt;)\n\t\t\t\t{\n\t\t\t\t\t_matched_2=true;\n\t\t\t\t}\n\t\t\t}\n\t\t\tif (!_matched_2)\n\t\t\t{\n\t\t\t\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveString%&gt;)\n\t\t\t\t{\n\t\t\t\t\t_matched_2=true;\n\t\t\t\t}\n\t\t\t}\n\t\t\tif (_matched_2)\n\t\t\t{\n\t\t\t\treturn true;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif ((typeToCheck instanceof &lt;%de.fhdo.ddmm.data.PrimitiveInteger%&gt;))\n\t\t\t{\n\t\t\t\tboolean _matched_3 = false;\n\t\t\t\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveLong%&gt;)\n\t\t\t\t{\n\t\t\t\t\t_matched_3=true;\n\t\t\t\t}\n\t\t\t\tif (!_matched_3)\n\t\t\t\t{\n\t\t\t\t\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveFloat%&gt;)\n\t\t\t\t\t{\n\t\t\t\t\t\t_matched_3=true;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tif (!_matched_3)\n\t\t\t\t{\n\t\t\t\t\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveDouble%&gt;)\n\t\t\t\t\t{\n\t\t\t\t\t\t_matched_3=true;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tif (_matched_3)\n\t\t\t\t{\n\t\t\t\t\treturn true;\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif ((typeToCheck instanceof &lt;%de.fhdo.ddmm.data.PrimitiveLong%&gt;))\n\t\t\t\t{\n\t\t\t\t\tboolean _matched_4 = false;\n\t\t\t\t\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveFloat%&gt;)\n\t\t\t\t\t{\n\t\t\t\t\t\t_matched_4=true;\n\t\t\t\t\t}\n\t\t\t\t\tif (!_matched_4)\n\t\t\t\t\t{\n\t\t\t\t\t\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveDouble%&gt;)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t_matched_4=true;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tif (_matched_4)\n\t\t\t\t\t{\n\t\t\t\t\t\treturn true;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif ((typeToCheck instanceof &lt;%de.fhdo.ddmm.data.PrimitiveFloat%&gt;))\n\t\t\t\t\t{\n\t\t\t\t\t\tboolean _matched_5 = false;\n\t\t\t\t\t\tif (this instanceof &lt;%de.fhdo.ddmm.data.PrimitiveDouble%&gt;)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t_matched_5=true;\n\t\t\t\t\t\t\treturn true;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n}\nreturn false;'"
     * @generated
     */
    boolean isCompatibleWith(PrimitiveType typeToCheck);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Convenience operation for retrieving all concrete built-in primitive types' meta-classes
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%java.util.ArrayList%&gt;&lt;&lt;%java.lang.Class%&gt;&lt;?&gt;&gt; primitiveTypes = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.Class%&gt;&lt;?&gt;&gt;newArrayList();\nprimitiveTypes.add(&lt;%de.fhdo.ddmm.data.PrimitiveBoolean%&gt;.class);\nprimitiveTypes.add(&lt;%de.fhdo.ddmm.data.PrimitiveByte%&gt;.class);\nprimitiveTypes.add(&lt;%de.fhdo.ddmm.data.PrimitiveCharacter%&gt;.class);\nprimitiveTypes.add(&lt;%de.fhdo.ddmm.data.PrimitiveDate%&gt;.class);\nprimitiveTypes.add(&lt;%de.fhdo.ddmm.data.PrimitiveDouble%&gt;.class);\nprimitiveTypes.add(&lt;%de.fhdo.ddmm.data.PrimitiveFloat%&gt;.class);\nprimitiveTypes.add(&lt;%de.fhdo.ddmm.data.PrimitiveInteger%&gt;.class);\nprimitiveTypes.add(&lt;%de.fhdo.ddmm.data.PrimitiveLong%&gt;.class);\nprimitiveTypes.add(&lt;%de.fhdo.ddmm.data.PrimitiveShort%&gt;.class);\nprimitiveTypes.add(&lt;%de.fhdo.ddmm.data.PrimitiveString%&gt;.class);\nreturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.Class%&gt;&lt;?&gt;&gt;asEList(primitiveTypes);'"
     * @generated
     */
    EList<Class<?>> getBuiltinPrimitiveTypes();

} // PrimitiveType
