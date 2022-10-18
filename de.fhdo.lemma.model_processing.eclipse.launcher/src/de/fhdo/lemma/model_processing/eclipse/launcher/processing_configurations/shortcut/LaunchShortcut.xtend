package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut

import org.eclipse.jface.viewers.ISelection
import org.eclipse.ui.IEditorPart
import org.eclipse.core.resources.IFile
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.swt.widgets.Shell
import java.util.List
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.layout.GridData
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.core.resources.IProject
import org.eclipse.debug.core.DebugPlugin
import org.eclipse.debug.ui.ILaunchShortcut2
import static de.fhdo.lemma.model_processing.eclipse.launcher.LaunchConfigurationConstants.PROCESSING_CONFIGURATION_LAUNCH_CONFIGURATION_TYPE
import org.eclipse.debug.ui.DebugUITools
import org.eclipse.debug.core.ILaunchManager
import org.eclipse.debug.core.ILaunchConfiguration
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator.JavaBaseGeneratorTemplate
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator.DockerJavaBaseGeneratorTemplate
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator.DockerTypeFocusedMappingModelJavaBaseGeneratorTemplate
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator.TypeFocusedMappingModelJavaBaseGeneratorTemplate
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.events.SelectionAdapter
import org.eclipse.swt.events.SelectionEvent
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.service.ImportType
import de.fhdo.lemma.utils.LemmaUtils
import de.fhdo.lemma.operation.OperationModel
import de.fhdo.lemma.technology.mapping.TechnologyMapping
import java.util.Map
import org.eclipse.emf.ecore.EObject
import de.fhdo.lemma.technology.Technology
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.mariadb.MariaDBGeneratorTemplate
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.mongodb.MongoDBGeneratorTemplate
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.mariadb.DockerMariaDBGeneratorTemplate
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.mongodb.DockerMongoDBGeneratorTemplate
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.eureka.EurekaGeneratorTemplate
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.eureka.DockerEurekaGeneratorTemplate
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.zuul.ZuulGeneratorTemplate
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.zuul.DockerZuulGeneratorTemplate
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.deployment_base_generator.DockerDeploymentBaseGeneratorTemplate
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.deployment_base_generator.DeploymentBaseGeneratorTemplate

