package de.fhdo.lemma.model_processing.code_generation.springcloud.eureka

import de.fhdo.lemma.model_processing.AbstractModelProcessor

/**
 * Main class of the Srping Cloud Eureka code generator implemented on the basis of LEMMA's model processing
 * framework as an AbstractModelProcessor.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class EurekaGenerator extends AbstractModelProcessor {
    /**
     * Entry point for the model processor. Should contain the package name for the code generation
     * modules.
     */
    new() {
        super("de.fhdo.lemma.model_processing.code_generation.springcloud.eureka");
    }

    def static void main(String[] args) {
        new EurekaGenerator().run(args)
    }
}