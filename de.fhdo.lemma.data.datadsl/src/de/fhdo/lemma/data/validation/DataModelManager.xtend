package de.fhdo.lemma.data.validation

import java.util.HashMap
import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.data.ComplexTypeImport
import static de.fhdo.lemma.utils.LemmaUtils.removeFileUri
import static de.fhdo.lemma.utils.LemmaUtils.absoluteFileUriFromResourceBase
import static de.fhdo.lemma.utils.LemmaUtils.getResourceFromUri

/**
 * This class acts as a DataModel cacher for checking cyclic imports
 *
 * @author <a href="mailto:dominik.pelkmann@fh-dortmund.de">Dominik Pelkmann</a>
 */
class DataModelManager {
    static val loadedResources = new HashMap<String, DataModel>

    /**
     * Returns a DataModel for a ComplexTypeImport and caches it
     */
    static def DataModel getDataModel(ComplexTypeImport complexTypeImport) {
        val absoluteFilePath = removeFileUri(absoluteFileUriFromResourceBase(
            complexTypeImport.importURI, complexTypeImport.eResource
        ))
        if (loadedResources.containsKey(absoluteFilePath))
            return loadedResources.get(absoluteFilePath)

        val dataModel = getResourceFromUri(complexTypeImport.eResource,
            absoluteFilePath).contents.get(0) as DataModel
        loadedResources.put(absoluteFilePath, dataModel)
        return dataModel
    }

    /**
     * Remove all loaded DataModels from the cache
     */
    static def clear() {
        loadedResources.clear
    }
}