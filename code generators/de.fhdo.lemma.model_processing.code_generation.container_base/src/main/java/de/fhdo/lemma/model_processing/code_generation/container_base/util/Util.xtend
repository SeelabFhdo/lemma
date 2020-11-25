package de.fhdo.lemma.model_processing.code_generation.container_base.util

import java.io.File
import java.util.regex.Pattern
import java.nio.file.Files
import java.nio.file.Paths

class Util {
    /**
     * Remove line with a given indicator at the beginning of the line
     */
    static def String removeLineFromString(String content, String indicator) {
        var String[] lines = content.split(System.getProperty("line.separator"));
        lines.drop(1).join(System.getProperty("line.separator"))
    }

    /**
     * Get a file from a specific file path
     */
    static def File asFile(String filePath) {
        return new File(Files.readAllLines(Paths.get(filePath)).toString)
    }

    /**
     * Get the short name for a service. Transforms for example "de.demo.demoservice" to
     * "demoservice".
     */
    static def String getShortNameService(String fullname) {
        fullname.substring(fullname.lastIndexOf('.'), fullname.length).replace('.', '')
    }

    /**
     * Get the specific port form the address string.
     */
    static def String getPortFromAddress(String address) {
        var part = ""
        val pattern = Pattern.compile("(:[0-9]+)")

        val matcher = pattern.matcher(address)
        while(matcher.find)
           part = matcher.group.replace(':', '')

        return part
    }

    /**
     * Adjust the indentations in yaml base files like docker-compose or Kubernetes files.
     */
    static def String adjustIndentations(String indentation, String content) {
        if (content.empty)
            return null

        val numberOfIndentations = content.split("\n").filter[line|line.length > 0]
        val spaces = numberOfIndentations.get(0).length - numberOfIndentations.get(0).trim.length
        val stringBuilder = new StringBuilder
        numberOfIndentations.forEach[line |
            if (line.length > spaces)
                stringBuilder.append(indentation + line.subSequence(spaces, line.length) + "\n")
        ]
        return stringBuilder.toString
    }

    /**
     * Get the build path from the qualified name of a deployed microservice.
     * Transformation of "v1.de.demo.demoservice" to "v1.de.demo". This function is needed to
     * fit the filesystem structure of the java base code generator.
     */
    static def String buildPathFromQualifiedName (String qualifedName) {
        val stringBuilder = new StringBuilder
        qualifedName.split("\\.").forEach[p |
            if(p != getShortNameService(qualifedName)) {
                stringBuilder.append(p)
                stringBuilder.append(File.separator)
            }
        ]
        return stringBuilder.toString
    }
}