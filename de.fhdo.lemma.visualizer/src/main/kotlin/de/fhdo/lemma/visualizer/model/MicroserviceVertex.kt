package de.fhdo.lemma.visualizer.model

/**
 * Simple vertex representing a microservice.
 * Contains only the attributes necessary for the display.
 *
 * @author [Jonas Sorgalla](mailto:jonas.sorgalla@fh-dortmund.de)
 */
data class MicroserviceVertex(val visibility:String, val name: String, val qualifiedName:String, val type: String, val technology: String? = null) {
    val interfaces: MutableList<InterfaceSubVertex> = mutableListOf()
}

/**
 * Simple vertex representing an interface of a microservice.
 * Contains only the attributes necessary for the display.
 *
 * @author [Jonas Sorgalla](mailto:jonas.sorgalla@fh-dortmund.de)
 */
data class InterfaceSubVertex(val name : String, val visibility:String) {
    val operations: MutableList<OperationSubVertex> = mutableListOf()
}

/**
 * Simple vertex representing an operation of an interface of a microservice.
 * Contains only the attributes necessary for the display.
 *
 * @author [Jonas Sorgalla](mailto:jonas.sorgalla@fh-dortmund.de)
 */
data class OperationSubVertex(val name : String, val visibility:String) {
    val parameters: MutableList<ParameterSubVertex> = mutableListOf()
}

/**
 * Simple vertex representing a parameter of an operation of an interface of a microservice.
 * Contains only the attributes necessary for the display.
 *
 * @author [Jonas Sorgalla](mailto:jonas.sorgalla@fh-dortmund.de)
 */
data class ParameterSubVertex(val commType : String, val name : String, val datatype:String)