package de.fhdo.lemma.model_processing.code_generation.deployment_base.template

/**
 * Template class for generating operation node specific build scripts.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class BuildScriptTemplate {
    public static val SHEBANG = "#!/usr/bin/env bash"

    /**
     * Get the string content for the node-specific build script.
     */
    static def String getNodeSpecificBuildScript(String nodeName)'''
        «SHEBANG»

        mvn clean install

        docker build . -t «nodeName»
    '''

    /**
     * Get the build command for the given deployment component's path.
     */
    static def String getComponentBuildCommand(String componentPath)'''
        cd "../«componentPath»" && sh build.sh
    '''

    /**
     * Get the header of the build script.
     */
    static def String getBuildScriptHeader()'''
        #!/usr/bin/env bash
    '''
}