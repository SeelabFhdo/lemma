package de.fhdo.lemma.intermediate.transformations.service

import de.fhdo.lemma.service.ServicePackage
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.service.intermediate.IntermediatePackage
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import java.util.Map
import de.fhdo.lemma.intermediate.transformations.TransformationModelDescription
import org.eclipse.emf.ecore.EObject
import de.fhdo.lemma.service.Microservice
import java.util.List
import de.fhdo.lemma.technology.Technology
import de.fhdo.lemma.technology.Protocol
import de.fhdo.lemma.service.Import
import de.fhdo.lemma.technology.CommunicationType
import de.fhdo.lemma.intermediate.transformations.TransformationModelType
import de.fhdo.lemma.intermediate.transformations.AbstractAtlInputOutputIntermediateModelTransformationStrategy
import de.fhdo.lemma.utils.LemmaUtils
import org.eclipse.core.resources.IFile

/**
 * Implementation of the ATL-based model-to-model transformation of service models to intermediate
 * service models.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class IntermediateServiceModelTransformation
    extends AbstractAtlInputOutputIntermediateModelTransformationStrategy {
    IFile inputModelFile
    String absoluteInputModelFilePath

    /**
     * Specify reference name and transformation model type of input model
     */
    override getInputModelReferenceNameAndType() {
        return "Service" ->
            new TransformationModelType(ServicePackage.eNS_URI, ServicePackage.eINSTANCE,
                ServiceModel)
    }

    /**
     * Specify reference name and transformation model type of output model
     */
    override getOutputModelReferenceNameAndType() {
        return "Intermediate" ->
            new TransformationModelType(IntermediatePackage.eNS_URI,
                IntermediatePackage.eINSTANCE, IntermediateServiceModel)
    }

    /**
     * Specify path to the compiled ATL transformation file
     */
    override getCompiledModelTransformationFilePath() {
        return "/IntermediateServiceModelTransformation.asm"
    }

    /**
     * Fetch input model file prior to transformation execution
     */
    override beforeTransformationHook(
        Map<TransformationModelDescription, IFile> inputModelFiles,
        Map<TransformationModelDescription, String> outputModelPaths
    ) {
        inputModelFile = inputModelFiles.values.get(0)
        absoluteInputModelFilePath = LemmaUtils.getAbsolutePath(inputModelFile)
    }

    /**
     * Prepare input model
     */
    override prepareInputModel(TransformationModelDescription modelDescription, EObject modelRoot) {
        val serviceModel = modelRoot as ServiceModel

        // Set source model URI. Note that the source model URI is only null, if this is not a
        // refining transformation of a Mapping Model, in which case the model URI will be an
        // empty string on the root model level.
        if (serviceModel.t_modelUri === null)
            serviceModel.t_modelUri = LemmaUtils.convertToFileUri(absoluteInputModelFilePath)

        // Convert import URIs to absolute URIs
        serviceModel.imports.forEach[
            importURI = LemmaUtils.convertToAbsoluteFileUri(importURI, absoluteInputModelFilePath)
        ]

        // Populate the model's Microservices, which specify a technology, with Technology instances
        linkTechnologyModels(serviceModel.microservices)
    }

    /**
     * Transformation preparation: Link technology models to service model to prevent continuous
     * disk accesses to model files during transformation. Note that this depends on absolute file
     * URIs of the imported technology models.
     */
    private def linkTechnologyModels(List<Microservice> microservices) {
        microservices.forEach[microservice |
            // Type definition technology
            if (microservice.t_typeDefinitionTechnology === null) {
                microservice.t_typeDefinitionTechnologyImport =
                    microservice.typeDefinitionTechnologyImport
                microservice.t_typeDefinitionTechnology = microservice.typeDefinitionTechnology
            }

            // Default protocols per communication type
            microservice.technologyReferences.map[technology].forEach[technologyImport |
                val technologyModel = LemmaUtils.getImportedModelRoot(technologyImport.eResource,
                    technologyImport.importURI, Technology)
                if (microservice.t_defaultProtocols === null)
                    microservice.t_defaultProtocols =
                        <CommunicationType, Pair<Import, Protocol>> newHashMap
                technologyModel.protocols.forEach[
                    if (^default)
                        microservice.t_defaultProtocols.putIfAbsent(it.communicationType,
                            technologyImport -> it)
                ]
            ]
        ]
    }

    /**
     * Specify validator for input model
     */
    override getInputModelValidator(TransformationModelDescription modelDescription) {
        return new ServiceModelTransformationValidator
    }

    /**
     * Add transformation target paths of imported model files to target model
     */
    override populateOutputModelWithImportTargetPaths(
        TransformationModelDescription modelDescription,
        EObject modelRoot,
        Map<String, String> targetPaths
    ) {
        val serviceModelRoot = modelRoot as IntermediateServiceModel
        targetPaths.forEach[importName, targetPath |
            val import = serviceModelRoot.imports.findFirst[name == importName]
            import.importUri = LemmaUtils.convertProjectPathToAbsoluteFileUri(targetPath)
        ]
    }

    /**
     * Convert URIs in intermediate service models to relative ones
     */
    override makeUrisRelative(TransformationResult result) {
        result.performUriRelativization()
    }

    /**
     * Reusable helper to convert URIs in intermediate service models to relative ones
     */
    static def performUriRelativization(TransformationResult result) {
        val serviceModel = result.outputModel.resource.contents.get(0) as IntermediateServiceModel

        // Convert source model URI
        serviceModel.sourceModelUri = LemmaUtils.convertToFileUri(LemmaUtils.relativize(
            LemmaUtils.removeFileUri(result.outputModel.outputPath),
            LemmaUtils.removeFileUri(result.inputModels.get(0).inputPath)
        ))

        // Convert import URIs
        serviceModel.imports.forEach[
            it.importUri = LemmaUtils.convertToFileUri(LemmaUtils.relativize(
                LemmaUtils.removeFileUri(result.outputModel.outputPath),
                LemmaUtils.removeFileUri(it.importUri)
            ))
        ]

        // Convert source model URIs in microservices
        serviceModel.microservices.forEach[
            it.sourceModelUri = LemmaUtils.convertToFileUri(LemmaUtils.relativize(
                LemmaUtils.removeFileUri(result.outputModel.outputPath),
                LemmaUtils.removeFileUri(it.sourceModelUri)
            ))
         ]
    }
}