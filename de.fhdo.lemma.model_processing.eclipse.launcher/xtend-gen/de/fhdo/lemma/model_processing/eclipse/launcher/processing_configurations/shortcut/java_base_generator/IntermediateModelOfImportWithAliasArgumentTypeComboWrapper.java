package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator;

import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;

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
@SuppressWarnings("all")
public final class IntermediateModelOfImportWithAliasArgumentTypeComboWrapper {
  private final ProcessingConfiguration processingConfiguration;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final Argument argument;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final Combo combo;
  
  /**
   * Constructor
   */
  public IntermediateModelOfImportWithAliasArgumentTypeComboWrapper(final Composite parent, final int style, final ProcessingConfiguration processingConfiguration, final String parameterName) {
    Combo _combo = new Combo(parent, style);
    this.combo = _combo;
    this.processingConfiguration = processingConfiguration;
    this.argument = Argument.newArgument().singleValued().intermediateModelOfImportWithAlias("").parameter(parameterName);
    this.addTransformableImportedModelsAsSelectionItems();
  }
  
  /**
   * Make all models which are imported by the source model and for which an intermediate
   * transformation exists selectable from the Combo by their import aliases
   */
  private void addTransformableImportedModelsAsSelectionItems() {
    try {
      final Function1<Pair<Class<? extends EObject>, Utils.ImportInfo>, String> _function = (Pair<Class<? extends EObject>, Utils.ImportInfo> it) -> {
        return it.getValue().getAlias();
      };
      final List<String> importAliases = ListExtensions.<Pair<Class<? extends EObject>, Utils.ImportInfo>, String>map(Utils.parseTransformableImportedModelsOfSourceModelFile(this.processingConfiguration), _function);
      this.combo.setItems(((String[])Conversions.unwrapArray(importAliases, String.class)));
      boolean _isEmpty = importAliases.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        this.argument.setValue(importAliases.get(0));
        this.combo.setText(this.argument.getValue());
      }
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        final IllegalArgumentException ex = (IllegalArgumentException)_t;
        final ControlDecoration decoration = new ControlDecoration(this.combo, (SWT.TOP | SWT.LEFT));
        decoration.setDescriptionText(ex.getMessage());
        decoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR).getImage());
        decoration.show();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Pure
  public Argument getArgument() {
    return this.argument;
  }
  
  @Pure
  public Combo getCombo() {
    return this.combo;
  }
}
