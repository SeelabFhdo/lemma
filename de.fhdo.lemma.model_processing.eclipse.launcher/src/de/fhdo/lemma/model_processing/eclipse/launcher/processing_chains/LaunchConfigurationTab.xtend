package de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains

import org.eclipse.debug.ui.AbstractLaunchConfigurationTab
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import org.eclipse.core.databinding.DataBindingContext
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui.tab.arguments_table.ArgumentsTable
import static de.fhdo.lemma.model_processing.eclipse.launcher.LaunchConfigurationConstants.*
import org.eclipse.swt.widgets.Button
import java.beans.PropertyChangeListener
import java.beans.PropertyChangeEvent
import org.eclipse.jface.viewers.TableViewer
import org.eclipse.jface.viewers.IStructuredContentProvider
import org.eclipse.jface.viewers.TableViewerColumn
import org.eclipse.jface.resource.LocalResourceManager
import org.eclipse.jface.resource.JFaceResources
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils
import org.eclipse.swt.layout.RowLayout
import de.fhdo.lemma.model_processing.eclipse.launcher.ui.ValidatingColumnLabelProvider

/**
 * Launch configuration tab for model processing chain configurations.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class LaunchConfigurationTab extends AbstractLaunchConfigurationTab
    implements PropertyChangeListener {
    static val RESOURCE_MANAGER = new LocalResourceManager(JFaceResources.getResources())
    static val NEW_IMAGE = LemmaUiUtils.createImage(RESOURCE_MANAGER, LaunchConfigurationTab,
        "add.gif")
    static val REMOVE_IMAGE = LemmaUiUtils.createImage(RESOURCE_MANAGER, ArgumentsTable,
        "remove.png")
    static val MOVE_UP_IMAGE = LemmaUiUtils.createImage(RESOURCE_MANAGER, ArgumentsTable,
        "moveUp.png")
    static val MOVE_DOWN_IMAGE = LemmaUiUtils.createImage(RESOURCE_MANAGER, ArgumentsTable,
        "moveDown.png")

    val dataBindingContext = new DataBindingContext()
    val availableLaunchConfigurations = getModelProcessingLaunchConfigurations()
    var Composite mainComposite

    var ProcessingChain originalChain
    var ProcessingChain currentChain
    var TableViewer tableViewer
    var Button newButton
    var Button removeButton
    var Button moveUpButton
    var Button moveDownButton

    /**
     * Create the control
     */
    final override createControl(Composite parent) {
        mainComposite = new Composite(parent, SWT.NULL)
        mainComposite.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true)
        mainComposite.layout = new GridLayout(1, false)
        setControl(mainComposite)
        createTable(mainComposite)
        createButtonRow(mainComposite)
    }

    /**
     * Create the table to configure the entries of a model processing chain
     */
    private def createTable(Composite parent) {
        tableViewer = new TableViewer(parent)
        tableViewer.contentProvider = new IStructuredContentProvider() {
            override getElements(Object inputElement) {
                return currentChain.entries
            }
        }
        tableViewer.table.headerVisible = true
        tableViewer.table.linesVisible = true
        tableViewer.table.layoutData = new GridData(GridData.FILL, GridData.FILL, true, true)
        createLaunchConfigurationColumn()
        createExitValueComparatorColumn()
        createExitValueColumn()
    }

    /**
     * Create the column for selecting the model processing launch configurations of a model
     * processing chain
     */
    private def createLaunchConfigurationColumn() {
        val column = new TableViewerColumn(tableViewer, SWT.NONE)
        column.column.width = 500
        column.column.text = "LEMMA Model Processing Configuration"
        column.labelProvider = new ValidatingColumnLabelProvider<ProcessingChainEntry>() {
            override getElementText(ProcessingChainEntry element) {
                return element.launchConfigurationName
            }

            override validate(ProcessingChainEntry element) {
                element.validateLaunchConfigurationName(availableLaunchConfigurations)
            }
        }
        column.editingSupport = new LaunchConfigurationNameColumnEditingSupport(
            tableViewer,
            dataBindingContext,
            availableLaunchConfigurations.keySet.sortBy[it]
        )
    }

    /**
     * Create the exit value comparator column
     */
    private def createExitValueComparatorColumn() {
        val column = new TableViewerColumn(tableViewer, SWT.NONE)
        column.column.width = 210
        column.column.text = "Previous Exit Value Comparator"
        column.labelProvider = new ValidatingColumnLabelProvider<ProcessingChainEntry>() {
            override getElementText(ProcessingChainEntry element) {
                return PreviousExitValueComparator
                    .getUserRepresentation(element.previousExitValueComparator)
            }

            override validate(ProcessingChainEntry element) {
                element.validatePreviousExitValueComparator
            }
        }
        column.editingSupport = new PreviousExitValueComparatorColumnEditingSupport(tableViewer,
            dataBindingContext)
    }

    /**
     * Create the exit value column
     */
    private def createExitValueColumn() {
        val column = new TableViewerColumn(tableViewer, SWT.NONE)
        column.column.width = 250
        column.column.text = "Expected Exit Value from the Execution of the Previous Configuration"
        column.labelProvider = new ValidatingColumnLabelProvider<ProcessingChainEntry>() {
            override getElementText(ProcessingChainEntry element) {
                return element.previousExitValue?.toString ?: ""
            }

            override validate(ProcessingChainEntry element) {
                element.validatePreviousExitValue
            }
        }
        column.editingSupport = new PreviousExitValueColumnEditingSupport(tableViewer,
            dataBindingContext)
    }

    /**
     * Create the button row for manipulating the entries of the model processing chain table
     */
    private def createButtonRow(Composite parent) {
        val buttonRow = new Composite(parent, SWT.NONE)
        buttonRow.layout = new RowLayout
        createNewButton(buttonRow)
        createRemoveButton(buttonRow)
        createMoveUpButton(buttonRow)
        createMoveDownButton(buttonRow)
    }

    /**
     * Create the button for the creation of a new chain entry
     */
    private def createNewButton(Composite parent) {
        newButton = new Button(parent, SWT.PUSH)
        newButton.image = NEW_IMAGE
        newButton.addListener(SWT.Selection, [
            if (tableViewer.input === null) {
                return
            }

            val entry = new ProcessingChainEntry("", currentChain)
            currentChain.addEntry(entry)
            syncInput()

            // Trigger EditorActivationEvent on all columns and thus getCellEditor() in the
            // argument's EditingSupport. As a result, the data bindings between columns' inputs and
            // argument attributes are established, thereby validating the yet empty inputs.
            // Consequently, the bindings receive possible error states, which are recognizable when
            // the user hits the "Apply" button, even immediately after she added the new row. More
            // precisely, triggering the event doesn't require the user to first enter input fields
            // before the cell is recognized as erroneous by the established bindings. Even more,
            // triggering the event makes editing row columns more convenient as the cell editor is
            // active immediately for input receipt.
            tableViewer.editElement(entry, 0)
        ])
    }

    /**
     * Synchronize the chain's domain object with the displayed table rows
     */
    private def syncInput() {
        if (!currentChain.entries.empty) {
            // There is no previous entry for the first entry in the chain. Thus, clear fields
            // pointing to previous entries.
            val firstEntry = currentChain.entries.get(0)
            firstEntry.previousExitValueComparator = null
            firstEntry.previousExitValue = null
        }

        tableViewer.input = currentChain.entries
    }

    /**
     * Create the button for the removal of a selected chain entry
     */
    private def createRemoveButton(Composite parent) {
        removeButton = new Button(parent, SWT.PUSH)
        removeButton.image = REMOVE_IMAGE
        removeButton.addListener(SWT.Selection, [
            if (tableViewer.input === null) {
                return
            }

            val selectedEntries = rowSelectionOrError(tableViewer)
            if (selectedEntries !== null) {
                currentChain.removeAll(selectedEntries.map[it as ProcessingChainEntry].toList)
                syncInput()
            }
        ])
    }

    /**
     * Create the button for moving up a selected chain entry
     */
    private def createMoveUpButton(Composite parent) {
        moveUpButton = new Button(parent, SWT.PUSH)
        moveUpButton.image = MOVE_UP_IMAGE
        moveUpButton.addListener(SWT.Selection, [
            if (tableViewer.input === null) {
                return
            }

            val selectedEntry = singleRowSelectionOrError(tableViewer)?.firstElement
            if (selectedEntry !== null) {
                currentChain.moveUp(selectedEntry as ProcessingChainEntry)
                syncInput()
            }
        ])
    }

    /**
     * Create the button for moving down a selected chain entry
     */
    private def createMoveDownButton(Composite parent) {
        moveDownButton = new Button(parent, SWT.PUSH)
        moveDownButton.image = MOVE_DOWN_IMAGE
        moveDownButton.addListener(SWT.Selection, [
            if (tableViewer.input === null) {
                return
            }

            val selectedEntry = singleRowSelectionOrError(tableViewer)?.firstElement
            if (selectedEntry !== null) {
                currentChain.moveDown(selectedEntry as ProcessingChainEntry)
                syncInput()
            }
        ])
    }

    /**
     * Initialize the launch configuration tab from the given ILaunchConfiguration
     */
    final override initializeFrom(ILaunchConfiguration launchConfiguration) {
        val chain = ProcessingChain.deserializeFrom(launchConfiguration) ?: new ProcessingChain
        setCurrentChain(chain)
        syncInput()
    }

    /**
     * Set the current chain's domain object
     */
    private def setCurrentChain(ProcessingChain chain) {
        removeCurrentConfigurationBindings()
        currentChain?.removePropertyChangeListener(this)

        originalChain = chain
        currentChain = chain.clone() as ProcessingChain

        currentChain.addPropertyChangeListener(this)
    }

    /**
     * Remove all Bean bindings of the tab from the data binding context
     */
    private def removeCurrentConfigurationBindings() {
        dataBindingContext.bindings.forEach[
            dispose
            dataBindingContext.removeBinding(it)
        ]
    }

    /**
     * Check if the given ILaunchConfiguration (which always is the current model processing chain
     * launch configuration) is valid
     */
    final override isValid(ILaunchConfiguration configuration) {
        return try {
            currentChain.validate(availableLaunchConfigurations)
            true
        } catch (IllegalArgumentException ex) {
            false
        }
    }

    /**
     * Return an error message when the current model processing configuration chain is invalid
     */
    final override getErrorMessage() {
        return try {
            currentChain.validate(availableLaunchConfigurations)
            null
        } catch (IllegalArgumentException ex) {
            ex.message
        }
    }

    /**
     * Check if the current model processing chain is dirty
     */
    final override isDirty() {
        return originalChain != currentChain
    }

    /**
     * Handle "Apply" click
     */
    final override performApply(ILaunchConfigurationWorkingCopy launchConfiguration) {
        ProcessingChain.setProcessingChainAsAttribute(launchConfiguration, currentChain)
    }

    /**
     * Handle the change of a domain object property's value
     */
    final override propertyChange(PropertyChangeEvent event) {
        updateLaunchConfigurationDialog()
    }

    /**
     * Get the name of the launch configuration tab
     */
    final override getName() {
        return "Chained LEMMA Model Processing Configurations"
    }

    /**
     * Get the image of the launch configuration tab
     */
    final override getImage() {
        return COMMON_LAUNCH_CONFIGURATION_TAB_IMAGE
    }

    /**
     * Set the defaults of the current launch configuration
     */
    final override setDefaults(ILaunchConfigurationWorkingCopy configuration) {
        // NOOP
    }

    /**
     * Dispose the tab
     */
    final override dispose() {
        dataBindingContext.dispose
        super.dispose
    }
}