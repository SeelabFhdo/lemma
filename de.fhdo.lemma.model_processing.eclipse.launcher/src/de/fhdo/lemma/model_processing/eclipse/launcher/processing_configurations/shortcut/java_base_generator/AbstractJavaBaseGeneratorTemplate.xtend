package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator

import org.eclipse.swt.widgets.Shell
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IFile
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.ProcessingConfigurationWithLaunchConfigurationName
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.AbstractCodeGeneratorTemplate
import org.eclipse.emf.ecore.EObject
import java.util.Map
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.technology.mapping.TechnologyMapping
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType

/**
 * Abstract superclass for launch configuration templates targeting code generation with the Java
 * Base Generator.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class AbstractJavaBaseGeneratorTemplate extends AbstractCodeGeneratorTemplate {
    var Argument generationSerializerArgument

    /**
     * Constructor
     */
    new(ProcessorExecutableType generatorExecutableType, Shell parentShell, String name,
        IProject project, IFile file) {
        super(generatorExecutableType, parentShell, name, project, file)
    }

    /**
     * Extend the model processing configuration template initialized by the superclass
     */
    override extendInitializedProcessingConfigurationTemplate(
        ProcessingConfigurationWithLaunchConfigurationName configuration
    ) {
        super.extendInitializedProcessingConfigurationTemplate(configuration)

        generationSerializerArgument = Argument.newArgument
            .singleValued
            .stringPair
            .parameter(JavaBaseGeneratorParameters.GENERATION_SERIALIZER_PARAMETER)
            .value(JavaBaseGeneratorParameters.instance.defaultGenerationSerializer)
        configuration.arguments.add(generationSerializerArgument)

        return configuration
    }

    /**
     * Return the dialog for template completion
     */
    final override getCodeGeneratorCompletionDialog() {
        val dialog = getJavaBaseGeneratorCompletionDialog()
        dialog.generationSerializerArgument = generationSerializerArgument
        return dialog
    }

    /**
     * Implementers must provide a specialized completion dialog. getCodeGeneratorCompletionDialog()
     * invokes this method to retrieve the specialized dialog and assign it the argument for the
     * selected code generation serializer.
     */
    abstract def AbstractJavaBaseGeneratorCompletionDialog getJavaBaseGeneratorCompletionDialog()

    /**
     * The template is applicable when the source service or mapping model applies the Java
     * technology to at least one microservice
     */
    override isApplicable(EObject modelRoot, Map<String, String> technologyNamePerAlias) {
        val technologyReferences = switch (modelRoot) {
            ServiceModel: modelRoot.microservices.map[it.technologyReferences].flatten
            TechnologyMapping: modelRoot.serviceMappings.map[it.technologyReferences].flatten
            default: emptyList
        }

        // Convert import paths to absolute paths as otherwise cross-references to imported
        // technologies won't be resolvable
        makeImportPathsAbsolute(modelRoot, file)

        return technologyReferences.exists[
            val alias = it.technology.name
            val technologyName = technologyNamePerAlias.get(alias)
            "java".equalsIgnoreCase(technologyName)
        ]
    }
}