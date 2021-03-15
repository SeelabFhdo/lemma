package de.fhdo.lemma.visualizer.model

/**
 * This enum is used to set the level of detail which is shown in the graphical representation.
 * DetailLevel.SERVICES only shows the Microservices as vertices
 * DetailLevel.INTERFACES the previous plus additionally shows the interfaces
 * DetailLevel.OPERATIONS the previous plus additionally shows the operations
 * DetailLevel.SIGNATURES the previous plus additionally shows the signature
 *
 * @author [Jonas Sorgalla](mailto:jonas.sorgalla@fh-dortmund.de)
 */
enum class DetailLevel {
    SERVICES,
    INTERFACES,
    OPERATIONS,
    SIGNATURES
}