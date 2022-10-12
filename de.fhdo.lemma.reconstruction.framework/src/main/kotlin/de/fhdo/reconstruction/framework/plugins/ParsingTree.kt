package de.fhdo.reconstruction.framework.plugins

/**
* Parsing result type for [AbstractParseTree] in technology specific plugins.
*
* @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
*/
enum class ParsingResultType {
    FULLY_PARSED,
    PARTIALLY_PARSED,
    NONE_PARSED
}

/**
 * Super class for creating technology specific parse trees.
 */
abstract class AbstractParseTree(val fileType: String)