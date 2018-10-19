/**
 */
package de.fhdo.ddmm.service;

import de.fhdo.ddmm.data.DataField;
import de.fhdo.ddmm.data.Type;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapped Data Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Concept to express technology-specific information, which was assigned to a data field leveraging
 * the Mapping DSL
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.MappedDataField#getDataField <em>Data Field</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.MappedDataField#getMappedType <em>Mapped Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.MappedDataField#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.MappedDataField#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.ServicePackage#getMappedDataField()
 * @model
 * @generated
 */
public interface MappedDataField extends EObject {
    /**
     * Returns the value of the '<em><b>Data Field</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Field</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Field</em>' reference.
     * @see #setDataField(DataField)
     * @see de.fhdo.ddmm.service.ServicePackage#getMappedDataField_DataField()
     * @model
     * @generated
     */
    DataField getDataField();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.MappedDataField#getDataField <em>Data Field</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Field</em>' reference.
     * @see #getDataField()
     * @generated
     */
    void setDataField(DataField value);

    /**
     * Returns the value of the '<em><b>Mapped Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mapped Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mapped Type</em>' containment reference.
     * @see #setMappedType(ImportedType)
     * @see de.fhdo.ddmm.service.ServicePackage#getMappedDataField_MappedType()
     * @model containment="true"
     * @generated
     */
    ImportedType getMappedType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.MappedDataField#getMappedType <em>Mapped Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mapped Type</em>' containment reference.
     * @see #getMappedType()
     * @generated
     */
    void setMappedType(ImportedType value);

    /**
     * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.ImportedServiceAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.ImportedServiceAspect#getMappedDataField <em>Mapped Data Field</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.ddmm.service.ServicePackage#getMappedDataField_Aspects()
     * @see de.fhdo.ddmm.service.ImportedServiceAspect#getMappedDataField
     * @model opposite="mappedDataField" containment="true"
     * @generated
     */
    EList<ImportedServiceAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Parameter</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Parameter#getMappedDataFields <em>Mapped Data Fields</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameter</em>' container reference.
     * @see #setParameter(Parameter)
     * @see de.fhdo.ddmm.service.ServicePackage#getMappedDataField_Parameter()
     * @see de.fhdo.ddmm.service.Parameter#getMappedDataFields
     * @model opposite="mappedDataFields" transient="false"
     * @generated
     */
    Parameter getParameter();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.MappedDataField#getParameter <em>Parameter</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parameter</em>' container reference.
     * @see #getParameter()
     * @generated
     */
    void setParameter(Parameter value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get parts of the parameter for creating a qualified name
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; _xblockexpression = null;\n{\n\tif (((this.getDataField() == null) || this.getDataField().getName().isEmpty()))\n\t{\n\t\treturn &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(&lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;newArrayList());\n\t}\n\tfinal &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; nameParts = this.getParameter().getQualifiedNameParts();\n\t&lt;%org.eclipse.xtext.xbase.lib.CollectionExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;addAll(nameParts, this.getDataField().getName());\n\t_xblockexpression = &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;asEList(nameParts);\n}\nreturn _xblockexpression;'"
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
     * Get the effective type of the mapped data field. The effective type corresponds to the mapped
     * type, if the field has one. Otherwise, it is the effective type of the field itself.
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%de.fhdo.ddmm.service.ImportedType%&gt; _mappedType = this.getMappedType();\nboolean _tripleNotEquals = (_mappedType != null);\nif (_tripleNotEquals)\n{\n\treturn this.getMappedType().getType();\n}\nelse\n{\n\t&lt;%de.fhdo.ddmm.data.DataField%&gt; _dataField = this.getDataField();\n\tboolean _tripleNotEquals_1 = (_dataField != null);\n\tif (_tripleNotEquals_1)\n\t{\n\t\treturn this.getDataField().getEffectiveType();\n\t}\n\telse\n\t{\n\t\treturn null;\n\t}\n}'"
     * @generated
     */
    Type getEffectiveType();

} // MappedDataField
