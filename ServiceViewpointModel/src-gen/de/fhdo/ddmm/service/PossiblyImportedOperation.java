/**
 */
package de.fhdo.ddmm.service;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Possibly Imported Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * An operation possibly imported from another service model
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.PossiblyImportedOperation#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.PossiblyImportedOperation#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.PossiblyImportedOperation#getRequiringMicroservice <em>Requiring Microservice</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.PossiblyImportedOperation#getInitializedParameter <em>Initialized Parameter</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.PossiblyImportedOperation#isRequired <em>Required</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.PossiblyImportedOperation#isRequiredByInterface <em>Required By Interface</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.PossiblyImportedOperation#isRequiredByMicroservice <em>Required By Microservice</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.PossiblyImportedOperation#isRequiredByContainer <em>Required By Container</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.ServicePackage#getPossiblyImportedOperation()
 * @model
 * @generated
 */
public interface PossiblyImportedOperation extends EObject {
    /**
     * Returns the value of the '<em><b>Import</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Import</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Import</em>' reference.
     * @see #setImport(Import)
     * @see de.fhdo.ddmm.service.ServicePackage#getPossiblyImportedOperation_Import()
     * @model
     * @generated
     */
    Import getImport();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.PossiblyImportedOperation#getImport <em>Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Import</em>' reference.
     * @see #getImport()
     * @generated
     */
    void setImport(Import value);

    /**
     * Returns the value of the '<em><b>Operation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation</em>' reference.
     * @see #setOperation(Operation)
     * @see de.fhdo.ddmm.service.ServicePackage#getPossiblyImportedOperation_Operation()
     * @model
     * @generated
     */
    Operation getOperation();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.PossiblyImportedOperation#getOperation <em>Operation</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation</em>' reference.
     * @see #getOperation()
     * @generated
     */
    void setOperation(Operation value);

    /**
     * Returns the value of the '<em><b>Requiring Microservice</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Microservice#getRequiredOperations <em>Required Operations</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Requiring Microservice</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Requiring Microservice</em>' container reference.
     * @see #setRequiringMicroservice(Microservice)
     * @see de.fhdo.ddmm.service.ServicePackage#getPossiblyImportedOperation_RequiringMicroservice()
     * @see de.fhdo.ddmm.service.Microservice#getRequiredOperations
     * @model opposite="requiredOperations" transient="false"
     * @generated
     */
    Microservice getRequiringMicroservice();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.PossiblyImportedOperation#getRequiringMicroservice <em>Requiring Microservice</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Requiring Microservice</em>' container reference.
     * @see #getRequiringMicroservice()
     * @generated
     */
    void setRequiringMicroservice(Microservice value);

    /**
     * Returns the value of the '<em><b>Initialized Parameter</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.service.Parameter#getInitializedByOperation <em>Initialized By Operation</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Initialized Parameter</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Initialized Parameter</em>' container reference.
     * @see #setInitializedParameter(Parameter)
     * @see de.fhdo.ddmm.service.ServicePackage#getPossiblyImportedOperation_InitializedParameter()
     * @see de.fhdo.ddmm.service.Parameter#getInitializedByOperation
     * @model opposite="initializedByOperation" transient="false"
     * @generated
     */
    Parameter getInitializedParameter();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.PossiblyImportedOperation#getInitializedParameter <em>Initialized Parameter</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Initialized Parameter</em>' container reference.
     * @see #getInitializedParameter()
     * @generated
     */
    void setInitializedParameter(Parameter value);

    /**
     * Returns the value of the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Flag to indicate if the operation is required by a microservice
     * <!-- end-model-doc -->
     * @return the value of the '<em>Required</em>' attribute.
     * @see de.fhdo.ddmm.service.ServicePackage#getPossiblyImportedOperation_Required()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%de.fhdo.ddmm.service.Microservice%&gt; _requiringMicroservice = this.getRequiringMicroservice();\nreturn (_requiringMicroservice != null);'"
     * @generated
     */
    boolean isRequired();

    /**
     * Returns the value of the '<em><b>Required By Interface</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Flag to indicate if the operation is already required, because its interface is required
     * <!-- end-model-doc -->
     * @return the value of the '<em>Required By Interface</em>' attribute.
     * @see de.fhdo.ddmm.service.ServicePackage#getPossiblyImportedOperation_RequiredByInterface()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='if ((((this.getOperation() == null) || \n\t(!this.isRequired())) || \n\t(this.getRequiringMicroservice().getRequiredInterfaces() == null)))\n{\n\treturn false;\n}\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt;, &lt;%de.fhdo.ddmm.service.Interface%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt;, &lt;%de.fhdo.ddmm.service.Interface%&gt;&gt;()\n{\n\tpublic &lt;%de.fhdo.ddmm.service.Interface%&gt; apply(final &lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt; it)\n\t{\n\t\treturn it.getInterface();\n\t}\n};\nboolean _contains = &lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedInterface%&gt;, &lt;%de.fhdo.ddmm.service.Interface%&gt;&gt;map(this.getRequiringMicroservice().getRequiredInterfaces(), _function).contains(this.getOperation().getInterface());\nif (_contains)\n{\n\treturn true;\n}\nreturn false;'"
     * @generated
     */
    boolean isRequiredByInterface();

    /**
     * Returns the value of the '<em><b>Required By Microservice</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Flag to indicate if the operation is already required, because its microservice is required
     * <!-- end-model-doc -->
     * @return the value of the '<em>Required By Microservice</em>' attribute.
     * @see de.fhdo.ddmm.service.ServicePackage#getPossiblyImportedOperation_RequiredByMicroservice()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='if (((((this.getOperation() == null) || \n\t(!this.isRequired())) || \n\t(this.getRequiringMicroservice().getRequiredMicroservices() == null)) || \n\t(this.getOperation().getInterface() == null)))\n{\n\treturn false;\n}\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt;, &lt;%de.fhdo.ddmm.service.Microservice%&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt;, &lt;%de.fhdo.ddmm.service.Microservice%&gt;&gt;()\n{\n\tpublic &lt;%de.fhdo.ddmm.service.Microservice%&gt; apply(final &lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt; it)\n\t{\n\t\treturn it.getMicroservice();\n\t}\n};\nboolean _contains = &lt;%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%&gt;.&lt;&lt;%de.fhdo.ddmm.service.PossiblyImportedMicroservice%&gt;, &lt;%de.fhdo.ddmm.service.Microservice%&gt;&gt;map(this.getRequiringMicroservice().getRequiredMicroservices(), _function).contains(this.getOperation().getInterface().getMicroservice());\nif (_contains)\n{\n\treturn true;\n}\nreturn false;'"
     * @generated
     */
    boolean isRequiredByMicroservice();

    /**
     * Returns the value of the '<em><b>Required By Container</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Flag to indicate if the operation is already required, because its containers, i.e., its
     * interface or indirectly containing microservice, is required
     * <!-- end-model-doc -->
     * @return the value of the '<em>Required By Container</em>' attribute.
     * @see de.fhdo.ddmm.service.ServicePackage#getPossiblyImportedOperation_RequiredByContainer()
     * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return (this.isRequiredByInterface() || this.isRequiredByMicroservice());'"
     * @generated
     */
    boolean isRequiredByContainer();

} // PossiblyImportedOperation
