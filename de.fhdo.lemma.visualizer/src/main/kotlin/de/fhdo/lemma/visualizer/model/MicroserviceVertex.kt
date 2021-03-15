package de.fhdo.lemma.visualizer.model

import de.fhdo.lemma.service.intermediate.IntermediateInterface

data class MicroserviceVertex(val visibility:String, val name: String, val qualifiedName:String, val type: String, val technology: String? = null) {
    val interfaces: MutableList<InterfaceSubVertex> = mutableListOf()
}

data class InterfaceSubVertex(val name : String, val visibility:String) {
    val operations: MutableList<OperationSubVertex> = mutableListOf()
}

data class OperationSubVertex(val name : String, val visibility:String) {
    val parameters: MutableList<ParameterSubVertex> = mutableListOf()
}

data class ParameterSubVertex(val commType : String, val name : String, val datatype:String)