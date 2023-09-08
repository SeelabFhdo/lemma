package de.fhdo.lemma.technology.mappingdsl.ui;

import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.technology.mapping.TechnologyMapping;
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
public class MappingDslReconcileStrategy extends XtextDocumentReconcileStrategy {
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
    if ((resource.getContents().isEmpty() || (!(resource.getContents().get(0) instanceof TechnologyMapping)))) {
      return;
    }
    EObject _get = resource.getContents().get(0);
    final TechnologyMapping mappingModel = ((TechnologyMapping) _get);
    final Consumer<Import> _function = (Import it) -> {
      try {
        final Resource importedResource = LemmaUtils.getResourceFromUri(mappingModel.eResource(), 
          it.getImportURI());
        importedResource.unload();
        importedResource.load(CollectionLiterals.<Object, Object>emptyMap());
        if (((!importedResource.getContents().isEmpty()) && 
          (importedResource.getContents().get(0) instanceof ServiceModel))) {
          EObject _get_1 = importedResource.getContents().get(0);
          this.reloadImportedDataModels(((ServiceModel) _get_1));
        }
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    };
    mappingModel.getImports().forEach(_function);
  }

  /**
   * Helper to reload data models being imported into a mapping model transitively via a service
   * model
   */
  private void reloadImportedDataModels(final ServiceModel serviceModel) {
    final Consumer<Import> _function = (Import it) -> {
      try {
        final Resource importedResource = LemmaUtils.getResourceFromUri(serviceModel.eResource(), 
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
    serviceModel.getImports().forEach(_function);
  }
}
