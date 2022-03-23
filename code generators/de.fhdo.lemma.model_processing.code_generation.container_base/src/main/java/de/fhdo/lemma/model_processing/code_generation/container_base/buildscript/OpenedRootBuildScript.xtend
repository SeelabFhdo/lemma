package de.fhdo.lemma.model_processing.code_generation.container_base.buildscript

import de.fhdo.lemma.model_processing.code_generation.container_base.template.BuildScriptTemplate
import java.nio.file.Files
import java.nio.file.Paths
import java.io.File
import java.nio.charset.StandardCharsets
import java.util.regex.Pattern
import de.fhdo.lemma.utils.LemmaUtils

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
     * Load an existing root build script from the file system into the data structure of the
     * OpendRootBuildScript class.
     *
     * FIXME: The paths of the deployment components are extracted from each line of the script via
     * a regular expression. This may lead to a problem with build scripts not created by this code
     * generator.
     */
    def loadExistingRootBuildScript(String targetFolder) {
        val filePath = '''«targetFolder»«File.separator»build«File.separator»build.sh'''
        if (new File(filePath).exists) {
            val stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)
            stream.forEach[line |
                if (line != BuildScriptTemplate.SHEBANG)
                    addBuildCommand(getComponentPathFromBuildScriptLine(line), line)
            ]
        }
    }

    /**
     * Add build command based on a deployment component's path.
     */
    def addBuildCommand(String componentPath, String buildCommand) {
        buildScriptNodes.put(componentPath, buildCommand)
    }

    /**
     * Extract the path of the deployment component from a specific line of a build script using a
     * regular expression.
     */
    private def String getComponentPathFromBuildScriptLine(String line) {
        val matcher = pattern.matcher(line)

        return if (matcher.find)
                LemmaUtils.removePrefix(matcher.group, "/", false)
            else
                ""
    }

    /**
     * Return the build script's content as a String.
     */
    override String toString() {
        val stringBuilder = new StringBuilder
        stringBuilder.append(BuildScriptTemplate::buildScriptHeader)
        buildScriptNodes.values.forEach[command |
            stringBuilder.append(command + "\n")
        ]

        return stringBuilder.toString.replace("\n\n", "\n")
    }
}