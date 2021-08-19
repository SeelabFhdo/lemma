package de.fhdo.reconstruction.framework.microservice

import de.fhdo.lemma.service.Interface
import de.fhdo.lemma.service.ServiceFactory
import de.fhdo.reconstruction.framework.plugins.AbstractParseTree
import de.fhdo.reconstruction.framework.plugins.ParsingResultType

/**
 * Data structure for reconstructing LEMMA's Microservice from a file, e.g., a Java or Kotlin file.
 */
data class Microservice(
    val name: String,
    val version: String?,
    val type: String?,
    val visibility: String?,
    val interfaces: Interface?
) {
    constructor(name: String, version: String?, type: String?, visibility: String?):
            this(name, version, type, visibility, null)
}
data class ReconstructedMicroservice(
    val id: String?,
    val microservice: Microservice
) {
    constructor(microservice: Microservice) : this(null, microservice)
}


/**
 * Helper function to add oder integrate a reconstructed microservice
 */
fun createMicroservice(name: String, version: String?, type: String?, visibility: String?): Microservice {
    return Microservice(name, version, type, visibility)
}

/**
 * Helper function to add oder integrate a reconstructed interface
 */
fun createInterface(interfaceName: String): Interface {
    val serviceInterface = ServiceFactory.eINSTANCE.createInterface()
    serviceInterface.name = interfaceName
    return serviceInterface
}

/**
 * Super class for building microservice reconstruction plugin modules.
 */
abstract class AbstractMicroserviceReconstructionModule {
    abstract fun getParsingTree(path: String): Pair<ParsingResultType, AbstractParseTree>
    abstract fun execute(abstractParseTree: AbstractParseTree): List<Microservice>
    abstract fun getSupportFileExtensions(): List<String>
}

/**
 * Annotation for identifying [AbstractMicroserviceReconstructionModule].
 */
@Target(AnnotationTarget.CLASS)
annotation class MicroserviceReconstructionModule

@Target(AnnotationTarget.CLASS)
annotation class TestAnnotation
