package de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.handlers

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.type.ClassOrInterfaceType
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.getGenletNodeInfoOrElseNull
import de.fhdo.lemma.model_processing.code_generation.java_base.getFirstMatchingAspectPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.avro.AvroConversionHelpersGenerator
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.genletHeap
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.avro.AvroConverters
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.avro.configuresAvroSchema
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.forDomainEventsTechnology
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.shared.EventGroupInterfaceTypes
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice

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
    override fun execute(eObject: IntermediateDataStructure, node: ClassOrInterfaceDeclaration, context: Nothing?)
        : GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration>? {
        // Register data structure for Avro converters
        if (!AvroConverters.initialized) {
            val currentDomainPackage: String by state()
            AvroConverters.initialize(currentDomainPackage, genletHeap)
        }
        //AvroConverters.addConverters(eObject)

        initializeAvroConversionHelpersGeneratorIfNecessary()
        AvroConversionHelpersGenerator.registerJavaTypeGeneratedFromComplexType(eObject, node)

        if (eObject.configuresAvroSchema()) {
            AvroConversionHelpersGenerator.registerStructureForGenericRecordBuilderGeneration(eObject)
            AvroConversionHelpersGenerator.compileSchema(eObject)
        }

        // Get and register event group interface. To this end, the Domain Event Genlet must be executed prior to the
        // Kafka Genlet.
        val eventGroup = eObject.getFirstMatchingAspectPropertyValue("EventGroup".forDomainEventsTechnology(), "name")
            ?: return null
        val groupInterfaceType = node.implementedTypes.find {
            it is ClassOrInterfaceType &&
            it.getGenletNodeInfoOrElseNull("DomainEventGroupInterface") == eventGroup
        } ?: return null

        EventGroupInterfaceTypes[eventGroup] = groupInterfaceType
        EventGroupInterfaceTypes[eObject] = eventGroup
        return null
    }

    private fun initializeAvroConversionHelpersGeneratorIfNecessary() {
        if (AvroConversionHelpersGenerator.initialized)
            return

        val currentDomainPackage: String by state()
        val currentMicroservice: IntermediateMicroservice by state()
        val currentMicroservicePackage: String by state()
        val currentMicroserviceTargetFolderPathForJavaFilesWithoutMicroservicePackage: String by state()
        val currentMicroserviceTargetFolderPathForResourceFiles: String by state()
        AvroConversionHelpersGenerator.initialize(
            currentDomainPackage,
            currentMicroservice,
            currentMicroservicePackage,
            currentMicroserviceTargetFolderPathForJavaFilesWithoutMicroservicePackage,
            currentMicroserviceTargetFolderPathForResourceFiles
        )
    }
}