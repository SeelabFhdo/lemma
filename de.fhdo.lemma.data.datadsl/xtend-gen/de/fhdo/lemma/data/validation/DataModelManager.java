package de.fhdo.lemma.data.validation;

import de.fhdo.lemma.data.ComplexTypeImport;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.utils.LemmaUtils;
import java.util.HashMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * This class acts as a DataModel cacher for checking cyclic imports
 * 
 * @author <a href="mailto:dominik.pelkmann@fh-dortmund.de">Dominik Pelkmann</a>
 */
@SuppressWarnings("all")
public class DataModelManager {
  private static final HashMap<String, DataModel> loadedResources = new HashMap<String, DataModel>();

  /**
   * Returns a DataModel for a ComplexTypeImport and caches it
   */
  public static DataModel getDataModel(final ComplexTypeImport complexTypeImport) {
    final String absoluteFilePath = LemmaUtils.removeFileUri(
      LemmaUtils.absoluteFileUriFromResourceBase(
        complexTypeImport.getImportURI(), complexTypeImport.eResource()));
    DataModel dataModel = DataModelManager.loadedResources.get(absoluteFilePath);
    if ((dataModel == null)) {
      final Resource modelResource = LemmaUtils.getResourceFromUri(complexTypeImport.eResource(), absoluteFilePath);
      EList<EObject> _contents = null;
      if (modelResource!=null) {
        _contents=modelResource.getContents();
      }
      boolean _isEmpty = _contents.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        EObject _get = modelResource.getContents().get(0);
        dataModel = ((DataModel) _get);
        DataModelManager.loadedResources.put(absoluteFilePath, dataModel);
      }
    }
    return dataModel;
  }

  /**
   * Remove all loaded DataModels from the cache
   */
  public static void clear() {
    DataModelManager.loadedResources.clear();
  }
}
