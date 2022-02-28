package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator

import org.eclipse.swt.widgets.Shell
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IFile
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.ProcessingConfigurationWithLaunchConfigurationName
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator.JavaBaseGeneratorParameters.GenletType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.graphics.Point

/**
 * Launch configuration template targeting code generation with the Java Base Generator from a
 * service model and in a Docker container based on a local image.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class DockerJavaBaseGeneratorTemplate extends AbstractJavaBaseGeneratorTemplate {
    protected static val TEMPLATE_NAME = "Docker-based Java microservice generation"

    /**
     * Constructor
     */
    new(Shell parentShell, IProject project, IFile file) {
        this(parentShell, TEMPLATE_NAME, project, file)
    }

    /**
     * Constructor with explicit template name parameter
     */
    new(Shell parentShell, String name, IProject project, IFile file) {
        super(ProcessorExecutableType.LOCAL_DOCKER_IMAGE, parentShell, name, project, file)
    }

    /**
     * Extend the model processing configuration template initialized by the superclass
     */
    final override extendInitializedProcessingConfigurationTemplate(
        ProcessingConfigurationWithLaunchConfigurationName configuration
    ) {
        val initializedConfiguration = super
            .extendInitializedProcessingConfigurationTemplate(configuration)

        initializedConfiguration.processorExecutablePath =
            JavaBaseGeneratorParameters.DEFAULT_DOCKER_IMAGE_NAME

        GenletType.values.forEach[initializedConfiguration.arguments.add(it.buildGenletArgument)]

        return configuration
    }

    /**
     * Build an Argument instance that specifies the execution of a Genlet of the given type with
     * the Java Base Generator
     */
    private def buildGenletArgument(GenletType genletType) {
         return Argument.newArgument
            .singleValued
            .stringPair
            .parameter(JavaBaseGeneratorParameters.GENLET_PARAMETER)
            .value(JavaBaseGeneratorParameters.instance.getDockerGenletFilePath(genletType))
    }

    /**
     * Return the dialog for template completion
     */
    override getJavaBaseGeneratorCompletionDialog() {
        return new TemplateCompletionDialog(parentShell, project, file)
    }

    /**
     * Docker-specific dialog for template completion
     */
    static class TemplateCompletionDialog extends AbstractJavaBaseGeneratorCompletionDialog {
        /**
         * Constructor
         */
        new(Shell parentShell, IProject project, IFile file) {
            super(parentShell, project, file)
        }

        /**
         * Addendum for the generator short name as part of the launch configuration name
         */
        override getGeneratorNameAddendum() {
            return "Docker"
        }

        /**
         * Addendum for generator long name as part of the label for the generator executable path's
         * text field
         */
        override getGeneratorExecutableLabelTextAddendum() {
            return "Docker image"
        }

        /**
         * Create the dialog
         */
        override create() {
            super.create()
            title = "Generate Java Microservices From LEMMA Models Using Docker"
            message = '''Use this dialog to configure and run LEMMA's «generatorLongName» in a ''' +
                '''Docker container on the selected «printableModelFileType» model'''
        }

        /**
         * Create the dialog area
         */
        override createDialogArea(Composite parent) {
            val area = super.createDialogArea(parent)
            parent.shell.size = new Point(DEFAULT_WIDTH, 340)
            return area
        }
    }
}