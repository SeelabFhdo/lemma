package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator

import org.eclipse.swt.widgets.Shell
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IFile
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator.JavaBaseGeneratorParameters.GenletType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelOfImportWithAliasArgumentType
import org.eclipse.swt.graphics.Point
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.ProcessingConfigurationWithLaunchConfigurationName
import org.eclipse.emf.ecore.EObject
import java.util.Map
import de.fhdo.lemma.technology.mapping.TechnologyMapping
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*

/**
 * Launch configuration template targeting code generation with the Java Base Generator from a
 * type-focused mapping model and in a Docker container based on a local image.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class DockerTypeFocusedMappingModelJavaBaseGeneratorTemplate
    extends DockerJavaBaseGeneratorTemplate {
    /**
     * Constructor
     */
    new(Shell parentShell, IProject project, IFile file) {
        super(parentShell, '''Type-focused mapping model: «TEMPLATE_NAME»''', project, file)
    }

    /**
     * Return the dialog for template completion
     */
    final override getJavaBaseGeneratorCompletionDialog() {
        return new TypeFocusedMappingModelTemplateCompletionDialog(parentShell, project, file)
    }

    /**
     * The template is applicable when the source mapping model applies the Java technology to at
     * least one type
     */
    final override isApplicable(EObject modelRoot, Map<String, String> technologyNamePerAlias) {
        val technologyReferences = switch (modelRoot) {
            TechnologyMapping: modelRoot.typeMappings.map[it.technologyReferences].flatten
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

    /**
     * Dialog for template completion. It extends the super dialog with a combo box to select the
     * service model comprising the relevant microservices including their technology-specific
     * configurations. That is because the template concerns type-focused mapping models that only
     * perform technology mapping for modeled types and not for microservices.
     */
    private static class TypeFocusedMappingModelTemplateCompletionDialog
        extends TemplateCompletionDialog {
        var Argument alternativeIntermediateServiceModelArgument

        /**
         * Constructor
         */
        new(Shell parentShell, IProject project, IFile file) {
            super(parentShell, project, file)
        }

        /**
         * Create the dialog area
         */
        final override createDialogArea(Composite parent) {
            val area = super.createDialogArea(parent)
            parent.shell.size = new Point(DEFAULT_WIDTH, 380)
            return area
        }

        /**
         * Add additional controls to the dialog
         */
        final override insertAdditionalControlsAfterDefaults(Composite parent) {
            super.insertAdditionalControlsAfterDefaults(parent)
            parent.addAlternativeIntermediateServiceModel
        }

        /**
         * Add combo box for selecting the service model comprising the relevant microservices
         * including their technology-specific configurations
         */
        private def addAlternativeIntermediateServiceModel(Composite parent) {
            new Label(parent, SWT.NULL).text = "Service model:"

            val comboWrapper = new IntermediateModelOfImportWithAliasArgumentTypeComboWrapper(
                    parent,
                    SWT.DROP_DOWN.bitwiseOr(SWT.READ_ONLY),
                    configurationTemplate,
                    JavaBaseGeneratorParameters.ALTERNATIVE_INTERMEDIATE_SERVICE_MODEL_PARAMETER
                )
            val layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
            layoutData.horizontalSpan = 2
            comboWrapper.combo.layoutData = layoutData

            bindWithValidationDecorationSupport(
                comboWrapper.combo,
                Argument,
                "value",
                comboWrapper.argument,
                [
                    (comboWrapper.argument.type as IntermediateModelOfImportWithAliasArgumentType)
                        .validateValueInInternalRepresentation(configurationTemplate, it)
                ]
            )

            alternativeIntermediateServiceModelArgument = comboWrapper.argument
            alternativeIntermediateServiceModelArgument.addPropertyChangeListener(this)
        }

        /**
         * Complete the template with the Argument instance representing the intermediate version
         * of the selected service model
         */
        final override completeProcessingConfigurationTemplate(
            ProcessingConfigurationWithLaunchConfigurationName templateToComplete
        ) {
            templateToComplete.arguments.add(alternativeIntermediateServiceModelArgument)
        }

        /**
         * Close the dialog
         */
        final override close() {
            alternativeIntermediateServiceModelArgument.removePropertyChangeListener(this)
            super.close()
        }
    }
}