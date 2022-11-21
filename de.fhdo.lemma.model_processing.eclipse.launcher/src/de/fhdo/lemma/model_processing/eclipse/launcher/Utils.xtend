package de.fhdo.lemma.model_processing.eclipse.launcher

import org.w3c.dom.Element
import java.util.List
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.resources.IFile
import org.eclipse.swt.widgets.Text
import org.eclipse.jface.databinding.swt.typed.WidgetProperties
import org.eclipse.core.databinding.beans.typed.BeanProperties
import org.eclipse.swt.SWT
import org.eclipse.core.databinding.DataBindingContext
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.jface.viewers.TableViewer
import org.eclipse.jface.fieldassist.ControlDecoration
import org.eclipse.jface.fieldassist.FieldDecorationRegistry
import java.nio.charset.StandardCharsets
import java.io.ByteArrayOutputStream
import org.eclipse.ui.console.MessageConsoleStream
import org.eclipse.ui.PlatformUI
import java.util.concurrent.TimeUnit
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils
import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.technology.Technology
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.service.ImportType
import de.fhdo.lemma.operation.OperationModel
import de.fhdo.lemma.technology.mapping.TechnologyMapping
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.swt.widgets.Control
import org.eclipse.jface.databinding.swt.ISWTObservableValue
import org.eclipse.swt.widgets.Combo
import org.eclipse.swt.events.SelectionListener
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.emf.ecore.EObject
import de.fhdo.lemma.service.Import
import de.fhdo.lemma.utils.LemmaUtils
import java.io.ByteArrayInputStream
import javax.xml.parsers.DocumentBuilderFactory
import org.w3c.dom.Document
import static de.fhdo.lemma.model_processing.eclipse.launcher.LaunchConfigurationConstants.*
import org.eclipse.jface.viewers.ISelection
import org.eclipse.core.runtime.Platform
import org.eclipse.ui.IEditorPart
import org.eclipse.ui.part.FileEditorInput
import org.eclipse.ui.console.ConsolePlugin
import org.eclipse.ui.console.MessageConsole
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration
import org.eclipse.debug.core.ILaunchManager
import org.eclipse.debug.core.ILaunchConfigurationType

