package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator

import org.eclipse.swt.widgets.Combo
import org.eclipse.swt.widgets.Composite
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.jface.fieldassist.ControlDecoration
import org.eclipse.swt.SWT
import org.eclipse.jface.fieldassist.FieldDecorationRegistry
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*

/**
 * Wrapper for an SWT Combo that enables to select the intermediate representation of a model
 * imported by the source model of a given model processing configuration. The selected model is
 * accessible by an Argument instance whose type attribute is an
 * IntermediateModelOfImportWithAliasArgumentType.
 *
 * Note that we don't subclass Combo but provide this wrapper since subclassing Combo is effectively
 * prohibited (cf. Combo.checkSubclass()). While we could override checkSubclass() to enable
 * subclassing, we don't do so to be compatible with future SWT releases (cf. the Javadoc of
 * Widget.checkSubclass()).
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class IntermediateModelOfImportWithAliasArgumentTypeComboWrapper {
    val ProcessingConfiguration processingConfiguration
    @Accessors(PUBLIC_GETTER)
    val Argument argument
    @Accessors(PUBLIC_GETTER)
    val Combo combo

    /**
     * Constructor
     */
    new(Composite parent, int style, ProcessingConfiguration processingConfiguration,
        String parameterName) {
        combo = new Combo(parent, style)
        this.processingConfiguration = processingConfiguration
        this.argument = Argument.newArgument
            .singleValued
            .intermediateModelOfImportWithAlias("")
            .parameter(parameterName)
        addTransformableImportedModelsAsSelectionItems()
    }

    /**
     * Make all models which are imported by the source model and for which an intermediate
     * transformation exists selectable from the Combo by their import aliases
     */
    private def addTransformableImportedModelsAsSelectionItems() {
        try {
            val importAliases =
                parseTransformableImportedModelsOfSourceModelFile(processingConfiguration)
                .map[it.value.alias]
            combo.items = importAliases

            if (!importAliases.empty) {
                argument.value = importAliases.get(0)
                combo.text = argument.value
            }
        } catch (IllegalArgumentException ex) {
            val decoration = new ControlDecoration(combo, SWT.TOP.bitwiseOr(SWT.LEFT))
            decoration.descriptionText = ex.message
            decoration.image = FieldDecorationRegistry
                .^default
                .getFieldDecoration(FieldDecorationRegistry.DEC_ERROR)
                .image
            decoration.show()
        }
    }
}