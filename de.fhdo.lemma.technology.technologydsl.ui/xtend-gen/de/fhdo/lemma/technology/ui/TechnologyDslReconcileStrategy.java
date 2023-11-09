package de.fhdo.lemma.technology.ui;

import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.technology.TechnologyImport;
import de.fhdo.lemma.utils.LemmaUtils;
import java.util.function.Consumer;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.reconciler.XtextDocumentReconcileStrategy;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * Reconcile strategy that is capable of reloading imported models of a currently constructed model.
 * As a result, the constructed model can immediately refer to elements that have just been added to
 * the imported models without the need to reload those models by closing/opening their associated
 * Eclipse editors.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class TechnologyDslReconcileStrategy extends XtextDocumentReconcileStrategy {
  /**
   * Post parse callback for Xtext resources which triggers model scoping and thus the resolution
   * of cross-referenced, possibly imported, model elements
   */
  @Override
  public void postParse(final XtextResource resource, final IProgressMonitor monitor) {
    this.reloadImportedModels(resource);
    super.postParse(resource, monitor);
  }

  /**
   * Helper to reload models being imported by a given Xtext resource
   */
  private void reloadImportedModels(final XtextResource resource) {
    if ((resource.getContents().isEmpty() || (!(resource.getContents().get(0) instanceof Technology)))) {
      return;
    }
    EObject _get = resource.getContents().get(0);
    final Technology technologyModel = ((Technology) _get);
    final Consumer<TechnologyImport> _function = (TechnologyImport it) -> {
      try {
        final Resource importedResource = LemmaUtils.getResourceFromUri(technologyModel.eResource(), 
          it.getImportURI());
        importedResource.unload();
        importedResource.load(CollectionLiterals.<Object, Object>emptyMap());
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    };
    technologyModel.getImports().forEach(_function);
  }
}
