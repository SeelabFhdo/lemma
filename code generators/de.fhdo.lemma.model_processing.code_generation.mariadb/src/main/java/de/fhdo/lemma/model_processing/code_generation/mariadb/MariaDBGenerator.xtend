package de.fhdo.lemma.model_processing.code_generation.mariadb

import de.fhdo.lemma.model_processing.AbstractModelProcessor

/**
 * Main class of the MariaDB generator implemented on the basis of LEMMA's model processing
 * framework as an AbstractModelProcessor.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class MariaDBGenerator extends AbstractModelProcessor {
    /**
     * Entry point for the model processor. Should contain the package name for the code generation
     * modules.
     */
    new() {
        super("de.fhdo.lemma.model_processing.code_generation.mariadb");
    }

    def static void main(String[] args) {
        new MariaDBGenerator().run(args)
    }
}