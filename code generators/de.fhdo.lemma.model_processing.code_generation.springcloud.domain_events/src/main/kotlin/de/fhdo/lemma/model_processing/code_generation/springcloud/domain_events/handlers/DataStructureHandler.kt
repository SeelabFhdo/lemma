package de.fhdo.lemma.model_processing.code_generation.springcloud.domain_events.handlers

import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.findParentNode
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.setGenletNodeInfo
import de.fhdo.lemma.model_processing.code_generation.java_base.getAspectPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.springcloud.domain_events.state.EventGroups

/**
 * Code generation handler for IntermediateDataStructure instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class DataStructureHandler
    : GenletCodeGenerationHandlerI<IntermediateDataStructure, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateDataStructure::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateDataStructure, node: ClassOrInterfaceDeclaration,
        context: Nothing?) : GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration>? {
        /*
         * Add an event group interface to the node generated for the data structure, in case the EventGroup aspect is
         * present
         */
        val eventGroup = eObject.getAspectPropertyValue("DomainEvents.EventGroup", "name") ?: return null

        // Add event group interface to node
        val currentDomainPackage: String by state()
        val groupInterface = EventGroups.addOrGetGroupInterface(eventGroup, currentDomainPackage)
        node.addImplementedType(groupInterface.nameAsString)
        node.addImport(groupInterface.fullyQualifiedName.get(), ImportTargetElementType.IMPLEMENTED_INTERFACE)

        // Add type of the group interface and its package name as Genlet-related information to the group interface.
        // These information can be used by subsequent Genlets to unambiguously identify event group interfaces.
        val groupInterfaceType = node.implementedTypes.last()
        groupInterfaceType.setGenletNodeInfo("DomainEventGroupInterface", eventGroup)
        groupInterfaceType.setGenletNodeInfo("DomainEventGroupInterfacePackageName",
            groupInterface.findParentNode<CompilationUnit>()!!.getPackageName())

        return GenletCodeGenerationHandlerResult(node)
    }
}