package de.fhdo.lemma.data.validation;

import de.fhdo.lemma.data.ComplexTypeImport;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.utils.LemmaUtils;
import java.util.HashMap;
import org.eclipse.emf.ecore.EObject;

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
    boolean _containsKey = DataModelManager.loadedResources.containsKey(absoluteFilePath);
    if (_containsKey) {
      return DataModelManager.loadedResources.get(absoluteFilePath);
    }
    EObject _get = LemmaUtils.getResourceFromUri(complexTypeImport.eResource(), absoluteFilePath).getContents().get(0);
    final DataModel dataModel = ((DataModel) _get);
    DataModelManager.loadedResources.put(absoluteFilePath, dataModel);
    return dataModel;
  }
  
  /**
   * Remove all loaded DataModels from the cache
   */
  public static void clear() {
    DataModelManager.loadedResources.clear();
  }
}
