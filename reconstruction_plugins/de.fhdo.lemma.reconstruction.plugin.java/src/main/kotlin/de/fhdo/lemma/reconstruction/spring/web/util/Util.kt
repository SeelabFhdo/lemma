package de.fhdo.lemma.reconstruction.spring.web.util

/**
 * Compare qualified names based on part separator and hierarchy level
 */
fun compareFullQualifiedNames(service: String, identifier: String, partSeparator: String, level: Int): Boolean {
    val serviceParts = service.split(partSeparator)
    val identifierParts = identifier.split(partSeparator)

    return serviceParts.subList(0, level) == identifierParts.subList(0, level)
}