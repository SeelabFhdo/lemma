package de.fhdo.lemma.model_processing.code_generation.lakeside_mutual.handlers

import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataOperation
import de.fhdo.lemma.data.intermediate.IntermediateCollectionType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependencies
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletPathSpecifier
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedFileContent
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getTypeMapping
import de.fhdo.lemma.model_processing.code_generation.java_base.resolve
import java.io.File

@CodeGenerationHandler
internal class IntermediateDataOperationHandler
    : GenletCodeGenerationHandlerI<IntermediateDataOperation, MethodDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateDataOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java

    override fun getAspects(eObject: IntermediateDataOperation) = eObject.aspects!!

    override fun execute(eObject: IntermediateDataOperation, node: MethodDeclaration, context: Nothing?)
        : GenletCodeGenerationHandlerResult<MethodDeclaration>? {
        val returnType = eObject.returnType?.type ?: return GenletCodeGenerationHandlerResult(node)
        if (returnType.name != "Page")
            return GenletCodeGenerationHandlerResult(node)

        val originalReturnType = if (eObject.returnType.originalType is IntermediateComplexType)
                (eObject.returnType.originalType as IntermediateComplexType).resolve()
            else
                eObject.returnType.originalType

        val fieldTypeName = if (originalReturnType is IntermediateCollectionType) {
            when {
                originalReturnType.isPrimitiveCollection ->
                    originalReturnType.primitiveType.getTypeMapping()!!.mappedTypeName

                originalReturnType.dataFields.size == 1 -> {
                    val type = originalReturnType.dataFields[0].type
                    val (typeName, isComplexTypeMapping, imports, dependencies) = type.getTypeMapping()!!
                    if (isComplexTypeMapping) {
                        val currentDomainPackage: String by state()
                        val fullyQualifiedClassname = (type as IntermediateComplexType).fullyQualifiedClassname
                        node.addImport("$currentDomainPackage.$fullyQualifiedClassname", ImportTargetElementType.METHOD)
                    }
                    imports.forEach { node.addImport(it, ImportTargetElementType.METHOD) }
                    node.addDependencies(dependencies)
                    typeName
                }
                else -> null
            }
        } else
            null

        if (fieldTypeName != null)
            node.setType("Page<$fieldTypeName>")
        else
            node.setType("Page")

        val currentMicroservicePackage: String by state()
        val pageClassPackage = "$currentMicroservicePackage.application"
        val (pageClassFullyQualifiedName, pageClassContent) = generatePageClassContent(pageClassPackage)
        node.addImport(pageClassFullyQualifiedName, ImportTargetElementType.METHOD)

        val result = GenletCodeGenerationHandlerResult(node)
        result.generatedFileContents.add(GenletGeneratedFileContent(
            GenletPathSpecifier.CURRENT_MICROSERVICE_JAVA_ROOT_PATH,
            "application${File.separator}Page.java",
            pageClassContent
        ))
        return result
    }

    private fun generatePageClassContent(pageClassPackage: String) : Pair<String, String> {
        val pageClassFullyQualifiedName = "$pageClassPackage.Page"

        val pageClassContent =
            """
                package $pageClassPackage;
    
                import java.util.List;
                
                /**
                 * An instance of the Page class can be used to represent a subset of a specific type of resource.
                 * */
                public class Page<T> {
                    private final List<T> elements;
                    private final int offset;
                    private final int limit;
                    private final int size;
                
                    public Page(List<T> elements, int offset, int limit, int size) {
                        this.elements = elements;
                        this.offset = offset;
                        this.limit = limit;
                        this.size = size;
                    }
                
                    public List<T> getElements() {
                        return elements;
                    }
                
                    public int getOffset() {
                        return offset;
                    }
                
                    public int getLimit() {
                        return limit;
                    }
                
                    public int getSize() {
                        return size;
                    }
                }
            """.trimIndent()

        return pageClassFullyQualifiedName to pageClassContent
    }
}