/**
 * Launch shortcut for model processing launch configurations.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class LaunchShortcut implements ILaunchShortcut2 {
    static val LAUNCH_MANAGER = DebugPlugin.^default.launchManager

    static val SUPPORTED_LAUNCH_CONFIGURATION_TEMPLATES = #{
        "mapping" -> <Class<? extends AbstractLaunchConfigurationTemplate>>newArrayList(
                DockerJavaBaseGeneratorTemplate,
                DockerTypeFocusedMappingModelJavaBaseGeneratorTemplate,
                JavaBaseGeneratorTemplate,
                TypeFocusedMappingModelJavaBaseGeneratorTemplate
            ),
        "operation" -> <Class<? extends AbstractLaunchConfigurationTemplate>>newArrayList(
                DeploymentBaseGeneratorTemplate,
                EurekaGeneratorTemplate,
                MariaDBGeneratorTemplate,
                MongoDBGeneratorTemplate,
                ZuulGeneratorTemplate,
                DockerDeploymentBaseGeneratorTemplate,
                DockerEurekaGeneratorTemplate,
                DockerMariaDBGeneratorTemplate,
                DockerMongoDBGeneratorTemplate,
                DockerZuulGeneratorTemplate
            ),
        "services" -> <Class<? extends AbstractLaunchConfigurationTemplate>>newArrayList(
                JavaBaseGeneratorTemplate,
                DockerJavaBaseGeneratorTemplate
            )
    }

    /**
     * Get the launch configurations associated with a selected file
     */
    final override getLaunchConfigurations(ISelection selection) {
        val file = getSelectedFile(selection)
        return if (file !== null)
                file.launchConfigurations
            else
                null
    }

    /**
     * Get the launch configurations applicable to the given IFile as a mapped resource
     */
    private def getLaunchConfigurations(IFile file) {
        return getLaunchConfigurationsForMappedResource(
            LAUNCH_MANAGER,
            PROCESSING_CONFIGURATION_LAUNCH_CONFIGURATION_TYPE,
            file
        )
    }

    /**
     * Get launchable resource associated with a selected file
     */
    final override getLaunchableResource(ISelection selection) {
        // Null because the shortcut provides specific launch configurations to execute
        return null
    }

    /**
     * Execute the shortcut for the selected file in the given mode
     */
    final override launch(ISelection selection, String mode) {
        getSelectedFile(selection).launch(mode)
    }

    /**
     * Execute the shortcut on the given file in the given mode
     */
    private def launch(IFile file, String mode) {
        if (file === null)
            return

        val project = file.projectOrError
        if (project === null)
            return

        val templates = file.launchConfigurationTemplates
        if (!templates.empty)
            new TemplateSelectionDialog(getActiveShell(), project, file, templates).open
        else
            MessageDialog.openInformation(getActiveShell(), "Quick launch not supported", "Quick " +
                '''launch for model files with extension "«file.rawLocation.fileExtension»" is ''' +
                "currently not supported")
    }

    /**
     * Helper to the Eclipse project for the given IFile or display an error in case the project is
     * not determinable
     */
    private def getProjectOrError(IFile file) {
        val project = file.project
        return if (project !== null)
                project
            else {
                MessageDialog.openError(getActiveShell(), "Project not determinable", "Could not " +
                    '''determine project for model file "«file.rawLocation.makeAbsolute»". ''' +
                    "Model files must be part of a project in the current workspace to process " +
                    "them.")
                null
            }
    }

    /**
     * Helper to retrieve completable launch configuration templates from the extension of the given
     * IFile
     */
    private def getLaunchConfigurationTemplates(IFile file) {
        return SUPPORTED_LAUNCH_CONFIGURATION_TEMPLATES.get(file.rawLocation.fileExtension) ?: #[]
    }

    /**
     * Get the launch configurations associated with the currently edited file
     */
    final override getLaunchConfigurations(IEditorPart editor) {
        val file = getEditedFile(editor)
        return if (file !== null)
                file.launchConfigurations
            else
                null
    }

    /**
     * Get launchable resource associated with the currently edited file
     */
    final override getLaunchableResource(IEditorPart editorpart) {
        return null
    }

    /**
     * Execute the shortcut for the currently edited file in the given mode
     */
    final override launch(IEditorPart editor, String mode) {
        getEditedFile(editor).launch(mode)
    }

    /**
     * Dialog to select a completable configuration template from a set of templates
     */
    private static class TemplateSelectionDialog extends TitleAreaDialog {
        val IProject project
        val IFile file
        val List<? extends AbstractLaunchConfigurationTemplate> allTemplates
        var List<? extends AbstractLaunchConfigurationTemplate> applicableTemplates
        var List<? extends AbstractLaunchConfigurationTemplate> currentTemplates
        var org.eclipse.swt.widgets.List templateSelectionList
        var Button continueButton

        /**
         * Constructor
         */
        new(
            Shell parentShell,
            IProject project,
            IFile file,
            List<Class<? extends AbstractLaunchConfigurationTemplate>> templateClasses
        ) {
            super(parentShell)
            this.project = project
            this.file = file
            allTemplates = templateClasses.map[it.instantiate].sortBy[it.name]
            currentTemplates = allTemplates
            helpAvailable = false
        }

        /**
         * Instantiate an AbstractLaunchConfigurationTemplate instance from the given class
         */
        private def instantiate(
            Class<? extends AbstractLaunchConfigurationTemplate> templateClass
        ) {
            val constructor = templateClass.constructors
                .findFirst[
                    it.parameterCount == 3 &&
                    it.parameterTypes.get(0) == Shell &&
                    it.parameterTypes.get(1) == IProject &&
                    it.parameterTypes.get(2) == IFile
                ]

            if (constructor !== null)
                return constructor.newInstance(shell, project, file)
                    as AbstractLaunchConfigurationTemplate
            else
                throw new IllegalArgumentException("Launch configuration template of type " +
                    '''«templateClass.simpleName» not instantiable. Required constructor with ''' +
                    '''parameters of types «Shell.simpleName», «IProject.simpleName» and ''' +
                    '''«IFile.simpleName» not found.''')
        }

        /**
         * Create the dialog
         */
        override create() {
            super.create()
            title = "Select quick launch configuration"
            message = "Please select a quick launch configuration from the list below"
        }

        /**
         * Create the dialog area
         */
        override createDialogArea(Composite parent) {
            val area = super.createDialogArea(parent) as Composite
            val container = new Composite(area, SWT.NONE);
            container.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true)
            container.layout = new GridLayout(1, false)

            container.addTemplateSelection
            container.addFilterNonApplicableTemplates

            return area
        }

        /**
         * Add template selection list to the dialog
         */
        private def addTemplateSelection(Composite parent) {
            templateSelectionList = new org.eclipse.swt.widgets.List(parent,
                SWT.BORDER.bitwiseOr(SWT.H_SCROLL).bitwiseOr(SWT.V_SCROLL))
            templateSelectionList.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true)
            updateTemplateSelectionList()
        }

        /**
         * Update the template selection list from the domain object representing the list of
         * current templates
         */
        private def updateTemplateSelectionList() {
            templateSelectionList.removeAll
            currentTemplates.forEach[templateSelectionList.add(it.name)]
        }

        /**
         * Add checkbox to filter non-applicable templates to the dialog
         */
        private def addFilterNonApplicableTemplates(Composite parent) {
            val checkbox = new Button(parent, SWT.CHECK)
            checkbox.text = "Show only applicable templates"
            checkbox.addSelectionListener(new SelectionAdapter() {
                override widgetSelected(SelectionEvent event) {
                    val button = event.source as Button
                    if (button.selection) {
                        if (applicableTemplates === null)
                            applicableTemplates = getApplicableTemplates()

                        currentTemplates = applicableTemplates
                    } else
                        currentTemplates = allTemplates

                    updateTemplateSelectionList()
                    updateContinueButton()
                }
            })
        }

        /**
         * Helper to get the list of templates that are applicable to the source model file
         */
        private def List<? extends AbstractLaunchConfigurationTemplate> getApplicableTemplates() {
            val modelResource = LemmaUiUtils.loadXtextResource(file)
            if (modelResource.contents.empty)
                return emptyList

            val modelRoot = modelResource.contents.get(0)
            val absoluteModelFilePath = file.rawLocation.makeAbsolute.toString

            return allTemplates.filter[
                it.isApplicable(
                    modelRoot,
                    modelRoot.getAbsoluteTechnologyModelImportPathPerAlias(absoluteModelFilePath)
                        .technologyNamePerAlias
                )
            ].toList
        }

        /**
         * Helper to retrieve the aliases and absolute paths of LEMMA technology models imported by
         * the given LEMMA source model root
         */
        private def getAbsoluteTechnologyModelImportPathPerAlias(EObject modelRoot,
            String absoluteModelPath) {
            val imports = try {
                    modelRoot.imports
                } catch (IllegalArgumentException ex) {
                    return emptyMap
                }

            return imports
                .filter[it.importType == ImportType.TECHNOLOGY]
                .toMap(
                    [it.name],
                    [LemmaUtils.convertToAbsolutePath(it.importURI, absoluteModelPath)]
                )
        }

        /**
         * Retrieve all imports of the given ServiceModel
         */
        private dispatch def getImports(ServiceModel modelRoot) {
            return modelRoot.imports
        }

        /**
         * Retrieve all imports of the given TechnologyMapping
         */
        private dispatch def getImports(TechnologyMapping modelRoot) {
            return modelRoot.imports
        }

        /**
         * Retrieve all imports of the given OperationModel
         */
        private dispatch def getImports(OperationModel modelRoot) {
            return modelRoot.imports
        }

        /**
         * Retrieve all imports of a generic EObject
         */
        private dispatch def getImports(EObject modelRoot) {
            throw new IllegalArgumentException('''Model type «modelRoot.class.simpleName» does ''' +
                '''not support model imports''')
        }

        /**
         * Parse LEMMA technology models to retrieve the names of the modeled technologies per alias
         * in the model which imports the technology models. The given map is expected to state per
         * import alias the absolute path of the corresponding technology model.
         */
        private def getTechnologyNamePerAlias(
            Map<String, String> technologyModelImportPathPerAlias
        ) {
            val resultMap = <String, String>newHashMap

            for (entry : technologyModelImportPathPerAlias.entrySet) {
                val importPath = entry.value
                val modelContents = LemmaUiUtils.loadXtextResource(importPath).contents
                val modelRoot = if (!modelContents.empty) modelContents.get(0) else null
                val technologyName = if (modelRoot instanceof Technology) modelRoot.name else null

                val alias = entry.key

                resultMap.put(alias, technologyName)
            }

            return resultMap
        }

        /**
         * Update continue button from the dialog's state
         */
        private def updateContinueButton() {
            continueButton.enabled = !currentTemplates.empty
        }

        /**
         * Create the dialog buttons
         */
        override createButtonsForButtonBar(Composite parent) {
            continueButton = createButton(parent, IDialogConstants.OK_ID, "Continue", true)
            updateContinueButton()

            createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false)
        }

        /**
         * Continue button was pressed
         */
        override okPressed() {
            if (templateSelectionList.selectionIndex == -1) {
                MessageDialog.openError(getActiveShell(), "No configuration selected", "Please " +
                    "select a quick launch configuration from the list")
                return
            }

            val launchTemplate = currentTemplates.get(templateSelectionList.selectionIndex)
            var initializedProcessingTemplate = initializeProcessingConfigurationTemplate()
            initializedProcessingTemplate = launchTemplate
                .extendInitializedProcessingConfigurationTemplate(initializedProcessingTemplate)

            val completionDialog = launchTemplate.completionDialog
            completionDialog.initializedProcessingConfigurationTemplate =
                initializedProcessingTemplate
            completionDialog.storeCallback = [it.store]
            completionDialog.runCallback = [it.storeAndRun]

            super.okPressed
            completionDialog.open()
        }

        /**
         * Initialize a model processing configuration to act as the domain object of a completable
         * model processing template
         */
        private def initializeProcessingConfigurationTemplate() {
            val configuration = new ProcessingConfigurationWithLaunchConfigurationName
            configuration.sourceModelProjectName = project.name
            configuration.sourceModelFilePath = file.projectRelativePath.toString
            return configuration
        }

        /**
         * Store the given model processing configuration if it is valid
         */
        private def store(
            ProcessingConfigurationWithLaunchConfigurationName completedProcessingConfiguration
        ) {
            try {
                completedProcessingConfiguration.validateInUserRepresentation
            } catch(IllegalArgumentException ex) {
                MessageDialog.openError(getActiveShell(), "Erroneous processing configuration",
                    '''Processing configuration is erroneous: «ex.message». Storage and ''' +
                    "execution not possible.")
                throw ex
            }

            // Create launch configuration working copy as expected by Eclipse's Debug Plugin
            val launchConfiguration = PROCESSING_CONFIGURATION_LAUNCH_CONFIGURATION_TYPE
                .newInstance(null, completedProcessingConfiguration.launchConfigurationName)
            // Serialize the model processing configuration as an attribute of the launch
            // configuration working copy
            ProcessingConfiguration.setProcessingConfigurationAsAttribute(launchConfiguration,
                completedProcessingConfiguration)
            // Store the launch configuration
            return launchConfiguration.doSave(ILaunchConfiguration.UPDATE_PROTOTYPE_CHILDREN)
        }

        /**
         * Store the given model processing configuration if it is valid and run it afterwards
         */
        private def storeAndRun(
            ProcessingConfigurationWithLaunchConfigurationName completedProcessingConfiguration
        ) {
            DebugUITools.launch(completedProcessingConfiguration.store, ILaunchManager.RUN_MODE)
        }

        /**
         * Flag to indicate that the dialog is resizable
         */
        override isResizable() {
            return true
        }
    }
}