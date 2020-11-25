package de.fhdo.lemma.model_processing.code_generation.container_base.buildscript

import de.fhdo.lemma.model_processing.code_generation.container_base.template.BuildScriptTemplate
import java.nio.file.Files
import java.nio.file.Paths
import java.io.File
import java.nio.charset.StandardCharsets
import java.util.regex.Pattern

/**
 * This class contains the logic for the generation of the build scripts, used in the
 * BuildScriptCodeGenerator.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class OpenedRootBuildScript {
    static val pattern = Pattern.compile("/[a-z,-|_]*")
    static OpenedRootBuildScript instance
    val buildScriptNodes = <String, String> newHashMap

    /**
     * Get or create instance of the OpendRootBuildScript class.
     */
    def static OpenedRootBuildScript getInstance() {
        if (instance === null)
            instance = new OpenedRootBuildScript

        return OpenedRootBuildScript.instance
    }

    /**
     * Load a  existing root build script from the file system into the data structure of the
     * OpendRootBuildScript class.
     *
     * Note: The name of the nodes is extracted from the content of each line of the script via
     * a regex. This may lead to a problem with build scripts not created by this code generator.
     */
    def loadExistingRootBuildScript(String targetFolder) {
        val filePath = '''«targetFolder»«File.separator»build«File.separator»build.sh'''
        val file = new File(filePath)
        if (file.exists) {
            var stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)
            stream.forEach[line |
                addBuildCommand(getNodeNameFromBuildScriptLine(line), line)]
            buildScriptNodes.remove("usrbinenv")
        }
    }

    /**
     * Add build command based the name of the operation node.
     */
    def addBuildCommand(String nodeName, String buildCommand) {
        buildScriptNodes.put(nodeName.toLowerCase, buildCommand)
    }

    /**
     * Extract the name of the operation node from a specific line of a build script via a regex.
     * The regex allows the letters a-z and the special characters '-' and '_' that may be
     * included in the name of operation node.
     */
    private def String getNodeNameFromBuildScriptLine(String line) {
        var part = ""
        val matcher = pattern.matcher(line)

        while(matcher.find)
            part = matcher.group.replace("/", "")

        return part
    }

    /**
     * Build a string with the content of the content for the build script.
     */
    override String toString() {
        val stringBuilder = new StringBuilder
        stringBuilder.append(BuildScriptTemplate::buildScriptHeader)
        buildScriptNodes.values.forEach[command |
            stringBuilder.append(command + "\n")]

        return stringBuilder.toString.replace("\n\n", "\n")
    }
}