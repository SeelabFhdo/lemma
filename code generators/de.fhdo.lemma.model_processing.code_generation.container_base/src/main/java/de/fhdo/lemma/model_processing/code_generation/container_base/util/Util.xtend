package de.fhdo.lemma.model_processing.code_generation.container_base.util

import de.fhdo.lemma.utils.LemmaUtils
import java.io.File

class Util {
    /**
     * Adjust the indentations in YAML-base filed like Docker Compose or Kubernetes files
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
     * Build the folder structure based on the fully qualified domain name.
     * For instance, the fully qualified domain name:
     *      "de.fhdo.service.fooservice"
     * is transformed to:
     *      "de/fhdo/service"
     */
    static def String buildPathFromQualifiedName(String qualifedName) {
        val stringBuilder = new StringBuilder
        qualifedName.split("\\.").forEach[p |
            if(p != LemmaUtils.getSimpleName(qualifedName)) {
                stringBuilder.append(p)
                stringBuilder.append(File.separator)
            }
        ]
        return stringBuilder.toString
    }
}