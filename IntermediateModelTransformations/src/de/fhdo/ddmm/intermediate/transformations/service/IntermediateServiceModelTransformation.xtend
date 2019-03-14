package de.fhdo.ddmm.intermediate.transformations.service

import de.fhdo.ddmm.service.ServicePackage
import de.fhdo.ddmm.service.ServiceModel
import de.fhdo.ddmm.utils.DdmmUtils
import de.fhdo.ddmm.technology.Technology
import org.eclipse.emf.ecore.EObject
import de.fhdo.ddmm.service.intermediate.IntermediatePackage
import de.fhdo.ddmm.intermediate.transformations.AbstractIntermediateModelTransformationStrategy
import de.fhdo.ddmm.intermediate.transformations.TargetModelInfo
import de.fhdo.ddmm.service.intermediate.IntermediateServiceModel
import org.eclipse.m2m.atl.core.emf.EMFModel
import java.util.Map
import org.eclipse.core.resources.ResourcesPlugin
import de.fhdo.ddmm.technology.CommunicationType
import de.fhdo.ddmm.technology.Protocol
import de.fhdo.ddmm.service.Import
import java.util.List
import de.fhdo.ddmm.service.Microservice

/**
 * This class enables access the model-to-model transformation of service models to intermediate
 * service models.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class IntermediateServiceModelTransformation
    extends AbstractIntermediateModelTransformationStrategy {
    static val TARGET_MODEL_INFO = new TargetModelInfo(
        IntermediatePackage.eNS_URI,
        IntermediatePackage.eINSTANCE,
        IntermediateServiceModel
    )

    String absoluteSourceModelPath

    /**
     * Get project-relative path to compiled ATL model transformation file
     */
    override getCompiledModelTransformationFilePath() {
        return "/IntermediateServiceModelTransformation.asm"
    }

    /**
     * Get URI and EPackage of the target intermediate metamodel
     */
    override getTargetModelInfo() {
        return TARGET_MODEL_INFO
    }

    /**
     * Before transformation hook
     *
     */
    override beforeTransformationHook(String absoluteSourceModelPath) {
        this.absoluteSourceModelPath = absoluteSourceModelPath
    }

    /**
     * Prepare source model
     */
    override prepareSourceModel(EObject modelRoot) {
        val serviceModel = modelRoot as ServiceModel

        // Set source model URI. Note that the source model URI is only null, if this is not a
        // refining transformation of a Mapping Model, in which case the model URI will be an
        // empty string on the root model level.
        if (serviceModel.t_modelUri === null)
            serviceModel.t_modelUri = DdmmUtils.convertToFileUri(absoluteSourceModelPath)

        // Convert import URIs to absolute URIs
        serviceModel.imports.forEach[
            importURI = DdmmUtils.convertToAbsoluteFileUri(importURI, absoluteSourceModelPath)
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
            microservice.technologies.forEach[technologyImport |
                val technologyModel = DdmmUtils.getImportedModelRoot(technologyImport.eResource,
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
     * Get validator for source model
     */
    override getSourceModelValidator() {
        return new ServiceModelTransformationValidator
    }

    /**
     * Get namespace URI of the source metamodel's EPackage
     */
    override getSourcePackageNamespaceUri() {
        return ServicePackage.eNS_URI
    }

    /**
     * Get prefix of source model in ATL transformation file
     */
    override getTransformationSourceModelPrefix() {
        return "Service"
    }

    /**
     * Get prefix of target model in ATL transformation file
     */
    override getTransformationTargetModelPrefix() {
        return "Intermediate"
    }

    /**
     * Add transformation target paths of imported model files to target model
     */
    override populateTargetModelWithImportTargetPaths(EMFModel targetModel,
        Map<String, String> targetPaths) {
        val modelRoot = targetModel.resource.contents.get(0) as IntermediateServiceModel
        val workspacePath = ResourcesPlugin.workspace.root.location.toString
        targetPaths.forEach[importName, targetPath |
            val import = modelRoot.imports.findFirst[name == importName]
            import.importUri = DdmmUtils.convertToFileUri(workspacePath + targetPath)
        ]
    }
}