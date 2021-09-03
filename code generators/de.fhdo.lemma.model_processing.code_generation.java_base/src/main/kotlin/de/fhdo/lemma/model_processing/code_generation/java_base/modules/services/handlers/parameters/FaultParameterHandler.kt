package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers.parameters

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.java.ast.utils.ImportTargetElementType
import de.fhdo.lemma.java.ast.utils.addAllAttributesConstructor
import de.fhdo.lemma.java.ast.utils.addAttribute
import de.fhdo.lemma.java.ast.utils.insertStatement
import de.fhdo.lemma.java.ast.utils.newJavaClassOrInterface
import de.fhdo.lemma.java.ast.utils.setBody
import de.fhdo.lemma.java.ast.utils.setSuperclass
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAttribute
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.buildExceptionClassName
import de.fhdo.lemma.model_processing.code_generation.java_base.buildOperationPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.generateCustomExceptionClassFor
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.VisitingCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.utils.packageToPath
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.ServicesContext.State as ServicesState
import de.fhdo.lemma.service.intermediate.IntermediateParameter
import de.fhdo.lemma.technology.CommunicationType
import java.io.File

/**
 * Code generation handler for IntermediateParameter instances that represent faults.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
class FaultParameterHandler
    : VisitingCodeGenerationHandlerI<IntermediateParameter, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateParameter::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java
    override fun getAspects(eObject: IntermediateParameter) = eObject.aspects!!

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateParameter, context: Nothing?)
        : Pair<ClassOrInterfaceDeclaration, String?>? {
        // Currently we only support synchronous fault parameters
        if (!eObject.isCommunicatesFault || eObject.communicationType == CommunicationType.ASYNCHRONOUS.name)
            return null

        /*
         * If the parameter's type is not a type known to the Java base generator, we delegate its handling to Genlets.
         * This mechanism enables the treatment of technology-specific Exception classes, i.e., fault parameters may be
         * typed by technology-specific Exception classes, and Genlets add imports and throws declarations for them to
         * the parameter's target method. Thus, we do not generate a custom Exception class in this case. A drawback of
         * this approach, however, is that those Exception classes cannot exhibit custom code. In the future, this could
         * be supported leveraging a dedicated aspect that results in a custom Exception class being generated, which
         * inherits from the Exception class with which the fault parameter is typed.
         */
        if (!eObject.generateCustomExceptionClassFor())
            return null

        /* Each fault parameter is mapped to an Exception class with the parameter as its attribute */
        val exceptionClassName = eObject.buildExceptionClassName()
        val generatedClass = newJavaClassOrInterface(eObject.buildOperationPackageName(), exceptionClassName)
        generatedClass.setSuperclass("RuntimeException", isExternalSuperclass = true)
        generatedClass.addImport("RuntimeException", ImportTargetElementType.SUPER)

        // Add parameter attribute to Exception class
        val parameterAttribute = generatedClass.addAttribute(eObject.name, eObject.type, generatedClass,
            Modifier.Keyword.PROTECTED) { generatedClass.addImport(it, ImportTargetElementType.METHOD) }
        val parameterAttributeType = parameterAttribute.variables[0].typeAsString

        // Add error message attribute to Exception class
        val errorMessageAttribute = if (eObject.name == "errorMessage") "errorMessage2" else "errorMessage"
        generatedClass.addAttribute(errorMessageAttribute, "String", Modifier.Keyword.PROTECTED)

        /* If the parameter is optional, a parameterless constructor is added to the class */
        if (eObject.isOptional) {
            val parameterlessConstructor = generatedClass.addConstructor(Modifier.Keyword.PUBLIC)
            parameterlessConstructor.setBody("super();")

            // Add constructor for error message, if its String type does not collide with the one of the optional
            // parameter, which would lead to constructors with ambiguous signatures
            if (parameterAttributeType != "String") {
                val errorMessageConstructor = generatedClass.addConstructor(Modifier.Keyword.PUBLIC)
                errorMessageConstructor.addParameter("String", errorMessageAttribute)
                errorMessageConstructor.setBody(
                    "super($errorMessageAttribute);",
                    "this.$errorMessageAttribute = $errorMessageAttribute;"
                )
            }
        }

        /* Add constructor for the parameter attribute */
        val parameterConstructor = generatedClass.addConstructor(Modifier.Keyword.PUBLIC)
        parameterConstructor.addParameter(parameterAttributeType, eObject.name)
        parameterConstructor.setBody("super();", "this.${eObject.name} = ${eObject.name};")

        /* Add constructor for initializing all attributes, i.e., the parameter and the error message attribute */
        generatedClass.addAllAttributesConstructor()!!.insertStatement("super($errorMessageAttribute);")

        /* Build target path for Exception class and return it together with the class */
        val interfaceSubFolderName: String by ServicesState
        val operationSubFolder = eObject.buildOperationPackageName(subPackageOnly = true).packageToPath()
        val exceptionClassFolderPath = "$interfaceSubFolderName${File.separator}$operationSubFolder"
        return generatedClass to "$exceptionClassFolderPath${File.separator}$exceptionClassName.java"
    }
}