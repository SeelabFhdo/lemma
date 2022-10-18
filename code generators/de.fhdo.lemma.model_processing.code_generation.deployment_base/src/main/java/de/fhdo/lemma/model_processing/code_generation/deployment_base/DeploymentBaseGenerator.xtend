package de.fhdo.lemma.model_processing.code_generation.deployment_base

import de.fhdo.lemma.model_processing.AbstractModelProcessor

/**
 * Main class of the Deployment Base Generator implemented on the basis of LEMMA's model processing
 * framework as an AbstractModelProcessor.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class DeploymentBaseGenerator extends AbstractModelProcessor {
    public static val BUILD_MANAGEMENT_TECHNOLOGY_NAME = "BuildManagement"
    public static val DEPLOYMENT_BASE_TECHNOLOGY_NAME = "DeploymentBase"

    /**
     * Entry point for the model processor. Should contain the package name for the code generation
     * modules.
     */
    new() {
        super("de.fhdo.lemma.model_processing.code_generation.deployment_base");
    }

    def static void main(String[] args) {
        new DeploymentBaseGenerator().run(args)
    }
}