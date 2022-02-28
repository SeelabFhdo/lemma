package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types;

import com.google.common.base.Objects;
import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Type of arguments representing intermediate models of LEMMA models that are imported into other
 * LEMMA models with some given aliases.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class IntermediateModelOfImportWithAliasArgumentType extends AbstractArgumentType {
  public static final ArgumentTypeIdentifier IDENTIFIER = ArgumentTypeIdentifier.INTERMEDIATE_MODEL_WITH_IMPORT_ALIAS;
  
  /**
   * Constructor
   */
  public IntermediateModelOfImportWithAliasArgumentType() {
    super(IntermediateModelOfImportWithAliasArgumentType.IDENTIFIER, "Intermediate model of import with alias");
  }
  
  /**
   * Validate the type-specific argument value in its internal representation, i.e., the import
   * alias. Specifically, check that the import with the alias points to a LEMMA model for which
   * an intermediate transformation exists.
   */
  @Override
  public final void validateValueInInternalRepresentation(final ProcessingConfiguration processingConfiguration, final String alias) {
    final List<Pair<Class<? extends EObject>, Utils.ImportInfo>> imports = Utils.parseTransformableImportedModelsOfSourceModelFile(processingConfiguration);
    final Function1<Pair<Class<? extends EObject>, Utils.ImportInfo>, Boolean> _function = (Pair<Class<? extends EObject>, Utils.ImportInfo> it) -> {
      String _alias = it.getValue().getAlias();
      return Boolean.valueOf(Objects.equal(_alias, alias));
    };
    boolean _exists = IterableExtensions.<Pair<Class<? extends EObject>, Utils.ImportInfo>>exists(imports, _function);
    boolean _not = (!_exists);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Source model import with alias \"");
      _builder.append(alias);
      _builder.append("\" ");
      String _plus = (_builder.toString() + 
        "does not point to a transformable LEMMA model");
      throw new IllegalArgumentException(_plus);
    }
  }
}
