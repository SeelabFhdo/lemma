package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator

import org.eclipse.swt.widgets.Shell
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IFile
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Combo
import org.eclipse.jface.databinding.swt.typed.WidgetProperties
import org.eclipse.core.databinding.beans.typed.BeanProperties
import org.eclipse.core.databinding.UpdateValueStrategy
import org.eclipse.core.databinding.conversion.IConverter
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.AbstractCodeGeneratorCompletionDialog
import org.eclipse.swt.graphics.Point

/**
 * Abstract superclass for completion dialogs for launch configuration templates targeting code
 * generation with the Java Base Generator.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class AbstractJavaBaseGeneratorCompletionDialog
    extends AbstractCodeGeneratorCompletionDialog {
    var Argument generationSerializerArgument
    protected var Combo generationSerializer

    /**
     * Constructor
     */
    new(Shell parentShell, IProject project, IFile file) {
        super(parentShell, project, file, "Java Base Generator", "JBG")
    }

    /**
     * Assign the Argument that identifies the code generation serializer
     */
    final protected def setGenerationSerializerArgument(Argument generationSerializerArgument) {
        this.generationSerializerArgument = generationSerializerArgument
        // Let argument participate in configuration validation in
        // AbstractTemplateCompletionDialog.propertyChange()
        this.generationSerializerArgument.addPropertyChangeListener(this)
    }

    /**
     * Create the dialog area
     */
    override createDialogArea(Composite parent) {
        val area = super.createDialogArea(parent)
        parent.shell.size = new Point(DEFAULT_WIDTH, 350)
        return area
    }

    /**
     * Add additional controls to the dialog
     */
    override insertAdditionalControlsAfterDefaults(Composite parent) {
        super.insertAdditionalControlsAfterDefaults(parent)
        parent.addGenerationSerializer
    }

    /**
     * Add combo box for code generation serializer selection
     */
    private def addGenerationSerializer(Composite parent) {
        new Label(parent, SWT.NULL).text = "Generation serializer:"

        // Add control
        generationSerializer = new Combo(parent, SWT.DROP_DOWN.bitwiseOr(SWT.READ_ONLY))
        val layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        layoutData.horizontalSpan = 2
        generationSerializer.layoutData = layoutData

        // Add items and select default item
        val generatorParameters = JavaBaseGeneratorParameters.instance()
        generationSerializer.items = generatorParameters.serializerLabels
        val defaultItem = generatorParameters.defaultSerializerLabel
        generationSerializer.select(generationSerializer.items.indexOf(defaultItem))

        // Establish property binding
        val target = WidgetProperties.comboSelection.observe(generationSerializer)
        val model = BeanProperties.value(Argument, "value").observe(generationSerializerArgument)

        val modelToTargetConverter = new UpdateValueStrategy<String, String>()
        modelToTargetConverter.converter = IConverter.create([
                generatorParameters.getSerializerLabel(it)
            ])

        val targetToModelConverter = new UpdateValueStrategy<String, String>()
        targetToModelConverter.converter = IConverter.create([
                generatorParameters.getSerializerParameter(it)
            ])

        dataBindingContext.bindValue(target, model, targetToModelConverter, modelToTargetConverter)
    }

    /**
     * Retrieve a printable representation of the source model's file type
     */
    final protected def printableModelFileType() {
        return switch(file.fileExtension) {
            case "services":
                "service"
            case "mapping":
                "mapping"
            default:
                throw new IllegalStateException("Unsupported model file extension " +
                    '''".«file.fileExtension»"''')
        }
    }

    /**
     * Close the dialog
     */
    override close() {
        generationSerializerArgument.removePropertyChangeListener(this)
        super.close()
    }
}