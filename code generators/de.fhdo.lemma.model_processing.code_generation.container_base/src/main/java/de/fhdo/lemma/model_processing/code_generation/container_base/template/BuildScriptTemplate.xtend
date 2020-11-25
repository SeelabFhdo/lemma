package de.fhdo.lemma.model_processing.code_generation.container_base.template

/**
 * Template class for generating operation node specific build scripts.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class BuildScriptTemplate {
    /**
     * Get the string content for the node-specific build script.
     */
    static def String getNodeSpecificBuildScript(String nodeName)'''
        #!/usr/bin/env bash

        mvn clean install

        docker build . -t «nodeName»
    '''

    /**
     * Get the first command set in the build script.
     */
    static def String getRootCommand(String nodeName)'''
        cd "../«nodeName.toLowerCase»" && sh build.sh
    '''

    /**
     * Get the header of the build script.
     */
    static def String getBuildScriptHeader()'''
        #!/usr/bin/env bash
    '''
}