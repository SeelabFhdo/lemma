package de.fhdo.lemma.model_processing.code_generation.mongodb

import de.fhdo.lemma.model_processing.AbstractModelProcessor

/**
 * Main class of the MongoDB generator implemented on the basis of LEMMA's model processing
 * framework as an AbstractModelProcessor.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class MongoDBGenerator extends AbstractModelProcessor {
    /**
     * Entry point for the model processor. Should contain the package name for the code generation
     * modules.
     */
    new() {
        super("de.fhdo.lemma.model_processing.code_generation.mongodb");
    }

    def static void main(String[] args) {
        new MongoDBGenerator().run(args)
    }
}