/**
 * Utility methods for the model processing launch configuration.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class Utils {
    static val TRANSFORMABLE_MODEL_KINDS = #[DataModel, ServiceModel, OperationModel]

    /**
     * Find a file with a certain name in a certain project of the current workspace
     */
    static def findFileInWorkspaceProject(String projectName, String filename) {
        return try {
            findProjectInCurrentWorkspace(projectName)?.findMember(filename) as IFile
        } catch (ClassCastException ex) {
            null
        }
    }

    /**
     * Find a certain project of the current workspace
     */
    static def findProjectInCurrentWorkspace(String projectName) {
        return ResourcesPlugin.workspace.root.projects.findFirst[it.name == projectName]
    }

    /**
     * Throw an IllegalArgumentException with a given message in case a given String is null or
     * empty
     */
    static def notNullOrEmpty(String s, String errorMessage) {
        if (s.nullOrEmpty)
            throw new IllegalArgumentException(errorMessage)
    }

    /**
     * Throw an IllegalArgumentException with a given message in case a given String is empty
     */
    static def notEmpty(String s, String errorMessage) {
        if (s.empty)
            throw new IllegalArgumentException(errorMessage)
    }

    /**
     * Throw an IllegalArgumentException with a given message in case a given object is null
     */
    static def notNull(Object o, String errorMessage) {
        if (o === null)
            throw new IllegalArgumentException(errorMessage)
    }

    /**
     * Find an XML element's first child that has a given tag
     */
    static def findChildElementWithTag(Element parent, String tag) {
        val children = parent.childNodes
        for (n : 0..<children.length) {
            val child = children.item(n)
            if (child instanceof Element && (child as Element).tagName == tag)
                return child as Element
        }
        return null
    }

    /**
     * Check if all elements of two lists are equal (==-semantics)
     */
    static def <T> equalLists(List<T> l1, List<? extends T> l2) {
        if (l1.size !== l2.size)
            return false

        for (i : 0 ..< l1.size)
            if (l1.get(i) != l2.get(i))
                return false

        return true
    }

    /**
     * Perform a "flat" copy of a given list. A "flat" copy is a new ArrayList instance that
     * comprises the same elements of the given list.
     */
    static def <T> flatCopy(List<T> list) {
        val copy = newArrayList()
        copy.addAll(list)
        return copy
    }

    /**
     * Add an element to the given list and return the list
     */
    static def <T> addInPlace(List<T> list, T element) {
        list.add(element)
        return list
    }

    /**
     * Move an element one index up in a given list and return the list. Note that the "move up"-
     * behavior is "rotating", i.e., an item at index 0 will be put to the end of the list.
     */
    static def <T> moveUpInPlace(List<T> list, T element) {
        val index = list.indexOf(element)
        switch (index) {
            case 0: {
                list.remove(0)
                list.add(element)
            }
            case index > 0: {
                list.add(index - 1, element)
                list.remove(index + 1)
            }
        }

        return list
    }

    /**
     * Move an element one index down in a given list and return the list. Note that the "move
     * down"-behavior is "rotating", i.e., an item at the end of the list will be put to index 0.
     */
    static def <T> moveDownInPlace(List<T> list, T element) {
        val index = list.indexOf(element)
        val lastIndex = list.size - 1
        switch (index) {
            case index > -1 && index == lastIndex: {
                list.remove(lastIndex)
                list.add(0, element)
            }
            case index > -1: {
                list.remove(index)
                list.add(index + 1, element)
            }
        }

        return list
    }

    /**
     * Add an element from the given list and return the list
     */
    static def <T> removeInPlace(List<T> list, T element) {
        list.remove(element)
        return list
    }

    /**
     * Remove all given elements from a list and return the list
     */
    static def <T> removeAllInPlace(List<T> list, List<T> elements) {
        list.removeAll(elements)
        return list
    }

    /**
     * Bind a UI control to a property of a Bean class and attach a validation listener to the
     * control. A validation listener will call the given validation procedure each time the control
     * is changed and on the new value of the control. In case the value is invalid, the validation
     * procedure is expected to throw an IllegalArgumentException whose message the validation
     * listener will display as a decoration for the given control.
     */
    static def <T> bindWithValidationDecorationSupport(
        Control control,
        DataBindingContext dataBindingContext,
        Class<T> beanClass,
        String propertyName,
        T source,
        (String)=>void validationProcedure
    ) {
        val target = control.toObservableValue
        val model = BeanProperties.value(beanClass, propertyName).observe(source)
        val updateStrategy = null

        val decoration = new ControlDecoration(control, SWT.TOP.bitwiseOr(SWT.LEFT))
        control.addValidationListener(decoration, validationProcedure)

        val bindValue = dataBindingContext.bindValue(target, model, updateStrategy, null)
        return bindValue -> decoration
    }

    /**
     * Wrap a generic SWT Control into an ISWTObservableValue
     */
    private static dispatch def toObservableValue(Control control) {
        throw new IllegalArgumentException('''Creation of «ISWTObservableValue.simpleName» ''' +
            '''instance not supported for controls of type «control.class.simpleName»''')
    }

    /**
     * Wrap an SWT Text into an ISWTObservableValue
     */
    private static dispatch def toObservableValue(Text text) {
        return WidgetProperties.text(SWT.Modify).observe(text)
    }

    /**
     * Wrap an SWT Combo into an ISWTObservableValue
     */
    private static dispatch def toObservableValue(Combo combo) {
        return WidgetProperties.comboSelection.observe(combo)
    }

    /**
     * Add a validation listener to a generic SWT Control
     */
    private static dispatch def addValidationListener(
        Control control,
        ControlDecoration decoration,
        (String)=>void validationProcedure
    ) {
        throw new IllegalArgumentException("Validation listeners not supported for controls of " +
            '''type «control.class.simpleName»''')
    }

    /**
     * Add a validation listener to an SWT Text
     */
    private static dispatch def addValidationListener(Text text, ControlDecoration decoration,
        (String)=>void validationProcedure) {
        text.addModifyListener([
            try {
                validationProcedure.apply((widget as Text).text)
                decoration.hide()
            } catch (IllegalArgumentException ex) {
                decoration.descriptionText = ex.message
                decoration.image = FieldDecorationRegistry
                    .^default
                    .getFieldDecoration(FieldDecorationRegistry.DEC_ERROR)
                    .image
                decoration.show()
            }
        ])
    }

    /**
     * Add a validation listener to an SWT Combo
     */
    private static dispatch def addValidationListener(Combo combo, ControlDecoration decoration,
        (String)=>void validationProcedure) {
        combo.addSelectionListener(new SelectionListener() {
            override widgetDefaultSelected(SelectionEvent event) {
                widgetSelected(event)
            }

            override widgetSelected(SelectionEvent event) {
                try {
                    validationProcedure.apply(combo.text)
                    decoration.hide()
                } catch (IllegalArgumentException ex) {
                    decoration.descriptionText = ex.message
                    decoration.image = FieldDecorationRegistry
                        .^default
                        .getFieldDecoration(FieldDecorationRegistry.DEC_ERROR)
                        .image
                    decoration.show()
                }
            }
        })
    }

    /**
     * Check if the user selected only a single row in a given TableViewer. If so, return the
     * corresponding IStructuredSelection instance. Otherwise display an error dialog.
     */
    static def singleRowSelectionOrError(TableViewer viewer) {
        val selection = viewer.selection as IStructuredSelection
        return if (selection.empty) {
            MessageDialog.openError(viewer.control.shell, "No Row Selected", "Please select a " +
                "single row.")
            null
        } else if (selection.length > 1) {
            MessageDialog.openError(viewer.control.shell, "Too Many Rows Selected", "Please " +
                "select only a single row.")
            null
        } else
            selection
    }

    /**
     * Check if the user selected at least one row in a given TableViewer. If so, return the
     * corresponding IStructuredSelection instance. Otherwise display an error dialog.
     */
    static def rowSelectionOrError(TableViewer viewer) {
        val selection = viewer.selection as IStructuredSelection
        return if (selection.empty) {
            MessageDialog.openError(viewer.control.shell, "No Rows Selected", "Please select at " +
                "least one row.")
            null
        } else
            selection
    }

    /**
     * Print the given string to the MessageConsoleStream indenting it by one INDENT
     */
    static def printlnIndent(MessageConsoleStream stream, String s) {
        stream.printlnIndent(s, 1)
    }

    public static val INDENT = " ".repeat(2)

    /**
     * Print the given string to the MessageConsoleStream indenting it by the given number of
     * INDENTs
     */
    static def printlnIndent(MessageConsoleStream stream, String s, int numberOfIndents) {
        stream.println(INDENT.repeat(numberOfIndents) + s)
    }

    /**
     * Get the currently active SWT Shell
     */
    static def getActiveShell() {
        return PlatformUI.workbench.activeWorkbenchWindow.shell
    }

    /**
     * Get the current workbench display
     */
    static def getWorkbenchDisplay() {
        return PlatformUI.workbench.display
    }

    /**
     * Execute the given command in a blocking fashion. The command will be executed in a new
     * Process and the helper will wait for the Process to terminate in at most
     * (cycleTime * maxCycles) milliseconds. If the Process does not terminate within that time, the
     * helper will kill the Process and throw an IllegalStateException. Otherwise, the helper will
     * return the Process's exit value, and STDOUT output (Process exited with value 0) or STDERR
     * output (Process exited with a value other than 0).
     */
    static def Pair<Integer, String> executeShellCommandBlocking(String command, int cycleTime,
        int maxCycles) {
        val process = Runtime.runtime.exec(command)
        val infoStream = new ByteArrayOutputStream()
        process.inputStream.transferTo(infoStream)
        val errorStream = new ByteArrayOutputStream()
        process.errorStream.transferTo(errorStream)

        var cycle = 0
        while(process.alive && cycle < maxCycles) {
            try {
                process.waitFor(cycleTime, TimeUnit.MILLISECONDS)
                cycle += 1
            } catch (InterruptedException ex) {
                process.destroyForcibly
                throw ex
            }
        }

        if (process.alive) {
            process.destroyForcibly
            throw new IllegalStateException('''Command «command» didn't finish in granted time ''' +
                '''(«cycleTime*maxCycles» ms)''')
        }

        val messageStream = process.exitValue == 0 ? infoStream : errorStream
        return process.exitValue -> messageStream.toString(StandardCharsets.UTF_8)
    }

    /**
     * Parse the source model file of the given model processing configuration for imports. The
     * method returns a list of Pairs whose keys are the EObject classes of the root elements of the
     * imported metamodel kinds and whose values are ImportInfo instances that subsume relevant
     * information about a model import in a canonical form.
     */
    static def parseTransformableImportedModelsOfSourceModelFile(
        ProcessingConfiguration processingConfiguration
    ) {
        val sourceModelFile = processingConfiguration.sourceModelFile
        if (sourceModelFile === null)
            throw new IllegalArgumentException("Please specify an existing source model file")

        val imports = parseImports(sourceModelFile)
            .filter[TRANSFORMABLE_MODEL_KINDS.contains(it.key)]
            .toList
        if (imports.empty)
            throw new IllegalArgumentException("Source model does not import other models")

        return imports
    }

    /**
     * Retrieve all imports from a LEMMA model represented by the given IFile. The helper returns a
     * list of Pairs whose keys are the EObject classes of the root elements of the imported
     * metamodel kinds (e.g., DataModel for a "datatype" import in a service model) and whose values
     * are ImportInfo instances that subsume relevant information about a model import in a
     * canonical form.
     */
    static def parseImports(IFile file) {
        try {
            val resource = LemmaUiUtils.loadXtextResource(file)
            val modelRoot = resource.contents.get(0)
            return modelRoot.typedImports.toList as List<Pair<Class<? extends EObject>, ImportInfo>>
        } catch(Exception ex) {
            throw new IllegalArgumentException("Error during parsing of model file" +
                '''«file.name»: «ex.message»''')
        }
    }

    /**
     * Canonical form of a LEMMA model import that subsumes all relevant information which are
     * common for different kinds of LEMMA imports (e.g., ComplexTypeImport for DataModel instances
     * and Import ServiceModel instances)
     */
    static class ImportInfo {
        @Accessors(PUBLIC_GETTER)
        val String alias
        @Accessors(PUBLIC_GETTER)
        val String importUri
        new(String alias, String importUri) {
            this.alias = alias
            this.importUri = importUri
        }
    }

    /**
     * Return a list of Pairs of root element types and ImportInfo instances of imports in a given
     * DataModel
     */
    static dispatch def typedImports(DataModel modelRoot) {
        return modelRoot.complexTypeImports.map[DataModel -> new ImportInfo(it.name, it.importURI)]
    }

    /**
     * Return a list of Pairs of root element types and ImportInfo instances of imports in a given
     * Technology
     */
    static dispatch def typedImports(Technology modelRoot) {
        return modelRoot.imports.map[Technology -> new ImportInfo(it.name, it.importURI)]
    }

    /**
     * Return a list of Pairs of root element types and ImportInfo instances of imports in a given
     * ServiceModel
     */
    static dispatch def typedImports(ServiceModel modelRoot) {
        return modelRoot.imports.map[
            it.importType.modelRootClass -> new ImportInfo(it.name, it.importURI)
        ]
    }

    /**
     * Helper to get the EObject class of a model that is imported using a certain ImportType
     */
    private static def getModelRootClass(ImportType importType) {
        return switch(importType) {
            case DATATYPES: DataModel
            case TECHNOLOGY: Technology
            case MICROSERVICES: ServiceModel
            case OPERATION_NODES: OperationModel
        }
    }

    /**
     * Return a list of Pairs of root element types and ImportInfo instances of imports in a given
     * TechnologyMapping
     */
    static dispatch def typedImports(TechnologyMapping modelRoot) {
        return modelRoot.imports.map[
            it.importType.modelRootClass -> new ImportInfo(it.name, it.importURI)
        ]
    }

    /**
     * Return a list of Pairs of root element types and ImportInfo instances of imports in a given
     * OperationModel
     */
    static dispatch def typedImports(OperationModel modelRoot) {
        return modelRoot.imports.map[
            it.importType.modelRootClass -> new ImportInfo(it.name, it.importURI)
        ]
    }

    /**
     * Make the paths of a DataModel's imports absolute w.r.t. the given base IFile
     */
    static dispatch def makeImportPathsAbsolute(DataModel modelRoot, IFile basefile) {
        modelRoot.makeImportPathsAbsoluteFromBasefilePath(
            basefile.rawLocation.makeAbsolute.toString
        )
    }

    /**
     * Make the paths of a DataModel's imports absolute w.r.t. the given base path
     */
    static dispatch def makeImportPathsAbsoluteFromBasefilePath(DataModel modelRoot,
        String absoluteBasefilePath) {
        modelRoot.complexTypeImports.forEach[
            it.importURI = LemmaUtils.convertToAbsolutePath(it.importURI, absoluteBasefilePath)
        ]
    }

    /**
     * Make the paths of a Technology's imports absolute w.r.t. the given base IFile
     */
    static dispatch def makeImportPathsAbsolute(Technology modelRoot, IFile basefile) {
        modelRoot.makeImportPathsAbsoluteFromBasefilePath(
            basefile.rawLocation.makeAbsolute.toString
        )
    }

    /**
     * Make the paths of a Technology's imports absolute w.r.t. the given base path
     */
    static dispatch def makeImportPathsAbsoluteFromBasefilePath(Technology modelRoot,
        String absoluteBasefilePath) {
        modelRoot.imports.forEach[
            it.importURI = LemmaUtils.convertToAbsolutePath(it.importURI, absoluteBasefilePath)
        ]
    }

    /**
     * Make the paths of a ServiceModel's imports absolute w.r.t. the given base IFile
     */
    static dispatch def makeImportPathsAbsolute(ServiceModel modelRoot, IFile basefile) {
        modelRoot.makeImportPathsAbsoluteFromBasefilePath(
            basefile.rawLocation.makeAbsolute.toString
        )
    }

    /**
     * Make the paths of a ServiceModel's imports absolute w.r.t. the given base path
     */
    static dispatch def makeImportPathsAbsoluteFromBasefilePath(ServiceModel modelRoot,
        String absoluteBasefilePath) {
        modelRoot.imports.forEach[it.makeImportPathAbsolute(absoluteBasefilePath)]
    }

    /**
     * Make the path of the given Import absolute w.r.t. the given base path
     */
    private static def makeImportPathAbsolute(Import ^import, String absoluteBasefilePath) {
        import.importURI = LemmaUtils.convertToAbsolutePath(import.importURI,
            absoluteBasefilePath)
    }

    /**
     * Make the paths of a TechnologyMapping's imports absolute w.r.t. the given base IFile
     */
    static dispatch def makeImportPathsAbsolute(TechnologyMapping modelRoot, IFile basefile) {
        modelRoot.makeImportPathsAbsoluteFromBasefilePath(
            basefile.rawLocation.makeAbsolute.toString
        )
    }

    /**
     * Make the paths of a TechnologyMapping's imports absolute w.r.t. the given base path
     */
    static dispatch def makeImportPathsAbsoluteFromBasefilePath(TechnologyMapping modelRoot,
        String absoluteBasefilePath) {
        modelRoot.imports.forEach[it.makeImportPathAbsolute(absoluteBasefilePath)]
    }

    /**
     * Make the paths of an OperationModel's imports absolute w.r.t. the given base IFile
     */
    static dispatch def makeImportPathsAbsolute(OperationModel modelRoot, IFile basefile) {
        modelRoot.makeImportPathsAbsoluteFromBasefilePath(
            basefile.rawLocation.makeAbsolute.toString
        )
    }

    /**
     * Make the paths of an OperationModel's imports absolute w.r.t. the given base path
     */
    static dispatch def makeImportPathsAbsoluteFromBasefilePath(OperationModel modelRoot,
        String absoluteBasefilePath) {
        modelRoot.imports.forEach[it.makeImportPathAbsolute(absoluteBasefilePath)]
    }

    /**
     * Programmatically trigger the validation of a text field by temporarily changing its value to
     * a different one
     */
    static def triggerValidation(Text field) {
        val currentText = field.text
        field.text = '''«currentText»TriggerUpdate'''
        field.text = currentText
    }

    /**
     * Parse the given XML String into an XML Document
     */
    static def parseXmlString(String xml) {
        val builder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
        return builder.parse(new ByteArrayInputStream(xml.bytes))
    }

    /**
     * Return the root element of the given XML Document if it has the given tag or null otherwise
     */
    static def getRootElementWithTag(Document document, String tag) {
        val rootElement = document.documentElement
        return if (rootElement !== null && rootElement instanceof Element &&
            (rootElement as Element).tagName == tag)
            rootElement as Element
        else
            null
    }

    /**
     * Get all model processing launch configurations
     */
    static def getModelProcessingLaunchConfigurations() {
        return LAUNCH_MANAGER
            .getLaunchConfigurations(PROCESSING_CONFIGURATION_LAUNCH_CONFIGURATION_TYPE)
            .toMap([it.name], [it])
    }

    /**
     * Get the IFile selected by the given ISelection
     */
    static def getSelectedFile(ISelection selection) {
        return if (selection instanceof IStructuredSelection) {
            val structuredSelection = selection as IStructuredSelection
            Platform.adapterManager.getAdapter(structuredSelection.firstElement, IFile)
        } else
            null
    }

    /**
     * Get the IFile that is currently edited in the given IEditorPart
     */
    static def getEditedFile(IEditorPart editor) {
        return if (editor.editorInput instanceof FileEditorInput) {
               val path = (editor.editorInput as FileEditorInput).path
                ResourcesPlugin.workspace.root.getFileForLocation(path)
            } else
                null
    }

    /**
     * Get or create an Eclipse MessageConsole with the given name, and also reveal it
     */
    static def getAndRevealConsole(String name) {
        val consoleManager = ConsolePlugin.^default.consoleManager
        var console = consoleManager.consoles.findFirst[it.name == name]
        if (console === null) {
            console = new MessageConsole(name, null)
            consoleManager.addConsoles(#[console])
        }

        consoleManager.showConsoleView(console)

        return console as MessageConsole
    }

    /**
     * Create a new error MessageStream for the given MessageConsole. An error MessageStream has a
     * different color (normally red) than a "regular" MessageStream.
     */
    static def newErrorMessageStream(MessageConsole console) {
        val stream = console.newMessageStream
        // Color setting needs to be done by UI thread because it enforces redrawing the widget and
        // this otherwise would result in an invalid thread access
        getWorkbenchDisplay.syncExec([stream.color = CONSOLE_ERROR_COLOR])
        return stream
    }

    /**
     * Get the launch configurations applicable to the given IFile as a mapped resource
     */
    static def getLaunchConfigurationsForMappedResource(
        ILaunchManager launchManager,
        ILaunchConfigurationType configurationType,
        IFile file
    ) {
        return LAUNCH_MANAGER
            .getLaunchConfigurations(PROCESSING_CHAIN_LAUNCH_CONFIGURATION_TYPE)
            .filter[
                it.mappedResources !== null &&
                it.mappedResources.exists[resource |
                    resource instanceof IFile && resource.fullPath == file.fullPath
                ]
            ]
    }

    /**
     * Helper to replace a given String searchString with a given String replacement in a given
     * String text.
     *
     * Note: The method's code was translated to Xtend from the eponymous method of the Java-based
     * StringUtils class of Apache's Commons Lang library. By implementing our own version of the
     * method, we can provide the plugin also as an Eclipse drop-in as recent Eclipse versions don't
     * include Apache Commons Lang by default.
     */
    static def replace(String text, String searchString, String replacement) {
        if (text.nullOrEmpty || searchString.nullOrEmpty || replacement.nullOrEmpty)
            return text

        var start = 0
        var end = text.indexOf(searchString, start)
        if (end == -1)
            return text

        var replLength = searchString.length()
        var increase = Math.max(replacement.length - replLength, 0) * 16
        var buf = new StringBuilder(text.length + increase)
        while (end != -1) {
            buf.append(text, start, end).append(replacement)
            start = end + replLength
            end = text.indexOf(searchString, start)
        }

        buf.append(text, start, text.length)
        return buf
    }

    /**
     * Helper to remove a given String remove from the start of a given String s.
     *
     * Note: The method's code was translated to Xtend from the eponymous method of the Java-based
     * StringUtils class of Apache's Commons Lang library. By implementing our own version of the
     * method, we can provide the plugin also as an Eclipse drop-in as recent Eclipse versions don't
     * include Apache Commons Lang by default.
     */
    static def removeStart(String s, String remove) {
        return if (s.nullOrEmpty || remove.nullOrEmpty)
                s
            else if (s.startsWith(remove))
                s.substring(remove.length)
            else
                s
    }

    /**
     * Helper to remove a given String remove from the end of a given String s.
     *
     * Note: The method's code was translated to Xtend from the eponymous method of the Java-based
     * StringUtils class of Apache's Commons Lang library. By implementing our own version of the
     * method, we can provide the plugin also as an Eclipse drop-in as recent Eclipse versions don't
     * include Apache Commons Lang by default.
     */
    static def removeEnd(String s, String remove) {
        return if (s.nullOrEmpty || remove.nullOrEmpty)
                s
            else if (s.endsWith(remove))
                s.substring(0, s.length - remove.length)
            else
                s
    }

    /**
     * Helper to get the substring occurring in a given String s before a given String sep.
     *
     * Note: The method's code was translated to Xtend from the eponymous method of the Java-based
     * StringUtils class of Apache's Commons Lang library. By implementing our own version of the
     * method, we can provide the plugin also as an Eclipse drop-in as recent Eclipse versions don't
     * include Apache Commons Lang by default.
     */
    static def substringBeforeLast(String s, String sep) {
        if (s.nullOrEmpty || sep.nullOrEmpty)
            return s

        val pos = s.lastIndexOf(sep)
        return if (pos !== -1)
                s
            else
                s.substring(0, pos)
    }

    /**
     * Helper to get the substring occurring in a given String s after a given String sep.
     *
     * Note: The method's code was translated to Xtend from the eponymous method of the Java-based
     * StringUtils class of Apache's Commons Lang library. By implementing our own version of the
     * method, we can provide the plugin also as an Eclipse drop-in as recent Eclipse versions don't
     * include Apache Commons Lang by default.
     */
    static def substringAfterLast(String s, String sep) {
        if (s.nullOrEmpty)
            return s

        val pos = s.lastIndexOf(sep)
        return if (pos == -1 || pos == s.length - 1)
                ""
            else
                s.substring(pos + 1)
    }
}