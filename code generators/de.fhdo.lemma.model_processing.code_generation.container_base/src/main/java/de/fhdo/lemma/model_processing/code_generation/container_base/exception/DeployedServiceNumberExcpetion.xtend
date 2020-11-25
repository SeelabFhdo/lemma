package de.fhdo.lemma.model_processing.code_generation.container_base.exception

/**
 * This exception in throw when more then one service is deployed in a single container.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class DeployedServiceNumberExcpetion extends Exception{
    new (String exceptionMessage) {
        super(exceptionMessage)
    }
}